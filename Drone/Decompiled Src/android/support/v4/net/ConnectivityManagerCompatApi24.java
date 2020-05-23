package android.support.v4.net;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.support.annotation.RequiresApi;

@TargetApi(24)
@RequiresApi(24)
class ConnectivityManagerCompatApi24 {
  public static int getRestrictBackgroundStatus(ConnectivityManager paramConnectivityManager) {
    return paramConnectivityManager.getRestrictBackgroundStatus();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\net\ConnectivityManagerCompatApi24.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */