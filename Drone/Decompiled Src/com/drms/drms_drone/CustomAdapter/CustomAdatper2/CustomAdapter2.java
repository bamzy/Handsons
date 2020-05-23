package com.drms.drms_drone.CustomAdapter.CustomAdatper2;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter2 extends BaseAdapter {
  private Context mContext;
  
  private List<Custom2_Item> mItems = new ArrayList<Custom2_Item>();
  
  public CustomAdapter2(Context paramContext) {
    this.mContext = paramContext;
  }
  
  public void addItem(Custom2_Item paramCustom2_Item) {
    this.mItems.add(paramCustom2_Item);
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
      custom2_View = new Custom2_View(this.mContext, this.mItems.get(paramInt));
      custom2_View.setIcon(((Custom2_Item)this.mItems.get(paramInt)).getIcon());
      custom2_View.setText(0, ((Custom2_Item)this.mItems.get(paramInt)).getData(0));
      custom2_View.setText(1, ((Custom2_Item)this.mItems.get(paramInt)).getData(1));
      return (View)custom2_View;
    } 
    Custom2_View custom2_View = custom2_View;
    custom2_View.setIcon(((Custom2_Item)this.mItems.get(paramInt)).getIcon());
    custom2_View.setText(0, ((Custom2_Item)this.mItems.get(paramInt)).getData(0));
    custom2_View.setText(1, ((Custom2_Item)this.mItems.get(paramInt)).getData(1));
    return (View)custom2_View;
  }
  
  public void removeItem() {
    while (this.mItems.size() > 0)
      this.mItems.remove(0); 
    Log.d("ContentValues", "remove size : " + this.mItems.size());
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\CustomAdapter\CustomAdatper2\CustomAdapter2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */