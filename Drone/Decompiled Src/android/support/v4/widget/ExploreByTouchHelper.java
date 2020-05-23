package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
  private static final String DEFAULT_CLASS_NAME = "android.view.View";
  
  public static final int HOST_ID = -1;
  
  public static final int INVALID_ID = -2147483648;
  
  private static final Rect INVALID_PARENT_BOUNDS = new Rect(2147483647, 2147483647, -2147483648, -2147483648);
  
  private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() {
      public void obtainBounds(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat, Rect param1Rect) {
        param1AccessibilityNodeInfoCompat.getBoundsInParent(param1Rect);
      }
    };
  
  private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() {
      public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> param1SparseArrayCompat, int param1Int) {
        return (AccessibilityNodeInfoCompat)param1SparseArrayCompat.valueAt(param1Int);
      }
      
      public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> param1SparseArrayCompat) {
        return param1SparseArrayCompat.size();
      }
    };
  
  private int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
  
  private final View mHost;
  
  private int mHoveredVirtualViewId = Integer.MIN_VALUE;
  
  private int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
  
  private final AccessibilityManager mManager;
  
  private MyNodeProvider mNodeProvider;
  
  private final int[] mTempGlobalRect = new int[2];
  
  private final Rect mTempParentRect = new Rect();
  
  private final Rect mTempScreenRect = new Rect();
  
  private final Rect mTempVisibleRect = new Rect();
  
  public ExploreByTouchHelper(View paramView) {
    if (paramView == null)
      throw new IllegalArgumentException("View may not be null"); 
    this.mHost = paramView;
    this.mManager = (AccessibilityManager)paramView.getContext().getSystemService("accessibility");
    paramView.setFocusable(true);
    if (ViewCompat.getImportantForAccessibility(paramView) == 0)
      ViewCompat.setImportantForAccessibility(paramView, 1); 
  }
  
  private boolean clearAccessibilityFocus(int paramInt) {
    if (this.mAccessibilityFocusedVirtualViewId == paramInt) {
      this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
      this.mHost.invalidate();
      sendEventForVirtualView(paramInt, 65536);
      return true;
    } 
    return false;
  }
  
  private boolean clickKeyboardFocusedVirtualView() {
    return (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE && onPerformActionForVirtualView(this.mKeyboardFocusedVirtualViewId, 16, null));
  }
  
  private AccessibilityEvent createEvent(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      default:
        return createEventForChild(paramInt1, paramInt2);
      case -1:
        break;
    } 
    return createEventForHost(paramInt2);
  }
  
  private AccessibilityEvent createEventForChild(int paramInt1, int paramInt2) {
    AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    AccessibilityRecordCompat accessibilityRecordCompat = AccessibilityEventCompat.asRecord(accessibilityEvent);
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = obtainAccessibilityNodeInfo(paramInt1);
    accessibilityRecordCompat.getText().add(accessibilityNodeInfoCompat.getText());
    accessibilityRecordCompat.setContentDescription(accessibilityNodeInfoCompat.getContentDescription());
    accessibilityRecordCompat.setScrollable(accessibilityNodeInfoCompat.isScrollable());
    accessibilityRecordCompat.setPassword(accessibilityNodeInfoCompat.isPassword());
    accessibilityRecordCompat.setEnabled(accessibilityNodeInfoCompat.isEnabled());
    accessibilityRecordCompat.setChecked(accessibilityNodeInfoCompat.isChecked());
    onPopulateEventForVirtualView(paramInt1, accessibilityEvent);
    if (accessibilityEvent.getText().isEmpty() && accessibilityEvent.getContentDescription() == null)
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()"); 
    accessibilityRecordCompat.setClassName(accessibilityNodeInfoCompat.getClassName());
    accessibilityRecordCompat.setSource(this.mHost, paramInt1);
    accessibilityEvent.setPackageName(this.mHost.getContext().getPackageName());
    return accessibilityEvent;
  }
  
  private AccessibilityEvent createEventForHost(int paramInt) {
    AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain(paramInt);
    ViewCompat.onInitializeAccessibilityEvent(this.mHost, accessibilityEvent);
    return accessibilityEvent;
  }
  
  @NonNull
  private AccessibilityNodeInfoCompat createNodeForChild(int paramInt) {
    boolean bool;
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    accessibilityNodeInfoCompat.setEnabled(true);
    accessibilityNodeInfoCompat.setFocusable(true);
    accessibilityNodeInfoCompat.setClassName("android.view.View");
    accessibilityNodeInfoCompat.setBoundsInParent(INVALID_PARENT_BOUNDS);
    accessibilityNodeInfoCompat.setBoundsInScreen(INVALID_PARENT_BOUNDS);
    accessibilityNodeInfoCompat.setParent(this.mHost);
    onPopulateNodeForVirtualView(paramInt, accessibilityNodeInfoCompat);
    if (accessibilityNodeInfoCompat.getText() == null && accessibilityNodeInfoCompat.getContentDescription() == null)
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()"); 
    accessibilityNodeInfoCompat.getBoundsInParent(this.mTempParentRect);
    if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS))
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()"); 
    int i = accessibilityNodeInfoCompat.getActions();
    if ((i & 0x40) != 0)
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()"); 
    if ((i & 0x80) != 0)
      throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()"); 
    accessibilityNodeInfoCompat.setPackageName(this.mHost.getContext().getPackageName());
    accessibilityNodeInfoCompat.setSource(this.mHost, paramInt);
    if (this.mAccessibilityFocusedVirtualViewId == paramInt) {
      accessibilityNodeInfoCompat.setAccessibilityFocused(true);
      accessibilityNodeInfoCompat.addAction(128);
    } else {
      accessibilityNodeInfoCompat.setAccessibilityFocused(false);
      accessibilityNodeInfoCompat.addAction(64);
    } 
    if (this.mKeyboardFocusedVirtualViewId == paramInt) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      accessibilityNodeInfoCompat.addAction(2);
    } else if (accessibilityNodeInfoCompat.isFocusable()) {
      accessibilityNodeInfoCompat.addAction(1);
    } 
    accessibilityNodeInfoCompat.setFocused(bool);
    this.mHost.getLocationOnScreen(this.mTempGlobalRect);
    accessibilityNodeInfoCompat.getBoundsInScreen(this.mTempScreenRect);
    if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
      accessibilityNodeInfoCompat.getBoundsInParent(this.mTempScreenRect);
      if (accessibilityNodeInfoCompat.mParentVirtualDescendantId != -1) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat1 = AccessibilityNodeInfoCompat.obtain();
        for (paramInt = accessibilityNodeInfoCompat.mParentVirtualDescendantId; paramInt != -1; paramInt = accessibilityNodeInfoCompat1.mParentVirtualDescendantId) {
          accessibilityNodeInfoCompat1.setParent(this.mHost, -1);
          accessibilityNodeInfoCompat1.setBoundsInParent(INVALID_PARENT_BOUNDS);
          onPopulateNodeForVirtualView(paramInt, accessibilityNodeInfoCompat1);
          accessibilityNodeInfoCompat1.getBoundsInParent(this.mTempParentRect);
          this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
        } 
        accessibilityNodeInfoCompat1.recycle();
      } 
      this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
    } 
    if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
      this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
      this.mTempScreenRect.intersect(this.mTempVisibleRect);
      accessibilityNodeInfoCompat.setBoundsInScreen(this.mTempScreenRect);
      if (isVisibleToUser(this.mTempScreenRect))
        accessibilityNodeInfoCompat.setVisibleToUser(true); 
    } 
    return accessibilityNodeInfoCompat;
  }
  
  @NonNull
  private AccessibilityNodeInfoCompat createNodeForHost() {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(this.mHost);
    ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, accessibilityNodeInfoCompat);
    ArrayList<Integer> arrayList = new ArrayList();
    getVisibleVirtualViews(arrayList);
    if (accessibilityNodeInfoCompat.getChildCount() > 0 && arrayList.size() > 0)
      throw new RuntimeException("Views cannot have both real and virtual children"); 
    int i = 0;
    int j = arrayList.size();
    while (i < j) {
      accessibilityNodeInfoCompat.addChild(this.mHost, ((Integer)arrayList.get(i)).intValue());
      i++;
    } 
    return accessibilityNodeInfoCompat;
  }
  
  private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
    ArrayList<Integer> arrayList = new ArrayList();
    getVisibleVirtualViews(arrayList);
    SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat();
    for (int i = 0; i < arrayList.size(); i++)
      sparseArrayCompat.put(i, createNodeForChild(i)); 
    return sparseArrayCompat;
  }
  
  private void getBoundsInParent(int paramInt, Rect paramRect) {
    obtainAccessibilityNodeInfo(paramInt).getBoundsInParent(paramRect);
  }
  
  private static Rect guessPreviouslyFocusedRect(@NonNull View paramView, int paramInt, @NonNull Rect paramRect) {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
        paramRect.set(i, 0, i, j);
        return paramRect;
      case 33:
        paramRect.set(0, j, i, j);
        return paramRect;
      case 66:
        paramRect.set(-1, 0, -1, j);
        return paramRect;
      case 130:
        break;
    } 
    paramRect.set(0, -1, i, -1);
    return paramRect;
  }
  
  private boolean isVisibleToUser(Rect paramRect) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 11
    //   4: aload_1
    //   5: invokevirtual isEmpty : ()Z
    //   8: ifeq -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: getfield mHost : Landroid/view/View;
    //   17: invokevirtual getWindowVisibility : ()I
    //   20: ifne -> 11
    //   23: aload_0
    //   24: getfield mHost : Landroid/view/View;
    //   27: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   30: astore_1
    //   31: aload_1
    //   32: instanceof android/view/View
    //   35: ifeq -> 67
    //   38: aload_1
    //   39: checkcast android/view/View
    //   42: astore_1
    //   43: aload_1
    //   44: invokestatic getAlpha : (Landroid/view/View;)F
    //   47: fconst_0
    //   48: fcmpg
    //   49: ifle -> 11
    //   52: aload_1
    //   53: invokevirtual getVisibility : ()I
    //   56: ifne -> 11
    //   59: aload_1
    //   60: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   63: astore_1
    //   64: goto -> 31
    //   67: aload_1
    //   68: ifnull -> 11
    //   71: iconst_1
    //   72: ireturn
  }
  
  private static int keyToDirection(int paramInt) {
    switch (paramInt) {
      default:
        return 130;
      case 21:
        return 17;
      case 19:
        return 33;
      case 22:
        break;
    } 
    return 66;
  }
  
  private boolean moveFocus(int paramInt, @Nullable Rect paramRect) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat1;
    boolean bool;
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
    Rect rect;
    SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = getAllNodes();
    int i = this.mKeyboardFocusedVirtualViewId;
    if (i == Integer.MIN_VALUE) {
      accessibilityNodeInfoCompat2 = null;
    } else {
      accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat)sparseArrayCompat.get(i);
    } 
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 1:
      case 2:
        if (ViewCompat.getLayoutDirection(this.mHost) == 1) {
          bool = true;
        } else {
          bool = false;
        } 
        accessibilityNodeInfoCompat1 = FocusStrategy.<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>findNextFocusInRelativeDirection(sparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat2, paramInt, bool, false);
        if (accessibilityNodeInfoCompat1 == null) {
          paramInt = Integer.MIN_VALUE;
          return requestKeyboardFocusForVirtualView(paramInt);
        } 
        break;
      case 17:
      case 33:
      case 66:
      case 130:
        rect = new Rect();
        if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
          getBoundsInParent(this.mKeyboardFocusedVirtualViewId, rect);
        } else if (accessibilityNodeInfoCompat1 != null) {
          rect.set((Rect)accessibilityNodeInfoCompat1);
        } else {
          guessPreviouslyFocusedRect(this.mHost, paramInt, rect);
        } 
        accessibilityNodeInfoCompat1 = FocusStrategy.<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>findNextFocusInAbsoluteDirection(sparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat2, rect, paramInt);
        if (accessibilityNodeInfoCompat1 == null) {
          paramInt = Integer.MIN_VALUE;
          return requestKeyboardFocusForVirtualView(paramInt);
        } 
        break;
    } 
    paramInt = sparseArrayCompat.keyAt(sparseArrayCompat.indexOfValue(accessibilityNodeInfoCompat1));
    return requestKeyboardFocusForVirtualView(paramInt);
  }
  
  private boolean performActionForChild(int paramInt1, int paramInt2, Bundle paramBundle) {
    switch (paramInt2) {
      default:
        return onPerformActionForVirtualView(paramInt1, paramInt2, paramBundle);
      case 64:
        return requestAccessibilityFocus(paramInt1);
      case 128:
        return clearAccessibilityFocus(paramInt1);
      case 1:
        return requestKeyboardFocusForVirtualView(paramInt1);
      case 2:
        break;
    } 
    return clearKeyboardFocusForVirtualView(paramInt1);
  }
  
  private boolean performActionForHost(int paramInt, Bundle paramBundle) {
    return ViewCompat.performAccessibilityAction(this.mHost, paramInt, paramBundle);
  }
  
  private boolean requestAccessibilityFocus(int paramInt) {
    if (this.mManager.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager) && this.mAccessibilityFocusedVirtualViewId != paramInt) {
      if (this.mAccessibilityFocusedVirtualViewId != Integer.MIN_VALUE)
        clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId); 
      this.mAccessibilityFocusedVirtualViewId = paramInt;
      this.mHost.invalidate();
      sendEventForVirtualView(paramInt, 32768);
      return true;
    } 
    return false;
  }
  
  private void updateHoveredVirtualView(int paramInt) {
    if (this.mHoveredVirtualViewId == paramInt)
      return; 
    int i = this.mHoveredVirtualViewId;
    this.mHoveredVirtualViewId = paramInt;
    sendEventForVirtualView(paramInt, 128);
    sendEventForVirtualView(i, 256);
  }
  
  public final boolean clearKeyboardFocusForVirtualView(int paramInt) {
    if (this.mKeyboardFocusedVirtualViewId != paramInt)
      return false; 
    this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    onVirtualViewKeyboardFocusChanged(paramInt, false);
    sendEventForVirtualView(paramInt, 8);
    return true;
  }
  
  public final boolean dispatchHoverEvent(@NonNull MotionEvent paramMotionEvent) {
    boolean bool = true;
    if (this.mManager.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) {
      int i;
      switch (paramMotionEvent.getAction()) {
        default:
          return false;
        case 7:
        case 9:
          i = getVirtualViewAt(paramMotionEvent.getX(), paramMotionEvent.getY());
          updateHoveredVirtualView(i);
          if (i == Integer.MIN_VALUE)
            bool = false; 
          return bool;
        case 10:
          break;
      } 
      if (this.mAccessibilityFocusedVirtualViewId != Integer.MIN_VALUE) {
        updateHoveredVirtualView(-2147483648);
        return true;
      } 
    } 
    return false;
  }
  
  public final boolean dispatchKeyEvent(@NonNull KeyEvent paramKeyEvent) {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramKeyEvent.getAction() != 1) {
      int i = paramKeyEvent.getKeyCode();
      switch (i) {
        default:
          return bool1;
        case 19:
        case 20:
        case 21:
        case 22:
          bool2 = bool1;
          if (KeyEventCompat.hasNoModifiers(paramKeyEvent)) {
            int j = keyToDirection(i);
            int k = paramKeyEvent.getRepeatCount();
            i = 0;
            bool1 = bool3;
            while (true) {
              bool2 = bool1;
              if (i < k + 1) {
                bool2 = bool1;
                if (moveFocus(j, null)) {
                  bool1 = true;
                  i++;
                  continue;
                } 
              } 
              return bool2;
            } 
          } 
          return bool2;
        case 23:
        case 66:
          bool2 = bool1;
          if (KeyEventCompat.hasNoModifiers(paramKeyEvent)) {
            bool2 = bool1;
            if (paramKeyEvent.getRepeatCount() == 0) {
              clickKeyboardFocusedVirtualView();
              return true;
            } 
          } 
          return bool2;
        case 61:
          break;
      } 
    } else {
      return bool2;
    } 
    if (KeyEventCompat.hasNoModifiers(paramKeyEvent))
      return moveFocus(2, null); 
    bool2 = bool1;
    return KeyEventCompat.hasModifiers(paramKeyEvent, 1) ? moveFocus(1, null) : bool2;
  }
  
  public final int getAccessibilityFocusedVirtualViewId() {
    return this.mAccessibilityFocusedVirtualViewId;
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView) {
    if (this.mNodeProvider == null)
      this.mNodeProvider = new MyNodeProvider(); 
    return this.mNodeProvider;
  }
  
  @Deprecated
  public int getFocusedVirtualView() {
    return getAccessibilityFocusedVirtualViewId();
  }
  
  public final int getKeyboardFocusedVirtualViewId() {
    return this.mKeyboardFocusedVirtualViewId;
  }
  
  protected abstract int getVirtualViewAt(float paramFloat1, float paramFloat2);
  
  protected abstract void getVisibleVirtualViews(List<Integer> paramList);
  
  public final void invalidateRoot() {
    invalidateVirtualView(-1, 1);
  }
  
  public final void invalidateVirtualView(int paramInt) {
    invalidateVirtualView(paramInt, 0);
  }
  
  public final void invalidateVirtualView(int paramInt1, int paramInt2) {
    if (paramInt1 != Integer.MIN_VALUE && this.mManager.isEnabled()) {
      ViewParent viewParent = this.mHost.getParent();
      if (viewParent != null) {
        AccessibilityEvent accessibilityEvent = createEvent(paramInt1, 2048);
        AccessibilityEventCompat.setContentChangeTypes(accessibilityEvent, paramInt2);
        ViewParentCompat.requestSendAccessibilityEvent(viewParent, this.mHost, accessibilityEvent);
      } 
    } 
  }
  
  @NonNull
  AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int paramInt) {
    return (paramInt == -1) ? createNodeForHost() : createNodeForChild(paramInt);
  }
  
  public final void onFocusChanged(boolean paramBoolean, int paramInt, @Nullable Rect paramRect) {
    if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE)
      clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId); 
    if (paramBoolean)
      moveFocus(paramInt, paramRect); 
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    onPopulateEventForHost(paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    onPopulateNodeForHost(paramAccessibilityNodeInfoCompat);
  }
  
  protected abstract boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle);
  
  protected void onPopulateEventForHost(AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
  
  protected abstract void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
  
  protected void onVirtualViewKeyboardFocusChanged(int paramInt, boolean paramBoolean) {}
  
  boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle) {
    switch (paramInt1) {
      default:
        return performActionForChild(paramInt1, paramInt2, paramBundle);
      case -1:
        break;
    } 
    return performActionForHost(paramInt2, paramBundle);
  }
  
  public final boolean requestKeyboardFocusForVirtualView(int paramInt) {
    if ((this.mHost.isFocused() || this.mHost.requestFocus()) && this.mKeyboardFocusedVirtualViewId != paramInt) {
      if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE)
        clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId); 
      this.mKeyboardFocusedVirtualViewId = paramInt;
      onVirtualViewKeyboardFocusChanged(paramInt, true);
      sendEventForVirtualView(paramInt, 8);
      return true;
    } 
    return false;
  }
  
  public final boolean sendEventForVirtualView(int paramInt1, int paramInt2) {
    if (paramInt1 != Integer.MIN_VALUE && this.mManager.isEnabled()) {
      ViewParent viewParent = this.mHost.getParent();
      if (viewParent != null) {
        AccessibilityEvent accessibilityEvent = createEvent(paramInt1, paramInt2);
        return ViewParentCompat.requestSendAccessibilityEvent(viewParent, this.mHost, accessibilityEvent);
      } 
    } 
    return false;
  }
  
  private class MyNodeProvider extends AccessibilityNodeProviderCompat {
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int param1Int) {
      return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(param1Int));
    }
    
    public AccessibilityNodeInfoCompat findFocus(int param1Int) {
      if (param1Int == 2) {
        param1Int = ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId;
      } else {
        param1Int = ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
      } 
      return (param1Int == Integer.MIN_VALUE) ? null : createAccessibilityNodeInfo(param1Int);
    }
    
    public boolean performAction(int param1Int1, int param1Int2, Bundle param1Bundle) {
      return ExploreByTouchHelper.this.performAction(param1Int1, param1Int2, param1Bundle);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\ExploreByTouchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */