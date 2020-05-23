package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AccessibilityNodeInfoCompat {
  public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
  
  public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
  
  public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
  
  public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
  
  public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
  
  public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
  
  public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
  
  public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
  
  public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
  
  public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
  
  public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
  
  public static final int ACTION_CLEAR_FOCUS = 2;
  
  public static final int ACTION_CLEAR_SELECTION = 8;
  
  public static final int ACTION_CLICK = 16;
  
  public static final int ACTION_COLLAPSE = 524288;
  
  public static final int ACTION_COPY = 16384;
  
  public static final int ACTION_CUT = 65536;
  
  public static final int ACTION_DISMISS = 1048576;
  
  public static final int ACTION_EXPAND = 262144;
  
  public static final int ACTION_FOCUS = 1;
  
  public static final int ACTION_LONG_CLICK = 32;
  
  public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
  
  public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
  
  public static final int ACTION_PASTE = 32768;
  
  public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
  
  public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
  
  public static final int ACTION_SCROLL_BACKWARD = 8192;
  
  public static final int ACTION_SCROLL_FORWARD = 4096;
  
  public static final int ACTION_SELECT = 4;
  
  public static final int ACTION_SET_SELECTION = 131072;
  
  public static final int ACTION_SET_TEXT = 2097152;
  
  public static final int FOCUS_ACCESSIBILITY = 2;
  
  public static final int FOCUS_INPUT = 1;
  
  static final AccessibilityNodeInfoImpl IMPL = new AccessibilityNodeInfoStubImpl();
  
  public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
  
  public static final int MOVEMENT_GRANULARITY_LINE = 4;
  
  public static final int MOVEMENT_GRANULARITY_PAGE = 16;
  
  public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
  
  public static final int MOVEMENT_GRANULARITY_WORD = 2;
  
  private final Object mInfo;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public int mParentVirtualDescendantId = -1;
  
  public AccessibilityNodeInfoCompat(Object paramObject) {
    this.mInfo = paramObject;
  }
  
  private static String getActionSymbolicName(int paramInt) {
    switch (paramInt) {
      default:
        return "ACTION_UNKNOWN";
      case 1:
        return "ACTION_FOCUS";
      case 2:
        return "ACTION_CLEAR_FOCUS";
      case 4:
        return "ACTION_SELECT";
      case 8:
        return "ACTION_CLEAR_SELECTION";
      case 16:
        return "ACTION_CLICK";
      case 32:
        return "ACTION_LONG_CLICK";
      case 64:
        return "ACTION_ACCESSIBILITY_FOCUS";
      case 128:
        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
      case 256:
        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
      case 512:
        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
      case 1024:
        return "ACTION_NEXT_HTML_ELEMENT";
      case 2048:
        return "ACTION_PREVIOUS_HTML_ELEMENT";
      case 4096:
        return "ACTION_SCROLL_FORWARD";
      case 8192:
        return "ACTION_SCROLL_BACKWARD";
      case 65536:
        return "ACTION_CUT";
      case 16384:
        return "ACTION_COPY";
      case 32768:
        return "ACTION_PASTE";
      case 131072:
        break;
    } 
    return "ACTION_SET_SELECTION";
  }
  
  public static AccessibilityNodeInfoCompat obtain() {
    return wrapNonNullInstance(IMPL.obtain());
  }
  
  public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    return wrapNonNullInstance(IMPL.obtain(paramAccessibilityNodeInfoCompat.mInfo));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView) {
    return wrapNonNullInstance(IMPL.obtain(paramView));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView, int paramInt) {
    return wrapNonNullInstance(IMPL.obtain(paramView, paramInt));
  }
  
  static AccessibilityNodeInfoCompat wrapNonNullInstance(Object paramObject) {
    return (paramObject != null) ? new AccessibilityNodeInfoCompat(paramObject) : null;
  }
  
  public void addAction(int paramInt) {
    IMPL.addAction(this.mInfo, paramInt);
  }
  
  public void addAction(AccessibilityActionCompat paramAccessibilityActionCompat) {
    IMPL.addAction(this.mInfo, paramAccessibilityActionCompat.mAction);
  }
  
  public void addChild(View paramView) {
    IMPL.addChild(this.mInfo, paramView);
  }
  
  public void addChild(View paramView, int paramInt) {
    IMPL.addChild(this.mInfo, paramView, paramInt);
  }
  
  public boolean canOpenPopup() {
    return IMPL.canOpenPopup(this.mInfo);
  }
  
  public boolean equals(Object paramObject) {
    if (this != paramObject) {
      if (paramObject == null)
        return false; 
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      if (this.mInfo == null)
        return !(((AccessibilityNodeInfoCompat)paramObject).mInfo != null); 
      if (!this.mInfo.equals(((AccessibilityNodeInfoCompat)paramObject).mInfo))
        return false; 
    } 
    return true;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString) {
    ArrayList<AccessibilityNodeInfoCompat> arrayList = new ArrayList();
    List<Object> list = IMPL.findAccessibilityNodeInfosByText(this.mInfo, paramString);
    int j = list.size();
    for (int i = 0; i < j; i++)
      arrayList.add(new AccessibilityNodeInfoCompat(list.get(i))); 
    return arrayList;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String paramString) {
    List<Object> list = IMPL.findAccessibilityNodeInfosByViewId(this.mInfo, paramString);
    if (list != null) {
      ArrayList<Object> arrayList = new ArrayList();
      Iterator iterator = list.iterator();
      while (true) {
        list = arrayList;
        if (iterator.hasNext()) {
          arrayList.add(new AccessibilityNodeInfoCompat(iterator.next()));
          continue;
        } 
        break;
      } 
    } else {
      list = Collections.emptyList();
    } 
    return (List)list;
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt) {
    return wrapNonNullInstance(IMPL.findFocus(this.mInfo, paramInt));
  }
  
  public AccessibilityNodeInfoCompat focusSearch(int paramInt) {
    return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, paramInt));
  }
  
  public List<AccessibilityActionCompat> getActionList() {
    List<?> list;
    List<Object> list1 = IMPL.getActionList(this.mInfo);
    if (list1 != null) {
      ArrayList<AccessibilityActionCompat> arrayList = new ArrayList();
      int j = list1.size();
      int i = 0;
      while (true) {
        list = arrayList;
        if (i < j) {
          arrayList.add(new AccessibilityActionCompat(list1.get(i)));
          i++;
          continue;
        } 
        break;
      } 
    } else {
      list = Collections.emptyList();
    } 
    return (List)list;
  }
  
  public int getActions() {
    return IMPL.getActions(this.mInfo);
  }
  
  public void getBoundsInParent(Rect paramRect) {
    IMPL.getBoundsInParent(this.mInfo, paramRect);
  }
  
  public void getBoundsInScreen(Rect paramRect) {
    IMPL.getBoundsInScreen(this.mInfo, paramRect);
  }
  
  public AccessibilityNodeInfoCompat getChild(int paramInt) {
    return wrapNonNullInstance(IMPL.getChild(this.mInfo, paramInt));
  }
  
  public int getChildCount() {
    return IMPL.getChildCount(this.mInfo);
  }
  
  public CharSequence getClassName() {
    return IMPL.getClassName(this.mInfo);
  }
  
  public CollectionInfoCompat getCollectionInfo() {
    Object object = IMPL.getCollectionInfo(this.mInfo);
    return (object == null) ? null : new CollectionInfoCompat(object);
  }
  
  public CollectionItemInfoCompat getCollectionItemInfo() {
    Object object = IMPL.getCollectionItemInfo(this.mInfo);
    return (object == null) ? null : new CollectionItemInfoCompat(object);
  }
  
  public CharSequence getContentDescription() {
    return IMPL.getContentDescription(this.mInfo);
  }
  
  public int getDrawingOrder() {
    return IMPL.getDrawingOrder(this.mInfo);
  }
  
  public CharSequence getError() {
    return IMPL.getError(this.mInfo);
  }
  
  public Bundle getExtras() {
    return IMPL.getExtras(this.mInfo);
  }
  
  public Object getInfo() {
    return this.mInfo;
  }
  
  public int getInputType() {
    return IMPL.getInputType(this.mInfo);
  }
  
  public AccessibilityNodeInfoCompat getLabelFor() {
    return wrapNonNullInstance(IMPL.getLabelFor(this.mInfo));
  }
  
  public AccessibilityNodeInfoCompat getLabeledBy() {
    return wrapNonNullInstance(IMPL.getLabeledBy(this.mInfo));
  }
  
  public int getLiveRegion() {
    return IMPL.getLiveRegion(this.mInfo);
  }
  
  public int getMaxTextLength() {
    return IMPL.getMaxTextLength(this.mInfo);
  }
  
  public int getMovementGranularities() {
    return IMPL.getMovementGranularities(this.mInfo);
  }
  
  public CharSequence getPackageName() {
    return IMPL.getPackageName(this.mInfo);
  }
  
  public AccessibilityNodeInfoCompat getParent() {
    return wrapNonNullInstance(IMPL.getParent(this.mInfo));
  }
  
  public RangeInfoCompat getRangeInfo() {
    Object object = IMPL.getRangeInfo(this.mInfo);
    return (object == null) ? null : new RangeInfoCompat(object);
  }
  
  @Nullable
  public CharSequence getRoleDescription() {
    return IMPL.getRoleDescription(this.mInfo);
  }
  
  public CharSequence getText() {
    return IMPL.getText(this.mInfo);
  }
  
  public int getTextSelectionEnd() {
    return IMPL.getTextSelectionEnd(this.mInfo);
  }
  
  public int getTextSelectionStart() {
    return IMPL.getTextSelectionStart(this.mInfo);
  }
  
  public AccessibilityNodeInfoCompat getTraversalAfter() {
    return wrapNonNullInstance(IMPL.getTraversalAfter(this.mInfo));
  }
  
  public AccessibilityNodeInfoCompat getTraversalBefore() {
    return wrapNonNullInstance(IMPL.getTraversalBefore(this.mInfo));
  }
  
  public String getViewIdResourceName() {
    return IMPL.getViewIdResourceName(this.mInfo);
  }
  
  public AccessibilityWindowInfoCompat getWindow() {
    return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getWindow(this.mInfo));
  }
  
  public int getWindowId() {
    return IMPL.getWindowId(this.mInfo);
  }
  
  public int hashCode() {
    return (this.mInfo == null) ? 0 : this.mInfo.hashCode();
  }
  
  public boolean isAccessibilityFocused() {
    return IMPL.isAccessibilityFocused(this.mInfo);
  }
  
  public boolean isCheckable() {
    return IMPL.isCheckable(this.mInfo);
  }
  
  public boolean isChecked() {
    return IMPL.isChecked(this.mInfo);
  }
  
  public boolean isClickable() {
    return IMPL.isClickable(this.mInfo);
  }
  
  public boolean isContentInvalid() {
    return IMPL.isContentInvalid(this.mInfo);
  }
  
  public boolean isContextClickable() {
    return IMPL.isContextClickable(this.mInfo);
  }
  
  public boolean isDismissable() {
    return IMPL.isDismissable(this.mInfo);
  }
  
  public boolean isEditable() {
    return IMPL.isEditable(this.mInfo);
  }
  
  public boolean isEnabled() {
    return IMPL.isEnabled(this.mInfo);
  }
  
  public boolean isFocusable() {
    return IMPL.isFocusable(this.mInfo);
  }
  
  public boolean isFocused() {
    return IMPL.isFocused(this.mInfo);
  }
  
  public boolean isImportantForAccessibility() {
    return IMPL.isImportantForAccessibility(this.mInfo);
  }
  
  public boolean isLongClickable() {
    return IMPL.isLongClickable(this.mInfo);
  }
  
  public boolean isMultiLine() {
    return IMPL.isMultiLine(this.mInfo);
  }
  
  public boolean isPassword() {
    return IMPL.isPassword(this.mInfo);
  }
  
  public boolean isScrollable() {
    return IMPL.isScrollable(this.mInfo);
  }
  
  public boolean isSelected() {
    return IMPL.isSelected(this.mInfo);
  }
  
  public boolean isVisibleToUser() {
    return IMPL.isVisibleToUser(this.mInfo);
  }
  
  public boolean performAction(int paramInt) {
    return IMPL.performAction(this.mInfo, paramInt);
  }
  
  public boolean performAction(int paramInt, Bundle paramBundle) {
    return IMPL.performAction(this.mInfo, paramInt, paramBundle);
  }
  
  public void recycle() {
    IMPL.recycle(this.mInfo);
  }
  
  public boolean refresh() {
    return IMPL.refresh(this.mInfo);
  }
  
  public boolean removeAction(AccessibilityActionCompat paramAccessibilityActionCompat) {
    return IMPL.removeAction(this.mInfo, paramAccessibilityActionCompat.mAction);
  }
  
  public boolean removeChild(View paramView) {
    return IMPL.removeChild(this.mInfo, paramView);
  }
  
  public boolean removeChild(View paramView, int paramInt) {
    return IMPL.removeChild(this.mInfo, paramView, paramInt);
  }
  
  public void setAccessibilityFocused(boolean paramBoolean) {
    IMPL.setAccessibilityFocused(this.mInfo, paramBoolean);
  }
  
  public void setBoundsInParent(Rect paramRect) {
    IMPL.setBoundsInParent(this.mInfo, paramRect);
  }
  
  public void setBoundsInScreen(Rect paramRect) {
    IMPL.setBoundsInScreen(this.mInfo, paramRect);
  }
  
  public void setCanOpenPopup(boolean paramBoolean) {
    IMPL.setCanOpenPopup(this.mInfo, paramBoolean);
  }
  
  public void setCheckable(boolean paramBoolean) {
    IMPL.setCheckable(this.mInfo, paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean) {
    IMPL.setChecked(this.mInfo, paramBoolean);
  }
  
  public void setClassName(CharSequence paramCharSequence) {
    IMPL.setClassName(this.mInfo, paramCharSequence);
  }
  
  public void setClickable(boolean paramBoolean) {
    IMPL.setClickable(this.mInfo, paramBoolean);
  }
  
  public void setCollectionInfo(Object paramObject) {
    IMPL.setCollectionInfo(this.mInfo, ((CollectionInfoCompat)paramObject).mInfo);
  }
  
  public void setCollectionItemInfo(Object paramObject) {
    IMPL.setCollectionItemInfo(this.mInfo, ((CollectionItemInfoCompat)paramObject).mInfo);
  }
  
  public void setContentDescription(CharSequence paramCharSequence) {
    IMPL.setContentDescription(this.mInfo, paramCharSequence);
  }
  
  public void setContentInvalid(boolean paramBoolean) {
    IMPL.setContentInvalid(this.mInfo, paramBoolean);
  }
  
  public void setContextClickable(boolean paramBoolean) {
    IMPL.setContextClickable(this.mInfo, paramBoolean);
  }
  
  public void setDismissable(boolean paramBoolean) {
    IMPL.setDismissable(this.mInfo, paramBoolean);
  }
  
  public void setDrawingOrder(int paramInt) {
    IMPL.setDrawingOrder(this.mInfo, paramInt);
  }
  
  public void setEditable(boolean paramBoolean) {
    IMPL.setEditable(this.mInfo, paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean) {
    IMPL.setEnabled(this.mInfo, paramBoolean);
  }
  
  public void setError(CharSequence paramCharSequence) {
    IMPL.setError(this.mInfo, paramCharSequence);
  }
  
  public void setFocusable(boolean paramBoolean) {
    IMPL.setFocusable(this.mInfo, paramBoolean);
  }
  
  public void setFocused(boolean paramBoolean) {
    IMPL.setFocused(this.mInfo, paramBoolean);
  }
  
  public void setImportantForAccessibility(boolean paramBoolean) {
    IMPL.setImportantForAccessibility(this.mInfo, paramBoolean);
  }
  
  public void setInputType(int paramInt) {
    IMPL.setInputType(this.mInfo, paramInt);
  }
  
  public void setLabelFor(View paramView) {
    IMPL.setLabelFor(this.mInfo, paramView);
  }
  
  public void setLabelFor(View paramView, int paramInt) {
    IMPL.setLabelFor(this.mInfo, paramView, paramInt);
  }
  
  public void setLabeledBy(View paramView) {
    IMPL.setLabeledBy(this.mInfo, paramView);
  }
  
  public void setLabeledBy(View paramView, int paramInt) {
    IMPL.setLabeledBy(this.mInfo, paramView, paramInt);
  }
  
  public void setLiveRegion(int paramInt) {
    IMPL.setLiveRegion(this.mInfo, paramInt);
  }
  
  public void setLongClickable(boolean paramBoolean) {
    IMPL.setLongClickable(this.mInfo, paramBoolean);
  }
  
  public void setMaxTextLength(int paramInt) {
    IMPL.setMaxTextLength(this.mInfo, paramInt);
  }
  
  public void setMovementGranularities(int paramInt) {
    IMPL.setMovementGranularities(this.mInfo, paramInt);
  }
  
  public void setMultiLine(boolean paramBoolean) {
    IMPL.setMultiLine(this.mInfo, paramBoolean);
  }
  
  public void setPackageName(CharSequence paramCharSequence) {
    IMPL.setPackageName(this.mInfo, paramCharSequence);
  }
  
  public void setParent(View paramView) {
    IMPL.setParent(this.mInfo, paramView);
  }
  
  public void setParent(View paramView, int paramInt) {
    this.mParentVirtualDescendantId = paramInt;
    IMPL.setParent(this.mInfo, paramView, paramInt);
  }
  
  public void setPassword(boolean paramBoolean) {
    IMPL.setPassword(this.mInfo, paramBoolean);
  }
  
  public void setRangeInfo(RangeInfoCompat paramRangeInfoCompat) {
    IMPL.setRangeInfo(this.mInfo, paramRangeInfoCompat.mInfo);
  }
  
  public void setRoleDescription(@Nullable CharSequence paramCharSequence) {
    IMPL.setRoleDescription(this.mInfo, paramCharSequence);
  }
  
  public void setScrollable(boolean paramBoolean) {
    IMPL.setScrollable(this.mInfo, paramBoolean);
  }
  
  public void setSelected(boolean paramBoolean) {
    IMPL.setSelected(this.mInfo, paramBoolean);
  }
  
  public void setSource(View paramView) {
    IMPL.setSource(this.mInfo, paramView);
  }
  
  public void setSource(View paramView, int paramInt) {
    IMPL.setSource(this.mInfo, paramView, paramInt);
  }
  
  public void setText(CharSequence paramCharSequence) {
    IMPL.setText(this.mInfo, paramCharSequence);
  }
  
  public void setTextSelection(int paramInt1, int paramInt2) {
    IMPL.setTextSelection(this.mInfo, paramInt1, paramInt2);
  }
  
  public void setTraversalAfter(View paramView) {
    IMPL.setTraversalAfter(this.mInfo, paramView);
  }
  
  public void setTraversalAfter(View paramView, int paramInt) {
    IMPL.setTraversalAfter(this.mInfo, paramView, paramInt);
  }
  
  public void setTraversalBefore(View paramView) {
    IMPL.setTraversalBefore(this.mInfo, paramView);
  }
  
  public void setTraversalBefore(View paramView, int paramInt) {
    IMPL.setTraversalBefore(this.mInfo, paramView, paramInt);
  }
  
  public void setViewIdResourceName(String paramString) {
    IMPL.setViewIdResourceName(this.mInfo, paramString);
  }
  
  public void setVisibleToUser(boolean paramBoolean) {
    IMPL.setVisibleToUser(this.mInfo, paramBoolean);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    Rect rect = new Rect();
    getBoundsInParent(rect);
    stringBuilder.append("; boundsInParent: " + rect);
    getBoundsInScreen(rect);
    stringBuilder.append("; boundsInScreen: " + rect);
    stringBuilder.append("; packageName: ").append(getPackageName());
    stringBuilder.append("; className: ").append(getClassName());
    stringBuilder.append("; text: ").append(getText());
    stringBuilder.append("; contentDescription: ").append(getContentDescription());
    stringBuilder.append("; viewId: ").append(getViewIdResourceName());
    stringBuilder.append("; checkable: ").append(isCheckable());
    stringBuilder.append("; checked: ").append(isChecked());
    stringBuilder.append("; focusable: ").append(isFocusable());
    stringBuilder.append("; focused: ").append(isFocused());
    stringBuilder.append("; selected: ").append(isSelected());
    stringBuilder.append("; clickable: ").append(isClickable());
    stringBuilder.append("; longClickable: ").append(isLongClickable());
    stringBuilder.append("; enabled: ").append(isEnabled());
    stringBuilder.append("; password: ").append(isPassword());
    stringBuilder.append("; scrollable: " + isScrollable());
    stringBuilder.append("; [");
    int i = getActions();
    while (i != 0) {
      int k = 1 << Integer.numberOfTrailingZeros(i);
      int j = i & (k ^ 0xFFFFFFFF);
      stringBuilder.append(getActionSymbolicName(k));
      i = j;
      if (j != 0) {
        stringBuilder.append(", ");
        i = j;
      } 
    } 
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 24) {
      IMPL = new AccessibilityNodeInfoApi24Impl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 23) {
      IMPL = new AccessibilityNodeInfoApi23Impl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 22) {
      IMPL = new AccessibilityNodeInfoApi22Impl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new AccessibilityNodeInfoApi21Impl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      IMPL = new AccessibilityNodeInfoKitKatImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 18) {
      IMPL = new AccessibilityNodeInfoJellybeanMr2Impl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 17) {
      IMPL = new AccessibilityNodeInfoJellybeanMr1Impl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new AccessibilityNodeInfoJellybeanImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new AccessibilityNodeInfoIcsImpl();
      return;
    } 
  }
  
  public static class AccessibilityActionCompat {
    public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
    
    public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
    
    public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
    
    public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
    
    public static final AccessibilityActionCompat ACTION_CLICK;
    
    public static final AccessibilityActionCompat ACTION_COLLAPSE;
    
    public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;
    
    public static final AccessibilityActionCompat ACTION_COPY;
    
    public static final AccessibilityActionCompat ACTION_CUT;
    
    public static final AccessibilityActionCompat ACTION_DISMISS;
    
    public static final AccessibilityActionCompat ACTION_EXPAND;
    
    public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
    
    public static final AccessibilityActionCompat ACTION_LONG_CLICK;
    
    public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    
    public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
    
    public static final AccessibilityActionCompat ACTION_PASTE;
    
    public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
    
    public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_UP;
    
    public static final AccessibilityActionCompat ACTION_SELECT = new AccessibilityActionCompat(4, null);
    
    public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
    
    public static final AccessibilityActionCompat ACTION_SET_SELECTION;
    
    public static final AccessibilityActionCompat ACTION_SET_TEXT;
    
    public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
    
    final Object mAction;
    
    static {
      ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
      ACTION_CLICK = new AccessibilityActionCompat(16, null);
      ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
      ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
      ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
      ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null);
      ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null);
      ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null);
      ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null);
      ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
      ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
      ACTION_COPY = new AccessibilityActionCompat(16384, null);
      ACTION_PASTE = new AccessibilityActionCompat(32768, null);
      ACTION_CUT = new AccessibilityActionCompat(65536, null);
      ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null);
      ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
      ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
      ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
      ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null);
      ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionShowOnScreen());
      ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollToPosition());
      ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollUp());
      ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollLeft());
      ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollDown());
      ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollRight());
      ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionContextClick());
      ACTION_SET_PROGRESS = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionSetProgress());
    }
    
    public AccessibilityActionCompat(int param1Int, CharSequence param1CharSequence) {
      this(AccessibilityNodeInfoCompat.IMPL.newAccessibilityAction(param1Int, param1CharSequence));
    }
    
    AccessibilityActionCompat(Object param1Object) {
      this.mAction = param1Object;
    }
    
    public int getId() {
      return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionId(this.mAction);
    }
    
    public CharSequence getLabel() {
      return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionLabel(this.mAction);
    }
  }
  
  static class AccessibilityNodeInfoApi21Impl extends AccessibilityNodeInfoKitKatImpl {
    public void addAction(Object param1Object1, Object param1Object2) {
      AccessibilityNodeInfoCompatApi21.addAction(param1Object1, param1Object2);
    }
    
    public int getAccessibilityActionId(Object param1Object) {
      return AccessibilityNodeInfoCompatApi21.getAccessibilityActionId(param1Object);
    }
    
    public CharSequence getAccessibilityActionLabel(Object param1Object) {
      return AccessibilityNodeInfoCompatApi21.getAccessibilityActionLabel(param1Object);
    }
    
    public List<Object> getActionList(Object param1Object) {
      return AccessibilityNodeInfoCompatApi21.getActionList(param1Object);
    }
    
    public int getCollectionInfoSelectionMode(Object param1Object) {
      return AccessibilityNodeInfoCompatApi21.CollectionInfo.getSelectionMode(param1Object);
    }
    
    public CharSequence getError(Object param1Object) {
      return AccessibilityNodeInfoCompatApi21.getError(param1Object);
    }
    
    public int getMaxTextLength(Object param1Object) {
      return AccessibilityNodeInfoCompatApi21.getMaxTextLength(param1Object);
    }
    
    public Object getWindow(Object param1Object) {
      return AccessibilityNodeInfoCompatApi21.getWindow(param1Object);
    }
    
    public boolean isCollectionItemSelected(Object param1Object) {
      return AccessibilityNodeInfoCompatApi21.CollectionItemInfo.isSelected(param1Object);
    }
    
    public Object newAccessibilityAction(int param1Int, CharSequence param1CharSequence) {
      return AccessibilityNodeInfoCompatApi21.newAccessibilityAction(param1Int, param1CharSequence);
    }
    
    public Object obtainCollectionInfo(int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3) {
      return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(param1Int1, param1Int2, param1Boolean, param1Int3);
    }
    
    public Object obtainCollectionItemInfo(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean1, boolean param1Boolean2) {
      return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(param1Int1, param1Int2, param1Int3, param1Int4, param1Boolean1, param1Boolean2);
    }
    
    public boolean removeAction(Object param1Object1, Object param1Object2) {
      return AccessibilityNodeInfoCompatApi21.removeAction(param1Object1, param1Object2);
    }
    
    public boolean removeChild(Object param1Object, View param1View) {
      return AccessibilityNodeInfoCompatApi21.removeChild(param1Object, param1View);
    }
    
    public boolean removeChild(Object param1Object, View param1View, int param1Int) {
      return AccessibilityNodeInfoCompatApi21.removeChild(param1Object, param1View, param1Int);
    }
    
    public void setError(Object param1Object, CharSequence param1CharSequence) {
      AccessibilityNodeInfoCompatApi21.setError(param1Object, param1CharSequence);
    }
    
    public void setMaxTextLength(Object param1Object, int param1Int) {
      AccessibilityNodeInfoCompatApi21.setMaxTextLength(param1Object, param1Int);
    }
  }
  
  static class AccessibilityNodeInfoApi22Impl extends AccessibilityNodeInfoApi21Impl {
    public Object getTraversalAfter(Object param1Object) {
      return AccessibilityNodeInfoCompatApi22.getTraversalAfter(param1Object);
    }
    
    public Object getTraversalBefore(Object param1Object) {
      return AccessibilityNodeInfoCompatApi22.getTraversalBefore(param1Object);
    }
    
    public void setTraversalAfter(Object param1Object, View param1View) {
      AccessibilityNodeInfoCompatApi22.setTraversalAfter(param1Object, param1View);
    }
    
    public void setTraversalAfter(Object param1Object, View param1View, int param1Int) {
      AccessibilityNodeInfoCompatApi22.setTraversalAfter(param1Object, param1View, param1Int);
    }
    
    public void setTraversalBefore(Object param1Object, View param1View) {
      AccessibilityNodeInfoCompatApi22.setTraversalBefore(param1Object, param1View);
    }
    
    public void setTraversalBefore(Object param1Object, View param1View, int param1Int) {
      AccessibilityNodeInfoCompatApi22.setTraversalBefore(param1Object, param1View, param1Int);
    }
  }
  
  static class AccessibilityNodeInfoApi23Impl extends AccessibilityNodeInfoApi22Impl {
    public Object getActionContextClick() {
      return AccessibilityNodeInfoCompatApi23.getActionContextClick();
    }
    
    public Object getActionScrollDown() {
      return AccessibilityNodeInfoCompatApi23.getActionScrollDown();
    }
    
    public Object getActionScrollLeft() {
      return AccessibilityNodeInfoCompatApi23.getActionScrollLeft();
    }
    
    public Object getActionScrollRight() {
      return AccessibilityNodeInfoCompatApi23.getActionScrollRight();
    }
    
    public Object getActionScrollToPosition() {
      return AccessibilityNodeInfoCompatApi23.getActionScrollToPosition();
    }
    
    public Object getActionScrollUp() {
      return AccessibilityNodeInfoCompatApi23.getActionScrollUp();
    }
    
    public Object getActionShowOnScreen() {
      return AccessibilityNodeInfoCompatApi23.getActionShowOnScreen();
    }
    
    public boolean isContextClickable(Object param1Object) {
      return AccessibilityNodeInfoCompatApi23.isContextClickable(param1Object);
    }
    
    public void setContextClickable(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatApi23.setContextClickable(param1Object, param1Boolean);
    }
  }
  
  static class AccessibilityNodeInfoApi24Impl extends AccessibilityNodeInfoApi23Impl {
    public Object getActionSetProgress() {
      return AccessibilityNodeInfoCompatApi24.getActionSetProgress();
    }
    
    public int getDrawingOrder(Object param1Object) {
      return AccessibilityNodeInfoCompatApi24.getDrawingOrder(param1Object);
    }
    
    public boolean isImportantForAccessibility(Object param1Object) {
      return AccessibilityNodeInfoCompatApi24.isImportantForAccessibility(param1Object);
    }
    
    public void setDrawingOrder(Object param1Object, int param1Int) {
      AccessibilityNodeInfoCompatApi24.setDrawingOrder(param1Object, param1Int);
    }
    
    public void setImportantForAccessibility(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatApi24.setImportantForAccessibility(param1Object, param1Boolean);
    }
  }
  
  static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
    public void addAction(Object param1Object, int param1Int) {
      AccessibilityNodeInfoCompatIcs.addAction(param1Object, param1Int);
    }
    
    public void addChild(Object param1Object, View param1View) {
      AccessibilityNodeInfoCompatIcs.addChild(param1Object, param1View);
    }
    
    public List<Object> findAccessibilityNodeInfosByText(Object param1Object, String param1String) {
      return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(param1Object, param1String);
    }
    
    public int getActions(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.getActions(param1Object);
    }
    
    public void getBoundsInParent(Object param1Object, Rect param1Rect) {
      AccessibilityNodeInfoCompatIcs.getBoundsInParent(param1Object, param1Rect);
    }
    
    public void getBoundsInScreen(Object param1Object, Rect param1Rect) {
      AccessibilityNodeInfoCompatIcs.getBoundsInScreen(param1Object, param1Rect);
    }
    
    public Object getChild(Object param1Object, int param1Int) {
      return AccessibilityNodeInfoCompatIcs.getChild(param1Object, param1Int);
    }
    
    public int getChildCount(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.getChildCount(param1Object);
    }
    
    public CharSequence getClassName(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.getClassName(param1Object);
    }
    
    public CharSequence getContentDescription(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.getContentDescription(param1Object);
    }
    
    public CharSequence getPackageName(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.getPackageName(param1Object);
    }
    
    public Object getParent(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.getParent(param1Object);
    }
    
    public CharSequence getText(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.getText(param1Object);
    }
    
    public int getWindowId(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.getWindowId(param1Object);
    }
    
    public boolean isCheckable(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.isCheckable(param1Object);
    }
    
    public boolean isChecked(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.isChecked(param1Object);
    }
    
    public boolean isClickable(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.isClickable(param1Object);
    }
    
    public boolean isEnabled(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.isEnabled(param1Object);
    }
    
    public boolean isFocusable(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.isFocusable(param1Object);
    }
    
    public boolean isFocused(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.isFocused(param1Object);
    }
    
    public boolean isLongClickable(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.isLongClickable(param1Object);
    }
    
    public boolean isPassword(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.isPassword(param1Object);
    }
    
    public boolean isScrollable(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.isScrollable(param1Object);
    }
    
    public boolean isSelected(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.isSelected(param1Object);
    }
    
    public Object obtain() {
      return AccessibilityNodeInfoCompatIcs.obtain();
    }
    
    public Object obtain(View param1View) {
      return AccessibilityNodeInfoCompatIcs.obtain(param1View);
    }
    
    public Object obtain(Object param1Object) {
      return AccessibilityNodeInfoCompatIcs.obtain(param1Object);
    }
    
    public boolean performAction(Object param1Object, int param1Int) {
      return AccessibilityNodeInfoCompatIcs.performAction(param1Object, param1Int);
    }
    
    public void recycle(Object param1Object) {
      AccessibilityNodeInfoCompatIcs.recycle(param1Object);
    }
    
    public void setBoundsInParent(Object param1Object, Rect param1Rect) {
      AccessibilityNodeInfoCompatIcs.setBoundsInParent(param1Object, param1Rect);
    }
    
    public void setBoundsInScreen(Object param1Object, Rect param1Rect) {
      AccessibilityNodeInfoCompatIcs.setBoundsInScreen(param1Object, param1Rect);
    }
    
    public void setCheckable(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatIcs.setCheckable(param1Object, param1Boolean);
    }
    
    public void setChecked(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatIcs.setChecked(param1Object, param1Boolean);
    }
    
    public void setClassName(Object param1Object, CharSequence param1CharSequence) {
      AccessibilityNodeInfoCompatIcs.setClassName(param1Object, param1CharSequence);
    }
    
    public void setClickable(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatIcs.setClickable(param1Object, param1Boolean);
    }
    
    public void setContentDescription(Object param1Object, CharSequence param1CharSequence) {
      AccessibilityNodeInfoCompatIcs.setContentDescription(param1Object, param1CharSequence);
    }
    
    public void setEnabled(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatIcs.setEnabled(param1Object, param1Boolean);
    }
    
    public void setFocusable(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatIcs.setFocusable(param1Object, param1Boolean);
    }
    
    public void setFocused(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatIcs.setFocused(param1Object, param1Boolean);
    }
    
    public void setLongClickable(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatIcs.setLongClickable(param1Object, param1Boolean);
    }
    
    public void setPackageName(Object param1Object, CharSequence param1CharSequence) {
      AccessibilityNodeInfoCompatIcs.setPackageName(param1Object, param1CharSequence);
    }
    
    public void setParent(Object param1Object, View param1View) {
      AccessibilityNodeInfoCompatIcs.setParent(param1Object, param1View);
    }
    
    public void setPassword(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatIcs.setPassword(param1Object, param1Boolean);
    }
    
    public void setScrollable(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatIcs.setScrollable(param1Object, param1Boolean);
    }
    
    public void setSelected(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatIcs.setSelected(param1Object, param1Boolean);
    }
    
    public void setSource(Object param1Object, View param1View) {
      AccessibilityNodeInfoCompatIcs.setSource(param1Object, param1View);
    }
    
    public void setText(Object param1Object, CharSequence param1CharSequence) {
      AccessibilityNodeInfoCompatIcs.setText(param1Object, param1CharSequence);
    }
  }
  
  static interface AccessibilityNodeInfoImpl {
    void addAction(Object param1Object, int param1Int);
    
    void addAction(Object param1Object1, Object param1Object2);
    
    void addChild(Object param1Object, View param1View);
    
    void addChild(Object param1Object, View param1View, int param1Int);
    
    boolean canOpenPopup(Object param1Object);
    
    List<Object> findAccessibilityNodeInfosByText(Object param1Object, String param1String);
    
    List<Object> findAccessibilityNodeInfosByViewId(Object param1Object, String param1String);
    
    Object findFocus(Object param1Object, int param1Int);
    
    Object focusSearch(Object param1Object, int param1Int);
    
    int getAccessibilityActionId(Object param1Object);
    
    CharSequence getAccessibilityActionLabel(Object param1Object);
    
    Object getActionContextClick();
    
    List<Object> getActionList(Object param1Object);
    
    Object getActionScrollDown();
    
    Object getActionScrollLeft();
    
    Object getActionScrollRight();
    
    Object getActionScrollToPosition();
    
    Object getActionScrollUp();
    
    Object getActionSetProgress();
    
    Object getActionShowOnScreen();
    
    int getActions(Object param1Object);
    
    void getBoundsInParent(Object param1Object, Rect param1Rect);
    
    void getBoundsInScreen(Object param1Object, Rect param1Rect);
    
    Object getChild(Object param1Object, int param1Int);
    
    int getChildCount(Object param1Object);
    
    CharSequence getClassName(Object param1Object);
    
    Object getCollectionInfo(Object param1Object);
    
    int getCollectionInfoColumnCount(Object param1Object);
    
    int getCollectionInfoRowCount(Object param1Object);
    
    int getCollectionInfoSelectionMode(Object param1Object);
    
    int getCollectionItemColumnIndex(Object param1Object);
    
    int getCollectionItemColumnSpan(Object param1Object);
    
    Object getCollectionItemInfo(Object param1Object);
    
    int getCollectionItemRowIndex(Object param1Object);
    
    int getCollectionItemRowSpan(Object param1Object);
    
    CharSequence getContentDescription(Object param1Object);
    
    int getDrawingOrder(Object param1Object);
    
    CharSequence getError(Object param1Object);
    
    Bundle getExtras(Object param1Object);
    
    int getInputType(Object param1Object);
    
    Object getLabelFor(Object param1Object);
    
    Object getLabeledBy(Object param1Object);
    
    int getLiveRegion(Object param1Object);
    
    int getMaxTextLength(Object param1Object);
    
    int getMovementGranularities(Object param1Object);
    
    CharSequence getPackageName(Object param1Object);
    
    Object getParent(Object param1Object);
    
    Object getRangeInfo(Object param1Object);
    
    CharSequence getRoleDescription(Object param1Object);
    
    CharSequence getText(Object param1Object);
    
    int getTextSelectionEnd(Object param1Object);
    
    int getTextSelectionStart(Object param1Object);
    
    Object getTraversalAfter(Object param1Object);
    
    Object getTraversalBefore(Object param1Object);
    
    String getViewIdResourceName(Object param1Object);
    
    Object getWindow(Object param1Object);
    
    int getWindowId(Object param1Object);
    
    boolean isAccessibilityFocused(Object param1Object);
    
    boolean isCheckable(Object param1Object);
    
    boolean isChecked(Object param1Object);
    
    boolean isClickable(Object param1Object);
    
    boolean isCollectionInfoHierarchical(Object param1Object);
    
    boolean isCollectionItemHeading(Object param1Object);
    
    boolean isCollectionItemSelected(Object param1Object);
    
    boolean isContentInvalid(Object param1Object);
    
    boolean isContextClickable(Object param1Object);
    
    boolean isDismissable(Object param1Object);
    
    boolean isEditable(Object param1Object);
    
    boolean isEnabled(Object param1Object);
    
    boolean isFocusable(Object param1Object);
    
    boolean isFocused(Object param1Object);
    
    boolean isImportantForAccessibility(Object param1Object);
    
    boolean isLongClickable(Object param1Object);
    
    boolean isMultiLine(Object param1Object);
    
    boolean isPassword(Object param1Object);
    
    boolean isScrollable(Object param1Object);
    
    boolean isSelected(Object param1Object);
    
    boolean isVisibleToUser(Object param1Object);
    
    Object newAccessibilityAction(int param1Int, CharSequence param1CharSequence);
    
    Object obtain();
    
    Object obtain(View param1View);
    
    Object obtain(View param1View, int param1Int);
    
    Object obtain(Object param1Object);
    
    Object obtainCollectionInfo(int param1Int1, int param1Int2, boolean param1Boolean);
    
    Object obtainCollectionInfo(int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3);
    
    Object obtainCollectionItemInfo(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean);
    
    Object obtainCollectionItemInfo(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean1, boolean param1Boolean2);
    
    Object obtainRangeInfo(int param1Int, float param1Float1, float param1Float2, float param1Float3);
    
    boolean performAction(Object param1Object, int param1Int);
    
    boolean performAction(Object param1Object, int param1Int, Bundle param1Bundle);
    
    void recycle(Object param1Object);
    
    boolean refresh(Object param1Object);
    
    boolean removeAction(Object param1Object1, Object param1Object2);
    
    boolean removeChild(Object param1Object, View param1View);
    
    boolean removeChild(Object param1Object, View param1View, int param1Int);
    
    void setAccessibilityFocused(Object param1Object, boolean param1Boolean);
    
    void setBoundsInParent(Object param1Object, Rect param1Rect);
    
    void setBoundsInScreen(Object param1Object, Rect param1Rect);
    
    void setCanOpenPopup(Object param1Object, boolean param1Boolean);
    
    void setCheckable(Object param1Object, boolean param1Boolean);
    
    void setChecked(Object param1Object, boolean param1Boolean);
    
    void setClassName(Object param1Object, CharSequence param1CharSequence);
    
    void setClickable(Object param1Object, boolean param1Boolean);
    
    void setCollectionInfo(Object param1Object1, Object param1Object2);
    
    void setCollectionItemInfo(Object param1Object1, Object param1Object2);
    
    void setContentDescription(Object param1Object, CharSequence param1CharSequence);
    
    void setContentInvalid(Object param1Object, boolean param1Boolean);
    
    void setContextClickable(Object param1Object, boolean param1Boolean);
    
    void setDismissable(Object param1Object, boolean param1Boolean);
    
    void setDrawingOrder(Object param1Object, int param1Int);
    
    void setEditable(Object param1Object, boolean param1Boolean);
    
    void setEnabled(Object param1Object, boolean param1Boolean);
    
    void setError(Object param1Object, CharSequence param1CharSequence);
    
    void setFocusable(Object param1Object, boolean param1Boolean);
    
    void setFocused(Object param1Object, boolean param1Boolean);
    
    void setImportantForAccessibility(Object param1Object, boolean param1Boolean);
    
    void setInputType(Object param1Object, int param1Int);
    
    void setLabelFor(Object param1Object, View param1View);
    
    void setLabelFor(Object param1Object, View param1View, int param1Int);
    
    void setLabeledBy(Object param1Object, View param1View);
    
    void setLabeledBy(Object param1Object, View param1View, int param1Int);
    
    void setLiveRegion(Object param1Object, int param1Int);
    
    void setLongClickable(Object param1Object, boolean param1Boolean);
    
    void setMaxTextLength(Object param1Object, int param1Int);
    
    void setMovementGranularities(Object param1Object, int param1Int);
    
    void setMultiLine(Object param1Object, boolean param1Boolean);
    
    void setPackageName(Object param1Object, CharSequence param1CharSequence);
    
    void setParent(Object param1Object, View param1View);
    
    void setParent(Object param1Object, View param1View, int param1Int);
    
    void setPassword(Object param1Object, boolean param1Boolean);
    
    void setRangeInfo(Object param1Object1, Object param1Object2);
    
    void setRoleDescription(Object param1Object, CharSequence param1CharSequence);
    
    void setScrollable(Object param1Object, boolean param1Boolean);
    
    void setSelected(Object param1Object, boolean param1Boolean);
    
    void setSource(Object param1Object, View param1View);
    
    void setSource(Object param1Object, View param1View, int param1Int);
    
    void setText(Object param1Object, CharSequence param1CharSequence);
    
    void setTextSelection(Object param1Object, int param1Int1, int param1Int2);
    
    void setTraversalAfter(Object param1Object, View param1View);
    
    void setTraversalAfter(Object param1Object, View param1View, int param1Int);
    
    void setTraversalBefore(Object param1Object, View param1View);
    
    void setTraversalBefore(Object param1Object, View param1View, int param1Int);
    
    void setViewIdResourceName(Object param1Object, String param1String);
    
    void setVisibleToUser(Object param1Object, boolean param1Boolean);
  }
  
  static class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoIcsImpl {
    public void addChild(Object param1Object, View param1View, int param1Int) {
      AccessibilityNodeInfoCompatJellyBean.addChild(param1Object, param1View, param1Int);
    }
    
    public Object findFocus(Object param1Object, int param1Int) {
      return AccessibilityNodeInfoCompatJellyBean.findFocus(param1Object, param1Int);
    }
    
    public Object focusSearch(Object param1Object, int param1Int) {
      return AccessibilityNodeInfoCompatJellyBean.focusSearch(param1Object, param1Int);
    }
    
    public int getMovementGranularities(Object param1Object) {
      return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(param1Object);
    }
    
    public boolean isAccessibilityFocused(Object param1Object) {
      return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(param1Object);
    }
    
    public boolean isVisibleToUser(Object param1Object) {
      return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(param1Object);
    }
    
    public Object obtain(View param1View, int param1Int) {
      return AccessibilityNodeInfoCompatJellyBean.obtain(param1View, param1Int);
    }
    
    public boolean performAction(Object param1Object, int param1Int, Bundle param1Bundle) {
      return AccessibilityNodeInfoCompatJellyBean.performAction(param1Object, param1Int, param1Bundle);
    }
    
    public void setAccessibilityFocused(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(param1Object, param1Boolean);
    }
    
    public void setMovementGranularities(Object param1Object, int param1Int) {
      AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(param1Object, param1Int);
    }
    
    public void setParent(Object param1Object, View param1View, int param1Int) {
      AccessibilityNodeInfoCompatJellyBean.setParent(param1Object, param1View, param1Int);
    }
    
    public void setSource(Object param1Object, View param1View, int param1Int) {
      AccessibilityNodeInfoCompatJellyBean.setSource(param1Object, param1View, param1Int);
    }
    
    public void setVisibleToUser(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(param1Object, param1Boolean);
    }
  }
  
  static class AccessibilityNodeInfoJellybeanMr1Impl extends AccessibilityNodeInfoJellybeanImpl {
    public Object getLabelFor(Object param1Object) {
      return AccessibilityNodeInfoCompatJellybeanMr1.getLabelFor(param1Object);
    }
    
    public Object getLabeledBy(Object param1Object) {
      return AccessibilityNodeInfoCompatJellybeanMr1.getLabeledBy(param1Object);
    }
    
    public void setLabelFor(Object param1Object, View param1View) {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(param1Object, param1View);
    }
    
    public void setLabelFor(Object param1Object, View param1View, int param1Int) {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(param1Object, param1View, param1Int);
    }
    
    public void setLabeledBy(Object param1Object, View param1View) {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(param1Object, param1View);
    }
    
    public void setLabeledBy(Object param1Object, View param1View, int param1Int) {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(param1Object, param1View, param1Int);
    }
  }
  
  static class AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoJellybeanMr1Impl {
    public List<Object> findAccessibilityNodeInfosByViewId(Object param1Object, String param1String) {
      return AccessibilityNodeInfoCompatJellybeanMr2.findAccessibilityNodeInfosByViewId(param1Object, param1String);
    }
    
    public int getTextSelectionEnd(Object param1Object) {
      return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionEnd(param1Object);
    }
    
    public int getTextSelectionStart(Object param1Object) {
      return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionStart(param1Object);
    }
    
    public String getViewIdResourceName(Object param1Object) {
      return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(param1Object);
    }
    
    public boolean isEditable(Object param1Object) {
      return AccessibilityNodeInfoCompatJellybeanMr2.isEditable(param1Object);
    }
    
    public boolean refresh(Object param1Object) {
      return AccessibilityNodeInfoCompatJellybeanMr2.refresh(param1Object);
    }
    
    public void setEditable(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatJellybeanMr2.setEditable(param1Object, param1Boolean);
    }
    
    public void setTextSelection(Object param1Object, int param1Int1, int param1Int2) {
      AccessibilityNodeInfoCompatJellybeanMr2.setTextSelection(param1Object, param1Int1, param1Int2);
    }
    
    public void setViewIdResourceName(Object param1Object, String param1String) {
      AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(param1Object, param1String);
    }
  }
  
  static class AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoJellybeanMr2Impl {
    public boolean canOpenPopup(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.canOpenPopup(param1Object);
    }
    
    public Object getCollectionInfo(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.getCollectionInfo(param1Object);
    }
    
    public int getCollectionInfoColumnCount(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getColumnCount(param1Object);
    }
    
    public int getCollectionInfoRowCount(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getRowCount(param1Object);
    }
    
    public int getCollectionItemColumnIndex(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnIndex(param1Object);
    }
    
    public int getCollectionItemColumnSpan(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnSpan(param1Object);
    }
    
    public Object getCollectionItemInfo(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.getCollectionItemInfo(param1Object);
    }
    
    public int getCollectionItemRowIndex(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowIndex(param1Object);
    }
    
    public int getCollectionItemRowSpan(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowSpan(param1Object);
    }
    
    public Bundle getExtras(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.getExtras(param1Object);
    }
    
    public int getInputType(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.getInputType(param1Object);
    }
    
    public int getLiveRegion(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.getLiveRegion(param1Object);
    }
    
    public Object getRangeInfo(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.getRangeInfo(param1Object);
    }
    
    public CharSequence getRoleDescription(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.getRoleDescription(param1Object);
    }
    
    public boolean isCollectionInfoHierarchical(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.CollectionInfo.isHierarchical(param1Object);
    }
    
    public boolean isCollectionItemHeading(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.isHeading(param1Object);
    }
    
    public boolean isContentInvalid(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.isContentInvalid(param1Object);
    }
    
    public boolean isDismissable(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.isDismissable(param1Object);
    }
    
    public boolean isMultiLine(Object param1Object) {
      return AccessibilityNodeInfoCompatKitKat.isMultiLine(param1Object);
    }
    
    public Object obtainCollectionInfo(int param1Int1, int param1Int2, boolean param1Boolean) {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(param1Int1, param1Int2, param1Boolean);
    }
    
    public Object obtainCollectionInfo(int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3) {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(param1Int1, param1Int2, param1Boolean, param1Int3);
    }
    
    public Object obtainCollectionItemInfo(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean) {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(param1Int1, param1Int2, param1Int3, param1Int4, param1Boolean);
    }
    
    public Object obtainCollectionItemInfo(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean1, boolean param1Boolean2) {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(param1Int1, param1Int2, param1Int3, param1Int4, param1Boolean1);
    }
    
    public Object obtainRangeInfo(int param1Int, float param1Float1, float param1Float2, float param1Float3) {
      return AccessibilityNodeInfoCompatKitKat.obtainRangeInfo(param1Int, param1Float1, param1Float2, param1Float3);
    }
    
    public void setCanOpenPopup(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatKitKat.setCanOpenPopup(param1Object, param1Boolean);
    }
    
    public void setCollectionInfo(Object param1Object1, Object param1Object2) {
      AccessibilityNodeInfoCompatKitKat.setCollectionInfo(param1Object1, param1Object2);
    }
    
    public void setCollectionItemInfo(Object param1Object1, Object param1Object2) {
      AccessibilityNodeInfoCompatKitKat.setCollectionItemInfo(param1Object1, param1Object2);
    }
    
    public void setContentInvalid(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatKitKat.setContentInvalid(param1Object, param1Boolean);
    }
    
    public void setDismissable(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatKitKat.setDismissable(param1Object, param1Boolean);
    }
    
    public void setInputType(Object param1Object, int param1Int) {
      AccessibilityNodeInfoCompatKitKat.setInputType(param1Object, param1Int);
    }
    
    public void setLiveRegion(Object param1Object, int param1Int) {
      AccessibilityNodeInfoCompatKitKat.setLiveRegion(param1Object, param1Int);
    }
    
    public void setMultiLine(Object param1Object, boolean param1Boolean) {
      AccessibilityNodeInfoCompatKitKat.setMultiLine(param1Object, param1Boolean);
    }
    
    public void setRangeInfo(Object param1Object1, Object param1Object2) {
      AccessibilityNodeInfoCompatKitKat.setRangeInfo(param1Object1, param1Object2);
    }
    
    public void setRoleDescription(Object param1Object, CharSequence param1CharSequence) {
      AccessibilityNodeInfoCompatKitKat.setRoleDescription(param1Object, param1CharSequence);
    }
  }
  
  static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
    public void addAction(Object param1Object, int param1Int) {}
    
    public void addAction(Object param1Object1, Object param1Object2) {}
    
    public void addChild(Object param1Object, View param1View) {}
    
    public void addChild(Object param1Object, View param1View, int param1Int) {}
    
    public boolean canOpenPopup(Object param1Object) {
      return false;
    }
    
    public List<Object> findAccessibilityNodeInfosByText(Object param1Object, String param1String) {
      return Collections.emptyList();
    }
    
    public List<Object> findAccessibilityNodeInfosByViewId(Object param1Object, String param1String) {
      return Collections.emptyList();
    }
    
    public Object findFocus(Object param1Object, int param1Int) {
      return null;
    }
    
    public Object focusSearch(Object param1Object, int param1Int) {
      return null;
    }
    
    public int getAccessibilityActionId(Object param1Object) {
      return 0;
    }
    
    public CharSequence getAccessibilityActionLabel(Object param1Object) {
      return null;
    }
    
    public Object getActionContextClick() {
      return null;
    }
    
    public List<Object> getActionList(Object param1Object) {
      return null;
    }
    
    public Object getActionScrollDown() {
      return null;
    }
    
    public Object getActionScrollLeft() {
      return null;
    }
    
    public Object getActionScrollRight() {
      return null;
    }
    
    public Object getActionScrollToPosition() {
      return null;
    }
    
    public Object getActionScrollUp() {
      return null;
    }
    
    public Object getActionSetProgress() {
      return null;
    }
    
    public Object getActionShowOnScreen() {
      return null;
    }
    
    public int getActions(Object param1Object) {
      return 0;
    }
    
    public void getBoundsInParent(Object param1Object, Rect param1Rect) {}
    
    public void getBoundsInScreen(Object param1Object, Rect param1Rect) {}
    
    public Object getChild(Object param1Object, int param1Int) {
      return null;
    }
    
    public int getChildCount(Object param1Object) {
      return 0;
    }
    
    public CharSequence getClassName(Object param1Object) {
      return null;
    }
    
    public Object getCollectionInfo(Object param1Object) {
      return null;
    }
    
    public int getCollectionInfoColumnCount(Object param1Object) {
      return 0;
    }
    
    public int getCollectionInfoRowCount(Object param1Object) {
      return 0;
    }
    
    public int getCollectionInfoSelectionMode(Object param1Object) {
      return 0;
    }
    
    public int getCollectionItemColumnIndex(Object param1Object) {
      return 0;
    }
    
    public int getCollectionItemColumnSpan(Object param1Object) {
      return 0;
    }
    
    public Object getCollectionItemInfo(Object param1Object) {
      return null;
    }
    
    public int getCollectionItemRowIndex(Object param1Object) {
      return 0;
    }
    
    public int getCollectionItemRowSpan(Object param1Object) {
      return 0;
    }
    
    public CharSequence getContentDescription(Object param1Object) {
      return null;
    }
    
    public int getDrawingOrder(Object param1Object) {
      return 0;
    }
    
    public CharSequence getError(Object param1Object) {
      return null;
    }
    
    public Bundle getExtras(Object param1Object) {
      return new Bundle();
    }
    
    public int getInputType(Object param1Object) {
      return 0;
    }
    
    public Object getLabelFor(Object param1Object) {
      return null;
    }
    
    public Object getLabeledBy(Object param1Object) {
      return null;
    }
    
    public int getLiveRegion(Object param1Object) {
      return 0;
    }
    
    public int getMaxTextLength(Object param1Object) {
      return -1;
    }
    
    public int getMovementGranularities(Object param1Object) {
      return 0;
    }
    
    public CharSequence getPackageName(Object param1Object) {
      return null;
    }
    
    public Object getParent(Object param1Object) {
      return null;
    }
    
    public Object getRangeInfo(Object param1Object) {
      return null;
    }
    
    public CharSequence getRoleDescription(Object param1Object) {
      return null;
    }
    
    public CharSequence getText(Object param1Object) {
      return null;
    }
    
    public int getTextSelectionEnd(Object param1Object) {
      return -1;
    }
    
    public int getTextSelectionStart(Object param1Object) {
      return -1;
    }
    
    public Object getTraversalAfter(Object param1Object) {
      return null;
    }
    
    public Object getTraversalBefore(Object param1Object) {
      return null;
    }
    
    public String getViewIdResourceName(Object param1Object) {
      return null;
    }
    
    public Object getWindow(Object param1Object) {
      return null;
    }
    
    public int getWindowId(Object param1Object) {
      return 0;
    }
    
    public boolean isAccessibilityFocused(Object param1Object) {
      return false;
    }
    
    public boolean isCheckable(Object param1Object) {
      return false;
    }
    
    public boolean isChecked(Object param1Object) {
      return false;
    }
    
    public boolean isClickable(Object param1Object) {
      return false;
    }
    
    public boolean isCollectionInfoHierarchical(Object param1Object) {
      return false;
    }
    
    public boolean isCollectionItemHeading(Object param1Object) {
      return false;
    }
    
    public boolean isCollectionItemSelected(Object param1Object) {
      return false;
    }
    
    public boolean isContentInvalid(Object param1Object) {
      return false;
    }
    
    public boolean isContextClickable(Object param1Object) {
      return false;
    }
    
    public boolean isDismissable(Object param1Object) {
      return false;
    }
    
    public boolean isEditable(Object param1Object) {
      return false;
    }
    
    public boolean isEnabled(Object param1Object) {
      return false;
    }
    
    public boolean isFocusable(Object param1Object) {
      return false;
    }
    
    public boolean isFocused(Object param1Object) {
      return false;
    }
    
    public boolean isImportantForAccessibility(Object param1Object) {
      return true;
    }
    
    public boolean isLongClickable(Object param1Object) {
      return false;
    }
    
    public boolean isMultiLine(Object param1Object) {
      return false;
    }
    
    public boolean isPassword(Object param1Object) {
      return false;
    }
    
    public boolean isScrollable(Object param1Object) {
      return false;
    }
    
    public boolean isSelected(Object param1Object) {
      return false;
    }
    
    public boolean isVisibleToUser(Object param1Object) {
      return false;
    }
    
    public Object newAccessibilityAction(int param1Int, CharSequence param1CharSequence) {
      return null;
    }
    
    public Object obtain() {
      return null;
    }
    
    public Object obtain(View param1View) {
      return null;
    }
    
    public Object obtain(View param1View, int param1Int) {
      return null;
    }
    
    public Object obtain(Object param1Object) {
      return null;
    }
    
    public Object obtainCollectionInfo(int param1Int1, int param1Int2, boolean param1Boolean) {
      return null;
    }
    
    public Object obtainCollectionInfo(int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3) {
      return null;
    }
    
    public Object obtainCollectionItemInfo(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean) {
      return null;
    }
    
    public Object obtainCollectionItemInfo(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean1, boolean param1Boolean2) {
      return null;
    }
    
    public Object obtainRangeInfo(int param1Int, float param1Float1, float param1Float2, float param1Float3) {
      return null;
    }
    
    public boolean performAction(Object param1Object, int param1Int) {
      return false;
    }
    
    public boolean performAction(Object param1Object, int param1Int, Bundle param1Bundle) {
      return false;
    }
    
    public void recycle(Object param1Object) {}
    
    public boolean refresh(Object param1Object) {
      return false;
    }
    
    public boolean removeAction(Object param1Object1, Object param1Object2) {
      return false;
    }
    
    public boolean removeChild(Object param1Object, View param1View) {
      return false;
    }
    
    public boolean removeChild(Object param1Object, View param1View, int param1Int) {
      return false;
    }
    
    public void setAccessibilityFocused(Object param1Object, boolean param1Boolean) {}
    
    public void setBoundsInParent(Object param1Object, Rect param1Rect) {}
    
    public void setBoundsInScreen(Object param1Object, Rect param1Rect) {}
    
    public void setCanOpenPopup(Object param1Object, boolean param1Boolean) {}
    
    public void setCheckable(Object param1Object, boolean param1Boolean) {}
    
    public void setChecked(Object param1Object, boolean param1Boolean) {}
    
    public void setClassName(Object param1Object, CharSequence param1CharSequence) {}
    
    public void setClickable(Object param1Object, boolean param1Boolean) {}
    
    public void setCollectionInfo(Object param1Object1, Object param1Object2) {}
    
    public void setCollectionItemInfo(Object param1Object1, Object param1Object2) {}
    
    public void setContentDescription(Object param1Object, CharSequence param1CharSequence) {}
    
    public void setContentInvalid(Object param1Object, boolean param1Boolean) {}
    
    public void setContextClickable(Object param1Object, boolean param1Boolean) {}
    
    public void setDismissable(Object param1Object, boolean param1Boolean) {}
    
    public void setDrawingOrder(Object param1Object, int param1Int) {}
    
    public void setEditable(Object param1Object, boolean param1Boolean) {}
    
    public void setEnabled(Object param1Object, boolean param1Boolean) {}
    
    public void setError(Object param1Object, CharSequence param1CharSequence) {}
    
    public void setFocusable(Object param1Object, boolean param1Boolean) {}
    
    public void setFocused(Object param1Object, boolean param1Boolean) {}
    
    public void setImportantForAccessibility(Object param1Object, boolean param1Boolean) {}
    
    public void setInputType(Object param1Object, int param1Int) {}
    
    public void setLabelFor(Object param1Object, View param1View) {}
    
    public void setLabelFor(Object param1Object, View param1View, int param1Int) {}
    
    public void setLabeledBy(Object param1Object, View param1View) {}
    
    public void setLabeledBy(Object param1Object, View param1View, int param1Int) {}
    
    public void setLiveRegion(Object param1Object, int param1Int) {}
    
    public void setLongClickable(Object param1Object, boolean param1Boolean) {}
    
    public void setMaxTextLength(Object param1Object, int param1Int) {}
    
    public void setMovementGranularities(Object param1Object, int param1Int) {}
    
    public void setMultiLine(Object param1Object, boolean param1Boolean) {}
    
    public void setPackageName(Object param1Object, CharSequence param1CharSequence) {}
    
    public void setParent(Object param1Object, View param1View) {}
    
    public void setParent(Object param1Object, View param1View, int param1Int) {}
    
    public void setPassword(Object param1Object, boolean param1Boolean) {}
    
    public void setRangeInfo(Object param1Object1, Object param1Object2) {}
    
    public void setRoleDescription(Object param1Object, CharSequence param1CharSequence) {}
    
    public void setScrollable(Object param1Object, boolean param1Boolean) {}
    
    public void setSelected(Object param1Object, boolean param1Boolean) {}
    
    public void setSource(Object param1Object, View param1View) {}
    
    public void setSource(Object param1Object, View param1View, int param1Int) {}
    
    public void setText(Object param1Object, CharSequence param1CharSequence) {}
    
    public void setTextSelection(Object param1Object, int param1Int1, int param1Int2) {}
    
    public void setTraversalAfter(Object param1Object, View param1View) {}
    
    public void setTraversalAfter(Object param1Object, View param1View, int param1Int) {}
    
    public void setTraversalBefore(Object param1Object, View param1View) {}
    
    public void setTraversalBefore(Object param1Object, View param1View, int param1Int) {}
    
    public void setViewIdResourceName(Object param1Object, String param1String) {}
    
    public void setVisibleToUser(Object param1Object, boolean param1Boolean) {}
  }
  
  public static class CollectionInfoCompat {
    public static final int SELECTION_MODE_MULTIPLE = 2;
    
    public static final int SELECTION_MODE_NONE = 0;
    
    public static final int SELECTION_MODE_SINGLE = 1;
    
    final Object mInfo;
    
    CollectionInfoCompat(Object param1Object) {
      this.mInfo = param1Object;
    }
    
    public static CollectionInfoCompat obtain(int param1Int1, int param1Int2, boolean param1Boolean) {
      return new CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(param1Int1, param1Int2, param1Boolean));
    }
    
    public static CollectionInfoCompat obtain(int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3) {
      return new CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(param1Int1, param1Int2, param1Boolean, param1Int3));
    }
    
    public int getColumnCount() {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoColumnCount(this.mInfo);
    }
    
    public int getRowCount() {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoRowCount(this.mInfo);
    }
    
    public int getSelectionMode() {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoSelectionMode(this.mInfo);
    }
    
    public boolean isHierarchical() {
      return AccessibilityNodeInfoCompat.IMPL.isCollectionInfoHierarchical(this.mInfo);
    }
  }
  
  public static class CollectionItemInfoCompat {
    final Object mInfo;
    
    CollectionItemInfoCompat(Object param1Object) {
      this.mInfo = param1Object;
    }
    
    public static CollectionItemInfoCompat obtain(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean) {
      return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(param1Int1, param1Int2, param1Int3, param1Int4, param1Boolean));
    }
    
    public static CollectionItemInfoCompat obtain(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean1, boolean param1Boolean2) {
      return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(param1Int1, param1Int2, param1Int3, param1Int4, param1Boolean1, param1Boolean2));
    }
    
    public int getColumnIndex() {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnIndex(this.mInfo);
    }
    
    public int getColumnSpan() {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnSpan(this.mInfo);
    }
    
    public int getRowIndex() {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowIndex(this.mInfo);
    }
    
    public int getRowSpan() {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowSpan(this.mInfo);
    }
    
    public boolean isHeading() {
      return AccessibilityNodeInfoCompat.IMPL.isCollectionItemHeading(this.mInfo);
    }
    
    public boolean isSelected() {
      return AccessibilityNodeInfoCompat.IMPL.isCollectionItemSelected(this.mInfo);
    }
  }
  
  public static class RangeInfoCompat {
    public static final int RANGE_TYPE_FLOAT = 1;
    
    public static final int RANGE_TYPE_INT = 0;
    
    public static final int RANGE_TYPE_PERCENT = 2;
    
    final Object mInfo;
    
    RangeInfoCompat(Object param1Object) {
      this.mInfo = param1Object;
    }
    
    public static RangeInfoCompat obtain(int param1Int, float param1Float1, float param1Float2, float param1Float3) {
      return new RangeInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainRangeInfo(param1Int, param1Float1, param1Float2, param1Float3));
    }
    
    public float getCurrent() {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getCurrent(this.mInfo);
    }
    
    public float getMax() {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMax(this.mInfo);
    }
    
    public float getMin() {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMin(this.mInfo);
    }
    
    public int getType() {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getType(this.mInfo);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityNodeInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */