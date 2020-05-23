package com.drms.drms_drone.Controller.MultiSetting;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.drms.drms_drone.MultiData;

public class SettingView extends View {
  protected float canvasHeight;
  
  protected float canvasWidth;
  
  protected Activity mActivity;
  
  protected Context mContext;
  
  protected MultiData mspdata;
  
  protected float x;
  
  protected float y;
  
  public SettingView(Context paramContext, Activity paramActivity) {
    super(paramContext);
    this.mContext = paramContext;
    this.mActivity = paramActivity;
    this.mspdata = (MultiData)paramActivity.getApplication();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Controller\MultiSetting\SettingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */