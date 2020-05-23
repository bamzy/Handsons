package android.support.v4.view;

import android.os.Build;
import android.view.KeyEvent;
import android.view.View;

public final class KeyEventCompat {
  static final KeyEventVersionImpl IMPL = new BaseKeyEventVersionImpl();
  
  @Deprecated
  public static boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2) {
    return paramKeyEvent.dispatch(paramCallback, (KeyEvent.DispatcherState)paramObject1, paramObject2);
  }
  
  @Deprecated
  public static Object getKeyDispatcherState(View paramView) {
    return paramView.getKeyDispatcherState();
  }
  
  public static boolean hasModifiers(KeyEvent paramKeyEvent, int paramInt) {
    return IMPL.metaStateHasModifiers(paramKeyEvent.getMetaState(), paramInt);
  }
  
  public static boolean hasNoModifiers(KeyEvent paramKeyEvent) {
    return IMPL.metaStateHasNoModifiers(paramKeyEvent.getMetaState());
  }
  
  public static boolean isCtrlPressed(KeyEvent paramKeyEvent) {
    return IMPL.isCtrlPressed(paramKeyEvent);
  }
  
  @Deprecated
  public static boolean isTracking(KeyEvent paramKeyEvent) {
    return paramKeyEvent.isTracking();
  }
  
  public static boolean metaStateHasModifiers(int paramInt1, int paramInt2) {
    return IMPL.metaStateHasModifiers(paramInt1, paramInt2);
  }
  
  public static boolean metaStateHasNoModifiers(int paramInt) {
    return IMPL.metaStateHasNoModifiers(paramInt);
  }
  
  public static int normalizeMetaState(int paramInt) {
    return IMPL.normalizeMetaState(paramInt);
  }
  
  @Deprecated
  public static void startTracking(KeyEvent paramKeyEvent) {
    paramKeyEvent.startTracking();
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 11) {
      IMPL = new HoneycombKeyEventVersionImpl();
      return;
    } 
  }
  
  static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
    private static final int META_ALL_MASK = 247;
    
    private static final int META_MODIFIER_MASK = 247;
    
    private static int metaStateFilterDirectionalModifiers(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
      boolean bool1;
      boolean bool2 = true;
      if ((param1Int2 & param1Int3) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      param1Int4 |= param1Int5;
      if ((param1Int2 & param1Int4) != 0) {
        param1Int2 = bool2;
      } else {
        param1Int2 = 0;
      } 
      if (bool1) {
        if (param1Int2 != 0)
          throw new IllegalArgumentException("bad arguments"); 
        return param1Int1 & (param1Int4 ^ 0xFFFFFFFF);
      } 
      param1Int4 = param1Int1;
      return (param1Int2 != 0) ? (param1Int1 & (param1Int3 ^ 0xFFFFFFFF)) : param1Int4;
    }
    
    public boolean isCtrlPressed(KeyEvent param1KeyEvent) {
      return false;
    }
    
    public boolean metaStateHasModifiers(int param1Int1, int param1Int2) {
      return (metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(param1Int1) & 0xF7, param1Int2, 1, 64, 128), param1Int2, 2, 16, 32) == param1Int2);
    }
    
    public boolean metaStateHasNoModifiers(int param1Int) {
      return ((normalizeMetaState(param1Int) & 0xF7) == 0);
    }
    
    public int normalizeMetaState(int param1Int) {
      int i = param1Int;
      if ((param1Int & 0xC0) != 0)
        i = param1Int | 0x1; 
      param1Int = i;
      if ((i & 0x30) != 0)
        param1Int = i | 0x2; 
      return param1Int & 0xF7;
    }
  }
  
  static class HoneycombKeyEventVersionImpl extends BaseKeyEventVersionImpl {
    public boolean isCtrlPressed(KeyEvent param1KeyEvent) {
      return KeyEventCompatHoneycomb.isCtrlPressed(param1KeyEvent);
    }
    
    public boolean metaStateHasModifiers(int param1Int1, int param1Int2) {
      return KeyEventCompatHoneycomb.metaStateHasModifiers(param1Int1, param1Int2);
    }
    
    public boolean metaStateHasNoModifiers(int param1Int) {
      return KeyEventCompatHoneycomb.metaStateHasNoModifiers(param1Int);
    }
    
    public int normalizeMetaState(int param1Int) {
      return KeyEventCompatHoneycomb.normalizeMetaState(param1Int);
    }
  }
  
  static interface KeyEventVersionImpl {
    boolean isCtrlPressed(KeyEvent param1KeyEvent);
    
    boolean metaStateHasModifiers(int param1Int1, int param1Int2);
    
    boolean metaStateHasNoModifiers(int param1Int);
    
    int normalizeMetaState(int param1Int);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\KeyEventCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */