package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityManager;

@TargetApi(19)
@RequiresApi(19)
class AccessibilityManagerCompatKitKat {
  public static boolean addTouchExplorationStateChangeListener(AccessibilityManager paramAccessibilityManager, Object paramObject) {
    return paramAccessibilityManager.addTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)paramObject);
  }
  
  public static Object newTouchExplorationStateChangeListener(final TouchExplorationStateChangeListenerBridge bridge) {
    return new AccessibilityManager.TouchExplorationStateChangeListener() {
        public void onTouchExplorationStateChanged(boolean param1Boolean) {
          bridge.onTouchExplorationStateChanged(param1Boolean);
        }
      };
  }
  
  public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager paramAccessibilityManager, Object paramObject) {
    return paramAccessibilityManager.removeTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)paramObject);
  }
  
  static interface TouchExplorationStateChangeListenerBridge {
    void onTouchExplorationStateChanged(boolean param1Boolean);
  }
  
  public static class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
    final Object mListener;
    
    final AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerBridge mListenerBridge;
    
    public TouchExplorationStateChangeListenerWrapper(Object param1Object, AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerBridge param1TouchExplorationStateChangeListenerBridge) {
      this.mListener = param1Object;
      this.mListenerBridge = param1TouchExplorationStateChangeListenerBridge;
    }
    
    public boolean equals(Object param1Object) {
      if (this != param1Object) {
        if (param1Object == null || getClass() != param1Object.getClass())
          return false; 
        param1Object = param1Object;
        return (this.mListener == null) ? (!(((TouchExplorationStateChangeListenerWrapper)param1Object).mListener != null)) : this.mListener.equals(((TouchExplorationStateChangeListenerWrapper)param1Object).mListener);
      } 
      return true;
    }
    
    public int hashCode() {
      return (this.mListener == null) ? 0 : this.mListener.hashCode();
    }
    
    public void onTouchExplorationStateChanged(boolean param1Boolean) {
      this.mListenerBridge.onTouchExplorationStateChanged(param1Boolean);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityManagerCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */