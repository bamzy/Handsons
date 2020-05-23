package android.support.v4.text;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(23)
@RequiresApi(23)
class ICUCompatApi23 {
  private static final String TAG = "ICUCompatIcs";
  
  private static Method sAddLikelySubtagsMethod;
  
  static {
    try {
      sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[] { Locale.class });
      return;
    } catch (Exception exception) {
      throw new IllegalStateException(exception);
    } 
  }
  
  public static String maximizeAndGetScript(Locale paramLocale) {
    try {
      return ((Locale)sAddLikelySubtagsMethod.invoke(null, new Object[] { paramLocale })).getScript();
    } catch (InvocationTargetException invocationTargetException) {
      Log.w("ICUCompatIcs", invocationTargetException);
    } catch (IllegalAccessException illegalAccessException) {
      Log.w("ICUCompatIcs", illegalAccessException);
    } 
    return paramLocale.getScript();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\text\ICUCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */