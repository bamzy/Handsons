package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.animation.Interpolator;

@TargetApi(18)
@RequiresApi(18)
class ViewPropertyAnimatorCompatJellybeanMr2 {
  public static Interpolator getInterpolator(View paramView) {
    return (Interpolator)paramView.animate().getInterpolator();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewPropertyAnimatorCompatJellybeanMr2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */