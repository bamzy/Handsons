package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;

public final class EdgeEffectCompat {
  private static final EdgeEffectImpl IMPL = new BaseEdgeEffectImpl();
  
  private Object mEdgeEffect;
  
  public EdgeEffectCompat(Context paramContext) {
    this.mEdgeEffect = IMPL.newEdgeEffect(paramContext);
  }
  
  public boolean draw(Canvas paramCanvas) {
    return IMPL.draw(this.mEdgeEffect, paramCanvas);
  }
  
  public void finish() {
    IMPL.finish(this.mEdgeEffect);
  }
  
  public boolean isFinished() {
    return IMPL.isFinished(this.mEdgeEffect);
  }
  
  public boolean onAbsorb(int paramInt) {
    return IMPL.onAbsorb(this.mEdgeEffect, paramInt);
  }
  
  @Deprecated
  public boolean onPull(float paramFloat) {
    return IMPL.onPull(this.mEdgeEffect, paramFloat);
  }
  
  public boolean onPull(float paramFloat1, float paramFloat2) {
    return IMPL.onPull(this.mEdgeEffect, paramFloat1, paramFloat2);
  }
  
  public boolean onRelease() {
    return IMPL.onRelease(this.mEdgeEffect);
  }
  
  public void setSize(int paramInt1, int paramInt2) {
    IMPL.setSize(this.mEdgeEffect, paramInt1, paramInt2);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new EdgeEffectLollipopImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new EdgeEffectIcsImpl();
      return;
    } 
  }
  
  static class BaseEdgeEffectImpl implements EdgeEffectImpl {
    public boolean draw(Object param1Object, Canvas param1Canvas) {
      return false;
    }
    
    public void finish(Object param1Object) {}
    
    public boolean isFinished(Object param1Object) {
      return true;
    }
    
    public Object newEdgeEffect(Context param1Context) {
      return null;
    }
    
    public boolean onAbsorb(Object param1Object, int param1Int) {
      return false;
    }
    
    public boolean onPull(Object param1Object, float param1Float) {
      return false;
    }
    
    public boolean onPull(Object param1Object, float param1Float1, float param1Float2) {
      return false;
    }
    
    public boolean onRelease(Object param1Object) {
      return false;
    }
    
    public void setSize(Object param1Object, int param1Int1, int param1Int2) {}
  }
  
  static class EdgeEffectIcsImpl implements EdgeEffectImpl {
    public boolean draw(Object param1Object, Canvas param1Canvas) {
      return EdgeEffectCompatIcs.draw(param1Object, param1Canvas);
    }
    
    public void finish(Object param1Object) {
      EdgeEffectCompatIcs.finish(param1Object);
    }
    
    public boolean isFinished(Object param1Object) {
      return EdgeEffectCompatIcs.isFinished(param1Object);
    }
    
    public Object newEdgeEffect(Context param1Context) {
      return EdgeEffectCompatIcs.newEdgeEffect(param1Context);
    }
    
    public boolean onAbsorb(Object param1Object, int param1Int) {
      return EdgeEffectCompatIcs.onAbsorb(param1Object, param1Int);
    }
    
    public boolean onPull(Object param1Object, float param1Float) {
      return EdgeEffectCompatIcs.onPull(param1Object, param1Float);
    }
    
    public boolean onPull(Object param1Object, float param1Float1, float param1Float2) {
      return EdgeEffectCompatIcs.onPull(param1Object, param1Float1);
    }
    
    public boolean onRelease(Object param1Object) {
      return EdgeEffectCompatIcs.onRelease(param1Object);
    }
    
    public void setSize(Object param1Object, int param1Int1, int param1Int2) {
      EdgeEffectCompatIcs.setSize(param1Object, param1Int1, param1Int2);
    }
  }
  
  static interface EdgeEffectImpl {
    boolean draw(Object param1Object, Canvas param1Canvas);
    
    void finish(Object param1Object);
    
    boolean isFinished(Object param1Object);
    
    Object newEdgeEffect(Context param1Context);
    
    boolean onAbsorb(Object param1Object, int param1Int);
    
    boolean onPull(Object param1Object, float param1Float);
    
    boolean onPull(Object param1Object, float param1Float1, float param1Float2);
    
    boolean onRelease(Object param1Object);
    
    void setSize(Object param1Object, int param1Int1, int param1Int2);
  }
  
  static class EdgeEffectLollipopImpl extends EdgeEffectIcsImpl {
    public boolean onPull(Object param1Object, float param1Float1, float param1Float2) {
      return EdgeEffectCompatLollipop.onPull(param1Object, param1Float1, param1Float2);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\EdgeEffectCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */