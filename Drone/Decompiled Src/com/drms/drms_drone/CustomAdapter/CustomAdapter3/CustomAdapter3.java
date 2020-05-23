package com.drms.drms_drone.CustomAdapter.CustomAdapter3;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter3 extends BaseAdapter {
  private Context mContext;
  
  private List<Custom3_Item> mItems = new ArrayList<Custom3_Item>();
  
  public CustomAdapter3(Context paramContext) {
    this.mContext = paramContext;
  }
  
  public void addItem(Custom3_Item paramCustom3_Item) {
    this.mItems.add(paramCustom3_Item);
  }
  
  public int getCount() {
    return this.mItems.size();
  }
  
  public Object getItem(int paramInt) {
    return this.mItems.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      custom3_View = new Custom3_View(this.mContext, this.mItems.get(paramInt));
      custom3_View.setIcon(((Custom3_Item)this.mItems.get(paramInt)).getIcon());
      custom3_View.setText(0, ((Custom3_Item)this.mItems.get(paramInt)).getData(0));
      custom3_View.setText(1, ((Custom3_Item)this.mItems.get(paramInt)).getData(1));
      return (View)custom3_View;
    } 
    Custom3_View custom3_View = custom3_View;
    custom3_View.setIcon(((Custom3_Item)this.mItems.get(paramInt)).getIcon());
    custom3_View.setText(0, ((Custom3_Item)this.mItems.get(paramInt)).getData(0));
    custom3_View.setText(1, ((Custom3_Item)this.mItems.get(paramInt)).getData(1));
    return (View)custom3_View;
  }
  
  public void removeItem() {
    while (this.mItems.size() > 0)
      this.mItems.remove(0); 
    Log.d("ContentValues", "remove size : " + this.mItems.size());
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\CustomAdapter\CustomAdapter3\CustomAdapter3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */