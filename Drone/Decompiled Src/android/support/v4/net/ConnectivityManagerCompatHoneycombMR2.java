package android.support.v4.net;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.RequiresApi;

@TargetApi(13)
@RequiresApi(13)
class ConnectivityManagerCompatHoneycombMR2 {
  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager) {
    NetworkInfo networkInfo = paramConnectivityManager.getActiveNetworkInfo();
    if (networkInfo == null);
    switch (networkInfo.getType()) {
      case 0:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
        return true;
      default:
        return true;
      case 1:
      case 7:
      case 9:
        break;
    } 
    return false;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\net\ConnectivityManagerCompatHoneycombMR2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */