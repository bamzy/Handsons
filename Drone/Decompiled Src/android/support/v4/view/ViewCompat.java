package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class ViewCompat {
  public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
  
  public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
  
  public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
  
  private static final long FAKE_FRAME_TIME = 10L;
  
  static final ViewCompatImpl IMPL = new BaseViewCompatImpl();
  
  public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
  
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
  
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
  
  public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
  
  public static final int LAYER_TYPE_HARDWARE = 2;
  
  public static final int LAYER_TYPE_NONE = 0;
  
  public static final int LAYER_TYPE_SOFTWARE = 1;
  
  public static final int LAYOUT_DIRECTION_INHERIT = 2;
  
  public static final int LAYOUT_DIRECTION_LOCALE = 3;
  
  public static final int LAYOUT_DIRECTION_LTR = 0;
  
  public static final int LAYOUT_DIRECTION_RTL = 1;
  
  public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
  
  public static final int MEASURED_SIZE_MASK = 16777215;
  
  public static final int MEASURED_STATE_MASK = -16777216;
  
  public static final int MEASURED_STATE_TOO_SMALL = 16777216;
  
  @Deprecated
  public static final int OVER_SCROLL_ALWAYS = 0;
  
  @Deprecated
  public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
  
  @Deprecated
  public static final int OVER_SCROLL_NEVER = 2;
  
  public static final int SCROLL_AXIS_HORIZONTAL = 1;
  
  public static final int SCROLL_AXIS_NONE = 0;
  
  public static final int SCROLL_AXIS_VERTICAL = 2;
  
  public static final int SCROLL_INDICATOR_BOTTOM = 2;
  
  public static final int SCROLL_INDICATOR_END = 32;
  
  public static final int SCROLL_INDICATOR_LEFT = 4;
  
  public static final int SCROLL_INDICATOR_RIGHT = 8;
  
  public static final int SCROLL_INDICATOR_START = 16;
  
  public static final int SCROLL_INDICATOR_TOP = 1;
  
  private static final String TAG = "ViewCompat";
  
  public static ViewPropertyAnimatorCompat animate(View paramView) {
    return IMPL.animate(paramView);
  }
  
  public static boolean canScrollHorizontally(View paramView, int paramInt) {
    return IMPL.canScrollHorizontally(paramView, paramInt);
  }
  
  public static boolean canScrollVertically(View paramView, int paramInt) {
    return IMPL.canScrollVertically(paramView, paramInt);
  }
  
  public static int combineMeasuredStates(int paramInt1, int paramInt2) {
    return IMPL.combineMeasuredStates(paramInt1, paramInt2);
  }
  
  public static WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat) {
    return IMPL.dispatchApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  public static void dispatchFinishTemporaryDetach(View paramView) {
    IMPL.dispatchFinishTemporaryDetach(paramView);
  }
  
  public static boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return IMPL.dispatchNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return IMPL.dispatchNestedPreFling(paramView, paramFloat1, paramFloat2);
  }
  
  public static boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return IMPL.dispatchNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2);
  }
  
  public static boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return IMPL.dispatchNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
  }
  
  public static void dispatchStartTemporaryDetach(View paramView) {
    IMPL.dispatchStartTemporaryDetach(paramView);
  }
  
  public static int getAccessibilityLiveRegion(View paramView) {
    return IMPL.getAccessibilityLiveRegion(paramView);
  }
  
  public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView) {
    return IMPL.getAccessibilityNodeProvider(paramView);
  }
  
  public static float getAlpha(View paramView) {
    return IMPL.getAlpha(paramView);
  }
  
  public static ColorStateList getBackgroundTintList(View paramView) {
    return IMPL.getBackgroundTintList(paramView);
  }
  
  public static PorterDuff.Mode getBackgroundTintMode(View paramView) {
    return IMPL.getBackgroundTintMode(paramView);
  }
  
  public static Rect getClipBounds(View paramView) {
    return IMPL.getClipBounds(paramView);
  }
  
  public static Display getDisplay(@NonNull View paramView) {
    return IMPL.getDisplay(paramView);
  }
  
  public static float getElevation(View paramView) {
    return IMPL.getElevation(paramView);
  }
  
  public static boolean getFitsSystemWindows(View paramView) {
    return IMPL.getFitsSystemWindows(paramView);
  }
  
  public static int getImportantForAccessibility(View paramView) {
    return IMPL.getImportantForAccessibility(paramView);
  }
  
  public static int getLabelFor(View paramView) {
    return IMPL.getLabelFor(paramView);
  }
  
  public static int getLayerType(View paramView) {
    return IMPL.getLayerType(paramView);
  }
  
  public static int getLayoutDirection(View paramView) {
    return IMPL.getLayoutDirection(paramView);
  }
  
  @Nullable
  public static Matrix getMatrix(View paramView) {
    return IMPL.getMatrix(paramView);
  }
  
  public static int getMeasuredHeightAndState(View paramView) {
    return IMPL.getMeasuredHeightAndState(paramView);
  }
  
  public static int getMeasuredState(View paramView) {
    return IMPL.getMeasuredState(paramView);
  }
  
  public static int getMeasuredWidthAndState(View paramView) {
    return IMPL.getMeasuredWidthAndState(paramView);
  }
  
  public static int getMinimumHeight(View paramView) {
    return IMPL.getMinimumHeight(paramView);
  }
  
  public static int getMinimumWidth(View paramView) {
    return IMPL.getMinimumWidth(paramView);
  }
  
  @Deprecated
  public static int getOverScrollMode(View paramView) {
    return paramView.getOverScrollMode();
  }
  
  public static int getPaddingEnd(View paramView) {
    return IMPL.getPaddingEnd(paramView);
  }
  
  public static int getPaddingStart(View paramView) {
    return IMPL.getPaddingStart(paramView);
  }
  
  public static ViewParent getParentForAccessibility(View paramView) {
    return IMPL.getParentForAccessibility(paramView);
  }
  
  public static float getPivotX(View paramView) {
    return IMPL.getPivotX(paramView);
  }
  
  public static float getPivotY(View paramView) {
    return IMPL.getPivotY(paramView);
  }
  
  public static float getRotation(View paramView) {
    return IMPL.getRotation(paramView);
  }
  
  public static float getRotationX(View paramView) {
    return IMPL.getRotationX(paramView);
  }
  
  public static float getRotationY(View paramView) {
    return IMPL.getRotationY(paramView);
  }
  
  public static float getScaleX(View paramView) {
    return IMPL.getScaleX(paramView);
  }
  
  public static float getScaleY(View paramView) {
    return IMPL.getScaleY(paramView);
  }
  
  public static int getScrollIndicators(@NonNull View paramView) {
    return IMPL.getScrollIndicators(paramView);
  }
  
  public static String getTransitionName(View paramView) {
    return IMPL.getTransitionName(paramView);
  }
  
  public static float getTranslationX(View paramView) {
    return IMPL.getTranslationX(paramView);
  }
  
  public static float getTranslationY(View paramView) {
    return IMPL.getTranslationY(paramView);
  }
  
  public static float getTranslationZ(View paramView) {
    return IMPL.getTranslationZ(paramView);
  }
  
  public static int getWindowSystemUiVisibility(View paramView) {
    return IMPL.getWindowSystemUiVisibility(paramView);
  }
  
  public static float getX(View paramView) {
    return IMPL.getX(paramView);
  }
  
  public static float getY(View paramView) {
    return IMPL.getY(paramView);
  }
  
  public static float getZ(View paramView) {
    return IMPL.getZ(paramView);
  }
  
  public static boolean hasAccessibilityDelegate(View paramView) {
    return IMPL.hasAccessibilityDelegate(paramView);
  }
  
  public static boolean hasNestedScrollingParent(View paramView) {
    return IMPL.hasNestedScrollingParent(paramView);
  }
  
  public static boolean hasOnClickListeners(View paramView) {
    return IMPL.hasOnClickListeners(paramView);
  }
  
  public static boolean hasOverlappingRendering(View paramView) {
    return IMPL.hasOverlappingRendering(paramView);
  }
  
  public static boolean hasTransientState(View paramView) {
    return IMPL.hasTransientState(paramView);
  }
  
  public static boolean isAttachedToWindow(View paramView) {
    return IMPL.isAttachedToWindow(paramView);
  }
  
  public static boolean isImportantForAccessibility(View paramView) {
    return IMPL.isImportantForAccessibility(paramView);
  }
  
  public static boolean isInLayout(View paramView) {
    return IMPL.isInLayout(paramView);
  }
  
  public static boolean isLaidOut(View paramView) {
    return IMPL.isLaidOut(paramView);
  }
  
  public static boolean isLayoutDirectionResolved(View paramView) {
    return IMPL.isLayoutDirectionResolved(paramView);
  }
  
  public static boolean isNestedScrollingEnabled(View paramView) {
    return IMPL.isNestedScrollingEnabled(paramView);
  }
  
  @Deprecated
  public static boolean isOpaque(View paramView) {
    return paramView.isOpaque();
  }
  
  public static boolean isPaddingRelative(View paramView) {
    return IMPL.isPaddingRelative(paramView);
  }
  
  public static void jumpDrawablesToCurrentState(View paramView) {
    IMPL.jumpDrawablesToCurrentState(paramView);
  }
  
  public static void offsetLeftAndRight(View paramView, int paramInt) {
    IMPL.offsetLeftAndRight(paramView, paramInt);
  }
  
  public static void offsetTopAndBottom(View paramView, int paramInt) {
    IMPL.offsetTopAndBottom(paramView, paramInt);
  }
  
  public static WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat) {
    return IMPL.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  public static void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    IMPL.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    IMPL.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
  }
  
  public static void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    IMPL.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle) {
    return IMPL.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
  
  public static void postInvalidateOnAnimation(View paramView) {
    IMPL.postInvalidateOnAnimation(paramView);
  }
  
  public static void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    IMPL.postInvalidateOnAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void postOnAnimation(View paramView, Runnable paramRunnable) {
    IMPL.postOnAnimation(paramView, paramRunnable);
  }
  
  public static void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong) {
    IMPL.postOnAnimationDelayed(paramView, paramRunnable, paramLong);
  }
  
  public static void requestApplyInsets(View paramView) {
    IMPL.requestApplyInsets(paramView);
  }
  
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3) {
    return IMPL.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  public static void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {
    IMPL.setAccessibilityDelegate(paramView, paramAccessibilityDelegateCompat);
  }
  
  public static void setAccessibilityLiveRegion(View paramView, int paramInt) {
    IMPL.setAccessibilityLiveRegion(paramView, paramInt);
  }
  
  public static void setActivated(View paramView, boolean paramBoolean) {
    IMPL.setActivated(paramView, paramBoolean);
  }
  
  public static void setAlpha(View paramView, @FloatRange(from = 0.0D, to = 1.0D) float paramFloat) {
    IMPL.setAlpha(paramView, paramFloat);
  }
  
  public static void setBackground(View paramView, Drawable paramDrawable) {
    IMPL.setBackground(paramView, paramDrawable);
  }
  
  public static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList) {
    IMPL.setBackgroundTintList(paramView, paramColorStateList);
  }
  
  public static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode) {
    IMPL.setBackgroundTintMode(paramView, paramMode);
  }
  
  public static void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean) {
    IMPL.setChildrenDrawingOrderEnabled(paramViewGroup, paramBoolean);
  }
  
  public static void setClipBounds(View paramView, Rect paramRect) {
    IMPL.setClipBounds(paramView, paramRect);
  }
  
  public static void setElevation(View paramView, float paramFloat) {
    IMPL.setElevation(paramView, paramFloat);
  }
  
  public static void setFitsSystemWindows(View paramView, boolean paramBoolean) {
    IMPL.setFitsSystemWindows(paramView, paramBoolean);
  }
  
  public static void setHasTransientState(View paramView, boolean paramBoolean) {
    IMPL.setHasTransientState(paramView, paramBoolean);
  }
  
  public static void setImportantForAccessibility(View paramView, int paramInt) {
    IMPL.setImportantForAccessibility(paramView, paramInt);
  }
  
  public static void setLabelFor(View paramView, @IdRes int paramInt) {
    IMPL.setLabelFor(paramView, paramInt);
  }
  
  public static void setLayerPaint(View paramView, Paint paramPaint) {
    IMPL.setLayerPaint(paramView, paramPaint);
  }
  
  public static void setLayerType(View paramView, int paramInt, Paint paramPaint) {
    IMPL.setLayerType(paramView, paramInt, paramPaint);
  }
  
  public static void setLayoutDirection(View paramView, int paramInt) {
    IMPL.setLayoutDirection(paramView, paramInt);
  }
  
  public static void setNestedScrollingEnabled(View paramView, boolean paramBoolean) {
    IMPL.setNestedScrollingEnabled(paramView, paramBoolean);
  }
  
  public static void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {
    IMPL.setOnApplyWindowInsetsListener(paramView, paramOnApplyWindowInsetsListener);
  }
  
  @Deprecated
  public static void setOverScrollMode(View paramView, int paramInt) {
    paramView.setOverScrollMode(paramInt);
  }
  
  public static void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    IMPL.setPaddingRelative(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setPivotX(View paramView, float paramFloat) {
    IMPL.setPivotX(paramView, paramFloat);
  }
  
  public static void setPivotY(View paramView, float paramFloat) {
    IMPL.setPivotY(paramView, paramFloat);
  }
  
  public static void setPointerIcon(@NonNull View paramView, PointerIconCompat paramPointerIconCompat) {
    IMPL.setPointerIcon(paramView, paramPointerIconCompat);
  }
  
  public static void setRotation(View paramView, float paramFloat) {
    IMPL.setRotation(paramView, paramFloat);
  }
  
  public static void setRotationX(View paramView, float paramFloat) {
    IMPL.setRotationX(paramView, paramFloat);
  }
  
  public static void setRotationY(View paramView, float paramFloat) {
    IMPL.setRotationY(paramView, paramFloat);
  }
  
  public static void setSaveFromParentEnabled(View paramView, boolean paramBoolean) {
    IMPL.setSaveFromParentEnabled(paramView, paramBoolean);
  }
  
  public static void setScaleX(View paramView, float paramFloat) {
    IMPL.setScaleX(paramView, paramFloat);
  }
  
  public static void setScaleY(View paramView, float paramFloat) {
    IMPL.setScaleY(paramView, paramFloat);
  }
  
  public static void setScrollIndicators(@NonNull View paramView, int paramInt) {
    IMPL.setScrollIndicators(paramView, paramInt);
  }
  
  public static void setScrollIndicators(@NonNull View paramView, int paramInt1, int paramInt2) {
    IMPL.setScrollIndicators(paramView, paramInt1, paramInt2);
  }
  
  public static void setTransitionName(View paramView, String paramString) {
    IMPL.setTransitionName(paramView, paramString);
  }
  
  public static void setTranslationX(View paramView, float paramFloat) {
    IMPL.setTranslationX(paramView, paramFloat);
  }
  
  public static void setTranslationY(View paramView, float paramFloat) {
    IMPL.setTranslationY(paramView, paramFloat);
  }
  
  public static void setTranslationZ(View paramView, float paramFloat) {
    IMPL.setTranslationZ(paramView, paramFloat);
  }
  
  public static void setX(View paramView, float paramFloat) {
    IMPL.setX(paramView, paramFloat);
  }
  
  public static void setY(View paramView, float paramFloat) {
    IMPL.setY(paramView, paramFloat);
  }
  
  public static void setZ(View paramView, float paramFloat) {
    IMPL.setZ(paramView, paramFloat);
  }
  
  public static boolean startNestedScroll(View paramView, int paramInt) {
    return IMPL.startNestedScroll(paramView, paramInt);
  }
  
  public static void stopNestedScroll(View paramView) {
    IMPL.stopNestedScroll(paramView);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (BuildCompat.isAtLeastN()) {
      IMPL = new Api24ViewCompatImpl();
      return;
    } 
    if (i >= 23) {
      IMPL = new MarshmallowViewCompatImpl();
      return;
    } 
    if (i >= 21) {
      IMPL = new LollipopViewCompatImpl();
      return;
    } 
    if (i >= 19) {
      IMPL = new KitKatViewCompatImpl();
      return;
    } 
    if (i >= 18) {
      IMPL = new JbMr2ViewCompatImpl();
      return;
    } 
    if (i >= 17) {
      IMPL = new JbMr1ViewCompatImpl();
      return;
    } 
    if (i >= 16) {
      IMPL = new JBViewCompatImpl();
      return;
    } 
    if (i >= 15) {
      IMPL = new ICSMr1ViewCompatImpl();
      return;
    } 
    if (i >= 14) {
      IMPL = new ICSViewCompatImpl();
      return;
    } 
    if (i >= 11) {
      IMPL = new HCViewCompatImpl();
      return;
    } 
  }
  
  static class Api24ViewCompatImpl extends MarshmallowViewCompatImpl {
    public void setPointerIcon(View param1View, PointerIconCompat param1PointerIconCompat) {
      if (param1PointerIconCompat != null) {
        Object object = param1PointerIconCompat.getPointerIcon();
      } else {
        param1PointerIconCompat = null;
      } 
      ViewCompatApi24.setPointerIcon(param1View, param1PointerIconCompat);
    }
  }
  
  static class BaseViewCompatImpl implements ViewCompatImpl {
    private static Method sChildrenDrawingOrderMethod;
    
    private Method mDispatchFinishTemporaryDetach;
    
    private Method mDispatchStartTemporaryDetach;
    
    private boolean mTempDetachBound;
    
    WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;
    
    private void bindTempDetach() {
      try {
        this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
        this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.e("ViewCompat", "Couldn't find method", noSuchMethodException);
      } 
      this.mTempDetachBound = true;
    }
    
    private boolean canScrollingViewScrollHorizontally(ScrollingView param1ScrollingView, int param1Int) {
      boolean bool = true;
      int i = param1ScrollingView.computeHorizontalScrollOffset();
      int j = param1ScrollingView.computeHorizontalScrollRange() - param1ScrollingView.computeHorizontalScrollExtent();
      return (j == 0) ? false : ((param1Int < 0) ? ((i <= 0) ? false : bool) : ((i >= j - 1) ? false : bool));
    }
    
    private boolean canScrollingViewScrollVertically(ScrollingView param1ScrollingView, int param1Int) {
      boolean bool = true;
      int i = param1ScrollingView.computeVerticalScrollOffset();
      int j = param1ScrollingView.computeVerticalScrollRange() - param1ScrollingView.computeVerticalScrollExtent();
      return (j == 0) ? false : ((param1Int < 0) ? ((i <= 0) ? false : bool) : ((i >= j - 1) ? false : bool));
    }
    
    public ViewPropertyAnimatorCompat animate(View param1View) {
      return new ViewPropertyAnimatorCompat(param1View);
    }
    
    public boolean canScrollHorizontally(View param1View, int param1Int) {
      return (param1View instanceof ScrollingView && canScrollingViewScrollHorizontally((ScrollingView)param1View, param1Int));
    }
    
    public boolean canScrollVertically(View param1View, int param1Int) {
      return (param1View instanceof ScrollingView && canScrollingViewScrollVertically((ScrollingView)param1View, param1Int));
    }
    
    public int combineMeasuredStates(int param1Int1, int param1Int2) {
      return param1Int1 | param1Int2;
    }
    
    public WindowInsetsCompat dispatchApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
      return param1WindowInsetsCompat;
    }
    
    public void dispatchFinishTemporaryDetach(View param1View) {
      if (!this.mTempDetachBound)
        bindTempDetach(); 
      if (this.mDispatchFinishTemporaryDetach != null)
        try {
          this.mDispatchFinishTemporaryDetach.invoke(param1View, new Object[0]);
          return;
        } catch (Exception exception) {
          Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", exception);
          return;
        }  
      exception.onFinishTemporaryDetach();
    }
    
    public boolean dispatchNestedFling(View param1View, float param1Float1, float param1Float2, boolean param1Boolean) {
      return (param1View instanceof NestedScrollingChild) ? ((NestedScrollingChild)param1View).dispatchNestedFling(param1Float1, param1Float2, param1Boolean) : false;
    }
    
    public boolean dispatchNestedPreFling(View param1View, float param1Float1, float param1Float2) {
      return (param1View instanceof NestedScrollingChild) ? ((NestedScrollingChild)param1View).dispatchNestedPreFling(param1Float1, param1Float2) : false;
    }
    
    public boolean dispatchNestedPreScroll(View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
      return (param1View instanceof NestedScrollingChild) ? ((NestedScrollingChild)param1View).dispatchNestedPreScroll(param1Int1, param1Int2, param1ArrayOfint1, param1ArrayOfint2) : false;
    }
    
    public boolean dispatchNestedScroll(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int[] param1ArrayOfint) {
      return (param1View instanceof NestedScrollingChild) ? ((NestedScrollingChild)param1View).dispatchNestedScroll(param1Int1, param1Int2, param1Int3, param1Int4, param1ArrayOfint) : false;
    }
    
    public void dispatchStartTemporaryDetach(View param1View) {
      if (!this.mTempDetachBound)
        bindTempDetach(); 
      if (this.mDispatchStartTemporaryDetach != null)
        try {
          this.mDispatchStartTemporaryDetach.invoke(param1View, new Object[0]);
          return;
        } catch (Exception exception) {
          Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", exception);
          return;
        }  
      exception.onStartTemporaryDetach();
    }
    
    public int getAccessibilityLiveRegion(View param1View) {
      return 0;
    }
    
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View param1View) {
      return null;
    }
    
    public float getAlpha(View param1View) {
      return 1.0F;
    }
    
    public ColorStateList getBackgroundTintList(View param1View) {
      return ViewCompatBase.getBackgroundTintList(param1View);
    }
    
    public PorterDuff.Mode getBackgroundTintMode(View param1View) {
      return ViewCompatBase.getBackgroundTintMode(param1View);
    }
    
    public Rect getClipBounds(View param1View) {
      return null;
    }
    
    public Display getDisplay(View param1View) {
      return ViewCompatBase.getDisplay(param1View);
    }
    
    public float getElevation(View param1View) {
      return 0.0F;
    }
    
    public boolean getFitsSystemWindows(View param1View) {
      return false;
    }
    
    long getFrameTime() {
      return 10L;
    }
    
    public int getImportantForAccessibility(View param1View) {
      return 0;
    }
    
    public int getLabelFor(View param1View) {
      return 0;
    }
    
    public int getLayerType(View param1View) {
      return 0;
    }
    
    public int getLayoutDirection(View param1View) {
      return 0;
    }
    
    public Matrix getMatrix(View param1View) {
      return null;
    }
    
    public int getMeasuredHeightAndState(View param1View) {
      return param1View.getMeasuredHeight();
    }
    
    public int getMeasuredState(View param1View) {
      return 0;
    }
    
    public int getMeasuredWidthAndState(View param1View) {
      return param1View.getMeasuredWidth();
    }
    
    public int getMinimumHeight(View param1View) {
      return ViewCompatBase.getMinimumHeight(param1View);
    }
    
    public int getMinimumWidth(View param1View) {
      return ViewCompatBase.getMinimumWidth(param1View);
    }
    
    public int getPaddingEnd(View param1View) {
      return param1View.getPaddingRight();
    }
    
    public int getPaddingStart(View param1View) {
      return param1View.getPaddingLeft();
    }
    
    public ViewParent getParentForAccessibility(View param1View) {
      return param1View.getParent();
    }
    
    public float getPivotX(View param1View) {
      return 0.0F;
    }
    
    public float getPivotY(View param1View) {
      return 0.0F;
    }
    
    public float getRotation(View param1View) {
      return 0.0F;
    }
    
    public float getRotationX(View param1View) {
      return 0.0F;
    }
    
    public float getRotationY(View param1View) {
      return 0.0F;
    }
    
    public float getScaleX(View param1View) {
      return 0.0F;
    }
    
    public float getScaleY(View param1View) {
      return 0.0F;
    }
    
    public int getScrollIndicators(View param1View) {
      return 0;
    }
    
    public String getTransitionName(View param1View) {
      return null;
    }
    
    public float getTranslationX(View param1View) {
      return 0.0F;
    }
    
    public float getTranslationY(View param1View) {
      return 0.0F;
    }
    
    public float getTranslationZ(View param1View) {
      return 0.0F;
    }
    
    public int getWindowSystemUiVisibility(View param1View) {
      return 0;
    }
    
    public float getX(View param1View) {
      return param1View.getLeft();
    }
    
    public float getY(View param1View) {
      return param1View.getTop();
    }
    
    public float getZ(View param1View) {
      return getTranslationZ(param1View) + getElevation(param1View);
    }
    
    public boolean hasAccessibilityDelegate(View param1View) {
      return false;
    }
    
    public boolean hasNestedScrollingParent(View param1View) {
      return (param1View instanceof NestedScrollingChild) ? ((NestedScrollingChild)param1View).hasNestedScrollingParent() : false;
    }
    
    public boolean hasOnClickListeners(View param1View) {
      return false;
    }
    
    public boolean hasOverlappingRendering(View param1View) {
      return true;
    }
    
    public boolean hasTransientState(View param1View) {
      return false;
    }
    
    public boolean isAttachedToWindow(View param1View) {
      return ViewCompatBase.isAttachedToWindow(param1View);
    }
    
    public boolean isImportantForAccessibility(View param1View) {
      return true;
    }
    
    public boolean isInLayout(View param1View) {
      return false;
    }
    
    public boolean isLaidOut(View param1View) {
      return ViewCompatBase.isLaidOut(param1View);
    }
    
    public boolean isLayoutDirectionResolved(View param1View) {
      return false;
    }
    
    public boolean isNestedScrollingEnabled(View param1View) {
      return (param1View instanceof NestedScrollingChild) ? ((NestedScrollingChild)param1View).isNestedScrollingEnabled() : false;
    }
    
    public boolean isPaddingRelative(View param1View) {
      return false;
    }
    
    public void jumpDrawablesToCurrentState(View param1View) {}
    
    public void offsetLeftAndRight(View param1View, int param1Int) {
      ViewCompatBase.offsetLeftAndRight(param1View, param1Int);
    }
    
    public void offsetTopAndBottom(View param1View, int param1Int) {
      ViewCompatBase.offsetTopAndBottom(param1View, param1Int);
    }
    
    public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
      return param1WindowInsetsCompat;
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {}
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {}
    
    public void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {}
    
    public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) {
      return false;
    }
    
    public void postInvalidateOnAnimation(View param1View) {
      param1View.invalidate();
    }
    
    public void postInvalidateOnAnimation(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      param1View.invalidate(param1Int1, param1Int2, param1Int3, param1Int4);
    }
    
    public void postOnAnimation(View param1View, Runnable param1Runnable) {
      param1View.postDelayed(param1Runnable, getFrameTime());
    }
    
    public void postOnAnimationDelayed(View param1View, Runnable param1Runnable, long param1Long) {
      param1View.postDelayed(param1Runnable, getFrameTime() + param1Long);
    }
    
    public void requestApplyInsets(View param1View) {}
    
    public int resolveSizeAndState(int param1Int1, int param1Int2, int param1Int3) {
      return View.resolveSize(param1Int1, param1Int2);
    }
    
    public void setAccessibilityDelegate(View param1View, AccessibilityDelegateCompat param1AccessibilityDelegateCompat) {}
    
    public void setAccessibilityLiveRegion(View param1View, int param1Int) {}
    
    public void setActivated(View param1View, boolean param1Boolean) {}
    
    public void setAlpha(View param1View, float param1Float) {}
    
    public void setBackground(View param1View, Drawable param1Drawable) {
      param1View.setBackgroundDrawable(param1Drawable);
    }
    
    public void setBackgroundTintList(View param1View, ColorStateList param1ColorStateList) {
      ViewCompatBase.setBackgroundTintList(param1View, param1ColorStateList);
    }
    
    public void setBackgroundTintMode(View param1View, PorterDuff.Mode param1Mode) {
      ViewCompatBase.setBackgroundTintMode(param1View, param1Mode);
    }
    
    public void setChildrenDrawingOrderEnabled(ViewGroup param1ViewGroup, boolean param1Boolean) {
      // Byte code:
      //   0: getstatic android/support/v4/view/ViewCompat$BaseViewCompatImpl.sChildrenDrawingOrderMethod : Ljava/lang/reflect/Method;
      //   3: ifnonnull -> 35
      //   6: ldc_w android/view/ViewGroup
      //   9: ldc_w 'setChildrenDrawingOrderEnabled'
      //   12: iconst_1
      //   13: anewarray java/lang/Class
      //   16: dup
      //   17: iconst_0
      //   18: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
      //   21: aastore
      //   22: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   25: putstatic android/support/v4/view/ViewCompat$BaseViewCompatImpl.sChildrenDrawingOrderMethod : Ljava/lang/reflect/Method;
      //   28: getstatic android/support/v4/view/ViewCompat$BaseViewCompatImpl.sChildrenDrawingOrderMethod : Ljava/lang/reflect/Method;
      //   31: iconst_1
      //   32: invokevirtual setAccessible : (Z)V
      //   35: getstatic android/support/v4/view/ViewCompat$BaseViewCompatImpl.sChildrenDrawingOrderMethod : Ljava/lang/reflect/Method;
      //   38: aload_1
      //   39: iconst_1
      //   40: anewarray java/lang/Object
      //   43: dup
      //   44: iconst_0
      //   45: iload_2
      //   46: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   49: aastore
      //   50: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   53: pop
      //   54: return
      //   55: astore_3
      //   56: ldc 'ViewCompat'
      //   58: ldc_w 'Unable to find childrenDrawingOrderEnabled'
      //   61: aload_3
      //   62: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   65: pop
      //   66: goto -> 28
      //   69: astore_1
      //   70: ldc 'ViewCompat'
      //   72: ldc_w 'Unable to invoke childrenDrawingOrderEnabled'
      //   75: aload_1
      //   76: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   79: pop
      //   80: return
      //   81: astore_1
      //   82: ldc 'ViewCompat'
      //   84: ldc_w 'Unable to invoke childrenDrawingOrderEnabled'
      //   87: aload_1
      //   88: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   91: pop
      //   92: return
      //   93: astore_1
      //   94: ldc 'ViewCompat'
      //   96: ldc_w 'Unable to invoke childrenDrawingOrderEnabled'
      //   99: aload_1
      //   100: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   103: pop
      //   104: return
      // Exception table:
      //   from	to	target	type
      //   6	28	55	java/lang/NoSuchMethodException
      //   35	54	69	java/lang/IllegalAccessException
      //   35	54	81	java/lang/IllegalArgumentException
      //   35	54	93	java/lang/reflect/InvocationTargetException
    }
    
    public void setClipBounds(View param1View, Rect param1Rect) {}
    
    public void setElevation(View param1View, float param1Float) {}
    
    public void setFitsSystemWindows(View param1View, boolean param1Boolean) {}
    
    public void setHasTransientState(View param1View, boolean param1Boolean) {}
    
    public void setImportantForAccessibility(View param1View, int param1Int) {}
    
    public void setLabelFor(View param1View, int param1Int) {}
    
    public void setLayerPaint(View param1View, Paint param1Paint) {}
    
    public void setLayerType(View param1View, int param1Int, Paint param1Paint) {}
    
    public void setLayoutDirection(View param1View, int param1Int) {}
    
    public void setNestedScrollingEnabled(View param1View, boolean param1Boolean) {
      if (param1View instanceof NestedScrollingChild)
        ((NestedScrollingChild)param1View).setNestedScrollingEnabled(param1Boolean); 
    }
    
    public void setOnApplyWindowInsetsListener(View param1View, OnApplyWindowInsetsListener param1OnApplyWindowInsetsListener) {}
    
    public void setPaddingRelative(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      param1View.setPadding(param1Int1, param1Int2, param1Int3, param1Int4);
    }
    
    public void setPivotX(View param1View, float param1Float) {}
    
    public void setPivotY(View param1View, float param1Float) {}
    
    public void setPointerIcon(View param1View, PointerIconCompat param1PointerIconCompat) {}
    
    public void setRotation(View param1View, float param1Float) {}
    
    public void setRotationX(View param1View, float param1Float) {}
    
    public void setRotationY(View param1View, float param1Float) {}
    
    public void setSaveFromParentEnabled(View param1View, boolean param1Boolean) {}
    
    public void setScaleX(View param1View, float param1Float) {}
    
    public void setScaleY(View param1View, float param1Float) {}
    
    public void setScrollIndicators(View param1View, int param1Int) {}
    
    public void setScrollIndicators(View param1View, int param1Int1, int param1Int2) {}
    
    public void setTransitionName(View param1View, String param1String) {}
    
    public void setTranslationX(View param1View, float param1Float) {}
    
    public void setTranslationY(View param1View, float param1Float) {}
    
    public void setTranslationZ(View param1View, float param1Float) {}
    
    public void setX(View param1View, float param1Float) {}
    
    public void setY(View param1View, float param1Float) {}
    
    public void setZ(View param1View, float param1Float) {}
    
    public boolean startNestedScroll(View param1View, int param1Int) {
      return (param1View instanceof NestedScrollingChild) ? ((NestedScrollingChild)param1View).startNestedScroll(param1Int) : false;
    }
    
    public void stopNestedScroll(View param1View) {
      if (param1View instanceof NestedScrollingChild)
        ((NestedScrollingChild)param1View).stopNestedScroll(); 
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface FocusDirection {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface FocusRealDirection {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface FocusRelativeDirection {}
  
  static class HCViewCompatImpl extends BaseViewCompatImpl {
    public int combineMeasuredStates(int param1Int1, int param1Int2) {
      return ViewCompatHC.combineMeasuredStates(param1Int1, param1Int2);
    }
    
    public float getAlpha(View param1View) {
      return ViewCompatHC.getAlpha(param1View);
    }
    
    long getFrameTime() {
      return ViewCompatHC.getFrameTime();
    }
    
    public int getLayerType(View param1View) {
      return ViewCompatHC.getLayerType(param1View);
    }
    
    public Matrix getMatrix(View param1View) {
      return ViewCompatHC.getMatrix(param1View);
    }
    
    public int getMeasuredHeightAndState(View param1View) {
      return ViewCompatHC.getMeasuredHeightAndState(param1View);
    }
    
    public int getMeasuredState(View param1View) {
      return ViewCompatHC.getMeasuredState(param1View);
    }
    
    public int getMeasuredWidthAndState(View param1View) {
      return ViewCompatHC.getMeasuredWidthAndState(param1View);
    }
    
    public float getPivotX(View param1View) {
      return ViewCompatHC.getPivotX(param1View);
    }
    
    public float getPivotY(View param1View) {
      return ViewCompatHC.getPivotY(param1View);
    }
    
    public float getRotation(View param1View) {
      return ViewCompatHC.getRotation(param1View);
    }
    
    public float getRotationX(View param1View) {
      return ViewCompatHC.getRotationX(param1View);
    }
    
    public float getRotationY(View param1View) {
      return ViewCompatHC.getRotationY(param1View);
    }
    
    public float getScaleX(View param1View) {
      return ViewCompatHC.getScaleX(param1View);
    }
    
    public float getScaleY(View param1View) {
      return ViewCompatHC.getScaleY(param1View);
    }
    
    public float getTranslationX(View param1View) {
      return ViewCompatHC.getTranslationX(param1View);
    }
    
    public float getTranslationY(View param1View) {
      return ViewCompatHC.getTranslationY(param1View);
    }
    
    public float getX(View param1View) {
      return ViewCompatHC.getX(param1View);
    }
    
    public float getY(View param1View) {
      return ViewCompatHC.getY(param1View);
    }
    
    public void jumpDrawablesToCurrentState(View param1View) {
      ViewCompatHC.jumpDrawablesToCurrentState(param1View);
    }
    
    public void offsetLeftAndRight(View param1View, int param1Int) {
      ViewCompatHC.offsetLeftAndRight(param1View, param1Int);
    }
    
    public void offsetTopAndBottom(View param1View, int param1Int) {
      ViewCompatHC.offsetTopAndBottom(param1View, param1Int);
    }
    
    public int resolveSizeAndState(int param1Int1, int param1Int2, int param1Int3) {
      return ViewCompatHC.resolveSizeAndState(param1Int1, param1Int2, param1Int3);
    }
    
    public void setActivated(View param1View, boolean param1Boolean) {
      ViewCompatHC.setActivated(param1View, param1Boolean);
    }
    
    public void setAlpha(View param1View, float param1Float) {
      ViewCompatHC.setAlpha(param1View, param1Float);
    }
    
    public void setLayerPaint(View param1View, Paint param1Paint) {
      setLayerType(param1View, getLayerType(param1View), param1Paint);
      param1View.invalidate();
    }
    
    public void setLayerType(View param1View, int param1Int, Paint param1Paint) {
      ViewCompatHC.setLayerType(param1View, param1Int, param1Paint);
    }
    
    public void setPivotX(View param1View, float param1Float) {
      ViewCompatHC.setPivotX(param1View, param1Float);
    }
    
    public void setPivotY(View param1View, float param1Float) {
      ViewCompatHC.setPivotY(param1View, param1Float);
    }
    
    public void setRotation(View param1View, float param1Float) {
      ViewCompatHC.setRotation(param1View, param1Float);
    }
    
    public void setRotationX(View param1View, float param1Float) {
      ViewCompatHC.setRotationX(param1View, param1Float);
    }
    
    public void setRotationY(View param1View, float param1Float) {
      ViewCompatHC.setRotationY(param1View, param1Float);
    }
    
    public void setSaveFromParentEnabled(View param1View, boolean param1Boolean) {
      ViewCompatHC.setSaveFromParentEnabled(param1View, param1Boolean);
    }
    
    public void setScaleX(View param1View, float param1Float) {
      ViewCompatHC.setScaleX(param1View, param1Float);
    }
    
    public void setScaleY(View param1View, float param1Float) {
      ViewCompatHC.setScaleY(param1View, param1Float);
    }
    
    public void setTranslationX(View param1View, float param1Float) {
      ViewCompatHC.setTranslationX(param1View, param1Float);
    }
    
    public void setTranslationY(View param1View, float param1Float) {
      ViewCompatHC.setTranslationY(param1View, param1Float);
    }
    
    public void setX(View param1View, float param1Float) {
      ViewCompatHC.setX(param1View, param1Float);
    }
    
    public void setY(View param1View, float param1Float) {
      ViewCompatHC.setY(param1View, param1Float);
    }
  }
  
  static class ICSMr1ViewCompatImpl extends ICSViewCompatImpl {
    public boolean hasOnClickListeners(View param1View) {
      return ViewCompatICSMr1.hasOnClickListeners(param1View);
    }
  }
  
  static class ICSViewCompatImpl extends HCViewCompatImpl {
    static boolean accessibilityDelegateCheckFailed = false;
    
    static Field mAccessibilityDelegateField;
    
    public ViewPropertyAnimatorCompat animate(View param1View) {
      if (this.mViewPropertyAnimatorCompatMap == null)
        this.mViewPropertyAnimatorCompatMap = new WeakHashMap<View, ViewPropertyAnimatorCompat>(); 
      ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = this.mViewPropertyAnimatorCompatMap.get(param1View);
      ViewPropertyAnimatorCompat viewPropertyAnimatorCompat1 = viewPropertyAnimatorCompat2;
      if (viewPropertyAnimatorCompat2 == null) {
        viewPropertyAnimatorCompat1 = new ViewPropertyAnimatorCompat(param1View);
        this.mViewPropertyAnimatorCompatMap.put(param1View, viewPropertyAnimatorCompat1);
      } 
      return viewPropertyAnimatorCompat1;
    }
    
    public boolean canScrollHorizontally(View param1View, int param1Int) {
      return ViewCompatICS.canScrollHorizontally(param1View, param1Int);
    }
    
    public boolean canScrollVertically(View param1View, int param1Int) {
      return ViewCompatICS.canScrollVertically(param1View, param1Int);
    }
    
    public boolean hasAccessibilityDelegate(View param1View) {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: getstatic android/support/v4/view/ViewCompat$ICSViewCompatImpl.accessibilityDelegateCheckFailed : Z
      //   5: ifeq -> 10
      //   8: iconst_0
      //   9: ireturn
      //   10: getstatic android/support/v4/view/ViewCompat$ICSViewCompatImpl.mAccessibilityDelegateField : Ljava/lang/reflect/Field;
      //   13: ifnonnull -> 33
      //   16: ldc android/view/View
      //   18: ldc 'mAccessibilityDelegate'
      //   20: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   23: putstatic android/support/v4/view/ViewCompat$ICSViewCompatImpl.mAccessibilityDelegateField : Ljava/lang/reflect/Field;
      //   26: getstatic android/support/v4/view/ViewCompat$ICSViewCompatImpl.mAccessibilityDelegateField : Ljava/lang/reflect/Field;
      //   29: iconst_1
      //   30: invokevirtual setAccessible : (Z)V
      //   33: getstatic android/support/v4/view/ViewCompat$ICSViewCompatImpl.mAccessibilityDelegateField : Ljava/lang/reflect/Field;
      //   36: aload_1
      //   37: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   40: astore_1
      //   41: aload_1
      //   42: ifnull -> 54
      //   45: iload_2
      //   46: ireturn
      //   47: astore_1
      //   48: iconst_1
      //   49: putstatic android/support/v4/view/ViewCompat$ICSViewCompatImpl.accessibilityDelegateCheckFailed : Z
      //   52: iconst_0
      //   53: ireturn
      //   54: iconst_0
      //   55: istore_2
      //   56: goto -> 45
      //   59: astore_1
      //   60: iconst_1
      //   61: putstatic android/support/v4/view/ViewCompat$ICSViewCompatImpl.accessibilityDelegateCheckFailed : Z
      //   64: iconst_0
      //   65: ireturn
      // Exception table:
      //   from	to	target	type
      //   16	33	47	java/lang/Throwable
      //   33	41	59	java/lang/Throwable
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      ViewCompatICS.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      ViewCompatICS.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat.getInfo());
    }
    
    public void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      ViewCompatICS.onPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public void setAccessibilityDelegate(View param1View, @Nullable AccessibilityDelegateCompat param1AccessibilityDelegateCompat) {
      Object object;
      if (param1AccessibilityDelegateCompat == null) {
        param1AccessibilityDelegateCompat = null;
      } else {
        object = param1AccessibilityDelegateCompat.getBridge();
      } 
      ViewCompatICS.setAccessibilityDelegate(param1View, object);
    }
    
    public void setFitsSystemWindows(View param1View, boolean param1Boolean) {
      ViewCompatICS.setFitsSystemWindows(param1View, param1Boolean);
    }
  }
  
  static class JBViewCompatImpl extends ICSMr1ViewCompatImpl {
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View param1View) {
      Object object = ViewCompatJB.getAccessibilityNodeProvider(param1View);
      return (object != null) ? new AccessibilityNodeProviderCompat(object) : null;
    }
    
    public boolean getFitsSystemWindows(View param1View) {
      return ViewCompatJB.getFitsSystemWindows(param1View);
    }
    
    public int getImportantForAccessibility(View param1View) {
      return ViewCompatJB.getImportantForAccessibility(param1View);
    }
    
    public int getMinimumHeight(View param1View) {
      return ViewCompatJB.getMinimumHeight(param1View);
    }
    
    public int getMinimumWidth(View param1View) {
      return ViewCompatJB.getMinimumWidth(param1View);
    }
    
    public ViewParent getParentForAccessibility(View param1View) {
      return ViewCompatJB.getParentForAccessibility(param1View);
    }
    
    public boolean hasOverlappingRendering(View param1View) {
      return ViewCompatJB.hasOverlappingRendering(param1View);
    }
    
    public boolean hasTransientState(View param1View) {
      return ViewCompatJB.hasTransientState(param1View);
    }
    
    public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) {
      return ViewCompatJB.performAccessibilityAction(param1View, param1Int, param1Bundle);
    }
    
    public void postInvalidateOnAnimation(View param1View) {
      ViewCompatJB.postInvalidateOnAnimation(param1View);
    }
    
    public void postInvalidateOnAnimation(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      ViewCompatJB.postInvalidateOnAnimation(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
    }
    
    public void postOnAnimation(View param1View, Runnable param1Runnable) {
      ViewCompatJB.postOnAnimation(param1View, param1Runnable);
    }
    
    public void postOnAnimationDelayed(View param1View, Runnable param1Runnable, long param1Long) {
      ViewCompatJB.postOnAnimationDelayed(param1View, param1Runnable, param1Long);
    }
    
    public void requestApplyInsets(View param1View) {
      ViewCompatJB.requestApplyInsets(param1View);
    }
    
    public void setBackground(View param1View, Drawable param1Drawable) {
      ViewCompatJB.setBackground(param1View, param1Drawable);
    }
    
    public void setHasTransientState(View param1View, boolean param1Boolean) {
      ViewCompatJB.setHasTransientState(param1View, param1Boolean);
    }
    
    public void setImportantForAccessibility(View param1View, int param1Int) {
      int i = param1Int;
      if (param1Int == 4)
        i = 2; 
      ViewCompatJB.setImportantForAccessibility(param1View, i);
    }
  }
  
  static class JbMr1ViewCompatImpl extends JBViewCompatImpl {
    public Display getDisplay(View param1View) {
      return ViewCompatJellybeanMr1.getDisplay(param1View);
    }
    
    public int getLabelFor(View param1View) {
      return ViewCompatJellybeanMr1.getLabelFor(param1View);
    }
    
    public int getLayoutDirection(View param1View) {
      return ViewCompatJellybeanMr1.getLayoutDirection(param1View);
    }
    
    public int getPaddingEnd(View param1View) {
      return ViewCompatJellybeanMr1.getPaddingEnd(param1View);
    }
    
    public int getPaddingStart(View param1View) {
      return ViewCompatJellybeanMr1.getPaddingStart(param1View);
    }
    
    public int getWindowSystemUiVisibility(View param1View) {
      return ViewCompatJellybeanMr1.getWindowSystemUiVisibility(param1View);
    }
    
    public boolean isPaddingRelative(View param1View) {
      return ViewCompatJellybeanMr1.isPaddingRelative(param1View);
    }
    
    public void setLabelFor(View param1View, int param1Int) {
      ViewCompatJellybeanMr1.setLabelFor(param1View, param1Int);
    }
    
    public void setLayerPaint(View param1View, Paint param1Paint) {
      ViewCompatJellybeanMr1.setLayerPaint(param1View, param1Paint);
    }
    
    public void setLayoutDirection(View param1View, int param1Int) {
      ViewCompatJellybeanMr1.setLayoutDirection(param1View, param1Int);
    }
    
    public void setPaddingRelative(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      ViewCompatJellybeanMr1.setPaddingRelative(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
    }
  }
  
  static class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl {
    public Rect getClipBounds(View param1View) {
      return ViewCompatJellybeanMr2.getClipBounds(param1View);
    }
    
    public boolean isInLayout(View param1View) {
      return ViewCompatJellybeanMr2.isInLayout(param1View);
    }
    
    public void setClipBounds(View param1View, Rect param1Rect) {
      ViewCompatJellybeanMr2.setClipBounds(param1View, param1Rect);
    }
  }
  
  static class KitKatViewCompatImpl extends JbMr2ViewCompatImpl {
    public int getAccessibilityLiveRegion(View param1View) {
      return ViewCompatKitKat.getAccessibilityLiveRegion(param1View);
    }
    
    public boolean isAttachedToWindow(View param1View) {
      return ViewCompatKitKat.isAttachedToWindow(param1View);
    }
    
    public boolean isLaidOut(View param1View) {
      return ViewCompatKitKat.isLaidOut(param1View);
    }
    
    public boolean isLayoutDirectionResolved(View param1View) {
      return ViewCompatKitKat.isLayoutDirectionResolved(param1View);
    }
    
    public void setAccessibilityLiveRegion(View param1View, int param1Int) {
      ViewCompatKitKat.setAccessibilityLiveRegion(param1View, param1Int);
    }
    
    public void setImportantForAccessibility(View param1View, int param1Int) {
      ViewCompatJB.setImportantForAccessibility(param1View, param1Int);
    }
  }
  
  static class LollipopViewCompatImpl extends KitKatViewCompatImpl {
    public WindowInsetsCompat dispatchApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
      return WindowInsetsCompat.wrap(ViewCompatLollipop.dispatchApplyWindowInsets(param1View, WindowInsetsCompat.unwrap(param1WindowInsetsCompat)));
    }
    
    public boolean dispatchNestedFling(View param1View, float param1Float1, float param1Float2, boolean param1Boolean) {
      return ViewCompatLollipop.dispatchNestedFling(param1View, param1Float1, param1Float2, param1Boolean);
    }
    
    public boolean dispatchNestedPreFling(View param1View, float param1Float1, float param1Float2) {
      return ViewCompatLollipop.dispatchNestedPreFling(param1View, param1Float1, param1Float2);
    }
    
    public boolean dispatchNestedPreScroll(View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
      return ViewCompatLollipop.dispatchNestedPreScroll(param1View, param1Int1, param1Int2, param1ArrayOfint1, param1ArrayOfint2);
    }
    
    public boolean dispatchNestedScroll(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int[] param1ArrayOfint) {
      return ViewCompatLollipop.dispatchNestedScroll(param1View, param1Int1, param1Int2, param1Int3, param1Int4, param1ArrayOfint);
    }
    
    public ColorStateList getBackgroundTintList(View param1View) {
      return ViewCompatLollipop.getBackgroundTintList(param1View);
    }
    
    public PorterDuff.Mode getBackgroundTintMode(View param1View) {
      return ViewCompatLollipop.getBackgroundTintMode(param1View);
    }
    
    public float getElevation(View param1View) {
      return ViewCompatLollipop.getElevation(param1View);
    }
    
    public String getTransitionName(View param1View) {
      return ViewCompatLollipop.getTransitionName(param1View);
    }
    
    public float getTranslationZ(View param1View) {
      return ViewCompatLollipop.getTranslationZ(param1View);
    }
    
    public float getZ(View param1View) {
      return ViewCompatLollipop.getZ(param1View);
    }
    
    public boolean hasNestedScrollingParent(View param1View) {
      return ViewCompatLollipop.hasNestedScrollingParent(param1View);
    }
    
    public boolean isImportantForAccessibility(View param1View) {
      return ViewCompatLollipop.isImportantForAccessibility(param1View);
    }
    
    public boolean isNestedScrollingEnabled(View param1View) {
      return ViewCompatLollipop.isNestedScrollingEnabled(param1View);
    }
    
    public void offsetLeftAndRight(View param1View, int param1Int) {
      ViewCompatLollipop.offsetLeftAndRight(param1View, param1Int);
    }
    
    public void offsetTopAndBottom(View param1View, int param1Int) {
      ViewCompatLollipop.offsetTopAndBottom(param1View, param1Int);
    }
    
    public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
      return WindowInsetsCompat.wrap(ViewCompatLollipop.onApplyWindowInsets(param1View, WindowInsetsCompat.unwrap(param1WindowInsetsCompat)));
    }
    
    public void requestApplyInsets(View param1View) {
      ViewCompatLollipop.requestApplyInsets(param1View);
    }
    
    public void setBackgroundTintList(View param1View, ColorStateList param1ColorStateList) {
      ViewCompatLollipop.setBackgroundTintList(param1View, param1ColorStateList);
    }
    
    public void setBackgroundTintMode(View param1View, PorterDuff.Mode param1Mode) {
      ViewCompatLollipop.setBackgroundTintMode(param1View, param1Mode);
    }
    
    public void setElevation(View param1View, float param1Float) {
      ViewCompatLollipop.setElevation(param1View, param1Float);
    }
    
    public void setNestedScrollingEnabled(View param1View, boolean param1Boolean) {
      ViewCompatLollipop.setNestedScrollingEnabled(param1View, param1Boolean);
    }
    
    public void setOnApplyWindowInsetsListener(View param1View, final OnApplyWindowInsetsListener listener) {
      if (listener == null) {
        ViewCompatLollipop.setOnApplyWindowInsetsListener(param1View, null);
        return;
      } 
      ViewCompatLollipop.setOnApplyWindowInsetsListener(param1View, new ViewCompatLollipop.OnApplyWindowInsetsListenerBridge() {
            public Object onApplyWindowInsets(View param2View, Object param2Object) {
              param2Object = WindowInsetsCompat.wrap(param2Object);
              return WindowInsetsCompat.unwrap(listener.onApplyWindowInsets(param2View, (WindowInsetsCompat)param2Object));
            }
          });
    }
    
    public void setTransitionName(View param1View, String param1String) {
      ViewCompatLollipop.setTransitionName(param1View, param1String);
    }
    
    public void setTranslationZ(View param1View, float param1Float) {
      ViewCompatLollipop.setTranslationZ(param1View, param1Float);
    }
    
    public void setZ(View param1View, float param1Float) {
      ViewCompatLollipop.setZ(param1View, param1Float);
    }
    
    public boolean startNestedScroll(View param1View, int param1Int) {
      return ViewCompatLollipop.startNestedScroll(param1View, param1Int);
    }
    
    public void stopNestedScroll(View param1View) {
      ViewCompatLollipop.stopNestedScroll(param1View);
    }
  }
  
  class null implements ViewCompatLollipop.OnApplyWindowInsetsListenerBridge {
    public Object onApplyWindowInsets(View param1View, Object param1Object) {
      param1Object = WindowInsetsCompat.wrap(param1Object);
      return WindowInsetsCompat.unwrap(listener.onApplyWindowInsets(param1View, (WindowInsetsCompat)param1Object));
    }
  }
  
  static class MarshmallowViewCompatImpl extends LollipopViewCompatImpl {
    public int getScrollIndicators(View param1View) {
      return ViewCompatMarshmallow.getScrollIndicators(param1View);
    }
    
    public void offsetLeftAndRight(View param1View, int param1Int) {
      ViewCompatMarshmallow.offsetLeftAndRight(param1View, param1Int);
    }
    
    public void offsetTopAndBottom(View param1View, int param1Int) {
      ViewCompatMarshmallow.offsetTopAndBottom(param1View, param1Int);
    }
    
    public void setScrollIndicators(View param1View, int param1Int) {
      ViewCompatMarshmallow.setScrollIndicators(param1View, param1Int);
    }
    
    public void setScrollIndicators(View param1View, int param1Int1, int param1Int2) {
      ViewCompatMarshmallow.setScrollIndicators(param1View, param1Int1, param1Int2);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScrollIndicators {}
  
  static interface ViewCompatImpl {
    ViewPropertyAnimatorCompat animate(View param1View);
    
    boolean canScrollHorizontally(View param1View, int param1Int);
    
    boolean canScrollVertically(View param1View, int param1Int);
    
    int combineMeasuredStates(int param1Int1, int param1Int2);
    
    WindowInsetsCompat dispatchApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat);
    
    void dispatchFinishTemporaryDetach(View param1View);
    
    boolean dispatchNestedFling(View param1View, float param1Float1, float param1Float2, boolean param1Boolean);
    
    boolean dispatchNestedPreFling(View param1View, float param1Float1, float param1Float2);
    
    boolean dispatchNestedPreScroll(View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfint1, int[] param1ArrayOfint2);
    
    boolean dispatchNestedScroll(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int[] param1ArrayOfint);
    
    void dispatchStartTemporaryDetach(View param1View);
    
    int getAccessibilityLiveRegion(View param1View);
    
    AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View param1View);
    
    float getAlpha(View param1View);
    
    ColorStateList getBackgroundTintList(View param1View);
    
    PorterDuff.Mode getBackgroundTintMode(View param1View);
    
    Rect getClipBounds(View param1View);
    
    Display getDisplay(View param1View);
    
    float getElevation(View param1View);
    
    boolean getFitsSystemWindows(View param1View);
    
    int getImportantForAccessibility(View param1View);
    
    int getLabelFor(View param1View);
    
    int getLayerType(View param1View);
    
    int getLayoutDirection(View param1View);
    
    @Nullable
    Matrix getMatrix(View param1View);
    
    int getMeasuredHeightAndState(View param1View);
    
    int getMeasuredState(View param1View);
    
    int getMeasuredWidthAndState(View param1View);
    
    int getMinimumHeight(View param1View);
    
    int getMinimumWidth(View param1View);
    
    int getPaddingEnd(View param1View);
    
    int getPaddingStart(View param1View);
    
    ViewParent getParentForAccessibility(View param1View);
    
    float getPivotX(View param1View);
    
    float getPivotY(View param1View);
    
    float getRotation(View param1View);
    
    float getRotationX(View param1View);
    
    float getRotationY(View param1View);
    
    float getScaleX(View param1View);
    
    float getScaleY(View param1View);
    
    int getScrollIndicators(View param1View);
    
    String getTransitionName(View param1View);
    
    float getTranslationX(View param1View);
    
    float getTranslationY(View param1View);
    
    float getTranslationZ(View param1View);
    
    int getWindowSystemUiVisibility(View param1View);
    
    float getX(View param1View);
    
    float getY(View param1View);
    
    float getZ(View param1View);
    
    boolean hasAccessibilityDelegate(View param1View);
    
    boolean hasNestedScrollingParent(View param1View);
    
    boolean hasOnClickListeners(View param1View);
    
    boolean hasOverlappingRendering(View param1View);
    
    boolean hasTransientState(View param1View);
    
    boolean isAttachedToWindow(View param1View);
    
    boolean isImportantForAccessibility(View param1View);
    
    boolean isInLayout(View param1View);
    
    boolean isLaidOut(View param1View);
    
    boolean isLayoutDirectionResolved(View param1View);
    
    boolean isNestedScrollingEnabled(View param1View);
    
    boolean isPaddingRelative(View param1View);
    
    void jumpDrawablesToCurrentState(View param1View);
    
    void offsetLeftAndRight(View param1View, int param1Int);
    
    void offsetTopAndBottom(View param1View, int param1Int);
    
    WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat);
    
    void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat);
    
    void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle);
    
    void postInvalidateOnAnimation(View param1View);
    
    void postInvalidateOnAnimation(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
    
    void postOnAnimation(View param1View, Runnable param1Runnable);
    
    void postOnAnimationDelayed(View param1View, Runnable param1Runnable, long param1Long);
    
    void requestApplyInsets(View param1View);
    
    int resolveSizeAndState(int param1Int1, int param1Int2, int param1Int3);
    
    void setAccessibilityDelegate(View param1View, @Nullable AccessibilityDelegateCompat param1AccessibilityDelegateCompat);
    
    void setAccessibilityLiveRegion(View param1View, int param1Int);
    
    void setActivated(View param1View, boolean param1Boolean);
    
    void setAlpha(View param1View, float param1Float);
    
    void setBackground(View param1View, Drawable param1Drawable);
    
    void setBackgroundTintList(View param1View, ColorStateList param1ColorStateList);
    
    void setBackgroundTintMode(View param1View, PorterDuff.Mode param1Mode);
    
    void setChildrenDrawingOrderEnabled(ViewGroup param1ViewGroup, boolean param1Boolean);
    
    void setClipBounds(View param1View, Rect param1Rect);
    
    void setElevation(View param1View, float param1Float);
    
    void setFitsSystemWindows(View param1View, boolean param1Boolean);
    
    void setHasTransientState(View param1View, boolean param1Boolean);
    
    void setImportantForAccessibility(View param1View, int param1Int);
    
    void setLabelFor(View param1View, int param1Int);
    
    void setLayerPaint(View param1View, Paint param1Paint);
    
    void setLayerType(View param1View, int param1Int, Paint param1Paint);
    
    void setLayoutDirection(View param1View, int param1Int);
    
    void setNestedScrollingEnabled(View param1View, boolean param1Boolean);
    
    void setOnApplyWindowInsetsListener(View param1View, OnApplyWindowInsetsListener param1OnApplyWindowInsetsListener);
    
    void setPaddingRelative(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
    
    void setPivotX(View param1View, float param1Float);
    
    void setPivotY(View param1View, float param1Float);
    
    void setPointerIcon(View param1View, PointerIconCompat param1PointerIconCompat);
    
    void setRotation(View param1View, float param1Float);
    
    void setRotationX(View param1View, float param1Float);
    
    void setRotationY(View param1View, float param1Float);
    
    void setSaveFromParentEnabled(View param1View, boolean param1Boolean);
    
    void setScaleX(View param1View, float param1Float);
    
    void setScaleY(View param1View, float param1Float);
    
    void setScrollIndicators(View param1View, int param1Int);
    
    void setScrollIndicators(View param1View, int param1Int1, int param1Int2);
    
    void setTransitionName(View param1View, String param1String);
    
    void setTranslationX(View param1View, float param1Float);
    
    void setTranslationY(View param1View, float param1Float);
    
    void setTranslationZ(View param1View, float param1Float);
    
    void setX(View param1View, float param1Float);
    
    void setY(View param1View, float param1Float);
    
    void setZ(View param1View, float param1Float);
    
    boolean startNestedScroll(View param1View, int param1Int);
    
    void stopNestedScroll(View param1View);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */