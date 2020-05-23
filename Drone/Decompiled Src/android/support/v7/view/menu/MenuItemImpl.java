package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewGroup;
import android.widget.LinearLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MenuItemImpl implements SupportMenuItem {
  private static final int CHECKABLE = 1;
  
  private static final int CHECKED = 2;
  
  private static final int ENABLED = 16;
  
  private static final int EXCLUSIVE = 4;
  
  private static final int HIDDEN = 8;
  
  private static final int IS_ACTION = 32;
  
  static final int NO_ICON = 0;
  
  private static final int SHOW_AS_ACTION_MASK = 3;
  
  private static final String TAG = "MenuItemImpl";
  
  private static String sDeleteShortcutLabel;
  
  private static String sEnterShortcutLabel;
  
  private static String sPrependShortcutLabel;
  
  private static String sSpaceShortcutLabel;
  
  private ActionProvider mActionProvider;
  
  private View mActionView;
  
  private final int mCategoryOrder;
  
  private MenuItem.OnMenuItemClickListener mClickListener;
  
  private int mFlags = 16;
  
  private final int mGroup;
  
  private Drawable mIconDrawable;
  
  private int mIconResId = 0;
  
  private final int mId;
  
  private Intent mIntent;
  
  private boolean mIsActionViewExpanded = false;
  
  private Runnable mItemCallback;
  
  MenuBuilder mMenu;
  
  private ContextMenu.ContextMenuInfo mMenuInfo;
  
  private MenuItemCompat.OnActionExpandListener mOnActionExpandListener;
  
  private final int mOrdering;
  
  private char mShortcutAlphabeticChar;
  
  private char mShortcutNumericChar;
  
  private int mShowAsAction = 0;
  
  private SubMenuBuilder mSubMenu;
  
  private CharSequence mTitle;
  
  private CharSequence mTitleCondensed;
  
  MenuItemImpl(MenuBuilder paramMenuBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5) {
    this.mMenu = paramMenuBuilder;
    this.mId = paramInt2;
    this.mGroup = paramInt1;
    this.mCategoryOrder = paramInt3;
    this.mOrdering = paramInt4;
    this.mTitle = paramCharSequence;
    this.mShowAsAction = paramInt5;
  }
  
  public void actionFormatChanged() {
    this.mMenu.onItemActionRequestChanged(this);
  }
  
  public boolean collapseActionView() {
    if ((this.mShowAsAction & 0x8) != 0) {
      if (this.mActionView == null)
        return true; 
      if (this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionCollapse((MenuItem)this))
        return this.mMenu.collapseItemActionView(this); 
    } 
    return false;
  }
  
  public boolean expandActionView() {
    return (hasCollapsibleActionView() && (this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionExpand((MenuItem)this))) ? this.mMenu.expandItemActionView(this) : false;
  }
  
  public ActionProvider getActionProvider() {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public View getActionView() {
    if (this.mActionView != null)
      return this.mActionView; 
    if (this.mActionProvider != null) {
      this.mActionView = this.mActionProvider.onCreateActionView((MenuItem)this);
      return this.mActionView;
    } 
    return null;
  }
  
  public char getAlphabeticShortcut() {
    return this.mShortcutAlphabeticChar;
  }
  
  Runnable getCallback() {
    return this.mItemCallback;
  }
  
  public int getGroupId() {
    return this.mGroup;
  }
  
  public Drawable getIcon() {
    if (this.mIconDrawable != null)
      return this.mIconDrawable; 
    if (this.mIconResId != 0) {
      Drawable drawable = AppCompatResources.getDrawable(this.mMenu.getContext(), this.mIconResId);
      this.mIconResId = 0;
      this.mIconDrawable = drawable;
      return drawable;
    } 
    return null;
  }
  
  public Intent getIntent() {
    return this.mIntent;
  }
  
  @CapturedViewProperty
  public int getItemId() {
    return this.mId;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo() {
    return this.mMenuInfo;
  }
  
  public char getNumericShortcut() {
    return this.mShortcutNumericChar;
  }
  
  public int getOrder() {
    return this.mCategoryOrder;
  }
  
  public int getOrdering() {
    return this.mOrdering;
  }
  
  char getShortcut() {
    return this.mMenu.isQwertyMode() ? this.mShortcutAlphabeticChar : this.mShortcutNumericChar;
  }
  
  String getShortcutLabel() {
    char c = getShortcut();
    if (c == '\000')
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(sPrependShortcutLabel);
    switch (c) {
      default:
        stringBuilder.append(c);
        return stringBuilder.toString();
      case '\n':
        stringBuilder.append(sEnterShortcutLabel);
        return stringBuilder.toString();
      case '\b':
        stringBuilder.append(sDeleteShortcutLabel);
        return stringBuilder.toString();
      case ' ':
        break;
    } 
    stringBuilder.append(sSpaceShortcutLabel);
    return stringBuilder.toString();
  }
  
  public SubMenu getSubMenu() {
    return this.mSubMenu;
  }
  
  public ActionProvider getSupportActionProvider() {
    return this.mActionProvider;
  }
  
  @CapturedViewProperty
  public CharSequence getTitle() {
    return this.mTitle;
  }
  
  public CharSequence getTitleCondensed() {
    CharSequence charSequence1;
    if (this.mTitleCondensed != null) {
      charSequence1 = this.mTitleCondensed;
    } else {
      charSequence1 = this.mTitle;
    } 
    CharSequence charSequence2 = charSequence1;
    if (Build.VERSION.SDK_INT < 18) {
      charSequence2 = charSequence1;
      if (charSequence1 != null) {
        charSequence2 = charSequence1;
        if (!(charSequence1 instanceof String))
          charSequence2 = charSequence1.toString(); 
      } 
    } 
    return charSequence2;
  }
  
  CharSequence getTitleForItemView(MenuView.ItemView paramItemView) {
    return (paramItemView != null && paramItemView.prefersCondensedTitle()) ? getTitleCondensed() : getTitle();
  }
  
  public boolean hasCollapsibleActionView() {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.mShowAsAction & 0x8) != 0) {
      if (this.mActionView == null && this.mActionProvider != null)
        this.mActionView = this.mActionProvider.onCreateActionView((MenuItem)this); 
      bool1 = bool2;
      if (this.mActionView != null)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public boolean hasSubMenu() {
    return (this.mSubMenu != null);
  }
  
  public boolean invoke() {
    if ((this.mClickListener == null || !this.mClickListener.onMenuItemClick((MenuItem)this)) && !this.mMenu.dispatchMenuItemSelected(this.mMenu.getRootMenu(), (MenuItem)this)) {
      if (this.mItemCallback != null) {
        this.mItemCallback.run();
        return true;
      } 
      if (this.mIntent != null)
        try {
          this.mMenu.getContext().startActivity(this.mIntent);
          return true;
        } catch (ActivityNotFoundException activityNotFoundException) {
          Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", (Throwable)activityNotFoundException);
        }  
      if (this.mActionProvider == null || !this.mActionProvider.onPerformDefaultAction())
        return false; 
    } 
    return true;
  }
  
  public boolean isActionButton() {
    return ((this.mFlags & 0x20) == 32);
  }
  
  public boolean isActionViewExpanded() {
    return this.mIsActionViewExpanded;
  }
  
  public boolean isCheckable() {
    return ((this.mFlags & 0x1) == 1);
  }
  
  public boolean isChecked() {
    return ((this.mFlags & 0x2) == 2);
  }
  
  public boolean isEnabled() {
    return ((this.mFlags & 0x10) != 0);
  }
  
  public boolean isExclusiveCheckable() {
    return ((this.mFlags & 0x4) != 0);
  }
  
  public boolean isVisible() {
    return (this.mActionProvider != null && this.mActionProvider.overridesItemVisibility()) ? (!((this.mFlags & 0x8) != 0 || !this.mActionProvider.isVisible())) : (!((this.mFlags & 0x8) != 0));
  }
  
  public boolean requestsActionButton() {
    return ((this.mShowAsAction & 0x1) == 1);
  }
  
  public boolean requiresActionButton() {
    return ((this.mShowAsAction & 0x2) == 2);
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider) {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public SupportMenuItem setActionView(int paramInt) {
    Context context = this.mMenu.getContext();
    setActionView(LayoutInflater.from(context).inflate(paramInt, (ViewGroup)new LinearLayout(context), false));
    return this;
  }
  
  public SupportMenuItem setActionView(View paramView) {
    this.mActionView = paramView;
    this.mActionProvider = null;
    if (paramView != null && paramView.getId() == -1 && this.mId > 0)
      paramView.setId(this.mId); 
    this.mMenu.onItemActionRequestChanged(this);
    return this;
  }
  
  public void setActionViewExpanded(boolean paramBoolean) {
    this.mIsActionViewExpanded = paramBoolean;
    this.mMenu.onItemsChanged(false);
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar) {
    if (this.mShortcutAlphabeticChar == paramChar)
      return (MenuItem)this; 
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar);
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setCallback(Runnable paramRunnable) {
    this.mItemCallback = paramRunnable;
    return (MenuItem)this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean) {
    boolean bool;
    int i = this.mFlags;
    int j = this.mFlags;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mFlags = bool | j & 0xFFFFFFFE;
    if (i != this.mFlags)
      this.mMenu.onItemsChanged(false); 
    return (MenuItem)this;
  }
  
  public MenuItem setChecked(boolean paramBoolean) {
    if ((this.mFlags & 0x4) != 0) {
      this.mMenu.setExclusiveItemChecked((MenuItem)this);
      return (MenuItem)this;
    } 
    setCheckedInt(paramBoolean);
    return (MenuItem)this;
  }
  
  void setCheckedInt(boolean paramBoolean) {
    boolean bool;
    int i = this.mFlags;
    int j = this.mFlags;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mFlags = bool | j & 0xFFFFFFFD;
    if (i != this.mFlags)
      this.mMenu.onItemsChanged(false); 
  }
  
  public MenuItem setEnabled(boolean paramBoolean) {
    if (paramBoolean) {
      this.mFlags |= 0x10;
      this.mMenu.onItemsChanged(false);
      return (MenuItem)this;
    } 
    this.mFlags &= 0xFFFFFFEF;
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean) {
    boolean bool;
    int i = this.mFlags;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mFlags = bool | i & 0xFFFFFFFB;
  }
  
  public MenuItem setIcon(int paramInt) {
    this.mIconDrawable = null;
    this.mIconResId = paramInt;
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable) {
    this.mIconResId = 0;
    this.mIconDrawable = paramDrawable;
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setIntent(Intent paramIntent) {
    this.mIntent = paramIntent;
    return (MenuItem)this;
  }
  
  public void setIsActionButton(boolean paramBoolean) {
    if (paramBoolean) {
      this.mFlags |= 0x20;
      return;
    } 
    this.mFlags &= 0xFFFFFFDF;
  }
  
  void setMenuInfo(ContextMenu.ContextMenuInfo paramContextMenuInfo) {
    this.mMenuInfo = paramContextMenuInfo;
  }
  
  public MenuItem setNumericShortcut(char paramChar) {
    if (this.mShortcutNumericChar == paramChar)
      return (MenuItem)this; 
    this.mShortcutNumericChar = paramChar;
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener) {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
    this.mClickListener = paramOnMenuItemClickListener;
    return (MenuItem)this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2) {
    this.mShortcutNumericChar = paramChar1;
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar2);
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public void setShowAsAction(int paramInt) {
    switch (paramInt & 0x3) {
      default:
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
      case 0:
      case 1:
      case 2:
        break;
    } 
    this.mShowAsAction = paramInt;
    this.mMenu.onItemActionRequestChanged(this);
  }
  
  public SupportMenuItem setShowAsActionFlags(int paramInt) {
    setShowAsAction(paramInt);
    return this;
  }
  
  public void setSubMenu(SubMenuBuilder paramSubMenuBuilder) {
    this.mSubMenu = paramSubMenuBuilder;
    paramSubMenuBuilder.setHeaderTitle(getTitle());
  }
  
  public SupportMenuItem setSupportActionProvider(ActionProvider paramActionProvider) {
    if (this.mActionProvider != null)
      this.mActionProvider.reset(); 
    this.mActionView = null;
    this.mActionProvider = paramActionProvider;
    this.mMenu.onItemsChanged(true);
    if (this.mActionProvider != null)
      this.mActionProvider.setVisibilityListener(new ActionProvider.VisibilityListener() {
            public void onActionProviderVisibilityChanged(boolean param1Boolean) {
              MenuItemImpl.this.mMenu.onItemVisibleChanged(MenuItemImpl.this);
            }
          }); 
    return this;
  }
  
  public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener) {
    this.mOnActionExpandListener = paramOnActionExpandListener;
    return this;
  }
  
  public MenuItem setTitle(int paramInt) {
    return setTitle(this.mMenu.getContext().getString(paramInt));
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence) {
    this.mTitle = paramCharSequence;
    this.mMenu.onItemsChanged(false);
    if (this.mSubMenu != null)
      this.mSubMenu.setHeaderTitle(paramCharSequence); 
    return (MenuItem)this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence) {
    this.mTitleCondensed = paramCharSequence;
    if (paramCharSequence == null)
      paramCharSequence = this.mTitle; 
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setVisible(boolean paramBoolean) {
    if (setVisibleInt(paramBoolean))
      this.mMenu.onItemVisibleChanged(this); 
    return (MenuItem)this;
  }
  
  boolean setVisibleInt(boolean paramBoolean) {
    byte b;
    boolean bool = false;
    int i = this.mFlags;
    int j = this.mFlags;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    this.mFlags = b | j & 0xFFFFFFF7;
    paramBoolean = bool;
    if (i != this.mFlags)
      paramBoolean = true; 
    return paramBoolean;
  }
  
  public boolean shouldShowIcon() {
    return this.mMenu.getOptionalIconsVisible();
  }
  
  boolean shouldShowShortcut() {
    return (this.mMenu.isShortcutsVisible() && getShortcut() != '\000');
  }
  
  public boolean showsTextAsAction() {
    return ((this.mShowAsAction & 0x4) == 4);
  }
  
  public String toString() {
    return (this.mTitle != null) ? this.mTitle.toString() : null;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\view\menu\MenuItemImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */