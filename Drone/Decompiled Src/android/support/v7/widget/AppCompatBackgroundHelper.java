package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;

class AppCompatBackgroundHelper {
  private int mBackgroundResId = -1;
  
  private TintInfo mBackgroundTint;
  
  private final AppCompatDrawableManager mDrawableManager;
  
  private TintInfo mInternalBackgroundTint;
  
  private TintInfo mTmpInfo;
  
  private final View mView;
  
  AppCompatBackgroundHelper(View paramView) {
    this.mView = paramView;
    this.mDrawableManager = AppCompatDrawableManager.get();
  }
  
  private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable paramDrawable) {
    if (this.mTmpInfo == null)
      this.mTmpInfo = new TintInfo(); 
    TintInfo tintInfo = this.mTmpInfo;
    tintInfo.clear();
    ColorStateList colorStateList = ViewCompat.getBackgroundTintList(this.mView);
    if (colorStateList != null) {
      tintInfo.mHasTintList = true;
      tintInfo.mTintList = colorStateList;
    } 
    PorterDuff.Mode mode = ViewCompat.getBackgroundTintMode(this.mView);
    if (mode != null) {
      tintInfo.mHasTintMode = true;
      tintInfo.mTintMode = mode;
    } 
    if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
      AppCompatDrawableManager.tintDrawable(paramDrawable, tintInfo, this.mView.getDrawableState());
      return true;
    } 
    return false;
  }
  
  private boolean shouldApplyFrameworkTintUsingColorFilter() {
    boolean bool2 = true;
    int i = Build.VERSION.SDK_INT;
    if (i < 21)
      return false; 
    boolean bool1 = bool2;
    if (i != 21) {
      bool1 = bool2;
      if (this.mInternalBackgroundTint == null)
        return false; 
    } 
    return bool1;
  }
  
  void applySupportBackgroundTint() {
    Drawable drawable = this.mView.getBackground();
    if (drawable != null && (!shouldApplyFrameworkTintUsingColorFilter() || !applyFrameworkTintUsingColorFilter(drawable))) {
      if (this.mBackgroundTint != null) {
        AppCompatDrawableManager.tintDrawable(drawable, this.mBackgroundTint, this.mView.getDrawableState());
        return;
      } 
      if (this.mInternalBackgroundTint != null) {
        AppCompatDrawableManager.tintDrawable(drawable, this.mInternalBackgroundTint, this.mView.getDrawableState());
        return;
      } 
    } 
  }
  
  ColorStateList getSupportBackgroundTintList() {
    return (this.mBackgroundTint != null) ? this.mBackgroundTint.mTintList : null;
  }
  
  PorterDuff.Mode getSupportBackgroundTintMode() {
    return (this.mBackgroundTint != null) ? this.mBackgroundTint.mTintMode : null;
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), paramAttributeSet, R.styleable.ViewBackgroundHelper, paramInt, 0);
    try {
      if (tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
        this.mBackgroundResId = tintTypedArray.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
        ColorStateList colorStateList = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);
        if (colorStateList != null)
          setInternalBackgroundTint(colorStateList); 
      } 
      if (tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint))
        ViewCompat.setBackgroundTintList(this.mView, tintTypedArray.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint)); 
      if (tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode))
        ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(tintTypedArray.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null)); 
      return;
    } finally {
      tintTypedArray.recycle();
    } 
  }
  
  void onSetBackgroundDrawable(Drawable paramDrawable) {
    this.mBackgroundResId = -1;
    setInternalBackgroundTint(null);
    applySupportBackgroundTint();
  }
  
  void onSetBackgroundResource(int paramInt) {
    ColorStateList colorStateList;
    this.mBackgroundResId = paramInt;
    if (this.mDrawableManager != null) {
      colorStateList = this.mDrawableManager.getTintList(this.mView.getContext(), paramInt);
    } else {
      colorStateList = null;
    } 
    setInternalBackgroundTint(colorStateList);
    applySupportBackgroundTint();
  }
  
  void setInternalBackgroundTint(ColorStateList paramColorStateList) {
    if (paramColorStateList != null) {
      if (this.mInternalBackgroundTint == null)
        this.mInternalBackgroundTint = new TintInfo(); 
      this.mInternalBackgroundTint.mTintList = paramColorStateList;
      this.mInternalBackgroundTint.mHasTintList = true;
    } else {
      this.mInternalBackgroundTint = null;
    } 
    applySupportBackgroundTint();
  }
  
  void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    if (this.mBackgroundTint == null)
      this.mBackgroundTint = new TintInfo(); 
    this.mBackgroundTint.mTintList = paramColorStateList;
    this.mBackgroundTint.mHasTintList = true;
    applySupportBackgroundTint();
  }
  
  void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    if (this.mBackgroundTint == null)
      this.mBackgroundTint = new TintInfo(); 
    this.mBackgroundTint.mTintMode = paramMode;
    this.mBackgroundTint.mHasTintMode = true;
    applySupportBackgroundTint();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\AppCompatBackgroundHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */