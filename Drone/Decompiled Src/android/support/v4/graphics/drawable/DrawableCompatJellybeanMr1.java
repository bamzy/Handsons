package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import java.lang.reflect.Method;

@TargetApi(17)
@RequiresApi(17)
class DrawableCompatJellybeanMr1 {
  private static final String TAG = "DrawableCompatJellybeanMr1";
  
  private static Method sGetLayoutDirectionMethod;
  
  private static boolean sGetLayoutDirectionMethodFetched;
  
  private static Method sSetLayoutDirectionMethod;
  
  private static boolean sSetLayoutDirectionMethodFetched;
  
  public static int getLayoutDirection(Drawable paramDrawable) {
    // Byte code:
    //   0: getstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sGetLayoutDirectionMethodFetched : Z
    //   3: ifne -> 31
    //   6: ldc android/graphics/drawable/Drawable
    //   8: ldc 'getLayoutDirection'
    //   10: iconst_0
    //   11: anewarray java/lang/Class
    //   14: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   17: putstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod : Ljava/lang/reflect/Method;
    //   20: getstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod : Ljava/lang/reflect/Method;
    //   23: iconst_1
    //   24: invokevirtual setAccessible : (Z)V
    //   27: iconst_1
    //   28: putstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sGetLayoutDirectionMethodFetched : Z
    //   31: getstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod : Ljava/lang/reflect/Method;
    //   34: ifnull -> 84
    //   37: getstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod : Ljava/lang/reflect/Method;
    //   40: aload_0
    //   41: iconst_0
    //   42: anewarray java/lang/Object
    //   45: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast java/lang/Integer
    //   51: invokevirtual intValue : ()I
    //   54: istore_1
    //   55: iload_1
    //   56: ireturn
    //   57: astore_2
    //   58: ldc 'DrawableCompatJellybeanMr1'
    //   60: ldc 'Failed to retrieve getLayoutDirection() method'
    //   62: aload_2
    //   63: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   66: pop
    //   67: goto -> 27
    //   70: astore_0
    //   71: ldc 'DrawableCompatJellybeanMr1'
    //   73: ldc 'Failed to invoke getLayoutDirection() via reflection'
    //   75: aload_0
    //   76: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   79: pop
    //   80: aconst_null
    //   81: putstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod : Ljava/lang/reflect/Method;
    //   84: iconst_m1
    //   85: ireturn
    // Exception table:
    //   from	to	target	type
    //   6	27	57	java/lang/NoSuchMethodException
    //   37	55	70	java/lang/Exception
  }
  
  public static boolean setLayoutDirection(Drawable paramDrawable, int paramInt) {
    // Byte code:
    //   0: getstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sSetLayoutDirectionMethodFetched : Z
    //   3: ifne -> 37
    //   6: ldc android/graphics/drawable/Drawable
    //   8: ldc 'setLayoutDirection'
    //   10: iconst_1
    //   11: anewarray java/lang/Class
    //   14: dup
    //   15: iconst_0
    //   16: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   19: aastore
    //   20: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   23: putstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod : Ljava/lang/reflect/Method;
    //   26: getstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod : Ljava/lang/reflect/Method;
    //   29: iconst_1
    //   30: invokevirtual setAccessible : (Z)V
    //   33: iconst_1
    //   34: putstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sSetLayoutDirectionMethodFetched : Z
    //   37: getstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod : Ljava/lang/reflect/Method;
    //   40: ifnull -> 91
    //   43: getstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod : Ljava/lang/reflect/Method;
    //   46: aload_0
    //   47: iconst_1
    //   48: anewarray java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: iload_1
    //   54: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: iconst_1
    //   63: ireturn
    //   64: astore_2
    //   65: ldc 'DrawableCompatJellybeanMr1'
    //   67: ldc 'Failed to retrieve setLayoutDirection(int) method'
    //   69: aload_2
    //   70: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   73: pop
    //   74: goto -> 33
    //   77: astore_0
    //   78: ldc 'DrawableCompatJellybeanMr1'
    //   80: ldc 'Failed to invoke setLayoutDirection(int) via reflection'
    //   82: aload_0
    //   83: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   86: pop
    //   87: aconst_null
    //   88: putstatic android/support/v4/graphics/drawable/DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod : Ljava/lang/reflect/Method;
    //   91: iconst_0
    //   92: ireturn
    // Exception table:
    //   from	to	target	type
    //   6	33	64	java/lang/NoSuchMethodException
    //   43	62	77	java/lang/Exception
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableCompatJellybeanMr1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */