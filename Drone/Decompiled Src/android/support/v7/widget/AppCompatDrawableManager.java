package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AppCompatDrawableManager {
  private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
  
  private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
  
  private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
  
  private static final ColorFilterLruCache COLOR_FILTER_CACHE;
  
  private static final boolean DEBUG = false;
  
  private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  
  private static AppCompatDrawableManager INSTANCE;
  
  private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
  
  private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
  
  private static final String TAG = "AppCompatDrawableManager";
  
  private static final int[] TINT_CHECKABLE_BUTTON_LIST;
  
  private static final int[] TINT_COLOR_CONTROL_NORMAL;
  
  private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
  
  private ArrayMap<String, InflateDelegate> mDelegates;
  
  private final Object mDrawableCacheLock = new Object();
  
  private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>>(0);
  
  private boolean mHasCheckedVectorDrawableSetup;
  
  private SparseArrayCompat<String> mKnownDrawableIdTags;
  
  private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
  
  private TypedValue mTypedValue;
  
  static {
    COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[] { R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha };
    TINT_COLOR_CONTROL_NORMAL = new int[] { R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha };
    COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[] { R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light };
    COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[] { R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult };
    TINT_COLOR_CONTROL_STATE_LIST = new int[] { R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material };
    TINT_CHECKABLE_BUTTON_LIST = new int[] { R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material };
  }
  
  private void addDelegate(@NonNull String paramString, @NonNull InflateDelegate paramInflateDelegate) {
    if (this.mDelegates == null)
      this.mDelegates = new ArrayMap(); 
    this.mDelegates.put(paramString, paramInflateDelegate);
  }
  
  private boolean addDrawableToCache(@NonNull Context paramContext, long paramLong, @NonNull Drawable paramDrawable) {
    Drawable.ConstantState constantState = paramDrawable.getConstantState();
    if (constantState != null)
      synchronized (this.mDrawableCacheLock) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray2 = this.mDrawableCaches.get(paramContext);
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray1 = longSparseArray2;
        if (longSparseArray2 == null) {
          longSparseArray1 = new LongSparseArray();
          this.mDrawableCaches.put(paramContext, longSparseArray1);
        } 
        longSparseArray1.put(paramLong, new WeakReference<Drawable.ConstantState>(constantState));
        return true;
      }  
    return false;
  }
  
  private void addTintListToCache(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull ColorStateList paramColorStateList) {
    if (this.mTintLists == null)
      this.mTintLists = new WeakHashMap<Context, SparseArrayCompat<ColorStateList>>(); 
    SparseArrayCompat<ColorStateList> sparseArrayCompat2 = this.mTintLists.get(paramContext);
    SparseArrayCompat<ColorStateList> sparseArrayCompat1 = sparseArrayCompat2;
    if (sparseArrayCompat2 == null) {
      sparseArrayCompat1 = new SparseArrayCompat();
      this.mTintLists.put(paramContext, sparseArrayCompat1);
    } 
    sparseArrayCompat1.append(paramInt, paramColorStateList);
  }
  
  private static boolean arrayContains(int[] paramArrayOfint, int paramInt) {
    boolean bool = false;
    int j = paramArrayOfint.length;
    for (int i = 0;; i++) {
      boolean bool1 = bool;
      if (i < j) {
        if (paramArrayOfint[i] == paramInt)
          return true; 
      } else {
        return bool1;
      } 
    } 
  }
  
  private void checkVectorDrawableSetup(@NonNull Context paramContext) {
    if (!this.mHasCheckedVectorDrawableSetup) {
      this.mHasCheckedVectorDrawableSetup = true;
      Drawable drawable = getDrawable(paramContext, R.drawable.abc_vector_test);
      if (drawable == null || !isVectorDrawable(drawable)) {
        this.mHasCheckedVectorDrawableSetup = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
      } 
    } 
  }
  
  private ColorStateList createBorderlessButtonColorStateList(@NonNull Context paramContext) {
    return createButtonColorStateList(paramContext, 0);
  }
  
  private ColorStateList createButtonColorStateList(@NonNull Context paramContext, @ColorInt int paramInt) {
    int[][] arrayOfInt = new int[4][];
    int[] arrayOfInt1 = new int[4];
    int i = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlHighlight);
    int j = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorButtonNormal);
    arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
    arrayOfInt1[0] = j;
    j = 0 + 1;
    arrayOfInt[j] = ThemeUtils.PRESSED_STATE_SET;
    arrayOfInt1[j] = ColorUtils.compositeColors(i, paramInt);
    arrayOfInt[++j] = ThemeUtils.FOCUSED_STATE_SET;
    arrayOfInt1[j] = ColorUtils.compositeColors(i, paramInt);
    i = j + 1;
    arrayOfInt[i] = ThemeUtils.EMPTY_STATE_SET;
    arrayOfInt1[i] = paramInt;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  private static long createCacheKey(TypedValue paramTypedValue) {
    return paramTypedValue.assetCookie << 32L | paramTypedValue.data;
  }
  
  private ColorStateList createColoredButtonColorStateList(@NonNull Context paramContext) {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorAccent));
  }
  
  private ColorStateList createDefaultButtonColorStateList(@NonNull Context paramContext) {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorButtonNormal));
  }
  
  private Drawable createDrawableIfNeeded(@NonNull Context paramContext, @DrawableRes int paramInt) {
    LayerDrawable layerDrawable;
    if (this.mTypedValue == null)
      this.mTypedValue = new TypedValue(); 
    TypedValue typedValue = this.mTypedValue;
    paramContext.getResources().getValue(paramInt, typedValue, true);
    long l = createCacheKey(typedValue);
    Drawable drawable = getCachedDrawable(paramContext, l);
    if (drawable != null)
      return drawable; 
    if (paramInt == R.drawable.abc_cab_background_top_material)
      layerDrawable = new LayerDrawable(new Drawable[] { getDrawable(paramContext, R.drawable.abc_cab_background_internal_bg), getDrawable(paramContext, R.drawable.abc_cab_background_top_mtrl_alpha) }); 
    if (layerDrawable != null) {
      layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
      addDrawableToCache(paramContext, l, (Drawable)layerDrawable);
    } 
    return (Drawable)layerDrawable;
  }
  
  private static PorterDuffColorFilter createTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int[] paramArrayOfint) {
    return (paramColorStateList == null || paramMode == null) ? null : getPorterDuffColorFilter(paramColorStateList.getColorForState(paramArrayOfint, 0), paramMode);
  }
  
  public static AppCompatDrawableManager get() {
    if (INSTANCE == null) {
      INSTANCE = new AppCompatDrawableManager();
      installDefaultInflateDelegates(INSTANCE);
    } 
    return INSTANCE;
  }
  
  private Drawable getCachedDrawable(@NonNull Context paramContext, long paramLong) {
    synchronized (this.mDrawableCacheLock) {
      LongSparseArray longSparseArray = this.mDrawableCaches.get(paramContext);
      if (longSparseArray == null)
        return null; 
      WeakReference<Drawable.ConstantState> weakReference = (WeakReference)longSparseArray.get(paramLong);
      if (weakReference != null) {
        Drawable.ConstantState constantState = weakReference.get();
        if (constantState != null)
          return constantState.newDrawable(paramContext.getResources()); 
        longSparseArray.delete(paramLong);
      } 
    } 
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_4} */
    return null;
  }
  
  public static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode) {
    PorterDuffColorFilter porterDuffColorFilter2 = COLOR_FILTER_CACHE.get(paramInt, paramMode);
    PorterDuffColorFilter porterDuffColorFilter1 = porterDuffColorFilter2;
    if (porterDuffColorFilter2 == null) {
      porterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
      COLOR_FILTER_CACHE.put(paramInt, paramMode, porterDuffColorFilter1);
    } 
    return porterDuffColorFilter1;
  }
  
  private ColorStateList getTintListFromCache(@NonNull Context paramContext, @DrawableRes int paramInt) {
    ColorStateList colorStateList2 = null;
    ColorStateList colorStateList1 = colorStateList2;
    if (this.mTintLists != null) {
      SparseArrayCompat sparseArrayCompat = this.mTintLists.get(paramContext);
      colorStateList1 = colorStateList2;
      if (sparseArrayCompat != null)
        colorStateList1 = (ColorStateList)sparseArrayCompat.get(paramInt); 
    } 
    return colorStateList1;
  }
  
  static PorterDuff.Mode getTintMode(int paramInt) {
    PorterDuff.Mode mode = null;
    if (paramInt == R.drawable.abc_switch_thumb_material)
      mode = PorterDuff.Mode.MULTIPLY; 
    return mode;
  }
  
  private static void installDefaultInflateDelegates(@NonNull AppCompatDrawableManager paramAppCompatDrawableManager) {
    if (Build.VERSION.SDK_INT < 24) {
      paramAppCompatDrawableManager.addDelegate("vector", new VdcInflateDelegate());
      if (Build.VERSION.SDK_INT >= 11)
        paramAppCompatDrawableManager.addDelegate("animated-vector", new AvdcInflateDelegate()); 
    } 
  }
  
  private static boolean isVectorDrawable(@NonNull Drawable paramDrawable) {
    return (paramDrawable instanceof VectorDrawableCompat || "android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()));
  }
  
  private Drawable loadDrawableFromDelegates(@NonNull Context paramContext, @DrawableRes int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mDelegates : Landroid/support/v4/util/ArrayMap;
    //   4: ifnull -> 408
    //   7: aload_0
    //   8: getfield mDelegates : Landroid/support/v4/util/ArrayMap;
    //   11: invokevirtual isEmpty : ()Z
    //   14: ifne -> 408
    //   17: aload_0
    //   18: getfield mKnownDrawableIdTags : Landroid/support/v4/util/SparseArrayCompat;
    //   21: ifnull -> 70
    //   24: aload_0
    //   25: getfield mKnownDrawableIdTags : Landroid/support/v4/util/SparseArrayCompat;
    //   28: iload_2
    //   29: invokevirtual get : (I)Ljava/lang/Object;
    //   32: checkcast java/lang/String
    //   35: astore #7
    //   37: ldc 'appcompat_skip_skip'
    //   39: aload #7
    //   41: invokevirtual equals : (Ljava/lang/Object;)Z
    //   44: ifne -> 64
    //   47: aload #7
    //   49: ifnull -> 81
    //   52: aload_0
    //   53: getfield mDelegates : Landroid/support/v4/util/ArrayMap;
    //   56: aload #7
    //   58: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   61: ifnonnull -> 81
    //   64: aconst_null
    //   65: astore #8
    //   67: aload #8
    //   69: areturn
    //   70: aload_0
    //   71: new android/support/v4/util/SparseArrayCompat
    //   74: dup
    //   75: invokespecial <init> : ()V
    //   78: putfield mKnownDrawableIdTags : Landroid/support/v4/util/SparseArrayCompat;
    //   81: aload_0
    //   82: getfield mTypedValue : Landroid/util/TypedValue;
    //   85: ifnonnull -> 99
    //   88: aload_0
    //   89: new android/util/TypedValue
    //   92: dup
    //   93: invokespecial <init> : ()V
    //   96: putfield mTypedValue : Landroid/util/TypedValue;
    //   99: aload_0
    //   100: getfield mTypedValue : Landroid/util/TypedValue;
    //   103: astore #10
    //   105: aload_1
    //   106: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   109: astore #11
    //   111: aload #11
    //   113: iload_2
    //   114: aload #10
    //   116: iconst_1
    //   117: invokevirtual getValue : (ILandroid/util/TypedValue;Z)V
    //   120: aload #10
    //   122: invokestatic createCacheKey : (Landroid/util/TypedValue;)J
    //   125: lstore #4
    //   127: aload_0
    //   128: aload_1
    //   129: lload #4
    //   131: invokespecial getCachedDrawable : (Landroid/content/Context;J)Landroid/graphics/drawable/Drawable;
    //   134: astore #7
    //   136: aload #7
    //   138: astore #8
    //   140: aload #7
    //   142: ifnonnull -> 67
    //   145: aload #7
    //   147: astore #9
    //   149: aload #10
    //   151: getfield string : Ljava/lang/CharSequence;
    //   154: ifnull -> 256
    //   157: aload #7
    //   159: astore #9
    //   161: aload #10
    //   163: getfield string : Ljava/lang/CharSequence;
    //   166: invokeinterface toString : ()Ljava/lang/String;
    //   171: ldc_w '.xml'
    //   174: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   177: ifeq -> 256
    //   180: aload #7
    //   182: astore #9
    //   184: aload #11
    //   186: iload_2
    //   187: invokevirtual getXml : (I)Landroid/content/res/XmlResourceParser;
    //   190: astore #11
    //   192: aload #7
    //   194: astore #9
    //   196: aload #11
    //   198: invokestatic asAttributeSet : (Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   201: astore #12
    //   203: aload #7
    //   205: astore #9
    //   207: aload #11
    //   209: invokeinterface next : ()I
    //   214: istore_3
    //   215: iload_3
    //   216: iconst_2
    //   217: if_icmpeq -> 225
    //   220: iload_3
    //   221: iconst_1
    //   222: if_icmpne -> 203
    //   225: iload_3
    //   226: iconst_2
    //   227: if_icmpeq -> 278
    //   230: aload #7
    //   232: astore #9
    //   234: new org/xmlpull/v1/XmlPullParserException
    //   237: dup
    //   238: ldc_w 'No start tag found'
    //   241: invokespecial <init> : (Ljava/lang/String;)V
    //   244: athrow
    //   245: astore_1
    //   246: ldc 'AppCompatDrawableManager'
    //   248: ldc_w 'Exception while inflating drawable'
    //   251: aload_1
    //   252: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   255: pop
    //   256: aload #9
    //   258: astore #8
    //   260: aload #9
    //   262: ifnonnull -> 67
    //   265: aload_0
    //   266: getfield mKnownDrawableIdTags : Landroid/support/v4/util/SparseArrayCompat;
    //   269: iload_2
    //   270: ldc 'appcompat_skip_skip'
    //   272: invokevirtual append : (ILjava/lang/Object;)V
    //   275: aload #9
    //   277: areturn
    //   278: aload #7
    //   280: astore #9
    //   282: aload #11
    //   284: invokeinterface getName : ()Ljava/lang/String;
    //   289: astore #8
    //   291: aload #7
    //   293: astore #9
    //   295: aload_0
    //   296: getfield mKnownDrawableIdTags : Landroid/support/v4/util/SparseArrayCompat;
    //   299: iload_2
    //   300: aload #8
    //   302: invokevirtual append : (ILjava/lang/Object;)V
    //   305: aload #7
    //   307: astore #9
    //   309: aload_0
    //   310: getfield mDelegates : Landroid/support/v4/util/ArrayMap;
    //   313: aload #8
    //   315: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   318: checkcast android/support/v7/widget/AppCompatDrawableManager$InflateDelegate
    //   321: astore #13
    //   323: aload #7
    //   325: astore #8
    //   327: aload #13
    //   329: ifnull -> 354
    //   332: aload #7
    //   334: astore #9
    //   336: aload #13
    //   338: aload_1
    //   339: aload #11
    //   341: aload #12
    //   343: aload_1
    //   344: invokevirtual getTheme : ()Landroid/content/res/Resources$Theme;
    //   347: invokeinterface createFromXmlInner : (Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;
    //   352: astore #8
    //   354: aload #8
    //   356: astore #9
    //   358: aload #8
    //   360: ifnull -> 256
    //   363: aload #8
    //   365: astore #9
    //   367: aload #8
    //   369: aload #10
    //   371: getfield changingConfigurations : I
    //   374: invokevirtual setChangingConfigurations : (I)V
    //   377: aload #8
    //   379: astore #9
    //   381: aload_0
    //   382: aload_1
    //   383: lload #4
    //   385: aload #8
    //   387: invokespecial addDrawableToCache : (Landroid/content/Context;JLandroid/graphics/drawable/Drawable;)Z
    //   390: istore #6
    //   392: aload #8
    //   394: astore #9
    //   396: iload #6
    //   398: ifeq -> 256
    //   401: aload #8
    //   403: astore #9
    //   405: goto -> 256
    //   408: aconst_null
    //   409: areturn
    // Exception table:
    //   from	to	target	type
    //   184	192	245	java/lang/Exception
    //   196	203	245	java/lang/Exception
    //   207	215	245	java/lang/Exception
    //   234	245	245	java/lang/Exception
    //   282	291	245	java/lang/Exception
    //   295	305	245	java/lang/Exception
    //   309	323	245	java/lang/Exception
    //   336	354	245	java/lang/Exception
    //   367	377	245	java/lang/Exception
    //   381	392	245	java/lang/Exception
  }
  
  private void removeDelegate(@NonNull String paramString, @NonNull InflateDelegate paramInflateDelegate) {
    if (this.mDelegates != null && this.mDelegates.get(paramString) == paramInflateDelegate)
      this.mDelegates.remove(paramString); 
  }
  
  private static void setPorterDuffColorFilter(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode) {
    Drawable drawable = paramDrawable;
    if (DrawableUtils.canSafelyMutateDrawable(paramDrawable))
      drawable = paramDrawable.mutate(); 
    PorterDuff.Mode mode = paramMode;
    if (paramMode == null)
      mode = DEFAULT_MODE; 
    drawable.setColorFilter((ColorFilter)getPorterDuffColorFilter(paramInt, mode));
  }
  
  private Drawable tintDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean, @NonNull Drawable paramDrawable) {
    Drawable drawable;
    PorterDuff.Mode mode1;
    ColorStateList colorStateList = getTintList(paramContext, paramInt);
    if (colorStateList != null) {
      drawable = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable))
        drawable = paramDrawable.mutate(); 
      drawable = DrawableCompat.wrap(drawable);
      DrawableCompat.setTintList(drawable, colorStateList);
      mode1 = getTintMode(paramInt);
      Drawable drawable1 = drawable;
      if (mode1 != null) {
        DrawableCompat.setTintMode(drawable, mode1);
        drawable1 = drawable;
      } 
      return drawable1;
    } 
    if (paramInt == R.drawable.abc_seekbar_track_material) {
      LayerDrawable layerDrawable = (LayerDrawable)mode1;
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor((Context)drawable, R.attr.colorControlNormal), DEFAULT_MODE);
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor((Context)drawable, R.attr.colorControlNormal), DEFAULT_MODE);
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor((Context)drawable, R.attr.colorControlActivated), DEFAULT_MODE);
      return (Drawable)mode1;
    } 
    if (paramInt == R.drawable.abc_ratingbar_material || paramInt == R.drawable.abc_ratingbar_indicator_material || paramInt == R.drawable.abc_ratingbar_small_material) {
      LayerDrawable layerDrawable = (LayerDrawable)mode1;
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor((Context)drawable, R.attr.colorControlNormal), DEFAULT_MODE);
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor((Context)drawable, R.attr.colorControlActivated), DEFAULT_MODE);
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor((Context)drawable, R.attr.colorControlActivated), DEFAULT_MODE);
      return (Drawable)mode1;
    } 
    PorterDuff.Mode mode2 = mode1;
    if (!tintDrawableUsingColorFilter((Context)drawable, paramInt, (Drawable)mode1)) {
      mode2 = mode1;
      if (paramBoolean)
        return null; 
    } 
    return (Drawable)mode2;
  }
  
  static void tintDrawable(Drawable paramDrawable, TintInfo paramTintInfo, int[] paramArrayOfint) {
    if (DrawableUtils.canSafelyMutateDrawable(paramDrawable) && paramDrawable.mutate() != paramDrawable) {
      Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
      return;
    } 
    if (paramTintInfo.mHasTintList || paramTintInfo.mHasTintMode) {
      PorterDuff.Mode mode;
      ColorStateList colorStateList;
      if (paramTintInfo.mHasTintList) {
        colorStateList = paramTintInfo.mTintList;
      } else {
        colorStateList = null;
      } 
      if (paramTintInfo.mHasTintMode) {
        mode = paramTintInfo.mTintMode;
      } else {
        mode = DEFAULT_MODE;
      } 
      paramDrawable.setColorFilter((ColorFilter)createTintFilter(colorStateList, mode, paramArrayOfint));
    } else {
      paramDrawable.clearColorFilter();
    } 
    if (Build.VERSION.SDK_INT <= 23) {
      paramDrawable.invalidateSelf();
      return;
    } 
  }
  
  static boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable) {
    byte b1;
    PorterDuff.Mode mode1;
    PorterDuff.Mode mode2 = DEFAULT_MODE;
    boolean bool = false;
    int i = 0;
    byte b2 = -1;
    if (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, paramInt)) {
      i = R.attr.colorControlNormal;
      bool = true;
      mode1 = mode2;
      b1 = b2;
    } else if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, paramInt)) {
      i = R.attr.colorControlActivated;
      bool = true;
      b1 = b2;
      mode1 = mode2;
    } else if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, paramInt)) {
      i = 16842801;
      bool = true;
      mode1 = PorterDuff.Mode.MULTIPLY;
      b1 = b2;
    } else if (paramInt == R.drawable.abc_list_divider_mtrl_alpha) {
      i = 16842800;
      bool = true;
      b1 = Math.round(40.8F);
      mode1 = mode2;
    } else {
      b1 = b2;
      mode1 = mode2;
      if (paramInt == R.drawable.abc_dialog_material_background) {
        i = 16842801;
        bool = true;
        b1 = b2;
        mode1 = mode2;
      } 
    } 
    if (bool) {
      Drawable drawable = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable))
        drawable = paramDrawable.mutate(); 
      drawable.setColorFilter((ColorFilter)getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(paramContext, i), mode1));
      if (b1 != -1)
        drawable.setAlpha(b1); 
      return true;
    } 
    return false;
  }
  
  public Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt) {
    return getDrawable(paramContext, paramInt, false);
  }
  
  Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean) {
    checkVectorDrawableSetup(paramContext);
    Drawable drawable2 = loadDrawableFromDelegates(paramContext, paramInt);
    Drawable drawable1 = drawable2;
    if (drawable2 == null)
      drawable1 = createDrawableIfNeeded(paramContext, paramInt); 
    drawable2 = drawable1;
    if (drawable1 == null)
      drawable2 = ContextCompat.getDrawable(paramContext, paramInt); 
    drawable1 = drawable2;
    if (drawable2 != null)
      drawable1 = tintDrawable(paramContext, paramInt, paramBoolean, drawable2); 
    if (drawable1 != null)
      DrawableUtils.fixDrawable(drawable1); 
    return drawable1;
  }
  
  ColorStateList getTintList(@NonNull Context paramContext, @DrawableRes int paramInt) {
    ColorStateList colorStateList1 = getTintListFromCache(paramContext, paramInt);
    ColorStateList colorStateList2 = colorStateList1;
    if (colorStateList1 == null) {
      if (paramInt == R.drawable.abc_edit_text_material) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_edittext);
      } else if (paramInt == R.drawable.abc_switch_track_mtrl_alpha) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_switch_track);
      } else if (paramInt == R.drawable.abc_switch_thumb_material) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_switch_thumb);
      } else if (paramInt == R.drawable.abc_btn_default_mtrl_shape) {
        colorStateList1 = createDefaultButtonColorStateList(paramContext);
      } else if (paramInt == R.drawable.abc_btn_borderless_material) {
        colorStateList1 = createBorderlessButtonColorStateList(paramContext);
      } else if (paramInt == R.drawable.abc_btn_colored_material) {
        colorStateList1 = createColoredButtonColorStateList(paramContext);
      } else if (paramInt == R.drawable.abc_spinner_mtrl_am_alpha || paramInt == R.drawable.abc_spinner_textfield_background_material) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_spinner);
      } else if (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt)) {
        colorStateList1 = ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorControlNormal);
      } else if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt)) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_default);
      } else if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, paramInt)) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_btn_checkable);
      } else if (paramInt == R.drawable.abc_seekbar_thumb_material) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_seek_thumb);
      } 
      colorStateList2 = colorStateList1;
      if (colorStateList1 != null) {
        addTintListToCache(paramContext, paramInt, colorStateList1);
        colorStateList2 = colorStateList1;
      } 
    } 
    return colorStateList2;
  }
  
  public void onConfigurationChanged(@NonNull Context paramContext) {
    synchronized (this.mDrawableCacheLock) {
      LongSparseArray longSparseArray = this.mDrawableCaches.get(paramContext);
      if (longSparseArray != null)
        longSparseArray.clear(); 
      return;
    } 
  }
  
  Drawable onDrawableLoadedFromResources(@NonNull Context paramContext, @NonNull VectorEnabledTintResources paramVectorEnabledTintResources, @DrawableRes int paramInt) {
    Drawable drawable2 = loadDrawableFromDelegates(paramContext, paramInt);
    Drawable drawable1 = drawable2;
    if (drawable2 == null)
      drawable1 = paramVectorEnabledTintResources.superGetDrawable(paramInt); 
    return (drawable1 != null) ? tintDrawable(paramContext, paramInt, false, drawable1) : null;
  }
  
  @TargetApi(11)
  @RequiresApi(11)
  private static class AvdcInflateDelegate implements InflateDelegate {
    @SuppressLint({"NewApi"})
    public Drawable createFromXmlInner(@NonNull Context param1Context, @NonNull XmlPullParser param1XmlPullParser, @NonNull AttributeSet param1AttributeSet, @Nullable Resources.Theme param1Theme) {
      try {
        return (Drawable)AnimatedVectorDrawableCompat.createFromXmlInner(param1Context, param1Context.getResources(), param1XmlPullParser, param1AttributeSet, param1Theme);
      } catch (Exception exception) {
        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", exception);
        return null;
      } 
    }
  }
  
  private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
    public ColorFilterLruCache(int param1Int) {
      super(param1Int);
    }
    
    private static int generateCacheKey(int param1Int, PorterDuff.Mode param1Mode) {
      return (param1Int + 31) * 31 + param1Mode.hashCode();
    }
    
    PorterDuffColorFilter get(int param1Int, PorterDuff.Mode param1Mode) {
      return (PorterDuffColorFilter)get(Integer.valueOf(generateCacheKey(param1Int, param1Mode)));
    }
    
    PorterDuffColorFilter put(int param1Int, PorterDuff.Mode param1Mode, PorterDuffColorFilter param1PorterDuffColorFilter) {
      return (PorterDuffColorFilter)put(Integer.valueOf(generateCacheKey(param1Int, param1Mode)), param1PorterDuffColorFilter);
    }
  }
  
  private static interface InflateDelegate {
    Drawable createFromXmlInner(@NonNull Context param1Context, @NonNull XmlPullParser param1XmlPullParser, @NonNull AttributeSet param1AttributeSet, @Nullable Resources.Theme param1Theme);
  }
  
  private static class VdcInflateDelegate implements InflateDelegate {
    @SuppressLint({"NewApi"})
    public Drawable createFromXmlInner(@NonNull Context param1Context, @NonNull XmlPullParser param1XmlPullParser, @NonNull AttributeSet param1AttributeSet, @Nullable Resources.Theme param1Theme) {
      try {
        return (Drawable)VectorDrawableCompat.createFromXmlInner(param1Context.getResources(), param1XmlPullParser, param1AttributeSet, param1Theme);
      } catch (Exception exception) {
        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", exception);
        return null;
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\AppCompatDrawableManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */