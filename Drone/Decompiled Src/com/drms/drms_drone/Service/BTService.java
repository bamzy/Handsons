package com.drms.drms_drone.Service;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.util.Log;
import com.drms.drms_drone.Communication.ClassicBluetooth.BluetoothService;
import com.drms.drms_drone.Communication.ClassicBluetooth.DeviceListActivity;
import com.drms.drms_drone.FileManagement.FileManagement;
import com.drms.drms_drone.MultiData;
import com.drms.drms_drone.Protocol.Multiwii.MSP;
import java.util.Locale;

public class BTService extends Service {
  public static final String ArduinoReset = "arduino reset";
  
  public static final String BLUETOOTH_ADDRESS = "bluetooth address";
  
  public static final String CONNECTED_BLUETOOTH = "connected bluetooth in Service";
  
  public static final int CONTROLLER = 1;
  
  public static final boolean D = true;
  
  public static final String DISCONNECTED_BLUETOOTH = "disconnected bluetooth in Service";
  
  public static final String DISCOVER_BT = "discover bluetooth";
  
  public static final String DISCOVER_FAILED = "discovr failed";
  
  public static long DISCOVER_LOOP = 5000L;
  
  public static final String FAILED_BLUETOOTH = "failed bluetooth in Service";
  
  public static final int MAINACTIVITY = 0;
  
  private static final int MESSAGE_READ = 3;
  
  private static final int MESSAGE_STATE_CHANGE = 10;
  
  private static final int MESSAGE_WRITE = 2;
  
  private static final int Multiwii_PROTOCOL = 102;
  
  public static final String NEXT_DISPLAY = "con.drms.drms_drone.NEXT_DISPLAY";
  
  public static final int NOTHIHG = -1;
  
  public static final String PREVIOUS_DISPLAY = "com.drms.drms_drone.PREVIOUS_DISPLAY";
  
  public static final int PROGRAMDRONE = 4;
  
  public static final String REQUEST_ACC_CALIBRATION = "request acc calibration";
  
  public static final String REQUEST_BOX_SETTING = "request box setting";
  
  public static final String REQUEST_CONNECT_BT = "request_connect_bt";
  
  private static final int REQUEST_CONNECT_DEVICE = 1;
  
  public static final String REQUEST_DISPLAY_CONTROLLER = "request controller display";
  
  public static final String REQUEST_DISPLAY_MAIN = "request main display";
  
  public static final String REQUEST_DISPLAY_NOTHING = "request nothing";
  
  public static final String REQUEST_DISPLAY_SETTING = "request display setting";
  
  public static final String REQUEST_DISPLAY_UPLOAD = "request upload display";
  
  private static final int REQUEST_ENABLE_BT = 2;
  
  public static final String REQUEST_FINISH_SERVICE = "request_finish_service";
  
  public static final String REQUEST_MAG_CALIBRATION = "request mag calibration";
  
  public static final String REQUEST_MSP_SET_HEAD = "reqeust set head";
  
  public static final String REQUEST_PID_SETTING = "request pid setting";
  
  public static final String REQUEST_PROGRAMDRONE = "request_program";
  
  public static final String REQUEST_RC_SETTING = "request rc setting";
  
  public static final String REQUEST_SCAN_DEVICE = "request scan device";
  
  public static final int SETTING = 3;
  
  private static final int STATE_NO_SENDING = 2;
  
  private static final int STATE_SENDING = 1;
  
  private static final String TAG = "BTService";
  
  public static final int UPDATE_UI = 100;
  
  public static final int UPLOAD = 2;
  
  private long BTcurrent_t = 0L;
  
  private long BTprev_t = 0L;
  
  private Handler BtHandler = new Handler() {
      public void handleMessage(Message param1Message) {
        Intent intent;
        super.handleMessage(param1Message);
        switch (param1Message.what) {
          default:
            return;
          case 10:
            intent = new Intent();
            switch (param1Message.arg1) {
              default:
                BTService.this.sendBroadcast(intent);
                return;
              case 4:
                BTService.access$102(BTService.this, new MSP(BTService.this.mBluetoothService, BTService.this.MSP_handler));
                Log.d("BTService", "Connected in Service");
                intent.setAction("connected bluetooth in Service");
                intent.putExtra("service", String.valueOf(this));
                if (BTService.this.currentDisplay == 0) {
                  BTService.this.implementationMainDisplayThread();
                } else if (BTService.this.currentDisplay == 1) {
                  BTService.this.implementationControlThread();
                } 
              case 7:
                Log.d("BTService", "Connection Failed");
                intent.setAction("failed bluetooth in Service");
                BTService.this.mBluetoothService.stop();
                BTService.this.sendBroadcast(new Intent("discovr failed"));
              case 8:
                Log.d("BTService", "disconnected");
                new Intent();
                intent.setAction("disconnected bluetooth in Service");
                BTService.this.sendBroadcast(intent);
                if (BTService.this.mFilemanagement.readBTAddress()[1] != "") {
                  BTService.access$802(BTService.this, new BTService.discoverBtDevice());
                  BTService.access$902(BTService.this, true);
                  BTService.this.mDiscoverThread.start();
                } 
              case 1:
                break;
            } 
            Log.d("BTService", "state_none");
            intent.setAction("disconnected bluetooth in Service");
          case 102:
            break;
        } 
        byte[] arrayOfByte = (byte[])param1Message.obj;
        BTService.this.mMSP.readMSP(arrayOfByte);
      }
    };
  
  private BroadcastReceiver BtReceiver = new BroadcastReceiver() {
      public void onReceive(Context param1Context, final Intent intent) {
        final float[] p;
        String str = intent.getAction();
        Log.d("BTService", str);
        if (str.equals("request_connect_bt")) {
          if (BTService.this.mFilemanagement.readBTAddress()[1] != "") {
            BTService.access$1002(BTService.this, intent.getStringExtra("BT"));
            BTService.access$802(BTService.this, new BTService.discoverBtDevice());
            BTService.access$902(BTService.this, true);
            BTService.this.mDiscoverThread.start();
          } 
          return;
        } 
        if (str.equals("request_finish_service")) {
          if (BTService.this.mBluetoothService != null) {
            BTService.this.mBluetoothService.stop();
            if (BTService.this.mFilemanagement.readBTAddress() != null)
              BTService.access$1002(BTService.this, BTService.this.mFilemanagement.readBTAddress()[1]); 
            Log.d("BTService", "bt_address in Service : " + BTService.this.bt_address);
            return;
          } 
          return;
        } 
        if (str.equals("request controller display")) {
          Log.d("BTService", "Bluetooth State : + " + BTService.this.mBluetoothService.getState());
          BTService.access$402(BTService.this, 1);
          BTService.this.implementationControlThread();
          Log.d("BTService", "Received Request Controller BroadCast ");
          return;
        } 
        if (str.equals("request_program")) {
          Log.d("BTService", "program Drone Mode");
          BTService.access$402(BTService.this, 4);
          BTService.this.implementationProgramThread();
          return;
        } 
        if (str.equals("bluetooth address")) {
          BTService.access$1002(BTService.this, intent.getStringExtra("BT"));
          Log.d("BTService", "BT address in Service : " + BTService.this.bt_address);
          return;
        } 
        if (str.equals("request upload display")) {
          Log.d("BTService", "preparing upload");
          BTService.access$402(BTService.this, 2);
          BTService.this.mBluetoothService.setProtocol("STK");
          return;
        } 
        if (str.equals("request main display")) {
          Log.d("BTService", "request main display");
          BTService.this.mBluetoothService.setProtocol("MSP");
          BTService.this.BtHandler.postDelayed(new Runnable() {
                public void run() {
                  BTService.this.implementationMainDisplayThread();
                  BTService.access$402(BTService.this, 0);
                  BTService.this.mBluetoothService.setmHandler(BTService.this.BtHandler);
                }
              }1000L);
          return;
        } 
        if (str.equals("request acc calibration")) {
          Log.d("BTService", "request acc Calibration");
          BTService.access$1302(BTService.this, true);
          try {
            Thread.sleep(300L);
          } catch (InterruptedException null) {}
          BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(205));
          BTService.this.tts.speak("가속도 센서 교정을 시작합니다.", 0, null);
          return;
        } 
        if (interruptedException.equals("request mag calibration")) {
          Log.d("BTService", "request mag Calibration");
          BTService.access$1302(BTService.this, true);
          try {
            Thread.sleep(300L);
          } catch (InterruptedException interruptedException) {}
          BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(206));
          BTService.this.tts.speak("지자계 센서 교정을 시작합니다.", 0, null);
          return;
        } 
        if (interruptedException.equals("reqeust set head")) {
          int i = intent.getIntExtra("head", 0);
          Log.d("BTService", "heading : " + i);
          return;
        } 
        if (interruptedException.equals("request display setting")) {
          Log.d("BTService", (String)interruptedException);
          BTService.this.mBluetoothService.setProtocol("MSP");
          BTService.this.BtHandler.postDelayed(new Runnable() {
                public void run() {
                  BTService.this.implementationSettingThread();
                  BTService.access$402(BTService.this, 3);
                  BTService.this.mBluetoothService.setmHandler(BTService.this.BtHandler);
                }
              }1000L);
          return;
        } 
        if (interruptedException.equals("request box setting")) {
          BTService.access$402(BTService.this, -1);
          BTService.this.mainHandler.postDelayed(new Runnable() {
                public void run() {
                  BTService.this.mMSP.sendRequestMSP_SET_BOX(BTService.this.mspData.getCheckboxData());
                  int i = intent.getIntExtra("REQUEST_BACK", 0);
                  if (i == 0) {
                    BTService.this.mainHandler.postDelayed(new Runnable() {
                          public void run() {
                            BTService.access$402(BTService.this, 3);
                            BTService.this.implementationSettingThread();
                          }
                        }1000L);
                    return;
                  } 
                  if (i == -1) {
                    Log.d("BTService", "go to Main");
                    return;
                  } 
                }
              }500L);
          return;
        } 
        if (interruptedException.equals("request rc setting")) {
          BTService.access$402(BTService.this, -1);
          BTService.this.mainHandler.postDelayed(new Runnable() {
                public void run() {
                  BTService.this.mMSP.SendRequestMSP_SET_RC_TUNING(BTService.this.mspData.getRCTUNEdata());
                  BTService.this.mMSP.SendRequestMSP_SET_MISC((int)BTService.this.mspData.getMISCdata()[0], (int)BTService.this.mspData.getMISCdata()[1], (int)BTService.this.mspData.getMISCdata()[2], (int)BTService.this.mspData.getMISCdata()[3], (int)BTService.this.mspData.getMISCdata()[4], BTService.this.mspData.getMISCdata()[7], (int)BTService.this.mspData.getMISCdata()[8], BTService.this.mspData.getMISCdata()[9], BTService.this.mspData.getMISCdata()[10], BTService.this.mspData.getMISCdata()[11]);
                  int i = intent.getIntExtra("REQUEST_BACK", 0);
                  if (i == 0) {
                    BTService.this.mainHandler.postDelayed(new Runnable() {
                          public void run() {
                            BTService.access$402(BTService.this, 3);
                            BTService.this.implementationSettingThread();
                          }
                        }1000L);
                    return;
                  } 
                  if (i == -1) {
                    Log.d("BTService", "go to Main");
                    return;
                  } 
                }
              }500L);
          return;
        } 
        if (interruptedException.equals("request pid setting")) {
          arrayOfFloat = intent.getFloatArrayExtra("P");
          final float[] i = intent.getFloatArrayExtra("I");
          final float[] d = intent.getFloatArrayExtra("D");
          BTService.access$402(BTService.this, -1);
          BTService.this.mainHandler.postDelayed(new Runnable() {
                public void run() {
                  BTService.this.mMSP.SendRequestMSP_SET_PID_TUNING(p, i, d);
                  int i = intent.getIntExtra("REQUEST_BACK", 0);
                  if (i == 0) {
                    BTService.this.mainHandler.postDelayed(new Runnable() {
                          public void run() {
                            BTService.access$402(BTService.this, 3);
                            BTService.this.implementationSettingThread();
                          }
                        }1000L);
                    return;
                  } 
                  if (i == -1) {
                    Log.d("BTService", "go to Main");
                    return;
                  } 
                }
              }500L);
          return;
        } 
        if (arrayOfFloat.equals("disconnected bluetooth in Service")) {
          if (BTService.this.mBluetoothService != null) {
            BTService.this.mBluetoothService.stop();
            return;
          } 
          return;
        } 
        if (arrayOfFloat.equals("con.drms.drms_drone.NEXT_DISPLAY")) {
          if (BTService.this.currentDisplay == 0) {
            BTService.this.tts.speak("조종기 화면으로 이동합니다.", 0, null);
            return;
          } 
          if (BTService.this.currentDisplay == 1) {
            BTService.this.tts.speak("설정", 0, null);
            return;
          } 
          return;
        } 
        if (arrayOfFloat.equals("com.drms.drms_drone.PREVIOUS_DISPLAY")) {
          if (BTService.this.currentDisplay == 0) {
            BTService.this.tts.speak("어플리케이션을 종료합니다 ", 0, null);
            return;
          } 
          if (BTService.this.currentDisplay == 1) {
            BTService.this.tts.speak("조종기 화면을 종료합니다.", 0, null);
            return;
          } 
        } 
      }
    };
  
  private Handler MSP_handler = new Handler() {
      public void handleMessage(Message param1Message) {
        int[] arrayOfInt;
        int i;
        super.handleMessage(param1Message);
        BTService.access$1802(BTService.this, BTService.this.BTcurrent_t);
        BTService.access$1902(BTService.this, System.currentTimeMillis());
        switch (param1Message.what) {
          default:
            return;
          case 114:
            BTService.this.mspData.setMISCdata((float[])param1Message.obj);
            return;
          case 111:
            BTService.this.mspData.setRCTUNEdata((float[])param1Message.obj);
            return;
          case 110:
            BTService.this.mspData.setAnalogData((float[])param1Message.obj);
            return;
          case 105:
            BTService.this.mspData.setReceivedRcdata((int[])param1Message.obj);
            return;
          case 108:
            BTService.this.mspData.setAttitudeData((float[])param1Message.obj);
            BTService.this.mainHandler.obtainMessage(100).sendToTarget();
            return;
          case 205:
            BTService.this.mspData.setACCCalibration(false);
            Log.d("BTService", "received acc cali");
            BTService.this.tts.speak("가속도 센서 교정이 완료되었습니다.", 1, null);
            BTService.access$1302(BTService.this, false);
            for (i = 1; i < 4; i++)
              BTService.this.mspData.setRawRCDataAux(i, 1000); 
            BTService.this.mainHandler.postDelayed(new Runnable() {
                  public void run() {
                    if (BTService.this.currentDisplay == 1)
                      BTService.this.implementationControlThread(); 
                  }
                },  500L);
            return;
          case 206:
            BTService.this.mainHandler.postDelayed(new Runnable() {
                  public void run() {
                    BTService.this.mspData.setMAGCalibration(false);
                    Log.d("BTService", "received mag cali");
                    BTService.this.tts.speak("지자계 센서 교정이 완료되었습니다.", 1, null);
                    BTService.access$1302(BTService.this, false);
                    for (int i = 1; i < 4; i++)
                      BTService.this.mspData.setRawRCDataAux(i, 1000); 
                    BTService.this.mainHandler.postDelayed(new Runnable() {
                          public void run() {
                            if (BTService.this.currentDisplay == 1)
                              BTService.this.implementationControlThread(); 
                          }
                        },  500L);
                  }
                }30000L);
            return;
          case 211:
            Log.w("BTService", "set Header");
            return;
          case 102:
            BTService.this.mspData.setIMUdata((int[])param1Message.obj);
            arrayOfInt = (int[])param1Message.obj;
            BTService.this.mainHandler.obtainMessage(100).sendToTarget();
            return;
          case 113:
            BTService.this.mspData.setCheckboxData((boolean[][])((Message)arrayOfInt).obj);
            Log.d("BTService", "received checkbox");
            return;
          case 112:
            BTService.this.mspData.setPIDdata((int[])((Message)arrayOfInt).obj);
            Log.d("BTService", "received pid data");
            return;
          case 116:
            BTService.this.mspData.initBoxITEM((String[])((Message)arrayOfInt).obj);
            Log.d("BTService", "set Box Name");
            return;
          case 109:
            break;
        } 
        BTService.this.mspData.setALTITUDEdata((float[])((Message)arrayOfInt).obj);
      }
    };
  
  public IBinder binder = (IBinder)new BtBinder();
  
  private String bt_address = "";
  
  boolean checkData = false;
  
  private int count = 0;
  
  private int currentDisplay = 0;
  
  private boolean isDiscovered = false;
  
  private boolean isDoCalibration = false;
  
  private boolean isProcessed = false;
  
  private boolean isServiceOn = false;
  
  private BluetoothService mBluetoothService;
  
  private Thread mDiscoverThread;
  
  private FileManagement mFilemanagement;
  
  private MSP mMSP;
  
  private int mSendingState;
  
  private Handler mainHandler;
  
  private MultiData mspData;
  
  private long prev_t = 0L;
  
  private TextToSpeech tts;
  
  private void implementationControlThread() {
    Log.d("BTService", "implementationControlThread");
    (new Thread(new Runnable() {
          public void run() {
            while (true) {
              if (BTService.this.currentDisplay == 1 && !BTService.this.isDoCalibration) {
                if (BTService.this.mBluetoothService != null) {
                  if (BTService.this.mMSP == null)
                    BTService.access$102(BTService.this, new MSP(BTService.this.mBluetoothService, BTService.this.MSP_handler)); 
                  if (BTService.this.mBluetoothService.getState() == 4) {
                    BTService.access$1702(BTService.this, System.currentTimeMillis());
                    BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(108));
                    try {
                      if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                        Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                    } catch (InterruptedException interruptedException) {}
                    BTService.access$1702(BTService.this, System.currentTimeMillis());
                    BTService.this.mMSP.sendRequestMSP_SET_RAW_RC(BTService.this.mspData.getRcdata());
                    try {
                      if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                        Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                    } catch (InterruptedException interruptedException) {}
                    BTService.access$1702(BTService.this, System.currentTimeMillis());
                    BTService.this.mMSP.sendRequestMSP_SET_RAW_RC(BTService.this.mspData.getRcdata());
                    try {
                      if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                        Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                    } catch (InterruptedException interruptedException) {}
                    BTService.access$1702(BTService.this, System.currentTimeMillis());
                    BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(110));
                    try {
                      if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                        Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                    } catch (InterruptedException interruptedException) {}
                    BTService.access$1702(BTService.this, System.currentTimeMillis());
                    BTService.this.mMSP.sendRequestMSP_SET_RAW_RC(BTService.this.mspData.getRcdata());
                    try {
                      if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                        Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                    } catch (InterruptedException interruptedException) {}
                    BTService.access$1702(BTService.this, System.currentTimeMillis());
                    BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(105));
                    try {
                      if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                        Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                    } catch (InterruptedException interruptedException) {}
                    continue;
                  } 
                  return;
                } 
                continue;
              } 
              return;
            } 
          }
        })).start();
  }
  
  private void implementationMainDisplayThread() {
    (new Thread(new Runnable() {
          public void run() {
            while (true) {
              if (BTService.this.currentDisplay == 0) {
                if (BTService.this.mBluetoothService != null) {
                  if (BTService.this.mMSP == null)
                    BTService.access$102(BTService.this, new MSP(BTService.this.mBluetoothService, BTService.this.MSP_handler)); 
                  if (BTService.this.mBluetoothService.getState() == 4) {
                    BTService.access$1702(BTService.this, System.currentTimeMillis());
                    BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(108));
                    try {
                      if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                        Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                    } catch (InterruptedException interruptedException) {}
                    BTService.access$1702(BTService.this, System.currentTimeMillis());
                    BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(110));
                    try {
                      if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                        Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                    } catch (InterruptedException interruptedException) {}
                    continue;
                  } 
                  return;
                } 
                continue;
              } 
              return;
            } 
          }
        })).start();
  }
  
  private void implementationProgramThread() {
    Log.d("BTService", "implementation Program Thread");
    (new Thread(new Runnable() {
          public void run() {
            while (BTService.this.currentDisplay == 4) {
              if (BTService.this.mBluetoothService != null && BTService.this.mMSP != null) {
                BTService.access$1702(BTService.this, System.currentTimeMillis());
                BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(109));
                try {
                  if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                    Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                } catch (InterruptedException interruptedException) {}
              } 
            } 
          }
        })).start();
  }
  
  private void implementationSettingThread() {
    Log.d("BTService", "implementationSettingThread");
    this.checkData = false;
    (new Thread(new Runnable() {
          public void run() {
            while (true) {
              if (BTService.this.currentDisplay == 3 && !BTService.this.isDoCalibration) {
                if (BTService.this.mBluetoothService != null) {
                  if (BTService.this.mMSP == null)
                    BTService.access$102(BTService.this, new MSP(BTService.this.mBluetoothService, BTService.this.MSP_handler)); 
                  if (BTService.this.mBluetoothService.getState() == 4) {
                    BTService.access$1702(BTService.this, System.currentTimeMillis());
                    BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(108));
                    try {
                      if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                        Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                    } catch (InterruptedException interruptedException) {}
                    BTService.access$1702(BTService.this, System.currentTimeMillis());
                    BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(110));
                    try {
                      if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                        Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                    } catch (InterruptedException interruptedException) {}
                    BTService.access$1702(BTService.this, System.currentTimeMillis());
                    BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(102));
                    try {
                      if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                        Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                    } catch (InterruptedException interruptedException) {}
                    if (!BTService.this.checkData) {
                      BTService.access$1702(BTService.this, System.currentTimeMillis());
                      BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(116));
                      try {
                        if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                          Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                      } catch (InterruptedException interruptedException) {}
                      BTService.access$1702(BTService.this, System.currentTimeMillis());
                      BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(114));
                      try {
                        if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                          Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                      } catch (InterruptedException interruptedException) {}
                      BTService.access$1702(BTService.this, System.currentTimeMillis());
                      BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(111));
                      try {
                        if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                          Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                      } catch (InterruptedException interruptedException) {}
                      BTService.access$1702(BTService.this, System.currentTimeMillis());
                      BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(113));
                      try {
                        if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                          Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                      } catch (InterruptedException interruptedException) {}
                      BTService.access$1702(BTService.this, System.currentTimeMillis());
                      BTService.this.mMSP.sendRequestMSP(BTService.this.mMSP.requestMSP(112));
                      try {
                        if (BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t > 0L)
                          Thread.sleep(BTService.this.mspData.getMSP_TIME() - System.currentTimeMillis() - BTService.this.prev_t); 
                      } catch (InterruptedException interruptedException) {}
                      BTService.this.checkData = true;
                    } 
                    continue;
                  } 
                  return;
                } 
                continue;
              } 
              return;
            } 
          }
        })).start();
  }
  
  private void setFilter() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("request_connect_bt");
    intentFilter.addAction("request_finish_service");
    intentFilter.addAction("request main display");
    intentFilter.addAction("request_program");
    intentFilter.addAction("request controller display");
    intentFilter.addAction("request nothing");
    intentFilter.addAction("request upload display");
    intentFilter.addAction("request acc calibration");
    intentFilter.addAction("request mag calibration");
    intentFilter.addAction("reqeust set head");
    intentFilter.addAction("request display setting");
    intentFilter.addAction("request box setting");
    intentFilter.addAction("request rc setting");
    intentFilter.addAction("request pid setting");
    intentFilter.addAction("con.drms.drms_drone.NEXT_DISPLAY");
    intentFilter.addAction("com.drms.drms_drone.PREVIOUS_DISPLAY");
    registerReceiver(this.BtReceiver, intentFilter);
  }
  
  public int getCurrentDisplay() {
    return this.currentDisplay;
  }
  
  public MultiData getMspData() {
    return this.mspData;
  }
  
  public boolean getisDiscovered() {
    return this.isDiscovered;
  }
  
  public BluetoothService getmBluetoothService() {
    return this.mBluetoothService;
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent) {
    return this.binder;
  }
  
  public void onCreate() {
    super.onCreate();
    Log.d("BTService", "onCreate Service");
    Log.d("BTService", "start BTService");
    this.mBluetoothService = new BluetoothService(this, this.BtHandler, "MSP");
    setFilter();
    this.currentDisplay = 0;
    this.mspData = (MultiData)getApplication();
    Log.d("BTService", "start discovering");
    this.isServiceOn = true;
    this.mFilemanagement = new FileManagement((Context)this, this.mainHandler);
    if (this.mFilemanagement.readBTAddress() != null)
      if (this.mFilemanagement.readBTAddress()[1] == "") {
        this.bt_address = "";
      } else {
        this.bt_address = this.mFilemanagement.readBTAddress()[1];
      }  
    if (this.tts == null)
      this.tts = new TextToSpeech((Context)this, new TextToSpeech.OnInitListener() {
            public void onInit(int param1Int) {
              BTService.this.tts.setLanguage(Locale.KOREAN);
            }
          }); 
    Log.d("BTService", this.bt_address);
    BluetoothAdapter.getDefaultAdapter();
    if (this.mFilemanagement.readBTAddress() != null && this.mFilemanagement.readBTAddress()[1] != "") {
      Log.d("BTService", "trying to connect BT ");
      this.mDiscoverThread = new discoverBtDevice();
      this.isDiscovered = true;
      this.mDiscoverThread.start();
    } 
  }
  
  public void onDestroy() {
    this.isServiceOn = false;
    super.onDestroy();
    if (this.tts != null)
      this.tts.shutdown(); 
    unregisterReceiver(this.BtReceiver);
    Log.d("BTService", "onDestroy() on BTService");
  }
  
  public void setCurrentDisplay(int paramInt) {
    this.currentDisplay = paramInt;
  }
  
  public void setHandler(Handler paramHandler) {
    this.mainHandler = paramHandler;
  }
  
  public void setisDiscovered(boolean paramBoolean) {
    this.isDiscovered = paramBoolean;
  }
  
  public class BtBinder extends Binder {
    public BTService getService() {
      return BTService.this;
    }
  }
  
  public class discoverBtDevice extends Thread {
    public void run() {
      super.run();
      while (true) {
        if (BTService.this.isServiceOn && BTService.this.isDiscovered) {
          if (BTService.this.mBluetoothService != null) {
            if (BTService.this.mBluetoothService.getState() == 2 || BTService.this.mBluetoothService.getState() == 1) {
              if (BTService.this.bt_address.length() == 17) {
                BTService.this.sendBroadcast(new Intent("discover bluetooth"));
                Log.d("BTService", "trying to connect BT");
                BTService.access$202(BTService.this, (BluetoothService)null);
                BTService.access$202(BTService.this, new BluetoothService(BTService.this, BTService.this.BtHandler, "MSP"));
                Intent intent = new Intent();
                intent.putExtra(DeviceListActivity.EXTRA_DEVICE_ADDRESS, BTService.this.bt_address);
                BTService.this.mBluetoothService.getDeviceInfo(intent);
              } else {
                Log.w("BTService", "Bluetooth Address is null");
              } 
            } else {
              if (BTService.this.mBluetoothService.getState() == 4) {
                Log.w("BTService", "Bluetooth is already connected");
                return;
              } 
              if (BTService.this.mBluetoothService.getState() == 3)
                Log.w("BTService", "Bluetooth is connecting"); 
            } 
          } else {
            Log.e("BTService", "mBluetoothService is null");
          } 
          try {
            sleep(BTService.DISCOVER_LOOP);
            continue;
          } catch (InterruptedException interruptedException) {
            Log.e("BTService", "InterruptedException during discovering BT Device", interruptedException);
          } 
        } 
        return;
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Service\BTService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */