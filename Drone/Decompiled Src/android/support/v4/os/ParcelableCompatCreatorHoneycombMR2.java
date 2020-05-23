package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;

@TargetApi(13)
@RequiresApi(13)
class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
  private final ParcelableCompatCreatorCallbacks<T> mCallbacks;
  
  public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks) {
    this.mCallbacks = paramParcelableCompatCreatorCallbacks;
  }
  
  public T createFromParcel(Parcel paramParcel) {
    return this.mCallbacks.createFromParcel(paramParcel, null);
  }
  
  public T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader) {
    return this.mCallbacks.createFromParcel(paramParcel, paramClassLoader);
  }
  
  public T[] newArray(int paramInt) {
    return this.mCallbacks.newArray(paramInt);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\os\ParcelableCompatCreatorHoneycombMR2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */