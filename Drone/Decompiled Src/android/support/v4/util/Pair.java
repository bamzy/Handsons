package android.support.v4.util;

public class Pair<F, S> {
  public final F first;
  
  public final S second;
  
  public Pair(F paramF, S paramS) {
    this.first = paramF;
    this.second = paramS;
  }
  
  public static <A, B> Pair<A, B> create(A paramA, B paramB) {
    return new Pair<A, B>(paramA, paramB);
  }
  
  private static boolean objectsEqual(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof Pair) {
      paramObject = paramObject;
      if (objectsEqual(((Pair)paramObject).first, this.first) && objectsEqual(((Pair)paramObject).second, this.second))
        return true; 
    } 
    return false;
  }
  
  public int hashCode() {
    int i;
    int j = 0;
    if (this.first == null) {
      i = 0;
    } else {
      i = this.first.hashCode();
    } 
    if (this.second != null)
      j = this.second.hashCode(); 
    return i ^ j;
  }
  
  public String toString() {
    return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v\\util\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */