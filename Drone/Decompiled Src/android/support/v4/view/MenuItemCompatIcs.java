package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.MenuItem;

@TargetApi(14)
@RequiresApi(14)
class MenuItemCompatIcs {
  public static boolean collapseActionView(MenuItem paramMenuItem) {
    return paramMenuItem.collapseActionView();
  }
  
  public static boolean expandActionView(MenuItem paramMenuItem) {
    return paramMenuItem.expandActionView();
  }
  
  public static boolean isActionViewExpanded(MenuItem paramMenuItem) {
    return paramMenuItem.isActionViewExpanded();
  }
  
  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, SupportActionExpandProxy paramSupportActionExpandProxy) {
    return paramMenuItem.setOnActionExpandListener(new OnActionExpandListenerWrapper(paramSupportActionExpandProxy));
  }
  
  static class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
    private MenuItemCompatIcs.SupportActionExpandProxy mWrapped;
    
    public OnActionExpandListenerWrapper(MenuItemCompatIcs.SupportActionExpandProxy param1SupportActionExpandProxy) {
      this.mWrapped = param1SupportActionExpandProxy;
    }
    
    public boolean onMenuItemActionCollapse(MenuItem param1MenuItem) {
      return this.mWrapped.onMenuItemActionCollapse(param1MenuItem);
    }
    
    public boolean onMenuItemActionExpand(MenuItem param1MenuItem) {
      return this.mWrapped.onMenuItemActionExpand(param1MenuItem);
    }
  }
  
  static interface SupportActionExpandProxy {
    boolean onMenuItemActionCollapse(MenuItem param1MenuItem);
    
    boolean onMenuItemActionExpand(MenuItem param1MenuItem);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\MenuItemCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */