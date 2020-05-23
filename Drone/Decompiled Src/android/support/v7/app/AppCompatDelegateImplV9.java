package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NavUtils;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(9)
@RequiresApi(9)
class AppCompatDelegateImplV9 extends AppCompatDelegateImplBase implements MenuBuilder.Callback, LayoutInflaterFactory {
  private static final boolean IS_PRE_LOLLIPOP;
  
  private ActionMenuPresenterCallback mActionMenuPresenterCallback;
  
  ActionMode mActionMode;
  
  PopupWindow mActionModePopup;
  
  ActionBarContextView mActionModeView;
  
  private AppCompatViewInflater mAppCompatViewInflater;
  
  private boolean mClosingActionMenu;
  
  private DecorContentParent mDecorContentParent;
  
  private boolean mEnableDefaultActionBarUp;
  
  ViewPropertyAnimatorCompat mFadeAnim = null;
  
  private boolean mFeatureIndeterminateProgress;
  
  private boolean mFeatureProgress;
  
  int mInvalidatePanelMenuFeatures;
  
  boolean mInvalidatePanelMenuPosted;
  
  private final Runnable mInvalidatePanelMenuRunnable = new Runnable() {
      public void run() {
        if ((AppCompatDelegateImplV9.this.mInvalidatePanelMenuFeatures & 0x1) != 0)
          AppCompatDelegateImplV9.this.doInvalidatePanelMenu(0); 
        if ((AppCompatDelegateImplV9.this.mInvalidatePanelMenuFeatures & 0x1000) != 0)
          AppCompatDelegateImplV9.this.doInvalidatePanelMenu(108); 
        AppCompatDelegateImplV9.this.mInvalidatePanelMenuPosted = false;
        AppCompatDelegateImplV9.this.mInvalidatePanelMenuFeatures = 0;
      }
    };
  
  private boolean mLongPressBackDown;
  
  private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
  
  private PanelFeatureState[] mPanels;
  
  private PanelFeatureState mPreparedPanel;
  
  Runnable mShowActionModePopup;
  
  private View mStatusGuard;
  
  private ViewGroup mSubDecor;
  
  private boolean mSubDecorInstalled;
  
  private Rect mTempRect1;
  
  private Rect mTempRect2;
  
  private TextView mTitleView;
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT < 21) {
      bool = true;
    } else {
      bool = false;
    } 
    IS_PRE_LOLLIPOP = bool;
  }
  
  AppCompatDelegateImplV9(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback) {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  private void applyFixedSizeWindow() {
    ContentFrameLayout contentFrameLayout = (ContentFrameLayout)this.mSubDecor.findViewById(16908290);
    View view = this.mWindow.getDecorView();
    contentFrameLayout.setDecorPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    TypedArray typedArray = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
    typedArray.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
    typedArray.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
    if (typedArray.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor))
      typedArray.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor()); 
    if (typedArray.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor))
      typedArray.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor()); 
    if (typedArray.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor))
      typedArray.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor()); 
    if (typedArray.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor))
      typedArray.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor()); 
    typedArray.recycle();
    contentFrameLayout.requestLayout();
  }
  
  private ViewGroup createSubDecor() {
    ViewGroup viewGroup1;
    ViewGroup viewGroup2;
    TypedArray typedArray = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
    if (!typedArray.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
      typedArray.recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    } 
    if (typedArray.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
      requestWindowFeature(1);
    } else if (typedArray.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
      requestWindowFeature(108);
    } 
    if (typedArray.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false))
      requestWindowFeature(109); 
    if (typedArray.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false))
      requestWindowFeature(10); 
    this.mIsFloating = typedArray.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
    typedArray.recycle();
    this.mWindow.getDecorView();
    LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
    typedArray = null;
    if (!this.mWindowNoTitle) {
      if (this.mIsFloating) {
        viewGroup1 = (ViewGroup)layoutInflater.inflate(R.layout.abc_dialog_title_material, null);
        this.mOverlayActionBar = false;
        this.mHasActionBar = false;
      } else if (this.mHasActionBar) {
        Context context;
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
          ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.mContext, typedValue.resourceId);
        } else {
          context = this.mContext;
        } 
        viewGroup2 = (ViewGroup)LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, null);
        this.mDecorContentParent = (DecorContentParent)viewGroup2.findViewById(R.id.decor_content_parent);
        this.mDecorContentParent.setWindowCallback(getWindowCallback());
        if (this.mOverlayActionBar)
          this.mDecorContentParent.initFeature(109); 
        if (this.mFeatureProgress)
          this.mDecorContentParent.initFeature(2); 
        viewGroup1 = viewGroup2;
        if (this.mFeatureIndeterminateProgress) {
          this.mDecorContentParent.initFeature(5);
          viewGroup1 = viewGroup2;
        } 
      } 
    } else {
      if (this.mOverlayActionMode) {
        viewGroup1 = (ViewGroup)viewGroup2.inflate(R.layout.abc_screen_simple_overlay_action_mode, null);
      } else {
        viewGroup1 = (ViewGroup)viewGroup2.inflate(R.layout.abc_screen_simple, null);
      } 
      if (Build.VERSION.SDK_INT >= 21) {
        ViewCompat.setOnApplyWindowInsetsListener((View)viewGroup1, new OnApplyWindowInsetsListener() {
              public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
                int i = param1WindowInsetsCompat.getSystemWindowInsetTop();
                int j = AppCompatDelegateImplV9.this.updateStatusGuard(i);
                WindowInsetsCompat windowInsetsCompat = param1WindowInsetsCompat;
                if (i != j)
                  windowInsetsCompat = param1WindowInsetsCompat.replaceSystemWindowInsets(param1WindowInsetsCompat.getSystemWindowInsetLeft(), j, param1WindowInsetsCompat.getSystemWindowInsetRight(), param1WindowInsetsCompat.getSystemWindowInsetBottom()); 
                return ViewCompat.onApplyWindowInsets(param1View, windowInsetsCompat);
              }
            });
      } else {
        ((FitWindowsViewGroup)viewGroup1).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() {
              public void onFitSystemWindows(Rect param1Rect) {
                param1Rect.top = AppCompatDelegateImplV9.this.updateStatusGuard(param1Rect.top);
              }
            });
      } 
    } 
    if (viewGroup1 == null)
      throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }"); 
    if (this.mDecorContentParent == null)
      this.mTitleView = (TextView)viewGroup1.findViewById(R.id.title); 
    ViewUtils.makeOptionalFitsSystemWindows((View)viewGroup1);
    ContentFrameLayout contentFrameLayout = (ContentFrameLayout)viewGroup1.findViewById(R.id.action_bar_activity_content);
    ViewGroup viewGroup3 = (ViewGroup)this.mWindow.findViewById(16908290);
    if (viewGroup3 != null) {
      while (viewGroup3.getChildCount() > 0) {
        View view = viewGroup3.getChildAt(0);
        viewGroup3.removeViewAt(0);
        contentFrameLayout.addView(view);
      } 
      viewGroup3.setId(-1);
      contentFrameLayout.setId(16908290);
      if (viewGroup3 instanceof FrameLayout)
        ((FrameLayout)viewGroup3).setForeground(null); 
    } 
    this.mWindow.setContentView((View)viewGroup1);
    contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() {
          public void onAttachedFromWindow() {}
          
          public void onDetachedFromWindow() {
            AppCompatDelegateImplV9.this.dismissPopups();
          }
        });
    return viewGroup1;
  }
  
  private void ensureSubDecor() {
    if (!this.mSubDecorInstalled) {
      this.mSubDecor = createSubDecor();
      CharSequence charSequence = getTitle();
      if (!TextUtils.isEmpty(charSequence))
        onTitleChanged(charSequence); 
      applyFixedSizeWindow();
      onSubDecorInstalled(this.mSubDecor);
      this.mSubDecorInstalled = true;
      PanelFeatureState panelFeatureState = getPanelState(0, false);
      if (!isDestroyed() && (panelFeatureState == null || panelFeatureState.menu == null))
        invalidatePanelMenu(108); 
    } 
  }
  
  private boolean initializePanelContent(PanelFeatureState paramPanelFeatureState) {
    if (paramPanelFeatureState.createdPanelView != null) {
      paramPanelFeatureState.shownPanelView = paramPanelFeatureState.createdPanelView;
      return true;
    } 
    if (paramPanelFeatureState.menu == null)
      return false; 
    if (this.mPanelMenuPresenterCallback == null)
      this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(); 
    paramPanelFeatureState.shownPanelView = (View)paramPanelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback);
    return !(paramPanelFeatureState.shownPanelView == null);
  }
  
  private boolean initializePanelDecor(PanelFeatureState paramPanelFeatureState) {
    paramPanelFeatureState.setStyle(getActionBarThemedContext());
    paramPanelFeatureState.decorView = (ViewGroup)new ListMenuDecorView(paramPanelFeatureState.listPresenterContext);
    paramPanelFeatureState.gravity = 81;
    return true;
  }
  
  private boolean initializePanelMenu(PanelFeatureState paramPanelFeatureState) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mContext : Landroid/content/Context;
    //   4: astore #4
    //   6: aload_1
    //   7: getfield featureId : I
    //   10: ifeq -> 25
    //   13: aload #4
    //   15: astore_2
    //   16: aload_1
    //   17: getfield featureId : I
    //   20: bipush #108
    //   22: if_icmpne -> 176
    //   25: aload #4
    //   27: astore_2
    //   28: aload_0
    //   29: getfield mDecorContentParent : Landroid/support/v7/widget/DecorContentParent;
    //   32: ifnull -> 176
    //   35: new android/util/TypedValue
    //   38: dup
    //   39: invokespecial <init> : ()V
    //   42: astore #5
    //   44: aload #4
    //   46: invokevirtual getTheme : ()Landroid/content/res/Resources$Theme;
    //   49: astore #6
    //   51: aload #6
    //   53: getstatic android/support/v7/appcompat/R$attr.actionBarTheme : I
    //   56: aload #5
    //   58: iconst_1
    //   59: invokevirtual resolveAttribute : (ILandroid/util/TypedValue;Z)Z
    //   62: pop
    //   63: aconst_null
    //   64: astore_2
    //   65: aload #5
    //   67: getfield resourceId : I
    //   70: ifeq -> 197
    //   73: aload #4
    //   75: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   78: invokevirtual newTheme : ()Landroid/content/res/Resources$Theme;
    //   81: astore_2
    //   82: aload_2
    //   83: aload #6
    //   85: invokevirtual setTo : (Landroid/content/res/Resources$Theme;)V
    //   88: aload_2
    //   89: aload #5
    //   91: getfield resourceId : I
    //   94: iconst_1
    //   95: invokevirtual applyStyle : (IZ)V
    //   98: aload_2
    //   99: getstatic android/support/v7/appcompat/R$attr.actionBarWidgetTheme : I
    //   102: aload #5
    //   104: iconst_1
    //   105: invokevirtual resolveAttribute : (ILandroid/util/TypedValue;Z)Z
    //   108: pop
    //   109: aload_2
    //   110: astore_3
    //   111: aload #5
    //   113: getfield resourceId : I
    //   116: ifeq -> 150
    //   119: aload_2
    //   120: astore_3
    //   121: aload_2
    //   122: ifnonnull -> 140
    //   125: aload #4
    //   127: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   130: invokevirtual newTheme : ()Landroid/content/res/Resources$Theme;
    //   133: astore_3
    //   134: aload_3
    //   135: aload #6
    //   137: invokevirtual setTo : (Landroid/content/res/Resources$Theme;)V
    //   140: aload_3
    //   141: aload #5
    //   143: getfield resourceId : I
    //   146: iconst_1
    //   147: invokevirtual applyStyle : (IZ)V
    //   150: aload #4
    //   152: astore_2
    //   153: aload_3
    //   154: ifnull -> 176
    //   157: new android/support/v7/view/ContextThemeWrapper
    //   160: dup
    //   161: aload #4
    //   163: iconst_0
    //   164: invokespecial <init> : (Landroid/content/Context;I)V
    //   167: astore_2
    //   168: aload_2
    //   169: invokevirtual getTheme : ()Landroid/content/res/Resources$Theme;
    //   172: aload_3
    //   173: invokevirtual setTo : (Landroid/content/res/Resources$Theme;)V
    //   176: new android/support/v7/view/menu/MenuBuilder
    //   179: dup
    //   180: aload_2
    //   181: invokespecial <init> : (Landroid/content/Context;)V
    //   184: astore_2
    //   185: aload_2
    //   186: aload_0
    //   187: invokevirtual setCallback : (Landroid/support/v7/view/menu/MenuBuilder$Callback;)V
    //   190: aload_1
    //   191: aload_2
    //   192: invokevirtual setMenu : (Landroid/support/v7/view/menu/MenuBuilder;)V
    //   195: iconst_1
    //   196: ireturn
    //   197: aload #6
    //   199: getstatic android/support/v7/appcompat/R$attr.actionBarWidgetTheme : I
    //   202: aload #5
    //   204: iconst_1
    //   205: invokevirtual resolveAttribute : (ILandroid/util/TypedValue;Z)Z
    //   208: pop
    //   209: goto -> 109
  }
  
  private void invalidatePanelMenu(int paramInt) {
    this.mInvalidatePanelMenuFeatures |= 1 << paramInt;
    if (!this.mInvalidatePanelMenuPosted) {
      ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
      this.mInvalidatePanelMenuPosted = true;
    } 
  }
  
  private boolean onKeyDownPanel(int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getRepeatCount() == 0) {
      PanelFeatureState panelFeatureState = getPanelState(paramInt, true);
      if (!panelFeatureState.isOpen)
        return preparePanel(panelFeatureState, paramKeyEvent); 
    } 
    return false;
  }
  
  private boolean onKeyUpPanel(int paramInt, KeyEvent paramKeyEvent) {
    boolean bool1;
    if (this.mActionMode != null)
      return false; 
    boolean bool3 = false;
    PanelFeatureState panelFeatureState = getPanelState(paramInt, true);
    if (paramInt == 0 && this.mDecorContentParent != null && this.mDecorContentParent.canShowOverflowMenu() && !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
      if (!this.mDecorContentParent.isOverflowMenuShowing()) {
        bool1 = bool3;
        if (!isDestroyed()) {
          bool1 = bool3;
          if (preparePanel(panelFeatureState, paramKeyEvent))
            bool1 = this.mDecorContentParent.showOverflowMenu(); 
        } 
      } else {
        bool1 = this.mDecorContentParent.hideOverflowMenu();
      } 
    } else if (panelFeatureState.isOpen || panelFeatureState.isHandled) {
      bool1 = panelFeatureState.isOpen;
      closePanel(panelFeatureState, true);
    } else {
      bool1 = bool3;
      if (panelFeatureState.isPrepared) {
        boolean bool = true;
        if (panelFeatureState.refreshMenuContent) {
          panelFeatureState.isPrepared = false;
          bool = preparePanel(panelFeatureState, paramKeyEvent);
        } 
        bool1 = bool3;
        if (bool) {
          openPanel(panelFeatureState, paramKeyEvent);
          bool1 = true;
        } 
      } 
    } 
    boolean bool2 = bool1;
    if (bool1) {
      AudioManager audioManager = (AudioManager)this.mContext.getSystemService("audio");
      if (audioManager != null) {
        audioManager.playSoundEffect(0);
        return bool1;
      } 
      Log.w("AppCompatDelegate", "Couldn't get audio manager");
      return bool1;
    } 
    return bool2;
  }
  
  private void openPanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent) {
    // Byte code:
    //   0: aload_1
    //   1: getfield isOpen : Z
    //   4: ifne -> 14
    //   7: aload_0
    //   8: invokevirtual isDestroyed : ()Z
    //   11: ifeq -> 15
    //   14: return
    //   15: aload_1
    //   16: getfield featureId : I
    //   19: ifne -> 73
    //   22: aload_0
    //   23: getfield mContext : Landroid/content/Context;
    //   26: astore #5
    //   28: aload #5
    //   30: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   33: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   36: getfield screenLayout : I
    //   39: bipush #15
    //   41: iand
    //   42: iconst_4
    //   43: if_icmpne -> 109
    //   46: iconst_1
    //   47: istore_3
    //   48: aload #5
    //   50: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   53: getfield targetSdkVersion : I
    //   56: bipush #11
    //   58: if_icmplt -> 114
    //   61: iconst_1
    //   62: istore #4
    //   64: iload_3
    //   65: ifeq -> 73
    //   68: iload #4
    //   70: ifne -> 14
    //   73: aload_0
    //   74: invokevirtual getWindowCallback : ()Landroid/view/Window$Callback;
    //   77: astore #5
    //   79: aload #5
    //   81: ifnull -> 120
    //   84: aload #5
    //   86: aload_1
    //   87: getfield featureId : I
    //   90: aload_1
    //   91: getfield menu : Landroid/support/v7/view/menu/MenuBuilder;
    //   94: invokeinterface onMenuOpened : (ILandroid/view/Menu;)Z
    //   99: ifne -> 120
    //   102: aload_0
    //   103: aload_1
    //   104: iconst_1
    //   105: invokevirtual closePanel : (Landroid/support/v7/app/AppCompatDelegateImplV9$PanelFeatureState;Z)V
    //   108: return
    //   109: iconst_0
    //   110: istore_3
    //   111: goto -> 48
    //   114: iconst_0
    //   115: istore #4
    //   117: goto -> 64
    //   120: aload_0
    //   121: getfield mContext : Landroid/content/Context;
    //   124: ldc_w 'window'
    //   127: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   130: checkcast android/view/WindowManager
    //   133: astore #6
    //   135: aload #6
    //   137: ifnull -> 14
    //   140: aload_0
    //   141: aload_1
    //   142: aload_2
    //   143: invokespecial preparePanel : (Landroid/support/v7/app/AppCompatDelegateImplV9$PanelFeatureState;Landroid/view/KeyEvent;)Z
    //   146: ifeq -> 14
    //   149: bipush #-2
    //   151: istore #4
    //   153: aload_1
    //   154: getfield decorView : Landroid/view/ViewGroup;
    //   157: ifnull -> 167
    //   160: aload_1
    //   161: getfield refreshDecorView : Z
    //   164: ifeq -> 409
    //   167: aload_1
    //   168: getfield decorView : Landroid/view/ViewGroup;
    //   171: ifnonnull -> 382
    //   174: aload_0
    //   175: aload_1
    //   176: invokespecial initializePanelDecor : (Landroid/support/v7/app/AppCompatDelegateImplV9$PanelFeatureState;)Z
    //   179: ifeq -> 14
    //   182: aload_1
    //   183: getfield decorView : Landroid/view/ViewGroup;
    //   186: ifnull -> 14
    //   189: aload_0
    //   190: aload_1
    //   191: invokespecial initializePanelContent : (Landroid/support/v7/app/AppCompatDelegateImplV9$PanelFeatureState;)Z
    //   194: ifeq -> 14
    //   197: aload_1
    //   198: invokevirtual hasPanelItems : ()Z
    //   201: ifeq -> 14
    //   204: aload_1
    //   205: getfield shownPanelView : Landroid/view/View;
    //   208: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   211: astore #5
    //   213: aload #5
    //   215: astore_2
    //   216: aload #5
    //   218: ifnonnull -> 233
    //   221: new android/view/ViewGroup$LayoutParams
    //   224: dup
    //   225: bipush #-2
    //   227: bipush #-2
    //   229: invokespecial <init> : (II)V
    //   232: astore_2
    //   233: aload_1
    //   234: getfield background : I
    //   237: istore_3
    //   238: aload_1
    //   239: getfield decorView : Landroid/view/ViewGroup;
    //   242: iload_3
    //   243: invokevirtual setBackgroundResource : (I)V
    //   246: aload_1
    //   247: getfield shownPanelView : Landroid/view/View;
    //   250: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   253: astore #5
    //   255: aload #5
    //   257: ifnull -> 280
    //   260: aload #5
    //   262: instanceof android/view/ViewGroup
    //   265: ifeq -> 280
    //   268: aload #5
    //   270: checkcast android/view/ViewGroup
    //   273: aload_1
    //   274: getfield shownPanelView : Landroid/view/View;
    //   277: invokevirtual removeView : (Landroid/view/View;)V
    //   280: aload_1
    //   281: getfield decorView : Landroid/view/ViewGroup;
    //   284: aload_1
    //   285: getfield shownPanelView : Landroid/view/View;
    //   288: aload_2
    //   289: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   292: iload #4
    //   294: istore_3
    //   295: aload_1
    //   296: getfield shownPanelView : Landroid/view/View;
    //   299: invokevirtual hasFocus : ()Z
    //   302: ifne -> 316
    //   305: aload_1
    //   306: getfield shownPanelView : Landroid/view/View;
    //   309: invokevirtual requestFocus : ()Z
    //   312: pop
    //   313: iload #4
    //   315: istore_3
    //   316: aload_1
    //   317: iconst_0
    //   318: putfield isHandled : Z
    //   321: new android/view/WindowManager$LayoutParams
    //   324: dup
    //   325: iload_3
    //   326: bipush #-2
    //   328: aload_1
    //   329: getfield x : I
    //   332: aload_1
    //   333: getfield y : I
    //   336: sipush #1002
    //   339: ldc_w 8519680
    //   342: bipush #-3
    //   344: invokespecial <init> : (IIIIIII)V
    //   347: astore_2
    //   348: aload_2
    //   349: aload_1
    //   350: getfield gravity : I
    //   353: putfield gravity : I
    //   356: aload_2
    //   357: aload_1
    //   358: getfield windowAnimations : I
    //   361: putfield windowAnimations : I
    //   364: aload #6
    //   366: aload_1
    //   367: getfield decorView : Landroid/view/ViewGroup;
    //   370: aload_2
    //   371: invokeinterface addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   376: aload_1
    //   377: iconst_1
    //   378: putfield isOpen : Z
    //   381: return
    //   382: aload_1
    //   383: getfield refreshDecorView : Z
    //   386: ifeq -> 189
    //   389: aload_1
    //   390: getfield decorView : Landroid/view/ViewGroup;
    //   393: invokevirtual getChildCount : ()I
    //   396: ifle -> 189
    //   399: aload_1
    //   400: getfield decorView : Landroid/view/ViewGroup;
    //   403: invokevirtual removeAllViews : ()V
    //   406: goto -> 189
    //   409: iload #4
    //   411: istore_3
    //   412: aload_1
    //   413: getfield createdPanelView : Landroid/view/View;
    //   416: ifnull -> 316
    //   419: aload_1
    //   420: getfield createdPanelView : Landroid/view/View;
    //   423: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   426: astore_2
    //   427: iload #4
    //   429: istore_3
    //   430: aload_2
    //   431: ifnull -> 316
    //   434: iload #4
    //   436: istore_3
    //   437: aload_2
    //   438: getfield width : I
    //   441: iconst_m1
    //   442: if_icmpne -> 316
    //   445: iconst_m1
    //   446: istore_3
    //   447: goto -> 316
  }
  
  private boolean performPanelShortcut(PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2) {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual isSystem : ()Z
    //   4: ifeq -> 13
    //   7: iconst_0
    //   8: istore #6
    //   10: iload #6
    //   12: ireturn
    //   13: iconst_0
    //   14: istore #6
    //   16: aload_1
    //   17: getfield isPrepared : Z
    //   20: ifne -> 36
    //   23: iload #6
    //   25: istore #5
    //   27: aload_0
    //   28: aload_1
    //   29: aload_3
    //   30: invokespecial preparePanel : (Landroid/support/v7/app/AppCompatDelegateImplV9$PanelFeatureState;Landroid/view/KeyEvent;)Z
    //   33: ifeq -> 60
    //   36: iload #6
    //   38: istore #5
    //   40: aload_1
    //   41: getfield menu : Landroid/support/v7/view/menu/MenuBuilder;
    //   44: ifnull -> 60
    //   47: aload_1
    //   48: getfield menu : Landroid/support/v7/view/menu/MenuBuilder;
    //   51: iload_2
    //   52: aload_3
    //   53: iload #4
    //   55: invokevirtual performShortcut : (ILandroid/view/KeyEvent;I)Z
    //   58: istore #5
    //   60: iload #5
    //   62: istore #6
    //   64: iload #5
    //   66: ifeq -> 10
    //   69: iload #5
    //   71: istore #6
    //   73: iload #4
    //   75: iconst_1
    //   76: iand
    //   77: ifne -> 10
    //   80: iload #5
    //   82: istore #6
    //   84: aload_0
    //   85: getfield mDecorContentParent : Landroid/support/v7/widget/DecorContentParent;
    //   88: ifnonnull -> 10
    //   91: aload_0
    //   92: aload_1
    //   93: iconst_1
    //   94: invokevirtual closePanel : (Landroid/support/v7/app/AppCompatDelegateImplV9$PanelFeatureState;Z)V
    //   97: iload #5
    //   99: ireturn
  }
  
  private boolean preparePanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent) {
    if (!isDestroyed()) {
      int i;
      if (paramPanelFeatureState.isPrepared)
        return true; 
      if (this.mPreparedPanel != null && this.mPreparedPanel != paramPanelFeatureState)
        closePanel(this.mPreparedPanel, false); 
      Window.Callback callback = getWindowCallback();
      if (callback != null)
        paramPanelFeatureState.createdPanelView = callback.onCreatePanelView(paramPanelFeatureState.featureId); 
      if (paramPanelFeatureState.featureId == 0 || paramPanelFeatureState.featureId == 108) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i && this.mDecorContentParent != null)
        this.mDecorContentParent.setMenuPrepared(); 
      if (paramPanelFeatureState.createdPanelView == null && (!i || !(peekSupportActionBar() instanceof ToolbarActionBar))) {
        boolean bool;
        if (paramPanelFeatureState.menu == null || paramPanelFeatureState.refreshMenuContent)
          if (paramPanelFeatureState.menu != null || (initializePanelMenu(paramPanelFeatureState) && paramPanelFeatureState.menu != null)) {
            if (i && this.mDecorContentParent != null) {
              if (this.mActionMenuPresenterCallback == null)
                this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback(); 
              this.mDecorContentParent.setMenu((Menu)paramPanelFeatureState.menu, this.mActionMenuPresenterCallback);
            } 
            paramPanelFeatureState.menu.stopDispatchingItemsChanged();
            if (!callback.onCreatePanelMenu(paramPanelFeatureState.featureId, (Menu)paramPanelFeatureState.menu)) {
              paramPanelFeatureState.setMenu(null);
              if (i && this.mDecorContentParent != null) {
                this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
                return false;
              } 
              return false;
            } 
            paramPanelFeatureState.refreshMenuContent = false;
          } else {
            return false;
          }  
        paramPanelFeatureState.menu.stopDispatchingItemsChanged();
        if (paramPanelFeatureState.frozenActionViewState != null) {
          paramPanelFeatureState.menu.restoreActionViewStates(paramPanelFeatureState.frozenActionViewState);
          paramPanelFeatureState.frozenActionViewState = null;
        } 
        if (!callback.onPreparePanel(0, paramPanelFeatureState.createdPanelView, (Menu)paramPanelFeatureState.menu)) {
          if (i && this.mDecorContentParent != null)
            this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback); 
          paramPanelFeatureState.menu.startDispatchingItemsChanged();
          return false;
        } 
        if (paramKeyEvent != null) {
          i = paramKeyEvent.getDeviceId();
        } else {
          i = -1;
        } 
        if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
          bool = true;
        } else {
          bool = false;
        } 
        paramPanelFeatureState.qwertyMode = bool;
        paramPanelFeatureState.menu.setQwertyMode(paramPanelFeatureState.qwertyMode);
        paramPanelFeatureState.menu.startDispatchingItemsChanged();
      } 
      paramPanelFeatureState.isPrepared = true;
      paramPanelFeatureState.isHandled = false;
      this.mPreparedPanel = paramPanelFeatureState;
      return true;
    } 
    return false;
  }
  
  private void reopenMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    if (this.mDecorContentParent != null && this.mDecorContentParent.canShowOverflowMenu() && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) || this.mDecorContentParent.isOverflowMenuShowPending())) {
      Window.Callback callback = getWindowCallback();
      if (!this.mDecorContentParent.isOverflowMenuShowing() || !paramBoolean) {
        if (callback != null && !isDestroyed()) {
          if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 0x1) != 0) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuRunnable.run();
          } 
          PanelFeatureState panelFeatureState1 = getPanelState(0, true);
          if (panelFeatureState1.menu != null && !panelFeatureState1.refreshMenuContent && callback.onPreparePanel(0, panelFeatureState1.createdPanelView, (Menu)panelFeatureState1.menu)) {
            callback.onMenuOpened(108, (Menu)panelFeatureState1.menu);
            this.mDecorContentParent.showOverflowMenu();
          } 
        } 
        return;
      } 
      this.mDecorContentParent.hideOverflowMenu();
      if (!isDestroyed()) {
        callback.onPanelClosed(108, (Menu)(getPanelState(0, true)).menu);
        return;
      } 
      return;
    } 
    PanelFeatureState panelFeatureState = getPanelState(0, true);
    panelFeatureState.refreshDecorView = true;
    closePanel(panelFeatureState, false);
    openPanel(panelFeatureState, (KeyEvent)null);
  }
  
  private int sanitizeWindowFeatureId(int paramInt) {
    if (paramInt == 8) {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      return 108;
    } 
    int i = paramInt;
    if (paramInt == 9) {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
      return 109;
    } 
    return i;
  }
  
  private boolean shouldInheritContext(ViewParent paramViewParent) {
    if (paramViewParent == null)
      return false; 
    View view = this.mWindow.getDecorView();
    while (true) {
      if (paramViewParent == null)
        return true; 
      if (paramViewParent == view || !(paramViewParent instanceof View) || ViewCompat.isAttachedToWindow((View)paramViewParent))
        return false; 
      paramViewParent = paramViewParent.getParent();
    } 
  }
  
  private void throwFeatureRequestIfSubDecorInstalled() {
    if (this.mSubDecorInstalled)
      throw new AndroidRuntimeException("Window feature must be requested before adding content"); 
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    ensureSubDecor();
    ((ViewGroup)this.mSubDecor.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.mOriginalWindowCallback.onContentChanged();
  }
  
  View callActivityOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    if (this.mOriginalWindowCallback instanceof LayoutInflater.Factory) {
      paramView = ((LayoutInflater.Factory)this.mOriginalWindowCallback).onCreateView(paramString, paramContext, paramAttributeSet);
      if (paramView != null)
        return paramView; 
    } 
    return null;
  }
  
  void callOnPanelClosed(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu) {
    MenuBuilder menuBuilder;
    PanelFeatureState panelFeatureState = paramPanelFeatureState;
    Menu menu = paramMenu;
    if (paramMenu == null) {
      PanelFeatureState panelFeatureState1 = paramPanelFeatureState;
      if (paramPanelFeatureState == null) {
        panelFeatureState1 = paramPanelFeatureState;
        if (paramInt >= 0) {
          panelFeatureState1 = paramPanelFeatureState;
          if (paramInt < this.mPanels.length)
            panelFeatureState1 = this.mPanels[paramInt]; 
        } 
      } 
      panelFeatureState = panelFeatureState1;
      menu = paramMenu;
      if (panelFeatureState1 != null) {
        menuBuilder = panelFeatureState1.menu;
        panelFeatureState = panelFeatureState1;
      } 
    } 
    if ((panelFeatureState == null || panelFeatureState.isOpen) && !isDestroyed()) {
      this.mOriginalWindowCallback.onPanelClosed(paramInt, (Menu)menuBuilder);
      return;
    } 
  }
  
  void checkCloseActionMenu(MenuBuilder paramMenuBuilder) {
    if (this.mClosingActionMenu)
      return; 
    this.mClosingActionMenu = true;
    this.mDecorContentParent.dismissPopups();
    Window.Callback callback = getWindowCallback();
    if (callback != null && !isDestroyed())
      callback.onPanelClosed(108, (Menu)paramMenuBuilder); 
    this.mClosingActionMenu = false;
  }
  
  void closePanel(int paramInt) {
    closePanel(getPanelState(paramInt, true), true);
  }
  
  void closePanel(PanelFeatureState paramPanelFeatureState, boolean paramBoolean) {
    if (paramBoolean && paramPanelFeatureState.featureId == 0 && this.mDecorContentParent != null && this.mDecorContentParent.isOverflowMenuShowing()) {
      checkCloseActionMenu(paramPanelFeatureState.menu);
      return;
    } 
    WindowManager windowManager = (WindowManager)this.mContext.getSystemService("window");
    if (windowManager != null && paramPanelFeatureState.isOpen && paramPanelFeatureState.decorView != null) {
      windowManager.removeView((View)paramPanelFeatureState.decorView);
      if (paramBoolean)
        callOnPanelClosed(paramPanelFeatureState.featureId, paramPanelFeatureState, (Menu)null); 
    } 
    paramPanelFeatureState.isPrepared = false;
    paramPanelFeatureState.isHandled = false;
    paramPanelFeatureState.isOpen = false;
    paramPanelFeatureState.shownPanelView = null;
    paramPanelFeatureState.refreshDecorView = true;
    if (this.mPreparedPanel == paramPanelFeatureState) {
      this.mPreparedPanel = null;
      return;
    } 
  }
  
  public View createView(View paramView, String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet) {
    if (this.mAppCompatViewInflater == null)
      this.mAppCompatViewInflater = new AppCompatViewInflater(); 
    boolean bool = false;
    if (IS_PRE_LOLLIPOP) {
      if (paramAttributeSet instanceof XmlPullParser) {
        if (((XmlPullParser)paramAttributeSet).getDepth() > 1) {
          bool = true;
          return this.mAppCompatViewInflater.createView(paramView, paramString, paramContext, paramAttributeSet, bool, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
        } 
        bool = false;
        return this.mAppCompatViewInflater.createView(paramView, paramString, paramContext, paramAttributeSet, bool, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
      } 
    } else {
      return this.mAppCompatViewInflater.createView(paramView, paramString, paramContext, paramAttributeSet, bool, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
    } 
    bool = shouldInheritContext((ViewParent)paramView);
    return this.mAppCompatViewInflater.createView(paramView, paramString, paramContext, paramAttributeSet, bool, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
  }
  
  void dismissPopups() {
    if (this.mDecorContentParent != null)
      this.mDecorContentParent.dismissPopups(); 
    if (this.mActionModePopup != null) {
      this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
      if (this.mActionModePopup.isShowing())
        try {
          this.mActionModePopup.dismiss();
        } catch (IllegalArgumentException illegalArgumentException) {} 
      this.mActionModePopup = null;
    } 
    endOnGoingFadeAnimation();
    PanelFeatureState panelFeatureState = getPanelState(0, false);
    if (panelFeatureState != null && panelFeatureState.menu != null)
      panelFeatureState.menu.close(); 
  }
  
  boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    boolean bool;
    if (paramKeyEvent.getKeyCode() == 82 && this.mOriginalWindowCallback.dispatchKeyEvent(paramKeyEvent))
      return true; 
    int i = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool ? onKeyDown(i, paramKeyEvent) : onKeyUp(i, paramKeyEvent);
  }
  
  void doInvalidatePanelMenu(int paramInt) {
    PanelFeatureState panelFeatureState = getPanelState(paramInt, true);
    if (panelFeatureState.menu != null) {
      Bundle bundle = new Bundle();
      panelFeatureState.menu.saveActionViewStates(bundle);
      if (bundle.size() > 0)
        panelFeatureState.frozenActionViewState = bundle; 
      panelFeatureState.menu.stopDispatchingItemsChanged();
      panelFeatureState.menu.clear();
    } 
    panelFeatureState.refreshMenuContent = true;
    panelFeatureState.refreshDecorView = true;
    if ((paramInt == 108 || paramInt == 0) && this.mDecorContentParent != null) {
      panelFeatureState = getPanelState(0, false);
      if (panelFeatureState != null) {
        panelFeatureState.isPrepared = false;
        preparePanel(panelFeatureState, (KeyEvent)null);
      } 
    } 
  }
  
  void endOnGoingFadeAnimation() {
    if (this.mFadeAnim != null)
      this.mFadeAnim.cancel(); 
  }
  
  PanelFeatureState findMenuPanel(Menu paramMenu) {
    byte b;
    PanelFeatureState[] arrayOfPanelFeatureState = this.mPanels;
    if (arrayOfPanelFeatureState != null) {
      b = arrayOfPanelFeatureState.length;
    } else {
      b = 0;
    } 
    for (int i = 0; i < b; i++) {
      PanelFeatureState panelFeatureState = arrayOfPanelFeatureState[i];
      if (panelFeatureState != null && panelFeatureState.menu == paramMenu)
        return panelFeatureState; 
    } 
    return null;
  }
  
  @Nullable
  public View findViewById(@IdRes int paramInt) {
    ensureSubDecor();
    return this.mWindow.findViewById(paramInt);
  }
  
  protected PanelFeatureState getPanelState(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mPanels : [Landroid/support/v7/app/AppCompatDelegateImplV9$PanelFeatureState;
    //   4: astore #4
    //   6: aload #4
    //   8: ifnull -> 21
    //   11: aload #4
    //   13: astore_3
    //   14: aload #4
    //   16: arraylength
    //   17: iload_1
    //   18: if_icmpgt -> 55
    //   21: iload_1
    //   22: iconst_1
    //   23: iadd
    //   24: anewarray android/support/v7/app/AppCompatDelegateImplV9$PanelFeatureState
    //   27: astore #5
    //   29: aload #4
    //   31: ifnull -> 46
    //   34: aload #4
    //   36: iconst_0
    //   37: aload #5
    //   39: iconst_0
    //   40: aload #4
    //   42: arraylength
    //   43: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   46: aload #5
    //   48: astore_3
    //   49: aload_0
    //   50: aload #5
    //   52: putfield mPanels : [Landroid/support/v7/app/AppCompatDelegateImplV9$PanelFeatureState;
    //   55: aload_3
    //   56: iload_1
    //   57: aaload
    //   58: astore #5
    //   60: aload #5
    //   62: astore #4
    //   64: aload #5
    //   66: ifnonnull -> 84
    //   69: new android/support/v7/app/AppCompatDelegateImplV9$PanelFeatureState
    //   72: dup
    //   73: iload_1
    //   74: invokespecial <init> : (I)V
    //   77: astore #4
    //   79: aload_3
    //   80: iload_1
    //   81: aload #4
    //   83: aastore
    //   84: aload #4
    //   86: areturn
  }
  
  ViewGroup getSubDecor() {
    return this.mSubDecor;
  }
  
  public boolean hasWindowFeature(int paramInt) {
    switch (sanitizeWindowFeatureId(paramInt)) {
      default:
        return false;
      case 108:
        return this.mHasActionBar;
      case 109:
        return this.mOverlayActionBar;
      case 10:
        return this.mOverlayActionMode;
      case 2:
        return this.mFeatureProgress;
      case 5:
        return this.mFeatureIndeterminateProgress;
      case 1:
        break;
    } 
    return this.mWindowNoTitle;
  }
  
  public void initWindowDecorActionBar() {
    ensureSubDecor();
    if (this.mHasActionBar && this.mActionBar == null) {
      if (this.mOriginalWindowCallback instanceof Activity) {
        this.mActionBar = new WindowDecorActionBar((Activity)this.mOriginalWindowCallback, this.mOverlayActionBar);
      } else if (this.mOriginalWindowCallback instanceof Dialog) {
        this.mActionBar = new WindowDecorActionBar((Dialog)this.mOriginalWindowCallback);
      } 
      if (this.mActionBar != null) {
        this.mActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
        return;
      } 
    } 
  }
  
  public void installViewFactory() {
    LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
    if (layoutInflater.getFactory() == null) {
      LayoutInflaterCompat.setFactory(layoutInflater, this);
      return;
    } 
    if (!(LayoutInflaterCompat.getFactory(layoutInflater) instanceof AppCompatDelegateImplV9)) {
      Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
      return;
    } 
  }
  
  public void invalidateOptionsMenu() {
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null && actionBar.invalidateOptionsMenu())
      return; 
    invalidatePanelMenu(0);
  }
  
  boolean onBackPressed() {
    if (this.mActionMode != null) {
      this.mActionMode.finish();
      return true;
    } 
    ActionBar actionBar = getSupportActionBar();
    return !(actionBar == null || !actionBar.collapseActionView());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    if (this.mHasActionBar && this.mSubDecorInstalled) {
      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null)
        actionBar.onConfigurationChanged(paramConfiguration); 
    } 
    AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
    applyDayNight();
  }
  
  public void onCreate(Bundle paramBundle) {
    ActionBar actionBar;
    if (this.mOriginalWindowCallback instanceof Activity && NavUtils.getParentActivityName((Activity)this.mOriginalWindowCallback) != null) {
      actionBar = peekSupportActionBar();
      if (actionBar == null) {
        this.mEnableDefaultActionBarUp = true;
        return;
      } 
    } else {
      return;
    } 
    actionBar.setDefaultDisplayHomeAsUpEnabled(true);
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    View view = callActivityOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
    return (view != null) ? view : createView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public void onDestroy() {
    if (this.mInvalidatePanelMenuPosted)
      this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable); 
    super.onDestroy();
    if (this.mActionBar != null)
      this.mActionBar.onDestroy(); 
  }
  
  boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    boolean bool = true;
    switch (paramInt) {
      default:
        if (Build.VERSION.SDK_INT < 11)
          onKeyShortcut(paramInt, paramKeyEvent); 
        return false;
      case 82:
        onKeyDownPanel(0, paramKeyEvent);
        return true;
      case 4:
        break;
    } 
    if ((paramKeyEvent.getFlags() & 0x80) == 0)
      bool = false; 
    this.mLongPressBackDown = bool;
  }
  
  boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent) {
    ActionBar actionBar = getSupportActionBar();
    if (actionBar == null || !actionBar.onKeyShortcut(paramInt, paramKeyEvent)) {
      if (this.mPreparedPanel != null && performPanelShortcut(this.mPreparedPanel, paramKeyEvent.getKeyCode(), paramKeyEvent, 1)) {
        if (this.mPreparedPanel != null) {
          this.mPreparedPanel.isHandled = true;
          return true;
        } 
        return true;
      } 
      if (this.mPreparedPanel == null) {
        PanelFeatureState panelFeatureState = getPanelState(0, true);
        preparePanel(panelFeatureState, paramKeyEvent);
        boolean bool = performPanelShortcut(panelFeatureState, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
        panelFeatureState.isPrepared = false;
        return !!bool;
      } 
      return false;
    } 
    return true;
  }
  
  boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    null = true;
    switch (paramInt) {
      default:
        return false;
      case 82:
        onKeyUpPanel(0, paramKeyEvent);
        return true;
      case 4:
        break;
    } 
    boolean bool = this.mLongPressBackDown;
    this.mLongPressBackDown = false;
    PanelFeatureState panelFeatureState = getPanelState(0, false);
    if (panelFeatureState != null && panelFeatureState.isOpen) {
      if (!bool) {
        closePanel(panelFeatureState, true);
        return true;
      } 
      return SYNTHETIC_LOCAL_VARIABLE_3;
    } 
    if (onBackPressed())
      return true; 
  }
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    Window.Callback callback = getWindowCallback();
    if (callback != null && !isDestroyed()) {
      PanelFeatureState panelFeatureState = findMenuPanel((Menu)paramMenuBuilder.getRootMenu());
      if (panelFeatureState != null)
        return callback.onMenuItemSelected(panelFeatureState.featureId, paramMenuItem); 
    } 
    return false;
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder) {
    reopenMenu(paramMenuBuilder, true);
  }
  
  boolean onMenuOpened(int paramInt, Menu paramMenu) {
    if (paramInt == 108) {
      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null)
        actionBar.dispatchMenuVisibilityChanged(true); 
      return true;
    } 
    return false;
  }
  
  void onPanelClosed(int paramInt, Menu paramMenu) {
    if (paramInt == 108) {
      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null)
        actionBar.dispatchMenuVisibilityChanged(false); 
      return;
    } 
    if (paramInt == 0) {
      PanelFeatureState panelFeatureState = getPanelState(paramInt, true);
      if (panelFeatureState.isOpen) {
        closePanel(panelFeatureState, false);
        return;
      } 
    } 
  }
  
  public void onPostCreate(Bundle paramBundle) {
    ensureSubDecor();
  }
  
  public void onPostResume() {
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null)
      actionBar.setShowHideAnimationEnabled(true); 
  }
  
  public void onStop() {
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null)
      actionBar.setShowHideAnimationEnabled(false); 
  }
  
  void onSubDecorInstalled(ViewGroup paramViewGroup) {}
  
  void onTitleChanged(CharSequence paramCharSequence) {
    if (this.mDecorContentParent != null) {
      this.mDecorContentParent.setWindowTitle(paramCharSequence);
      return;
    } 
    if (peekSupportActionBar() != null) {
      peekSupportActionBar().setWindowTitle(paramCharSequence);
      return;
    } 
    if (this.mTitleView != null) {
      this.mTitleView.setText(paramCharSequence);
      return;
    } 
  }
  
  public boolean requestWindowFeature(int paramInt) {
    paramInt = sanitizeWindowFeatureId(paramInt);
    if (this.mWindowNoTitle && paramInt == 108)
      return false; 
    if (this.mHasActionBar && paramInt == 1)
      this.mHasActionBar = false; 
    switch (paramInt) {
      default:
        return this.mWindow.requestFeature(paramInt);
      case 108:
        throwFeatureRequestIfSubDecorInstalled();
        this.mHasActionBar = true;
        return true;
      case 109:
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
      case 10:
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionMode = true;
        return true;
      case 2:
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureProgress = true;
        return true;
      case 5:
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureIndeterminateProgress = true;
        return true;
      case 1:
        break;
    } 
    throwFeatureRequestIfSubDecorInstalled();
    this.mWindowNoTitle = true;
    return true;
  }
  
  public void setContentView(int paramInt) {
    ensureSubDecor();
    ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    viewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, viewGroup);
    this.mOriginalWindowCallback.onContentChanged();
  }
  
  public void setContentView(View paramView) {
    ensureSubDecor();
    ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    viewGroup.removeAllViews();
    viewGroup.addView(paramView);
    this.mOriginalWindowCallback.onContentChanged();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    ensureSubDecor();
    ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    viewGroup.removeAllViews();
    viewGroup.addView(paramView, paramLayoutParams);
    this.mOriginalWindowCallback.onContentChanged();
  }
  
  public void setSupportActionBar(Toolbar paramToolbar) {
    if (!(this.mOriginalWindowCallback instanceof Activity))
      return; 
    ActionBar actionBar = getSupportActionBar();
    if (actionBar instanceof WindowDecorActionBar)
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead."); 
    this.mMenuInflater = null;
    if (actionBar != null)
      actionBar.onDestroy(); 
    if (paramToolbar != null) {
      ToolbarActionBar toolbarActionBar = new ToolbarActionBar(paramToolbar, ((Activity)this.mOriginalWindowCallback).getTitle(), this.mAppCompatWindowCallback);
      this.mActionBar = toolbarActionBar;
      this.mWindow.setCallback(toolbarActionBar.getWrappedWindowCallback());
    } else {
      this.mActionBar = null;
      this.mWindow.setCallback(this.mAppCompatWindowCallback);
    } 
    invalidateOptionsMenu();
  }
  
  final boolean shouldAnimateActionModeView() {
    return (this.mSubDecorInstalled && this.mSubDecor != null && ViewCompat.isLaidOut((View)this.mSubDecor));
  }
  
  public ActionMode startSupportActionMode(@NonNull ActionMode.Callback paramCallback) {
    if (paramCallback == null)
      throw new IllegalArgumentException("ActionMode callback can not be null."); 
    if (this.mActionMode != null)
      this.mActionMode.finish(); 
    paramCallback = new ActionModeCallbackWrapperV9(paramCallback);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      this.mActionMode = actionBar.startActionMode(paramCallback);
      if (this.mActionMode != null && this.mAppCompatCallback != null)
        this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode); 
    } 
    if (this.mActionMode == null)
      this.mActionMode = startSupportActionModeFromWindow(paramCallback); 
    return this.mActionMode;
  }
  
  ActionMode startSupportActionModeFromWindow(@NonNull ActionMode.Callback paramCallback) {
    ActionMode.Callback callback1;
    endOnGoingFadeAnimation();
    if (this.mActionMode != null)
      this.mActionMode.finish(); 
    ActionMode.Callback callback2 = paramCallback;
    if (!(paramCallback instanceof ActionModeCallbackWrapperV9))
      callback2 = new ActionModeCallbackWrapperV9(paramCallback); 
    ActionMode.Callback callback3 = null;
    paramCallback = callback3;
    if (this.mAppCompatCallback != null) {
      paramCallback = callback3;
      if (!isDestroyed())
        try {
          ActionMode actionMode = this.mAppCompatCallback.onWindowStartingSupportActionMode(callback2);
        } catch (AbstractMethodError abstractMethodError) {
          callback1 = callback3;
        }  
    } 
    if (callback1 != null) {
      this.mActionMode = (ActionMode)callback1;
    } else {
      if (this.mActionModeView == null)
        if (this.mIsFloating) {
          Context context;
          TypedValue typedValue = new TypedValue();
          Resources.Theme theme = this.mContext.getTheme();
          theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
          if (typedValue.resourceId != 0) {
            Resources.Theme theme1 = this.mContext.getResources().newTheme();
            theme1.setTo(theme);
            theme1.applyStyle(typedValue.resourceId, true);
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.mContext, 0);
            contextThemeWrapper.getTheme().setTo(theme1);
          } else {
            context = this.mContext;
          } 
          this.mActionModeView = new ActionBarContextView(context);
          this.mActionModePopup = new PopupWindow(context, null, R.attr.actionModePopupWindowStyle);
          PopupWindowCompat.setWindowLayoutType(this.mActionModePopup, 2);
          this.mActionModePopup.setContentView((View)this.mActionModeView);
          this.mActionModePopup.setWidth(-1);
          context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
          int i = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
          this.mActionModeView.setContentHeight(i);
          this.mActionModePopup.setHeight(-2);
          this.mShowActionModePopup = new Runnable() {
              public void run() {
                AppCompatDelegateImplV9.this.mActionModePopup.showAtLocation((View)AppCompatDelegateImplV9.this.mActionModeView, 55, 0, 0);
                AppCompatDelegateImplV9.this.endOnGoingFadeAnimation();
                if (AppCompatDelegateImplV9.this.shouldAnimateActionModeView()) {
                  ViewCompat.setAlpha((View)AppCompatDelegateImplV9.this.mActionModeView, 0.0F);
                  AppCompatDelegateImplV9.this.mFadeAnim = ViewCompat.animate((View)AppCompatDelegateImplV9.this.mActionModeView).alpha(1.0F);
                  AppCompatDelegateImplV9.this.mFadeAnim.setListener((ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerAdapter() {
                        public void onAnimationEnd(View param2View) {
                          ViewCompat.setAlpha((View)AppCompatDelegateImplV9.this.mActionModeView, 1.0F);
                          AppCompatDelegateImplV9.this.mFadeAnim.setListener(null);
                          AppCompatDelegateImplV9.this.mFadeAnim = null;
                        }
                        
                        public void onAnimationStart(View param2View) {
                          AppCompatDelegateImplV9.this.mActionModeView.setVisibility(0);
                        }
                      });
                  return;
                } 
                ViewCompat.setAlpha((View)AppCompatDelegateImplV9.this.mActionModeView, 1.0F);
                AppCompatDelegateImplV9.this.mActionModeView.setVisibility(0);
              }
            };
        } else {
          ViewStubCompat viewStubCompat = (ViewStubCompat)this.mSubDecor.findViewById(R.id.action_mode_bar_stub);
          if (viewStubCompat != null) {
            viewStubCompat.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
            this.mActionModeView = (ActionBarContextView)viewStubCompat.inflate();
          } 
        }  
      if (this.mActionModeView != null) {
        boolean bool;
        endOnGoingFadeAnimation();
        this.mActionModeView.killMode();
        Context context = this.mActionModeView.getContext();
        ActionBarContextView actionBarContextView = this.mActionModeView;
        if (this.mActionModePopup == null) {
          bool = true;
        } else {
          bool = false;
        } 
        StandaloneActionMode standaloneActionMode = new StandaloneActionMode(context, actionBarContextView, callback2, bool);
        if (callback2.onCreateActionMode((ActionMode)standaloneActionMode, standaloneActionMode.getMenu())) {
          standaloneActionMode.invalidate();
          this.mActionModeView.initForMode((ActionMode)standaloneActionMode);
          this.mActionMode = (ActionMode)standaloneActionMode;
          if (shouldAnimateActionModeView()) {
            ViewCompat.setAlpha((View)this.mActionModeView, 0.0F);
            this.mFadeAnim = ViewCompat.animate((View)this.mActionModeView).alpha(1.0F);
            this.mFadeAnim.setListener((ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerAdapter() {
                  public void onAnimationEnd(View param1View) {
                    ViewCompat.setAlpha((View)AppCompatDelegateImplV9.this.mActionModeView, 1.0F);
                    AppCompatDelegateImplV9.this.mFadeAnim.setListener(null);
                    AppCompatDelegateImplV9.this.mFadeAnim = null;
                  }
                  
                  public void onAnimationStart(View param1View) {
                    AppCompatDelegateImplV9.this.mActionModeView.setVisibility(0);
                    AppCompatDelegateImplV9.this.mActionModeView.sendAccessibilityEvent(32);
                    if (AppCompatDelegateImplV9.this.mActionModeView.getParent() instanceof View)
                      ViewCompat.requestApplyInsets((View)AppCompatDelegateImplV9.this.mActionModeView.getParent()); 
                  }
                });
          } else {
            ViewCompat.setAlpha((View)this.mActionModeView, 1.0F);
            this.mActionModeView.setVisibility(0);
            this.mActionModeView.sendAccessibilityEvent(32);
            if (this.mActionModeView.getParent() instanceof View)
              ViewCompat.requestApplyInsets((View)this.mActionModeView.getParent()); 
          } 
          if (this.mActionModePopup != null)
            this.mWindow.getDecorView().post(this.mShowActionModePopup); 
        } else {
          this.mActionMode = null;
        } 
      } 
    } 
    if (this.mActionMode != null && this.mAppCompatCallback != null)
      this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode); 
    return this.mActionMode;
  }
  
  int updateStatusGuard(int paramInt) {
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = false;
    int k = j;
    int i = paramInt;
    if (this.mActionModeView != null) {
      k = j;
      i = paramInt;
      if (this.mActionModeView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
        boolean bool;
        int m;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.mActionModeView.getLayoutParams();
        j = 0;
        i = 0;
        if (this.mActionModeView.isShown()) {
          if (this.mTempRect1 == null) {
            this.mTempRect1 = new Rect();
            this.mTempRect2 = new Rect();
          } 
          Rect rect1 = this.mTempRect1;
          Rect rect2 = this.mTempRect2;
          rect1.set(0, paramInt, 0, 0);
          ViewUtils.computeFitSystemWindows((View)this.mSubDecor, rect1, rect2);
          if (rect2.top == 0) {
            j = paramInt;
          } else {
            j = 0;
          } 
          if (marginLayoutParams.topMargin != j) {
            j = 1;
            marginLayoutParams.topMargin = paramInt;
            if (this.mStatusGuard == null) {
              this.mStatusGuard = new View(this.mContext);
              this.mStatusGuard.setBackgroundColor(this.mContext.getResources().getColor(R.color.abc_input_method_navigation_guard));
              this.mSubDecor.addView(this.mStatusGuard, -1, new ViewGroup.LayoutParams(-1, paramInt));
              i = j;
            } else {
              ViewGroup.LayoutParams layoutParams = this.mStatusGuard.getLayoutParams();
              i = j;
              if (layoutParams.height != paramInt) {
                layoutParams.height = paramInt;
                this.mStatusGuard.setLayoutParams(layoutParams);
                i = j;
              } 
            } 
          } 
          if (this.mStatusGuard != null) {
            k = 1;
          } else {
            k = 0;
          } 
          j = i;
          bool = k;
          m = paramInt;
          if (!this.mOverlayActionMode) {
            j = i;
            bool = k;
            m = paramInt;
            if (k != 0) {
              m = 0;
              bool = k;
              j = i;
            } 
          } 
        } else {
          bool = bool2;
          m = paramInt;
          if (marginLayoutParams.topMargin != 0) {
            j = 1;
            marginLayoutParams.topMargin = 0;
            bool = bool2;
            m = paramInt;
          } 
        } 
        k = bool;
        i = m;
        if (j != 0) {
          this.mActionModeView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
          i = m;
          k = bool;
        } 
      } 
    } 
    if (this.mStatusGuard != null) {
      View view = this.mStatusGuard;
      if (k != 0) {
        paramInt = bool1;
      } else {
        paramInt = 8;
      } 
      view.setVisibility(paramInt);
    } 
    return i;
  }
  
  private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {
      AppCompatDelegateImplV9.this.checkCloseActionMenu(param1MenuBuilder);
    }
    
    public boolean onOpenSubMenu(MenuBuilder param1MenuBuilder) {
      Window.Callback callback = AppCompatDelegateImplV9.this.getWindowCallback();
      if (callback != null)
        callback.onMenuOpened(108, (Menu)param1MenuBuilder); 
      return true;
    }
  }
  
  class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
    private ActionMode.Callback mWrapped;
    
    public ActionModeCallbackWrapperV9(ActionMode.Callback param1Callback) {
      this.mWrapped = param1Callback;
    }
    
    public boolean onActionItemClicked(ActionMode param1ActionMode, MenuItem param1MenuItem) {
      return this.mWrapped.onActionItemClicked(param1ActionMode, param1MenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode param1ActionMode, Menu param1Menu) {
      return this.mWrapped.onCreateActionMode(param1ActionMode, param1Menu);
    }
    
    public void onDestroyActionMode(ActionMode param1ActionMode) {
      this.mWrapped.onDestroyActionMode(param1ActionMode);
      if (AppCompatDelegateImplV9.this.mActionModePopup != null)
        AppCompatDelegateImplV9.this.mWindow.getDecorView().removeCallbacks(AppCompatDelegateImplV9.this.mShowActionModePopup); 
      if (AppCompatDelegateImplV9.this.mActionModeView != null) {
        AppCompatDelegateImplV9.this.endOnGoingFadeAnimation();
        AppCompatDelegateImplV9.this.mFadeAnim = ViewCompat.animate((View)AppCompatDelegateImplV9.this.mActionModeView).alpha(0.0F);
        AppCompatDelegateImplV9.this.mFadeAnim.setListener((ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerAdapter() {
              public void onAnimationEnd(View param2View) {
                AppCompatDelegateImplV9.this.mActionModeView.setVisibility(8);
                if (AppCompatDelegateImplV9.this.mActionModePopup != null) {
                  AppCompatDelegateImplV9.this.mActionModePopup.dismiss();
                } else if (AppCompatDelegateImplV9.this.mActionModeView.getParent() instanceof View) {
                  ViewCompat.requestApplyInsets((View)AppCompatDelegateImplV9.this.mActionModeView.getParent());
                } 
                AppCompatDelegateImplV9.this.mActionModeView.removeAllViews();
                AppCompatDelegateImplV9.this.mFadeAnim.setListener(null);
                AppCompatDelegateImplV9.this.mFadeAnim = null;
              }
            });
      } 
      if (AppCompatDelegateImplV9.this.mAppCompatCallback != null)
        AppCompatDelegateImplV9.this.mAppCompatCallback.onSupportActionModeFinished(AppCompatDelegateImplV9.this.mActionMode); 
      AppCompatDelegateImplV9.this.mActionMode = null;
    }
    
    public boolean onPrepareActionMode(ActionMode param1ActionMode, Menu param1Menu) {
      return this.mWrapped.onPrepareActionMode(param1ActionMode, param1Menu);
    }
  }
  
  class null extends ViewPropertyAnimatorListenerAdapter {
    public void onAnimationEnd(View param1View) {
      AppCompatDelegateImplV9.this.mActionModeView.setVisibility(8);
      if (AppCompatDelegateImplV9.this.mActionModePopup != null) {
        AppCompatDelegateImplV9.this.mActionModePopup.dismiss();
      } else if (AppCompatDelegateImplV9.this.mActionModeView.getParent() instanceof View) {
        ViewCompat.requestApplyInsets((View)AppCompatDelegateImplV9.this.mActionModeView.getParent());
      } 
      AppCompatDelegateImplV9.this.mActionModeView.removeAllViews();
      AppCompatDelegateImplV9.this.mFadeAnim.setListener(null);
      AppCompatDelegateImplV9.this.mFadeAnim = null;
    }
  }
  
  private class ListMenuDecorView extends ContentFrameLayout {
    public ListMenuDecorView(Context param1Context) {
      super(param1Context);
    }
    
    private boolean isOutOfBounds(int param1Int1, int param1Int2) {
      return (param1Int1 < -5 || param1Int2 < -5 || param1Int1 > getWidth() + 5 || param1Int2 > getHeight() + 5);
    }
    
    public boolean dispatchKeyEvent(KeyEvent param1KeyEvent) {
      return (AppCompatDelegateImplV9.this.dispatchKeyEvent(param1KeyEvent) || super.dispatchKeyEvent(param1KeyEvent));
    }
    
    public boolean onInterceptTouchEvent(MotionEvent param1MotionEvent) {
      if (param1MotionEvent.getAction() == 0 && isOutOfBounds((int)param1MotionEvent.getX(), (int)param1MotionEvent.getY())) {
        AppCompatDelegateImplV9.this.closePanel(0);
        return true;
      } 
      return super.onInterceptTouchEvent(param1MotionEvent);
    }
    
    public void setBackgroundResource(int param1Int) {
      setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), param1Int));
    }
  }
  
  protected static final class PanelFeatureState {
    int background;
    
    View createdPanelView;
    
    ViewGroup decorView;
    
    int featureId;
    
    Bundle frozenActionViewState;
    
    Bundle frozenMenuState;
    
    int gravity;
    
    boolean isHandled;
    
    boolean isOpen;
    
    boolean isPrepared;
    
    ListMenuPresenter listMenuPresenter;
    
    Context listPresenterContext;
    
    MenuBuilder menu;
    
    public boolean qwertyMode;
    
    boolean refreshDecorView;
    
    boolean refreshMenuContent;
    
    View shownPanelView;
    
    boolean wasLastOpen;
    
    int windowAnimations;
    
    int x;
    
    int y;
    
    PanelFeatureState(int param1Int) {
      this.featureId = param1Int;
      this.refreshDecorView = false;
    }
    
    void applyFrozenState() {
      if (this.menu != null && this.frozenMenuState != null) {
        this.menu.restorePresenterStates(this.frozenMenuState);
        this.frozenMenuState = null;
      } 
    }
    
    public void clearMenuPresenters() {
      if (this.menu != null)
        this.menu.removeMenuPresenter((MenuPresenter)this.listMenuPresenter); 
      this.listMenuPresenter = null;
    }
    
    MenuView getListMenuView(MenuPresenter.Callback param1Callback) {
      if (this.menu == null)
        return null; 
      if (this.listMenuPresenter == null) {
        this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
        this.listMenuPresenter.setCallback(param1Callback);
        this.menu.addMenuPresenter((MenuPresenter)this.listMenuPresenter);
      } 
      return this.listMenuPresenter.getMenuView(this.decorView);
    }
    
    public boolean hasPanelItems() {
      boolean bool2 = true;
      if (this.shownPanelView == null)
        return false; 
      boolean bool1 = bool2;
      if (this.createdPanelView == null) {
        bool1 = bool2;
        if (this.listMenuPresenter.getAdapter().getCount() <= 0)
          return false; 
      } 
      return bool1;
    }
    
    void onRestoreInstanceState(Parcelable param1Parcelable) {
      param1Parcelable = param1Parcelable;
      this.featureId = ((SavedState)param1Parcelable).featureId;
      this.wasLastOpen = ((SavedState)param1Parcelable).isOpen;
      this.frozenMenuState = ((SavedState)param1Parcelable).menuState;
      this.shownPanelView = null;
      this.decorView = null;
    }
    
    Parcelable onSaveInstanceState() {
      SavedState savedState = new SavedState();
      savedState.featureId = this.featureId;
      savedState.isOpen = this.isOpen;
      if (this.menu != null) {
        savedState.menuState = new Bundle();
        this.menu.savePresenterStates(savedState.menuState);
      } 
      return savedState;
    }
    
    void setMenu(MenuBuilder param1MenuBuilder) {
      if (param1MenuBuilder != this.menu) {
        if (this.menu != null)
          this.menu.removeMenuPresenter((MenuPresenter)this.listMenuPresenter); 
        this.menu = param1MenuBuilder;
        if (param1MenuBuilder != null && this.listMenuPresenter != null) {
          param1MenuBuilder.addMenuPresenter((MenuPresenter)this.listMenuPresenter);
          return;
        } 
      } 
    }
    
    void setStyle(Context param1Context) {
      TypedValue typedValue = new TypedValue();
      Resources.Theme theme = param1Context.getResources().newTheme();
      theme.setTo(param1Context.getTheme());
      theme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
      if (typedValue.resourceId != 0)
        theme.applyStyle(typedValue.resourceId, true); 
      theme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
      if (typedValue.resourceId != 0) {
        theme.applyStyle(typedValue.resourceId, true);
      } else {
        theme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
      } 
      ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(param1Context, 0);
      contextThemeWrapper.getTheme().setTo(theme);
      this.listPresenterContext = (Context)contextThemeWrapper;
      TypedArray typedArray = contextThemeWrapper.obtainStyledAttributes(R.styleable.AppCompatTheme);
      this.background = typedArray.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
      this.windowAnimations = typedArray.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
      typedArray.recycle();
    }
    
    private static class SavedState implements Parcelable {
      public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
            public AppCompatDelegateImplV9.PanelFeatureState.SavedState createFromParcel(Parcel param3Parcel, ClassLoader param3ClassLoader) {
              return AppCompatDelegateImplV9.PanelFeatureState.SavedState.readFromParcel(param3Parcel, param3ClassLoader);
            }
            
            public AppCompatDelegateImplV9.PanelFeatureState.SavedState[] newArray(int param3Int) {
              return new AppCompatDelegateImplV9.PanelFeatureState.SavedState[param3Int];
            }
          });
      
      int featureId;
      
      boolean isOpen;
      
      Bundle menuState;
      
      static SavedState readFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        boolean bool = true;
        SavedState savedState = new SavedState();
        savedState.featureId = param2Parcel.readInt();
        if (param2Parcel.readInt() != 1)
          bool = false; 
        savedState.isOpen = bool;
        if (savedState.isOpen)
          savedState.menuState = param2Parcel.readBundle(param2ClassLoader); 
        return savedState;
      }
      
      public int describeContents() {
        return 0;
      }
      
      public void writeToParcel(Parcel param2Parcel, int param2Int) {
        param2Parcel.writeInt(this.featureId);
        if (this.isOpen) {
          param2Int = 1;
        } else {
          param2Int = 0;
        } 
        param2Parcel.writeInt(param2Int);
        if (this.isOpen)
          param2Parcel.writeBundle(this.menuState); 
      }
    }
    
    static final class null implements ParcelableCompatCreatorCallbacks<SavedState> {
      public AppCompatDelegateImplV9.PanelFeatureState.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        return AppCompatDelegateImplV9.PanelFeatureState.SavedState.readFromParcel(param2Parcel, param2ClassLoader);
      }
      
      public AppCompatDelegateImplV9.PanelFeatureState.SavedState[] newArray(int param2Int) {
        return new AppCompatDelegateImplV9.PanelFeatureState.SavedState[param2Int];
      }
    }
  }
  
  private static class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
          public AppCompatDelegateImplV9.PanelFeatureState.SavedState createFromParcel(Parcel param3Parcel, ClassLoader param3ClassLoader) {
            return AppCompatDelegateImplV9.PanelFeatureState.SavedState.readFromParcel(param3Parcel, param3ClassLoader);
          }
          
          public AppCompatDelegateImplV9.PanelFeatureState.SavedState[] newArray(int param3Int) {
            return new AppCompatDelegateImplV9.PanelFeatureState.SavedState[param3Int];
          }
        });
    
    int featureId;
    
    boolean isOpen;
    
    Bundle menuState;
    
    static SavedState readFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      boolean bool = true;
      SavedState savedState = new SavedState();
      savedState.featureId = param1Parcel.readInt();
      if (param1Parcel.readInt() != 1)
        bool = false; 
      savedState.isOpen = bool;
      if (savedState.isOpen)
        savedState.menuState = param1Parcel.readBundle(param1ClassLoader); 
      return savedState;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.featureId);
      if (this.isOpen) {
        param1Int = 1;
      } else {
        param1Int = 0;
      } 
      param1Parcel.writeInt(param1Int);
      if (this.isOpen)
        param1Parcel.writeBundle(this.menuState); 
    }
  }
  
  static final class null implements ParcelableCompatCreatorCallbacks<PanelFeatureState.SavedState> {
    public AppCompatDelegateImplV9.PanelFeatureState.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return AppCompatDelegateImplV9.PanelFeatureState.SavedState.readFromParcel(param1Parcel, param1ClassLoader);
    }
    
    public AppCompatDelegateImplV9.PanelFeatureState.SavedState[] newArray(int param1Int) {
      return new AppCompatDelegateImplV9.PanelFeatureState.SavedState[param1Int];
    }
  }
  
  private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {
      boolean bool;
      MenuBuilder menuBuilder = param1MenuBuilder.getRootMenu();
      if (menuBuilder != param1MenuBuilder) {
        bool = true;
      } else {
        bool = false;
      } 
      AppCompatDelegateImplV9 appCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
      if (bool)
        param1MenuBuilder = menuBuilder; 
      AppCompatDelegateImplV9.PanelFeatureState panelFeatureState = appCompatDelegateImplV9.findMenuPanel((Menu)param1MenuBuilder);
      if (panelFeatureState != null) {
        if (bool) {
          AppCompatDelegateImplV9.this.callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, (Menu)menuBuilder);
          AppCompatDelegateImplV9.this.closePanel(panelFeatureState, true);
          return;
        } 
      } else {
        return;
      } 
      AppCompatDelegateImplV9.this.closePanel(panelFeatureState, param1Boolean);
    }
    
    public boolean onOpenSubMenu(MenuBuilder param1MenuBuilder) {
      if (param1MenuBuilder == null && AppCompatDelegateImplV9.this.mHasActionBar) {
        Window.Callback callback = AppCompatDelegateImplV9.this.getWindowCallback();
        if (callback != null && !AppCompatDelegateImplV9.this.isDestroyed())
          callback.onMenuOpened(108, (Menu)param1MenuBuilder); 
      } 
      return true;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\app\AppCompatDelegateImplV9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */