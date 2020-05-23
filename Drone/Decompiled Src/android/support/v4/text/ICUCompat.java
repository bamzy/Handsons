package android.support.v4.text;

import android.os.Build;
import java.util.Locale;

public final class ICUCompat {
  private static final ICUCompatImpl IMPL = new ICUCompatImplBase();
  
  public static String maximizeAndGetScript(Locale paramLocale) {
    return IMPL.maximizeAndGetScript(paramLocale);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      IMPL = new ICUCompatImplLollipop();
      return;
    } 
    if (i >= 14) {
      IMPL = new ICUCompatImplIcs();
      return;
    } 
  }
  
  static interface ICUCompatImpl {
    String maximizeAndGetScript(Locale param1Locale);
  }
  
  static class ICUCompatImplBase implements ICUCompatImpl {
    public String maximizeAndGetScript(Locale param1Locale) {
      return null;
    }
  }
  
  static class ICUCompatImplIcs implements ICUCompatImpl {
    public String maximizeAndGetScript(Locale param1Locale) {
      return ICUCompatIcs.maximizeAndGetScript(param1Locale);
    }
  }
  
  static class ICUCompatImplLollipop implements ICUCompatImpl {
    public String maximizeAndGetScript(Locale param1Locale) {
      return ICUCompatApi23.maximizeAndGetScript(param1Locale);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\text\ICUCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */