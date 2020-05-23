package com.drms.drms_drone.Controller.DroneController;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.drms.drms_drone.MultiData;
import com.drms.drms_drone.Sound.SoundManager;

public class Setting1View extends View {
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
  
  public Setting1View(Context paramContext, Activity paramActivity) {
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
    arrayOfPaint[0].setTextSize(6.0F * this.y);
    arrayOfPaint[0].setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawRect(10.0F * this.x, 5.0F * this.y, this.x * 70.0F, this.y * 15.0F, arrayOfPaint[0]);
    paramCanvas.drawLine(30.0F * this.x, 5.0F * this.y, 30.0F * this.x, this.y * 15.0F, arrayOfPaint[0]);
    paramCanvas.drawLine(this.x * 50.0F, 5.0F * this.y, this.x * 50.0F, this.y * 15.0F, arrayOfPaint[0]);
    arrayOfPaint[0].setStyle(Paint.Style.FILL);
    paramCanvas.drawText("DUAL1", 20.0F * this.x, this.y * 10.0F + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    paramCanvas.drawText("DUAL2", 40.0F * this.x, this.y * 10.0F + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    paramCanvas.drawText("SINGLE", 60.0F * this.x, this.y * 10.0F + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    arrayOfPaint[0].setStyle(Paint.Style.STROKE);
    arrayOfPaint[0].setColor(this.context.getResources().getColor(2131492946));
    arrayOfPaint[1] = new Paint();
    arrayOfPaint[1].setColor(this.context.getResources().getColor(2131492945));
    if (this.mspdata.getMYJOYSTICK() == 0) {
      paramCanvas.drawRect(10.0F * this.x, 5.0F * this.y, 30.0F * this.x, this.y * 15.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + f1 * 10.0F, arrayOfPaint[0].getStrokeWidth() / 2.0F + f3 * 5.0F, this.x * 30.0F - arrayOfPaint[0].getStrokeWidth() / 2.0F, 15.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("DUAL1", 20.0F * this.x, this.y * 10.0F + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } else if (this.mspdata.getMYJOYSTICK() == 1) {
      paramCanvas.drawRect(30.0F * this.x, 5.0F * this.y, this.x * 50.0F, this.y * 15.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + f1 * 30.0F, arrayOfPaint[0].getStrokeWidth() / 2.0F + f3 * 5.0F, 50.0F * this.x - arrayOfPaint[0].getStrokeWidth() / 2.0F, 15.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("DUAL2", 40.0F * this.x, this.y * 10.0F + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } else if (this.mspdata.getMYJOYSTICK() == 2) {
      paramCanvas.drawRect(this.x * 50.0F, 5.0F * this.y, this.x * 70.0F, this.y * 15.0F, arrayOfPaint[0]);
      float f1 = this.x;
      float f2 = arrayOfPaint[0].getStrokeWidth() / 2.0F;
      float f3 = this.y;
      paramCanvas.drawRect(f2 + 50.0F * f1, arrayOfPaint[0].getStrokeWidth() / 2.0F + f3 * 5.0F, 70.0F * this.x - arrayOfPaint[0].getStrokeWidth() / 2.0F, 15.0F * this.y - arrayOfPaint[0].getStrokeWidth(), arrayOfPaint[1]);
      arrayOfPaint[0].setStyle(Paint.Style.FILL);
      paramCanvas.drawText("SINGLE", 60.0F * this.x, this.y * 10.0F + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]);
    } 
    arrayOfPaint[2] = new Paint();
    arrayOfPaint[2].setColor(-16777216);
    arrayOfPaint[2].setStrokeWidth(5.0F);
    arrayOfPaint[2].setStyle(Paint.Style.STROKE);
    arrayOfPaint[3] = new Paint();
    arrayOfPaint[3].setColor(this.context.getResources().getColor(2131492895));
    arrayOfPaint[3].setStyle(Paint.Style.FILL);
    Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.context.getResources(), 2130903092), (int)(3.0F * this.x), (int)(3.0F * this.y), true);
    if (this.mspdata.getMYJOYSTICK() == 0 || this.mspdata.getMYJOYSTICK() == 1) {
      paramCanvas.drawRect(this.x * 20.0F, this.y * 20.0F, this.x * 60.0F, this.y * 40.0F, arrayOfPaint[2]);
      paramCanvas.drawRect(this.x * 23.0F, this.y * 23.0F, this.x * 37.0F, this.y * 37.0F, arrayOfPaint[3]);
      paramCanvas.drawRect(this.x * 43.0F, this.y * 23.0F, this.x * 57.0F, this.y * 37.0F, arrayOfPaint[3]);
      if (this.mspdata.getMYJOYSTICK() == 0) {
        paramCanvas.drawBitmap(bitmap, this.x * 30.0F - (bitmap.getWidth() / 2), this.y * 30.0F - (bitmap.getHeight() / 2), null);
        paramCanvas.drawBitmap(bitmap, 50.0F * this.x - (bitmap.getWidth() / 2), this.y * 30.0F - (bitmap.getHeight() / 2), null);
        return;
      } 
      if (this.mspdata.getMYJOYSTICK() == 1) {
        paramCanvas.drawBitmap(bitmap, this.x * 30.0F - (bitmap.getWidth() / 2), this.y * 30.0F - (bitmap.getHeight() / 2), null);
        arrayOfPaint[0].setTextSize(this.y * 2.0F);
        arrayOfPaint[0].setColor(this.context.getResources().getColor(2131492904));
        return;
      } 
      return;
    } 
    if (this.mspdata.getMYJOYSTICK() == 2) {
      paramCanvas.drawRect(30.0F * this.x, this.y * 17.0F, this.x * 50.0F, this.y * 43.0F, arrayOfPaint[2]);
      paramCanvas.drawRect(this.x * 32.0F, this.y * 25.0F, this.x * 48.0F, this.y * 41.0F, arrayOfPaint[3]);
      paramCanvas.drawBitmap(bitmap, 40.0F * this.x - (bitmap.getWidth() / 2), 33.0F * this.y - (bitmap.getHeight() / 2), null);
      return;
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0) {
      Intent intent = new Intent();
      if (paramMotionEvent.getX() >= 10.0F * this.x && paramMotionEvent.getX() < this.x * 30.0F && paramMotionEvent.getY() >= this.y * 5.0F && paramMotionEvent.getY() <= this.y * 15.0F) {
        this.mspdata.setMYJOYSTICK(0);
        this.mSoundManager.play(0);
        intent.setAction("request dual1");
        invalidate();
        this.context.sendBroadcast(intent);
        Log.d("Setting1View", "send BroadCast : " + intent.getAction());
      } 
      if (paramMotionEvent.getX() >= this.x * 30.0F && paramMotionEvent.getX() < this.x * 50.0F && paramMotionEvent.getY() >= this.y * 5.0F && paramMotionEvent.getY() <= this.y * 15.0F) {
        this.mspdata.setMYJOYSTICK(1);
        this.mSoundManager.play(0);
        intent.setAction("request dual2");
        invalidate();
        this.context.sendBroadcast(intent);
        Log.d("Setting1View", "send BroadCast : " + intent.getAction());
      } 
      if (paramMotionEvent.getX() >= this.x * 50.0F && paramMotionEvent.getX() < 70.0F * this.x && paramMotionEvent.getY() >= this.y * 5.0F && paramMotionEvent.getY() <= this.y * 15.0F) {
        this.mSoundManager.play(0);
        Toast.makeText((Context)this.activity, "준비 중 입니다.", 0).show();
        invalidate();
      } 
    } 
    return true;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Controller\DroneController\Setting1View.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */