package android.support.v4.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;

@RequiresApi(9)
class PaintCompatGingerbread {
  private static final String TOFU_STRING = "󟿽";
  
  private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = new ThreadLocal<Pair<Rect, Rect>>();
  
  static boolean hasGlyph(@NonNull Paint paramPaint, @NonNull String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #9
    //   3: aload_1
    //   4: invokevirtual length : ()I
    //   7: istore #6
    //   9: iload #6
    //   11: iconst_1
    //   12: if_icmpne -> 32
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual charAt : (I)C
    //   20: invokestatic isWhitespace : (C)Z
    //   23: ifeq -> 32
    //   26: iconst_1
    //   27: istore #8
    //   29: iload #8
    //   31: ireturn
    //   32: aload_0
    //   33: ldc '󟿽'
    //   35: invokevirtual measureText : (Ljava/lang/String;)F
    //   38: fstore_3
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual measureText : (Ljava/lang/String;)F
    //   44: fstore #4
    //   46: iload #9
    //   48: istore #8
    //   50: fload #4
    //   52: fconst_0
    //   53: fcmpl
    //   54: ifeq -> 29
    //   57: aload_1
    //   58: iconst_0
    //   59: aload_1
    //   60: invokevirtual length : ()I
    //   63: invokevirtual codePointCount : (II)I
    //   66: iconst_1
    //   67: if_icmple -> 142
    //   70: iload #9
    //   72: istore #8
    //   74: fload #4
    //   76: fconst_2
    //   77: fload_3
    //   78: fmul
    //   79: fcmpl
    //   80: ifgt -> 29
    //   83: fconst_0
    //   84: fstore_2
    //   85: iconst_0
    //   86: istore #5
    //   88: iload #5
    //   90: iload #6
    //   92: if_icmpge -> 131
    //   95: aload_1
    //   96: iload #5
    //   98: invokevirtual codePointAt : (I)I
    //   101: invokestatic charCount : (I)I
    //   104: istore #7
    //   106: fload_2
    //   107: aload_0
    //   108: aload_1
    //   109: iload #5
    //   111: iload #5
    //   113: iload #7
    //   115: iadd
    //   116: invokevirtual measureText : (Ljava/lang/String;II)F
    //   119: fadd
    //   120: fstore_2
    //   121: iload #5
    //   123: iload #7
    //   125: iadd
    //   126: istore #5
    //   128: goto -> 88
    //   131: iload #9
    //   133: istore #8
    //   135: fload #4
    //   137: fload_2
    //   138: fcmpl
    //   139: ifge -> 29
    //   142: fload #4
    //   144: fload_3
    //   145: fcmpl
    //   146: ifeq -> 151
    //   149: iconst_1
    //   150: ireturn
    //   151: invokestatic obtainEmptyRects : ()Landroid/support/v4/util/Pair;
    //   154: astore #10
    //   156: aload_0
    //   157: ldc '󟿽'
    //   159: iconst_0
    //   160: ldc '󟿽'
    //   162: invokevirtual length : ()I
    //   165: aload #10
    //   167: getfield first : Ljava/lang/Object;
    //   170: checkcast android/graphics/Rect
    //   173: invokevirtual getTextBounds : (Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   176: aload_0
    //   177: aload_1
    //   178: iconst_0
    //   179: iload #6
    //   181: aload #10
    //   183: getfield second : Ljava/lang/Object;
    //   186: checkcast android/graphics/Rect
    //   189: invokevirtual getTextBounds : (Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   192: aload #10
    //   194: getfield first : Ljava/lang/Object;
    //   197: checkcast android/graphics/Rect
    //   200: aload #10
    //   202: getfield second : Ljava/lang/Object;
    //   205: invokevirtual equals : (Ljava/lang/Object;)Z
    //   208: ifne -> 217
    //   211: iconst_1
    //   212: istore #8
    //   214: iload #8
    //   216: ireturn
    //   217: iconst_0
    //   218: istore #8
    //   220: goto -> 214
  }
  
  private static Pair<Rect, Rect> obtainEmptyRects() {
    Pair<Rect, Rect> pair = sRectThreadLocal.get();
    if (pair == null) {
      pair = new Pair(new Rect(), new Rect());
      sRectThreadLocal.set(pair);
      return pair;
    } 
    ((Rect)pair.first).setEmpty();
    ((Rect)pair.second).setEmpty();
    return pair;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\graphics\PaintCompatGingerbread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */