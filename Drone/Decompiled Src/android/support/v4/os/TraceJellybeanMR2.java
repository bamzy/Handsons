package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.Trace;
import android.support.annotation.RequiresApi;

@TargetApi(18)
@RequiresApi(18)
class TraceJellybeanMR2 {
  public static void beginSection(String paramString) {
    Trace.beginSection(paramString);
  }
  
  public static void endSection() {
    Trace.endSection();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\os\TraceJellybeanMR2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */