package android.support.constraint.solver;

public class ArrayLinkedVariables {
  private static final boolean DEBUG = false;
  
  private static final int NONE = -1;
  
  private int ROW_SIZE = 8;
  
  private SolverVariable candidate = null;
  
  int currentSize = 0;
  
  private int[] mArrayIndices = new int[this.ROW_SIZE];
  
  private int[] mArrayNextIndices = new int[this.ROW_SIZE];
  
  private float[] mArrayValues = new float[this.ROW_SIZE];
  
  private final Cache mCache;
  
  private boolean mDidFillOnce = false;
  
  private int mHead = -1;
  
  private int mLast = -1;
  
  private final ArrayRow mRow;
  
  ArrayLinkedVariables(ArrayRow paramArrayRow, Cache paramCache) {
    this.mRow = paramArrayRow;
    this.mCache = paramCache;
  }
  
  public final void add(SolverVariable paramSolverVariable, float paramFloat) {
    // Byte code:
    //   0: fload_2
    //   1: fconst_0
    //   2: fcmpl
    //   3: ifne -> 7
    //   6: return
    //   7: aload_0
    //   8: getfield mHead : I
    //   11: iconst_m1
    //   12: if_icmpne -> 81
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield mHead : I
    //   20: aload_0
    //   21: getfield mArrayValues : [F
    //   24: aload_0
    //   25: getfield mHead : I
    //   28: fload_2
    //   29: fastore
    //   30: aload_0
    //   31: getfield mArrayIndices : [I
    //   34: aload_0
    //   35: getfield mHead : I
    //   38: aload_1
    //   39: getfield id : I
    //   42: iastore
    //   43: aload_0
    //   44: getfield mArrayNextIndices : [I
    //   47: aload_0
    //   48: getfield mHead : I
    //   51: iconst_m1
    //   52: iastore
    //   53: aload_0
    //   54: aload_0
    //   55: getfield currentSize : I
    //   58: iconst_1
    //   59: iadd
    //   60: putfield currentSize : I
    //   63: aload_0
    //   64: getfield mDidFillOnce : Z
    //   67: ifne -> 6
    //   70: aload_0
    //   71: aload_0
    //   72: getfield mLast : I
    //   75: iconst_1
    //   76: iadd
    //   77: putfield mLast : I
    //   80: return
    //   81: aload_0
    //   82: getfield mHead : I
    //   85: istore_3
    //   86: iconst_m1
    //   87: istore #6
    //   89: iconst_0
    //   90: istore #4
    //   92: iload_3
    //   93: iconst_m1
    //   94: if_icmpeq -> 253
    //   97: iload #4
    //   99: aload_0
    //   100: getfield currentSize : I
    //   103: if_icmpge -> 253
    //   106: aload_0
    //   107: getfield mArrayIndices : [I
    //   110: iload_3
    //   111: iaload
    //   112: istore #5
    //   114: iload #5
    //   116: aload_1
    //   117: getfield id : I
    //   120: if_icmpne -> 221
    //   123: aload_0
    //   124: getfield mArrayValues : [F
    //   127: astore_1
    //   128: aload_1
    //   129: iload_3
    //   130: aload_1
    //   131: iload_3
    //   132: faload
    //   133: fload_2
    //   134: fadd
    //   135: fastore
    //   136: aload_0
    //   137: getfield mArrayValues : [F
    //   140: iload_3
    //   141: faload
    //   142: fconst_0
    //   143: fcmpl
    //   144: ifne -> 6
    //   147: iload_3
    //   148: aload_0
    //   149: getfield mHead : I
    //   152: if_icmpne -> 205
    //   155: aload_0
    //   156: aload_0
    //   157: getfield mArrayNextIndices : [I
    //   160: iload_3
    //   161: iaload
    //   162: putfield mHead : I
    //   165: aload_0
    //   166: getfield mCache : Landroid/support/constraint/solver/Cache;
    //   169: getfield mIndexedVariables : [Landroid/support/constraint/solver/SolverVariable;
    //   172: iload #5
    //   174: aaload
    //   175: aload_0
    //   176: getfield mRow : Landroid/support/constraint/solver/ArrayRow;
    //   179: invokevirtual removeClientEquation : (Landroid/support/constraint/solver/ArrayRow;)V
    //   182: aload_0
    //   183: getfield mDidFillOnce : Z
    //   186: ifeq -> 194
    //   189: aload_0
    //   190: iload_3
    //   191: putfield mLast : I
    //   194: aload_0
    //   195: aload_0
    //   196: getfield currentSize : I
    //   199: iconst_1
    //   200: isub
    //   201: putfield currentSize : I
    //   204: return
    //   205: aload_0
    //   206: getfield mArrayNextIndices : [I
    //   209: iload #6
    //   211: aload_0
    //   212: getfield mArrayNextIndices : [I
    //   215: iload_3
    //   216: iaload
    //   217: iastore
    //   218: goto -> 165
    //   221: aload_0
    //   222: getfield mArrayIndices : [I
    //   225: iload_3
    //   226: iaload
    //   227: aload_1
    //   228: getfield id : I
    //   231: if_icmpge -> 237
    //   234: iload_3
    //   235: istore #6
    //   237: aload_0
    //   238: getfield mArrayNextIndices : [I
    //   241: iload_3
    //   242: iaload
    //   243: istore_3
    //   244: iload #4
    //   246: iconst_1
    //   247: iadd
    //   248: istore #4
    //   250: goto -> 92
    //   253: aload_0
    //   254: getfield mLast : I
    //   257: iconst_1
    //   258: iadd
    //   259: istore_3
    //   260: aload_0
    //   261: getfield mDidFillOnce : Z
    //   264: ifeq -> 285
    //   267: aload_0
    //   268: getfield mArrayIndices : [I
    //   271: aload_0
    //   272: getfield mLast : I
    //   275: iaload
    //   276: iconst_m1
    //   277: if_icmpne -> 529
    //   280: aload_0
    //   281: getfield mLast : I
    //   284: istore_3
    //   285: iload_3
    //   286: istore #4
    //   288: iload_3
    //   289: aload_0
    //   290: getfield mArrayIndices : [I
    //   293: arraylength
    //   294: if_icmplt -> 343
    //   297: iload_3
    //   298: istore #4
    //   300: aload_0
    //   301: getfield currentSize : I
    //   304: aload_0
    //   305: getfield mArrayIndices : [I
    //   308: arraylength
    //   309: if_icmpge -> 343
    //   312: iconst_0
    //   313: istore #5
    //   315: iload_3
    //   316: istore #4
    //   318: iload #5
    //   320: aload_0
    //   321: getfield mArrayIndices : [I
    //   324: arraylength
    //   325: if_icmpge -> 343
    //   328: aload_0
    //   329: getfield mArrayIndices : [I
    //   332: iload #5
    //   334: iaload
    //   335: iconst_m1
    //   336: if_icmpne -> 538
    //   339: iload #5
    //   341: istore #4
    //   343: iload #4
    //   345: istore_3
    //   346: iload #4
    //   348: aload_0
    //   349: getfield mArrayIndices : [I
    //   352: arraylength
    //   353: if_icmplt -> 429
    //   356: aload_0
    //   357: getfield mArrayIndices : [I
    //   360: arraylength
    //   361: istore_3
    //   362: aload_0
    //   363: aload_0
    //   364: getfield ROW_SIZE : I
    //   367: iconst_2
    //   368: imul
    //   369: putfield ROW_SIZE : I
    //   372: aload_0
    //   373: iconst_0
    //   374: putfield mDidFillOnce : Z
    //   377: aload_0
    //   378: iload_3
    //   379: iconst_1
    //   380: isub
    //   381: putfield mLast : I
    //   384: aload_0
    //   385: aload_0
    //   386: getfield mArrayValues : [F
    //   389: aload_0
    //   390: getfield ROW_SIZE : I
    //   393: invokestatic copyOf : ([FI)[F
    //   396: putfield mArrayValues : [F
    //   399: aload_0
    //   400: aload_0
    //   401: getfield mArrayIndices : [I
    //   404: aload_0
    //   405: getfield ROW_SIZE : I
    //   408: invokestatic copyOf : ([II)[I
    //   411: putfield mArrayIndices : [I
    //   414: aload_0
    //   415: aload_0
    //   416: getfield mArrayNextIndices : [I
    //   419: aload_0
    //   420: getfield ROW_SIZE : I
    //   423: invokestatic copyOf : ([II)[I
    //   426: putfield mArrayNextIndices : [I
    //   429: aload_0
    //   430: getfield mArrayIndices : [I
    //   433: iload_3
    //   434: aload_1
    //   435: getfield id : I
    //   438: iastore
    //   439: aload_0
    //   440: getfield mArrayValues : [F
    //   443: iload_3
    //   444: fload_2
    //   445: fastore
    //   446: iload #6
    //   448: iconst_m1
    //   449: if_icmpeq -> 547
    //   452: aload_0
    //   453: getfield mArrayNextIndices : [I
    //   456: iload_3
    //   457: aload_0
    //   458: getfield mArrayNextIndices : [I
    //   461: iload #6
    //   463: iaload
    //   464: iastore
    //   465: aload_0
    //   466: getfield mArrayNextIndices : [I
    //   469: iload #6
    //   471: iload_3
    //   472: iastore
    //   473: aload_0
    //   474: aload_0
    //   475: getfield currentSize : I
    //   478: iconst_1
    //   479: iadd
    //   480: putfield currentSize : I
    //   483: aload_0
    //   484: getfield mDidFillOnce : Z
    //   487: ifne -> 500
    //   490: aload_0
    //   491: aload_0
    //   492: getfield mLast : I
    //   495: iconst_1
    //   496: iadd
    //   497: putfield mLast : I
    //   500: aload_0
    //   501: getfield mLast : I
    //   504: aload_0
    //   505: getfield mArrayIndices : [I
    //   508: arraylength
    //   509: if_icmplt -> 6
    //   512: aload_0
    //   513: iconst_1
    //   514: putfield mDidFillOnce : Z
    //   517: aload_0
    //   518: aload_0
    //   519: getfield mArrayIndices : [I
    //   522: arraylength
    //   523: iconst_1
    //   524: isub
    //   525: putfield mLast : I
    //   528: return
    //   529: aload_0
    //   530: getfield mArrayIndices : [I
    //   533: arraylength
    //   534: istore_3
    //   535: goto -> 285
    //   538: iload #5
    //   540: iconst_1
    //   541: iadd
    //   542: istore #5
    //   544: goto -> 315
    //   547: aload_0
    //   548: getfield mArrayNextIndices : [I
    //   551: iload_3
    //   552: aload_0
    //   553: getfield mHead : I
    //   556: iastore
    //   557: aload_0
    //   558: iload_3
    //   559: putfield mHead : I
    //   562: goto -> 473
  }
  
  public final void clear() {
    this.mHead = -1;
    this.mLast = -1;
    this.mDidFillOnce = false;
    this.currentSize = 0;
  }
  
  final boolean containsKey(SolverVariable paramSolverVariable) {
    if (this.mHead != -1) {
      int j = this.mHead;
      int i = 0;
      while (true) {
        if (j != -1 && i < this.currentSize) {
          if (this.mArrayIndices[j] == paramSolverVariable.id)
            return true; 
          j = this.mArrayNextIndices[j];
          i++;
          continue;
        } 
        return false;
      } 
    } 
    return false;
  }
  
  public void display() {
    int j = this.currentSize;
    System.out.print("{ ");
    for (int i = 0; i < j; i++) {
      SolverVariable solverVariable = getVariable(i);
      if (solverVariable != null)
        System.out.print(solverVariable + " = " + getVariableValue(i) + " "); 
    } 
    System.out.println(" }");
  }
  
  void divideByAmount(float paramFloat) {
    int j = this.mHead;
    for (int i = 0; j != -1 && i < this.currentSize; i++) {
      float[] arrayOfFloat = this.mArrayValues;
      arrayOfFloat[j] = arrayOfFloat[j] / paramFloat;
      j = this.mArrayNextIndices[j];
    } 
  }
  
  public final float get(SolverVariable paramSolverVariable) {
    int j = this.mHead;
    for (int i = 0; j != -1 && i < this.currentSize; i++) {
      if (this.mArrayIndices[j] == paramSolverVariable.id)
        return this.mArrayValues[j]; 
      j = this.mArrayNextIndices[j];
    } 
    return 0.0F;
  }
  
  SolverVariable getPivotCandidate() {
    // Byte code:
    //   0: aload_0
    //   1: getfield candidate : Landroid/support/constraint/solver/SolverVariable;
    //   4: ifnonnull -> 105
    //   7: aload_0
    //   8: getfield mHead : I
    //   11: istore_2
    //   12: iconst_0
    //   13: istore_1
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_3
    //   17: astore #4
    //   19: iload_2
    //   20: iconst_m1
    //   21: if_icmpeq -> 111
    //   24: aload_3
    //   25: astore #4
    //   27: iload_1
    //   28: aload_0
    //   29: getfield currentSize : I
    //   32: if_icmpge -> 111
    //   35: aload_3
    //   36: astore #4
    //   38: aload_0
    //   39: getfield mArrayValues : [F
    //   42: iload_2
    //   43: faload
    //   44: fconst_0
    //   45: fcmpg
    //   46: ifge -> 88
    //   49: aload_0
    //   50: getfield mCache : Landroid/support/constraint/solver/Cache;
    //   53: getfield mIndexedVariables : [Landroid/support/constraint/solver/SolverVariable;
    //   56: aload_0
    //   57: getfield mArrayIndices : [I
    //   60: iload_2
    //   61: iaload
    //   62: aaload
    //   63: astore #5
    //   65: aload_3
    //   66: ifnull -> 84
    //   69: aload_3
    //   70: astore #4
    //   72: aload_3
    //   73: getfield strength : I
    //   76: aload #5
    //   78: getfield strength : I
    //   81: if_icmpge -> 88
    //   84: aload #5
    //   86: astore #4
    //   88: aload_0
    //   89: getfield mArrayNextIndices : [I
    //   92: iload_2
    //   93: iaload
    //   94: istore_2
    //   95: iload_1
    //   96: iconst_1
    //   97: iadd
    //   98: istore_1
    //   99: aload #4
    //   101: astore_3
    //   102: goto -> 16
    //   105: aload_0
    //   106: getfield candidate : Landroid/support/constraint/solver/SolverVariable;
    //   109: astore #4
    //   111: aload #4
    //   113: areturn
  }
  
  final SolverVariable getVariable(int paramInt) {
    int j = this.mHead;
    for (int i = 0; j != -1 && i < this.currentSize; i++) {
      if (i == paramInt)
        return this.mCache.mIndexedVariables[this.mArrayIndices[j]]; 
      j = this.mArrayNextIndices[j];
    } 
    return null;
  }
  
  final float getVariableValue(int paramInt) {
    int j = this.mHead;
    for (int i = 0; j != -1 && i < this.currentSize; i++) {
      if (i == paramInt)
        return this.mArrayValues[j]; 
      j = this.mArrayNextIndices[j];
    } 
    return 0.0F;
  }
  
  boolean hasAtLeastOnePositiveVariable() {
    int j = this.mHead;
    for (int i = 0; j != -1 && i < this.currentSize; i++) {
      if (this.mArrayValues[j] > 0.0F)
        return true; 
      j = this.mArrayNextIndices[j];
    } 
    return false;
  }
  
  void invert() {
    int j = this.mHead;
    for (int i = 0; j != -1 && i < this.currentSize; i++) {
      float[] arrayOfFloat = this.mArrayValues;
      arrayOfFloat[j] = arrayOfFloat[j] * -1.0F;
      j = this.mArrayNextIndices[j];
    } 
  }
  
  SolverVariable pickPivotCandidate() {
    // Byte code:
    //   0: aconst_null
    //   1: astore #6
    //   3: aconst_null
    //   4: astore #5
    //   6: aload_0
    //   7: getfield mHead : I
    //   10: istore #4
    //   12: iconst_0
    //   13: istore_3
    //   14: iload #4
    //   16: iconst_m1
    //   17: if_icmpeq -> 231
    //   20: iload_3
    //   21: aload_0
    //   22: getfield currentSize : I
    //   25: if_icmpge -> 231
    //   28: aload_0
    //   29: getfield mArrayValues : [F
    //   32: iload #4
    //   34: faload
    //   35: fstore_2
    //   36: fload_2
    //   37: fconst_0
    //   38: fcmpg
    //   39: ifge -> 113
    //   42: fload_2
    //   43: fstore_1
    //   44: fload_2
    //   45: ldc 0.001
    //   47: fneg
    //   48: fcmpl
    //   49: ifle -> 62
    //   52: aload_0
    //   53: getfield mArrayValues : [F
    //   56: iload #4
    //   58: fconst_0
    //   59: fastore
    //   60: fconst_0
    //   61: fstore_1
    //   62: aload #6
    //   64: astore #8
    //   66: aload #5
    //   68: astore #9
    //   70: fload_1
    //   71: fconst_0
    //   72: fcmpl
    //   73: ifeq -> 156
    //   76: aload_0
    //   77: getfield mCache : Landroid/support/constraint/solver/Cache;
    //   80: getfield mIndexedVariables : [Landroid/support/constraint/solver/SolverVariable;
    //   83: aload_0
    //   84: getfield mArrayIndices : [I
    //   87: iload #4
    //   89: iaload
    //   90: aaload
    //   91: astore #7
    //   93: aload #7
    //   95: getfield mType : Landroid/support/constraint/solver/SolverVariable$Type;
    //   98: getstatic android/support/constraint/solver/SolverVariable$Type.UNRESTRICTED : Landroid/support/constraint/solver/SolverVariable$Type;
    //   101: if_acmpne -> 180
    //   104: fload_1
    //   105: fconst_0
    //   106: fcmpg
    //   107: ifge -> 135
    //   110: aload #7
    //   112: areturn
    //   113: fload_2
    //   114: fstore_1
    //   115: fload_2
    //   116: ldc 0.001
    //   118: fcmpg
    //   119: ifge -> 62
    //   122: aload_0
    //   123: getfield mArrayValues : [F
    //   126: iload #4
    //   128: fconst_0
    //   129: fastore
    //   130: fconst_0
    //   131: fstore_1
    //   132: goto -> 62
    //   135: aload #6
    //   137: astore #8
    //   139: aload #5
    //   141: astore #9
    //   143: aload #5
    //   145: ifnonnull -> 156
    //   148: aload #7
    //   150: astore #9
    //   152: aload #6
    //   154: astore #8
    //   156: aload_0
    //   157: getfield mArrayNextIndices : [I
    //   160: iload #4
    //   162: iaload
    //   163: istore #4
    //   165: iload_3
    //   166: iconst_1
    //   167: iadd
    //   168: istore_3
    //   169: aload #8
    //   171: astore #6
    //   173: aload #9
    //   175: astore #5
    //   177: goto -> 14
    //   180: aload #6
    //   182: astore #8
    //   184: aload #5
    //   186: astore #9
    //   188: fload_1
    //   189: fconst_0
    //   190: fcmpg
    //   191: ifge -> 156
    //   194: aload #6
    //   196: ifnull -> 220
    //   199: aload #6
    //   201: astore #8
    //   203: aload #5
    //   205: astore #9
    //   207: aload #7
    //   209: getfield strength : I
    //   212: aload #6
    //   214: getfield strength : I
    //   217: if_icmpge -> 156
    //   220: aload #7
    //   222: astore #8
    //   224: aload #5
    //   226: astore #9
    //   228: goto -> 156
    //   231: aload #5
    //   233: ifnull -> 239
    //   236: aload #5
    //   238: areturn
    //   239: aload #6
    //   241: areturn
  }
  
  public final void put(SolverVariable paramSolverVariable, float paramFloat) {
    // Byte code:
    //   0: fload_2
    //   1: fconst_0
    //   2: fcmpl
    //   3: ifne -> 13
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual remove : (Landroid/support/constraint/solver/SolverVariable;)F
    //   11: pop
    //   12: return
    //   13: aload_0
    //   14: getfield mHead : I
    //   17: iconst_m1
    //   18: if_icmpne -> 87
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield mHead : I
    //   26: aload_0
    //   27: getfield mArrayValues : [F
    //   30: aload_0
    //   31: getfield mHead : I
    //   34: fload_2
    //   35: fastore
    //   36: aload_0
    //   37: getfield mArrayIndices : [I
    //   40: aload_0
    //   41: getfield mHead : I
    //   44: aload_1
    //   45: getfield id : I
    //   48: iastore
    //   49: aload_0
    //   50: getfield mArrayNextIndices : [I
    //   53: aload_0
    //   54: getfield mHead : I
    //   57: iconst_m1
    //   58: iastore
    //   59: aload_0
    //   60: aload_0
    //   61: getfield currentSize : I
    //   64: iconst_1
    //   65: iadd
    //   66: putfield currentSize : I
    //   69: aload_0
    //   70: getfield mDidFillOnce : Z
    //   73: ifne -> 12
    //   76: aload_0
    //   77: aload_0
    //   78: getfield mLast : I
    //   81: iconst_1
    //   82: iadd
    //   83: putfield mLast : I
    //   86: return
    //   87: aload_0
    //   88: getfield mHead : I
    //   91: istore_3
    //   92: iconst_m1
    //   93: istore #6
    //   95: iconst_0
    //   96: istore #4
    //   98: iload_3
    //   99: iconst_m1
    //   100: if_icmpeq -> 165
    //   103: iload #4
    //   105: aload_0
    //   106: getfield currentSize : I
    //   109: if_icmpge -> 165
    //   112: aload_0
    //   113: getfield mArrayIndices : [I
    //   116: iload_3
    //   117: iaload
    //   118: aload_1
    //   119: getfield id : I
    //   122: if_icmpne -> 133
    //   125: aload_0
    //   126: getfield mArrayValues : [F
    //   129: iload_3
    //   130: fload_2
    //   131: fastore
    //   132: return
    //   133: aload_0
    //   134: getfield mArrayIndices : [I
    //   137: iload_3
    //   138: iaload
    //   139: aload_1
    //   140: getfield id : I
    //   143: if_icmpge -> 149
    //   146: iload_3
    //   147: istore #6
    //   149: aload_0
    //   150: getfield mArrayNextIndices : [I
    //   153: iload_3
    //   154: iaload
    //   155: istore_3
    //   156: iload #4
    //   158: iconst_1
    //   159: iadd
    //   160: istore #4
    //   162: goto -> 98
    //   165: aload_0
    //   166: getfield mLast : I
    //   169: iconst_1
    //   170: iadd
    //   171: istore_3
    //   172: aload_0
    //   173: getfield mDidFillOnce : Z
    //   176: ifeq -> 197
    //   179: aload_0
    //   180: getfield mArrayIndices : [I
    //   183: aload_0
    //   184: getfield mLast : I
    //   187: iaload
    //   188: iconst_m1
    //   189: if_icmpne -> 430
    //   192: aload_0
    //   193: getfield mLast : I
    //   196: istore_3
    //   197: iload_3
    //   198: istore #4
    //   200: iload_3
    //   201: aload_0
    //   202: getfield mArrayIndices : [I
    //   205: arraylength
    //   206: if_icmplt -> 255
    //   209: iload_3
    //   210: istore #4
    //   212: aload_0
    //   213: getfield currentSize : I
    //   216: aload_0
    //   217: getfield mArrayIndices : [I
    //   220: arraylength
    //   221: if_icmpge -> 255
    //   224: iconst_0
    //   225: istore #5
    //   227: iload_3
    //   228: istore #4
    //   230: iload #5
    //   232: aload_0
    //   233: getfield mArrayIndices : [I
    //   236: arraylength
    //   237: if_icmpge -> 255
    //   240: aload_0
    //   241: getfield mArrayIndices : [I
    //   244: iload #5
    //   246: iaload
    //   247: iconst_m1
    //   248: if_icmpne -> 439
    //   251: iload #5
    //   253: istore #4
    //   255: iload #4
    //   257: istore_3
    //   258: iload #4
    //   260: aload_0
    //   261: getfield mArrayIndices : [I
    //   264: arraylength
    //   265: if_icmplt -> 341
    //   268: aload_0
    //   269: getfield mArrayIndices : [I
    //   272: arraylength
    //   273: istore_3
    //   274: aload_0
    //   275: aload_0
    //   276: getfield ROW_SIZE : I
    //   279: iconst_2
    //   280: imul
    //   281: putfield ROW_SIZE : I
    //   284: aload_0
    //   285: iconst_0
    //   286: putfield mDidFillOnce : Z
    //   289: aload_0
    //   290: iload_3
    //   291: iconst_1
    //   292: isub
    //   293: putfield mLast : I
    //   296: aload_0
    //   297: aload_0
    //   298: getfield mArrayValues : [F
    //   301: aload_0
    //   302: getfield ROW_SIZE : I
    //   305: invokestatic copyOf : ([FI)[F
    //   308: putfield mArrayValues : [F
    //   311: aload_0
    //   312: aload_0
    //   313: getfield mArrayIndices : [I
    //   316: aload_0
    //   317: getfield ROW_SIZE : I
    //   320: invokestatic copyOf : ([II)[I
    //   323: putfield mArrayIndices : [I
    //   326: aload_0
    //   327: aload_0
    //   328: getfield mArrayNextIndices : [I
    //   331: aload_0
    //   332: getfield ROW_SIZE : I
    //   335: invokestatic copyOf : ([II)[I
    //   338: putfield mArrayNextIndices : [I
    //   341: aload_0
    //   342: getfield mArrayIndices : [I
    //   345: iload_3
    //   346: aload_1
    //   347: getfield id : I
    //   350: iastore
    //   351: aload_0
    //   352: getfield mArrayValues : [F
    //   355: iload_3
    //   356: fload_2
    //   357: fastore
    //   358: iload #6
    //   360: iconst_m1
    //   361: if_icmpeq -> 448
    //   364: aload_0
    //   365: getfield mArrayNextIndices : [I
    //   368: iload_3
    //   369: aload_0
    //   370: getfield mArrayNextIndices : [I
    //   373: iload #6
    //   375: iaload
    //   376: iastore
    //   377: aload_0
    //   378: getfield mArrayNextIndices : [I
    //   381: iload #6
    //   383: iload_3
    //   384: iastore
    //   385: aload_0
    //   386: aload_0
    //   387: getfield currentSize : I
    //   390: iconst_1
    //   391: iadd
    //   392: putfield currentSize : I
    //   395: aload_0
    //   396: getfield mDidFillOnce : Z
    //   399: ifne -> 412
    //   402: aload_0
    //   403: aload_0
    //   404: getfield mLast : I
    //   407: iconst_1
    //   408: iadd
    //   409: putfield mLast : I
    //   412: aload_0
    //   413: getfield currentSize : I
    //   416: aload_0
    //   417: getfield mArrayIndices : [I
    //   420: arraylength
    //   421: if_icmplt -> 12
    //   424: aload_0
    //   425: iconst_1
    //   426: putfield mDidFillOnce : Z
    //   429: return
    //   430: aload_0
    //   431: getfield mArrayIndices : [I
    //   434: arraylength
    //   435: istore_3
    //   436: goto -> 197
    //   439: iload #5
    //   441: iconst_1
    //   442: iadd
    //   443: istore #5
    //   445: goto -> 227
    //   448: aload_0
    //   449: getfield mArrayNextIndices : [I
    //   452: iload_3
    //   453: aload_0
    //   454: getfield mHead : I
    //   457: iastore
    //   458: aload_0
    //   459: iload_3
    //   460: putfield mHead : I
    //   463: goto -> 385
  }
  
  public final float remove(SolverVariable paramSolverVariable) {
    if (this.candidate == paramSolverVariable)
      this.candidate = null; 
    if (this.mHead != -1) {
      int i = this.mHead;
      int k = -1;
      int j = 0;
      while (true) {
        if (i != -1 && j < this.currentSize) {
          int m = this.mArrayIndices[i];
          if (m == paramSolverVariable.id) {
            if (i == this.mHead) {
              this.mHead = this.mArrayNextIndices[i];
            } else {
              this.mArrayNextIndices[k] = this.mArrayNextIndices[i];
            } 
            this.mCache.mIndexedVariables[m].removeClientEquation(this.mRow);
            this.currentSize--;
            this.mArrayIndices[i] = -1;
            if (this.mDidFillOnce)
              this.mLast = i; 
            return this.mArrayValues[i];
          } 
          k = i;
          i = this.mArrayNextIndices[i];
          j++;
          continue;
        } 
        return 0.0F;
      } 
    } 
    return 0.0F;
  }
  
  int sizeInBytes() {
    return 0 + this.mArrayIndices.length * 4 * 3 + 36;
  }
  
  public String toString() {
    String str = "";
    int j = this.mHead;
    for (int i = 0; j != -1 && i < this.currentSize; i++) {
      str = str + " -> ";
      str = str + this.mArrayValues[j] + " : ";
      str = str + this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      j = this.mArrayNextIndices[j];
    } 
    return str;
  }
  
  void updateClientEquations(ArrayRow paramArrayRow) {
    int j = this.mHead;
    for (int i = 0; j != -1 && i < this.currentSize; i++) {
      this.mCache.mIndexedVariables[this.mArrayIndices[j]].addClientEquation(paramArrayRow);
      j = this.mArrayNextIndices[j];
    } 
  }
  
  void updateFromRow(ArrayRow paramArrayRow1, ArrayRow paramArrayRow2) {
    int j = this.mHead;
    int i;
    for (i = 0; j != -1 && i < this.currentSize; i++) {
      if (this.mArrayIndices[j] == paramArrayRow2.variable.id) {
        float f = this.mArrayValues[j];
        remove(paramArrayRow2.variable);
        ArrayLinkedVariables arrayLinkedVariables = paramArrayRow2.variables;
        j = arrayLinkedVariables.mHead;
        for (i = 0; j != -1 && i < arrayLinkedVariables.currentSize; i++) {
          add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[j]], arrayLinkedVariables.mArrayValues[j] * f);
          j = arrayLinkedVariables.mArrayNextIndices[j];
        } 
        paramArrayRow1.constantValue += paramArrayRow2.constantValue * f;
        paramArrayRow2.variable.removeClientEquation(paramArrayRow1);
        j = this.mHead;
        i = 0;
        continue;
      } 
      j = this.mArrayNextIndices[j];
    } 
  }
  
  void updateFromSystem(ArrayRow paramArrayRow, ArrayRow[] paramArrayOfArrayRow) {
    int j = this.mHead;
    int i;
    for (i = 0; j != -1 && i < this.currentSize; i++) {
      SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      if (solverVariable.definitionId != -1) {
        float f = this.mArrayValues[j];
        remove(solverVariable);
        ArrayRow arrayRow = paramArrayOfArrayRow[solverVariable.definitionId];
        if (!arrayRow.isSimpleDefinition) {
          ArrayLinkedVariables arrayLinkedVariables = arrayRow.variables;
          j = arrayLinkedVariables.mHead;
          for (i = 0; j != -1 && i < arrayLinkedVariables.currentSize; i++) {
            add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[j]], arrayLinkedVariables.mArrayValues[j] * f);
            j = arrayLinkedVariables.mArrayNextIndices[j];
          } 
        } 
        paramArrayRow.constantValue += arrayRow.constantValue * f;
        arrayRow.variable.removeClientEquation(paramArrayRow);
        j = this.mHead;
        i = 0;
        continue;
      } 
      j = this.mArrayNextIndices[j];
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\solver\ArrayLinkedVariables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */