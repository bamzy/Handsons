package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

public class AppCompatButton extends Button implements TintableBackgroundView {
  private final AppCompatBackgroundHelper mBackgroundTintHelper = new AppCompatBackgroundHelper((View)this);
  
  private final AppCompatTextHelper mTextHelper;
  
  public AppCompatButton(Context paramContext) {
    this(paramContext, null);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.buttonStyle);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.mBackgroundTintHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper = AppCompatTextHelper.create((TextView)this);
    this.mTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper.applyCompoundDrawablesTints();
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.applySupportBackgroundTint(); 
    if (this.mTextHelper != null)
      this.mTextHelper.applyCompoundDrawablesTints(); 
  }
  
  @Nullable
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public ColorStateList getSupportBackgroundTintList() {
    return (this.mBackgroundTintHelper != null) ? this.mBackgroundTintHelper.getSupportBackgroundTintList() : null;
  }
  
  @Nullable
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    return (this.mBackgroundTintHelper != null) ? this.mBackgroundTintHelper.getSupportBackgroundTintMode() : null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Button.class.getName());
  }
  
  @TargetApi(14)
  @RequiresApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Button.class.getName());
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.onSetBackgroundDrawable(paramDrawable); 
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt) {
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.onSetBackgroundResource(paramInt); 
  }
  
  public void setSupportAllCaps(boolean paramBoolean) {
    if (this.mTextHelper != null)
      this.mTextHelper.setAllCaps(paramBoolean); 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList) {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList); 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode) {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode); 
  }
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null)
      this.mTextHelper.onSetTextAppearance(paramContext, paramInt); 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\AppCompatButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */