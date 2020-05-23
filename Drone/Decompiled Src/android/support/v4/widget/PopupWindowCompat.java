package android.support.v4.widget;

import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class PopupWindowCompat {
  static final PopupWindowImpl IMPL = new BasePopupWindowImpl();
  
  public static boolean getOverlapAnchor(PopupWindow paramPopupWindow) {
    return IMPL.getOverlapAnchor(paramPopupWindow);
  }
  
  public static int getWindowLayoutType(PopupWindow paramPopupWindow) {
    return IMPL.getWindowLayoutType(paramPopupWindow);
  }
  
  public static void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean) {
    IMPL.setOverlapAnchor(paramPopupWindow, paramBoolean);
  }
  
  public static void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt) {
    IMPL.setWindowLayoutType(paramPopupWindow, paramInt);
  }
  
  public static void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3) {
    IMPL.showAsDropDown(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      IMPL = new Api23PopupWindowImpl();
      return;
    } 
    if (i >= 21) {
      IMPL = new Api21PopupWindowImpl();
      return;
    } 
    if (i >= 19) {
      IMPL = new KitKatPopupWindowImpl();
      return;
    } 
  }
  
  static class Api21PopupWindowImpl extends KitKatPopupWindowImpl {
    public boolean getOverlapAnchor(PopupWindow param1PopupWindow) {
      return PopupWindowCompatApi21.getOverlapAnchor(param1PopupWindow);
    }
    
    public void setOverlapAnchor(PopupWindow param1PopupWindow, boolean param1Boolean) {
      PopupWindowCompatApi21.setOverlapAnchor(param1PopupWindow, param1Boolean);
    }
  }
  
  static class Api23PopupWindowImpl extends Api21PopupWindowImpl {
    public boolean getOverlapAnchor(PopupWindow param1PopupWindow) {
      return PopupWindowCompatApi23.getOverlapAnchor(param1PopupWindow);
    }
    
    public int getWindowLayoutType(PopupWindow param1PopupWindow) {
      return PopupWindowCompatApi23.getWindowLayoutType(param1PopupWindow);
    }
    
    public void setOverlapAnchor(PopupWindow param1PopupWindow, boolean param1Boolean) {
      PopupWindowCompatApi23.setOverlapAnchor(param1PopupWindow, param1Boolean);
    }
    
    public void setWindowLayoutType(PopupWindow param1PopupWindow, int param1Int) {
      PopupWindowCompatApi23.setWindowLayoutType(param1PopupWindow, param1Int);
    }
  }
  
  static class BasePopupWindowImpl implements PopupWindowImpl {
    private static Method sGetWindowLayoutTypeMethod;
    
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    
    private static Method sSetWindowLayoutTypeMethod;
    
    private static boolean sSetWindowLayoutTypeMethodAttempted;
    
    public boolean getOverlapAnchor(PopupWindow param1PopupWindow) {
      return false;
    }
    
    public int getWindowLayoutType(PopupWindow param1PopupWindow) {
      if (!sGetWindowLayoutTypeMethodAttempted) {
        try {
          sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
          sGetWindowLayoutTypeMethod.setAccessible(true);
        } catch (Exception exception) {}
        sGetWindowLayoutTypeMethodAttempted = true;
      } 
      if (sGetWindowLayoutTypeMethod != null)
        try {
          return ((Integer)sGetWindowLayoutTypeMethod.invoke(param1PopupWindow, new Object[0])).intValue();
        } catch (Exception exception) {} 
      return 0;
    }
    
    public void setOverlapAnchor(PopupWindow param1PopupWindow, boolean param1Boolean) {}
    
    public void setWindowLayoutType(PopupWindow param1PopupWindow, int param1Int) {
      if (!sSetWindowLayoutTypeMethodAttempted) {
        try {
          sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { int.class });
          sSetWindowLayoutTypeMethod.setAccessible(true);
        } catch (Exception exception) {}
        sSetWindowLayoutTypeMethodAttempted = true;
      } 
      if (sSetWindowLayoutTypeMethod != null)
        try {
          sSetWindowLayoutTypeMethod.invoke(param1PopupWindow, new Object[] { Integer.valueOf(param1Int) });
          return;
        } catch (Exception exception) {
          return;
        }  
    }
    
    public void showAsDropDown(PopupWindow param1PopupWindow, View param1View, int param1Int1, int param1Int2, int param1Int3) {
      int i = param1Int1;
      if ((GravityCompat.getAbsoluteGravity(param1Int3, ViewCompat.getLayoutDirection(param1View)) & 0x7) == 5)
        i = param1Int1 - param1PopupWindow.getWidth() - param1View.getWidth(); 
      param1PopupWindow.showAsDropDown(param1View, i, param1Int2);
    }
  }
  
  static class KitKatPopupWindowImpl extends BasePopupWindowImpl {
    public void showAsDropDown(PopupWindow param1PopupWindow, View param1View, int param1Int1, int param1Int2, int param1Int3) {
      PopupWindowCompatKitKat.showAsDropDown(param1PopupWindow, param1View, param1Int1, param1Int2, param1Int3);
    }
  }
  
  static interface PopupWindowImpl {
    boolean getOverlapAnchor(PopupWindow param1PopupWindow);
    
    int getWindowLayoutType(PopupWindow param1PopupWindow);
    
    void setOverlapAnchor(PopupWindow param1PopupWindow, boolean param1Boolean);
    
    void setWindowLayoutType(PopupWindow param1PopupWindow, int param1Int);
    
    void showAsDropDown(PopupWindow param1PopupWindow, View param1View, int param1Int1, int param1Int2, int param1Int3);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\PopupWindowCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */