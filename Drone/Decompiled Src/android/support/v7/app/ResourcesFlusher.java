package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;
import java.lang.reflect.Field;

class ResourcesFlusher {
  private static final String TAG = "ResourcesFlusher";
  
  private static Field sDrawableCacheField;
  
  private static boolean sDrawableCacheFieldFetched;
  
  private static Field sResourcesImplField;
  
  private static boolean sResourcesImplFieldFetched;
  
  private static Class sThemedResourceCacheClazz;
  
  private static boolean sThemedResourceCacheClazzFetched;
  
  private static Field sThemedResourceCache_mUnthemedEntriesField;
  
  private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;
  
  static boolean flush(@NonNull Resources paramResources) {
    int i = Build.VERSION.SDK_INT;
    return (i >= 24) ? flushNougats(paramResources) : ((i >= 23) ? flushMarshmallows(paramResources) : ((i >= 21) ? flushLollipops(paramResources) : false));
  }
  
  private static boolean flushLollipops(@NonNull Resources paramResources) {
    // Byte code:
    //   0: getstatic android/support/v7/app/ResourcesFlusher.sDrawableCacheFieldFetched : Z
    //   3: ifne -> 27
    //   6: ldc android/content/res/Resources
    //   8: ldc 'mDrawableCache'
    //   10: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   13: putstatic android/support/v7/app/ResourcesFlusher.sDrawableCacheField : Ljava/lang/reflect/Field;
    //   16: getstatic android/support/v7/app/ResourcesFlusher.sDrawableCacheField : Ljava/lang/reflect/Field;
    //   19: iconst_1
    //   20: invokevirtual setAccessible : (Z)V
    //   23: iconst_1
    //   24: putstatic android/support/v7/app/ResourcesFlusher.sDrawableCacheFieldFetched : Z
    //   27: getstatic android/support/v7/app/ResourcesFlusher.sDrawableCacheField : Ljava/lang/reflect/Field;
    //   30: ifnull -> 86
    //   33: aconst_null
    //   34: astore_1
    //   35: getstatic android/support/v7/app/ResourcesFlusher.sDrawableCacheField : Ljava/lang/reflect/Field;
    //   38: aload_0
    //   39: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast java/util/Map
    //   45: astore_0
    //   46: aload_0
    //   47: ifnull -> 86
    //   50: aload_0
    //   51: invokeinterface clear : ()V
    //   56: iconst_1
    //   57: ireturn
    //   58: astore_1
    //   59: ldc 'ResourcesFlusher'
    //   61: ldc 'Could not retrieve Resources#mDrawableCache field'
    //   63: aload_1
    //   64: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   67: pop
    //   68: goto -> 23
    //   71: astore_0
    //   72: ldc 'ResourcesFlusher'
    //   74: ldc 'Could not retrieve value from Resources#mDrawableCache'
    //   76: aload_0
    //   77: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   80: pop
    //   81: aload_1
    //   82: astore_0
    //   83: goto -> 46
    //   86: iconst_0
    //   87: ireturn
    // Exception table:
    //   from	to	target	type
    //   6	23	58	java/lang/NoSuchFieldException
    //   35	46	71	java/lang/IllegalAccessException
  }
  
  private static boolean flushMarshmallows(@NonNull Resources paramResources) {
    boolean bool = true;
    if (!sDrawableCacheFieldFetched) {
      try {
        sDrawableCacheField = Resources.class.getDeclaredField("mDrawableCache");
        sDrawableCacheField.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", noSuchFieldException);
      } 
      sDrawableCacheFieldFetched = true;
    } 
    Object object1 = null;
    Object object = object1;
    if (sDrawableCacheField != null) {
      try {
        object = sDrawableCacheField.get(paramResources);
        if (object == null)
          return false; 
      } catch (IllegalAccessException illegalAccessException) {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", illegalAccessException);
        object = object1;
        if (object == null)
          return false; 
      } 
      if (object == null || !flushThemedResourcesCache(object))
        bool = false; 
      return bool;
    } 
    if (object == null)
      return false; 
  }
  
  private static boolean flushNougats(@NonNull Resources paramResources) {
    boolean bool = true;
    if (!sResourcesImplFieldFetched) {
      try {
        sResourcesImplField = Resources.class.getDeclaredField("mResourcesImpl");
        sResourcesImplField.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", noSuchFieldException);
      } 
      sResourcesImplFieldFetched = true;
    } 
    if (sResourcesImplField != null) {
      Object object = null;
      try {
        Object object1 = sResourcesImplField.get(paramResources);
        if (object1 != null) {
          if (!sDrawableCacheFieldFetched) {
            try {
              sDrawableCacheField = object1.getClass().getDeclaredField("mDrawableCache");
              sDrawableCacheField.setAccessible(true);
            } catch (NoSuchFieldException noSuchFieldException) {
              Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", noSuchFieldException);
            } 
            sDrawableCacheFieldFetched = true;
          } 
          Object object2 = null;
          object = object2;
          if (sDrawableCacheField != null)
            try {
              object = sDrawableCacheField.get(object1);
            } catch (IllegalAccessException illegalAccessException) {
              Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", illegalAccessException);
              object = object2;
            }  
          if (object == null || !flushThemedResourcesCache(object))
            bool = false; 
          return bool;
        } 
      } catch (IllegalAccessException illegalAccessException) {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", illegalAccessException);
        Object object1 = object;
      } 
    } 
    return false;
  }
  
  private static boolean flushThemedResourcesCache(@NonNull Object paramObject) {
    // Byte code:
    //   0: getstatic android/support/v7/app/ResourcesFlusher.sThemedResourceCacheClazzFetched : Z
    //   3: ifne -> 18
    //   6: ldc 'android.content.res.ThemedResourceCache'
    //   8: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   11: putstatic android/support/v7/app/ResourcesFlusher.sThemedResourceCacheClazz : Ljava/lang/Class;
    //   14: iconst_1
    //   15: putstatic android/support/v7/app/ResourcesFlusher.sThemedResourceCacheClazzFetched : Z
    //   18: getstatic android/support/v7/app/ResourcesFlusher.sThemedResourceCacheClazz : Ljava/lang/Class;
    //   21: ifnonnull -> 39
    //   24: iconst_0
    //   25: ireturn
    //   26: astore_1
    //   27: ldc 'ResourcesFlusher'
    //   29: ldc 'Could not find ThemedResourceCache class'
    //   31: aload_1
    //   32: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   35: pop
    //   36: goto -> 14
    //   39: getstatic android/support/v7/app/ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesFieldFetched : Z
    //   42: ifne -> 67
    //   45: getstatic android/support/v7/app/ResourcesFlusher.sThemedResourceCacheClazz : Ljava/lang/Class;
    //   48: ldc 'mUnthemedEntries'
    //   50: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   53: putstatic android/support/v7/app/ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesField : Ljava/lang/reflect/Field;
    //   56: getstatic android/support/v7/app/ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesField : Ljava/lang/reflect/Field;
    //   59: iconst_1
    //   60: invokevirtual setAccessible : (Z)V
    //   63: iconst_1
    //   64: putstatic android/support/v7/app/ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesFieldFetched : Z
    //   67: getstatic android/support/v7/app/ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesField : Ljava/lang/reflect/Field;
    //   70: ifnonnull -> 88
    //   73: iconst_0
    //   74: ireturn
    //   75: astore_1
    //   76: ldc 'ResourcesFlusher'
    //   78: ldc 'Could not retrieve ThemedResourceCache#mUnthemedEntries field'
    //   80: aload_1
    //   81: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   84: pop
    //   85: goto -> 63
    //   88: aconst_null
    //   89: astore_1
    //   90: getstatic android/support/v7/app/ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesField : Ljava/lang/reflect/Field;
    //   93: aload_0
    //   94: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast android/util/LongSparseArray
    //   100: astore_0
    //   101: aload_0
    //   102: ifnull -> 126
    //   105: aload_0
    //   106: invokevirtual clear : ()V
    //   109: iconst_1
    //   110: ireturn
    //   111: astore_0
    //   112: ldc 'ResourcesFlusher'
    //   114: ldc 'Could not retrieve value from ThemedResourceCache#mUnthemedEntries'
    //   116: aload_0
    //   117: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   120: pop
    //   121: aload_1
    //   122: astore_0
    //   123: goto -> 101
    //   126: iconst_0
    //   127: ireturn
    // Exception table:
    //   from	to	target	type
    //   6	14	26	java/lang/ClassNotFoundException
    //   45	63	75	java/lang/NoSuchFieldException
    //   90	101	111	java/lang/IllegalAccessException
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\app\ResourcesFlusher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */