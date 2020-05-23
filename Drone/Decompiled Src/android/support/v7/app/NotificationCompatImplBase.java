package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompatBase;
import android.support.v7.appcompat.R;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@TargetApi(9)
@RequiresApi(9)
class NotificationCompatImplBase {
  private static final int MAX_ACTION_BUTTONS = 3;
  
  static final int MAX_MEDIA_BUTTONS = 5;
  
  static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
  
  public static RemoteViews applyStandardTemplate(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt1, int paramInt2, Bitmap paramBitmap, CharSequence paramCharSequence4, boolean paramBoolean1, long paramLong, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean2) {
    Bitmap bitmap;
    Resources resources = paramContext.getResources();
    RemoteViews remoteViews = new RemoteViews(paramContext.getPackageName(), paramInt5);
    boolean bool = false;
    paramInt5 = 0;
    if (paramInt3 < -1) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    } 
    if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 21)
      if (paramInt3 != 0) {
        remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
        remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
      } else {
        remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
        remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
      }  
    if (paramBitmap != null) {
      if (Build.VERSION.SDK_INT >= 16) {
        remoteViews.setViewVisibility(R.id.icon, 0);
        remoteViews.setImageViewBitmap(R.id.icon, paramBitmap);
      } else {
        remoteViews.setViewVisibility(R.id.icon, 8);
      } 
      if (paramInt2 != 0) {
        paramInt3 = resources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
        int i = resources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding);
        if (Build.VERSION.SDK_INT >= 21) {
          bitmap = createIconWithBackground(paramContext, paramInt2, paramInt3, paramInt3 - i * 2, paramInt4);
          remoteViews.setImageViewBitmap(R.id.right_icon, bitmap);
        } else {
          remoteViews.setImageViewBitmap(R.id.right_icon, createColoredBitmap((Context)bitmap, paramInt2, -1));
        } 
        remoteViews.setViewVisibility(R.id.right_icon, 0);
      } 
    } else if (paramInt2 != 0) {
      remoteViews.setViewVisibility(R.id.icon, 0);
      if (Build.VERSION.SDK_INT >= 21) {
        bitmap = createIconWithBackground((Context)bitmap, paramInt2, resources.getDimensionPixelSize(R.dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R.dimen.notification_big_circle_margin), resources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large), paramInt4);
        remoteViews.setImageViewBitmap(R.id.icon, bitmap);
      } else {
        remoteViews.setImageViewBitmap(R.id.icon, createColoredBitmap((Context)bitmap, paramInt2, -1));
      } 
    } 
    if (paramCharSequence1 != null)
      remoteViews.setTextViewText(R.id.title, paramCharSequence1); 
    paramInt2 = bool;
    if (paramCharSequence2 != null) {
      remoteViews.setTextViewText(R.id.text, paramCharSequence2);
      paramInt2 = 1;
    } 
    if (Build.VERSION.SDK_INT < 21 && paramBitmap != null) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    } 
    if (paramCharSequence3 != null) {
      remoteViews.setTextViewText(R.id.info, paramCharSequence3);
      remoteViews.setViewVisibility(R.id.info, 0);
      paramInt2 = 1;
      paramInt1 = 1;
    } else if (paramInt1 > 0) {
      if (paramInt1 > resources.getInteger(R.integer.status_bar_notification_info_maxnum)) {
        remoteViews.setTextViewText(R.id.info, resources.getString(R.string.status_bar_notification_info_overflow));
      } else {
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        remoteViews.setTextViewText(R.id.info, numberFormat.format(paramInt1));
      } 
      remoteViews.setViewVisibility(R.id.info, 0);
      paramInt2 = 1;
      paramInt1 = 1;
    } else {
      remoteViews.setViewVisibility(R.id.info, 8);
      paramInt1 = paramInt3;
    } 
    paramInt3 = paramInt5;
    if (paramCharSequence4 != null) {
      paramInt3 = paramInt5;
      if (Build.VERSION.SDK_INT >= 16) {
        remoteViews.setTextViewText(R.id.text, paramCharSequence4);
        if (paramCharSequence2 != null) {
          remoteViews.setTextViewText(R.id.text2, paramCharSequence2);
          remoteViews.setViewVisibility(R.id.text2, 0);
          paramInt3 = 1;
        } else {
          remoteViews.setViewVisibility(R.id.text2, 8);
          paramInt3 = paramInt5;
        } 
      } 
    } 
    if (paramInt3 != 0 && Build.VERSION.SDK_INT >= 16) {
      if (paramBoolean2) {
        float f = resources.getDimensionPixelSize(R.dimen.notification_subtext_size);
        remoteViews.setTextViewTextSize(R.id.text, 0, f);
      } 
      remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
    } 
    if (paramLong != 0L) {
      if (paramBoolean1 && Build.VERSION.SDK_INT >= 16) {
        remoteViews.setViewVisibility(R.id.chronometer, 0);
        remoteViews.setLong(R.id.chronometer, "setBase", SystemClock.elapsedRealtime() - System.currentTimeMillis() + paramLong);
        remoteViews.setBoolean(R.id.chronometer, "setStarted", true);
      } else {
        remoteViews.setViewVisibility(R.id.time, 0);
        remoteViews.setLong(R.id.time, "setTime", paramLong);
      } 
      paramInt1 = 1;
    } 
    paramInt3 = R.id.right_side;
    if (paramInt1 != 0) {
      paramInt1 = 0;
    } else {
      paramInt1 = 8;
    } 
    remoteViews.setViewVisibility(paramInt3, paramInt1);
    paramInt3 = R.id.line3;
    if (paramInt2 != 0) {
      paramInt1 = 0;
      remoteViews.setViewVisibility(paramInt3, paramInt1);
      return remoteViews;
    } 
    paramInt1 = 8;
    remoteViews.setViewVisibility(paramInt3, paramInt1);
    return remoteViews;
  }
  
  public static RemoteViews applyStandardTemplateWithActions(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt1, int paramInt2, Bitmap paramBitmap, CharSequence paramCharSequence4, boolean paramBoolean1, long paramLong, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean2, ArrayList<NotificationCompat.Action> paramArrayList) {
    RemoteViews remoteViews = applyStandardTemplate(paramContext, paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt1, paramInt2, paramBitmap, paramCharSequence4, paramBoolean1, paramLong, paramInt3, paramInt4, paramInt5, paramBoolean2);
    remoteViews.removeAllViews(R.id.actions);
    paramInt1 = 0;
    paramInt2 = paramInt1;
    if (paramArrayList != null) {
      paramInt3 = paramArrayList.size();
      paramInt2 = paramInt1;
      if (paramInt3 > 0) {
        paramInt4 = 1;
        paramInt1 = paramInt3;
        if (paramInt3 > 3)
          paramInt1 = 3; 
        paramInt3 = 0;
        while (true) {
          paramInt2 = paramInt4;
          if (paramInt3 < paramInt1) {
            RemoteViews remoteViews1 = generateActionButton(paramContext, paramArrayList.get(paramInt3));
            remoteViews.addView(R.id.actions, remoteViews1);
            paramInt3++;
            continue;
          } 
          break;
        } 
      } 
    } 
    if (paramInt2 != 0) {
      paramInt1 = 0;
      remoteViews.setViewVisibility(R.id.actions, paramInt1);
      remoteViews.setViewVisibility(R.id.action_divider, paramInt1);
      return remoteViews;
    } 
    paramInt1 = 8;
    remoteViews.setViewVisibility(R.id.actions, paramInt1);
    remoteViews.setViewVisibility(R.id.action_divider, paramInt1);
    return remoteViews;
  }
  
  public static void buildIntoRemoteViews(Context paramContext, RemoteViews paramRemoteViews1, RemoteViews paramRemoteViews2) {
    hideNormalContent(paramRemoteViews1);
    paramRemoteViews1.removeAllViews(R.id.notification_main_column);
    paramRemoteViews1.addView(R.id.notification_main_column, paramRemoteViews2.clone());
    paramRemoteViews1.setViewVisibility(R.id.notification_main_column, 0);
    if (Build.VERSION.SDK_INT >= 21)
      paramRemoteViews1.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(paramContext), 0, 0); 
  }
  
  public static int calculateTopPadding(Context paramContext) {
    int i = paramContext.getResources().getDimensionPixelSize(R.dimen.notification_top_pad);
    int j = paramContext.getResources().getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
    float f = (constrain((paramContext.getResources().getConfiguration()).fontScale, 1.0F, 1.3F) - 1.0F) / 0.29999995F;
    return Math.round((1.0F - f) * i + j * f);
  }
  
  public static float constrain(float paramFloat1, float paramFloat2, float paramFloat3) {
    return (paramFloat1 < paramFloat2) ? paramFloat2 : ((paramFloat1 > paramFloat3) ? paramFloat3 : paramFloat1);
  }
  
  private static Bitmap createColoredBitmap(Context paramContext, int paramInt1, int paramInt2) {
    return createColoredBitmap(paramContext, paramInt1, paramInt2, 0);
  }
  
  private static Bitmap createColoredBitmap(Context paramContext, int paramInt1, int paramInt2, int paramInt3) {
    Drawable drawable = paramContext.getResources().getDrawable(paramInt1);
    if (paramInt3 == 0) {
      paramInt1 = drawable.getIntrinsicWidth();
    } else {
      paramInt1 = paramInt3;
    } 
    if (paramInt3 == 0)
      paramInt3 = drawable.getIntrinsicHeight(); 
    Bitmap bitmap = Bitmap.createBitmap(paramInt1, paramInt3, Bitmap.Config.ARGB_8888);
    drawable.setBounds(0, 0, paramInt1, paramInt3);
    if (paramInt2 != 0)
      drawable.mutate().setColorFilter((ColorFilter)new PorterDuffColorFilter(paramInt2, PorterDuff.Mode.SRC_IN)); 
    drawable.draw(new Canvas(bitmap));
    return bitmap;
  }
  
  public static Bitmap createIconWithBackground(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int j = R.drawable.notification_icon_background;
    int i = paramInt4;
    if (paramInt4 == 0)
      i = 0; 
    Bitmap bitmap = createColoredBitmap(paramContext, j, i, paramInt2);
    Canvas canvas = new Canvas(bitmap);
    Drawable drawable = paramContext.getResources().getDrawable(paramInt1).mutate();
    drawable.setFilterBitmap(true);
    paramInt1 = (paramInt2 - paramInt3) / 2;
    drawable.setBounds(paramInt1, paramInt1, paramInt3 + paramInt1, paramInt3 + paramInt1);
    drawable.setColorFilter((ColorFilter)new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
    drawable.draw(canvas);
    return bitmap;
  }
  
  private static RemoteViews generateActionButton(Context paramContext, NotificationCompat.Action paramAction) {
    boolean bool;
    int i;
    if (paramAction.actionIntent == null) {
      bool = true;
    } else {
      bool = false;
    } 
    String str = paramContext.getPackageName();
    if (bool) {
      i = getActionTombstoneLayoutResource();
    } else {
      i = getActionLayoutResource();
    } 
    RemoteViews remoteViews = new RemoteViews(str, i);
    remoteViews.setImageViewBitmap(R.id.action_image, createColoredBitmap(paramContext, paramAction.getIcon(), paramContext.getResources().getColor(R.color.notification_action_color_filter)));
    remoteViews.setTextViewText(R.id.action_text, paramAction.title);
    if (!bool)
      remoteViews.setOnClickPendingIntent(R.id.action_container, paramAction.actionIntent); 
    if (Build.VERSION.SDK_INT >= 15)
      remoteViews.setContentDescription(R.id.action_container, paramAction.title); 
    return remoteViews;
  }
  
  @TargetApi(11)
  @RequiresApi(11)
  private static <T extends NotificationCompatBase.Action> RemoteViews generateContentViewMedia(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt1, Bitmap paramBitmap, CharSequence paramCharSequence4, boolean paramBoolean1, long paramLong, int paramInt2, List<T> paramList, int[] paramArrayOfint, boolean paramBoolean2, PendingIntent paramPendingIntent, boolean paramBoolean3) {
    if (paramBoolean3) {
      i = R.layout.notification_template_media_custom;
    } else {
      i = R.layout.notification_template_media;
    } 
    RemoteViews remoteViews = applyStandardTemplate(paramContext, paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt1, 0, paramBitmap, paramCharSequence4, paramBoolean1, paramLong, paramInt2, 0, i, true);
    int i = paramList.size();
    if (paramArrayOfint == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = Math.min(paramArrayOfint.length, 3);
    } 
    remoteViews.removeAllViews(R.id.media_actions);
    if (paramInt1 > 0)
      for (paramInt2 = 0; paramInt2 < paramInt1; paramInt2++) {
        if (paramInt2 >= i)
          throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i - 1) })); 
        RemoteViews remoteViews1 = generateMediaActionButton(paramContext, (NotificationCompatBase.Action)paramList.get(paramArrayOfint[paramInt2]));
        remoteViews.addView(R.id.media_actions, remoteViews1);
      }  
    if (paramBoolean2) {
      remoteViews.setViewVisibility(R.id.end_padder, 8);
      remoteViews.setViewVisibility(R.id.cancel_action, 0);
      remoteViews.setOnClickPendingIntent(R.id.cancel_action, paramPendingIntent);
      remoteViews.setInt(R.id.cancel_action, "setAlpha", paramContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
      return remoteViews;
    } 
    remoteViews.setViewVisibility(R.id.end_padder, 0);
    remoteViews.setViewVisibility(R.id.cancel_action, 8);
    return remoteViews;
  }
  
  @TargetApi(11)
  @RequiresApi(11)
  private static RemoteViews generateMediaActionButton(Context paramContext, NotificationCompatBase.Action paramAction) {
    boolean bool;
    if (paramAction.getActionIntent() == null) {
      bool = true;
    } else {
      bool = false;
    } 
    RemoteViews remoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.notification_media_action);
    remoteViews.setImageViewResource(R.id.action0, paramAction.getIcon());
    if (!bool)
      remoteViews.setOnClickPendingIntent(R.id.action0, paramAction.getActionIntent()); 
    if (Build.VERSION.SDK_INT >= 15)
      remoteViews.setContentDescription(R.id.action0, paramAction.getTitle()); 
    return remoteViews;
  }
  
  @TargetApi(11)
  @RequiresApi(11)
  public static <T extends NotificationCompatBase.Action> RemoteViews generateMediaBigView(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt1, Bitmap paramBitmap, CharSequence paramCharSequence4, boolean paramBoolean1, long paramLong, int paramInt2, int paramInt3, List<T> paramList, boolean paramBoolean2, PendingIntent paramPendingIntent, boolean paramBoolean3) {
    int i = Math.min(paramList.size(), 5);
    RemoteViews remoteViews = applyStandardTemplate(paramContext, paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt1, 0, paramBitmap, paramCharSequence4, paramBoolean1, paramLong, paramInt2, paramInt3, getBigMediaLayoutResource(paramBoolean3, i), false);
    remoteViews.removeAllViews(R.id.media_actions);
    if (i > 0)
      for (paramInt1 = 0; paramInt1 < i; paramInt1++) {
        RemoteViews remoteViews1 = generateMediaActionButton(paramContext, (NotificationCompatBase.Action)paramList.get(paramInt1));
        remoteViews.addView(R.id.media_actions, remoteViews1);
      }  
    if (paramBoolean2) {
      remoteViews.setViewVisibility(R.id.cancel_action, 0);
      remoteViews.setInt(R.id.cancel_action, "setAlpha", paramContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
      remoteViews.setOnClickPendingIntent(R.id.cancel_action, paramPendingIntent);
      return remoteViews;
    } 
    remoteViews.setViewVisibility(R.id.cancel_action, 8);
    return remoteViews;
  }
  
  private static int getActionLayoutResource() {
    return R.layout.notification_action;
  }
  
  private static int getActionTombstoneLayoutResource() {
    return R.layout.notification_action_tombstone;
  }
  
  @TargetApi(11)
  @RequiresApi(11)
  private static int getBigMediaLayoutResource(boolean paramBoolean, int paramInt) {
    return (paramInt <= 3) ? (paramBoolean ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_narrow) : (paramBoolean ? R.layout.notification_template_big_media_custom : R.layout.notification_template_big_media);
  }
  
  private static void hideNormalContent(RemoteViews paramRemoteViews) {
    paramRemoteViews.setViewVisibility(R.id.title, 8);
    paramRemoteViews.setViewVisibility(R.id.text2, 8);
    paramRemoteViews.setViewVisibility(R.id.text, 8);
  }
  
  @TargetApi(11)
  @RequiresApi(11)
  public static <T extends NotificationCompatBase.Action> RemoteViews overrideContentViewMedia(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt1, Bitmap paramBitmap, CharSequence paramCharSequence4, boolean paramBoolean1, long paramLong, int paramInt2, List<T> paramList, int[] paramArrayOfint, boolean paramBoolean2, PendingIntent paramPendingIntent, boolean paramBoolean3) {
    RemoteViews remoteViews = generateContentViewMedia(paramContext, paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt1, paramBitmap, paramCharSequence4, paramBoolean1, paramLong, paramInt2, paramList, paramArrayOfint, paramBoolean2, paramPendingIntent, paramBoolean3);
    paramNotificationBuilderWithBuilderAccessor.getBuilder().setContent(remoteViews);
    if (paramBoolean2)
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true); 
    return remoteViews;
  }
  
  @TargetApi(16)
  @RequiresApi(16)
  public static <T extends NotificationCompatBase.Action> void overrideMediaBigContentView(Notification paramNotification, Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt1, Bitmap paramBitmap, CharSequence paramCharSequence4, boolean paramBoolean1, long paramLong, int paramInt2, int paramInt3, List<T> paramList, boolean paramBoolean2, PendingIntent paramPendingIntent, boolean paramBoolean3) {
    paramNotification.bigContentView = generateMediaBigView(paramContext, paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt1, paramBitmap, paramCharSequence4, paramBoolean1, paramLong, paramInt2, paramInt3, paramList, paramBoolean2, paramPendingIntent, paramBoolean3);
    if (paramBoolean2)
      paramNotification.flags |= 0x2; 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\app\NotificationCompatImplBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */