package android.support.v4.os;

import android.content.Context;

public class UserManagerCompat {
  public static boolean isUserUnlocked(Context paramContext) {
    return BuildCompat.isAtLeastN() ? UserManagerCompatApi24.isUserUnlocked(paramContext) : true;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\os\UserManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */