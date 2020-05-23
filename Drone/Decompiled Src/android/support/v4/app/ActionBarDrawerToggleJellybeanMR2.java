package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@TargetApi(18)
@RequiresApi(18)
class ActionBarDrawerToggleJellybeanMR2 {
  private static final String TAG = "ActionBarDrawerToggleImplJellybeanMR2";
  
  private static final int[] THEME_ATTRS = new int[] { 16843531 };
  
  public static Drawable getThemeUpIndicator(Activity paramActivity) {
    Context context;
    ActionBar actionBar = paramActivity.getActionBar();
    if (actionBar != null)
      context = actionBar.getThemedContext(); 
    TypedArray typedArray = context.obtainStyledAttributes(null, THEME_ATTRS, 16843470, 0);
    Drawable drawable = typedArray.getDrawable(0);
    typedArray.recycle();
    return drawable;
  }
  
  public static Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt) {
    ActionBar actionBar = paramActivity.getActionBar();
    if (actionBar != null)
      actionBar.setHomeActionContentDescription(paramInt); 
    return paramObject;
  }
  
  public static Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt) {
    ActionBar actionBar = paramActivity.getActionBar();
    if (actionBar != null) {
      actionBar.setHomeAsUpIndicator(paramDrawable);
      actionBar.setHomeActionContentDescription(paramInt);
    } 
    return paramObject;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ActionBarDrawerToggleJellybeanMR2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */