package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build;

public final class BitmapCompat {
  static final BitmapImpl IMPL = new BaseBitmapImpl();
  
  public static int getAllocationByteCount(Bitmap paramBitmap) {
    return IMPL.getAllocationByteCount(paramBitmap);
  }
  
  public static boolean hasMipMap(Bitmap paramBitmap) {
    return IMPL.hasMipMap(paramBitmap);
  }
  
  public static void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean) {
    IMPL.setHasMipMap(paramBitmap, paramBoolean);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19) {
      IMPL = new KitKatBitmapCompatImpl();
      return;
    } 
    if (i >= 18) {
      IMPL = new JbMr2BitmapCompatImpl();
      return;
    } 
    if (i >= 12) {
      IMPL = new HcMr1BitmapCompatImpl();
      return;
    } 
  }
  
  static class BaseBitmapImpl implements BitmapImpl {
    public int getAllocationByteCount(Bitmap param1Bitmap) {
      return param1Bitmap.getRowBytes() * param1Bitmap.getHeight();
    }
    
    public boolean hasMipMap(Bitmap param1Bitmap) {
      return false;
    }
    
    public void setHasMipMap(Bitmap param1Bitmap, boolean param1Boolean) {}
  }
  
  static interface BitmapImpl {
    int getAllocationByteCount(Bitmap param1Bitmap);
    
    boolean hasMipMap(Bitmap param1Bitmap);
    
    void setHasMipMap(Bitmap param1Bitmap, boolean param1Boolean);
  }
  
  static class HcMr1BitmapCompatImpl extends BaseBitmapImpl {
    public int getAllocationByteCount(Bitmap param1Bitmap) {
      return BitmapCompatHoneycombMr1.getAllocationByteCount(param1Bitmap);
    }
  }
  
  static class JbMr2BitmapCompatImpl extends HcMr1BitmapCompatImpl {
    public boolean hasMipMap(Bitmap param1Bitmap) {
      return BitmapCompatJellybeanMR2.hasMipMap(param1Bitmap);
    }
    
    public void setHasMipMap(Bitmap param1Bitmap, boolean param1Boolean) {
      BitmapCompatJellybeanMR2.setHasMipMap(param1Bitmap, param1Boolean);
    }
  }
  
  static class KitKatBitmapCompatImpl extends JbMr2BitmapCompatImpl {
    public int getAllocationByteCount(Bitmap param1Bitmap) {
      return BitmapCompatKitKat.getAllocationByteCount(param1Bitmap);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\graphics\BitmapCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */