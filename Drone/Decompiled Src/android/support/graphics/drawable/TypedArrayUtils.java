package android.support.graphics.drawable;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

class TypedArrayUtils {
  private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";
  
  public static boolean getNamedBoolean(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, boolean paramBoolean) {
    return !hasAttribute(paramXmlPullParser, paramString) ? paramBoolean : paramTypedArray.getBoolean(paramInt, paramBoolean);
  }
  
  public static int getNamedColor(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2) {
    return !hasAttribute(paramXmlPullParser, paramString) ? paramInt2 : paramTypedArray.getColor(paramInt1, paramInt2);
  }
  
  public static float getNamedFloat(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, float paramFloat) {
    return !hasAttribute(paramXmlPullParser, paramString) ? paramFloat : paramTypedArray.getFloat(paramInt, paramFloat);
  }
  
  public static int getNamedInt(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2) {
    return !hasAttribute(paramXmlPullParser, paramString) ? paramInt2 : paramTypedArray.getInt(paramInt1, paramInt2);
  }
  
  public static boolean hasAttribute(XmlPullParser paramXmlPullParser, String paramString) {
    return (paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\graphics\drawable\TypedArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */