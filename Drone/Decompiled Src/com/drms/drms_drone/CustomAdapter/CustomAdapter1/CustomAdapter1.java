package com.drms.drms_drone.CustomAdapter.CustomAdapter1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter1 extends BaseAdapter {
  private List<Custom1_Item> IconBox = new ArrayList<Custom1_Item>();
  
  private Context mContext;
  
  public CustomAdapter1(Context paramContext) {
    this.mContext = paramContext;
  }
  
  public void addItem(Custom1_Item paramCustom1_Item) {
    this.IconBox.add(paramCustom1_Item);
  }
  
  public int getCount() {
    return this.IconBox.size();
  }
  
  public Object getItem(int paramInt) {
    return this.IconBox.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      custom1_View = new Custom1_View(this.mContext, this.IconBox.get(paramInt));
      custom1_View.setIcon(((Custom1_Item)this.IconBox.get(paramInt)).getIcon());
      custom1_View.setName(((Custom1_Item)this.IconBox.get(paramInt)).getName());
      return (View)custom1_View;
    } 
    Custom1_View custom1_View = custom1_View;
    custom1_View.setIcon(((Custom1_Item)this.IconBox.get(paramInt)).getIcon());
    custom1_View.setName(((Custom1_Item)this.IconBox.get(paramInt)).getName());
    return (View)custom1_View;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\CustomAdapter\CustomAdapter1\CustomAdapter1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */