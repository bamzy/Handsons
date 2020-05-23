package android.support.v4.app;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.text.Html;

@TargetApi(16)
@RequiresApi(16)
class ShareCompatJB {
  public static String escapeHtml(CharSequence paramCharSequence) {
    return Html.escapeHtml(paramCharSequence);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ShareCompatJB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */