package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@TargetApi(15)
@RequiresApi(15)
class ResourcesCompatIcsMr1 {
  public static Drawable getDrawableForDensity(Resources paramResources, int paramInt1, int paramInt2) throws Resources.NotFoundException {
    return paramResources.getDrawableForDensity(paramInt1, paramInt2);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\res\ResourcesCompatIcsMr1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */