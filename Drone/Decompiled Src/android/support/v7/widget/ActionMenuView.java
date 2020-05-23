package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
  static final int GENERATED_ITEM_PADDING = 4;
  
  static final int MIN_CELL_SIZE = 56;
  
  private static final String TAG = "ActionMenuView";
  
  private MenuPresenter.Callback mActionMenuPresenterCallback;
  
  private boolean mFormatItems;
  
  private int mFormatItemsWidth;
  
  private int mGeneratedItemPadding;
  
  private MenuBuilder mMenu;
  
  MenuBuilder.Callback mMenuBuilderCallback;
  
  private int mMinCellSize;
  
  OnMenuItemClickListener mOnMenuItemClickListener;
  
  private Context mPopupContext;
  
  private int mPopupTheme;
  
  private ActionMenuPresenter mPresenter;
  
  private boolean mReserveOverflow;
  
  public ActionMenuView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = (paramContext.getResources().getDisplayMetrics()).density;
    this.mMinCellSize = (int)(56.0F * f);
    this.mGeneratedItemPadding = (int)(4.0F * f);
    this.mPopupContext = paramContext;
    this.mPopupTheme = 0;
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   4: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   7: astore #9
    //   9: iload_3
    //   10: invokestatic getSize : (I)I
    //   13: iload #4
    //   15: isub
    //   16: iload_3
    //   17: invokestatic getMode : (I)I
    //   20: invokestatic makeMeasureSpec : (II)I
    //   23: istore #6
    //   25: aload_0
    //   26: instanceof android/support/v7/view/menu/ActionMenuItemView
    //   29: ifeq -> 176
    //   32: aload_0
    //   33: checkcast android/support/v7/view/menu/ActionMenuItemView
    //   36: astore #8
    //   38: aload #8
    //   40: ifnull -> 182
    //   43: aload #8
    //   45: invokevirtual hasText : ()Z
    //   48: ifeq -> 182
    //   51: iconst_1
    //   52: istore #4
    //   54: iconst_0
    //   55: istore #5
    //   57: iload #5
    //   59: istore_3
    //   60: iload_2
    //   61: ifle -> 131
    //   64: iload #4
    //   66: ifeq -> 77
    //   69: iload #5
    //   71: istore_3
    //   72: iload_2
    //   73: iconst_2
    //   74: if_icmplt -> 131
    //   77: aload_0
    //   78: iload_1
    //   79: iload_2
    //   80: imul
    //   81: ldc -2147483648
    //   83: invokestatic makeMeasureSpec : (II)I
    //   86: iload #6
    //   88: invokevirtual measure : (II)V
    //   91: aload_0
    //   92: invokevirtual getMeasuredWidth : ()I
    //   95: istore #5
    //   97: iload #5
    //   99: iload_1
    //   100: idiv
    //   101: istore_3
    //   102: iload_3
    //   103: istore_2
    //   104: iload #5
    //   106: iload_1
    //   107: irem
    //   108: ifeq -> 115
    //   111: iload_3
    //   112: iconst_1
    //   113: iadd
    //   114: istore_2
    //   115: iload_2
    //   116: istore_3
    //   117: iload #4
    //   119: ifeq -> 131
    //   122: iload_2
    //   123: istore_3
    //   124: iload_2
    //   125: iconst_2
    //   126: if_icmpge -> 131
    //   129: iconst_2
    //   130: istore_3
    //   131: aload #9
    //   133: getfield isOverflowButton : Z
    //   136: ifne -> 188
    //   139: iload #4
    //   141: ifeq -> 188
    //   144: iconst_1
    //   145: istore #7
    //   147: aload #9
    //   149: iload #7
    //   151: putfield expandable : Z
    //   154: aload #9
    //   156: iload_3
    //   157: putfield cellsUsed : I
    //   160: aload_0
    //   161: iload_3
    //   162: iload_1
    //   163: imul
    //   164: ldc 1073741824
    //   166: invokestatic makeMeasureSpec : (II)I
    //   169: iload #6
    //   171: invokevirtual measure : (II)V
    //   174: iload_3
    //   175: ireturn
    //   176: aconst_null
    //   177: astore #8
    //   179: goto -> 38
    //   182: iconst_0
    //   183: istore #4
    //   185: goto -> 54
    //   188: iconst_0
    //   189: istore #7
    //   191: goto -> 147
  }
  
  private void onMeasureExactFormat(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_2
    //   1: invokestatic getMode : (I)I
    //   4: istore #18
    //   6: iload_1
    //   7: invokestatic getSize : (I)I
    //   10: istore_1
    //   11: iload_2
    //   12: invokestatic getSize : (I)I
    //   15: istore #17
    //   17: aload_0
    //   18: invokevirtual getPaddingLeft : ()I
    //   21: istore #6
    //   23: aload_0
    //   24: invokevirtual getPaddingRight : ()I
    //   27: istore #7
    //   29: aload_0
    //   30: invokevirtual getPaddingTop : ()I
    //   33: aload_0
    //   34: invokevirtual getPaddingBottom : ()I
    //   37: iadd
    //   38: istore #23
    //   40: iload_2
    //   41: iload #23
    //   43: bipush #-2
    //   45: invokestatic getChildMeasureSpec : (III)I
    //   48: istore #19
    //   50: iload_1
    //   51: iload #6
    //   53: iload #7
    //   55: iadd
    //   56: isub
    //   57: istore #20
    //   59: iload #20
    //   61: aload_0
    //   62: getfield mMinCellSize : I
    //   65: idiv
    //   66: istore_1
    //   67: aload_0
    //   68: getfield mMinCellSize : I
    //   71: istore_2
    //   72: iload_1
    //   73: ifne -> 84
    //   76: aload_0
    //   77: iload #20
    //   79: iconst_0
    //   80: invokevirtual setMeasuredDimension : (II)V
    //   83: return
    //   84: aload_0
    //   85: getfield mMinCellSize : I
    //   88: iload #20
    //   90: iload_2
    //   91: irem
    //   92: iload_1
    //   93: idiv
    //   94: iadd
    //   95: istore #21
    //   97: iconst_0
    //   98: istore #6
    //   100: iconst_0
    //   101: istore #9
    //   103: iconst_0
    //   104: istore #8
    //   106: iconst_0
    //   107: istore #10
    //   109: iconst_0
    //   110: istore #7
    //   112: lconst_0
    //   113: lstore #25
    //   115: aload_0
    //   116: invokevirtual getChildCount : ()I
    //   119: istore #22
    //   121: iconst_0
    //   122: istore #11
    //   124: iload #11
    //   126: iload #22
    //   128: if_icmpge -> 435
    //   131: aload_0
    //   132: iload #11
    //   134: invokevirtual getChildAt : (I)Landroid/view/View;
    //   137: astore #32
    //   139: aload #32
    //   141: invokevirtual getVisibility : ()I
    //   144: bipush #8
    //   146: if_icmpne -> 174
    //   149: lload #25
    //   151: lstore #27
    //   153: iload #7
    //   155: istore #12
    //   157: iload #11
    //   159: iconst_1
    //   160: iadd
    //   161: istore #11
    //   163: iload #12
    //   165: istore #7
    //   167: lload #27
    //   169: lstore #25
    //   171: goto -> 124
    //   174: aload #32
    //   176: instanceof android/support/v7/view/menu/ActionMenuItemView
    //   179: istore #31
    //   181: iload #10
    //   183: iconst_1
    //   184: iadd
    //   185: istore #13
    //   187: iload #31
    //   189: ifeq -> 207
    //   192: aload #32
    //   194: aload_0
    //   195: getfield mGeneratedItemPadding : I
    //   198: iconst_0
    //   199: aload_0
    //   200: getfield mGeneratedItemPadding : I
    //   203: iconst_0
    //   204: invokevirtual setPadding : (IIII)V
    //   207: aload #32
    //   209: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   212: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   215: astore #33
    //   217: aload #33
    //   219: iconst_0
    //   220: putfield expanded : Z
    //   223: aload #33
    //   225: iconst_0
    //   226: putfield extraPixels : I
    //   229: aload #33
    //   231: iconst_0
    //   232: putfield cellsUsed : I
    //   235: aload #33
    //   237: iconst_0
    //   238: putfield expandable : Z
    //   241: aload #33
    //   243: iconst_0
    //   244: putfield leftMargin : I
    //   247: aload #33
    //   249: iconst_0
    //   250: putfield rightMargin : I
    //   253: iload #31
    //   255: ifeq -> 424
    //   258: aload #32
    //   260: checkcast android/support/v7/view/menu/ActionMenuItemView
    //   263: invokevirtual hasText : ()Z
    //   266: ifeq -> 424
    //   269: iconst_1
    //   270: istore #31
    //   272: aload #33
    //   274: iload #31
    //   276: putfield preventEdgeOffset : Z
    //   279: aload #33
    //   281: getfield isOverflowButton : Z
    //   284: ifeq -> 430
    //   287: iconst_1
    //   288: istore_2
    //   289: aload #32
    //   291: iload #21
    //   293: iload_2
    //   294: iload #19
    //   296: iload #23
    //   298: invokestatic measureChildForCells : (Landroid/view/View;IIII)I
    //   301: istore #24
    //   303: iload #9
    //   305: iload #24
    //   307: invokestatic max : (II)I
    //   310: istore #14
    //   312: iload #8
    //   314: istore_2
    //   315: aload #33
    //   317: getfield expandable : Z
    //   320: ifeq -> 328
    //   323: iload #8
    //   325: iconst_1
    //   326: iadd
    //   327: istore_2
    //   328: aload #33
    //   330: getfield isOverflowButton : Z
    //   333: ifeq -> 339
    //   336: iconst_1
    //   337: istore #7
    //   339: iload_1
    //   340: iload #24
    //   342: isub
    //   343: istore #15
    //   345: iload #6
    //   347: aload #32
    //   349: invokevirtual getMeasuredHeight : ()I
    //   352: invokestatic max : (II)I
    //   355: istore #16
    //   357: iload #15
    //   359: istore_1
    //   360: iload_2
    //   361: istore #8
    //   363: iload #7
    //   365: istore #12
    //   367: iload #14
    //   369: istore #9
    //   371: iload #16
    //   373: istore #6
    //   375: lload #25
    //   377: lstore #27
    //   379: iload #13
    //   381: istore #10
    //   383: iload #24
    //   385: iconst_1
    //   386: if_icmpne -> 157
    //   389: lload #25
    //   391: iconst_1
    //   392: iload #11
    //   394: ishl
    //   395: i2l
    //   396: lor
    //   397: lstore #27
    //   399: iload #15
    //   401: istore_1
    //   402: iload_2
    //   403: istore #8
    //   405: iload #7
    //   407: istore #12
    //   409: iload #14
    //   411: istore #9
    //   413: iload #16
    //   415: istore #6
    //   417: iload #13
    //   419: istore #10
    //   421: goto -> 157
    //   424: iconst_0
    //   425: istore #31
    //   427: goto -> 272
    //   430: iload_1
    //   431: istore_2
    //   432: goto -> 289
    //   435: iload #7
    //   437: ifeq -> 545
    //   440: iload #10
    //   442: iconst_2
    //   443: if_icmpne -> 545
    //   446: iconst_1
    //   447: istore #11
    //   449: iconst_0
    //   450: istore_2
    //   451: iload_1
    //   452: istore #12
    //   454: lload #25
    //   456: lstore #27
    //   458: iload #8
    //   460: ifle -> 641
    //   463: lload #25
    //   465: lstore #27
    //   467: iload #12
    //   469: ifle -> 641
    //   472: ldc 2147483647
    //   474: istore #13
    //   476: lconst_0
    //   477: lstore #29
    //   479: iconst_0
    //   480: istore #16
    //   482: iconst_0
    //   483: istore #14
    //   485: iload #14
    //   487: iload #22
    //   489: if_icmpge -> 623
    //   492: aload_0
    //   493: iload #14
    //   495: invokevirtual getChildAt : (I)Landroid/view/View;
    //   498: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   501: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   504: astore #32
    //   506: aload #32
    //   508: getfield expandable : Z
    //   511: ifne -> 551
    //   514: lload #29
    //   516: lstore #27
    //   518: iload #16
    //   520: istore_1
    //   521: iload #13
    //   523: istore #15
    //   525: iload #14
    //   527: iconst_1
    //   528: iadd
    //   529: istore #14
    //   531: iload #15
    //   533: istore #13
    //   535: iload_1
    //   536: istore #16
    //   538: lload #27
    //   540: lstore #29
    //   542: goto -> 485
    //   545: iconst_0
    //   546: istore #11
    //   548: goto -> 449
    //   551: aload #32
    //   553: getfield cellsUsed : I
    //   556: iload #13
    //   558: if_icmpge -> 580
    //   561: aload #32
    //   563: getfield cellsUsed : I
    //   566: istore #15
    //   568: iconst_1
    //   569: iload #14
    //   571: ishl
    //   572: i2l
    //   573: lstore #27
    //   575: iconst_1
    //   576: istore_1
    //   577: goto -> 525
    //   580: iload #13
    //   582: istore #15
    //   584: iload #16
    //   586: istore_1
    //   587: lload #29
    //   589: lstore #27
    //   591: aload #32
    //   593: getfield cellsUsed : I
    //   596: iload #13
    //   598: if_icmpne -> 525
    //   601: lload #29
    //   603: iconst_1
    //   604: iload #14
    //   606: ishl
    //   607: i2l
    //   608: lor
    //   609: lstore #27
    //   611: iload #16
    //   613: iconst_1
    //   614: iadd
    //   615: istore_1
    //   616: iload #13
    //   618: istore #15
    //   620: goto -> 525
    //   623: lload #25
    //   625: lload #29
    //   627: lor
    //   628: lstore #25
    //   630: iload #16
    //   632: iload #12
    //   634: if_icmple -> 850
    //   637: lload #25
    //   639: lstore #27
    //   641: iload #7
    //   643: ifne -> 1004
    //   646: iload #10
    //   648: iconst_1
    //   649: if_icmpne -> 1004
    //   652: iconst_1
    //   653: istore_1
    //   654: iload_2
    //   655: istore #7
    //   657: iload #12
    //   659: ifle -> 1160
    //   662: iload_2
    //   663: istore #7
    //   665: lload #27
    //   667: lconst_0
    //   668: lcmp
    //   669: ifeq -> 1160
    //   672: iload #12
    //   674: iload #10
    //   676: iconst_1
    //   677: isub
    //   678: if_icmplt -> 694
    //   681: iload_1
    //   682: ifne -> 694
    //   685: iload_2
    //   686: istore #7
    //   688: iload #9
    //   690: iconst_1
    //   691: if_icmple -> 1160
    //   694: lload #27
    //   696: invokestatic bitCount : (J)I
    //   699: i2f
    //   700: fstore #5
    //   702: fload #5
    //   704: fstore #4
    //   706: iload_1
    //   707: ifne -> 795
    //   710: fload #5
    //   712: fstore_3
    //   713: lconst_1
    //   714: lload #27
    //   716: land
    //   717: lconst_0
    //   718: lcmp
    //   719: ifeq -> 748
    //   722: fload #5
    //   724: fstore_3
    //   725: aload_0
    //   726: iconst_0
    //   727: invokevirtual getChildAt : (I)Landroid/view/View;
    //   730: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   733: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   736: getfield preventEdgeOffset : Z
    //   739: ifne -> 748
    //   742: fload #5
    //   744: ldc 0.5
    //   746: fsub
    //   747: fstore_3
    //   748: fload_3
    //   749: fstore #4
    //   751: iconst_1
    //   752: iload #22
    //   754: iconst_1
    //   755: isub
    //   756: ishl
    //   757: i2l
    //   758: lload #27
    //   760: land
    //   761: lconst_0
    //   762: lcmp
    //   763: ifeq -> 795
    //   766: fload_3
    //   767: fstore #4
    //   769: aload_0
    //   770: iload #22
    //   772: iconst_1
    //   773: isub
    //   774: invokevirtual getChildAt : (I)Landroid/view/View;
    //   777: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   780: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   783: getfield preventEdgeOffset : Z
    //   786: ifne -> 795
    //   789: fload_3
    //   790: ldc 0.5
    //   792: fsub
    //   793: fstore #4
    //   795: fload #4
    //   797: fconst_0
    //   798: fcmpl
    //   799: ifle -> 1009
    //   802: iload #12
    //   804: iload #21
    //   806: imul
    //   807: i2f
    //   808: fload #4
    //   810: fdiv
    //   811: f2i
    //   812: istore #7
    //   814: iconst_0
    //   815: istore #8
    //   817: iload #8
    //   819: iload #22
    //   821: if_icmpge -> 1157
    //   824: iconst_1
    //   825: iload #8
    //   827: ishl
    //   828: i2l
    //   829: lload #27
    //   831: land
    //   832: lconst_0
    //   833: lcmp
    //   834: ifne -> 1015
    //   837: iload_2
    //   838: istore_1
    //   839: iload #8
    //   841: iconst_1
    //   842: iadd
    //   843: istore #8
    //   845: iload_1
    //   846: istore_2
    //   847: goto -> 817
    //   850: iconst_0
    //   851: istore_1
    //   852: iload_1
    //   853: iload #22
    //   855: if_icmpge -> 999
    //   858: aload_0
    //   859: iload_1
    //   860: invokevirtual getChildAt : (I)Landroid/view/View;
    //   863: astore #32
    //   865: aload #32
    //   867: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   870: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   873: astore #33
    //   875: iconst_1
    //   876: iload_1
    //   877: ishl
    //   878: i2l
    //   879: lload #29
    //   881: land
    //   882: lconst_0
    //   883: lcmp
    //   884: ifne -> 932
    //   887: iload #12
    //   889: istore_2
    //   890: lload #25
    //   892: lstore #27
    //   894: aload #33
    //   896: getfield cellsUsed : I
    //   899: iload #13
    //   901: iconst_1
    //   902: iadd
    //   903: if_icmpne -> 918
    //   906: lload #25
    //   908: iconst_1
    //   909: iload_1
    //   910: ishl
    //   911: i2l
    //   912: lor
    //   913: lstore #27
    //   915: iload #12
    //   917: istore_2
    //   918: iload_1
    //   919: iconst_1
    //   920: iadd
    //   921: istore_1
    //   922: iload_2
    //   923: istore #12
    //   925: lload #27
    //   927: lstore #25
    //   929: goto -> 852
    //   932: iload #11
    //   934: ifeq -> 969
    //   937: aload #33
    //   939: getfield preventEdgeOffset : Z
    //   942: ifeq -> 969
    //   945: iload #12
    //   947: iconst_1
    //   948: if_icmpne -> 969
    //   951: aload #32
    //   953: aload_0
    //   954: getfield mGeneratedItemPadding : I
    //   957: iload #21
    //   959: iadd
    //   960: iconst_0
    //   961: aload_0
    //   962: getfield mGeneratedItemPadding : I
    //   965: iconst_0
    //   966: invokevirtual setPadding : (IIII)V
    //   969: aload #33
    //   971: aload #33
    //   973: getfield cellsUsed : I
    //   976: iconst_1
    //   977: iadd
    //   978: putfield cellsUsed : I
    //   981: aload #33
    //   983: iconst_1
    //   984: putfield expanded : Z
    //   987: iload #12
    //   989: iconst_1
    //   990: isub
    //   991: istore_2
    //   992: lload #25
    //   994: lstore #27
    //   996: goto -> 918
    //   999: iconst_1
    //   1000: istore_2
    //   1001: goto -> 454
    //   1004: iconst_0
    //   1005: istore_1
    //   1006: goto -> 654
    //   1009: iconst_0
    //   1010: istore #7
    //   1012: goto -> 814
    //   1015: aload_0
    //   1016: iload #8
    //   1018: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1021: astore #32
    //   1023: aload #32
    //   1025: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1028: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   1031: astore #33
    //   1033: aload #32
    //   1035: instanceof android/support/v7/view/menu/ActionMenuItemView
    //   1038: ifeq -> 1082
    //   1041: aload #33
    //   1043: iload #7
    //   1045: putfield extraPixels : I
    //   1048: aload #33
    //   1050: iconst_1
    //   1051: putfield expanded : Z
    //   1054: iload #8
    //   1056: ifne -> 1077
    //   1059: aload #33
    //   1061: getfield preventEdgeOffset : Z
    //   1064: ifne -> 1077
    //   1067: aload #33
    //   1069: iload #7
    //   1071: ineg
    //   1072: iconst_2
    //   1073: idiv
    //   1074: putfield leftMargin : I
    //   1077: iconst_1
    //   1078: istore_1
    //   1079: goto -> 839
    //   1082: aload #33
    //   1084: getfield isOverflowButton : Z
    //   1087: ifeq -> 1118
    //   1090: aload #33
    //   1092: iload #7
    //   1094: putfield extraPixels : I
    //   1097: aload #33
    //   1099: iconst_1
    //   1100: putfield expanded : Z
    //   1103: aload #33
    //   1105: iload #7
    //   1107: ineg
    //   1108: iconst_2
    //   1109: idiv
    //   1110: putfield rightMargin : I
    //   1113: iconst_1
    //   1114: istore_1
    //   1115: goto -> 839
    //   1118: iload #8
    //   1120: ifeq -> 1132
    //   1123: aload #33
    //   1125: iload #7
    //   1127: iconst_2
    //   1128: idiv
    //   1129: putfield leftMargin : I
    //   1132: iload_2
    //   1133: istore_1
    //   1134: iload #8
    //   1136: iload #22
    //   1138: iconst_1
    //   1139: isub
    //   1140: if_icmpeq -> 839
    //   1143: aload #33
    //   1145: iload #7
    //   1147: iconst_2
    //   1148: idiv
    //   1149: putfield rightMargin : I
    //   1152: iload_2
    //   1153: istore_1
    //   1154: goto -> 839
    //   1157: iload_2
    //   1158: istore #7
    //   1160: iload #7
    //   1162: ifeq -> 1234
    //   1165: iconst_0
    //   1166: istore_1
    //   1167: iload_1
    //   1168: iload #22
    //   1170: if_icmpge -> 1234
    //   1173: aload_0
    //   1174: iload_1
    //   1175: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1178: astore #32
    //   1180: aload #32
    //   1182: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1185: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   1188: astore #33
    //   1190: aload #33
    //   1192: getfield expanded : Z
    //   1195: ifne -> 1205
    //   1198: iload_1
    //   1199: iconst_1
    //   1200: iadd
    //   1201: istore_1
    //   1202: goto -> 1167
    //   1205: aload #32
    //   1207: aload #33
    //   1209: getfield cellsUsed : I
    //   1212: iload #21
    //   1214: imul
    //   1215: aload #33
    //   1217: getfield extraPixels : I
    //   1220: iadd
    //   1221: ldc 1073741824
    //   1223: invokestatic makeMeasureSpec : (II)I
    //   1226: iload #19
    //   1228: invokevirtual measure : (II)V
    //   1231: goto -> 1198
    //   1234: iload #17
    //   1236: istore_1
    //   1237: iload #18
    //   1239: ldc 1073741824
    //   1241: if_icmpeq -> 1247
    //   1244: iload #6
    //   1246: istore_1
    //   1247: aload_0
    //   1248: iload #20
    //   1250: iload_1
    //   1251: invokevirtual setMeasuredDimension : (II)V
    //   1254: return
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams != null && paramLayoutParams instanceof LayoutParams);
  }
  
  public void dismissPopupMenus() {
    if (this.mPresenter != null)
      this.mPresenter.dismissPopupMenus(); 
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    return false;
  }
  
  protected LayoutParams generateDefaultLayoutParams() {
    LayoutParams layoutParams = new LayoutParams(-2, -2);
    layoutParams.gravity = 16;
    return layoutParams;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    if (paramLayoutParams != null) {
      LayoutParams layoutParams;
      if (paramLayoutParams instanceof LayoutParams) {
        layoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      } else {
        layoutParams = new LayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
      if (layoutParams.gravity <= 0)
        layoutParams.gravity = 16; 
      return layoutParams;
    } 
    return generateDefaultLayoutParams();
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public LayoutParams generateOverflowButtonLayoutParams() {
    LayoutParams layoutParams = generateDefaultLayoutParams();
    layoutParams.isOverflowButton = true;
    return layoutParams;
  }
  
  public Menu getMenu() {
    if (this.mMenu == null) {
      MenuPresenter.Callback callback;
      Context context = getContext();
      this.mMenu = new MenuBuilder(context);
      this.mMenu.setCallback(new MenuBuilderCallback());
      this.mPresenter = new ActionMenuPresenter(context);
      this.mPresenter.setReserveOverflow(true);
      ActionMenuPresenter actionMenuPresenter = this.mPresenter;
      if (this.mActionMenuPresenterCallback != null) {
        callback = this.mActionMenuPresenterCallback;
      } else {
        callback = new ActionMenuPresenterCallback();
      } 
      actionMenuPresenter.setCallback(callback);
      this.mMenu.addMenuPresenter((MenuPresenter)this.mPresenter, this.mPopupContext);
      this.mPresenter.setMenuView(this);
    } 
    return (Menu)this.mMenu;
  }
  
  @Nullable
  public Drawable getOverflowIcon() {
    getMenu();
    return this.mPresenter.getOverflowIcon();
  }
  
  public int getPopupTheme() {
    return this.mPopupTheme;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public int getWindowAnimations() {
    return 0;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  protected boolean hasSupportDividerBeforeChildAt(int paramInt) {
    if (paramInt == 0)
      return false; 
    View view1 = getChildAt(paramInt - 1);
    View view2 = getChildAt(paramInt);
    int j = 0;
    int i = j;
    if (paramInt < getChildCount()) {
      i = j;
      if (view1 instanceof ActionMenuChildView)
        i = false | ((ActionMenuChildView)view1).needsDividerAfter(); 
    } 
    j = i;
    if (paramInt > 0) {
      j = i;
      if (view2 instanceof ActionMenuChildView)
        return i | ((ActionMenuChildView)view2).needsDividerBefore(); 
    } 
    return j;
  }
  
  public boolean hideOverflowMenu() {
    return (this.mPresenter != null && this.mPresenter.hideOverflowMenu());
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void initialize(MenuBuilder paramMenuBuilder) {
    this.mMenu = paramMenuBuilder;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl) {
    return this.mMenu.performItemAction((MenuItem)paramMenuItemImpl, 0);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public boolean isOverflowMenuShowPending() {
    return (this.mPresenter != null && this.mPresenter.isOverflowMenuShowPending());
  }
  
  public boolean isOverflowMenuShowing() {
    return (this.mPresenter != null && this.mPresenter.isOverflowMenuShowing());
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public boolean isOverflowReserved() {
    return this.mReserveOverflow;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mPresenter != null) {
      this.mPresenter.updateMenuView(false);
      if (this.mPresenter.isOverflowMenuShowing()) {
        this.mPresenter.hideOverflowMenu();
        this.mPresenter.showOverflowMenu();
      } 
    } 
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    dismissPopupMenus();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!this.mFormatItems) {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    int n = getChildCount();
    int m = (paramInt4 - paramInt2) / 2;
    int i1 = getDividerWidth();
    int j = 0;
    paramInt4 = 0;
    paramInt2 = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    int k = 0;
    paramBoolean = ViewUtils.isLayoutRtl((View)this);
    int i;
    for (i = 0; i < n; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.isOverflowButton) {
          int i3;
          int i2 = view.getMeasuredWidth();
          k = i2;
          if (hasSupportDividerBeforeChildAt(i))
            k = i2 + i1; 
          int i4 = view.getMeasuredHeight();
          if (paramBoolean) {
            i2 = getPaddingLeft() + layoutParams.leftMargin;
            i3 = i2 + k;
          } else {
            i3 = getWidth() - getPaddingRight() - layoutParams.rightMargin;
            i2 = i3 - k;
          } 
          int i5 = m - i4 / 2;
          view.layout(i2, i5, i3, i5 + i4);
          paramInt2 -= k;
          k = 1;
        } else {
          int i2 = view.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
          j += i2;
          i2 = paramInt2 - i2;
          paramInt2 = j;
          if (hasSupportDividerBeforeChildAt(i))
            paramInt2 = j + i1; 
          paramInt4++;
          j = paramInt2;
          paramInt2 = i2;
        } 
      } 
    } 
    if (n == 1 && k == 0) {
      View view = getChildAt(0);
      paramInt2 = view.getMeasuredWidth();
      paramInt4 = view.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1) / 2 - paramInt2 / 2;
      paramInt3 = m - paramInt4 / 2;
      view.layout(paramInt1, paramInt3, paramInt1 + paramInt2, paramInt3 + paramInt4);
      return;
    } 
    if (k != 0) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    } 
    paramInt1 = paramInt4 - paramInt1;
    if (paramInt1 > 0) {
      paramInt1 = paramInt2 / paramInt1;
    } else {
      paramInt1 = 0;
    } 
    paramInt4 = Math.max(0, paramInt1);
    if (paramBoolean) {
      paramInt2 = getWidth() - getPaddingRight();
      paramInt1 = 0;
      while (true) {
        if (paramInt1 < n) {
          View view = getChildAt(paramInt1);
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          paramInt3 = paramInt2;
          if (view.getVisibility() != 8)
            if (layoutParams.isOverflowButton) {
              paramInt3 = paramInt2;
            } else {
              paramInt2 -= layoutParams.rightMargin;
              paramInt3 = view.getMeasuredWidth();
              i = view.getMeasuredHeight();
              j = m - i / 2;
              view.layout(paramInt2 - paramInt3, j, paramInt2, j + i);
              paramInt3 = paramInt2 - layoutParams.leftMargin + paramInt3 + paramInt4;
            }  
          paramInt1++;
          paramInt2 = paramInt3;
          continue;
        } 
        return;
      } 
    } 
    paramInt2 = getPaddingLeft();
    paramInt1 = 0;
    while (true) {
      if (paramInt1 < n) {
        View view = getChildAt(paramInt1);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        paramInt3 = paramInt2;
        if (view.getVisibility() != 8)
          if (layoutParams.isOverflowButton) {
            paramInt3 = paramInt2;
          } else {
            paramInt2 += layoutParams.leftMargin;
            paramInt3 = view.getMeasuredWidth();
            i = view.getMeasuredHeight();
            j = m - i / 2;
            view.layout(paramInt2, j, paramInt2 + paramInt3, j + i);
            paramInt3 = paramInt2 + layoutParams.rightMargin + paramInt3 + paramInt4;
          }  
        paramInt1++;
        paramInt2 = paramInt3;
        continue;
      } 
      return;
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    boolean bool;
    boolean bool1 = this.mFormatItems;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mFormatItems = bool;
    if (bool1 != this.mFormatItems)
      this.mFormatItemsWidth = 0; 
    int i = View.MeasureSpec.getSize(paramInt1);
    if (this.mFormatItems && this.mMenu != null && i != this.mFormatItemsWidth) {
      this.mFormatItemsWidth = i;
      this.mMenu.onItemsChanged(true);
    } 
    int j = getChildCount();
    if (this.mFormatItems && j > 0) {
      onMeasureExactFormat(paramInt1, paramInt2);
      return;
    } 
    for (i = 0; i < j; i++) {
      LayoutParams layoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
      layoutParams.rightMargin = 0;
      layoutParams.leftMargin = 0;
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public MenuBuilder peekMenu() {
    return this.mMenu;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setExpandedActionViewsExclusive(boolean paramBoolean) {
    this.mPresenter.setExpandedActionViewsExclusive(paramBoolean);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1) {
    this.mActionMenuPresenterCallback = paramCallback;
    this.mMenuBuilderCallback = paramCallback1;
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener) {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(@Nullable Drawable paramDrawable) {
    getMenu();
    this.mPresenter.setOverflowIcon(paramDrawable);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setOverflowReserved(boolean paramBoolean) {
    this.mReserveOverflow = paramBoolean;
  }
  
  public void setPopupTheme(@StyleRes int paramInt) {
    if (this.mPopupTheme != paramInt) {
      this.mPopupTheme = paramInt;
      if (paramInt == 0) {
        this.mPopupContext = getContext();
        return;
      } 
    } else {
      return;
    } 
    this.mPopupContext = (Context)new ContextThemeWrapper(getContext(), paramInt);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter) {
    this.mPresenter = paramActionMenuPresenter;
    this.mPresenter.setMenuView(this);
  }
  
  public boolean showOverflowMenu() {
    return (this.mPresenter != null && this.mPresenter.showOverflowMenu());
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static interface ActionMenuChildView {
    boolean needsDividerAfter();
    
    boolean needsDividerBefore();
  }
  
  private class ActionMenuPresenterCallback implements MenuPresenter.Callback {
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {}
    
    public boolean onOpenSubMenu(MenuBuilder param1MenuBuilder) {
      return false;
    }
  }
  
  public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
    @ExportedProperty
    public int cellsUsed;
    
    @ExportedProperty
    public boolean expandable;
    
    boolean expanded;
    
    @ExportedProperty
    public int extraPixels;
    
    @ExportedProperty
    public boolean isOverflowButton;
    
    @ExportedProperty
    public boolean preventEdgeOffset;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.isOverflowButton = false;
    }
    
    LayoutParams(int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1Int1, param1Int2);
      this.isOverflowButton = param1Boolean;
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super((ViewGroup.LayoutParams)param1LayoutParams);
      this.isOverflowButton = param1LayoutParams.isOverflowButton;
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
  }
  
  private class MenuBuilderCallback implements MenuBuilder.Callback {
    public boolean onMenuItemSelected(MenuBuilder param1MenuBuilder, MenuItem param1MenuItem) {
      return (ActionMenuView.this.mOnMenuItemClickListener != null && ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(param1MenuItem));
    }
    
    public void onMenuModeChange(MenuBuilder param1MenuBuilder) {
      if (ActionMenuView.this.mMenuBuilderCallback != null)
        ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(param1MenuBuilder); 
    }
  }
  
  public static interface OnMenuItemClickListener {
    boolean onMenuItemClick(MenuItem param1MenuItem);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\ActionMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */