package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.annotation.RequiresApi;
import android.widget.CompoundButton;

@TargetApi(21)
@RequiresApi(21)
class CompoundButtonCompatLollipop {
  static ColorStateList getButtonTintList(CompoundButton paramCompoundButton) {
    return paramCompoundButton.getButtonTintList();
  }
  
  static PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton) {
    return paramCompoundButton.getButtonTintMode();
  }
  
  static void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList) {
    paramCompoundButton.setButtonTintList(paramColorStateList);
  }
  
  static void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode) {
    paramCompoundButton.setButtonTintMode(paramMode);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\CompoundButtonCompatLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */