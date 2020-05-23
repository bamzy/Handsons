package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;

@TargetApi(14)
@RequiresApi(14)
class MotionEventCompatICS {
  public static int getButtonState(MotionEvent paramMotionEvent) {
    return paramMotionEvent.getButtonState();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\MotionEventCompatICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */