package com.drms.drms_drone.Activity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.drms.drms_drone.Communication.ClassicBluetooth.BluetoothService;
import com.drms.drms_drone.Communication.ClassicBluetooth.DeviceListActivity;
import com.drms.drms_drone.Communication.UsbSerial.UsbService;
import com.drms.drms_drone.Controller.DroneController.WaitActivity;
import com.drms.drms_drone.CustomAdapter.CustomAdapter1.Custom1_Item;
import com.drms.drms_drone.CustomAdapter.CustomAdapter1.CustomAdapter1;
import com.drms.drms_drone.FileManagement.FileManagement;
import com.drms.drms_drone.MainView.EtcView;
import com.drms.drms_drone.MainView.Playflight;
import com.drms.drms_drone.MainView.SettingView;
import com.drms.drms_drone.MainView.UploadingView;
import com.drms.drms_drone.MultiData;
import com.drms.drms_drone.Service.BTService;
import com.drms.drms_drone.Sound.SoundManager;

public class DroneMainActivity extends AppCompatActivity implements View.OnSystemUiVisibilityChangeListener {
  public static final boolean D = true;
  
  private static int DISPLAY_LOOP = 2;
  
  private static final int MESSAGE_FROM_USBSERVERICE = 11;
  
  private static final int MESSAGE_READ = 3;
  
  private static final int MESSAGE_STATE_CHANGE = 10;
  
  private static final int MESSAGE_WRITE = 2;
  
  public static final int REQUEST_CAFE = 6;
  
  private static final int REQUEST_CONNECT_DEVICE = 1;
  
  public static final int REQUEST_CONTROLLER = 3;
  
  private static final int REQUEST_ENABLE_BT = 2;
  
  public static final int REQUEST_PROGRAMDRONE = 8;
  
  public static final int REQUEST_SETTING = 4;
  
  public static final int REQUEST_UPLAOD = 5;
  
  public static final int REQUEST_WEB = 7;
  
  private static final int STATE_NO_SENDING = 2;
  
  private static final int STATE_SENDING = 1;
  
  private final ServiceConnection BTConnection = new ServiceConnection() {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        DroneMainActivity.access$502(DroneMainActivity.this, ((BTService.BtBinder)param1IBinder).getService());
        DroneMainActivity.this.mBTService.setHandler(DroneMainActivity.this.mHandler);
        Log.d(DroneMainActivity.this.TAG, "Service : " + String.valueOf(DroneMainActivity.this.mBTService));
        DroneMainActivity.this.mPlayflight.setmBTService(DroneMainActivity.this.mBTService);
        DroneMainActivity.this.mUploadingView.setmBTService(DroneMainActivity.this.mBTService);
        DroneMainActivity.this.mSettingView.setmBTService(DroneMainActivity.this.mBTService);
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        DroneMainActivity.access$502(DroneMainActivity.this, (BTService)null);
        Log.e(DroneMainActivity.this.TAG, "Service Disconnected");
      }
    };
  
  private int BT_Connecting_tries = 0;
  
  private boolean BtDiscoverEnable = false;
  
  private BroadcastReceiver MainReceiver = new BroadcastReceiver() {
      public void onReceive(Context param1Context, Intent param1Intent) {
        String str1;
        String str2 = param1Intent.getAction();
        if ("connected bluetooth in Service".equals(str2)) {
          DroneMainActivity.this.tryConnect.setVisibility(8);
          DroneMainActivity.this.bluetooth.setImageDrawable(DroneMainActivity.this.getResources().getDrawable(2130903045));
          DroneMainActivity.this.bluetooth.setVisibility(0);
          DroneMainActivity.this.device_name.setTextColor(DroneMainActivity.this.getResources().getColor(2131492882));
          DroneMainActivity.this.device_address.setTextColor(DroneMainActivity.this.getResources().getColor(2131492882));
          DroneMainActivity.this.device_name.setText(DroneMainActivity.this.bt_name);
          DroneMainActivity.this.device_address.setText(DroneMainActivity.this.bt_address);
          return;
        } 
        if ("disconnected bluetooth in Service".equals(str2)) {
          Log.d(DroneMainActivity.this.TAG, "in main disconnected");
          DroneMainActivity.this.bluetooth.setImageDrawable(DroneMainActivity.this.getResources().getDrawable(2130903044));
          DroneMainActivity.this.device_name.setTextColor(DroneMainActivity.this.getResources().getColor(2131492883));
          DroneMainActivity.this.device_address.setTextColor(DroneMainActivity.this.getResources().getColor(2131492883));
          DroneMainActivity.this.device_name.setText(" Disconnected...");
          DroneMainActivity.this.mPlayflight.invalidate();
          DroneMainActivity.this.device_address.setText("...");
          DroneMainActivity.access$1702(DroneMainActivity.this, true);
          return;
        } 
        if ("failed bluetooth in Service".equals(str2)) {
          DroneMainActivity.this.bluetooth.setImageDrawable(DroneMainActivity.this.getResources().getDrawable(2130903044));
          DroneMainActivity.this.device_name.setText(" Disconnected...");
          DroneMainActivity.this.device_address.setText("...");
          return;
        } 
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(str2)) {
          str1 = param1Intent.getStringExtra("reason");
          if (str1 != null && str1.equals("homekey")) {
            DroneMainActivity.this.sendBroadcast(new Intent("request nothing"));
            DroneMainActivity.this.sendBroadcast(new Intent("request_finish_service"));
            DroneMainActivity.this.bluetooth.setImageDrawable(DroneMainActivity.this.getResources().getDrawable(2130903044));
            DroneMainActivity.this.device_name.setText(" Disconnected...");
            DroneMainActivity.this.device_address.setText("...");
            DroneMainActivity.this.unregisterReceiver(DroneMainActivity.this.MainReceiver);
            DroneMainActivity.this.unbindService(DroneMainActivity.this.BTConnection);
            DroneMainActivity.this.unbindService(DroneMainActivity.this.usbConnection);
            return;
          } 
          return;
        } 
        if (str2.equals("discover bluetooth")) {
          DroneMainActivity.this.tryConnect.setVisibility(0);
          DroneMainActivity.this.bluetooth.setVisibility(8);
          return;
        } 
        if (str2.equals("discovr failed")) {
          DroneMainActivity.this.bluetooth.setImageDrawable(DroneMainActivity.this.getResources().getDrawable(2130903044));
          DroneMainActivity.this.bluetooth.setVisibility(0);
          DroneMainActivity.this.tryConnect.setVisibility(8);
          return;
        } 
        if (str2.equals("com.felhr.usbservice.USB_PERMISSION_GRANTED")) {
          Log.d(DroneMainActivity.this.TAG, "USB Device is connected -> check Controller\n");
          return;
        } 
        if (str2.equals("com.felhr.usbservice.USB_PERMISSION_NOT_GRANTED")) {
          Toast.makeText((Context)str1, "조종기 권한이 거부되어 연결할 수 없습니다.", 0).show();
          return;
        } 
        if (!str2.equals("com.felhr.usbservice.NO_USB")) {
          TextView textView;
          if (str2.equals("com.felhr.usbservice.USB_DISCONNECTED")) {
            Toast.makeText((Context)str1, "장치가 분리되었습니다", 0).show();
            DroneMainActivity.this.controller.setImageDrawable(DroneMainActivity.this.getResources().getDrawable(2130903054));
            textView = (TextView)DroneMainActivity.this.findViewById(2131558520);
            textView.setText("Controller\ndisconnected");
            textView.setTextColor(DroneMainActivity.this.getResources().getColor(2131492890));
            return;
          } 
          if (str2.equals("com.felhr.usbservice.USB_NOT_SUPPORTED")) {
            Toast.makeText((Context)textView, "USB device not supported", 0).show();
            DroneMainActivity.this.finish();
            return;
          } 
          if (str2.equals("com.drms.drms_drone.CONNECTED_CONTROLLER")) {
            DroneMainActivity.this.controller.setImageDrawable(DroneMainActivity.this.getResources().getDrawable(2130903054));
            textView = (TextView)DroneMainActivity.this.findViewById(2131558520);
            textView.setText("Controller\nConnected");
            textView.setTextColor(-16776961);
            return;
          } 
          if (str2.equals("con.drms.drms_drone.NEXT_DISPLAY")) {
            DroneMainActivity.this.mPlayflight.executeController();
            return;
          } 
          if (str2.equals("com.drms.drms_drone.PREVIOUS_DISPLAY")) {
            DroneMainActivity.this.sendBroadcast(new Intent("request nothing"));
            DroneMainActivity.this.sendBroadcast(new Intent("request_finish_service"));
            DroneMainActivity.this.bluetooth.setImageDrawable(DroneMainActivity.this.getResources().getDrawable(2130903044));
            DroneMainActivity.this.device_name.setText(" Disconnected...");
            DroneMainActivity.this.device_address.setText("...");
            DroneMainActivity.this.unbindService(DroneMainActivity.this.BTConnection);
            DroneMainActivity.this.unbindService(DroneMainActivity.this.usbConnection);
            DroneMainActivity.this.mspdata.setControllerConnected(false);
            DroneMainActivity.this.usbService.write("#bye".getBytes());
            DroneMainActivity.this.finish();
            return;
          } 
        } 
      }
    };
  
  private String TAG = DroneMainActivity.class.getSimpleName();
  
  private ImageView bluetooth;
  
  private String bt_address = "";
  
  private String bt_name = "";
  
  private ImageView controller;
  
  private int count_display = 0;
  
  private TextView device_address;
  
  private TextView device_name;
  
  private LinearLayout etc;
  
  private boolean isReqeustBTConnect = false;
  
  private BTService mBTService;
  
  private BluetoothService mBluetoothService;
  
  private DrawerLayout mDrawerLayout;
  
  private ActionBarDrawerToggle mDrawerToggle;
  
  private EtcView mEtcView;
  
  private FileManagement mFileManagement;
  
  private Handler mHandler = new Handler() {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        switch (param1Message.what) {
          default:
            return;
          case 100:
            DroneMainActivity.this.mPlayflight.invalidate();
            return;
          case 11:
            break;
        } 
        switch (param1Message.arg1) {
          default:
            return;
          case 0:
            Log.d("USBActivity", (String)param1Message.obj);
            return;
          case 1:
            Toast.makeText((Context)DroneMainActivity.this, "CTS_CHANGE", 1).show();
            return;
          case 2:
            break;
        } 
        Toast.makeText((Context)DroneMainActivity.this, "DSR_CHANGE", 1).show();
      }
    };
  
  private Playflight mPlayflight;
  
  private int mSendingState;
  
  private SettingView mSettingView;
  
  private SoundManager mSoundManager;
  
  private UploadingView mUploadingView;
  
  private View.OnTouchListener mainTouchListener = new View.OnTouchListener() {
      public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
        if (param1MotionEvent.getAction() != 0 && param1MotionEvent.getAction() == 1) {
          DroneMainActivity.this.mSoundManager.play(0);
          switch (param1View.getId()) {
            default:
              return true;
            case 2131558517:
              break;
          } 
          DroneMainActivity.this.mDrawerLayout.openDrawer(8388611);
          return true;
        } 
        return true;
      }
    };
  
  private ImageView menu;
  
  private Bitmap menuIcon;
  
  private MultiData mspdata;
  
  private TextView myDevice;
  
  private LinearLayout playflight;
  
  private boolean requestReconnect = false;
  
  private LinearLayout setting;
  
  private ProgressBar tryConnect;
  
  private LinearLayout uploading;
  
  private final ServiceConnection usbConnection = new ServiceConnection() {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        DroneMainActivity.access$1502(DroneMainActivity.this, ((UsbService.UsbBinder)param1IBinder).getService());
        DroneMainActivity.this.usbService.setHandler(DroneMainActivity.this.mHandler);
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        DroneMainActivity.access$1502(DroneMainActivity.this, (UsbService)null);
      }
    };
  
  private UsbService usbService;
  
  private int[] getBitmapSize(int paramInt) {
    try {
      BitmapFactory.Options options = new BitmapFactory.Options();
      options.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(getResources(), paramInt, options);
      paramInt = options.outWidth;
      int i = options.outHeight;
      return new int[] { paramInt, i };
    } catch (Exception exception) {
      return new int[] { 0, 0 };
    } 
  }
  
  private void implementationDrawerList() {
    CustomAdapter1 customAdapter1 = new CustomAdapter1((Context)this);
    customAdapter1.addItem(new Custom1_Item(getResources().getDrawable(2130903074), "나의 디바이스"));
    customAdapter1.addItem(new Custom1_Item(getResources().getDrawable(2130903062), "디바이스 초기화"));
    ListView listView = (ListView)findViewById(2131558509);
    listView.setAdapter((ListAdapter)customAdapter1);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            BluetoothAdapter bluetoothAdapter;
            DroneMainActivity.this.mSoundManager.play(0);
            switch (param1Int) {
              default:
                return;
              case 0:
                bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (bluetoothAdapter == null) {
                  Log.e(DroneMainActivity.this.TAG, "bluetooth is not available");
                  return;
                } 
                Log.d(DroneMainActivity.this.TAG, "Bluetooth is available");
                if (!bluetoothAdapter.isEnabled()) {
                  Intent intent1 = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
                  DroneMainActivity.this.startActivityForResult(intent1, 2);
                  return;
                } 
                DroneMainActivity.this.sendBroadcast(new Intent("request_finish_service"));
                DroneMainActivity.access$202(DroneMainActivity.this, "");
                DroneMainActivity.access$302(DroneMainActivity.this, "");
                DroneMainActivity.this.mFileManagement.writeBtAddressOnFile("", "");
                intent = new Intent((Context)DroneMainActivity.this, DeviceListActivity.class);
                DroneMainActivity.this.mBTService.setisDiscovered(false);
                DroneMainActivity.this.startActivityForResult(intent, 1);
                DroneMainActivity.this.overridePendingTransition(2131034123, 2131034124);
                return;
              case 1:
                DroneMainActivity.this.bluetooth.setImageDrawable(DroneMainActivity.this.getResources().getDrawable(2130903044));
                DroneMainActivity.this.device_name.setText(" Disconnected...");
                DroneMainActivity.this.device_address.setText("...");
                DroneMainActivity.this.mFileManagement.writeBtAddressOnFile("", "");
                Log.d(DroneMainActivity.this.TAG, "initialize Bluetooth Device");
                DroneMainActivity.this.myDevice.setText("No device");
                DroneMainActivity.access$302(DroneMainActivity.this, "");
                DroneMainActivity.access$202(DroneMainActivity.this, "");
                DroneMainActivity.this.sendBroadcast(new Intent("request_finish_service"));
                return;
              case 2:
                break;
            } 
            Intent intent = new Intent((Context)DroneMainActivity.this, ProgrammingDroneActivity.class);
            DroneMainActivity.this.sendBroadcast((new Intent()).setAction("request_program"));
            DroneMainActivity.this.mDrawerLayout.closeDrawer(8388611);
            DroneMainActivity.this.startActivityForResult(intent, 8);
            DroneMainActivity.this.overridePendingTransition(2131034123, 2131034124);
          }
        });
    ((ImageView)findViewById(2131558525)).setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            DroneMainActivity.this.mSoundManager.play(0);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://cafe.naver.com/drmakersystem"));
            DroneMainActivity.this.startActivityForResult(intent, 6);
          }
        });
    ((ImageView)findViewById(2131558526)).setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            DroneMainActivity.this.mSoundManager.play(0);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://drmakersystem.com"));
            DroneMainActivity.this.startActivityForResult(intent, 7);
          }
        });
  }
  
  private void initLayout() {
    this.playflight.setBackgroundColor(getResources().getColor(2131492895));
    this.setting.setBackgroundColor(getResources().getColor(2131492895));
    this.uploading.setBackgroundColor(getResources().getColor(2131492895));
    this.etc.setBackgroundColor(getResources().getColor(2131492895));
  }
  
  private void initializeView() {
    this.playflight = (LinearLayout)findViewById(2131558521);
    this.setting = (LinearLayout)findViewById(2131558522);
    this.uploading = (LinearLayout)findViewById(2131558523);
    this.etc = (LinearLayout)findViewById(2131558524);
    this.mPlayflight = new Playflight((Context)this, (Activity)this);
    this.mPlayflight.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    this.playflight.addView((View)this.mPlayflight);
    this.playflight.invalidate();
    this.mSettingView = new SettingView((Context)this, (Activity)this);
    this.mSettingView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    this.setting.addView((View)this.mSettingView);
    this.mSettingView.invalidate();
    this.mUploadingView = new UploadingView((Context)this, (Activity)this);
    this.mUploadingView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    this.uploading.addView((View)this.mUploadingView);
    this.mUploadingView.invalidate();
    this.mEtcView = new EtcView((Context)this, (Activity)this);
    this.mEtcView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    this.etc.addView((View)this.mEtcView);
    this.mEtcView.invalidate();
    this.controller = (ImageView)findViewById(2131558519);
    Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), 2130903054);
    Bitmap bitmap2 = Bitmap.createBitmap(bitmap1.getWidth(), bitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas2 = new Canvas(bitmap2);
    Paint paint2 = new Paint();
    paint2.setStrokeWidth(8.0F);
    paint2.setColor(getResources().getColor(2131492905));
    canvas2.drawBitmap(bitmap1, 0.0F, 0.0F, null);
    canvas2.drawLine(0.0F, 0.0F, canvas2.getWidth(), canvas2.getHeight(), paint2);
    canvas2.drawLine(canvas2.getWidth(), 0.0F, 0.0F, canvas2.getHeight(), paint2);
    this.controller.setImageDrawable((Drawable)new BitmapDrawable(bitmap2));
    this.menu = (ImageView)findViewById(2131558517);
    int[] arrayOfInt = getBitmapSize(2130903060);
    this.menuIcon = Bitmap.createBitmap(arrayOfInt[0], arrayOfInt[1], Bitmap.Config.ARGB_8888);
    Canvas canvas1 = new Canvas(this.menuIcon);
    Paint paint1 = new Paint();
    paint1.setStrokeWidth(8.0F);
    paint1.setColor(getResources().getColor(2131492904));
    for (int i = 0; i < 3; i++)
      canvas1.drawLine((canvas1.getWidth() / 5), (canvas1.getHeight() * (i + 1) / 4), (canvas1.getWidth() * 4 / 5), (canvas1.getHeight() * (i + 1) / 4), paint1); 
    this.menu.setImageBitmap(this.menuIcon);
    this.menu.setOnTouchListener(this.mainTouchListener);
    this.bluetooth = (ImageView)findViewById(2131558506);
    this.bluetooth.setOnTouchListener(this.mainTouchListener);
    this.tryConnect = (ProgressBar)findViewById(2131558518);
    this.device_name = (TextView)findViewById(2131558502);
    this.device_address = (TextView)findViewById(2131558503);
    this.mSoundManager = new SoundManager((Context)this);
    this.mFileManagement = new FileManagement((Context)this, this.mHandler);
    Log.d(this.TAG, "mFileManager " + this.mFileManagement);
    if (this.mFileManagement.readBTAddress() != null && this.mFileManagement.readBTAddress()[1] != null)
      if (this.mFileManagement.readBTAddress()[1] != "") {
        this.bt_name = this.mFileManagement.readBTAddress()[0];
        this.bt_address = this.mFileManagement.readBTAddress()[1];
      } else {
        this.bt_name = "";
        this.bt_address = "";
      }  
    Log.d(this.TAG, "BT address : " + this.bt_address);
    this.mDrawerLayout = (DrawerLayout)findViewById(2131558504);
    this.myDevice = (TextView)findViewById(2131558508);
    if (this.bt_name != null) {
      if (this.bt_address.length() == 17) {
        this.myDevice.setText(this.bt_name);
      } else {
        this.myDevice.setText("No device");
      } 
    } else {
      this.myDevice.setText("No device");
    } 
    implementationDrawerList();
  }
  
  private void requestSettingBtDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this, 2131362149);
    builder.setTitle("블루투스 장치 선택 안됨");
    builder.setCancelable(false);
    builder.setMessage("블루투스 장치를 선택화면으로 이동하시겠습니까?").setPositiveButton("확인", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (bluetoothAdapter == null) {
              Log.e(DroneMainActivity.this.TAG, "bluetooth is not available");
              return;
            } 
            Log.d(DroneMainActivity.this.TAG, "Bluetooth is available");
            if (!bluetoothAdapter.isEnabled()) {
              Intent intent1 = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
              DroneMainActivity.this.startActivityForResult(intent1, 2);
              return;
            } 
            Intent intent = new Intent((Context)DroneMainActivity.this, DeviceListActivity.class);
            DroneMainActivity.this.startActivityForResult(intent, 1);
            DroneMainActivity.this.overridePendingTransition(2131034123, 2131034124);
          }
        }).setNegativeButton("취소", null).create().show();
  }
  
  private void setFilter() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("connected bluetooth in Service");
    intentFilter.addAction("disconnected bluetooth in Service");
    intentFilter.addAction("failed bluetooth in Service");
    intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    intentFilter.addAction("discover bluetooth");
    intentFilter.addAction("discovr failed");
    intentFilter.addAction("com.felhr.usbservice.USB_PERMISSION_GRANTED");
    intentFilter.addAction("com.felhr.usbservice.NO_USB");
    intentFilter.addAction("com.felhr.usbservice.USB_DISCONNECTED");
    intentFilter.addAction("com.felhr.usbservice.USB_NOT_SUPPORTED");
    intentFilter.addAction("com.felhr.usbservice.USB_PERMISSION_NOT_GRANTED");
    intentFilter.addAction("com.drms.drms_drone.CONNECTED_CONTROLLER");
    intentFilter.addAction("con.drms.drms_drone.NEXT_DISPLAY");
    intentFilter.addAction("com.drms.drms_drone.PREVIOUS_DISPLAY");
    registerReceiver(this.MainReceiver, intentFilter);
  }
  
  private void startDiscoveringBtDevice() {
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (bluetoothAdapter != null) {
      if (bluetoothAdapter.isEnabled()) {
        Intent intent = new Intent();
        intent.setAction("request_connect_bt");
        intent.putExtra("BT", this.bt_address);
        sendBroadcast(intent);
        this.isReqeustBTConnect = false;
        return;
      } 
      startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2);
      return;
    } 
    Log.e(this.TAG, "Bluetooth is not available");
  }
  
  private void startService(Class<?> paramClass, ServiceConnection paramServiceConnection, Bundle paramBundle) {
    Intent intent = new Intent((Context)this, paramClass);
    if (paramBundle != null && !paramBundle.isEmpty())
      for (String str : paramBundle.keySet())
        intent.putExtra(str, paramBundle.getString(str));  
    bindService(new Intent((Context)this, paramClass), paramServiceConnection, 1);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    Log.d(this.TAG, "onActivityResult" + paramInt2);
    switch (paramInt1) {
      default:
        return;
      case 2:
        Log.d(this.TAG, "Result Code : " + paramInt2);
        if (paramInt2 == -1)
          if (this.mFileManagement.readBTAddress() != null) {
            if (this.mFileManagement.readBTAddress()[1] == "") {
              startActivityForResult(new Intent((Context)this, DeviceListActivity.class), 1);
              overridePendingTransition(2131034123, 2131034124);
              return;
            } 
            if (this.bt_address.length() == 17) {
              this.isReqeustBTConnect = false;
              return;
            } 
            requestSettingBtDialog();
            return;
          }  
        Log.d(this.TAG, "Bluetooth is not enable");
        finish();
        return;
      case 1:
        if (paramInt2 == -1) {
          this.mFileManagement.writeBtAddressOnFile(paramIntent.getStringExtra(DeviceListActivity.EXTRA_DEVICE_NAME), paramIntent.getStringExtra(DeviceListActivity.EXTRA_DEVICE_ADDRESS));
          this.bt_address = this.mFileManagement.readBTAddress()[1];
          this.myDevice.setText(this.mFileManagement.readBTAddress()[0]);
          this.bt_name = this.mFileManagement.readBTAddress()[0];
          if (this.bt_address.length() == 17) {
            this.isReqeustBTConnect = false;
          } else {
            Log.e(this.TAG, "not selected ");
          } 
          paramIntent = new Intent();
          paramIntent.setAction("bluetooth address");
          sendBroadcast(paramIntent);
          this.mHandler.postDelayed(new Runnable() {
                public void run() {
                  Intent intent = new Intent();
                  intent.setAction("request_connect_bt");
                  intent.putExtra("BT", DroneMainActivity.this.mFileManagement.readBTAddress()[1]);
                  DroneMainActivity.this.sendBroadcast(intent);
                }
              }500L);
          return;
        } 
      case 3:
        this.mBTService.setHandler(this.mHandler);
        sendBroadcast(new Intent("request main display"));
        if (paramInt2 == 1) {
          this.device_name.setText("disconnected");
          this.device_address.setText("...");
          return;
        } 
      case 4:
        this.mBTService.setHandler(this.mHandler);
        paramIntent = new Intent((Context)this, WaitActivity.class);
        paramIntent.putExtra("request", 1);
        startActivityForResult(paramIntent, 1);
        overridePendingTransition(2131034123, 2131034124);
        sendBroadcast(new Intent("request main display"));
        return;
      case 5:
        this.mBTService.setHandler(this.mHandler);
        paramIntent = new Intent((Context)this, WaitActivity.class);
        paramIntent.putExtra("request", 1);
        startActivityForResult(paramIntent, 1);
        overridePendingTransition(2131034123, 2131034124);
        sendBroadcast(new Intent("request main display"));
        return;
      case 8:
        break;
    } 
    this.mBTService.setHandler(this.mHandler);
    paramIntent = new Intent((Context)this, WaitActivity.class);
    paramIntent.putExtra("request", 1);
    startActivityForResult(paramIntent, 1);
    overridePendingTransition(2131034123, 2131034124);
    sendBroadcast(new Intent("request main display"));
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968608);
    getWindow().addFlags(128);
    this.mspdata = (MultiData)getApplication();
    this.mspdata.initializeMultiData();
    initializeView();
  }
  
  protected void onDestroy() {
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      if (this.mDrawerLayout.isDrawerOpen(8388611)) {
        this.mDrawerLayout.closeDrawer(8388611);
        return true;
      } 
    } else {
      return true;
    } 
    sendBroadcast(new Intent("request nothing"));
    sendBroadcast(new Intent("request_finish_service"));
    this.bluetooth.setImageDrawable(getResources().getDrawable(2130903044));
    this.device_name.setText(" Disconnected...");
    this.device_address.setText("...");
    this.mspdata.setControllerConnected(false);
    this.usbService.write("#bye".getBytes());
    unbindService(this.BTConnection);
    unbindService(this.usbConnection);
    finish();
    return true;
  }
  
  protected void onPause() {
    super.onPause();
    unregisterReceiver(this.MainReceiver);
  }
  
  protected void onRestart() {
    super.onRestart();
    Log.d(this.TAG, "onRestart()");
    Intent intent = new Intent((Context)this, BTService.class);
    setFilter();
    bindService(intent, this.BTConnection, 1);
  }
  
  public void onResume() {
    super.onResume();
    setFilter();
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (bluetoothAdapter != null)
      if (bluetoothAdapter.isEnabled()) {
        startService(BTService.class, this.BTConnection, (Bundle)null);
        startService(UsbService.class, this.usbConnection, (Bundle)null);
      } else {
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2);
      }  
    getWindow().getDecorView().setSystemUiVisibility(4098);
  }
  
  protected void onStop() {
    super.onStop();
    Log.d(this.TAG, "onStop");
    if (this.mBTService != null && this.mBTService.getmBluetoothService() != null && this.mBTService.getmBluetoothService().getState() == 4)
      this.requestReconnect = true; 
  }
  
  public void onSystemUiVisibilityChange(int paramInt) {
    Log.d(this.TAG, "changed");
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Activity\DroneMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */