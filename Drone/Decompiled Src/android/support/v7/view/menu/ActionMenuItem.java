package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ActionMenuItem implements SupportMenuItem {
  private static final int CHECKABLE = 1;
  
  private static final int CHECKED = 2;
  
  private static final int ENABLED = 16;
  
  private static final int EXCLUSIVE = 4;
  
  private static final int HIDDEN = 8;
  
  private static final int NO_ICON = 0;
  
  private final int mCategoryOrder;
  
  private MenuItem.OnMenuItemClickListener mClickListener;
  
  private Context mContext;
  
  private int mFlags = 16;
  
  private final int mGroup;
  
  private Drawable mIconDrawable;
  
  private int mIconResId = 0;
  
  private final int mId;
  
  private Intent mIntent;
  
  private final int mOrdering;
  
  private char mShortcutAlphabeticChar;
  
  private char mShortcutNumericChar;
  
  private CharSequence mTitle;
  
  private CharSequence mTitleCondensed;
  
  public ActionMenuItem(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence) {
    this.mContext = paramContext;
    this.mId = paramInt2;
    this.mGroup = paramInt1;
    this.mCategoryOrder = paramInt3;
    this.mOrdering = paramInt4;
    this.mTitle = paramCharSequence;
  }
  
  public boolean collapseActionView() {
    return false;
  }
  
  public boolean expandActionView() {
    return false;
  }
  
  public ActionProvider getActionProvider() {
    throw new UnsupportedOperationException();
  }
  
  public View getActionView() {
    return null;
  }
  
  public char getAlphabeticShortcut() {
    return this.mShortcutAlphabeticChar;
  }
  
  public int getGroupId() {
    return this.mGroup;
  }
  
  public Drawable getIcon() {
    return this.mIconDrawable;
  }
  
  public Intent getIntent() {
    return this.mIntent;
  }
  
  public int getItemId() {
    return this.mId;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo() {
    return null;
  }
  
  public char getNumericShortcut() {
    return this.mShortcutNumericChar;
  }
  
  public int getOrder() {
    return this.mOrdering;
  }
  
  public SubMenu getSubMenu() {
    return null;
  }
  
  public ActionProvider getSupportActionProvider() {
    return null;
  }
  
  public CharSequence getTitle() {
    return this.mTitle;
  }
  
  public CharSequence getTitleCondensed() {
    return (this.mTitleCondensed != null) ? this.mTitleCondensed : this.mTitle;
  }
  
  public boolean hasSubMenu() {
    return false;
  }
  
  public boolean invoke() {
    if (this.mClickListener != null && this.mClickListener.onMenuItemClick((MenuItem)this))
      return true; 
    if (this.mIntent != null) {
      this.mContext.startActivity(this.mIntent);
      return true;
    } 
    return false;
  }
  
  public boolean isActionViewExpanded() {
    return false;
  }
  
  public boolean isCheckable() {
    return ((this.mFlags & 0x1) != 0);
  }
  
  public boolean isChecked() {
    return ((this.mFlags & 0x2) != 0);
  }
  
  public boolean isEnabled() {
    return ((this.mFlags & 0x10) != 0);
  }
  
  public boolean isVisible() {
    return ((this.mFlags & 0x8) == 0);
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider) {
    throw new UnsupportedOperationException();
  }
  
  public SupportMenuItem setActionView(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public SupportMenuItem setActionView(View paramView) {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar) {
    this.mShortcutAlphabeticChar = paramChar;
    return (MenuItem)this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean) {
    int i = this.mFlags;
    if (paramBoolean) {
      boolean bool1 = true;
      this.mFlags = bool1 | i & 0xFFFFFFFE;
      return (MenuItem)this;
    } 
    boolean bool = false;
    this.mFlags = bool | i & 0xFFFFFFFE;
    return (MenuItem)this;
  }
  
  public MenuItem setChecked(boolean paramBoolean) {
    int i = this.mFlags;
    if (paramBoolean) {
      byte b = 2;
      this.mFlags = b | i & 0xFFFFFFFD;
      return (MenuItem)this;
    } 
    boolean bool = false;
    this.mFlags = bool | i & 0xFFFFFFFD;
    return (MenuItem)this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean) {
    int i = this.mFlags;
    if (paramBoolean) {
      byte b = 16;
      this.mFlags = b | i & 0xFFFFFFEF;
      return (MenuItem)this;
    } 
    boolean bool = false;
    this.mFlags = bool | i & 0xFFFFFFEF;
    return (MenuItem)this;
  }
  
  public ActionMenuItem setExclusiveCheckable(boolean paramBoolean) {
    int i = this.mFlags;
    if (paramBoolean) {
      byte b = 4;
      this.mFlags = b | i & 0xFFFFFFFB;
      return this;
    } 
    boolean bool = false;
    this.mFlags = bool | i & 0xFFFFFFFB;
    return this;
  }
  
  public MenuItem setIcon(int paramInt) {
    this.mIconResId = paramInt;
    this.mIconDrawable = ContextCompat.getDrawable(this.mContext, paramInt);
    return (MenuItem)this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable) {
    this.mIconDrawable = paramDrawable;
    this.mIconResId = 0;
    return (MenuItem)this;
  }
  
  public MenuItem setIntent(Intent paramIntent) {
    this.mIntent = paramIntent;
    return (MenuItem)this;
  }
  
  public MenuItem setNumericShortcut(char paramChar) {
    this.mShortcutNumericChar = paramChar;
    return (MenuItem)this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener) {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
    this.mClickListener = paramOnMenuItemClickListener;
    return (MenuItem)this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2) {
    this.mShortcutNumericChar = paramChar1;
    this.mShortcutAlphabeticChar = paramChar2;
    return (MenuItem)this;
  }
  
  public void setShowAsAction(int paramInt) {}
  
  public SupportMenuItem setShowAsActionFlags(int paramInt) {
    setShowAsAction(paramInt);
    return this;
  }
  
  public SupportMenuItem setSupportActionProvider(ActionProvider paramActionProvider) {
    throw new UnsupportedOperationException();
  }
  
  public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener) {
    return this;
  }
  
  public MenuItem setTitle(int paramInt) {
    this.mTitle = this.mContext.getResources().getString(paramInt);
    return (MenuItem)this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence) {
    this.mTitle = paramCharSequence;
    return (MenuItem)this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence) {
    this.mTitleCondensed = paramCharSequence;
    return (MenuItem)this;
  }
  
  public MenuItem setVisible(boolean paramBoolean) {
    int i = this.mFlags;
    if (paramBoolean) {
      boolean bool = false;
      this.mFlags = bool | i & 0x8;
      return (MenuItem)this;
    } 
    byte b = 8;
    this.mFlags = b | i & 0x8;
    return (MenuItem)this;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\view\menu\ActionMenuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */