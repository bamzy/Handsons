package android.support.v7.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class AppCompatColorStateListInflater {
  private static final int DEFAULT_COLOR = -65536;
  
  @NonNull
  public static ColorStateList createFromXml(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @Nullable Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    int i;
    AttributeSet attributeSet = Xml.asAttributeSet(paramXmlPullParser);
    do {
      i = paramXmlPullParser.next();
    } while (i != 2 && i != 1);
    if (i != 2)
      throw new XmlPullParserException("No start tag found"); 
    return createFromXmlInner(paramResources, paramXmlPullParser, attributeSet, paramTheme);
  }
  
  @NonNull
  private static ColorStateList createFromXmlInner(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    String str = paramXmlPullParser.getName();
    if (!str.equals("selector"))
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid color state list tag " + str); 
    return inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  private static ColorStateList inflate(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    int j = paramXmlPullParser.getDepth() + 1;
    int[][] arrayOfInt3 = new int[20][];
    int[] arrayOfInt4 = new int[arrayOfInt3.length];
    int i = 0;
    while (true) {
      int k = paramXmlPullParser.next();
      if (k != 1) {
        int m = paramXmlPullParser.getDepth();
        if (m >= j || k != 3) {
          if (k == 2 && m <= j && paramXmlPullParser.getName().equals("item")) {
            TypedArray typedArray = obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.ColorStateListItem);
            int n = typedArray.getColor(R.styleable.ColorStateListItem_android_color, -65281);
            float f = 1.0F;
            if (typedArray.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
              f = typedArray.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0F);
            } else if (typedArray.hasValue(R.styleable.ColorStateListItem_alpha)) {
              f = typedArray.getFloat(R.styleable.ColorStateListItem_alpha, 1.0F);
            } 
            typedArray.recycle();
            int i1 = paramAttributeSet.getAttributeCount();
            int[] arrayOfInt = new int[i1];
            m = 0;
            k = 0;
            while (m < i1) {
              int i2 = paramAttributeSet.getAttributeNameResource(m);
              if (i2 != 16843173 && i2 != 16843551 && i2 != R.attr.alpha) {
                int i3 = k + 1;
                if (!paramAttributeSet.getAttributeBooleanValue(m, false))
                  i2 = -i2; 
                arrayOfInt[k] = i2;
                k = i3;
              } 
              m++;
            } 
            arrayOfInt = StateSet.trimStateSet(arrayOfInt, k);
            k = modulateColorAlpha(n, f);
            if (!i || arrayOfInt.length == 0);
            arrayOfInt4 = GrowingArrayUtils.append(arrayOfInt4, i, k);
            arrayOfInt3 = GrowingArrayUtils.<int[]>append(arrayOfInt3, i, arrayOfInt);
            i++;
          } 
          continue;
        } 
      } 
      break;
    } 
    int[] arrayOfInt1 = new int[i];
    int[][] arrayOfInt2 = new int[i][];
    System.arraycopy(arrayOfInt4, 0, arrayOfInt1, 0, i);
    System.arraycopy(arrayOfInt3, 0, arrayOfInt2, 0, i);
    return new ColorStateList(arrayOfInt2, arrayOfInt1);
  }
  
  private static int modulateColorAlpha(int paramInt, float paramFloat) {
    return ColorUtils.setAlphaComponent(paramInt, Math.round(Color.alpha(paramInt) * paramFloat));
  }
  
  private static TypedArray obtainAttributes(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfint) {
    return (paramTheme == null) ? paramResources.obtainAttributes(paramAttributeSet, paramArrayOfint) : paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfint, 0, 0);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\content\res\AppCompatColorStateListInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */