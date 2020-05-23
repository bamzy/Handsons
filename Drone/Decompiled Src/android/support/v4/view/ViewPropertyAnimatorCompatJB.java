package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(16)
@RequiresApi(16)
class ViewPropertyAnimatorCompatJB {
  public static void setListener(final View view, final ViewPropertyAnimatorListener listener) {
    if (listener != null) {
      view.animate().setListener((Animator.AnimatorListener)new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator param1Animator) {
              listener.onAnimationCancel(view);
            }
            
            public void onAnimationEnd(Animator param1Animator) {
              listener.onAnimationEnd(view);
            }
            
            public void onAnimationStart(Animator param1Animator) {
              listener.onAnimationStart(view);
            }
          });
      return;
    } 
    view.animate().setListener(null);
  }
  
  public static void withEndAction(View paramView, Runnable paramRunnable) {
    paramView.animate().withEndAction(paramRunnable);
  }
  
  public static void withLayer(View paramView) {
    paramView.animate().withLayer();
  }
  
  public static void withStartAction(View paramView, Runnable paramRunnable) {
    paramView.animate().withStartAction(paramRunnable);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewPropertyAnimatorCompatJB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */