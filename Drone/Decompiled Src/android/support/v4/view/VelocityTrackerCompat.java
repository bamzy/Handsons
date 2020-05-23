package android.support.v4.view;

import android.os.Build;
import android.view.VelocityTracker;

public final class VelocityTrackerCompat {
  static final VelocityTrackerVersionImpl IMPL = new BaseVelocityTrackerVersionImpl();
  
  public static float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt) {
    return IMPL.getXVelocity(paramVelocityTracker, paramInt);
  }
  
  public static float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt) {
    return IMPL.getYVelocity(paramVelocityTracker, paramInt);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 11) {
      IMPL = new HoneycombVelocityTrackerVersionImpl();
      return;
    } 
  }
  
  static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
    public float getXVelocity(VelocityTracker param1VelocityTracker, int param1Int) {
      return param1VelocityTracker.getXVelocity();
    }
    
    public float getYVelocity(VelocityTracker param1VelocityTracker, int param1Int) {
      return param1VelocityTracker.getYVelocity();
    }
  }
  
  static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
    public float getXVelocity(VelocityTracker param1VelocityTracker, int param1Int) {
      return VelocityTrackerCompatHoneycomb.getXVelocity(param1VelocityTracker, param1Int);
    }
    
    public float getYVelocity(VelocityTracker param1VelocityTracker, int param1Int) {
      return VelocityTrackerCompatHoneycomb.getYVelocity(param1VelocityTracker, param1Int);
    }
  }
  
  static interface VelocityTrackerVersionImpl {
    float getXVelocity(VelocityTracker param1VelocityTracker, int param1Int);
    
    float getYVelocity(VelocityTracker param1VelocityTracker, int param1Int);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\VelocityTrackerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */