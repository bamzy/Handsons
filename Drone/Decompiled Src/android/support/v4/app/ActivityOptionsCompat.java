package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;
import android.view.View;

public class ActivityOptionsCompat {
  public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
  
  public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";
  
  public static ActivityOptionsCompat makeBasic() {
    return (Build.VERSION.SDK_INT >= 24) ? new ActivityOptionsImpl24(ActivityOptionsCompat24.makeBasic()) : ((Build.VERSION.SDK_INT >= 23) ? new ActivityOptionsImpl23(ActivityOptionsCompat23.makeBasic()) : new ActivityOptionsCompat());
  }
  
  public static ActivityOptionsCompat makeClipRevealAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (Build.VERSION.SDK_INT >= 24) ? new ActivityOptionsImpl24(ActivityOptionsCompat24.makeClipRevealAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4)) : ((Build.VERSION.SDK_INT >= 23) ? new ActivityOptionsImpl23(ActivityOptionsCompat23.makeClipRevealAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4)) : new ActivityOptionsCompat());
  }
  
  public static ActivityOptionsCompat makeCustomAnimation(Context paramContext, int paramInt1, int paramInt2) {
    return (Build.VERSION.SDK_INT >= 24) ? new ActivityOptionsImpl24(ActivityOptionsCompat24.makeCustomAnimation(paramContext, paramInt1, paramInt2)) : ((Build.VERSION.SDK_INT >= 23) ? new ActivityOptionsImpl23(ActivityOptionsCompat23.makeCustomAnimation(paramContext, paramInt1, paramInt2)) : ((Build.VERSION.SDK_INT >= 21) ? new ActivityOptionsImpl21(ActivityOptionsCompat21.makeCustomAnimation(paramContext, paramInt1, paramInt2)) : ((Build.VERSION.SDK_INT >= 16) ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(paramContext, paramInt1, paramInt2)) : new ActivityOptionsCompat())));
  }
  
  public static ActivityOptionsCompat makeScaleUpAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (Build.VERSION.SDK_INT >= 24) ? new ActivityOptionsImpl24(ActivityOptionsCompat24.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4)) : ((Build.VERSION.SDK_INT >= 23) ? new ActivityOptionsImpl23(ActivityOptionsCompat23.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4)) : ((Build.VERSION.SDK_INT >= 21) ? new ActivityOptionsImpl21(ActivityOptionsCompat21.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4)) : ((Build.VERSION.SDK_INT >= 16) ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4)) : new ActivityOptionsCompat())));
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, View paramView, String paramString) {
    return (Build.VERSION.SDK_INT >= 24) ? new ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(paramActivity, paramView, paramString)) : ((Build.VERSION.SDK_INT >= 23) ? new ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(paramActivity, paramView, paramString)) : ((Build.VERSION.SDK_INT >= 21) ? new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, paramView, paramString)) : new ActivityOptionsCompat()));
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, Pair<View, String>... paramVarArgs) {
    if (Build.VERSION.SDK_INT >= 21) {
      View[] arrayOfView = null;
      String[] arrayOfString = null;
      if (paramVarArgs != null) {
        View[] arrayOfView1 = new View[paramVarArgs.length];
        String[] arrayOfString1 = new String[paramVarArgs.length];
        int i = 0;
        while (true) {
          arrayOfString = arrayOfString1;
          arrayOfView = arrayOfView1;
          if (i < paramVarArgs.length) {
            arrayOfView1[i] = (View)(paramVarArgs[i]).first;
            arrayOfString1[i] = (String)(paramVarArgs[i]).second;
            i++;
            continue;
          } 
          break;
        } 
      } 
      return (ActivityOptionsCompat)((Build.VERSION.SDK_INT >= 24) ? new ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(paramActivity, arrayOfView, arrayOfString)) : ((Build.VERSION.SDK_INT >= 23) ? new ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(paramActivity, arrayOfView, arrayOfString)) : new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, arrayOfView, arrayOfString))));
    } 
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeTaskLaunchBehind() {
    return (Build.VERSION.SDK_INT >= 24) ? new ActivityOptionsImpl24(ActivityOptionsCompat24.makeTaskLaunchBehind()) : ((Build.VERSION.SDK_INT >= 23) ? new ActivityOptionsImpl23(ActivityOptionsCompat23.makeTaskLaunchBehind()) : ((Build.VERSION.SDK_INT >= 21) ? new ActivityOptionsImpl21(ActivityOptionsCompat21.makeTaskLaunchBehind()) : new ActivityOptionsCompat()));
  }
  
  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View paramView, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    return (Build.VERSION.SDK_INT >= 24) ? new ActivityOptionsImpl24(ActivityOptionsCompat24.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2)) : ((Build.VERSION.SDK_INT >= 23) ? new ActivityOptionsImpl23(ActivityOptionsCompat23.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2)) : ((Build.VERSION.SDK_INT >= 21) ? new ActivityOptionsImpl21(ActivityOptionsCompat21.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2)) : ((Build.VERSION.SDK_INT >= 16) ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2)) : new ActivityOptionsCompat())));
  }
  
  @Nullable
  public Rect getLaunchBounds() {
    return null;
  }
  
  public void requestUsageTimeReport(PendingIntent paramPendingIntent) {}
  
  public ActivityOptionsCompat setLaunchBounds(@Nullable Rect paramRect) {
    return null;
  }
  
  public Bundle toBundle() {
    return null;
  }
  
  public void update(ActivityOptionsCompat paramActivityOptionsCompat) {}
  
  @TargetApi(21)
  @RequiresApi(21)
  private static class ActivityOptionsImpl21 extends ActivityOptionsCompat {
    private final ActivityOptionsCompat21 mImpl;
    
    ActivityOptionsImpl21(ActivityOptionsCompat21 param1ActivityOptionsCompat21) {
      this.mImpl = param1ActivityOptionsCompat21;
    }
    
    public Bundle toBundle() {
      return this.mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat param1ActivityOptionsCompat) {
      if (param1ActivityOptionsCompat instanceof ActivityOptionsImpl21) {
        param1ActivityOptionsCompat = param1ActivityOptionsCompat;
        this.mImpl.update(((ActivityOptionsImpl21)param1ActivityOptionsCompat).mImpl);
      } 
    }
  }
  
  @TargetApi(23)
  @RequiresApi(23)
  private static class ActivityOptionsImpl23 extends ActivityOptionsCompat {
    private final ActivityOptionsCompat23 mImpl;
    
    ActivityOptionsImpl23(ActivityOptionsCompat23 param1ActivityOptionsCompat23) {
      this.mImpl = param1ActivityOptionsCompat23;
    }
    
    public void requestUsageTimeReport(PendingIntent param1PendingIntent) {
      this.mImpl.requestUsageTimeReport(param1PendingIntent);
    }
    
    public Bundle toBundle() {
      return this.mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat param1ActivityOptionsCompat) {
      if (param1ActivityOptionsCompat instanceof ActivityOptionsImpl23) {
        param1ActivityOptionsCompat = param1ActivityOptionsCompat;
        this.mImpl.update(((ActivityOptionsImpl23)param1ActivityOptionsCompat).mImpl);
      } 
    }
  }
  
  @TargetApi(24)
  @RequiresApi(24)
  private static class ActivityOptionsImpl24 extends ActivityOptionsCompat {
    private final ActivityOptionsCompat24 mImpl;
    
    ActivityOptionsImpl24(ActivityOptionsCompat24 param1ActivityOptionsCompat24) {
      this.mImpl = param1ActivityOptionsCompat24;
    }
    
    public Rect getLaunchBounds() {
      return this.mImpl.getLaunchBounds();
    }
    
    public void requestUsageTimeReport(PendingIntent param1PendingIntent) {
      this.mImpl.requestUsageTimeReport(param1PendingIntent);
    }
    
    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect param1Rect) {
      return new ActivityOptionsImpl24(this.mImpl.setLaunchBounds(param1Rect));
    }
    
    public Bundle toBundle() {
      return this.mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat param1ActivityOptionsCompat) {
      if (param1ActivityOptionsCompat instanceof ActivityOptionsImpl24) {
        param1ActivityOptionsCompat = param1ActivityOptionsCompat;
        this.mImpl.update(((ActivityOptionsImpl24)param1ActivityOptionsCompat).mImpl);
      } 
    }
  }
  
  @TargetApi(16)
  @RequiresApi(16)
  private static class ActivityOptionsImplJB extends ActivityOptionsCompat {
    private final ActivityOptionsCompatJB mImpl;
    
    ActivityOptionsImplJB(ActivityOptionsCompatJB param1ActivityOptionsCompatJB) {
      this.mImpl = param1ActivityOptionsCompatJB;
    }
    
    public Bundle toBundle() {
      return this.mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat param1ActivityOptionsCompat) {
      if (param1ActivityOptionsCompat instanceof ActivityOptionsImplJB) {
        param1ActivityOptionsCompat = param1ActivityOptionsCompat;
        this.mImpl.update(((ActivityOptionsImplJB)param1ActivityOptionsCompat).mImpl);
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ActivityOptionsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */