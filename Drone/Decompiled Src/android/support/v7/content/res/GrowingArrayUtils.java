package android.support.v7.content.res;

import java.lang.reflect.Array;

final class GrowingArrayUtils {
  static {
    boolean bool;
    if (!GrowingArrayUtils.class.desiredAssertionStatus()) {
      bool = true;
    } else {
      bool = false;
    } 
    $assertionsDisabled = bool;
  }
  
  public static int[] append(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    assert paramInt1 <= paramArrayOfint.length;
    int[] arrayOfInt = paramArrayOfint;
    if (paramInt1 + 1 > paramArrayOfint.length) {
      arrayOfInt = new int[growSize(paramInt1)];
      System.arraycopy(paramArrayOfint, 0, arrayOfInt, 0, paramInt1);
    } 
    arrayOfInt[paramInt1] = paramInt2;
    return arrayOfInt;
  }
  
  public static long[] append(long[] paramArrayOflong, int paramInt, long paramLong) {
    assert paramInt <= paramArrayOflong.length;
    long[] arrayOfLong = paramArrayOflong;
    if (paramInt + 1 > paramArrayOflong.length) {
      arrayOfLong = new long[growSize(paramInt)];
      System.arraycopy(paramArrayOflong, 0, arrayOfLong, 0, paramInt);
    } 
    arrayOfLong[paramInt] = paramLong;
    return arrayOfLong;
  }
  
  public static <T> T[] append(T[] paramArrayOfT, int paramInt, T paramT) {
    assert paramInt <= paramArrayOfT.length;
    T[] arrayOfT = paramArrayOfT;
    if (paramInt + 1 > paramArrayOfT.length) {
      arrayOfT = (T[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), growSize(paramInt));
      System.arraycopy(paramArrayOfT, 0, arrayOfT, 0, paramInt);
    } 
    arrayOfT[paramInt] = paramT;
    return arrayOfT;
  }
  
  public static boolean[] append(boolean[] paramArrayOfboolean, int paramInt, boolean paramBoolean) {
    assert paramInt <= paramArrayOfboolean.length;
    boolean[] arrayOfBoolean = paramArrayOfboolean;
    if (paramInt + 1 > paramArrayOfboolean.length) {
      arrayOfBoolean = new boolean[growSize(paramInt)];
      System.arraycopy(paramArrayOfboolean, 0, arrayOfBoolean, 0, paramInt);
    } 
    arrayOfBoolean[paramInt] = paramBoolean;
    return arrayOfBoolean;
  }
  
  public static int growSize(int paramInt) {
    return (paramInt <= 4) ? 8 : (paramInt * 2);
  }
  
  public static int[] insert(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
    assert paramInt1 <= paramArrayOfint.length;
    if (paramInt1 + 1 <= paramArrayOfint.length) {
      System.arraycopy(paramArrayOfint, paramInt2, paramArrayOfint, paramInt2 + 1, paramInt1 - paramInt2);
      paramArrayOfint[paramInt2] = paramInt3;
      return paramArrayOfint;
    } 
    int[] arrayOfInt = new int[growSize(paramInt1)];
    System.arraycopy(paramArrayOfint, 0, arrayOfInt, 0, paramInt2);
    arrayOfInt[paramInt2] = paramInt3;
    System.arraycopy(paramArrayOfint, paramInt2, arrayOfInt, paramInt2 + 1, paramArrayOfint.length - paramInt2);
    return arrayOfInt;
  }
  
  public static long[] insert(long[] paramArrayOflong, int paramInt1, int paramInt2, long paramLong) {
    assert paramInt1 <= paramArrayOflong.length;
    if (paramInt1 + 1 <= paramArrayOflong.length) {
      System.arraycopy(paramArrayOflong, paramInt2, paramArrayOflong, paramInt2 + 1, paramInt1 - paramInt2);
      paramArrayOflong[paramInt2] = paramLong;
      return paramArrayOflong;
    } 
    long[] arrayOfLong = new long[growSize(paramInt1)];
    System.arraycopy(paramArrayOflong, 0, arrayOfLong, 0, paramInt2);
    arrayOfLong[paramInt2] = paramLong;
    System.arraycopy(paramArrayOflong, paramInt2, arrayOfLong, paramInt2 + 1, paramArrayOflong.length - paramInt2);
    return arrayOfLong;
  }
  
  public static <T> T[] insert(T[] paramArrayOfT, int paramInt1, int paramInt2, T paramT) {
    assert paramInt1 <= paramArrayOfT.length;
    if (paramInt1 + 1 <= paramArrayOfT.length) {
      System.arraycopy(paramArrayOfT, paramInt2, paramArrayOfT, paramInt2 + 1, paramInt1 - paramInt2);
      paramArrayOfT[paramInt2] = paramT;
      return paramArrayOfT;
    } 
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), growSize(paramInt1));
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, paramInt2);
    arrayOfObject[paramInt2] = paramT;
    System.arraycopy(paramArrayOfT, paramInt2, arrayOfObject, paramInt2 + 1, paramArrayOfT.length - paramInt2);
    return (T[])arrayOfObject;
  }
  
  public static boolean[] insert(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2, boolean paramBoolean) {
    assert paramInt1 <= paramArrayOfboolean.length;
    if (paramInt1 + 1 <= paramArrayOfboolean.length) {
      System.arraycopy(paramArrayOfboolean, paramInt2, paramArrayOfboolean, paramInt2 + 1, paramInt1 - paramInt2);
      paramArrayOfboolean[paramInt2] = paramBoolean;
      return paramArrayOfboolean;
    } 
    boolean[] arrayOfBoolean = new boolean[growSize(paramInt1)];
    System.arraycopy(paramArrayOfboolean, 0, arrayOfBoolean, 0, paramInt2);
    arrayOfBoolean[paramInt2] = paramBoolean;
    System.arraycopy(paramArrayOfboolean, paramInt2, arrayOfBoolean, paramInt2 + 1, paramArrayOfboolean.length - paramInt2);
    return arrayOfBoolean;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\content\res\GrowingArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */