package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.widget.EdgeEffect;

@TargetApi(21)
@RequiresApi(21)
class EdgeEffectCompatLollipop {
  public static boolean onPull(Object paramObject, float paramFloat1, float paramFloat2) {
    ((EdgeEffect)paramObject).onPull(paramFloat1, paramFloat2);
    return true;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\EdgeEffectCompatLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */