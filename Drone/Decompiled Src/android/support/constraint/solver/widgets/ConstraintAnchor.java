package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;
import java.util.HashSet;

public class ConstraintAnchor {
  private static final boolean ALLOW_BINARY = false;
  
  public static final int ANY_GROUP = 2147483647;
  
  public static final int APPLY_GROUP_RESULTS = -2;
  
  public static final int AUTO_CONSTRAINT_CREATOR = 2;
  
  public static final int SCOUT_CREATOR = 1;
  
  private static final int UNSET_GONE_MARGIN = -1;
  
  public static final int USER_CREATOR = 0;
  
  public static final boolean USE_CENTER_ANCHOR = false;
  
  private int mConnectionCreator = 0;
  
  private ConnectionType mConnectionType = ConnectionType.RELAXED;
  
  int mGoneMargin = -1;
  
  int mGroup = Integer.MAX_VALUE;
  
  public int mMargin = 0;
  
  final ConstraintWidget mOwner;
  
  SolverVariable mSolverVariable;
  
  private Strength mStrength = Strength.NONE;
  
  ConstraintAnchor mTarget;
  
  final Type mType;
  
  public ConstraintAnchor(ConstraintWidget paramConstraintWidget, Type paramType) {
    this.mOwner = paramConstraintWidget;
    this.mType = paramType;
  }
  
  private boolean isConnectionToMe(ConstraintWidget paramConstraintWidget, HashSet<ConstraintWidget> paramHashSet) {
    if (!paramHashSet.contains(paramConstraintWidget)) {
      paramHashSet.add(paramConstraintWidget);
      if (paramConstraintWidget == getOwner())
        return true; 
      ArrayList<ConstraintAnchor> arrayList = paramConstraintWidget.getAnchors();
      int i = 0;
      int j = arrayList.size();
      while (true) {
        if (i < j) {
          ConstraintAnchor constraintAnchor = arrayList.get(i);
          if (constraintAnchor.isSimilarDimensionConnection(this) && constraintAnchor.isConnected() && isConnectionToMe(constraintAnchor.getTarget().getOwner(), paramHashSet))
            return true; 
          i++;
          continue;
        } 
        return false;
      } 
    } 
    return false;
  }
  
  private String toString(HashSet<ConstraintAnchor> paramHashSet) {
    if (paramHashSet.add(this)) {
      StringBuilder stringBuilder = (new StringBuilder()).append(this.mOwner.getDebugName()).append(":").append(this.mType.toString());
      if (this.mTarget != null) {
        String str1 = " connected to " + this.mTarget.toString(paramHashSet);
        return stringBuilder.append(str1).toString();
      } 
      String str = "";
      return stringBuilder.append(str).toString();
    } 
    return "<-";
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt) {
    return connect(paramConstraintAnchor, paramInt, -1, Strength.STRONG, 0, false);
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2) {
    return connect(paramConstraintAnchor, paramInt1, -1, Strength.STRONG, paramInt2, false);
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2, Strength paramStrength, int paramInt3, boolean paramBoolean) {
    if (paramConstraintAnchor == null) {
      this.mTarget = null;
      this.mMargin = 0;
      this.mGoneMargin = -1;
      this.mStrength = Strength.NONE;
      this.mConnectionCreator = 2;
      return true;
    } 
    if (!paramBoolean && !isValidConnection(paramConstraintAnchor))
      return false; 
    this.mTarget = paramConstraintAnchor;
    if (paramInt1 > 0) {
      this.mMargin = paramInt1;
      this.mGoneMargin = paramInt2;
      this.mStrength = paramStrength;
      this.mConnectionCreator = paramInt3;
      return true;
    } 
    this.mMargin = 0;
    this.mGoneMargin = paramInt2;
    this.mStrength = paramStrength;
    this.mConnectionCreator = paramInt3;
    return true;
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, Strength paramStrength, int paramInt2) {
    return connect(paramConstraintAnchor, paramInt1, -1, paramStrength, paramInt2, false);
  }
  
  public int getConnectionCreator() {
    return this.mConnectionCreator;
  }
  
  public ConnectionType getConnectionType() {
    return this.mConnectionType;
  }
  
  public int getGroup() {
    return this.mGroup;
  }
  
  public int getMargin() {
    return (this.mOwner.getVisibility() == 8) ? 0 : ((this.mGoneMargin > -1 && this.mTarget != null && this.mTarget.mOwner.getVisibility() == 8) ? this.mGoneMargin : this.mMargin);
  }
  
  public final ConstraintAnchor getOpposite() {
    switch (this.mType) {
      default:
        return null;
      case LEFT:
        return this.mOwner.mRight;
      case RIGHT:
        return this.mOwner.mLeft;
      case TOP:
        return this.mOwner.mBottom;
      case BOTTOM:
        break;
    } 
    return this.mOwner.mTop;
  }
  
  public ConstraintWidget getOwner() {
    return this.mOwner;
  }
  
  public int getPriorityLevel() {
    switch (this.mType) {
      default:
        return 0;
      case BASELINE:
        return 1;
      case LEFT:
        return 2;
      case RIGHT:
        return 2;
      case TOP:
        return 2;
      case BOTTOM:
        return 2;
      case CENTER:
        break;
    } 
    return 2;
  }
  
  public int getSnapPriorityLevel() {
    boolean bool = true;
    switch (this.mType) {
      default:
        bool = false;
      case LEFT:
      case RIGHT:
      case CENTER_Y:
        return bool;
      case CENTER_X:
        return 0;
      case TOP:
        return 0;
      case BOTTOM:
        return 0;
      case BASELINE:
        return 2;
      case CENTER:
        break;
    } 
    return 3;
  }
  
  public SolverVariable getSolverVariable() {
    return this.mSolverVariable;
  }
  
  public Strength getStrength() {
    return this.mStrength;
  }
  
  public ConstraintAnchor getTarget() {
    return this.mTarget;
  }
  
  public Type getType() {
    return this.mType;
  }
  
  public boolean isConnected() {
    return (this.mTarget != null);
  }
  
  public boolean isConnectionAllowed(ConstraintWidget paramConstraintWidget) {
    if (!isConnectionToMe(paramConstraintWidget, new HashSet<ConstraintWidget>())) {
      ConstraintWidget constraintWidget = getOwner().getParent();
      if (constraintWidget == paramConstraintWidget)
        return true; 
      if (paramConstraintWidget.getParent() == constraintWidget)
        return true; 
    } 
    return false;
  }
  
  public boolean isConnectionAllowed(ConstraintWidget paramConstraintWidget, ConstraintAnchor paramConstraintAnchor) {
    return isConnectionAllowed(paramConstraintWidget);
  }
  
  public boolean isSideAnchor() {
    switch (this.mType) {
      default:
        return false;
      case LEFT:
      case RIGHT:
      case TOP:
      case BOTTOM:
        break;
    } 
    return true;
  }
  
  public boolean isSimilarDimensionConnection(ConstraintAnchor paramConstraintAnchor) {
    boolean bool1 = true;
    boolean bool2 = false;
    Type type = paramConstraintAnchor.getType();
    if (type == this.mType)
      return true; 
    switch (this.mType) {
      default:
        return false;
      case CENTER:
        if (type == Type.BASELINE)
          bool1 = false; 
        return bool1;
      case LEFT:
      case RIGHT:
      case CENTER_X:
        if (type != Type.LEFT && type != Type.RIGHT) {
          bool1 = bool2;
          return (type == Type.CENTER_X) ? true : bool1;
        } 
        return true;
      case TOP:
      case BOTTOM:
      case CENTER_Y:
      case BASELINE:
        break;
    } 
    if (type != Type.TOP && type != Type.BOTTOM && type != Type.CENTER_Y) {
      bool1 = bool2;
      return (type == Type.BASELINE) ? true : bool1;
    } 
    return true;
  }
  
  public boolean isSnapCompatibleWith(ConstraintAnchor paramConstraintAnchor) {
    if (this.mType == Type.CENTER)
      return false; 
    if (this.mType == paramConstraintAnchor.getType())
      return true; 
    switch (this.mType) {
      default:
        return false;
      case LEFT:
        switch (paramConstraintAnchor.getType()) {
          default:
            return false;
          case RIGHT:
            return true;
          case CENTER_X:
            break;
        } 
        return true;
      case RIGHT:
        switch (paramConstraintAnchor.getType()) {
          default:
            return false;
          case LEFT:
            return true;
          case CENTER_X:
            break;
        } 
        return true;
      case CENTER_X:
        switch (paramConstraintAnchor.getType()) {
          default:
            return false;
          case LEFT:
            return true;
          case RIGHT:
            break;
        } 
        return true;
      case TOP:
        switch (paramConstraintAnchor.getType()) {
          default:
            return false;
          case BOTTOM:
            return true;
          case CENTER_Y:
            break;
        } 
        return true;
      case BOTTOM:
        switch (paramConstraintAnchor.getType()) {
          default:
            return false;
          case TOP:
            return true;
          case CENTER_Y:
            break;
        } 
        return true;
      case CENTER_Y:
        break;
    } 
    switch (paramConstraintAnchor.getType()) {
      default:
        return false;
      case TOP:
        return true;
      case BOTTOM:
        break;
    } 
    return true;
  }
  
  public boolean isValidConnection(ConstraintAnchor paramConstraintAnchor) {
    boolean bool = true;
    if (paramConstraintAnchor == null)
      return false; 
    Type type = paramConstraintAnchor.getType();
    if (type == this.mType)
      return (this.mType != Type.CENTER && (this.mType != Type.BASELINE || (paramConstraintAnchor.getOwner().hasBaseline() && getOwner().hasBaseline()))); 
    switch (this.mType) {
      default:
        return false;
      case CENTER:
        if (type == Type.BASELINE || type == Type.CENTER_X || type == Type.CENTER_Y)
          bool = false; 
        return bool;
      case LEFT:
      case RIGHT:
        if (type == Type.LEFT || type == Type.RIGHT) {
          bool = true;
        } else {
          bool = false;
        } 
        null = bool;
        if (paramConstraintAnchor.getOwner() instanceof Guideline) {
          if (bool || type == Type.CENTER_X)
            return true; 
        } else {
          return null;
        } 
        return false;
      case TOP:
      case BOTTOM:
        break;
    } 
    if (type == Type.TOP || type == Type.BOTTOM) {
      bool = true;
    } else {
      bool = false;
    } 
    null = bool;
    if (paramConstraintAnchor.getOwner() instanceof Guideline) {
      if (bool || type == Type.CENTER_Y)
        return true; 
    } else {
      return null;
    } 
    return false;
  }
  
  public boolean isVerticalAnchor() {
    switch (this.mType) {
      default:
        return true;
      case CENTER:
      case LEFT:
      case RIGHT:
      case CENTER_X:
        break;
    } 
    return false;
  }
  
  public void reset() {
    this.mTarget = null;
    this.mMargin = 0;
    this.mGoneMargin = -1;
    this.mStrength = Strength.STRONG;
    this.mConnectionCreator = 0;
    this.mConnectionType = ConnectionType.RELAXED;
  }
  
  public void resetSolverVariable(Cache paramCache) {
    if (this.mSolverVariable == null) {
      this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
      return;
    } 
    this.mSolverVariable.reset();
  }
  
  public void setConnectionCreator(int paramInt) {
    this.mConnectionCreator = paramInt;
  }
  
  public void setConnectionType(ConnectionType paramConnectionType) {
    this.mConnectionType = paramConnectionType;
  }
  
  public void setGoneMargin(int paramInt) {
    if (isConnected())
      this.mGoneMargin = paramInt; 
  }
  
  public void setGroup(int paramInt) {
    this.mGroup = paramInt;
  }
  
  public void setMargin(int paramInt) {
    if (isConnected())
      this.mMargin = paramInt; 
  }
  
  public void setStrength(Strength paramStrength) {
    if (isConnected())
      this.mStrength = paramStrength; 
  }
  
  public String toString() {
    HashSet<ConstraintAnchor> hashSet = new HashSet();
    StringBuilder stringBuilder = (new StringBuilder()).append(this.mOwner.getDebugName()).append(":").append(this.mType.toString());
    if (this.mTarget != null) {
      String str1 = " connected to " + this.mTarget.toString(hashSet);
      return stringBuilder.append(str1).toString();
    } 
    String str = "";
    return stringBuilder.append(str).toString();
  }
  
  public enum ConnectionType {
    RELAXED, STRICT;
    
    static {
    
    }
  }
  
  public enum Strength {
    NONE, STRONG, WEAK;
    
    static {
    
    }
  }
  
  public enum Type {
    NONE, RIGHT, TOP, BASELINE, BOTTOM, CENTER, CENTER_X, CENTER_Y, LEFT;
    
    static {
      RIGHT = new Type("RIGHT", 3);
      BOTTOM = new Type("BOTTOM", 4);
      BASELINE = new Type("BASELINE", 5);
      CENTER = new Type("CENTER", 6);
      CENTER_X = new Type("CENTER_X", 7);
      CENTER_Y = new Type("CENTER_Y", 8);
      $VALUES = new Type[] { NONE, LEFT, TOP, RIGHT, BOTTOM, BASELINE, CENTER, CENTER_X, CENTER_Y };
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\solver\widgets\ConstraintAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */