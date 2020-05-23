package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;
import java.util.ArrayList;

@TargetApi(21)
@RequiresApi(21)
class NotificationCompatApi21 {
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
  
  private static final String KEY_AUTHOR = "author";
  
  private static final String KEY_MESSAGES = "messages";
  
  private static final String KEY_ON_READ = "on_read";
  
  private static final String KEY_ON_REPLY = "on_reply";
  
  private static final String KEY_PARTICIPANTS = "participants";
  
  private static final String KEY_REMOTE_INPUT = "remote_input";
  
  private static final String KEY_TEXT = "text";
  
  private static final String KEY_TIMESTAMP = "timestamp";
  
  private static RemoteInput fromCompatRemoteInput(RemoteInputCompatBase.RemoteInput paramRemoteInput) {
    return (new RemoteInput.Builder(paramRemoteInput.getResultKey())).setLabel(paramRemoteInput.getLabel()).setChoices(paramRemoteInput.getChoices()).setAllowFreeFormInput(paramRemoteInput.getAllowFreeFormInput()).addExtras(paramRemoteInput.getExtras()).build();
  }
  
  static Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation paramUnreadConversation) {
    if (paramUnreadConversation == null)
      return null; 
    Bundle bundle = new Bundle();
    String str2 = null;
    String str1 = str2;
    if (paramUnreadConversation.getParticipants() != null) {
      str1 = str2;
      if ((paramUnreadConversation.getParticipants()).length > 1)
        str1 = paramUnreadConversation.getParticipants()[0]; 
    } 
    Parcelable[] arrayOfParcelable = new Parcelable[(paramUnreadConversation.getMessages()).length];
    for (int i = 0; i < arrayOfParcelable.length; i++) {
      Bundle bundle1 = new Bundle();
      bundle1.putString("text", paramUnreadConversation.getMessages()[i]);
      bundle1.putString("author", str1);
      arrayOfParcelable[i] = (Parcelable)bundle1;
    } 
    bundle.putParcelableArray("messages", arrayOfParcelable);
    RemoteInputCompatBase.RemoteInput remoteInput = paramUnreadConversation.getRemoteInput();
    if (remoteInput != null)
      bundle.putParcelable("remote_input", (Parcelable)fromCompatRemoteInput(remoteInput)); 
    bundle.putParcelable("on_reply", (Parcelable)paramUnreadConversation.getReplyPendingIntent());
    bundle.putParcelable("on_read", (Parcelable)paramUnreadConversation.getReadPendingIntent());
    bundle.putStringArray("participants", paramUnreadConversation.getParticipants());
    bundle.putLong("timestamp", paramUnreadConversation.getLatestTimestamp());
    return bundle;
  }
  
  public static String getCategory(Notification paramNotification) {
    return paramNotification.category;
  }
  
  static NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle paramBundle, NotificationCompatBase.UnreadConversation.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #7
    //   3: aload_0
    //   4: ifnonnull -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: ldc 'messages'
    //   12: invokevirtual getParcelableArray : (Ljava/lang/String;)[Landroid/os/Parcelable;
    //   15: astore #8
    //   17: aconst_null
    //   18: astore #6
    //   20: aload #8
    //   22: ifnull -> 67
    //   25: aload #8
    //   27: arraylength
    //   28: anewarray java/lang/String
    //   31: astore #6
    //   33: iconst_1
    //   34: istore #5
    //   36: iconst_0
    //   37: istore #4
    //   39: iload #5
    //   41: istore_3
    //   42: iload #4
    //   44: aload #6
    //   46: arraylength
    //   47: if_icmpge -> 63
    //   50: aload #8
    //   52: iload #4
    //   54: aaload
    //   55: instanceof android/os/Bundle
    //   58: ifne -> 156
    //   61: iconst_0
    //   62: istore_3
    //   63: iload_3
    //   64: ifeq -> 7
    //   67: aload_0
    //   68: ldc 'on_read'
    //   70: invokevirtual getParcelable : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   73: checkcast android/app/PendingIntent
    //   76: astore #8
    //   78: aload_0
    //   79: ldc 'on_reply'
    //   81: invokevirtual getParcelable : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   84: checkcast android/app/PendingIntent
    //   87: astore #9
    //   89: aload_0
    //   90: ldc 'remote_input'
    //   92: invokevirtual getParcelable : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   95: checkcast android/app/RemoteInput
    //   98: astore #11
    //   100: aload_0
    //   101: ldc 'participants'
    //   103: invokevirtual getStringArray : (Ljava/lang/String;)[Ljava/lang/String;
    //   106: astore #10
    //   108: aload #10
    //   110: ifnull -> 7
    //   113: aload #10
    //   115: arraylength
    //   116: iconst_1
    //   117: if_icmpne -> 7
    //   120: aload #11
    //   122: ifnull -> 133
    //   125: aload #11
    //   127: aload_2
    //   128: invokestatic toCompatRemoteInput : (Landroid/app/RemoteInput;Landroid/support/v4/app/RemoteInputCompatBase$RemoteInput$Factory;)Landroid/support/v4/app/RemoteInputCompatBase$RemoteInput;
    //   131: astore #7
    //   133: aload_1
    //   134: aload #6
    //   136: aload #7
    //   138: aload #9
    //   140: aload #8
    //   142: aload #10
    //   144: aload_0
    //   145: ldc 'timestamp'
    //   147: invokevirtual getLong : (Ljava/lang/String;)J
    //   150: invokeinterface build : ([Ljava/lang/String;Landroid/support/v4/app/RemoteInputCompatBase$RemoteInput;Landroid/app/PendingIntent;Landroid/app/PendingIntent;[Ljava/lang/String;J)Landroid/support/v4/app/NotificationCompatBase$UnreadConversation;
    //   155: areturn
    //   156: aload #6
    //   158: iload #4
    //   160: aload #8
    //   162: iload #4
    //   164: aaload
    //   165: checkcast android/os/Bundle
    //   168: ldc 'text'
    //   170: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   173: aastore
    //   174: aload #6
    //   176: iload #4
    //   178: aaload
    //   179: ifnonnull -> 187
    //   182: iconst_0
    //   183: istore_3
    //   184: goto -> 63
    //   187: iload #4
    //   189: iconst_1
    //   190: iadd
    //   191: istore #4
    //   193: goto -> 39
  }
  
  private static RemoteInputCompatBase.RemoteInput toCompatRemoteInput(RemoteInput paramRemoteInput, RemoteInputCompatBase.RemoteInput.Factory paramFactory) {
    return paramFactory.build(paramRemoteInput.getResultKey(), paramRemoteInput.getLabel(), paramRemoteInput.getChoices(), paramRemoteInput.getAllowFreeFormInput(), paramRemoteInput.getExtras());
  }
  
  public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
    private Notification.Builder b;
    
    private RemoteViews mBigContentView;
    
    private RemoteViews mContentView;
    
    private Bundle mExtras;
    
    private RemoteViews mHeadsUpContentView;
    
    public Builder(Context param1Context, Notification param1Notification1, CharSequence param1CharSequence1, CharSequence param1CharSequence2, CharSequence param1CharSequence3, RemoteViews param1RemoteViews1, int param1Int1, PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, Bitmap param1Bitmap, int param1Int2, int param1Int3, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, int param1Int4, CharSequence param1CharSequence4, boolean param1Boolean4, String param1String1, ArrayList<String> param1ArrayList, Bundle param1Bundle, int param1Int5, int param1Int6, Notification param1Notification2, String param1String2, boolean param1Boolean5, String param1String3, RemoteViews param1RemoteViews2, RemoteViews param1RemoteViews3, RemoteViews param1RemoteViews4) {
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
      this.b = builder.setFullScreenIntent(param1PendingIntent2, param1Boolean2).setLargeIcon(param1Bitmap).setNumber(param1Int1).setUsesChronometer(param1Boolean3).setPriority(param1Int4).setProgress(param1Int2, param1Int3, param1Boolean1).setLocalOnly(param1Boolean4).setGroup(param1String2).setGroupSummary(param1Boolean5).setSortKey(param1String3).setCategory(param1String1).setColor(param1Int5).setVisibility(param1Int6).setPublicVersion(param1Notification2);
      this.mExtras = new Bundle();
      if (param1Bundle != null)
        this.mExtras.putAll(param1Bundle); 
      for (String str : param1ArrayList)
        this.b.addPerson(str); 
      this.mContentView = param1RemoteViews2;
      this.mBigContentView = param1RemoteViews3;
      this.mHeadsUpContentView = param1RemoteViews4;
    }
    
    public void addAction(NotificationCompatBase.Action param1Action) {
      NotificationCompatApi20.addAction(this.b, param1Action);
    }
    
    public Notification build() {
      this.b.setExtras(this.mExtras);
      Notification notification = this.b.build();
      if (this.mContentView != null)
        notification.contentView = this.mContentView; 
      if (this.mBigContentView != null)
        notification.bigContentView = this.mBigContentView; 
      if (this.mHeadsUpContentView != null)
        notification.headsUpContentView = this.mHeadsUpContentView; 
      return notification;
    }
    
    public Notification.Builder getBuilder() {
      return this.b;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\NotificationCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */