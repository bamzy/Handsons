package android.support.v4.view.animation;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.support.annotation.RequiresApi;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

@TargetApi(21)
@RequiresApi(21)
class PathInterpolatorCompatApi21 {
  public static Interpolator create(float paramFloat1, float paramFloat2) {
    return (Interpolator)new PathInterpolator(paramFloat1, paramFloat2);
  }
  
  public static Interpolator create(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    return (Interpolator)new PathInterpolator(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public static Interpolator create(Path paramPath) {
    return (Interpolator)new PathInterpolator(paramPath);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\animation\PathInterpolatorCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */