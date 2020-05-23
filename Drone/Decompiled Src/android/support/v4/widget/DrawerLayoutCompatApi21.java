package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

@TargetApi(21)
@RequiresApi(21)
class DrawerLayoutCompatApi21 {
  private static final int[] THEME_ATTRS = new int[] { 16843828 };
  
  public static void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt) {
    WindowInsets windowInsets = (WindowInsets)paramObject;
    if (paramInt == 3) {
      paramObject = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
    } else {
      paramObject = windowInsets;
      if (paramInt == 5)
        paramObject = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()); 
    } 
    paramMarginLayoutParams.leftMargin = paramObject.getSystemWindowInsetLeft();
    paramMarginLayoutParams.topMargin = paramObject.getSystemWindowInsetTop();
    paramMarginLayoutParams.rightMargin = paramObject.getSystemWindowInsetRight();
    paramMarginLayoutParams.bottomMargin = paramObject.getSystemWindowInsetBottom();
  }
  
  public static void configureApplyInsets(View paramView) {
    if (paramView instanceof DrawerLayoutImpl) {
      paramView.setOnApplyWindowInsetsListener(new InsetsListener());
      paramView.setSystemUiVisibility(1280);
    } 
  }
  
  public static void dispatchChildInsets(View paramView, Object paramObject, int paramInt) {
    WindowInsets windowInsets = (WindowInsets)paramObject;
    if (paramInt == 3) {
      paramObject = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
    } else {
      paramObject = windowInsets;
      if (paramInt == 5)
        paramObject = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()); 
    } 
    paramView.dispatchApplyWindowInsets((WindowInsets)paramObject);
  }
  
  public static Drawable getDefaultStatusBarBackground(Context paramContext) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(THEME_ATTRS);
    try {
      return typedArray.getDrawable(0);
    } finally {
      typedArray.recycle();
    } 
  }
  
  public static int getTopInset(Object paramObject) {
    return (paramObject != null) ? ((WindowInsets)paramObject).getSystemWindowInsetTop() : 0;
  }
  
  static class InsetsListener implements View.OnApplyWindowInsetsListener {
    public WindowInsets onApplyWindowInsets(View param1View, WindowInsets param1WindowInsets) {
      DrawerLayoutImpl drawerLayoutImpl = (DrawerLayoutImpl)param1View;
      if (param1WindowInsets.getSystemWindowInsetTop() > 0) {
        boolean bool1 = true;
        drawerLayoutImpl.setChildInsets(param1WindowInsets, bool1);
        return param1WindowInsets.consumeSystemWindowInsets();
      } 
      boolean bool = false;
      drawerLayoutImpl.setChildInsets(param1WindowInsets, bool);
      return param1WindowInsets.consumeSystemWindowInsets();
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\DrawerLayoutCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */