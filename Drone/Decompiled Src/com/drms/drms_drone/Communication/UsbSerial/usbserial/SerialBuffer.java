package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class SerialBuffer {
  public static final int DEFAULT_READ_BUFFER_SIZE = 16384;
  
  public static final int DEFAULT_WRITE_BUFFER_SIZE = 16384;
  
  private boolean debugging = false;
  
  private ByteBuffer readBuffer;
  
  private byte[] readBuffer_compatible;
  
  private SynchronizedBuffer writeBuffer = new SynchronizedBuffer();
  
  public SerialBuffer(boolean paramBoolean) {
    if (paramBoolean) {
      this.readBuffer = ByteBuffer.allocate(16384);
      return;
    } 
    this.readBuffer_compatible = new byte[16384];
  }
  
  public void clearReadBuffer() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readBuffer : Ljava/nio/ByteBuffer;
    //   6: invokevirtual clear : ()Ljava/nio/Buffer;
    //   9: pop
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	13	finally
    //   14	16	13	finally
  }
  
  public void debug(boolean paramBoolean) {
    this.debugging = paramBoolean;
  }
  
  public byte[] getBufferCompatible() {
    return this.readBuffer_compatible;
  }
  
  public byte[] getDataReceived() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readBuffer : Ljava/nio/ByteBuffer;
    //   6: invokevirtual position : ()I
    //   9: newarray byte
    //   11: astore_1
    //   12: aload_0
    //   13: getfield readBuffer : Ljava/nio/ByteBuffer;
    //   16: iconst_0
    //   17: invokevirtual position : (I)Ljava/nio/Buffer;
    //   20: pop
    //   21: aload_0
    //   22: getfield readBuffer : Ljava/nio/ByteBuffer;
    //   25: aload_1
    //   26: iconst_0
    //   27: aload_1
    //   28: arraylength
    //   29: invokevirtual get : ([BII)Ljava/nio/ByteBuffer;
    //   32: pop
    //   33: aload_0
    //   34: getfield debugging : Z
    //   37: ifeq -> 45
    //   40: aload_1
    //   41: iconst_1
    //   42: invokestatic printReadLogGet : ([BZ)V
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
    //   2	45	49	finally
    //   45	47	49	finally
    //   50	52	49	finally
  }
  
  public byte[] getDataReceivedCompatible(int paramInt) {
    return Arrays.copyOfRange(this.readBuffer_compatible, 0, paramInt);
  }
  
  public ByteBuffer getReadBuffer() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readBuffer : Ljava/nio/ByteBuffer;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	11	finally
    //   12	14	11	finally
  }
  
  public byte[] getWriteBuffer() {
    return this.writeBuffer.get();
  }
  
  public void putReadBuffer(ByteBuffer paramByteBuffer) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readBuffer : Ljava/nio/ByteBuffer;
    //   6: aload_1
    //   7: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   10: pop
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    //   19: astore_1
    //   20: goto -> 11
    // Exception table:
    //   from	to	target	type
    //   2	11	19	java/nio/BufferOverflowException
    //   2	11	14	finally
    //   11	13	14	finally
    //   15	17	14	finally
  }
  
  public void putWriteBuffer(byte[] paramArrayOfbyte) {
    this.writeBuffer.put(paramArrayOfbyte);
  }
  
  public void resetWriteBuffer() {
    this.writeBuffer.reset();
  }
  
  private class SynchronizedBuffer {
    private byte[] buffer = new byte[16384];
    
    private int position = -1;
    
    public byte[] get() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield position : I
      //   6: istore_1
      //   7: iload_1
      //   8: iconst_m1
      //   9: if_icmpne -> 16
      //   12: aload_0
      //   13: invokevirtual wait : ()V
      //   16: aload_0
      //   17: getfield buffer : [B
      //   20: iconst_0
      //   21: aload_0
      //   22: getfield position : I
      //   25: invokestatic copyOfRange : ([BII)[B
      //   28: astore_2
      //   29: aload_0
      //   30: getfield this$0 : Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;
      //   33: invokestatic access$000 : (Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;)Z
      //   36: ifeq -> 44
      //   39: aload_2
      //   40: iconst_1
      //   41: invokestatic printLogGet : ([BZ)V
      //   44: aload_0
      //   45: iconst_m1
      //   46: putfield position : I
      //   49: aload_0
      //   50: monitorexit
      //   51: aload_2
      //   52: areturn
      //   53: astore_2
      //   54: aload_2
      //   55: invokevirtual printStackTrace : ()V
      //   58: goto -> 16
      //   61: astore_2
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_2
      //   65: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	61	finally
      //   12	16	53	java/lang/InterruptedException
      //   12	16	61	finally
      //   16	44	61	finally
      //   44	49	61	finally
      //   54	58	61	finally
    }
    
    public void put(byte[] param1ArrayOfbyte) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield position : I
      //   6: iconst_m1
      //   7: if_icmpne -> 15
      //   10: aload_0
      //   11: iconst_0
      //   12: putfield position : I
      //   15: aload_0
      //   16: getfield this$0 : Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;
      //   19: invokestatic access$000 : (Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;)Z
      //   22: ifeq -> 30
      //   25: aload_1
      //   26: iconst_1
      //   27: invokestatic printLogPut : ([BZ)V
      //   30: aload_0
      //   31: getfield position : I
      //   34: aload_1
      //   35: arraylength
      //   36: iadd
      //   37: sipush #16383
      //   40: if_icmple -> 88
      //   43: aload_0
      //   44: getfield position : I
      //   47: sipush #16384
      //   50: if_icmpge -> 74
      //   53: aload_1
      //   54: iconst_0
      //   55: aload_0
      //   56: getfield buffer : [B
      //   59: aload_0
      //   60: getfield position : I
      //   63: sipush #16384
      //   66: aload_0
      //   67: getfield position : I
      //   70: isub
      //   71: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
      //   74: aload_0
      //   75: sipush #16384
      //   78: putfield position : I
      //   81: aload_0
      //   82: invokevirtual notify : ()V
      //   85: aload_0
      //   86: monitorexit
      //   87: return
      //   88: aload_1
      //   89: iconst_0
      //   90: aload_0
      //   91: getfield buffer : [B
      //   94: aload_0
      //   95: getfield position : I
      //   98: aload_1
      //   99: arraylength
      //   100: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
      //   103: aload_0
      //   104: aload_0
      //   105: getfield position : I
      //   108: aload_1
      //   109: arraylength
      //   110: iadd
      //   111: putfield position : I
      //   114: aload_0
      //   115: invokevirtual notify : ()V
      //   118: goto -> 85
      //   121: astore_1
      //   122: aload_0
      //   123: monitorexit
      //   124: aload_1
      //   125: athrow
      // Exception table:
      //   from	to	target	type
      //   2	15	121	finally
      //   15	30	121	finally
      //   30	74	121	finally
      //   74	85	121	finally
      //   88	118	121	finally
    }
    
    public void reset() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_m1
      //   4: putfield position : I
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_1
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_1
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	10	finally
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\SerialBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */