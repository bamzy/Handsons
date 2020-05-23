package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.view.View;
import java.util.List;
import java.util.Map;

@TargetApi(23)
@RequiresApi(23)
class ActivityCompatApi23 {
  private static SharedElementCallback createCallback(SharedElementCallback23 paramSharedElementCallback23) {
    SharedElementCallbackImpl sharedElementCallbackImpl = null;
    if (paramSharedElementCallback23 != null)
      sharedElementCallbackImpl = new SharedElementCallbackImpl(paramSharedElementCallback23); 
    return sharedElementCallbackImpl;
  }
  
  public static void requestPermissions(Activity paramActivity, String[] paramArrayOfString, int paramInt) {
    if (paramActivity instanceof RequestPermissionsRequestCodeValidator)
      ((RequestPermissionsRequestCodeValidator)paramActivity).validateRequestPermissionsRequestCode(paramInt); 
    paramActivity.requestPermissions(paramArrayOfString, paramInt);
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback23 paramSharedElementCallback23) {
    paramActivity.setEnterSharedElementCallback(createCallback(paramSharedElementCallback23));
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback23 paramSharedElementCallback23) {
    paramActivity.setExitSharedElementCallback(createCallback(paramSharedElementCallback23));
  }
  
  public static boolean shouldShowRequestPermissionRationale(Activity paramActivity, String paramString) {
    return paramActivity.shouldShowRequestPermissionRationale(paramString);
  }
  
  public static interface OnSharedElementsReadyListenerBridge {
    void onSharedElementsReady();
  }
  
  public static interface RequestPermissionsRequestCodeValidator {
    void validateRequestPermissionsRequestCode(int param1Int);
  }
  
  public static abstract class SharedElementCallback23 extends ActivityCompatApi21.SharedElementCallback21 {
    public abstract void onSharedElementsArrived(List<String> param1List, List<View> param1List1, ActivityCompatApi23.OnSharedElementsReadyListenerBridge param1OnSharedElementsReadyListenerBridge);
  }
  
  private static class SharedElementCallbackImpl extends SharedElementCallback {
    private ActivityCompatApi23.SharedElementCallback23 mCallback;
    
    public SharedElementCallbackImpl(ActivityCompatApi23.SharedElementCallback23 param1SharedElementCallback23) {
      this.mCallback = param1SharedElementCallback23;
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
    
    public void onSharedElementsArrived(List<String> param1List, List<View> param1List1, final SharedElementCallback.OnSharedElementsReadyListener listener) {
      this.mCallback.onSharedElementsArrived(param1List, param1List1, new ActivityCompatApi23.OnSharedElementsReadyListenerBridge() {
            public void onSharedElementsReady() {
              listener.onSharedElementsReady();
            }
          });
    }
  }
  
  class null implements OnSharedElementsReadyListenerBridge {
    public void onSharedElementsReady() {
      listener.onSharedElementsReady();
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ActivityCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */