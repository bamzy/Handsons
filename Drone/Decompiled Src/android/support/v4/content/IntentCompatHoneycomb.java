package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.support.annotation.RequiresApi;

@TargetApi(11)
@RequiresApi(11)
class IntentCompatHoneycomb {
  public static Intent makeMainActivity(ComponentName paramComponentName) {
    return Intent.makeMainActivity(paramComponentName);
  }
  
  public static Intent makeRestartActivityTask(ComponentName paramComponentName) {
    return Intent.makeRestartActivityTask(paramComponentName);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\IntentCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */