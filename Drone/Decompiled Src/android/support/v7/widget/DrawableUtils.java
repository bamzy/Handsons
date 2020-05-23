package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.util.Log;
import java.lang.reflect.Field;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DrawableUtils {
  public static final Rect INSETS_NONE = new Rect();
  
  private static final String TAG = "DrawableUtils";
  
  private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
  
  private static Class<?> sInsetsClazz;
  
  static {
    if (Build.VERSION.SDK_INT >= 18)
      try {
        sInsetsClazz = Class.forName("android.graphics.Insets");
        return;
      } catch (ClassNotFoundException classNotFoundException) {
        return;
      }  
  }
  
  public static boolean canSafelyMutateDrawable(@NonNull Drawable paramDrawable) {
    if ((Build.VERSION.SDK_INT >= 15 || !(paramDrawable instanceof android.graphics.drawable.InsetDrawable)) && (Build.VERSION.SDK_INT >= 15 || !(paramDrawable instanceof android.graphics.drawable.GradientDrawable)) && (Build.VERSION.SDK_INT >= 17 || !(paramDrawable instanceof android.graphics.drawable.LayerDrawable))) {
      Drawable[] arrayOfDrawable;
      if (paramDrawable instanceof DrawableContainer) {
        Drawable.ConstantState constantState = paramDrawable.getConstantState();
        if (constantState instanceof DrawableContainer.DrawableContainerState) {
          arrayOfDrawable = ((DrawableContainer.DrawableContainerState)constantState).getChildren();
          int j = arrayOfDrawable.length;
          int i = 0;
          while (i < j) {
            if (canSafelyMutateDrawable(arrayOfDrawable[i])) {
              i++;
              continue;
            } 
            return false;
          } 
        } 
      } else {
        if (arrayOfDrawable instanceof DrawableWrapper)
          return canSafelyMutateDrawable(((DrawableWrapper)arrayOfDrawable).getWrappedDrawable()); 
        if (arrayOfDrawable instanceof DrawableWrapper)
          return canSafelyMutateDrawable(((DrawableWrapper)arrayOfDrawable).getWrappedDrawable()); 
        if (arrayOfDrawable instanceof ScaleDrawable)
          return canSafelyMutateDrawable(((ScaleDrawable)arrayOfDrawable).getDrawable()); 
      } 
      return true;
    } 
    return false;
  }
  
  static void fixDrawable(@NonNull Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()))
      fixVectorDrawableTinting(paramDrawable); 
  }
  
  private static void fixVectorDrawableTinting(Drawable paramDrawable) {
    int[] arrayOfInt = paramDrawable.getState();
    if (arrayOfInt == null || arrayOfInt.length == 0) {
      paramDrawable.setState(ThemeUtils.CHECKED_STATE_SET);
    } else {
      paramDrawable.setState(ThemeUtils.EMPTY_STATE_SET);
    } 
    paramDrawable.setState(arrayOfInt);
  }
  
  public static Rect getOpticalBounds(Drawable paramDrawable) {
    if (sInsetsClazz != null)
      try {
        paramDrawable = DrawableCompat.unwrap(paramDrawable);
        Object object = paramDrawable.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(paramDrawable, new Object[0]);
        if (object != null) {
          Rect rect = new Rect();
          Field[] arrayOfField = sInsetsClazz.getFields();
          int j = arrayOfField.length;
          for (int i = 0;; i++) {
            Field field;
            byte b;
            Rect rect1 = rect;
            if (i < j) {
              field = arrayOfField[i];
              String str = field.getName();
              b = -1;
              switch (str.hashCode()) {
                case 3317767:
                  if (str.equals("left"))
                    b = 0; 
                  break;
                case 115029:
                  if (str.equals("top"))
                    b = 1; 
                  break;
                case 108511772:
                  if (str.equals("right"))
                    b = 2; 
                  break;
                case -1383228885:
                  if (str.equals("bottom"))
                    b = 3; 
                  break;
              } 
            } else {
              return (Rect)field;
            } 
            switch (b) {
              case 0:
                rect.left = field.getInt(object);
                break;
              case 1:
                rect.top = field.getInt(object);
                break;
              case 2:
                rect.right = field.getInt(object);
                break;
              case 3:
                rect.bottom = field.getInt(object);
                break;
            } 
          } 
        } 
      } catch (Exception exception) {
        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
      }  
    return INSETS_NONE;
  }
  
  static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode) {
    switch (paramInt) {
      default:
        return paramMode;
      case 3:
        return PorterDuff.Mode.SRC_OVER;
      case 5:
        return PorterDuff.Mode.SRC_IN;
      case 9:
        return PorterDuff.Mode.SRC_ATOP;
      case 14:
        return PorterDuff.Mode.MULTIPLY;
      case 15:
        return PorterDuff.Mode.SCREEN;
      case 16:
        break;
    } 
    if (Build.VERSION.SDK_INT >= 11)
      return PorterDuff.Mode.valueOf("ADD"); 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */