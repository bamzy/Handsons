package android.support.v4.util;

class ContainerHelpers {
  static final int[] EMPTY_INTS = new int[0];
  
  static final long[] EMPTY_LONGS = new long[0];
  
  static final Object[] EMPTY_OBJECTS = new Object[0];
  
  static int binarySearch(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_1
    //   3: iconst_1
    //   4: isub
    //   5: istore #4
    //   7: iload_3
    //   8: istore_1
    //   9: iload #4
    //   11: istore_3
    //   12: iload_1
    //   13: iload_3
    //   14: if_icmpgt -> 61
    //   17: iload_1
    //   18: iload_3
    //   19: iadd
    //   20: iconst_1
    //   21: iushr
    //   22: istore #4
    //   24: aload_0
    //   25: iload #4
    //   27: iaload
    //   28: istore #5
    //   30: iload #5
    //   32: iload_2
    //   33: if_icmpge -> 44
    //   36: iload #4
    //   38: iconst_1
    //   39: iadd
    //   40: istore_1
    //   41: goto -> 12
    //   44: iload #4
    //   46: istore_3
    //   47: iload #5
    //   49: iload_2
    //   50: if_icmple -> 65
    //   53: iload #4
    //   55: iconst_1
    //   56: isub
    //   57: istore_3
    //   58: goto -> 12
    //   61: iload_1
    //   62: iconst_m1
    //   63: ixor
    //   64: istore_3
    //   65: iload_3
    //   66: ireturn
  }
  
  static int binarySearch(long[] paramArrayOflong, int paramInt, long paramLong) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #4
    //   3: iload_1
    //   4: iconst_1
    //   5: isub
    //   6: istore #5
    //   8: iload #4
    //   10: istore_1
    //   11: iload #5
    //   13: istore #4
    //   15: iload_1
    //   16: iload #4
    //   18: if_icmpgt -> 70
    //   21: iload_1
    //   22: iload #4
    //   24: iadd
    //   25: iconst_1
    //   26: iushr
    //   27: istore #5
    //   29: aload_0
    //   30: iload #5
    //   32: laload
    //   33: lstore #6
    //   35: lload #6
    //   37: lload_2
    //   38: lcmp
    //   39: ifge -> 50
    //   42: iload #5
    //   44: iconst_1
    //   45: iadd
    //   46: istore_1
    //   47: goto -> 15
    //   50: iload #5
    //   52: istore #4
    //   54: lload #6
    //   56: lload_2
    //   57: lcmp
    //   58: ifle -> 75
    //   61: iload #5
    //   63: iconst_1
    //   64: isub
    //   65: istore #4
    //   67: goto -> 15
    //   70: iload_1
    //   71: iconst_m1
    //   72: ixor
    //   73: istore #4
    //   75: iload #4
    //   77: ireturn
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public static int idealByteArraySize(int paramInt) {
    for (int i = 4;; i++) {
      int j = paramInt;
      if (i < 32) {
        if (paramInt <= (1 << i) - 12)
          return (1 << i) - 12; 
      } else {
        return j;
      } 
    } 
  }
  
  public static int idealIntArraySize(int paramInt) {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public static int idealLongArraySize(int paramInt) {
    return idealByteArraySize(paramInt * 8) / 8;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v\\util\ContainerHelpers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */