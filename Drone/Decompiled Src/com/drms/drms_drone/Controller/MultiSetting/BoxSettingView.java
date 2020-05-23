package com.drms.drms_drone.Controller.MultiSetting;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import com.drms.drms_drone.Sound.SoundManager;
import java.lang.reflect.Array;

public class BoxSettingView extends SettingView {
  private int BOXITEMNUM = 0;
  
  private CheckBox[][] checkbox;
  
  private SoundManager mSoundManager = new SoundManager(this.mContext);
  
  private Bitmap offTemp;
  
  private Bitmap onTemp;
  
  public BoxSettingView(Context paramContext, Activity paramActivity) {
    super(paramContext, paramActivity);
    if (this.mspdata.getBoxITEM() != null) {
      this.BOXITEMNUM = (this.mspdata.getBoxITEM()).length;
    } else {
      this.BOXITEMNUM = 0;
    } 
    this.checkbox = (CheckBox[][])Array.newInstance(CheckBox.class, new int[] { this.BOXITEMNUM, 12 });
  }
  
  private void initializeOnOff() {
    this.onTemp = Bitmap.createBitmap((int)(3.0F * this.y), (int)(3.0F * this.y), Bitmap.Config.ARGB_8888);
    this.offTemp = Bitmap.createBitmap((int)(3.0F * this.y), (int)(3.0F * this.y), Bitmap.Config.ARGB_8888);
    Canvas canvas1 = new Canvas(this.onTemp);
    Paint paint1 = new Paint();
    paint1.setStrokeWidth(8.0F);
    paint1.setColor(this.mContext.getResources().getColor(2131492904));
    paint1.setStyle(Paint.Style.STROKE);
    canvas1.drawCircle((canvas1.getWidth() / 2), (canvas1.getHeight() / 2), (canvas1.getHeight() / 2) - paint1.getStrokeWidth() / 2.0F, paint1);
    Canvas canvas2 = new Canvas(this.offTemp);
    Paint paint2 = new Paint();
    paint2.setStrokeWidth(8.0F);
    paint2.setColor(this.mContext.getResources().getColor(2131492906));
    paint2.setStyle(Paint.Style.STROKE);
    canvas2.drawCircle((canvas1.getWidth() / 2), (canvas1.getHeight() / 2), (canvas1.getHeight() / 2) - paint1.getStrokeWidth() / 2.0F, paint2);
    paint2.setStrokeWidth(15.0F);
    canvas2.drawPoint((canvas2.getWidth() / 2), (canvas2.getHeight() / 2), paint2);
    float f1 = 10.0F * this.x;
    float f2 = 7.0F * this.y;
    for (int i = 0; i < this.BOXITEMNUM; i++) {
      for (int j = 0; j < 12; j++) {
        this.checkbox[i][j] = new CheckBox(f1, f2, this.mspdata.getCheckboxData()[i][j]);
        if (j % 3 != 2) {
          f1 += 4.0F * this.x;
        } else {
          f1 += 6.0F * this.x;
        } 
      } 
      f1 = 10.0F * this.x;
      f2 += 4.0F * this.y;
    } 
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.canvasWidth != paramCanvas.getWidth() || this.canvasHeight != paramCanvas.getHeight()) {
      this.canvasWidth = paramCanvas.getWidth();
      this.canvasHeight = paramCanvas.getHeight();
      this.x = this.canvasWidth / 65.0F;
      this.y = this.canvasHeight / 40.0F;
      initializeOnOff();
    } 
    int i;
    for (i = 0; i < this.BOXITEMNUM; i++) {
      for (int j = 0; j < 12; j++)
        paramCanvas.drawBitmap(this.checkbox[i][j].getDisplayed_check(), this.checkbox[i][j].getPositionX(), this.checkbox[i][j].getPositionY(), null); 
    } 
    Paint[] arrayOfPaint = new Paint[10];
    arrayOfPaint[0] = new Paint();
    arrayOfPaint[0].setColor(this.mContext.getResources().getColor(2131492907));
    arrayOfPaint[0].setStrokeWidth(7.0F);
    arrayOfPaint[0].setTextAlign(Paint.Align.CENTER);
    arrayOfPaint[0].setTextSize(2.0F * this.y);
    if (this.BOXITEMNUM != 0) {
      String[] arrayOfString = new String[this.BOXITEMNUM];
      for (i = 0; i < this.BOXITEMNUM; i++)
        arrayOfString[i] = this.mspdata.getBoxITEM()[i]; 
      for (i = 0; i < this.BOXITEMNUM; i++)
        paramCanvas.drawText(arrayOfString[i], 5.0F * this.x, (this.checkbox[i][0].getPositionY() + this.checkbox[i][0].getPositionY() + this.checkbox[i][0].getDisplayed_check().getHeight()) / 2.0F + arrayOfPaint[0].getTextSize() / 2.0F, arrayOfPaint[0]); 
      for (i = 0; i < 12; i++) {
        (new String[3])[0] = "L";
        (new String[3])[1] = "M";
        (new String[3])[2] = "H";
        paramCanvas.drawText((new String[3])[i % 3], (this.checkbox[0][i].getPositionX() + this.checkbox[0][i].getPositionX() + this.checkbox[0][i].getDisplayed_check().getWidth()) / 2.0F, 6.0F * this.y, arrayOfPaint[0]);
      } 
      arrayOfPaint[0].setTextSize(3.0F * this.y);
      arrayOfPaint[0].setColor(this.mContext.getResources().getColor(2131492947));
      for (i = 0; i < 4; i++) {
        (new String[4])[0] = "AUX1";
        (new String[4])[1] = "AUX2";
        (new String[4])[2] = "AUX3";
        (new String[4])[3] = "AUX4";
        paramCanvas.drawText((new String[4])[i], (this.checkbox[0][i * 3 + 1].getPositionX() + this.checkbox[0][i * 3 + 1].getPositionX() + this.checkbox[0][i * 3 + 1].getDisplayed_check().getWidth()) / 2.0F, 3.3F * this.y, arrayOfPaint[0]);
      } 
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0) {
      int i = 0;
      label22: while (i < this.BOXITEMNUM) {
        int j = 0;
        while (true) {
          if (j < 12)
            if (paramMotionEvent.getX() >= this.checkbox[i][j].getPositionX() && paramMotionEvent.getX() <= this.checkbox[i][j].getPositionX() + this.checkbox[i][j].getDisplayed_check().getWidth() && paramMotionEvent.getY() >= this.checkbox[i][j].getPositionY() && paramMotionEvent.getY() <= this.checkbox[i][j].getPositionY() + this.checkbox[i][j].getDisplayed_check().getHeight()) {
              if (this.checkbox[i][j].isChecked()) {
                this.checkbox[i][j].setChecked(false);
              } else {
                this.checkbox[i][j].setChecked(true);
              } 
              invalidate();
              this.mSoundManager.play(0);
              this.mspdata.setEachCheckboxData(i, j, this.checkbox[i][j].isChecked());
            } else {
              j++;
              continue;
            }  
          i++;
          continue label22;
        } 
      } 
    } 
    return true;
  }
  
  private class CheckBox {
    private boolean checked;
    
    private Bitmap displayed_check;
    
    private Bitmap off;
    
    private Bitmap on;
    
    private float positionX;
    
    private float positionY;
    
    public CheckBox(float param1Float1, float param1Float2, boolean param1Boolean) {
      this.positionX = param1Float1;
      this.positionY = param1Float2;
      this.checked = param1Boolean;
      this.on = BoxSettingView.this.onTemp;
      this.off = BoxSettingView.this.offTemp;
      if (param1Boolean) {
        this.displayed_check = this.off;
        return;
      } 
      this.displayed_check = this.on;
    }
    
    public Bitmap getDisplayed_check() {
      return this.displayed_check;
    }
    
    public float getPositionX() {
      return this.positionX;
    }
    
    public float getPositionY() {
      return this.positionY;
    }
    
    public boolean isChecked() {
      return this.checked;
    }
    
    public void setChecked(boolean param1Boolean) {
      this.checked = param1Boolean;
      if (param1Boolean) {
        this.displayed_check = this.off;
        return;
      } 
      this.displayed_check = this.on;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Controller\MultiSetting\BoxSettingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */