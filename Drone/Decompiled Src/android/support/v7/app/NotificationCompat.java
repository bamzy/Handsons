package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.text.BidiFormatter;
import android.support.v7.appcompat.R;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import java.util.List;

public class NotificationCompat extends NotificationCompat {
  @TargetApi(16)
  @RequiresApi(16)
  private static void addBigStyleToBuilderJellybean(Notification paramNotification, NotificationCompat.Builder paramBuilder) {
    if (paramBuilder.mStyle instanceof MediaStyle) {
      boolean bool;
      RemoteViews remoteViews;
      MediaStyle mediaStyle = (MediaStyle)paramBuilder.mStyle;
      if (paramBuilder.getBigContentView() != null) {
        remoteViews = paramBuilder.getBigContentView();
      } else {
        remoteViews = paramBuilder.getContentView();
      } 
      if (paramBuilder.mStyle instanceof DecoratedMediaCustomViewStyle && remoteViews != null) {
        bool = true;
      } else {
        bool = false;
      } 
      NotificationCompatImplBase.overrideMediaBigContentView(paramNotification, paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mNumber, paramBuilder.mLargeIcon, paramBuilder.mSubText, paramBuilder.mUseChronometer, paramBuilder.getWhenIfShowing(), paramBuilder.getPriority(), 0, paramBuilder.mActions, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent, bool);
      if (bool)
        NotificationCompatImplBase.buildIntoRemoteViews(paramBuilder.mContext, paramNotification.bigContentView, remoteViews); 
      return;
    } 
    if (paramBuilder.mStyle instanceof DecoratedCustomViewStyle) {
      addDecoratedBigStyleToBuilderJellybean(paramNotification, paramBuilder);
      return;
    } 
  }
  
  @TargetApi(21)
  @RequiresApi(21)
  private static void addBigStyleToBuilderLollipop(Notification paramNotification, NotificationCompat.Builder paramBuilder) {
    RemoteViews remoteViews;
    if (paramBuilder.getBigContentView() != null) {
      remoteViews = paramBuilder.getBigContentView();
    } else {
      remoteViews = paramBuilder.getContentView();
    } 
    if (paramBuilder.mStyle instanceof DecoratedMediaCustomViewStyle && remoteViews != null) {
      NotificationCompatImplBase.overrideMediaBigContentView(paramNotification, paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mNumber, paramBuilder.mLargeIcon, paramBuilder.mSubText, paramBuilder.mUseChronometer, paramBuilder.getWhenIfShowing(), paramBuilder.getPriority(), 0, paramBuilder.mActions, false, null, true);
      NotificationCompatImplBase.buildIntoRemoteViews(paramBuilder.mContext, paramNotification.bigContentView, remoteViews);
      setBackgroundColor(paramBuilder.mContext, paramNotification.bigContentView, paramBuilder.getColor());
      return;
    } 
    if (paramBuilder.mStyle instanceof DecoratedCustomViewStyle) {
      addDecoratedBigStyleToBuilderJellybean(paramNotification, paramBuilder);
      return;
    } 
  }
  
  @TargetApi(16)
  @RequiresApi(16)
  private static void addDecoratedBigStyleToBuilderJellybean(Notification paramNotification, NotificationCompat.Builder paramBuilder) {
    RemoteViews remoteViews1 = paramBuilder.getBigContentView();
    if (remoteViews1 == null)
      remoteViews1 = paramBuilder.getContentView(); 
    if (remoteViews1 == null)
      return; 
    RemoteViews remoteViews2 = NotificationCompatImplBase.applyStandardTemplateWithActions(paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mNumber, paramNotification.icon, paramBuilder.mLargeIcon, paramBuilder.mSubText, paramBuilder.mUseChronometer, paramBuilder.getWhenIfShowing(), paramBuilder.getPriority(), paramBuilder.getColor(), R.layout.notification_template_custom_big, false, paramBuilder.mActions);
    NotificationCompatImplBase.buildIntoRemoteViews(paramBuilder.mContext, remoteViews2, remoteViews1);
    paramNotification.bigContentView = remoteViews2;
  }
  
  @TargetApi(21)
  @RequiresApi(21)
  private static void addDecoratedHeadsUpToBuilderLollipop(Notification paramNotification, NotificationCompat.Builder paramBuilder) {
    RemoteViews remoteViews1;
    RemoteViews remoteViews2 = paramBuilder.getHeadsUpContentView();
    if (remoteViews2 != null) {
      remoteViews1 = remoteViews2;
    } else {
      remoteViews1 = paramBuilder.getContentView();
    } 
    if (remoteViews2 == null)
      return; 
    remoteViews2 = NotificationCompatImplBase.applyStandardTemplateWithActions(paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mNumber, paramNotification.icon, paramBuilder.mLargeIcon, paramBuilder.mSubText, paramBuilder.mUseChronometer, paramBuilder.getWhenIfShowing(), paramBuilder.getPriority(), paramBuilder.getColor(), R.layout.notification_template_custom_big, false, paramBuilder.mActions);
    NotificationCompatImplBase.buildIntoRemoteViews(paramBuilder.mContext, remoteViews2, remoteViews1);
    paramNotification.headsUpContentView = remoteViews2;
  }
  
  @TargetApi(21)
  @RequiresApi(21)
  private static void addHeadsUpToBuilderLollipop(Notification paramNotification, NotificationCompat.Builder paramBuilder) {
    RemoteViews remoteViews;
    if (paramBuilder.getHeadsUpContentView() != null) {
      remoteViews = paramBuilder.getHeadsUpContentView();
    } else {
      remoteViews = paramBuilder.getContentView();
    } 
    if (paramBuilder.mStyle instanceof DecoratedMediaCustomViewStyle && remoteViews != null) {
      paramNotification.headsUpContentView = NotificationCompatImplBase.generateMediaBigView(paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mNumber, paramBuilder.mLargeIcon, paramBuilder.mSubText, paramBuilder.mUseChronometer, paramBuilder.getWhenIfShowing(), paramBuilder.getPriority(), 0, paramBuilder.mActions, false, null, true);
      NotificationCompatImplBase.buildIntoRemoteViews(paramBuilder.mContext, paramNotification.headsUpContentView, remoteViews);
      setBackgroundColor(paramBuilder.mContext, paramNotification.headsUpContentView, paramBuilder.getColor());
      return;
    } 
    if (paramBuilder.mStyle instanceof DecoratedCustomViewStyle) {
      addDecoratedHeadsUpToBuilderLollipop(paramNotification, paramBuilder);
      return;
    } 
  }
  
  private static void addMessagingFallBackStyle(NotificationCompat.MessagingStyle paramMessagingStyle, NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, NotificationCompat.Builder paramBuilder) {
    boolean bool;
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
    List<NotificationCompat.MessagingStyle.Message> list = paramMessagingStyle.getMessages();
    if (paramMessagingStyle.getConversationTitle() != null || hasMessagesWithoutSender(paramMessagingStyle.getMessages())) {
      bool = true;
    } else {
      bool = false;
    } 
    for (int i = list.size() - 1; i >= 0; i--) {
      CharSequence charSequence;
      NotificationCompat.MessagingStyle.Message message = list.get(i);
      if (bool) {
        charSequence = makeMessageLine(paramBuilder, paramMessagingStyle, message);
      } else {
        charSequence = charSequence.getText();
      } 
      if (i != list.size() - 1)
        spannableStringBuilder.insert(0, "\n"); 
      spannableStringBuilder.insert(0, charSequence);
    } 
    NotificationCompatImplJellybean.addBigTextStyle(paramNotificationBuilderWithBuilderAccessor, (CharSequence)spannableStringBuilder);
  }
  
  @TargetApi(14)
  @RequiresApi(14)
  private static RemoteViews addStyleGetContentViewIcs(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, NotificationCompat.Builder paramBuilder) {
    if (paramBuilder.mStyle instanceof MediaStyle) {
      boolean bool;
      MediaStyle mediaStyle = (MediaStyle)paramBuilder.mStyle;
      if (paramBuilder.mStyle instanceof DecoratedMediaCustomViewStyle && paramBuilder.getContentView() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      RemoteViews remoteViews = NotificationCompatImplBase.overrideContentViewMedia(paramNotificationBuilderWithBuilderAccessor, paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mNumber, paramBuilder.mLargeIcon, paramBuilder.mSubText, paramBuilder.mUseChronometer, paramBuilder.getWhenIfShowing(), paramBuilder.getPriority(), paramBuilder.mActions, mediaStyle.mActionsToShowInCompact, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent, bool);
      if (bool) {
        NotificationCompatImplBase.buildIntoRemoteViews(paramBuilder.mContext, remoteViews, paramBuilder.getContentView());
        return remoteViews;
      } 
    } else if (paramBuilder.mStyle instanceof DecoratedCustomViewStyle) {
      return getDecoratedContentView(paramBuilder);
    } 
    return null;
  }
  
  @TargetApi(16)
  @RequiresApi(16)
  private static RemoteViews addStyleGetContentViewJellybean(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, NotificationCompat.Builder paramBuilder) {
    if (paramBuilder.mStyle instanceof NotificationCompat.MessagingStyle)
      addMessagingFallBackStyle((NotificationCompat.MessagingStyle)paramBuilder.mStyle, paramNotificationBuilderWithBuilderAccessor, paramBuilder); 
    return addStyleGetContentViewIcs(paramNotificationBuilderWithBuilderAccessor, paramBuilder);
  }
  
  @TargetApi(21)
  @RequiresApi(21)
  private static RemoteViews addStyleGetContentViewLollipop(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, NotificationCompat.Builder paramBuilder) {
    RemoteViews remoteViews;
    if (paramBuilder.mStyle instanceof MediaStyle) {
      boolean bool1;
      boolean bool2;
      Object object;
      MediaStyle mediaStyle = (MediaStyle)paramBuilder.mStyle;
      int[] arrayOfInt = mediaStyle.mActionsToShowInCompact;
      if (mediaStyle.mToken != null) {
        object = mediaStyle.mToken.getToken();
      } else {
        object = null;
      } 
      NotificationCompatImpl21.addMediaStyle(paramNotificationBuilderWithBuilderAccessor, arrayOfInt, object);
      if (paramBuilder.getContentView() != null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 23) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool2 || (bool1 && paramBuilder.getBigContentView() != null)) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (paramBuilder.mStyle instanceof DecoratedMediaCustomViewStyle && bool1) {
        remoteViews = NotificationCompatImplBase.overrideContentViewMedia(paramNotificationBuilderWithBuilderAccessor, paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mNumber, paramBuilder.mLargeIcon, paramBuilder.mSubText, paramBuilder.mUseChronometer, paramBuilder.getWhenIfShowing(), paramBuilder.getPriority(), paramBuilder.mActions, mediaStyle.mActionsToShowInCompact, false, null, bool2);
        if (bool2)
          NotificationCompatImplBase.buildIntoRemoteViews(paramBuilder.mContext, remoteViews, paramBuilder.getContentView()); 
        setBackgroundColor(paramBuilder.mContext, remoteViews, paramBuilder.getColor());
        return remoteViews;
      } 
      return null;
    } 
    return (paramBuilder.mStyle instanceof DecoratedCustomViewStyle) ? getDecoratedContentView(paramBuilder) : addStyleGetContentViewJellybean((NotificationBuilderWithBuilderAccessor)remoteViews, paramBuilder);
  }
  
  @TargetApi(24)
  @RequiresApi(24)
  private static void addStyleToBuilderApi24(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, NotificationCompat.Builder paramBuilder) {
    if (paramBuilder.mStyle instanceof DecoratedCustomViewStyle) {
      NotificationCompatImpl24.addDecoratedCustomViewStyle(paramNotificationBuilderWithBuilderAccessor);
      return;
    } 
    if (paramBuilder.mStyle instanceof DecoratedMediaCustomViewStyle) {
      NotificationCompatImpl24.addDecoratedMediaCustomViewStyle(paramNotificationBuilderWithBuilderAccessor);
      return;
    } 
    if (!(paramBuilder.mStyle instanceof NotificationCompat.MessagingStyle)) {
      addStyleGetContentViewLollipop(paramNotificationBuilderWithBuilderAccessor, paramBuilder);
      return;
    } 
  }
  
  private static NotificationCompat.MessagingStyle.Message findLatestIncomingMessage(NotificationCompat.MessagingStyle paramMessagingStyle) {
    List<NotificationCompat.MessagingStyle.Message> list = paramMessagingStyle.getMessages();
    for (int i = list.size() - 1; i >= 0; i--) {
      NotificationCompat.MessagingStyle.Message message = list.get(i);
      if (!TextUtils.isEmpty(message.getSender()))
        return message; 
    } 
    return !list.isEmpty() ? list.get(list.size() - 1) : null;
  }
  
  private static RemoteViews getDecoratedContentView(NotificationCompat.Builder paramBuilder) {
    if (paramBuilder.getContentView() == null)
      return null; 
    RemoteViews remoteViews = NotificationCompatImplBase.applyStandardTemplateWithActions(paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mNumber, paramBuilder.mNotification.icon, paramBuilder.mLargeIcon, paramBuilder.mSubText, paramBuilder.mUseChronometer, paramBuilder.getWhenIfShowing(), paramBuilder.getPriority(), paramBuilder.getColor(), R.layout.notification_template_custom_big, false, null);
    NotificationCompatImplBase.buildIntoRemoteViews(paramBuilder.mContext, remoteViews, paramBuilder.getContentView());
    return remoteViews;
  }
  
  public static MediaSessionCompat.Token getMediaSession(Notification paramNotification) {
    Bundle bundle = getExtras(paramNotification);
    if (bundle != null) {
      Parcelable parcelable;
      if (Build.VERSION.SDK_INT >= 21) {
        parcelable = bundle.getParcelable("android.mediaSession");
        if (parcelable != null)
          return MediaSessionCompat.Token.fromToken(parcelable); 
      } else {
        IBinder iBinder = BundleCompat.getBinder((Bundle)parcelable, "android.mediaSession");
        if (iBinder != null) {
          Parcel parcel = Parcel.obtain();
          parcel.writeStrongBinder(iBinder);
          parcel.setDataPosition(0);
          MediaSessionCompat.Token token = (MediaSessionCompat.Token)MediaSessionCompat.Token.CREATOR.createFromParcel(parcel);
          parcel.recycle();
          return token;
        } 
      } 
    } 
    return null;
  }
  
  private static boolean hasMessagesWithoutSender(List<NotificationCompat.MessagingStyle.Message> paramList) {
    for (int i = paramList.size() - 1; i >= 0; i--) {
      if (((NotificationCompat.MessagingStyle.Message)paramList.get(i)).getSender() == null)
        return true; 
    } 
    return false;
  }
  
  private static TextAppearanceSpan makeFontColorSpan(int paramInt) {
    return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(paramInt), null);
  }
  
  private static CharSequence makeMessageLine(NotificationCompat.Builder paramBuilder, NotificationCompat.MessagingStyle paramMessagingStyle, NotificationCompat.MessagingStyle.Message paramMessage) {
    byte b;
    boolean bool;
    BidiFormatter bidiFormatter = BidiFormatter.getInstance();
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool || Build.VERSION.SDK_INT <= 10) {
      b = -16777216;
    } else {
      b = -1;
    } 
    CharSequence charSequence2 = paramMessage.getSender();
    int i = b;
    if (TextUtils.isEmpty(paramMessage.getSender())) {
      CharSequence charSequence;
      if (paramMessagingStyle.getUserDisplayName() == null) {
        charSequence = "";
      } else {
        charSequence = charSequence.getUserDisplayName();
      } 
      i = b;
      charSequence2 = charSequence;
      if (bool) {
        i = b;
        charSequence2 = charSequence;
        if (paramBuilder.getColor() != 0) {
          i = paramBuilder.getColor();
          charSequence2 = charSequence;
        } 
      } 
    } 
    CharSequence charSequence1 = bidiFormatter.unicodeWrap(charSequence2);
    spannableStringBuilder.append(charSequence1);
    spannableStringBuilder.setSpan(makeFontColorSpan(i), spannableStringBuilder.length() - charSequence1.length(), spannableStringBuilder.length(), 33);
    if (paramMessage.getText() == null) {
      charSequence1 = "";
      spannableStringBuilder.append("  ").append(bidiFormatter.unicodeWrap(charSequence1));
      return (CharSequence)spannableStringBuilder;
    } 
    charSequence1 = paramMessage.getText();
    spannableStringBuilder.append("  ").append(bidiFormatter.unicodeWrap(charSequence1));
    return (CharSequence)spannableStringBuilder;
  }
  
  private static void setBackgroundColor(Context paramContext, RemoteViews paramRemoteViews, int paramInt) {
    int i = paramInt;
    if (paramInt == 0)
      i = paramContext.getResources().getColor(R.color.notification_material_background_media_default_color); 
    paramRemoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", i);
  }
  
  private static class Api24Extender extends NotificationCompat.BuilderExtender {
    private Api24Extender() {}
    
    public Notification build(NotificationCompat.Builder param1Builder, NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      NotificationCompat.addStyleToBuilderApi24(param1NotificationBuilderWithBuilderAccessor, param1Builder);
      return param1NotificationBuilderWithBuilderAccessor.build();
    }
  }
  
  public static class Builder extends NotificationCompat.Builder {
    public Builder(Context param1Context) {
      super(param1Context);
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected NotificationCompat.BuilderExtender getExtender() {
      return (Build.VERSION.SDK_INT >= 24) ? new NotificationCompat.Api24Extender() : ((Build.VERSION.SDK_INT >= 21) ? new NotificationCompat.LollipopExtender() : ((Build.VERSION.SDK_INT >= 16) ? new NotificationCompat.JellybeanExtender() : ((Build.VERSION.SDK_INT >= 14) ? new NotificationCompat.IceCreamSandwichExtender() : super.getExtender())));
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected CharSequence resolveText() {
      if (this.mStyle instanceof NotificationCompat.MessagingStyle) {
        NotificationCompat.MessagingStyle messagingStyle = (NotificationCompat.MessagingStyle)this.mStyle;
        NotificationCompat.MessagingStyle.Message message = NotificationCompat.findLatestIncomingMessage(messagingStyle);
        CharSequence charSequence = messagingStyle.getConversationTitle();
        if (message != null)
          return (charSequence != null) ? NotificationCompat.makeMessageLine(this, messagingStyle, message) : message.getText(); 
      } 
      return super.resolveText();
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected CharSequence resolveTitle() {
      if (this.mStyle instanceof NotificationCompat.MessagingStyle) {
        NotificationCompat.MessagingStyle messagingStyle = (NotificationCompat.MessagingStyle)this.mStyle;
        NotificationCompat.MessagingStyle.Message message = NotificationCompat.findLatestIncomingMessage(messagingStyle);
        CharSequence charSequence = messagingStyle.getConversationTitle();
        if (charSequence != null || message != null)
          return (charSequence != null) ? charSequence : message.getSender(); 
      } 
      return super.resolveTitle();
    }
  }
  
  public static class DecoratedCustomViewStyle extends NotificationCompat.Style {}
  
  public static class DecoratedMediaCustomViewStyle extends MediaStyle {}
  
  private static class IceCreamSandwichExtender extends NotificationCompat.BuilderExtender {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      RemoteViews remoteViews = NotificationCompat.addStyleGetContentViewIcs(param1NotificationBuilderWithBuilderAccessor, param1Builder);
      Notification notification = param1NotificationBuilderWithBuilderAccessor.build();
      if (remoteViews != null) {
        notification.contentView = remoteViews;
        return notification;
      } 
      if (param1Builder.getContentView() != null) {
        notification.contentView = param1Builder.getContentView();
        return notification;
      } 
      return notification;
    }
  }
  
  private static class JellybeanExtender extends NotificationCompat.BuilderExtender {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      RemoteViews remoteViews = NotificationCompat.addStyleGetContentViewJellybean(param1NotificationBuilderWithBuilderAccessor, param1Builder);
      Notification notification = param1NotificationBuilderWithBuilderAccessor.build();
      if (remoteViews != null)
        notification.contentView = remoteViews; 
      NotificationCompat.addBigStyleToBuilderJellybean(notification, param1Builder);
      return notification;
    }
  }
  
  private static class LollipopExtender extends NotificationCompat.BuilderExtender {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      RemoteViews remoteViews = NotificationCompat.addStyleGetContentViewLollipop(param1NotificationBuilderWithBuilderAccessor, param1Builder);
      Notification notification = param1NotificationBuilderWithBuilderAccessor.build();
      if (remoteViews != null)
        notification.contentView = remoteViews; 
      NotificationCompat.addBigStyleToBuilderLollipop(notification, param1Builder);
      NotificationCompat.addHeadsUpToBuilderLollipop(notification, param1Builder);
      return notification;
    }
  }
  
  public static class MediaStyle extends NotificationCompat.Style {
    int[] mActionsToShowInCompact = null;
    
    PendingIntent mCancelButtonIntent;
    
    boolean mShowCancelButton;
    
    MediaSessionCompat.Token mToken;
    
    public MediaStyle() {}
    
    public MediaStyle(NotificationCompat.Builder param1Builder) {
      setBuilder(param1Builder);
    }
    
    public MediaStyle setCancelButtonIntent(PendingIntent param1PendingIntent) {
      this.mCancelButtonIntent = param1PendingIntent;
      return this;
    }
    
    public MediaStyle setMediaSession(MediaSessionCompat.Token param1Token) {
      this.mToken = param1Token;
      return this;
    }
    
    public MediaStyle setShowActionsInCompactView(int... param1VarArgs) {
      this.mActionsToShowInCompact = param1VarArgs;
      return this;
    }
    
    public MediaStyle setShowCancelButton(boolean param1Boolean) {
      this.mShowCancelButton = param1Boolean;
      return this;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\app\NotificationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */