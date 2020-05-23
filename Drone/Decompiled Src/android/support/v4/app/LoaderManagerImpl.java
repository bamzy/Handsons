package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {
  static boolean DEBUG = false;
  
  static final String TAG = "LoaderManager";
  
  boolean mCreatingLoader;
  
  FragmentHostCallback mHost;
  
  final SparseArrayCompat<LoaderInfo> mInactiveLoaders = new SparseArrayCompat();
  
  final SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat();
  
  boolean mRetaining;
  
  boolean mRetainingStarted;
  
  boolean mStarted;
  
  final String mWho;
  
  LoaderManagerImpl(String paramString, FragmentHostCallback paramFragmentHostCallback, boolean paramBoolean) {
    this.mWho = paramString;
    this.mHost = paramFragmentHostCallback;
    this.mStarted = paramBoolean;
  }
  
  private LoaderInfo createAndInstallLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks) {
    try {
      this.mCreatingLoader = true;
      LoaderInfo loaderInfo = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
      installLoader(loaderInfo);
      return loaderInfo;
    } finally {
      this.mCreatingLoader = false;
    } 
  }
  
  private LoaderInfo createLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks) {
    LoaderInfo loaderInfo = new LoaderInfo(paramInt, paramBundle, paramLoaderCallbacks);
    loaderInfo.mLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
    return loaderInfo;
  }
  
  public void destroyLoader(int paramInt) {
    if (this.mCreatingLoader)
      throw new IllegalStateException("Called while creating a loader"); 
    if (DEBUG)
      Log.v("LoaderManager", "destroyLoader in " + this + " of " + paramInt); 
    int i = this.mLoaders.indexOfKey(paramInt);
    if (i >= 0) {
      LoaderInfo loaderInfo = (LoaderInfo)this.mLoaders.valueAt(i);
      this.mLoaders.removeAt(i);
      loaderInfo.destroy();
    } 
    paramInt = this.mInactiveLoaders.indexOfKey(paramInt);
    if (paramInt >= 0) {
      LoaderInfo loaderInfo = (LoaderInfo)this.mInactiveLoaders.valueAt(paramInt);
      this.mInactiveLoaders.removeAt(paramInt);
      loaderInfo.destroy();
    } 
    if (this.mHost != null && !hasRunningLoaders())
      this.mHost.mFragmentManager.startPendingDeferredFragments(); 
  }
  
  void doDestroy() {
    if (!this.mRetaining) {
      if (DEBUG)
        Log.v("LoaderManager", "Destroying Active in " + this); 
      for (int j = this.mLoaders.size() - 1; j >= 0; j--)
        ((LoaderInfo)this.mLoaders.valueAt(j)).destroy(); 
      this.mLoaders.clear();
    } 
    if (DEBUG)
      Log.v("LoaderManager", "Destroying Inactive in " + this); 
    for (int i = this.mInactiveLoaders.size() - 1; i >= 0; i--)
      ((LoaderInfo)this.mInactiveLoaders.valueAt(i)).destroy(); 
    this.mInactiveLoaders.clear();
    this.mHost = null;
  }
  
  void doReportNextStart() {
    for (int i = this.mLoaders.size() - 1; i >= 0; i--)
      ((LoaderInfo)this.mLoaders.valueAt(i)).mReportNextStart = true; 
  }
  
  void doReportStart() {
    for (int i = this.mLoaders.size() - 1; i >= 0; i--)
      ((LoaderInfo)this.mLoaders.valueAt(i)).reportStart(); 
  }
  
  void doRetain() {
    if (DEBUG)
      Log.v("LoaderManager", "Retaining in " + this); 
    if (!this.mStarted) {
      RuntimeException runtimeException = new RuntimeException("here");
      runtimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
      return;
    } 
    this.mRetaining = true;
    this.mStarted = false;
    int i = this.mLoaders.size() - 1;
    while (true) {
      if (i >= 0) {
        ((LoaderInfo)this.mLoaders.valueAt(i)).retain();
        i--;
        continue;
      } 
      return;
    } 
  }
  
  void doStart() {
    if (DEBUG)
      Log.v("LoaderManager", "Starting in " + this); 
    if (this.mStarted) {
      RuntimeException runtimeException = new RuntimeException("here");
      runtimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
      return;
    } 
    this.mStarted = true;
    int i = this.mLoaders.size() - 1;
    while (true) {
      if (i >= 0) {
        ((LoaderInfo)this.mLoaders.valueAt(i)).start();
        i--;
        continue;
      } 
      return;
    } 
  }
  
  void doStop() {
    if (DEBUG)
      Log.v("LoaderManager", "Stopping in " + this); 
    if (!this.mStarted) {
      RuntimeException runtimeException = new RuntimeException("here");
      runtimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
      return;
    } 
    for (int i = this.mLoaders.size() - 1; i >= 0; i--)
      ((LoaderInfo)this.mLoaders.valueAt(i)).stop(); 
    this.mStarted = false;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    if (this.mLoaders.size() > 0) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      String str = paramString + "    ";
      int i;
      for (i = 0; i < this.mLoaders.size(); i++) {
        LoaderInfo loaderInfo = (LoaderInfo)this.mLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(loaderInfo.toString());
        loaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      } 
    } 
    if (this.mInactiveLoaders.size() > 0) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      String str = paramString + "    ";
      int i;
      for (i = 0; i < this.mInactiveLoaders.size(); i++) {
        LoaderInfo loaderInfo = (LoaderInfo)this.mInactiveLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mInactiveLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(loaderInfo.toString());
        loaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      } 
    } 
  }
  
  void finishRetain() {
    if (this.mRetaining) {
      if (DEBUG)
        Log.v("LoaderManager", "Finished Retaining in " + this); 
      this.mRetaining = false;
      for (int i = this.mLoaders.size() - 1; i >= 0; i--)
        ((LoaderInfo)this.mLoaders.valueAt(i)).finishRetain(); 
    } 
  }
  
  public <D> Loader<D> getLoader(int paramInt) {
    if (this.mCreatingLoader)
      throw new IllegalStateException("Called while creating a loader"); 
    LoaderInfo loaderInfo = (LoaderInfo)this.mLoaders.get(paramInt);
    return (loaderInfo != null) ? ((loaderInfo.mPendingLoader != null) ? loaderInfo.mPendingLoader.mLoader : loaderInfo.mLoader) : null;
  }
  
  public boolean hasRunningLoaders() {
    int k = 0;
    int j = this.mLoaders.size();
    for (int i = 0; i < j; i++) {
      byte b;
      LoaderInfo loaderInfo = (LoaderInfo)this.mLoaders.valueAt(i);
      if (loaderInfo.mStarted && !loaderInfo.mDeliveredData) {
        b = 1;
      } else {
        b = 0;
      } 
      k |= b;
    } 
    return k;
  }
  
  public <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks) {
    LoaderInfo loaderInfo1;
    LoaderInfo loaderInfo2;
    if (this.mCreatingLoader)
      throw new IllegalStateException("Called while creating a loader"); 
    LoaderInfo loaderInfo3 = (LoaderInfo)this.mLoaders.get(paramInt);
    if (DEBUG)
      Log.v("LoaderManager", "initLoader in " + this + ": args=" + paramBundle); 
    if (loaderInfo3 == null) {
      loaderInfo2 = createAndInstallLoader(paramInt, paramBundle, (LoaderManager.LoaderCallbacks)paramLoaderCallbacks);
      loaderInfo1 = loaderInfo2;
      if (DEBUG) {
        Log.v("LoaderManager", "  Created new loader " + loaderInfo2);
        loaderInfo1 = loaderInfo2;
      } 
    } else {
      if (DEBUG)
        Log.v("LoaderManager", "  Re-using existing loader " + loaderInfo3); 
      loaderInfo3.mCallbacks = (LoaderManager.LoaderCallbacks)loaderInfo2;
      loaderInfo1 = loaderInfo3;
    } 
    if (loaderInfo1.mHaveData && this.mStarted)
      loaderInfo1.callOnLoadFinished(loaderInfo1.mLoader, loaderInfo1.mData); 
    return loaderInfo1.mLoader;
  }
  
  void installLoader(LoaderInfo paramLoaderInfo) {
    this.mLoaders.put(paramLoaderInfo.mId, paramLoaderInfo);
    if (this.mStarted)
      paramLoaderInfo.start(); 
  }
  
  public <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks) {
    if (this.mCreatingLoader)
      throw new IllegalStateException("Called while creating a loader"); 
    LoaderInfo loaderInfo = (LoaderInfo)this.mLoaders.get(paramInt);
    if (DEBUG)
      Log.v("LoaderManager", "restartLoader in " + this + ": args=" + paramBundle); 
    if (loaderInfo != null) {
      LoaderInfo loaderInfo1 = (LoaderInfo)this.mInactiveLoaders.get(paramInt);
      if (loaderInfo1 != null) {
        if (loaderInfo.mHaveData) {
          if (DEBUG)
            Log.v("LoaderManager", "  Removing last inactive loader: " + loaderInfo); 
          loaderInfo1.mDeliveredData = false;
          loaderInfo1.destroy();
          loaderInfo.mLoader.abandon();
          this.mInactiveLoaders.put(paramInt, loaderInfo);
          return (createAndInstallLoader(paramInt, paramBundle, (LoaderManager.LoaderCallbacks)paramLoaderCallbacks)).mLoader;
        } 
        if (!loaderInfo.cancel()) {
          if (DEBUG)
            Log.v("LoaderManager", "  Current loader is stopped; replacing"); 
          this.mLoaders.put(paramInt, null);
          loaderInfo.destroy();
          return (createAndInstallLoader(paramInt, paramBundle, (LoaderManager.LoaderCallbacks)paramLoaderCallbacks)).mLoader;
        } 
        if (DEBUG)
          Log.v("LoaderManager", "  Current loader is running; configuring pending loader"); 
        if (loaderInfo.mPendingLoader != null) {
          if (DEBUG)
            Log.v("LoaderManager", "  Removing pending loader: " + loaderInfo.mPendingLoader); 
          loaderInfo.mPendingLoader.destroy();
          loaderInfo.mPendingLoader = null;
        } 
        if (DEBUG)
          Log.v("LoaderManager", "  Enqueuing as new pending loader"); 
        loaderInfo.mPendingLoader = createLoader(paramInt, paramBundle, (LoaderManager.LoaderCallbacks)paramLoaderCallbacks);
        return loaderInfo.mPendingLoader.mLoader;
      } 
    } else {
      return (createAndInstallLoader(paramInt, paramBundle, (LoaderManager.LoaderCallbacks)paramLoaderCallbacks)).mLoader;
    } 
    if (DEBUG)
      Log.v("LoaderManager", "  Making last loader inactive: " + loaderInfo); 
    loaderInfo.mLoader.abandon();
    this.mInactiveLoaders.put(paramInt, loaderInfo);
    return (createAndInstallLoader(paramInt, paramBundle, (LoaderManager.LoaderCallbacks)paramLoaderCallbacks)).mLoader;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("LoaderManager{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mHost, stringBuilder);
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
  
  void updateHostController(FragmentHostCallback paramFragmentHostCallback) {
    this.mHost = paramFragmentHostCallback;
  }
  
  final class LoaderInfo implements Loader.OnLoadCompleteListener<Object>, Loader.OnLoadCanceledListener<Object> {
    final Bundle mArgs;
    
    LoaderManager.LoaderCallbacks<Object> mCallbacks;
    
    Object mData;
    
    boolean mDeliveredData;
    
    boolean mDestroyed;
    
    boolean mHaveData;
    
    final int mId;
    
    boolean mListenerRegistered;
    
    Loader<Object> mLoader;
    
    LoaderInfo mPendingLoader;
    
    boolean mReportNextStart;
    
    boolean mRetaining;
    
    boolean mRetainingStarted;
    
    boolean mStarted;
    
    public LoaderInfo(int param1Int, Bundle param1Bundle, LoaderManager.LoaderCallbacks<Object> param1LoaderCallbacks) {
      this.mId = param1Int;
      this.mArgs = param1Bundle;
      this.mCallbacks = param1LoaderCallbacks;
    }
    
    void callOnLoadFinished(Loader<Object> param1Loader, Object param1Object) {
      if (this.mCallbacks != null) {
        String str = null;
        if (LoaderManagerImpl.this.mHost != null) {
          str = LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause;
          LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
        } 
        try {
          if (LoaderManagerImpl.DEBUG)
            Log.v("LoaderManager", "  onLoadFinished in " + param1Loader + ": " + param1Loader.dataToString(param1Object)); 
          this.mCallbacks.onLoadFinished(param1Loader, param1Object);
          if (LoaderManagerImpl.this.mHost != null)
            LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = str; 
          return;
        } finally {
          if (LoaderManagerImpl.this.mHost != null)
            LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = str; 
        } 
      } 
    }
    
    boolean cancel() {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "  Canceling: " + this); 
      if (this.mStarted && this.mLoader != null && this.mListenerRegistered) {
        boolean bool = this.mLoader.cancelLoad();
        if (!bool)
          onLoadCanceled(this.mLoader); 
        return bool;
      } 
      return false;
    }
    
    void destroy() {
      // Byte code:
      //   0: getstatic android/support/v4/app/LoaderManagerImpl.DEBUG : Z
      //   3: ifeq -> 31
      //   6: ldc 'LoaderManager'
      //   8: new java/lang/StringBuilder
      //   11: dup
      //   12: invokespecial <init> : ()V
      //   15: ldc '  Destroying: '
      //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   20: aload_0
      //   21: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   24: invokevirtual toString : ()Ljava/lang/String;
      //   27: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
      //   30: pop
      //   31: aload_0
      //   32: iconst_1
      //   33: putfield mDestroyed : Z
      //   36: aload_0
      //   37: getfield mDeliveredData : Z
      //   40: istore_1
      //   41: aload_0
      //   42: iconst_0
      //   43: putfield mDeliveredData : Z
      //   46: aload_0
      //   47: getfield mCallbacks : Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
      //   50: ifnull -> 180
      //   53: aload_0
      //   54: getfield mLoader : Landroid/support/v4/content/Loader;
      //   57: ifnull -> 180
      //   60: aload_0
      //   61: getfield mHaveData : Z
      //   64: ifeq -> 180
      //   67: iload_1
      //   68: ifeq -> 180
      //   71: getstatic android/support/v4/app/LoaderManagerImpl.DEBUG : Z
      //   74: ifeq -> 102
      //   77: ldc 'LoaderManager'
      //   79: new java/lang/StringBuilder
      //   82: dup
      //   83: invokespecial <init> : ()V
      //   86: ldc '  Resetting: '
      //   88: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   91: aload_0
      //   92: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   95: invokevirtual toString : ()Ljava/lang/String;
      //   98: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
      //   101: pop
      //   102: aconst_null
      //   103: astore_2
      //   104: aload_0
      //   105: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   108: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   111: ifnull -> 143
      //   114: aload_0
      //   115: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   118: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   121: getfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
      //   124: getfield mNoTransactionsBecause : Ljava/lang/String;
      //   127: astore_2
      //   128: aload_0
      //   129: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   132: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   135: getfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
      //   138: ldc 'onLoaderReset'
      //   140: putfield mNoTransactionsBecause : Ljava/lang/String;
      //   143: aload_0
      //   144: getfield mCallbacks : Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
      //   147: aload_0
      //   148: getfield mLoader : Landroid/support/v4/content/Loader;
      //   151: invokeinterface onLoaderReset : (Landroid/support/v4/content/Loader;)V
      //   156: aload_0
      //   157: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   160: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   163: ifnull -> 180
      //   166: aload_0
      //   167: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   170: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   173: getfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
      //   176: aload_2
      //   177: putfield mNoTransactionsBecause : Ljava/lang/String;
      //   180: aload_0
      //   181: aconst_null
      //   182: putfield mCallbacks : Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
      //   185: aload_0
      //   186: aconst_null
      //   187: putfield mData : Ljava/lang/Object;
      //   190: aload_0
      //   191: iconst_0
      //   192: putfield mHaveData : Z
      //   195: aload_0
      //   196: getfield mLoader : Landroid/support/v4/content/Loader;
      //   199: ifnull -> 237
      //   202: aload_0
      //   203: getfield mListenerRegistered : Z
      //   206: ifeq -> 230
      //   209: aload_0
      //   210: iconst_0
      //   211: putfield mListenerRegistered : Z
      //   214: aload_0
      //   215: getfield mLoader : Landroid/support/v4/content/Loader;
      //   218: aload_0
      //   219: invokevirtual unregisterListener : (Landroid/support/v4/content/Loader$OnLoadCompleteListener;)V
      //   222: aload_0
      //   223: getfield mLoader : Landroid/support/v4/content/Loader;
      //   226: aload_0
      //   227: invokevirtual unregisterOnLoadCanceledListener : (Landroid/support/v4/content/Loader$OnLoadCanceledListener;)V
      //   230: aload_0
      //   231: getfield mLoader : Landroid/support/v4/content/Loader;
      //   234: invokevirtual reset : ()V
      //   237: aload_0
      //   238: getfield mPendingLoader : Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo;
      //   241: ifnull -> 251
      //   244: aload_0
      //   245: getfield mPendingLoader : Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo;
      //   248: invokevirtual destroy : ()V
      //   251: return
      //   252: astore_3
      //   253: aload_0
      //   254: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   257: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   260: ifnull -> 277
      //   263: aload_0
      //   264: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   267: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   270: getfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
      //   273: aload_2
      //   274: putfield mNoTransactionsBecause : Ljava/lang/String;
      //   277: aload_3
      //   278: athrow
      // Exception table:
      //   from	to	target	type
      //   143	156	252	finally
    }
    
    public void dump(String param1String, FileDescriptor param1FileDescriptor, PrintWriter param1PrintWriter, String[] param1ArrayOfString) {
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mId=");
      param1PrintWriter.print(this.mId);
      param1PrintWriter.print(" mArgs=");
      param1PrintWriter.println(this.mArgs);
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mCallbacks=");
      param1PrintWriter.println(this.mCallbacks);
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mLoader=");
      param1PrintWriter.println(this.mLoader);
      if (this.mLoader != null)
        this.mLoader.dump(param1String + "  ", param1FileDescriptor, param1PrintWriter, param1ArrayOfString); 
      if (this.mHaveData || this.mDeliveredData) {
        param1PrintWriter.print(param1String);
        param1PrintWriter.print("mHaveData=");
        param1PrintWriter.print(this.mHaveData);
        param1PrintWriter.print("  mDeliveredData=");
        param1PrintWriter.println(this.mDeliveredData);
        param1PrintWriter.print(param1String);
        param1PrintWriter.print("mData=");
        param1PrintWriter.println(this.mData);
      } 
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mStarted=");
      param1PrintWriter.print(this.mStarted);
      param1PrintWriter.print(" mReportNextStart=");
      param1PrintWriter.print(this.mReportNextStart);
      param1PrintWriter.print(" mDestroyed=");
      param1PrintWriter.println(this.mDestroyed);
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mRetaining=");
      param1PrintWriter.print(this.mRetaining);
      param1PrintWriter.print(" mRetainingStarted=");
      param1PrintWriter.print(this.mRetainingStarted);
      param1PrintWriter.print(" mListenerRegistered=");
      param1PrintWriter.println(this.mListenerRegistered);
      if (this.mPendingLoader != null) {
        param1PrintWriter.print(param1String);
        param1PrintWriter.println("Pending Loader ");
        param1PrintWriter.print(this.mPendingLoader);
        param1PrintWriter.println(":");
        this.mPendingLoader.dump(param1String + "  ", param1FileDescriptor, param1PrintWriter, param1ArrayOfString);
      } 
    }
    
    void finishRetain() {
      if (this.mRetaining) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Finished Retaining: " + this); 
        this.mRetaining = false;
        if (this.mStarted != this.mRetainingStarted && !this.mStarted)
          stop(); 
      } 
      if (this.mStarted && this.mHaveData && !this.mReportNextStart)
        callOnLoadFinished(this.mLoader, this.mData); 
    }
    
    public void onLoadCanceled(Loader<Object> param1Loader) {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "onLoadCanceled: " + this); 
      if (this.mDestroyed) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Ignoring load canceled -- destroyed"); 
        return;
      } 
      if (LoaderManagerImpl.this.mLoaders.get(this.mId) != this) {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  Ignoring load canceled -- not active");
          return;
        } 
        return;
      } 
      LoaderInfo loaderInfo = this.mPendingLoader;
      if (loaderInfo != null) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Switching to pending loader: " + loaderInfo); 
        this.mPendingLoader = null;
        LoaderManagerImpl.this.mLoaders.put(this.mId, null);
        destroy();
        LoaderManagerImpl.this.installLoader(loaderInfo);
        return;
      } 
    }
    
    public void onLoadComplete(Loader<Object> param1Loader, Object param1Object) {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "onLoadComplete: " + this); 
      if (this.mDestroyed) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Ignoring load complete -- destroyed"); 
        return;
      } 
      if (LoaderManagerImpl.this.mLoaders.get(this.mId) != this) {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  Ignoring load complete -- not active");
          return;
        } 
        return;
      } 
      LoaderInfo loaderInfo2 = this.mPendingLoader;
      if (loaderInfo2 != null) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Switching to pending loader: " + loaderInfo2); 
        this.mPendingLoader = null;
        LoaderManagerImpl.this.mLoaders.put(this.mId, null);
        destroy();
        LoaderManagerImpl.this.installLoader(loaderInfo2);
        return;
      } 
      if (this.mData != param1Object || !this.mHaveData) {
        this.mData = param1Object;
        this.mHaveData = true;
        if (this.mStarted)
          callOnLoadFinished(param1Loader, param1Object); 
      } 
      LoaderInfo loaderInfo1 = (LoaderInfo)LoaderManagerImpl.this.mInactiveLoaders.get(this.mId);
      if (loaderInfo1 != null && loaderInfo1 != this) {
        loaderInfo1.mDeliveredData = false;
        loaderInfo1.destroy();
        LoaderManagerImpl.this.mInactiveLoaders.remove(this.mId);
      } 
      if (LoaderManagerImpl.this.mHost != null && !LoaderManagerImpl.this.hasRunningLoaders()) {
        LoaderManagerImpl.this.mHost.mFragmentManager.startPendingDeferredFragments();
        return;
      } 
    }
    
    void reportStart() {
      if (this.mStarted && this.mReportNextStart) {
        this.mReportNextStart = false;
        if (this.mHaveData && !this.mRetaining)
          callOnLoadFinished(this.mLoader, this.mData); 
      } 
    }
    
    void retain() {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "  Retaining: " + this); 
      this.mRetaining = true;
      this.mRetainingStarted = this.mStarted;
      this.mStarted = false;
      this.mCallbacks = null;
    }
    
    void start() {
      if (this.mRetaining && this.mRetainingStarted) {
        this.mStarted = true;
        return;
      } 
      if (!this.mStarted) {
        this.mStarted = true;
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Starting: " + this); 
        if (this.mLoader == null && this.mCallbacks != null)
          this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs); 
        if (this.mLoader != null) {
          if (this.mLoader.getClass().isMemberClass() && !Modifier.isStatic(this.mLoader.getClass().getModifiers()))
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader); 
          if (!this.mListenerRegistered) {
            this.mLoader.registerListener(this.mId, this);
            this.mLoader.registerOnLoadCanceledListener(this);
            this.mListenerRegistered = true;
          } 
          this.mLoader.startLoading();
          return;
        } 
      } 
    }
    
    void stop() {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "  Stopping: " + this); 
      this.mStarted = false;
      if (!this.mRetaining && this.mLoader != null && this.mListenerRegistered) {
        this.mListenerRegistered = false;
        this.mLoader.unregisterListener(this);
        this.mLoader.unregisterOnLoadCanceledListener(this);
        this.mLoader.stopLoading();
      } 
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(64);
      stringBuilder.append("LoaderInfo{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" #");
      stringBuilder.append(this.mId);
      stringBuilder.append(" : ");
      DebugUtils.buildShortClassTag(this.mLoader, stringBuilder);
      stringBuilder.append("}}");
      return stringBuilder.toString();
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\LoaderManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */