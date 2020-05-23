package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

class DropDownListView extends ListViewCompat {
  private ViewPropertyAnimatorCompat mClickAnimation;
  
  private boolean mDrawsInPressedState;
  
  private boolean mHijackFocus;
  
  private boolean mListSelectionHidden;
  
  private ListViewAutoScrollHelper mScrollHelper;
  
  public DropDownListView(Context paramContext, boolean paramBoolean) {
    super(paramContext, (AttributeSet)null, R.attr.dropDownListViewStyle);
    this.mHijackFocus = paramBoolean;
    setCacheColorHint(0);
  }
  
  private void clearPressedItem() {
    this.mDrawsInPressedState = false;
    setPressed(false);
    drawableStateChanged();
    View view = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
    if (view != null)
      view.setPressed(false); 
    if (this.mClickAnimation != null) {
      this.mClickAnimation.cancel();
      this.mClickAnimation = null;
    } 
  }
  
  private void clickPressedItem(View paramView, int paramInt) {
    performItemClick(paramView, paramInt, getItemIdAtPosition(paramInt));
  }
  
  private void setPressedItem(View paramView, int paramInt, float paramFloat1, float paramFloat2) {
    this.mDrawsInPressedState = true;
    if (Build.VERSION.SDK_INT >= 21)
      drawableHotspotChanged(paramFloat1, paramFloat2); 
    if (!isPressed())
      setPressed(true); 
    layoutChildren();
    if (this.mMotionPosition != -1) {
      View view = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
      if (view != null && view != paramView && view.isPressed())
        view.setPressed(false); 
    } 
    this.mMotionPosition = paramInt;
    float f1 = paramView.getLeft();
    float f2 = paramView.getTop();
    if (Build.VERSION.SDK_INT >= 21)
      paramView.drawableHotspotChanged(paramFloat1 - f1, paramFloat2 - f2); 
    if (!paramView.isPressed())
      paramView.setPressed(true); 
    positionSelectorLikeTouchCompat(paramInt, paramView, paramFloat1, paramFloat2);
    setSelectorEnabled(false);
    refreshDrawableState();
  }
  
  public boolean hasFocus() {
    return (this.mHijackFocus || super.hasFocus());
  }
  
  public boolean hasWindowFocus() {
    return (this.mHijackFocus || super.hasWindowFocus());
  }
  
  public boolean isFocused() {
    return (this.mHijackFocus || super.isFocused());
  }
  
  public boolean isInTouchMode() {
    return ((this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode());
  }
  
  public boolean onForwardedEvent(MotionEvent paramMotionEvent, int paramInt) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #7
    //   3: iconst_1
    //   4: istore #8
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_1
    //   9: invokestatic getActionMasked : (Landroid/view/MotionEvent;)I
    //   12: istore #4
    //   14: iload #4
    //   16: tableswitch default -> 44, 1 -> 117, 2 -> 120, 3 -> 109
    //   44: iload #8
    //   46: istore #7
    //   48: iload_3
    //   49: istore_2
    //   50: iload #7
    //   52: ifeq -> 59
    //   55: iload_2
    //   56: ifeq -> 63
    //   59: aload_0
    //   60: invokespecial clearPressedItem : ()V
    //   63: iload #7
    //   65: ifeq -> 235
    //   68: aload_0
    //   69: getfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   72: ifnonnull -> 87
    //   75: aload_0
    //   76: new android/support/v4/widget/ListViewAutoScrollHelper
    //   79: dup
    //   80: aload_0
    //   81: invokespecial <init> : (Landroid/widget/ListView;)V
    //   84: putfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   87: aload_0
    //   88: getfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   91: iconst_1
    //   92: invokevirtual setEnabled : (Z)Landroid/support/v4/widget/AutoScrollHelper;
    //   95: pop
    //   96: aload_0
    //   97: getfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   100: aload_0
    //   101: aload_1
    //   102: invokevirtual onTouch : (Landroid/view/View;Landroid/view/MotionEvent;)Z
    //   105: pop
    //   106: iload #7
    //   108: ireturn
    //   109: iconst_0
    //   110: istore #7
    //   112: iload_3
    //   113: istore_2
    //   114: goto -> 50
    //   117: iconst_0
    //   118: istore #7
    //   120: aload_1
    //   121: iload_2
    //   122: invokevirtual findPointerIndex : (I)I
    //   125: istore #5
    //   127: iload #5
    //   129: ifge -> 140
    //   132: iconst_0
    //   133: istore #7
    //   135: iload_3
    //   136: istore_2
    //   137: goto -> 50
    //   140: aload_1
    //   141: iload #5
    //   143: invokevirtual getX : (I)F
    //   146: f2i
    //   147: istore_2
    //   148: aload_1
    //   149: iload #5
    //   151: invokevirtual getY : (I)F
    //   154: f2i
    //   155: istore #6
    //   157: aload_0
    //   158: iload_2
    //   159: iload #6
    //   161: invokevirtual pointToPosition : (II)I
    //   164: istore #5
    //   166: iload #5
    //   168: iconst_m1
    //   169: if_icmpne -> 177
    //   172: iconst_1
    //   173: istore_2
    //   174: goto -> 50
    //   177: aload_0
    //   178: iload #5
    //   180: aload_0
    //   181: invokevirtual getFirstVisiblePosition : ()I
    //   184: isub
    //   185: invokevirtual getChildAt : (I)Landroid/view/View;
    //   188: astore #9
    //   190: aload_0
    //   191: aload #9
    //   193: iload #5
    //   195: iload_2
    //   196: i2f
    //   197: iload #6
    //   199: i2f
    //   200: invokespecial setPressedItem : (Landroid/view/View;IFF)V
    //   203: iconst_1
    //   204: istore #8
    //   206: iload_3
    //   207: istore_2
    //   208: iload #8
    //   210: istore #7
    //   212: iload #4
    //   214: iconst_1
    //   215: if_icmpne -> 50
    //   218: aload_0
    //   219: aload #9
    //   221: iload #5
    //   223: invokespecial clickPressedItem : (Landroid/view/View;I)V
    //   226: iload_3
    //   227: istore_2
    //   228: iload #8
    //   230: istore #7
    //   232: goto -> 50
    //   235: aload_0
    //   236: getfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   239: ifnull -> 106
    //   242: aload_0
    //   243: getfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   246: iconst_0
    //   247: invokevirtual setEnabled : (Z)Landroid/support/v4/widget/AutoScrollHelper;
    //   250: pop
    //   251: iload #7
    //   253: ireturn
  }
  
  void setListSelectionHidden(boolean paramBoolean) {
    this.mListSelectionHidden = paramBoolean;
  }
  
  protected boolean touchModeDrawsInPressedStateCompat() {
    return (this.mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat());
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\DropDownListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */