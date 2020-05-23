package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;

@TargetApi(14)
@RequiresApi(14)
class NotificationCompatIceCreamSandwich {
  public static class Builder implements NotificationBuilderWithBuilderAccessor {
    private Notification.Builder b;
    
    public Builder(Context param1Context, Notification param1Notification, CharSequence param1CharSequence1, CharSequence param1CharSequence2, CharSequence param1CharSequence3, RemoteViews param1RemoteViews, int param1Int1, PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, Bitmap param1Bitmap, int param1Int2, int param1Int3, boolean param1Boolean) {
      boolean bool;
      Notification.Builder builder = (new Notification.Builder(param1Context)).setWhen(param1Notification.when).setSmallIcon(param1Notification.icon, param1Notification.iconLevel).setContent(param1Notification.contentView).setTicker(param1Notification.tickerText, param1RemoteViews).setSound(param1Notification.sound, param1Notification.audioStreamType).setVibrate(param1Notification.vibrate).setLights(param1Notification.ledARGB, param1Notification.ledOnMS, param1Notification.ledOffMS);
      if ((param1Notification.flags & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      builder = builder.setOngoing(bool);
      if ((param1Notification.flags & 0x8) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      builder = builder.setOnlyAlertOnce(bool);
      if ((param1Notification.flags & 0x10) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      builder = builder.setAutoCancel(bool).setDefaults(param1Notification.defaults).setContentTitle(param1CharSequence1).setContentText(param1CharSequence2).setContentInfo(param1CharSequence3).setContentIntent(param1PendingIntent1).setDeleteIntent(param1Notification.deleteIntent);
      if ((param1Notification.flags & 0x80) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.b = builder.setFullScreenIntent(param1PendingIntent2, bool).setLargeIcon(param1Bitmap).setNumber(param1Int1).setProgress(param1Int2, param1Int3, param1Boolean);
    }
    
    public Notification build() {
      return this.b.getNotification();
    }
    
    public Notification.Builder getBuilder() {
      return this.b;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\NotificationCompatIceCreamSandwich.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */