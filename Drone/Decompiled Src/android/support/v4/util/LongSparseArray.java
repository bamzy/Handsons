package android.support.v4.util;

public class LongSparseArray<E> implements Cloneable {
  private static final Object DELETED = new Object();
  
  private boolean mGarbage = false;
  
  private long[] mKeys;
  
  private int mSize;
  
  private Object[] mValues;
  
  public LongSparseArray() {
    this(10);
  }
  
  public LongSparseArray(int paramInt) {
    if (paramInt == 0) {
      this.mKeys = ContainerHelpers.EMPTY_LONGS;
      this.mValues = ContainerHelpers.EMPTY_OBJECTS;
    } else {
      paramInt = ContainerHelpers.idealLongArraySize(paramInt);
      this.mKeys = new long[paramInt];
      this.mValues = new Object[paramInt];
    } 
    this.mSize = 0;
  }
  
  private void gc() {
    int k = this.mSize;
    int j = 0;
    long[] arrayOfLong = this.mKeys;
    Object[] arrayOfObject = this.mValues;
    int i = 0;
    while (i < k) {
      Object object = arrayOfObject[i];
      int m = j;
      if (object != DELETED) {
        if (i != j) {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = object;
          arrayOfObject[i] = null;
        } 
        m = j + 1;
      } 
      i++;
      j = m;
    } 
    this.mGarbage = false;
    this.mSize = j;
  }
  
  public void append(long paramLong, E paramE) {
    if (this.mSize != 0 && paramLong <= this.mKeys[this.mSize - 1]) {
      put(paramLong, paramE);
      return;
    } 
    if (this.mGarbage && this.mSize >= this.mKeys.length)
      gc(); 
    int i = this.mSize;
    if (i >= this.mKeys.length) {
      int j = ContainerHelpers.idealLongArraySize(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
      System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
      this.mKeys = arrayOfLong;
      this.mValues = arrayOfObject;
    } 
    this.mKeys[i] = paramLong;
    this.mValues[i] = paramE;
    this.mSize = i + 1;
  }
  
  public void clear() {
    int j = this.mSize;
    Object[] arrayOfObject = this.mValues;
    for (int i = 0; i < j; i++)
      arrayOfObject[i] = null; 
    this.mSize = 0;
    this.mGarbage = false;
  }
  
  public LongSparseArray<E> clone() {
    LongSparseArray<E> longSparseArray = null;
    try {
      LongSparseArray<E> longSparseArray1 = (LongSparseArray)super.clone();
      longSparseArray = longSparseArray1;
      longSparseArray1.mKeys = (long[])this.mKeys.clone();
      longSparseArray = longSparseArray1;
      longSparseArray1.mValues = (Object[])this.mValues.clone();
      return longSparseArray1;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return longSparseArray;
    } 
  }
  
  public void delete(long paramLong) {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if (i >= 0 && this.mValues[i] != DELETED) {
      this.mValues[i] = DELETED;
      this.mGarbage = true;
    } 
  }
  
  public E get(long paramLong) {
    return get(paramLong, null);
  }
  
  public E get(long paramLong, E paramE) {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    return (E)((i < 0 || this.mValues[i] == DELETED) ? (Object)paramE : this.mValues[i]);
  }
  
  public int indexOfKey(long paramLong) {
    if (this.mGarbage)
      gc(); 
    return ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
  }
  
  public int indexOfValue(E paramE) {
    if (this.mGarbage)
      gc(); 
    for (int i = 0; i < this.mSize; i++) {
      if (this.mValues[i] == paramE)
        return i; 
    } 
    return -1;
  }
  
  public long keyAt(int paramInt) {
    if (this.mGarbage)
      gc(); 
    return this.mKeys[paramInt];
  }
  
  public void put(long paramLong, E paramE) {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if (i >= 0) {
      this.mValues[i] = paramE;
      return;
    } 
    int j = i ^ 0xFFFFFFFF;
    if (j < this.mSize && this.mValues[j] == DELETED) {
      this.mKeys[j] = paramLong;
      this.mValues[j] = paramE;
      return;
    } 
    i = j;
    if (this.mGarbage) {
      i = j;
      if (this.mSize >= this.mKeys.length) {
        gc();
        i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong) ^ 0xFFFFFFFF;
      } 
    } 
    if (this.mSize >= this.mKeys.length) {
      j = ContainerHelpers.idealLongArraySize(this.mSize + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
      System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
      this.mKeys = arrayOfLong;
      this.mValues = arrayOfObject;
    } 
    if (this.mSize - i != 0) {
      System.arraycopy(this.mKeys, i, this.mKeys, i + 1, this.mSize - i);
      System.arraycopy(this.mValues, i, this.mValues, i + 1, this.mSize - i);
    } 
    this.mKeys[i] = paramLong;
    this.mValues[i] = paramE;
    this.mSize++;
  }
  
  public void remove(long paramLong) {
    delete(paramLong);
  }
  
  public void removeAt(int paramInt) {
    if (this.mValues[paramInt] != DELETED) {
      this.mValues[paramInt] = DELETED;
      this.mGarbage = true;
    } 
  }
  
  public void setValueAt(int paramInt, E paramE) {
    if (this.mGarbage)
      gc(); 
    this.mValues[paramInt] = paramE;
  }
  
  public int size() {
    if (this.mGarbage)
      gc(); 
    return this.mSize;
  }
  
  public String toString() {
    if (size() <= 0)
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
    stringBuilder.append('{');
    for (int i = 0; i < this.mSize; i++) {
      if (i > 0)
        stringBuilder.append(", "); 
      stringBuilder.append(keyAt(i));
      stringBuilder.append('=');
      E e = valueAt(i);
      if (e != this) {
        stringBuilder.append(e);
      } else {
        stringBuilder.append("(this Map)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public E valueAt(int paramInt) {
    if (this.mGarbage)
      gc(); 
    return (E)this.mValues[paramInt];
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v\\util\LongSparseArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */