package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.TextView;

@TargetApi(17)
@RequiresApi(17)
class AppCompatTextHelperV17 extends AppCompatTextHelper {
  private TintInfo mDrawableEndTint;
  
  private TintInfo mDrawableStartTint;
  
  AppCompatTextHelperV17(TextView paramTextView) {
    super(paramTextView);
  }
  
  void applyCompoundDrawablesTints() {
    super.applyCompoundDrawablesTints();
    if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
      Drawable[] arrayOfDrawable = this.mView.getCompoundDrawablesRelative();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableStartTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableEndTint);
    } 
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt) {
    super.loadFromAttributes(paramAttributeSet, paramInt);
    Context context = this.mView.getContext();
    AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
    TypedArray typedArray = context.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    if (typedArray.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart))
      this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0)); 
    if (typedArray.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd))
      this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0)); 
    typedArray.recycle();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\AppCompatTextHelperV17.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */