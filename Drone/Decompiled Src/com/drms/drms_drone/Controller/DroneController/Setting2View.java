package com.drms.drms_drone.Controller.DroneController;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.drms.drms_drone.MultiData;
import com.drms.drms_drone.Sound.SoundManager;

public class Setting2View extends View {
  public static final String REQUEST_DUAL1_JOYSTICK = "request dual1";
  
  public static final String REQUEST_DUAL2_JOYSTICK = "request dual2";
  
  public static final String REQUEST_SINGLE_JOYSTICK = "request single";
  
  private static final String TAG = "Setting1View";
  
  private Activity activity;
  
  private Context context;
  
  private SoundManager mSoundManager;
  
  private MultiData mspdata;
  
  private float x;
  
  private float y;
  
  public Setting2View(Context paramContext, Activity paramActivity) {
    super(paramContext);
    this.context = paramContext;
    this.activity = paramActivity;
    this.mSoundManager = new SoundManager(paramContext);
    this.mspdata = (MultiData)paramActivity.getApplication();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.x == 0.0F && this.y == 0.0F) {
      this.x = (paramCanvas.getWidth() / 80);
      this.y = (paramCanvas.getHeight() / 45);
      Log.d("Setting1View", "x : " + this.x + "\ny : " + this.y);
    } 
    Paint[] arrayOfPaint = new Paint[10];
    arrayOfPaint[0] = new Paint();
    arrayOfPaint[0].setColor(-16777216);
    arrayOfPaint[0].setStrokeWidth(5.0F);
    arrayOfPaint[0].setStyle(Paint.Style.STROKE);
    arrayOfPaint[0].setTextSize(4.0F * this.y);
    arrayOfPaint[0].setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawRect(this.x * 15.0F, this.y * 8.0F, 25.0F * this.x, this.y * 13.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(25.0F * this.x, this.y * 8.0F, 35.0F * this.x, this.y * 13.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(35.0F * this.x, this.y * 8.0F, this.x * 45.0F, this.y * 13.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(this.x * 45.0F, this.y * 8.0F, this.x * 55.0F, this.y * 13.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(this.x * 55.0F, this.y * 8.0F, this.x * 65.0F, this.y * 13.0F, arrayOfPaint[0]);
    arrayOfPaint[0].setStyle(Paint.Style.FILL);
    paramCanvas.drawText("비행 속도", 40.0F * this.x, 6.0F * this.y, arrayOfPaint[0]);
    arrayOfPaint[0].setTextSize(3.0F * this.y);
    paramCanvas.drawText("매우 느림", 20.0F * this.x, 10.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    paramCanvas.drawText("느림", 30.0F * this.x, 10.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    paramCanvas.drawText("중간", 40.0F * this.x, 10.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    paramCanvas.drawText("빠름", 50.0F * this.x, 10.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    paramCanvas.drawText("매우 빠름", 60.0F * this.x, 10.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    arrayOfPaint[0].setStyle(Paint.Style.STROKE);
    arrayOfPaint[0].setColor(this.context.getResources().getColor(2131492946));
    arrayOfPaint[1] = new Paint();
    arrayOfPaint[1].setColor(this.context.getResources().getColor(2131492945));
    if (this.mspdata.getDRONE_SPEED() == 100) {
      paramCanvas.drawRect(this.x * 15.0F, this.y * 8.0F, 25.0F * this.x, this.y * 13.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + 15.0F * f1, arrayOfPaint[0].getStrokeWidth() / 2.0F + 8.0F * f3, this.x * 25.0F - arrayOfPaint[0].getStrokeWidth() / 2.0F, 13.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("매우 느림", 20.0F * this.x, 10.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } else if (this.mspdata.getDRONE_SPEED() == 200) {
      paramCanvas.drawRect(25.0F * this.x, this.y * 8.0F, 35.0F * this.x, this.y * 13.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + f1 * 25.0F, arrayOfPaint[0].getStrokeWidth() / 2.0F + 8.0F * f3, this.x * 35.0F - arrayOfPaint[0].getStrokeWidth() / 2.0F, 13.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("느림", 30.0F * this.x, 10.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } else if (this.mspdata.getDRONE_SPEED() == 300) {
      paramCanvas.drawRect(35.0F * this.x, this.y * 8.0F, this.x * 45.0F, this.y * 13.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + f1 * 35.0F, arrayOfPaint[0].getStrokeWidth() / 2.0F + 8.0F * f3, 45.0F * this.x - arrayOfPaint[0].getStrokeWidth() / 2.0F, 13.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("중간", 40.0F * this.x, 10.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } else if (this.mspdata.getDRONE_SPEED() == 350) {
      paramCanvas.drawRect(this.x * 45.0F, this.y * 8.0F, this.x * 55.0F, this.y * 13.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + 45.0F * f1, arrayOfPaint[0].getStrokeWidth() / 2.0F + 8.0F * f3, 55.0F * this.x - arrayOfPaint[0].getStrokeWidth() / 2.0F, 13.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("빠름", 50.0F * this.x, 10.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } else if (this.mspdata.getDRONE_SPEED() == 400) {
      paramCanvas.drawRect(this.x * 55.0F, this.y * 8.0F, this.x * 65.0F, this.y * 13.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + 55.0F * f1, arrayOfPaint[0].getStrokeWidth() / 2.0F + 8.0F * f3, 65.0F * this.x - arrayOfPaint[0].getStrokeWidth() / 2.0F, 13.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("매우 빠름", 60.0F * this.x, 10.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } 
    arrayOfPaint[0].setTextSize(4.0F * this.y);
    arrayOfPaint[0].setColor(-16777216);
    paramCanvas.drawText("트림 조정 간격 ", 40.0F * this.x, 16.0F * this.y + arrayOfPaint[0].getTextSize(), arrayOfPaint[0]);
    arrayOfPaint[0].setColor(-16777216);
    arrayOfPaint[0].setStrokeWidth(5.0F);
    arrayOfPaint[0].setStyle(Paint.Style.STROKE);
    arrayOfPaint[0].setTextSize(4.0F * this.y);
    arrayOfPaint[0].setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawRect(this.x * 15.0F, this.y * 23.0F, 25.0F * this.x, this.y * 28.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(25.0F * this.x, this.y * 23.0F, 35.0F * this.x, this.y * 28.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(35.0F * this.x, this.y * 23.0F, this.x * 45.0F, this.y * 28.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(this.x * 45.0F, this.y * 23.0F, this.x * 55.0F, this.y * 28.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(this.x * 55.0F, this.y * 23.0F, this.x * 65.0F, this.y * 28.0F, arrayOfPaint[0]);
    arrayOfPaint[0].setStyle(Paint.Style.FILL);
    arrayOfPaint[0].setTextSize(3.0F * this.y);
    paramCanvas.drawText("1", 20.0F * this.x, 25.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    paramCanvas.drawText("2", 30.0F * this.x, 25.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    paramCanvas.drawText("3", 40.0F * this.x, 25.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    paramCanvas.drawText("4", 50.0F * this.x, 25.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    paramCanvas.drawText("5", 60.0F * this.x, 25.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    arrayOfPaint[0].setStyle(Paint.Style.STROKE);
    arrayOfPaint[0].setColor(this.context.getResources().getColor(2131492946));
    arrayOfPaint[1] = new Paint();
    arrayOfPaint[1].setColor(this.context.getResources().getColor(2131492945));
    if (this.mspdata.getTreamInterval() == 1) {
      paramCanvas.drawRect(this.x * 15.0F, this.y * 23.0F, 25.0F * this.x, this.y * 28.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + 15.0F * f1, arrayOfPaint[0].getStrokeWidth() / 2.0F + 23.0F * f3, this.x * 25.0F - arrayOfPaint[0].getStrokeWidth() / 2.0F, 28.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("1", 20.0F * this.x, 25.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } else if (this.mspdata.getTreamInterval() == 2) {
      paramCanvas.drawRect(25.0F * this.x, this.y * 23.0F, 35.0F * this.x, this.y * 28.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + f1 * 25.0F, arrayOfPaint[0].getStrokeWidth() / 2.0F + 23.0F * f3, this.x * 35.0F - arrayOfPaint[0].getStrokeWidth() / 2.0F, 28.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("2", 30.0F * this.x, 25.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } else if (this.mspdata.getTreamInterval() == 3) {
      paramCanvas.drawRect(35.0F * this.x, this.y * 23.0F, this.x * 45.0F, this.y * 28.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + f1 * 35.0F, arrayOfPaint[0].getStrokeWidth() / 2.0F + 23.0F * f3, 45.0F * this.x - arrayOfPaint[0].getStrokeWidth() / 2.0F, 28.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("3", 40.0F * this.x, 25.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } else if (this.mspdata.getTreamInterval() == 4) {
      paramCanvas.drawRect(this.x * 45.0F, this.y * 23.0F, this.x * 55.0F, this.y * 28.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + 45.0F * f1, arrayOfPaint[0].getStrokeWidth() / 2.0F + 23.0F * f3, 55.0F * this.x - arrayOfPaint[0].getStrokeWidth() / 2.0F, 28.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("4", 50.0F * this.x, 25.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } else if (this.mspdata.getTreamInterval() == 5) {
      paramCanvas.drawRect(this.x * 55.0F, this.y * 23.0F, this.x * 65.0F, this.y * 28.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + 55.0F * f1, arrayOfPaint[0].getStrokeWidth() / 2.0F + 23.0F * f3, 65.0F * this.x - arrayOfPaint[0].getStrokeWidth() / 2.0F, 28.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("5", 60.0F * this.x, 25.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } 
    if (this.mspdata.getMYJOYSTICK() == 1) {
      arrayOfPaint[0].setTextSize(4.0F * this.y);
      arrayOfPaint[0].setColor(-16777216);
      paramCanvas.drawText("스마트폰 최대 기울기", 40.0F * this.x, 31.0F * this.y + arrayOfPaint[0].getTextSize(), arrayOfPaint[0]);
      arrayOfPaint[0].setColor(-16777216);
      arrayOfPaint[0].setStrokeWidth(5.0F);
      arrayOfPaint[0].setStyle(Paint.Style.STROKE);
      arrayOfPaint[0].setTextSize(4.0F * this.y);
      arrayOfPaint[0].setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawRect(this.x * 15.0F, this.y * 38.0F, 25.0F * this.x, this.y * 43.0F, arrayOfPaint[0]);
      paramCanvas.drawRect(25.0F * this.x, this.y * 38.0F, 35.0F * this.x, this.y * 43.0F, arrayOfPaint[0]);
      paramCanvas.drawRect(35.0F * this.x, this.y * 38.0F, this.x * 45.0F, this.y * 43.0F, arrayOfPaint[0]);
      paramCanvas.drawRect(this.x * 45.0F, this.y * 38.0F, this.x * 55.0F, this.y * 43.0F, arrayOfPaint[0]);
      paramCanvas.drawRect(this.x * 55.0F, this.y * 38.0F, this.x * 65.0F, this.y * 43.0F, arrayOfPaint[0]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      arrayOfPaint[0].setTextSize(3.0F * this.y);
      paramCanvas.drawText("30˚", 20.0F * this.x, 40.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
      paramCanvas.drawText("40˚", 30.0F * this.x, 40.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
      paramCanvas.drawText("50˚", 40.0F * this.x, 40.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
      paramCanvas.drawText("60˚", 50.0F * this.x, 40.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
      paramCanvas.drawText("70˚", 60.0F * this.x, 40.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
      arrayOfPaint[0].setStyle(Paint.Style.STROKE);
      arrayOfPaint[0].setColor(this.context.getResources().getColor(2131492946));
      arrayOfPaint[1] = new Paint();
      arrayOfPaint[1].setColor(this.context.getResources().getColor(2131492945));
      if (this.mspdata.getSmartphoneAngle() == 30) {
        paramCanvas.drawRect(this.x * 15.0F, this.y * 38.0F, 25.0F * this.x, this.y * 43.0F, arrayOfPaint[0]);
        float f1 = this.x;
        float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
        float f3 = this.y;
        paramCanvas.drawRect(f2 + 15.0F * f1, arrayOfPaint[0].getStrokeWidth() / 2.0F + 38.0F * f3, this.x * 25.0F - arrayOfPaint[0].getStrokeWidth() / 2.0F, 43.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
        arrayOfPaint[0].setStyle(Paint.Style.FILL);
        paramCanvas.drawText("30˚", 20.0F * this.x, 40.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
        return;
      } 
    } else {
      return;
    } 
    if (this.mspdata.getSmartphoneAngle() == 40) {
      paramCanvas.drawRect(25.0F * this.x, this.y * 38.0F, 35.0F * this.x, this.y * 43.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + f1 * 25.0F, arrayOfPaint[0].getStrokeWidth() / 2.0F + 38.0F * f3, this.x * 35.0F - arrayOfPaint[0].getStrokeWidth() / 2.0F, 43.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("40˚", 30.0F * this.x, 40.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
      return;
    } 
    if (this.mspdata.getSmartphoneAngle() == 50) {
      paramCanvas.drawRect(35.0F * this.x, this.y * 38.0F, this.x * 45.0F, this.y * 43.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + f1 * 35.0F, arrayOfPaint[0].getStrokeWidth() / 2.0F + 38.0F * f3, 45.0F * this.x - arrayOfPaint[0].getStrokeWidth() / 2.0F, 43.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("50˚", 40.0F * this.x, 40.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
      return;
    } 
    if (this.mspdata.getSmartphoneAngle() == 60) {
      paramCanvas.drawRect(this.x * 45.0F, this.y * 38.0F, this.x * 55.0F, this.y * 43.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + 45.0F * f1, arrayOfPaint[0].getStrokeWidth() / 2.0F + 38.0F * f3, 55.0F * this.x - arrayOfPaint[0].getStrokeWidth() / 2.0F, 43.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("60˚", 50.0F * this.x, 40.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
      return;
    } 
    if (this.mspdata.getSmartphoneAngle() == 70) {
      paramCanvas.drawRect(this.x * 55.0F, this.y * 38.0F, this.x * 65.0F, this.y * 43.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + 55.0F * f1, arrayOfPaint[0].getStrokeWidth() / 2.0F + 38.0F * f3, 65.0F * this.x - arrayOfPaint[0].getStrokeWidth() / 2.0F, 43.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("70˚", 60.0F * this.x, 40.5F * this.y + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
      return;
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0) {
      new Intent();
      if (paramMotionEvent.getX() >= 15.0F * this.x && paramMotionEvent.getX() < this.x * 25.0F && paramMotionEvent.getY() >= 8.0F * this.y && paramMotionEvent.getY() <= 13.0F * this.y) {
        this.mspdata.setDRONE_SPEED(100);
        this.mSoundManager.play(0);
        invalidate();
      } 
      if (paramMotionEvent.getX() >= this.x * 25.0F && paramMotionEvent.getX() < this.x * 35.0F && paramMotionEvent.getY() >= 8.0F * this.y && paramMotionEvent.getY() <= 13.0F * this.y) {
        this.mspdata.setDRONE_SPEED(200);
        this.mSoundManager.play(0);
        invalidate();
      } 
      if (paramMotionEvent.getX() >= this.x * 35.0F && paramMotionEvent.getX() < this.x * 45.0F && paramMotionEvent.getY() >= 8.0F * this.y && paramMotionEvent.getY() <= 13.0F * this.y) {
        this.mspdata.setDRONE_SPEED(300);
        this.mSoundManager.play(0);
        invalidate();
      } 
      if (paramMotionEvent.getX() >= this.x * 45.0F && paramMotionEvent.getX() < this.x * 55.0F && paramMotionEvent.getY() >= 8.0F * this.y && paramMotionEvent.getY() <= 13.0F * this.y) {
        this.mspdata.setDRONE_SPEED(350);
        this.mSoundManager.play(0);
        invalidate();
      } 
      if (paramMotionEvent.getX() >= this.x * 55.0F && paramMotionEvent.getX() < 65.0F * this.x && paramMotionEvent.getY() >= 8.0F * this.y && paramMotionEvent.getY() <= 13.0F * this.y) {
        this.mspdata.setDRONE_SPEED(400);
        this.mSoundManager.play(0);
        invalidate();
      } 
      if (paramMotionEvent.getX() >= 15.0F * this.x && paramMotionEvent.getX() < this.x * 25.0F && paramMotionEvent.getY() >= 23.0F * this.y && paramMotionEvent.getY() <= 28.0F * this.y) {
        this.mspdata.setTreamInterval(1);
        this.mSoundManager.play(0);
        invalidate();
      } 
      if (paramMotionEvent.getX() >= this.x * 25.0F && paramMotionEvent.getX() < this.x * 35.0F && paramMotionEvent.getY() >= 23.0F * this.y && paramMotionEvent.getY() <= 28.0F * this.y) {
        this.mspdata.setTreamInterval(2);
        this.mSoundManager.play(0);
        invalidate();
      } 
      if (paramMotionEvent.getX() >= this.x * 35.0F && paramMotionEvent.getX() < this.x * 45.0F && paramMotionEvent.getY() >= 23.0F * this.y && paramMotionEvent.getY() <= 28.0F * this.y) {
        this.mspdata.setTreamInterval(3);
        this.mSoundManager.play(0);
        invalidate();
      } 
      if (paramMotionEvent.getX() >= this.x * 45.0F && paramMotionEvent.getX() < this.x * 55.0F && paramMotionEvent.getY() >= 23.0F * this.y && paramMotionEvent.getY() <= 28.0F * this.y) {
        this.mspdata.setTreamInterval(4);
        this.mSoundManager.play(0);
        invalidate();
      } 
      if (paramMotionEvent.getX() >= this.x * 55.0F && paramMotionEvent.getX() < 65.0F * this.x && paramMotionEvent.getY() >= 23.0F * this.y && paramMotionEvent.getY() <= 28.0F * this.y) {
        this.mspdata.setTreamInterval(5);
        this.mSoundManager.play(0);
        invalidate();
      } 
      if (this.mspdata.getMYJOYSTICK() == 1) {
        if (paramMotionEvent.getX() >= 15.0F * this.x && paramMotionEvent.getX() < this.x * 25.0F && paramMotionEvent.getY() >= 38.0F * this.y && paramMotionEvent.getY() <= 43.0F * this.y) {
          this.mspdata.setSmartphoneAngle(30);
          this.mSoundManager.play(0);
          invalidate();
        } 
        if (paramMotionEvent.getX() >= this.x * 25.0F && paramMotionEvent.getX() < this.x * 35.0F && paramMotionEvent.getY() >= 38.0F * this.y && paramMotionEvent.getY() <= 43.0F * this.y) {
          this.mspdata.setSmartphoneAngle(40);
          this.mSoundManager.play(0);
          invalidate();
        } 
        if (paramMotionEvent.getX() >= this.x * 35.0F && paramMotionEvent.getX() < this.x * 45.0F && paramMotionEvent.getY() >= 38.0F * this.y && paramMotionEvent.getY() <= 43.0F * this.y) {
          this.mspdata.setSmartphoneAngle(50);
          this.mSoundManager.play(0);
          invalidate();
        } 
        if (paramMotionEvent.getX() >= this.x * 45.0F && paramMotionEvent.getX() < this.x * 55.0F && paramMotionEvent.getY() >= 38.0F * this.y && paramMotionEvent.getY() <= 43.0F * this.y) {
          this.mspdata.setSmartphoneAngle(60);
          this.mSoundManager.play(0);
          invalidate();
        } 
        if (paramMotionEvent.getX() >= this.x * 55.0F && paramMotionEvent.getX() < 65.0F * this.x && paramMotionEvent.getY() >= 38.0F * this.y && paramMotionEvent.getY() <= 43.0F * this.y) {
          this.mspdata.setSmartphoneAngle(70);
          this.mSoundManager.play(0);
          invalidate();
        } 
      } 
      Log.d("Setting1View", "drone speed : " + this.mspdata.getDRONE_SPEED());
    } 
    return true;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Controller\DroneController\Setting2View.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */