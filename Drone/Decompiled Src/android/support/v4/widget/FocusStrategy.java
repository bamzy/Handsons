package android.support.v4.widget;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FocusStrategy {
  private static boolean beamBeats(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2, @NonNull Rect paramRect3) {
    boolean bool1 = true;
    boolean bool = beamsOverlap(paramInt, paramRect1, paramRect2);
    if (beamsOverlap(paramInt, paramRect1, paramRect3) || !bool)
      return false; 
    bool = bool1;
    if (isToDirectionOf(paramInt, paramRect1, paramRect3)) {
      bool = bool1;
      if (paramInt != 17) {
        bool = bool1;
        if (paramInt != 66) {
          bool = bool1;
          if (majorAxisDistance(paramInt, paramRect1, paramRect2) >= majorAxisDistanceToFarEdge(paramInt, paramRect1, paramRect3))
            return false; 
        } 
      } 
    } 
    return bool;
  }
  
  private static boolean beamsOverlap(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
      case 66:
        return !(paramRect2.bottom < paramRect1.top || paramRect2.top > paramRect1.bottom);
      case 33:
      case 130:
        break;
    } 
    return !(paramRect2.right < paramRect1.left || paramRect2.left > paramRect1.right);
  }
  
  public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L paramL, @NonNull CollectionAdapter<L, T> paramCollectionAdapter, @NonNull BoundsAdapter<T> paramBoundsAdapter, @Nullable T paramT, @NonNull Rect paramRect, int paramInt) {
    // Byte code:
    //   0: new android/graphics/Rect
    //   3: dup
    //   4: aload #4
    //   6: invokespecial <init> : (Landroid/graphics/Rect;)V
    //   9: astore #10
    //   11: iload #5
    //   13: lookupswitch default -> 56, 17 -> 66, 33 -> 153, 66 -> 136, 130 -> 169
    //   56: new java/lang/IllegalArgumentException
    //   59: dup
    //   60: ldc 'direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.'
    //   62: invokespecial <init> : (Ljava/lang/String;)V
    //   65: athrow
    //   66: aload #10
    //   68: aload #4
    //   70: invokevirtual width : ()I
    //   73: iconst_1
    //   74: iadd
    //   75: iconst_0
    //   76: invokevirtual offset : (II)V
    //   79: aconst_null
    //   80: astore #8
    //   82: aload_1
    //   83: aload_0
    //   84: invokeinterface size : (Ljava/lang/Object;)I
    //   89: istore #7
    //   91: new android/graphics/Rect
    //   94: dup
    //   95: invokespecial <init> : ()V
    //   98: astore #11
    //   100: iconst_0
    //   101: istore #6
    //   103: iload #6
    //   105: iload #7
    //   107: if_icmpge -> 224
    //   110: aload_1
    //   111: aload_0
    //   112: iload #6
    //   114: invokeinterface get : (Ljava/lang/Object;I)Ljava/lang/Object;
    //   119: astore #9
    //   121: aload #9
    //   123: aload_3
    //   124: if_acmpne -> 186
    //   127: iload #6
    //   129: iconst_1
    //   130: iadd
    //   131: istore #6
    //   133: goto -> 103
    //   136: aload #10
    //   138: aload #4
    //   140: invokevirtual width : ()I
    //   143: iconst_1
    //   144: iadd
    //   145: ineg
    //   146: iconst_0
    //   147: invokevirtual offset : (II)V
    //   150: goto -> 79
    //   153: aload #10
    //   155: iconst_0
    //   156: aload #4
    //   158: invokevirtual height : ()I
    //   161: iconst_1
    //   162: iadd
    //   163: invokevirtual offset : (II)V
    //   166: goto -> 79
    //   169: aload #10
    //   171: iconst_0
    //   172: aload #4
    //   174: invokevirtual height : ()I
    //   177: iconst_1
    //   178: iadd
    //   179: ineg
    //   180: invokevirtual offset : (II)V
    //   183: goto -> 79
    //   186: aload_2
    //   187: aload #9
    //   189: aload #11
    //   191: invokeinterface obtainBounds : (Ljava/lang/Object;Landroid/graphics/Rect;)V
    //   196: iload #5
    //   198: aload #4
    //   200: aload #11
    //   202: aload #10
    //   204: invokestatic isBetterCandidate : (ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)Z
    //   207: ifeq -> 127
    //   210: aload #10
    //   212: aload #11
    //   214: invokevirtual set : (Landroid/graphics/Rect;)V
    //   217: aload #9
    //   219: astore #8
    //   221: goto -> 127
    //   224: aload #8
    //   226: areturn
  }
  
  public static <L, T> T findNextFocusInRelativeDirection(@NonNull L paramL, @NonNull CollectionAdapter<L, T> paramCollectionAdapter, @NonNull BoundsAdapter<T> paramBoundsAdapter, @Nullable T paramT, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    int j = paramCollectionAdapter.size(paramL);
    ArrayList<?> arrayList = new ArrayList(j);
    int i;
    for (i = 0; i < j; i++)
      arrayList.add(paramCollectionAdapter.get(paramL, i)); 
    Collections.sort(arrayList, new SequentialComparator(paramBoolean1, paramBoundsAdapter));
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
      case 2:
        return getNextFocusable(paramT, (ArrayList)arrayList, paramBoolean2);
      case 1:
        break;
    } 
    return getPreviousFocusable(paramT, (ArrayList)arrayList, paramBoolean2);
  }
  
  private static <T> T getNextFocusable(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean) {
    int i;
    int j = paramArrayList.size();
    if (paramT == null) {
      i = -1;
    } else {
      i = paramArrayList.lastIndexOf(paramT);
    } 
    return (++i < j) ? paramArrayList.get(i) : ((paramBoolean && j > 0) ? paramArrayList.get(0) : null);
  }
  
  private static <T> T getPreviousFocusable(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean) {
    int i;
    int j = paramArrayList.size();
    if (paramT == null) {
      i = j;
    } else {
      i = paramArrayList.indexOf(paramT);
    } 
    return (--i >= 0) ? paramArrayList.get(i) : ((paramBoolean && j > 0) ? paramArrayList.get(j - 1) : null);
  }
  
  private static int getWeightedDistanceFor(int paramInt1, int paramInt2) {
    return paramInt1 * 13 * paramInt1 + paramInt2 * paramInt2;
  }
  
  private static boolean isBetterCandidate(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2, @NonNull Rect paramRect3) {
    boolean bool2 = true;
    if (!isCandidate(paramRect1, paramRect2, paramInt))
      return false; 
    boolean bool1 = bool2;
    if (isCandidate(paramRect1, paramRect3, paramInt)) {
      bool1 = bool2;
      if (!beamBeats(paramInt, paramRect1, paramRect2, paramRect3)) {
        if (beamBeats(paramInt, paramRect1, paramRect3, paramRect2))
          return false; 
        bool1 = bool2;
        if (getWeightedDistanceFor(majorAxisDistance(paramInt, paramRect1, paramRect2), minorAxisDistance(paramInt, paramRect1, paramRect2)) >= getWeightedDistanceFor(majorAxisDistance(paramInt, paramRect1, paramRect3), minorAxisDistance(paramInt, paramRect1, paramRect3)))
          return false; 
      } 
    } 
    return bool1;
  }
  
  private static boolean isCandidate(@NonNull Rect paramRect1, @NonNull Rect paramRect2, int paramInt) {
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
        return !((paramRect1.right <= paramRect2.right && paramRect1.left < paramRect2.right) || paramRect1.left <= paramRect2.left);
      case 66:
        return !((paramRect1.left >= paramRect2.left && paramRect1.right > paramRect2.left) || paramRect1.right >= paramRect2.right);
      case 33:
        return !((paramRect1.bottom <= paramRect2.bottom && paramRect1.top < paramRect2.bottom) || paramRect1.top <= paramRect2.top);
      case 130:
        break;
    } 
    return !((paramRect1.top >= paramRect2.top && paramRect1.bottom > paramRect2.top) || paramRect1.bottom >= paramRect2.bottom);
  }
  
  private static boolean isToDirectionOf(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
        return !(paramRect1.left < paramRect2.right);
      case 66:
        return !(paramRect1.right > paramRect2.left);
      case 33:
        return !(paramRect1.top < paramRect2.bottom);
      case 130:
        break;
    } 
    return !(paramRect1.bottom > paramRect2.top);
  }
  
  private static int majorAxisDistance(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    return Math.max(0, majorAxisDistanceRaw(paramInt, paramRect1, paramRect2));
  }
  
  private static int majorAxisDistanceRaw(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
        return paramRect1.left - paramRect2.right;
      case 66:
        return paramRect2.left - paramRect1.right;
      case 33:
        return paramRect1.top - paramRect2.bottom;
      case 130:
        break;
    } 
    return paramRect2.top - paramRect1.bottom;
  }
  
  private static int majorAxisDistanceToFarEdge(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    return Math.max(1, majorAxisDistanceToFarEdgeRaw(paramInt, paramRect1, paramRect2));
  }
  
  private static int majorAxisDistanceToFarEdgeRaw(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
        return paramRect1.left - paramRect2.left;
      case 66:
        return paramRect2.right - paramRect1.right;
      case 33:
        return paramRect1.top - paramRect2.top;
      case 130:
        break;
    } 
    return paramRect2.bottom - paramRect1.bottom;
  }
  
  private static int minorAxisDistance(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
      case 66:
        return Math.abs(paramRect1.top + paramRect1.height() / 2 - paramRect2.top + paramRect2.height() / 2);
      case 33:
      case 130:
        break;
    } 
    return Math.abs(paramRect1.left + paramRect1.width() / 2 - paramRect2.left + paramRect2.width() / 2);
  }
  
  public static interface BoundsAdapter<T> {
    void obtainBounds(T param1T, Rect param1Rect);
  }
  
  public static interface CollectionAdapter<T, V> {
    V get(T param1T, int param1Int);
    
    int size(T param1T);
  }
  
  private static class SequentialComparator<T> implements Comparator<T> {
    private final FocusStrategy.BoundsAdapter<T> mAdapter;
    
    private final boolean mIsLayoutRtl;
    
    private final Rect mTemp1 = new Rect();
    
    private final Rect mTemp2 = new Rect();
    
    SequentialComparator(boolean param1Boolean, FocusStrategy.BoundsAdapter<T> param1BoundsAdapter) {
      this.mIsLayoutRtl = param1Boolean;
      this.mAdapter = param1BoundsAdapter;
    }
    
    public int compare(T param1T1, T param1T2) {
      boolean bool = true;
      byte b = 1;
      Rect rect1 = this.mTemp1;
      Rect rect2 = this.mTemp2;
      this.mAdapter.obtainBounds(param1T1, rect1);
      this.mAdapter.obtainBounds(param1T2, rect2);
      if (rect1.top >= rect2.top) {
        if (rect1.top > rect2.top)
          return 1; 
        if (rect1.left < rect2.left) {
          if (!this.mIsLayoutRtl)
            b = -1; 
          return b;
        } 
        if (rect1.left > rect2.left)
          return !this.mIsLayoutRtl ? 1 : -1; 
        if (rect1.bottom >= rect2.bottom)
          return (rect1.bottom > rect2.bottom) ? 1 : ((rect1.right < rect2.right) ? (this.mIsLayoutRtl ? bool : -1) : ((rect1.right > rect2.right) ? (!this.mIsLayoutRtl ? 1 : -1) : 0)); 
      } 
      return -1;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\FocusStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */