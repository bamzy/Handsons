package android.support.v4.view;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

@TargetApi(16)
@RequiresApi(16)
class AccessibilityDelegateCompatJellyBean {
  public static Object getAccessibilityNodeProvider(Object paramObject, View paramView) {
    return ((View.AccessibilityDelegate)paramObject).getAccessibilityNodeProvider(paramView);
  }
  
  public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateBridgeJellyBean bridge) {
    return new View.AccessibilityDelegate() {
        public boolean dispatchPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
          return bridge.dispatchPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
        }
        
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View param1View) {
          return (AccessibilityNodeProvider)bridge.getAccessibilityNodeProvider(param1View);
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
        
        public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) {
          return bridge.performAccessibilityAction(param1View, param1Int, param1Bundle);
        }
        
        public void sendAccessibilityEvent(View param1View, int param1Int) {
          bridge.sendAccessibilityEvent(param1View, param1Int);
        }
        
        public void sendAccessibilityEventUnchecked(View param1View, AccessibilityEvent param1AccessibilityEvent) {
          bridge.sendAccessibilityEventUnchecked(param1View, param1AccessibilityEvent);
        }
      };
  }
  
  public static boolean performAccessibilityAction(Object paramObject, View paramView, int paramInt, Bundle paramBundle) {
    return ((View.AccessibilityDelegate)paramObject).performAccessibilityAction(paramView, paramInt, paramBundle);
  }
  
  public static interface AccessibilityDelegateBridgeJellyBean {
    boolean dispatchPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    Object getAccessibilityNodeProvider(View param1View);
    
    void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    void onInitializeAccessibilityNodeInfo(View param1View, Object param1Object);
    
    void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle);
    
    void sendAccessibilityEvent(View param1View, int param1Int);
    
    void sendAccessibilityEventUnchecked(View param1View, AccessibilityEvent param1AccessibilityEvent);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\AccessibilityDelegateCompatJellyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */