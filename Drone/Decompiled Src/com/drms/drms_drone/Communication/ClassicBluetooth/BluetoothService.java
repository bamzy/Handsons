package com.drms.drms_drone.Communication.ClassicBluetooth;

import android.app.Activity;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class BluetoothService {
  private static final int DRS_PROTOCOL = 101;
  
  public static final int MESSAGE_READ = 3;
  
  public static final int MESSAGE_STATE_CHANGE = 10;
  
  public static final int MESSAGE_WRITE = 2;
  
  public static final int MODE_REQUEST = 1;
  
  private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
  
  private static final int Multiwii_PROTOCOL = 102;
  
  private static final int REQUEST_CONNECT_DEVICE = 1;
  
  private static final int REQUEST_ENABLE_BT = 2;
  
  public static final int STATE_CONNECTED = 4;
  
  public static final int STATE_CONNECTING = 3;
  
  public static final int STATE_DISCONNECTED = 8;
  
  public static final int STATE_FAIL = 7;
  
  public static final int STATE_LISTEN = 2;
  
  public static final int STATE_NONE = 1;
  
  private static final int STK_PROTOCOL = 103;
  
  private static final String TAG = "BluetoothService";
  
  private String MyAddress = "";
  
  private String Protocol;
  
  public String address1;
  
  private BluetoothAdapter btAdapter;
  
  public BluetoothDevice device;
  
  private String level_round;
  
  private Activity mActivity;
  
  private ConnectThread mConnectThread;
  
  private ConnectedThread mConnectedThread;
  
  private Handler mHandler;
  
  public int mMode;
  
  private Service mService;
  
  public int mState = 1;
  
  private boolean read_running = true;
  
  public BluetoothService(Service paramService, Handler paramHandler, String paramString) {
    this.mService = paramService;
    this.mHandler = paramHandler;
    this.level_round = this.level_round;
    this.Protocol = paramString;
    BluetoothAdapter.getDefaultAdapter();
    this.btAdapter = BluetoothAdapter.getDefaultAdapter();
  }
  
  private void ConnectLost() {
    setState(2);
  }
  
  private void connectFailed() {
    setState(7);
  }
  
  private void setState(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'BluetoothService'
    //   4: new java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: ldc 'setState()'
    //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield mState : I
    //   20: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   23: ldc '->'
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_1
    //   29: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: aload_0
    //   40: iload_1
    //   41: putfield mState : I
    //   44: aload_0
    //   45: getfield mHandler : Landroid/os/Handler;
    //   48: bipush #10
    //   50: iload_1
    //   51: iconst_m1
    //   52: invokevirtual obtainMessage : (III)Landroid/os/Message;
    //   55: invokevirtual sendToTarget : ()V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Exception table:
    //   from	to	target	type
    //   2	58	61	finally
  }
  
  public void connect(BluetoothDevice paramBluetoothDevice) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'BluetoothService'
    //   4: new java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: ldc 'connect to: '
    //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: invokevirtual toString : ()Ljava/lang/String;
    //   23: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   26: pop
    //   27: aload_0
    //   28: getfield mState : I
    //   31: iconst_3
    //   32: if_icmpne -> 42
    //   35: aload_0
    //   36: getfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   39: ifnonnull -> 77
    //   42: aload_0
    //   43: getfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   46: ifnonnull -> 97
    //   49: aload_0
    //   50: new com/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread
    //   53: dup
    //   54: aload_0
    //   55: aload_1
    //   56: invokespecial <init> : (Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/bluetooth/BluetoothDevice;)V
    //   59: putfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   62: aload_0
    //   63: getfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   66: invokevirtual start : ()V
    //   69: aload_0
    //   70: iconst_3
    //   71: invokespecial setState : (I)V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: aload_0
    //   78: getfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   81: invokevirtual cancel : ()V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   89: goto -> 42
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: aload_0
    //   98: getfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   101: invokevirtual cancel : ()V
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   109: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   2	42	92	finally
    //   42	49	92	finally
    //   49	74	92	finally
    //   77	89	92	finally
    //   97	109	92	finally
  }
  
  public void connected(BluetoothSocket paramBluetoothSocket, BluetoothDevice paramBluetoothDevice) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'BluetoothService'
    //   4: ldc 'connected'
    //   6: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: getfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   14: ifnonnull -> 52
    //   17: aload_0
    //   18: getfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   21: ifnonnull -> 72
    //   24: aload_0
    //   25: new com/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial <init> : (Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/bluetooth/BluetoothSocket;)V
    //   34: putfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   37: aload_0
    //   38: getfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   41: invokevirtual start : ()V
    //   44: aload_0
    //   45: iconst_4
    //   46: invokespecial setState : (I)V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_0
    //   53: getfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   56: invokevirtual cancel : ()V
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   64: goto -> 17
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: aload_0
    //   73: getfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   76: invokevirtual cancel : ()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   84: goto -> 24
    // Exception table:
    //   from	to	target	type
    //   2	17	67	finally
    //   17	24	67	finally
    //   24	49	67	finally
    //   52	64	67	finally
    //   72	84	67	finally
  }
  
  public void enableBluetooth() {
    Log.i("BluetoothService", "Check the enable Bluetooth");
    if (this.btAdapter.isEnabled()) {
      Log.d("BluetoothService", "Bluetooth Enable Now");
      scanDevice();
      return;
    } 
    Log.d("BluetoothService", "Bluetooth Enable Request");
    new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
  }
  
  public void getDeviceInfo(Intent paramIntent) {
    String str = paramIntent.getExtras().getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);
    this.address1 = str;
    this.device = this.btAdapter.getRemoteDevice(str);
    Log.d("BluetoothService", "Get Device Info\naddress : " + str);
    connect(this.device);
  }
  
  public boolean getDeviceState() {
    Log.d("BluetoothService", "Check the Bluetooth support");
    if (this.btAdapter == null) {
      Log.d("BluetoothService", "Bluetooth is not available");
      return false;
    } 
    Log.d("BluetoothService", "Bluetooth is available");
    return true;
  }
  
  public int getState() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mState : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void readMSP() {
    this.mConnectedThread.read_protocol("MSP");
  }
  
  public void scanDevice() {
    Log.d("BluetoothService", "SCAN DEVICE");
    (new Intent((Context)this.mActivity, DeviceListActivity.class)).setAction("request scan device");
  }
  
  public void setProtocol(String paramString) {
    this.Protocol = paramString;
  }
  
  public void setReadRunning(boolean paramBoolean) {
    this.read_running = paramBoolean;
  }
  
  public void setmHandler(Handler paramHandler) {
    this.mHandler = paramHandler;
  }
  
  public void start() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'BluetoothService'
    //   4: ldc_w 'start'
    //   7: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   10: pop
    //   11: aload_0
    //   12: getfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   27: invokevirtual cancel : ()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   35: goto -> 20
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	38	finally
    //   23	35	38	finally
  }
  
  public void stop() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'BluetoothService'
    //   4: ldc_w 'STOP'
    //   7: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   10: pop
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield read_running : Z
    //   16: aload_0
    //   17: getfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   20: ifnull -> 35
    //   23: aload_0
    //   24: getfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   27: invokevirtual cancel : ()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield mConnectThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    //   35: aload_0
    //   36: getfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   39: ifnull -> 54
    //   42: aload_0
    //   43: getfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   46: invokevirtual cancel : ()V
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield device : Landroid/bluetooth/BluetoothDevice;
    //   59: aload_0
    //   60: iconst_1
    //   61: invokespecial setState : (I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	67	finally
    //   35	54	67	finally
    //   54	64	67	finally
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mState : I
    //   6: iconst_4
    //   7: if_icmpeq -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: getfield mConnectedThread : Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    //   17: astore_3
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_3
    //   21: aload_1
    //   22: iload_2
    //   23: invokevirtual write : ([BI)V
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	27	finally
    //   13	20	27	finally
    //   28	30	27	finally
  }
  
  private class ConnectThread extends Thread {
    private final BluetoothDevice mmDevice;
    
    private final BluetoothSocket mmSocket;
    
    public ConnectThread(BluetoothDevice param1BluetoothDevice) {
      BluetoothSocket bluetoothSocket;
      this.mmDevice = param1BluetoothDevice;
      BluetoothService.this = null;
      try {
        BluetoothSocket bluetoothSocket1 = param1BluetoothDevice.createRfcommSocketToServiceRecord(BluetoothService.MY_UUID);
        bluetoothSocket = bluetoothSocket1;
      } catch (IOException iOException) {
        Log.e("BluetoothService", "create() failed", iOException);
      } 
      this.mmSocket = bluetoothSocket;
    }
    
    public void cancel() {
      try {
        this.mmSocket.close();
        return;
      } catch (IOException iOException) {
        Log.e("BluetoothService", "close() of connect socket failed", iOException);
        return;
      } 
    }
    
    public void run() {
      Exception exception;
      Log.i("BluetoothService", "BEGIN mConnectThread");
      setName("ConnectThread");
      BluetoothService.this.btAdapter.cancelDiscovery();
      try {
        this.mmSocket.connect();
        Log.d("BluetoothService", "Connect Success");
        BluetoothService bluetoothService = BluetoothService.this;
        /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{com/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService}, name=null} */
        try {
          BluetoothService.access$302(BluetoothService.this, null);
          /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{com/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService}, name=null} */
          BluetoothService.this.connected(this.mmSocket, this.mmDevice);
          return;
        } finally {}
      } catch (IOException null) {
        BluetoothService.this.connectFailed();
        Log.d("BluetoothService", "Connect Fail");
        try {
          this.mmSocket.close();
        } catch (IOException iOException) {
          Log.e("BluetoothService", "unable to close() socket during connection failure", iOException);
        } 
        BluetoothService.this.start();
        return;
      } 
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/io/IOException}, name=null} */
      throw exception;
    }
  }
  
  private class ConnectedThread extends Thread {
    private final InputStream mmInStream;
    
    private final OutputStream mmOutStream;
    
    private final BluetoothSocket mmSocket;
    
    public ConnectedThread(BluetoothSocket param1BluetoothSocket) {
      InputStream inputStream;
      Log.d("BluetoothService", "create ConnectedThread");
      this.mmSocket = param1BluetoothSocket;
      BluetoothService.this = null;
      IOException iOException2 = null;
      try {
        InputStream inputStream1 = param1BluetoothSocket.getInputStream();
        inputStream = inputStream1;
        OutputStream outputStream = param1BluetoothSocket.getOutputStream();
        inputStream = inputStream1;
      } catch (IOException iOException1) {
        Log.e("BluetoothService", "temp socket net created", iOException1);
        iOException1 = iOException2;
      } 
      this.mmInStream = inputStream;
      this.mmOutStream = (OutputStream)iOException1;
    }
    
    private void read_protocol(String param1String) {
      if (param1String.equals("STK"))
        try {
          byte[] arrayOfByte = new byte[2];
          int i = this.mmInStream.read();
          arrayOfByte[0] = (byte)i;
          if ((byte)i == 20)
            arrayOfByte[1] = (byte)this.mmInStream.read(); 
          BluetoothService.this.mHandler.obtainMessage(3, -1, -1, arrayOfByte).sendToTarget();
          return;
        } catch (IOException null) {
          Log.d("BluetoothService", "disconnected");
          BluetoothService.this.ConnectLost();
          BluetoothService.access$402(BluetoothService.this, false);
          try {
            BluetoothService.this.mHandler.obtainMessage(10, 8, -1).sendToTarget();
            return;
          } catch (Exception exception) {
            return;
          } 
        }  
      if (exception.equals("MSP")) {
        int[] arrayOfInt = new int[2];
        try {
          if ((char)this.mmInStream.read() == '$') {
            int i;
            for (i = 0; i < 2; i++)
              arrayOfInt[i] = this.mmInStream.read(); 
            int k = this.mmInStream.read();
            int n = this.mmInStream.read();
            int[] arrayOfInt1 = new int[k];
            for (i = 0; i < k; i++)
              arrayOfInt1[i] = this.mmInStream.read(); 
            int m = this.mmInStream.read();
            byte[] arrayOfByte = new byte[k + 6];
            int j = 0 + 1;
            arrayOfByte[0] = 36;
            i = 0;
            while (i < 2) {
              arrayOfByte[j] = (byte)arrayOfInt[i];
              i++;
              j++;
            } 
            int i1 = j + 1;
            arrayOfByte[j] = (byte)k;
            i = i1 + 1;
            arrayOfByte[i1] = (byte)n;
            j = 0;
            while (true) {
              if (j < k) {
                arrayOfByte[i] = (byte)arrayOfInt1[j];
                j++;
                i++;
                continue;
              } 
              arrayOfByte[i] = (byte)m;
              BluetoothService.this.mHandler.obtainMessage(102, i, -1, arrayOfByte).sendToTarget();
              return;
            } 
          } 
          return;
        } catch (IOException iOException) {
          Log.e("BluetoothService", "disconnected");
          BluetoothService.this.mHandler.obtainMessage(10, 8, -1).sendToTarget();
          BluetoothService.this.ConnectLost();
          BluetoothService.access$402(BluetoothService.this, false);
          return;
        } 
      } 
    }
    
    public void cancel() {
      try {
        this.mmSocket.close();
        return;
      } catch (IOException iOException) {
        Log.e("BluetoothService", "close() of connect socket failed", iOException);
        return;
      } 
    }
    
    public void run() {
      Log.i("BluetoothService", "BEGIN mConnectedThread");
      while (BluetoothService.this.read_running)
        read_protocol(BluetoothService.this.Protocol); 
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int) {
      try {
        this.mmOutStream.write(param1ArrayOfbyte);
        BluetoothService.this.mMode = param1Int;
        if (param1Int == 1);
        return;
      } catch (IOException iOException) {
        Log.e("BluetoothService", "Exception during write");
        return;
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\ClassicBluetooth\BluetoothService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */