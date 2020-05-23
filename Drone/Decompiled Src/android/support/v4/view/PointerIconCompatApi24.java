package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.view.PointerIcon;

@TargetApi(24)
@RequiresApi(24)
class PointerIconCompatApi24 {
  public static Object create(Bitmap paramBitmap, float paramFloat1, float paramFloat2) {
    return PointerIcon.create(paramBitmap, paramFloat1, paramFloat2);
  }
  
  public static Object getSystemIcon(Context paramContext, int paramInt) {
    return PointerIcon.getSystemIcon(paramContext, paramInt);
  }
  
  public static Object load(Resources paramResources, int paramInt) {
    return PointerIcon.load(paramResources, paramInt);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\PointerIconCompatApi24.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */