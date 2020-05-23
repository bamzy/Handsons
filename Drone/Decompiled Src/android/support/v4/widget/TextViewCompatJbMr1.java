package android.support.v4.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

@TargetApi(17)
@RequiresApi(17)
class TextViewCompatJbMr1 {
  public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView paramTextView) {
    boolean bool = true;
    if (paramTextView.getLayoutDirection() != 1)
      bool = false; 
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    if (bool) {
      Drawable drawable1 = arrayOfDrawable[2];
      Drawable drawable2 = arrayOfDrawable[0];
      arrayOfDrawable[0] = drawable1;
      arrayOfDrawable[2] = drawable2;
    } 
    return arrayOfDrawable;
  }
  
  public static void setCompoundDrawablesRelative(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4) {
    Drawable drawable;
    boolean bool = true;
    if (paramTextView.getLayoutDirection() != 1)
      bool = false; 
    if (bool) {
      drawable = paramDrawable3;
    } else {
      drawable = paramDrawable1;
    } 
    if (!bool)
      paramDrawable1 = paramDrawable3; 
    paramTextView.setCompoundDrawables(drawable, paramDrawable2, paramDrawable1, paramDrawable4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i;
    boolean bool = true;
    if (paramTextView.getLayoutDirection() != 1)
      bool = false; 
    if (bool) {
      i = paramInt3;
    } else {
      i = paramInt1;
    } 
    if (!bool)
      paramInt1 = paramInt3; 
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(i, paramInt2, paramInt1, paramInt4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4) {
    Drawable drawable;
    boolean bool = true;
    if (paramTextView.getLayoutDirection() != 1)
      bool = false; 
    if (bool) {
      drawable = paramDrawable3;
    } else {
      drawable = paramDrawable1;
    } 
    if (!bool)
      paramDrawable1 = paramDrawable3; 
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, paramDrawable2, paramDrawable1, paramDrawable4);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\TextViewCompatJbMr1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */