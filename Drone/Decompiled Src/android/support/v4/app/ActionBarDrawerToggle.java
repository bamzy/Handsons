package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
  private static final int ID_HOME = 16908332;
  
  private static final ActionBarDrawerToggleImpl IMPL = new ActionBarDrawerToggleImplBase();
  
  private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334F;
  
  final Activity mActivity;
  
  private final Delegate mActivityImpl;
  
  private final int mCloseDrawerContentDescRes;
  
  private Drawable mDrawerImage;
  
  private final int mDrawerImageResource;
  
  private boolean mDrawerIndicatorEnabled;
  
  private final DrawerLayout mDrawerLayout;
  
  private boolean mHasCustomUpIndicator;
  
  private Drawable mHomeAsUpIndicator;
  
  private final int mOpenDrawerContentDescRes;
  
  private Object mSetIndicatorInfo;
  
  private SlideDrawable mSlider;
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, @DrawableRes int paramInt1, @StringRes int paramInt2, @StringRes int paramInt3) {
    this(paramActivity, paramDrawerLayout, bool, paramInt1, paramInt2, paramInt3);
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, boolean paramBoolean, @DrawableRes int paramInt1, @StringRes int paramInt2, @StringRes int paramInt3) {
    float f;
    this.mDrawerIndicatorEnabled = true;
    this.mActivity = paramActivity;
    if (paramActivity instanceof DelegateProvider) {
      this.mActivityImpl = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();
    } else {
      this.mActivityImpl = null;
    } 
    this.mDrawerLayout = paramDrawerLayout;
    this.mDrawerImageResource = paramInt1;
    this.mOpenDrawerContentDescRes = paramInt2;
    this.mCloseDrawerContentDescRes = paramInt3;
    this.mHomeAsUpIndicator = getThemeUpIndicator();
    this.mDrawerImage = ContextCompat.getDrawable((Context)paramActivity, paramInt1);
    this.mSlider = new SlideDrawable(this.mDrawerImage);
    SlideDrawable slideDrawable = this.mSlider;
    if (paramBoolean) {
      f = 0.33333334F;
    } else {
      f = 0.0F;
    } 
    slideDrawable.setOffset(f);
  }
  
  private static boolean assumeMaterial(Context paramContext) {
    return ((paramContext.getApplicationInfo()).targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21);
  }
  
  Drawable getThemeUpIndicator() {
    return (this.mActivityImpl != null) ? this.mActivityImpl.getThemeUpIndicator() : IMPL.getThemeUpIndicator(this.mActivity);
  }
  
  public boolean isDrawerIndicatorEnabled() {
    return this.mDrawerIndicatorEnabled;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    if (!this.mHasCustomUpIndicator)
      this.mHomeAsUpIndicator = getThemeUpIndicator(); 
    this.mDrawerImage = ContextCompat.getDrawable((Context)this.mActivity, this.mDrawerImageResource);
    syncState();
  }
  
  public void onDrawerClosed(View paramView) {
    this.mSlider.setPosition(0.0F);
    if (this.mDrawerIndicatorEnabled)
      setActionBarDescription(this.mOpenDrawerContentDescRes); 
  }
  
  public void onDrawerOpened(View paramView) {
    this.mSlider.setPosition(1.0F);
    if (this.mDrawerIndicatorEnabled)
      setActionBarDescription(this.mCloseDrawerContentDescRes); 
  }
  
  public void onDrawerSlide(View paramView, float paramFloat) {
    float f = this.mSlider.getPosition();
    if (paramFloat > 0.5F) {
      paramFloat = Math.max(f, Math.max(0.0F, paramFloat - 0.5F) * 2.0F);
    } else {
      paramFloat = Math.min(f, paramFloat * 2.0F);
    } 
    this.mSlider.setPosition(paramFloat);
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    if (paramMenuItem != null && paramMenuItem.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
      if (this.mDrawerLayout.isDrawerVisible(8388611)) {
        this.mDrawerLayout.closeDrawer(8388611);
        return true;
      } 
      this.mDrawerLayout.openDrawer(8388611);
      return true;
    } 
    return false;
  }
  
  void setActionBarDescription(int paramInt) {
    if (this.mActivityImpl != null) {
      this.mActivityImpl.setActionBarDescription(paramInt);
      return;
    } 
    this.mSetIndicatorInfo = IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, paramInt);
  }
  
  void setActionBarUpIndicator(Drawable paramDrawable, int paramInt) {
    if (this.mActivityImpl != null) {
      this.mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
      return;
    } 
    this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, paramDrawable, paramInt);
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean) {
    if (paramBoolean != this.mDrawerIndicatorEnabled) {
      if (paramBoolean) {
        int i;
        SlideDrawable slideDrawable = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(8388611)) {
          i = this.mCloseDrawerContentDescRes;
        } else {
          i = this.mOpenDrawerContentDescRes;
        } 
        setActionBarUpIndicator((Drawable)slideDrawable, i);
      } else {
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
      } 
      this.mDrawerIndicatorEnabled = paramBoolean;
    } 
  }
  
  public void setHomeAsUpIndicator(int paramInt) {
    Drawable drawable = null;
    if (paramInt != 0)
      drawable = ContextCompat.getDrawable((Context)this.mActivity, paramInt); 
    setHomeAsUpIndicator(drawable);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable) {
    if (paramDrawable == null) {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
      this.mHasCustomUpIndicator = false;
    } else {
      this.mHomeAsUpIndicator = paramDrawable;
      this.mHasCustomUpIndicator = true;
    } 
    if (!this.mDrawerIndicatorEnabled)
      setActionBarUpIndicator(this.mHomeAsUpIndicator, 0); 
  }
  
  public void syncState() {
    if (this.mDrawerLayout.isDrawerOpen(8388611)) {
      this.mSlider.setPosition(1.0F);
    } else {
      this.mSlider.setPosition(0.0F);
    } 
    if (this.mDrawerIndicatorEnabled) {
      int i;
      SlideDrawable slideDrawable = this.mSlider;
      if (this.mDrawerLayout.isDrawerOpen(8388611)) {
        i = this.mCloseDrawerContentDescRes;
      } else {
        i = this.mOpenDrawerContentDescRes;
      } 
      setActionBarUpIndicator((Drawable)slideDrawable, i);
    } 
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18) {
      IMPL = new ActionBarDrawerToggleImplJellybeanMR2();
      return;
    } 
    if (i >= 11) {
      IMPL = new ActionBarDrawerToggleImplHC();
      return;
    } 
  }
  
  private static interface ActionBarDrawerToggleImpl {
    Drawable getThemeUpIndicator(Activity param1Activity);
    
    Object setActionBarDescription(Object param1Object, Activity param1Activity, int param1Int);
    
    Object setActionBarUpIndicator(Object param1Object, Activity param1Activity, Drawable param1Drawable, int param1Int);
  }
  
  private static class ActionBarDrawerToggleImplBase implements ActionBarDrawerToggleImpl {
    public Drawable getThemeUpIndicator(Activity param1Activity) {
      return null;
    }
    
    public Object setActionBarDescription(Object param1Object, Activity param1Activity, int param1Int) {
      return param1Object;
    }
    
    public Object setActionBarUpIndicator(Object param1Object, Activity param1Activity, Drawable param1Drawable, int param1Int) {
      return param1Object;
    }
  }
  
  @TargetApi(11)
  @RequiresApi(11)
  private static class ActionBarDrawerToggleImplHC implements ActionBarDrawerToggleImpl {
    public Drawable getThemeUpIndicator(Activity param1Activity) {
      return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(param1Activity);
    }
    
    public Object setActionBarDescription(Object param1Object, Activity param1Activity, int param1Int) {
      return ActionBarDrawerToggleHoneycomb.setActionBarDescription(param1Object, param1Activity, param1Int);
    }
    
    public Object setActionBarUpIndicator(Object param1Object, Activity param1Activity, Drawable param1Drawable, int param1Int) {
      return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(param1Object, param1Activity, param1Drawable, param1Int);
    }
  }
  
  @TargetApi(18)
  @RequiresApi(18)
  private static class ActionBarDrawerToggleImplJellybeanMR2 implements ActionBarDrawerToggleImpl {
    public Drawable getThemeUpIndicator(Activity param1Activity) {
      return ActionBarDrawerToggleJellybeanMR2.getThemeUpIndicator(param1Activity);
    }
    
    public Object setActionBarDescription(Object param1Object, Activity param1Activity, int param1Int) {
      return ActionBarDrawerToggleJellybeanMR2.setActionBarDescription(param1Object, param1Activity, param1Int);
    }
    
    public Object setActionBarUpIndicator(Object param1Object, Activity param1Activity, Drawable param1Drawable, int param1Int) {
      return ActionBarDrawerToggleJellybeanMR2.setActionBarUpIndicator(param1Object, param1Activity, param1Drawable, param1Int);
    }
  }
  
  public static interface Delegate {
    @Nullable
    Drawable getThemeUpIndicator();
    
    void setActionBarDescription(@StringRes int param1Int);
    
    void setActionBarUpIndicator(Drawable param1Drawable, @StringRes int param1Int);
  }
  
  public static interface DelegateProvider {
    @Nullable
    ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  }
  
  private class SlideDrawable extends InsetDrawable implements Drawable.Callback {
    private final boolean mHasMirroring;
    
    private float mOffset;
    
    private float mPosition;
    
    private final Rect mTmpRect;
    
    SlideDrawable(Drawable param1Drawable) {
      super(param1Drawable, 0);
      if (Build.VERSION.SDK_INT > 18)
        bool = true; 
      this.mHasMirroring = bool;
      this.mTmpRect = new Rect();
    }
    
    public void draw(Canvas param1Canvas) {
      boolean bool;
      byte b = 1;
      copyBounds(this.mTmpRect);
      param1Canvas.save();
      if (ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool)
        b = -1; 
      int i = this.mTmpRect.width();
      param1Canvas.translate(-this.mOffset * i * this.mPosition * b, 0.0F);
      if (bool && !this.mHasMirroring) {
        param1Canvas.translate(i, 0.0F);
        param1Canvas.scale(-1.0F, 1.0F);
      } 
      super.draw(param1Canvas);
      param1Canvas.restore();
    }
    
    public float getPosition() {
      return this.mPosition;
    }
    
    public void setOffset(float param1Float) {
      this.mOffset = param1Float;
      invalidateSelf();
    }
    
    public void setPosition(float param1Float) {
      this.mPosition = param1Float;
      invalidateSelf();
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ActionBarDrawerToggle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */