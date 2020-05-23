package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

@TargetApi(14)
@RequiresApi(14)
class AccessibilityEventCompatIcs {
  public static void appendRecord(AccessibilityEvent paramAccessibilityEvent, Object paramObject) {
    paramAccessibilityEvent.appendRecord((AccessibilityRecord)paramObject);
  }
  
  public static Object getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt) {
    return paramAccessibilityEvent.getRecord(paramInt);
  }
  
  public static int getRecordCount(AccessibilityEvent paramAccessibilityEvent) {
    return paramAccessibilityEvent.getRecordCount();
  }
  
  public static void setScrollable(AccessibilityEvent paramAccessibilityEvent, boolean paramBoolean) {
    paramAccessibilityEvent.setScrollable(paramBoolean);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityEventCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */