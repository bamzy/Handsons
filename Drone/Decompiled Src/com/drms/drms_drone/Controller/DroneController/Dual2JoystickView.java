package com.drms.drms_drone.Controller.DroneController;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class Dual2JoystickView extends Joystick_view {
  private boolean isSensorActivation = false;
  
  int pitchToMSP = 0;
  
  int rollToMSP = 0;
  
  int sensorCount = 0;
  
  public Dual2JoystickView(Context paramContext, Activity paramActivity, Handler paramHandler) {
    super(paramContext, paramActivity, paramHandler);
    this.mSensorManager.registerListener(this.mSensorEventListener, this.mSensorManager.getDefaultSensor(3), 2);
  }
  
  protected Bitmap drawBackground(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2) {
    return super.drawBackground(paramFloat1, paramInt1, paramFloat2, paramInt2);
  }
  
  protected void drawController(Canvas paramCanvas) {
    super.drawController(paramCanvas);
  }
  
  public SensorManager getmSensorManager() {
    return this.mSensorManager;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), 2130903092), (int)(this.x * 6.0F), (int)(this.y * 6.0F), true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    int j = paramMotionEvent.getPointerCount();
    int i = j;
    if (j > 2)
      i = 2; 
    switch (paramMotionEvent.getAction()) {
      default:
        return true;
      case 0:
        Log.d("Joystick_view", "onTouch");
        Log.w("Joystick_view", "x: " + paramMotionEvent.getX() + "\ny : " + paramMotionEvent.getY());
        if (paramMotionEvent.getX() >= 3.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX() <= 33.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getY() >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY() <= 50.0F * this.y) {
          Log.d("Joystick_view", "unlock left throttle");
          if (this.mspdata.getRcdata()[7] == 1000) {
            float f1 = this.y;
            float f2 = this.droneThrottle.getThrottleImage().getHeight();
            if (paramMotionEvent.getY() <= 50.0F * this.y && paramMotionEvent.getY() >= 45.0F * f1 - f2)
              this.mspdata.setRawRCDataAux(4, 2000); 
          } 
          int[] arrayOfInt = new int[2];
          arrayOfInt[0] = (int)(paramMotionEvent.getX() - (this.droneThrottle.getThrottleImage().getWidth() / 2));
          arrayOfInt[1] = (int)(paramMotionEvent.getY() - (this.droneThrottle.getThrottleImage().getHeight() / 2));
          this.unlock_throttle[0][0] = true;
          this.unlock_throttle[0][1] = false;
          if (paramMotionEvent.getY() >= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY() <= 50.0F * this.y)
            if (paramMotionEvent.getX() >= 12.0F * this.x && paramMotionEvent.getX() <= 23.0F * this.x) {
              arrayOfInt[0] = (int)(45.0F * this.y - this.droneThrottle.getThrottleImage().getHeight());
            } else {
              this.unlock_throttle[0][0] = false;
              this.unlock_throttle[0][1] = false;
            }  
          if (this.unlock_throttle[0][1])
            this.droneThrottle.setLeft(arrayOfInt); 
        } else if (paramMotionEvent.getX() >= 52.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX() <= 82.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getY() >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY() <= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
          this.isSensorActivation = true;
        } else {
          this.unlock_throttle[0][0] = false;
          this.unlock_throttle[0][1] = false;
        } 
        if (paramMotionEvent.getX() >= 40.0F * this.x && paramMotionEvent.getX() <= 45.0F * this.x && paramMotionEvent.getY() >= 48.0F * this.y && paramMotionEvent.getY() <= 53.0F * this.y) {
          if (this.mspdata.getLocked()) {
            this.mspdata.setLocked(false);
          } else {
            this.mspdata.setLocked(true);
          } 
          this.mSoundManager.play(0);
          Log.d("Joystick_view", "locked : " + this.mspdata.getLocked());
        } 
        if (paramMotionEvent.getX() >= 2.0F * this.x && paramMotionEvent.getX() <= 9.0F * this.x && paramMotionEvent.getY() > 2.0F * this.y && paramMotionEvent.getY() < 12.0F * this.y) {
          this.mHandler.obtainMessage(0).sendToTarget();
          this.mSoundManager.play(0);
        } 
        if (paramMotionEvent.getX() >= 3.0F * this.x && paramMotionEvent.getX() <= 8.0F * this.x && paramMotionEvent.getY() >= 46.0F * this.y && paramMotionEvent.getY() <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setYawTream(this.mspdata.getTream()[2] - this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 28.0F * this.x && paramMotionEvent.getX() <= 33.0F * this.x && paramMotionEvent.getY() >= 46.0F * this.y && paramMotionEvent.getY() <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setYawTream(this.mspdata.getTream()[2] + this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 40.0F * this.x && paramMotionEvent.getX() <= 45.0F * this.x && paramMotionEvent.getY() >= 30.0F * this.y && paramMotionEvent.getY() <= 35.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setPitchTream(this.mspdata.getTream()[1] + this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 40.0F * this.x && paramMotionEvent.getX() <= 45.0F * this.x && paramMotionEvent.getY() >= 40.0F * this.y && paramMotionEvent.getY() <= 45.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setPitchTream(this.mspdata.getTream()[1] - this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 52.0F * this.x && paramMotionEvent.getX() <= 57.0F * this.x && paramMotionEvent.getY() >= 46.0F * this.y && paramMotionEvent.getY() <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setRollTream(this.mspdata.getTream()[0] - this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 77.0F * this.x && paramMotionEvent.getX() <= 82.0F * this.x && paramMotionEvent.getY() >= 46.0F * this.y && paramMotionEvent.getY() <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setRollTream(this.mspdata.getTream()[0] + this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 14.0F * this.x && paramMotionEvent.getX() <= 19.0F * this.x && paramMotionEvent.getY() >= 5.0F * this.y && paramMotionEvent.getY() <= 10.0F * this.y) {
          this.mSoundManager.play(0);
          if (this.mspdata.getReceivedRcdata()[4] == 2000) {
            this.mspdata.setRawRCDataAux(1, 1000);
          } else if (this.mspdata.getReceivedRcdata()[4] == 1000) {
            this.mspdata.setRawRCDataAux(1, 2000);
          } 
        } 
        if (paramMotionEvent.getX() >= 22.0F * this.x && paramMotionEvent.getX() <= 27.0F * this.x && paramMotionEvent.getY() >= 5.0F * this.y && paramMotionEvent.getY() <= 10.0F * this.y) {
          this.mSoundManager.play(0);
          if (this.mspdata.getReceivedRcdata()[5] == 2000) {
            this.mspdata.setRawRCDataAux(2, 1000);
          } else if (this.mspdata.getReceivedRcdata()[5] == 1000) {
            this.mspdata.setRawRCDataAux(2, 2000);
          } 
        } 
        if (paramMotionEvent.getX() >= 29.0F * this.x && paramMotionEvent.getX() <= 34.0F * this.x && paramMotionEvent.getY() >= 5.0F * this.y && paramMotionEvent.getY() <= 10.0F * this.y) {
          this.mSoundManager.play(0);
          if (this.mspdata.getReceivedRcdata()[6] == 2000) {
            this.mspdata.setRawRCDataAux(3, 1000);
          } else if (this.mspdata.getReceivedRcdata()[6] == 1000) {
            this.mspdata.setRawRCDataAux(3, 2000);
          } 
        } 
        if (paramMotionEvent.getX() >= 40.0F * this.x && paramMotionEvent.getX() <= 45.0F * this.x && paramMotionEvent.getY() >= 3.0F * this.y && paramMotionEvent.getY() <= 8.0F * this.y)
          if (!this.mspdata.getCalibration()[0]) {
            this.mSoundManager.play(0);
            this.mspdata.setACCCalibration(true);
            this.mspdata.setRawRCDataRollPitch(1500, 1500);
            this.mspdata.setRawRCDataYawThrottle(1500, 1000);
            for (i = 1; i < 5; i++)
              this.mspdata.setRawRCDataAux(i, 1000); 
            this.mHandler.postDelayed(new Runnable() {
                  public void run() {
                    Dual2JoystickView.this.mContext.sendBroadcast((new Intent()).setAction("request acc calibration"));
                  }
                },  500L);
          } else {
            Toast.makeText(this.mContext, "교정 중...", 0).show();
          }  
        if (paramMotionEvent.getX() >= 47.0F * this.x && paramMotionEvent.getX() <= 52.0F * this.x && paramMotionEvent.getY() >= 3.0F * this.y && paramMotionEvent.getY() <= 8.0F * this.y) {
          if (!this.mspdata.getCalibration()[1]) {
            this.mSoundManager.play(0);
            this.mspdata.setMAGCalibration(true);
            this.mspdata.setRawRCDataRollPitch(1500, 1500);
            this.mspdata.setRawRCDataYawThrottle(1500, 1000);
            for (i = 1; i < 5; i++)
              this.mspdata.setRawRCDataAux(i, 1000); 
            this.mHandler.postDelayed(new Runnable() {
                  public void run() {
                    Dual2JoystickView.this.mContext.sendBroadcast((new Intent()).setAction("request mag calibration"));
                  }
                },  500L);
          } 
          Toast.makeText(this.mContext, "교정 중...", 0).show();
        } 
      case 2:
        arrayOfInt2 = new int[2];
        arrayOfInt2[0] = this.droneThrottle.getLeft()[0];
        arrayOfInt2[1] = this.droneThrottle.getLeft()[1];
        j = this.droneThrottle.getRight()[0];
        j = this.droneThrottle.getRight()[1];
        if (i == 1) {
          if (this.unlock_throttle[0][0] && !this.unlock_throttle[0][1]) {
            if (paramMotionEvent.getX() >= 3.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX() <= 33.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2)) {
              if (!this.mspdata.getLocked()) {
                if (paramMotionEvent.getX() >= 3.0F * this.x + 6.0F * this.x && paramMotionEvent.getX() <= 33.0F * this.x - 6.0F * this.x) {
                  arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
                } else {
                  arrayOfInt2[0] = (int)paramMotionEvent.getX(0) - this.droneThrottle.getThrottleImage().getWidth() / 2;
                } 
              } else {
                arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
              } 
            } else if (paramMotionEvent.getX() > 33.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX() < this.width / 2.0F) {
              if (!this.mspdata.getLocked())
                arrayOfInt2[0] = (int)(33.0F * this.x - this.droneThrottle.getThrottleImage().getWidth()); 
            } else if (paramMotionEvent.getX() < 3.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2)) {
              if (!this.mspdata.getLocked())
                arrayOfInt2[0] = (int)(3.0F * this.x); 
            } else if (paramMotionEvent.getX() > this.width / 2.0F && !this.mspdata.getLocked()) {
              arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
            } 
            if (paramMotionEvent.getY() >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY() <= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
              arrayOfInt2[1] = (int)paramMotionEvent.getY() - this.droneThrottle.getThrottleImage().getHeight() / 2;
            } else if (paramMotionEvent.getY() < 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
              arrayOfInt2[1] = (int)(15.0F * this.y);
            } else if (paramMotionEvent.getY() > 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY() < this.height) {
              arrayOfInt2[1] = (int)(45.0F * this.y - this.droneThrottle.getThrottleImage().getHeight());
            } 
          } 
          if (this.unlock_throttle[1][0] && !this.unlock_throttle[1][1]) {
            if (paramMotionEvent.getX(0) >= 3.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX(0) <= 33.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2)) {
              if (!this.mspdata.getLocked()) {
                if (paramMotionEvent.getX(0) > 3.0F * this.x + 6.0F * this.x && paramMotionEvent.getX() < 33.0F * this.x - 6.0F * this.x) {
                  arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
                } else {
                  arrayOfInt2[0] = (int)paramMotionEvent.getX(0) - this.droneThrottle.getThrottleImage().getWidth() / 2;
                } 
              } else {
                arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
              } 
            } else if (paramMotionEvent.getX(0) > 33.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX(0) < this.width / 2.0F) {
              arrayOfInt2[0] = (int)(33.0F * this.x - this.droneThrottle.getThrottleImage().getWidth());
            } else if (paramMotionEvent.getX(0) < 3.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2)) {
              arrayOfInt2[0] = (int)(3.0F * this.x);
            } else if (paramMotionEvent.getX(0) > this.width / 2.0F) {
              arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
            } 
            if (paramMotionEvent.getY(0) >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY(0) <= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
              arrayOfInt2[1] = (int)paramMotionEvent.getY(0) - this.droneThrottle.getThrottleImage().getHeight() / 2;
            } else if (paramMotionEvent.getY(0) < 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
              arrayOfInt2[1] = (int)(15.0F * this.y);
            } else if (paramMotionEvent.getY(0) > 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY(0) < this.height) {
              arrayOfInt2[1] = (int)(45.0F * this.y - this.droneThrottle.getThrottleImage().getHeight());
            } 
          } 
          this.droneThrottle.setLeft(arrayOfInt2);
        } else if (i == 2) {
          if (this.unlock_throttle[0][0]) {
            if (paramMotionEvent.getX(0) >= 3.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX(0) <= 33.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2)) {
              if (!this.mspdata.getLocked()) {
                if (paramMotionEvent.getX(0) > 3.0F * this.x + 6.0F * this.x && paramMotionEvent.getX() < 33.0F * this.x - 6.0F * this.x) {
                  arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
                } else {
                  arrayOfInt2[0] = (int)paramMotionEvent.getX(0) - this.droneThrottle.getThrottleImage().getWidth() / 2;
                } 
              } else {
                arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
              } 
            } else if (paramMotionEvent.getX(0) > 33.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX(0) < this.width / 2.0F) {
              if (!this.mspdata.getLocked())
                arrayOfInt2[0] = (int)(33.0F * this.x - this.droneThrottle.getThrottleImage().getWidth()); 
            } else if (paramMotionEvent.getX(0) < 3.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2)) {
              if (!this.mspdata.getLocked())
                arrayOfInt2[0] = (int)(3.0F * this.x); 
            } else if (paramMotionEvent.getX(0) > this.width / 2.0F && !this.mspdata.getLocked()) {
              arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
            } 
            if (paramMotionEvent.getY(0) >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY(0) <= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
              arrayOfInt2[1] = (int)paramMotionEvent.getY(0) - this.droneThrottle.getThrottleImage().getHeight() / 2;
            } else if (paramMotionEvent.getY(0) < 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
              arrayOfInt2[1] = (int)(15.0F * this.y);
            } else if (paramMotionEvent.getY(0) > 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY(0) < this.height) {
              arrayOfInt2[1] = (int)(45.0F * this.y - this.droneThrottle.getThrottleImage().getHeight());
            } 
          } 
          if (this.unlock_throttle[1][0]) {
            if (paramMotionEvent.getX(1) >= 3.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX(1) <= 33.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2)) {
              if (!this.mspdata.getLocked()) {
                if (paramMotionEvent.getX(1) > 3.0F * this.x + 6.0F * this.x && paramMotionEvent.getX(1) < 33.0F * this.x - 6.0F * this.x) {
                  arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
                } else {
                  arrayOfInt2[0] = (int)paramMotionEvent.getX(1) - this.droneThrottle.getThrottleImage().getWidth() / 2;
                } 
              } else {
                arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
              } 
            } else if (paramMotionEvent.getX(1) > 33.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX(1) < this.width / 2.0F) {
              if (!this.mspdata.getLocked())
                arrayOfInt2[0] = (int)(33.0F * this.x - this.droneThrottle.getThrottleImage().getWidth()); 
            } else if (paramMotionEvent.getX(1) < 3.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2)) {
              if (!this.mspdata.getLocked())
                arrayOfInt2[0] = (int)(3.0F * this.x); 
            } else if (paramMotionEvent.getX(1) > this.width / 2.0F && !this.mspdata.getLocked()) {
              arrayOfInt2[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
            } 
            if (paramMotionEvent.getY(1) >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY(1) <= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
              arrayOfInt2[1] = (int)paramMotionEvent.getY(1) - this.droneThrottle.getThrottleImage().getHeight() / 2;
            } else if (paramMotionEvent.getY(1) < 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
              arrayOfInt2[1] = (int)(15.0F * this.y);
            } else if (paramMotionEvent.getY(1) > 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY(1) < this.height) {
              arrayOfInt2[1] = (int)(45.0F * this.y - this.droneThrottle.getThrottleImage().getHeight());
            } 
          } 
          this.droneThrottle.setLeft(arrayOfInt2);
        } 
        invalidate();
      case 5:
        if (paramMotionEvent.getX() >= 3.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX() <= 33.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getY() >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY() <= 50.0F * this.y) {
          Log.d("Joystick_view", "unlock left throttle");
          if (this.mspdata.getRcdata()[7] == 1000) {
            float f1 = this.y;
            float f2 = this.droneThrottle.getThrottleImage().getHeight();
            if (paramMotionEvent.getY() <= 50.0F * this.y && paramMotionEvent.getY() >= 45.0F * f1 - f2)
              this.mspdata.setRawRCDataAux(4, 2000); 
          } 
          arrayOfInt2 = new int[2];
          arrayOfInt2[0] = (int)(paramMotionEvent.getX() - (this.droneThrottle.getThrottleImage().getWidth() / 2));
          arrayOfInt2[1] = (int)(paramMotionEvent.getY() - (this.droneThrottle.getThrottleImage().getHeight() / 2));
          this.unlock_throttle[0][0] = true;
          this.unlock_throttle[0][1] = false;
          if (paramMotionEvent.getY() >= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY() <= 50.0F * this.y)
            if (paramMotionEvent.getX() >= 12.0F * this.x && paramMotionEvent.getX() <= 23.0F * this.x) {
              arrayOfInt2[0] = (int)(45.0F * this.y - this.droneThrottle.getThrottleImage().getHeight());
            } else {
              this.unlock_throttle[0][0] = false;
              this.unlock_throttle[0][1] = false;
            }  
          if (this.unlock_throttle[0][1])
            this.droneThrottle.setLeft(arrayOfInt2); 
        } else if (paramMotionEvent.getX(0) >= 52.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX(0) <= 82.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getY(0) >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY(0) <= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
          this.isSensorActivation = true;
        } 
        if (paramMotionEvent.getX() >= 40.0F * this.x && paramMotionEvent.getX() <= 45.0F * this.x && paramMotionEvent.getY() >= 48.0F * this.y && paramMotionEvent.getY() <= 53.0F * this.y) {
          if (this.mspdata.getLocked()) {
            this.mspdata.setLocked(false);
          } else {
            this.mspdata.setLocked(true);
          } 
          this.mSoundManager.play(0);
          Log.d("Joystick_view", "locked : " + this.mspdata.getLocked());
        } 
        if (paramMotionEvent.getX() >= 2.0F * this.x && paramMotionEvent.getX() <= 9.0F * this.x && paramMotionEvent.getY() > 2.0F * this.y && paramMotionEvent.getY() < 12.0F * this.y) {
          this.mHandler.obtainMessage(0).sendToTarget();
          this.mSoundManager.play(0);
        } 
        if (paramMotionEvent.getX() >= 3.0F * this.x && paramMotionEvent.getX() <= 8.0F * this.x && paramMotionEvent.getY() >= 46.0F * this.y && paramMotionEvent.getY() <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setYawTream(this.mspdata.getTream()[2] - this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 28.0F * this.x && paramMotionEvent.getX() <= 33.0F * this.x && paramMotionEvent.getY() >= 46.0F * this.y && paramMotionEvent.getY() <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setYawTream(this.mspdata.getTream()[2] + this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 40.0F * this.x && paramMotionEvent.getX() <= 45.0F * this.x && paramMotionEvent.getY() >= 30.0F * this.y && paramMotionEvent.getY() <= 35.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setPitchTream(this.mspdata.getTream()[1] + this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 40.0F * this.x && paramMotionEvent.getX() <= 45.0F * this.x && paramMotionEvent.getY() >= 40.0F * this.y && paramMotionEvent.getY() <= 45.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setPitchTream(this.mspdata.getTream()[1] - this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 52.0F * this.x && paramMotionEvent.getX() <= 57.0F * this.x && paramMotionEvent.getY() >= 46.0F * this.y && paramMotionEvent.getY() <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setRollTream(this.mspdata.getTream()[0] - this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 77.0F * this.x && paramMotionEvent.getX() <= 82.0F * this.x && paramMotionEvent.getY() >= 46.0F * this.y && paramMotionEvent.getY() <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setRollTream(this.mspdata.getTream()[0] + this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX() >= 14.0F * this.x && paramMotionEvent.getX() <= 19.0F * this.x && paramMotionEvent.getY() >= 5.0F * this.y && paramMotionEvent.getY() <= 10.0F * this.y) {
          this.mSoundManager.play(0);
          if (this.mspdata.getReceivedRcdata()[4] == 2000) {
            this.mspdata.setRawRCDataAux(1, 1000);
          } else if (this.mspdata.getReceivedRcdata()[4] == 1000) {
            this.mspdata.setRawRCDataAux(1, 2000);
          } 
        } 
        if (paramMotionEvent.getX() >= 22.0F * this.x && paramMotionEvent.getX() <= 27.0F * this.x && paramMotionEvent.getY() >= 5.0F * this.y && paramMotionEvent.getY() <= 10.0F * this.y) {
          this.mSoundManager.play(0);
          if (this.mspdata.getReceivedRcdata()[5] == 2000) {
            this.mspdata.setRawRCDataAux(2, 1000);
          } else if (this.mspdata.getReceivedRcdata()[5] == 1000) {
            this.mspdata.setRawRCDataAux(2, 2000);
          } 
        } 
        if (paramMotionEvent.getX() >= 29.0F * this.x && paramMotionEvent.getX() <= 34.0F * this.x && paramMotionEvent.getY() >= 5.0F * this.y && paramMotionEvent.getY() <= 10.0F * this.y) {
          this.mSoundManager.play(0);
          if (this.mspdata.getReceivedRcdata()[6] == 2000) {
            this.mspdata.setRawRCDataAux(3, 1000);
          } else if (this.mspdata.getReceivedRcdata()[6] == 1000) {
            this.mspdata.setRawRCDataAux(3, 2000);
          } 
        } 
        if (paramMotionEvent.getX() >= 40.0F * this.x && paramMotionEvent.getX() <= 45.0F * this.x && paramMotionEvent.getY() >= 3.0F * this.y && paramMotionEvent.getY() <= 8.0F * this.y)
          if (!this.mspdata.getCalibration()[0]) {
            this.mSoundManager.play(0);
            this.mspdata.setACCCalibration(true);
            this.mspdata.setRawRCDataRollPitch(1500, 1500);
            this.mspdata.setRawRCDataYawThrottle(1500, 1000);
            for (i = 1; i < 5; i++)
              this.mspdata.setRawRCDataAux(i, 1000); 
            this.mHandler.postDelayed(new Runnable() {
                  public void run() {
                    Dual2JoystickView.this.mContext.sendBroadcast((new Intent()).setAction("request acc calibration"));
                  }
                },  500L);
          } else {
            Toast.makeText(this.mContext, "교정 중...", 0).show();
          }  
        if (paramMotionEvent.getX() >= 47.0F * this.x && paramMotionEvent.getX() <= 52.0F * this.x && paramMotionEvent.getY() >= 3.0F * this.y && paramMotionEvent.getY() <= 8.0F * this.y) {
          if (!this.mspdata.getCalibration()[1]) {
            this.mSoundManager.play(0);
            this.mspdata.setMAGCalibration(true);
            this.mspdata.setRawRCDataRollPitch(1500, 1500);
            this.mspdata.setRawRCDataYawThrottle(1500, 1000);
            for (i = 1; i < 5; i++)
              this.mspdata.setRawRCDataAux(i, 1000); 
            this.mHandler.postDelayed(new Runnable() {
                  public void run() {
                    Dual2JoystickView.this.mContext.sendBroadcast((new Intent()).setAction("request mag calibration"));
                  }
                },  500L);
          } 
          Toast.makeText(this.mContext, "교정 중...", 0).show();
        } 
      case 261:
        Log.d("Joystick_view", "pointer2 down");
        if (paramMotionEvent.getX(1) >= 3.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX(1) <= 33.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getY(1) >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY(1) <= 50.0F * this.y) {
          Log.d("Joystick_view", "unlock left throttle");
          if (this.mspdata.getRcdata()[7] == 1000) {
            float f1 = this.y;
            float f2 = this.droneThrottle.getThrottleImage().getHeight();
            if (paramMotionEvent.getY(1) <= 50.0F * this.y && paramMotionEvent.getY(1) >= 45.0F * f1 - f2)
              this.mspdata.setRawRCDataAux(4, 2000); 
          } 
          arrayOfInt2 = new int[2];
          arrayOfInt2[0] = (int)(paramMotionEvent.getX(1) - (this.droneThrottle.getThrottleImage().getWidth() / 2));
          arrayOfInt2[1] = (int)(paramMotionEvent.getY(1) - (this.droneThrottle.getThrottleImage().getHeight() / 2));
          this.unlock_throttle[1][0] = true;
          this.unlock_throttle[1][1] = false;
          if (paramMotionEvent.getY(1) >= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY(1) <= 50.0F * this.y)
            if (paramMotionEvent.getX(1) >= 12.0F * this.x && paramMotionEvent.getX(1) <= 23.0F * this.x) {
              arrayOfInt2[0] = (int)(45.0F * this.y - this.droneThrottle.getThrottleImage().getHeight());
            } else {
              this.unlock_throttle[1][0] = false;
              this.unlock_throttle[1][1] = false;
            }  
          if (this.unlock_throttle[1][0])
            this.droneThrottle.setLeft(arrayOfInt2); 
        } else if (paramMotionEvent.getX(1) >= 52.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getX(1) <= 82.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && paramMotionEvent.getY(1) >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && paramMotionEvent.getY(1) <= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
          this.isSensorActivation = true;
        } 
        if (paramMotionEvent.getX(1) >= 40.0F * this.x && paramMotionEvent.getX(1) <= 45.0F * this.x && paramMotionEvent.getY(1) >= 48.0F * this.y && paramMotionEvent.getY(1) <= 53.0F * this.y) {
          if (this.mspdata.getLocked()) {
            this.mspdata.setLocked(false);
          } else {
            this.mspdata.setLocked(true);
          } 
          this.mSoundManager.play(0);
          Log.d("Joystick_view", "locked : " + this.mspdata.getLocked());
        } 
        if (paramMotionEvent.getX(1) >= 3.0F * this.x && paramMotionEvent.getX(1) <= 8.0F * this.x && paramMotionEvent.getY(1) >= 46.0F * this.y && paramMotionEvent.getY(1) <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setYawTream(this.mspdata.getTream()[2] - this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX(1) >= 28.0F * this.x && paramMotionEvent.getX(1) <= 33.0F * this.x && paramMotionEvent.getY(1) >= 46.0F * this.y && paramMotionEvent.getY(1) <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setYawTream(this.mspdata.getTream()[2] + this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX(1) >= 40.0F * this.x && paramMotionEvent.getX(1) <= 45.0F * this.x && paramMotionEvent.getY(1) >= 30.0F * this.y && paramMotionEvent.getY(1) <= 35.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setPitchTream(this.mspdata.getTream()[1] + this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX(1) >= 40.0F * this.x && paramMotionEvent.getX(1) <= 45.0F * this.x && paramMotionEvent.getY(1) >= 40.0F * this.y && paramMotionEvent.getY(1) <= 45.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setPitchTream(this.mspdata.getTream()[1] - this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX(1) >= 52.0F * this.x && paramMotionEvent.getX(1) <= 57.0F * this.x && paramMotionEvent.getY(1) >= 46.0F * this.y && paramMotionEvent.getY(1) <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setRollTream(this.mspdata.getTream()[0] - this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX(1) >= 77.0F * this.x && paramMotionEvent.getX(1) <= 82.0F * this.x && paramMotionEvent.getY(1) >= 46.0F * this.y && paramMotionEvent.getY(1) <= 51.0F * this.y) {
          this.mSoundManager.play(0);
          this.mspdata.setRollTream(this.mspdata.getTream()[0] + this.mspdata.getTreamInterval());
        } 
        if (paramMotionEvent.getX(1) >= 14.0F * this.x && paramMotionEvent.getX(1) <= 19.0F * this.x && paramMotionEvent.getY(1) >= 5.0F * this.y && paramMotionEvent.getY(1) <= 10.0F * this.y) {
          this.mSoundManager.play(0);
          if (this.mspdata.getReceivedRcdata()[4] == 2000) {
            this.mspdata.setRawRCDataAux(1, 1000);
          } else if (this.mspdata.getReceivedRcdata()[4] == 1000) {
            this.mspdata.setRawRCDataAux(1, 2000);
          } 
        } 
        if (paramMotionEvent.getX(1) >= 22.0F * this.x && paramMotionEvent.getX(1) <= 27.0F * this.x && paramMotionEvent.getY(1) >= 5.0F * this.y && paramMotionEvent.getY(1) <= 10.0F * this.y) {
          this.mSoundManager.play(0);
          if (this.mspdata.getReceivedRcdata()[5] == 2000) {
            this.mspdata.setRawRCDataAux(2, 1000);
          } else if (this.mspdata.getReceivedRcdata()[5] == 1000) {
            this.mspdata.setRawRCDataAux(2, 2000);
          } 
        } 
        if (paramMotionEvent.getX(1) >= 29.0F * this.x && paramMotionEvent.getX(1) <= 34.0F * this.x && paramMotionEvent.getY(1) >= 5.0F * this.y && paramMotionEvent.getY(1) <= 10.0F * this.y) {
          this.mSoundManager.play(0);
          if (this.mspdata.getReceivedRcdata()[6] == 2000) {
            this.mspdata.setRawRCDataAux(3, 1000);
          } else if (this.mspdata.getReceivedRcdata()[6] == 1000) {
            this.mspdata.setRawRCDataAux(3, 2000);
          } 
        } 
        if (paramMotionEvent.getX(1) >= 40.0F * this.x && paramMotionEvent.getX(1) <= 45.0F * this.x && paramMotionEvent.getY(1) >= 3.0F * this.y && paramMotionEvent.getY(1) <= 8.0F * this.y)
          if (!this.mspdata.getCalibration()[0]) {
            this.mSoundManager.play(0);
            this.mspdata.setACCCalibration(true);
            this.mspdata.setRawRCDataRollPitch(1500, 1500);
            this.mspdata.setRawRCDataYawThrottle(1500, 1000);
            for (i = 1; i < 5; i++)
              this.mspdata.setRawRCDataAux(i, 1000); 
            this.mHandler.postDelayed(new Runnable() {
                  public void run() {
                    Dual2JoystickView.this.mContext.sendBroadcast((new Intent()).setAction("request acc calibration"));
                  }
                },  500L);
          } else {
            Toast.makeText(this.mContext, "교정 중...", 0).show();
          }  
        if (paramMotionEvent.getX(1) >= 47.0F * this.x && paramMotionEvent.getX(1) <= 52.0F * this.x && paramMotionEvent.getY(1) >= 3.0F * this.y && paramMotionEvent.getY(1) <= 8.0F * this.y) {
          if (!this.mspdata.getCalibration()[1]) {
            this.mSoundManager.play(0);
            this.mspdata.setMAGCalibration(true);
            this.mspdata.setRawRCDataRollPitch(1500, 1500);
            this.mspdata.setRawRCDataYawThrottle(1500, 1000);
            for (i = 1; i < 5; i++)
              this.mspdata.setRawRCDataAux(i, 1000); 
            this.mHandler.postDelayed(new Runnable() {
                  public void run() {
                    Dual2JoystickView.this.mContext.sendBroadcast((new Intent()).setAction("request mag calibration"));
                  }
                },  500L);
          } 
          Toast.makeText(this.mContext, "교정 중...", 0).show();
        } 
      case 6:
        if (this.unlock_throttle[0][0]) {
          if (paramMotionEvent.getX(0) < this.width / 2.0F) {
            arrayOfInt1 = new int[2];
            if (this.mspdata.getRcdata()[6] == 2000) {
              arrayOfInt1[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
              arrayOfInt1[1] = (int)(30.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2));
            } else if (this.mspdata.getRcdata()[6] == 1000) {
              arrayOfInt1[0] = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
              arrayOfInt1[1] = this.droneThrottle.getLeft()[1];
            } 
            this.droneThrottle.setLeft(arrayOfInt1);
            this.unlock_throttle[0][0] = false;
            if (this.mspdata.getRcdata()[3] <= 1050)
              this.mspdata.setRawRCDataAux(4, 1000); 
          } 
        } else if (this.unlock_throttle[0][1] && arrayOfInt1.getX(0) >= 52.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && arrayOfInt1.getX(0) <= 82.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && arrayOfInt1.getY(0) >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && arrayOfInt1.getY(0) <= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
          this.isSensorActivation = false;
        } 
        Log.d("Joystick_view", "pointer1 count : " + i);
      case 262:
        if (arrayOfInt1.getX(1) < this.width / 2.0F) {
          j = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
          int k = this.droneThrottle.getLeft()[1];
          int m = (int)(67.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
          m = (int)(30.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2));
          this.droneThrottle.setLeft(new int[] { j, k });
          if (this.unlock_throttle[1][0])
            this.unlock_throttle[1][0] = false; 
          if (this.mspdata.getRcdata()[3] <= 1050)
            this.mspdata.setRawRCDataAux(4, 1000); 
        } else if (arrayOfInt1.getX(1) >= 52.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && arrayOfInt1.getX(1) <= 82.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && arrayOfInt1.getY(1) >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && arrayOfInt1.getY(1) <= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2)) {
          this.isSensorActivation = false;
        } 
        Log.d("Joystick_view", "pointer2 count : " + i);
      case 1:
        break;
    } 
    if (arrayOfInt1.getX() < this.width / 2.0F) {
      i = (int)(18.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
      j = this.droneThrottle.getLeft()[1];
      int k = (int)(67.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2));
      k = (int)(30.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2));
      this.droneThrottle.setLeft(new int[] { i, j });
      if (this.unlock_throttle[0][0])
        this.unlock_throttle[0][0] = false; 
      if (this.unlock_throttle[1][0])
        this.unlock_throttle[1][0] = false; 
      if (this.mspdata.getRcdata()[3] <= 1050)
        this.mspdata.setRawRCDataAux(4, 1000); 
    } 
    if (arrayOfInt1.getX(0) >= 52.0F * this.x + (this.droneThrottle.getThrottleImage().getWidth() / 2) && arrayOfInt1.getX(0) <= 82.0F * this.x - (this.droneThrottle.getThrottleImage().getWidth() / 2) && arrayOfInt1.getY(0) >= 15.0F * this.y + (this.droneThrottle.getThrottleImage().getHeight() / 2) && arrayOfInt1.getY(0) <= 45.0F * this.y - (this.droneThrottle.getThrottleImage().getHeight() / 2))
      this.isSensorActivation = false; 
  }
  
  private class SensorListener implements SensorEventListener {
    float pitch;
    
    float roll;
    
    float yaw;
    
    private SensorListener() {}
    
    public void onAccuracyChanged(Sensor param1Sensor, int param1Int) {}
    
    public void onSensorChanged(SensorEvent param1SensorEvent) {
      float[] arrayOfFloat = param1SensorEvent.values;
      Dual2JoystickView dual2JoystickView = Dual2JoystickView.this;
      int i = dual2JoystickView.sensorCount;
      dual2JoystickView.sensorCount = i + 1;
      if (i <= 1) {
        switch (param1SensorEvent.sensor.getType()) {
          default:
            return;
          case 3:
            break;
        } 
        if (Dual2JoystickView.this.isSensorActivation) {
          this.yaw = arrayOfFloat[0];
          this.roll = -arrayOfFloat[1];
          this.pitch = -arrayOfFloat[2];
          if (this.roll > Dual2JoystickView.this.mspdata.getSmartphoneAngle())
            this.roll = Dual2JoystickView.this.mspdata.getSmartphoneAngle(); 
          if (this.roll < -Dual2JoystickView.this.mspdata.getSmartphoneAngle())
            this.roll = -Dual2JoystickView.this.mspdata.getSmartphoneAngle(); 
          if (this.pitch > Dual2JoystickView.this.mspdata.getSmartphoneAngle())
            this.pitch = Dual2JoystickView.this.mspdata.getSmartphoneAngle(); 
          if (this.pitch < -Dual2JoystickView.this.mspdata.getSmartphoneAngle())
            this.pitch = -Dual2JoystickView.this.mspdata.getSmartphoneAngle(); 
        } else {
          this.roll = 0.0F;
          this.pitch = 0.0F;
        } 
        Dual2JoystickView.this.rollToMSP = (int)(this.roll * Dual2JoystickView.this.mspdata.getDRONE_SPEED() / Dual2JoystickView.this.mspdata.getSmartphoneAngle() + 1500.0F + Dual2JoystickView.this.mspdata.getTream()[0]);
        Dual2JoystickView.this.pitchToMSP = (int)(this.pitch * Dual2JoystickView.this.mspdata.getDRONE_SPEED() / Dual2JoystickView.this.mspdata.getSmartphoneAngle() + 1500.0F + Dual2JoystickView.this.mspdata.getTream()[1]);
        Dual2JoystickView.this.mspdata.setRawRCDataRollPitch(Dual2JoystickView.this.rollToMSP, Dual2JoystickView.this.pitchToMSP);
        return;
      } 
      Dual2JoystickView.this.sensorCount = 0;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Controller\DroneController\Dual2JoystickView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */