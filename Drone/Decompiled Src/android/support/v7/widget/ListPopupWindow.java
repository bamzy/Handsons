package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
  private static final boolean DEBUG = false;
  
  static final int EXPAND_LIST_TIMEOUT = 250;
  
  public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
  
  public static final int INPUT_METHOD_NEEDED = 1;
  
  public static final int INPUT_METHOD_NOT_NEEDED = 2;
  
  public static final int MATCH_PARENT = -1;
  
  public static final int POSITION_PROMPT_ABOVE = 0;
  
  public static final int POSITION_PROMPT_BELOW = 1;
  
  private static final String TAG = "ListPopupWindow";
  
  public static final int WRAP_CONTENT = -2;
  
  private static Method sClipToWindowEnabledMethod;
  
  private static Method sGetMaxAvailableHeightMethod;
  
  private static Method sSetEpicenterBoundsMethod;
  
  private ListAdapter mAdapter;
  
  private Context mContext;
  
  private boolean mDropDownAlwaysVisible = false;
  
  private View mDropDownAnchorView;
  
  private int mDropDownGravity = 0;
  
  private int mDropDownHeight = -2;
  
  private int mDropDownHorizontalOffset;
  
  DropDownListView mDropDownList;
  
  private Drawable mDropDownListHighlight;
  
  private int mDropDownVerticalOffset;
  
  private boolean mDropDownVerticalOffsetSet;
  
  private int mDropDownWidth = -2;
  
  private int mDropDownWindowLayoutType = 1002;
  
  private Rect mEpicenterBounds;
  
  private boolean mForceIgnoreOutsideTouch = false;
  
  final Handler mHandler;
  
  private final ListSelectorHider mHideSelector = new ListSelectorHider();
  
  private boolean mIsAnimatedFromAnchor = true;
  
  private AdapterView.OnItemClickListener mItemClickListener;
  
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  
  int mListItemExpandMaximum = Integer.MAX_VALUE;
  
  private boolean mModal;
  
  private DataSetObserver mObserver;
  
  PopupWindow mPopup;
  
  private int mPromptPosition = 0;
  
  private View mPromptView;
  
  final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable();
  
  private final PopupScrollListener mScrollListener = new PopupScrollListener();
  
  private Runnable mShowDropDownRunnable;
  
  private final Rect mTempRect = new Rect();
  
  private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();
  
  static {
    try {
      sClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { boolean.class });
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
    } 
    try {
      sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, int.class, boolean.class });
      try {
        sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
        return;
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
      } 
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
      try {
        sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
        return;
      } catch (NoSuchMethodException noSuchMethodException1) {
        Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
      } 
    } 
  }
  
  public ListPopupWindow(@NonNull Context paramContext) {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt) {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2) {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper());
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPopupWindow, paramInt1, paramInt2);
    this.mDropDownHorizontalOffset = typedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.mDropDownVerticalOffset = typedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.mDropDownVerticalOffset != 0)
      this.mDropDownVerticalOffsetSet = true; 
    typedArray.recycle();
    if (Build.VERSION.SDK_INT >= 11) {
      this.mPopup = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    } else {
      this.mPopup = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1);
    } 
    this.mPopup.setInputMethodMode(1);
  }
  
  private int buildDropDown() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   8: ifnonnull -> 485
    //   11: aload_0
    //   12: getfield mContext : Landroid/content/Context;
    //   15: astore #9
    //   17: aload_0
    //   18: new android/support/v7/widget/ListPopupWindow$2
    //   21: dup
    //   22: aload_0
    //   23: invokespecial <init> : (Landroid/support/v7/widget/ListPopupWindow;)V
    //   26: putfield mShowDropDownRunnable : Ljava/lang/Runnable;
    //   29: aload_0
    //   30: getfield mModal : Z
    //   33: ifne -> 434
    //   36: iconst_1
    //   37: istore #5
    //   39: aload_0
    //   40: aload_0
    //   41: aload #9
    //   43: iload #5
    //   45: invokevirtual createDropDownListView : (Landroid/content/Context;Z)Landroid/support/v7/widget/DropDownListView;
    //   48: putfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   51: aload_0
    //   52: getfield mDropDownListHighlight : Landroid/graphics/drawable/Drawable;
    //   55: ifnull -> 69
    //   58: aload_0
    //   59: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   62: aload_0
    //   63: getfield mDropDownListHighlight : Landroid/graphics/drawable/Drawable;
    //   66: invokevirtual setSelector : (Landroid/graphics/drawable/Drawable;)V
    //   69: aload_0
    //   70: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   73: aload_0
    //   74: getfield mAdapter : Landroid/widget/ListAdapter;
    //   77: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   80: aload_0
    //   81: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   84: aload_0
    //   85: getfield mItemClickListener : Landroid/widget/AdapterView$OnItemClickListener;
    //   88: invokevirtual setOnItemClickListener : (Landroid/widget/AdapterView$OnItemClickListener;)V
    //   91: aload_0
    //   92: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   95: iconst_1
    //   96: invokevirtual setFocusable : (Z)V
    //   99: aload_0
    //   100: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   103: iconst_1
    //   104: invokevirtual setFocusableInTouchMode : (Z)V
    //   107: aload_0
    //   108: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   111: new android/support/v7/widget/ListPopupWindow$3
    //   114: dup
    //   115: aload_0
    //   116: invokespecial <init> : (Landroid/support/v7/widget/ListPopupWindow;)V
    //   119: invokevirtual setOnItemSelectedListener : (Landroid/widget/AdapterView$OnItemSelectedListener;)V
    //   122: aload_0
    //   123: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   126: aload_0
    //   127: getfield mScrollListener : Landroid/support/v7/widget/ListPopupWindow$PopupScrollListener;
    //   130: invokevirtual setOnScrollListener : (Landroid/widget/AbsListView$OnScrollListener;)V
    //   133: aload_0
    //   134: getfield mItemSelectedListener : Landroid/widget/AdapterView$OnItemSelectedListener;
    //   137: ifnull -> 151
    //   140: aload_0
    //   141: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   144: aload_0
    //   145: getfield mItemSelectedListener : Landroid/widget/AdapterView$OnItemSelectedListener;
    //   148: invokevirtual setOnItemSelectedListener : (Landroid/widget/AdapterView$OnItemSelectedListener;)V
    //   151: aload_0
    //   152: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   155: astore #7
    //   157: aload_0
    //   158: getfield mPromptView : Landroid/view/View;
    //   161: astore #8
    //   163: aload #7
    //   165: astore #6
    //   167: aload #8
    //   169: ifnull -> 312
    //   172: new android/widget/LinearLayout
    //   175: dup
    //   176: aload #9
    //   178: invokespecial <init> : (Landroid/content/Context;)V
    //   181: astore #6
    //   183: aload #6
    //   185: iconst_1
    //   186: invokevirtual setOrientation : (I)V
    //   189: new android/widget/LinearLayout$LayoutParams
    //   192: dup
    //   193: iconst_m1
    //   194: iconst_0
    //   195: fconst_1
    //   196: invokespecial <init> : (IIF)V
    //   199: astore #9
    //   201: aload_0
    //   202: getfield mPromptPosition : I
    //   205: tableswitch default -> 228, 0 -> 459, 1 -> 440
    //   228: ldc 'ListPopupWindow'
    //   230: new java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial <init> : ()V
    //   237: ldc_w 'Invalid hint position '
    //   240: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_0
    //   244: getfield mPromptPosition : I
    //   247: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   250: invokevirtual toString : ()Ljava/lang/String;
    //   253: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   256: pop
    //   257: aload_0
    //   258: getfield mDropDownWidth : I
    //   261: iflt -> 478
    //   264: ldc_w -2147483648
    //   267: istore_1
    //   268: aload_0
    //   269: getfield mDropDownWidth : I
    //   272: istore_2
    //   273: aload #8
    //   275: iload_2
    //   276: iload_1
    //   277: invokestatic makeMeasureSpec : (II)I
    //   280: iconst_0
    //   281: invokevirtual measure : (II)V
    //   284: aload #8
    //   286: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   289: checkcast android/widget/LinearLayout$LayoutParams
    //   292: astore #7
    //   294: aload #8
    //   296: invokevirtual getMeasuredHeight : ()I
    //   299: aload #7
    //   301: getfield topMargin : I
    //   304: iadd
    //   305: aload #7
    //   307: getfield bottomMargin : I
    //   310: iadd
    //   311: istore_1
    //   312: aload_0
    //   313: getfield mPopup : Landroid/widget/PopupWindow;
    //   316: aload #6
    //   318: invokevirtual setContentView : (Landroid/view/View;)V
    //   321: aload_0
    //   322: getfield mPopup : Landroid/widget/PopupWindow;
    //   325: invokevirtual getBackground : ()Landroid/graphics/drawable/Drawable;
    //   328: astore #6
    //   330: aload #6
    //   332: ifnull -> 541
    //   335: aload #6
    //   337: aload_0
    //   338: getfield mTempRect : Landroid/graphics/Rect;
    //   341: invokevirtual getPadding : (Landroid/graphics/Rect;)Z
    //   344: pop
    //   345: aload_0
    //   346: getfield mTempRect : Landroid/graphics/Rect;
    //   349: getfield top : I
    //   352: aload_0
    //   353: getfield mTempRect : Landroid/graphics/Rect;
    //   356: getfield bottom : I
    //   359: iadd
    //   360: istore_2
    //   361: iload_2
    //   362: istore_3
    //   363: aload_0
    //   364: getfield mDropDownVerticalOffsetSet : Z
    //   367: ifne -> 384
    //   370: aload_0
    //   371: aload_0
    //   372: getfield mTempRect : Landroid/graphics/Rect;
    //   375: getfield top : I
    //   378: ineg
    //   379: putfield mDropDownVerticalOffset : I
    //   382: iload_2
    //   383: istore_3
    //   384: aload_0
    //   385: getfield mPopup : Landroid/widget/PopupWindow;
    //   388: invokevirtual getInputMethodMode : ()I
    //   391: iconst_2
    //   392: if_icmpne -> 553
    //   395: iconst_1
    //   396: istore #5
    //   398: aload_0
    //   399: aload_0
    //   400: invokevirtual getAnchorView : ()Landroid/view/View;
    //   403: aload_0
    //   404: getfield mDropDownVerticalOffset : I
    //   407: iload #5
    //   409: invokespecial getMaxAvailableHeight : (Landroid/view/View;IZ)I
    //   412: istore #4
    //   414: aload_0
    //   415: getfield mDropDownAlwaysVisible : Z
    //   418: ifne -> 429
    //   421: aload_0
    //   422: getfield mDropDownHeight : I
    //   425: iconst_m1
    //   426: if_icmpne -> 559
    //   429: iload #4
    //   431: iload_3
    //   432: iadd
    //   433: ireturn
    //   434: iconst_0
    //   435: istore #5
    //   437: goto -> 39
    //   440: aload #6
    //   442: aload #7
    //   444: aload #9
    //   446: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   449: aload #6
    //   451: aload #8
    //   453: invokevirtual addView : (Landroid/view/View;)V
    //   456: goto -> 257
    //   459: aload #6
    //   461: aload #8
    //   463: invokevirtual addView : (Landroid/view/View;)V
    //   466: aload #6
    //   468: aload #7
    //   470: aload #9
    //   472: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   475: goto -> 257
    //   478: iconst_0
    //   479: istore_1
    //   480: iconst_0
    //   481: istore_2
    //   482: goto -> 273
    //   485: aload_0
    //   486: getfield mPopup : Landroid/widget/PopupWindow;
    //   489: invokevirtual getContentView : ()Landroid/view/View;
    //   492: checkcast android/view/ViewGroup
    //   495: astore #6
    //   497: aload_0
    //   498: getfield mPromptView : Landroid/view/View;
    //   501: astore #6
    //   503: iload_2
    //   504: istore_1
    //   505: aload #6
    //   507: ifnull -> 321
    //   510: aload #6
    //   512: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   515: checkcast android/widget/LinearLayout$LayoutParams
    //   518: astore #7
    //   520: aload #6
    //   522: invokevirtual getMeasuredHeight : ()I
    //   525: aload #7
    //   527: getfield topMargin : I
    //   530: iadd
    //   531: aload #7
    //   533: getfield bottomMargin : I
    //   536: iadd
    //   537: istore_1
    //   538: goto -> 321
    //   541: aload_0
    //   542: getfield mTempRect : Landroid/graphics/Rect;
    //   545: invokevirtual setEmpty : ()V
    //   548: iconst_0
    //   549: istore_3
    //   550: goto -> 384
    //   553: iconst_0
    //   554: istore #5
    //   556: goto -> 398
    //   559: aload_0
    //   560: getfield mDropDownWidth : I
    //   563: tableswitch default -> 584, -2 -> 644, -1 -> 683
    //   584: aload_0
    //   585: getfield mDropDownWidth : I
    //   588: ldc_w 1073741824
    //   591: invokestatic makeMeasureSpec : (II)I
    //   594: istore_2
    //   595: aload_0
    //   596: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   599: iload_2
    //   600: iconst_0
    //   601: iconst_m1
    //   602: iload #4
    //   604: iload_1
    //   605: isub
    //   606: iconst_m1
    //   607: invokevirtual measureHeightOfChildrenCompat : (IIIII)I
    //   610: istore #4
    //   612: iload_1
    //   613: istore_2
    //   614: iload #4
    //   616: ifle -> 639
    //   619: iload_1
    //   620: iload_3
    //   621: aload_0
    //   622: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   625: invokevirtual getPaddingTop : ()I
    //   628: aload_0
    //   629: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   632: invokevirtual getPaddingBottom : ()I
    //   635: iadd
    //   636: iadd
    //   637: iadd
    //   638: istore_2
    //   639: iload #4
    //   641: iload_2
    //   642: iadd
    //   643: ireturn
    //   644: aload_0
    //   645: getfield mContext : Landroid/content/Context;
    //   648: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   651: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   654: getfield widthPixels : I
    //   657: aload_0
    //   658: getfield mTempRect : Landroid/graphics/Rect;
    //   661: getfield left : I
    //   664: aload_0
    //   665: getfield mTempRect : Landroid/graphics/Rect;
    //   668: getfield right : I
    //   671: iadd
    //   672: isub
    //   673: ldc_w -2147483648
    //   676: invokestatic makeMeasureSpec : (II)I
    //   679: istore_2
    //   680: goto -> 595
    //   683: aload_0
    //   684: getfield mContext : Landroid/content/Context;
    //   687: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   690: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   693: getfield widthPixels : I
    //   696: aload_0
    //   697: getfield mTempRect : Landroid/graphics/Rect;
    //   700: getfield left : I
    //   703: aload_0
    //   704: getfield mTempRect : Landroid/graphics/Rect;
    //   707: getfield right : I
    //   710: iadd
    //   711: isub
    //   712: ldc_w 1073741824
    //   715: invokestatic makeMeasureSpec : (II)I
    //   718: istore_2
    //   719: goto -> 595
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean) {
    if (sGetMaxAvailableHeightMethod != null)
      try {
        return ((Integer)sGetMaxAvailableHeightMethod.invoke(this.mPopup, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
      } catch (Exception exception) {
        Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
      }  
    return this.mPopup.getMaxAvailableHeight(paramView, paramInt);
  }
  
  private static boolean isConfirmKey(int paramInt) {
    return (paramInt == 66 || paramInt == 23);
  }
  
  private void removePromptView() {
    if (this.mPromptView != null) {
      ViewParent viewParent = this.mPromptView.getParent();
      if (viewParent instanceof ViewGroup)
        ((ViewGroup)viewParent).removeView(this.mPromptView); 
    } 
  }
  
  private void setPopupClipToScreenEnabled(boolean paramBoolean) {
    if (sClipToWindowEnabledMethod != null)
      try {
        sClipToWindowEnabledMethod.invoke(this.mPopup, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      } catch (Exception exception) {
        Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
        return;
      }  
  }
  
  public void clearListSelection() {
    DropDownListView dropDownListView = this.mDropDownList;
    if (dropDownListView != null) {
      dropDownListView.setListSelectionHidden(true);
      dropDownListView.requestLayout();
    } 
  }
  
  public View.OnTouchListener createDragToOpenListener(View paramView) {
    return new ForwardingListener(paramView) {
        public ListPopupWindow getPopup() {
          return ListPopupWindow.this;
        }
      };
  }
  
  @NonNull
  DropDownListView createDropDownListView(Context paramContext, boolean paramBoolean) {
    return new DropDownListView(paramContext, paramBoolean);
  }
  
  public void dismiss() {
    this.mPopup.dismiss();
    removePromptView();
    this.mPopup.setContentView(null);
    this.mDropDownList = null;
    this.mHandler.removeCallbacks(this.mResizePopupRunnable);
  }
  
  @Nullable
  public View getAnchorView() {
    return this.mDropDownAnchorView;
  }
  
  @StyleRes
  public int getAnimationStyle() {
    return this.mPopup.getAnimationStyle();
  }
  
  @Nullable
  public Drawable getBackground() {
    return this.mPopup.getBackground();
  }
  
  public int getHeight() {
    return this.mDropDownHeight;
  }
  
  public int getHorizontalOffset() {
    return this.mDropDownHorizontalOffset;
  }
  
  public int getInputMethodMode() {
    return this.mPopup.getInputMethodMode();
  }
  
  @Nullable
  public ListView getListView() {
    return this.mDropDownList;
  }
  
  public int getPromptPosition() {
    return this.mPromptPosition;
  }
  
  @Nullable
  public Object getSelectedItem() {
    return !isShowing() ? null : this.mDropDownList.getSelectedItem();
  }
  
  public long getSelectedItemId() {
    return !isShowing() ? Long.MIN_VALUE : this.mDropDownList.getSelectedItemId();
  }
  
  public int getSelectedItemPosition() {
    return !isShowing() ? -1 : this.mDropDownList.getSelectedItemPosition();
  }
  
  @Nullable
  public View getSelectedView() {
    return !isShowing() ? null : this.mDropDownList.getSelectedView();
  }
  
  public int getSoftInputMode() {
    return this.mPopup.getSoftInputMode();
  }
  
  public int getVerticalOffset() {
    return !this.mDropDownVerticalOffsetSet ? 0 : this.mDropDownVerticalOffset;
  }
  
  public int getWidth() {
    return this.mDropDownWidth;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public boolean isDropDownAlwaysVisible() {
    return this.mDropDownAlwaysVisible;
  }
  
  public boolean isInputMethodNotNeeded() {
    return (this.mPopup.getInputMethodMode() == 2);
  }
  
  public boolean isModal() {
    return this.mModal;
  }
  
  public boolean isShowing() {
    return this.mPopup.isShowing();
  }
  
  public boolean onKeyDown(int paramInt, @NonNull KeyEvent paramKeyEvent) {
    int i;
    int j;
    boolean bool;
    int k;
    if (isShowing() && paramInt != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(paramInt))) {
      k = this.mDropDownList.getSelectedItemPosition();
      if (!this.mPopup.isAboveAnchor()) {
        bool = true;
      } else {
        bool = false;
      } 
      ListAdapter listAdapter = this.mAdapter;
      i = Integer.MAX_VALUE;
      j = Integer.MIN_VALUE;
      if (listAdapter != null) {
        boolean bool1 = listAdapter.areAllItemsEnabled();
        if (bool1) {
          i = 0;
        } else {
          i = this.mDropDownList.lookForSelectablePosition(0, true);
        } 
        if (bool1) {
          j = listAdapter.getCount() - 1;
        } else {
          j = this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() - 1, false);
        } 
      } 
      if ((bool && paramInt == 19 && k <= i) || (!bool && paramInt == 20 && k >= j)) {
        clearListSelection();
        this.mPopup.setInputMethodMode(1);
        show();
      } 
      this.mDropDownList.setListSelectionHidden(false);
      if (this.mDropDownList.onKeyDown(paramInt, paramKeyEvent)) {
        this.mPopup.setInputMethodMode(2);
        this.mDropDownList.requestFocusFromTouch();
        show();
        switch (paramInt) {
          case 19:
          case 20:
          case 23:
          case 66:
            return true;
        } 
        return false;
      } 
    } else {
      return false;
    } 
    return (bool && paramInt == 20) ? ((k == j)) : ((!bool && paramInt == 19 && k == i));
  }
  
  public boolean onKeyPreIme(int paramInt, @NonNull KeyEvent paramKeyEvent) {
    if (paramInt == 4 && isShowing()) {
      KeyEvent.DispatcherState dispatcherState;
      View view = this.mDropDownAnchorView;
      if (paramKeyEvent.getAction() == 0 && paramKeyEvent.getRepeatCount() == 0) {
        dispatcherState = view.getKeyDispatcherState();
        if (dispatcherState != null)
          dispatcherState.startTracking(paramKeyEvent, this); 
        return true;
      } 
      if (paramKeyEvent.getAction() == 1) {
        dispatcherState = dispatcherState.getKeyDispatcherState();
        if (dispatcherState != null)
          dispatcherState.handleUpEvent(paramKeyEvent); 
        if (paramKeyEvent.isTracking() && !paramKeyEvent.isCanceled()) {
          dismiss();
          return true;
        } 
      } 
    } 
    return false;
  }
  
  public boolean onKeyUp(int paramInt, @NonNull KeyEvent paramKeyEvent) {
    if (isShowing() && this.mDropDownList.getSelectedItemPosition() >= 0) {
      boolean bool = this.mDropDownList.onKeyUp(paramInt, paramKeyEvent);
      if (bool && isConfirmKey(paramInt))
        dismiss(); 
      return bool;
    } 
    return false;
  }
  
  public boolean performItemClick(int paramInt) {
    if (isShowing()) {
      if (this.mItemClickListener != null) {
        DropDownListView dropDownListView = this.mDropDownList;
        View view = dropDownListView.getChildAt(paramInt - dropDownListView.getFirstVisiblePosition());
        ListAdapter listAdapter = dropDownListView.getAdapter();
        this.mItemClickListener.onItemClick((AdapterView)dropDownListView, view, paramInt, listAdapter.getItemId(paramInt));
      } 
      return true;
    } 
    return false;
  }
  
  public void postShow() {
    this.mHandler.post(this.mShowDropDownRunnable);
  }
  
  public void setAdapter(@Nullable ListAdapter paramListAdapter) {
    if (this.mObserver == null) {
      this.mObserver = new PopupDataSetObserver();
    } else if (this.mAdapter != null) {
      this.mAdapter.unregisterDataSetObserver(this.mObserver);
    } 
    this.mAdapter = paramListAdapter;
    if (this.mAdapter != null)
      paramListAdapter.registerDataSetObserver(this.mObserver); 
    if (this.mDropDownList != null)
      this.mDropDownList.setAdapter(this.mAdapter); 
  }
  
  public void setAnchorView(@Nullable View paramView) {
    this.mDropDownAnchorView = paramView;
  }
  
  public void setAnimationStyle(@StyleRes int paramInt) {
    this.mPopup.setAnimationStyle(paramInt);
  }
  
  public void setBackgroundDrawable(@Nullable Drawable paramDrawable) {
    this.mPopup.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt) {
    Drawable drawable = this.mPopup.getBackground();
    if (drawable != null) {
      drawable.getPadding(this.mTempRect);
      this.mDropDownWidth = this.mTempRect.left + this.mTempRect.right + paramInt;
      return;
    } 
    setWidth(paramInt);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setDropDownAlwaysVisible(boolean paramBoolean) {
    this.mDropDownAlwaysVisible = paramBoolean;
  }
  
  public void setDropDownGravity(int paramInt) {
    this.mDropDownGravity = paramInt;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setEpicenterBounds(Rect paramRect) {
    this.mEpicenterBounds = paramRect;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setForceIgnoreOutsideTouch(boolean paramBoolean) {
    this.mForceIgnoreOutsideTouch = paramBoolean;
  }
  
  public void setHeight(int paramInt) {
    this.mDropDownHeight = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt) {
    this.mDropDownHorizontalOffset = paramInt;
  }
  
  public void setInputMethodMode(int paramInt) {
    this.mPopup.setInputMethodMode(paramInt);
  }
  
  void setListItemExpandMax(int paramInt) {
    this.mListItemExpandMaximum = paramInt;
  }
  
  public void setListSelector(Drawable paramDrawable) {
    this.mDropDownListHighlight = paramDrawable;
  }
  
  public void setModal(boolean paramBoolean) {
    this.mModal = paramBoolean;
    this.mPopup.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener paramOnDismissListener) {
    this.mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener paramOnItemClickListener) {
    this.mItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener paramOnItemSelectedListener) {
    this.mItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void setPromptPosition(int paramInt) {
    this.mPromptPosition = paramInt;
  }
  
  public void setPromptView(@Nullable View paramView) {
    boolean bool = isShowing();
    if (bool)
      removePromptView(); 
    this.mPromptView = paramView;
    if (bool)
      show(); 
  }
  
  public void setSelection(int paramInt) {
    DropDownListView dropDownListView = this.mDropDownList;
    if (isShowing() && dropDownListView != null) {
      dropDownListView.setListSelectionHidden(false);
      dropDownListView.setSelection(paramInt);
      if (Build.VERSION.SDK_INT >= 11 && dropDownListView.getChoiceMode() != 0)
        dropDownListView.setItemChecked(paramInt, true); 
    } 
  }
  
  public void setSoftInputMode(int paramInt) {
    this.mPopup.setSoftInputMode(paramInt);
  }
  
  public void setVerticalOffset(int paramInt) {
    this.mDropDownVerticalOffset = paramInt;
    this.mDropDownVerticalOffsetSet = true;
  }
  
  public void setWidth(int paramInt) {
    this.mDropDownWidth = paramInt;
  }
  
  public void setWindowLayoutType(int paramInt) {
    this.mDropDownWindowLayoutType = paramInt;
  }
  
  public void show() {
    int i;
    boolean bool1 = true;
    boolean bool2 = false;
    byte b = -1;
    int j = buildDropDown();
    boolean bool = isInputMethodNotNeeded();
    PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
    if (this.mPopup.isShowing()) {
      if (this.mDropDownWidth == -1) {
        i = -1;
      } else if (this.mDropDownWidth == -2) {
        i = getAnchorView().getWidth();
      } else {
        i = this.mDropDownWidth;
      } 
      if (this.mDropDownHeight == -1) {
        if (!bool)
          j = -1; 
        if (bool) {
          boolean bool3;
          PopupWindow popupWindow2 = this.mPopup;
          if (this.mDropDownWidth == -1) {
            bool3 = true;
          } else {
            bool3 = false;
          } 
          popupWindow2.setWidth(bool3);
          this.mPopup.setHeight(0);
        } else {
          boolean bool3;
          PopupWindow popupWindow2 = this.mPopup;
          if (this.mDropDownWidth == -1) {
            bool3 = true;
          } else {
            bool3 = false;
          } 
          popupWindow2.setWidth(bool3);
          this.mPopup.setHeight(-1);
        } 
      } else if (this.mDropDownHeight != -2) {
        j = this.mDropDownHeight;
      } 
      PopupWindow popupWindow1 = this.mPopup;
      bool1 = bool2;
      if (!this.mForceIgnoreOutsideTouch) {
        bool1 = bool2;
        if (!this.mDropDownAlwaysVisible)
          bool1 = true; 
      } 
      popupWindow1.setOutsideTouchable(bool1);
      popupWindow1 = this.mPopup;
      View view = getAnchorView();
      int k = this.mDropDownHorizontalOffset;
      int m = this.mDropDownVerticalOffset;
      if (i < 0)
        i = -1; 
      if (j < 0)
        j = b; 
      popupWindow1.update(view, k, m, i, j);
      return;
    } 
    if (this.mDropDownWidth == -1) {
      i = -1;
    } else if (this.mDropDownWidth == -2) {
      i = getAnchorView().getWidth();
    } else {
      i = this.mDropDownWidth;
    } 
    if (this.mDropDownHeight == -1) {
      j = -1;
    } else if (this.mDropDownHeight != -2) {
      j = this.mDropDownHeight;
    } 
    this.mPopup.setWidth(i);
    this.mPopup.setHeight(j);
    setPopupClipToScreenEnabled(true);
    PopupWindow popupWindow = this.mPopup;
    if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible)
      bool1 = false; 
    popupWindow.setOutsideTouchable(bool1);
    this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
    if (sSetEpicenterBoundsMethod != null)
      try {
        sSetEpicenterBoundsMethod.invoke(this.mPopup, new Object[] { this.mEpicenterBounds });
      } catch (Exception exception) {
        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", exception);
      }  
    PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
    this.mDropDownList.setSelection(-1);
    if (!this.mModal || this.mDropDownList.isInTouchMode())
      clearListSelection(); 
    if (!this.mModal) {
      this.mHandler.post(this.mHideSelector);
      return;
    } 
  }
  
  private class ListSelectorHider implements Runnable {
    public void run() {
      ListPopupWindow.this.clearListSelection();
    }
  }
  
  private class PopupDataSetObserver extends DataSetObserver {
    public void onChanged() {
      if (ListPopupWindow.this.isShowing())
        ListPopupWindow.this.show(); 
    }
    
    public void onInvalidated() {
      ListPopupWindow.this.dismiss();
    }
  }
  
  private class PopupScrollListener implements AbsListView.OnScrollListener {
    public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
      if (param1Int == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
        ListPopupWindow.this.mResizePopupRunnable.run();
      } 
    }
  }
  
  private class PopupTouchInterceptor implements View.OnTouchListener {
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      int i = param1MotionEvent.getAction();
      int j = (int)param1MotionEvent.getX();
      int k = (int)param1MotionEvent.getY();
      if (i == 0 && ListPopupWindow.this.mPopup != null && ListPopupWindow.this.mPopup.isShowing() && j >= 0 && j < ListPopupWindow.this.mPopup.getWidth() && k >= 0 && k < ListPopupWindow.this.mPopup.getHeight()) {
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250L);
        return false;
      } 
      if (i == 1)
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable); 
      return false;
    }
  }
  
  private class ResizePopupRunnable implements Runnable {
    public void run() {
      if (ListPopupWindow.this.mDropDownList != null && ViewCompat.isAttachedToWindow((View)ListPopupWindow.this.mDropDownList) && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
        ListPopupWindow.this.mPopup.setInputMethodMode(2);
        ListPopupWindow.this.show();
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\ListPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */