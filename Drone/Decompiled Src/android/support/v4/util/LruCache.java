package android.support.v4.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
  private int createCount;
  
  private int evictionCount;
  
  private int hitCount;
  
  private final LinkedHashMap<K, V> map;
  
  private int maxSize;
  
  private int missCount;
  
  private int putCount;
  
  private int size;
  
  public LruCache(int paramInt) {
    if (paramInt <= 0)
      throw new IllegalArgumentException("maxSize <= 0"); 
    this.maxSize = paramInt;
    this.map = new LinkedHashMap<K, V>(0, 0.75F, true);
  }
  
  private int safeSizeOf(K paramK, V paramV) {
    int i = sizeOf(paramK, paramV);
    if (i < 0)
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV); 
    return i;
  }
  
  protected V create(K paramK) {
    return null;
  }
  
  public final int createCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield createCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final void evictAll() {
    trimToSize(-1);
  }
  
  public final int evictionCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield evictionCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final V get(K paramK) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 14
    //   4: new java/lang/NullPointerException
    //   7: dup
    //   8: ldc 'key == null'
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield map : Ljava/util/LinkedHashMap;
    //   20: aload_1
    //   21: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull -> 43
    //   29: aload_0
    //   30: aload_0
    //   31: getfield hitCount : I
    //   34: iconst_1
    //   35: iadd
    //   36: putfield hitCount : I
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: areturn
    //   43: aload_0
    //   44: aload_0
    //   45: getfield missCount : I
    //   48: iconst_1
    //   49: iadd
    //   50: putfield missCount : I
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual create : (Ljava/lang/Object;)Ljava/lang/Object;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnonnull -> 72
    //   65: aconst_null
    //   66: areturn
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: aload_0
    //   73: monitorenter
    //   74: aload_0
    //   75: aload_0
    //   76: getfield createCount : I
    //   79: iconst_1
    //   80: iadd
    //   81: putfield createCount : I
    //   84: aload_0
    //   85: getfield map : Ljava/util/LinkedHashMap;
    //   88: aload_1
    //   89: aload_2
    //   90: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: astore_3
    //   94: aload_3
    //   95: ifnull -> 124
    //   98: aload_0
    //   99: getfield map : Ljava/util/LinkedHashMap;
    //   102: aload_1
    //   103: aload_3
    //   104: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_3
    //   111: ifnull -> 147
    //   114: aload_0
    //   115: iconst_0
    //   116: aload_1
    //   117: aload_2
    //   118: aload_3
    //   119: invokevirtual entryRemoved : (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   122: aload_3
    //   123: areturn
    //   124: aload_0
    //   125: aload_0
    //   126: getfield size : I
    //   129: aload_0
    //   130: aload_1
    //   131: aload_2
    //   132: invokespecial safeSizeOf : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   135: iadd
    //   136: putfield size : I
    //   139: goto -> 108
    //   142: astore_1
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    //   147: aload_0
    //   148: aload_0
    //   149: getfield maxSize : I
    //   152: invokevirtual trimToSize : (I)V
    //   155: aload_2
    //   156: areturn
    // Exception table:
    //   from	to	target	type
    //   16	25	67	finally
    //   29	41	67	finally
    //   43	55	67	finally
    //   68	70	67	finally
    //   74	94	142	finally
    //   98	108	142	finally
    //   108	110	142	finally
    //   124	139	142	finally
    //   143	145	142	finally
  }
  
  public final int hitCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield hitCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final int maxSize() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield maxSize : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final int missCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield missCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final V put(K paramK, V paramV) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 8
    //   4: aload_2
    //   5: ifnonnull -> 18
    //   8: new java/lang/NullPointerException
    //   11: dup
    //   12: ldc 'key == null || value == null'
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_0
    //   19: monitorenter
    //   20: aload_0
    //   21: aload_0
    //   22: getfield putCount : I
    //   25: iconst_1
    //   26: iadd
    //   27: putfield putCount : I
    //   30: aload_0
    //   31: aload_0
    //   32: getfield size : I
    //   35: aload_0
    //   36: aload_1
    //   37: aload_2
    //   38: invokespecial safeSizeOf : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   41: iadd
    //   42: putfield size : I
    //   45: aload_0
    //   46: getfield map : Ljava/util/LinkedHashMap;
    //   49: aload_1
    //   50: aload_2
    //   51: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull -> 74
    //   59: aload_0
    //   60: aload_0
    //   61: getfield size : I
    //   64: aload_0
    //   65: aload_1
    //   66: aload_3
    //   67: invokespecial safeSizeOf : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   70: isub
    //   71: putfield size : I
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_3
    //   77: ifnull -> 88
    //   80: aload_0
    //   81: iconst_0
    //   82: aload_1
    //   83: aload_3
    //   84: aload_2
    //   85: invokevirtual entryRemoved : (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   88: aload_0
    //   89: aload_0
    //   90: getfield maxSize : I
    //   93: invokevirtual trimToSize : (I)V
    //   96: aload_3
    //   97: areturn
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Exception table:
    //   from	to	target	type
    //   20	55	98	finally
    //   59	74	98	finally
    //   74	76	98	finally
    //   99	101	98	finally
  }
  
  public final int putCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield putCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final V remove(K paramK) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 14
    //   4: new java/lang/NullPointerException
    //   7: dup
    //   8: ldc 'key == null'
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield map : Ljava/util/LinkedHashMap;
    //   20: aload_1
    //   21: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull -> 44
    //   29: aload_0
    //   30: aload_0
    //   31: getfield size : I
    //   34: aload_0
    //   35: aload_1
    //   36: aload_2
    //   37: invokespecial safeSizeOf : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   40: isub
    //   41: putfield size : I
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: ifnull -> 58
    //   50: aload_0
    //   51: iconst_0
    //   52: aload_1
    //   53: aload_2
    //   54: aconst_null
    //   55: invokevirtual entryRemoved : (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   58: aload_2
    //   59: areturn
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   16	25	60	finally
    //   29	44	60	finally
    //   44	46	60	finally
    //   61	63	60	finally
  }
  
  public void resize(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: ifgt -> 14
    //   4: new java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 'maxSize <= 0'
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: iload_1
    //   18: putfield maxSize : I
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_0
    //   24: iload_1
    //   25: invokevirtual trimToSize : (I)V
    //   28: return
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   16	23	29	finally
    //   30	32	29	finally
  }
  
  public final int size() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield size : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  protected int sizeOf(K paramK, V paramV) {
    return 1;
  }
  
  public final Map<K, V> snapshot() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/LinkedHashMap
    //   5: dup
    //   6: aload_0
    //   7: getfield map : Ljava/util/LinkedHashMap;
    //   10: invokespecial <init> : (Ljava/util/Map;)V
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	18	finally
  }
  
  public final String toString() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield hitCount : I
    //   8: aload_0
    //   9: getfield missCount : I
    //   12: iadd
    //   13: istore_2
    //   14: iload_2
    //   15: ifeq -> 28
    //   18: aload_0
    //   19: getfield hitCount : I
    //   22: bipush #100
    //   24: imul
    //   25: iload_2
    //   26: idiv
    //   27: istore_1
    //   28: ldc 'LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]'
    //   30: iconst_4
    //   31: anewarray java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_0
    //   37: getfield maxSize : I
    //   40: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_0
    //   47: getfield hitCount : I
    //   50: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: aload_0
    //   57: getfield missCount : I
    //   60: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   63: aastore
    //   64: dup
    //   65: iconst_3
    //   66: iload_1
    //   67: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   70: aastore
    //   71: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   74: astore_3
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_3
    //   78: areturn
    //   79: astore_3
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_3
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   4	14	79	finally
    //   18	28	79	finally
    //   28	75	79	finally
  }
  
  public void trimToSize(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield size : I
    //   6: iflt -> 26
    //   9: aload_0
    //   10: getfield map : Ljava/util/LinkedHashMap;
    //   13: invokevirtual isEmpty : ()Z
    //   16: ifeq -> 64
    //   19: aload_0
    //   20: getfield size : I
    //   23: ifeq -> 64
    //   26: new java/lang/IllegalStateException
    //   29: dup
    //   30: new java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: aload_0
    //   38: invokevirtual getClass : ()Ljava/lang/Class;
    //   41: invokevirtual getName : ()Ljava/lang/String;
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc '.sizeOf() is reporting inconsistent results!'
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual toString : ()Ljava/lang/String;
    //   55: invokespecial <init> : (Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield size : I
    //   68: iload_1
    //   69: if_icmple -> 82
    //   72: aload_0
    //   73: getfield map : Ljava/util/LinkedHashMap;
    //   76: invokevirtual isEmpty : ()Z
    //   79: ifeq -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield map : Ljava/util/LinkedHashMap;
    //   89: invokevirtual entrySet : ()Ljava/util/Set;
    //   92: invokeinterface iterator : ()Ljava/util/Iterator;
    //   97: invokeinterface next : ()Ljava/lang/Object;
    //   102: checkcast java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface getKey : ()Ljava/lang/Object;
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface getValue : ()Ljava/lang/Object;
    //   119: astore_3
    //   120: aload_0
    //   121: getfield map : Ljava/util/LinkedHashMap;
    //   124: aload_2
    //   125: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: aload_0
    //   131: getfield size : I
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokespecial safeSizeOf : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: isub
    //   141: putfield size : I
    //   144: aload_0
    //   145: aload_0
    //   146: getfield evictionCount : I
    //   149: iconst_1
    //   150: iadd
    //   151: putfield evictionCount : I
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_0
    //   157: iconst_1
    //   158: aload_2
    //   159: aload_3
    //   160: aconst_null
    //   161: invokevirtual entryRemoved : (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   164: goto -> 0
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   60	62	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   85	156	59	finally
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v\\util\LruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */