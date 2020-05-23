package android.support.v4.os;

public final class CancellationSignal {
  private boolean mCancelInProgress;
  
  private Object mCancellationSignalObj;
  
  private boolean mIsCanceled;
  
  private OnCancelListener mOnCancelListener;
  
  private void waitForCancelFinishedLocked() {
    while (this.mCancelInProgress) {
      try {
        wait();
      } catch (InterruptedException interruptedException) {}
    } 
  }
  
  public void cancel() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mIsCanceled : Z
    //   6: ifeq -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield mIsCanceled : Z
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield mCancelInProgress : Z
    //   22: aload_0
    //   23: getfield mOnCancelListener : Landroid/support/v4/os/CancellationSignal$OnCancelListener;
    //   26: astore_1
    //   27: aload_0
    //   28: getfield mCancellationSignalObj : Ljava/lang/Object;
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: ifnull -> 44
    //   38: aload_1
    //   39: invokeinterface onCancel : ()V
    //   44: aload_2
    //   45: ifnull -> 52
    //   48: aload_2
    //   49: invokestatic cancel : (Ljava/lang/Object;)V
    //   52: aload_0
    //   53: monitorenter
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield mCancelInProgress : Z
    //   59: aload_0
    //   60: invokevirtual notifyAll : ()V
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: aload_0
    //   78: monitorenter
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield mCancelInProgress : Z
    //   84: aload_0
    //   85: invokevirtual notifyAll : ()V
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	71	finally
    //   12	34	71	finally
    //   38	44	76	finally
    //   48	52	76	finally
    //   54	65	66	finally
    //   67	69	66	finally
    //   72	74	71	finally
    //   79	90	92	finally
    //   93	95	92	finally
  }
  
  public Object getCancellationSignalObject() {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #16
    //   5: if_icmpge -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield mCancellationSignalObj : Ljava/lang/Object;
    //   16: ifnonnull -> 40
    //   19: aload_0
    //   20: invokestatic create : ()Ljava/lang/Object;
    //   23: putfield mCancellationSignalObj : Ljava/lang/Object;
    //   26: aload_0
    //   27: getfield mIsCanceled : Z
    //   30: ifeq -> 40
    //   33: aload_0
    //   34: getfield mCancellationSignalObj : Ljava/lang/Object;
    //   37: invokestatic cancel : (Ljava/lang/Object;)V
    //   40: aload_0
    //   41: getfield mCancellationSignalObj : Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   12	40	49	finally
    //   40	47	49	finally
    //   50	52	49	finally
  }
  
  public boolean isCanceled() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mIsCanceled : Z
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
    //   2	9	11	finally
    //   12	14	11	finally
  }
  
  public void setOnCancelListener(OnCancelListener paramOnCancelListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial waitForCancelFinishedLocked : ()V
    //   6: aload_0
    //   7: getfield mOnCancelListener : Landroid/support/v4/os/CancellationSignal$OnCancelListener;
    //   10: aload_1
    //   11: if_acmpne -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: aload_1
    //   19: putfield mOnCancelListener : Landroid/support/v4/os/CancellationSignal$OnCancelListener;
    //   22: aload_0
    //   23: getfield mIsCanceled : Z
    //   26: ifeq -> 33
    //   29: aload_1
    //   30: ifnonnull -> 41
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: invokeinterface onCancel : ()V
    //   49: return
    // Exception table:
    //   from	to	target	type
    //   2	16	36	finally
    //   17	29	36	finally
    //   33	35	36	finally
    //   37	39	36	finally
    //   41	43	36	finally
  }
  
  public void throwIfCanceled() {
    if (isCanceled())
      throw new OperationCanceledException(); 
  }
  
  public static interface OnCancelListener {
    void onCancel();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\os\CancellationSignal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */