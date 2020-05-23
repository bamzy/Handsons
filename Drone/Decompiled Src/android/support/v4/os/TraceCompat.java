package android.support.v4.os;

import android.os.Build;

public final class TraceCompat {
  public static void beginSection(String paramString) {
    if (Build.VERSION.SDK_INT >= 18)
      TraceJellybeanMR2.beginSection(paramString); 
  }
  
  public static void endSection() {
    if (Build.VERSION.SDK_INT >= 18)
      TraceJellybeanMR2.endSection(); 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\os\TraceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */