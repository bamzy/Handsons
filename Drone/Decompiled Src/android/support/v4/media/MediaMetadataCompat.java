package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

public final class MediaMetadataCompat implements Parcelable {
  public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
  
  static final ArrayMap<String, Integer> METADATA_KEYS_TYPE = new ArrayMap();
  
  public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
  
  public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
  
  public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
  
  public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
  
  public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
  
  public static final String METADATA_KEY_ART = "android.media.metadata.ART";
  
  public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
  
  public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
  
  public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
  
  public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
  
  public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
  
  public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
  
  public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
  
  public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
  
  public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
  
  public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
  
  public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
  
  public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
  
  public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
  
  public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
  
  public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
  
  public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
  
  public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
  
  public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
  
  public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
  
  public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
  
  public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
  
  public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
  
  public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
  
  public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
  
  static final int METADATA_TYPE_BITMAP = 2;
  
  static final int METADATA_TYPE_LONG = 0;
  
  static final int METADATA_TYPE_RATING = 3;
  
  static final int METADATA_TYPE_TEXT = 1;
  
  private static final String[] PREFERRED_BITMAP_ORDER;
  
  private static final String[] PREFERRED_DESCRIPTION_ORDER = new String[] { "android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER" };
  
  private static final String[] PREFERRED_URI_ORDER;
  
  private static final String TAG = "MediaMetadata";
  
  final Bundle mBundle;
  
  private MediaDescriptionCompat mDescription;
  
  private Object mMetadataObj;
  
  static {
    PREFERRED_BITMAP_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART" };
    PREFERRED_URI_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI" };
    CREATOR = new Parcelable.Creator<MediaMetadataCompat>() {
        public MediaMetadataCompat createFromParcel(Parcel param1Parcel) {
          return new MediaMetadataCompat(param1Parcel);
        }
        
        public MediaMetadataCompat[] newArray(int param1Int) {
          return new MediaMetadataCompat[param1Int];
        }
      };
  }
  
  MediaMetadataCompat(Bundle paramBundle) {
    this.mBundle = new Bundle(paramBundle);
  }
  
  MediaMetadataCompat(Parcel paramParcel) {
    this.mBundle = paramParcel.readBundle();
  }
  
  public static MediaMetadataCompat fromMediaMetadata(Object paramObject) {
    if (paramObject == null || Build.VERSION.SDK_INT < 21)
      return null; 
    Parcel parcel = Parcel.obtain();
    MediaMetadataCompatApi21.writeToParcel(paramObject, parcel, 0);
    parcel.setDataPosition(0);
    MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(parcel);
    parcel.recycle();
    mediaMetadataCompat.mMetadataObj = paramObject;
    return mediaMetadataCompat;
  }
  
  public boolean containsKey(String paramString) {
    return this.mBundle.containsKey(paramString);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Bitmap getBitmap(String paramString) {
    try {
      return (Bitmap)this.mBundle.getParcelable(paramString);
    } catch (Exception exception) {
      Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", exception);
      return null;
    } 
  }
  
  public Bundle getBundle() {
    return this.mBundle;
  }
  
  public MediaDescriptionCompat getDescription() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mDescription : Landroid/support/v4/media/MediaDescriptionCompat;
    //   4: ifnull -> 12
    //   7: aload_0
    //   8: getfield mDescription : Landroid/support/v4/media/MediaDescriptionCompat;
    //   11: areturn
    //   12: aload_0
    //   13: ldc 'android.media.metadata.MEDIA_ID'
    //   15: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   18: astore #7
    //   20: iconst_3
    //   21: anewarray java/lang/CharSequence
    //   24: astore #8
    //   26: aconst_null
    //   27: astore #5
    //   29: aconst_null
    //   30: astore #6
    //   32: aload_0
    //   33: ldc 'android.media.metadata.DISPLAY_TITLE'
    //   35: invokevirtual getText : (Ljava/lang/String;)Ljava/lang/CharSequence;
    //   38: astore #4
    //   40: aload #4
    //   42: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   45: ifne -> 298
    //   48: aload #8
    //   50: iconst_0
    //   51: aload #4
    //   53: aastore
    //   54: aload #8
    //   56: iconst_1
    //   57: aload_0
    //   58: ldc 'android.media.metadata.DISPLAY_SUBTITLE'
    //   60: invokevirtual getText : (Ljava/lang/String;)Ljava/lang/CharSequence;
    //   63: aastore
    //   64: aload #8
    //   66: iconst_2
    //   67: aload_0
    //   68: ldc 'android.media.metadata.DISPLAY_DESCRIPTION'
    //   70: invokevirtual getText : (Ljava/lang/String;)Ljava/lang/CharSequence;
    //   73: aastore
    //   74: iconst_0
    //   75: istore_1
    //   76: aload #5
    //   78: astore #4
    //   80: iload_1
    //   81: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_BITMAP_ORDER : [Ljava/lang/String;
    //   84: arraylength
    //   85: if_icmpge -> 104
    //   88: aload_0
    //   89: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_BITMAP_ORDER : [Ljava/lang/String;
    //   92: iload_1
    //   93: aaload
    //   94: invokevirtual getBitmap : (Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   97: astore #4
    //   99: aload #4
    //   101: ifnull -> 357
    //   104: iconst_0
    //   105: istore_1
    //   106: aload #6
    //   108: astore #5
    //   110: iload_1
    //   111: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_URI_ORDER : [Ljava/lang/String;
    //   114: arraylength
    //   115: if_icmpge -> 144
    //   118: aload_0
    //   119: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_URI_ORDER : [Ljava/lang/String;
    //   122: iload_1
    //   123: aaload
    //   124: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   127: astore #5
    //   129: aload #5
    //   131: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   134: ifne -> 364
    //   137: aload #5
    //   139: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   142: astore #5
    //   144: aconst_null
    //   145: astore #6
    //   147: aload_0
    //   148: ldc 'android.media.metadata.MEDIA_URI'
    //   150: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   153: astore #9
    //   155: aload #9
    //   157: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   160: ifne -> 170
    //   163: aload #9
    //   165: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   168: astore #6
    //   170: new android/support/v4/media/MediaDescriptionCompat$Builder
    //   173: dup
    //   174: invokespecial <init> : ()V
    //   177: astore #9
    //   179: aload #9
    //   181: aload #7
    //   183: invokevirtual setMediaId : (Ljava/lang/String;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   186: pop
    //   187: aload #9
    //   189: aload #8
    //   191: iconst_0
    //   192: aaload
    //   193: invokevirtual setTitle : (Ljava/lang/CharSequence;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   196: pop
    //   197: aload #9
    //   199: aload #8
    //   201: iconst_1
    //   202: aaload
    //   203: invokevirtual setSubtitle : (Ljava/lang/CharSequence;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   206: pop
    //   207: aload #9
    //   209: aload #8
    //   211: iconst_2
    //   212: aaload
    //   213: invokevirtual setDescription : (Ljava/lang/CharSequence;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   216: pop
    //   217: aload #9
    //   219: aload #4
    //   221: invokevirtual setIconBitmap : (Landroid/graphics/Bitmap;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   224: pop
    //   225: aload #9
    //   227: aload #5
    //   229: invokevirtual setIconUri : (Landroid/net/Uri;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   232: pop
    //   233: aload #9
    //   235: aload #6
    //   237: invokevirtual setMediaUri : (Landroid/net/Uri;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   240: pop
    //   241: aload_0
    //   242: getfield mBundle : Landroid/os/Bundle;
    //   245: ldc 'android.media.metadata.BT_FOLDER_TYPE'
    //   247: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   250: ifeq -> 284
    //   253: new android/os/Bundle
    //   256: dup
    //   257: invokespecial <init> : ()V
    //   260: astore #4
    //   262: aload #4
    //   264: ldc_w 'android.media.extra.BT_FOLDER_TYPE'
    //   267: aload_0
    //   268: ldc 'android.media.metadata.BT_FOLDER_TYPE'
    //   270: invokevirtual getLong : (Ljava/lang/String;)J
    //   273: invokevirtual putLong : (Ljava/lang/String;J)V
    //   276: aload #9
    //   278: aload #4
    //   280: invokevirtual setExtras : (Landroid/os/Bundle;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   283: pop
    //   284: aload_0
    //   285: aload #9
    //   287: invokevirtual build : ()Landroid/support/v4/media/MediaDescriptionCompat;
    //   290: putfield mDescription : Landroid/support/v4/media/MediaDescriptionCompat;
    //   293: aload_0
    //   294: getfield mDescription : Landroid/support/v4/media/MediaDescriptionCompat;
    //   297: areturn
    //   298: iconst_0
    //   299: istore_2
    //   300: iconst_0
    //   301: istore_1
    //   302: iload_2
    //   303: aload #8
    //   305: arraylength
    //   306: if_icmpge -> 74
    //   309: iload_1
    //   310: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER : [Ljava/lang/String;
    //   313: arraylength
    //   314: if_icmpge -> 74
    //   317: aload_0
    //   318: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER : [Ljava/lang/String;
    //   321: iload_1
    //   322: aaload
    //   323: invokevirtual getText : (Ljava/lang/String;)Ljava/lang/CharSequence;
    //   326: astore #4
    //   328: iload_2
    //   329: istore_3
    //   330: aload #4
    //   332: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   335: ifne -> 348
    //   338: aload #8
    //   340: iload_2
    //   341: aload #4
    //   343: aastore
    //   344: iload_2
    //   345: iconst_1
    //   346: iadd
    //   347: istore_3
    //   348: iload_1
    //   349: iconst_1
    //   350: iadd
    //   351: istore_1
    //   352: iload_3
    //   353: istore_2
    //   354: goto -> 302
    //   357: iload_1
    //   358: iconst_1
    //   359: iadd
    //   360: istore_1
    //   361: goto -> 76
    //   364: iload_1
    //   365: iconst_1
    //   366: iadd
    //   367: istore_1
    //   368: goto -> 106
  }
  
  public long getLong(String paramString) {
    return this.mBundle.getLong(paramString, 0L);
  }
  
  public Object getMediaMetadata() {
    if (this.mMetadataObj != null || Build.VERSION.SDK_INT < 21)
      return this.mMetadataObj; 
    Parcel parcel = Parcel.obtain();
    writeToParcel(parcel, 0);
    parcel.setDataPosition(0);
    this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(parcel);
    parcel.recycle();
    return this.mMetadataObj;
  }
  
  public RatingCompat getRating(String paramString) {
    try {
      return (Build.VERSION.SDK_INT >= 19) ? RatingCompat.fromRating(this.mBundle.getParcelable(paramString)) : (RatingCompat)this.mBundle.getParcelable(paramString);
    } catch (Exception exception) {
      Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", exception);
      return null;
    } 
  }
  
  public String getString(String paramString) {
    CharSequence charSequence = this.mBundle.getCharSequence(paramString);
    return (charSequence != null) ? charSequence.toString() : null;
  }
  
  public CharSequence getText(String paramString) {
    return this.mBundle.getCharSequence(paramString);
  }
  
  public Set<String> keySet() {
    return this.mBundle.keySet();
  }
  
  public int size() {
    return this.mBundle.size();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeBundle(this.mBundle);
  }
  
  static {
    METADATA_KEYS_TYPE.put("android.media.metadata.TITLE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.ARTIST", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DURATION", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.WRITER", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DATE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.YEAR", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.GENRE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.ART", Integer.valueOf(2));
    METADATA_KEYS_TYPE.put("android.media.metadata.ART_URI", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
    METADATA_KEYS_TYPE.put("android.media.metadata.RATING", Integer.valueOf(3));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface BitmapKey {}
  
  public static final class Builder {
    private final Bundle mBundle = new Bundle();
    
    public Builder() {}
    
    public Builder(MediaMetadataCompat param1MediaMetadataCompat) {}
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Builder(MediaMetadataCompat param1MediaMetadataCompat, int param1Int) {
      this(param1MediaMetadataCompat);
      for (String str : this.mBundle.keySet()) {
        Object object = this.mBundle.get(str);
        if (object != null && object instanceof Bitmap) {
          object = object;
          if (object.getHeight() > param1Int || object.getWidth() > param1Int) {
            putBitmap(str, scaleBitmap((Bitmap)object, param1Int));
            continue;
          } 
          if (Build.VERSION.SDK_INT >= 14 && (str.equals("android.media.metadata.ART") || str.equals("android.media.metadata.ALBUM_ART")))
            putBitmap(str, object.copy(object.getConfig(), false)); 
        } 
      } 
    }
    
    private Bitmap scaleBitmap(Bitmap param1Bitmap, int param1Int) {
      float f = param1Int;
      f = Math.min(f / param1Bitmap.getWidth(), f / param1Bitmap.getHeight());
      param1Int = (int)(param1Bitmap.getHeight() * f);
      return Bitmap.createScaledBitmap(param1Bitmap, (int)(param1Bitmap.getWidth() * f), param1Int, true);
    }
    
    public MediaMetadataCompat build() {
      return new MediaMetadataCompat(this.mBundle);
    }
    
    public Builder putBitmap(String param1String, Bitmap param1Bitmap) {
      if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() != 2)
        throw new IllegalArgumentException("The " + param1String + " key cannot be used to put a Bitmap"); 
      this.mBundle.putParcelable(param1String, (Parcelable)param1Bitmap);
      return this;
    }
    
    public Builder putLong(String param1String, long param1Long) {
      if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() != 0)
        throw new IllegalArgumentException("The " + param1String + " key cannot be used to put a long"); 
      this.mBundle.putLong(param1String, param1Long);
      return this;
    }
    
    public Builder putRating(String param1String, RatingCompat param1RatingCompat) {
      if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() != 3)
        throw new IllegalArgumentException("The " + param1String + " key cannot be used to put a Rating"); 
      if (Build.VERSION.SDK_INT >= 19) {
        this.mBundle.putParcelable(param1String, (Parcelable)param1RatingCompat.getRating());
        return this;
      } 
      this.mBundle.putParcelable(param1String, param1RatingCompat);
      return this;
    }
    
    public Builder putString(String param1String1, String param1String2) {
      if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String1) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String1)).intValue() != 1)
        throw new IllegalArgumentException("The " + param1String1 + " key cannot be used to put a String"); 
      this.mBundle.putCharSequence(param1String1, param1String2);
      return this;
    }
    
    public Builder putText(String param1String, CharSequence param1CharSequence) {
      if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() != 1)
        throw new IllegalArgumentException("The " + param1String + " key cannot be used to put a CharSequence"); 
      this.mBundle.putCharSequence(param1String, param1CharSequence);
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface LongKey {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface RatingKey {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface TextKey {}
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\media\MediaMetadataCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */