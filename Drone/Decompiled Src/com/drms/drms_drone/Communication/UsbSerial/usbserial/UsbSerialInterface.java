package com.drms.drms_drone.Communication.UsbSerial.usbserial;

public interface UsbSerialInterface {
  public static final int DATA_BITS_5 = 5;
  
  public static final int DATA_BITS_6 = 6;
  
  public static final int DATA_BITS_7 = 7;
  
  public static final int DATA_BITS_8 = 8;
  
  public static final int FLOW_CONTROL_DSR_DTR = 2;
  
  public static final int FLOW_CONTROL_OFF = 0;
  
  public static final int FLOW_CONTROL_RTS_CTS = 1;
  
  public static final int FLOW_CONTROL_XON_XOFF = 3;
  
  public static final int PARITY_EVEN = 2;
  
  public static final int PARITY_MARK = 3;
  
  public static final int PARITY_NONE = 0;
  
  public static final int PARITY_ODD = 1;
  
  public static final int PARITY_SPACE = 4;
  
  public static final int STOP_BITS_1 = 1;
  
  public static final int STOP_BITS_15 = 3;
  
  public static final int STOP_BITS_2 = 2;
  
  void close();
  
  void getBreak(UsbBreakCallback paramUsbBreakCallback);
  
  void getCTS(UsbCTSCallback paramUsbCTSCallback);
  
  void getDSR(UsbDSRCallback paramUsbDSRCallback);
  
  void getFrame(UsbFrameCallback paramUsbFrameCallback);
  
  void getOverrun(UsbOverrunCallback paramUsbOverrunCallback);
  
  void getParity(UsbParityCallback paramUsbParityCallback);
  
  boolean open();
  
  int read(UsbReadCallback paramUsbReadCallback);
  
  void setBaudRate(int paramInt);
  
  void setDTR(boolean paramBoolean);
  
  void setDataBits(int paramInt);
  
  void setFlowControl(int paramInt);
  
  void setParity(int paramInt);
  
  void setRTS(boolean paramBoolean);
  
  void setStopBits(int paramInt);
  
  void syncClose();
  
  boolean syncOpen();
  
  int syncRead(byte[] paramArrayOfbyte, int paramInt);
  
  int syncWrite(byte[] paramArrayOfbyte, int paramInt);
  
  void write(byte[] paramArrayOfbyte);
  
  public static interface UsbBreakCallback {
    void onBreakInterrupt();
  }
  
  public static interface UsbCTSCallback {
    void onCTSChanged(boolean param1Boolean);
  }
  
  public static interface UsbDSRCallback {
    void onDSRChanged(boolean param1Boolean);
  }
  
  public static interface UsbFrameCallback {
    void onFramingError();
  }
  
  public static interface UsbOverrunCallback {
    void onOverrunError();
  }
  
  public static interface UsbParityCallback {
    void onParityError();
  }
  
  public static interface UsbReadCallback {
    void onReceivedData(byte[] param1ArrayOfbyte);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\UsbSerialInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */