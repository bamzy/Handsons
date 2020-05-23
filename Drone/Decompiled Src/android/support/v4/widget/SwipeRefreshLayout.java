package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
  private static final int ALPHA_ANIMATION_DURATION = 300;
  
  private static final int ANIMATE_TO_START_DURATION = 200;
  
  private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
  
  private static final int CIRCLE_BG_LIGHT = -328966;
  
  @VisibleForTesting
  static final int CIRCLE_DIAMETER = 40;
  
  @VisibleForTesting
  static final int CIRCLE_DIAMETER_LARGE = 56;
  
  private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0F;
  
  public static final int DEFAULT = 1;
  
  private static final int DEFAULT_CIRCLE_TARGET = 64;
  
  private static final float DRAG_RATE = 0.5F;
  
  private static final int INVALID_POINTER = -1;
  
  public static final int LARGE = 0;
  
  private static final int[] LAYOUT_ATTRS;
  
  private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
  
  private static final int MAX_ALPHA = 255;
  
  private static final float MAX_PROGRESS_ANGLE = 0.8F;
  
  private static final int SCALE_DOWN_DURATION = 150;
  
  private static final int STARTING_PROGRESS_ALPHA = 76;
  
  private int mActivePointerId = -1;
  
  private Animation mAlphaMaxAnimation;
  
  private Animation mAlphaStartAnimation;
  
  private final Animation mAnimateToCorrectPosition = new Animation() {
      public void applyTransformation(float param1Float, Transformation param1Transformation) {
        if (!SwipeRefreshLayout.this.mUsingCustomStart) {
          i = SwipeRefreshLayout.this.mSpinnerOffsetEnd - Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop);
        } else {
          i = SwipeRefreshLayout.this.mSpinnerOffsetEnd;
        } 
        int j = SwipeRefreshLayout.this.mFrom;
        int i = (int)((i - SwipeRefreshLayout.this.mFrom) * param1Float);
        int k = SwipeRefreshLayout.this.mCircleView.getTop();
        SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(j + i - k, false);
        SwipeRefreshLayout.this.mProgress.setArrowScale(1.0F - param1Float);
      }
    };
  
  private final Animation mAnimateToStartPosition = new Animation() {
      public void applyTransformation(float param1Float, Transformation param1Transformation) {
        SwipeRefreshLayout.this.moveToStart(param1Float);
      }
    };
  
  private OnChildScrollUpCallback mChildScrollUpCallback;
  
  private int mCircleDiameter;
  
  CircleImageView mCircleView;
  
  private int mCircleViewIndex = -1;
  
  int mCurrentTargetOffsetTop;
  
  private final DecelerateInterpolator mDecelerateInterpolator;
  
  protected int mFrom;
  
  private float mInitialDownY;
  
  private float mInitialMotionY;
  
  private boolean mIsBeingDragged;
  
  OnRefreshListener mListener;
  
  private int mMediumAnimationDuration;
  
  private boolean mNestedScrollInProgress;
  
  private final NestedScrollingChildHelper mNestedScrollingChildHelper;
  
  private final NestedScrollingParentHelper mNestedScrollingParentHelper;
  
  boolean mNotify;
  
  protected int mOriginalOffsetTop;
  
  private final int[] mParentOffsetInWindow = new int[2];
  
  private final int[] mParentScrollConsumed = new int[2];
  
  MaterialProgressDrawable mProgress;
  
  private Animation.AnimationListener mRefreshListener = new Animation.AnimationListener() {
      @SuppressLint({"NewApi"})
      public void onAnimationEnd(Animation param1Animation) {
        if (SwipeRefreshLayout.this.mRefreshing) {
          SwipeRefreshLayout.this.mProgress.setAlpha(255);
          SwipeRefreshLayout.this.mProgress.start();
          if (SwipeRefreshLayout.this.mNotify && SwipeRefreshLayout.this.mListener != null)
            SwipeRefreshLayout.this.mListener.onRefresh(); 
          SwipeRefreshLayout.this.mCurrentTargetOffsetTop = SwipeRefreshLayout.this.mCircleView.getTop();
          return;
        } 
        SwipeRefreshLayout.this.reset();
      }
      
      public void onAnimationRepeat(Animation param1Animation) {}
      
      public void onAnimationStart(Animation param1Animation) {}
    };
  
  boolean mRefreshing = false;
  
  private boolean mReturningToStart;
  
  boolean mScale;
  
  private Animation mScaleAnimation;
  
  private Animation mScaleDownAnimation;
  
  private Animation mScaleDownToStartAnimation;
  
  int mSpinnerOffsetEnd;
  
  float mStartingScale;
  
  private View mTarget;
  
  private float mTotalDragDistance = -1.0F;
  
  private float mTotalUnconsumed;
  
  private int mTouchSlop;
  
  boolean mUsingCustomStart;
  
  static {
    LAYOUT_ATTRS = new int[] { 16842766 };
  }
  
  public SwipeRefreshLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mMediumAnimationDuration = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.mDecelerateInterpolator = new DecelerateInterpolator(2.0F);
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    this.mCircleDiameter = (int)(40.0F * displayMetrics.density);
    createProgressView();
    ViewCompat.setChildrenDrawingOrderEnabled(this, true);
    this.mSpinnerOffsetEnd = (int)(64.0F * displayMetrics.density);
    this.mTotalDragDistance = this.mSpinnerOffsetEnd;
    this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    this.mNestedScrollingChildHelper = new NestedScrollingChildHelper((View)this);
    setNestedScrollingEnabled(true);
    int i = -this.mCircleDiameter;
    this.mCurrentTargetOffsetTop = i;
    this.mOriginalOffsetTop = i;
    moveToStart(1.0F);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(typedArray.getBoolean(0, true));
    typedArray.recycle();
  }
  
  private void animateOffsetToCorrectPosition(int paramInt, Animation.AnimationListener paramAnimationListener) {
    this.mFrom = paramInt;
    this.mAnimateToCorrectPosition.reset();
    this.mAnimateToCorrectPosition.setDuration(200L);
    this.mAnimateToCorrectPosition.setInterpolator((Interpolator)this.mDecelerateInterpolator);
    if (paramAnimationListener != null)
      this.mCircleView.setAnimationListener(paramAnimationListener); 
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
  }
  
  private void animateOffsetToStartPosition(int paramInt, Animation.AnimationListener paramAnimationListener) {
    if (this.mScale) {
      startScaleDownReturnToStartAnimation(paramInt, paramAnimationListener);
      return;
    } 
    this.mFrom = paramInt;
    this.mAnimateToStartPosition.reset();
    this.mAnimateToStartPosition.setDuration(200L);
    this.mAnimateToStartPosition.setInterpolator((Interpolator)this.mDecelerateInterpolator);
    if (paramAnimationListener != null)
      this.mCircleView.setAnimationListener(paramAnimationListener); 
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mAnimateToStartPosition);
  }
  
  private void createProgressView() {
    this.mCircleView = new CircleImageView(getContext(), -328966);
    this.mProgress = new MaterialProgressDrawable(getContext(), (View)this);
    this.mProgress.setBackgroundColor(-328966);
    this.mCircleView.setImageDrawable(this.mProgress);
    this.mCircleView.setVisibility(8);
    addView((View)this.mCircleView);
  }
  
  private void ensureTarget() {
    if (this.mTarget == null)
      for (int i = 0;; i++) {
        if (i < getChildCount()) {
          View view = getChildAt(i);
          if (!view.equals(this.mCircleView)) {
            this.mTarget = view;
            return;
          } 
        } else {
          return;
        } 
      }  
  }
  
  private void finishSpinner(float paramFloat) {
    if (paramFloat > this.mTotalDragDistance) {
      setRefreshing(true, true);
      return;
    } 
    this.mRefreshing = false;
    this.mProgress.setStartEndTrim(0.0F, 0.0F);
    Animation.AnimationListener animationListener = null;
    if (!this.mScale)
      animationListener = new Animation.AnimationListener() {
          public void onAnimationEnd(Animation param1Animation) {
            if (!SwipeRefreshLayout.this.mScale)
              SwipeRefreshLayout.this.startScaleDownAnimation((Animation.AnimationListener)null); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        }; 
    animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, animationListener);
    this.mProgress.showArrow(false);
  }
  
  private boolean isAlphaUsedForScale() {
    return (Build.VERSION.SDK_INT < 11);
  }
  
  private boolean isAnimationRunning(Animation paramAnimation) {
    return (paramAnimation != null && paramAnimation.hasStarted() && !paramAnimation.hasEnded());
  }
  
  @SuppressLint({"NewApi"})
  private void moveSpinner(float paramFloat) {
    float f1;
    this.mProgress.showArrow(true);
    float f2 = Math.min(1.0F, Math.abs(paramFloat / this.mTotalDragDistance));
    float f3 = (float)Math.max(f2 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.mTotalDragDistance;
    if (this.mUsingCustomStart) {
      f1 = (this.mSpinnerOffsetEnd - this.mOriginalOffsetTop);
    } else {
      f1 = this.mSpinnerOffsetEnd;
    } 
    f4 = Math.max(0.0F, Math.min(f4 - f5, 2.0F * f1) / f1);
    f4 = (float)((f4 / 4.0F) - Math.pow((f4 / 4.0F), 2.0D)) * 2.0F;
    int i = this.mOriginalOffsetTop;
    int j = (int)(f1 * f2 + f1 * f4 * 2.0F);
    if (this.mCircleView.getVisibility() != 0)
      this.mCircleView.setVisibility(0); 
    if (!this.mScale) {
      ViewCompat.setScaleX((View)this.mCircleView, 1.0F);
      ViewCompat.setScaleY((View)this.mCircleView, 1.0F);
    } 
    if (this.mScale)
      setAnimationProgress(Math.min(1.0F, paramFloat / this.mTotalDragDistance)); 
    if (paramFloat < this.mTotalDragDistance) {
      if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation))
        startProgressAlphaStartAnimation(); 
    } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
      startProgressAlphaMaxAnimation();
    } 
    this.mProgress.setStartEndTrim(0.0F, Math.min(0.8F, f3 * 0.8F));
    this.mProgress.setArrowScale(Math.min(1.0F, f3));
    this.mProgress.setProgressRotation((-0.25F + 0.4F * f3 + 2.0F * f4) * 0.5F);
    setTargetOffsetTopAndBottom(i + j - this.mCurrentTargetOffsetTop, true);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent) {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
    } 
  }
  
  @SuppressLint({"NewApi"})
  private void setColorViewAlpha(int paramInt) {
    this.mCircleView.getBackground().setAlpha(paramInt);
    this.mProgress.setAlpha(paramInt);
  }
  
  private void setRefreshing(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.mRefreshing != paramBoolean1) {
      this.mNotify = paramBoolean2;
      ensureTarget();
      this.mRefreshing = paramBoolean1;
      if (this.mRefreshing) {
        animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
        return;
      } 
    } else {
      return;
    } 
    startScaleDownAnimation(this.mRefreshListener);
  }
  
  @SuppressLint({"NewApi"})
  private Animation startAlphaAnimation(final int startingAlpha, final int endingAlpha) {
    if (this.mScale && isAlphaUsedForScale())
      return null; 
    Animation animation = new Animation() {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          SwipeRefreshLayout.this.mProgress.setAlpha((int)(startingAlpha + (endingAlpha - startingAlpha) * param1Float));
        }
      };
    animation.setDuration(300L);
    this.mCircleView.setAnimationListener((Animation.AnimationListener)null);
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(animation);
    return animation;
  }
  
  @SuppressLint({"NewApi"})
  private void startDragging(float paramFloat) {
    if (paramFloat - this.mInitialDownY > this.mTouchSlop && !this.mIsBeingDragged) {
      this.mInitialMotionY = this.mInitialDownY + this.mTouchSlop;
      this.mIsBeingDragged = true;
      this.mProgress.setAlpha(76);
    } 
  }
  
  @SuppressLint({"NewApi"})
  private void startProgressAlphaMaxAnimation() {
    this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
  }
  
  @SuppressLint({"NewApi"})
  private void startProgressAlphaStartAnimation() {
    this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
  }
  
  @SuppressLint({"NewApi"})
  private void startScaleDownReturnToStartAnimation(int paramInt, Animation.AnimationListener paramAnimationListener) {
    this.mFrom = paramInt;
    if (isAlphaUsedForScale()) {
      this.mStartingScale = this.mProgress.getAlpha();
    } else {
      this.mStartingScale = ViewCompat.getScaleX((View)this.mCircleView);
    } 
    this.mScaleDownToStartAnimation = new Animation() {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          float f1 = SwipeRefreshLayout.this.mStartingScale;
          float f2 = -SwipeRefreshLayout.this.mStartingScale;
          SwipeRefreshLayout.this.setAnimationProgress(f1 + f2 * param1Float);
          SwipeRefreshLayout.this.moveToStart(param1Float);
        }
      };
    this.mScaleDownToStartAnimation.setDuration(150L);
    if (paramAnimationListener != null)
      this.mCircleView.setAnimationListener(paramAnimationListener); 
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
  }
  
  @SuppressLint({"NewApi"})
  private void startScaleUpAnimation(Animation.AnimationListener paramAnimationListener) {
    this.mCircleView.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 11)
      this.mProgress.setAlpha(255); 
    this.mScaleAnimation = new Animation() {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          SwipeRefreshLayout.this.setAnimationProgress(param1Float);
        }
      };
    this.mScaleAnimation.setDuration(this.mMediumAnimationDuration);
    if (paramAnimationListener != null)
      this.mCircleView.setAnimationListener(paramAnimationListener); 
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleAnimation);
  }
  
  public boolean canChildScrollUp() {
    boolean bool1 = true;
    boolean bool = false;
    if (this.mChildScrollUpCallback != null)
      return this.mChildScrollUpCallback.canChildScrollUp(this, this.mTarget); 
    if (Build.VERSION.SDK_INT < 14) {
      if (this.mTarget instanceof AbsListView) {
        AbsListView absListView = (AbsListView)this.mTarget;
        if (absListView.getChildCount() > 0) {
          bool = bool1;
          if (absListView.getFirstVisiblePosition() <= 0) {
            bool = bool1;
            if (absListView.getChildAt(0).getTop() >= absListView.getPaddingTop())
              return false; 
          } 
          return bool;
        } 
        return false;
      } 
      if (ViewCompat.canScrollVertically(this.mTarget, -1) || this.mTarget.getScrollY() > 0)
        bool = true; 
      return bool;
    } 
    return ViewCompat.canScrollVertically(this.mTarget, -1);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return this.mNestedScrollingChildHelper.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2) {
    return this.mNestedScrollingChildHelper.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return this.mNestedScrollingChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    if (this.mCircleViewIndex >= 0) {
      if (paramInt2 == paramInt1 - 1)
        return this.mCircleViewIndex; 
      if (paramInt2 >= this.mCircleViewIndex)
        return paramInt2 + 1; 
    } 
    return paramInt2;
  }
  
  public int getNestedScrollAxes() {
    return this.mNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  public int getProgressCircleDiameter() {
    return this.mCircleDiameter;
  }
  
  public int getProgressViewEndOffset() {
    return this.mSpinnerOffsetEnd;
  }
  
  public int getProgressViewStartOffset() {
    return this.mOriginalOffsetTop;
  }
  
  public boolean hasNestedScrollingParent() {
    return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled() {
    return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
  }
  
  public boolean isRefreshing() {
    return this.mRefreshing;
  }
  
  void moveToStart(float paramFloat) {
    setTargetOffsetTopAndBottom(this.mFrom + (int)((this.mOriginalOffsetTop - this.mFrom) * paramFloat) - this.mCircleView.getTop(), false);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    ensureTarget();
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (this.mReturningToStart && i == 0)
      this.mReturningToStart = false; 
    if (isEnabled() && !this.mReturningToStart && !canChildScrollUp() && !this.mRefreshing && !this.mNestedScrollInProgress) {
      switch (i) {
        default:
          return this.mIsBeingDragged;
        case 0:
          setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mIsBeingDragged = false;
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i >= 0)
            this.mInitialDownY = paramMotionEvent.getY(i); 
          return false;
        case 2:
          if (this.mActivePointerId == -1) {
            Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
            return false;
          } 
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i >= 0)
            startDragging(paramMotionEvent.getY(i)); 
          return false;
        case 6:
          onSecondaryPointerUp(paramMotionEvent);
        case 1:
        case 3:
          break;
      } 
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
    } 
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() != 0) {
      if (this.mTarget == null)
        ensureTarget(); 
      if (this.mTarget != null) {
        View view = this.mTarget;
        paramInt3 = getPaddingLeft();
        paramInt4 = getPaddingTop();
        view.layout(paramInt3, paramInt4, paramInt3 + paramInt1 - getPaddingLeft() - getPaddingRight(), paramInt4 + paramInt2 - getPaddingTop() - getPaddingBottom());
        paramInt2 = this.mCircleView.getMeasuredWidth();
        paramInt3 = this.mCircleView.getMeasuredHeight();
        this.mCircleView.layout(paramInt1 / 2 - paramInt2 / 2, this.mCurrentTargetOffsetTop, paramInt1 / 2 + paramInt2 / 2, this.mCurrentTargetOffsetTop + paramInt3);
        return;
      } 
    } 
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mTarget == null)
      ensureTarget(); 
    if (this.mTarget != null) {
      this.mTarget.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
      this.mCircleViewIndex = -1;
      paramInt1 = 0;
      while (true) {
        if (paramInt1 < getChildCount()) {
          if (getChildAt(paramInt1) == this.mCircleView) {
            this.mCircleViewIndex = paramInt1;
            return;
          } 
          paramInt1++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    if (paramInt2 > 0 && this.mTotalUnconsumed > 0.0F) {
      if (paramInt2 > this.mTotalUnconsumed) {
        paramArrayOfint[1] = paramInt2 - (int)this.mTotalUnconsumed;
        this.mTotalUnconsumed = 0.0F;
      } else {
        this.mTotalUnconsumed -= paramInt2;
        paramArrayOfint[1] = paramInt2;
      } 
      moveSpinner(this.mTotalUnconsumed);
    } 
    if (this.mUsingCustomStart && paramInt2 > 0 && this.mTotalUnconsumed == 0.0F && Math.abs(paramInt2 - paramArrayOfint[1]) > 0)
      this.mCircleView.setVisibility(8); 
    int[] arrayOfInt = this.mParentScrollConsumed;
    if (dispatchNestedPreScroll(paramInt1 - paramArrayOfint[0], paramInt2 - paramArrayOfint[1], arrayOfInt, (int[])null)) {
      paramArrayOfint[0] = paramArrayOfint[0] + arrayOfInt[0];
      paramArrayOfint[1] = paramArrayOfint[1] + arrayOfInt[1];
    } 
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mParentOffsetInWindow);
    paramInt1 = paramInt4 + this.mParentOffsetInWindow[1];
    if (paramInt1 < 0 && !canChildScrollUp()) {
      this.mTotalUnconsumed += Math.abs(paramInt1);
      moveSpinner(this.mTotalUnconsumed);
    } 
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    this.mNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    startNestedScroll(paramInt & 0x2);
    this.mTotalUnconsumed = 0.0F;
    this.mNestedScrollInProgress = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) {
    return (isEnabled() && !this.mReturningToStart && !this.mRefreshing && (paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView) {
    this.mNestedScrollingParentHelper.onStopNestedScroll(paramView);
    this.mNestedScrollInProgress = false;
    if (this.mTotalUnconsumed > 0.0F) {
      finishSpinner(this.mTotalUnconsumed);
      this.mTotalUnconsumed = 0.0F;
    } 
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    float f;
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (this.mReturningToStart && i == 0)
      this.mReturningToStart = false; 
    if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress);
    switch (i) {
      case 3:
        return false;
      default:
        return true;
      case 0:
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mIsBeingDragged = false;
      case 2:
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i < 0) {
          Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
          return false;
        } 
        f = paramMotionEvent.getY(i);
        startDragging(f);
        if (this.mIsBeingDragged) {
          f = (f - this.mInitialMotionY) * 0.5F;
          if (f > 0.0F)
            moveSpinner(f); 
        } 
      case 5:
        i = MotionEventCompat.getActionIndex(paramMotionEvent);
        if (i < 0) {
          Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
          return false;
        } 
        this.mActivePointerId = paramMotionEvent.getPointerId(i);
      case 6:
        onSecondaryPointerUp(paramMotionEvent);
      case 1:
        break;
    } 
    i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
    if (i < 0) {
      Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
      return false;
    } 
    if (this.mIsBeingDragged) {
      f = paramMotionEvent.getY(i);
      float f1 = this.mInitialMotionY;
      this.mIsBeingDragged = false;
      finishSpinner((f - f1) * 0.5F);
    } 
    this.mActivePointerId = -1;
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    if ((Build.VERSION.SDK_INT < 21 && this.mTarget instanceof AbsListView) || (this.mTarget != null && !ViewCompat.isNestedScrollingEnabled(this.mTarget)))
      return; 
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  void reset() {
    this.mCircleView.clearAnimation();
    this.mProgress.stop();
    this.mCircleView.setVisibility(8);
    setColorViewAlpha(255);
    if (this.mScale) {
      setAnimationProgress(0.0F);
    } else {
      setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop, true);
    } 
    this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
  }
  
  void setAnimationProgress(float paramFloat) {
    if (isAlphaUsedForScale()) {
      setColorViewAlpha((int)(255.0F * paramFloat));
      return;
    } 
    ViewCompat.setScaleX((View)this.mCircleView, paramFloat);
    ViewCompat.setScaleY((View)this.mCircleView, paramFloat);
  }
  
  @Deprecated
  public void setColorScheme(@ColorInt int... paramVarArgs) {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(@ColorInt int... paramVarArgs) {
    ensureTarget();
    this.mProgress.setColorSchemeColors(paramVarArgs);
  }
  
  public void setColorSchemeResources(@ColorRes int... paramVarArgs) {
    Context context = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++)
      arrayOfInt[i] = ContextCompat.getColor(context, paramVarArgs[i]); 
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt) {
    this.mTotalDragDistance = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean) {
    super.setEnabled(paramBoolean);
    if (!paramBoolean)
      reset(); 
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) {
    this.mNestedScrollingChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback paramOnChildScrollUpCallback) {
    this.mChildScrollUpCallback = paramOnChildScrollUpCallback;
  }
  
  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener) {
    this.mListener = paramOnRefreshListener;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt) {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(@ColorInt int paramInt) {
    this.mCircleView.setBackgroundColor(paramInt);
    this.mProgress.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(@ColorRes int paramInt) {
    setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setProgressViewEndTarget(boolean paramBoolean, int paramInt) {
    this.mSpinnerOffsetEnd = paramInt;
    this.mScale = paramBoolean;
    this.mCircleView.invalidate();
  }
  
  public void setProgressViewOffset(boolean paramBoolean, int paramInt1, int paramInt2) {
    this.mScale = paramBoolean;
    this.mOriginalOffsetTop = paramInt1;
    this.mSpinnerOffsetEnd = paramInt2;
    this.mUsingCustomStart = true;
    reset();
    this.mRefreshing = false;
  }
  
  public void setRefreshing(boolean paramBoolean) {
    if (paramBoolean && this.mRefreshing != paramBoolean) {
      int i;
      this.mRefreshing = paramBoolean;
      if (!this.mUsingCustomStart) {
        i = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
      } else {
        i = this.mSpinnerOffsetEnd;
      } 
      setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop, true);
      this.mNotify = false;
      startScaleUpAnimation(this.mRefreshListener);
      return;
    } 
    setRefreshing(paramBoolean, false);
  }
  
  public void setSize(int paramInt) {
    if (paramInt != 0 && paramInt != 1)
      return; 
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    if (paramInt == 0) {
      this.mCircleDiameter = (int)(56.0F * displayMetrics.density);
    } else {
      this.mCircleDiameter = (int)(40.0F * displayMetrics.density);
    } 
    this.mCircleView.setImageDrawable(null);
    this.mProgress.updateSizes(paramInt);
    this.mCircleView.setImageDrawable(this.mProgress);
  }
  
  void setTargetOffsetTopAndBottom(int paramInt, boolean paramBoolean) {
    this.mCircleView.bringToFront();
    ViewCompat.offsetTopAndBottom((View)this.mCircleView, paramInt);
    this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    if (paramBoolean && Build.VERSION.SDK_INT < 11)
      invalidate(); 
  }
  
  public boolean startNestedScroll(int paramInt) {
    return this.mNestedScrollingChildHelper.startNestedScroll(paramInt);
  }
  
  void startScaleDownAnimation(Animation.AnimationListener paramAnimationListener) {
    this.mScaleDownAnimation = new Animation() {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          SwipeRefreshLayout.this.setAnimationProgress(1.0F - param1Float);
        }
      };
    this.mScaleDownAnimation.setDuration(150L);
    this.mCircleView.setAnimationListener(paramAnimationListener);
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleDownAnimation);
  }
  
  public void stopNestedScroll() {
    this.mNestedScrollingChildHelper.stopNestedScroll();
  }
  
  public static interface OnChildScrollUpCallback {
    boolean canChildScrollUp(SwipeRefreshLayout param1SwipeRefreshLayout, @Nullable View param1View);
  }
  
  public static interface OnRefreshListener {
    void onRefresh();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\SwipeRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */