package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface DrawableWrapper {
  Drawable getWrappedDrawable();
  
  void setWrappedDrawable(Drawable paramDrawable);
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */