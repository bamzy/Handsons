package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ConnectivityManagerCompat {
  private static final ConnectivityManagerCompatImpl IMPL = new BaseConnectivityManagerCompatImpl();
  
  public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
  
  public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
  
  public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;
  
  public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager paramConnectivityManager, Intent paramIntent) {
    NetworkInfo networkInfo = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    return (networkInfo != null) ? paramConnectivityManager.getNetworkInfo(networkInfo.getType()) : null;
  }
  
  public static int getRestrictBackgroundStatus(ConnectivityManager paramConnectivityManager) {
    return IMPL.getRestrictBackgroundStatus(paramConnectivityManager);
  }
  
  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager) {
    return IMPL.isActiveNetworkMetered(paramConnectivityManager);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 24) {
      IMPL = new Api24ConnectivityManagerCompatImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new JellyBeanConnectivityManagerCompatImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 13) {
      IMPL = new HoneycombMR2ConnectivityManagerCompatImpl();
      return;
    } 
  }
  
  static class Api24ConnectivityManagerCompatImpl extends JellyBeanConnectivityManagerCompatImpl {
    public int getRestrictBackgroundStatus(ConnectivityManager param1ConnectivityManager) {
      return ConnectivityManagerCompatApi24.getRestrictBackgroundStatus(param1ConnectivityManager);
    }
  }
  
  static class BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
    public int getRestrictBackgroundStatus(ConnectivityManager param1ConnectivityManager) {
      return 3;
    }
    
    public boolean isActiveNetworkMetered(ConnectivityManager param1ConnectivityManager) {
      NetworkInfo networkInfo = param1ConnectivityManager.getActiveNetworkInfo();
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
          break;
      } 
      return false;
    }
  }
  
  static interface ConnectivityManagerCompatImpl {
    int getRestrictBackgroundStatus(ConnectivityManager param1ConnectivityManager);
    
    boolean isActiveNetworkMetered(ConnectivityManager param1ConnectivityManager);
  }
  
  static class HoneycombMR2ConnectivityManagerCompatImpl extends BaseConnectivityManagerCompatImpl {
    public boolean isActiveNetworkMetered(ConnectivityManager param1ConnectivityManager) {
      return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(param1ConnectivityManager);
    }
  }
  
  static class JellyBeanConnectivityManagerCompatImpl extends HoneycombMR2ConnectivityManagerCompatImpl {
    public boolean isActiveNetworkMetered(ConnectivityManager param1ConnectivityManager) {
      return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(param1ConnectivityManager);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface RestrictBackgroundStatus {}
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\net\ConnectivityManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */