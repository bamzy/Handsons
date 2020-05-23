package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;
import android.widget.RemoteViews;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat {
  public static final String CATEGORY_ALARM = "alarm";
  
  public static final String CATEGORY_CALL = "call";
  
  public static final String CATEGORY_EMAIL = "email";
  
  public static final String CATEGORY_ERROR = "err";
  
  public static final String CATEGORY_EVENT = "event";
  
  public static final String CATEGORY_MESSAGE = "msg";
  
  public static final String CATEGORY_PROGRESS = "progress";
  
  public static final String CATEGORY_PROMO = "promo";
  
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  
  public static final String CATEGORY_REMINDER = "reminder";
  
  public static final String CATEGORY_SERVICE = "service";
  
  public static final String CATEGORY_SOCIAL = "social";
  
  public static final String CATEGORY_STATUS = "status";
  
  public static final String CATEGORY_SYSTEM = "sys";
  
  public static final String CATEGORY_TRANSPORT = "transport";
  
  @ColorInt
  public static final int COLOR_DEFAULT = 0;
  
  public static final int DEFAULT_ALL = -1;
  
  public static final int DEFAULT_LIGHTS = 4;
  
  public static final int DEFAULT_SOUND = 1;
  
  public static final int DEFAULT_VIBRATE = 2;
  
  public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
  
  public static final String EXTRA_BIG_TEXT = "android.bigText";
  
  public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
  
  public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
  
  public static final String EXTRA_INFO_TEXT = "android.infoText";
  
  public static final String EXTRA_LARGE_ICON = "android.largeIcon";
  
  public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
  
  public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
  
  public static final String EXTRA_MESSAGES = "android.messages";
  
  public static final String EXTRA_PEOPLE = "android.people";
  
  public static final String EXTRA_PICTURE = "android.picture";
  
  public static final String EXTRA_PROGRESS = "android.progress";
  
  public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
  
  public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
  
  public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
  
  public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
  
  public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
  
  public static final String EXTRA_SHOW_WHEN = "android.showWhen";
  
  public static final String EXTRA_SMALL_ICON = "android.icon";
  
  public static final String EXTRA_SUB_TEXT = "android.subText";
  
  public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
  
  public static final String EXTRA_TEMPLATE = "android.template";
  
  public static final String EXTRA_TEXT = "android.text";
  
  public static final String EXTRA_TEXT_LINES = "android.textLines";
  
  public static final String EXTRA_TITLE = "android.title";
  
  public static final String EXTRA_TITLE_BIG = "android.title.big";
  
  public static final int FLAG_AUTO_CANCEL = 16;
  
  public static final int FLAG_FOREGROUND_SERVICE = 64;
  
  public static final int FLAG_GROUP_SUMMARY = 512;
  
  @Deprecated
  public static final int FLAG_HIGH_PRIORITY = 128;
  
  public static final int FLAG_INSISTENT = 4;
  
  public static final int FLAG_LOCAL_ONLY = 256;
  
  public static final int FLAG_NO_CLEAR = 32;
  
  public static final int FLAG_ONGOING_EVENT = 2;
  
  public static final int FLAG_ONLY_ALERT_ONCE = 8;
  
  public static final int FLAG_SHOW_LIGHTS = 1;
  
  static final NotificationCompatImpl IMPL = new NotificationCompatImplBase();
  
  public static final int PRIORITY_DEFAULT = 0;
  
  public static final int PRIORITY_HIGH = 1;
  
  public static final int PRIORITY_LOW = -1;
  
  public static final int PRIORITY_MAX = 2;
  
  public static final int PRIORITY_MIN = -2;
  
  public static final int STREAM_DEFAULT = -1;
  
  public static final int VISIBILITY_PRIVATE = 0;
  
  public static final int VISIBILITY_PUBLIC = 1;
  
  public static final int VISIBILITY_SECRET = -1;
  
  static void addActionsToBuilder(NotificationBuilderWithActions paramNotificationBuilderWithActions, ArrayList<Action> paramArrayList) {
    Iterator<Action> iterator = paramArrayList.iterator();
    while (iterator.hasNext())
      paramNotificationBuilderWithActions.addAction(iterator.next()); 
  }
  
  static void addStyleToBuilderApi24(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, Style paramStyle) {
    if (paramStyle != null) {
      if (paramStyle instanceof MessagingStyle) {
        paramStyle = paramStyle;
        ArrayList<CharSequence> arrayList1 = new ArrayList();
        ArrayList<Long> arrayList = new ArrayList();
        ArrayList<CharSequence> arrayList2 = new ArrayList();
        ArrayList<String> arrayList3 = new ArrayList();
        ArrayList<Uri> arrayList4 = new ArrayList();
        for (MessagingStyle.Message message : ((MessagingStyle)paramStyle).mMessages) {
          arrayList1.add(message.getText());
          arrayList.add(Long.valueOf(message.getTimestamp()));
          arrayList2.add(message.getSender());
          arrayList3.add(message.getDataMimeType());
          arrayList4.add(message.getDataUri());
        } 
        NotificationCompatApi24.addMessagingStyle(paramNotificationBuilderWithBuilderAccessor, ((MessagingStyle)paramStyle).mUserDisplayName, ((MessagingStyle)paramStyle).mConversationTitle, arrayList1, arrayList, arrayList2, arrayList3, arrayList4);
        return;
      } 
    } else {
      return;
    } 
    addStyleToBuilderJellybean(paramNotificationBuilderWithBuilderAccessor, paramStyle);
  }
  
  static void addStyleToBuilderJellybean(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, Style paramStyle) {
    if (paramStyle != null) {
      if (paramStyle instanceof BigTextStyle) {
        paramStyle = paramStyle;
        NotificationCompatJellybean.addBigTextStyle(paramNotificationBuilderWithBuilderAccessor, ((BigTextStyle)paramStyle).mBigContentTitle, ((BigTextStyle)paramStyle).mSummaryTextSet, ((BigTextStyle)paramStyle).mSummaryText, ((BigTextStyle)paramStyle).mBigText);
        return;
      } 
    } else {
      return;
    } 
    if (paramStyle instanceof InboxStyle) {
      paramStyle = paramStyle;
      NotificationCompatJellybean.addInboxStyle(paramNotificationBuilderWithBuilderAccessor, ((InboxStyle)paramStyle).mBigContentTitle, ((InboxStyle)paramStyle).mSummaryTextSet, ((InboxStyle)paramStyle).mSummaryText, ((InboxStyle)paramStyle).mTexts);
      return;
    } 
    if (paramStyle instanceof BigPictureStyle) {
      paramStyle = paramStyle;
      NotificationCompatJellybean.addBigPictureStyle(paramNotificationBuilderWithBuilderAccessor, ((BigPictureStyle)paramStyle).mBigContentTitle, ((BigPictureStyle)paramStyle).mSummaryTextSet, ((BigPictureStyle)paramStyle).mSummaryText, ((BigPictureStyle)paramStyle).mPicture, ((BigPictureStyle)paramStyle).mBigLargeIcon, ((BigPictureStyle)paramStyle).mBigLargeIconSet);
      return;
    } 
  }
  
  public static Action getAction(Notification paramNotification, int paramInt) {
    return IMPL.getAction(paramNotification, paramInt);
  }
  
  public static int getActionCount(Notification paramNotification) {
    return IMPL.getActionCount(paramNotification);
  }
  
  public static String getCategory(Notification paramNotification) {
    return IMPL.getCategory(paramNotification);
  }
  
  public static Bundle getExtras(Notification paramNotification) {
    return IMPL.getExtras(paramNotification);
  }
  
  public static String getGroup(Notification paramNotification) {
    return IMPL.getGroup(paramNotification);
  }
  
  public static boolean getLocalOnly(Notification paramNotification) {
    return IMPL.getLocalOnly(paramNotification);
  }
  
  static Notification[] getNotificationArrayFromBundle(Bundle paramBundle, String paramString) {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (arrayOfParcelable instanceof Notification[] || arrayOfParcelable == null)
      return (Notification[])arrayOfParcelable; 
    Notification[] arrayOfNotification = new Notification[arrayOfParcelable.length];
    for (int i = 0; i < arrayOfParcelable.length; i++)
      arrayOfNotification[i] = (Notification)arrayOfParcelable[i]; 
    paramBundle.putParcelableArray(paramString, (Parcelable[])arrayOfNotification);
    return arrayOfNotification;
  }
  
  public static String getSortKey(Notification paramNotification) {
    return IMPL.getSortKey(paramNotification);
  }
  
  public static boolean isGroupSummary(Notification paramNotification) {
    return IMPL.isGroupSummary(paramNotification);
  }
  
  static {
    if (BuildCompat.isAtLeastN()) {
      IMPL = new NotificationCompatImplApi24();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new NotificationCompatImplApi21();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 20) {
      IMPL = new NotificationCompatImplApi20();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      IMPL = new NotificationCompatImplKitKat();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new NotificationCompatImplJellybean();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new NotificationCompatImplIceCreamSandwich();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 11) {
      IMPL = new NotificationCompatImplHoneycomb();
      return;
    } 
  }
  
  public static class Action extends NotificationCompatBase.Action {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final NotificationCompatBase.Action.Factory FACTORY = new NotificationCompatBase.Action.Factory() {
        public NotificationCompatBase.Action build(int param2Int, CharSequence param2CharSequence, PendingIntent param2PendingIntent, Bundle param2Bundle, RemoteInputCompatBase.RemoteInput[] param2ArrayOfRemoteInput, boolean param2Boolean) {
          return new NotificationCompat.Action(param2Int, param2CharSequence, param2PendingIntent, param2Bundle, (RemoteInput[])param2ArrayOfRemoteInput, param2Boolean);
        }
        
        public NotificationCompat.Action[] newArray(int param2Int) {
          return new NotificationCompat.Action[param2Int];
        }
      };
    
    public PendingIntent actionIntent;
    
    public int icon;
    
    private boolean mAllowGeneratedReplies;
    
    final Bundle mExtras;
    
    private final RemoteInput[] mRemoteInputs;
    
    public CharSequence title;
    
    public Action(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this(param1Int, param1CharSequence, param1PendingIntent, new Bundle(), null, true);
    }
    
    Action(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent, Bundle param1Bundle, RemoteInput[] param1ArrayOfRemoteInput, boolean param1Boolean) {
      this.icon = param1Int;
      this.title = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      this.actionIntent = param1PendingIntent;
      if (param1Bundle == null)
        param1Bundle = new Bundle(); 
      this.mExtras = param1Bundle;
      this.mRemoteInputs = param1ArrayOfRemoteInput;
      this.mAllowGeneratedReplies = param1Boolean;
    }
    
    public PendingIntent getActionIntent() {
      return this.actionIntent;
    }
    
    public boolean getAllowGeneratedReplies() {
      return this.mAllowGeneratedReplies;
    }
    
    public Bundle getExtras() {
      return this.mExtras;
    }
    
    public int getIcon() {
      return this.icon;
    }
    
    public RemoteInput[] getRemoteInputs() {
      return this.mRemoteInputs;
    }
    
    public CharSequence getTitle() {
      return this.title;
    }
    
    public static final class Builder {
      private boolean mAllowGeneratedReplies;
      
      private final Bundle mExtras;
      
      private final int mIcon;
      
      private final PendingIntent mIntent;
      
      private ArrayList<RemoteInput> mRemoteInputs;
      
      private final CharSequence mTitle;
      
      public Builder(int param2Int, CharSequence param2CharSequence, PendingIntent param2PendingIntent) {
        this(param2Int, param2CharSequence, param2PendingIntent, new Bundle(), null, true);
      }
      
      private Builder(int param2Int, CharSequence param2CharSequence, PendingIntent param2PendingIntent, Bundle param2Bundle, RemoteInput[] param2ArrayOfRemoteInput, boolean param2Boolean) {
        ArrayList<RemoteInput> arrayList;
        this.mAllowGeneratedReplies = true;
        this.mIcon = param2Int;
        this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(param2CharSequence);
        this.mIntent = param2PendingIntent;
        this.mExtras = param2Bundle;
        if (param2ArrayOfRemoteInput == null) {
          param2CharSequence = null;
        } else {
          arrayList = new ArrayList(Arrays.asList((Object[])param2ArrayOfRemoteInput));
        } 
        this.mRemoteInputs = arrayList;
        this.mAllowGeneratedReplies = param2Boolean;
      }
      
      public Builder(NotificationCompat.Action param2Action) {
        this(param2Action.icon, param2Action.title, param2Action.actionIntent, new Bundle(param2Action.mExtras), param2Action.getRemoteInputs(), param2Action.getAllowGeneratedReplies());
      }
      
      public Builder addExtras(Bundle param2Bundle) {
        if (param2Bundle != null)
          this.mExtras.putAll(param2Bundle); 
        return this;
      }
      
      public Builder addRemoteInput(RemoteInput param2RemoteInput) {
        if (this.mRemoteInputs == null)
          this.mRemoteInputs = new ArrayList<RemoteInput>(); 
        this.mRemoteInputs.add(param2RemoteInput);
        return this;
      }
      
      public NotificationCompat.Action build() {
        if (this.mRemoteInputs != null) {
          RemoteInput[] arrayOfRemoteInput1 = this.mRemoteInputs.<RemoteInput>toArray(new RemoteInput[this.mRemoteInputs.size()]);
          return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayOfRemoteInput1, this.mAllowGeneratedReplies);
        } 
        RemoteInput[] arrayOfRemoteInput = null;
        return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayOfRemoteInput, this.mAllowGeneratedReplies);
      }
      
      public Builder extend(NotificationCompat.Action.Extender param2Extender) {
        param2Extender.extend(this);
        return this;
      }
      
      public Bundle getExtras() {
        return this.mExtras;
      }
      
      public Builder setAllowGeneratedReplies(boolean param2Boolean) {
        this.mAllowGeneratedReplies = param2Boolean;
        return this;
      }
    }
    
    public static interface Extender {
      NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param2Builder);
    }
    
    public static final class WearableExtender implements Extender {
      private static final int DEFAULT_FLAGS = 1;
      
      private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
      
      private static final int FLAG_AVAILABLE_OFFLINE = 1;
      
      private static final int FLAG_HINT_DISPLAY_INLINE = 4;
      
      private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
      
      private static final String KEY_CANCEL_LABEL = "cancelLabel";
      
      private static final String KEY_CONFIRM_LABEL = "confirmLabel";
      
      private static final String KEY_FLAGS = "flags";
      
      private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
      
      private CharSequence mCancelLabel;
      
      private CharSequence mConfirmLabel;
      
      private int mFlags = 1;
      
      private CharSequence mInProgressLabel;
      
      public WearableExtender() {}
      
      public WearableExtender(NotificationCompat.Action param2Action) {
        Bundle bundle = param2Action.getExtras().getBundle("android.wearable.EXTENSIONS");
        if (bundle != null) {
          this.mFlags = bundle.getInt("flags", 1);
          this.mInProgressLabel = bundle.getCharSequence("inProgressLabel");
          this.mConfirmLabel = bundle.getCharSequence("confirmLabel");
          this.mCancelLabel = bundle.getCharSequence("cancelLabel");
        } 
      }
      
      private void setFlag(int param2Int, boolean param2Boolean) {
        if (param2Boolean) {
          this.mFlags |= param2Int;
          return;
        } 
        this.mFlags &= param2Int ^ 0xFFFFFFFF;
      }
      
      public WearableExtender clone() {
        WearableExtender wearableExtender = new WearableExtender();
        wearableExtender.mFlags = this.mFlags;
        wearableExtender.mInProgressLabel = this.mInProgressLabel;
        wearableExtender.mConfirmLabel = this.mConfirmLabel;
        wearableExtender.mCancelLabel = this.mCancelLabel;
        return wearableExtender;
      }
      
      public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param2Builder) {
        Bundle bundle = new Bundle();
        if (this.mFlags != 1)
          bundle.putInt("flags", this.mFlags); 
        if (this.mInProgressLabel != null)
          bundle.putCharSequence("inProgressLabel", this.mInProgressLabel); 
        if (this.mConfirmLabel != null)
          bundle.putCharSequence("confirmLabel", this.mConfirmLabel); 
        if (this.mCancelLabel != null)
          bundle.putCharSequence("cancelLabel", this.mCancelLabel); 
        param2Builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
        return param2Builder;
      }
      
      public CharSequence getCancelLabel() {
        return this.mCancelLabel;
      }
      
      public CharSequence getConfirmLabel() {
        return this.mConfirmLabel;
      }
      
      public boolean getHintDisplayActionInline() {
        return ((this.mFlags & 0x4) != 0);
      }
      
      public boolean getHintLaunchesActivity() {
        return ((this.mFlags & 0x2) != 0);
      }
      
      public CharSequence getInProgressLabel() {
        return this.mInProgressLabel;
      }
      
      public boolean isAvailableOffline() {
        return ((this.mFlags & 0x1) != 0);
      }
      
      public WearableExtender setAvailableOffline(boolean param2Boolean) {
        setFlag(1, param2Boolean);
        return this;
      }
      
      public WearableExtender setCancelLabel(CharSequence param2CharSequence) {
        this.mCancelLabel = param2CharSequence;
        return this;
      }
      
      public WearableExtender setConfirmLabel(CharSequence param2CharSequence) {
        this.mConfirmLabel = param2CharSequence;
        return this;
      }
      
      public WearableExtender setHintDisplayActionInline(boolean param2Boolean) {
        setFlag(4, param2Boolean);
        return this;
      }
      
      public WearableExtender setHintLaunchesActivity(boolean param2Boolean) {
        setFlag(2, param2Boolean);
        return this;
      }
      
      public WearableExtender setInProgressLabel(CharSequence param2CharSequence) {
        this.mInProgressLabel = param2CharSequence;
        return this;
      }
    }
  }
  
  static final class null implements NotificationCompatBase.Action.Factory {
    public NotificationCompatBase.Action build(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent, Bundle param1Bundle, RemoteInputCompatBase.RemoteInput[] param1ArrayOfRemoteInput, boolean param1Boolean) {
      return new NotificationCompat.Action(param1Int, param1CharSequence, param1PendingIntent, param1Bundle, (RemoteInput[])param1ArrayOfRemoteInput, param1Boolean);
    }
    
    public NotificationCompat.Action[] newArray(int param1Int) {
      return new NotificationCompat.Action[param1Int];
    }
  }
  
  public static final class Builder {
    private boolean mAllowGeneratedReplies;
    
    private final Bundle mExtras;
    
    private final int mIcon;
    
    private final PendingIntent mIntent;
    
    private ArrayList<RemoteInput> mRemoteInputs;
    
    private final CharSequence mTitle;
    
    public Builder(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this(param1Int, param1CharSequence, param1PendingIntent, new Bundle(), null, true);
    }
    
    private Builder(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent, Bundle param1Bundle, RemoteInput[] param1ArrayOfRemoteInput, boolean param1Boolean) {
      ArrayList<RemoteInput> arrayList;
      this.mAllowGeneratedReplies = true;
      this.mIcon = param1Int;
      this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      this.mIntent = param1PendingIntent;
      this.mExtras = param1Bundle;
      if (param1ArrayOfRemoteInput == null) {
        param1CharSequence = null;
      } else {
        arrayList = new ArrayList(Arrays.asList((Object[])param1ArrayOfRemoteInput));
      } 
      this.mRemoteInputs = arrayList;
      this.mAllowGeneratedReplies = param1Boolean;
    }
    
    public Builder(NotificationCompat.Action param1Action) {
      this(param1Action.icon, param1Action.title, param1Action.actionIntent, new Bundle(param1Action.mExtras), param1Action.getRemoteInputs(), param1Action.getAllowGeneratedReplies());
    }
    
    public Builder addExtras(Bundle param1Bundle) {
      if (param1Bundle != null)
        this.mExtras.putAll(param1Bundle); 
      return this;
    }
    
    public Builder addRemoteInput(RemoteInput param1RemoteInput) {
      if (this.mRemoteInputs == null)
        this.mRemoteInputs = new ArrayList<RemoteInput>(); 
      this.mRemoteInputs.add(param1RemoteInput);
      return this;
    }
    
    public NotificationCompat.Action build() {
      if (this.mRemoteInputs != null) {
        RemoteInput[] arrayOfRemoteInput1 = this.mRemoteInputs.<RemoteInput>toArray(new RemoteInput[this.mRemoteInputs.size()]);
        return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayOfRemoteInput1, this.mAllowGeneratedReplies);
      } 
      RemoteInput[] arrayOfRemoteInput = null;
      return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayOfRemoteInput, this.mAllowGeneratedReplies);
    }
    
    public Builder extend(NotificationCompat.Action.Extender param1Extender) {
      param1Extender.extend(this);
      return this;
    }
    
    public Bundle getExtras() {
      return this.mExtras;
    }
    
    public Builder setAllowGeneratedReplies(boolean param1Boolean) {
      this.mAllowGeneratedReplies = param1Boolean;
      return this;
    }
  }
  
  public static interface Extender {
    NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param1Builder);
  }
  
  public static final class WearableExtender implements Action.Extender {
    private static final int DEFAULT_FLAGS = 1;
    
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    
    private static final int FLAG_AVAILABLE_OFFLINE = 1;
    
    private static final int FLAG_HINT_DISPLAY_INLINE = 4;
    
    private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
    
    private static final String KEY_CANCEL_LABEL = "cancelLabel";
    
    private static final String KEY_CONFIRM_LABEL = "confirmLabel";
    
    private static final String KEY_FLAGS = "flags";
    
    private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
    
    private CharSequence mCancelLabel;
    
    private CharSequence mConfirmLabel;
    
    private int mFlags = 1;
    
    private CharSequence mInProgressLabel;
    
    public WearableExtender() {}
    
    public WearableExtender(NotificationCompat.Action param1Action) {
      Bundle bundle = param1Action.getExtras().getBundle("android.wearable.EXTENSIONS");
      if (bundle != null) {
        this.mFlags = bundle.getInt("flags", 1);
        this.mInProgressLabel = bundle.getCharSequence("inProgressLabel");
        this.mConfirmLabel = bundle.getCharSequence("confirmLabel");
        this.mCancelLabel = bundle.getCharSequence("cancelLabel");
      } 
    }
    
    private void setFlag(int param1Int, boolean param1Boolean) {
      if (param1Boolean) {
        this.mFlags |= param1Int;
        return;
      } 
      this.mFlags &= param1Int ^ 0xFFFFFFFF;
    }
    
    public WearableExtender clone() {
      WearableExtender wearableExtender = new WearableExtender();
      wearableExtender.mFlags = this.mFlags;
      wearableExtender.mInProgressLabel = this.mInProgressLabel;
      wearableExtender.mConfirmLabel = this.mConfirmLabel;
      wearableExtender.mCancelLabel = this.mCancelLabel;
      return wearableExtender;
    }
    
    public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param1Builder) {
      Bundle bundle = new Bundle();
      if (this.mFlags != 1)
        bundle.putInt("flags", this.mFlags); 
      if (this.mInProgressLabel != null)
        bundle.putCharSequence("inProgressLabel", this.mInProgressLabel); 
      if (this.mConfirmLabel != null)
        bundle.putCharSequence("confirmLabel", this.mConfirmLabel); 
      if (this.mCancelLabel != null)
        bundle.putCharSequence("cancelLabel", this.mCancelLabel); 
      param1Builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
      return param1Builder;
    }
    
    public CharSequence getCancelLabel() {
      return this.mCancelLabel;
    }
    
    public CharSequence getConfirmLabel() {
      return this.mConfirmLabel;
    }
    
    public boolean getHintDisplayActionInline() {
      return ((this.mFlags & 0x4) != 0);
    }
    
    public boolean getHintLaunchesActivity() {
      return ((this.mFlags & 0x2) != 0);
    }
    
    public CharSequence getInProgressLabel() {
      return this.mInProgressLabel;
    }
    
    public boolean isAvailableOffline() {
      return ((this.mFlags & 0x1) != 0);
    }
    
    public WearableExtender setAvailableOffline(boolean param1Boolean) {
      setFlag(1, param1Boolean);
      return this;
    }
    
    public WearableExtender setCancelLabel(CharSequence param1CharSequence) {
      this.mCancelLabel = param1CharSequence;
      return this;
    }
    
    public WearableExtender setConfirmLabel(CharSequence param1CharSequence) {
      this.mConfirmLabel = param1CharSequence;
      return this;
    }
    
    public WearableExtender setHintDisplayActionInline(boolean param1Boolean) {
      setFlag(4, param1Boolean);
      return this;
    }
    
    public WearableExtender setHintLaunchesActivity(boolean param1Boolean) {
      setFlag(2, param1Boolean);
      return this;
    }
    
    public WearableExtender setInProgressLabel(CharSequence param1CharSequence) {
      this.mInProgressLabel = param1CharSequence;
      return this;
    }
  }
  
  public static class BigPictureStyle extends Style {
    Bitmap mBigLargeIcon;
    
    boolean mBigLargeIconSet;
    
    Bitmap mPicture;
    
    public BigPictureStyle() {}
    
    public BigPictureStyle(NotificationCompat.Builder param1Builder) {
      setBuilder(param1Builder);
    }
    
    public BigPictureStyle bigLargeIcon(Bitmap param1Bitmap) {
      this.mBigLargeIcon = param1Bitmap;
      this.mBigLargeIconSet = true;
      return this;
    }
    
    public BigPictureStyle bigPicture(Bitmap param1Bitmap) {
      this.mPicture = param1Bitmap;
      return this;
    }
    
    public BigPictureStyle setBigContentTitle(CharSequence param1CharSequence) {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public BigPictureStyle setSummaryText(CharSequence param1CharSequence) {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class BigTextStyle extends Style {
    CharSequence mBigText;
    
    public BigTextStyle() {}
    
    public BigTextStyle(NotificationCompat.Builder param1Builder) {
      setBuilder(param1Builder);
    }
    
    public BigTextStyle bigText(CharSequence param1CharSequence) {
      this.mBigText = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public BigTextStyle setBigContentTitle(CharSequence param1CharSequence) {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public BigTextStyle setSummaryText(CharSequence param1CharSequence) {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class Builder {
    private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ArrayList<NotificationCompat.Action> mActions = new ArrayList<NotificationCompat.Action>();
    
    RemoteViews mBigContentView;
    
    String mCategory;
    
    int mColor = 0;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mContentInfo;
    
    PendingIntent mContentIntent;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mContentText;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mContentTitle;
    
    RemoteViews mContentView;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Context mContext;
    
    Bundle mExtras;
    
    PendingIntent mFullScreenIntent;
    
    String mGroupKey;
    
    boolean mGroupSummary;
    
    RemoteViews mHeadsUpContentView;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bitmap mLargeIcon;
    
    boolean mLocalOnly = false;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Notification mNotification = new Notification();
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int mNumber;
    
    public ArrayList<String> mPeople;
    
    int mPriority;
    
    int mProgress;
    
    boolean mProgressIndeterminate;
    
    int mProgressMax;
    
    Notification mPublicVersion;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence[] mRemoteInputHistory;
    
    boolean mShowWhen = true;
    
    String mSortKey;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NotificationCompat.Style mStyle;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mSubText;
    
    RemoteViews mTickerView;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mUseChronometer;
    
    int mVisibility = 0;
    
    public Builder(Context param1Context) {
      this.mContext = param1Context;
      this.mNotification.when = System.currentTimeMillis();
      this.mNotification.audioStreamType = -1;
      this.mPriority = 0;
      this.mPeople = new ArrayList<String>();
    }
    
    protected static CharSequence limitCharSequenceLength(CharSequence param1CharSequence) {
      return (param1CharSequence != null && param1CharSequence.length() > 5120) ? param1CharSequence.subSequence(0, 5120) : param1CharSequence;
    }
    
    private void setFlag(int param1Int, boolean param1Boolean) {
      if (param1Boolean) {
        Notification notification1 = this.mNotification;
        notification1.flags |= param1Int;
        return;
      } 
      Notification notification = this.mNotification;
      notification.flags &= param1Int ^ 0xFFFFFFFF;
    }
    
    public Builder addAction(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this.mActions.add(new NotificationCompat.Action(param1Int, param1CharSequence, param1PendingIntent));
      return this;
    }
    
    public Builder addAction(NotificationCompat.Action param1Action) {
      this.mActions.add(param1Action);
      return this;
    }
    
    public Builder addExtras(Bundle param1Bundle) {
      if (param1Bundle != null) {
        if (this.mExtras == null) {
          this.mExtras = new Bundle(param1Bundle);
          return this;
        } 
      } else {
        return this;
      } 
      this.mExtras.putAll(param1Bundle);
      return this;
    }
    
    public Builder addPerson(String param1String) {
      this.mPeople.add(param1String);
      return this;
    }
    
    public Notification build() {
      return NotificationCompat.IMPL.build(this, getExtender());
    }
    
    public Builder extend(NotificationCompat.Extender param1Extender) {
      param1Extender.extend(this);
      return this;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews getBigContentView() {
      return this.mBigContentView;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getColor() {
      return this.mColor;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews getContentView() {
      return this.mContentView;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected NotificationCompat.BuilderExtender getExtender() {
      return new NotificationCompat.BuilderExtender();
    }
    
    public Bundle getExtras() {
      if (this.mExtras == null)
        this.mExtras = new Bundle(); 
      return this.mExtras;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews getHeadsUpContentView() {
      return this.mHeadsUpContentView;
    }
    
    @Deprecated
    public Notification getNotification() {
      return build();
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getPriority() {
      return this.mPriority;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getWhenIfShowing() {
      return this.mShowWhen ? this.mNotification.when : 0L;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected CharSequence resolveText() {
      return this.mContentText;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected CharSequence resolveTitle() {
      return this.mContentTitle;
    }
    
    public Builder setAutoCancel(boolean param1Boolean) {
      setFlag(16, param1Boolean);
      return this;
    }
    
    public Builder setCategory(String param1String) {
      this.mCategory = param1String;
      return this;
    }
    
    public Builder setColor(@ColorInt int param1Int) {
      this.mColor = param1Int;
      return this;
    }
    
    public Builder setContent(RemoteViews param1RemoteViews) {
      this.mNotification.contentView = param1RemoteViews;
      return this;
    }
    
    public Builder setContentInfo(CharSequence param1CharSequence) {
      this.mContentInfo = limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public Builder setContentIntent(PendingIntent param1PendingIntent) {
      this.mContentIntent = param1PendingIntent;
      return this;
    }
    
    public Builder setContentText(CharSequence param1CharSequence) {
      this.mContentText = limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public Builder setContentTitle(CharSequence param1CharSequence) {
      this.mContentTitle = limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public Builder setCustomBigContentView(RemoteViews param1RemoteViews) {
      this.mBigContentView = param1RemoteViews;
      return this;
    }
    
    public Builder setCustomContentView(RemoteViews param1RemoteViews) {
      this.mContentView = param1RemoteViews;
      return this;
    }
    
    public Builder setCustomHeadsUpContentView(RemoteViews param1RemoteViews) {
      this.mHeadsUpContentView = param1RemoteViews;
      return this;
    }
    
    public Builder setDefaults(int param1Int) {
      this.mNotification.defaults = param1Int;
      if ((param1Int & 0x4) != 0) {
        Notification notification = this.mNotification;
        notification.flags |= 0x1;
      } 
      return this;
    }
    
    public Builder setDeleteIntent(PendingIntent param1PendingIntent) {
      this.mNotification.deleteIntent = param1PendingIntent;
      return this;
    }
    
    public Builder setExtras(Bundle param1Bundle) {
      this.mExtras = param1Bundle;
      return this;
    }
    
    public Builder setFullScreenIntent(PendingIntent param1PendingIntent, boolean param1Boolean) {
      this.mFullScreenIntent = param1PendingIntent;
      setFlag(128, param1Boolean);
      return this;
    }
    
    public Builder setGroup(String param1String) {
      this.mGroupKey = param1String;
      return this;
    }
    
    public Builder setGroupSummary(boolean param1Boolean) {
      this.mGroupSummary = param1Boolean;
      return this;
    }
    
    public Builder setLargeIcon(Bitmap param1Bitmap) {
      this.mLargeIcon = param1Bitmap;
      return this;
    }
    
    public Builder setLights(@ColorInt int param1Int1, int param1Int2, int param1Int3) {
      boolean bool = true;
      this.mNotification.ledARGB = param1Int1;
      this.mNotification.ledOnMS = param1Int2;
      this.mNotification.ledOffMS = param1Int3;
      if (this.mNotification.ledOnMS != 0 && this.mNotification.ledOffMS != 0) {
        param1Int1 = 1;
      } else {
        param1Int1 = 0;
      } 
      Notification notification = this.mNotification;
      param1Int2 = this.mNotification.flags;
      if (param1Int1 != 0) {
        param1Int1 = bool;
        notification.flags = param1Int1 | param1Int2 & 0xFFFFFFFE;
        return this;
      } 
      param1Int1 = 0;
      notification.flags = param1Int1 | param1Int2 & 0xFFFFFFFE;
      return this;
    }
    
    public Builder setLocalOnly(boolean param1Boolean) {
      this.mLocalOnly = param1Boolean;
      return this;
    }
    
    public Builder setNumber(int param1Int) {
      this.mNumber = param1Int;
      return this;
    }
    
    public Builder setOngoing(boolean param1Boolean) {
      setFlag(2, param1Boolean);
      return this;
    }
    
    public Builder setOnlyAlertOnce(boolean param1Boolean) {
      setFlag(8, param1Boolean);
      return this;
    }
    
    public Builder setPriority(int param1Int) {
      this.mPriority = param1Int;
      return this;
    }
    
    public Builder setProgress(int param1Int1, int param1Int2, boolean param1Boolean) {
      this.mProgressMax = param1Int1;
      this.mProgress = param1Int2;
      this.mProgressIndeterminate = param1Boolean;
      return this;
    }
    
    public Builder setPublicVersion(Notification param1Notification) {
      this.mPublicVersion = param1Notification;
      return this;
    }
    
    public Builder setRemoteInputHistory(CharSequence[] param1ArrayOfCharSequence) {
      this.mRemoteInputHistory = param1ArrayOfCharSequence;
      return this;
    }
    
    public Builder setShowWhen(boolean param1Boolean) {
      this.mShowWhen = param1Boolean;
      return this;
    }
    
    public Builder setSmallIcon(int param1Int) {
      this.mNotification.icon = param1Int;
      return this;
    }
    
    public Builder setSmallIcon(int param1Int1, int param1Int2) {
      this.mNotification.icon = param1Int1;
      this.mNotification.iconLevel = param1Int2;
      return this;
    }
    
    public Builder setSortKey(String param1String) {
      this.mSortKey = param1String;
      return this;
    }
    
    public Builder setSound(Uri param1Uri) {
      this.mNotification.sound = param1Uri;
      this.mNotification.audioStreamType = -1;
      return this;
    }
    
    public Builder setSound(Uri param1Uri, int param1Int) {
      this.mNotification.sound = param1Uri;
      this.mNotification.audioStreamType = param1Int;
      return this;
    }
    
    public Builder setStyle(NotificationCompat.Style param1Style) {
      if (this.mStyle != param1Style) {
        this.mStyle = param1Style;
        if (this.mStyle != null)
          this.mStyle.setBuilder(this); 
      } 
      return this;
    }
    
    public Builder setSubText(CharSequence param1CharSequence) {
      this.mSubText = limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence param1CharSequence) {
      this.mNotification.tickerText = limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence param1CharSequence, RemoteViews param1RemoteViews) {
      this.mNotification.tickerText = limitCharSequenceLength(param1CharSequence);
      this.mTickerView = param1RemoteViews;
      return this;
    }
    
    public Builder setUsesChronometer(boolean param1Boolean) {
      this.mUseChronometer = param1Boolean;
      return this;
    }
    
    public Builder setVibrate(long[] param1ArrayOflong) {
      this.mNotification.vibrate = param1ArrayOflong;
      return this;
    }
    
    public Builder setVisibility(int param1Int) {
      this.mVisibility = param1Int;
      return this;
    }
    
    public Builder setWhen(long param1Long) {
      this.mNotification.when = param1Long;
      return this;
    }
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  protected static class BuilderExtender {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      Notification notification = param1NotificationBuilderWithBuilderAccessor.build();
      if (param1Builder.mContentView != null)
        notification.contentView = param1Builder.mContentView; 
      return notification;
    }
  }
  
  public static final class CarExtender implements Extender {
    private static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
    
    private static final String EXTRA_COLOR = "app_color";
    
    private static final String EXTRA_CONVERSATION = "car_conversation";
    
    private static final String EXTRA_LARGE_ICON = "large_icon";
    
    private static final String TAG = "CarExtender";
    
    private int mColor = 0;
    
    private Bitmap mLargeIcon;
    
    private UnreadConversation mUnreadConversation;
    
    public CarExtender() {}
    
    public CarExtender(Notification param1Notification) {
      if (Build.VERSION.SDK_INT >= 21) {
        Bundle bundle;
        if (NotificationCompat.getExtras(param1Notification) == null) {
          param1Notification = null;
        } else {
          bundle = NotificationCompat.getExtras(param1Notification).getBundle("android.car.EXTENSIONS");
        } 
        if (bundle != null) {
          this.mLargeIcon = (Bitmap)bundle.getParcelable("large_icon");
          this.mColor = bundle.getInt("app_color", 0);
          bundle = bundle.getBundle("car_conversation");
          this.mUnreadConversation = (UnreadConversation)NotificationCompat.IMPL.getUnreadConversationFromBundle(bundle, UnreadConversation.FACTORY, RemoteInput.FACTORY);
          return;
        } 
      } 
    }
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder param1Builder) {
      if (Build.VERSION.SDK_INT < 21)
        return param1Builder; 
      Bundle bundle = new Bundle();
      if (this.mLargeIcon != null)
        bundle.putParcelable("large_icon", (Parcelable)this.mLargeIcon); 
      if (this.mColor != 0)
        bundle.putInt("app_color", this.mColor); 
      if (this.mUnreadConversation != null)
        bundle.putBundle("car_conversation", NotificationCompat.IMPL.getBundleForUnreadConversation(this.mUnreadConversation)); 
      param1Builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
      return param1Builder;
    }
    
    @ColorInt
    public int getColor() {
      return this.mColor;
    }
    
    public Bitmap getLargeIcon() {
      return this.mLargeIcon;
    }
    
    public UnreadConversation getUnreadConversation() {
      return this.mUnreadConversation;
    }
    
    public CarExtender setColor(@ColorInt int param1Int) {
      this.mColor = param1Int;
      return this;
    }
    
    public CarExtender setLargeIcon(Bitmap param1Bitmap) {
      this.mLargeIcon = param1Bitmap;
      return this;
    }
    
    public CarExtender setUnreadConversation(UnreadConversation param1UnreadConversation) {
      this.mUnreadConversation = param1UnreadConversation;
      return this;
    }
    
    public static class UnreadConversation extends NotificationCompatBase.UnreadConversation {
      static final NotificationCompatBase.UnreadConversation.Factory FACTORY = new NotificationCompatBase.UnreadConversation.Factory() {
          public NotificationCompat.CarExtender.UnreadConversation build(String[] param3ArrayOfString1, RemoteInputCompatBase.RemoteInput param3RemoteInput, PendingIntent param3PendingIntent1, PendingIntent param3PendingIntent2, String[] param3ArrayOfString2, long param3Long) {
            return new NotificationCompat.CarExtender.UnreadConversation(param3ArrayOfString1, (RemoteInput)param3RemoteInput, param3PendingIntent1, param3PendingIntent2, param3ArrayOfString2, param3Long);
          }
        };
      
      private final long mLatestTimestamp;
      
      private final String[] mMessages;
      
      private final String[] mParticipants;
      
      private final PendingIntent mReadPendingIntent;
      
      private final RemoteInput mRemoteInput;
      
      private final PendingIntent mReplyPendingIntent;
      
      UnreadConversation(String[] param2ArrayOfString1, RemoteInput param2RemoteInput, PendingIntent param2PendingIntent1, PendingIntent param2PendingIntent2, String[] param2ArrayOfString2, long param2Long) {
        this.mMessages = param2ArrayOfString1;
        this.mRemoteInput = param2RemoteInput;
        this.mReadPendingIntent = param2PendingIntent2;
        this.mReplyPendingIntent = param2PendingIntent1;
        this.mParticipants = param2ArrayOfString2;
        this.mLatestTimestamp = param2Long;
      }
      
      public long getLatestTimestamp() {
        return this.mLatestTimestamp;
      }
      
      public String[] getMessages() {
        return this.mMessages;
      }
      
      public String getParticipant() {
        return (this.mParticipants.length > 0) ? this.mParticipants[0] : null;
      }
      
      public String[] getParticipants() {
        return this.mParticipants;
      }
      
      public PendingIntent getReadPendingIntent() {
        return this.mReadPendingIntent;
      }
      
      public RemoteInput getRemoteInput() {
        return this.mRemoteInput;
      }
      
      public PendingIntent getReplyPendingIntent() {
        return this.mReplyPendingIntent;
      }
      
      public static class Builder {
        private long mLatestTimestamp;
        
        private final List<String> mMessages = new ArrayList<String>();
        
        private final String mParticipant;
        
        private PendingIntent mReadPendingIntent;
        
        private RemoteInput mRemoteInput;
        
        private PendingIntent mReplyPendingIntent;
        
        public Builder(String param3String) {
          this.mParticipant = param3String;
        }
        
        public Builder addMessage(String param3String) {
          this.mMessages.add(param3String);
          return this;
        }
        
        public NotificationCompat.CarExtender.UnreadConversation build() {
          String[] arrayOfString = this.mMessages.<String>toArray(new String[this.mMessages.size()]);
          String str = this.mParticipant;
          RemoteInput remoteInput = this.mRemoteInput;
          PendingIntent pendingIntent1 = this.mReplyPendingIntent;
          PendingIntent pendingIntent2 = this.mReadPendingIntent;
          long l = this.mLatestTimestamp;
          return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
        }
        
        public Builder setLatestTimestamp(long param3Long) {
          this.mLatestTimestamp = param3Long;
          return this;
        }
        
        public Builder setReadPendingIntent(PendingIntent param3PendingIntent) {
          this.mReadPendingIntent = param3PendingIntent;
          return this;
        }
        
        public Builder setReplyAction(PendingIntent param3PendingIntent, RemoteInput param3RemoteInput) {
          this.mRemoteInput = param3RemoteInput;
          this.mReplyPendingIntent = param3PendingIntent;
          return this;
        }
      }
    }
    
    static final class null implements NotificationCompatBase.UnreadConversation.Factory {
      public NotificationCompat.CarExtender.UnreadConversation build(String[] param2ArrayOfString1, RemoteInputCompatBase.RemoteInput param2RemoteInput, PendingIntent param2PendingIntent1, PendingIntent param2PendingIntent2, String[] param2ArrayOfString2, long param2Long) {
        return new NotificationCompat.CarExtender.UnreadConversation(param2ArrayOfString1, (RemoteInput)param2RemoteInput, param2PendingIntent1, param2PendingIntent2, param2ArrayOfString2, param2Long);
      }
    }
    
    public static class Builder {
      private long mLatestTimestamp;
      
      private final List<String> mMessages = new ArrayList<String>();
      
      private final String mParticipant;
      
      private PendingIntent mReadPendingIntent;
      
      private RemoteInput mRemoteInput;
      
      private PendingIntent mReplyPendingIntent;
      
      public Builder(String param2String) {
        this.mParticipant = param2String;
      }
      
      public Builder addMessage(String param2String) {
        this.mMessages.add(param2String);
        return this;
      }
      
      public NotificationCompat.CarExtender.UnreadConversation build() {
        String[] arrayOfString = this.mMessages.<String>toArray(new String[this.mMessages.size()]);
        String str = this.mParticipant;
        RemoteInput remoteInput = this.mRemoteInput;
        PendingIntent pendingIntent1 = this.mReplyPendingIntent;
        PendingIntent pendingIntent2 = this.mReadPendingIntent;
        long l = this.mLatestTimestamp;
        return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
      }
      
      public Builder setLatestTimestamp(long param2Long) {
        this.mLatestTimestamp = param2Long;
        return this;
      }
      
      public Builder setReadPendingIntent(PendingIntent param2PendingIntent) {
        this.mReadPendingIntent = param2PendingIntent;
        return this;
      }
      
      public Builder setReplyAction(PendingIntent param2PendingIntent, RemoteInput param2RemoteInput) {
        this.mRemoteInput = param2RemoteInput;
        this.mReplyPendingIntent = param2PendingIntent;
        return this;
      }
    }
  }
  
  public static class UnreadConversation extends NotificationCompatBase.UnreadConversation {
    static final NotificationCompatBase.UnreadConversation.Factory FACTORY = new NotificationCompatBase.UnreadConversation.Factory() {
        public NotificationCompat.CarExtender.UnreadConversation build(String[] param3ArrayOfString1, RemoteInputCompatBase.RemoteInput param3RemoteInput, PendingIntent param3PendingIntent1, PendingIntent param3PendingIntent2, String[] param3ArrayOfString2, long param3Long) {
          return new NotificationCompat.CarExtender.UnreadConversation(param3ArrayOfString1, (RemoteInput)param3RemoteInput, param3PendingIntent1, param3PendingIntent2, param3ArrayOfString2, param3Long);
        }
      };
    
    private final long mLatestTimestamp;
    
    private final String[] mMessages;
    
    private final String[] mParticipants;
    
    private final PendingIntent mReadPendingIntent;
    
    private final RemoteInput mRemoteInput;
    
    private final PendingIntent mReplyPendingIntent;
    
    UnreadConversation(String[] param1ArrayOfString1, RemoteInput param1RemoteInput, PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, String[] param1ArrayOfString2, long param1Long) {
      this.mMessages = param1ArrayOfString1;
      this.mRemoteInput = param1RemoteInput;
      this.mReadPendingIntent = param1PendingIntent2;
      this.mReplyPendingIntent = param1PendingIntent1;
      this.mParticipants = param1ArrayOfString2;
      this.mLatestTimestamp = param1Long;
    }
    
    public long getLatestTimestamp() {
      return this.mLatestTimestamp;
    }
    
    public String[] getMessages() {
      return this.mMessages;
    }
    
    public String getParticipant() {
      return (this.mParticipants.length > 0) ? this.mParticipants[0] : null;
    }
    
    public String[] getParticipants() {
      return this.mParticipants;
    }
    
    public PendingIntent getReadPendingIntent() {
      return this.mReadPendingIntent;
    }
    
    public RemoteInput getRemoteInput() {
      return this.mRemoteInput;
    }
    
    public PendingIntent getReplyPendingIntent() {
      return this.mReplyPendingIntent;
    }
    
    public static class Builder {
      private long mLatestTimestamp;
      
      private final List<String> mMessages = new ArrayList<String>();
      
      private final String mParticipant;
      
      private PendingIntent mReadPendingIntent;
      
      private RemoteInput mRemoteInput;
      
      private PendingIntent mReplyPendingIntent;
      
      public Builder(String param3String) {
        this.mParticipant = param3String;
      }
      
      public Builder addMessage(String param3String) {
        this.mMessages.add(param3String);
        return this;
      }
      
      public NotificationCompat.CarExtender.UnreadConversation build() {
        String[] arrayOfString = this.mMessages.<String>toArray(new String[this.mMessages.size()]);
        String str = this.mParticipant;
        RemoteInput remoteInput = this.mRemoteInput;
        PendingIntent pendingIntent1 = this.mReplyPendingIntent;
        PendingIntent pendingIntent2 = this.mReadPendingIntent;
        long l = this.mLatestTimestamp;
        return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
      }
      
      public Builder setLatestTimestamp(long param3Long) {
        this.mLatestTimestamp = param3Long;
        return this;
      }
      
      public Builder setReadPendingIntent(PendingIntent param3PendingIntent) {
        this.mReadPendingIntent = param3PendingIntent;
        return this;
      }
      
      public Builder setReplyAction(PendingIntent param3PendingIntent, RemoteInput param3RemoteInput) {
        this.mRemoteInput = param3RemoteInput;
        this.mReplyPendingIntent = param3PendingIntent;
        return this;
      }
    }
  }
  
  static final class null implements NotificationCompatBase.UnreadConversation.Factory {
    public NotificationCompat.CarExtender.UnreadConversation build(String[] param1ArrayOfString1, RemoteInputCompatBase.RemoteInput param1RemoteInput, PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, String[] param1ArrayOfString2, long param1Long) {
      return new NotificationCompat.CarExtender.UnreadConversation(param1ArrayOfString1, (RemoteInput)param1RemoteInput, param1PendingIntent1, param1PendingIntent2, param1ArrayOfString2, param1Long);
    }
  }
  
  public static class Builder {
    private long mLatestTimestamp;
    
    private final List<String> mMessages = new ArrayList<String>();
    
    private final String mParticipant;
    
    private PendingIntent mReadPendingIntent;
    
    private RemoteInput mRemoteInput;
    
    private PendingIntent mReplyPendingIntent;
    
    public Builder(String param1String) {
      this.mParticipant = param1String;
    }
    
    public Builder addMessage(String param1String) {
      this.mMessages.add(param1String);
      return this;
    }
    
    public NotificationCompat.CarExtender.UnreadConversation build() {
      String[] arrayOfString = this.mMessages.<String>toArray(new String[this.mMessages.size()]);
      String str = this.mParticipant;
      RemoteInput remoteInput = this.mRemoteInput;
      PendingIntent pendingIntent1 = this.mReplyPendingIntent;
      PendingIntent pendingIntent2 = this.mReadPendingIntent;
      long l = this.mLatestTimestamp;
      return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
    }
    
    public Builder setLatestTimestamp(long param1Long) {
      this.mLatestTimestamp = param1Long;
      return this;
    }
    
    public Builder setReadPendingIntent(PendingIntent param1PendingIntent) {
      this.mReadPendingIntent = param1PendingIntent;
      return this;
    }
    
    public Builder setReplyAction(PendingIntent param1PendingIntent, RemoteInput param1RemoteInput) {
      this.mRemoteInput = param1RemoteInput;
      this.mReplyPendingIntent = param1PendingIntent;
      return this;
    }
  }
  
  public static interface Extender {
    NotificationCompat.Builder extend(NotificationCompat.Builder param1Builder);
  }
  
  public static class InboxStyle extends Style {
    ArrayList<CharSequence> mTexts = new ArrayList<CharSequence>();
    
    public InboxStyle() {}
    
    public InboxStyle(NotificationCompat.Builder param1Builder) {
      setBuilder(param1Builder);
    }
    
    public InboxStyle addLine(CharSequence param1CharSequence) {
      this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence));
      return this;
    }
    
    public InboxStyle setBigContentTitle(CharSequence param1CharSequence) {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public InboxStyle setSummaryText(CharSequence param1CharSequence) {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class MessagingStyle extends Style {
    public static final int MAXIMUM_RETAINED_MESSAGES = 25;
    
    CharSequence mConversationTitle;
    
    List<Message> mMessages = new ArrayList<Message>();
    
    CharSequence mUserDisplayName;
    
    MessagingStyle() {}
    
    public MessagingStyle(@NonNull CharSequence param1CharSequence) {
      this.mUserDisplayName = param1CharSequence;
    }
    
    public static MessagingStyle extractMessagingStyleFromNotification(Notification param1Notification) {
      Bundle bundle = NotificationCompat.IMPL.getExtras(param1Notification);
      if (bundle != null && !bundle.containsKey("android.selfDisplayName"))
        return null; 
      try {
        MessagingStyle messagingStyle = new MessagingStyle();
        messagingStyle.restoreFromCompatExtras(bundle);
        return messagingStyle;
      } catch (ClassCastException classCastException) {
        return null;
      } 
    }
    
    public void addCompatExtras(Bundle param1Bundle) {
      super.addCompatExtras(param1Bundle);
      if (this.mUserDisplayName != null)
        param1Bundle.putCharSequence("android.selfDisplayName", this.mUserDisplayName); 
      if (this.mConversationTitle != null)
        param1Bundle.putCharSequence("android.conversationTitle", this.mConversationTitle); 
      if (!this.mMessages.isEmpty())
        param1Bundle.putParcelableArray("android.messages", (Parcelable[])Message.getBundleArrayForMessages(this.mMessages)); 
    }
    
    public MessagingStyle addMessage(Message param1Message) {
      this.mMessages.add(param1Message);
      if (this.mMessages.size() > 25)
        this.mMessages.remove(0); 
      return this;
    }
    
    public MessagingStyle addMessage(CharSequence param1CharSequence1, long param1Long, CharSequence param1CharSequence2) {
      this.mMessages.add(new Message(param1CharSequence1, param1Long, param1CharSequence2));
      if (this.mMessages.size() > 25)
        this.mMessages.remove(0); 
      return this;
    }
    
    public CharSequence getConversationTitle() {
      return this.mConversationTitle;
    }
    
    public List<Message> getMessages() {
      return this.mMessages;
    }
    
    public CharSequence getUserDisplayName() {
      return this.mUserDisplayName;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void restoreFromCompatExtras(Bundle param1Bundle) {
      this.mMessages.clear();
      this.mUserDisplayName = param1Bundle.getString("android.selfDisplayName");
      this.mConversationTitle = param1Bundle.getString("android.conversationTitle");
      Parcelable[] arrayOfParcelable = param1Bundle.getParcelableArray("android.messages");
      if (arrayOfParcelable != null)
        this.mMessages = Message.getMessagesFromBundleArray(arrayOfParcelable); 
    }
    
    public MessagingStyle setConversationTitle(CharSequence param1CharSequence) {
      this.mConversationTitle = param1CharSequence;
      return this;
    }
    
    public static final class Message {
      static final String KEY_DATA_MIME_TYPE = "type";
      
      static final String KEY_DATA_URI = "uri";
      
      static final String KEY_SENDER = "sender";
      
      static final String KEY_TEXT = "text";
      
      static final String KEY_TIMESTAMP = "time";
      
      private String mDataMimeType;
      
      private Uri mDataUri;
      
      private final CharSequence mSender;
      
      private final CharSequence mText;
      
      private final long mTimestamp;
      
      public Message(CharSequence param2CharSequence1, long param2Long, CharSequence param2CharSequence2) {
        this.mText = param2CharSequence1;
        this.mTimestamp = param2Long;
        this.mSender = param2CharSequence2;
      }
      
      static Bundle[] getBundleArrayForMessages(List<Message> param2List) {
        Bundle[] arrayOfBundle = new Bundle[param2List.size()];
        int j = param2List.size();
        for (int i = 0; i < j; i++)
          arrayOfBundle[i] = ((Message)param2List.get(i)).toBundle(); 
        return arrayOfBundle;
      }
      
      static Message getMessageFromBundle(Bundle param2Bundle) {
        Message message;
        try {
          if (!param2Bundle.containsKey("text") || !param2Bundle.containsKey("time"))
            return null; 
          Message message1 = new Message(param2Bundle.getCharSequence("text"), param2Bundle.getLong("time"), param2Bundle.getCharSequence("sender"));
          message = message1;
          if (param2Bundle.containsKey("type")) {
            message = message1;
            if (param2Bundle.containsKey("uri")) {
              message1.setData(param2Bundle.getString("type"), (Uri)param2Bundle.getParcelable("uri"));
              return message1;
            } 
          } 
        } catch (ClassCastException classCastException) {
          return null;
        } 
        return message;
      }
      
      static List<Message> getMessagesFromBundleArray(Parcelable[] param2ArrayOfParcelable) {
        ArrayList<Message> arrayList = new ArrayList(param2ArrayOfParcelable.length);
        for (int i = 0; i < param2ArrayOfParcelable.length; i++) {
          if (param2ArrayOfParcelable[i] instanceof Bundle) {
            Message message = getMessageFromBundle((Bundle)param2ArrayOfParcelable[i]);
            if (message != null)
              arrayList.add(message); 
          } 
        } 
        return arrayList;
      }
      
      private Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.mText != null)
          bundle.putCharSequence("text", this.mText); 
        bundle.putLong("time", this.mTimestamp);
        if (this.mSender != null)
          bundle.putCharSequence("sender", this.mSender); 
        if (this.mDataMimeType != null)
          bundle.putString("type", this.mDataMimeType); 
        if (this.mDataUri != null)
          bundle.putParcelable("uri", (Parcelable)this.mDataUri); 
        return bundle;
      }
      
      public String getDataMimeType() {
        return this.mDataMimeType;
      }
      
      public Uri getDataUri() {
        return this.mDataUri;
      }
      
      public CharSequence getSender() {
        return this.mSender;
      }
      
      public CharSequence getText() {
        return this.mText;
      }
      
      public long getTimestamp() {
        return this.mTimestamp;
      }
      
      public Message setData(String param2String, Uri param2Uri) {
        this.mDataMimeType = param2String;
        this.mDataUri = param2Uri;
        return this;
      }
    }
  }
  
  public static final class Message {
    static final String KEY_DATA_MIME_TYPE = "type";
    
    static final String KEY_DATA_URI = "uri";
    
    static final String KEY_SENDER = "sender";
    
    static final String KEY_TEXT = "text";
    
    static final String KEY_TIMESTAMP = "time";
    
    private String mDataMimeType;
    
    private Uri mDataUri;
    
    private final CharSequence mSender;
    
    private final CharSequence mText;
    
    private final long mTimestamp;
    
    public Message(CharSequence param1CharSequence1, long param1Long, CharSequence param1CharSequence2) {
      this.mText = param1CharSequence1;
      this.mTimestamp = param1Long;
      this.mSender = param1CharSequence2;
    }
    
    static Bundle[] getBundleArrayForMessages(List<Message> param1List) {
      Bundle[] arrayOfBundle = new Bundle[param1List.size()];
      int j = param1List.size();
      for (int i = 0; i < j; i++)
        arrayOfBundle[i] = ((Message)param1List.get(i)).toBundle(); 
      return arrayOfBundle;
    }
    
    static Message getMessageFromBundle(Bundle param1Bundle) {
      Message message;
      try {
        if (!param1Bundle.containsKey("text") || !param1Bundle.containsKey("time"))
          return null; 
        Message message1 = new Message(param1Bundle.getCharSequence("text"), param1Bundle.getLong("time"), param1Bundle.getCharSequence("sender"));
        message = message1;
        if (param1Bundle.containsKey("type")) {
          message = message1;
          if (param1Bundle.containsKey("uri")) {
            message1.setData(param1Bundle.getString("type"), (Uri)param1Bundle.getParcelable("uri"));
            return message1;
          } 
        } 
      } catch (ClassCastException classCastException) {
        return null;
      } 
      return message;
    }
    
    static List<Message> getMessagesFromBundleArray(Parcelable[] param1ArrayOfParcelable) {
      ArrayList<Message> arrayList = new ArrayList(param1ArrayOfParcelable.length);
      for (int i = 0; i < param1ArrayOfParcelable.length; i++) {
        if (param1ArrayOfParcelable[i] instanceof Bundle) {
          Message message = getMessageFromBundle((Bundle)param1ArrayOfParcelable[i]);
          if (message != null)
            arrayList.add(message); 
        } 
      } 
      return arrayList;
    }
    
    private Bundle toBundle() {
      Bundle bundle = new Bundle();
      if (this.mText != null)
        bundle.putCharSequence("text", this.mText); 
      bundle.putLong("time", this.mTimestamp);
      if (this.mSender != null)
        bundle.putCharSequence("sender", this.mSender); 
      if (this.mDataMimeType != null)
        bundle.putString("type", this.mDataMimeType); 
      if (this.mDataUri != null)
        bundle.putParcelable("uri", (Parcelable)this.mDataUri); 
      return bundle;
    }
    
    public String getDataMimeType() {
      return this.mDataMimeType;
    }
    
    public Uri getDataUri() {
      return this.mDataUri;
    }
    
    public CharSequence getSender() {
      return this.mSender;
    }
    
    public CharSequence getText() {
      return this.mText;
    }
    
    public long getTimestamp() {
      return this.mTimestamp;
    }
    
    public Message setData(String param1String, Uri param1Uri) {
      this.mDataMimeType = param1String;
      this.mDataUri = param1Uri;
      return this;
    }
  }
  
  static interface NotificationCompatImpl {
    Notification build(NotificationCompat.Builder param1Builder, NotificationCompat.BuilderExtender param1BuilderExtender);
    
    NotificationCompat.Action getAction(Notification param1Notification, int param1Int);
    
    int getActionCount(Notification param1Notification);
    
    NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> param1ArrayList);
    
    Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation param1UnreadConversation);
    
    String getCategory(Notification param1Notification);
    
    Bundle getExtras(Notification param1Notification);
    
    String getGroup(Notification param1Notification);
    
    boolean getLocalOnly(Notification param1Notification);
    
    ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] param1ArrayOfAction);
    
    String getSortKey(Notification param1Notification);
    
    NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle param1Bundle, NotificationCompatBase.UnreadConversation.Factory param1Factory, RemoteInputCompatBase.RemoteInput.Factory param1Factory1);
    
    boolean isGroupSummary(Notification param1Notification);
  }
  
  static class NotificationCompatImplApi20 extends NotificationCompatImplKitKat {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationCompat.BuilderExtender param1BuilderExtender) {
      NotificationCompatApi20.Builder builder = new NotificationCompatApi20.Builder(param1Builder.mContext, param1Builder.mNotification, param1Builder.resolveTitle(), param1Builder.resolveText(), param1Builder.mContentInfo, param1Builder.mTickerView, param1Builder.mNumber, param1Builder.mContentIntent, param1Builder.mFullScreenIntent, param1Builder.mLargeIcon, param1Builder.mProgressMax, param1Builder.mProgress, param1Builder.mProgressIndeterminate, param1Builder.mShowWhen, param1Builder.mUseChronometer, param1Builder.mPriority, param1Builder.mSubText, param1Builder.mLocalOnly, param1Builder.mPeople, param1Builder.mExtras, param1Builder.mGroupKey, param1Builder.mGroupSummary, param1Builder.mSortKey, param1Builder.mContentView, param1Builder.mBigContentView);
      NotificationCompat.addActionsToBuilder(builder, param1Builder.mActions);
      NotificationCompat.addStyleToBuilderJellybean(builder, param1Builder.mStyle);
      Notification notification = param1BuilderExtender.build(param1Builder, builder);
      if (param1Builder.mStyle != null)
        param1Builder.mStyle.addCompatExtras(getExtras(notification)); 
      return notification;
    }
    
    public NotificationCompat.Action getAction(Notification param1Notification, int param1Int) {
      return (NotificationCompat.Action)NotificationCompatApi20.getAction(param1Notification, param1Int, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> param1ArrayList) {
      return (NotificationCompat.Action[])NotificationCompatApi20.getActionsFromParcelableArrayList(param1ArrayList, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public String getGroup(Notification param1Notification) {
      return NotificationCompatApi20.getGroup(param1Notification);
    }
    
    public boolean getLocalOnly(Notification param1Notification) {
      return NotificationCompatApi20.getLocalOnly(param1Notification);
    }
    
    public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] param1ArrayOfAction) {
      return NotificationCompatApi20.getParcelableArrayListForActions((NotificationCompatBase.Action[])param1ArrayOfAction);
    }
    
    public String getSortKey(Notification param1Notification) {
      return NotificationCompatApi20.getSortKey(param1Notification);
    }
    
    public boolean isGroupSummary(Notification param1Notification) {
      return NotificationCompatApi20.isGroupSummary(param1Notification);
    }
  }
  
  static class NotificationCompatImplApi21 extends NotificationCompatImplApi20 {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationCompat.BuilderExtender param1BuilderExtender) {
      NotificationCompatApi21.Builder builder = new NotificationCompatApi21.Builder(param1Builder.mContext, param1Builder.mNotification, param1Builder.resolveTitle(), param1Builder.resolveText(), param1Builder.mContentInfo, param1Builder.mTickerView, param1Builder.mNumber, param1Builder.mContentIntent, param1Builder.mFullScreenIntent, param1Builder.mLargeIcon, param1Builder.mProgressMax, param1Builder.mProgress, param1Builder.mProgressIndeterminate, param1Builder.mShowWhen, param1Builder.mUseChronometer, param1Builder.mPriority, param1Builder.mSubText, param1Builder.mLocalOnly, param1Builder.mCategory, param1Builder.mPeople, param1Builder.mExtras, param1Builder.mColor, param1Builder.mVisibility, param1Builder.mPublicVersion, param1Builder.mGroupKey, param1Builder.mGroupSummary, param1Builder.mSortKey, param1Builder.mContentView, param1Builder.mBigContentView, param1Builder.mHeadsUpContentView);
      NotificationCompat.addActionsToBuilder(builder, param1Builder.mActions);
      NotificationCompat.addStyleToBuilderJellybean(builder, param1Builder.mStyle);
      Notification notification = param1BuilderExtender.build(param1Builder, builder);
      if (param1Builder.mStyle != null)
        param1Builder.mStyle.addCompatExtras(getExtras(notification)); 
      return notification;
    }
    
    public Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation param1UnreadConversation) {
      return NotificationCompatApi21.getBundleForUnreadConversation(param1UnreadConversation);
    }
    
    public String getCategory(Notification param1Notification) {
      return NotificationCompatApi21.getCategory(param1Notification);
    }
    
    public NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle param1Bundle, NotificationCompatBase.UnreadConversation.Factory param1Factory, RemoteInputCompatBase.RemoteInput.Factory param1Factory1) {
      return NotificationCompatApi21.getUnreadConversationFromBundle(param1Bundle, param1Factory, param1Factory1);
    }
  }
  
  static class NotificationCompatImplApi24 extends NotificationCompatImplApi21 {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationCompat.BuilderExtender param1BuilderExtender) {
      NotificationCompatApi24.Builder builder = new NotificationCompatApi24.Builder(param1Builder.mContext, param1Builder.mNotification, param1Builder.mContentTitle, param1Builder.mContentText, param1Builder.mContentInfo, param1Builder.mTickerView, param1Builder.mNumber, param1Builder.mContentIntent, param1Builder.mFullScreenIntent, param1Builder.mLargeIcon, param1Builder.mProgressMax, param1Builder.mProgress, param1Builder.mProgressIndeterminate, param1Builder.mShowWhen, param1Builder.mUseChronometer, param1Builder.mPriority, param1Builder.mSubText, param1Builder.mLocalOnly, param1Builder.mCategory, param1Builder.mPeople, param1Builder.mExtras, param1Builder.mColor, param1Builder.mVisibility, param1Builder.mPublicVersion, param1Builder.mGroupKey, param1Builder.mGroupSummary, param1Builder.mSortKey, param1Builder.mRemoteInputHistory, param1Builder.mContentView, param1Builder.mBigContentView, param1Builder.mHeadsUpContentView);
      NotificationCompat.addActionsToBuilder(builder, param1Builder.mActions);
      NotificationCompat.addStyleToBuilderApi24(builder, param1Builder.mStyle);
      Notification notification = param1BuilderExtender.build(param1Builder, builder);
      if (param1Builder.mStyle != null)
        param1Builder.mStyle.addCompatExtras(getExtras(notification)); 
      return notification;
    }
  }
  
  static class NotificationCompatImplBase implements NotificationCompatImpl {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationCompat.BuilderExtender param1BuilderExtender) {
      Notification notification = NotificationCompatBase.add(param1Builder.mNotification, param1Builder.mContext, param1Builder.resolveTitle(), param1Builder.resolveText(), param1Builder.mContentIntent, param1Builder.mFullScreenIntent);
      if (param1Builder.mPriority > 0)
        notification.flags |= 0x80; 
      if (param1Builder.mContentView != null)
        notification.contentView = param1Builder.mContentView; 
      return notification;
    }
    
    public NotificationCompat.Action getAction(Notification param1Notification, int param1Int) {
      return null;
    }
    
    public int getActionCount(Notification param1Notification) {
      return 0;
    }
    
    public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> param1ArrayList) {
      return null;
    }
    
    public Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation param1UnreadConversation) {
      return null;
    }
    
    public String getCategory(Notification param1Notification) {
      return null;
    }
    
    public Bundle getExtras(Notification param1Notification) {
      return null;
    }
    
    public String getGroup(Notification param1Notification) {
      return null;
    }
    
    public boolean getLocalOnly(Notification param1Notification) {
      return false;
    }
    
    public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] param1ArrayOfAction) {
      return null;
    }
    
    public String getSortKey(Notification param1Notification) {
      return null;
    }
    
    public NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle param1Bundle, NotificationCompatBase.UnreadConversation.Factory param1Factory, RemoteInputCompatBase.RemoteInput.Factory param1Factory1) {
      return null;
    }
    
    public boolean isGroupSummary(Notification param1Notification) {
      return false;
    }
  }
  
  static class NotificationCompatImplHoneycomb extends NotificationCompatImplBase {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationCompat.BuilderExtender param1BuilderExtender) {
      Notification notification = NotificationCompatHoneycomb.add(param1Builder.mContext, param1Builder.mNotification, param1Builder.resolveTitle(), param1Builder.resolveText(), param1Builder.mContentInfo, param1Builder.mTickerView, param1Builder.mNumber, param1Builder.mContentIntent, param1Builder.mFullScreenIntent, param1Builder.mLargeIcon);
      if (param1Builder.mContentView != null)
        notification.contentView = param1Builder.mContentView; 
      return notification;
    }
  }
  
  static class NotificationCompatImplIceCreamSandwich extends NotificationCompatImplBase {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationCompat.BuilderExtender param1BuilderExtender) {
      return param1BuilderExtender.build(param1Builder, new NotificationCompatIceCreamSandwich.Builder(param1Builder.mContext, param1Builder.mNotification, param1Builder.resolveTitle(), param1Builder.resolveText(), param1Builder.mContentInfo, param1Builder.mTickerView, param1Builder.mNumber, param1Builder.mContentIntent, param1Builder.mFullScreenIntent, param1Builder.mLargeIcon, param1Builder.mProgressMax, param1Builder.mProgress, param1Builder.mProgressIndeterminate));
    }
  }
  
  static class NotificationCompatImplJellybean extends NotificationCompatImplBase {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationCompat.BuilderExtender param1BuilderExtender) {
      NotificationCompatJellybean.Builder builder = new NotificationCompatJellybean.Builder(param1Builder.mContext, param1Builder.mNotification, param1Builder.resolveTitle(), param1Builder.resolveText(), param1Builder.mContentInfo, param1Builder.mTickerView, param1Builder.mNumber, param1Builder.mContentIntent, param1Builder.mFullScreenIntent, param1Builder.mLargeIcon, param1Builder.mProgressMax, param1Builder.mProgress, param1Builder.mProgressIndeterminate, param1Builder.mUseChronometer, param1Builder.mPriority, param1Builder.mSubText, param1Builder.mLocalOnly, param1Builder.mExtras, param1Builder.mGroupKey, param1Builder.mGroupSummary, param1Builder.mSortKey, param1Builder.mContentView, param1Builder.mBigContentView);
      NotificationCompat.addActionsToBuilder(builder, param1Builder.mActions);
      NotificationCompat.addStyleToBuilderJellybean(builder, param1Builder.mStyle);
      Notification notification = param1BuilderExtender.build(param1Builder, builder);
      if (param1Builder.mStyle != null) {
        Bundle bundle = getExtras(notification);
        if (bundle != null)
          param1Builder.mStyle.addCompatExtras(bundle); 
      } 
      return notification;
    }
    
    public NotificationCompat.Action getAction(Notification param1Notification, int param1Int) {
      return (NotificationCompat.Action)NotificationCompatJellybean.getAction(param1Notification, param1Int, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public int getActionCount(Notification param1Notification) {
      return NotificationCompatJellybean.getActionCount(param1Notification);
    }
    
    public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> param1ArrayList) {
      return (NotificationCompat.Action[])NotificationCompatJellybean.getActionsFromParcelableArrayList(param1ArrayList, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public Bundle getExtras(Notification param1Notification) {
      return NotificationCompatJellybean.getExtras(param1Notification);
    }
    
    public String getGroup(Notification param1Notification) {
      return NotificationCompatJellybean.getGroup(param1Notification);
    }
    
    public boolean getLocalOnly(Notification param1Notification) {
      return NotificationCompatJellybean.getLocalOnly(param1Notification);
    }
    
    public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] param1ArrayOfAction) {
      return NotificationCompatJellybean.getParcelableArrayListForActions((NotificationCompatBase.Action[])param1ArrayOfAction);
    }
    
    public String getSortKey(Notification param1Notification) {
      return NotificationCompatJellybean.getSortKey(param1Notification);
    }
    
    public boolean isGroupSummary(Notification param1Notification) {
      return NotificationCompatJellybean.isGroupSummary(param1Notification);
    }
  }
  
  static class NotificationCompatImplKitKat extends NotificationCompatImplJellybean {
    public Notification build(NotificationCompat.Builder param1Builder, NotificationCompat.BuilderExtender param1BuilderExtender) {
      NotificationCompatKitKat.Builder builder = new NotificationCompatKitKat.Builder(param1Builder.mContext, param1Builder.mNotification, param1Builder.resolveTitle(), param1Builder.resolveText(), param1Builder.mContentInfo, param1Builder.mTickerView, param1Builder.mNumber, param1Builder.mContentIntent, param1Builder.mFullScreenIntent, param1Builder.mLargeIcon, param1Builder.mProgressMax, param1Builder.mProgress, param1Builder.mProgressIndeterminate, param1Builder.mShowWhen, param1Builder.mUseChronometer, param1Builder.mPriority, param1Builder.mSubText, param1Builder.mLocalOnly, param1Builder.mPeople, param1Builder.mExtras, param1Builder.mGroupKey, param1Builder.mGroupSummary, param1Builder.mSortKey, param1Builder.mContentView, param1Builder.mBigContentView);
      NotificationCompat.addActionsToBuilder(builder, param1Builder.mActions);
      NotificationCompat.addStyleToBuilderJellybean(builder, param1Builder.mStyle);
      return param1BuilderExtender.build(param1Builder, builder);
    }
    
    public NotificationCompat.Action getAction(Notification param1Notification, int param1Int) {
      return (NotificationCompat.Action)NotificationCompatKitKat.getAction(param1Notification, param1Int, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public int getActionCount(Notification param1Notification) {
      return NotificationCompatKitKat.getActionCount(param1Notification);
    }
    
    public Bundle getExtras(Notification param1Notification) {
      return NotificationCompatKitKat.getExtras(param1Notification);
    }
    
    public String getGroup(Notification param1Notification) {
      return NotificationCompatKitKat.getGroup(param1Notification);
    }
    
    public boolean getLocalOnly(Notification param1Notification) {
      return NotificationCompatKitKat.getLocalOnly(param1Notification);
    }
    
    public String getSortKey(Notification param1Notification) {
      return NotificationCompatKitKat.getSortKey(param1Notification);
    }
    
    public boolean isGroupSummary(Notification param1Notification) {
      return NotificationCompatKitKat.isGroupSummary(param1Notification);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NotificationVisibility {}
  
  public static abstract class Style {
    CharSequence mBigContentTitle;
    
    NotificationCompat.Builder mBuilder;
    
    CharSequence mSummaryText;
    
    boolean mSummaryTextSet = false;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addCompatExtras(Bundle param1Bundle) {}
    
    public Notification build() {
      Notification notification = null;
      if (this.mBuilder != null)
        notification = this.mBuilder.build(); 
      return notification;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void restoreFromCompatExtras(Bundle param1Bundle) {}
    
    public void setBuilder(NotificationCompat.Builder param1Builder) {
      if (this.mBuilder != param1Builder) {
        this.mBuilder = param1Builder;
        if (this.mBuilder != null)
          this.mBuilder.setStyle(this); 
      } 
    }
  }
  
  public static final class WearableExtender implements Extender {
    private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
    
    private static final int DEFAULT_FLAGS = 1;
    
    private static final int DEFAULT_GRAVITY = 80;
    
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    
    private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
    
    private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
    
    private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
    
    private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
    
    private static final int FLAG_HINT_HIDE_ICON = 2;
    
    private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
    
    private static final int FLAG_START_SCROLL_BOTTOM = 8;
    
    private static final String KEY_ACTIONS = "actions";
    
    private static final String KEY_BACKGROUND = "background";
    
    private static final String KEY_BRIDGE_TAG = "bridgeTag";
    
    private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
    
    private static final String KEY_CONTENT_ICON = "contentIcon";
    
    private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
    
    private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
    
    private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
    
    private static final String KEY_DISMISSAL_ID = "dismissalId";
    
    private static final String KEY_DISPLAY_INTENT = "displayIntent";
    
    private static final String KEY_FLAGS = "flags";
    
    private static final String KEY_GRAVITY = "gravity";
    
    private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
    
    private static final String KEY_PAGES = "pages";
    
    public static final int SCREEN_TIMEOUT_LONG = -1;
    
    public static final int SCREEN_TIMEOUT_SHORT = 0;
    
    public static final int SIZE_DEFAULT = 0;
    
    public static final int SIZE_FULL_SCREEN = 5;
    
    public static final int SIZE_LARGE = 4;
    
    public static final int SIZE_MEDIUM = 3;
    
    public static final int SIZE_SMALL = 2;
    
    public static final int SIZE_XSMALL = 1;
    
    public static final int UNSET_ACTION_INDEX = -1;
    
    private ArrayList<NotificationCompat.Action> mActions = new ArrayList<NotificationCompat.Action>();
    
    private Bitmap mBackground;
    
    private String mBridgeTag;
    
    private int mContentActionIndex = -1;
    
    private int mContentIcon;
    
    private int mContentIconGravity = 8388613;
    
    private int mCustomContentHeight;
    
    private int mCustomSizePreset = 0;
    
    private String mDismissalId;
    
    private PendingIntent mDisplayIntent;
    
    private int mFlags = 1;
    
    private int mGravity = 80;
    
    private int mHintScreenTimeout;
    
    private ArrayList<Notification> mPages = new ArrayList<Notification>();
    
    public WearableExtender() {}
    
    public WearableExtender(Notification param1Notification) {
      Bundle bundle = NotificationCompat.getExtras(param1Notification);
      if (bundle != null) {
        bundle = bundle.getBundle("android.wearable.EXTENSIONS");
      } else {
        bundle = null;
      } 
      if (bundle != null) {
        NotificationCompat.Action[] arrayOfAction = NotificationCompat.IMPL.getActionsFromParcelableArrayList(bundle.getParcelableArrayList("actions"));
        if (arrayOfAction != null)
          Collections.addAll(this.mActions, arrayOfAction); 
        this.mFlags = bundle.getInt("flags", 1);
        this.mDisplayIntent = (PendingIntent)bundle.getParcelable("displayIntent");
        Notification[] arrayOfNotification = NotificationCompat.getNotificationArrayFromBundle(bundle, "pages");
        if (arrayOfNotification != null)
          Collections.addAll(this.mPages, arrayOfNotification); 
        this.mBackground = (Bitmap)bundle.getParcelable("background");
        this.mContentIcon = bundle.getInt("contentIcon");
        this.mContentIconGravity = bundle.getInt("contentIconGravity", 8388613);
        this.mContentActionIndex = bundle.getInt("contentActionIndex", -1);
        this.mCustomSizePreset = bundle.getInt("customSizePreset", 0);
        this.mCustomContentHeight = bundle.getInt("customContentHeight");
        this.mGravity = bundle.getInt("gravity", 80);
        this.mHintScreenTimeout = bundle.getInt("hintScreenTimeout");
        this.mDismissalId = bundle.getString("dismissalId");
        this.mBridgeTag = bundle.getString("bridgeTag");
      } 
    }
    
    private void setFlag(int param1Int, boolean param1Boolean) {
      if (param1Boolean) {
        this.mFlags |= param1Int;
        return;
      } 
      this.mFlags &= param1Int ^ 0xFFFFFFFF;
    }
    
    public WearableExtender addAction(NotificationCompat.Action param1Action) {
      this.mActions.add(param1Action);
      return this;
    }
    
    public WearableExtender addActions(List<NotificationCompat.Action> param1List) {
      this.mActions.addAll(param1List);
      return this;
    }
    
    public WearableExtender addPage(Notification param1Notification) {
      this.mPages.add(param1Notification);
      return this;
    }
    
    public WearableExtender addPages(List<Notification> param1List) {
      this.mPages.addAll(param1List);
      return this;
    }
    
    public WearableExtender clearActions() {
      this.mActions.clear();
      return this;
    }
    
    public WearableExtender clearPages() {
      this.mPages.clear();
      return this;
    }
    
    public WearableExtender clone() {
      WearableExtender wearableExtender = new WearableExtender();
      wearableExtender.mActions = new ArrayList<NotificationCompat.Action>(this.mActions);
      wearableExtender.mFlags = this.mFlags;
      wearableExtender.mDisplayIntent = this.mDisplayIntent;
      wearableExtender.mPages = new ArrayList<Notification>(this.mPages);
      wearableExtender.mBackground = this.mBackground;
      wearableExtender.mContentIcon = this.mContentIcon;
      wearableExtender.mContentIconGravity = this.mContentIconGravity;
      wearableExtender.mContentActionIndex = this.mContentActionIndex;
      wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
      wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
      wearableExtender.mGravity = this.mGravity;
      wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
      wearableExtender.mDismissalId = this.mDismissalId;
      wearableExtender.mBridgeTag = this.mBridgeTag;
      return wearableExtender;
    }
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder param1Builder) {
      Bundle bundle = new Bundle();
      if (!this.mActions.isEmpty())
        bundle.putParcelableArrayList("actions", NotificationCompat.IMPL.getParcelableArrayListForActions(this.mActions.<NotificationCompat.Action>toArray(new NotificationCompat.Action[this.mActions.size()]))); 
      if (this.mFlags != 1)
        bundle.putInt("flags", this.mFlags); 
      if (this.mDisplayIntent != null)
        bundle.putParcelable("displayIntent", (Parcelable)this.mDisplayIntent); 
      if (!this.mPages.isEmpty())
        bundle.putParcelableArray("pages", (Parcelable[])this.mPages.toArray((Object[])new Notification[this.mPages.size()])); 
      if (this.mBackground != null)
        bundle.putParcelable("background", (Parcelable)this.mBackground); 
      if (this.mContentIcon != 0)
        bundle.putInt("contentIcon", this.mContentIcon); 
      if (this.mContentIconGravity != 8388613)
        bundle.putInt("contentIconGravity", this.mContentIconGravity); 
      if (this.mContentActionIndex != -1)
        bundle.putInt("contentActionIndex", this.mContentActionIndex); 
      if (this.mCustomSizePreset != 0)
        bundle.putInt("customSizePreset", this.mCustomSizePreset); 
      if (this.mCustomContentHeight != 0)
        bundle.putInt("customContentHeight", this.mCustomContentHeight); 
      if (this.mGravity != 80)
        bundle.putInt("gravity", this.mGravity); 
      if (this.mHintScreenTimeout != 0)
        bundle.putInt("hintScreenTimeout", this.mHintScreenTimeout); 
      if (this.mDismissalId != null)
        bundle.putString("dismissalId", this.mDismissalId); 
      if (this.mBridgeTag != null)
        bundle.putString("bridgeTag", this.mBridgeTag); 
      param1Builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
      return param1Builder;
    }
    
    public List<NotificationCompat.Action> getActions() {
      return this.mActions;
    }
    
    public Bitmap getBackground() {
      return this.mBackground;
    }
    
    public String getBridgeTag() {
      return this.mBridgeTag;
    }
    
    public int getContentAction() {
      return this.mContentActionIndex;
    }
    
    public int getContentIcon() {
      return this.mContentIcon;
    }
    
    public int getContentIconGravity() {
      return this.mContentIconGravity;
    }
    
    public boolean getContentIntentAvailableOffline() {
      return ((this.mFlags & 0x1) != 0);
    }
    
    public int getCustomContentHeight() {
      return this.mCustomContentHeight;
    }
    
    public int getCustomSizePreset() {
      return this.mCustomSizePreset;
    }
    
    public String getDismissalId() {
      return this.mDismissalId;
    }
    
    public PendingIntent getDisplayIntent() {
      return this.mDisplayIntent;
    }
    
    public int getGravity() {
      return this.mGravity;
    }
    
    public boolean getHintAmbientBigPicture() {
      return ((this.mFlags & 0x20) != 0);
    }
    
    public boolean getHintAvoidBackgroundClipping() {
      return ((this.mFlags & 0x10) != 0);
    }
    
    public boolean getHintContentIntentLaunchesActivity() {
      return ((this.mFlags & 0x40) != 0);
    }
    
    public boolean getHintHideIcon() {
      return ((this.mFlags & 0x2) != 0);
    }
    
    public int getHintScreenTimeout() {
      return this.mHintScreenTimeout;
    }
    
    public boolean getHintShowBackgroundOnly() {
      return ((this.mFlags & 0x4) != 0);
    }
    
    public List<Notification> getPages() {
      return this.mPages;
    }
    
    public boolean getStartScrollBottom() {
      return ((this.mFlags & 0x8) != 0);
    }
    
    public WearableExtender setBackground(Bitmap param1Bitmap) {
      this.mBackground = param1Bitmap;
      return this;
    }
    
    public WearableExtender setBridgeTag(String param1String) {
      this.mBridgeTag = param1String;
      return this;
    }
    
    public WearableExtender setContentAction(int param1Int) {
      this.mContentActionIndex = param1Int;
      return this;
    }
    
    public WearableExtender setContentIcon(int param1Int) {
      this.mContentIcon = param1Int;
      return this;
    }
    
    public WearableExtender setContentIconGravity(int param1Int) {
      this.mContentIconGravity = param1Int;
      return this;
    }
    
    public WearableExtender setContentIntentAvailableOffline(boolean param1Boolean) {
      setFlag(1, param1Boolean);
      return this;
    }
    
    public WearableExtender setCustomContentHeight(int param1Int) {
      this.mCustomContentHeight = param1Int;
      return this;
    }
    
    public WearableExtender setCustomSizePreset(int param1Int) {
      this.mCustomSizePreset = param1Int;
      return this;
    }
    
    public WearableExtender setDismissalId(String param1String) {
      this.mDismissalId = param1String;
      return this;
    }
    
    public WearableExtender setDisplayIntent(PendingIntent param1PendingIntent) {
      this.mDisplayIntent = param1PendingIntent;
      return this;
    }
    
    public WearableExtender setGravity(int param1Int) {
      this.mGravity = param1Int;
      return this;
    }
    
    public WearableExtender setHintAmbientBigPicture(boolean param1Boolean) {
      setFlag(32, param1Boolean);
      return this;
    }
    
    public WearableExtender setHintAvoidBackgroundClipping(boolean param1Boolean) {
      setFlag(16, param1Boolean);
      return this;
    }
    
    public WearableExtender setHintContentIntentLaunchesActivity(boolean param1Boolean) {
      setFlag(64, param1Boolean);
      return this;
    }
    
    public WearableExtender setHintHideIcon(boolean param1Boolean) {
      setFlag(2, param1Boolean);
      return this;
    }
    
    public WearableExtender setHintScreenTimeout(int param1Int) {
      this.mHintScreenTimeout = param1Int;
      return this;
    }
    
    public WearableExtender setHintShowBackgroundOnly(boolean param1Boolean) {
      setFlag(4, param1Boolean);
      return this;
    }
    
    public WearableExtender setStartScrollBottom(boolean param1Boolean) {
      setFlag(8, param1Boolean);
      return this;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\NotificationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */