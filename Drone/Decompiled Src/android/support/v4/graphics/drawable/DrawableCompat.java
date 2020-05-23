package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
  static final DrawableImpl IMPL = new BaseDrawableImpl();
  
  public static void applyTheme(@NonNull Drawable paramDrawable, @NonNull Resources.Theme paramTheme) {
    IMPL.applyTheme(paramDrawable, paramTheme);
  }
  
  public static boolean canApplyTheme(@NonNull Drawable paramDrawable) {
    return IMPL.canApplyTheme(paramDrawable);
  }
  
  public static void clearColorFilter(@NonNull Drawable paramDrawable) {
    IMPL.clearColorFilter(paramDrawable);
  }
  
  public static int getAlpha(@NonNull Drawable paramDrawable) {
    return IMPL.getAlpha(paramDrawable);
  }
  
  public static ColorFilter getColorFilter(@NonNull Drawable paramDrawable) {
    return IMPL.getColorFilter(paramDrawable);
  }
  
  public static int getLayoutDirection(@NonNull Drawable paramDrawable) {
    return IMPL.getLayoutDirection(paramDrawable);
  }
  
  public static void inflate(@NonNull Drawable paramDrawable, @NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    IMPL.inflate(paramDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public static boolean isAutoMirrored(@NonNull Drawable paramDrawable) {
    return IMPL.isAutoMirrored(paramDrawable);
  }
  
  public static void jumpToCurrentState(@NonNull Drawable paramDrawable) {
    IMPL.jumpToCurrentState(paramDrawable);
  }
  
  public static void setAutoMirrored(@NonNull Drawable paramDrawable, boolean paramBoolean) {
    IMPL.setAutoMirrored(paramDrawable, paramBoolean);
  }
  
  public static void setHotspot(@NonNull Drawable paramDrawable, float paramFloat1, float paramFloat2) {
    IMPL.setHotspot(paramDrawable, paramFloat1, paramFloat2);
  }
  
  public static void setHotspotBounds(@NonNull Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    IMPL.setHotspotBounds(paramDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static boolean setLayoutDirection(@NonNull Drawable paramDrawable, int paramInt) {
    return IMPL.setLayoutDirection(paramDrawable, paramInt);
  }
  
  public static void setTint(@NonNull Drawable paramDrawable, @ColorInt int paramInt) {
    IMPL.setTint(paramDrawable, paramInt);
  }
  
  public static void setTintList(@NonNull Drawable paramDrawable, @Nullable ColorStateList paramColorStateList) {
    IMPL.setTintList(paramDrawable, paramColorStateList);
  }
  
  public static void setTintMode(@NonNull Drawable paramDrawable, @Nullable PorterDuff.Mode paramMode) {
    IMPL.setTintMode(paramDrawable, paramMode);
  }
  
  public static <T extends Drawable> T unwrap(@NonNull Drawable paramDrawable) {
    Drawable drawable = paramDrawable;
    if (paramDrawable instanceof DrawableWrapper)
      drawable = ((DrawableWrapper)paramDrawable).getWrappedDrawable(); 
    return (T)drawable;
  }
  
  public static Drawable wrap(@NonNull Drawable paramDrawable) {
    return IMPL.wrap(paramDrawable);
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      IMPL = new MDrawableImpl();
      return;
    } 
    if (i >= 21) {
      IMPL = new LollipopDrawableImpl();
      return;
    } 
    if (i >= 19) {
      IMPL = new KitKatDrawableImpl();
      return;
    } 
    if (i >= 17) {
      IMPL = new JellybeanMr1DrawableImpl();
      return;
    } 
    if (i >= 11) {
      IMPL = new HoneycombDrawableImpl();
      return;
    } 
  }
  
  static class BaseDrawableImpl implements DrawableImpl {
    public void applyTheme(Drawable param1Drawable, Resources.Theme param1Theme) {}
    
    public boolean canApplyTheme(Drawable param1Drawable) {
      return false;
    }
    
    public void clearColorFilter(Drawable param1Drawable) {
      param1Drawable.clearColorFilter();
    }
    
    public int getAlpha(Drawable param1Drawable) {
      return 0;
    }
    
    public ColorFilter getColorFilter(Drawable param1Drawable) {
      return null;
    }
    
    public int getLayoutDirection(Drawable param1Drawable) {
      return 0;
    }
    
    public void inflate(Drawable param1Drawable, Resources param1Resources, XmlPullParser param1XmlPullParser, AttributeSet param1AttributeSet, Resources.Theme param1Theme) throws IOException, XmlPullParserException {
      DrawableCompatBase.inflate(param1Drawable, param1Resources, param1XmlPullParser, param1AttributeSet, param1Theme);
    }
    
    public boolean isAutoMirrored(Drawable param1Drawable) {
      return false;
    }
    
    public void jumpToCurrentState(Drawable param1Drawable) {}
    
    public void setAutoMirrored(Drawable param1Drawable, boolean param1Boolean) {}
    
    public void setHotspot(Drawable param1Drawable, float param1Float1, float param1Float2) {}
    
    public void setHotspotBounds(Drawable param1Drawable, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {}
    
    public boolean setLayoutDirection(Drawable param1Drawable, int param1Int) {
      return false;
    }
    
    public void setTint(Drawable param1Drawable, int param1Int) {
      DrawableCompatBase.setTint(param1Drawable, param1Int);
    }
    
    public void setTintList(Drawable param1Drawable, ColorStateList param1ColorStateList) {
      DrawableCompatBase.setTintList(param1Drawable, param1ColorStateList);
    }
    
    public void setTintMode(Drawable param1Drawable, PorterDuff.Mode param1Mode) {
      DrawableCompatBase.setTintMode(param1Drawable, param1Mode);
    }
    
    public Drawable wrap(Drawable param1Drawable) {
      return DrawableCompatBase.wrapForTinting(param1Drawable);
    }
  }
  
  static interface DrawableImpl {
    void applyTheme(Drawable param1Drawable, Resources.Theme param1Theme);
    
    boolean canApplyTheme(Drawable param1Drawable);
    
    void clearColorFilter(Drawable param1Drawable);
    
    int getAlpha(Drawable param1Drawable);
    
    ColorFilter getColorFilter(Drawable param1Drawable);
    
    int getLayoutDirection(Drawable param1Drawable);
    
    void inflate(Drawable param1Drawable, Resources param1Resources, XmlPullParser param1XmlPullParser, AttributeSet param1AttributeSet, Resources.Theme param1Theme) throws IOException, XmlPullParserException;
    
    boolean isAutoMirrored(Drawable param1Drawable);
    
    void jumpToCurrentState(Drawable param1Drawable);
    
    void setAutoMirrored(Drawable param1Drawable, boolean param1Boolean);
    
    void setHotspot(Drawable param1Drawable, float param1Float1, float param1Float2);
    
    void setHotspotBounds(Drawable param1Drawable, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
    
    boolean setLayoutDirection(Drawable param1Drawable, int param1Int);
    
    void setTint(Drawable param1Drawable, int param1Int);
    
    void setTintList(Drawable param1Drawable, ColorStateList param1ColorStateList);
    
    void setTintMode(Drawable param1Drawable, PorterDuff.Mode param1Mode);
    
    Drawable wrap(Drawable param1Drawable);
  }
  
  static class HoneycombDrawableImpl extends BaseDrawableImpl {
    public void jumpToCurrentState(Drawable param1Drawable) {
      DrawableCompatHoneycomb.jumpToCurrentState(param1Drawable);
    }
    
    public Drawable wrap(Drawable param1Drawable) {
      return DrawableCompatHoneycomb.wrapForTinting(param1Drawable);
    }
  }
  
  static class JellybeanMr1DrawableImpl extends HoneycombDrawableImpl {
    public int getLayoutDirection(Drawable param1Drawable) {
      int i = DrawableCompatJellybeanMr1.getLayoutDirection(param1Drawable);
      return (i >= 0) ? i : 0;
    }
    
    public boolean setLayoutDirection(Drawable param1Drawable, int param1Int) {
      return DrawableCompatJellybeanMr1.setLayoutDirection(param1Drawable, param1Int);
    }
  }
  
  static class KitKatDrawableImpl extends JellybeanMr1DrawableImpl {
    public int getAlpha(Drawable param1Drawable) {
      return DrawableCompatKitKat.getAlpha(param1Drawable);
    }
    
    public boolean isAutoMirrored(Drawable param1Drawable) {
      return DrawableCompatKitKat.isAutoMirrored(param1Drawable);
    }
    
    public void setAutoMirrored(Drawable param1Drawable, boolean param1Boolean) {
      DrawableCompatKitKat.setAutoMirrored(param1Drawable, param1Boolean);
    }
    
    public Drawable wrap(Drawable param1Drawable) {
      return DrawableCompatKitKat.wrapForTinting(param1Drawable);
    }
  }
  
  static class LollipopDrawableImpl extends KitKatDrawableImpl {
    public void applyTheme(Drawable param1Drawable, Resources.Theme param1Theme) {
      DrawableCompatLollipop.applyTheme(param1Drawable, param1Theme);
    }
    
    public boolean canApplyTheme(Drawable param1Drawable) {
      return DrawableCompatLollipop.canApplyTheme(param1Drawable);
    }
    
    public void clearColorFilter(Drawable param1Drawable) {
      DrawableCompatLollipop.clearColorFilter(param1Drawable);
    }
    
    public ColorFilter getColorFilter(Drawable param1Drawable) {
      return DrawableCompatLollipop.getColorFilter(param1Drawable);
    }
    
    public void inflate(Drawable param1Drawable, Resources param1Resources, XmlPullParser param1XmlPullParser, AttributeSet param1AttributeSet, Resources.Theme param1Theme) throws IOException, XmlPullParserException {
      DrawableCompatLollipop.inflate(param1Drawable, param1Resources, param1XmlPullParser, param1AttributeSet, param1Theme);
    }
    
    public void setHotspot(Drawable param1Drawable, float param1Float1, float param1Float2) {
      DrawableCompatLollipop.setHotspot(param1Drawable, param1Float1, param1Float2);
    }
    
    public void setHotspotBounds(Drawable param1Drawable, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      DrawableCompatLollipop.setHotspotBounds(param1Drawable, param1Int1, param1Int2, param1Int3, param1Int4);
    }
    
    public void setTint(Drawable param1Drawable, int param1Int) {
      DrawableCompatLollipop.setTint(param1Drawable, param1Int);
    }
    
    public void setTintList(Drawable param1Drawable, ColorStateList param1ColorStateList) {
      DrawableCompatLollipop.setTintList(param1Drawable, param1ColorStateList);
    }
    
    public void setTintMode(Drawable param1Drawable, PorterDuff.Mode param1Mode) {
      DrawableCompatLollipop.setTintMode(param1Drawable, param1Mode);
    }
    
    public Drawable wrap(Drawable param1Drawable) {
      return DrawableCompatLollipop.wrapForTinting(param1Drawable);
    }
  }
  
  static class MDrawableImpl extends LollipopDrawableImpl {
    public void clearColorFilter(Drawable param1Drawable) {
      param1Drawable.clearColorFilter();
    }
    
    public int getLayoutDirection(Drawable param1Drawable) {
      return DrawableCompatApi23.getLayoutDirection(param1Drawable);
    }
    
    public boolean setLayoutDirection(Drawable param1Drawable, int param1Int) {
      return DrawableCompatApi23.setLayoutDirection(param1Drawable, param1Int);
    }
    
    public Drawable wrap(Drawable param1Drawable) {
      return param1Drawable;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */