package com.drms.drms_drone.Controller.DroneController;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.view.View;
import com.drms.drms_drone.Communication.ClassicBluetooth.BluetoothService;
import com.drms.drms_drone.MultiData;
import com.drms.drms_drone.Sound.SoundManager;
import java.lang.reflect.Array;

public class DrsControllerView extends View {
  protected static final String TAG = "DrsControllerView";
  
  protected Bitmap backBitmap;
  
  protected Throttle droneThrottle;
  
  protected float height = 0.0F;
  
  protected long init_time = 0L;
  
  private boolean isArmed = false;
  
  protected Activity mActivity;
  
  protected BluetoothService mBluetoothService;
  
  protected Context mContext;
  
  protected Handler mHandler;
  
  protected SensorEventListener mSensorEventListener;
  
  protected SensorManager mSensorManager;
  
  protected SoundManager mSoundManager;
  
  protected int minute = 0;
  
  protected MultiData mspdata;
  
  protected int seconds = 1;
  
  protected long timer = 0L;
  
  protected final int unitHeight = 60;
  
  protected final int unitWidth = 85;
  
  protected boolean[][] unlock_throttle = (boolean[][])Array.newInstance(boolean.class, new int[] { 2, 2 });
  
  protected boolean unlocked_left_throttle = false;
  
  protected boolean unlocked_right_throttle = false;
  
  protected float width = 0.0F;
  
  protected float x;
  
  protected float y;
  
  public DrsControllerView(Context paramContext, Activity paramActivity, Handler paramHandler) {
    super(paramContext);
    this.mActivity = paramActivity;
    this.mContext = paramContext;
    this.mspdata = (MultiData)paramActivity.getApplication();
    this.mHandler = paramHandler;
    this.mSoundManager = new SoundManager(this.mContext);
    this.init_time = System.currentTimeMillis() / 1000L;
  }
  
  protected Bitmap drawBackground(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2) {
    Paint[] arrayOfPaint = new Paint[10];
    arrayOfPaint[0] = new Paint();
    arrayOfPaint[0].setAlpha(20);
    arrayOfPaint[0].setStrokeWidth(3.0F);
    arrayOfPaint[0].setColor(this.mContext.getResources().getColor(2131492904));
    arrayOfPaint[0].setARGB(130, 167, 167, 167);
    arrayOfPaint[0].setStyle(Paint.Style.FILL);
    Bitmap bitmap1 = Bitmap.createBitmap((int)paramFloat1, (int)paramFloat2, Bitmap.Config.ARGB_8888);
    Canvas canvas1 = new Canvas(bitmap1);
    arrayOfPaint[1] = new Paint();
    arrayOfPaint[1].setStrokeWidth(7.0F);
    arrayOfPaint[1].setColor(-16777216);
    arrayOfPaint[2] = new Paint();
    arrayOfPaint[2].setStrokeWidth(5.0F);
    arrayOfPaint[2].setColor(this.mContext.getResources().getColor(2131492905));
    canvas1.drawLine(35.0F * this.x, 13.0F * this.y, 37.0F * this.x, 13.0F * this.y, arrayOfPaint[1]);
    canvas1.drawLine(48.0F * this.x, 13.0F * this.y, 50.0F * this.x, 13.0F * this.y, arrayOfPaint[1]);
    canvas1.drawLine(35.0F * this.x, 27.0F * this.y, 37.0F * this.x, 27.0F * this.y, arrayOfPaint[1]);
    canvas1.drawLine(48.0F * this.x, 27.0F * this.y, 50.0F * this.x, 27.0F * this.y, arrayOfPaint[1]);
    canvas1.drawLine(35.0F * this.x + arrayOfPaint[1].getStrokeWidth() / 2.0F, 13.0F * this.y - arrayOfPaint[1].getStrokeWidth() / 2.0F, 35.0F * this.x + arrayOfPaint[1].getStrokeWidth() / 2.0F, 27.0F * this.y + arrayOfPaint[1].getStrokeWidth() / 2.0F, arrayOfPaint[1]);
    canvas1.drawLine(50.0F * this.x + arrayOfPaint[1].getStrokeWidth() / 2.0F, 13.0F * this.y - arrayOfPaint[1].getStrokeWidth() / 2.0F, 50.0F * this.x + arrayOfPaint[1].getStrokeWidth() / 2.0F, 27.0F * this.y + arrayOfPaint[1].getStrokeWidth() / 2.0F, arrayOfPaint[1]);
    canvas1.drawLine(40.0F * this.x, 13.0F * this.y, 45.0F * this.x, 13.0F * this.y, arrayOfPaint[2]);
    canvas1.drawLine(40.0F * this.x, 20.0F * this.y, 45.0F * this.x, 20.0F * this.y, arrayOfPaint[2]);
    canvas1.drawLine(40.0F * this.x, 27.0F * this.y, 45.0F * this.x, 27.0F * this.y, arrayOfPaint[2]);
    arrayOfPaint[2].setColor(-16777216);
    for (paramInt1 = 0; paramInt1 < 6; paramInt1++)
      canvas1.drawLine(42.0F * this.x, (paramInt1 + 14) * this.y, 43.0F * this.x, (paramInt1 + 14) * this.y, arrayOfPaint[2]); 
    for (paramInt1 = 0; paramInt1 < 6; paramInt1++)
      canvas1.drawLine(42.0F * this.x, (paramInt1 + 21) * this.y, 43.0F * this.x, (paramInt1 + 21) * this.y, arrayOfPaint[2]); 
    arrayOfPaint[2].setColor(this.mContext.getResources().getColor(2131492954));
    arrayOfPaint[2].setStrokeWidth(10.0F);
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inSampleSize = 2;
    Bitmap[] arrayOfBitmap1 = new Bitmap[4];
    arrayOfBitmap1[0] = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903073, options);
    arrayOfBitmap1[1] = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903068, options);
    arrayOfBitmap1[2] = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903069, options);
    arrayOfBitmap1[3] = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903071, options);
    BitmapFactory.decodeResource(this.mContext.getResources(), 2130903093, options);
    BitmapFactory.decodeResource(this.mContext.getResources(), 2130903056, options);
    BitmapFactory.decodeResource(this.mContext.getResources(), 2130903063, options);
    BitmapFactory.decodeResource(this.mContext.getResources(), 2130903084, options);
    Bitmap[] arrayOfBitmap2 = new Bitmap[4];
    Bitmap[] arrayOfBitmap3 = new Bitmap[4];
    for (paramInt1 = 0; paramInt1 < 4; paramInt1++)
      arrayOfBitmap2[paramInt1] = Bitmap.createScaledBitmap(arrayOfBitmap1[paramInt1], (int)(5.0F * this.x), (int)(5.0F * this.y), true); 
    for (paramInt1 = 0; paramInt1 < 4; paramInt1++)
      arrayOfBitmap3[paramInt1] = Bitmap.createScaledBitmap(arrayOfBitmap1[paramInt1], (int)(5.0F * this.x), (int)(5.0F * this.y), true); 
    if (this.mspdata.getTream_touched()[0]) {
      canvas1.drawBitmap(arrayOfBitmap3[2], 52.0F * this.x, 46.0F * this.y, null);
    } else {
      canvas1.drawBitmap(arrayOfBitmap2[2], 52.0F * this.x, 46.0F * this.y, null);
    } 
    if (this.mspdata.getTream_touched()[1]) {
      canvas1.drawBitmap(arrayOfBitmap3[3], 77.0F * this.x, 46.0F * this.y, null);
    } else {
      canvas1.drawBitmap(arrayOfBitmap2[3], 77.0F * this.x, 46.0F * this.y, null);
    } 
    if (this.mspdata.getTream_touched()[2]) {
      canvas1.drawBitmap(arrayOfBitmap3[1], 40.0F * this.x, 40.0F * this.y, null);
    } else {
      canvas1.drawBitmap(arrayOfBitmap2[1], 40.0F * this.x, 40.0F * this.y, null);
    } 
    if (this.mspdata.getTream_touched()[3]) {
      canvas1.drawBitmap(arrayOfBitmap3[0], 40.0F * this.x, 30.0F * this.y, null);
    } else {
      canvas1.drawBitmap(arrayOfBitmap2[0], 40.0F * this.x, 30.0F * this.y, null);
    } 
    if (this.mspdata.getTream_touched()[4]) {
      canvas1.drawBitmap(arrayOfBitmap3[2], 3.0F * this.x, 46.0F * this.y, null);
    } else {
      canvas1.drawBitmap(arrayOfBitmap2[2], 3.0F * this.x, 46.0F * this.y, null);
    } 
    if (this.mspdata.getTream_touched()[5]) {
      canvas1.drawBitmap(arrayOfBitmap3[3], 28.0F * this.x, 46.0F * this.y, null);
    } else {
      canvas1.drawBitmap(arrayOfBitmap2[3], 28.0F * this.x, 46.0F * this.y, null);
    } 
    Bitmap bitmap2 = Bitmap.createBitmap((int)(7.0F * this.x), (int)(5.0F * this.y), Bitmap.Config.ARGB_8888);
    Canvas canvas2 = new Canvas(bitmap2);
    Paint paint = new Paint();
    paint.setStrokeWidth(5.0F);
    paint.setColor(-16777216);
    for (paramInt1 = 0; paramInt1 < 3; paramInt1++)
      canvas1.drawLine((canvas2.getWidth() / 5), (canvas2.getHeight() * (paramInt1 + 1) / 4), (canvas2.getWidth() * 4 / 5), (canvas2.getHeight() * (paramInt1 + 1) / 4), paint); 
    canvas1.drawBitmap(bitmap2, 2.0F * this.x, 2.0F * this.y, null);
    arrayOfPaint[3] = new Paint();
    arrayOfPaint[3].setARGB(255, 250, 224, 212);
    arrayOfPaint[3].setStrokeWidth(5.0F);
    arrayOfPaint[3].setStyle(Paint.Style.STROKE);
    canvas1.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), 2130903059), (int)(5.0F * this.x), (int)(5.0F * this.y), true), 73.0F * this.x, 53.0F * this.y, null);
    canvas1.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), 2130903067), (int)(5.0F * this.x), (int)(5.0F * this.y), true), 60.0F * this.x, 53.0F * this.y, null);
    canvas1.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), 2130837607), (int)(20.0F * this.x), (int)(9.0F * this.y), true), (int)(57.0F * this.x), (int)(4.0F * this.y), null);
    return bitmap1;
  }
  
  protected void drawController(Canvas paramCanvas) {
    String str1;
    Bitmap bitmap1;
    String str2;
    Bitmap bitmap3;
    this.timer = System.currentTimeMillis() / 1000L - this.init_time;
    this.minute = (int)(this.timer / 60L);
    this.seconds = (int)(this.timer % 60L);
    Paint[] arrayOfPaint = new Paint[10];
    arrayOfPaint[0] = new Paint();
    arrayOfPaint[0].setStrokeWidth(10.0F);
    arrayOfPaint[0].setColor(this.mContext.getResources().getColor(2131492947));
    float f2 = -this.mspdata.getAttitudeData()[1];
    float f3 = this.mspdata.getAttitudeData()[0];
    float f1 = f2;
    if (f2 > 60.0F)
      f1 = 60.0F; 
    f2 = f1;
    if (f1 < -60.0F)
      f2 = -60.0F; 
    f1 = f3;
    if (f3 > 90.0F)
      f1 = 90.0F; 
    f3 = f1;
    if (f1 < -90.0F)
      f3 = -90.0F; 
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (35.0F * this.x + 50.0F * this.x) / 2.0F;
    arrayOfFloat[1] = (13.0F * this.y + 27.0F * this.y) / 2.0F + 5.0F * this.x * f2 / 60.0F;
    f1 = 5.0F * this.x;
    paramCanvas.drawLine(this.x * 37.0F, arrayOfFloat[1], this.x * 48.0F, arrayOfFloat[1], arrayOfPaint[0]);
    arrayOfPaint[0].setColor(this.mContext.getResources().getColor(2131492907));
    arrayOfFloat[1] = (13.0F * this.y + 27.0F * this.y) / 2.0F;
    paramCanvas.drawLine((float)(arrayOfFloat[0] + f1 * Math.cos(f3 * 3.141592D / 180.0D)), (float)(arrayOfFloat[1] + f1 * Math.sin(f3 * 3.141592D / 180.0D)), (float)(arrayOfFloat[0] + f1 * Math.cos((180.0F + f3) * 3.141592D / 180.0D)), (float)(arrayOfFloat[1] + f1 * Math.sin((180.0F + f3) * 3.141592D / 180.0D)), arrayOfPaint[0]);
    arrayOfPaint[1] = new Paint();
    arrayOfPaint[1].setTextSize((float)(2.5D * this.x));
    arrayOfPaint[1].setColor(this.mContext.getResources().getColor(2131492904));
    arrayOfPaint[1].setStrokeWidth(3.0F);
    arrayOfPaint[1].setTextAlign(Paint.Align.CENTER);
    int i = (int)((this.mspdata.getAnalogData()[0] - 2.5D) / 1.7D * 100.0D);
    arrayOfPaint[1].measureText(String.valueOf(i) + " %");
    paramCanvas.drawText(String.valueOf(i) + " %", 81.0F * this.x, 55.0F * this.y + arrayOfPaint[1].getTextSize() / 2.0F, arrayOfPaint[1]);
    i = this.mspdata.getMobile_vbat();
    arrayOfPaint[1].measureText(String.valueOf(i) + " %");
    paramCanvas.drawText(String.valueOf(i) + " %", 68.0F * this.x, 55.0F * this.y + arrayOfPaint[1].getTextSize() / 2.0F, arrayOfPaint[1]);
    Bitmap bitmap2 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903044);
    if (this.mBluetoothService != null)
      if (this.mBluetoothService.getState() == 4) {
        bitmap2 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903045);
      } else {
        bitmap2 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903044);
      }  
    f1 = 5.0F * this.x / bitmap2.getHeight();
    paramCanvas.drawBitmap(Bitmap.createScaledBitmap(bitmap2, (int)(bitmap2.getWidth() * f1), (int)(bitmap2.getHeight() * f1), true), this.x, 53.0F * this.y, null);
    bitmap2 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903050);
    Bitmap bitmap4 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903043);
    Bitmap bitmap5 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903041);
    Bitmap[] arrayOfBitmap = new Bitmap[4];
    for (i = 0; i < 3; i++) {
      if (this.mspdata.getReceivedRcdata()[i + 4] == 1000) {
        arrayOfBitmap[i] = Bitmap.createScaledBitmap(bitmap2, (int)(5.0F * this.x), (int)(5.0F * this.y), true);
      } else if (this.mspdata.getReceivedRcdata()[i + 4] == 2000) {
        arrayOfBitmap[i] = Bitmap.createScaledBitmap(bitmap4, (int)(5.0F * this.x), (int)(5.0F * this.y), true);
      } else {
        arrayOfBitmap[i] = Bitmap.createScaledBitmap(bitmap2, (int)(5.0F * this.x), (int)(5.0F * this.y), true);
      } 
    } 
    Bitmap.createScaledBitmap(bitmap5, (int)(5.0F * this.x), (int)(5.0F * this.y), true);
    arrayOfPaint[2] = new Paint();
    arrayOfPaint[2].setColor(-16777216);
    arrayOfPaint[2].setTextSize(2.0F * this.x);
    arrayOfPaint[2].setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawBitmap(arrayOfBitmap[0], (int)(14.0F * this.x), (int)(3.0F * this.y), null);
    paramCanvas.drawBitmap(arrayOfBitmap[1], (int)(22.0F * this.x), (int)(3.0F * this.y), null);
    paramCanvas.drawBitmap(arrayOfBitmap[2], (int)(29.0F * this.x), (int)(3.0F * this.y), null);
    paramCanvas.drawText("Aux1", (int)(16.5D * this.x), (int)(11.0F * this.y), arrayOfPaint[2]);
    paramCanvas.drawText("Aux2", (int)(24.5D * this.x), (int)(11.0F * this.y), arrayOfPaint[2]);
    paramCanvas.drawText("Aux3", (int)(31.5D * this.x), (int)(11.0F * this.y), arrayOfPaint[2]);
    if (this.mspdata.getReceivedRcdata()[7] == 1000) {
      bitmap2 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903079);
    } else if (this.mspdata.getReceivedRcdata()[7] == 2000) {
      bitmap2 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903080);
    } else {
      bitmap2 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903079);
    } 
    paramCanvas.drawBitmap(Bitmap.createScaledBitmap(bitmap2, (int)(7.0F * this.x), (int)(7.0F * this.y), true), 58.0F * this.x, 5.0F * this.y, null);
    arrayOfPaint[3] = new Paint();
    arrayOfPaint[3].setColor(-16777216);
    arrayOfPaint[3].setStrokeWidth(3.0F);
    arrayOfPaint[3].setTextSize(3.0F * this.x);
    arrayOfPaint[3].setTextAlign(Paint.Align.CENTER);
    if (this.minute < 10) {
      str1 = "0" + String.valueOf(this.minute);
    } else {
      str1 = String.valueOf(this.minute);
    } 
    if (this.seconds < 10) {
      str2 = "0" + String.valueOf(this.seconds);
    } else {
      str2 = String.valueOf(this.seconds);
    } 
    arrayOfPaint[4] = new Paint();
    arrayOfPaint[4].setTextSize(2.0F * this.y);
    arrayOfPaint[4].setColor(-1);
    arrayOfPaint[4].setStrokeWidth(8.0F);
    arrayOfPaint[4].setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawText(String.valueOf(this.mspdata.getTream()[0]), (int)(67.0F * this.x), (int)(48.5F * this.y) + arrayOfPaint[4].getTextSize() / 2.0F, arrayOfPaint[4]);
    paramCanvas.drawText(String.valueOf(this.mspdata.getTream()[1]), (int)(42.5F * this.x), (int)(37.5F * this.y) + arrayOfPaint[4].getTextSize() / 2.0F, arrayOfPaint[4]);
    paramCanvas.drawText(String.valueOf(this.mspdata.getTream()[2]), (int)(18.0F * this.x), (int)(48.5F * this.y) + arrayOfPaint[4].getTextSize() / 2.0F, arrayOfPaint[4]);
    paramCanvas.drawText(str1 + ":" + str2, (int)(71.0F * this.x), (int)(8.0F * this.y) + arrayOfPaint[3].getTextSize() / 2.0F, arrayOfPaint[3]);
    if (this.mspdata.getCalibration()[0] == true) {
      bitmap1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), 2130903051), (int)(5.0F * this.x), (int)(5.0F * this.y), true);
    } else {
      bitmap1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), 2130903050), (int)(5.0F * this.x), (int)(5.0F * this.y), true);
    } 
    if (this.mspdata.getCalibration()[1] == true) {
      bitmap3 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), 2130903051), (int)(5.0F * this.x), (int)(5.0F * this.y), true);
    } else {
      bitmap3 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), 2130903050), (int)(5.0F * this.x), (int)(5.0F * this.y), true);
    } 
    paramCanvas.drawText("acc교정", 42.5F * this.x, 8.0F * this.y + arrayOfPaint[4].getTextSize(), arrayOfPaint[4]);
    paramCanvas.drawText(" mag교정", 49.5F * this.x, 8.0F * this.y + arrayOfPaint[4].getTextSize(), arrayOfPaint[4]);
    paramCanvas.drawBitmap(bitmap1, 40.0F * this.x, 3.0F * this.y, null);
    paramCanvas.drawBitmap(bitmap3, 47.0F * this.x, 3.0F * this.y, null);
    arrayOfPaint[5] = new Paint();
    arrayOfPaint[5].setTextAlign(Paint.Align.CENTER);
    arrayOfPaint[5].setColor(this.mContext.getResources().getColor(2131492904));
    arrayOfPaint[5].setStrokeWidth(4.0F);
  }
  
  protected SensorEventListener getmSensorEventListener() {
    return this.mSensorEventListener;
  }
  
  protected SensorManager getmSensorManager() {
    return this.mSensorManager;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    Paint paint = new Paint();
    paint.setStrokeWidth(5.0F);
    paint.setColor(-1);
    if (this.backBitmap == null) {
      this.width = paramCanvas.getWidth();
      this.height = paramCanvas.getHeight();
      this.x = this.width / 85.0F;
      this.y = this.height / 60.0F;
      setBackground((Drawable)new BitmapDrawable(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), 2130837591), (int)this.width, (int)this.height, true)));
      this.backBitmap = drawBackground(this.width, 85, this.height, 60);
      setBackground((Drawable)new BitmapDrawable(this.backBitmap));
    } 
    drawController(paramCanvas);
  }
  
  public void setmBluetoothService(BluetoothService paramBluetoothService) {
    this.mBluetoothService = paramBluetoothService;
  }
  
  protected class SensorListener implements SensorEventListener {
    public void onAccuracyChanged(Sensor param1Sensor, int param1Int) {}
    
    public void onSensorChanged(SensorEvent param1SensorEvent) {}
  }
  
  public class Throttle {
    private int[] RawRc = new int[4];
    
    private int[] left;
    
    private int[] right;
    
    private Bitmap throttleImage;
    
    private int throttle_height;
    
    private int[][] throttle_position = (int[][])Array.newInstance(int.class, new int[] { 2, 2 });
    
    private int throttle_width;
    
    public Throttle(Bitmap param1Bitmap, int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
      this.throttleImage = param1Bitmap;
      this.left = param1ArrayOfint1;
      this.right = param1ArrayOfint2;
      int i;
      for (i = 0; i < 2; i++) {
        int j;
        for (j = 0; j < 2; j++)
          this.throttle_position[i][j] = 0; 
      } 
      this.RawRc[0] = 1500;
      this.RawRc[1] = 1500;
      this.RawRc[2] = 1500;
      this.RawRc[3] = 1000;
    }
    
    public int[] getLeft() {
      return this.left;
    }
    
    public int[] getRight() {
      return this.right;
    }
    
    public Bitmap getThrottleImage() {
      return this.throttleImage;
    }
    
    public void setLeft(int[] param1ArrayOfint) {
      this.left = param1ArrayOfint;
      this.RawRc[3] = (this.throttle_position[0][1] + this.throttle_height - this.throttleImage.getHeight() / 2 - param1ArrayOfint[1] + this.throttleImage.getHeight() / 2) * 1000 / (this.throttle_height - this.throttleImage.getHeight()) + 1000;
      this.RawRc[2] = (param1ArrayOfint[0] + this.throttleImage.getWidth() / 2 - this.throttle_position[0][0] + this.throttle_width / 2 - this.throttle_width / DrsControllerView.this.getWidth() / 2) * DrsControllerView.this.mspdata.getDRONE_SPEED() / (this.throttle_width / 2 - this.throttleImage.getWidth() / 2) + 1500 + DrsControllerView.this.mspdata.getTream()[2];
      DrsControllerView.this.mspdata.setRawRCDataYawThrottle(this.RawRc[2], this.RawRc[3]);
    }
    
    public void setRight(int[] param1ArrayOfint) {
      this.right = param1ArrayOfint;
      this.RawRc[0] = (param1ArrayOfint[0] + this.throttleImage.getWidth() / 2 - this.throttle_position[1][0] + this.throttle_width / 2) * DrsControllerView.this.mspdata.getDRONE_SPEED() / (this.throttle_width / 2 - this.throttleImage.getWidth() / 2) + 1500 + DrsControllerView.this.mspdata.getTream()[0];
      this.RawRc[1] = (this.throttle_position[1][1] + this.throttle_height / 2 - param1ArrayOfint[1] + this.throttleImage.getHeight() / 2) * DrsControllerView.this.mspdata.getDRONE_SPEED() / (this.throttle_height / 2 - this.throttleImage.getHeight() / 2) + 1500 + DrsControllerView.this.mspdata.getTream()[1];
      DrsControllerView.this.mspdata.setRawRCDataRollPitch(this.RawRc[0], this.RawRc[1]);
    }
    
    public void setThrottle_height(int param1Int) {
      this.throttle_height = param1Int;
    }
    
    public void setThrottle_position(int[][] param1ArrayOfint) {
      this.throttle_position = param1ArrayOfint;
    }
    
    public void setThrottle_width(int param1Int) {
      this.throttle_width = param1Int;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Controller\DroneController\DrsControllerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */