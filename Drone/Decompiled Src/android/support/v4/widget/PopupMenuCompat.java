package android.support.v4.widget;

import android.os.Build;
import android.view.View;

public final class PopupMenuCompat {
  static final PopupMenuImpl IMPL = new BasePopupMenuImpl();
  
  public static View.OnTouchListener getDragToOpenListener(Object paramObject) {
    return IMPL.getDragToOpenListener(paramObject);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 19) {
      IMPL = new KitKatPopupMenuImpl();
      return;
    } 
  }
  
  static class BasePopupMenuImpl implements PopupMenuImpl {
    public View.OnTouchListener getDragToOpenListener(Object param1Object) {
      return null;
    }
  }
  
  static class KitKatPopupMenuImpl extends BasePopupMenuImpl {
    public View.OnTouchListener getDragToOpenListener(Object param1Object) {
      return PopupMenuCompatKitKat.getDragToOpenListener(param1Object);
    }
  }
  
  static interface PopupMenuImpl {
    View.OnTouchListener getDragToOpenListener(Object param1Object);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\PopupMenuCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */