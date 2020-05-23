package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@TargetApi(21)
@RequiresApi(21)
class DrawableWrapperLollipop extends DrawableWrapperKitKat {
  DrawableWrapperLollipop(Drawable paramDrawable) {
    super(paramDrawable);
  }
  
  DrawableWrapperLollipop(DrawableWrapperGingerbread.DrawableWrapperState paramDrawableWrapperState, Resources paramResources) {
    super(paramDrawableWrapperState, paramResources);
  }
  
  public Rect getDirtyBounds() {
    return this.mDrawable.getDirtyBounds();
  }
  
  public void getOutline(Outline paramOutline) {
    this.mDrawable.getOutline(paramOutline);
  }
  
  protected boolean isCompatTintEnabled() {
    boolean bool = false;
    null = bool;
    if (Build.VERSION.SDK_INT == 21) {
      Drawable drawable = this.mDrawable;
      if (!(drawable instanceof android.graphics.drawable.GradientDrawable) && !(drawable instanceof android.graphics.drawable.DrawableContainer)) {
        null = bool;
        return (drawable instanceof android.graphics.drawable.InsetDrawable) ? true : null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  @NonNull
  DrawableWrapperGingerbread.DrawableWrapperState mutateConstantState() {
    return new DrawableWrapperStateLollipop(this.mState, null);
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2) {
    this.mDrawable.setHotspot(paramFloat1, paramFloat2);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean setState(int[] paramArrayOfint) {
    if (super.setState(paramArrayOfint)) {
      invalidateSelf();
      return true;
    } 
    return false;
  }
  
  public void setTint(int paramInt) {
    if (isCompatTintEnabled()) {
      super.setTint(paramInt);
      return;
    } 
    this.mDrawable.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    if (isCompatTintEnabled()) {
      super.setTintList(paramColorStateList);
      return;
    } 
    this.mDrawable.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    if (isCompatTintEnabled()) {
      super.setTintMode(paramMode);
      return;
    } 
    this.mDrawable.setTintMode(paramMode);
  }
  
  private static class DrawableWrapperStateLollipop extends DrawableWrapperGingerbread.DrawableWrapperState {
    DrawableWrapperStateLollipop(@Nullable DrawableWrapperGingerbread.DrawableWrapperState param1DrawableWrapperState, @Nullable Resources param1Resources) {
      super(param1DrawableWrapperState, param1Resources);
    }
    
    public Drawable newDrawable(@Nullable Resources param1Resources) {
      return new DrawableWrapperLollipop(this, param1Resources);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableWrapperLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */