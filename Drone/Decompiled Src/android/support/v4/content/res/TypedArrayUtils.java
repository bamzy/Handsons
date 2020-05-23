package android.support.v4.content.res;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AnyRes;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleableRes;
import android.util.TypedValue;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TypedArrayUtils {
  public static int getAttr(Context paramContext, int paramInt1, int paramInt2) {
    TypedValue typedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt1, typedValue, true);
    return (typedValue.resourceId != 0) ? paramInt1 : paramInt2;
  }
  
  public static boolean getBoolean(TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2, boolean paramBoolean) {
    return paramTypedArray.getBoolean(paramInt1, paramTypedArray.getBoolean(paramInt2, paramBoolean));
  }
  
  public static Drawable getDrawable(TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2) {
    Drawable drawable2 = paramTypedArray.getDrawable(paramInt1);
    Drawable drawable1 = drawable2;
    if (drawable2 == null)
      drawable1 = paramTypedArray.getDrawable(paramInt2); 
    return drawable1;
  }
  
  public static int getInt(TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2, int paramInt3) {
    return paramTypedArray.getInt(paramInt1, paramTypedArray.getInt(paramInt2, paramInt3));
  }
  
  @AnyRes
  public static int getResourceId(TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2, @AnyRes int paramInt3) {
    return paramTypedArray.getResourceId(paramInt1, paramTypedArray.getResourceId(paramInt2, paramInt3));
  }
  
  public static String getString(TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2) {
    String str2 = paramTypedArray.getString(paramInt1);
    String str1 = str2;
    if (str2 == null)
      str1 = paramTypedArray.getString(paramInt2); 
    return str1;
  }
  
  public static CharSequence getText(TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2) {
    CharSequence charSequence2 = paramTypedArray.getText(paramInt1);
    CharSequence charSequence1 = charSequence2;
    if (charSequence2 == null)
      charSequence1 = paramTypedArray.getText(paramInt2); 
    return charSequence1;
  }
  
  public static CharSequence[] getTextArray(TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2) {
    CharSequence[] arrayOfCharSequence2 = paramTypedArray.getTextArray(paramInt1);
    CharSequence[] arrayOfCharSequence1 = arrayOfCharSequence2;
    if (arrayOfCharSequence2 == null)
      arrayOfCharSequence1 = paramTypedArray.getTextArray(paramInt2); 
    return arrayOfCharSequence1;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\res\TypedArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */