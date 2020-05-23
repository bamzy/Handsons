package com.drms.drms_drone.Activity;

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
import com.drms.drms_drone.MultiData;
import com.drms.drms_drone.Service.BTService;

public class ProgrammingDroneActivity extends AppCompatActivity {
  private static Handler ProgramHandler = new Handler() {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
      }
    };
  
  private static final String TAG = "ProgrammingDrone";
  
  private final ServiceConnection BTConnection = new ServiceConnection() {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        ProgrammingDroneActivity.access$202(ProgrammingDroneActivity.this, ((BTService.BtBinder)param1IBinder).getService());
        ProgrammingDroneActivity.this.mBTService.setHandler(ProgrammingDroneActivity.ProgramHandler);
        Log.d("ProgrammingDrone", "Service : " + String.valueOf(ProgrammingDroneActivity.this.mBTService));
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        ProgrammingDroneActivity.access$202(ProgrammingDroneActivity.this, (BTService)null);
        Log.e("ProgrammingDrone", "Service Disconnected");
      }
    };
  
  private BTService mBTService;
  
  private MultiData mspdata;
  
  private BroadcastReceiver programDroneRecevier = new BroadcastReceiver() {
      public void onReceive(Context param1Context, Intent param1Intent) {}
    };
  
  private boolean running = true;
  
  private void setFilter() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
    intentFilter.addAction("disconnected bluetooth in Service");
    intentFilter.addAction("arduino reset");
    registerReceiver(this.programDroneRecevier, intentFilter);
  }
  
  private void startService(Class<?> paramClass, ServiceConnection paramServiceConnection, Bundle paramBundle) {
    Intent intent = new Intent((Context)this, paramClass);
    if (paramBundle != null && !paramBundle.isEmpty())
      for (String str : paramBundle.keySet())
        intent.putExtra(str, paramBundle.getString(str));  
    bindService(new Intent((Context)this, paramClass), paramServiceConnection, 1);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968612);
    this.mspdata = (MultiData)getApplication();
    (new Thread(new Runnable() {
          public void run() {
            while (ProgrammingDroneActivity.this.running) {
              Log.d("ProgrammingDrone", "altitude : " + ProgrammingDroneActivity.this.mspdata.getALTITUDEdata()[0] + "\tvario : " + ProgrammingDroneActivity.this.mspdata.getALTITUDEdata()[1]);
              try {
                Thread.sleep(10L);
              } catch (InterruptedException interruptedException) {}
            } 
          }
        })).start();
  }
  
  protected void onPause() {
    super.onPause();
    unbindService(this.BTConnection);
    this.running = false;
    unregisterReceiver(this.programDroneRecevier);
  }
  
  protected void onResume() {
    super.onResume();
    setFilter();
    startService(BTService.class, this.BTConnection, (Bundle)null);
    Log.d("ProgrammingDrone", "programDrone Service");
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Activity\ProgrammingDroneActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */