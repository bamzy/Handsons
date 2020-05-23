package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class ResourcesCompat {
  @ColorInt
  public static int getColor(@NonNull Resources paramResources, @ColorRes int paramInt, @Nullable Resources.Theme paramTheme) throws Resources.NotFoundException {
    return (Build.VERSION.SDK_INT >= 23) ? ResourcesCompatApi23.getColor(paramResources, paramInt, paramTheme) : paramResources.getColor(paramInt);
  }
  
  @Nullable
  public static ColorStateList getColorStateList(@NonNull Resources paramResources, @ColorRes int paramInt, @Nullable Resources.Theme paramTheme) throws Resources.NotFoundException {
    return (Build.VERSION.SDK_INT >= 23) ? ResourcesCompatApi23.getColorStateList(paramResources, paramInt, paramTheme) : paramResources.getColorStateList(paramInt);
  }
  
  @Nullable
  public static Drawable getDrawable(@NonNull Resources paramResources, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme) throws Resources.NotFoundException {
    return (Build.VERSION.SDK_INT >= 21) ? ResourcesCompatApi21.getDrawable(paramResources, paramInt, paramTheme) : paramResources.getDrawable(paramInt);
  }
  
  @Nullable
  public static Drawable getDrawableForDensity(@NonNull Resources paramResources, @DrawableRes int paramInt1, int paramInt2, @Nullable Resources.Theme paramTheme) throws Resources.NotFoundException {
    return (Build.VERSION.SDK_INT >= 21) ? ResourcesCompatApi21.getDrawableForDensity(paramResources, paramInt1, paramInt2, paramTheme) : ((Build.VERSION.SDK_INT >= 15) ? ResourcesCompatIcsMr1.getDrawableForDensity(paramResources, paramInt1, paramInt2) : paramResources.getDrawable(paramInt1));
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\res\ResourcesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */