package android.support.v4.app;

import android.app.Service;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {
  static final ServiceCompatImpl IMPL = new BaseServiceCompatImpl();
  
  public static final int START_STICKY = 1;
  
  public static final int STOP_FOREGROUND_DETACH = 2;
  
  public static final int STOP_FOREGROUND_REMOVE = 1;
  
  public static void stopForeground(Service paramService, int paramInt) {
    IMPL.stopForeground(paramService, paramInt);
  }
  
  static {
    if (BuildCompat.isAtLeastN()) {
      IMPL = new Api24ServiceCompatImpl();
      return;
    } 
  }
  
  static class Api24ServiceCompatImpl implements ServiceCompatImpl {
    public void stopForeground(Service param1Service, int param1Int) {
      ServiceCompatApi24.stopForeground(param1Service, param1Int);
    }
  }
  
  static class BaseServiceCompatImpl implements ServiceCompatImpl {
    public void stopForeground(Service param1Service, int param1Int) {
      boolean bool;
      if ((param1Int & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      param1Service.stopForeground(bool);
    }
  }
  
  static interface ServiceCompatImpl {
    void stopForeground(Service param1Service, int param1Int);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface StopForegroundFlags {}
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ServiceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */