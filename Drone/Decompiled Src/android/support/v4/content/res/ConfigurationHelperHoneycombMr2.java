package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@TargetApi(13)
@RequiresApi(13)
class ConfigurationHelperHoneycombMr2 {
  static int getScreenHeightDp(@NonNull Resources paramResources) {
    return (paramResources.getConfiguration()).screenHeightDp;
  }
  
  static int getScreenWidthDp(@NonNull Resources paramResources) {
    return (paramResources.getConfiguration()).screenWidthDp;
  }
  
  static int getSmallestScreenWidthDp(@NonNull Resources paramResources) {
    return (paramResources.getConfiguration()).smallestScreenWidthDp;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\res\ConfigurationHelperHoneycombMr2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */