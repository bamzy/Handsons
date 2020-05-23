package android.support.v4.app;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(9)
@RequiresApi(9)
class RemoteInputCompatBase {
  public static abstract class RemoteInput {
    protected abstract boolean getAllowFreeFormInput();
    
    protected abstract CharSequence[] getChoices();
    
    protected abstract Bundle getExtras();
    
    protected abstract CharSequence getLabel();
    
    protected abstract String getResultKey();
    
    public static interface Factory {
      RemoteInputCompatBase.RemoteInput build(String param2String, CharSequence param2CharSequence, CharSequence[] param2ArrayOfCharSequence, boolean param2Boolean, Bundle param2Bundle);
      
      RemoteInputCompatBase.RemoteInput[] newArray(int param2Int);
    }
  }
  
  public static interface Factory {
    RemoteInputCompatBase.RemoteInput build(String param1String, CharSequence param1CharSequence, CharSequence[] param1ArrayOfCharSequence, boolean param1Boolean, Bundle param1Bundle);
    
    RemoteInputCompatBase.RemoteInput[] newArray(int param1Int);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\RemoteInputCompatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */