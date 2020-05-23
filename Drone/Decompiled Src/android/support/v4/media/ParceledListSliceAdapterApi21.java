package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.browse.MediaBrowser;
import android.support.annotation.RequiresApi;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@TargetApi(21)
@RequiresApi(21)
class ParceledListSliceAdapterApi21 {
  private static Constructor sConstructor;
  
  static {
    try {
      sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(new Class[] { List.class });
      return;
    } catch (ClassNotFoundException classNotFoundException) {
    
    } catch (NoSuchMethodException noSuchMethodException) {}
    noSuchMethodException.printStackTrace();
  }
  
  static Object newInstance(List<MediaBrowser.MediaItem> paramList) {
    try {
      return sConstructor.newInstance(new Object[] { paramList });
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    invocationTargetException.printStackTrace();
    return null;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\media\ParceledListSliceAdapterApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */