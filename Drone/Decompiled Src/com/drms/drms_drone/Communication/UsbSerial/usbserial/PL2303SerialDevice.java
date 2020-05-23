package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;

public class PL2303SerialDevice extends UsbSerialDevice {
  private static final String CLASS_ID = PL2303SerialDevice.class.getSimpleName();
  
  private static final int PL2303_REQTYPE_DEVICE2HOST_VENDOR = 192;
  
  private static final int PL2303_REQTYPE_HOST2DEVICE = 33;
  
  private static final int PL2303_REQTYPE_HOST2DEVICE_VENDOR = 64;
  
  private static final int PL2303_SET_CONTROL_REQUEST = 34;
  
  private static final int PL2303_SET_LINE_CODING = 32;
  
  private static final int PL2303_VENDOR_WRITE_REQUEST = 1;
  
  private byte[] defaultSetLine = new byte[] { Byte.MIN_VALUE, 37, 0, 0, 0, 0, 8 };
  
  private UsbEndpoint inEndpoint;
  
  private UsbInterface mInterface;
  
  private UsbEndpoint outEndpoint;
  
  private UsbRequest requestIN;
  
  public PL2303SerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    this(paramUsbDevice, paramUsbDeviceConnection, -1);
  }
  
  public PL2303SerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection, int paramInt) {
    super(paramUsbDevice, paramUsbDeviceConnection);
    if (paramInt > 1)
      throw new IllegalArgumentException("Multi-interface PL2303 devices not supported!"); 
    if (paramInt < 0)
      paramInt = 0; 
    this.mInterface = paramUsbDevice.getInterface(paramInt);
  }
  
  private boolean openPL2303() {
    if (this.connection.claimInterface(this.mInterface, true)) {
      Log.i(CLASS_ID, "Interface succesfully claimed");
      int j = this.mInterface.getEndpointCount();
      for (int i = 0; i <= j - 1; i++) {
        UsbEndpoint usbEndpoint = this.mInterface.getEndpoint(i);
        if (usbEndpoint.getType() == 2 && usbEndpoint.getDirection() == 128) {
          this.inEndpoint = usbEndpoint;
        } else if (usbEndpoint.getType() == 2 && usbEndpoint.getDirection() == 0) {
          this.outEndpoint = usbEndpoint;
        } 
      } 
    } else {
      Log.i(CLASS_ID, "Interface could not be claimed");
      return false;
    } 
    byte[] arrayOfByte = new byte[1];
    return (setControlCommand(192, 1, 33924, 0, arrayOfByte) < 0) ? false : ((setControlCommand(64, 1, 1028, 0, (byte[])null) < 0) ? false : ((setControlCommand(192, 1, 33924, 0, arrayOfByte) < 0) ? false : ((setControlCommand(192, 1, 33667, 0, arrayOfByte) < 0) ? false : ((setControlCommand(192, 1, 33924, 0, arrayOfByte) < 0) ? false : ((setControlCommand(64, 1, 1028, 1, (byte[])null) < 0) ? false : ((setControlCommand(192, 1, 33924, 0, arrayOfByte) < 0) ? false : ((setControlCommand(192, 1, 33667, 0, arrayOfByte) < 0) ? false : ((setControlCommand(64, 1, 0, 1, (byte[])null) < 0) ? false : ((setControlCommand(64, 1, 1, 0, (byte[])null) < 0) ? false : ((setControlCommand(64, 1, 2, 68, (byte[])null) < 0) ? false : ((setControlCommand(33, 34, 3, 0, (byte[])null) < 0) ? false : ((setControlCommand(33, 32, 0, 0, this.defaultSetLine) < 0) ? false : (!(setControlCommand(64, 1, 1285, 4881, (byte[])null) < 0))))))))))))));
  }
  
  private int setControlCommand(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfbyte) {
    int i = 0;
    if (paramArrayOfbyte != null)
      i = paramArrayOfbyte.length; 
    paramInt1 = this.connection.controlTransfer(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfbyte, i, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(paramInt1));
    return paramInt1;
  }
  
  public void close() {
    killWorkingThread();
    killWriteThread();
    this.connection.releaseInterface(this.mInterface);
  }
  
  public void getBreak(UsbSerialInterface.UsbBreakCallback paramUsbBreakCallback) {}
  
  public void getCTS(UsbSerialInterface.UsbCTSCallback paramUsbCTSCallback) {}
  
  public void getDSR(UsbSerialInterface.UsbDSRCallback paramUsbDSRCallback) {}
  
  public void getFrame(UsbSerialInterface.UsbFrameCallback paramUsbFrameCallback) {}
  
  public void getOverrun(UsbSerialInterface.UsbOverrunCallback paramUsbOverrunCallback) {}
  
  public void getParity(UsbSerialInterface.UsbParityCallback paramUsbParityCallback) {}
  
  public boolean open() {
    if (openPL2303()) {
      this.requestIN = new UsbRequest();
      this.requestIN.initialize(this.connection, this.inEndpoint);
      restartWorkingThread();
      restartWriteThread();
      setThreadsParams(this.requestIN, this.outEndpoint);
      this.asyncMode = true;
      return true;
    } 
    return false;
  }
  
  public void setBaudRate(int paramInt) {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = (byte)(paramInt & 0xFF);
    arrayOfByte[1] = (byte)(paramInt >> 8 & 0xFF);
    arrayOfByte[2] = (byte)(paramInt >> 16 & 0xFF);
    arrayOfByte[3] = (byte)(paramInt >> 24 & 0xFF);
    if (arrayOfByte[0] != this.defaultSetLine[0] || arrayOfByte[1] != this.defaultSetLine[1] || arrayOfByte[2] != this.defaultSetLine[2] || arrayOfByte[3] != this.defaultSetLine[3]) {
      this.defaultSetLine[0] = arrayOfByte[0];
      this.defaultSetLine[1] = arrayOfByte[1];
      this.defaultSetLine[2] = arrayOfByte[2];
      this.defaultSetLine[3] = arrayOfByte[3];
      setControlCommand(33, 32, 0, 0, this.defaultSetLine);
    } 
  }
  
  public void setDTR(boolean paramBoolean) {}
  
  public void setDataBits(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 5:
        if (this.defaultSetLine[6] != 5) {
          this.defaultSetLine[6] = 5;
          setControlCommand(33, 32, 0, 0, this.defaultSetLine);
          return;
        } 
      case 6:
        if (this.defaultSetLine[6] != 6) {
          this.defaultSetLine[6] = 6;
          setControlCommand(33, 32, 0, 0, this.defaultSetLine);
          return;
        } 
      case 7:
        if (this.defaultSetLine[6] != 7) {
          this.defaultSetLine[6] = 7;
          setControlCommand(33, 32, 0, 0, this.defaultSetLine);
          return;
        } 
      case 8:
        break;
    } 
    if (this.defaultSetLine[6] != 8) {
      this.defaultSetLine[6] = 8;
      setControlCommand(33, 32, 0, 0, this.defaultSetLine);
      return;
    } 
  }
  
  public void setFlowControl(int paramInt) {}
  
  public void setParity(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 0:
        if (this.defaultSetLine[5] != 0) {
          this.defaultSetLine[5] = 0;
          setControlCommand(33, 32, 0, 0, this.defaultSetLine);
          return;
        } 
      case 1:
        if (this.defaultSetLine[5] != 1) {
          this.defaultSetLine[5] = 1;
          setControlCommand(33, 32, 0, 0, this.defaultSetLine);
          return;
        } 
      case 2:
        if (this.defaultSetLine[5] != 2) {
          this.defaultSetLine[5] = 2;
          setControlCommand(33, 32, 0, 0, this.defaultSetLine);
          return;
        } 
      case 3:
        if (this.defaultSetLine[5] != 3) {
          this.defaultSetLine[5] = 3;
          setControlCommand(33, 32, 0, 0, this.defaultSetLine);
          return;
        } 
      case 4:
        break;
    } 
    if (this.defaultSetLine[5] != 4) {
      this.defaultSetLine[5] = 4;
      setControlCommand(33, 32, 0, 0, this.defaultSetLine);
      return;
    } 
  }
  
  public void setRTS(boolean paramBoolean) {}
  
  public void setStopBits(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        if (this.defaultSetLine[4] != 0) {
          this.defaultSetLine[4] = 0;
          setControlCommand(33, 32, 0, 0, this.defaultSetLine);
          return;
        } 
      case 3:
        if (this.defaultSetLine[4] != 1) {
          this.defaultSetLine[4] = 1;
          setControlCommand(33, 32, 0, 0, this.defaultSetLine);
          return;
        } 
      case 2:
        break;
    } 
    if (this.defaultSetLine[4] != 2) {
      this.defaultSetLine[4] = 2;
      setControlCommand(33, 32, 0, 0, this.defaultSetLine);
      return;
    } 
  }
  
  public void syncClose() {
    this.connection.releaseInterface(this.mInterface);
  }
  
  public boolean syncOpen() {
    boolean bool = false;
    if (openPL2303()) {
      setSyncParams(this.inEndpoint, this.outEndpoint);
      this.asyncMode = false;
      bool = true;
    } 
    return bool;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\PL2303SerialDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */