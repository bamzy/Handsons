package android.support.v7.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class AppCompatResources {
  private static final String LOG_TAG = "AppCompatResources";
  
  private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal<TypedValue>();
  
  private static final Object sColorStateCacheLock;
  
  private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>>(0);
  
  static {
    sColorStateCacheLock = new Object();
  }
  
  private static void addColorStateListToCache(@NonNull Context paramContext, @ColorRes int paramInt, @NonNull ColorStateList paramColorStateList) {
    synchronized (sColorStateCacheLock) {
      SparseArray<ColorStateListCacheEntry> sparseArray2 = sColorStateCaches.get(paramContext);
      SparseArray<ColorStateListCacheEntry> sparseArray1 = sparseArray2;
      if (sparseArray2 == null) {
        sparseArray1 = new SparseArray();
        sColorStateCaches.put(paramContext, sparseArray1);
      } 
      sparseArray1.append(paramInt, new ColorStateListCacheEntry(paramColorStateList, paramContext.getResources().getConfiguration()));
      return;
    } 
  }
  
  @Nullable
  private static ColorStateList getCachedColorStateList(@NonNull Context paramContext, @ColorRes int paramInt) {
    synchronized (sColorStateCacheLock) {
      SparseArray sparseArray = sColorStateCaches.get(paramContext);
      if (sparseArray != null && sparseArray.size() > 0) {
        ColorStateListCacheEntry colorStateListCacheEntry = (ColorStateListCacheEntry)sparseArray.get(paramInt);
        if (colorStateListCacheEntry != null) {
          if (colorStateListCacheEntry.configuration.equals(paramContext.getResources().getConfiguration()))
            return colorStateListCacheEntry.value; 
          sparseArray.remove(paramInt);
        } 
      } 
      return null;
    } 
  }
  
  public static ColorStateList getColorStateList(@NonNull Context paramContext, @ColorRes int paramInt) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramContext.getColorStateList(paramInt); 
    ColorStateList colorStateList2 = getCachedColorStateList(paramContext, paramInt);
    ColorStateList colorStateList1 = colorStateList2;
    if (colorStateList2 == null) {
      colorStateList1 = inflateColorStateList(paramContext, paramInt);
      if (colorStateList1 != null) {
        addColorStateListToCache(paramContext, paramInt, colorStateList1);
        return colorStateList1;
      } 
      return ContextCompat.getColorStateList(paramContext, paramInt);
    } 
    return colorStateList1;
  }
  
  @Nullable
  public static Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt) {
    return AppCompatDrawableManager.get().getDrawable(paramContext, paramInt);
  }
  
  @NonNull
  private static TypedValue getTypedValue() {
    TypedValue typedValue2 = TL_TYPED_VALUE.get();
    TypedValue typedValue1 = typedValue2;
    if (typedValue2 == null) {
      typedValue1 = new TypedValue();
      TL_TYPED_VALUE.set(typedValue1);
    } 
    return typedValue1;
  }
  
  @Nullable
  private static ColorStateList inflateColorStateList(Context paramContext, int paramInt) {
    if (isColorInt(paramContext, paramInt))
      return null; 
    Resources resources = paramContext.getResources();
    XmlResourceParser xmlResourceParser = resources.getXml(paramInt);
    try {
      return AppCompatColorStateListInflater.createFromXml(resources, (XmlPullParser)xmlResourceParser, paramContext.getTheme());
    } catch (Exception exception) {
      Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", exception);
      return null;
    } 
  }
  
  private static boolean isColorInt(@NonNull Context paramContext, @ColorRes int paramInt) {
    Resources resources = paramContext.getResources();
    TypedValue typedValue = getTypedValue();
    resources.getValue(paramInt, typedValue, true);
    return (typedValue.type >= 28 && typedValue.type <= 31);
  }
  
  private static class ColorStateListCacheEntry {
    final Configuration configuration;
    
    final ColorStateList value;
    
    ColorStateListCacheEntry(@NonNull ColorStateList param1ColorStateList, @NonNull Configuration param1Configuration) {
      this.value = param1ColorStateList;
      this.configuration = param1Configuration;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\content\res\AppCompatResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */