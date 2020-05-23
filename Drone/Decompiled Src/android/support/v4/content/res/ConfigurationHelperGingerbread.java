package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;

@TargetApi(9)
@RequiresApi(9)
class ConfigurationHelperGingerbread {
  static int getDensityDpi(@NonNull Resources paramResources) {
    return (paramResources.getDisplayMetrics()).densityDpi;
  }
  
  static int getScreenHeightDp(@NonNull Resources paramResources) {
    DisplayMetrics displayMetrics = paramResources.getDisplayMetrics();
    return (int)(displayMetrics.heightPixels / displayMetrics.density);
  }
  
  static int getScreenWidthDp(@NonNull Resources paramResources) {
    DisplayMetrics displayMetrics = paramResources.getDisplayMetrics();
    return (int)(displayMetrics.widthPixels / displayMetrics.density);
  }
  
  static int getSmallestScreenWidthDp(@NonNull Resources paramResources) {
    return Math.min(getScreenWidthDp(paramResources), getScreenHeightDp(paramResources));
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\res\ConfigurationHelperGingerbread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */