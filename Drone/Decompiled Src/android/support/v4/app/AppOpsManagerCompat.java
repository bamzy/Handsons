package android.support.v4.app;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;

public final class AppOpsManagerCompat {
  private static final AppOpsManagerImpl IMPL = new AppOpsManagerImpl();
  
  public static final int MODE_ALLOWED = 0;
  
  public static final int MODE_DEFAULT = 3;
  
  public static final int MODE_IGNORED = 1;
  
  public static int noteOp(@NonNull Context paramContext, @NonNull String paramString1, int paramInt, @NonNull String paramString2) {
    return IMPL.noteOp(paramContext, paramString1, paramInt, paramString2);
  }
  
  public static int noteProxyOp(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2) {
    return IMPL.noteProxyOp(paramContext, paramString1, paramString2);
  }
  
  public static String permissionToOp(@NonNull String paramString) {
    return IMPL.permissionToOp(paramString);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 23) {
      IMPL = new AppOpsManager23();
      return;
    } 
  }
  
  private static class AppOpsManager23 extends AppOpsManagerImpl {
    public int noteOp(Context param1Context, String param1String1, int param1Int, String param1String2) {
      return AppOpsManagerCompat23.noteOp(param1Context, param1String1, param1Int, param1String2);
    }
    
    public int noteProxyOp(Context param1Context, String param1String1, String param1String2) {
      return AppOpsManagerCompat23.noteProxyOp(param1Context, param1String1, param1String2);
    }
    
    public String permissionToOp(String param1String) {
      return AppOpsManagerCompat23.permissionToOp(param1String);
    }
  }
  
  private static class AppOpsManagerImpl {
    public int noteOp(Context param1Context, String param1String1, int param1Int, String param1String2) {
      return 1;
    }
    
    public int noteProxyOp(Context param1Context, String param1String1, String param1String2) {
      return 1;
    }
    
    public String permissionToOp(String param1String) {
      return null;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\AppOpsManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */