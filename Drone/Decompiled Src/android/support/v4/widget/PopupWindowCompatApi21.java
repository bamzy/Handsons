package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

@TargetApi(21)
@RequiresApi(21)
class PopupWindowCompatApi21 {
  private static final String TAG = "PopupWindowCompatApi21";
  
  private static Field sOverlapAnchorField;
  
  static {
    try {
      sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
      sOverlapAnchorField.setAccessible(true);
      return;
    } catch (NoSuchFieldException noSuchFieldException) {
      Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", noSuchFieldException);
      return;
    } 
  }
  
  static boolean getOverlapAnchor(PopupWindow paramPopupWindow) {
    if (sOverlapAnchorField != null)
      try {
        return ((Boolean)sOverlapAnchorField.get(paramPopupWindow)).booleanValue();
      } catch (IllegalAccessException illegalAccessException) {
        Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", illegalAccessException);
      }  
    return false;
  }
  
  static void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean) {
    if (sOverlapAnchorField != null)
      try {
        sOverlapAnchorField.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
        return;
      } catch (IllegalAccessException illegalAccessException) {
        Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", illegalAccessException);
        return;
      }  
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\PopupWindowCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */