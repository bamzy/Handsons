package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.RequiresApi;

@TargetApi(16)
@RequiresApi(16)
class AccessibilityServiceInfoCompatJellyBean {
  public static String loadDescription(AccessibilityServiceInfo paramAccessibilityServiceInfo, PackageManager paramPackageManager) {
    return paramAccessibilityServiceInfo.loadDescription(paramPackageManager);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\accessibilityservice\AccessibilityServiceInfoCompatJellyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */