package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
  private static final String TAG = "Toolbar";
  
  private MenuPresenter.Callback mActionMenuPresenterCallback;
  
  int mButtonGravity;
  
  ImageButton mCollapseButtonView;
  
  private CharSequence mCollapseDescription;
  
  private Drawable mCollapseIcon;
  
  private boolean mCollapsible;
  
  private int mContentInsetEndWithActions;
  
  private int mContentInsetStartWithNavigation;
  
  private RtlSpacingHelper mContentInsets;
  
  private boolean mEatingHover;
  
  private boolean mEatingTouch;
  
  View mExpandedActionView;
  
  private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
  
  private int mGravity = 8388627;
  
  private final ArrayList<View> mHiddenViews = new ArrayList<View>();
  
  private ImageView mLogoView;
  
  private int mMaxButtonHeight;
  
  private MenuBuilder.Callback mMenuBuilderCallback;
  
  private ActionMenuView mMenuView;
  
  private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener() {
      public boolean onMenuItemClick(MenuItem param1MenuItem) {
        return (Toolbar.this.mOnMenuItemClickListener != null) ? Toolbar.this.mOnMenuItemClickListener.onMenuItemClick(param1MenuItem) : false;
      }
    };
  
  private ImageButton mNavButtonView;
  
  OnMenuItemClickListener mOnMenuItemClickListener;
  
  private ActionMenuPresenter mOuterActionMenuPresenter;
  
  private Context mPopupContext;
  
  private int mPopupTheme;
  
  private final Runnable mShowOverflowMenuRunnable = new Runnable() {
      public void run() {
        Toolbar.this.showOverflowMenu();
      }
    };
  
  private CharSequence mSubtitleText;
  
  private int mSubtitleTextAppearance;
  
  private int mSubtitleTextColor;
  
  private TextView mSubtitleTextView;
  
  private final int[] mTempMargins = new int[2];
  
  private final ArrayList<View> mTempViews = new ArrayList<View>();
  
  private int mTitleMarginBottom;
  
  private int mTitleMarginEnd;
  
  private int mTitleMarginStart;
  
  private int mTitleMarginTop;
  
  private CharSequence mTitleText;
  
  private int mTitleTextAppearance;
  
  private int mTitleTextColor;
  
  private TextView mTitleTextView;
  
  private ToolbarWidgetWrapper mWrapper;
  
  public Toolbar(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public Toolbar(Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    this.mTitleTextAppearance = tintTypedArray.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
    this.mSubtitleTextAppearance = tintTypedArray.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
    this.mGravity = tintTypedArray.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
    this.mButtonGravity = tintTypedArray.getInteger(R.styleable.Toolbar_buttonGravity, 48);
    int i = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
    paramInt = i;
    if (tintTypedArray.hasValue(R.styleable.Toolbar_titleMargins))
      paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, i); 
    this.mTitleMarginBottom = paramInt;
    this.mTitleMarginTop = paramInt;
    this.mTitleMarginEnd = paramInt;
    this.mTitleMarginStart = paramInt;
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0)
      this.mTitleMarginStart = paramInt; 
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0)
      this.mTitleMarginEnd = paramInt; 
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0)
      this.mTitleMarginTop = paramInt; 
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0)
      this.mTitleMarginBottom = paramInt; 
    this.mMaxButtonHeight = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, -2147483648);
    i = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, -2147483648);
    int j = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
    int k = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
    ensureContentInsets();
    this.mContentInsets.setAbsolute(j, k);
    if (paramInt != Integer.MIN_VALUE || i != Integer.MIN_VALUE)
      this.mContentInsets.setRelative(paramInt, i); 
    this.mContentInsetStartWithNavigation = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, -2147483648);
    this.mContentInsetEndWithActions = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, -2147483648);
    this.mCollapseIcon = tintTypedArray.getDrawable(R.styleable.Toolbar_collapseIcon);
    this.mCollapseDescription = tintTypedArray.getText(R.styleable.Toolbar_collapseContentDescription);
    CharSequence charSequence3 = tintTypedArray.getText(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(charSequence3))
      setTitle(charSequence3); 
    charSequence3 = tintTypedArray.getText(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(charSequence3))
      setSubtitle(charSequence3); 
    this.mPopupContext = getContext();
    setPopupTheme(tintTypedArray.getResourceId(R.styleable.Toolbar_popupTheme, 0));
    Drawable drawable2 = tintTypedArray.getDrawable(R.styleable.Toolbar_navigationIcon);
    if (drawable2 != null)
      setNavigationIcon(drawable2); 
    CharSequence charSequence2 = tintTypedArray.getText(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(charSequence2))
      setNavigationContentDescription(charSequence2); 
    Drawable drawable1 = tintTypedArray.getDrawable(R.styleable.Toolbar_logo);
    if (drawable1 != null)
      setLogo(drawable1); 
    CharSequence charSequence1 = tintTypedArray.getText(R.styleable.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(charSequence1))
      setLogoDescription(charSequence1); 
    if (tintTypedArray.hasValue(R.styleable.Toolbar_titleTextColor))
      setTitleTextColor(tintTypedArray.getColor(R.styleable.Toolbar_titleTextColor, -1)); 
    if (tintTypedArray.hasValue(R.styleable.Toolbar_subtitleTextColor))
      setSubtitleTextColor(tintTypedArray.getColor(R.styleable.Toolbar_subtitleTextColor, -1)); 
    tintTypedArray.recycle();
  }
  
  private void addCustomViewsWithGravity(List<View> paramList, int paramInt) {
    boolean bool = true;
    if (ViewCompat.getLayoutDirection((View)this) != 1)
      bool = false; 
    int j = getChildCount();
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection((View)this));
    paramList.clear();
    if (bool) {
      for (paramInt = j - 1; paramInt >= 0; paramInt--) {
        View view = getChildAt(paramInt);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mViewType == 0 && shouldLayout(view) && getChildHorizontalGravity(layoutParams.gravity) == i)
          paramList.add(view); 
      } 
    } else {
      for (paramInt = 0; paramInt < j; paramInt++) {
        View view = getChildAt(paramInt);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mViewType == 0 && shouldLayout(view) && getChildHorizontalGravity(layoutParams.gravity) == i)
          paramList.add(view); 
      } 
    } 
  }
  
  private void addSystemView(View paramView, boolean paramBoolean) {
    LayoutParams layoutParams;
    ViewGroup.LayoutParams layoutParams1 = paramView.getLayoutParams();
    if (layoutParams1 == null) {
      layoutParams = generateDefaultLayoutParams();
    } else if (!checkLayoutParams((ViewGroup.LayoutParams)layoutParams)) {
      layoutParams = generateLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } else {
      layoutParams = layoutParams;
    } 
    layoutParams.mViewType = 1;
    if (paramBoolean && this.mExpandedActionView != null) {
      paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.mHiddenViews.add(paramView);
      return;
    } 
    addView(paramView, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void ensureContentInsets() {
    if (this.mContentInsets == null)
      this.mContentInsets = new RtlSpacingHelper(); 
  }
  
  private void ensureLogoView() {
    if (this.mLogoView == null)
      this.mLogoView = new AppCompatImageView(getContext()); 
  }
  
  private void ensureMenu() {
    ensureMenuView();
    if (this.mMenuView.peekMenu() == null) {
      MenuBuilder menuBuilder = (MenuBuilder)this.mMenuView.getMenu();
      if (this.mExpandedMenuPresenter == null)
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(); 
      this.mMenuView.setExpandedActionViewsExclusive(true);
      menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    } 
  }
  
  private void ensureMenuView() {
    if (this.mMenuView == null) {
      this.mMenuView = new ActionMenuView(getContext());
      this.mMenuView.setPopupTheme(this.mPopupTheme);
      this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
      this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
      LayoutParams layoutParams = generateDefaultLayoutParams();
      layoutParams.gravity = 0x800005 | this.mButtonGravity & 0x70;
      this.mMenuView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      addSystemView((View)this.mMenuView, false);
    } 
  }
  
  private void ensureNavButtonView() {
    if (this.mNavButtonView == null) {
      this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      LayoutParams layoutParams = generateDefaultLayoutParams();
      layoutParams.gravity = 0x800003 | this.mButtonGravity & 0x70;
      this.mNavButtonView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  private int getChildHorizontalGravity(int paramInt) {
    int j = ViewCompat.getLayoutDirection((View)this);
    int i = GravityCompat.getAbsoluteGravity(paramInt, j) & 0x7;
    paramInt = i;
    switch (i) {
      default:
        if (j == 1)
          paramInt = 5; 
        break;
      case 1:
      case 3:
      case 5:
        return paramInt;
    } 
    paramInt = 3;
  }
  
  private int getChildTop(View paramView, int paramInt) {
    int i;
    int k;
    int m;
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = paramView.getMeasuredHeight();
    if (paramInt > 0) {
      paramInt = (j - paramInt) / 2;
    } else {
      paramInt = 0;
    } 
    switch (getChildVerticalGravity(layoutParams.gravity)) {
      default:
        k = getPaddingTop();
        paramInt = getPaddingBottom();
        m = getHeight();
        i = (m - k - paramInt - j) / 2;
        if (i < layoutParams.topMargin) {
          paramInt = layoutParams.topMargin;
          return k + paramInt;
        } 
        break;
      case 48:
        return getPaddingTop() - paramInt;
      case 80:
        return getHeight() - getPaddingBottom() - j - layoutParams.bottomMargin - paramInt;
    } 
    j = m - paramInt - j - i - k;
    paramInt = i;
    if (j < layoutParams.bottomMargin)
      paramInt = Math.max(0, i - layoutParams.bottomMargin - j); 
    return k + paramInt;
  }
  
  private int getChildVerticalGravity(int paramInt) {
    int i = paramInt & 0x70;
    paramInt = i;
    switch (i) {
      default:
        paramInt = this.mGravity & 0x70;
        break;
      case 16:
      case 48:
      case 80:
        break;
    } 
    return paramInt;
  }
  
  private int getHorizontalMargins(View paramView) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
  }
  
  private MenuInflater getMenuInflater() {
    return (MenuInflater)new SupportMenuInflater(getContext());
  }
  
  private int getVerticalMargins(View paramView) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
  }
  
  private int getViewListMeasuredWidth(List<View> paramList, int[] paramArrayOfint) {
    int m = paramArrayOfint[0];
    int k = paramArrayOfint[1];
    int j = 0;
    int n = paramList.size();
    for (int i = 0; i < n; i++) {
      View view = paramList.get(i);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      m = layoutParams.leftMargin - m;
      k = layoutParams.rightMargin - k;
      int i1 = Math.max(0, m);
      int i2 = Math.max(0, k);
      m = Math.max(0, -m);
      k = Math.max(0, -k);
      j += view.getMeasuredWidth() + i1 + i2;
    } 
    return j;
  }
  
  private boolean isChildOrHidden(View paramView) {
    return (paramView.getParent() == this || this.mHiddenViews.contains(paramView));
  }
  
  private static boolean isCustomView(View paramView) {
    return (((LayoutParams)paramView.getLayoutParams()).mViewType == 0);
  }
  
  private int layoutChildLeft(View paramView, int paramInt1, int[] paramArrayOfint, int paramInt2) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = layoutParams.leftMargin - paramArrayOfint[0];
    paramInt1 += Math.max(0, i);
    paramArrayOfint[0] = Math.max(0, -i);
    paramInt2 = getChildTop(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 + layoutParams.rightMargin + i;
  }
  
  private int layoutChildRight(View paramView, int paramInt1, int[] paramArrayOfint, int paramInt2) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = layoutParams.rightMargin - paramArrayOfint[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfint[1] = Math.max(0, -i);
    paramInt2 = getChildTop(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - layoutParams.leftMargin + i;
  }
  
  private int measureChildCollapseMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = marginLayoutParams.leftMargin - paramArrayOfint[0];
    int j = marginLayoutParams.rightMargin - paramArrayOfint[1];
    int k = Math.max(0, i) + Math.max(0, j);
    paramArrayOfint[0] = Math.max(0, -i);
    paramArrayOfint[1] = Math.max(0, -j);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + k + paramInt2, marginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + paramInt4, marginLayoutParams.height));
    return paramView.getMeasuredWidth() + k;
  }
  
  private void measureChildConstrained(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + paramInt2, marginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + paramInt4, marginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824) {
      paramInt1 = paramInt2;
      if (paramInt5 >= 0) {
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt5);
        } else {
          paramInt1 = paramInt5;
        } 
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      } 
    } 
    paramView.measure(i, paramInt1);
  }
  
  private void postShowOverflowMenu() {
    removeCallbacks(this.mShowOverflowMenuRunnable);
    post(this.mShowOverflowMenuRunnable);
  }
  
  private boolean shouldCollapse() {
    if (this.mCollapsible) {
      int j = getChildCount();
      int i = 0;
      while (i < j) {
        View view = getChildAt(i);
        if (!shouldLayout(view) || view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
          i++;
          continue;
        } 
        return false;
      } 
      return true;
    } 
    return false;
  }
  
  private boolean shouldLayout(View paramView) {
    return (paramView != null && paramView.getParent() == this && paramView.getVisibility() != 8);
  }
  
  void addChildrenForExpandedActionView() {
    for (int i = this.mHiddenViews.size() - 1; i >= 0; i--)
      addView(this.mHiddenViews.get(i)); 
    this.mHiddenViews.clear();
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public boolean canShowOverflowMenu() {
    return (getVisibility() == 0 && this.mMenuView != null && this.mMenuView.isOverflowReserved());
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (super.checkLayoutParams(paramLayoutParams) && paramLayoutParams instanceof LayoutParams);
  }
  
  public void collapseActionView() {
    MenuItemImpl menuItemImpl;
    if (this.mExpandedMenuPresenter == null) {
      menuItemImpl = null;
    } else {
      menuItemImpl = this.mExpandedMenuPresenter.mCurrentExpandedItem;
    } 
    if (menuItemImpl != null)
      menuItemImpl.collapseActionView(); 
  }
  
  public void dismissPopupMenus() {
    if (this.mMenuView != null)
      this.mMenuView.dismissPopupMenus(); 
  }
  
  void ensureCollapseButtonView() {
    if (this.mCollapseButtonView == null) {
      this.mCollapseButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
      this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
      LayoutParams layoutParams = generateDefaultLayoutParams();
      layoutParams.gravity = 0x800003 | this.mButtonGravity & 0x70;
      layoutParams.mViewType = 2;
      this.mCollapseButtonView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
              Toolbar.this.collapseActionView();
            }
          });
    } 
  }
  
  protected LayoutParams generateDefaultLayoutParams() {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams) ? new LayoutParams((LayoutParams)paramLayoutParams) : ((paramLayoutParams instanceof ActionBar.LayoutParams) ? new LayoutParams((ActionBar.LayoutParams)paramLayoutParams) : ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams)));
  }
  
  public int getContentInsetEnd() {
    return (this.mContentInsets != null) ? this.mContentInsets.getEnd() : 0;
  }
  
  public int getContentInsetEndWithActions() {
    return (this.mContentInsetEndWithActions != Integer.MIN_VALUE) ? this.mContentInsetEndWithActions : getContentInsetEnd();
  }
  
  public int getContentInsetLeft() {
    return (this.mContentInsets != null) ? this.mContentInsets.getLeft() : 0;
  }
  
  public int getContentInsetRight() {
    return (this.mContentInsets != null) ? this.mContentInsets.getRight() : 0;
  }
  
  public int getContentInsetStart() {
    return (this.mContentInsets != null) ? this.mContentInsets.getStart() : 0;
  }
  
  public int getContentInsetStartWithNavigation() {
    return (this.mContentInsetStartWithNavigation != Integer.MIN_VALUE) ? this.mContentInsetStartWithNavigation : getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd() {
    boolean bool = false;
    if (this.mMenuView != null) {
      MenuBuilder menuBuilder = this.mMenuView.peekMenu();
      if (menuBuilder != null && menuBuilder.hasVisibleItems()) {
        bool = true;
      } else {
        bool = false;
      } 
    } 
    return bool ? Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0)) : getContentInsetEnd();
  }
  
  public int getCurrentContentInsetLeft() {
    return (ViewCompat.getLayoutDirection((View)this) == 1) ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight() {
    return (ViewCompat.getLayoutDirection((View)this) == 1) ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart() {
    return (getNavigationIcon() != null) ? Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0)) : getContentInsetStart();
  }
  
  public Drawable getLogo() {
    return (this.mLogoView != null) ? this.mLogoView.getDrawable() : null;
  }
  
  public CharSequence getLogoDescription() {
    return (this.mLogoView != null) ? this.mLogoView.getContentDescription() : null;
  }
  
  public Menu getMenu() {
    ensureMenu();
    return this.mMenuView.getMenu();
  }
  
  @Nullable
  public CharSequence getNavigationContentDescription() {
    return (this.mNavButtonView != null) ? this.mNavButtonView.getContentDescription() : null;
  }
  
  @Nullable
  public Drawable getNavigationIcon() {
    return (this.mNavButtonView != null) ? this.mNavButtonView.getDrawable() : null;
  }
  
  @Nullable
  public Drawable getOverflowIcon() {
    ensureMenu();
    return this.mMenuView.getOverflowIcon();
  }
  
  public int getPopupTheme() {
    return this.mPopupTheme;
  }
  
  public CharSequence getSubtitle() {
    return this.mSubtitleText;
  }
  
  public CharSequence getTitle() {
    return this.mTitleText;
  }
  
  public int getTitleMarginBottom() {
    return this.mTitleMarginBottom;
  }
  
  public int getTitleMarginEnd() {
    return this.mTitleMarginEnd;
  }
  
  public int getTitleMarginStart() {
    return this.mTitleMarginStart;
  }
  
  public int getTitleMarginTop() {
    return this.mTitleMarginTop;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public DecorToolbar getWrapper() {
    if (this.mWrapper == null)
      this.mWrapper = new ToolbarWidgetWrapper(this, true); 
    return this.mWrapper;
  }
  
  public boolean hasExpandedActionView() {
    return (this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null);
  }
  
  public boolean hideOverflowMenu() {
    return (this.mMenuView != null && this.mMenuView.hideOverflowMenu());
  }
  
  public void inflateMenu(@MenuRes int paramInt) {
    getMenuInflater().inflate(paramInt, getMenu());
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public boolean isOverflowMenuShowPending() {
    return (this.mMenuView != null && this.mMenuView.isOverflowMenuShowPending());
  }
  
  public boolean isOverflowMenuShowing() {
    return (this.mMenuView != null && this.mMenuView.isOverflowMenuShowing());
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public boolean isTitleTruncated() {
    if (this.mTitleTextView != null) {
      Layout layout = this.mTitleTextView.getLayout();
      if (layout != null) {
        int j = layout.getLineCount();
        int i = 0;
        while (true) {
          if (i < j) {
            if (layout.getEllipsisCount(i) > 0)
              return true; 
            i++;
            continue;
          } 
          return false;
        } 
      } 
    } 
    return false;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    removeCallbacks(this.mShowOverflowMenuRunnable);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent) {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 9)
      this.mEatingHover = false; 
    if (!this.mEatingHover) {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if (i == 9 && !bool)
        this.mEatingHover = true; 
    } 
    if (i == 10 || i == 3)
      this.mEatingHover = false; 
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic getLayoutDirection : (Landroid/view/View;)I
    //   4: iconst_1
    //   5: if_icmpne -> 911
    //   8: iconst_1
    //   9: istore #8
    //   11: aload_0
    //   12: invokevirtual getWidth : ()I
    //   15: istore #12
    //   17: aload_0
    //   18: invokevirtual getHeight : ()I
    //   21: istore #14
    //   23: aload_0
    //   24: invokevirtual getPaddingLeft : ()I
    //   27: istore #11
    //   29: aload_0
    //   30: invokevirtual getPaddingRight : ()I
    //   33: istore #13
    //   35: aload_0
    //   36: invokevirtual getPaddingTop : ()I
    //   39: istore #10
    //   41: aload_0
    //   42: invokevirtual getPaddingBottom : ()I
    //   45: istore #15
    //   47: iload #11
    //   49: istore #4
    //   51: iload #12
    //   53: iload #13
    //   55: isub
    //   56: istore #7
    //   58: aload_0
    //   59: getfield mTempMargins : [I
    //   62: astore #19
    //   64: aload #19
    //   66: iconst_1
    //   67: iconst_0
    //   68: iastore
    //   69: aload #19
    //   71: iconst_0
    //   72: iconst_0
    //   73: iastore
    //   74: aload_0
    //   75: invokestatic getMinimumHeight : (Landroid/view/View;)I
    //   78: istore_2
    //   79: iload_2
    //   80: iflt -> 917
    //   83: iload_2
    //   84: iload #5
    //   86: iload_3
    //   87: isub
    //   88: invokestatic min : (II)I
    //   91: istore #6
    //   93: iload #4
    //   95: istore_2
    //   96: iload #7
    //   98: istore_3
    //   99: aload_0
    //   100: aload_0
    //   101: getfield mNavButtonView : Landroid/widget/ImageButton;
    //   104: invokespecial shouldLayout : (Landroid/view/View;)Z
    //   107: ifeq -> 133
    //   110: iload #8
    //   112: ifeq -> 923
    //   115: aload_0
    //   116: aload_0
    //   117: getfield mNavButtonView : Landroid/widget/ImageButton;
    //   120: iload #7
    //   122: aload #19
    //   124: iload #6
    //   126: invokespecial layoutChildRight : (Landroid/view/View;I[II)I
    //   129: istore_3
    //   130: iload #4
    //   132: istore_2
    //   133: iload_2
    //   134: istore #4
    //   136: iload_3
    //   137: istore #5
    //   139: aload_0
    //   140: aload_0
    //   141: getfield mCollapseButtonView : Landroid/widget/ImageButton;
    //   144: invokespecial shouldLayout : (Landroid/view/View;)Z
    //   147: ifeq -> 173
    //   150: iload #8
    //   152: ifeq -> 944
    //   155: aload_0
    //   156: aload_0
    //   157: getfield mCollapseButtonView : Landroid/widget/ImageButton;
    //   160: iload_3
    //   161: aload #19
    //   163: iload #6
    //   165: invokespecial layoutChildRight : (Landroid/view/View;I[II)I
    //   168: istore #5
    //   170: iload_2
    //   171: istore #4
    //   173: iload #4
    //   175: istore_3
    //   176: iload #5
    //   178: istore_2
    //   179: aload_0
    //   180: aload_0
    //   181: getfield mMenuView : Landroid/support/v7/widget/ActionMenuView;
    //   184: invokespecial shouldLayout : (Landroid/view/View;)Z
    //   187: ifeq -> 213
    //   190: iload #8
    //   192: ifeq -> 965
    //   195: aload_0
    //   196: aload_0
    //   197: getfield mMenuView : Landroid/support/v7/widget/ActionMenuView;
    //   200: iload #4
    //   202: aload #19
    //   204: iload #6
    //   206: invokespecial layoutChildLeft : (Landroid/view/View;I[II)I
    //   209: istore_3
    //   210: iload #5
    //   212: istore_2
    //   213: aload_0
    //   214: invokevirtual getCurrentContentInsetLeft : ()I
    //   217: istore #4
    //   219: aload_0
    //   220: invokevirtual getCurrentContentInsetRight : ()I
    //   223: istore #5
    //   225: aload #19
    //   227: iconst_0
    //   228: iconst_0
    //   229: iload #4
    //   231: iload_3
    //   232: isub
    //   233: invokestatic max : (II)I
    //   236: iastore
    //   237: aload #19
    //   239: iconst_1
    //   240: iconst_0
    //   241: iload #5
    //   243: iload #12
    //   245: iload #13
    //   247: isub
    //   248: iload_2
    //   249: isub
    //   250: isub
    //   251: invokestatic max : (II)I
    //   254: iastore
    //   255: iload_3
    //   256: iload #4
    //   258: invokestatic max : (II)I
    //   261: istore #4
    //   263: iload_2
    //   264: iload #12
    //   266: iload #13
    //   268: isub
    //   269: iload #5
    //   271: isub
    //   272: invokestatic min : (II)I
    //   275: istore #5
    //   277: iload #4
    //   279: istore_2
    //   280: iload #5
    //   282: istore_3
    //   283: aload_0
    //   284: aload_0
    //   285: getfield mExpandedActionView : Landroid/view/View;
    //   288: invokespecial shouldLayout : (Landroid/view/View;)Z
    //   291: ifeq -> 317
    //   294: iload #8
    //   296: ifeq -> 986
    //   299: aload_0
    //   300: aload_0
    //   301: getfield mExpandedActionView : Landroid/view/View;
    //   304: iload #5
    //   306: aload #19
    //   308: iload #6
    //   310: invokespecial layoutChildRight : (Landroid/view/View;I[II)I
    //   313: istore_3
    //   314: iload #4
    //   316: istore_2
    //   317: iload_2
    //   318: istore #4
    //   320: iload_3
    //   321: istore #5
    //   323: aload_0
    //   324: aload_0
    //   325: getfield mLogoView : Landroid/widget/ImageView;
    //   328: invokespecial shouldLayout : (Landroid/view/View;)Z
    //   331: ifeq -> 357
    //   334: iload #8
    //   336: ifeq -> 1007
    //   339: aload_0
    //   340: aload_0
    //   341: getfield mLogoView : Landroid/widget/ImageView;
    //   344: iload_3
    //   345: aload #19
    //   347: iload #6
    //   349: invokespecial layoutChildRight : (Landroid/view/View;I[II)I
    //   352: istore #5
    //   354: iload_2
    //   355: istore #4
    //   357: aload_0
    //   358: aload_0
    //   359: getfield mTitleTextView : Landroid/widget/TextView;
    //   362: invokespecial shouldLayout : (Landroid/view/View;)Z
    //   365: istore_1
    //   366: aload_0
    //   367: aload_0
    //   368: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   371: invokespecial shouldLayout : (Landroid/view/View;)Z
    //   374: istore #16
    //   376: iconst_0
    //   377: istore_2
    //   378: iload_1
    //   379: ifeq -> 416
    //   382: aload_0
    //   383: getfield mTitleTextView : Landroid/widget/TextView;
    //   386: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   389: checkcast android/support/v7/widget/Toolbar$LayoutParams
    //   392: astore #17
    //   394: iconst_0
    //   395: aload #17
    //   397: getfield topMargin : I
    //   400: aload_0
    //   401: getfield mTitleTextView : Landroid/widget/TextView;
    //   404: invokevirtual getMeasuredHeight : ()I
    //   407: iadd
    //   408: aload #17
    //   410: getfield bottomMargin : I
    //   413: iadd
    //   414: iadd
    //   415: istore_2
    //   416: iload_2
    //   417: istore #9
    //   419: iload #16
    //   421: ifeq -> 459
    //   424: aload_0
    //   425: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   428: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   431: checkcast android/support/v7/widget/Toolbar$LayoutParams
    //   434: astore #17
    //   436: iload_2
    //   437: aload #17
    //   439: getfield topMargin : I
    //   442: aload_0
    //   443: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   446: invokevirtual getMeasuredHeight : ()I
    //   449: iadd
    //   450: aload #17
    //   452: getfield bottomMargin : I
    //   455: iadd
    //   456: iadd
    //   457: istore #9
    //   459: iload_1
    //   460: ifne -> 474
    //   463: iload #4
    //   465: istore_3
    //   466: iload #5
    //   468: istore_2
    //   469: iload #16
    //   471: ifeq -> 852
    //   474: iload_1
    //   475: ifeq -> 1028
    //   478: aload_0
    //   479: getfield mTitleTextView : Landroid/widget/TextView;
    //   482: astore #17
    //   484: iload #16
    //   486: ifeq -> 1037
    //   489: aload_0
    //   490: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   493: astore #18
    //   495: aload #17
    //   497: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   500: checkcast android/support/v7/widget/Toolbar$LayoutParams
    //   503: astore #17
    //   505: aload #18
    //   507: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   510: checkcast android/support/v7/widget/Toolbar$LayoutParams
    //   513: astore #18
    //   515: iload_1
    //   516: ifeq -> 529
    //   519: aload_0
    //   520: getfield mTitleTextView : Landroid/widget/TextView;
    //   523: invokevirtual getMeasuredWidth : ()I
    //   526: ifgt -> 544
    //   529: iload #16
    //   531: ifeq -> 1046
    //   534: aload_0
    //   535: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   538: invokevirtual getMeasuredWidth : ()I
    //   541: ifle -> 1046
    //   544: iconst_1
    //   545: istore #7
    //   547: aload_0
    //   548: getfield mGravity : I
    //   551: bipush #112
    //   553: iand
    //   554: lookupswitch default -> 580, 48 -> 1052, 80 -> 1126
    //   580: iload #14
    //   582: iload #10
    //   584: isub
    //   585: iload #15
    //   587: isub
    //   588: iload #9
    //   590: isub
    //   591: iconst_2
    //   592: idiv
    //   593: istore_3
    //   594: iload_3
    //   595: aload #17
    //   597: getfield topMargin : I
    //   600: aload_0
    //   601: getfield mTitleMarginTop : I
    //   604: iadd
    //   605: if_icmpge -> 1071
    //   608: aload #17
    //   610: getfield topMargin : I
    //   613: aload_0
    //   614: getfield mTitleMarginTop : I
    //   617: iadd
    //   618: istore_2
    //   619: iload #10
    //   621: iload_2
    //   622: iadd
    //   623: istore_2
    //   624: iload #8
    //   626: ifeq -> 1154
    //   629: iload #7
    //   631: ifeq -> 1149
    //   634: aload_0
    //   635: getfield mTitleMarginStart : I
    //   638: istore_3
    //   639: iload_3
    //   640: aload #19
    //   642: iconst_1
    //   643: iaload
    //   644: isub
    //   645: istore_3
    //   646: iload #5
    //   648: iconst_0
    //   649: iload_3
    //   650: invokestatic max : (II)I
    //   653: isub
    //   654: istore #5
    //   656: aload #19
    //   658: iconst_1
    //   659: iconst_0
    //   660: iload_3
    //   661: ineg
    //   662: invokestatic max : (II)I
    //   665: iastore
    //   666: iload #5
    //   668: istore #9
    //   670: iload #5
    //   672: istore_3
    //   673: iload #9
    //   675: istore #8
    //   677: iload_2
    //   678: istore #10
    //   680: iload_1
    //   681: ifeq -> 752
    //   684: aload_0
    //   685: getfield mTitleTextView : Landroid/widget/TextView;
    //   688: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   691: checkcast android/support/v7/widget/Toolbar$LayoutParams
    //   694: astore #17
    //   696: iload #9
    //   698: aload_0
    //   699: getfield mTitleTextView : Landroid/widget/TextView;
    //   702: invokevirtual getMeasuredWidth : ()I
    //   705: isub
    //   706: istore #8
    //   708: iload_2
    //   709: aload_0
    //   710: getfield mTitleTextView : Landroid/widget/TextView;
    //   713: invokevirtual getMeasuredHeight : ()I
    //   716: iadd
    //   717: istore #10
    //   719: aload_0
    //   720: getfield mTitleTextView : Landroid/widget/TextView;
    //   723: iload #8
    //   725: iload_2
    //   726: iload #9
    //   728: iload #10
    //   730: invokevirtual layout : (IIII)V
    //   733: iload #8
    //   735: aload_0
    //   736: getfield mTitleMarginEnd : I
    //   739: isub
    //   740: istore #8
    //   742: iload #10
    //   744: aload #17
    //   746: getfield bottomMargin : I
    //   749: iadd
    //   750: istore #10
    //   752: iload_3
    //   753: istore #9
    //   755: iload #16
    //   757: ifeq -> 830
    //   760: aload_0
    //   761: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   764: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   767: checkcast android/support/v7/widget/Toolbar$LayoutParams
    //   770: astore #17
    //   772: iload #10
    //   774: aload #17
    //   776: getfield topMargin : I
    //   779: iadd
    //   780: istore_2
    //   781: aload_0
    //   782: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   785: invokevirtual getMeasuredWidth : ()I
    //   788: istore #9
    //   790: iload_2
    //   791: aload_0
    //   792: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   795: invokevirtual getMeasuredHeight : ()I
    //   798: iadd
    //   799: istore #10
    //   801: aload_0
    //   802: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   805: iload_3
    //   806: iload #9
    //   808: isub
    //   809: iload_2
    //   810: iload_3
    //   811: iload #10
    //   813: invokevirtual layout : (IIII)V
    //   816: iload_3
    //   817: aload_0
    //   818: getfield mTitleMarginEnd : I
    //   821: isub
    //   822: istore #9
    //   824: aload #17
    //   826: getfield bottomMargin : I
    //   829: istore_2
    //   830: iload #4
    //   832: istore_3
    //   833: iload #5
    //   835: istore_2
    //   836: iload #7
    //   838: ifeq -> 852
    //   841: iload #8
    //   843: iload #9
    //   845: invokestatic min : (II)I
    //   848: istore_2
    //   849: iload #4
    //   851: istore_3
    //   852: aload_0
    //   853: aload_0
    //   854: getfield mTempViews : Ljava/util/ArrayList;
    //   857: iconst_3
    //   858: invokespecial addCustomViewsWithGravity : (Ljava/util/List;I)V
    //   861: aload_0
    //   862: getfield mTempViews : Ljava/util/ArrayList;
    //   865: invokevirtual size : ()I
    //   868: istore #5
    //   870: iconst_0
    //   871: istore #4
    //   873: iload #4
    //   875: iload #5
    //   877: if_icmpge -> 1387
    //   880: aload_0
    //   881: aload_0
    //   882: getfield mTempViews : Ljava/util/ArrayList;
    //   885: iload #4
    //   887: invokevirtual get : (I)Ljava/lang/Object;
    //   890: checkcast android/view/View
    //   893: iload_3
    //   894: aload #19
    //   896: iload #6
    //   898: invokespecial layoutChildLeft : (Landroid/view/View;I[II)I
    //   901: istore_3
    //   902: iload #4
    //   904: iconst_1
    //   905: iadd
    //   906: istore #4
    //   908: goto -> 873
    //   911: iconst_0
    //   912: istore #8
    //   914: goto -> 11
    //   917: iconst_0
    //   918: istore #6
    //   920: goto -> 93
    //   923: aload_0
    //   924: aload_0
    //   925: getfield mNavButtonView : Landroid/widget/ImageButton;
    //   928: iload #4
    //   930: aload #19
    //   932: iload #6
    //   934: invokespecial layoutChildLeft : (Landroid/view/View;I[II)I
    //   937: istore_2
    //   938: iload #7
    //   940: istore_3
    //   941: goto -> 133
    //   944: aload_0
    //   945: aload_0
    //   946: getfield mCollapseButtonView : Landroid/widget/ImageButton;
    //   949: iload_2
    //   950: aload #19
    //   952: iload #6
    //   954: invokespecial layoutChildLeft : (Landroid/view/View;I[II)I
    //   957: istore #4
    //   959: iload_3
    //   960: istore #5
    //   962: goto -> 173
    //   965: aload_0
    //   966: aload_0
    //   967: getfield mMenuView : Landroid/support/v7/widget/ActionMenuView;
    //   970: iload #5
    //   972: aload #19
    //   974: iload #6
    //   976: invokespecial layoutChildRight : (Landroid/view/View;I[II)I
    //   979: istore_2
    //   980: iload #4
    //   982: istore_3
    //   983: goto -> 213
    //   986: aload_0
    //   987: aload_0
    //   988: getfield mExpandedActionView : Landroid/view/View;
    //   991: iload #4
    //   993: aload #19
    //   995: iload #6
    //   997: invokespecial layoutChildLeft : (Landroid/view/View;I[II)I
    //   1000: istore_2
    //   1001: iload #5
    //   1003: istore_3
    //   1004: goto -> 317
    //   1007: aload_0
    //   1008: aload_0
    //   1009: getfield mLogoView : Landroid/widget/ImageView;
    //   1012: iload_2
    //   1013: aload #19
    //   1015: iload #6
    //   1017: invokespecial layoutChildLeft : (Landroid/view/View;I[II)I
    //   1020: istore #4
    //   1022: iload_3
    //   1023: istore #5
    //   1025: goto -> 357
    //   1028: aload_0
    //   1029: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   1032: astore #17
    //   1034: goto -> 484
    //   1037: aload_0
    //   1038: getfield mTitleTextView : Landroid/widget/TextView;
    //   1041: astore #18
    //   1043: goto -> 495
    //   1046: iconst_0
    //   1047: istore #7
    //   1049: goto -> 547
    //   1052: aload_0
    //   1053: invokevirtual getPaddingTop : ()I
    //   1056: aload #17
    //   1058: getfield topMargin : I
    //   1061: iadd
    //   1062: aload_0
    //   1063: getfield mTitleMarginTop : I
    //   1066: iadd
    //   1067: istore_2
    //   1068: goto -> 624
    //   1071: iload #14
    //   1073: iload #15
    //   1075: isub
    //   1076: iload #9
    //   1078: isub
    //   1079: iload_3
    //   1080: isub
    //   1081: iload #10
    //   1083: isub
    //   1084: istore #9
    //   1086: iload_3
    //   1087: istore_2
    //   1088: iload #9
    //   1090: aload #17
    //   1092: getfield bottomMargin : I
    //   1095: aload_0
    //   1096: getfield mTitleMarginBottom : I
    //   1099: iadd
    //   1100: if_icmpge -> 619
    //   1103: iconst_0
    //   1104: iload_3
    //   1105: aload #18
    //   1107: getfield bottomMargin : I
    //   1110: aload_0
    //   1111: getfield mTitleMarginBottom : I
    //   1114: iadd
    //   1115: iload #9
    //   1117: isub
    //   1118: isub
    //   1119: invokestatic max : (II)I
    //   1122: istore_2
    //   1123: goto -> 619
    //   1126: iload #14
    //   1128: iload #15
    //   1130: isub
    //   1131: aload #18
    //   1133: getfield bottomMargin : I
    //   1136: isub
    //   1137: aload_0
    //   1138: getfield mTitleMarginBottom : I
    //   1141: isub
    //   1142: iload #9
    //   1144: isub
    //   1145: istore_2
    //   1146: goto -> 624
    //   1149: iconst_0
    //   1150: istore_3
    //   1151: goto -> 639
    //   1154: iload #7
    //   1156: ifeq -> 1382
    //   1159: aload_0
    //   1160: getfield mTitleMarginStart : I
    //   1163: istore_3
    //   1164: iload_3
    //   1165: aload #19
    //   1167: iconst_0
    //   1168: iaload
    //   1169: isub
    //   1170: istore #8
    //   1172: iload #4
    //   1174: iconst_0
    //   1175: iload #8
    //   1177: invokestatic max : (II)I
    //   1180: iadd
    //   1181: istore_3
    //   1182: aload #19
    //   1184: iconst_0
    //   1185: iconst_0
    //   1186: iload #8
    //   1188: ineg
    //   1189: invokestatic max : (II)I
    //   1192: iastore
    //   1193: iload_3
    //   1194: istore #9
    //   1196: iload_3
    //   1197: istore #4
    //   1199: iload #9
    //   1201: istore #8
    //   1203: iload_2
    //   1204: istore #10
    //   1206: iload_1
    //   1207: ifeq -> 1278
    //   1210: aload_0
    //   1211: getfield mTitleTextView : Landroid/widget/TextView;
    //   1214: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1217: checkcast android/support/v7/widget/Toolbar$LayoutParams
    //   1220: astore #17
    //   1222: iload #9
    //   1224: aload_0
    //   1225: getfield mTitleTextView : Landroid/widget/TextView;
    //   1228: invokevirtual getMeasuredWidth : ()I
    //   1231: iadd
    //   1232: istore #8
    //   1234: iload_2
    //   1235: aload_0
    //   1236: getfield mTitleTextView : Landroid/widget/TextView;
    //   1239: invokevirtual getMeasuredHeight : ()I
    //   1242: iadd
    //   1243: istore #10
    //   1245: aload_0
    //   1246: getfield mTitleTextView : Landroid/widget/TextView;
    //   1249: iload #9
    //   1251: iload_2
    //   1252: iload #8
    //   1254: iload #10
    //   1256: invokevirtual layout : (IIII)V
    //   1259: iload #8
    //   1261: aload_0
    //   1262: getfield mTitleMarginEnd : I
    //   1265: iadd
    //   1266: istore #8
    //   1268: iload #10
    //   1270: aload #17
    //   1272: getfield bottomMargin : I
    //   1275: iadd
    //   1276: istore #10
    //   1278: iload #4
    //   1280: istore #9
    //   1282: iload #16
    //   1284: ifeq -> 1360
    //   1287: aload_0
    //   1288: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   1291: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1294: checkcast android/support/v7/widget/Toolbar$LayoutParams
    //   1297: astore #17
    //   1299: iload #10
    //   1301: aload #17
    //   1303: getfield topMargin : I
    //   1306: iadd
    //   1307: istore_2
    //   1308: iload #4
    //   1310: aload_0
    //   1311: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   1314: invokevirtual getMeasuredWidth : ()I
    //   1317: iadd
    //   1318: istore #9
    //   1320: iload_2
    //   1321: aload_0
    //   1322: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   1325: invokevirtual getMeasuredHeight : ()I
    //   1328: iadd
    //   1329: istore #10
    //   1331: aload_0
    //   1332: getfield mSubtitleTextView : Landroid/widget/TextView;
    //   1335: iload #4
    //   1337: iload_2
    //   1338: iload #9
    //   1340: iload #10
    //   1342: invokevirtual layout : (IIII)V
    //   1345: iload #9
    //   1347: aload_0
    //   1348: getfield mTitleMarginEnd : I
    //   1351: iadd
    //   1352: istore #9
    //   1354: aload #17
    //   1356: getfield bottomMargin : I
    //   1359: istore_2
    //   1360: iload #5
    //   1362: istore_2
    //   1363: iload #7
    //   1365: ifeq -> 852
    //   1368: iload #8
    //   1370: iload #9
    //   1372: invokestatic max : (II)I
    //   1375: istore_3
    //   1376: iload #5
    //   1378: istore_2
    //   1379: goto -> 852
    //   1382: iconst_0
    //   1383: istore_3
    //   1384: goto -> 1164
    //   1387: aload_0
    //   1388: aload_0
    //   1389: getfield mTempViews : Ljava/util/ArrayList;
    //   1392: iconst_5
    //   1393: invokespecial addCustomViewsWithGravity : (Ljava/util/List;I)V
    //   1396: aload_0
    //   1397: getfield mTempViews : Ljava/util/ArrayList;
    //   1400: invokevirtual size : ()I
    //   1403: istore #7
    //   1405: iconst_0
    //   1406: istore #5
    //   1408: iload_2
    //   1409: istore #4
    //   1411: iload #5
    //   1413: istore_2
    //   1414: iload_2
    //   1415: iload #7
    //   1417: if_icmpge -> 1450
    //   1420: aload_0
    //   1421: aload_0
    //   1422: getfield mTempViews : Ljava/util/ArrayList;
    //   1425: iload_2
    //   1426: invokevirtual get : (I)Ljava/lang/Object;
    //   1429: checkcast android/view/View
    //   1432: iload #4
    //   1434: aload #19
    //   1436: iload #6
    //   1438: invokespecial layoutChildRight : (Landroid/view/View;I[II)I
    //   1441: istore #4
    //   1443: iload_2
    //   1444: iconst_1
    //   1445: iadd
    //   1446: istore_2
    //   1447: goto -> 1414
    //   1450: aload_0
    //   1451: aload_0
    //   1452: getfield mTempViews : Ljava/util/ArrayList;
    //   1455: iconst_1
    //   1456: invokespecial addCustomViewsWithGravity : (Ljava/util/List;I)V
    //   1459: aload_0
    //   1460: aload_0
    //   1461: getfield mTempViews : Ljava/util/ArrayList;
    //   1464: aload #19
    //   1466: invokespecial getViewListMeasuredWidth : (Ljava/util/List;[I)I
    //   1469: istore_2
    //   1470: iload #11
    //   1472: iload #12
    //   1474: iload #11
    //   1476: isub
    //   1477: iload #13
    //   1479: isub
    //   1480: iconst_2
    //   1481: idiv
    //   1482: iadd
    //   1483: iload_2
    //   1484: iconst_2
    //   1485: idiv
    //   1486: isub
    //   1487: istore #5
    //   1489: iload #5
    //   1491: iload_2
    //   1492: iadd
    //   1493: istore #7
    //   1495: iload #5
    //   1497: iload_3
    //   1498: if_icmpge -> 1548
    //   1501: iload_3
    //   1502: istore_2
    //   1503: aload_0
    //   1504: getfield mTempViews : Ljava/util/ArrayList;
    //   1507: invokevirtual size : ()I
    //   1510: istore #4
    //   1512: iconst_0
    //   1513: istore_3
    //   1514: iload_3
    //   1515: iload #4
    //   1517: if_icmpge -> 1570
    //   1520: aload_0
    //   1521: aload_0
    //   1522: getfield mTempViews : Ljava/util/ArrayList;
    //   1525: iload_3
    //   1526: invokevirtual get : (I)Ljava/lang/Object;
    //   1529: checkcast android/view/View
    //   1532: iload_2
    //   1533: aload #19
    //   1535: iload #6
    //   1537: invokespecial layoutChildLeft : (Landroid/view/View;I[II)I
    //   1540: istore_2
    //   1541: iload_3
    //   1542: iconst_1
    //   1543: iadd
    //   1544: istore_3
    //   1545: goto -> 1514
    //   1548: iload #5
    //   1550: istore_2
    //   1551: iload #7
    //   1553: iload #4
    //   1555: if_icmple -> 1503
    //   1558: iload #5
    //   1560: iload #7
    //   1562: iload #4
    //   1564: isub
    //   1565: isub
    //   1566: istore_2
    //   1567: goto -> 1503
    //   1570: aload_0
    //   1571: getfield mTempViews : Ljava/util/ArrayList;
    //   1574: invokevirtual clear : ()V
    //   1577: return
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int m = 0;
    int k = 0;
    int[] arrayOfInt = this.mTempMargins;
    if (ViewUtils.isLayoutRtl((View)this)) {
      i2 = 1;
      i1 = 0;
    } else {
      i2 = 0;
      i1 = 1;
    } 
    int n = 0;
    if (shouldLayout((View)this.mNavButtonView)) {
      measureChildConstrained((View)this.mNavButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
      n = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins((View)this.mNavButtonView);
      m = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins((View)this.mNavButtonView));
      k = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState((View)this.mNavButtonView));
    } 
    int i = k;
    int j = m;
    if (shouldLayout((View)this.mCollapseButtonView)) {
      measureChildConstrained((View)this.mCollapseButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
      n = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins((View)this.mCollapseButtonView);
      j = Math.max(m, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins((View)this.mCollapseButtonView));
      i = ViewUtils.combineMeasuredStates(k, ViewCompat.getMeasuredState((View)this.mCollapseButtonView));
    } 
    k = getCurrentContentInsetStart();
    int i3 = 0 + Math.max(k, n);
    arrayOfInt[i2] = Math.max(0, k - n);
    n = 0;
    k = i;
    m = j;
    if (shouldLayout((View)this.mMenuView)) {
      measureChildConstrained((View)this.mMenuView, paramInt1, i3, paramInt2, 0, this.mMaxButtonHeight);
      n = this.mMenuView.getMeasuredWidth() + getHorizontalMargins((View)this.mMenuView);
      m = Math.max(j, this.mMenuView.getMeasuredHeight() + getVerticalMargins((View)this.mMenuView));
      k = ViewUtils.combineMeasuredStates(i, ViewCompat.getMeasuredState((View)this.mMenuView));
    } 
    i = getCurrentContentInsetEnd();
    int i2 = i3 + Math.max(i, n);
    arrayOfInt[i1] = Math.max(0, i - n);
    int i1 = i2;
    i = k;
    j = m;
    if (shouldLayout(this.mExpandedActionView)) {
      i1 = i2 + measureChildCollapseMargins(this.mExpandedActionView, paramInt1, i2, paramInt2, 0, arrayOfInt);
      j = Math.max(m, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
      i = ViewUtils.combineMeasuredStates(k, ViewCompat.getMeasuredState(this.mExpandedActionView));
    } 
    k = i1;
    m = i;
    n = j;
    if (shouldLayout((View)this.mLogoView)) {
      k = i1 + measureChildCollapseMargins((View)this.mLogoView, paramInt1, i1, paramInt2, 0, arrayOfInt);
      n = Math.max(j, this.mLogoView.getMeasuredHeight() + getVerticalMargins((View)this.mLogoView));
      m = ViewUtils.combineMeasuredStates(i, ViewCompat.getMeasuredState((View)this.mLogoView));
    } 
    i3 = getChildCount();
    j = 0;
    i1 = n;
    i = m;
    n = k;
    while (j < i3) {
      View view = getChildAt(j);
      k = n;
      m = i;
      i2 = i1;
      if (((LayoutParams)view.getLayoutParams()).mViewType == 0)
        if (!shouldLayout(view)) {
          i2 = i1;
          m = i;
          k = n;
        } else {
          k = n + measureChildCollapseMargins(view, paramInt1, n, paramInt2, 0, arrayOfInt);
          i2 = Math.max(i1, view.getMeasuredHeight() + getVerticalMargins(view));
          m = ViewUtils.combineMeasuredStates(i, ViewCompat.getMeasuredState(view));
        }  
      j++;
      n = k;
      i = m;
      i1 = i2;
    } 
    m = 0;
    k = 0;
    int i4 = this.mTitleMarginTop + this.mTitleMarginBottom;
    int i5 = this.mTitleMarginStart + this.mTitleMarginEnd;
    j = i;
    if (shouldLayout((View)this.mTitleTextView)) {
      measureChildCollapseMargins((View)this.mTitleTextView, paramInt1, n + i5, paramInt2, i4, arrayOfInt);
      m = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins((View)this.mTitleTextView);
      k = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins((View)this.mTitleTextView);
      j = ViewUtils.combineMeasuredStates(i, ViewCompat.getMeasuredState((View)this.mTitleTextView));
    } 
    i2 = j;
    i3 = k;
    i = m;
    if (shouldLayout((View)this.mSubtitleTextView)) {
      i = Math.max(m, measureChildCollapseMargins((View)this.mSubtitleTextView, paramInt1, n + i5, paramInt2, k + i4, arrayOfInt));
      i3 = k + this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins((View)this.mSubtitleTextView);
      i2 = ViewUtils.combineMeasuredStates(j, ViewCompat.getMeasuredState((View)this.mSubtitleTextView));
    } 
    j = Math.max(i1, i3);
    i1 = getPaddingLeft();
    i3 = getPaddingRight();
    k = getPaddingTop();
    m = getPaddingBottom();
    i = ViewCompat.resolveSizeAndState(Math.max(n + i + i1 + i3, getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i2);
    paramInt1 = ViewCompat.resolveSizeAndState(Math.max(j + k + m, getSuggestedMinimumHeight()), paramInt2, i2 << 16);
    if (shouldCollapse())
      paramInt1 = 0; 
    setMeasuredDimension(i, paramInt1);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    if (this.mMenuView != null) {
      MenuBuilder menuBuilder = this.mMenuView.peekMenu();
    } else {
      paramParcelable = null;
    } 
    if (savedState.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && paramParcelable != null) {
      MenuItem menuItem = paramParcelable.findItem(savedState.expandedMenuItemId);
      if (menuItem != null)
        MenuItemCompat.expandActionView(menuItem); 
    } 
    if (savedState.isOverflowOpen) {
      postShowOverflowMenu();
      return;
    } 
  }
  
  public void onRtlPropertiesChanged(int paramInt) {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17)
      super.onRtlPropertiesChanged(paramInt); 
    ensureContentInsets();
    RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
    if (paramInt != 1)
      bool = false; 
    rtlSpacingHelper.setDirection(bool);
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    if (this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null)
      savedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId(); 
    savedState.isOverflowOpen = isOverflowMenuShowing();
    return (Parcelable)savedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 0)
      this.mEatingTouch = false; 
    if (!this.mEatingTouch) {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if (i == 0 && !bool)
        this.mEatingTouch = true; 
    } 
    if (i == 1 || i == 3)
      this.mEatingTouch = false; 
    return true;
  }
  
  void removeChildrenForExpandedActionView() {
    for (int i = getChildCount() - 1; i >= 0; i--) {
      View view = getChildAt(i);
      if (((LayoutParams)view.getLayoutParams()).mViewType != 2 && view != this.mMenuView) {
        removeViewAt(i);
        this.mHiddenViews.add(view);
      } 
    } 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setCollapsible(boolean paramBoolean) {
    this.mCollapsible = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt) {
    int i = paramInt;
    if (paramInt < 0)
      i = Integer.MIN_VALUE; 
    if (i != this.mContentInsetEndWithActions) {
      this.mContentInsetEndWithActions = i;
      if (getNavigationIcon() != null)
        requestLayout(); 
    } 
  }
  
  public void setContentInsetStartWithNavigation(int paramInt) {
    int i = paramInt;
    if (paramInt < 0)
      i = Integer.MIN_VALUE; 
    if (i != this.mContentInsetStartWithNavigation) {
      this.mContentInsetStartWithNavigation = i;
      if (getNavigationIcon() != null)
        requestLayout(); 
    } 
  }
  
  public void setContentInsetsAbsolute(int paramInt1, int paramInt2) {
    ensureContentInsets();
    this.mContentInsets.setAbsolute(paramInt1, paramInt2);
  }
  
  public void setContentInsetsRelative(int paramInt1, int paramInt2) {
    ensureContentInsets();
    this.mContentInsets.setRelative(paramInt1, paramInt2);
  }
  
  public void setLogo(@DrawableRes int paramInt) {
    setLogo(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable) {
    if (paramDrawable != null) {
      ensureLogoView();
      if (!isChildOrHidden((View)this.mLogoView))
        addSystemView((View)this.mLogoView, true); 
    } else if (this.mLogoView != null && isChildOrHidden((View)this.mLogoView)) {
      removeView((View)this.mLogoView);
      this.mHiddenViews.remove(this.mLogoView);
    } 
    if (this.mLogoView != null)
      this.mLogoView.setImageDrawable(paramDrawable); 
  }
  
  public void setLogoDescription(@StringRes int paramInt) {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence))
      ensureLogoView(); 
    if (this.mLogoView != null)
      this.mLogoView.setContentDescription(paramCharSequence); 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setMenu(MenuBuilder paramMenuBuilder, ActionMenuPresenter paramActionMenuPresenter) {
    if (paramMenuBuilder != null || this.mMenuView != null) {
      ensureMenuView();
      MenuBuilder menuBuilder = this.mMenuView.peekMenu();
      if (menuBuilder != paramMenuBuilder) {
        if (menuBuilder != null) {
          menuBuilder.removeMenuPresenter((MenuPresenter)this.mOuterActionMenuPresenter);
          menuBuilder.removeMenuPresenter(this.mExpandedMenuPresenter);
        } 
        if (this.mExpandedMenuPresenter == null)
          this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(); 
        paramActionMenuPresenter.setExpandedActionViewsExclusive(true);
        if (paramMenuBuilder != null) {
          paramMenuBuilder.addMenuPresenter((MenuPresenter)paramActionMenuPresenter, this.mPopupContext);
          paramMenuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        } else {
          paramActionMenuPresenter.initForMenu(this.mPopupContext, null);
          this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
          paramActionMenuPresenter.updateMenuView(true);
          this.mExpandedMenuPresenter.updateMenuView(true);
        } 
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(paramActionMenuPresenter);
        this.mOuterActionMenuPresenter = paramActionMenuPresenter;
        return;
      } 
    } 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1) {
    this.mActionMenuPresenterCallback = paramCallback;
    this.mMenuBuilderCallback = paramCallback1;
    if (this.mMenuView != null)
      this.mMenuView.setMenuCallbacks(paramCallback, paramCallback1); 
  }
  
  public void setNavigationContentDescription(@StringRes int paramInt) {
    CharSequence charSequence;
    if (paramInt != 0) {
      charSequence = getContext().getText(paramInt);
    } else {
      charSequence = null;
    } 
    setNavigationContentDescription(charSequence);
  }
  
  public void setNavigationContentDescription(@Nullable CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence))
      ensureNavButtonView(); 
    if (this.mNavButtonView != null)
      this.mNavButtonView.setContentDescription(paramCharSequence); 
  }
  
  public void setNavigationIcon(@DrawableRes int paramInt) {
    setNavigationIcon(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setNavigationIcon(@Nullable Drawable paramDrawable) {
    if (paramDrawable != null) {
      ensureNavButtonView();
      if (!isChildOrHidden((View)this.mNavButtonView))
        addSystemView((View)this.mNavButtonView, true); 
    } else if (this.mNavButtonView != null && isChildOrHidden((View)this.mNavButtonView)) {
      removeView((View)this.mNavButtonView);
      this.mHiddenViews.remove(this.mNavButtonView);
    } 
    if (this.mNavButtonView != null)
      this.mNavButtonView.setImageDrawable(paramDrawable); 
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener) {
    ensureNavButtonView();
    this.mNavButtonView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener) {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(@Nullable Drawable paramDrawable) {
    ensureMenu();
    this.mMenuView.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(@StyleRes int paramInt) {
    if (this.mPopupTheme != paramInt) {
      this.mPopupTheme = paramInt;
      if (paramInt == 0) {
        this.mPopupContext = getContext();
        return;
      } 
    } else {
      return;
    } 
    this.mPopupContext = (Context)new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(@StringRes int paramInt) {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      if (this.mSubtitleTextView == null) {
        Context context = getContext();
        this.mSubtitleTextView = new AppCompatTextView(context);
        this.mSubtitleTextView.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.mSubtitleTextAppearance != 0)
          this.mSubtitleTextView.setTextAppearance(context, this.mSubtitleTextAppearance); 
        if (this.mSubtitleTextColor != 0)
          this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor); 
      } 
      if (!isChildOrHidden((View)this.mSubtitleTextView))
        addSystemView((View)this.mSubtitleTextView, true); 
    } else if (this.mSubtitleTextView != null && isChildOrHidden((View)this.mSubtitleTextView)) {
      removeView((View)this.mSubtitleTextView);
      this.mHiddenViews.remove(this.mSubtitleTextView);
    } 
    if (this.mSubtitleTextView != null)
      this.mSubtitleTextView.setText(paramCharSequence); 
    this.mSubtitleText = paramCharSequence;
  }
  
  public void setSubtitleTextAppearance(Context paramContext, @StyleRes int paramInt) {
    this.mSubtitleTextAppearance = paramInt;
    if (this.mSubtitleTextView != null)
      this.mSubtitleTextView.setTextAppearance(paramContext, paramInt); 
  }
  
  public void setSubtitleTextColor(@ColorInt int paramInt) {
    this.mSubtitleTextColor = paramInt;
    if (this.mSubtitleTextView != null)
      this.mSubtitleTextView.setTextColor(paramInt); 
  }
  
  public void setTitle(@StringRes int paramInt) {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      if (this.mTitleTextView == null) {
        Context context = getContext();
        this.mTitleTextView = new AppCompatTextView(context);
        this.mTitleTextView.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.mTitleTextAppearance != 0)
          this.mTitleTextView.setTextAppearance(context, this.mTitleTextAppearance); 
        if (this.mTitleTextColor != 0)
          this.mTitleTextView.setTextColor(this.mTitleTextColor); 
      } 
      if (!isChildOrHidden((View)this.mTitleTextView))
        addSystemView((View)this.mTitleTextView, true); 
    } else if (this.mTitleTextView != null && isChildOrHidden((View)this.mTitleTextView)) {
      removeView((View)this.mTitleTextView);
      this.mHiddenViews.remove(this.mTitleTextView);
    } 
    if (this.mTitleTextView != null)
      this.mTitleTextView.setText(paramCharSequence); 
    this.mTitleText = paramCharSequence;
  }
  
  public void setTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mTitleMarginStart = paramInt1;
    this.mTitleMarginTop = paramInt2;
    this.mTitleMarginEnd = paramInt3;
    this.mTitleMarginBottom = paramInt4;
    requestLayout();
  }
  
  public void setTitleMarginBottom(int paramInt) {
    this.mTitleMarginBottom = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt) {
    this.mTitleMarginEnd = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt) {
    this.mTitleMarginStart = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt) {
    this.mTitleMarginTop = paramInt;
    requestLayout();
  }
  
  public void setTitleTextAppearance(Context paramContext, @StyleRes int paramInt) {
    this.mTitleTextAppearance = paramInt;
    if (this.mTitleTextView != null)
      this.mTitleTextView.setTextAppearance(paramContext, paramInt); 
  }
  
  public void setTitleTextColor(@ColorInt int paramInt) {
    this.mTitleTextColor = paramInt;
    if (this.mTitleTextView != null)
      this.mTitleTextView.setTextColor(paramInt); 
  }
  
  public boolean showOverflowMenu() {
    return (this.mMenuView != null && this.mMenuView.showOverflowMenu());
  }
  
  private class ExpandedActionViewMenuPresenter implements MenuPresenter {
    MenuItemImpl mCurrentExpandedItem;
    
    MenuBuilder mMenu;
    
    public boolean collapseItemActionView(MenuBuilder param1MenuBuilder, MenuItemImpl param1MenuItemImpl) {
      if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView)
        ((CollapsibleActionView)Toolbar.this.mExpandedActionView).onActionViewCollapsed(); 
      Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
      Toolbar.this.removeView((View)Toolbar.this.mCollapseButtonView);
      Toolbar.this.mExpandedActionView = null;
      Toolbar.this.addChildrenForExpandedActionView();
      this.mCurrentExpandedItem = null;
      Toolbar.this.requestLayout();
      param1MenuItemImpl.setActionViewExpanded(false);
      return true;
    }
    
    public boolean expandItemActionView(MenuBuilder param1MenuBuilder, MenuItemImpl param1MenuItemImpl) {
      Toolbar.this.ensureCollapseButtonView();
      if (Toolbar.this.mCollapseButtonView.getParent() != Toolbar.this)
        Toolbar.this.addView((View)Toolbar.this.mCollapseButtonView); 
      Toolbar.this.mExpandedActionView = param1MenuItemImpl.getActionView();
      this.mCurrentExpandedItem = param1MenuItemImpl;
      if (Toolbar.this.mExpandedActionView.getParent() != Toolbar.this) {
        Toolbar.LayoutParams layoutParams = Toolbar.this.generateDefaultLayoutParams();
        layoutParams.gravity = 0x800003 | Toolbar.this.mButtonGravity & 0x70;
        layoutParams.mViewType = 2;
        Toolbar.this.mExpandedActionView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        Toolbar.this.addView(Toolbar.this.mExpandedActionView);
      } 
      Toolbar.this.removeChildrenForExpandedActionView();
      Toolbar.this.requestLayout();
      param1MenuItemImpl.setActionViewExpanded(true);
      if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView)
        ((CollapsibleActionView)Toolbar.this.mExpandedActionView).onActionViewExpanded(); 
      return true;
    }
    
    public boolean flagActionItems() {
      return false;
    }
    
    public int getId() {
      return 0;
    }
    
    public MenuView getMenuView(ViewGroup param1ViewGroup) {
      return null;
    }
    
    public void initForMenu(Context param1Context, MenuBuilder param1MenuBuilder) {
      if (this.mMenu != null && this.mCurrentExpandedItem != null)
        this.mMenu.collapseItemActionView(this.mCurrentExpandedItem); 
      this.mMenu = param1MenuBuilder;
    }
    
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {}
    
    public void onRestoreInstanceState(Parcelable param1Parcelable) {}
    
    public Parcelable onSaveInstanceState() {
      return null;
    }
    
    public boolean onSubMenuSelected(SubMenuBuilder param1SubMenuBuilder) {
      return false;
    }
    
    public void setCallback(MenuPresenter.Callback param1Callback) {}
    
    public void updateMenuView(boolean param1Boolean) {
      boolean bool;
      if (this.mCurrentExpandedItem != null) {
        boolean bool1 = false;
        bool = bool1;
        if (this.mMenu != null) {
          int j = this.mMenu.size();
          int i = 0;
          while (true) {
            bool = bool1;
            if (i < j)
              if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                bool = true;
              } else {
                i++;
                continue;
              }  
            if (!bool)
              collapseItemActionView(this.mMenu, this.mCurrentExpandedItem); 
            return;
          } 
        } 
      } else {
        return;
      } 
      if (!bool)
        collapseItemActionView(this.mMenu, this.mCurrentExpandedItem); 
    }
  }
  
  public static class LayoutParams extends ActionBar.LayoutParams {
    static final int CUSTOM = 0;
    
    static final int EXPANDED = 2;
    
    static final int SYSTEM = 1;
    
    int mViewType = 0;
    
    public LayoutParams(int param1Int) {
      this(-2, -1, param1Int);
    }
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.gravity = 8388627;
    }
    
    public LayoutParams(int param1Int1, int param1Int2, int param1Int3) {
      super(param1Int1, param1Int2);
      this.gravity = param1Int3;
    }
    
    public LayoutParams(@NonNull Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    public LayoutParams(ActionBar.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.mViewType = param1LayoutParams.mViewType;
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super((ViewGroup.LayoutParams)param1MarginLayoutParams);
      copyMarginsFromCompat(param1MarginLayoutParams);
    }
    
    void copyMarginsFromCompat(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      this.leftMargin = param1MarginLayoutParams.leftMargin;
      this.topMargin = param1MarginLayoutParams.topMargin;
      this.rightMargin = param1MarginLayoutParams.rightMargin;
      this.bottomMargin = param1MarginLayoutParams.bottomMargin;
    }
  }
  
  public static interface OnMenuItemClickListener {
    boolean onMenuItemClick(MenuItem param1MenuItem);
  }
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
          public Toolbar.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
            return new Toolbar.SavedState(param2Parcel, param2ClassLoader);
          }
          
          public Toolbar.SavedState[] newArray(int param2Int) {
            return new Toolbar.SavedState[param2Int];
          }
        });
    
    int expandedMenuItemId;
    
    boolean isOverflowOpen;
    
    public SavedState(Parcel param1Parcel) {
      this(param1Parcel, null);
    }
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      boolean bool;
      this.expandedMenuItemId = param1Parcel.readInt();
      if (param1Parcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.isOverflowOpen = bool;
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.expandedMenuItemId);
      if (this.isOverflowOpen) {
        param1Int = 1;
      } else {
        param1Int = 0;
      } 
      param1Parcel.writeInt(param1Int);
    }
  }
  
  static final class null implements ParcelableCompatCreatorCallbacks<SavedState> {
    public Toolbar.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new Toolbar.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public Toolbar.SavedState[] newArray(int param1Int) {
      return new Toolbar.SavedState[param1Int];
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\Toolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */