package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public final class ViewGroupCompat {
  static final ViewGroupCompatImpl IMPL = new ViewGroupCompatStubImpl();
  
  public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
  
  public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
  
  public static int getLayoutMode(ViewGroup paramViewGroup) {
    return IMPL.getLayoutMode(paramViewGroup);
  }
  
  public static int getNestedScrollAxes(ViewGroup paramViewGroup) {
    return IMPL.getNestedScrollAxes(paramViewGroup);
  }
  
  public static boolean isTransitionGroup(ViewGroup paramViewGroup) {
    return IMPL.isTransitionGroup(paramViewGroup);
  }
  
  public static boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return IMPL.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public static void setLayoutMode(ViewGroup paramViewGroup, int paramInt) {
    IMPL.setLayoutMode(paramViewGroup, paramInt);
  }
  
  public static void setMotionEventSplittingEnabled(ViewGroup paramViewGroup, boolean paramBoolean) {
    IMPL.setMotionEventSplittingEnabled(paramViewGroup, paramBoolean);
  }
  
  public static void setTransitionGroup(ViewGroup paramViewGroup, boolean paramBoolean) {
    IMPL.setTransitionGroup(paramViewGroup, paramBoolean);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      IMPL = new ViewGroupCompatLollipopImpl();
      return;
    } 
    if (i >= 18) {
      IMPL = new ViewGroupCompatJellybeanMR2Impl();
      return;
    } 
    if (i >= 14) {
      IMPL = new ViewGroupCompatIcsImpl();
      return;
    } 
    if (i >= 11) {
      IMPL = new ViewGroupCompatHCImpl();
      return;
    } 
  }
  
  static class ViewGroupCompatHCImpl extends ViewGroupCompatStubImpl {
    public void setMotionEventSplittingEnabled(ViewGroup param1ViewGroup, boolean param1Boolean) {
      ViewGroupCompatHC.setMotionEventSplittingEnabled(param1ViewGroup, param1Boolean);
    }
  }
  
  static class ViewGroupCompatIcsImpl extends ViewGroupCompatHCImpl {
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent);
    }
  }
  
  static interface ViewGroupCompatImpl {
    int getLayoutMode(ViewGroup param1ViewGroup);
    
    int getNestedScrollAxes(ViewGroup param1ViewGroup);
    
    boolean isTransitionGroup(ViewGroup param1ViewGroup);
    
    boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent);
    
    void setLayoutMode(ViewGroup param1ViewGroup, int param1Int);
    
    void setMotionEventSplittingEnabled(ViewGroup param1ViewGroup, boolean param1Boolean);
    
    void setTransitionGroup(ViewGroup param1ViewGroup, boolean param1Boolean);
  }
  
  static class ViewGroupCompatJellybeanMR2Impl extends ViewGroupCompatIcsImpl {
    public int getLayoutMode(ViewGroup param1ViewGroup) {
      return ViewGroupCompatJellybeanMR2.getLayoutMode(param1ViewGroup);
    }
    
    public void setLayoutMode(ViewGroup param1ViewGroup, int param1Int) {
      ViewGroupCompatJellybeanMR2.setLayoutMode(param1ViewGroup, param1Int);
    }
  }
  
  static class ViewGroupCompatLollipopImpl extends ViewGroupCompatJellybeanMR2Impl {
    public int getNestedScrollAxes(ViewGroup param1ViewGroup) {
      return ViewGroupCompatLollipop.getNestedScrollAxes(param1ViewGroup);
    }
    
    public boolean isTransitionGroup(ViewGroup param1ViewGroup) {
      return ViewGroupCompatLollipop.isTransitionGroup(param1ViewGroup);
    }
    
    public void setTransitionGroup(ViewGroup param1ViewGroup, boolean param1Boolean) {
      ViewGroupCompatLollipop.setTransitionGroup(param1ViewGroup, param1Boolean);
    }
  }
  
  static class ViewGroupCompatStubImpl implements ViewGroupCompatImpl {
    public int getLayoutMode(ViewGroup param1ViewGroup) {
      return 0;
    }
    
    public int getNestedScrollAxes(ViewGroup param1ViewGroup) {
      return (param1ViewGroup instanceof NestedScrollingParent) ? ((NestedScrollingParent)param1ViewGroup).getNestedScrollAxes() : 0;
    }
    
    public boolean isTransitionGroup(ViewGroup param1ViewGroup) {
      return false;
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return true;
    }
    
    public void setLayoutMode(ViewGroup param1ViewGroup, int param1Int) {}
    
    public void setMotionEventSplittingEnabled(ViewGroup param1ViewGroup, boolean param1Boolean) {}
    
    public void setTransitionGroup(ViewGroup param1ViewGroup, boolean param1Boolean) {}
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewGroupCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */