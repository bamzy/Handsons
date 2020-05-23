package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;

public final class AccessibilityManagerCompat {
  private static final AccessibilityManagerVersionImpl IMPL = new AccessibilityManagerStubImpl();
  
  public static boolean addAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityStateChangeListener paramAccessibilityStateChangeListener) {
    return IMPL.addAccessibilityStateChangeListener(paramAccessibilityManager, paramAccessibilityStateChangeListener);
  }
  
  public static boolean addTouchExplorationStateChangeListener(AccessibilityManager paramAccessibilityManager, TouchExplorationStateChangeListener paramTouchExplorationStateChangeListener) {
    return IMPL.addTouchExplorationStateChangeListener(paramAccessibilityManager, paramTouchExplorationStateChangeListener);
  }
  
  public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager, int paramInt) {
    return IMPL.getEnabledAccessibilityServiceList(paramAccessibilityManager, paramInt);
  }
  
  public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager) {
    return IMPL.getInstalledAccessibilityServiceList(paramAccessibilityManager);
  }
  
  public static boolean isTouchExplorationEnabled(AccessibilityManager paramAccessibilityManager) {
    return IMPL.isTouchExplorationEnabled(paramAccessibilityManager);
  }
  
  public static boolean removeAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityStateChangeListener paramAccessibilityStateChangeListener) {
    return IMPL.removeAccessibilityStateChangeListener(paramAccessibilityManager, paramAccessibilityStateChangeListener);
  }
  
  public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager paramAccessibilityManager, TouchExplorationStateChangeListener paramTouchExplorationStateChangeListener) {
    return IMPL.removeTouchExplorationStateChangeListener(paramAccessibilityManager, paramTouchExplorationStateChangeListener);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 19) {
      IMPL = new AccessibilityManagerKitKatImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new AccessibilityManagerIcsImpl();
      return;
    } 
  }
  
  static class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl {
    public boolean addAccessibilityStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListener param1AccessibilityStateChangeListener) {
      return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(param1AccessibilityManager, newAccessibilityStateChangeListener(param1AccessibilityStateChangeListener));
    }
    
    public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager param1AccessibilityManager, int param1Int) {
      return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(param1AccessibilityManager, param1Int);
    }
    
    public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager param1AccessibilityManager) {
      return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(param1AccessibilityManager);
    }
    
    public boolean isTouchExplorationEnabled(AccessibilityManager param1AccessibilityManager) {
      return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(param1AccessibilityManager);
    }
    
    public AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(final AccessibilityManagerCompat.AccessibilityStateChangeListener listener) {
      return new AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerWrapper(listener, new AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge() {
            public void onAccessibilityStateChanged(boolean param2Boolean) {
              listener.onAccessibilityStateChanged(param2Boolean);
            }
          });
    }
    
    public boolean removeAccessibilityStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListener param1AccessibilityStateChangeListener) {
      return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(param1AccessibilityManager, newAccessibilityStateChangeListener(param1AccessibilityStateChangeListener));
    }
  }
  
  class null implements AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge {
    public void onAccessibilityStateChanged(boolean param1Boolean) {
      listener.onAccessibilityStateChanged(param1Boolean);
    }
  }
  
  static class AccessibilityManagerKitKatImpl extends AccessibilityManagerIcsImpl {
    public boolean addTouchExplorationStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.TouchExplorationStateChangeListener param1TouchExplorationStateChangeListener) {
      return AccessibilityManagerCompatKitKat.addTouchExplorationStateChangeListener(param1AccessibilityManager, newTouchExplorationStateChangeListener(param1TouchExplorationStateChangeListener));
    }
    
    public AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(final AccessibilityManagerCompat.TouchExplorationStateChangeListener listener) {
      return new AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerWrapper(listener, new AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerBridge() {
            public void onTouchExplorationStateChanged(boolean param2Boolean) {
              listener.onTouchExplorationStateChanged(param2Boolean);
            }
          });
    }
    
    public boolean removeTouchExplorationStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.TouchExplorationStateChangeListener param1TouchExplorationStateChangeListener) {
      return AccessibilityManagerCompatKitKat.removeTouchExplorationStateChangeListener(param1AccessibilityManager, newTouchExplorationStateChangeListener(param1TouchExplorationStateChangeListener));
    }
  }
  
  class null implements AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerBridge {
    public void onTouchExplorationStateChanged(boolean param1Boolean) {
      listener.onTouchExplorationStateChanged(param1Boolean);
    }
  }
  
  static class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl {
    public boolean addAccessibilityStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListener param1AccessibilityStateChangeListener) {
      return false;
    }
    
    public boolean addTouchExplorationStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.TouchExplorationStateChangeListener param1TouchExplorationStateChangeListener) {
      return false;
    }
    
    public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager param1AccessibilityManager, int param1Int) {
      return Collections.emptyList();
    }
    
    public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager param1AccessibilityManager) {
      return Collections.emptyList();
    }
    
    public boolean isTouchExplorationEnabled(AccessibilityManager param1AccessibilityManager) {
      return false;
    }
    
    public AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(AccessibilityManagerCompat.AccessibilityStateChangeListener param1AccessibilityStateChangeListener) {
      return null;
    }
    
    public AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(AccessibilityManagerCompat.TouchExplorationStateChangeListener param1TouchExplorationStateChangeListener) {
      return null;
    }
    
    public boolean removeAccessibilityStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListener param1AccessibilityStateChangeListener) {
      return false;
    }
    
    public boolean removeTouchExplorationStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.TouchExplorationStateChangeListener param1TouchExplorationStateChangeListener) {
      return false;
    }
  }
  
  static interface AccessibilityManagerVersionImpl {
    boolean addAccessibilityStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListener param1AccessibilityStateChangeListener);
    
    boolean addTouchExplorationStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.TouchExplorationStateChangeListener param1TouchExplorationStateChangeListener);
    
    List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager param1AccessibilityManager, int param1Int);
    
    List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager param1AccessibilityManager);
    
    boolean isTouchExplorationEnabled(AccessibilityManager param1AccessibilityManager);
    
    AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(AccessibilityManagerCompat.AccessibilityStateChangeListener param1AccessibilityStateChangeListener);
    
    AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(AccessibilityManagerCompat.TouchExplorationStateChangeListener param1TouchExplorationStateChangeListener);
    
    boolean removeAccessibilityStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListener param1AccessibilityStateChangeListener);
    
    boolean removeTouchExplorationStateChangeListener(AccessibilityManager param1AccessibilityManager, AccessibilityManagerCompat.TouchExplorationStateChangeListener param1TouchExplorationStateChangeListener);
  }
  
  public static interface AccessibilityStateChangeListener {
    void onAccessibilityStateChanged(boolean param1Boolean);
  }
  
  @Deprecated
  public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {}
  
  public static interface TouchExplorationStateChangeListener {
    void onTouchExplorationStateChanged(boolean param1Boolean);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */