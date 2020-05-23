package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.appcompat.R;
import android.support.v7.text.AllCapsTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

@TargetApi(9)
@RequiresApi(9)
class AppCompatTextHelper {
  private TintInfo mDrawableBottomTint;
  
  private TintInfo mDrawableLeftTint;
  
  private TintInfo mDrawableRightTint;
  
  private TintInfo mDrawableTopTint;
  
  final TextView mView;
  
  AppCompatTextHelper(TextView paramTextView) {
    this.mView = paramTextView;
  }
  
  static AppCompatTextHelper create(TextView paramTextView) {
    return (Build.VERSION.SDK_INT >= 17) ? new AppCompatTextHelperV17(paramTextView) : new AppCompatTextHelper(paramTextView);
  }
  
  protected static TintInfo createTintInfo(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt) {
    ColorStateList colorStateList = paramAppCompatDrawableManager.getTintList(paramContext, paramInt);
    if (colorStateList != null) {
      TintInfo tintInfo = new TintInfo();
      tintInfo.mHasTintList = true;
      tintInfo.mTintList = colorStateList;
      return tintInfo;
    } 
    return null;
  }
  
  final void applyCompoundDrawableTint(Drawable paramDrawable, TintInfo paramTintInfo) {
    if (paramDrawable != null && paramTintInfo != null)
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, this.mView.getDrawableState()); 
  }
  
  void applyCompoundDrawablesTints() {
    if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
      Drawable[] arrayOfDrawable = this.mView.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable[1], this.mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableRightTint);
      applyCompoundDrawableTint(arrayOfDrawable[3], this.mDrawableBottomTint);
    } 
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt) {
    ColorStateList colorStateList2;
    ColorStateList colorStateList3;
    Context context = this.mView.getContext();
    AppCompatDrawableManager appCompatDrawableManager1 = AppCompatDrawableManager.get();
    TintTypedArray tintTypedArray1 = TintTypedArray.obtainStyledAttributes(context, paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    int i = tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft))
      this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager1, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop))
      this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager1, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight))
      this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager1, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom))
      this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager1, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0)); 
    tintTypedArray1.recycle();
    boolean bool5 = this.mView.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    AppCompatDrawableManager appCompatDrawableManager2 = null;
    appCompatDrawableManager1 = null;
    TintTypedArray tintTypedArray3 = null;
    tintTypedArray1 = null;
    AppCompatDrawableManager appCompatDrawableManager3 = null;
    if (i != -1) {
      ColorStateList colorStateList;
      TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
      bool3 = bool4;
      bool1 = bool2;
      if (!bool5) {
        bool3 = bool4;
        bool1 = bool2;
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)) {
          bool1 = true;
          bool3 = tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        } 
      } 
      appCompatDrawableManager1 = appCompatDrawableManager2;
      appCompatDrawableManager2 = appCompatDrawableManager3;
      if (Build.VERSION.SDK_INT < 23) {
        ColorStateList colorStateList5;
        tintTypedArray1 = tintTypedArray3;
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor))
          colorStateList5 = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor); 
        colorStateList2 = colorStateList5;
        appCompatDrawableManager2 = appCompatDrawableManager3;
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
          colorStateList = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
          colorStateList2 = colorStateList5;
        } 
      } 
      tintTypedArray.recycle();
      colorStateList3 = colorStateList;
    } 
    TintTypedArray tintTypedArray2 = TintTypedArray.obtainStyledAttributes(context, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
    bool4 = bool3;
    paramInt = bool1;
    if (!bool5) {
      bool4 = bool3;
      paramInt = bool1;
      if (tintTypedArray2.hasValue(R.styleable.TextAppearance_textAllCaps)) {
        paramInt = 1;
        bool4 = tintTypedArray2.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
      } 
    } 
    ColorStateList colorStateList1 = colorStateList2;
    ColorStateList colorStateList4 = colorStateList3;
    if (Build.VERSION.SDK_INT < 23) {
      if (tintTypedArray2.hasValue(R.styleable.TextAppearance_android_textColor))
        colorStateList2 = tintTypedArray2.getColorStateList(R.styleable.TextAppearance_android_textColor); 
      colorStateList1 = colorStateList2;
      colorStateList4 = colorStateList3;
      if (tintTypedArray2.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
        colorStateList4 = tintTypedArray2.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
        colorStateList1 = colorStateList2;
      } 
    } 
    tintTypedArray2.recycle();
    if (colorStateList1 != null)
      this.mView.setTextColor(colorStateList1); 
    if (colorStateList4 != null)
      this.mView.setHintTextColor(colorStateList4); 
    if (!bool5 && paramInt != 0)
      setAllCaps(bool4); 
  }
  
  void onSetTextAppearance(Context paramContext, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    if (tintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps))
      setAllCaps(tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false)); 
    if (Build.VERSION.SDK_INT < 23 && tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
      ColorStateList colorStateList = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
      if (colorStateList != null)
        this.mView.setTextColor(colorStateList); 
    } 
    tintTypedArray.recycle();
  }
  
  void setAllCaps(boolean paramBoolean) {
    TransformationMethod transformationMethod;
    TextView textView = this.mView;
    if (paramBoolean) {
      transformationMethod = (TransformationMethod)new AllCapsTransformationMethod(this.mView.getContext());
    } else {
      transformationMethod = null;
    } 
    textView.setTransformationMethod(transformationMethod);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\AppCompatTextHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */