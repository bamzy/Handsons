package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.CancellationSignal;
import android.support.annotation.RequiresApi;

@TargetApi(16)
@RequiresApi(16)
class CancellationSignalCompatJellybean {
  public static void cancel(Object paramObject) {
    ((CancellationSignal)paramObject).cancel();
  }
  
  public static Object create() {
    return new CancellationSignal();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\os\CancellationSignalCompatJellybean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */