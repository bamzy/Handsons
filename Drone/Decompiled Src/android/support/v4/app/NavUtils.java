package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.IntentCompat;
import android.util.Log;

public final class NavUtils {
  private static final NavUtilsImpl IMPL = new NavUtilsImplBase();
  
  public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
  
  private static final String TAG = "NavUtils";
  
  public static Intent getParentActivityIntent(Activity paramActivity) {
    return IMPL.getParentActivityIntent(paramActivity);
  }
  
  public static Intent getParentActivityIntent(Context paramContext, ComponentName paramComponentName) throws PackageManager.NameNotFoundException {
    String str = getParentActivityName(paramContext, paramComponentName);
    if (str == null)
      return null; 
    paramComponentName = new ComponentName(paramComponentName.getPackageName(), str);
    return (getParentActivityName(paramContext, paramComponentName) == null) ? IntentCompat.makeMainActivity(paramComponentName) : (new Intent()).setComponent(paramComponentName);
  }
  
  public static Intent getParentActivityIntent(Context paramContext, Class<?> paramClass) throws PackageManager.NameNotFoundException {
    String str = getParentActivityName(paramContext, new ComponentName(paramContext, paramClass));
    if (str == null)
      return null; 
    ComponentName componentName = new ComponentName(paramContext, str);
    return (getParentActivityName(paramContext, componentName) == null) ? IntentCompat.makeMainActivity(componentName) : (new Intent()).setComponent(componentName);
  }
  
  @Nullable
  public static String getParentActivityName(Activity paramActivity) {
    try {
      return getParentActivityName((Context)paramActivity, paramActivity.getComponentName());
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      throw new IllegalArgumentException(nameNotFoundException);
    } 
  }
  
  @Nullable
  public static String getParentActivityName(Context paramContext, ComponentName paramComponentName) throws PackageManager.NameNotFoundException {
    ActivityInfo activityInfo = paramContext.getPackageManager().getActivityInfo(paramComponentName, 128);
    return IMPL.getParentActivityName(paramContext, activityInfo);
  }
  
  public static void navigateUpFromSameTask(Activity paramActivity) {
    Intent intent = getParentActivityIntent(paramActivity);
    if (intent == null)
      throw new IllegalArgumentException("Activity " + paramActivity.getClass().getSimpleName() + " does not have a parent activity name specified." + " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " + " element in your manifest?)"); 
    navigateUpTo(paramActivity, intent);
  }
  
  public static void navigateUpTo(Activity paramActivity, Intent paramIntent) {
    IMPL.navigateUpTo(paramActivity, paramIntent);
  }
  
  public static boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent) {
    return IMPL.shouldUpRecreateTask(paramActivity, paramIntent);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new NavUtilsImplJB();
      return;
    } 
  }
  
  static interface NavUtilsImpl {
    Intent getParentActivityIntent(Activity param1Activity);
    
    String getParentActivityName(Context param1Context, ActivityInfo param1ActivityInfo);
    
    void navigateUpTo(Activity param1Activity, Intent param1Intent);
    
    boolean shouldUpRecreateTask(Activity param1Activity, Intent param1Intent);
  }
  
  static class NavUtilsImplBase implements NavUtilsImpl {
    public Intent getParentActivityIntent(Activity param1Activity) {
      String str = NavUtils.getParentActivityName(param1Activity);
      if (str == null)
        return null; 
      ComponentName componentName = new ComponentName((Context)param1Activity, str);
      try {
        if (NavUtils.getParentActivityName((Context)param1Activity, componentName) == null) {
          Intent intent = IntentCompat.makeMainActivity(componentName);
        } else {
          Intent intent = (new Intent()).setComponent(componentName);
        } 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + str + "' in manifest");
        return null;
      } 
      return (Intent)nameNotFoundException;
    }
    
    public String getParentActivityName(Context param1Context, ActivityInfo param1ActivityInfo) {
      if (param1ActivityInfo.metaData == null)
        return null; 
      String str2 = param1ActivityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
      if (str2 == null)
        return null; 
      String str1 = str2;
      return (str2.charAt(0) == '.') ? (param1Context.getPackageName() + str2) : str1;
    }
    
    public void navigateUpTo(Activity param1Activity, Intent param1Intent) {
      param1Intent.addFlags(67108864);
      param1Activity.startActivity(param1Intent);
      param1Activity.finish();
    }
    
    public boolean shouldUpRecreateTask(Activity param1Activity, Intent param1Intent) {
      String str = param1Activity.getIntent().getAction();
      return (str != null && !str.equals("android.intent.action.MAIN"));
    }
  }
  
  static class NavUtilsImplJB extends NavUtilsImplBase {
    public Intent getParentActivityIntent(Activity param1Activity) {
      Intent intent2 = NavUtilsJB.getParentActivityIntent(param1Activity);
      Intent intent1 = intent2;
      if (intent2 == null)
        intent1 = superGetParentActivityIntent(param1Activity); 
      return intent1;
    }
    
    public String getParentActivityName(Context param1Context, ActivityInfo param1ActivityInfo) {
      String str2 = NavUtilsJB.getParentActivityName(param1ActivityInfo);
      String str1 = str2;
      if (str2 == null)
        str1 = super.getParentActivityName(param1Context, param1ActivityInfo); 
      return str1;
    }
    
    public void navigateUpTo(Activity param1Activity, Intent param1Intent) {
      NavUtilsJB.navigateUpTo(param1Activity, param1Intent);
    }
    
    public boolean shouldUpRecreateTask(Activity param1Activity, Intent param1Intent) {
      return NavUtilsJB.shouldUpRecreateTask(param1Activity, param1Intent);
    }
    
    Intent superGetParentActivityIntent(Activity param1Activity) {
      return super.getParentActivityIntent(param1Activity);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\NavUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */