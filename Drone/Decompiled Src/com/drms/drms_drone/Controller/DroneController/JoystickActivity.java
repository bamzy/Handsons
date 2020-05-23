package com.drms.drms_drone.Controller.DroneController;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.drms.drms_drone.MultiData;
import com.drms.drms_drone.Service.BTService;
import com.drms.drms_drone.Sound.SoundManager;

public class JoystickActivity extends AppCompatActivity {
  public static final int REQUEST_JOYSTICK_MENU = 0;
  
  public static final int REQUEST_WAIT = 0;
  
  private static final String TAG = "JoystickActivity";
  
  private final ServiceConnection BTConnection = new ServiceConnection() {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        JoystickActivity.access$002(JoystickActivity.this, ((BTService.BtBinder)param1IBinder).getService());
        JoystickActivity.this.mBTService.setHandler(JoystickActivity.this.JoystickHandler);
        Log.d("JoystickActivity", "Service : " + String.valueOf(JoystickActivity.this.mBTService));
        if (!JoystickActivity.this.mspdata.isControllerConnected()) {
          if (JoystickActivity.this.mDualJoystickView != null)
            JoystickActivity.this.mDualJoystickView.setmBluetoothService(JoystickActivity.this.mBTService.getmBluetoothService()); 
          if (JoystickActivity.this.mSingleJoystickView != null);
          return;
        } 
        if (JoystickActivity.this.mDrsControllerView != null) {
          JoystickActivity.this.mDrsControllerView.setmBluetoothService(JoystickActivity.this.mBTService.getmBluetoothService());
          return;
        } 
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        JoystickActivity.access$002(JoystickActivity.this, (BTService)null);
        Log.e("JoystickActivity", "Service Disconnected");
      }
    };
  
  private DrawerLayout Joystick1_drawer_layout;
  
  private Handler JoystickHandler = new Handler() {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        switch (param1Message.what) {
          default:
            return;
          case 100:
            if (!JoystickActivity.this.mspdata.isControllerConnected()) {
              if (JoystickActivity.this.mDualJoystickView != null)
                JoystickActivity.this.mDualJoystickView.invalidate(); 
              if (JoystickActivity.this.mSingleJoystickView != null) {
                JoystickActivity.this.mSingleJoystickView.invalidate();
                return;
              } 
            } 
            if (JoystickActivity.this.mDrsControllerView != null);
            JoystickActivity.this.mDrsControllerView.invalidate();
            return;
          case 0:
            break;
        } 
        if (JoystickActivity.this.mspdata.getReceivedRcdata()[3] <= 1050) {
          JoystickActivity.this.implementationJoystickSettingMenu();
          return;
        } 
        Toast.makeText(JoystickActivity.this.getApplicationContext(), "드론이 비행 중 입니다.", 0).show();
      }
    };
  
  private BroadcastReceiver JoystickReceiver = new BroadcastReceiver() {
      public void onReceive(Context param1Context, Intent param1Intent) {
        // Byte code:
        //   0: aload_2
        //   1: invokevirtual getAction : ()Ljava/lang/String;
        //   4: astore_1
        //   5: aload_1
        //   6: ldc 'android.intent.action.BATTERY_CHANGED'
        //   8: invokevirtual equals : (Ljava/lang/Object;)Z
        //   11: ifeq -> 79
        //   14: aload_0
        //   15: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   18: aload_2
        //   19: ldc 'level'
        //   21: iconst_0
        //   22: invokevirtual getIntExtra : (Ljava/lang/String;I)I
        //   25: putfield battery_level : I
        //   28: ldc 'JoystickActivity'
        //   30: new java/lang/StringBuilder
        //   33: dup
        //   34: invokespecial <init> : ()V
        //   37: ldc 'vbat : '
        //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   42: aload_0
        //   43: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   46: getfield battery_level : I
        //   49: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   52: invokevirtual toString : ()Ljava/lang/String;
        //   55: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   58: pop
        //   59: aload_0
        //   60: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   63: invokevirtual getApplication : ()Landroid/app/Application;
        //   66: checkcast com/drms/drms_drone/MultiData
        //   69: aload_0
        //   70: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   73: getfield battery_level : I
        //   76: invokevirtual setMobile_vbat : (I)V
        //   79: aload_1
        //   80: ldc 'disconnected bluetooth in Service'
        //   82: invokevirtual equals : (Ljava/lang/Object;)Z
        //   85: ifeq -> 114
        //   88: aload_0
        //   89: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   92: invokestatic access$000 : (Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Service/BTService;
        //   95: iconst_0
        //   96: invokevirtual setCurrentDisplay : (I)V
        //   99: aload_0
        //   100: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   103: iconst_m1
        //   104: invokevirtual setResult : (I)V
        //   107: aload_0
        //   108: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   111: invokevirtual finish : ()V
        //   114: aload_1
        //   115: ldc 'request dual1'
        //   117: invokevirtual equals : (Ljava/lang/Object;)Z
        //   120: ifne -> 132
        //   123: aload_1
        //   124: ldc 'request dual2'
        //   126: invokevirtual equals : (Ljava/lang/Object;)Z
        //   129: ifeq -> 222
        //   132: aload_0
        //   133: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   136: invokestatic access$300 : (Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
        //   139: invokevirtual getmSensorManager : ()Landroid/hardware/SensorManager;
        //   142: ifnull -> 189
        //   145: aload_0
        //   146: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   149: invokestatic access$300 : (Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
        //   152: invokevirtual getmSensorEventListener : ()Landroid/hardware/SensorEventListener;
        //   155: ifnull -> 189
        //   158: ldc 'JoystickActivity'
        //   160: ldc 'unregister Listener'
        //   162: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   165: pop
        //   166: aload_0
        //   167: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   170: invokestatic access$300 : (Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
        //   173: invokevirtual getmSensorManager : ()Landroid/hardware/SensorManager;
        //   176: aload_0
        //   177: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   180: invokestatic access$300 : (Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
        //   183: invokevirtual getmSensorEventListener : ()Landroid/hardware/SensorEventListener;
        //   186: invokevirtual unregisterListener : (Landroid/hardware/SensorEventListener;)V
        //   189: ldc 'JoystickActivity'
        //   191: new java/lang/StringBuilder
        //   194: dup
        //   195: invokespecial <init> : ()V
        //   198: ldc 'received Message : '
        //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   203: aload_1
        //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   207: invokevirtual toString : ()Ljava/lang/String;
        //   210: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   213: pop
        //   214: aload_0
        //   215: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   218: aload_1
        //   219: invokestatic access$700 : (Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;Ljava/lang/String;)V
        //   222: aload_1
        //   223: ldc 'request single'
        //   225: invokevirtual equals : (Ljava/lang/Object;)Z
        //   228: ifeq -> 321
        //   231: aload_0
        //   232: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   235: invokestatic access$300 : (Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
        //   238: invokevirtual getmSensorManager : ()Landroid/hardware/SensorManager;
        //   241: ifnull -> 288
        //   244: aload_0
        //   245: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   248: invokestatic access$300 : (Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
        //   251: invokevirtual getmSensorEventListener : ()Landroid/hardware/SensorEventListener;
        //   254: ifnull -> 288
        //   257: ldc 'JoystickActivity'
        //   259: ldc 'unregister Listener'
        //   261: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   264: pop
        //   265: aload_0
        //   266: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   269: invokestatic access$300 : (Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
        //   272: invokevirtual getmSensorManager : ()Landroid/hardware/SensorManager;
        //   275: aload_0
        //   276: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   279: invokestatic access$300 : (Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
        //   282: invokevirtual getmSensorEventListener : ()Landroid/hardware/SensorEventListener;
        //   285: invokevirtual unregisterListener : (Landroid/hardware/SensorEventListener;)V
        //   288: ldc 'JoystickActivity'
        //   290: new java/lang/StringBuilder
        //   293: dup
        //   294: invokespecial <init> : ()V
        //   297: ldc 'received Message : '
        //   299: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   302: aload_1
        //   303: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   306: invokevirtual toString : ()Ljava/lang/String;
        //   309: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   312: pop
        //   313: aload_0
        //   314: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   317: aload_1
        //   318: invokestatic access$700 : (Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;Ljava/lang/String;)V
        //   321: aload_1
        //   322: ldc 'arduino reset'
        //   324: invokevirtual equals : (Ljava/lang/Object;)Z
        //   327: ifeq -> 337
        //   330: aload_0
        //   331: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   334: invokevirtual finish : ()V
        //   337: aload_1
        //   338: ldc 'con.drms.drms_drone.NEXT_DISPLAY'
        //   340: invokevirtual equals : (Ljava/lang/Object;)Z
        //   343: ifeq -> 346
        //   346: aload_1
        //   347: ldc 'com.drms.drms_drone.PREVIOUS_DISPLAY'
        //   349: invokevirtual equals : (Ljava/lang/Object;)Z
        //   352: ifeq -> 362
        //   355: aload_0
        //   356: getfield this$0 : Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
        //   359: invokevirtual finish : ()V
        //   362: return
      }
    };
  
  int battery_level = 0;
  
  private LinearLayout joystick_layout;
  
  private BTService mBTService;
  
  private DrsControllerView mDrsControllerView;
  
  private Joystick_view mDualJoystickView;
  
  private SingleJoystickView mSingleJoystickView;
  
  private SoundManager mSoundManager;
  
  private MultiData mspdata;
  
  private void implementationJoystickSettingMenu() {
    startActivity(new Intent((Context)this, JoystickSettingActivity.class));
    overridePendingTransition(2131034125, 2131034124);
  }
  
  private void setFilter() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
    intentFilter.addAction("disconnected bluetooth in Service");
    intentFilter.addAction("request dual1");
    intentFilter.addAction("request dual2");
    intentFilter.addAction("request single");
    intentFilter.addAction("arduino reset");
    intentFilter.addAction("com.drms.drms_drone.PREVIOUS_DISPLAY");
    intentFilter.addAction("con.drms.drms_drone.NEXT_DISPLAY");
    registerReceiver(this.JoystickReceiver, intentFilter);
  }
  
  private void startService(Class<?> paramClass, ServiceConnection paramServiceConnection, Bundle paramBundle) {
    Intent intent = new Intent((Context)this, paramClass);
    if (paramBundle != null && !paramBundle.isEmpty())
      for (String str : paramBundle.keySet())
        intent.putExtra(str, paramBundle.getString(str));  
    bindService(new Intent((Context)this, paramClass), paramServiceConnection, 1);
  }
  
  private void updateJoystick(String paramString) {
    if (this.mDualJoystickView != null) {
      this.joystick_layout.removeAllViews();
      this.mDualJoystickView = null;
      this.mSingleJoystickView = null;
    } 
    if (paramString.equals("request dual1")) {
      setRequestedOrientation(0);
      this.mDualJoystickView = new Dual1JoystickView((Context)this, (Activity)this, this.JoystickHandler);
      this.joystick_layout.addView(this.mDualJoystickView);
      this.mDualJoystickView.setmBluetoothService(this.mBTService.getmBluetoothService());
      return;
    } 
    if (paramString.equals("request dual2")) {
      setRequestedOrientation(0);
      this.mDualJoystickView = new Dual2JoystickView((Context)this, (Activity)this, this.JoystickHandler);
      this.joystick_layout.addView(this.mDualJoystickView);
      this.mDualJoystickView.setmBluetoothService(this.mBTService.getmBluetoothService());
      return;
    } 
    if (paramString.equals("request single")) {
      setRequestedOrientation(1);
      this.mSingleJoystickView = new SingleJoystickView((Context)this);
      this.joystick_layout.addView(this.mSingleJoystickView);
      return;
    } 
  }
  
  public void finish() {
    super.finish();
    overridePendingTransition(2131034124, 2131034122);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968609);
    getWindow().getDecorView().setSystemUiVisibility(4098);
    this.joystick_layout = (LinearLayout)findViewById(2131558528);
    this.mspdata = (MultiData)getApplication();
    if (!this.mspdata.isControllerConnected()) {
      if (this.mspdata.getMYJOYSTICK() == 0) {
        this.mDualJoystickView = new Dual1JoystickView((Context)this, (Activity)this, this.JoystickHandler);
        this.mDualJoystickView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.joystick_layout.addView(this.mDualJoystickView);
      } else if (this.mspdata.getMYJOYSTICK() == 1) {
        this.mDualJoystickView = new Dual2JoystickView((Context)this, (Activity)this, this.JoystickHandler);
        this.mDualJoystickView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.joystick_layout.addView(this.mDualJoystickView);
      } else if (this.mspdata.getMYJOYSTICK() == 2) {
        this.mSingleJoystickView = new SingleJoystickView((Context)this);
        this.joystick_layout.addView(this.mSingleJoystickView);
      } 
    } else {
      this.mDrsControllerView = new DrsControllerView((Context)this, (Activity)this, this.JoystickHandler);
      this.mDrsControllerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.joystick_layout.addView(this.mDrsControllerView);
    } 
    getWindow().addFlags(128);
    this.mSoundManager = new SoundManager((Context)this);
  }
  
  protected void onDestroy() {
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4)
      finish(); 
    return true;
  }
  
  protected void onPause() {
    super.onPause();
    unbindService(this.BTConnection);
    for (int i = 1; i < 5; i++)
      this.mspdata.setRawRCDataAux(i, 1000); 
    this.mspdata.initializeMultiData();
  }
  
  protected void onResume() {
    super.onResume();
    setFilter();
    startService(BTService.class, this.BTConnection, (Bundle)null);
    if (this.mBTService != null);
    Log.d("JoystickActivity", "start on");
  }
  
  protected void onStop() {
    super.onStop();
    unregisterReceiver(this.JoystickReceiver);
    if (this.mDualJoystickView != null && this.mDualJoystickView.getmSensorManager() != null && this.mDualJoystickView.getmSensorEventListener() != null) {
      Log.d("JoystickActivity", "unregister Listener");
      this.mDualJoystickView.getmSensorManager().unregisterListener(this.mDualJoystickView.getmSensorEventListener());
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Controller\DroneController\JoystickActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */