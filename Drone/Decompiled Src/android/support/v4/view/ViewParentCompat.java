package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

public final class ViewParentCompat {
  static final ViewParentCompatImpl IMPL = new ViewParentCompatStubImpl();
  
  public static void notifySubtreeAccessibilityStateChanged(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt) {
    IMPL.notifySubtreeAccessibilityStateChanged(paramViewParent, paramView1, paramView2, paramInt);
  }
  
  public static boolean onNestedFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return IMPL.onNestedFling(paramViewParent, paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean onNestedPreFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2) {
    return IMPL.onNestedPreFling(paramViewParent, paramView, paramFloat1, paramFloat2);
  }
  
  public static void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    IMPL.onNestedPreScroll(paramViewParent, paramView, paramInt1, paramInt2, paramArrayOfint);
  }
  
  public static void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    IMPL.onNestedScroll(paramViewParent, paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt) {
    IMPL.onNestedScrollAccepted(paramViewParent, paramView1, paramView2, paramInt);
  }
  
  public static boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt) {
    return IMPL.onStartNestedScroll(paramViewParent, paramView1, paramView2, paramInt);
  }
  
  public static void onStopNestedScroll(ViewParent paramViewParent, View paramView) {
    IMPL.onStopNestedScroll(paramViewParent, paramView);
  }
  
  public static boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return IMPL.requestSendAccessibilityEvent(paramViewParent, paramView, paramAccessibilityEvent);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      IMPL = new ViewParentCompatLollipopImpl();
      return;
    } 
    if (i >= 19) {
      IMPL = new ViewParentCompatKitKatImpl();
      return;
    } 
    if (i >= 14) {
      IMPL = new ViewParentCompatICSImpl();
      return;
    } 
  }
  
  static class ViewParentCompatICSImpl extends ViewParentCompatStubImpl {
    public boolean requestSendAccessibilityEvent(ViewParent param1ViewParent, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return ViewParentCompatICS.requestSendAccessibilityEvent(param1ViewParent, param1View, param1AccessibilityEvent);
    }
  }
  
  static interface ViewParentCompatImpl {
    void notifySubtreeAccessibilityStateChanged(ViewParent param1ViewParent, View param1View1, View param1View2, int param1Int);
    
    boolean onNestedFling(ViewParent param1ViewParent, View param1View, float param1Float1, float param1Float2, boolean param1Boolean);
    
    boolean onNestedPreFling(ViewParent param1ViewParent, View param1View, float param1Float1, float param1Float2);
    
    void onNestedPreScroll(ViewParent param1ViewParent, View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfint);
    
    void onNestedScroll(ViewParent param1ViewParent, View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
    
    void onNestedScrollAccepted(ViewParent param1ViewParent, View param1View1, View param1View2, int param1Int);
    
    boolean onStartNestedScroll(ViewParent param1ViewParent, View param1View1, View param1View2, int param1Int);
    
    void onStopNestedScroll(ViewParent param1ViewParent, View param1View);
    
    boolean requestSendAccessibilityEvent(ViewParent param1ViewParent, View param1View, AccessibilityEvent param1AccessibilityEvent);
  }
  
  static class ViewParentCompatKitKatImpl extends ViewParentCompatICSImpl {
    public void notifySubtreeAccessibilityStateChanged(ViewParent param1ViewParent, View param1View1, View param1View2, int param1Int) {
      ViewParentCompatKitKat.notifySubtreeAccessibilityStateChanged(param1ViewParent, param1View1, param1View2, param1Int);
    }
  }
  
  static class ViewParentCompatLollipopImpl extends ViewParentCompatKitKatImpl {
    public boolean onNestedFling(ViewParent param1ViewParent, View param1View, float param1Float1, float param1Float2, boolean param1Boolean) {
      return ViewParentCompatLollipop.onNestedFling(param1ViewParent, param1View, param1Float1, param1Float2, param1Boolean);
    }
    
    public boolean onNestedPreFling(ViewParent param1ViewParent, View param1View, float param1Float1, float param1Float2) {
      return ViewParentCompatLollipop.onNestedPreFling(param1ViewParent, param1View, param1Float1, param1Float2);
    }
    
    public void onNestedPreScroll(ViewParent param1ViewParent, View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfint) {
      ViewParentCompatLollipop.onNestedPreScroll(param1ViewParent, param1View, param1Int1, param1Int2, param1ArrayOfint);
    }
    
    public void onNestedScroll(ViewParent param1ViewParent, View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      ViewParentCompatLollipop.onNestedScroll(param1ViewParent, param1View, param1Int1, param1Int2, param1Int3, param1Int4);
    }
    
    public void onNestedScrollAccepted(ViewParent param1ViewParent, View param1View1, View param1View2, int param1Int) {
      ViewParentCompatLollipop.onNestedScrollAccepted(param1ViewParent, param1View1, param1View2, param1Int);
    }
    
    public boolean onStartNestedScroll(ViewParent param1ViewParent, View param1View1, View param1View2, int param1Int) {
      return ViewParentCompatLollipop.onStartNestedScroll(param1ViewParent, param1View1, param1View2, param1Int);
    }
    
    public void onStopNestedScroll(ViewParent param1ViewParent, View param1View) {
      ViewParentCompatLollipop.onStopNestedScroll(param1ViewParent, param1View);
    }
  }
  
  static class ViewParentCompatStubImpl implements ViewParentCompatImpl {
    public void notifySubtreeAccessibilityStateChanged(ViewParent param1ViewParent, View param1View1, View param1View2, int param1Int) {}
    
    public boolean onNestedFling(ViewParent param1ViewParent, View param1View, float param1Float1, float param1Float2, boolean param1Boolean) {
      return (param1ViewParent instanceof NestedScrollingParent) ? ((NestedScrollingParent)param1ViewParent).onNestedFling(param1View, param1Float1, param1Float2, param1Boolean) : false;
    }
    
    public boolean onNestedPreFling(ViewParent param1ViewParent, View param1View, float param1Float1, float param1Float2) {
      return (param1ViewParent instanceof NestedScrollingParent) ? ((NestedScrollingParent)param1ViewParent).onNestedPreFling(param1View, param1Float1, param1Float2) : false;
    }
    
    public void onNestedPreScroll(ViewParent param1ViewParent, View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfint) {
      if (param1ViewParent instanceof NestedScrollingParent)
        ((NestedScrollingParent)param1ViewParent).onNestedPreScroll(param1View, param1Int1, param1Int2, param1ArrayOfint); 
    }
    
    public void onNestedScroll(ViewParent param1ViewParent, View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      if (param1ViewParent instanceof NestedScrollingParent)
        ((NestedScrollingParent)param1ViewParent).onNestedScroll(param1View, param1Int1, param1Int2, param1Int3, param1Int4); 
    }
    
    public void onNestedScrollAccepted(ViewParent param1ViewParent, View param1View1, View param1View2, int param1Int) {
      if (param1ViewParent instanceof NestedScrollingParent)
        ((NestedScrollingParent)param1ViewParent).onNestedScrollAccepted(param1View1, param1View2, param1Int); 
    }
    
    public boolean onStartNestedScroll(ViewParent param1ViewParent, View param1View1, View param1View2, int param1Int) {
      return (param1ViewParent instanceof NestedScrollingParent) ? ((NestedScrollingParent)param1ViewParent).onStartNestedScroll(param1View1, param1View2, param1Int) : false;
    }
    
    public void onStopNestedScroll(ViewParent param1ViewParent, View param1View) {
      if (param1ViewParent instanceof NestedScrollingParent)
        ((NestedScrollingParent)param1ViewParent).onStopNestedScroll(param1View); 
    }
    
    public boolean requestSendAccessibilityEvent(ViewParent param1ViewParent, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      if (param1View == null)
        return false; 
      ((AccessibilityManager)param1View.getContext().getSystemService("accessibility")).sendAccessibilityEvent(param1AccessibilityEvent);
      return true;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewParentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */