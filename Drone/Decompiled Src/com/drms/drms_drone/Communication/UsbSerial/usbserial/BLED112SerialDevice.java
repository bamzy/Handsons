package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;

@Deprecated
public class BLED112SerialDevice extends UsbSerialDevice {
  private static final int BLED112_DEFAULT_CONTROL_LINE = 3;
  
  private static final byte[] BLED112_DEFAULT_LINE_CODING;
  
  private static final int BLED112_DISCONNECT_CONTROL_LINE = 2;
  
  private static final int BLED112_GET_LINE_CODING = 33;
  
  private static final int BLED112_REQTYPE_DEVICE2HOST = 161;
  
  private static final int BLED112_REQTYPE_HOST2DEVICE = 33;
  
  private static final int BLED112_SET_CONTROL_LINE_STATE = 34;
  
  private static final int BLED112_SET_LINE_CODING = 32;
  
  private static final String CLASS_ID = BLED112SerialDevice.class.getSimpleName();
  
  private UsbEndpoint inEndpoint;
  
  private UsbInterface mInterface;
  
  private UsbEndpoint outEndpoint;
  
  private UsbRequest requestIN;
  
  static {
    BLED112_DEFAULT_LINE_CODING = new byte[] { 0, 1, -62, 0, 0, 0, 8 };
  }
  
  @Deprecated
  public BLED112SerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    super(paramUsbDevice, paramUsbDeviceConnection);
    this.mInterface = paramUsbDevice.getInterface(1);
  }
  
  private byte[] getLineCoding() {
    byte[] arrayOfByte = new byte[7];
    int i = this.connection.controlTransfer(161, 33, 0, 0, arrayOfByte, arrayOfByte.length, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(i));
    return arrayOfByte;
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
    setControlCommand(34, 2, (byte[])null);
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
    restartWorkingThread();
    restartWriteThread();
    if (this.connection.claimInterface(this.mInterface, true)) {
      Log.i(CLASS_ID, "Interface succesfully claimed");
    } else {
      Log.i(CLASS_ID, "Interface could not be claimed");
    } 
    int j = this.mInterface.getEndpointCount();
    for (int i = 0; i <= j - 1; i++) {
      UsbEndpoint usbEndpoint = this.mInterface.getEndpoint(i);
      if (usbEndpoint.getType() == 2 && usbEndpoint.getDirection() == 128) {
        this.inEndpoint = usbEndpoint;
      } else {
        this.outEndpoint = usbEndpoint;
      } 
    } 
    setControlCommand(32, 0, BLED112_DEFAULT_LINE_CODING);
    setControlCommand(34, 3, (byte[])null);
    this.requestIN = new UsbRequest();
    this.requestIN.initialize(this.connection, this.inEndpoint);
    setThreadsParams(this.requestIN, this.outEndpoint);
    return true;
  }
  
  public void setBaudRate(int paramInt) {
    byte[] arrayOfByte = getLineCoding();
    arrayOfByte[3] = (byte)(paramInt & 0xFF);
    arrayOfByte[2] = (byte)(paramInt >> 8 & 0xFF);
    arrayOfByte[1] = (byte)(paramInt >> 16 & 0xFF);
    arrayOfByte[0] = (byte)(paramInt >> 24 & 0xFF);
    setControlCommand(32, 0, arrayOfByte);
  }
  
  public void setDTR(boolean paramBoolean) {}
  
  public void setDataBits(int paramInt) {
    byte[] arrayOfByte = getLineCoding();
    switch (paramInt) {
      default:
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 5:
        arrayOfByte[6] = 5;
      case 6:
        arrayOfByte[6] = 6;
      case 7:
        arrayOfByte[6] = 7;
      case 8:
        break;
    } 
    arrayOfByte[6] = 8;
  }
  
  public void setFlowControl(int paramInt) {}
  
  public void setParity(int paramInt) {
    byte[] arrayOfByte = getLineCoding();
    switch (paramInt) {
      default:
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 0:
        arrayOfByte[5] = 0;
      case 1:
        arrayOfByte[5] = 1;
      case 2:
        arrayOfByte[5] = 2;
      case 3:
        arrayOfByte[5] = 3;
      case 4:
        break;
    } 
    arrayOfByte[5] = 4;
  }
  
  public void setRTS(boolean paramBoolean) {}
  
  public void setStopBits(int paramInt) {
    byte[] arrayOfByte = getLineCoding();
    switch (paramInt) {
      default:
        setControlCommand(32, 0, arrayOfByte);
        return;
      case 1:
        arrayOfByte[4] = 0;
      case 3:
        arrayOfByte[4] = 1;
      case 2:
        break;
    } 
    arrayOfByte[4] = 2;
  }
  
  public void syncClose() {}
  
  public boolean syncOpen() {
    return false;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\BLED112SerialDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */