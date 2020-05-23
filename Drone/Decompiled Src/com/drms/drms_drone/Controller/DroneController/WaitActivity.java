package com.drms.drms_drone.Controller.DroneController;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class WaitActivity extends AppCompatActivity {
  public static final int REQUEST_MAIN_THREAD = 1;
  
  private int count = 0;
  
  public void finish() {
    super.finish();
    overridePendingTransition(2131034124, 2131034122);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968614);
    getWindow().getDecorView().setSystemUiVisibility(4098);
    (new Handler()).postDelayed(new Runnable() {
          public void run() {
            WaitActivity.this.finish();
          }
        },  1000L);
  }
  
  protected void onStop() {
    super.onStop();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Controller\DroneController\WaitActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */