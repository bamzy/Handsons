package com.drms.drms_drone.Communication.UsbSerial;

import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import com.drms.drms_drone.Communication.UsbSerial.usbserial.UsbSerialDevice;
import com.drms.drms_drone.Communication.UsbSerial.usbserial.UsbSerialInterface;
import com.drms.drms_drone.DrsController.DrsControllerManager;
import com.drms.drms_drone.MultiData;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UsbService extends Service {
  public static final String ACTION_CDC_DRIVER_NOT_WORKING = "com.felhr.connectivityservices.ACTION_CDC_DRIVER_NOT_WORKING";
  
  public static final String ACTION_NO_USB = "com.felhr.usbservice.NO_USB";
  
  public static final String ACTION_USB_ATTACHED = "android.hardware.usb.action.USB_DEVICE_ATTACHED";
  
  public static final String ACTION_USB_DETACHED = "android.hardware.usb.action.USB_DEVICE_DETACHED";
  
  public static final String ACTION_USB_DEVICE_NOT_WORKING = "com.felhr.connectivityservices.ACTION_USB_DEVICE_NOT_WORKING";
  
  public static final String ACTION_USB_DISCONNECTED = "com.felhr.usbservice.USB_DISCONNECTED";
  
  public static final String ACTION_USB_NOT_SUPPORTED = "com.felhr.usbservice.USB_NOT_SUPPORTED";
  
  private static final String ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION";
  
  public static final String ACTION_USB_PERMISSION_GRANTED = "com.felhr.usbservice.USB_PERMISSION_GRANTED";
  
  public static final String ACTION_USB_PERMISSION_NOT_GRANTED = "com.felhr.usbservice.USB_PERMISSION_NOT_GRANTED";
  
  public static final String ACTION_USB_READY = "com.felhr.connectivityservices.USB_READY";
  
  private static final int BAUD_RATE = 57600;
  
  public static final String CONNECTED_CONTROLLER = "com.drms.drms_drone.CONNECTED_CONTROLLER";
  
  public static final int CTS_CHANGE = 1;
  
  public static final int DSR_CHANGE = 2;
  
  public static final int MESSAGE_FROM_SERIAL_PORT = 0;
  
  public static final int MESSAGE_FROM_USBSERVERVICE = 11;
  
  public static boolean SERVICE_CONNECTED = false;
  
  private static final String TAG = "UsbService";
  
  private IBinder binder = (IBinder)new UsbBinder();
  
  private boolean connected = false;
  
  private boolean connectedRequested = false;
  
  private UsbDeviceConnection connection;
  
  private Context context;
  
  private UsbSerialInterface.UsbCTSCallback ctsCallback = new UsbSerialInterface.UsbCTSCallback() {
      public void onCTSChanged(boolean param1Boolean) {
        if (UsbService.this.mHandler != null)
          UsbService.this.mHandler.obtainMessage(11, 1, -1).sendToTarget(); 
      }
    };
  
  private UsbDevice device;
  
  private DrsControllerManager drsController;
  
  private UsbSerialInterface.UsbDSRCallback dsrCallback = new UsbSerialInterface.UsbDSRCallback() {
      public void onDSRChanged(boolean param1Boolean) {
        if (UsbService.this.mHandler != null)
          UsbService.this.mHandler.obtainMessage(11, 2, -1).sendToTarget(); 
      }
    };
  
  private UsbSerialInterface.UsbReadCallback mCallback = new UsbSerialInterface.UsbReadCallback() {
      public void onReceivedData(final byte[] datain) {
        try {
          if ((new String(datain, "UTF-8")).equals("HELLO")) {
            Log.d("UsbService", "Connected");
            UsbService.access$002(UsbService.this, true);
            UsbService.access$102(UsbService.this, false);
            UsbService.this.multiData.setControllerConnected(true);
            UsbService.this.context.sendBroadcast(new Intent("com.drms.drms_drone.CONNECTED_CONTROLLER"));
            return;
          } 
          if (datain.length > 0 && UsbService.this.mHandler != null) {
            (new Thread(new Runnable() {
                  public void run() {
                    UsbService.this.drsController.processControllerData(datain);
                  }
                })).start();
            return;
          } 
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
        } 
      }
    };
  
  private Handler mHandler;
  
  private MultiData multiData;
  
  private UsbSerialDevice serialPort;
  
  private boolean serialPortConnected;
  
  private UsbManager usbManager;
  
  private final BroadcastReceiver usbReceiver = new BroadcastReceiver() {
      public void onReceive(Context param1Context, Intent param1Intent) {
        if (param1Intent.getAction().equals("com.android.example.USB_PERMISSION")) {
          if (param1Intent.getExtras().getBoolean("permission")) {
            param1Context.sendBroadcast(new Intent("com.felhr.usbservice.USB_PERMISSION_GRANTED"));
            UsbService.access$602(UsbService.this, UsbService.this.usbManager.openDevice(UsbService.this.device));
            UsbService.access$102(UsbService.this, true);
            (new UsbService.ConnectionThread()).start();
            return;
          } 
          param1Context.sendBroadcast(new Intent("com.felhr.usbservice.USB_PERMISSION_NOT_GRANTED"));
          return;
        } 
        if (param1Intent.getAction().equals("android.hardware.usb.action.USB_DEVICE_ATTACHED")) {
          if (!UsbService.this.serialPortConnected) {
            UsbService.this.findSerialPortDevice();
            return;
          } 
          return;
        } 
        if (param1Intent.getAction().equals("android.hardware.usb.action.USB_DEVICE_DETACHED")) {
          param1Context.sendBroadcast(new Intent("com.felhr.usbservice.USB_DISCONNECTED"));
          if (UsbService.this.serialPortConnected)
            UsbService.this.serialPort.close(); 
          UsbService.access$1002(UsbService.this, false);
          UsbService.access$102(UsbService.this, false);
          UsbService.access$002(UsbService.this, false);
          UsbService.this.multiData.setControllerConnected(false);
          return;
        } 
      }
    };
  
  private void findSerialPortDevice() {
    HashMap hashMap = this.usbManager.getDeviceList();
    if (!hashMap.isEmpty()) {
      int i = 1;
      Iterator<Map.Entry> iterator = hashMap.entrySet().iterator();
      while (true) {
        int j = i;
        if (iterator.hasNext()) {
          this.device = (UsbDevice)((Map.Entry)iterator.next()).getValue();
          j = this.device.getVendorId();
          int k = this.device.getProductId();
          if (j != 7531 && k != 1 && k != 2 && k != 3) {
            requestUserPermission();
            j = 0;
          } else {
            this.connection = null;
            this.device = null;
            j = i;
          } 
          i = j;
          if (j == 0) {
            if (j == 0)
              sendBroadcast(new Intent("com.felhr.usbservice.NO_USB")); 
            return;
          } 
          continue;
        } 
        if (j == 0)
          sendBroadcast(new Intent("com.felhr.usbservice.NO_USB")); 
        return;
      } 
    } 
    sendBroadcast(new Intent("com.felhr.usbservice.NO_USB"));
  }
  
  private void requestUserPermission() {
    PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)this, 0, new Intent("com.android.example.USB_PERMISSION"), 0);
    this.usbManager.requestPermission(this.device, pendingIntent);
  }
  
  private void setFilter() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("com.android.example.USB_PERMISSION");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    registerReceiver(this.usbReceiver, intentFilter);
  }
  
  public IBinder onBind(Intent paramIntent) {
    return this.binder;
  }
  
  public void onCreate() {
    this.context = (Context)this;
    this.serialPortConnected = false;
    SERVICE_CONNECTED = true;
    setFilter();
    this.usbManager = (UsbManager)getSystemService("usb");
    findSerialPortDevice();
    this.multiData = (MultiData)getApplication();
    this.drsController = new DrsControllerManager(this);
  }
  
  public void onDestroy() {
    super.onDestroy();
    SERVICE_CONNECTED = false;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    return 2;
  }
  
  public void setHandler(Handler paramHandler) {
    this.mHandler = paramHandler;
  }
  
  public void write(byte[] paramArrayOfbyte) {
    if (this.serialPort != null)
      this.serialPort.write(paramArrayOfbyte); 
  }
  
  private class ConnectionThread extends Thread {
    private ConnectionThread() {}
    
    public void run() {
      UsbService.access$1202(UsbService.this, UsbSerialDevice.createUsbSerialDevice(UsbService.this.device, UsbService.this.connection));
      if (UsbService.this.serialPort != null) {
        if (UsbService.this.serialPort.open()) {
          UsbService.access$1002(UsbService.this, true);
          UsbService.this.serialPort.setBaudRate(57600);
          UsbService.this.serialPort.setDataBits(8);
          UsbService.this.serialPort.setStopBits(1);
          UsbService.this.serialPort.setParity(0);
          UsbService.this.serialPort.setFlowControl(0);
          UsbService.this.serialPort.read(UsbService.this.mCallback);
          UsbService.this.serialPort.getCTS(UsbService.this.ctsCallback);
          UsbService.this.serialPort.getDSR(UsbService.this.dsrCallback);
          Intent intent1 = new Intent("com.felhr.connectivityservices.USB_READY");
          UsbService.this.context.sendBroadcast(intent1);
          UsbService.access$002(UsbService.this, false);
          while (!UsbService.this.connected && UsbService.this.connectedRequested == true) {
            UsbService.this.write("#hello".getBytes());
            try {
              sleep(1000L);
            } catch (InterruptedException interruptedException) {
              Log.d("UsbService", "Interrupted Exception for connected to Arduino");
            } 
          } 
          while (UsbService.this.connected) {
            UsbService.this.write("#get".getBytes());
            try {
              sleep(50L);
            } catch (InterruptedException interruptedException) {
              Log.d("UsbService", "InterruptedException occured");
            } 
          } 
        } else {
          if (UsbService.this.serialPort instanceof com.drms.drms_drone.Communication.UsbSerial.usbserial.CDCSerialDevice) {
            Intent intent2 = new Intent("com.felhr.connectivityservices.ACTION_CDC_DRIVER_NOT_WORKING");
            UsbService.this.context.sendBroadcast(intent2);
            return;
          } 
          Intent intent1 = new Intent("com.felhr.connectivityservices.ACTION_USB_DEVICE_NOT_WORKING");
          UsbService.this.context.sendBroadcast(intent1);
          return;
        } 
        return;
      } 
      Intent intent = new Intent("com.felhr.usbservice.USB_NOT_SUPPORTED");
      UsbService.this.context.sendBroadcast(intent);
    }
  }
  
  public class UsbBinder extends Binder {
    public UsbService getService() {
      return UsbService.this;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSerial\UsbService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */