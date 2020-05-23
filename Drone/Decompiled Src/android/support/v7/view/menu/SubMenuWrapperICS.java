package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

@TargetApi(14)
@RequiresApi(14)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
  SubMenuWrapperICS(Context paramContext, SupportSubMenu paramSupportSubMenu) {
    super(paramContext, (SupportMenu)paramSupportSubMenu);
  }
  
  public void clearHeader() {
    getWrappedObject().clearHeader();
  }
  
  public MenuItem getItem() {
    return getMenuItemWrapper(getWrappedObject().getItem());
  }
  
  public SupportSubMenu getWrappedObject() {
    return (SupportSubMenu)this.mWrappedObject;
  }
  
  public SubMenu setHeaderIcon(int paramInt) {
    getWrappedObject().setHeaderIcon(paramInt);
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable) {
    getWrappedObject().setHeaderIcon(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt) {
    getWrappedObject().setHeaderTitle(paramInt);
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence) {
    getWrappedObject().setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView) {
    getWrappedObject().setHeaderView(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt) {
    getWrappedObject().setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable) {
    getWrappedObject().setIcon(paramDrawable);
    return this;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\view\menu\SubMenuWrapperICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */