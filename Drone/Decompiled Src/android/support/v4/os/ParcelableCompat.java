package android.support.v4.os;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

public final class ParcelableCompat {
  public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks) {
    return (Build.VERSION.SDK_INT >= 13) ? ParcelableCompatCreatorHoneycombMR2Stub.instantiate(paramParcelableCompatCreatorCallbacks) : new CompatCreator<T>(paramParcelableCompatCreatorCallbacks);
  }
  
  static class CompatCreator<T> implements Parcelable.Creator<T> {
    final ParcelableCompatCreatorCallbacks<T> mCallbacks;
    
    public CompatCreator(ParcelableCompatCreatorCallbacks<T> param1ParcelableCompatCreatorCallbacks) {
      this.mCallbacks = param1ParcelableCompatCreatorCallbacks;
    }
    
    public T createFromParcel(Parcel param1Parcel) {
      return this.mCallbacks.createFromParcel(param1Parcel, null);
    }
    
    public T[] newArray(int param1Int) {
      return this.mCallbacks.newArray(param1Int);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\os\ParcelableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */