package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MediaBrowserCompatUtils {
  public static boolean areSameOptions(Bundle paramBundle1, Bundle paramBundle2) {
    if (paramBundle1 != paramBundle2) {
      if (paramBundle1 == null)
        return !(paramBundle2.getInt("android.media.browse.extra.PAGE", -1) != -1 || paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1); 
      if (paramBundle2 == null)
        return !(paramBundle1.getInt("android.media.browse.extra.PAGE", -1) != -1 || paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1); 
      if (paramBundle1.getInt("android.media.browse.extra.PAGE", -1) != paramBundle2.getInt("android.media.browse.extra.PAGE", -1) || paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1))
        return false; 
    } 
    return true;
  }
  
  public static boolean hasDuplicatedItems(Bundle paramBundle1, Bundle paramBundle2) {
    int i;
    int j;
    int k;
    int m;
    if (paramBundle1 == null) {
      k = -1;
    } else {
      k = paramBundle1.getInt("android.media.browse.extra.PAGE", -1);
    } 
    if (paramBundle2 == null) {
      i = -1;
    } else {
      i = paramBundle2.getInt("android.media.browse.extra.PAGE", -1);
    } 
    if (paramBundle1 == null) {
      m = -1;
    } else {
      m = paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    } 
    if (paramBundle2 == null) {
      j = -1;
    } else {
      j = paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    } 
    if (k == -1 || m == -1) {
      m = 0;
      k = Integer.MAX_VALUE;
    } else {
      int n = m * k;
      k = n + m - 1;
      m = n;
    } 
    if (i == -1 || j == -1) {
      j = 0;
      i = Integer.MAX_VALUE;
    } else {
      int n = j * i;
      i = n + j - 1;
      j = n;
    } 
    return !((m > j || j > k) && (m > i || i > k));
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\media\MediaBrowserCompatUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */