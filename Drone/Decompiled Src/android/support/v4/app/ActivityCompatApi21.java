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

@TargetApi(21)
@RequiresApi(21)
class ActivityCompatApi21 {
  private static SharedElementCallback createCallback(SharedElementCallback21 paramSharedElementCallback21) {
    SharedElementCallbackImpl sharedElementCallbackImpl = null;
    if (paramSharedElementCallback21 != null)
      sharedElementCallbackImpl = new SharedElementCallbackImpl(paramSharedElementCallback21); 
    return sharedElementCallbackImpl;
  }
  
  public static void finishAfterTransition(Activity paramActivity) {
    paramActivity.finishAfterTransition();
  }
  
  public static void postponeEnterTransition(Activity paramActivity) {
    paramActivity.postponeEnterTransition();
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback21 paramSharedElementCallback21) {
    paramActivity.setEnterSharedElementCallback(createCallback(paramSharedElementCallback21));
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback21 paramSharedElementCallback21) {
    paramActivity.setExitSharedElementCallback(createCallback(paramSharedElementCallback21));
  }
  
  public static void startPostponedEnterTransition(Activity paramActivity) {
    paramActivity.startPostponedEnterTransition();
  }
  
  public static abstract class SharedElementCallback21 {
    public abstract Parcelable onCaptureSharedElementSnapshot(View param1View, Matrix param1Matrix, RectF param1RectF);
    
    public abstract View onCreateSnapshotView(Context param1Context, Parcelable param1Parcelable);
    
    public abstract void onMapSharedElements(List<String> param1List, Map<String, View> param1Map);
    
    public abstract void onRejectSharedElements(List<View> param1List);
    
    public abstract void onSharedElementEnd(List<String> param1List, List<View> param1List1, List<View> param1List2);
    
    public abstract void onSharedElementStart(List<String> param1List, List<View> param1List1, List<View> param1List2);
  }
  
  private static class SharedElementCallbackImpl extends SharedElementCallback {
    private ActivityCompatApi21.SharedElementCallback21 mCallback;
    
    public SharedElementCallbackImpl(ActivityCompatApi21.SharedElementCallback21 param1SharedElementCallback21) {
      this.mCallback = param1SharedElementCallback21;
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
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ActivityCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */