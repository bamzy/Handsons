package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

@TargetApi(16)
@RequiresApi(16)
class AccessibilityRecordCompatJellyBean {
  public static void setSource(Object paramObject, View paramView, int paramInt) {
    ((AccessibilityRecord)paramObject).setSource(paramView, paramInt);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityRecordCompatJellyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */