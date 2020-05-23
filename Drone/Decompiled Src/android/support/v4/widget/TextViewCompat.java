package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.widget.TextView;

public final class TextViewCompat {
  static final TextViewCompatImpl IMPL = new BaseTextViewCompatImpl();
  
  public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView paramTextView) {
    return IMPL.getCompoundDrawablesRelative(paramTextView);
  }
  
  public static int getMaxLines(@NonNull TextView paramTextView) {
    return IMPL.getMaxLines(paramTextView);
  }
  
  public static int getMinLines(@NonNull TextView paramTextView) {
    return IMPL.getMinLines(paramTextView);
  }
  
  public static void setCompoundDrawablesRelative(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4) {
    IMPL.setCompoundDrawablesRelative(paramTextView, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4) {
    IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(paramTextView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4) {
    IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(paramTextView, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setTextAppearance(@NonNull TextView paramTextView, @StyleRes int paramInt) {
    IMPL.setTextAppearance(paramTextView, paramInt);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      IMPL = new Api23TextViewCompatImpl();
      return;
    } 
    if (i >= 18) {
      IMPL = new JbMr2TextViewCompatImpl();
      return;
    } 
    if (i >= 17) {
      IMPL = new JbMr1TextViewCompatImpl();
      return;
    } 
    if (i >= 16) {
      IMPL = new JbTextViewCompatImpl();
      return;
    } 
  }
  
  static class Api23TextViewCompatImpl extends JbMr2TextViewCompatImpl {
    public void setTextAppearance(@NonNull TextView param1TextView, @StyleRes int param1Int) {
      TextViewCompatApi23.setTextAppearance(param1TextView, param1Int);
    }
  }
  
  static class BaseTextViewCompatImpl implements TextViewCompatImpl {
    public Drawable[] getCompoundDrawablesRelative(@NonNull TextView param1TextView) {
      return TextViewCompatGingerbread.getCompoundDrawablesRelative(param1TextView);
    }
    
    public int getMaxLines(TextView param1TextView) {
      return TextViewCompatGingerbread.getMaxLines(param1TextView);
    }
    
    public int getMinLines(TextView param1TextView) {
      return TextViewCompatGingerbread.getMinLines(param1TextView);
    }
    
    public void setCompoundDrawablesRelative(@NonNull TextView param1TextView, @Nullable Drawable param1Drawable1, @Nullable Drawable param1Drawable2, @Nullable Drawable param1Drawable3, @Nullable Drawable param1Drawable4) {
      param1TextView.setCompoundDrawables(param1Drawable1, param1Drawable2, param1Drawable3, param1Drawable4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView param1TextView, @DrawableRes int param1Int1, @DrawableRes int param1Int2, @DrawableRes int param1Int3, @DrawableRes int param1Int4) {
      param1TextView.setCompoundDrawablesWithIntrinsicBounds(param1Int1, param1Int2, param1Int3, param1Int4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView param1TextView, @Nullable Drawable param1Drawable1, @Nullable Drawable param1Drawable2, @Nullable Drawable param1Drawable3, @Nullable Drawable param1Drawable4) {
      param1TextView.setCompoundDrawablesWithIntrinsicBounds(param1Drawable1, param1Drawable2, param1Drawable3, param1Drawable4);
    }
    
    public void setTextAppearance(TextView param1TextView, @StyleRes int param1Int) {
      TextViewCompatGingerbread.setTextAppearance(param1TextView, param1Int);
    }
  }
  
  static class JbMr1TextViewCompatImpl extends JbTextViewCompatImpl {
    public Drawable[] getCompoundDrawablesRelative(@NonNull TextView param1TextView) {
      return TextViewCompatJbMr1.getCompoundDrawablesRelative(param1TextView);
    }
    
    public void setCompoundDrawablesRelative(@NonNull TextView param1TextView, @Nullable Drawable param1Drawable1, @Nullable Drawable param1Drawable2, @Nullable Drawable param1Drawable3, @Nullable Drawable param1Drawable4) {
      TextViewCompatJbMr1.setCompoundDrawablesRelative(param1TextView, param1Drawable1, param1Drawable2, param1Drawable3, param1Drawable4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView param1TextView, @DrawableRes int param1Int1, @DrawableRes int param1Int2, @DrawableRes int param1Int3, @DrawableRes int param1Int4) {
      TextViewCompatJbMr1.setCompoundDrawablesRelativeWithIntrinsicBounds(param1TextView, param1Int1, param1Int2, param1Int3, param1Int4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView param1TextView, @Nullable Drawable param1Drawable1, @Nullable Drawable param1Drawable2, @Nullable Drawable param1Drawable3, @Nullable Drawable param1Drawable4) {
      TextViewCompatJbMr1.setCompoundDrawablesRelativeWithIntrinsicBounds(param1TextView, param1Drawable1, param1Drawable2, param1Drawable3, param1Drawable4);
    }
  }
  
  static class JbMr2TextViewCompatImpl extends JbMr1TextViewCompatImpl {
    public Drawable[] getCompoundDrawablesRelative(@NonNull TextView param1TextView) {
      return TextViewCompatJbMr2.getCompoundDrawablesRelative(param1TextView);
    }
    
    public void setCompoundDrawablesRelative(@NonNull TextView param1TextView, @Nullable Drawable param1Drawable1, @Nullable Drawable param1Drawable2, @Nullable Drawable param1Drawable3, @Nullable Drawable param1Drawable4) {
      TextViewCompatJbMr2.setCompoundDrawablesRelative(param1TextView, param1Drawable1, param1Drawable2, param1Drawable3, param1Drawable4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView param1TextView, @DrawableRes int param1Int1, @DrawableRes int param1Int2, @DrawableRes int param1Int3, @DrawableRes int param1Int4) {
      TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(param1TextView, param1Int1, param1Int2, param1Int3, param1Int4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView param1TextView, @Nullable Drawable param1Drawable1, @Nullable Drawable param1Drawable2, @Nullable Drawable param1Drawable3, @Nullable Drawable param1Drawable4) {
      TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(param1TextView, param1Drawable1, param1Drawable2, param1Drawable3, param1Drawable4);
    }
  }
  
  static class JbTextViewCompatImpl extends BaseTextViewCompatImpl {
    public int getMaxLines(TextView param1TextView) {
      return TextViewCompatJb.getMaxLines(param1TextView);
    }
    
    public int getMinLines(TextView param1TextView) {
      return TextViewCompatJb.getMinLines(param1TextView);
    }
  }
  
  static interface TextViewCompatImpl {
    Drawable[] getCompoundDrawablesRelative(@NonNull TextView param1TextView);
    
    int getMaxLines(TextView param1TextView);
    
    int getMinLines(TextView param1TextView);
    
    void setCompoundDrawablesRelative(@NonNull TextView param1TextView, @Nullable Drawable param1Drawable1, @Nullable Drawable param1Drawable2, @Nullable Drawable param1Drawable3, @Nullable Drawable param1Drawable4);
    
    void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView param1TextView, @DrawableRes int param1Int1, @DrawableRes int param1Int2, @DrawableRes int param1Int3, @DrawableRes int param1Int4);
    
    void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView param1TextView, @Nullable Drawable param1Drawable1, @Nullable Drawable param1Drawable2, @Nullable Drawable param1Drawable3, @Nullable Drawable param1Drawable4);
    
    void setTextAppearance(@NonNull TextView param1TextView, @StyleRes int param1Int);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\TextViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */