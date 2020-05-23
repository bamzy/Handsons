package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.ImageView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AppCompatImageHelper {
  private final ImageView mView;
  
  public AppCompatImageHelper(ImageView paramImageView) {
    this.mView = paramImageView;
  }
  
  boolean hasOverlappingRendering() {
    Drawable drawable = this.mView.getBackground();
    return !(Build.VERSION.SDK_INT >= 21 && drawable instanceof android.graphics.drawable.RippleDrawable);
  }
  
  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt) {
    TintTypedArray tintTypedArray3 = null;
    TintTypedArray tintTypedArray2 = null;
    TintTypedArray tintTypedArray1 = tintTypedArray3;
    try {
      Drawable drawable2 = this.mView.getDrawable();
      Drawable drawable1 = drawable2;
      if (drawable2 == null) {
        tintTypedArray1 = tintTypedArray3;
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), paramAttributeSet, R.styleable.AppCompatImageView, paramInt, 0);
        tintTypedArray1 = tintTypedArray;
        paramInt = tintTypedArray.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
        tintTypedArray2 = tintTypedArray;
        drawable1 = drawable2;
        if (paramInt != -1) {
          tintTypedArray1 = tintTypedArray;
          drawable2 = AppCompatResources.getDrawable(this.mView.getContext(), paramInt);
          tintTypedArray2 = tintTypedArray;
          drawable1 = drawable2;
          if (drawable2 != null) {
            tintTypedArray1 = tintTypedArray;
            this.mView.setImageDrawable(drawable2);
            drawable1 = drawable2;
            tintTypedArray2 = tintTypedArray;
          } 
        } 
      } 
      if (drawable1 != null) {
        tintTypedArray1 = tintTypedArray2;
        DrawableUtils.fixDrawable(drawable1);
      } 
      return;
    } finally {
      if (tintTypedArray1 != null)
        tintTypedArray1.recycle(); 
    } 
  }
  
  public void setImageResource(int paramInt) {
    if (paramInt != 0) {
      Drawable drawable = AppCompatResources.getDrawable(this.mView.getContext(), paramInt);
      if (drawable != null)
        DrawableUtils.fixDrawable(drawable); 
      this.mView.setImageDrawable(drawable);
      return;
    } 
    this.mView.setImageDrawable(null);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\AppCompatImageHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */