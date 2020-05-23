package com.drms.drms_drone.Controller.MultiSetting;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.drms.drms_drone.CustomAdapter.CustomAdapter1.Custom1_Item;
import com.drms.drms_drone.CustomAdapter.CustomAdapter1.CustomAdapter1;
import com.drms.drms_drone.FileManagement.FileManagement;
import com.drms.drms_drone.MultiData;
import com.drms.drms_drone.Service.BTService;
import com.drms.drms_drone.Sound.SoundManager;
import java.text.DecimalFormat;

public class DroneSettingActivity extends AppCompatActivity {
  private static final int BOX = 2;
  
  private static int DISPLAY_LOOP = 2;
  
  private static final int GPS = 4;
  
  private static final int MYDRONE = 0;
  
  private static final int PID = 3;
  
  private static final int RC = 1;
  
  private static final String TAG = "DroneSettingActivity";
  
  private final ServiceConnection BTConnection = new ServiceConnection() {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        DroneSettingActivity.access$5102(DroneSettingActivity.this, ((BTService.BtBinder)param1IBinder).getService());
        DroneSettingActivity.this.mBTService.setHandler(DroneSettingActivity.this.DroneSettingHandler);
        Log.d("DroneSettingActivity", "Service : " + String.valueOf(DroneSettingActivity.this.mBTService));
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        DroneSettingActivity.access$5102(DroneSettingActivity.this, (BTService)null);
        Log.e("DroneSettingActivity", "Service Disconnected");
      }
    };
  
  private Handler DroneSettingHandler = new Handler() {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        switch (param1Message.what) {
          default:
            return;
          case 100:
            break;
        } 
        if (DroneSettingActivity.access$5308(DroneSettingActivity.this) >= DroneSettingActivity.DISPLAY_LOOP) {
          DroneSettingActivity.this.drone.invalidate();
          DroneSettingActivity.access$5302(DroneSettingActivity.this, 0);
          return;
        } 
      }
    };
  
  private BroadcastReceiver DroneSettingReceiver = new BroadcastReceiver() {
      public void onReceive(Context param1Context, Intent param1Intent) {}
    };
  
  private float[] MSP_PID_D = new float[10];
  
  private float[] MSP_PID_I = new float[10];
  
  private float[] MSP_PID_P = new float[10];
  
  private int SETTINGDISPLAY = 0;
  
  private EditText alt_d;
  
  private EditText alt_i;
  
  private EditText alt_p;
  
  private BoxSettingView box;
  
  private int count_display = 0;
  
  private EditText currentvbat;
  
  private AlertDialog dialog;
  
  private DrawerLayout drawer;
  
  private MyDroneSettingView drone;
  
  private EditText failsafe;
  
  private boolean isPIDSetting = false;
  
  private boolean isRcSetting = false;
  
  private EditText lev_d;
  
  private EditText lev_i;
  
  private EditText lev_p;
  
  private BTService mBTService;
  
  private FileManagement mFileManagemnet;
  
  private SoundManager mSoundManager;
  
  private EditText mag_p;
  
  private MultiData mspdata;
  
  private EditText navr_d;
  
  private EditText navr_i;
  
  private EditText navr_p;
  
  private ImageView openDrawer;
  
  private EditText pitch_d;
  
  private EditText pitch_i;
  
  private EditText pitch_p;
  
  private EditText pos_i;
  
  private EditText pos_p;
  
  private EditText posr_d;
  
  private EditText posr_i;
  
  private EditText posr_p;
  
  private EditText rcexpo;
  
  private EditText rcrate;
  
  private EditText roll_d;
  
  private EditText roll_i;
  
  private EditText roll_p;
  
  private EditText rpexpo;
  
  private EditText scale;
  
  private LinearLayout settinglayout;
  
  private EditText thr_expo;
  
  private EditText thr_mid;
  
  private EditText throttlemax;
  
  private EditText throttlemin;
  
  private EditText warning1;
  
  private EditText warning2;
  
  private EditText warning3;
  
  private EditText yaw_d;
  
  private EditText yaw_i;
  
  private EditText yaw_p;
  
  private EditText yawrate;
  
  private void implementationDrawer() {
    ListView listView = (ListView)findViewById(2131558509);
    CustomAdapter1 customAdapter1 = new CustomAdapter1((Context)this);
    customAdapter1.addItem(new Custom1_Item(getResources().getDrawable(2130903075), "My Drone"));
    customAdapter1.addItem(new Custom1_Item(getResources().getDrawable(2130903083), "RC & Battery"));
    customAdapter1.addItem(new Custom1_Item(getResources().getDrawable(2130903046), "Box Setting"));
    customAdapter1.addItem(new Custom1_Item(getResources().getDrawable(2130903078), "PID Setting"));
    TextView textView = (TextView)findViewById(2131558508);
    this.mFileManagemnet = new FileManagement((Context)this, this.DroneSettingHandler);
    textView.setText(this.mFileManagemnet.readBTAddress()[0]);
    listView.setAdapter((ListAdapter)customAdapter1);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            DroneSettingActivity.access$4402(DroneSettingActivity.this, false);
            DroneSettingActivity.access$102(DroneSettingActivity.this, param1Int);
            switch (param1Int) {
              default:
                DroneSettingActivity.this.mSoundManager.play(0);
                return;
              case 0:
                DroneSettingActivity.this.settinglayout.removeAllViews();
                DroneSettingActivity.access$4602(DroneSettingActivity.this, new MyDroneSettingView((Context)DroneSettingActivity.this, (Activity)DroneSettingActivity.this));
                DroneSettingActivity.this.settinglayout.addView(DroneSettingActivity.this.drone);
                DroneSettingActivity.this.drawer.closeDrawer(8388611);
              case 1:
                DroneSettingActivity.this.implementationRcSetting();
                DroneSettingActivity.this.drawer.closeDrawer(8388611);
              case 2:
                DroneSettingActivity.this.settinglayout.removeAllViews();
                DroneSettingActivity.access$4802(DroneSettingActivity.this, new BoxSettingView((Context)DroneSettingActivity.this, (Activity)DroneSettingActivity.this));
                DroneSettingActivity.this.settinglayout.addView(DroneSettingActivity.this.box);
                DroneSettingActivity.this.drawer.closeDrawer(8388611);
              case 3:
                break;
            } 
            DroneSettingActivity.this.implementationPIDSetting();
            DroneSettingActivity.this.drawer.closeDrawer(8388611);
          }
        });
  }
  
  private void implementationPIDSetting() {
    this.isPIDSetting = true;
    this.settinglayout.removeAllViews();
    LinearLayout linearLayout = (LinearLayout)View.inflate((Context)this, 2130968634, null);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    this.settinglayout.addView((View)linearLayout);
    this.roll_p = (EditText)linearLayout.findViewById(2131558568);
    this.roll_i = (EditText)linearLayout.findViewById(2131558569);
    this.roll_d = (EditText)linearLayout.findViewById(2131558570);
    this.pitch_p = (EditText)linearLayout.findViewById(2131558571);
    this.pitch_i = (EditText)linearLayout.findViewById(2131558572);
    this.pitch_d = (EditText)linearLayout.findViewById(2131558573);
    this.yaw_p = (EditText)linearLayout.findViewById(2131558574);
    this.yaw_i = (EditText)linearLayout.findViewById(2131558575);
    this.yaw_d = (EditText)linearLayout.findViewById(2131558576);
    this.alt_p = (EditText)linearLayout.findViewById(2131558577);
    this.alt_i = (EditText)linearLayout.findViewById(2131558578);
    this.alt_d = (EditText)linearLayout.findViewById(2131558579);
    this.pos_p = (EditText)linearLayout.findViewById(2131558580);
    this.pos_i = (EditText)linearLayout.findViewById(2131558581);
    this.posr_p = (EditText)linearLayout.findViewById(2131558582);
    this.posr_i = (EditText)linearLayout.findViewById(2131558583);
    this.posr_d = (EditText)linearLayout.findViewById(2131558584);
    this.navr_p = (EditText)linearLayout.findViewById(2131558585);
    this.navr_i = (EditText)linearLayout.findViewById(2131558586);
    this.navr_d = (EditText)linearLayout.findViewById(2131558587);
    this.lev_p = (EditText)linearLayout.findViewById(2131558588);
    this.lev_i = (EditText)linearLayout.findViewById(2131558589);
    this.lev_d = (EditText)linearLayout.findViewById(2131558590);
    this.mag_p = (EditText)linearLayout.findViewById(2131558591);
    int i = 0;
    for (int j = 0; i < 10; j++) {
      float[] arrayOfFloat = this.MSP_PID_P;
      int[] arrayOfInt = this.mspdata.getPIDdata();
      int k = j + 1;
      arrayOfFloat[i] = arrayOfInt[j];
      arrayOfFloat = this.MSP_PID_I;
      arrayOfInt = this.mspdata.getPIDdata();
      j = k + 1;
      arrayOfFloat[i] = arrayOfInt[k];
      this.MSP_PID_D[i] = this.mspdata.getPIDdata()[j];
      i++;
    } 
    this.roll_p.setText(String.valueOf(this.MSP_PID_P[0] / 10.0F));
    this.pitch_p.setText(String.valueOf(this.MSP_PID_P[1] / 10.0F));
    this.yaw_p.setText(String.valueOf(this.MSP_PID_P[2] / 10.0F));
    this.alt_p.setText(String.valueOf(this.MSP_PID_P[3] / 10.0F));
    this.pos_p.setText(String.valueOf(this.MSP_PID_P[4] / 100.0F));
    this.posr_p.setText(String.valueOf(this.MSP_PID_P[5] / 10.0F));
    this.navr_p.setText(String.valueOf(this.MSP_PID_P[6] / 10.0F));
    this.lev_p.setText(String.valueOf((int)this.MSP_PID_P[7] / 10));
    this.mag_p.setText(String.valueOf((int)this.MSP_PID_P[8] / 10));
    this.roll_i.setText(String.valueOf(this.MSP_PID_I[0] / 1000.0F));
    this.pitch_i.setText(String.valueOf(this.MSP_PID_I[1] / 1000.0F));
    this.yaw_i.setText(String.valueOf(this.MSP_PID_I[2] / 1000.0F));
    this.alt_i.setText(String.valueOf(this.MSP_PID_I[3] / 1000.0F));
    this.pos_i.setText(String.valueOf(this.MSP_PID_I[4] / 1000.0F));
    this.posr_i.setText(String.valueOf(this.MSP_PID_I[5] / 100.0F));
    this.navr_i.setText(String.valueOf(this.MSP_PID_I[6] / 100.0F));
    this.lev_i.setText(String.valueOf(this.MSP_PID_I[7] / 1000.0F));
    this.roll_d.setText(String.valueOf((int)this.MSP_PID_D[0]));
    this.pitch_d.setText(String.valueOf((int)this.MSP_PID_D[1]));
    this.yaw_d.setText(String.valueOf((int)this.MSP_PID_D[2]));
    this.alt_d.setText(String.valueOf((int)this.MSP_PID_D[3]));
    this.posr_d.setText(String.valueOf(this.MSP_PID_D[5] / 1000.0F));
    this.navr_d.setText(String.valueOf(this.MSP_PID_D[6] / 1000.0F));
    this.lev_d.setText(String.valueOf((int)this.MSP_PID_D[7]));
  }
  
  private void implementationRcSetting() {
    this.isRcSetting = true;
    this.settinglayout.removeAllViews();
    LinearLayout linearLayout = (LinearLayout)View.inflate((Context)this, 2130968635, null);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    this.settinglayout.addView((View)linearLayout);
    final DecimalFormat form = new DecimalFormat("#.##");
    this.rcrate = (EditText)linearLayout.findViewById(2131558592);
    this.rcexpo = (EditText)linearLayout.findViewById(2131558594);
    this.rpexpo = (EditText)linearLayout.findViewById(2131558596);
    this.thr_mid = (EditText)linearLayout.findViewById(2131558593);
    this.thr_expo = (EditText)linearLayout.findViewById(2131558595);
    this.yawrate = (EditText)linearLayout.findViewById(2131558597);
    this.throttlemin = (EditText)linearLayout.findViewById(2131558598);
    this.throttlemax = (EditText)linearLayout.findViewById(2131558599);
    this.failsafe = (EditText)linearLayout.findViewById(2131558600);
    this.scale = (EditText)linearLayout.findViewById(2131558601);
    this.currentvbat = (EditText)linearLayout.findViewById(2131558602);
    this.warning1 = (EditText)linearLayout.findViewById(2131558603);
    this.warning2 = (EditText)linearLayout.findViewById(2131558604);
    this.warning3 = (EditText)linearLayout.findViewById(2131558605);
    this.throttlemin.setText(String.valueOf((int)this.mspdata.getMISCdata()[1]));
    this.throttlemax.setText(String.valueOf((int)this.mspdata.getMISCdata()[2]));
    this.failsafe.setText(String.valueOf((int)this.mspdata.getMISCdata()[4]));
    this.scale.setText(String.valueOf((int)this.mspdata.getMISCdata()[8]));
    this.warning1.setText(String.valueOf(decimalFormat.format(this.mspdata.getMISCdata()[9])));
    this.warning2.setText(String.valueOf(decimalFormat.format(this.mspdata.getMISCdata()[10])));
    this.warning3.setText(String.valueOf(decimalFormat.format(this.mspdata.getMISCdata()[11])));
    this.rcrate.setText(String.valueOf(this.mspdata.getRCTUNEdata()[0]));
    this.rcexpo.setText(String.valueOf(this.mspdata.getRCTUNEdata()[1]));
    this.rpexpo.setText(String.valueOf(this.mspdata.getRCTUNEdata()[2]));
    this.yawrate.setText(String.valueOf(this.mspdata.getRCTUNEdata()[3]));
    this.thr_mid.setText(String.valueOf(this.mspdata.getRCTUNEdata()[5]));
    this.thr_expo.setText(String.valueOf(this.mspdata.getRCTUNEdata()[6]));
    (new Thread(new Runnable() {
          public void run() {
            while (DroneSettingActivity.this.isRcSetting) {
              DroneSettingActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                      DroneSettingActivity.this.currentvbat.setText(form.format(DroneSettingActivity.this.mspdata.getAnalogData()[0]));
                    }
                  });
              try {
                Thread.sleep(100L);
              } catch (InterruptedException interruptedException) {}
            } 
            Log.d("DroneSettingActivity", "end of vbat");
          }
        })).start();
  }
  
  private void initializeView() {
    this.mspdata = (MultiData)getApplication();
    this.mSoundManager = new SoundManager((Context)this);
    this.drawer = (DrawerLayout)findViewById(2131558504);
    this.openDrawer = (ImageView)findViewById(2131558505);
    this.openDrawer.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1MotionEvent.getAction() == 0) {
              switch (DroneSettingActivity.this.SETTINGDISPLAY) {
                default:
                  return true;
                case 1:
                  f1 = Float.parseFloat(DroneSettingActivity.this.rcrate.getText().toString());
                  f2 = Float.parseFloat(DroneSettingActivity.this.rcexpo.getText().toString());
                  f3 = Float.parseFloat(DroneSettingActivity.this.rpexpo.getText().toString());
                  f4 = Float.parseFloat(DroneSettingActivity.this.yawrate.getText().toString());
                  f5 = DroneSettingActivity.this.mspdata.getRCTUNEdata()[4];
                  f6 = Float.parseFloat(DroneSettingActivity.this.thr_mid.getText().toString());
                  f7 = Float.parseFloat(DroneSettingActivity.this.thr_expo.getText().toString());
                  f8 = DroneSettingActivity.this.mspdata.getMISCdata()[0];
                  f9 = Float.parseFloat(DroneSettingActivity.this.throttlemin.getText().toString());
                  f10 = DroneSettingActivity.this.mspdata.getMISCdata()[2];
                  f11 = DroneSettingActivity.this.mspdata.getMISCdata()[3];
                  f12 = Float.parseFloat(DroneSettingActivity.this.failsafe.getText().toString());
                  f13 = DroneSettingActivity.this.mspdata.getMISCdata()[5];
                  f14 = DroneSettingActivity.this.mspdata.getMISCdata()[6];
                  f15 = DroneSettingActivity.this.mspdata.getMISCdata()[7];
                  f16 = Float.parseFloat(DroneSettingActivity.this.scale.getText().toString());
                  f17 = Float.parseFloat(DroneSettingActivity.this.warning1.getText().toString());
                  f18 = Float.parseFloat(DroneSettingActivity.this.warning2.getText().toString());
                  f19 = Float.parseFloat(DroneSettingActivity.this.warning3.getText().toString());
                  DroneSettingActivity.this.mspdata.setRCTUNEdata(new float[] { f1, f2, f3, f4, f5, f6, f7 });
                  DroneSettingActivity.this.mspdata.setMISCdata(new float[] { 
                        f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, 
                        f18, f19 });
                  DroneSettingActivity.this.sendBroadcast(new Intent("request rc setting"));
                  return true;
                case 2:
                  Log.d("DroneSettingActivity", "send box data");
                  DroneSettingActivity.this.sendBroadcast(new Intent("request box setting"));
                  return true;
                case 3:
                  break;
              } 
              float f1 = Float.parseFloat(DroneSettingActivity.this.roll_p.getText().toString());
              float f2 = Float.parseFloat(DroneSettingActivity.this.pitch_p.getText().toString());
              float f3 = Float.parseFloat(DroneSettingActivity.this.yaw_p.getText().toString());
              float f4 = Float.parseFloat(DroneSettingActivity.this.alt_p.getText().toString());
              float f5 = Float.parseFloat(DroneSettingActivity.this.pos_p.getText().toString());
              float f6 = Float.parseFloat(DroneSettingActivity.this.posr_p.getText().toString());
              float f7 = Float.parseFloat(DroneSettingActivity.this.navr_p.getText().toString());
              float f8 = Float.parseFloat(DroneSettingActivity.this.lev_p.getText().toString());
              float f9 = Float.parseFloat(DroneSettingActivity.this.mag_p.getText().toString());
              float f10 = DroneSettingActivity.this.MSP_PID_P[9];
              float f11 = Float.parseFloat(DroneSettingActivity.this.roll_i.getText().toString());
              float f12 = Float.parseFloat(DroneSettingActivity.this.pitch_i.getText().toString());
              float f13 = Float.parseFloat(DroneSettingActivity.this.yaw_i.getText().toString());
              float f14 = Float.parseFloat(DroneSettingActivity.this.alt_i.getText().toString());
              float f15 = Float.parseFloat(DroneSettingActivity.this.pos_i.getText().toString());
              float f16 = Float.parseFloat(DroneSettingActivity.this.posr_i.getText().toString());
              float f17 = Float.parseFloat(DroneSettingActivity.this.navr_i.getText().toString());
              float f18 = Float.parseFloat(DroneSettingActivity.this.lev_i.getText().toString());
              float f19 = DroneSettingActivity.this.MSP_PID_I[8];
              float f20 = DroneSettingActivity.this.MSP_PID_I[9];
              float f21 = Float.parseFloat(DroneSettingActivity.this.roll_d.getText().toString());
              float f22 = Float.parseFloat(DroneSettingActivity.this.pitch_d.getText().toString());
              float f23 = Float.parseFloat(DroneSettingActivity.this.yaw_d.getText().toString());
              float f24 = Float.parseFloat(DroneSettingActivity.this.alt_d.getText().toString());
              float f25 = DroneSettingActivity.this.MSP_PID_D[4];
              float f26 = Float.parseFloat(DroneSettingActivity.this.posr_d.getText().toString());
              float f27 = Float.parseFloat(DroneSettingActivity.this.navr_d.getText().toString());
              float f28 = Float.parseFloat(DroneSettingActivity.this.lev_d.getText().toString());
              float f29 = DroneSettingActivity.this.MSP_PID_D[8];
              float f30 = DroneSettingActivity.this.MSP_PID_D[9];
              Intent intent = new Intent();
              intent.putExtra("P", new float[] { f1 * 10.0F, f2 * 10.0F, f3 * 10.0F, f4 * 10.0F, f5 * 100.0F, f6 * 10.0F, f7 * 10.0F, f8 * 10.0F, f9 * 10.0F, f10 });
              intent.putExtra("I", new float[] { f11 * 1000.0F, f12 * 1000.0F, f13 * 1000.0F, f14 * 1000.0F, f15 * 1000.0F, f16 * 100.0F, f17 * 100.0F, f18 * 1000.0F, f19, f20 });
              intent.putExtra("D", new float[] { f21, f22, f23, f24, f25, f26 * 1000.0F, f27 * 1000.0F, f28, f29, f30 });
              intent.setAction("request pid setting");
              DroneSettingActivity.this.sendBroadcast(intent);
              return true;
            } 
            if (param1MotionEvent.getAction() == 1) {
              try {
                Thread.sleep(30L);
              } catch (InterruptedException interruptedException) {}
              DroneSettingActivity.this.mSoundManager.play(0);
              DroneSettingActivity.this.drawer.openDrawer(8388611);
              return true;
            } 
          }
        });
    this.settinglayout = (LinearLayout)findViewById(2131558507);
    this.drone = new MyDroneSettingView((Context)this, (Activity)this);
    this.drone.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.settinglayout.addView(this.drone);
    implementationDrawer();
  }
  
  private void setFilter() {
    IntentFilter intentFilter = new IntentFilter();
    registerReceiver(this.DroneSettingReceiver, intentFilter);
  }
  
  private void startService(Class<?> paramClass, ServiceConnection paramServiceConnection, Bundle paramBundle) {
    Intent intent = new Intent((Context)this, paramClass);
    if (paramBundle != null && !paramBundle.isEmpty())
      for (String str : paramBundle.keySet())
        intent.putExtra(str, paramBundle.getString(str));  
    bindService(new Intent((Context)this, paramClass), paramServiceConnection, 1);
  }
  
  public void finish() {
    super.finish();
    overridePendingTransition(2131034124, 2131034122);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968606);
    getWindow().getDecorView().setSystemUiVisibility(4098);
    sendBroadcast(new Intent("request display setting"));
    initializeView();
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
    LinearLayout linearLayout = (LinearLayout)View.inflate((Context)this, 2130968639, null);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    builder.setView((View)linearLayout);
    TextView textView1 = (TextView)linearLayout.findViewById(2131558606);
    TextView textView2 = (TextView)linearLayout.findViewById(2131558607);
    textView1.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            DroneSettingActivity.this.dialog.dismiss();
          }
        });
    textView2.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            DroneSettingActivity.this.dialog.cancel();
          }
        });
    this.dialog = builder.create();
    this.dialog.show();
    this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
          public void onCancel(DialogInterface param1DialogInterface) {
            DroneSettingActivity.this.finish();
          }
        });
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      if (this.drawer.isDrawerOpen(8388611))
        this.drawer.closeDrawer(8388611); 
      Intent intent = new Intent();
      intent.putExtra("REQUEST_BACK", -1);
      switch (this.SETTINGDISPLAY) {
        default:
          return true;
        case 0:
          finish();
        case 1:
          intent.setAction("request rc setting");
          f1 = Float.parseFloat(this.rcrate.getText().toString());
          f2 = Float.parseFloat(this.rcexpo.getText().toString());
          f3 = Float.parseFloat(this.rpexpo.getText().toString());
          f4 = Float.parseFloat(this.yawrate.getText().toString());
          f5 = this.mspdata.getRCTUNEdata()[4];
          f6 = Float.parseFloat(this.thr_mid.getText().toString());
          f7 = Float.parseFloat(this.thr_expo.getText().toString());
          f8 = this.mspdata.getMISCdata()[0];
          f9 = Float.parseFloat(this.throttlemin.getText().toString());
          f10 = this.mspdata.getMISCdata()[2];
          f11 = this.mspdata.getMISCdata()[3];
          f12 = Float.parseFloat(this.failsafe.getText().toString());
          f13 = this.mspdata.getMISCdata()[5];
          f14 = this.mspdata.getMISCdata()[6];
          f15 = this.mspdata.getMISCdata()[7];
          f16 = Float.parseFloat(this.scale.getText().toString());
          f17 = Float.parseFloat(this.warning1.getText().toString());
          f18 = Float.parseFloat(this.warning2.getText().toString());
          f19 = Float.parseFloat(this.warning3.getText().toString());
          this.mspdata.setRCTUNEdata(new float[] { f1, f2, f3, f4, f5, f6, f7 });
          this.mspdata.setMISCdata(new float[] { 
                f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, 
                f18, f19 });
          sendBroadcast(intent);
          finish();
        case 2:
          Log.d("DroneSettingActivity", "send box data");
          intent.setAction("request box setting");
          sendBroadcast(intent);
          finish();
        case 3:
          break;
      } 
      float f1 = Float.parseFloat(this.roll_p.getText().toString());
      float f2 = Float.parseFloat(this.pitch_p.getText().toString());
      float f3 = Float.parseFloat(this.yaw_p.getText().toString());
      float f4 = Float.parseFloat(this.alt_p.getText().toString());
      float f5 = Float.parseFloat(this.pos_p.getText().toString());
      float f6 = Float.parseFloat(this.posr_p.getText().toString());
      float f7 = Float.parseFloat(this.navr_p.getText().toString());
      float f8 = Float.parseFloat(this.lev_p.getText().toString());
      float f9 = Float.parseFloat(this.mag_p.getText().toString());
      float f10 = this.MSP_PID_P[9];
      float f11 = Float.parseFloat(this.roll_i.getText().toString());
      float f12 = Float.parseFloat(this.pitch_i.getText().toString());
      float f13 = Float.parseFloat(this.yaw_i.getText().toString());
      float f14 = Float.parseFloat(this.alt_i.getText().toString());
      float f15 = Float.parseFloat(this.pos_i.getText().toString());
      float f16 = Float.parseFloat(this.posr_i.getText().toString());
      float f17 = Float.parseFloat(this.navr_i.getText().toString());
      float f18 = Float.parseFloat(this.lev_i.getText().toString());
      float f19 = this.MSP_PID_I[8];
      float f20 = this.MSP_PID_I[9];
      float f21 = Float.parseFloat(this.roll_d.getText().toString());
      float f22 = Float.parseFloat(this.pitch_d.getText().toString());
      float f23 = Float.parseFloat(this.yaw_d.getText().toString());
      float f24 = Float.parseFloat(this.alt_d.getText().toString());
      float f25 = this.MSP_PID_D[4];
      float f26 = Float.parseFloat(this.posr_d.getText().toString());
      float f27 = Float.parseFloat(this.navr_d.getText().toString());
      float f28 = Float.parseFloat(this.lev_d.getText().toString());
      float f29 = this.MSP_PID_D[8];
      float f30 = this.MSP_PID_D[9];
      intent.putExtra("P", new float[] { f1 * 10.0F, f2 * 10.0F, f3 * 10.0F, f4 * 10.0F, f5 * 100.0F, f6 * 10.0F, f7 * 10.0F, f8 * 10.0F, f9 * 10.0F, f10 });
      intent.putExtra("I", new float[] { f11 * 1000.0F, f12 * 1000.0F, f13 * 1000.0F, f14 * 1000.0F, f15 * 1000.0F, f16 * 100.0F, f17 * 100.0F, f18 * 1000.0F, f19, f20 });
      intent.putExtra("D", new float[] { f21, f22, f23, f24, f25, f26 * 1000.0F, f27 * 1000.0F, f28, f29, f30 });
      intent.setAction("request pid setting");
      sendBroadcast(intent);
      finish();
    } 
  }
  
  protected void onPause() {
    super.onPause();
    unregisterReceiver(this.DroneSettingReceiver);
  }
  
  protected void onResume() {
    super.onResume();
    setFilter();
    startService(BTService.class, this.BTConnection, (Bundle)null);
  }
  
  protected void onStop() {
    super.onStop();
    this.isRcSetting = false;
    unbindService(this.BTConnection);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Controller\MultiSetting\DroneSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */