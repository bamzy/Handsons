package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@TargetApi(17)
@RequiresApi(17)
class ConfigurationHelperJellybeanMr1 {
  static int getDensityDpi(@NonNull Resources paramResources) {
    return (paramResources.getConfiguration()).densityDpi;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\res\ConfigurationHelperJellybeanMr1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */