package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(20)
@RequiresApi(20)
class RemoteInputCompatApi20 {
  static void addResultsToIntent(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle) {
    RemoteInput.addResultsToIntent(fromCompat(paramArrayOfRemoteInput), paramIntent, paramBundle);
  }
  
  static RemoteInput[] fromCompat(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput) {
    if (paramArrayOfRemoteInput == null)
      return null; 
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfRemoteInput.length];
    int i = 0;
    while (true) {
      RemoteInputCompatBase.RemoteInput remoteInput;
      RemoteInput[] arrayOfRemoteInput1 = arrayOfRemoteInput;
      if (i < paramArrayOfRemoteInput.length) {
        remoteInput = paramArrayOfRemoteInput[i];
        arrayOfRemoteInput[i] = (new RemoteInput.Builder(remoteInput.getResultKey())).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build();
        i++;
        continue;
      } 
      return (RemoteInput[])remoteInput;
    } 
  }
  
  static Bundle getResultsFromIntent(Intent paramIntent) {
    return RemoteInput.getResultsFromIntent(paramIntent);
  }
  
  static RemoteInputCompatBase.RemoteInput[] toCompat(RemoteInput[] paramArrayOfRemoteInput, RemoteInputCompatBase.RemoteInput.Factory paramFactory) {
    if (paramArrayOfRemoteInput == null)
      return null; 
    RemoteInputCompatBase.RemoteInput[] arrayOfRemoteInput = paramFactory.newArray(paramArrayOfRemoteInput.length);
    int i = 0;
    while (true) {
      RemoteInput remoteInput;
      RemoteInputCompatBase.RemoteInput[] arrayOfRemoteInput1 = arrayOfRemoteInput;
      if (i < paramArrayOfRemoteInput.length) {
        remoteInput = paramArrayOfRemoteInput[i];
        arrayOfRemoteInput[i] = paramFactory.build(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
        i++;
        continue;
      } 
      return (RemoteInputCompatBase.RemoteInput[])remoteInput;
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\RemoteInputCompatApi20.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */