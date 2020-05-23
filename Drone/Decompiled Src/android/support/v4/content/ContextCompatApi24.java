package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import java.io.File;

@TargetApi(24)
@RequiresApi(24)
class ContextCompatApi24 {
  public static Context createDeviceProtectedStorageContext(Context paramContext) {
    return paramContext.createDeviceProtectedStorageContext();
  }
  
  public static File getDataDir(Context paramContext) {
    return paramContext.getDataDir();
  }
  
  public static boolean isDeviceProtectedStorage(Context paramContext) {
    return paramContext.isDeviceProtectedStorage();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\ContextCompatApi24.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */