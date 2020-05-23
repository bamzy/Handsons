package com.drms.drms_drone.MainView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.drms.drms_drone.Download.DownloadManager;

public class EtcView extends LinearLayout {
  private String TAG = EtcView.class.getSimpleName();
  
  float canvas_height = 0.0F;
  
  float canvas_width = 0.0F;
  
  private Activity mActivity;
  
  private Context mContext;
  
  private Paint[] mPaint = new Paint[5];
  
  public EtcView(Context paramContext, Activity paramActivity) {
    super(paramContext);
    this.mContext = paramContext;
    this.mActivity = paramActivity;
  }
  
  public void drawTopic(Canvas paramCanvas) {
    this.mPaint[0] = new Paint();
    this.mPaint[0].setTextAlign(Paint.Align.LEFT);
    this.mPaint[0].setTextSize(70.0F);
    this.mPaint[0].setStrokeWidth(5.0F);
    this.mPaint[0].setColor(this.mContext.getResources().getColor(2131492907));
    paramCanvas.drawText("Information", this.mPaint[0].getTextSize() / 2.0F, this.mPaint[0].getTextSize() * 3.0F / 2.0F, this.mPaint[0]);
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
      (new DownloadManager(this.mActivity, this.mContext)).download();
      return true;
    } 
    return true;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\MainView\EtcView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */