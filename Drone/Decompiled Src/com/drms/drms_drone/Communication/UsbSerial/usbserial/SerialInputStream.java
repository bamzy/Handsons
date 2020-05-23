package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import java.io.InputStream;
import java.util.concurrent.ArrayBlockingQueue;

public class SerialInputStream extends InputStream implements UsbSerialInterface.UsbReadCallback {
  protected ArrayBlockingQueue data = new ArrayBlockingQueue(256);
  
  protected final UsbSerialInterface device;
  
  protected volatile boolean is_open;
  
  public SerialInputStream(UsbSerialInterface paramUsbSerialInterface) {
    this.device = paramUsbSerialInterface;
    this.is_open = true;
    paramUsbSerialInterface.read(this);
  }
  
  public void close() {
    this.is_open = false;
    try {
      this.data.put(Integer.valueOf(-1));
      return;
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
      return;
    } 
  }
  
  public void onReceivedData(byte[] paramArrayOfbyte) {
    int j = paramArrayOfbyte.length;
    int i = 0;
    while (true) {
      if (i < j) {
        byte b = paramArrayOfbyte[i];
        try {
          this.data.put(Integer.valueOf(b & 0xFF));
        } catch (InterruptedException interruptedException) {}
        i++;
        continue;
      } 
      return;
    } 
  }
  
  public int read() {
    while (true) {
      if (this.is_open)
        try {
          return ((Integer)this.data.take()).intValue();
        } catch (InterruptedException interruptedException) {
          continue;
        }  
      return -1;
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\SerialInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */