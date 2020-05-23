package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.support.constraint.solver.widgets.Guideline;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class ConstraintLayout extends ViewGroup {
  static final boolean ALLOWS_EMBEDDED = false;
  
  private static final boolean SIMPLE_LAYOUT = true;
  
  private static final String TAG = "ConstraintLayout";
  
  public static final String VERSION = "ConstraintLayout-1.0.0";
  
  SparseArray<View> mChildrenByIds = new SparseArray();
  
  private ConstraintSet mConstraintSet = null;
  
  private boolean mDirtyHierarchy = true;
  
  ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
  
  private int mMaxHeight = Integer.MAX_VALUE;
  
  private int mMaxWidth = Integer.MAX_VALUE;
  
  private int mMinHeight = 0;
  
  private int mMinWidth = 0;
  
  private int mOptimizationLevel = 2;
  
  private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<ConstraintWidget>(100);
  
  public ConstraintLayout(Context paramContext) {
    super(paramContext);
    init((AttributeSet)null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private final ConstraintWidget getTargetWidget(int paramInt) {
    if (paramInt == 0)
      return (ConstraintWidget)this.mLayoutWidget; 
    View view = (View)this.mChildrenByIds.get(paramInt);
    return (ConstraintWidget)((view == this) ? this.mLayoutWidget : ((view == null) ? null : ((LayoutParams)view.getLayoutParams()).widget));
  }
  
  private final ConstraintWidget getViewWidget(View paramView) {
    return (ConstraintWidget)((paramView == this) ? this.mLayoutWidget : ((paramView == null) ? null : ((LayoutParams)paramView.getLayoutParams()).widget));
  }
  
  private void init(AttributeSet paramAttributeSet) {
    this.mLayoutWidget.setCompanionWidget(this);
    this.mChildrenByIds.put(getId(), this);
    this.mConstraintSet = null;
    if (paramAttributeSet != null) {
      TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = typedArray.getIndexCount();
      for (int i = 0; i < j; i++) {
        int k = typedArray.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_android_minWidth) {
          this.mMinWidth = typedArray.getDimensionPixelOffset(k, this.mMinWidth);
        } else if (k == R.styleable.ConstraintLayout_Layout_android_minHeight) {
          this.mMinHeight = typedArray.getDimensionPixelOffset(k, this.mMinHeight);
        } else if (k == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
          this.mMaxWidth = typedArray.getDimensionPixelOffset(k, this.mMaxWidth);
        } else if (k == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
          this.mMaxHeight = typedArray.getDimensionPixelOffset(k, this.mMaxHeight);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
          this.mOptimizationLevel = typedArray.getInt(k, this.mOptimizationLevel);
        } else if (k == R.styleable.ConstraintLayout_Layout_constraintSet) {
          k = typedArray.getResourceId(k, 0);
          this.mConstraintSet = new ConstraintSet();
          this.mConstraintSet.load(getContext(), k);
        } 
      } 
      typedArray.recycle();
    } 
    this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
  }
  
  private void internalMeasureChildren(int paramInt1, int paramInt2) {
    int j = getPaddingTop() + getPaddingBottom();
    int k = getPaddingLeft() + getPaddingRight();
    int m = getChildCount();
    for (int i = 0; i < m; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        ConstraintWidget constraintWidget = layoutParams.widget;
        if (!layoutParams.isGuideline) {
          int n;
          int i5 = layoutParams.width;
          int i4 = layoutParams.height;
          if (layoutParams.horizontalDimensionFixed || layoutParams.verticalDimensionFixed || (!layoutParams.horizontalDimensionFixed && layoutParams.matchConstraintDefaultWidth == 1) || layoutParams.width == -1 || (!layoutParams.verticalDimensionFixed && (layoutParams.matchConstraintDefaultHeight == 1 || layoutParams.height == -1))) {
            n = 1;
          } else {
            n = 0;
          } 
          int i3 = 0;
          byte b = 0;
          boolean bool1 = false;
          boolean bool2 = false;
          int i2 = i4;
          int i1 = i5;
          if (n) {
            if (i5 == 0 || i5 == -1) {
              i1 = getChildMeasureSpec(paramInt1, k, -2);
              n = 1;
            } else {
              i1 = getChildMeasureSpec(paramInt1, k, i5);
              n = b;
            } 
            if (i4 == 0 || i4 == -1) {
              i2 = getChildMeasureSpec(paramInt2, j, -2);
              bool1 = true;
            } else {
              i2 = getChildMeasureSpec(paramInt2, j, i4);
              bool1 = bool2;
            } 
            view.measure(i1, i2);
            i1 = view.getMeasuredWidth();
            i2 = view.getMeasuredHeight();
            i3 = n;
          } 
          constraintWidget.setWidth(i1);
          constraintWidget.setHeight(i2);
          if (i3)
            constraintWidget.setWrapWidth(i1); 
          if (bool1)
            constraintWidget.setWrapHeight(i2); 
          if (layoutParams.needsBaseline) {
            n = view.getBaseline();
            if (n != -1)
              constraintWidget.setBaselineDistance(n); 
          } 
        } 
      } 
    } 
  }
  
  private void setChildrenConstraints() {
    if (this.mConstraintSet != null)
      this.mConstraintSet.applyToInternal(this); 
    int j = getChildCount();
    this.mLayoutWidget.removeAllChildren();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      ConstraintWidget constraintWidget = getViewWidget(view);
      if (constraintWidget != null) {
        Guideline guideline;
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        constraintWidget.reset();
        constraintWidget.setVisibility(view.getVisibility());
        constraintWidget.setCompanionWidget(view);
        this.mLayoutWidget.add(constraintWidget);
        if (!layoutParams.verticalDimensionFixed || !layoutParams.horizontalDimensionFixed)
          this.mVariableDimensionsWidgets.add(constraintWidget); 
        if (layoutParams.isGuideline) {
          guideline = (Guideline)constraintWidget;
          if (layoutParams.guideBegin != -1)
            guideline.setGuideBegin(layoutParams.guideBegin); 
          if (layoutParams.guideEnd != -1)
            guideline.setGuideEnd(layoutParams.guideEnd); 
          if (layoutParams.guidePercent != -1.0F)
            guideline.setGuidePercent(layoutParams.guidePercent); 
        } else if (layoutParams.resolvedLeftToLeft != -1 || layoutParams.resolvedLeftToRight != -1 || layoutParams.resolvedRightToLeft != -1 || layoutParams.resolvedRightToRight != -1 || layoutParams.topToTop != -1 || layoutParams.topToBottom != -1 || layoutParams.bottomToTop != -1 || layoutParams.bottomToBottom != -1 || layoutParams.baselineToBaseline != -1 || layoutParams.editorAbsoluteX != -1 || layoutParams.editorAbsoluteY != -1 || layoutParams.width == -1 || layoutParams.height == -1) {
          int i2 = layoutParams.resolvedLeftToLeft;
          int i3 = layoutParams.resolvedLeftToRight;
          int k = layoutParams.resolvedRightToLeft;
          int m = layoutParams.resolvedRightToRight;
          int n = layoutParams.resolveGoneLeftMargin;
          int i1 = layoutParams.resolveGoneRightMargin;
          float f = layoutParams.resolvedHorizontalBias;
          if (Build.VERSION.SDK_INT < 17) {
            k = layoutParams.leftToLeft;
            m = layoutParams.leftToRight;
            int i8 = layoutParams.rightToLeft;
            int i9 = layoutParams.rightToRight;
            int i6 = layoutParams.goneLeftMargin;
            int i7 = layoutParams.goneRightMargin;
            float f1 = layoutParams.horizontalBias;
            int i4 = k;
            int i5 = m;
            if (k == -1) {
              i4 = k;
              i5 = m;
              if (m == -1)
                if (layoutParams.startToStart != -1) {
                  i4 = layoutParams.startToStart;
                  i5 = m;
                } else {
                  i4 = k;
                  i5 = m;
                  if (layoutParams.startToEnd != -1) {
                    i5 = layoutParams.startToEnd;
                    i4 = k;
                  } 
                }  
            } 
            n = i6;
            i1 = i7;
            f = f1;
            i2 = i4;
            i3 = i5;
            k = i8;
            m = i9;
            if (i8 == -1) {
              n = i6;
              i1 = i7;
              f = f1;
              i2 = i4;
              i3 = i5;
              k = i8;
              m = i9;
              if (i9 == -1)
                if (layoutParams.endToStart != -1) {
                  k = layoutParams.endToStart;
                  m = i9;
                  i3 = i5;
                  i2 = i4;
                  f = f1;
                  i1 = i7;
                  n = i6;
                } else {
                  n = i6;
                  i1 = i7;
                  f = f1;
                  i2 = i4;
                  i3 = i5;
                  k = i8;
                  m = i9;
                  if (layoutParams.endToEnd != -1) {
                    m = layoutParams.endToEnd;
                    n = i6;
                    i1 = i7;
                    f = f1;
                    i2 = i4;
                    i3 = i5;
                    k = i8;
                  } 
                }  
            } 
          } 
          if (i2 != -1) {
            ConstraintWidget constraintWidget1 = getTargetWidget(i2);
            if (constraintWidget1 != null)
              guideline.immediateConnect(ConstraintAnchor.Type.LEFT, constraintWidget1, ConstraintAnchor.Type.LEFT, layoutParams.leftMargin, n); 
          } else if (i3 != -1) {
            ConstraintWidget constraintWidget1 = getTargetWidget(i3);
            if (constraintWidget1 != null)
              guideline.immediateConnect(ConstraintAnchor.Type.LEFT, constraintWidget1, ConstraintAnchor.Type.RIGHT, layoutParams.leftMargin, n); 
          } 
          if (k != -1) {
            ConstraintWidget constraintWidget1 = getTargetWidget(k);
            if (constraintWidget1 != null)
              guideline.immediateConnect(ConstraintAnchor.Type.RIGHT, constraintWidget1, ConstraintAnchor.Type.LEFT, layoutParams.rightMargin, i1); 
          } else if (m != -1) {
            ConstraintWidget constraintWidget1 = getTargetWidget(m);
            if (constraintWidget1 != null)
              guideline.immediateConnect(ConstraintAnchor.Type.RIGHT, constraintWidget1, ConstraintAnchor.Type.RIGHT, layoutParams.rightMargin, i1); 
          } 
          if (layoutParams.topToTop != -1) {
            ConstraintWidget constraintWidget1 = getTargetWidget(layoutParams.topToTop);
            if (constraintWidget1 != null)
              guideline.immediateConnect(ConstraintAnchor.Type.TOP, constraintWidget1, ConstraintAnchor.Type.TOP, layoutParams.topMargin, layoutParams.goneTopMargin); 
          } else if (layoutParams.topToBottom != -1) {
            ConstraintWidget constraintWidget1 = getTargetWidget(layoutParams.topToBottom);
            if (constraintWidget1 != null)
              guideline.immediateConnect(ConstraintAnchor.Type.TOP, constraintWidget1, ConstraintAnchor.Type.BOTTOM, layoutParams.topMargin, layoutParams.goneTopMargin); 
          } 
          if (layoutParams.bottomToTop != -1) {
            ConstraintWidget constraintWidget1 = getTargetWidget(layoutParams.bottomToTop);
            if (constraintWidget1 != null)
              guideline.immediateConnect(ConstraintAnchor.Type.BOTTOM, constraintWidget1, ConstraintAnchor.Type.TOP, layoutParams.bottomMargin, layoutParams.goneBottomMargin); 
          } else if (layoutParams.bottomToBottom != -1) {
            ConstraintWidget constraintWidget1 = getTargetWidget(layoutParams.bottomToBottom);
            if (constraintWidget1 != null)
              guideline.immediateConnect(ConstraintAnchor.Type.BOTTOM, constraintWidget1, ConstraintAnchor.Type.BOTTOM, layoutParams.bottomMargin, layoutParams.goneBottomMargin); 
          } 
          if (layoutParams.baselineToBaseline != -1) {
            View view1 = (View)this.mChildrenByIds.get(layoutParams.baselineToBaseline);
            ConstraintWidget constraintWidget1 = getTargetWidget(layoutParams.baselineToBaseline);
            if (constraintWidget1 != null && view1 != null && view1.getLayoutParams() instanceof LayoutParams) {
              LayoutParams layoutParams1 = (LayoutParams)view1.getLayoutParams();
              layoutParams.needsBaseline = true;
              layoutParams1.needsBaseline = true;
              guideline.getAnchor(ConstraintAnchor.Type.BASELINE).connect(constraintWidget1.getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, ConstraintAnchor.Strength.STRONG, 0, true);
              guideline.getAnchor(ConstraintAnchor.Type.TOP).reset();
              guideline.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
            } 
          } 
          if (f >= 0.0F && f != 0.5F)
            guideline.setHorizontalBiasPercent(f); 
          if (layoutParams.verticalBias >= 0.0F && layoutParams.verticalBias != 0.5F)
            guideline.setVerticalBiasPercent(layoutParams.verticalBias); 
          if (isInEditMode() && (layoutParams.editorAbsoluteX != -1 || layoutParams.editorAbsoluteY != -1))
            guideline.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY); 
          if (!layoutParams.horizontalDimensionFixed) {
            if (layoutParams.width == -1) {
              guideline.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
              (guideline.getAnchor(ConstraintAnchor.Type.LEFT)).mMargin = layoutParams.leftMargin;
              (guideline.getAnchor(ConstraintAnchor.Type.RIGHT)).mMargin = layoutParams.rightMargin;
            } else {
              guideline.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
              guideline.setWidth(0);
            } 
          } else {
            guideline.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            guideline.setWidth(layoutParams.width);
          } 
          if (!layoutParams.verticalDimensionFixed) {
            if (layoutParams.height == -1) {
              guideline.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
              (guideline.getAnchor(ConstraintAnchor.Type.TOP)).mMargin = layoutParams.topMargin;
              (guideline.getAnchor(ConstraintAnchor.Type.BOTTOM)).mMargin = layoutParams.bottomMargin;
            } else {
              guideline.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
              guideline.setHeight(0);
            } 
          } else {
            guideline.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            guideline.setHeight(layoutParams.height);
          } 
          if (layoutParams.dimensionRatio != null)
            guideline.setDimensionRatio(layoutParams.dimensionRatio); 
          guideline.setHorizontalWeight(layoutParams.horizontalWeight);
          guideline.setVerticalWeight(layoutParams.verticalWeight);
          guideline.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
          guideline.setVerticalChainStyle(layoutParams.verticalChainStyle);
          guideline.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth);
          guideline.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight);
        } 
      } 
    } 
  }
  
  private void setSelfDimensionBehaviour(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_1
    //   1: invokestatic getMode : (I)I
    //   4: istore #8
    //   6: iload_1
    //   7: invokestatic getSize : (I)I
    //   10: istore_1
    //   11: iload_2
    //   12: invokestatic getMode : (I)I
    //   15: istore #5
    //   17: iload_2
    //   18: invokestatic getSize : (I)I
    //   21: istore_2
    //   22: aload_0
    //   23: invokevirtual getPaddingTop : ()I
    //   26: istore #6
    //   28: aload_0
    //   29: invokevirtual getPaddingBottom : ()I
    //   32: istore #7
    //   34: aload_0
    //   35: invokevirtual getPaddingLeft : ()I
    //   38: istore #9
    //   40: aload_0
    //   41: invokevirtual getPaddingRight : ()I
    //   44: istore #10
    //   46: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   49: astore #11
    //   51: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   54: astore #12
    //   56: iconst_0
    //   57: istore #4
    //   59: iconst_0
    //   60: istore_3
    //   61: aload_0
    //   62: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   65: pop
    //   66: iload #8
    //   68: lookupswitch default -> 104, -2147483648 -> 239, 0 -> 247, 1073741824 -> 258
    //   104: iload #4
    //   106: istore_1
    //   107: iload #5
    //   109: lookupswitch default -> 144, -2147483648 -> 276, 0 -> 284, 1073741824 -> 294
    //   144: iload_3
    //   145: istore_2
    //   146: aload_0
    //   147: getfield mLayoutWidget : Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   150: iconst_0
    //   151: invokevirtual setMinWidth : (I)V
    //   154: aload_0
    //   155: getfield mLayoutWidget : Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   158: iconst_0
    //   159: invokevirtual setMinHeight : (I)V
    //   162: aload_0
    //   163: getfield mLayoutWidget : Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   166: aload #11
    //   168: invokevirtual setHorizontalDimensionBehaviour : (Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;)V
    //   171: aload_0
    //   172: getfield mLayoutWidget : Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   175: iload_1
    //   176: invokevirtual setWidth : (I)V
    //   179: aload_0
    //   180: getfield mLayoutWidget : Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   183: aload #12
    //   185: invokevirtual setVerticalDimensionBehaviour : (Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;)V
    //   188: aload_0
    //   189: getfield mLayoutWidget : Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   192: iload_2
    //   193: invokevirtual setHeight : (I)V
    //   196: aload_0
    //   197: getfield mLayoutWidget : Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   200: aload_0
    //   201: getfield mMinWidth : I
    //   204: aload_0
    //   205: invokevirtual getPaddingLeft : ()I
    //   208: isub
    //   209: aload_0
    //   210: invokevirtual getPaddingRight : ()I
    //   213: isub
    //   214: invokevirtual setMinWidth : (I)V
    //   217: aload_0
    //   218: getfield mLayoutWidget : Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   221: aload_0
    //   222: getfield mMinHeight : I
    //   225: aload_0
    //   226: invokevirtual getPaddingTop : ()I
    //   229: isub
    //   230: aload_0
    //   231: invokevirtual getPaddingBottom : ()I
    //   234: isub
    //   235: invokevirtual setMinHeight : (I)V
    //   238: return
    //   239: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   242: astore #11
    //   244: goto -> 107
    //   247: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   250: astore #11
    //   252: iload #4
    //   254: istore_1
    //   255: goto -> 107
    //   258: aload_0
    //   259: getfield mMaxWidth : I
    //   262: iload_1
    //   263: invokestatic min : (II)I
    //   266: iload #9
    //   268: iload #10
    //   270: iadd
    //   271: isub
    //   272: istore_1
    //   273: goto -> 107
    //   276: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   279: astore #12
    //   281: goto -> 146
    //   284: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   287: astore #12
    //   289: iload_3
    //   290: istore_2
    //   291: goto -> 146
    //   294: aload_0
    //   295: getfield mMaxHeight : I
    //   298: iload_2
    //   299: invokestatic min : (II)I
    //   302: iload #6
    //   304: iload #7
    //   306: iadd
    //   307: isub
    //   308: istore_2
    //   309: goto -> 146
  }
  
  private void updateHierarchy() {
    int j = getChildCount();
    boolean bool = false;
    int i = 0;
    while (true) {
      boolean bool1 = bool;
      if (i < j)
        if (getChildAt(i).isLayoutRequested()) {
          bool1 = true;
        } else {
          i++;
          continue;
        }  
      if (bool1) {
        this.mVariableDimensionsWidgets.clear();
        setChildrenConstraints();
      } 
      return;
    } 
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14)
      onViewAdded(paramView); 
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected LayoutParams generateDefaultLayoutParams() {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)new LayoutParams(paramLayoutParams);
  }
  
  public int getMaxHeight() {
    return this.mMaxHeight;
  }
  
  public int getMaxWidth() {
    return this.mMaxWidth;
  }
  
  public int getMinHeight() {
    return this.mMinHeight;
  }
  
  public int getMinWidth() {
    return this.mMinWidth;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt2 = getChildCount();
    paramBoolean = isInEditMode();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      View view = getChildAt(paramInt1);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      if (view.getVisibility() != 8 || layoutParams.isGuideline || paramBoolean) {
        ConstraintWidget constraintWidget = layoutParams.widget;
        paramInt3 = constraintWidget.getDrawX();
        paramInt4 = constraintWidget.getDrawY();
        view.layout(paramInt3, paramInt4, paramInt3 + constraintWidget.getWidth(), paramInt4 + constraintWidget.getHeight());
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int j = getPaddingLeft();
    int m = getPaddingTop();
    this.mLayoutWidget.setX(j);
    this.mLayoutWidget.setY(m);
    setSelfDimensionBehaviour(paramInt1, paramInt2);
    if (this.mDirtyHierarchy) {
      this.mDirtyHierarchy = false;
      updateHierarchy();
    } 
    internalMeasureChildren(paramInt1, paramInt2);
    if (getChildCount() > 0)
      solveLinearSystem(); 
    int k = 0;
    int i = 0;
    int n = this.mVariableDimensionsWidgets.size();
    int i1 = m + getPaddingBottom();
    int i2 = j + getPaddingRight();
    if (n > 0) {
      boolean bool;
      j = 0;
      if (this.mLayoutWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        m = 1;
      } else {
        m = 0;
      } 
      if (this.mLayoutWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        bool = true;
      } else {
        bool = false;
      } 
      int i3 = 0;
      while (i3 < n) {
        int i4;
        ConstraintWidget constraintWidget = this.mVariableDimensionsWidgets.get(i3);
        if (constraintWidget instanceof Guideline) {
          i4 = j;
          k = i;
        } else {
          View view = (View)constraintWidget.getCompanionWidget();
          k = i;
          i4 = j;
          if (view != null) {
            k = i;
            i4 = j;
            if (view.getVisibility() != 8) {
              LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
              if (layoutParams.width == -2) {
                k = getChildMeasureSpec(paramInt1, i2, layoutParams.width);
              } else {
                k = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
              } 
              if (layoutParams.height == -2) {
                i4 = getChildMeasureSpec(paramInt2, i1, layoutParams.height);
              } else {
                i4 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
              } 
              view.measure(k, i4);
              k = view.getMeasuredWidth();
              i4 = view.getMeasuredHeight();
              if (k != constraintWidget.getWidth()) {
                constraintWidget.setWidth(k);
                if (m != 0 && constraintWidget.getRight() > this.mLayoutWidget.getWidth()) {
                  j = constraintWidget.getRight();
                  k = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin();
                  this.mLayoutWidget.setWidth(Math.max(this.mMinWidth, j + k));
                } 
                j = 1;
              } 
              k = j;
              if (i4 != constraintWidget.getHeight()) {
                constraintWidget.setHeight(i4);
                if (bool && constraintWidget.getBottom() > this.mLayoutWidget.getHeight()) {
                  j = constraintWidget.getBottom();
                  k = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                  this.mLayoutWidget.setHeight(Math.max(this.mMinHeight, j + k));
                } 
                k = 1;
              } 
              j = k;
              if (layoutParams.needsBaseline) {
                i4 = view.getBaseline();
                j = k;
                if (i4 != -1) {
                  j = k;
                  if (i4 != constraintWidget.getBaselineDistance()) {
                    constraintWidget.setBaselineDistance(i4);
                    j = 1;
                  } 
                } 
              } 
              k = i;
              i4 = j;
              if (Build.VERSION.SDK_INT >= 11) {
                k = combineMeasuredStates(i, view.getMeasuredState());
                i4 = j;
              } 
            } 
          } 
        } 
        i3++;
        i = k;
        j = i4;
      } 
      k = i;
      if (j != 0) {
        solveLinearSystem();
        k = i;
      } 
    } 
    i = this.mLayoutWidget.getWidth() + i2;
    j = this.mLayoutWidget.getHeight() + i1;
    if (Build.VERSION.SDK_INT >= 11) {
      paramInt1 = resolveSizeAndState(i, paramInt1, k);
      paramInt2 = resolveSizeAndState(j, paramInt2, k << 16);
      paramInt1 = Math.min(this.mMaxWidth, paramInt1);
      i = Math.min(this.mMaxHeight, paramInt2);
      paramInt2 = paramInt1 & 0xFFFFFF;
      i &= 0xFFFFFF;
      paramInt1 = paramInt2;
      if (this.mLayoutWidget.isWidthMeasuredTooSmall())
        paramInt1 = paramInt2 | 0x1000000; 
      paramInt2 = i;
      if (this.mLayoutWidget.isHeightMeasuredTooSmall())
        paramInt2 = i | 0x1000000; 
      setMeasuredDimension(paramInt1, paramInt2);
      return;
    } 
    setMeasuredDimension(i, j);
  }
  
  public void onViewAdded(View paramView) {
    if (Build.VERSION.SDK_INT >= 14)
      super.onViewAdded(paramView); 
    ConstraintWidget constraintWidget = getViewWidget(paramView);
    if (paramView instanceof Guideline && !(constraintWidget instanceof Guideline)) {
      LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
      layoutParams.widget = (ConstraintWidget)new Guideline();
      layoutParams.isGuideline = true;
      ((Guideline)layoutParams.widget).setOrientation(layoutParams.orientation);
      ConstraintWidget constraintWidget1 = layoutParams.widget;
    } 
    this.mChildrenByIds.put(paramView.getId(), paramView);
    this.mDirtyHierarchy = true;
  }
  
  public void onViewRemoved(View paramView) {
    if (Build.VERSION.SDK_INT >= 14)
      super.onViewRemoved(paramView); 
    this.mChildrenByIds.remove(paramView.getId());
    this.mLayoutWidget.remove(getViewWidget(paramView));
    this.mDirtyHierarchy = true;
  }
  
  public void removeView(View paramView) {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14)
      onViewRemoved(paramView); 
  }
  
  public void requestLayout() {
    super.requestLayout();
    this.mDirtyHierarchy = true;
  }
  
  public void setConstraintSet(ConstraintSet paramConstraintSet) {
    this.mConstraintSet = paramConstraintSet;
  }
  
  public void setId(int paramInt) {
    this.mChildrenByIds.remove(getId());
    super.setId(paramInt);
    this.mChildrenByIds.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt) {
    if (paramInt == this.mMaxHeight)
      return; 
    this.mMaxHeight = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt) {
    if (paramInt == this.mMaxWidth)
      return; 
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt) {
    if (paramInt == this.mMinHeight)
      return; 
    this.mMinHeight = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt) {
    if (paramInt == this.mMinWidth)
      return; 
    this.mMinWidth = paramInt;
    requestLayout();
  }
  
  public void setOptimizationLevel(int paramInt) {
    this.mLayoutWidget.setOptimizationLevel(paramInt);
  }
  
  protected void solveLinearSystem() {
    this.mLayoutWidget.layout();
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    public static final int BASELINE = 5;
    
    public static final int BOTTOM = 4;
    
    public static final int CHAIN_PACKED = 2;
    
    public static final int CHAIN_SPREAD = 0;
    
    public static final int CHAIN_SPREAD_INSIDE = 1;
    
    public static final int END = 7;
    
    public static final int HORIZONTAL = 0;
    
    public static final int LEFT = 1;
    
    public static final int MATCH_CONSTRAINT = 0;
    
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    
    public static final int PARENT_ID = 0;
    
    public static final int RIGHT = 2;
    
    public static final int START = 6;
    
    public static final int TOP = 3;
    
    public static final int UNSET = -1;
    
    public static final int VERTICAL = 1;
    
    public int baselineToBaseline = -1;
    
    public int bottomToBottom = -1;
    
    public int bottomToTop = -1;
    
    public String dimensionRatio = null;
    
    int dimensionRatioSide = 1;
    
    float dimensionRatioValue = 0.0F;
    
    public int editorAbsoluteX = -1;
    
    public int editorAbsoluteY = -1;
    
    public int endToEnd = -1;
    
    public int endToStart = -1;
    
    public int goneBottomMargin = -1;
    
    public int goneEndMargin = -1;
    
    public int goneLeftMargin = -1;
    
    public int goneRightMargin = -1;
    
    public int goneStartMargin = -1;
    
    public int goneTopMargin = -1;
    
    public int guideBegin = -1;
    
    public int guideEnd = -1;
    
    public float guidePercent = -1.0F;
    
    public float horizontalBias = 0.5F;
    
    public int horizontalChainStyle = 0;
    
    boolean horizontalDimensionFixed = true;
    
    public float horizontalWeight = 0.0F;
    
    boolean isGuideline = false;
    
    public int leftToLeft = -1;
    
    public int leftToRight = -1;
    
    public int matchConstraintDefaultHeight = 0;
    
    public int matchConstraintDefaultWidth = 0;
    
    public int matchConstraintMaxHeight = 0;
    
    public int matchConstraintMaxWidth = 0;
    
    public int matchConstraintMinHeight = 0;
    
    public int matchConstraintMinWidth = 0;
    
    boolean needsBaseline = false;
    
    public int orientation = -1;
    
    int resolveGoneLeftMargin = -1;
    
    int resolveGoneRightMargin = -1;
    
    float resolvedHorizontalBias = 0.5F;
    
    int resolvedLeftToLeft = -1;
    
    int resolvedLeftToRight = -1;
    
    int resolvedRightToLeft = -1;
    
    int resolvedRightToRight = -1;
    
    public int rightToLeft = -1;
    
    public int rightToRight = -1;
    
    public int startToEnd = -1;
    
    public int startToStart = -1;
    
    public int topToBottom = -1;
    
    public int topToTop = -1;
    
    public float verticalBias = 0.5F;
    
    public int verticalChainStyle = 0;
    
    boolean verticalDimensionFixed = true;
    
    public float verticalWeight = 0.0F;
    
    ConstraintWidget widget = new ConstraintWidget();
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = typedArray.getIndexCount();
      for (int i = 0; i < j; i++) {
        int k = typedArray.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf) {
          this.leftToLeft = typedArray.getResourceId(k, this.leftToLeft);
          if (this.leftToLeft == -1)
            this.leftToLeft = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf) {
          this.leftToRight = typedArray.getResourceId(k, this.leftToRight);
          if (this.leftToRight == -1)
            this.leftToRight = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf) {
          this.rightToLeft = typedArray.getResourceId(k, this.rightToLeft);
          if (this.rightToLeft == -1)
            this.rightToLeft = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf) {
          this.rightToRight = typedArray.getResourceId(k, this.rightToRight);
          if (this.rightToRight == -1)
            this.rightToRight = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf) {
          this.topToTop = typedArray.getResourceId(k, this.topToTop);
          if (this.topToTop == -1)
            this.topToTop = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf) {
          this.topToBottom = typedArray.getResourceId(k, this.topToBottom);
          if (this.topToBottom == -1)
            this.topToBottom = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf) {
          this.bottomToTop = typedArray.getResourceId(k, this.bottomToTop);
          if (this.bottomToTop == -1)
            this.bottomToTop = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf) {
          this.bottomToBottom = typedArray.getResourceId(k, this.bottomToBottom);
          if (this.bottomToBottom == -1)
            this.bottomToBottom = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf) {
          this.baselineToBaseline = typedArray.getResourceId(k, this.baselineToBaseline);
          if (this.baselineToBaseline == -1)
            this.baselineToBaseline = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX) {
          this.editorAbsoluteX = typedArray.getDimensionPixelOffset(k, this.editorAbsoluteX);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY) {
          this.editorAbsoluteY = typedArray.getDimensionPixelOffset(k, this.editorAbsoluteY);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin) {
          this.guideBegin = typedArray.getDimensionPixelOffset(k, this.guideBegin);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end) {
          this.guideEnd = typedArray.getDimensionPixelOffset(k, this.guideEnd);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent) {
          this.guidePercent = typedArray.getFloat(k, this.guidePercent);
        } else if (k == R.styleable.ConstraintLayout_Layout_android_orientation) {
          this.orientation = typedArray.getInt(k, this.orientation);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf) {
          this.startToEnd = typedArray.getResourceId(k, this.startToEnd);
          if (this.startToEnd == -1)
            this.startToEnd = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf) {
          this.startToStart = typedArray.getResourceId(k, this.startToStart);
          if (this.startToStart == -1)
            this.startToStart = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf) {
          this.endToStart = typedArray.getResourceId(k, this.endToStart);
          if (this.endToStart == -1)
            this.endToStart = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf) {
          this.endToEnd = typedArray.getResourceId(k, this.endToEnd);
          if (this.endToEnd == -1)
            this.endToEnd = typedArray.getInt(k, -1); 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft) {
          this.goneLeftMargin = typedArray.getDimensionPixelSize(k, this.goneLeftMargin);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginTop) {
          this.goneTopMargin = typedArray.getDimensionPixelSize(k, this.goneTopMargin);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginRight) {
          this.goneRightMargin = typedArray.getDimensionPixelSize(k, this.goneRightMargin);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom) {
          this.goneBottomMargin = typedArray.getDimensionPixelSize(k, this.goneBottomMargin);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginStart) {
          this.goneStartMargin = typedArray.getDimensionPixelSize(k, this.goneStartMargin);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd) {
          this.goneEndMargin = typedArray.getDimensionPixelSize(k, this.goneEndMargin);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias) {
          this.horizontalBias = typedArray.getFloat(k, this.horizontalBias);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias) {
          this.verticalBias = typedArray.getFloat(k, this.verticalBias);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio) {
          this.dimensionRatio = typedArray.getString(k);
          this.dimensionRatioValue = Float.NaN;
          this.dimensionRatioSide = -1;
          if (this.dimensionRatio != null) {
            int m = this.dimensionRatio.length();
            k = this.dimensionRatio.indexOf(',');
            if (k > 0 && k < m - 1) {
              String str = this.dimensionRatio.substring(0, k);
              if (str.equalsIgnoreCase("W")) {
                this.dimensionRatioSide = 0;
              } else if (str.equalsIgnoreCase("H")) {
                this.dimensionRatioSide = 1;
              } 
              k++;
            } else {
              k = 0;
            } 
            int n = this.dimensionRatio.indexOf(':');
            if (n >= 0 && n < m - 1) {
              String str1 = this.dimensionRatio.substring(k, n);
              String str2 = this.dimensionRatio.substring(n + 1);
              if (str1.length() > 0 && str2.length() > 0)
                try {
                  float f1 = Float.parseFloat(str1);
                  float f2 = Float.parseFloat(str2);
                  if (f1 > 0.0F && f2 > 0.0F)
                    if (this.dimensionRatioSide == 1) {
                      this.dimensionRatioValue = Math.abs(f2 / f1);
                    } else {
                      f1 /= f2;
                      this.dimensionRatioValue = Math.abs(f1);
                    }  
                } catch (NumberFormatException numberFormatException) {} 
            } else {
              String str = this.dimensionRatio.substring(k);
              if (str.length() > 0)
                try {
                  this.dimensionRatioValue = Float.parseFloat(str);
                } catch (NumberFormatException numberFormatException) {} 
            } 
          } 
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight) {
          this.horizontalWeight = typedArray.getFloat(k, 0.0F);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight) {
          this.verticalWeight = typedArray.getFloat(k, 0.0F);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle) {
          this.horizontalChainStyle = typedArray.getInt(k, 0);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle) {
          this.verticalChainStyle = typedArray.getInt(k, 0);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default) {
          this.matchConstraintDefaultWidth = typedArray.getInt(k, 0);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default) {
          this.matchConstraintDefaultHeight = typedArray.getInt(k, 0);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min) {
          this.matchConstraintMinWidth = typedArray.getDimensionPixelSize(k, this.matchConstraintMinWidth);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max) {
          this.matchConstraintMaxWidth = typedArray.getDimensionPixelSize(k, this.matchConstraintMaxWidth);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min) {
          this.matchConstraintMinHeight = typedArray.getDimensionPixelSize(k, this.matchConstraintMinHeight);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max) {
          this.matchConstraintMaxHeight = typedArray.getDimensionPixelSize(k, this.matchConstraintMaxHeight);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator || k == R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator || k == R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator || k == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator || k == R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator) {
        
        } 
      } 
      typedArray.recycle();
      validate();
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.guideBegin = param1LayoutParams.guideBegin;
      this.guideEnd = param1LayoutParams.guideEnd;
      this.guidePercent = param1LayoutParams.guidePercent;
      this.leftToLeft = param1LayoutParams.leftToLeft;
      this.leftToRight = param1LayoutParams.leftToRight;
      this.rightToLeft = param1LayoutParams.rightToLeft;
      this.rightToRight = param1LayoutParams.rightToRight;
      this.topToTop = param1LayoutParams.topToTop;
      this.topToBottom = param1LayoutParams.topToBottom;
      this.bottomToTop = param1LayoutParams.bottomToTop;
      this.bottomToBottom = param1LayoutParams.bottomToBottom;
      this.baselineToBaseline = param1LayoutParams.baselineToBaseline;
      this.startToEnd = param1LayoutParams.startToEnd;
      this.startToStart = param1LayoutParams.startToStart;
      this.endToStart = param1LayoutParams.endToStart;
      this.endToEnd = param1LayoutParams.endToEnd;
      this.goneLeftMargin = param1LayoutParams.goneLeftMargin;
      this.goneTopMargin = param1LayoutParams.goneTopMargin;
      this.goneRightMargin = param1LayoutParams.goneRightMargin;
      this.goneBottomMargin = param1LayoutParams.goneBottomMargin;
      this.goneStartMargin = param1LayoutParams.goneStartMargin;
      this.goneEndMargin = param1LayoutParams.goneEndMargin;
      this.horizontalBias = param1LayoutParams.horizontalBias;
      this.verticalBias = param1LayoutParams.verticalBias;
      this.dimensionRatio = param1LayoutParams.dimensionRatio;
      this.dimensionRatioValue = param1LayoutParams.dimensionRatioValue;
      this.dimensionRatioSide = param1LayoutParams.dimensionRatioSide;
      this.horizontalWeight = param1LayoutParams.horizontalWeight;
      this.verticalWeight = param1LayoutParams.verticalWeight;
      this.horizontalChainStyle = param1LayoutParams.horizontalChainStyle;
      this.verticalChainStyle = param1LayoutParams.verticalChainStyle;
      this.matchConstraintDefaultWidth = param1LayoutParams.matchConstraintDefaultWidth;
      this.matchConstraintDefaultHeight = param1LayoutParams.matchConstraintDefaultHeight;
      this.matchConstraintMinWidth = param1LayoutParams.matchConstraintMinWidth;
      this.matchConstraintMaxWidth = param1LayoutParams.matchConstraintMaxWidth;
      this.matchConstraintMinHeight = param1LayoutParams.matchConstraintMinHeight;
      this.matchConstraintMaxHeight = param1LayoutParams.matchConstraintMaxHeight;
      this.editorAbsoluteX = param1LayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = param1LayoutParams.editorAbsoluteY;
      this.orientation = param1LayoutParams.orientation;
      this.horizontalDimensionFixed = param1LayoutParams.horizontalDimensionFixed;
      this.verticalDimensionFixed = param1LayoutParams.verticalDimensionFixed;
      this.needsBaseline = param1LayoutParams.needsBaseline;
      this.isGuideline = param1LayoutParams.isGuideline;
      this.resolvedLeftToLeft = param1LayoutParams.resolvedLeftToLeft;
      this.resolvedLeftToRight = param1LayoutParams.resolvedLeftToRight;
      this.resolvedRightToLeft = param1LayoutParams.resolvedRightToLeft;
      this.resolvedRightToRight = param1LayoutParams.resolvedRightToRight;
      this.resolveGoneLeftMargin = param1LayoutParams.resolveGoneLeftMargin;
      this.resolveGoneRightMargin = param1LayoutParams.resolveGoneRightMargin;
      this.resolvedHorizontalBias = param1LayoutParams.resolvedHorizontalBias;
      this.widget = param1LayoutParams.widget;
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    @TargetApi(17)
    public void resolveLayoutDirection(int param1Int) {
      boolean bool = true;
      super.resolveLayoutDirection(param1Int);
      this.resolvedRightToLeft = -1;
      this.resolvedRightToRight = -1;
      this.resolvedLeftToLeft = -1;
      this.resolvedLeftToRight = -1;
      this.resolveGoneLeftMargin = -1;
      this.resolveGoneRightMargin = -1;
      this.resolveGoneLeftMargin = this.goneLeftMargin;
      this.resolveGoneRightMargin = this.goneRightMargin;
      this.resolvedHorizontalBias = this.horizontalBias;
      if (1 == getLayoutDirection()) {
        param1Int = bool;
      } else {
        param1Int = 0;
      } 
      if (param1Int != 0) {
        if (this.startToEnd != -1) {
          this.resolvedRightToLeft = this.startToEnd;
        } else if (this.startToStart != -1) {
          this.resolvedRightToRight = this.startToStart;
        } 
        if (this.endToStart != -1)
          this.resolvedLeftToRight = this.endToStart; 
        if (this.endToEnd != -1)
          this.resolvedLeftToLeft = this.endToEnd; 
        if (this.goneStartMargin != -1)
          this.resolveGoneRightMargin = this.goneStartMargin; 
        if (this.goneEndMargin != -1)
          this.resolveGoneLeftMargin = this.goneEndMargin; 
        this.resolvedHorizontalBias = 1.0F - this.horizontalBias;
      } else {
        if (this.startToEnd != -1)
          this.resolvedLeftToRight = this.startToEnd; 
        if (this.startToStart != -1)
          this.resolvedLeftToLeft = this.startToStart; 
        if (this.endToStart != -1)
          this.resolvedRightToLeft = this.endToStart; 
        if (this.endToEnd != -1)
          this.resolvedRightToRight = this.endToEnd; 
        if (this.goneStartMargin != -1)
          this.resolveGoneLeftMargin = this.goneStartMargin; 
        if (this.goneEndMargin != -1)
          this.resolveGoneRightMargin = this.goneEndMargin; 
      } 
      if (this.endToStart == -1 && this.endToEnd == -1)
        if (this.rightToLeft != -1) {
          this.resolvedRightToLeft = this.rightToLeft;
        } else if (this.rightToRight != -1) {
          this.resolvedRightToRight = this.rightToRight;
        }  
      if (this.startToStart == -1 && this.startToEnd == -1) {
        if (this.leftToLeft != -1) {
          this.resolvedLeftToLeft = this.leftToLeft;
          return;
        } 
      } else {
        return;
      } 
      if (this.leftToRight != -1) {
        this.resolvedLeftToRight = this.leftToRight;
        return;
      } 
    }
    
    public void validate() {
      this.isGuideline = false;
      this.horizontalDimensionFixed = true;
      this.verticalDimensionFixed = true;
      if (this.width == 0 || this.width == -1)
        this.horizontalDimensionFixed = false; 
      if (this.height == 0 || this.height == -1)
        this.verticalDimensionFixed = false; 
      if (this.guidePercent != -1.0F || this.guideBegin != -1 || this.guideEnd != -1) {
        this.isGuideline = true;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        if (!(this.widget instanceof Guideline))
          this.widget = (ConstraintWidget)new Guideline(); 
        ((Guideline)this.widget).setOrientation(this.orientation);
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\ConstraintLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */