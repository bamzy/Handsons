package android.support.v7.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import java.util.List;

@TargetApi(24)
@RequiresApi(24)
class AppCompatDelegateImplN extends AppCompatDelegateImplV23 {
  AppCompatDelegateImplN(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback) {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  Window.Callback wrapWindowCallback(Window.Callback paramCallback) {
    return (Window.Callback)new AppCompatWindowCallbackN(paramCallback);
  }
  
  class AppCompatWindowCallbackN extends AppCompatDelegateImplV23.AppCompatWindowCallbackV23 {
    AppCompatWindowCallbackN(Window.Callback param1Callback) {
      super(param1Callback);
    }
    
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> param1List, Menu param1Menu, int param1Int) {
      AppCompatDelegateImplV9.PanelFeatureState panelFeatureState = AppCompatDelegateImplN.this.getPanelState(0, true);
      if (panelFeatureState != null && panelFeatureState.menu != null) {
        super.onProvideKeyboardShortcuts(param1List, (Menu)panelFeatureState.menu, param1Int);
        return;
      } 
      super.onProvideKeyboardShortcuts(param1List, param1Menu, param1Int);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\app\AppCompatDelegateImplN.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */