package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;

public final class IntentCompat {
  public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
  
  public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
  
  public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
  
  public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
  
  public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
  
  public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
  
  public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
  
  public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
  
  private static final IntentCompatImpl IMPL = new IntentCompatImplBase();
  
  public static Intent makeMainActivity(ComponentName paramComponentName) {
    return IMPL.makeMainActivity(paramComponentName);
  }
  
  public static Intent makeMainSelectorActivity(String paramString1, String paramString2) {
    return IMPL.makeMainSelectorActivity(paramString1, paramString2);
  }
  
  public static Intent makeRestartActivityTask(ComponentName paramComponentName) {
    return IMPL.makeRestartActivityTask(paramComponentName);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 15) {
      IMPL = new IntentCompatImplIcsMr1();
      return;
    } 
    if (i >= 11) {
      IMPL = new IntentCompatImplHC();
      return;
    } 
  }
  
  static interface IntentCompatImpl {
    Intent makeMainActivity(ComponentName param1ComponentName);
    
    Intent makeMainSelectorActivity(String param1String1, String param1String2);
    
    Intent makeRestartActivityTask(ComponentName param1ComponentName);
  }
  
  static class IntentCompatImplBase implements IntentCompatImpl {
    public Intent makeMainActivity(ComponentName param1ComponentName) {
      Intent intent = new Intent("android.intent.action.MAIN");
      intent.setComponent(param1ComponentName);
      intent.addCategory("android.intent.category.LAUNCHER");
      return intent;
    }
    
    public Intent makeMainSelectorActivity(String param1String1, String param1String2) {
      Intent intent = new Intent(param1String1);
      intent.addCategory(param1String2);
      return intent;
    }
    
    public Intent makeRestartActivityTask(ComponentName param1ComponentName) {
      Intent intent = makeMainActivity(param1ComponentName);
      intent.addFlags(268468224);
      return intent;
    }
  }
  
  static class IntentCompatImplHC extends IntentCompatImplBase {
    public Intent makeMainActivity(ComponentName param1ComponentName) {
      return IntentCompatHoneycomb.makeMainActivity(param1ComponentName);
    }
    
    public Intent makeRestartActivityTask(ComponentName param1ComponentName) {
      return IntentCompatHoneycomb.makeRestartActivityTask(param1ComponentName);
    }
  }
  
  static class IntentCompatImplIcsMr1 extends IntentCompatImplHC {
    public Intent makeMainSelectorActivity(String param1String1, String param1String2) {
      return IntentCompatIcsMr1.makeMainSelectorActivity(param1String1, param1String2);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\IntentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */