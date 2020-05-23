package com.drms.drms_drone.MainView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.drms.drms_drone.Controller.DroneController.JoystickActivity;
import com.drms.drms_drone.MultiData;
import com.drms.drms_drone.Service.BTService;
import com.drms.drms_drone.Sound.SoundManager;

public class Playflight extends LinearLayout {
  private double Pi = 3.141592D;
  
  private String TAG = Playflight.class.getSimpleName();
  
  float canvas_height = 0.0F;
  
  float canvas_width = 0.0F;
  
  private NextBtn flight_play;
  
  private Activity mActivity;
  
  private BTService mBTService;
  
  private Context mContext;
  
  private Paint[] mPaint = new Paint[10];
  
  private SoundManager mSoundManager;
  
  private MultiData mspdata;
  
  private CurrentDrone myDrone;
  
  public Playflight(Context paramContext, Activity paramActivity) {
    super(paramContext);
    this.mContext = paramContext;
    this.mActivity = paramActivity;
    this.mspdata = (MultiData)paramActivity.getApplication();
    this.mSoundManager = new SoundManager(paramContext);
  }
  
  private void drawCurrentDrone(Canvas paramCanvas) {
    this.mPaint[1] = new Paint();
    this.mPaint[1].setStrokeWidth(5.0F);
    this.mPaint[1].setColor(this.mContext.getResources().getColor(2131492906));
    this.mPaint[1].setStyle(Paint.Style.STROKE);
    this.mPaint[2] = new Paint();
    this.mPaint[2].setColor(-16777216);
    this.mPaint[2].setStrokeWidth(7.0F);
    this.mPaint[2].setStyle(Paint.Style.STROKE);
    float f1 = (paramCanvas.getHeight() / 6);
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = (paramCanvas.getWidth() / 5);
    arrayOfFloat1[1] = (paramCanvas.getHeight() * 2 / 5);
    float[] arrayOfFloat2 = new float[4];
    arrayOfFloat2[0] = (paramCanvas.getWidth() * 26 / 30);
    arrayOfFloat2[1] = (paramCanvas.getHeight() * 3 / 30);
    arrayOfFloat2[2] = (paramCanvas.getWidth() * 29 / 30);
    arrayOfFloat2[3] = (paramCanvas.getHeight() * 9 / 30);
    float f2 = arrayOfFloat2[2] - arrayOfFloat2[0];
    paramCanvas.drawRect(arrayOfFloat2[0], arrayOfFloat2[1], arrayOfFloat2[2], arrayOfFloat2[3], this.mPaint[2]);
    float f3 = arrayOfFloat2[0];
    float f4 = f2 / 3.0F;
    float f5 = (paramCanvas.getHeight() * 2 / 30);
    float f6 = arrayOfFloat2[0];
    paramCanvas.drawRect(f4 + f3, f5, 2.0F * f2 / 3.0F + f6, arrayOfFloat2[1], this.mPaint[2]);
    this.mPaint[3] = new Paint();
    this.mPaint[3].setTextSize(50.0F);
    this.mPaint[3].setStrokeWidth(4.0F);
    this.mPaint[3].setColor(this.mContext.getResources().getColor(2131492904));
    this.mPaint[3].setTextAlign(Paint.Align.CENTER);
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = paramCanvas.getWidth() / 2;
    arrayOfInt1[1] = (int)(arrayOfFloat1[1] - f1 + this.mPaint[3].getTextSize() / 2.0F);
    paramCanvas.drawText("R : ", arrayOfInt1[0], arrayOfInt1[1], this.mPaint[3]);
    paramCanvas.drawText("P : ", arrayOfInt1[0], arrayOfInt1[1] + f1, this.mPaint[3]);
    paramCanvas.drawText("Y : ", arrayOfInt1[0], arrayOfInt1[1] + 2.0F * f1, this.mPaint[3]);
    f2 = this.mPaint[3].measureText("Pitch");
    int j = 0;
    int i = 0;
    int k = 0;
    if (this.mBTService != null) {
      j = (int)this.mspdata.getAttitudeData()[0];
      i = (int)this.mspdata.getAttitudeData()[1];
      k = (int)this.mspdata.getAttitudeData()[2];
    } 
    paramCanvas.drawText(String.valueOf(j), arrayOfInt1[0] + f2, arrayOfInt1[1], this.mPaint[3]);
    paramCanvas.drawText(String.valueOf(i), arrayOfInt1[0] + f2, arrayOfInt1[1] + f1, this.mPaint[3]);
    paramCanvas.drawText(String.valueOf(k), arrayOfInt1[0] + f2, arrayOfInt1[1] + 2.0F * f1, this.mPaint[3]);
    k = j;
    if (j > 180)
      k = 180; 
    int m = k;
    if (k < -180)
      m = -180; 
    j = i;
    if (i > 60)
      j = 60; 
    i = j;
    if (j < -60)
      i = -60; 
    this.mPaint[4] = new Paint();
    this.mPaint[4].setStrokeWidth(10.0F);
    this.mPaint[4].setColor(this.mContext.getResources().getColor(2131492940));
    this.mPaint[5] = new Paint();
    this.mPaint[5].setStrokeWidth(10.0F);
    this.mPaint[5].setColor(this.mContext.getResources().getColor(2131492927));
    arrayOfInt1 = new int[4];
    arrayOfInt1[0] = (int)(arrayOfFloat1[0] + f1 * Math.cos(m * this.Pi / 180.0D));
    arrayOfInt1[1] = (int)(arrayOfFloat1[1] + f1 * Math.sin(m * this.Pi / 180.0D));
    arrayOfInt1[2] = (int)(arrayOfFloat1[0] + f1 * Math.cos((m + 180) * this.Pi / 180.0D));
    arrayOfInt1[3] = (int)(arrayOfFloat1[1] + f1 * Math.sin((m + 180) * this.Pi / 180.0D));
    int[] arrayOfInt2 = new int[4];
    arrayOfInt2[0] = (int)(arrayOfFloat1[0] + f1 * Math.cos(-i * this.Pi / 180.0D));
    arrayOfInt2[1] = (int)(arrayOfFloat1[1] + f1 * Math.sin(-i * this.Pi / 180.0D));
    arrayOfInt2[2] = (int)(arrayOfFloat1[0] + f1 * Math.cos((i + 180) * this.Pi / 180.0D));
    arrayOfInt2[3] = (int)(arrayOfFloat1[1] + f1 * Math.sin(-i * this.Pi / 180.0D));
    int[] arrayOfInt3 = new int[9];
    arrayOfInt3[0] = 0;
    arrayOfInt3[1] = 45;
    arrayOfInt3[2] = 90;
    arrayOfInt3[3] = 135;
    arrayOfInt3[4] = 180;
    arrayOfInt3[5] = 225;
    arrayOfInt3[6] = 270;
    arrayOfInt3[7] = 315;
    arrayOfInt3[8] = 360;
    paramCanvas.drawLine(arrayOfInt1[0], arrayOfInt1[1], arrayOfInt1[2], arrayOfInt1[3], this.mPaint[4]);
    paramCanvas.drawLine(arrayOfInt2[0], arrayOfInt2[1], arrayOfInt2[2], arrayOfInt2[3], this.mPaint[5]);
    paramCanvas.drawCircle(arrayOfFloat1[0], arrayOfFloat1[1], f1, this.mPaint[1]);
    this.mPaint[6] = new Paint();
    this.mPaint[6].setStrokeWidth(8.0F);
    this.mPaint[6].setColor(this.mContext.getResources().getColor(2131492904));
    for (j = 0; j < arrayOfInt3.length; j++)
      paramCanvas.drawPoint((float)(arrayOfFloat1[0] + f1 * Math.cos(arrayOfInt3[j] * this.Pi / 180.0D)), (float)(arrayOfFloat1[1] + f1 * Math.sin(arrayOfInt3[j] * this.Pi / 180.0D)), this.mPaint[6]); 
    this.mPaint[7] = new Paint();
    this.mPaint[7].setStyle(Paint.Style.FILL);
    this.mPaint[7].setColor(this.mContext.getResources().getColor(2131492954));
    f3 = (paramCanvas.getHeight() / 5);
    f4 = this.mPaint[2].getStrokeWidth();
    f2 = this.mspdata.getAnalogData()[0];
    f1 = f2;
    if (f2 == 0.1F)
      f1 = 2.5F; 
    f1 = (float)((arrayOfFloat2[3] - this.mPaint[2].getStrokeWidth() / 2.0F) - (f1 - 2.5D) / 1.7D * (f3 - f4));
    f2 = arrayOfFloat2[0];
    paramCanvas.drawRect(this.mPaint[2].getStrokeWidth() / 2.0F + f2, f1, arrayOfFloat2[2] - this.mPaint[2].getStrokeWidth() / 2.0F, arrayOfFloat2[3] - this.mPaint[2].getStrokeWidth() / 2.0F, this.mPaint[7]);
    this.mPaint[8] = new Paint();
    this.mPaint[8].setColor(this.mContext.getResources().getColor(2131492897));
    this.mPaint[8].setTextSize(80.0F);
    this.mPaint[8].setStrokeWidth(4.0F);
    this.mPaint[8].setTextAlign(Paint.Align.CENTER);
    if (this.mBTService != null) {
      if (this.mBTService.getmBluetoothService() != null) {
        if (this.mBTService.getmBluetoothService().getState() == 4) {
          if (m <= 4 && m >= -4 && i <= 4 && i >= -4) {
            paramCanvas.drawText("비 행  가 능", (paramCanvas.getWidth() / 2), (paramCanvas.getHeight() * 7 / 8), this.mPaint[8]);
            return;
          } 
          this.mPaint[8].setColor(-65536);
          paramCanvas.drawText("비 행  불 가", (paramCanvas.getWidth() / 2), (paramCanvas.getHeight() * 7 / 8), this.mPaint[8]);
          return;
        } 
        this.mPaint[8].setColor(-65536);
        paramCanvas.drawText("Disconnected", (paramCanvas.getWidth() / 2), (paramCanvas.getHeight() * 7 / 8), this.mPaint[8]);
        return;
      } 
      this.mPaint[8].setColor(-65536);
      paramCanvas.drawText("Disconnected", (paramCanvas.getWidth() / 2), (paramCanvas.getHeight() * 7 / 8), this.mPaint[8]);
      return;
    } 
    this.mPaint[8].setColor(-65536);
    paramCanvas.drawText("Disconnected", (paramCanvas.getWidth() / 2), (paramCanvas.getHeight() * 7 / 8), this.mPaint[8]);
  }
  
  private void drawTopicAndNext(Canvas paramCanvas) {
    this.mPaint[0] = new Paint();
    this.mPaint[0].setTextAlign(Paint.Align.LEFT);
    this.mPaint[0].setTextSize(70.0F);
    this.mPaint[0].setStrokeWidth(5.0F);
    this.mPaint[0].setColor(this.mContext.getResources().getColor(2131492907));
    BitmapFactory.decodeResource(this.mContext.getResources(), 2130903076);
    paramCanvas.drawText(" 비 행 ", this.mPaint[0].getTextSize() / 2.0F, this.mPaint[0].getTextSize() * 3.0F / 2.0F, this.mPaint[0]);
  }
  
  public void executeController() {
    if (this.mBTService.getmBluetoothService().getState() == 4) {
      if (this.mspdata.getAttitudeData()[0] > -5.0F && this.mspdata.getAttitudeData()[0] < 5.0F && this.mspdata.getAttitudeData()[1] >= -5.0F && this.mspdata.getAttitudeData()[1] <= 5.0F) {
        Intent intent = new Intent(this.mContext, JoystickActivity.class);
        this.mActivity.sendBroadcast((new Intent()).setAction("request controller display"));
        this.mActivity.startActivityForResult(intent, 3);
        this.mActivity.overridePendingTransition(2131034123, 2131034124);
        this.mSoundManager.play(0);
      } 
      return;
    } 
    if (this.mBTService.getmBluetoothService().getState() == 3) {
      Toast.makeText((Context)this.mActivity, "드론 연결 중...", 0).show();
      return;
    } 
    Toast.makeText((Context)this.mActivity, "드론을 연결해 주세요.", 0).show();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.canvas_width == 0.0F && this.canvas_height == 0.0F) {
      this.canvas_width = paramCanvas.getWidth();
      this.canvas_height = paramCanvas.getHeight();
      Log.d(this.TAG, "Canvas Width : " + this.canvas_width + "\nCanvas Height : " + this.canvas_height);
    } 
    drawTopicAndNext(paramCanvas);
    drawCurrentDrone(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() != 0 && paramMotionEvent.getAction() == 1) {
      try {
        Thread.sleep(30L);
      } catch (InterruptedException interruptedException) {}
      Log.d(this.TAG, "onTouch PlayFlight");
      executeController();
      return true;
    } 
    return true;
  }
  
  public void setmBTService(BTService paramBTService) {
    this.mBTService = paramBTService;
    Log.d(this.TAG, "set BTService in PlayFlight");
  }
  
  private class CurrentDrone {
    private float current_vbat;
    
    private Bitmap drone;
    
    private float pitch;
    
    private float roll;
    
    private float x;
    
    private float y;
    
    private float yaw;
    
    public CurrentDrone(Bitmap param1Bitmap, float param1Float1, float param1Float2) {
      this.drone = param1Bitmap;
      this.x = param1Float1;
      this.y = param1Float2;
    }
    
    public Bitmap getDrone() {
      return this.drone;
    }
    
    public float getX() {
      return this.x;
    }
    
    public float getY() {
      return this.y;
    }
    
    public void setRPY(float[] param1ArrayOffloat) {
      this.roll = param1ArrayOffloat[0];
      this.pitch = param1ArrayOffloat[1];
      this.yaw = param1ArrayOffloat[2];
    }
    
    public void setVbat(float param1Float) {
      this.current_vbat = param1Float;
    }
  }
  
  private class NextBtn {
    private Bitmap clickedicon;
    
    private Bitmap displayed_icon;
    
    private Bitmap icon;
    
    private float x;
    
    private float y;
    
    public NextBtn(Bitmap param1Bitmap1, Bitmap param1Bitmap2, float param1Float1, float param1Float2) {
      this.icon = param1Bitmap1;
      this.clickedicon = param1Bitmap2;
      this.x = param1Float1;
      this.y = param1Float2;
      this.displayed_icon = param1Bitmap1;
    }
    
    public Bitmap getClickedicon() {
      return this.clickedicon;
    }
    
    public Bitmap getDisplayed_icon() {
      return this.displayed_icon;
    }
    
    public Bitmap getIcon() {
      return this.icon;
    }
    
    public float getX() {
      return this.x;
    }
    
    public float getY() {
      return this.y;
    }
    
    public void setDisplayed_icon(boolean param1Boolean) {
      if (param1Boolean) {
        this.displayed_icon = this.clickedicon;
        return;
      } 
      this.displayed_icon = this.icon;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\MainView\Playflight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */