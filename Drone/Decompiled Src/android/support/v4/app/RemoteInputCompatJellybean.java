package android.support.v4.app;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(16)
@RequiresApi(16)
class RemoteInputCompatJellybean {
  public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
  
  private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
  
  private static final String KEY_CHOICES = "choices";
  
  private static final String KEY_EXTRAS = "extras";
  
  private static final String KEY_LABEL = "label";
  
  private static final String KEY_RESULT_KEY = "resultKey";
  
  public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
  
  static void addResultsToIntent(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle) {
    Bundle bundle = new Bundle();
    int j = paramArrayOfRemoteInput.length;
    for (int i = 0; i < j; i++) {
      RemoteInputCompatBase.RemoteInput remoteInput = paramArrayOfRemoteInput[i];
      Object object = paramBundle.get(remoteInput.getResultKey());
      if (object instanceof CharSequence)
        bundle.putCharSequence(remoteInput.getResultKey(), (CharSequence)object); 
    } 
    Intent intent = new Intent();
    intent.putExtra("android.remoteinput.resultsData", bundle);
    paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", intent));
  }
  
  static RemoteInputCompatBase.RemoteInput fromBundle(Bundle paramBundle, RemoteInputCompatBase.RemoteInput.Factory paramFactory) {
    return paramFactory.build(paramBundle.getString("resultKey"), paramBundle.getCharSequence("label"), paramBundle.getCharSequenceArray("choices"), paramBundle.getBoolean("allowFreeFormInput"), paramBundle.getBundle("extras"));
  }
  
  static RemoteInputCompatBase.RemoteInput[] fromBundleArray(Bundle[] paramArrayOfBundle, RemoteInputCompatBase.RemoteInput.Factory paramFactory) {
    if (paramArrayOfBundle == null)
      return null; 
    RemoteInputCompatBase.RemoteInput[] arrayOfRemoteInput = paramFactory.newArray(paramArrayOfBundle.length);
    int i = 0;
    while (true) {
      RemoteInputCompatBase.RemoteInput[] arrayOfRemoteInput1 = arrayOfRemoteInput;
      if (i < paramArrayOfBundle.length) {
        arrayOfRemoteInput[i] = fromBundle(paramArrayOfBundle[i], paramFactory);
        i++;
        continue;
      } 
      return arrayOfRemoteInput1;
    } 
  }
  
  static Bundle getResultsFromIntent(Intent paramIntent) {
    ClipData clipData = paramIntent.getClipData();
    if (clipData != null) {
      ClipDescription clipDescription = clipData.getDescription();
      if (clipDescription.hasMimeType("text/vnd.android.intent") && clipDescription.getLabel().equals("android.remoteinput.results"))
        return (Bundle)clipData.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData"); 
    } 
    return null;
  }
  
  static Bundle toBundle(RemoteInputCompatBase.RemoteInput paramRemoteInput) {
    Bundle bundle = new Bundle();
    bundle.putString("resultKey", paramRemoteInput.getResultKey());
    bundle.putCharSequence("label", paramRemoteInput.getLabel());
    bundle.putCharSequenceArray("choices", paramRemoteInput.getChoices());
    bundle.putBoolean("allowFreeFormInput", paramRemoteInput.getAllowFreeFormInput());
    bundle.putBundle("extras", paramRemoteInput.getExtras());
    return bundle;
  }
  
  static Bundle[] toBundleArray(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput) {
    if (paramArrayOfRemoteInput == null)
      return null; 
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfRemoteInput.length];
    int i = 0;
    while (true) {
      Bundle[] arrayOfBundle1 = arrayOfBundle;
      if (i < paramArrayOfRemoteInput.length) {
        arrayOfBundle[i] = toBundle(paramArrayOfRemoteInput[i]);
        i++;
        continue;
      } 
      return arrayOfBundle1;
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\RemoteInputCompatJellybean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */