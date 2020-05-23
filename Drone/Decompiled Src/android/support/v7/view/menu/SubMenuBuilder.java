package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
  private MenuItemImpl mItem;
  
  private MenuBuilder mParentMenu;
  
  public SubMenuBuilder(Context paramContext, MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    super(paramContext);
    this.mParentMenu = paramMenuBuilder;
    this.mItem = paramMenuItemImpl;
  }
  
  public boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl) {
    return this.mParentMenu.collapseItemActionView(paramMenuItemImpl);
  }
  
  boolean dispatchMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    return (super.dispatchMenuItemSelected(paramMenuBuilder, paramMenuItem) || this.mParentMenu.dispatchMenuItemSelected(paramMenuBuilder, paramMenuItem));
  }
  
  public boolean expandItemActionView(MenuItemImpl paramMenuItemImpl) {
    return this.mParentMenu.expandItemActionView(paramMenuItemImpl);
  }
  
  public String getActionViewStatesKey() {
    boolean bool;
    if (this.mItem != null) {
      bool = this.mItem.getItemId();
    } else {
      bool = false;
    } 
    return !bool ? null : (super.getActionViewStatesKey() + ":" + bool);
  }
  
  public MenuItem getItem() {
    return (MenuItem)this.mItem;
  }
  
  public Menu getParentMenu() {
    return (Menu)this.mParentMenu;
  }
  
  public MenuBuilder getRootMenu() {
    return this.mParentMenu.getRootMenu();
  }
  
  public boolean isQwertyMode() {
    return this.mParentMenu.isQwertyMode();
  }
  
  public boolean isShortcutsVisible() {
    return this.mParentMenu.isShortcutsVisible();
  }
  
  public void setCallback(MenuBuilder.Callback paramCallback) {
    this.mParentMenu.setCallback(paramCallback);
  }
  
  public SubMenu setHeaderIcon(int paramInt) {
    return (SubMenu)setHeaderIconInt(paramInt);
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable) {
    return (SubMenu)setHeaderIconInt(paramDrawable);
  }
  
  public SubMenu setHeaderTitle(int paramInt) {
    return (SubMenu)setHeaderTitleInt(paramInt);
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence) {
    return (SubMenu)setHeaderTitleInt(paramCharSequence);
  }
  
  public SubMenu setHeaderView(View paramView) {
    return (SubMenu)setHeaderViewInt(paramView);
  }
  
  public SubMenu setIcon(int paramInt) {
    this.mItem.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable) {
    this.mItem.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean) {
    this.mParentMenu.setQwertyMode(paramBoolean);
  }
  
  public void setShortcutsVisible(boolean paramBoolean) {
    this.mParentMenu.setShortcutsVisible(paramBoolean);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\view\menu\SubMenuBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */