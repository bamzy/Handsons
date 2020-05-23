package android.support.v4.view.accessibility;

import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import java.util.Collections;
import java.util.List;

public class AccessibilityRecordCompat {
  private static final AccessibilityRecordImpl IMPL = new AccessibilityRecordStubImpl();
  
  private final Object mRecord;
  
  @Deprecated
  public AccessibilityRecordCompat(Object paramObject) {
    this.mRecord = paramObject;
  }
  
  public static AccessibilityRecordCompat obtain() {
    return new AccessibilityRecordCompat(IMPL.obtain());
  }
  
  public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat paramAccessibilityRecordCompat) {
    return new AccessibilityRecordCompat(IMPL.obtain(paramAccessibilityRecordCompat.mRecord));
  }
  
  public boolean equals(Object paramObject) {
    if (this != paramObject) {
      if (paramObject == null)
        return false; 
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      if (this.mRecord == null)
        return !(((AccessibilityRecordCompat)paramObject).mRecord != null); 
      if (!this.mRecord.equals(((AccessibilityRecordCompat)paramObject).mRecord))
        return false; 
    } 
    return true;
  }
  
  public int getAddedCount() {
    return IMPL.getAddedCount(this.mRecord);
  }
  
  public CharSequence getBeforeText() {
    return IMPL.getBeforeText(this.mRecord);
  }
  
  public CharSequence getClassName() {
    return IMPL.getClassName(this.mRecord);
  }
  
  public CharSequence getContentDescription() {
    return IMPL.getContentDescription(this.mRecord);
  }
  
  public int getCurrentItemIndex() {
    return IMPL.getCurrentItemIndex(this.mRecord);
  }
  
  public int getFromIndex() {
    return IMPL.getFromIndex(this.mRecord);
  }
  
  @Deprecated
  public Object getImpl() {
    return this.mRecord;
  }
  
  public int getItemCount() {
    return IMPL.getItemCount(this.mRecord);
  }
  
  public int getMaxScrollX() {
    return IMPL.getMaxScrollX(this.mRecord);
  }
  
  public int getMaxScrollY() {
    return IMPL.getMaxScrollY(this.mRecord);
  }
  
  public Parcelable getParcelableData() {
    return IMPL.getParcelableData(this.mRecord);
  }
  
  public int getRemovedCount() {
    return IMPL.getRemovedCount(this.mRecord);
  }
  
  public int getScrollX() {
    return IMPL.getScrollX(this.mRecord);
  }
  
  public int getScrollY() {
    return IMPL.getScrollY(this.mRecord);
  }
  
  public AccessibilityNodeInfoCompat getSource() {
    return IMPL.getSource(this.mRecord);
  }
  
  public List<CharSequence> getText() {
    return IMPL.getText(this.mRecord);
  }
  
  public int getToIndex() {
    return IMPL.getToIndex(this.mRecord);
  }
  
  public int getWindowId() {
    return IMPL.getWindowId(this.mRecord);
  }
  
  public int hashCode() {
    return (this.mRecord == null) ? 0 : this.mRecord.hashCode();
  }
  
  public boolean isChecked() {
    return IMPL.isChecked(this.mRecord);
  }
  
  public boolean isEnabled() {
    return IMPL.isEnabled(this.mRecord);
  }
  
  public boolean isFullScreen() {
    return IMPL.isFullScreen(this.mRecord);
  }
  
  public boolean isPassword() {
    return IMPL.isPassword(this.mRecord);
  }
  
  public boolean isScrollable() {
    return IMPL.isScrollable(this.mRecord);
  }
  
  public void recycle() {
    IMPL.recycle(this.mRecord);
  }
  
  public void setAddedCount(int paramInt) {
    IMPL.setAddedCount(this.mRecord, paramInt);
  }
  
  public void setBeforeText(CharSequence paramCharSequence) {
    IMPL.setBeforeText(this.mRecord, paramCharSequence);
  }
  
  public void setChecked(boolean paramBoolean) {
    IMPL.setChecked(this.mRecord, paramBoolean);
  }
  
  public void setClassName(CharSequence paramCharSequence) {
    IMPL.setClassName(this.mRecord, paramCharSequence);
  }
  
  public void setContentDescription(CharSequence paramCharSequence) {
    IMPL.setContentDescription(this.mRecord, paramCharSequence);
  }
  
  public void setCurrentItemIndex(int paramInt) {
    IMPL.setCurrentItemIndex(this.mRecord, paramInt);
  }
  
  public void setEnabled(boolean paramBoolean) {
    IMPL.setEnabled(this.mRecord, paramBoolean);
  }
  
  public void setFromIndex(int paramInt) {
    IMPL.setFromIndex(this.mRecord, paramInt);
  }
  
  public void setFullScreen(boolean paramBoolean) {
    IMPL.setFullScreen(this.mRecord, paramBoolean);
  }
  
  public void setItemCount(int paramInt) {
    IMPL.setItemCount(this.mRecord, paramInt);
  }
  
  public void setMaxScrollX(int paramInt) {
    IMPL.setMaxScrollX(this.mRecord, paramInt);
  }
  
  public void setMaxScrollY(int paramInt) {
    IMPL.setMaxScrollY(this.mRecord, paramInt);
  }
  
  public void setParcelableData(Parcelable paramParcelable) {
    IMPL.setParcelableData(this.mRecord, paramParcelable);
  }
  
  public void setPassword(boolean paramBoolean) {
    IMPL.setPassword(this.mRecord, paramBoolean);
  }
  
  public void setRemovedCount(int paramInt) {
    IMPL.setRemovedCount(this.mRecord, paramInt);
  }
  
  public void setScrollX(int paramInt) {
    IMPL.setScrollX(this.mRecord, paramInt);
  }
  
  public void setScrollY(int paramInt) {
    IMPL.setScrollY(this.mRecord, paramInt);
  }
  
  public void setScrollable(boolean paramBoolean) {
    IMPL.setScrollable(this.mRecord, paramBoolean);
  }
  
  public void setSource(View paramView) {
    IMPL.setSource(this.mRecord, paramView);
  }
  
  public void setSource(View paramView, int paramInt) {
    IMPL.setSource(this.mRecord, paramView, paramInt);
  }
  
  public void setToIndex(int paramInt) {
    IMPL.setToIndex(this.mRecord, paramInt);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new AccessibilityRecordJellyBeanImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 15) {
      IMPL = new AccessibilityRecordIcsMr1Impl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new AccessibilityRecordIcsImpl();
      return;
    } 
  }
  
  static class AccessibilityRecordIcsImpl extends AccessibilityRecordStubImpl {
    public int getAddedCount(Object param1Object) {
      return AccessibilityRecordCompatIcs.getAddedCount(param1Object);
    }
    
    public CharSequence getBeforeText(Object param1Object) {
      return AccessibilityRecordCompatIcs.getBeforeText(param1Object);
    }
    
    public CharSequence getClassName(Object param1Object) {
      return AccessibilityRecordCompatIcs.getClassName(param1Object);
    }
    
    public CharSequence getContentDescription(Object param1Object) {
      return AccessibilityRecordCompatIcs.getContentDescription(param1Object);
    }
    
    public int getCurrentItemIndex(Object param1Object) {
      return AccessibilityRecordCompatIcs.getCurrentItemIndex(param1Object);
    }
    
    public int getFromIndex(Object param1Object) {
      return AccessibilityRecordCompatIcs.getFromIndex(param1Object);
    }
    
    public int getItemCount(Object param1Object) {
      return AccessibilityRecordCompatIcs.getItemCount(param1Object);
    }
    
    public Parcelable getParcelableData(Object param1Object) {
      return AccessibilityRecordCompatIcs.getParcelableData(param1Object);
    }
    
    public int getRemovedCount(Object param1Object) {
      return AccessibilityRecordCompatIcs.getRemovedCount(param1Object);
    }
    
    public int getScrollX(Object param1Object) {
      return AccessibilityRecordCompatIcs.getScrollX(param1Object);
    }
    
    public int getScrollY(Object param1Object) {
      return AccessibilityRecordCompatIcs.getScrollY(param1Object);
    }
    
    public AccessibilityNodeInfoCompat getSource(Object param1Object) {
      return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityRecordCompatIcs.getSource(param1Object));
    }
    
    public List<CharSequence> getText(Object param1Object) {
      return AccessibilityRecordCompatIcs.getText(param1Object);
    }
    
    public int getToIndex(Object param1Object) {
      return AccessibilityRecordCompatIcs.getToIndex(param1Object);
    }
    
    public int getWindowId(Object param1Object) {
      return AccessibilityRecordCompatIcs.getWindowId(param1Object);
    }
    
    public boolean isChecked(Object param1Object) {
      return AccessibilityRecordCompatIcs.isChecked(param1Object);
    }
    
    public boolean isEnabled(Object param1Object) {
      return AccessibilityRecordCompatIcs.isEnabled(param1Object);
    }
    
    public boolean isFullScreen(Object param1Object) {
      return AccessibilityRecordCompatIcs.isFullScreen(param1Object);
    }
    
    public boolean isPassword(Object param1Object) {
      return AccessibilityRecordCompatIcs.isPassword(param1Object);
    }
    
    public boolean isScrollable(Object param1Object) {
      return AccessibilityRecordCompatIcs.isScrollable(param1Object);
    }
    
    public Object obtain() {
      return AccessibilityRecordCompatIcs.obtain();
    }
    
    public Object obtain(Object param1Object) {
      return AccessibilityRecordCompatIcs.obtain(param1Object);
    }
    
    public void recycle(Object param1Object) {
      AccessibilityRecordCompatIcs.recycle(param1Object);
    }
    
    public void setAddedCount(Object param1Object, int param1Int) {
      AccessibilityRecordCompatIcs.setAddedCount(param1Object, param1Int);
    }
    
    public void setBeforeText(Object param1Object, CharSequence param1CharSequence) {
      AccessibilityRecordCompatIcs.setBeforeText(param1Object, param1CharSequence);
    }
    
    public void setChecked(Object param1Object, boolean param1Boolean) {
      AccessibilityRecordCompatIcs.setChecked(param1Object, param1Boolean);
    }
    
    public void setClassName(Object param1Object, CharSequence param1CharSequence) {
      AccessibilityRecordCompatIcs.setClassName(param1Object, param1CharSequence);
    }
    
    public void setContentDescription(Object param1Object, CharSequence param1CharSequence) {
      AccessibilityRecordCompatIcs.setContentDescription(param1Object, param1CharSequence);
    }
    
    public void setCurrentItemIndex(Object param1Object, int param1Int) {
      AccessibilityRecordCompatIcs.setCurrentItemIndex(param1Object, param1Int);
    }
    
    public void setEnabled(Object param1Object, boolean param1Boolean) {
      AccessibilityRecordCompatIcs.setEnabled(param1Object, param1Boolean);
    }
    
    public void setFromIndex(Object param1Object, int param1Int) {
      AccessibilityRecordCompatIcs.setFromIndex(param1Object, param1Int);
    }
    
    public void setFullScreen(Object param1Object, boolean param1Boolean) {
      AccessibilityRecordCompatIcs.setFullScreen(param1Object, param1Boolean);
    }
    
    public void setItemCount(Object param1Object, int param1Int) {
      AccessibilityRecordCompatIcs.setItemCount(param1Object, param1Int);
    }
    
    public void setParcelableData(Object param1Object, Parcelable param1Parcelable) {
      AccessibilityRecordCompatIcs.setParcelableData(param1Object, param1Parcelable);
    }
    
    public void setPassword(Object param1Object, boolean param1Boolean) {
      AccessibilityRecordCompatIcs.setPassword(param1Object, param1Boolean);
    }
    
    public void setRemovedCount(Object param1Object, int param1Int) {
      AccessibilityRecordCompatIcs.setRemovedCount(param1Object, param1Int);
    }
    
    public void setScrollX(Object param1Object, int param1Int) {
      AccessibilityRecordCompatIcs.setScrollX(param1Object, param1Int);
    }
    
    public void setScrollY(Object param1Object, int param1Int) {
      AccessibilityRecordCompatIcs.setScrollY(param1Object, param1Int);
    }
    
    public void setScrollable(Object param1Object, boolean param1Boolean) {
      AccessibilityRecordCompatIcs.setScrollable(param1Object, param1Boolean);
    }
    
    public void setSource(Object param1Object, View param1View) {
      AccessibilityRecordCompatIcs.setSource(param1Object, param1View);
    }
    
    public void setToIndex(Object param1Object, int param1Int) {
      AccessibilityRecordCompatIcs.setToIndex(param1Object, param1Int);
    }
  }
  
  static class AccessibilityRecordIcsMr1Impl extends AccessibilityRecordIcsImpl {
    public int getMaxScrollX(Object param1Object) {
      return AccessibilityRecordCompatIcsMr1.getMaxScrollX(param1Object);
    }
    
    public int getMaxScrollY(Object param1Object) {
      return AccessibilityRecordCompatIcsMr1.getMaxScrollY(param1Object);
    }
    
    public void setMaxScrollX(Object param1Object, int param1Int) {
      AccessibilityRecordCompatIcsMr1.setMaxScrollX(param1Object, param1Int);
    }
    
    public void setMaxScrollY(Object param1Object, int param1Int) {
      AccessibilityRecordCompatIcsMr1.setMaxScrollY(param1Object, param1Int);
    }
  }
  
  static interface AccessibilityRecordImpl {
    int getAddedCount(Object param1Object);
    
    CharSequence getBeforeText(Object param1Object);
    
    CharSequence getClassName(Object param1Object);
    
    CharSequence getContentDescription(Object param1Object);
    
    int getCurrentItemIndex(Object param1Object);
    
    int getFromIndex(Object param1Object);
    
    int getItemCount(Object param1Object);
    
    int getMaxScrollX(Object param1Object);
    
    int getMaxScrollY(Object param1Object);
    
    Parcelable getParcelableData(Object param1Object);
    
    int getRemovedCount(Object param1Object);
    
    int getScrollX(Object param1Object);
    
    int getScrollY(Object param1Object);
    
    AccessibilityNodeInfoCompat getSource(Object param1Object);
    
    List<CharSequence> getText(Object param1Object);
    
    int getToIndex(Object param1Object);
    
    int getWindowId(Object param1Object);
    
    boolean isChecked(Object param1Object);
    
    boolean isEnabled(Object param1Object);
    
    boolean isFullScreen(Object param1Object);
    
    boolean isPassword(Object param1Object);
    
    boolean isScrollable(Object param1Object);
    
    Object obtain();
    
    Object obtain(Object param1Object);
    
    void recycle(Object param1Object);
    
    void setAddedCount(Object param1Object, int param1Int);
    
    void setBeforeText(Object param1Object, CharSequence param1CharSequence);
    
    void setChecked(Object param1Object, boolean param1Boolean);
    
    void setClassName(Object param1Object, CharSequence param1CharSequence);
    
    void setContentDescription(Object param1Object, CharSequence param1CharSequence);
    
    void setCurrentItemIndex(Object param1Object, int param1Int);
    
    void setEnabled(Object param1Object, boolean param1Boolean);
    
    void setFromIndex(Object param1Object, int param1Int);
    
    void setFullScreen(Object param1Object, boolean param1Boolean);
    
    void setItemCount(Object param1Object, int param1Int);
    
    void setMaxScrollX(Object param1Object, int param1Int);
    
    void setMaxScrollY(Object param1Object, int param1Int);
    
    void setParcelableData(Object param1Object, Parcelable param1Parcelable);
    
    void setPassword(Object param1Object, boolean param1Boolean);
    
    void setRemovedCount(Object param1Object, int param1Int);
    
    void setScrollX(Object param1Object, int param1Int);
    
    void setScrollY(Object param1Object, int param1Int);
    
    void setScrollable(Object param1Object, boolean param1Boolean);
    
    void setSource(Object param1Object, View param1View);
    
    void setSource(Object param1Object, View param1View, int param1Int);
    
    void setToIndex(Object param1Object, int param1Int);
  }
  
  static class AccessibilityRecordJellyBeanImpl extends AccessibilityRecordIcsMr1Impl {
    public void setSource(Object param1Object, View param1View, int param1Int) {
      AccessibilityRecordCompatJellyBean.setSource(param1Object, param1View, param1Int);
    }
  }
  
  static class AccessibilityRecordStubImpl implements AccessibilityRecordImpl {
    public int getAddedCount(Object param1Object) {
      return 0;
    }
    
    public CharSequence getBeforeText(Object param1Object) {
      return null;
    }
    
    public CharSequence getClassName(Object param1Object) {
      return null;
    }
    
    public CharSequence getContentDescription(Object param1Object) {
      return null;
    }
    
    public int getCurrentItemIndex(Object param1Object) {
      return 0;
    }
    
    public int getFromIndex(Object param1Object) {
      return 0;
    }
    
    public int getItemCount(Object param1Object) {
      return 0;
    }
    
    public int getMaxScrollX(Object param1Object) {
      return 0;
    }
    
    public int getMaxScrollY(Object param1Object) {
      return 0;
    }
    
    public Parcelable getParcelableData(Object param1Object) {
      return null;
    }
    
    public int getRemovedCount(Object param1Object) {
      return 0;
    }
    
    public int getScrollX(Object param1Object) {
      return 0;
    }
    
    public int getScrollY(Object param1Object) {
      return 0;
    }
    
    public AccessibilityNodeInfoCompat getSource(Object param1Object) {
      return null;
    }
    
    public List<CharSequence> getText(Object param1Object) {
      return Collections.emptyList();
    }
    
    public int getToIndex(Object param1Object) {
      return 0;
    }
    
    public int getWindowId(Object param1Object) {
      return 0;
    }
    
    public boolean isChecked(Object param1Object) {
      return false;
    }
    
    public boolean isEnabled(Object param1Object) {
      return false;
    }
    
    public boolean isFullScreen(Object param1Object) {
      return false;
    }
    
    public boolean isPassword(Object param1Object) {
      return false;
    }
    
    public boolean isScrollable(Object param1Object) {
      return false;
    }
    
    public Object obtain() {
      return null;
    }
    
    public Object obtain(Object param1Object) {
      return null;
    }
    
    public void recycle(Object param1Object) {}
    
    public void setAddedCount(Object param1Object, int param1Int) {}
    
    public void setBeforeText(Object param1Object, CharSequence param1CharSequence) {}
    
    public void setChecked(Object param1Object, boolean param1Boolean) {}
    
    public void setClassName(Object param1Object, CharSequence param1CharSequence) {}
    
    public void setContentDescription(Object param1Object, CharSequence param1CharSequence) {}
    
    public void setCurrentItemIndex(Object param1Object, int param1Int) {}
    
    public void setEnabled(Object param1Object, boolean param1Boolean) {}
    
    public void setFromIndex(Object param1Object, int param1Int) {}
    
    public void setFullScreen(Object param1Object, boolean param1Boolean) {}
    
    public void setItemCount(Object param1Object, int param1Int) {}
    
    public void setMaxScrollX(Object param1Object, int param1Int) {}
    
    public void setMaxScrollY(Object param1Object, int param1Int) {}
    
    public void setParcelableData(Object param1Object, Parcelable param1Parcelable) {}
    
    public void setPassword(Object param1Object, boolean param1Boolean) {}
    
    public void setRemovedCount(Object param1Object, int param1Int) {}
    
    public void setScrollX(Object param1Object, int param1Int) {}
    
    public void setScrollY(Object param1Object, int param1Int) {}
    
    public void setScrollable(Object param1Object, boolean param1Boolean) {}
    
    public void setSource(Object param1Object, View param1View) {}
    
    public void setSource(Object param1Object, View param1View, int param1Int) {}
    
    public void setToIndex(Object param1Object, int param1Int) {}
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityRecordCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */