package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;

@Deprecated
public class XdcVcpSerialDevice extends UsbSerialDevice {
  private static final String CLASS_ID = XdcVcpSerialDevice.class.getSimpleName();
  
  private static final int DEFAULT_BAUDRATE = 115200;
  
  private static final int XDCVCP_GET_LINE_CTL = 4;
  
  private static final int XDCVCP_IFC_ENABLE = 0;
  
  private static final int XDCVCP_LINE_CTL_DEFAULT = 2048;
  
  private static final int XDCVCP_MHS_ALL = 17;
  
  private static final int XDCVCP_MHS_DEFAULT = 0;
  
  private static final int XDCVCP_MHS_DTR = 1;
  
  private static final int XDCVCP_MHS_RTS = 16;
  
  private static final int XDCVCP_REQTYPE_DEVICE2HOST = 193;
  
  private static final int XDCVCP_REQTYPE_HOST2DEVICE = 65;
  
  private static final int XDCVCP_SET_BAUDDIV = 1;
  
  private static final int XDCVCP_SET_BAUDRATE = 30;
  
  private static final int XDCVCP_SET_CHARS = 25;
  
  private static final int XDCVCP_SET_FLOW = 19;
  
  private static final int XDCVCP_SET_LINE_CTL = 3;
  
  private static final int XDCVCP_SET_MHS = 7;
  
  private static final int XDCVCP_SET_XOFF = 10;
  
  private static final int XDCVCP_SET_XON = 9;
  
  private static final int XDCVCP_UART_DISABLE = 0;
  
  private static final int XDCVCP_UART_ENABLE = 1;
  
  private static final int XDCVCP_XOFF = 0;
  
  private static final int XDCVCP_XON = 0;
  
  private UsbEndpoint inEndpoint;
  
  private UsbInterface mInterface;
  
  private UsbEndpoint outEndpoint;
  
  private UsbRequest requestIN;
  
  public XdcVcpSerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    this(paramUsbDevice, paramUsbDeviceConnection, -1);
  }
  
  public XdcVcpSerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection, int paramInt) {
    super(paramUsbDevice, paramUsbDeviceConnection);
    if (paramInt < 0)
      paramInt = 0; 
    this.mInterface = paramUsbDevice.getInterface(paramInt);
  }
  
  private byte[] getCTL() {
    byte[] arrayOfByte = new byte[2];
    int i = this.connection.controlTransfer(193, 4, 0, this.mInterface.getId(), arrayOfByte, arrayOfByte.length, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(i));
    return arrayOfByte;
  }
  
  private int setControlCommand(int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
    int i = 0;
    if (paramArrayOfbyte != null)
      i = paramArrayOfbyte.length; 
    paramInt1 = this.connection.controlTransfer(65, paramInt1, paramInt2, this.mInterface.getId(), paramArrayOfbyte, i, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(paramInt1));
    return paramInt1;
  }
  
  public void close() {
    setControlCommand(0, 0, (byte[])null);
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
      int j = this.mInterface.getEndpointCount();
      for (int i = 0; i <= j - 1; i++) {
        UsbEndpoint usbEndpoint = this.mInterface.getEndpoint(i);
        if (usbEndpoint.getType() == 2 && usbEndpoint.getDirection() == 128) {
          this.inEndpoint = usbEndpoint;
        } else {
          this.outEndpoint = usbEndpoint;
        } 
      } 
    } else {
      Log.i(CLASS_ID, "Interface could not be claimed");
      return false;
    } 
    if (setControlCommand(0, 1, (byte[])null) >= 0) {
      setBaudRate(115200);
      if (setControlCommand(3, 2048, (byte[])null) >= 0) {
        setFlowControl(0);
        if (setControlCommand(7, 0, (byte[])null) >= 0) {
          this.requestIN = new UsbRequest();
          this.requestIN.initialize(this.connection, this.inEndpoint);
          setThreadsParams(this.requestIN, this.outEndpoint);
          return true;
        } 
      } 
    } 
    return false;
  }
  
  public void setBaudRate(int paramInt) {
    setControlCommand(30, 0, new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 24 & 0xFF) });
  }
  
  public void setDTR(boolean paramBoolean) {}
  
  public void setDataBits(int paramInt) {
    byte[] arrayOfByte = getCTL();
    switch (paramInt) {
      default:
        return;
      case 5:
        arrayOfByte[1] = 5;
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 6:
        arrayOfByte[1] = 6;
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 7:
        arrayOfByte[1] = 7;
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 8:
        break;
    } 
    arrayOfByte[1] = 8;
    setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
  }
  
  public void setFlowControl(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 0:
        setControlCommand(19, 0, new byte[] { 
              1, 0, 0, 0, 64, 0, 0, 0, 0, Byte.MIN_VALUE, 
              0, 0, 0, 32, 0, 0 });
        return;
      case 1:
        setControlCommand(19, 0, new byte[] { 
              9, 0, 0, 0, Byte.MIN_VALUE, 0, 0, 0, 0, Byte.MIN_VALUE, 
              0, 0, 0, 32, 0, 0 });
        return;
      case 2:
        setControlCommand(19, 0, new byte[] { 
              18, 0, 0, 0, 64, 0, 0, 0, 0, Byte.MIN_VALUE, 
              0, 0, 0, 32, 0, 0 });
        return;
      case 3:
        break;
    } 
    setControlCommand(25, 0, new byte[] { 0, 0, 0, 0, 17, 19 });
    setControlCommand(19, 0, new byte[] { 
          1, 0, 0, 0, 67, 0, 0, 0, 0, Byte.MIN_VALUE, 
          0, 0, 0, 32, 0, 0 });
  }
  
  public void setParity(int paramInt) {
    byte[] arrayOfByte = getCTL();
    switch (paramInt) {
      default:
        return;
      case 0:
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFEF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFDF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFBF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFF7F);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 1:
        arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x10);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFDF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFBF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFF7F);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 2:
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFEF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x20);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFBF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFF7F);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 3:
        arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x10);
        arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x20);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFBF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFF7F);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 4:
        break;
    } 
    arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFEF);
    arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFDF);
    arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x40);
    arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFF7F);
    setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
  }
  
  public void setRTS(boolean paramBoolean) {}
  
  public void setStopBits(int paramInt) {
    byte[] arrayOfByte = getCTL();
    switch (paramInt) {
      default:
        return;
      case 1:
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFFE);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFFD);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 3:
        arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x1);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFFD);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 2:
        break;
    } 
    arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFFE);
    arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x2);
    setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
  }
  
  public void syncClose() {}
  
  public boolean syncOpen() {
    return false;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\XdcVcpSerialDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */