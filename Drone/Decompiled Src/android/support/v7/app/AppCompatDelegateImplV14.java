package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportActionModeWrapper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.Window;

@TargetApi(14)
@RequiresApi(14)
class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11 {
  private static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
  
  private boolean mApplyDayNightCalled;
  
  private AutoNightModeManager mAutoNightModeManager;
  
  private boolean mHandleNativeActionModes = true;
  
  private int mLocalNightMode = -100;
  
  AppCompatDelegateImplV14(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback) {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  private void ensureAutoNightModeManager() {
    if (this.mAutoNightModeManager == null)
      this.mAutoNightModeManager = new AutoNightModeManager(TwilightManager.getInstance(this.mContext)); 
  }
  
  private int getNightMode() {
    return (this.mLocalNightMode != -100) ? this.mLocalNightMode : getDefaultNightMode();
  }
  
  private boolean shouldRecreateOnNightModeChange() {
    if (this.mApplyDayNightCalled && this.mContext instanceof Activity) {
      PackageManager packageManager = this.mContext.getPackageManager();
      try {
        int i = (packageManager.getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0)).configChanges;
        return ((i & 0x200) == 0);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", (Throwable)nameNotFoundException);
        return true;
      } 
    } 
    return false;
  }
  
  private boolean updateForNightMode(int paramInt) {
    Resources resources = this.mContext.getResources();
    Configuration configuration = resources.getConfiguration();
    int i = configuration.uiMode;
    if (paramInt == 2) {
      paramInt = 32;
    } else {
      paramInt = 16;
    } 
    if ((i & 0x30) != paramInt) {
      if (shouldRecreateOnNightModeChange()) {
        ((Activity)this.mContext).recreate();
        return true;
      } 
      configuration = new Configuration(configuration);
      DisplayMetrics displayMetrics = resources.getDisplayMetrics();
      configuration.uiMode = configuration.uiMode & 0xFFFFFFCF | paramInt;
      resources.updateConfiguration(configuration, displayMetrics);
      ResourcesFlusher.flush(resources);
      return true;
    } 
    return false;
  }
  
  public boolean applyDayNight() {
    boolean bool = false;
    int i = getNightMode();
    int j = mapNightMode(i);
    if (j != -1)
      bool = updateForNightMode(j); 
    if (i == 0) {
      ensureAutoNightModeManager();
      this.mAutoNightModeManager.setup();
    } 
    this.mApplyDayNightCalled = true;
    return bool;
  }
  
  @VisibleForTesting
  final AutoNightModeManager getAutoNightModeManager() {
    ensureAutoNightModeManager();
    return this.mAutoNightModeManager;
  }
  
  public boolean isHandleNativeActionModesEnabled() {
    return this.mHandleNativeActionModes;
  }
  
  int mapNightMode(int paramInt) {
    switch (paramInt) {
      default:
        return paramInt;
      case 0:
        ensureAutoNightModeManager();
        return this.mAutoNightModeManager.getApplyableNightMode();
      case -100:
        break;
    } 
    return -1;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (paramBundle != null && this.mLocalNightMode == -100)
      this.mLocalNightMode = paramBundle.getInt("appcompat:local_night_mode", -100); 
  }
  
  public void onDestroy() {
    super.onDestroy();
    if (this.mAutoNightModeManager != null)
      this.mAutoNightModeManager.cleanup(); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    if (this.mLocalNightMode != -100)
      paramBundle.putInt("appcompat:local_night_mode", this.mLocalNightMode); 
  }
  
  public void onStart() {
    super.onStart();
    applyDayNight();
  }
  
  public void onStop() {
    super.onStop();
    if (this.mAutoNightModeManager != null)
      this.mAutoNightModeManager.cleanup(); 
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean) {
    this.mHandleNativeActionModes = paramBoolean;
  }
  
  public void setLocalNightMode(int paramInt) {
    switch (paramInt) {
      default:
        Log.i("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
        return;
      case -1:
      case 0:
      case 1:
      case 2:
        break;
    } 
    if (this.mLocalNightMode != paramInt) {
      this.mLocalNightMode = paramInt;
      if (this.mApplyDayNightCalled) {
        applyDayNight();
        return;
      } 
    } 
  }
  
  Window.Callback wrapWindowCallback(Window.Callback paramCallback) {
    return (Window.Callback)new AppCompatWindowCallbackV14(paramCallback);
  }
  
  class AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase {
    AppCompatWindowCallbackV14(Window.Callback param1Callback) {
      super(param1Callback);
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback param1Callback) {
      return AppCompatDelegateImplV14.this.isHandleNativeActionModesEnabled() ? startAsSupportActionMode(param1Callback) : super.onWindowStartingActionMode(param1Callback);
    }
    
    final ActionMode startAsSupportActionMode(ActionMode.Callback param1Callback) {
      SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImplV14.this.mContext, param1Callback);
      ActionMode actionMode = AppCompatDelegateImplV14.this.startSupportActionMode((ActionMode.Callback)callbackWrapper);
      return (actionMode != null) ? callbackWrapper.getActionModeWrapper(actionMode) : null;
    }
  }
  
  @VisibleForTesting
  final class AutoNightModeManager {
    private BroadcastReceiver mAutoTimeChangeReceiver;
    
    private IntentFilter mAutoTimeChangeReceiverFilter;
    
    private boolean mIsNight;
    
    private TwilightManager mTwilightManager;
    
    AutoNightModeManager(TwilightManager param1TwilightManager) {
      this.mTwilightManager = param1TwilightManager;
      this.mIsNight = param1TwilightManager.isNight();
    }
    
    final void cleanup() {
      if (this.mAutoTimeChangeReceiver != null) {
        AppCompatDelegateImplV14.this.mContext.unregisterReceiver(this.mAutoTimeChangeReceiver);
        this.mAutoTimeChangeReceiver = null;
      } 
    }
    
    final void dispatchTimeChanged() {
      boolean bool = this.mTwilightManager.isNight();
      if (bool != this.mIsNight) {
        this.mIsNight = bool;
        AppCompatDelegateImplV14.this.applyDayNight();
      } 
    }
    
    final int getApplyableNightMode() {
      this.mIsNight = this.mTwilightManager.isNight();
      return this.mIsNight ? 2 : 1;
    }
    
    final void setup() {
      cleanup();
      if (this.mAutoTimeChangeReceiver == null)
        this.mAutoTimeChangeReceiver = new BroadcastReceiver() {
            public void onReceive(Context param2Context, Intent param2Intent) {
              AppCompatDelegateImplV14.AutoNightModeManager.this.dispatchTimeChanged();
            }
          }; 
      if (this.mAutoTimeChangeReceiverFilter == null) {
        this.mAutoTimeChangeReceiverFilter = new IntentFilter();
        this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_SET");
        this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_TICK");
      } 
      AppCompatDelegateImplV14.this.mContext.registerReceiver(this.mAutoTimeChangeReceiver, this.mAutoTimeChangeReceiverFilter);
    }
  }
  
  class null extends BroadcastReceiver {
    public void onReceive(Context param1Context, Intent param1Intent) {
      this.this$1.dispatchTimeChanged();
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\app\AppCompatDelegateImplV14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */