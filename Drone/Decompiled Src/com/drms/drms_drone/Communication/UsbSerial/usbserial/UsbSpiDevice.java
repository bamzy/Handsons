package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import com.drms.drms_drone.Communication.UsbSerial.deviceids.CP2130Ids;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class UsbSpiDevice implements UsbSpiInterface {
  private static final String CLASS_ID = UsbSerialDevice.class.getSimpleName();
  
  protected static final int USB_TIMEOUT = 5000;
  
  protected final UsbDeviceConnection connection;
  
  protected final UsbDevice device;
  
  private UsbEndpoint inEndpoint;
  
  private UsbEndpoint outEndpoint;
  
  protected ReadThread readThread;
  
  protected SerialBuffer serialBuffer;
  
  protected WriteThread writeThread;
  
  public UsbSpiDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    this.device = paramUsbDevice;
    this.connection = paramUsbDeviceConnection;
    this.serialBuffer = new SerialBuffer(false);
  }
  
  public static UsbSpiDevice createUsbSerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    return createUsbSerialDevice(paramUsbDevice, paramUsbDeviceConnection, -1);
  }
  
  public static UsbSpiDevice createUsbSerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection, int paramInt) {
    return CP2130Ids.isDeviceSupported(paramUsbDevice.getVendorId(), paramUsbDevice.getProductId()) ? new CP2130SpiDevice(paramUsbDevice, paramUsbDeviceConnection, paramInt) : null;
  }
  
  public abstract void closeSPI();
  
  public abstract boolean connectSPI();
  
  public abstract int getClockDivider();
  
  public abstract int getSelectedSlave();
  
  protected void killWorkingThread() {
    if (this.readThread != null) {
      this.readThread.stopReadThread();
      this.readThread = null;
    } 
  }
  
  protected void killWriteThread() {
    if (this.writeThread != null) {
      this.writeThread.stopWriteThread();
      this.writeThread = null;
      this.serialBuffer.resetWriteBuffer();
    } 
  }
  
  public abstract void readMISO(int paramInt);
  
  protected void restartWorkingThread() {
    this.readThread = new ReadThread();
    this.readThread.start();
    do {
    
    } while (!this.readThread.isAlive());
  }
  
  protected void restartWriteThread() {
    if (this.writeThread == null) {
      this.writeThread = new WriteThread();
      this.writeThread.start();
      do {
      
      } while (!this.writeThread.isAlive());
    } 
  }
  
  public abstract void selectSlave(int paramInt);
  
  public abstract void setClock(int paramInt);
  
  public void setMISOCallback(UsbSpiInterface.UsbMISOCallback paramUsbMISOCallback) {
    this.readThread.setCallback(paramUsbMISOCallback);
  }
  
  protected void setThreadsParams(UsbEndpoint paramUsbEndpoint1, UsbEndpoint paramUsbEndpoint2) {
    if (this.writeThread != null)
      this.writeThread.setUsbEndpoint(paramUsbEndpoint2); 
    if (this.readThread != null)
      this.readThread.setUsbEndpoint(paramUsbEndpoint1); 
  }
  
  public abstract void writeMOSI(byte[] paramArrayOfbyte);
  
  public abstract void writeRead(byte[] paramArrayOfbyte, int paramInt);
  
  protected class ReadThread extends Thread {
    private UsbEndpoint inEndpoint;
    
    private UsbSpiInterface.UsbMISOCallback misoCallback;
    
    private AtomicBoolean working = new AtomicBoolean(true);
    
    private void onReceivedData(byte[] param1ArrayOfbyte) {
      if (this.misoCallback != null)
        this.misoCallback.onReceivedData(param1ArrayOfbyte); 
    }
    
    public void run() {
      while (this.working.get()) {
        boolean bool;
        if (this.inEndpoint != null) {
          bool = UsbSpiDevice.this.connection.bulkTransfer(this.inEndpoint, UsbSpiDevice.this.serialBuffer.getBufferCompatible(), 16384, 0);
        } else {
          bool = false;
        } 
        if (bool)
          onReceivedData(UsbSpiDevice.this.serialBuffer.getDataReceivedCompatible(bool)); 
      } 
    }
    
    public void setCallback(UsbSpiInterface.UsbMISOCallback param1UsbMISOCallback) {
      this.misoCallback = param1UsbMISOCallback;
    }
    
    public void setUsbEndpoint(UsbEndpoint param1UsbEndpoint) {
      this.inEndpoint = param1UsbEndpoint;
    }
    
    public void stopReadThread() {
      this.working.set(false);
    }
  }
  
  protected class WriteThread extends Thread {
    private UsbEndpoint outEndpoint;
    
    private AtomicBoolean working = new AtomicBoolean(true);
    
    public void run() {
      while (this.working.get()) {
        byte[] arrayOfByte = UsbSpiDevice.this.serialBuffer.getWriteBuffer();
        UsbSpiDevice.this.connection.bulkTransfer(this.outEndpoint, arrayOfByte, arrayOfByte.length, 5000);
      } 
    }
    
    public void setUsbEndpoint(UsbEndpoint param1UsbEndpoint) {
      this.outEndpoint = param1UsbEndpoint;
    }
    
    public void stopWriteThread() {
      this.working.set(false);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\UsbSpiDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */