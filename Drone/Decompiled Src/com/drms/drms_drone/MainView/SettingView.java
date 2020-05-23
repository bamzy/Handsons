package com.drms.drms_drone.MainView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.drms.drms_drone.Controller.MultiSetting.DroneSettingActivity;
import com.drms.drms_drone.Service.BTService;
import com.drms.drms_drone.Sound.SoundManager;

public class SettingView extends LinearLayout {
  private String TAG = SettingView.class.getSimpleName();
  
  float canvas_height = 0.0F;
  
  float canvas_width = 0.0F;
  
  private Activity mActivity;
  
  private BTService mBTService;
  
  private Context mContext;
  
  private Paint[] mPaint = new Paint[5];
  
  private SoundManager mSoundManager;
  
  public SettingView(Context paramContext, Activity paramActivity) {
    super(paramContext);
    this.mContext = paramContext;
    this.mActivity = paramActivity;
    this.mSoundManager = new SoundManager(this.mContext);
  }
  
  public void drawTopic(Canvas paramCanvas) {
    this.mPaint[0] = new Paint();
    this.mPaint[0].setTextAlign(Paint.Align.LEFT);
    this.mPaint[0].setTextSize(70.0F);
    this.mPaint[0].setStrokeWidth(5.0F);
    this.mPaint[0].setColor(this.mContext.getResources().getColor(2131492907));
    paramCanvas.drawText(" 설 정 ", this.mPaint[0].getTextSize() / 2.0F, this.mPaint[0].getTextSize() * 3.0F / 2.0F, this.mPaint[0]);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.canvas_width == 0.0F && this.canvas_height == 0.0F) {
      this.canvas_width = paramCanvas.getWidth();
      this.canvas_height = paramCanvas.getHeight();
      Log.d(this.TAG, "Canvas Width : " + this.canvas_width + "\nCanvas Height : " + this.canvas_height);
    } 
    drawTopic(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() != 0 && paramMotionEvent.getAction() == 1) {
      if (this.mBTService.getmBluetoothService().getState() == 4) {
        try {
          Thread.sleep(30L);
        } catch (InterruptedException interruptedException) {}
        Intent intent = new Intent(this.mContext, DroneSettingActivity.class);
        this.mActivity.startActivityForResult(intent, 4);
        this.mActivity.overridePendingTransition(2131034123, 2131034124);
        this.mSoundManager.play(0);
        return true;
      } 
      if (this.mBTService.getmBluetoothService().getState() == 3) {
        Toast.makeText((Context)this.mActivity, "드론 연결 중", 0).show();
        return true;
      } 
      Toast.makeText((Context)this.mActivity, "드론을 연결해주세요.", 0).show();
      return true;
    } 
    return true;
  }
  
  public void setmBTService(BTService paramBTService) {
    this.mBTService = paramBTService;
    Log.d(this.TAG, "set BTService in SettingView");
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\MainView\SettingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */