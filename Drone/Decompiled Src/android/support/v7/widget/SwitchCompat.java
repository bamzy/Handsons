package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.text.AllCapsTransformationMethod;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CompoundButton;

public class SwitchCompat extends CompoundButton {
  private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
  
  private static final int[] CHECKED_STATE_SET = new int[] { 16842912 };
  
  private static final int MONOSPACE = 3;
  
  private static final int SANS = 1;
  
  private static final int SERIF = 2;
  
  private static final int THUMB_ANIMATION_DURATION = 250;
  
  private static final int TOUCH_MODE_DOWN = 1;
  
  private static final int TOUCH_MODE_DRAGGING = 2;
  
  private static final int TOUCH_MODE_IDLE = 0;
  
  private boolean mHasThumbTint = false;
  
  private boolean mHasThumbTintMode = false;
  
  private boolean mHasTrackTint = false;
  
  private boolean mHasTrackTintMode = false;
  
  private int mMinFlingVelocity;
  
  private Layout mOffLayout;
  
  private Layout mOnLayout;
  
  ThumbAnimation mPositionAnimator;
  
  private boolean mShowText;
  
  private boolean mSplitTrack;
  
  private int mSwitchBottom;
  
  private int mSwitchHeight;
  
  private int mSwitchLeft;
  
  private int mSwitchMinWidth;
  
  private int mSwitchPadding;
  
  private int mSwitchRight;
  
  private int mSwitchTop;
  
  private TransformationMethod mSwitchTransformationMethod;
  
  private int mSwitchWidth;
  
  private final Rect mTempRect = new Rect();
  
  private ColorStateList mTextColors;
  
  private CharSequence mTextOff;
  
  private CharSequence mTextOn;
  
  private TextPaint mTextPaint = new TextPaint(1);
  
  private Drawable mThumbDrawable;
  
  private float mThumbPosition;
  
  private int mThumbTextPadding;
  
  private ColorStateList mThumbTintList = null;
  
  private PorterDuff.Mode mThumbTintMode = null;
  
  private int mThumbWidth;
  
  private int mTouchMode;
  
  private int mTouchSlop;
  
  private float mTouchX;
  
  private float mTouchY;
  
  private Drawable mTrackDrawable;
  
  private ColorStateList mTrackTintList = null;
  
  private PorterDuff.Mode mTrackTintMode = null;
  
  private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
  
  public SwitchCompat(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.switchStyle);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    Resources resources = getResources();
    this.mTextPaint.density = (resources.getDisplayMetrics()).density;
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SwitchCompat, paramInt, 0);
    this.mThumbDrawable = tintTypedArray.getDrawable(R.styleable.SwitchCompat_android_thumb);
    if (this.mThumbDrawable != null)
      this.mThumbDrawable.setCallback((Drawable.Callback)this); 
    this.mTrackDrawable = tintTypedArray.getDrawable(R.styleable.SwitchCompat_track);
    if (this.mTrackDrawable != null)
      this.mTrackDrawable.setCallback((Drawable.Callback)this); 
    this.mTextOn = tintTypedArray.getText(R.styleable.SwitchCompat_android_textOn);
    this.mTextOff = tintTypedArray.getText(R.styleable.SwitchCompat_android_textOff);
    this.mShowText = tintTypedArray.getBoolean(R.styleable.SwitchCompat_showText, true);
    this.mThumbTextPadding = tintTypedArray.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
    this.mSwitchMinWidth = tintTypedArray.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
    this.mSwitchPadding = tintTypedArray.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
    this.mSplitTrack = tintTypedArray.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
    ColorStateList colorStateList2 = tintTypedArray.getColorStateList(R.styleable.SwitchCompat_thumbTint);
    if (colorStateList2 != null) {
      this.mThumbTintList = colorStateList2;
      this.mHasThumbTint = true;
    } 
    PorterDuff.Mode mode2 = DrawableUtils.parseTintMode(tintTypedArray.getInt(R.styleable.SwitchCompat_thumbTintMode, -1), null);
    if (this.mThumbTintMode != mode2) {
      this.mThumbTintMode = mode2;
      this.mHasThumbTintMode = true;
    } 
    if (this.mHasThumbTint || this.mHasThumbTintMode)
      applyThumbTint(); 
    ColorStateList colorStateList1 = tintTypedArray.getColorStateList(R.styleable.SwitchCompat_trackTint);
    if (colorStateList1 != null) {
      this.mTrackTintList = colorStateList1;
      this.mHasTrackTint = true;
    } 
    PorterDuff.Mode mode1 = DrawableUtils.parseTintMode(tintTypedArray.getInt(R.styleable.SwitchCompat_trackTintMode, -1), null);
    if (this.mTrackTintMode != mode1) {
      this.mTrackTintMode = mode1;
      this.mHasTrackTintMode = true;
    } 
    if (this.mHasTrackTint || this.mHasTrackTintMode)
      applyTrackTint(); 
    paramInt = tintTypedArray.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
    if (paramInt != 0)
      setSwitchTextAppearance(paramContext, paramInt); 
    tintTypedArray.recycle();
    ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
    this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
    refreshDrawableState();
    setChecked(isChecked());
  }
  
  private void animateThumbToCheckedState(final boolean newCheckedState) {
    float f1;
    if (this.mPositionAnimator != null)
      cancelPositionAnimator(); 
    float f2 = this.mThumbPosition;
    if (newCheckedState) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    } 
    this.mPositionAnimator = new ThumbAnimation(f2, f1);
    this.mPositionAnimator.setDuration(250L);
    this.mPositionAnimator.setAnimationListener(new Animation.AnimationListener() {
          public void onAnimationEnd(Animation param1Animation) {
            if (SwitchCompat.this.mPositionAnimator == param1Animation) {
              float f;
              SwitchCompat switchCompat = SwitchCompat.this;
              if (newCheckedState) {
                f = 1.0F;
              } else {
                f = 0.0F;
              } 
              switchCompat.setThumbPosition(f);
              SwitchCompat.this.mPositionAnimator = null;
            } 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    startAnimation(this.mPositionAnimator);
  }
  
  private void applyThumbTint() {
    if (this.mThumbDrawable != null && (this.mHasThumbTint || this.mHasThumbTintMode)) {
      this.mThumbDrawable = this.mThumbDrawable.mutate();
      if (this.mHasThumbTint)
        DrawableCompat.setTintList(this.mThumbDrawable, this.mThumbTintList); 
      if (this.mHasThumbTintMode)
        DrawableCompat.setTintMode(this.mThumbDrawable, this.mThumbTintMode); 
      if (this.mThumbDrawable.isStateful())
        this.mThumbDrawable.setState(getDrawableState()); 
    } 
  }
  
  private void applyTrackTint() {
    if (this.mTrackDrawable != null && (this.mHasTrackTint || this.mHasTrackTintMode)) {
      this.mTrackDrawable = this.mTrackDrawable.mutate();
      if (this.mHasTrackTint)
        DrawableCompat.setTintList(this.mTrackDrawable, this.mTrackTintList); 
      if (this.mHasTrackTintMode)
        DrawableCompat.setTintMode(this.mTrackDrawable, this.mTrackTintMode); 
      if (this.mTrackDrawable.isStateful())
        this.mTrackDrawable.setState(getDrawableState()); 
    } 
  }
  
  private void cancelPositionAnimator() {
    if (this.mPositionAnimator != null) {
      clearAnimation();
      this.mPositionAnimator = null;
    } 
  }
  
  private void cancelSuperTouch(MotionEvent paramMotionEvent) {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3) {
    return (paramFloat1 < paramFloat2) ? paramFloat2 : ((paramFloat1 > paramFloat3) ? paramFloat3 : paramFloat1);
  }
  
  private boolean getTargetCheckedState() {
    return (this.mThumbPosition > 0.5F);
  }
  
  private int getThumbOffset() {
    if (ViewUtils.isLayoutRtl((View)this)) {
      float f1 = 1.0F - this.mThumbPosition;
      return (int)(getThumbScrollRange() * f1 + 0.5F);
    } 
    float f = this.mThumbPosition;
    return (int)(getThumbScrollRange() * f + 0.5F);
  }
  
  private int getThumbScrollRange() {
    if (this.mTrackDrawable != null) {
      Rect rect2 = this.mTempRect;
      this.mTrackDrawable.getPadding(rect2);
      if (this.mThumbDrawable != null) {
        Rect rect = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
        return this.mSwitchWidth - this.mThumbWidth - rect2.left - rect2.right - rect.left - rect.right;
      } 
      Rect rect1 = DrawableUtils.INSETS_NONE;
      return this.mSwitchWidth - this.mThumbWidth - rect2.left - rect2.right - rect1.left - rect1.right;
    } 
    return 0;
  }
  
  private boolean hitThumb(float paramFloat1, float paramFloat2) {
    if (this.mThumbDrawable != null) {
      int k = getThumbOffset();
      this.mThumbDrawable.getPadding(this.mTempRect);
      int i = this.mSwitchTop;
      int j = this.mTouchSlop;
      k = this.mSwitchLeft + k - this.mTouchSlop;
      int m = this.mThumbWidth;
      int n = this.mTempRect.left;
      int i1 = this.mTempRect.right;
      int i2 = this.mTouchSlop;
      int i3 = this.mSwitchBottom;
      int i4 = this.mTouchSlop;
      if (paramFloat1 > k && paramFloat1 < (m + k + n + i1 + i2) && paramFloat2 > (i - j) && paramFloat2 < (i3 + i4))
        return true; 
    } 
    return false;
  }
  
  private Layout makeLayout(CharSequence paramCharSequence) {
    if (this.mSwitchTransformationMethod != null)
      paramCharSequence = this.mSwitchTransformationMethod.getTransformation(paramCharSequence, (View)this); 
    TextPaint textPaint = this.mTextPaint;
    if (paramCharSequence != null) {
      int i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.mTextPaint));
      return (Layout)new StaticLayout(paramCharSequence, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    } 
    boolean bool = false;
    return (Layout)new StaticLayout(paramCharSequence, textPaint, bool, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
  }
  
  private void setSwitchTypefaceByIndex(int paramInt1, int paramInt2) {
    Typeface typeface = null;
    switch (paramInt1) {
      default:
        setSwitchTypeface(typeface, paramInt2);
        return;
      case 1:
        typeface = Typeface.SANS_SERIF;
      case 2:
        typeface = Typeface.SERIF;
      case 3:
        break;
    } 
    typeface = Typeface.MONOSPACE;
  }
  
  private void stopDrag(MotionEvent paramMotionEvent) {
    boolean bool;
    boolean bool1;
    this.mTouchMode = 0;
    if (paramMotionEvent.getAction() == 1 && isEnabled()) {
      bool = true;
    } else {
      bool = false;
    } 
    boolean bool2 = isChecked();
    if (bool) {
      this.mVelocityTracker.computeCurrentVelocity(1000);
      float f = this.mVelocityTracker.getXVelocity();
      if (Math.abs(f) > this.mMinFlingVelocity) {
        if (ViewUtils.isLayoutRtl((View)this)) {
          if (f < 0.0F) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
        } else if (f > 0.0F) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
      } else {
        bool1 = getTargetCheckedState();
      } 
    } else {
      bool1 = bool2;
    } 
    if (bool1 != bool2)
      playSoundEffect(0); 
    setChecked(bool1);
    cancelSuperTouch(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas) {
    Rect rect1;
    Rect rect2 = this.mTempRect;
    int m = this.mSwitchLeft;
    int n = this.mSwitchTop;
    int j = this.mSwitchRight;
    int i1 = this.mSwitchBottom;
    int k = m + getThumbOffset();
    if (this.mThumbDrawable != null) {
      rect1 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
    } else {
      rect1 = DrawableUtils.INSETS_NONE;
    } 
    int i = k;
    if (this.mTrackDrawable != null) {
      this.mTrackDrawable.getPadding(rect2);
      int i7 = k + rect2.left;
      k = n;
      int i2 = i1;
      int i6 = i2;
      int i3 = m;
      int i4 = j;
      int i5 = k;
      if (rect1 != null) {
        i = m;
        if (rect1.left > rect2.left)
          i = m + rect1.left - rect2.left; 
        m = k;
        if (rect1.top > rect2.top)
          m = k + rect1.top - rect2.top; 
        k = j;
        if (rect1.right > rect2.right)
          k = j - rect1.right - rect2.right; 
        i6 = i2;
        i3 = i;
        i4 = k;
        i5 = m;
        if (rect1.bottom > rect2.bottom) {
          i6 = i2 - rect1.bottom - rect2.bottom;
          i5 = m;
          i4 = k;
          i3 = i;
        } 
      } 
      this.mTrackDrawable.setBounds(i3, i5, i4, i6);
      i = i7;
    } 
    if (this.mThumbDrawable != null) {
      this.mThumbDrawable.getPadding(rect2);
      j = i - rect2.left;
      i = this.mThumbWidth + i + rect2.right;
      this.mThumbDrawable.setBounds(j, n, i, i1);
      Drawable drawable = getBackground();
      if (drawable != null)
        DrawableCompat.setHotspotBounds(drawable, j, n, i, i1); 
    } 
    super.draw(paramCanvas);
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2) {
    if (Build.VERSION.SDK_INT >= 21)
      super.drawableHotspotChanged(paramFloat1, paramFloat2); 
    if (this.mThumbDrawable != null)
      DrawableCompat.setHotspot(this.mThumbDrawable, paramFloat1, paramFloat2); 
    if (this.mTrackDrawable != null)
      DrawableCompat.setHotspot(this.mTrackDrawable, paramFloat1, paramFloat2); 
  }
  
  protected void drawableStateChanged() {
    boolean bool;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    int j = 0;
    Drawable drawable = this.mThumbDrawable;
    int i = j;
    if (drawable != null) {
      i = j;
      if (drawable.isStateful())
        i = false | drawable.setState(arrayOfInt); 
    } 
    drawable = this.mTrackDrawable;
    j = i;
    if (drawable != null) {
      j = i;
      if (drawable.isStateful())
        bool = i | drawable.setState(arrayOfInt); 
    } 
    if (bool)
      invalidate(); 
  }
  
  public int getCompoundPaddingLeft() {
    if (!ViewUtils.isLayoutRtl((View)this))
      return super.getCompoundPaddingLeft(); 
    int j = super.getCompoundPaddingLeft() + this.mSwitchWidth;
    int i = j;
    return !TextUtils.isEmpty(getText()) ? (j + this.mSwitchPadding) : i;
  }
  
  public int getCompoundPaddingRight() {
    if (ViewUtils.isLayoutRtl((View)this))
      return super.getCompoundPaddingRight(); 
    int j = super.getCompoundPaddingRight() + this.mSwitchWidth;
    int i = j;
    return !TextUtils.isEmpty(getText()) ? (j + this.mSwitchPadding) : i;
  }
  
  public boolean getShowText() {
    return this.mShowText;
  }
  
  public boolean getSplitTrack() {
    return this.mSplitTrack;
  }
  
  public int getSwitchMinWidth() {
    return this.mSwitchMinWidth;
  }
  
  public int getSwitchPadding() {
    return this.mSwitchPadding;
  }
  
  public CharSequence getTextOff() {
    return this.mTextOff;
  }
  
  public CharSequence getTextOn() {
    return this.mTextOn;
  }
  
  public Drawable getThumbDrawable() {
    return this.mThumbDrawable;
  }
  
  public int getThumbTextPadding() {
    return this.mThumbTextPadding;
  }
  
  @Nullable
  public ColorStateList getThumbTintList() {
    return this.mThumbTintList;
  }
  
  @Nullable
  public PorterDuff.Mode getThumbTintMode() {
    return this.mThumbTintMode;
  }
  
  public Drawable getTrackDrawable() {
    return this.mTrackDrawable;
  }
  
  @Nullable
  public ColorStateList getTrackTintList() {
    return this.mTrackTintList;
  }
  
  @Nullable
  public PorterDuff.Mode getTrackTintMode() {
    return this.mTrackTintMode;
  }
  
  public void jumpDrawablesToCurrentState() {
    if (Build.VERSION.SDK_INT >= 11) {
      float f;
      super.jumpDrawablesToCurrentState();
      if (this.mThumbDrawable != null)
        this.mThumbDrawable.jumpToCurrentState(); 
      if (this.mTrackDrawable != null)
        this.mTrackDrawable.jumpToCurrentState(); 
      cancelPositionAnimator();
      if (isChecked()) {
        f = 1.0F;
      } else {
        f = 0.0F;
      } 
      setThumbPosition(f);
    } 
  }
  
  protected int[] onCreateDrawableState(int paramInt) {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked())
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET); 
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    Layout layout;
    super.onDraw(paramCanvas);
    Rect rect = this.mTempRect;
    Drawable drawable2 = this.mTrackDrawable;
    if (drawable2 != null) {
      drawable2.getPadding(rect);
    } else {
      rect.setEmpty();
    } 
    int j = this.mSwitchTop;
    int k = this.mSwitchBottom;
    int m = rect.top;
    int n = rect.bottom;
    Drawable drawable1 = this.mThumbDrawable;
    if (drawable2 != null)
      if (this.mSplitTrack && drawable1 != null) {
        Rect rect1 = DrawableUtils.getOpticalBounds(drawable1);
        drawable1.copyBounds(rect);
        rect.left += rect1.left;
        rect.right -= rect1.right;
        int i1 = paramCanvas.save();
        paramCanvas.clipRect(rect, Region.Op.DIFFERENCE);
        drawable2.draw(paramCanvas);
        paramCanvas.restoreToCount(i1);
      } else {
        drawable2.draw(paramCanvas);
      }  
    int i = paramCanvas.save();
    if (drawable1 != null)
      drawable1.draw(paramCanvas); 
    if (getTargetCheckedState()) {
      layout = this.mOnLayout;
    } else {
      layout = this.mOffLayout;
    } 
    if (layout != null) {
      int i1;
      int[] arrayOfInt = getDrawableState();
      if (this.mTextColors != null)
        this.mTextPaint.setColor(this.mTextColors.getColorForState(arrayOfInt, 0)); 
      this.mTextPaint.drawableState = arrayOfInt;
      if (drawable1 != null) {
        Rect rect1 = drawable1.getBounds();
        i1 = rect1.left + rect1.right;
      } else {
        i1 = getWidth();
      } 
      i1 /= 2;
      int i2 = layout.getWidth() / 2;
      j = (j + m + k - n) / 2;
      k = layout.getHeight() / 2;
      paramCanvas.translate((i1 - i2), (j - k));
      layout.draw(paramCanvas);
    } 
    paramCanvas.restoreToCount(i);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    CharSequence charSequence1;
    CharSequence charSequence2;
    if (Build.VERSION.SDK_INT >= 14) {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
      if (isChecked()) {
        charSequence1 = this.mTextOn;
      } else {
        charSequence1 = this.mTextOff;
      } 
      if (!TextUtils.isEmpty(charSequence1)) {
        charSequence2 = paramAccessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(charSequence2)) {
          paramAccessibilityNodeInfo.setText(charSequence1);
          return;
        } 
      } else {
        return;
      } 
    } else {
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(charSequence2).append(' ').append(charSequence1);
    paramAccessibilityNodeInfo.setText(stringBuilder);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    paramInt2 = 0;
    if (this.mThumbDrawable != null) {
      Rect rect1 = this.mTempRect;
      if (this.mTrackDrawable != null) {
        this.mTrackDrawable.getPadding(rect1);
      } else {
        rect1.setEmpty();
      } 
      Rect rect2 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
      paramInt1 = Math.max(0, rect2.left - rect1.left);
      paramInt2 = Math.max(0, rect2.right - rect1.right);
    } 
    if (ViewUtils.isLayoutRtl((View)this)) {
      paramInt3 = getPaddingLeft() + paramInt1;
      paramInt4 = this.mSwitchWidth + paramInt3 - paramInt1 - paramInt2;
    } else {
      paramInt4 = getWidth() - getPaddingRight() - paramInt2;
      paramInt3 = paramInt4 - this.mSwitchWidth + paramInt1 + paramInt2;
    } 
    switch (getGravity() & 0x70) {
      default:
        paramInt2 = getPaddingTop();
        paramInt1 = paramInt2 + this.mSwitchHeight;
        this.mSwitchLeft = paramInt3;
        this.mSwitchTop = paramInt2;
        this.mSwitchBottom = paramInt1;
        this.mSwitchRight = paramInt4;
        return;
      case 16:
        paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.mSwitchHeight / 2;
        paramInt1 = paramInt2 + this.mSwitchHeight;
        this.mSwitchLeft = paramInt3;
        this.mSwitchTop = paramInt2;
        this.mSwitchBottom = paramInt1;
        this.mSwitchRight = paramInt4;
        return;
      case 80:
        break;
    } 
    paramInt1 = getHeight() - getPaddingBottom();
    paramInt2 = paramInt1 - this.mSwitchHeight;
    this.mSwitchLeft = paramInt3;
    this.mSwitchTop = paramInt2;
    this.mSwitchBottom = paramInt1;
    this.mSwitchRight = paramInt4;
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    int j;
    if (this.mShowText) {
      if (this.mOnLayout == null)
        this.mOnLayout = makeLayout(this.mTextOn); 
      if (this.mOffLayout == null)
        this.mOffLayout = makeLayout(this.mTextOff); 
    } 
    Rect rect = this.mTempRect;
    if (this.mThumbDrawable != null) {
      this.mThumbDrawable.getPadding(rect);
      j = this.mThumbDrawable.getIntrinsicWidth() - rect.left - rect.right;
      i = this.mThumbDrawable.getIntrinsicHeight();
    } else {
      j = 0;
      i = 0;
    } 
    if (this.mShowText) {
      k = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + this.mThumbTextPadding * 2;
    } else {
      k = 0;
    } 
    this.mThumbWidth = Math.max(k, j);
    if (this.mTrackDrawable != null) {
      this.mTrackDrawable.getPadding(rect);
      j = this.mTrackDrawable.getIntrinsicHeight();
    } else {
      rect.setEmpty();
      j = 0;
    } 
    int i1 = rect.left;
    int n = rect.right;
    int m = i1;
    int k = n;
    if (this.mThumbDrawable != null) {
      rect = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
      m = Math.max(i1, rect.left);
      k = Math.max(n, rect.right);
    } 
    k = Math.max(this.mSwitchMinWidth, this.mThumbWidth * 2 + m + k);
    int i = Math.max(j, i);
    this.mSwitchWidth = k;
    this.mSwitchHeight = i;
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < i)
      setMeasuredDimension(ViewCompat.getMeasuredWidthAndState((View)this), i); 
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    CharSequence charSequence;
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (isChecked()) {
      charSequence = this.mTextOn;
    } else {
      charSequence = this.mTextOff;
    } 
    if (charSequence != null)
      paramAccessibilityEvent.getText().add(charSequence); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    float f1;
    float f2;
    float f3;
    int i;
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (MotionEventCompat.getActionMasked(paramMotionEvent)) {
      default:
      
      case 0:
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        if (isEnabled() && hitThumb(f1, f2)) {
          this.mTouchMode = 1;
          this.mTouchX = f1;
          this.mTouchY = f2;
        } 
      case 2:
        switch (this.mTouchMode) {
          case 0:
          case 0:
            return super.onTouchEvent(paramMotionEvent);
          case 1:
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            if (Math.abs(f1 - this.mTouchX) > this.mTouchSlop || Math.abs(f2 - this.mTouchY) > this.mTouchSlop) {
              this.mTouchMode = 2;
              getParent().requestDisallowInterceptTouchEvent(true);
              this.mTouchX = f1;
              this.mTouchY = f2;
              return true;
            } 
          case 2:
            break;
        } 
        f3 = paramMotionEvent.getX();
        i = getThumbScrollRange();
        f1 = f3 - this.mTouchX;
        if (i != 0) {
          f1 /= i;
        } else if (f1 > 0.0F) {
          f1 = 1.0F;
        } else {
          f1 = -1.0F;
        } 
        f2 = f1;
        if (ViewUtils.isLayoutRtl((View)this))
          f2 = -f1; 
        f1 = constrain(this.mThumbPosition + f2, 0.0F, 1.0F);
        if (f1 != this.mThumbPosition) {
          this.mTouchX = f3;
          setThumbPosition(f1);
        } 
        return true;
      case 1:
      case 3:
        break;
    } 
    if (this.mTouchMode == 2) {
      stopDrag(paramMotionEvent);
      super.onTouchEvent(paramMotionEvent);
      return true;
    } 
    this.mTouchMode = 0;
    this.mVelocityTracker.clear();
  }
  
  public void setChecked(boolean paramBoolean) {
    float f;
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if (getWindowToken() != null && ViewCompat.isLaidOut((View)this) && isShown()) {
      animateThumbToCheckedState(paramBoolean);
      return;
    } 
    cancelPositionAnimator();
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.0F;
    } 
    setThumbPosition(f);
  }
  
  public void setShowText(boolean paramBoolean) {
    if (this.mShowText != paramBoolean) {
      this.mShowText = paramBoolean;
      requestLayout();
    } 
  }
  
  public void setSplitTrack(boolean paramBoolean) {
    this.mSplitTrack = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt) {
    this.mSwitchMinWidth = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt) {
    this.mSwitchPadding = paramInt;
    requestLayout();
  }
  
  public void setSwitchTextAppearance(Context paramContext, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    ColorStateList colorStateList = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
    if (colorStateList != null) {
      this.mTextColors = colorStateList;
    } else {
      this.mTextColors = getTextColors();
    } 
    paramInt = tintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
    if (paramInt != 0 && paramInt != this.mTextPaint.getTextSize()) {
      this.mTextPaint.setTextSize(paramInt);
      requestLayout();
    } 
    setSwitchTypefaceByIndex(tintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, -1), tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, -1));
    if (tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
      this.mSwitchTransformationMethod = (TransformationMethod)new AllCapsTransformationMethod(getContext());
    } else {
      this.mSwitchTransformationMethod = null;
    } 
    tintTypedArray.recycle();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface) {
    if (this.mTextPaint.getTypeface() != paramTypeface) {
      this.mTextPaint.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    } 
  }
  
  public void setSwitchTypeface(Typeface paramTypeface, int paramInt) {
    TextPaint textPaint;
    boolean bool = false;
    if (paramInt > 0) {
      float f;
      boolean bool1;
      if (paramTypeface == null) {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
      } else {
        paramTypeface = Typeface.create(paramTypeface, paramInt);
      } 
      setSwitchTypeface(paramTypeface);
      if (paramTypeface != null) {
        bool1 = paramTypeface.getStyle();
      } else {
        bool1 = false;
      } 
      paramInt &= bool1 ^ 0xFFFFFFFF;
      textPaint = this.mTextPaint;
      if ((paramInt & 0x1) != 0)
        bool = true; 
      textPaint.setFakeBoldText(bool);
      textPaint = this.mTextPaint;
      if ((paramInt & 0x2) != 0) {
        f = -0.25F;
      } else {
        f = 0.0F;
      } 
      textPaint.setTextSkewX(f);
      return;
    } 
    this.mTextPaint.setFakeBoldText(false);
    this.mTextPaint.setTextSkewX(0.0F);
    setSwitchTypeface((Typeface)textPaint);
  }
  
  public void setTextOff(CharSequence paramCharSequence) {
    this.mTextOff = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence) {
    this.mTextOn = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable) {
    if (this.mThumbDrawable != null)
      this.mThumbDrawable.setCallback(null); 
    this.mThumbDrawable = paramDrawable;
    if (paramDrawable != null)
      paramDrawable.setCallback((Drawable.Callback)this); 
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat) {
    this.mThumbPosition = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt) {
    setThumbDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt) {
    this.mThumbTextPadding = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(@Nullable ColorStateList paramColorStateList) {
    this.mThumbTintList = paramColorStateList;
    this.mHasThumbTint = true;
    applyThumbTint();
  }
  
  public void setThumbTintMode(@Nullable PorterDuff.Mode paramMode) {
    this.mThumbTintMode = paramMode;
    this.mHasThumbTintMode = true;
    applyThumbTint();
  }
  
  public void setTrackDrawable(Drawable paramDrawable) {
    if (this.mTrackDrawable != null)
      this.mTrackDrawable.setCallback(null); 
    this.mTrackDrawable = paramDrawable;
    if (paramDrawable != null)
      paramDrawable.setCallback((Drawable.Callback)this); 
    requestLayout();
  }
  
  public void setTrackResource(int paramInt) {
    setTrackDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setTrackTintList(@Nullable ColorStateList paramColorStateList) {
    this.mTrackTintList = paramColorStateList;
    this.mHasTrackTint = true;
    applyTrackTint();
  }
  
  public void setTrackTintMode(@Nullable PorterDuff.Mode paramMode) {
    this.mTrackTintMode = paramMode;
    this.mHasTrackTintMode = true;
    applyTrackTint();
  }
  
  public void toggle() {
    boolean bool;
    if (!isChecked()) {
      bool = true;
    } else {
      bool = false;
    } 
    setChecked(bool);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) {
    return (super.verifyDrawable(paramDrawable) || paramDrawable == this.mThumbDrawable || paramDrawable == this.mTrackDrawable);
  }
  
  private class ThumbAnimation extends Animation {
    final float mDiff;
    
    final float mEndPosition;
    
    final float mStartPosition;
    
    ThumbAnimation(float param1Float1, float param1Float2) {
      this.mStartPosition = param1Float1;
      this.mEndPosition = param1Float2;
      this.mDiff = param1Float2 - param1Float1;
    }
    
    protected void applyTransformation(float param1Float, Transformation param1Transformation) {
      SwitchCompat.this.setThumbPosition(this.mStartPosition + this.mDiff * param1Float);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\SwitchCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */