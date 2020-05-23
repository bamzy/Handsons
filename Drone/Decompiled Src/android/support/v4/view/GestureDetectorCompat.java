package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat {
  private final GestureDetectorCompatImpl mImpl;
  
  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener) {
    this(paramContext, paramOnGestureListener, null);
  }
  
  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler) {
    if (Build.VERSION.SDK_INT > 17) {
      this.mImpl = new GestureDetectorCompatImplJellybeanMr2(paramContext, paramOnGestureListener, paramHandler);
      return;
    } 
    this.mImpl = new GestureDetectorCompatImplBase(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public boolean isLongpressEnabled() {
    return this.mImpl.isLongpressEnabled();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return this.mImpl.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsLongpressEnabled(boolean paramBoolean) {
    this.mImpl.setIsLongpressEnabled(paramBoolean);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener) {
    this.mImpl.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  static interface GestureDetectorCompatImpl {
    boolean isLongpressEnabled();
    
    boolean onTouchEvent(MotionEvent param1MotionEvent);
    
    void setIsLongpressEnabled(boolean param1Boolean);
    
    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener param1OnDoubleTapListener);
  }
  
  static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
    private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    
    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    
    private static final int LONG_PRESS = 2;
    
    private static final int SHOW_PRESS = 1;
    
    private static final int TAP = 3;
    
    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    
    private boolean mAlwaysInBiggerTapRegion;
    
    private boolean mAlwaysInTapRegion;
    
    MotionEvent mCurrentDownEvent;
    
    boolean mDeferConfirmSingleTap;
    
    GestureDetector.OnDoubleTapListener mDoubleTapListener;
    
    private int mDoubleTapSlopSquare;
    
    private float mDownFocusX;
    
    private float mDownFocusY;
    
    private final Handler mHandler;
    
    private boolean mInLongPress;
    
    private boolean mIsDoubleTapping;
    
    private boolean mIsLongpressEnabled;
    
    private float mLastFocusX;
    
    private float mLastFocusY;
    
    final GestureDetector.OnGestureListener mListener;
    
    private int mMaximumFlingVelocity;
    
    private int mMinimumFlingVelocity;
    
    private MotionEvent mPreviousUpEvent;
    
    boolean mStillDown;
    
    private int mTouchSlopSquare;
    
    private VelocityTracker mVelocityTracker;
    
    static {
    
    }
    
    public GestureDetectorCompatImplBase(Context param1Context, GestureDetector.OnGestureListener param1OnGestureListener, Handler param1Handler) {
      if (param1Handler != null) {
        this.mHandler = new GestureHandler(param1Handler);
      } else {
        this.mHandler = new GestureHandler();
      } 
      this.mListener = param1OnGestureListener;
      if (param1OnGestureListener instanceof GestureDetector.OnDoubleTapListener)
        setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)param1OnGestureListener); 
      init(param1Context);
    }
    
    private void cancel() {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(3);
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      this.mIsDoubleTapping = false;
      this.mStillDown = false;
      this.mAlwaysInTapRegion = false;
      this.mAlwaysInBiggerTapRegion = false;
      this.mDeferConfirmSingleTap = false;
      if (this.mInLongPress)
        this.mInLongPress = false; 
    }
    
    private void cancelTaps() {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(3);
      this.mIsDoubleTapping = false;
      this.mAlwaysInTapRegion = false;
      this.mAlwaysInBiggerTapRegion = false;
      this.mDeferConfirmSingleTap = false;
      if (this.mInLongPress)
        this.mInLongPress = false; 
    }
    
    private void init(Context param1Context) {
      if (param1Context == null)
        throw new IllegalArgumentException("Context must not be null"); 
      if (this.mListener == null)
        throw new IllegalArgumentException("OnGestureListener must not be null"); 
      this.mIsLongpressEnabled = true;
      ViewConfiguration viewConfiguration = ViewConfiguration.get(param1Context);
      int i = viewConfiguration.getScaledTouchSlop();
      int j = viewConfiguration.getScaledDoubleTapSlop();
      this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
      this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
      this.mTouchSlopSquare = i * i;
      this.mDoubleTapSlopSquare = j * j;
    }
    
    private boolean isConsideredDoubleTap(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, MotionEvent param1MotionEvent3) {
      if (this.mAlwaysInBiggerTapRegion && param1MotionEvent3.getEventTime() - param1MotionEvent2.getEventTime() <= DOUBLE_TAP_TIMEOUT) {
        int i = (int)param1MotionEvent1.getX() - (int)param1MotionEvent3.getX();
        int j = (int)param1MotionEvent1.getY() - (int)param1MotionEvent3.getY();
        if (i * i + j * j < this.mDoubleTapSlopSquare)
          return true; 
      } 
      return false;
    }
    
    void dispatchLongPress() {
      this.mHandler.removeMessages(3);
      this.mDeferConfirmSingleTap = false;
      this.mInLongPress = true;
      this.mListener.onLongPress(this.mCurrentDownEvent);
    }
    
    public boolean isLongpressEnabled() {
      return this.mIsLongpressEnabled;
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual getAction : ()I
      //   4: istore #10
      //   6: aload_0
      //   7: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   10: ifnonnull -> 20
      //   13: aload_0
      //   14: invokestatic obtain : ()Landroid/view/VelocityTracker;
      //   17: putfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   20: aload_0
      //   21: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   24: aload_1
      //   25: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
      //   28: iload #10
      //   30: sipush #255
      //   33: iand
      //   34: bipush #6
      //   36: if_icmpne -> 89
      //   39: iconst_1
      //   40: istore #6
      //   42: iload #6
      //   44: ifeq -> 95
      //   47: aload_1
      //   48: invokestatic getActionIndex : (Landroid/view/MotionEvent;)I
      //   51: istore #7
      //   53: fconst_0
      //   54: fstore_3
      //   55: fconst_0
      //   56: fstore_2
      //   57: aload_1
      //   58: invokevirtual getPointerCount : ()I
      //   61: istore #9
      //   63: iconst_0
      //   64: istore #8
      //   66: iload #8
      //   68: iload #9
      //   70: if_icmpge -> 122
      //   73: iload #7
      //   75: iload #8
      //   77: if_icmpne -> 101
      //   80: iload #8
      //   82: iconst_1
      //   83: iadd
      //   84: istore #8
      //   86: goto -> 66
      //   89: iconst_0
      //   90: istore #6
      //   92: goto -> 42
      //   95: iconst_m1
      //   96: istore #7
      //   98: goto -> 53
      //   101: fload_3
      //   102: aload_1
      //   103: iload #8
      //   105: invokevirtual getX : (I)F
      //   108: fadd
      //   109: fstore_3
      //   110: fload_2
      //   111: aload_1
      //   112: iload #8
      //   114: invokevirtual getY : (I)F
      //   117: fadd
      //   118: fstore_2
      //   119: goto -> 80
      //   122: iload #6
      //   124: ifeq -> 215
      //   127: iload #9
      //   129: iconst_1
      //   130: isub
      //   131: istore #6
      //   133: fload_3
      //   134: iload #6
      //   136: i2f
      //   137: fdiv
      //   138: fstore_3
      //   139: fload_2
      //   140: iload #6
      //   142: i2f
      //   143: fdiv
      //   144: fstore_2
      //   145: iconst_0
      //   146: istore #7
      //   148: iconst_0
      //   149: istore #13
      //   151: iconst_0
      //   152: istore #14
      //   154: iconst_0
      //   155: istore #11
      //   157: iload #11
      //   159: istore #12
      //   161: iload #10
      //   163: sipush #255
      //   166: iand
      //   167: tableswitch default -> 208, 0 -> 392, 1 -> 892, 2 -> 657, 3 -> 1171, 4 -> 212, 5 -> 222, 6 -> 248
      //   208: iload #11
      //   210: istore #12
      //   212: iload #12
      //   214: ireturn
      //   215: iload #9
      //   217: istore #6
      //   219: goto -> 133
      //   222: aload_0
      //   223: fload_3
      //   224: putfield mLastFocusX : F
      //   227: aload_0
      //   228: fload_3
      //   229: putfield mDownFocusX : F
      //   232: aload_0
      //   233: fload_2
      //   234: putfield mLastFocusY : F
      //   237: aload_0
      //   238: fload_2
      //   239: putfield mDownFocusY : F
      //   242: aload_0
      //   243: invokespecial cancelTaps : ()V
      //   246: iconst_0
      //   247: ireturn
      //   248: aload_0
      //   249: fload_3
      //   250: putfield mLastFocusX : F
      //   253: aload_0
      //   254: fload_3
      //   255: putfield mDownFocusX : F
      //   258: aload_0
      //   259: fload_2
      //   260: putfield mLastFocusY : F
      //   263: aload_0
      //   264: fload_2
      //   265: putfield mDownFocusY : F
      //   268: aload_0
      //   269: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   272: sipush #1000
      //   275: aload_0
      //   276: getfield mMaximumFlingVelocity : I
      //   279: i2f
      //   280: invokevirtual computeCurrentVelocity : (IF)V
      //   283: aload_1
      //   284: invokestatic getActionIndex : (Landroid/view/MotionEvent;)I
      //   287: istore #7
      //   289: aload_1
      //   290: iload #7
      //   292: invokevirtual getPointerId : (I)I
      //   295: istore #6
      //   297: aload_0
      //   298: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   301: iload #6
      //   303: invokestatic getXVelocity : (Landroid/view/VelocityTracker;I)F
      //   306: fstore_2
      //   307: aload_0
      //   308: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   311: iload #6
      //   313: invokestatic getYVelocity : (Landroid/view/VelocityTracker;I)F
      //   316: fstore_3
      //   317: iconst_0
      //   318: istore #6
      //   320: iload #11
      //   322: istore #12
      //   324: iload #6
      //   326: iload #9
      //   328: if_icmpge -> 212
      //   331: iload #6
      //   333: iload #7
      //   335: if_icmpne -> 347
      //   338: iload #6
      //   340: iconst_1
      //   341: iadd
      //   342: istore #6
      //   344: goto -> 320
      //   347: aload_1
      //   348: iload #6
      //   350: invokevirtual getPointerId : (I)I
      //   353: istore #8
      //   355: fload_2
      //   356: aload_0
      //   357: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   360: iload #8
      //   362: invokestatic getXVelocity : (Landroid/view/VelocityTracker;I)F
      //   365: fmul
      //   366: fload_3
      //   367: aload_0
      //   368: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   371: iload #8
      //   373: invokestatic getYVelocity : (Landroid/view/VelocityTracker;I)F
      //   376: fmul
      //   377: fadd
      //   378: fconst_0
      //   379: fcmpg
      //   380: ifge -> 338
      //   383: aload_0
      //   384: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   387: invokevirtual clear : ()V
      //   390: iconst_0
      //   391: ireturn
      //   392: iload #7
      //   394: istore #6
      //   396: aload_0
      //   397: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   400: ifnull -> 494
      //   403: aload_0
      //   404: getfield mHandler : Landroid/os/Handler;
      //   407: iconst_3
      //   408: invokevirtual hasMessages : (I)Z
      //   411: istore #11
      //   413: iload #11
      //   415: ifeq -> 426
      //   418: aload_0
      //   419: getfield mHandler : Landroid/os/Handler;
      //   422: iconst_3
      //   423: invokevirtual removeMessages : (I)V
      //   426: aload_0
      //   427: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   430: ifnull -> 637
      //   433: aload_0
      //   434: getfield mPreviousUpEvent : Landroid/view/MotionEvent;
      //   437: ifnull -> 637
      //   440: iload #11
      //   442: ifeq -> 637
      //   445: aload_0
      //   446: aload_0
      //   447: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   450: aload_0
      //   451: getfield mPreviousUpEvent : Landroid/view/MotionEvent;
      //   454: aload_1
      //   455: invokespecial isConsideredDoubleTap : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;Landroid/view/MotionEvent;)Z
      //   458: ifeq -> 637
      //   461: aload_0
      //   462: iconst_1
      //   463: putfield mIsDoubleTapping : Z
      //   466: iconst_0
      //   467: aload_0
      //   468: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   471: aload_0
      //   472: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   475: invokeinterface onDoubleTap : (Landroid/view/MotionEvent;)Z
      //   480: ior
      //   481: aload_0
      //   482: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   485: aload_1
      //   486: invokeinterface onDoubleTapEvent : (Landroid/view/MotionEvent;)Z
      //   491: ior
      //   492: istore #6
      //   494: aload_0
      //   495: fload_3
      //   496: putfield mLastFocusX : F
      //   499: aload_0
      //   500: fload_3
      //   501: putfield mDownFocusX : F
      //   504: aload_0
      //   505: fload_2
      //   506: putfield mLastFocusY : F
      //   509: aload_0
      //   510: fload_2
      //   511: putfield mDownFocusY : F
      //   514: aload_0
      //   515: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   518: ifnull -> 528
      //   521: aload_0
      //   522: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   525: invokevirtual recycle : ()V
      //   528: aload_0
      //   529: aload_1
      //   530: invokestatic obtain : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
      //   533: putfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   536: aload_0
      //   537: iconst_1
      //   538: putfield mAlwaysInTapRegion : Z
      //   541: aload_0
      //   542: iconst_1
      //   543: putfield mAlwaysInBiggerTapRegion : Z
      //   546: aload_0
      //   547: iconst_1
      //   548: putfield mStillDown : Z
      //   551: aload_0
      //   552: iconst_0
      //   553: putfield mInLongPress : Z
      //   556: aload_0
      //   557: iconst_0
      //   558: putfield mDeferConfirmSingleTap : Z
      //   561: aload_0
      //   562: getfield mIsLongpressEnabled : Z
      //   565: ifeq -> 602
      //   568: aload_0
      //   569: getfield mHandler : Landroid/os/Handler;
      //   572: iconst_2
      //   573: invokevirtual removeMessages : (I)V
      //   576: aload_0
      //   577: getfield mHandler : Landroid/os/Handler;
      //   580: iconst_2
      //   581: aload_0
      //   582: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   585: invokevirtual getDownTime : ()J
      //   588: getstatic android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplBase.TAP_TIMEOUT : I
      //   591: i2l
      //   592: ladd
      //   593: getstatic android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplBase.LONGPRESS_TIMEOUT : I
      //   596: i2l
      //   597: ladd
      //   598: invokevirtual sendEmptyMessageAtTime : (IJ)Z
      //   601: pop
      //   602: aload_0
      //   603: getfield mHandler : Landroid/os/Handler;
      //   606: iconst_1
      //   607: aload_0
      //   608: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   611: invokevirtual getDownTime : ()J
      //   614: getstatic android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplBase.TAP_TIMEOUT : I
      //   617: i2l
      //   618: ladd
      //   619: invokevirtual sendEmptyMessageAtTime : (IJ)Z
      //   622: pop
      //   623: iload #6
      //   625: aload_0
      //   626: getfield mListener : Landroid/view/GestureDetector$OnGestureListener;
      //   629: aload_1
      //   630: invokeinterface onDown : (Landroid/view/MotionEvent;)Z
      //   635: ior
      //   636: ireturn
      //   637: aload_0
      //   638: getfield mHandler : Landroid/os/Handler;
      //   641: iconst_3
      //   642: getstatic android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT : I
      //   645: i2l
      //   646: invokevirtual sendEmptyMessageDelayed : (IJ)Z
      //   649: pop
      //   650: iload #7
      //   652: istore #6
      //   654: goto -> 494
      //   657: iload #11
      //   659: istore #12
      //   661: aload_0
      //   662: getfield mInLongPress : Z
      //   665: ifne -> 212
      //   668: aload_0
      //   669: getfield mLastFocusX : F
      //   672: fload_3
      //   673: fsub
      //   674: fstore #4
      //   676: aload_0
      //   677: getfield mLastFocusY : F
      //   680: fload_2
      //   681: fsub
      //   682: fstore #5
      //   684: aload_0
      //   685: getfield mIsDoubleTapping : Z
      //   688: ifeq -> 704
      //   691: iconst_0
      //   692: aload_0
      //   693: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   696: aload_1
      //   697: invokeinterface onDoubleTapEvent : (Landroid/view/MotionEvent;)Z
      //   702: ior
      //   703: ireturn
      //   704: aload_0
      //   705: getfield mAlwaysInTapRegion : Z
      //   708: ifeq -> 835
      //   711: fload_3
      //   712: aload_0
      //   713: getfield mDownFocusX : F
      //   716: fsub
      //   717: f2i
      //   718: istore #6
      //   720: fload_2
      //   721: aload_0
      //   722: getfield mDownFocusY : F
      //   725: fsub
      //   726: f2i
      //   727: istore #7
      //   729: iload #6
      //   731: iload #6
      //   733: imul
      //   734: iload #7
      //   736: iload #7
      //   738: imul
      //   739: iadd
      //   740: istore #6
      //   742: iload #13
      //   744: istore #11
      //   746: iload #6
      //   748: aload_0
      //   749: getfield mTouchSlopSquare : I
      //   752: if_icmple -> 814
      //   755: aload_0
      //   756: getfield mListener : Landroid/view/GestureDetector$OnGestureListener;
      //   759: aload_0
      //   760: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   763: aload_1
      //   764: fload #4
      //   766: fload #5
      //   768: invokeinterface onScroll : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
      //   773: istore #11
      //   775: aload_0
      //   776: fload_3
      //   777: putfield mLastFocusX : F
      //   780: aload_0
      //   781: fload_2
      //   782: putfield mLastFocusY : F
      //   785: aload_0
      //   786: iconst_0
      //   787: putfield mAlwaysInTapRegion : Z
      //   790: aload_0
      //   791: getfield mHandler : Landroid/os/Handler;
      //   794: iconst_3
      //   795: invokevirtual removeMessages : (I)V
      //   798: aload_0
      //   799: getfield mHandler : Landroid/os/Handler;
      //   802: iconst_1
      //   803: invokevirtual removeMessages : (I)V
      //   806: aload_0
      //   807: getfield mHandler : Landroid/os/Handler;
      //   810: iconst_2
      //   811: invokevirtual removeMessages : (I)V
      //   814: iload #11
      //   816: istore #12
      //   818: iload #6
      //   820: aload_0
      //   821: getfield mTouchSlopSquare : I
      //   824: if_icmple -> 212
      //   827: aload_0
      //   828: iconst_0
      //   829: putfield mAlwaysInBiggerTapRegion : Z
      //   832: iload #11
      //   834: ireturn
      //   835: fload #4
      //   837: invokestatic abs : (F)F
      //   840: fconst_1
      //   841: fcmpl
      //   842: ifge -> 859
      //   845: iload #11
      //   847: istore #12
      //   849: fload #5
      //   851: invokestatic abs : (F)F
      //   854: fconst_1
      //   855: fcmpl
      //   856: iflt -> 212
      //   859: aload_0
      //   860: getfield mListener : Landroid/view/GestureDetector$OnGestureListener;
      //   863: aload_0
      //   864: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   867: aload_1
      //   868: fload #4
      //   870: fload #5
      //   872: invokeinterface onScroll : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
      //   877: istore #11
      //   879: aload_0
      //   880: fload_3
      //   881: putfield mLastFocusX : F
      //   884: aload_0
      //   885: fload_2
      //   886: putfield mLastFocusY : F
      //   889: iload #11
      //   891: ireturn
      //   892: aload_0
      //   893: iconst_0
      //   894: putfield mStillDown : Z
      //   897: aload_1
      //   898: invokestatic obtain : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
      //   901: astore #15
      //   903: aload_0
      //   904: getfield mIsDoubleTapping : Z
      //   907: ifeq -> 992
      //   910: iconst_0
      //   911: aload_0
      //   912: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   915: aload_1
      //   916: invokeinterface onDoubleTapEvent : (Landroid/view/MotionEvent;)Z
      //   921: ior
      //   922: istore #11
      //   924: aload_0
      //   925: getfield mPreviousUpEvent : Landroid/view/MotionEvent;
      //   928: ifnull -> 938
      //   931: aload_0
      //   932: getfield mPreviousUpEvent : Landroid/view/MotionEvent;
      //   935: invokevirtual recycle : ()V
      //   938: aload_0
      //   939: aload #15
      //   941: putfield mPreviousUpEvent : Landroid/view/MotionEvent;
      //   944: aload_0
      //   945: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   948: ifnull -> 963
      //   951: aload_0
      //   952: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   955: invokevirtual recycle : ()V
      //   958: aload_0
      //   959: aconst_null
      //   960: putfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   963: aload_0
      //   964: iconst_0
      //   965: putfield mIsDoubleTapping : Z
      //   968: aload_0
      //   969: iconst_0
      //   970: putfield mDeferConfirmSingleTap : Z
      //   973: aload_0
      //   974: getfield mHandler : Landroid/os/Handler;
      //   977: iconst_1
      //   978: invokevirtual removeMessages : (I)V
      //   981: aload_0
      //   982: getfield mHandler : Landroid/os/Handler;
      //   985: iconst_2
      //   986: invokevirtual removeMessages : (I)V
      //   989: iload #11
      //   991: ireturn
      //   992: aload_0
      //   993: getfield mInLongPress : Z
      //   996: ifeq -> 1019
      //   999: aload_0
      //   1000: getfield mHandler : Landroid/os/Handler;
      //   1003: iconst_3
      //   1004: invokevirtual removeMessages : (I)V
      //   1007: aload_0
      //   1008: iconst_0
      //   1009: putfield mInLongPress : Z
      //   1012: iload #14
      //   1014: istore #11
      //   1016: goto -> 924
      //   1019: aload_0
      //   1020: getfield mAlwaysInTapRegion : Z
      //   1023: ifeq -> 1078
      //   1026: aload_0
      //   1027: getfield mListener : Landroid/view/GestureDetector$OnGestureListener;
      //   1030: aload_1
      //   1031: invokeinterface onSingleTapUp : (Landroid/view/MotionEvent;)Z
      //   1036: istore #12
      //   1038: iload #12
      //   1040: istore #11
      //   1042: aload_0
      //   1043: getfield mDeferConfirmSingleTap : Z
      //   1046: ifeq -> 924
      //   1049: iload #12
      //   1051: istore #11
      //   1053: aload_0
      //   1054: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   1057: ifnull -> 924
      //   1060: aload_0
      //   1061: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   1064: aload_1
      //   1065: invokeinterface onSingleTapConfirmed : (Landroid/view/MotionEvent;)Z
      //   1070: pop
      //   1071: iload #12
      //   1073: istore #11
      //   1075: goto -> 924
      //   1078: aload_0
      //   1079: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   1082: astore #16
      //   1084: aload_1
      //   1085: iconst_0
      //   1086: invokevirtual getPointerId : (I)I
      //   1089: istore #6
      //   1091: aload #16
      //   1093: sipush #1000
      //   1096: aload_0
      //   1097: getfield mMaximumFlingVelocity : I
      //   1100: i2f
      //   1101: invokevirtual computeCurrentVelocity : (IF)V
      //   1104: aload #16
      //   1106: iload #6
      //   1108: invokestatic getYVelocity : (Landroid/view/VelocityTracker;I)F
      //   1111: fstore_2
      //   1112: aload #16
      //   1114: iload #6
      //   1116: invokestatic getXVelocity : (Landroid/view/VelocityTracker;I)F
      //   1119: fstore_3
      //   1120: fload_2
      //   1121: invokestatic abs : (F)F
      //   1124: aload_0
      //   1125: getfield mMinimumFlingVelocity : I
      //   1128: i2f
      //   1129: fcmpl
      //   1130: ifgt -> 1150
      //   1133: iload #14
      //   1135: istore #11
      //   1137: fload_3
      //   1138: invokestatic abs : (F)F
      //   1141: aload_0
      //   1142: getfield mMinimumFlingVelocity : I
      //   1145: i2f
      //   1146: fcmpl
      //   1147: ifle -> 924
      //   1150: aload_0
      //   1151: getfield mListener : Landroid/view/GestureDetector$OnGestureListener;
      //   1154: aload_0
      //   1155: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   1158: aload_1
      //   1159: fload_3
      //   1160: fload_2
      //   1161: invokeinterface onFling : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
      //   1166: istore #11
      //   1168: goto -> 924
      //   1171: aload_0
      //   1172: invokespecial cancel : ()V
      //   1175: iconst_0
      //   1176: ireturn
    }
    
    public void setIsLongpressEnabled(boolean param1Boolean) {
      this.mIsLongpressEnabled = param1Boolean;
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener param1OnDoubleTapListener) {
      this.mDoubleTapListener = param1OnDoubleTapListener;
    }
    
    private class GestureHandler extends Handler {
      GestureHandler() {}
      
      GestureHandler(Handler param2Handler) {
        super(param2Handler.getLooper());
      }
      
      public void handleMessage(Message param2Message) {
        switch (param2Message.what) {
          default:
            throw new RuntimeException("Unknown message " + param2Message);
          case 1:
            GestureDetectorCompat.GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompat.GestureDetectorCompatImplBase.this.mCurrentDownEvent);
            return;
          case 2:
            GestureDetectorCompat.GestureDetectorCompatImplBase.this.dispatchLongPress();
            return;
          case 3:
            break;
        } 
        if (GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDoubleTapListener != null) {
          if (!GestureDetectorCompat.GestureDetectorCompatImplBase.this.mStillDown) {
            GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompat.GestureDetectorCompatImplBase.this.mCurrentDownEvent);
            return;
          } 
          GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
          return;
        } 
      }
    }
  }
  
  private class GestureHandler extends Handler {
    GestureHandler() {}
    
    GestureHandler(Handler param1Handler) {
      super(param1Handler.getLooper());
    }
    
    public void handleMessage(Message param1Message) {
      switch (param1Message.what) {
        default:
          throw new RuntimeException("Unknown message " + param1Message);
        case 1:
          this.this$0.mListener.onShowPress(this.this$0.mCurrentDownEvent);
          return;
        case 2:
          this.this$0.dispatchLongPress();
          return;
        case 3:
          break;
      } 
      if (this.this$0.mDoubleTapListener != null) {
        if (!this.this$0.mStillDown) {
          this.this$0.mDoubleTapListener.onSingleTapConfirmed(this.this$0.mCurrentDownEvent);
          return;
        } 
        this.this$0.mDeferConfirmSingleTap = true;
        return;
      } 
    }
  }
  
  static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
    private final GestureDetector mDetector;
    
    public GestureDetectorCompatImplJellybeanMr2(Context param1Context, GestureDetector.OnGestureListener param1OnGestureListener, Handler param1Handler) {
      this.mDetector = new GestureDetector(param1Context, param1OnGestureListener, param1Handler);
    }
    
    public boolean isLongpressEnabled() {
      return this.mDetector.isLongpressEnabled();
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      return this.mDetector.onTouchEvent(param1MotionEvent);
    }
    
    public void setIsLongpressEnabled(boolean param1Boolean) {
      this.mDetector.setIsLongpressEnabled(param1Boolean);
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener param1OnDoubleTapListener) {
      this.mDetector.setOnDoubleTapListener(param1OnDoubleTapListener);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\GestureDetectorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */