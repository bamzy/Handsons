package android.support.v4.internal.view;

import android.support.annotation.RestrictTo;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.view.MenuItem;
import android.view.View;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface SupportMenuItem extends MenuItem {
  public static final int SHOW_AS_ACTION_ALWAYS = 2;
  
  public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
  
  public static final int SHOW_AS_ACTION_IF_ROOM = 1;
  
  public static final int SHOW_AS_ACTION_NEVER = 0;
  
  public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
  
  boolean collapseActionView();
  
  boolean expandActionView();
  
  View getActionView();
  
  ActionProvider getSupportActionProvider();
  
  boolean isActionViewExpanded();
  
  MenuItem setActionView(int paramInt);
  
  MenuItem setActionView(View paramView);
  
  void setShowAsAction(int paramInt);
  
  MenuItem setShowAsActionFlags(int paramInt);
  
  SupportMenuItem setSupportActionProvider(ActionProvider paramActionProvider);
  
  SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener);
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\internal\view\SupportMenuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */