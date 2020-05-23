package android.support.v4.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;

public final class PathInterpolatorCompat {
  public static Interpolator create(float paramFloat1, float paramFloat2) {
    return (Build.VERSION.SDK_INT >= 21) ? PathInterpolatorCompatApi21.create(paramFloat1, paramFloat2) : PathInterpolatorCompatBase.create(paramFloat1, paramFloat2);
  }
  
  public static Interpolator create(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    return (Build.VERSION.SDK_INT >= 21) ? PathInterpolatorCompatApi21.create(paramFloat1, paramFloat2, paramFloat3, paramFloat4) : PathInterpolatorCompatBase.create(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public static Interpolator create(Path paramPath) {
    return (Build.VERSION.SDK_INT >= 21) ? PathInterpolatorCompatApi21.create(paramPath) : PathInterpolatorCompatBase.create(paramPath);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\animation\PathInterpolatorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */