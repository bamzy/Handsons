package android.support.v4.text.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.PatternsCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
  private static final Comparator<LinkSpec> COMPARATOR;
  
  private static final String[] EMPTY_STRING = new String[0];
  
  static {
    COMPARATOR = new Comparator<LinkSpec>() {
        public final int compare(LinkifyCompat.LinkSpec param1LinkSpec1, LinkifyCompat.LinkSpec param1LinkSpec2) {
          if (param1LinkSpec1.start >= param1LinkSpec2.start) {
            if (param1LinkSpec1.start > param1LinkSpec2.start)
              return 1; 
            if (param1LinkSpec1.end < param1LinkSpec2.end)
              return 1; 
            if (param1LinkSpec1.end <= param1LinkSpec2.end)
              return 0; 
          } 
          return -1;
        }
      };
  }
  
  private static void addLinkMovementMethod(@NonNull TextView paramTextView) {
    MovementMethod movementMethod = paramTextView.getMovementMethod();
    if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && paramTextView.getLinksClickable())
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance()); 
  }
  
  public static final void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString) {
    addLinks(paramTextView, paramPattern, paramString, (String[])null, (Linkify.MatchFilter)null, (Linkify.TransformFilter)null);
  }
  
  public static final void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter) {
    addLinks(paramTextView, paramPattern, paramString, (String[])null, paramMatchFilter, paramTransformFilter);
  }
  
  public static final void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter) {
    SpannableString spannableString = SpannableString.valueOf(paramTextView.getText());
    if (addLinks((Spannable)spannableString, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter)) {
      paramTextView.setText((CharSequence)spannableString);
      addLinkMovementMethod(paramTextView);
    } 
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, int paramInt) {
    if (paramInt == 0)
      return false; 
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    for (int i = arrayOfURLSpan.length - 1; i >= 0; i--)
      paramSpannable.removeSpan(arrayOfURLSpan[i]); 
    if ((paramInt & 0x4) != 0)
      Linkify.addLinks(paramSpannable, 4); 
    ArrayList<LinkSpec> arrayList = new ArrayList();
    if ((paramInt & 0x1) != 0) {
      Pattern pattern = PatternsCompat.AUTOLINK_WEB_URL;
      Linkify.MatchFilter matchFilter = Linkify.sUrlMatchFilter;
      gatherLinks(arrayList, paramSpannable, pattern, new String[] { "http://", "https://", "rtsp://" }, matchFilter, null);
    } 
    if ((paramInt & 0x2) != 0)
      gatherLinks(arrayList, paramSpannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[] { "mailto:" }, null, null); 
    if ((paramInt & 0x8) != 0)
      gatherMapLinks(arrayList, paramSpannable); 
    pruneOverlaps(arrayList, paramSpannable);
    if (arrayList.size() == 0)
      return false; 
    for (LinkSpec linkSpec : arrayList) {
      if (linkSpec.frameworkAddedSpan == null)
        applyLink(linkSpec.url, linkSpec.start, linkSpec.end, paramSpannable); 
    } 
    return true;
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString) {
    return addLinks(paramSpannable, paramPattern, paramString, (String[])null, (Linkify.MatchFilter)null, (Linkify.TransformFilter)null);
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter) {
    return addLinks(paramSpannable, paramPattern, paramString, (String[])null, paramMatchFilter, paramTransformFilter);
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter) {
    // Byte code:
    //   0: aload_2
    //   1: astore #10
    //   3: aload_2
    //   4: ifnonnull -> 11
    //   7: ldc ''
    //   9: astore #10
    //   11: aload_3
    //   12: ifnull -> 23
    //   15: aload_3
    //   16: astore_2
    //   17: aload_3
    //   18: arraylength
    //   19: iconst_1
    //   20: if_icmpge -> 27
    //   23: getstatic android/support/v4/text/util/LinkifyCompat.EMPTY_STRING : [Ljava/lang/String;
    //   26: astore_2
    //   27: aload_2
    //   28: arraylength
    //   29: iconst_1
    //   30: iadd
    //   31: anewarray java/lang/String
    //   34: astore #11
    //   36: aload #11
    //   38: iconst_0
    //   39: aload #10
    //   41: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   44: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   47: aastore
    //   48: iconst_0
    //   49: istore #6
    //   51: iload #6
    //   53: aload_2
    //   54: arraylength
    //   55: if_icmpge -> 98
    //   58: aload_2
    //   59: iload #6
    //   61: aaload
    //   62: astore_3
    //   63: aload_3
    //   64: ifnonnull -> 87
    //   67: ldc ''
    //   69: astore_3
    //   70: aload #11
    //   72: iload #6
    //   74: iconst_1
    //   75: iadd
    //   76: aload_3
    //   77: aastore
    //   78: iload #6
    //   80: iconst_1
    //   81: iadd
    //   82: istore #6
    //   84: goto -> 51
    //   87: aload_3
    //   88: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   91: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   94: astore_3
    //   95: goto -> 70
    //   98: iconst_0
    //   99: istore #8
    //   101: aload_1
    //   102: aload_0
    //   103: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual find : ()Z
    //   111: ifeq -> 180
    //   114: aload_1
    //   115: invokevirtual start : ()I
    //   118: istore #6
    //   120: aload_1
    //   121: invokevirtual end : ()I
    //   124: istore #7
    //   126: iconst_1
    //   127: istore #9
    //   129: aload #4
    //   131: ifnull -> 148
    //   134: aload #4
    //   136: aload_0
    //   137: iload #6
    //   139: iload #7
    //   141: invokeinterface acceptMatch : (Ljava/lang/CharSequence;II)Z
    //   146: istore #9
    //   148: iload #9
    //   150: ifeq -> 107
    //   153: aload_1
    //   154: iconst_0
    //   155: invokevirtual group : (I)Ljava/lang/String;
    //   158: aload #11
    //   160: aload_1
    //   161: aload #5
    //   163: invokestatic makeUrl : (Ljava/lang/String;[Ljava/lang/String;Ljava/util/regex/Matcher;Landroid/text/util/Linkify$TransformFilter;)Ljava/lang/String;
    //   166: iload #6
    //   168: iload #7
    //   170: aload_0
    //   171: invokestatic applyLink : (Ljava/lang/String;IILandroid/text/Spannable;)V
    //   174: iconst_1
    //   175: istore #8
    //   177: goto -> 107
    //   180: iload #8
    //   182: ireturn
  }
  
  public static final boolean addLinks(@NonNull TextView paramTextView, int paramInt) {
    if (paramInt != 0) {
      CharSequence charSequence = paramTextView.getText();
      if (charSequence instanceof Spannable) {
        if (addLinks((Spannable)charSequence, paramInt)) {
          addLinkMovementMethod(paramTextView);
          return true;
        } 
        return false;
      } 
      SpannableString spannableString = SpannableString.valueOf(charSequence);
      if (addLinks((Spannable)spannableString, paramInt)) {
        addLinkMovementMethod(paramTextView);
        paramTextView.setText((CharSequence)spannableString);
        return true;
      } 
    } 
    return false;
  }
  
  private static void applyLink(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable) {
    paramSpannable.setSpan(new URLSpan(paramString), paramInt1, paramInt2, 33);
  }
  
  private static void gatherLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable, Pattern paramPattern, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter) {
    Matcher matcher = paramPattern.matcher((CharSequence)paramSpannable);
    while (matcher.find()) {
      int i = matcher.start();
      int j = matcher.end();
      if (paramMatchFilter == null || paramMatchFilter.acceptMatch((CharSequence)paramSpannable, i, j)) {
        LinkSpec linkSpec = new LinkSpec();
        linkSpec.url = makeUrl(matcher.group(0), paramArrayOfString, matcher, paramTransformFilter);
        linkSpec.start = i;
        linkSpec.end = j;
        paramArrayList.add(linkSpec);
      } 
    } 
  }
  
  private static final void gatherMapLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable) {
    String str = paramSpannable.toString();
    int i = 0;
    while (true) {
      try {
        String str1 = WebView.findAddress(str);
        if (str1 != null) {
          int j = str.indexOf(str1);
          if (j < 0)
            return; 
          LinkSpec linkSpec = new LinkSpec();
          int k = j + str1.length();
          linkSpec.start = i + j;
          linkSpec.end = i + k;
          str = str.substring(k);
          i += k;
          try {
            str1 = URLEncoder.encode(str1, "UTF-8");
            linkSpec.url = "geo:0,0?q=" + str1;
            paramArrayList.add(linkSpec);
          } catch (UnsupportedEncodingException unsupportedEncodingException) {}
          continue;
        } 
      } catch (UnsupportedOperationException unsupportedOperationException) {
        return;
      } 
      break;
    } 
  }
  
  private static String makeUrl(@NonNull String paramString, @NonNull String[] paramArrayOfString, Matcher paramMatcher, @Nullable Linkify.TransformFilter paramTransformFilter) {
    String str = paramString;
    if (paramTransformFilter != null)
      str = paramTransformFilter.transformUrl(paramMatcher, paramString); 
    boolean bool = false;
    int i = 0;
    while (true) {
      boolean bool1 = bool;
      paramString = str;
      if (i < paramArrayOfString.length)
        if (str.regionMatches(true, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length())) {
          bool = true;
          bool1 = bool;
          paramString = str;
          if (!str.regionMatches(false, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length())) {
            paramString = paramArrayOfString[i] + str.substring(paramArrayOfString[i].length());
            bool1 = bool;
          } 
        } else {
          i++;
          continue;
        }  
      String str1 = paramString;
      if (!bool1) {
        str1 = paramString;
        if (paramArrayOfString.length > 0)
          str1 = paramArrayOfString[0] + paramString; 
      } 
      return str1;
    } 
  }
  
  private static final void pruneOverlaps(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable) {
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    int i;
    for (i = 0; i < arrayOfURLSpan.length; i++) {
      LinkSpec linkSpec = new LinkSpec();
      linkSpec.frameworkAddedSpan = arrayOfURLSpan[i];
      linkSpec.start = paramSpannable.getSpanStart(arrayOfURLSpan[i]);
      linkSpec.end = paramSpannable.getSpanEnd(arrayOfURLSpan[i]);
      paramArrayList.add(linkSpec);
    } 
    Collections.sort(paramArrayList, COMPARATOR);
    int k = paramArrayList.size();
    for (int j = 0; j < k - 1; j++) {
      LinkSpec linkSpec1 = paramArrayList.get(j);
      LinkSpec linkSpec2 = paramArrayList.get(j + 1);
      i = -1;
      if (linkSpec1.start <= linkSpec2.start && linkSpec1.end > linkSpec2.start) {
        if (linkSpec2.end <= linkSpec1.end) {
          i = j + 1;
        } else if (linkSpec1.end - linkSpec1.start > linkSpec2.end - linkSpec2.start) {
          i = j + 1;
        } else if (linkSpec1.end - linkSpec1.start < linkSpec2.end - linkSpec2.start) {
          i = j;
        } 
        if (i != -1) {
          URLSpan uRLSpan = ((LinkSpec)paramArrayList.get(i)).frameworkAddedSpan;
          if (uRLSpan != null)
            paramSpannable.removeSpan(uRLSpan); 
          paramArrayList.remove(i);
          k--;
          continue;
        } 
      } 
    } 
  }
  
  private static class LinkSpec {
    int end;
    
    URLSpan frameworkAddedSpan;
    
    int start;
    
    String url;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LinkifyMask {}
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\tex\\util\LinkifyCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */