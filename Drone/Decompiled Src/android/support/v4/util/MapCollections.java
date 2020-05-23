package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class MapCollections<K, V> {
  EntrySet mEntrySet;
  
  KeySet mKeySet;
  
  ValuesCollection mValues;
  
  public static <K, V> boolean containsAllHelper(Map<K, V> paramMap, Collection<?> paramCollection) {
    Iterator<?> iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      if (!paramMap.containsKey(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public static <T> boolean equalsSetHelper(Set<T> paramSet, Object paramObject) {
    boolean bool1 = true;
    boolean bool = false;
    if (paramSet == paramObject)
      return true; 
    if (paramObject instanceof Set) {
      paramObject = paramObject;
      try {
        if (paramSet.size() == paramObject.size()) {
          bool = paramSet.containsAll((Collection<?>)paramObject);
          if (bool)
            return bool1; 
        } 
        return false;
      } catch (NullPointerException nullPointerException) {
        return false;
      } catch (ClassCastException classCastException) {
        return false;
      } 
    } 
    return bool;
  }
  
  public static <K, V> boolean removeAllHelper(Map<K, V> paramMap, Collection<?> paramCollection) {
    int i = paramMap.size();
    Iterator<?> iterator = paramCollection.iterator();
    while (iterator.hasNext())
      paramMap.remove(iterator.next()); 
    return (i != paramMap.size());
  }
  
  public static <K, V> boolean retainAllHelper(Map<K, V> paramMap, Collection<?> paramCollection) {
    int i = paramMap.size();
    Iterator iterator = paramMap.keySet().iterator();
    while (iterator.hasNext()) {
      if (!paramCollection.contains(iterator.next()))
        iterator.remove(); 
    } 
    return (i != paramMap.size());
  }
  
  protected abstract void colClear();
  
  protected abstract Object colGetEntry(int paramInt1, int paramInt2);
  
  protected abstract Map<K, V> colGetMap();
  
  protected abstract int colGetSize();
  
  protected abstract int colIndexOfKey(Object paramObject);
  
  protected abstract int colIndexOfValue(Object paramObject);
  
  protected abstract void colPut(K paramK, V paramV);
  
  protected abstract void colRemoveAt(int paramInt);
  
  protected abstract V colSetValue(int paramInt, V paramV);
  
  public Set<Map.Entry<K, V>> getEntrySet() {
    if (this.mEntrySet == null)
      this.mEntrySet = new EntrySet(); 
    return this.mEntrySet;
  }
  
  public Set<K> getKeySet() {
    if (this.mKeySet == null)
      this.mKeySet = new KeySet(); 
    return this.mKeySet;
  }
  
  public Collection<V> getValues() {
    if (this.mValues == null)
      this.mValues = new ValuesCollection(); 
    return this.mValues;
  }
  
  public Object[] toArrayHelper(int paramInt) {
    int j = colGetSize();
    Object[] arrayOfObject = new Object[j];
    for (int i = 0; i < j; i++)
      arrayOfObject[i] = colGetEntry(i, paramInt); 
    return arrayOfObject;
  }
  
  public <T> T[] toArrayHelper(T[] paramArrayOfT, int paramInt) {
    int j = colGetSize();
    T[] arrayOfT = paramArrayOfT;
    if (paramArrayOfT.length < j)
      arrayOfT = (T[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j); 
    for (int i = 0; i < j; i++)
      arrayOfT[i] = (T)colGetEntry(i, paramInt); 
    if (arrayOfT.length > j)
      arrayOfT[j] = null; 
    return arrayOfT;
  }
  
  final class ArrayIterator<T> implements Iterator<T> {
    boolean mCanRemove = false;
    
    int mIndex;
    
    final int mOffset;
    
    int mSize;
    
    ArrayIterator(int param1Int) {
      this.mOffset = param1Int;
      this.mSize = MapCollections.this.colGetSize();
    }
    
    public boolean hasNext() {
      return (this.mIndex < this.mSize);
    }
    
    public T next() {
      Object object = MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
      this.mIndex++;
      this.mCanRemove = true;
      return (T)object;
    }
    
    public void remove() {
      if (!this.mCanRemove)
        throw new IllegalStateException(); 
      this.mIndex--;
      this.mSize--;
      this.mCanRemove = false;
      MapCollections.this.colRemoveAt(this.mIndex);
    }
  }
  
  final class EntrySet implements Set<Map.Entry<K, V>> {
    public boolean add(Map.Entry<K, V> param1Entry) {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends Map.Entry<K, V>> param1Collection) {
      int i = MapCollections.this.colGetSize();
      for (Map.Entry<K, V> entry : param1Collection)
        MapCollections.this.colPut(entry.getKey(), entry.getValue()); 
      return (i != MapCollections.this.colGetSize());
    }
    
    public void clear() {
      MapCollections.this.colClear();
    }
    
    public boolean contains(Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        int i = MapCollections.this.colIndexOfKey(param1Object.getKey());
        if (i >= 0)
          return ContainerHelpers.equal(MapCollections.this.colGetEntry(i, 1), param1Object.getValue()); 
      } 
      return false;
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      Iterator<?> iterator = param1Collection.iterator();
      while (iterator.hasNext()) {
        if (!contains(iterator.next()))
          return false; 
      } 
      return true;
    }
    
    public boolean equals(Object param1Object) {
      return MapCollections.equalsSetHelper(this, param1Object);
    }
    
    public int hashCode() {
      int j = 0;
      for (int i = MapCollections.this.colGetSize() - 1; i >= 0; i--) {
        int k;
        int m;
        Object object1 = MapCollections.this.colGetEntry(i, 0);
        Object object2 = MapCollections.this.colGetEntry(i, 1);
        if (object1 == null) {
          k = 0;
        } else {
          k = object1.hashCode();
        } 
        if (object2 == null) {
          m = 0;
        } else {
          m = object2.hashCode();
        } 
        j += m ^ k;
      } 
      return j;
    }
    
    public boolean isEmpty() {
      return (MapCollections.this.colGetSize() == 0);
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new MapCollections.MapIterator();
    }
    
    public boolean remove(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public int size() {
      return MapCollections.this.colGetSize();
    }
    
    public Object[] toArray() {
      throw new UnsupportedOperationException();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      throw new UnsupportedOperationException();
    }
  }
  
  final class KeySet implements Set<K> {
    public boolean add(K param1K) {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends K> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public void clear() {
      MapCollections.this.colClear();
    }
    
    public boolean contains(Object param1Object) {
      return (MapCollections.this.colIndexOfKey(param1Object) >= 0);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return MapCollections.containsAllHelper(MapCollections.this.colGetMap(), param1Collection);
    }
    
    public boolean equals(Object param1Object) {
      return MapCollections.equalsSetHelper(this, param1Object);
    }
    
    public int hashCode() {
      int j = 0;
      for (int i = MapCollections.this.colGetSize() - 1; i >= 0; i--) {
        int k;
        Object object = MapCollections.this.colGetEntry(i, 0);
        if (object == null) {
          k = 0;
        } else {
          k = object.hashCode();
        } 
        j += k;
      } 
      return j;
    }
    
    public boolean isEmpty() {
      return (MapCollections.this.colGetSize() == 0);
    }
    
    public Iterator<K> iterator() {
      return new MapCollections.ArrayIterator<K>(0);
    }
    
    public boolean remove(Object param1Object) {
      int i = MapCollections.this.colIndexOfKey(param1Object);
      if (i >= 0) {
        MapCollections.this.colRemoveAt(i);
        return true;
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return MapCollections.removeAllHelper(MapCollections.this.colGetMap(), param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return MapCollections.retainAllHelper(MapCollections.this.colGetMap(), param1Collection);
    }
    
    public int size() {
      return MapCollections.this.colGetSize();
    }
    
    public Object[] toArray() {
      return MapCollections.this.toArrayHelper(0);
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])MapCollections.this.toArrayHelper((Object[])param1ArrayOfT, 0);
    }
  }
  
  final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
    int mEnd = MapCollections.this.colGetSize() - 1;
    
    boolean mEntryValid = false;
    
    int mIndex = -1;
    
    public final boolean equals(Object param1Object) {
      boolean bool = true;
      if (!this.mEntryValid)
        throw new IllegalStateException("This container does not support retaining Map.Entry objects"); 
      if (!(param1Object instanceof Map.Entry))
        return false; 
      param1Object = param1Object;
      if (!ContainerHelpers.equal(param1Object.getKey(), MapCollections.this.colGetEntry(this.mIndex, 0)) || !ContainerHelpers.equal(param1Object.getValue(), MapCollections.this.colGetEntry(this.mIndex, 1)))
        bool = false; 
      return bool;
    }
    
    public K getKey() {
      if (!this.mEntryValid)
        throw new IllegalStateException("This container does not support retaining Map.Entry objects"); 
      return (K)MapCollections.this.colGetEntry(this.mIndex, 0);
    }
    
    public V getValue() {
      if (!this.mEntryValid)
        throw new IllegalStateException("This container does not support retaining Map.Entry objects"); 
      return (V)MapCollections.this.colGetEntry(this.mIndex, 1);
    }
    
    public boolean hasNext() {
      return (this.mIndex < this.mEnd);
    }
    
    public final int hashCode() {
      int i;
      int j = 0;
      if (!this.mEntryValid)
        throw new IllegalStateException("This container does not support retaining Map.Entry objects"); 
      Object object1 = MapCollections.this.colGetEntry(this.mIndex, 0);
      Object object2 = MapCollections.this.colGetEntry(this.mIndex, 1);
      if (object1 == null) {
        i = 0;
      } else {
        i = object1.hashCode();
      } 
      if (object2 != null)
        j = object2.hashCode(); 
      return j ^ i;
    }
    
    public Map.Entry<K, V> next() {
      this.mIndex++;
      this.mEntryValid = true;
      return this;
    }
    
    public void remove() {
      if (!this.mEntryValid)
        throw new IllegalStateException(); 
      MapCollections.this.colRemoveAt(this.mIndex);
      this.mIndex--;
      this.mEnd--;
      this.mEntryValid = false;
    }
    
    public V setValue(V param1V) {
      if (!this.mEntryValid)
        throw new IllegalStateException("This container does not support retaining Map.Entry objects"); 
      return (V)MapCollections.this.colSetValue(this.mIndex, param1V);
    }
    
    public final String toString() {
      return (new StringBuilder()).append(getKey()).append("=").append(getValue()).toString();
    }
  }
  
  final class ValuesCollection implements Collection<V> {
    public boolean add(V param1V) {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends V> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public void clear() {
      MapCollections.this.colClear();
    }
    
    public boolean contains(Object param1Object) {
      return (MapCollections.this.colIndexOfValue(param1Object) >= 0);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      Iterator<?> iterator = param1Collection.iterator();
      while (iterator.hasNext()) {
        if (!contains(iterator.next()))
          return false; 
      } 
      return true;
    }
    
    public boolean isEmpty() {
      return (MapCollections.this.colGetSize() == 0);
    }
    
    public Iterator<V> iterator() {
      return new MapCollections.ArrayIterator<V>(1);
    }
    
    public boolean remove(Object param1Object) {
      int i = MapCollections.this.colIndexOfValue(param1Object);
      if (i >= 0) {
        MapCollections.this.colRemoveAt(i);
        return true;
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      int j = MapCollections.this.colGetSize();
      boolean bool = false;
      int i = 0;
      while (i < j) {
        int k = j;
        int m = i;
        if (param1Collection.contains(MapCollections.this.colGetEntry(i, 1))) {
          MapCollections.this.colRemoveAt(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        } 
        i = m + 1;
        j = k;
      } 
      return bool;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      int j = MapCollections.this.colGetSize();
      boolean bool = false;
      int i = 0;
      while (i < j) {
        int k = j;
        int m = i;
        if (!param1Collection.contains(MapCollections.this.colGetEntry(i, 1))) {
          MapCollections.this.colRemoveAt(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        } 
        i = m + 1;
        j = k;
      } 
      return bool;
    }
    
    public int size() {
      return MapCollections.this.colGetSize();
    }
    
    public Object[] toArray() {
      return MapCollections.this.toArrayHelper(1);
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])MapCollections.this.toArrayHelper((Object[])param1ArrayOfT, 1);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v\\util\MapCollections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */