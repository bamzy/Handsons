package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;

public class CP2130SpiDevice extends UsbSpiDevice {
  private static final int BM_REQ_DEVICE_2_HOST = 192;
  
  private static final int BM_REQ_HOST_2_DEVICE = 64;
  
  private static String CLASS_ID = CP2130SpiDevice.class.getSimpleName();
  
  public static final int CLOCK_12MHz = 0;
  
  public static final int CLOCK_187_5KHz = 6;
  
  public static final int CLOCK_1_5MHz = 3;
  
  public static final int CLOCK_375KHz = 5;
  
  public static final int CLOCK_3MHz = 2;
  
  public static final int CLOCK_6MHz = 1;
  
  public static final int CLOCK_750KHz = 4;
  
  public static final int CLOCK_93_75KHz = 7;
  
  private static final int GET_SPI_WORD = 48;
  
  private static final int SET_GPIO_CHIP_SELECT = 37;
  
  private static final int SET_SPI_WORD = 49;
  
  private int currentChannel;
  
  private UsbEndpoint inEndpoint;
  
  private UsbInterface mInterface;
  
  private UsbEndpoint outEndpoint;
  
  private UsbRequest requestIN;
  
  public CP2130SpiDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    this(paramUsbDevice, paramUsbDeviceConnection, -1);
  }
  
  public CP2130SpiDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection, int paramInt) {
    super(paramUsbDevice, paramUsbDeviceConnection);
    if (paramInt < 0)
      paramInt = 0; 
    this.mInterface = paramUsbDevice.getInterface(paramInt);
    this.currentChannel = 0;
  }
  
  private byte[] getSpiWord() {
    return setControlCommandIn(48, 0, 0, 2);
  }
  
  private boolean openCP2130() {
    boolean bool = true;
    if (this.connection.claimInterface(this.mInterface, true)) {
      Log.i(CLASS_ID, "Interface succesfully claimed");
      int j = this.mInterface.getEndpointCount();
      int i = 0;
      while (true) {
        boolean bool1 = bool;
        if (i <= j - 1) {
          UsbEndpoint usbEndpoint = this.mInterface.getEndpoint(i);
          if (usbEndpoint.getType() == 2 && usbEndpoint.getDirection() == 128) {
            this.inEndpoint = usbEndpoint;
          } else {
            this.outEndpoint = usbEndpoint;
          } 
          i++;
          continue;
        } 
        return bool1;
      } 
    } 
    Log.i(CLASS_ID, "Interface could not be claimed");
    return false;
  }
  
  private byte[] setControlCommandIn(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte[] arrayOfByte = new byte[paramInt4];
    paramInt1 = this.connection.controlTransfer(192, paramInt1, paramInt2, this.mInterface.getId(), arrayOfByte, paramInt4, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(paramInt1));
    return arrayOfByte;
  }
  
  private int setControlCommandOut(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfbyte) {
    paramInt3 = 0;
    if (paramArrayOfbyte != null)
      paramInt3 = paramArrayOfbyte.length; 
    paramInt1 = this.connection.controlTransfer(64, paramInt1, paramInt2, this.mInterface.getId(), paramArrayOfbyte, paramInt3, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(paramInt1));
    return paramInt1;
  }
  
  private void setGpioChipSelect(int paramInt, boolean paramBoolean) {
    if (paramInt >= 0 && paramInt <= 10) {
      boolean bool;
      byte b = (byte)paramInt;
      if (paramBoolean) {
        bool = true;
      } else {
        bool = true;
      } 
      if (setControlCommandOut(37, 0, 0, new byte[] { b, bool }) != -1)
        this.currentChannel = paramInt; 
      return;
    } 
    Log.i(CLASS_ID, "Channel not valid");
  }
  
  private void setSetSpiWord(int paramInt1, int paramInt2) {
    byte[] arrayOfByte = new byte[2];
    if (paramInt1 >= 0 && paramInt1 <= 10) {
      arrayOfByte[0] = (byte)paramInt1;
      arrayOfByte[1] = (byte)paramInt2;
      arrayOfByte[1] = (byte)(arrayOfByte[1] | 0x8);
      setControlCommandOut(49, 0, 0, arrayOfByte);
      return;
    } 
    Log.i(CLASS_ID, "Channel not valid");
  }
  
  public void closeSPI() {
    killWorkingThread();
    killWriteThread();
    this.connection.releaseInterface(this.mInterface);
  }
  
  public boolean connectSPI() {
    if (!openCP2130())
      return false; 
    restartWorkingThread();
    restartWriteThread();
    setThreadsParams(this.inEndpoint, this.outEndpoint);
    return true;
  }
  
  public int getClockDivider() {
    return getSpiWord()[this.currentChannel] & 0x7;
  }
  
  public int getSelectedSlave() {
    return this.currentChannel;
  }
  
  public void readMISO(int paramInt) {
    byte b1 = (byte)(paramInt & 0xFF);
    byte b2 = (byte)(paramInt >> 8 & 0xFF);
    byte b3 = (byte)(paramInt >> 16 & 0xFF);
    byte b4 = (byte)(paramInt >> 24 & 0xFF);
    this.serialBuffer.putWriteBuffer(new byte[] { 0, 0, 0, Byte.MIN_VALUE, b1, b2, b3, b4 });
  }
  
  public void selectSlave(int paramInt) {
    if (paramInt > 10 || paramInt < 0) {
      Log.i(CLASS_ID, "selected slave must be in 0-10 range");
      return;
    } 
    setGpioChipSelect(paramInt, true);
  }
  
  public void setClock(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 0:
        setSetSpiWord(this.currentChannel, 0);
        return;
      case 1:
        setSetSpiWord(this.currentChannel, 1);
        return;
      case 2:
        setSetSpiWord(this.currentChannel, 2);
        return;
      case 3:
        setSetSpiWord(this.currentChannel, 3);
        return;
      case 4:
        setSetSpiWord(this.currentChannel, 4);
        return;
      case 5:
        setSetSpiWord(this.currentChannel, 5);
        return;
      case 6:
        setSetSpiWord(this.currentChannel, 6);
        return;
      case 7:
        break;
    } 
    setSetSpiWord(this.currentChannel, 7);
  }
  
  public void writeMOSI(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length + 8];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    arrayOfByte[2] = 1;
    arrayOfByte[3] = Byte.MIN_VALUE;
    arrayOfByte[4] = (byte)(paramArrayOfbyte.length & 0xFF);
    arrayOfByte[5] = (byte)(paramArrayOfbyte.length >> 8 & 0xFF);
    arrayOfByte[6] = (byte)(paramArrayOfbyte.length >> 16 & 0xFF);
    arrayOfByte[7] = (byte)(paramArrayOfbyte.length >> 24 & 0xFF);
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 8, paramArrayOfbyte.length);
    this.serialBuffer.putWriteBuffer(arrayOfByte);
  }
  
  public void writeRead(byte[] paramArrayOfbyte, int paramInt) {
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length + 8];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    arrayOfByte[2] = 2;
    arrayOfByte[3] = Byte.MIN_VALUE;
    arrayOfByte[4] = (byte)(paramInt & 0xFF);
    arrayOfByte[5] = (byte)(paramInt >> 8 & 0xFF);
    arrayOfByte[6] = (byte)(paramInt >> 16 & 0xFF);
    arrayOfByte[7] = (byte)(paramInt >> 24 & 0xFF);
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 8, paramArrayOfbyte.length);
    this.serialBuffer.putWriteBuffer(arrayOfByte);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\CP2130SpiDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */