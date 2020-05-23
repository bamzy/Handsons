package com.drms.drms_drone.Controller.DroneController;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.drms.drms_drone.Sound.SoundManager;

public class JoystickSettingActivity extends AppCompatActivity {
  private static final String TAG = "JoystickSettingActivity";
  
  private LinearLayout bottomSetting;
  
  private boolean[] isSettingmenu = new boolean[] { false, false, false };
  
  private SoundManager mSoundManager;
  
  private LinearLayout[] optionMenu = new LinearLayout[2];
  
  private View.OnTouchListener optionMenuTouchListener = new View.OnTouchListener() {
      public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
        if (param1MotionEvent.getAction() == 0) {
          switch (param1View.getId()) {
            default:
              return true;
            case 2131558530:
              JoystickSettingActivity.this.isSettingmenu[0] = true;
              return true;
            case 2131558532:
              break;
          } 
          JoystickSettingActivity.this.isSettingmenu[1] = true;
          return true;
        } 
        if (param1MotionEvent.getAction() == 1) {
          try {
            Thread.sleep(30L);
          } catch (InterruptedException interruptedException) {}
          JoystickSettingActivity.this.mSoundManager.play(0);
          switch (param1View.getId()) {
            default:
              return true;
            case 2131558530:
              if (JoystickSettingActivity.this.isSettingmenu[0]) {
                JoystickSettingActivity.this.isSettingmenu[0] = false;
                for (int i = 0; i < JoystickSettingActivity.this.optionMenu.length; i++)
                  JoystickSettingActivity.this.optionMenu[i].setBackgroundColor(JoystickSettingActivity.this.getResources().getColor(2131492902)); 
                JoystickSettingActivity.this.optionMenu[0].setBackgroundColor(JoystickSettingActivity.this.getResources().getColor(2131492903));
                JoystickSettingActivity.this.bottomSetting.removeAllViews();
                param1View = new Setting1View((Context)JoystickSettingActivity.this, (Activity)JoystickSettingActivity.this);
                param1View.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                JoystickSettingActivity.this.bottomSetting.addView(param1View);
                return true;
              } 
            case 2131558532:
              break;
          } 
          if (JoystickSettingActivity.this.isSettingmenu[1]) {
            JoystickSettingActivity.this.isSettingmenu[1] = false;
            for (int i = 0; i < JoystickSettingActivity.this.optionMenu.length; i++)
              JoystickSettingActivity.this.optionMenu[i].setBackgroundColor(JoystickSettingActivity.this.getResources().getColor(2131492902)); 
            JoystickSettingActivity.this.optionMenu[1].setBackgroundColor(JoystickSettingActivity.this.getResources().getColor(2131492903));
            JoystickSettingActivity.this.bottomSetting.removeAllViews();
            param1View = new Setting2View((Context)JoystickSettingActivity.this, (Activity)JoystickSettingActivity.this);
            param1View.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            JoystickSettingActivity.this.bottomSetting.addView(param1View);
            return true;
          } 
        } 
      }
    };
  
  private TextView[] optionText = new TextView[2];
  
  private void initializeView() {
    this.optionMenu[0] = (LinearLayout)findViewById(2131558529);
    this.optionMenu[1] = (LinearLayout)findViewById(2131558531);
    this.optionText[0] = (TextView)findViewById(2131558530);
    this.optionText[1] = (TextView)findViewById(2131558532);
    this.bottomSetting = (LinearLayout)findViewById(2131558533);
    for (int i = 0; i < this.optionText.length; i++)
      this.optionText[i].setOnTouchListener(this.optionMenuTouchListener); 
    this.mSoundManager = new SoundManager((Context)this);
    Setting1View setting1View = new Setting1View((Context)this, (Activity)this);
    setting1View.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.bottomSetting.addView(setting1View);
  }
  
  public void finish() {
    super.finish();
    overridePendingTransition(2131034124, 2131034126);
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968610);
    getWindow().getDecorView().setSystemUiVisibility(4098);
    initializeView();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Controller\DroneController\JoystickSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */