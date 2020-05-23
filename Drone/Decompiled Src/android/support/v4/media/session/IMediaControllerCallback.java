package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

public interface IMediaControllerCallback extends IInterface {
  void onEvent(String paramString, Bundle paramBundle) throws RemoteException;
  
  void onExtrasChanged(Bundle paramBundle) throws RemoteException;
  
  void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat) throws RemoteException;
  
  void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat) throws RemoteException;
  
  void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList) throws RemoteException;
  
  void onQueueTitleChanged(CharSequence paramCharSequence) throws RemoteException;
  
  void onRepeatModeChanged(int paramInt) throws RemoteException;
  
  void onSessionDestroyed() throws RemoteException;
  
  void onShuffleModeChanged(boolean paramBoolean) throws RemoteException;
  
  void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IMediaControllerCallback {
    private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
    
    static final int TRANSACTION_onEvent = 1;
    
    static final int TRANSACTION_onExtrasChanged = 7;
    
    static final int TRANSACTION_onMetadataChanged = 4;
    
    static final int TRANSACTION_onPlaybackStateChanged = 3;
    
    static final int TRANSACTION_onQueueChanged = 5;
    
    static final int TRANSACTION_onQueueTitleChanged = 6;
    
    static final int TRANSACTION_onRepeatModeChanged = 9;
    
    static final int TRANSACTION_onSessionDestroyed = 2;
    
    static final int TRANSACTION_onShuffleModeChanged = 10;
    
    static final int TRANSACTION_onVolumeInfoChanged = 8;
    
    public Stub() {
      attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
    }
    
    public static IMediaControllerCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
      return (iInterface != null && iInterface instanceof IMediaControllerCallback) ? (IMediaControllerCallback)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      String str;
      switch (param1Int1) {
        default:
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
        case 1598968902:
          param1Parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
          return true;
        case 1:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          str = param1Parcel1.readString();
          if (param1Parcel1.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1);
            onEvent(str, bundle);
            return true;
          } 
          param1Parcel1 = null;
          onEvent(str, (Bundle)param1Parcel1);
          return true;
        case 2:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onSessionDestroyed();
          return true;
        case 3:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (param1Parcel1.readInt() != 0) {
            PlaybackStateCompat playbackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(param1Parcel1);
            onPlaybackStateChanged(playbackStateCompat);
            return true;
          } 
          param1Parcel1 = null;
          onPlaybackStateChanged((PlaybackStateCompat)param1Parcel1);
          return true;
        case 4:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (param1Parcel1.readInt() != 0) {
            MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(param1Parcel1);
            onMetadataChanged(mediaMetadataCompat);
            return true;
          } 
          param1Parcel1 = null;
          onMetadataChanged((MediaMetadataCompat)param1Parcel1);
          return true;
        case 5:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onQueueChanged(param1Parcel1.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
          return true;
        case 6:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (param1Parcel1.readInt() != 0) {
            CharSequence charSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(param1Parcel1);
            onQueueTitleChanged(charSequence);
            return true;
          } 
          param1Parcel1 = null;
          onQueueTitleChanged((CharSequence)param1Parcel1);
          return true;
        case 7:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (param1Parcel1.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1);
            onExtrasChanged(bundle);
            return true;
          } 
          param1Parcel1 = null;
          onExtrasChanged((Bundle)param1Parcel1);
          return true;
        case 8:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (param1Parcel1.readInt() != 0) {
            ParcelableVolumeInfo parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(param1Parcel1);
            onVolumeInfoChanged(parcelableVolumeInfo);
            return true;
          } 
          param1Parcel1 = null;
          onVolumeInfoChanged((ParcelableVolumeInfo)param1Parcel1);
          return true;
        case 9:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onRepeatModeChanged(param1Parcel1.readInt());
          return true;
        case 10:
          break;
      } 
      param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      if (param1Parcel1.readInt() != 0) {
        boolean bool1 = true;
        onShuffleModeChanged(bool1);
        return true;
      } 
      boolean bool = false;
      onShuffleModeChanged(bool);
      return true;
    }
    
    private static class Proxy implements IMediaControllerCallback {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return "android.support.v4.media.session.IMediaControllerCallback";
      }
      
      public void onEvent(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          parcel.writeString(param2String);
          if (param2Bundle != null) {
            parcel.writeInt(1);
            param2Bundle.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(1, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onExtrasChanged(Bundle param2Bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2Bundle != null) {
            parcel.writeInt(1);
            param2Bundle.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(7, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onMetadataChanged(MediaMetadataCompat param2MediaMetadataCompat) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2MediaMetadataCompat != null) {
            parcel.writeInt(1);
            param2MediaMetadataCompat.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(4, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onPlaybackStateChanged(PlaybackStateCompat param2PlaybackStateCompat) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2PlaybackStateCompat != null) {
            parcel.writeInt(1);
            param2PlaybackStateCompat.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(3, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> param2List) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          parcel.writeTypedList(param2List);
          this.mRemote.transact(5, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onQueueTitleChanged(CharSequence param2CharSequence) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2CharSequence != null) {
            parcel.writeInt(1);
            TextUtils.writeToParcel(param2CharSequence, parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(6, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onRepeatModeChanged(int param2Int) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          parcel.writeInt(param2Int);
          this.mRemote.transact(9, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onSessionDestroyed() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          this.mRemote.transact(2, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onShuffleModeChanged(boolean param2Boolean) throws RemoteException {
        boolean bool = true;
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (!param2Boolean)
            bool = false; 
          parcel.writeInt(bool);
          this.mRemote.transact(10, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onVolumeInfoChanged(ParcelableVolumeInfo param2ParcelableVolumeInfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2ParcelableVolumeInfo != null) {
            parcel.writeInt(1);
            param2ParcelableVolumeInfo.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(8, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements IMediaControllerCallback {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return "android.support.v4.media.session.IMediaControllerCallback";
    }
    
    public void onEvent(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        parcel.writeString(param1String);
        if (param1Bundle != null) {
          parcel.writeInt(1);
          param1Bundle.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(1, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onExtrasChanged(Bundle param1Bundle) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1Bundle != null) {
          parcel.writeInt(1);
          param1Bundle.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(7, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onMetadataChanged(MediaMetadataCompat param1MediaMetadataCompat) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1MediaMetadataCompat != null) {
          parcel.writeInt(1);
          param1MediaMetadataCompat.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(4, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onPlaybackStateChanged(PlaybackStateCompat param1PlaybackStateCompat) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1PlaybackStateCompat != null) {
          parcel.writeInt(1);
          param1PlaybackStateCompat.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(3, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onQueueChanged(List<MediaSessionCompat.QueueItem> param1List) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        parcel.writeTypedList(param1List);
        this.mRemote.transact(5, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onQueueTitleChanged(CharSequence param1CharSequence) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1CharSequence != null) {
          parcel.writeInt(1);
          TextUtils.writeToParcel(param1CharSequence, parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(6, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onRepeatModeChanged(int param1Int) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        parcel.writeInt(param1Int);
        this.mRemote.transact(9, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onSessionDestroyed() throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        this.mRemote.transact(2, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onShuffleModeChanged(boolean param1Boolean) throws RemoteException {
      boolean bool = true;
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (!param1Boolean)
          bool = false; 
        parcel.writeInt(bool);
        this.mRemote.transact(10, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onVolumeInfoChanged(ParcelableVolumeInfo param1ParcelableVolumeInfo) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1ParcelableVolumeInfo != null) {
          parcel.writeInt(1);
          param1ParcelableVolumeInfo.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(8, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\media\session\IMediaControllerCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */