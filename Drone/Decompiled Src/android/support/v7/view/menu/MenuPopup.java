package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

abstract class MenuPopup implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {
  private Rect mEpicenterBounds;
  
  protected static int measureIndividualMenuWidth(ListAdapter paramListAdapter, ViewGroup paramViewGroup, Context paramContext, int paramInt) {
    int i = 0;
    ViewGroup viewGroup2 = null;
    int k = 0;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = paramListAdapter.getCount();
    int j = 0;
    ViewGroup viewGroup1 = paramViewGroup;
    paramViewGroup = viewGroup2;
    while (j < i1) {
      FrameLayout frameLayout2;
      int i3 = paramListAdapter.getItemViewType(j);
      int i2 = k;
      if (i3 != k) {
        i2 = i3;
        paramViewGroup = null;
      } 
      viewGroup2 = viewGroup1;
      if (viewGroup1 == null)
        frameLayout2 = new FrameLayout(paramContext); 
      View view = paramListAdapter.getView(j, (View)paramViewGroup, (ViewGroup)frameLayout2);
      view.measure(m, n);
      k = view.getMeasuredWidth();
      if (k >= paramInt)
        return paramInt; 
      i3 = i;
      if (k > i)
        i3 = k; 
      j++;
      k = i2;
      i = i3;
      FrameLayout frameLayout1 = frameLayout2;
    } 
    return i;
  }
  
  protected static boolean shouldPreserveIconSpacing(MenuBuilder paramMenuBuilder) {
    boolean bool = false;
    int j = paramMenuBuilder.size();
    for (int i = 0;; i++) {
      boolean bool1 = bool;
      if (i < j) {
        MenuItem menuItem = paramMenuBuilder.getItem(i);
        if (menuItem.isVisible() && menuItem.getIcon() != null)
          return true; 
      } else {
        return bool1;
      } 
    } 
  }
  
  protected static MenuAdapter toMenuAdapter(ListAdapter paramListAdapter) {
    return (paramListAdapter instanceof HeaderViewListAdapter) ? (MenuAdapter)((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter() : (MenuAdapter)paramListAdapter;
  }
  
  public abstract void addMenu(MenuBuilder paramMenuBuilder);
  
  protected boolean closeMenuOnSubMenuOpened() {
    return true;
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public Rect getEpicenterBounds() {
    return this.mEpicenterBounds;
  }
  
  public int getId() {
    return 0;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup) {
    throw new UnsupportedOperationException("MenuPopups manage their own views");
  }
  
  public void initForMenu(@NonNull Context paramContext, @Nullable MenuBuilder paramMenuBuilder) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    ListAdapter listAdapter = (ListAdapter)paramAdapterView.getAdapter();
    MenuBuilder menuBuilder = (toMenuAdapter(listAdapter)).mAdapterMenu;
    MenuItem menuItem = (MenuItem)listAdapter.getItem(paramInt);
    if (closeMenuOnSubMenuOpened()) {
      paramInt = 0;
    } else {
      paramInt = 4;
    } 
    menuBuilder.performItemAction(menuItem, this, paramInt);
  }
  
  public abstract void setAnchorView(View paramView);
  
  public void setEpicenterBounds(Rect paramRect) {
    this.mEpicenterBounds = paramRect;
  }
  
  public abstract void setForceShowIcon(boolean paramBoolean);
  
  public abstract void setGravity(int paramInt);
  
  public abstract void setHorizontalOffset(int paramInt);
  
  public abstract void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void setShowTitle(boolean paramBoolean);
  
  public abstract void setVerticalOffset(int paramInt);
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\view\menu\MenuPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */