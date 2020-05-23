package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.BuildCompat;
import android.util.TypedValue;
import java.io.File;

public class ContextCompat {
  private static final String DIR_ANDROID = "Android";
  
  private static final String DIR_OBB = "obb";
  
  private static final String TAG = "ContextCompat";
  
  private static final Object sLock = new Object();
  
  private static TypedValue sTempValue;
  
  private static File buildPath(File paramFile, String... paramVarArgs) {
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      String str = paramVarArgs[i];
      if (paramFile == null) {
        paramFile = new File(str);
      } else if (str != null) {
        paramFile = new File(paramFile, str);
      } 
    } 
    return paramFile;
  }
  
  public static int checkSelfPermission(@NonNull Context paramContext, @NonNull String paramString) {
    if (paramString == null)
      throw new IllegalArgumentException("permission is null"); 
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
  }
  
  public static Context createDeviceProtectedStorageContext(Context paramContext) {
    return BuildCompat.isAtLeastN() ? ContextCompatApi24.createDeviceProtectedStorageContext(paramContext) : null;
  }
  
  private static File createFilesDir(File paramFile) {
    // Byte code:
    //   0: ldc android/support/v4/content/ContextCompat
    //   2: monitorenter
    //   3: aload_0
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual exists : ()Z
    //   9: ifne -> 32
    //   12: aload_0
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual mkdirs : ()Z
    //   18: ifne -> 32
    //   21: aload_0
    //   22: invokevirtual exists : ()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifeq -> 37
    //   30: aload_0
    //   31: astore_2
    //   32: ldc android/support/v4/content/ContextCompat
    //   34: monitorexit
    //   35: aload_2
    //   36: areturn
    //   37: ldc 'ContextCompat'
    //   39: new java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial <init> : ()V
    //   46: ldc 'Unable to create files subdir '
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: invokevirtual getPath : ()Ljava/lang/String;
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: aconst_null
    //   66: astore_2
    //   67: goto -> 32
    //   70: astore_0
    //   71: ldc android/support/v4/content/ContextCompat
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    // Exception table:
    //   from	to	target	type
    //   5	12	70	finally
    //   14	26	70	finally
    //   37	65	70	finally
  }
  
  public static File getCodeCacheDir(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 21) ? ContextCompatApi21.getCodeCacheDir(paramContext) : createFilesDir(new File((paramContext.getApplicationInfo()).dataDir, "code_cache"));
  }
  
  @ColorInt
  public static final int getColor(Context paramContext, @ColorRes int paramInt) {
    return (Build.VERSION.SDK_INT >= 23) ? ContextCompatApi23.getColor(paramContext, paramInt) : paramContext.getResources().getColor(paramInt);
  }
  
  public static final ColorStateList getColorStateList(Context paramContext, @ColorRes int paramInt) {
    return (Build.VERSION.SDK_INT >= 23) ? ContextCompatApi23.getColorStateList(paramContext, paramInt) : paramContext.getResources().getColorStateList(paramInt);
  }
  
  public static File getDataDir(Context paramContext) {
    if (BuildCompat.isAtLeastN())
      return ContextCompatApi24.getDataDir(paramContext); 
    String str = (paramContext.getApplicationInfo()).dataDir;
    return (str != null) ? new File(str) : null;
  }
  
  public static final Drawable getDrawable(Context paramContext, @DrawableRes int paramInt) {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
      return ContextCompatApi21.getDrawable(paramContext, paramInt); 
    if (i >= 16)
      return paramContext.getResources().getDrawable(paramInt); 
    synchronized (sLock) {
      if (sTempValue == null)
        sTempValue = new TypedValue(); 
      paramContext.getResources().getValue(paramInt, sTempValue, true);
      paramInt = sTempValue.resourceId;
      return paramContext.getResources().getDrawable(paramInt);
    } 
  }
  
  public static File[] getExternalCacheDirs(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 19) ? ContextCompatKitKat.getExternalCacheDirs(paramContext) : new File[] { paramContext.getExternalCacheDir() };
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString) {
    return (Build.VERSION.SDK_INT >= 19) ? ContextCompatKitKat.getExternalFilesDirs(paramContext, paramString) : new File[] { paramContext.getExternalFilesDir(paramString) };
  }
  
  public static final File getNoBackupFilesDir(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 21) ? ContextCompatApi21.getNoBackupFilesDir(paramContext) : createFilesDir(new File((paramContext.getApplicationInfo()).dataDir, "no_backup"));
  }
  
  public static File[] getObbDirs(Context paramContext) {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
      return ContextCompatKitKat.getObbDirs(paramContext); 
    if (i >= 11) {
      file = ContextCompatHoneycomb.getObbDir(paramContext);
      return new File[] { file };
    } 
    File file = buildPath(Environment.getExternalStorageDirectory(), new String[] { "Android", "obb", file.getPackageName() });
    return new File[] { file };
  }
  
  public static boolean isDeviceProtectedStorage(Context paramContext) {
    return BuildCompat.isAtLeastN() ? ContextCompatApi24.isDeviceProtectedStorage(paramContext) : false;
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent) {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle) {
    int i = Build.VERSION.SDK_INT;
    if (i >= 16) {
      ContextCompatJellybean.startActivities(paramContext, paramArrayOfIntent, paramBundle);
      return true;
    } 
    if (i >= 11) {
      ContextCompatHoneycomb.startActivities(paramContext, paramArrayOfIntent);
      return true;
    } 
    return false;
  }
  
  public static void startActivity(Context paramContext, Intent paramIntent, @Nullable Bundle paramBundle) {
    if (Build.VERSION.SDK_INT >= 16) {
      ContextCompatJellybean.startActivity(paramContext, paramIntent, paramBundle);
      return;
    } 
    paramContext.startActivity(paramIntent);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\ContextCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */