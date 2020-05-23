package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import java.io.OutputStream;

public class SerialOutputStream extends OutputStream {
  protected final UsbSerialInterface device;
  
  public SerialOutputStream(UsbSerialInterface paramUsbSerialInterface) {
    this.device = paramUsbSerialInterface;
  }
  
  public void write(int paramInt) {
    this.device.write(new byte[] { (byte)paramInt });
  }
  
  public void write(byte[] paramArrayOfbyte) {
    this.device.write(paramArrayOfbyte);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\SerialOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */