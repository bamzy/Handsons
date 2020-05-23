package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView {
  private static final String TAG = "ListMenuItemView";
  
  private Drawable mBackground;
  
  private CheckBox mCheckBox;
  
  private boolean mForceShowIcon;
  
  private ImageView mIconView;
  
  private LayoutInflater mInflater;
  
  private MenuItemImpl mItemData;
  
  private int mMenuType;
  
  private boolean mPreserveIconSpacing;
  
  private RadioButton mRadioButton;
  
  private TextView mShortcutView;
  
  private Drawable mSubMenuArrow;
  
  private ImageView mSubMenuArrowView;
  
  private int mTextAppearance;
  
  private Context mTextAppearanceContext;
  
  private TextView mTitleView;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.MenuView, paramInt, 0);
    this.mBackground = tintTypedArray.getDrawable(R.styleable.MenuView_android_itemBackground);
    this.mTextAppearance = tintTypedArray.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
    this.mPreserveIconSpacing = tintTypedArray.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
    this.mTextAppearanceContext = paramContext;
    this.mSubMenuArrow = tintTypedArray.getDrawable(R.styleable.MenuView_subMenuArrow);
    tintTypedArray.recycle();
  }
  
  private LayoutInflater getInflater() {
    if (this.mInflater == null)
      this.mInflater = LayoutInflater.from(getContext()); 
    return this.mInflater;
  }
  
  private void insertCheckBox() {
    this.mCheckBox = (CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup)this, false);
    addView((View)this.mCheckBox);
  }
  
  private void insertIconView() {
    this.mIconView = (ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup)this, false);
    addView((View)this.mIconView, 0);
  }
  
  private void insertRadioButton() {
    this.mRadioButton = (RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup)this, false);
    addView((View)this.mRadioButton);
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean) {
    if (this.mSubMenuArrowView != null) {
      byte b;
      ImageView imageView = this.mSubMenuArrowView;
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      imageView.setVisibility(b);
    } 
  }
  
  public MenuItemImpl getItemData() {
    return this.mItemData;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt) {
    this.mItemData = paramMenuItemImpl;
    this.mMenuType = paramInt;
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    } 
    setVisibility(paramInt);
    setTitle(paramMenuItemImpl.getTitleForItemView(this));
    setCheckable(paramMenuItemImpl.isCheckable());
    setShortcut(paramMenuItemImpl.shouldShowShortcut(), paramMenuItemImpl.getShortcut());
    setIcon(paramMenuItemImpl.getIcon());
    setEnabled(paramMenuItemImpl.isEnabled());
    setSubMenuArrowVisible(paramMenuItemImpl.hasSubMenu());
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    ViewCompat.setBackground((View)this, this.mBackground);
    this.mTitleView = (TextView)findViewById(R.id.title);
    if (this.mTextAppearance != -1)
      this.mTitleView.setTextAppearance(this.mTextAppearanceContext, this.mTextAppearance); 
    this.mShortcutView = (TextView)findViewById(R.id.shortcut);
    this.mSubMenuArrowView = (ImageView)findViewById(R.id.submenuarrow);
    if (this.mSubMenuArrowView != null)
      this.mSubMenuArrowView.setImageDrawable(this.mSubMenuArrow); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.mIconView != null && this.mPreserveIconSpacing) {
      ViewGroup.LayoutParams layoutParams = getLayoutParams();
      LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)this.mIconView.getLayoutParams();
      if (layoutParams.height > 0 && layoutParams1.width <= 0)
        layoutParams1.width = layoutParams.height; 
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean prefersCondensedTitle() {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean) {
    if (paramBoolean || this.mRadioButton != null || this.mCheckBox != null) {
      CheckBox checkBox;
      RadioButton radioButton;
      if (this.mItemData.isExclusiveCheckable()) {
        if (this.mRadioButton == null)
          insertRadioButton(); 
        RadioButton radioButton1 = this.mRadioButton;
        CheckBox checkBox1 = this.mCheckBox;
      } else {
        if (this.mCheckBox == null)
          insertCheckBox(); 
        checkBox = this.mCheckBox;
        radioButton = this.mRadioButton;
      } 
      if (paramBoolean) {
        byte b;
        checkBox.setChecked(this.mItemData.isChecked());
        if (paramBoolean) {
          b = 0;
        } else {
          b = 8;
        } 
        if (checkBox.getVisibility() != b)
          checkBox.setVisibility(b); 
        if (radioButton != null && radioButton.getVisibility() != 8) {
          radioButton.setVisibility(8);
          return;
        } 
        return;
      } 
      if (this.mCheckBox != null)
        this.mCheckBox.setVisibility(8); 
      if (this.mRadioButton != null) {
        this.mRadioButton.setVisibility(8);
        return;
      } 
    } 
  }
  
  public void setChecked(boolean paramBoolean) {
    CheckBox checkBox;
    if (this.mItemData.isExclusiveCheckable()) {
      if (this.mRadioButton == null)
        insertRadioButton(); 
      RadioButton radioButton = this.mRadioButton;
    } else {
      if (this.mCheckBox == null)
        insertCheckBox(); 
      checkBox = this.mCheckBox;
    } 
    checkBox.setChecked(paramBoolean);
  }
  
  public void setForceShowIcon(boolean paramBoolean) {
    this.mForceShowIcon = paramBoolean;
    this.mPreserveIconSpacing = paramBoolean;
  }
  
  public void setIcon(Drawable paramDrawable) {
    boolean bool;
    if (this.mItemData.shouldShowIcon() || this.mForceShowIcon) {
      bool = true;
    } else {
      bool = false;
    } 
    if ((bool || this.mPreserveIconSpacing) && (this.mIconView != null || paramDrawable != null || this.mPreserveIconSpacing)) {
      if (this.mIconView == null)
        insertIconView(); 
      if (paramDrawable != null || this.mPreserveIconSpacing) {
        ImageView imageView = this.mIconView;
        if (!bool)
          paramDrawable = null; 
        imageView.setImageDrawable(paramDrawable);
        if (this.mIconView.getVisibility() != 0) {
          this.mIconView.setVisibility(0);
          return;
        } 
        return;
      } 
      this.mIconView.setVisibility(8);
      return;
    } 
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {
    if (paramBoolean && this.mItemData.shouldShowShortcut()) {
      paramChar = Character.MIN_VALUE;
    } else {
      paramChar = '\b';
    } 
    if (paramChar == '\000')
      this.mShortcutView.setText(this.mItemData.getShortcutLabel()); 
    if (this.mShortcutView.getVisibility() != paramChar)
      this.mShortcutView.setVisibility(paramChar); 
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    if (paramCharSequence != null) {
      this.mTitleView.setText(paramCharSequence);
      if (this.mTitleView.getVisibility() != 0)
        this.mTitleView.setVisibility(0); 
      return;
    } 
    if (this.mTitleView.getVisibility() != 8) {
      this.mTitleView.setVisibility(8);
      return;
    } 
  }
  
  public boolean showsIcon() {
    return this.mForceShowIcon;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\view\menu\ListMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */