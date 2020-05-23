package com.drms.drms_drone.Upload;

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
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.drms.drms_drone.Communication.ClassicBluetooth.BluetoothService;
import com.drms.drms_drone.CustomAdapter.CustomAdapter3.Custom3_Item;
import com.drms.drms_drone.CustomAdapter.CustomAdapter3.CustomAdapter3;
import com.drms.drms_drone.FileManagement.FileManagement;
import com.drms.drms_drone.Service.BTService;
import com.drms.drms_drone.Sound.SoundManager;

public class UploadSelectedActivity extends AppCompatActivity {
  public static final int REQUEST_HEX_GY521 = 3;
  
  public static final int REQUEST_HEX_GY85 = 4;
  
  public static final int REQUEST_HEX_GY86 = 5;
  
  public static final int REQUEST_QUAD_GY521 = 0;
  
  public static final int REQUEST_QUAD_GY85 = 1;
  
  public static final int REQUEST_QUAD_GY86 = 2;
  
  private static final String TAG = "UploadSelectActivity";
  
  private final ServiceConnection BTConnection = new ServiceConnection() {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        UploadSelectedActivity.access$302(UploadSelectedActivity.this, ((BTService.BtBinder)param1IBinder).getService());
        UploadSelectedActivity.this.mBTService.setHandler(UploadSelectedActivity.this.mHandler);
        Log.d("UploadSelectActivity", "Service : " + String.valueOf(UploadSelectedActivity.this.mBTService));
        UploadSelectedActivity.access$102(UploadSelectedActivity.this, UploadSelectedActivity.this.mBTService.getmBluetoothService());
        UploadSelectedActivity.access$202(UploadSelectedActivity.this, new FileManagement((Context)UploadSelectedActivity.this, UploadSelectedActivity.this.mHandler));
        UploadSelectedActivity.access$002(UploadSelectedActivity.this, new SoundManager((Context)UploadSelectedActivity.this));
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        UploadSelectedActivity.access$302(UploadSelectedActivity.this, (BTService)null);
        Log.e("UploadSelectActivity", "Service Disconnected");
      }
    };
  
  private AdapterView.OnItemClickListener HexItemClickListener = new AdapterView.OnItemClickListener() {
      public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
        byte b = -1;
        UploadSelectedActivity.this.mSoundManager.play(0);
        switch (param1Int) {
          default:
            param1Int = b;
            if (param1Int != -1) {
              new UploadManager((Activity)UploadSelectedActivity.this, UploadSelectedActivity.this.mBluetoothService, UploadSelectedActivity.this.mFileManagement.readBTAddress()[1], param1Int);
              return;
            } 
            break;
          case 0:
            param1Int = 3;
            if (param1Int != -1) {
              new UploadManager((Activity)UploadSelectedActivity.this, UploadSelectedActivity.this.mBluetoothService, UploadSelectedActivity.this.mFileManagement.readBTAddress()[1], param1Int);
              return;
            } 
            break;
          case 1:
            param1Int = 4;
            if (param1Int != -1) {
              new UploadManager((Activity)UploadSelectedActivity.this, UploadSelectedActivity.this.mBluetoothService, UploadSelectedActivity.this.mFileManagement.readBTAddress()[1], param1Int);
              return;
            } 
            break;
          case 2:
            param1Int = 5;
            if (param1Int != -1) {
              new UploadManager((Activity)UploadSelectedActivity.this, UploadSelectedActivity.this.mBluetoothService, UploadSelectedActivity.this.mFileManagement.readBTAddress()[1], param1Int);
              return;
            } 
            break;
        } 
        Log.e("UploadSelectActivity", "error request Drone");
        UploadSelectedActivity.this.finish();
      }
    };
  
  private BroadcastReceiver MainReceiver = new BroadcastReceiver() {
      public void onReceive(Context param1Context, Intent param1Intent) {
        param1Intent.getAction();
      }
    };
  
  private AdapterView.OnItemClickListener QuadItemClickListener = new AdapterView.OnItemClickListener() {
      public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
        UploadSelectedActivity.this.mSoundManager.play(0);
        byte b = -1;
        switch (param1Int) {
          default:
            param1Int = b;
            if (param1Int != -1) {
              new UploadManager((Activity)UploadSelectedActivity.this, UploadSelectedActivity.this.mBluetoothService, UploadSelectedActivity.this.mFileManagement.readBTAddress()[1], param1Int);
              return;
            } 
            break;
          case 0:
            param1Int = 0;
            if (param1Int != -1) {
              new UploadManager((Activity)UploadSelectedActivity.this, UploadSelectedActivity.this.mBluetoothService, UploadSelectedActivity.this.mFileManagement.readBTAddress()[1], param1Int);
              return;
            } 
            break;
          case 1:
            param1Int = 1;
            if (param1Int != -1) {
              new UploadManager((Activity)UploadSelectedActivity.this, UploadSelectedActivity.this.mBluetoothService, UploadSelectedActivity.this.mFileManagement.readBTAddress()[1], param1Int);
              return;
            } 
            break;
          case 2:
            param1Int = 2;
            if (param1Int != -1) {
              new UploadManager((Activity)UploadSelectedActivity.this, UploadSelectedActivity.this.mBluetoothService, UploadSelectedActivity.this.mFileManagement.readBTAddress()[1], param1Int);
              return;
            } 
            break;
        } 
        Log.e("UploadSelectActivity", "error request Drone");
        UploadSelectedActivity.this.finish();
      }
    };
  
  private CustomAdapter3 hexAdapter;
  
  private ListView hex_contents;
  
  private BTService mBTService;
  
  private BluetoothService mBluetoothService;
  
  private FileManagement mFileManagement;
  
  private Handler mHandler = new Handler() {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
      }
    };
  
  private SoundManager mSoundManager;
  
  private CustomAdapter3 quadAdapter;
  
  private ListView quad_contents;
  
  private void setFilter() {
    IntentFilter intentFilter = new IntentFilter();
    registerReceiver(this.MainReceiver, intentFilter);
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
    setContentView(2130968613);
    Intent intent = new Intent();
    intent.setAction("request upload display");
    sendBroadcast(intent);
    this.quad_contents = (ListView)findViewById(2131558536);
    this.hex_contents = (ListView)findViewById(2131558537);
    this.quadAdapter = new CustomAdapter3((Context)this);
    this.hexAdapter = new CustomAdapter3((Context)this);
    this.quadAdapter.addItem(new Custom3_Item(getResources().getDrawable(2130903081), "Quad + GY-521", "ACC + GYRO"));
    this.quadAdapter.addItem(new Custom3_Item(getResources().getDrawable(2130903081), "Quad + GY-85", "ACC + GYRO + MAG"));
    this.quadAdapter.addItem(new Custom3_Item(getResources().getDrawable(2130903081), "Quad + GY-86", "ACC + GYRO + MAG + BARO"));
    this.hexAdapter.addItem(new Custom3_Item(getResources().getDrawable(2130903059), "HEX + GY-521", "ACC + GYRO"));
    this.hexAdapter.addItem(new Custom3_Item(getResources().getDrawable(2130903059), "HEX + GY-85", "ACC + GYRO"));
    this.hexAdapter.addItem(new Custom3_Item(getResources().getDrawable(2130903059), "HEX + GY-86", "ACC + GYRO"));
    this.quad_contents.setAdapter((ListAdapter)this.quadAdapter);
    this.quad_contents.setOnItemClickListener(this.QuadItemClickListener);
    this.hex_contents.setAdapter((ListAdapter)this.hexAdapter);
    this.hex_contents.setOnItemClickListener(this.HexItemClickListener);
  }
  
  protected void onPause() {
    super.onPause();
  }
  
  protected void onResume() {
    super.onResume();
    setFilter();
    startService(BTService.class, this.BTConnection, (Bundle)null);
    getWindow().getDecorView().setSystemUiVisibility(4098);
  }
  
  protected void onStop() {
    super.onStop();
    unregisterReceiver(this.MainReceiver);
    unbindService(this.BTConnection);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Upload\UploadSelectedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */