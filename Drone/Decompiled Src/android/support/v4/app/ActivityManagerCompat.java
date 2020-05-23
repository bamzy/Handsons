package android.support.v4.app;

import android.app.ActivityManager;
import android.os.Build;
import android.support.annotation.NonNull;

public final class ActivityManagerCompat {
  public static boolean isLowRamDevice(@NonNull ActivityManager paramActivityManager) {
    return (Build.VERSION.SDK_INT >= 19) ? ActivityManagerCompatKitKat.isLowRamDevice(paramActivityManager) : false;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ActivityManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */