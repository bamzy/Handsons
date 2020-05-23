package android.support.v4.app;

import android.os.Build;
import android.support.v4.util.LogWriter;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator {
  static final int OP_ADD = 1;
  
  static final int OP_ATTACH = 7;
  
  static final int OP_DETACH = 6;
  
  static final int OP_HIDE = 4;
  
  static final int OP_NULL = 0;
  
  static final int OP_REMOVE = 3;
  
  static final int OP_REPLACE = 2;
  
  static final int OP_SHOW = 5;
  
  static final boolean SUPPORTS_TRANSITIONS;
  
  static final String TAG = "FragmentManager";
  
  boolean mAddToBackStack;
  
  boolean mAllowAddToBackStack = true;
  
  boolean mAllowOptimization = false;
  
  int mBreadCrumbShortTitleRes;
  
  CharSequence mBreadCrumbShortTitleText;
  
  int mBreadCrumbTitleRes;
  
  CharSequence mBreadCrumbTitleText;
  
  boolean mCommitted;
  
  int mEnterAnim;
  
  int mExitAnim;
  
  int mIndex = -1;
  
  final FragmentManagerImpl mManager;
  
  String mName;
  
  ArrayList<Op> mOps = new ArrayList<Op>();
  
  int mPopEnterAnim;
  
  int mPopExitAnim;
  
  ArrayList<String> mSharedElementSourceNames;
  
  ArrayList<String> mSharedElementTargetNames;
  
  int mTransition;
  
  int mTransitionStyle;
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    SUPPORTS_TRANSITIONS = bool;
  }
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl) {
    this.mManager = paramFragmentManagerImpl;
  }
  
  private void doAddOp(int paramInt1, Fragment paramFragment, String paramString, int paramInt2) {
    Class<?> clazz = paramFragment.getClass();
    int i = clazz.getModifiers();
    if (clazz.isAnonymousClass() || !Modifier.isPublic(i) || (clazz.isMemberClass() && !Modifier.isStatic(i)))
      throw new IllegalStateException("Fragment " + clazz.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state."); 
    paramFragment.mFragmentManager = this.mManager;
    if (paramString != null) {
      if (paramFragment.mTag != null && !paramString.equals(paramFragment.mTag))
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString); 
      paramFragment.mTag = paramString;
    } 
    if (paramInt1 != 0) {
      if (paramInt1 == -1)
        throw new IllegalArgumentException("Can't add fragment " + paramFragment + " with tag " + paramString + " to container view with no id"); 
      if (paramFragment.mFragmentId != 0 && paramFragment.mFragmentId != paramInt1)
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.mFragmentId + " now " + paramInt1); 
      paramFragment.mFragmentId = paramInt1;
      paramFragment.mContainerId = paramInt1;
    } 
    Op op = new Op();
    op.cmd = paramInt2;
    op.fragment = paramFragment;
    addOp(op);
  }
  
  private static boolean isFragmentPostponed(Op paramOp) {
    Fragment fragment = paramOp.fragment;
    return (fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed());
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment) {
    doAddOp(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment, String paramString) {
    doAddOp(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public FragmentTransaction add(Fragment paramFragment, String paramString) {
    doAddOp(0, paramFragment, paramString, 1);
    return this;
  }
  
  void addOp(Op paramOp) {
    this.mOps.add(paramOp);
    paramOp.enterAnim = this.mEnterAnim;
    paramOp.exitAnim = this.mExitAnim;
    paramOp.popEnterAnim = this.mPopEnterAnim;
    paramOp.popExitAnim = this.mPopExitAnim;
  }
  
  public FragmentTransaction addSharedElement(View paramView, String paramString) {
    if (SUPPORTS_TRANSITIONS) {
      String str = ViewCompat.getTransitionName(paramView);
      if (str == null)
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements"); 
      if (this.mSharedElementSourceNames == null) {
        this.mSharedElementSourceNames = new ArrayList<String>();
        this.mSharedElementTargetNames = new ArrayList<String>();
      } else {
        if (this.mSharedElementTargetNames.contains(paramString))
          throw new IllegalArgumentException("A shared element with the target name '" + paramString + "' has already been added to the transaction."); 
        if (this.mSharedElementSourceNames.contains(str))
          throw new IllegalArgumentException("A shared element with the source name '" + str + " has already been added to the transaction."); 
      } 
      this.mSharedElementSourceNames.add(str);
      this.mSharedElementTargetNames.add(paramString);
    } 
    return this;
  }
  
  public FragmentTransaction addToBackStack(String paramString) {
    if (!this.mAllowAddToBackStack)
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack."); 
    this.mAddToBackStack = true;
    this.mName = paramString;
    return this;
  }
  
  public FragmentTransaction attach(Fragment paramFragment) {
    Op op = new Op();
    op.cmd = 7;
    op.fragment = paramFragment;
    addOp(op);
    return this;
  }
  
  void bumpBackStackNesting(int paramInt) {
    if (this.mAddToBackStack) {
      if (FragmentManagerImpl.DEBUG)
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt); 
      int j = this.mOps.size();
      int i = 0;
      while (true) {
        if (i < j) {
          Op op = this.mOps.get(i);
          if (op.fragment != null) {
            Fragment fragment = op.fragment;
            fragment.mBackStackNesting += paramInt;
            if (FragmentManagerImpl.DEBUG)
              Log.v("FragmentManager", "Bump nesting of " + op.fragment + " to " + op.fragment.mBackStackNesting); 
          } 
          i++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public int commit() {
    return commitInternal(false);
  }
  
  public int commitAllowingStateLoss() {
    return commitInternal(true);
  }
  
  int commitInternal(boolean paramBoolean) {
    if (this.mCommitted)
      throw new IllegalStateException("commit already called"); 
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", "Commit: " + this);
      PrintWriter printWriter = new PrintWriter((Writer)new LogWriter("FragmentManager"));
      dump("  ", null, printWriter, null);
      printWriter.close();
    } 
    this.mCommitted = true;
    if (this.mAddToBackStack) {
      this.mIndex = this.mManager.allocBackStackIndex(this);
      this.mManager.enqueueAction(this, paramBoolean);
      return this.mIndex;
    } 
    this.mIndex = -1;
    this.mManager.enqueueAction(this, paramBoolean);
    return this.mIndex;
  }
  
  public void commitNow() {
    disallowAddToBackStack();
    this.mManager.execSingleAction(this, false);
  }
  
  public void commitNowAllowingStateLoss() {
    disallowAddToBackStack();
    this.mManager.execSingleAction(this, true);
  }
  
  public FragmentTransaction detach(Fragment paramFragment) {
    Op op = new Op();
    op.cmd = 6;
    op.fragment = paramFragment;
    addOp(op);
    return this;
  }
  
  public FragmentTransaction disallowAddToBackStack() {
    if (this.mAddToBackStack)
      throw new IllegalStateException("This transaction is already being added to the back stack"); 
    this.mAllowAddToBackStack = false;
    return this;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    dump(paramString, paramPrintWriter, true);
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean) {
    // Byte code:
    //   0: iload_3
    //   1: ifeq -> 316
    //   4: aload_2
    //   5: aload_1
    //   6: invokevirtual print : (Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc_w 'mName='
    //   13: invokevirtual print : (Ljava/lang/String;)V
    //   16: aload_2
    //   17: aload_0
    //   18: getfield mName : Ljava/lang/String;
    //   21: invokevirtual print : (Ljava/lang/String;)V
    //   24: aload_2
    //   25: ldc_w ' mIndex='
    //   28: invokevirtual print : (Ljava/lang/String;)V
    //   31: aload_2
    //   32: aload_0
    //   33: getfield mIndex : I
    //   36: invokevirtual print : (I)V
    //   39: aload_2
    //   40: ldc_w ' mCommitted='
    //   43: invokevirtual print : (Ljava/lang/String;)V
    //   46: aload_2
    //   47: aload_0
    //   48: getfield mCommitted : Z
    //   51: invokevirtual println : (Z)V
    //   54: aload_0
    //   55: getfield mTransition : I
    //   58: ifeq -> 102
    //   61: aload_2
    //   62: aload_1
    //   63: invokevirtual print : (Ljava/lang/String;)V
    //   66: aload_2
    //   67: ldc_w 'mTransition=#'
    //   70: invokevirtual print : (Ljava/lang/String;)V
    //   73: aload_2
    //   74: aload_0
    //   75: getfield mTransition : I
    //   78: invokestatic toHexString : (I)Ljava/lang/String;
    //   81: invokevirtual print : (Ljava/lang/String;)V
    //   84: aload_2
    //   85: ldc_w ' mTransitionStyle=#'
    //   88: invokevirtual print : (Ljava/lang/String;)V
    //   91: aload_2
    //   92: aload_0
    //   93: getfield mTransitionStyle : I
    //   96: invokestatic toHexString : (I)Ljava/lang/String;
    //   99: invokevirtual println : (Ljava/lang/String;)V
    //   102: aload_0
    //   103: getfield mEnterAnim : I
    //   106: ifne -> 116
    //   109: aload_0
    //   110: getfield mExitAnim : I
    //   113: ifeq -> 157
    //   116: aload_2
    //   117: aload_1
    //   118: invokevirtual print : (Ljava/lang/String;)V
    //   121: aload_2
    //   122: ldc_w 'mEnterAnim=#'
    //   125: invokevirtual print : (Ljava/lang/String;)V
    //   128: aload_2
    //   129: aload_0
    //   130: getfield mEnterAnim : I
    //   133: invokestatic toHexString : (I)Ljava/lang/String;
    //   136: invokevirtual print : (Ljava/lang/String;)V
    //   139: aload_2
    //   140: ldc_w ' mExitAnim=#'
    //   143: invokevirtual print : (Ljava/lang/String;)V
    //   146: aload_2
    //   147: aload_0
    //   148: getfield mExitAnim : I
    //   151: invokestatic toHexString : (I)Ljava/lang/String;
    //   154: invokevirtual println : (Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield mPopEnterAnim : I
    //   161: ifne -> 171
    //   164: aload_0
    //   165: getfield mPopExitAnim : I
    //   168: ifeq -> 212
    //   171: aload_2
    //   172: aload_1
    //   173: invokevirtual print : (Ljava/lang/String;)V
    //   176: aload_2
    //   177: ldc_w 'mPopEnterAnim=#'
    //   180: invokevirtual print : (Ljava/lang/String;)V
    //   183: aload_2
    //   184: aload_0
    //   185: getfield mPopEnterAnim : I
    //   188: invokestatic toHexString : (I)Ljava/lang/String;
    //   191: invokevirtual print : (Ljava/lang/String;)V
    //   194: aload_2
    //   195: ldc_w ' mPopExitAnim=#'
    //   198: invokevirtual print : (Ljava/lang/String;)V
    //   201: aload_2
    //   202: aload_0
    //   203: getfield mPopExitAnim : I
    //   206: invokestatic toHexString : (I)Ljava/lang/String;
    //   209: invokevirtual println : (Ljava/lang/String;)V
    //   212: aload_0
    //   213: getfield mBreadCrumbTitleRes : I
    //   216: ifne -> 226
    //   219: aload_0
    //   220: getfield mBreadCrumbTitleText : Ljava/lang/CharSequence;
    //   223: ifnull -> 264
    //   226: aload_2
    //   227: aload_1
    //   228: invokevirtual print : (Ljava/lang/String;)V
    //   231: aload_2
    //   232: ldc_w 'mBreadCrumbTitleRes=#'
    //   235: invokevirtual print : (Ljava/lang/String;)V
    //   238: aload_2
    //   239: aload_0
    //   240: getfield mBreadCrumbTitleRes : I
    //   243: invokestatic toHexString : (I)Ljava/lang/String;
    //   246: invokevirtual print : (Ljava/lang/String;)V
    //   249: aload_2
    //   250: ldc_w ' mBreadCrumbTitleText='
    //   253: invokevirtual print : (Ljava/lang/String;)V
    //   256: aload_2
    //   257: aload_0
    //   258: getfield mBreadCrumbTitleText : Ljava/lang/CharSequence;
    //   261: invokevirtual println : (Ljava/lang/Object;)V
    //   264: aload_0
    //   265: getfield mBreadCrumbShortTitleRes : I
    //   268: ifne -> 278
    //   271: aload_0
    //   272: getfield mBreadCrumbShortTitleText : Ljava/lang/CharSequence;
    //   275: ifnull -> 316
    //   278: aload_2
    //   279: aload_1
    //   280: invokevirtual print : (Ljava/lang/String;)V
    //   283: aload_2
    //   284: ldc_w 'mBreadCrumbShortTitleRes=#'
    //   287: invokevirtual print : (Ljava/lang/String;)V
    //   290: aload_2
    //   291: aload_0
    //   292: getfield mBreadCrumbShortTitleRes : I
    //   295: invokestatic toHexString : (I)Ljava/lang/String;
    //   298: invokevirtual print : (Ljava/lang/String;)V
    //   301: aload_2
    //   302: ldc_w ' mBreadCrumbShortTitleText='
    //   305: invokevirtual print : (Ljava/lang/String;)V
    //   308: aload_2
    //   309: aload_0
    //   310: getfield mBreadCrumbShortTitleText : Ljava/lang/CharSequence;
    //   313: invokevirtual println : (Ljava/lang/Object;)V
    //   316: aload_0
    //   317: getfield mOps : Ljava/util/ArrayList;
    //   320: invokevirtual isEmpty : ()Z
    //   323: ifne -> 712
    //   326: aload_2
    //   327: aload_1
    //   328: invokevirtual print : (Ljava/lang/String;)V
    //   331: aload_2
    //   332: ldc_w 'Operations:'
    //   335: invokevirtual println : (Ljava/lang/String;)V
    //   338: new java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial <init> : ()V
    //   345: aload_1
    //   346: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc_w '    '
    //   352: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual toString : ()Ljava/lang/String;
    //   358: pop
    //   359: aload_0
    //   360: getfield mOps : Ljava/util/ArrayList;
    //   363: invokevirtual size : ()I
    //   366: istore #5
    //   368: iconst_0
    //   369: istore #4
    //   371: iload #4
    //   373: iload #5
    //   375: if_icmpge -> 712
    //   378: aload_0
    //   379: getfield mOps : Ljava/util/ArrayList;
    //   382: iload #4
    //   384: invokevirtual get : (I)Ljava/lang/Object;
    //   387: checkcast android/support/v4/app/BackStackRecord$Op
    //   390: astore #7
    //   392: aload #7
    //   394: getfield cmd : I
    //   397: tableswitch default -> 444, 0 -> 648, 1 -> 656, 2 -> 664, 3 -> 672, 4 -> 680, 5 -> 688, 6 -> 696, 7 -> 704
    //   444: new java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial <init> : ()V
    //   451: ldc_w 'cmd='
    //   454: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload #7
    //   459: getfield cmd : I
    //   462: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   465: invokevirtual toString : ()Ljava/lang/String;
    //   468: astore #6
    //   470: aload_2
    //   471: aload_1
    //   472: invokevirtual print : (Ljava/lang/String;)V
    //   475: aload_2
    //   476: ldc_w '  Op #'
    //   479: invokevirtual print : (Ljava/lang/String;)V
    //   482: aload_2
    //   483: iload #4
    //   485: invokevirtual print : (I)V
    //   488: aload_2
    //   489: ldc_w ': '
    //   492: invokevirtual print : (Ljava/lang/String;)V
    //   495: aload_2
    //   496: aload #6
    //   498: invokevirtual print : (Ljava/lang/String;)V
    //   501: aload_2
    //   502: ldc_w ' '
    //   505: invokevirtual print : (Ljava/lang/String;)V
    //   508: aload_2
    //   509: aload #7
    //   511: getfield fragment : Landroid/support/v4/app/Fragment;
    //   514: invokevirtual println : (Ljava/lang/Object;)V
    //   517: iload_3
    //   518: ifeq -> 639
    //   521: aload #7
    //   523: getfield enterAnim : I
    //   526: ifne -> 537
    //   529: aload #7
    //   531: getfield exitAnim : I
    //   534: ifeq -> 580
    //   537: aload_2
    //   538: aload_1
    //   539: invokevirtual print : (Ljava/lang/String;)V
    //   542: aload_2
    //   543: ldc_w 'enterAnim=#'
    //   546: invokevirtual print : (Ljava/lang/String;)V
    //   549: aload_2
    //   550: aload #7
    //   552: getfield enterAnim : I
    //   555: invokestatic toHexString : (I)Ljava/lang/String;
    //   558: invokevirtual print : (Ljava/lang/String;)V
    //   561: aload_2
    //   562: ldc_w ' exitAnim=#'
    //   565: invokevirtual print : (Ljava/lang/String;)V
    //   568: aload_2
    //   569: aload #7
    //   571: getfield exitAnim : I
    //   574: invokestatic toHexString : (I)Ljava/lang/String;
    //   577: invokevirtual println : (Ljava/lang/String;)V
    //   580: aload #7
    //   582: getfield popEnterAnim : I
    //   585: ifne -> 596
    //   588: aload #7
    //   590: getfield popExitAnim : I
    //   593: ifeq -> 639
    //   596: aload_2
    //   597: aload_1
    //   598: invokevirtual print : (Ljava/lang/String;)V
    //   601: aload_2
    //   602: ldc_w 'popEnterAnim=#'
    //   605: invokevirtual print : (Ljava/lang/String;)V
    //   608: aload_2
    //   609: aload #7
    //   611: getfield popEnterAnim : I
    //   614: invokestatic toHexString : (I)Ljava/lang/String;
    //   617: invokevirtual print : (Ljava/lang/String;)V
    //   620: aload_2
    //   621: ldc_w ' popExitAnim=#'
    //   624: invokevirtual print : (Ljava/lang/String;)V
    //   627: aload_2
    //   628: aload #7
    //   630: getfield popExitAnim : I
    //   633: invokestatic toHexString : (I)Ljava/lang/String;
    //   636: invokevirtual println : (Ljava/lang/String;)V
    //   639: iload #4
    //   641: iconst_1
    //   642: iadd
    //   643: istore #4
    //   645: goto -> 371
    //   648: ldc_w 'NULL'
    //   651: astore #6
    //   653: goto -> 470
    //   656: ldc_w 'ADD'
    //   659: astore #6
    //   661: goto -> 470
    //   664: ldc_w 'REPLACE'
    //   667: astore #6
    //   669: goto -> 470
    //   672: ldc_w 'REMOVE'
    //   675: astore #6
    //   677: goto -> 470
    //   680: ldc_w 'HIDE'
    //   683: astore #6
    //   685: goto -> 470
    //   688: ldc_w 'SHOW'
    //   691: astore #6
    //   693: goto -> 470
    //   696: ldc_w 'DETACH'
    //   699: astore #6
    //   701: goto -> 470
    //   704: ldc_w 'ATTACH'
    //   707: astore #6
    //   709: goto -> 470
    //   712: return
  }
  
  void executeOps() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mOps : Ljava/util/ArrayList;
    //   4: invokevirtual size : ()I
    //   7: istore_2
    //   8: iconst_0
    //   9: istore_1
    //   10: iload_1
    //   11: iload_2
    //   12: if_icmpge -> 278
    //   15: aload_0
    //   16: getfield mOps : Ljava/util/ArrayList;
    //   19: iload_1
    //   20: invokevirtual get : (I)Ljava/lang/Object;
    //   23: checkcast android/support/v4/app/BackStackRecord$Op
    //   26: astore_3
    //   27: aload_3
    //   28: getfield fragment : Landroid/support/v4/app/Fragment;
    //   31: astore #4
    //   33: aload #4
    //   35: aload_0
    //   36: getfield mTransition : I
    //   39: aload_0
    //   40: getfield mTransitionStyle : I
    //   43: invokevirtual setNextTransition : (II)V
    //   46: aload_3
    //   47: getfield cmd : I
    //   50: tableswitch default -> 92, 1 -> 123, 2 -> 92, 3 -> 173, 4 -> 194, 5 -> 215, 6 -> 236, 7 -> 257
    //   92: new java/lang/IllegalArgumentException
    //   95: dup
    //   96: new java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: ldc_w 'Unknown cmd: '
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: getfield cmd : I
    //   113: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   116: invokevirtual toString : ()Ljava/lang/String;
    //   119: invokespecial <init> : (Ljava/lang/String;)V
    //   122: athrow
    //   123: aload #4
    //   125: aload_3
    //   126: getfield enterAnim : I
    //   129: invokevirtual setNextAnim : (I)V
    //   132: aload_0
    //   133: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   136: aload #4
    //   138: iconst_0
    //   139: invokevirtual addFragment : (Landroid/support/v4/app/Fragment;Z)V
    //   142: aload_0
    //   143: getfield mAllowOptimization : Z
    //   146: ifne -> 166
    //   149: aload_3
    //   150: getfield cmd : I
    //   153: iconst_1
    //   154: if_icmpeq -> 166
    //   157: aload_0
    //   158: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   161: aload #4
    //   163: invokevirtual moveFragmentToExpectedState : (Landroid/support/v4/app/Fragment;)V
    //   166: iload_1
    //   167: iconst_1
    //   168: iadd
    //   169: istore_1
    //   170: goto -> 10
    //   173: aload #4
    //   175: aload_3
    //   176: getfield exitAnim : I
    //   179: invokevirtual setNextAnim : (I)V
    //   182: aload_0
    //   183: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   186: aload #4
    //   188: invokevirtual removeFragment : (Landroid/support/v4/app/Fragment;)V
    //   191: goto -> 142
    //   194: aload #4
    //   196: aload_3
    //   197: getfield exitAnim : I
    //   200: invokevirtual setNextAnim : (I)V
    //   203: aload_0
    //   204: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   207: aload #4
    //   209: invokevirtual hideFragment : (Landroid/support/v4/app/Fragment;)V
    //   212: goto -> 142
    //   215: aload #4
    //   217: aload_3
    //   218: getfield enterAnim : I
    //   221: invokevirtual setNextAnim : (I)V
    //   224: aload_0
    //   225: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   228: aload #4
    //   230: invokevirtual showFragment : (Landroid/support/v4/app/Fragment;)V
    //   233: goto -> 142
    //   236: aload #4
    //   238: aload_3
    //   239: getfield exitAnim : I
    //   242: invokevirtual setNextAnim : (I)V
    //   245: aload_0
    //   246: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   249: aload #4
    //   251: invokevirtual detachFragment : (Landroid/support/v4/app/Fragment;)V
    //   254: goto -> 142
    //   257: aload #4
    //   259: aload_3
    //   260: getfield enterAnim : I
    //   263: invokevirtual setNextAnim : (I)V
    //   266: aload_0
    //   267: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   270: aload #4
    //   272: invokevirtual attachFragment : (Landroid/support/v4/app/Fragment;)V
    //   275: goto -> 142
    //   278: aload_0
    //   279: getfield mAllowOptimization : Z
    //   282: ifne -> 300
    //   285: aload_0
    //   286: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   289: aload_0
    //   290: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   293: getfield mCurState : I
    //   296: iconst_1
    //   297: invokevirtual moveToState : (IZ)V
    //   300: return
  }
  
  void executePopOps(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mOps : Ljava/util/ArrayList;
    //   4: invokevirtual size : ()I
    //   7: iconst_1
    //   8: isub
    //   9: istore_2
    //   10: iload_2
    //   11: iflt -> 282
    //   14: aload_0
    //   15: getfield mOps : Ljava/util/ArrayList;
    //   18: iload_2
    //   19: invokevirtual get : (I)Ljava/lang/Object;
    //   22: checkcast android/support/v4/app/BackStackRecord$Op
    //   25: astore_3
    //   26: aload_3
    //   27: getfield fragment : Landroid/support/v4/app/Fragment;
    //   30: astore #4
    //   32: aload #4
    //   34: aload_0
    //   35: getfield mTransition : I
    //   38: invokestatic reverseTransit : (I)I
    //   41: aload_0
    //   42: getfield mTransitionStyle : I
    //   45: invokevirtual setNextTransition : (II)V
    //   48: aload_3
    //   49: getfield cmd : I
    //   52: tableswitch default -> 96, 1 -> 127, 2 -> 96, 3 -> 176, 4 -> 198, 5 -> 219, 6 -> 240, 7 -> 261
    //   96: new java/lang/IllegalArgumentException
    //   99: dup
    //   100: new java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial <init> : ()V
    //   107: ldc_w 'Unknown cmd: '
    //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_3
    //   114: getfield cmd : I
    //   117: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   120: invokevirtual toString : ()Ljava/lang/String;
    //   123: invokespecial <init> : (Ljava/lang/String;)V
    //   126: athrow
    //   127: aload #4
    //   129: aload_3
    //   130: getfield popExitAnim : I
    //   133: invokevirtual setNextAnim : (I)V
    //   136: aload_0
    //   137: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   140: aload #4
    //   142: invokevirtual removeFragment : (Landroid/support/v4/app/Fragment;)V
    //   145: aload_0
    //   146: getfield mAllowOptimization : Z
    //   149: ifne -> 169
    //   152: aload_3
    //   153: getfield cmd : I
    //   156: iconst_3
    //   157: if_icmpeq -> 169
    //   160: aload_0
    //   161: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   164: aload #4
    //   166: invokevirtual moveFragmentToExpectedState : (Landroid/support/v4/app/Fragment;)V
    //   169: iload_2
    //   170: iconst_1
    //   171: isub
    //   172: istore_2
    //   173: goto -> 10
    //   176: aload #4
    //   178: aload_3
    //   179: getfield popEnterAnim : I
    //   182: invokevirtual setNextAnim : (I)V
    //   185: aload_0
    //   186: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   189: aload #4
    //   191: iconst_0
    //   192: invokevirtual addFragment : (Landroid/support/v4/app/Fragment;Z)V
    //   195: goto -> 145
    //   198: aload #4
    //   200: aload_3
    //   201: getfield popEnterAnim : I
    //   204: invokevirtual setNextAnim : (I)V
    //   207: aload_0
    //   208: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   211: aload #4
    //   213: invokevirtual showFragment : (Landroid/support/v4/app/Fragment;)V
    //   216: goto -> 145
    //   219: aload #4
    //   221: aload_3
    //   222: getfield popExitAnim : I
    //   225: invokevirtual setNextAnim : (I)V
    //   228: aload_0
    //   229: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   232: aload #4
    //   234: invokevirtual hideFragment : (Landroid/support/v4/app/Fragment;)V
    //   237: goto -> 145
    //   240: aload #4
    //   242: aload_3
    //   243: getfield popEnterAnim : I
    //   246: invokevirtual setNextAnim : (I)V
    //   249: aload_0
    //   250: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   253: aload #4
    //   255: invokevirtual attachFragment : (Landroid/support/v4/app/Fragment;)V
    //   258: goto -> 145
    //   261: aload #4
    //   263: aload_3
    //   264: getfield popExitAnim : I
    //   267: invokevirtual setNextAnim : (I)V
    //   270: aload_0
    //   271: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   274: aload #4
    //   276: invokevirtual detachFragment : (Landroid/support/v4/app/Fragment;)V
    //   279: goto -> 145
    //   282: aload_0
    //   283: getfield mAllowOptimization : Z
    //   286: ifne -> 308
    //   289: iload_1
    //   290: ifeq -> 308
    //   293: aload_0
    //   294: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   297: aload_0
    //   298: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   301: getfield mCurState : I
    //   304: iconst_1
    //   305: invokevirtual moveToState : (IZ)V
    //   308: return
  }
  
  void expandReplaceOps(ArrayList<Fragment> paramArrayList) {
    int i = 0;
    while (i < this.mOps.size()) {
      Op op = this.mOps.get(i);
      int j = i;
      switch (op.cmd) {
        default:
          j = i;
        case 4:
        case 5:
          i = j + 1;
          continue;
        case 1:
        case 7:
          paramArrayList.add(op.fragment);
          j = i;
        case 3:
        case 6:
          paramArrayList.remove(op.fragment);
          j = i;
        case 2:
          break;
      } 
      Fragment fragment = op.fragment;
      int k = fragment.mContainerId;
      boolean bool = false;
      j = paramArrayList.size() - 1;
      while (j >= 0) {
        Fragment fragment1 = paramArrayList.get(j);
        boolean bool1 = bool;
        int m = i;
        if (fragment1.mContainerId == k)
          if (fragment1 == fragment) {
            bool1 = true;
            m = i;
          } else {
            Op op1 = new Op();
            op1.cmd = 3;
            op1.fragment = fragment1;
            op1.enterAnim = op.enterAnim;
            op1.popEnterAnim = op.popEnterAnim;
            op1.exitAnim = op.exitAnim;
            op1.popExitAnim = op.popExitAnim;
            this.mOps.add(i, op1);
            paramArrayList.remove(fragment1);
            m = i + 1;
            bool1 = bool;
          }  
        j--;
        bool = bool1;
        i = m;
      } 
      if (bool) {
        this.mOps.remove(i);
        j = i - 1;
      } 
      op.cmd = 1;
      paramArrayList.add(fragment);
      j = i;
    } 
  }
  
  public boolean generateOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    if (FragmentManagerImpl.DEBUG)
      Log.v("FragmentManager", "Run: " + this); 
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.valueOf(false));
    if (this.mAddToBackStack)
      this.mManager.addBackStackState(this); 
    return true;
  }
  
  public CharSequence getBreadCrumbShortTitle() {
    return (this.mBreadCrumbShortTitleRes != 0) ? this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
  }
  
  public int getBreadCrumbShortTitleRes() {
    return this.mBreadCrumbShortTitleRes;
  }
  
  public CharSequence getBreadCrumbTitle() {
    return (this.mBreadCrumbTitleRes != 0) ? this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
  }
  
  public int getBreadCrumbTitleRes() {
    return this.mBreadCrumbTitleRes;
  }
  
  public int getId() {
    return this.mIndex;
  }
  
  public String getName() {
    return this.mName;
  }
  
  public int getTransition() {
    return this.mTransition;
  }
  
  public int getTransitionStyle() {
    return this.mTransitionStyle;
  }
  
  public FragmentTransaction hide(Fragment paramFragment) {
    Op op = new Op();
    op.cmd = 4;
    op.fragment = paramFragment;
    addOp(op);
    return this;
  }
  
  boolean interactsWith(int paramInt) {
    int j = this.mOps.size();
    for (int i = 0; i < j; i++) {
      if (((Op)this.mOps.get(i)).fragment.mContainerId == paramInt)
        return true; 
    } 
    return false;
  }
  
  boolean interactsWith(ArrayList<BackStackRecord> paramArrayList, int paramInt1, int paramInt2) {
    if (paramInt2 != paramInt1) {
      int k = this.mOps.size();
      int j = -1;
      int i = 0;
      while (true) {
        if (i < k) {
          int n = ((Op)this.mOps.get(i)).fragment.mContainerId;
          int m = j;
          if (n != 0) {
            m = j;
            if (n != j) {
              j = n;
              int i1 = paramInt1;
              while (true) {
                m = j;
                if (i1 < paramInt2) {
                  BackStackRecord backStackRecord = paramArrayList.get(i1);
                  int i2 = backStackRecord.mOps.size();
                  for (m = 0; m < i2; m++) {
                    if (((Op)backStackRecord.mOps.get(m)).fragment.mContainerId == n)
                      return true; 
                  } 
                  i1++;
                  continue;
                } 
                break;
              } 
            } 
          } 
          i++;
          j = m;
          continue;
        } 
        return false;
      } 
    } 
    return false;
  }
  
  public boolean isAddToBackStackAllowed() {
    return this.mAllowAddToBackStack;
  }
  
  public boolean isEmpty() {
    return this.mOps.isEmpty();
  }
  
  boolean isPostponed() {
    for (int i = 0; i < this.mOps.size(); i++) {
      if (isFragmentPostponed(this.mOps.get(i)))
        return true; 
    } 
    return false;
  }
  
  public FragmentTransaction remove(Fragment paramFragment) {
    Op op = new Op();
    op.cmd = 3;
    op.fragment = paramFragment;
    addOp(op);
    return this;
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment) {
    return replace(paramInt, paramFragment, null);
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment, String paramString) {
    if (paramInt == 0)
      throw new IllegalArgumentException("Must use non-zero containerViewId"); 
    doAddOp(paramInt, paramFragment, paramString, 2);
    return this;
  }
  
  public FragmentTransaction setAllowOptimization(boolean paramBoolean) {
    this.mAllowOptimization = paramBoolean;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(int paramInt) {
    this.mBreadCrumbShortTitleRes = paramInt;
    this.mBreadCrumbShortTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence) {
    this.mBreadCrumbShortTitleRes = 0;
    this.mBreadCrumbShortTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(int paramInt) {
    this.mBreadCrumbTitleRes = paramInt;
    this.mBreadCrumbTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence) {
    this.mBreadCrumbTitleRes = 0;
    this.mBreadCrumbTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2) {
    return setCustomAnimations(paramInt1, paramInt2, 0, 0);
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mEnterAnim = paramInt1;
    this.mExitAnim = paramInt2;
    this.mPopEnterAnim = paramInt3;
    this.mPopExitAnim = paramInt4;
    return this;
  }
  
  void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener paramOnStartEnterTransitionListener) {
    for (int i = 0; i < this.mOps.size(); i++) {
      Op op = this.mOps.get(i);
      if (isFragmentPostponed(op))
        op.fragment.setOnStartEnterTransitionListener(paramOnStartEnterTransitionListener); 
    } 
  }
  
  public FragmentTransaction setTransition(int paramInt) {
    this.mTransition = paramInt;
    return this;
  }
  
  public FragmentTransaction setTransitionStyle(int paramInt) {
    this.mTransitionStyle = paramInt;
    return this;
  }
  
  public FragmentTransaction show(Fragment paramFragment) {
    Op op = new Op();
    op.cmd = 5;
    op.fragment = paramFragment;
    addOp(op);
    return this;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("BackStackEntry{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.mIndex >= 0) {
      stringBuilder.append(" #");
      stringBuilder.append(this.mIndex);
    } 
    if (this.mName != null) {
      stringBuilder.append(" ");
      stringBuilder.append(this.mName);
    } 
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  void trackAddedFragmentsInPop(ArrayList<Fragment> paramArrayList) {
    int i = 0;
    while (i < this.mOps.size()) {
      Op op = this.mOps.get(i);
      switch (op.cmd) {
        default:
          i++;
          continue;
        case 1:
        case 7:
          paramArrayList.remove(op.fragment);
        case 3:
        case 6:
          break;
      } 
      paramArrayList.add(op.fragment);
    } 
  }
  
  static final class Op {
    int cmd;
    
    int enterAnim;
    
    int exitAnim;
    
    Fragment fragment;
    
    int popEnterAnim;
    
    int popExitAnim;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\BackStackRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */