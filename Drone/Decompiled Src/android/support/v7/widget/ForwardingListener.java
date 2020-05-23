package android.support.v7.widget;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewTreeObserver;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ForwardingListener implements View.OnTouchListener {
  private int mActivePointerId;
  
  private Runnable mDisallowIntercept;
  
  private boolean mForwarding;
  
  private final int mLongPressTimeout;
  
  private final float mScaledTouchSlop;
  
  final View mSrc;
  
  private final int mTapTimeout;
  
  private final int[] mTmpLocation = new int[2];
  
  private Runnable mTriggerLongPress;
  
  public ForwardingListener(View paramView) {
    this.mSrc = paramView;
    paramView.setLongClickable(true);
    if (Build.VERSION.SDK_INT >= 12) {
      addDetachListenerApi12(paramView);
    } else {
      addDetachListenerBase(paramView);
    } 
    this.mScaledTouchSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.mTapTimeout = ViewConfiguration.getTapTimeout();
    this.mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
  }
  
  @TargetApi(12)
  @RequiresApi(12)
  private void addDetachListenerApi12(View paramView) {
    paramView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
          public void onViewAttachedToWindow(View param1View) {}
          
          public void onViewDetachedFromWindow(View param1View) {
            ForwardingListener.this.onDetachedFromWindow();
          }
        });
  }
  
  private void addDetachListenerBase(View paramView) {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
          boolean mIsAttached = ViewCompat.isAttachedToWindow(ForwardingListener.this.mSrc);
          
          public void onGlobalLayout() {
            boolean bool = this.mIsAttached;
            this.mIsAttached = ViewCompat.isAttachedToWindow(ForwardingListener.this.mSrc);
            if (bool && !this.mIsAttached)
              ForwardingListener.this.onDetachedFromWindow(); 
          }
        });
  }
  
  private void clearCallbacks() {
    if (this.mTriggerLongPress != null)
      this.mSrc.removeCallbacks(this.mTriggerLongPress); 
    if (this.mDisallowIntercept != null)
      this.mSrc.removeCallbacks(this.mDisallowIntercept); 
  }
  
  private void onDetachedFromWindow() {
    this.mForwarding = false;
    this.mActivePointerId = -1;
    if (this.mDisallowIntercept != null)
      this.mSrc.removeCallbacks(this.mDisallowIntercept); 
  }
  
  private boolean onTouchForwarded(MotionEvent paramMotionEvent) {
    boolean bool = true;
    View view = this.mSrc;
    ShowableListMenu showableListMenu = getPopup();
    if (showableListMenu != null && showableListMenu.isShowing()) {
      DropDownListView dropDownListView = (DropDownListView)showableListMenu.getListView();
      if (dropDownListView != null && dropDownListView.isShown()) {
        MotionEvent motionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        toGlobalMotionEvent(view, motionEvent);
        toLocalMotionEvent((View)dropDownListView, motionEvent);
        boolean bool1 = dropDownListView.onForwardedEvent(motionEvent, this.mActivePointerId);
        motionEvent.recycle();
        int i = MotionEventCompat.getActionMasked(paramMotionEvent);
        if (i != 1 && i != 3) {
          i = 1;
        } else {
          i = 0;
        } 
        if (!bool1 || i == 0)
          bool = false; 
        return bool;
      } 
    } 
    return false;
  }
  
  private boolean onTouchObserved(MotionEvent paramMotionEvent) {
    View view = this.mSrc;
    if (view.isEnabled()) {
      int i;
      switch (MotionEventCompat.getActionMasked(paramMotionEvent)) {
        default:
          return false;
        case 0:
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          if (this.mDisallowIntercept == null)
            this.mDisallowIntercept = new DisallowIntercept(); 
          view.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
          if (this.mTriggerLongPress == null)
            this.mTriggerLongPress = new TriggerLongPress(); 
          view.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
          return false;
        case 2:
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i >= 0 && !pointInView(view, paramMotionEvent.getX(i), paramMotionEvent.getY(i), this.mScaledTouchSlop)) {
            clearCallbacks();
            view.getParent().requestDisallowInterceptTouchEvent(true);
            return true;
          } 
          return false;
        case 1:
        case 3:
          break;
      } 
      clearCallbacks();
      return false;
    } 
    return false;
  }
  
  private static boolean pointInView(View paramView, float paramFloat1, float paramFloat2, float paramFloat3) {
    return (paramFloat1 >= -paramFloat3 && paramFloat2 >= -paramFloat3 && paramFloat1 < (paramView.getRight() - paramView.getLeft()) + paramFloat3 && paramFloat2 < (paramView.getBottom() - paramView.getTop()) + paramFloat3);
  }
  
  private boolean toGlobalMotionEvent(View paramView, MotionEvent paramMotionEvent) {
    int[] arrayOfInt = this.mTmpLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
    return true;
  }
  
  private boolean toLocalMotionEvent(View paramView, MotionEvent paramMotionEvent) {
    int[] arrayOfInt = this.mTmpLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
    return true;
  }
  
  public abstract ShowableListMenu getPopup();
  
  protected boolean onForwardingStarted() {
    ShowableListMenu showableListMenu = getPopup();
    if (showableListMenu != null && !showableListMenu.isShowing())
      showableListMenu.show(); 
    return true;
  }
  
  protected boolean onForwardingStopped() {
    ShowableListMenu showableListMenu = getPopup();
    if (showableListMenu != null && showableListMenu.isShowing())
      showableListMenu.dismiss(); 
    return true;
  }
  
  void onLongPress() {
    clearCallbacks();
    View view = this.mSrc;
    if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
      view.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      view.onTouchEvent(motionEvent);
      motionEvent.recycle();
      this.mForwarding = true;
      return;
    } 
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    boolean bool = false;
    boolean bool1 = this.mForwarding;
    if (bool1) {
      if (onTouchForwarded(paramMotionEvent) || !onForwardingStopped()) {
        null = true;
      } else {
        null = false;
      } 
    } else {
      boolean bool2;
      if (onTouchObserved(paramMotionEvent) && onForwardingStarted()) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      null = bool2;
      if (bool2) {
        long l = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.mSrc.onTouchEvent(motionEvent);
        motionEvent.recycle();
        null = bool2;
      } 
    } 
    this.mForwarding = null;
    if (!null) {
      null = bool;
      return bool1 ? true : null;
    } 
    return true;
  }
  
  private class DisallowIntercept implements Runnable {
    public void run() {
      ViewParent viewParent = ForwardingListener.this.mSrc.getParent();
      if (viewParent != null)
        viewParent.requestDisallowInterceptTouchEvent(true); 
    }
  }
  
  private class TriggerLongPress implements Runnable {
    public void run() {
      ForwardingListener.this.onLongPress();
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\ForwardingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */