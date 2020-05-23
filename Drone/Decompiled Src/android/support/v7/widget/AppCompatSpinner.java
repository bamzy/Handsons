package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
  private static final int[] ATTRS_ANDROID_SPINNERMODE = new int[] { 16843505 };
  
  private static final int MAX_ITEMS_MEASURED = 15;
  
  private static final int MODE_DIALOG = 0;
  
  private static final int MODE_DROPDOWN = 1;
  
  private static final int MODE_THEME = -1;
  
  private static final String TAG = "AppCompatSpinner";
  
  private AppCompatBackgroundHelper mBackgroundTintHelper;
  
  int mDropDownWidth;
  
  private ForwardingListener mForwardingListener;
  
  DropdownPopup mPopup;
  
  private Context mPopupContext;
  
  private boolean mPopupSet;
  
  private SpinnerAdapter mTempAdapter;
  
  final Rect mTempRect;
  
  public AppCompatSpinner(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public AppCompatSpinner(Context paramContext, int paramInt) {
    this(paramContext, (AttributeSet)null, R.attr.spinnerStyle, paramInt);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, (Resources.Theme)null);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, Resources.Theme paramTheme) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new android/graphics/Rect
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: putfield mTempRect : Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic android/support/v7/appcompat/R$styleable.Spinner : [I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic obtainStyledAttributes : (Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   28: astore #10
    //   30: aload_0
    //   31: new android/support/v7/widget/AppCompatBackgroundHelper
    //   34: dup
    //   35: aload_0
    //   36: invokespecial <init> : (Landroid/view/View;)V
    //   39: putfield mBackgroundTintHelper : Landroid/support/v7/widget/AppCompatBackgroundHelper;
    //   42: aload #5
    //   44: ifnull -> 343
    //   47: aload_0
    //   48: new android/support/v7/view/ContextThemeWrapper
    //   51: dup
    //   52: aload_1
    //   53: aload #5
    //   55: invokespecial <init> : (Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   58: putfield mPopupContext : Landroid/content/Context;
    //   61: aload_0
    //   62: getfield mPopupContext : Landroid/content/Context;
    //   65: ifnull -> 263
    //   68: iload #4
    //   70: istore #7
    //   72: iload #4
    //   74: iconst_m1
    //   75: if_icmpne -> 160
    //   78: getstatic android/os/Build$VERSION.SDK_INT : I
    //   81: bipush #11
    //   83: if_icmplt -> 452
    //   86: aconst_null
    //   87: astore #8
    //   89: aconst_null
    //   90: astore #5
    //   92: aload_1
    //   93: aload_2
    //   94: getstatic android/support/v7/widget/AppCompatSpinner.ATTRS_ANDROID_SPINNERMODE : [I
    //   97: iload_3
    //   98: iconst_0
    //   99: invokevirtual obtainStyledAttributes : (Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   102: astore #9
    //   104: iload #4
    //   106: istore #6
    //   108: aload #9
    //   110: astore #5
    //   112: aload #9
    //   114: astore #8
    //   116: aload #9
    //   118: iconst_0
    //   119: invokevirtual hasValue : (I)Z
    //   122: ifeq -> 142
    //   125: aload #9
    //   127: astore #5
    //   129: aload #9
    //   131: astore #8
    //   133: aload #9
    //   135: iconst_0
    //   136: iconst_0
    //   137: invokevirtual getInt : (II)I
    //   140: istore #6
    //   142: iload #6
    //   144: istore #7
    //   146: aload #9
    //   148: ifnull -> 160
    //   151: aload #9
    //   153: invokevirtual recycle : ()V
    //   156: iload #6
    //   158: istore #7
    //   160: iload #7
    //   162: iconst_1
    //   163: if_icmpne -> 263
    //   166: new android/support/v7/widget/AppCompatSpinner$DropdownPopup
    //   169: dup
    //   170: aload_0
    //   171: aload_0
    //   172: getfield mPopupContext : Landroid/content/Context;
    //   175: aload_2
    //   176: iload_3
    //   177: invokespecial <init> : (Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   180: astore #5
    //   182: aload_0
    //   183: getfield mPopupContext : Landroid/content/Context;
    //   186: aload_2
    //   187: getstatic android/support/v7/appcompat/R$styleable.Spinner : [I
    //   190: iload_3
    //   191: iconst_0
    //   192: invokestatic obtainStyledAttributes : (Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   195: astore #8
    //   197: aload_0
    //   198: aload #8
    //   200: getstatic android/support/v7/appcompat/R$styleable.Spinner_android_dropDownWidth : I
    //   203: bipush #-2
    //   205: invokevirtual getLayoutDimension : (II)I
    //   208: putfield mDropDownWidth : I
    //   211: aload #5
    //   213: aload #8
    //   215: getstatic android/support/v7/appcompat/R$styleable.Spinner_android_popupBackground : I
    //   218: invokevirtual getDrawable : (I)Landroid/graphics/drawable/Drawable;
    //   221: invokevirtual setBackgroundDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   224: aload #5
    //   226: aload #10
    //   228: getstatic android/support/v7/appcompat/R$styleable.Spinner_android_prompt : I
    //   231: invokevirtual getString : (I)Ljava/lang/String;
    //   234: invokevirtual setPromptText : (Ljava/lang/CharSequence;)V
    //   237: aload #8
    //   239: invokevirtual recycle : ()V
    //   242: aload_0
    //   243: aload #5
    //   245: putfield mPopup : Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;
    //   248: aload_0
    //   249: new android/support/v7/widget/AppCompatSpinner$1
    //   252: dup
    //   253: aload_0
    //   254: aload_0
    //   255: aload #5
    //   257: invokespecial <init> : (Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;)V
    //   260: putfield mForwardingListener : Landroid/support/v7/widget/ForwardingListener;
    //   263: aload #10
    //   265: getstatic android/support/v7/appcompat/R$styleable.Spinner_android_entries : I
    //   268: invokevirtual getTextArray : (I)[Ljava/lang/CharSequence;
    //   271: astore #5
    //   273: aload #5
    //   275: ifnull -> 303
    //   278: new android/widget/ArrayAdapter
    //   281: dup
    //   282: aload_1
    //   283: ldc 17367048
    //   285: aload #5
    //   287: invokespecial <init> : (Landroid/content/Context;I[Ljava/lang/Object;)V
    //   290: astore_1
    //   291: aload_1
    //   292: getstatic android/support/v7/appcompat/R$layout.support_simple_spinner_dropdown_item : I
    //   295: invokevirtual setDropDownViewResource : (I)V
    //   298: aload_0
    //   299: aload_1
    //   300: invokevirtual setAdapter : (Landroid/widget/SpinnerAdapter;)V
    //   303: aload #10
    //   305: invokevirtual recycle : ()V
    //   308: aload_0
    //   309: iconst_1
    //   310: putfield mPopupSet : Z
    //   313: aload_0
    //   314: getfield mTempAdapter : Landroid/widget/SpinnerAdapter;
    //   317: ifnull -> 333
    //   320: aload_0
    //   321: aload_0
    //   322: getfield mTempAdapter : Landroid/widget/SpinnerAdapter;
    //   325: invokevirtual setAdapter : (Landroid/widget/SpinnerAdapter;)V
    //   328: aload_0
    //   329: aconst_null
    //   330: putfield mTempAdapter : Landroid/widget/SpinnerAdapter;
    //   333: aload_0
    //   334: getfield mBackgroundTintHelper : Landroid/support/v7/widget/AppCompatBackgroundHelper;
    //   337: aload_2
    //   338: iload_3
    //   339: invokevirtual loadFromAttributes : (Landroid/util/AttributeSet;I)V
    //   342: return
    //   343: aload #10
    //   345: getstatic android/support/v7/appcompat/R$styleable.Spinner_popupTheme : I
    //   348: iconst_0
    //   349: invokevirtual getResourceId : (II)I
    //   352: istore #6
    //   354: iload #6
    //   356: ifeq -> 376
    //   359: aload_0
    //   360: new android/support/v7/view/ContextThemeWrapper
    //   363: dup
    //   364: aload_1
    //   365: iload #6
    //   367: invokespecial <init> : (Landroid/content/Context;I)V
    //   370: putfield mPopupContext : Landroid/content/Context;
    //   373: goto -> 61
    //   376: getstatic android/os/Build$VERSION.SDK_INT : I
    //   379: bipush #23
    //   381: if_icmpge -> 396
    //   384: aload_1
    //   385: astore #5
    //   387: aload_0
    //   388: aload #5
    //   390: putfield mPopupContext : Landroid/content/Context;
    //   393: goto -> 61
    //   396: aconst_null
    //   397: astore #5
    //   399: goto -> 387
    //   402: astore #9
    //   404: aload #5
    //   406: astore #8
    //   408: ldc 'AppCompatSpinner'
    //   410: ldc 'Could not read android:spinnerMode'
    //   412: aload #9
    //   414: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   417: pop
    //   418: iload #4
    //   420: istore #7
    //   422: aload #5
    //   424: ifnull -> 160
    //   427: aload #5
    //   429: invokevirtual recycle : ()V
    //   432: iload #4
    //   434: istore #7
    //   436: goto -> 160
    //   439: astore_1
    //   440: aload #8
    //   442: ifnull -> 450
    //   445: aload #8
    //   447: invokevirtual recycle : ()V
    //   450: aload_1
    //   451: athrow
    //   452: iconst_1
    //   453: istore #7
    //   455: goto -> 160
    // Exception table:
    //   from	to	target	type
    //   92	104	402	java/lang/Exception
    //   92	104	439	finally
    //   116	125	402	java/lang/Exception
    //   116	125	439	finally
    //   133	142	402	java/lang/Exception
    //   133	142	439	finally
    //   408	418	439	finally
  }
  
  int compatMeasureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable) {
    if (paramSpinnerAdapter == null)
      return 0; 
    int i = 0;
    View view = null;
    int k = 0;
    int m = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int n = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int j = Math.max(0, getSelectedItemPosition());
    int i1 = Math.min(paramSpinnerAdapter.getCount(), j + 15);
    j = Math.max(0, j - 15 - i1 - j);
    while (j < i1) {
      int i3 = paramSpinnerAdapter.getItemViewType(j);
      int i2 = k;
      if (i3 != k) {
        i2 = i3;
        view = null;
      } 
      view = paramSpinnerAdapter.getView(j, view, (ViewGroup)this);
      if (view.getLayoutParams() == null)
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2)); 
      view.measure(m, n);
      i = Math.max(i, view.getMeasuredWidth());
      j++;
      k = i2;
    } 
    j = i;
    if (paramDrawable != null) {
      paramDrawable.getPadding(this.mTempRect);
      return i + this.mTempRect.left + this.mTempRect.right;
    } 
    return j;
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.applySupportBackgroundTint(); 
  }
  
  public int getDropDownHorizontalOffset() {
    return (this.mPopup != null) ? this.mPopup.getHorizontalOffset() : ((Build.VERSION.SDK_INT >= 16) ? super.getDropDownHorizontalOffset() : 0);
  }
  
  public int getDropDownVerticalOffset() {
    return (this.mPopup != null) ? this.mPopup.getVerticalOffset() : ((Build.VERSION.SDK_INT >= 16) ? super.getDropDownVerticalOffset() : 0);
  }
  
  public int getDropDownWidth() {
    return (this.mPopup != null) ? this.mDropDownWidth : ((Build.VERSION.SDK_INT >= 16) ? super.getDropDownWidth() : 0);
  }
  
  public Drawable getPopupBackground() {
    return (this.mPopup != null) ? this.mPopup.getBackground() : ((Build.VERSION.SDK_INT >= 16) ? super.getPopupBackground() : null);
  }
  
  public Context getPopupContext() {
    return (this.mPopup != null) ? this.mPopupContext : ((Build.VERSION.SDK_INT >= 23) ? super.getPopupContext() : null);
  }
  
  public CharSequence getPrompt() {
    return (this.mPopup != null) ? this.mPopup.getHintText() : super.getPrompt();
  }
  
  @Nullable
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public ColorStateList getSupportBackgroundTintList() {
    return (this.mBackgroundTintHelper != null) ? this.mBackgroundTintHelper.getSupportBackgroundTintList() : null;
  }
  
  @Nullable
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    return (this.mBackgroundTintHelper != null) ? this.mBackgroundTintHelper.getSupportBackgroundTintMode() : null;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.mPopup != null && this.mPopup.isShowing())
      this.mPopup.dismiss(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mPopup != null && View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight()); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return (this.mForwardingListener != null && this.mForwardingListener.onTouch((View)this, paramMotionEvent)) ? true : super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick() {
    if (this.mPopup != null) {
      if (!this.mPopup.isShowing())
        this.mPopup.show(); 
      return true;
    } 
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter) {
    if (!this.mPopupSet) {
      this.mTempAdapter = paramSpinnerAdapter;
      return;
    } 
    super.setAdapter(paramSpinnerAdapter);
    if (this.mPopup != null) {
      Context context;
      if (this.mPopupContext == null) {
        context = getContext();
      } else {
        context = this.mPopupContext;
      } 
      this.mPopup.setAdapter(new DropDownAdapter(paramSpinnerAdapter, context.getTheme()));
      return;
    } 
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.onSetBackgroundDrawable(paramDrawable); 
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt) {
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.onSetBackgroundResource(paramInt); 
  }
  
  public void setDropDownHorizontalOffset(int paramInt) {
    if (this.mPopup != null) {
      this.mPopup.setHorizontalOffset(paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownHorizontalOffset(paramInt);
      return;
    } 
  }
  
  public void setDropDownVerticalOffset(int paramInt) {
    if (this.mPopup != null) {
      this.mPopup.setVerticalOffset(paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownVerticalOffset(paramInt);
      return;
    } 
  }
  
  public void setDropDownWidth(int paramInt) {
    if (this.mPopup != null) {
      this.mDropDownWidth = paramInt;
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownWidth(paramInt);
      return;
    } 
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable) {
    if (this.mPopup != null) {
      this.mPopup.setBackgroundDrawable(paramDrawable);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      super.setPopupBackgroundDrawable(paramDrawable);
      return;
    } 
  }
  
  public void setPopupBackgroundResource(@DrawableRes int paramInt) {
    setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence) {
    if (this.mPopup != null) {
      this.mPopup.setPromptText(paramCharSequence);
      return;
    } 
    super.setPrompt(paramCharSequence);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList) {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList); 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode) {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode); 
  }
  
  private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
    private SpinnerAdapter mAdapter;
    
    private ListAdapter mListAdapter;
    
    public DropDownAdapter(@Nullable SpinnerAdapter param1SpinnerAdapter, @Nullable Resources.Theme param1Theme) {
      ThemedSpinnerAdapter themedSpinnerAdapter;
      this.mAdapter = param1SpinnerAdapter;
      if (param1SpinnerAdapter instanceof ListAdapter)
        this.mListAdapter = (ListAdapter)param1SpinnerAdapter; 
      if (param1Theme != null) {
        if (Build.VERSION.SDK_INT >= 23 && param1SpinnerAdapter instanceof ThemedSpinnerAdapter) {
          themedSpinnerAdapter = (ThemedSpinnerAdapter)param1SpinnerAdapter;
          if (themedSpinnerAdapter.getDropDownViewTheme() != param1Theme)
            themedSpinnerAdapter.setDropDownViewTheme(param1Theme); 
          return;
        } 
      } else {
        return;
      } 
      if (themedSpinnerAdapter instanceof ThemedSpinnerAdapter) {
        ThemedSpinnerAdapter themedSpinnerAdapter1 = (ThemedSpinnerAdapter)themedSpinnerAdapter;
        if (themedSpinnerAdapter1.getDropDownViewTheme() == null) {
          themedSpinnerAdapter1.setDropDownViewTheme(param1Theme);
          return;
        } 
      } 
    }
    
    public boolean areAllItemsEnabled() {
      ListAdapter listAdapter = this.mListAdapter;
      return (listAdapter != null) ? listAdapter.areAllItemsEnabled() : true;
    }
    
    public int getCount() {
      return (this.mAdapter == null) ? 0 : this.mAdapter.getCount();
    }
    
    public View getDropDownView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      return (this.mAdapter == null) ? null : this.mAdapter.getDropDownView(param1Int, param1View, param1ViewGroup);
    }
    
    public Object getItem(int param1Int) {
      return (this.mAdapter == null) ? null : this.mAdapter.getItem(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return (this.mAdapter == null) ? -1L : this.mAdapter.getItemId(param1Int);
    }
    
    public int getItemViewType(int param1Int) {
      return 0;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      return getDropDownView(param1Int, param1View, param1ViewGroup);
    }
    
    public int getViewTypeCount() {
      return 1;
    }
    
    public boolean hasStableIds() {
      return (this.mAdapter != null && this.mAdapter.hasStableIds());
    }
    
    public boolean isEmpty() {
      return (getCount() == 0);
    }
    
    public boolean isEnabled(int param1Int) {
      ListAdapter listAdapter = this.mListAdapter;
      return (listAdapter != null) ? listAdapter.isEnabled(param1Int) : true;
    }
    
    public void registerDataSetObserver(DataSetObserver param1DataSetObserver) {
      if (this.mAdapter != null)
        this.mAdapter.registerDataSetObserver(param1DataSetObserver); 
    }
    
    public void unregisterDataSetObserver(DataSetObserver param1DataSetObserver) {
      if (this.mAdapter != null)
        this.mAdapter.unregisterDataSetObserver(param1DataSetObserver); 
    }
  }
  
  private class DropdownPopup extends ListPopupWindow {
    ListAdapter mAdapter;
    
    private CharSequence mHintText;
    
    private final Rect mVisibleRect = new Rect();
    
    public DropdownPopup(Context param1Context, AttributeSet param1AttributeSet, int param1Int) {
      super(param1Context, param1AttributeSet, param1Int);
      setAnchorView((View)AppCompatSpinner.this);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> param2AdapterView, View param2View, int param2Int, long param2Long) {
              AppCompatSpinner.this.setSelection(param2Int);
              if (AppCompatSpinner.this.getOnItemClickListener() != null)
                AppCompatSpinner.this.performItemClick(param2View, param2Int, AppCompatSpinner.DropdownPopup.this.mAdapter.getItemId(param2Int)); 
              AppCompatSpinner.DropdownPopup.this.dismiss();
            }
          });
    }
    
    void computeContentWidth() {
      Drawable drawable = getBackground();
      int i = 0;
      if (drawable != null) {
        drawable.getPadding(AppCompatSpinner.this.mTempRect);
        if (ViewUtils.isLayoutRtl((View)AppCompatSpinner.this)) {
          i = AppCompatSpinner.this.mTempRect.right;
        } else {
          i = -AppCompatSpinner.this.mTempRect.left;
        } 
      } else {
        Rect rect = AppCompatSpinner.this.mTempRect;
        AppCompatSpinner.this.mTempRect.right = 0;
        rect.left = 0;
      } 
      int j = AppCompatSpinner.this.getPaddingLeft();
      int k = AppCompatSpinner.this.getPaddingRight();
      int m = AppCompatSpinner.this.getWidth();
      if (AppCompatSpinner.this.mDropDownWidth == -2) {
        int i1 = AppCompatSpinner.this.compatMeasureContentWidth((SpinnerAdapter)this.mAdapter, getBackground());
        int i2 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics()).widthPixels - AppCompatSpinner.this.mTempRect.left - AppCompatSpinner.this.mTempRect.right;
        int n = i1;
        if (i1 > i2)
          n = i2; 
        setContentWidth(Math.max(n, m - j - k));
      } else if (AppCompatSpinner.this.mDropDownWidth == -1) {
        setContentWidth(m - j - k);
      } else {
        setContentWidth(AppCompatSpinner.this.mDropDownWidth);
      } 
      if (ViewUtils.isLayoutRtl((View)AppCompatSpinner.this)) {
        i += m - k - getWidth();
      } else {
        i += j;
      } 
      setHorizontalOffset(i);
    }
    
    public CharSequence getHintText() {
      return this.mHintText;
    }
    
    boolean isVisibleToUser(View param1View) {
      return (ViewCompat.isAttachedToWindow(param1View) && param1View.getGlobalVisibleRect(this.mVisibleRect));
    }
    
    public void setAdapter(ListAdapter param1ListAdapter) {
      super.setAdapter(param1ListAdapter);
      this.mAdapter = param1ListAdapter;
    }
    
    public void setPromptText(CharSequence param1CharSequence) {
      this.mHintText = param1CharSequence;
    }
    
    public void show() {
      boolean bool = isShowing();
      computeContentWidth();
      setInputMethodMode(2);
      super.show();
      getListView().setChoiceMode(1);
      setSelection(AppCompatSpinner.this.getSelectedItemPosition());
      if (!bool) {
        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
        if (viewTreeObserver != null) {
          final ViewTreeObserver.OnGlobalLayoutListener layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
              public void onGlobalLayout() {
                if (!AppCompatSpinner.DropdownPopup.this.isVisibleToUser((View)AppCompatSpinner.this)) {
                  AppCompatSpinner.DropdownPopup.this.dismiss();
                  return;
                } 
                AppCompatSpinner.DropdownPopup.this.computeContentWidth();
                AppCompatSpinner.DropdownPopup.this.show();
              }
            };
          viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
          setOnDismissListener(new PopupWindow.OnDismissListener() {
                public void onDismiss() {
                  ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                  if (viewTreeObserver != null)
                    viewTreeObserver.removeGlobalOnLayoutListener(layoutListener); 
                }
              });
          return;
        } 
      } 
    }
  }
  
  class null implements AdapterView.OnItemClickListener {
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      AppCompatSpinner.this.setSelection(param1Int);
      if (AppCompatSpinner.this.getOnItemClickListener() != null)
        AppCompatSpinner.this.performItemClick(param1View, param1Int, this.this$1.mAdapter.getItemId(param1Int)); 
      this.this$1.dismiss();
    }
  }
  
  class null implements ViewTreeObserver.OnGlobalLayoutListener {
    public void onGlobalLayout() {
      if (!this.this$1.isVisibleToUser((View)AppCompatSpinner.this)) {
        this.this$1.dismiss();
        return;
      } 
      this.this$1.computeContentWidth();
      this.this$1.show();
    }
  }
  
  class null implements PopupWindow.OnDismissListener {
    public void onDismiss() {
      ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
      if (viewTreeObserver != null)
        viewTreeObserver.removeGlobalOnLayoutListener(layoutListener); 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\AppCompatSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */