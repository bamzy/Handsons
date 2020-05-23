package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

@TargetApi(21)
@RequiresApi(21)
class ViewCompatLollipop {
  private static ThreadLocal<Rect> sThreadLocalRect;
  
  public static Object dispatchApplyWindowInsets(View paramView, Object paramObject) {
    WindowInsets windowInsets2 = (WindowInsets)paramObject;
    WindowInsets windowInsets1 = paramView.dispatchApplyWindowInsets(windowInsets2);
    if (windowInsets1 != windowInsets2)
      paramObject = new WindowInsets(windowInsets1); 
    return paramObject;
  }
  
  public static boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return paramView.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return paramView.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public static boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return paramView.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2);
  }
  
  public static boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return paramView.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
  }
  
  static ColorStateList getBackgroundTintList(View paramView) {
    return paramView.getBackgroundTintList();
  }
  
  static PorterDuff.Mode getBackgroundTintMode(View paramView) {
    return paramView.getBackgroundTintMode();
  }
  
  public static float getElevation(View paramView) {
    return paramView.getElevation();
  }
  
  private static Rect getEmptyTempRect() {
    if (sThreadLocalRect == null)
      sThreadLocalRect = new ThreadLocal<Rect>(); 
    Rect rect2 = sThreadLocalRect.get();
    Rect rect1 = rect2;
    if (rect2 == null) {
      rect1 = new Rect();
      sThreadLocalRect.set(rect1);
    } 
    rect1.setEmpty();
    return rect1;
  }
  
  public static String getTransitionName(View paramView) {
    return paramView.getTransitionName();
  }
  
  public static float getTranslationZ(View paramView) {
    return paramView.getTranslationZ();
  }
  
  public static float getZ(View paramView) {
    return paramView.getZ();
  }
  
  public static boolean hasNestedScrollingParent(View paramView) {
    return paramView.hasNestedScrollingParent();
  }
  
  public static boolean isImportantForAccessibility(View paramView) {
    return paramView.isImportantForAccessibility();
  }
  
  public static boolean isNestedScrollingEnabled(View paramView) {
    return paramView.isNestedScrollingEnabled();
  }
  
  static void offsetLeftAndRight(View paramView, int paramInt) {
    Rect rect = getEmptyTempRect();
    boolean bool = false;
    ViewParent viewParent = paramView.getParent();
    if (viewParent instanceof View) {
      View view = (View)viewParent;
      rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
      if (!rect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        bool = true;
      } else {
        bool = false;
      } 
    } 
    ViewCompatHC.offsetLeftAndRight(paramView, paramInt);
    if (bool && rect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))
      ((View)viewParent).invalidate(rect); 
  }
  
  static void offsetTopAndBottom(View paramView, int paramInt) {
    Rect rect = getEmptyTempRect();
    boolean bool = false;
    ViewParent viewParent = paramView.getParent();
    if (viewParent instanceof View) {
      View view = (View)viewParent;
      rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
      if (!rect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        bool = true;
      } else {
        bool = false;
      } 
    } 
    ViewCompatHC.offsetTopAndBottom(paramView, paramInt);
    if (bool && rect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))
      ((View)viewParent).invalidate(rect); 
  }
  
  public static Object onApplyWindowInsets(View paramView, Object paramObject) {
    WindowInsets windowInsets2 = (WindowInsets)paramObject;
    WindowInsets windowInsets1 = paramView.onApplyWindowInsets(windowInsets2);
    if (windowInsets1 != windowInsets2)
      paramObject = new WindowInsets(windowInsets1); 
    return paramObject;
  }
  
  public static void requestApplyInsets(View paramView) {
    paramView.requestApplyInsets();
  }
  
  static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList) {
    paramView.setBackgroundTintList(paramColorStateList);
    if (Build.VERSION.SDK_INT == 21) {
      boolean bool;
      Drawable drawable = paramView.getBackground();
      if (paramView.getBackgroundTintList() != null && paramView.getBackgroundTintMode() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (drawable != null && bool) {
        if (drawable.isStateful())
          drawable.setState(paramView.getDrawableState()); 
        paramView.setBackground(drawable);
      } 
    } 
  }
  
  static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode) {
    paramView.setBackgroundTintMode(paramMode);
    if (Build.VERSION.SDK_INT == 21) {
      boolean bool;
      Drawable drawable = paramView.getBackground();
      if (paramView.getBackgroundTintList() != null && paramView.getBackgroundTintMode() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (drawable != null && bool) {
        if (drawable.isStateful())
          drawable.setState(paramView.getDrawableState()); 
        paramView.setBackground(drawable);
      } 
    } 
  }
  
  public static void setElevation(View paramView, float paramFloat) {
    paramView.setElevation(paramFloat);
  }
  
  public static void setNestedScrollingEnabled(View paramView, boolean paramBoolean) {
    paramView.setNestedScrollingEnabled(paramBoolean);
  }
  
  public static void setOnApplyWindowInsetsListener(View paramView, final OnApplyWindowInsetsListenerBridge bridge) {
    if (bridge == null) {
      paramView.setOnApplyWindowInsetsListener(null);
      return;
    } 
    paramView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
          public WindowInsets onApplyWindowInsets(View param1View, WindowInsets param1WindowInsets) {
            return (WindowInsets)bridge.onApplyWindowInsets(param1View, param1WindowInsets);
          }
        });
  }
  
  public static void setTransitionName(View paramView, String paramString) {
    paramView.setTransitionName(paramString);
  }
  
  public static void setTranslationZ(View paramView, float paramFloat) {
    paramView.setTranslationZ(paramFloat);
  }
  
  public static void setZ(View paramView, float paramFloat) {
    paramView.setZ(paramFloat);
  }
  
  public static boolean startNestedScroll(View paramView, int paramInt) {
    return paramView.startNestedScroll(paramInt);
  }
  
  public static void stopNestedScroll(View paramView) {
    paramView.stopNestedScroll();
  }
  
  public static interface OnApplyWindowInsetsListenerBridge {
    Object onApplyWindowInsets(View param1View, Object param1Object);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewCompatLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */