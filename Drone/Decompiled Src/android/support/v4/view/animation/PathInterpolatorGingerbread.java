package android.support.v4.view.animation;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.RequiresApi;
import android.view.animation.Interpolator;

@TargetApi(9)
@RequiresApi(9)
class PathInterpolatorGingerbread implements Interpolator {
  private static final float PRECISION = 0.002F;
  
  private final float[] mX;
  
  private final float[] mY;
  
  public PathInterpolatorGingerbread(float paramFloat1, float paramFloat2) {
    this(createQuad(paramFloat1, paramFloat2));
  }
  
  public PathInterpolatorGingerbread(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    this(createCubic(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public PathInterpolatorGingerbread(Path paramPath) {
    PathMeasure pathMeasure = new PathMeasure(paramPath, false);
    float f = pathMeasure.getLength();
    int j = (int)(f / 0.002F) + 1;
    this.mX = new float[j];
    this.mY = new float[j];
    float[] arrayOfFloat = new float[2];
    for (int i = 0; i < j; i++) {
      pathMeasure.getPosTan(i * f / (j - 1), arrayOfFloat, null);
      this.mX[i] = arrayOfFloat[0];
      this.mY[i] = arrayOfFloat[1];
    } 
  }
  
  private static Path createCubic(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    Path path = new Path();
    path.moveTo(0.0F, 0.0F);
    path.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F);
    return path;
  }
  
  private static Path createQuad(float paramFloat1, float paramFloat2) {
    Path path = new Path();
    path.moveTo(0.0F, 0.0F);
    path.quadTo(paramFloat1, paramFloat2, 1.0F, 1.0F);
    return path;
  }
  
  public float getInterpolation(float paramFloat) {
    if (paramFloat <= 0.0F)
      return 0.0F; 
    if (paramFloat >= 1.0F)
      return 1.0F; 
    int i = 0;
    int j = this.mX.length - 1;
    while (j - i > 1) {
      int k = (i + j) / 2;
      if (paramFloat < this.mX[k]) {
        j = k;
        continue;
      } 
      i = k;
    } 
    float f = this.mX[j] - this.mX[i];
    if (f == 0.0F)
      return this.mY[i]; 
    paramFloat = (paramFloat - this.mX[i]) / f;
    f = this.mY[i];
    return (this.mY[j] - f) * paramFloat + f;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\animation\PathInterpolatorGingerbread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */