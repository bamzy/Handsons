package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

class MaterialProgressDrawable extends Drawable implements Animatable {
  private static final int ANIMATION_DURATION = 1332;
  
  private static final int ARROW_HEIGHT = 5;
  
  private static final int ARROW_HEIGHT_LARGE = 6;
  
  private static final float ARROW_OFFSET_ANGLE = 5.0F;
  
  private static final int ARROW_WIDTH = 10;
  
  private static final int ARROW_WIDTH_LARGE = 12;
  
  private static final float CENTER_RADIUS = 8.75F;
  
  private static final float CENTER_RADIUS_LARGE = 12.5F;
  
  private static final int CIRCLE_DIAMETER = 40;
  
  private static final int CIRCLE_DIAMETER_LARGE = 56;
  
  private static final int[] COLORS;
  
  private static final float COLOR_START_DELAY_OFFSET = 0.75F;
  
  static final int DEFAULT = 1;
  
  private static final float END_TRIM_START_DELAY_OFFSET = 0.5F;
  
  private static final float FULL_ROTATION = 1080.0F;
  
  static final int LARGE = 0;
  
  private static final Interpolator LINEAR_INTERPOLATOR = (Interpolator)new LinearInterpolator();
  
  static final Interpolator MATERIAL_INTERPOLATOR = (Interpolator)new FastOutSlowInInterpolator();
  
  private static final float MAX_PROGRESS_ARC = 0.8F;
  
  private static final float NUM_POINTS = 5.0F;
  
  private static final float START_TRIM_DURATION_OFFSET = 0.5F;
  
  private static final float STROKE_WIDTH = 2.5F;
  
  private static final float STROKE_WIDTH_LARGE = 3.0F;
  
  private Animation mAnimation;
  
  private final ArrayList<Animation> mAnimators = new ArrayList<Animation>();
  
  private final Drawable.Callback mCallback = new Drawable.Callback() {
      public void invalidateDrawable(Drawable param1Drawable) {
        MaterialProgressDrawable.this.invalidateSelf();
      }
      
      public void scheduleDrawable(Drawable param1Drawable, Runnable param1Runnable, long param1Long) {
        MaterialProgressDrawable.this.scheduleSelf(param1Runnable, param1Long);
      }
      
      public void unscheduleDrawable(Drawable param1Drawable, Runnable param1Runnable) {
        MaterialProgressDrawable.this.unscheduleSelf(param1Runnable);
      }
    };
  
  boolean mFinishing;
  
  private double mHeight;
  
  private View mParent;
  
  private Resources mResources;
  
  private final Ring mRing;
  
  private float mRotation;
  
  float mRotationCount;
  
  private double mWidth;
  
  static {
    COLORS = new int[] { -16777216 };
  }
  
  MaterialProgressDrawable(Context paramContext, View paramView) {
    this.mParent = paramView;
    this.mResources = paramContext.getResources();
    this.mRing = new Ring(this.mCallback);
    this.mRing.setColors(COLORS);
    updateSizes(1);
    setupAnimators();
  }
  
  private int evaluateColorChange(float paramFloat, int paramInt1, int paramInt2) {
    int k = Integer.valueOf(paramInt1).intValue();
    paramInt1 = k >> 24 & 0xFF;
    int i = k >> 16 & 0xFF;
    int j = k >> 8 & 0xFF;
    k &= 0xFF;
    paramInt2 = Integer.valueOf(paramInt2).intValue();
    return (int)(((paramInt2 >> 24 & 0xFF) - paramInt1) * paramFloat) + paramInt1 << 24 | (int)(((paramInt2 >> 16 & 0xFF) - i) * paramFloat) + i << 16 | (int)(((paramInt2 >> 8 & 0xFF) - j) * paramFloat) + j << 8 | (int)(((paramInt2 & 0xFF) - k) * paramFloat) + k;
  }
  
  private float getRotation() {
    return this.mRotation;
  }
  
  private void setSizeParameters(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float paramFloat1, float paramFloat2) {
    Ring ring = this.mRing;
    float f = (this.mResources.getDisplayMetrics()).density;
    this.mWidth = f * paramDouble1;
    this.mHeight = f * paramDouble2;
    ring.setStrokeWidth((float)paramDouble4 * f);
    ring.setCenterRadius(f * paramDouble3);
    ring.setColorIndex(0);
    ring.setArrowDimensions(paramFloat1 * f, paramFloat2 * f);
    ring.setInsets((int)this.mWidth, (int)this.mHeight);
  }
  
  private void setupAnimators() {
    final Ring ring = this.mRing;
    Animation animation = new Animation() {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          if (MaterialProgressDrawable.this.mFinishing) {
            MaterialProgressDrawable.this.applyFinishTranslation(param1Float, ring);
            return;
          } 
          float f1 = MaterialProgressDrawable.this.getMinProgressArc(ring);
          float f2 = ring.getStartingEndTrim();
          float f4 = ring.getStartingStartTrim();
          float f3 = ring.getStartingRotation();
          MaterialProgressDrawable.this.updateRingColor(param1Float, ring);
          if (param1Float <= 0.5F) {
            float f = param1Float / 0.5F;
            f = MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(f);
            ring.setStartTrim(f4 + (0.8F - f1) * f);
          } 
          if (param1Float > 0.5F) {
            f4 = (param1Float - 0.5F) / 0.5F;
            f4 = MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(f4);
            ring.setEndTrim(f2 + f4 * (0.8F - f1));
          } 
          ring.setRotation(f3 + 0.25F * param1Float);
          f1 = MaterialProgressDrawable.this.mRotationCount / 5.0F;
          MaterialProgressDrawable.this.setRotation(216.0F * param1Float + 1080.0F * f1);
        }
      };
    animation.setRepeatCount(-1);
    animation.setRepeatMode(1);
    animation.setInterpolator(LINEAR_INTERPOLATOR);
    animation.setAnimationListener(new Animation.AnimationListener() {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {
            ring.storeOriginals();
            ring.goToNextColor();
            ring.setStartTrim(ring.getEndTrim());
            if (MaterialProgressDrawable.this.mFinishing) {
              MaterialProgressDrawable.this.mFinishing = false;
              param1Animation.setDuration(1332L);
              ring.setShowArrow(false);
              return;
            } 
            MaterialProgressDrawable.this.mRotationCount = (MaterialProgressDrawable.this.mRotationCount + 1.0F) % 5.0F;
          }
          
          public void onAnimationStart(Animation param1Animation) {
            MaterialProgressDrawable.this.mRotationCount = 0.0F;
          }
        });
    this.mAnimation = animation;
  }
  
  void applyFinishTranslation(float paramFloat, Ring paramRing) {
    updateRingColor(paramFloat, paramRing);
    float f1 = (float)(Math.floor((paramRing.getStartingRotation() / 0.8F)) + 1.0D);
    float f2 = getMinProgressArc(paramRing);
    paramRing.setStartTrim(paramRing.getStartingStartTrim() + (paramRing.getStartingEndTrim() - f2 - paramRing.getStartingStartTrim()) * paramFloat);
    paramRing.setEndTrim(paramRing.getStartingEndTrim());
    paramRing.setRotation(paramRing.getStartingRotation() + (f1 - paramRing.getStartingRotation()) * paramFloat);
  }
  
  public void draw(Canvas paramCanvas) {
    Rect rect = getBounds();
    int i = paramCanvas.save();
    paramCanvas.rotate(this.mRotation, rect.exactCenterX(), rect.exactCenterY());
    this.mRing.draw(paramCanvas, rect);
    paramCanvas.restoreToCount(i);
  }
  
  public int getAlpha() {
    return this.mRing.getAlpha();
  }
  
  public int getIntrinsicHeight() {
    return (int)this.mHeight;
  }
  
  public int getIntrinsicWidth() {
    return (int)this.mWidth;
  }
  
  float getMinProgressArc(Ring paramRing) {
    return (float)Math.toRadians(paramRing.getStrokeWidth() / 6.283185307179586D * paramRing.getCenterRadius());
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public boolean isRunning() {
    ArrayList<Animation> arrayList = this.mAnimators;
    int j = arrayList.size();
    for (int i = 0; i < j; i++) {
      Animation animation = arrayList.get(i);
      if (animation.hasStarted() && !animation.hasEnded())
        return true; 
    } 
    return false;
  }
  
  public void setAlpha(int paramInt) {
    this.mRing.setAlpha(paramInt);
  }
  
  public void setArrowScale(float paramFloat) {
    this.mRing.setArrowScale(paramFloat);
  }
  
  public void setBackgroundColor(int paramInt) {
    this.mRing.setBackgroundColor(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.mRing.setColorFilter(paramColorFilter);
  }
  
  public void setColorSchemeColors(int... paramVarArgs) {
    this.mRing.setColors(paramVarArgs);
    this.mRing.setColorIndex(0);
  }
  
  public void setProgressRotation(float paramFloat) {
    this.mRing.setRotation(paramFloat);
  }
  
  void setRotation(float paramFloat) {
    this.mRotation = paramFloat;
    invalidateSelf();
  }
  
  public void setStartEndTrim(float paramFloat1, float paramFloat2) {
    this.mRing.setStartTrim(paramFloat1);
    this.mRing.setEndTrim(paramFloat2);
  }
  
  public void showArrow(boolean paramBoolean) {
    this.mRing.setShowArrow(paramBoolean);
  }
  
  public void start() {
    this.mAnimation.reset();
    this.mRing.storeOriginals();
    if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
      this.mFinishing = true;
      this.mAnimation.setDuration(666L);
      this.mParent.startAnimation(this.mAnimation);
      return;
    } 
    this.mRing.setColorIndex(0);
    this.mRing.resetOriginals();
    this.mAnimation.setDuration(1332L);
    this.mParent.startAnimation(this.mAnimation);
  }
  
  public void stop() {
    this.mParent.clearAnimation();
    setRotation(0.0F);
    this.mRing.setShowArrow(false);
    this.mRing.setColorIndex(0);
    this.mRing.resetOriginals();
  }
  
  void updateRingColor(float paramFloat, Ring paramRing) {
    if (paramFloat > 0.75F)
      paramRing.setColor(evaluateColorChange((paramFloat - 0.75F) / 0.25F, paramRing.getStartingColor(), paramRing.getNextColor())); 
  }
  
  public void updateSizes(int paramInt) {
    if (paramInt == 0) {
      setSizeParameters(56.0D, 56.0D, 12.5D, 3.0D, 12.0F, 6.0F);
      return;
    } 
    setSizeParameters(40.0D, 40.0D, 8.75D, 2.5D, 10.0F, 5.0F);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ProgressDrawableSize {}
  
  private static class Ring {
    private int mAlpha;
    
    private Path mArrow;
    
    private int mArrowHeight;
    
    private final Paint mArrowPaint = new Paint();
    
    private float mArrowScale;
    
    private int mArrowWidth;
    
    private int mBackgroundColor;
    
    private final Drawable.Callback mCallback;
    
    private final Paint mCirclePaint = new Paint(1);
    
    private int mColorIndex;
    
    private int[] mColors;
    
    private int mCurrentColor;
    
    private float mEndTrim = 0.0F;
    
    private final Paint mPaint = new Paint();
    
    private double mRingCenterRadius;
    
    private float mRotation = 0.0F;
    
    private boolean mShowArrow;
    
    private float mStartTrim = 0.0F;
    
    private float mStartingEndTrim;
    
    private float mStartingRotation;
    
    private float mStartingStartTrim;
    
    private float mStrokeInset = 2.5F;
    
    private float mStrokeWidth = 5.0F;
    
    private final RectF mTempBounds = new RectF();
    
    Ring(Drawable.Callback param1Callback) {
      this.mCallback = param1Callback;
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mArrowPaint.setStyle(Paint.Style.FILL);
      this.mArrowPaint.setAntiAlias(true);
    }
    
    private void drawTriangle(Canvas param1Canvas, float param1Float1, float param1Float2, Rect param1Rect) {
      if (this.mShowArrow) {
        if (this.mArrow == null) {
          this.mArrow = new Path();
          this.mArrow.setFillType(Path.FillType.EVEN_ODD);
        } else {
          this.mArrow.reset();
        } 
        float f1 = ((int)this.mStrokeInset / 2);
        float f2 = this.mArrowScale;
        float f3 = (float)(this.mRingCenterRadius * Math.cos(0.0D) + param1Rect.exactCenterX());
        float f4 = (float)(this.mRingCenterRadius * Math.sin(0.0D) + param1Rect.exactCenterY());
        this.mArrow.moveTo(0.0F, 0.0F);
        this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0F);
        this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale / 2.0F, this.mArrowHeight * this.mArrowScale);
        this.mArrow.offset(f3 - f1 * f2, f4);
        this.mArrow.close();
        this.mArrowPaint.setColor(this.mCurrentColor);
        param1Canvas.rotate(param1Float1 + param1Float2 - 5.0F, param1Rect.exactCenterX(), param1Rect.exactCenterY());
        param1Canvas.drawPath(this.mArrow, this.mArrowPaint);
      } 
    }
    
    private int getNextColorIndex() {
      return (this.mColorIndex + 1) % this.mColors.length;
    }
    
    private void invalidateSelf() {
      this.mCallback.invalidateDrawable(null);
    }
    
    public void draw(Canvas param1Canvas, Rect param1Rect) {
      RectF rectF = this.mTempBounds;
      rectF.set(param1Rect);
      rectF.inset(this.mStrokeInset, this.mStrokeInset);
      float f1 = (this.mStartTrim + this.mRotation) * 360.0F;
      float f2 = (this.mEndTrim + this.mRotation) * 360.0F - f1;
      this.mPaint.setColor(this.mCurrentColor);
      param1Canvas.drawArc(rectF, f1, f2, false, this.mPaint);
      drawTriangle(param1Canvas, f1, f2, param1Rect);
      if (this.mAlpha < 255) {
        this.mCirclePaint.setColor(this.mBackgroundColor);
        this.mCirclePaint.setAlpha(255 - this.mAlpha);
        param1Canvas.drawCircle(param1Rect.exactCenterX(), param1Rect.exactCenterY(), (param1Rect.width() / 2), this.mCirclePaint);
      } 
    }
    
    public int getAlpha() {
      return this.mAlpha;
    }
    
    public double getCenterRadius() {
      return this.mRingCenterRadius;
    }
    
    public float getEndTrim() {
      return this.mEndTrim;
    }
    
    public float getInsets() {
      return this.mStrokeInset;
    }
    
    public int getNextColor() {
      return this.mColors[getNextColorIndex()];
    }
    
    public float getRotation() {
      return this.mRotation;
    }
    
    public float getStartTrim() {
      return this.mStartTrim;
    }
    
    public int getStartingColor() {
      return this.mColors[this.mColorIndex];
    }
    
    public float getStartingEndTrim() {
      return this.mStartingEndTrim;
    }
    
    public float getStartingRotation() {
      return this.mStartingRotation;
    }
    
    public float getStartingStartTrim() {
      return this.mStartingStartTrim;
    }
    
    public float getStrokeWidth() {
      return this.mStrokeWidth;
    }
    
    public void goToNextColor() {
      setColorIndex(getNextColorIndex());
    }
    
    public void resetOriginals() {
      this.mStartingStartTrim = 0.0F;
      this.mStartingEndTrim = 0.0F;
      this.mStartingRotation = 0.0F;
      setStartTrim(0.0F);
      setEndTrim(0.0F);
      setRotation(0.0F);
    }
    
    public void setAlpha(int param1Int) {
      this.mAlpha = param1Int;
    }
    
    public void setArrowDimensions(float param1Float1, float param1Float2) {
      this.mArrowWidth = (int)param1Float1;
      this.mArrowHeight = (int)param1Float2;
    }
    
    public void setArrowScale(float param1Float) {
      if (param1Float != this.mArrowScale) {
        this.mArrowScale = param1Float;
        invalidateSelf();
      } 
    }
    
    public void setBackgroundColor(int param1Int) {
      this.mBackgroundColor = param1Int;
    }
    
    public void setCenterRadius(double param1Double) {
      this.mRingCenterRadius = param1Double;
    }
    
    public void setColor(int param1Int) {
      this.mCurrentColor = param1Int;
    }
    
    public void setColorFilter(ColorFilter param1ColorFilter) {
      this.mPaint.setColorFilter(param1ColorFilter);
      invalidateSelf();
    }
    
    public void setColorIndex(int param1Int) {
      this.mColorIndex = param1Int;
      this.mCurrentColor = this.mColors[this.mColorIndex];
    }
    
    public void setColors(@NonNull int[] param1ArrayOfint) {
      this.mColors = param1ArrayOfint;
      setColorIndex(0);
    }
    
    public void setEndTrim(float param1Float) {
      this.mEndTrim = param1Float;
      invalidateSelf();
    }
    
    public void setInsets(int param1Int1, int param1Int2) {
      float f = Math.min(param1Int1, param1Int2);
      if (this.mRingCenterRadius <= 0.0D || f < 0.0F) {
        f = (float)Math.ceil((this.mStrokeWidth / 2.0F));
      } else {
        f = (float)((f / 2.0F) - this.mRingCenterRadius);
      } 
      this.mStrokeInset = f;
    }
    
    public void setRotation(float param1Float) {
      this.mRotation = param1Float;
      invalidateSelf();
    }
    
    public void setShowArrow(boolean param1Boolean) {
      if (this.mShowArrow != param1Boolean) {
        this.mShowArrow = param1Boolean;
        invalidateSelf();
      } 
    }
    
    public void setStartTrim(float param1Float) {
      this.mStartTrim = param1Float;
      invalidateSelf();
    }
    
    public void setStrokeWidth(float param1Float) {
      this.mStrokeWidth = param1Float;
      this.mPaint.setStrokeWidth(param1Float);
      invalidateSelf();
    }
    
    public void storeOriginals() {
      this.mStartingStartTrim = this.mStartTrim;
      this.mStartingEndTrim = this.mEndTrim;
      this.mStartingRotation = this.mRotation;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\MaterialProgressDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */