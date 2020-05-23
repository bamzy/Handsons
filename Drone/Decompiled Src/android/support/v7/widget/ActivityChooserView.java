package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
  private static final String LOG_TAG = "ActivityChooserView";
  
  private final LinearLayoutCompat mActivityChooserContent;
  
  private final Drawable mActivityChooserContentBackground;
  
  final ActivityChooserViewAdapter mAdapter;
  
  private final Callbacks mCallbacks;
  
  private int mDefaultActionButtonContentDescription;
  
  final FrameLayout mDefaultActivityButton;
  
  private final ImageView mDefaultActivityButtonImage;
  
  final FrameLayout mExpandActivityOverflowButton;
  
  private final ImageView mExpandActivityOverflowButtonImage;
  
  int mInitialActivityCount = 4;
  
  private boolean mIsAttachedToWindow;
  
  boolean mIsSelectingDefaultActivity;
  
  private final int mListPopupMaxWidth;
  
  private ListPopupWindow mListPopupWindow;
  
  final DataSetObserver mModelDataSetObserver = new DataSetObserver() {
      public void onChanged() {
        super.onChanged();
        ActivityChooserView.this.mAdapter.notifyDataSetChanged();
      }
      
      public void onInvalidated() {
        super.onInvalidated();
        ActivityChooserView.this.mAdapter.notifyDataSetInvalidated();
      }
    };
  
  PopupWindow.OnDismissListener mOnDismissListener;
  
  private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
      public void onGlobalLayout() {
        if (ActivityChooserView.this.isShowingPopup()) {
          if (!ActivityChooserView.this.isShown()) {
            ActivityChooserView.this.getListPopupWindow().dismiss();
            return;
          } 
        } else {
          return;
        } 
        ActivityChooserView.this.getListPopupWindow().show();
        if (ActivityChooserView.this.mProvider != null) {
          ActivityChooserView.this.mProvider.subUiVisibilityChanged(true);
          return;
        } 
      }
    };
  
  ActionProvider mProvider;
  
  public ActivityChooserView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActivityChooserView, paramInt, 0);
    this.mInitialActivityCount = typedArray.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
    Drawable drawable = typedArray.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
    typedArray.recycle();
    LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
    this.mCallbacks = new Callbacks();
    this.mActivityChooserContent = (LinearLayoutCompat)findViewById(R.id.activity_chooser_view_content);
    this.mActivityChooserContentBackground = this.mActivityChooserContent.getBackground();
    this.mDefaultActivityButton = (FrameLayout)findViewById(R.id.default_activity_button);
    this.mDefaultActivityButton.setOnClickListener(this.mCallbacks);
    this.mDefaultActivityButton.setOnLongClickListener(this.mCallbacks);
    this.mDefaultActivityButtonImage = (ImageView)this.mDefaultActivityButton.findViewById(R.id.image);
    FrameLayout frameLayout = (FrameLayout)findViewById(R.id.expand_activities_button);
    frameLayout.setOnClickListener(this.mCallbacks);
    frameLayout.setOnTouchListener(new ForwardingListener((View)frameLayout) {
          public ShowableListMenu getPopup() {
            return ActivityChooserView.this.getListPopupWindow();
          }
          
          protected boolean onForwardingStarted() {
            ActivityChooserView.this.showPopup();
            return true;
          }
          
          protected boolean onForwardingStopped() {
            ActivityChooserView.this.dismissPopup();
            return true;
          }
        });
    this.mExpandActivityOverflowButton = frameLayout;
    this.mExpandActivityOverflowButtonImage = (ImageView)frameLayout.findViewById(R.id.image);
    this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    this.mAdapter = new ActivityChooserViewAdapter();
    this.mAdapter.registerDataSetObserver(new DataSetObserver() {
          public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.updateAppearance();
          }
        });
    Resources resources = paramContext.getResources();
    this.mListPopupMaxWidth = Math.max((resources.getDisplayMetrics()).widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
  }
  
  public boolean dismissPopup() {
    if (isShowingPopup()) {
      getListPopupWindow().dismiss();
      ViewTreeObserver viewTreeObserver = getViewTreeObserver();
      if (viewTreeObserver.isAlive())
        viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener); 
    } 
    return true;
  }
  
  public ActivityChooserModel getDataModel() {
    return this.mAdapter.getDataModel();
  }
  
  ListPopupWindow getListPopupWindow() {
    if (this.mListPopupWindow == null) {
      this.mListPopupWindow = new ListPopupWindow(getContext());
      this.mListPopupWindow.setAdapter((ListAdapter)this.mAdapter);
      this.mListPopupWindow.setAnchorView((View)this);
      this.mListPopupWindow.setModal(true);
      this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
      this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
    } 
    return this.mListPopupWindow;
  }
  
  public boolean isShowingPopup() {
    return getListPopupWindow().isShowing();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    ActivityChooserModel activityChooserModel = this.mAdapter.getDataModel();
    if (activityChooserModel != null)
      activityChooserModel.registerObserver(this.mModelDataSetObserver); 
    this.mIsAttachedToWindow = true;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    ActivityChooserModel activityChooserModel = this.mAdapter.getDataModel();
    if (activityChooserModel != null)
      activityChooserModel.unregisterObserver(this.mModelDataSetObserver); 
    ViewTreeObserver viewTreeObserver = getViewTreeObserver();
    if (viewTreeObserver.isAlive())
      viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener); 
    if (isShowingPopup())
      dismissPopup(); 
    this.mIsAttachedToWindow = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mActivityChooserContent.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!isShowingPopup())
      dismissPopup(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    LinearLayoutCompat linearLayoutCompat = this.mActivityChooserContent;
    int i = paramInt2;
    if (this.mDefaultActivityButton.getVisibility() != 0)
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824); 
    measureChild((View)linearLayoutCompat, paramInt1, i);
    setMeasuredDimension(linearLayoutCompat.getMeasuredWidth(), linearLayoutCompat.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel) {
    this.mAdapter.setDataModel(paramActivityChooserModel);
    if (isShowingPopup()) {
      dismissPopup();
      showPopup();
    } 
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt) {
    this.mDefaultActionButtonContentDescription = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt) {
    String str = getContext().getString(paramInt);
    this.mExpandActivityOverflowButtonImage.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable) {
    this.mExpandActivityOverflowButtonImage.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt) {
    this.mInitialActivityCount = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setProvider(ActionProvider paramActionProvider) {
    this.mProvider = paramActionProvider;
  }
  
  public boolean showPopup() {
    if (isShowingPopup() || !this.mIsAttachedToWindow)
      return false; 
    this.mIsSelectingDefaultActivity = false;
    showPopupUnchecked(this.mInitialActivityCount);
    return true;
  }
  
  void showPopupUnchecked(int paramInt) {
    byte b;
    boolean bool;
    if (this.mAdapter.getDataModel() == null)
      throw new IllegalStateException("No data model. Did you call #setDataModel?"); 
    getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    if (this.mDefaultActivityButton.getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.mAdapter.getActivityCount();
    if (bool) {
      b = 1;
    } else {
      b = 0;
    } 
    if (paramInt != Integer.MAX_VALUE && i > paramInt + b) {
      this.mAdapter.setShowFooterView(true);
      this.mAdapter.setMaxActivityCount(paramInt - 1);
    } else {
      this.mAdapter.setShowFooterView(false);
      this.mAdapter.setMaxActivityCount(paramInt);
    } 
    ListPopupWindow listPopupWindow = getListPopupWindow();
    if (!listPopupWindow.isShowing()) {
      if (this.mIsSelectingDefaultActivity || !bool) {
        this.mAdapter.setShowDefaultActivity(true, bool);
      } else {
        this.mAdapter.setShowDefaultActivity(false, false);
      } 
      listPopupWindow.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
      listPopupWindow.show();
      if (this.mProvider != null)
        this.mProvider.subUiVisibilityChanged(true); 
      listPopupWindow.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
    } 
  }
  
  void updateAppearance() {
    if (this.mAdapter.getCount() > 0) {
      this.mExpandActivityOverflowButton.setEnabled(true);
    } else {
      this.mExpandActivityOverflowButton.setEnabled(false);
    } 
    int i = this.mAdapter.getActivityCount();
    int j = this.mAdapter.getHistorySize();
    if (i == 1 || (i > 1 && j > 0)) {
      this.mDefaultActivityButton.setVisibility(0);
      ResolveInfo resolveInfo = this.mAdapter.getDefaultActivity();
      PackageManager packageManager = getContext().getPackageManager();
      this.mDefaultActivityButtonImage.setImageDrawable(resolveInfo.loadIcon(packageManager));
      if (this.mDefaultActionButtonContentDescription != 0) {
        CharSequence charSequence = resolveInfo.loadLabel(packageManager);
        charSequence = getContext().getString(this.mDefaultActionButtonContentDescription, new Object[] { charSequence });
        this.mDefaultActivityButton.setContentDescription(charSequence);
      } 
    } else {
      this.mDefaultActivityButton.setVisibility(8);
    } 
    if (this.mDefaultActivityButton.getVisibility() == 0) {
      this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
      return;
    } 
    this.mActivityChooserContent.setBackgroundDrawable(null);
  }
  
  private class ActivityChooserViewAdapter extends BaseAdapter {
    private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
    
    private static final int ITEM_VIEW_TYPE_COUNT = 3;
    
    private static final int ITEM_VIEW_TYPE_FOOTER = 1;
    
    public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
    
    public static final int MAX_ACTIVITY_COUNT_UNLIMITED = 2147483647;
    
    private ActivityChooserModel mDataModel;
    
    private boolean mHighlightDefaultActivity;
    
    private int mMaxActivityCount = 4;
    
    private boolean mShowDefaultActivity;
    
    private boolean mShowFooterView;
    
    public int getActivityCount() {
      return this.mDataModel.getActivityCount();
    }
    
    public int getCount() {
      int j = this.mDataModel.getActivityCount();
      int i = j;
      if (!this.mShowDefaultActivity) {
        i = j;
        if (this.mDataModel.getDefaultActivity() != null)
          i = j - 1; 
      } 
      j = Math.min(i, this.mMaxActivityCount);
      i = j;
      if (this.mShowFooterView)
        i = j + 1; 
      return i;
    }
    
    public ActivityChooserModel getDataModel() {
      return this.mDataModel;
    }
    
    public ResolveInfo getDefaultActivity() {
      return this.mDataModel.getDefaultActivity();
    }
    
    public int getHistorySize() {
      return this.mDataModel.getHistorySize();
    }
    
    public Object getItem(int param1Int) {
      switch (getItemViewType(param1Int)) {
        default:
          throw new IllegalArgumentException();
        case 1:
          return null;
        case 0:
          break;
      } 
      int i = param1Int;
      if (!this.mShowDefaultActivity) {
        i = param1Int;
        if (this.mDataModel.getDefaultActivity() != null)
          i = param1Int + 1; 
      } 
      return this.mDataModel.getActivity(i);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public int getItemViewType(int param1Int) {
      return (this.mShowFooterView && param1Int == getCount() - 1) ? 1 : 0;
    }
    
    public boolean getShowDefaultActivity() {
      return this.mShowDefaultActivity;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      // Byte code:
      //   0: aload_0
      //   1: iload_1
      //   2: invokevirtual getItemViewType : (I)I
      //   5: tableswitch default -> 28, 0 -> 107, 1 -> 36
      //   28: new java/lang/IllegalArgumentException
      //   31: dup
      //   32: invokespecial <init> : ()V
      //   35: athrow
      //   36: aload_2
      //   37: ifnull -> 51
      //   40: aload_2
      //   41: astore #4
      //   43: aload_2
      //   44: invokevirtual getId : ()I
      //   47: iconst_1
      //   48: if_icmpeq -> 104
      //   51: aload_0
      //   52: getfield this$0 : Landroid/support/v7/widget/ActivityChooserView;
      //   55: invokevirtual getContext : ()Landroid/content/Context;
      //   58: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
      //   61: getstatic android/support/v7/appcompat/R$layout.abc_activity_chooser_view_list_item : I
      //   64: aload_3
      //   65: iconst_0
      //   66: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
      //   69: astore #4
      //   71: aload #4
      //   73: iconst_1
      //   74: invokevirtual setId : (I)V
      //   77: aload #4
      //   79: getstatic android/support/v7/appcompat/R$id.title : I
      //   82: invokevirtual findViewById : (I)Landroid/view/View;
      //   85: checkcast android/widget/TextView
      //   88: aload_0
      //   89: getfield this$0 : Landroid/support/v7/widget/ActivityChooserView;
      //   92: invokevirtual getContext : ()Landroid/content/Context;
      //   95: getstatic android/support/v7/appcompat/R$string.abc_activity_chooser_view_see_all : I
      //   98: invokevirtual getString : (I)Ljava/lang/String;
      //   101: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   104: aload #4
      //   106: areturn
      //   107: aload_2
      //   108: ifnull -> 124
      //   111: aload_2
      //   112: astore #4
      //   114: aload_2
      //   115: invokevirtual getId : ()I
      //   118: getstatic android/support/v7/appcompat/R$id.list_item : I
      //   121: if_icmpeq -> 144
      //   124: aload_0
      //   125: getfield this$0 : Landroid/support/v7/widget/ActivityChooserView;
      //   128: invokevirtual getContext : ()Landroid/content/Context;
      //   131: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
      //   134: getstatic android/support/v7/appcompat/R$layout.abc_activity_chooser_view_list_item : I
      //   137: aload_3
      //   138: iconst_0
      //   139: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
      //   142: astore #4
      //   144: aload_0
      //   145: getfield this$0 : Landroid/support/v7/widget/ActivityChooserView;
      //   148: invokevirtual getContext : ()Landroid/content/Context;
      //   151: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
      //   154: astore_2
      //   155: aload #4
      //   157: getstatic android/support/v7/appcompat/R$id.icon : I
      //   160: invokevirtual findViewById : (I)Landroid/view/View;
      //   163: checkcast android/widget/ImageView
      //   166: astore_3
      //   167: aload_0
      //   168: iload_1
      //   169: invokevirtual getItem : (I)Ljava/lang/Object;
      //   172: checkcast android/content/pm/ResolveInfo
      //   175: astore #5
      //   177: aload_3
      //   178: aload #5
      //   180: aload_2
      //   181: invokevirtual loadIcon : (Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;
      //   184: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
      //   187: aload #4
      //   189: getstatic android/support/v7/appcompat/R$id.title : I
      //   192: invokevirtual findViewById : (I)Landroid/view/View;
      //   195: checkcast android/widget/TextView
      //   198: aload #5
      //   200: aload_2
      //   201: invokevirtual loadLabel : (Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
      //   204: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   207: aload_0
      //   208: getfield mShowDefaultActivity : Z
      //   211: ifeq -> 234
      //   214: iload_1
      //   215: ifne -> 234
      //   218: aload_0
      //   219: getfield mHighlightDefaultActivity : Z
      //   222: ifeq -> 234
      //   225: aload #4
      //   227: iconst_1
      //   228: invokestatic setActivated : (Landroid/view/View;Z)V
      //   231: aload #4
      //   233: areturn
      //   234: aload #4
      //   236: iconst_0
      //   237: invokestatic setActivated : (Landroid/view/View;Z)V
      //   240: goto -> 231
    }
    
    public int getViewTypeCount() {
      return 3;
    }
    
    public int measureContentWidth() {
      int k = this.mMaxActivityCount;
      this.mMaxActivityCount = Integer.MAX_VALUE;
      int j = 0;
      View view = null;
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      int n = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i1 = getCount();
      for (int i = 0; i < i1; i++) {
        view = getView(i, view, (ViewGroup)null);
        view.measure(m, n);
        j = Math.max(j, view.getMeasuredWidth());
      } 
      this.mMaxActivityCount = k;
      return j;
    }
    
    public void setDataModel(ActivityChooserModel param1ActivityChooserModel) {
      ActivityChooserModel activityChooserModel = ActivityChooserView.this.mAdapter.getDataModel();
      if (activityChooserModel != null && ActivityChooserView.this.isShown())
        activityChooserModel.unregisterObserver(ActivityChooserView.this.mModelDataSetObserver); 
      this.mDataModel = param1ActivityChooserModel;
      if (param1ActivityChooserModel != null && ActivityChooserView.this.isShown())
        param1ActivityChooserModel.registerObserver(ActivityChooserView.this.mModelDataSetObserver); 
      notifyDataSetChanged();
    }
    
    public void setMaxActivityCount(int param1Int) {
      if (this.mMaxActivityCount != param1Int) {
        this.mMaxActivityCount = param1Int;
        notifyDataSetChanged();
      } 
    }
    
    public void setShowDefaultActivity(boolean param1Boolean1, boolean param1Boolean2) {
      if (this.mShowDefaultActivity != param1Boolean1 || this.mHighlightDefaultActivity != param1Boolean2) {
        this.mShowDefaultActivity = param1Boolean1;
        this.mHighlightDefaultActivity = param1Boolean2;
        notifyDataSetChanged();
      } 
    }
    
    public void setShowFooterView(boolean param1Boolean) {
      if (this.mShowFooterView != param1Boolean) {
        this.mShowFooterView = param1Boolean;
        notifyDataSetChanged();
      } 
    }
  }
  
  private class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
    private void notifyOnDismissListener() {
      if (ActivityChooserView.this.mOnDismissListener != null)
        ActivityChooserView.this.mOnDismissListener.onDismiss(); 
    }
    
    public void onClick(View param1View) {
      Intent intent;
      if (param1View == ActivityChooserView.this.mDefaultActivityButton) {
        ActivityChooserView.this.dismissPopup();
        ResolveInfo resolveInfo = ActivityChooserView.this.mAdapter.getDefaultActivity();
        int i = ActivityChooserView.this.mAdapter.getDataModel().getActivityIndex(resolveInfo);
        intent = ActivityChooserView.this.mAdapter.getDataModel().chooseActivity(i);
        if (intent != null) {
          intent.addFlags(524288);
          ActivityChooserView.this.getContext().startActivity(intent);
        } 
        return;
      } 
      if (intent == ActivityChooserView.this.mExpandActivityOverflowButton) {
        ActivityChooserView.this.mIsSelectingDefaultActivity = false;
        ActivityChooserView.this.showPopupUnchecked(ActivityChooserView.this.mInitialActivityCount);
        return;
      } 
      throw new IllegalArgumentException();
    }
    
    public void onDismiss() {
      notifyOnDismissListener();
      if (ActivityChooserView.this.mProvider != null)
        ActivityChooserView.this.mProvider.subUiVisibilityChanged(false); 
    }
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      switch (((ActivityChooserView.ActivityChooserViewAdapter)param1AdapterView.getAdapter()).getItemViewType(param1Int)) {
        default:
          throw new IllegalArgumentException();
        case 1:
          ActivityChooserView.this.showPopupUnchecked(2147483647);
          return;
        case 0:
          break;
      } 
      ActivityChooserView.this.dismissPopup();
      if (ActivityChooserView.this.mIsSelectingDefaultActivity) {
        if (param1Int > 0) {
          ActivityChooserView.this.mAdapter.getDataModel().setDefaultActivity(param1Int);
          return;
        } 
        return;
      } 
      if (!ActivityChooserView.this.mAdapter.getShowDefaultActivity())
        param1Int++; 
      Intent intent = ActivityChooserView.this.mAdapter.getDataModel().chooseActivity(param1Int);
      if (intent != null) {
        intent.addFlags(524288);
        ActivityChooserView.this.getContext().startActivity(intent);
        return;
      } 
    }
    
    public boolean onLongClick(View param1View) {
      if (param1View == ActivityChooserView.this.mDefaultActivityButton) {
        if (ActivityChooserView.this.mAdapter.getCount() > 0) {
          ActivityChooserView.this.mIsSelectingDefaultActivity = true;
          ActivityChooserView.this.showPopupUnchecked(ActivityChooserView.this.mInitialActivityCount);
        } 
        return true;
      } 
      throw new IllegalArgumentException();
    }
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static class InnerLayout extends LinearLayoutCompat {
    private static final int[] TINT_ATTRS = new int[] { 16842964 };
    
    public InnerLayout(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(param1Context, param1AttributeSet, TINT_ATTRS);
      setBackgroundDrawable(tintTypedArray.getDrawable(0));
      tintTypedArray.recycle();
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\ActivityChooserView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */