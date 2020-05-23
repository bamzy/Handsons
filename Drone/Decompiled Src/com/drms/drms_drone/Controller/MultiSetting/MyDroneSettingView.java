package com.drms.drms_drone.Controller.MultiSetting;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import java.text.DecimalFormat;

public class MyDroneSettingView extends SettingView {
  private static final String TAG = "MyDroneSettingView";
  
  private float[] positionXGraph = new float[3];
  
  private float[] positionYGraph = new float[9];
  
  private Path[] settingPath = new Path[9];
  
  public MyDroneSettingView(Context paramContext, Activity paramActivity) {
    super(paramContext, paramActivity);
    for (int i = 0; i < this.settingPath.length; i++)
      this.settingPath[i] = new Path(); 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.canvasWidth != paramCanvas.getWidth() || this.canvasHeight != paramCanvas.getHeight()) {
      this.canvasWidth = paramCanvas.getWidth();
      this.canvasHeight = paramCanvas.getHeight();
      this.x = this.canvasWidth / 65.0F;
      this.y = this.canvasHeight / 40.0F;
      this.settingPath[0].moveTo(2.0F * this.x, 30.0F * this.y);
      this.settingPath[1].moveTo(2.0F * this.x, 30.0F * this.y);
      this.settingPath[2].moveTo(2.0F * this.x, 30.0F * this.y);
      this.settingPath[3].moveTo(23.0F * this.x, 30.0F * this.y);
      this.settingPath[4].moveTo(23.0F * this.x, 30.0F * this.y);
      this.settingPath[5].moveTo(23.0F * this.x, 30.0F * this.y);
      this.settingPath[6].moveTo(44.0F * this.x, 30.0F * this.y);
      this.settingPath[7].moveTo(44.0F * this.x, 30.0F * this.y);
      this.settingPath[8].moveTo(44.0F * this.x, 30.0F * this.y);
      this.positionXGraph[0] = 2.0F * this.x;
      this.positionXGraph[1] = 23.0F * this.x;
      this.positionXGraph[2] = 44.0F * this.x;
      this.positionYGraph[0] = 30.0F * this.y;
      this.positionYGraph[1] = 30.0F * this.y;
      this.positionYGraph[2] = 30.0F * this.y;
      this.positionYGraph[3] = 30.0F * this.y;
      this.positionYGraph[4] = 30.0F * this.y;
      this.positionYGraph[5] = 30.0F * this.y;
      this.positionYGraph[6] = 30.0F * this.y;
      this.positionYGraph[7] = 30.0F * this.y;
      this.positionYGraph[8] = 30.0F * this.y;
      Log.d("MyDroneSettingView", "x : " + this.x + "/ y : " + this.y);
    } 
    Paint[] arrayOfPaint = new Paint[10];
    Bitmap bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), 2130903081);
    float f = 10.0F * this.y / bitmap.getHeight();
    paramCanvas.drawBitmap(Bitmap.createScaledBitmap(bitmap, (int)(bitmap.getWidth() * f), (int)(bitmap.getHeight() * f), true), 5.0F * this.x, 5.0F * this.y, null);
    arrayOfPaint[0] = new Paint();
    arrayOfPaint[0].setStrokeWidth(7.0F);
    arrayOfPaint[0].setColor(this.mContext.getResources().getColor(2131492904));
    arrayOfPaint[0].setStyle(Paint.Style.STROKE);
    paramCanvas.drawRect(this.x * 20.0F, this.y * 3.0F, this.x * 30.0F, this.y * 17.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(this.x * 35.0F, this.y * 3.0F, this.x * 45.0F, this.y * 17.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(this.x * 50.0F, this.y * 3.0F, this.x * 60.0F, this.y * 17.0F, arrayOfPaint[0]);
    arrayOfPaint[1] = new Paint();
    arrayOfPaint[1].setStrokeWidth(8.0F);
    arrayOfPaint[1].setColor(this.mContext.getResources().getColor(2131492907));
    arrayOfPaint[1].setTextAlign(Paint.Align.CENTER);
    arrayOfPaint[1].setTextSize(3.0F * this.y);
    paramCanvas.drawText("Acc", 25.0F * this.x, (float)(6.5D * this.y), arrayOfPaint[1]);
    paramCanvas.drawText("Gyro", 40.0F * this.x, (float)(6.5D * this.y), arrayOfPaint[1]);
    paramCanvas.drawText("Orient", 55.0F * this.x, (float)(6.5D * this.y), arrayOfPaint[1]);
    arrayOfPaint[1].setTextSize(2.0F * this.y);
    arrayOfPaint[1].setColor(this.mContext.getResources().getColor(2131492906));
    paramCanvas.drawText("x", (float)(21.5D * this.x), (float)(8.5D * this.y + (arrayOfPaint[1].getTextSize() / 2.0F)), arrayOfPaint[1]);
    paramCanvas.drawText("y", (float)(21.5D * this.x), (float)(11.5D * this.y + (arrayOfPaint[1].getTextSize() / 2.0F)), arrayOfPaint[1]);
    paramCanvas.drawText("z", (float)(21.5D * this.x), (float)(14.5D * this.y + (arrayOfPaint[1].getTextSize() / 2.0F)), arrayOfPaint[1]);
    paramCanvas.drawText("x", (float)(36.5D * this.x), (float)(8.5D * this.y + (arrayOfPaint[1].getTextSize() / 2.0F)), arrayOfPaint[1]);
    paramCanvas.drawText("y", (float)(36.5D * this.x), (float)(11.5D * this.y + (arrayOfPaint[1].getTextSize() / 2.0F)), arrayOfPaint[1]);
    paramCanvas.drawText("z", (float)(36.5D * this.x), (float)(14.5D * this.y + (arrayOfPaint[1].getTextSize() / 2.0F)), arrayOfPaint[1]);
    paramCanvas.drawText("R", (float)(51.5D * this.x), (float)(8.5D * this.y + (arrayOfPaint[1].getTextSize() / 2.0F)), arrayOfPaint[1]);
    paramCanvas.drawText("P", (float)(51.5D * this.x), (float)(11.5D * this.y + (arrayOfPaint[1].getTextSize() / 2.0F)), arrayOfPaint[1]);
    paramCanvas.drawText("Y", (float)(51.5D * this.x), (float)(14.5D * this.y + (arrayOfPaint[1].getTextSize() / 2.0F)), arrayOfPaint[1]);
    arrayOfPaint[2] = new Paint();
    arrayOfPaint[0].setStyle(Paint.Style.FILL);
    arrayOfPaint[0].setColor(this.mContext.getResources().getColor(2131492865));
    paramCanvas.drawRect(this.x * 2.0F, this.y * 22.0F, this.x * 21.0F, this.y * 38.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(this.x * 23.0F, this.y * 22.0F, this.x * 42.0F, this.y * 38.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(this.x * 44.0F, this.y * 22.0F, this.x * 63.0F, this.y * 38.0F, arrayOfPaint[0]);
    arrayOfPaint[0].setStrokeWidth(10.0F);
    arrayOfPaint[0].setStyle(Paint.Style.STROKE);
    arrayOfPaint[0].setColor(this.mContext.getResources().getColor(2131492904));
    paramCanvas.drawRect(this.x * 2.0F, this.y * 22.0F, this.x * 21.0F, this.y * 38.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(this.x * 23.0F, this.y * 22.0F, this.x * 42.0F, this.y * 38.0F, arrayOfPaint[0]);
    paramCanvas.drawRect(this.x * 44.0F, this.y * 22.0F, this.x * 63.0F, this.y * 38.0F, arrayOfPaint[0]);
    arrayOfPaint[2] = new Paint();
    arrayOfPaint[2].setStrokeWidth(6.0F);
    arrayOfPaint[2].setTextSize((float)(1.5D * this.y));
    arrayOfPaint[2].setColor(this.mContext.getResources().getColor(2131492904));
    arrayOfPaint[2].setTextAlign(Paint.Align.CENTER);
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    paramCanvas.drawText(String.valueOf(decimalFormat.format((this.mspdata.getIMUdata()[0] / 50.0F))), (float)(26.5D * this.x), (float)(8.5D * this.y) + arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    paramCanvas.drawText(String.valueOf(decimalFormat.format((this.mspdata.getIMUdata()[1] / 50.0F))), (float)(26.5D * this.x), (float)(11.5D * this.y) + arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    paramCanvas.drawText(String.valueOf(decimalFormat.format((this.mspdata.getIMUdata()[2] / 50.0F))), (float)(26.5D * this.x), (float)(14.5D * this.y) + arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    paramCanvas.drawText(String.valueOf(this.mspdata.getIMUdata()[3]), (float)(41.5D * this.x), (float)(8.5D * this.y) + arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    paramCanvas.drawText(String.valueOf(this.mspdata.getIMUdata()[4]), (float)(41.5D * this.x), (float)(11.5D * this.y) + arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    paramCanvas.drawText(String.valueOf(this.mspdata.getIMUdata()[5]), (float)(41.5D * this.x), (float)(14.5D * this.y) + arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    paramCanvas.drawText(String.valueOf((int)this.mspdata.getAttitudeData()[0]), (float)(56.5D * this.x), (float)(8.5D * this.y) + arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    paramCanvas.drawText(String.valueOf((int)this.mspdata.getAttitudeData()[1]), (float)(56.5D * this.x), (float)(11.5D * this.y) + arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    paramCanvas.drawText(String.valueOf((int)this.mspdata.getAttitudeData()[2]), (float)(56.5D * this.x), (float)(14.5D * this.y) + arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    arrayOfPaint[2].setColor(this.mContext.getResources().getColor(2131492907));
    paramCanvas.drawText("Acc", 12.0F * this.x, 22.0F * this.y - arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    paramCanvas.drawText("Gyro", 33.0F * this.x, 22.0F * this.y - arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    paramCanvas.drawText("Orient", 54.0F * this.x, 22.0F * this.y - arrayOfPaint[2].getTextSize() / 2.0F, arrayOfPaint[2]);
    arrayOfPaint[3] = new Paint();
    arrayOfPaint[4] = new Paint();
    arrayOfPaint[5] = new Paint();
    arrayOfPaint[3].setColor(this.mContext.getResources().getColor(2131492905));
    arrayOfPaint[4].setColor(this.mContext.getResources().getColor(2131492940));
    arrayOfPaint[5].setColor(this.mContext.getResources().getColor(2131492927));
    arrayOfPaint[3].setStrokeWidth(5.0F);
    arrayOfPaint[3].setStyle(Paint.Style.STROKE);
    arrayOfPaint[4].setStrokeWidth(5.0F);
    arrayOfPaint[4].setStyle(Paint.Style.STROKE);
    arrayOfPaint[5].setStrokeWidth(5.0F);
    arrayOfPaint[5].setStyle(Paint.Style.STROKE);
    if (this.x != 0.0F && this.y != 0.0F && (this.mspdata.getIMUdata()[0] != 0 || this.mspdata.getIMUdata()[1] != 0 || this.mspdata.getIMUdata()[2] != 0)) {
      float[] arrayOfFloat1 = new float[3];
      arrayOfFloat1[0] = this.positionYGraph[3] - (this.mspdata.getIMUdata()[0] / 5);
      arrayOfFloat1[1] = this.positionYGraph[4] - (this.mspdata.getIMUdata()[1] / 5);
      arrayOfFloat1[2] = this.positionYGraph[5] - ((this.mspdata.getIMUdata()[2] - 490) / 5);
      int i;
      for (i = 0; i < arrayOfFloat1.length; i++) {
        if (arrayOfFloat1[i] < 22.0F * this.y + arrayOfPaint[0].getStrokeWidth() / 2.0F)
          arrayOfFloat1[i] = 22.0F * this.y - arrayOfPaint[0].getStrokeWidth() / 2.0F; 
        if (arrayOfFloat1[i] > 38.0F * this.y - arrayOfPaint[0].getStrokeWidth() / 2.0F)
          arrayOfFloat1[i] = 38.0F * this.y - arrayOfPaint[0].getStrokeWidth() / 2.0F; 
      } 
      this.settingPath[0].lineTo(this.positionXGraph[0], arrayOfFloat1[0]);
      this.settingPath[1].lineTo(this.positionXGraph[0], arrayOfFloat1[1]);
      Path path2 = this.settingPath[2];
      float[] arrayOfFloat3 = this.positionXGraph;
      f = arrayOfFloat3[0] + 3.0F;
      arrayOfFloat3[0] = f;
      path2.lineTo(f, arrayOfFloat1[2]);
      if (this.positionXGraph[0] >= 21.0F * this.x) {
        this.settingPath[0].reset();
        this.settingPath[0].moveTo(2.0F * this.x, 30.0F * this.y);
        this.settingPath[1].reset();
        this.settingPath[1].moveTo(2.0F * this.x, 30.0F * this.y);
        this.settingPath[2].reset();
        this.settingPath[2].moveTo(2.0F * this.x, 30.0F * this.y);
        this.positionXGraph[0] = 2.0F * this.x;
      } 
      paramCanvas.drawPath(this.settingPath[0], arrayOfPaint[3]);
      paramCanvas.drawPath(this.settingPath[1], arrayOfPaint[4]);
      paramCanvas.drawPath(this.settingPath[2], arrayOfPaint[5]);
      arrayOfFloat1 = new float[3];
      arrayOfFloat1[0] = this.positionYGraph[3] - (this.mspdata.getIMUdata()[3] / 7);
      arrayOfFloat1[1] = this.positionYGraph[4] - (this.mspdata.getIMUdata()[4] / 7);
      arrayOfFloat1[2] = this.positionYGraph[5] - (this.mspdata.getIMUdata()[5] / 7);
      for (i = 0; i < arrayOfFloat1.length; i++) {
        if (arrayOfFloat1[i] < 22.0F * this.y + arrayOfPaint[0].getStrokeWidth() / 2.0F)
          arrayOfFloat1[i] = 22.0F * this.y - arrayOfPaint[0].getStrokeWidth() / 2.0F; 
        if (arrayOfFloat1[i] > 38.0F * this.y - arrayOfPaint[0].getStrokeWidth() / 2.0F)
          arrayOfFloat1[i] = 38.0F * this.y - arrayOfPaint[0].getStrokeWidth() / 2.0F; 
      } 
      this.settingPath[3].lineTo(this.positionXGraph[1], arrayOfFloat1[0]);
      this.settingPath[4].lineTo(this.positionXGraph[1], arrayOfFloat1[1]);
      path2 = this.settingPath[5];
      arrayOfFloat3 = this.positionXGraph;
      f = arrayOfFloat3[1] + 3.0F;
      arrayOfFloat3[1] = f;
      path2.lineTo(f, arrayOfFloat1[2]);
      if (this.positionXGraph[1] >= 42.0F * this.x) {
        this.settingPath[3].reset();
        this.settingPath[3].moveTo(23.0F * this.x, 30.0F * this.y);
        this.settingPath[4].reset();
        this.settingPath[4].moveTo(23.0F * this.x, 30.0F * this.y);
        this.settingPath[5].reset();
        this.settingPath[5].moveTo(23.0F * this.x, 30.0F * this.y);
        this.positionXGraph[1] = 23.0F * this.x;
      } 
      paramCanvas.drawPath(this.settingPath[3], arrayOfPaint[3]);
      paramCanvas.drawPath(this.settingPath[4], arrayOfPaint[4]);
      paramCanvas.drawPath(this.settingPath[5], arrayOfPaint[5]);
      this.settingPath[6].lineTo(this.positionXGraph[2], this.positionYGraph[3] - this.mspdata.getAttitudeData()[0]);
      this.settingPath[7].lineTo(this.positionXGraph[2], this.positionYGraph[4] - this.mspdata.getAttitudeData()[1]);
      Path path1 = this.settingPath[8];
      float[] arrayOfFloat2 = this.positionXGraph;
      f = arrayOfFloat2[2] + 3.0F;
      arrayOfFloat2[2] = f;
      path1.lineTo(f, this.positionYGraph[5] - this.mspdata.getAttitudeData()[2]);
      if (this.positionXGraph[2] >= 63.0F * this.x) {
        this.settingPath[6].reset();
        this.settingPath[6].moveTo(44.0F * this.x, 30.0F * this.y);
        this.settingPath[7].reset();
        this.settingPath[7].moveTo(44.0F * this.x, 30.0F * this.y);
        this.settingPath[8].reset();
        this.settingPath[8].moveTo(44.0F * this.x, 30.0F * this.y);
        this.positionXGraph[2] = 44.0F * this.x;
      } 
      paramCanvas.drawPath(this.settingPath[6], arrayOfPaint[3]);
      paramCanvas.drawPath(this.settingPath[7], arrayOfPaint[4]);
      paramCanvas.drawPath(this.settingPath[8], arrayOfPaint[5]);
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Controller\MultiSetting\MyDroneSettingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */