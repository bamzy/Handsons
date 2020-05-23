package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

public class ConstraintWidget {
  private static final boolean AUTOTAG_CENTER = false;
  
  public static final int CHAIN_PACKED = 2;
  
  public static final int CHAIN_SPREAD = 0;
  
  public static final int CHAIN_SPREAD_INSIDE = 1;
  
  public static float DEFAULT_BIAS = 0.5F;
  
  protected static final int DIRECT = 2;
  
  public static final int GONE = 8;
  
  public static final int HORIZONTAL = 0;
  
  public static final int INVISIBLE = 4;
  
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  
  protected static final int SOLVER = 1;
  
  public static final int UNKNOWN = -1;
  
  public static final int VERTICAL = 1;
  
  public static final int VISIBLE = 0;
  
  protected ArrayList<ConstraintAnchor> mAnchors = new ArrayList<ConstraintAnchor>();
  
  ConstraintAnchor mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
  
  int mBaselineDistance = 0;
  
  ConstraintAnchor mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
  
  boolean mBottomHasCentered;
  
  ConstraintAnchor mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
  
  ConstraintAnchor mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
  
  ConstraintAnchor mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
  
  private Object mCompanionWidget;
  
  private int mContainerItemSkip = 0;
  
  private String mDebugName = null;
  
  protected float mDimensionRatio = 0.0F;
  
  protected int mDimensionRatioSide = -1;
  
  int mDistToBottom;
  
  int mDistToLeft;
  
  int mDistToRight;
  
  int mDistToTop;
  
  private int mDrawHeight = 0;
  
  private int mDrawWidth = 0;
  
  private int mDrawX = 0;
  
  private int mDrawY = 0;
  
  int mHeight = 0;
  
  float mHorizontalBiasPercent = DEFAULT_BIAS;
  
  boolean mHorizontalChainFixedPosition;
  
  int mHorizontalChainStyle = 0;
  
  DimensionBehaviour mHorizontalDimensionBehaviour = DimensionBehaviour.FIXED;
  
  ConstraintWidget mHorizontalNextWidget = null;
  
  public int mHorizontalResolution = -1;
  
  float mHorizontalWeight = 0.0F;
  
  boolean mHorizontalWrapVisited;
  
  ConstraintAnchor mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
  
  boolean mLeftHasCentered;
  
  int mMatchConstraintDefaultHeight = 0;
  
  int mMatchConstraintDefaultWidth = 0;
  
  int mMatchConstraintMaxHeight = 0;
  
  int mMatchConstraintMaxWidth = 0;
  
  int mMatchConstraintMinHeight = 0;
  
  int mMatchConstraintMinWidth = 0;
  
  protected int mMinHeight;
  
  protected int mMinWidth;
  
  protected int mOffsetX = 0;
  
  protected int mOffsetY = 0;
  
  ConstraintWidget mParent = null;
  
  ConstraintAnchor mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
  
  boolean mRightHasCentered;
  
  private int mSolverBottom = 0;
  
  private int mSolverLeft = 0;
  
  private int mSolverRight = 0;
  
  private int mSolverTop = 0;
  
  ConstraintAnchor mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
  
  boolean mTopHasCentered;
  
  private String mType = null;
  
  float mVerticalBiasPercent = DEFAULT_BIAS;
  
  boolean mVerticalChainFixedPosition;
  
  int mVerticalChainStyle = 0;
  
  DimensionBehaviour mVerticalDimensionBehaviour = DimensionBehaviour.FIXED;
  
  ConstraintWidget mVerticalNextWidget = null;
  
  public int mVerticalResolution = -1;
  
  float mVerticalWeight = 0.0F;
  
  boolean mVerticalWrapVisited;
  
  private int mVisibility = 0;
  
  int mWidth = 0;
  
  private int mWrapHeight;
  
  private int mWrapWidth;
  
  protected int mX = 0;
  
  protected int mY = 0;
  
  public ConstraintWidget() {
    addAnchors();
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2) {
    this(0, 0, paramInt1, paramInt2);
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mX = paramInt1;
    this.mY = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
    addAnchors();
    forceUpdateDrawPosition();
  }
  
  private void addAnchors() {
    this.mAnchors.add(this.mLeft);
    this.mAnchors.add(this.mTop);
    this.mAnchors.add(this.mRight);
    this.mAnchors.add(this.mBottom);
    this.mAnchors.add(this.mCenterX);
    this.mAnchors.add(this.mCenterY);
    this.mAnchors.add(this.mBaseline);
  }
  
  private void applyConstraints(LinearSystem paramLinearSystem, boolean paramBoolean1, boolean paramBoolean2, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7) {
    SolverVariable solverVariable3 = paramLinearSystem.createObjectVariable(paramConstraintAnchor1);
    SolverVariable solverVariable1 = paramLinearSystem.createObjectVariable(paramConstraintAnchor2);
    SolverVariable solverVariable4 = paramLinearSystem.createObjectVariable(paramConstraintAnchor1.getTarget());
    SolverVariable solverVariable2 = paramLinearSystem.createObjectVariable(paramConstraintAnchor2.getTarget());
    int i = paramConstraintAnchor1.getMargin();
    int j = paramConstraintAnchor2.getMargin();
    if (this.mVisibility == 8) {
      paramInt3 = 0;
      paramBoolean2 = true;
    } 
    if (solverVariable4 == null && solverVariable2 == null) {
      paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable3, paramInt1));
      if (!paramBoolean3) {
        if (paramBoolean1) {
          paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, solverVariable1, solverVariable3, paramInt4, true));
          return;
        } 
      } else {
        return;
      } 
      if (paramBoolean2) {
        paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, solverVariable1, solverVariable3, paramInt3, false));
        return;
      } 
      paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable1, paramInt2));
      return;
    } 
    if (solverVariable4 != null && solverVariable2 == null) {
      paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable3, solverVariable4, i));
      if (paramBoolean1) {
        paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, solverVariable1, solverVariable3, paramInt4, true));
        return;
      } 
      if (!paramBoolean3) {
        if (paramBoolean2) {
          paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable1, solverVariable3, paramInt3));
          return;
        } 
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable1, paramInt2));
        return;
      } 
      return;
    } 
    if (solverVariable4 == null && solverVariable2 != null) {
      paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable1, solverVariable2, j * -1));
      if (paramBoolean1) {
        paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, solverVariable1, solverVariable3, paramInt4, true));
        return;
      } 
      if (!paramBoolean3) {
        if (paramBoolean2) {
          paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable1, solverVariable3, paramInt3));
          return;
        } 
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable3, paramInt1));
        return;
      } 
      return;
    } 
    if (paramBoolean2) {
      SolverVariable solverVariable;
      ArrayRow arrayRow;
      if (paramBoolean1) {
        paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, solverVariable1, solverVariable3, paramInt4, true));
      } else {
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable1, solverVariable3, paramInt3));
      } 
      if (paramConstraintAnchor1.getStrength() != paramConstraintAnchor2.getStrength()) {
        if (paramConstraintAnchor1.getStrength() == ConstraintAnchor.Strength.STRONG) {
          paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable3, solverVariable4, i));
          SolverVariable solverVariable5 = paramLinearSystem.createSlackVariable();
          ArrayRow arrayRow1 = paramLinearSystem.createRow();
          arrayRow1.createRowLowerThan(solverVariable1, solverVariable2, solverVariable5, j * -1);
          paramLinearSystem.addConstraint(arrayRow1);
          return;
        } 
        solverVariable = paramLinearSystem.createSlackVariable();
        arrayRow = paramLinearSystem.createRow();
        arrayRow.createRowGreaterThan(solverVariable3, solverVariable4, solverVariable, i);
        paramLinearSystem.addConstraint(arrayRow);
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable1, solverVariable2, j * -1));
        return;
      } 
      if (solverVariable4 == solverVariable2) {
        paramLinearSystem.addConstraint(LinearSystem.createRowCentering(paramLinearSystem, solverVariable3, solverVariable4, 0, 0.5F, solverVariable2, solverVariable1, 0, true));
        return;
      } 
      if (!paramBoolean4) {
        if (solverVariable.getConnectionType() != ConstraintAnchor.ConnectionType.STRICT) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        } 
        paramLinearSystem.addConstraint(LinearSystem.createRowGreaterThan(paramLinearSystem, solverVariable3, solverVariable4, i, paramBoolean1));
        if (arrayRow.getConnectionType() != ConstraintAnchor.ConnectionType.STRICT) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        } 
        paramLinearSystem.addConstraint(LinearSystem.createRowLowerThan(paramLinearSystem, solverVariable1, solverVariable2, j * -1, paramBoolean1));
        paramLinearSystem.addConstraint(LinearSystem.createRowCentering(paramLinearSystem, solverVariable3, solverVariable4, i, paramFloat, solverVariable2, solverVariable1, j, false));
        return;
      } 
      return;
    } 
    if (paramBoolean3) {
      paramLinearSystem.addGreaterThan(solverVariable3, solverVariable4, i, 3);
      paramLinearSystem.addLowerThan(solverVariable1, solverVariable2, j * -1, 3);
      paramLinearSystem.addConstraint(LinearSystem.createRowCentering(paramLinearSystem, solverVariable3, solverVariable4, i, paramFloat, solverVariable2, solverVariable1, j, true));
      return;
    } 
    if (!paramBoolean4) {
      if (paramInt5 == 1) {
        paramInt1 = paramInt3;
        if (paramInt6 > paramInt3)
          paramInt1 = paramInt6; 
        paramInt2 = paramInt1;
        if (paramInt7 > 0)
          if (paramInt7 < paramInt1) {
            paramInt2 = paramInt7;
          } else {
            paramLinearSystem.addLowerThan(solverVariable1, solverVariable3, paramInt7, 3);
            paramInt2 = paramInt1;
          }  
        paramLinearSystem.addEquality(solverVariable1, solverVariable3, paramInt2, 3);
        paramLinearSystem.addGreaterThan(solverVariable3, solverVariable4, i, 2);
        paramLinearSystem.addLowerThan(solverVariable1, solverVariable2, -j, 2);
        paramLinearSystem.addCentering(solverVariable3, solverVariable4, i, paramFloat, solverVariable2, solverVariable1, j, 4);
        return;
      } 
      if (paramInt6 == 0 && paramInt7 == 0) {
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable3, solverVariable4, i));
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(solverVariable1, solverVariable2, j * -1));
        return;
      } 
      if (paramInt7 > 0)
        paramLinearSystem.addLowerThan(solverVariable1, solverVariable3, paramInt7, 3); 
      paramLinearSystem.addGreaterThan(solverVariable3, solverVariable4, i, 2);
      paramLinearSystem.addLowerThan(solverVariable1, solverVariable2, -j, 2);
      paramLinearSystem.addCentering(solverVariable3, solverVariable4, i, paramFloat, solverVariable2, solverVariable1, j, 4);
      return;
    } 
  }
  
  public void addToSolver(LinearSystem paramLinearSystem) {
    addToSolver(paramLinearSystem, 2147483647);
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, int paramInt) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #19
    //   3: aconst_null
    //   4: astore #20
    //   6: aconst_null
    //   7: astore #21
    //   9: aconst_null
    //   10: astore #22
    //   12: aconst_null
    //   13: astore #23
    //   15: iload_2
    //   16: ldc_w 2147483647
    //   19: if_icmpeq -> 33
    //   22: aload_0
    //   23: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   26: getfield mGroup : I
    //   29: iload_2
    //   30: if_icmpne -> 43
    //   33: aload_1
    //   34: aload_0
    //   35: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   38: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   41: astore #19
    //   43: iload_2
    //   44: ldc_w 2147483647
    //   47: if_icmpeq -> 61
    //   50: aload_0
    //   51: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   54: getfield mGroup : I
    //   57: iload_2
    //   58: if_icmpne -> 71
    //   61: aload_1
    //   62: aload_0
    //   63: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   66: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   69: astore #20
    //   71: iload_2
    //   72: ldc_w 2147483647
    //   75: if_icmpeq -> 89
    //   78: aload_0
    //   79: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   82: getfield mGroup : I
    //   85: iload_2
    //   86: if_icmpne -> 99
    //   89: aload_1
    //   90: aload_0
    //   91: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   94: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   97: astore #21
    //   99: iload_2
    //   100: ldc_w 2147483647
    //   103: if_icmpeq -> 117
    //   106: aload_0
    //   107: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   110: getfield mGroup : I
    //   113: iload_2
    //   114: if_icmpne -> 127
    //   117: aload_1
    //   118: aload_0
    //   119: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   122: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   125: astore #22
    //   127: iload_2
    //   128: ldc_w 2147483647
    //   131: if_icmpeq -> 145
    //   134: aload_0
    //   135: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   138: getfield mGroup : I
    //   141: iload_2
    //   142: if_icmpne -> 155
    //   145: aload_1
    //   146: aload_0
    //   147: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   150: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   153: astore #23
    //   155: iconst_0
    //   156: istore #17
    //   158: iconst_0
    //   159: istore #14
    //   161: iconst_0
    //   162: istore #16
    //   164: iconst_0
    //   165: istore #15
    //   167: aload_0
    //   168: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   171: ifnull -> 656
    //   174: aload_0
    //   175: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   178: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   181: ifnull -> 201
    //   184: aload_0
    //   185: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   188: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   191: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   194: aload_0
    //   195: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   198: if_acmpeq -> 236
    //   201: iload #14
    //   203: istore #13
    //   205: aload_0
    //   206: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   209: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   212: ifnull -> 251
    //   215: iload #14
    //   217: istore #13
    //   219: aload_0
    //   220: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   223: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   226: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   229: aload_0
    //   230: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   233: if_acmpne -> 251
    //   236: aload_0
    //   237: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   240: checkcast android/support/constraint/solver/widgets/ConstraintWidgetContainer
    //   243: aload_0
    //   244: iconst_0
    //   245: invokevirtual addChain : (Landroid/support/constraint/solver/widgets/ConstraintWidget;I)V
    //   248: iconst_1
    //   249: istore #13
    //   251: aload_0
    //   252: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   255: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   258: ifnull -> 278
    //   261: aload_0
    //   262: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   265: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   268: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   271: aload_0
    //   272: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   275: if_acmpeq -> 313
    //   278: iload #15
    //   280: istore #14
    //   282: aload_0
    //   283: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   286: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   289: ifnull -> 328
    //   292: iload #15
    //   294: istore #14
    //   296: aload_0
    //   297: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   300: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   303: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   306: aload_0
    //   307: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   310: if_acmpne -> 328
    //   313: aload_0
    //   314: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   317: checkcast android/support/constraint/solver/widgets/ConstraintWidgetContainer
    //   320: aload_0
    //   321: iconst_1
    //   322: invokevirtual addChain : (Landroid/support/constraint/solver/widgets/ConstraintWidget;I)V
    //   325: iconst_1
    //   326: istore #14
    //   328: aload_0
    //   329: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   332: invokevirtual getHorizontalDimensionBehaviour : ()Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   335: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   338: if_acmpne -> 480
    //   341: iload #13
    //   343: ifne -> 480
    //   346: aload_0
    //   347: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   350: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   353: ifnull -> 373
    //   356: aload_0
    //   357: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   360: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   363: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   366: aload_0
    //   367: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   370: if_acmpeq -> 1262
    //   373: aload_1
    //   374: aload_0
    //   375: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   378: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   381: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   384: astore #24
    //   386: aload_1
    //   387: invokevirtual createRow : ()Landroid/support/constraint/solver/ArrayRow;
    //   390: astore #25
    //   392: aload #25
    //   394: aload #19
    //   396: aload #24
    //   398: aload_1
    //   399: invokevirtual createSlackVariable : ()Landroid/support/constraint/solver/SolverVariable;
    //   402: iconst_0
    //   403: invokevirtual createRowGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;I)Landroid/support/constraint/solver/ArrayRow;
    //   406: pop
    //   407: aload_1
    //   408: aload #25
    //   410: invokevirtual addConstraint : (Landroid/support/constraint/solver/ArrayRow;)V
    //   413: aload_0
    //   414: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   417: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   420: ifnull -> 440
    //   423: aload_0
    //   424: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   427: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   430: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   433: aload_0
    //   434: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   437: if_acmpeq -> 1302
    //   440: aload_1
    //   441: aload_0
    //   442: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   445: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   448: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   451: astore #24
    //   453: aload_1
    //   454: invokevirtual createRow : ()Landroid/support/constraint/solver/ArrayRow;
    //   457: astore #25
    //   459: aload #25
    //   461: aload #24
    //   463: aload #20
    //   465: aload_1
    //   466: invokevirtual createSlackVariable : ()Landroid/support/constraint/solver/SolverVariable;
    //   469: iconst_0
    //   470: invokevirtual createRowGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;I)Landroid/support/constraint/solver/ArrayRow;
    //   473: pop
    //   474: aload_1
    //   475: aload #25
    //   477: invokevirtual addConstraint : (Landroid/support/constraint/solver/ArrayRow;)V
    //   480: iload #13
    //   482: istore #17
    //   484: iload #14
    //   486: istore #16
    //   488: aload_0
    //   489: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   492: invokevirtual getVerticalDimensionBehaviour : ()Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   495: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   498: if_acmpne -> 656
    //   501: iload #13
    //   503: istore #17
    //   505: iload #14
    //   507: istore #16
    //   509: iload #14
    //   511: ifne -> 656
    //   514: aload_0
    //   515: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   518: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   521: ifnull -> 541
    //   524: aload_0
    //   525: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   528: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   531: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   534: aload_0
    //   535: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   538: if_acmpeq -> 1342
    //   541: aload_1
    //   542: aload_0
    //   543: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   546: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   549: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   552: astore #24
    //   554: aload_1
    //   555: invokevirtual createRow : ()Landroid/support/constraint/solver/ArrayRow;
    //   558: astore #25
    //   560: aload #25
    //   562: aload #21
    //   564: aload #24
    //   566: aload_1
    //   567: invokevirtual createSlackVariable : ()Landroid/support/constraint/solver/SolverVariable;
    //   570: iconst_0
    //   571: invokevirtual createRowGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;I)Landroid/support/constraint/solver/ArrayRow;
    //   574: pop
    //   575: aload_1
    //   576: aload #25
    //   578: invokevirtual addConstraint : (Landroid/support/constraint/solver/ArrayRow;)V
    //   581: aload_0
    //   582: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   585: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   588: ifnull -> 608
    //   591: aload_0
    //   592: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   595: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   598: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   601: aload_0
    //   602: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   605: if_acmpeq -> 1382
    //   608: aload_1
    //   609: aload_0
    //   610: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   613: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   616: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   619: astore #24
    //   621: aload_1
    //   622: invokevirtual createRow : ()Landroid/support/constraint/solver/ArrayRow;
    //   625: astore #25
    //   627: aload #25
    //   629: aload #24
    //   631: aload #22
    //   633: aload_1
    //   634: invokevirtual createSlackVariable : ()Landroid/support/constraint/solver/SolverVariable;
    //   637: iconst_0
    //   638: invokevirtual createRowGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;I)Landroid/support/constraint/solver/ArrayRow;
    //   641: pop
    //   642: aload_1
    //   643: aload #25
    //   645: invokevirtual addConstraint : (Landroid/support/constraint/solver/ArrayRow;)V
    //   648: iload #14
    //   650: istore #16
    //   652: iload #13
    //   654: istore #17
    //   656: aload_0
    //   657: getfield mWidth : I
    //   660: istore #5
    //   662: iload #5
    //   664: istore #6
    //   666: iload #5
    //   668: aload_0
    //   669: getfield mMinWidth : I
    //   672: if_icmpge -> 681
    //   675: aload_0
    //   676: getfield mMinWidth : I
    //   679: istore #6
    //   681: aload_0
    //   682: getfield mHeight : I
    //   685: istore #5
    //   687: iload #5
    //   689: istore #8
    //   691: iload #5
    //   693: aload_0
    //   694: getfield mMinHeight : I
    //   697: if_icmpge -> 706
    //   700: aload_0
    //   701: getfield mMinHeight : I
    //   704: istore #8
    //   706: aload_0
    //   707: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   710: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   713: if_acmpeq -> 1446
    //   716: iconst_1
    //   717: istore #14
    //   719: aload_0
    //   720: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   723: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   726: if_acmpeq -> 1452
    //   729: iconst_1
    //   730: istore #15
    //   732: iload #14
    //   734: istore #13
    //   736: iload #14
    //   738: ifne -> 790
    //   741: iload #14
    //   743: istore #13
    //   745: aload_0
    //   746: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   749: ifnull -> 790
    //   752: iload #14
    //   754: istore #13
    //   756: aload_0
    //   757: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   760: ifnull -> 790
    //   763: aload_0
    //   764: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   767: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   770: ifnull -> 787
    //   773: iload #14
    //   775: istore #13
    //   777: aload_0
    //   778: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   781: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   784: ifnonnull -> 790
    //   787: iconst_1
    //   788: istore #13
    //   790: iload #15
    //   792: istore #14
    //   794: iload #15
    //   796: ifne -> 890
    //   799: iload #15
    //   801: istore #14
    //   803: aload_0
    //   804: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   807: ifnull -> 890
    //   810: iload #15
    //   812: istore #14
    //   814: aload_0
    //   815: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   818: ifnull -> 890
    //   821: aload_0
    //   822: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   825: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   828: ifnull -> 845
    //   831: iload #15
    //   833: istore #14
    //   835: aload_0
    //   836: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   839: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   842: ifnonnull -> 890
    //   845: aload_0
    //   846: getfield mBaselineDistance : I
    //   849: ifeq -> 887
    //   852: iload #15
    //   854: istore #14
    //   856: aload_0
    //   857: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   860: ifnull -> 890
    //   863: aload_0
    //   864: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   867: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   870: ifnull -> 887
    //   873: iload #15
    //   875: istore #14
    //   877: aload_0
    //   878: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   881: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   884: ifnonnull -> 890
    //   887: iconst_1
    //   888: istore #14
    //   890: iconst_0
    //   891: istore #11
    //   893: aload_0
    //   894: getfield mDimensionRatioSide : I
    //   897: istore #12
    //   899: aload_0
    //   900: getfield mDimensionRatio : F
    //   903: fstore #4
    //   905: iload #13
    //   907: istore #18
    //   909: iload #6
    //   911: istore #10
    //   913: iload #14
    //   915: istore #15
    //   917: iload #8
    //   919: istore #7
    //   921: fload #4
    //   923: fstore_3
    //   924: iload #12
    //   926: istore #5
    //   928: iload #11
    //   930: istore #9
    //   932: aload_0
    //   933: getfield mDimensionRatio : F
    //   936: fconst_0
    //   937: fcmpl
    //   938: ifle -> 1036
    //   941: iload #13
    //   943: istore #18
    //   945: iload #6
    //   947: istore #10
    //   949: iload #14
    //   951: istore #15
    //   953: iload #8
    //   955: istore #7
    //   957: fload #4
    //   959: fstore_3
    //   960: iload #12
    //   962: istore #5
    //   964: iload #11
    //   966: istore #9
    //   968: aload_0
    //   969: getfield mVisibility : I
    //   972: bipush #8
    //   974: if_icmpeq -> 1036
    //   977: aload_0
    //   978: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   981: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   984: if_acmpne -> 1592
    //   987: aload_0
    //   988: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   991: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   994: if_acmpne -> 1592
    //   997: iconst_1
    //   998: istore #11
    //   1000: iload #13
    //   1002: ifeq -> 1458
    //   1005: iload #14
    //   1007: ifne -> 1458
    //   1010: iconst_0
    //   1011: istore #5
    //   1013: iload #11
    //   1015: istore #9
    //   1017: fload #4
    //   1019: fstore_3
    //   1020: iload #8
    //   1022: istore #7
    //   1024: iload #14
    //   1026: istore #15
    //   1028: iload #6
    //   1030: istore #10
    //   1032: iload #13
    //   1034: istore #18
    //   1036: iload #9
    //   1038: ifeq -> 1721
    //   1041: iload #5
    //   1043: ifeq -> 1052
    //   1046: iload #5
    //   1048: iconst_m1
    //   1049: if_icmpne -> 1721
    //   1052: iconst_1
    //   1053: istore #13
    //   1055: aload_0
    //   1056: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1059: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1062: if_acmpne -> 1727
    //   1065: aload_0
    //   1066: instanceof android/support/constraint/solver/widgets/ConstraintWidgetContainer
    //   1069: ifeq -> 1727
    //   1072: iconst_1
    //   1073: istore #14
    //   1075: aload_0
    //   1076: getfield mHorizontalResolution : I
    //   1079: iconst_2
    //   1080: if_icmpeq -> 1253
    //   1083: iload_2
    //   1084: ldc_w 2147483647
    //   1087: if_icmpeq -> 1112
    //   1090: aload_0
    //   1091: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1094: getfield mGroup : I
    //   1097: iload_2
    //   1098: if_icmpne -> 1253
    //   1101: aload_0
    //   1102: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1105: getfield mGroup : I
    //   1108: iload_2
    //   1109: if_icmpne -> 1253
    //   1112: iload #13
    //   1114: ifeq -> 1733
    //   1117: aload_0
    //   1118: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1121: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1124: ifnull -> 1733
    //   1127: aload_0
    //   1128: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1131: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1134: ifnull -> 1733
    //   1137: aload_1
    //   1138: aload_0
    //   1139: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1142: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1145: astore #24
    //   1147: aload_1
    //   1148: aload_0
    //   1149: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1152: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1155: astore #25
    //   1157: aload_1
    //   1158: aload_0
    //   1159: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1162: invokevirtual getTarget : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1165: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1168: astore #26
    //   1170: aload_1
    //   1171: aload_0
    //   1172: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1175: invokevirtual getTarget : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1178: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1181: astore #27
    //   1183: aload_1
    //   1184: aload #24
    //   1186: aload #26
    //   1188: aload_0
    //   1189: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1192: invokevirtual getMargin : ()I
    //   1195: iconst_3
    //   1196: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1199: aload_1
    //   1200: aload #25
    //   1202: aload #27
    //   1204: aload_0
    //   1205: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1208: invokevirtual getMargin : ()I
    //   1211: iconst_m1
    //   1212: imul
    //   1213: iconst_3
    //   1214: invokevirtual addLowerThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1217: iload #17
    //   1219: ifne -> 1253
    //   1222: aload_1
    //   1223: aload #24
    //   1225: aload #26
    //   1227: aload_0
    //   1228: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1231: invokevirtual getMargin : ()I
    //   1234: aload_0
    //   1235: getfield mHorizontalBiasPercent : F
    //   1238: aload #27
    //   1240: aload #25
    //   1242: aload_0
    //   1243: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1246: invokevirtual getMargin : ()I
    //   1249: iconst_4
    //   1250: invokevirtual addCentering : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;IFLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1253: aload_0
    //   1254: getfield mVerticalResolution : I
    //   1257: iconst_2
    //   1258: if_icmpne -> 1790
    //   1261: return
    //   1262: aload_0
    //   1263: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1266: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1269: ifnull -> 413
    //   1272: aload_0
    //   1273: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1276: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1279: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1282: aload_0
    //   1283: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1286: if_acmpne -> 413
    //   1289: aload_0
    //   1290: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1293: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType.STRICT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType;
    //   1296: invokevirtual setConnectionType : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType;)V
    //   1299: goto -> 413
    //   1302: aload_0
    //   1303: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1306: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1309: ifnull -> 480
    //   1312: aload_0
    //   1313: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1316: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1319: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1322: aload_0
    //   1323: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1326: if_acmpne -> 480
    //   1329: aload_0
    //   1330: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1333: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType.STRICT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType;
    //   1336: invokevirtual setConnectionType : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType;)V
    //   1339: goto -> 480
    //   1342: aload_0
    //   1343: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1346: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1349: ifnull -> 581
    //   1352: aload_0
    //   1353: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1356: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1359: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1362: aload_0
    //   1363: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1366: if_acmpne -> 581
    //   1369: aload_0
    //   1370: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1373: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType.STRICT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType;
    //   1376: invokevirtual setConnectionType : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType;)V
    //   1379: goto -> 581
    //   1382: iload #13
    //   1384: istore #17
    //   1386: iload #14
    //   1388: istore #16
    //   1390: aload_0
    //   1391: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1394: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1397: ifnull -> 656
    //   1400: iload #13
    //   1402: istore #17
    //   1404: iload #14
    //   1406: istore #16
    //   1408: aload_0
    //   1409: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1412: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1415: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1418: aload_0
    //   1419: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1422: if_acmpne -> 656
    //   1425: aload_0
    //   1426: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1429: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType.STRICT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType;
    //   1432: invokevirtual setConnectionType : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$ConnectionType;)V
    //   1435: iload #13
    //   1437: istore #17
    //   1439: iload #14
    //   1441: istore #16
    //   1443: goto -> 656
    //   1446: iconst_0
    //   1447: istore #14
    //   1449: goto -> 719
    //   1452: iconst_0
    //   1453: istore #15
    //   1455: goto -> 732
    //   1458: iload #13
    //   1460: istore #18
    //   1462: iload #6
    //   1464: istore #10
    //   1466: iload #14
    //   1468: istore #15
    //   1470: iload #8
    //   1472: istore #7
    //   1474: fload #4
    //   1476: fstore_3
    //   1477: iload #12
    //   1479: istore #5
    //   1481: iload #11
    //   1483: istore #9
    //   1485: iload #13
    //   1487: ifne -> 1036
    //   1490: iload #13
    //   1492: istore #18
    //   1494: iload #6
    //   1496: istore #10
    //   1498: iload #14
    //   1500: istore #15
    //   1502: iload #8
    //   1504: istore #7
    //   1506: fload #4
    //   1508: fstore_3
    //   1509: iload #12
    //   1511: istore #5
    //   1513: iload #11
    //   1515: istore #9
    //   1517: iload #14
    //   1519: ifeq -> 1036
    //   1522: iconst_1
    //   1523: istore #12
    //   1525: iload #13
    //   1527: istore #18
    //   1529: iload #6
    //   1531: istore #10
    //   1533: iload #14
    //   1535: istore #15
    //   1537: iload #8
    //   1539: istore #7
    //   1541: fload #4
    //   1543: fstore_3
    //   1544: iload #12
    //   1546: istore #5
    //   1548: iload #11
    //   1550: istore #9
    //   1552: aload_0
    //   1553: getfield mDimensionRatioSide : I
    //   1556: iconst_m1
    //   1557: if_icmpne -> 1036
    //   1560: fconst_1
    //   1561: fload #4
    //   1563: fdiv
    //   1564: fstore_3
    //   1565: iload #13
    //   1567: istore #18
    //   1569: iload #6
    //   1571: istore #10
    //   1573: iload #14
    //   1575: istore #15
    //   1577: iload #8
    //   1579: istore #7
    //   1581: iload #12
    //   1583: istore #5
    //   1585: iload #11
    //   1587: istore #9
    //   1589: goto -> 1036
    //   1592: aload_0
    //   1593: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1596: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1599: if_acmpne -> 1637
    //   1602: iconst_0
    //   1603: istore #5
    //   1605: aload_0
    //   1606: getfield mHeight : I
    //   1609: i2f
    //   1610: fload #4
    //   1612: fmul
    //   1613: f2i
    //   1614: istore #10
    //   1616: iconst_1
    //   1617: istore #18
    //   1619: iload #14
    //   1621: istore #15
    //   1623: iload #8
    //   1625: istore #7
    //   1627: fload #4
    //   1629: fstore_3
    //   1630: iload #11
    //   1632: istore #9
    //   1634: goto -> 1036
    //   1637: iload #13
    //   1639: istore #18
    //   1641: iload #6
    //   1643: istore #10
    //   1645: iload #14
    //   1647: istore #15
    //   1649: iload #8
    //   1651: istore #7
    //   1653: fload #4
    //   1655: fstore_3
    //   1656: iload #12
    //   1658: istore #5
    //   1660: iload #11
    //   1662: istore #9
    //   1664: aload_0
    //   1665: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1668: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1671: if_acmpne -> 1036
    //   1674: iconst_1
    //   1675: istore #5
    //   1677: fload #4
    //   1679: fstore_3
    //   1680: aload_0
    //   1681: getfield mDimensionRatioSide : I
    //   1684: iconst_m1
    //   1685: if_icmpne -> 1693
    //   1688: fconst_1
    //   1689: fload #4
    //   1691: fdiv
    //   1692: fstore_3
    //   1693: aload_0
    //   1694: getfield mWidth : I
    //   1697: i2f
    //   1698: fload_3
    //   1699: fmul
    //   1700: f2i
    //   1701: istore #7
    //   1703: iconst_1
    //   1704: istore #15
    //   1706: iload #13
    //   1708: istore #18
    //   1710: iload #6
    //   1712: istore #10
    //   1714: iload #11
    //   1716: istore #9
    //   1718: goto -> 1036
    //   1721: iconst_0
    //   1722: istore #13
    //   1724: goto -> 1055
    //   1727: iconst_0
    //   1728: istore #14
    //   1730: goto -> 1075
    //   1733: aload_0
    //   1734: aload_1
    //   1735: iload #14
    //   1737: iload #18
    //   1739: aload_0
    //   1740: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1743: aload_0
    //   1744: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1747: aload_0
    //   1748: getfield mX : I
    //   1751: aload_0
    //   1752: getfield mX : I
    //   1755: iload #10
    //   1757: iadd
    //   1758: iload #10
    //   1760: aload_0
    //   1761: getfield mMinWidth : I
    //   1764: aload_0
    //   1765: getfield mHorizontalBiasPercent : F
    //   1768: iload #13
    //   1770: iload #17
    //   1772: aload_0
    //   1773: getfield mMatchConstraintDefaultWidth : I
    //   1776: aload_0
    //   1777: getfield mMatchConstraintMinWidth : I
    //   1780: aload_0
    //   1781: getfield mMatchConstraintMaxWidth : I
    //   1784: invokespecial applyConstraints : (Landroid/support/constraint/solver/LinearSystem;ZZLandroid/support/constraint/solver/widgets/ConstraintAnchor;Landroid/support/constraint/solver/widgets/ConstraintAnchor;IIIIFZZIII)V
    //   1787: goto -> 1253
    //   1790: aload_0
    //   1791: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1794: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1797: if_acmpne -> 2148
    //   1800: aload_0
    //   1801: instanceof android/support/constraint/solver/widgets/ConstraintWidgetContainer
    //   1804: ifeq -> 2148
    //   1807: iconst_1
    //   1808: istore #13
    //   1810: iload #9
    //   1812: ifeq -> 2154
    //   1815: iload #5
    //   1817: iconst_1
    //   1818: if_icmpeq -> 1827
    //   1821: iload #5
    //   1823: iconst_m1
    //   1824: if_icmpne -> 2154
    //   1827: iconst_1
    //   1828: istore #14
    //   1830: aload_0
    //   1831: getfield mBaselineDistance : I
    //   1834: ifle -> 2227
    //   1837: aload_0
    //   1838: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1841: astore #24
    //   1843: iload_2
    //   1844: ldc_w 2147483647
    //   1847: if_icmpeq -> 1872
    //   1850: aload_0
    //   1851: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1854: getfield mGroup : I
    //   1857: iload_2
    //   1858: if_icmpne -> 1886
    //   1861: aload_0
    //   1862: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1865: getfield mGroup : I
    //   1868: iload_2
    //   1869: if_icmpne -> 1886
    //   1872: aload_1
    //   1873: aload #23
    //   1875: aload #21
    //   1877: aload_0
    //   1878: invokevirtual getBaselineDistance : ()I
    //   1881: iconst_5
    //   1882: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   1885: pop
    //   1886: aload #24
    //   1888: astore #23
    //   1890: iload #7
    //   1892: istore #6
    //   1894: aload_0
    //   1895: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1898: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1901: ifnull -> 1916
    //   1904: aload_0
    //   1905: getfield mBaselineDistance : I
    //   1908: istore #6
    //   1910: aload_0
    //   1911: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1914: astore #23
    //   1916: iload_2
    //   1917: ldc_w 2147483647
    //   1920: if_icmpeq -> 1943
    //   1923: aload_0
    //   1924: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1927: getfield mGroup : I
    //   1930: iload_2
    //   1931: if_icmpne -> 2084
    //   1934: aload #23
    //   1936: getfield mGroup : I
    //   1939: iload_2
    //   1940: if_icmpne -> 2084
    //   1943: iload #14
    //   1945: ifeq -> 2160
    //   1948: aload_0
    //   1949: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1952: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1955: ifnull -> 2160
    //   1958: aload_0
    //   1959: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1962: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1965: ifnull -> 2160
    //   1968: aload_1
    //   1969: aload_0
    //   1970: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1973: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1976: astore #23
    //   1978: aload_1
    //   1979: aload_0
    //   1980: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1983: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1986: astore #24
    //   1988: aload_1
    //   1989: aload_0
    //   1990: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1993: invokevirtual getTarget : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1996: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1999: astore #25
    //   2001: aload_1
    //   2002: aload_0
    //   2003: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2006: invokevirtual getTarget : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2009: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   2012: astore #26
    //   2014: aload_1
    //   2015: aload #23
    //   2017: aload #25
    //   2019: aload_0
    //   2020: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2023: invokevirtual getMargin : ()I
    //   2026: iconst_3
    //   2027: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   2030: aload_1
    //   2031: aload #24
    //   2033: aload #26
    //   2035: aload_0
    //   2036: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2039: invokevirtual getMargin : ()I
    //   2042: iconst_m1
    //   2043: imul
    //   2044: iconst_3
    //   2045: invokevirtual addLowerThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   2048: iload #16
    //   2050: ifne -> 2084
    //   2053: aload_1
    //   2054: aload #23
    //   2056: aload #25
    //   2058: aload_0
    //   2059: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2062: invokevirtual getMargin : ()I
    //   2065: aload_0
    //   2066: getfield mVerticalBiasPercent : F
    //   2069: aload #26
    //   2071: aload #24
    //   2073: aload_0
    //   2074: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2077: invokevirtual getMargin : ()I
    //   2080: iconst_4
    //   2081: invokevirtual addCentering : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;IFLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   2084: iload #9
    //   2086: ifeq -> 1261
    //   2089: aload_1
    //   2090: invokevirtual createRow : ()Landroid/support/constraint/solver/ArrayRow;
    //   2093: astore #23
    //   2095: iload_2
    //   2096: ldc_w 2147483647
    //   2099: if_icmpeq -> 2124
    //   2102: aload_0
    //   2103: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2106: getfield mGroup : I
    //   2109: iload_2
    //   2110: if_icmpne -> 1261
    //   2113: aload_0
    //   2114: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2117: getfield mGroup : I
    //   2120: iload_2
    //   2121: if_icmpne -> 1261
    //   2124: iload #5
    //   2126: ifne -> 2457
    //   2129: aload_1
    //   2130: aload #23
    //   2132: aload #20
    //   2134: aload #19
    //   2136: aload #22
    //   2138: aload #21
    //   2140: fload_3
    //   2141: invokevirtual createRowDimensionRatio : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;F)Landroid/support/constraint/solver/ArrayRow;
    //   2144: invokevirtual addConstraint : (Landroid/support/constraint/solver/ArrayRow;)V
    //   2147: return
    //   2148: iconst_0
    //   2149: istore #13
    //   2151: goto -> 1810
    //   2154: iconst_0
    //   2155: istore #14
    //   2157: goto -> 1830
    //   2160: aload_0
    //   2161: aload_1
    //   2162: iload #13
    //   2164: iload #15
    //   2166: aload_0
    //   2167: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2170: aload #23
    //   2172: aload_0
    //   2173: getfield mY : I
    //   2176: aload_0
    //   2177: getfield mY : I
    //   2180: iload #6
    //   2182: iadd
    //   2183: iload #6
    //   2185: aload_0
    //   2186: getfield mMinHeight : I
    //   2189: aload_0
    //   2190: getfield mVerticalBiasPercent : F
    //   2193: iload #14
    //   2195: iload #16
    //   2197: aload_0
    //   2198: getfield mMatchConstraintDefaultHeight : I
    //   2201: aload_0
    //   2202: getfield mMatchConstraintMinHeight : I
    //   2205: aload_0
    //   2206: getfield mMatchConstraintMaxHeight : I
    //   2209: invokespecial applyConstraints : (Landroid/support/constraint/solver/LinearSystem;ZZLandroid/support/constraint/solver/widgets/ConstraintAnchor;Landroid/support/constraint/solver/widgets/ConstraintAnchor;IIIIFZZIII)V
    //   2212: aload_1
    //   2213: aload #22
    //   2215: aload #21
    //   2217: iload #7
    //   2219: iconst_5
    //   2220: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   2223: pop
    //   2224: goto -> 2084
    //   2227: iload_2
    //   2228: ldc_w 2147483647
    //   2231: if_icmpeq -> 2256
    //   2234: aload_0
    //   2235: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2238: getfield mGroup : I
    //   2241: iload_2
    //   2242: if_icmpne -> 2084
    //   2245: aload_0
    //   2246: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2249: getfield mGroup : I
    //   2252: iload_2
    //   2253: if_icmpne -> 2084
    //   2256: iload #14
    //   2258: ifeq -> 2400
    //   2261: aload_0
    //   2262: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2265: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2268: ifnull -> 2400
    //   2271: aload_0
    //   2272: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2275: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2278: ifnull -> 2400
    //   2281: aload_1
    //   2282: aload_0
    //   2283: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2286: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   2289: astore #23
    //   2291: aload_1
    //   2292: aload_0
    //   2293: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2296: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   2299: astore #24
    //   2301: aload_1
    //   2302: aload_0
    //   2303: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2306: invokevirtual getTarget : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2309: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   2312: astore #25
    //   2314: aload_1
    //   2315: aload_0
    //   2316: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2319: invokevirtual getTarget : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2322: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   2325: astore #26
    //   2327: aload_1
    //   2328: aload #23
    //   2330: aload #25
    //   2332: aload_0
    //   2333: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2336: invokevirtual getMargin : ()I
    //   2339: iconst_3
    //   2340: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   2343: aload_1
    //   2344: aload #24
    //   2346: aload #26
    //   2348: aload_0
    //   2349: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2352: invokevirtual getMargin : ()I
    //   2355: iconst_m1
    //   2356: imul
    //   2357: iconst_3
    //   2358: invokevirtual addLowerThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   2361: iload #16
    //   2363: ifne -> 2084
    //   2366: aload_1
    //   2367: aload #23
    //   2369: aload #25
    //   2371: aload_0
    //   2372: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2375: invokevirtual getMargin : ()I
    //   2378: aload_0
    //   2379: getfield mVerticalBiasPercent : F
    //   2382: aload #26
    //   2384: aload #24
    //   2386: aload_0
    //   2387: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2390: invokevirtual getMargin : ()I
    //   2393: iconst_4
    //   2394: invokevirtual addCentering : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;IFLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   2397: goto -> 2084
    //   2400: aload_0
    //   2401: aload_1
    //   2402: iload #13
    //   2404: iload #15
    //   2406: aload_0
    //   2407: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2410: aload_0
    //   2411: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2414: aload_0
    //   2415: getfield mY : I
    //   2418: aload_0
    //   2419: getfield mY : I
    //   2422: iload #7
    //   2424: iadd
    //   2425: iload #7
    //   2427: aload_0
    //   2428: getfield mMinHeight : I
    //   2431: aload_0
    //   2432: getfield mVerticalBiasPercent : F
    //   2435: iload #14
    //   2437: iload #16
    //   2439: aload_0
    //   2440: getfield mMatchConstraintDefaultHeight : I
    //   2443: aload_0
    //   2444: getfield mMatchConstraintMinHeight : I
    //   2447: aload_0
    //   2448: getfield mMatchConstraintMaxHeight : I
    //   2451: invokespecial applyConstraints : (Landroid/support/constraint/solver/LinearSystem;ZZLandroid/support/constraint/solver/widgets/ConstraintAnchor;Landroid/support/constraint/solver/widgets/ConstraintAnchor;IIIIFZZIII)V
    //   2454: goto -> 2084
    //   2457: iload #5
    //   2459: iconst_1
    //   2460: if_icmpne -> 2482
    //   2463: aload_1
    //   2464: aload #23
    //   2466: aload #22
    //   2468: aload #21
    //   2470: aload #20
    //   2472: aload #19
    //   2474: fload_3
    //   2475: invokevirtual createRowDimensionRatio : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;F)Landroid/support/constraint/solver/ArrayRow;
    //   2478: invokevirtual addConstraint : (Landroid/support/constraint/solver/ArrayRow;)V
    //   2481: return
    //   2482: aload_0
    //   2483: getfield mMatchConstraintMinWidth : I
    //   2486: ifle -> 2502
    //   2489: aload_1
    //   2490: aload #20
    //   2492: aload #19
    //   2494: aload_0
    //   2495: getfield mMatchConstraintMinWidth : I
    //   2498: iconst_3
    //   2499: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   2502: aload_0
    //   2503: getfield mMatchConstraintMinHeight : I
    //   2506: ifle -> 2522
    //   2509: aload_1
    //   2510: aload #22
    //   2512: aload #21
    //   2514: aload_0
    //   2515: getfield mMatchConstraintMinHeight : I
    //   2518: iconst_3
    //   2519: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   2522: aload #23
    //   2524: aload #20
    //   2526: aload #19
    //   2528: aload #22
    //   2530: aload #21
    //   2532: fload_3
    //   2533: invokevirtual createRowDimensionRatio : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;F)Landroid/support/constraint/solver/ArrayRow;
    //   2536: pop
    //   2537: aload_1
    //   2538: invokevirtual createErrorVariable : ()Landroid/support/constraint/solver/SolverVariable;
    //   2541: astore #19
    //   2543: aload_1
    //   2544: invokevirtual createErrorVariable : ()Landroid/support/constraint/solver/SolverVariable;
    //   2547: astore #20
    //   2549: aload #19
    //   2551: iconst_4
    //   2552: putfield strength : I
    //   2555: aload #20
    //   2557: iconst_4
    //   2558: putfield strength : I
    //   2561: aload #23
    //   2563: aload #19
    //   2565: aload #20
    //   2567: invokevirtual addError : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;)Landroid/support/constraint/solver/ArrayRow;
    //   2570: pop
    //   2571: aload_1
    //   2572: aload #23
    //   2574: invokevirtual addConstraint : (Landroid/support/constraint/solver/ArrayRow;)V
    //   2577: return
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2) {
    connect(paramType1, paramConstraintWidget, paramType2, 0, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt) {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt, ConstraintAnchor.Strength paramStrength) {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, paramStrength, 0);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2) {
    // Byte code:
    //   0: aload_1
    //   1: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   4: if_acmpne -> 404
    //   7: aload_3
    //   8: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   11: if_acmpne -> 280
    //   14: aload_0
    //   15: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   18: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   21: astore_1
    //   22: aload_0
    //   23: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   26: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   29: astore_3
    //   30: aload_0
    //   31: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   34: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   37: astore #9
    //   39: aload_0
    //   40: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   43: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   46: astore #10
    //   48: iconst_0
    //   49: istore #7
    //   51: iconst_0
    //   52: istore #8
    //   54: aload_1
    //   55: ifnull -> 69
    //   58: iload #7
    //   60: istore #4
    //   62: aload_1
    //   63: invokevirtual isConnected : ()Z
    //   66: ifne -> 84
    //   69: aload_3
    //   70: ifnull -> 150
    //   73: aload_3
    //   74: invokevirtual isConnected : ()Z
    //   77: ifeq -> 150
    //   80: iload #7
    //   82: istore #4
    //   84: aload #9
    //   86: ifnull -> 101
    //   89: iload #8
    //   91: istore #7
    //   93: aload #9
    //   95: invokevirtual isConnected : ()Z
    //   98: ifne -> 118
    //   101: aload #10
    //   103: ifnull -> 188
    //   106: aload #10
    //   108: invokevirtual isConnected : ()Z
    //   111: ifeq -> 188
    //   114: iload #8
    //   116: istore #7
    //   118: iload #4
    //   120: ifeq -> 226
    //   123: iload #7
    //   125: ifeq -> 226
    //   128: aload_0
    //   129: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   132: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   135: aload_2
    //   136: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   139: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   142: iconst_0
    //   143: iload #6
    //   145: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   148: pop
    //   149: return
    //   150: aload_0
    //   151: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   154: aload_2
    //   155: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   158: iconst_0
    //   159: aload #5
    //   161: iload #6
    //   163: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;ILandroid/support/constraint/solver/widgets/ConstraintAnchor$Strength;I)V
    //   166: aload_0
    //   167: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   170: aload_2
    //   171: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   174: iconst_0
    //   175: aload #5
    //   177: iload #6
    //   179: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;ILandroid/support/constraint/solver/widgets/ConstraintAnchor$Strength;I)V
    //   182: iconst_1
    //   183: istore #4
    //   185: goto -> 84
    //   188: aload_0
    //   189: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   192: aload_2
    //   193: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   196: iconst_0
    //   197: aload #5
    //   199: iload #6
    //   201: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;ILandroid/support/constraint/solver/widgets/ConstraintAnchor$Strength;I)V
    //   204: aload_0
    //   205: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   208: aload_2
    //   209: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   212: iconst_0
    //   213: aload #5
    //   215: iload #6
    //   217: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;ILandroid/support/constraint/solver/widgets/ConstraintAnchor$Strength;I)V
    //   220: iconst_1
    //   221: istore #7
    //   223: goto -> 118
    //   226: iload #4
    //   228: ifeq -> 253
    //   231: aload_0
    //   232: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_X : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   235: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   238: aload_2
    //   239: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_X : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   242: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   245: iconst_0
    //   246: iload #6
    //   248: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   251: pop
    //   252: return
    //   253: iload #7
    //   255: ifeq -> 149
    //   258: aload_0
    //   259: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_Y : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   262: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   265: aload_2
    //   266: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_Y : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   269: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   272: iconst_0
    //   273: iload #6
    //   275: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   278: pop
    //   279: return
    //   280: aload_3
    //   281: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   284: if_acmpeq -> 294
    //   287: aload_3
    //   288: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   291: if_acmpne -> 342
    //   294: aload_0
    //   295: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   298: aload_2
    //   299: aload_3
    //   300: iconst_0
    //   301: aload #5
    //   303: iload #6
    //   305: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;ILandroid/support/constraint/solver/widgets/ConstraintAnchor$Strength;I)V
    //   308: aload_0
    //   309: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   312: aload_2
    //   313: aload_3
    //   314: iconst_0
    //   315: aload #5
    //   317: iload #6
    //   319: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;ILandroid/support/constraint/solver/widgets/ConstraintAnchor$Strength;I)V
    //   322: aload_0
    //   323: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   326: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   329: aload_2
    //   330: aload_3
    //   331: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   334: iconst_0
    //   335: iload #6
    //   337: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   340: pop
    //   341: return
    //   342: aload_3
    //   343: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   346: if_acmpeq -> 356
    //   349: aload_3
    //   350: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   353: if_acmpne -> 149
    //   356: aload_0
    //   357: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   360: aload_2
    //   361: aload_3
    //   362: iconst_0
    //   363: aload #5
    //   365: iload #6
    //   367: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;ILandroid/support/constraint/solver/widgets/ConstraintAnchor$Strength;I)V
    //   370: aload_0
    //   371: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   374: aload_2
    //   375: aload_3
    //   376: iconst_0
    //   377: aload #5
    //   379: iload #6
    //   381: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;ILandroid/support/constraint/solver/widgets/ConstraintAnchor$Strength;I)V
    //   384: aload_0
    //   385: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   388: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   391: aload_2
    //   392: aload_3
    //   393: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   396: iconst_0
    //   397: iload #6
    //   399: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   402: pop
    //   403: return
    //   404: aload_1
    //   405: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_X : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   408: if_acmpne -> 481
    //   411: aload_3
    //   412: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   415: if_acmpeq -> 425
    //   418: aload_3
    //   419: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   422: if_acmpne -> 481
    //   425: aload_0
    //   426: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   429: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   432: astore_1
    //   433: aload_2
    //   434: aload_3
    //   435: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   438: astore_2
    //   439: aload_0
    //   440: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   443: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   446: astore_3
    //   447: aload_1
    //   448: aload_2
    //   449: iconst_0
    //   450: iload #6
    //   452: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   455: pop
    //   456: aload_3
    //   457: aload_2
    //   458: iconst_0
    //   459: iload #6
    //   461: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   464: pop
    //   465: aload_0
    //   466: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_X : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   469: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   472: aload_2
    //   473: iconst_0
    //   474: iload #6
    //   476: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   479: pop
    //   480: return
    //   481: aload_1
    //   482: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_Y : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   485: if_acmpne -> 554
    //   488: aload_3
    //   489: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   492: if_acmpeq -> 502
    //   495: aload_3
    //   496: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   499: if_acmpne -> 554
    //   502: aload_2
    //   503: aload_3
    //   504: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   507: astore_1
    //   508: aload_0
    //   509: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   512: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   515: aload_1
    //   516: iconst_0
    //   517: iload #6
    //   519: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   522: pop
    //   523: aload_0
    //   524: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   527: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   530: aload_1
    //   531: iconst_0
    //   532: iload #6
    //   534: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   537: pop
    //   538: aload_0
    //   539: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_Y : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   542: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   545: aload_1
    //   546: iconst_0
    //   547: iload #6
    //   549: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   552: pop
    //   553: return
    //   554: aload_1
    //   555: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_X : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   558: if_acmpne -> 630
    //   561: aload_3
    //   562: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_X : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   565: if_acmpne -> 630
    //   568: aload_0
    //   569: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   572: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   575: aload_2
    //   576: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   579: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   582: iconst_0
    //   583: iload #6
    //   585: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   588: pop
    //   589: aload_0
    //   590: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   593: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   596: aload_2
    //   597: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   600: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   603: iconst_0
    //   604: iload #6
    //   606: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   609: pop
    //   610: aload_0
    //   611: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_X : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   614: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   617: aload_2
    //   618: aload_3
    //   619: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   622: iconst_0
    //   623: iload #6
    //   625: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   628: pop
    //   629: return
    //   630: aload_1
    //   631: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_Y : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   634: if_acmpne -> 706
    //   637: aload_3
    //   638: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_Y : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   641: if_acmpne -> 706
    //   644: aload_0
    //   645: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   648: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   651: aload_2
    //   652: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   655: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   658: iconst_0
    //   659: iload #6
    //   661: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   664: pop
    //   665: aload_0
    //   666: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   669: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   672: aload_2
    //   673: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   676: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   679: iconst_0
    //   680: iload #6
    //   682: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   685: pop
    //   686: aload_0
    //   687: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_Y : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   690: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   693: aload_2
    //   694: aload_3
    //   695: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   698: iconst_0
    //   699: iload #6
    //   701: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;II)Z
    //   704: pop
    //   705: return
    //   706: aload_0
    //   707: aload_1
    //   708: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   711: astore #9
    //   713: aload_2
    //   714: aload_3
    //   715: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   718: astore_2
    //   719: aload #9
    //   721: aload_2
    //   722: invokevirtual isValidConnection : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;)Z
    //   725: ifeq -> 149
    //   728: aload_1
    //   729: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BASELINE : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   732: if_acmpne -> 796
    //   735: aload_0
    //   736: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   739: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   742: astore_1
    //   743: aload_0
    //   744: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   747: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   750: astore_3
    //   751: aload_1
    //   752: ifnull -> 759
    //   755: aload_1
    //   756: invokevirtual reset : ()V
    //   759: aload_3
    //   760: ifnull -> 767
    //   763: aload_3
    //   764: invokevirtual reset : ()V
    //   767: iconst_0
    //   768: istore #7
    //   770: aload #9
    //   772: aload_2
    //   773: iload #7
    //   775: aload #5
    //   777: iload #6
    //   779: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;ILandroid/support/constraint/solver/widgets/ConstraintAnchor$Strength;I)Z
    //   782: pop
    //   783: aload_2
    //   784: invokevirtual getOwner : ()Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   787: aload #9
    //   789: invokevirtual getOwner : ()Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   792: invokevirtual connectedTo : (Landroid/support/constraint/solver/widgets/ConstraintWidget;)V
    //   795: return
    //   796: aload_1
    //   797: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   800: if_acmpeq -> 810
    //   803: aload_1
    //   804: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   807: if_acmpne -> 889
    //   810: aload_0
    //   811: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BASELINE : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   814: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   817: astore_3
    //   818: aload_3
    //   819: ifnull -> 826
    //   822: aload_3
    //   823: invokevirtual reset : ()V
    //   826: aload_0
    //   827: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   830: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   833: astore_3
    //   834: aload_3
    //   835: invokevirtual getTarget : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   838: aload_2
    //   839: if_acmpeq -> 846
    //   842: aload_3
    //   843: invokevirtual reset : ()V
    //   846: aload_0
    //   847: aload_1
    //   848: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   851: invokevirtual getOpposite : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   854: astore_1
    //   855: aload_0
    //   856: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_Y : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   859: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   862: astore_3
    //   863: iload #4
    //   865: istore #7
    //   867: aload_3
    //   868: invokevirtual isConnected : ()Z
    //   871: ifeq -> 770
    //   874: aload_1
    //   875: invokevirtual reset : ()V
    //   878: aload_3
    //   879: invokevirtual reset : ()V
    //   882: iload #4
    //   884: istore #7
    //   886: goto -> 770
    //   889: aload_1
    //   890: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   893: if_acmpeq -> 907
    //   896: iload #4
    //   898: istore #7
    //   900: aload_1
    //   901: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   904: if_acmpne -> 770
    //   907: aload_0
    //   908: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   911: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   914: astore_3
    //   915: aload_3
    //   916: invokevirtual getTarget : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   919: aload_2
    //   920: if_acmpeq -> 927
    //   923: aload_3
    //   924: invokevirtual reset : ()V
    //   927: aload_0
    //   928: aload_1
    //   929: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   932: invokevirtual getOpposite : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   935: astore_1
    //   936: aload_0
    //   937: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.CENTER_X : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   940: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   943: astore_3
    //   944: iload #4
    //   946: istore #7
    //   948: aload_3
    //   949: invokevirtual isConnected : ()Z
    //   952: ifeq -> 770
    //   955: aload_1
    //   956: invokevirtual reset : ()V
    //   959: aload_3
    //   960: invokevirtual reset : ()V
    //   963: iload #4
    //   965: istore #7
    //   967: goto -> 770
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt) {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt, ConstraintAnchor.Strength.STRONG, 0);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2) {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt1, ConstraintAnchor.Strength.STRONG, paramInt2);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2) {
    if (paramConstraintAnchor1.getOwner() == this)
      connect(paramConstraintAnchor1.getType(), paramConstraintAnchor2.getOwner(), paramConstraintAnchor2.getType(), paramInt1, paramStrength, paramInt2); 
  }
  
  public void connectedTo(ConstraintWidget paramConstraintWidget) {}
  
  public void disconnectUnlockedWidget(ConstraintWidget paramConstraintWidget) {
    ArrayList<ConstraintAnchor> arrayList = getAnchors();
    int i = 0;
    int j = arrayList.size();
    while (i < j) {
      ConstraintAnchor constraintAnchor = arrayList.get(i);
      if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == paramConstraintWidget && constraintAnchor.getConnectionCreator() == 2)
        constraintAnchor.reset(); 
      i++;
    } 
  }
  
  public void disconnectWidget(ConstraintWidget paramConstraintWidget) {
    ArrayList<ConstraintAnchor> arrayList = getAnchors();
    int i = 0;
    int j = arrayList.size();
    while (i < j) {
      ConstraintAnchor constraintAnchor = arrayList.get(i);
      if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == paramConstraintWidget)
        constraintAnchor.reset(); 
      i++;
    } 
  }
  
  public void forceUpdateDrawPosition() {
    int i = this.mX;
    int j = this.mY;
    int k = this.mX;
    int m = this.mWidth;
    int n = this.mY;
    int i1 = this.mHeight;
    this.mDrawX = i;
    this.mDrawY = j;
    this.mDrawWidth = k + m - i;
    this.mDrawHeight = n + i1 - j;
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType) {
    switch (paramType) {
      default:
        return null;
      case LEFT:
        return this.mLeft;
      case TOP:
        return this.mTop;
      case RIGHT:
        return this.mRight;
      case BOTTOM:
        return this.mBottom;
      case BASELINE:
        return this.mBaseline;
      case CENTER_X:
        return this.mCenterX;
      case CENTER_Y:
        return this.mCenterY;
      case CENTER:
        break;
    } 
    return this.mCenter;
  }
  
  public ArrayList<ConstraintAnchor> getAnchors() {
    return this.mAnchors;
  }
  
  public int getBaselineDistance() {
    return this.mBaselineDistance;
  }
  
  public int getBottom() {
    return getY() + this.mHeight;
  }
  
  public Object getCompanionWidget() {
    return this.mCompanionWidget;
  }
  
  public int getContainerItemSkip() {
    return this.mContainerItemSkip;
  }
  
  public String getDebugName() {
    return this.mDebugName;
  }
  
  public float getDimensionRatio() {
    return this.mDimensionRatio;
  }
  
  public int getDimensionRatioSide() {
    return this.mDimensionRatioSide;
  }
  
  public int getDrawBottom() {
    return getDrawY() + this.mDrawHeight;
  }
  
  public int getDrawHeight() {
    return this.mDrawHeight;
  }
  
  public int getDrawRight() {
    return getDrawX() + this.mDrawWidth;
  }
  
  public int getDrawWidth() {
    return this.mDrawWidth;
  }
  
  public int getDrawX() {
    return this.mDrawX + this.mOffsetX;
  }
  
  public int getDrawY() {
    return this.mDrawY + this.mOffsetY;
  }
  
  public int getHeight() {
    return (this.mVisibility == 8) ? 0 : this.mHeight;
  }
  
  public float getHorizontalBiasPercent() {
    return this.mHorizontalBiasPercent;
  }
  
  public ConstraintWidget getHorizontalChainControlWidget() {
    ConstraintAnchor constraintAnchor2 = null;
    ConstraintAnchor constraintAnchor1 = null;
    if (isInHorizontalChain()) {
      ConstraintWidget constraintWidget = this;
      while (true) {
        ConstraintAnchor constraintAnchor4;
        constraintAnchor2 = constraintAnchor1;
        if (constraintAnchor1 == null) {
          constraintAnchor2 = constraintAnchor1;
          if (constraintWidget != null) {
            ConstraintWidget constraintWidget1;
            constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            if (constraintAnchor2 == null) {
              constraintAnchor2 = null;
            } else {
              constraintAnchor2 = constraintAnchor2.getTarget();
            } 
            if (constraintAnchor2 == null) {
              constraintAnchor2 = null;
            } else {
              constraintWidget1 = constraintAnchor2.getOwner();
            } 
            if (constraintWidget1 == getParent())
              return constraintWidget; 
          } else {
            return (ConstraintWidget)constraintAnchor2;
          } 
        } else {
          return (ConstraintWidget)constraintAnchor2;
        } 
        if (constraintAnchor2 == null) {
          constraintAnchor4 = null;
        } else {
          constraintAnchor4 = constraintAnchor2.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
        } 
        if (constraintAnchor4 != null && constraintAnchor4.getOwner() != constraintWidget) {
          ConstraintWidget constraintWidget1 = constraintWidget;
          continue;
        } 
        ConstraintAnchor constraintAnchor3 = constraintAnchor2;
      } 
    } 
    return (ConstraintWidget)constraintAnchor2;
  }
  
  public int getHorizontalChainStyle() {
    return this.mHorizontalChainStyle;
  }
  
  public DimensionBehaviour getHorizontalDimensionBehaviour() {
    return this.mHorizontalDimensionBehaviour;
  }
  
  public int getInternalDrawBottom() {
    return this.mDrawY + this.mDrawHeight;
  }
  
  public int getInternalDrawRight() {
    return this.mDrawX + this.mDrawWidth;
  }
  
  int getInternalDrawX() {
    return this.mDrawX;
  }
  
  int getInternalDrawY() {
    return this.mDrawY;
  }
  
  public int getLeft() {
    return getX();
  }
  
  public int getMinHeight() {
    return this.mMinHeight;
  }
  
  public int getMinWidth() {
    return this.mMinWidth;
  }
  
  public int getOptimizerWrapHeight() {
    int i = this.mHeight;
    int j = i;
    if (this.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
      if (this.mMatchConstraintDefaultHeight == 1) {
        i = Math.max(this.mMatchConstraintMinHeight, i);
      } else if (this.mMatchConstraintMinHeight > 0) {
        i = this.mMatchConstraintMinHeight;
        this.mHeight = i;
      } else {
        i = 0;
      } 
      j = i;
      if (this.mMatchConstraintMaxHeight > 0) {
        j = i;
        if (this.mMatchConstraintMaxHeight < i)
          j = this.mMatchConstraintMaxHeight; 
      } 
    } 
    return j;
  }
  
  public int getOptimizerWrapWidth() {
    int i = this.mWidth;
    int j = i;
    if (this.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
      if (this.mMatchConstraintDefaultWidth == 1) {
        i = Math.max(this.mMatchConstraintMinWidth, i);
      } else if (this.mMatchConstraintMinWidth > 0) {
        i = this.mMatchConstraintMinWidth;
        this.mWidth = i;
      } else {
        i = 0;
      } 
      j = i;
      if (this.mMatchConstraintMaxWidth > 0) {
        j = i;
        if (this.mMatchConstraintMaxWidth < i)
          j = this.mMatchConstraintMaxWidth; 
      } 
    } 
    return j;
  }
  
  public ConstraintWidget getParent() {
    return this.mParent;
  }
  
  public int getRight() {
    return getX() + this.mWidth;
  }
  
  public WidgetContainer getRootWidgetContainer() {
    ConstraintWidget constraintWidget;
    for (constraintWidget = this; constraintWidget.getParent() != null; constraintWidget = constraintWidget.getParent());
    return (constraintWidget instanceof WidgetContainer) ? (WidgetContainer)constraintWidget : null;
  }
  
  protected int getRootX() {
    return this.mX + this.mOffsetX;
  }
  
  protected int getRootY() {
    return this.mY + this.mOffsetY;
  }
  
  public int getTop() {
    return getY();
  }
  
  public String getType() {
    return this.mType;
  }
  
  public float getVerticalBiasPercent() {
    return this.mVerticalBiasPercent;
  }
  
  public ConstraintWidget getVerticalChainControlWidget() {
    ConstraintAnchor constraintAnchor2 = null;
    ConstraintAnchor constraintAnchor1 = null;
    if (isInVerticalChain()) {
      ConstraintWidget constraintWidget = this;
      while (true) {
        ConstraintAnchor constraintAnchor4;
        constraintAnchor2 = constraintAnchor1;
        if (constraintAnchor1 == null) {
          constraintAnchor2 = constraintAnchor1;
          if (constraintWidget != null) {
            ConstraintWidget constraintWidget1;
            constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            if (constraintAnchor2 == null) {
              constraintAnchor2 = null;
            } else {
              constraintAnchor2 = constraintAnchor2.getTarget();
            } 
            if (constraintAnchor2 == null) {
              constraintAnchor2 = null;
            } else {
              constraintWidget1 = constraintAnchor2.getOwner();
            } 
            if (constraintWidget1 == getParent())
              return constraintWidget; 
          } else {
            return (ConstraintWidget)constraintAnchor2;
          } 
        } else {
          return (ConstraintWidget)constraintAnchor2;
        } 
        if (constraintAnchor2 == null) {
          constraintAnchor4 = null;
        } else {
          constraintAnchor4 = constraintAnchor2.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
        } 
        if (constraintAnchor4 != null && constraintAnchor4.getOwner() != constraintWidget) {
          ConstraintWidget constraintWidget1 = constraintWidget;
          continue;
        } 
        ConstraintAnchor constraintAnchor3 = constraintAnchor2;
      } 
    } 
    return (ConstraintWidget)constraintAnchor2;
  }
  
  public int getVerticalChainStyle() {
    return this.mVerticalChainStyle;
  }
  
  public DimensionBehaviour getVerticalDimensionBehaviour() {
    return this.mVerticalDimensionBehaviour;
  }
  
  public int getVisibility() {
    return this.mVisibility;
  }
  
  public int getWidth() {
    return (this.mVisibility == 8) ? 0 : this.mWidth;
  }
  
  public int getWrapHeight() {
    return this.mWrapHeight;
  }
  
  public int getWrapWidth() {
    return this.mWrapWidth;
  }
  
  public int getX() {
    return this.mX;
  }
  
  public int getY() {
    return this.mY;
  }
  
  public boolean hasAncestor(ConstraintWidget paramConstraintWidget) {
    ConstraintWidget constraintWidget = getParent();
    if (constraintWidget != paramConstraintWidget) {
      ConstraintWidget constraintWidget1 = constraintWidget;
      if (constraintWidget == paramConstraintWidget.getParent())
        return false; 
      while (constraintWidget1 != null) {
        if (constraintWidget1 != paramConstraintWidget) {
          if (constraintWidget1 == paramConstraintWidget.getParent())
            return true; 
          constraintWidget1 = constraintWidget1.getParent();
          continue;
        } 
        return true;
      } 
      return false;
    } 
    return true;
  }
  
  public boolean hasBaseline() {
    return (this.mBaselineDistance > 0);
  }
  
  public void immediateConnect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, int paramInt2) {
    getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType2), paramInt1, paramInt2, ConstraintAnchor.Strength.STRONG, 0, true);
  }
  
  public boolean isInHorizontalChain() {
    return ((this.mLeft.mTarget != null && this.mLeft.mTarget.mTarget == this.mLeft) || (this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight));
  }
  
  public boolean isInVerticalChain() {
    return ((this.mTop.mTarget != null && this.mTop.mTarget.mTarget == this.mTop) || (this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom));
  }
  
  public boolean isInsideConstraintLayout() {
    ConstraintWidget constraintWidget2 = getParent();
    ConstraintWidget constraintWidget1 = constraintWidget2;
    if (constraintWidget2 != null)
      while (true) {
        if (constraintWidget1 != null) {
          if (constraintWidget1 instanceof ConstraintWidgetContainer)
            return true; 
          constraintWidget1 = constraintWidget1.getParent();
          continue;
        } 
        return false;
      }  
    return false;
  }
  
  public boolean isRoot() {
    return (this.mParent == null);
  }
  
  public boolean isRootContainer() {
    return (this instanceof ConstraintWidgetContainer && (this.mParent == null || !(this.mParent instanceof ConstraintWidgetContainer)));
  }
  
  public void reset() {
    this.mLeft.reset();
    this.mTop.reset();
    this.mRight.reset();
    this.mBottom.reset();
    this.mBaseline.reset();
    this.mCenterX.reset();
    this.mCenterY.reset();
    this.mCenter.reset();
    this.mParent = null;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mDimensionRatio = 0.0F;
    this.mDimensionRatioSide = -1;
    this.mX = 0;
    this.mY = 0;
    this.mDrawX = 0;
    this.mDrawY = 0;
    this.mDrawWidth = 0;
    this.mDrawHeight = 0;
    this.mOffsetX = 0;
    this.mOffsetY = 0;
    this.mBaselineDistance = 0;
    this.mMinWidth = 0;
    this.mMinHeight = 0;
    this.mWrapWidth = 0;
    this.mWrapHeight = 0;
    this.mHorizontalBiasPercent = DEFAULT_BIAS;
    this.mVerticalBiasPercent = DEFAULT_BIAS;
    this.mHorizontalDimensionBehaviour = DimensionBehaviour.FIXED;
    this.mVerticalDimensionBehaviour = DimensionBehaviour.FIXED;
    this.mCompanionWidget = null;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mDebugName = null;
    this.mType = null;
    this.mHorizontalWrapVisited = false;
    this.mVerticalWrapVisited = false;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mHorizontalChainFixedPosition = false;
    this.mVerticalChainFixedPosition = false;
    this.mHorizontalWeight = 0.0F;
    this.mVerticalWeight = 0.0F;
    this.mHorizontalResolution = -1;
    this.mVerticalResolution = -1;
  }
  
  public void resetAllConstraints() {
    resetAnchors();
    setVerticalBiasPercent(DEFAULT_BIAS);
    setHorizontalBiasPercent(DEFAULT_BIAS);
    if (!(this instanceof ConstraintWidgetContainer)) {
      if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT)
        if (getWidth() == getWrapWidth()) {
          setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
        } else if (getWidth() > getMinWidth()) {
          setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
        }  
      if (getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
        if (getHeight() == getWrapHeight()) {
          setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
          return;
        } 
        if (getHeight() > getMinHeight()) {
          setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
          return;
        } 
      } 
    } 
  }
  
  public void resetAnchor(ConstraintAnchor paramConstraintAnchor) {
    if (getParent() != null && getParent() instanceof ConstraintWidgetContainer && ((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())
      return; 
    ConstraintAnchor constraintAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT);
    ConstraintAnchor constraintAnchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor constraintAnchor3 = getAnchor(ConstraintAnchor.Type.TOP);
    ConstraintAnchor constraintAnchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
    ConstraintAnchor constraintAnchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
    ConstraintAnchor constraintAnchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor constraintAnchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
    if (paramConstraintAnchor == constraintAnchor5) {
      if (constraintAnchor1.isConnected() && constraintAnchor2.isConnected() && constraintAnchor1.getTarget() == constraintAnchor2.getTarget()) {
        constraintAnchor1.reset();
        constraintAnchor2.reset();
      } 
      if (constraintAnchor3.isConnected() && constraintAnchor4.isConnected() && constraintAnchor3.getTarget() == constraintAnchor4.getTarget()) {
        constraintAnchor3.reset();
        constraintAnchor4.reset();
      } 
      this.mHorizontalBiasPercent = 0.5F;
      this.mVerticalBiasPercent = 0.5F;
    } else if (paramConstraintAnchor == constraintAnchor6) {
      if (constraintAnchor1.isConnected() && constraintAnchor2.isConnected() && constraintAnchor1.getTarget().getOwner() == constraintAnchor2.getTarget().getOwner()) {
        constraintAnchor1.reset();
        constraintAnchor2.reset();
      } 
      this.mHorizontalBiasPercent = 0.5F;
    } else if (paramConstraintAnchor == constraintAnchor7) {
      if (constraintAnchor3.isConnected() && constraintAnchor4.isConnected() && constraintAnchor3.getTarget().getOwner() == constraintAnchor4.getTarget().getOwner()) {
        constraintAnchor3.reset();
        constraintAnchor4.reset();
      } 
      this.mVerticalBiasPercent = 0.5F;
    } else if (paramConstraintAnchor == constraintAnchor1 || paramConstraintAnchor == constraintAnchor2) {
      if (constraintAnchor1.isConnected() && constraintAnchor1.getTarget() == constraintAnchor2.getTarget())
        constraintAnchor5.reset(); 
    } else if ((paramConstraintAnchor == constraintAnchor3 || paramConstraintAnchor == constraintAnchor4) && constraintAnchor3.isConnected() && constraintAnchor3.getTarget() == constraintAnchor4.getTarget()) {
      constraintAnchor5.reset();
    } 
    paramConstraintAnchor.reset();
  }
  
  public void resetAnchors() {
    ConstraintWidget constraintWidget = getParent();
    if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer)getParent()).handlesInternalConstraints()) {
      int i = 0;
      int j = this.mAnchors.size();
      while (true) {
        if (i < j) {
          ((ConstraintAnchor)this.mAnchors.get(i)).reset();
          i++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public void resetAnchors(int paramInt) {
    ConstraintWidget constraintWidget = getParent();
    if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer)getParent()).handlesInternalConstraints()) {
      int i = 0;
      int j = this.mAnchors.size();
      while (true) {
        if (i < j) {
          ConstraintAnchor constraintAnchor = this.mAnchors.get(i);
          if (paramInt == constraintAnchor.getConnectionCreator()) {
            if (constraintAnchor.isVerticalAnchor()) {
              setVerticalBiasPercent(DEFAULT_BIAS);
            } else {
              setHorizontalBiasPercent(DEFAULT_BIAS);
            } 
            constraintAnchor.reset();
          } 
          i++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public void resetGroups() {
    int j = this.mAnchors.size();
    for (int i = 0; i < j; i++)
      ((ConstraintAnchor)this.mAnchors.get(i)).mGroup = Integer.MAX_VALUE; 
  }
  
  public void resetSolverVariables(Cache paramCache) {
    this.mLeft.resetSolverVariable(paramCache);
    this.mTop.resetSolverVariable(paramCache);
    this.mRight.resetSolverVariable(paramCache);
    this.mBottom.resetSolverVariable(paramCache);
    this.mBaseline.resetSolverVariable(paramCache);
    this.mCenter.resetSolverVariable(paramCache);
    this.mCenterX.resetSolverVariable(paramCache);
    this.mCenterY.resetSolverVariable(paramCache);
  }
  
  public void setBaselineDistance(int paramInt) {
    this.mBaselineDistance = paramInt;
  }
  
  public void setCompanionWidget(Object paramObject) {
    this.mCompanionWidget = paramObject;
  }
  
  public void setContainerItemSkip(int paramInt) {
    if (paramInt >= 0) {
      this.mContainerItemSkip = paramInt;
      return;
    } 
    this.mContainerItemSkip = 0;
  }
  
  public void setDebugName(String paramString) {
    this.mDebugName = paramString;
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString) {
    this.mDebugName = paramString;
    SolverVariable solverVariable1 = paramLinearSystem.createObjectVariable(this.mLeft);
    SolverVariable solverVariable2 = paramLinearSystem.createObjectVariable(this.mTop);
    SolverVariable solverVariable3 = paramLinearSystem.createObjectVariable(this.mRight);
    SolverVariable solverVariable4 = paramLinearSystem.createObjectVariable(this.mBottom);
    solverVariable1.setName(paramString + ".left");
    solverVariable2.setName(paramString + ".top");
    solverVariable3.setName(paramString + ".right");
    solverVariable4.setName(paramString + ".bottom");
    if (this.mBaselineDistance > 0)
      paramLinearSystem.createObjectVariable(this.mBaseline).setName(paramString + ".baseline"); 
  }
  
  public void setDimension(int paramInt1, int paramInt2) {
    this.mWidth = paramInt1;
    if (this.mWidth < this.mMinWidth)
      this.mWidth = this.mMinWidth; 
    this.mHeight = paramInt2;
    if (this.mHeight < this.mMinHeight)
      this.mHeight = this.mMinHeight; 
  }
  
  public void setDimensionRatio(float paramFloat, int paramInt) {
    this.mDimensionRatio = paramFloat;
    this.mDimensionRatioSide = paramInt;
  }
  
  public void setDimensionRatio(String paramString) {
    float f1;
    if (paramString == null || paramString.length() == 0) {
      this.mDimensionRatio = 0.0F;
      return;
    } 
    byte b = -1;
    float f2 = 0.0F;
    int j = paramString.length();
    int i = paramString.indexOf(',');
    if (i > 0 && i < j - 1) {
      String str = paramString.substring(0, i);
      if (str.equalsIgnoreCase("W")) {
        b = 0;
      } else if (str.equalsIgnoreCase("H")) {
        b = 1;
      } 
      i++;
    } else {
      i = 0;
    } 
    int k = paramString.indexOf(':');
    if (k >= 0 && k < j - 1) {
      String str = paramString.substring(i, k);
      paramString = paramString.substring(k + 1);
      f1 = f2;
      if (str.length() > 0) {
        f1 = f2;
        if (paramString.length() > 0)
          try {
            float f3 = Float.parseFloat(str);
            float f4 = Float.parseFloat(paramString);
            f1 = f2;
            if (f3 > 0.0F) {
              f1 = f2;
              if (f4 > 0.0F)
                if (b == 1) {
                  f1 = Math.abs(f4 / f3);
                } else {
                  f1 = f3 / f4;
                  f1 = Math.abs(f1);
                }  
            } 
          } catch (NumberFormatException numberFormatException) {
            f1 = f2;
          }  
      } 
    } else {
      String str = numberFormatException.substring(i);
      f1 = f2;
      if (str.length() > 0)
        try {
          f1 = Float.parseFloat(str);
        } catch (NumberFormatException numberFormatException1) {
          f1 = f2;
        }  
    } 
    if (f1 > 0.0F) {
      this.mDimensionRatio = f1;
      this.mDimensionRatioSide = b;
      return;
    } 
  }
  
  public void setDrawHeight(int paramInt) {
    this.mDrawHeight = paramInt;
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2) {
    this.mDrawX = paramInt1 - this.mOffsetX;
    this.mDrawY = paramInt2 - this.mOffsetY;
    this.mX = this.mDrawX;
    this.mY = this.mDrawY;
  }
  
  public void setDrawWidth(int paramInt) {
    this.mDrawWidth = paramInt;
  }
  
  public void setDrawX(int paramInt) {
    this.mDrawX = paramInt - this.mOffsetX;
    this.mX = this.mDrawX;
  }
  
  public void setDrawY(int paramInt) {
    this.mDrawY = paramInt - this.mOffsetY;
    this.mY = this.mDrawY;
  }
  
  public void setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = paramInt3 - paramInt1;
    paramInt3 = paramInt4 - paramInt2;
    this.mX = paramInt1;
    this.mY = paramInt2;
    if (this.mVisibility == 8) {
      this.mWidth = 0;
      this.mHeight = 0;
      return;
    } 
    paramInt1 = i;
    if (this.mHorizontalDimensionBehaviour == DimensionBehaviour.FIXED) {
      paramInt1 = i;
      if (i < this.mWidth)
        paramInt1 = this.mWidth; 
    } 
    paramInt2 = paramInt3;
    if (this.mVerticalDimensionBehaviour == DimensionBehaviour.FIXED) {
      paramInt2 = paramInt3;
      if (paramInt3 < this.mHeight)
        paramInt2 = this.mHeight; 
    } 
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    if (this.mHeight < this.mMinHeight)
      this.mHeight = this.mMinHeight; 
    if (this.mWidth < this.mMinWidth) {
      this.mWidth = this.mMinWidth;
      return;
    } 
  }
  
  public void setGoneMargin(ConstraintAnchor.Type paramType, int paramInt) {
    switch (paramType) {
      default:
        return;
      case LEFT:
        this.mLeft.mGoneMargin = paramInt;
        return;
      case TOP:
        this.mTop.mGoneMargin = paramInt;
        return;
      case RIGHT:
        this.mRight.mGoneMargin = paramInt;
        return;
      case BOTTOM:
        break;
    } 
    this.mBottom.mGoneMargin = paramInt;
  }
  
  public void setHeight(int paramInt) {
    this.mHeight = paramInt;
    if (this.mHeight < this.mMinHeight)
      this.mHeight = this.mMinHeight; 
  }
  
  public void setHorizontalBiasPercent(float paramFloat) {
    this.mHorizontalBiasPercent = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt) {
    this.mHorizontalChainStyle = paramInt;
  }
  
  public void setHorizontalDimension(int paramInt1, int paramInt2) {
    this.mX = paramInt1;
    this.mWidth = paramInt2 - paramInt1;
    if (this.mWidth < this.mMinWidth)
      this.mWidth = this.mMinWidth; 
  }
  
  public void setHorizontalDimensionBehaviour(DimensionBehaviour paramDimensionBehaviour) {
    this.mHorizontalDimensionBehaviour = paramDimensionBehaviour;
    if (this.mHorizontalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT)
      setWidth(this.mWrapWidth); 
  }
  
  public void setHorizontalMatchStyle(int paramInt1, int paramInt2, int paramInt3) {
    this.mMatchConstraintDefaultWidth = paramInt1;
    this.mMatchConstraintMinWidth = paramInt2;
    this.mMatchConstraintMaxWidth = paramInt3;
  }
  
  public void setHorizontalWeight(float paramFloat) {
    this.mHorizontalWeight = paramFloat;
  }
  
  public void setMinHeight(int paramInt) {
    if (paramInt < 0) {
      this.mMinHeight = 0;
      return;
    } 
    this.mMinHeight = paramInt;
  }
  
  public void setMinWidth(int paramInt) {
    if (paramInt < 0) {
      this.mMinWidth = 0;
      return;
    } 
    this.mMinWidth = paramInt;
  }
  
  public void setOffset(int paramInt1, int paramInt2) {
    this.mOffsetX = paramInt1;
    this.mOffsetY = paramInt2;
  }
  
  public void setOrigin(int paramInt1, int paramInt2) {
    this.mX = paramInt1;
    this.mY = paramInt2;
  }
  
  public void setParent(ConstraintWidget paramConstraintWidget) {
    this.mParent = paramConstraintWidget;
  }
  
  public void setType(String paramString) {
    this.mType = paramString;
  }
  
  public void setVerticalBiasPercent(float paramFloat) {
    this.mVerticalBiasPercent = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt) {
    this.mVerticalChainStyle = paramInt;
  }
  
  public void setVerticalDimension(int paramInt1, int paramInt2) {
    this.mY = paramInt1;
    this.mHeight = paramInt2 - paramInt1;
    if (this.mHeight < this.mMinHeight)
      this.mHeight = this.mMinHeight; 
  }
  
  public void setVerticalDimensionBehaviour(DimensionBehaviour paramDimensionBehaviour) {
    this.mVerticalDimensionBehaviour = paramDimensionBehaviour;
    if (this.mVerticalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT)
      setHeight(this.mWrapHeight); 
  }
  
  public void setVerticalMatchStyle(int paramInt1, int paramInt2, int paramInt3) {
    this.mMatchConstraintDefaultHeight = paramInt1;
    this.mMatchConstraintMinHeight = paramInt2;
    this.mMatchConstraintMaxHeight = paramInt3;
  }
  
  public void setVerticalWeight(float paramFloat) {
    this.mVerticalWeight = paramFloat;
  }
  
  public void setVisibility(int paramInt) {
    this.mVisibility = paramInt;
  }
  
  public void setWidth(int paramInt) {
    this.mWidth = paramInt;
    if (this.mWidth < this.mMinWidth)
      this.mWidth = this.mMinWidth; 
  }
  
  public void setWrapHeight(int paramInt) {
    this.mWrapHeight = paramInt;
  }
  
  public void setWrapWidth(int paramInt) {
    this.mWrapWidth = paramInt;
  }
  
  public void setX(int paramInt) {
    this.mX = paramInt;
  }
  
  public void setY(int paramInt) {
    this.mY = paramInt;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    if (this.mType != null) {
      str = "type: " + this.mType + " ";
    } else {
      str = "";
    } 
    stringBuilder = stringBuilder.append(str);
    if (this.mDebugName != null) {
      str = "id: " + this.mDebugName + " ";
      return stringBuilder.append(str).append("(").append(this.mX).append(", ").append(this.mY).append(") - (").append(this.mWidth).append(" x ").append(this.mHeight).append(")").append(" wrap: (").append(this.mWrapWidth).append(" x ").append(this.mWrapHeight).append(")").toString();
    } 
    String str = "";
    return stringBuilder.append(str).append("(").append(this.mX).append(", ").append(this.mY).append(") - (").append(this.mWidth).append(" x ").append(this.mHeight).append(")").append(" wrap: (").append(this.mWrapWidth).append(" x ").append(this.mWrapHeight).append(")").toString();
  }
  
  public void updateDrawPosition() {
    int i = this.mX;
    int j = this.mY;
    int k = this.mX;
    int m = this.mWidth;
    int n = this.mY;
    int i1 = this.mHeight;
    this.mDrawX = i;
    this.mDrawY = j;
    this.mDrawWidth = k + m - i;
    this.mDrawHeight = n + i1 - j;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem) {
    updateFromSolver(paramLinearSystem, 2147483647);
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem, int paramInt) {
    if (paramInt == Integer.MAX_VALUE) {
      setFrame(paramLinearSystem.getObjectVariableValue(this.mLeft), paramLinearSystem.getObjectVariableValue(this.mTop), paramLinearSystem.getObjectVariableValue(this.mRight), paramLinearSystem.getObjectVariableValue(this.mBottom));
      return;
    } 
    if (paramInt == -2) {
      setFrame(this.mSolverLeft, this.mSolverTop, this.mSolverRight, this.mSolverBottom);
      return;
    } 
    if (this.mLeft.mGroup == paramInt)
      this.mSolverLeft = paramLinearSystem.getObjectVariableValue(this.mLeft); 
    if (this.mTop.mGroup == paramInt)
      this.mSolverTop = paramLinearSystem.getObjectVariableValue(this.mTop); 
    if (this.mRight.mGroup == paramInt)
      this.mSolverRight = paramLinearSystem.getObjectVariableValue(this.mRight); 
    if (this.mBottom.mGroup == paramInt) {
      this.mSolverBottom = paramLinearSystem.getObjectVariableValue(this.mBottom);
      return;
    } 
  }
  
  public enum ContentAlignment {
    BEGIN, BOTTOM, END, LEFT, MIDDLE, RIGHT, TOP, VERTICAL_MIDDLE;
    
    static {
      BOTTOM = new ContentAlignment("BOTTOM", 5);
      LEFT = new ContentAlignment("LEFT", 6);
      RIGHT = new ContentAlignment("RIGHT", 7);
      $VALUES = new ContentAlignment[] { BEGIN, MIDDLE, END, TOP, VERTICAL_MIDDLE, BOTTOM, LEFT, RIGHT };
    }
  }
  
  public enum DimensionBehaviour {
    FIXED, MATCH_CONSTRAINT, MATCH_PARENT, WRAP_CONTENT;
    
    static {
      $VALUES = new DimensionBehaviour[] { FIXED, WRAP_CONTENT, MATCH_CONSTRAINT, MATCH_PARENT };
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\solver\widgets\ConstraintWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */