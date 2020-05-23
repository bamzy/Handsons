package android.support.v4.widget;

import android.os.Build;
import android.view.View;

public final class ListPopupWindowCompat {
  static final ListPopupWindowImpl IMPL = new BaseListPopupWindowImpl();
  
  public static View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView) {
    return IMPL.createDragToOpenListener(paramObject, paramView);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 19) {
      IMPL = new KitKatListPopupWindowImpl();
      return;
    } 
  }
  
  static class BaseListPopupWindowImpl implements ListPopupWindowImpl {
    public View.OnTouchListener createDragToOpenListener(Object param1Object, View param1View) {
      return null;
    }
  }
  
  static class KitKatListPopupWindowImpl extends BaseListPopupWindowImpl {
    public View.OnTouchListener createDragToOpenListener(Object param1Object, View param1View) {
      return ListPopupWindowCompatKitKat.createDragToOpenListener(param1Object, param1View);
    }
  }
  
  static interface ListPopupWindowImpl {
    View.OnTouchListener createDragToOpenListener(Object param1Object, View param1View);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\ListPopupWindowCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */