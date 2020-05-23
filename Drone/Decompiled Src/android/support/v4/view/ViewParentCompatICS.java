package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

@TargetApi(14)
@RequiresApi(14)
class ViewParentCompatICS {
  public static boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return paramViewParent.requestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewParentCompatICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */