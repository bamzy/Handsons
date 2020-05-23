package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ActionBarContextView extends AbsActionBarView {
  private static final String TAG = "ActionBarContextView";
  
  private View mClose;
  
  private int mCloseItemLayout;
  
  private View mCustomView;
  
  private CharSequence mSubtitle;
  
  private int mSubtitleStyleRes;
  
  private TextView mSubtitleView;
  
  private CharSequence mTitle;
  
  private LinearLayout mTitleLayout;
  
  private boolean mTitleOptional;
  
  private int mTitleStyleRes;
  
  private TextView mTitleView;
  
  public ActionBarContextView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ActionMode, paramInt, 0);
    ViewCompat.setBackground((View)this, tintTypedArray.getDrawable(R.styleable.ActionMode_background));
    this.mTitleStyleRes = tintTypedArray.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
    this.mSubtitleStyleRes = tintTypedArray.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
    this.mContentHeight = tintTypedArray.getLayoutDimension(R.styleable.ActionMode_height, 0);
    this.mCloseItemLayout = tintTypedArray.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
    tintTypedArray.recycle();
  }
  
  private void initTitle() {
    // Byte code:
    //   0: bipush #8
    //   2: istore #4
    //   4: aload_0
    //   5: getfield mTitleLayout : Landroid/widget/LinearLayout;
    //   8: ifnonnull -> 121
    //   11: aload_0
    //   12: invokevirtual getContext : ()Landroid/content/Context;
    //   15: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   18: getstatic android/support/v7/appcompat/R$layout.abc_action_bar_title_item : I
    //   21: aload_0
    //   22: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
    //   25: pop
    //   26: aload_0
    //   27: aload_0
    //   28: aload_0
    //   29: invokevirtual getChildCount : ()I
    //   32: iconst_1
    //   33: isub
    //   34: invokevirtual getChildAt : (I)Landroid/view/View;
    //   37: checkcast android/widget/LinearLayout
    //   40: putfield mTitleLayout : Landroid/widget/LinearLayout;
    //   43: aload_0
    //   44: aload_0
    //   45: getfield mTitleLayout : Landroid/widget/LinearLayout;
    //   48: getstatic android/support/v7/appcompat/R$id.action_bar_title : I
    //   51: invokevirtual findViewById : (I)Landroid/view/View;
    //   54: checkcast android/widget/TextView
    //   57: putfield mTitleView : Landroid/widget/TextView;
    //   60: aload_0
    //   61: aload_0
    //   62: getfield mTitleLayout : Landroid/widget/LinearLayout;
    //   65: getstatic android/support/v7/appcompat/R$id.action_bar_subtitle : I
    //   68: invokevirtual findViewById : (I)Landroid/view/View;
    //   71: checkcast android/widget/TextView
    //   74: putfield mSubtitleView : Landroid/widget/TextView;
    //   77: aload_0
    //   78: getfield mTitleStyleRes : I
    //   81: ifeq -> 99
    //   84: aload_0
    //   85: getfield mTitleView : Landroid/widget/TextView;
    //   88: aload_0
    //   89: invokevirtual getContext : ()Landroid/content/Context;
    //   92: aload_0
    //   93: getfield mTitleStyleRes : I
    //   96: invokevirtual setTextAppearance : (Landroid/content/Context;I)V
    //   99: aload_0
    //   100: getfield mSubtitleStyleRes : I
    //   103: ifeq -> 121
    //   106: aload_0
    //   107: getfield mSubtitleView : Landroid/widget/TextView;
    //   110: aload_0
    //   111: invokevirtual getContext : ()Landroid/content/Context;
    //   114: aload_0
    //   115: getfield mSubtitleStyleRes : I
    //   118: invokevirtual setTextAppearance : (Landroid/content/Context;I)V
    //   121: aload_0
    //   122: getfield mTitleView : Landroid/widget/TextView;
    //   125: aload_0
    //   126: getfield mTitle : Ljava/lang/CharSequence;
    //   129: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   132: aload_0
    //   133: getfield mSubtitleView : Landroid/widget/TextView;
    //   136: aload_0
    //   137: getfield mSubtitle : Ljava/lang/CharSequence;
    //   140: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   143: aload_0
    //   144: getfield mTitle : Ljava/lang/CharSequence;
    //   147: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   150: ifne -> 229
    //   153: iconst_1
    //   154: istore_1
    //   155: aload_0
    //   156: getfield mSubtitle : Ljava/lang/CharSequence;
    //   159: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   162: ifne -> 234
    //   165: iconst_1
    //   166: istore_2
    //   167: aload_0
    //   168: getfield mSubtitleView : Landroid/widget/TextView;
    //   171: astore #5
    //   173: iload_2
    //   174: ifeq -> 239
    //   177: iconst_0
    //   178: istore_3
    //   179: aload #5
    //   181: iload_3
    //   182: invokevirtual setVisibility : (I)V
    //   185: aload_0
    //   186: getfield mTitleLayout : Landroid/widget/LinearLayout;
    //   189: astore #5
    //   191: iload_1
    //   192: ifne -> 202
    //   195: iload #4
    //   197: istore_1
    //   198: iload_2
    //   199: ifeq -> 204
    //   202: iconst_0
    //   203: istore_1
    //   204: aload #5
    //   206: iload_1
    //   207: invokevirtual setVisibility : (I)V
    //   210: aload_0
    //   211: getfield mTitleLayout : Landroid/widget/LinearLayout;
    //   214: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   217: ifnonnull -> 228
    //   220: aload_0
    //   221: aload_0
    //   222: getfield mTitleLayout : Landroid/widget/LinearLayout;
    //   225: invokevirtual addView : (Landroid/view/View;)V
    //   228: return
    //   229: iconst_0
    //   230: istore_1
    //   231: goto -> 155
    //   234: iconst_0
    //   235: istore_2
    //   236: goto -> 167
    //   239: bipush #8
    //   241: istore_3
    //   242: goto -> 179
  }
  
  public void closeMode() {
    if (this.mClose == null)
      killMode(); 
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return (ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return (ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle() {
    return this.mSubtitle;
  }
  
  public CharSequence getTitle() {
    return this.mTitle;
  }
  
  public boolean hideOverflowMenu() {
    return (this.mActionMenuPresenter != null) ? this.mActionMenuPresenter.hideOverflowMenu() : false;
  }
  
  public void initForMode(final ActionMode mode) {
    if (this.mClose == null) {
      this.mClose = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
      addView(this.mClose);
    } else if (this.mClose.getParent() == null) {
      addView(this.mClose);
    } 
    this.mClose.findViewById(R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            mode.finish();
          }
        });
    MenuBuilder menuBuilder = (MenuBuilder)mode.getMenu();
    if (this.mActionMenuPresenter != null)
      this.mActionMenuPresenter.dismissPopupMenus(); 
    this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
    this.mActionMenuPresenter.setReserveOverflow(true);
    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
    menuBuilder.addMenuPresenter((MenuPresenter)this.mActionMenuPresenter, this.mPopupContext);
    this.mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
    ViewCompat.setBackground((View)this.mMenuView, null);
    addView((View)this.mMenuView, layoutParams);
  }
  
  public boolean isOverflowMenuShowing() {
    return (this.mActionMenuPresenter != null) ? this.mActionMenuPresenter.isOverflowMenuShowing() : false;
  }
  
  public boolean isTitleOptional() {
    return this.mTitleOptional;
  }
  
  public void killMode() {
    removeAllViews();
    this.mCustomView = null;
    this.mMenuView = null;
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.mActionMenuPresenter != null) {
      this.mActionMenuPresenter.hideOverflowMenu();
      this.mActionMenuPresenter.hideSubMenus();
    } 
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    if (Build.VERSION.SDK_INT >= 14) {
      if (paramAccessibilityEvent.getEventType() == 32) {
        paramAccessibilityEvent.setSource((View)this);
        paramAccessibilityEvent.setClassName(getClass().getName());
        paramAccessibilityEvent.setPackageName(getContext().getPackageName());
        paramAccessibilityEvent.setContentDescription(this.mTitle);
        return;
      } 
    } else {
      return;
    } 
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i;
    paramBoolean = ViewUtils.isLayoutRtl((View)this);
    if (paramBoolean) {
      i = paramInt3 - paramInt1 - getPaddingRight();
    } else {
      i = getPaddingLeft();
    } 
    int j = getPaddingTop();
    int k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    paramInt2 = i;
    if (this.mClose != null) {
      paramInt2 = i;
      if (this.mClose.getVisibility() != 8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
        if (paramBoolean) {
          paramInt2 = marginLayoutParams.rightMargin;
        } else {
          paramInt2 = marginLayoutParams.leftMargin;
        } 
        if (paramBoolean) {
          paramInt4 = marginLayoutParams.leftMargin;
        } else {
          paramInt4 = marginLayoutParams.rightMargin;
        } 
        paramInt2 = next(i, paramInt2, paramBoolean);
        paramInt2 = next(paramInt2 + positionChild(this.mClose, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
      } 
    } 
    paramInt4 = paramInt2;
    if (this.mTitleLayout != null) {
      paramInt4 = paramInt2;
      if (this.mCustomView == null) {
        paramInt4 = paramInt2;
        if (this.mTitleLayout.getVisibility() != 8)
          paramInt4 = paramInt2 + positionChild((View)this.mTitleLayout, paramInt2, j, k, paramBoolean); 
      } 
    } 
    if (this.mCustomView != null)
      positionChild(this.mCustomView, paramInt4, j, k, paramBoolean); 
    if (paramBoolean) {
      paramInt1 = getPaddingLeft();
    } else {
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
    } 
    if (this.mMenuView != null) {
      ActionMenuView actionMenuView = this.mMenuView;
      if (!paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      positionChild((View)actionMenuView, paramInt1, j, k, paramBoolean);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)"); 
    if (View.MeasureSpec.getMode(paramInt2) == 0)
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\""); 
    int m = View.MeasureSpec.getSize(paramInt1);
    if (this.mContentHeight > 0) {
      i = this.mContentHeight;
    } else {
      i = View.MeasureSpec.getSize(paramInt2);
    } 
    int n = getPaddingTop() + getPaddingBottom();
    paramInt1 = m - getPaddingLeft() - getPaddingRight();
    int k = i - n;
    int j = View.MeasureSpec.makeMeasureSpec(k, -2147483648);
    paramInt2 = paramInt1;
    if (this.mClose != null) {
      paramInt1 = measureChildView(this.mClose, paramInt1, j, 0);
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
      paramInt2 = paramInt1 - marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    } 
    paramInt1 = paramInt2;
    if (this.mMenuView != null) {
      paramInt1 = paramInt2;
      if (this.mMenuView.getParent() == this)
        paramInt1 = measureChildView((View)this.mMenuView, paramInt2, j, 0); 
    } 
    paramInt2 = paramInt1;
    if (this.mTitleLayout != null) {
      paramInt2 = paramInt1;
      if (this.mCustomView == null)
        if (this.mTitleOptional) {
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.mTitleLayout.measure(paramInt2, j);
          int i1 = this.mTitleLayout.getMeasuredWidth();
          if (i1 <= paramInt1) {
            j = 1;
          } else {
            j = 0;
          } 
          paramInt2 = paramInt1;
          if (j != 0)
            paramInt2 = paramInt1 - i1; 
          LinearLayout linearLayout = this.mTitleLayout;
          if (j != 0) {
            paramInt1 = 0;
          } else {
            paramInt1 = 8;
          } 
          linearLayout.setVisibility(paramInt1);
        } else {
          paramInt2 = measureChildView((View)this.mTitleLayout, paramInt1, j, 0);
        }  
    } 
    if (this.mCustomView != null) {
      ViewGroup.LayoutParams layoutParams = this.mCustomView.getLayoutParams();
      if (layoutParams.width != -2) {
        paramInt1 = 1073741824;
      } else {
        paramInt1 = Integer.MIN_VALUE;
      } 
      if (layoutParams.width >= 0)
        paramInt2 = Math.min(layoutParams.width, paramInt2); 
      if (layoutParams.height != -2) {
        j = 1073741824;
      } else {
        j = Integer.MIN_VALUE;
      } 
      if (layoutParams.height >= 0)
        k = Math.min(layoutParams.height, k); 
      this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, paramInt1), View.MeasureSpec.makeMeasureSpec(k, j));
    } 
    if (this.mContentHeight <= 0) {
      paramInt2 = 0;
      k = getChildCount();
      paramInt1 = 0;
      while (paramInt1 < k) {
        j = getChildAt(paramInt1).getMeasuredHeight() + n;
        i = paramInt2;
        if (j > paramInt2)
          i = j; 
        paramInt1++;
        paramInt2 = i;
      } 
      setMeasuredDimension(m, paramInt2);
      return;
    } 
    setMeasuredDimension(m, i);
  }
  
  public void setContentHeight(int paramInt) {
    this.mContentHeight = paramInt;
  }
  
  public void setCustomView(View paramView) {
    if (this.mCustomView != null)
      removeView(this.mCustomView); 
    this.mCustomView = paramView;
    if (paramView != null && this.mTitleLayout != null) {
      removeView((View)this.mTitleLayout);
      this.mTitleLayout = null;
    } 
    if (paramView != null)
      addView(paramView); 
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {
    this.mSubtitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.mTitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitleOptional(boolean paramBoolean) {
    if (paramBoolean != this.mTitleOptional)
      requestLayout(); 
    this.mTitleOptional = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState() {
    return false;
  }
  
  public boolean showOverflowMenu() {
    return (this.mActionMenuPresenter != null) ? this.mActionMenuPresenter.showOverflowMenu() : false;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\ActionBarContextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */