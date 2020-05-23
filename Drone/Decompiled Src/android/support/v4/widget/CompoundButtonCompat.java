package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;

public final class CompoundButtonCompat {
  private static final CompoundButtonCompatImpl IMPL = new BaseCompoundButtonCompat();
  
  @Nullable
  public static Drawable getButtonDrawable(@NonNull CompoundButton paramCompoundButton) {
    return IMPL.getButtonDrawable(paramCompoundButton);
  }
  
  @Nullable
  public static ColorStateList getButtonTintList(@NonNull CompoundButton paramCompoundButton) {
    return IMPL.getButtonTintList(paramCompoundButton);
  }
  
  @Nullable
  public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton paramCompoundButton) {
    return IMPL.getButtonTintMode(paramCompoundButton);
  }
  
  public static void setButtonTintList(@NonNull CompoundButton paramCompoundButton, @Nullable ColorStateList paramColorStateList) {
    IMPL.setButtonTintList(paramCompoundButton, paramColorStateList);
  }
  
  public static void setButtonTintMode(@NonNull CompoundButton paramCompoundButton, @Nullable PorterDuff.Mode paramMode) {
    IMPL.setButtonTintMode(paramCompoundButton, paramMode);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      IMPL = new Api23CompoundButtonImpl();
      return;
    } 
    if (i >= 21) {
      IMPL = new LollipopCompoundButtonImpl();
      return;
    } 
  }
  
  static class Api23CompoundButtonImpl extends LollipopCompoundButtonImpl {
    public Drawable getButtonDrawable(CompoundButton param1CompoundButton) {
      return CompoundButtonCompatApi23.getButtonDrawable(param1CompoundButton);
    }
  }
  
  static class BaseCompoundButtonCompat implements CompoundButtonCompatImpl {
    public Drawable getButtonDrawable(CompoundButton param1CompoundButton) {
      return CompoundButtonCompatGingerbread.getButtonDrawable(param1CompoundButton);
    }
    
    public ColorStateList getButtonTintList(CompoundButton param1CompoundButton) {
      return CompoundButtonCompatGingerbread.getButtonTintList(param1CompoundButton);
    }
    
    public PorterDuff.Mode getButtonTintMode(CompoundButton param1CompoundButton) {
      return CompoundButtonCompatGingerbread.getButtonTintMode(param1CompoundButton);
    }
    
    public void setButtonTintList(CompoundButton param1CompoundButton, ColorStateList param1ColorStateList) {
      CompoundButtonCompatGingerbread.setButtonTintList(param1CompoundButton, param1ColorStateList);
    }
    
    public void setButtonTintMode(CompoundButton param1CompoundButton, PorterDuff.Mode param1Mode) {
      CompoundButtonCompatGingerbread.setButtonTintMode(param1CompoundButton, param1Mode);
    }
  }
  
  static interface CompoundButtonCompatImpl {
    Drawable getButtonDrawable(CompoundButton param1CompoundButton);
    
    ColorStateList getButtonTintList(CompoundButton param1CompoundButton);
    
    PorterDuff.Mode getButtonTintMode(CompoundButton param1CompoundButton);
    
    void setButtonTintList(CompoundButton param1CompoundButton, ColorStateList param1ColorStateList);
    
    void setButtonTintMode(CompoundButton param1CompoundButton, PorterDuff.Mode param1Mode);
  }
  
  static class LollipopCompoundButtonImpl extends BaseCompoundButtonCompat {
    public ColorStateList getButtonTintList(CompoundButton param1CompoundButton) {
      return CompoundButtonCompatLollipop.getButtonTintList(param1CompoundButton);
    }
    
    public PorterDuff.Mode getButtonTintMode(CompoundButton param1CompoundButton) {
      return CompoundButtonCompatLollipop.getButtonTintMode(param1CompoundButton);
    }
    
    public void setButtonTintList(CompoundButton param1CompoundButton, ColorStateList param1ColorStateList) {
      CompoundButtonCompatLollipop.setButtonTintList(param1CompoundButton, param1ColorStateList);
    }
    
    public void setButtonTintMode(CompoundButton param1CompoundButton, PorterDuff.Mode param1Mode) {
      CompoundButtonCompatLollipop.setButtonTintMode(param1CompoundButton, param1Mode);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\CompoundButtonCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */