package com.drms.drms_drone.CustomAdapter.CustomAdapter3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Custom3_View extends LinearLayout {
  ImageView mIcon;
  
  public TextView mtext01;
  
  TextView mtext02;
  
  public Custom3_View(Context paramContext, Custom3_Item paramCustom3_Item) {
    super(paramContext);
    setBackgroundColor(paramContext.getResources().getColor(2131492865));
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968617, (ViewGroup)this, true);
    this.mIcon = (ImageView)findViewById(2131558540);
    this.mIcon.setImageDrawable(paramCustom3_Item.getIcon());
    this.mtext01 = (TextView)findViewById(2131558541);
    this.mtext01.setText(paramCustom3_Item.getData(0));
    this.mtext02 = (TextView)findViewById(2131558542);
    this.mtext02.setText(paramCustom3_Item.getData(1));
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.mIcon.setImageDrawable(paramDrawable);
  }
  
  public void setText(int paramInt, String paramString) {
    if (paramInt == 0) {
      this.mtext01.setText(paramString);
      return;
    } 
    if (paramInt == 1) {
      this.mtext02.setText(paramString);
      return;
    } 
    throw new IllegalArgumentException();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\CustomAdapter\CustomAdapter3\Custom3_View.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */