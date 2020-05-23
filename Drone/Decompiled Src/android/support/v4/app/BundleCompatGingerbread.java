package android.support.v4.app;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import java.lang.reflect.Method;

@TargetApi(9)
@RequiresApi(9)
class BundleCompatGingerbread {
  private static final String TAG = "BundleCompatGingerbread";
  
  private static Method sGetIBinderMethod;
  
  private static boolean sGetIBinderMethodFetched;
  
  private static Method sPutIBinderMethod;
  
  private static boolean sPutIBinderMethodFetched;
  
  public static IBinder getBinder(Bundle paramBundle, String paramString) {
    // Byte code:
    //   0: getstatic android/support/v4/app/BundleCompatGingerbread.sGetIBinderMethodFetched : Z
    //   3: ifne -> 36
    //   6: ldc android/os/Bundle
    //   8: ldc 'getIBinder'
    //   10: iconst_1
    //   11: anewarray java/lang/Class
    //   14: dup
    //   15: iconst_0
    //   16: ldc java/lang/String
    //   18: aastore
    //   19: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   22: putstatic android/support/v4/app/BundleCompatGingerbread.sGetIBinderMethod : Ljava/lang/reflect/Method;
    //   25: getstatic android/support/v4/app/BundleCompatGingerbread.sGetIBinderMethod : Ljava/lang/reflect/Method;
    //   28: iconst_1
    //   29: invokevirtual setAccessible : (Z)V
    //   32: iconst_1
    //   33: putstatic android/support/v4/app/BundleCompatGingerbread.sGetIBinderMethodFetched : Z
    //   36: getstatic android/support/v4/app/BundleCompatGingerbread.sGetIBinderMethod : Ljava/lang/reflect/Method;
    //   39: ifnull -> 90
    //   42: getstatic android/support/v4/app/BundleCompatGingerbread.sGetIBinderMethod : Ljava/lang/reflect/Method;
    //   45: aload_0
    //   46: iconst_1
    //   47: anewarray java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_1
    //   53: aastore
    //   54: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast android/os/IBinder
    //   60: astore_0
    //   61: aload_0
    //   62: areturn
    //   63: astore_2
    //   64: ldc 'BundleCompatGingerbread'
    //   66: ldc 'Failed to retrieve getIBinder method'
    //   68: aload_2
    //   69: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   72: pop
    //   73: goto -> 32
    //   76: astore_0
    //   77: ldc 'BundleCompatGingerbread'
    //   79: ldc 'Failed to invoke getIBinder via reflection'
    //   81: aload_0
    //   82: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   85: pop
    //   86: aconst_null
    //   87: putstatic android/support/v4/app/BundleCompatGingerbread.sGetIBinderMethod : Ljava/lang/reflect/Method;
    //   90: aconst_null
    //   91: areturn
    //   92: astore_0
    //   93: goto -> 77
    //   96: astore_0
    //   97: goto -> 77
    // Exception table:
    //   from	to	target	type
    //   6	32	63	java/lang/NoSuchMethodException
    //   42	61	96	java/lang/reflect/InvocationTargetException
    //   42	61	76	java/lang/IllegalAccessException
    //   42	61	92	java/lang/IllegalArgumentException
  }
  
  public static void putBinder(Bundle paramBundle, String paramString, IBinder paramIBinder) {
    // Byte code:
    //   0: getstatic android/support/v4/app/BundleCompatGingerbread.sPutIBinderMethodFetched : Z
    //   3: ifne -> 41
    //   6: ldc android/os/Bundle
    //   8: ldc 'putIBinder'
    //   10: iconst_2
    //   11: anewarray java/lang/Class
    //   14: dup
    //   15: iconst_0
    //   16: ldc java/lang/String
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: ldc android/os/IBinder
    //   23: aastore
    //   24: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   27: putstatic android/support/v4/app/BundleCompatGingerbread.sPutIBinderMethod : Ljava/lang/reflect/Method;
    //   30: getstatic android/support/v4/app/BundleCompatGingerbread.sPutIBinderMethod : Ljava/lang/reflect/Method;
    //   33: iconst_1
    //   34: invokevirtual setAccessible : (Z)V
    //   37: iconst_1
    //   38: putstatic android/support/v4/app/BundleCompatGingerbread.sPutIBinderMethodFetched : Z
    //   41: getstatic android/support/v4/app/BundleCompatGingerbread.sPutIBinderMethod : Ljava/lang/reflect/Method;
    //   44: ifnull -> 67
    //   47: getstatic android/support/v4/app/BundleCompatGingerbread.sPutIBinderMethod : Ljava/lang/reflect/Method;
    //   50: aload_0
    //   51: iconst_2
    //   52: anewarray java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: aload_2
    //   62: aastore
    //   63: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: return
    //   68: astore_3
    //   69: ldc 'BundleCompatGingerbread'
    //   71: ldc 'Failed to retrieve putIBinder method'
    //   73: aload_3
    //   74: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   77: pop
    //   78: goto -> 37
    //   81: astore_0
    //   82: ldc 'BundleCompatGingerbread'
    //   84: ldc 'Failed to invoke putIBinder via reflection'
    //   86: aload_0
    //   87: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   90: pop
    //   91: aconst_null
    //   92: putstatic android/support/v4/app/BundleCompatGingerbread.sPutIBinderMethod : Ljava/lang/reflect/Method;
    //   95: return
    //   96: astore_0
    //   97: goto -> 82
    //   100: astore_0
    //   101: goto -> 82
    // Exception table:
    //   from	to	target	type
    //   6	37	68	java/lang/NoSuchMethodException
    //   47	67	100	java/lang/reflect/InvocationTargetException
    //   47	67	81	java/lang/IllegalAccessException
    //   47	67	96	java/lang/IllegalArgumentException
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\BundleCompatGingerbread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */