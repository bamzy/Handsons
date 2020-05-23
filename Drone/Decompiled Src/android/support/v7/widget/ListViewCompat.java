package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ListViewCompat extends ListView {
  public static final int INVALID_POSITION = -1;
  
  public static final int NO_POSITION = -1;
  
  private static final int[] STATE_SET_NOTHING = new int[] { 0 };
  
  private Field mIsChildViewEnabled;
  
  protected int mMotionPosition;
  
  int mSelectionBottomPadding = 0;
  
  int mSelectionLeftPadding = 0;
  
  int mSelectionRightPadding = 0;
  
  int mSelectionTopPadding = 0;
  
  private GateKeeperDrawable mSelector;
  
  final Rect mSelectorRect = new Rect();
  
  public ListViewCompat(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ListViewCompat(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ListViewCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    try {
      this.mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.mIsChildViewEnabled.setAccessible(true);
      return;
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
      return;
    } 
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    drawSelectorCompat(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawSelectorCompat(Canvas paramCanvas) {
    if (!this.mSelectorRect.isEmpty()) {
      Drawable drawable = getSelector();
      if (drawable != null) {
        drawable.setBounds(this.mSelectorRect);
        drawable.draw(paramCanvas);
      } 
    } 
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    setSelectorEnabled(true);
    updateSelectorStateCompat();
  }
  
  public int lookForSelectablePosition(int paramInt, boolean paramBoolean) {
    ListAdapter listAdapter = getAdapter();
    if (listAdapter != null && !isInTouchMode()) {
      int i = listAdapter.getCount();
      if (!getAdapter().areAllItemsEnabled()) {
        int j;
        if (paramBoolean) {
          paramInt = Math.max(0, paramInt);
          while (true) {
            j = paramInt;
            if (paramInt < i) {
              j = paramInt;
              if (!listAdapter.isEnabled(paramInt)) {
                paramInt++;
                continue;
              } 
            } 
            break;
          } 
        } else {
          paramInt = Math.min(paramInt, i - 1);
          while (true) {
            j = paramInt;
            if (paramInt >= 0) {
              j = paramInt;
              if (!listAdapter.isEnabled(paramInt)) {
                paramInt--;
                continue;
              } 
            } 
            break;
          } 
        } 
        return (j >= 0 && j < i) ? j : -1;
      } 
      if (paramInt >= 0 && paramInt < i)
        return paramInt; 
    } 
    return -1;
  }
  
  public int measureHeightOfChildrenCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    paramInt2 = getListPaddingTop();
    paramInt3 = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int i = getDividerHeight();
    Drawable drawable = getDivider();
    ListAdapter listAdapter = getAdapter();
    if (listAdapter == null) {
      paramInt2 += paramInt3;
      return paramInt2;
    } 
    paramInt3 = paramInt2 + paramInt3;
    if (i <= 0 || drawable == null)
      i = 0; 
    paramInt2 = 0;
    drawable = null;
    int k = 0;
    int m = listAdapter.getCount();
    int j = 0;
    while (j < m) {
      int i1 = listAdapter.getItemViewType(j);
      int n = k;
      if (i1 != k) {
        drawable = null;
        n = i1;
      } 
      View view2 = listAdapter.getView(j, (View)drawable, (ViewGroup)this);
      ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
      ViewGroup.LayoutParams layoutParams1 = layoutParams2;
      if (layoutParams2 == null) {
        layoutParams1 = generateDefaultLayoutParams();
        view2.setLayoutParams(layoutParams1);
      } 
      if (layoutParams1.height > 0) {
        k = View.MeasureSpec.makeMeasureSpec(layoutParams1.height, 1073741824);
      } else {
        k = View.MeasureSpec.makeMeasureSpec(0, 0);
      } 
      view2.measure(paramInt1, k);
      view2.forceLayout();
      k = paramInt3;
      if (j > 0)
        k = paramInt3 + i; 
      paramInt3 = k + view2.getMeasuredHeight();
      if (paramInt3 >= paramInt4)
        return (paramInt5 < 0 || j <= paramInt5 || paramInt2 <= 0 || paramInt3 == paramInt4) ? paramInt4 : paramInt2; 
      k = paramInt2;
      if (paramInt5 >= 0) {
        k = paramInt2;
        if (j >= paramInt5)
          k = paramInt3; 
      } 
      j++;
      View view1 = view2;
      paramInt2 = k;
      k = n;
    } 
    return paramInt3;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    switch (paramMotionEvent.getAction()) {
      default:
        return super.onTouchEvent(paramMotionEvent);
      case 0:
        break;
    } 
    this.mMotionPosition = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  protected void positionSelectorCompat(int paramInt, View paramView) {
    Rect rect = this.mSelectorRect;
    rect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    rect.left -= this.mSelectionLeftPadding;
    rect.top -= this.mSelectionTopPadding;
    rect.right += this.mSelectionRightPadding;
    rect.bottom += this.mSelectionBottomPadding;
    try {
      boolean bool = this.mIsChildViewEnabled.getBoolean(this);
      if (paramView.isEnabled() != bool) {
        Field field = this.mIsChildViewEnabled;
        if (!bool) {
          bool = true;
        } else {
          bool = false;
        } 
        field.set(this, Boolean.valueOf(bool));
        if (paramInt != -1)
          refreshDrawableState(); 
      } 
      return;
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
      return;
    } 
  }
  
  protected void positionSelectorLikeFocusCompat(int paramInt, View paramView) {
    boolean bool1;
    boolean bool2 = true;
    Drawable drawable = getSelector();
    if (drawable != null && paramInt != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool1)
      drawable.setVisible(false, false); 
    positionSelectorCompat(paramInt, paramView);
    if (bool1) {
      Rect rect = this.mSelectorRect;
      float f1 = rect.exactCenterX();
      float f2 = rect.exactCenterY();
      if (getVisibility() != 0)
        bool2 = false; 
      drawable.setVisible(bool2, false);
      DrawableCompat.setHotspot(drawable, f1, f2);
    } 
  }
  
  protected void positionSelectorLikeTouchCompat(int paramInt, View paramView, float paramFloat1, float paramFloat2) {
    positionSelectorLikeFocusCompat(paramInt, paramView);
    Drawable drawable = getSelector();
    if (drawable != null && paramInt != -1)
      DrawableCompat.setHotspot(drawable, paramFloat1, paramFloat2); 
  }
  
  public void setSelector(Drawable paramDrawable) {
    GateKeeperDrawable gateKeeperDrawable;
    if (paramDrawable != null) {
      gateKeeperDrawable = new GateKeeperDrawable(paramDrawable);
    } else {
      gateKeeperDrawable = null;
    } 
    this.mSelector = gateKeeperDrawable;
    super.setSelector((Drawable)this.mSelector);
    Rect rect = new Rect();
    if (paramDrawable != null)
      paramDrawable.getPadding(rect); 
    this.mSelectionLeftPadding = rect.left;
    this.mSelectionTopPadding = rect.top;
    this.mSelectionRightPadding = rect.right;
    this.mSelectionBottomPadding = rect.bottom;
  }
  
  protected void setSelectorEnabled(boolean paramBoolean) {
    if (this.mSelector != null)
      this.mSelector.setEnabled(paramBoolean); 
  }
  
  protected boolean shouldShowSelectorCompat() {
    return (touchModeDrawsInPressedStateCompat() && isPressed());
  }
  
  protected boolean touchModeDrawsInPressedStateCompat() {
    return false;
  }
  
  protected void updateSelectorStateCompat() {
    Drawable drawable = getSelector();
    if (drawable != null && shouldShowSelectorCompat())
      drawable.setState(getDrawableState()); 
  }
  
  private static class GateKeeperDrawable extends DrawableWrapper {
    private boolean mEnabled = true;
    
    public GateKeeperDrawable(Drawable param1Drawable) {
      super(param1Drawable);
    }
    
    public void draw(Canvas param1Canvas) {
      if (this.mEnabled)
        super.draw(param1Canvas); 
    }
    
    void setEnabled(boolean param1Boolean) {
      this.mEnabled = param1Boolean;
    }
    
    public void setHotspot(float param1Float1, float param1Float2) {
      if (this.mEnabled)
        super.setHotspot(param1Float1, param1Float2); 
    }
    
    public void setHotspotBounds(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      if (this.mEnabled)
        super.setHotspotBounds(param1Int1, param1Int2, param1Int3, param1Int4); 
    }
    
    public boolean setState(int[] param1ArrayOfint) {
      return this.mEnabled ? super.setState(param1ArrayOfint) : false;
    }
    
    public boolean setVisible(boolean param1Boolean1, boolean param1Boolean2) {
      return this.mEnabled ? super.setVisible(param1Boolean1, param1Boolean2) : false;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\ListViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */