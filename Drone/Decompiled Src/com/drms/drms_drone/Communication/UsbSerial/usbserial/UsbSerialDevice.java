package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbRequest;
import android.os.Build;
import com.drms.drms_drone.Communication.UsbSerial.deviceids.CH34xIds;
import com.drms.drms_drone.Communication.UsbSerial.deviceids.CP210xIds;
import com.drms.drms_drone.Communication.UsbSerial.deviceids.FTDISioIds;
import com.drms.drms_drone.Communication.UsbSerial.deviceids.PL2303Ids;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class UsbSerialDevice implements UsbSerialInterface {
  private static final String CLASS_ID = UsbSerialDevice.class.getSimpleName();
  
  protected static final int USB_TIMEOUT = 5000;
  
  private static boolean mr1Version = false;
  
  protected boolean asyncMode;
  
  protected final UsbDeviceConnection connection;
  
  protected final UsbDevice device;
  
  private UsbEndpoint inEndpoint;
  
  private UsbEndpoint outEndpoint;
  
  protected ReadThread readThread;
  
  protected SerialBuffer serialBuffer;
  
  protected WorkerThread workerThread;
  
  protected WriteThread writeThread;
  
  public UsbSerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    this.device = paramUsbDevice;
    this.connection = paramUsbDeviceConnection;
    this.asyncMode = true;
    this.serialBuffer = new SerialBuffer(mr1Version);
  }
  
  public static UsbSerialDevice createUsbSerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    return createUsbSerialDevice(paramUsbDevice, paramUsbDeviceConnection, -1);
  }
  
  public static UsbSerialDevice createUsbSerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection, int paramInt) {
    int i = paramUsbDevice.getVendorId();
    int j = paramUsbDevice.getProductId();
    return (UsbSerialDevice)(FTDISioIds.isDeviceSupported(i, j) ? new FTDISerialDevice(paramUsbDevice, paramUsbDeviceConnection, paramInt) : (CP210xIds.isDeviceSupported(i, j) ? new CP2102SerialDevice(paramUsbDevice, paramUsbDeviceConnection, paramInt) : (PL2303Ids.isDeviceSupported(i, j) ? new PL2303SerialDevice(paramUsbDevice, paramUsbDeviceConnection, paramInt) : (CH34xIds.isDeviceSupported(i, j) ? new CH34xSerialDevice(paramUsbDevice, paramUsbDeviceConnection, paramInt) : (isCdcDevice(paramUsbDevice) ? new CDCSerialDevice(paramUsbDevice, paramUsbDeviceConnection, paramInt) : null)))));
  }
  
  public static boolean isCdcDevice(UsbDevice paramUsbDevice) {
    int j = paramUsbDevice.getInterfaceCount();
    for (int i = 0; i <= j - 1; i++) {
      if (paramUsbDevice.getInterface(i).getInterfaceClass() == 10)
        return true; 
    } 
    return false;
  }
  
  private boolean isFTDIDevice() {
    return this instanceof FTDISerialDevice;
  }
  
  public static boolean isSupported(UsbDevice paramUsbDevice) {
    int i = paramUsbDevice.getVendorId();
    int j = paramUsbDevice.getProductId();
    return !(!FTDISioIds.isDeviceSupported(i, j) && !CP210xIds.isDeviceSupported(i, j) && !PL2303Ids.isDeviceSupported(i, j) && !CH34xIds.isDeviceSupported(i, j) && !isCdcDevice(paramUsbDevice));
  }
  
  public abstract void close();
  
  public void debug(boolean paramBoolean) {
    if (this.serialBuffer != null)
      this.serialBuffer.debug(paramBoolean); 
  }
  
  protected void killWorkingThread() {
    if (mr1Version && this.workerThread != null) {
      this.workerThread.stopWorkingThread();
      this.workerThread = null;
      return;
    } 
    if (!mr1Version && this.readThread != null) {
      this.readThread.stopReadThread();
      this.readThread = null;
      return;
    } 
  }
  
  protected void killWriteThread() {
    if (this.writeThread != null) {
      this.writeThread.stopWriteThread();
      this.writeThread = null;
      this.serialBuffer.resetWriteBuffer();
    } 
  }
  
  public abstract boolean open();
  
  public int read(UsbSerialInterface.UsbReadCallback paramUsbReadCallback) {
    if (!this.asyncMode)
      return -1; 
    if (mr1Version) {
      this.workerThread.setCallback(paramUsbReadCallback);
      this.workerThread.getUsbRequest().queue(this.serialBuffer.getReadBuffer(), 16384);
      return 0;
    } 
    this.readThread.setCallback(paramUsbReadCallback);
    return 0;
  }
  
  protected void restartWorkingThread() {
    if (mr1Version && this.workerThread == null) {
      this.workerThread = new WorkerThread(this);
      this.workerThread.start();
      do {
      
      } while (!this.workerThread.isAlive());
      return;
    } 
    if (!mr1Version && this.readThread == null) {
      this.readThread = new ReadThread(this);
      this.readThread.start();
      while (true) {
        if (!this.readThread.isAlive())
          continue; 
        return;
      } 
    } 
  }
  
  protected void restartWriteThread() {
    if (this.writeThread == null) {
      this.writeThread = new WriteThread();
      this.writeThread.start();
      do {
      
      } while (!this.writeThread.isAlive());
    } 
  }
  
  public abstract void setBaudRate(int paramInt);
  
  public abstract void setDataBits(int paramInt);
  
  public abstract void setFlowControl(int paramInt);
  
  public abstract void setParity(int paramInt);
  
  public abstract void setStopBits(int paramInt);
  
  protected void setSyncParams(UsbEndpoint paramUsbEndpoint1, UsbEndpoint paramUsbEndpoint2) {
    this.inEndpoint = paramUsbEndpoint1;
    this.outEndpoint = paramUsbEndpoint2;
  }
  
  protected void setThreadsParams(UsbRequest paramUsbRequest, UsbEndpoint paramUsbEndpoint) {
    if (mr1Version) {
      this.workerThread.setUsbRequest(paramUsbRequest);
      this.writeThread.setUsbEndpoint(paramUsbEndpoint);
      return;
    } 
    this.readThread.setUsbEndpoint(paramUsbRequest.getEndpoint());
    this.writeThread.setUsbEndpoint(paramUsbEndpoint);
  }
  
  public abstract void syncClose();
  
  public abstract boolean syncOpen();
  
  public int syncRead(byte[] paramArrayOfbyte, int paramInt) {
    return this.asyncMode ? -1 : ((paramArrayOfbyte == null) ? 0 : this.connection.bulkTransfer(this.inEndpoint, paramArrayOfbyte, paramArrayOfbyte.length, paramInt));
  }
  
  public int syncWrite(byte[] paramArrayOfbyte, int paramInt) {
    return !this.asyncMode ? ((paramArrayOfbyte == null) ? 0 : this.connection.bulkTransfer(this.outEndpoint, paramArrayOfbyte, paramArrayOfbyte.length, paramInt)) : -1;
  }
  
  public void write(byte[] paramArrayOfbyte) {
    if (this.asyncMode)
      this.serialBuffer.putWriteBuffer(paramArrayOfbyte); 
  }
  
  static {
    if (Build.VERSION.SDK_INT > 17) {
      mr1Version = true;
      return;
    } 
  }
  
  protected class ReadThread extends Thread {
    private UsbSerialInterface.UsbReadCallback callback;
    
    private UsbEndpoint inEndpoint;
    
    private UsbSerialDevice usbSerialDevice;
    
    private AtomicBoolean working;
    
    public ReadThread(UsbSerialDevice param1UsbSerialDevice1) {
      this.usbSerialDevice = param1UsbSerialDevice1;
      this.working = new AtomicBoolean(true);
    }
    
    private void onReceivedData(byte[] param1ArrayOfbyte) {
      if (this.callback != null)
        this.callback.onReceivedData(param1ArrayOfbyte); 
    }
    
    public void run() {
      while (this.working.get()) {
        boolean bool;
        if (this.inEndpoint != null) {
          bool = UsbSerialDevice.this.connection.bulkTransfer(this.inEndpoint, UsbSerialDevice.this.serialBuffer.getBufferCompatible(), 16384, 0);
        } else {
          bool = false;
        } 
        if (bool) {
          byte[] arrayOfByte = UsbSerialDevice.this.serialBuffer.getDataReceivedCompatible(bool);
          if (UsbSerialDevice.this.isFTDIDevice()) {
            ((FTDISerialDevice)this.usbSerialDevice).ftdiUtilities.checkModemStatus(arrayOfByte);
            if (arrayOfByte.length > 2)
              onReceivedData(((FTDISerialDevice)this.usbSerialDevice).ftdiUtilities.adaptArray(arrayOfByte)); 
            continue;
          } 
          onReceivedData(arrayOfByte);
        } 
      } 
    }
    
    public void setCallback(UsbSerialInterface.UsbReadCallback param1UsbReadCallback) {
      this.callback = param1UsbReadCallback;
    }
    
    public void setUsbEndpoint(UsbEndpoint param1UsbEndpoint) {
      this.inEndpoint = param1UsbEndpoint;
    }
    
    public void stopReadThread() {
      this.working.set(false);
    }
  }
  
  protected class WorkerThread extends Thread {
    private UsbSerialInterface.UsbReadCallback callback;
    
    private UsbRequest requestIN;
    
    private UsbSerialDevice usbSerialDevice;
    
    private AtomicBoolean working;
    
    public WorkerThread(UsbSerialDevice param1UsbSerialDevice1) {
      this.usbSerialDevice = param1UsbSerialDevice1;
      this.working = new AtomicBoolean(true);
    }
    
    private void onReceivedData(byte[] param1ArrayOfbyte) {
      if (this.callback != null)
        this.callback.onReceivedData(param1ArrayOfbyte); 
    }
    
    public UsbRequest getUsbRequest() {
      return this.requestIN;
    }
    
    public void run() {
      while (this.working.get()) {
        UsbRequest usbRequest = UsbSerialDevice.this.connection.requestWait();
        if (usbRequest != null && usbRequest.getEndpoint().getType() == 2 && usbRequest.getEndpoint().getDirection() == 128) {
          byte[] arrayOfByte = UsbSerialDevice.this.serialBuffer.getDataReceived();
          if (UsbSerialDevice.this.isFTDIDevice()) {
            ((FTDISerialDevice)this.usbSerialDevice).ftdiUtilities.checkModemStatus(arrayOfByte);
            UsbSerialDevice.this.serialBuffer.clearReadBuffer();
            if (arrayOfByte.length > 2)
              onReceivedData(((FTDISerialDevice)this.usbSerialDevice).ftdiUtilities.adaptArray(arrayOfByte)); 
          } else {
            UsbSerialDevice.this.serialBuffer.clearReadBuffer();
            onReceivedData(arrayOfByte);
          } 
          this.requestIN.queue(UsbSerialDevice.this.serialBuffer.getReadBuffer(), 16384);
        } 
      } 
    }
    
    public void setCallback(UsbSerialInterface.UsbReadCallback param1UsbReadCallback) {
      this.callback = param1UsbReadCallback;
    }
    
    public void setUsbRequest(UsbRequest param1UsbRequest) {
      this.requestIN = param1UsbRequest;
    }
    
    public void stopWorkingThread() {
      this.working.set(false);
    }
  }
  
  protected class WriteThread extends Thread {
    private UsbEndpoint outEndpoint;
    
    private AtomicBoolean working = new AtomicBoolean(true);
    
    public void run() {
      while (this.working.get()) {
        byte[] arrayOfByte = UsbSerialDevice.this.serialBuffer.getWriteBuffer();
        UsbSerialDevice.this.connection.bulkTransfer(this.outEndpoint, arrayOfByte, arrayOfByte.length, 5000);
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


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\UsbSerialDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */