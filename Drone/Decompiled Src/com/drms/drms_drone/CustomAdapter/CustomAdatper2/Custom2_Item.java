package com.drms.drms_drone.CustomAdapter.CustomAdatper2;

import android.graphics.drawable.Drawable;

public class Custom2_Item {
  private String[] mData;
  
  private Drawable mIcon;
  
  public Custom2_Item(Drawable paramDrawable, String paramString1, String paramString2) {
    this.mIcon = paramDrawable;
    this.mData = new String[2];
    if (paramString1 != null) {
      this.mData[0] = paramString1;
    } else {
      this.mData[0] = "Unknown";
    } 
    this.mData[1] = paramString2;
  }
  
  public Custom2_Item(Drawable paramDrawable, String[] paramArrayOfString) {
    this.mIcon = paramDrawable;
    this.mData = paramArrayOfString;
  }
  
  public Custom2_Item(String paramString) {
    this.mData[0] = paramString;
  }
  
  public String getData(int paramInt) {
    return (this.mData == null || paramInt >= this.mData.length) ? null : this.mData[paramInt];
  }
  
  public String[] getData() {
    return this.mData;
  }
  
  public Drawable getIcon() {
    return this.mIcon;
  }
  
  public void setData(String[] paramArrayOfString) {
    this.mData = paramArrayOfString;
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.mIcon = paramDrawable;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\CustomAdapter\CustomAdatper2\Custom2_Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */