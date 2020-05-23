package android.support.v4.view;

import android.os.Build;
import android.view.ViewGroup;

public final class MarginLayoutParamsCompat {
  static final MarginLayoutParamsCompatImpl IMPL = new MarginLayoutParamsCompatImplBase();
  
  public static int getLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
    int j = IMPL.getLayoutDirection(paramMarginLayoutParams);
    int i = j;
    if (j != 0) {
      i = j;
      if (j != 1)
        i = 0; 
    } 
    return i;
  }
  
  public static int getMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
    return IMPL.getMarginEnd(paramMarginLayoutParams);
  }
  
  public static int getMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
    return IMPL.getMarginStart(paramMarginLayoutParams);
  }
  
  public static boolean isMarginRelative(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
    return IMPL.isMarginRelative(paramMarginLayoutParams);
  }
  
  public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt) {
    IMPL.resolveLayoutDirection(paramMarginLayoutParams, paramInt);
  }
  
  public static void setLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt) {
    IMPL.setLayoutDirection(paramMarginLayoutParams, paramInt);
  }
  
  public static void setMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt) {
    IMPL.setMarginEnd(paramMarginLayoutParams, paramInt);
  }
  
  public static void setMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt) {
    IMPL.setMarginStart(paramMarginLayoutParams, paramInt);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 17) {
      IMPL = new MarginLayoutParamsCompatImplJbMr1();
      return;
    } 
  }
  
  static interface MarginLayoutParamsCompatImpl {
    int getLayoutDirection(ViewGroup.MarginLayoutParams param1MarginLayoutParams);
    
    int getMarginEnd(ViewGroup.MarginLayoutParams param1MarginLayoutParams);
    
    int getMarginStart(ViewGroup.MarginLayoutParams param1MarginLayoutParams);
    
    boolean isMarginRelative(ViewGroup.MarginLayoutParams param1MarginLayoutParams);
    
    void resolveLayoutDirection(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int);
    
    void setLayoutDirection(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int);
    
    void setMarginEnd(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int);
    
    void setMarginStart(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int);
  }
  
  static class MarginLayoutParamsCompatImplBase implements MarginLayoutParamsCompatImpl {
    public int getLayoutDirection(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      return 0;
    }
    
    public int getMarginEnd(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      return param1MarginLayoutParams.rightMargin;
    }
    
    public int getMarginStart(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      return param1MarginLayoutParams.leftMargin;
    }
    
    public boolean isMarginRelative(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      return false;
    }
    
    public void resolveLayoutDirection(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int) {}
    
    public void setLayoutDirection(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int) {}
    
    public void setMarginEnd(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int) {
      param1MarginLayoutParams.rightMargin = param1Int;
    }
    
    public void setMarginStart(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int) {
      param1MarginLayoutParams.leftMargin = param1Int;
    }
  }
  
  static class MarginLayoutParamsCompatImplJbMr1 implements MarginLayoutParamsCompatImpl {
    public int getLayoutDirection(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      return MarginLayoutParamsCompatJellybeanMr1.getLayoutDirection(param1MarginLayoutParams);
    }
    
    public int getMarginEnd(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      return MarginLayoutParamsCompatJellybeanMr1.getMarginEnd(param1MarginLayoutParams);
    }
    
    public int getMarginStart(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      return MarginLayoutParamsCompatJellybeanMr1.getMarginStart(param1MarginLayoutParams);
    }
    
    public boolean isMarginRelative(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      return MarginLayoutParamsCompatJellybeanMr1.isMarginRelative(param1MarginLayoutParams);
    }
    
    public void resolveLayoutDirection(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int) {
      MarginLayoutParamsCompatJellybeanMr1.resolveLayoutDirection(param1MarginLayoutParams, param1Int);
    }
    
    public void setLayoutDirection(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int) {
      MarginLayoutParamsCompatJellybeanMr1.setLayoutDirection(param1MarginLayoutParams, param1Int);
    }
    
    public void setMarginEnd(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int) {
      MarginLayoutParamsCompatJellybeanMr1.setMarginEnd(param1MarginLayoutParams, param1Int);
    }
    
    public void setMarginStart(ViewGroup.MarginLayoutParams param1MarginLayoutParams, int param1Int) {
      MarginLayoutParamsCompatJellybeanMr1.setMarginStart(param1MarginLayoutParams, param1Int);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\MarginLayoutParamsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */