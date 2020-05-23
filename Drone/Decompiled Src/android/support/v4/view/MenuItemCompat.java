package android.support.v4.view;

import android.os.Build;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class MenuItemCompat {
  static final MenuVersionImpl IMPL = new BaseMenuVersionImpl();
  
  public static final int SHOW_AS_ACTION_ALWAYS = 2;
  
  public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
  
  public static final int SHOW_AS_ACTION_IF_ROOM = 1;
  
  public static final int SHOW_AS_ACTION_NEVER = 0;
  
  public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
  
  private static final String TAG = "MenuItemCompat";
  
  public static boolean collapseActionView(MenuItem paramMenuItem) {
    return (paramMenuItem instanceof SupportMenuItem) ? ((SupportMenuItem)paramMenuItem).collapseActionView() : IMPL.collapseActionView(paramMenuItem);
  }
  
  public static boolean expandActionView(MenuItem paramMenuItem) {
    return (paramMenuItem instanceof SupportMenuItem) ? ((SupportMenuItem)paramMenuItem).expandActionView() : IMPL.expandActionView(paramMenuItem);
  }
  
  public static ActionProvider getActionProvider(MenuItem paramMenuItem) {
    if (paramMenuItem instanceof SupportMenuItem)
      return ((SupportMenuItem)paramMenuItem).getSupportActionProvider(); 
    Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
    return null;
  }
  
  public static View getActionView(MenuItem paramMenuItem) {
    return (paramMenuItem instanceof SupportMenuItem) ? ((SupportMenuItem)paramMenuItem).getActionView() : IMPL.getActionView(paramMenuItem);
  }
  
  public static boolean isActionViewExpanded(MenuItem paramMenuItem) {
    return (paramMenuItem instanceof SupportMenuItem) ? ((SupportMenuItem)paramMenuItem).isActionViewExpanded() : IMPL.isActionViewExpanded(paramMenuItem);
  }
  
  public static MenuItem setActionProvider(MenuItem paramMenuItem, ActionProvider paramActionProvider) {
    if (paramMenuItem instanceof SupportMenuItem)
      return (MenuItem)((SupportMenuItem)paramMenuItem).setSupportActionProvider(paramActionProvider); 
    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
    return paramMenuItem;
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, int paramInt) {
    return (paramMenuItem instanceof SupportMenuItem) ? ((SupportMenuItem)paramMenuItem).setActionView(paramInt) : IMPL.setActionView(paramMenuItem, paramInt);
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, View paramView) {
    return (paramMenuItem instanceof SupportMenuItem) ? ((SupportMenuItem)paramMenuItem).setActionView(paramView) : IMPL.setActionView(paramMenuItem, paramView);
  }
  
  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, OnActionExpandListener paramOnActionExpandListener) {
    return (MenuItem)((paramMenuItem instanceof SupportMenuItem) ? ((SupportMenuItem)paramMenuItem).setSupportOnActionExpandListener(paramOnActionExpandListener) : IMPL.setOnActionExpandListener(paramMenuItem, paramOnActionExpandListener));
  }
  
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt) {
    if (paramMenuItem instanceof SupportMenuItem) {
      ((SupportMenuItem)paramMenuItem).setShowAsAction(paramInt);
      return;
    } 
    IMPL.setShowAsAction(paramMenuItem, paramInt);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new IcsMenuVersionImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 11) {
      IMPL = new HoneycombMenuVersionImpl();
      return;
    } 
  }
  
  static class BaseMenuVersionImpl implements MenuVersionImpl {
    public boolean collapseActionView(MenuItem param1MenuItem) {
      return false;
    }
    
    public boolean expandActionView(MenuItem param1MenuItem) {
      return false;
    }
    
    public View getActionView(MenuItem param1MenuItem) {
      return null;
    }
    
    public boolean isActionViewExpanded(MenuItem param1MenuItem) {
      return false;
    }
    
    public MenuItem setActionView(MenuItem param1MenuItem, int param1Int) {
      return param1MenuItem;
    }
    
    public MenuItem setActionView(MenuItem param1MenuItem, View param1View) {
      return param1MenuItem;
    }
    
    public MenuItem setOnActionExpandListener(MenuItem param1MenuItem, MenuItemCompat.OnActionExpandListener param1OnActionExpandListener) {
      return param1MenuItem;
    }
    
    public void setShowAsAction(MenuItem param1MenuItem, int param1Int) {}
  }
  
  static class HoneycombMenuVersionImpl implements MenuVersionImpl {
    public boolean collapseActionView(MenuItem param1MenuItem) {
      return false;
    }
    
    public boolean expandActionView(MenuItem param1MenuItem) {
      return false;
    }
    
    public View getActionView(MenuItem param1MenuItem) {
      return MenuItemCompatHoneycomb.getActionView(param1MenuItem);
    }
    
    public boolean isActionViewExpanded(MenuItem param1MenuItem) {
      return false;
    }
    
    public MenuItem setActionView(MenuItem param1MenuItem, int param1Int) {
      return MenuItemCompatHoneycomb.setActionView(param1MenuItem, param1Int);
    }
    
    public MenuItem setActionView(MenuItem param1MenuItem, View param1View) {
      return MenuItemCompatHoneycomb.setActionView(param1MenuItem, param1View);
    }
    
    public MenuItem setOnActionExpandListener(MenuItem param1MenuItem, MenuItemCompat.OnActionExpandListener param1OnActionExpandListener) {
      return param1MenuItem;
    }
    
    public void setShowAsAction(MenuItem param1MenuItem, int param1Int) {
      MenuItemCompatHoneycomb.setShowAsAction(param1MenuItem, param1Int);
    }
  }
  
  static class IcsMenuVersionImpl extends HoneycombMenuVersionImpl {
    public boolean collapseActionView(MenuItem param1MenuItem) {
      return MenuItemCompatIcs.collapseActionView(param1MenuItem);
    }
    
    public boolean expandActionView(MenuItem param1MenuItem) {
      return MenuItemCompatIcs.expandActionView(param1MenuItem);
    }
    
    public boolean isActionViewExpanded(MenuItem param1MenuItem) {
      return MenuItemCompatIcs.isActionViewExpanded(param1MenuItem);
    }
    
    public MenuItem setOnActionExpandListener(MenuItem param1MenuItem, final MenuItemCompat.OnActionExpandListener listener) {
      return (listener == null) ? MenuItemCompatIcs.setOnActionExpandListener(param1MenuItem, null) : MenuItemCompatIcs.setOnActionExpandListener(param1MenuItem, new MenuItemCompatIcs.SupportActionExpandProxy() {
            public boolean onMenuItemActionCollapse(MenuItem param2MenuItem) {
              return listener.onMenuItemActionCollapse(param2MenuItem);
            }
            
            public boolean onMenuItemActionExpand(MenuItem param2MenuItem) {
              return listener.onMenuItemActionExpand(param2MenuItem);
            }
          });
    }
  }
  
  class null implements MenuItemCompatIcs.SupportActionExpandProxy {
    public boolean onMenuItemActionCollapse(MenuItem param1MenuItem) {
      return listener.onMenuItemActionCollapse(param1MenuItem);
    }
    
    public boolean onMenuItemActionExpand(MenuItem param1MenuItem) {
      return listener.onMenuItemActionExpand(param1MenuItem);
    }
  }
  
  static interface MenuVersionImpl {
    boolean collapseActionView(MenuItem param1MenuItem);
    
    boolean expandActionView(MenuItem param1MenuItem);
    
    View getActionView(MenuItem param1MenuItem);
    
    boolean isActionViewExpanded(MenuItem param1MenuItem);
    
    MenuItem setActionView(MenuItem param1MenuItem, int param1Int);
    
    MenuItem setActionView(MenuItem param1MenuItem, View param1View);
    
    MenuItem setOnActionExpandListener(MenuItem param1MenuItem, MenuItemCompat.OnActionExpandListener param1OnActionExpandListener);
    
    void setShowAsAction(MenuItem param1MenuItem, int param1Int);
  }
  
  public static interface OnActionExpandListener {
    boolean onMenuItemActionCollapse(MenuItem param1MenuItem);
    
    boolean onMenuItemActionExpand(MenuItem param1MenuItem);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\MenuItemCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */