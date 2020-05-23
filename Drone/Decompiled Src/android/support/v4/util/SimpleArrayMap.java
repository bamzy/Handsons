package android.support.v4.util;

import java.util.Map;

public class SimpleArrayMap<K, V> {
  private static final int BASE_SIZE = 4;
  
  private static final int CACHE_SIZE = 10;
  
  private static final boolean DEBUG = false;
  
  private static final String TAG = "ArrayMap";
  
  static Object[] mBaseCache;
  
  static int mBaseCacheSize;
  
  static Object[] mTwiceBaseCache;
  
  static int mTwiceBaseCacheSize;
  
  Object[] mArray;
  
  int[] mHashes;
  
  int mSize;
  
  public SimpleArrayMap() {
    this.mHashes = ContainerHelpers.EMPTY_INTS;
    this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    this.mSize = 0;
  }
  
  public SimpleArrayMap(int paramInt) {
    if (paramInt == 0) {
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    } else {
      allocArrays(paramInt);
    } 
    this.mSize = 0;
  }
  
  public SimpleArrayMap(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap) {
    this();
    if (paramSimpleArrayMap != null)
      putAll(paramSimpleArrayMap); 
  }
  
  private void allocArrays(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: bipush #8
    //   3: if_icmpne -> 96
    //   6: ldc android/support/v4/util/ArrayMap
    //   8: monitorenter
    //   9: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   12: ifnull -> 69
    //   15: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_0
    //   20: aload_2
    //   21: putfield mArray : [Ljava/lang/Object;
    //   24: aload_2
    //   25: iconst_0
    //   26: aaload
    //   27: checkcast [Ljava/lang/Object;
    //   30: checkcast [Ljava/lang/Object;
    //   33: putstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   36: aload_0
    //   37: aload_2
    //   38: iconst_1
    //   39: aaload
    //   40: checkcast [I
    //   43: checkcast [I
    //   46: putfield mHashes : [I
    //   49: aload_2
    //   50: iconst_1
    //   51: aconst_null
    //   52: aastore
    //   53: aload_2
    //   54: iconst_0
    //   55: aconst_null
    //   56: aastore
    //   57: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   60: iconst_1
    //   61: isub
    //   62: putstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   65: ldc android/support/v4/util/ArrayMap
    //   67: monitorexit
    //   68: return
    //   69: ldc android/support/v4/util/ArrayMap
    //   71: monitorexit
    //   72: aload_0
    //   73: iload_1
    //   74: newarray int
    //   76: putfield mHashes : [I
    //   79: aload_0
    //   80: iload_1
    //   81: iconst_1
    //   82: ishl
    //   83: anewarray java/lang/Object
    //   86: putfield mArray : [Ljava/lang/Object;
    //   89: return
    //   90: astore_2
    //   91: ldc android/support/v4/util/ArrayMap
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    //   96: iload_1
    //   97: iconst_4
    //   98: if_icmpne -> 72
    //   101: ldc android/support/v4/util/ArrayMap
    //   103: monitorenter
    //   104: getstatic android/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   107: ifnull -> 170
    //   110: getstatic android/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   113: astore_2
    //   114: aload_0
    //   115: aload_2
    //   116: putfield mArray : [Ljava/lang/Object;
    //   119: aload_2
    //   120: iconst_0
    //   121: aaload
    //   122: checkcast [Ljava/lang/Object;
    //   125: checkcast [Ljava/lang/Object;
    //   128: putstatic android/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   131: aload_0
    //   132: aload_2
    //   133: iconst_1
    //   134: aaload
    //   135: checkcast [I
    //   138: checkcast [I
    //   141: putfield mHashes : [I
    //   144: aload_2
    //   145: iconst_1
    //   146: aconst_null
    //   147: aastore
    //   148: aload_2
    //   149: iconst_0
    //   150: aconst_null
    //   151: aastore
    //   152: getstatic android/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   155: iconst_1
    //   156: isub
    //   157: putstatic android/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   160: ldc android/support/v4/util/ArrayMap
    //   162: monitorexit
    //   163: return
    //   164: astore_2
    //   165: ldc android/support/v4/util/ArrayMap
    //   167: monitorexit
    //   168: aload_2
    //   169: athrow
    //   170: ldc android/support/v4/util/ArrayMap
    //   172: monitorexit
    //   173: goto -> 72
    // Exception table:
    //   from	to	target	type
    //   9	49	90	finally
    //   57	68	90	finally
    //   69	72	90	finally
    //   91	94	90	finally
    //   104	144	164	finally
    //   152	163	164	finally
    //   165	168	164	finally
    //   170	173	164	finally
  }
  
  private static void freeArrays(int[] paramArrayOfint, Object[] paramArrayOfObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: bipush #8
    //   4: if_icmpne -> 59
    //   7: ldc android/support/v4/util/ArrayMap
    //   9: monitorenter
    //   10: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   13: bipush #10
    //   15: if_icmpge -> 49
    //   18: aload_1
    //   19: iconst_0
    //   20: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   23: aastore
    //   24: aload_1
    //   25: iconst_1
    //   26: aload_0
    //   27: aastore
    //   28: iload_2
    //   29: iconst_1
    //   30: ishl
    //   31: iconst_1
    //   32: isub
    //   33: istore_2
    //   34: goto -> 117
    //   37: aload_1
    //   38: putstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   41: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   44: iconst_1
    //   45: iadd
    //   46: putstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   49: ldc android/support/v4/util/ArrayMap
    //   51: monitorexit
    //   52: return
    //   53: astore_0
    //   54: ldc android/support/v4/util/ArrayMap
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    //   59: aload_0
    //   60: arraylength
    //   61: iconst_4
    //   62: if_icmpne -> 133
    //   65: ldc android/support/v4/util/ArrayMap
    //   67: monitorenter
    //   68: getstatic android/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   71: bipush #10
    //   73: if_icmpge -> 107
    //   76: aload_1
    //   77: iconst_0
    //   78: getstatic android/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   81: aastore
    //   82: aload_1
    //   83: iconst_1
    //   84: aload_0
    //   85: aastore
    //   86: iload_2
    //   87: iconst_1
    //   88: ishl
    //   89: iconst_1
    //   90: isub
    //   91: istore_2
    //   92: goto -> 134
    //   95: aload_1
    //   96: putstatic android/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   99: getstatic android/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   102: iconst_1
    //   103: iadd
    //   104: putstatic android/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   107: ldc android/support/v4/util/ArrayMap
    //   109: monitorexit
    //   110: return
    //   111: astore_0
    //   112: ldc android/support/v4/util/ArrayMap
    //   114: monitorexit
    //   115: aload_0
    //   116: athrow
    //   117: iload_2
    //   118: iconst_2
    //   119: if_icmplt -> 37
    //   122: aload_1
    //   123: iload_2
    //   124: aconst_null
    //   125: aastore
    //   126: iload_2
    //   127: iconst_1
    //   128: isub
    //   129: istore_2
    //   130: goto -> 117
    //   133: return
    //   134: iload_2
    //   135: iconst_2
    //   136: if_icmplt -> 95
    //   139: aload_1
    //   140: iload_2
    //   141: aconst_null
    //   142: aastore
    //   143: iload_2
    //   144: iconst_1
    //   145: isub
    //   146: istore_2
    //   147: goto -> 134
    // Exception table:
    //   from	to	target	type
    //   10	24	53	finally
    //   37	49	53	finally
    //   49	52	53	finally
    //   54	57	53	finally
    //   68	82	111	finally
    //   95	107	111	finally
    //   107	110	111	finally
    //   112	115	111	finally
  }
  
  public void clear() {
    if (this.mSize != 0) {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
    } 
  }
  
  public boolean containsKey(Object paramObject) {
    return (indexOfKey(paramObject) >= 0);
  }
  
  public boolean containsValue(Object paramObject) {
    return (indexOfValue(paramObject) >= 0);
  }
  
  public void ensureCapacity(int paramInt) {
    if (this.mHashes.length < paramInt) {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(paramInt);
      if (this.mSize > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, this.mSize << 1);
      } 
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (this != paramObject) {
      if (paramObject instanceof SimpleArrayMap) {
        paramObject = paramObject;
        if (size() != paramObject.size())
          return false; 
        int i = 0;
        try {
          while (true) {
            if (i < this.mSize) {
              K k = keyAt(i);
              V v = valueAt(i);
              Object object = paramObject.get(k);
              if (v == null) {
                if (object != null || !paramObject.containsKey(k))
                  break; 
              } else {
                boolean bool = v.equals(object);
                if (!bool)
                  return false; 
              } 
              i++;
              continue;
            } 
            return true;
          } 
        } catch (NullPointerException nullPointerException) {
          return false;
        } catch (ClassCastException classCastException) {
          return false;
        } 
      } else {
        if (classCastException instanceof Map) {
          Map map = (Map)classCastException;
          if (size() != map.size())
            return false; 
          int i = 0;
          try {
            while (true) {
              if (i < this.mSize) {
                K k = keyAt(i);
                V v = valueAt(i);
                Object object = map.get(k);
                if (v == null) {
                  if (object != null || !map.containsKey(k))
                    break; 
                } else {
                  boolean bool = v.equals(object);
                  if (!bool)
                    return false; 
                } 
                i++;
                continue;
              } 
              return true;
            } 
          } catch (NullPointerException nullPointerException) {
            return false;
          } catch (ClassCastException classCastException1) {
            return false;
          } 
        } else {
          return false;
        } 
        return false;
      } 
      return false;
    } 
    return true;
  }
  
  public V get(Object paramObject) {
    int i = indexOfKey(paramObject);
    return (V)((i >= 0) ? this.mArray[(i << 1) + 1] : null);
  }
  
  public int hashCode() {
    int[] arrayOfInt = this.mHashes;
    Object[] arrayOfObject = this.mArray;
    int k = 0;
    int j = 0;
    int i = 1;
    int m = this.mSize;
    while (j < m) {
      int n;
      Object object = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      if (object == null) {
        n = 0;
      } else {
        n = object.hashCode();
      } 
      k += n ^ i1;
      j++;
      i += 2;
    } 
    return k;
  }
  
  int indexOf(Object paramObject, int paramInt) {
    int k = this.mSize;
    if (k == 0)
      return -1; 
    int j = ContainerHelpers.binarySearch(this.mHashes, k, paramInt);
    int i = j;
    if (j >= 0) {
      i = j;
      if (!paramObject.equals(this.mArray[j << 1])) {
        for (i = j + 1; i < k && this.mHashes[i] == paramInt; i++) {
          if (paramObject.equals(this.mArray[i << 1]))
            return i; 
        } 
        while (--j >= 0 && this.mHashes[j] == paramInt) {
          if (paramObject.equals(this.mArray[j << 1]))
            return j; 
          j--;
        } 
        return i ^ 0xFFFFFFFF;
      } 
    } 
    return i;
  }
  
  public int indexOfKey(Object paramObject) {
    return (paramObject == null) ? indexOfNull() : indexOf(paramObject, paramObject.hashCode());
  }
  
  int indexOfNull() {
    int k = this.mSize;
    if (k == 0)
      return -1; 
    int j = ContainerHelpers.binarySearch(this.mHashes, k, 0);
    int i = j;
    if (j >= 0) {
      i = j;
      if (this.mArray[j << 1] != null) {
        for (i = j + 1; i < k && this.mHashes[i] == 0; i++) {
          if (this.mArray[i << 1] == null)
            return i; 
        } 
        while (--j >= 0 && this.mHashes[j] == 0) {
          if (this.mArray[j << 1] == null)
            return j; 
          j--;
        } 
        return i ^ 0xFFFFFFFF;
      } 
    } 
    return i;
  }
  
  int indexOfValue(Object paramObject) {
    int i = this.mSize * 2;
    Object[] arrayOfObject = this.mArray;
    if (paramObject == null) {
      for (int j = 1; j < i; j += 2) {
        if (arrayOfObject[j] == null)
          return j >> 1; 
      } 
    } else {
      for (int j = 1; j < i; j += 2) {
        if (paramObject.equals(arrayOfObject[j]))
          return j >> 1; 
      } 
    } 
    return -1;
  }
  
  public boolean isEmpty() {
    return (this.mSize <= 0);
  }
  
  public K keyAt(int paramInt) {
    return (K)this.mArray[paramInt << 1];
  }
  
  public V put(K paramK, V paramV) {
    int i;
    int j;
    byte b = 8;
    if (paramK == null) {
      j = 0;
      i = indexOfNull();
    } else {
      j = paramK.hashCode();
      i = indexOf(paramK, j);
    } 
    if (i >= 0) {
      i = (i << 1) + 1;
      paramK = (K)this.mArray[i];
      this.mArray[i] = paramV;
      return (V)paramK;
    } 
    int k = i ^ 0xFFFFFFFF;
    if (this.mSize >= this.mHashes.length) {
      if (this.mSize >= 8) {
        i = this.mSize + (this.mSize >> 1);
      } else {
        i = b;
        if (this.mSize < 4)
          i = 4; 
      } 
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      if (this.mHashes.length > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, arrayOfObject.length);
      } 
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    } 
    if (k < this.mSize) {
      System.arraycopy(this.mHashes, k, this.mHashes, k + 1, this.mSize - k);
      System.arraycopy(this.mArray, k << 1, this.mArray, k + 1 << 1, this.mSize - k << 1);
    } 
    this.mHashes[k] = j;
    this.mArray[k << 1] = paramK;
    this.mArray[(k << 1) + 1] = paramV;
    this.mSize++;
    return null;
  }
  
  public void putAll(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap) {
    int j = paramSimpleArrayMap.mSize;
    ensureCapacity(this.mSize + j);
    if (this.mSize == 0) {
      if (j > 0) {
        System.arraycopy(paramSimpleArrayMap.mHashes, 0, this.mHashes, 0, j);
        System.arraycopy(paramSimpleArrayMap.mArray, 0, this.mArray, 0, j << 1);
        this.mSize = j;
      } 
      return;
    } 
    int i = 0;
    while (true) {
      if (i < j) {
        put(paramSimpleArrayMap.keyAt(i), paramSimpleArrayMap.valueAt(i));
        i++;
        continue;
      } 
      return;
    } 
  }
  
  public V remove(Object paramObject) {
    int i = indexOfKey(paramObject);
    return (i >= 0) ? removeAt(i) : null;
  }
  
  public V removeAt(int paramInt) {
    int i = 8;
    Object object = this.mArray[(paramInt << 1) + 1];
    if (this.mSize <= 1) {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
      return (V)object;
    } 
    if (this.mHashes.length > 8 && this.mSize < this.mHashes.length / 3) {
      if (this.mSize > 8)
        i = this.mSize + (this.mSize >> 1); 
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      this.mSize--;
      if (paramInt > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, paramInt << 1);
      } 
      if (paramInt < this.mSize) {
        System.arraycopy(arrayOfInt, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
        System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.mArray, paramInt << 1, this.mSize - paramInt << 1);
        return (V)object;
      } 
      return (V)object;
    } 
    this.mSize--;
    if (paramInt < this.mSize) {
      System.arraycopy(this.mHashes, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
      System.arraycopy(this.mArray, paramInt + 1 << 1, this.mArray, paramInt << 1, this.mSize - paramInt << 1);
    } 
    this.mArray[this.mSize << 1] = null;
    this.mArray[(this.mSize << 1) + 1] = null;
    return (V)object;
  }
  
  public V setValueAt(int paramInt, V paramV) {
    paramInt = (paramInt << 1) + 1;
    Object object = this.mArray[paramInt];
    this.mArray[paramInt] = paramV;
    return (V)object;
  }
  
  public int size() {
    return this.mSize;
  }
  
  public String toString() {
    if (isEmpty())
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
    stringBuilder.append('{');
    for (int i = 0; i < this.mSize; i++) {
      if (i > 0)
        stringBuilder.append(", "); 
      V v = (V)keyAt(i);
      if (v != this) {
        stringBuilder.append(v);
      } else {
        stringBuilder.append("(this Map)");
      } 
      stringBuilder.append('=');
      v = valueAt(i);
      if (v != this) {
        stringBuilder.append(v);
      } else {
        stringBuilder.append("(this Map)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public V valueAt(int paramInt) {
    return (V)this.mArray[(paramInt << 1) + 1];
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v\\util\SimpleArrayMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */