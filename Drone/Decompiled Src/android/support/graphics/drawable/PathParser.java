package android.support.graphics.drawable;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

class PathParser {
  private static final String LOGTAG = "PathParser";
  
  private static void addNode(ArrayList<PathDataNode> paramArrayList, char paramChar, float[] paramArrayOffloat) {
    paramArrayList.add(new PathDataNode(paramChar, paramArrayOffloat));
  }
  
  public static boolean canMorph(PathDataNode[] paramArrayOfPathDataNode1, PathDataNode[] paramArrayOfPathDataNode2) {
    if (paramArrayOfPathDataNode1 != null && paramArrayOfPathDataNode2 != null && paramArrayOfPathDataNode1.length == paramArrayOfPathDataNode2.length) {
      int i = 0;
      while (i < paramArrayOfPathDataNode1.length) {
        if ((paramArrayOfPathDataNode1[i]).type == (paramArrayOfPathDataNode2[i]).type && (paramArrayOfPathDataNode1[i]).params.length == (paramArrayOfPathDataNode2[i]).params.length) {
          i++;
          continue;
        } 
        return false;
      } 
      return true;
    } 
    return false;
  }
  
  static float[] copyOfRange(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException(); 
    int i = paramArrayOffloat.length;
    if (paramInt1 < 0 || paramInt1 > i)
      throw new ArrayIndexOutOfBoundsException(); 
    paramInt2 -= paramInt1;
    i = Math.min(paramInt2, i - paramInt1);
    float[] arrayOfFloat = new float[paramInt2];
    System.arraycopy(paramArrayOffloat, paramInt1, arrayOfFloat, 0, i);
    return arrayOfFloat;
  }
  
  public static PathDataNode[] createNodesFromPathData(String paramString) {
    if (paramString == null)
      return null; 
    int i = 0;
    int j = 1;
    ArrayList<PathDataNode> arrayList = new ArrayList();
    while (j < paramString.length()) {
      j = nextStart(paramString, j);
      String str = paramString.substring(i, j).trim();
      if (str.length() > 0) {
        float[] arrayOfFloat = getFloats(str);
        addNode(arrayList, str.charAt(0), arrayOfFloat);
      } 
      i = j;
      j++;
    } 
    if (j - i == 1 && i < paramString.length())
      addNode(arrayList, paramString.charAt(i), new float[0]); 
    return arrayList.<PathDataNode>toArray(new PathDataNode[arrayList.size()]);
  }
  
  public static Path createPathFromPathData(String paramString) {
    Path path = new Path();
    PathDataNode[] arrayOfPathDataNode = createNodesFromPathData(paramString);
    if (arrayOfPathDataNode != null)
      try {
        PathDataNode.nodesToPath(arrayOfPathDataNode, path);
        return path;
      } catch (RuntimeException runtimeException) {
        throw new RuntimeException("Error in parsing " + paramString, runtimeException);
      }  
    return null;
  }
  
  public static PathDataNode[] deepCopyNodes(PathDataNode[] paramArrayOfPathDataNode) {
    if (paramArrayOfPathDataNode == null)
      return null; 
    PathDataNode[] arrayOfPathDataNode = new PathDataNode[paramArrayOfPathDataNode.length];
    int i = 0;
    while (true) {
      PathDataNode[] arrayOfPathDataNode1 = arrayOfPathDataNode;
      if (i < paramArrayOfPathDataNode.length) {
        arrayOfPathDataNode[i] = new PathDataNode(paramArrayOfPathDataNode[i]);
        i++;
        continue;
      } 
      return arrayOfPathDataNode1;
    } 
  }
  
  private static void extract(String paramString, int paramInt, ExtractFloatResult paramExtractFloatResult) {
    Object object1;
    Object object2;
    Object object3;
    int i = paramInt;
    boolean bool2 = false;
    paramExtractFloatResult.mEndWithNegOrDot = false;
    boolean bool1 = false;
    boolean bool3 = false;
    while (true) {
      if (i < paramString.length()) {
        Object object6;
        boolean bool5;
        Object object5;
        boolean bool4;
        Object object4;
        boolean bool6;
        Object object7;
        boolean bool7 = false;
        switch (paramString.charAt(i)) {
          default:
            object7 = object1;
            bool6 = bool7;
            object6 = object2;
            if (object6 != null) {
              paramExtractFloatResult.mEndPosition = i;
              return;
            } 
            break;
          case ' ':
          case ',':
            bool5 = true;
            bool6 = bool7;
            object7 = object1;
            if (bool5) {
              paramExtractFloatResult.mEndPosition = i;
              return;
            } 
            break;
          case '-':
            object5 = object2;
            bool6 = bool7;
            object7 = object1;
            if (i != paramInt) {
              object5 = object2;
              bool6 = bool7;
              object7 = object1;
              if (object3 == null) {
                bool4 = true;
                paramExtractFloatResult.mEndWithNegOrDot = true;
                bool6 = bool7;
                object7 = object1;
              } 
            } 
            if (bool4) {
              paramExtractFloatResult.mEndPosition = i;
              return;
            } 
            break;
          case '.':
            if (object1 == null) {
              boolean bool = true;
              Object object = object2;
              bool6 = bool7;
            } else {
              bool4 = true;
              paramExtractFloatResult.mEndWithNegOrDot = true;
              bool6 = bool7;
              object7 = object1;
            } 
            if (bool4) {
              paramExtractFloatResult.mEndPosition = i;
              return;
            } 
            break;
          case 'E':
          case 'e':
            bool6 = true;
            object4 = object2;
            object7 = object1;
            if (object4 != null) {
              paramExtractFloatResult.mEndPosition = i;
              return;
            } 
            break;
        } 
        continue;
      } 
      paramExtractFloatResult.mEndPosition = i;
      return;
      i++;
      object2 = SYNTHETIC_LOCAL_VARIABLE_3;
      object3 = SYNTHETIC_LOCAL_VARIABLE_4;
      object1 = SYNTHETIC_LOCAL_VARIABLE_9;
    } 
  }
  
  private static float[] getFloats(String paramString) {
    int i;
    int j = 1;
    if (paramString.charAt(0) == 'z') {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramString.charAt(0) != 'Z')
      j = 0; 
    if ((i | j) != 0)
      return new float[0]; 
    try {
      float[] arrayOfFloat = new float[paramString.length()];
      j = 1;
      ExtractFloatResult extractFloatResult = new ExtractFloatResult();
      int k = paramString.length();
      i = 0;
      while (true) {
        int m;
        if (j < k) {
          extract(paramString, j, extractFloatResult);
          m = extractFloatResult.mEndPosition;
          if (j < m) {
            int n = i + 1;
            arrayOfFloat[i] = Float.parseFloat(paramString.substring(j, m));
            i = n;
          } 
          if (extractFloatResult.mEndWithNegOrDot) {
            j = m;
            continue;
          } 
        } else {
          return copyOfRange(arrayOfFloat, 0, i);
        } 
        j = m + 1;
      } 
    } catch (NumberFormatException numberFormatException) {
      throw new RuntimeException("error in parsing \"" + paramString + "\"", numberFormatException);
    } 
  }
  
  private static int nextStart(String paramString, int paramInt) {
    while (true) {
      if (paramInt < paramString.length()) {
        char c = paramString.charAt(paramInt);
        if (((c - 65) * (c - 90) > 0 && (c - 97) * (c - 122) > 0) || c == 'e' || c == 'E') {
          paramInt++;
          continue;
        } 
      } 
      return paramInt;
    } 
  }
  
  public static void updateNodes(PathDataNode[] paramArrayOfPathDataNode1, PathDataNode[] paramArrayOfPathDataNode2) {
    for (int i = 0; i < paramArrayOfPathDataNode2.length; i++) {
      (paramArrayOfPathDataNode1[i]).type = (paramArrayOfPathDataNode2[i]).type;
      for (int j = 0; j < (paramArrayOfPathDataNode2[i]).params.length; j++)
        (paramArrayOfPathDataNode1[i]).params[j] = (paramArrayOfPathDataNode2[i]).params[j]; 
    } 
  }
  
  private static class ExtractFloatResult {
    int mEndPosition;
    
    boolean mEndWithNegOrDot;
  }
  
  public static class PathDataNode {
    float[] params;
    
    char type;
    
    PathDataNode(char param1Char, float[] param1ArrayOffloat) {
      this.type = param1Char;
      this.params = param1ArrayOffloat;
    }
    
    PathDataNode(PathDataNode param1PathDataNode) {
      this.type = param1PathDataNode.type;
      this.params = PathParser.copyOfRange(param1PathDataNode.params, 0, param1PathDataNode.params.length);
    }
    
    private static void addCommand(Path param1Path, float[] param1ArrayOffloat1, char param1Char1, char param1Char2, float[] param1ArrayOffloat2) {
      float f7;
      float f8;
      float f9;
      char c;
      boolean bool;
      byte b = 2;
      float f1 = param1ArrayOffloat1[0];
      float f2 = param1ArrayOffloat1[1];
      float f4 = param1ArrayOffloat1[2];
      float f6 = param1ArrayOffloat1[3];
      float f3 = param1ArrayOffloat1[4];
      float f5 = param1ArrayOffloat1[5];
      switch (param1Char2) {
        default:
          bool = false;
          c = param1Char1;
          param1Char1 = bool;
          f7 = f5;
          f5 = f3;
          f8 = f6;
          f9 = f4;
          while (true) {
            int i;
            if (param1Char1 < param1ArrayOffloat2.length) {
              boolean bool1;
              boolean bool2;
              switch (param1Char2) {
                default:
                  f6 = f7;
                  f4 = f8;
                  f3 = f9;
                  c = param1Char2;
                  i = param1Char1 + b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'm':
                  f1 += param1ArrayOffloat2[i + 0];
                  f2 += param1ArrayOffloat2[i + 1];
                  if (i > 0) {
                    param1Path.rLineTo(param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1]);
                    f3 = f9;
                    f4 = f8;
                    f6 = f7;
                  } else {
                    param1Path.rMoveTo(param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1]);
                    f5 = f1;
                    f6 = f2;
                    f3 = f9;
                    f4 = f8;
                  } 
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'M':
                  f1 = param1ArrayOffloat2[i + 0];
                  f2 = param1ArrayOffloat2[i + 1];
                  if (i > 0) {
                    param1Path.lineTo(param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1]);
                    f3 = f9;
                    f4 = f8;
                    f6 = f7;
                  } else {
                    param1Path.moveTo(param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1]);
                    f5 = f1;
                    f6 = f2;
                    f3 = f9;
                    f4 = f8;
                  } 
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'l':
                  param1Path.rLineTo(param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1]);
                  f1 += param1ArrayOffloat2[i + 0];
                  f2 += param1ArrayOffloat2[i + 1];
                  f3 = f9;
                  f4 = f8;
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'L':
                  param1Path.lineTo(param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1]);
                  f1 = param1ArrayOffloat2[i + 0];
                  f2 = param1ArrayOffloat2[i + 1];
                  f3 = f9;
                  f4 = f8;
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'h':
                  param1Path.rLineTo(param1ArrayOffloat2[i + 0], 0.0F);
                  f1 += param1ArrayOffloat2[i + 0];
                  f3 = f9;
                  f4 = f8;
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'H':
                  param1Path.lineTo(param1ArrayOffloat2[i + 0], f2);
                  f1 = param1ArrayOffloat2[i + 0];
                  f3 = f9;
                  f4 = f8;
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'v':
                  param1Path.rLineTo(0.0F, param1ArrayOffloat2[i + 0]);
                  f2 += param1ArrayOffloat2[i + 0];
                  f3 = f9;
                  f4 = f8;
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'V':
                  param1Path.lineTo(f1, param1ArrayOffloat2[i + 0]);
                  f2 = param1ArrayOffloat2[i + 0];
                  f3 = f9;
                  f4 = f8;
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'c':
                  param1Path.rCubicTo(param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1], param1ArrayOffloat2[i + 2], param1ArrayOffloat2[i + 3], param1ArrayOffloat2[i + 4], param1ArrayOffloat2[i + 5]);
                  f3 = f1 + param1ArrayOffloat2[i + 2];
                  f4 = f2 + param1ArrayOffloat2[i + 3];
                  f1 += param1ArrayOffloat2[i + 4];
                  f2 += param1ArrayOffloat2[i + 5];
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'C':
                  param1Path.cubicTo(param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1], param1ArrayOffloat2[i + 2], param1ArrayOffloat2[i + 3], param1ArrayOffloat2[i + 4], param1ArrayOffloat2[i + 5]);
                  f1 = param1ArrayOffloat2[i + 4];
                  f2 = param1ArrayOffloat2[i + 5];
                  f3 = param1ArrayOffloat2[i + 2];
                  f4 = param1ArrayOffloat2[i + 3];
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 's':
                  f3 = 0.0F;
                  f4 = 0.0F;
                  if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                    f3 = f1 - f9;
                    f4 = f2 - f8;
                  } 
                  param1Path.rCubicTo(f3, f4, param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1], param1ArrayOffloat2[i + 2], param1ArrayOffloat2[i + 3]);
                  f3 = f1 + param1ArrayOffloat2[i + 0];
                  f4 = f2 + param1ArrayOffloat2[i + 1];
                  f1 += param1ArrayOffloat2[i + 2];
                  f2 += param1ArrayOffloat2[i + 3];
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'S':
                  f4 = f1;
                  f3 = f2;
                  if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                    f4 = 2.0F * f1 - f9;
                    f3 = 2.0F * f2 - f8;
                  } 
                  param1Path.cubicTo(f4, f3, param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1], param1ArrayOffloat2[i + 2], param1ArrayOffloat2[i + 3]);
                  f3 = param1ArrayOffloat2[i + 0];
                  f4 = param1ArrayOffloat2[i + 1];
                  f1 = param1ArrayOffloat2[i + 2];
                  f2 = param1ArrayOffloat2[i + 3];
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'q':
                  param1Path.rQuadTo(param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1], param1ArrayOffloat2[i + 2], param1ArrayOffloat2[i + 3]);
                  f3 = f1 + param1ArrayOffloat2[i + 0];
                  f4 = f2 + param1ArrayOffloat2[i + 1];
                  f1 += param1ArrayOffloat2[i + 2];
                  f2 += param1ArrayOffloat2[i + 3];
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'Q':
                  param1Path.quadTo(param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1], param1ArrayOffloat2[i + 2], param1ArrayOffloat2[i + 3]);
                  f3 = param1ArrayOffloat2[i + 0];
                  f4 = param1ArrayOffloat2[i + 1];
                  f1 = param1ArrayOffloat2[i + 2];
                  f2 = param1ArrayOffloat2[i + 3];
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 't':
                  f4 = 0.0F;
                  f3 = 0.0F;
                  if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                    f4 = f1 - f9;
                    f3 = f2 - f8;
                  } 
                  param1Path.rQuadTo(f4, f3, param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1]);
                  f4 = f1 + f4;
                  f6 = f2 + f3;
                  f1 += param1ArrayOffloat2[i + 0];
                  f2 += param1ArrayOffloat2[i + 1];
                  f3 = f4;
                  f4 = f6;
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'T':
                  f4 = f1;
                  f3 = f2;
                  if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                    f4 = 2.0F * f1 - f9;
                    f3 = 2.0F * f2 - f8;
                  } 
                  param1Path.quadTo(f4, f3, param1ArrayOffloat2[i + 0], param1ArrayOffloat2[i + 1]);
                  f1 = f3;
                  f8 = param1ArrayOffloat2[i + 0];
                  f2 = param1ArrayOffloat2[i + 1];
                  f3 = f4;
                  f4 = f1;
                  f6 = f7;
                  f1 = f8;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'a':
                  f3 = param1ArrayOffloat2[i + 5];
                  f4 = param1ArrayOffloat2[i + 6];
                  f6 = param1ArrayOffloat2[i + 0];
                  f8 = param1ArrayOffloat2[i + 1];
                  f9 = param1ArrayOffloat2[i + 2];
                  if (param1ArrayOffloat2[i + 3] != 0.0F) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  } 
                  if (param1ArrayOffloat2[i + 4] != 0.0F) {
                    bool2 = true;
                  } else {
                    bool2 = false;
                  } 
                  drawArc(param1Path, f1, f2, f3 + f1, f4 + f2, f6, f8, f9, bool1, bool2);
                  f1 += param1ArrayOffloat2[i + 5];
                  f2 += param1ArrayOffloat2[i + 6];
                  f3 = f1;
                  f4 = f2;
                  f6 = f7;
                  c = param1Char2;
                  i += b;
                  f9 = f3;
                  f8 = f4;
                  f7 = f6;
                  continue;
                case 'A':
                  break;
              } 
              f3 = param1ArrayOffloat2[i + 5];
              f4 = param1ArrayOffloat2[i + 6];
              f6 = param1ArrayOffloat2[i + 0];
              f8 = param1ArrayOffloat2[i + 1];
              f9 = param1ArrayOffloat2[i + 2];
              if (param1ArrayOffloat2[i + 3] != 0.0F) {
                bool1 = true;
              } else {
                bool1 = false;
              } 
              if (param1ArrayOffloat2[i + 4] != 0.0F) {
                bool2 = true;
              } else {
                bool2 = false;
              } 
              drawArc(param1Path, f1, f2, f3, f4, f6, f8, f9, bool1, bool2);
              f1 = param1ArrayOffloat2[i + 5];
              f2 = param1ArrayOffloat2[i + 6];
              f3 = f1;
              f4 = f2;
              f6 = f7;
            } else {
              break;
            } 
            c = param1Char2;
            i += b;
            f9 = f3;
            f8 = f4;
            f7 = f6;
          } 
          break;
        case 'Z':
        case 'z':
          param1Path.close();
          f1 = f3;
          f2 = f5;
          f4 = f3;
          f6 = f5;
          param1Path.moveTo(f1, f2);
        case 'L':
        case 'M':
        case 'T':
        case 'l':
        case 'm':
        case 't':
          b = 2;
        case 'H':
        case 'V':
        case 'h':
        case 'v':
          b = 1;
        case 'C':
        case 'c':
          b = 6;
        case 'Q':
        case 'S':
        case 'q':
        case 's':
          b = 4;
        case 'A':
        case 'a':
          b = 7;
      } 
      param1ArrayOffloat1[0] = f1;
      param1ArrayOffloat1[1] = f2;
      param1ArrayOffloat1[2] = f9;
      param1ArrayOffloat1[3] = f8;
      param1ArrayOffloat1[4] = f5;
      param1ArrayOffloat1[5] = f7;
    }
    
    private static void arcToBezier(Path param1Path, double param1Double1, double param1Double2, double param1Double3, double param1Double4, double param1Double5, double param1Double6, double param1Double7, double param1Double8, double param1Double9) {
      int j = (int)Math.ceil(Math.abs(4.0D * param1Double9 / Math.PI));
      double d1 = param1Double8;
      double d4 = Math.cos(param1Double7);
      double d5 = Math.sin(param1Double7);
      param1Double7 = Math.cos(d1);
      param1Double8 = Math.sin(d1);
      double d2 = -param1Double3 * d4 * param1Double8 - param1Double4 * d5 * param1Double7;
      double d3 = -param1Double3 * d5 * param1Double8 + param1Double4 * d4 * param1Double7;
      double d6 = param1Double9 / j;
      int i = 0;
      param1Double8 = param1Double6;
      param1Double7 = param1Double5;
      param1Double9 = d1;
      param1Double6 = d3;
      param1Double5 = d2;
      while (i < j) {
        double d8 = param1Double9 + d6;
        d3 = Math.sin(d8);
        double d9 = Math.cos(d8);
        double d7 = param1Double3 * d4 * d9 + param1Double1 - param1Double4 * d5 * d3;
        d2 = param1Double3 * d5 * d9 + param1Double2 + param1Double4 * d4 * d3;
        d1 = -param1Double3 * d4 * d3 - param1Double4 * d5 * d9;
        d3 = -param1Double3 * d5 * d3 + param1Double4 * d4 * d9;
        d9 = Math.tan((d8 - param1Double9) / 2.0D);
        param1Double9 = Math.sin(d8 - param1Double9) * (Math.sqrt(4.0D + 3.0D * d9 * d9) - 1.0D) / 3.0D;
        param1Path.rLineTo(0.0F, 0.0F);
        param1Path.cubicTo((float)(param1Double7 + param1Double9 * param1Double5), (float)(param1Double8 + param1Double9 * param1Double6), (float)(d7 - param1Double9 * d1), (float)(d2 - param1Double9 * d3), (float)d7, (float)d2);
        param1Double9 = d8;
        param1Double7 = d7;
        param1Double8 = d2;
        param1Double5 = d1;
        param1Double6 = d3;
        i++;
      } 
    }
    
    private static void drawArc(Path param1Path, float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6, float param1Float7, boolean param1Boolean1, boolean param1Boolean2) {
      double d5 = Math.toRadians(param1Float7);
      double d6 = Math.cos(d5);
      double d7 = Math.sin(d5);
      double d8 = (param1Float1 * d6 + param1Float2 * d7) / param1Float5;
      double d9 = (-param1Float1 * d7 + param1Float2 * d6) / param1Float6;
      double d1 = (param1Float3 * d6 + param1Float4 * d7) / param1Float5;
      double d4 = (-param1Float3 * d7 + param1Float4 * d6) / param1Float6;
      double d11 = d8 - d1;
      double d10 = d9 - d4;
      double d3 = (d8 + d1) / 2.0D;
      double d2 = (d9 + d4) / 2.0D;
      double d12 = d11 * d11 + d10 * d10;
      if (d12 == 0.0D) {
        Log.w("PathParser", " Points are coincident");
        return;
      } 
      double d13 = 1.0D / d12 - 0.25D;
      if (d13 < 0.0D) {
        Log.w("PathParser", "Points are too far apart " + d12);
        float f = (float)(Math.sqrt(d12) / 1.99999D);
        drawArc(param1Path, param1Float1, param1Float2, param1Float3, param1Float4, param1Float5 * f, param1Float6 * f, param1Float7, param1Boolean1, param1Boolean2);
        return;
      } 
      d12 = Math.sqrt(d13);
      d11 = d12 * d11;
      d10 = d12 * d10;
      if (param1Boolean1 == param1Boolean2) {
        d3 -= d10;
        d2 += d11;
      } else {
        d3 += d10;
        d2 -= d11;
      } 
      d8 = Math.atan2(d9 - d2, d8 - d3);
      d4 = Math.atan2(d4 - d2, d1 - d3) - d8;
      if (d4 >= 0.0D) {
        param1Boolean1 = true;
      } else {
        param1Boolean1 = false;
      } 
      d1 = d4;
      if (param1Boolean2 != param1Boolean1)
        if (d4 > 0.0D) {
          d1 = d4 - 6.283185307179586D;
        } else {
          d1 = d4 + 6.283185307179586D;
        }  
      d3 *= param1Float5;
      d2 *= param1Float6;
      arcToBezier(param1Path, d3 * d6 - d2 * d7, d3 * d7 + d2 * d6, param1Float5, param1Float6, param1Float1, param1Float2, d5, d8, d1);
    }
    
    public static void nodesToPath(PathDataNode[] param1ArrayOfPathDataNode, Path param1Path) {
      float[] arrayOfFloat = new float[6];
      char c = 'm';
      for (int i = 0; i < param1ArrayOfPathDataNode.length; i++) {
        addCommand(param1Path, arrayOfFloat, c, (param1ArrayOfPathDataNode[i]).type, (param1ArrayOfPathDataNode[i]).params);
        c = (param1ArrayOfPathDataNode[i]).type;
      } 
    }
    
    public void interpolatePathDataNode(PathDataNode param1PathDataNode1, PathDataNode param1PathDataNode2, float param1Float) {
      int i;
      for (i = 0; i < param1PathDataNode1.params.length; i++)
        this.params[i] = param1PathDataNode1.params[i] * (1.0F - param1Float) + param1PathDataNode2.params[i] * param1Float; 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\graphics\drawable\PathParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */