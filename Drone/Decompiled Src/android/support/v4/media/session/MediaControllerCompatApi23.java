package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(23)
@RequiresApi(23)
class MediaControllerCompatApi23 {
  public static class TransportControls extends MediaControllerCompatApi21.TransportControls {
    public static void playFromUri(Object param1Object, Uri param1Uri, Bundle param1Bundle) {
      ((MediaController.TransportControls)param1Object).playFromUri(param1Uri, param1Bundle);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\media\session\MediaControllerCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */