package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

@TargetApi(9)
@RequiresApi(9)
class CompoundButtonCompatGingerbread {
  private static final String TAG = "CompoundButtonCompatGingerbread";
  
  private static Field sButtonDrawableField;
  
  private static boolean sButtonDrawableFieldFetched;
  
  static Drawable getButtonDrawable(CompoundButton paramCompoundButton) {
    // Byte code:
    //   0: getstatic android/support/v4/widget/CompoundButtonCompatGingerbread.sButtonDrawableFieldFetched : Z
    //   3: ifne -> 27
    //   6: ldc android/widget/CompoundButton
    //   8: ldc 'mButtonDrawable'
    //   10: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   13: putstatic android/support/v4/widget/CompoundButtonCompatGingerbread.sButtonDrawableField : Ljava/lang/reflect/Field;
    //   16: getstatic android/support/v4/widget/CompoundButtonCompatGingerbread.sButtonDrawableField : Ljava/lang/reflect/Field;
    //   19: iconst_1
    //   20: invokevirtual setAccessible : (Z)V
    //   23: iconst_1
    //   24: putstatic android/support/v4/widget/CompoundButtonCompatGingerbread.sButtonDrawableFieldFetched : Z
    //   27: getstatic android/support/v4/widget/CompoundButtonCompatGingerbread.sButtonDrawableField : Ljava/lang/reflect/Field;
    //   30: ifnull -> 73
    //   33: getstatic android/support/v4/widget/CompoundButtonCompatGingerbread.sButtonDrawableField : Ljava/lang/reflect/Field;
    //   36: aload_0
    //   37: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast android/graphics/drawable/Drawable
    //   43: astore_0
    //   44: aload_0
    //   45: areturn
    //   46: astore_1
    //   47: ldc 'CompoundButtonCompatGingerbread'
    //   49: ldc 'Failed to retrieve mButtonDrawable field'
    //   51: aload_1
    //   52: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   55: pop
    //   56: goto -> 23
    //   59: astore_0
    //   60: ldc 'CompoundButtonCompatGingerbread'
    //   62: ldc 'Failed to get button drawable via reflection'
    //   64: aload_0
    //   65: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   68: pop
    //   69: aconst_null
    //   70: putstatic android/support/v4/widget/CompoundButtonCompatGingerbread.sButtonDrawableField : Ljava/lang/reflect/Field;
    //   73: aconst_null
    //   74: areturn
    // Exception table:
    //   from	to	target	type
    //   6	23	46	java/lang/NoSuchFieldException
    //   33	44	59	java/lang/IllegalAccessException
  }
  
  static ColorStateList getButtonTintList(CompoundButton paramCompoundButton) {
    return (paramCompoundButton instanceof TintableCompoundButton) ? ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintList() : null;
  }
  
  static PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton) {
    return (paramCompoundButton instanceof TintableCompoundButton) ? ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintMode() : null;
  }
  
  static void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList) {
    if (paramCompoundButton instanceof TintableCompoundButton)
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintList(paramColorStateList); 
  }
  
  static void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode) {
    if (paramCompoundButton instanceof TintableCompoundButton)
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintMode(paramMode); 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\CompoundButtonCompatGingerbread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */