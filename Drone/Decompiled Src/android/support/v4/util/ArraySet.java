package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
  private static final int BASE_SIZE = 4;
  
  private static final int CACHE_SIZE = 10;
  
  private static final boolean DEBUG = false;
  
  private static final int[] INT = new int[0];
  
  private static final Object[] OBJECT = new Object[0];
  
  private static final String TAG = "ArraySet";
  
  static Object[] sBaseCache;
  
  static int sBaseCacheSize;
  
  static Object[] sTwiceBaseCache;
  
  static int sTwiceBaseCacheSize;
  
  Object[] mArray;
  
  MapCollections<E, E> mCollections;
  
  int[] mHashes;
  
  final boolean mIdentityHashCode;
  
  int mSize;
  
  public ArraySet() {
    this(0, false);
  }
  
  public ArraySet(int paramInt) {
    this(paramInt, false);
  }
  
  public ArraySet(int paramInt, boolean paramBoolean) {
    this.mIdentityHashCode = paramBoolean;
    if (paramInt == 0) {
      this.mHashes = INT;
      this.mArray = OBJECT;
    } else {
      allocArrays(paramInt);
    } 
    this.mSize = 0;
  }
  
  public ArraySet(ArraySet<E> paramArraySet) {
    this();
    if (paramArraySet != null)
      addAll(paramArraySet); 
  }
  
  public ArraySet(Collection<E> paramCollection) {
    this();
    if (paramCollection != null)
      addAll(paramCollection); 
  }
  
  private void allocArrays(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: bipush #8
    //   3: if_icmpne -> 94
    //   6: ldc android/support/v4/util/ArraySet
    //   8: monitorenter
    //   9: getstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   12: ifnull -> 69
    //   15: getstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_0
    //   20: aload_2
    //   21: putfield mArray : [Ljava/lang/Object;
    //   24: aload_2
    //   25: iconst_0
    //   26: aaload
    //   27: checkcast [Ljava/lang/Object;
    //   30: checkcast [Ljava/lang/Object;
    //   33: putstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
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
    //   57: getstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   60: iconst_1
    //   61: isub
    //   62: putstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   65: ldc android/support/v4/util/ArraySet
    //   67: monitorexit
    //   68: return
    //   69: ldc android/support/v4/util/ArraySet
    //   71: monitorexit
    //   72: aload_0
    //   73: iload_1
    //   74: newarray int
    //   76: putfield mHashes : [I
    //   79: aload_0
    //   80: iload_1
    //   81: anewarray java/lang/Object
    //   84: putfield mArray : [Ljava/lang/Object;
    //   87: return
    //   88: astore_2
    //   89: ldc android/support/v4/util/ArraySet
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    //   94: iload_1
    //   95: iconst_4
    //   96: if_icmpne -> 72
    //   99: ldc android/support/v4/util/ArraySet
    //   101: monitorenter
    //   102: getstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   105: ifnull -> 168
    //   108: getstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   111: astore_2
    //   112: aload_0
    //   113: aload_2
    //   114: putfield mArray : [Ljava/lang/Object;
    //   117: aload_2
    //   118: iconst_0
    //   119: aaload
    //   120: checkcast [Ljava/lang/Object;
    //   123: checkcast [Ljava/lang/Object;
    //   126: putstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   129: aload_0
    //   130: aload_2
    //   131: iconst_1
    //   132: aaload
    //   133: checkcast [I
    //   136: checkcast [I
    //   139: putfield mHashes : [I
    //   142: aload_2
    //   143: iconst_1
    //   144: aconst_null
    //   145: aastore
    //   146: aload_2
    //   147: iconst_0
    //   148: aconst_null
    //   149: aastore
    //   150: getstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   153: iconst_1
    //   154: isub
    //   155: putstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   158: ldc android/support/v4/util/ArraySet
    //   160: monitorexit
    //   161: return
    //   162: astore_2
    //   163: ldc android/support/v4/util/ArraySet
    //   165: monitorexit
    //   166: aload_2
    //   167: athrow
    //   168: ldc android/support/v4/util/ArraySet
    //   170: monitorexit
    //   171: goto -> 72
    // Exception table:
    //   from	to	target	type
    //   9	49	88	finally
    //   57	68	88	finally
    //   69	72	88	finally
    //   89	92	88	finally
    //   102	142	162	finally
    //   150	161	162	finally
    //   163	166	162	finally
    //   168	171	162	finally
  }
  
  private static void freeArrays(int[] paramArrayOfint, Object[] paramArrayOfObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: bipush #8
    //   4: if_icmpne -> 57
    //   7: ldc android/support/v4/util/ArraySet
    //   9: monitorenter
    //   10: getstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   13: bipush #10
    //   15: if_icmpge -> 47
    //   18: aload_1
    //   19: iconst_0
    //   20: getstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   23: aastore
    //   24: aload_1
    //   25: iconst_1
    //   26: aload_0
    //   27: aastore
    //   28: iload_2
    //   29: iconst_1
    //   30: isub
    //   31: istore_2
    //   32: goto -> 113
    //   35: aload_1
    //   36: putstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   39: getstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   42: iconst_1
    //   43: iadd
    //   44: putstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   47: ldc android/support/v4/util/ArraySet
    //   49: monitorexit
    //   50: return
    //   51: astore_0
    //   52: ldc android/support/v4/util/ArraySet
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    //   57: aload_0
    //   58: arraylength
    //   59: iconst_4
    //   60: if_icmpne -> 129
    //   63: ldc android/support/v4/util/ArraySet
    //   65: monitorenter
    //   66: getstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   69: bipush #10
    //   71: if_icmpge -> 103
    //   74: aload_1
    //   75: iconst_0
    //   76: getstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   79: aastore
    //   80: aload_1
    //   81: iconst_1
    //   82: aload_0
    //   83: aastore
    //   84: iload_2
    //   85: iconst_1
    //   86: isub
    //   87: istore_2
    //   88: goto -> 130
    //   91: aload_1
    //   92: putstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   95: getstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   98: iconst_1
    //   99: iadd
    //   100: putstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   103: ldc android/support/v4/util/ArraySet
    //   105: monitorexit
    //   106: return
    //   107: astore_0
    //   108: ldc android/support/v4/util/ArraySet
    //   110: monitorexit
    //   111: aload_0
    //   112: athrow
    //   113: iload_2
    //   114: iconst_2
    //   115: if_icmplt -> 35
    //   118: aload_1
    //   119: iload_2
    //   120: aconst_null
    //   121: aastore
    //   122: iload_2
    //   123: iconst_1
    //   124: isub
    //   125: istore_2
    //   126: goto -> 113
    //   129: return
    //   130: iload_2
    //   131: iconst_2
    //   132: if_icmplt -> 91
    //   135: aload_1
    //   136: iload_2
    //   137: aconst_null
    //   138: aastore
    //   139: iload_2
    //   140: iconst_1
    //   141: isub
    //   142: istore_2
    //   143: goto -> 130
    // Exception table:
    //   from	to	target	type
    //   10	24	51	finally
    //   35	47	51	finally
    //   47	50	51	finally
    //   52	55	51	finally
    //   66	80	107	finally
    //   91	103	107	finally
    //   103	106	107	finally
    //   108	111	107	finally
  }
  
  private MapCollections<E, E> getCollection() {
    if (this.mCollections == null)
      this.mCollections = new MapCollections<E, E>() {
          protected void colClear() {
            ArraySet.this.clear();
          }
          
          protected Object colGetEntry(int param1Int1, int param1Int2) {
            return ArraySet.this.mArray[param1Int1];
          }
          
          protected Map<E, E> colGetMap() {
            throw new UnsupportedOperationException("not a map");
          }
          
          protected int colGetSize() {
            return ArraySet.this.mSize;
          }
          
          protected int colIndexOfKey(Object param1Object) {
            return ArraySet.this.indexOf(param1Object);
          }
          
          protected int colIndexOfValue(Object param1Object) {
            return ArraySet.this.indexOf(param1Object);
          }
          
          protected void colPut(E param1E1, E param1E2) {
            ArraySet.this.add(param1E1);
          }
          
          protected void colRemoveAt(int param1Int) {
            ArraySet.this.removeAt(param1Int);
          }
          
          protected E colSetValue(int param1Int, E param1E) {
            throw new UnsupportedOperationException("not a map");
          }
        }; 
    return this.mCollections;
  }
  
  private int indexOf(Object paramObject, int paramInt) {
    int k = this.mSize;
    if (k == 0)
      return -1; 
    int j = ContainerHelpers.binarySearch(this.mHashes, k, paramInt);
    int i = j;
    if (j >= 0) {
      i = j;
      if (!paramObject.equals(this.mArray[j])) {
        for (i = j + 1; i < k && this.mHashes[i] == paramInt; i++) {
          if (paramObject.equals(this.mArray[i]))
            return i; 
        } 
        while (--j >= 0 && this.mHashes[j] == paramInt) {
          if (paramObject.equals(this.mArray[j]))
            return j; 
          j--;
        } 
        return i ^ 0xFFFFFFFF;
      } 
    } 
    return i;
  }
  
  private int indexOfNull() {
    int k = this.mSize;
    if (k == 0)
      return -1; 
    int j = ContainerHelpers.binarySearch(this.mHashes, k, 0);
    int i = j;
    if (j >= 0) {
      i = j;
      if (this.mArray[j] != null) {
        for (i = j + 1; i < k && this.mHashes[i] == 0; i++) {
          if (this.mArray[i] == null)
            return i; 
        } 
        while (--j >= 0 && this.mHashes[j] == 0) {
          if (this.mArray[j] == null)
            return j; 
          j--;
        } 
        return i ^ 0xFFFFFFFF;
      } 
    } 
    return i;
  }
  
  public boolean add(E paramE) {
    int i;
    int j;
    byte b = 8;
    if (paramE == null) {
      j = 0;
      i = indexOfNull();
    } else {
      if (this.mIdentityHashCode) {
        i = System.identityHashCode(paramE);
      } else {
        i = paramE.hashCode();
      } 
      int m = indexOf(paramE, i);
      j = i;
      i = m;
    } 
    if (i >= 0)
      return false; 
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
      System.arraycopy(this.mArray, k, this.mArray, k + 1, this.mSize - k);
    } 
    this.mHashes[k] = j;
    this.mArray[k] = paramE;
    this.mSize++;
    return true;
  }
  
  public void addAll(ArraySet<? extends E> paramArraySet) {
    int j = paramArraySet.mSize;
    ensureCapacity(this.mSize + j);
    if (this.mSize == 0) {
      if (j > 0) {
        System.arraycopy(paramArraySet.mHashes, 0, this.mHashes, 0, j);
        System.arraycopy(paramArraySet.mArray, 0, this.mArray, 0, j);
        this.mSize = j;
      } 
      return;
    } 
    int i = 0;
    while (true) {
      if (i < j) {
        add(paramArraySet.valueAt(i));
        i++;
        continue;
      } 
      return;
    } 
  }
  
  public boolean addAll(Collection<? extends E> paramCollection) {
    ensureCapacity(this.mSize + paramCollection.size());
    boolean bool = false;
    Iterator<? extends E> iterator = paramCollection.iterator();
    while (iterator.hasNext())
      bool |= add(iterator.next()); 
    return bool;
  }
  
  public void append(E paramE) {
    int i;
    int j = this.mSize;
    if (paramE == null) {
      i = 0;
    } else if (this.mIdentityHashCode) {
      i = System.identityHashCode(paramE);
    } else {
      i = paramE.hashCode();
    } 
    if (j >= this.mHashes.length)
      throw new IllegalStateException("Array is full"); 
    if (j > 0 && this.mHashes[j - 1] > i) {
      add(paramE);
      return;
    } 
    this.mSize = j + 1;
    this.mHashes[j] = i;
    this.mArray[j] = paramE;
  }
  
  public void clear() {
    if (this.mSize != 0) {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = INT;
      this.mArray = OBJECT;
      this.mSize = 0;
    } 
  }
  
  public boolean contains(Object paramObject) {
    return (indexOf(paramObject) >= 0);
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    Iterator<?> iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      if (!contains(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public void ensureCapacity(int paramInt) {
    if (this.mHashes.length < paramInt) {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(paramInt);
      if (this.mSize > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, this.mSize);
      } 
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (this != paramObject) {
      if (paramObject instanceof Set) {
        paramObject = paramObject;
        if (size() != paramObject.size())
          return false; 
        int i = 0;
        try {
          while (true) {
            if (i < this.mSize) {
              boolean bool = paramObject.contains(valueAt(i));
              if (!bool)
                return false; 
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
      } 
      return false;
    } 
    return true;
  }
  
  public int hashCode() {
    int[] arrayOfInt = this.mHashes;
    int j = 0;
    int i = 0;
    int k = this.mSize;
    while (i < k) {
      j += arrayOfInt[i];
      i++;
    } 
    return j;
  }
  
  public int indexOf(Object paramObject) {
    if (paramObject == null)
      return indexOfNull(); 
    if (this.mIdentityHashCode) {
      int j = System.identityHashCode(paramObject);
      return indexOf(paramObject, j);
    } 
    int i = paramObject.hashCode();
    return indexOf(paramObject, i);
  }
  
  public boolean isEmpty() {
    return (this.mSize <= 0);
  }
  
  public Iterator<E> iterator() {
    return getCollection().getKeySet().iterator();
  }
  
  public boolean remove(Object paramObject) {
    int i = indexOf(paramObject);
    if (i >= 0) {
      removeAt(i);
      return true;
    } 
    return false;
  }
  
  public boolean removeAll(ArraySet<? extends E> paramArraySet) {
    int j = paramArraySet.mSize;
    int k = this.mSize;
    for (int i = 0; i < j; i++)
      remove(paramArraySet.valueAt(i)); 
    return (k != this.mSize);
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    boolean bool = false;
    Iterator<?> iterator = paramCollection.iterator();
    while (iterator.hasNext())
      bool |= remove(iterator.next()); 
    return bool;
  }
  
  public E removeAt(int paramInt) {
    int i = 8;
    Object object = this.mArray[paramInt];
    if (this.mSize <= 1) {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = INT;
      this.mArray = OBJECT;
      this.mSize = 0;
      return (E)object;
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
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, paramInt);
      } 
      if (paramInt < this.mSize) {
        System.arraycopy(arrayOfInt, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
        System.arraycopy(arrayOfObject, paramInt + 1, this.mArray, paramInt, this.mSize - paramInt);
        return (E)object;
      } 
      return (E)object;
    } 
    this.mSize--;
    if (paramInt < this.mSize) {
      System.arraycopy(this.mHashes, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
      System.arraycopy(this.mArray, paramInt + 1, this.mArray, paramInt, this.mSize - paramInt);
    } 
    this.mArray[this.mSize] = null;
    return (E)object;
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    boolean bool = false;
    for (int i = this.mSize - 1; i >= 0; i--) {
      if (!paramCollection.contains(this.mArray[i])) {
        removeAt(i);
        bool = true;
      } 
    } 
    return bool;
  }
  
  public int size() {
    return this.mSize;
  }
  
  public Object[] toArray() {
    Object[] arrayOfObject = new Object[this.mSize];
    System.arraycopy(this.mArray, 0, arrayOfObject, 0, this.mSize);
    return arrayOfObject;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    T[] arrayOfT = paramArrayOfT;
    if (paramArrayOfT.length < this.mSize)
      arrayOfT = (T[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.mSize); 
    System.arraycopy(this.mArray, 0, arrayOfT, 0, this.mSize);
    if (arrayOfT.length > this.mSize)
      arrayOfT[this.mSize] = null; 
    return arrayOfT;
  }
  
  public String toString() {
    if (isEmpty())
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(this.mSize * 14);
    stringBuilder.append('{');
    for (int i = 0; i < this.mSize; i++) {
      if (i > 0)
        stringBuilder.append(", "); 
      E e = valueAt(i);
      if (e != this) {
        stringBuilder.append(e);
      } else {
        stringBuilder.append("(this Set)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public E valueAt(int paramInt) {
    return (E)this.mArray[paramInt];
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v\\util\ArraySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */