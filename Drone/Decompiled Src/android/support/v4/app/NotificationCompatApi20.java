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

@TargetApi(20)
@RequiresApi(20)
class NotificationCompatApi20 {
  public static void addAction(Notification.Builder paramBuilder, NotificationCompatBase.Action paramAction) {
    Bundle bundle;
    Notification.Action.Builder builder = new Notification.Action.Builder(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
    if (paramAction.getRemoteInputs() != null) {
      RemoteInput[] arrayOfRemoteInput = RemoteInputCompatApi20.fromCompat(paramAction.getRemoteInputs());
      int j = arrayOfRemoteInput.length;
      for (int i = 0; i < j; i++)
        builder.addRemoteInput(arrayOfRemoteInput[i]); 
    } 
    if (paramAction.getExtras() != null) {
      bundle = new Bundle(paramAction.getExtras());
    } else {
      bundle = new Bundle();
    } 
    bundle.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
    builder.addExtras(bundle);
    paramBuilder.addAction(builder.build());
  }
  
  public static NotificationCompatBase.Action getAction(Notification paramNotification, int paramInt, NotificationCompatBase.Action.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1) {
    return getActionCompatFromAction(paramNotification.actions[paramInt], paramFactory, paramFactory1);
  }
  
  private static NotificationCompatBase.Action getActionCompatFromAction(Notification.Action paramAction, NotificationCompatBase.Action.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1) {
    RemoteInputCompatBase.RemoteInput[] arrayOfRemoteInput = RemoteInputCompatApi20.toCompat(paramAction.getRemoteInputs(), paramFactory1);
    boolean bool = paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies");
    return paramFactory.build(paramAction.icon, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput, bool);
  }
  
  private static Notification.Action getActionFromActionCompat(NotificationCompatBase.Action paramAction) {
    Bundle bundle;
    Notification.Action.Builder builder = new Notification.Action.Builder(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
    if (paramAction.getExtras() != null) {
      bundle = new Bundle(paramAction.getExtras());
    } else {
      bundle = new Bundle();
    } 
    bundle.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
    builder.addExtras(bundle);
    RemoteInputCompatBase.RemoteInput[] arrayOfRemoteInput = paramAction.getRemoteInputs();
    if (arrayOfRemoteInput != null) {
      RemoteInput[] arrayOfRemoteInput1 = RemoteInputCompatApi20.fromCompat(arrayOfRemoteInput);
      int j = arrayOfRemoteInput1.length;
      for (int i = 0; i < j; i++)
        builder.addRemoteInput(arrayOfRemoteInput1[i]); 
    } 
    return builder.build();
  }
  
  public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> paramArrayList, NotificationCompatBase.Action.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1) {
    if (paramArrayList == null)
      return null; 
    NotificationCompatBase.Action[] arrayOfAction = paramFactory.newArray(paramArrayList.size());
    int i = 0;
    while (true) {
      NotificationCompatBase.Action[] arrayOfAction1 = arrayOfAction;
      if (i < arrayOfAction.length) {
        arrayOfAction[i] = getActionCompatFromAction((Notification.Action)paramArrayList.get(i), paramFactory, paramFactory1);
        i++;
        continue;
      } 
      return arrayOfAction1;
    } 
  }
  
  public static String getGroup(Notification paramNotification) {
    return paramNotification.getGroup();
  }
  
  public static boolean getLocalOnly(Notification paramNotification) {
    return ((paramNotification.flags & 0x100) != 0);
  }
  
  public static ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompatBase.Action[] paramArrayOfAction) {
    if (paramArrayOfAction == null)
      return null; 
    ArrayList<Notification.Action> arrayList = new ArrayList(paramArrayOfAction.length);
    int j = paramArrayOfAction.length;
    int i = 0;
    while (true) {
      ArrayList<Notification.Action> arrayList1 = arrayList;
      if (i < j) {
        arrayList.add(getActionFromActionCompat(paramArrayOfAction[i]));
        i++;
        continue;
      } 
      return (ArrayList)arrayList1;
    } 
  }
  
  public static String getSortKey(Notification paramNotification) {
    return paramNotification.getSortKey();
  }
  
  public static boolean isGroupSummary(Notification paramNotification) {
    return ((paramNotification.flags & 0x200) != 0);
  }
  
  public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
    private Notification.Builder b;
    
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
      this.b = builder.setFullScreenIntent(param1PendingIntent2, param1Boolean2).setLargeIcon(param1Bitmap).setNumber(param1Int1).setUsesChronometer(param1Boolean3).setPriority(param1Int4).setProgress(param1Int2, param1Int3, param1Boolean1).setLocalOnly(param1Boolean4).setGroup(param1String1).setGroupSummary(param1Boolean5).setSortKey(param1String2);
      this.mExtras = new Bundle();
      if (param1Bundle != null)
        this.mExtras.putAll(param1Bundle); 
      if (param1ArrayList != null && !param1ArrayList.isEmpty())
        this.mExtras.putStringArray("android.people", param1ArrayList.<String>toArray(new String[param1ArrayList.size()])); 
      this.mContentView = param1RemoteViews2;
      this.mBigContentView = param1RemoteViews3;
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
      return notification;
    }
    
    public Notification.Builder getBuilder() {
      return this.b;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\NotificationCompatApi20.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */