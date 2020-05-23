package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {
  protected ArrayList<ConstraintWidget> mChildren = new ArrayList<ConstraintWidget>();
  
  public WidgetContainer() {}
  
  public WidgetContainer(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public WidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static Rectangle getBounds(ArrayList<ConstraintWidget> paramArrayList) {
    Rectangle rectangle = new Rectangle();
    if (paramArrayList.size() == 0)
      return rectangle; 
    int n = Integer.MAX_VALUE;
    int k = 0;
    int m = Integer.MAX_VALUE;
    int i = 0;
    int j = 0;
    int i1 = paramArrayList.size();
    while (j < i1) {
      ConstraintWidget constraintWidget = paramArrayList.get(j);
      int i2 = n;
      if (constraintWidget.getX() < n)
        i2 = constraintWidget.getX(); 
      int i3 = m;
      if (constraintWidget.getY() < m)
        i3 = constraintWidget.getY(); 
      m = k;
      if (constraintWidget.getRight() > k)
        m = constraintWidget.getRight(); 
      n = i;
      if (constraintWidget.getBottom() > i)
        n = constraintWidget.getBottom(); 
      j++;
      k = m;
      i = n;
      n = i2;
      m = i3;
    } 
    rectangle.setBounds(n, m, k - n, i - m);
    return rectangle;
  }
  
  public void add(ConstraintWidget paramConstraintWidget) {
    this.mChildren.add(paramConstraintWidget);
    if (paramConstraintWidget.getParent() != null)
      ((WidgetContainer)paramConstraintWidget.getParent()).remove(paramConstraintWidget); 
    paramConstraintWidget.setParent(this);
  }
  
  public ConstraintWidget findWidget(float paramFloat1, float paramFloat2) {
    ConstraintWidget constraintWidget = null;
    int i = getDrawX();
    int j = getDrawY();
    int k = getWidth();
    int m = getHeight();
    WidgetContainer widgetContainer = (WidgetContainer)constraintWidget;
    if (paramFloat1 >= i) {
      widgetContainer = (WidgetContainer)constraintWidget;
      if (paramFloat1 <= (i + k)) {
        widgetContainer = (WidgetContainer)constraintWidget;
        if (paramFloat2 >= j) {
          widgetContainer = (WidgetContainer)constraintWidget;
          if (paramFloat2 <= (j + m))
            widgetContainer = this; 
        } 
      } 
    } 
    i = 0;
    j = this.mChildren.size();
    constraintWidget = widgetContainer;
    while (i < j) {
      ConstraintWidget constraintWidget1;
      ConstraintWidget constraintWidget2 = this.mChildren.get(i);
      if (constraintWidget2 instanceof WidgetContainer) {
        constraintWidget2 = ((WidgetContainer)constraintWidget2).findWidget(paramFloat1, paramFloat2);
        widgetContainer = (WidgetContainer)constraintWidget;
        if (constraintWidget2 != null)
          constraintWidget1 = constraintWidget2; 
      } else {
        k = constraintWidget2.getDrawX();
        m = constraintWidget2.getDrawY();
        int n = constraintWidget2.getWidth();
        int i1 = constraintWidget2.getHeight();
        widgetContainer = (WidgetContainer)constraintWidget;
        if (paramFloat1 >= k) {
          widgetContainer = (WidgetContainer)constraintWidget;
          if (paramFloat1 <= (k + n)) {
            widgetContainer = (WidgetContainer)constraintWidget;
            if (paramFloat2 >= m) {
              widgetContainer = (WidgetContainer)constraintWidget;
              if (paramFloat2 <= (m + i1))
                constraintWidget1 = constraintWidget2; 
            } 
          } 
        } 
      } 
      i++;
      constraintWidget = constraintWidget1;
    } 
    return constraintWidget;
  }
  
  public ArrayList<ConstraintWidget> findWidgets(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    ArrayList<ConstraintWidget> arrayList = new ArrayList();
    Rectangle rectangle = new Rectangle();
    rectangle.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    paramInt2 = this.mChildren.size();
    while (paramInt1 < paramInt2) {
      ConstraintWidget constraintWidget = this.mChildren.get(paramInt1);
      Rectangle rectangle1 = new Rectangle();
      rectangle1.setBounds(constraintWidget.getDrawX(), constraintWidget.getDrawY(), constraintWidget.getWidth(), constraintWidget.getHeight());
      if (rectangle.intersects(rectangle1))
        arrayList.add(constraintWidget); 
      paramInt1++;
    } 
    return arrayList;
  }
  
  public ArrayList<ConstraintWidget> getChildren() {
    return this.mChildren;
  }
  
  public ConstraintWidgetContainer getRootConstraintContainer() {
    ConstraintWidget constraintWidget2 = getParent();
    ConstraintWidgetContainer constraintWidgetContainer = null;
    ConstraintWidget constraintWidget1 = constraintWidget2;
    if (this instanceof ConstraintWidgetContainer) {
      constraintWidgetContainer = (ConstraintWidgetContainer)this;
      constraintWidget1 = constraintWidget2;
    } 
    while (true) {
      ConstraintWidget constraintWidget = constraintWidget1;
      if (constraintWidget != null) {
        constraintWidget2 = constraintWidget.getParent();
        constraintWidget1 = constraintWidget2;
        if (constraintWidget instanceof ConstraintWidgetContainer) {
          constraintWidgetContainer = (ConstraintWidgetContainer)constraintWidget;
          constraintWidget1 = constraintWidget2;
        } 
        continue;
      } 
      return constraintWidgetContainer;
    } 
  }
  
  public void layout() {
    updateDrawPosition();
    if (this.mChildren != null) {
      int j = this.mChildren.size();
      int i = 0;
      while (true) {
        if (i < j) {
          ConstraintWidget constraintWidget = this.mChildren.get(i);
          if (constraintWidget instanceof WidgetContainer)
            ((WidgetContainer)constraintWidget).layout(); 
          i++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public void remove(ConstraintWidget paramConstraintWidget) {
    this.mChildren.remove(paramConstraintWidget);
    paramConstraintWidget.setParent(null);
  }
  
  public void removeAllChildren() {
    this.mChildren.clear();
  }
  
  public void reset() {
    this.mChildren.clear();
    super.reset();
  }
  
  public void resetGroups() {
    super.resetGroups();
    int j = this.mChildren.size();
    for (int i = 0; i < j; i++)
      ((ConstraintWidget)this.mChildren.get(i)).resetGroups(); 
  }
  
  public void resetSolverVariables(Cache paramCache) {
    super.resetSolverVariables(paramCache);
    int j = this.mChildren.size();
    for (int i = 0; i < j; i++)
      ((ConstraintWidget)this.mChildren.get(i)).resetSolverVariables(paramCache); 
  }
  
  public void setOffset(int paramInt1, int paramInt2) {
    super.setOffset(paramInt1, paramInt2);
    paramInt2 = this.mChildren.size();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
      ((ConstraintWidget)this.mChildren.get(paramInt1)).setOffset(getRootX(), getRootY()); 
  }
  
  public void updateDrawPosition() {
    super.updateDrawPosition();
    if (this.mChildren != null) {
      int j = this.mChildren.size();
      int i = 0;
      while (true) {
        if (i < j) {
          ConstraintWidget constraintWidget = this.mChildren.get(i);
          constraintWidget.setOffset(getDrawX(), getDrawY());
          if (!(constraintWidget instanceof ConstraintWidgetContainer))
            constraintWidget.updateDrawPosition(); 
          i++;
          continue;
        } 
        return;
      } 
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\solver\widgets\WidgetContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */