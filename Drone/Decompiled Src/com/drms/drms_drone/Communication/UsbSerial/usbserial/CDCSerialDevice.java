package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;

public class CDCSerialDevice extends UsbSerialDevice {
  private static final int CDC_CONTROL_LINE_OFF = 0;
  
  private static final int CDC_CONTROL_LINE_ON = 3;
  
  private static final byte[] CDC_DEFAULT_LINE_CODING;
  
  private static final int CDC_GET_LINE_CODING = 33;
  
  private static final int CDC_REQTYPE_DEVICE2HOST = 161;
  
  private static final int CDC_REQTYPE_HOST2DEVICE = 33;
  
  private static final int CDC_SET_CONTROL_LINE_STATE = 34;
  
  private static final int CDC_SET_LINE_CODING = 32;
  
  private static final String CLASS_ID = CDCSerialDevice.class.getSimpleName();
  
  private UsbEndpoint inEndpoint;
  
  private UsbInterface mInterface;
  
  private UsbEndpoint outEndpoint;
  
  private UsbRequest requestIN;
  
  static {
    CDC_DEFAULT_LINE_CODING = new byte[] { 0, -62, 1, 0, 0, 0, 8 };
  }
  
  public CDCSerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    this(paramUsbDevice, paramUsbDeviceConnection, -1);
  }
  
  public CDCSerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection, int paramInt) {
    super(paramUsbDevice, paramUsbDeviceConnection);
    if (paramInt < 0)
      paramInt = findFirstCDC(paramUsbDevice); 
    this.mInterface = paramUsbDevice.getInterface(paramInt);
  }
  
  private static int findFirstCDC(UsbDevice paramUsbDevice) {
    int j = paramUsbDevice.getInterfaceCount();
    for (int i = 0; i < j; i++) {
      if (paramUsbDevice.getInterface(i).getInterfaceClass() == 10)
        return i; 
    } 
    Log.i(CLASS_ID, "There is no CDC class interface");
    return -1;
  }
  
  private byte[] getLineCoding() {
    byte[] arrayOfByte = new byte[7];
    int i = this.connection.controlTransfer(161, 33, 0, 0, arrayOfByte, arrayOfByte.length, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(i));
    return arrayOfByte;
  }
  
  private boolean openCDC() {
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
    if (this.outEndpoint == null || this.inEndpoint == null) {
      Log.i(CLASS_ID, "Interface does not have an IN or OUT interface");
      return false;
    } 
    setControlCommand(32, 0, CDC_DEFAULT_LINE_CODING);
    setControlCommand(34, 3, (byte[])null);
    return true;
  }
  
  private int setControlCommand(int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
    int i = 0;
    if (paramArrayOfbyte != null)
      i = paramArrayOfbyte.length; 
    paramInt1 = this.connection.controlTransfer(33, paramInt1, paramInt2, 0, paramArrayOfbyte, i, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(paramInt1));
    return paramInt1;
  }
  
  public void close() {
    setControlCommand(34, 0, (byte[])null);
    killWorkingThread();
    killWriteThread();
    this.connection.releaseInterface(this.mInterface);
    this.connection.close();
  }
  
  public void getBreak(UsbSerialInterface.UsbBreakCallback paramUsbBreakCallback) {}
  
  public void getCTS(UsbSerialInterface.UsbCTSCallback paramUsbCTSCallback) {}
  
  public void getDSR(UsbSerialInterface.UsbDSRCallback paramUsbDSRCallback) {}
  
  public void getFrame(UsbSerialInterface.UsbFrameCallback paramUsbFrameCallback) {}
  
  public void getOverrun(UsbSerialInterface.UsbOverrunCallback paramUsbOverrunCallback) {}
  
  public void getParity(UsbSerialInterface.UsbParityCallback paramUsbParityCallback) {}
  
  public boolean open() {
    if (openCDC()) {
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
    byte[] arrayOfByte = getLineCoding();
    arrayOfByte[0] = (byte)(paramInt & 0xFF);
    arrayOfByte[1] = (byte)(paramInt >> 8 & 0xFF);
    arrayOfByte[2] = (byte)(paramInt >> 16 & 0xFF);
    arrayOfByte[3] = (byte)(paramInt >> 24 & 0xFF);
    setControlCommand(32, 0, arrayOfByte);
  }
  
  public void setDTR(boolean paramBoolean) {}
  
  public void setDataBits(int paramInt) {
    byte[] arrayOfByte = getLineCoding();
    switch (paramInt) {
      default:
        return;
      case 5:
        arrayOfByte[6] = 5;
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 6:
        arrayOfByte[6] = 6;
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 7:
        arrayOfByte[6] = 7;
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 8:
        break;
    } 
    arrayOfByte[6] = 8;
    setControlCommand(32, 0, arrayOfByte);
  }
  
  public void setFlowControl(int paramInt) {}
  
  public void setParity(int paramInt) {
    byte[] arrayOfByte = getLineCoding();
    switch (paramInt) {
      default:
        return;
      case 0:
        arrayOfByte[5] = 0;
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 1:
        arrayOfByte[5] = 1;
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 2:
        arrayOfByte[5] = 2;
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 3:
        arrayOfByte[5] = 3;
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 4:
        break;
    } 
    arrayOfByte[5] = 4;
    setControlCommand(32, 0, arrayOfByte);
  }
  
  public void setRTS(boolean paramBoolean) {}
  
  public void setStopBits(int paramInt) {
    byte[] arrayOfByte = getLineCoding();
    switch (paramInt) {
      default:
        return;
      case 1:
        arrayOfByte[4] = 0;
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 3:
        arrayOfByte[4] = 1;
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 2:
        break;
    } 
    arrayOfByte[4] = 2;
    setControlCommand(32, 0, arrayOfByte);
  }
  
  public void syncClose() {
    setControlCommand(34, 0, (byte[])null);
    this.connection.releaseInterface(this.mInterface);
    this.connection.close();
  }
  
  public boolean syncOpen() {
    boolean bool = false;
    if (openCDC()) {
      setSyncParams(this.inEndpoint, this.outEndpoint);
      this.asyncMode = false;
      bool = true;
    } 
    return bool;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\CDCSerialDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */