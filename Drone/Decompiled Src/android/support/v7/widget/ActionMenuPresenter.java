package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.support.v7.transition.ActionBarTransition;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
  private static final String TAG = "ActionMenuPresenter";
  
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  
  ActionButtonSubmenu mActionButtonPopup;
  
  private int mActionItemWidthLimit;
  
  private boolean mExpandedActionViewsExclusive;
  
  private int mMaxItems;
  
  private boolean mMaxItemsSet;
  
  private int mMinCellSize;
  
  int mOpenSubMenuId;
  
  OverflowMenuButton mOverflowButton;
  
  OverflowPopup mOverflowPopup;
  
  private Drawable mPendingOverflowIcon;
  
  private boolean mPendingOverflowIconSet;
  
  private ActionMenuPopupCallback mPopupCallback;
  
  final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
  
  OpenOverflowRunnable mPostedOpenRunnable;
  
  private boolean mReserveOverflow;
  
  private boolean mReserveOverflowSet;
  
  private View mScrapActionButtonView;
  
  private boolean mStrictWidthLimit;
  
  private int mWidthLimit;
  
  private boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext) {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  private View findViewForItem(MenuItem paramMenuItem) {
    ViewGroup viewGroup = (ViewGroup)this.mMenuView;
    if (viewGroup == null)
      return null; 
    int j = viewGroup.getChildCount();
    for (int i = 0; i < j; i++) {
      View view = viewGroup.getChildAt(i);
      if (view instanceof MenuView.ItemView) {
        View view1 = view;
        if (((MenuView.ItemView)view).getItemData() != paramMenuItem)
          continue; 
        return view1;
      } 
      continue;
    } 
    return null;
  }
  
  public void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView) {
    paramItemView.initialize(paramMenuItemImpl, 0);
    ActionMenuView actionMenuView = (ActionMenuView)this.mMenuView;
    ActionMenuItemView actionMenuItemView = (ActionMenuItemView)paramItemView;
    actionMenuItemView.setItemInvoker(actionMenuView);
    if (this.mPopupCallback == null)
      this.mPopupCallback = new ActionMenuPopupCallback(); 
    actionMenuItemView.setPopupCallback(this.mPopupCallback);
  }
  
  public boolean dismissPopupMenus() {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt) {
    return (paramViewGroup.getChildAt(paramInt) == this.mOverflowButton) ? false : super.filterLeftoverView(paramViewGroup, paramInt);
  }
  
  public boolean flagActionItems() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   4: ifnull -> 126
    //   7: aload_0
    //   8: getfield mMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   11: invokevirtual getVisibleItems : ()Ljava/util/ArrayList;
    //   14: astore #16
    //   16: aload #16
    //   18: invokevirtual size : ()I
    //   21: istore #8
    //   23: aload_0
    //   24: getfield mMaxItems : I
    //   27: istore_1
    //   28: aload_0
    //   29: getfield mActionItemWidthLimit : I
    //   32: istore #10
    //   34: iconst_0
    //   35: iconst_0
    //   36: invokestatic makeMeasureSpec : (II)I
    //   39: istore #11
    //   41: aload_0
    //   42: getfield mMenuView : Landroid/support/v7/view/menu/MenuView;
    //   45: checkcast android/view/ViewGroup
    //   48: astore #17
    //   50: iconst_0
    //   51: istore_2
    //   52: iconst_0
    //   53: istore #4
    //   55: iconst_0
    //   56: istore #7
    //   58: iconst_0
    //   59: istore #5
    //   61: iconst_0
    //   62: istore_3
    //   63: iload_3
    //   64: iload #8
    //   66: if_icmpge -> 158
    //   69: aload #16
    //   71: iload_3
    //   72: invokevirtual get : (I)Ljava/lang/Object;
    //   75: checkcast android/support/v7/view/menu/MenuItemImpl
    //   78: astore #18
    //   80: aload #18
    //   82: invokevirtual requiresActionButton : ()Z
    //   85: ifeq -> 135
    //   88: iload_2
    //   89: iconst_1
    //   90: iadd
    //   91: istore_2
    //   92: iload_1
    //   93: istore #6
    //   95: aload_0
    //   96: getfield mExpandedActionViewsExclusive : Z
    //   99: ifeq -> 116
    //   102: iload_1
    //   103: istore #6
    //   105: aload #18
    //   107: invokevirtual isActionViewExpanded : ()Z
    //   110: ifeq -> 116
    //   113: iconst_0
    //   114: istore #6
    //   116: iload_3
    //   117: iconst_1
    //   118: iadd
    //   119: istore_3
    //   120: iload #6
    //   122: istore_1
    //   123: goto -> 63
    //   126: aconst_null
    //   127: astore #16
    //   129: iconst_0
    //   130: istore #8
    //   132: goto -> 23
    //   135: aload #18
    //   137: invokevirtual requestsActionButton : ()Z
    //   140: ifeq -> 152
    //   143: iload #4
    //   145: iconst_1
    //   146: iadd
    //   147: istore #4
    //   149: goto -> 92
    //   152: iconst_1
    //   153: istore #5
    //   155: goto -> 92
    //   158: iload_1
    //   159: istore_3
    //   160: aload_0
    //   161: getfield mReserveOverflow : Z
    //   164: ifeq -> 186
    //   167: iload #5
    //   169: ifne -> 182
    //   172: iload_1
    //   173: istore_3
    //   174: iload_2
    //   175: iload #4
    //   177: iadd
    //   178: iload_1
    //   179: if_icmple -> 186
    //   182: iload_1
    //   183: iconst_1
    //   184: isub
    //   185: istore_3
    //   186: iload_3
    //   187: iload_2
    //   188: isub
    //   189: istore_3
    //   190: aload_0
    //   191: getfield mActionButtonGroups : Landroid/util/SparseBooleanArray;
    //   194: astore #18
    //   196: aload #18
    //   198: invokevirtual clear : ()V
    //   201: iconst_0
    //   202: istore #9
    //   204: iconst_0
    //   205: istore_2
    //   206: aload_0
    //   207: getfield mStrictWidthLimit : Z
    //   210: ifeq -> 239
    //   213: iload #10
    //   215: aload_0
    //   216: getfield mMinCellSize : I
    //   219: idiv
    //   220: istore_2
    //   221: aload_0
    //   222: getfield mMinCellSize : I
    //   225: istore_1
    //   226: aload_0
    //   227: getfield mMinCellSize : I
    //   230: iload #10
    //   232: iload_1
    //   233: irem
    //   234: iload_2
    //   235: idiv
    //   236: iadd
    //   237: istore #9
    //   239: iconst_0
    //   240: istore_1
    //   241: iload #10
    //   243: istore #5
    //   245: iload_1
    //   246: istore #10
    //   248: iload #7
    //   250: istore_1
    //   251: iload #10
    //   253: iload #8
    //   255: if_icmpge -> 775
    //   258: aload #16
    //   260: iload #10
    //   262: invokevirtual get : (I)Ljava/lang/Object;
    //   265: checkcast android/support/v7/view/menu/MenuItemImpl
    //   268: astore #19
    //   270: aload #19
    //   272: invokevirtual requiresActionButton : ()Z
    //   275: ifeq -> 402
    //   278: aload_0
    //   279: aload #19
    //   281: aload_0
    //   282: getfield mScrapActionButtonView : Landroid/view/View;
    //   285: aload #17
    //   287: invokevirtual getItemView : (Landroid/support/v7/view/menu/MenuItemImpl;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   290: astore #20
    //   292: aload_0
    //   293: getfield mScrapActionButtonView : Landroid/view/View;
    //   296: ifnonnull -> 305
    //   299: aload_0
    //   300: aload #20
    //   302: putfield mScrapActionButtonView : Landroid/view/View;
    //   305: aload_0
    //   306: getfield mStrictWidthLimit : Z
    //   309: ifeq -> 390
    //   312: iload_2
    //   313: aload #20
    //   315: iload #9
    //   317: iload_2
    //   318: iload #11
    //   320: iconst_0
    //   321: invokestatic measureChildForCells : (Landroid/view/View;IIII)I
    //   324: isub
    //   325: istore_2
    //   326: aload #20
    //   328: invokevirtual getMeasuredWidth : ()I
    //   331: istore #6
    //   333: iload #5
    //   335: iload #6
    //   337: isub
    //   338: istore #4
    //   340: iload_1
    //   341: istore #5
    //   343: iload_1
    //   344: ifne -> 351
    //   347: iload #6
    //   349: istore #5
    //   351: aload #19
    //   353: invokevirtual getGroupId : ()I
    //   356: istore_1
    //   357: iload_1
    //   358: ifeq -> 368
    //   361: aload #18
    //   363: iload_1
    //   364: iconst_1
    //   365: invokevirtual put : (IZ)V
    //   368: aload #19
    //   370: iconst_1
    //   371: invokevirtual setIsActionButton : (Z)V
    //   374: iload #5
    //   376: istore_1
    //   377: iload #10
    //   379: iconst_1
    //   380: iadd
    //   381: istore #10
    //   383: iload #4
    //   385: istore #5
    //   387: goto -> 251
    //   390: aload #20
    //   392: iload #11
    //   394: iload #11
    //   396: invokevirtual measure : (II)V
    //   399: goto -> 326
    //   402: aload #19
    //   404: invokevirtual requestsActionButton : ()Z
    //   407: ifeq -> 762
    //   410: aload #19
    //   412: invokevirtual getGroupId : ()I
    //   415: istore #12
    //   417: aload #18
    //   419: iload #12
    //   421: invokevirtual get : (I)Z
    //   424: istore #15
    //   426: iload_3
    //   427: ifgt -> 435
    //   430: iload #15
    //   432: ifeq -> 635
    //   435: iload #5
    //   437: ifle -> 635
    //   440: aload_0
    //   441: getfield mStrictWidthLimit : Z
    //   444: ifeq -> 451
    //   447: iload_2
    //   448: ifle -> 635
    //   451: iconst_1
    //   452: istore #13
    //   454: iload_2
    //   455: istore #7
    //   457: iload_1
    //   458: istore #6
    //   460: iload #13
    //   462: istore #14
    //   464: iload #5
    //   466: istore #4
    //   468: iload #13
    //   470: ifeq -> 588
    //   473: aload_0
    //   474: aload #19
    //   476: aload_0
    //   477: getfield mScrapActionButtonView : Landroid/view/View;
    //   480: aload #17
    //   482: invokevirtual getItemView : (Landroid/support/v7/view/menu/MenuItemImpl;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   485: astore #20
    //   487: aload_0
    //   488: getfield mScrapActionButtonView : Landroid/view/View;
    //   491: ifnonnull -> 500
    //   494: aload_0
    //   495: aload #20
    //   497: putfield mScrapActionButtonView : Landroid/view/View;
    //   500: aload_0
    //   501: getfield mStrictWidthLimit : Z
    //   504: ifeq -> 641
    //   507: aload #20
    //   509: iload #9
    //   511: iload_2
    //   512: iload #11
    //   514: iconst_0
    //   515: invokestatic measureChildForCells : (Landroid/view/View;IIII)I
    //   518: istore #6
    //   520: iload_2
    //   521: iload #6
    //   523: isub
    //   524: istore #4
    //   526: iload #4
    //   528: istore_2
    //   529: iload #6
    //   531: ifne -> 540
    //   534: iconst_0
    //   535: istore #13
    //   537: iload #4
    //   539: istore_2
    //   540: aload #20
    //   542: invokevirtual getMeasuredWidth : ()I
    //   545: istore #7
    //   547: iload #5
    //   549: iload #7
    //   551: isub
    //   552: istore #4
    //   554: iload_1
    //   555: istore #6
    //   557: iload_1
    //   558: ifne -> 565
    //   561: iload #7
    //   563: istore #6
    //   565: aload_0
    //   566: getfield mStrictWidthLimit : Z
    //   569: ifeq -> 658
    //   572: iload #4
    //   574: iflt -> 653
    //   577: iconst_1
    //   578: istore_1
    //   579: iload #13
    //   581: iload_1
    //   582: iand
    //   583: istore #14
    //   585: iload_2
    //   586: istore #7
    //   588: iload #14
    //   590: ifeq -> 685
    //   593: iload #12
    //   595: ifeq -> 685
    //   598: aload #18
    //   600: iload #12
    //   602: iconst_1
    //   603: invokevirtual put : (IZ)V
    //   606: iload_3
    //   607: istore_1
    //   608: iload_1
    //   609: istore_3
    //   610: iload #14
    //   612: ifeq -> 619
    //   615: iload_1
    //   616: iconst_1
    //   617: isub
    //   618: istore_3
    //   619: aload #19
    //   621: iload #14
    //   623: invokevirtual setIsActionButton : (Z)V
    //   626: iload #7
    //   628: istore_2
    //   629: iload #6
    //   631: istore_1
    //   632: goto -> 377
    //   635: iconst_0
    //   636: istore #13
    //   638: goto -> 454
    //   641: aload #20
    //   643: iload #11
    //   645: iload #11
    //   647: invokevirtual measure : (II)V
    //   650: goto -> 540
    //   653: iconst_0
    //   654: istore_1
    //   655: goto -> 579
    //   658: iload #4
    //   660: iload #6
    //   662: iadd
    //   663: ifle -> 680
    //   666: iconst_1
    //   667: istore_1
    //   668: iload #13
    //   670: iload_1
    //   671: iand
    //   672: istore #14
    //   674: iload_2
    //   675: istore #7
    //   677: goto -> 588
    //   680: iconst_0
    //   681: istore_1
    //   682: goto -> 668
    //   685: iload_3
    //   686: istore_1
    //   687: iload #15
    //   689: ifeq -> 608
    //   692: aload #18
    //   694: iload #12
    //   696: iconst_0
    //   697: invokevirtual put : (IZ)V
    //   700: iconst_0
    //   701: istore_2
    //   702: iload_3
    //   703: istore_1
    //   704: iload_2
    //   705: iload #10
    //   707: if_icmpge -> 608
    //   710: aload #16
    //   712: iload_2
    //   713: invokevirtual get : (I)Ljava/lang/Object;
    //   716: checkcast android/support/v7/view/menu/MenuItemImpl
    //   719: astore #20
    //   721: iload_3
    //   722: istore_1
    //   723: aload #20
    //   725: invokevirtual getGroupId : ()I
    //   728: iload #12
    //   730: if_icmpne -> 753
    //   733: iload_3
    //   734: istore_1
    //   735: aload #20
    //   737: invokevirtual isActionButton : ()Z
    //   740: ifeq -> 747
    //   743: iload_3
    //   744: iconst_1
    //   745: iadd
    //   746: istore_1
    //   747: aload #20
    //   749: iconst_0
    //   750: invokevirtual setIsActionButton : (Z)V
    //   753: iload_2
    //   754: iconst_1
    //   755: iadd
    //   756: istore_2
    //   757: iload_1
    //   758: istore_3
    //   759: goto -> 702
    //   762: aload #19
    //   764: iconst_0
    //   765: invokevirtual setIsActionButton : (Z)V
    //   768: iload #5
    //   770: istore #4
    //   772: goto -> 377
    //   775: iconst_1
    //   776: ireturn
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup) {
    boolean bool;
    View view = paramMenuItemImpl.getActionView();
    if (view == null || paramMenuItemImpl.hasCollapsibleActionView())
      view = super.getItemView(paramMenuItemImpl, paramView, paramViewGroup); 
    if (paramMenuItemImpl.isActionViewExpanded()) {
      bool = true;
    } else {
      bool = false;
    } 
    view.setVisibility(bool);
    ActionMenuView actionMenuView = (ActionMenuView)paramViewGroup;
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    if (!actionMenuView.checkLayoutParams(layoutParams))
      view.setLayoutParams((ViewGroup.LayoutParams)actionMenuView.generateLayoutParams(layoutParams)); 
    return view;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup) {
    MenuView menuView2 = this.mMenuView;
    MenuView menuView1 = super.getMenuView(paramViewGroup);
    if (menuView2 != menuView1)
      ((ActionMenuView)menuView1).setPresenter(this); 
    return menuView1;
  }
  
  public Drawable getOverflowIcon() {
    return (this.mOverflowButton != null) ? this.mOverflowButton.getDrawable() : (this.mPendingOverflowIconSet ? this.mPendingOverflowIcon : null);
  }
  
  public boolean hideOverflowMenu() {
    if (this.mPostedOpenRunnable != null && this.mMenuView != null) {
      ((View)this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
      this.mPostedOpenRunnable = null;
      return true;
    } 
    OverflowPopup overflowPopup = this.mOverflowPopup;
    if (overflowPopup != null) {
      overflowPopup.dismiss();
      return true;
    } 
    return false;
  }
  
  public boolean hideSubMenus() {
    if (this.mActionButtonPopup != null) {
      this.mActionButtonPopup.dismiss();
      return true;
    } 
    return false;
  }
  
  public void initForMenu(@NonNull Context paramContext, @Nullable MenuBuilder paramMenuBuilder) {
    super.initForMenu(paramContext, paramMenuBuilder);
    Resources resources = paramContext.getResources();
    ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(paramContext);
    if (!this.mReserveOverflowSet)
      this.mReserveOverflow = actionBarPolicy.showsOverflowMenuButton(); 
    if (!this.mWidthLimitSet)
      this.mWidthLimit = actionBarPolicy.getEmbeddedMenuWidthLimit(); 
    if (!this.mMaxItemsSet)
      this.mMaxItems = actionBarPolicy.getMaxActionButtons(); 
    int i = this.mWidthLimit;
    if (this.mReserveOverflow) {
      if (this.mOverflowButton == null) {
        this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
        if (this.mPendingOverflowIconSet) {
          this.mOverflowButton.setImageDrawable(this.mPendingOverflowIcon);
          this.mPendingOverflowIcon = null;
          this.mPendingOverflowIconSet = false;
        } 
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(j, j);
      } 
      i -= this.mOverflowButton.getMeasuredWidth();
    } else {
      this.mOverflowButton = null;
    } 
    this.mActionItemWidthLimit = i;
    this.mMinCellSize = (int)(56.0F * (resources.getDisplayMetrics()).density);
    this.mScrapActionButtonView = null;
  }
  
  public boolean isOverflowMenuShowPending() {
    return (this.mPostedOpenRunnable != null || isOverflowMenuShowing());
  }
  
  public boolean isOverflowMenuShowing() {
    return (this.mOverflowPopup != null && this.mOverflowPopup.isShowing());
  }
  
  public boolean isOverflowReserved() {
    return this.mReserveOverflow;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    dismissPopupMenus();
    super.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    if (!this.mMaxItemsSet)
      this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons(); 
    if (this.mMenu != null)
      this.mMenu.onItemsChanged(true); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (paramParcelable instanceof SavedState) {
      paramParcelable = paramParcelable;
      if (((SavedState)paramParcelable).openSubMenuId > 0) {
        MenuItem menuItem = this.mMenu.findItem(((SavedState)paramParcelable).openSubMenuId);
        if (menuItem != null) {
          onSubMenuSelected((SubMenuBuilder)menuItem.getSubMenu());
          return;
        } 
      } 
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState();
    savedState.openSubMenuId = this.mOpenSubMenuId;
    return savedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    if (paramSubMenuBuilder.hasVisibleItems()) {
      SubMenuBuilder subMenuBuilder;
      for (subMenuBuilder = paramSubMenuBuilder; subMenuBuilder.getParentMenu() != this.mMenu; subMenuBuilder = (SubMenuBuilder)subMenuBuilder.getParentMenu());
      View view = findViewForItem(subMenuBuilder.getItem());
      if (view != null) {
        this.mOpenSubMenuId = paramSubMenuBuilder.getItem().getItemId();
        boolean bool = false;
        int j = paramSubMenuBuilder.size();
        for (int i = 0;; i++) {
          boolean bool1 = bool;
          if (i < j) {
            MenuItem menuItem = paramSubMenuBuilder.getItem(i);
            if (menuItem.isVisible() && menuItem.getIcon() != null) {
              bool1 = true;
              this.mActionButtonPopup = new ActionButtonSubmenu(this.mContext, paramSubMenuBuilder, view);
              this.mActionButtonPopup.setForceShowIcon(bool1);
              this.mActionButtonPopup.show();
              super.onSubMenuSelected(paramSubMenuBuilder);
              return true;
            } 
          } else {
            this.mActionButtonPopup = new ActionButtonSubmenu(this.mContext, paramSubMenuBuilder, view);
            this.mActionButtonPopup.setForceShowIcon(bool1);
            this.mActionButtonPopup.show();
            super.onSubMenuSelected(paramSubMenuBuilder);
            return true;
          } 
        } 
      } 
    } 
    return false;
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean) {
    if (paramBoolean) {
      super.onSubMenuSelected(null);
      return;
    } 
    if (this.mMenu != null) {
      this.mMenu.close(false);
      return;
    } 
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean) {
    this.mExpandedActionViewsExclusive = paramBoolean;
  }
  
  public void setItemLimit(int paramInt) {
    this.mMaxItems = paramInt;
    this.mMaxItemsSet = true;
  }
  
  public void setMenuView(ActionMenuView paramActionMenuView) {
    this.mMenuView = paramActionMenuView;
    paramActionMenuView.initialize(this.mMenu);
  }
  
  public void setOverflowIcon(Drawable paramDrawable) {
    if (this.mOverflowButton != null) {
      this.mOverflowButton.setImageDrawable(paramDrawable);
      return;
    } 
    this.mPendingOverflowIconSet = true;
    this.mPendingOverflowIcon = paramDrawable;
  }
  
  public void setReserveOverflow(boolean paramBoolean) {
    this.mReserveOverflow = paramBoolean;
    this.mReserveOverflowSet = true;
  }
  
  public void setWidthLimit(int paramInt, boolean paramBoolean) {
    this.mWidthLimit = paramInt;
    this.mStrictWidthLimit = paramBoolean;
    this.mWidthLimitSet = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl) {
    return paramMenuItemImpl.isActionButton();
  }
  
  public boolean showOverflowMenu() {
    if (this.mReserveOverflow && !isOverflowMenuShowing() && this.mMenu != null && this.mMenuView != null && this.mPostedOpenRunnable == null && !this.mMenu.getNonActionItems().isEmpty()) {
      this.mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, (View)this.mOverflowButton, true));
      ((View)this.mMenuView).post(this.mPostedOpenRunnable);
      super.onSubMenuSelected(null);
      return true;
    } 
    return false;
  }
  
  public void updateMenuView(boolean paramBoolean) {
    ViewGroup<MenuItemImpl> viewGroup = (ViewGroup)((View)this.mMenuView).getParent();
    if (viewGroup != null)
      ActionBarTransition.beginDelayedTransition(viewGroup); 
    super.updateMenuView(paramBoolean);
    ((View)this.mMenuView).requestLayout();
    if (this.mMenu != null) {
      ArrayList<MenuItemImpl> arrayList = this.mMenu.getActionItems();
      int k = arrayList.size();
      for (int j = 0; j < k; j++) {
        ActionProvider actionProvider = ((MenuItemImpl)arrayList.get(j)).getSupportActionProvider();
        if (actionProvider != null)
          actionProvider.setSubUiVisibilityListener(this); 
      } 
    } 
    if (this.mMenu != null) {
      ArrayList arrayList = this.mMenu.getNonActionItems();
    } else {
      viewGroup = null;
    } 
    byte b = 0;
    int i = b;
    if (this.mReserveOverflow) {
      i = b;
      if (viewGroup != null) {
        i = viewGroup.size();
        if (i == 1) {
          if (!((MenuItemImpl)viewGroup.get(0)).isActionViewExpanded()) {
            i = 1;
          } else {
            i = 0;
          } 
        } else if (i > 0) {
          i = 1;
        } else {
          i = 0;
        } 
      } 
    } 
    if (i != 0) {
      if (this.mOverflowButton == null)
        this.mOverflowButton = new OverflowMenuButton(this.mSystemContext); 
      viewGroup = (ViewGroup<MenuItemImpl>)this.mOverflowButton.getParent();
      if (viewGroup != this.mMenuView) {
        if (viewGroup != null)
          viewGroup.removeView((View)this.mOverflowButton); 
        viewGroup = (ActionMenuView)this.mMenuView;
        viewGroup.addView((View)this.mOverflowButton, (ViewGroup.LayoutParams)viewGroup.generateOverflowButtonLayoutParams());
      } 
    } else if (this.mOverflowButton != null && this.mOverflowButton.getParent() == this.mMenuView) {
      ((ViewGroup)this.mMenuView).removeView((View)this.mOverflowButton);
    } 
    ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
  }
  
  private class ActionButtonSubmenu extends MenuPopupHelper {
    public ActionButtonSubmenu(Context param1Context, SubMenuBuilder param1SubMenuBuilder, View param1View) {
      super(param1Context, (MenuBuilder)param1SubMenuBuilder, param1View, false, R.attr.actionOverflowMenuStyle);
      if (!((MenuItemImpl)param1SubMenuBuilder.getItem()).isActionButton()) {
        ActionMenuPresenter.OverflowMenuButton overflowMenuButton;
        if (ActionMenuPresenter.this.mOverflowButton == null) {
          View view = (View)ActionMenuPresenter.this.mMenuView;
        } else {
          overflowMenuButton = ActionMenuPresenter.this.mOverflowButton;
        } 
        setAnchorView((View)overflowMenuButton);
      } 
      setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
    }
    
    protected void onDismiss() {
      ActionMenuPresenter.this.mActionButtonPopup = null;
      ActionMenuPresenter.this.mOpenSubMenuId = 0;
      super.onDismiss();
    }
  }
  
  private class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
    public ShowableListMenu getPopup() {
      return (ShowableListMenu)((ActionMenuPresenter.this.mActionButtonPopup != null) ? ActionMenuPresenter.this.mActionButtonPopup.getPopup() : null);
    }
  }
  
  private class OpenOverflowRunnable implements Runnable {
    private ActionMenuPresenter.OverflowPopup mPopup;
    
    public OpenOverflowRunnable(ActionMenuPresenter.OverflowPopup param1OverflowPopup) {
      this.mPopup = param1OverflowPopup;
    }
    
    public void run() {
      if (ActionMenuPresenter.this.mMenu != null)
        ActionMenuPresenter.this.mMenu.changeMenuMode(); 
      View view = (View)ActionMenuPresenter.this.mMenuView;
      if (view != null && view.getWindowToken() != null && this.mPopup.tryShow())
        ActionMenuPresenter.this.mOverflowPopup = this.mPopup; 
      ActionMenuPresenter.this.mPostedOpenRunnable = null;
    }
  }
  
  private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
    private final float[] mTempPts = new float[2];
    
    public OverflowMenuButton(Context param1Context) {
      super(param1Context, (AttributeSet)null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      setOnTouchListener(new ForwardingListener((View)this) {
            public ShowableListMenu getPopup() {
              return (ShowableListMenu)((ActionMenuPresenter.this.mOverflowPopup == null) ? null : ActionMenuPresenter.this.mOverflowPopup.getPopup());
            }
            
            public boolean onForwardingStarted() {
              ActionMenuPresenter.this.showOverflowMenu();
              return true;
            }
            
            public boolean onForwardingStopped() {
              if (ActionMenuPresenter.this.mPostedOpenRunnable != null)
                return false; 
              ActionMenuPresenter.this.hideOverflowMenu();
              return true;
            }
          });
    }
    
    public boolean needsDividerAfter() {
      return false;
    }
    
    public boolean needsDividerBefore() {
      return false;
    }
    
    public boolean performClick() {
      if (super.performClick())
        return true; 
      playSoundEffect(0);
      ActionMenuPresenter.this.showOverflowMenu();
      return true;
    }
    
    protected boolean setFrame(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      boolean bool = super.setFrame(param1Int1, param1Int2, param1Int3, param1Int4);
      Drawable drawable1 = getDrawable();
      Drawable drawable2 = getBackground();
      if (drawable1 != null && drawable2 != null) {
        int i = getWidth();
        param1Int2 = getHeight();
        param1Int1 = Math.max(i, param1Int2) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        param1Int3 = getPaddingTop();
        param1Int4 = getPaddingBottom();
        i = (i + j - k) / 2;
        param1Int2 = (param1Int2 + param1Int3 - param1Int4) / 2;
        DrawableCompat.setHotspotBounds(drawable2, i - param1Int1, param1Int2 - param1Int1, i + param1Int1, param1Int2 + param1Int1);
      } 
      return bool;
    }
  }
  
  class null extends ForwardingListener {
    null(View param1View) {
      super(param1View);
    }
    
    public ShowableListMenu getPopup() {
      return (ShowableListMenu)((ActionMenuPresenter.this.mOverflowPopup == null) ? null : ActionMenuPresenter.this.mOverflowPopup.getPopup());
    }
    
    public boolean onForwardingStarted() {
      ActionMenuPresenter.this.showOverflowMenu();
      return true;
    }
    
    public boolean onForwardingStopped() {
      if (ActionMenuPresenter.this.mPostedOpenRunnable != null)
        return false; 
      ActionMenuPresenter.this.hideOverflowMenu();
      return true;
    }
  }
  
  private class OverflowPopup extends MenuPopupHelper {
    public OverflowPopup(Context param1Context, MenuBuilder param1MenuBuilder, View param1View, boolean param1Boolean) {
      super(param1Context, param1MenuBuilder, param1View, param1Boolean, R.attr.actionOverflowMenuStyle);
      setGravity(8388613);
      setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
    }
    
    protected void onDismiss() {
      if (ActionMenuPresenter.this.mMenu != null)
        ActionMenuPresenter.this.mMenu.close(); 
      ActionMenuPresenter.this.mOverflowPopup = null;
      super.onDismiss();
    }
  }
  
  private class PopupPresenterCallback implements MenuPresenter.Callback {
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {
      if (param1MenuBuilder instanceof SubMenuBuilder)
        param1MenuBuilder.getRootMenu().close(false); 
      MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
      if (callback != null)
        callback.onCloseMenu(param1MenuBuilder, param1Boolean); 
    }
    
    public boolean onOpenSubMenu(MenuBuilder param1MenuBuilder) {
      if (param1MenuBuilder == null)
        return false; 
      ActionMenuPresenter.this.mOpenSubMenuId = ((SubMenuBuilder)param1MenuBuilder).getItem().getItemId();
      MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
      return (callback != null) ? callback.onOpenSubMenu(param1MenuBuilder) : false;
    }
  }
  
  private static class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public ActionMenuPresenter.SavedState createFromParcel(Parcel param2Parcel) {
          return new ActionMenuPresenter.SavedState(param2Parcel);
        }
        
        public ActionMenuPresenter.SavedState[] newArray(int param2Int) {
          return new ActionMenuPresenter.SavedState[param2Int];
        }
      };
    
    public int openSubMenuId;
    
    SavedState() {}
    
    SavedState(Parcel param1Parcel) {
      this.openSubMenuId = param1Parcel.readInt();
    }
    
    public int describeContents() {
      return 0;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.openSubMenuId);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public ActionMenuPresenter.SavedState createFromParcel(Parcel param1Parcel) {
      return new ActionMenuPresenter.SavedState(param1Parcel);
    }
    
    public ActionMenuPresenter.SavedState[] newArray(int param1Int) {
      return new ActionMenuPresenter.SavedState[param1Int];
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\ActionMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */