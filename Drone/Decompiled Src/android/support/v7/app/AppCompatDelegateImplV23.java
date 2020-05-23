package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.UiModeManager;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.ActionMode;
import android.view.Window;

@TargetApi(23)
@RequiresApi(23)
class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14 {
  private final UiModeManager mUiModeManager;
  
  AppCompatDelegateImplV23(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback) {
    super(paramContext, paramWindow, paramAppCompatCallback);
    this.mUiModeManager = (UiModeManager)paramContext.getSystemService("uimode");
  }
  
  int mapNightMode(int paramInt) {
    return (paramInt == 0 && this.mUiModeManager.getNightMode() == 0) ? -1 : super.mapNightMode(paramInt);
  }
  
  Window.Callback wrapWindowCallback(Window.Callback paramCallback) {
    return (Window.Callback)new AppCompatWindowCallbackV23(paramCallback);
  }
  
  class AppCompatWindowCallbackV23 extends AppCompatDelegateImplV14.AppCompatWindowCallbackV14 {
    AppCompatWindowCallbackV23(Window.Callback param1Callback) {
      super(param1Callback);
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback param1Callback) {
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback param1Callback, int param1Int) {
      if (AppCompatDelegateImplV23.this.isHandleNativeActionModesEnabled()) {
        switch (param1Int) {
          default:
            return super.onWindowStartingActionMode(param1Callback, param1Int);
          case 0:
            break;
        } 
        return startAsSupportActionMode(param1Callback);
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\app\AppCompatDelegateImplV23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */