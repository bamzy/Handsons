package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.v4.os.BuildCompat;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl extends FragmentManager implements LayoutInflaterFactory {
  static final Interpolator ACCELERATE_CUBIC;
  
  static final Interpolator ACCELERATE_QUINT;
  
  static final int ANIM_DUR = 220;
  
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  
  static boolean DEBUG = false;
  
  static final Interpolator DECELERATE_CUBIC;
  
  static final Interpolator DECELERATE_QUINT;
  
  static final boolean HONEYCOMB;
  
  static final String TAG = "FragmentManager";
  
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  
  static final String TARGET_STATE_TAG = "android:target_state";
  
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  
  static final String VIEW_STATE_TAG = "android:view_state";
  
  static Field sAnimationListenerField = null;
  
  ArrayList<Fragment> mActive;
  
  ArrayList<Fragment> mAdded;
  
  ArrayList<Integer> mAvailBackStackIndices;
  
  ArrayList<Integer> mAvailIndices;
  
  ArrayList<BackStackRecord> mBackStack;
  
  ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  
  ArrayList<BackStackRecord> mBackStackIndices;
  
  FragmentContainer mContainer;
  
  ArrayList<Fragment> mCreatedMenus;
  
  int mCurState = 0;
  
  boolean mDestroyed;
  
  Runnable mExecCommit = new Runnable() {
      public void run() {
        FragmentManagerImpl.this.execPendingActions();
      }
    };
  
  boolean mExecutingActions;
  
  boolean mHavePendingDeferredStart;
  
  FragmentHostCallback mHost;
  
  private CopyOnWriteArrayList<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> mLifecycleCallbacks;
  
  boolean mNeedMenuInvalidate;
  
  String mNoTransactionsBecause;
  
  Fragment mParent;
  
  ArrayList<OpGenerator> mPendingActions;
  
  ArrayList<StartEnterTransitionListener> mPostponedTransactions;
  
  SparseArray<Parcelable> mStateArray = null;
  
  Bundle mStateBundle = null;
  
  boolean mStateSaved;
  
  Runnable[] mTmpActions;
  
  ArrayList<Fragment> mTmpAddedFragments;
  
  ArrayList<Boolean> mTmpIsPop;
  
  ArrayList<BackStackRecord> mTmpRecords;
  
  static {
    DECELERATE_QUINT = (Interpolator)new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = (Interpolator)new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = (Interpolator)new AccelerateInterpolator(2.5F);
    ACCELERATE_CUBIC = (Interpolator)new AccelerateInterpolator(1.5F);
  }
  
  private void addAddedFragments(ArraySet<Fragment> paramArraySet) {
    if (this.mCurState >= 1) {
      int i;
      int k = Math.min(this.mCurState, 4);
      if (this.mAdded == null) {
        i = 0;
      } else {
        i = this.mAdded.size();
      } 
      int j = 0;
      while (true) {
        if (j < i) {
          Fragment fragment = this.mAdded.get(j);
          if (fragment.mState < k) {
            moveToState(fragment, k, fragment.getNextAnim(), fragment.getNextTransition(), false);
            if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded)
              paramArraySet.add(fragment); 
          } 
          j++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  private void checkStateLoss() {
    if (this.mStateSaved)
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState"); 
    if (this.mNoTransactionsBecause != null)
      throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause); 
  }
  
  private void cleanupExec() {
    this.mExecutingActions = false;
    this.mTmpIsPop.clear();
    this.mTmpRecords.clear();
  }
  
  private void completeExecute(BackStackRecord paramBackStackRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    ArrayList<BackStackRecord> arrayList = new ArrayList(1);
    ArrayList<Boolean> arrayList1 = new ArrayList(1);
    arrayList.add(paramBackStackRecord);
    arrayList1.add(Boolean.valueOf(paramBoolean1));
    executeOps(arrayList, arrayList1, 0, 1);
    if (paramBoolean2)
      FragmentTransition.startTransitions(this, arrayList, arrayList1, 0, 1, true); 
    if (paramBoolean3)
      moveToState(this.mCurState, true); 
    if (this.mActive != null) {
      int j = this.mActive.size();
      for (int i = 0; i < j; i++) {
        Fragment fragment = this.mActive.get(i);
        if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && paramBackStackRecord.interactsWith(fragment.mContainerId)) {
          if (Build.VERSION.SDK_INT >= 11 && fragment.mPostponedAlpha > 0.0F)
            fragment.mView.setAlpha(fragment.mPostponedAlpha); 
          if (paramBoolean3) {
            fragment.mPostponedAlpha = 0.0F;
          } else {
            fragment.mPostponedAlpha = -1.0F;
            fragment.mIsNewlyAdded = false;
          } 
        } 
      } 
    } 
  }
  
  private void endAnimatingAwayFragments() {
    int i;
    if (this.mActive == null) {
      i = 0;
    } else {
      i = this.mActive.size();
    } 
    for (int j = 0; j < i; j++) {
      Fragment fragment = this.mActive.get(j);
      if (fragment != null && fragment.getAnimatingAway() != null) {
        int k = fragment.getStateAfterAnimating();
        View view = fragment.getAnimatingAway();
        fragment.setAnimatingAway(null);
        Animation animation = view.getAnimation();
        if (animation != null)
          animation.cancel(); 
        moveToState(fragment, k, 0, 0, false);
      } 
    } 
  }
  
  private void ensureExecReady(boolean paramBoolean) {
    if (this.mExecutingActions)
      throw new IllegalStateException("FragmentManager is already executing transactions"); 
    if (Looper.myLooper() != this.mHost.getHandler().getLooper())
      throw new IllegalStateException("Must be called from main thread of fragment host"); 
    if (!paramBoolean)
      checkStateLoss(); 
    if (this.mTmpRecords == null) {
      this.mTmpRecords = new ArrayList<BackStackRecord>();
      this.mTmpIsPop = new ArrayList<Boolean>();
    } 
    this.mExecutingActions = true;
    try {
      executePostponedTransaction(null, null);
      return;
    } finally {
      this.mExecutingActions = false;
    } 
  }
  
  private static void executeOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(paramInt1);
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue()) {
        boolean bool;
        backStackRecord.bumpBackStackNesting(-1);
        if (paramInt1 == paramInt2 - 1) {
          bool = true;
        } else {
          bool = false;
        } 
        backStackRecord.executePopOps(bool);
      } else {
        backStackRecord.bumpBackStackNesting(1);
        backStackRecord.executeOps();
      } 
      paramInt1++;
    } 
  }
  
  private void executeOpsTogether(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2) {
    boolean bool1 = ((BackStackRecord)paramArrayList.get(paramInt1)).mAllowOptimization;
    boolean bool = false;
    if (this.mTmpAddedFragments == null) {
      this.mTmpAddedFragments = new ArrayList<Fragment>();
    } else {
      this.mTmpAddedFragments.clear();
    } 
    if (this.mAdded != null)
      this.mTmpAddedFragments.addAll(this.mAdded); 
    int i;
    for (i = paramInt1; i < paramInt2; i++) {
      BackStackRecord backStackRecord = paramArrayList.get(i);
      if (!((Boolean)paramArrayList1.get(i)).booleanValue()) {
        backStackRecord.expandReplaceOps(this.mTmpAddedFragments);
      } else {
        backStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments);
      } 
      if (bool || backStackRecord.mAddToBackStack) {
        bool = true;
      } else {
        bool = false;
      } 
    } 
    this.mTmpAddedFragments.clear();
    if (!bool1)
      FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false); 
    executeOps(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    i = paramInt2;
    if (bool1) {
      ArraySet<Fragment> arraySet = new ArraySet();
      addAddedFragments(arraySet);
      i = postponePostponableTransactions(paramArrayList, paramArrayList1, paramInt1, paramInt2, arraySet);
      makeRemovedFragmentsInvisible(arraySet);
    } 
    if (i != paramInt1 && bool1) {
      FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, i, true);
      moveToState(this.mCurState, true);
    } 
    while (paramInt1 < paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(paramInt1);
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue() && backStackRecord.mIndex >= 0) {
        freeBackStackIndex(backStackRecord.mIndex);
        backStackRecord.mIndex = -1;
      } 
      paramInt1++;
    } 
    if (bool)
      reportBackStackChanged(); 
  }
  
  private void executePostponedTransaction(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   4: ifnonnull -> 105
    //   7: iconst_0
    //   8: istore_3
    //   9: iconst_0
    //   10: istore #5
    //   12: iload_3
    //   13: istore #4
    //   15: iload #5
    //   17: istore_3
    //   18: iload_3
    //   19: iload #4
    //   21: if_icmpge -> 236
    //   24: aload_0
    //   25: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   28: iload_3
    //   29: invokevirtual get : (I)Ljava/lang/Object;
    //   32: checkcast android/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener
    //   35: astore #7
    //   37: aload_1
    //   38: ifnull -> 116
    //   41: aload #7
    //   43: invokestatic access$000 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Z
    //   46: ifne -> 116
    //   49: aload_1
    //   50: aload #7
    //   52: invokestatic access$100 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Landroid/support/v4/app/BackStackRecord;
    //   55: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   58: istore #5
    //   60: iload #5
    //   62: iconst_m1
    //   63: if_icmpeq -> 116
    //   66: aload_2
    //   67: iload #5
    //   69: invokevirtual get : (I)Ljava/lang/Object;
    //   72: checkcast java/lang/Boolean
    //   75: invokevirtual booleanValue : ()Z
    //   78: ifeq -> 116
    //   81: aload #7
    //   83: invokevirtual cancelTransaction : ()V
    //   86: iload #4
    //   88: istore #6
    //   90: iload_3
    //   91: istore #5
    //   93: iload #5
    //   95: iconst_1
    //   96: iadd
    //   97: istore_3
    //   98: iload #6
    //   100: istore #4
    //   102: goto -> 18
    //   105: aload_0
    //   106: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   109: invokevirtual size : ()I
    //   112: istore_3
    //   113: goto -> 9
    //   116: aload #7
    //   118: invokevirtual isReady : ()Z
    //   121: ifne -> 159
    //   124: iload_3
    //   125: istore #5
    //   127: iload #4
    //   129: istore #6
    //   131: aload_1
    //   132: ifnull -> 93
    //   135: iload_3
    //   136: istore #5
    //   138: iload #4
    //   140: istore #6
    //   142: aload #7
    //   144: invokestatic access$100 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Landroid/support/v4/app/BackStackRecord;
    //   147: aload_1
    //   148: iconst_0
    //   149: aload_1
    //   150: invokevirtual size : ()I
    //   153: invokevirtual interactsWith : (Ljava/util/ArrayList;II)Z
    //   156: ifeq -> 93
    //   159: aload_0
    //   160: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   163: iload_3
    //   164: invokevirtual remove : (I)Ljava/lang/Object;
    //   167: pop
    //   168: iload_3
    //   169: iconst_1
    //   170: isub
    //   171: istore #5
    //   173: iload #4
    //   175: iconst_1
    //   176: isub
    //   177: istore #6
    //   179: aload_1
    //   180: ifnull -> 228
    //   183: aload #7
    //   185: invokestatic access$000 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Z
    //   188: ifne -> 228
    //   191: aload_1
    //   192: aload #7
    //   194: invokestatic access$100 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Landroid/support/v4/app/BackStackRecord;
    //   197: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   200: istore_3
    //   201: iload_3
    //   202: iconst_m1
    //   203: if_icmpeq -> 228
    //   206: aload_2
    //   207: iload_3
    //   208: invokevirtual get : (I)Ljava/lang/Object;
    //   211: checkcast java/lang/Boolean
    //   214: invokevirtual booleanValue : ()Z
    //   217: ifeq -> 228
    //   220: aload #7
    //   222: invokevirtual cancelTransaction : ()V
    //   225: goto -> 93
    //   228: aload #7
    //   230: invokevirtual completeTransaction : ()V
    //   233: goto -> 93
    //   236: return
  }
  
  private Fragment findFragmentUnder(Fragment paramFragment) {
    ViewGroup viewGroup = paramFragment.mContainer;
    View view = paramFragment.mView;
    if (viewGroup == null || view == null)
      return null; 
    for (int i = this.mAdded.indexOf(paramFragment) - 1; i >= 0; i--) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment.mContainer == viewGroup) {
        paramFragment = fragment;
        if (fragment.mView == null)
          continue; 
        return paramFragment;
      } 
      continue;
    } 
    return null;
  }
  
  private void forcePostponedTransactions() {
    if (this.mPostponedTransactions != null)
      while (!this.mPostponedTransactions.isEmpty())
        ((StartEnterTransitionListener)this.mPostponedTransactions.remove(0)).completeTransaction();  
  }
  
  private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPendingActions : Ljava/util/ArrayList;
    //   6: ifnull -> 19
    //   9: aload_0
    //   10: getfield mPendingActions : Ljava/util/ArrayList;
    //   13: invokevirtual size : ()I
    //   16: ifne -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_0
    //   24: getfield mPendingActions : Ljava/util/ArrayList;
    //   27: invokevirtual size : ()I
    //   30: istore #4
    //   32: iconst_0
    //   33: istore_3
    //   34: iload_3
    //   35: iload #4
    //   37: if_icmpge -> 66
    //   40: aload_0
    //   41: getfield mPendingActions : Ljava/util/ArrayList;
    //   44: iload_3
    //   45: invokevirtual get : (I)Ljava/lang/Object;
    //   48: checkcast android/support/v4/app/FragmentManagerImpl$OpGenerator
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface generateOps : (Ljava/util/ArrayList;Ljava/util/ArrayList;)Z
    //   58: pop
    //   59: iload_3
    //   60: iconst_1
    //   61: iadd
    //   62: istore_3
    //   63: goto -> 34
    //   66: aload_0
    //   67: getfield mPendingActions : Ljava/util/ArrayList;
    //   70: invokevirtual clear : ()V
    //   73: aload_0
    //   74: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   77: invokevirtual getHandler : ()Landroid/os/Handler;
    //   80: aload_0
    //   81: getfield mExecCommit : Ljava/lang/Runnable;
    //   84: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   87: aload_0
    //   88: monitorexit
    //   89: iload #4
    //   91: ifle -> 101
    //   94: iconst_1
    //   95: ireturn
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: iconst_0
    //   102: ireturn
    // Exception table:
    //   from	to	target	type
    //   2	19	96	finally
    //   19	21	96	finally
    //   23	32	96	finally
    //   40	59	96	finally
    //   66	89	96	finally
    //   97	99	96	finally
  }
  
  static Animation makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2) {
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    alphaAnimation.setInterpolator(DECELERATE_CUBIC);
    alphaAnimation.setDuration(220L);
    return (Animation)alphaAnimation;
  }
  
  static Animation makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    AnimationSet animationSet = new AnimationSet(false);
    ScaleAnimation scaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setInterpolator(DECELERATE_QUINT);
    scaleAnimation.setDuration(220L);
    animationSet.addAnimation((Animation)scaleAnimation);
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat3, paramFloat4);
    alphaAnimation.setInterpolator(DECELERATE_CUBIC);
    alphaAnimation.setDuration(220L);
    animationSet.addAnimation((Animation)alphaAnimation);
    return (Animation)animationSet;
  }
  
  private void makeRemovedFragmentsInvisible(ArraySet<Fragment> paramArraySet) {
    int j = paramArraySet.size();
    for (int i = 0; i < j; i++) {
      Fragment fragment = (Fragment)paramArraySet.valueAt(i);
      if (!fragment.mAdded) {
        View view = fragment.getView();
        if (Build.VERSION.SDK_INT < 11) {
          fragment.getView().setVisibility(4);
        } else {
          fragment.mPostponedAlpha = view.getAlpha();
          view.setAlpha(0.0F);
        } 
      } 
    } 
  }
  
  static boolean modifiesAlpha(Animation paramAnimation) {
    if (!(paramAnimation instanceof AlphaAnimation)) {
      if (paramAnimation instanceof AnimationSet) {
        List list = ((AnimationSet)paramAnimation).getAnimations();
        int i = 0;
        while (i < list.size()) {
          if (!(list.get(i) instanceof AlphaAnimation)) {
            i++;
            continue;
          } 
          return true;
        } 
      } 
      return false;
    } 
    return true;
  }
  
  private void optimizeAndExecuteOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    if (paramArrayList != null && !paramArrayList.isEmpty()) {
      if (paramArrayList1 == null || paramArrayList.size() != paramArrayList1.size())
        throw new IllegalStateException("Internal error with the back stack records"); 
      executePostponedTransaction(paramArrayList, paramArrayList1);
      int k = paramArrayList.size();
      int j = 0;
      int i = 0;
      while (i < k) {
        int n = i;
        int m = j;
        if (!((BackStackRecord)paramArrayList.get(i)).mAllowOptimization) {
          if (j != i)
            executeOpsTogether(paramArrayList, paramArrayList1, j, i); 
          j = i + 1;
          m = j;
          if (((Boolean)paramArrayList1.get(i)).booleanValue())
            while (true) {
              m = j;
              if (j < k) {
                m = j;
                if (((Boolean)paramArrayList1.get(j)).booleanValue()) {
                  m = j;
                  if (!((BackStackRecord)paramArrayList.get(j)).mAllowOptimization) {
                    j++;
                    continue;
                  } 
                } 
              } 
              break;
            }  
          executeOpsTogether(paramArrayList, paramArrayList1, i, m);
          i = m;
          n = m - 1;
          m = i;
        } 
        i = n + 1;
        j = m;
      } 
      if (j != k) {
        executeOpsTogether(paramArrayList, paramArrayList1, j, k);
        return;
      } 
    } 
  }
  
  private boolean popBackStackImmediate(String paramString, int paramInt1, int paramInt2) {
    execPendingActions();
    ensureExecReady(true);
    boolean bool = popBackStackState(this.mTmpRecords, this.mTmpIsPop, paramString, paramInt1, paramInt2);
    if (bool) {
      this.mExecutingActions = true;
      try {
        optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
        return bool;
      } finally {
        cleanupExec();
      } 
    } 
    doPendingDeferredStart();
    return bool;
  }
  
  private int postponePostponableTransactions(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, ArraySet<Fragment> paramArraySet) {
    int j = paramInt2;
    int i = paramInt2 - 1;
    while (i >= paramInt1) {
      boolean bool;
      BackStackRecord backStackRecord = paramArrayList.get(i);
      boolean bool1 = ((Boolean)paramArrayList1.get(i)).booleanValue();
      if (backStackRecord.isPostponed() && !backStackRecord.interactsWith(paramArrayList, i + 1, paramInt2)) {
        bool = true;
      } else {
        bool = false;
      } 
      int k = j;
      if (bool) {
        if (this.mPostponedTransactions == null)
          this.mPostponedTransactions = new ArrayList<StartEnterTransitionListener>(); 
        StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, bool1);
        this.mPostponedTransactions.add(startEnterTransitionListener);
        backStackRecord.setOnStartPostponedListener(startEnterTransitionListener);
        if (bool1) {
          backStackRecord.executeOps();
        } else {
          backStackRecord.executePopOps(false);
        } 
        k = j - 1;
        if (i != k) {
          paramArrayList.remove(i);
          paramArrayList.add(k, backStackRecord);
        } 
        addAddedFragments(paramArraySet);
      } 
      i--;
      j = k;
    } 
    return j;
  }
  
  public static int reverseTransit(int paramInt) {
    switch (paramInt) {
      default:
        return 0;
      case 4097:
        return 8194;
      case 8194:
        return 4097;
      case 4099:
        break;
    } 
    return 4099;
  }
  
  private void scheduleCommit() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   8: ifnull -> 92
    //   11: aload_0
    //   12: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   15: invokevirtual isEmpty : ()Z
    //   18: ifne -> 92
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: getfield mPendingActions : Ljava/util/ArrayList;
    //   27: ifnull -> 97
    //   30: aload_0
    //   31: getfield mPendingActions : Ljava/util/ArrayList;
    //   34: invokevirtual size : ()I
    //   37: iconst_1
    //   38: if_icmpne -> 97
    //   41: goto -> 81
    //   44: aload_0
    //   45: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   48: invokevirtual getHandler : ()Landroid/os/Handler;
    //   51: aload_0
    //   52: getfield mExecCommit : Ljava/lang/Runnable;
    //   55: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   58: aload_0
    //   59: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   62: invokevirtual getHandler : ()Landroid/os/Handler;
    //   65: aload_0
    //   66: getfield mExecCommit : Ljava/lang/Runnable;
    //   69: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   72: pop
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: astore_3
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_3
    //   80: athrow
    //   81: iload_1
    //   82: ifne -> 44
    //   85: iload_2
    //   86: ifeq -> 73
    //   89: goto -> 44
    //   92: iconst_0
    //   93: istore_1
    //   94: goto -> 23
    //   97: iconst_0
    //   98: istore_2
    //   99: goto -> 81
    // Exception table:
    //   from	to	target	type
    //   4	21	76	finally
    //   23	41	76	finally
    //   44	73	76	finally
    //   73	75	76	finally
    //   77	79	76	finally
  }
  
  private void setHWLayerAnimListenerIfAlpha(View paramView, Animation paramAnimation) {
    if (paramView != null && paramAnimation != null && shouldRunOnHWLayer(paramView, paramAnimation)) {
      Animation.AnimationListener animationListener = null;
      try {
        if (sAnimationListenerField == null) {
          sAnimationListenerField = Animation.class.getDeclaredField("mListener");
          sAnimationListenerField.setAccessible(true);
        } 
        Animation.AnimationListener animationListener1 = (Animation.AnimationListener)sAnimationListenerField.get(paramAnimation);
        animationListener = animationListener1;
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("FragmentManager", "No field with the name mListener is found in Animation class", noSuchFieldException);
      } catch (IllegalAccessException illegalAccessException) {
        Log.e("FragmentManager", "Cannot access Animation's mListener field", illegalAccessException);
      } 
      ViewCompat.setLayerType(paramView, 2, null);
      paramAnimation.setAnimationListener(new AnimateOnHWLayerIfNeededListener(paramView, paramAnimation, animationListener));
      return;
    } 
  }
  
  static boolean shouldRunOnHWLayer(View paramView, Animation paramAnimation) {
    return (Build.VERSION.SDK_INT >= 19 && ViewCompat.getLayerType(paramView) == 0 && ViewCompat.hasOverlappingRendering(paramView) && modifiesAlpha(paramAnimation));
  }
  
  private void throwException(RuntimeException paramRuntimeException) {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter printWriter = new PrintWriter((Writer)new LogWriter("FragmentManager"));
    if (this.mHost != null) {
      try {
        this.mHost.onDump("  ", null, printWriter, new String[0]);
      } catch (Exception exception) {
        Log.e("FragmentManager", "Failed dumping state", exception);
      } 
      throw paramRuntimeException;
    } 
    try {
      dump("  ", null, (PrintWriter)exception, new String[0]);
    } catch (Exception exception1) {
      Log.e("FragmentManager", "Failed dumping state", exception1);
    } 
    throw paramRuntimeException;
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean) {
    switch (paramInt) {
      default:
        return -1;
      case 4097:
        return paramBoolean ? 1 : 2;
      case 8194:
        return paramBoolean ? 3 : 4;
      case 4099:
        break;
    } 
    return paramBoolean ? 5 : 6;
  }
  
  void addBackStackState(BackStackRecord paramBackStackRecord) {
    if (this.mBackStack == null)
      this.mBackStack = new ArrayList<BackStackRecord>(); 
    this.mBackStack.add(paramBackStackRecord);
    reportBackStackChanged();
  }
  
  public void addFragment(Fragment paramFragment, boolean paramBoolean) {
    if (this.mAdded == null)
      this.mAdded = new ArrayList<Fragment>(); 
    if (DEBUG)
      Log.v("FragmentManager", "add: " + paramFragment); 
    makeActive(paramFragment);
    if (!paramFragment.mDetached) {
      if (this.mAdded.contains(paramFragment))
        throw new IllegalStateException("Fragment already added: " + paramFragment); 
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      paramFragment.mRemoving = false;
      if (paramFragment.mView == null)
        paramFragment.mHiddenChanged = false; 
      if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
        this.mNeedMenuInvalidate = true; 
      if (paramBoolean)
        moveToState(paramFragment); 
    } 
  }
  
  public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener) {
    if (this.mBackStackChangeListeners == null)
      this.mBackStackChangeListeners = new ArrayList<FragmentManager.OnBackStackChangedListener>(); 
    this.mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  public int allocBackStackIndex(BackStackRecord paramBackStackRecord) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   6: ifnull -> 19
    //   9: aload_0
    //   10: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   13: invokevirtual size : ()I
    //   16: ifgt -> 100
    //   19: aload_0
    //   20: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   23: ifnonnull -> 37
    //   26: aload_0
    //   27: new java/util/ArrayList
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: putfield mBackStackIndices : Ljava/util/ArrayList;
    //   37: aload_0
    //   38: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   41: invokevirtual size : ()I
    //   44: istore_2
    //   45: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   48: ifeq -> 87
    //   51: ldc 'FragmentManager'
    //   53: new java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial <init> : ()V
    //   60: ldc_w 'Setting back stack index '
    //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_2
    //   67: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   70: ldc_w ' to '
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: invokevirtual toString : ()Ljava/lang/String;
    //   83: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   86: pop
    //   87: aload_0
    //   88: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   91: aload_1
    //   92: invokevirtual add : (Ljava/lang/Object;)Z
    //   95: pop
    //   96: aload_0
    //   97: monitorexit
    //   98: iload_2
    //   99: ireturn
    //   100: aload_0
    //   101: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   104: aload_0
    //   105: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   108: invokevirtual size : ()I
    //   111: iconst_1
    //   112: isub
    //   113: invokevirtual remove : (I)Ljava/lang/Object;
    //   116: checkcast java/lang/Integer
    //   119: invokevirtual intValue : ()I
    //   122: istore_2
    //   123: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   126: ifeq -> 165
    //   129: ldc 'FragmentManager'
    //   131: new java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial <init> : ()V
    //   138: ldc_w 'Adding back stack index '
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: iload_2
    //   145: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   148: ldc_w ' with '
    //   151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_1
    //   155: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual toString : ()Ljava/lang/String;
    //   161: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   164: pop
    //   165: aload_0
    //   166: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   169: iload_2
    //   170: aload_1
    //   171: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: aload_0
    //   176: monitorexit
    //   177: iload_2
    //   178: ireturn
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	179	finally
    //   19	37	179	finally
    //   37	87	179	finally
    //   87	98	179	finally
    //   100	165	179	finally
    //   165	177	179	finally
    //   180	182	179	finally
  }
  
  public void attachController(FragmentHostCallback paramFragmentHostCallback, FragmentContainer paramFragmentContainer, Fragment paramFragment) {
    if (this.mHost != null)
      throw new IllegalStateException("Already attached"); 
    this.mHost = paramFragmentHostCallback;
    this.mContainer = paramFragmentContainer;
    this.mParent = paramFragment;
  }
  
  public void attachFragment(Fragment paramFragment) {
    if (DEBUG)
      Log.v("FragmentManager", "attach: " + paramFragment); 
    if (paramFragment.mDetached) {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded) {
        if (this.mAdded == null)
          this.mAdded = new ArrayList<Fragment>(); 
        if (this.mAdded.contains(paramFragment))
          throw new IllegalStateException("Fragment already added: " + paramFragment); 
        if (DEBUG)
          Log.v("FragmentManager", "add from attach: " + paramFragment); 
        this.mAdded.add(paramFragment);
        paramFragment.mAdded = true;
        if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
          this.mNeedMenuInvalidate = true; 
      } 
    } 
  }
  
  public FragmentTransaction beginTransaction() {
    return new BackStackRecord(this);
  }
  
  void completeShowHideFragment(Fragment paramFragment) {
    if (paramFragment.mView != null) {
      boolean bool;
      int i = paramFragment.getNextTransition();
      if (!paramFragment.mHidden) {
        bool = true;
      } else {
        bool = false;
      } 
      Animation animation = loadAnimation(paramFragment, i, bool, paramFragment.getNextTransitionStyle());
      if (animation != null) {
        setHWLayerAnimListenerIfAlpha(paramFragment.mView, animation);
        paramFragment.mView.startAnimation(animation);
        setHWLayerAnimListenerIfAlpha(paramFragment.mView, animation);
        animation.start();
      } 
      if (paramFragment.mHidden && !paramFragment.isHideReplaced()) {
        i = 8;
      } else {
        i = 0;
      } 
      paramFragment.mView.setVisibility(i);
      if (paramFragment.isHideReplaced())
        paramFragment.setHideReplaced(false); 
    } 
    if (paramFragment.mAdded && paramFragment.mHasMenu && paramFragment.mMenuVisible)
      this.mNeedMenuInvalidate = true; 
    paramFragment.mHiddenChanged = false;
    paramFragment.onHiddenChanged(paramFragment.mHidden);
  }
  
  public void detachFragment(Fragment paramFragment) {
    if (DEBUG)
      Log.v("FragmentManager", "detach: " + paramFragment); 
    if (!paramFragment.mDetached) {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded) {
        if (this.mAdded != null) {
          if (DEBUG)
            Log.v("FragmentManager", "remove from detach: " + paramFragment); 
          this.mAdded.remove(paramFragment);
        } 
        if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
          this.mNeedMenuInvalidate = true; 
        paramFragment.mAdded = false;
      } 
    } 
  }
  
  public void dispatchActivityCreated() {
    this.mStateSaved = false;
    this.mExecutingActions = true;
    moveToState(2, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration) {
    if (this.mAdded != null)
      for (int i = 0; i < this.mAdded.size(); i++) {
        Fragment fragment = this.mAdded.get(i);
        if (fragment != null)
          fragment.performConfigurationChanged(paramConfiguration); 
      }  
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem) {
    if (this.mAdded != null)
      for (int i = 0; i < this.mAdded.size(); i++) {
        Fragment fragment = this.mAdded.get(i);
        if (fragment != null && fragment.performContextItemSelected(paramMenuItem))
          return true; 
      }  
    return false;
  }
  
  public void dispatchCreate() {
    this.mStateSaved = false;
    this.mExecutingActions = true;
    moveToState(1, false);
    this.mExecutingActions = false;
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
    boolean bool2 = false;
    boolean bool1 = false;
    ArrayList<Fragment> arrayList2 = null;
    ArrayList<Fragment> arrayList1 = null;
    if (this.mAdded != null) {
      int i = 0;
      while (true) {
        arrayList2 = arrayList1;
        bool2 = bool1;
        if (i < this.mAdded.size()) {
          Fragment fragment = this.mAdded.get(i);
          arrayList2 = arrayList1;
          bool2 = bool1;
          if (fragment != null) {
            arrayList2 = arrayList1;
            bool2 = bool1;
            if (fragment.performCreateOptionsMenu(paramMenu, paramMenuInflater)) {
              bool2 = true;
              arrayList2 = arrayList1;
              if (arrayList1 == null)
                arrayList2 = new ArrayList(); 
              arrayList2.add(fragment);
            } 
          } 
          i++;
          arrayList1 = arrayList2;
          bool1 = bool2;
          continue;
        } 
        break;
      } 
    } 
    if (this.mCreatedMenus != null)
      for (int i = 0; i < this.mCreatedMenus.size(); i++) {
        Fragment fragment = this.mCreatedMenus.get(i);
        if (arrayList2 == null || !arrayList2.contains(fragment))
          fragment.onDestroyOptionsMenu(); 
      }  
    this.mCreatedMenus = arrayList2;
    return bool2;
  }
  
  public void dispatchDestroy() {
    this.mDestroyed = true;
    execPendingActions();
    this.mExecutingActions = true;
    moveToState(0, false);
    this.mExecutingActions = false;
    this.mHost = null;
    this.mContainer = null;
    this.mParent = null;
  }
  
  public void dispatchDestroyView() {
    this.mExecutingActions = true;
    moveToState(1, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchLowMemory() {
    if (this.mAdded != null)
      for (int i = 0; i < this.mAdded.size(); i++) {
        Fragment fragment = this.mAdded.get(i);
        if (fragment != null)
          fragment.performLowMemory(); 
      }  
  }
  
  public void dispatchMultiWindowModeChanged(boolean paramBoolean) {
    if (this.mAdded != null) {
      int i = this.mAdded.size() - 1;
      while (true) {
        if (i >= 0) {
          Fragment fragment = this.mAdded.get(i);
          if (fragment != null)
            fragment.performMultiWindowModeChanged(paramBoolean); 
          i--;
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentActivityCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentActivityCreated(paramFragment, paramBundle, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentActivityCreated(this, paramFragment, paramBundle); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentAttached(paramFragment, paramContext, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentAttached(this, paramFragment, paramContext); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentCreated(paramFragment, paramBundle, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentCreated(this, paramFragment, paramBundle); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentDestroyed(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentDestroyed(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentDestroyed(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentDetached(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentDetached(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentDetached(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentPaused(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentPaused(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentPaused(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentPreAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentPreAttached(paramFragment, paramContext, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentPreAttached(this, paramFragment, paramContext); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentResumed(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentResumed(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentResumed(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentSaveInstanceState(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentSaveInstanceState(paramFragment, paramBundle, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentSaveInstanceState(this, paramFragment, paramBundle); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentStarted(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentStarted(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentStarted(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentStopped(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentStopped(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentStopped(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentViewCreated(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentViewCreated(paramFragment, paramView, paramBundle, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentViewCreated(this, paramFragment, paramView, paramBundle); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentViewDestroyed(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentViewDestroyed(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentViewDestroyed(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem) {
    if (this.mAdded != null)
      for (int i = 0; i < this.mAdded.size(); i++) {
        Fragment fragment = this.mAdded.get(i);
        if (fragment != null && fragment.performOptionsItemSelected(paramMenuItem))
          return true; 
      }  
    return false;
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu) {
    if (this.mAdded != null)
      for (int i = 0; i < this.mAdded.size(); i++) {
        Fragment fragment = this.mAdded.get(i);
        if (fragment != null)
          fragment.performOptionsMenuClosed(paramMenu); 
      }  
  }
  
  public void dispatchPause() {
    this.mExecutingActions = true;
    moveToState(4, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchPictureInPictureModeChanged(boolean paramBoolean) {
    if (this.mAdded != null) {
      int i = this.mAdded.size() - 1;
      while (true) {
        if (i >= 0) {
          Fragment fragment = this.mAdded.get(i);
          if (fragment != null)
            fragment.performPictureInPictureModeChanged(paramBoolean); 
          i--;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu) {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.mAdded != null) {
      int i = 0;
      while (true) {
        bool2 = bool1;
        if (i < this.mAdded.size()) {
          Fragment fragment = this.mAdded.get(i);
          bool2 = bool1;
          if (fragment != null) {
            bool2 = bool1;
            if (fragment.performPrepareOptionsMenu(paramMenu))
              bool2 = true; 
          } 
          i++;
          bool1 = bool2;
          continue;
        } 
        break;
      } 
    } 
    return bool2;
  }
  
  public void dispatchReallyStop() {
    this.mExecutingActions = true;
    moveToState(2, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchResume() {
    this.mStateSaved = false;
    this.mExecutingActions = true;
    moveToState(5, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchStart() {
    this.mStateSaved = false;
    this.mExecutingActions = true;
    moveToState(4, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchStop() {
    this.mStateSaved = true;
    this.mExecutingActions = true;
    moveToState(3, false);
    this.mExecutingActions = false;
  }
  
  void doPendingDeferredStart() {
    if (this.mHavePendingDeferredStart) {
      boolean bool = false;
      int i = 0;
      while (i < this.mActive.size()) {
        Fragment fragment = this.mActive.get(i);
        boolean bool1 = bool;
        if (fragment != null) {
          bool1 = bool;
          if (fragment.mLoaderManager != null)
            bool1 = bool | fragment.mLoaderManager.hasRunningLoaders(); 
        } 
        i++;
        bool = bool1;
      } 
      if (!bool) {
        this.mHavePendingDeferredStart = false;
        startPendingDeferredFragments();
      } 
    } 
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: aload_1
    //   8: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11: ldc_w '    '
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual toString : ()Ljava/lang/String;
    //   20: astore #7
    //   22: aload_0
    //   23: getfield mActive : Ljava/util/ArrayList;
    //   26: ifnull -> 153
    //   29: aload_0
    //   30: getfield mActive : Ljava/util/ArrayList;
    //   33: invokevirtual size : ()I
    //   36: istore #6
    //   38: iload #6
    //   40: ifle -> 153
    //   43: aload_3
    //   44: aload_1
    //   45: invokevirtual print : (Ljava/lang/String;)V
    //   48: aload_3
    //   49: ldc_w 'Active Fragments in '
    //   52: invokevirtual print : (Ljava/lang/String;)V
    //   55: aload_3
    //   56: aload_0
    //   57: invokestatic identityHashCode : (Ljava/lang/Object;)I
    //   60: invokestatic toHexString : (I)Ljava/lang/String;
    //   63: invokevirtual print : (Ljava/lang/String;)V
    //   66: aload_3
    //   67: ldc_w ':'
    //   70: invokevirtual println : (Ljava/lang/String;)V
    //   73: iconst_0
    //   74: istore #5
    //   76: iload #5
    //   78: iload #6
    //   80: if_icmpge -> 153
    //   83: aload_0
    //   84: getfield mActive : Ljava/util/ArrayList;
    //   87: iload #5
    //   89: invokevirtual get : (I)Ljava/lang/Object;
    //   92: checkcast android/support/v4/app/Fragment
    //   95: astore #8
    //   97: aload_3
    //   98: aload_1
    //   99: invokevirtual print : (Ljava/lang/String;)V
    //   102: aload_3
    //   103: ldc_w '  #'
    //   106: invokevirtual print : (Ljava/lang/String;)V
    //   109: aload_3
    //   110: iload #5
    //   112: invokevirtual print : (I)V
    //   115: aload_3
    //   116: ldc_w ': '
    //   119: invokevirtual print : (Ljava/lang/String;)V
    //   122: aload_3
    //   123: aload #8
    //   125: invokevirtual println : (Ljava/lang/Object;)V
    //   128: aload #8
    //   130: ifnull -> 144
    //   133: aload #8
    //   135: aload #7
    //   137: aload_2
    //   138: aload_3
    //   139: aload #4
    //   141: invokevirtual dump : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   144: iload #5
    //   146: iconst_1
    //   147: iadd
    //   148: istore #5
    //   150: goto -> 76
    //   153: aload_0
    //   154: getfield mAdded : Ljava/util/ArrayList;
    //   157: ifnull -> 253
    //   160: aload_0
    //   161: getfield mAdded : Ljava/util/ArrayList;
    //   164: invokevirtual size : ()I
    //   167: istore #6
    //   169: iload #6
    //   171: ifle -> 253
    //   174: aload_3
    //   175: aload_1
    //   176: invokevirtual print : (Ljava/lang/String;)V
    //   179: aload_3
    //   180: ldc_w 'Added Fragments:'
    //   183: invokevirtual println : (Ljava/lang/String;)V
    //   186: iconst_0
    //   187: istore #5
    //   189: iload #5
    //   191: iload #6
    //   193: if_icmpge -> 253
    //   196: aload_0
    //   197: getfield mAdded : Ljava/util/ArrayList;
    //   200: iload #5
    //   202: invokevirtual get : (I)Ljava/lang/Object;
    //   205: checkcast android/support/v4/app/Fragment
    //   208: astore #8
    //   210: aload_3
    //   211: aload_1
    //   212: invokevirtual print : (Ljava/lang/String;)V
    //   215: aload_3
    //   216: ldc_w '  #'
    //   219: invokevirtual print : (Ljava/lang/String;)V
    //   222: aload_3
    //   223: iload #5
    //   225: invokevirtual print : (I)V
    //   228: aload_3
    //   229: ldc_w ': '
    //   232: invokevirtual print : (Ljava/lang/String;)V
    //   235: aload_3
    //   236: aload #8
    //   238: invokevirtual toString : ()Ljava/lang/String;
    //   241: invokevirtual println : (Ljava/lang/String;)V
    //   244: iload #5
    //   246: iconst_1
    //   247: iadd
    //   248: istore #5
    //   250: goto -> 189
    //   253: aload_0
    //   254: getfield mCreatedMenus : Ljava/util/ArrayList;
    //   257: ifnull -> 353
    //   260: aload_0
    //   261: getfield mCreatedMenus : Ljava/util/ArrayList;
    //   264: invokevirtual size : ()I
    //   267: istore #6
    //   269: iload #6
    //   271: ifle -> 353
    //   274: aload_3
    //   275: aload_1
    //   276: invokevirtual print : (Ljava/lang/String;)V
    //   279: aload_3
    //   280: ldc_w 'Fragments Created Menus:'
    //   283: invokevirtual println : (Ljava/lang/String;)V
    //   286: iconst_0
    //   287: istore #5
    //   289: iload #5
    //   291: iload #6
    //   293: if_icmpge -> 353
    //   296: aload_0
    //   297: getfield mCreatedMenus : Ljava/util/ArrayList;
    //   300: iload #5
    //   302: invokevirtual get : (I)Ljava/lang/Object;
    //   305: checkcast android/support/v4/app/Fragment
    //   308: astore #8
    //   310: aload_3
    //   311: aload_1
    //   312: invokevirtual print : (Ljava/lang/String;)V
    //   315: aload_3
    //   316: ldc_w '  #'
    //   319: invokevirtual print : (Ljava/lang/String;)V
    //   322: aload_3
    //   323: iload #5
    //   325: invokevirtual print : (I)V
    //   328: aload_3
    //   329: ldc_w ': '
    //   332: invokevirtual print : (Ljava/lang/String;)V
    //   335: aload_3
    //   336: aload #8
    //   338: invokevirtual toString : ()Ljava/lang/String;
    //   341: invokevirtual println : (Ljava/lang/String;)V
    //   344: iload #5
    //   346: iconst_1
    //   347: iadd
    //   348: istore #5
    //   350: goto -> 289
    //   353: aload_0
    //   354: getfield mBackStack : Ljava/util/ArrayList;
    //   357: ifnull -> 464
    //   360: aload_0
    //   361: getfield mBackStack : Ljava/util/ArrayList;
    //   364: invokevirtual size : ()I
    //   367: istore #6
    //   369: iload #6
    //   371: ifle -> 464
    //   374: aload_3
    //   375: aload_1
    //   376: invokevirtual print : (Ljava/lang/String;)V
    //   379: aload_3
    //   380: ldc_w 'Back Stack:'
    //   383: invokevirtual println : (Ljava/lang/String;)V
    //   386: iconst_0
    //   387: istore #5
    //   389: iload #5
    //   391: iload #6
    //   393: if_icmpge -> 464
    //   396: aload_0
    //   397: getfield mBackStack : Ljava/util/ArrayList;
    //   400: iload #5
    //   402: invokevirtual get : (I)Ljava/lang/Object;
    //   405: checkcast android/support/v4/app/BackStackRecord
    //   408: astore #8
    //   410: aload_3
    //   411: aload_1
    //   412: invokevirtual print : (Ljava/lang/String;)V
    //   415: aload_3
    //   416: ldc_w '  #'
    //   419: invokevirtual print : (Ljava/lang/String;)V
    //   422: aload_3
    //   423: iload #5
    //   425: invokevirtual print : (I)V
    //   428: aload_3
    //   429: ldc_w ': '
    //   432: invokevirtual print : (Ljava/lang/String;)V
    //   435: aload_3
    //   436: aload #8
    //   438: invokevirtual toString : ()Ljava/lang/String;
    //   441: invokevirtual println : (Ljava/lang/String;)V
    //   444: aload #8
    //   446: aload #7
    //   448: aload_2
    //   449: aload_3
    //   450: aload #4
    //   452: invokevirtual dump : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   455: iload #5
    //   457: iconst_1
    //   458: iadd
    //   459: istore #5
    //   461: goto -> 389
    //   464: aload_0
    //   465: monitorenter
    //   466: aload_0
    //   467: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   470: ifnull -> 561
    //   473: aload_0
    //   474: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   477: invokevirtual size : ()I
    //   480: istore #6
    //   482: iload #6
    //   484: ifle -> 561
    //   487: aload_3
    //   488: aload_1
    //   489: invokevirtual print : (Ljava/lang/String;)V
    //   492: aload_3
    //   493: ldc_w 'Back Stack Indices:'
    //   496: invokevirtual println : (Ljava/lang/String;)V
    //   499: iconst_0
    //   500: istore #5
    //   502: iload #5
    //   504: iload #6
    //   506: if_icmpge -> 561
    //   509: aload_0
    //   510: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   513: iload #5
    //   515: invokevirtual get : (I)Ljava/lang/Object;
    //   518: checkcast android/support/v4/app/BackStackRecord
    //   521: astore_2
    //   522: aload_3
    //   523: aload_1
    //   524: invokevirtual print : (Ljava/lang/String;)V
    //   527: aload_3
    //   528: ldc_w '  #'
    //   531: invokevirtual print : (Ljava/lang/String;)V
    //   534: aload_3
    //   535: iload #5
    //   537: invokevirtual print : (I)V
    //   540: aload_3
    //   541: ldc_w ': '
    //   544: invokevirtual print : (Ljava/lang/String;)V
    //   547: aload_3
    //   548: aload_2
    //   549: invokevirtual println : (Ljava/lang/Object;)V
    //   552: iload #5
    //   554: iconst_1
    //   555: iadd
    //   556: istore #5
    //   558: goto -> 502
    //   561: aload_0
    //   562: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   565: ifnull -> 604
    //   568: aload_0
    //   569: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   572: invokevirtual size : ()I
    //   575: ifle -> 604
    //   578: aload_3
    //   579: aload_1
    //   580: invokevirtual print : (Ljava/lang/String;)V
    //   583: aload_3
    //   584: ldc_w 'mAvailBackStackIndices: '
    //   587: invokevirtual print : (Ljava/lang/String;)V
    //   590: aload_3
    //   591: aload_0
    //   592: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   595: invokevirtual toArray : ()[Ljava/lang/Object;
    //   598: invokestatic toString : ([Ljava/lang/Object;)Ljava/lang/String;
    //   601: invokevirtual println : (Ljava/lang/String;)V
    //   604: aload_0
    //   605: monitorexit
    //   606: aload_0
    //   607: getfield mPendingActions : Ljava/util/ArrayList;
    //   610: ifnull -> 706
    //   613: aload_0
    //   614: getfield mPendingActions : Ljava/util/ArrayList;
    //   617: invokevirtual size : ()I
    //   620: istore #6
    //   622: iload #6
    //   624: ifle -> 706
    //   627: aload_3
    //   628: aload_1
    //   629: invokevirtual print : (Ljava/lang/String;)V
    //   632: aload_3
    //   633: ldc_w 'Pending Actions:'
    //   636: invokevirtual println : (Ljava/lang/String;)V
    //   639: iconst_0
    //   640: istore #5
    //   642: iload #5
    //   644: iload #6
    //   646: if_icmpge -> 706
    //   649: aload_0
    //   650: getfield mPendingActions : Ljava/util/ArrayList;
    //   653: iload #5
    //   655: invokevirtual get : (I)Ljava/lang/Object;
    //   658: checkcast android/support/v4/app/FragmentManagerImpl$OpGenerator
    //   661: astore_2
    //   662: aload_3
    //   663: aload_1
    //   664: invokevirtual print : (Ljava/lang/String;)V
    //   667: aload_3
    //   668: ldc_w '  #'
    //   671: invokevirtual print : (Ljava/lang/String;)V
    //   674: aload_3
    //   675: iload #5
    //   677: invokevirtual print : (I)V
    //   680: aload_3
    //   681: ldc_w ': '
    //   684: invokevirtual print : (Ljava/lang/String;)V
    //   687: aload_3
    //   688: aload_2
    //   689: invokevirtual println : (Ljava/lang/Object;)V
    //   692: iload #5
    //   694: iconst_1
    //   695: iadd
    //   696: istore #5
    //   698: goto -> 642
    //   701: astore_1
    //   702: aload_0
    //   703: monitorexit
    //   704: aload_1
    //   705: athrow
    //   706: aload_3
    //   707: aload_1
    //   708: invokevirtual print : (Ljava/lang/String;)V
    //   711: aload_3
    //   712: ldc_w 'FragmentManager misc state:'
    //   715: invokevirtual println : (Ljava/lang/String;)V
    //   718: aload_3
    //   719: aload_1
    //   720: invokevirtual print : (Ljava/lang/String;)V
    //   723: aload_3
    //   724: ldc_w '  mHost='
    //   727: invokevirtual print : (Ljava/lang/String;)V
    //   730: aload_3
    //   731: aload_0
    //   732: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   735: invokevirtual println : (Ljava/lang/Object;)V
    //   738: aload_3
    //   739: aload_1
    //   740: invokevirtual print : (Ljava/lang/String;)V
    //   743: aload_3
    //   744: ldc_w '  mContainer='
    //   747: invokevirtual print : (Ljava/lang/String;)V
    //   750: aload_3
    //   751: aload_0
    //   752: getfield mContainer : Landroid/support/v4/app/FragmentContainer;
    //   755: invokevirtual println : (Ljava/lang/Object;)V
    //   758: aload_0
    //   759: getfield mParent : Landroid/support/v4/app/Fragment;
    //   762: ifnull -> 785
    //   765: aload_3
    //   766: aload_1
    //   767: invokevirtual print : (Ljava/lang/String;)V
    //   770: aload_3
    //   771: ldc_w '  mParent='
    //   774: invokevirtual print : (Ljava/lang/String;)V
    //   777: aload_3
    //   778: aload_0
    //   779: getfield mParent : Landroid/support/v4/app/Fragment;
    //   782: invokevirtual println : (Ljava/lang/Object;)V
    //   785: aload_3
    //   786: aload_1
    //   787: invokevirtual print : (Ljava/lang/String;)V
    //   790: aload_3
    //   791: ldc_w '  mCurState='
    //   794: invokevirtual print : (Ljava/lang/String;)V
    //   797: aload_3
    //   798: aload_0
    //   799: getfield mCurState : I
    //   802: invokevirtual print : (I)V
    //   805: aload_3
    //   806: ldc_w ' mStateSaved='
    //   809: invokevirtual print : (Ljava/lang/String;)V
    //   812: aload_3
    //   813: aload_0
    //   814: getfield mStateSaved : Z
    //   817: invokevirtual print : (Z)V
    //   820: aload_3
    //   821: ldc_w ' mDestroyed='
    //   824: invokevirtual print : (Ljava/lang/String;)V
    //   827: aload_3
    //   828: aload_0
    //   829: getfield mDestroyed : Z
    //   832: invokevirtual println : (Z)V
    //   835: aload_0
    //   836: getfield mNeedMenuInvalidate : Z
    //   839: ifeq -> 862
    //   842: aload_3
    //   843: aload_1
    //   844: invokevirtual print : (Ljava/lang/String;)V
    //   847: aload_3
    //   848: ldc_w '  mNeedMenuInvalidate='
    //   851: invokevirtual print : (Ljava/lang/String;)V
    //   854: aload_3
    //   855: aload_0
    //   856: getfield mNeedMenuInvalidate : Z
    //   859: invokevirtual println : (Z)V
    //   862: aload_0
    //   863: getfield mNoTransactionsBecause : Ljava/lang/String;
    //   866: ifnull -> 889
    //   869: aload_3
    //   870: aload_1
    //   871: invokevirtual print : (Ljava/lang/String;)V
    //   874: aload_3
    //   875: ldc_w '  mNoTransactionsBecause='
    //   878: invokevirtual print : (Ljava/lang/String;)V
    //   881: aload_3
    //   882: aload_0
    //   883: getfield mNoTransactionsBecause : Ljava/lang/String;
    //   886: invokevirtual println : (Ljava/lang/String;)V
    //   889: aload_0
    //   890: getfield mAvailIndices : Ljava/util/ArrayList;
    //   893: ifnull -> 932
    //   896: aload_0
    //   897: getfield mAvailIndices : Ljava/util/ArrayList;
    //   900: invokevirtual size : ()I
    //   903: ifle -> 932
    //   906: aload_3
    //   907: aload_1
    //   908: invokevirtual print : (Ljava/lang/String;)V
    //   911: aload_3
    //   912: ldc_w '  mAvailIndices: '
    //   915: invokevirtual print : (Ljava/lang/String;)V
    //   918: aload_3
    //   919: aload_0
    //   920: getfield mAvailIndices : Ljava/util/ArrayList;
    //   923: invokevirtual toArray : ()[Ljava/lang/Object;
    //   926: invokestatic toString : ([Ljava/lang/Object;)Ljava/lang/String;
    //   929: invokevirtual println : (Ljava/lang/String;)V
    //   932: return
    // Exception table:
    //   from	to	target	type
    //   466	482	701	finally
    //   487	499	701	finally
    //   509	552	701	finally
    //   561	604	701	finally
    //   604	606	701	finally
    //   702	704	701	finally
  }
  
  public void enqueueAction(OpGenerator paramOpGenerator, boolean paramBoolean) {
    // Byte code:
    //   0: iload_2
    //   1: ifne -> 8
    //   4: aload_0
    //   5: invokespecial checkStateLoss : ()V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield mDestroyed : Z
    //   14: ifne -> 24
    //   17: aload_0
    //   18: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   21: ifnonnull -> 40
    //   24: new java/lang/IllegalStateException
    //   27: dup
    //   28: ldc_w 'Activity has been destroyed'
    //   31: invokespecial <init> : (Ljava/lang/String;)V
    //   34: athrow
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    //   40: aload_0
    //   41: getfield mPendingActions : Ljava/util/ArrayList;
    //   44: ifnonnull -> 58
    //   47: aload_0
    //   48: new java/util/ArrayList
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: putfield mPendingActions : Ljava/util/ArrayList;
    //   58: aload_0
    //   59: getfield mPendingActions : Ljava/util/ArrayList;
    //   62: aload_1
    //   63: invokevirtual add : (Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_0
    //   68: invokespecial scheduleCommit : ()V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    // Exception table:
    //   from	to	target	type
    //   10	24	35	finally
    //   24	35	35	finally
    //   36	38	35	finally
    //   40	58	35	finally
    //   58	73	35	finally
  }
  
  public boolean execPendingActions() {
    ensureExecReady(true);
    boolean bool = false;
    while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
      this.mExecutingActions = true;
      try {
        optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
      } finally {
        cleanupExec();
      } 
    } 
    doPendingDeferredStart();
    return bool;
  }
  
  public void execSingleAction(OpGenerator paramOpGenerator, boolean paramBoolean) {
    ensureExecReady(paramBoolean);
    if (paramOpGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
      this.mExecutingActions = true;
      try {
        optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
        return;
      } finally {
        cleanupExec();
      } 
    } 
    doPendingDeferredStart();
  }
  
  public boolean executePendingTransactions() {
    boolean bool = execPendingActions();
    forcePostponedTransactions();
    return bool;
  }
  
  public Fragment findFragmentById(int paramInt) {
    if (this.mAdded != null) {
      int i = this.mAdded.size() - 1;
      while (i >= 0) {
        Fragment fragment = this.mAdded.get(i);
        if (fragment == null || fragment.mFragmentId != paramInt) {
          i--;
          continue;
        } 
        return fragment;
      } 
    } 
    if (this.mActive != null)
      for (int i = this.mActive.size() - 1; i >= 0; i--) {
        Fragment fragment = this.mActive.get(i);
        if (fragment != null) {
          Fragment fragment1 = fragment;
          if (fragment.mFragmentId != paramInt)
            continue; 
          return fragment1;
        } 
        continue;
      }  
    return null;
  }
  
  public Fragment findFragmentByTag(String paramString) {
    if (this.mAdded != null && paramString != null) {
      int i = this.mAdded.size() - 1;
      while (i >= 0) {
        Fragment fragment = this.mAdded.get(i);
        if (fragment == null || !paramString.equals(fragment.mTag)) {
          i--;
          continue;
        } 
        return fragment;
      } 
    } 
    if (this.mActive != null && paramString != null)
      for (int i = this.mActive.size() - 1; i >= 0; i--) {
        Fragment fragment = this.mActive.get(i);
        if (fragment != null) {
          Fragment fragment1 = fragment;
          if (!paramString.equals(fragment.mTag))
            continue; 
          return fragment1;
        } 
        continue;
      }  
    return null;
  }
  
  public Fragment findFragmentByWho(String paramString) {
    if (this.mActive != null && paramString != null)
      for (int i = this.mActive.size() - 1; i >= 0; i--) {
        Fragment fragment = this.mActive.get(i);
        if (fragment != null) {
          fragment = fragment.findFragmentByWho(paramString);
          if (fragment != null)
            return fragment; 
        } 
      }  
    return null;
  }
  
  public void freeBackStackIndex(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   6: iload_1
    //   7: aconst_null
    //   8: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_0
    //   13: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   16: ifnonnull -> 30
    //   19: aload_0
    //   20: new java/util/ArrayList
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: putfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   30: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   33: ifeq -> 62
    //   36: ldc 'FragmentManager'
    //   38: new java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial <init> : ()V
    //   45: ldc_w 'Freeing back stack index '
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_1
    //   52: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   55: invokevirtual toString : ()Ljava/lang/String;
    //   58: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   61: pop
    //   62: aload_0
    //   63: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   66: iload_1
    //   67: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   70: invokevirtual add : (Ljava/lang/Object;)Z
    //   73: pop
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	77	finally
    //   30	62	77	finally
    //   62	76	77	finally
    //   78	80	77	finally
  }
  
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt) {
    return this.mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount() {
    return (this.mBackStack != null) ? this.mBackStack.size() : 0;
  }
  
  public Fragment getFragment(Bundle paramBundle, String paramString) {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1)
      return null; 
    if (i >= this.mActive.size())
      throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i)); 
    Fragment fragment2 = this.mActive.get(i);
    Fragment fragment1 = fragment2;
    if (fragment2 == null) {
      throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
      return fragment2;
    } 
    return fragment1;
  }
  
  public List<Fragment> getFragments() {
    return this.mActive;
  }
  
  LayoutInflaterFactory getLayoutInflaterFactory() {
    return this;
  }
  
  public void hideFragment(Fragment paramFragment) {
    boolean bool = true;
    if (DEBUG)
      Log.v("FragmentManager", "hide: " + paramFragment); 
    if (!paramFragment.mHidden) {
      paramFragment.mHidden = true;
      if (paramFragment.mHiddenChanged)
        bool = false; 
      paramFragment.mHiddenChanged = bool;
    } 
  }
  
  public boolean isDestroyed() {
    return this.mDestroyed;
  }
  
  boolean isStateAtLeast(int paramInt) {
    return (this.mCurState >= paramInt);
  }
  
  Animation loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2) {
    Animation animation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, paramFragment.getNextAnim());
    if (animation != null)
      return animation; 
    if (paramFragment.getNextAnim() != 0) {
      Animation animation1 = AnimationUtils.loadAnimation(this.mHost.getContext(), paramFragment.getNextAnim());
      if (animation1 != null)
        return animation1; 
    } 
    if (paramInt1 == 0)
      return null; 
    paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
    if (paramInt1 < 0)
      return null; 
    switch (paramInt1) {
      default:
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = paramInt2;
          if (this.mHost.onHasWindowAnimations())
            paramInt1 = this.mHost.onGetWindowAnimations(); 
        } 
        return (Animation)((paramInt1 == 0) ? null : null);
      case 1:
        return makeOpenCloseAnimation(this.mHost.getContext(), 1.125F, 1.0F, 0.0F, 1.0F);
      case 2:
        return makeOpenCloseAnimation(this.mHost.getContext(), 1.0F, 0.975F, 1.0F, 0.0F);
      case 3:
        return makeOpenCloseAnimation(this.mHost.getContext(), 0.975F, 1.0F, 0.0F, 1.0F);
      case 4:
        return makeOpenCloseAnimation(this.mHost.getContext(), 1.0F, 1.075F, 1.0F, 0.0F);
      case 5:
        return makeFadeAnimation(this.mHost.getContext(), 0.0F, 1.0F);
      case 6:
        break;
    } 
    return makeFadeAnimation(this.mHost.getContext(), 1.0F, 0.0F);
  }
  
  void makeActive(Fragment paramFragment) {
    if (paramFragment.mIndex < 0) {
      if (this.mAvailIndices == null || this.mAvailIndices.size() <= 0) {
        if (this.mActive == null)
          this.mActive = new ArrayList<Fragment>(); 
        paramFragment.setIndex(this.mActive.size(), this.mParent);
        this.mActive.add(paramFragment);
      } else {
        paramFragment.setIndex(((Integer)this.mAvailIndices.remove(this.mAvailIndices.size() - 1)).intValue(), this.mParent);
        this.mActive.set(paramFragment.mIndex, paramFragment);
      } 
      if (DEBUG) {
        Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
        return;
      } 
    } 
  }
  
  void makeInactive(Fragment paramFragment) {
    if (paramFragment.mIndex < 0)
      return; 
    if (DEBUG)
      Log.v("FragmentManager", "Freeing fragment index " + paramFragment); 
    this.mActive.set(paramFragment.mIndex, null);
    if (this.mAvailIndices == null)
      this.mAvailIndices = new ArrayList<Integer>(); 
    this.mAvailIndices.add(Integer.valueOf(paramFragment.mIndex));
    this.mHost.inactivateFragment(paramFragment.mWho);
    paramFragment.initState();
  }
  
  void moveFragmentToExpectedState(Fragment paramFragment) {
    if (paramFragment != null) {
      int j = this.mCurState;
      int i = j;
      if (paramFragment.mRemoving)
        if (paramFragment.isInBackStack()) {
          i = Math.min(j, 1);
        } else {
          i = Math.min(j, 0);
        }  
      moveToState(paramFragment, i, paramFragment.getNextTransition(), paramFragment.getNextTransitionStyle(), false);
      if (paramFragment.mView != null) {
        Fragment fragment = findFragmentUnder(paramFragment);
        if (fragment != null) {
          View view = fragment.mView;
          ViewGroup viewGroup = paramFragment.mContainer;
          i = viewGroup.indexOfChild(view);
          j = viewGroup.indexOfChild(paramFragment.mView);
          if (j < i) {
            viewGroup.removeViewAt(j);
            viewGroup.addView(paramFragment.mView, i);
          } 
        } 
        if (paramFragment.mIsNewlyAdded && paramFragment.mContainer != null) {
          if (Build.VERSION.SDK_INT < 11) {
            paramFragment.mView.setVisibility(0);
          } else if (paramFragment.mPostponedAlpha > 0.0F) {
            paramFragment.mView.setAlpha(paramFragment.mPostponedAlpha);
          } 
          paramFragment.mPostponedAlpha = 0.0F;
          paramFragment.mIsNewlyAdded = false;
          Animation animation = loadAnimation(paramFragment, paramFragment.getNextTransition(), true, paramFragment.getNextTransitionStyle());
          if (animation != null) {
            setHWLayerAnimListenerIfAlpha(paramFragment.mView, animation);
            paramFragment.mView.startAnimation(animation);
          } 
        } 
      } 
      if (paramFragment.mHiddenChanged) {
        completeShowHideFragment(paramFragment);
        return;
      } 
    } 
  }
  
  void moveToState(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   4: ifnonnull -> 22
    //   7: iload_1
    //   8: ifeq -> 22
    //   11: new java/lang/IllegalStateException
    //   14: dup
    //   15: ldc_w 'No activity'
    //   18: invokespecial <init> : (Ljava/lang/String;)V
    //   21: athrow
    //   22: iload_2
    //   23: ifne -> 35
    //   26: iload_1
    //   27: aload_0
    //   28: getfield mCurState : I
    //   31: if_icmpne -> 35
    //   34: return
    //   35: aload_0
    //   36: iload_1
    //   37: putfield mCurState : I
    //   40: aload_0
    //   41: getfield mActive : Ljava/util/ArrayList;
    //   44: ifnull -> 34
    //   47: iconst_0
    //   48: istore_1
    //   49: iconst_0
    //   50: istore_3
    //   51: aload_0
    //   52: getfield mAdded : Ljava/util/ArrayList;
    //   55: ifnull -> 131
    //   58: aload_0
    //   59: getfield mAdded : Ljava/util/ArrayList;
    //   62: invokevirtual size : ()I
    //   65: istore #5
    //   67: iconst_0
    //   68: istore #4
    //   70: iload_3
    //   71: istore_1
    //   72: iload #4
    //   74: iload #5
    //   76: if_icmpge -> 131
    //   79: aload_0
    //   80: getfield mAdded : Ljava/util/ArrayList;
    //   83: iload #4
    //   85: invokevirtual get : (I)Ljava/lang/Object;
    //   88: checkcast android/support/v4/app/Fragment
    //   91: astore #6
    //   93: aload_0
    //   94: aload #6
    //   96: invokevirtual moveFragmentToExpectedState : (Landroid/support/v4/app/Fragment;)V
    //   99: iload_3
    //   100: istore_1
    //   101: aload #6
    //   103: getfield mLoaderManager : Landroid/support/v4/app/LoaderManagerImpl;
    //   106: ifnull -> 120
    //   109: iload_3
    //   110: aload #6
    //   112: getfield mLoaderManager : Landroid/support/v4/app/LoaderManagerImpl;
    //   115: invokevirtual hasRunningLoaders : ()Z
    //   118: ior
    //   119: istore_1
    //   120: iload #4
    //   122: iconst_1
    //   123: iadd
    //   124: istore #4
    //   126: iload_1
    //   127: istore_3
    //   128: goto -> 70
    //   131: aload_0
    //   132: getfield mActive : Ljava/util/ArrayList;
    //   135: invokevirtual size : ()I
    //   138: istore #5
    //   140: iconst_0
    //   141: istore #4
    //   143: iload_1
    //   144: istore_3
    //   145: iload #4
    //   147: istore_1
    //   148: iload_1
    //   149: iload #5
    //   151: if_icmpge -> 244
    //   154: aload_0
    //   155: getfield mActive : Ljava/util/ArrayList;
    //   158: iload_1
    //   159: invokevirtual get : (I)Ljava/lang/Object;
    //   162: checkcast android/support/v4/app/Fragment
    //   165: astore #6
    //   167: iload_3
    //   168: istore #4
    //   170: aload #6
    //   172: ifnull -> 234
    //   175: aload #6
    //   177: getfield mRemoving : Z
    //   180: ifne -> 194
    //   183: iload_3
    //   184: istore #4
    //   186: aload #6
    //   188: getfield mDetached : Z
    //   191: ifeq -> 234
    //   194: iload_3
    //   195: istore #4
    //   197: aload #6
    //   199: getfield mIsNewlyAdded : Z
    //   202: ifne -> 234
    //   205: aload_0
    //   206: aload #6
    //   208: invokevirtual moveFragmentToExpectedState : (Landroid/support/v4/app/Fragment;)V
    //   211: iload_3
    //   212: istore #4
    //   214: aload #6
    //   216: getfield mLoaderManager : Landroid/support/v4/app/LoaderManagerImpl;
    //   219: ifnull -> 234
    //   222: iload_3
    //   223: aload #6
    //   225: getfield mLoaderManager : Landroid/support/v4/app/LoaderManagerImpl;
    //   228: invokevirtual hasRunningLoaders : ()Z
    //   231: ior
    //   232: istore #4
    //   234: iload_1
    //   235: iconst_1
    //   236: iadd
    //   237: istore_1
    //   238: iload #4
    //   240: istore_3
    //   241: goto -> 148
    //   244: iload_3
    //   245: ifne -> 252
    //   248: aload_0
    //   249: invokevirtual startPendingDeferredFragments : ()V
    //   252: aload_0
    //   253: getfield mNeedMenuInvalidate : Z
    //   256: ifeq -> 34
    //   259: aload_0
    //   260: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   263: ifnull -> 34
    //   266: aload_0
    //   267: getfield mCurState : I
    //   270: iconst_5
    //   271: if_icmpne -> 34
    //   274: aload_0
    //   275: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   278: invokevirtual onSupportInvalidateOptionsMenu : ()V
    //   281: aload_0
    //   282: iconst_0
    //   283: putfield mNeedMenuInvalidate : Z
    //   286: return
  }
  
  void moveToState(Fragment paramFragment) {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: getfield mAdded : Z
    //   4: ifeq -> 17
    //   7: iload_2
    //   8: istore #6
    //   10: aload_1
    //   11: getfield mDetached : Z
    //   14: ifeq -> 28
    //   17: iload_2
    //   18: istore #6
    //   20: iload_2
    //   21: iconst_1
    //   22: if_icmple -> 28
    //   25: iconst_1
    //   26: istore #6
    //   28: iload #6
    //   30: istore #7
    //   32: aload_1
    //   33: getfield mRemoving : Z
    //   36: ifeq -> 58
    //   39: iload #6
    //   41: istore #7
    //   43: iload #6
    //   45: aload_1
    //   46: getfield mState : I
    //   49: if_icmple -> 58
    //   52: aload_1
    //   53: getfield mState : I
    //   56: istore #7
    //   58: iload #7
    //   60: istore_2
    //   61: aload_1
    //   62: getfield mDeferStart : Z
    //   65: ifeq -> 90
    //   68: iload #7
    //   70: istore_2
    //   71: aload_1
    //   72: getfield mState : I
    //   75: iconst_4
    //   76: if_icmpge -> 90
    //   79: iload #7
    //   81: istore_2
    //   82: iload #7
    //   84: iconst_3
    //   85: if_icmple -> 90
    //   88: iconst_3
    //   89: istore_2
    //   90: aload_1
    //   91: getfield mState : I
    //   94: iload_2
    //   95: if_icmpge -> 1324
    //   98: aload_1
    //   99: getfield mFromLayout : Z
    //   102: ifeq -> 113
    //   105: aload_1
    //   106: getfield mInLayout : Z
    //   109: ifne -> 113
    //   112: return
    //   113: aload_1
    //   114: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   117: ifnull -> 137
    //   120: aload_1
    //   121: aconst_null
    //   122: invokevirtual setAnimatingAway : (Landroid/view/View;)V
    //   125: aload_0
    //   126: aload_1
    //   127: aload_1
    //   128: invokevirtual getStateAfterAnimating : ()I
    //   131: iconst_0
    //   132: iconst_0
    //   133: iconst_1
    //   134: invokevirtual moveToState : (Landroid/support/v4/app/Fragment;IIIZ)V
    //   137: iload_2
    //   138: istore_3
    //   139: iload_2
    //   140: istore #6
    //   142: iload_2
    //   143: istore #7
    //   145: iload_2
    //   146: istore #4
    //   148: aload_1
    //   149: getfield mState : I
    //   152: tableswitch default -> 188, 0 -> 263, 1 -> 695, 2 -> 1090, 3 -> 1109, 4 -> 1165
    //   188: iload_2
    //   189: istore #6
    //   191: aload_1
    //   192: getfield mState : I
    //   195: iload #6
    //   197: if_icmpeq -> 112
    //   200: ldc 'FragmentManager'
    //   202: new java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial <init> : ()V
    //   209: ldc_w 'moveToState: Fragment state for '
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   219: ldc_w ' not updated inline; '
    //   222: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc_w 'expected state '
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload #6
    //   233: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   236: ldc_w ' found '
    //   239: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_1
    //   243: getfield mState : I
    //   246: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   249: invokevirtual toString : ()Ljava/lang/String;
    //   252: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   255: pop
    //   256: aload_1
    //   257: iload #6
    //   259: putfield mState : I
    //   262: return
    //   263: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   266: ifeq -> 295
    //   269: ldc 'FragmentManager'
    //   271: new java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial <init> : ()V
    //   278: ldc_w 'moveto CREATED: '
    //   281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_1
    //   285: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   288: invokevirtual toString : ()Ljava/lang/String;
    //   291: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   294: pop
    //   295: iload_2
    //   296: istore #4
    //   298: aload_1
    //   299: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   302: ifnull -> 410
    //   305: aload_1
    //   306: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   309: aload_0
    //   310: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   313: invokevirtual getContext : ()Landroid/content/Context;
    //   316: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   319: invokevirtual setClassLoader : (Ljava/lang/ClassLoader;)V
    //   322: aload_1
    //   323: aload_1
    //   324: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   327: ldc 'android:view_state'
    //   329: invokevirtual getSparseParcelableArray : (Ljava/lang/String;)Landroid/util/SparseArray;
    //   332: putfield mSavedViewState : Landroid/util/SparseArray;
    //   335: aload_1
    //   336: aload_0
    //   337: aload_1
    //   338: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   341: ldc 'android:target_state'
    //   343: invokevirtual getFragment : (Landroid/os/Bundle;Ljava/lang/String;)Landroid/support/v4/app/Fragment;
    //   346: putfield mTarget : Landroid/support/v4/app/Fragment;
    //   349: aload_1
    //   350: getfield mTarget : Landroid/support/v4/app/Fragment;
    //   353: ifnull -> 370
    //   356: aload_1
    //   357: aload_1
    //   358: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   361: ldc 'android:target_req_state'
    //   363: iconst_0
    //   364: invokevirtual getInt : (Ljava/lang/String;I)I
    //   367: putfield mTargetRequestCode : I
    //   370: aload_1
    //   371: aload_1
    //   372: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   375: ldc 'android:user_visible_hint'
    //   377: iconst_1
    //   378: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
    //   381: putfield mUserVisibleHint : Z
    //   384: iload_2
    //   385: istore #4
    //   387: aload_1
    //   388: getfield mUserVisibleHint : Z
    //   391: ifne -> 410
    //   394: aload_1
    //   395: iconst_1
    //   396: putfield mDeferStart : Z
    //   399: iload_2
    //   400: istore #4
    //   402: iload_2
    //   403: iconst_3
    //   404: if_icmple -> 410
    //   407: iconst_3
    //   408: istore #4
    //   410: aload_1
    //   411: aload_0
    //   412: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   415: putfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   418: aload_1
    //   419: aload_0
    //   420: getfield mParent : Landroid/support/v4/app/Fragment;
    //   423: putfield mParentFragment : Landroid/support/v4/app/Fragment;
    //   426: aload_0
    //   427: getfield mParent : Landroid/support/v4/app/Fragment;
    //   430: ifnull -> 518
    //   433: aload_0
    //   434: getfield mParent : Landroid/support/v4/app/Fragment;
    //   437: getfield mChildFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   440: astore #8
    //   442: aload_1
    //   443: aload #8
    //   445: putfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   448: aload_0
    //   449: aload_1
    //   450: aload_0
    //   451: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   454: invokevirtual getContext : ()Landroid/content/Context;
    //   457: iconst_0
    //   458: invokevirtual dispatchOnFragmentPreAttached : (Landroid/support/v4/app/Fragment;Landroid/content/Context;Z)V
    //   461: aload_1
    //   462: iconst_0
    //   463: putfield mCalled : Z
    //   466: aload_1
    //   467: aload_0
    //   468: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   471: invokevirtual getContext : ()Landroid/content/Context;
    //   474: invokevirtual onAttach : (Landroid/content/Context;)V
    //   477: aload_1
    //   478: getfield mCalled : Z
    //   481: ifne -> 530
    //   484: new android/support/v4/app/SuperNotCalledException
    //   487: dup
    //   488: new java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial <init> : ()V
    //   495: ldc_w 'Fragment '
    //   498: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload_1
    //   502: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   505: ldc_w ' did not call through to super.onAttach()'
    //   508: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual toString : ()Ljava/lang/String;
    //   514: invokespecial <init> : (Ljava/lang/String;)V
    //   517: athrow
    //   518: aload_0
    //   519: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   522: invokevirtual getFragmentManagerImpl : ()Landroid/support/v4/app/FragmentManagerImpl;
    //   525: astore #8
    //   527: goto -> 442
    //   530: aload_1
    //   531: getfield mParentFragment : Landroid/support/v4/app/Fragment;
    //   534: ifnonnull -> 1234
    //   537: aload_0
    //   538: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   541: aload_1
    //   542: invokevirtual onAttachFragment : (Landroid/support/v4/app/Fragment;)V
    //   545: aload_0
    //   546: aload_1
    //   547: aload_0
    //   548: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   551: invokevirtual getContext : ()Landroid/content/Context;
    //   554: iconst_0
    //   555: invokevirtual dispatchOnFragmentAttached : (Landroid/support/v4/app/Fragment;Landroid/content/Context;Z)V
    //   558: aload_1
    //   559: getfield mRetaining : Z
    //   562: ifne -> 1245
    //   565: aload_1
    //   566: aload_1
    //   567: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   570: invokevirtual performCreate : (Landroid/os/Bundle;)V
    //   573: aload_0
    //   574: aload_1
    //   575: aload_1
    //   576: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   579: iconst_0
    //   580: invokevirtual dispatchOnFragmentCreated : (Landroid/support/v4/app/Fragment;Landroid/os/Bundle;Z)V
    //   583: aload_1
    //   584: iconst_0
    //   585: putfield mRetaining : Z
    //   588: iload #4
    //   590: istore_3
    //   591: aload_1
    //   592: getfield mFromLayout : Z
    //   595: ifeq -> 695
    //   598: aload_1
    //   599: aload_1
    //   600: aload_1
    //   601: aload_1
    //   602: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   605: invokevirtual getLayoutInflater : (Landroid/os/Bundle;)Landroid/view/LayoutInflater;
    //   608: aconst_null
    //   609: aload_1
    //   610: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   613: invokevirtual performCreateView : (Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    //   616: putfield mView : Landroid/view/View;
    //   619: aload_1
    //   620: getfield mView : Landroid/view/View;
    //   623: ifnull -> 1275
    //   626: aload_1
    //   627: aload_1
    //   628: getfield mView : Landroid/view/View;
    //   631: putfield mInnerView : Landroid/view/View;
    //   634: getstatic android/os/Build$VERSION.SDK_INT : I
    //   637: bipush #11
    //   639: if_icmplt -> 1261
    //   642: aload_1
    //   643: getfield mView : Landroid/view/View;
    //   646: iconst_0
    //   647: invokestatic setSaveFromParentEnabled : (Landroid/view/View;Z)V
    //   650: aload_1
    //   651: getfield mHidden : Z
    //   654: ifeq -> 666
    //   657: aload_1
    //   658: getfield mView : Landroid/view/View;
    //   661: bipush #8
    //   663: invokevirtual setVisibility : (I)V
    //   666: aload_1
    //   667: aload_1
    //   668: getfield mView : Landroid/view/View;
    //   671: aload_1
    //   672: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   675: invokevirtual onViewCreated : (Landroid/view/View;Landroid/os/Bundle;)V
    //   678: aload_0
    //   679: aload_1
    //   680: aload_1
    //   681: getfield mView : Landroid/view/View;
    //   684: aload_1
    //   685: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   688: iconst_0
    //   689: invokevirtual dispatchOnFragmentViewCreated : (Landroid/support/v4/app/Fragment;Landroid/view/View;Landroid/os/Bundle;Z)V
    //   692: iload #4
    //   694: istore_3
    //   695: iload_3
    //   696: istore #6
    //   698: iload_3
    //   699: iconst_1
    //   700: if_icmple -> 1090
    //   703: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   706: ifeq -> 735
    //   709: ldc 'FragmentManager'
    //   711: new java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial <init> : ()V
    //   718: ldc_w 'moveto ACTIVITY_CREATED: '
    //   721: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload_1
    //   725: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   728: invokevirtual toString : ()Ljava/lang/String;
    //   731: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   734: pop
    //   735: aload_1
    //   736: getfield mFromLayout : Z
    //   739: ifne -> 1049
    //   742: aconst_null
    //   743: astore #8
    //   745: aload_1
    //   746: getfield mContainerId : I
    //   749: ifeq -> 908
    //   752: aload_1
    //   753: getfield mContainerId : I
    //   756: iconst_m1
    //   757: if_icmpne -> 797
    //   760: aload_0
    //   761: new java/lang/IllegalArgumentException
    //   764: dup
    //   765: new java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial <init> : ()V
    //   772: ldc_w 'Cannot create fragment '
    //   775: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: aload_1
    //   779: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   782: ldc_w ' for a container view with no id'
    //   785: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: invokevirtual toString : ()Ljava/lang/String;
    //   791: invokespecial <init> : (Ljava/lang/String;)V
    //   794: invokespecial throwException : (Ljava/lang/RuntimeException;)V
    //   797: aload_0
    //   798: getfield mContainer : Landroid/support/v4/app/FragmentContainer;
    //   801: aload_1
    //   802: getfield mContainerId : I
    //   805: invokevirtual onFindViewById : (I)Landroid/view/View;
    //   808: checkcast android/view/ViewGroup
    //   811: astore #9
    //   813: aload #9
    //   815: astore #8
    //   817: aload #9
    //   819: ifnonnull -> 908
    //   822: aload #9
    //   824: astore #8
    //   826: aload_1
    //   827: getfield mRestored : Z
    //   830: ifne -> 908
    //   833: aload_1
    //   834: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   837: aload_1
    //   838: getfield mContainerId : I
    //   841: invokevirtual getResourceName : (I)Ljava/lang/String;
    //   844: astore #8
    //   846: aload_0
    //   847: new java/lang/IllegalArgumentException
    //   850: dup
    //   851: new java/lang/StringBuilder
    //   854: dup
    //   855: invokespecial <init> : ()V
    //   858: ldc_w 'No view found for id 0x'
    //   861: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: aload_1
    //   865: getfield mContainerId : I
    //   868: invokestatic toHexString : (I)Ljava/lang/String;
    //   871: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: ldc_w ' ('
    //   877: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: aload #8
    //   882: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: ldc_w ') for fragment '
    //   888: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: aload_1
    //   892: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   895: invokevirtual toString : ()Ljava/lang/String;
    //   898: invokespecial <init> : (Ljava/lang/String;)V
    //   901: invokespecial throwException : (Ljava/lang/RuntimeException;)V
    //   904: aload #9
    //   906: astore #8
    //   908: aload_1
    //   909: aload #8
    //   911: putfield mContainer : Landroid/view/ViewGroup;
    //   914: aload_1
    //   915: aload_1
    //   916: aload_1
    //   917: aload_1
    //   918: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   921: invokevirtual getLayoutInflater : (Landroid/os/Bundle;)Landroid/view/LayoutInflater;
    //   924: aload #8
    //   926: aload_1
    //   927: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   930: invokevirtual performCreateView : (Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    //   933: putfield mView : Landroid/view/View;
    //   936: aload_1
    //   937: getfield mView : Landroid/view/View;
    //   940: ifnull -> 1316
    //   943: aload_1
    //   944: aload_1
    //   945: getfield mView : Landroid/view/View;
    //   948: putfield mInnerView : Landroid/view/View;
    //   951: getstatic android/os/Build$VERSION.SDK_INT : I
    //   954: bipush #11
    //   956: if_icmplt -> 1296
    //   959: aload_1
    //   960: getfield mView : Landroid/view/View;
    //   963: iconst_0
    //   964: invokestatic setSaveFromParentEnabled : (Landroid/view/View;Z)V
    //   967: aload #8
    //   969: ifnull -> 981
    //   972: aload #8
    //   974: aload_1
    //   975: getfield mView : Landroid/view/View;
    //   978: invokevirtual addView : (Landroid/view/View;)V
    //   981: aload_1
    //   982: getfield mHidden : Z
    //   985: ifeq -> 997
    //   988: aload_1
    //   989: getfield mView : Landroid/view/View;
    //   992: bipush #8
    //   994: invokevirtual setVisibility : (I)V
    //   997: aload_1
    //   998: aload_1
    //   999: getfield mView : Landroid/view/View;
    //   1002: aload_1
    //   1003: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1006: invokevirtual onViewCreated : (Landroid/view/View;Landroid/os/Bundle;)V
    //   1009: aload_0
    //   1010: aload_1
    //   1011: aload_1
    //   1012: getfield mView : Landroid/view/View;
    //   1015: aload_1
    //   1016: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1019: iconst_0
    //   1020: invokevirtual dispatchOnFragmentViewCreated : (Landroid/support/v4/app/Fragment;Landroid/view/View;Landroid/os/Bundle;Z)V
    //   1023: aload_1
    //   1024: getfield mView : Landroid/view/View;
    //   1027: invokevirtual getVisibility : ()I
    //   1030: ifne -> 1310
    //   1033: aload_1
    //   1034: getfield mContainer : Landroid/view/ViewGroup;
    //   1037: ifnull -> 1310
    //   1040: iconst_1
    //   1041: istore #5
    //   1043: aload_1
    //   1044: iload #5
    //   1046: putfield mIsNewlyAdded : Z
    //   1049: aload_1
    //   1050: aload_1
    //   1051: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1054: invokevirtual performActivityCreated : (Landroid/os/Bundle;)V
    //   1057: aload_0
    //   1058: aload_1
    //   1059: aload_1
    //   1060: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1063: iconst_0
    //   1064: invokevirtual dispatchOnFragmentActivityCreated : (Landroid/support/v4/app/Fragment;Landroid/os/Bundle;Z)V
    //   1067: aload_1
    //   1068: getfield mView : Landroid/view/View;
    //   1071: ifnull -> 1082
    //   1074: aload_1
    //   1075: aload_1
    //   1076: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1079: invokevirtual restoreViewState : (Landroid/os/Bundle;)V
    //   1082: aload_1
    //   1083: aconst_null
    //   1084: putfield mSavedFragmentState : Landroid/os/Bundle;
    //   1087: iload_3
    //   1088: istore #6
    //   1090: iload #6
    //   1092: istore #7
    //   1094: iload #6
    //   1096: iconst_2
    //   1097: if_icmple -> 1109
    //   1100: aload_1
    //   1101: iconst_3
    //   1102: putfield mState : I
    //   1105: iload #6
    //   1107: istore #7
    //   1109: iload #7
    //   1111: istore #4
    //   1113: iload #7
    //   1115: iconst_3
    //   1116: if_icmple -> 1165
    //   1119: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1122: ifeq -> 1151
    //   1125: ldc 'FragmentManager'
    //   1127: new java/lang/StringBuilder
    //   1130: dup
    //   1131: invokespecial <init> : ()V
    //   1134: ldc_w 'moveto STARTED: '
    //   1137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: aload_1
    //   1141: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1144: invokevirtual toString : ()Ljava/lang/String;
    //   1147: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1150: pop
    //   1151: aload_1
    //   1152: invokevirtual performStart : ()V
    //   1155: aload_0
    //   1156: aload_1
    //   1157: iconst_0
    //   1158: invokevirtual dispatchOnFragmentStarted : (Landroid/support/v4/app/Fragment;Z)V
    //   1161: iload #7
    //   1163: istore #4
    //   1165: iload #4
    //   1167: istore #6
    //   1169: iload #4
    //   1171: iconst_4
    //   1172: if_icmple -> 191
    //   1175: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1178: ifeq -> 1207
    //   1181: ldc 'FragmentManager'
    //   1183: new java/lang/StringBuilder
    //   1186: dup
    //   1187: invokespecial <init> : ()V
    //   1190: ldc_w 'moveto RESUMED: '
    //   1193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: aload_1
    //   1197: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1200: invokevirtual toString : ()Ljava/lang/String;
    //   1203: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1206: pop
    //   1207: aload_1
    //   1208: invokevirtual performResume : ()V
    //   1211: aload_0
    //   1212: aload_1
    //   1213: iconst_0
    //   1214: invokevirtual dispatchOnFragmentResumed : (Landroid/support/v4/app/Fragment;Z)V
    //   1217: aload_1
    //   1218: aconst_null
    //   1219: putfield mSavedFragmentState : Landroid/os/Bundle;
    //   1222: aload_1
    //   1223: aconst_null
    //   1224: putfield mSavedViewState : Landroid/util/SparseArray;
    //   1227: iload #4
    //   1229: istore #6
    //   1231: goto -> 191
    //   1234: aload_1
    //   1235: getfield mParentFragment : Landroid/support/v4/app/Fragment;
    //   1238: aload_1
    //   1239: invokevirtual onAttachFragment : (Landroid/support/v4/app/Fragment;)V
    //   1242: goto -> 545
    //   1245: aload_1
    //   1246: aload_1
    //   1247: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1250: invokevirtual restoreChildFragmentState : (Landroid/os/Bundle;)V
    //   1253: aload_1
    //   1254: iconst_1
    //   1255: putfield mState : I
    //   1258: goto -> 583
    //   1261: aload_1
    //   1262: aload_1
    //   1263: getfield mView : Landroid/view/View;
    //   1266: invokestatic wrap : (Landroid/view/View;)Landroid/view/ViewGroup;
    //   1269: putfield mView : Landroid/view/View;
    //   1272: goto -> 650
    //   1275: aload_1
    //   1276: aconst_null
    //   1277: putfield mInnerView : Landroid/view/View;
    //   1280: iload #4
    //   1282: istore_3
    //   1283: goto -> 695
    //   1286: astore #8
    //   1288: ldc_w 'unknown'
    //   1291: astore #8
    //   1293: goto -> 846
    //   1296: aload_1
    //   1297: aload_1
    //   1298: getfield mView : Landroid/view/View;
    //   1301: invokestatic wrap : (Landroid/view/View;)Landroid/view/ViewGroup;
    //   1304: putfield mView : Landroid/view/View;
    //   1307: goto -> 967
    //   1310: iconst_0
    //   1311: istore #5
    //   1313: goto -> 1043
    //   1316: aload_1
    //   1317: aconst_null
    //   1318: putfield mInnerView : Landroid/view/View;
    //   1321: goto -> 1049
    //   1324: iload_2
    //   1325: istore #6
    //   1327: aload_1
    //   1328: getfield mState : I
    //   1331: iload_2
    //   1332: if_icmple -> 191
    //   1335: aload_1
    //   1336: getfield mState : I
    //   1339: tableswitch default -> 1372, 1 -> 1378, 2 -> 1569, 3 -> 1528, 4 -> 1481, 5 -> 1434
    //   1372: iload_2
    //   1373: istore #6
    //   1375: goto -> 191
    //   1378: iload_2
    //   1379: istore #6
    //   1381: iload_2
    //   1382: iconst_1
    //   1383: if_icmpge -> 191
    //   1386: aload_0
    //   1387: getfield mDestroyed : Z
    //   1390: ifeq -> 1416
    //   1393: aload_1
    //   1394: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   1397: ifnull -> 1416
    //   1400: aload_1
    //   1401: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   1404: astore #8
    //   1406: aload_1
    //   1407: aconst_null
    //   1408: invokevirtual setAnimatingAway : (Landroid/view/View;)V
    //   1411: aload #8
    //   1413: invokevirtual clearAnimation : ()V
    //   1416: aload_1
    //   1417: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   1420: ifnull -> 1804
    //   1423: aload_1
    //   1424: iload_2
    //   1425: invokevirtual setStateAfterAnimating : (I)V
    //   1428: iconst_1
    //   1429: istore #6
    //   1431: goto -> 191
    //   1434: iload_2
    //   1435: iconst_5
    //   1436: if_icmpge -> 1481
    //   1439: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1442: ifeq -> 1471
    //   1445: ldc 'FragmentManager'
    //   1447: new java/lang/StringBuilder
    //   1450: dup
    //   1451: invokespecial <init> : ()V
    //   1454: ldc_w 'movefrom RESUMED: '
    //   1457: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: aload_1
    //   1461: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1464: invokevirtual toString : ()Ljava/lang/String;
    //   1467: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1470: pop
    //   1471: aload_1
    //   1472: invokevirtual performPause : ()V
    //   1475: aload_0
    //   1476: aload_1
    //   1477: iconst_0
    //   1478: invokevirtual dispatchOnFragmentPaused : (Landroid/support/v4/app/Fragment;Z)V
    //   1481: iload_2
    //   1482: iconst_4
    //   1483: if_icmpge -> 1528
    //   1486: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1489: ifeq -> 1518
    //   1492: ldc 'FragmentManager'
    //   1494: new java/lang/StringBuilder
    //   1497: dup
    //   1498: invokespecial <init> : ()V
    //   1501: ldc_w 'movefrom STARTED: '
    //   1504: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: aload_1
    //   1508: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1511: invokevirtual toString : ()Ljava/lang/String;
    //   1514: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1517: pop
    //   1518: aload_1
    //   1519: invokevirtual performStop : ()V
    //   1522: aload_0
    //   1523: aload_1
    //   1524: iconst_0
    //   1525: invokevirtual dispatchOnFragmentStopped : (Landroid/support/v4/app/Fragment;Z)V
    //   1528: iload_2
    //   1529: iconst_3
    //   1530: if_icmpge -> 1569
    //   1533: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1536: ifeq -> 1565
    //   1539: ldc 'FragmentManager'
    //   1541: new java/lang/StringBuilder
    //   1544: dup
    //   1545: invokespecial <init> : ()V
    //   1548: ldc_w 'movefrom STOPPED: '
    //   1551: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: aload_1
    //   1555: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1558: invokevirtual toString : ()Ljava/lang/String;
    //   1561: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1564: pop
    //   1565: aload_1
    //   1566: invokevirtual performReallyStop : ()V
    //   1569: iload_2
    //   1570: iconst_2
    //   1571: if_icmpge -> 1378
    //   1574: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1577: ifeq -> 1606
    //   1580: ldc 'FragmentManager'
    //   1582: new java/lang/StringBuilder
    //   1585: dup
    //   1586: invokespecial <init> : ()V
    //   1589: ldc_w 'movefrom ACTIVITY_CREATED: '
    //   1592: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: aload_1
    //   1596: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1599: invokevirtual toString : ()Ljava/lang/String;
    //   1602: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1605: pop
    //   1606: aload_1
    //   1607: getfield mView : Landroid/view/View;
    //   1610: ifnull -> 1636
    //   1613: aload_0
    //   1614: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   1617: aload_1
    //   1618: invokevirtual onShouldSaveFragmentState : (Landroid/support/v4/app/Fragment;)Z
    //   1621: ifeq -> 1636
    //   1624: aload_1
    //   1625: getfield mSavedViewState : Landroid/util/SparseArray;
    //   1628: ifnonnull -> 1636
    //   1631: aload_0
    //   1632: aload_1
    //   1633: invokevirtual saveFragmentViewState : (Landroid/support/v4/app/Fragment;)V
    //   1636: aload_1
    //   1637: invokevirtual performDestroyView : ()V
    //   1640: aload_0
    //   1641: aload_1
    //   1642: iconst_0
    //   1643: invokevirtual dispatchOnFragmentViewDestroyed : (Landroid/support/v4/app/Fragment;Z)V
    //   1646: aload_1
    //   1647: getfield mView : Landroid/view/View;
    //   1650: ifnull -> 1786
    //   1653: aload_1
    //   1654: getfield mContainer : Landroid/view/ViewGroup;
    //   1657: ifnull -> 1786
    //   1660: aconst_null
    //   1661: astore #9
    //   1663: aload #9
    //   1665: astore #8
    //   1667: aload_0
    //   1668: getfield mCurState : I
    //   1671: ifle -> 1723
    //   1674: aload #9
    //   1676: astore #8
    //   1678: aload_0
    //   1679: getfield mDestroyed : Z
    //   1682: ifne -> 1723
    //   1685: aload #9
    //   1687: astore #8
    //   1689: aload_1
    //   1690: getfield mView : Landroid/view/View;
    //   1693: invokevirtual getVisibility : ()I
    //   1696: ifne -> 1723
    //   1699: aload #9
    //   1701: astore #8
    //   1703: aload_1
    //   1704: getfield mPostponedAlpha : F
    //   1707: fconst_0
    //   1708: fcmpl
    //   1709: iflt -> 1723
    //   1712: aload_0
    //   1713: aload_1
    //   1714: iload_3
    //   1715: iconst_0
    //   1716: iload #4
    //   1718: invokevirtual loadAnimation : (Landroid/support/v4/app/Fragment;IZI)Landroid/view/animation/Animation;
    //   1721: astore #8
    //   1723: aload_1
    //   1724: fconst_0
    //   1725: putfield mPostponedAlpha : F
    //   1728: aload #8
    //   1730: ifnull -> 1775
    //   1733: aload_1
    //   1734: aload_1
    //   1735: getfield mView : Landroid/view/View;
    //   1738: invokevirtual setAnimatingAway : (Landroid/view/View;)V
    //   1741: aload_1
    //   1742: iload_2
    //   1743: invokevirtual setStateAfterAnimating : (I)V
    //   1746: aload #8
    //   1748: new android/support/v4/app/FragmentManagerImpl$2
    //   1751: dup
    //   1752: aload_0
    //   1753: aload_1
    //   1754: getfield mView : Landroid/view/View;
    //   1757: aload #8
    //   1759: aload_1
    //   1760: invokespecial <init> : (Landroid/support/v4/app/FragmentManagerImpl;Landroid/view/View;Landroid/view/animation/Animation;Landroid/support/v4/app/Fragment;)V
    //   1763: invokevirtual setAnimationListener : (Landroid/view/animation/Animation$AnimationListener;)V
    //   1766: aload_1
    //   1767: getfield mView : Landroid/view/View;
    //   1770: aload #8
    //   1772: invokevirtual startAnimation : (Landroid/view/animation/Animation;)V
    //   1775: aload_1
    //   1776: getfield mContainer : Landroid/view/ViewGroup;
    //   1779: aload_1
    //   1780: getfield mView : Landroid/view/View;
    //   1783: invokevirtual removeView : (Landroid/view/View;)V
    //   1786: aload_1
    //   1787: aconst_null
    //   1788: putfield mContainer : Landroid/view/ViewGroup;
    //   1791: aload_1
    //   1792: aconst_null
    //   1793: putfield mView : Landroid/view/View;
    //   1796: aload_1
    //   1797: aconst_null
    //   1798: putfield mInnerView : Landroid/view/View;
    //   1801: goto -> 1378
    //   1804: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1807: ifeq -> 1836
    //   1810: ldc 'FragmentManager'
    //   1812: new java/lang/StringBuilder
    //   1815: dup
    //   1816: invokespecial <init> : ()V
    //   1819: ldc_w 'movefrom CREATED: '
    //   1822: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1825: aload_1
    //   1826: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1829: invokevirtual toString : ()Ljava/lang/String;
    //   1832: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1835: pop
    //   1836: aload_1
    //   1837: getfield mRetaining : Z
    //   1840: ifne -> 1889
    //   1843: aload_1
    //   1844: invokevirtual performDestroy : ()V
    //   1847: aload_0
    //   1848: aload_1
    //   1849: iconst_0
    //   1850: invokevirtual dispatchOnFragmentDestroyed : (Landroid/support/v4/app/Fragment;Z)V
    //   1853: aload_1
    //   1854: invokevirtual performDetach : ()V
    //   1857: aload_0
    //   1858: aload_1
    //   1859: iconst_0
    //   1860: invokevirtual dispatchOnFragmentDetached : (Landroid/support/v4/app/Fragment;Z)V
    //   1863: iload_2
    //   1864: istore #6
    //   1866: iload #5
    //   1868: ifne -> 191
    //   1871: aload_1
    //   1872: getfield mRetaining : Z
    //   1875: ifne -> 1897
    //   1878: aload_0
    //   1879: aload_1
    //   1880: invokevirtual makeInactive : (Landroid/support/v4/app/Fragment;)V
    //   1883: iload_2
    //   1884: istore #6
    //   1886: goto -> 191
    //   1889: aload_1
    //   1890: iconst_0
    //   1891: putfield mState : I
    //   1894: goto -> 1853
    //   1897: aload_1
    //   1898: aconst_null
    //   1899: putfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   1902: aload_1
    //   1903: aconst_null
    //   1904: putfield mParentFragment : Landroid/support/v4/app/Fragment;
    //   1907: aload_1
    //   1908: aconst_null
    //   1909: putfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   1912: iload_2
    //   1913: istore #6
    //   1915: goto -> 191
    // Exception table:
    //   from	to	target	type
    //   833	846	1286	android/content/res/Resources$NotFoundException
  }
  
  public void noteStateNotSaved() {
    this.mStateSaved = false;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    if ("fragment".equals(paramString)) {
      paramString = paramAttributeSet.getAttributeValue(null, "class");
      TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentTag.Fragment);
      String str1 = paramString;
      if (paramString == null)
        str1 = typedArray.getString(0); 
      int i = typedArray.getResourceId(1, -1);
      String str2 = typedArray.getString(2);
      typedArray.recycle();
      if (Fragment.isSupportFragmentClass(this.mHost.getContext(), str1)) {
        Fragment fragment1;
        boolean bool;
        if (paramView != null) {
          bool = paramView.getId();
        } else {
          bool = false;
        } 
        if (bool == -1 && i == -1 && str2 == null)
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1); 
        if (i != -1) {
          Fragment fragment = findFragmentById(i);
        } else {
          paramString = null;
        } 
        String str = paramString;
        if (paramString == null) {
          str = paramString;
          if (str2 != null)
            fragment1 = findFragmentByTag(str2); 
        } 
        Fragment fragment2 = fragment1;
        if (fragment1 == null) {
          fragment2 = fragment1;
          if (bool != -1)
            fragment2 = findFragmentById(bool); 
        } 
        if (DEBUG)
          Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(i) + " fname=" + str1 + " existing=" + fragment2); 
        if (fragment2 == null) {
          boolean bool1;
          fragment1 = Fragment.instantiate(paramContext, str1);
          fragment1.mFromLayout = true;
          if (i != 0) {
            bool1 = i;
          } else {
            bool1 = bool;
          } 
          fragment1.mFragmentId = bool1;
          fragment1.mContainerId = bool;
          fragment1.mTag = str2;
          fragment1.mInLayout = true;
          fragment1.mFragmentManager = this;
          fragment1.mHost = this.mHost;
          fragment1.onInflate(this.mHost.getContext(), paramAttributeSet, fragment1.mSavedFragmentState);
          addFragment(fragment1, true);
        } else {
          if (fragment2.mInLayout)
            throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(i) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(bool) + " with another fragment for " + str1); 
          fragment2.mInLayout = true;
          fragment2.mHost = this.mHost;
          fragment1 = fragment2;
          if (!fragment2.mRetaining) {
            fragment2.onInflate(this.mHost.getContext(), paramAttributeSet, fragment2.mSavedFragmentState);
            fragment1 = fragment2;
          } 
        } 
        if (this.mCurState < 1 && fragment1.mFromLayout) {
          moveToState(fragment1, 1, 0, 0, false);
        } else {
          moveToState(fragment1);
        } 
        if (fragment1.mView == null)
          throw new IllegalStateException("Fragment " + str1 + " did not create a view."); 
        if (i != 0)
          fragment1.mView.setId(i); 
        if (fragment1.mView.getTag() == null)
          fragment1.mView.setTag(str2); 
        return fragment1.mView;
      } 
    } 
    return null;
  }
  
  public void performPendingDeferredStart(Fragment paramFragment) {
    if (paramFragment.mDeferStart) {
      if (this.mExecutingActions) {
        this.mHavePendingDeferredStart = true;
        return;
      } 
    } else {
      return;
    } 
    paramFragment.mDeferStart = false;
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  public void popBackStack() {
    enqueueAction(new PopBackStackState(null, -1, 0), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2) {
    if (paramInt1 < 0)
      throw new IllegalArgumentException("Bad id: " + paramInt1); 
    enqueueAction(new PopBackStackState(null, paramInt1, paramInt2), false);
  }
  
  public void popBackStack(String paramString, int paramInt) {
    enqueueAction(new PopBackStackState(paramString, -1, paramInt), false);
  }
  
  public boolean popBackStackImmediate() {
    checkStateLoss();
    return popBackStackImmediate(null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2) {
    checkStateLoss();
    execPendingActions();
    if (paramInt1 < 0)
      throw new IllegalArgumentException("Bad id: " + paramInt1); 
    return popBackStackImmediate(null, paramInt1, paramInt2);
  }
  
  public boolean popBackStackImmediate(String paramString, int paramInt) {
    checkStateLoss();
    return popBackStackImmediate(paramString, -1, paramInt);
  }
  
  boolean popBackStackState(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mBackStack : Ljava/util/ArrayList;
    //   4: ifnonnull -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_3
    //   10: ifnonnull -> 66
    //   13: iload #4
    //   15: ifge -> 66
    //   18: iload #5
    //   20: iconst_1
    //   21: iand
    //   22: ifne -> 66
    //   25: aload_0
    //   26: getfield mBackStack : Ljava/util/ArrayList;
    //   29: invokevirtual size : ()I
    //   32: iconst_1
    //   33: isub
    //   34: istore #4
    //   36: iload #4
    //   38: iflt -> 7
    //   41: aload_1
    //   42: aload_0
    //   43: getfield mBackStack : Ljava/util/ArrayList;
    //   46: iload #4
    //   48: invokevirtual remove : (I)Ljava/lang/Object;
    //   51: invokevirtual add : (Ljava/lang/Object;)Z
    //   54: pop
    //   55: aload_2
    //   56: iconst_1
    //   57: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   60: invokevirtual add : (Ljava/lang/Object;)Z
    //   63: pop
    //   64: iconst_1
    //   65: ireturn
    //   66: iconst_m1
    //   67: istore #6
    //   69: aload_3
    //   70: ifnonnull -> 78
    //   73: iload #4
    //   75: iflt -> 241
    //   78: aload_0
    //   79: getfield mBackStack : Ljava/util/ArrayList;
    //   82: invokevirtual size : ()I
    //   85: iconst_1
    //   86: isub
    //   87: istore #7
    //   89: iload #7
    //   91: iflt -> 124
    //   94: aload_0
    //   95: getfield mBackStack : Ljava/util/ArrayList;
    //   98: iload #7
    //   100: invokevirtual get : (I)Ljava/lang/Object;
    //   103: checkcast android/support/v4/app/BackStackRecord
    //   106: astore #8
    //   108: aload_3
    //   109: ifnull -> 217
    //   112: aload_3
    //   113: aload #8
    //   115: invokevirtual getName : ()Ljava/lang/String;
    //   118: invokevirtual equals : (Ljava/lang/Object;)Z
    //   121: ifeq -> 217
    //   124: iload #7
    //   126: iflt -> 7
    //   129: iload #7
    //   131: istore #6
    //   133: iload #5
    //   135: iconst_1
    //   136: iand
    //   137: ifeq -> 241
    //   140: iload #7
    //   142: iconst_1
    //   143: isub
    //   144: istore #5
    //   146: iload #5
    //   148: istore #6
    //   150: iload #5
    //   152: iflt -> 241
    //   155: aload_0
    //   156: getfield mBackStack : Ljava/util/ArrayList;
    //   159: iload #5
    //   161: invokevirtual get : (I)Ljava/lang/Object;
    //   164: checkcast android/support/v4/app/BackStackRecord
    //   167: astore #8
    //   169: aload_3
    //   170: ifnull -> 185
    //   173: aload_3
    //   174: aload #8
    //   176: invokevirtual getName : ()Ljava/lang/String;
    //   179: invokevirtual equals : (Ljava/lang/Object;)Z
    //   182: ifne -> 208
    //   185: iload #5
    //   187: istore #6
    //   189: iload #4
    //   191: iflt -> 241
    //   194: iload #5
    //   196: istore #6
    //   198: iload #4
    //   200: aload #8
    //   202: getfield mIndex : I
    //   205: if_icmpne -> 241
    //   208: iload #5
    //   210: iconst_1
    //   211: isub
    //   212: istore #5
    //   214: goto -> 146
    //   217: iload #4
    //   219: iflt -> 232
    //   222: iload #4
    //   224: aload #8
    //   226: getfield mIndex : I
    //   229: if_icmpeq -> 124
    //   232: iload #7
    //   234: iconst_1
    //   235: isub
    //   236: istore #7
    //   238: goto -> 89
    //   241: iload #6
    //   243: aload_0
    //   244: getfield mBackStack : Ljava/util/ArrayList;
    //   247: invokevirtual size : ()I
    //   250: iconst_1
    //   251: isub
    //   252: if_icmpeq -> 7
    //   255: aload_0
    //   256: getfield mBackStack : Ljava/util/ArrayList;
    //   259: invokevirtual size : ()I
    //   262: iconst_1
    //   263: isub
    //   264: istore #4
    //   266: iload #4
    //   268: iload #6
    //   270: if_icmple -> 64
    //   273: aload_1
    //   274: aload_0
    //   275: getfield mBackStack : Ljava/util/ArrayList;
    //   278: iload #4
    //   280: invokevirtual remove : (I)Ljava/lang/Object;
    //   283: invokevirtual add : (Ljava/lang/Object;)Z
    //   286: pop
    //   287: aload_2
    //   288: iconst_1
    //   289: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   292: invokevirtual add : (Ljava/lang/Object;)Z
    //   295: pop
    //   296: iload #4
    //   298: iconst_1
    //   299: isub
    //   300: istore #4
    //   302: goto -> 266
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment) {
    if (paramFragment.mIndex < 0)
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager")); 
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean) {
    if (this.mLifecycleCallbacks == null)
      this.mLifecycleCallbacks = new CopyOnWriteArrayList<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>>(); 
    this.mLifecycleCallbacks.add(new Pair(paramFragmentLifecycleCallbacks, Boolean.valueOf(paramBoolean)));
  }
  
  public void removeFragment(Fragment paramFragment) {
    boolean bool;
    if (DEBUG)
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.mBackStackNesting); 
    if (!paramFragment.isInBackStack()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!paramFragment.mDetached || bool) {
      if (this.mAdded != null)
        this.mAdded.remove(paramFragment); 
      if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
        this.mNeedMenuInvalidate = true; 
      paramFragment.mAdded = false;
      paramFragment.mRemoving = true;
    } 
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener) {
    if (this.mBackStackChangeListeners != null)
      this.mBackStackChangeListeners.remove(paramOnBackStackChangedListener); 
  }
  
  void reportBackStackChanged() {
    if (this.mBackStackChangeListeners != null)
      for (int i = 0; i < this.mBackStackChangeListeners.size(); i++)
        ((FragmentManager.OnBackStackChangedListener)this.mBackStackChangeListeners.get(i)).onBackStackChanged();  
  }
  
  void restoreAllState(Parcelable paramParcelable, FragmentManagerNonConfig paramFragmentManagerNonConfig) {
    if (paramParcelable != null) {
      FragmentManagerState fragmentManagerState = (FragmentManagerState)paramParcelable;
      if (fragmentManagerState.mActive != null) {
        Fragment fragment;
        paramParcelable = null;
        if (paramFragmentManagerNonConfig != null) {
          byte b;
          List<Fragment> list1 = paramFragmentManagerNonConfig.getFragments();
          List<FragmentManagerNonConfig> list = paramFragmentManagerNonConfig.getChildNonConfigs();
          if (list1 != null) {
            b = list1.size();
          } else {
            b = 0;
          } 
          int j = 0;
          while (true) {
            List<FragmentManagerNonConfig> list2 = list;
            if (j < b) {
              fragment = list1.get(j);
              if (DEBUG)
                Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment); 
              FragmentState fragmentState = fragmentManagerState.mActive[fragment.mIndex];
              fragmentState.mInstance = fragment;
              fragment.mSavedViewState = null;
              fragment.mBackStackNesting = 0;
              fragment.mInLayout = false;
              fragment.mAdded = false;
              fragment.mTarget = null;
              if (fragmentState.mSavedFragmentState != null) {
                fragmentState.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
              } 
              j++;
              continue;
            } 
            break;
          } 
        } 
        this.mActive = new ArrayList<Fragment>(fragmentManagerState.mActive.length);
        if (this.mAvailIndices != null)
          this.mAvailIndices.clear(); 
        int i;
        for (i = 0; i < fragmentManagerState.mActive.length; i++) {
          FragmentState fragmentState = fragmentManagerState.mActive[i];
          if (fragmentState != null) {
            FragmentManagerNonConfig fragmentManagerNonConfig2 = null;
            FragmentManagerNonConfig fragmentManagerNonConfig1 = fragmentManagerNonConfig2;
            if (fragment != null) {
              fragmentManagerNonConfig1 = fragmentManagerNonConfig2;
              if (i < fragment.size())
                fragmentManagerNonConfig1 = fragment.get(i); 
            } 
            Fragment fragment1 = fragmentState.instantiate(this.mHost, this.mParent, fragmentManagerNonConfig1);
            if (DEBUG)
              Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + fragment1); 
            this.mActive.add(fragment1);
            fragmentState.mInstance = null;
          } else {
            this.mActive.add(null);
            if (this.mAvailIndices == null)
              this.mAvailIndices = new ArrayList<Integer>(); 
            if (DEBUG)
              Log.v("FragmentManager", "restoreAllState: avail #" + i); 
            this.mAvailIndices.add(Integer.valueOf(i));
          } 
        } 
        if (paramFragmentManagerNonConfig != null) {
          List<Fragment> list = paramFragmentManagerNonConfig.getFragments();
          if (list != null) {
            i = list.size();
          } else {
            i = 0;
          } 
          for (int j = 0; j < i; j++) {
            Fragment fragment1 = list.get(j);
            if (fragment1.mTargetIndex >= 0)
              if (fragment1.mTargetIndex < this.mActive.size()) {
                fragment1.mTarget = this.mActive.get(fragment1.mTargetIndex);
              } else {
                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment1 + " target no longer exists: " + fragment1.mTargetIndex);
                fragment1.mTarget = null;
              }  
          } 
        } 
        if (fragmentManagerState.mAdded != null) {
          this.mAdded = new ArrayList<Fragment>(fragmentManagerState.mAdded.length);
          for (i = 0; i < fragmentManagerState.mAdded.length; i++) {
            fragment = this.mActive.get(fragmentManagerState.mAdded[i]);
            if (fragment == null)
              throwException(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[i])); 
            fragment.mAdded = true;
            if (DEBUG)
              Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment); 
            if (this.mAdded.contains(fragment))
              throw new IllegalStateException("Already added!"); 
            this.mAdded.add(fragment);
          } 
        } else {
          this.mAdded = null;
        } 
        if (fragmentManagerState.mBackStack != null) {
          this.mBackStack = new ArrayList<BackStackRecord>(fragmentManagerState.mBackStack.length);
          i = 0;
          while (true) {
            if (i < fragmentManagerState.mBackStack.length) {
              BackStackRecord backStackRecord = fragmentManagerState.mBackStack[i].instantiate(this);
              if (DEBUG) {
                Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + backStackRecord.mIndex + "): " + backStackRecord);
                PrintWriter printWriter = new PrintWriter((Writer)new LogWriter("FragmentManager"));
                backStackRecord.dump("  ", printWriter, false);
                printWriter.close();
              } 
              this.mBackStack.add(backStackRecord);
              if (backStackRecord.mIndex >= 0)
                setBackStackIndex(backStackRecord.mIndex, backStackRecord); 
              i++;
              continue;
            } 
            return;
          } 
        } 
        this.mBackStack = null;
        return;
      } 
    } 
  }
  
  FragmentManagerNonConfig retainNonConfig() {
    ArrayList<Fragment> arrayList4 = null;
    ArrayList<Fragment> arrayList2 = null;
    ArrayList<Fragment> arrayList3 = null;
    ArrayList<Fragment> arrayList1 = null;
    if (this.mActive != null) {
      int i = 0;
      while (true) {
        arrayList3 = arrayList1;
        arrayList4 = arrayList2;
        if (i < this.mActive.size()) {
          Fragment fragment = this.mActive.get(i);
          arrayList4 = arrayList1;
          ArrayList<Fragment> arrayList = arrayList2;
          if (fragment != null) {
            arrayList3 = arrayList2;
            if (fragment.mRetainInstance) {
              byte b1;
              arrayList4 = arrayList2;
              if (arrayList2 == null)
                arrayList4 = new ArrayList(); 
              arrayList4.add(fragment);
              fragment.mRetaining = true;
              if (fragment.mTarget != null) {
                b1 = fragment.mTarget.mIndex;
              } else {
                b1 = -1;
              } 
              fragment.mTargetIndex = b1;
              arrayList3 = arrayList4;
              if (DEBUG) {
                Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                arrayList3 = arrayList4;
              } 
            } 
            byte b = 0;
            int j = b;
            arrayList2 = arrayList1;
            if (fragment.mChildFragmentManager != null) {
              FragmentManagerNonConfig fragmentManagerNonConfig = fragment.mChildFragmentManager.retainNonConfig();
              j = b;
              arrayList2 = arrayList1;
              if (fragmentManagerNonConfig != null) {
                arrayList2 = arrayList1;
                if (arrayList1 == null) {
                  arrayList1 = new ArrayList<Fragment>();
                  j = 0;
                  while (true) {
                    arrayList2 = arrayList1;
                    if (j < i) {
                      arrayList1.add(null);
                      j++;
                      continue;
                    } 
                    break;
                  } 
                } 
                arrayList2.add(fragmentManagerNonConfig);
                j = 1;
              } 
            } 
            arrayList4 = arrayList2;
            arrayList = arrayList3;
            if (arrayList2 != null) {
              arrayList4 = arrayList2;
              arrayList = arrayList3;
              if (j == 0) {
                arrayList2.add(null);
                arrayList = arrayList3;
                arrayList4 = arrayList2;
              } 
            } 
          } 
          i++;
          arrayList1 = arrayList4;
          arrayList2 = arrayList;
          continue;
        } 
        break;
      } 
    } 
    return (arrayList4 == null && arrayList3 == null) ? null : new FragmentManagerNonConfig(arrayList4, (List)arrayList3);
  }
  
  Parcelable saveAllState() {
    forcePostponedTransactions();
    endAnimatingAwayFragments();
    execPendingActions();
    if (HONEYCOMB)
      this.mStateSaved = true; 
    if (this.mActive != null && this.mActive.size() > 0) {
      BackStackState[] arrayOfBackStackState;
      int k = this.mActive.size();
      FragmentState[] arrayOfFragmentState = new FragmentState[k];
      int j = 0;
      int i;
      for (i = 0; i < k; i++) {
        Fragment fragment = this.mActive.get(i);
        if (fragment != null) {
          if (fragment.mIndex < 0)
            throwException(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex)); 
          byte b = 1;
          FragmentState fragmentState = new FragmentState(fragment);
          arrayOfFragmentState[i] = fragmentState;
          if (fragment.mState > 0 && fragmentState.mSavedFragmentState == null) {
            fragmentState.mSavedFragmentState = saveFragmentBasicState(fragment);
            if (fragment.mTarget != null) {
              if (fragment.mTarget.mIndex < 0)
                throwException(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget)); 
              if (fragmentState.mSavedFragmentState == null)
                fragmentState.mSavedFragmentState = new Bundle(); 
              putFragment(fragmentState.mSavedFragmentState, "android:target_state", fragment.mTarget);
              if (fragment.mTargetRequestCode != 0)
                fragmentState.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode); 
            } 
          } else {
            fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
          } 
          j = b;
          if (DEBUG) {
            Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState);
            j = b;
          } 
        } 
      } 
      if (!j) {
        if (DEBUG) {
          Log.v("FragmentManager", "saveAllState: no fragments!");
          return null;
        } 
        return null;
      } 
      int[] arrayOfInt2 = null;
      int[] arrayOfInt3 = null;
      int[] arrayOfInt1 = arrayOfInt2;
      if (this.mAdded != null) {
        j = this.mAdded.size();
        arrayOfInt1 = arrayOfInt2;
        if (j > 0) {
          arrayOfInt2 = new int[j];
          i = 0;
          while (true) {
            arrayOfInt1 = arrayOfInt2;
            if (i < j) {
              arrayOfInt2[i] = ((Fragment)this.mAdded.get(i)).mIndex;
              if (arrayOfInt2[i] < 0)
                throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i) + " has cleared index: " + arrayOfInt2[i])); 
              if (DEBUG)
                Log.v("FragmentManager", "saveAllState: adding fragment #" + i + ": " + this.mAdded.get(i)); 
              i++;
              continue;
            } 
            break;
          } 
        } 
      } 
      arrayOfInt2 = arrayOfInt3;
      if (this.mBackStack != null) {
        j = this.mBackStack.size();
        arrayOfInt2 = arrayOfInt3;
        if (j > 0) {
          BackStackState[] arrayOfBackStackState1 = new BackStackState[j];
          i = 0;
          while (true) {
            arrayOfBackStackState = arrayOfBackStackState1;
            if (i < j) {
              arrayOfBackStackState1[i] = new BackStackState(this.mBackStack.get(i));
              if (DEBUG)
                Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.mBackStack.get(i)); 
              i++;
              continue;
            } 
            break;
          } 
        } 
      } 
      FragmentManagerState fragmentManagerState = new FragmentManagerState();
      fragmentManagerState.mActive = arrayOfFragmentState;
      fragmentManagerState.mAdded = arrayOfInt1;
      fragmentManagerState.mBackStack = arrayOfBackStackState;
      return fragmentManagerState;
    } 
    return null;
  }
  
  Bundle saveFragmentBasicState(Fragment paramFragment) {
    Bundle bundle2 = null;
    if (this.mStateBundle == null)
      this.mStateBundle = new Bundle(); 
    paramFragment.performSaveInstanceState(this.mStateBundle);
    dispatchOnFragmentSaveInstanceState(paramFragment, this.mStateBundle, false);
    if (!this.mStateBundle.isEmpty()) {
      bundle2 = this.mStateBundle;
      this.mStateBundle = null;
    } 
    if (paramFragment.mView != null)
      saveFragmentViewState(paramFragment); 
    Bundle bundle1 = bundle2;
    if (paramFragment.mSavedViewState != null) {
      bundle1 = bundle2;
      if (bundle2 == null)
        bundle1 = new Bundle(); 
      bundle1.putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
    } 
    bundle2 = bundle1;
    if (!paramFragment.mUserVisibleHint) {
      bundle2 = bundle1;
      if (bundle1 == null)
        bundle2 = new Bundle(); 
      bundle2.putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
    } 
    return bundle2;
  }
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment) {
    Fragment.SavedState savedState2 = null;
    if (paramFragment.mIndex < 0)
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager")); 
    Fragment.SavedState savedState1 = savedState2;
    if (paramFragment.mState > 0) {
      Bundle bundle = saveFragmentBasicState(paramFragment);
      savedState1 = savedState2;
      if (bundle != null)
        savedState1 = new Fragment.SavedState(bundle); 
    } 
    return savedState1;
  }
  
  void saveFragmentViewState(Fragment paramFragment) {
    if (paramFragment.mInnerView != null) {
      if (this.mStateArray == null) {
        this.mStateArray = new SparseArray();
      } else {
        this.mStateArray.clear();
      } 
      paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
      if (this.mStateArray.size() > 0) {
        paramFragment.mSavedViewState = this.mStateArray;
        this.mStateArray = null;
        return;
      } 
    } 
  }
  
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   6: ifnonnull -> 20
    //   9: aload_0
    //   10: new java/util/ArrayList
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: putfield mBackStackIndices : Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   24: invokevirtual size : ()I
    //   27: istore #4
    //   29: iload #4
    //   31: istore_3
    //   32: iload_1
    //   33: iload #4
    //   35: if_icmpge -> 93
    //   38: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   41: ifeq -> 80
    //   44: ldc 'FragmentManager'
    //   46: new java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial <init> : ()V
    //   53: ldc_w 'Setting back stack index '
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: iload_1
    //   60: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   63: ldc_w ' to '
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: invokevirtual toString : ()Ljava/lang/String;
    //   76: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   79: pop
    //   80: aload_0
    //   81: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   84: iload_1
    //   85: aload_2
    //   86: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: iload_3
    //   94: iload_1
    //   95: if_icmpge -> 176
    //   98: aload_0
    //   99: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   102: aconst_null
    //   103: invokevirtual add : (Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload_0
    //   108: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   111: ifnonnull -> 125
    //   114: aload_0
    //   115: new java/util/ArrayList
    //   118: dup
    //   119: invokespecial <init> : ()V
    //   122: putfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   125: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   128: ifeq -> 157
    //   131: ldc 'FragmentManager'
    //   133: new java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial <init> : ()V
    //   140: ldc_w 'Adding available back stack index '
    //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload_3
    //   147: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   150: invokevirtual toString : ()Ljava/lang/String;
    //   153: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   156: pop
    //   157: aload_0
    //   158: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   161: iload_3
    //   162: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   165: invokevirtual add : (Ljava/lang/Object;)Z
    //   168: pop
    //   169: iload_3
    //   170: iconst_1
    //   171: iadd
    //   172: istore_3
    //   173: goto -> 93
    //   176: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   179: ifeq -> 218
    //   182: ldc 'FragmentManager'
    //   184: new java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial <init> : ()V
    //   191: ldc_w 'Adding back stack index '
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload_1
    //   198: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   201: ldc_w ' with '
    //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_2
    //   208: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: invokevirtual toString : ()Ljava/lang/String;
    //   214: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: aload_0
    //   219: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   222: aload_2
    //   223: invokevirtual add : (Ljava/lang/Object;)Z
    //   226: pop
    //   227: goto -> 90
    //   230: astore_2
    //   231: aload_0
    //   232: monitorexit
    //   233: aload_2
    //   234: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	230	finally
    //   20	29	230	finally
    //   38	80	230	finally
    //   80	90	230	finally
    //   90	92	230	finally
    //   98	125	230	finally
    //   125	157	230	finally
    //   157	169	230	finally
    //   176	218	230	finally
    //   218	227	230	finally
    //   231	233	230	finally
  }
  
  public void showFragment(Fragment paramFragment) {
    boolean bool = false;
    if (DEBUG)
      Log.v("FragmentManager", "show: " + paramFragment); 
    if (paramFragment.mHidden) {
      paramFragment.mHidden = false;
      if (!paramFragment.mHiddenChanged)
        bool = true; 
      paramFragment.mHiddenChanged = bool;
    } 
  }
  
  void startPendingDeferredFragments() {
    if (this.mActive != null) {
      int i = 0;
      while (true) {
        if (i < this.mActive.size()) {
          Fragment fragment = this.mActive.get(i);
          if (fragment != null)
            performPendingDeferredStart(fragment); 
          i++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("FragmentManager{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" in ");
    if (this.mParent != null) {
      DebugUtils.buildShortClassTag(this.mParent, stringBuilder);
      stringBuilder.append("}}");
      return stringBuilder.toString();
    } 
    DebugUtils.buildShortClassTag(this.mHost, stringBuilder);
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
  
  public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mLifecycleCallbacks : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   4: ifnonnull -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield mLifecycleCallbacks : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   12: astore #4
    //   14: aload #4
    //   16: monitorenter
    //   17: iconst_0
    //   18: istore_2
    //   19: aload_0
    //   20: getfield mLifecycleCallbacks : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   23: invokevirtual size : ()I
    //   26: istore_3
    //   27: iload_2
    //   28: iload_3
    //   29: if_icmpge -> 59
    //   32: aload_0
    //   33: getfield mLifecycleCallbacks : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   36: iload_2
    //   37: invokevirtual get : (I)Ljava/lang/Object;
    //   40: checkcast android/support/v4/util/Pair
    //   43: getfield first : Ljava/lang/Object;
    //   46: aload_1
    //   47: if_acmpne -> 69
    //   50: aload_0
    //   51: getfield mLifecycleCallbacks : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   54: iload_2
    //   55: invokevirtual remove : (I)Ljava/lang/Object;
    //   58: pop
    //   59: aload #4
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload #4
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    //   69: iload_2
    //   70: iconst_1
    //   71: iadd
    //   72: istore_2
    //   73: goto -> 27
    // Exception table:
    //   from	to	target	type
    //   19	27	63	finally
    //   32	59	63	finally
    //   59	62	63	finally
    //   64	67	63	finally
  }
  
  static {
    boolean bool = false;
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 11)
      bool = true; 
    HONEYCOMB = bool;
  }
  
  static class AnimateOnHWLayerIfNeededListener implements Animation.AnimationListener {
    private Animation.AnimationListener mOriginalListener;
    
    private boolean mShouldRunOnHWLayer;
    
    View mView;
    
    public AnimateOnHWLayerIfNeededListener(View param1View, Animation param1Animation) {
      if (param1View == null || param1Animation == null)
        return; 
      this.mView = param1View;
    }
    
    public AnimateOnHWLayerIfNeededListener(View param1View, Animation param1Animation, Animation.AnimationListener param1AnimationListener) {
      if (param1View == null || param1Animation == null)
        return; 
      this.mOriginalListener = param1AnimationListener;
      this.mView = param1View;
      this.mShouldRunOnHWLayer = true;
    }
    
    @CallSuper
    public void onAnimationEnd(Animation param1Animation) {
      if (this.mView != null && this.mShouldRunOnHWLayer)
        if (ViewCompat.isAttachedToWindow(this.mView) || BuildCompat.isAtLeastN()) {
          this.mView.post(new Runnable() {
                public void run() {
                  ViewCompat.setLayerType(FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.this.mView, 0, null);
                }
              });
        } else {
          ViewCompat.setLayerType(this.mView, 0, null);
        }  
      if (this.mOriginalListener != null)
        this.mOriginalListener.onAnimationEnd(param1Animation); 
    }
    
    public void onAnimationRepeat(Animation param1Animation) {
      if (this.mOriginalListener != null)
        this.mOriginalListener.onAnimationRepeat(param1Animation); 
    }
    
    @CallSuper
    public void onAnimationStart(Animation param1Animation) {
      if (this.mOriginalListener != null)
        this.mOriginalListener.onAnimationStart(param1Animation); 
    }
  }
  
  class null implements Runnable {
    public void run() {
      ViewCompat.setLayerType(this.this$0.mView, 0, null);
    }
  }
  
  static class FragmentTag {
    public static final int[] Fragment = new int[] { 16842755, 16842960, 16842961 };
    
    public static final int Fragment_id = 1;
    
    public static final int Fragment_name = 0;
    
    public static final int Fragment_tag = 2;
  }
  
  static interface OpGenerator {
    boolean generateOps(ArrayList<BackStackRecord> param1ArrayList, ArrayList<Boolean> param1ArrayList1);
  }
  
  private class PopBackStackState implements OpGenerator {
    final int mFlags;
    
    final int mId;
    
    final String mName;
    
    PopBackStackState(String param1String, int param1Int1, int param1Int2) {
      this.mName = param1String;
      this.mId = param1Int1;
      this.mFlags = param1Int2;
    }
    
    public boolean generateOps(ArrayList<BackStackRecord> param1ArrayList, ArrayList<Boolean> param1ArrayList1) {
      return FragmentManagerImpl.this.popBackStackState(param1ArrayList, param1ArrayList1, this.mName, this.mId, this.mFlags);
    }
  }
  
  static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
    private final boolean mIsBack;
    
    private int mNumPostponed;
    
    private final BackStackRecord mRecord;
    
    StartEnterTransitionListener(BackStackRecord param1BackStackRecord, boolean param1Boolean) {
      this.mIsBack = param1Boolean;
      this.mRecord = param1BackStackRecord;
    }
    
    public void cancelTransaction() {
      this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
    }
    
    public void completeTransaction() {
      boolean bool1;
      boolean bool2 = false;
      if (this.mNumPostponed > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      FragmentManagerImpl fragmentManagerImpl = this.mRecord.mManager;
      int j = fragmentManagerImpl.mAdded.size();
      for (int i = 0; i < j; i++) {
        Fragment fragment = fragmentManagerImpl.mAdded.get(i);
        fragment.setOnStartEnterTransitionListener(null);
        if (bool1 && fragment.isPostponed())
          fragment.startPostponedEnterTransition(); 
      } 
      fragmentManagerImpl = this.mRecord.mManager;
      BackStackRecord backStackRecord = this.mRecord;
      boolean bool = this.mIsBack;
      if (!bool1)
        bool2 = true; 
      fragmentManagerImpl.completeExecute(backStackRecord, bool, bool2, true);
    }
    
    public boolean isReady() {
      return (this.mNumPostponed == 0);
    }
    
    public void onStartEnterTransition() {
      this.mNumPostponed--;
      if (this.mNumPostponed != 0)
        return; 
      this.mRecord.mManager.scheduleCommit();
    }
    
    public void startListening() {
      this.mNumPostponed++;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */