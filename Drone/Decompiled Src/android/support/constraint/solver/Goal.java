package android.support.constraint.solver;

import java.util.ArrayList;

public class Goal {
  ArrayList<SolverVariable> variables = new ArrayList<SolverVariable>();
  
  private void initFromSystemErrors(LinearSystem paramLinearSystem) {
    this.variables.clear();
    for (int i = 1; i < paramLinearSystem.mNumColumns; i++) {
      SolverVariable solverVariable = paramLinearSystem.mCache.mIndexedVariables[i];
      for (int j = 0; j < 6; j++)
        solverVariable.strengthVector[j] = 0.0F; 
      solverVariable.strengthVector[solverVariable.strength] = 1.0F;
      if (solverVariable.mType == SolverVariable.Type.ERROR)
        this.variables.add(solverVariable); 
    } 
  }
  
  SolverVariable getPivotCandidate() {
    int k = this.variables.size();
    SolverVariable solverVariable = null;
    int i = 0;
    int j;
    for (j = 0; j < k; j++) {
      SolverVariable solverVariable1 = this.variables.get(j);
      for (int m = 5; m >= 0; m--) {
        float f = solverVariable1.strengthVector[m];
        SolverVariable solverVariable2 = solverVariable;
        int n = i;
        if (solverVariable == null) {
          solverVariable2 = solverVariable;
          n = i;
          if (f < 0.0F) {
            solverVariable2 = solverVariable;
            n = i;
            if (m >= i) {
              n = m;
              solverVariable2 = solverVariable1;
            } 
          } 
        } 
        solverVariable = solverVariable2;
        i = n;
        if (f > 0.0F) {
          solverVariable = solverVariable2;
          i = n;
          if (m > n) {
            i = m;
            solverVariable = null;
          } 
        } 
      } 
    } 
    return solverVariable;
  }
  
  public String toString() {
    String str = "Goal: ";
    int j = this.variables.size();
    for (int i = 0; i < j; i++) {
      SolverVariable solverVariable = this.variables.get(i);
      str = str + solverVariable.strengthsToString();
    } 
    return str;
  }
  
  void updateFromSystem(LinearSystem paramLinearSystem) {
    initFromSystemErrors(paramLinearSystem);
    int j = this.variables.size();
    for (int i = 0; i < j; i++) {
      SolverVariable solverVariable = this.variables.get(i);
      if (solverVariable.definitionId != -1) {
        ArrayLinkedVariables arrayLinkedVariables = (paramLinearSystem.getRow(solverVariable.definitionId)).variables;
        int m = arrayLinkedVariables.currentSize;
        for (int k = 0; k < m; k++) {
          SolverVariable solverVariable1 = arrayLinkedVariables.getVariable(k);
          if (solverVariable1 != null) {
            float f = arrayLinkedVariables.getVariableValue(k);
            int n;
            for (n = 0; n < 6; n++) {
              float[] arrayOfFloat = solverVariable1.strengthVector;
              arrayOfFloat[n] = arrayOfFloat[n] + solverVariable.strengthVector[n] * f;
            } 
            if (!this.variables.contains(solverVariable1))
              this.variables.add(solverVariable1); 
          } 
        } 
        solverVariable.clearStrengths();
      } 
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\solver\Goal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */