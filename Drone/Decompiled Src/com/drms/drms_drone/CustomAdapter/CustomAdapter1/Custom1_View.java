package com.drms.drms_drone.CustomAdapter.CustomAdapter1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Custom1_View extends LinearLayout {
  ImageView icon;
  
  TextView name;
  
  public Custom1_View(Context paramContext, Custom1_Item paramCustom1_Item) {
    super(paramContext);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968615, (ViewGroup)this, true);
    this.icon = (ImageView)findViewById(2131558452);
    this.icon.setImageDrawable(paramCustom1_Item.getIcon());
    this.name = (TextView)findViewById(2131558539);
    this.name.setText(paramCustom1_Item.getName());
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.icon.setImageDrawable(paramDrawable);
  }
  
  public void setName(String paramString) {
    this.name.setText(paramString);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\CustomAdapter\CustomAdapter1\Custom1_View.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */