package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.BuildCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class MediaBrowserCompat {
  static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
  
  public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
  
  public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
  
  static final String TAG = "MediaBrowserCompat";
  
  private final MediaBrowserImpl mImpl;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, ConnectionCallback paramConnectionCallback, Bundle paramBundle) {
    if (Build.VERSION.SDK_INT >= 26 || BuildCompat.isAtLeastO()) {
      this.mImpl = new MediaBrowserImplApi24(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 23) {
      this.mImpl = new MediaBrowserImplApi23(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      this.mImpl = new MediaBrowserImplApi21(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
      return;
    } 
    this.mImpl = new MediaBrowserImplBase(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
  }
  
  public void connect() {
    this.mImpl.connect();
  }
  
  public void disconnect() {
    this.mImpl.disconnect();
  }
  
  @Nullable
  public Bundle getExtras() {
    return this.mImpl.getExtras();
  }
  
  public void getItem(@NonNull String paramString, @NonNull ItemCallback paramItemCallback) {
    this.mImpl.getItem(paramString, paramItemCallback);
  }
  
  @NonNull
  public String getRoot() {
    return this.mImpl.getRoot();
  }
  
  @NonNull
  public ComponentName getServiceComponent() {
    return this.mImpl.getServiceComponent();
  }
  
  @NonNull
  public MediaSessionCompat.Token getSessionToken() {
    return this.mImpl.getSessionToken();
  }
  
  public boolean isConnected() {
    return this.mImpl.isConnected();
  }
  
  public void search(@NonNull String paramString, Bundle paramBundle, @NonNull SearchCallback paramSearchCallback) {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("query cannot be empty"); 
    if (paramSearchCallback == null)
      throw new IllegalArgumentException("callback cannot be null"); 
    this.mImpl.search(paramString, paramBundle, paramSearchCallback);
  }
  
  public void subscribe(@NonNull String paramString, @NonNull Bundle paramBundle, @NonNull SubscriptionCallback paramSubscriptionCallback) {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("parentId is empty"); 
    if (paramSubscriptionCallback == null)
      throw new IllegalArgumentException("callback is null"); 
    if (paramBundle == null)
      throw new IllegalArgumentException("options are null"); 
    this.mImpl.subscribe(paramString, paramBundle, paramSubscriptionCallback);
  }
  
  public void subscribe(@NonNull String paramString, @NonNull SubscriptionCallback paramSubscriptionCallback) {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("parentId is empty"); 
    if (paramSubscriptionCallback == null)
      throw new IllegalArgumentException("callback is null"); 
    this.mImpl.subscribe(paramString, null, paramSubscriptionCallback);
  }
  
  public void unsubscribe(@NonNull String paramString) {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("parentId is empty"); 
    this.mImpl.unsubscribe(paramString, null);
  }
  
  public void unsubscribe(@NonNull String paramString, @NonNull SubscriptionCallback paramSubscriptionCallback) {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("parentId is empty"); 
    if (paramSubscriptionCallback == null)
      throw new IllegalArgumentException("callback is null"); 
    this.mImpl.unsubscribe(paramString, paramSubscriptionCallback);
  }
  
  private static class CallbackHandler extends Handler {
    private final WeakReference<MediaBrowserCompat.MediaBrowserServiceCallbackImpl> mCallbackImplRef;
    
    private WeakReference<Messenger> mCallbacksMessengerRef;
    
    CallbackHandler(MediaBrowserCompat.MediaBrowserServiceCallbackImpl param1MediaBrowserServiceCallbackImpl) {
      this.mCallbackImplRef = new WeakReference<MediaBrowserCompat.MediaBrowserServiceCallbackImpl>(param1MediaBrowserServiceCallbackImpl);
    }
    
    public void handleMessage(Message param1Message) {
      if (this.mCallbacksMessengerRef == null || this.mCallbacksMessengerRef.get() == null || this.mCallbackImplRef.get() == null)
        return; 
      Bundle bundle = param1Message.getData();
      bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
      switch (param1Message.what) {
        default:
          Log.w("MediaBrowserCompat", "Unhandled message: " + param1Message + "\n  Client version: " + '\001' + "\n  Service version: " + param1Message.arg1);
          return;
        case 1:
          ((MediaBrowserCompat.MediaBrowserServiceCallbackImpl)this.mCallbackImplRef.get()).onServiceConnected(this.mCallbacksMessengerRef.get(), bundle.getString("data_media_item_id"), (MediaSessionCompat.Token)bundle.getParcelable("data_media_session_token"), bundle.getBundle("data_root_hints"));
          return;
        case 2:
          ((MediaBrowserCompat.MediaBrowserServiceCallbackImpl)this.mCallbackImplRef.get()).onConnectionFailed(this.mCallbacksMessengerRef.get());
          return;
        case 3:
          break;
      } 
      ((MediaBrowserCompat.MediaBrowserServiceCallbackImpl)this.mCallbackImplRef.get()).onLoadChildren(this.mCallbacksMessengerRef.get(), bundle.getString("data_media_item_id"), bundle.getParcelableArrayList("data_media_item_list"), bundle.getBundle("data_options"));
    }
    
    void setCallbacksMessenger(Messenger param1Messenger) {
      this.mCallbacksMessengerRef = new WeakReference<Messenger>(param1Messenger);
    }
  }
  
  public static class ConnectionCallback {
    ConnectionCallbackInternal mConnectionCallbackInternal;
    
    final Object mConnectionCallbackObj;
    
    public ConnectionCallback() {
      if (Build.VERSION.SDK_INT >= 21) {
        this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21());
        return;
      } 
      this.mConnectionCallbackObj = null;
    }
    
    public void onConnected() {}
    
    public void onConnectionFailed() {}
    
    public void onConnectionSuspended() {}
    
    void setInternalConnectionCallback(ConnectionCallbackInternal param1ConnectionCallbackInternal) {
      this.mConnectionCallbackInternal = param1ConnectionCallbackInternal;
    }
    
    static interface ConnectionCallbackInternal {
      void onConnected();
      
      void onConnectionFailed();
      
      void onConnectionSuspended();
    }
    
    private class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
      public void onConnected() {
        if (MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null)
          MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnected(); 
        MediaBrowserCompat.ConnectionCallback.this.onConnected();
      }
      
      public void onConnectionFailed() {
        if (MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null)
          MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnectionFailed(); 
        MediaBrowserCompat.ConnectionCallback.this.onConnectionFailed();
      }
      
      public void onConnectionSuspended() {
        if (MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null)
          MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnectionSuspended(); 
        MediaBrowserCompat.ConnectionCallback.this.onConnectionSuspended();
      }
    }
  }
  
  static interface ConnectionCallbackInternal {
    void onConnected();
    
    void onConnectionFailed();
    
    void onConnectionSuspended();
  }
  
  private class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
    public void onConnected() {
      if (this.this$0.mConnectionCallbackInternal != null)
        this.this$0.mConnectionCallbackInternal.onConnected(); 
      this.this$0.onConnected();
    }
    
    public void onConnectionFailed() {
      if (this.this$0.mConnectionCallbackInternal != null)
        this.this$0.mConnectionCallbackInternal.onConnectionFailed(); 
      this.this$0.onConnectionFailed();
    }
    
    public void onConnectionSuspended() {
      if (this.this$0.mConnectionCallbackInternal != null)
        this.this$0.mConnectionCallbackInternal.onConnectionSuspended(); 
      this.this$0.onConnectionSuspended();
    }
  }
  
  public static abstract class ItemCallback {
    final Object mItemCallbackObj;
    
    public ItemCallback() {
      if (Build.VERSION.SDK_INT >= 23) {
        this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23());
        return;
      } 
      this.mItemCallbackObj = null;
    }
    
    public void onError(@NonNull String param1String) {}
    
    public void onItemLoaded(MediaBrowserCompat.MediaItem param1MediaItem) {}
    
    private class StubApi23 implements MediaBrowserCompatApi23.ItemCallback {
      public void onError(@NonNull String param2String) {
        MediaBrowserCompat.ItemCallback.this.onError(param2String);
      }
      
      public void onItemLoaded(Parcel param2Parcel) {
        if (param2Parcel == null) {
          MediaBrowserCompat.ItemCallback.this.onItemLoaded(null);
          return;
        } 
        param2Parcel.setDataPosition(0);
        MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem)MediaBrowserCompat.MediaItem.CREATOR.createFromParcel(param2Parcel);
        param2Parcel.recycle();
        MediaBrowserCompat.ItemCallback.this.onItemLoaded(mediaItem);
      }
    }
  }
  
  private class StubApi23 implements MediaBrowserCompatApi23.ItemCallback {
    public void onError(@NonNull String param1String) {
      this.this$0.onError(param1String);
    }
    
    public void onItemLoaded(Parcel param1Parcel) {
      if (param1Parcel == null) {
        this.this$0.onItemLoaded(null);
        return;
      } 
      param1Parcel.setDataPosition(0);
      MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem)MediaBrowserCompat.MediaItem.CREATOR.createFromParcel(param1Parcel);
      param1Parcel.recycle();
      this.this$0.onItemLoaded(mediaItem);
    }
  }
  
  private static class ItemReceiver extends ResultReceiver {
    private final MediaBrowserCompat.ItemCallback mCallback;
    
    private final String mMediaId;
    
    ItemReceiver(String param1String, MediaBrowserCompat.ItemCallback param1ItemCallback, Handler param1Handler) {
      super(param1Handler);
      this.mMediaId = param1String;
      this.mCallback = param1ItemCallback;
    }
    
    protected void onReceiveResult(int param1Int, Bundle param1Bundle) {
      if (param1Bundle != null)
        param1Bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader()); 
      if (param1Int != 0 || param1Bundle == null || !param1Bundle.containsKey("media_item")) {
        this.mCallback.onError(this.mMediaId);
        return;
      } 
      Parcelable parcelable = param1Bundle.getParcelable("media_item");
      if (parcelable == null || parcelable instanceof MediaBrowserCompat.MediaItem) {
        this.mCallback.onItemLoaded((MediaBrowserCompat.MediaItem)parcelable);
        return;
      } 
      this.mCallback.onError(this.mMediaId);
    }
  }
  
  static interface MediaBrowserImpl {
    void connect();
    
    void disconnect();
    
    @Nullable
    Bundle getExtras();
    
    void getItem(@NonNull String param1String, @NonNull MediaBrowserCompat.ItemCallback param1ItemCallback);
    
    @NonNull
    String getRoot();
    
    ComponentName getServiceComponent();
    
    @NonNull
    MediaSessionCompat.Token getSessionToken();
    
    boolean isConnected();
    
    void search(@NonNull String param1String, Bundle param1Bundle, @NonNull MediaBrowserCompat.SearchCallback param1SearchCallback);
    
    void subscribe(@NonNull String param1String, Bundle param1Bundle, @NonNull MediaBrowserCompat.SubscriptionCallback param1SubscriptionCallback);
    
    void unsubscribe(@NonNull String param1String, MediaBrowserCompat.SubscriptionCallback param1SubscriptionCallback);
  }
  
  static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
    protected final Object mBrowserObj;
    
    protected Messenger mCallbacksMessenger;
    
    protected final MediaBrowserCompat.CallbackHandler mHandler = new MediaBrowserCompat.CallbackHandler(this);
    
    protected final Bundle mRootHints;
    
    protected MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
    
    private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions = new ArrayMap();
    
    public MediaBrowserImplApi21(Context param1Context, ComponentName param1ComponentName, MediaBrowserCompat.ConnectionCallback param1ConnectionCallback, Bundle param1Bundle) {
      if (Build.VERSION.SDK_INT <= 25) {
        Bundle bundle = param1Bundle;
        if (param1Bundle == null)
          bundle = new Bundle(); 
        bundle.putInt("extra_client_version", 1);
        this.mRootHints = new Bundle(bundle);
      } else {
        if (param1Bundle == null) {
          param1Bundle = null;
        } else {
          param1Bundle = new Bundle(param1Bundle);
        } 
        this.mRootHints = param1Bundle;
      } 
      param1ConnectionCallback.setInternalConnectionCallback(this);
      this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(param1Context, param1ComponentName, param1ConnectionCallback.mConnectionCallbackObj, this.mRootHints);
    }
    
    public void connect() {
      MediaBrowserCompatApi21.connect(this.mBrowserObj);
    }
    
    public void disconnect() {
      if (this.mServiceBinderWrapper != null && this.mCallbacksMessenger != null)
        try {
          this.mServiceBinderWrapper.unregisterCallbackMessenger(this.mCallbacksMessenger);
        } catch (RemoteException remoteException) {
          Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
        }  
      MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
    }
    
    @Nullable
    public Bundle getExtras() {
      return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
    }
    
    public void getItem(@NonNull final String mediaId, @NonNull final MediaBrowserCompat.ItemCallback cb) {
      if (TextUtils.isEmpty(mediaId))
        throw new IllegalArgumentException("mediaId is empty"); 
      if (cb == null)
        throw new IllegalArgumentException("cb is null"); 
      if (!MediaBrowserCompatApi21.isConnected(this.mBrowserObj)) {
        Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
        this.mHandler.post(new Runnable() {
              public void run() {
                cb.onError(mediaId);
              }
            });
        return;
      } 
      if (this.mServiceBinderWrapper == null) {
        this.mHandler.post(new Runnable() {
              public void run() {
                cb.onError(mediaId);
              }
            });
        return;
      } 
      MediaBrowserCompat.ItemReceiver itemReceiver = new MediaBrowserCompat.ItemReceiver(mediaId, cb, this.mHandler);
      try {
        this.mServiceBinderWrapper.getMediaItem(mediaId, itemReceiver, this.mCallbacksMessenger);
        return;
      } catch (RemoteException remoteException) {
        Log.i("MediaBrowserCompat", "Remote error getting media item: " + mediaId);
        this.mHandler.post(new Runnable() {
              public void run() {
                cb.onError(mediaId);
              }
            });
        return;
      } 
    }
    
    @NonNull
    public String getRoot() {
      return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
    }
    
    public ComponentName getServiceComponent() {
      return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
    }
    
    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
      return MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
    }
    
    public boolean isConnected() {
      return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
    }
    
    public void onConnected() {
      Bundle bundle = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
      if (bundle != null) {
        IBinder iBinder = BundleCompat.getBinder(bundle, "extra_messenger");
        if (iBinder != null) {
          this.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(iBinder, this.mRootHints);
          this.mCallbacksMessenger = new Messenger(this.mHandler);
          this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);
          try {
            this.mServiceBinderWrapper.registerCallbackMessenger(this.mCallbacksMessenger);
            return;
          } catch (RemoteException remoteException) {
            Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
            return;
          } 
        } 
      } 
    }
    
    public void onConnectionFailed() {}
    
    public void onConnectionFailed(Messenger param1Messenger) {}
    
    public void onConnectionSuspended() {
      this.mServiceBinderWrapper = null;
      this.mCallbacksMessenger = null;
      this.mHandler.setCallbacksMessenger((Messenger)null);
    }
    
    public void onLoadChildren(Messenger param1Messenger, String param1String, List<MediaBrowserCompat.MediaItem> param1List, Bundle param1Bundle) {
      if (this.mCallbacksMessenger == param1Messenger) {
        MediaBrowserCompat.Subscription subscription = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(param1String);
        if (subscription == null) {
          if (MediaBrowserCompat.DEBUG) {
            Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + param1String);
            return;
          } 
          return;
        } 
        MediaBrowserCompat.SubscriptionCallback subscriptionCallback = subscription.getCallback(param1Bundle);
        if (subscriptionCallback != null) {
          if (param1Bundle == null) {
            if (param1List == null) {
              subscriptionCallback.onError(param1String);
              return;
            } 
            subscriptionCallback.onChildrenLoaded(param1String, param1List);
            return;
          } 
          if (param1List == null) {
            subscriptionCallback.onError(param1String, param1Bundle);
            return;
          } 
          subscriptionCallback.onChildrenLoaded(param1String, param1List, param1Bundle);
          return;
        } 
      } 
    }
    
    public void onServiceConnected(Messenger param1Messenger, String param1String, MediaSessionCompat.Token param1Token, Bundle param1Bundle) {}
    
    public void search(@NonNull final String query, final Bundle extras, @NonNull final MediaBrowserCompat.SearchCallback callback) {
      if (!isConnected()) {
        Log.i("MediaBrowserCompat", "Not connected, unable to search.");
        this.mHandler.post(new Runnable() {
              public void run() {
                callback.onError(query, extras);
              }
            });
        return;
      } 
      if (this.mServiceBinderWrapper == null) {
        Log.i("MediaBrowserCompat", "The connected service doesn't support search.");
        this.mHandler.post(new Runnable() {
              public void run() {
                callback.onError(query, extras);
              }
            });
        return;
      } 
      MediaBrowserCompat.SearchResultReceiver searchResultReceiver = new MediaBrowserCompat.SearchResultReceiver(query, extras, callback, this.mHandler);
      try {
        this.mServiceBinderWrapper.search(query, extras, searchResultReceiver, this.mCallbacksMessenger);
        return;
      } catch (RemoteException remoteException) {
        Log.i("MediaBrowserCompat", "Remote error searching items with query: " + query, (Throwable)remoteException);
        this.mHandler.post(new Runnable() {
              public void run() {
                callback.onError(query, extras);
              }
            });
        return;
      } 
    }
    
    public void subscribe(@NonNull String param1String, Bundle param1Bundle, @NonNull MediaBrowserCompat.SubscriptionCallback param1SubscriptionCallback) {
      MediaBrowserCompat.Subscription subscription2 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(param1String);
      MediaBrowserCompat.Subscription subscription1 = subscription2;
      if (subscription2 == null) {
        subscription1 = new MediaBrowserCompat.Subscription();
        this.mSubscriptions.put(param1String, subscription1);
      } 
      param1SubscriptionCallback.setSubscription(subscription1);
      if (param1Bundle == null) {
        param1Bundle = null;
      } else {
        param1Bundle = new Bundle(param1Bundle);
      } 
      subscription1.putCallback(param1Bundle, param1SubscriptionCallback);
      if (this.mServiceBinderWrapper == null) {
        MediaBrowserCompatApi21.subscribe(this.mBrowserObj, param1String, param1SubscriptionCallback.mSubscriptionCallbackObj);
        return;
      } 
      try {
        this.mServiceBinderWrapper.addSubscription(param1String, param1SubscriptionCallback.mToken, param1Bundle, this.mCallbacksMessenger);
        return;
      } catch (RemoteException remoteException) {
        Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + param1String);
        return;
      } 
    }
    
    public void unsubscribe(@NonNull String param1String, MediaBrowserCompat.SubscriptionCallback param1SubscriptionCallback) {
      // Byte code:
      //   0: aload_0
      //   1: getfield mSubscriptions : Landroid/support/v4/util/ArrayMap;
      //   4: aload_1
      //   5: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   8: checkcast android/support/v4/media/MediaBrowserCompat$Subscription
      //   11: astore #4
      //   13: aload #4
      //   15: ifnonnull -> 19
      //   18: return
      //   19: aload_0
      //   20: getfield mServiceBinderWrapper : Landroid/support/v4/media/MediaBrowserCompat$ServiceBinderWrapper;
      //   23: ifnonnull -> 146
      //   26: aload_2
      //   27: ifnonnull -> 60
      //   30: aload_0
      //   31: getfield mBrowserObj : Ljava/lang/Object;
      //   34: aload_1
      //   35: invokestatic unsubscribe : (Ljava/lang/Object;Ljava/lang/String;)V
      //   38: aload #4
      //   40: invokevirtual isEmpty : ()Z
      //   43: ifne -> 50
      //   46: aload_2
      //   47: ifnonnull -> 18
      //   50: aload_0
      //   51: getfield mSubscriptions : Landroid/support/v4/util/ArrayMap;
      //   54: aload_1
      //   55: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
      //   58: pop
      //   59: return
      //   60: aload #4
      //   62: invokevirtual getCallbacks : ()Ljava/util/List;
      //   65: astore #5
      //   67: aload #4
      //   69: invokevirtual getOptionsList : ()Ljava/util/List;
      //   72: astore #6
      //   74: aload #5
      //   76: invokeinterface size : ()I
      //   81: iconst_1
      //   82: isub
      //   83: istore_3
      //   84: iload_3
      //   85: iflt -> 125
      //   88: aload #5
      //   90: iload_3
      //   91: invokeinterface get : (I)Ljava/lang/Object;
      //   96: aload_2
      //   97: if_acmpne -> 118
      //   100: aload #5
      //   102: iload_3
      //   103: invokeinterface remove : (I)Ljava/lang/Object;
      //   108: pop
      //   109: aload #6
      //   111: iload_3
      //   112: invokeinterface remove : (I)Ljava/lang/Object;
      //   117: pop
      //   118: iload_3
      //   119: iconst_1
      //   120: isub
      //   121: istore_3
      //   122: goto -> 84
      //   125: aload #5
      //   127: invokeinterface size : ()I
      //   132: ifne -> 38
      //   135: aload_0
      //   136: getfield mBrowserObj : Ljava/lang/Object;
      //   139: aload_1
      //   140: invokestatic unsubscribe : (Ljava/lang/Object;Ljava/lang/String;)V
      //   143: goto -> 38
      //   146: aload_2
      //   147: ifnonnull -> 197
      //   150: aload_0
      //   151: getfield mServiceBinderWrapper : Landroid/support/v4/media/MediaBrowserCompat$ServiceBinderWrapper;
      //   154: aload_1
      //   155: aconst_null
      //   156: aload_0
      //   157: getfield mCallbacksMessenger : Landroid/os/Messenger;
      //   160: invokevirtual removeSubscription : (Ljava/lang/String;Landroid/os/IBinder;Landroid/os/Messenger;)V
      //   163: goto -> 38
      //   166: astore #5
      //   168: ldc 'MediaBrowserCompat'
      //   170: new java/lang/StringBuilder
      //   173: dup
      //   174: invokespecial <init> : ()V
      //   177: ldc_w 'removeSubscription failed with RemoteException parentId='
      //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   183: aload_1
      //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   187: invokevirtual toString : ()Ljava/lang/String;
      //   190: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
      //   193: pop
      //   194: goto -> 38
      //   197: aload #4
      //   199: invokevirtual getCallbacks : ()Ljava/util/List;
      //   202: astore #5
      //   204: aload #4
      //   206: invokevirtual getOptionsList : ()Ljava/util/List;
      //   209: astore #6
      //   211: aload #5
      //   213: invokeinterface size : ()I
      //   218: iconst_1
      //   219: isub
      //   220: istore_3
      //   221: iload_3
      //   222: iflt -> 38
      //   225: aload #5
      //   227: iload_3
      //   228: invokeinterface get : (I)Ljava/lang/Object;
      //   233: aload_2
      //   234: if_acmpne -> 271
      //   237: aload_0
      //   238: getfield mServiceBinderWrapper : Landroid/support/v4/media/MediaBrowserCompat$ServiceBinderWrapper;
      //   241: aload_1
      //   242: aload_2
      //   243: invokestatic access$000 : (Landroid/support/v4/media/MediaBrowserCompat$SubscriptionCallback;)Landroid/os/IBinder;
      //   246: aload_0
      //   247: getfield mCallbacksMessenger : Landroid/os/Messenger;
      //   250: invokevirtual removeSubscription : (Ljava/lang/String;Landroid/os/IBinder;Landroid/os/Messenger;)V
      //   253: aload #5
      //   255: iload_3
      //   256: invokeinterface remove : (I)Ljava/lang/Object;
      //   261: pop
      //   262: aload #6
      //   264: iload_3
      //   265: invokeinterface remove : (I)Ljava/lang/Object;
      //   270: pop
      //   271: iload_3
      //   272: iconst_1
      //   273: isub
      //   274: istore_3
      //   275: goto -> 221
      // Exception table:
      //   from	to	target	type
      //   150	163	166	android/os/RemoteException
      //   197	221	166	android/os/RemoteException
      //   225	271	166	android/os/RemoteException
    }
  }
  
  class null implements Runnable {
    public void run() {
      cb.onError(mediaId);
    }
  }
  
  class null implements Runnable {
    public void run() {
      cb.onError(mediaId);
    }
  }
  
  class null implements Runnable {
    public void run() {
      cb.onError(mediaId);
    }
  }
  
  class null implements Runnable {
    public void run() {
      callback.onError(query, extras);
    }
  }
  
  class null implements Runnable {
    public void run() {
      callback.onError(query, extras);
    }
  }
  
  class null implements Runnable {
    public void run() {
      callback.onError(query, extras);
    }
  }
  
  static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
    public MediaBrowserImplApi23(Context param1Context, ComponentName param1ComponentName, MediaBrowserCompat.ConnectionCallback param1ConnectionCallback, Bundle param1Bundle) {
      super(param1Context, param1ComponentName, param1ConnectionCallback, param1Bundle);
    }
    
    public void getItem(@NonNull String param1String, @NonNull MediaBrowserCompat.ItemCallback param1ItemCallback) {
      if (this.mServiceBinderWrapper == null) {
        MediaBrowserCompatApi23.getItem(this.mBrowserObj, param1String, param1ItemCallback.mItemCallbackObj);
        return;
      } 
      super.getItem(param1String, param1ItemCallback);
    }
  }
  
  static class MediaBrowserImplApi24 extends MediaBrowserImplApi23 {
    public MediaBrowserImplApi24(Context param1Context, ComponentName param1ComponentName, MediaBrowserCompat.ConnectionCallback param1ConnectionCallback, Bundle param1Bundle) {
      super(param1Context, param1ComponentName, param1ConnectionCallback, param1Bundle);
    }
    
    public void subscribe(@NonNull String param1String, @NonNull Bundle param1Bundle, @NonNull MediaBrowserCompat.SubscriptionCallback param1SubscriptionCallback) {
      if (param1Bundle == null) {
        MediaBrowserCompatApi21.subscribe(this.mBrowserObj, param1String, param1SubscriptionCallback.mSubscriptionCallbackObj);
        return;
      } 
      MediaBrowserCompatApi24.subscribe(this.mBrowserObj, param1String, param1Bundle, param1SubscriptionCallback.mSubscriptionCallbackObj);
    }
    
    public void unsubscribe(@NonNull String param1String, MediaBrowserCompat.SubscriptionCallback param1SubscriptionCallback) {
      if (param1SubscriptionCallback == null) {
        MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, param1String);
        return;
      } 
      MediaBrowserCompatApi24.unsubscribe(this.mBrowserObj, param1String, param1SubscriptionCallback.mSubscriptionCallbackObj);
    }
  }
  
  static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
    private static final int CONNECT_STATE_CONNECTED = 2;
    
    static final int CONNECT_STATE_CONNECTING = 1;
    
    static final int CONNECT_STATE_DISCONNECTED = 0;
    
    static final int CONNECT_STATE_SUSPENDED = 3;
    
    final MediaBrowserCompat.ConnectionCallback mCallback;
    
    Messenger mCallbacksMessenger;
    
    final Context mContext;
    
    private Bundle mExtras;
    
    final MediaBrowserCompat.CallbackHandler mHandler;
    
    private MediaSessionCompat.Token mMediaSessionToken;
    
    final Bundle mRootHints;
    
    private String mRootId;
    
    MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
    
    final ComponentName mServiceComponent;
    
    MediaServiceConnection mServiceConnection;
    
    int mState;
    
    private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions;
    
    public MediaBrowserImplBase(Context param1Context, ComponentName param1ComponentName, MediaBrowserCompat.ConnectionCallback param1ConnectionCallback, Bundle param1Bundle) {
      Bundle bundle;
      this.mHandler = new MediaBrowserCompat.CallbackHandler(this);
      this.mSubscriptions = new ArrayMap();
      this.mState = 0;
      if (param1Context == null)
        throw new IllegalArgumentException("context must not be null"); 
      if (param1ComponentName == null)
        throw new IllegalArgumentException("service component must not be null"); 
      if (param1ConnectionCallback == null)
        throw new IllegalArgumentException("connection callback must not be null"); 
      this.mContext = param1Context;
      this.mServiceComponent = param1ComponentName;
      this.mCallback = param1ConnectionCallback;
      if (param1Bundle == null) {
        param1Context = null;
      } else {
        bundle = new Bundle(param1Bundle);
      } 
      this.mRootHints = bundle;
    }
    
    private static String getStateLabel(int param1Int) {
      switch (param1Int) {
        default:
          return "UNKNOWN/" + param1Int;
        case 0:
          return "CONNECT_STATE_DISCONNECTED";
        case 1:
          return "CONNECT_STATE_CONNECTING";
        case 2:
          return "CONNECT_STATE_CONNECTED";
        case 3:
          break;
      } 
      return "CONNECT_STATE_SUSPENDED";
    }
    
    private boolean isCurrent(Messenger param1Messenger, String param1String) {
      if (this.mCallbacksMessenger != param1Messenger) {
        if (this.mState != 0)
          Log.i("MediaBrowserCompat", param1String + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this); 
        return false;
      } 
      return true;
    }
    
    public void connect() {
      if (this.mState != 0)
        throw new IllegalStateException("connect() called while not disconnected (state=" + getStateLabel(this.mState) + ")"); 
      if (MediaBrowserCompat.DEBUG && this.mServiceConnection != null)
        throw new RuntimeException("mServiceConnection should be null. Instead it is " + this.mServiceConnection); 
      if (this.mServiceBinderWrapper != null)
        throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.mServiceBinderWrapper); 
      if (this.mCallbacksMessenger != null)
        throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.mCallbacksMessenger); 
      this.mState = 1;
      Intent intent = new Intent("android.media.browse.MediaBrowserService");
      intent.setComponent(this.mServiceComponent);
      final MediaServiceConnection thisConnection = new MediaServiceConnection();
      this.mServiceConnection = mediaServiceConnection;
      boolean bool = false;
      try {
        boolean bool1 = this.mContext.bindService(intent, this.mServiceConnection, 1);
        bool = bool1;
      } catch (Exception exception) {
        Log.e("MediaBrowserCompat", "Failed binding to service " + this.mServiceComponent);
      } 
      if (!bool)
        this.mHandler.post(new Runnable() {
              public void run() {
                if (thisConnection == MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection) {
                  MediaBrowserCompat.MediaBrowserImplBase.this.forceCloseConnection();
                  MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                } 
              }
            }); 
      if (MediaBrowserCompat.DEBUG) {
        Log.d("MediaBrowserCompat", "connect...");
        dump();
      } 
    }
    
    public void disconnect() {
      if (this.mCallbacksMessenger != null)
        try {
          this.mServiceBinderWrapper.disconnect(this.mCallbacksMessenger);
        } catch (RemoteException remoteException) {
          Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.mServiceComponent);
        }  
      forceCloseConnection();
      if (MediaBrowserCompat.DEBUG) {
        Log.d("MediaBrowserCompat", "disconnect...");
        dump();
      } 
    }
    
    void dump() {
      Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
      Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.mServiceComponent);
      Log.d("MediaBrowserCompat", "  mCallback=" + this.mCallback);
      Log.d("MediaBrowserCompat", "  mRootHints=" + this.mRootHints);
      Log.d("MediaBrowserCompat", "  mState=" + getStateLabel(this.mState));
      Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.mServiceConnection);
      Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
      Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.mCallbacksMessenger);
      Log.d("MediaBrowserCompat", "  mRootId=" + this.mRootId);
      Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.mMediaSessionToken);
    }
    
    void forceCloseConnection() {
      if (this.mServiceConnection != null)
        this.mContext.unbindService(this.mServiceConnection); 
      this.mState = 0;
      this.mServiceConnection = null;
      this.mServiceBinderWrapper = null;
      this.mCallbacksMessenger = null;
      this.mHandler.setCallbacksMessenger((Messenger)null);
      this.mRootId = null;
      this.mMediaSessionToken = null;
    }
    
    @Nullable
    public Bundle getExtras() {
      if (!isConnected())
        throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")"); 
      return this.mExtras;
    }
    
    public void getItem(@NonNull final String mediaId, @NonNull final MediaBrowserCompat.ItemCallback cb) {
      if (TextUtils.isEmpty(mediaId))
        throw new IllegalArgumentException("mediaId is empty"); 
      if (cb == null)
        throw new IllegalArgumentException("cb is null"); 
      if (this.mState != 2) {
        Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
        this.mHandler.post(new Runnable() {
              public void run() {
                cb.onError(mediaId);
              }
            });
        return;
      } 
      MediaBrowserCompat.ItemReceiver itemReceiver = new MediaBrowserCompat.ItemReceiver(mediaId, cb, this.mHandler);
      try {
        this.mServiceBinderWrapper.getMediaItem(mediaId, itemReceiver, this.mCallbacksMessenger);
        return;
      } catch (RemoteException remoteException) {
        Log.i("MediaBrowserCompat", "Remote error getting media item.");
        this.mHandler.post(new Runnable() {
              public void run() {
                cb.onError(mediaId);
              }
            });
        return;
      } 
    }
    
    @NonNull
    public String getRoot() {
      if (!isConnected())
        throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")"); 
      return this.mRootId;
    }
    
    @NonNull
    public ComponentName getServiceComponent() {
      if (!isConnected())
        throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")"); 
      return this.mServiceComponent;
    }
    
    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
      if (!isConnected())
        throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")"); 
      return this.mMediaSessionToken;
    }
    
    public boolean isConnected() {
      return (this.mState == 2);
    }
    
    public void onConnectionFailed(Messenger param1Messenger) {
      Log.e("MediaBrowserCompat", "onConnectFailed for " + this.mServiceComponent);
      if (!isCurrent(param1Messenger, "onConnectFailed"))
        return; 
      if (this.mState != 1) {
        Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
        return;
      } 
      forceCloseConnection();
      this.mCallback.onConnectionFailed();
    }
    
    public void onLoadChildren(Messenger param1Messenger, String param1String, List<MediaBrowserCompat.MediaItem> param1List, Bundle param1Bundle) {
      if (isCurrent(param1Messenger, "onLoadChildren")) {
        if (MediaBrowserCompat.DEBUG)
          Log.d("MediaBrowserCompat", "onLoadChildren for " + this.mServiceComponent + " id=" + param1String); 
        MediaBrowserCompat.Subscription subscription = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(param1String);
        if (subscription == null) {
          if (MediaBrowserCompat.DEBUG) {
            Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + param1String);
            return;
          } 
          return;
        } 
        MediaBrowserCompat.SubscriptionCallback subscriptionCallback = subscription.getCallback(param1Bundle);
        if (subscriptionCallback != null) {
          if (param1Bundle == null) {
            if (param1List == null) {
              subscriptionCallback.onError(param1String);
              return;
            } 
            subscriptionCallback.onChildrenLoaded(param1String, param1List);
            return;
          } 
          if (param1List == null) {
            subscriptionCallback.onError(param1String, param1Bundle);
            return;
          } 
          subscriptionCallback.onChildrenLoaded(param1String, param1List, param1Bundle);
          return;
        } 
      } 
    }
    
    public void onServiceConnected(Messenger param1Messenger, String param1String, MediaSessionCompat.Token param1Token, Bundle param1Bundle) {
      if (isCurrent(param1Messenger, "onConnect")) {
        if (this.mState != 1) {
          Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
          return;
        } 
        this.mRootId = param1String;
        this.mMediaSessionToken = param1Token;
        this.mExtras = param1Bundle;
        this.mState = 2;
        if (MediaBrowserCompat.DEBUG) {
          Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
          dump();
        } 
        this.mCallback.onConnected();
        try {
          Iterator<Map.Entry> iterator = this.mSubscriptions.entrySet().iterator();
          while (true) {
            if (iterator.hasNext()) {
              Map.Entry entry = iterator.next();
              param1String = (String)entry.getKey();
              MediaBrowserCompat.Subscription subscription = (MediaBrowserCompat.Subscription)entry.getValue();
              List<MediaBrowserCompat.SubscriptionCallback> list = subscription.getCallbacks();
              List<Bundle> list1 = subscription.getOptionsList();
              int i;
              for (i = 0; i < list.size(); i++)
                this.mServiceBinderWrapper.addSubscription(param1String, (list.get(i)).mToken, list1.get(i), this.mCallbacksMessenger); 
              continue;
            } 
            return;
          } 
        } catch (RemoteException remoteException) {
          Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
          return;
        } 
      } 
    }
    
    public void search(@NonNull final String query, final Bundle extras, @NonNull final MediaBrowserCompat.SearchCallback callback) {
      if (!isConnected()) {
        Log.i("MediaBrowserCompat", "Not connected, unable to search.");
        this.mHandler.post(new Runnable() {
              public void run() {
                callback.onError(query, extras);
              }
            });
        return;
      } 
      MediaBrowserCompat.SearchResultReceiver searchResultReceiver = new MediaBrowserCompat.SearchResultReceiver(query, extras, callback, this.mHandler);
      try {
        this.mServiceBinderWrapper.search(query, extras, searchResultReceiver, this.mCallbacksMessenger);
        return;
      } catch (RemoteException remoteException) {
        Log.i("MediaBrowserCompat", "Remote error searching items with query: " + query, (Throwable)remoteException);
        this.mHandler.post(new Runnable() {
              public void run() {
                callback.onError(query, extras);
              }
            });
        return;
      } 
    }
    
    public void subscribe(@NonNull String param1String, Bundle param1Bundle, @NonNull MediaBrowserCompat.SubscriptionCallback param1SubscriptionCallback) {
      MediaBrowserCompat.Subscription subscription2 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(param1String);
      MediaBrowserCompat.Subscription subscription1 = subscription2;
      if (subscription2 == null) {
        subscription1 = new MediaBrowserCompat.Subscription();
        this.mSubscriptions.put(param1String, subscription1);
      } 
      if (param1Bundle == null) {
        param1Bundle = null;
      } else {
        param1Bundle = new Bundle(param1Bundle);
      } 
      subscription1.putCallback(param1Bundle, param1SubscriptionCallback);
      if (this.mState == 2)
        try {
          this.mServiceBinderWrapper.addSubscription(param1String, param1SubscriptionCallback.mToken, param1Bundle, this.mCallbacksMessenger);
          return;
        } catch (RemoteException remoteException) {
          Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + param1String);
          return;
        }  
    }
    
    public void unsubscribe(@NonNull String param1String, MediaBrowserCompat.SubscriptionCallback param1SubscriptionCallback) {
      // Byte code:
      //   0: aload_0
      //   1: getfield mSubscriptions : Landroid/support/v4/util/ArrayMap;
      //   4: aload_1
      //   5: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   8: checkcast android/support/v4/media/MediaBrowserCompat$Subscription
      //   11: astore #4
      //   13: aload #4
      //   15: ifnonnull -> 19
      //   18: return
      //   19: aload_2
      //   20: ifnonnull -> 66
      //   23: aload_0
      //   24: getfield mState : I
      //   27: iconst_2
      //   28: if_icmpne -> 44
      //   31: aload_0
      //   32: getfield mServiceBinderWrapper : Landroid/support/v4/media/MediaBrowserCompat$ServiceBinderWrapper;
      //   35: aload_1
      //   36: aconst_null
      //   37: aload_0
      //   38: getfield mCallbacksMessenger : Landroid/os/Messenger;
      //   41: invokevirtual removeSubscription : (Ljava/lang/String;Landroid/os/IBinder;Landroid/os/Messenger;)V
      //   44: aload #4
      //   46: invokevirtual isEmpty : ()Z
      //   49: ifne -> 56
      //   52: aload_2
      //   53: ifnonnull -> 18
      //   56: aload_0
      //   57: getfield mSubscriptions : Landroid/support/v4/util/ArrayMap;
      //   60: aload_1
      //   61: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
      //   64: pop
      //   65: return
      //   66: aload #4
      //   68: invokevirtual getCallbacks : ()Ljava/util/List;
      //   71: astore #5
      //   73: aload #4
      //   75: invokevirtual getOptionsList : ()Ljava/util/List;
      //   78: astore #6
      //   80: aload #5
      //   82: invokeinterface size : ()I
      //   87: iconst_1
      //   88: isub
      //   89: istore_3
      //   90: iload_3
      //   91: iflt -> 44
      //   94: aload #5
      //   96: iload_3
      //   97: invokeinterface get : (I)Ljava/lang/Object;
      //   102: aload_2
      //   103: if_acmpne -> 148
      //   106: aload_0
      //   107: getfield mState : I
      //   110: iconst_2
      //   111: if_icmpne -> 130
      //   114: aload_0
      //   115: getfield mServiceBinderWrapper : Landroid/support/v4/media/MediaBrowserCompat$ServiceBinderWrapper;
      //   118: aload_1
      //   119: aload_2
      //   120: invokestatic access$000 : (Landroid/support/v4/media/MediaBrowserCompat$SubscriptionCallback;)Landroid/os/IBinder;
      //   123: aload_0
      //   124: getfield mCallbacksMessenger : Landroid/os/Messenger;
      //   127: invokevirtual removeSubscription : (Ljava/lang/String;Landroid/os/IBinder;Landroid/os/Messenger;)V
      //   130: aload #5
      //   132: iload_3
      //   133: invokeinterface remove : (I)Ljava/lang/Object;
      //   138: pop
      //   139: aload #6
      //   141: iload_3
      //   142: invokeinterface remove : (I)Ljava/lang/Object;
      //   147: pop
      //   148: iload_3
      //   149: iconst_1
      //   150: isub
      //   151: istore_3
      //   152: goto -> 90
      //   155: astore #5
      //   157: ldc 'MediaBrowserCompat'
      //   159: new java/lang/StringBuilder
      //   162: dup
      //   163: invokespecial <init> : ()V
      //   166: ldc_w 'removeSubscription failed with RemoteException parentId='
      //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   172: aload_1
      //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   176: invokevirtual toString : ()Ljava/lang/String;
      //   179: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
      //   182: pop
      //   183: goto -> 44
      // Exception table:
      //   from	to	target	type
      //   23	44	155	android/os/RemoteException
      //   66	90	155	android/os/RemoteException
      //   94	130	155	android/os/RemoteException
      //   130	148	155	android/os/RemoteException
    }
    
    private class MediaServiceConnection implements ServiceConnection {
      private void postOrRun(Runnable param2Runnable) {
        if (Thread.currentThread() == MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
          param2Runnable.run();
          return;
        } 
        MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.post(param2Runnable);
      }
      
      boolean isCurrent(String param2String) {
        if (MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection != this) {
          if (MediaBrowserCompat.MediaBrowserImplBase.this.mState != 0)
            Log.i("MediaBrowserCompat", param2String + " for " + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection + " this=" + this); 
          return false;
        } 
        return true;
      }
      
      public void onServiceConnected(final ComponentName name, final IBinder binder) {
        postOrRun(new Runnable() {
              public void run() {
                if (MediaBrowserCompat.DEBUG) {
                  Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + name + " binder=" + binder);
                  MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                } 
                if (MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                  MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(binder, MediaBrowserCompat.MediaBrowserImplBase.this.mRootHints);
                  MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserCompat.MediaBrowserImplBase.this.mHandler);
                  MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                  MediaBrowserCompat.MediaBrowserImplBase.this.mState = 1;
                  try {
                    if (MediaBrowserCompat.DEBUG) {
                      Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                      MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                    } 
                    MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper.connect(MediaBrowserCompat.MediaBrowserImplBase.this.mContext, MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                    return;
                  } catch (RemoteException remoteException) {
                    Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                  } 
                } 
              }
            });
      }
      
      public void onServiceDisconnected(final ComponentName name) {
        postOrRun(new Runnable() {
              public void run() {
                if (MediaBrowserCompat.DEBUG) {
                  Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + name + " this=" + this + " mServiceConnection=" + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
                  MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                } 
                if (!MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceDisconnected"))
                  return; 
                MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper = null;
                MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = null;
                MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.setCallbacksMessenger((Messenger)null);
                MediaBrowserCompat.MediaBrowserImplBase.this.mState = 3;
                MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
              }
            });
      }
    }
    
    class null implements Runnable {
      public void run() {
        if (MediaBrowserCompat.DEBUG) {
          Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + name + " binder=" + binder);
          MediaBrowserCompat.MediaBrowserImplBase.this.dump();
        } 
        if (this.this$1.isCurrent("onServiceConnected")) {
          MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(binder, MediaBrowserCompat.MediaBrowserImplBase.this.mRootHints);
          MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserCompat.MediaBrowserImplBase.this.mHandler);
          MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
          MediaBrowserCompat.MediaBrowserImplBase.this.mState = 1;
          try {
            if (MediaBrowserCompat.DEBUG) {
              Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
              MediaBrowserCompat.MediaBrowserImplBase.this.dump();
            } 
            MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper.connect(MediaBrowserCompat.MediaBrowserImplBase.this.mContext, MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
            return;
          } catch (RemoteException remoteException) {
            Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
          } 
        } 
      }
    }
    
    class null implements Runnable {
      public void run() {
        if (MediaBrowserCompat.DEBUG) {
          Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + name + " this=" + this + " mServiceConnection=" + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
          MediaBrowserCompat.MediaBrowserImplBase.this.dump();
        } 
        if (!this.this$1.isCurrent("onServiceDisconnected"))
          return; 
        MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper = null;
        MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = null;
        MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.setCallbacksMessenger((Messenger)null);
        MediaBrowserCompat.MediaBrowserImplBase.this.mState = 3;
        MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
      }
    }
  }
  
  class null implements Runnable {
    public void run() {
      if (thisConnection == this.this$0.mServiceConnection) {
        this.this$0.forceCloseConnection();
        this.this$0.mCallback.onConnectionFailed();
      } 
    }
  }
  
  class null implements Runnable {
    public void run() {
      cb.onError(mediaId);
    }
  }
  
  class null implements Runnable {
    public void run() {
      cb.onError(mediaId);
    }
  }
  
  class null implements Runnable {
    public void run() {
      callback.onError(query, extras);
    }
  }
  
  class null implements Runnable {
    public void run() {
      callback.onError(query, extras);
    }
  }
  
  private class MediaServiceConnection implements ServiceConnection {
    private void postOrRun(Runnable param1Runnable) {
      if (Thread.currentThread() == this.this$0.mHandler.getLooper().getThread()) {
        param1Runnable.run();
        return;
      } 
      this.this$0.mHandler.post(param1Runnable);
    }
    
    boolean isCurrent(String param1String) {
      if (this.this$0.mServiceConnection != this) {
        if (this.this$0.mState != 0)
          Log.i("MediaBrowserCompat", param1String + " for " + this.this$0.mServiceComponent + " with mServiceConnection=" + this.this$0.mServiceConnection + " this=" + this); 
        return false;
      } 
      return true;
    }
    
    public void onServiceConnected(final ComponentName name, final IBinder binder) {
      postOrRun(new Runnable() {
            public void run() {
              if (MediaBrowserCompat.DEBUG) {
                Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + name + " binder=" + binder);
                this.this$1.this$0.dump();
              } 
              if (MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                this.this$1.this$0.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(binder, this.this$1.this$0.mRootHints);
                this.this$1.this$0.mCallbacksMessenger = new Messenger(this.this$1.this$0.mHandler);
                this.this$1.this$0.mHandler.setCallbacksMessenger(this.this$1.this$0.mCallbacksMessenger);
                this.this$1.this$0.mState = 1;
                try {
                  if (MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    this.this$1.this$0.dump();
                  } 
                  this.this$1.this$0.mServiceBinderWrapper.connect(this.this$1.this$0.mContext, this.this$1.this$0.mCallbacksMessenger);
                  return;
                } catch (RemoteException remoteException) {
                  Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.this$1.this$0.mServiceComponent);
                } 
              } 
            }
          });
    }
    
    public void onServiceDisconnected(final ComponentName name) {
      postOrRun(new Runnable() {
            public void run() {
              if (MediaBrowserCompat.DEBUG) {
                Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + name + " this=" + this + " mServiceConnection=" + this.this$1.this$0.mServiceConnection);
                this.this$1.this$0.dump();
              } 
              if (!MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceDisconnected"))
                return; 
              this.this$1.this$0.mServiceBinderWrapper = null;
              this.this$1.this$0.mCallbacksMessenger = null;
              this.this$1.this$0.mHandler.setCallbacksMessenger((Messenger)null);
              this.this$1.this$0.mState = 3;
              this.this$1.this$0.mCallback.onConnectionSuspended();
            }
          });
    }
  }
  
  class null implements Runnable {
    public void run() {
      if (MediaBrowserCompat.DEBUG) {
        Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + name + " binder=" + binder);
        this.this$1.this$0.dump();
      } 
      if (this.this$1.isCurrent("onServiceConnected")) {
        this.this$1.this$0.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(binder, this.this$1.this$0.mRootHints);
        this.this$1.this$0.mCallbacksMessenger = new Messenger(this.this$1.this$0.mHandler);
        this.this$1.this$0.mHandler.setCallbacksMessenger(this.this$1.this$0.mCallbacksMessenger);
        this.this$1.this$0.mState = 1;
        try {
          if (MediaBrowserCompat.DEBUG) {
            Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
            this.this$1.this$0.dump();
          } 
          this.this$1.this$0.mServiceBinderWrapper.connect(this.this$1.this$0.mContext, this.this$1.this$0.mCallbacksMessenger);
          return;
        } catch (RemoteException remoteException) {
          Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.this$1.this$0.mServiceComponent);
        } 
      } 
    }
  }
  
  class null implements Runnable {
    public void run() {
      if (MediaBrowserCompat.DEBUG) {
        Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + name + " this=" + this + " mServiceConnection=" + this.this$1.this$0.mServiceConnection);
        this.this$1.this$0.dump();
      } 
      if (!this.this$1.isCurrent("onServiceDisconnected"))
        return; 
      this.this$1.this$0.mServiceBinderWrapper = null;
      this.this$1.this$0.mCallbacksMessenger = null;
      this.this$1.this$0.mHandler.setCallbacksMessenger((Messenger)null);
      this.this$1.this$0.mState = 3;
      this.this$1.this$0.mCallback.onConnectionSuspended();
    }
  }
  
  static interface MediaBrowserServiceCallbackImpl {
    void onConnectionFailed(Messenger param1Messenger);
    
    void onLoadChildren(Messenger param1Messenger, String param1String, List param1List, Bundle param1Bundle);
    
    void onServiceConnected(Messenger param1Messenger, String param1String, MediaSessionCompat.Token param1Token, Bundle param1Bundle);
  }
  
  public static class MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
        public MediaBrowserCompat.MediaItem createFromParcel(Parcel param2Parcel) {
          return new MediaBrowserCompat.MediaItem(param2Parcel);
        }
        
        public MediaBrowserCompat.MediaItem[] newArray(int param2Int) {
          return new MediaBrowserCompat.MediaItem[param2Int];
        }
      };
    
    public static final int FLAG_BROWSABLE = 1;
    
    public static final int FLAG_PLAYABLE = 2;
    
    private final MediaDescriptionCompat mDescription;
    
    private final int mFlags;
    
    MediaItem(Parcel param1Parcel) {
      this.mFlags = param1Parcel.readInt();
      this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(param1Parcel);
    }
    
    public MediaItem(@NonNull MediaDescriptionCompat param1MediaDescriptionCompat, int param1Int) {
      if (param1MediaDescriptionCompat == null)
        throw new IllegalArgumentException("description cannot be null"); 
      if (TextUtils.isEmpty(param1MediaDescriptionCompat.getMediaId()))
        throw new IllegalArgumentException("description must have a non-empty media id"); 
      this.mFlags = param1Int;
      this.mDescription = param1MediaDescriptionCompat;
    }
    
    public static MediaItem fromMediaItem(Object param1Object) {
      if (param1Object == null || Build.VERSION.SDK_INT < 21)
        return null; 
      int i = MediaBrowserCompatApi21.MediaItem.getFlags(param1Object);
      return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaBrowserCompatApi21.MediaItem.getDescription(param1Object)), i);
    }
    
    public static List<MediaItem> fromMediaItemList(List<?> param1List) {
      if (param1List == null || Build.VERSION.SDK_INT < 21)
        return null; 
      ArrayList<?> arrayList = new ArrayList(param1List.size());
      Iterator<?> iterator = param1List.iterator();
      while (true) {
        param1List = arrayList;
        if (iterator.hasNext()) {
          arrayList.add(fromMediaItem(iterator.next()));
          continue;
        } 
        return (List)param1List;
      } 
    }
    
    public int describeContents() {
      return 0;
    }
    
    @NonNull
    public MediaDescriptionCompat getDescription() {
      return this.mDescription;
    }
    
    public int getFlags() {
      return this.mFlags;
    }
    
    @Nullable
    public String getMediaId() {
      return this.mDescription.getMediaId();
    }
    
    public boolean isBrowsable() {
      return ((this.mFlags & 0x1) != 0);
    }
    
    public boolean isPlayable() {
      return ((this.mFlags & 0x2) != 0);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("MediaItem{");
      stringBuilder.append("mFlags=").append(this.mFlags);
      stringBuilder.append(", mDescription=").append(this.mDescription);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.mFlags);
      this.mDescription.writeToParcel(param1Parcel, param1Int);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static @interface Flags {}
  }
  
  static final class null implements Parcelable.Creator<MediaItem> {
    public MediaBrowserCompat.MediaItem createFromParcel(Parcel param1Parcel) {
      return new MediaBrowserCompat.MediaItem(param1Parcel);
    }
    
    public MediaBrowserCompat.MediaItem[] newArray(int param1Int) {
      return new MediaBrowserCompat.MediaItem[param1Int];
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface Flags {}
  
  public static abstract class SearchCallback {
    public void onError(@NonNull String param1String, Bundle param1Bundle) {}
    
    public void onSearchResult(@NonNull String param1String, Bundle param1Bundle, @NonNull List<MediaBrowserCompat.MediaItem> param1List) {}
  }
  
  private static class SearchResultReceiver extends ResultReceiver {
    private final MediaBrowserCompat.SearchCallback mCallback;
    
    private final Bundle mExtras;
    
    private final String mQuery;
    
    SearchResultReceiver(String param1String, Bundle param1Bundle, MediaBrowserCompat.SearchCallback param1SearchCallback, Handler param1Handler) {
      super(param1Handler);
      this.mQuery = param1String;
      this.mExtras = param1Bundle;
      this.mCallback = param1SearchCallback;
    }
    
    protected void onReceiveResult(int param1Int, Bundle param1Bundle) {
      ArrayList<MediaBrowserCompat.MediaItem> arrayList;
      if (param1Int != 0 || param1Bundle == null || !param1Bundle.containsKey("search_results")) {
        this.mCallback.onError(this.mQuery, this.mExtras);
        return;
      } 
      Parcelable[] arrayOfParcelable = param1Bundle.getParcelableArray("search_results");
      param1Bundle = null;
      if (arrayOfParcelable != null) {
        ArrayList<MediaBrowserCompat.MediaItem> arrayList1 = new ArrayList();
        int i = arrayOfParcelable.length;
        param1Int = 0;
        while (true) {
          arrayList = arrayList1;
          if (param1Int < i) {
            arrayList1.add((MediaBrowserCompat.MediaItem)arrayOfParcelable[param1Int]);
            param1Int++;
            continue;
          } 
          break;
        } 
      } 
      this.mCallback.onSearchResult(this.mQuery, this.mExtras, arrayList);
    }
  }
  
  private static class ServiceBinderWrapper {
    private Messenger mMessenger;
    
    private Bundle mRootHints;
    
    public ServiceBinderWrapper(IBinder param1IBinder, Bundle param1Bundle) {
      this.mMessenger = new Messenger(param1IBinder);
      this.mRootHints = param1Bundle;
    }
    
    private void sendRequest(int param1Int, Bundle param1Bundle, Messenger param1Messenger) throws RemoteException {
      Message message = Message.obtain();
      message.what = param1Int;
      message.arg1 = 1;
      message.setData(param1Bundle);
      message.replyTo = param1Messenger;
      this.mMessenger.send(message);
    }
    
    void addSubscription(String param1String, IBinder param1IBinder, Bundle param1Bundle, Messenger param1Messenger) throws RemoteException {
      Bundle bundle = new Bundle();
      bundle.putString("data_media_item_id", param1String);
      BundleCompat.putBinder(bundle, "data_callback_token", param1IBinder);
      bundle.putBundle("data_options", param1Bundle);
      sendRequest(3, bundle, param1Messenger);
    }
    
    void connect(Context param1Context, Messenger param1Messenger) throws RemoteException {
      Bundle bundle = new Bundle();
      bundle.putString("data_package_name", param1Context.getPackageName());
      bundle.putBundle("data_root_hints", this.mRootHints);
      sendRequest(1, bundle, param1Messenger);
    }
    
    void disconnect(Messenger param1Messenger) throws RemoteException {
      sendRequest(2, null, param1Messenger);
    }
    
    void getMediaItem(String param1String, ResultReceiver param1ResultReceiver, Messenger param1Messenger) throws RemoteException {
      Bundle bundle = new Bundle();
      bundle.putString("data_media_item_id", param1String);
      bundle.putParcelable("data_result_receiver", (Parcelable)param1ResultReceiver);
      sendRequest(5, bundle, param1Messenger);
    }
    
    void registerCallbackMessenger(Messenger param1Messenger) throws RemoteException {
      Bundle bundle = new Bundle();
      bundle.putBundle("data_root_hints", this.mRootHints);
      sendRequest(6, bundle, param1Messenger);
    }
    
    void removeSubscription(String param1String, IBinder param1IBinder, Messenger param1Messenger) throws RemoteException {
      Bundle bundle = new Bundle();
      bundle.putString("data_media_item_id", param1String);
      BundleCompat.putBinder(bundle, "data_callback_token", param1IBinder);
      sendRequest(4, bundle, param1Messenger);
    }
    
    void search(String param1String, Bundle param1Bundle, ResultReceiver param1ResultReceiver, Messenger param1Messenger) throws RemoteException {
      Bundle bundle = new Bundle();
      bundle.putString("data_search_query", param1String);
      bundle.putBundle("data_search_extras", param1Bundle);
      bundle.putParcelable("data_result_receiver", (Parcelable)param1ResultReceiver);
      sendRequest(8, bundle, param1Messenger);
    }
    
    void unregisterCallbackMessenger(Messenger param1Messenger) throws RemoteException {
      sendRequest(7, null, param1Messenger);
    }
  }
  
  private static class Subscription {
    private final List<MediaBrowserCompat.SubscriptionCallback> mCallbacks = new ArrayList<MediaBrowserCompat.SubscriptionCallback>();
    
    private final List<Bundle> mOptionsList = new ArrayList<Bundle>();
    
    public MediaBrowserCompat.SubscriptionCallback getCallback(Bundle param1Bundle) {
      for (int i = 0; i < this.mOptionsList.size(); i++) {
        if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), param1Bundle))
          return this.mCallbacks.get(i); 
      } 
      return null;
    }
    
    public List<MediaBrowserCompat.SubscriptionCallback> getCallbacks() {
      return this.mCallbacks;
    }
    
    public List<Bundle> getOptionsList() {
      return this.mOptionsList;
    }
    
    public boolean isEmpty() {
      return this.mCallbacks.isEmpty();
    }
    
    public void putCallback(Bundle param1Bundle, MediaBrowserCompat.SubscriptionCallback param1SubscriptionCallback) {
      for (int i = 0; i < this.mOptionsList.size(); i++) {
        if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), param1Bundle)) {
          this.mCallbacks.set(i, param1SubscriptionCallback);
          return;
        } 
      } 
      this.mCallbacks.add(param1SubscriptionCallback);
      this.mOptionsList.add(param1Bundle);
    }
  }
  
  public static abstract class SubscriptionCallback {
    private final Object mSubscriptionCallbackObj;
    
    WeakReference<MediaBrowserCompat.Subscription> mSubscriptionRef;
    
    private final IBinder mToken;
    
    public SubscriptionCallback() {
      if (Build.VERSION.SDK_INT >= 26 || BuildCompat.isAtLeastO()) {
        this.mSubscriptionCallbackObj = MediaBrowserCompatApi24.createSubscriptionCallback(new StubApi24());
        this.mToken = null;
        return;
      } 
      if (Build.VERSION.SDK_INT >= 21) {
        this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new StubApi21());
        this.mToken = (IBinder)new Binder();
        return;
      } 
      this.mSubscriptionCallbackObj = null;
      this.mToken = (IBinder)new Binder();
    }
    
    private void setSubscription(MediaBrowserCompat.Subscription param1Subscription) {
      this.mSubscriptionRef = new WeakReference<MediaBrowserCompat.Subscription>(param1Subscription);
    }
    
    public void onChildrenLoaded(@NonNull String param1String, @NonNull List<MediaBrowserCompat.MediaItem> param1List) {}
    
    public void onChildrenLoaded(@NonNull String param1String, @NonNull List<MediaBrowserCompat.MediaItem> param1List, @NonNull Bundle param1Bundle) {}
    
    public void onError(@NonNull String param1String) {}
    
    public void onError(@NonNull String param1String, @NonNull Bundle param1Bundle) {}
    
    private class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {
      List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> param2List, Bundle param2Bundle) {
        // Byte code:
        //   0: aload_1
        //   1: ifnonnull -> 8
        //   4: aconst_null
        //   5: astore_2
        //   6: aload_2
        //   7: areturn
        //   8: aload_2
        //   9: ldc 'android.media.browse.extra.PAGE'
        //   11: iconst_m1
        //   12: invokevirtual getInt : (Ljava/lang/String;I)I
        //   15: istore_3
        //   16: aload_2
        //   17: ldc 'android.media.browse.extra.PAGE_SIZE'
        //   19: iconst_m1
        //   20: invokevirtual getInt : (Ljava/lang/String;I)I
        //   23: istore #6
        //   25: iload_3
        //   26: iconst_m1
        //   27: if_icmpne -> 38
        //   30: aload_1
        //   31: astore_2
        //   32: iload #6
        //   34: iconst_m1
        //   35: if_icmpeq -> 6
        //   38: iload #6
        //   40: iload_3
        //   41: imul
        //   42: istore #5
        //   44: iload #5
        //   46: iload #6
        //   48: iadd
        //   49: istore #4
        //   51: iload_3
        //   52: iflt -> 72
        //   55: iload #6
        //   57: iconst_1
        //   58: if_icmplt -> 72
        //   61: iload #5
        //   63: aload_1
        //   64: invokeinterface size : ()I
        //   69: if_icmplt -> 76
        //   72: getstatic java/util/Collections.EMPTY_LIST : Ljava/util/List;
        //   75: areturn
        //   76: iload #4
        //   78: istore_3
        //   79: iload #4
        //   81: aload_1
        //   82: invokeinterface size : ()I
        //   87: if_icmple -> 97
        //   90: aload_1
        //   91: invokeinterface size : ()I
        //   96: istore_3
        //   97: aload_1
        //   98: iload #5
        //   100: iload_3
        //   101: invokeinterface subList : (II)Ljava/util/List;
        //   106: areturn
      }
      
      public void onChildrenLoaded(@NonNull String param2String, List<?> param2List) {
        MediaBrowserCompat.Subscription subscription;
        if (MediaBrowserCompat.SubscriptionCallback.this.mSubscriptionRef == null) {
          subscription = null;
        } else {
          subscription = MediaBrowserCompat.SubscriptionCallback.this.mSubscriptionRef.get();
        } 
        if (subscription == null) {
          MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(param2String, MediaBrowserCompat.MediaItem.fromMediaItemList(param2List));
          return;
        } 
        param2List = MediaBrowserCompat.MediaItem.fromMediaItemList(param2List);
        List<MediaBrowserCompat.SubscriptionCallback> list1 = subscription.getCallbacks();
        List<Bundle> list = subscription.getOptionsList();
        int i = 0;
        while (true) {
          if (i < list1.size()) {
            Bundle bundle = list.get(i);
            if (bundle == null) {
              MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(param2String, (List)param2List);
            } else {
              MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(param2String, applyOptions((List)param2List, bundle), bundle);
            } 
            i++;
            continue;
          } 
          return;
        } 
      }
      
      public void onError(@NonNull String param2String) {
        MediaBrowserCompat.SubscriptionCallback.this.onError(param2String);
      }
    }
    
    private class StubApi24 extends StubApi21 implements MediaBrowserCompatApi24.SubscriptionCallback {
      public void onChildrenLoaded(@NonNull String param2String, List<?> param2List, @NonNull Bundle param2Bundle) {
        MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(param2String, MediaBrowserCompat.MediaItem.fromMediaItemList(param2List), param2Bundle);
      }
      
      public void onError(@NonNull String param2String, @NonNull Bundle param2Bundle) {
        MediaBrowserCompat.SubscriptionCallback.this.onError(param2String, param2Bundle);
      }
    }
  }
  
  private class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {
    List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> param1List, Bundle param1Bundle) {
      // Byte code:
      //   0: aload_1
      //   1: ifnonnull -> 8
      //   4: aconst_null
      //   5: astore_2
      //   6: aload_2
      //   7: areturn
      //   8: aload_2
      //   9: ldc 'android.media.browse.extra.PAGE'
      //   11: iconst_m1
      //   12: invokevirtual getInt : (Ljava/lang/String;I)I
      //   15: istore_3
      //   16: aload_2
      //   17: ldc 'android.media.browse.extra.PAGE_SIZE'
      //   19: iconst_m1
      //   20: invokevirtual getInt : (Ljava/lang/String;I)I
      //   23: istore #6
      //   25: iload_3
      //   26: iconst_m1
      //   27: if_icmpne -> 38
      //   30: aload_1
      //   31: astore_2
      //   32: iload #6
      //   34: iconst_m1
      //   35: if_icmpeq -> 6
      //   38: iload #6
      //   40: iload_3
      //   41: imul
      //   42: istore #5
      //   44: iload #5
      //   46: iload #6
      //   48: iadd
      //   49: istore #4
      //   51: iload_3
      //   52: iflt -> 72
      //   55: iload #6
      //   57: iconst_1
      //   58: if_icmplt -> 72
      //   61: iload #5
      //   63: aload_1
      //   64: invokeinterface size : ()I
      //   69: if_icmplt -> 76
      //   72: getstatic java/util/Collections.EMPTY_LIST : Ljava/util/List;
      //   75: areturn
      //   76: iload #4
      //   78: istore_3
      //   79: iload #4
      //   81: aload_1
      //   82: invokeinterface size : ()I
      //   87: if_icmple -> 97
      //   90: aload_1
      //   91: invokeinterface size : ()I
      //   96: istore_3
      //   97: aload_1
      //   98: iload #5
      //   100: iload_3
      //   101: invokeinterface subList : (II)Ljava/util/List;
      //   106: areturn
    }
    
    public void onChildrenLoaded(@NonNull String param1String, List<?> param1List) {
      MediaBrowserCompat.Subscription subscription;
      if (this.this$0.mSubscriptionRef == null) {
        subscription = null;
      } else {
        subscription = this.this$0.mSubscriptionRef.get();
      } 
      if (subscription == null) {
        this.this$0.onChildrenLoaded(param1String, MediaBrowserCompat.MediaItem.fromMediaItemList(param1List));
        return;
      } 
      param1List = MediaBrowserCompat.MediaItem.fromMediaItemList(param1List);
      List<MediaBrowserCompat.SubscriptionCallback> list1 = subscription.getCallbacks();
      List<Bundle> list = subscription.getOptionsList();
      int i = 0;
      while (true) {
        if (i < list1.size()) {
          Bundle bundle = list.get(i);
          if (bundle == null) {
            this.this$0.onChildrenLoaded(param1String, (List)param1List);
          } else {
            this.this$0.onChildrenLoaded(param1String, applyOptions((List)param1List, bundle), bundle);
          } 
          i++;
          continue;
        } 
        return;
      } 
    }
    
    public void onError(@NonNull String param1String) {
      this.this$0.onError(param1String);
    }
  }
  
  private class StubApi24 extends SubscriptionCallback.StubApi21 implements MediaBrowserCompatApi24.SubscriptionCallback {
    StubApi24() {
      super((MediaBrowserCompat.SubscriptionCallback)MediaBrowserCompat.this);
    }
    
    public void onChildrenLoaded(@NonNull String param1String, List<?> param1List, @NonNull Bundle param1Bundle) {
      this.this$0.onChildrenLoaded(param1String, MediaBrowserCompat.MediaItem.fromMediaItemList(param1List), param1Bundle);
    }
    
    public void onError(@NonNull String param1String, @NonNull Bundle param1Bundle) {
      this.this$0.onError(param1String, param1Bundle);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\media\MediaBrowserCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */