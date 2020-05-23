package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

@TargetApi(24)
@RequiresApi(24)
class NotificationCompatApi24 {
  public static final String CATEGORY_ALARM = "alarm";
  
  public static final String CATEGORY_CALL = "call";
  
  public static final String CATEGORY_EMAIL = "email";
  
  public static final String CATEGORY_ERROR = "err";
  
  public static final String CATEGORY_EVENT = "event";
  
  public static final String CATEGORY_MESSAGE = "msg";
  
  public static final String CATEGORY_PROGRESS = "progress";
  
  public static final String CATEGORY_PROMO = "promo";
  
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  
  public static final String CATEGORY_SERVICE = "service";
  
  public static final String CATEGORY_SOCIAL = "social";
  
  public static final String CATEGORY_STATUS = "status";
  
  public static final String CATEGORY_SYSTEM = "sys";
  
  public static final String CATEGORY_TRANSPORT = "transport";
  
  public static void addMessagingStyle(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, CharSequence paramCharSequence1, CharSequence paramCharSequence2, List<CharSequence> paramList1, List<Long> paramList, List<CharSequence> paramList2, List<String> paramList3, List<Uri> paramList4) {
    Notification.MessagingStyle messagingStyle = (new Notification.MessagingStyle(paramCharSequence1)).setConversationTitle(paramCharSequence2);
    int i;
    for (i = 0; i < paramList1.size(); i++) {
      Notification.MessagingStyle.Message message = new Notification.MessagingStyle.Message(paramList1.get(i), ((Long)paramList.get(i)).longValue(), paramList2.get(i));
      if (paramList3.get(i) != null)
        message.setData(paramList3.get(i), paramList4.get(i)); 
      messagingStyle.addMessage(message);
    } 
    messagingStyle.setBuilder(paramNotificationBuilderWithBuilderAccessor.getBuilder());
  }
  
  public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
    private Notification.Builder b;
    
    public Builder(Context param1Context, Notification param1Notification1, CharSequence param1CharSequence1, CharSequence param1CharSequence2, CharSequence param1CharSequence3, RemoteViews param1RemoteViews1, int param1Int1, PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, Bitmap param1Bitmap, int param1Int2, int param1Int3, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, int param1Int4, CharSequence param1CharSequence4, boolean param1Boolean4, String param1String1, ArrayList<String> param1ArrayList, Bundle param1Bundle, int param1Int5, int param1Int6, Notification param1Notification2, String param1String2, boolean param1Boolean5, String param1String3, CharSequence[] param1ArrayOfCharSequence, RemoteViews param1RemoteViews2, RemoteViews param1RemoteViews3, RemoteViews param1RemoteViews4) {
      Notification.Builder builder = (new Notification.Builder(param1Context)).setWhen(param1Notification1.when).setShowWhen(param1Boolean2).setSmallIcon(param1Notification1.icon, param1Notification1.iconLevel).setContent(param1Notification1.contentView).setTicker(param1Notification1.tickerText, param1RemoteViews1).setSound(param1Notification1.sound, param1Notification1.audioStreamType).setVibrate(param1Notification1.vibrate).setLights(param1Notification1.ledARGB, param1Notification1.ledOnMS, param1Notification1.ledOffMS);
      if ((param1Notification1.flags & 0x2) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      builder = builder.setOngoing(param1Boolean2);
      if ((param1Notification1.flags & 0x8) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      builder = builder.setOnlyAlertOnce(param1Boolean2);
      if ((param1Notification1.flags & 0x10) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      builder = builder.setAutoCancel(param1Boolean2).setDefaults(param1Notification1.defaults).setContentTitle(param1CharSequence1).setContentText(param1CharSequence2).setSubText(param1CharSequence4).setContentInfo(param1CharSequence3).setContentIntent(param1PendingIntent1).setDeleteIntent(param1Notification1.deleteIntent);
      if ((param1Notification1.flags & 0x80) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      this.b = builder.setFullScreenIntent(param1PendingIntent2, param1Boolean2).setLargeIcon(param1Bitmap).setNumber(param1Int1).setUsesChronometer(param1Boolean3).setPriority(param1Int4).setProgress(param1Int2, param1Int3, param1Boolean1).setLocalOnly(param1Boolean4).setExtras(param1Bundle).setGroup(param1String2).setGroupSummary(param1Boolean5).setSortKey(param1String3).setCategory(param1String1).setColor(param1Int5).setVisibility(param1Int6).setPublicVersion(param1Notification2).setRemoteInputHistory(param1ArrayOfCharSequence);
      if (param1RemoteViews2 != null)
        this.b.setCustomContentView(param1RemoteViews2); 
      if (param1RemoteViews3 != null)
        this.b.setCustomBigContentView(param1RemoteViews3); 
      if (param1RemoteViews4 != null)
        this.b.setCustomHeadsUpContentView(param1RemoteViews4); 
      for (String str : param1ArrayList)
        this.b.addPerson(str); 
    }
    
    public void addAction(NotificationCompatBase.Action param1Action) {
      Bundle bundle;
      Notification.Action.Builder builder = new Notification.Action.Builder(param1Action.getIcon(), param1Action.getTitle(), param1Action.getActionIntent());
      if (param1Action.getRemoteInputs() != null) {
        RemoteInput[] arrayOfRemoteInput = RemoteInputCompatApi20.fromCompat(param1Action.getRemoteInputs());
        int j = arrayOfRemoteInput.length;
        for (int i = 0; i < j; i++)
          builder.addRemoteInput(arrayOfRemoteInput[i]); 
      } 
      if (param1Action.getExtras() != null) {
        bundle = new Bundle(param1Action.getExtras());
      } else {
        bundle = new Bundle();
      } 
      bundle.putBoolean("android.support.allowGeneratedReplies", param1Action.getAllowGeneratedReplies());
      builder.addExtras(bundle);
      builder.setAllowGeneratedReplies(param1Action.getAllowGeneratedReplies());
      this.b.addAction(builder.build());
    }
    
    public Notification build() {
      return this.b.build();
    }
    
    public Notification.Builder getBuilder() {
      return this.b;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\NotificationCompatApi24.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */