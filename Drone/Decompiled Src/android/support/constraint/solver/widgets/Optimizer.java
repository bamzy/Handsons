package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;

public class Optimizer {
  static void applyDirectResolutionHorizontalChain(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt, ConstraintWidget paramConstraintWidget) {
    Object object1;
    float f2;
    Object object2;
    Object object3;
    int j;
    boolean bool1 = false;
    Object object4 = null;
    boolean bool2 = false;
    float f3 = 0.0F;
    ConstraintWidget constraintWidget = paramConstraintWidget;
    while (constraintWidget != null) {
      float f;
      int k;
      int m;
      ConstraintWidget constraintWidget1;
      if (constraintWidget.getVisibility() == 8) {
        k = 1;
      } else {
        k = 0;
      } 
      Object object7 = object3;
      Object object5 = object1;
      Object object6 = object2;
      if (!k) {
        m = object3 + 1;
        if (constraintWidget.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          int i1 = constraintWidget.getWidth();
          if (constraintWidget.mLeft.mTarget != null) {
            n = constraintWidget.mLeft.getMargin();
          } else {
            n = 0;
          } 
          if (constraintWidget.mRight.mTarget != null) {
            k = constraintWidget.mRight.getMargin();
          } else {
            k = 0;
          } 
          int n = object2 + i1 + n + k;
          object5 = object1;
        } else {
          f = object1 + constraintWidget.mHorizontalWeight;
          object6 = object2;
        } 
      } 
      ConstraintWidget constraintWidget2 = constraintWidget;
      if (constraintWidget.mRight.mTarget != null) {
        constraintWidget1 = constraintWidget.mRight.mTarget.mOwner;
      } else {
        constraintWidget1 = null;
      } 
      j = m;
      object4 = constraintWidget2;
      f2 = f;
      object2 = object6;
      constraintWidget = constraintWidget1;
      if (constraintWidget1 != null) {
        if (constraintWidget1.mLeft.mTarget != null) {
          j = m;
          object4 = constraintWidget2;
          f2 = f;
          object2 = object6;
          constraintWidget = constraintWidget1;
          if (constraintWidget1.mLeft.mTarget != null) {
            j = m;
            object4 = constraintWidget2;
            f2 = f;
            object2 = object6;
            constraintWidget = constraintWidget1;
            if (constraintWidget1.mLeft.mTarget.mOwner != constraintWidget2)
              continue; 
          } 
          continue;
        } 
        continue;
      } 
      continue;
      constraintWidget = null;
      object3 = SYNTHETIC_LOCAL_VARIABLE_13;
      object4 = SYNTHETIC_LOCAL_VARIABLE_16;
      object1 = SYNTHETIC_LOCAL_VARIABLE_4;
      object2 = SYNTHETIC_LOCAL_VARIABLE_9;
    } 
    int i = 0;
    if (object4 != null) {
      byte b;
      if (((ConstraintWidget)object4).mRight.mTarget != null) {
        b = ((ConstraintWidget)object4).mRight.mTarget.mOwner.getX();
      } else {
        b = 0;
      } 
      i = b;
      if (((ConstraintWidget)object4).mRight.mTarget != null) {
        i = b;
        if (((ConstraintWidget)object4).mRight.mTarget.mOwner == paramConstraintWidgetContainer)
          i = paramConstraintWidgetContainer.getRight(); 
      } 
    } 
    float f5 = (i - 0) - object2;
    float f4 = f5 / (j + 1);
    float f1 = 0.0F;
    if (paramInt == 0) {
      f1 = f4;
    } else {
      f4 = f5 / paramInt;
    } 
    while (paramConstraintWidget != null) {
      float f;
      boolean bool;
      if (paramConstraintWidget.mLeft.mTarget != null) {
        bool = paramConstraintWidget.mLeft.getMargin();
      } else {
        bool = false;
      } 
      if (paramConstraintWidget.mRight.mTarget != null) {
        i = paramConstraintWidget.mRight.getMargin();
      } else {
        i = 0;
      } 
      if (paramConstraintWidget.getVisibility() != 8) {
        f1 += bool;
        paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, (int)(0.5F + f1));
        if (paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          if (f2 == 0.0F) {
            f1 += f4 - bool - i;
          } else {
            f1 += paramConstraintWidget.mHorizontalWeight * f5 / f2 - bool - i;
          } 
        } else {
          f1 += paramConstraintWidget.getWidth();
        } 
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, (int)(0.5F + f1));
        f = f1;
        if (paramInt == 0)
          f = f1 + f4; 
        f += i;
      } else {
        f = f1 - f4 / 2.0F;
        paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, (int)(0.5F + f));
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, (int)(0.5F + f));
        f = f1;
      } 
      if (paramConstraintWidget.mRight.mTarget != null) {
        constraintWidget = paramConstraintWidget.mRight.mTarget.mOwner;
      } else {
        constraintWidget = null;
      } 
      ConstraintWidget constraintWidget1 = constraintWidget;
      if (constraintWidget != null) {
        constraintWidget1 = constraintWidget;
        if (constraintWidget.mLeft.mTarget != null) {
          constraintWidget1 = constraintWidget;
          if (constraintWidget.mLeft.mTarget.mOwner != paramConstraintWidget)
            constraintWidget1 = null; 
        } 
      } 
      f1 = f;
      paramConstraintWidget = constraintWidget1;
      if (constraintWidget1 == paramConstraintWidgetContainer) {
        paramConstraintWidget = null;
        f1 = f;
      } 
    } 
  }
  
  static void applyDirectResolutionVerticalChain(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt, ConstraintWidget paramConstraintWidget) {
    Object object1;
    float f2;
    Object object2;
    Object object3;
    int j;
    boolean bool1 = false;
    Object object4 = null;
    boolean bool2 = false;
    float f3 = 0.0F;
    ConstraintWidget constraintWidget = paramConstraintWidget;
    while (constraintWidget != null) {
      float f;
      int k;
      int m;
      ConstraintWidget constraintWidget1;
      if (constraintWidget.getVisibility() == 8) {
        k = 1;
      } else {
        k = 0;
      } 
      Object object7 = object3;
      Object object5 = object1;
      Object object6 = object2;
      if (!k) {
        m = object3 + 1;
        if (constraintWidget.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          int i1 = constraintWidget.getHeight();
          if (constraintWidget.mTop.mTarget != null) {
            n = constraintWidget.mTop.getMargin();
          } else {
            n = 0;
          } 
          if (constraintWidget.mBottom.mTarget != null) {
            k = constraintWidget.mBottom.getMargin();
          } else {
            k = 0;
          } 
          int n = object2 + i1 + n + k;
          object5 = object1;
        } else {
          f = object1 + constraintWidget.mVerticalWeight;
          object6 = object2;
        } 
      } 
      ConstraintWidget constraintWidget2 = constraintWidget;
      if (constraintWidget.mBottom.mTarget != null) {
        constraintWidget1 = constraintWidget.mBottom.mTarget.mOwner;
      } else {
        constraintWidget1 = null;
      } 
      j = m;
      object4 = constraintWidget2;
      f2 = f;
      object2 = object6;
      constraintWidget = constraintWidget1;
      if (constraintWidget1 != null) {
        if (constraintWidget1.mTop.mTarget != null) {
          j = m;
          object4 = constraintWidget2;
          f2 = f;
          object2 = object6;
          constraintWidget = constraintWidget1;
          if (constraintWidget1.mTop.mTarget != null) {
            j = m;
            object4 = constraintWidget2;
            f2 = f;
            object2 = object6;
            constraintWidget = constraintWidget1;
            if (constraintWidget1.mTop.mTarget.mOwner != constraintWidget2)
              continue; 
          } 
          continue;
        } 
        continue;
      } 
      continue;
      constraintWidget = null;
      object3 = SYNTHETIC_LOCAL_VARIABLE_13;
      object4 = SYNTHETIC_LOCAL_VARIABLE_16;
      object1 = SYNTHETIC_LOCAL_VARIABLE_4;
      object2 = SYNTHETIC_LOCAL_VARIABLE_9;
    } 
    int i = 0;
    if (object4 != null) {
      byte b;
      if (((ConstraintWidget)object4).mBottom.mTarget != null) {
        b = ((ConstraintWidget)object4).mBottom.mTarget.mOwner.getX();
      } else {
        b = 0;
      } 
      i = b;
      if (((ConstraintWidget)object4).mBottom.mTarget != null) {
        i = b;
        if (((ConstraintWidget)object4).mBottom.mTarget.mOwner == paramConstraintWidgetContainer)
          i = paramConstraintWidgetContainer.getBottom(); 
      } 
    } 
    float f5 = (i - 0) - object2;
    float f4 = f5 / (j + 1);
    float f1 = 0.0F;
    if (paramInt == 0) {
      f1 = f4;
    } else {
      f4 = f5 / paramInt;
    } 
    while (paramConstraintWidget != null) {
      float f;
      boolean bool;
      if (paramConstraintWidget.mTop.mTarget != null) {
        bool = paramConstraintWidget.mTop.getMargin();
      } else {
        bool = false;
      } 
      if (paramConstraintWidget.mBottom.mTarget != null) {
        i = paramConstraintWidget.mBottom.getMargin();
      } else {
        i = 0;
      } 
      if (paramConstraintWidget.getVisibility() != 8) {
        f1 += bool;
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, (int)(0.5F + f1));
        if (paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          if (f2 == 0.0F) {
            f1 += f4 - bool - i;
          } else {
            f1 += paramConstraintWidget.mVerticalWeight * f5 / f2 - bool - i;
          } 
        } else {
          f1 += paramConstraintWidget.getHeight();
        } 
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, (int)(0.5F + f1));
        f = f1;
        if (paramInt == 0)
          f = f1 + f4; 
        f += i;
      } else {
        f = f1 - f4 / 2.0F;
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, (int)(0.5F + f));
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, (int)(0.5F + f));
        f = f1;
      } 
      if (paramConstraintWidget.mBottom.mTarget != null) {
        constraintWidget = paramConstraintWidget.mBottom.mTarget.mOwner;
      } else {
        constraintWidget = null;
      } 
      ConstraintWidget constraintWidget1 = constraintWidget;
      if (constraintWidget != null) {
        constraintWidget1 = constraintWidget;
        if (constraintWidget.mTop.mTarget != null) {
          constraintWidget1 = constraintWidget;
          if (constraintWidget.mTop.mTarget.mOwner != paramConstraintWidget)
            constraintWidget1 = null; 
        } 
      } 
      f1 = f;
      paramConstraintWidget = constraintWidget1;
      if (constraintWidget1 == paramConstraintWidgetContainer) {
        paramConstraintWidget = null;
        f1 = f;
      } 
    } 
  }
  
  static void checkHorizontalSimpleDependency(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget) {
    SolverVariable solverVariable;
    int i;
    int j;
    if (paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      paramConstraintWidget.mHorizontalResolution = 1;
      return;
    } 
    if (paramConstraintWidgetContainer.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      i = paramConstraintWidget.mLeft.mMargin;
      j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.mMargin;
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.setHorizontalDimension(i, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      return;
    } 
    if (paramConstraintWidget.mLeft.mTarget != null && paramConstraintWidget.mRight.mTarget != null) {
      if (paramConstraintWidget.mLeft.mTarget.mOwner == paramConstraintWidgetContainer && paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidgetContainer) {
        i = paramConstraintWidget.mLeft.getMargin();
        j = paramConstraintWidget.mRight.getMargin();
        if (paramConstraintWidgetContainer.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          j = paramConstraintWidgetContainer.getWidth() - j;
        } else {
          int k = paramConstraintWidget.getWidth();
          i += (int)((paramConstraintWidgetContainer.getWidth() - i - j - k) * paramConstraintWidget.mHorizontalBiasPercent + 0.5F);
          j = i + paramConstraintWidget.getWidth();
        } 
        paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
        paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
        paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
        paramConstraintWidget.mHorizontalResolution = 2;
        paramConstraintWidget.setHorizontalDimension(i, j);
        return;
      } 
      paramConstraintWidget.mHorizontalResolution = 1;
      return;
    } 
    if (paramConstraintWidget.mLeft.mTarget != null && paramConstraintWidget.mLeft.mTarget.mOwner == paramConstraintWidgetContainer) {
      i = paramConstraintWidget.mLeft.getMargin();
      j = i + paramConstraintWidget.getWidth();
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(i, j);
      return;
    } 
    if (paramConstraintWidget.mRight.mTarget != null && paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidgetContainer) {
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      i = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.getMargin();
      j = i - paramConstraintWidget.getWidth();
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, j);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(j, i);
      return;
    } 
    if (paramConstraintWidget.mLeft.mTarget != null && paramConstraintWidget.mLeft.mTarget.mOwner.mHorizontalResolution == 2) {
      solverVariable = paramConstraintWidget.mLeft.mTarget.mSolverVariable;
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      i = (int)(solverVariable.computedValue + paramConstraintWidget.mLeft.getMargin() + 0.5F);
      j = i + paramConstraintWidget.getWidth();
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(i, j);
      return;
    } 
    if (paramConstraintWidget.mRight.mTarget != null && paramConstraintWidget.mRight.mTarget.mOwner.mHorizontalResolution == 2) {
      solverVariable = paramConstraintWidget.mRight.mTarget.mSolverVariable;
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      i = (int)(solverVariable.computedValue - paramConstraintWidget.mRight.getMargin() + 0.5F);
      j = i - paramConstraintWidget.getWidth();
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, j);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(j, i);
      return;
    } 
    if (paramConstraintWidget.mLeft.mTarget != null) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramConstraintWidget.mRight.mTarget != null) {
      j = 1;
    } else {
      j = 0;
    } 
    if (!i && !j) {
      if (paramConstraintWidget instanceof Guideline) {
        Guideline guideline = (Guideline)paramConstraintWidget;
        if (guideline.getOrientation() == 1) {
          float f;
          paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
          paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
          if (guideline.getRelativeBegin() != -1) {
            f = guideline.getRelativeBegin();
          } else if (guideline.getRelativeEnd() != -1) {
            f = (solverVariable.getWidth() - guideline.getRelativeEnd());
          } else {
            f = solverVariable.getWidth() * guideline.getRelativePercent();
          } 
          i = (int)(0.5F + f);
          paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
          paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i);
          paramConstraintWidget.mHorizontalResolution = 2;
          paramConstraintWidget.mVerticalResolution = 2;
          paramConstraintWidget.setHorizontalDimension(i, i);
          paramConstraintWidget.setVerticalDimension(0, solverVariable.getHeight());
          return;
        } 
        return;
      } 
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      i = paramConstraintWidget.getX();
      j = paramConstraintWidget.getWidth();
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i + j);
      paramConstraintWidget.mHorizontalResolution = 2;
      return;
    } 
  }
  
  static void checkMatchParent(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget) {
    if (paramConstraintWidgetContainer.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      int i = paramConstraintWidget.mLeft.mMargin;
      int j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.mMargin;
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.setHorizontalDimension(i, j);
      paramConstraintWidget.mHorizontalResolution = 2;
    } 
    if (paramConstraintWidgetContainer.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      int i = paramConstraintWidget.mTop.mMargin;
      int j = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.mMargin;
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      if (paramConstraintWidget.mBaselineDistance > 0 || paramConstraintWidget.getVisibility() == 8) {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      } 
      paramConstraintWidget.setVerticalDimension(i, j);
      paramConstraintWidget.mVerticalResolution = 2;
    } 
  }
  
  static void checkVerticalSimpleDependency(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget) {
    SolverVariable solverVariable;
    int i;
    int j;
    boolean bool;
    if (paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      paramConstraintWidget.mVerticalResolution = 1;
      return;
    } 
    if (paramConstraintWidgetContainer.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = paramConstraintWidget.mTop.mMargin;
      j = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.mMargin;
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      if (paramConstraintWidget.mBaselineDistance > 0 || paramConstraintWidget.getVisibility() == 8) {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      } 
      paramConstraintWidget.setVerticalDimension(i, j);
      paramConstraintWidget.mVerticalResolution = 2;
      return;
    } 
    if (paramConstraintWidget.mTop.mTarget != null && paramConstraintWidget.mBottom.mTarget != null) {
      if (paramConstraintWidget.mTop.mTarget.mOwner == paramConstraintWidgetContainer && paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidgetContainer) {
        j = paramConstraintWidget.mTop.getMargin();
        i = paramConstraintWidget.mBottom.getMargin();
        if (paramConstraintWidgetContainer.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          i = j + paramConstraintWidget.getHeight();
        } else {
          bool = paramConstraintWidget.getHeight();
          int k = paramConstraintWidgetContainer.getHeight();
          j = (int)(j + (k - j - i - bool) * paramConstraintWidget.mVerticalBiasPercent + 0.5F);
          i = j + paramConstraintWidget.getHeight();
        } 
        paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
        paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, j);
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
        if (paramConstraintWidget.mBaselineDistance > 0 || paramConstraintWidget.getVisibility() == 8) {
          paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
          paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + j);
        } 
        paramConstraintWidget.mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(j, i);
        return;
      } 
      paramConstraintWidget.mVerticalResolution = 1;
      return;
    } 
    if (paramConstraintWidget.mTop.mTarget != null && paramConstraintWidget.mTop.mTarget.mOwner == paramConstraintWidgetContainer) {
      i = paramConstraintWidget.mTop.getMargin();
      j = i + paramConstraintWidget.getHeight();
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      if (paramConstraintWidget.mBaselineDistance > 0 || paramConstraintWidget.getVisibility() == 8) {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      } 
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(i, j);
      return;
    } 
    if (paramConstraintWidget.mBottom.mTarget != null && paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidgetContainer) {
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.getMargin();
      j = i - paramConstraintWidget.getHeight();
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, j);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
      if (paramConstraintWidget.mBaselineDistance > 0 || paramConstraintWidget.getVisibility() == 8) {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + j);
      } 
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(j, i);
      return;
    } 
    if (paramConstraintWidget.mTop.mTarget != null && paramConstraintWidget.mTop.mTarget.mOwner.mVerticalResolution == 2) {
      solverVariable = paramConstraintWidget.mTop.mTarget.mSolverVariable;
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = (int)(solverVariable.computedValue + paramConstraintWidget.mTop.getMargin() + 0.5F);
      j = i + paramConstraintWidget.getHeight();
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      if (paramConstraintWidget.mBaselineDistance > 0 || paramConstraintWidget.getVisibility() == 8) {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      } 
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(i, j);
      return;
    } 
    if (paramConstraintWidget.mBottom.mTarget != null && paramConstraintWidget.mBottom.mTarget.mOwner.mVerticalResolution == 2) {
      solverVariable = paramConstraintWidget.mBottom.mTarget.mSolverVariable;
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = (int)(solverVariable.computedValue - paramConstraintWidget.mBottom.getMargin() + 0.5F);
      j = i - paramConstraintWidget.getHeight();
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, j);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
      if (paramConstraintWidget.mBaselineDistance > 0 || paramConstraintWidget.getVisibility() == 8) {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + j);
      } 
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(j, i);
      return;
    } 
    if (paramConstraintWidget.mBaseline.mTarget != null && paramConstraintWidget.mBaseline.mTarget.mOwner.mVerticalResolution == 2) {
      solverVariable = paramConstraintWidget.mBaseline.mTarget.mSolverVariable;
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = (int)(solverVariable.computedValue - paramConstraintWidget.mBaselineDistance + 0.5F);
      j = i + paramConstraintWidget.getHeight();
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
      paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(i, j);
      return;
    } 
    if (paramConstraintWidget.mBaseline.mTarget != null) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramConstraintWidget.mTop.mTarget != null) {
      j = 1;
    } else {
      j = 0;
    } 
    if (paramConstraintWidget.mBottom.mTarget != null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!i && !j && !bool) {
      if (paramConstraintWidget instanceof Guideline) {
        Guideline guideline = (Guideline)paramConstraintWidget;
        if (guideline.getOrientation() == 0) {
          float f;
          paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
          paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
          if (guideline.getRelativeBegin() != -1) {
            f = guideline.getRelativeBegin();
          } else if (guideline.getRelativeEnd() != -1) {
            f = (solverVariable.getHeight() - guideline.getRelativeEnd());
          } else {
            f = solverVariable.getHeight() * guideline.getRelativePercent();
          } 
          i = (int)(0.5F + f);
          paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
          paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
          paramConstraintWidget.mVerticalResolution = 2;
          paramConstraintWidget.mHorizontalResolution = 2;
          paramConstraintWidget.setVerticalDimension(i, i);
          paramConstraintWidget.setHorizontalDimension(0, solverVariable.getWidth());
          return;
        } 
        return;
      } 
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = paramConstraintWidget.getY();
      j = paramConstraintWidget.getHeight();
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i + j);
      if (paramConstraintWidget.mBaselineDistance > 0 || paramConstraintWidget.getVisibility() == 8) {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      } 
      paramConstraintWidget.mVerticalResolution = 2;
      return;
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\solver\widgets\Optimizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */