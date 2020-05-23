package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.ContextThemeWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

class AppCompatViewInflater {
  private static final String LOG_TAG = "AppCompatViewInflater";
  
  private static final String[] sClassPrefixList;
  
  private static final Map<String, Constructor<? extends View>> sConstructorMap;
  
  private static final Class<?>[] sConstructorSignature = new Class[] { Context.class, AttributeSet.class };
  
  private static final int[] sOnClickAttrs = new int[] { 16843375 };
  
  private final Object[] mConstructorArgs = new Object[2];
  
  static {
    sClassPrefixList = new String[] { "android.widget.", "android.view.", "android.webkit." };
    sConstructorMap = (Map<String, Constructor<? extends View>>)new ArrayMap();
  }
  
  private void checkOnClickListener(View paramView, AttributeSet paramAttributeSet) {
    Context context = paramView.getContext();
    if (!(context instanceof ContextWrapper) || (Build.VERSION.SDK_INT >= 15 && !ViewCompat.hasOnClickListeners(paramView)))
      return; 
    TypedArray typedArray = context.obtainStyledAttributes(paramAttributeSet, sOnClickAttrs);
    String str = typedArray.getString(0);
    if (str != null)
      paramView.setOnClickListener(new DeclaredOnClickListener(paramView, str)); 
    typedArray.recycle();
  }
  
  private View createView(Context paramContext, String paramString1, String paramString2) throws ClassNotFoundException, InflateException {
    Constructor constructor1 = sConstructorMap.get(paramString1);
    Constructor<? extends View> constructor = constructor1;
    if (constructor1 == null)
      try {
        String str;
        ClassLoader classLoader = paramContext.getClassLoader();
        if (paramString2 != null) {
          str = paramString2 + paramString1;
        } else {
          str = paramString1;
        } 
        constructor = classLoader.loadClass(str).<View>asSubclass(View.class).getConstructor(sConstructorSignature);
        sConstructorMap.put(paramString1, constructor);
        constructor.setAccessible(true);
        return constructor.newInstance(this.mConstructorArgs);
      } catch (Exception exception) {
        return null;
      }  
    constructor.setAccessible(true);
    return constructor.newInstance(this.mConstructorArgs);
  }
  
  private View createViewFromTag(Context paramContext, String paramString, AttributeSet paramAttributeSet) {
    String str = paramString;
    if (paramString.equals("view"))
      str = paramAttributeSet.getAttributeValue(null, "class"); 
    try {
      this.mConstructorArgs[0] = paramContext;
      this.mConstructorArgs[1] = paramAttributeSet;
      if (-1 == str.indexOf('.')) {
        int i;
        for (i = 0; i < sClassPrefixList.length; i++) {
          View view = createView(paramContext, str, sClassPrefixList[i]);
          if (view != null)
            return view; 
        } 
        return null;
      } 
      return createView(paramContext, str, null);
    } catch (Exception exception) {
      return null;
    } finally {
      this.mConstructorArgs[0] = null;
      this.mConstructorArgs[1] = null;
    } 
  }
  
  private static Context themifyContext(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View, 0, 0);
    int i = 0;
    if (paramBoolean1)
      i = typedArray.getResourceId(R.styleable.View_android_theme, 0); 
    int j = i;
    if (paramBoolean2) {
      j = i;
      if (i == 0) {
        i = typedArray.getResourceId(R.styleable.View_theme, 0);
        j = i;
        if (i != 0) {
          Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
          j = i;
        } 
      } 
    } 
    typedArray.recycle();
    Context context = paramContext;
    if (j != 0) {
      if (paramContext instanceof ContextThemeWrapper) {
        context = paramContext;
        return (Context)((((ContextThemeWrapper)paramContext).getThemeResId() != j) ? new ContextThemeWrapper(paramContext, j) : context);
      } 
    } else {
      return context;
    } 
    return (Context)new ContextThemeWrapper(paramContext, j);
  }
  
  public final View createView(View paramView, String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    // Byte code:
    //   0: aload_3
    //   1: astore #10
    //   3: iload #5
    //   5: ifeq -> 21
    //   8: aload_3
    //   9: astore #10
    //   11: aload_1
    //   12: ifnull -> 21
    //   15: aload_1
    //   16: invokevirtual getContext : ()Landroid/content/Context;
    //   19: astore #10
    //   21: iload #6
    //   23: ifne -> 34
    //   26: aload #10
    //   28: astore_1
    //   29: iload #7
    //   31: ifeq -> 46
    //   34: aload #10
    //   36: aload #4
    //   38: iload #6
    //   40: iload #7
    //   42: invokestatic themifyContext : (Landroid/content/Context;Landroid/util/AttributeSet;ZZ)Landroid/content/Context;
    //   45: astore_1
    //   46: aload_1
    //   47: astore #10
    //   49: iload #8
    //   51: ifeq -> 60
    //   54: aload_1
    //   55: invokestatic wrap : (Landroid/content/Context;)Landroid/content/Context;
    //   58: astore #10
    //   60: aconst_null
    //   61: astore_1
    //   62: iconst_m1
    //   63: istore #9
    //   65: aload_2
    //   66: invokevirtual hashCode : ()I
    //   69: lookupswitch default -> 184, -1946472170 -> 465, -1455429095 -> 417, -1346021293 -> 449, -938935918 -> 295, -937446323 -> 370, -658531749 -> 481, -339785223 -> 355, 776382189 -> 401, 1125864064 -> 310, 1413872058 -> 433, 1601505219 -> 385, 1666676343 -> 340, 2001146706 -> 325
    //   184: iload #9
    //   186: tableswitch default -> 252, 0 -> 498, 1 -> 513, 2 -> 528, 3 -> 543, 4 -> 558, 5 -> 573, 6 -> 588, 7 -> 603, 8 -> 618, 9 -> 633, 10 -> 648, 11 -> 663, 12 -> 678
    //   252: aload_1
    //   253: astore #11
    //   255: aload_1
    //   256: ifnonnull -> 279
    //   259: aload_1
    //   260: astore #11
    //   262: aload_3
    //   263: aload #10
    //   265: if_acmpeq -> 279
    //   268: aload_0
    //   269: aload #10
    //   271: aload_2
    //   272: aload #4
    //   274: invokespecial createViewFromTag : (Landroid/content/Context;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    //   277: astore #11
    //   279: aload #11
    //   281: ifnull -> 292
    //   284: aload_0
    //   285: aload #11
    //   287: aload #4
    //   289: invokespecial checkOnClickListener : (Landroid/view/View;Landroid/util/AttributeSet;)V
    //   292: aload #11
    //   294: areturn
    //   295: aload_2
    //   296: ldc 'TextView'
    //   298: invokevirtual equals : (Ljava/lang/Object;)Z
    //   301: ifeq -> 184
    //   304: iconst_0
    //   305: istore #9
    //   307: goto -> 184
    //   310: aload_2
    //   311: ldc 'ImageView'
    //   313: invokevirtual equals : (Ljava/lang/Object;)Z
    //   316: ifeq -> 184
    //   319: iconst_1
    //   320: istore #9
    //   322: goto -> 184
    //   325: aload_2
    //   326: ldc 'Button'
    //   328: invokevirtual equals : (Ljava/lang/Object;)Z
    //   331: ifeq -> 184
    //   334: iconst_2
    //   335: istore #9
    //   337: goto -> 184
    //   340: aload_2
    //   341: ldc 'EditText'
    //   343: invokevirtual equals : (Ljava/lang/Object;)Z
    //   346: ifeq -> 184
    //   349: iconst_3
    //   350: istore #9
    //   352: goto -> 184
    //   355: aload_2
    //   356: ldc 'Spinner'
    //   358: invokevirtual equals : (Ljava/lang/Object;)Z
    //   361: ifeq -> 184
    //   364: iconst_4
    //   365: istore #9
    //   367: goto -> 184
    //   370: aload_2
    //   371: ldc 'ImageButton'
    //   373: invokevirtual equals : (Ljava/lang/Object;)Z
    //   376: ifeq -> 184
    //   379: iconst_5
    //   380: istore #9
    //   382: goto -> 184
    //   385: aload_2
    //   386: ldc 'CheckBox'
    //   388: invokevirtual equals : (Ljava/lang/Object;)Z
    //   391: ifeq -> 184
    //   394: bipush #6
    //   396: istore #9
    //   398: goto -> 184
    //   401: aload_2
    //   402: ldc 'RadioButton'
    //   404: invokevirtual equals : (Ljava/lang/Object;)Z
    //   407: ifeq -> 184
    //   410: bipush #7
    //   412: istore #9
    //   414: goto -> 184
    //   417: aload_2
    //   418: ldc 'CheckedTextView'
    //   420: invokevirtual equals : (Ljava/lang/Object;)Z
    //   423: ifeq -> 184
    //   426: bipush #8
    //   428: istore #9
    //   430: goto -> 184
    //   433: aload_2
    //   434: ldc 'AutoCompleteTextView'
    //   436: invokevirtual equals : (Ljava/lang/Object;)Z
    //   439: ifeq -> 184
    //   442: bipush #9
    //   444: istore #9
    //   446: goto -> 184
    //   449: aload_2
    //   450: ldc 'MultiAutoCompleteTextView'
    //   452: invokevirtual equals : (Ljava/lang/Object;)Z
    //   455: ifeq -> 184
    //   458: bipush #10
    //   460: istore #9
    //   462: goto -> 184
    //   465: aload_2
    //   466: ldc 'RatingBar'
    //   468: invokevirtual equals : (Ljava/lang/Object;)Z
    //   471: ifeq -> 184
    //   474: bipush #11
    //   476: istore #9
    //   478: goto -> 184
    //   481: aload_2
    //   482: ldc_w 'SeekBar'
    //   485: invokevirtual equals : (Ljava/lang/Object;)Z
    //   488: ifeq -> 184
    //   491: bipush #12
    //   493: istore #9
    //   495: goto -> 184
    //   498: new android/support/v7/widget/AppCompatTextView
    //   501: dup
    //   502: aload #10
    //   504: aload #4
    //   506: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   509: astore_1
    //   510: goto -> 252
    //   513: new android/support/v7/widget/AppCompatImageView
    //   516: dup
    //   517: aload #10
    //   519: aload #4
    //   521: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   524: astore_1
    //   525: goto -> 252
    //   528: new android/support/v7/widget/AppCompatButton
    //   531: dup
    //   532: aload #10
    //   534: aload #4
    //   536: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   539: astore_1
    //   540: goto -> 252
    //   543: new android/support/v7/widget/AppCompatEditText
    //   546: dup
    //   547: aload #10
    //   549: aload #4
    //   551: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   554: astore_1
    //   555: goto -> 252
    //   558: new android/support/v7/widget/AppCompatSpinner
    //   561: dup
    //   562: aload #10
    //   564: aload #4
    //   566: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   569: astore_1
    //   570: goto -> 252
    //   573: new android/support/v7/widget/AppCompatImageButton
    //   576: dup
    //   577: aload #10
    //   579: aload #4
    //   581: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   584: astore_1
    //   585: goto -> 252
    //   588: new android/support/v7/widget/AppCompatCheckBox
    //   591: dup
    //   592: aload #10
    //   594: aload #4
    //   596: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   599: astore_1
    //   600: goto -> 252
    //   603: new android/support/v7/widget/AppCompatRadioButton
    //   606: dup
    //   607: aload #10
    //   609: aload #4
    //   611: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   614: astore_1
    //   615: goto -> 252
    //   618: new android/support/v7/widget/AppCompatCheckedTextView
    //   621: dup
    //   622: aload #10
    //   624: aload #4
    //   626: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   629: astore_1
    //   630: goto -> 252
    //   633: new android/support/v7/widget/AppCompatAutoCompleteTextView
    //   636: dup
    //   637: aload #10
    //   639: aload #4
    //   641: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   644: astore_1
    //   645: goto -> 252
    //   648: new android/support/v7/widget/AppCompatMultiAutoCompleteTextView
    //   651: dup
    //   652: aload #10
    //   654: aload #4
    //   656: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   659: astore_1
    //   660: goto -> 252
    //   663: new android/support/v7/widget/AppCompatRatingBar
    //   666: dup
    //   667: aload #10
    //   669: aload #4
    //   671: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   674: astore_1
    //   675: goto -> 252
    //   678: new android/support/v7/widget/AppCompatSeekBar
    //   681: dup
    //   682: aload #10
    //   684: aload #4
    //   686: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   689: astore_1
    //   690: goto -> 252
  }
  
  private static class DeclaredOnClickListener implements View.OnClickListener {
    private final View mHostView;
    
    private final String mMethodName;
    
    private Context mResolvedContext;
    
    private Method mResolvedMethod;
    
    public DeclaredOnClickListener(@NonNull View param1View, @NonNull String param1String) {
      this.mHostView = param1View;
      this.mMethodName = param1String;
    }
    
    @NonNull
    private void resolveMethod(@Nullable Context param1Context, @NonNull String param1String) {
      while (param1Context != null) {
        try {
          if (!param1Context.isRestricted()) {
            Method method = param1Context.getClass().getMethod(this.mMethodName, new Class[] { View.class });
            if (method != null) {
              this.mResolvedMethod = method;
              this.mResolvedContext = param1Context;
              return;
            } 
          } 
        } catch (NoSuchMethodException noSuchMethodException) {}
        if (param1Context instanceof ContextWrapper) {
          param1Context = ((ContextWrapper)param1Context).getBaseContext();
          continue;
        } 
        param1Context = null;
      } 
      int i = this.mHostView.getId();
      if (i == -1) {
        String str1 = "";
        throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.mHostView.getClass() + str1);
      } 
      String str = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(i) + "'";
      throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.mHostView.getClass() + str);
    }
    
    public void onClick(@NonNull View param1View) {
      if (this.mResolvedMethod == null)
        resolveMethod(this.mHostView.getContext(), this.mMethodName); 
      try {
        this.mResolvedMethod.invoke(this.mResolvedContext, new Object[] { param1View });
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new IllegalStateException("Could not execute non-public method for android:onClick", illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new IllegalStateException("Could not execute method for android:onClick", invocationTargetException);
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\app\AppCompatViewInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */