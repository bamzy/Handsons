package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build;

public class WindowInsetsCompat {
  private static final WindowInsetsCompatImpl IMPL = new WindowInsetsCompatBaseImpl();
  
  private final Object mInsets;
  
  public WindowInsetsCompat(WindowInsetsCompat paramWindowInsetsCompat) {
    Object object;
    if (paramWindowInsetsCompat == null) {
      paramWindowInsetsCompat = null;
    } else {
      object = IMPL.getSourceWindowInsets(paramWindowInsetsCompat.mInsets);
    } 
    this.mInsets = object;
  }
  
  WindowInsetsCompat(Object paramObject) {
    this.mInsets = paramObject;
  }
  
  static Object unwrap(WindowInsetsCompat paramWindowInsetsCompat) {
    return (paramWindowInsetsCompat == null) ? null : paramWindowInsetsCompat.mInsets;
  }
  
  static WindowInsetsCompat wrap(Object paramObject) {
    return (paramObject == null) ? null : new WindowInsetsCompat(paramObject);
  }
  
  public WindowInsetsCompat consumeStableInsets() {
    return IMPL.consumeStableInsets(this.mInsets);
  }
  
  public WindowInsetsCompat consumeSystemWindowInsets() {
    return IMPL.consumeSystemWindowInsets(this.mInsets);
  }
  
  public boolean equals(Object paramObject) {
    if (this != paramObject) {
      if (paramObject == null || getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (this.mInsets == null) ? (!(((WindowInsetsCompat)paramObject).mInsets != null)) : this.mInsets.equals(((WindowInsetsCompat)paramObject).mInsets);
    } 
    return true;
  }
  
  public int getStableInsetBottom() {
    return IMPL.getStableInsetBottom(this.mInsets);
  }
  
  public int getStableInsetLeft() {
    return IMPL.getStableInsetLeft(this.mInsets);
  }
  
  public int getStableInsetRight() {
    return IMPL.getStableInsetRight(this.mInsets);
  }
  
  public int getStableInsetTop() {
    return IMPL.getStableInsetTop(this.mInsets);
  }
  
  public int getSystemWindowInsetBottom() {
    return IMPL.getSystemWindowInsetBottom(this.mInsets);
  }
  
  public int getSystemWindowInsetLeft() {
    return IMPL.getSystemWindowInsetLeft(this.mInsets);
  }
  
  public int getSystemWindowInsetRight() {
    return IMPL.getSystemWindowInsetRight(this.mInsets);
  }
  
  public int getSystemWindowInsetTop() {
    return IMPL.getSystemWindowInsetTop(this.mInsets);
  }
  
  public boolean hasInsets() {
    return IMPL.hasInsets(this.mInsets);
  }
  
  public boolean hasStableInsets() {
    return IMPL.hasStableInsets(this.mInsets);
  }
  
  public boolean hasSystemWindowInsets() {
    return IMPL.hasSystemWindowInsets(this.mInsets);
  }
  
  public int hashCode() {
    return (this.mInsets == null) ? 0 : this.mInsets.hashCode();
  }
  
  public boolean isConsumed() {
    return IMPL.isConsumed(this.mInsets);
  }
  
  public boolean isRound() {
    return IMPL.isRound(this.mInsets);
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return IMPL.replaceSystemWindowInsets(this.mInsets, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(Rect paramRect) {
    return IMPL.replaceSystemWindowInsets(this.mInsets, paramRect);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      IMPL = new WindowInsetsCompatApi21Impl();
      return;
    } 
    if (i >= 20) {
      IMPL = new WindowInsetsCompatApi20Impl();
      return;
    } 
  }
  
  private static class WindowInsetsCompatApi20Impl extends WindowInsetsCompatBaseImpl {
    public WindowInsetsCompat consumeSystemWindowInsets(Object param1Object) {
      return new WindowInsetsCompat(WindowInsetsCompatApi20.consumeSystemWindowInsets(param1Object));
    }
    
    public Object getSourceWindowInsets(Object param1Object) {
      return WindowInsetsCompatApi20.getSourceWindowInsets(param1Object);
    }
    
    public int getSystemWindowInsetBottom(Object param1Object) {
      return WindowInsetsCompatApi20.getSystemWindowInsetBottom(param1Object);
    }
    
    public int getSystemWindowInsetLeft(Object param1Object) {
      return WindowInsetsCompatApi20.getSystemWindowInsetLeft(param1Object);
    }
    
    public int getSystemWindowInsetRight(Object param1Object) {
      return WindowInsetsCompatApi20.getSystemWindowInsetRight(param1Object);
    }
    
    public int getSystemWindowInsetTop(Object param1Object) {
      return WindowInsetsCompatApi20.getSystemWindowInsetTop(param1Object);
    }
    
    public boolean hasInsets(Object param1Object) {
      return WindowInsetsCompatApi20.hasInsets(param1Object);
    }
    
    public boolean hasSystemWindowInsets(Object param1Object) {
      return WindowInsetsCompatApi20.hasSystemWindowInsets(param1Object);
    }
    
    public boolean isRound(Object param1Object) {
      return WindowInsetsCompatApi20.isRound(param1Object);
    }
    
    public WindowInsetsCompat replaceSystemWindowInsets(Object param1Object, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return new WindowInsetsCompat(WindowInsetsCompatApi20.replaceSystemWindowInsets(param1Object, param1Int1, param1Int2, param1Int3, param1Int4));
    }
  }
  
  private static class WindowInsetsCompatApi21Impl extends WindowInsetsCompatApi20Impl {
    public WindowInsetsCompat consumeStableInsets(Object param1Object) {
      return new WindowInsetsCompat(WindowInsetsCompatApi21.consumeStableInsets(param1Object));
    }
    
    public int getStableInsetBottom(Object param1Object) {
      return WindowInsetsCompatApi21.getStableInsetBottom(param1Object);
    }
    
    public int getStableInsetLeft(Object param1Object) {
      return WindowInsetsCompatApi21.getStableInsetLeft(param1Object);
    }
    
    public int getStableInsetRight(Object param1Object) {
      return WindowInsetsCompatApi21.getStableInsetRight(param1Object);
    }
    
    public int getStableInsetTop(Object param1Object) {
      return WindowInsetsCompatApi21.getStableInsetTop(param1Object);
    }
    
    public boolean hasStableInsets(Object param1Object) {
      return WindowInsetsCompatApi21.hasStableInsets(param1Object);
    }
    
    public boolean isConsumed(Object param1Object) {
      return WindowInsetsCompatApi21.isConsumed(param1Object);
    }
    
    public WindowInsetsCompat replaceSystemWindowInsets(Object param1Object, Rect param1Rect) {
      return new WindowInsetsCompat(WindowInsetsCompatApi21.replaceSystemWindowInsets(param1Object, param1Rect));
    }
  }
  
  private static class WindowInsetsCompatBaseImpl implements WindowInsetsCompatImpl {
    public WindowInsetsCompat consumeStableInsets(Object param1Object) {
      return null;
    }
    
    public WindowInsetsCompat consumeSystemWindowInsets(Object param1Object) {
      return null;
    }
    
    public Object getSourceWindowInsets(Object param1Object) {
      return null;
    }
    
    public int getStableInsetBottom(Object param1Object) {
      return 0;
    }
    
    public int getStableInsetLeft(Object param1Object) {
      return 0;
    }
    
    public int getStableInsetRight(Object param1Object) {
      return 0;
    }
    
    public int getStableInsetTop(Object param1Object) {
      return 0;
    }
    
    public int getSystemWindowInsetBottom(Object param1Object) {
      return 0;
    }
    
    public int getSystemWindowInsetLeft(Object param1Object) {
      return 0;
    }
    
    public int getSystemWindowInsetRight(Object param1Object) {
      return 0;
    }
    
    public int getSystemWindowInsetTop(Object param1Object) {
      return 0;
    }
    
    public boolean hasInsets(Object param1Object) {
      return false;
    }
    
    public boolean hasStableInsets(Object param1Object) {
      return false;
    }
    
    public boolean hasSystemWindowInsets(Object param1Object) {
      return false;
    }
    
    public boolean isConsumed(Object param1Object) {
      return false;
    }
    
    public boolean isRound(Object param1Object) {
      return false;
    }
    
    public WindowInsetsCompat replaceSystemWindowInsets(Object param1Object, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return null;
    }
    
    public WindowInsetsCompat replaceSystemWindowInsets(Object param1Object, Rect param1Rect) {
      return null;
    }
  }
  
  private static interface WindowInsetsCompatImpl {
    WindowInsetsCompat consumeStableInsets(Object param1Object);
    
    WindowInsetsCompat consumeSystemWindowInsets(Object param1Object);
    
    Object getSourceWindowInsets(Object param1Object);
    
    int getStableInsetBottom(Object param1Object);
    
    int getStableInsetLeft(Object param1Object);
    
    int getStableInsetRight(Object param1Object);
    
    int getStableInsetTop(Object param1Object);
    
    int getSystemWindowInsetBottom(Object param1Object);
    
    int getSystemWindowInsetLeft(Object param1Object);
    
    int getSystemWindowInsetRight(Object param1Object);
    
    int getSystemWindowInsetTop(Object param1Object);
    
    boolean hasInsets(Object param1Object);
    
    boolean hasStableInsets(Object param1Object);
    
    boolean hasSystemWindowInsets(Object param1Object);
    
    boolean isConsumed(Object param1Object);
    
    boolean isRound(Object param1Object);
    
    WindowInsetsCompat replaceSystemWindowInsets(Object param1Object, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
    
    WindowInsetsCompat replaceSystemWindowInsets(Object param1Object, Rect param1Rect);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\WindowInsetsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */