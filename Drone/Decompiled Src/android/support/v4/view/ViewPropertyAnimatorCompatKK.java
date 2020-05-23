package android.support.v4.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(19)
@RequiresApi(19)
class ViewPropertyAnimatorCompatKK {
  public static void setUpdateListener(final View view, final ViewPropertyAnimatorUpdateListener listener) {
    ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
    if (listener != null)
      animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            listener.onAnimationUpdate(view);
          }
        }; 
    view.animate().setUpdateListener(animatorUpdateListener);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewPropertyAnimatorCompatKK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */