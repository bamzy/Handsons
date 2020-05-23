package com.drms.drms_drone.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CheckPermissionActivity extends AppCompatActivity {
  private static final int ALLPERMISSION_GRANGTED = 0;
  
  private static final int PERMISSION_RESULT_OK = 1;
  
  private static final int REQUEST_PERMISSION = 0;
  
  public static final String REQUEST_TUTORIAL = "requset tutorial";
  
  private Button checkPermission;
  
  private Handler mHandler = new Handler() {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        if (param1Message.what == 0) {
          CheckPermissionActivity.access$002(CheckPermissionActivity.this, false);
          try {
            Thread.sleep(300L);
          } catch (InterruptedException interruptedException) {}
          Intent intent = new Intent((Context)CheckPermissionActivity.this, DroneMainActivity.class);
          intent.putExtra("requset tutorial", 1);
          CheckPermissionActivity.this.startActivity(intent);
          CheckPermissionActivity.this.overridePendingTransition(2131034123, 2131034124);
          CheckPermissionActivity.this.finish();
        } 
      }
    };
  
  private boolean running = false;
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968603);
    getSupportActionBar().hide();
    getWindow().setFlags(1024, 1024);
    this.checkPermission = (Button)findViewById(2131558494);
    this.checkPermission.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            CheckPermissionActivity.access$002(CheckPermissionActivity.this, true);
            if (Build.VERSION.SDK_INT >= 23) {
              int i = CheckPermissionActivity.this.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
              int j = CheckPermissionActivity.this.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
              int k = CheckPermissionActivity.this.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
              if (i == -1 || j == -1 || k == -1) {
                if (CheckPermissionActivity.this.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION") || CheckPermissionActivity.this.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION") || CheckPermissionActivity.this.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                  (new AlertDialog.Builder((Context)CheckPermissionActivity.this)).setTitle("권한이 필요합니다.").setMessage("이 기능을 사용하기 위해서는 단말기의 권한이 필요합니다. 계속 하시겠습니까").setPositiveButton("네", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                          if (Build.VERSION.SDK_INT >= 23)
                            CheckPermissionActivity.this.requestPermissions(new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 1000); 
                        }
                      }).setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                          Toast.makeText((Context)CheckPermissionActivity.this, "어플리케이션을 종료합니다.", 0).show();
                          CheckPermissionActivity.this.finish();
                        }
                      }).create().show();
                  return;
                } 
              } else {
                return;
              } 
            } else {
              return;
            } 
            CheckPermissionActivity.this.requestPermissions(new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE" }, 1000);
          }
        });
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfint) {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
    if (paramInt == 1000) {
      if (paramArrayOfint[0] == 0 && paramArrayOfint[1] == 0 && paramArrayOfint[2] == 0) {
        try {
          Thread.sleep(300L);
        } catch (InterruptedException interruptedException) {}
        Intent intent = new Intent((Context)this, DroneMainActivity.class);
        intent.putExtra("requset tutorial", 1);
        startActivity(intent);
        overridePendingTransition(2131034123, 2131034124);
        finish();
        return;
      } 
    } else {
      return;
    } 
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
    builder.setTitle("경고");
    builder.setMessage("권한을 허용하지 않아 어플리케이션을 종료합니다.");
    final AlertDialog ad = builder.create();
    alertDialog.show();
    (new Handler()).postDelayed(new Runnable() {
          public void run() {
            ad.dismiss();
            CheckPermissionActivity.this.finish();
          }
        },  1000L);
  }
  
  protected void onStop() {
    super.onStop();
    this.running = false;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Activity\CheckPermissionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */