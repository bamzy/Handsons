package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class AppCompatProgressBarHelper {
  private static final int[] TINT_ATTRS = new int[] { 16843067, 16843068 };
  
  private Bitmap mSampleTile;
  
  private final ProgressBar mView;
  
  AppCompatProgressBarHelper(ProgressBar paramProgressBar) {
    this.mView = paramProgressBar;
  }
  
  private Shape getDrawableShape() {
    return (Shape)new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null);
  }
  
  private Drawable tileify(Drawable paramDrawable, boolean paramBoolean) {
    LayerDrawable layerDrawable;
    ClipDrawable clipDrawable;
    if (paramDrawable instanceof DrawableWrapper) {
      Drawable drawable = ((DrawableWrapper)paramDrawable).getWrappedDrawable();
      if (drawable != null) {
        drawable = tileify(drawable, paramBoolean);
        ((DrawableWrapper)paramDrawable).setWrappedDrawable(drawable);
      } 
      return paramDrawable;
    } 
    if (paramDrawable instanceof LayerDrawable) {
      LayerDrawable layerDrawable2 = (LayerDrawable)paramDrawable;
      int j = layerDrawable2.getNumberOfLayers();
      Drawable[] arrayOfDrawable = new Drawable[j];
      int i;
      for (i = 0; i < j; i++) {
        int k = layerDrawable2.getId(i);
        Drawable drawable = layerDrawable2.getDrawable(i);
        if (k == 16908301 || k == 16908303) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        } 
        arrayOfDrawable[i] = tileify(drawable, paramBoolean);
      } 
      LayerDrawable layerDrawable1 = new LayerDrawable(arrayOfDrawable);
      i = 0;
      while (true) {
        layerDrawable = layerDrawable1;
        if (i < j) {
          layerDrawable1.setId(i, layerDrawable2.getId(i));
          i++;
          continue;
        } 
        return (Drawable)layerDrawable;
      } 
    } 
    if (layerDrawable instanceof BitmapDrawable) {
      BitmapDrawable bitmapDrawable = (BitmapDrawable)layerDrawable;
      Bitmap bitmap = bitmapDrawable.getBitmap();
      if (this.mSampleTile == null)
        this.mSampleTile = bitmap; 
      ShapeDrawable shapeDrawable2 = new ShapeDrawable(getDrawableShape());
      BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
      shapeDrawable2.getPaint().setShader((Shader)bitmapShader);
      shapeDrawable2.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
      ShapeDrawable shapeDrawable1 = shapeDrawable2;
      if (paramBoolean)
        clipDrawable = new ClipDrawable((Drawable)shapeDrawable2, 3, 1); 
      return (Drawable)clipDrawable;
    } 
    return (Drawable)clipDrawable;
  }
  
  private Drawable tileifyIndeterminate(Drawable paramDrawable) {
    AnimationDrawable animationDrawable;
    Drawable drawable = paramDrawable;
    if (paramDrawable instanceof AnimationDrawable) {
      AnimationDrawable animationDrawable1 = (AnimationDrawable)paramDrawable;
      int j = animationDrawable1.getNumberOfFrames();
      animationDrawable = new AnimationDrawable();
      animationDrawable.setOneShot(animationDrawable1.isOneShot());
      for (int i = 0; i < j; i++) {
        Drawable drawable1 = tileify(animationDrawable1.getFrame(i), true);
        drawable1.setLevel(10000);
        animationDrawable.addFrame(drawable1, animationDrawable1.getDuration(i));
      } 
      animationDrawable.setLevel(10000);
    } 
    return (Drawable)animationDrawable;
  }
  
  Bitmap getSampleTime() {
    return this.mSampleTile;
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), paramAttributeSet, TINT_ATTRS, paramInt, 0);
    Drawable drawable = tintTypedArray.getDrawableIfKnown(0);
    if (drawable != null)
      this.mView.setIndeterminateDrawable(tileifyIndeterminate(drawable)); 
    drawable = tintTypedArray.getDrawableIfKnown(1);
    if (drawable != null)
      this.mView.setProgressDrawable(tileify(drawable, false)); 
    tintTypedArray.recycle();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\AppCompatProgressBarHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */