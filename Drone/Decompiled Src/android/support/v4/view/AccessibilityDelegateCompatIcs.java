package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(14)
@RequiresApi(14)
class AccessibilityDelegateCompatIcs {
  public static boolean dispatchPopulateAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return ((View.AccessibilityDelegate)paramObject).dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateBridge bridge) {
    return new View.AccessibilityDelegate() {
        public boolean dispatchPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
          return bridge.dispatchPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
        }
        
        public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
          bridge.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
        }
        
        public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfo param1AccessibilityNodeInfo) {
          bridge.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfo);
        }
        
        public void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
          bridge.onPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
        }
        
        public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
          return bridge.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent);
        }
        
        public void sendAccessibilityEvent(View param1View, int param1Int) {
          bridge.sendAccessibilityEvent(param1View, param1Int);
        }
        
        public void sendAccessibilityEventUnchecked(View param1View, AccessibilityEvent param1AccessibilityEvent) {
          bridge.sendAccessibilityEventUnchecked(param1View, param1AccessibilityEvent);
        }
      };
  }
  
  public static Object newAccessibilityDelegateDefaultImpl() {
    return new View.AccessibilityDelegate();
  }
  
  public static void onInitializeAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    ((View.AccessibilityDelegate)paramObject).onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void onInitializeAccessibilityNodeInfo(Object paramObject1, View paramView, Object paramObject2) {
    ((View.AccessibilityDelegate)paramObject1).onInitializeAccessibilityNodeInfo(paramView, (AccessibilityNodeInfo)paramObject2);
  }
  
  public static void onPopulateAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    ((View.AccessibilityDelegate)paramObject).onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static boolean onRequestSendAccessibilityEvent(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return ((View.AccessibilityDelegate)paramObject).onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public static void sendAccessibilityEvent(Object paramObject, View paramView, int paramInt) {
    ((View.AccessibilityDelegate)paramObject).sendAccessibilityEvent(paramView, paramInt);
  }
  
  public static void sendAccessibilityEventUnchecked(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    ((View.AccessibilityDelegate)paramObject).sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
  
  public static interface AccessibilityDelegateBridge {
    boolean dispatchPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    void onInitializeAccessibilityNodeInfo(View param1View, Object param1Object);
    
    void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    void sendAccessibilityEvent(View param1View, int param1Int);
    
    void sendAccessibilityEventUnchecked(View param1View, AccessibilityEvent param1AccessibilityEvent);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\AccessibilityDelegateCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */