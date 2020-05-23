package android.support.v7.widget;

import android.graphics.Rect;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface FitWindowsViewGroup {
  void setOnFitSystemWindowsListener(OnFitSystemWindowsListener paramOnFitSystemWindowsListener);
  
  public static interface OnFitSystemWindowsListener {
    void onFitSystemWindows(Rect param1Rect);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\FitWindowsViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */