package android.support.v7.view.menu;

import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MenuAdapter extends BaseAdapter {
  static final int ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;
  
  MenuBuilder mAdapterMenu;
  
  private int mExpandedIndex = -1;
  
  private boolean mForceShowIcon;
  
  private final LayoutInflater mInflater;
  
  private final boolean mOverflowOnly;
  
  public MenuAdapter(MenuBuilder paramMenuBuilder, LayoutInflater paramLayoutInflater, boolean paramBoolean) {
    this.mOverflowOnly = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.mAdapterMenu = paramMenuBuilder;
    findExpandedIndex();
  }
  
  void findExpandedIndex() {
    MenuItemImpl menuItemImpl = this.mAdapterMenu.getExpandedItem();
    if (menuItemImpl != null) {
      ArrayList<MenuItemImpl> arrayList = this.mAdapterMenu.getNonActionItems();
      int j = arrayList.size();
      for (int i = 0; i < j; i++) {
        if ((MenuItemImpl)arrayList.get(i) == menuItemImpl) {
          this.mExpandedIndex = i;
          return;
        } 
      } 
    } 
    this.mExpandedIndex = -1;
  }
  
  public MenuBuilder getAdapterMenu() {
    return this.mAdapterMenu;
  }
  
  public int getCount() {
    ArrayList<MenuItemImpl> arrayList;
    if (this.mOverflowOnly) {
      arrayList = this.mAdapterMenu.getNonActionItems();
    } else {
      arrayList = this.mAdapterMenu.getVisibleItems();
    } 
    return (this.mExpandedIndex < 0) ? arrayList.size() : (arrayList.size() - 1);
  }
  
  public boolean getForceShowIcon() {
    return this.mForceShowIcon;
  }
  
  public MenuItemImpl getItem(int paramInt) {
    ArrayList<MenuItemImpl> arrayList;
    if (this.mOverflowOnly) {
      arrayList = this.mAdapterMenu.getNonActionItems();
    } else {
      arrayList = this.mAdapterMenu.getVisibleItems();
    } 
    int i = paramInt;
    if (this.mExpandedIndex >= 0) {
      i = paramInt;
      if (paramInt >= this.mExpandedIndex)
        i = paramInt + 1; 
    } 
    return arrayList.get(i);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view = paramView;
    if (paramView == null)
      view = this.mInflater.inflate(ITEM_LAYOUT, paramViewGroup, false); 
    MenuView.ItemView itemView = (MenuView.ItemView)view;
    if (this.mForceShowIcon)
      ((ListMenuItemView)view).setForceShowIcon(true); 
    itemView.initialize(getItem(paramInt), 0);
    return view;
  }
  
  public void notifyDataSetChanged() {
    findExpandedIndex();
    super.notifyDataSetChanged();
  }
  
  public void setForceShowIcon(boolean paramBoolean) {
    this.mForceShowIcon = paramBoolean;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\view\menu\MenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */