package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer extends WidgetContainer {
  static boolean ALLOW_ROOT_GROUP = true;
  
  private static final int CHAIN_FIRST = 0;
  
  private static final int CHAIN_FIRST_VISIBLE = 2;
  
  private static final int CHAIN_LAST = 1;
  
  private static final int CHAIN_LAST_VISIBLE = 3;
  
  private static final boolean DEBUG = false;
  
  private static final boolean DEBUG_LAYOUT = false;
  
  private static final boolean DEBUG_OPTIMIZE = false;
  
  private static final int FLAG_CHAIN_DANGLING = 1;
  
  private static final int FLAG_CHAIN_OPTIMIZE = 0;
  
  private static final int FLAG_RECOMPUTE_BOUNDS = 2;
  
  private static final int MAX_ITERATIONS = 8;
  
  public static final int OPTIMIZATION_ALL = 2;
  
  public static final int OPTIMIZATION_BASIC = 4;
  
  public static final int OPTIMIZATION_CHAIN = 8;
  
  public static final int OPTIMIZATION_NONE = 1;
  
  private static final boolean USE_SNAPSHOT = true;
  
  private static final boolean USE_THREAD = false;
  
  private boolean[] flags = new boolean[3];
  
  protected LinearSystem mBackgroundSystem = null;
  
  private ConstraintWidget[] mChainEnds = new ConstraintWidget[4];
  
  private boolean mHeightMeasuredTooSmall = false;
  
  private ConstraintWidget[] mHorizontalChainsArray = new ConstraintWidget[4];
  
  private int mHorizontalChainsSize = 0;
  
  private ConstraintWidget[] mMatchConstraintsChainedWidgets = new ConstraintWidget[4];
  
  private int mOptimizationLevel = 2;
  
  int mPaddingBottom;
  
  int mPaddingLeft;
  
  int mPaddingRight;
  
  int mPaddingTop;
  
  private Snapshot mSnapshot;
  
  protected LinearSystem mSystem = new LinearSystem();
  
  private ConstraintWidget[] mVerticalChainsArray = new ConstraintWidget[4];
  
  private int mVerticalChainsSize = 0;
  
  private boolean mWidthMeasuredTooSmall = false;
  
  int mWrapHeight;
  
  int mWrapWidth;
  
  public ConstraintWidgetContainer() {}
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void addHorizontalChain(ConstraintWidget paramConstraintWidget) {
    for (int i = 0; i < this.mHorizontalChainsSize; i++) {
      if (this.mHorizontalChainsArray[i] == paramConstraintWidget)
        return; 
    } 
    if (this.mHorizontalChainsSize + 1 >= this.mHorizontalChainsArray.length)
      this.mHorizontalChainsArray = Arrays.<ConstraintWidget>copyOf(this.mHorizontalChainsArray, this.mHorizontalChainsArray.length * 2); 
    this.mHorizontalChainsArray[this.mHorizontalChainsSize] = paramConstraintWidget;
    this.mHorizontalChainsSize++;
  }
  
  private void addVerticalChain(ConstraintWidget paramConstraintWidget) {
    for (int i = 0; i < this.mVerticalChainsSize; i++) {
      if (this.mVerticalChainsArray[i] == paramConstraintWidget)
        return; 
    } 
    if (this.mVerticalChainsSize + 1 >= this.mVerticalChainsArray.length)
      this.mVerticalChainsArray = Arrays.<ConstraintWidget>copyOf(this.mVerticalChainsArray, this.mVerticalChainsArray.length * 2); 
    this.mVerticalChainsArray[this.mVerticalChainsSize] = paramConstraintWidget;
    this.mVerticalChainsSize++;
  }
  
  private void applyHorizontalChain(LinearSystem paramLinearSystem) {
    int i = 0;
    label218: while (i < this.mHorizontalChainsSize) {
      int k;
      int m;
      ConstraintWidget constraintWidget3 = this.mHorizontalChainsArray[i];
      int n = countMatchConstraintsChainedWidgets(paramLinearSystem, this.mChainEnds, this.mHorizontalChainsArray[i], 0, this.flags);
      ConstraintWidget constraintWidget2 = this.mChainEnds[2];
      if (constraintWidget2 == null)
        continue; 
      if (this.flags[1]) {
        j = constraintWidget3.getDrawX();
        while (true) {
          if (constraintWidget2 != null) {
            paramLinearSystem.addEquality(constraintWidget2.mLeft.mSolverVariable, j);
            ConstraintWidget constraintWidget = constraintWidget2.mHorizontalNextWidget;
            j += constraintWidget2.mLeft.getMargin() + constraintWidget2.getWidth() + constraintWidget2.mRight.getMargin();
            constraintWidget2 = constraintWidget;
            continue;
          } 
          i++;
          continue label218;
        } 
      } 
      if (constraintWidget3.mHorizontalChainStyle == 0) {
        j = 1;
      } else {
        j = 0;
      } 
      if (constraintWidget3.mHorizontalChainStyle == 2) {
        k = 1;
      } else {
        k = 0;
      } 
      if (this.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        m = 1;
      } else {
        m = 0;
      } 
      if ((this.mOptimizationLevel == 2 || this.mOptimizationLevel == 8) && this.flags[0] && constraintWidget3.mHorizontalChainFixedPosition && !k && !m && constraintWidget3.mHorizontalChainStyle == 0) {
        Optimizer.applyDirectResolutionHorizontalChain(this, paramLinearSystem, n, constraintWidget3);
        continue;
      } 
      if (n == 0 || k) {
        ConstraintWidget constraintWidget5 = null;
        ConstraintWidget constraintWidget6 = null;
        m = 0;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        while (true) {
          ConstraintWidget constraintWidget = constraintWidget4;
          if (constraintWidget != null) {
            ConstraintWidget constraintWidget7 = constraintWidget.mHorizontalNextWidget;
            if (constraintWidget7 == null) {
              constraintWidget6 = this.mChainEnds[1];
              m = 1;
            } 
            if (k) {
              ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
              int i1 = constraintAnchor.getMargin();
              n = i1;
              if (constraintWidget5 != null)
                n = i1 + constraintWidget5.mRight.getMargin(); 
              i1 = 1;
              if (constraintWidget2 != constraintWidget)
                i1 = 3; 
              paramLinearSystem.addGreaterThan(constraintAnchor.mSolverVariable, constraintAnchor.mTarget.mSolverVariable, n, i1);
              constraintWidget5 = constraintWidget7;
              if (constraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintAnchor constraintAnchor1 = constraintWidget.mRight;
                if (constraintWidget.mMatchConstraintDefaultWidth == 1) {
                  n = Math.max(constraintWidget.mMatchConstraintMinWidth, constraintWidget.getWidth());
                  paramLinearSystem.addEquality(constraintAnchor1.mSolverVariable, constraintAnchor.mSolverVariable, n, 3);
                  constraintWidget5 = constraintWidget7;
                } else {
                  paramLinearSystem.addGreaterThan(constraintAnchor.mSolverVariable, constraintAnchor.mTarget.mSolverVariable, constraintAnchor.mMargin, 3);
                  paramLinearSystem.addLowerThan(constraintAnchor1.mSolverVariable, constraintAnchor.mSolverVariable, constraintWidget.mMatchConstraintMinWidth, 3);
                  constraintWidget5 = constraintWidget7;
                } 
              } 
            } else if (!j && m && constraintWidget5 != null) {
              if (constraintWidget.mRight.mTarget == null) {
                paramLinearSystem.addEquality(constraintWidget.mRight.mSolverVariable, constraintWidget.getDrawRight());
                constraintWidget5 = constraintWidget7;
              } else {
                n = constraintWidget.mRight.getMargin();
                paramLinearSystem.addEquality(constraintWidget.mRight.mSolverVariable, constraintWidget6.mRight.mTarget.mSolverVariable, -n, 5);
                constraintWidget5 = constraintWidget7;
              } 
            } else if (!j && !m && constraintWidget5 == null) {
              if (constraintWidget.mLeft.mTarget == null) {
                paramLinearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, constraintWidget.getDrawX());
                constraintWidget5 = constraintWidget7;
              } else {
                n = constraintWidget.mLeft.getMargin();
                paramLinearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, constraintWidget3.mLeft.mTarget.mSolverVariable, n, 5);
                constraintWidget5 = constraintWidget7;
              } 
            } else {
              SolverVariable solverVariable;
              ConstraintAnchor constraintAnchor1 = constraintWidget.mLeft;
              ConstraintAnchor constraintAnchor2 = constraintWidget.mRight;
              n = constraintAnchor1.getMargin();
              int i1 = constraintAnchor2.getMargin();
              paramLinearSystem.addGreaterThan(constraintAnchor1.mSolverVariable, constraintAnchor1.mTarget.mSolverVariable, n, 1);
              paramLinearSystem.addLowerThan(constraintAnchor2.mSolverVariable, constraintAnchor2.mTarget.mSolverVariable, -i1, 1);
              if (constraintAnchor1.mTarget != null) {
                solverVariable = constraintAnchor1.mTarget.mSolverVariable;
              } else {
                solverVariable = null;
              } 
              if (constraintWidget5 == null)
                if (constraintWidget3.mLeft.mTarget != null) {
                  solverVariable = constraintWidget3.mLeft.mTarget.mSolverVariable;
                } else {
                  solverVariable = null;
                }  
              constraintWidget4 = constraintWidget7;
              if (constraintWidget7 == null)
                if (constraintWidget6.mRight.mTarget != null) {
                  constraintWidget4 = constraintWidget6.mRight.mTarget.mOwner;
                } else {
                  constraintWidget4 = null;
                }  
              constraintWidget5 = constraintWidget4;
              if (constraintWidget4 != null) {
                SolverVariable solverVariable1 = constraintWidget4.mLeft.mSolverVariable;
                if (m)
                  if (constraintWidget6.mRight.mTarget != null) {
                    solverVariable1 = constraintWidget6.mRight.mTarget.mSolverVariable;
                  } else {
                    solverVariable1 = null;
                  }  
                constraintWidget5 = constraintWidget4;
                if (solverVariable != null) {
                  constraintWidget5 = constraintWidget4;
                  if (solverVariable1 != null) {
                    paramLinearSystem.addCentering(constraintAnchor1.mSolverVariable, solverVariable, n, 0.5F, solverVariable1, constraintAnchor2.mSolverVariable, i1, 4);
                    constraintWidget5 = constraintWidget4;
                  } 
                } 
              } 
            } 
            if (m) {
              constraintWidget4 = null;
            } else {
              constraintWidget4 = constraintWidget5;
            } 
            constraintWidget5 = constraintWidget;
            continue;
          } 
          if (k) {
            ConstraintAnchor constraintAnchor1 = constraintWidget2.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget6.mRight;
            j = constraintAnchor1.getMargin();
            k = constraintAnchor2.getMargin();
            if (constraintWidget3.mLeft.mTarget != null) {
              SolverVariable solverVariable = constraintWidget3.mLeft.mTarget.mSolverVariable;
            } else {
              constraintWidget4 = null;
            } 
            if (constraintWidget6.mRight.mTarget != null) {
              SolverVariable solverVariable = constraintWidget6.mRight.mTarget.mSolverVariable;
            } else {
              constraintWidget2 = null;
            } 
            if (constraintWidget4 != null) {
              if (constraintWidget2 != null) {
                paramLinearSystem.addLowerThan(constraintAnchor2.mSolverVariable, (SolverVariable)constraintWidget2, -k, 1);
                paramLinearSystem.addCentering(constraintAnchor1.mSolverVariable, (SolverVariable)constraintWidget4, j, constraintWidget3.mHorizontalBiasPercent, (SolverVariable)constraintWidget2, constraintAnchor2.mSolverVariable, k, 4);
                continue label218;
              } 
              continue label218;
            } 
            continue label218;
          } 
          continue label218;
        } 
      } 
      ConstraintWidget constraintWidget1 = null;
      float f = 0.0F;
      while (constraintWidget2 != null) {
        if (constraintWidget2.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          k = constraintWidget2.mLeft.getMargin();
          j = k;
          if (constraintWidget1 != null)
            j = k + constraintWidget1.mRight.getMargin(); 
          k = 3;
          if (constraintWidget2.mLeft.mTarget.mOwner.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
            k = 2; 
          paramLinearSystem.addGreaterThan(constraintWidget2.mLeft.mSolverVariable, constraintWidget2.mLeft.mTarget.mSolverVariable, j, k);
          k = constraintWidget2.mRight.getMargin();
          j = k;
          if (constraintWidget2.mRight.mTarget.mOwner.mLeft.mTarget != null) {
            j = k;
            if (constraintWidget2.mRight.mTarget.mOwner.mLeft.mTarget.mOwner == constraintWidget2)
              j = k + constraintWidget2.mRight.mTarget.mOwner.mLeft.getMargin(); 
          } 
          k = 3;
          if (constraintWidget2.mRight.mTarget.mOwner.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
            k = 2; 
          paramLinearSystem.addLowerThan(constraintWidget2.mRight.mSolverVariable, constraintWidget2.mRight.mTarget.mSolverVariable, -j, k);
        } else {
          f += constraintWidget2.mHorizontalWeight;
          j = 0;
          if (constraintWidget2.mRight.mTarget != null) {
            k = constraintWidget2.mRight.getMargin();
            j = k;
            if (constraintWidget2 != this.mChainEnds[3])
              j = k + constraintWidget2.mRight.mTarget.mOwner.mLeft.getMargin(); 
          } 
          paramLinearSystem.addGreaterThan(constraintWidget2.mRight.mSolverVariable, constraintWidget2.mLeft.mSolverVariable, 0, 1);
          paramLinearSystem.addLowerThan(constraintWidget2.mRight.mSolverVariable, constraintWidget2.mRight.mTarget.mSolverVariable, -j, 1);
        } 
        constraintWidget1 = constraintWidget2;
        constraintWidget2 = constraintWidget2.mHorizontalNextWidget;
      } 
      if (n == 1) {
        constraintWidget2 = this.mMatchConstraintsChainedWidgets[0];
        k = constraintWidget2.mLeft.getMargin();
        j = k;
        if (constraintWidget2.mLeft.mTarget != null)
          j = k + constraintWidget2.mLeft.mTarget.getMargin(); 
        m = constraintWidget2.mRight.getMargin();
        k = m;
        if (constraintWidget2.mRight.mTarget != null)
          k = m + constraintWidget2.mRight.mTarget.getMargin(); 
        SolverVariable solverVariable = constraintWidget3.mRight.mTarget.mSolverVariable;
        if (constraintWidget2 == this.mChainEnds[3])
          solverVariable = (this.mChainEnds[1]).mRight.mTarget.mSolverVariable; 
        if (constraintWidget2.mMatchConstraintDefaultWidth == 1) {
          paramLinearSystem.addGreaterThan(constraintWidget3.mLeft.mSolverVariable, constraintWidget3.mLeft.mTarget.mSolverVariable, j, 1);
          paramLinearSystem.addLowerThan(constraintWidget3.mRight.mSolverVariable, solverVariable, -k, 1);
          paramLinearSystem.addEquality(constraintWidget3.mRight.mSolverVariable, constraintWidget3.mLeft.mSolverVariable, constraintWidget3.getWidth(), 2);
          continue;
        } 
        paramLinearSystem.addEquality(constraintWidget2.mLeft.mSolverVariable, constraintWidget2.mLeft.mTarget.mSolverVariable, j, 1);
        paramLinearSystem.addEquality(constraintWidget2.mRight.mSolverVariable, solverVariable, -k, 1);
        continue;
      } 
      int j = 0;
      while (true) {
        if (j < n - 1) {
          ConstraintWidget constraintWidget4 = this.mMatchConstraintsChainedWidgets[j];
          ConstraintWidget constraintWidget5 = this.mMatchConstraintsChainedWidgets[j + 1];
          SolverVariable solverVariable2 = constraintWidget4.mLeft.mSolverVariable;
          SolverVariable solverVariable3 = constraintWidget4.mRight.mSolverVariable;
          SolverVariable solverVariable4 = constraintWidget5.mLeft.mSolverVariable;
          SolverVariable solverVariable1 = constraintWidget5.mRight.mSolverVariable;
          if (constraintWidget5 == this.mChainEnds[3])
            solverVariable1 = (this.mChainEnds[1]).mRight.mSolverVariable; 
          m = constraintWidget4.mLeft.getMargin();
          k = m;
          if (constraintWidget4.mLeft.mTarget != null) {
            k = m;
            if (constraintWidget4.mLeft.mTarget.mOwner.mRight.mTarget != null) {
              k = m;
              if (constraintWidget4.mLeft.mTarget.mOwner.mRight.mTarget.mOwner == constraintWidget4)
                k = m + constraintWidget4.mLeft.mTarget.mOwner.mRight.getMargin(); 
            } 
          } 
          paramLinearSystem.addGreaterThan(solverVariable2, constraintWidget4.mLeft.mTarget.mSolverVariable, k, 2);
          m = constraintWidget4.mRight.getMargin();
          k = m;
          if (constraintWidget4.mRight.mTarget != null) {
            k = m;
            if (constraintWidget4.mHorizontalNextWidget != null) {
              if (constraintWidget4.mHorizontalNextWidget.mLeft.mTarget != null) {
                k = constraintWidget4.mHorizontalNextWidget.mLeft.getMargin();
              } else {
                k = 0;
              } 
              k = m + k;
            } 
          } 
          paramLinearSystem.addLowerThan(solverVariable3, constraintWidget4.mRight.mTarget.mSolverVariable, -k, 2);
          if (j + 1 == n - 1) {
            m = constraintWidget5.mLeft.getMargin();
            k = m;
            if (constraintWidget5.mLeft.mTarget != null) {
              k = m;
              if (constraintWidget5.mLeft.mTarget.mOwner.mRight.mTarget != null) {
                k = m;
                if (constraintWidget5.mLeft.mTarget.mOwner.mRight.mTarget.mOwner == constraintWidget5)
                  k = m + constraintWidget5.mLeft.mTarget.mOwner.mRight.getMargin(); 
              } 
            } 
            paramLinearSystem.addGreaterThan(solverVariable4, constraintWidget5.mLeft.mTarget.mSolverVariable, k, 2);
            ConstraintAnchor constraintAnchor = constraintWidget5.mRight;
            if (constraintWidget5 == this.mChainEnds[3])
              constraintAnchor = (this.mChainEnds[1]).mRight; 
            m = constraintAnchor.getMargin();
            k = m;
            if (constraintAnchor.mTarget != null) {
              k = m;
              if (constraintAnchor.mTarget.mOwner.mLeft.mTarget != null) {
                k = m;
                if (constraintAnchor.mTarget.mOwner.mLeft.mTarget.mOwner == constraintWidget5)
                  k = m + constraintAnchor.mTarget.mOwner.mLeft.getMargin(); 
              } 
            } 
            paramLinearSystem.addLowerThan(solverVariable1, constraintAnchor.mTarget.mSolverVariable, -k, 2);
          } 
          if (constraintWidget3.mMatchConstraintMaxWidth > 0)
            paramLinearSystem.addLowerThan(solverVariable3, solverVariable2, constraintWidget3.mMatchConstraintMaxWidth, 2); 
          ArrayRow arrayRow = paramLinearSystem.createRow();
          arrayRow.createRowEqualDimension(constraintWidget4.mHorizontalWeight, f, constraintWidget5.mHorizontalWeight, solverVariable2, constraintWidget4.mLeft.getMargin(), solverVariable3, constraintWidget4.mRight.getMargin(), solverVariable4, constraintWidget5.mLeft.getMargin(), solverVariable1, constraintWidget5.mRight.getMargin());
          paramLinearSystem.addConstraint(arrayRow);
          j++;
          continue;
        } 
        i++;
        continue label218;
      } 
    } 
  }
  
  private void applyVerticalChain(LinearSystem paramLinearSystem) {
    int i = 0;
    label228: while (i < this.mVerticalChainsSize) {
      int k;
      int m;
      ConstraintWidget constraintWidget3 = this.mVerticalChainsArray[i];
      int n = countMatchConstraintsChainedWidgets(paramLinearSystem, this.mChainEnds, this.mVerticalChainsArray[i], 1, this.flags);
      ConstraintWidget constraintWidget2 = this.mChainEnds[2];
      if (constraintWidget2 == null)
        continue; 
      if (this.flags[1]) {
        j = constraintWidget3.getDrawY();
        while (true) {
          if (constraintWidget2 != null) {
            paramLinearSystem.addEquality(constraintWidget2.mTop.mSolverVariable, j);
            ConstraintWidget constraintWidget = constraintWidget2.mVerticalNextWidget;
            j += constraintWidget2.mTop.getMargin() + constraintWidget2.getHeight() + constraintWidget2.mBottom.getMargin();
            constraintWidget2 = constraintWidget;
            continue;
          } 
          i++;
          continue label228;
        } 
      } 
      if (constraintWidget3.mVerticalChainStyle == 0) {
        k = 1;
      } else {
        k = 0;
      } 
      if (constraintWidget3.mVerticalChainStyle == 2) {
        m = 1;
      } else {
        m = 0;
      } 
      if (this.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        j = 1;
      } else {
        j = 0;
      } 
      if ((this.mOptimizationLevel == 2 || this.mOptimizationLevel == 8) && this.flags[0] && constraintWidget3.mVerticalChainFixedPosition && !m && !j && constraintWidget3.mVerticalChainStyle == 0) {
        Optimizer.applyDirectResolutionVerticalChain(this, paramLinearSystem, n, constraintWidget3);
        continue;
      } 
      if (n == 0 || m) {
        ConstraintWidget constraintWidget5 = null;
        ConstraintWidget constraintWidget6 = null;
        n = 0;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        while (true) {
          ConstraintWidget constraintWidget = constraintWidget4;
          if (constraintWidget != null) {
            ConstraintWidget constraintWidget7 = constraintWidget.mVerticalNextWidget;
            if (constraintWidget7 == null) {
              constraintWidget6 = this.mChainEnds[1];
              n = 1;
            } 
            if (m) {
              int i2;
              SolverVariable solverVariable1;
              ConstraintAnchor constraintAnchor = constraintWidget.mTop;
              int i1 = constraintAnchor.getMargin();
              j = i1;
              if (constraintWidget5 != null)
                j = i1 + constraintWidget5.mBottom.getMargin(); 
              i1 = 1;
              if (constraintWidget2 != constraintWidget)
                i1 = 3; 
              constraintWidget4 = null;
              SolverVariable solverVariable2 = null;
              if (constraintAnchor.mTarget != null) {
                solverVariable1 = constraintAnchor.mSolverVariable;
                solverVariable2 = constraintAnchor.mTarget.mSolverVariable;
                i2 = j;
              } else {
                i2 = j;
                if (constraintWidget.mBaseline.mTarget != null) {
                  solverVariable1 = constraintWidget.mBaseline.mSolverVariable;
                  solverVariable2 = constraintWidget.mBaseline.mTarget.mSolverVariable;
                  i2 = j - constraintAnchor.getMargin();
                } 
              } 
              if (solverVariable1 != null && solverVariable2 != null)
                paramLinearSystem.addGreaterThan(solverVariable1, solverVariable2, i2, i1); 
              constraintWidget5 = constraintWidget7;
              if (constraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintAnchor constraintAnchor1 = constraintWidget.mBottom;
                if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                  j = Math.max(constraintWidget.mMatchConstraintMinHeight, constraintWidget.getHeight());
                  paramLinearSystem.addEquality(constraintAnchor1.mSolverVariable, constraintAnchor.mSolverVariable, j, 3);
                  constraintWidget5 = constraintWidget7;
                } else {
                  paramLinearSystem.addGreaterThan(constraintAnchor.mSolverVariable, constraintAnchor.mTarget.mSolverVariable, constraintAnchor.mMargin, 3);
                  paramLinearSystem.addLowerThan(constraintAnchor1.mSolverVariable, constraintAnchor.mSolverVariable, constraintWidget.mMatchConstraintMinHeight, 3);
                  constraintWidget5 = constraintWidget7;
                } 
              } 
            } else if (!k && n != 0 && constraintWidget5 != null) {
              if (constraintWidget.mBottom.mTarget == null) {
                paramLinearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, constraintWidget.getDrawBottom());
                constraintWidget5 = constraintWidget7;
              } else {
                j = constraintWidget.mBottom.getMargin();
                paramLinearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, constraintWidget6.mBottom.mTarget.mSolverVariable, -j, 5);
                constraintWidget5 = constraintWidget7;
              } 
            } else if (!k && n == 0 && constraintWidget5 == null) {
              if (constraintWidget.mTop.mTarget == null) {
                paramLinearSystem.addEquality(constraintWidget.mTop.mSolverVariable, constraintWidget.getDrawY());
                constraintWidget5 = constraintWidget7;
              } else {
                j = constraintWidget.mTop.getMargin();
                paramLinearSystem.addEquality(constraintWidget.mTop.mSolverVariable, constraintWidget3.mTop.mTarget.mSolverVariable, j, 5);
                constraintWidget5 = constraintWidget7;
              } 
            } else {
              SolverVariable solverVariable;
              ConstraintAnchor constraintAnchor1 = constraintWidget.mTop;
              ConstraintAnchor constraintAnchor2 = constraintWidget.mBottom;
              j = constraintAnchor1.getMargin();
              int i1 = constraintAnchor2.getMargin();
              paramLinearSystem.addGreaterThan(constraintAnchor1.mSolverVariable, constraintAnchor1.mTarget.mSolverVariable, j, 1);
              paramLinearSystem.addLowerThan(constraintAnchor2.mSolverVariable, constraintAnchor2.mTarget.mSolverVariable, -i1, 1);
              if (constraintAnchor1.mTarget != null) {
                solverVariable = constraintAnchor1.mTarget.mSolverVariable;
              } else {
                solverVariable = null;
              } 
              if (constraintWidget5 == null)
                if (constraintWidget3.mTop.mTarget != null) {
                  solverVariable = constraintWidget3.mTop.mTarget.mSolverVariable;
                } else {
                  solverVariable = null;
                }  
              constraintWidget4 = constraintWidget7;
              if (constraintWidget7 == null)
                if (constraintWidget6.mBottom.mTarget != null) {
                  constraintWidget4 = constraintWidget6.mBottom.mTarget.mOwner;
                } else {
                  constraintWidget4 = null;
                }  
              constraintWidget5 = constraintWidget4;
              if (constraintWidget4 != null) {
                SolverVariable solverVariable1 = constraintWidget4.mTop.mSolverVariable;
                if (n != 0)
                  if (constraintWidget6.mBottom.mTarget != null) {
                    solverVariable1 = constraintWidget6.mBottom.mTarget.mSolverVariable;
                  } else {
                    solverVariable1 = null;
                  }  
                constraintWidget5 = constraintWidget4;
                if (solverVariable != null) {
                  constraintWidget5 = constraintWidget4;
                  if (solverVariable1 != null) {
                    paramLinearSystem.addCentering(constraintAnchor1.mSolverVariable, solverVariable, j, 0.5F, solverVariable1, constraintAnchor2.mSolverVariable, i1, 4);
                    constraintWidget5 = constraintWidget4;
                  } 
                } 
              } 
            } 
            if (n != 0) {
              constraintWidget4 = null;
            } else {
              constraintWidget4 = constraintWidget5;
            } 
            constraintWidget5 = constraintWidget;
            continue;
          } 
          if (m) {
            ConstraintAnchor constraintAnchor1 = constraintWidget2.mTop;
            ConstraintAnchor constraintAnchor2 = constraintWidget6.mBottom;
            j = constraintAnchor1.getMargin();
            k = constraintAnchor2.getMargin();
            if (constraintWidget3.mTop.mTarget != null) {
              SolverVariable solverVariable = constraintWidget3.mTop.mTarget.mSolverVariable;
            } else {
              constraintWidget4 = null;
            } 
            if (constraintWidget6.mBottom.mTarget != null) {
              SolverVariable solverVariable = constraintWidget6.mBottom.mTarget.mSolverVariable;
            } else {
              constraintWidget2 = null;
            } 
            if (constraintWidget4 != null) {
              if (constraintWidget2 != null) {
                paramLinearSystem.addLowerThan(constraintAnchor2.mSolverVariable, (SolverVariable)constraintWidget2, -k, 1);
                paramLinearSystem.addCentering(constraintAnchor1.mSolverVariable, (SolverVariable)constraintWidget4, j, constraintWidget3.mVerticalBiasPercent, (SolverVariable)constraintWidget2, constraintAnchor2.mSolverVariable, k, 4);
                continue label228;
              } 
              continue label228;
            } 
            continue label228;
          } 
          continue label228;
        } 
      } 
      ConstraintWidget constraintWidget1 = null;
      float f = 0.0F;
      while (constraintWidget2 != null) {
        if (constraintWidget2.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          k = constraintWidget2.mTop.getMargin();
          j = k;
          if (constraintWidget1 != null)
            j = k + constraintWidget1.mBottom.getMargin(); 
          k = 3;
          if (constraintWidget2.mTop.mTarget.mOwner.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
            k = 2; 
          paramLinearSystem.addGreaterThan(constraintWidget2.mTop.mSolverVariable, constraintWidget2.mTop.mTarget.mSolverVariable, j, k);
          k = constraintWidget2.mBottom.getMargin();
          j = k;
          if (constraintWidget2.mBottom.mTarget.mOwner.mTop.mTarget != null) {
            j = k;
            if (constraintWidget2.mBottom.mTarget.mOwner.mTop.mTarget.mOwner == constraintWidget2)
              j = k + constraintWidget2.mBottom.mTarget.mOwner.mTop.getMargin(); 
          } 
          k = 3;
          if (constraintWidget2.mBottom.mTarget.mOwner.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
            k = 2; 
          paramLinearSystem.addLowerThan(constraintWidget2.mBottom.mSolverVariable, constraintWidget2.mBottom.mTarget.mSolverVariable, -j, k);
        } else {
          f += constraintWidget2.mVerticalWeight;
          j = 0;
          if (constraintWidget2.mBottom.mTarget != null) {
            k = constraintWidget2.mBottom.getMargin();
            j = k;
            if (constraintWidget2 != this.mChainEnds[3])
              j = k + constraintWidget2.mBottom.mTarget.mOwner.mTop.getMargin(); 
          } 
          paramLinearSystem.addGreaterThan(constraintWidget2.mBottom.mSolverVariable, constraintWidget2.mTop.mSolverVariable, 0, 1);
          paramLinearSystem.addLowerThan(constraintWidget2.mBottom.mSolverVariable, constraintWidget2.mBottom.mTarget.mSolverVariable, -j, 1);
        } 
        constraintWidget1 = constraintWidget2;
        constraintWidget2 = constraintWidget2.mVerticalNextWidget;
      } 
      if (n == 1) {
        constraintWidget2 = this.mMatchConstraintsChainedWidgets[0];
        k = constraintWidget2.mTop.getMargin();
        j = k;
        if (constraintWidget2.mTop.mTarget != null)
          j = k + constraintWidget2.mTop.mTarget.getMargin(); 
        m = constraintWidget2.mBottom.getMargin();
        k = m;
        if (constraintWidget2.mBottom.mTarget != null)
          k = m + constraintWidget2.mBottom.mTarget.getMargin(); 
        SolverVariable solverVariable = constraintWidget3.mBottom.mTarget.mSolverVariable;
        if (constraintWidget2 == this.mChainEnds[3])
          solverVariable = (this.mChainEnds[1]).mBottom.mTarget.mSolverVariable; 
        if (constraintWidget2.mMatchConstraintDefaultHeight == 1) {
          paramLinearSystem.addGreaterThan(constraintWidget3.mTop.mSolverVariable, constraintWidget3.mTop.mTarget.mSolverVariable, j, 1);
          paramLinearSystem.addLowerThan(constraintWidget3.mBottom.mSolverVariable, solverVariable, -k, 1);
          paramLinearSystem.addEquality(constraintWidget3.mBottom.mSolverVariable, constraintWidget3.mTop.mSolverVariable, constraintWidget3.getHeight(), 2);
          continue;
        } 
        paramLinearSystem.addEquality(constraintWidget2.mTop.mSolverVariable, constraintWidget2.mTop.mTarget.mSolverVariable, j, 1);
        paramLinearSystem.addEquality(constraintWidget2.mBottom.mSolverVariable, solverVariable, -k, 1);
        continue;
      } 
      int j = 0;
      while (true) {
        if (j < n - 1) {
          ConstraintWidget constraintWidget4 = this.mMatchConstraintsChainedWidgets[j];
          ConstraintWidget constraintWidget5 = this.mMatchConstraintsChainedWidgets[j + 1];
          SolverVariable solverVariable2 = constraintWidget4.mTop.mSolverVariable;
          SolverVariable solverVariable3 = constraintWidget4.mBottom.mSolverVariable;
          SolverVariable solverVariable4 = constraintWidget5.mTop.mSolverVariable;
          SolverVariable solverVariable1 = constraintWidget5.mBottom.mSolverVariable;
          if (constraintWidget5 == this.mChainEnds[3])
            solverVariable1 = (this.mChainEnds[1]).mBottom.mSolverVariable; 
          m = constraintWidget4.mTop.getMargin();
          k = m;
          if (constraintWidget4.mTop.mTarget != null) {
            k = m;
            if (constraintWidget4.mTop.mTarget.mOwner.mBottom.mTarget != null) {
              k = m;
              if (constraintWidget4.mTop.mTarget.mOwner.mBottom.mTarget.mOwner == constraintWidget4)
                k = m + constraintWidget4.mTop.mTarget.mOwner.mBottom.getMargin(); 
            } 
          } 
          paramLinearSystem.addGreaterThan(solverVariable2, constraintWidget4.mTop.mTarget.mSolverVariable, k, 2);
          m = constraintWidget4.mBottom.getMargin();
          k = m;
          if (constraintWidget4.mBottom.mTarget != null) {
            k = m;
            if (constraintWidget4.mVerticalNextWidget != null) {
              if (constraintWidget4.mVerticalNextWidget.mTop.mTarget != null) {
                k = constraintWidget4.mVerticalNextWidget.mTop.getMargin();
              } else {
                k = 0;
              } 
              k = m + k;
            } 
          } 
          paramLinearSystem.addLowerThan(solverVariable3, constraintWidget4.mBottom.mTarget.mSolverVariable, -k, 2);
          if (j + 1 == n - 1) {
            m = constraintWidget5.mTop.getMargin();
            k = m;
            if (constraintWidget5.mTop.mTarget != null) {
              k = m;
              if (constraintWidget5.mTop.mTarget.mOwner.mBottom.mTarget != null) {
                k = m;
                if (constraintWidget5.mTop.mTarget.mOwner.mBottom.mTarget.mOwner == constraintWidget5)
                  k = m + constraintWidget5.mTop.mTarget.mOwner.mBottom.getMargin(); 
              } 
            } 
            paramLinearSystem.addGreaterThan(solverVariable4, constraintWidget5.mTop.mTarget.mSolverVariable, k, 2);
            ConstraintAnchor constraintAnchor = constraintWidget5.mBottom;
            if (constraintWidget5 == this.mChainEnds[3])
              constraintAnchor = (this.mChainEnds[1]).mBottom; 
            m = constraintAnchor.getMargin();
            k = m;
            if (constraintAnchor.mTarget != null) {
              k = m;
              if (constraintAnchor.mTarget.mOwner.mTop.mTarget != null) {
                k = m;
                if (constraintAnchor.mTarget.mOwner.mTop.mTarget.mOwner == constraintWidget5)
                  k = m + constraintAnchor.mTarget.mOwner.mTop.getMargin(); 
              } 
            } 
            paramLinearSystem.addLowerThan(solverVariable1, constraintAnchor.mTarget.mSolverVariable, -k, 2);
          } 
          if (constraintWidget3.mMatchConstraintMaxHeight > 0)
            paramLinearSystem.addLowerThan(solverVariable3, solverVariable2, constraintWidget3.mMatchConstraintMaxHeight, 2); 
          ArrayRow arrayRow = paramLinearSystem.createRow();
          arrayRow.createRowEqualDimension(constraintWidget4.mVerticalWeight, f, constraintWidget5.mVerticalWeight, solverVariable2, constraintWidget4.mTop.getMargin(), solverVariable3, constraintWidget4.mBottom.getMargin(), solverVariable4, constraintWidget5.mTop.getMargin(), solverVariable1, constraintWidget5.mBottom.getMargin());
          paramLinearSystem.addConstraint(arrayRow);
          j++;
          continue;
        } 
        i++;
        continue label228;
      } 
    } 
  }
  
  private int countMatchConstraintsChainedWidgets(LinearSystem paramLinearSystem, ConstraintWidget[] paramArrayOfConstraintWidget, ConstraintWidget paramConstraintWidget, int paramInt, boolean[] paramArrayOfboolean) {
    int j = 0;
    int i = 0;
    paramArrayOfboolean[0] = true;
    paramArrayOfboolean[1] = false;
    paramArrayOfConstraintWidget[0] = null;
    paramArrayOfConstraintWidget[2] = null;
    paramArrayOfConstraintWidget[1] = null;
    paramArrayOfConstraintWidget[3] = null;
    if (paramInt == 0) {
      boolean bool4 = true;
      ConstraintWidget constraintWidget8 = null;
      boolean bool3 = bool4;
      if (paramConstraintWidget.mLeft.mTarget != null) {
        bool3 = bool4;
        if (paramConstraintWidget.mLeft.mTarget.mOwner != this)
          bool3 = false; 
      } 
      paramConstraintWidget.mHorizontalNextWidget = null;
      ConstraintWidget constraintWidget5 = null;
      if (paramConstraintWidget.getVisibility() != 8)
        constraintWidget5 = paramConstraintWidget; 
      ConstraintWidget constraintWidget6 = constraintWidget5;
      ConstraintWidget constraintWidget7 = paramConstraintWidget;
      paramInt = i;
      while (true) {
        j = paramInt;
        ConstraintWidget constraintWidget9 = constraintWidget5;
        ConstraintWidget constraintWidget10 = constraintWidget6;
        if (constraintWidget7.mRight.mTarget != null) {
          constraintWidget7.mHorizontalNextWidget = null;
          if (constraintWidget7.getVisibility() != 8) {
            constraintWidget9 = constraintWidget5;
            if (constraintWidget5 == null)
              constraintWidget9 = constraintWidget7; 
            if (constraintWidget6 != null && constraintWidget6 != constraintWidget7)
              constraintWidget6.mHorizontalNextWidget = constraintWidget7; 
            constraintWidget6 = constraintWidget7;
            constraintWidget5 = constraintWidget9;
          } else {
            paramLinearSystem.addEquality(constraintWidget7.mLeft.mSolverVariable, constraintWidget7.mLeft.mTarget.mSolverVariable, 0, 5);
            paramLinearSystem.addEquality(constraintWidget7.mRight.mSolverVariable, constraintWidget7.mLeft.mSolverVariable, 0, 5);
          } 
          i = paramInt;
          if (constraintWidget7.getVisibility() != 8) {
            i = paramInt;
            if (constraintWidget7.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
              if (constraintWidget7.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
                paramArrayOfboolean[0] = false; 
              i = paramInt;
              if (constraintWidget7.mDimensionRatio <= 0.0F) {
                paramArrayOfboolean[0] = false;
                if (paramInt + 1 >= this.mMatchConstraintsChainedWidgets.length)
                  this.mMatchConstraintsChainedWidgets = Arrays.<ConstraintWidget>copyOf(this.mMatchConstraintsChainedWidgets, this.mMatchConstraintsChainedWidgets.length * 2); 
                this.mMatchConstraintsChainedWidgets[paramInt] = constraintWidget7;
                i = paramInt + 1;
              } 
            } 
          } 
          if (constraintWidget7.mRight.mTarget.mOwner.mLeft.mTarget == null) {
            constraintWidget10 = constraintWidget6;
            constraintWidget9 = constraintWidget5;
            j = i;
          } else {
            j = i;
            constraintWidget9 = constraintWidget5;
            constraintWidget10 = constraintWidget6;
            if (constraintWidget7.mRight.mTarget.mOwner.mLeft.mTarget.mOwner == constraintWidget7) {
              j = i;
              constraintWidget9 = constraintWidget5;
              constraintWidget10 = constraintWidget6;
              if (constraintWidget7.mRight.mTarget.mOwner != constraintWidget7) {
                constraintWidget7 = constraintWidget7.mRight.mTarget.mOwner;
                constraintWidget8 = constraintWidget7;
                paramInt = i;
                continue;
              } 
            } 
          } 
        } 
        bool4 = bool3;
        if (constraintWidget7.mRight.mTarget != null) {
          bool4 = bool3;
          if (constraintWidget7.mRight.mTarget.mOwner != this)
            bool4 = false; 
        } 
        if (paramConstraintWidget.mLeft.mTarget == null || constraintWidget8.mRight.mTarget == null)
          paramArrayOfboolean[1] = true; 
        paramConstraintWidget.mHorizontalChainFixedPosition = bool4;
        constraintWidget8.mHorizontalNextWidget = null;
        paramArrayOfConstraintWidget[0] = paramConstraintWidget;
        paramArrayOfConstraintWidget[2] = constraintWidget9;
        paramArrayOfConstraintWidget[1] = constraintWidget8;
        paramArrayOfConstraintWidget[3] = constraintWidget10;
        return j;
      } 
    } 
    boolean bool2 = true;
    ConstraintWidget constraintWidget4 = null;
    boolean bool1 = bool2;
    if (paramConstraintWidget.mTop.mTarget != null) {
      bool1 = bool2;
      if (paramConstraintWidget.mTop.mTarget.mOwner != this)
        bool1 = false; 
    } 
    paramConstraintWidget.mVerticalNextWidget = null;
    ConstraintWidget constraintWidget1 = null;
    if (paramConstraintWidget.getVisibility() != 8)
      constraintWidget1 = paramConstraintWidget; 
    ConstraintWidget constraintWidget2 = constraintWidget1;
    ConstraintWidget constraintWidget3 = paramConstraintWidget;
    paramInt = j;
    while (true) {
      j = paramInt;
      ConstraintWidget constraintWidget5 = constraintWidget1;
      ConstraintWidget constraintWidget6 = constraintWidget2;
      if (constraintWidget3.mBottom.mTarget != null) {
        constraintWidget3.mVerticalNextWidget = null;
        if (constraintWidget3.getVisibility() != 8) {
          constraintWidget5 = constraintWidget1;
          if (constraintWidget1 == null)
            constraintWidget5 = constraintWidget3; 
          if (constraintWidget2 != null && constraintWidget2 != constraintWidget3)
            constraintWidget2.mVerticalNextWidget = constraintWidget3; 
          constraintWidget2 = constraintWidget3;
          constraintWidget1 = constraintWidget5;
        } else {
          paramLinearSystem.addEquality(constraintWidget3.mTop.mSolverVariable, constraintWidget3.mTop.mTarget.mSolverVariable, 0, 5);
          paramLinearSystem.addEquality(constraintWidget3.mBottom.mSolverVariable, constraintWidget3.mTop.mSolverVariable, 0, 5);
        } 
        i = paramInt;
        if (constraintWidget3.getVisibility() != 8) {
          i = paramInt;
          if (constraintWidget3.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget3.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
              paramArrayOfboolean[0] = false; 
            i = paramInt;
            if (constraintWidget3.mDimensionRatio <= 0.0F) {
              paramArrayOfboolean[0] = false;
              if (paramInt + 1 >= this.mMatchConstraintsChainedWidgets.length)
                this.mMatchConstraintsChainedWidgets = Arrays.<ConstraintWidget>copyOf(this.mMatchConstraintsChainedWidgets, this.mMatchConstraintsChainedWidgets.length * 2); 
              this.mMatchConstraintsChainedWidgets[paramInt] = constraintWidget3;
              i = paramInt + 1;
            } 
          } 
        } 
        if (constraintWidget3.mBottom.mTarget.mOwner.mTop.mTarget == null) {
          constraintWidget6 = constraintWidget2;
          constraintWidget5 = constraintWidget1;
          j = i;
        } else {
          j = i;
          constraintWidget5 = constraintWidget1;
          constraintWidget6 = constraintWidget2;
          if (constraintWidget3.mBottom.mTarget.mOwner.mTop.mTarget.mOwner == constraintWidget3) {
            j = i;
            constraintWidget5 = constraintWidget1;
            constraintWidget6 = constraintWidget2;
            if (constraintWidget3.mBottom.mTarget.mOwner != constraintWidget3) {
              constraintWidget3 = constraintWidget3.mBottom.mTarget.mOwner;
              constraintWidget4 = constraintWidget3;
              paramInt = i;
              continue;
            } 
          } 
        } 
      } 
      bool2 = bool1;
      if (constraintWidget3.mBottom.mTarget != null) {
        bool2 = bool1;
        if (constraintWidget3.mBottom.mTarget.mOwner != this)
          bool2 = false; 
      } 
      if (paramConstraintWidget.mTop.mTarget == null || constraintWidget4.mBottom.mTarget == null)
        paramArrayOfboolean[1] = true; 
      paramConstraintWidget.mVerticalChainFixedPosition = bool2;
      constraintWidget4.mVerticalNextWidget = null;
      paramArrayOfConstraintWidget[0] = paramConstraintWidget;
      paramArrayOfConstraintWidget[2] = constraintWidget5;
      paramArrayOfConstraintWidget[1] = constraintWidget4;
      paramArrayOfConstraintWidget[3] = constraintWidget6;
      return j;
    } 
  }
  
  public static ConstraintWidgetContainer createContainer(ConstraintWidgetContainer paramConstraintWidgetContainer, String paramString, ArrayList<ConstraintWidget> paramArrayList, int paramInt) {
    Rectangle rectangle = getBounds(paramArrayList);
    if (rectangle.width == 0 || rectangle.height == 0)
      return null; 
    if (paramInt > 0) {
      int k = Math.min(rectangle.x, rectangle.y);
      int j = paramInt;
      if (paramInt > k)
        j = k; 
      rectangle.grow(j, j);
    } 
    paramConstraintWidgetContainer.setOrigin(rectangle.x, rectangle.y);
    paramConstraintWidgetContainer.setDimension(rectangle.width, rectangle.height);
    paramConstraintWidgetContainer.setDebugName(paramString);
    ConstraintWidget constraintWidget = ((ConstraintWidget)paramArrayList.get(0)).getParent();
    paramInt = 0;
    int i = paramArrayList.size();
    while (true) {
      ConstraintWidget constraintWidget1 = paramConstraintWidgetContainer;
      if (paramInt < i) {
        constraintWidget1 = paramArrayList.get(paramInt);
        if (constraintWidget1.getParent() == constraintWidget) {
          paramConstraintWidgetContainer.add(constraintWidget1);
          constraintWidget1.setX(constraintWidget1.getX() - rectangle.x);
          constraintWidget1.setY(constraintWidget1.getY() - rectangle.y);
        } 
        paramInt++;
        continue;
      } 
      return (ConstraintWidgetContainer)constraintWidget1;
    } 
  }
  
  private boolean optimize(LinearSystem paramLinearSystem) {
    int i;
    int m;
    int n;
    int i1;
    int i5 = this.mChildren.size();
    int k = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int j = 0;
    while (true) {
      m = i3;
      i = k;
      n = i2;
      i1 = i4;
      if (j < i5) {
        ConstraintWidget constraintWidget = this.mChildren.get(j);
        constraintWidget.mHorizontalResolution = -1;
        constraintWidget.mVerticalResolution = -1;
        if (constraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          constraintWidget.mHorizontalResolution = 1;
          constraintWidget.mVerticalResolution = 1;
        } 
        j++;
        continue;
      } 
      break;
    } 
    label63: while (true) {
      i4 = n;
      i3 = m;
      if (!i) {
        k = 0;
        j = 0;
        i2 = i1 + 1;
        m = 0;
        while (true) {
          if (m < i5) {
            ConstraintWidget constraintWidget = this.mChildren.get(m);
            if (constraintWidget.mHorizontalResolution == -1)
              if (this.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                constraintWidget.mHorizontalResolution = 1;
              } else {
                Optimizer.checkHorizontalSimpleDependency(this, paramLinearSystem, constraintWidget);
              }  
            if (constraintWidget.mVerticalResolution == -1)
              if (this.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                constraintWidget.mVerticalResolution = 1;
              } else {
                Optimizer.checkVerticalSimpleDependency(this, paramLinearSystem, constraintWidget);
              }  
            n = k;
            if (constraintWidget.mVerticalResolution == -1)
              n = k + 1; 
            k = j;
            if (constraintWidget.mHorizontalResolution == -1)
              k = j + 1; 
            m++;
            j = k;
            k = n;
            continue;
          } 
          if (k == 0 && j == 0) {
            i = 1;
            i1 = i2;
            n = k;
            m = j;
            continue label63;
          } 
          break;
        } 
        m = j;
        n = k;
        i1 = i2;
        continue;
      } 
      m = 0;
      i = 0;
      j = 0;
      while (true) {
        j++;
        m = k;
        i = n;
      } 
      return (m == 0 && i == 0);
      if (i4 == k) {
        m = j;
        n = k;
        i1 = i2;
        if (i3 == j) {
          i = 1;
          m = j;
          n = k;
          i1 = i2;
        } 
      } 
    } 
  }
  
  private void resetChains() {
    this.mHorizontalChainsSize = 0;
    this.mVerticalChainsSize = 0;
  }
  
  static int setGroup(ConstraintAnchor paramConstraintAnchor, int paramInt) {
    int j = paramConstraintAnchor.mGroup;
    if (paramConstraintAnchor.mOwner.getParent() == null)
      return paramInt; 
    int i = j;
    if (j > paramInt) {
      paramConstraintAnchor.mGroup = paramInt;
      ConstraintAnchor constraintAnchor1 = paramConstraintAnchor.getOpposite();
      ConstraintAnchor constraintAnchor2 = paramConstraintAnchor.mTarget;
      i = paramInt;
      if (constraintAnchor1 != null)
        i = setGroup(constraintAnchor1, paramInt); 
      paramInt = i;
      if (constraintAnchor2 != null)
        paramInt = setGroup(constraintAnchor2, i); 
      i = paramInt;
      if (constraintAnchor1 != null)
        i = setGroup(constraintAnchor1, paramInt); 
      paramConstraintAnchor.mGroup = i;
      return i;
    } 
    return i;
  }
  
  void addChain(ConstraintWidget paramConstraintWidget, int paramInt) {
    if (paramInt == 0) {
      while (paramConstraintWidget.mLeft.mTarget != null && paramConstraintWidget.mLeft.mTarget.mOwner.mRight.mTarget != null && paramConstraintWidget.mLeft.mTarget.mOwner.mRight.mTarget == paramConstraintWidget.mLeft && paramConstraintWidget.mLeft.mTarget.mOwner != paramConstraintWidget)
        paramConstraintWidget = paramConstraintWidget.mLeft.mTarget.mOwner; 
      addHorizontalChain(paramConstraintWidget);
      return;
    } 
    if (paramInt == 1) {
      while (paramConstraintWidget.mTop.mTarget != null && paramConstraintWidget.mTop.mTarget.mOwner.mBottom.mTarget != null && paramConstraintWidget.mTop.mTarget.mOwner.mBottom.mTarget == paramConstraintWidget.mTop && paramConstraintWidget.mTop.mTarget.mOwner != paramConstraintWidget)
        paramConstraintWidget = paramConstraintWidget.mTop.mTarget.mOwner; 
      addVerticalChain(paramConstraintWidget);
      return;
    } 
  }
  
  public boolean addChildrenToSolver(LinearSystem paramLinearSystem, int paramInt) {
    addToSolver(paramLinearSystem, paramInt);
    int j = this.mChildren.size();
    boolean bool = false;
    if (this.mOptimizationLevel == 2 || this.mOptimizationLevel == 4) {
      if (optimize(paramLinearSystem))
        return false; 
    } else {
      bool = true;
    } 
    for (int i = 0; i < j; i++) {
      ConstraintWidget constraintWidget = this.mChildren.get(i);
      if (constraintWidget instanceof ConstraintWidgetContainer) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour1 = constraintWidget.mHorizontalDimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.mVerticalDimensionBehaviour;
        if (dimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED); 
        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED); 
        constraintWidget.addToSolver(paramLinearSystem, paramInt);
        if (dimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour1); 
        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2); 
      } else {
        if (bool)
          Optimizer.checkMatchParent(this, paramLinearSystem, constraintWidget); 
        constraintWidget.addToSolver(paramLinearSystem, paramInt);
      } 
    } 
    if (this.mHorizontalChainsSize > 0)
      applyHorizontalChain(paramLinearSystem); 
    if (this.mVerticalChainsSize > 0)
      applyVerticalChain(paramLinearSystem); 
    return true;
  }
  
  public void findHorizontalWrapRecursive(ConstraintWidget paramConstraintWidget, boolean[] paramArrayOfboolean) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #9
    //   3: aload_1
    //   4: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   7: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   10: if_acmpne -> 37
    //   13: aload_1
    //   14: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   17: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   20: if_acmpne -> 37
    //   23: aload_1
    //   24: getfield mDimensionRatio : F
    //   27: fconst_0
    //   28: fcmpl
    //   29: ifle -> 37
    //   32: aload_2
    //   33: iconst_0
    //   34: iconst_0
    //   35: bastore
    //   36: return
    //   37: aload_1
    //   38: invokevirtual getOptimizerWrapWidth : ()I
    //   41: istore #6
    //   43: aload_1
    //   44: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   47: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   50: if_acmpne -> 77
    //   53: aload_1
    //   54: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   57: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   60: if_acmpeq -> 77
    //   63: aload_1
    //   64: getfield mDimensionRatio : F
    //   67: fconst_0
    //   68: fcmpl
    //   69: ifle -> 77
    //   72: aload_2
    //   73: iconst_0
    //   74: iconst_0
    //   75: bastore
    //   76: return
    //   77: iload #6
    //   79: istore #4
    //   81: aconst_null
    //   82: astore #11
    //   84: aconst_null
    //   85: astore #10
    //   87: aload_1
    //   88: iconst_1
    //   89: putfield mHorizontalWrapVisited : Z
    //   92: aload_1
    //   93: instanceof android/support/constraint/solver/widgets/Guideline
    //   96: ifeq -> 203
    //   99: aload_1
    //   100: checkcast android/support/constraint/solver/widgets/Guideline
    //   103: astore_2
    //   104: iload #6
    //   106: istore_3
    //   107: aload_2
    //   108: invokevirtual getOrientation : ()I
    //   111: iconst_1
    //   112: if_icmpne -> 134
    //   115: iconst_0
    //   116: istore #5
    //   118: iconst_0
    //   119: istore #4
    //   121: aload_2
    //   122: invokevirtual getRelativeBegin : ()I
    //   125: iconst_m1
    //   126: if_icmpeq -> 180
    //   129: aload_2
    //   130: invokevirtual getRelativeBegin : ()I
    //   133: istore_3
    //   134: iload_3
    //   135: istore #6
    //   137: iload #4
    //   139: istore #5
    //   141: aload_1
    //   142: invokevirtual getVisibility : ()I
    //   145: bipush #8
    //   147: if_icmpne -> 167
    //   150: iload_3
    //   151: aload_1
    //   152: getfield mWidth : I
    //   155: isub
    //   156: istore #6
    //   158: iload #4
    //   160: aload_1
    //   161: getfield mWidth : I
    //   164: isub
    //   165: istore #5
    //   167: aload_1
    //   168: iload #6
    //   170: putfield mDistToLeft : I
    //   173: aload_1
    //   174: iload #5
    //   176: putfield mDistToRight : I
    //   179: return
    //   180: iload #5
    //   182: istore_3
    //   183: aload_2
    //   184: invokevirtual getRelativeEnd : ()I
    //   187: iconst_m1
    //   188: if_icmpeq -> 134
    //   191: aload_2
    //   192: invokevirtual getRelativeEnd : ()I
    //   195: istore #4
    //   197: iload #5
    //   199: istore_3
    //   200: goto -> 134
    //   203: aload_1
    //   204: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   207: invokevirtual isConnected : ()Z
    //   210: ifne -> 234
    //   213: aload_1
    //   214: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   217: invokevirtual isConnected : ()Z
    //   220: ifne -> 234
    //   223: iload #6
    //   225: aload_1
    //   226: invokevirtual getX : ()I
    //   229: iadd
    //   230: istore_3
    //   231: goto -> 134
    //   234: aload_1
    //   235: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   238: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   241: ifnull -> 316
    //   244: aload_1
    //   245: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   248: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   251: ifnull -> 316
    //   254: aload_1
    //   255: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   258: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   261: aload_1
    //   262: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   265: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   268: if_acmpeq -> 311
    //   271: aload_1
    //   272: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   275: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   278: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   281: aload_1
    //   282: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   285: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   288: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   291: if_acmpne -> 316
    //   294: aload_1
    //   295: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   298: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   301: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   304: aload_1
    //   305: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   308: if_acmpeq -> 316
    //   311: aload_2
    //   312: iconst_0
    //   313: iconst_0
    //   314: bastore
    //   315: return
    //   316: iload #4
    //   318: istore_3
    //   319: aload_1
    //   320: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   323: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   326: ifnull -> 397
    //   329: aload_1
    //   330: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   333: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   336: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   339: astore #12
    //   341: iload #4
    //   343: aload_1
    //   344: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   347: invokevirtual getMargin : ()I
    //   350: iadd
    //   351: istore #4
    //   353: iload #4
    //   355: istore_3
    //   356: aload #12
    //   358: astore #10
    //   360: aload #12
    //   362: invokevirtual isRoot : ()Z
    //   365: ifne -> 397
    //   368: iload #4
    //   370: istore_3
    //   371: aload #12
    //   373: astore #10
    //   375: aload #12
    //   377: getfield mHorizontalWrapVisited : Z
    //   380: ifne -> 397
    //   383: aload_0
    //   384: aload #12
    //   386: aload_2
    //   387: invokevirtual findHorizontalWrapRecursive : (Landroid/support/constraint/solver/widgets/ConstraintWidget;[Z)V
    //   390: aload #12
    //   392: astore #10
    //   394: iload #4
    //   396: istore_3
    //   397: iload #6
    //   399: istore #5
    //   401: aload_1
    //   402: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   405: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   408: ifnull -> 482
    //   411: aload_1
    //   412: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   415: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   418: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   421: astore #12
    //   423: iload #6
    //   425: aload_1
    //   426: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   429: invokevirtual getMargin : ()I
    //   432: iadd
    //   433: istore #4
    //   435: iload #4
    //   437: istore #5
    //   439: aload #12
    //   441: astore #11
    //   443: aload #12
    //   445: invokevirtual isRoot : ()Z
    //   448: ifne -> 482
    //   451: iload #4
    //   453: istore #5
    //   455: aload #12
    //   457: astore #11
    //   459: aload #12
    //   461: getfield mHorizontalWrapVisited : Z
    //   464: ifne -> 482
    //   467: aload_0
    //   468: aload #12
    //   470: aload_2
    //   471: invokevirtual findHorizontalWrapRecursive : (Landroid/support/constraint/solver/widgets/ConstraintWidget;[Z)V
    //   474: aload #12
    //   476: astore #11
    //   478: iload #4
    //   480: istore #5
    //   482: iload_3
    //   483: istore #6
    //   485: aload_1
    //   486: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   489: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   492: ifnull -> 622
    //   495: iload_3
    //   496: istore #6
    //   498: aload #10
    //   500: invokevirtual isRoot : ()Z
    //   503: ifne -> 622
    //   506: aload_1
    //   507: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   510: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   513: getfield mType : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   516: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   519: if_acmpne -> 792
    //   522: iload_3
    //   523: aload #10
    //   525: getfield mDistToRight : I
    //   528: aload #10
    //   530: invokevirtual getOptimizerWrapWidth : ()I
    //   533: isub
    //   534: iadd
    //   535: istore #4
    //   537: aload #10
    //   539: getfield mRightHasCentered : Z
    //   542: ifne -> 578
    //   545: aload #10
    //   547: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   550: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   553: ifnull -> 823
    //   556: aload #10
    //   558: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   561: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   564: ifnull -> 823
    //   567: aload #10
    //   569: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   572: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   575: if_acmpeq -> 823
    //   578: iconst_1
    //   579: istore #8
    //   581: aload_1
    //   582: iload #8
    //   584: putfield mRightHasCentered : Z
    //   587: iload #4
    //   589: istore #6
    //   591: aload_1
    //   592: getfield mRightHasCentered : Z
    //   595: ifeq -> 622
    //   598: aload #10
    //   600: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   603: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   606: ifnonnull -> 829
    //   609: iload #4
    //   611: iload #4
    //   613: aload #10
    //   615: getfield mDistToRight : I
    //   618: isub
    //   619: iadd
    //   620: istore #6
    //   622: iload #5
    //   624: istore_3
    //   625: iload #6
    //   627: istore #4
    //   629: aload_1
    //   630: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   633: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   636: ifnull -> 134
    //   639: iload #5
    //   641: istore_3
    //   642: iload #6
    //   644: istore #4
    //   646: aload #11
    //   648: invokevirtual isRoot : ()Z
    //   651: ifne -> 134
    //   654: aload_1
    //   655: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   658: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   661: invokevirtual getType : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   664: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   667: if_acmpne -> 851
    //   670: iload #5
    //   672: aload #11
    //   674: getfield mDistToLeft : I
    //   677: aload #11
    //   679: invokevirtual getOptimizerWrapWidth : ()I
    //   682: isub
    //   683: iadd
    //   684: istore #7
    //   686: aload #11
    //   688: getfield mLeftHasCentered : Z
    //   691: ifne -> 739
    //   694: iload #9
    //   696: istore #8
    //   698: aload #11
    //   700: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   703: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   706: ifnull -> 742
    //   709: iload #9
    //   711: istore #8
    //   713: aload #11
    //   715: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   718: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   721: ifnull -> 742
    //   724: iload #9
    //   726: istore #8
    //   728: aload #11
    //   730: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   733: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   736: if_acmpeq -> 742
    //   739: iconst_1
    //   740: istore #8
    //   742: aload_1
    //   743: iload #8
    //   745: putfield mLeftHasCentered : Z
    //   748: iload #7
    //   750: istore_3
    //   751: iload #6
    //   753: istore #4
    //   755: aload_1
    //   756: getfield mLeftHasCentered : Z
    //   759: ifeq -> 134
    //   762: aload #11
    //   764: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   767: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   770: ifnonnull -> 884
    //   773: iload #7
    //   775: iload #7
    //   777: aload #11
    //   779: getfield mDistToLeft : I
    //   782: isub
    //   783: iadd
    //   784: istore_3
    //   785: iload #6
    //   787: istore #4
    //   789: goto -> 134
    //   792: iload_3
    //   793: istore #4
    //   795: aload_1
    //   796: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   799: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   802: invokevirtual getType : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   805: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   808: if_acmpne -> 537
    //   811: iload_3
    //   812: aload #10
    //   814: getfield mDistToRight : I
    //   817: iadd
    //   818: istore #4
    //   820: goto -> 537
    //   823: iconst_0
    //   824: istore #8
    //   826: goto -> 581
    //   829: iload #4
    //   831: istore #6
    //   833: aload #10
    //   835: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   838: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   841: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   844: aload_1
    //   845: if_acmpeq -> 622
    //   848: goto -> 609
    //   851: iload #5
    //   853: istore #7
    //   855: aload_1
    //   856: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   859: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   862: invokevirtual getType : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   865: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   868: if_acmpne -> 686
    //   871: iload #5
    //   873: aload #11
    //   875: getfield mDistToLeft : I
    //   878: iadd
    //   879: istore #7
    //   881: goto -> 686
    //   884: iload #7
    //   886: istore_3
    //   887: iload #6
    //   889: istore #4
    //   891: aload #11
    //   893: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   896: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   899: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   902: aload_1
    //   903: if_acmpeq -> 134
    //   906: goto -> 773
  }
  
  public void findVerticalWrapRecursive(ConstraintWidget paramConstraintWidget, boolean[] paramArrayOfboolean) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #9
    //   3: aload_1
    //   4: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   7: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   10: if_acmpne -> 37
    //   13: aload_1
    //   14: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   17: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   20: if_acmpeq -> 37
    //   23: aload_1
    //   24: getfield mDimensionRatio : F
    //   27: fconst_0
    //   28: fcmpl
    //   29: ifle -> 37
    //   32: aload_2
    //   33: iconst_0
    //   34: iconst_0
    //   35: bastore
    //   36: return
    //   37: aload_1
    //   38: invokevirtual getOptimizerWrapHeight : ()I
    //   41: istore_3
    //   42: iload_3
    //   43: istore #5
    //   45: iload_3
    //   46: istore #4
    //   48: aconst_null
    //   49: astore #10
    //   51: aconst_null
    //   52: astore #11
    //   54: aload_1
    //   55: iconst_1
    //   56: putfield mVerticalWrapVisited : Z
    //   59: aload_1
    //   60: instanceof android/support/constraint/solver/widgets/Guideline
    //   63: ifeq -> 174
    //   66: aload_1
    //   67: checkcast android/support/constraint/solver/widgets/Guideline
    //   70: astore_2
    //   71: iload #4
    //   73: istore_3
    //   74: iload #5
    //   76: istore #4
    //   78: aload_2
    //   79: invokevirtual getOrientation : ()I
    //   82: ifne -> 104
    //   85: iconst_0
    //   86: istore #5
    //   88: iconst_0
    //   89: istore_3
    //   90: aload_2
    //   91: invokevirtual getRelativeBegin : ()I
    //   94: iconst_m1
    //   95: if_icmpeq -> 150
    //   98: aload_2
    //   99: invokevirtual getRelativeBegin : ()I
    //   102: istore #4
    //   104: iload_3
    //   105: istore #6
    //   107: iload #4
    //   109: istore #5
    //   111: aload_1
    //   112: invokevirtual getVisibility : ()I
    //   115: bipush #8
    //   117: if_icmpne -> 137
    //   120: iload #4
    //   122: aload_1
    //   123: getfield mHeight : I
    //   126: isub
    //   127: istore #5
    //   129: iload_3
    //   130: aload_1
    //   131: getfield mHeight : I
    //   134: isub
    //   135: istore #6
    //   137: aload_1
    //   138: iload #5
    //   140: putfield mDistToTop : I
    //   143: aload_1
    //   144: iload #6
    //   146: putfield mDistToBottom : I
    //   149: return
    //   150: iload #5
    //   152: istore #4
    //   154: aload_2
    //   155: invokevirtual getRelativeEnd : ()I
    //   158: iconst_m1
    //   159: if_icmpeq -> 104
    //   162: aload_2
    //   163: invokevirtual getRelativeEnd : ()I
    //   166: istore_3
    //   167: iload #5
    //   169: istore #4
    //   171: goto -> 104
    //   174: aload_1
    //   175: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   178: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   181: ifnonnull -> 223
    //   184: aload_1
    //   185: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   188: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   191: ifnonnull -> 223
    //   194: aload_1
    //   195: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   198: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   201: ifnonnull -> 223
    //   204: iload #5
    //   206: aload_1
    //   207: invokevirtual getY : ()I
    //   210: iadd
    //   211: istore #5
    //   213: iload #4
    //   215: istore_3
    //   216: iload #5
    //   218: istore #4
    //   220: goto -> 104
    //   223: aload_1
    //   224: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   227: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   230: ifnull -> 305
    //   233: aload_1
    //   234: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   237: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   240: ifnull -> 305
    //   243: aload_1
    //   244: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   247: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   250: aload_1
    //   251: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   254: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   257: if_acmpeq -> 300
    //   260: aload_1
    //   261: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   264: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   267: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   270: aload_1
    //   271: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   274: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   277: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   280: if_acmpne -> 305
    //   283: aload_1
    //   284: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   287: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   290: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   293: aload_1
    //   294: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   297: if_acmpeq -> 305
    //   300: aload_2
    //   301: iconst_0
    //   302: iconst_0
    //   303: bastore
    //   304: return
    //   305: aload_1
    //   306: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   309: invokevirtual isConnected : ()Z
    //   312: ifeq -> 425
    //   315: aload_1
    //   316: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   319: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   322: invokevirtual getOwner : ()Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   325: astore #10
    //   327: aload #10
    //   329: getfield mVerticalWrapVisited : Z
    //   332: ifne -> 342
    //   335: aload_0
    //   336: aload #10
    //   338: aload_2
    //   339: invokevirtual findVerticalWrapRecursive : (Landroid/support/constraint/solver/widgets/ConstraintWidget;[Z)V
    //   342: aload #10
    //   344: getfield mDistToTop : I
    //   347: aload #10
    //   349: getfield mHeight : I
    //   352: isub
    //   353: iload_3
    //   354: iadd
    //   355: iload_3
    //   356: invokestatic max : (II)I
    //   359: istore #5
    //   361: aload #10
    //   363: getfield mDistToBottom : I
    //   366: aload #10
    //   368: getfield mHeight : I
    //   371: isub
    //   372: iload_3
    //   373: iadd
    //   374: iload_3
    //   375: invokestatic max : (II)I
    //   378: istore #6
    //   380: iload #6
    //   382: istore #4
    //   384: iload #5
    //   386: istore_3
    //   387: aload_1
    //   388: invokevirtual getVisibility : ()I
    //   391: bipush #8
    //   393: if_icmpne -> 413
    //   396: iload #5
    //   398: aload_1
    //   399: getfield mHeight : I
    //   402: isub
    //   403: istore_3
    //   404: iload #6
    //   406: aload_1
    //   407: getfield mHeight : I
    //   410: isub
    //   411: istore #4
    //   413: aload_1
    //   414: iload_3
    //   415: putfield mDistToTop : I
    //   418: aload_1
    //   419: iload #4
    //   421: putfield mDistToBottom : I
    //   424: return
    //   425: iload #5
    //   427: istore_3
    //   428: aload_1
    //   429: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   432: invokevirtual isConnected : ()Z
    //   435: ifeq -> 506
    //   438: aload_1
    //   439: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   442: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   445: invokevirtual getOwner : ()Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   448: astore #12
    //   450: iload #5
    //   452: aload_1
    //   453: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   456: invokevirtual getMargin : ()I
    //   459: iadd
    //   460: istore #5
    //   462: iload #5
    //   464: istore_3
    //   465: aload #12
    //   467: astore #10
    //   469: aload #12
    //   471: invokevirtual isRoot : ()Z
    //   474: ifne -> 506
    //   477: iload #5
    //   479: istore_3
    //   480: aload #12
    //   482: astore #10
    //   484: aload #12
    //   486: getfield mVerticalWrapVisited : Z
    //   489: ifne -> 506
    //   492: aload_0
    //   493: aload #12
    //   495: aload_2
    //   496: invokevirtual findVerticalWrapRecursive : (Landroid/support/constraint/solver/widgets/ConstraintWidget;[Z)V
    //   499: aload #12
    //   501: astore #10
    //   503: iload #5
    //   505: istore_3
    //   506: iload #4
    //   508: istore #5
    //   510: aload_1
    //   511: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   514: invokevirtual isConnected : ()Z
    //   517: ifeq -> 591
    //   520: aload_1
    //   521: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   524: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   527: invokevirtual getOwner : ()Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   530: astore #12
    //   532: iload #4
    //   534: aload_1
    //   535: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   538: invokevirtual getMargin : ()I
    //   541: iadd
    //   542: istore #4
    //   544: aload #12
    //   546: astore #11
    //   548: iload #4
    //   550: istore #5
    //   552: aload #12
    //   554: invokevirtual isRoot : ()Z
    //   557: ifne -> 591
    //   560: aload #12
    //   562: astore #11
    //   564: iload #4
    //   566: istore #5
    //   568: aload #12
    //   570: getfield mVerticalWrapVisited : Z
    //   573: ifne -> 591
    //   576: aload_0
    //   577: aload #12
    //   579: aload_2
    //   580: invokevirtual findVerticalWrapRecursive : (Landroid/support/constraint/solver/widgets/ConstraintWidget;[Z)V
    //   583: iload #4
    //   585: istore #5
    //   587: aload #12
    //   589: astore #11
    //   591: iload_3
    //   592: istore #6
    //   594: aload_1
    //   595: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   598: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   601: ifnull -> 761
    //   604: iload_3
    //   605: istore #6
    //   607: aload #10
    //   609: invokevirtual isRoot : ()Z
    //   612: ifne -> 761
    //   615: aload_1
    //   616: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   619: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   622: invokevirtual getType : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   625: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   628: if_acmpne -> 969
    //   631: iload_3
    //   632: aload #10
    //   634: getfield mDistToTop : I
    //   637: aload #10
    //   639: invokevirtual getOptimizerWrapHeight : ()I
    //   642: isub
    //   643: iadd
    //   644: istore #4
    //   646: aload #10
    //   648: getfield mTopHasCentered : Z
    //   651: ifne -> 717
    //   654: aload #10
    //   656: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   659: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   662: ifnull -> 1000
    //   665: aload #10
    //   667: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   670: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   673: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   676: aload_1
    //   677: if_acmpeq -> 1000
    //   680: aload #10
    //   682: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   685: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   688: ifnull -> 1000
    //   691: aload #10
    //   693: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   696: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   699: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   702: aload_1
    //   703: if_acmpeq -> 1000
    //   706: aload #10
    //   708: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   711: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   714: if_acmpeq -> 1000
    //   717: iconst_1
    //   718: istore #8
    //   720: aload_1
    //   721: iload #8
    //   723: putfield mTopHasCentered : Z
    //   726: iload #4
    //   728: istore #6
    //   730: aload_1
    //   731: getfield mTopHasCentered : Z
    //   734: ifeq -> 761
    //   737: aload #10
    //   739: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   742: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   745: ifnonnull -> 1006
    //   748: iload #4
    //   750: iload #4
    //   752: aload #10
    //   754: getfield mDistToTop : I
    //   757: isub
    //   758: iadd
    //   759: istore #6
    //   761: iload #5
    //   763: istore_3
    //   764: iload #6
    //   766: istore #4
    //   768: aload_1
    //   769: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   772: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   775: ifnull -> 104
    //   778: iload #5
    //   780: istore_3
    //   781: iload #6
    //   783: istore #4
    //   785: aload #11
    //   787: invokevirtual isRoot : ()Z
    //   790: ifne -> 104
    //   793: aload_1
    //   794: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   797: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   800: invokevirtual getType : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   803: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   806: if_acmpne -> 1028
    //   809: iload #5
    //   811: aload #11
    //   813: getfield mDistToBottom : I
    //   816: aload #11
    //   818: invokevirtual getOptimizerWrapHeight : ()I
    //   821: isub
    //   822: iadd
    //   823: istore #7
    //   825: aload #11
    //   827: getfield mBottomHasCentered : Z
    //   830: ifne -> 916
    //   833: iload #9
    //   835: istore #8
    //   837: aload #11
    //   839: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   842: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   845: ifnull -> 919
    //   848: iload #9
    //   850: istore #8
    //   852: aload #11
    //   854: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   857: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   860: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   863: aload_1
    //   864: if_acmpeq -> 919
    //   867: iload #9
    //   869: istore #8
    //   871: aload #11
    //   873: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   876: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   879: ifnull -> 919
    //   882: iload #9
    //   884: istore #8
    //   886: aload #11
    //   888: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   891: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   894: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   897: aload_1
    //   898: if_acmpeq -> 919
    //   901: iload #9
    //   903: istore #8
    //   905: aload #11
    //   907: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   910: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   913: if_acmpeq -> 919
    //   916: iconst_1
    //   917: istore #8
    //   919: aload_1
    //   920: iload #8
    //   922: putfield mBottomHasCentered : Z
    //   925: iload #7
    //   927: istore_3
    //   928: iload #6
    //   930: istore #4
    //   932: aload_1
    //   933: getfield mBottomHasCentered : Z
    //   936: ifeq -> 104
    //   939: aload #11
    //   941: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   944: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   947: ifnonnull -> 1061
    //   950: iload #7
    //   952: iload #7
    //   954: aload #11
    //   956: getfield mDistToBottom : I
    //   959: isub
    //   960: iadd
    //   961: istore_3
    //   962: iload #6
    //   964: istore #4
    //   966: goto -> 104
    //   969: iload_3
    //   970: istore #4
    //   972: aload_1
    //   973: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   976: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   979: invokevirtual getType : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   982: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   985: if_acmpne -> 646
    //   988: iload_3
    //   989: aload #10
    //   991: getfield mDistToTop : I
    //   994: iadd
    //   995: istore #4
    //   997: goto -> 646
    //   1000: iconst_0
    //   1001: istore #8
    //   1003: goto -> 720
    //   1006: iload #4
    //   1008: istore #6
    //   1010: aload #10
    //   1012: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1015: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1018: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1021: aload_1
    //   1022: if_acmpeq -> 761
    //   1025: goto -> 748
    //   1028: iload #5
    //   1030: istore #7
    //   1032: aload_1
    //   1033: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1036: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1039: invokevirtual getType : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1042: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1045: if_acmpne -> 825
    //   1048: iload #5
    //   1050: aload #11
    //   1052: getfield mDistToBottom : I
    //   1055: iadd
    //   1056: istore #7
    //   1058: goto -> 825
    //   1061: iload #7
    //   1063: istore_3
    //   1064: iload #6
    //   1066: istore #4
    //   1068: aload #11
    //   1070: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1073: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1076: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1079: aload_1
    //   1080: if_acmpeq -> 104
    //   1083: goto -> 950
  }
  
  public void findWrapSize(ArrayList<ConstraintWidget> paramArrayList, boolean[] paramArrayOfboolean) {
    int n = 0;
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    int m = 0;
    int j = 0;
    int i4 = paramArrayList.size();
    paramArrayOfboolean[0] = true;
    for (int k = 0; k < i4; k++) {
      ConstraintWidget constraintWidget = paramArrayList.get(k);
      if (!constraintWidget.isRoot()) {
        if (!constraintWidget.mHorizontalWrapVisited)
          findHorizontalWrapRecursive(constraintWidget, paramArrayOfboolean); 
        if (!constraintWidget.mVerticalWrapVisited)
          findVerticalWrapRecursive(constraintWidget, paramArrayOfboolean); 
        if (!paramArrayOfboolean[0])
          return; 
        int i5 = constraintWidget.mDistToLeft + constraintWidget.mDistToRight - constraintWidget.getWidth();
        int i6 = constraintWidget.mDistToTop + constraintWidget.mDistToBottom - constraintWidget.getHeight();
        if (constraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)
          i5 = constraintWidget.getWidth() + constraintWidget.mLeft.mMargin + constraintWidget.mRight.mMargin; 
        if (constraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)
          i6 = constraintWidget.getHeight() + constraintWidget.mTop.mMargin + constraintWidget.mBottom.mMargin; 
        if (constraintWidget.getVisibility() == 8) {
          i5 = 0;
          i6 = 0;
        } 
        i3 = Math.max(i3, constraintWidget.mDistToLeft);
        i2 = Math.max(i2, constraintWidget.mDistToRight);
        i1 = Math.max(i1, constraintWidget.mDistToBottom);
        n = Math.max(n, constraintWidget.mDistToTop);
        m = Math.max(m, i5);
        j = Math.max(j, i6);
      } 
    } 
    int i = Math.max(i3, i2);
    this.mWrapWidth = Math.max(this.mMinWidth, Math.max(i, m));
    i = Math.max(n, i1);
    this.mWrapHeight = Math.max(this.mMinHeight, Math.max(i, j));
    i = 0;
    while (true) {
      if (i < i4) {
        ConstraintWidget constraintWidget = paramArrayList.get(i);
        constraintWidget.mHorizontalWrapVisited = false;
        constraintWidget.mVerticalWrapVisited = false;
        constraintWidget.mLeftHasCentered = false;
        constraintWidget.mRightHasCentered = false;
        constraintWidget.mTopHasCentered = false;
        constraintWidget.mBottomHasCentered = false;
        i++;
        continue;
      } 
      return;
    } 
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines() {
    ArrayList<ConstraintWidget> arrayList = new ArrayList();
    int i = 0;
    int j = this.mChildren.size();
    while (i < j) {
      ConstraintWidget constraintWidget = this.mChildren.get(i);
      if (constraintWidget instanceof Guideline) {
        constraintWidget = constraintWidget;
        if (constraintWidget.getOrientation() == 0)
          arrayList.add(constraintWidget); 
      } 
      i++;
    } 
    return (ArrayList)arrayList;
  }
  
  public LinearSystem getSystem() {
    return this.mSystem;
  }
  
  public String getType() {
    return "ConstraintLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines() {
    ArrayList<ConstraintWidget> arrayList = new ArrayList();
    int i = 0;
    int j = this.mChildren.size();
    while (i < j) {
      ConstraintWidget constraintWidget = this.mChildren.get(i);
      if (constraintWidget instanceof Guideline) {
        constraintWidget = constraintWidget;
        if (constraintWidget.getOrientation() == 1)
          arrayList.add(constraintWidget); 
      } 
      i++;
    } 
    return (ArrayList)arrayList;
  }
  
  public boolean handlesInternalConstraints() {
    return false;
  }
  
  public boolean isHeightMeasuredTooSmall() {
    return this.mHeightMeasuredTooSmall;
  }
  
  public boolean isWidthMeasuredTooSmall() {
    return this.mWidthMeasuredTooSmall;
  }
  
  public void layout() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mX : I
    //   4: istore #5
    //   6: aload_0
    //   7: getfield mY : I
    //   10: istore #6
    //   12: iconst_0
    //   13: aload_0
    //   14: invokevirtual getWidth : ()I
    //   17: invokestatic max : (II)I
    //   20: istore #7
    //   22: iconst_0
    //   23: aload_0
    //   24: invokevirtual getHeight : ()I
    //   27: invokestatic max : (II)I
    //   30: istore #8
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield mWidthMeasuredTooSmall : Z
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield mHeightMeasuredTooSmall : Z
    //   42: aload_0
    //   43: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   46: ifnull -> 379
    //   49: aload_0
    //   50: getfield mSnapshot : Landroid/support/constraint/solver/widgets/Snapshot;
    //   53: ifnonnull -> 68
    //   56: aload_0
    //   57: new android/support/constraint/solver/widgets/Snapshot
    //   60: dup
    //   61: aload_0
    //   62: invokespecial <init> : (Landroid/support/constraint/solver/widgets/ConstraintWidget;)V
    //   65: putfield mSnapshot : Landroid/support/constraint/solver/widgets/Snapshot;
    //   68: aload_0
    //   69: getfield mSnapshot : Landroid/support/constraint/solver/widgets/Snapshot;
    //   72: aload_0
    //   73: invokevirtual updateFrom : (Landroid/support/constraint/solver/widgets/ConstraintWidget;)V
    //   76: aload_0
    //   77: aload_0
    //   78: getfield mPaddingLeft : I
    //   81: invokevirtual setX : (I)V
    //   84: aload_0
    //   85: aload_0
    //   86: getfield mPaddingTop : I
    //   89: invokevirtual setY : (I)V
    //   92: aload_0
    //   93: invokevirtual resetAnchors : ()V
    //   96: aload_0
    //   97: aload_0
    //   98: getfield mSystem : Landroid/support/constraint/solver/LinearSystem;
    //   101: invokevirtual getCache : ()Landroid/support/constraint/solver/Cache;
    //   104: invokevirtual resetSolverVariables : (Landroid/support/constraint/solver/Cache;)V
    //   107: iconst_0
    //   108: istore #11
    //   110: aload_0
    //   111: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   114: astore #16
    //   116: aload_0
    //   117: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   120: astore #17
    //   122: iload #11
    //   124: istore #10
    //   126: aload_0
    //   127: getfield mOptimizationLevel : I
    //   130: iconst_2
    //   131: if_icmpne -> 322
    //   134: aload_0
    //   135: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   138: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   141: if_acmpeq -> 158
    //   144: iload #11
    //   146: istore #10
    //   148: aload_0
    //   149: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   152: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   155: if_acmpne -> 322
    //   158: aload_0
    //   159: aload_0
    //   160: getfield mChildren : Ljava/util/ArrayList;
    //   163: aload_0
    //   164: getfield flags : [Z
    //   167: invokevirtual findWrapSize : (Ljava/util/ArrayList;[Z)V
    //   170: aload_0
    //   171: getfield flags : [Z
    //   174: iconst_0
    //   175: baload
    //   176: istore #10
    //   178: iload #10
    //   180: istore #11
    //   182: iload #7
    //   184: ifle -> 221
    //   187: iload #10
    //   189: istore #11
    //   191: iload #8
    //   193: ifle -> 221
    //   196: aload_0
    //   197: getfield mWrapWidth : I
    //   200: iload #7
    //   202: if_icmpgt -> 218
    //   205: iload #10
    //   207: istore #11
    //   209: aload_0
    //   210: getfield mWrapHeight : I
    //   213: iload #8
    //   215: if_icmple -> 221
    //   218: iconst_0
    //   219: istore #11
    //   221: iload #11
    //   223: istore #10
    //   225: iload #11
    //   227: ifeq -> 322
    //   230: aload_0
    //   231: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   234: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   237: if_acmpne -> 272
    //   240: aload_0
    //   241: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   244: putfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   247: iload #7
    //   249: ifle -> 392
    //   252: iload #7
    //   254: aload_0
    //   255: getfield mWrapWidth : I
    //   258: if_icmpge -> 392
    //   261: aload_0
    //   262: iconst_1
    //   263: putfield mWidthMeasuredTooSmall : Z
    //   266: aload_0
    //   267: iload #7
    //   269: invokevirtual setWidth : (I)V
    //   272: iload #11
    //   274: istore #10
    //   276: aload_0
    //   277: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   280: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   283: if_acmpne -> 322
    //   286: aload_0
    //   287: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   290: putfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   293: iload #8
    //   295: ifle -> 410
    //   298: iload #8
    //   300: aload_0
    //   301: getfield mWrapHeight : I
    //   304: if_icmpge -> 410
    //   307: aload_0
    //   308: iconst_1
    //   309: putfield mHeightMeasuredTooSmall : Z
    //   312: aload_0
    //   313: iload #8
    //   315: invokevirtual setHeight : (I)V
    //   318: iload #11
    //   320: istore #10
    //   322: aload_0
    //   323: invokespecial resetChains : ()V
    //   326: aload_0
    //   327: getfield mChildren : Ljava/util/ArrayList;
    //   330: invokevirtual size : ()I
    //   333: istore #9
    //   335: iconst_0
    //   336: istore_1
    //   337: iload_1
    //   338: iload #9
    //   340: if_icmpge -> 432
    //   343: aload_0
    //   344: getfield mChildren : Ljava/util/ArrayList;
    //   347: iload_1
    //   348: invokevirtual get : (I)Ljava/lang/Object;
    //   351: checkcast android/support/constraint/solver/widgets/ConstraintWidget
    //   354: astore #18
    //   356: aload #18
    //   358: instanceof android/support/constraint/solver/widgets/WidgetContainer
    //   361: ifeq -> 372
    //   364: aload #18
    //   366: checkcast android/support/constraint/solver/widgets/WidgetContainer
    //   369: invokevirtual layout : ()V
    //   372: iload_1
    //   373: iconst_1
    //   374: iadd
    //   375: istore_1
    //   376: goto -> 337
    //   379: aload_0
    //   380: iconst_0
    //   381: putfield mX : I
    //   384: aload_0
    //   385: iconst_0
    //   386: putfield mY : I
    //   389: goto -> 107
    //   392: aload_0
    //   393: aload_0
    //   394: getfield mMinWidth : I
    //   397: aload_0
    //   398: getfield mWrapWidth : I
    //   401: invokestatic max : (II)I
    //   404: invokevirtual setWidth : (I)V
    //   407: goto -> 272
    //   410: aload_0
    //   411: aload_0
    //   412: getfield mMinHeight : I
    //   415: aload_0
    //   416: getfield mWrapHeight : I
    //   419: invokestatic max : (II)I
    //   422: invokevirtual setHeight : (I)V
    //   425: iload #11
    //   427: istore #10
    //   429: goto -> 322
    //   432: iconst_1
    //   433: istore #11
    //   435: iconst_0
    //   436: istore_1
    //   437: iload #11
    //   439: ifeq -> 1111
    //   442: iload_1
    //   443: iconst_1
    //   444: iadd
    //   445: istore #4
    //   447: iload #11
    //   449: istore #12
    //   451: aload_0
    //   452: getfield mSystem : Landroid/support/constraint/solver/LinearSystem;
    //   455: invokevirtual reset : ()V
    //   458: iload #11
    //   460: istore #12
    //   462: aload_0
    //   463: aload_0
    //   464: getfield mSystem : Landroid/support/constraint/solver/LinearSystem;
    //   467: ldc_w 2147483647
    //   470: invokevirtual addChildrenToSolver : (Landroid/support/constraint/solver/LinearSystem;I)Z
    //   473: istore #11
    //   475: iload #11
    //   477: istore #12
    //   479: iload #11
    //   481: ifeq -> 499
    //   484: iload #11
    //   486: istore #12
    //   488: aload_0
    //   489: getfield mSystem : Landroid/support/constraint/solver/LinearSystem;
    //   492: invokevirtual minimize : ()V
    //   495: iload #11
    //   497: istore #12
    //   499: iload #12
    //   501: ifeq -> 631
    //   504: aload_0
    //   505: aload_0
    //   506: getfield mSystem : Landroid/support/constraint/solver/LinearSystem;
    //   509: ldc_w 2147483647
    //   512: aload_0
    //   513: getfield flags : [Z
    //   516: invokevirtual updateChildrenFromSolver : (Landroid/support/constraint/solver/LinearSystem;I[Z)V
    //   519: iconst_0
    //   520: istore #13
    //   522: iconst_0
    //   523: istore #15
    //   525: iload #13
    //   527: istore #12
    //   529: iload #10
    //   531: istore #11
    //   533: iload #4
    //   535: bipush #8
    //   537: if_icmpge -> 856
    //   540: iload #13
    //   542: istore #12
    //   544: iload #10
    //   546: istore #11
    //   548: aload_0
    //   549: getfield flags : [Z
    //   552: iconst_2
    //   553: baload
    //   554: ifeq -> 856
    //   557: iconst_0
    //   558: istore_3
    //   559: iconst_0
    //   560: istore_1
    //   561: iconst_0
    //   562: istore_2
    //   563: iload_2
    //   564: iload #9
    //   566: if_icmpge -> 738
    //   569: aload_0
    //   570: getfield mChildren : Ljava/util/ArrayList;
    //   573: iload_2
    //   574: invokevirtual get : (I)Ljava/lang/Object;
    //   577: checkcast android/support/constraint/solver/widgets/ConstraintWidget
    //   580: astore #18
    //   582: iload_3
    //   583: aload #18
    //   585: getfield mX : I
    //   588: aload #18
    //   590: invokevirtual getWidth : ()I
    //   593: iadd
    //   594: invokestatic max : (II)I
    //   597: istore_3
    //   598: iload_1
    //   599: aload #18
    //   601: getfield mY : I
    //   604: aload #18
    //   606: invokevirtual getHeight : ()I
    //   609: iadd
    //   610: invokestatic max : (II)I
    //   613: istore_1
    //   614: iload_2
    //   615: iconst_1
    //   616: iadd
    //   617: istore_2
    //   618: goto -> 563
    //   621: astore #18
    //   623: aload #18
    //   625: invokevirtual printStackTrace : ()V
    //   628: goto -> 499
    //   631: aload_0
    //   632: aload_0
    //   633: getfield mSystem : Landroid/support/constraint/solver/LinearSystem;
    //   636: ldc_w 2147483647
    //   639: invokevirtual updateFromSolver : (Landroid/support/constraint/solver/LinearSystem;I)V
    //   642: iconst_0
    //   643: istore_1
    //   644: iload_1
    //   645: iload #9
    //   647: if_icmpge -> 519
    //   650: aload_0
    //   651: getfield mChildren : Ljava/util/ArrayList;
    //   654: iload_1
    //   655: invokevirtual get : (I)Ljava/lang/Object;
    //   658: checkcast android/support/constraint/solver/widgets/ConstraintWidget
    //   661: astore #18
    //   663: aload #18
    //   665: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   668: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   671: if_acmpne -> 697
    //   674: aload #18
    //   676: invokevirtual getWidth : ()I
    //   679: aload #18
    //   681: invokevirtual getWrapWidth : ()I
    //   684: if_icmpge -> 697
    //   687: aload_0
    //   688: getfield flags : [Z
    //   691: iconst_2
    //   692: iconst_1
    //   693: bastore
    //   694: goto -> 519
    //   697: aload #18
    //   699: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   702: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   705: if_acmpne -> 731
    //   708: aload #18
    //   710: invokevirtual getHeight : ()I
    //   713: aload #18
    //   715: invokevirtual getWrapHeight : ()I
    //   718: if_icmpge -> 731
    //   721: aload_0
    //   722: getfield flags : [Z
    //   725: iconst_2
    //   726: iconst_1
    //   727: bastore
    //   728: goto -> 519
    //   731: iload_1
    //   732: iconst_1
    //   733: iadd
    //   734: istore_1
    //   735: goto -> 644
    //   738: aload_0
    //   739: getfield mMinWidth : I
    //   742: iload_3
    //   743: invokestatic max : (II)I
    //   746: istore_2
    //   747: aload_0
    //   748: getfield mMinHeight : I
    //   751: iload_1
    //   752: invokestatic max : (II)I
    //   755: istore_1
    //   756: iload #15
    //   758: istore #14
    //   760: iload #10
    //   762: istore #13
    //   764: aload #17
    //   766: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   769: if_acmpne -> 806
    //   772: iload #15
    //   774: istore #14
    //   776: iload #10
    //   778: istore #13
    //   780: aload_0
    //   781: invokevirtual getWidth : ()I
    //   784: iload_2
    //   785: if_icmpge -> 806
    //   788: aload_0
    //   789: iload_2
    //   790: invokevirtual setWidth : (I)V
    //   793: aload_0
    //   794: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   797: putfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   800: iconst_1
    //   801: istore #13
    //   803: iconst_1
    //   804: istore #14
    //   806: iload #14
    //   808: istore #12
    //   810: iload #13
    //   812: istore #11
    //   814: aload #16
    //   816: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   819: if_acmpne -> 856
    //   822: iload #14
    //   824: istore #12
    //   826: iload #13
    //   828: istore #11
    //   830: aload_0
    //   831: invokevirtual getHeight : ()I
    //   834: iload_1
    //   835: if_icmpge -> 856
    //   838: aload_0
    //   839: iload_1
    //   840: invokevirtual setHeight : (I)V
    //   843: aload_0
    //   844: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   847: putfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   850: iconst_1
    //   851: istore #11
    //   853: iconst_1
    //   854: istore #12
    //   856: aload_0
    //   857: getfield mMinWidth : I
    //   860: aload_0
    //   861: invokevirtual getWidth : ()I
    //   864: invokestatic max : (II)I
    //   867: istore_1
    //   868: iload_1
    //   869: aload_0
    //   870: invokevirtual getWidth : ()I
    //   873: if_icmple -> 894
    //   876: aload_0
    //   877: iload_1
    //   878: invokevirtual setWidth : (I)V
    //   881: aload_0
    //   882: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   885: putfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   888: iconst_1
    //   889: istore #11
    //   891: iconst_1
    //   892: istore #12
    //   894: aload_0
    //   895: getfield mMinHeight : I
    //   898: aload_0
    //   899: invokevirtual getHeight : ()I
    //   902: invokestatic max : (II)I
    //   905: istore_1
    //   906: iload #11
    //   908: istore #13
    //   910: iload_1
    //   911: aload_0
    //   912: invokevirtual getHeight : ()I
    //   915: if_icmple -> 936
    //   918: aload_0
    //   919: iload_1
    //   920: invokevirtual setHeight : (I)V
    //   923: aload_0
    //   924: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   927: putfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   930: iconst_1
    //   931: istore #13
    //   933: iconst_1
    //   934: istore #12
    //   936: iload #4
    //   938: istore_1
    //   939: iload #12
    //   941: istore #11
    //   943: iload #13
    //   945: istore #10
    //   947: iload #13
    //   949: ifne -> 437
    //   952: iload #12
    //   954: istore #15
    //   956: iload #13
    //   958: istore #14
    //   960: aload_0
    //   961: getfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   964: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   967: if_acmpne -> 1024
    //   970: iload #12
    //   972: istore #15
    //   974: iload #13
    //   976: istore #14
    //   978: iload #7
    //   980: ifle -> 1024
    //   983: iload #12
    //   985: istore #15
    //   987: iload #13
    //   989: istore #14
    //   991: aload_0
    //   992: invokevirtual getWidth : ()I
    //   995: iload #7
    //   997: if_icmple -> 1024
    //   1000: aload_0
    //   1001: iconst_1
    //   1002: putfield mWidthMeasuredTooSmall : Z
    //   1005: iconst_1
    //   1006: istore #14
    //   1008: aload_0
    //   1009: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1012: putfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1015: aload_0
    //   1016: iload #7
    //   1018: invokevirtual setWidth : (I)V
    //   1021: iconst_1
    //   1022: istore #15
    //   1024: iload #4
    //   1026: istore_1
    //   1027: iload #15
    //   1029: istore #11
    //   1031: iload #14
    //   1033: istore #10
    //   1035: aload_0
    //   1036: getfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1039: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1042: if_acmpne -> 437
    //   1045: iload #4
    //   1047: istore_1
    //   1048: iload #15
    //   1050: istore #11
    //   1052: iload #14
    //   1054: istore #10
    //   1056: iload #8
    //   1058: ifle -> 437
    //   1061: iload #4
    //   1063: istore_1
    //   1064: iload #15
    //   1066: istore #11
    //   1068: iload #14
    //   1070: istore #10
    //   1072: aload_0
    //   1073: invokevirtual getHeight : ()I
    //   1076: iload #8
    //   1078: if_icmple -> 437
    //   1081: aload_0
    //   1082: iconst_1
    //   1083: putfield mHeightMeasuredTooSmall : Z
    //   1086: iconst_1
    //   1087: istore #10
    //   1089: aload_0
    //   1090: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1093: putfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1096: aload_0
    //   1097: iload #8
    //   1099: invokevirtual setHeight : (I)V
    //   1102: iconst_1
    //   1103: istore #11
    //   1105: iload #4
    //   1107: istore_1
    //   1108: goto -> 437
    //   1111: aload_0
    //   1112: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1115: ifnull -> 1221
    //   1118: aload_0
    //   1119: getfield mMinWidth : I
    //   1122: aload_0
    //   1123: invokevirtual getWidth : ()I
    //   1126: invokestatic max : (II)I
    //   1129: istore_1
    //   1130: aload_0
    //   1131: getfield mMinHeight : I
    //   1134: aload_0
    //   1135: invokevirtual getHeight : ()I
    //   1138: invokestatic max : (II)I
    //   1141: istore_2
    //   1142: aload_0
    //   1143: getfield mSnapshot : Landroid/support/constraint/solver/widgets/Snapshot;
    //   1146: aload_0
    //   1147: invokevirtual applyTo : (Landroid/support/constraint/solver/widgets/ConstraintWidget;)V
    //   1150: aload_0
    //   1151: aload_0
    //   1152: getfield mPaddingLeft : I
    //   1155: iload_1
    //   1156: iadd
    //   1157: aload_0
    //   1158: getfield mPaddingRight : I
    //   1161: iadd
    //   1162: invokevirtual setWidth : (I)V
    //   1165: aload_0
    //   1166: aload_0
    //   1167: getfield mPaddingTop : I
    //   1170: iload_2
    //   1171: iadd
    //   1172: aload_0
    //   1173: getfield mPaddingBottom : I
    //   1176: iadd
    //   1177: invokevirtual setHeight : (I)V
    //   1180: iload #10
    //   1182: ifeq -> 1197
    //   1185: aload_0
    //   1186: aload #17
    //   1188: putfield mHorizontalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1191: aload_0
    //   1192: aload #16
    //   1194: putfield mVerticalDimensionBehaviour : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1197: aload_0
    //   1198: aload_0
    //   1199: getfield mSystem : Landroid/support/constraint/solver/LinearSystem;
    //   1202: invokevirtual getCache : ()Landroid/support/constraint/solver/Cache;
    //   1205: invokevirtual resetSolverVariables : (Landroid/support/constraint/solver/Cache;)V
    //   1208: aload_0
    //   1209: aload_0
    //   1210: invokevirtual getRootConstraintContainer : ()Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   1213: if_acmpne -> 1220
    //   1216: aload_0
    //   1217: invokevirtual updateDrawPosition : ()V
    //   1220: return
    //   1221: aload_0
    //   1222: iload #5
    //   1224: putfield mX : I
    //   1227: aload_0
    //   1228: iload #6
    //   1230: putfield mY : I
    //   1233: goto -> 1180
    // Exception table:
    //   from	to	target	type
    //   451	458	621	java/lang/Exception
    //   462	475	621	java/lang/Exception
    //   488	495	621	java/lang/Exception
  }
  
  public int layoutFindGroups() {
    ConstraintAnchor.Type[] arrayOfType = new ConstraintAnchor.Type[5];
    arrayOfType[0] = ConstraintAnchor.Type.LEFT;
    arrayOfType[1] = ConstraintAnchor.Type.RIGHT;
    arrayOfType[2] = ConstraintAnchor.Type.TOP;
    arrayOfType[3] = ConstraintAnchor.Type.BASELINE;
    arrayOfType[4] = ConstraintAnchor.Type.BOTTOM;
    int i = 1;
    int i1 = this.mChildren.size();
    int k = 0;
    while (k < i1) {
      int i2;
      ConstraintWidget constraintWidget = this.mChildren.get(k);
      ConstraintAnchor constraintAnchor2 = constraintWidget.mLeft;
      if (constraintAnchor2.mTarget != null) {
        i2 = i;
        if (setGroup(constraintAnchor2, i) == i)
          i2 = i + 1; 
      } else {
        constraintAnchor2.mGroup = Integer.MAX_VALUE;
        i2 = i;
      } 
      constraintAnchor2 = constraintWidget.mTop;
      if (constraintAnchor2.mTarget != null) {
        i = i2;
        if (setGroup(constraintAnchor2, i2) == i2)
          i = i2 + 1; 
      } else {
        constraintAnchor2.mGroup = Integer.MAX_VALUE;
        i = i2;
      } 
      constraintAnchor2 = constraintWidget.mRight;
      if (constraintAnchor2.mTarget != null) {
        i2 = i;
        if (setGroup(constraintAnchor2, i) == i)
          i2 = i + 1; 
      } else {
        constraintAnchor2.mGroup = Integer.MAX_VALUE;
        i2 = i;
      } 
      constraintAnchor2 = constraintWidget.mBottom;
      if (constraintAnchor2.mTarget != null) {
        i = i2;
        if (setGroup(constraintAnchor2, i2) == i2)
          i = i2 + 1; 
      } else {
        constraintAnchor2.mGroup = Integer.MAX_VALUE;
        i = i2;
      } 
      ConstraintAnchor constraintAnchor1 = constraintWidget.mBaseline;
      if (constraintAnchor1.mTarget != null) {
        i2 = i;
        if (setGroup(constraintAnchor1, i) == i)
          i2 = i + 1; 
      } else {
        constraintAnchor1.mGroup = Integer.MAX_VALUE;
        i2 = i;
      } 
      k++;
      i = i2;
    } 
    int m = 1;
    int n = 0;
    int j = 0;
    label126: while (m) {
      k = 0;
      int i3 = n + 1;
      int i2 = 0;
      i = j;
      while (true) {
        n = i3;
        j = i;
        m = k;
        if (i2 < i1) {
          ConstraintWidget constraintWidget = this.mChildren.get(i2);
          for (n = 0; n < arrayOfType.length; n++) {
            ConstraintAnchor.Type type = arrayOfType[n];
            ConstraintAnchor constraintAnchor1 = null;
            switch (type) {
              default:
                constraintAnchor2 = constraintAnchor1.mTarget;
              case LEFT:
                constraintAnchor1 = constraintWidget.mLeft;
              case TOP:
                constraintAnchor1 = constraintWidget.mTop;
              case RIGHT:
                constraintAnchor1 = constraintWidget.mRight;
              case BOTTOM:
                constraintAnchor1 = constraintWidget.mBottom;
              case BASELINE:
                constraintAnchor1 = constraintWidget.mBaseline;
            } 
            j = i;
            m = k;
            if (constraintAnchor2.mOwner.getParent() != null) {
              j = i;
              m = k;
              if (constraintAnchor2.mGroup != constraintAnchor1.mGroup) {
                if (constraintAnchor1.mGroup > constraintAnchor2.mGroup) {
                  j = constraintAnchor2.mGroup;
                } else {
                  j = constraintAnchor1.mGroup;
                } 
                constraintAnchor1.mGroup = j;
                constraintAnchor2.mGroup = j;
                j = i + 1;
                m = 1;
              } 
            } 
            ConstraintAnchor constraintAnchor2 = constraintAnchor2.getOpposite();
            i = j;
            k = m;
            if (constraintAnchor2 != null) {
              i = j;
              k = m;
              if (constraintAnchor2.mGroup != constraintAnchor1.mGroup) {
                if (constraintAnchor1.mGroup > constraintAnchor2.mGroup) {
                  i = constraintAnchor2.mGroup;
                } else {
                  i = constraintAnchor1.mGroup;
                } 
                constraintAnchor1.mGroup = i;
                constraintAnchor2.mGroup = i;
                i = j + 1;
                k = 1;
              } 
            } 
            continue;
          } 
          i2++;
          continue;
        } 
        continue label126;
      } 
    } 
    int[] arrayOfInt = new int[this.mChildren.size() * arrayOfType.length + 1];
    Arrays.fill(arrayOfInt, -1);
    k = 0;
    i = 0;
    while (true) {
      if (k < i1) {
        ConstraintWidget constraintWidget = this.mChildren.get(k);
        ConstraintAnchor constraintAnchor2 = constraintWidget.mLeft;
        if (constraintAnchor2.mGroup != Integer.MAX_VALUE) {
          m = constraintAnchor2.mGroup;
          if (arrayOfInt[m] == -1) {
            j = i + 1;
            arrayOfInt[m] = i;
          } else {
            j = i;
          } 
          constraintAnchor2.mGroup = arrayOfInt[m];
        } else {
          j = i;
        } 
        constraintAnchor2 = constraintWidget.mTop;
        i = j;
        if (constraintAnchor2.mGroup != Integer.MAX_VALUE) {
          m = constraintAnchor2.mGroup;
          i = j;
          if (arrayOfInt[m] == -1) {
            arrayOfInt[m] = j;
            i = j + 1;
          } 
          constraintAnchor2.mGroup = arrayOfInt[m];
        } 
        constraintAnchor2 = constraintWidget.mRight;
        j = i;
        if (constraintAnchor2.mGroup != Integer.MAX_VALUE) {
          m = constraintAnchor2.mGroup;
          j = i;
          if (arrayOfInt[m] == -1) {
            arrayOfInt[m] = i;
            j = i + 1;
          } 
          constraintAnchor2.mGroup = arrayOfInt[m];
        } 
        constraintAnchor2 = constraintWidget.mBottom;
        i = j;
        if (constraintAnchor2.mGroup != Integer.MAX_VALUE) {
          m = constraintAnchor2.mGroup;
          i = j;
          if (arrayOfInt[m] == -1) {
            arrayOfInt[m] = j;
            i = j + 1;
          } 
          constraintAnchor2.mGroup = arrayOfInt[m];
        } 
        ConstraintAnchor constraintAnchor1 = constraintWidget.mBaseline;
        j = i;
        if (constraintAnchor1.mGroup != Integer.MAX_VALUE) {
          m = constraintAnchor1.mGroup;
          j = i;
          if (arrayOfInt[m] == -1) {
            arrayOfInt[m] = i;
            j = i + 1;
          } 
          constraintAnchor1.mGroup = arrayOfInt[m];
        } 
        k++;
        i = j;
        continue;
      } 
      return i;
    } 
  }
  
  public int layoutFindGroupsSimple() {
    int j = this.mChildren.size();
    for (int i = 0; i < j; i++) {
      ConstraintWidget constraintWidget = this.mChildren.get(i);
      constraintWidget.mLeft.mGroup = 0;
      constraintWidget.mRight.mGroup = 0;
      constraintWidget.mTop.mGroup = 1;
      constraintWidget.mBottom.mGroup = 1;
      constraintWidget.mBaseline.mGroup = 1;
    } 
    return 2;
  }
  
  public void layoutWithGroup(int paramInt) {
    int j = this.mX;
    int k = this.mY;
    if (this.mParent != null) {
      if (this.mSnapshot == null)
        this.mSnapshot = new Snapshot(this); 
      this.mSnapshot.updateFrom(this);
      this.mX = 0;
      this.mY = 0;
      resetAnchors();
      resetSolverVariables(this.mSystem.getCache());
    } else {
      this.mX = 0;
      this.mY = 0;
    } 
    int m = this.mChildren.size();
    int i;
    for (i = 0; i < m; i++) {
      ConstraintWidget constraintWidget = this.mChildren.get(i);
      if (constraintWidget instanceof WidgetContainer)
        ((WidgetContainer)constraintWidget).layout(); 
    } 
    this.mLeft.mGroup = 0;
    this.mRight.mGroup = 0;
    this.mTop.mGroup = 1;
    this.mBottom.mGroup = 1;
    this.mSystem.reset();
    for (i = 0; i < paramInt; i++) {
      try {
        addToSolver(this.mSystem, i);
        this.mSystem.minimize();
        updateFromSolver(this.mSystem, i);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      updateFromSolver(this.mSystem, -2);
    } 
    if (this.mParent != null) {
      paramInt = getWidth();
      i = getHeight();
      this.mSnapshot.applyTo(this);
      setWidth(paramInt);
      setHeight(i);
    } else {
      this.mX = j;
      this.mY = k;
    } 
    if (this == getRootConstraintContainer())
      updateDrawPosition(); 
  }
  
  public void reset() {
    this.mSystem.reset();
    this.mPaddingLeft = 0;
    this.mPaddingRight = 0;
    this.mPaddingTop = 0;
    this.mPaddingBottom = 0;
    super.reset();
  }
  
  public void setOptimizationLevel(int paramInt) {
    this.mOptimizationLevel = paramInt;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mPaddingLeft = paramInt1;
    this.mPaddingTop = paramInt2;
    this.mPaddingRight = paramInt3;
    this.mPaddingBottom = paramInt4;
  }
  
  public void updateChildrenFromSolver(LinearSystem paramLinearSystem, int paramInt, boolean[] paramArrayOfboolean) {
    paramArrayOfboolean[2] = false;
    updateFromSolver(paramLinearSystem, paramInt);
    int j = this.mChildren.size();
    int i;
    for (i = 0; i < j; i++) {
      ConstraintWidget constraintWidget = this.mChildren.get(i);
      constraintWidget.updateFromSolver(paramLinearSystem, paramInt);
      if (constraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth())
        paramArrayOfboolean[2] = true; 
      if (constraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight())
        paramArrayOfboolean[2] = true; 
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\solver\widgets\ConstraintWidgetContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */