package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import java.lang.reflect.Field;

@TargetApi(9)
@RequiresApi(9)
class ViewCompatBase {
  private static final String TAG = "ViewCompatBase";
  
  private static Field sMinHeightField;
  
  private static boolean sMinHeightFieldFetched;
  
  private static Field sMinWidthField;
  
  private static boolean sMinWidthFieldFetched;
  
  static ColorStateList getBackgroundTintList(View paramView) {
    return (paramView instanceof TintableBackgroundView) ? ((TintableBackgroundView)paramView).getSupportBackgroundTintList() : null;
  }
  
  static PorterDuff.Mode getBackgroundTintMode(View paramView) {
    return (paramView instanceof TintableBackgroundView) ? ((TintableBackgroundView)paramView).getSupportBackgroundTintMode() : null;
  }
  
  static Display getDisplay(View paramView) {
    return isAttachedToWindow(paramView) ? ((WindowManager)paramView.getContext().getSystemService("window")).getDefaultDisplay() : null;
  }
  
  static int getMinimumHeight(View paramView) {
    if (!sMinHeightFieldFetched) {
      try {
        sMinHeightField = View.class.getDeclaredField("mMinHeight");
        sMinHeightField.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {}
      sMinHeightFieldFetched = true;
    } 
    if (sMinHeightField != null)
      try {
        return ((Integer)sMinHeightField.get(paramView)).intValue();
      } catch (Exception exception) {} 
    return 0;
  }
  
  static int getMinimumWidth(View paramView) {
    if (!sMinWidthFieldFetched) {
      try {
        sMinWidthField = View.class.getDeclaredField("mMinWidth");
        sMinWidthField.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {}
      sMinWidthFieldFetched = true;
    } 
    if (sMinWidthField != null)
      try {
        return ((Integer)sMinWidthField.get(paramView)).intValue();
      } catch (Exception exception) {} 
    return 0;
  }
  
  static boolean isAttachedToWindow(View paramView) {
    return (paramView.getWindowToken() != null);
  }
  
  static boolean isLaidOut(View paramView) {
    return (paramView.getWidth() > 0 && paramView.getHeight() > 0);
  }
  
  static void offsetLeftAndRight(View paramView, int paramInt) {
    int i = paramView.getLeft();
    paramView.offsetLeftAndRight(paramInt);
    if (paramInt != 0) {
      ViewParent viewParent = paramView.getParent();
      if (viewParent instanceof View) {
        paramInt = Math.abs(paramInt);
        ((View)viewParent).invalidate(i - paramInt, paramView.getTop(), paramView.getWidth() + i + paramInt, paramView.getBottom());
        return;
      } 
    } else {
      return;
    } 
    paramView.invalidate();
  }
  
  static void offsetTopAndBottom(View paramView, int paramInt) {
    int i = paramView.getTop();
    paramView.offsetTopAndBottom(paramInt);
    if (paramInt != 0) {
      ViewParent viewParent = paramView.getParent();
      if (viewParent instanceof View) {
        paramInt = Math.abs(paramInt);
        ((View)viewParent).invalidate(paramView.getLeft(), i - paramInt, paramView.getRight(), paramView.getHeight() + i + paramInt);
        return;
      } 
    } else {
      return;
    } 
    paramView.invalidate();
  }
  
  static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList) {
    if (paramView instanceof TintableBackgroundView)
      ((TintableBackgroundView)paramView).setSupportBackgroundTintList(paramColorStateList); 
  }
  
  static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode) {
    if (paramView instanceof TintableBackgroundView)
      ((TintableBackgroundView)paramView).setSupportBackgroundTintMode(paramMode); 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewCompatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */