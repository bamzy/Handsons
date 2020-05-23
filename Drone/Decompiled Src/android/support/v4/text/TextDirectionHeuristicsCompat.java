package android.support.v4.text;

import java.nio.CharBuffer;
import java.util.Locale;

public final class TextDirectionHeuristicsCompat {
  public static final TextDirectionHeuristicCompat ANYRTL_LTR;
  
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
  
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
  
  public static final TextDirectionHeuristicCompat LOCALE;
  
  public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicInternal(null, false);
  
  public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicInternal(null, true);
  
  private static final int STATE_FALSE = 1;
  
  private static final int STATE_TRUE = 0;
  
  private static final int STATE_UNKNOWN = 2;
  
  static {
    FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
    FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
    ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
    LOCALE = TextDirectionHeuristicLocale.INSTANCE;
  }
  
  static int isRtlText(int paramInt) {
    switch (paramInt) {
      default:
        return 2;
      case 0:
        return 1;
      case 1:
      case 2:
        break;
    } 
    return 0;
  }
  
  static int isRtlTextOrFormat(int paramInt) {
    switch (paramInt) {
      default:
        return 2;
      case 0:
      case 14:
      case 15:
        return 1;
      case 1:
      case 2:
      case 16:
      case 17:
        break;
    } 
    return 0;
  }
  
  private static class AnyStrong implements TextDirectionAlgorithm {
    public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
    
    public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
    
    private final boolean mLookForRtl;
    
    static {
    
    }
    
    private AnyStrong(boolean param1Boolean) {
      this.mLookForRtl = param1Boolean;
    }
    
    public int checkRtl(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      boolean bool2 = true;
      boolean bool1 = false;
      int i = param1Int1;
      while (i < param1Int1 + param1Int2) {
        switch (TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(param1CharSequence.charAt(i)))) {
          case 0:
            if (this.mLookForRtl)
              return 0; 
            bool1 = true;
            i++;
            break;
          case 1:
            bool1 = bool2;
            if (this.mLookForRtl) {
              bool1 = true;
            } else {
              return bool1;
            } 
            i++;
            break;
        } 
      } 
      if (bool1) {
        bool1 = bool2;
        return !this.mLookForRtl ? 0 : bool1;
      } 
      return 2;
    }
  }
  
  private static class FirstStrong implements TextDirectionAlgorithm {
    public static final FirstStrong INSTANCE = new FirstStrong();
    
    public int checkRtl(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      int j = 2;
      int i;
      for (i = param1Int1; i < param1Int1 + param1Int2 && j == 2; i++)
        j = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(param1CharSequence.charAt(i))); 
      return j;
    }
  }
  
  private static interface TextDirectionAlgorithm {
    int checkRtl(CharSequence param1CharSequence, int param1Int1, int param1Int2);
  }
  
  private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
    private final TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;
    
    public TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat.TextDirectionAlgorithm param1TextDirectionAlgorithm) {
      this.mAlgorithm = param1TextDirectionAlgorithm;
    }
    
    private boolean doCheck(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      switch (this.mAlgorithm.checkRtl(param1CharSequence, param1Int1, param1Int2)) {
        default:
          return defaultIsRtl();
        case 0:
          return true;
        case 1:
          break;
      } 
      return false;
    }
    
    protected abstract boolean defaultIsRtl();
    
    public boolean isRtl(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      if (param1CharSequence == null || param1Int1 < 0 || param1Int2 < 0 || param1CharSequence.length() - param1Int2 < param1Int1)
        throw new IllegalArgumentException(); 
      return (this.mAlgorithm == null) ? defaultIsRtl() : doCheck(param1CharSequence, param1Int1, param1Int2);
    }
    
    public boolean isRtl(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
      return isRtl(CharBuffer.wrap(param1ArrayOfchar), param1Int1, param1Int2);
    }
  }
  
  private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
    private final boolean mDefaultIsRtl;
    
    TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm param1TextDirectionAlgorithm, boolean param1Boolean) {
      super(param1TextDirectionAlgorithm);
      this.mDefaultIsRtl = param1Boolean;
    }
    
    protected boolean defaultIsRtl() {
      return this.mDefaultIsRtl;
    }
  }
  
  private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
    public static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();
    
    public TextDirectionHeuristicLocale() {
      super(null);
    }
    
    protected boolean defaultIsRtl() {
      return (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\text\TextDirectionHeuristicsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */