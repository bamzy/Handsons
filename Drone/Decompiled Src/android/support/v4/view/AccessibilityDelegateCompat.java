package android.support.v4.view;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityDelegateCompat {
  private static final Object DEFAULT_DELEGATE = IMPL.newAccessiblityDelegateDefaultImpl();
  
  private static final AccessibilityDelegateImpl IMPL;
  
  final Object mBridge = IMPL.newAccessiblityDelegateBridge(this);
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, paramView, paramAccessibilityEvent);
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView) {
    return IMPL.getAccessibilityNodeProvider(DEFAULT_DELEGATE, paramView);
  }
  
  Object getBridge() {
    return this.mBridge;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, paramView, paramAccessibilityNodeInfoCompat);
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle) {
    return IMPL.performAccessibilityAction(DEFAULT_DELEGATE, paramView, paramInt, paramBundle);
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt) {
    IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, paramView, paramInt);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, paramView, paramAccessibilityEvent);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new AccessibilityDelegateJellyBeanImpl();
    } else if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new AccessibilityDelegateIcsImpl();
    } else {
      IMPL = new AccessibilityDelegateStubImpl();
    } 
  }
  
  static class AccessibilityDelegateIcsImpl extends AccessibilityDelegateStubImpl {
    public boolean dispatchPopulateAccessibilityEvent(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(param1Object, param1View, param1AccessibilityEvent);
    }
    
    public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat compat) {
      return AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(new AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge() {
            public boolean dispatchPopulateAccessibilityEvent(View param2View, AccessibilityEvent param2AccessibilityEvent) {
              return compat.dispatchPopulateAccessibilityEvent(param2View, param2AccessibilityEvent);
            }
            
            public void onInitializeAccessibilityEvent(View param2View, AccessibilityEvent param2AccessibilityEvent) {
              compat.onInitializeAccessibilityEvent(param2View, param2AccessibilityEvent);
            }
            
            public void onInitializeAccessibilityNodeInfo(View param2View, Object param2Object) {
              compat.onInitializeAccessibilityNodeInfo(param2View, new AccessibilityNodeInfoCompat(param2Object));
            }
            
            public void onPopulateAccessibilityEvent(View param2View, AccessibilityEvent param2AccessibilityEvent) {
              compat.onPopulateAccessibilityEvent(param2View, param2AccessibilityEvent);
            }
            
            public boolean onRequestSendAccessibilityEvent(ViewGroup param2ViewGroup, View param2View, AccessibilityEvent param2AccessibilityEvent) {
              return compat.onRequestSendAccessibilityEvent(param2ViewGroup, param2View, param2AccessibilityEvent);
            }
            
            public void sendAccessibilityEvent(View param2View, int param2Int) {
              compat.sendAccessibilityEvent(param2View, param2Int);
            }
            
            public void sendAccessibilityEventUnchecked(View param2View, AccessibilityEvent param2AccessibilityEvent) {
              compat.sendAccessibilityEventUnchecked(param2View, param2AccessibilityEvent);
            }
          });
    }
    
    public Object newAccessiblityDelegateDefaultImpl() {
      return AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
    }
    
    public void onInitializeAccessibilityEvent(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(param1Object, param1View, param1AccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(Object param1Object, View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(param1Object, param1View, param1AccessibilityNodeInfoCompat.getInfo());
    }
    
    public void onPopulateAccessibilityEvent(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(param1Object, param1View, param1AccessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(Object param1Object, ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(param1Object, param1ViewGroup, param1View, param1AccessibilityEvent);
    }
    
    public void sendAccessibilityEvent(Object param1Object, View param1View, int param1Int) {
      AccessibilityDelegateCompatIcs.sendAccessibilityEvent(param1Object, param1View, param1Int);
    }
    
    public void sendAccessibilityEventUnchecked(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(param1Object, param1View, param1AccessibilityEvent);
    }
  }
  
  class null implements AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge {
    public boolean dispatchPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return compat.dispatchPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      compat.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, Object param1Object) {
      compat.onInitializeAccessibilityNodeInfo(param1View, new AccessibilityNodeInfoCompat(param1Object));
    }
    
    public void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      compat.onPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return compat.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent);
    }
    
    public void sendAccessibilityEvent(View param1View, int param1Int) {
      compat.sendAccessibilityEvent(param1View, param1Int);
    }
    
    public void sendAccessibilityEventUnchecked(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      compat.sendAccessibilityEventUnchecked(param1View, param1AccessibilityEvent);
    }
  }
  
  static interface AccessibilityDelegateImpl {
    boolean dispatchPopulateAccessibilityEvent(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object param1Object, View param1View);
    
    Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat param1AccessibilityDelegateCompat);
    
    Object newAccessiblityDelegateDefaultImpl();
    
    void onInitializeAccessibilityEvent(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    void onInitializeAccessibilityNodeInfo(Object param1Object, View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat);
    
    void onPopulateAccessibilityEvent(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    boolean onRequestSendAccessibilityEvent(Object param1Object, ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    boolean performAccessibilityAction(Object param1Object, View param1View, int param1Int, Bundle param1Bundle);
    
    void sendAccessibilityEvent(Object param1Object, View param1View, int param1Int);
    
    void sendAccessibilityEventUnchecked(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent);
  }
  
  static class AccessibilityDelegateJellyBeanImpl extends AccessibilityDelegateIcsImpl {
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object param1Object, View param1View) {
      param1Object = AccessibilityDelegateCompatJellyBean.getAccessibilityNodeProvider(param1Object, param1View);
      return (param1Object != null) ? new AccessibilityNodeProviderCompat(param1Object) : null;
    }
    
    public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat compat) {
      return AccessibilityDelegateCompatJellyBean.newAccessibilityDelegateBridge(new AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean() {
            public boolean dispatchPopulateAccessibilityEvent(View param2View, AccessibilityEvent param2AccessibilityEvent) {
              return compat.dispatchPopulateAccessibilityEvent(param2View, param2AccessibilityEvent);
            }
            
            public Object getAccessibilityNodeProvider(View param2View) {
              AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = compat.getAccessibilityNodeProvider(param2View);
              return (accessibilityNodeProviderCompat != null) ? accessibilityNodeProviderCompat.getProvider() : null;
            }
            
            public void onInitializeAccessibilityEvent(View param2View, AccessibilityEvent param2AccessibilityEvent) {
              compat.onInitializeAccessibilityEvent(param2View, param2AccessibilityEvent);
            }
            
            public void onInitializeAccessibilityNodeInfo(View param2View, Object param2Object) {
              compat.onInitializeAccessibilityNodeInfo(param2View, new AccessibilityNodeInfoCompat(param2Object));
            }
            
            public void onPopulateAccessibilityEvent(View param2View, AccessibilityEvent param2AccessibilityEvent) {
              compat.onPopulateAccessibilityEvent(param2View, param2AccessibilityEvent);
            }
            
            public boolean onRequestSendAccessibilityEvent(ViewGroup param2ViewGroup, View param2View, AccessibilityEvent param2AccessibilityEvent) {
              return compat.onRequestSendAccessibilityEvent(param2ViewGroup, param2View, param2AccessibilityEvent);
            }
            
            public boolean performAccessibilityAction(View param2View, int param2Int, Bundle param2Bundle) {
              return compat.performAccessibilityAction(param2View, param2Int, param2Bundle);
            }
            
            public void sendAccessibilityEvent(View param2View, int param2Int) {
              compat.sendAccessibilityEvent(param2View, param2Int);
            }
            
            public void sendAccessibilityEventUnchecked(View param2View, AccessibilityEvent param2AccessibilityEvent) {
              compat.sendAccessibilityEventUnchecked(param2View, param2AccessibilityEvent);
            }
          });
    }
    
    public boolean performAccessibilityAction(Object param1Object, View param1View, int param1Int, Bundle param1Bundle) {
      return AccessibilityDelegateCompatJellyBean.performAccessibilityAction(param1Object, param1View, param1Int, param1Bundle);
    }
  }
  
  class null implements AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean {
    public boolean dispatchPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return compat.dispatchPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public Object getAccessibilityNodeProvider(View param1View) {
      AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = compat.getAccessibilityNodeProvider(param1View);
      return (accessibilityNodeProviderCompat != null) ? accessibilityNodeProviderCompat.getProvider() : null;
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      compat.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, Object param1Object) {
      compat.onInitializeAccessibilityNodeInfo(param1View, new AccessibilityNodeInfoCompat(param1Object));
    }
    
    public void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      compat.onPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return compat.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent);
    }
    
    public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) {
      return compat.performAccessibilityAction(param1View, param1Int, param1Bundle);
    }
    
    public void sendAccessibilityEvent(View param1View, int param1Int) {
      compat.sendAccessibilityEvent(param1View, param1Int);
    }
    
    public void sendAccessibilityEventUnchecked(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      compat.sendAccessibilityEventUnchecked(param1View, param1AccessibilityEvent);
    }
  }
  
  static class AccessibilityDelegateStubImpl implements AccessibilityDelegateImpl {
    public boolean dispatchPopulateAccessibilityEvent(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return false;
    }
    
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object param1Object, View param1View) {
      return null;
    }
    
    public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat param1AccessibilityDelegateCompat) {
      return null;
    }
    
    public Object newAccessiblityDelegateDefaultImpl() {
      return null;
    }
    
    public void onInitializeAccessibilityEvent(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent) {}
    
    public void onInitializeAccessibilityNodeInfo(Object param1Object, View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {}
    
    public void onPopulateAccessibilityEvent(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent) {}
    
    public boolean onRequestSendAccessibilityEvent(Object param1Object, ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return true;
    }
    
    public boolean performAccessibilityAction(Object param1Object, View param1View, int param1Int, Bundle param1Bundle) {
      return false;
    }
    
    public void sendAccessibilityEvent(Object param1Object, View param1View, int param1Int) {}
    
    public void sendAccessibilityEventUnchecked(Object param1Object, View param1View, AccessibilityEvent param1AccessibilityEvent) {}
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\AccessibilityDelegateCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */