package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
  private static final int DEFAULT_FADE_COLOR = -858993460;
  
  private static final int DEFAULT_OVERHANG_SIZE = 32;
  
  static final SlidingPanelLayoutImpl IMPL = new SlidingPanelLayoutImplBase();
  
  private static final int MIN_FLING_VELOCITY = 400;
  
  private static final String TAG = "SlidingPaneLayout";
  
  private boolean mCanSlide;
  
  private int mCoveredFadeColor;
  
  final ViewDragHelper mDragHelper;
  
  private boolean mFirstLayout = true;
  
  private float mInitialMotionX;
  
  private float mInitialMotionY;
  
  boolean mIsUnableToDrag;
  
  private final int mOverhangSize;
  
  private PanelSlideListener mPanelSlideListener;
  
  private int mParallaxBy;
  
  private float mParallaxOffset;
  
  final ArrayList<DisableLayerRunnable> mPostedRunnables = new ArrayList<DisableLayerRunnable>();
  
  boolean mPreservedOpenState;
  
  private Drawable mShadowDrawableLeft;
  
  private Drawable mShadowDrawableRight;
  
  float mSlideOffset;
  
  int mSlideRange;
  
  View mSlideableView;
  
  private int mSliderFadeColor = -858993460;
  
  private final Rect mTmpRect = new Rect();
  
  public SlidingPaneLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    float f = (paramContext.getResources().getDisplayMetrics()).density;
    this.mOverhangSize = (int)(32.0F * f + 0.5F);
    ViewConfiguration.get(paramContext);
    setWillNotDraw(false);
    ViewCompat.setAccessibilityDelegate((View)this, new AccessibilityDelegate());
    ViewCompat.setImportantForAccessibility((View)this, 1);
    this.mDragHelper = ViewDragHelper.create(this, 0.5F, new DragHelperCallback());
    this.mDragHelper.setMinVelocity(400.0F * f);
  }
  
  private boolean closePane(View paramView, int paramInt) {
    boolean bool = false;
    if (this.mFirstLayout || smoothSlideTo(0.0F, paramInt)) {
      this.mPreservedOpenState = false;
      bool = true;
    } 
    return bool;
  }
  
  private void dimChildView(View paramView, float paramFloat, int paramInt) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat > 0.0F && paramInt != 0) {
      int i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (layoutParams.dimPaint == null)
        layoutParams.dimPaint = new Paint(); 
      layoutParams.dimPaint.setColorFilter((ColorFilter)new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (ViewCompat.getLayerType(paramView) != 2)
        ViewCompat.setLayerType(paramView, 2, layoutParams.dimPaint); 
      invalidateChildRegion(paramView);
      return;
    } 
    if (ViewCompat.getLayerType(paramView) != 0) {
      if (layoutParams.dimPaint != null)
        layoutParams.dimPaint.setColorFilter(null); 
      DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(paramView);
      this.mPostedRunnables.add(disableLayerRunnable);
      ViewCompat.postOnAnimation((View)this, disableLayerRunnable);
      return;
    } 
  }
  
  private boolean openPane(View paramView, int paramInt) {
    if (this.mFirstLayout || smoothSlideTo(1.0F, paramInt)) {
      this.mPreservedOpenState = true;
      return true;
    } 
    return false;
  }
  
  private void parallaxOtherViews(float paramFloat) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual isLayoutRtlSupport : ()Z
    //   4: istore #8
    //   6: aload_0
    //   7: getfield mSlideableView : Landroid/view/View;
    //   10: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   13: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
    //   16: astore #9
    //   18: aload #9
    //   20: getfield dimWhenOffset : Z
    //   23: ifeq -> 94
    //   26: iload #8
    //   28: ifeq -> 85
    //   31: aload #9
    //   33: getfield rightMargin : I
    //   36: istore_3
    //   37: iload_3
    //   38: ifgt -> 94
    //   41: iconst_1
    //   42: istore_3
    //   43: aload_0
    //   44: invokevirtual getChildCount : ()I
    //   47: istore #7
    //   49: iconst_0
    //   50: istore #4
    //   52: iload #4
    //   54: iload #7
    //   56: if_icmpge -> 195
    //   59: aload_0
    //   60: iload #4
    //   62: invokevirtual getChildAt : (I)Landroid/view/View;
    //   65: astore #9
    //   67: aload #9
    //   69: aload_0
    //   70: getfield mSlideableView : Landroid/view/View;
    //   73: if_acmpne -> 99
    //   76: iload #4
    //   78: iconst_1
    //   79: iadd
    //   80: istore #4
    //   82: goto -> 52
    //   85: aload #9
    //   87: getfield leftMargin : I
    //   90: istore_3
    //   91: goto -> 37
    //   94: iconst_0
    //   95: istore_3
    //   96: goto -> 43
    //   99: fconst_1
    //   100: aload_0
    //   101: getfield mParallaxOffset : F
    //   104: fsub
    //   105: aload_0
    //   106: getfield mParallaxBy : I
    //   109: i2f
    //   110: fmul
    //   111: f2i
    //   112: istore #5
    //   114: aload_0
    //   115: fload_1
    //   116: putfield mParallaxOffset : F
    //   119: iload #5
    //   121: fconst_1
    //   122: fload_1
    //   123: fsub
    //   124: aload_0
    //   125: getfield mParallaxBy : I
    //   128: i2f
    //   129: fmul
    //   130: f2i
    //   131: isub
    //   132: istore #6
    //   134: iload #6
    //   136: istore #5
    //   138: iload #8
    //   140: ifeq -> 148
    //   143: iload #6
    //   145: ineg
    //   146: istore #5
    //   148: aload #9
    //   150: iload #5
    //   152: invokevirtual offsetLeftAndRight : (I)V
    //   155: iload_3
    //   156: ifeq -> 76
    //   159: iload #8
    //   161: ifeq -> 185
    //   164: aload_0
    //   165: getfield mParallaxOffset : F
    //   168: fconst_1
    //   169: fsub
    //   170: fstore_2
    //   171: aload_0
    //   172: aload #9
    //   174: fload_2
    //   175: aload_0
    //   176: getfield mCoveredFadeColor : I
    //   179: invokespecial dimChildView : (Landroid/view/View;FI)V
    //   182: goto -> 76
    //   185: fconst_1
    //   186: aload_0
    //   187: getfield mParallaxOffset : F
    //   190: fsub
    //   191: fstore_2
    //   192: goto -> 171
    //   195: return
  }
  
  private static boolean viewIsOpaque(View paramView) {
    if (!paramView.isOpaque()) {
      if (Build.VERSION.SDK_INT >= 18)
        return false; 
      Drawable drawable = paramView.getBackground();
      return (drawable != null) ? (!(drawable.getOpacity() != -1)) : false;
    } 
    return true;
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i;
      for (i = viewGroup.getChildCount() - 1; i >= 0; i--) {
        View view = viewGroup.getChildAt(i);
        if (paramInt2 + j >= view.getLeft() && paramInt2 + j < view.getRight() && paramInt3 + k >= view.getTop() && paramInt3 + k < view.getBottom() && canScroll(view, true, paramInt1, paramInt2 + j - view.getLeft(), paramInt3 + k - view.getTop()))
          return true; 
      } 
    } 
    if (paramBoolean) {
      if (!isLayoutRtlSupport())
        paramInt1 = -paramInt1; 
      if (ViewCompat.canScrollHorizontally(paramView, paramInt1))
        return true; 
    } 
    return false;
  }
  
  @Deprecated
  public boolean canSlide() {
    return this.mCanSlide;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams && super.checkLayoutParams(paramLayoutParams));
  }
  
  public boolean closePane() {
    return closePane(this.mSlideableView, 0);
  }
  
  public void computeScroll() {
    if (this.mDragHelper.continueSettling(true)) {
      if (!this.mCanSlide) {
        this.mDragHelper.abort();
        return;
      } 
    } else {
      return;
    } 
    ViewCompat.postInvalidateOnAnimation((View)this);
  }
  
  void dispatchOnPanelClosed(View paramView) {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelClosed(paramView); 
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelOpened(View paramView) {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelOpened(paramView); 
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelSlide(View paramView) {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelSlide(paramView, this.mSlideOffset); 
  }
  
  public void draw(Canvas paramCanvas) {
    int i;
    int j;
    Drawable drawable;
    View view;
    super.draw(paramCanvas);
    if (isLayoutRtlSupport()) {
      drawable = this.mShadowDrawableRight;
    } else {
      drawable = this.mShadowDrawableLeft;
    } 
    if (getChildCount() > 1) {
      view = getChildAt(1);
    } else {
      view = null;
    } 
    if (view == null || drawable == null)
      return; 
    int k = view.getTop();
    int m = view.getBottom();
    int n = drawable.getIntrinsicWidth();
    if (isLayoutRtlSupport()) {
      i = view.getRight();
      j = i + n;
    } else {
      j = view.getLeft();
      i = j - n;
    } 
    drawable.setBounds(i, k, j, m);
    drawable.draw(paramCanvas);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save(2);
    if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
      paramCanvas.getClipBounds(this.mTmpRect);
      if (isLayoutRtlSupport()) {
        this.mTmpRect.left = Math.max(this.mTmpRect.left, this.mSlideableView.getRight());
      } else {
        this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
      } 
      paramCanvas.clipRect(this.mTmpRect);
    } 
    if (Build.VERSION.SDK_INT >= 11) {
      boolean bool1 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      return bool1;
    } 
    if (layoutParams.dimWhenOffset && this.mSlideOffset > 0.0F) {
      if (!paramView.isDrawingCacheEnabled())
        paramView.setDrawingCacheEnabled(true); 
      Bitmap bitmap = paramView.getDrawingCache();
      if (bitmap != null) {
        paramCanvas.drawBitmap(bitmap, paramView.getLeft(), paramView.getTop(), layoutParams.dimPaint);
        boolean bool2 = false;
        paramCanvas.restoreToCount(i);
        return bool2;
      } 
      Log.e("SlidingPaneLayout", "drawChild: child view " + paramView + " returned null drawing cache");
      boolean bool1 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      return bool1;
    } 
    if (paramView.isDrawingCacheEnabled())
      paramView.setDrawingCacheEnabled(false); 
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i);
    return bool;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return (ViewGroup.LayoutParams)new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return (ViewGroup.LayoutParams)new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams));
  }
  
  @ColorInt
  public int getCoveredFadeColor() {
    return this.mCoveredFadeColor;
  }
  
  public int getParallaxDistance() {
    return this.mParallaxBy;
  }
  
  @ColorInt
  public int getSliderFadeColor() {
    return this.mSliderFadeColor;
  }
  
  void invalidateChildRegion(View paramView) {
    IMPL.invalidateChildRegion(this, paramView);
  }
  
  boolean isDimmed(View paramView) {
    if (paramView != null) {
      LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
      if (this.mCanSlide && layoutParams.dimWhenOffset && this.mSlideOffset > 0.0F)
        return true; 
    } 
    return false;
  }
  
  boolean isLayoutRtlSupport() {
    return (ViewCompat.getLayoutDirection((View)this) == 1);
  }
  
  public boolean isOpen() {
    return (!this.mCanSlide || this.mSlideOffset == 1.0F);
  }
  
  public boolean isSlideable() {
    return this.mCanSlide;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    int i = 0;
    int j = this.mPostedRunnables.size();
    while (i < j) {
      ((DisableLayerRunnable)this.mPostedRunnables.get(i)).run();
      i++;
    } 
    this.mPostedRunnables.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (!this.mCanSlide && i == 0 && getChildCount() > 1) {
      View view = getChildAt(1);
      if (view != null) {
        boolean bool;
        if (!this.mDragHelper.isViewUnder(view, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          bool = true;
        } else {
          bool = false;
        } 
        this.mPreservedOpenState = bool;
      } 
    } 
    if (!this.mCanSlide || (this.mIsUnableToDrag && i != 0)) {
      this.mDragHelper.cancel();
      return super.onInterceptTouchEvent(paramMotionEvent);
    } 
    if (i == 3 || i == 1) {
      this.mDragHelper.cancel();
      return false;
    } 
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (i) {
      default:
        bool1 = bool2;
      case 1:
        return (this.mDragHelper.shouldInterceptTouchEvent(paramMotionEvent) || bool1);
      case 0:
        this.mIsUnableToDrag = false;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.mInitialMotionX = f1;
        this.mInitialMotionY = f2;
        bool1 = bool2;
        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int)f1, (int)f2)) {
          bool1 = bool2;
          if (isDimmed(this.mSlideableView))
            bool1 = true; 
        } 
      case 2:
        break;
    } 
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    f2 = Math.abs(f2 - this.mInitialMotionX);
    f1 = Math.abs(f1 - this.mInitialMotionY);
    bool1 = bool2;
    if (f2 > this.mDragHelper.getTouchSlop()) {
      bool1 = bool2;
      if (f1 > f2) {
        this.mDragHelper.cancel();
        this.mIsUnableToDrag = true;
        return false;
      } 
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual isLayoutRtlSupport : ()Z
    //   4: istore #14
    //   6: iload #14
    //   8: ifeq -> 137
    //   11: aload_0
    //   12: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   15: iconst_2
    //   16: invokevirtual setEdgeTrackingEnabled : (I)V
    //   19: iload #4
    //   21: iload_2
    //   22: isub
    //   23: istore #9
    //   25: iload #14
    //   27: ifeq -> 148
    //   30: aload_0
    //   31: invokevirtual getPaddingRight : ()I
    //   34: istore_2
    //   35: iload #14
    //   37: ifeq -> 156
    //   40: aload_0
    //   41: invokevirtual getPaddingLeft : ()I
    //   44: istore #4
    //   46: aload_0
    //   47: invokevirtual getPaddingTop : ()I
    //   50: istore #11
    //   52: aload_0
    //   53: invokevirtual getChildCount : ()I
    //   56: istore #10
    //   58: iload_2
    //   59: istore #5
    //   61: aload_0
    //   62: getfield mFirstLayout : Z
    //   65: ifeq -> 91
    //   68: aload_0
    //   69: getfield mCanSlide : Z
    //   72: ifeq -> 165
    //   75: aload_0
    //   76: getfield mPreservedOpenState : Z
    //   79: ifeq -> 165
    //   82: fconst_1
    //   83: fstore #6
    //   85: aload_0
    //   86: fload #6
    //   88: putfield mSlideOffset : F
    //   91: iconst_0
    //   92: istore #7
    //   94: iload_2
    //   95: istore_3
    //   96: iload #5
    //   98: istore_2
    //   99: iload #7
    //   101: istore #5
    //   103: iload #5
    //   105: iload #10
    //   107: if_icmpge -> 444
    //   110: aload_0
    //   111: iload #5
    //   113: invokevirtual getChildAt : (I)Landroid/view/View;
    //   116: astore #15
    //   118: aload #15
    //   120: invokevirtual getVisibility : ()I
    //   123: bipush #8
    //   125: if_icmpne -> 171
    //   128: iload #5
    //   130: iconst_1
    //   131: iadd
    //   132: istore #5
    //   134: goto -> 103
    //   137: aload_0
    //   138: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   141: iconst_1
    //   142: invokevirtual setEdgeTrackingEnabled : (I)V
    //   145: goto -> 19
    //   148: aload_0
    //   149: invokevirtual getPaddingLeft : ()I
    //   152: istore_2
    //   153: goto -> 35
    //   156: aload_0
    //   157: invokevirtual getPaddingRight : ()I
    //   160: istore #4
    //   162: goto -> 46
    //   165: fconst_0
    //   166: fstore #6
    //   168: goto -> 85
    //   171: aload #15
    //   173: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   176: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
    //   179: astore #16
    //   181: aload #15
    //   183: invokevirtual getMeasuredWidth : ()I
    //   186: istore #12
    //   188: iconst_0
    //   189: istore #8
    //   191: aload #16
    //   193: getfield slideable : Z
    //   196: ifeq -> 385
    //   199: aload #16
    //   201: getfield leftMargin : I
    //   204: istore #7
    //   206: aload #16
    //   208: getfield rightMargin : I
    //   211: istore #13
    //   213: iload_2
    //   214: iload #9
    //   216: iload #4
    //   218: isub
    //   219: aload_0
    //   220: getfield mOverhangSize : I
    //   223: isub
    //   224: invokestatic min : (II)I
    //   227: iload_3
    //   228: isub
    //   229: iload #7
    //   231: iload #13
    //   233: iadd
    //   234: isub
    //   235: istore #13
    //   237: aload_0
    //   238: iload #13
    //   240: putfield mSlideRange : I
    //   243: iload #14
    //   245: ifeq -> 370
    //   248: aload #16
    //   250: getfield rightMargin : I
    //   253: istore #7
    //   255: iload_3
    //   256: iload #7
    //   258: iadd
    //   259: iload #13
    //   261: iadd
    //   262: iload #12
    //   264: iconst_2
    //   265: idiv
    //   266: iadd
    //   267: iload #9
    //   269: iload #4
    //   271: isub
    //   272: if_icmple -> 380
    //   275: iconst_1
    //   276: istore_1
    //   277: aload #16
    //   279: iload_1
    //   280: putfield dimWhenOffset : Z
    //   283: iload #13
    //   285: i2f
    //   286: aload_0
    //   287: getfield mSlideOffset : F
    //   290: fmul
    //   291: f2i
    //   292: istore #13
    //   294: iload_3
    //   295: iload #13
    //   297: iload #7
    //   299: iadd
    //   300: iadd
    //   301: istore_3
    //   302: aload_0
    //   303: iload #13
    //   305: i2f
    //   306: aload_0
    //   307: getfield mSlideRange : I
    //   310: i2f
    //   311: fdiv
    //   312: putfield mSlideOffset : F
    //   315: iload #8
    //   317: istore #7
    //   319: iload #14
    //   321: ifeq -> 428
    //   324: iload #9
    //   326: iload_3
    //   327: isub
    //   328: iload #7
    //   330: iadd
    //   331: istore #8
    //   333: iload #8
    //   335: iload #12
    //   337: isub
    //   338: istore #7
    //   340: aload #15
    //   342: iload #7
    //   344: iload #11
    //   346: iload #8
    //   348: iload #11
    //   350: aload #15
    //   352: invokevirtual getMeasuredHeight : ()I
    //   355: iadd
    //   356: invokevirtual layout : (IIII)V
    //   359: iload_2
    //   360: aload #15
    //   362: invokevirtual getWidth : ()I
    //   365: iadd
    //   366: istore_2
    //   367: goto -> 128
    //   370: aload #16
    //   372: getfield leftMargin : I
    //   375: istore #7
    //   377: goto -> 255
    //   380: iconst_0
    //   381: istore_1
    //   382: goto -> 277
    //   385: aload_0
    //   386: getfield mCanSlide : Z
    //   389: ifeq -> 419
    //   392: aload_0
    //   393: getfield mParallaxBy : I
    //   396: ifeq -> 419
    //   399: fconst_1
    //   400: aload_0
    //   401: getfield mSlideOffset : F
    //   404: fsub
    //   405: aload_0
    //   406: getfield mParallaxBy : I
    //   409: i2f
    //   410: fmul
    //   411: f2i
    //   412: istore #7
    //   414: iload_2
    //   415: istore_3
    //   416: goto -> 319
    //   419: iload_2
    //   420: istore_3
    //   421: iload #8
    //   423: istore #7
    //   425: goto -> 319
    //   428: iload_3
    //   429: iload #7
    //   431: isub
    //   432: istore #7
    //   434: iload #7
    //   436: iload #12
    //   438: iadd
    //   439: istore #8
    //   441: goto -> 340
    //   444: aload_0
    //   445: getfield mFirstLayout : Z
    //   448: ifeq -> 513
    //   451: aload_0
    //   452: getfield mCanSlide : Z
    //   455: ifeq -> 519
    //   458: aload_0
    //   459: getfield mParallaxBy : I
    //   462: ifeq -> 473
    //   465: aload_0
    //   466: aload_0
    //   467: getfield mSlideOffset : F
    //   470: invokespecial parallaxOtherViews : (F)V
    //   473: aload_0
    //   474: getfield mSlideableView : Landroid/view/View;
    //   477: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   480: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
    //   483: getfield dimWhenOffset : Z
    //   486: ifeq -> 505
    //   489: aload_0
    //   490: aload_0
    //   491: getfield mSlideableView : Landroid/view/View;
    //   494: aload_0
    //   495: getfield mSlideOffset : F
    //   498: aload_0
    //   499: getfield mSliderFadeColor : I
    //   502: invokespecial dimChildView : (Landroid/view/View;FI)V
    //   505: aload_0
    //   506: aload_0
    //   507: getfield mSlideableView : Landroid/view/View;
    //   510: invokevirtual updateObscuredViewsVisibility : (Landroid/view/View;)V
    //   513: aload_0
    //   514: iconst_0
    //   515: putfield mFirstLayout : Z
    //   518: return
    //   519: iconst_0
    //   520: istore_2
    //   521: iload_2
    //   522: iload #10
    //   524: if_icmpge -> 505
    //   527: aload_0
    //   528: aload_0
    //   529: iload_2
    //   530: invokevirtual getChildAt : (I)Landroid/view/View;
    //   533: fconst_0
    //   534: aload_0
    //   535: getfield mSliderFadeColor : I
    //   538: invokespecial dimChildView : (Landroid/view/View;FI)V
    //   541: iload_2
    //   542: iconst_1
    //   543: iadd
    //   544: istore_2
    //   545: goto -> 521
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_1
    //   1: invokestatic getMode : (I)I
    //   4: istore #8
    //   6: iload_1
    //   7: invokestatic getSize : (I)I
    //   10: istore #5
    //   12: iload_2
    //   13: invokestatic getMode : (I)I
    //   16: istore #6
    //   18: iload_2
    //   19: invokestatic getSize : (I)I
    //   22: istore_2
    //   23: iload #8
    //   25: ldc_w 1073741824
    //   28: if_icmpeq -> 254
    //   31: aload_0
    //   32: invokevirtual isInEditMode : ()Z
    //   35: ifeq -> 243
    //   38: iload #8
    //   40: ldc_w -2147483648
    //   43: if_icmpne -> 214
    //   46: iload #5
    //   48: istore #7
    //   50: iload_2
    //   51: istore_1
    //   52: iload #6
    //   54: istore #9
    //   56: iconst_0
    //   57: istore #5
    //   59: iconst_m1
    //   60: istore_2
    //   61: iload #9
    //   63: lookupswitch default -> 88, -2147483648 -> 336, 1073741824 -> 318
    //   88: fconst_0
    //   89: fstore_3
    //   90: iconst_0
    //   91: istore #15
    //   93: iload #7
    //   95: aload_0
    //   96: invokevirtual getPaddingLeft : ()I
    //   99: isub
    //   100: aload_0
    //   101: invokevirtual getPaddingRight : ()I
    //   104: isub
    //   105: istore #12
    //   107: iload #12
    //   109: istore #8
    //   111: aload_0
    //   112: invokevirtual getChildCount : ()I
    //   115: istore #13
    //   117: iload #13
    //   119: iconst_2
    //   120: if_icmple -> 132
    //   123: ldc 'SlidingPaneLayout'
    //   125: ldc_w 'onMeasure: More than two child views are not supported.'
    //   128: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: aload_0
    //   133: aconst_null
    //   134: putfield mSlideableView : Landroid/view/View;
    //   137: iconst_0
    //   138: istore #10
    //   140: iload #10
    //   142: iload #13
    //   144: if_icmpge -> 653
    //   147: aload_0
    //   148: iload #10
    //   150: invokevirtual getChildAt : (I)Landroid/view/View;
    //   153: astore #17
    //   155: aload #17
    //   157: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   160: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
    //   163: astore #18
    //   165: aload #17
    //   167: invokevirtual getVisibility : ()I
    //   170: bipush #8
    //   172: if_icmpne -> 351
    //   175: aload #18
    //   177: iconst_0
    //   178: putfield dimWhenOffset : Z
    //   181: iload #8
    //   183: istore #11
    //   185: iload #5
    //   187: istore #6
    //   189: iload #15
    //   191: istore #16
    //   193: iload #10
    //   195: iconst_1
    //   196: iadd
    //   197: istore #10
    //   199: iload #16
    //   201: istore #15
    //   203: iload #6
    //   205: istore #5
    //   207: iload #11
    //   209: istore #8
    //   211: goto -> 140
    //   214: iload #6
    //   216: istore #9
    //   218: iload_2
    //   219: istore_1
    //   220: iload #5
    //   222: istore #7
    //   224: iload #8
    //   226: ifne -> 56
    //   229: sipush #300
    //   232: istore #7
    //   234: iload #6
    //   236: istore #9
    //   238: iload_2
    //   239: istore_1
    //   240: goto -> 56
    //   243: new java/lang/IllegalStateException
    //   246: dup
    //   247: ldc_w 'Width must have an exact value or MATCH_PARENT'
    //   250: invokespecial <init> : (Ljava/lang/String;)V
    //   253: athrow
    //   254: iload #6
    //   256: istore #9
    //   258: iload_2
    //   259: istore_1
    //   260: iload #5
    //   262: istore #7
    //   264: iload #6
    //   266: ifne -> 56
    //   269: aload_0
    //   270: invokevirtual isInEditMode : ()Z
    //   273: ifeq -> 307
    //   276: iload #6
    //   278: istore #9
    //   280: iload_2
    //   281: istore_1
    //   282: iload #5
    //   284: istore #7
    //   286: iload #6
    //   288: ifne -> 56
    //   291: ldc_w -2147483648
    //   294: istore #9
    //   296: sipush #300
    //   299: istore_1
    //   300: iload #5
    //   302: istore #7
    //   304: goto -> 56
    //   307: new java/lang/IllegalStateException
    //   310: dup
    //   311: ldc_w 'Height must not be UNSPECIFIED'
    //   314: invokespecial <init> : (Ljava/lang/String;)V
    //   317: athrow
    //   318: iload_1
    //   319: aload_0
    //   320: invokevirtual getPaddingTop : ()I
    //   323: isub
    //   324: aload_0
    //   325: invokevirtual getPaddingBottom : ()I
    //   328: isub
    //   329: istore_2
    //   330: iload_2
    //   331: istore #5
    //   333: goto -> 88
    //   336: iload_1
    //   337: aload_0
    //   338: invokevirtual getPaddingTop : ()I
    //   341: isub
    //   342: aload_0
    //   343: invokevirtual getPaddingBottom : ()I
    //   346: isub
    //   347: istore_2
    //   348: goto -> 88
    //   351: fload_3
    //   352: fstore #4
    //   354: aload #18
    //   356: getfield weight : F
    //   359: fconst_0
    //   360: fcmpl
    //   361: ifle -> 396
    //   364: fload_3
    //   365: aload #18
    //   367: getfield weight : F
    //   370: fadd
    //   371: fstore #4
    //   373: iload #15
    //   375: istore #16
    //   377: iload #5
    //   379: istore #6
    //   381: fload #4
    //   383: fstore_3
    //   384: iload #8
    //   386: istore #11
    //   388: aload #18
    //   390: getfield width : I
    //   393: ifeq -> 193
    //   396: aload #18
    //   398: getfield leftMargin : I
    //   401: aload #18
    //   403: getfield rightMargin : I
    //   406: iadd
    //   407: istore_1
    //   408: aload #18
    //   410: getfield width : I
    //   413: bipush #-2
    //   415: if_icmpne -> 572
    //   418: iload #12
    //   420: iload_1
    //   421: isub
    //   422: ldc_w -2147483648
    //   425: invokestatic makeMeasureSpec : (II)I
    //   428: istore_1
    //   429: aload #18
    //   431: getfield height : I
    //   434: bipush #-2
    //   436: if_icmpne -> 610
    //   439: iload_2
    //   440: ldc_w -2147483648
    //   443: invokestatic makeMeasureSpec : (II)I
    //   446: istore #6
    //   448: aload #17
    //   450: iload_1
    //   451: iload #6
    //   453: invokevirtual measure : (II)V
    //   456: aload #17
    //   458: invokevirtual getMeasuredWidth : ()I
    //   461: istore #6
    //   463: aload #17
    //   465: invokevirtual getMeasuredHeight : ()I
    //   468: istore #11
    //   470: iload #5
    //   472: istore_1
    //   473: iload #9
    //   475: ldc_w -2147483648
    //   478: if_icmpne -> 498
    //   481: iload #5
    //   483: istore_1
    //   484: iload #11
    //   486: iload #5
    //   488: if_icmple -> 498
    //   491: iload #11
    //   493: iload_2
    //   494: invokestatic min : (II)I
    //   497: istore_1
    //   498: iload #8
    //   500: iload #6
    //   502: isub
    //   503: istore #5
    //   505: iload #5
    //   507: ifge -> 647
    //   510: iconst_1
    //   511: istore #16
    //   513: aload #18
    //   515: iload #16
    //   517: putfield slideable : Z
    //   520: iload #15
    //   522: iload #16
    //   524: ior
    //   525: istore #15
    //   527: iload #15
    //   529: istore #16
    //   531: iload_1
    //   532: istore #6
    //   534: fload #4
    //   536: fstore_3
    //   537: iload #5
    //   539: istore #11
    //   541: aload #18
    //   543: getfield slideable : Z
    //   546: ifeq -> 193
    //   549: aload_0
    //   550: aload #17
    //   552: putfield mSlideableView : Landroid/view/View;
    //   555: iload #15
    //   557: istore #16
    //   559: iload_1
    //   560: istore #6
    //   562: fload #4
    //   564: fstore_3
    //   565: iload #5
    //   567: istore #11
    //   569: goto -> 193
    //   572: aload #18
    //   574: getfield width : I
    //   577: iconst_m1
    //   578: if_icmpne -> 595
    //   581: iload #12
    //   583: iload_1
    //   584: isub
    //   585: ldc_w 1073741824
    //   588: invokestatic makeMeasureSpec : (II)I
    //   591: istore_1
    //   592: goto -> 429
    //   595: aload #18
    //   597: getfield width : I
    //   600: ldc_w 1073741824
    //   603: invokestatic makeMeasureSpec : (II)I
    //   606: istore_1
    //   607: goto -> 429
    //   610: aload #18
    //   612: getfield height : I
    //   615: iconst_m1
    //   616: if_icmpne -> 631
    //   619: iload_2
    //   620: ldc_w 1073741824
    //   623: invokestatic makeMeasureSpec : (II)I
    //   626: istore #6
    //   628: goto -> 448
    //   631: aload #18
    //   633: getfield height : I
    //   636: ldc_w 1073741824
    //   639: invokestatic makeMeasureSpec : (II)I
    //   642: istore #6
    //   644: goto -> 448
    //   647: iconst_0
    //   648: istore #16
    //   650: goto -> 513
    //   653: iload #15
    //   655: ifne -> 664
    //   658: fload_3
    //   659: fconst_0
    //   660: fcmpl
    //   661: ifle -> 1073
    //   664: iload #12
    //   666: aload_0
    //   667: getfield mOverhangSize : I
    //   670: isub
    //   671: istore #10
    //   673: iconst_0
    //   674: istore #6
    //   676: iload #6
    //   678: iload #13
    //   680: if_icmpge -> 1073
    //   683: aload_0
    //   684: iload #6
    //   686: invokevirtual getChildAt : (I)Landroid/view/View;
    //   689: astore #17
    //   691: aload #17
    //   693: invokevirtual getVisibility : ()I
    //   696: bipush #8
    //   698: if_icmpne -> 710
    //   701: iload #6
    //   703: iconst_1
    //   704: iadd
    //   705: istore #6
    //   707: goto -> 676
    //   710: aload #17
    //   712: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   715: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
    //   718: astore #18
    //   720: aload #17
    //   722: invokevirtual getVisibility : ()I
    //   725: bipush #8
    //   727: if_icmpeq -> 701
    //   730: aload #18
    //   732: getfield width : I
    //   735: ifne -> 835
    //   738: aload #18
    //   740: getfield weight : F
    //   743: fconst_0
    //   744: fcmpl
    //   745: ifle -> 835
    //   748: iconst_1
    //   749: istore_1
    //   750: iload_1
    //   751: ifeq -> 840
    //   754: iconst_0
    //   755: istore #9
    //   757: iload #15
    //   759: ifeq -> 900
    //   762: aload #17
    //   764: aload_0
    //   765: getfield mSlideableView : Landroid/view/View;
    //   768: if_acmpeq -> 900
    //   771: aload #18
    //   773: getfield width : I
    //   776: ifge -> 701
    //   779: iload #9
    //   781: iload #10
    //   783: if_icmpgt -> 796
    //   786: aload #18
    //   788: getfield weight : F
    //   791: fconst_0
    //   792: fcmpl
    //   793: ifle -> 701
    //   796: iload_1
    //   797: ifeq -> 885
    //   800: aload #18
    //   802: getfield height : I
    //   805: bipush #-2
    //   807: if_icmpne -> 850
    //   810: iload_2
    //   811: ldc_w -2147483648
    //   814: invokestatic makeMeasureSpec : (II)I
    //   817: istore_1
    //   818: aload #17
    //   820: iload #10
    //   822: ldc_w 1073741824
    //   825: invokestatic makeMeasureSpec : (II)I
    //   828: iload_1
    //   829: invokevirtual measure : (II)V
    //   832: goto -> 701
    //   835: iconst_0
    //   836: istore_1
    //   837: goto -> 750
    //   840: aload #17
    //   842: invokevirtual getMeasuredWidth : ()I
    //   845: istore #9
    //   847: goto -> 757
    //   850: aload #18
    //   852: getfield height : I
    //   855: iconst_m1
    //   856: if_icmpne -> 870
    //   859: iload_2
    //   860: ldc_w 1073741824
    //   863: invokestatic makeMeasureSpec : (II)I
    //   866: istore_1
    //   867: goto -> 818
    //   870: aload #18
    //   872: getfield height : I
    //   875: ldc_w 1073741824
    //   878: invokestatic makeMeasureSpec : (II)I
    //   881: istore_1
    //   882: goto -> 818
    //   885: aload #17
    //   887: invokevirtual getMeasuredHeight : ()I
    //   890: ldc_w 1073741824
    //   893: invokestatic makeMeasureSpec : (II)I
    //   896: istore_1
    //   897: goto -> 818
    //   900: aload #18
    //   902: getfield weight : F
    //   905: fconst_0
    //   906: fcmpl
    //   907: ifle -> 701
    //   910: aload #18
    //   912: getfield width : I
    //   915: ifne -> 1020
    //   918: aload #18
    //   920: getfield height : I
    //   923: bipush #-2
    //   925: if_icmpne -> 985
    //   928: iload_2
    //   929: ldc_w -2147483648
    //   932: invokestatic makeMeasureSpec : (II)I
    //   935: istore_1
    //   936: iload #15
    //   938: ifeq -> 1035
    //   941: iload #12
    //   943: aload #18
    //   945: getfield leftMargin : I
    //   948: aload #18
    //   950: getfield rightMargin : I
    //   953: iadd
    //   954: isub
    //   955: istore #11
    //   957: iload #11
    //   959: ldc_w 1073741824
    //   962: invokestatic makeMeasureSpec : (II)I
    //   965: istore #14
    //   967: iload #9
    //   969: iload #11
    //   971: if_icmpeq -> 701
    //   974: aload #17
    //   976: iload #14
    //   978: iload_1
    //   979: invokevirtual measure : (II)V
    //   982: goto -> 701
    //   985: aload #18
    //   987: getfield height : I
    //   990: iconst_m1
    //   991: if_icmpne -> 1005
    //   994: iload_2
    //   995: ldc_w 1073741824
    //   998: invokestatic makeMeasureSpec : (II)I
    //   1001: istore_1
    //   1002: goto -> 936
    //   1005: aload #18
    //   1007: getfield height : I
    //   1010: ldc_w 1073741824
    //   1013: invokestatic makeMeasureSpec : (II)I
    //   1016: istore_1
    //   1017: goto -> 936
    //   1020: aload #17
    //   1022: invokevirtual getMeasuredHeight : ()I
    //   1025: ldc_w 1073741824
    //   1028: invokestatic makeMeasureSpec : (II)I
    //   1031: istore_1
    //   1032: goto -> 936
    //   1035: iconst_0
    //   1036: iload #8
    //   1038: invokestatic max : (II)I
    //   1041: istore #11
    //   1043: aload #17
    //   1045: iload #9
    //   1047: aload #18
    //   1049: getfield weight : F
    //   1052: iload #11
    //   1054: i2f
    //   1055: fmul
    //   1056: fload_3
    //   1057: fdiv
    //   1058: f2i
    //   1059: iadd
    //   1060: ldc_w 1073741824
    //   1063: invokestatic makeMeasureSpec : (II)I
    //   1066: iload_1
    //   1067: invokevirtual measure : (II)V
    //   1070: goto -> 701
    //   1073: aload_0
    //   1074: iload #7
    //   1076: aload_0
    //   1077: invokevirtual getPaddingTop : ()I
    //   1080: iload #5
    //   1082: iadd
    //   1083: aload_0
    //   1084: invokevirtual getPaddingBottom : ()I
    //   1087: iadd
    //   1088: invokevirtual setMeasuredDimension : (II)V
    //   1091: aload_0
    //   1092: iload #15
    //   1094: putfield mCanSlide : Z
    //   1097: aload_0
    //   1098: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   1101: invokevirtual getViewDragState : ()I
    //   1104: ifeq -> 1119
    //   1107: iload #15
    //   1109: ifne -> 1119
    //   1112: aload_0
    //   1113: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   1116: invokevirtual abort : ()V
    //   1119: return
  }
  
  void onPanelDragged(int paramInt) {
    int j;
    if (this.mSlideableView == null) {
      this.mSlideOffset = 0.0F;
      return;
    } 
    boolean bool = isLayoutRtlSupport();
    LayoutParams layoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
    int i = this.mSlideableView.getWidth();
    if (bool)
      paramInt = getWidth() - paramInt - i; 
    if (bool) {
      i = getPaddingRight();
    } else {
      i = getPaddingLeft();
    } 
    if (bool) {
      j = layoutParams.rightMargin;
    } else {
      j = layoutParams.leftMargin;
    } 
    this.mSlideOffset = (paramInt - i + j) / this.mSlideRange;
    if (this.mParallaxBy != 0)
      parallaxOtherViews(this.mSlideOffset); 
    if (layoutParams.dimWhenOffset)
      dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor); 
    dispatchOnPanelSlide(this.mSlideableView);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    if (savedState.isOpen) {
      openPane();
    } else {
      closePane();
    } 
    this.mPreservedOpenState = savedState.isOpen;
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    if (isSlideable()) {
      boolean bool1 = isOpen();
      savedState.isOpen = bool1;
      return (Parcelable)savedState;
    } 
    boolean bool = this.mPreservedOpenState;
    savedState.isOpen = bool;
    return (Parcelable)savedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      this.mFirstLayout = true; 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    float f1;
    float f2;
    if (!this.mCanSlide)
      return super.onTouchEvent(paramMotionEvent); 
    this.mDragHelper.processTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    boolean bool2 = true;
    switch (i & 0xFF) {
      default:
        return true;
      case 0:
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.mInitialMotionX = f1;
        this.mInitialMotionY = f2;
        return true;
      case 1:
        break;
    } 
    boolean bool1 = bool2;
    if (isDimmed(this.mSlideableView)) {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      float f3 = f1 - this.mInitialMotionX;
      float f4 = f2 - this.mInitialMotionY;
      i = this.mDragHelper.getTouchSlop();
      bool1 = bool2;
      if (f3 * f3 + f4 * f4 < (i * i)) {
        bool1 = bool2;
        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int)f1, (int)f2)) {
          closePane(this.mSlideableView, 0);
          return true;
        } 
      } 
    } 
    return bool1;
  }
  
  public boolean openPane() {
    return openPane(this.mSlideableView, 0);
  }
  
  public void requestChildFocus(View paramView1, View paramView2) {
    super.requestChildFocus(paramView1, paramView2);
    if (!isInTouchMode() && !this.mCanSlide) {
      boolean bool;
      if (paramView1 == this.mSlideableView) {
        bool = true;
      } else {
        bool = false;
      } 
      this.mPreservedOpenState = bool;
    } 
  }
  
  void setAllChildrenVisible() {
    int i = 0;
    int j = getChildCount();
    while (i < j) {
      View view = getChildAt(i);
      if (view.getVisibility() == 4)
        view.setVisibility(0); 
      i++;
    } 
  }
  
  public void setCoveredFadeColor(@ColorInt int paramInt) {
    this.mCoveredFadeColor = paramInt;
  }
  
  public void setPanelSlideListener(PanelSlideListener paramPanelSlideListener) {
    this.mPanelSlideListener = paramPanelSlideListener;
  }
  
  public void setParallaxDistance(int paramInt) {
    this.mParallaxBy = paramInt;
    requestLayout();
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable) {
    setShadowDrawableLeft(paramDrawable);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable) {
    this.mShadowDrawableLeft = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable) {
    this.mShadowDrawableRight = paramDrawable;
  }
  
  @Deprecated
  public void setShadowResource(@DrawableRes int paramInt) {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setShadowResourceLeft(int paramInt) {
    setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setShadowResourceRight(int paramInt) {
    setShadowDrawableRight(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setSliderFadeColor(@ColorInt int paramInt) {
    this.mSliderFadeColor = paramInt;
  }
  
  @Deprecated
  public void smoothSlideClosed() {
    closePane();
  }
  
  @Deprecated
  public void smoothSlideOpen() {
    openPane();
  }
  
  boolean smoothSlideTo(float paramFloat, int paramInt) {
    if (this.mCanSlide) {
      boolean bool = isLayoutRtlSupport();
      LayoutParams layoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
      if (bool) {
        paramInt = getPaddingRight();
        int i = layoutParams.rightMargin;
        int j = this.mSlideableView.getWidth();
        paramInt = (int)(getWidth() - (paramInt + i) + this.mSlideRange * paramFloat + j);
      } else {
        paramInt = (int)((getPaddingLeft() + layoutParams.leftMargin) + this.mSlideRange * paramFloat);
      } 
      if (this.mDragHelper.smoothSlideViewTo(this.mSlideableView, paramInt, this.mSlideableView.getTop())) {
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation((View)this);
        return true;
      } 
    } 
    return false;
  }
  
  void updateObscuredViewsVisibility(View paramView) {
    int i;
    int j;
    byte b1;
    byte b2;
    byte b3;
    byte b4;
    boolean bool = isLayoutRtlSupport();
    if (bool) {
      i = getWidth() - getPaddingRight();
    } else {
      i = getPaddingLeft();
    } 
    if (bool) {
      j = getPaddingLeft();
    } else {
      j = getWidth() - getPaddingRight();
    } 
    int m = getPaddingTop();
    int n = getHeight();
    int i1 = getPaddingBottom();
    if (paramView != null && viewIsOpaque(paramView)) {
      b2 = paramView.getLeft();
      b3 = paramView.getRight();
      b4 = paramView.getTop();
      b1 = paramView.getBottom();
    } else {
      b1 = 0;
      b4 = 0;
      b3 = 0;
      b2 = 0;
    } 
    int k = 0;
    int i2 = getChildCount();
    while (true) {
      if (k < i2) {
        View view = getChildAt(k);
        if (view != paramView) {
          if (view.getVisibility() != 8) {
            if (bool) {
              i3 = j;
            } else {
              i3 = i;
            } 
            int i4 = Math.max(i3, view.getLeft());
            int i5 = Math.max(m, view.getTop());
            if (bool) {
              i3 = i;
            } else {
              i3 = j;
            } 
            int i3 = Math.min(i3, view.getRight());
            int i6 = Math.min(n - i1, view.getBottom());
            if (i4 >= b2 && i5 >= b4 && i3 <= b3 && i6 <= b1) {
              i3 = 4;
            } else {
              i3 = 0;
            } 
            view.setVisibility(i3);
          } 
          k++;
          continue;
        } 
      } 
      return;
    } 
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17) {
      IMPL = new SlidingPanelLayoutImplJBMR1();
      return;
    } 
    if (i >= 16) {
      IMPL = new SlidingPanelLayoutImplJB();
      return;
    } 
  }
  
  class AccessibilityDelegate extends AccessibilityDelegateCompat {
    private final Rect mTmpRect = new Rect();
    
    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat2) {
      Rect rect = this.mTmpRect;
      param1AccessibilityNodeInfoCompat2.getBoundsInParent(rect);
      param1AccessibilityNodeInfoCompat1.setBoundsInParent(rect);
      param1AccessibilityNodeInfoCompat2.getBoundsInScreen(rect);
      param1AccessibilityNodeInfoCompat1.setBoundsInScreen(rect);
      param1AccessibilityNodeInfoCompat1.setVisibleToUser(param1AccessibilityNodeInfoCompat2.isVisibleToUser());
      param1AccessibilityNodeInfoCompat1.setPackageName(param1AccessibilityNodeInfoCompat2.getPackageName());
      param1AccessibilityNodeInfoCompat1.setClassName(param1AccessibilityNodeInfoCompat2.getClassName());
      param1AccessibilityNodeInfoCompat1.setContentDescription(param1AccessibilityNodeInfoCompat2.getContentDescription());
      param1AccessibilityNodeInfoCompat1.setEnabled(param1AccessibilityNodeInfoCompat2.isEnabled());
      param1AccessibilityNodeInfoCompat1.setClickable(param1AccessibilityNodeInfoCompat2.isClickable());
      param1AccessibilityNodeInfoCompat1.setFocusable(param1AccessibilityNodeInfoCompat2.isFocusable());
      param1AccessibilityNodeInfoCompat1.setFocused(param1AccessibilityNodeInfoCompat2.isFocused());
      param1AccessibilityNodeInfoCompat1.setAccessibilityFocused(param1AccessibilityNodeInfoCompat2.isAccessibilityFocused());
      param1AccessibilityNodeInfoCompat1.setSelected(param1AccessibilityNodeInfoCompat2.isSelected());
      param1AccessibilityNodeInfoCompat1.setLongClickable(param1AccessibilityNodeInfoCompat2.isLongClickable());
      param1AccessibilityNodeInfoCompat1.addAction(param1AccessibilityNodeInfoCompat2.getActions());
      param1AccessibilityNodeInfoCompat1.setMovementGranularities(param1AccessibilityNodeInfoCompat2.getMovementGranularities());
    }
    
    public boolean filter(View param1View) {
      return SlidingPaneLayout.this.isDimmed(param1View);
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(param1AccessibilityNodeInfoCompat);
      super.onInitializeAccessibilityNodeInfo(param1View, accessibilityNodeInfoCompat);
      copyNodeInfoNoChildren(param1AccessibilityNodeInfoCompat, accessibilityNodeInfoCompat);
      accessibilityNodeInfoCompat.recycle();
      param1AccessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
      param1AccessibilityNodeInfoCompat.setSource(param1View);
      ViewParent viewParent = ViewCompat.getParentForAccessibility(param1View);
      if (viewParent instanceof View)
        param1AccessibilityNodeInfoCompat.setParent((View)viewParent); 
      int j = SlidingPaneLayout.this.getChildCount();
      for (int i = 0; i < j; i++) {
        View view = SlidingPaneLayout.this.getChildAt(i);
        if (!filter(view) && view.getVisibility() == 0) {
          ViewCompat.setImportantForAccessibility(view, 1);
          param1AccessibilityNodeInfoCompat.addChild(view);
        } 
      } 
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return !filter(param1View) ? super.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent) : false;
    }
  }
  
  private class DisableLayerRunnable implements Runnable {
    final View mChildView;
    
    DisableLayerRunnable(View param1View) {
      this.mChildView = param1View;
    }
    
    public void run() {
      if (this.mChildView.getParent() == SlidingPaneLayout.this) {
        ViewCompat.setLayerType(this.mChildView, 0, null);
        SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
      } 
      SlidingPaneLayout.this.mPostedRunnables.remove(this);
    }
  }
  
  private class DragHelperCallback extends ViewDragHelper.Callback {
    public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
      SlidingPaneLayout.LayoutParams layoutParams = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.mSlideableView.getLayoutParams();
      if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
        param1Int2 = SlidingPaneLayout.this.getWidth() - SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin + SlidingPaneLayout.this.mSlideableView.getWidth();
        int j = SlidingPaneLayout.this.mSlideRange;
        return Math.max(Math.min(param1Int1, param1Int2), param1Int2 - j);
      } 
      param1Int2 = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
      int i = SlidingPaneLayout.this.mSlideRange;
      return Math.min(Math.max(param1Int1, param1Int2), param1Int2 + i);
    }
    
    public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
      return param1View.getTop();
    }
    
    public int getViewHorizontalDragRange(View param1View) {
      return SlidingPaneLayout.this.mSlideRange;
    }
    
    public void onEdgeDragStarted(int param1Int1, int param1Int2) {
      SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, param1Int2);
    }
    
    public void onViewCaptured(View param1View, int param1Int) {
      SlidingPaneLayout.this.setAllChildrenVisible();
    }
    
    public void onViewDragStateChanged(int param1Int) {
      if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
        if (SlidingPaneLayout.this.mSlideOffset == 0.0F) {
          SlidingPaneLayout.this.updateObscuredViewsVisibility(SlidingPaneLayout.this.mSlideableView);
          SlidingPaneLayout.this.dispatchOnPanelClosed(SlidingPaneLayout.this.mSlideableView);
          SlidingPaneLayout.this.mPreservedOpenState = false;
          return;
        } 
      } else {
        return;
      } 
      SlidingPaneLayout.this.dispatchOnPanelOpened(SlidingPaneLayout.this.mSlideableView);
      SlidingPaneLayout.this.mPreservedOpenState = true;
    }
    
    public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      SlidingPaneLayout.this.onPanelDragged(param1Int1);
      SlidingPaneLayout.this.invalidate();
    }
    
    public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   4: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
      //   7: astore #6
      //   9: aload_0
      //   10: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   13: invokevirtual isLayoutRtlSupport : ()Z
      //   16: ifeq -> 131
      //   19: aload_0
      //   20: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   23: invokevirtual getPaddingRight : ()I
      //   26: aload #6
      //   28: getfield rightMargin : I
      //   31: iadd
      //   32: istore #5
      //   34: fload_2
      //   35: fconst_0
      //   36: fcmpg
      //   37: iflt -> 67
      //   40: iload #5
      //   42: istore #4
      //   44: fload_2
      //   45: fconst_0
      //   46: fcmpl
      //   47: ifne -> 79
      //   50: iload #5
      //   52: istore #4
      //   54: aload_0
      //   55: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   58: getfield mSlideOffset : F
      //   61: ldc 0.5
      //   63: fcmpl
      //   64: ifle -> 79
      //   67: iload #5
      //   69: aload_0
      //   70: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   73: getfield mSlideRange : I
      //   76: iadd
      //   77: istore #4
      //   79: aload_0
      //   80: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   83: getfield mSlideableView : Landroid/view/View;
      //   86: invokevirtual getWidth : ()I
      //   89: istore #5
      //   91: aload_0
      //   92: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   95: invokevirtual getWidth : ()I
      //   98: iload #4
      //   100: isub
      //   101: iload #5
      //   103: isub
      //   104: istore #4
      //   106: aload_0
      //   107: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   110: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
      //   113: iload #4
      //   115: aload_1
      //   116: invokevirtual getTop : ()I
      //   119: invokevirtual settleCapturedViewAt : (II)Z
      //   122: pop
      //   123: aload_0
      //   124: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   127: invokevirtual invalidate : ()V
      //   130: return
      //   131: aload_0
      //   132: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   135: invokevirtual getPaddingLeft : ()I
      //   138: aload #6
      //   140: getfield leftMargin : I
      //   143: iadd
      //   144: istore #5
      //   146: fload_2
      //   147: fconst_0
      //   148: fcmpl
      //   149: ifgt -> 179
      //   152: iload #5
      //   154: istore #4
      //   156: fload_2
      //   157: fconst_0
      //   158: fcmpl
      //   159: ifne -> 106
      //   162: iload #5
      //   164: istore #4
      //   166: aload_0
      //   167: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   170: getfield mSlideOffset : F
      //   173: ldc 0.5
      //   175: fcmpl
      //   176: ifle -> 106
      //   179: iload #5
      //   181: aload_0
      //   182: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   185: getfield mSlideRange : I
      //   188: iadd
      //   189: istore #4
      //   191: goto -> 106
    }
    
    public boolean tryCaptureView(View param1View, int param1Int) {
      return SlidingPaneLayout.this.mIsUnableToDrag ? false : ((SlidingPaneLayout.LayoutParams)param1View.getLayoutParams()).slideable;
    }
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    private static final int[] ATTRS = new int[] { 16843137 };
    
    Paint dimPaint;
    
    boolean dimWhenOffset;
    
    boolean slideable;
    
    public float weight = 0.0F;
    
    public LayoutParams() {
      super(-1, -1);
    }
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, ATTRS);
      this.weight = typedArray.getFloat(0, 0.0F);
      typedArray.recycle();
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.weight = param1LayoutParams.weight;
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
  }
  
  public static interface PanelSlideListener {
    void onPanelClosed(View param1View);
    
    void onPanelOpened(View param1View);
    
    void onPanelSlide(View param1View, float param1Float);
  }
  
  static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
          public SlidingPaneLayout.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
            return new SlidingPaneLayout.SavedState(param2Parcel, param2ClassLoader);
          }
          
          public SlidingPaneLayout.SavedState[] newArray(int param2Int) {
            return new SlidingPaneLayout.SavedState[param2Int];
          }
        });
    
    boolean isOpen;
    
    SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      boolean bool;
      if (param1Parcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.isOpen = bool;
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      if (this.isOpen) {
        param1Int = 1;
      } else {
        param1Int = 0;
      } 
      param1Parcel.writeInt(param1Int);
    }
  }
  
  static final class null implements ParcelableCompatCreatorCallbacks<SavedState> {
    public SlidingPaneLayout.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new SlidingPaneLayout.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public SlidingPaneLayout.SavedState[] newArray(int param1Int) {
      return new SlidingPaneLayout.SavedState[param1Int];
    }
  }
  
  public static class SimplePanelSlideListener implements PanelSlideListener {
    public void onPanelClosed(View param1View) {}
    
    public void onPanelOpened(View param1View) {}
    
    public void onPanelSlide(View param1View, float param1Float) {}
  }
  
  static interface SlidingPanelLayoutImpl {
    void invalidateChildRegion(SlidingPaneLayout param1SlidingPaneLayout, View param1View);
  }
  
  static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
    public void invalidateChildRegion(SlidingPaneLayout param1SlidingPaneLayout, View param1View) {
      ViewCompat.postInvalidateOnAnimation((View)param1SlidingPaneLayout, param1View.getLeft(), param1View.getTop(), param1View.getRight(), param1View.getBottom());
    }
  }
  
  static class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
    private Method mGetDisplayList;
    
    private Field mRecreateDisplayList;
    
    SlidingPanelLayoutImplJB() {
      try {
        this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[])null);
        try {
          this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
          this.mRecreateDisplayList.setAccessible(true);
          return;
        } catch (NoSuchFieldException noSuchFieldException) {
          Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", noSuchFieldException);
        } 
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", noSuchMethodException);
        try {
          this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
          this.mRecreateDisplayList.setAccessible(true);
          return;
        } catch (NoSuchFieldException noSuchFieldException) {
          Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", noSuchFieldException);
        } 
      } 
    }
    
    public void invalidateChildRegion(SlidingPaneLayout param1SlidingPaneLayout, View param1View) {
      if (this.mGetDisplayList != null && this.mRecreateDisplayList != null) {
        try {
          this.mRecreateDisplayList.setBoolean(param1View, true);
          this.mGetDisplayList.invoke(param1View, (Object[])null);
        } catch (Exception exception) {
          Log.e("SlidingPaneLayout", "Error refreshing display list state", exception);
        } 
        super.invalidateChildRegion(param1SlidingPaneLayout, param1View);
        return;
      } 
      param1View.invalidate();
    }
  }
  
  static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
    public void invalidateChildRegion(SlidingPaneLayout param1SlidingPaneLayout, View param1View) {
      ViewCompat.setLayerPaint(param1View, ((SlidingPaneLayout.LayoutParams)param1View.getLayoutParams()).dimPaint);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\SlidingPaneLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */