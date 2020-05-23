package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

class TintInfo {
  public boolean mHasTintList;
  
  public boolean mHasTintMode;
  
  public ColorStateList mTintList;
  
  public PorterDuff.Mode mTintMode;
  
  void clear() {
    this.mTintList = null;
    this.mHasTintList = false;
    this.mTintMode = null;
    this.mHasTintMode = false;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\TintInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */