package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.support.annotation.RequiresApi;

@TargetApi(19)
@RequiresApi(19)
class ActivityManagerCompatKitKat {
  public static boolean isLowRamDevice(ActivityManager paramActivityManager) {
    return paramActivityManager.isLowRamDevice();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ActivityManagerCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */