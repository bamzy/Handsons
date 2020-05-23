package com.drms.drms_drone.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private static final int PERMISSION_RESULT_OK = 1;
  
  private static final int REQUEST_PERMISSION = 0;
  
  private int alpha = 0;
  
  private int count = 0;
  
  private boolean isSplash = false;
  
  private TextView logo;
  
  private Handler mHandler;
  
  private Runnable nextActivityRunnable = new Runnable() {
      public void run() {
        if (Build.VERSION.SDK_INT >= 23) {
          int i = MainActivity.this.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
          int j = MainActivity.this.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
          int k = MainActivity.this.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
          if (i == -1 || j == -1 || k == -1) {
            Intent intent2 = new Intent((Context)MainActivity.this, CheckPermissionActivity.class);
            MainActivity.this.startActivityForResult(intent2, 0);
            MainActivity.this.overridePendingTransition(2131034123, 2131034124);
            MainActivity.this.finish();
            return;
          } 
          Log.d("HANDLER", "OK");
          Intent intent1 = new Intent((Context)MainActivity.this, DroneMainActivity.class);
          MainActivity.this.startActivity(intent1);
          MainActivity.this.overridePendingTransition(2131034123, 2131034124);
          MainActivity.this.finish();
          return;
        } 
        Intent intent = new Intent((Context)MainActivity.this, DroneMainActivity.class);
        MainActivity.this.startActivity(intent);
        MainActivity.this.overridePendingTransition(2131034123, 2131034124);
        MainActivity.this.finish();
      }
    };
  
  private TextView version;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0 && paramInt2 == 1) {
      startActivity(new Intent((Context)this, DroneMainActivity.class));
      overridePendingTransition(2131034123, 2131034124);
      finish();
    } 
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    this.isSplash = false;
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968611);
    getWindow().getDecorView().setSystemUiVisibility(4098);
    this.version = (TextView)findViewById(2131558535);
    this.logo = (TextView)findViewById(2131558534);
    this.mHandler = new Handler();
    this.version.setText("v 2.0.3");
    this.isSplash = true;
    (new Thread(new Runnable() {
          public void run() {
            while (MainActivity.this.isSplash) {
              MainActivity.access$102(MainActivity.this, MainActivity.this.alpha + 2);
              MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                      MainActivity.this.logo.setAlpha(MainActivity.this.alpha / 255.0F);
                    }
                  });
              try {
                Thread.sleep(15L);
              } catch (InterruptedException interruptedException) {}
              if (MainActivity.this.alpha >= 255) {
                MainActivity.access$002(MainActivity.this, false);
                MainActivity.this.mHandler.post(MainActivity.this.nextActivityRunnable);
              } 
            } 
          }
        })).start();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Activity\MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */