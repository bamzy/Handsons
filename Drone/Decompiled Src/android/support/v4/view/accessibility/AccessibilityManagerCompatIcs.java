package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

@TargetApi(14)
@RequiresApi(14)
class AccessibilityManagerCompatIcs {
  public static boolean addAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityStateChangeListenerWrapper paramAccessibilityStateChangeListenerWrapper) {
    return paramAccessibilityManager.addAccessibilityStateChangeListener(paramAccessibilityStateChangeListenerWrapper);
  }
  
  public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager, int paramInt) {
    return paramAccessibilityManager.getEnabledAccessibilityServiceList(paramInt);
  }
  
  public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager) {
    return paramAccessibilityManager.getInstalledAccessibilityServiceList();
  }
  
  public static boolean isTouchExplorationEnabled(AccessibilityManager paramAccessibilityManager) {
    return paramAccessibilityManager.isTouchExplorationEnabled();
  }
  
  public static boolean removeAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityStateChangeListenerWrapper paramAccessibilityStateChangeListenerWrapper) {
    return paramAccessibilityManager.removeAccessibilityStateChangeListener(paramAccessibilityStateChangeListenerWrapper);
  }
  
  static interface AccessibilityStateChangeListenerBridge {
    void onAccessibilityStateChanged(boolean param1Boolean);
  }
  
  public static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
    Object mListener;
    
    AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge mListenerBridge;
    
    public AccessibilityStateChangeListenerWrapper(Object param1Object, AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge param1AccessibilityStateChangeListenerBridge) {
      this.mListener = param1Object;
      this.mListenerBridge = param1AccessibilityStateChangeListenerBridge;
    }
    
    public boolean equals(Object param1Object) {
      if (this != param1Object) {
        if (param1Object == null || getClass() != param1Object.getClass())
          return false; 
        param1Object = param1Object;
        return (this.mListener == null) ? (!(((AccessibilityStateChangeListenerWrapper)param1Object).mListener != null)) : this.mListener.equals(((AccessibilityStateChangeListenerWrapper)param1Object).mListener);
      } 
      return true;
    }
    
    public int hashCode() {
      return (this.mListener == null) ? 0 : this.mListener.hashCode();
    }
    
    public void onAccessibilityStateChanged(boolean param1Boolean) {
      this.mListenerBridge.onAccessibilityStateChanged(param1Boolean);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityManagerCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */