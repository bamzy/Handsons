package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ForwardingListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, View.OnLongClickListener, ActionMenuView.ActionMenuChildView {
  private static final int MAX_ICON_SIZE = 32;
  
  private static final String TAG = "ActionMenuItemView";
  
  private boolean mAllowTextWithIcon;
  
  private boolean mExpandedFormat;
  
  private ForwardingListener mForwardingListener;
  
  private Drawable mIcon;
  
  MenuItemImpl mItemData;
  
  MenuBuilder.ItemInvoker mItemInvoker;
  
  private int mMaxIconSize;
  
  private int mMinWidth;
  
  PopupCallback mPopupCallback;
  
  private int mSavedPaddingLeft;
  
  private CharSequence mTitle;
  
  public ActionMenuItemView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    Resources resources = paramContext.getResources();
    this.mAllowTextWithIcon = shouldAllowTextWithIcon();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionMenuItemView, paramInt, 0);
    this.mMinWidth = typedArray.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
    typedArray.recycle();
    this.mMaxIconSize = (int)(32.0F * (resources.getDisplayMetrics()).density + 0.5F);
    setOnClickListener(this);
    setOnLongClickListener(this);
    this.mSavedPaddingLeft = -1;
    setSaveEnabled(false);
  }
  
  private boolean shouldAllowTextWithIcon() {
    Configuration configuration = getContext().getResources().getConfiguration();
    int i = ConfigurationHelper.getScreenWidthDp(getResources());
    int j = ConfigurationHelper.getScreenHeightDp(getResources());
    return (i >= 480 || (i >= 640 && j >= 480) || configuration.orientation == 2);
  }
  
  private void updateTextButtonVisibility() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield mTitle : Ljava/lang/CharSequence;
    //   6: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   9: ifne -> 70
    //   12: iconst_1
    //   13: istore_1
    //   14: aload_0
    //   15: getfield mIcon : Landroid/graphics/drawable/Drawable;
    //   18: ifnull -> 49
    //   21: iload_3
    //   22: istore_2
    //   23: aload_0
    //   24: getfield mItemData : Landroid/support/v7/view/menu/MenuItemImpl;
    //   27: invokevirtual showsTextAsAction : ()Z
    //   30: ifeq -> 51
    //   33: aload_0
    //   34: getfield mAllowTextWithIcon : Z
    //   37: ifne -> 49
    //   40: iload_3
    //   41: istore_2
    //   42: aload_0
    //   43: getfield mExpandedFormat : Z
    //   46: ifeq -> 51
    //   49: iconst_1
    //   50: istore_2
    //   51: iload_1
    //   52: iload_2
    //   53: iand
    //   54: ifeq -> 75
    //   57: aload_0
    //   58: getfield mTitle : Ljava/lang/CharSequence;
    //   61: astore #4
    //   63: aload_0
    //   64: aload #4
    //   66: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   69: return
    //   70: iconst_0
    //   71: istore_1
    //   72: goto -> 14
    //   75: aconst_null
    //   76: astore #4
    //   78: goto -> 63
  }
  
  public MenuItemImpl getItemData() {
    return this.mItemData;
  }
  
  public boolean hasText() {
    return !TextUtils.isEmpty(getText());
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt) {
    this.mItemData = paramMenuItemImpl;
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.getTitleForItemView(this));
    setId(paramMenuItemImpl.getItemId());
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    } 
    setVisibility(paramInt);
    setEnabled(paramMenuItemImpl.isEnabled());
    if (paramMenuItemImpl.hasSubMenu() && this.mForwardingListener == null)
      this.mForwardingListener = new ActionMenuItemForwardingListener(); 
  }
  
  public boolean needsDividerAfter() {
    return hasText();
  }
  
  public boolean needsDividerBefore() {
    return (hasText() && this.mItemData.getIcon() == null);
  }
  
  public void onClick(View paramView) {
    if (this.mItemInvoker != null)
      this.mItemInvoker.invokeItem(this.mItemData); 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    this.mAllowTextWithIcon = shouldAllowTextWithIcon();
    updateTextButtonVisibility();
  }
  
  public boolean onLongClick(View paramView) {
    if (hasText())
      return false; 
    int[] arrayOfInt = new int[2];
    Rect rect = new Rect();
    getLocationOnScreen(arrayOfInt);
    getWindowVisibleDisplayFrame(rect);
    Context context = getContext();
    int i = getWidth();
    int k = getHeight();
    int m = arrayOfInt[1];
    int n = k / 2;
    int j = arrayOfInt[0] + i / 2;
    i = j;
    if (ViewCompat.getLayoutDirection(paramView) == 0)
      i = (context.getResources().getDisplayMetrics()).widthPixels - j; 
    Toast toast = Toast.makeText(context, this.mItemData.getTitle(), 0);
    if (m + n < rect.height()) {
      toast.setGravity(8388661, i, arrayOfInt[1] + k - rect.top);
      toast.show();
      return true;
    } 
    toast.setGravity(81, 0, k);
    toast.show();
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    boolean bool = hasText();
    if (bool && this.mSavedPaddingLeft >= 0)
      super.setPadding(this.mSavedPaddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom()); 
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = getMeasuredWidth();
    if (i == Integer.MIN_VALUE) {
      paramInt1 = Math.min(paramInt1, this.mMinWidth);
    } else {
      paramInt1 = this.mMinWidth;
    } 
    if (i != 1073741824 && this.mMinWidth > 0 && j < paramInt1)
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2); 
    if (!bool && this.mIcon != null)
      super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom()); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    super.onRestoreInstanceState(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return (this.mItemData.hasSubMenu() && this.mForwardingListener != null && this.mForwardingListener.onTouch((View)this, paramMotionEvent)) ? true : super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean prefersCondensedTitle() {
    return true;
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean) {
    if (this.mExpandedFormat != paramBoolean) {
      this.mExpandedFormat = paramBoolean;
      if (this.mItemData != null)
        this.mItemData.actionFormatChanged(); 
    } 
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.mIcon = paramDrawable;
    if (paramDrawable != null) {
      int m = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int j = k;
      int i = m;
      if (m > this.mMaxIconSize) {
        float f = this.mMaxIconSize / m;
        i = this.mMaxIconSize;
        j = (int)(k * f);
      } 
      m = j;
      k = i;
      if (j > this.mMaxIconSize) {
        float f = this.mMaxIconSize / j;
        m = this.mMaxIconSize;
        k = (int)(i * f);
      } 
      paramDrawable.setBounds(0, 0, k, m);
    } 
    setCompoundDrawables(paramDrawable, null, null, null);
    updateTextButtonVisibility();
  }
  
  public void setItemInvoker(MenuBuilder.ItemInvoker paramItemInvoker) {
    this.mItemInvoker = paramItemInvoker;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mSavedPaddingLeft = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(PopupCallback paramPopupCallback) {
    this.mPopupCallback = paramPopupCallback;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTitle(CharSequence paramCharSequence) {
    this.mTitle = paramCharSequence;
    setContentDescription(this.mTitle);
    updateTextButtonVisibility();
  }
  
  public boolean showsIcon() {
    return true;
  }
  
  private class ActionMenuItemForwardingListener extends ForwardingListener {
    public ActionMenuItemForwardingListener() {
      super((View)ActionMenuItemView.this);
    }
    
    public ShowableListMenu getPopup() {
      return (ActionMenuItemView.this.mPopupCallback != null) ? ActionMenuItemView.this.mPopupCallback.getPopup() : null;
    }
    
    protected boolean onForwardingStarted() {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (ActionMenuItemView.this.mItemInvoker != null) {
        bool1 = bool2;
        if (ActionMenuItemView.this.mItemInvoker.invokeItem(ActionMenuItemView.this.mItemData)) {
          ShowableListMenu showableListMenu = getPopup();
          bool1 = bool2;
          if (showableListMenu != null) {
            bool1 = bool2;
            if (showableListMenu.isShowing())
              bool1 = true; 
          } 
        } 
      } 
      return bool1;
    }
  }
  
  public static abstract class PopupCallback {
    public abstract ShowableListMenu getPopup();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\view\menu\ActionMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */