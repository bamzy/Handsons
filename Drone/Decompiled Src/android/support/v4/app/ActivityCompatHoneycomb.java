package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@TargetApi(11)
@RequiresApi(11)
class ActivityCompatHoneycomb {
  static void dump(Activity paramActivity, String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramActivity.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  static void invalidateOptionsMenu(Activity paramActivity) {
    paramActivity.invalidateOptionsMenu();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ActivityCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */