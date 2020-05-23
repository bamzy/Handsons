package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@TargetApi(19)
@RequiresApi(19)
class DrawableCompatKitKat {
  public static int getAlpha(Drawable paramDrawable) {
    return paramDrawable.getAlpha();
  }
  
  public static boolean isAutoMirrored(Drawable paramDrawable) {
    return paramDrawable.isAutoMirrored();
  }
  
  public static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean) {
    paramDrawable.setAutoMirrored(paramBoolean);
  }
  
  public static Drawable wrapForTinting(Drawable paramDrawable) {
    Drawable drawable = paramDrawable;
    if (!(paramDrawable instanceof TintAwareDrawable))
      drawable = new DrawableWrapperKitKat(paramDrawable); 
    return drawable;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */