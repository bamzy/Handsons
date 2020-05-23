package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(9)
@RequiresApi(9)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NotificationCompatBase {
  private static Method sSetLatestEventInfo;
  
  public static Notification add(Notification paramNotification, Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2) {
    if (sSetLatestEventInfo == null)
      try {
        sSetLatestEventInfo = Notification.class.getMethod("setLatestEventInfo", new Class[] { Context.class, CharSequence.class, CharSequence.class, PendingIntent.class });
        try {
          sSetLatestEventInfo.invoke(paramNotification, new Object[] { paramContext, paramCharSequence1, paramCharSequence2, paramPendingIntent1 });
          paramNotification.fullScreenIntent = paramPendingIntent2;
          return paramNotification;
        } catch (IllegalAccessException illegalAccessException) {
        
        } catch (InvocationTargetException invocationTargetException) {}
      } catch (NoSuchMethodException noSuchMethodException) {
        throw new RuntimeException(noSuchMethodException);
      }  
    try {
      sSetLatestEventInfo.invoke(noSuchMethodException, new Object[] { paramContext, paramCharSequence1, paramCharSequence2, paramPendingIntent1 });
      ((Notification)noSuchMethodException).fullScreenIntent = paramPendingIntent2;
      return (Notification)noSuchMethodException;
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InvocationTargetException invocationTargetException) {}
  }
  
  public static abstract class Action {
    public abstract PendingIntent getActionIntent();
    
    public abstract boolean getAllowGeneratedReplies();
    
    public abstract Bundle getExtras();
    
    public abstract int getIcon();
    
    public abstract RemoteInputCompatBase.RemoteInput[] getRemoteInputs();
    
    public abstract CharSequence getTitle();
    
    public static interface Factory {
      NotificationCompatBase.Action build(int param2Int, CharSequence param2CharSequence, PendingIntent param2PendingIntent, Bundle param2Bundle, RemoteInputCompatBase.RemoteInput[] param2ArrayOfRemoteInput, boolean param2Boolean);
      
      NotificationCompatBase.Action[] newArray(int param2Int);
    }
  }
  
  public static interface Factory {
    NotificationCompatBase.Action build(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent, Bundle param1Bundle, RemoteInputCompatBase.RemoteInput[] param1ArrayOfRemoteInput, boolean param1Boolean);
    
    NotificationCompatBase.Action[] newArray(int param1Int);
  }
  
  public static abstract class UnreadConversation {
    abstract long getLatestTimestamp();
    
    abstract String[] getMessages();
    
    abstract String getParticipant();
    
    abstract String[] getParticipants();
    
    abstract PendingIntent getReadPendingIntent();
    
    abstract RemoteInputCompatBase.RemoteInput getRemoteInput();
    
    abstract PendingIntent getReplyPendingIntent();
    
    public static interface Factory {
      NotificationCompatBase.UnreadConversation build(String[] param2ArrayOfString1, RemoteInputCompatBase.RemoteInput param2RemoteInput, PendingIntent param2PendingIntent1, PendingIntent param2PendingIntent2, String[] param2ArrayOfString2, long param2Long);
    }
  }
  
  public static interface Factory {
    NotificationCompatBase.UnreadConversation build(String[] param1ArrayOfString1, RemoteInputCompatBase.RemoteInput param1RemoteInput, PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, String[] param1ArrayOfString2, long param1Long);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\NotificationCompatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */