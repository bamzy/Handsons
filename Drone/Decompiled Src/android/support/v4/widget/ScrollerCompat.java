package android.support.v4.widget;

import android.content.Context;
import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

public final class ScrollerCompat {
  private final boolean mIsIcsOrNewer;
  
  OverScroller mScroller;
  
  ScrollerCompat(boolean paramBoolean, Context paramContext, Interpolator paramInterpolator) {
    OverScroller overScroller;
    this.mIsIcsOrNewer = paramBoolean;
    if (paramInterpolator != null) {
      overScroller = new OverScroller(paramContext, paramInterpolator);
    } else {
      overScroller = new OverScroller((Context)overScroller);
    } 
    this.mScroller = overScroller;
  }
  
  public static ScrollerCompat create(Context paramContext) {
    return create(paramContext, null);
  }
  
  public static ScrollerCompat create(Context paramContext, Interpolator paramInterpolator) {
    if (Build.VERSION.SDK_INT >= 14) {
      boolean bool1 = true;
      return new ScrollerCompat(bool1, paramContext, paramInterpolator);
    } 
    boolean bool = false;
    return new ScrollerCompat(bool, paramContext, paramInterpolator);
  }
  
  public void abortAnimation() {
    this.mScroller.abortAnimation();
  }
  
  public boolean computeScrollOffset() {
    return this.mScroller.computeScrollOffset();
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    this.mScroller.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
    this.mScroller.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public float getCurrVelocity() {
    return this.mIsIcsOrNewer ? ScrollerCompatIcs.getCurrVelocity(this.mScroller) : 0.0F;
  }
  
  public int getCurrX() {
    return this.mScroller.getCurrX();
  }
  
  public int getCurrY() {
    return this.mScroller.getCurrY();
  }
  
  public int getFinalX() {
    return this.mScroller.getFinalX();
  }
  
  public int getFinalY() {
    return this.mScroller.getFinalY();
  }
  
  public boolean isFinished() {
    return this.mScroller.isFinished();
  }
  
  public boolean isOverScrolled() {
    return this.mScroller.isOverScrolled();
  }
  
  public void notifyHorizontalEdgeReached(int paramInt1, int paramInt2, int paramInt3) {
    this.mScroller.notifyHorizontalEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  public void notifyVerticalEdgeReached(int paramInt1, int paramInt2, int paramInt3) {
    this.mScroller.notifyVerticalEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean springBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    return this.mScroller.springBack(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mScroller.startScroll(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    this.mScroller.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\ScrollerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */