package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
  static final int HORIZ_POSITION_LEFT = 0;
  
  static final int HORIZ_POSITION_RIGHT = 1;
  
  static final int SUBMENU_TIMEOUT_MS = 200;
  
  private View mAnchorView;
  
  private final Context mContext;
  
  private int mDropDownGravity = 0;
  
  private boolean mForceShowIcon;
  
  private final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
      public void onGlobalLayout() {
        if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.mShowingMenus.size() > 0 && !((CascadingMenuPopup.CascadingMenuInfo)CascadingMenuPopup.this.mShowingMenus.get(0)).window.isModal()) {
          View view = CascadingMenuPopup.this.mShownAnchorView;
          if (view == null || !view.isShown()) {
            CascadingMenuPopup.this.dismiss();
            return;
          } 
        } else {
          return;
        } 
        Iterator<CascadingMenuPopup.CascadingMenuInfo> iterator = CascadingMenuPopup.this.mShowingMenus.iterator();
        while (true) {
          if (iterator.hasNext()) {
            ((CascadingMenuPopup.CascadingMenuInfo)iterator.next()).window.show();
            continue;
          } 
          return;
        } 
      }
    };
  
  private boolean mHasXOffset;
  
  private boolean mHasYOffset;
  
  private int mLastPosition;
  
  private final MenuItemHoverListener mMenuItemHoverListener = new MenuItemHoverListener() {
      public void onItemHoverEnter(@NonNull final MenuBuilder menu, @NonNull final MenuItem item) {
        CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(null);
        byte b = -1;
        int i = 0;
        int j = CascadingMenuPopup.this.mShowingMenus.size();
        while (true) {
          final CascadingMenuPopup.CascadingMenuInfo nextInfo;
          int k = b;
          if (i < j)
            if (menu == ((CascadingMenuPopup.CascadingMenuInfo)CascadingMenuPopup.this.mShowingMenus.get(i)).menu) {
              k = i;
            } else {
              i++;
              continue;
            }  
          if (k == -1)
            return; 
          i = k + 1;
          if (i < CascadingMenuPopup.this.mShowingMenus.size()) {
            cascadingMenuInfo = CascadingMenuPopup.this.mShowingMenus.get(i);
          } else {
            cascadingMenuInfo = null;
          } 
          Runnable runnable = new Runnable() {
              public void run() {
                if (nextInfo != null) {
                  CascadingMenuPopup.this.mShouldCloseImmediately = true;
                  nextInfo.menu.close(false);
                  CascadingMenuPopup.this.mShouldCloseImmediately = false;
                } 
                if (item.isEnabled() && item.hasSubMenu())
                  menu.performItemAction(item, 4); 
              }
            };
          long l = SystemClock.uptimeMillis();
          CascadingMenuPopup.this.mSubMenuHoverHandler.postAtTime(runnable, menu, l + 200L);
          return;
        } 
      }
      
      public void onItemHoverExit(@NonNull MenuBuilder param1MenuBuilder, @NonNull MenuItem param1MenuItem) {
        CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(param1MenuBuilder);
      }
    };
  
  private final int mMenuMaxWidth;
  
  private PopupWindow.OnDismissListener mOnDismissListener;
  
  private final boolean mOverflowOnly;
  
  private final List<MenuBuilder> mPendingMenus = new LinkedList<MenuBuilder>();
  
  private final int mPopupStyleAttr;
  
  private final int mPopupStyleRes;
  
  private MenuPresenter.Callback mPresenterCallback;
  
  private int mRawDropDownGravity = 0;
  
  boolean mShouldCloseImmediately;
  
  private boolean mShowTitle;
  
  final List<CascadingMenuInfo> mShowingMenus = new ArrayList<CascadingMenuInfo>();
  
  View mShownAnchorView;
  
  final Handler mSubMenuHoverHandler;
  
  private ViewTreeObserver mTreeObserver;
  
  private int mXOffset;
  
  private int mYOffset;
  
  public CascadingMenuPopup(@NonNull Context paramContext, @NonNull View paramView, @AttrRes int paramInt1, @StyleRes int paramInt2, boolean paramBoolean) {
    this.mContext = paramContext;
    this.mAnchorView = paramView;
    this.mPopupStyleAttr = paramInt1;
    this.mPopupStyleRes = paramInt2;
    this.mOverflowOnly = paramBoolean;
    this.mForceShowIcon = false;
    this.mLastPosition = getInitialMenuPosition();
    Resources resources = paramContext.getResources();
    this.mMenuMaxWidth = Math.max((resources.getDisplayMetrics()).widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.mSubMenuHoverHandler = new Handler();
  }
  
  private MenuPopupWindow createPopupWindow() {
    MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
    menuPopupWindow.setHoverListener(this.mMenuItemHoverListener);
    menuPopupWindow.setOnItemClickListener(this);
    menuPopupWindow.setOnDismissListener(this);
    menuPopupWindow.setAnchorView(this.mAnchorView);
    menuPopupWindow.setDropDownGravity(this.mDropDownGravity);
    menuPopupWindow.setModal(true);
    return menuPopupWindow;
  }
  
  private int findIndexOfAddedMenu(@NonNull MenuBuilder paramMenuBuilder) {
    int i = 0;
    int j = this.mShowingMenus.size();
    while (i < j) {
      if (paramMenuBuilder == ((CascadingMenuInfo)this.mShowingMenus.get(i)).menu)
        return i; 
      i++;
    } 
    return -1;
  }
  
  private MenuItem findMenuItemForSubmenu(@NonNull MenuBuilder paramMenuBuilder1, @NonNull MenuBuilder paramMenuBuilder2) {
    int i = 0;
    int j = paramMenuBuilder1.size();
    while (i < j) {
      MenuItem menuItem = paramMenuBuilder1.getItem(i);
      if (menuItem.hasSubMenu() && paramMenuBuilder2 == menuItem.getSubMenu())
        return menuItem; 
      i++;
    } 
    return null;
  }
  
  @Nullable
  private View findParentViewForSubmenu(@NonNull CascadingMenuInfo paramCascadingMenuInfo, @NonNull MenuBuilder paramMenuBuilder) {
    MenuItem menuItem = findMenuItemForSubmenu(paramCascadingMenuInfo.menu, paramMenuBuilder);
    if (menuItem != null) {
      MenuAdapter menuAdapter;
      byte b;
      ListView listView = paramCascadingMenuInfo.getListView();
      ListAdapter listAdapter = listView.getAdapter();
      if (listAdapter instanceof HeaderViewListAdapter) {
        HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter)listAdapter;
        b = headerViewListAdapter.getHeadersCount();
        menuAdapter = (MenuAdapter)headerViewListAdapter.getWrappedAdapter();
      } else {
        b = 0;
        menuAdapter = menuAdapter;
      } 
      byte b1 = -1;
      int i = 0;
      int j = menuAdapter.getCount();
      while (true) {
        int k = b1;
        if (i < j)
          if (menuItem == menuAdapter.getItem(i)) {
            k = i;
          } else {
            i++;
            continue;
          }  
        if (k != -1) {
          i = k + b - listView.getFirstVisiblePosition();
          if (i >= 0 && i < listView.getChildCount())
            return listView.getChildAt(i); 
        } 
        return null;
      } 
    } 
    return null;
  }
  
  private int getInitialMenuPosition() {
    boolean bool = true;
    if (ViewCompat.getLayoutDirection(this.mAnchorView) == 1)
      bool = false; 
    return bool;
  }
  
  private int getNextMenuPosition(int paramInt) {
    ListView listView = ((CascadingMenuInfo)this.mShowingMenus.get(this.mShowingMenus.size() - 1)).getListView();
    int[] arrayOfInt = new int[2];
    listView.getLocationOnScreen(arrayOfInt);
    Rect rect = new Rect();
    this.mShownAnchorView.getWindowVisibleDisplayFrame(rect);
    return (this.mLastPosition == 1) ? ((arrayOfInt[0] + listView.getWidth() + paramInt > rect.right) ? 0 : 1) : ((arrayOfInt[0] - paramInt < 0) ? 1 : 0);
  }
  
  private void showMenu(@NonNull MenuBuilder paramMenuBuilder) {
    View view;
    LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
    MenuAdapter menuAdapter = new MenuAdapter(paramMenuBuilder, layoutInflater, this.mOverflowOnly);
    if (!isShowing() && this.mForceShowIcon) {
      menuAdapter.setForceShowIcon(true);
    } else if (isShowing()) {
      menuAdapter.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(paramMenuBuilder));
    } 
    int i = measureIndividualMenuWidth((ListAdapter)menuAdapter, null, this.mContext, this.mMenuMaxWidth);
    MenuPopupWindow menuPopupWindow = createPopupWindow();
    menuPopupWindow.setAdapter((ListAdapter)menuAdapter);
    menuPopupWindow.setContentWidth(i);
    menuPopupWindow.setDropDownGravity(this.mDropDownGravity);
    if (this.mShowingMenus.size() > 0) {
      CascadingMenuInfo cascadingMenuInfo1 = this.mShowingMenus.get(this.mShowingMenus.size() - 1);
      view = findParentViewForSubmenu(cascadingMenuInfo1, paramMenuBuilder);
    } else {
      menuAdapter = null;
      view = null;
    } 
    if (view != null) {
      int j;
      menuPopupWindow.setTouchModal(false);
      menuPopupWindow.setEnterTransition(null);
      int k = getNextMenuPosition(i);
      if (k == 1) {
        j = 1;
      } else {
        j = 0;
      } 
      this.mLastPosition = k;
      int[] arrayOfInt = new int[2];
      view.getLocationInWindow(arrayOfInt);
      int n = ((CascadingMenuInfo)menuAdapter).window.getHorizontalOffset() + arrayOfInt[0];
      k = ((CascadingMenuInfo)menuAdapter).window.getVerticalOffset();
      int m = arrayOfInt[1];
      if ((this.mDropDownGravity & 0x5) == 5) {
        if (j) {
          j = n + i;
        } else {
          j = n - view.getWidth();
        } 
      } else if (j != 0) {
        j = n + view.getWidth();
      } else {
        j = n - i;
      } 
      menuPopupWindow.setHorizontalOffset(j);
      menuPopupWindow.setVerticalOffset(k + m);
    } else {
      if (this.mHasXOffset)
        menuPopupWindow.setHorizontalOffset(this.mXOffset); 
      if (this.mHasYOffset)
        menuPopupWindow.setVerticalOffset(this.mYOffset); 
      menuPopupWindow.setEpicenterBounds(getEpicenterBounds());
    } 
    CascadingMenuInfo cascadingMenuInfo = new CascadingMenuInfo(menuPopupWindow, paramMenuBuilder, this.mLastPosition);
    this.mShowingMenus.add(cascadingMenuInfo);
    menuPopupWindow.show();
    if (menuAdapter == null && this.mShowTitle && paramMenuBuilder.getHeaderTitle() != null) {
      ListView listView = menuPopupWindow.getListView();
      FrameLayout frameLayout = (FrameLayout)layoutInflater.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)listView, false);
      TextView textView = (TextView)frameLayout.findViewById(16908310);
      frameLayout.setEnabled(false);
      textView.setText(paramMenuBuilder.getHeaderTitle());
      listView.addHeaderView((View)frameLayout, null, false);
      menuPopupWindow.show();
    } 
  }
  
  public void addMenu(MenuBuilder paramMenuBuilder) {
    paramMenuBuilder.addMenuPresenter(this, this.mContext);
    if (isShowing()) {
      showMenu(paramMenuBuilder);
      return;
    } 
    this.mPendingMenus.add(paramMenuBuilder);
  }
  
  protected boolean closeMenuOnSubMenuOpened() {
    return false;
  }
  
  public void dismiss() {
    int i = this.mShowingMenus.size();
    if (i > 0) {
      CascadingMenuInfo[] arrayOfCascadingMenuInfo = this.mShowingMenus.<CascadingMenuInfo>toArray(new CascadingMenuInfo[i]);
      while (--i >= 0) {
        CascadingMenuInfo cascadingMenuInfo = arrayOfCascadingMenuInfo[i];
        if (cascadingMenuInfo.window.isShowing())
          cascadingMenuInfo.window.dismiss(); 
        i--;
      } 
    } 
  }
  
  public boolean flagActionItems() {
    return false;
  }
  
  public ListView getListView() {
    return this.mShowingMenus.isEmpty() ? null : ((CascadingMenuInfo)this.mShowingMenus.get(this.mShowingMenus.size() - 1)).getListView();
  }
  
  public boolean isShowing() {
    return (this.mShowingMenus.size() > 0 && ((CascadingMenuInfo)this.mShowingMenus.get(0)).window.isShowing());
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    int i = findIndexOfAddedMenu(paramMenuBuilder);
    if (i >= 0) {
      int j = i + 1;
      if (j < this.mShowingMenus.size())
        ((CascadingMenuInfo)this.mShowingMenus.get(j)).menu.close(false); 
      CascadingMenuInfo cascadingMenuInfo = this.mShowingMenus.remove(i);
      cascadingMenuInfo.menu.removeMenuPresenter(this);
      if (this.mShouldCloseImmediately) {
        cascadingMenuInfo.window.setExitTransition(null);
        cascadingMenuInfo.window.setAnimationStyle(0);
      } 
      cascadingMenuInfo.window.dismiss();
      i = this.mShowingMenus.size();
      if (i > 0) {
        this.mLastPosition = ((CascadingMenuInfo)this.mShowingMenus.get(i - 1)).position;
      } else {
        this.mLastPosition = getInitialMenuPosition();
      } 
      if (i == 0) {
        dismiss();
        if (this.mPresenterCallback != null)
          this.mPresenterCallback.onCloseMenu(paramMenuBuilder, true); 
        if (this.mTreeObserver != null) {
          if (this.mTreeObserver.isAlive())
            this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener); 
          this.mTreeObserver = null;
        } 
        this.mOnDismissListener.onDismiss();
        return;
      } 
      if (paramBoolean) {
        ((CascadingMenuInfo)this.mShowingMenus.get(0)).menu.close(false);
        return;
      } 
    } 
  }
  
  public void onDismiss() {
    CascadingMenuInfo cascadingMenuInfo = null;
    int i = 0;
    int j = this.mShowingMenus.size();
    while (true) {
      CascadingMenuInfo cascadingMenuInfo1 = cascadingMenuInfo;
      if (i < j) {
        cascadingMenuInfo1 = this.mShowingMenus.get(i);
        if (cascadingMenuInfo1.window.isShowing()) {
          i++;
          continue;
        } 
      } 
      if (cascadingMenuInfo1 != null)
        cascadingMenuInfo1.menu.close(false); 
      return;
    } 
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 1 && paramInt == 82) {
      dismiss();
      return true;
    } 
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState() {
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    for (CascadingMenuInfo cascadingMenuInfo : this.mShowingMenus) {
      if (paramSubMenuBuilder == cascadingMenuInfo.menu) {
        cascadingMenuInfo.getListView().requestFocus();
        return true;
      } 
    } 
    if (paramSubMenuBuilder.hasVisibleItems()) {
      addMenu(paramSubMenuBuilder);
      if (this.mPresenterCallback != null) {
        this.mPresenterCallback.onOpenSubMenu(paramSubMenuBuilder);
        return true;
      } 
      return true;
    } 
    return false;
  }
  
  public void setAnchorView(@NonNull View paramView) {
    if (this.mAnchorView != paramView) {
      this.mAnchorView = paramView;
      this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView));
    } 
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {
    this.mPresenterCallback = paramCallback;
  }
  
  public void setForceShowIcon(boolean paramBoolean) {
    this.mForceShowIcon = paramBoolean;
  }
  
  public void setGravity(int paramInt) {
    if (this.mRawDropDownGravity != paramInt) {
      this.mRawDropDownGravity = paramInt;
      this.mDropDownGravity = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this.mAnchorView));
    } 
  }
  
  public void setHorizontalOffset(int paramInt) {
    this.mHasXOffset = true;
    this.mXOffset = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public void setShowTitle(boolean paramBoolean) {
    this.mShowTitle = paramBoolean;
  }
  
  public void setVerticalOffset(int paramInt) {
    this.mHasYOffset = true;
    this.mYOffset = paramInt;
  }
  
  public void show() {
    if (!isShowing()) {
      Iterator<MenuBuilder> iterator = this.mPendingMenus.iterator();
      while (iterator.hasNext())
        showMenu(iterator.next()); 
      this.mPendingMenus.clear();
      this.mShownAnchorView = this.mAnchorView;
      if (this.mShownAnchorView != null) {
        boolean bool;
        if (this.mTreeObserver == null) {
          bool = true;
        } else {
          bool = false;
        } 
        this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
        if (bool) {
          this.mTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
          return;
        } 
      } 
    } 
  }
  
  public void updateMenuView(boolean paramBoolean) {
    Iterator<CascadingMenuInfo> iterator = this.mShowingMenus.iterator();
    while (iterator.hasNext())
      toMenuAdapter(((CascadingMenuInfo)iterator.next()).getListView().getAdapter()).notifyDataSetChanged(); 
  }
  
  private static class CascadingMenuInfo {
    public final MenuBuilder menu;
    
    public final int position;
    
    public final MenuPopupWindow window;
    
    public CascadingMenuInfo(@NonNull MenuPopupWindow param1MenuPopupWindow, @NonNull MenuBuilder param1MenuBuilder, int param1Int) {
      this.window = param1MenuPopupWindow;
      this.menu = param1MenuBuilder;
      this.position = param1Int;
    }
    
    public ListView getListView() {
      return this.window.getListView();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HorizPosition {}
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\view\menu\CascadingMenuPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */