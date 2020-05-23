package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {
  private static ActivityCompatApi21.SharedElementCallback21 createCallback(SharedElementCallback paramSharedElementCallback) {
    SharedElementCallback21Impl sharedElementCallback21Impl = null;
    if (paramSharedElementCallback != null)
      sharedElementCallback21Impl = new SharedElementCallback21Impl(paramSharedElementCallback); 
    return sharedElementCallback21Impl;
  }
  
  private static ActivityCompatApi23.SharedElementCallback23 createCallback23(SharedElementCallback paramSharedElementCallback) {
    SharedElementCallback23Impl sharedElementCallback23Impl = null;
    if (paramSharedElementCallback != null)
      sharedElementCallback23Impl = new SharedElementCallback23Impl(paramSharedElementCallback); 
    return sharedElementCallback23Impl;
  }
  
  public static void finishAffinity(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.finishAffinity(paramActivity);
      return;
    } 
    paramActivity.finish();
  }
  
  public static void finishAfterTransition(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompatApi21.finishAfterTransition(paramActivity);
      return;
    } 
    paramActivity.finish();
  }
  
  @Nullable
  public static Uri getReferrer(Activity paramActivity) {
    String str;
    if (Build.VERSION.SDK_INT >= 22)
      return ActivityCompatApi22.getReferrer(paramActivity); 
    Intent intent = paramActivity.getIntent();
    Uri uri2 = (Uri)intent.getParcelableExtra("android.intent.extra.REFERRER");
    Uri uri1 = uri2;
    if (uri2 == null) {
      str = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
      return (str != null) ? Uri.parse(str) : null;
    } 
    return (Uri)str;
  }
  
  public static boolean invalidateOptionsMenu(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 11) {
      ActivityCompatHoneycomb.invalidateOptionsMenu(paramActivity);
      return true;
    } 
    return false;
  }
  
  public static void postponeEnterTransition(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 21)
      ActivityCompatApi21.postponeEnterTransition(paramActivity); 
  }
  
  public static void requestPermissions(@NonNull final Activity activity, @NonNull final String[] permissions, @IntRange(from = 0L) final int requestCode) {
    if (Build.VERSION.SDK_INT >= 23) {
      ActivityCompatApi23.requestPermissions(activity, permissions, requestCode);
      return;
    } 
    if (activity instanceof OnRequestPermissionsResultCallback) {
      (new Handler(Looper.getMainLooper())).post(new Runnable() {
            public void run() {
              int[] arrayOfInt = new int[permissions.length];
              PackageManager packageManager = activity.getPackageManager();
              String str = activity.getPackageName();
              int j = permissions.length;
              for (int i = 0; i < j; i++)
                arrayOfInt[i] = packageManager.checkPermission(permissions[i], str); 
              ((ActivityCompat.OnRequestPermissionsResultCallback)activity).onRequestPermissionsResult(requestCode, permissions, arrayOfInt);
            }
          });
      return;
    } 
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback) {
    if (Build.VERSION.SDK_INT >= 23) {
      ActivityCompatApi23.setEnterSharedElementCallback(paramActivity, createCallback23(paramSharedElementCallback));
      return;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompatApi21.setEnterSharedElementCallback(paramActivity, createCallback(paramSharedElementCallback));
      return;
    } 
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback) {
    if (Build.VERSION.SDK_INT >= 23) {
      ActivityCompatApi23.setExitSharedElementCallback(paramActivity, createCallback23(paramSharedElementCallback));
      return;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompatApi21.setExitSharedElementCallback(paramActivity, createCallback(paramSharedElementCallback));
      return;
    } 
  }
  
  public static boolean shouldShowRequestPermissionRationale(@NonNull Activity paramActivity, @NonNull String paramString) {
    return (Build.VERSION.SDK_INT >= 23) ? ActivityCompatApi23.shouldShowRequestPermissionRationale(paramActivity, paramString) : false;
  }
  
  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle) {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.startActivityForResult(paramActivity, paramIntent, paramInt, paramBundle);
      return;
    } 
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void startIntentSenderForResult(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle) throws IntentSender.SendIntentException {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.startIntentSenderForResult(paramActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    } 
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public static void startPostponedEnterTransition(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 21)
      ActivityCompatApi21.startPostponedEnterTransition(paramActivity); 
  }
  
  public static interface OnRequestPermissionsResultCallback {
    void onRequestPermissionsResult(int param1Int, @NonNull String[] param1ArrayOfString, @NonNull int[] param1ArrayOfint);
  }
  
  private static class SharedElementCallback21Impl extends ActivityCompatApi21.SharedElementCallback21 {
    private SharedElementCallback mCallback;
    
    public SharedElementCallback21Impl(SharedElementCallback param1SharedElementCallback) {
      this.mCallback = param1SharedElementCallback;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View param1View, Matrix param1Matrix, RectF param1RectF) {
      return this.mCallback.onCaptureSharedElementSnapshot(param1View, param1Matrix, param1RectF);
    }
    
    public View onCreateSnapshotView(Context param1Context, Parcelable param1Parcelable) {
      return this.mCallback.onCreateSnapshotView(param1Context, param1Parcelable);
    }
    
    public void onMapSharedElements(List<String> param1List, Map<String, View> param1Map) {
      this.mCallback.onMapSharedElements(param1List, param1Map);
    }
    
    public void onRejectSharedElements(List<View> param1List) {
      this.mCallback.onRejectSharedElements(param1List);
    }
    
    public void onSharedElementEnd(List<String> param1List, List<View> param1List1, List<View> param1List2) {
      this.mCallback.onSharedElementEnd(param1List, param1List1, param1List2);
    }
    
    public void onSharedElementStart(List<String> param1List, List<View> param1List1, List<View> param1List2) {
      this.mCallback.onSharedElementStart(param1List, param1List1, param1List2);
    }
  }
  
  private static class SharedElementCallback23Impl extends ActivityCompatApi23.SharedElementCallback23 {
    private SharedElementCallback mCallback;
    
    public SharedElementCallback23Impl(SharedElementCallback param1SharedElementCallback) {
      this.mCallback = param1SharedElementCallback;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View param1View, Matrix param1Matrix, RectF param1RectF) {
      return this.mCallback.onCaptureSharedElementSnapshot(param1View, param1Matrix, param1RectF);
    }
    
    public View onCreateSnapshotView(Context param1Context, Parcelable param1Parcelable) {
      return this.mCallback.onCreateSnapshotView(param1Context, param1Parcelable);
    }
    
    public void onMapSharedElements(List<String> param1List, Map<String, View> param1Map) {
      this.mCallback.onMapSharedElements(param1List, param1Map);
    }
    
    public void onRejectSharedElements(List<View> param1List) {
      this.mCallback.onRejectSharedElements(param1List);
    }
    
    public void onSharedElementEnd(List<String> param1List, List<View> param1List1, List<View> param1List2) {
      this.mCallback.onSharedElementEnd(param1List, param1List1, param1List2);
    }
    
    public void onSharedElementStart(List<String> param1List, List<View> param1List1, List<View> param1List2) {
      this.mCallback.onSharedElementStart(param1List, param1List1, param1List2);
    }
    
    public void onSharedElementsArrived(List<String> param1List, List<View> param1List1, final ActivityCompatApi23.OnSharedElementsReadyListenerBridge listener) {
      this.mCallback.onSharedElementsArrived(param1List, param1List1, new SharedElementCallback.OnSharedElementsReadyListener() {
            public void onSharedElementsReady() {
              listener.onSharedElementsReady();
            }
          });
    }
  }
  
  class null implements SharedElementCallback.OnSharedElementsReadyListener {
    public void onSharedElementsReady() {
      listener.onSharedElementsReady();
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ActivityCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */