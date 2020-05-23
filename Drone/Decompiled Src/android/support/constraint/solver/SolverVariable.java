package android.support.constraint.solver;

import java.util.Arrays;

public class SolverVariable {
  private static final boolean INTERNAL_DEBUG = false;
  
  static final int MAX_STRENGTH = 6;
  
  public static final int STRENGTH_EQUALITY = 5;
  
  public static final int STRENGTH_HIGH = 3;
  
  public static final int STRENGTH_HIGHEST = 4;
  
  public static final int STRENGTH_LOW = 1;
  
  public static final int STRENGTH_MEDIUM = 2;
  
  public static final int STRENGTH_NONE = 0;
  
  private static int uniqueId = 1;
  
  public float computedValue;
  
  int definitionId = -1;
  
  public int id = -1;
  
  ArrayRow[] mClientEquations = new ArrayRow[8];
  
  int mClientEquationsCount = 0;
  
  private String mName;
  
  Type mType;
  
  public int strength = 0;
  
  float[] strengthVector = new float[6];
  
  public SolverVariable(Type paramType) {
    this.mType = paramType;
  }
  
  public SolverVariable(String paramString, Type paramType) {
    this.mName = paramString;
    this.mType = paramType;
  }
  
  private static String getUniqueName(Type paramType) {
    uniqueId++;
    switch (paramType) {
      default:
        return "V" + uniqueId;
      case UNRESTRICTED:
        return "U" + uniqueId;
      case CONSTANT:
        return "C" + uniqueId;
      case SLACK:
        return "S" + uniqueId;
      case ERROR:
        break;
    } 
    return "e" + uniqueId;
  }
  
  void addClientEquation(ArrayRow paramArrayRow) {
    for (int i = 0; i < this.mClientEquationsCount; i++) {
      if (this.mClientEquations[i] == paramArrayRow)
        return; 
    } 
    if (this.mClientEquationsCount >= this.mClientEquations.length)
      this.mClientEquations = Arrays.<ArrayRow>copyOf(this.mClientEquations, this.mClientEquations.length * 2); 
    this.mClientEquations[this.mClientEquationsCount] = paramArrayRow;
    this.mClientEquationsCount++;
  }
  
  void clearStrengths() {
    for (int i = 0; i < 6; i++)
      this.strengthVector[i] = 0.0F; 
  }
  
  public String getName() {
    return this.mName;
  }
  
  void removeClientEquation(ArrayRow paramArrayRow) {
    for (int i = 0;; i++) {
      if (i < this.mClientEquationsCount) {
        if (this.mClientEquations[i] == paramArrayRow) {
          for (int j = 0; j < this.mClientEquationsCount - i - 1; j++)
            this.mClientEquations[i + j] = this.mClientEquations[i + j + 1]; 
          this.mClientEquationsCount--;
          return;
        } 
      } else {
        return;
      } 
    } 
  }
  
  public void reset() {
    this.mName = null;
    this.mType = Type.UNKNOWN;
    this.strength = 0;
    this.id = -1;
    this.definitionId = -1;
    this.computedValue = 0.0F;
    this.mClientEquationsCount = 0;
  }
  
  public void setName(String paramString) {
    this.mName = paramString;
  }
  
  public void setType(Type paramType) {
    this.mType = paramType;
  }
  
  String strengthsToString() {
    String str = this + "[";
    for (int i = 0; i < this.strengthVector.length; i++) {
      str = str + this.strengthVector[i];
      if (i < this.strengthVector.length - 1) {
        str = str + ", ";
      } else {
        str = str + "] ";
      } 
    } 
    return str;
  }
  
  public String toString() {
    return "" + this.mName;
  }
  
  public enum Type {
    CONSTANT, ERROR, SLACK, UNKNOWN, UNRESTRICTED;
    
    static {
      ERROR = new Type("ERROR", 3);
      UNKNOWN = new Type("UNKNOWN", 4);
      $VALUES = new Type[] { UNRESTRICTED, CONSTANT, SLACK, ERROR, UNKNOWN };
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\solver\SolverVariable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */