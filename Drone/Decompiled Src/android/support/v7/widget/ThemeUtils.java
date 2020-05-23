package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

class ThemeUtils {
  static final int[] ACTIVATED_STATE_SET;
  
  static final int[] CHECKED_STATE_SET;
  
  static final int[] DISABLED_STATE_SET;
  
  static final int[] EMPTY_STATE_SET;
  
  static final int[] FOCUSED_STATE_SET;
  
  static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET;
  
  static final int[] PRESSED_STATE_SET;
  
  static final int[] SELECTED_STATE_SET;
  
  private static final int[] TEMP_ARRAY;
  
  private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal<TypedValue>();
  
  static {
    DISABLED_STATE_SET = new int[] { -16842910 };
    FOCUSED_STATE_SET = new int[] { 16842908 };
    ACTIVATED_STATE_SET = new int[] { 16843518 };
    PRESSED_STATE_SET = new int[] { 16842919 };
    CHECKED_STATE_SET = new int[] { 16842912 };
    SELECTED_STATE_SET = new int[] { 16842913 };
    NOT_PRESSED_OR_FOCUSED_STATE_SET = new int[] { -16842919, -16842908 };
    EMPTY_STATE_SET = new int[0];
    TEMP_ARRAY = new int[1];
  }
  
  public static ColorStateList createDisabledStateList(int paramInt1, int paramInt2) {
    int[][] arrayOfInt = new int[2][];
    int[] arrayOfInt1 = new int[2];
    arrayOfInt[0] = DISABLED_STATE_SET;
    arrayOfInt1[0] = paramInt2;
    paramInt2 = 0 + 1;
    arrayOfInt[paramInt2] = EMPTY_STATE_SET;
    arrayOfInt1[paramInt2] = paramInt1;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  public static int getDisabledThemeAttrColor(Context paramContext, int paramInt) {
    ColorStateList colorStateList = getThemeAttrColorStateList(paramContext, paramInt);
    if (colorStateList != null && colorStateList.isStateful())
      return colorStateList.getColorForState(DISABLED_STATE_SET, colorStateList.getDefaultColor()); 
    TypedValue typedValue = getTypedValue();
    paramContext.getTheme().resolveAttribute(16842803, typedValue, true);
    return getThemeAttrColor(paramContext, paramInt, typedValue.getFloat());
  }
  
  public static int getThemeAttrColor(Context paramContext, int paramInt) {
    TEMP_ARRAY[0] = paramInt;
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, (AttributeSet)null, TEMP_ARRAY);
    try {
      paramInt = tintTypedArray.getColor(0, 0);
      return paramInt;
    } finally {
      tintTypedArray.recycle();
    } 
  }
  
  static int getThemeAttrColor(Context paramContext, int paramInt, float paramFloat) {
    paramInt = getThemeAttrColor(paramContext, paramInt);
    return ColorUtils.setAlphaComponent(paramInt, Math.round(Color.alpha(paramInt) * paramFloat));
  }
  
  public static ColorStateList getThemeAttrColorStateList(Context paramContext, int paramInt) {
    TEMP_ARRAY[0] = paramInt;
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, (AttributeSet)null, TEMP_ARRAY);
    try {
      return tintTypedArray.getColorStateList(0);
    } finally {
      tintTypedArray.recycle();
    } 
  }
  
  private static TypedValue getTypedValue() {
    TypedValue typedValue2 = TL_TYPED_VALUE.get();
    TypedValue typedValue1 = typedValue2;
    if (typedValue2 == null) {
      typedValue1 = new TypedValue();
      TL_TYPED_VALUE.set(typedValue1);
    } 
    return typedValue1;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\ThemeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */