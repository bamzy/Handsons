package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

final class FragmentManagerState implements Parcelable {
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {
      public FragmentManagerState createFromParcel(Parcel param1Parcel) {
        return new FragmentManagerState(param1Parcel);
      }
      
      public FragmentManagerState[] newArray(int param1Int) {
        return new FragmentManagerState[param1Int];
      }
    };
  
  FragmentState[] mActive;
  
  int[] mAdded;
  
  BackStackState[] mBackStack;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel) {
    this.mActive = (FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR);
    this.mAdded = paramParcel.createIntArray();
    this.mBackStack = (BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeTypedArray((Parcelable[])this.mActive, paramInt);
    paramParcel.writeIntArray(this.mAdded);
    paramParcel.writeTypedArray((Parcelable[])this.mBackStack, paramInt);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\FragmentManagerState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */