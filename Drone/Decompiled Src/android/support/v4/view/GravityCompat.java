package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

public final class GravityCompat {
  public static final int END = 8388613;
  
  static final GravityCompatImpl IMPL = new GravityCompatImplBase();
  
  public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
  
  public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
  
  public static final int START = 8388611;
  
  public static void apply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, int paramInt4, int paramInt5, Rect paramRect2, int paramInt6) {
    IMPL.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramInt4, paramInt5, paramRect2, paramInt6);
  }
  
  public static void apply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2, int paramInt4) {
    IMPL.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, paramInt4);
  }
  
  public static void applyDisplay(int paramInt1, Rect paramRect1, Rect paramRect2, int paramInt2) {
    IMPL.applyDisplay(paramInt1, paramRect1, paramRect2, paramInt2);
  }
  
  public static int getAbsoluteGravity(int paramInt1, int paramInt2) {
    return IMPL.getAbsoluteGravity(paramInt1, paramInt2);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 17) {
      IMPL = new GravityCompatImplJellybeanMr1();
      return;
    } 
  }
  
  static interface GravityCompatImpl {
    void apply(int param1Int1, int param1Int2, int param1Int3, Rect param1Rect1, int param1Int4, int param1Int5, Rect param1Rect2, int param1Int6);
    
    void apply(int param1Int1, int param1Int2, int param1Int3, Rect param1Rect1, Rect param1Rect2, int param1Int4);
    
    void applyDisplay(int param1Int1, Rect param1Rect1, Rect param1Rect2, int param1Int2);
    
    int getAbsoluteGravity(int param1Int1, int param1Int2);
  }
  
  static class GravityCompatImplBase implements GravityCompatImpl {
    public void apply(int param1Int1, int param1Int2, int param1Int3, Rect param1Rect1, int param1Int4, int param1Int5, Rect param1Rect2, int param1Int6) {
      Gravity.apply(param1Int1, param1Int2, param1Int3, param1Rect1, param1Int4, param1Int5, param1Rect2);
    }
    
    public void apply(int param1Int1, int param1Int2, int param1Int3, Rect param1Rect1, Rect param1Rect2, int param1Int4) {
      Gravity.apply(param1Int1, param1Int2, param1Int3, param1Rect1, param1Rect2);
    }
    
    public void applyDisplay(int param1Int1, Rect param1Rect1, Rect param1Rect2, int param1Int2) {
      Gravity.applyDisplay(param1Int1, param1Rect1, param1Rect2);
    }
    
    public int getAbsoluteGravity(int param1Int1, int param1Int2) {
      return 0xFF7FFFFF & param1Int1;
    }
  }
  
  static class GravityCompatImplJellybeanMr1 implements GravityCompatImpl {
    public void apply(int param1Int1, int param1Int2, int param1Int3, Rect param1Rect1, int param1Int4, int param1Int5, Rect param1Rect2, int param1Int6) {
      GravityCompatJellybeanMr1.apply(param1Int1, param1Int2, param1Int3, param1Rect1, param1Int4, param1Int5, param1Rect2, param1Int6);
    }
    
    public void apply(int param1Int1, int param1Int2, int param1Int3, Rect param1Rect1, Rect param1Rect2, int param1Int4) {
      GravityCompatJellybeanMr1.apply(param1Int1, param1Int2, param1Int3, param1Rect1, param1Rect2, param1Int4);
    }
    
    public void applyDisplay(int param1Int1, Rect param1Rect1, Rect param1Rect2, int param1Int2) {
      GravityCompatJellybeanMr1.applyDisplay(param1Int1, param1Rect1, param1Rect2, param1Int2);
    }
    
    public int getAbsoluteGravity(int param1Int1, int param1Int2) {
      return GravityCompatJellybeanMr1.getAbsoluteGravity(param1Int1, param1Int2);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\GravityCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */