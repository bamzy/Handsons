package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

@TargetApi(21)
@RequiresApi(21)
class ViewParentCompatLollipop {
  private static final String TAG = "ViewParentCompat";
  
  public static boolean onNestedFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    try {
      return paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    } catch (AbstractMethodError abstractMethodError) {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onNestedFling", abstractMethodError);
      return false;
    } 
  }
  
  public static boolean onNestedPreFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2) {
    try {
      return paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
    } catch (AbstractMethodError abstractMethodError) {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onNestedPreFling", abstractMethodError);
      return false;
    } 
  }
  
  public static void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    try {
      paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfint);
      return;
    } catch (AbstractMethodError abstractMethodError) {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onNestedPreScroll", abstractMethodError);
      return;
    } 
  }
  
  public static void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    try {
      paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } catch (AbstractMethodError abstractMethodError) {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onNestedScroll", abstractMethodError);
      return;
    } 
  }
  
  public static void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt) {
    try {
      paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt);
      return;
    } catch (AbstractMethodError abstractMethodError) {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onNestedScrollAccepted", abstractMethodError);
      return;
    } 
  }
  
  public static boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt) {
    try {
      return paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt);
    } catch (AbstractMethodError abstractMethodError) {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onStartNestedScroll", abstractMethodError);
      return false;
    } 
  }
  
  public static void onStopNestedScroll(ViewParent paramViewParent, View paramView) {
    try {
      paramViewParent.onStopNestedScroll(paramView);
      return;
    } catch (AbstractMethodError abstractMethodError) {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onStopNestedScroll", abstractMethodError);
      return;
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewParentCompatLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */