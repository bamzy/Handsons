package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
  private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
  
  private static final SparseArray<PowerManager.WakeLock> mActiveWakeLocks = new SparseArray();
  
  private static int mNextId = 1;
  
  public static boolean completeWakefulIntent(Intent paramIntent) {
    int i = paramIntent.getIntExtra("android.support.content.wakelockid", 0);
    if (i == 0)
      return false; 
    synchronized (mActiveWakeLocks) {
      PowerManager.WakeLock wakeLock = (PowerManager.WakeLock)mActiveWakeLocks.get(i);
      if (wakeLock != null) {
        wakeLock.release();
        mActiveWakeLocks.remove(i);
        return true;
      } 
      Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + i);
      return true;
    } 
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent) {
    synchronized (mActiveWakeLocks) {
      int i = mNextId;
      mNextId++;
      if (mNextId <= 0)
        mNextId = 1; 
      paramIntent.putExtra("android.support.content.wakelockid", i);
      ComponentName componentName = paramContext.startService(paramIntent);
      if (componentName == null)
        return null; 
      PowerManager.WakeLock wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "wake:" + componentName.flattenToShortString());
      wakeLock.setReferenceCounted(false);
      wakeLock.acquire(60000L);
      mActiveWakeLocks.put(i, wakeLock);
      return componentName;
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\WakefulBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */