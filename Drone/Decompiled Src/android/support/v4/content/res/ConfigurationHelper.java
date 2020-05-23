package android.support.v4.content.res;

import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;

public final class ConfigurationHelper {
  private static final ConfigurationHelperImpl IMPL = new GingerbreadImpl();
  
  public static int getDensityDpi(@NonNull Resources paramResources) {
    return IMPL.getDensityDpi(paramResources);
  }
  
  public static int getScreenHeightDp(@NonNull Resources paramResources) {
    return IMPL.getScreenHeightDp(paramResources);
  }
  
  public static int getScreenWidthDp(@NonNull Resources paramResources) {
    return IMPL.getScreenWidthDp(paramResources);
  }
  
  public static int getSmallestScreenWidthDp(@NonNull Resources paramResources) {
    return IMPL.getSmallestScreenWidthDp(paramResources);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17) {
      IMPL = new JellybeanMr1Impl();
      return;
    } 
    if (i >= 13) {
      IMPL = new HoneycombMr2Impl();
      return;
    } 
  }
  
  private static interface ConfigurationHelperImpl {
    int getDensityDpi(@NonNull Resources param1Resources);
    
    int getScreenHeightDp(@NonNull Resources param1Resources);
    
    int getScreenWidthDp(@NonNull Resources param1Resources);
    
    int getSmallestScreenWidthDp(@NonNull Resources param1Resources);
  }
  
  private static class GingerbreadImpl implements ConfigurationHelperImpl {
    public int getDensityDpi(@NonNull Resources param1Resources) {
      return ConfigurationHelperGingerbread.getDensityDpi(param1Resources);
    }
    
    public int getScreenHeightDp(@NonNull Resources param1Resources) {
      return ConfigurationHelperGingerbread.getScreenHeightDp(param1Resources);
    }
    
    public int getScreenWidthDp(@NonNull Resources param1Resources) {
      return ConfigurationHelperGingerbread.getScreenWidthDp(param1Resources);
    }
    
    public int getSmallestScreenWidthDp(@NonNull Resources param1Resources) {
      return ConfigurationHelperGingerbread.getSmallestScreenWidthDp(param1Resources);
    }
  }
  
  private static class HoneycombMr2Impl extends GingerbreadImpl {
    public int getScreenHeightDp(@NonNull Resources param1Resources) {
      return ConfigurationHelperHoneycombMr2.getScreenHeightDp(param1Resources);
    }
    
    public int getScreenWidthDp(@NonNull Resources param1Resources) {
      return ConfigurationHelperHoneycombMr2.getScreenWidthDp(param1Resources);
    }
    
    public int getSmallestScreenWidthDp(@NonNull Resources param1Resources) {
      return ConfigurationHelperHoneycombMr2.getSmallestScreenWidthDp(param1Resources);
    }
  }
  
  private static class JellybeanMr1Impl extends HoneycombMr2Impl {
    public int getDensityDpi(@NonNull Resources param1Resources) {
      return ConfigurationHelperJellybeanMr1.getDensityDpi(param1Resources);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\res\ConfigurationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */