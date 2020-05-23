package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ActionBarContainer extends FrameLayout {
  private View mActionBarView;
  
  Drawable mBackground;
  
  private View mContextView;
  
  private int mHeight;
  
  boolean mIsSplit;
  
  boolean mIsStacked;
  
  private boolean mIsTransitioning;
  
  Drawable mSplitBackground;
  
  Drawable mStackedBackground;
  
  private View mTabContainer;
  
  public ActionBarContainer(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    ActionBarBackgroundDrawable actionBarBackgroundDrawable;
    if (Build.VERSION.SDK_INT >= 21) {
      actionBarBackgroundDrawable = new ActionBarBackgroundDrawableV21(this);
    } else {
      actionBarBackgroundDrawable = new ActionBarBackgroundDrawable(this);
    } 
    ViewCompat.setBackground((View)this, actionBarBackgroundDrawable);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar);
    this.mBackground = typedArray.getDrawable(R.styleable.ActionBar_background);
    this.mStackedBackground = typedArray.getDrawable(R.styleable.ActionBar_backgroundStacked);
    this.mHeight = typedArray.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
    if (getId() == R.id.split_action_bar) {
      this.mIsSplit = true;
      this.mSplitBackground = typedArray.getDrawable(R.styleable.ActionBar_backgroundSplit);
    } 
    typedArray.recycle();
    if (this.mIsSplit) {
      if (this.mSplitBackground != null)
        bool = false; 
    } else if (this.mBackground != null || this.mStackedBackground != null) {
      bool = false;
    } 
    setWillNotDraw(bool);
  }
  
  private int getMeasuredHeightWithMargins(View paramView) {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    return paramView.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
  }
  
  private boolean isCollapsed(View paramView) {
    return (paramView == null || paramView.getVisibility() == 8 || paramView.getMeasuredHeight() == 0);
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    if (this.mBackground != null && this.mBackground.isStateful())
      this.mBackground.setState(getDrawableState()); 
    if (this.mStackedBackground != null && this.mStackedBackground.isStateful())
      this.mStackedBackground.setState(getDrawableState()); 
    if (this.mSplitBackground != null && this.mSplitBackground.isStateful())
      this.mSplitBackground.setState(getDrawableState()); 
  }
  
  public View getTabContainer() {
    return this.mTabContainer;
  }
  
  public void jumpDrawablesToCurrentState() {
    if (Build.VERSION.SDK_INT >= 11) {
      super.jumpDrawablesToCurrentState();
      if (this.mBackground != null)
        this.mBackground.jumpToCurrentState(); 
      if (this.mStackedBackground != null)
        this.mStackedBackground.jumpToCurrentState(); 
      if (this.mSplitBackground != null)
        this.mSplitBackground.jumpToCurrentState(); 
    } 
  }
  
  public void onFinishInflate() {
    super.onFinishInflate();
    this.mActionBarView = findViewById(R.id.action_bar);
    this.mContextView = findViewById(R.id.action_context_bar);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    return (this.mIsTransitioning || super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View view = this.mTabContainer;
    if (view != null && view.getVisibility() != 8) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    if (view != null && view.getVisibility() != 8) {
      paramInt2 = getMeasuredHeight();
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
      view.layout(paramInt1, paramInt2 - view.getMeasuredHeight() - layoutParams.bottomMargin, paramInt3, paramInt2 - layoutParams.bottomMargin);
    } 
    paramInt2 = 0;
    paramInt1 = 0;
    if (this.mIsSplit) {
      if (this.mSplitBackground != null) {
        this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        paramInt1 = 1;
      } 
    } else {
      if (this.mBackground != null) {
        if (this.mActionBarView.getVisibility() == 0) {
          this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
        } else if (this.mContextView != null && this.mContextView.getVisibility() == 0) {
          this.mBackground.setBounds(this.mContextView.getLeft(), this.mContextView.getTop(), this.mContextView.getRight(), this.mContextView.getBottom());
        } else {
          this.mBackground.setBounds(0, 0, 0, 0);
        } 
        paramInt2 = 1;
      } 
      this.mIsStacked = paramBoolean;
      paramInt1 = paramInt2;
      if (paramBoolean) {
        paramInt1 = paramInt2;
        if (this.mStackedBackground != null) {
          this.mStackedBackground.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
          paramInt1 = 1;
        } 
      } 
    } 
    if (paramInt1 != 0)
      invalidate(); 
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    int i = paramInt2;
    if (this.mActionBarView == null) {
      i = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE) {
        i = paramInt2;
        if (this.mHeight >= 0)
          i = View.MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, View.MeasureSpec.getSize(paramInt2)), -2147483648); 
      } 
    } 
    super.onMeasure(paramInt1, i);
    if (this.mActionBarView != null) {
      paramInt2 = View.MeasureSpec.getMode(i);
      if (this.mTabContainer != null && this.mTabContainer.getVisibility() != 8 && paramInt2 != 1073741824) {
        if (!isCollapsed(this.mActionBarView)) {
          paramInt1 = getMeasuredHeightWithMargins(this.mActionBarView);
        } else if (!isCollapsed(this.mContextView)) {
          paramInt1 = getMeasuredHeightWithMargins(this.mContextView);
        } else {
          paramInt1 = 0;
        } 
        if (paramInt2 == Integer.MIN_VALUE) {
          paramInt2 = View.MeasureSpec.getSize(i);
        } else {
          paramInt2 = Integer.MAX_VALUE;
        } 
        setMeasuredDimension(getMeasuredWidth(), Math.min(getMeasuredHeightWithMargins(this.mTabContainer) + paramInt1, paramInt2));
        return;
      } 
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable) {
    boolean bool = true;
    if (this.mBackground != null) {
      this.mBackground.setCallback(null);
      unscheduleDrawable(this.mBackground);
    } 
    this.mBackground = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback((Drawable.Callback)this);
      if (this.mActionBarView != null)
        this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom()); 
    } 
    if (this.mIsSplit) {
      if (this.mSplitBackground != null)
        bool = false; 
    } else if (this.mBackground != null || this.mStackedBackground != null) {
      bool = false;
    } 
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setSplitBackground(Drawable paramDrawable) {
    boolean bool = true;
    if (this.mSplitBackground != null) {
      this.mSplitBackground.setCallback(null);
      unscheduleDrawable(this.mSplitBackground);
    } 
    this.mSplitBackground = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback((Drawable.Callback)this);
      if (this.mIsSplit && this.mSplitBackground != null)
        this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight()); 
    } 
    if (this.mIsSplit) {
      if (this.mSplitBackground != null)
        bool = false; 
    } else if (this.mBackground != null || this.mStackedBackground != null) {
      bool = false;
    } 
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setStackedBackground(Drawable paramDrawable) {
    boolean bool = true;
    if (this.mStackedBackground != null) {
      this.mStackedBackground.setCallback(null);
      unscheduleDrawable(this.mStackedBackground);
    } 
    this.mStackedBackground = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback((Drawable.Callback)this);
      if (this.mIsStacked && this.mStackedBackground != null)
        this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom()); 
    } 
    if (this.mIsSplit) {
      if (this.mSplitBackground != null)
        bool = false; 
    } else if (this.mBackground != null || this.mStackedBackground != null) {
      bool = false;
    } 
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setTabContainer(ScrollingTabContainerView paramScrollingTabContainerView) {
    if (this.mTabContainer != null)
      removeView(this.mTabContainer); 
    this.mTabContainer = (View)paramScrollingTabContainerView;
    if (paramScrollingTabContainerView != null) {
      addView((View)paramScrollingTabContainerView);
      ViewGroup.LayoutParams layoutParams = paramScrollingTabContainerView.getLayoutParams();
      layoutParams.width = -1;
      layoutParams.height = -2;
      paramScrollingTabContainerView.setAllowCollapse(false);
    } 
  }
  
  public void setTransitioning(boolean paramBoolean) {
    int i;
    this.mIsTransitioning = paramBoolean;
    if (paramBoolean) {
      i = 393216;
    } else {
      i = 262144;
    } 
    setDescendantFocusability(i);
  }
  
  public void setVisibility(int paramInt) {
    boolean bool;
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (this.mBackground != null)
      this.mBackground.setVisible(bool, false); 
    if (this.mStackedBackground != null)
      this.mStackedBackground.setVisible(bool, false); 
    if (this.mSplitBackground != null)
      this.mSplitBackground.setVisible(bool, false); 
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback) {
    return null;
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt) {
    return (paramInt != 0) ? super.startActionModeForChild(paramView, paramCallback, paramInt) : null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) {
    return ((paramDrawable == this.mBackground && !this.mIsSplit) || (paramDrawable == this.mStackedBackground && this.mIsStacked) || (paramDrawable == this.mSplitBackground && this.mIsSplit) || super.verifyDrawable(paramDrawable));
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\ActionBarContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */