package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Arrays;

class BundleUtil {
  public static Bundle[] getBundleArrayFromBundle(Bundle paramBundle, String paramString) {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (arrayOfParcelable instanceof Bundle[] || arrayOfParcelable == null)
      return (Bundle[])arrayOfParcelable; 
    Bundle[] arrayOfBundle = Arrays.<Bundle, Parcelable>copyOf(arrayOfParcelable, arrayOfParcelable.length, Bundle[].class);
    paramBundle.putParcelableArray(paramString, (Parcelable[])arrayOfBundle);
    return arrayOfBundle;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\BundleUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */