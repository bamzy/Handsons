package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AlertDialogLayout extends LinearLayoutCompat {
  public AlertDialogLayout(@Nullable Context paramContext) {
    super(paramContext);
  }
  
  public AlertDialogLayout(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void forceUniformWidth(int paramInt1, int paramInt2) {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    for (int i = 0; i < paramInt1; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() != 8) {
        LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams)view.getLayoutParams();
        if (layoutParams.width == -1) {
          int k = layoutParams.height;
          layoutParams.height = view.getMeasuredHeight();
          measureChildWithMargins(view, j, 0, paramInt2, 0);
          layoutParams.height = k;
        } 
      } 
    } 
  }
  
  private static int resolveMinimumHeight(View paramView) {
    int i = ViewCompat.getMinimumHeight(paramView);
    if (i > 0)
      return i; 
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      if (viewGroup.getChildCount() == 1)
        return resolveMinimumHeight(viewGroup.getChildAt(0)); 
    } 
    return 0;
  }
  
  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  private boolean tryOnMeasure(int paramInt1, int paramInt2) {
    View view1 = null;
    View view3 = null;
    View view2 = null;
    int i5 = getChildCount();
    int i;
    for (i = 0; i < i5; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() != 8) {
        int i8 = view.getId();
        if (i8 == R.id.topPanel) {
          view1 = view;
        } else if (i8 == R.id.buttonPanel) {
          view3 = view;
        } else if (i8 == R.id.contentPanel || i8 == R.id.customPanel) {
          if (view2 != null)
            return false; 
          view2 = view;
        } else {
          return false;
        } 
      } 
    } 
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int j = 0;
    i = getPaddingTop() + getPaddingBottom();
    int k = i;
    if (view1 != null) {
      view1.measure(paramInt1, 0);
      k = i + view1.getMeasuredHeight();
      j = ViewCompat.combineMeasuredStates(0, ViewCompat.getMeasuredState(view1));
    } 
    i = 0;
    int i2 = 0;
    int m = j;
    int n = k;
    if (view3 != null) {
      view3.measure(paramInt1, 0);
      i = resolveMinimumHeight(view3);
      i2 = view3.getMeasuredHeight() - i;
      n = k + i;
      m = ViewCompat.combineMeasuredStates(j, ViewCompat.getMeasuredState(view3));
    } 
    int i1 = 0;
    j = m;
    k = n;
    if (view2 != null) {
      if (i7 == 0) {
        j = 0;
      } else {
        j = View.MeasureSpec.makeMeasureSpec(Math.max(0, i3 - n), i7);
      } 
      view2.measure(paramInt1, j);
      i1 = view2.getMeasuredHeight();
      k = n + i1;
      j = ViewCompat.combineMeasuredStates(m, ViewCompat.getMeasuredState(view2));
    } 
    i3 -= k;
    m = j;
    int i4 = i3;
    n = k;
    if (view3 != null) {
      i2 = Math.min(i3, i2);
      n = i;
      m = i3;
      if (i2 > 0) {
        m = i3 - i2;
        n = i + i2;
      } 
      view3.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(n, 1073741824));
      n = k - i + view3.getMeasuredHeight();
      i = ViewCompat.combineMeasuredStates(j, ViewCompat.getMeasuredState(view3));
      i4 = m;
      m = i;
    } 
    j = m;
    i = n;
    if (view2 != null) {
      j = m;
      i = n;
      if (i4 > 0) {
        view2.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i1 + i4, i7));
        i = n - i1 + view2.getMeasuredHeight();
        j = ViewCompat.combineMeasuredStates(m, ViewCompat.getMeasuredState(view2));
      } 
    } 
    m = 0;
    k = 0;
    while (k < i5) {
      View view = getChildAt(k);
      n = m;
      if (view.getVisibility() != 8)
        n = Math.max(m, view.getMeasuredWidth()); 
      k++;
      m = n;
    } 
    setMeasuredDimension(ViewCompat.resolveSizeAndState(m + getPaddingLeft() + getPaddingRight(), paramInt1, j), ViewCompat.resolveSizeAndState(i, paramInt2, 0));
    if (i6 != 1073741824)
      forceUniformWidth(i5, paramInt2); 
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getPaddingLeft : ()I
    //   4: istore #7
    //   6: iload #4
    //   8: iload_2
    //   9: isub
    //   10: istore #8
    //   12: aload_0
    //   13: invokevirtual getPaddingRight : ()I
    //   16: istore #9
    //   18: aload_0
    //   19: invokevirtual getPaddingRight : ()I
    //   22: istore #10
    //   24: aload_0
    //   25: invokevirtual getMeasuredHeight : ()I
    //   28: istore_2
    //   29: aload_0
    //   30: invokevirtual getChildCount : ()I
    //   33: istore #11
    //   35: aload_0
    //   36: invokevirtual getGravity : ()I
    //   39: istore #12
    //   41: iload #12
    //   43: bipush #112
    //   45: iand
    //   46: lookupswitch default -> 72, 16 -> 297, 80 -> 282
    //   72: aload_0
    //   73: invokevirtual getPaddingTop : ()I
    //   76: istore_2
    //   77: aload_0
    //   78: invokevirtual getDividerDrawable : ()Landroid/graphics/drawable/Drawable;
    //   81: astore #15
    //   83: aload #15
    //   85: ifnonnull -> 314
    //   88: iconst_0
    //   89: istore #4
    //   91: iconst_0
    //   92: istore #5
    //   94: iload #5
    //   96: iload #11
    //   98: if_icmpge -> 374
    //   101: aload_0
    //   102: iload #5
    //   104: invokevirtual getChildAt : (I)Landroid/view/View;
    //   107: astore #15
    //   109: iload_2
    //   110: istore_3
    //   111: aload #15
    //   113: ifnull -> 271
    //   116: iload_2
    //   117: istore_3
    //   118: aload #15
    //   120: invokevirtual getVisibility : ()I
    //   123: bipush #8
    //   125: if_icmpeq -> 271
    //   128: aload #15
    //   130: invokevirtual getMeasuredWidth : ()I
    //   133: istore #13
    //   135: aload #15
    //   137: invokevirtual getMeasuredHeight : ()I
    //   140: istore #14
    //   142: aload #15
    //   144: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   147: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   150: astore #16
    //   152: aload #16
    //   154: getfield gravity : I
    //   157: istore #6
    //   159: iload #6
    //   161: istore_3
    //   162: iload #6
    //   164: ifge -> 173
    //   167: iload #12
    //   169: ldc 8388615
    //   171: iand
    //   172: istore_3
    //   173: iload_3
    //   174: aload_0
    //   175: invokestatic getLayoutDirection : (Landroid/view/View;)I
    //   178: invokestatic getAbsoluteGravity : (II)I
    //   181: bipush #7
    //   183: iand
    //   184: lookupswitch default -> 212, 1 -> 324, 5 -> 356
    //   212: iload #7
    //   214: aload #16
    //   216: getfield leftMargin : I
    //   219: iadd
    //   220: istore_3
    //   221: iload_2
    //   222: istore #6
    //   224: aload_0
    //   225: iload #5
    //   227: invokevirtual hasDividerBeforeChildAt : (I)Z
    //   230: ifeq -> 239
    //   233: iload_2
    //   234: iload #4
    //   236: iadd
    //   237: istore #6
    //   239: iload #6
    //   241: aload #16
    //   243: getfield topMargin : I
    //   246: iadd
    //   247: istore_2
    //   248: aload_0
    //   249: aload #15
    //   251: iload_3
    //   252: iload_2
    //   253: iload #13
    //   255: iload #14
    //   257: invokespecial setChildFrame : (Landroid/view/View;IIII)V
    //   260: iload_2
    //   261: aload #16
    //   263: getfield bottomMargin : I
    //   266: iload #14
    //   268: iadd
    //   269: iadd
    //   270: istore_3
    //   271: iload #5
    //   273: iconst_1
    //   274: iadd
    //   275: istore #5
    //   277: iload_3
    //   278: istore_2
    //   279: goto -> 94
    //   282: aload_0
    //   283: invokevirtual getPaddingTop : ()I
    //   286: iload #5
    //   288: iadd
    //   289: iload_3
    //   290: isub
    //   291: iload_2
    //   292: isub
    //   293: istore_2
    //   294: goto -> 77
    //   297: aload_0
    //   298: invokevirtual getPaddingTop : ()I
    //   301: iload #5
    //   303: iload_3
    //   304: isub
    //   305: iload_2
    //   306: isub
    //   307: iconst_2
    //   308: idiv
    //   309: iadd
    //   310: istore_2
    //   311: goto -> 77
    //   314: aload #15
    //   316: invokevirtual getIntrinsicHeight : ()I
    //   319: istore #4
    //   321: goto -> 91
    //   324: iload #8
    //   326: iload #7
    //   328: isub
    //   329: iload #10
    //   331: isub
    //   332: iload #13
    //   334: isub
    //   335: iconst_2
    //   336: idiv
    //   337: iload #7
    //   339: iadd
    //   340: aload #16
    //   342: getfield leftMargin : I
    //   345: iadd
    //   346: aload #16
    //   348: getfield rightMargin : I
    //   351: isub
    //   352: istore_3
    //   353: goto -> 221
    //   356: iload #8
    //   358: iload #9
    //   360: isub
    //   361: iload #13
    //   363: isub
    //   364: aload #16
    //   366: getfield rightMargin : I
    //   369: isub
    //   370: istore_3
    //   371: goto -> 221
    //   374: return
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (!tryOnMeasure(paramInt1, paramInt2))
      super.onMeasure(paramInt1, paramInt2); 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\AlertDialogLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */