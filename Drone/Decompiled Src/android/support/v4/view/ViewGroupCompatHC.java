package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

@TargetApi(11)
@RequiresApi(11)
class ViewGroupCompatHC {
  public static void setMotionEventSplittingEnabled(ViewGroup paramViewGroup, boolean paramBoolean) {
    paramViewGroup.setMotionEventSplittingEnabled(paramBoolean);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewGroupCompatHC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */