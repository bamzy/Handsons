package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(21)
@RequiresApi(21)
class ViewPropertyAnimatorCompatLollipop {
  public static void translationZ(View paramView, float paramFloat) {
    paramView.animate().translationZ(paramFloat);
  }
  
  public static void translationZBy(View paramView, float paramFloat) {
    paramView.animate().translationZBy(paramFloat);
  }
  
  public static void z(View paramView, float paramFloat) {
    paramView.animate().z(paramFloat);
  }
  
  public static void zBy(View paramView, float paramFloat) {
    paramView.animate().zBy(paramFloat);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewPropertyAnimatorCompatLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */