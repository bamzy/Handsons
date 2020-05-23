package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import java.util.ArrayList;

public class ConstraintTableLayout extends ConstraintWidgetContainer {
  public static final int ALIGN_CENTER = 0;
  
  private static final int ALIGN_FULL = 3;
  
  public static final int ALIGN_LEFT = 1;
  
  public static final int ALIGN_RIGHT = 2;
  
  private ArrayList<Guideline> mHorizontalGuidelines = new ArrayList<Guideline>();
  
  private ArrayList<HorizontalSlice> mHorizontalSlices = new ArrayList<HorizontalSlice>();
  
  private int mNumCols = 0;
  
  private int mNumRows = 0;
  
  private int mPadding = 8;
  
  private boolean mVerticalGrowth = true;
  
  private ArrayList<Guideline> mVerticalGuidelines = new ArrayList<Guideline>();
  
  private ArrayList<VerticalSlice> mVerticalSlices = new ArrayList<VerticalSlice>();
  
  private LinearSystem system = null;
  
  public ConstraintTableLayout() {}
  
  public ConstraintTableLayout(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintTableLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void setChildrenConnections() {
    int k = this.mChildren.size();
    int j = 0;
    for (int i = 0;; i++) {
      if (i < k) {
        ConstraintWidget constraintWidget1 = this.mChildren.get(i);
        j += constraintWidget1.getContainerItemSkip();
        int m = this.mNumCols;
        int n = j / this.mNumCols;
        HorizontalSlice horizontalSlice = this.mHorizontalSlices.get(n);
        VerticalSlice verticalSlice = this.mVerticalSlices.get(j % m);
        ConstraintWidget constraintWidget2 = verticalSlice.left;
        ConstraintWidget constraintWidget3 = verticalSlice.right;
        ConstraintWidget constraintWidget4 = horizontalSlice.top;
        ConstraintWidget constraintWidget5 = horizontalSlice.bottom;
        constraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), this.mPadding);
        if (constraintWidget3 instanceof Guideline) {
          constraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.LEFT), this.mPadding);
        } else {
          constraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT), this.mPadding);
        } 
        switch (verticalSlice.alignment) {
          default:
            constraintWidget1.getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget4.getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
            if (constraintWidget5 instanceof Guideline) {
              constraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget5.getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
            } else {
              break;
            } 
            j++;
            i++;
            continue;
          case 3:
            constraintWidget1.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
          case 1:
            constraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.STRONG);
            constraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.WEAK);
          case 2:
            constraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.WEAK);
            constraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.STRONG);
        } 
        constraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget5.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mPadding);
      } else {
        break;
      } 
      j++;
    } 
  }
  
  private void setHorizontalSlices() {
    this.mHorizontalSlices.clear();
    float f2 = 100.0F / this.mNumRows;
    float f1 = f2;
    ConstraintTableLayout constraintTableLayout = this;
    for (int i = 0; i < this.mNumRows; i++) {
      HorizontalSlice horizontalSlice = new HorizontalSlice();
      horizontalSlice.top = constraintTableLayout;
      if (i < this.mNumRows - 1) {
        Guideline guideline = new Guideline();
        guideline.setOrientation(0);
        guideline.setParent(this);
        guideline.setGuidePercent((int)f1);
        f1 += f2;
        horizontalSlice.bottom = guideline;
        this.mHorizontalGuidelines.add(guideline);
      } else {
        horizontalSlice.bottom = this;
      } 
      ConstraintWidget constraintWidget = horizontalSlice.bottom;
      this.mHorizontalSlices.add(horizontalSlice);
    } 
    updateDebugSolverNames();
  }
  
  private void setVerticalSlices() {
    this.mVerticalSlices.clear();
    ConstraintTableLayout constraintTableLayout = this;
    float f2 = 100.0F / this.mNumCols;
    float f1 = f2;
    for (int i = 0; i < this.mNumCols; i++) {
      VerticalSlice verticalSlice = new VerticalSlice();
      verticalSlice.left = constraintTableLayout;
      if (i < this.mNumCols - 1) {
        Guideline guideline = new Guideline();
        guideline.setOrientation(1);
        guideline.setParent(this);
        guideline.setGuidePercent((int)f1);
        f1 += f2;
        verticalSlice.right = guideline;
        this.mVerticalGuidelines.add(guideline);
      } else {
        verticalSlice.right = this;
      } 
      ConstraintWidget constraintWidget = verticalSlice.right;
      this.mVerticalSlices.add(verticalSlice);
    } 
    updateDebugSolverNames();
  }
  
  private void updateDebugSolverNames() {
    if (this.system != null) {
      int j = this.mVerticalGuidelines.size();
      int i;
      for (i = 0; i < j; i++)
        ((Guideline)this.mVerticalGuidelines.get(i)).setDebugSolverName(this.system, getDebugName() + ".VG" + i); 
      j = this.mHorizontalGuidelines.size();
      i = 0;
      while (true) {
        if (i < j) {
          ((Guideline)this.mHorizontalGuidelines.get(i)).setDebugSolverName(this.system, getDebugName() + ".HG" + i);
          i++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, int paramInt) {
    super.addToSolver(paramLinearSystem, paramInt);
    int i = this.mChildren.size();
    if (i != 0) {
      setTableDimensions();
      if (paramLinearSystem == this.mSystem) {
        int k = this.mVerticalGuidelines.size();
        int j;
        for (j = 0; j < k; j++) {
          boolean bool;
          Guideline guideline = this.mVerticalGuidelines.get(j);
          if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            bool = true;
          } else {
            bool = false;
          } 
          guideline.setPositionRelaxed(bool);
          guideline.addToSolver(paramLinearSystem, paramInt);
        } 
        k = this.mHorizontalGuidelines.size();
        for (j = 0; j < k; j++) {
          boolean bool;
          Guideline guideline = this.mHorizontalGuidelines.get(j);
          if (getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            bool = true;
          } else {
            bool = false;
          } 
          guideline.setPositionRelaxed(bool);
          guideline.addToSolver(paramLinearSystem, paramInt);
        } 
        j = 0;
        while (true) {
          if (j < i) {
            ((ConstraintWidget)this.mChildren.get(j)).addToSolver(paramLinearSystem, paramInt);
            j++;
            continue;
          } 
          return;
        } 
      } 
    } 
  }
  
  public void computeGuidelinesPercentPositions() {
    int j = this.mVerticalGuidelines.size();
    int i;
    for (i = 0; i < j; i++)
      ((Guideline)this.mVerticalGuidelines.get(i)).inferRelativePercentPosition(); 
    j = this.mHorizontalGuidelines.size();
    for (i = 0; i < j; i++)
      ((Guideline)this.mHorizontalGuidelines.get(i)).inferRelativePercentPosition(); 
  }
  
  public void cycleColumnAlignment(int paramInt) {
    VerticalSlice verticalSlice = this.mVerticalSlices.get(paramInt);
    switch (verticalSlice.alignment) {
      default:
        setChildrenConnections();
        return;
      case 1:
        verticalSlice.alignment = 0;
      case 2:
        verticalSlice.alignment = 1;
      case 0:
        break;
    } 
    verticalSlice.alignment = 2;
  }
  
  public String getColumnAlignmentRepresentation(int paramInt) {
    VerticalSlice verticalSlice = this.mVerticalSlices.get(paramInt);
    return (verticalSlice.alignment == 1) ? "L" : ((verticalSlice.alignment == 0) ? "C" : ((verticalSlice.alignment == 3) ? "F" : ((verticalSlice.alignment == 2) ? "R" : "!")));
  }
  
  public String getColumnsAlignmentRepresentation() {
    int j = this.mVerticalSlices.size();
    String str = "";
    int i = 0;
    while (i < j) {
      String str1;
      VerticalSlice verticalSlice = this.mVerticalSlices.get(i);
      if (verticalSlice.alignment == 1) {
        str1 = str + "L";
      } else if (verticalSlice.alignment == 0) {
        str1 = str + "C";
      } else if (verticalSlice.alignment == 3) {
        str1 = str + "F";
      } else {
        str1 = str;
        if (verticalSlice.alignment == 2)
          str1 = str + "R"; 
      } 
      i++;
      str = str1;
    } 
    return str;
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines() {
    return this.mHorizontalGuidelines;
  }
  
  public int getNumCols() {
    return this.mNumCols;
  }
  
  public int getNumRows() {
    return this.mNumRows;
  }
  
  public int getPadding() {
    return this.mPadding;
  }
  
  public String getType() {
    return "ConstraintTableLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines() {
    return this.mVerticalGuidelines;
  }
  
  public boolean handlesInternalConstraints() {
    return true;
  }
  
  public boolean isVerticalGrowth() {
    return this.mVerticalGrowth;
  }
  
  public void setColumnAlignment(int paramInt1, int paramInt2) {
    if (paramInt1 < this.mVerticalSlices.size()) {
      ((VerticalSlice)this.mVerticalSlices.get(paramInt1)).alignment = paramInt2;
      setChildrenConnections();
    } 
  }
  
  public void setColumnAlignment(String paramString) {
    int i = 0;
    int j = paramString.length();
    while (i < j) {
      char c = paramString.charAt(i);
      if (c == 'L') {
        setColumnAlignment(i, 1);
      } else if (c == 'C') {
        setColumnAlignment(i, 0);
      } else if (c == 'F') {
        setColumnAlignment(i, 3);
      } else if (c == 'R') {
        setColumnAlignment(i, 2);
      } else {
        setColumnAlignment(i, 0);
      } 
      i++;
    } 
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString) {
    this.system = paramLinearSystem;
    super.setDebugSolverName(paramLinearSystem, paramString);
    updateDebugSolverNames();
  }
  
  public void setNumCols(int paramInt) {
    if (this.mVerticalGrowth && this.mNumCols != paramInt) {
      this.mNumCols = paramInt;
      setVerticalSlices();
      setTableDimensions();
    } 
  }
  
  public void setNumRows(int paramInt) {
    if (!this.mVerticalGrowth && this.mNumCols != paramInt) {
      this.mNumRows = paramInt;
      setHorizontalSlices();
      setTableDimensions();
    } 
  }
  
  public void setPadding(int paramInt) {
    if (paramInt > 1)
      this.mPadding = paramInt; 
  }
  
  public void setTableDimensions() {
    int j = 0;
    int k = this.mChildren.size();
    int i;
    for (i = 0; i < k; i++)
      j += ((ConstraintWidget)this.mChildren.get(i)).getContainerItemSkip(); 
    k += j;
    if (this.mVerticalGrowth) {
      if (this.mNumCols == 0)
        setNumCols(1); 
      j = k / this.mNumCols;
      i = j;
      if (this.mNumCols * j < k)
        i = j + 1; 
      if (this.mNumRows == i && this.mVerticalGuidelines.size() == this.mNumCols - 1)
        return; 
      this.mNumRows = i;
      setHorizontalSlices();
    } else {
      if (this.mNumRows == 0)
        setNumRows(1); 
      j = k / this.mNumRows;
      i = j;
      if (this.mNumRows * j < k)
        i = j + 1; 
      if (this.mNumCols != i || this.mHorizontalGuidelines.size() != this.mNumRows - 1) {
        this.mNumCols = i;
        setVerticalSlices();
      } else {
        return;
      } 
    } 
    setChildrenConnections();
  }
  
  public void setVerticalGrowth(boolean paramBoolean) {
    this.mVerticalGrowth = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem, int paramInt) {
    super.updateFromSolver(paramLinearSystem, paramInt);
    if (paramLinearSystem == this.mSystem) {
      int j = this.mVerticalGuidelines.size();
      int i;
      for (i = 0; i < j; i++)
        ((Guideline)this.mVerticalGuidelines.get(i)).updateFromSolver(paramLinearSystem, paramInt); 
      j = this.mHorizontalGuidelines.size();
      for (i = 0; i < j; i++)
        ((Guideline)this.mHorizontalGuidelines.get(i)).updateFromSolver(paramLinearSystem, paramInt); 
    } 
  }
  
  class HorizontalSlice {
    ConstraintWidget bottom;
    
    int padding;
    
    ConstraintWidget top;
  }
  
  class VerticalSlice {
    int alignment = 1;
    
    ConstraintWidget left;
    
    int padding;
    
    ConstraintWidget right;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\solver\widgets\ConstraintTableLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */