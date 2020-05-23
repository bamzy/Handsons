package com.drms.drms_drone.CustomAdapter.CustomAdapter1;

import android.graphics.drawable.Drawable;

public class Custom1_Item {
  private Drawable icon;
  
  private String name;
  
  public Custom1_Item(Drawable paramDrawable, String paramString) {
    this.icon = paramDrawable;
    this.name = paramString;
  }
  
  public Drawable getIcon() {
    return this.icon;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.icon = paramDrawable;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\CustomAdapter\CustomAdapter1\Custom1_Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */