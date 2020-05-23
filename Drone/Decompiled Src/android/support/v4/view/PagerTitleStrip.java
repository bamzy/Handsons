package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.v4.widget.TextViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;

@DecorView
public class PagerTitleStrip extends ViewGroup {
  private static final int[] ATTRS = new int[] { 16842804, 16842901, 16842904, 16842927 };
  
  private static final PagerTitleStripImpl IMPL;
  
  private static final float SIDE_ALPHA = 0.6F;
  
  private static final String TAG = "PagerTitleStrip";
  
  private static final int[] TEXT_ATTRS = new int[] { 16843660 };
  
  private static final int TEXT_SPACING = 16;
  
  TextView mCurrText;
  
  private int mGravity;
  
  private int mLastKnownCurrentPage = -1;
  
  float mLastKnownPositionOffset = -1.0F;
  
  TextView mNextText;
  
  private int mNonPrimaryAlpha;
  
  private final PageListener mPageListener = new PageListener();
  
  ViewPager mPager;
  
  TextView mPrevText;
  
  private int mScaledTextSpacing;
  
  int mTextColor;
  
  private boolean mUpdatingPositions;
  
  private boolean mUpdatingText;
  
  private WeakReference<PagerAdapter> mWatchingAdapter;
  
  static {
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new PagerTitleStripImplIcs();
      return;
    } 
    IMPL = new PagerTitleStripImplBase();
  }
  
  public PagerTitleStrip(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TextView textView = new TextView(paramContext);
    this.mPrevText = textView;
    addView((View)textView);
    textView = new TextView(paramContext);
    this.mCurrText = textView;
    addView((View)textView);
    textView = new TextView(paramContext);
    this.mNextText = textView;
    addView((View)textView);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    int i = typedArray.getResourceId(0, 0);
    if (i != 0) {
      TextViewCompat.setTextAppearance(this.mPrevText, i);
      TextViewCompat.setTextAppearance(this.mCurrText, i);
      TextViewCompat.setTextAppearance(this.mNextText, i);
    } 
    int j = typedArray.getDimensionPixelSize(1, 0);
    if (j != 0)
      setTextSize(0, j); 
    if (typedArray.hasValue(2)) {
      j = typedArray.getColor(2, 0);
      this.mPrevText.setTextColor(j);
      this.mCurrText.setTextColor(j);
      this.mNextText.setTextColor(j);
    } 
    this.mGravity = typedArray.getInteger(3, 80);
    typedArray.recycle();
    this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
    this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
    this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
    boolean bool = false;
    if (i != 0) {
      typedArray = paramContext.obtainStyledAttributes(i, TEXT_ATTRS);
      bool = typedArray.getBoolean(0, false);
      typedArray.recycle();
    } 
    if (bool) {
      setSingleLineAllCaps(this.mPrevText);
      setSingleLineAllCaps(this.mCurrText);
      setSingleLineAllCaps(this.mNextText);
    } else {
      this.mPrevText.setSingleLine();
      this.mCurrText.setSingleLine();
      this.mNextText.setSingleLine();
    } 
    this.mScaledTextSpacing = (int)(16.0F * (paramContext.getResources().getDisplayMetrics()).density);
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView) {
    IMPL.setSingleLineAllCaps(paramTextView);
  }
  
  int getMinHeight() {
    int i = 0;
    Drawable drawable = getBackground();
    if (drawable != null)
      i = drawable.getIntrinsicHeight(); 
    return i;
  }
  
  public int getTextSpacing() {
    return this.mScaledTextSpacing;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    ViewParent viewParent = getParent();
    if (!(viewParent instanceof ViewPager))
      throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager."); 
    ViewPager viewPager = (ViewPager)viewParent;
    PagerAdapter pagerAdapter = viewPager.getAdapter();
    viewPager.setInternalPageChangeListener(this.mPageListener);
    viewPager.addOnAdapterChangeListener(this.mPageListener);
    this.mPager = viewPager;
    if (this.mWatchingAdapter != null) {
      PagerAdapter pagerAdapter1 = this.mWatchingAdapter.get();
    } else {
      viewPager = null;
    } 
    updateAdapter((PagerAdapter)viewPager, pagerAdapter);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.mPager != null) {
      updateAdapter(this.mPager.getAdapter(), (PagerAdapter)null);
      this.mPager.setInternalPageChangeListener(null);
      this.mPager.removeOnAdapterChangeListener(this.mPageListener);
      this.mPager = null;
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f = 0.0F;
    if (this.mPager != null) {
      if (this.mLastKnownPositionOffset >= 0.0F)
        f = this.mLastKnownPositionOffset; 
      updateTextPositions(this.mLastKnownCurrentPage, f, true);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
      throw new IllegalStateException("Must measure with an exact width"); 
    int j = getPaddingTop() + getPaddingBottom();
    int k = getChildMeasureSpec(paramInt2, j, -2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = getChildMeasureSpec(paramInt1, (int)(i * 0.2F), -2);
    this.mPrevText.measure(paramInt1, k);
    this.mCurrText.measure(paramInt1, k);
    this.mNextText.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
    } else {
      paramInt1 = this.mCurrText.getMeasuredHeight();
      paramInt1 = Math.max(getMinHeight(), paramInt1 + j);
    } 
    setMeasuredDimension(i, ViewCompat.resolveSizeAndState(paramInt1, paramInt2, ViewCompat.getMeasuredState((View)this.mCurrText) << 16));
  }
  
  public void requestLayout() {
    if (!this.mUpdatingText)
      super.requestLayout(); 
  }
  
  public void setGravity(int paramInt) {
    this.mGravity = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(@FloatRange(from = 0.0D, to = 1.0D) float paramFloat) {
    this.mNonPrimaryAlpha = (int)(255.0F * paramFloat) & 0xFF;
    int i = this.mNonPrimaryAlpha << 24 | this.mTextColor & 0xFFFFFF;
    this.mPrevText.setTextColor(i);
    this.mNextText.setTextColor(i);
  }
  
  public void setTextColor(@ColorInt int paramInt) {
    this.mTextColor = paramInt;
    this.mCurrText.setTextColor(paramInt);
    paramInt = this.mNonPrimaryAlpha << 24 | this.mTextColor & 0xFFFFFF;
    this.mPrevText.setTextColor(paramInt);
    this.mNextText.setTextColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat) {
    this.mPrevText.setTextSize(paramInt, paramFloat);
    this.mCurrText.setTextSize(paramInt, paramFloat);
    this.mNextText.setTextSize(paramInt, paramFloat);
  }
  
  public void setTextSpacing(int paramInt) {
    this.mScaledTextSpacing = paramInt;
    requestLayout();
  }
  
  void updateAdapter(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2) {
    if (paramPagerAdapter1 != null) {
      paramPagerAdapter1.unregisterDataSetObserver(this.mPageListener);
      this.mWatchingAdapter = null;
    } 
    if (paramPagerAdapter2 != null) {
      paramPagerAdapter2.registerDataSetObserver(this.mPageListener);
      this.mWatchingAdapter = new WeakReference<PagerAdapter>(paramPagerAdapter2);
    } 
    if (this.mPager != null) {
      this.mLastKnownCurrentPage = -1;
      this.mLastKnownPositionOffset = -1.0F;
      updateText(this.mPager.getCurrentItem(), paramPagerAdapter2);
      requestLayout();
    } 
  }
  
  void updateText(int paramInt, PagerAdapter paramPagerAdapter) {
    CharSequence charSequence1;
    if (paramPagerAdapter != null) {
      i = paramPagerAdapter.getCount();
    } else {
      i = 0;
    } 
    this.mUpdatingText = true;
    CharSequence charSequence3 = null;
    CharSequence charSequence2 = charSequence3;
    if (paramInt >= 1) {
      charSequence2 = charSequence3;
      if (paramPagerAdapter != null)
        charSequence2 = paramPagerAdapter.getPageTitle(paramInt - 1); 
    } 
    this.mPrevText.setText(charSequence2);
    TextView textView2 = this.mCurrText;
    if (paramPagerAdapter != null && paramInt < i) {
      charSequence2 = paramPagerAdapter.getPageTitle(paramInt);
    } else {
      charSequence2 = null;
    } 
    textView2.setText(charSequence2);
    textView2 = null;
    TextView textView1 = textView2;
    if (paramInt + 1 < i) {
      textView1 = textView2;
      if (paramPagerAdapter != null)
        charSequence1 = paramPagerAdapter.getPageTitle(paramInt + 1); 
    } 
    this.mNextText.setText(charSequence1);
    int i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
    int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
    this.mPrevText.measure(i, j);
    this.mCurrText.measure(i, j);
    this.mNextText.measure(i, j);
    this.mLastKnownCurrentPage = paramInt;
    if (!this.mUpdatingPositions)
      updateTextPositions(paramInt, this.mLastKnownPositionOffset, false); 
    this.mUpdatingText = false;
  }
  
  void updateTextPositions(int paramInt, float paramFloat, boolean paramBoolean) {
    if (paramInt != this.mLastKnownCurrentPage) {
      updateText(paramInt, this.mPager.getAdapter());
    } else if (!paramBoolean && paramFloat == this.mLastKnownPositionOffset) {
      return;
    } 
    this.mUpdatingPositions = true;
    int m = this.mPrevText.getMeasuredWidth();
    int i4 = this.mCurrText.getMeasuredWidth();
    int k = this.mNextText.getMeasuredWidth();
    int i3 = i4 / 2;
    int n = getWidth();
    int i = getHeight();
    int i2 = getPaddingLeft();
    int i1 = getPaddingRight();
    paramInt = getPaddingTop();
    int j = getPaddingBottom();
    int i5 = i1 + i3;
    float f2 = paramFloat + 0.5F;
    float f1 = f2;
    if (f2 > 1.0F)
      f1 = f2 - 1.0F; 
    i3 = n - i5 - (int)((n - i2 + i3 - i5) * f1) - i4 / 2;
    i4 = i3 + i4;
    int i7 = this.mPrevText.getBaseline();
    int i6 = this.mCurrText.getBaseline();
    i5 = this.mNextText.getBaseline();
    int i8 = Math.max(Math.max(i7, i6), i5);
    i7 = i8 - i7;
    i6 = i8 - i6;
    i5 = i8 - i5;
    i8 = this.mPrevText.getMeasuredHeight();
    int i9 = this.mCurrText.getMeasuredHeight();
    int i10 = this.mNextText.getMeasuredHeight();
    i8 = Math.max(Math.max(i7 + i8, i6 + i9), i5 + i10);
    switch (this.mGravity & 0x70) {
      default:
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
        this.mCurrText.layout(i3, i, i4, this.mCurrText.getMeasuredHeight() + i);
        i = Math.min(i2, i3 - this.mScaledTextSpacing - m);
        this.mPrevText.layout(i, j, i + m, this.mPrevText.getMeasuredHeight() + j);
        i = Math.max(n - i1 - k, this.mScaledTextSpacing + i4);
        this.mNextText.layout(i, paramInt, i + k, this.mNextText.getMeasuredHeight() + paramInt);
        this.mLastKnownPositionOffset = paramFloat;
        this.mUpdatingPositions = false;
        return;
      case 16:
        paramInt = (i - paramInt - j - i8) / 2;
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
        this.mCurrText.layout(i3, i, i4, this.mCurrText.getMeasuredHeight() + i);
        i = Math.min(i2, i3 - this.mScaledTextSpacing - m);
        this.mPrevText.layout(i, j, i + m, this.mPrevText.getMeasuredHeight() + j);
        i = Math.max(n - i1 - k, this.mScaledTextSpacing + i4);
        this.mNextText.layout(i, paramInt, i + k, this.mNextText.getMeasuredHeight() + paramInt);
        this.mLastKnownPositionOffset = paramFloat;
        this.mUpdatingPositions = false;
        return;
      case 80:
        break;
    } 
    paramInt = i - j - i8;
    j = paramInt + i7;
    i = paramInt + i6;
    paramInt += i5;
    this.mCurrText.layout(i3, i, i4, this.mCurrText.getMeasuredHeight() + i);
    i = Math.min(i2, i3 - this.mScaledTextSpacing - m);
    this.mPrevText.layout(i, j, i + m, this.mPrevText.getMeasuredHeight() + j);
    i = Math.max(n - i1 - k, this.mScaledTextSpacing + i4);
    this.mNextText.layout(i, paramInt, i + k, this.mNextText.getMeasuredHeight() + paramInt);
    this.mLastKnownPositionOffset = paramFloat;
    this.mUpdatingPositions = false;
  }
  
  private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
    private int mScrollState;
    
    public void onAdapterChanged(ViewPager param1ViewPager, PagerAdapter param1PagerAdapter1, PagerAdapter param1PagerAdapter2) {
      PagerTitleStrip.this.updateAdapter(param1PagerAdapter1, param1PagerAdapter2);
    }
    
    public void onChanged() {
      float f = 0.0F;
      PagerTitleStrip.this.updateText(PagerTitleStrip.this.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
      if (PagerTitleStrip.this.mLastKnownPositionOffset >= 0.0F)
        f = PagerTitleStrip.this.mLastKnownPositionOffset; 
      PagerTitleStrip.this.updateTextPositions(PagerTitleStrip.this.mPager.getCurrentItem(), f, true);
    }
    
    public void onPageScrollStateChanged(int param1Int) {
      this.mScrollState = param1Int;
    }
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {
      param1Int2 = param1Int1;
      if (param1Float > 0.5F)
        param1Int2 = param1Int1 + 1; 
      PagerTitleStrip.this.updateTextPositions(param1Int2, param1Float, false);
    }
    
    public void onPageSelected(int param1Int) {
      float f = 0.0F;
      if (this.mScrollState == 0) {
        PagerTitleStrip.this.updateText(PagerTitleStrip.this.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
        if (PagerTitleStrip.this.mLastKnownPositionOffset >= 0.0F)
          f = PagerTitleStrip.this.mLastKnownPositionOffset; 
        PagerTitleStrip.this.updateTextPositions(PagerTitleStrip.this.mPager.getCurrentItem(), f, true);
      } 
    }
  }
  
  static interface PagerTitleStripImpl {
    void setSingleLineAllCaps(TextView param1TextView);
  }
  
  static class PagerTitleStripImplBase implements PagerTitleStripImpl {
    public void setSingleLineAllCaps(TextView param1TextView) {
      param1TextView.setSingleLine();
    }
  }
  
  static class PagerTitleStripImplIcs implements PagerTitleStripImpl {
    public void setSingleLineAllCaps(TextView param1TextView) {
      PagerTitleStripIcs.setSingleLineAllCaps(param1TextView);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\PagerTitleStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */