package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.lang.reflect.Method;

@TargetApi(11)
@RequiresApi(11)
class ActionBarDrawerToggleHoneycomb {
  private static final String TAG = "ActionBarDrawerToggleHoneycomb";
  
  private static final int[] THEME_ATTRS = new int[] { 16843531 };
  
  public static Drawable getThemeUpIndicator(Activity paramActivity) {
    TypedArray typedArray = paramActivity.obtainStyledAttributes(THEME_ATTRS);
    Drawable drawable = typedArray.getDrawable(0);
    typedArray.recycle();
    return drawable;
  }
  
  public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo paramSetIndicatorInfo, Activity paramActivity, int paramInt) {
    SetIndicatorInfo setIndicatorInfo = paramSetIndicatorInfo;
    if (paramSetIndicatorInfo == null)
      setIndicatorInfo = new SetIndicatorInfo(paramActivity); 
    if (setIndicatorInfo.setHomeAsUpIndicator != null)
      try {
        ActionBar actionBar = paramActivity.getActionBar();
        setIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, new Object[] { Integer.valueOf(paramInt) });
        if (Build.VERSION.SDK_INT <= 19)
          actionBar.setSubtitle(actionBar.getSubtitle()); 
        return setIndicatorInfo;
      } catch (Exception exception) {
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", exception);
        return setIndicatorInfo;
      }  
    return setIndicatorInfo;
  }
  
  public static SetIndicatorInfo setActionBarUpIndicator(SetIndicatorInfo paramSetIndicatorInfo, Activity paramActivity, Drawable paramDrawable, int paramInt) {
    paramSetIndicatorInfo = new SetIndicatorInfo(paramActivity);
    if (paramSetIndicatorInfo.setHomeAsUpIndicator != null)
      try {
        ActionBar actionBar = paramActivity.getActionBar();
        paramSetIndicatorInfo.setHomeAsUpIndicator.invoke(actionBar, new Object[] { paramDrawable });
        paramSetIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, new Object[] { Integer.valueOf(paramInt) });
        return paramSetIndicatorInfo;
      } catch (Exception exception) {
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", exception);
        return paramSetIndicatorInfo;
      }  
    if (paramSetIndicatorInfo.upIndicatorView != null) {
      paramSetIndicatorInfo.upIndicatorView.setImageDrawable(paramDrawable);
      return paramSetIndicatorInfo;
    } 
    Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
    return paramSetIndicatorInfo;
  }
  
  static class SetIndicatorInfo {
    public Method setHomeActionContentDescription;
    
    public Method setHomeAsUpIndicator;
    
    public ImageView upIndicatorView;
    
    SetIndicatorInfo(Activity param1Activity) {
      try {
        this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[] { Drawable.class });
        this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[] { int.class });
      } catch (NoSuchMethodException noSuchMethodException) {
        View view = param1Activity.findViewById(16908332);
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\app\ActionBarDrawerToggleHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */