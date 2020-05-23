package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E> extends FragmentContainer {
  private final Activity mActivity;
  
  private SimpleArrayMap<String, LoaderManager> mAllLoaderManagers;
  
  private boolean mCheckedForLoaderManager;
  
  final Context mContext;
  
  final FragmentManagerImpl mFragmentManager = new FragmentManagerImpl();
  
  private final Handler mHandler;
  
  private LoaderManagerImpl mLoaderManager;
  
  private boolean mLoadersStarted;
  
  private boolean mRetainLoaders;
  
  final int mWindowAnimations;
  
  FragmentHostCallback(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt) {
    this.mActivity = paramActivity;
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.mWindowAnimations = paramInt;
  }
  
  public FragmentHostCallback(Context paramContext, Handler paramHandler, int paramInt) {
    this(activity, paramContext, paramHandler, paramInt);
  }
  
  FragmentHostCallback(FragmentActivity paramFragmentActivity) {
    this(paramFragmentActivity, (Context)paramFragmentActivity, paramFragmentActivity.mHandler, 0);
  }
  
  void doLoaderDestroy() {
    if (this.mLoaderManager == null)
      return; 
    this.mLoaderManager.doDestroy();
  }
  
  void doLoaderRetain() {
    if (this.mLoaderManager == null)
      return; 
    this.mLoaderManager.doRetain();
  }
  
  void doLoaderStart() {
    if (this.mLoadersStarted)
      return; 
    this.mLoadersStarted = true;
    if (this.mLoaderManager != null) {
      this.mLoaderManager.doStart();
    } else if (!this.mCheckedForLoaderManager) {
      this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, false);
      if (this.mLoaderManager != null && !this.mLoaderManager.mStarted)
        this.mLoaderManager.doStart(); 
    } 
    this.mCheckedForLoaderManager = true;
  }
  
  void doLoaderStop(boolean paramBoolean) {
    this.mRetainLoaders = paramBoolean;
    if (this.mLoaderManager != null && this.mLoadersStarted) {
      this.mLoadersStarted = false;
      if (paramBoolean) {
        this.mLoaderManager.doRetain();
        return;
      } 
      this.mLoaderManager.doStop();
      return;
    } 
  }
  
  void dumpLoaders(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.mLoadersStarted);
    if (this.mLoaderManager != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
      paramPrintWriter.println(":");
      this.mLoaderManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    } 
  }
  
  Activity getActivity() {
    return this.mActivity;
  }
  
  Context getContext() {
    return this.mContext;
  }
  
  FragmentManagerImpl getFragmentManagerImpl() {
    return this.mFragmentManager;
  }
  
  Handler getHandler() {
    return this.mHandler;
  }
  
  LoaderManagerImpl getLoaderManager(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    if (this.mAllLoaderManagers == null)
      this.mAllLoaderManagers = new SimpleArrayMap(); 
    LoaderManagerImpl loaderManagerImpl2 = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramString);
    if (loaderManagerImpl2 == null && paramBoolean2) {
      loaderManagerImpl2 = new LoaderManagerImpl(paramString, this, paramBoolean1);
      this.mAllLoaderManagers.put(paramString, loaderManagerImpl2);
      return loaderManagerImpl2;
    } 
    LoaderManagerImpl loaderManagerImpl1 = loaderManagerImpl2;
    if (paramBoolean1) {
      loaderManagerImpl1 = loaderManagerImpl2;
      if (loaderManagerImpl2 != null) {
        loaderManagerImpl1 = loaderManagerImpl2;
        if (!loaderManagerImpl2.mStarted) {
          loaderManagerImpl2.doStart();
          return loaderManagerImpl2;
        } 
      } 
    } 
    return loaderManagerImpl1;
  }
  
  LoaderManagerImpl getLoaderManagerImpl() {
    if (this.mLoaderManager != null)
      return this.mLoaderManager; 
    this.mCheckedForLoaderManager = true;
    this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, true);
    return this.mLoaderManager;
  }
  
  boolean getRetainLoaders() {
    return this.mRetainLoaders;
  }
  
  void inactivateFragment(String paramString) {
    if (this.mAllLoaderManagers != null) {
      LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramString);
      if (loaderManagerImpl != null && !loaderManagerImpl.mRetaining) {
        loaderManagerImpl.doDestroy();
        this.mAllLoaderManagers.remove(paramString);
      } 
    } 
  }
  
  void onAttachFragment(Fragment paramFragment) {}
  
  public void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  @Nullable
  public View onFindViewById(int paramInt) {
    return null;
  }
  
  @Nullable
  public abstract E onGetHost();
  
  public LayoutInflater onGetLayoutInflater() {
    return (LayoutInflater)this.mContext.getSystemService("layout_inflater");
  }
  
  public int onGetWindowAnimations() {
    return this.mWindowAnimations;
  }
  
  public boolean onHasView() {
    return true;
  }
  
  public boolean onHasWindowAnimations() {
    return true;
  }
  
  public void onRequestPermissionsFromFragment(@NonNull Fragment paramFragment, @NonNull String[] paramArrayOfString, int paramInt) {}
  
  public boolean onShouldSaveFragmentState(Fragment paramFragment) {
    return true;
  }
  
  public boolean onShouldShowRequestPermissionRationale(@NonNull String paramString) {
    return false;
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt) {
    onStartActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle) {
    if (paramInt != -1)
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host"); 
    this.mContext.startActivity(paramIntent);
  }
  
  public void onStartIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle) throws IntentSender.SendIntentException {
    if (paramInt1 != -1)
      throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host"); 
    ActivityCompat.startIntentSenderForResult(this.mActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void onSupportInvalidateOptionsMenu() {}
  
  void reportLoaderStart() {
    if (this.mAllLoaderManagers != null) {
      int j = this.mAllLoaderManagers.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[j];
      int i;
      for (i = j - 1; i >= 0; i--)
        arrayOfLoaderManagerImpl[i] = (LoaderManagerImpl)this.mAllLoaderManagers.valueAt(i); 
      for (i = 0; i < j; i++) {
        LoaderManagerImpl loaderManagerImpl = arrayOfLoaderManagerImpl[i];
        loaderManagerImpl.finishRetain();
        loaderManagerImpl.doReportStart();
      } 
    } 
  }
  
  void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> paramSimpleArrayMap) {
    if (paramSimpleArrayMap != null) {
      int j = paramSimpleArrayMap.size();
      for (int i = 0; i < j; i++)
        ((LoaderManagerImpl)paramSimpleArrayMap.valueAt(i)).updateHostController(this); 
    } 
    this.mAllLoaderManagers = paramSimpleArrayMap;
  }
  
  SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
    int j = 0;
    int i = 0;
    if (this.mAllLoaderManagers != null) {
      int m = this.mAllLoaderManagers.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[m];
      int k;
      for (k = m - 1; k >= 0; k--)
        arrayOfLoaderManagerImpl[k] = (LoaderManagerImpl)this.mAllLoaderManagers.valueAt(k); 
      boolean bool = getRetainLoaders();
      j = 0;
      k = i;
      i = j;
      while (true) {
        j = k;
        if (i < m) {
          LoaderManagerImpl loaderManagerImpl = arrayOfLoaderManagerImpl[i];
          if (!loaderManagerImpl.mRetaining && bool) {
            if (!loaderManagerImpl.mStarted)
              loaderManagerImpl.doStart(); 
            loaderManagerImpl.doRetain();
          } 
          if (loaderManagerImpl.mRetaining) {
            k = 1;
          } else {
            loaderManagerImpl.doDestroy();
            this.mAllLoaderManagers.remove(loaderManagerImpl.mWho);
          } 
          i++;
          continue;
        } 
        break;
      } 
    } 
    return (j != 0) ? this.mAllLoaderManagers : null;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\FragmentHostCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */