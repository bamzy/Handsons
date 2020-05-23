package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;

@TargetApi(13)
@RequiresApi(13)
class ParcelableCompatCreatorHoneycombMR2Stub {
  static <T> Parcelable.Creator<T> instantiate(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks) {
    return (Parcelable.Creator<T>)new ParcelableCompatCreatorHoneycombMR2<T>(paramParcelableCompatCreatorCallbacks);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\os\ParcelableCompatCreatorHoneycombMR2Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */