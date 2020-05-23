package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

public class AppLaunchChecker {
  private static final String KEY_STARTED_FROM_LAUNCHER = "startedFromLauncher";
  
  private static final String SHARED_PREFS_NAME = "android.support.AppLaunchChecker";
  
  public static boolean hasStartedFromLauncher(Context paramContext) {
    return paramContext.getSharedPreferences("android.support.AppLaunchChecker", 0).getBoolean("startedFromLauncher", false);
  }
  
  public static void onActivityCreate(Activity paramActivity) {
    SharedPreferences sharedPreferences = paramActivity.getSharedPreferences("android.support.AppLaunchChecker", 0);
    if (!sharedPreferences.getBoolean("startedFromLauncher", false)) {
      Intent intent = paramActivity.getIntent();
      if (intent != null && "android.intent.action.MAIN".equals(intent.getAction()) && (intent.hasCategory("android.intent.category.LAUNCHER") || intent.hasCategory("android.intent.category.LEANBACK_LAUNCHER"))) {
        SharedPreferencesCompat.EditorCompat.getInstance().apply(sharedPreferences.edit().putBoolean("startedFromLauncher", true));
        return;
      } 
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\AppLaunchChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */