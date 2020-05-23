package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
  public static final int HORIZONTAL = 0;
  
  private static final int INDEX_BOTTOM = 2;
  
  private static final int INDEX_CENTER_VERTICAL = 0;
  
  private static final int INDEX_FILL = 3;
  
  private static final int INDEX_TOP = 1;
  
  public static final int SHOW_DIVIDER_BEGINNING = 1;
  
  public static final int SHOW_DIVIDER_END = 4;
  
  public static final int SHOW_DIVIDER_MIDDLE = 2;
  
  public static final int SHOW_DIVIDER_NONE = 0;
  
  public static final int VERTICAL = 1;
  
  private static final int VERTICAL_GRAVITY_COUNT = 4;
  
  private boolean mBaselineAligned = true;
  
  private int mBaselineAlignedChildIndex = -1;
  
  private int mBaselineChildTop = 0;
  
  private Drawable mDivider;
  
  private int mDividerHeight;
  
  private int mDividerPadding;
  
  private int mDividerWidth;
  
  private int mGravity = 8388659;
  
  private int[] mMaxAscent;
  
  private int[] mMaxDescent;
  
  private int mOrientation;
  
  private int mShowDividers;
  
  private int mTotalLength;
  
  private boolean mUseLargestChild;
  
  private float mWeightSum;
  
  public LinearLayoutCompat(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.LinearLayoutCompat, paramInt, 0);
    paramInt = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0)
      setOrientation(paramInt); 
    paramInt = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0)
      setGravity(paramInt); 
    boolean bool = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool)
      setBaselineAligned(bool); 
    this.mWeightSum = tintTypedArray.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
    this.mBaselineAlignedChildIndex = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.mUseLargestChild = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(tintTypedArray.getDrawable(R.styleable.LinearLayoutCompat_divider));
    this.mShowDividers = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
    this.mDividerPadding = tintTypedArray.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
    tintTypedArray.recycle();
  }
  
  private void forceUniformHeight(int paramInt1, int paramInt2) {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    for (int i = 0; i < paramInt1; i++) {
      View view = getVirtualChildAt(i);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.height == -1) {
          int k = layoutParams.width;
          layoutParams.width = view.getMeasuredWidth();
          measureChildWithMargins(view, paramInt2, 0, j, 0);
          layoutParams.width = k;
        } 
      } 
    } 
  }
  
  private void forceUniformWidth(int paramInt1, int paramInt2) {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    for (int i = 0; i < paramInt1; i++) {
      View view = getVirtualChildAt(i);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.width == -1) {
          int k = layoutParams.height;
          layoutParams.height = view.getMeasuredHeight();
          measureChildWithMargins(view, j, 0, paramInt2, 0);
          layoutParams.height = k;
        } 
      } 
    } 
  }
  
  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  void drawDividersHorizontal(Canvas paramCanvas) {
    int j = getVirtualChildCount();
    boolean bool = ViewUtils.isLayoutRtl((View)this);
    int i;
    for (i = 0; i < j; i++) {
      View view = getVirtualChildAt(i);
      if (view != null && view.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
        int k;
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (bool) {
          k = view.getRight() + layoutParams.rightMargin;
        } else {
          k = view.getLeft() - layoutParams.leftMargin - this.mDividerWidth;
        } 
        drawVerticalDivider(paramCanvas, k);
      } 
    } 
    if (hasDividerBeforeChildAt(j)) {
      View view = getVirtualChildAt(j - 1);
      if (view == null) {
        if (bool) {
          i = getPaddingLeft();
        } else {
          i = getWidth() - getPaddingRight() - this.mDividerWidth;
        } 
      } else {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (bool) {
          i = view.getLeft() - layoutParams.leftMargin - this.mDividerWidth;
        } else {
          i = view.getRight() + layoutParams.rightMargin;
        } 
      } 
      drawVerticalDivider(paramCanvas, i);
    } 
  }
  
  void drawDividersVertical(Canvas paramCanvas) {
    int j = getVirtualChildCount();
    int i;
    for (i = 0; i < j; i++) {
      View view = getVirtualChildAt(i);
      if (view != null && view.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        drawHorizontalDivider(paramCanvas, view.getTop() - layoutParams.topMargin - this.mDividerHeight);
      } 
    } 
    if (hasDividerBeforeChildAt(j)) {
      View view = getVirtualChildAt(j - 1);
      if (view == null) {
        i = getHeight() - getPaddingBottom() - this.mDividerHeight;
      } else {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        i = view.getBottom() + layoutParams.bottomMargin;
      } 
      drawHorizontalDivider(paramCanvas, i);
    } 
  }
  
  void drawHorizontalDivider(Canvas paramCanvas, int paramInt) {
    this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, paramInt, getWidth() - getPaddingRight() - this.mDividerPadding, this.mDividerHeight + paramInt);
    this.mDivider.draw(paramCanvas);
  }
  
  void drawVerticalDivider(Canvas paramCanvas, int paramInt) {
    this.mDivider.setBounds(paramInt, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + paramInt, getHeight() - getPaddingBottom() - this.mDividerPadding);
    this.mDivider.draw(paramCanvas);
  }
  
  protected LayoutParams generateDefaultLayoutParams() {
    return (this.mOrientation == 0) ? new LayoutParams(-2, -2) : ((this.mOrientation == 1) ? new LayoutParams(-1, -2) : null);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getBaseline() {
    int i = -1;
    if (this.mBaselineAlignedChildIndex < 0)
      return super.getBaseline(); 
    if (getChildCount() <= this.mBaselineAlignedChildIndex)
      throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds."); 
    View view = getChildAt(this.mBaselineAlignedChildIndex);
    int k = view.getBaseline();
    if (k == -1) {
      if (this.mBaselineAlignedChildIndex != 0)
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline."); 
      return i;
    } 
    int j = this.mBaselineChildTop;
    i = j;
    if (this.mOrientation == 1) {
      int m = this.mGravity & 0x70;
      i = j;
      if (m != 48) {
        switch (m) {
          default:
            i = j;
            return ((LayoutParams)view.getLayoutParams()).topMargin + i + k;
          case 80:
            i = getBottom() - getTop() - getPaddingBottom() - this.mTotalLength;
            return ((LayoutParams)view.getLayoutParams()).topMargin + i + k;
          case 16:
            break;
        } 
      } else {
        return ((LayoutParams)view.getLayoutParams()).topMargin + i + k;
      } 
    } else {
      return ((LayoutParams)view.getLayoutParams()).topMargin + i + k;
    } 
    i = j + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.mTotalLength) / 2;
    return ((LayoutParams)view.getLayoutParams()).topMargin + i + k;
  }
  
  public int getBaselineAlignedChildIndex() {
    return this.mBaselineAlignedChildIndex;
  }
  
  int getChildrenSkipCount(View paramView, int paramInt) {
    return 0;
  }
  
  public Drawable getDividerDrawable() {
    return this.mDivider;
  }
  
  public int getDividerPadding() {
    return this.mDividerPadding;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public int getDividerWidth() {
    return this.mDividerWidth;
  }
  
  public int getGravity() {
    return this.mGravity;
  }
  
  int getLocationOffset(View paramView) {
    return 0;
  }
  
  int getNextLocationOffset(View paramView) {
    return 0;
  }
  
  public int getOrientation() {
    return this.mOrientation;
  }
  
  public int getShowDividers() {
    return this.mShowDividers;
  }
  
  View getVirtualChildAt(int paramInt) {
    return getChildAt(paramInt);
  }
  
  int getVirtualChildCount() {
    return getChildCount();
  }
  
  public float getWeightSum() {
    return this.mWeightSum;
  }
  
  protected boolean hasDividerBeforeChildAt(int paramInt) {
    if (paramInt == 0)
      return !((this.mShowDividers & 0x1) == 0); 
    if (paramInt == getChildCount())
      return !((this.mShowDividers & 0x4) == 0); 
    if ((this.mShowDividers & 0x2) != 0) {
      boolean bool = false;
      paramInt--;
      while (true) {
        boolean bool1 = bool;
        if (paramInt >= 0) {
          if (getChildAt(paramInt).getVisibility() != 8)
            return true; 
        } else {
          return bool1;
        } 
        paramInt--;
      } 
    } 
    return false;
  }
  
  public boolean isBaselineAligned() {
    return this.mBaselineAligned;
  }
  
  public boolean isMeasureWithLargestChildEnabled() {
    return this.mUseLargestChild;
  }
  
  void layoutHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isLayoutRtl : (Landroid/view/View;)Z
    //   4: istore #17
    //   6: aload_0
    //   7: invokevirtual getPaddingTop : ()I
    //   10: istore #7
    //   12: iload #4
    //   14: iload_2
    //   15: isub
    //   16: istore #9
    //   18: aload_0
    //   19: invokevirtual getPaddingBottom : ()I
    //   22: istore #10
    //   24: aload_0
    //   25: invokevirtual getPaddingBottom : ()I
    //   28: istore #11
    //   30: aload_0
    //   31: invokevirtual getVirtualChildCount : ()I
    //   34: istore #12
    //   36: aload_0
    //   37: getfield mGravity : I
    //   40: istore_2
    //   41: aload_0
    //   42: getfield mGravity : I
    //   45: istore #13
    //   47: aload_0
    //   48: getfield mBaselineAligned : Z
    //   51: istore #18
    //   53: aload_0
    //   54: getfield mMaxAscent : [I
    //   57: astore #19
    //   59: aload_0
    //   60: getfield mMaxDescent : [I
    //   63: astore #20
    //   65: iload_2
    //   66: ldc_w 8388615
    //   69: iand
    //   70: aload_0
    //   71: invokestatic getLayoutDirection : (Landroid/view/View;)I
    //   74: invokestatic getAbsoluteGravity : (II)I
    //   77: lookupswitch default -> 104, 1 -> 200, 5 -> 183
    //   104: aload_0
    //   105: invokevirtual getPaddingLeft : ()I
    //   108: istore_1
    //   109: iconst_0
    //   110: istore #5
    //   112: iconst_1
    //   113: istore #4
    //   115: iload #17
    //   117: ifeq -> 129
    //   120: iload #12
    //   122: iconst_1
    //   123: isub
    //   124: istore #5
    //   126: iconst_m1
    //   127: istore #4
    //   129: iconst_0
    //   130: istore_2
    //   131: iload_1
    //   132: istore_3
    //   133: iload_2
    //   134: iload #12
    //   136: if_icmpge -> 544
    //   139: iload #5
    //   141: iload #4
    //   143: iload_2
    //   144: imul
    //   145: iadd
    //   146: istore #14
    //   148: aload_0
    //   149: iload #14
    //   151: invokevirtual getVirtualChildAt : (I)Landroid/view/View;
    //   154: astore #21
    //   156: aload #21
    //   158: ifnonnull -> 219
    //   161: iload_3
    //   162: aload_0
    //   163: iload #14
    //   165: invokevirtual measureNullChild : (I)I
    //   168: iadd
    //   169: istore_1
    //   170: iload_2
    //   171: istore #6
    //   173: iload #6
    //   175: iconst_1
    //   176: iadd
    //   177: istore_2
    //   178: iload_1
    //   179: istore_3
    //   180: goto -> 133
    //   183: aload_0
    //   184: invokevirtual getPaddingLeft : ()I
    //   187: iload_3
    //   188: iadd
    //   189: iload_1
    //   190: isub
    //   191: aload_0
    //   192: getfield mTotalLength : I
    //   195: isub
    //   196: istore_1
    //   197: goto -> 109
    //   200: aload_0
    //   201: invokevirtual getPaddingLeft : ()I
    //   204: iload_3
    //   205: iload_1
    //   206: isub
    //   207: aload_0
    //   208: getfield mTotalLength : I
    //   211: isub
    //   212: iconst_2
    //   213: idiv
    //   214: iadd
    //   215: istore_1
    //   216: goto -> 109
    //   219: iload_3
    //   220: istore_1
    //   221: iload_2
    //   222: istore #6
    //   224: aload #21
    //   226: invokevirtual getVisibility : ()I
    //   229: bipush #8
    //   231: if_icmpeq -> 173
    //   234: aload #21
    //   236: invokevirtual getMeasuredWidth : ()I
    //   239: istore #15
    //   241: aload #21
    //   243: invokevirtual getMeasuredHeight : ()I
    //   246: istore #16
    //   248: iconst_m1
    //   249: istore_1
    //   250: aload #21
    //   252: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   255: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   258: astore #22
    //   260: iload_1
    //   261: istore #6
    //   263: iload #18
    //   265: ifeq -> 287
    //   268: iload_1
    //   269: istore #6
    //   271: aload #22
    //   273: getfield height : I
    //   276: iconst_m1
    //   277: if_icmpeq -> 287
    //   280: aload #21
    //   282: invokevirtual getBaseline : ()I
    //   285: istore #6
    //   287: aload #22
    //   289: getfield gravity : I
    //   292: istore #8
    //   294: iload #8
    //   296: istore_1
    //   297: iload #8
    //   299: ifge -> 308
    //   302: iload #13
    //   304: bipush #112
    //   306: iand
    //   307: istore_1
    //   308: iload_1
    //   309: bipush #112
    //   311: iand
    //   312: lookupswitch default -> 348, 16 -> 465, 48 -> 432, 80 -> 497
    //   348: iload #7
    //   350: istore_1
    //   351: iload_3
    //   352: istore #6
    //   354: aload_0
    //   355: iload #14
    //   357: invokevirtual hasDividerBeforeChildAt : (I)Z
    //   360: ifeq -> 371
    //   363: iload_3
    //   364: aload_0
    //   365: getfield mDividerWidth : I
    //   368: iadd
    //   369: istore #6
    //   371: iload #6
    //   373: aload #22
    //   375: getfield leftMargin : I
    //   378: iadd
    //   379: istore_3
    //   380: aload_0
    //   381: aload #21
    //   383: iload_3
    //   384: aload_0
    //   385: aload #21
    //   387: invokevirtual getLocationOffset : (Landroid/view/View;)I
    //   390: iadd
    //   391: iload_1
    //   392: iload #15
    //   394: iload #16
    //   396: invokespecial setChildFrame : (Landroid/view/View;IIII)V
    //   399: iload_3
    //   400: aload #22
    //   402: getfield rightMargin : I
    //   405: iload #15
    //   407: iadd
    //   408: aload_0
    //   409: aload #21
    //   411: invokevirtual getNextLocationOffset : (Landroid/view/View;)I
    //   414: iadd
    //   415: iadd
    //   416: istore_1
    //   417: iload_2
    //   418: aload_0
    //   419: aload #21
    //   421: iload #14
    //   423: invokevirtual getChildrenSkipCount : (Landroid/view/View;I)I
    //   426: iadd
    //   427: istore #6
    //   429: goto -> 173
    //   432: iload #7
    //   434: aload #22
    //   436: getfield topMargin : I
    //   439: iadd
    //   440: istore #8
    //   442: iload #8
    //   444: istore_1
    //   445: iload #6
    //   447: iconst_m1
    //   448: if_icmpeq -> 351
    //   451: iload #8
    //   453: aload #19
    //   455: iconst_1
    //   456: iaload
    //   457: iload #6
    //   459: isub
    //   460: iadd
    //   461: istore_1
    //   462: goto -> 351
    //   465: iload #9
    //   467: iload #7
    //   469: isub
    //   470: iload #11
    //   472: isub
    //   473: iload #16
    //   475: isub
    //   476: iconst_2
    //   477: idiv
    //   478: iload #7
    //   480: iadd
    //   481: aload #22
    //   483: getfield topMargin : I
    //   486: iadd
    //   487: aload #22
    //   489: getfield bottomMargin : I
    //   492: isub
    //   493: istore_1
    //   494: goto -> 351
    //   497: iload #9
    //   499: iload #10
    //   501: isub
    //   502: iload #16
    //   504: isub
    //   505: aload #22
    //   507: getfield bottomMargin : I
    //   510: isub
    //   511: istore #8
    //   513: iload #8
    //   515: istore_1
    //   516: iload #6
    //   518: iconst_m1
    //   519: if_icmpeq -> 351
    //   522: aload #21
    //   524: invokevirtual getMeasuredHeight : ()I
    //   527: istore_1
    //   528: iload #8
    //   530: aload #20
    //   532: iconst_2
    //   533: iaload
    //   534: iload_1
    //   535: iload #6
    //   537: isub
    //   538: isub
    //   539: isub
    //   540: istore_1
    //   541: goto -> 351
    //   544: return
  }
  
  void layoutVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getPaddingLeft : ()I
    //   4: istore #5
    //   6: iload_3
    //   7: iload_1
    //   8: isub
    //   9: istore #6
    //   11: aload_0
    //   12: invokevirtual getPaddingRight : ()I
    //   15: istore #7
    //   17: aload_0
    //   18: invokevirtual getPaddingRight : ()I
    //   21: istore #8
    //   23: aload_0
    //   24: invokevirtual getVirtualChildCount : ()I
    //   27: istore #9
    //   29: aload_0
    //   30: getfield mGravity : I
    //   33: istore_1
    //   34: aload_0
    //   35: getfield mGravity : I
    //   38: istore #10
    //   40: iload_1
    //   41: bipush #112
    //   43: iand
    //   44: lookupswitch default -> 72, 16 -> 136, 80 -> 118
    //   72: aload_0
    //   73: invokevirtual getPaddingTop : ()I
    //   76: istore_1
    //   77: iconst_0
    //   78: istore_2
    //   79: iload_2
    //   80: iload #9
    //   82: if_icmpge -> 394
    //   85: aload_0
    //   86: iload_2
    //   87: invokevirtual getVirtualChildAt : (I)Landroid/view/View;
    //   90: astore #13
    //   92: aload #13
    //   94: ifnonnull -> 156
    //   97: iload_1
    //   98: aload_0
    //   99: iload_2
    //   100: invokevirtual measureNullChild : (I)I
    //   103: iadd
    //   104: istore_3
    //   105: iload_2
    //   106: istore #4
    //   108: iload #4
    //   110: iconst_1
    //   111: iadd
    //   112: istore_2
    //   113: iload_3
    //   114: istore_1
    //   115: goto -> 79
    //   118: aload_0
    //   119: invokevirtual getPaddingTop : ()I
    //   122: iload #4
    //   124: iadd
    //   125: iload_2
    //   126: isub
    //   127: aload_0
    //   128: getfield mTotalLength : I
    //   131: isub
    //   132: istore_1
    //   133: goto -> 77
    //   136: aload_0
    //   137: invokevirtual getPaddingTop : ()I
    //   140: iload #4
    //   142: iload_2
    //   143: isub
    //   144: aload_0
    //   145: getfield mTotalLength : I
    //   148: isub
    //   149: iconst_2
    //   150: idiv
    //   151: iadd
    //   152: istore_1
    //   153: goto -> 77
    //   156: iload_1
    //   157: istore_3
    //   158: iload_2
    //   159: istore #4
    //   161: aload #13
    //   163: invokevirtual getVisibility : ()I
    //   166: bipush #8
    //   168: if_icmpeq -> 108
    //   171: aload #13
    //   173: invokevirtual getMeasuredWidth : ()I
    //   176: istore #11
    //   178: aload #13
    //   180: invokevirtual getMeasuredHeight : ()I
    //   183: istore #12
    //   185: aload #13
    //   187: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   190: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   193: astore #14
    //   195: aload #14
    //   197: getfield gravity : I
    //   200: istore #4
    //   202: iload #4
    //   204: istore_3
    //   205: iload #4
    //   207: ifge -> 217
    //   210: iload #10
    //   212: ldc_w 8388615
    //   215: iand
    //   216: istore_3
    //   217: iload_3
    //   218: aload_0
    //   219: invokestatic getLayoutDirection : (Landroid/view/View;)I
    //   222: invokestatic getAbsoluteGravity : (II)I
    //   225: bipush #7
    //   227: iand
    //   228: lookupswitch default -> 256, 1 -> 344, 5 -> 376
    //   256: iload #5
    //   258: aload #14
    //   260: getfield leftMargin : I
    //   263: iadd
    //   264: istore_3
    //   265: iload_1
    //   266: istore #4
    //   268: aload_0
    //   269: iload_2
    //   270: invokevirtual hasDividerBeforeChildAt : (I)Z
    //   273: ifeq -> 284
    //   276: iload_1
    //   277: aload_0
    //   278: getfield mDividerHeight : I
    //   281: iadd
    //   282: istore #4
    //   284: iload #4
    //   286: aload #14
    //   288: getfield topMargin : I
    //   291: iadd
    //   292: istore_1
    //   293: aload_0
    //   294: aload #13
    //   296: iload_3
    //   297: iload_1
    //   298: aload_0
    //   299: aload #13
    //   301: invokevirtual getLocationOffset : (Landroid/view/View;)I
    //   304: iadd
    //   305: iload #11
    //   307: iload #12
    //   309: invokespecial setChildFrame : (Landroid/view/View;IIII)V
    //   312: iload_1
    //   313: aload #14
    //   315: getfield bottomMargin : I
    //   318: iload #12
    //   320: iadd
    //   321: aload_0
    //   322: aload #13
    //   324: invokevirtual getNextLocationOffset : (Landroid/view/View;)I
    //   327: iadd
    //   328: iadd
    //   329: istore_3
    //   330: iload_2
    //   331: aload_0
    //   332: aload #13
    //   334: iload_2
    //   335: invokevirtual getChildrenSkipCount : (Landroid/view/View;I)I
    //   338: iadd
    //   339: istore #4
    //   341: goto -> 108
    //   344: iload #6
    //   346: iload #5
    //   348: isub
    //   349: iload #8
    //   351: isub
    //   352: iload #11
    //   354: isub
    //   355: iconst_2
    //   356: idiv
    //   357: iload #5
    //   359: iadd
    //   360: aload #14
    //   362: getfield leftMargin : I
    //   365: iadd
    //   366: aload #14
    //   368: getfield rightMargin : I
    //   371: isub
    //   372: istore_3
    //   373: goto -> 265
    //   376: iload #6
    //   378: iload #7
    //   380: isub
    //   381: iload #11
    //   383: isub
    //   384: aload #14
    //   386: getfield rightMargin : I
    //   389: isub
    //   390: istore_3
    //   391: goto -> 265
    //   394: return
  }
  
  void measureChildBeforeLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  void measureHorizontal(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield mTotalLength : I
    //   5: iconst_0
    //   6: istore #13
    //   8: iconst_0
    //   9: istore #8
    //   11: iconst_0
    //   12: istore #6
    //   14: iconst_0
    //   15: istore #10
    //   17: iconst_1
    //   18: istore #7
    //   20: fconst_0
    //   21: fstore_3
    //   22: aload_0
    //   23: invokevirtual getVirtualChildCount : ()I
    //   26: istore #21
    //   28: iload_1
    //   29: invokestatic getMode : (I)I
    //   32: istore #23
    //   34: iload_2
    //   35: invokestatic getMode : (I)I
    //   38: istore #22
    //   40: iconst_0
    //   41: istore #9
    //   43: iconst_0
    //   44: istore #14
    //   46: aload_0
    //   47: getfield mMaxAscent : [I
    //   50: ifnull -> 60
    //   53: aload_0
    //   54: getfield mMaxDescent : [I
    //   57: ifnonnull -> 74
    //   60: aload_0
    //   61: iconst_4
    //   62: newarray int
    //   64: putfield mMaxAscent : [I
    //   67: aload_0
    //   68: iconst_4
    //   69: newarray int
    //   71: putfield mMaxDescent : [I
    //   74: aload_0
    //   75: getfield mMaxAscent : [I
    //   78: astore #28
    //   80: aload_0
    //   81: getfield mMaxDescent : [I
    //   84: astore #29
    //   86: aload #28
    //   88: iconst_3
    //   89: iconst_m1
    //   90: iastore
    //   91: aload #28
    //   93: iconst_2
    //   94: iconst_m1
    //   95: iastore
    //   96: aload #28
    //   98: iconst_1
    //   99: iconst_m1
    //   100: iastore
    //   101: aload #28
    //   103: iconst_0
    //   104: iconst_m1
    //   105: iastore
    //   106: aload #29
    //   108: iconst_3
    //   109: iconst_m1
    //   110: iastore
    //   111: aload #29
    //   113: iconst_2
    //   114: iconst_m1
    //   115: iastore
    //   116: aload #29
    //   118: iconst_1
    //   119: iconst_m1
    //   120: iastore
    //   121: aload #29
    //   123: iconst_0
    //   124: iconst_m1
    //   125: iastore
    //   126: aload_0
    //   127: getfield mBaselineAligned : Z
    //   130: istore #26
    //   132: aload_0
    //   133: getfield mUseLargestChild : Z
    //   136: istore #27
    //   138: iload #23
    //   140: ldc 1073741824
    //   142: if_icmpne -> 208
    //   145: iconst_1
    //   146: istore #17
    //   148: ldc_w -2147483648
    //   151: istore #12
    //   153: iconst_0
    //   154: istore #11
    //   156: iload #11
    //   158: iload #21
    //   160: if_icmpge -> 885
    //   163: aload_0
    //   164: iload #11
    //   166: invokevirtual getVirtualChildAt : (I)Landroid/view/View;
    //   169: astore #30
    //   171: aload #30
    //   173: ifnonnull -> 214
    //   176: aload_0
    //   177: aload_0
    //   178: getfield mTotalLength : I
    //   181: aload_0
    //   182: iload #11
    //   184: invokevirtual measureNullChild : (I)I
    //   187: iadd
    //   188: putfield mTotalLength : I
    //   191: iload #12
    //   193: istore #16
    //   195: iload #11
    //   197: iconst_1
    //   198: iadd
    //   199: istore #11
    //   201: iload #16
    //   203: istore #12
    //   205: goto -> 156
    //   208: iconst_0
    //   209: istore #17
    //   211: goto -> 148
    //   214: aload #30
    //   216: invokevirtual getVisibility : ()I
    //   219: bipush #8
    //   221: if_icmpne -> 244
    //   224: iload #11
    //   226: aload_0
    //   227: aload #30
    //   229: iload #11
    //   231: invokevirtual getChildrenSkipCount : (Landroid/view/View;I)I
    //   234: iadd
    //   235: istore #11
    //   237: iload #12
    //   239: istore #16
    //   241: goto -> 195
    //   244: aload_0
    //   245: iload #11
    //   247: invokevirtual hasDividerBeforeChildAt : (I)Z
    //   250: ifeq -> 266
    //   253: aload_0
    //   254: aload_0
    //   255: getfield mTotalLength : I
    //   258: aload_0
    //   259: getfield mDividerWidth : I
    //   262: iadd
    //   263: putfield mTotalLength : I
    //   266: aload #30
    //   268: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   271: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   274: astore #31
    //   276: fload_3
    //   277: aload #31
    //   279: getfield weight : F
    //   282: fadd
    //   283: fstore_3
    //   284: iload #23
    //   286: ldc 1073741824
    //   288: if_icmpne -> 638
    //   291: aload #31
    //   293: getfield width : I
    //   296: ifne -> 638
    //   299: aload #31
    //   301: getfield weight : F
    //   304: fconst_0
    //   305: fcmpl
    //   306: ifle -> 638
    //   309: iload #17
    //   311: ifeq -> 596
    //   314: aload_0
    //   315: aload_0
    //   316: getfield mTotalLength : I
    //   319: aload #31
    //   321: getfield leftMargin : I
    //   324: aload #31
    //   326: getfield rightMargin : I
    //   329: iadd
    //   330: iadd
    //   331: putfield mTotalLength : I
    //   334: iload #26
    //   336: ifeq -> 628
    //   339: iconst_0
    //   340: iconst_0
    //   341: invokestatic makeMeasureSpec : (II)I
    //   344: istore #15
    //   346: aload #30
    //   348: iload #15
    //   350: iload #15
    //   352: invokevirtual measure : (II)V
    //   355: iload #14
    //   357: istore #15
    //   359: iload #12
    //   361: istore #16
    //   363: iconst_0
    //   364: istore #18
    //   366: iload #9
    //   368: istore #12
    //   370: iload #18
    //   372: istore #14
    //   374: iload #22
    //   376: ldc 1073741824
    //   378: if_icmpeq -> 404
    //   381: iload #9
    //   383: istore #12
    //   385: iload #18
    //   387: istore #14
    //   389: aload #31
    //   391: getfield height : I
    //   394: iconst_m1
    //   395: if_icmpne -> 404
    //   398: iconst_1
    //   399: istore #12
    //   401: iconst_1
    //   402: istore #14
    //   404: aload #31
    //   406: getfield topMargin : I
    //   409: aload #31
    //   411: getfield bottomMargin : I
    //   414: iadd
    //   415: istore #9
    //   417: aload #30
    //   419: invokevirtual getMeasuredHeight : ()I
    //   422: iload #9
    //   424: iadd
    //   425: istore #18
    //   427: iload #8
    //   429: aload #30
    //   431: invokestatic getMeasuredState : (Landroid/view/View;)I
    //   434: invokestatic combineMeasuredStates : (II)I
    //   437: istore #19
    //   439: iload #26
    //   441: ifeq -> 518
    //   444: aload #30
    //   446: invokevirtual getBaseline : ()I
    //   449: istore #20
    //   451: iload #20
    //   453: iconst_m1
    //   454: if_icmpeq -> 518
    //   457: aload #31
    //   459: getfield gravity : I
    //   462: ifge -> 838
    //   465: aload_0
    //   466: getfield mGravity : I
    //   469: istore #8
    //   471: iload #8
    //   473: bipush #112
    //   475: iand
    //   476: iconst_4
    //   477: ishr
    //   478: bipush #-2
    //   480: iand
    //   481: iconst_1
    //   482: ishr
    //   483: istore #8
    //   485: aload #28
    //   487: iload #8
    //   489: aload #28
    //   491: iload #8
    //   493: iaload
    //   494: iload #20
    //   496: invokestatic max : (II)I
    //   499: iastore
    //   500: aload #29
    //   502: iload #8
    //   504: aload #29
    //   506: iload #8
    //   508: iaload
    //   509: iload #18
    //   511: iload #20
    //   513: isub
    //   514: invokestatic max : (II)I
    //   517: iastore
    //   518: iload #13
    //   520: iload #18
    //   522: invokestatic max : (II)I
    //   525: istore #13
    //   527: iload #7
    //   529: ifeq -> 848
    //   532: aload #31
    //   534: getfield height : I
    //   537: iconst_m1
    //   538: if_icmpne -> 848
    //   541: iconst_1
    //   542: istore #7
    //   544: aload #31
    //   546: getfield weight : F
    //   549: fconst_0
    //   550: fcmpl
    //   551: ifle -> 861
    //   554: iload #14
    //   556: ifeq -> 854
    //   559: iload #10
    //   561: iload #9
    //   563: invokestatic max : (II)I
    //   566: istore #10
    //   568: iload #11
    //   570: aload_0
    //   571: aload #30
    //   573: iload #11
    //   575: invokevirtual getChildrenSkipCount : (Landroid/view/View;I)I
    //   578: iadd
    //   579: istore #11
    //   581: iload #19
    //   583: istore #8
    //   585: iload #12
    //   587: istore #9
    //   589: iload #15
    //   591: istore #14
    //   593: goto -> 195
    //   596: aload_0
    //   597: getfield mTotalLength : I
    //   600: istore #15
    //   602: aload_0
    //   603: iload #15
    //   605: aload #31
    //   607: getfield leftMargin : I
    //   610: iload #15
    //   612: iadd
    //   613: aload #31
    //   615: getfield rightMargin : I
    //   618: iadd
    //   619: invokestatic max : (II)I
    //   622: putfield mTotalLength : I
    //   625: goto -> 334
    //   628: iconst_1
    //   629: istore #15
    //   631: iload #12
    //   633: istore #16
    //   635: goto -> 363
    //   638: ldc_w -2147483648
    //   641: istore #16
    //   643: iload #16
    //   645: istore #15
    //   647: aload #31
    //   649: getfield width : I
    //   652: ifne -> 679
    //   655: iload #16
    //   657: istore #15
    //   659: aload #31
    //   661: getfield weight : F
    //   664: fconst_0
    //   665: fcmpl
    //   666: ifle -> 679
    //   669: iconst_0
    //   670: istore #15
    //   672: aload #31
    //   674: bipush #-2
    //   676: putfield width : I
    //   679: fload_3
    //   680: fconst_0
    //   681: fcmpl
    //   682: ifne -> 790
    //   685: aload_0
    //   686: getfield mTotalLength : I
    //   689: istore #16
    //   691: aload_0
    //   692: aload #30
    //   694: iload #11
    //   696: iload_1
    //   697: iload #16
    //   699: iload_2
    //   700: iconst_0
    //   701: invokevirtual measureChildBeforeLayout : (Landroid/view/View;IIIII)V
    //   704: iload #15
    //   706: ldc_w -2147483648
    //   709: if_icmpeq -> 719
    //   712: aload #31
    //   714: iload #15
    //   716: putfield width : I
    //   719: aload #30
    //   721: invokevirtual getMeasuredWidth : ()I
    //   724: istore #18
    //   726: iload #17
    //   728: ifeq -> 796
    //   731: aload_0
    //   732: aload_0
    //   733: getfield mTotalLength : I
    //   736: aload #31
    //   738: getfield leftMargin : I
    //   741: iload #18
    //   743: iadd
    //   744: aload #31
    //   746: getfield rightMargin : I
    //   749: iadd
    //   750: aload_0
    //   751: aload #30
    //   753: invokevirtual getNextLocationOffset : (Landroid/view/View;)I
    //   756: iadd
    //   757: iadd
    //   758: putfield mTotalLength : I
    //   761: iload #12
    //   763: istore #16
    //   765: iload #14
    //   767: istore #15
    //   769: iload #27
    //   771: ifeq -> 363
    //   774: iload #18
    //   776: iload #12
    //   778: invokestatic max : (II)I
    //   781: istore #16
    //   783: iload #14
    //   785: istore #15
    //   787: goto -> 363
    //   790: iconst_0
    //   791: istore #16
    //   793: goto -> 691
    //   796: aload_0
    //   797: getfield mTotalLength : I
    //   800: istore #15
    //   802: aload_0
    //   803: iload #15
    //   805: iload #15
    //   807: iload #18
    //   809: iadd
    //   810: aload #31
    //   812: getfield leftMargin : I
    //   815: iadd
    //   816: aload #31
    //   818: getfield rightMargin : I
    //   821: iadd
    //   822: aload_0
    //   823: aload #30
    //   825: invokevirtual getNextLocationOffset : (Landroid/view/View;)I
    //   828: iadd
    //   829: invokestatic max : (II)I
    //   832: putfield mTotalLength : I
    //   835: goto -> 761
    //   838: aload #31
    //   840: getfield gravity : I
    //   843: istore #8
    //   845: goto -> 471
    //   848: iconst_0
    //   849: istore #7
    //   851: goto -> 544
    //   854: iload #18
    //   856: istore #9
    //   858: goto -> 559
    //   861: iload #14
    //   863: ifeq -> 878
    //   866: iload #6
    //   868: iload #9
    //   870: invokestatic max : (II)I
    //   873: istore #6
    //   875: goto -> 568
    //   878: iload #18
    //   880: istore #9
    //   882: goto -> 866
    //   885: aload_0
    //   886: getfield mTotalLength : I
    //   889: ifle -> 914
    //   892: aload_0
    //   893: iload #21
    //   895: invokevirtual hasDividerBeforeChildAt : (I)Z
    //   898: ifeq -> 914
    //   901: aload_0
    //   902: aload_0
    //   903: getfield mTotalLength : I
    //   906: aload_0
    //   907: getfield mDividerWidth : I
    //   910: iadd
    //   911: putfield mTotalLength : I
    //   914: aload #28
    //   916: iconst_1
    //   917: iaload
    //   918: iconst_m1
    //   919: if_icmpne -> 950
    //   922: aload #28
    //   924: iconst_0
    //   925: iaload
    //   926: iconst_m1
    //   927: if_icmpne -> 950
    //   930: aload #28
    //   932: iconst_2
    //   933: iaload
    //   934: iconst_m1
    //   935: if_icmpne -> 950
    //   938: iload #13
    //   940: istore #11
    //   942: aload #28
    //   944: iconst_3
    //   945: iaload
    //   946: iconst_m1
    //   947: if_icmpeq -> 1008
    //   950: iload #13
    //   952: aload #28
    //   954: iconst_3
    //   955: iaload
    //   956: aload #28
    //   958: iconst_0
    //   959: iaload
    //   960: aload #28
    //   962: iconst_1
    //   963: iaload
    //   964: aload #28
    //   966: iconst_2
    //   967: iaload
    //   968: invokestatic max : (II)I
    //   971: invokestatic max : (II)I
    //   974: invokestatic max : (II)I
    //   977: aload #29
    //   979: iconst_3
    //   980: iaload
    //   981: aload #29
    //   983: iconst_0
    //   984: iaload
    //   985: aload #29
    //   987: iconst_1
    //   988: iaload
    //   989: aload #29
    //   991: iconst_2
    //   992: iaload
    //   993: invokestatic max : (II)I
    //   996: invokestatic max : (II)I
    //   999: invokestatic max : (II)I
    //   1002: iadd
    //   1003: invokestatic max : (II)I
    //   1006: istore #11
    //   1008: iload #27
    //   1010: ifeq -> 1194
    //   1013: iload #23
    //   1015: ldc_w -2147483648
    //   1018: if_icmpeq -> 1026
    //   1021: iload #23
    //   1023: ifne -> 1194
    //   1026: aload_0
    //   1027: iconst_0
    //   1028: putfield mTotalLength : I
    //   1031: iconst_0
    //   1032: istore #13
    //   1034: iload #13
    //   1036: iload #21
    //   1038: if_icmpge -> 1194
    //   1041: aload_0
    //   1042: iload #13
    //   1044: invokevirtual getVirtualChildAt : (I)Landroid/view/View;
    //   1047: astore #30
    //   1049: aload #30
    //   1051: ifnonnull -> 1078
    //   1054: aload_0
    //   1055: aload_0
    //   1056: getfield mTotalLength : I
    //   1059: aload_0
    //   1060: iload #13
    //   1062: invokevirtual measureNullChild : (I)I
    //   1065: iadd
    //   1066: putfield mTotalLength : I
    //   1069: iload #13
    //   1071: iconst_1
    //   1072: iadd
    //   1073: istore #13
    //   1075: goto -> 1034
    //   1078: aload #30
    //   1080: invokevirtual getVisibility : ()I
    //   1083: bipush #8
    //   1085: if_icmpne -> 1104
    //   1088: iload #13
    //   1090: aload_0
    //   1091: aload #30
    //   1093: iload #13
    //   1095: invokevirtual getChildrenSkipCount : (Landroid/view/View;I)I
    //   1098: iadd
    //   1099: istore #13
    //   1101: goto -> 1069
    //   1104: aload #30
    //   1106: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1109: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   1112: astore #31
    //   1114: iload #17
    //   1116: ifeq -> 1152
    //   1119: aload_0
    //   1120: aload_0
    //   1121: getfield mTotalLength : I
    //   1124: aload #31
    //   1126: getfield leftMargin : I
    //   1129: iload #12
    //   1131: iadd
    //   1132: aload #31
    //   1134: getfield rightMargin : I
    //   1137: iadd
    //   1138: aload_0
    //   1139: aload #30
    //   1141: invokevirtual getNextLocationOffset : (Landroid/view/View;)I
    //   1144: iadd
    //   1145: iadd
    //   1146: putfield mTotalLength : I
    //   1149: goto -> 1069
    //   1152: aload_0
    //   1153: getfield mTotalLength : I
    //   1156: istore #15
    //   1158: aload_0
    //   1159: iload #15
    //   1161: iload #15
    //   1163: iload #12
    //   1165: iadd
    //   1166: aload #31
    //   1168: getfield leftMargin : I
    //   1171: iadd
    //   1172: aload #31
    //   1174: getfield rightMargin : I
    //   1177: iadd
    //   1178: aload_0
    //   1179: aload #30
    //   1181: invokevirtual getNextLocationOffset : (Landroid/view/View;)I
    //   1184: iadd
    //   1185: invokestatic max : (II)I
    //   1188: putfield mTotalLength : I
    //   1191: goto -> 1069
    //   1194: aload_0
    //   1195: aload_0
    //   1196: getfield mTotalLength : I
    //   1199: aload_0
    //   1200: invokevirtual getPaddingLeft : ()I
    //   1203: aload_0
    //   1204: invokevirtual getPaddingRight : ()I
    //   1207: iadd
    //   1208: iadd
    //   1209: putfield mTotalLength : I
    //   1212: aload_0
    //   1213: getfield mTotalLength : I
    //   1216: aload_0
    //   1217: invokevirtual getSuggestedMinimumWidth : ()I
    //   1220: invokestatic max : (II)I
    //   1223: iload_1
    //   1224: iconst_0
    //   1225: invokestatic resolveSizeAndState : (III)I
    //   1228: istore #24
    //   1230: iload #24
    //   1232: ldc_w 16777215
    //   1235: iand
    //   1236: aload_0
    //   1237: getfield mTotalLength : I
    //   1240: isub
    //   1241: istore #13
    //   1243: iload #14
    //   1245: ifne -> 1259
    //   1248: iload #13
    //   1250: ifeq -> 2199
    //   1253: fload_3
    //   1254: fconst_0
    //   1255: fcmpl
    //   1256: ifle -> 2199
    //   1259: aload_0
    //   1260: getfield mWeightSum : F
    //   1263: fconst_0
    //   1264: fcmpl
    //   1265: ifle -> 1436
    //   1268: aload_0
    //   1269: getfield mWeightSum : F
    //   1272: fstore_3
    //   1273: aload #28
    //   1275: iconst_3
    //   1276: iconst_m1
    //   1277: iastore
    //   1278: aload #28
    //   1280: iconst_2
    //   1281: iconst_m1
    //   1282: iastore
    //   1283: aload #28
    //   1285: iconst_1
    //   1286: iconst_m1
    //   1287: iastore
    //   1288: aload #28
    //   1290: iconst_0
    //   1291: iconst_m1
    //   1292: iastore
    //   1293: aload #29
    //   1295: iconst_3
    //   1296: iconst_m1
    //   1297: iastore
    //   1298: aload #29
    //   1300: iconst_2
    //   1301: iconst_m1
    //   1302: iastore
    //   1303: aload #29
    //   1305: iconst_1
    //   1306: iconst_m1
    //   1307: iastore
    //   1308: aload #29
    //   1310: iconst_0
    //   1311: iconst_m1
    //   1312: iastore
    //   1313: iconst_m1
    //   1314: istore #11
    //   1316: aload_0
    //   1317: iconst_0
    //   1318: putfield mTotalLength : I
    //   1321: iconst_0
    //   1322: istore #14
    //   1324: iload #6
    //   1326: istore #10
    //   1328: iload #14
    //   1330: iload #21
    //   1332: if_icmpge -> 1985
    //   1335: aload_0
    //   1336: iload #14
    //   1338: invokevirtual getVirtualChildAt : (I)Landroid/view/View;
    //   1341: astore #30
    //   1343: iload #7
    //   1345: istore #15
    //   1347: iload #10
    //   1349: istore #16
    //   1351: iload #8
    //   1353: istore #18
    //   1355: iload #13
    //   1357: istore #19
    //   1359: iload #11
    //   1361: istore #20
    //   1363: fload_3
    //   1364: fstore #5
    //   1366: aload #30
    //   1368: ifnull -> 1404
    //   1371: aload #30
    //   1373: invokevirtual getVisibility : ()I
    //   1376: bipush #8
    //   1378: if_icmpne -> 1439
    //   1381: fload_3
    //   1382: fstore #5
    //   1384: iload #11
    //   1386: istore #20
    //   1388: iload #13
    //   1390: istore #19
    //   1392: iload #8
    //   1394: istore #18
    //   1396: iload #10
    //   1398: istore #16
    //   1400: iload #7
    //   1402: istore #15
    //   1404: iload #14
    //   1406: iconst_1
    //   1407: iadd
    //   1408: istore #14
    //   1410: iload #15
    //   1412: istore #7
    //   1414: iload #16
    //   1416: istore #10
    //   1418: iload #18
    //   1420: istore #8
    //   1422: iload #19
    //   1424: istore #13
    //   1426: iload #20
    //   1428: istore #11
    //   1430: fload #5
    //   1432: fstore_3
    //   1433: goto -> 1328
    //   1436: goto -> 1273
    //   1439: aload #30
    //   1441: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1444: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   1447: astore #31
    //   1449: aload #31
    //   1451: getfield weight : F
    //   1454: fstore #5
    //   1456: iload #8
    //   1458: istore #12
    //   1460: iload #13
    //   1462: istore #6
    //   1464: fload_3
    //   1465: fstore #4
    //   1467: fload #5
    //   1469: fconst_0
    //   1470: fcmpl
    //   1471: ifle -> 1605
    //   1474: iload #13
    //   1476: i2f
    //   1477: fload #5
    //   1479: fmul
    //   1480: fload_3
    //   1481: fdiv
    //   1482: f2i
    //   1483: istore #6
    //   1485: fload_3
    //   1486: fload #5
    //   1488: fsub
    //   1489: fstore #4
    //   1491: iload #13
    //   1493: iload #6
    //   1495: isub
    //   1496: istore #12
    //   1498: iload_2
    //   1499: aload_0
    //   1500: invokevirtual getPaddingTop : ()I
    //   1503: aload_0
    //   1504: invokevirtual getPaddingBottom : ()I
    //   1507: iadd
    //   1508: aload #31
    //   1510: getfield topMargin : I
    //   1513: iadd
    //   1514: aload #31
    //   1516: getfield bottomMargin : I
    //   1519: iadd
    //   1520: aload #31
    //   1522: getfield height : I
    //   1525: invokestatic getChildMeasureSpec : (III)I
    //   1528: istore #15
    //   1530: aload #31
    //   1532: getfield width : I
    //   1535: ifne -> 1545
    //   1538: iload #23
    //   1540: ldc 1073741824
    //   1542: if_icmpeq -> 1883
    //   1545: aload #30
    //   1547: invokevirtual getMeasuredWidth : ()I
    //   1550: iload #6
    //   1552: iadd
    //   1553: istore #13
    //   1555: iload #13
    //   1557: istore #6
    //   1559: iload #13
    //   1561: ifge -> 1567
    //   1564: iconst_0
    //   1565: istore #6
    //   1567: aload #30
    //   1569: iload #6
    //   1571: ldc 1073741824
    //   1573: invokestatic makeMeasureSpec : (II)I
    //   1576: iload #15
    //   1578: invokevirtual measure : (II)V
    //   1581: iload #8
    //   1583: aload #30
    //   1585: invokestatic getMeasuredState : (Landroid/view/View;)I
    //   1588: ldc_w -16777216
    //   1591: iand
    //   1592: invokestatic combineMeasuredStates : (II)I
    //   1595: istore #8
    //   1597: iload #12
    //   1599: istore #6
    //   1601: iload #8
    //   1603: istore #12
    //   1605: iload #17
    //   1607: ifeq -> 1911
    //   1610: aload_0
    //   1611: aload_0
    //   1612: getfield mTotalLength : I
    //   1615: aload #30
    //   1617: invokevirtual getMeasuredWidth : ()I
    //   1620: aload #31
    //   1622: getfield leftMargin : I
    //   1625: iadd
    //   1626: aload #31
    //   1628: getfield rightMargin : I
    //   1631: iadd
    //   1632: aload_0
    //   1633: aload #30
    //   1635: invokevirtual getNextLocationOffset : (Landroid/view/View;)I
    //   1638: iadd
    //   1639: iadd
    //   1640: putfield mTotalLength : I
    //   1643: iload #22
    //   1645: ldc 1073741824
    //   1647: if_icmpeq -> 1956
    //   1650: aload #31
    //   1652: getfield height : I
    //   1655: iconst_m1
    //   1656: if_icmpne -> 1956
    //   1659: iconst_1
    //   1660: istore #8
    //   1662: aload #31
    //   1664: getfield topMargin : I
    //   1667: aload #31
    //   1669: getfield bottomMargin : I
    //   1672: iadd
    //   1673: istore #15
    //   1675: aload #30
    //   1677: invokevirtual getMeasuredHeight : ()I
    //   1680: iload #15
    //   1682: iadd
    //   1683: istore #13
    //   1685: iload #11
    //   1687: iload #13
    //   1689: invokestatic max : (II)I
    //   1692: istore #11
    //   1694: iload #8
    //   1696: ifeq -> 1962
    //   1699: iload #15
    //   1701: istore #8
    //   1703: iload #10
    //   1705: iload #8
    //   1707: invokestatic max : (II)I
    //   1710: istore #10
    //   1712: iload #7
    //   1714: ifeq -> 1969
    //   1717: aload #31
    //   1719: getfield height : I
    //   1722: iconst_m1
    //   1723: if_icmpne -> 1969
    //   1726: iconst_1
    //   1727: istore #7
    //   1729: iload #7
    //   1731: istore #15
    //   1733: iload #10
    //   1735: istore #16
    //   1737: iload #12
    //   1739: istore #18
    //   1741: iload #6
    //   1743: istore #19
    //   1745: iload #11
    //   1747: istore #20
    //   1749: fload #4
    //   1751: fstore #5
    //   1753: iload #26
    //   1755: ifeq -> 1404
    //   1758: aload #30
    //   1760: invokevirtual getBaseline : ()I
    //   1763: istore #25
    //   1765: iload #7
    //   1767: istore #15
    //   1769: iload #10
    //   1771: istore #16
    //   1773: iload #12
    //   1775: istore #18
    //   1777: iload #6
    //   1779: istore #19
    //   1781: iload #11
    //   1783: istore #20
    //   1785: fload #4
    //   1787: fstore #5
    //   1789: iload #25
    //   1791: iconst_m1
    //   1792: if_icmpeq -> 1404
    //   1795: aload #31
    //   1797: getfield gravity : I
    //   1800: ifge -> 1975
    //   1803: aload_0
    //   1804: getfield mGravity : I
    //   1807: istore #8
    //   1809: iload #8
    //   1811: bipush #112
    //   1813: iand
    //   1814: iconst_4
    //   1815: ishr
    //   1816: bipush #-2
    //   1818: iand
    //   1819: iconst_1
    //   1820: ishr
    //   1821: istore #8
    //   1823: aload #28
    //   1825: iload #8
    //   1827: aload #28
    //   1829: iload #8
    //   1831: iaload
    //   1832: iload #25
    //   1834: invokestatic max : (II)I
    //   1837: iastore
    //   1838: aload #29
    //   1840: iload #8
    //   1842: aload #29
    //   1844: iload #8
    //   1846: iaload
    //   1847: iload #13
    //   1849: iload #25
    //   1851: isub
    //   1852: invokestatic max : (II)I
    //   1855: iastore
    //   1856: iload #7
    //   1858: istore #15
    //   1860: iload #10
    //   1862: istore #16
    //   1864: iload #12
    //   1866: istore #18
    //   1868: iload #6
    //   1870: istore #19
    //   1872: iload #11
    //   1874: istore #20
    //   1876: fload #4
    //   1878: fstore #5
    //   1880: goto -> 1404
    //   1883: iload #6
    //   1885: ifle -> 1905
    //   1888: aload #30
    //   1890: iload #6
    //   1892: ldc 1073741824
    //   1894: invokestatic makeMeasureSpec : (II)I
    //   1897: iload #15
    //   1899: invokevirtual measure : (II)V
    //   1902: goto -> 1581
    //   1905: iconst_0
    //   1906: istore #6
    //   1908: goto -> 1888
    //   1911: aload_0
    //   1912: getfield mTotalLength : I
    //   1915: istore #8
    //   1917: aload_0
    //   1918: iload #8
    //   1920: aload #30
    //   1922: invokevirtual getMeasuredWidth : ()I
    //   1925: iload #8
    //   1927: iadd
    //   1928: aload #31
    //   1930: getfield leftMargin : I
    //   1933: iadd
    //   1934: aload #31
    //   1936: getfield rightMargin : I
    //   1939: iadd
    //   1940: aload_0
    //   1941: aload #30
    //   1943: invokevirtual getNextLocationOffset : (Landroid/view/View;)I
    //   1946: iadd
    //   1947: invokestatic max : (II)I
    //   1950: putfield mTotalLength : I
    //   1953: goto -> 1643
    //   1956: iconst_0
    //   1957: istore #8
    //   1959: goto -> 1662
    //   1962: iload #13
    //   1964: istore #8
    //   1966: goto -> 1703
    //   1969: iconst_0
    //   1970: istore #7
    //   1972: goto -> 1729
    //   1975: aload #31
    //   1977: getfield gravity : I
    //   1980: istore #8
    //   1982: goto -> 1809
    //   1985: aload_0
    //   1986: aload_0
    //   1987: getfield mTotalLength : I
    //   1990: aload_0
    //   1991: invokevirtual getPaddingLeft : ()I
    //   1994: aload_0
    //   1995: invokevirtual getPaddingRight : ()I
    //   1998: iadd
    //   1999: iadd
    //   2000: putfield mTotalLength : I
    //   2003: aload #28
    //   2005: iconst_1
    //   2006: iaload
    //   2007: iconst_m1
    //   2008: if_icmpne -> 2051
    //   2011: aload #28
    //   2013: iconst_0
    //   2014: iaload
    //   2015: iconst_m1
    //   2016: if_icmpne -> 2051
    //   2019: aload #28
    //   2021: iconst_2
    //   2022: iaload
    //   2023: iconst_m1
    //   2024: if_icmpne -> 2051
    //   2027: iload #7
    //   2029: istore #15
    //   2031: iload #10
    //   2033: istore #13
    //   2035: iload #8
    //   2037: istore #14
    //   2039: iload #11
    //   2041: istore #6
    //   2043: aload #28
    //   2045: iconst_3
    //   2046: iaload
    //   2047: iconst_m1
    //   2048: if_icmpeq -> 2121
    //   2051: iload #11
    //   2053: aload #28
    //   2055: iconst_3
    //   2056: iaload
    //   2057: aload #28
    //   2059: iconst_0
    //   2060: iaload
    //   2061: aload #28
    //   2063: iconst_1
    //   2064: iaload
    //   2065: aload #28
    //   2067: iconst_2
    //   2068: iaload
    //   2069: invokestatic max : (II)I
    //   2072: invokestatic max : (II)I
    //   2075: invokestatic max : (II)I
    //   2078: aload #29
    //   2080: iconst_3
    //   2081: iaload
    //   2082: aload #29
    //   2084: iconst_0
    //   2085: iaload
    //   2086: aload #29
    //   2088: iconst_1
    //   2089: iaload
    //   2090: aload #29
    //   2092: iconst_2
    //   2093: iaload
    //   2094: invokestatic max : (II)I
    //   2097: invokestatic max : (II)I
    //   2100: invokestatic max : (II)I
    //   2103: iadd
    //   2104: invokestatic max : (II)I
    //   2107: istore #6
    //   2109: iload #8
    //   2111: istore #14
    //   2113: iload #10
    //   2115: istore #13
    //   2117: iload #7
    //   2119: istore #15
    //   2121: iload #6
    //   2123: istore #7
    //   2125: iload #15
    //   2127: ifne -> 2145
    //   2130: iload #6
    //   2132: istore #7
    //   2134: iload #22
    //   2136: ldc 1073741824
    //   2138: if_icmpeq -> 2145
    //   2141: iload #13
    //   2143: istore #7
    //   2145: aload_0
    //   2146: ldc_w -16777216
    //   2149: iload #14
    //   2151: iand
    //   2152: iload #24
    //   2154: ior
    //   2155: iload #7
    //   2157: aload_0
    //   2158: invokevirtual getPaddingTop : ()I
    //   2161: aload_0
    //   2162: invokevirtual getPaddingBottom : ()I
    //   2165: iadd
    //   2166: iadd
    //   2167: aload_0
    //   2168: invokevirtual getSuggestedMinimumHeight : ()I
    //   2171: invokestatic max : (II)I
    //   2174: iload_2
    //   2175: iload #14
    //   2177: bipush #16
    //   2179: ishl
    //   2180: invokestatic resolveSizeAndState : (III)I
    //   2183: invokevirtual setMeasuredDimension : (II)V
    //   2186: iload #9
    //   2188: ifeq -> 2198
    //   2191: aload_0
    //   2192: iload #21
    //   2194: iload_1
    //   2195: invokespecial forceUniformHeight : (II)V
    //   2198: return
    //   2199: iload #6
    //   2201: iload #10
    //   2203: invokestatic max : (II)I
    //   2206: istore #16
    //   2208: iload #7
    //   2210: istore #15
    //   2212: iload #16
    //   2214: istore #13
    //   2216: iload #8
    //   2218: istore #14
    //   2220: iload #11
    //   2222: istore #6
    //   2224: iload #27
    //   2226: ifeq -> 2121
    //   2229: iload #7
    //   2231: istore #15
    //   2233: iload #16
    //   2235: istore #13
    //   2237: iload #8
    //   2239: istore #14
    //   2241: iload #11
    //   2243: istore #6
    //   2245: iload #23
    //   2247: ldc 1073741824
    //   2249: if_icmpeq -> 2121
    //   2252: iconst_0
    //   2253: istore #10
    //   2255: iload #7
    //   2257: istore #15
    //   2259: iload #16
    //   2261: istore #13
    //   2263: iload #8
    //   2265: istore #14
    //   2267: iload #11
    //   2269: istore #6
    //   2271: iload #10
    //   2273: iload #21
    //   2275: if_icmpge -> 2121
    //   2278: aload_0
    //   2279: iload #10
    //   2281: invokevirtual getVirtualChildAt : (I)Landroid/view/View;
    //   2284: astore #28
    //   2286: aload #28
    //   2288: ifnull -> 2301
    //   2291: aload #28
    //   2293: invokevirtual getVisibility : ()I
    //   2296: bipush #8
    //   2298: if_icmpne -> 2310
    //   2301: iload #10
    //   2303: iconst_1
    //   2304: iadd
    //   2305: istore #10
    //   2307: goto -> 2255
    //   2310: aload #28
    //   2312: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   2315: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   2318: getfield weight : F
    //   2321: fconst_0
    //   2322: fcmpl
    //   2323: ifle -> 2301
    //   2326: aload #28
    //   2328: iload #12
    //   2330: ldc 1073741824
    //   2332: invokestatic makeMeasureSpec : (II)I
    //   2335: aload #28
    //   2337: invokevirtual getMeasuredHeight : ()I
    //   2340: ldc 1073741824
    //   2342: invokestatic makeMeasureSpec : (II)I
    //   2345: invokevirtual measure : (II)V
    //   2348: goto -> 2301
  }
  
  int measureNullChild(int paramInt) {
    return 0;
  }
  
  void measureVertical(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield mTotalLength : I
    //   5: iconst_0
    //   6: istore #9
    //   8: iconst_0
    //   9: istore #8
    //   11: iconst_0
    //   12: istore #6
    //   14: iconst_0
    //   15: istore #11
    //   17: iconst_1
    //   18: istore #7
    //   20: fconst_0
    //   21: fstore_3
    //   22: aload_0
    //   23: invokevirtual getVirtualChildCount : ()I
    //   26: istore #18
    //   28: iload_1
    //   29: invokestatic getMode : (I)I
    //   32: istore #19
    //   34: iload_2
    //   35: invokestatic getMode : (I)I
    //   38: istore #20
    //   40: iconst_0
    //   41: istore #10
    //   43: iconst_0
    //   44: istore #14
    //   46: aload_0
    //   47: getfield mBaselineAlignedChildIndex : I
    //   50: istore #21
    //   52: aload_0
    //   53: getfield mUseLargestChild : Z
    //   56: istore #22
    //   58: ldc_w -2147483648
    //   61: istore #13
    //   63: iconst_0
    //   64: istore #12
    //   66: iload #12
    //   68: iload #18
    //   70: if_icmpge -> 648
    //   73: aload_0
    //   74: iload #12
    //   76: invokevirtual getVirtualChildAt : (I)Landroid/view/View;
    //   79: astore #23
    //   81: aload #23
    //   83: ifnonnull -> 118
    //   86: aload_0
    //   87: aload_0
    //   88: getfield mTotalLength : I
    //   91: aload_0
    //   92: iload #12
    //   94: invokevirtual measureNullChild : (I)I
    //   97: iadd
    //   98: putfield mTotalLength : I
    //   101: iload #13
    //   103: istore #16
    //   105: iload #12
    //   107: iconst_1
    //   108: iadd
    //   109: istore #12
    //   111: iload #16
    //   113: istore #13
    //   115: goto -> 66
    //   118: aload #23
    //   120: invokevirtual getVisibility : ()I
    //   123: bipush #8
    //   125: if_icmpne -> 148
    //   128: iload #12
    //   130: aload_0
    //   131: aload #23
    //   133: iload #12
    //   135: invokevirtual getChildrenSkipCount : (Landroid/view/View;I)I
    //   138: iadd
    //   139: istore #12
    //   141: iload #13
    //   143: istore #16
    //   145: goto -> 105
    //   148: aload_0
    //   149: iload #12
    //   151: invokevirtual hasDividerBeforeChildAt : (I)Z
    //   154: ifeq -> 170
    //   157: aload_0
    //   158: aload_0
    //   159: getfield mTotalLength : I
    //   162: aload_0
    //   163: getfield mDividerHeight : I
    //   166: iadd
    //   167: putfield mTotalLength : I
    //   170: aload #23
    //   172: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   175: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   178: astore #24
    //   180: fload_3
    //   181: aload #24
    //   183: getfield weight : F
    //   186: fadd
    //   187: fstore_3
    //   188: iload #20
    //   190: ldc 1073741824
    //   192: if_icmpne -> 299
    //   195: aload #24
    //   197: getfield height : I
    //   200: ifne -> 299
    //   203: aload #24
    //   205: getfield weight : F
    //   208: fconst_0
    //   209: fcmpl
    //   210: ifle -> 299
    //   213: aload_0
    //   214: getfield mTotalLength : I
    //   217: istore #14
    //   219: aload_0
    //   220: iload #14
    //   222: aload #24
    //   224: getfield topMargin : I
    //   227: iload #14
    //   229: iadd
    //   230: aload #24
    //   232: getfield bottomMargin : I
    //   235: iadd
    //   236: invokestatic max : (II)I
    //   239: putfield mTotalLength : I
    //   242: iconst_1
    //   243: istore #15
    //   245: iload #13
    //   247: istore #16
    //   249: iload #21
    //   251: iflt -> 271
    //   254: iload #21
    //   256: iload #12
    //   258: iconst_1
    //   259: iadd
    //   260: if_icmpne -> 271
    //   263: aload_0
    //   264: aload_0
    //   265: getfield mTotalLength : I
    //   268: putfield mBaselineChildTop : I
    //   271: iload #12
    //   273: iload #21
    //   275: if_icmpge -> 461
    //   278: aload #24
    //   280: getfield weight : F
    //   283: fconst_0
    //   284: fcmpl
    //   285: ifle -> 461
    //   288: new java/lang/RuntimeException
    //   291: dup
    //   292: ldc_w 'A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.'
    //   295: invokespecial <init> : (Ljava/lang/String;)V
    //   298: athrow
    //   299: ldc_w -2147483648
    //   302: istore #16
    //   304: iload #16
    //   306: istore #15
    //   308: aload #24
    //   310: getfield height : I
    //   313: ifne -> 340
    //   316: iload #16
    //   318: istore #15
    //   320: aload #24
    //   322: getfield weight : F
    //   325: fconst_0
    //   326: fcmpl
    //   327: ifle -> 340
    //   330: iconst_0
    //   331: istore #15
    //   333: aload #24
    //   335: bipush #-2
    //   337: putfield height : I
    //   340: fload_3
    //   341: fconst_0
    //   342: fcmpl
    //   343: ifne -> 455
    //   346: aload_0
    //   347: getfield mTotalLength : I
    //   350: istore #16
    //   352: aload_0
    //   353: aload #23
    //   355: iload #12
    //   357: iload_1
    //   358: iconst_0
    //   359: iload_2
    //   360: iload #16
    //   362: invokevirtual measureChildBeforeLayout : (Landroid/view/View;IIIII)V
    //   365: iload #15
    //   367: ldc_w -2147483648
    //   370: if_icmpeq -> 380
    //   373: aload #24
    //   375: iload #15
    //   377: putfield height : I
    //   380: aload #23
    //   382: invokevirtual getMeasuredHeight : ()I
    //   385: istore #17
    //   387: aload_0
    //   388: getfield mTotalLength : I
    //   391: istore #15
    //   393: aload_0
    //   394: iload #15
    //   396: iload #15
    //   398: iload #17
    //   400: iadd
    //   401: aload #24
    //   403: getfield topMargin : I
    //   406: iadd
    //   407: aload #24
    //   409: getfield bottomMargin : I
    //   412: iadd
    //   413: aload_0
    //   414: aload #23
    //   416: invokevirtual getNextLocationOffset : (Landroid/view/View;)I
    //   419: iadd
    //   420: invokestatic max : (II)I
    //   423: putfield mTotalLength : I
    //   426: iload #13
    //   428: istore #16
    //   430: iload #14
    //   432: istore #15
    //   434: iload #22
    //   436: ifeq -> 249
    //   439: iload #17
    //   441: iload #13
    //   443: invokestatic max : (II)I
    //   446: istore #16
    //   448: iload #14
    //   450: istore #15
    //   452: goto -> 249
    //   455: iconst_0
    //   456: istore #16
    //   458: goto -> 352
    //   461: iconst_0
    //   462: istore #17
    //   464: iload #10
    //   466: istore #13
    //   468: iload #17
    //   470: istore #14
    //   472: iload #19
    //   474: ldc 1073741824
    //   476: if_icmpeq -> 502
    //   479: iload #10
    //   481: istore #13
    //   483: iload #17
    //   485: istore #14
    //   487: aload #24
    //   489: getfield width : I
    //   492: iconst_m1
    //   493: if_icmpne -> 502
    //   496: iconst_1
    //   497: istore #13
    //   499: iconst_1
    //   500: istore #14
    //   502: aload #24
    //   504: getfield leftMargin : I
    //   507: aload #24
    //   509: getfield rightMargin : I
    //   512: iadd
    //   513: istore #10
    //   515: aload #23
    //   517: invokevirtual getMeasuredWidth : ()I
    //   520: iload #10
    //   522: iadd
    //   523: istore #17
    //   525: iload #9
    //   527: iload #17
    //   529: invokestatic max : (II)I
    //   532: istore #9
    //   534: iload #8
    //   536: aload #23
    //   538: invokestatic getMeasuredState : (Landroid/view/View;)I
    //   541: invokestatic combineMeasuredStates : (II)I
    //   544: istore #8
    //   546: iload #7
    //   548: ifeq -> 611
    //   551: aload #24
    //   553: getfield width : I
    //   556: iconst_m1
    //   557: if_icmpne -> 611
    //   560: iconst_1
    //   561: istore #7
    //   563: aload #24
    //   565: getfield weight : F
    //   568: fconst_0
    //   569: fcmpl
    //   570: ifle -> 624
    //   573: iload #14
    //   575: ifeq -> 617
    //   578: iload #11
    //   580: iload #10
    //   582: invokestatic max : (II)I
    //   585: istore #11
    //   587: iload #12
    //   589: aload_0
    //   590: aload #23
    //   592: iload #12
    //   594: invokevirtual getChildrenSkipCount : (Landroid/view/View;I)I
    //   597: iadd
    //   598: istore #12
    //   600: iload #13
    //   602: istore #10
    //   604: iload #15
    //   606: istore #14
    //   608: goto -> 105
    //   611: iconst_0
    //   612: istore #7
    //   614: goto -> 563
    //   617: iload #17
    //   619: istore #10
    //   621: goto -> 578
    //   624: iload #14
    //   626: ifeq -> 641
    //   629: iload #6
    //   631: iload #10
    //   633: invokestatic max : (II)I
    //   636: istore #6
    //   638: goto -> 587
    //   641: iload #17
    //   643: istore #10
    //   645: goto -> 629
    //   648: aload_0
    //   649: getfield mTotalLength : I
    //   652: ifle -> 677
    //   655: aload_0
    //   656: iload #18
    //   658: invokevirtual hasDividerBeforeChildAt : (I)Z
    //   661: ifeq -> 677
    //   664: aload_0
    //   665: aload_0
    //   666: getfield mTotalLength : I
    //   669: aload_0
    //   670: getfield mDividerHeight : I
    //   673: iadd
    //   674: putfield mTotalLength : I
    //   677: iload #22
    //   679: ifeq -> 825
    //   682: iload #20
    //   684: ldc_w -2147483648
    //   687: if_icmpeq -> 695
    //   690: iload #20
    //   692: ifne -> 825
    //   695: aload_0
    //   696: iconst_0
    //   697: putfield mTotalLength : I
    //   700: iconst_0
    //   701: istore #12
    //   703: iload #12
    //   705: iload #18
    //   707: if_icmpge -> 825
    //   710: aload_0
    //   711: iload #12
    //   713: invokevirtual getVirtualChildAt : (I)Landroid/view/View;
    //   716: astore #23
    //   718: aload #23
    //   720: ifnonnull -> 747
    //   723: aload_0
    //   724: aload_0
    //   725: getfield mTotalLength : I
    //   728: aload_0
    //   729: iload #12
    //   731: invokevirtual measureNullChild : (I)I
    //   734: iadd
    //   735: putfield mTotalLength : I
    //   738: iload #12
    //   740: iconst_1
    //   741: iadd
    //   742: istore #12
    //   744: goto -> 703
    //   747: aload #23
    //   749: invokevirtual getVisibility : ()I
    //   752: bipush #8
    //   754: if_icmpne -> 773
    //   757: iload #12
    //   759: aload_0
    //   760: aload #23
    //   762: iload #12
    //   764: invokevirtual getChildrenSkipCount : (Landroid/view/View;I)I
    //   767: iadd
    //   768: istore #12
    //   770: goto -> 738
    //   773: aload #23
    //   775: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   778: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   781: astore #24
    //   783: aload_0
    //   784: getfield mTotalLength : I
    //   787: istore #15
    //   789: aload_0
    //   790: iload #15
    //   792: iload #15
    //   794: iload #13
    //   796: iadd
    //   797: aload #24
    //   799: getfield topMargin : I
    //   802: iadd
    //   803: aload #24
    //   805: getfield bottomMargin : I
    //   808: iadd
    //   809: aload_0
    //   810: aload #23
    //   812: invokevirtual getNextLocationOffset : (Landroid/view/View;)I
    //   815: iadd
    //   816: invokestatic max : (II)I
    //   819: putfield mTotalLength : I
    //   822: goto -> 738
    //   825: aload_0
    //   826: aload_0
    //   827: getfield mTotalLength : I
    //   830: aload_0
    //   831: invokevirtual getPaddingTop : ()I
    //   834: aload_0
    //   835: invokevirtual getPaddingBottom : ()I
    //   838: iadd
    //   839: iadd
    //   840: putfield mTotalLength : I
    //   843: aload_0
    //   844: getfield mTotalLength : I
    //   847: aload_0
    //   848: invokevirtual getSuggestedMinimumHeight : ()I
    //   851: invokestatic max : (II)I
    //   854: iload_2
    //   855: iconst_0
    //   856: invokestatic resolveSizeAndState : (III)I
    //   859: istore #17
    //   861: iload #17
    //   863: ldc_w 16777215
    //   866: iand
    //   867: aload_0
    //   868: getfield mTotalLength : I
    //   871: isub
    //   872: istore #12
    //   874: iload #14
    //   876: ifne -> 890
    //   879: iload #12
    //   881: ifeq -> 1430
    //   884: fload_3
    //   885: fconst_0
    //   886: fcmpl
    //   887: ifle -> 1430
    //   890: aload_0
    //   891: getfield mWeightSum : F
    //   894: fconst_0
    //   895: fcmpl
    //   896: ifle -> 986
    //   899: aload_0
    //   900: getfield mWeightSum : F
    //   903: fstore_3
    //   904: aload_0
    //   905: iconst_0
    //   906: putfield mTotalLength : I
    //   909: iconst_0
    //   910: istore #14
    //   912: iload #9
    //   914: istore #11
    //   916: iload #12
    //   918: istore #13
    //   920: iload #14
    //   922: iload #18
    //   924: if_icmpge -> 1336
    //   927: aload_0
    //   928: iload #14
    //   930: invokevirtual getVirtualChildAt : (I)Landroid/view/View;
    //   933: astore #23
    //   935: aload #23
    //   937: invokevirtual getVisibility : ()I
    //   940: bipush #8
    //   942: if_icmpne -> 989
    //   945: iload #13
    //   947: istore #9
    //   949: iload #8
    //   951: istore #12
    //   953: iload #6
    //   955: istore #8
    //   957: iload #7
    //   959: istore #6
    //   961: iload #14
    //   963: iconst_1
    //   964: iadd
    //   965: istore #14
    //   967: iload #6
    //   969: istore #7
    //   971: iload #8
    //   973: istore #6
    //   975: iload #12
    //   977: istore #8
    //   979: iload #9
    //   981: istore #13
    //   983: goto -> 920
    //   986: goto -> 904
    //   989: aload #23
    //   991: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   994: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   997: astore #24
    //   999: aload #24
    //   1001: getfield weight : F
    //   1004: fstore #5
    //   1006: iload #8
    //   1008: istore #12
    //   1010: iload #13
    //   1012: istore #9
    //   1014: fload_3
    //   1015: fstore #4
    //   1017: fload #5
    //   1019: fconst_0
    //   1020: fcmpl
    //   1021: ifle -> 1155
    //   1024: iload #13
    //   1026: i2f
    //   1027: fload #5
    //   1029: fmul
    //   1030: fload_3
    //   1031: fdiv
    //   1032: f2i
    //   1033: istore #9
    //   1035: fload_3
    //   1036: fload #5
    //   1038: fsub
    //   1039: fstore #4
    //   1041: iload #13
    //   1043: iload #9
    //   1045: isub
    //   1046: istore #12
    //   1048: iload_1
    //   1049: aload_0
    //   1050: invokevirtual getPaddingLeft : ()I
    //   1053: aload_0
    //   1054: invokevirtual getPaddingRight : ()I
    //   1057: iadd
    //   1058: aload #24
    //   1060: getfield leftMargin : I
    //   1063: iadd
    //   1064: aload #24
    //   1066: getfield rightMargin : I
    //   1069: iadd
    //   1070: aload #24
    //   1072: getfield width : I
    //   1075: invokestatic getChildMeasureSpec : (III)I
    //   1078: istore #15
    //   1080: aload #24
    //   1082: getfield height : I
    //   1085: ifne -> 1095
    //   1088: iload #20
    //   1090: ldc 1073741824
    //   1092: if_icmpeq -> 1289
    //   1095: aload #23
    //   1097: invokevirtual getMeasuredHeight : ()I
    //   1100: iload #9
    //   1102: iadd
    //   1103: istore #13
    //   1105: iload #13
    //   1107: istore #9
    //   1109: iload #13
    //   1111: ifge -> 1117
    //   1114: iconst_0
    //   1115: istore #9
    //   1117: aload #23
    //   1119: iload #15
    //   1121: iload #9
    //   1123: ldc 1073741824
    //   1125: invokestatic makeMeasureSpec : (II)I
    //   1128: invokevirtual measure : (II)V
    //   1131: iload #8
    //   1133: aload #23
    //   1135: invokestatic getMeasuredState : (Landroid/view/View;)I
    //   1138: sipush #-256
    //   1141: iand
    //   1142: invokestatic combineMeasuredStates : (II)I
    //   1145: istore #8
    //   1147: iload #12
    //   1149: istore #9
    //   1151: iload #8
    //   1153: istore #12
    //   1155: aload #24
    //   1157: getfield leftMargin : I
    //   1160: aload #24
    //   1162: getfield rightMargin : I
    //   1165: iadd
    //   1166: istore #13
    //   1168: aload #23
    //   1170: invokevirtual getMeasuredWidth : ()I
    //   1173: iload #13
    //   1175: iadd
    //   1176: istore #15
    //   1178: iload #11
    //   1180: iload #15
    //   1182: invokestatic max : (II)I
    //   1185: istore #11
    //   1187: iload #19
    //   1189: ldc 1073741824
    //   1191: if_icmpeq -> 1317
    //   1194: aload #24
    //   1196: getfield width : I
    //   1199: iconst_m1
    //   1200: if_icmpne -> 1317
    //   1203: iconst_1
    //   1204: istore #8
    //   1206: iload #8
    //   1208: ifeq -> 1323
    //   1211: iload #13
    //   1213: istore #8
    //   1215: iload #6
    //   1217: iload #8
    //   1219: invokestatic max : (II)I
    //   1222: istore #8
    //   1224: iload #7
    //   1226: ifeq -> 1330
    //   1229: aload #24
    //   1231: getfield width : I
    //   1234: iconst_m1
    //   1235: if_icmpne -> 1330
    //   1238: iconst_1
    //   1239: istore #6
    //   1241: aload_0
    //   1242: getfield mTotalLength : I
    //   1245: istore #7
    //   1247: aload_0
    //   1248: iload #7
    //   1250: aload #23
    //   1252: invokevirtual getMeasuredHeight : ()I
    //   1255: iload #7
    //   1257: iadd
    //   1258: aload #24
    //   1260: getfield topMargin : I
    //   1263: iadd
    //   1264: aload #24
    //   1266: getfield bottomMargin : I
    //   1269: iadd
    //   1270: aload_0
    //   1271: aload #23
    //   1273: invokevirtual getNextLocationOffset : (Landroid/view/View;)I
    //   1276: iadd
    //   1277: invokestatic max : (II)I
    //   1280: putfield mTotalLength : I
    //   1283: fload #4
    //   1285: fstore_3
    //   1286: goto -> 961
    //   1289: iload #9
    //   1291: ifle -> 1311
    //   1294: aload #23
    //   1296: iload #15
    //   1298: iload #9
    //   1300: ldc 1073741824
    //   1302: invokestatic makeMeasureSpec : (II)I
    //   1305: invokevirtual measure : (II)V
    //   1308: goto -> 1131
    //   1311: iconst_0
    //   1312: istore #9
    //   1314: goto -> 1294
    //   1317: iconst_0
    //   1318: istore #8
    //   1320: goto -> 1206
    //   1323: iload #15
    //   1325: istore #8
    //   1327: goto -> 1215
    //   1330: iconst_0
    //   1331: istore #6
    //   1333: goto -> 1241
    //   1336: aload_0
    //   1337: aload_0
    //   1338: getfield mTotalLength : I
    //   1341: aload_0
    //   1342: invokevirtual getPaddingTop : ()I
    //   1345: aload_0
    //   1346: invokevirtual getPaddingBottom : ()I
    //   1349: iadd
    //   1350: iadd
    //   1351: putfield mTotalLength : I
    //   1354: iload #8
    //   1356: istore #12
    //   1358: iload #7
    //   1360: istore #14
    //   1362: iload #11
    //   1364: istore #7
    //   1366: iload #14
    //   1368: ifne -> 1386
    //   1371: iload #11
    //   1373: istore #7
    //   1375: iload #19
    //   1377: ldc 1073741824
    //   1379: if_icmpeq -> 1386
    //   1382: iload #6
    //   1384: istore #7
    //   1386: aload_0
    //   1387: iload #7
    //   1389: aload_0
    //   1390: invokevirtual getPaddingLeft : ()I
    //   1393: aload_0
    //   1394: invokevirtual getPaddingRight : ()I
    //   1397: iadd
    //   1398: iadd
    //   1399: aload_0
    //   1400: invokevirtual getSuggestedMinimumWidth : ()I
    //   1403: invokestatic max : (II)I
    //   1406: iload_1
    //   1407: iload #12
    //   1409: invokestatic resolveSizeAndState : (III)I
    //   1412: iload #17
    //   1414: invokevirtual setMeasuredDimension : (II)V
    //   1417: iload #10
    //   1419: ifeq -> 1429
    //   1422: aload_0
    //   1423: iload #18
    //   1425: iload_2
    //   1426: invokespecial forceUniformWidth : (II)V
    //   1429: return
    //   1430: iload #6
    //   1432: iload #11
    //   1434: invokestatic max : (II)I
    //   1437: istore #16
    //   1439: iload #7
    //   1441: istore #14
    //   1443: iload #16
    //   1445: istore #6
    //   1447: iload #8
    //   1449: istore #12
    //   1451: iload #9
    //   1453: istore #11
    //   1455: iload #22
    //   1457: ifeq -> 1362
    //   1460: iload #7
    //   1462: istore #14
    //   1464: iload #16
    //   1466: istore #6
    //   1468: iload #8
    //   1470: istore #12
    //   1472: iload #9
    //   1474: istore #11
    //   1476: iload #20
    //   1478: ldc 1073741824
    //   1480: if_icmpeq -> 1362
    //   1483: iconst_0
    //   1484: istore #15
    //   1486: iload #7
    //   1488: istore #14
    //   1490: iload #16
    //   1492: istore #6
    //   1494: iload #8
    //   1496: istore #12
    //   1498: iload #9
    //   1500: istore #11
    //   1502: iload #15
    //   1504: iload #18
    //   1506: if_icmpge -> 1362
    //   1509: aload_0
    //   1510: iload #15
    //   1512: invokevirtual getVirtualChildAt : (I)Landroid/view/View;
    //   1515: astore #23
    //   1517: aload #23
    //   1519: ifnull -> 1532
    //   1522: aload #23
    //   1524: invokevirtual getVisibility : ()I
    //   1527: bipush #8
    //   1529: if_icmpne -> 1541
    //   1532: iload #15
    //   1534: iconst_1
    //   1535: iadd
    //   1536: istore #15
    //   1538: goto -> 1486
    //   1541: aload #23
    //   1543: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1546: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   1549: getfield weight : F
    //   1552: fconst_0
    //   1553: fcmpl
    //   1554: ifle -> 1532
    //   1557: aload #23
    //   1559: aload #23
    //   1561: invokevirtual getMeasuredWidth : ()I
    //   1564: ldc 1073741824
    //   1566: invokestatic makeMeasureSpec : (II)I
    //   1569: iload #13
    //   1571: ldc 1073741824
    //   1573: invokestatic makeMeasureSpec : (II)I
    //   1576: invokevirtual measure : (II)V
    //   1579: goto -> 1532
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.mDivider == null)
      return; 
    if (this.mOrientation == 1) {
      drawDividersVertical(paramCanvas);
      return;
    } 
    drawDividersHorizontal(paramCanvas);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    } 
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.mOrientation == 1) {
      layoutVertical(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    layoutHorizontal(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.mOrientation == 1) {
      measureVertical(paramInt1, paramInt2);
      return;
    } 
    measureHorizontal(paramInt1, paramInt2);
  }
  
  public void setBaselineAligned(boolean paramBoolean) {
    this.mBaselineAligned = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt) {
    if (paramInt < 0 || paramInt >= getChildCount())
      throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")"); 
    this.mBaselineAlignedChildIndex = paramInt;
  }
  
  public void setDividerDrawable(Drawable paramDrawable) {
    boolean bool = false;
    if (paramDrawable == this.mDivider)
      return; 
    this.mDivider = paramDrawable;
    if (paramDrawable != null) {
      this.mDividerWidth = paramDrawable.getIntrinsicWidth();
      this.mDividerHeight = paramDrawable.getIntrinsicHeight();
    } else {
      this.mDividerWidth = 0;
      this.mDividerHeight = 0;
    } 
    if (paramDrawable == null)
      bool = true; 
    setWillNotDraw(bool);
    requestLayout();
  }
  
  public void setDividerPadding(int paramInt) {
    this.mDividerPadding = paramInt;
  }
  
  public void setGravity(int paramInt) {
    if (this.mGravity != paramInt) {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0)
        i = paramInt | 0x800003; 
      paramInt = i;
      if ((i & 0x70) == 0)
        paramInt = i | 0x30; 
      this.mGravity = paramInt;
      requestLayout();
    } 
  }
  
  public void setHorizontalGravity(int paramInt) {
    paramInt &= 0x800007;
    if ((this.mGravity & 0x800007) != paramInt) {
      this.mGravity = this.mGravity & 0xFF7FFFF8 | paramInt;
      requestLayout();
    } 
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean) {
    this.mUseLargestChild = paramBoolean;
  }
  
  public void setOrientation(int paramInt) {
    if (this.mOrientation != paramInt) {
      this.mOrientation = paramInt;
      requestLayout();
    } 
  }
  
  public void setShowDividers(int paramInt) {
    if (paramInt != this.mShowDividers)
      requestLayout(); 
    this.mShowDividers = paramInt;
  }
  
  public void setVerticalGravity(int paramInt) {
    paramInt &= 0x70;
    if ((this.mGravity & 0x70) != paramInt) {
      this.mGravity = this.mGravity & 0xFFFFFF8F | paramInt;
      requestLayout();
    } 
  }
  
  public void setWeightSum(float paramFloat) {
    this.mWeightSum = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState() {
    return false;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface DividerMode {}
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    public int gravity = -1;
    
    public float weight;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.weight = 0.0F;
    }
    
    public LayoutParams(int param1Int1, int param1Int2, float param1Float) {
      super(param1Int1, param1Int2);
      this.weight = param1Float;
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.LinearLayoutCompat_Layout);
      this.weight = typedArray.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      this.gravity = typedArray.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      typedArray.recycle();
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.weight = param1LayoutParams.weight;
      this.gravity = param1LayoutParams.gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface OrientationMode {}
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\LinearLayoutCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */