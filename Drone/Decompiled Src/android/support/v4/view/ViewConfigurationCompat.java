package android.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;

public final class ViewConfigurationCompat {
  static final ViewConfigurationVersionImpl IMPL = new BaseViewConfigurationVersionImpl();
  
  @Deprecated
  public static int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration) {
    return paramViewConfiguration.getScaledPagingTouchSlop();
  }
  
  public static boolean hasPermanentMenuKey(ViewConfiguration paramViewConfiguration) {
    return IMPL.hasPermanentMenuKey(paramViewConfiguration);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new IcsViewConfigurationVersionImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 11) {
      IMPL = new HoneycombViewConfigurationVersionImpl();
      return;
    } 
  }
  
  static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
    public boolean hasPermanentMenuKey(ViewConfiguration param1ViewConfiguration) {
      return true;
    }
  }
  
  static class HoneycombViewConfigurationVersionImpl extends BaseViewConfigurationVersionImpl {
    public boolean hasPermanentMenuKey(ViewConfiguration param1ViewConfiguration) {
      return false;
    }
  }
  
  static class IcsViewConfigurationVersionImpl extends HoneycombViewConfigurationVersionImpl {
    public boolean hasPermanentMenuKey(ViewConfiguration param1ViewConfiguration) {
      return ViewConfigurationCompatICS.hasPermanentMenuKey(param1ViewConfiguration);
    }
  }
  
  static interface ViewConfigurationVersionImpl {
    boolean hasPermanentMenuKey(ViewConfiguration param1ViewConfiguration);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewConfigurationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */