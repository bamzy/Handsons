package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ButtonBarLayout extends LinearLayout {
  private static final int ALLOW_STACKING_MIN_HEIGHT_DP = 320;
  
  private static final int PEEK_BUTTON_DP = 16;
  
  private boolean mAllowStacking;
  
  private int mLastWidthSize;
  
  public ButtonBarLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    boolean bool;
    this.mLastWidthSize = -1;
    if (ConfigurationHelper.getScreenHeightDp(getResources()) >= 320) {
      bool = true;
    } else {
      bool = false;
    } 
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ButtonBarLayout);
    this.mAllowStacking = typedArray.getBoolean(R.styleable.ButtonBarLayout_allowStacking, bool);
    typedArray.recycle();
  }
  
  private int getNextVisibleChildIndex(int paramInt) {
    int i = getChildCount();
    while (paramInt < i) {
      if (getChildAt(paramInt).getVisibility() == 0)
        return paramInt; 
      paramInt++;
    } 
    return -1;
  }
  
  private boolean isStacked() {
    return (getOrientation() == 1);
  }
  
  private void setStacked(boolean paramBoolean) {
    if (paramBoolean) {
      i = 1;
    } else {
      i = 0;
    } 
    setOrientation(i);
    if (paramBoolean) {
      i = 5;
    } else {
      i = 80;
    } 
    setGravity(i);
    View view = findViewById(R.id.spacer);
    if (view != null) {
      if (paramBoolean) {
        i = 8;
      } else {
        i = 4;
      } 
      view.setVisibility(i);
    } 
    int i;
    for (i = getChildCount() - 2; i >= 0; i--)
      bringChildToFront(getChildAt(i)); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int j;
    int m = View.MeasureSpec.getSize(paramInt1);
    if (this.mAllowStacking) {
      if (m > this.mLastWidthSize && isStacked())
        setStacked(false); 
      this.mLastWidthSize = m;
    } 
    int i = 0;
    if (!isStacked() && View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      j = View.MeasureSpec.makeMeasureSpec(m, -2147483648);
      i = 1;
    } else {
      j = paramInt1;
    } 
    super.onMeasure(j, paramInt2);
    int k = i;
    if (this.mAllowStacking) {
      k = i;
      if (!isStacked()) {
        if (Build.VERSION.SDK_INT >= 11) {
          if ((ViewCompat.getMeasuredWidthAndState((View)this) & 0xFF000000) == 16777216) {
            j = 1;
          } else {
            j = 0;
          } 
        } else {
          k = 0;
          j = 0;
          int n = getChildCount();
          while (j < n) {
            k += getChildAt(j).getMeasuredWidth();
            j++;
          } 
          if (getPaddingLeft() + k + getPaddingRight() > m) {
            j = 1;
          } else {
            j = 0;
          } 
        } 
        k = i;
        if (j != 0) {
          setStacked(true);
          k = 1;
        } 
      } 
    } 
    if (k != 0)
      super.onMeasure(paramInt1, paramInt2); 
    paramInt1 = 0;
    i = getNextVisibleChildIndex(0);
    if (i >= 0) {
      View view = getChildAt(i);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
      paramInt2 = 0 + getPaddingTop() + view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
      if (isStacked()) {
        i = getNextVisibleChildIndex(i + 1);
        paramInt1 = paramInt2;
        if (i >= 0)
          paramInt1 = (int)(paramInt2 + getChildAt(i).getPaddingTop() + 16.0F * (getResources().getDisplayMetrics()).density); 
      } else {
        paramInt1 = paramInt2 + getPaddingBottom();
      } 
    } 
    if (ViewCompat.getMinimumHeight((View)this) != paramInt1)
      setMinimumHeight(paramInt1); 
  }
  
  public void setAllowStacking(boolean paramBoolean) {
    if (this.mAllowStacking != paramBoolean) {
      this.mAllowStacking = paramBoolean;
      if (!this.mAllowStacking && getOrientation() == 1)
        setStacked(false); 
      requestLayout();
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\ButtonBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */