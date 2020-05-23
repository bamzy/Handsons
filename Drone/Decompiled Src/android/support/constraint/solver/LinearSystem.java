package android.support.constraint.solver;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
  private static final boolean DEBUG = false;
  
  private static int POOL_SIZE = 1000;
  
  private int TABLE_SIZE = 32;
  
  private boolean[] mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
  
  final Cache mCache;
  
  private Goal mGoal = new Goal();
  
  private int mMaxColumns = this.TABLE_SIZE;
  
  private int mMaxRows = this.TABLE_SIZE;
  
  int mNumColumns = 1;
  
  private int mNumRows = 0;
  
  private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
  
  private int mPoolVariablesCount = 0;
  
  private ArrayRow[] mRows = null;
  
  private HashMap<String, SolverVariable> mVariables = null;
  
  int mVariablesID = 0;
  
  private ArrayRow[] tempClientsCopy = new ArrayRow[this.TABLE_SIZE];
  
  public LinearSystem() {
    this.mRows = new ArrayRow[this.TABLE_SIZE];
    releaseRows();
    this.mCache = new Cache();
  }
  
  private SolverVariable acquireSolverVariable(SolverVariable.Type paramType) {
    SolverVariable solverVariable1;
    SolverVariable solverVariable2 = this.mCache.solverVariablePool.acquire();
    if (solverVariable2 == null) {
      solverVariable1 = new SolverVariable(paramType);
    } else {
      solverVariable2.reset();
      solverVariable2.setType((SolverVariable.Type)solverVariable1);
      solverVariable1 = solverVariable2;
    } 
    if (this.mPoolVariablesCount >= POOL_SIZE) {
      POOL_SIZE *= 2;
      this.mPoolVariables = Arrays.<SolverVariable>copyOf(this.mPoolVariables, POOL_SIZE);
    } 
    SolverVariable[] arrayOfSolverVariable = this.mPoolVariables;
    int i = this.mPoolVariablesCount;
    this.mPoolVariablesCount = i + 1;
    arrayOfSolverVariable[i] = solverVariable1;
    return solverVariable1;
  }
  
  private void addError(ArrayRow paramArrayRow) {
    paramArrayRow.addError(createErrorVariable(), createErrorVariable());
  }
  
  private void addSingleError(ArrayRow paramArrayRow, int paramInt) {
    paramArrayRow.addSingleError(createErrorVariable(), paramInt);
  }
  
  private void computeValues() {
    for (int i = 0; i < this.mNumRows; i++) {
      ArrayRow arrayRow = this.mRows[i];
      arrayRow.variable.computedValue = arrayRow.constantValue;
    } 
  }
  
  public static ArrayRow createRowCentering(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, boolean paramBoolean) {
    ArrayRow arrayRow = paramLinearSystem.createRow();
    arrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramBoolean) {
      paramSolverVariable1 = paramLinearSystem.createErrorVariable();
      SolverVariable solverVariable = paramLinearSystem.createErrorVariable();
      paramSolverVariable1.strength = 4;
      solverVariable.strength = 4;
      arrayRow.addError(paramSolverVariable1, solverVariable);
    } 
    return arrayRow;
  }
  
  public static ArrayRow createRowDimensionPercent(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat, boolean paramBoolean) {
    ArrayRow arrayRow = paramLinearSystem.createRow();
    if (paramBoolean)
      paramLinearSystem.addError(arrayRow); 
    return arrayRow.createRowDimensionPercent(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramFloat);
  }
  
  public static ArrayRow createRowEquals(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean) {
    ArrayRow arrayRow = paramLinearSystem.createRow();
    arrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt);
    if (paramBoolean)
      paramLinearSystem.addSingleError(arrayRow, 1); 
    return arrayRow;
  }
  
  public static ArrayRow createRowGreaterThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean) {
    SolverVariable solverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow arrayRow = paramLinearSystem.createRow();
    arrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, solverVariable, paramInt);
    if (paramBoolean)
      paramLinearSystem.addSingleError(arrayRow, (int)(-1.0F * arrayRow.variables.get(solverVariable))); 
    return arrayRow;
  }
  
  public static ArrayRow createRowLowerThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean) {
    SolverVariable solverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow arrayRow = paramLinearSystem.createRow();
    arrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, solverVariable, paramInt);
    if (paramBoolean)
      paramLinearSystem.addSingleError(arrayRow, (int)(-1.0F * arrayRow.variables.get(solverVariable))); 
    return arrayRow;
  }
  
  private SolverVariable createVariable(String paramString, SolverVariable.Type paramType) {
    if (this.mNumColumns + 1 >= this.mMaxColumns)
      increaseTableSize(); 
    SolverVariable solverVariable = acquireSolverVariable(paramType);
    solverVariable.setName(paramString);
    this.mVariablesID++;
    this.mNumColumns++;
    solverVariable.id = this.mVariablesID;
    if (this.mVariables == null)
      this.mVariables = new HashMap<String, SolverVariable>(); 
    this.mVariables.put(paramString, solverVariable);
    this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable;
    return solverVariable;
  }
  
  private void displayRows() {
    displaySolverVariables();
    String str1 = "";
    for (int i = 0; i < this.mNumRows; i++) {
      str1 = str1 + this.mRows[i];
      str1 = str1 + "\n";
    } 
    String str2 = str1;
    if (this.mGoal.variables.size() != 0)
      str2 = str1 + this.mGoal + "\n"; 
    System.out.println(str2);
  }
  
  private void displaySolverVariables() {
    String str = "Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ") :\n\t | C | ";
    for (int i = 1; i <= this.mNumColumns; i++) {
      SolverVariable solverVariable = this.mCache.mIndexedVariables[i];
      str = str + solverVariable;
      str = str + " | ";
    } 
    str = str + "\n";
    System.out.println(str);
  }
  
  private int enforceBFS(Goal paramGoal) throws Exception {
    int k = 0;
    int m = 0;
    int j = 0;
    while (true) {
      i = m;
      if (j < this.mNumRows) {
        if ((this.mRows[j]).variable.mType != SolverVariable.Type.UNRESTRICTED && (this.mRows[j]).constantValue < 0.0F) {
          i = 1;
          break;
        } 
        j++;
        continue;
      } 
      break;
    } 
    j = k;
    if (i) {
      boolean bool = false;
      i = 0;
      while (true) {
        j = i;
        if (!bool) {
          int n = i + 1;
          float f = Float.MAX_VALUE;
          k = 0;
          j = -1;
          i = -1;
          m = 0;
          label66: while (m < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[m];
            if (arrayRow.variable.mType == SolverVariable.Type.UNRESTRICTED) {
              int i6 = k;
              int i5 = j;
              int i4 = i;
              float f2 = f;
              continue;
            } 
            float f1 = f;
            int i1 = i;
            int i2 = j;
            int i3 = k;
            if (arrayRow.constantValue < 0.0F) {
              byte b = 1;
              while (true) {
                f1 = f;
                i1 = i;
                i2 = j;
                i3 = k;
                if (b < this.mNumColumns) {
                  SolverVariable solverVariable = this.mCache.mIndexedVariables[b];
                  float f2 = arrayRow.variables.get(solverVariable);
                  if (f2 <= 0.0F) {
                    i2 = k;
                    i3 = j;
                    int i4 = i;
                    f1 = f;
                    continue;
                  } 
                  i2 = 0;
                  i1 = i;
                  i = i2;
                  while (true) {
                    f1 = f;
                    int i4 = i1;
                    i3 = j;
                    i2 = k;
                    i++;
                    k = i2;
                  } 
                  break;
                } 
                m++;
                f = f1;
                i = i1;
                j = i2;
                k = i3;
                continue label66;
              } 
            } 
            continue;
          } 
          if (j != -1) {
            ArrayRow arrayRow = this.mRows[j];
            arrayRow.variable.definitionId = -1;
            arrayRow.pivot(this.mCache.mIndexedVariables[i]);
            arrayRow.variable.definitionId = j;
            for (i = 0; i < this.mNumRows; i++)
              this.mRows[i].updateRowWithEquation(arrayRow); 
            paramGoal.updateFromSystem(this);
            i = n;
            continue;
          } 
          bool = true;
          i = n;
          continue;
        } 
        break;
      } 
    } 
    for (int i = 0; i < this.mNumRows && ((this.mRows[i]).variable.mType == SolverVariable.Type.UNRESTRICTED || (this.mRows[i]).constantValue >= 0.0F); i++);
    return j;
  }
  
  private String getDisplaySize(int paramInt) {
    int i = paramInt * 4 / 1024 / 1024;
    if (i > 0)
      return "" + i + " Mb"; 
    i = paramInt * 4 / 1024;
    return (i > 0) ? ("" + i + " Kb") : ("" + (paramInt * 4) + " bytes");
  }
  
  private void increaseTableSize() {
    this.TABLE_SIZE *= 2;
    this.mRows = Arrays.<ArrayRow>copyOf(this.mRows, this.TABLE_SIZE);
    this.mCache.mIndexedVariables = Arrays.<SolverVariable>copyOf(this.mCache.mIndexedVariables, this.TABLE_SIZE);
    this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
    this.mMaxColumns = this.TABLE_SIZE;
    this.mMaxRows = this.TABLE_SIZE;
    this.mGoal.variables.clear();
  }
  
  private int optimize(Goal paramGoal) {
    int k = 0;
    int j = 0;
    int i;
    for (i = 0; i < this.mNumColumns; i++)
      this.mAlreadyTestedCandidates[i] = false; 
    int m = 0;
    i = k;
    while (i == 0) {
      int n = j + 1;
      SolverVariable solverVariable2 = paramGoal.getPivotCandidate();
      k = i;
      SolverVariable solverVariable1 = solverVariable2;
      j = m;
      if (solverVariable2 != null)
        if (this.mAlreadyTestedCandidates[solverVariable2.id]) {
          solverVariable1 = null;
          j = m;
          k = i;
        } else {
          this.mAlreadyTestedCandidates[solverVariable2.id] = true;
          m++;
          k = i;
          solverVariable1 = solverVariable2;
          j = m;
          if (m >= this.mNumColumns) {
            k = 1;
            solverVariable1 = solverVariable2;
            j = m;
          } 
        }  
      if (solverVariable1 != null) {
        float f = Float.MAX_VALUE;
        m = -1;
        i = 0;
        while (i < this.mNumRows) {
          float f1;
          int i1;
          ArrayRow arrayRow = this.mRows[i];
          if (arrayRow.variable.mType == SolverVariable.Type.UNRESTRICTED) {
            i1 = m;
            f1 = f;
          } else {
            f1 = f;
            i1 = m;
            if (arrayRow.hasVariable(solverVariable1)) {
              float f2 = arrayRow.variables.get(solverVariable1);
              f1 = f;
              i1 = m;
              if (f2 < 0.0F) {
                f2 = -arrayRow.constantValue / f2;
                f1 = f;
                i1 = m;
                if (f2 < f) {
                  f1 = f2;
                  i1 = i;
                } 
              } 
            } 
          } 
          i++;
          f = f1;
          m = i1;
        } 
        if (m > -1) {
          ArrayRow arrayRow = this.mRows[m];
          arrayRow.variable.definitionId = -1;
          arrayRow.pivot(solverVariable1);
          arrayRow.variable.definitionId = m;
          for (i = 0; i < this.mNumRows; i++)
            this.mRows[i].updateRowWithEquation(arrayRow); 
          paramGoal.updateFromSystem(this);
          try {
            enforceBFS(paramGoal);
            i = k;
            m = j;
            j = n;
          } catch (Exception exception) {
            exception.printStackTrace();
            i = k;
            m = j;
            j = n;
          } 
          continue;
        } 
        i = 1;
        m = j;
        j = n;
        continue;
      } 
      i = 1;
      m = j;
      j = n;
    } 
    return j;
  }
  
  private void releaseRows() {
    for (int i = 0; i < this.mRows.length; i++) {
      ArrayRow arrayRow = this.mRows[i];
      if (arrayRow != null)
        this.mCache.arrayRowPool.release(arrayRow); 
      this.mRows[i] = null;
    } 
  }
  
  private void updateRowFromVariables(ArrayRow paramArrayRow) {
    if (this.mNumRows > 0) {
      paramArrayRow.variables.updateFromSystem(paramArrayRow, this.mRows);
      if (paramArrayRow.variables.currentSize == 0)
        paramArrayRow.isSimpleDefinition = true; 
    } 
  }
  
  public void addCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, int paramInt3) {
    ArrayRow arrayRow = createRow();
    arrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    paramSolverVariable1 = createErrorVariable();
    paramSolverVariable2 = createErrorVariable();
    paramSolverVariable1.strength = paramInt3;
    paramSolverVariable2.strength = paramInt3;
    arrayRow.addError(paramSolverVariable1, paramSolverVariable2);
    addConstraint(arrayRow);
  }
  
  public void addConstraint(ArrayRow paramArrayRow) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield mNumRows : I
    //   9: iconst_1
    //   10: iadd
    //   11: aload_0
    //   12: getfield mMaxRows : I
    //   15: if_icmpge -> 31
    //   18: aload_0
    //   19: getfield mNumColumns : I
    //   22: iconst_1
    //   23: iadd
    //   24: aload_0
    //   25: getfield mMaxColumns : I
    //   28: if_icmplt -> 35
    //   31: aload_0
    //   32: invokespecial increaseTableSize : ()V
    //   35: aload_1
    //   36: getfield isSimpleDefinition : Z
    //   39: ifne -> 62
    //   42: aload_0
    //   43: aload_1
    //   44: invokespecial updateRowFromVariables : (Landroid/support/constraint/solver/ArrayRow;)V
    //   47: aload_1
    //   48: invokevirtual ensurePositiveConstant : ()V
    //   51: aload_1
    //   52: invokevirtual pickRowVariable : ()V
    //   55: aload_1
    //   56: invokevirtual hasKeyVariable : ()Z
    //   59: ifeq -> 4
    //   62: aload_0
    //   63: getfield mRows : [Landroid/support/constraint/solver/ArrayRow;
    //   66: aload_0
    //   67: getfield mNumRows : I
    //   70: aaload
    //   71: ifnull -> 96
    //   74: aload_0
    //   75: getfield mCache : Landroid/support/constraint/solver/Cache;
    //   78: getfield arrayRowPool : Landroid/support/constraint/solver/Pools$Pool;
    //   81: aload_0
    //   82: getfield mRows : [Landroid/support/constraint/solver/ArrayRow;
    //   85: aload_0
    //   86: getfield mNumRows : I
    //   89: aaload
    //   90: invokeinterface release : (Ljava/lang/Object;)Z
    //   95: pop
    //   96: aload_1
    //   97: getfield isSimpleDefinition : Z
    //   100: ifne -> 107
    //   103: aload_1
    //   104: invokevirtual updateClientEquations : ()V
    //   107: aload_0
    //   108: getfield mRows : [Landroid/support/constraint/solver/ArrayRow;
    //   111: aload_0
    //   112: getfield mNumRows : I
    //   115: aload_1
    //   116: aastore
    //   117: aload_1
    //   118: getfield variable : Landroid/support/constraint/solver/SolverVariable;
    //   121: aload_0
    //   122: getfield mNumRows : I
    //   125: putfield definitionId : I
    //   128: aload_0
    //   129: aload_0
    //   130: getfield mNumRows : I
    //   133: iconst_1
    //   134: iadd
    //   135: putfield mNumRows : I
    //   138: aload_1
    //   139: getfield variable : Landroid/support/constraint/solver/SolverVariable;
    //   142: getfield mClientEquationsCount : I
    //   145: istore_3
    //   146: iload_3
    //   147: ifle -> 4
    //   150: aload_0
    //   151: getfield tempClientsCopy : [Landroid/support/constraint/solver/ArrayRow;
    //   154: arraylength
    //   155: iload_3
    //   156: if_icmpge -> 176
    //   159: aload_0
    //   160: aload_0
    //   161: getfield tempClientsCopy : [Landroid/support/constraint/solver/ArrayRow;
    //   164: arraylength
    //   165: iconst_2
    //   166: imul
    //   167: anewarray android/support/constraint/solver/ArrayRow
    //   170: putfield tempClientsCopy : [Landroid/support/constraint/solver/ArrayRow;
    //   173: goto -> 150
    //   176: aload_0
    //   177: getfield tempClientsCopy : [Landroid/support/constraint/solver/ArrayRow;
    //   180: astore #4
    //   182: iconst_0
    //   183: istore_2
    //   184: iload_2
    //   185: iload_3
    //   186: if_icmpge -> 209
    //   189: aload #4
    //   191: iload_2
    //   192: aload_1
    //   193: getfield variable : Landroid/support/constraint/solver/SolverVariable;
    //   196: getfield mClientEquations : [Landroid/support/constraint/solver/ArrayRow;
    //   199: iload_2
    //   200: aaload
    //   201: aastore
    //   202: iload_2
    //   203: iconst_1
    //   204: iadd
    //   205: istore_2
    //   206: goto -> 184
    //   209: iconst_0
    //   210: istore_2
    //   211: iload_2
    //   212: iload_3
    //   213: if_icmpge -> 4
    //   216: aload #4
    //   218: iload_2
    //   219: aaload
    //   220: astore #5
    //   222: aload #5
    //   224: aload_1
    //   225: if_acmpne -> 235
    //   228: iload_2
    //   229: iconst_1
    //   230: iadd
    //   231: istore_2
    //   232: goto -> 211
    //   235: aload #5
    //   237: getfield variables : Landroid/support/constraint/solver/ArrayLinkedVariables;
    //   240: aload #5
    //   242: aload_1
    //   243: invokevirtual updateFromRow : (Landroid/support/constraint/solver/ArrayRow;Landroid/support/constraint/solver/ArrayRow;)V
    //   246: aload #5
    //   248: invokevirtual updateClientEquations : ()V
    //   251: goto -> 228
  }
  
  public ArrayRow addEquality(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2) {
    ArrayRow arrayRow = createRow();
    arrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt1);
    paramSolverVariable1 = createErrorVariable();
    paramSolverVariable2 = createErrorVariable();
    paramSolverVariable1.strength = paramInt2;
    paramSolverVariable2.strength = paramInt2;
    arrayRow.addError(paramSolverVariable1, paramSolverVariable2);
    addConstraint(arrayRow);
    return arrayRow;
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt) {
    int i = paramSolverVariable.definitionId;
    if (paramSolverVariable.definitionId != -1) {
      ArrayRow arrayRow1 = this.mRows[i];
      if (arrayRow1.isSimpleDefinition) {
        arrayRow1.constantValue = paramInt;
        return;
      } 
      arrayRow1 = createRow();
      arrayRow1.createRowEquals(paramSolverVariable, paramInt);
      addConstraint(arrayRow1);
      return;
    } 
    ArrayRow arrayRow = createRow();
    arrayRow.createRowDefinition(paramSolverVariable, paramInt);
    addConstraint(arrayRow);
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2) {
    ArrayRow arrayRow = createRow();
    SolverVariable solverVariable = createSlackVariable();
    solverVariable.strength = paramInt2;
    arrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, solverVariable, paramInt1);
    addConstraint(arrayRow);
  }
  
  public void addLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2) {
    ArrayRow arrayRow = createRow();
    SolverVariable solverVariable = createSlackVariable();
    solverVariable.strength = paramInt2;
    arrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, solverVariable, paramInt1);
    addConstraint(arrayRow);
  }
  
  public SolverVariable createErrorVariable() {
    if (this.mNumColumns + 1 >= this.mMaxColumns)
      increaseTableSize(); 
    SolverVariable solverVariable = acquireSolverVariable(SolverVariable.Type.ERROR);
    this.mVariablesID++;
    this.mNumColumns++;
    solverVariable.id = this.mVariablesID;
    this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable;
    return solverVariable;
  }
  
  public SolverVariable createObjectVariable(Object paramObject) {
    SolverVariable solverVariable1;
    if (paramObject == null)
      return null; 
    if (this.mNumColumns + 1 >= this.mMaxColumns)
      increaseTableSize(); 
    SolverVariable solverVariable2 = null;
    if (paramObject instanceof ConstraintAnchor) {
      solverVariable2 = ((ConstraintAnchor)paramObject).getSolverVariable();
      solverVariable1 = solverVariable2;
      if (solverVariable2 == null) {
        ((ConstraintAnchor)paramObject).resetSolverVariable(this.mCache);
        solverVariable1 = ((ConstraintAnchor)paramObject).getSolverVariable();
      } 
      if (solverVariable1.id != -1 && solverVariable1.id <= this.mVariablesID) {
        solverVariable2 = solverVariable1;
        if (this.mCache.mIndexedVariables[solverVariable1.id] == null) {
          if (solverVariable1.id != -1)
            solverVariable1.reset(); 
          this.mVariablesID++;
          this.mNumColumns++;
          solverVariable1.id = this.mVariablesID;
          solverVariable1.mType = SolverVariable.Type.UNRESTRICTED;
          this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable1;
          return solverVariable1;
        } 
        return solverVariable2;
      } 
    } else {
      return solverVariable2;
    } 
    if (solverVariable1.id != -1)
      solverVariable1.reset(); 
    this.mVariablesID++;
    this.mNumColumns++;
    solverVariable1.id = this.mVariablesID;
    solverVariable1.mType = SolverVariable.Type.UNRESTRICTED;
    this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable1;
    return solverVariable1;
  }
  
  public ArrayRow createRow() {
    ArrayRow arrayRow = this.mCache.arrayRowPool.acquire();
    if (arrayRow == null)
      return new ArrayRow(this.mCache); 
    arrayRow.reset();
    return arrayRow;
  }
  
  public SolverVariable createSlackVariable() {
    if (this.mNumColumns + 1 >= this.mMaxColumns)
      increaseTableSize(); 
    SolverVariable solverVariable = acquireSolverVariable(SolverVariable.Type.SLACK);
    this.mVariablesID++;
    this.mNumColumns++;
    solverVariable.id = this.mVariablesID;
    this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable;
    return solverVariable;
  }
  
  void displayReadableRows() {
    displaySolverVariables();
    String str1 = "";
    for (int i = 0; i < this.mNumRows; i++) {
      str1 = str1 + this.mRows[i].toReadableString();
      str1 = str1 + "\n";
    } 
    String str2 = str1;
    if (this.mGoal != null)
      str2 = str1 + this.mGoal + "\n"; 
    System.out.println(str2);
  }
  
  void displaySystemInformations() {
    int i = 0;
    int j = 0;
    while (j < this.TABLE_SIZE) {
      int m = i;
      if (this.mRows[j] != null)
        m = i + this.mRows[j].sizeInBytes(); 
      j++;
      i = m;
    } 
    int k = 0;
    j = 0;
    while (j < this.mNumRows) {
      int m = k;
      if (this.mRows[j] != null)
        m = k + this.mRows[j].sizeInBytes(); 
      j++;
      k = m;
    } 
    System.out.println("Linear System -> Table size: " + this.TABLE_SIZE + " (" + getDisplaySize(this.TABLE_SIZE * this.TABLE_SIZE) + ") -- row sizes: " + getDisplaySize(i) + ", actual size: " + getDisplaySize(k) + " rows: " + this.mNumRows + "/" + this.mMaxRows + " cols: " + this.mNumColumns + "/" + this.mMaxColumns + " " + Character.MIN_VALUE + " occupied cells, " + getDisplaySize(0));
  }
  
  public void displayVariablesReadableRows() {
    displaySolverVariables();
    String str1 = "";
    int i = 0;
    while (i < this.mNumRows) {
      String str = str1;
      if ((this.mRows[i]).variable.mType == SolverVariable.Type.UNRESTRICTED) {
        str1 = str1 + this.mRows[i].toReadableString();
        str = str1 + "\n";
      } 
      i++;
      str1 = str;
    } 
    String str2 = str1;
    if (this.mGoal.variables.size() != 0)
      str2 = str1 + this.mGoal + "\n"; 
    System.out.println(str2);
  }
  
  public Cache getCache() {
    return this.mCache;
  }
  
  Goal getGoal() {
    return this.mGoal;
  }
  
  public int getMemoryUsed() {
    int j = 0;
    int i = 0;
    while (i < this.mNumRows) {
      int k = j;
      if (this.mRows[i] != null)
        k = j + this.mRows[i].sizeInBytes(); 
      i++;
      j = k;
    } 
    return j;
  }
  
  public int getNumEquations() {
    return this.mNumRows;
  }
  
  public int getNumVariables() {
    return this.mVariablesID;
  }
  
  public int getObjectVariableValue(Object paramObject) {
    paramObject = ((ConstraintAnchor)paramObject).getSolverVariable();
    return (paramObject != null) ? (int)(((SolverVariable)paramObject).computedValue + 0.5F) : 0;
  }
  
  ArrayRow getRow(int paramInt) {
    return this.mRows[paramInt];
  }
  
  float getValueFor(String paramString) {
    SolverVariable solverVariable = getVariable(paramString, SolverVariable.Type.UNRESTRICTED);
    return (solverVariable == null) ? 0.0F : solverVariable.computedValue;
  }
  
  SolverVariable getVariable(String paramString, SolverVariable.Type paramType) {
    if (this.mVariables == null)
      this.mVariables = new HashMap<String, SolverVariable>(); 
    SolverVariable solverVariable2 = this.mVariables.get(paramString);
    SolverVariable solverVariable1 = solverVariable2;
    if (solverVariable2 == null)
      solverVariable1 = createVariable(paramString, paramType); 
    return solverVariable1;
  }
  
  public void minimize() throws Exception {
    minimizeGoal(this.mGoal);
  }
  
  void minimizeGoal(Goal paramGoal) throws Exception {
    paramGoal.updateFromSystem(this);
    enforceBFS(paramGoal);
    optimize(paramGoal);
    computeValues();
  }
  
  void rebuildGoalFromErrors() {
    this.mGoal.updateFromSystem(this);
  }
  
  public void reset() {
    int i;
    for (i = 0; i < this.mCache.mIndexedVariables.length; i++) {
      SolverVariable solverVariable = this.mCache.mIndexedVariables[i];
      if (solverVariable != null)
        solverVariable.reset(); 
    } 
    this.mCache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
    this.mPoolVariablesCount = 0;
    Arrays.fill((Object[])this.mCache.mIndexedVariables, (Object)null);
    if (this.mVariables != null)
      this.mVariables.clear(); 
    this.mVariablesID = 0;
    this.mGoal.variables.clear();
    this.mNumColumns = 1;
    for (i = 0; i < this.mNumRows; i++)
      (this.mRows[i]).used = false; 
    releaseRows();
    this.mNumRows = 0;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\solver\LinearSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */