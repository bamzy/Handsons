package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
@RequiresApi(19)
class NotificationCompatKitKat {
  public static NotificationCompatBase.Action getAction(Notification paramNotification, int paramInt, NotificationCompatBase.Action.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1) {
    Bundle bundle;
    Notification.Action action = paramNotification.actions[paramInt];
    Notification notification = null;
    SparseArray sparseArray = paramNotification.extras.getSparseParcelableArray("android.support.actionExtras");
    paramNotification = notification;
    if (sparseArray != null)
      bundle = (Bundle)sparseArray.get(paramInt); 
    return NotificationCompatJellybean.readAction(paramFactory, paramFactory1, action.icon, action.title, action.actionIntent, bundle);
  }
  
  public static int getActionCount(Notification paramNotification) {
    return (paramNotification.actions != null) ? paramNotification.actions.length : 0;
  }
  
  public static Bundle getExtras(Notification paramNotification) {
    return paramNotification.extras;
  }
  
  public static String getGroup(Notification paramNotification) {
    return paramNotification.extras.getString("android.support.groupKey");
  }
  
  public static boolean getLocalOnly(Notification paramNotification) {
    return paramNotification.extras.getBoolean("android.support.localOnly");
  }
  
  public static String getSortKey(Notification paramNotification) {
    return paramNotification.extras.getString("android.support.sortKey");
  }
  
  public static boolean isGroupSummary(Notification paramNotification) {
    return paramNotification.extras.getBoolean("android.support.isGroupSummary");
  }
  
  public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
    private Notification.Builder b;
    
    private List<Bundle> mActionExtrasList = new ArrayList<Bundle>();
    
    private RemoteViews mBigContentView;
    
    private RemoteViews mContentView;
    
    private Bundle mExtras;
    
    public Builder(Context param1Context, Notification param1Notification, CharSequence param1CharSequence1, CharSequence param1CharSequence2, CharSequence param1CharSequence3, RemoteViews param1RemoteViews1, int param1Int1, PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, Bitmap param1Bitmap, int param1Int2, int param1Int3, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, int param1Int4, CharSequence param1CharSequence4, boolean param1Boolean4, ArrayList<String> param1ArrayList, Bundle param1Bundle, String param1String1, boolean param1Boolean5, String param1String2, RemoteViews param1RemoteViews2, RemoteViews param1RemoteViews3) {
      Notification.Builder builder = (new Notification.Builder(param1Context)).setWhen(param1Notification.when).setShowWhen(param1Boolean2).setSmallIcon(param1Notification.icon, param1Notification.iconLevel).setContent(param1Notification.contentView).setTicker(param1Notification.tickerText, param1RemoteViews1).setSound(param1Notification.sound, param1Notification.audioStreamType).setVibrate(param1Notification.vibrate).setLights(param1Notification.ledARGB, param1Notification.ledOnMS, param1Notification.ledOffMS);
      if ((param1Notification.flags & 0x2) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      builder = builder.setOngoing(param1Boolean2);
      if ((param1Notification.flags & 0x8) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      builder = builder.setOnlyAlertOnce(param1Boolean2);
      if ((param1Notification.flags & 0x10) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      builder = builder.setAutoCancel(param1Boolean2).setDefaults(param1Notification.defaults).setContentTitle(param1CharSequence1).setContentText(param1CharSequence2).setSubText(param1CharSequence4).setContentInfo(param1CharSequence3).setContentIntent(param1PendingIntent1).setDeleteIntent(param1Notification.deleteIntent);
      if ((param1Notification.flags & 0x80) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      this.b = builder.setFullScreenIntent(param1PendingIntent2, param1Boolean2).setLargeIcon(param1Bitmap).setNumber(param1Int1).setUsesChronometer(param1Boolean3).setPriority(param1Int4).setProgress(param1Int2, param1Int3, param1Boolean1);
      this.mExtras = new Bundle();
      if (param1Bundle != null)
        this.mExtras.putAll(param1Bundle); 
      if (param1ArrayList != null && !param1ArrayList.isEmpty())
        this.mExtras.putStringArray("android.people", param1ArrayList.<String>toArray(new String[param1ArrayList.size()])); 
      if (param1Boolean4)
        this.mExtras.putBoolean("android.support.localOnly", true); 
      if (param1String1 != null) {
        this.mExtras.putString("android.support.groupKey", param1String1);
        if (param1Boolean5) {
          this.mExtras.putBoolean("android.support.isGroupSummary", true);
        } else {
          this.mExtras.putBoolean("android.support.useSideChannel", true);
        } 
      } 
      if (param1String2 != null)
        this.mExtras.putString("android.support.sortKey", param1String2); 
      this.mContentView = param1RemoteViews2;
      this.mBigContentView = param1RemoteViews3;
    }
    
    public void addAction(NotificationCompatBase.Action param1Action) {
      this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.b, param1Action));
    }
    
    public Notification build() {
      SparseArray<Bundle> sparseArray = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
      if (sparseArray != null)
        this.mExtras.putSparseParcelableArray("android.support.actionExtras", sparseArray); 
      this.b.setExtras(this.mExtras);
      Notification notification = this.b.build();
      if (this.mContentView != null)
        notification.contentView = this.mContentView; 
      if (this.mBigContentView != null)
        notification.bigContentView = this.mBigContentView; 
      return notification;
    }
    
    public Notification.Builder getBuilder() {
      return this.b;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\NotificationCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */