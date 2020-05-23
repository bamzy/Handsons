package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
  private static final int CLOSE_ENOUGH = 2;
  
  private static final Comparator<ItemInfo> COMPARATOR;
  
  private static final boolean DEBUG = false;
  
  private static final int DEFAULT_GUTTER_SIZE = 16;
  
  private static final int DEFAULT_OFFSCREEN_PAGES = 1;
  
  private static final int DRAW_ORDER_DEFAULT = 0;
  
  private static final int DRAW_ORDER_FORWARD = 1;
  
  private static final int DRAW_ORDER_REVERSE = 2;
  
  private static final int INVALID_POINTER = -1;
  
  static final int[] LAYOUT_ATTRS = new int[] { 16842931 };
  
  private static final int MAX_SETTLE_DURATION = 600;
  
  private static final int MIN_DISTANCE_FOR_FLING = 25;
  
  private static final int MIN_FLING_VELOCITY = 400;
  
  public static final int SCROLL_STATE_DRAGGING = 1;
  
  public static final int SCROLL_STATE_IDLE = 0;
  
  public static final int SCROLL_STATE_SETTLING = 2;
  
  private static final String TAG = "ViewPager";
  
  private static final boolean USE_CACHE = false;
  
  private static final Interpolator sInterpolator;
  
  private static final ViewPositionComparator sPositionComparator;
  
  private int mActivePointerId = -1;
  
  PagerAdapter mAdapter;
  
  private List<OnAdapterChangeListener> mAdapterChangeListeners;
  
  private int mBottomPageBounds;
  
  private boolean mCalledSuper;
  
  private int mChildHeightMeasureSpec;
  
  private int mChildWidthMeasureSpec;
  
  private int mCloseEnough;
  
  int mCurItem;
  
  private int mDecorChildCount;
  
  private int mDefaultGutterSize;
  
  private int mDrawingOrder;
  
  private ArrayList<View> mDrawingOrderedChildren;
  
  private final Runnable mEndScrollRunnable = new Runnable() {
      public void run() {
        ViewPager.this.setScrollState(0);
        ViewPager.this.populate();
      }
    };
  
  private int mExpectedAdapterCount;
  
  private long mFakeDragBeginTime;
  
  private boolean mFakeDragging;
  
  private boolean mFirstLayout = true;
  
  private float mFirstOffset = -3.4028235E38F;
  
  private int mFlingDistance;
  
  private int mGutterSize;
  
  private boolean mInLayout;
  
  private float mInitialMotionX;
  
  private float mInitialMotionY;
  
  private OnPageChangeListener mInternalPageChangeListener;
  
  private boolean mIsBeingDragged;
  
  private boolean mIsScrollStarted;
  
  private boolean mIsUnableToDrag;
  
  private final ArrayList<ItemInfo> mItems = new ArrayList<ItemInfo>();
  
  private float mLastMotionX;
  
  private float mLastMotionY;
  
  private float mLastOffset = Float.MAX_VALUE;
  
  private EdgeEffectCompat mLeftEdge;
  
  private Drawable mMarginDrawable;
  
  private int mMaximumVelocity;
  
  private int mMinimumVelocity;
  
  private boolean mNeedCalculatePageOffsets = false;
  
  private PagerObserver mObserver;
  
  private int mOffscreenPageLimit = 1;
  
  private OnPageChangeListener mOnPageChangeListener;
  
  private List<OnPageChangeListener> mOnPageChangeListeners;
  
  private int mPageMargin;
  
  private PageTransformer mPageTransformer;
  
  private int mPageTransformerLayerType;
  
  private boolean mPopulatePending;
  
  private Parcelable mRestoredAdapterState = null;
  
  private ClassLoader mRestoredClassLoader = null;
  
  private int mRestoredCurItem = -1;
  
  private EdgeEffectCompat mRightEdge;
  
  private int mScrollState = 0;
  
  private Scroller mScroller;
  
  private boolean mScrollingCacheEnabled;
  
  private Method mSetChildrenDrawingOrderEnabled;
  
  private final ItemInfo mTempItem = new ItemInfo();
  
  private final Rect mTempRect = new Rect();
  
  private int mTopPageBounds;
  
  private int mTouchSlop;
  
  private VelocityTracker mVelocityTracker;
  
  static {
    COMPARATOR = new Comparator<ItemInfo>() {
        public int compare(ViewPager.ItemInfo param1ItemInfo1, ViewPager.ItemInfo param1ItemInfo2) {
          return param1ItemInfo1.position - param1ItemInfo2.position;
        }
      };
    sInterpolator = new Interpolator() {
        public float getInterpolation(float param1Float) {
          param1Float--;
          return param1Float * param1Float * param1Float * param1Float * param1Float + 1.0F;
        }
      };
    sPositionComparator = new ViewPositionComparator();
  }
  
  public ViewPager(Context paramContext) {
    super(paramContext);
    initViewPager();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private void calculatePageOffsets(ItemInfo paramItemInfo1, int paramInt, ItemInfo paramItemInfo2) {
    float f2;
    int m = this.mAdapter.getCount();
    int i = getClientWidth();
    if (i > 0) {
      f2 = this.mPageMargin / i;
    } else {
      f2 = 0.0F;
    } 
    if (paramItemInfo2 != null) {
      i = paramItemInfo2.position;
      if (i < paramItemInfo1.position) {
        int n = 0;
        f1 = paramItemInfo2.offset + paramItemInfo2.widthFactor + f2;
        while (++i <= paramItemInfo1.position && n < this.mItems.size()) {
          float f;
          int i1;
          paramItemInfo2 = this.mItems.get(n);
          while (true) {
            f = f1;
            i1 = i;
            if (i > paramItemInfo2.position) {
              f = f1;
              i1 = i;
              if (n < this.mItems.size() - 1) {
                paramItemInfo2 = this.mItems.get(++n);
                continue;
              } 
            } 
            break;
          } 
          while (i1 < paramItemInfo2.position) {
            f += this.mAdapter.getPageWidth(i1) + f2;
            i1++;
          } 
          paramItemInfo2.offset = f;
          f1 = f + paramItemInfo2.widthFactor + f2;
          i = i1 + 1;
        } 
      } else if (i > paramItemInfo1.position) {
        int n = this.mItems.size() - 1;
        f1 = paramItemInfo2.offset;
        while (--i >= paramItemInfo1.position && n >= 0) {
          float f;
          int i1;
          paramItemInfo2 = this.mItems.get(n);
          while (true) {
            f = f1;
            i1 = i;
            if (i < paramItemInfo2.position) {
              f = f1;
              i1 = i;
              if (n > 0) {
                paramItemInfo2 = this.mItems.get(--n);
                continue;
              } 
            } 
            break;
          } 
          while (i1 > paramItemInfo2.position) {
            f -= this.mAdapter.getPageWidth(i1) + f2;
            i1--;
          } 
          f1 = f - paramItemInfo2.widthFactor + f2;
          paramItemInfo2.offset = f1;
          i = i1 - 1;
        } 
      } 
    } 
    int k = this.mItems.size();
    float f3 = paramItemInfo1.offset;
    i = paramItemInfo1.position - 1;
    if (paramItemInfo1.position == 0) {
      f1 = paramItemInfo1.offset;
    } else {
      f1 = -3.4028235E38F;
    } 
    this.mFirstOffset = f1;
    if (paramItemInfo1.position == m - 1) {
      f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor - 1.0F;
    } else {
      f1 = Float.MAX_VALUE;
    } 
    this.mLastOffset = f1;
    int j = paramInt - 1;
    float f1 = f3;
    while (j >= 0) {
      paramItemInfo2 = this.mItems.get(j);
      while (i > paramItemInfo2.position) {
        f1 -= this.mAdapter.getPageWidth(i) + f2;
        i--;
      } 
      f1 -= paramItemInfo2.widthFactor + f2;
      paramItemInfo2.offset = f1;
      if (paramItemInfo2.position == 0)
        this.mFirstOffset = f1; 
      j--;
      i--;
    } 
    f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor + f2;
    i = paramItemInfo1.position + 1;
    j = paramInt + 1;
    paramInt = i;
    i = j;
    while (i < k) {
      paramItemInfo1 = this.mItems.get(i);
      while (paramInt < paramItemInfo1.position) {
        f1 += this.mAdapter.getPageWidth(paramInt) + f2;
        paramInt++;
      } 
      if (paramItemInfo1.position == m - 1)
        this.mLastOffset = paramItemInfo1.widthFactor + f1 - 1.0F; 
      paramItemInfo1.offset = f1;
      f1 += paramItemInfo1.widthFactor + f2;
      i++;
      paramInt++;
    } 
    this.mNeedCalculatePageOffsets = false;
  }
  
  private void completeScroll(boolean paramBoolean) {
    int j = 1;
    if (this.mScrollState == 2) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      setScrollingCacheEnabled(false);
      if (this.mScroller.isFinished())
        j = 0; 
      if (j) {
        this.mScroller.abortAnimation();
        j = getScrollX();
        int k = getScrollY();
        int m = this.mScroller.getCurrX();
        int n = this.mScroller.getCurrY();
        if (j != m || k != n) {
          scrollTo(m, n);
          if (m != j)
            pageScrolled(m); 
        } 
      } 
    } 
    this.mPopulatePending = false;
    byte b = 0;
    j = i;
    int i;
    for (i = b; i < this.mItems.size(); i++) {
      ItemInfo itemInfo = this.mItems.get(i);
      if (itemInfo.scrolling) {
        j = 1;
        itemInfo.scrolling = false;
      } 
    } 
    if (j != 0) {
      if (paramBoolean) {
        ViewCompat.postOnAnimation((View)this, this.mEndScrollRunnable);
        return;
      } 
    } else {
      return;
    } 
    this.mEndScrollRunnable.run();
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3) {
    if (Math.abs(paramInt3) > this.mFlingDistance && Math.abs(paramInt2) > this.mMinimumVelocity) {
      if (paramInt2 <= 0)
        paramInt1++; 
    } else {
      float f;
      if (paramInt1 >= this.mCurItem) {
        f = 0.4F;
      } else {
        f = 0.6F;
      } 
      paramInt1 += (int)(paramFloat + f);
    } 
    paramInt2 = paramInt1;
    if (this.mItems.size() > 0) {
      ItemInfo itemInfo1 = this.mItems.get(0);
      ItemInfo itemInfo2 = this.mItems.get(this.mItems.size() - 1);
      paramInt2 = Math.max(itemInfo1.position, Math.min(paramInt1, itemInfo2.position));
    } 
    return paramInt2;
  }
  
  private void dispatchOnPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    if (this.mOnPageChangeListener != null)
      this.mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
    if (this.mOnPageChangeListeners != null) {
      int i = 0;
      int j = this.mOnPageChangeListeners.size();
      while (i < j) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
        i++;
      } 
    } 
    if (this.mInternalPageChangeListener != null)
      this.mInternalPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
  }
  
  private void dispatchOnPageSelected(int paramInt) {
    if (this.mOnPageChangeListener != null)
      this.mOnPageChangeListener.onPageSelected(paramInt); 
    if (this.mOnPageChangeListeners != null) {
      int i = 0;
      int j = this.mOnPageChangeListeners.size();
      while (i < j) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageSelected(paramInt); 
        i++;
      } 
    } 
    if (this.mInternalPageChangeListener != null)
      this.mInternalPageChangeListener.onPageSelected(paramInt); 
  }
  
  private void dispatchOnScrollStateChanged(int paramInt) {
    if (this.mOnPageChangeListener != null)
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt); 
    if (this.mOnPageChangeListeners != null) {
      int i = 0;
      int j = this.mOnPageChangeListeners.size();
      while (i < j) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageScrollStateChanged(paramInt); 
        i++;
      } 
    } 
    if (this.mInternalPageChangeListener != null)
      this.mInternalPageChangeListener.onPageScrollStateChanged(paramInt); 
  }
  
  private void enableLayers(boolean paramBoolean) {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      boolean bool;
      if (paramBoolean) {
        bool = this.mPageTransformerLayerType;
      } else {
        bool = false;
      } 
      ViewCompat.setLayerType(getChildAt(i), bool, null);
    } 
  }
  
  private void endDrag() {
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    } 
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView) {
    Rect rect = paramRect;
    if (paramRect == null)
      rect = new Rect(); 
    if (paramView == null) {
      rect.set(0, 0, 0, 0);
      return rect;
    } 
    rect.left = paramView.getLeft();
    rect.right = paramView.getRight();
    rect.top = paramView.getTop();
    rect.bottom = paramView.getBottom();
    ViewParent viewParent = paramView.getParent();
    while (true) {
      if (viewParent instanceof ViewGroup && viewParent != this) {
        ViewGroup viewGroup = (ViewGroup)viewParent;
        rect.left += viewGroup.getLeft();
        rect.right += viewGroup.getRight();
        rect.top += viewGroup.getTop();
        rect.bottom += viewGroup.getBottom();
        ViewParent viewParent1 = viewGroup.getParent();
        continue;
      } 
      return rect;
    } 
  }
  
  private int getClientWidth() {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private ItemInfo infoForCurrentScrollPosition() {
    // Byte code:
    //   0: fconst_0
    //   1: fstore_2
    //   2: aload_0
    //   3: invokespecial getClientWidth : ()I
    //   6: istore #5
    //   8: iload #5
    //   10: ifle -> 227
    //   13: aload_0
    //   14: invokevirtual getScrollX : ()I
    //   17: i2f
    //   18: iload #5
    //   20: i2f
    //   21: fdiv
    //   22: fstore_1
    //   23: iload #5
    //   25: ifle -> 38
    //   28: aload_0
    //   29: getfield mPageMargin : I
    //   32: i2f
    //   33: iload #5
    //   35: i2f
    //   36: fdiv
    //   37: fstore_2
    //   38: iconst_m1
    //   39: istore #7
    //   41: fconst_0
    //   42: fstore_3
    //   43: fconst_0
    //   44: fstore #4
    //   46: iconst_1
    //   47: istore #6
    //   49: aconst_null
    //   50: astore #10
    //   52: iconst_0
    //   53: istore #5
    //   55: aload #10
    //   57: astore #11
    //   59: iload #5
    //   61: aload_0
    //   62: getfield mItems : Ljava/util/ArrayList;
    //   65: invokevirtual size : ()I
    //   68: if_icmpge -> 224
    //   71: aload_0
    //   72: getfield mItems : Ljava/util/ArrayList;
    //   75: iload #5
    //   77: invokevirtual get : (I)Ljava/lang/Object;
    //   80: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   83: astore #11
    //   85: iload #5
    //   87: istore #8
    //   89: aload #11
    //   91: astore #9
    //   93: iload #6
    //   95: ifne -> 167
    //   98: iload #5
    //   100: istore #8
    //   102: aload #11
    //   104: astore #9
    //   106: aload #11
    //   108: getfield position : I
    //   111: iload #7
    //   113: iconst_1
    //   114: iadd
    //   115: if_icmpeq -> 167
    //   118: aload_0
    //   119: getfield mTempItem : Landroid/support/v4/view/ViewPager$ItemInfo;
    //   122: astore #9
    //   124: aload #9
    //   126: fload_3
    //   127: fload #4
    //   129: fadd
    //   130: fload_2
    //   131: fadd
    //   132: putfield offset : F
    //   135: aload #9
    //   137: iload #7
    //   139: iconst_1
    //   140: iadd
    //   141: putfield position : I
    //   144: aload #9
    //   146: aload_0
    //   147: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   150: aload #9
    //   152: getfield position : I
    //   155: invokevirtual getPageWidth : (I)F
    //   158: putfield widthFactor : F
    //   161: iload #5
    //   163: iconst_1
    //   164: isub
    //   165: istore #8
    //   167: aload #9
    //   169: getfield offset : F
    //   172: fstore_3
    //   173: aload #9
    //   175: getfield widthFactor : F
    //   178: fstore #4
    //   180: iload #6
    //   182: ifne -> 195
    //   185: aload #10
    //   187: astore #11
    //   189: fload_1
    //   190: fload_3
    //   191: fcmpl
    //   192: iflt -> 224
    //   195: fload_1
    //   196: fload #4
    //   198: fload_3
    //   199: fadd
    //   200: fload_2
    //   201: fadd
    //   202: fcmpg
    //   203: iflt -> 220
    //   206: iload #8
    //   208: aload_0
    //   209: getfield mItems : Ljava/util/ArrayList;
    //   212: invokevirtual size : ()I
    //   215: iconst_1
    //   216: isub
    //   217: if_icmpne -> 232
    //   220: aload #9
    //   222: astore #11
    //   224: aload #11
    //   226: areturn
    //   227: fconst_0
    //   228: fstore_1
    //   229: goto -> 23
    //   232: iconst_0
    //   233: istore #6
    //   235: aload #9
    //   237: getfield position : I
    //   240: istore #7
    //   242: aload #9
    //   244: getfield widthFactor : F
    //   247: fstore #4
    //   249: iload #8
    //   251: iconst_1
    //   252: iadd
    //   253: istore #5
    //   255: aload #9
    //   257: astore #10
    //   259: goto -> 55
  }
  
  private static boolean isDecorView(@NonNull View paramView) {
    return (paramView.getClass().getAnnotation(DecorView.class) != null);
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2) {
    return ((paramFloat1 < this.mGutterSize && paramFloat2 > 0.0F) || (paramFloat1 > (getWidth() - this.mGutterSize) && paramFloat2 < 0.0F));
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent) {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.mLastMotionX = paramMotionEvent.getX(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null)
        this.mVelocityTracker.clear(); 
    } 
  }
  
  private boolean pageScrolled(int paramInt) {
    if (this.mItems.size() == 0) {
      if (!this.mFirstLayout) {
        this.mCalledSuper = false;
        onPageScrolled(0, 0.0F, 0);
        if (!this.mCalledSuper)
          throw new IllegalStateException("onPageScrolled did not call superclass implementation"); 
      } 
      return false;
    } 
    ItemInfo itemInfo = infoForCurrentScrollPosition();
    int j = getClientWidth();
    int k = this.mPageMargin;
    float f = this.mPageMargin / j;
    int i = itemInfo.position;
    f = (paramInt / j - itemInfo.offset) / (itemInfo.widthFactor + f);
    paramInt = (int)((j + k) * f);
    this.mCalledSuper = false;
    onPageScrolled(i, f, paramInt);
    if (!this.mCalledSuper)
      throw new IllegalStateException("onPageScrolled did not call superclass implementation"); 
    return true;
  }
  
  private boolean performDrag(float paramFloat) {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool = false;
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = getScrollX() + f1 - paramFloat;
    int i = getClientWidth();
    paramFloat = i * this.mFirstOffset;
    f1 = i * this.mLastOffset;
    boolean bool1 = true;
    boolean bool2 = true;
    ItemInfo itemInfo1 = this.mItems.get(0);
    ItemInfo itemInfo2 = this.mItems.get(this.mItems.size() - 1);
    if (itemInfo1.position != 0) {
      bool1 = false;
      paramFloat = itemInfo1.offset * i;
    } 
    if (itemInfo2.position != this.mAdapter.getCount() - 1) {
      bool2 = false;
      f1 = itemInfo2.offset * i;
    } 
    if (f2 < paramFloat) {
      if (bool1)
        bool = this.mLeftEdge.onPull(Math.abs(paramFloat - f2) / i); 
      this.mLastMotionX += paramFloat - (int)paramFloat;
      scrollTo((int)paramFloat, getScrollY());
      pageScrolled((int)paramFloat);
      return bool;
    } 
    bool = bool4;
    paramFloat = f2;
    if (f2 > f1) {
      bool = bool3;
      if (bool2)
        bool = this.mRightEdge.onPull(Math.abs(f2 - f1) / i); 
      paramFloat = f1;
    } 
    this.mLastMotionX += paramFloat - (int)paramFloat;
    scrollTo((int)paramFloat, getScrollY());
    pageScrolled((int)paramFloat);
    return bool;
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f;
    if (paramInt2 > 0 && !this.mItems.isEmpty()) {
      if (!this.mScroller.isFinished()) {
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
      } 
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      f = getScrollX() / (paramInt2 - k - m + paramInt4);
      scrollTo((int)((paramInt1 - i - j + paramInt3) * f), getScrollY());
      return;
    } 
    ItemInfo itemInfo = infoForPosition(this.mCurItem);
    if (itemInfo != null) {
      f = Math.min(itemInfo.offset, this.mLastOffset);
    } else {
      f = 0.0F;
    } 
    paramInt1 = (int)((paramInt1 - getPaddingLeft() - getPaddingRight()) * f);
    if (paramInt1 != getScrollX()) {
      completeScroll(false);
      scrollTo(paramInt1, getScrollY());
      return;
    } 
  }
  
  private void removeNonDecorViews() {
    for (int i = 0; i < getChildCount(); i = j + 1) {
      int j = i;
      if (!((LayoutParams)getChildAt(i).getLayoutParams()).isDecor) {
        removeViewAt(i);
        j = i - 1;
      } 
    } 
  }
  
  private void requestParentDisallowInterceptTouchEvent(boolean paramBoolean) {
    ViewParent viewParent = getParent();
    if (viewParent != null)
      viewParent.requestDisallowInterceptTouchEvent(paramBoolean); 
  }
  
  private boolean resetTouch() {
    this.mActivePointerId = -1;
    endDrag();
    return this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2) {
    ItemInfo itemInfo = infoForPosition(paramInt1);
    int i = 0;
    if (itemInfo != null)
      i = (int)(getClientWidth() * Math.max(this.mFirstOffset, Math.min(itemInfo.offset, this.mLastOffset))); 
    if (paramBoolean1) {
      smoothScrollTo(i, 0, paramInt2);
      if (paramBoolean2)
        dispatchOnPageSelected(paramInt1); 
      return;
    } 
    if (paramBoolean2)
      dispatchOnPageSelected(paramInt1); 
    completeScroll(false);
    scrollTo(i, 0);
    pageScrolled(i);
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean) {
    if (this.mScrollingCacheEnabled != paramBoolean)
      this.mScrollingCacheEnabled = paramBoolean; 
  }
  
  private void sortChildDrawingOrder() {
    if (this.mDrawingOrder != 0) {
      if (this.mDrawingOrderedChildren == null) {
        this.mDrawingOrderedChildren = new ArrayList<View>();
      } else {
        this.mDrawingOrderedChildren.clear();
      } 
      int j = getChildCount();
      for (int i = 0; i < j; i++) {
        View view = getChildAt(i);
        this.mDrawingOrderedChildren.add(view);
      } 
      Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
    } 
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2) {
    int i = paramArrayList.size();
    int j = getDescendantFocusability();
    if (j != 393216) {
      int k;
      for (k = 0; k < getChildCount(); k++) {
        View view = getChildAt(k);
        if (view.getVisibility() == 0) {
          ItemInfo itemInfo = infoForChild(view);
          if (itemInfo != null && itemInfo.position == this.mCurItem)
            view.addFocusables(paramArrayList, paramInt1, paramInt2); 
        } 
      } 
    } 
    if ((j != 262144 || i == paramArrayList.size()) && isFocusable() && ((paramInt2 & 0x1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && paramArrayList != null) {
      paramArrayList.add(this);
      return;
    } 
  }
  
  ItemInfo addNewItem(int paramInt1, int paramInt2) {
    ItemInfo itemInfo = new ItemInfo();
    itemInfo.position = paramInt1;
    itemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    itemInfo.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if (paramInt2 < 0 || paramInt2 >= this.mItems.size()) {
      this.mItems.add(itemInfo);
      return itemInfo;
    } 
    this.mItems.add(paramInt2, itemInfo);
    return itemInfo;
  }
  
  public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener paramOnAdapterChangeListener) {
    if (this.mAdapterChangeListeners == null)
      this.mAdapterChangeListeners = new ArrayList<OnAdapterChangeListener>(); 
    this.mAdapterChangeListeners.add(paramOnAdapterChangeListener);
  }
  
  public void addOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    if (this.mOnPageChangeListeners == null)
      this.mOnPageChangeListeners = new ArrayList<OnPageChangeListener>(); 
    this.mOnPageChangeListeners.add(paramOnPageChangeListener);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList) {
    for (int i = 0; i < getChildCount(); i++) {
      View view = getChildAt(i);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = infoForChild(view);
        if (itemInfo != null && itemInfo.position == this.mCurItem)
          view.addTouchables(paramArrayList); 
      } 
    } 
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    ViewGroup.LayoutParams layoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams))
      layoutParams = generateLayoutParams(paramLayoutParams); 
    paramLayoutParams = layoutParams;
    ((LayoutParams)paramLayoutParams).isDecor |= isDecorView(paramView);
    if (this.mInLayout) {
      if (paramLayoutParams != null && ((LayoutParams)paramLayoutParams).isDecor)
        throw new IllegalStateException("Cannot add pager decor view during layout"); 
      ((LayoutParams)paramLayoutParams).needsMeasure = true;
      addViewInLayout(paramView, paramInt, layoutParams);
      return;
    } 
    super.addView(paramView, paramInt, layoutParams);
  }
  
  public boolean arrowScroll(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual findFocus : ()Landroid/view/View;
    //   4: astore #6
    //   6: aload #6
    //   8: aload_0
    //   9: if_acmpne -> 108
    //   12: aconst_null
    //   13: astore #5
    //   15: iconst_0
    //   16: istore #4
    //   18: invokestatic getInstance : ()Landroid/view/FocusFinder;
    //   21: aload_0
    //   22: aload #5
    //   24: iload_1
    //   25: invokevirtual findNextFocus : (Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    //   28: astore #6
    //   30: aload #6
    //   32: ifnull -> 343
    //   35: aload #6
    //   37: aload #5
    //   39: if_acmpeq -> 343
    //   42: iload_1
    //   43: bipush #17
    //   45: if_icmpne -> 280
    //   48: aload_0
    //   49: aload_0
    //   50: getfield mTempRect : Landroid/graphics/Rect;
    //   53: aload #6
    //   55: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   58: getfield left : I
    //   61: istore_2
    //   62: aload_0
    //   63: aload_0
    //   64: getfield mTempRect : Landroid/graphics/Rect;
    //   67: aload #5
    //   69: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   72: getfield left : I
    //   75: istore_3
    //   76: aload #5
    //   78: ifnull -> 270
    //   81: iload_2
    //   82: iload_3
    //   83: if_icmplt -> 270
    //   86: aload_0
    //   87: invokevirtual pageLeft : ()Z
    //   90: istore #4
    //   92: iload #4
    //   94: ifeq -> 105
    //   97: aload_0
    //   98: iload_1
    //   99: invokestatic getContantForFocusDirection : (I)I
    //   102: invokevirtual playSoundEffect : (I)V
    //   105: iload #4
    //   107: ireturn
    //   108: aload #6
    //   110: astore #5
    //   112: aload #6
    //   114: ifnull -> 15
    //   117: iconst_0
    //   118: istore_3
    //   119: aload #6
    //   121: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   124: astore #5
    //   126: iload_3
    //   127: istore_2
    //   128: aload #5
    //   130: instanceof android/view/ViewGroup
    //   133: ifeq -> 144
    //   136: aload #5
    //   138: aload_0
    //   139: if_acmpne -> 222
    //   142: iconst_1
    //   143: istore_2
    //   144: aload #6
    //   146: astore #5
    //   148: iload_2
    //   149: ifne -> 15
    //   152: new java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial <init> : ()V
    //   159: astore #7
    //   161: aload #7
    //   163: aload #6
    //   165: invokevirtual getClass : ()Ljava/lang/Class;
    //   168: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload #6
    //   177: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   180: astore #5
    //   182: aload #5
    //   184: instanceof android/view/ViewGroup
    //   187: ifeq -> 234
    //   190: aload #7
    //   192: ldc_w ' => '
    //   195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload #5
    //   200: invokevirtual getClass : ()Ljava/lang/Class;
    //   203: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   206: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload #5
    //   212: invokeinterface getParent : ()Landroid/view/ViewParent;
    //   217: astore #5
    //   219: goto -> 182
    //   222: aload #5
    //   224: invokeinterface getParent : ()Landroid/view/ViewParent;
    //   229: astore #5
    //   231: goto -> 126
    //   234: ldc 'ViewPager'
    //   236: new java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial <init> : ()V
    //   243: ldc_w 'arrowScroll tried to find focus based on non-child current focused view '
    //   246: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload #7
    //   251: invokevirtual toString : ()Ljava/lang/String;
    //   254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual toString : ()Ljava/lang/String;
    //   260: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   263: pop
    //   264: aconst_null
    //   265: astore #5
    //   267: goto -> 15
    //   270: aload #6
    //   272: invokevirtual requestFocus : ()Z
    //   275: istore #4
    //   277: goto -> 92
    //   280: iload_1
    //   281: bipush #66
    //   283: if_icmpne -> 92
    //   286: aload_0
    //   287: aload_0
    //   288: getfield mTempRect : Landroid/graphics/Rect;
    //   291: aload #6
    //   293: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   296: getfield left : I
    //   299: istore_2
    //   300: aload_0
    //   301: aload_0
    //   302: getfield mTempRect : Landroid/graphics/Rect;
    //   305: aload #5
    //   307: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   310: getfield left : I
    //   313: istore_3
    //   314: aload #5
    //   316: ifnull -> 333
    //   319: iload_2
    //   320: iload_3
    //   321: if_icmpgt -> 333
    //   324: aload_0
    //   325: invokevirtual pageRight : ()Z
    //   328: istore #4
    //   330: goto -> 92
    //   333: aload #6
    //   335: invokevirtual requestFocus : ()Z
    //   338: istore #4
    //   340: goto -> 92
    //   343: iload_1
    //   344: bipush #17
    //   346: if_icmpeq -> 354
    //   349: iload_1
    //   350: iconst_1
    //   351: if_icmpne -> 363
    //   354: aload_0
    //   355: invokevirtual pageLeft : ()Z
    //   358: istore #4
    //   360: goto -> 92
    //   363: iload_1
    //   364: bipush #66
    //   366: if_icmpeq -> 374
    //   369: iload_1
    //   370: iconst_2
    //   371: if_icmpne -> 92
    //   374: aload_0
    //   375: invokevirtual pageRight : ()Z
    //   378: istore #4
    //   380: goto -> 92
  }
  
  public boolean beginFakeDrag() {
    if (this.mIsBeingDragged)
      return false; 
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionX = 0.0F;
    this.mInitialMotionX = 0.0F;
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
      long l1 = SystemClock.uptimeMillis();
      MotionEvent motionEvent1 = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
      this.mVelocityTracker.addMovement(motionEvent1);
      motionEvent1.recycle();
      this.mFakeDragBeginTime = l1;
      return true;
    } 
    this.mVelocityTracker.clear();
    long l = SystemClock.uptimeMillis();
    MotionEvent motionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
    this.mVelocityTracker.addMovement(motionEvent);
    motionEvent.recycle();
    this.mFakeDragBeginTime = l;
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
    return (paramBoolean && ViewCompat.canScrollHorizontally(paramView, -paramInt1));
  }
  
  public boolean canScrollHorizontally(int paramInt) {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.mAdapter != null) {
      int i = getClientWidth();
      int j = getScrollX();
      if (paramInt < 0) {
        if (j <= (int)(i * this.mFirstOffset))
          bool1 = false; 
        return bool1;
      } 
      if (paramInt > 0)
        return (j < (int)(i * this.mLastOffset)) ? bool2 : false; 
    } 
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams && super.checkLayoutParams(paramLayoutParams));
  }
  
  public void clearOnPageChangeListeners() {
    if (this.mOnPageChangeListeners != null)
      this.mOnPageChangeListeners.clear(); 
  }
  
  public void computeScroll() {
    this.mIsScrollStarted = true;
    if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      if (i != k || j != m) {
        scrollTo(k, m);
        if (!pageScrolled(k)) {
          this.mScroller.abortAnimation();
          scrollTo(0, m);
        } 
      } 
      ViewCompat.postInvalidateOnAnimation((View)this);
      return;
    } 
    completeScroll(true);
  }
  
  void dataSetChanged() {
    int i;
    int n = this.mAdapter.getCount();
    this.mExpectedAdapterCount = n;
    if (this.mItems.size() < this.mOffscreenPageLimit * 2 + 1 && this.mItems.size() < n) {
      i = 1;
    } else {
      i = 0;
    } 
    int j = this.mCurItem;
    int k = 0;
    int m = 0;
    while (m < this.mItems.size()) {
      int i1;
      int i2;
      int i3;
      ItemInfo itemInfo = this.mItems.get(m);
      int i4 = this.mAdapter.getItemPosition(itemInfo.object);
      if (i4 == -1) {
        i1 = j;
        i2 = k;
        i3 = m;
      } else if (i4 == -2) {
        this.mItems.remove(m);
        i4 = m - 1;
        m = k;
        if (!k) {
          this.mAdapter.startUpdate(this);
          m = 1;
        } 
        this.mAdapter.destroyItem(this, itemInfo.position, itemInfo.object);
        i = 1;
        i3 = i4;
        i2 = m;
        i1 = j;
        if (this.mCurItem == itemInfo.position) {
          i1 = Math.max(0, Math.min(this.mCurItem, n - 1));
          i = 1;
          i3 = i4;
          i2 = m;
        } 
      } else {
        i3 = m;
        i2 = k;
        i1 = j;
        if (itemInfo.position != i4) {
          if (itemInfo.position == this.mCurItem)
            j = i4; 
          itemInfo.position = i4;
          i = 1;
          i3 = m;
          i2 = k;
          i1 = j;
        } 
      } 
      m = i3 + 1;
      k = i2;
      j = i1;
    } 
    if (k != 0)
      this.mAdapter.finishUpdate(this); 
    Collections.sort(this.mItems, COMPARATOR);
    if (i) {
      k = getChildCount();
      for (i = 0; i < k; i++) {
        LayoutParams layoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        if (!layoutParams.isDecor)
          layoutParams.widthFactor = 0.0F; 
      } 
      setCurrentItemInternal(j, false, true);
      requestLayout();
    } 
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return (super.dispatchKeyEvent(paramKeyEvent) || executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    if (paramAccessibilityEvent.getEventType() == 4096)
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent); 
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = infoForChild(view);
        if (itemInfo != null && itemInfo.position == this.mCurItem && view.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))
          return true; 
      } 
    } 
    return false;
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat) {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  public void draw(Canvas paramCanvas) {
    boolean bool;
    super.draw(paramCanvas);
    int j = 0;
    int i = 0;
    int k = getOverScrollMode();
    if (k == 0 || (k == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
      if (!this.mLeftEdge.isFinished()) {
        j = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        k = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate((-i + getPaddingTop()), this.mFirstOffset * k);
        this.mLeftEdge.setSize(i, k);
        i = false | this.mLeftEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(j);
      } 
      j = i;
      if (!this.mRightEdge.isFinished()) {
        k = paramCanvas.save();
        j = getWidth();
        int m = getHeight();
        int n = getPaddingTop();
        int i1 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.mLastOffset + 1.0F) * j);
        this.mRightEdge.setSize(m - n - i1, j);
        bool = i | this.mRightEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(k);
      } 
    } else {
      this.mLeftEdge.finish();
      this.mRightEdge.finish();
    } 
    if (bool)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    Drawable drawable = this.mMarginDrawable;
    if (drawable != null && drawable.isStateful())
      drawable.setState(getDrawableState()); 
  }
  
  public void endFakeDrag() {
    if (!this.mFakeDragging)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first."); 
    if (this.mAdapter != null) {
      VelocityTracker velocityTracker = this.mVelocityTracker;
      velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
      int i = (int)VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
      this.mPopulatePending = true;
      int j = getClientWidth();
      int k = getScrollX();
      ItemInfo itemInfo = infoForCurrentScrollPosition();
      setCurrentItemInternal(determineTargetPage(itemInfo.position, (k / j - itemInfo.offset) / itemInfo.widthFactor, i, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, i);
    } 
    endDrag();
    this.mFakeDragging = false;
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode()) {
        default:
          return false;
        case 21:
          return arrowScroll(17);
        case 22:
          return arrowScroll(66);
        case 61:
          break;
      } 
      if (Build.VERSION.SDK_INT >= 11) {
        if (KeyEventCompat.hasNoModifiers(paramKeyEvent))
          return arrowScroll(2); 
        if (KeyEventCompat.hasModifiers(paramKeyEvent, 1))
          return arrowScroll(1); 
      } 
    } 
  }
  
  public void fakeDragBy(float paramFloat) {
    if (!this.mFakeDragging)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first."); 
    if (this.mAdapter == null)
      return; 
    this.mLastMotionX += paramFloat;
    float f2 = getScrollX() - paramFloat;
    int i = getClientWidth();
    paramFloat = i * this.mFirstOffset;
    float f1 = i * this.mLastOffset;
    ItemInfo itemInfo1 = this.mItems.get(0);
    ItemInfo itemInfo2 = this.mItems.get(this.mItems.size() - 1);
    if (itemInfo1.position != 0)
      paramFloat = itemInfo1.offset * i; 
    if (itemInfo2.position != this.mAdapter.getCount() - 1)
      f1 = itemInfo2.offset * i; 
    if (f2 >= paramFloat) {
      paramFloat = f2;
      if (f2 > f1)
        paramFloat = f1; 
    } 
    this.mLastMotionX += paramFloat - (int)paramFloat;
    scrollTo((int)paramFloat, getScrollY());
    pageScrolled((int)paramFloat);
    long l = SystemClock.uptimeMillis();
    MotionEvent motionEvent = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
    this.mVelocityTracker.addMovement(motionEvent);
    motionEvent.recycle();
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter() {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    if (this.mDrawingOrder == 2) {
      paramInt1 = paramInt1 - 1 - paramInt2;
      return ((LayoutParams)((View)this.mDrawingOrderedChildren.get(paramInt1)).getLayoutParams()).childIndex;
    } 
    paramInt1 = paramInt2;
    return ((LayoutParams)((View)this.mDrawingOrderedChildren.get(paramInt1)).getLayoutParams()).childIndex;
  }
  
  public int getCurrentItem() {
    return this.mCurItem;
  }
  
  public int getOffscreenPageLimit() {
    return this.mOffscreenPageLimit;
  }
  
  public int getPageMargin() {
    return this.mPageMargin;
  }
  
  ItemInfo infoForAnyChild(View paramView) {
    while (true) {
      ViewParent viewParent = paramView.getParent();
      if (viewParent != this) {
        if (viewParent == null || !(viewParent instanceof View))
          return null; 
        paramView = (View)viewParent;
        continue;
      } 
      return infoForChild(paramView);
    } 
  }
  
  ItemInfo infoForChild(View paramView) {
    for (int i = 0; i < this.mItems.size(); i++) {
      ItemInfo itemInfo = this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, itemInfo.object))
        return itemInfo; 
    } 
    return null;
  }
  
  ItemInfo infoForPosition(int paramInt) {
    for (int i = 0; i < this.mItems.size(); i++) {
      ItemInfo itemInfo = this.mItems.get(i);
      if (itemInfo.position == paramInt)
        return itemInfo; 
    } 
    return null;
  }
  
  void initViewPager() {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context context = getContext();
    this.mScroller = new Scroller(context, sInterpolator);
    ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
    float f = (context.getResources().getDisplayMetrics()).density;
    this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
    this.mMinimumVelocity = (int)(400.0F * f);
    this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new EdgeEffectCompat(context);
    this.mRightEdge = new EdgeEffectCompat(context);
    this.mFlingDistance = (int)(25.0F * f);
    this.mCloseEnough = (int)(2.0F * f);
    this.mDefaultGutterSize = (int)(16.0F * f);
    ViewCompat.setAccessibilityDelegate((View)this, new MyAccessibilityDelegate());
    if (ViewCompat.getImportantForAccessibility((View)this) == 0)
      ViewCompat.setImportantForAccessibility((View)this, 1); 
    ViewCompat.setOnApplyWindowInsetsListener((View)this, new OnApplyWindowInsetsListener() {
          private final Rect mTempRect = new Rect();
          
          public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
            WindowInsetsCompat windowInsetsCompat = ViewCompat.onApplyWindowInsets(param1View, param1WindowInsetsCompat);
            if (windowInsetsCompat.isConsumed())
              return windowInsetsCompat; 
            Rect rect = this.mTempRect;
            rect.left = windowInsetsCompat.getSystemWindowInsetLeft();
            rect.top = windowInsetsCompat.getSystemWindowInsetTop();
            rect.right = windowInsetsCompat.getSystemWindowInsetRight();
            rect.bottom = windowInsetsCompat.getSystemWindowInsetBottom();
            int i = 0;
            int j = ViewPager.this.getChildCount();
            while (i < j) {
              WindowInsetsCompat windowInsetsCompat1 = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i), windowInsetsCompat);
              rect.left = Math.min(windowInsetsCompat1.getSystemWindowInsetLeft(), rect.left);
              rect.top = Math.min(windowInsetsCompat1.getSystemWindowInsetTop(), rect.top);
              rect.right = Math.min(windowInsetsCompat1.getSystemWindowInsetRight(), rect.right);
              rect.bottom = Math.min(windowInsetsCompat1.getSystemWindowInsetBottom(), rect.bottom);
              i++;
            } 
            return windowInsetsCompat.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
          }
        });
  }
  
  public boolean isFakeDragging() {
    return this.mFakeDragging;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow() {
    removeCallbacks(this.mEndScrollRunnable);
    if (this.mScroller != null && !this.mScroller.isFinished())
      this.mScroller.abortAnimation(); 
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
      int k = getScrollX();
      int m = getWidth();
      float f2 = this.mPageMargin / m;
      int j = 0;
      ItemInfo itemInfo = this.mItems.get(0);
      float f1 = itemInfo.offset;
      int n = this.mItems.size();
      int i = itemInfo.position;
      int i1 = ((ItemInfo)this.mItems.get(n - 1)).position;
      while (true) {
        if (i < i1) {
          float f;
          ItemInfo itemInfo1;
          while (i > itemInfo.position && j < n) {
            ArrayList<ItemInfo> arrayList = this.mItems;
            itemInfo1 = arrayList.get(++j);
          } 
          if (i == itemInfo1.position) {
            f = (itemInfo1.offset + itemInfo1.widthFactor) * m;
            f1 = itemInfo1.offset + itemInfo1.widthFactor + f2;
          } else {
            float f3 = this.mAdapter.getPageWidth(i);
            f = (f1 + f3) * m;
            f1 += f3 + f2;
          } 
          if (this.mPageMargin + f > k) {
            this.mMarginDrawable.setBounds(Math.round(f), this.mTopPageBounds, Math.round(this.mPageMargin + f), this.mBottomPageBounds);
            this.mMarginDrawable.draw(paramCanvas);
          } 
          if (f <= (k + m)) {
            i++;
            continue;
          } 
        } 
        return;
      } 
    } 
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    float f;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 3 || i == 1) {
      resetTouch();
      return false;
    } 
    if (i != 0) {
      if (this.mIsBeingDragged)
        return true; 
      if (this.mIsUnableToDrag)
        return false; 
    } 
    switch (i) {
      default:
        if (this.mVelocityTracker == null)
          this.mVelocityTracker = VelocityTracker.obtain(); 
        this.mVelocityTracker.addMovement(paramMotionEvent);
        return this.mIsBeingDragged;
      case 2:
        i = this.mActivePointerId;
        if (i != -1) {
          i = paramMotionEvent.findPointerIndex(i);
          float f2 = paramMotionEvent.getX(i);
          float f1 = f2 - this.mLastMotionX;
          float f4 = Math.abs(f1);
          float f3 = paramMotionEvent.getY(i);
          float f5 = Math.abs(f3 - this.mInitialMotionY);
          if (f1 != 0.0F && !isGutterDrag(this.mLastMotionX, f1) && canScroll((View)this, false, (int)f1, (int)f2, (int)f3)) {
            this.mLastMotionX = f2;
            this.mLastMotionY = f3;
            this.mIsUnableToDrag = true;
            return false;
          } 
          if (f4 > this.mTouchSlop && 0.5F * f4 > f5) {
            this.mIsBeingDragged = true;
            requestParentDisallowInterceptTouchEvent(true);
            setScrollState(1);
            if (f1 > 0.0F) {
              f1 = this.mInitialMotionX + this.mTouchSlop;
            } else {
              f1 = this.mInitialMotionX - this.mTouchSlop;
            } 
            this.mLastMotionX = f1;
            this.mLastMotionY = f3;
            setScrollingCacheEnabled(true);
          } else if (f5 > this.mTouchSlop) {
            this.mIsUnableToDrag = true;
          } 
          if (this.mIsBeingDragged && performDrag(f2))
            ViewCompat.postInvalidateOnAnimation((View)this); 
        } 
      case 0:
        f = paramMotionEvent.getX();
        this.mInitialMotionX = f;
        this.mLastMotionX = f;
        f = paramMotionEvent.getY();
        this.mInitialMotionY = f;
        this.mLastMotionY = f;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mIsUnableToDrag = false;
        this.mIsScrollStarted = true;
        this.mScroller.computeScrollOffset();
        if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
          this.mScroller.abortAnimation();
          this.mPopulatePending = false;
          populate();
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
        } else {
          completeScroll(false);
          this.mIsBeingDragged = false;
        } 
      case 6:
        break;
    } 
    onSecondaryPointerUp(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getChildCount : ()I
    //   4: istore #13
    //   6: iload #4
    //   8: iload_2
    //   9: isub
    //   10: istore #15
    //   12: iload #5
    //   14: iload_3
    //   15: isub
    //   16: istore #14
    //   18: aload_0
    //   19: invokevirtual getPaddingLeft : ()I
    //   22: istore_3
    //   23: aload_0
    //   24: invokevirtual getPaddingTop : ()I
    //   27: istore_2
    //   28: aload_0
    //   29: invokevirtual getPaddingRight : ()I
    //   32: istore #6
    //   34: aload_0
    //   35: invokevirtual getPaddingBottom : ()I
    //   38: istore #5
    //   40: aload_0
    //   41: invokevirtual getScrollX : ()I
    //   44: istore #16
    //   46: iconst_0
    //   47: istore #8
    //   49: iconst_0
    //   50: istore #9
    //   52: iload #9
    //   54: iload #13
    //   56: if_icmpge -> 426
    //   59: aload_0
    //   60: iload #9
    //   62: invokevirtual getChildAt : (I)Landroid/view/View;
    //   65: astore #17
    //   67: iload #8
    //   69: istore #12
    //   71: iload #5
    //   73: istore #11
    //   75: iload_3
    //   76: istore #7
    //   78: iload #6
    //   80: istore #10
    //   82: iload_2
    //   83: istore #4
    //   85: aload #17
    //   87: invokevirtual getVisibility : ()I
    //   90: bipush #8
    //   92: if_icmpeq -> 277
    //   95: aload #17
    //   97: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   100: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   103: astore #18
    //   105: iload #8
    //   107: istore #12
    //   109: iload #5
    //   111: istore #11
    //   113: iload_3
    //   114: istore #7
    //   116: iload #6
    //   118: istore #10
    //   120: iload_2
    //   121: istore #4
    //   123: aload #18
    //   125: getfield isDecor : Z
    //   128: ifeq -> 277
    //   131: aload #18
    //   133: getfield gravity : I
    //   136: istore #4
    //   138: aload #18
    //   140: getfield gravity : I
    //   143: istore #10
    //   145: iload #4
    //   147: bipush #7
    //   149: iand
    //   150: tableswitch default -> 184, 1 -> 319, 2 -> 184, 3 -> 304, 4 -> 184, 5 -> 341
    //   184: iload_3
    //   185: istore #4
    //   187: iload_3
    //   188: istore #7
    //   190: iload #10
    //   192: bipush #112
    //   194: iand
    //   195: lookupswitch default -> 228, 16 -> 383, 48 -> 370, 80 -> 401
    //   228: iload_2
    //   229: istore_3
    //   230: iload #4
    //   232: iload #16
    //   234: iadd
    //   235: istore #4
    //   237: aload #17
    //   239: iload #4
    //   241: iload_3
    //   242: aload #17
    //   244: invokevirtual getMeasuredWidth : ()I
    //   247: iload #4
    //   249: iadd
    //   250: aload #17
    //   252: invokevirtual getMeasuredHeight : ()I
    //   255: iload_3
    //   256: iadd
    //   257: invokevirtual layout : (IIII)V
    //   260: iload #8
    //   262: iconst_1
    //   263: iadd
    //   264: istore #12
    //   266: iload_2
    //   267: istore #4
    //   269: iload #6
    //   271: istore #10
    //   273: iload #5
    //   275: istore #11
    //   277: iload #9
    //   279: iconst_1
    //   280: iadd
    //   281: istore #9
    //   283: iload #12
    //   285: istore #8
    //   287: iload #11
    //   289: istore #5
    //   291: iload #7
    //   293: istore_3
    //   294: iload #10
    //   296: istore #6
    //   298: iload #4
    //   300: istore_2
    //   301: goto -> 52
    //   304: iload_3
    //   305: istore #4
    //   307: iload_3
    //   308: aload #17
    //   310: invokevirtual getMeasuredWidth : ()I
    //   313: iadd
    //   314: istore #7
    //   316: goto -> 190
    //   319: iload #15
    //   321: aload #17
    //   323: invokevirtual getMeasuredWidth : ()I
    //   326: isub
    //   327: iconst_2
    //   328: idiv
    //   329: iload_3
    //   330: invokestatic max : (II)I
    //   333: istore #4
    //   335: iload_3
    //   336: istore #7
    //   338: goto -> 190
    //   341: iload #15
    //   343: iload #6
    //   345: isub
    //   346: aload #17
    //   348: invokevirtual getMeasuredWidth : ()I
    //   351: isub
    //   352: istore #4
    //   354: iload #6
    //   356: aload #17
    //   358: invokevirtual getMeasuredWidth : ()I
    //   361: iadd
    //   362: istore #6
    //   364: iload_3
    //   365: istore #7
    //   367: goto -> 190
    //   370: iload_2
    //   371: istore_3
    //   372: iload_2
    //   373: aload #17
    //   375: invokevirtual getMeasuredHeight : ()I
    //   378: iadd
    //   379: istore_2
    //   380: goto -> 230
    //   383: iload #14
    //   385: aload #17
    //   387: invokevirtual getMeasuredHeight : ()I
    //   390: isub
    //   391: iconst_2
    //   392: idiv
    //   393: iload_2
    //   394: invokestatic max : (II)I
    //   397: istore_3
    //   398: goto -> 230
    //   401: iload #14
    //   403: iload #5
    //   405: isub
    //   406: aload #17
    //   408: invokevirtual getMeasuredHeight : ()I
    //   411: isub
    //   412: istore_3
    //   413: iload #5
    //   415: aload #17
    //   417: invokevirtual getMeasuredHeight : ()I
    //   420: iadd
    //   421: istore #5
    //   423: goto -> 230
    //   426: iload #15
    //   428: iload_3
    //   429: isub
    //   430: iload #6
    //   432: isub
    //   433: istore #6
    //   435: iconst_0
    //   436: istore #4
    //   438: iload #4
    //   440: iload #13
    //   442: if_icmpge -> 588
    //   445: aload_0
    //   446: iload #4
    //   448: invokevirtual getChildAt : (I)Landroid/view/View;
    //   451: astore #17
    //   453: aload #17
    //   455: invokevirtual getVisibility : ()I
    //   458: bipush #8
    //   460: if_icmpeq -> 579
    //   463: aload #17
    //   465: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   468: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   471: astore #18
    //   473: aload #18
    //   475: getfield isDecor : Z
    //   478: ifne -> 579
    //   481: aload_0
    //   482: aload #17
    //   484: invokevirtual infoForChild : (Landroid/view/View;)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   487: astore #19
    //   489: aload #19
    //   491: ifnull -> 579
    //   494: iload_3
    //   495: iload #6
    //   497: i2f
    //   498: aload #19
    //   500: getfield offset : F
    //   503: fmul
    //   504: f2i
    //   505: iadd
    //   506: istore #7
    //   508: aload #18
    //   510: getfield needsMeasure : Z
    //   513: ifeq -> 556
    //   516: aload #18
    //   518: iconst_0
    //   519: putfield needsMeasure : Z
    //   522: aload #17
    //   524: iload #6
    //   526: i2f
    //   527: aload #18
    //   529: getfield widthFactor : F
    //   532: fmul
    //   533: f2i
    //   534: ldc_w 1073741824
    //   537: invokestatic makeMeasureSpec : (II)I
    //   540: iload #14
    //   542: iload_2
    //   543: isub
    //   544: iload #5
    //   546: isub
    //   547: ldc_w 1073741824
    //   550: invokestatic makeMeasureSpec : (II)I
    //   553: invokevirtual measure : (II)V
    //   556: aload #17
    //   558: iload #7
    //   560: iload_2
    //   561: aload #17
    //   563: invokevirtual getMeasuredWidth : ()I
    //   566: iload #7
    //   568: iadd
    //   569: aload #17
    //   571: invokevirtual getMeasuredHeight : ()I
    //   574: iload_2
    //   575: iadd
    //   576: invokevirtual layout : (IIII)V
    //   579: iload #4
    //   581: iconst_1
    //   582: iadd
    //   583: istore #4
    //   585: goto -> 438
    //   588: aload_0
    //   589: iload_2
    //   590: putfield mTopPageBounds : I
    //   593: aload_0
    //   594: iload #14
    //   596: iload #5
    //   598: isub
    //   599: putfield mBottomPageBounds : I
    //   602: aload_0
    //   603: iload #8
    //   605: putfield mDecorChildCount : I
    //   608: aload_0
    //   609: getfield mFirstLayout : Z
    //   612: ifeq -> 626
    //   615: aload_0
    //   616: aload_0
    //   617: getfield mCurItem : I
    //   620: iconst_0
    //   621: iconst_0
    //   622: iconst_0
    //   623: invokespecial scrollToItem : (IZIZ)V
    //   626: aload_0
    //   627: iconst_0
    //   628: putfield mFirstLayout : Z
    //   631: return
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.mGutterSize = Math.min(paramInt1 / 10, this.mDefaultGutterSize);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int k = getChildCount();
    int j = 0;
    while (j < k) {
      View view = getChildAt(j);
      int m = paramInt2;
      int n = paramInt1;
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        m = paramInt2;
        n = paramInt1;
        if (layoutParams != null) {
          m = paramInt2;
          n = paramInt1;
          if (layoutParams.isDecor) {
            boolean bool;
            n = layoutParams.gravity & 0x7;
            int i1 = layoutParams.gravity & 0x70;
            int i2 = Integer.MIN_VALUE;
            m = Integer.MIN_VALUE;
            if (i1 == 48 || i1 == 80) {
              i1 = 1;
            } else {
              i1 = 0;
            } 
            if (n == 3 || n == 5) {
              bool = true;
            } else {
              bool = false;
            } 
            if (i1 != 0) {
              n = 1073741824;
            } else {
              n = i2;
              if (bool) {
                m = 1073741824;
                n = i2;
              } 
            } 
            int i4 = paramInt1;
            i2 = paramInt2;
            int i3 = i4;
            if (layoutParams.width != -2) {
              int i5 = 1073741824;
              n = i5;
              i3 = i4;
              if (layoutParams.width != -1) {
                i3 = layoutParams.width;
                n = i5;
              } 
            } 
            i4 = i2;
            if (layoutParams.height != -2) {
              int i5 = 1073741824;
              m = i5;
              i4 = i2;
              if (layoutParams.height != -1) {
                i4 = layoutParams.height;
                m = i5;
              } 
            } 
            view.measure(View.MeasureSpec.makeMeasureSpec(i3, n), View.MeasureSpec.makeMeasureSpec(i4, m));
            if (i1 != 0) {
              m = paramInt2 - view.getMeasuredHeight();
              n = paramInt1;
            } else {
              m = paramInt2;
              n = paramInt1;
              if (bool) {
                n = paramInt1 - view.getMeasuredWidth();
                m = paramInt2;
              } 
            } 
          } 
        } 
      } 
      j++;
      paramInt2 = m;
      paramInt1 = n;
    } 
    this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    this.mInLayout = true;
    populate();
    this.mInLayout = false;
    int i = getChildCount();
    for (paramInt2 = 0; paramInt2 < i; paramInt2++) {
      View view = getChildAt(paramInt2);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams == null || !layoutParams.isDecor)
          view.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * layoutParams.widthFactor), 1073741824), this.mChildHeightMeasureSpec); 
      } 
    } 
  }
  
  @CallSuper
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mDecorChildCount : I
    //   4: ifle -> 251
    //   7: aload_0
    //   8: invokevirtual getScrollX : ()I
    //   11: istore #9
    //   13: aload_0
    //   14: invokevirtual getPaddingLeft : ()I
    //   17: istore #4
    //   19: aload_0
    //   20: invokevirtual getPaddingRight : ()I
    //   23: istore #6
    //   25: aload_0
    //   26: invokevirtual getWidth : ()I
    //   29: istore #10
    //   31: aload_0
    //   32: invokevirtual getChildCount : ()I
    //   35: istore #11
    //   37: iconst_0
    //   38: istore #7
    //   40: iload #7
    //   42: iload #11
    //   44: if_icmpge -> 251
    //   47: aload_0
    //   48: iload #7
    //   50: invokevirtual getChildAt : (I)Landroid/view/View;
    //   53: astore #13
    //   55: aload #13
    //   57: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   60: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   63: astore #14
    //   65: aload #14
    //   67: getfield isDecor : Z
    //   70: ifne -> 98
    //   73: iload #6
    //   75: istore #5
    //   77: iload #4
    //   79: istore #8
    //   81: iload #7
    //   83: iconst_1
    //   84: iadd
    //   85: istore #7
    //   87: iload #8
    //   89: istore #4
    //   91: iload #5
    //   93: istore #6
    //   95: goto -> 40
    //   98: aload #14
    //   100: getfield gravity : I
    //   103: bipush #7
    //   105: iand
    //   106: tableswitch default -> 140, 1 -> 205, 2 -> 140, 3 -> 188, 4 -> 140, 5 -> 225
    //   140: iload #4
    //   142: istore #5
    //   144: iload #5
    //   146: iload #9
    //   148: iadd
    //   149: aload #13
    //   151: invokevirtual getLeft : ()I
    //   154: isub
    //   155: istore #12
    //   157: iload #4
    //   159: istore #8
    //   161: iload #6
    //   163: istore #5
    //   165: iload #12
    //   167: ifeq -> 81
    //   170: aload #13
    //   172: iload #12
    //   174: invokevirtual offsetLeftAndRight : (I)V
    //   177: iload #4
    //   179: istore #8
    //   181: iload #6
    //   183: istore #5
    //   185: goto -> 81
    //   188: iload #4
    //   190: istore #5
    //   192: iload #4
    //   194: aload #13
    //   196: invokevirtual getWidth : ()I
    //   199: iadd
    //   200: istore #4
    //   202: goto -> 144
    //   205: iload #10
    //   207: aload #13
    //   209: invokevirtual getMeasuredWidth : ()I
    //   212: isub
    //   213: iconst_2
    //   214: idiv
    //   215: iload #4
    //   217: invokestatic max : (II)I
    //   220: istore #5
    //   222: goto -> 144
    //   225: iload #10
    //   227: iload #6
    //   229: isub
    //   230: aload #13
    //   232: invokevirtual getMeasuredWidth : ()I
    //   235: isub
    //   236: istore #5
    //   238: iload #6
    //   240: aload #13
    //   242: invokevirtual getMeasuredWidth : ()I
    //   245: iadd
    //   246: istore #6
    //   248: goto -> 144
    //   251: aload_0
    //   252: iload_1
    //   253: fload_2
    //   254: iload_3
    //   255: invokespecial dispatchOnPageScrolled : (IFI)V
    //   258: aload_0
    //   259: getfield mPageTransformer : Landroid/support/v4/view/ViewPager$PageTransformer;
    //   262: ifnull -> 342
    //   265: aload_0
    //   266: invokevirtual getScrollX : ()I
    //   269: istore_3
    //   270: aload_0
    //   271: invokevirtual getChildCount : ()I
    //   274: istore #4
    //   276: iconst_0
    //   277: istore_1
    //   278: iload_1
    //   279: iload #4
    //   281: if_icmpge -> 342
    //   284: aload_0
    //   285: iload_1
    //   286: invokevirtual getChildAt : (I)Landroid/view/View;
    //   289: astore #13
    //   291: aload #13
    //   293: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   296: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   299: getfield isDecor : Z
    //   302: ifeq -> 312
    //   305: iload_1
    //   306: iconst_1
    //   307: iadd
    //   308: istore_1
    //   309: goto -> 278
    //   312: aload #13
    //   314: invokevirtual getLeft : ()I
    //   317: iload_3
    //   318: isub
    //   319: i2f
    //   320: aload_0
    //   321: invokespecial getClientWidth : ()I
    //   324: i2f
    //   325: fdiv
    //   326: fstore_2
    //   327: aload_0
    //   328: getfield mPageTransformer : Landroid/support/v4/view/ViewPager$PageTransformer;
    //   331: aload #13
    //   333: fload_2
    //   334: invokeinterface transformPage : (Landroid/view/View;F)V
    //   339: goto -> 305
    //   342: aload_0
    //   343: iconst_1
    //   344: putfield mCalledSuper : Z
    //   347: return
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) {
    int i;
    byte b;
    int j = getChildCount();
    if ((paramInt & 0x2) != 0) {
      i = 0;
      b = 1;
    } else {
      i = j - 1;
      b = -1;
      j = -1;
    } 
    while (i != j) {
      View view = getChildAt(i);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = infoForChild(view);
        if (itemInfo != null && itemInfo.position == this.mCurItem && view.requestFocus(paramInt, paramRect))
          return true; 
      } 
      i += b;
    } 
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    paramParcelable = paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.mAdapter != null) {
      this.mAdapter.restoreState(((SavedState)paramParcelable).adapterState, ((SavedState)paramParcelable).loader);
      setCurrentItemInternal(((SavedState)paramParcelable).position, false, true);
      return;
    } 
    this.mRestoredCurItem = ((SavedState)paramParcelable).position;
    this.mRestoredAdapterState = ((SavedState)paramParcelable).adapterState;
    this.mRestoredClassLoader = ((SavedState)paramParcelable).loader;
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.position = this.mCurItem;
    if (this.mAdapter != null)
      savedState.adapterState = this.mAdapter.saveState(); 
    return savedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      recomputeScrollPosition(paramInt1, paramInt3, this.mPageMargin, this.mPageMargin); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mFakeDragging : Z
    //   4: ifeq -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_1
    //   10: invokevirtual getAction : ()I
    //   13: ifne -> 25
    //   16: aload_1
    //   17: invokevirtual getEdgeFlags : ()I
    //   20: ifeq -> 25
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   29: ifnull -> 42
    //   32: aload_0
    //   33: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   36: invokevirtual getCount : ()I
    //   39: ifne -> 44
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_0
    //   45: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   48: ifnonnull -> 58
    //   51: aload_0
    //   52: invokestatic obtain : ()Landroid/view/VelocityTracker;
    //   55: putfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   58: aload_0
    //   59: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   62: aload_1
    //   63: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   66: aload_1
    //   67: invokevirtual getAction : ()I
    //   70: istore #6
    //   72: iconst_0
    //   73: istore #10
    //   75: iload #10
    //   77: istore #9
    //   79: iload #6
    //   81: sipush #255
    //   84: iand
    //   85: tableswitch default -> 128, 0 -> 143, 1 -> 411, 2 -> 205, 3 -> 553, 4 -> 132, 5 -> 584, 6 -> 617
    //   128: iload #10
    //   130: istore #9
    //   132: iload #9
    //   134: ifeq -> 141
    //   137: aload_0
    //   138: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   141: iconst_1
    //   142: ireturn
    //   143: aload_0
    //   144: getfield mScroller : Landroid/widget/Scroller;
    //   147: invokevirtual abortAnimation : ()V
    //   150: aload_0
    //   151: iconst_0
    //   152: putfield mPopulatePending : Z
    //   155: aload_0
    //   156: invokevirtual populate : ()V
    //   159: aload_1
    //   160: invokevirtual getX : ()F
    //   163: fstore_2
    //   164: aload_0
    //   165: fload_2
    //   166: putfield mInitialMotionX : F
    //   169: aload_0
    //   170: fload_2
    //   171: putfield mLastMotionX : F
    //   174: aload_1
    //   175: invokevirtual getY : ()F
    //   178: fstore_2
    //   179: aload_0
    //   180: fload_2
    //   181: putfield mInitialMotionY : F
    //   184: aload_0
    //   185: fload_2
    //   186: putfield mLastMotionY : F
    //   189: aload_0
    //   190: aload_1
    //   191: iconst_0
    //   192: invokevirtual getPointerId : (I)I
    //   195: putfield mActivePointerId : I
    //   198: iload #10
    //   200: istore #9
    //   202: goto -> 132
    //   205: aload_0
    //   206: getfield mIsBeingDragged : Z
    //   209: ifne -> 363
    //   212: aload_1
    //   213: aload_0
    //   214: getfield mActivePointerId : I
    //   217: invokevirtual findPointerIndex : (I)I
    //   220: istore #6
    //   222: iload #6
    //   224: iconst_m1
    //   225: if_icmpne -> 237
    //   228: aload_0
    //   229: invokespecial resetTouch : ()Z
    //   232: istore #9
    //   234: goto -> 132
    //   237: aload_1
    //   238: iload #6
    //   240: invokevirtual getX : (I)F
    //   243: fstore_2
    //   244: fload_2
    //   245: aload_0
    //   246: getfield mLastMotionX : F
    //   249: fsub
    //   250: invokestatic abs : (F)F
    //   253: fstore #4
    //   255: aload_1
    //   256: iload #6
    //   258: invokevirtual getY : (I)F
    //   261: fstore_3
    //   262: fload_3
    //   263: aload_0
    //   264: getfield mLastMotionY : F
    //   267: fsub
    //   268: invokestatic abs : (F)F
    //   271: fstore #5
    //   273: fload #4
    //   275: aload_0
    //   276: getfield mTouchSlop : I
    //   279: i2f
    //   280: fcmpl
    //   281: ifle -> 363
    //   284: fload #4
    //   286: fload #5
    //   288: fcmpl
    //   289: ifle -> 363
    //   292: aload_0
    //   293: iconst_1
    //   294: putfield mIsBeingDragged : Z
    //   297: aload_0
    //   298: iconst_1
    //   299: invokespecial requestParentDisallowInterceptTouchEvent : (Z)V
    //   302: fload_2
    //   303: aload_0
    //   304: getfield mInitialMotionX : F
    //   307: fsub
    //   308: fconst_0
    //   309: fcmpl
    //   310: ifle -> 397
    //   313: aload_0
    //   314: getfield mInitialMotionX : F
    //   317: aload_0
    //   318: getfield mTouchSlop : I
    //   321: i2f
    //   322: fadd
    //   323: fstore_2
    //   324: aload_0
    //   325: fload_2
    //   326: putfield mLastMotionX : F
    //   329: aload_0
    //   330: fload_3
    //   331: putfield mLastMotionY : F
    //   334: aload_0
    //   335: iconst_1
    //   336: invokevirtual setScrollState : (I)V
    //   339: aload_0
    //   340: iconst_1
    //   341: invokespecial setScrollingCacheEnabled : (Z)V
    //   344: aload_0
    //   345: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   348: astore #11
    //   350: aload #11
    //   352: ifnull -> 363
    //   355: aload #11
    //   357: iconst_1
    //   358: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   363: iload #10
    //   365: istore #9
    //   367: aload_0
    //   368: getfield mIsBeingDragged : Z
    //   371: ifeq -> 132
    //   374: iconst_0
    //   375: aload_0
    //   376: aload_1
    //   377: aload_1
    //   378: aload_0
    //   379: getfield mActivePointerId : I
    //   382: invokevirtual findPointerIndex : (I)I
    //   385: invokevirtual getX : (I)F
    //   388: invokespecial performDrag : (F)Z
    //   391: ior
    //   392: istore #9
    //   394: goto -> 132
    //   397: aload_0
    //   398: getfield mInitialMotionX : F
    //   401: aload_0
    //   402: getfield mTouchSlop : I
    //   405: i2f
    //   406: fsub
    //   407: fstore_2
    //   408: goto -> 324
    //   411: iload #10
    //   413: istore #9
    //   415: aload_0
    //   416: getfield mIsBeingDragged : Z
    //   419: ifeq -> 132
    //   422: aload_0
    //   423: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   426: astore #11
    //   428: aload #11
    //   430: sipush #1000
    //   433: aload_0
    //   434: getfield mMaximumVelocity : I
    //   437: i2f
    //   438: invokevirtual computeCurrentVelocity : (IF)V
    //   441: aload #11
    //   443: aload_0
    //   444: getfield mActivePointerId : I
    //   447: invokestatic getXVelocity : (Landroid/view/VelocityTracker;I)F
    //   450: f2i
    //   451: istore #6
    //   453: aload_0
    //   454: iconst_1
    //   455: putfield mPopulatePending : Z
    //   458: aload_0
    //   459: invokespecial getClientWidth : ()I
    //   462: istore #7
    //   464: aload_0
    //   465: invokevirtual getScrollX : ()I
    //   468: istore #8
    //   470: aload_0
    //   471: invokespecial infoForCurrentScrollPosition : ()Landroid/support/v4/view/ViewPager$ItemInfo;
    //   474: astore #11
    //   476: aload_0
    //   477: getfield mPageMargin : I
    //   480: i2f
    //   481: iload #7
    //   483: i2f
    //   484: fdiv
    //   485: fstore_2
    //   486: aload_0
    //   487: aload_0
    //   488: aload #11
    //   490: getfield position : I
    //   493: iload #8
    //   495: i2f
    //   496: iload #7
    //   498: i2f
    //   499: fdiv
    //   500: aload #11
    //   502: getfield offset : F
    //   505: fsub
    //   506: aload #11
    //   508: getfield widthFactor : F
    //   511: fload_2
    //   512: fadd
    //   513: fdiv
    //   514: iload #6
    //   516: aload_1
    //   517: aload_1
    //   518: aload_0
    //   519: getfield mActivePointerId : I
    //   522: invokevirtual findPointerIndex : (I)I
    //   525: invokevirtual getX : (I)F
    //   528: aload_0
    //   529: getfield mInitialMotionX : F
    //   532: fsub
    //   533: f2i
    //   534: invokespecial determineTargetPage : (IFII)I
    //   537: iconst_1
    //   538: iconst_1
    //   539: iload #6
    //   541: invokevirtual setCurrentItemInternal : (IZZI)V
    //   544: aload_0
    //   545: invokespecial resetTouch : ()Z
    //   548: istore #9
    //   550: goto -> 132
    //   553: iload #10
    //   555: istore #9
    //   557: aload_0
    //   558: getfield mIsBeingDragged : Z
    //   561: ifeq -> 132
    //   564: aload_0
    //   565: aload_0
    //   566: getfield mCurItem : I
    //   569: iconst_1
    //   570: iconst_0
    //   571: iconst_0
    //   572: invokespecial scrollToItem : (IZIZ)V
    //   575: aload_0
    //   576: invokespecial resetTouch : ()Z
    //   579: istore #9
    //   581: goto -> 132
    //   584: aload_1
    //   585: invokestatic getActionIndex : (Landroid/view/MotionEvent;)I
    //   588: istore #6
    //   590: aload_0
    //   591: aload_1
    //   592: iload #6
    //   594: invokevirtual getX : (I)F
    //   597: putfield mLastMotionX : F
    //   600: aload_0
    //   601: aload_1
    //   602: iload #6
    //   604: invokevirtual getPointerId : (I)I
    //   607: putfield mActivePointerId : I
    //   610: iload #10
    //   612: istore #9
    //   614: goto -> 132
    //   617: aload_0
    //   618: aload_1
    //   619: invokespecial onSecondaryPointerUp : (Landroid/view/MotionEvent;)V
    //   622: aload_0
    //   623: aload_1
    //   624: aload_1
    //   625: aload_0
    //   626: getfield mActivePointerId : I
    //   629: invokevirtual findPointerIndex : (I)I
    //   632: invokevirtual getX : (I)F
    //   635: putfield mLastMotionX : F
    //   638: iload #10
    //   640: istore #9
    //   642: goto -> 132
  }
  
  boolean pageLeft() {
    if (this.mCurItem > 0) {
      setCurrentItem(this.mCurItem - 1, true);
      return true;
    } 
    return false;
  }
  
  boolean pageRight() {
    if (this.mAdapter != null && this.mCurItem < this.mAdapter.getCount() - 1) {
      setCurrentItem(this.mCurItem + 1, true);
      return true;
    } 
    return false;
  }
  
  void populate() {
    populate(this.mCurItem);
  }
  
  void populate(int paramInt) {
    ItemInfo itemInfo = null;
    if (this.mCurItem != paramInt) {
      itemInfo = infoForPosition(this.mCurItem);
      this.mCurItem = paramInt;
    } 
    if (this.mAdapter == null) {
      sortChildDrawingOrder();
      return;
    } 
    if (this.mPopulatePending) {
      sortChildDrawingOrder();
      return;
    } 
    if (getWindowToken() != null) {
      this.mAdapter.startUpdate(this);
      paramInt = this.mOffscreenPageLimit;
      int k = Math.max(0, this.mCurItem - paramInt);
      int i = this.mAdapter.getCount();
      int j = Math.min(i - 1, this.mCurItem + paramInt);
      if (i != this.mExpectedAdapterCount) {
        String str;
        try {
          str = getResources().getResourceName(getId());
        } catch (android.content.res.Resources.NotFoundException notFoundException) {
          str = Integer.toHexString(getId());
        } 
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + i + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
      } 
      ItemInfo itemInfo1 = null;
      paramInt = 0;
      while (true) {
        ItemInfo itemInfo2 = itemInfo1;
        if (paramInt < this.mItems.size()) {
          ItemInfo itemInfo3 = this.mItems.get(paramInt);
          if (itemInfo3.position >= this.mCurItem) {
            itemInfo2 = itemInfo1;
            if (itemInfo3.position == this.mCurItem)
              itemInfo2 = itemInfo3; 
          } else {
            paramInt++;
            continue;
          } 
        } 
        itemInfo1 = itemInfo2;
        if (itemInfo2 == null) {
          itemInfo1 = itemInfo2;
          if (i > 0)
            itemInfo1 = addNewItem(this.mCurItem, paramInt); 
        } 
        if (itemInfo1 != null) {
          float f1;
          Object object1;
          Object object2;
          float f2 = 0.0F;
          int i1 = paramInt - 1;
          if (i1 >= 0) {
            itemInfo2 = this.mItems.get(i1);
          } else {
            itemInfo2 = null;
          } 
          int i2 = getClientWidth();
          if (i2 <= 0) {
            f1 = 0.0F;
          } else {
            f1 = 2.0F - itemInfo1.widthFactor + getPaddingLeft() / i2;
          } 
          int n = this.mCurItem - 1;
          ItemInfo itemInfo3 = itemInfo2;
          int m = paramInt;
          while (true) {
            float f3;
            if (n >= 0)
              if (object1 >= f1) {
                if (n < k) {
                  if (itemInfo3 != null) {
                    paramInt = m;
                    Object object3 = object1;
                    itemInfo2 = itemInfo3;
                    Object object4 = object2;
                    if (n == itemInfo3.position) {
                      paramInt = m;
                      object3 = object1;
                      itemInfo2 = itemInfo3;
                      object4 = object2;
                      if (!itemInfo3.scrolling) {
                        this.mItems.remove(object2);
                        this.mAdapter.destroyItem(this, n, itemInfo3.object);
                        int i3 = object2 - 1;
                        paramInt = m - 1;
                        if (i3 >= 0) {
                          itemInfo2 = this.mItems.get(i3);
                          object3 = object1;
                        } else {
                          itemInfo2 = null;
                          object3 = object1;
                        } 
                      } 
                    } 
                    continue;
                  } 
                } else {
                  if (itemInfo3 != null && n == itemInfo3.position) {
                    f3 = object1 + itemInfo3.widthFactor;
                    int i3 = object2 - 1;
                    if (i3 >= 0) {
                      itemInfo2 = this.mItems.get(i3);
                    } else {
                      itemInfo2 = null;
                    } 
                    paramInt = m;
                  } else {
                    f3 = object1 + (addNewItem(n, object2 + 1)).widthFactor;
                    paramInt = m + 1;
                    if (object2 >= null) {
                      itemInfo2 = this.mItems.get(object2);
                    } else {
                      itemInfo2 = null;
                    } 
                    Object object = object2;
                  } 
                  continue;
                } 
              } else {
                continue;
              }  
            float f4 = itemInfo1.widthFactor;
            n = m + 1;
            if (f4 < 2.0F) {
              if (n < this.mItems.size()) {
                itemInfo2 = this.mItems.get(n);
              } else {
                itemInfo2 = null;
              } 
              if (i2 <= 0) {
                f1 = 0.0F;
              } else {
                f1 = getPaddingRight() / i2 + 2.0F;
              } 
              int i3 = this.mCurItem + 1;
              itemInfo3 = itemInfo2;
              while (true) {
                if (i3 < i)
                  if (f4 >= f1 && i3 > j) {
                    if (itemInfo3 != null) {
                      f3 = f4;
                      itemInfo2 = itemInfo3;
                      paramInt = n;
                      if (i3 == itemInfo3.position) {
                        f3 = f4;
                        itemInfo2 = itemInfo3;
                        paramInt = n;
                        if (!itemInfo3.scrolling) {
                          this.mItems.remove(n);
                          this.mAdapter.destroyItem(this, i3, itemInfo3.object);
                          if (n < this.mItems.size()) {
                            itemInfo2 = this.mItems.get(n);
                            paramInt = n;
                            f3 = f4;
                          } else {
                            itemInfo2 = null;
                            f3 = f4;
                            paramInt = n;
                          } 
                        } 
                      } 
                      continue;
                    } 
                  } else {
                    if (itemInfo3 != null && i3 == itemInfo3.position) {
                      f3 = f4 + itemInfo3.widthFactor;
                      paramInt = n + 1;
                      if (paramInt < this.mItems.size()) {
                        itemInfo2 = this.mItems.get(paramInt);
                      } else {
                        itemInfo2 = null;
                      } 
                    } else {
                      itemInfo2 = addNewItem(i3, n);
                      paramInt = n + 1;
                      f3 = f4 + itemInfo2.widthFactor;
                      if (paramInt < this.mItems.size()) {
                        itemInfo2 = this.mItems.get(paramInt);
                      } else {
                        itemInfo2 = null;
                      } 
                    } 
                    continue;
                  }  
                calculatePageOffsets(itemInfo1, m, itemInfo);
                PagerAdapter pagerAdapter = this.mAdapter;
                paramInt = this.mCurItem;
                if (itemInfo1 != null) {
                  Object object = itemInfo1.object;
                } else {
                  itemInfo2 = null;
                } 
                pagerAdapter.setPrimaryItem(this, paramInt, itemInfo2);
                this.mAdapter.finishUpdate(this);
                i3 = getChildCount();
                for (paramInt = 0; paramInt < i3; paramInt++) {
                  View view = getChildAt(paramInt);
                  LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                  layoutParams.childIndex = paramInt;
                  if (!layoutParams.isDecor && layoutParams.widthFactor == 0.0F) {
                    ItemInfo itemInfo4 = infoForChild(view);
                    if (itemInfo4 != null) {
                      layoutParams.widthFactor = itemInfo4.widthFactor;
                      layoutParams.position = itemInfo4.position;
                    } 
                  } 
                } 
                sortChildDrawingOrder();
                if (hasFocus()) {
                  View view = findFocus();
                  if (view != null) {
                    ItemInfo itemInfo4 = infoForAnyChild(view);
                  } else {
                    view = null;
                  } 
                  if (view == null || ((ItemInfo)view).position != this.mCurItem) {
                    paramInt = 0;
                    while (true) {
                      if (paramInt < getChildCount()) {
                        view = getChildAt(paramInt);
                        ItemInfo itemInfo4 = infoForChild(view);
                        if (itemInfo4 == null || itemInfo4.position != this.mCurItem || !view.requestFocus(2)) {
                          paramInt++;
                          continue;
                        } 
                      } 
                      return;
                    } 
                    break;
                  } 
                  // Byte code: goto -> 37
                } 
                // Byte code: goto -> 37
                i3++;
                f4 = f3;
                itemInfo3 = itemInfo2;
                n = paramInt;
              } 
              break;
            } 
            continue;
            n--;
            m = paramInt;
            object1 = SYNTHETIC_LOCAL_VARIABLE_2;
            itemInfo3 = itemInfo2;
            object2 = SYNTHETIC_LOCAL_VARIABLE_5;
          } 
        } 
        continue;
      } 
    } 
  }
  
  public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener paramOnAdapterChangeListener) {
    if (this.mAdapterChangeListeners != null)
      this.mAdapterChangeListeners.remove(paramOnAdapterChangeListener); 
  }
  
  public void removeOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    if (this.mOnPageChangeListeners != null)
      this.mOnPageChangeListeners.remove(paramOnPageChangeListener); 
  }
  
  public void removeView(View paramView) {
    if (this.mInLayout) {
      removeViewInLayout(paramView);
      return;
    } 
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter) {
    if (this.mAdapter != null) {
      this.mAdapter.setViewPagerObserver(null);
      this.mAdapter.startUpdate(this);
      for (int i = 0; i < this.mItems.size(); i++) {
        ItemInfo itemInfo = this.mItems.get(i);
        this.mAdapter.destroyItem(this, itemInfo.position, itemInfo.object);
      } 
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      scrollTo(0, 0);
    } 
    PagerAdapter pagerAdapter = this.mAdapter;
    this.mAdapter = paramPagerAdapter;
    this.mExpectedAdapterCount = 0;
    if (this.mAdapter != null) {
      if (this.mObserver == null)
        this.mObserver = new PagerObserver(); 
      this.mAdapter.setViewPagerObserver(this.mObserver);
      this.mPopulatePending = false;
      boolean bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem >= 0) {
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
      } else if (!bool) {
        populate();
      } else {
        requestLayout();
      } 
    } 
    if (this.mAdapterChangeListeners != null && !this.mAdapterChangeListeners.isEmpty()) {
      int i = 0;
      int j = this.mAdapterChangeListeners.size();
      while (i < j) {
        ((OnAdapterChangeListener)this.mAdapterChangeListeners.get(i)).onAdapterChanged(this, pagerAdapter, paramPagerAdapter);
        i++;
      } 
    } 
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 7) {
      if (this.mSetChildrenDrawingOrderEnabled == null) {
        try {
          this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { boolean.class });
          try {
            this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
            return;
          } catch (Exception exception) {
            Log.e("ViewPager", "Error changing children drawing order", exception);
          } 
        } catch (NoSuchMethodException noSuchMethodException) {
          Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", noSuchMethodException);
          try {
            this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
            return;
          } catch (Exception exception) {
            Log.e("ViewPager", "Error changing children drawing order", exception);
          } 
        } 
        return;
      } 
    } else {
      return;
    } 
    try {
      this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    } catch (Exception exception) {
      Log.e("ViewPager", "Error changing children drawing order", exception);
    } 
  }
  
  public void setCurrentItem(int paramInt) {
    boolean bool;
    this.mPopulatePending = false;
    if (!this.mFirstLayout) {
      bool = true;
    } else {
      bool = false;
    } 
    setCurrentItemInternal(paramInt, bool, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean) {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2) {
    int i;
    boolean bool = true;
    if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    if (!paramBoolean2 && this.mCurItem == paramInt1 && this.mItems.size() != 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    if (paramInt1 < 0) {
      i = 0;
    } else {
      i = paramInt1;
      if (paramInt1 >= this.mAdapter.getCount())
        i = this.mAdapter.getCount() - 1; 
    } 
    paramInt1 = this.mOffscreenPageLimit;
    if (i > this.mCurItem + paramInt1 || i < this.mCurItem - paramInt1)
      for (paramInt1 = 0; paramInt1 < this.mItems.size(); paramInt1++)
        ((ItemInfo)this.mItems.get(paramInt1)).scrolling = true;  
    if (this.mCurItem != i) {
      paramBoolean2 = bool;
    } else {
      paramBoolean2 = false;
    } 
    if (this.mFirstLayout) {
      this.mCurItem = i;
      if (paramBoolean2)
        dispatchOnPageSelected(i); 
      requestLayout();
      return;
    } 
    populate(i);
    scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    OnPageChangeListener onPageChangeListener = this.mInternalPageChangeListener;
    this.mInternalPageChangeListener = paramOnPageChangeListener;
    return onPageChangeListener;
  }
  
  public void setOffscreenPageLimit(int paramInt) {
    int i = paramInt;
    if (paramInt < 1) {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + '\001');
      i = 1;
    } 
    if (i != this.mOffscreenPageLimit) {
      this.mOffscreenPageLimit = i;
      populate();
    } 
  }
  
  @Deprecated
  public void setOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt) {
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(@DrawableRes int paramInt) {
    setPageMarginDrawable(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable) {
    boolean bool;
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null)
      refreshDrawableState(); 
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    } 
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setPageTransformer(boolean paramBoolean, PageTransformer paramPageTransformer) {
    setPageTransformer(paramBoolean, paramPageTransformer, 2);
  }
  
  public void setPageTransformer(boolean paramBoolean, PageTransformer paramPageTransformer, int paramInt) {
    byte b = 1;
    if (Build.VERSION.SDK_INT >= 11) {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (paramPageTransformer != null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (this.mPageTransformer != null) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      if (bool2 != bool3) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.mPageTransformer = paramPageTransformer;
      setChildrenDrawingOrderEnabledCompat(bool2);
      if (bool2) {
        if (paramBoolean)
          b = 2; 
        this.mDrawingOrder = b;
        this.mPageTransformerLayerType = paramInt;
      } else {
        this.mDrawingOrder = 0;
      } 
      if (bool1)
        populate(); 
    } 
  }
  
  void setScrollState(int paramInt) {
    if (this.mScrollState == paramInt)
      return; 
    this.mScrollState = paramInt;
    if (this.mPageTransformer != null) {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      enableLayers(bool);
    } 
    dispatchOnScrollStateChanged(paramInt);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2) {
    smoothScrollTo(paramInt1, paramInt2, 0);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3) {
    int i;
    if (getChildCount() == 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    if (this.mScroller != null && !this.mScroller.isFinished()) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      if (this.mIsScrollStarted) {
        i = this.mScroller.getCurrX();
      } else {
        i = this.mScroller.getStartX();
      } 
      this.mScroller.abortAnimation();
      setScrollingCacheEnabled(false);
    } else {
      i = getScrollX();
    } 
    int j = getScrollY();
    int k = paramInt1 - i;
    paramInt2 -= j;
    if (k == 0 && paramInt2 == 0) {
      completeScroll(false);
      populate();
      setScrollState(0);
      return;
    } 
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int m = paramInt1 / 2;
    float f3 = Math.min(1.0F, 1.0F * Math.abs(k) / paramInt1);
    float f1 = m;
    float f2 = m;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {
      paramInt1 = Math.round(1000.0F * Math.abs((f1 + f2 * f3) / paramInt3)) * 4;
    } else {
      f1 = paramInt1;
      f2 = this.mAdapter.getPageWidth(this.mCurItem);
      paramInt1 = (int)((1.0F + Math.abs(k) / (this.mPageMargin + f1 * f2)) * 100.0F);
    } 
    paramInt1 = Math.min(paramInt1, 600);
    this.mIsScrollStarted = false;
    this.mScroller.startScroll(i, j, k, paramInt2, paramInt1);
    ViewCompat.postInvalidateOnAnimation((View)this);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) {
    return (super.verifyDrawable(paramDrawable) || paramDrawable == this.mMarginDrawable);
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE})
  public static @interface DecorView {}
  
  static class ItemInfo {
    Object object;
    
    float offset;
    
    int position;
    
    boolean scrolling;
    
    float widthFactor;
  }
  
  public static class LayoutParams extends ViewGroup.LayoutParams {
    int childIndex;
    
    public int gravity;
    
    public boolean isDecor;
    
    boolean needsMeasure;
    
    int position;
    
    float widthFactor = 0.0F;
    
    public LayoutParams() {
      super(-1, -1);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, ViewPager.LAYOUT_ATTRS);
      this.gravity = typedArray.getInteger(0, 48);
      typedArray.recycle();
    }
  }
  
  class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
    private boolean canScroll() {
      return (ViewPager.this.mAdapter != null && ViewPager.this.mAdapter.getCount() > 1);
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName(ViewPager.class.getName());
      AccessibilityRecordCompat accessibilityRecordCompat = AccessibilityEventCompat.asRecord(param1AccessibilityEvent);
      accessibilityRecordCompat.setScrollable(canScroll());
      if (param1AccessibilityEvent.getEventType() == 4096 && ViewPager.this.mAdapter != null) {
        accessibilityRecordCompat.setItemCount(ViewPager.this.mAdapter.getCount());
        accessibilityRecordCompat.setFromIndex(ViewPager.this.mCurItem);
        accessibilityRecordCompat.setToIndex(ViewPager.this.mCurItem);
      } 
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
      param1AccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
      param1AccessibilityNodeInfoCompat.setScrollable(canScroll());
      if (ViewPager.this.canScrollHorizontally(1))
        param1AccessibilityNodeInfoCompat.addAction(4096); 
      if (ViewPager.this.canScrollHorizontally(-1))
        param1AccessibilityNodeInfoCompat.addAction(8192); 
    }
    
    public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) {
      if (super.performAccessibilityAction(param1View, param1Int, param1Bundle))
        return true; 
      switch (param1Int) {
        default:
          return false;
        case 4096:
          if (ViewPager.this.canScrollHorizontally(1)) {
            ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + 1);
            return true;
          } 
          return false;
        case 8192:
          break;
      } 
      if (ViewPager.this.canScrollHorizontally(-1)) {
        ViewPager.this.setCurrentItem(ViewPager.this.mCurItem - 1);
        return true;
      } 
      return false;
    }
  }
  
  public static interface OnAdapterChangeListener {
    void onAdapterChanged(@NonNull ViewPager param1ViewPager, @Nullable PagerAdapter param1PagerAdapter1, @Nullable PagerAdapter param1PagerAdapter2);
  }
  
  public static interface OnPageChangeListener {
    void onPageScrollStateChanged(int param1Int);
    
    void onPageScrolled(int param1Int1, float param1Float, int param1Int2);
    
    void onPageSelected(int param1Int);
  }
  
  public static interface PageTransformer {
    void transformPage(View param1View, float param1Float);
  }
  
  private class PagerObserver extends DataSetObserver {
    public void onChanged() {
      ViewPager.this.dataSetChanged();
    }
    
    public void onInvalidated() {
      ViewPager.this.dataSetChanged();
    }
  }
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
          public ViewPager.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
            return new ViewPager.SavedState(param2Parcel, param2ClassLoader);
          }
          
          public ViewPager.SavedState[] newArray(int param2Int) {
            return new ViewPager.SavedState[param2Int];
          }
        });
    
    Parcelable adapterState;
    
    ClassLoader loader;
    
    int position;
    
    SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      ClassLoader classLoader = param1ClassLoader;
      if (param1ClassLoader == null)
        classLoader = getClass().getClassLoader(); 
      this.position = param1Parcel.readInt();
      this.adapterState = param1Parcel.readParcelable(classLoader);
      this.loader = classLoader;
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public String toString() {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.position);
      param1Parcel.writeParcelable(this.adapterState, param1Int);
    }
  }
  
  static final class null implements ParcelableCompatCreatorCallbacks<SavedState> {
    public ViewPager.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new ViewPager.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public ViewPager.SavedState[] newArray(int param1Int) {
      return new ViewPager.SavedState[param1Int];
    }
  }
  
  public static class SimpleOnPageChangeListener implements OnPageChangeListener {
    public void onPageScrollStateChanged(int param1Int) {}
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
    
    public void onPageSelected(int param1Int) {}
  }
  
  static class ViewPositionComparator implements Comparator<View> {
    public int compare(View param1View1, View param1View2) {
      ViewPager.LayoutParams layoutParams1 = (ViewPager.LayoutParams)param1View1.getLayoutParams();
      ViewPager.LayoutParams layoutParams2 = (ViewPager.LayoutParams)param1View2.getLayoutParams();
      return (layoutParams1.isDecor != layoutParams2.isDecor) ? (layoutParams1.isDecor ? 1 : -1) : (layoutParams1.position - layoutParams2.position);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */