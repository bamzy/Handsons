package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.v7.appcompat.R;
import android.view.LayoutInflater;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ContextThemeWrapper extends ContextWrapper {
  private LayoutInflater mInflater;
  
  private Resources.Theme mTheme;
  
  private int mThemeResource;
  
  public ContextThemeWrapper(Context paramContext, @StyleRes int paramInt) {
    super(paramContext);
    this.mThemeResource = paramInt;
  }
  
  public ContextThemeWrapper(Context paramContext, Resources.Theme paramTheme) {
    super(paramContext);
    this.mTheme = paramTheme;
  }
  
  private void initializeTheme() {
    boolean bool;
    if (this.mTheme == null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      this.mTheme = getResources().newTheme();
      Resources.Theme theme = getBaseContext().getTheme();
      if (theme != null)
        this.mTheme.setTo(theme); 
    } 
    onApplyThemeResource(this.mTheme, this.mThemeResource, bool);
  }
  
  public AssetManager getAssets() {
    return getResources().getAssets();
  }
  
  public Object getSystemService(String paramString) {
    if ("layout_inflater".equals(paramString)) {
      if (this.mInflater == null)
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext((Context)this); 
      return this.mInflater;
    } 
    return getBaseContext().getSystemService(paramString);
  }
  
  public Resources.Theme getTheme() {
    if (this.mTheme != null)
      return this.mTheme; 
    if (this.mThemeResource == 0)
      this.mThemeResource = R.style.Theme_AppCompat_Light; 
    initializeTheme();
    return this.mTheme;
  }
  
  public int getThemeResId() {
    return this.mThemeResource;
  }
  
  protected void onApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean) {
    paramTheme.applyStyle(paramInt, true);
  }
  
  public void setTheme(int paramInt) {
    if (this.mThemeResource != paramInt) {
      this.mThemeResource = paramInt;
      initializeTheme();
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\view\ContextThemeWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */