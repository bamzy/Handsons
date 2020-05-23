package com.drms.drms_drone.Communication.UsbSerial.usbserial;

public interface UsbSpiInterface {
  public static final int DIVIDER_128 = 128;
  
  public static final int DIVIDER_16 = 16;
  
  public static final int DIVIDER_2 = 2;
  
  public static final int DIVIDER_32 = 32;
  
  public static final int DIVIDER_4 = 4;
  
  public static final int DIVIDER_64 = 64;
  
  public static final int DIVIDER_8 = 8;
  
  void closeSPI();
  
  boolean connectSPI();
  
  int getClockDivider();
  
  int getSelectedSlave();
  
  void readMISO(int paramInt);
  
  void selectSlave(int paramInt);
  
  void setClock(int paramInt);
  
  void setMISOCallback(UsbMISOCallback paramUsbMISOCallback);
  
  void writeMOSI(byte[] paramArrayOfbyte);
  
  void writeRead(byte[] paramArrayOfbyte, int paramInt);
  
  public static interface UsbMISOCallback {
    int onReceivedData(byte[] param1ArrayOfbyte);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\UsbSpiInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */