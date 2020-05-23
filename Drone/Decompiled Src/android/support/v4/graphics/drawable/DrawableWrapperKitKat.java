package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@TargetApi(19)
@RequiresApi(19)
class DrawableWrapperKitKat extends DrawableWrapperHoneycomb {
  DrawableWrapperKitKat(Drawable paramDrawable) {
    super(paramDrawable);
  }
  
  DrawableWrapperKitKat(DrawableWrapperGingerbread.DrawableWrapperState paramDrawableWrapperState, Resources paramResources) {
    super(paramDrawableWrapperState, paramResources);
  }
  
  public boolean isAutoMirrored() {
    return this.mDrawable.isAutoMirrored();
  }
  
  @NonNull
  DrawableWrapperGingerbread.DrawableWrapperState mutateConstantState() {
    return new DrawableWrapperStateKitKat(this.mState, null);
  }
  
  public void setAutoMirrored(boolean paramBoolean) {
    this.mDrawable.setAutoMirrored(paramBoolean);
  }
  
  private static class DrawableWrapperStateKitKat extends DrawableWrapperGingerbread.DrawableWrapperState {
    DrawableWrapperStateKitKat(@Nullable DrawableWrapperGingerbread.DrawableWrapperState param1DrawableWrapperState, @Nullable Resources param1Resources) {
      super(param1DrawableWrapperState, param1Resources);
    }
    
    public Drawable newDrawable(@Nullable Resources param1Resources) {
      return new DrawableWrapperKitKat(this, param1Resources);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableWrapperKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */