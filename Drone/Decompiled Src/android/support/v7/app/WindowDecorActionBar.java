package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
  private static final boolean ALLOW_SHOW_HIDE_ANIMATIONS;
  
  private static final long FADE_IN_DURATION_MS = 200L;
  
  private static final long FADE_OUT_DURATION_MS = 100L;
  
  private static final int INVALID_POSITION = -1;
  
  private static final String TAG = "WindowDecorActionBar";
  
  private static final Interpolator sHideInterpolator = (Interpolator)new AccelerateInterpolator();
  
  private static final Interpolator sShowInterpolator = (Interpolator)new DecelerateInterpolator();
  
  ActionModeImpl mActionMode;
  
  private Activity mActivity;
  
  ActionBarContainer mContainerView;
  
  boolean mContentAnimations = true;
  
  View mContentView;
  
  Context mContext;
  
  ActionBarContextView mContextView;
  
  private int mCurWindowVisibility = 0;
  
  ViewPropertyAnimatorCompatSet mCurrentShowAnim;
  
  DecorToolbar mDecorToolbar;
  
  ActionMode mDeferredDestroyActionMode;
  
  ActionMode.Callback mDeferredModeDestroyCallback;
  
  private Dialog mDialog;
  
  private boolean mDisplayHomeAsUpSet;
  
  private boolean mHasEmbeddedTabs;
  
  boolean mHiddenByApp;
  
  boolean mHiddenBySystem;
  
  final ViewPropertyAnimatorListener mHideListener = (ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerAdapter() {
      public void onAnimationEnd(View param1View) {
        if (WindowDecorActionBar.this.mContentAnimations && WindowDecorActionBar.this.mContentView != null) {
          ViewCompat.setTranslationY(WindowDecorActionBar.this.mContentView, 0.0F);
          ViewCompat.setTranslationY((View)WindowDecorActionBar.this.mContainerView, 0.0F);
        } 
        WindowDecorActionBar.this.mContainerView.setVisibility(8);
        WindowDecorActionBar.this.mContainerView.setTransitioning(false);
        WindowDecorActionBar.this.mCurrentShowAnim = null;
        WindowDecorActionBar.this.completeDeferredDestroyActionMode();
        if (WindowDecorActionBar.this.mOverlayLayout != null)
          ViewCompat.requestApplyInsets((View)WindowDecorActionBar.this.mOverlayLayout); 
      }
    };
  
  boolean mHideOnContentScroll;
  
  private boolean mLastMenuVisibility;
  
  private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<ActionBar.OnMenuVisibilityListener>();
  
  private boolean mNowShowing = true;
  
  ActionBarOverlayLayout mOverlayLayout;
  
  private int mSavedTabPosition = -1;
  
  private TabImpl mSelectedTab;
  
  private boolean mShowHideAnimationEnabled;
  
  final ViewPropertyAnimatorListener mShowListener = (ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerAdapter() {
      public void onAnimationEnd(View param1View) {
        WindowDecorActionBar.this.mCurrentShowAnim = null;
        WindowDecorActionBar.this.mContainerView.requestLayout();
      }
    };
  
  private boolean mShowingForMode;
  
  ScrollingTabContainerView mTabScrollView;
  
  private ArrayList<TabImpl> mTabs = new ArrayList<TabImpl>();
  
  private Context mThemedContext;
  
  final ViewPropertyAnimatorUpdateListener mUpdateListener = new ViewPropertyAnimatorUpdateListener() {
      public void onAnimationUpdate(View param1View) {
        ((View)WindowDecorActionBar.this.mContainerView.getParent()).invalidate();
      }
    };
  
  static {
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    ALLOW_SHOW_HIDE_ANIMATIONS = bool1;
  }
  
  public WindowDecorActionBar(Activity paramActivity, boolean paramBoolean) {
    this.mActivity = paramActivity;
    View view = paramActivity.getWindow().getDecorView();
    init(view);
    if (!paramBoolean)
      this.mContentView = view.findViewById(16908290); 
  }
  
  public WindowDecorActionBar(Dialog paramDialog) {
    this.mDialog = paramDialog;
    init(paramDialog.getWindow().getDecorView());
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public WindowDecorActionBar(View paramView) {
    assert paramView.isInEditMode();
    init(paramView);
  }
  
  static boolean checkShowingFlags(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    return !(!paramBoolean3 && (paramBoolean1 || paramBoolean2));
  }
  
  private void cleanupTabs() {
    if (this.mSelectedTab != null)
      selectTab(null); 
    this.mTabs.clear();
    if (this.mTabScrollView != null)
      this.mTabScrollView.removeAllTabs(); 
    this.mSavedTabPosition = -1;
  }
  
  private void configureTab(ActionBar.Tab paramTab, int paramInt) {
    paramTab = paramTab;
    if (paramTab.getCallback() == null)
      throw new IllegalStateException("Action Bar Tab must have a Callback"); 
    paramTab.setPosition(paramInt);
    this.mTabs.add(paramInt, paramTab);
    int i = this.mTabs.size();
    while (++paramInt < i) {
      ((TabImpl)this.mTabs.get(paramInt)).setPosition(paramInt);
      paramInt++;
    } 
  }
  
  private void ensureTabsExist() {
    if (this.mTabScrollView != null)
      return; 
    ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
    if (this.mHasEmbeddedTabs) {
      scrollingTabContainerView.setVisibility(0);
      this.mDecorToolbar.setEmbeddedTabView(scrollingTabContainerView);
    } else {
      if (getNavigationMode() == 2) {
        scrollingTabContainerView.setVisibility(0);
        if (this.mOverlayLayout != null)
          ViewCompat.requestApplyInsets((View)this.mOverlayLayout); 
      } else {
        scrollingTabContainerView.setVisibility(8);
      } 
      this.mContainerView.setTabContainer(scrollingTabContainerView);
    } 
    this.mTabScrollView = scrollingTabContainerView;
  }
  
  private DecorToolbar getDecorToolbar(View paramView) {
    if (paramView instanceof DecorToolbar)
      return (DecorToolbar)paramView; 
    if (paramView instanceof Toolbar)
      return ((Toolbar)paramView).getWrapper(); 
    if ("Can't make a decor toolbar out of " + paramView != null) {
      String str1 = paramView.getClass().getSimpleName();
      throw new IllegalStateException(str1);
    } 
    String str = "null";
    throw new IllegalStateException(str);
  }
  
  private void hideForActionMode() {
    if (this.mShowingForMode) {
      this.mShowingForMode = false;
      if (this.mOverlayLayout != null)
        this.mOverlayLayout.setShowingForActionMode(false); 
      updateVisibility(false);
    } 
  }
  
  private void init(View paramView) {
    boolean bool;
    this.mOverlayLayout = (ActionBarOverlayLayout)paramView.findViewById(R.id.decor_content_parent);
    if (this.mOverlayLayout != null)
      this.mOverlayLayout.setActionBarVisibilityCallback(this); 
    this.mDecorToolbar = getDecorToolbar(paramView.findViewById(R.id.action_bar));
    this.mContextView = (ActionBarContextView)paramView.findViewById(R.id.action_context_bar);
    this.mContainerView = (ActionBarContainer)paramView.findViewById(R.id.action_bar_container);
    if (this.mDecorToolbar == null || this.mContextView == null || this.mContainerView == null)
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout"); 
    this.mContext = this.mDecorToolbar.getContext();
    if ((this.mDecorToolbar.getDisplayOptions() & 0x4) != 0) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i)
      this.mDisplayHomeAsUpSet = true; 
    ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.mContext);
    if (actionBarPolicy.enableHomeButtonByDefault() || i) {
      bool = true;
    } else {
      bool = false;
    } 
    setHomeButtonEnabled(bool);
    setHasEmbeddedTabs(actionBarPolicy.hasEmbeddedTabs());
    TypedArray typedArray = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    if (typedArray.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false))
      setHideOnContentScrollEnabled(true); 
    int i = typedArray.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
    if (i != 0)
      setElevation(i); 
    typedArray.recycle();
  }
  
  private void setHasEmbeddedTabs(boolean paramBoolean) {
    boolean bool1;
    boolean bool2 = true;
    this.mHasEmbeddedTabs = paramBoolean;
    if (!this.mHasEmbeddedTabs) {
      this.mDecorToolbar.setEmbeddedTabView(null);
      this.mContainerView.setTabContainer(this.mTabScrollView);
    } else {
      this.mContainerView.setTabContainer(null);
      this.mDecorToolbar.setEmbeddedTabView(this.mTabScrollView);
    } 
    if (getNavigationMode() == 2) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.mTabScrollView != null)
      if (bool1) {
        this.mTabScrollView.setVisibility(0);
        if (this.mOverlayLayout != null)
          ViewCompat.requestApplyInsets((View)this.mOverlayLayout); 
      } else {
        this.mTabScrollView.setVisibility(8);
      }  
    DecorToolbar decorToolbar = this.mDecorToolbar;
    if (!this.mHasEmbeddedTabs && bool1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    decorToolbar.setCollapsible(paramBoolean);
    ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
    if (!this.mHasEmbeddedTabs && bool1) {
      paramBoolean = bool2;
    } else {
      paramBoolean = false;
    } 
    actionBarOverlayLayout.setHasNonEmbeddedTabs(paramBoolean);
  }
  
  private boolean shouldAnimateContextView() {
    return ViewCompat.isLaidOut((View)this.mContainerView);
  }
  
  private void showForActionMode() {
    if (!this.mShowingForMode) {
      this.mShowingForMode = true;
      if (this.mOverlayLayout != null)
        this.mOverlayLayout.setShowingForActionMode(true); 
      updateVisibility(false);
    } 
  }
  
  private void updateVisibility(boolean paramBoolean) {
    if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
      if (!this.mNowShowing) {
        this.mNowShowing = true;
        doShow(paramBoolean);
      } 
      return;
    } 
    if (this.mNowShowing) {
      this.mNowShowing = false;
      doHide(paramBoolean);
      return;
    } 
  }
  
  public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener) {
    this.mMenuVisibilityListeners.add(paramOnMenuVisibilityListener);
  }
  
  public void addTab(ActionBar.Tab paramTab) {
    addTab(paramTab, this.mTabs.isEmpty());
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt) {
    addTab(paramTab, paramInt, this.mTabs.isEmpty());
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean) {
    ensureTabsExist();
    this.mTabScrollView.addTab(paramTab, paramInt, paramBoolean);
    configureTab(paramTab, paramInt);
    if (paramBoolean)
      selectTab(paramTab); 
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean) {
    ensureTabsExist();
    this.mTabScrollView.addTab(paramTab, paramBoolean);
    configureTab(paramTab, this.mTabs.size());
    if (paramBoolean)
      selectTab(paramTab); 
  }
  
  public void animateToMode(boolean paramBoolean) {
    if (paramBoolean) {
      showForActionMode();
    } else {
      hideForActionMode();
    } 
    if (shouldAnimateContextView()) {
      ViewPropertyAnimatorCompat viewPropertyAnimatorCompat1;
      ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
      if (paramBoolean) {
        viewPropertyAnimatorCompat2 = this.mDecorToolbar.setupAnimatorToVisibility(4, 100L);
        viewPropertyAnimatorCompat1 = this.mContextView.setupAnimatorToVisibility(0, 200L);
      } else {
        viewPropertyAnimatorCompat1 = this.mDecorToolbar.setupAnimatorToVisibility(0, 200L);
        viewPropertyAnimatorCompat2 = this.mContextView.setupAnimatorToVisibility(8, 100L);
      } 
      ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat1);
      viewPropertyAnimatorCompatSet.start();
      return;
    } 
    if (paramBoolean) {
      this.mDecorToolbar.setVisibility(4);
      this.mContextView.setVisibility(0);
      return;
    } 
    this.mDecorToolbar.setVisibility(0);
    this.mContextView.setVisibility(8);
  }
  
  public boolean collapseActionView() {
    if (this.mDecorToolbar != null && this.mDecorToolbar.hasExpandedActionView()) {
      this.mDecorToolbar.collapseActionView();
      return true;
    } 
    return false;
  }
  
  void completeDeferredDestroyActionMode() {
    if (this.mDeferredModeDestroyCallback != null) {
      this.mDeferredModeDestroyCallback.onDestroyActionMode(this.mDeferredDestroyActionMode);
      this.mDeferredDestroyActionMode = null;
      this.mDeferredModeDestroyCallback = null;
    } 
  }
  
  public void dispatchMenuVisibilityChanged(boolean paramBoolean) {
    if (paramBoolean != this.mLastMenuVisibility) {
      this.mLastMenuVisibility = paramBoolean;
      int j = this.mMenuVisibilityListeners.size();
      int i = 0;
      while (true) {
        if (i < j) {
          ((ActionBar.OnMenuVisibilityListener)this.mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(paramBoolean);
          i++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public void doHide(boolean paramBoolean) {
    if (this.mCurrentShowAnim != null)
      this.mCurrentShowAnim.cancel(); 
    if (this.mCurWindowVisibility == 0 && ALLOW_SHOW_HIDE_ANIMATIONS && (this.mShowHideAnimationEnabled || paramBoolean)) {
      ViewCompat.setAlpha((View)this.mContainerView, 1.0F);
      this.mContainerView.setTransitioning(true);
      ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      float f2 = -this.mContainerView.getHeight();
      float f1 = f2;
      if (paramBoolean) {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        this.mContainerView.getLocationInWindow(arrayOfInt);
        f1 = f2 - arrayOfInt[1];
      } 
      ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)this.mContainerView).translationY(f1);
      viewPropertyAnimatorCompat.setUpdateListener(this.mUpdateListener);
      viewPropertyAnimatorCompatSet.play(viewPropertyAnimatorCompat);
      if (this.mContentAnimations && this.mContentView != null)
        viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mContentView).translationY(f1)); 
      viewPropertyAnimatorCompatSet.setInterpolator(sHideInterpolator);
      viewPropertyAnimatorCompatSet.setDuration(250L);
      viewPropertyAnimatorCompatSet.setListener(this.mHideListener);
      this.mCurrentShowAnim = viewPropertyAnimatorCompatSet;
      viewPropertyAnimatorCompatSet.start();
      return;
    } 
    this.mHideListener.onAnimationEnd(null);
  }
  
  public void doShow(boolean paramBoolean) {
    if (this.mCurrentShowAnim != null)
      this.mCurrentShowAnim.cancel(); 
    this.mContainerView.setVisibility(0);
    if (this.mCurWindowVisibility == 0 && ALLOW_SHOW_HIDE_ANIMATIONS && (this.mShowHideAnimationEnabled || paramBoolean)) {
      ViewCompat.setTranslationY((View)this.mContainerView, 0.0F);
      float f2 = -this.mContainerView.getHeight();
      float f1 = f2;
      if (paramBoolean) {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        this.mContainerView.getLocationInWindow(arrayOfInt);
        f1 = f2 - arrayOfInt[1];
      } 
      ViewCompat.setTranslationY((View)this.mContainerView, f1);
      ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)this.mContainerView).translationY(0.0F);
      viewPropertyAnimatorCompat.setUpdateListener(this.mUpdateListener);
      viewPropertyAnimatorCompatSet.play(viewPropertyAnimatorCompat);
      if (this.mContentAnimations && this.mContentView != null) {
        ViewCompat.setTranslationY(this.mContentView, f1);
        viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mContentView).translationY(0.0F));
      } 
      viewPropertyAnimatorCompatSet.setInterpolator(sShowInterpolator);
      viewPropertyAnimatorCompatSet.setDuration(250L);
      viewPropertyAnimatorCompatSet.setListener(this.mShowListener);
      this.mCurrentShowAnim = viewPropertyAnimatorCompatSet;
      viewPropertyAnimatorCompatSet.start();
    } else {
      ViewCompat.setAlpha((View)this.mContainerView, 1.0F);
      ViewCompat.setTranslationY((View)this.mContainerView, 0.0F);
      if (this.mContentAnimations && this.mContentView != null)
        ViewCompat.setTranslationY(this.mContentView, 0.0F); 
      this.mShowListener.onAnimationEnd(null);
    } 
    if (this.mOverlayLayout != null)
      ViewCompat.requestApplyInsets((View)this.mOverlayLayout); 
  }
  
  public void enableContentAnimations(boolean paramBoolean) {
    this.mContentAnimations = paramBoolean;
  }
  
  public View getCustomView() {
    return this.mDecorToolbar.getCustomView();
  }
  
  public int getDisplayOptions() {
    return this.mDecorToolbar.getDisplayOptions();
  }
  
  public float getElevation() {
    return ViewCompat.getElevation((View)this.mContainerView);
  }
  
  public int getHeight() {
    return this.mContainerView.getHeight();
  }
  
  public int getHideOffset() {
    return this.mOverlayLayout.getActionBarHideOffset();
  }
  
  public int getNavigationItemCount() {
    switch (this.mDecorToolbar.getNavigationMode()) {
      default:
        return 0;
      case 2:
        return this.mTabs.size();
      case 1:
        break;
    } 
    return this.mDecorToolbar.getDropdownItemCount();
  }
  
  public int getNavigationMode() {
    return this.mDecorToolbar.getNavigationMode();
  }
  
  public int getSelectedNavigationIndex() {
    switch (this.mDecorToolbar.getNavigationMode()) {
      default:
        return -1;
      case 2:
        if (this.mSelectedTab != null)
          return this.mSelectedTab.getPosition(); 
      case 1:
        break;
    } 
    return this.mDecorToolbar.getDropdownSelectedPosition();
  }
  
  public ActionBar.Tab getSelectedTab() {
    return this.mSelectedTab;
  }
  
  public CharSequence getSubtitle() {
    return this.mDecorToolbar.getSubtitle();
  }
  
  public ActionBar.Tab getTabAt(int paramInt) {
    return this.mTabs.get(paramInt);
  }
  
  public int getTabCount() {
    return this.mTabs.size();
  }
  
  public Context getThemedContext() {
    if (this.mThemedContext == null) {
      TypedValue typedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
      int i = typedValue.resourceId;
      if (i != 0) {
        this.mThemedContext = (Context)new ContextThemeWrapper(this.mContext, i);
        return this.mThemedContext;
      } 
    } else {
      return this.mThemedContext;
    } 
    this.mThemedContext = this.mContext;
    return this.mThemedContext;
  }
  
  public CharSequence getTitle() {
    return this.mDecorToolbar.getTitle();
  }
  
  public boolean hasIcon() {
    return this.mDecorToolbar.hasIcon();
  }
  
  public boolean hasLogo() {
    return this.mDecorToolbar.hasLogo();
  }
  
  public void hide() {
    if (!this.mHiddenByApp) {
      this.mHiddenByApp = true;
      updateVisibility(false);
    } 
  }
  
  public void hideForSystem() {
    if (!this.mHiddenBySystem) {
      this.mHiddenBySystem = true;
      updateVisibility(true);
    } 
  }
  
  public boolean isHideOnContentScrollEnabled() {
    return this.mOverlayLayout.isHideOnContentScrollEnabled();
  }
  
  public boolean isShowing() {
    int i = getHeight();
    return (this.mNowShowing && (i == 0 || getHideOffset() < i));
  }
  
  public boolean isTitleTruncated() {
    return (this.mDecorToolbar != null && this.mDecorToolbar.isTitleTruncated());
  }
  
  public ActionBar.Tab newTab() {
    return new TabImpl();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
  }
  
  public void onContentScrollStarted() {
    if (this.mCurrentShowAnim != null) {
      this.mCurrentShowAnim.cancel();
      this.mCurrentShowAnim = null;
    } 
  }
  
  public void onContentScrollStopped() {}
  
  public void onWindowVisibilityChanged(int paramInt) {
    this.mCurWindowVisibility = paramInt;
  }
  
  public void removeAllTabs() {
    cleanupTabs();
  }
  
  public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener) {
    this.mMenuVisibilityListeners.remove(paramOnMenuVisibilityListener);
  }
  
  public void removeTab(ActionBar.Tab paramTab) {
    removeTabAt(paramTab.getPosition());
  }
  
  public void removeTabAt(int paramInt) {
    if (this.mTabScrollView != null) {
      int i;
      if (this.mSelectedTab != null) {
        i = this.mSelectedTab.getPosition();
      } else {
        i = this.mSavedTabPosition;
      } 
      this.mTabScrollView.removeTabAt(paramInt);
      TabImpl tabImpl = this.mTabs.remove(paramInt);
      if (tabImpl != null)
        tabImpl.setPosition(-1); 
      int k = this.mTabs.size();
      for (int j = paramInt; j < k; j++)
        ((TabImpl)this.mTabs.get(j)).setPosition(j); 
      if (i == paramInt) {
        if (this.mTabs.isEmpty()) {
          tabImpl = null;
        } else {
          tabImpl = this.mTabs.get(Math.max(0, paramInt - 1));
        } 
        selectTab(tabImpl);
        return;
      } 
    } 
  }
  
  public boolean requestFocus() {
    ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
    if (viewGroup != null && !viewGroup.hasFocus()) {
      viewGroup.requestFocus();
      return true;
    } 
    return false;
  }
  
  public void selectTab(ActionBar.Tab paramTab) {
    FragmentTransaction fragmentTransaction;
    int i = -1;
    if (getNavigationMode() != 2) {
      if (paramTab != null) {
        i = paramTab.getPosition();
      } else {
        i = -1;
      } 
      this.mSavedTabPosition = i;
      return;
    } 
    if (this.mActivity instanceof FragmentActivity && !this.mDecorToolbar.getViewGroup().isInEditMode()) {
      fragmentTransaction = ((FragmentActivity)this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
    } else {
      fragmentTransaction = null;
    } 
    if (this.mSelectedTab == paramTab) {
      if (this.mSelectedTab != null) {
        this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, fragmentTransaction);
        this.mTabScrollView.animateToTab(paramTab.getPosition());
      } 
    } else {
      ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
      if (paramTab != null)
        i = paramTab.getPosition(); 
      scrollingTabContainerView.setTabSelected(i);
      if (this.mSelectedTab != null)
        this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, fragmentTransaction); 
      this.mSelectedTab = (TabImpl)paramTab;
      if (this.mSelectedTab != null)
        this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, fragmentTransaction); 
    } 
    if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
      fragmentTransaction.commit();
      return;
    } 
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    this.mContainerView.setPrimaryBackground(paramDrawable);
  }
  
  public void setCustomView(int paramInt) {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.mDecorToolbar.getViewGroup(), false));
  }
  
  public void setCustomView(View paramView) {
    this.mDecorToolbar.setCustomView(paramView);
  }
  
  public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams) {
    paramView.setLayoutParams((ViewGroup.LayoutParams)paramLayoutParams);
    this.mDecorToolbar.setCustomView(paramView);
  }
  
  public void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean) {
    if (!this.mDisplayHomeAsUpSet)
      setDisplayHomeAsUpEnabled(paramBoolean); 
  }
  
  public void setDisplayHomeAsUpEnabled(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    setDisplayOptions(bool, 4);
  }
  
  public void setDisplayOptions(int paramInt) {
    if ((paramInt & 0x4) != 0)
      this.mDisplayHomeAsUpSet = true; 
    this.mDecorToolbar.setDisplayOptions(paramInt);
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2) {
    int i = this.mDecorToolbar.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0)
      this.mDisplayHomeAsUpSet = true; 
    this.mDecorToolbar.setDisplayOptions(paramInt1 & paramInt2 | (paramInt2 ^ 0xFFFFFFFF) & i);
  }
  
  public void setDisplayShowCustomEnabled(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    setDisplayOptions(bool, 16);
  }
  
  public void setDisplayShowHomeEnabled(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    setDisplayOptions(bool, 2);
  }
  
  public void setDisplayShowTitleEnabled(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    setDisplayOptions(bool, 8);
  }
  
  public void setDisplayUseLogoEnabled(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    setDisplayOptions(bool, 1);
  }
  
  public void setElevation(float paramFloat) {
    ViewCompat.setElevation((View)this.mContainerView, paramFloat);
  }
  
  public void setHideOffset(int paramInt) {
    if (paramInt != 0 && !this.mOverlayLayout.isInOverlayMode())
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset"); 
    this.mOverlayLayout.setActionBarHideOffset(paramInt);
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean) {
    if (paramBoolean && !this.mOverlayLayout.isInOverlayMode())
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll"); 
    this.mHideOnContentScroll = paramBoolean;
    this.mOverlayLayout.setHideOnContentScrollEnabled(paramBoolean);
  }
  
  public void setHomeActionContentDescription(int paramInt) {
    this.mDecorToolbar.setNavigationContentDescription(paramInt);
  }
  
  public void setHomeActionContentDescription(CharSequence paramCharSequence) {
    this.mDecorToolbar.setNavigationContentDescription(paramCharSequence);
  }
  
  public void setHomeAsUpIndicator(int paramInt) {
    this.mDecorToolbar.setNavigationIcon(paramInt);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable) {
    this.mDecorToolbar.setNavigationIcon(paramDrawable);
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean) {
    this.mDecorToolbar.setHomeButtonEnabled(paramBoolean);
  }
  
  public void setIcon(int paramInt) {
    this.mDecorToolbar.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.mDecorToolbar.setIcon(paramDrawable);
  }
  
  public void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.OnNavigationListener paramOnNavigationListener) {
    this.mDecorToolbar.setDropdownParams(paramSpinnerAdapter, new NavItemSelectedListener(paramOnNavigationListener));
  }
  
  public void setLogo(int paramInt) {
    this.mDecorToolbar.setLogo(paramInt);
  }
  
  public void setLogo(Drawable paramDrawable) {
    this.mDecorToolbar.setLogo(paramDrawable);
  }
  
  public void setNavigationMode(int paramInt) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #4
    //   3: aload_0
    //   4: getfield mDecorToolbar : Landroid/support/v7/widget/DecorToolbar;
    //   7: invokeinterface getNavigationMode : ()I
    //   12: istore_2
    //   13: iload_2
    //   14: tableswitch default -> 32, 2 -> 144
    //   32: iload_2
    //   33: iload_1
    //   34: if_icmpeq -> 58
    //   37: aload_0
    //   38: getfield mHasEmbeddedTabs : Z
    //   41: ifne -> 58
    //   44: aload_0
    //   45: getfield mOverlayLayout : Landroid/support/v7/widget/ActionBarOverlayLayout;
    //   48: ifnull -> 58
    //   51: aload_0
    //   52: getfield mOverlayLayout : Landroid/support/v7/widget/ActionBarOverlayLayout;
    //   55: invokestatic requestApplyInsets : (Landroid/view/View;)V
    //   58: aload_0
    //   59: getfield mDecorToolbar : Landroid/support/v7/widget/DecorToolbar;
    //   62: iload_1
    //   63: invokeinterface setNavigationMode : (I)V
    //   68: iload_1
    //   69: tableswitch default -> 88, 2 -> 169
    //   88: aload_0
    //   89: getfield mDecorToolbar : Landroid/support/v7/widget/DecorToolbar;
    //   92: astore #5
    //   94: iload_1
    //   95: iconst_2
    //   96: if_icmpne -> 205
    //   99: aload_0
    //   100: getfield mHasEmbeddedTabs : Z
    //   103: ifne -> 205
    //   106: iconst_1
    //   107: istore_3
    //   108: aload #5
    //   110: iload_3
    //   111: invokeinterface setCollapsible : (Z)V
    //   116: aload_0
    //   117: getfield mOverlayLayout : Landroid/support/v7/widget/ActionBarOverlayLayout;
    //   120: astore #5
    //   122: iload_1
    //   123: iconst_2
    //   124: if_icmpne -> 210
    //   127: aload_0
    //   128: getfield mHasEmbeddedTabs : Z
    //   131: ifne -> 210
    //   134: iload #4
    //   136: istore_3
    //   137: aload #5
    //   139: iload_3
    //   140: invokevirtual setHasNonEmbeddedTabs : (Z)V
    //   143: return
    //   144: aload_0
    //   145: aload_0
    //   146: invokevirtual getSelectedNavigationIndex : ()I
    //   149: putfield mSavedTabPosition : I
    //   152: aload_0
    //   153: aconst_null
    //   154: invokevirtual selectTab : (Landroid/support/v7/app/ActionBar$Tab;)V
    //   157: aload_0
    //   158: getfield mTabScrollView : Landroid/support/v7/widget/ScrollingTabContainerView;
    //   161: bipush #8
    //   163: invokevirtual setVisibility : (I)V
    //   166: goto -> 32
    //   169: aload_0
    //   170: invokespecial ensureTabsExist : ()V
    //   173: aload_0
    //   174: getfield mTabScrollView : Landroid/support/v7/widget/ScrollingTabContainerView;
    //   177: iconst_0
    //   178: invokevirtual setVisibility : (I)V
    //   181: aload_0
    //   182: getfield mSavedTabPosition : I
    //   185: iconst_m1
    //   186: if_icmpeq -> 88
    //   189: aload_0
    //   190: aload_0
    //   191: getfield mSavedTabPosition : I
    //   194: invokevirtual setSelectedNavigationItem : (I)V
    //   197: aload_0
    //   198: iconst_m1
    //   199: putfield mSavedTabPosition : I
    //   202: goto -> 88
    //   205: iconst_0
    //   206: istore_3
    //   207: goto -> 108
    //   210: iconst_0
    //   211: istore_3
    //   212: goto -> 137
  }
  
  public void setSelectedNavigationItem(int paramInt) {
    switch (this.mDecorToolbar.getNavigationMode()) {
      default:
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
      case 2:
        selectTab(this.mTabs.get(paramInt));
        return;
      case 1:
        break;
    } 
    this.mDecorToolbar.setDropdownSelectedPosition(paramInt);
  }
  
  public void setShowHideAnimationEnabled(boolean paramBoolean) {
    this.mShowHideAnimationEnabled = paramBoolean;
    if (!paramBoolean && this.mCurrentShowAnim != null)
      this.mCurrentShowAnim.cancel(); 
  }
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setStackedBackgroundDrawable(Drawable paramDrawable) {
    this.mContainerView.setStackedBackground(paramDrawable);
  }
  
  public void setSubtitle(int paramInt) {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {
    this.mDecorToolbar.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt) {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.mDecorToolbar.setTitle(paramCharSequence);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence) {
    this.mDecorToolbar.setWindowTitle(paramCharSequence);
  }
  
  public void show() {
    if (this.mHiddenByApp) {
      this.mHiddenByApp = false;
      updateVisibility(false);
    } 
  }
  
  public void showForSystem() {
    if (this.mHiddenBySystem) {
      this.mHiddenBySystem = false;
      updateVisibility(true);
    } 
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback) {
    if (this.mActionMode != null)
      this.mActionMode.finish(); 
    this.mOverlayLayout.setHideOnContentScrollEnabled(false);
    this.mContextView.killMode();
    ActionModeImpl actionModeImpl = new ActionModeImpl(this.mContextView.getContext(), paramCallback);
    if (actionModeImpl.dispatchOnCreate()) {
      this.mActionMode = actionModeImpl;
      actionModeImpl.invalidate();
      this.mContextView.initForMode(actionModeImpl);
      animateToMode(true);
      this.mContextView.sendAccessibilityEvent(32);
      return actionModeImpl;
    } 
    return null;
  }
  
  static {
    boolean bool1;
    boolean bool2 = true;
    if (!WindowDecorActionBar.class.desiredAssertionStatus()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    $assertionsDisabled = bool1;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
    private final Context mActionModeContext;
    
    private ActionMode.Callback mCallback;
    
    private WeakReference<View> mCustomView;
    
    private final MenuBuilder mMenu;
    
    public ActionModeImpl(Context param1Context, ActionMode.Callback param1Callback) {
      this.mActionModeContext = param1Context;
      this.mCallback = param1Callback;
      this.mMenu = (new MenuBuilder(param1Context)).setDefaultShowAsAction(1);
      this.mMenu.setCallback(this);
    }
    
    public boolean dispatchOnCreate() {
      this.mMenu.stopDispatchingItemsChanged();
      try {
        return this.mCallback.onCreateActionMode(this, (Menu)this.mMenu);
      } finally {
        this.mMenu.startDispatchingItemsChanged();
      } 
    }
    
    public void finish() {
      if (WindowDecorActionBar.this.mActionMode != this)
        return; 
      if (!WindowDecorActionBar.checkShowingFlags(WindowDecorActionBar.this.mHiddenByApp, WindowDecorActionBar.this.mHiddenBySystem, false)) {
        WindowDecorActionBar.this.mDeferredDestroyActionMode = this;
        WindowDecorActionBar.this.mDeferredModeDestroyCallback = this.mCallback;
      } else {
        this.mCallback.onDestroyActionMode(this);
      } 
      this.mCallback = null;
      WindowDecorActionBar.this.animateToMode(false);
      WindowDecorActionBar.this.mContextView.closeMode();
      WindowDecorActionBar.this.mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
      WindowDecorActionBar.this.mOverlayLayout.setHideOnContentScrollEnabled(WindowDecorActionBar.this.mHideOnContentScroll);
      WindowDecorActionBar.this.mActionMode = null;
    }
    
    public View getCustomView() {
      return (this.mCustomView != null) ? this.mCustomView.get() : null;
    }
    
    public Menu getMenu() {
      return (Menu)this.mMenu;
    }
    
    public MenuInflater getMenuInflater() {
      return (MenuInflater)new SupportMenuInflater(this.mActionModeContext);
    }
    
    public CharSequence getSubtitle() {
      return WindowDecorActionBar.this.mContextView.getSubtitle();
    }
    
    public CharSequence getTitle() {
      return WindowDecorActionBar.this.mContextView.getTitle();
    }
    
    public void invalidate() {
      if (WindowDecorActionBar.this.mActionMode != this)
        return; 
      this.mMenu.stopDispatchingItemsChanged();
      try {
        this.mCallback.onPrepareActionMode(this, (Menu)this.mMenu);
        return;
      } finally {
        this.mMenu.startDispatchingItemsChanged();
      } 
    }
    
    public boolean isTitleOptional() {
      return WindowDecorActionBar.this.mContextView.isTitleOptional();
    }
    
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {}
    
    public void onCloseSubMenu(SubMenuBuilder param1SubMenuBuilder) {}
    
    public boolean onMenuItemSelected(MenuBuilder param1MenuBuilder, MenuItem param1MenuItem) {
      return (this.mCallback != null) ? this.mCallback.onActionItemClicked(this, param1MenuItem) : false;
    }
    
    public void onMenuModeChange(MenuBuilder param1MenuBuilder) {
      if (this.mCallback == null)
        return; 
      invalidate();
      WindowDecorActionBar.this.mContextView.showOverflowMenu();
    }
    
    public boolean onSubMenuSelected(SubMenuBuilder param1SubMenuBuilder) {
      boolean bool = true;
      if (this.mCallback == null)
        return false; 
      if (param1SubMenuBuilder.hasVisibleItems()) {
        (new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), (MenuBuilder)param1SubMenuBuilder)).show();
        return true;
      } 
      return bool;
    }
    
    public void setCustomView(View param1View) {
      WindowDecorActionBar.this.mContextView.setCustomView(param1View);
      this.mCustomView = new WeakReference<View>(param1View);
    }
    
    public void setSubtitle(int param1Int) {
      setSubtitle(WindowDecorActionBar.this.mContext.getResources().getString(param1Int));
    }
    
    public void setSubtitle(CharSequence param1CharSequence) {
      WindowDecorActionBar.this.mContextView.setSubtitle(param1CharSequence);
    }
    
    public void setTitle(int param1Int) {
      setTitle(WindowDecorActionBar.this.mContext.getResources().getString(param1Int));
    }
    
    public void setTitle(CharSequence param1CharSequence) {
      WindowDecorActionBar.this.mContextView.setTitle(param1CharSequence);
    }
    
    public void setTitleOptionalHint(boolean param1Boolean) {
      super.setTitleOptionalHint(param1Boolean);
      WindowDecorActionBar.this.mContextView.setTitleOptional(param1Boolean);
    }
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public class TabImpl extends ActionBar.Tab {
    private ActionBar.TabListener mCallback;
    
    private CharSequence mContentDesc;
    
    private View mCustomView;
    
    private Drawable mIcon;
    
    private int mPosition = -1;
    
    private Object mTag;
    
    private CharSequence mText;
    
    public ActionBar.TabListener getCallback() {
      return this.mCallback;
    }
    
    public CharSequence getContentDescription() {
      return this.mContentDesc;
    }
    
    public View getCustomView() {
      return this.mCustomView;
    }
    
    public Drawable getIcon() {
      return this.mIcon;
    }
    
    public int getPosition() {
      return this.mPosition;
    }
    
    public Object getTag() {
      return this.mTag;
    }
    
    public CharSequence getText() {
      return this.mText;
    }
    
    public void select() {
      WindowDecorActionBar.this.selectTab(this);
    }
    
    public ActionBar.Tab setContentDescription(int param1Int) {
      return setContentDescription(WindowDecorActionBar.this.mContext.getResources().getText(param1Int));
    }
    
    public ActionBar.Tab setContentDescription(CharSequence param1CharSequence) {
      this.mContentDesc = param1CharSequence;
      if (this.mPosition >= 0)
        WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition); 
      return this;
    }
    
    public ActionBar.Tab setCustomView(int param1Int) {
      return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(param1Int, null));
    }
    
    public ActionBar.Tab setCustomView(View param1View) {
      this.mCustomView = param1View;
      if (this.mPosition >= 0)
        WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition); 
      return this;
    }
    
    public ActionBar.Tab setIcon(int param1Int) {
      return setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.mContext, param1Int));
    }
    
    public ActionBar.Tab setIcon(Drawable param1Drawable) {
      this.mIcon = param1Drawable;
      if (this.mPosition >= 0)
        WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition); 
      return this;
    }
    
    public void setPosition(int param1Int) {
      this.mPosition = param1Int;
    }
    
    public ActionBar.Tab setTabListener(ActionBar.TabListener param1TabListener) {
      this.mCallback = param1TabListener;
      return this;
    }
    
    public ActionBar.Tab setTag(Object param1Object) {
      this.mTag = param1Object;
      return this;
    }
    
    public ActionBar.Tab setText(int param1Int) {
      return setText(WindowDecorActionBar.this.mContext.getResources().getText(param1Int));
    }
    
    public ActionBar.Tab setText(CharSequence param1CharSequence) {
      this.mText = param1CharSequence;
      if (this.mPosition >= 0)
        WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition); 
      return this;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\app\WindowDecorActionBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */