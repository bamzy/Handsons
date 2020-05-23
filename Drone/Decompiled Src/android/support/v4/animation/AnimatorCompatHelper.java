package android.support.v4.animation;

import android.os.Build;
import android.support.annotation.RestrictTo;
import android.view.View;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AnimatorCompatHelper {
  private static final AnimatorProvider IMPL = new GingerbreadAnimatorCompatProvider();
  
  public static void clearInterpolator(View paramView) {
    IMPL.clearInterpolator(paramView);
  }
  
  public static ValueAnimatorCompat emptyValueAnimator() {
    return IMPL.emptyValueAnimator();
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 12) {
      IMPL = new HoneycombMr1AnimatorCompatProvider();
      return;
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\animation\AnimatorCompatHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */