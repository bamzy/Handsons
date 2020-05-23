package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

public class ConstraintHorizontalLayout extends ConstraintWidgetContainer {
  private ContentAlignment mAlignment = ContentAlignment.MIDDLE;
  
  public ConstraintHorizontalLayout() {}
  
  public ConstraintHorizontalLayout(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintHorizontalLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, int paramInt) {
    if (this.mChildren.size() != 0) {
      ConstraintWidget constraintWidget = this;
      int i = 0;
      int j = this.mChildren.size();
      while (i < j) {
        ConstraintWidget constraintWidget1 = this.mChildren.get(i);
        if (constraintWidget != this) {
          constraintWidget1.connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.RIGHT);
          constraintWidget.connect(ConstraintAnchor.Type.RIGHT, constraintWidget1, ConstraintAnchor.Type.LEFT);
        } else {
          ConstraintAnchor.Strength strength = ConstraintAnchor.Strength.STRONG;
          if (this.mAlignment == ContentAlignment.END)
            strength = ConstraintAnchor.Strength.WEAK; 
          constraintWidget1.connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0, strength);
        } 
        constraintWidget1.connect(ConstraintAnchor.Type.TOP, this, ConstraintAnchor.Type.TOP);
        constraintWidget1.connect(ConstraintAnchor.Type.BOTTOM, this, ConstraintAnchor.Type.BOTTOM);
        constraintWidget = constraintWidget1;
        i++;
      } 
      if (constraintWidget != this) {
        ConstraintAnchor.Strength strength = ConstraintAnchor.Strength.STRONG;
        if (this.mAlignment == ContentAlignment.BEGIN)
          strength = ConstraintAnchor.Strength.WEAK; 
        constraintWidget.connect(ConstraintAnchor.Type.RIGHT, this, ConstraintAnchor.Type.RIGHT, 0, strength);
      } 
    } 
    super.addToSolver(paramLinearSystem, paramInt);
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
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\solver\widgets\ConstraintHorizontalLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */