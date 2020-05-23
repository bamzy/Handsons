package android.support.v4.media;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RatingCompat implements Parcelable {
  public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
      public RatingCompat createFromParcel(Parcel param1Parcel) {
        return new RatingCompat(param1Parcel.readInt(), param1Parcel.readFloat());
      }
      
      public RatingCompat[] newArray(int param1Int) {
        return new RatingCompat[param1Int];
      }
    };
  
  public static final int RATING_3_STARS = 3;
  
  public static final int RATING_4_STARS = 4;
  
  public static final int RATING_5_STARS = 5;
  
  public static final int RATING_HEART = 1;
  
  public static final int RATING_NONE = 0;
  
  private static final float RATING_NOT_RATED = -1.0F;
  
  public static final int RATING_PERCENTAGE = 6;
  
  public static final int RATING_THUMB_UP_DOWN = 2;
  
  private static final String TAG = "Rating";
  
  private Object mRatingObj;
  
  private final int mRatingStyle;
  
  private final float mRatingValue;
  
  RatingCompat(int paramInt, float paramFloat) {
    this.mRatingStyle = paramInt;
    this.mRatingValue = paramFloat;
  }
  
  public static RatingCompat fromRating(Object paramObject) {
    if (paramObject == null || Build.VERSION.SDK_INT < 19)
      return null; 
    int i = RatingCompatKitkat.getRatingStyle(paramObject);
    if (RatingCompatKitkat.isRated(paramObject)) {
      switch (i) {
        default:
          return null;
        case 1:
          ratingCompat1 = newHeartRating(RatingCompatKitkat.hasHeart(paramObject));
          ratingCompat1.mRatingObj = paramObject;
          return ratingCompat1;
        case 2:
          ratingCompat1 = newThumbRating(RatingCompatKitkat.isThumbUp(paramObject));
          ratingCompat1.mRatingObj = paramObject;
          return ratingCompat1;
        case 3:
        case 4:
        case 5:
          ratingCompat1 = newStarRating(i, RatingCompatKitkat.getStarRating(paramObject));
          ratingCompat1.mRatingObj = paramObject;
          return ratingCompat1;
        case 6:
          break;
      } 
      RatingCompat ratingCompat1 = newPercentageRating(RatingCompatKitkat.getPercentRating(paramObject));
      ratingCompat1.mRatingObj = paramObject;
      return ratingCompat1;
    } 
    RatingCompat ratingCompat = newUnratedRating(i);
    ratingCompat.mRatingObj = paramObject;
    return ratingCompat;
  }
  
  public static RatingCompat newHeartRating(boolean paramBoolean) {
    if (paramBoolean) {
      float f1 = 1.0F;
      return new RatingCompat(1, f1);
    } 
    float f = 0.0F;
    return new RatingCompat(1, f);
  }
  
  public static RatingCompat newPercentageRating(float paramFloat) {
    if (paramFloat < 0.0F || paramFloat > 100.0F) {
      Log.e("Rating", "Invalid percentage-based rating value");
      return null;
    } 
    return new RatingCompat(6, paramFloat);
  }
  
  public static RatingCompat newStarRating(int paramInt, float paramFloat) {
    // Byte code:
    //   0: iload_0
    //   1: tableswitch default -> 28, 3 -> 60, 4 -> 85, 5 -> 91
    //   28: ldc 'Rating'
    //   30: new java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: ldc 'Invalid rating style ('
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_0
    //   43: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   46: ldc ') for a star rating'
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual toString : ()Ljava/lang/String;
    //   54: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   57: pop
    //   58: aconst_null
    //   59: areturn
    //   60: ldc 3.0
    //   62: fstore_2
    //   63: fload_1
    //   64: fconst_0
    //   65: fcmpg
    //   66: iflt -> 75
    //   69: fload_1
    //   70: fload_2
    //   71: fcmpl
    //   72: ifle -> 97
    //   75: ldc 'Rating'
    //   77: ldc 'Trying to set out of range star-based rating'
    //   79: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: aconst_null
    //   84: areturn
    //   85: ldc 4.0
    //   87: fstore_2
    //   88: goto -> 63
    //   91: ldc 5.0
    //   93: fstore_2
    //   94: goto -> 63
    //   97: new android/support/v4/media/RatingCompat
    //   100: dup
    //   101: iload_0
    //   102: fload_1
    //   103: invokespecial <init> : (IF)V
    //   106: areturn
  }
  
  public static RatingCompat newThumbRating(boolean paramBoolean) {
    if (paramBoolean) {
      float f1 = 1.0F;
      return new RatingCompat(2, f1);
    } 
    float f = 0.0F;
    return new RatingCompat(2, f);
  }
  
  public static RatingCompat newUnratedRating(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
        break;
    } 
    return new RatingCompat(paramInt, -1.0F);
  }
  
  public int describeContents() {
    return this.mRatingStyle;
  }
  
  public float getPercentRating() {
    return (this.mRatingStyle != 6 || !isRated()) ? -1.0F : this.mRatingValue;
  }
  
  public Object getRating() {
    if (this.mRatingObj != null || Build.VERSION.SDK_INT < 19)
      return this.mRatingObj; 
    if (isRated()) {
      switch (this.mRatingStyle) {
        default:
          return null;
        case 1:
          this.mRatingObj = RatingCompatKitkat.newHeartRating(hasHeart());
          return this.mRatingObj;
        case 2:
          this.mRatingObj = RatingCompatKitkat.newThumbRating(isThumbUp());
          return this.mRatingObj;
        case 3:
        case 4:
        case 5:
          this.mRatingObj = RatingCompatKitkat.newStarRating(this.mRatingStyle, getStarRating());
          return this.mRatingObj;
        case 6:
          break;
      } 
      this.mRatingObj = RatingCompatKitkat.newPercentageRating(getPercentRating());
    } 
    this.mRatingObj = RatingCompatKitkat.newUnratedRating(this.mRatingStyle);
    return this.mRatingObj;
  }
  
  public int getRatingStyle() {
    return this.mRatingStyle;
  }
  
  public float getStarRating() {
    switch (this.mRatingStyle) {
      default:
        return -1.0F;
      case 3:
      case 4:
      case 5:
        break;
    } 
    if (isRated())
      return this.mRatingValue; 
  }
  
  public boolean hasHeart() {
    boolean bool = true;
    if (this.mRatingStyle != 1)
      return false; 
    if (this.mRatingValue != 1.0F)
      bool = false; 
    return bool;
  }
  
  public boolean isRated() {
    return (this.mRatingValue >= 0.0F);
  }
  
  public boolean isThumbUp() {
    return (this.mRatingStyle == 2 && this.mRatingValue == 1.0F);
  }
  
  public String toString() {
    StringBuilder stringBuilder = (new StringBuilder()).append("Rating:style=").append(this.mRatingStyle).append(" rating=");
    if (this.mRatingValue < 0.0F) {
      String str1 = "unrated";
      return stringBuilder.append(str1).toString();
    } 
    String str = String.valueOf(this.mRatingValue);
    return stringBuilder.append(str).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.mRatingStyle);
    paramParcel.writeFloat(this.mRatingValue);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface StarStyle {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface Style {}
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\media\RatingCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */