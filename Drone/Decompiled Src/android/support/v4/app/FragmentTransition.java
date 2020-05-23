package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

class FragmentTransition {
  private static final int[] INVERSE_OPS = new int[] { 0, 3, 0, 1, 5, 4, 7, 6 };
  
  private static void addSharedElementsWithMatchingNames(ArrayList<View> paramArrayList, ArrayMap<String, View> paramArrayMap, Collection<String> paramCollection) {
    for (int i = paramArrayMap.size() - 1; i >= 0; i--) {
      View view = (View)paramArrayMap.valueAt(i);
      if (paramCollection.contains(ViewCompat.getTransitionName(view)))
        paramArrayList.add(view); 
    } 
  }
  
  private static void addToFirstInLastOut(BackStackRecord paramBackStackRecord, BackStackRecord.Op paramOp, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_1
    //   1: getfield fragment : Landroid/support/v4/app/Fragment;
    //   4: astore #16
    //   6: aload #16
    //   8: getfield mContainerId : I
    //   11: istore #12
    //   13: iload #12
    //   15: ifne -> 19
    //   18: return
    //   19: iload_3
    //   20: ifeq -> 323
    //   23: getstatic android/support/v4/app/FragmentTransition.INVERSE_OPS : [I
    //   26: aload_1
    //   27: getfield cmd : I
    //   30: iaload
    //   31: istore #8
    //   33: iconst_0
    //   34: istore #14
    //   36: iconst_0
    //   37: istore #10
    //   39: iconst_0
    //   40: istore #11
    //   42: iconst_0
    //   43: istore #9
    //   45: iload #11
    //   47: istore #5
    //   49: iload #14
    //   51: istore #13
    //   53: iload #9
    //   55: istore #6
    //   57: iload #10
    //   59: istore #7
    //   61: iload #8
    //   63: tableswitch default -> 104, 1 -> 394, 2 -> 120, 3 -> 528, 4 -> 448, 5 -> 332, 6 -> 528, 7 -> 394
    //   104: iload #10
    //   106: istore #7
    //   108: iload #9
    //   110: istore #6
    //   112: iload #14
    //   114: istore #13
    //   116: iload #11
    //   118: istore #5
    //   120: aload_2
    //   121: iload #12
    //   123: invokevirtual get : (I)Ljava/lang/Object;
    //   126: checkcast android/support/v4/app/FragmentTransition$FragmentContainerTransition
    //   129: astore #15
    //   131: aload #15
    //   133: astore_1
    //   134: iload #13
    //   136: ifeq -> 164
    //   139: aload #15
    //   141: aload_2
    //   142: iload #12
    //   144: invokestatic ensureContainer : (Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/util/SparseArray;I)Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    //   147: astore_1
    //   148: aload_1
    //   149: aload #16
    //   151: putfield lastIn : Landroid/support/v4/app/Fragment;
    //   154: aload_1
    //   155: iload_3
    //   156: putfield lastInIsPop : Z
    //   159: aload_1
    //   160: aload_0
    //   161: putfield lastInTransaction : Landroid/support/v4/app/BackStackRecord;
    //   164: iload #4
    //   166: ifne -> 241
    //   169: iload #6
    //   171: ifeq -> 241
    //   174: aload_1
    //   175: ifnull -> 192
    //   178: aload_1
    //   179: getfield firstOut : Landroid/support/v4/app/Fragment;
    //   182: aload #16
    //   184: if_acmpne -> 192
    //   187: aload_1
    //   188: aconst_null
    //   189: putfield firstOut : Landroid/support/v4/app/Fragment;
    //   192: aload_0
    //   193: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   196: astore #15
    //   198: aload #16
    //   200: getfield mState : I
    //   203: iconst_1
    //   204: if_icmpge -> 241
    //   207: aload #15
    //   209: getfield mCurState : I
    //   212: iconst_1
    //   213: if_icmplt -> 241
    //   216: aload_0
    //   217: getfield mAllowOptimization : Z
    //   220: ifne -> 241
    //   223: aload #15
    //   225: aload #16
    //   227: invokevirtual makeActive : (Landroid/support/v4/app/Fragment;)V
    //   230: aload #15
    //   232: aload #16
    //   234: iconst_1
    //   235: iconst_0
    //   236: iconst_0
    //   237: iconst_0
    //   238: invokevirtual moveToState : (Landroid/support/v4/app/Fragment;IIIZ)V
    //   241: aload_1
    //   242: astore #15
    //   244: iload #5
    //   246: ifeq -> 291
    //   249: aload_1
    //   250: ifnull -> 263
    //   253: aload_1
    //   254: astore #15
    //   256: aload_1
    //   257: getfield firstOut : Landroid/support/v4/app/Fragment;
    //   260: ifnonnull -> 291
    //   263: aload_1
    //   264: aload_2
    //   265: iload #12
    //   267: invokestatic ensureContainer : (Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/util/SparseArray;I)Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    //   270: astore #15
    //   272: aload #15
    //   274: aload #16
    //   276: putfield firstOut : Landroid/support/v4/app/Fragment;
    //   279: aload #15
    //   281: iload_3
    //   282: putfield firstOutIsPop : Z
    //   285: aload #15
    //   287: aload_0
    //   288: putfield firstOutTransaction : Landroid/support/v4/app/BackStackRecord;
    //   291: iload #4
    //   293: ifne -> 18
    //   296: iload #7
    //   298: ifeq -> 18
    //   301: aload #15
    //   303: ifnull -> 18
    //   306: aload #15
    //   308: getfield lastIn : Landroid/support/v4/app/Fragment;
    //   311: aload #16
    //   313: if_acmpne -> 18
    //   316: aload #15
    //   318: aconst_null
    //   319: putfield lastIn : Landroid/support/v4/app/Fragment;
    //   322: return
    //   323: aload_1
    //   324: getfield cmd : I
    //   327: istore #8
    //   329: goto -> 33
    //   332: iload #4
    //   334: ifeq -> 384
    //   337: aload #16
    //   339: getfield mHiddenChanged : Z
    //   342: ifeq -> 378
    //   345: aload #16
    //   347: getfield mHidden : Z
    //   350: ifne -> 378
    //   353: aload #16
    //   355: getfield mAdded : Z
    //   358: ifeq -> 378
    //   361: iconst_1
    //   362: istore #13
    //   364: iconst_1
    //   365: istore #6
    //   367: iload #11
    //   369: istore #5
    //   371: iload #10
    //   373: istore #7
    //   375: goto -> 120
    //   378: iconst_0
    //   379: istore #13
    //   381: goto -> 364
    //   384: aload #16
    //   386: getfield mHidden : Z
    //   389: istore #13
    //   391: goto -> 364
    //   394: iload #4
    //   396: ifeq -> 420
    //   399: aload #16
    //   401: getfield mIsNewlyAdded : Z
    //   404: istore #13
    //   406: iconst_1
    //   407: istore #6
    //   409: iload #11
    //   411: istore #5
    //   413: iload #10
    //   415: istore #7
    //   417: goto -> 120
    //   420: aload #16
    //   422: getfield mAdded : Z
    //   425: ifne -> 442
    //   428: aload #16
    //   430: getfield mHidden : Z
    //   433: ifne -> 442
    //   436: iconst_1
    //   437: istore #13
    //   439: goto -> 406
    //   442: iconst_0
    //   443: istore #13
    //   445: goto -> 439
    //   448: iload #4
    //   450: ifeq -> 500
    //   453: aload #16
    //   455: getfield mHiddenChanged : Z
    //   458: ifeq -> 494
    //   461: aload #16
    //   463: getfield mAdded : Z
    //   466: ifeq -> 494
    //   469: aload #16
    //   471: getfield mHidden : Z
    //   474: ifeq -> 494
    //   477: iconst_1
    //   478: istore #5
    //   480: iconst_1
    //   481: istore #7
    //   483: iload #14
    //   485: istore #13
    //   487: iload #9
    //   489: istore #6
    //   491: goto -> 120
    //   494: iconst_0
    //   495: istore #5
    //   497: goto -> 480
    //   500: aload #16
    //   502: getfield mAdded : Z
    //   505: ifeq -> 522
    //   508: aload #16
    //   510: getfield mHidden : Z
    //   513: ifne -> 522
    //   516: iconst_1
    //   517: istore #5
    //   519: goto -> 480
    //   522: iconst_0
    //   523: istore #5
    //   525: goto -> 519
    //   528: iload #4
    //   530: ifeq -> 593
    //   533: aload #16
    //   535: getfield mAdded : Z
    //   538: ifne -> 587
    //   541: aload #16
    //   543: getfield mView : Landroid/view/View;
    //   546: ifnull -> 587
    //   549: aload #16
    //   551: getfield mView : Landroid/view/View;
    //   554: invokevirtual getVisibility : ()I
    //   557: ifne -> 587
    //   560: aload #16
    //   562: getfield mPostponedAlpha : F
    //   565: fconst_0
    //   566: fcmpl
    //   567: iflt -> 587
    //   570: iconst_1
    //   571: istore #5
    //   573: iconst_1
    //   574: istore #7
    //   576: iload #14
    //   578: istore #13
    //   580: iload #9
    //   582: istore #6
    //   584: goto -> 120
    //   587: iconst_0
    //   588: istore #5
    //   590: goto -> 573
    //   593: aload #16
    //   595: getfield mAdded : Z
    //   598: ifeq -> 615
    //   601: aload #16
    //   603: getfield mHidden : Z
    //   606: ifne -> 615
    //   609: iconst_1
    //   610: istore #5
    //   612: goto -> 573
    //   615: iconst_0
    //   616: istore #5
    //   618: goto -> 612
  }
  
  public static void calculateFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean) {
    int j = paramBackStackRecord.mOps.size();
    for (int i = 0; i < j; i++)
      addToFirstInLastOut(paramBackStackRecord, paramBackStackRecord.mOps.get(i), paramSparseArray, false, paramBoolean); 
  }
  
  private static ArrayMap<String, String> calculateNameOverrides(int paramInt1, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    label26: while (--paramInt3 >= paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(paramInt3);
      if (!backStackRecord.interactsWith(paramInt1))
        continue; 
      boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
      if (backStackRecord.mSharedElementSourceNames != null) {
        ArrayList<String> arrayList1;
        ArrayList<String> arrayList2;
        int j = backStackRecord.mSharedElementSourceNames.size();
        if (bool) {
          arrayList2 = backStackRecord.mSharedElementSourceNames;
          arrayList1 = backStackRecord.mSharedElementTargetNames;
        } else {
          arrayList1 = backStackRecord.mSharedElementSourceNames;
          arrayList2 = backStackRecord.mSharedElementTargetNames;
        } 
        int i = 0;
        while (true) {
          if (i < j) {
            String str1 = arrayList1.get(i);
            String str2 = arrayList2.get(i);
            String str3 = (String)arrayMap.remove(str2);
            if (str3 != null) {
              arrayMap.put(str1, str3);
            } else {
              arrayMap.put(str1, str2);
            } 
            i++;
            continue;
          } 
          paramInt3--;
          continue label26;
        } 
      } 
      continue;
    } 
    return arrayMap;
  }
  
  public static void calculatePopFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean) {
    if (paramBackStackRecord.mManager.mContainer.onHasView()) {
      int i = paramBackStackRecord.mOps.size() - 1;
      while (true) {
        if (i >= 0) {
          addToFirstInLastOut(paramBackStackRecord, paramBackStackRecord.mOps.get(i), paramSparseArray, true, paramBoolean);
          i--;
          continue;
        } 
        return;
      } 
    } 
  }
  
  private static void callSharedElementStartEnd(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean1, ArrayMap<String, View> paramArrayMap, boolean paramBoolean2) {
    SharedElementCallback sharedElementCallback;
    ArrayList<Object> arrayList1;
    ArrayList<Object> arrayList2;
    if (paramBoolean1) {
      sharedElementCallback = paramFragment2.getEnterTransitionCallback();
    } else {
      sharedElementCallback = sharedElementCallback.getEnterTransitionCallback();
    } 
    if (sharedElementCallback != null) {
      int i;
      arrayList1 = new ArrayList();
      arrayList2 = new ArrayList();
      if (paramArrayMap == null) {
        i = 0;
      } else {
        i = paramArrayMap.size();
      } 
      int j;
      for (j = 0; j < i; j++) {
        arrayList2.add(paramArrayMap.keyAt(j));
        arrayList1.add(paramArrayMap.valueAt(j));
      } 
      if (paramBoolean2) {
        sharedElementCallback.onSharedElementStart(arrayList2, arrayList1, null);
        return;
      } 
    } else {
      return;
    } 
    sharedElementCallback.onSharedElementEnd(arrayList2, arrayList1, null);
  }
  
  private static ArrayMap<String, View> captureInSharedElements(ArrayMap<String, String> paramArrayMap, Object<String> paramObject, FragmentContainerTransition paramFragmentContainerTransition) {
    ArrayList<String> arrayList;
    SharedElementCallback sharedElementCallback;
    Fragment fragment = paramFragmentContainerTransition.lastIn;
    View view = fragment.getView();
    if (paramArrayMap.isEmpty() || paramObject == null || view == null) {
      paramArrayMap.clear();
      return null;
    } 
    ArrayMap<String, View> arrayMap = new ArrayMap();
    FragmentTransitionCompat21.findNamedViews((Map<String, View>)arrayMap, view);
    paramObject = (Object<String>)paramFragmentContainerTransition.lastInTransaction;
    if (paramFragmentContainerTransition.lastInIsPop) {
      sharedElementCallback = fragment.getExitTransitionCallback();
      paramObject = (Object<String>)((BackStackRecord)paramObject).mSharedElementSourceNames;
    } else {
      sharedElementCallback = fragment.getEnterTransitionCallback();
      arrayList = ((BackStackRecord)paramObject).mSharedElementTargetNames;
    } 
    if (arrayList != null)
      arrayMap.retainAll(arrayList); 
    if (sharedElementCallback != null) {
      sharedElementCallback.onMapSharedElements(arrayList, (Map<String, View>)arrayMap);
      int i = arrayList.size() - 1;
      while (true) {
        String str;
        ArrayMap<String, View> arrayMap1 = arrayMap;
        if (i >= 0) {
          String str1 = arrayList.get(i);
          View view1 = (View)arrayMap.get(str1);
          if (view1 == null) {
            str = findKeyForValue(paramArrayMap, str1);
            if (str != null)
              paramArrayMap.remove(str); 
          } else if (!str1.equals(ViewCompat.getTransitionName((View)str))) {
            str1 = findKeyForValue(paramArrayMap, str1);
            if (str1 != null)
              paramArrayMap.put(str1, ViewCompat.getTransitionName((View)str)); 
          } 
          i--;
          continue;
        } 
        return (ArrayMap<String, View>)str;
      } 
    } 
    retainValues(paramArrayMap, arrayMap);
    return arrayMap;
  }
  
  private static ArrayMap<String, View> captureOutSharedElements(ArrayMap<String, String> paramArrayMap, Object<String> paramObject, FragmentContainerTransition paramFragmentContainerTransition) {
    ArrayList<String> arrayList;
    SharedElementCallback sharedElementCallback;
    if (paramArrayMap.isEmpty() || paramObject == null) {
      paramArrayMap.clear();
      return null;
    } 
    Fragment fragment = paramFragmentContainerTransition.firstOut;
    ArrayMap<String, View> arrayMap = new ArrayMap();
    FragmentTransitionCompat21.findNamedViews((Map<String, View>)arrayMap, fragment.getView());
    paramObject = (Object<String>)paramFragmentContainerTransition.firstOutTransaction;
    if (paramFragmentContainerTransition.firstOutIsPop) {
      sharedElementCallback = fragment.getEnterTransitionCallback();
      paramObject = (Object<String>)((BackStackRecord)paramObject).mSharedElementTargetNames;
    } else {
      sharedElementCallback = fragment.getExitTransitionCallback();
      arrayList = ((BackStackRecord)paramObject).mSharedElementSourceNames;
    } 
    arrayMap.retainAll(arrayList);
    if (sharedElementCallback != null) {
      sharedElementCallback.onMapSharedElements(arrayList, (Map<String, View>)arrayMap);
      int i = arrayList.size() - 1;
      while (true) {
        View view;
        ArrayMap<String, View> arrayMap1 = arrayMap;
        if (i >= 0) {
          String str = arrayList.get(i);
          view = (View)arrayMap.get(str);
          if (view == null) {
            paramArrayMap.remove(str);
          } else if (!str.equals(ViewCompat.getTransitionName(view))) {
            str = (String)paramArrayMap.remove(str);
            paramArrayMap.put(ViewCompat.getTransitionName(view), str);
          } 
          i--;
          continue;
        } 
        return (ArrayMap<String, View>)view;
      } 
    } 
    paramArrayMap.retainAll(arrayMap.keySet());
    return arrayMap;
  }
  
  private static ArrayList<View> configureEnteringExitingViews(Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView) {
    ArrayList<View> arrayList = null;
    if (paramObject != null) {
      ArrayList<View> arrayList1 = new ArrayList();
      View view = paramFragment.getView();
      if (view != null)
        FragmentTransitionCompat21.captureTransitioningViews(arrayList1, view); 
      if (paramArrayList != null)
        arrayList1.removeAll(paramArrayList); 
      arrayList = arrayList1;
      if (!arrayList1.isEmpty()) {
        arrayList1.add(paramView);
        FragmentTransitionCompat21.addTargets(paramObject, arrayList1);
        arrayList = arrayList1;
      } 
    } 
    return arrayList;
  }
  
  private static Object configureSharedElementsOptimized(ViewGroup paramViewGroup, final View epicenterView, final ArrayMap<String, String> epicenter, FragmentContainerTransition paramFragmentContainerTransition, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2) {
    Object<String, String> object;
    ArrayMap<String, String> arrayMap;
    final Fragment inFragment = paramFragmentContainerTransition.lastIn;
    final Fragment outFragment = paramFragmentContainerTransition.firstOut;
    if (fragment1 != null)
      fragment1.getView().setVisibility(0); 
    if (fragment1 == null || fragment2 == null)
      return null; 
    final boolean inIsPop = paramFragmentContainerTransition.lastInIsPop;
    if (epicenter.isEmpty()) {
      object = null;
    } else {
      object = (Object<String, String>)getSharedElementTransition(fragment1, fragment2, bool);
    } 
    ArrayMap<String, View> arrayMap2 = captureOutSharedElements(epicenter, object, paramFragmentContainerTransition);
    final ArrayMap<String, View> inSharedElements = captureInSharedElements(epicenter, object, paramFragmentContainerTransition);
    if (epicenter.isEmpty()) {
      epicenter = null;
      if (arrayMap2 != null)
        arrayMap2.clear(); 
      object = (Object<String, String>)epicenter;
      if (arrayMap1 != null) {
        arrayMap1.clear();
        arrayMap = epicenter;
      } 
    } else {
      addSharedElementsWithMatchingNames(paramArrayList1, arrayMap2, epicenter.keySet());
      addSharedElementsWithMatchingNames(paramArrayList2, arrayMap1, epicenter.values());
    } 
    if (paramObject1 == null && paramObject2 == null && arrayMap == null)
      return null; 
    callSharedElementStartEnd(fragment1, fragment2, bool, arrayMap2, true);
    if (arrayMap != null) {
      paramArrayList2.add(epicenterView);
      FragmentTransitionCompat21.setSharedElementTargets(arrayMap, epicenterView, paramArrayList1);
      setOutEpicenter(arrayMap, paramObject2, arrayMap2, paramFragmentContainerTransition.firstOutIsPop, paramFragmentContainerTransition.firstOutTransaction);
      Rect rect2 = new Rect();
      View view = getInEpicenterView(arrayMap1, paramFragmentContainerTransition, paramObject1, bool);
      epicenterView = view;
      final Rect epicenter = rect2;
      if (view != null) {
        FragmentTransitionCompat21.setEpicenter(paramObject1, rect2);
        rect1 = rect2;
        epicenterView = view;
      } 
      OneShotPreDrawListener.add((View)paramViewGroup, new Runnable() {
            public void run() {
              FragmentTransition.callSharedElementStartEnd(inFragment, outFragment, inIsPop, inSharedElements, false);
              if (epicenterView != null)
                FragmentTransitionCompat21.getBoundsOnScreen(epicenterView, epicenter); 
            }
          });
      return arrayMap;
    } 
    epicenter = null;
    epicenterView = null;
    OneShotPreDrawListener.add((View)paramViewGroup, new Runnable() {
          public void run() {
            FragmentTransition.callSharedElementStartEnd(inFragment, outFragment, inIsPop, inSharedElements, false);
            if (epicenterView != null)
              FragmentTransitionCompat21.getBoundsOnScreen(epicenterView, epicenter); 
          }
        });
    return arrayMap;
  }
  
  private static Object configureSharedElementsUnoptimized(ViewGroup paramViewGroup, final View nonExistentView, final ArrayMap<String, String> nameOverrides, final FragmentContainerTransition fragments, final ArrayList<View> sharedElementsOut, final ArrayList<View> sharedElementsIn, final Object enterTransition, final Object inEpicenter) {
    final Object finalSharedElementTransition;
    final Fragment inFragment = fragments.lastIn;
    final Fragment outFragment = fragments.firstOut;
    if (fragment1 == null || fragment2 == null)
      return null; 
    final boolean inIsPop = fragments.lastInIsPop;
    if (nameOverrides.isEmpty()) {
      object = null;
    } else {
      object = getSharedElementTransition(fragment1, fragment2, bool);
    } 
    ArrayMap<String, View> arrayMap = captureOutSharedElements(nameOverrides, object, fragments);
    if (nameOverrides.isEmpty()) {
      object = null;
    } else {
      sharedElementsOut.addAll(arrayMap.values());
    } 
    if (enterTransition == null && inEpicenter == null && object == null)
      return null; 
    callSharedElementStartEnd(fragment1, fragment2, bool, arrayMap, true);
    if (object != null) {
      Rect rect = new Rect();
      FragmentTransitionCompat21.setSharedElementTargets(object, nonExistentView, sharedElementsOut);
      setOutEpicenter(object, inEpicenter, arrayMap, fragments.firstOutIsPop, fragments.firstOutTransaction);
      inEpicenter = rect;
      if (enterTransition != null) {
        FragmentTransitionCompat21.setEpicenter(enterTransition, rect);
        inEpicenter = rect;
      } 
      OneShotPreDrawListener.add((View)paramViewGroup, new Runnable() {
            public void run() {
              ArrayMap arrayMap = FragmentTransition.captureInSharedElements(nameOverrides, finalSharedElementTransition, fragments);
              if (arrayMap != null) {
                sharedElementsIn.addAll(arrayMap.values());
                sharedElementsIn.add(nonExistentView);
              } 
              FragmentTransition.callSharedElementStartEnd(inFragment, outFragment, inIsPop, arrayMap, false);
              if (finalSharedElementTransition != null) {
                FragmentTransitionCompat21.swapSharedElementTargets(finalSharedElementTransition, sharedElementsOut, sharedElementsIn);
                View view = FragmentTransition.getInEpicenterView(arrayMap, fragments, enterTransition, inIsPop);
                if (view != null)
                  FragmentTransitionCompat21.getBoundsOnScreen(view, inEpicenter); 
              } 
            }
          });
      return object;
    } 
    inEpicenter = null;
    OneShotPreDrawListener.add((View)paramViewGroup, new Runnable() {
          public void run() {
            ArrayMap arrayMap = FragmentTransition.captureInSharedElements(nameOverrides, finalSharedElementTransition, fragments);
            if (arrayMap != null) {
              sharedElementsIn.addAll(arrayMap.values());
              sharedElementsIn.add(nonExistentView);
            } 
            FragmentTransition.callSharedElementStartEnd(inFragment, outFragment, inIsPop, arrayMap, false);
            if (finalSharedElementTransition != null) {
              FragmentTransitionCompat21.swapSharedElementTargets(finalSharedElementTransition, sharedElementsOut, sharedElementsIn);
              View view = FragmentTransition.getInEpicenterView(arrayMap, fragments, enterTransition, inIsPop);
              if (view != null)
                FragmentTransitionCompat21.getBoundsOnScreen(view, inEpicenter); 
            } 
          }
        });
    return object;
  }
  
  private static void configureTransitionsOptimized(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap) {
    ViewGroup viewGroup = null;
    if (paramFragmentManagerImpl.mContainer.onHasView())
      viewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.onFindViewById(paramInt); 
    if (viewGroup != null) {
      Fragment fragment2 = paramFragmentContainerTransition.lastIn;
      Fragment fragment1 = paramFragmentContainerTransition.firstOut;
      boolean bool1 = paramFragmentContainerTransition.lastInIsPop;
      boolean bool2 = paramFragmentContainerTransition.firstOutIsPop;
      ArrayList<View> arrayList1 = new ArrayList();
      ArrayList<View> arrayList2 = new ArrayList();
      Object object2 = getEnterTransition(fragment2, bool1);
      Object object3 = getExitTransition(fragment1, bool2);
      Object object1 = configureSharedElementsOptimized(viewGroup, paramView, paramArrayMap, paramFragmentContainerTransition, arrayList2, arrayList1, object2, object3);
      if (object2 != null || object1 != null || object3 != null) {
        ArrayList<View> arrayList4 = configureEnteringExitingViews(object3, fragment1, arrayList2, paramView);
        ArrayList<View> arrayList3 = configureEnteringExitingViews(object2, fragment2, arrayList1, paramView);
        setViewVisibility(arrayList3, 4);
        Object object = mergeTransitions(object2, object3, object1, fragment2, bool1);
        if (object != null) {
          replaceHide(object3, fragment1, arrayList4);
          ArrayList<String> arrayList = FragmentTransitionCompat21.prepareSetNameOverridesOptimized(arrayList1);
          FragmentTransitionCompat21.scheduleRemoveTargets(object, object2, arrayList3, object3, arrayList4, object1, arrayList1);
          FragmentTransitionCompat21.beginDelayedTransition(viewGroup, object);
          FragmentTransitionCompat21.setNameOverridesOptimized((View)viewGroup, arrayList2, arrayList1, arrayList, (Map<String, String>)paramArrayMap);
          setViewVisibility(arrayList3, 0);
          FragmentTransitionCompat21.swapSharedElementTargets(object1, arrayList2, arrayList1);
          return;
        } 
      } 
    } 
  }
  
  private static void configureTransitionsUnoptimized(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap) {
    ViewGroup viewGroup = null;
    if (paramFragmentManagerImpl.mContainer.onHasView())
      viewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.onFindViewById(paramInt); 
    if (viewGroup != null) {
      Fragment fragment1 = paramFragmentContainerTransition.lastIn;
      Fragment fragment2 = paramFragmentContainerTransition.firstOut;
      boolean bool1 = paramFragmentContainerTransition.lastInIsPop;
      boolean bool2 = paramFragmentContainerTransition.firstOutIsPop;
      Object object2 = getEnterTransition(fragment1, bool1);
      Object object1 = getExitTransition(fragment2, bool2);
      ArrayList<View> arrayList2 = new ArrayList();
      ArrayList<View> arrayList1 = new ArrayList();
      Object object3 = configureSharedElementsUnoptimized(viewGroup, paramView, paramArrayMap, paramFragmentContainerTransition, arrayList2, arrayList1, object2, object1);
      if (object2 != null || object3 != null || object1 != null) {
        ArrayList<View> arrayList = configureEnteringExitingViews(object1, fragment2, arrayList2, paramView);
        if (arrayList == null || arrayList.isEmpty())
          object1 = null; 
        FragmentTransitionCompat21.addTarget(object2, paramView);
        Object object = mergeTransitions(object2, object1, object3, fragment1, paramFragmentContainerTransition.lastInIsPop);
        if (object != null) {
          arrayList2 = new ArrayList<View>();
          FragmentTransitionCompat21.scheduleRemoveTargets(object, object2, arrayList2, object1, arrayList, object3, arrayList1);
          scheduleTargetChange(viewGroup, fragment1, paramView, arrayList1, object2, arrayList2, object1, arrayList);
          FragmentTransitionCompat21.setNameOverridesUnoptimized((View)viewGroup, arrayList1, (Map<String, String>)paramArrayMap);
          FragmentTransitionCompat21.beginDelayedTransition(viewGroup, object);
          FragmentTransitionCompat21.scheduleNameReset(viewGroup, arrayList1, (Map<String, String>)paramArrayMap);
          return;
        } 
      } 
    } 
  }
  
  private static FragmentContainerTransition ensureContainer(FragmentContainerTransition paramFragmentContainerTransition, SparseArray<FragmentContainerTransition> paramSparseArray, int paramInt) {
    FragmentContainerTransition fragmentContainerTransition = paramFragmentContainerTransition;
    if (paramFragmentContainerTransition == null) {
      fragmentContainerTransition = new FragmentContainerTransition();
      paramSparseArray.put(paramInt, fragmentContainerTransition);
    } 
    return fragmentContainerTransition;
  }
  
  private static String findKeyForValue(ArrayMap<String, String> paramArrayMap, String paramString) {
    int j = paramArrayMap.size();
    for (int i = 0; i < j; i++) {
      if (paramString.equals(paramArrayMap.valueAt(i)))
        return (String)paramArrayMap.keyAt(i); 
    } 
    return null;
  }
  
  private static Object getEnterTransition(Fragment paramFragment, boolean paramBoolean) {
    if (paramFragment == null)
      return null; 
    if (paramBoolean) {
      object = paramFragment.getReenterTransition();
      return FragmentTransitionCompat21.cloneTransition(object);
    } 
    Object object = object.getEnterTransition();
    return FragmentTransitionCompat21.cloneTransition(object);
  }
  
  private static Object getExitTransition(Fragment paramFragment, boolean paramBoolean) {
    if (paramFragment == null)
      return null; 
    if (paramBoolean) {
      object = paramFragment.getReturnTransition();
      return FragmentTransitionCompat21.cloneTransition(object);
    } 
    Object object = object.getExitTransition();
    return FragmentTransitionCompat21.cloneTransition(object);
  }
  
  private static View getInEpicenterView(ArrayMap<String, View> paramArrayMap, FragmentContainerTransition paramFragmentContainerTransition, Object paramObject, boolean paramBoolean) {
    BackStackRecord backStackRecord = paramFragmentContainerTransition.lastInTransaction;
    if (paramObject != null && paramArrayMap != null && backStackRecord.mSharedElementSourceNames != null && !backStackRecord.mSharedElementSourceNames.isEmpty()) {
      if (paramBoolean) {
        str = backStackRecord.mSharedElementSourceNames.get(0);
        return (View)paramArrayMap.get(str);
      } 
      String str = ((BackStackRecord)str).mSharedElementTargetNames.get(0);
      return (View)paramArrayMap.get(str);
    } 
    return null;
  }
  
  private static Object getSharedElementTransition(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean) {
    if (paramFragment1 == null || paramFragment2 == null)
      return null; 
    if (paramBoolean) {
      object = paramFragment2.getSharedElementReturnTransition();
      return FragmentTransitionCompat21.wrapTransitionInSet(FragmentTransitionCompat21.cloneTransition(object));
    } 
    Object object = object.getSharedElementEnterTransition();
    return FragmentTransitionCompat21.wrapTransitionInSet(FragmentTransitionCompat21.cloneTransition(object));
  }
  
  private static Object mergeTransitions(Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean) {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramObject1 != null) {
      bool1 = bool2;
      if (paramObject2 != null) {
        bool1 = bool2;
        if (paramFragment != null)
          if (paramBoolean) {
            bool1 = paramFragment.getAllowReturnTransitionOverlap();
          } else {
            bool1 = paramFragment.getAllowEnterTransitionOverlap();
          }  
      } 
    } 
    return bool1 ? FragmentTransitionCompat21.mergeTransitionsTogether(paramObject2, paramObject1, paramObject3) : FragmentTransitionCompat21.mergeTransitionsInSequence(paramObject2, paramObject1, paramObject3);
  }
  
  private static void replaceHide(Object paramObject, Fragment paramFragment, final ArrayList<View> exitingViews) {
    if (paramFragment != null && paramObject != null && paramFragment.mAdded && paramFragment.mHidden && paramFragment.mHiddenChanged) {
      paramFragment.setHideReplaced(true);
      FragmentTransitionCompat21.scheduleHideFragmentView(paramObject, paramFragment.getView(), exitingViews);
      OneShotPreDrawListener.add((View)paramFragment.mContainer, new Runnable() {
            public void run() {
              FragmentTransition.setViewVisibility(exitingViews, 4);
            }
          });
    } 
  }
  
  private static void retainValues(ArrayMap<String, String> paramArrayMap, ArrayMap<String, View> paramArrayMap1) {
    for (int i = paramArrayMap.size() - 1; i >= 0; i--) {
      if (!paramArrayMap1.containsKey(paramArrayMap.valueAt(i)))
        paramArrayMap.removeAt(i); 
    } 
  }
  
  private static void scheduleTargetChange(ViewGroup paramViewGroup, final Fragment inFragment, final View nonExistentView, final ArrayList<View> sharedElementsIn, final Object enterTransition, final ArrayList<View> enteringViews, final Object exitTransition, final ArrayList<View> exitingViews) {
    OneShotPreDrawListener.add((View)paramViewGroup, new Runnable() {
          public void run() {
            if (enterTransition != null) {
              FragmentTransitionCompat21.removeTarget(enterTransition, nonExistentView);
              ArrayList arrayList = FragmentTransition.configureEnteringExitingViews(enterTransition, inFragment, sharedElementsIn, nonExistentView);
              enteringViews.addAll(arrayList);
            } 
            if (exitingViews != null) {
              if (exitTransition != null) {
                ArrayList<View> arrayList = new ArrayList();
                arrayList.add(nonExistentView);
                FragmentTransitionCompat21.replaceTargets(exitTransition, exitingViews, arrayList);
              } 
              exitingViews.clear();
              exitingViews.add(nonExistentView);
            } 
          }
        });
  }
  
  private static void setOutEpicenter(Object paramObject1, Object paramObject2, ArrayMap<String, View> paramArrayMap, boolean paramBoolean, BackStackRecord paramBackStackRecord) {
    if (paramBackStackRecord.mSharedElementSourceNames != null && !paramBackStackRecord.mSharedElementSourceNames.isEmpty()) {
      String str;
      if (paramBoolean) {
        str = paramBackStackRecord.mSharedElementTargetNames.get(0);
      } else {
        str = ((BackStackRecord)str).mSharedElementSourceNames.get(0);
      } 
      View view = (View)paramArrayMap.get(str);
      FragmentTransitionCompat21.setEpicenter(paramObject1, view);
      if (paramObject2 != null)
        FragmentTransitionCompat21.setEpicenter(paramObject2, view); 
    } 
  }
  
  private static void setViewVisibility(ArrayList<View> paramArrayList, int paramInt) {
    if (paramArrayList != null) {
      int i = paramArrayList.size() - 1;
      while (true) {
        if (i >= 0) {
          ((View)paramArrayList.get(i)).setVisibility(paramInt);
          i--;
          continue;
        } 
        return;
      } 
    } 
  }
  
  static void startTransitions(FragmentManagerImpl paramFragmentManagerImpl, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramFragmentManagerImpl.mCurState >= 1 && Build.VERSION.SDK_INT >= 21) {
      SparseArray<FragmentContainerTransition> sparseArray = new SparseArray();
      int i;
      for (i = paramInt1; i < paramInt2; i++) {
        BackStackRecord backStackRecord = paramArrayList.get(i);
        if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
          calculatePopFragments(backStackRecord, sparseArray, paramBoolean);
        } else {
          calculateFragments(backStackRecord, sparseArray, paramBoolean);
        } 
      } 
      if (sparseArray.size() != 0) {
        View view = new View(paramFragmentManagerImpl.mHost.getContext());
        int j = sparseArray.size();
        i = 0;
        while (true) {
          if (i < j) {
            int k = sparseArray.keyAt(i);
            ArrayMap<String, String> arrayMap = calculateNameOverrides(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
            FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition)sparseArray.valueAt(i);
            if (paramBoolean) {
              configureTransitionsOptimized(paramFragmentManagerImpl, k, fragmentContainerTransition, view, arrayMap);
            } else {
              configureTransitionsUnoptimized(paramFragmentManagerImpl, k, fragmentContainerTransition, view, arrayMap);
            } 
            i++;
            continue;
          } 
          return;
        } 
      } 
    } 
  }
  
  static class FragmentContainerTransition {
    public Fragment firstOut;
    
    public boolean firstOutIsPop;
    
    public BackStackRecord firstOutTransaction;
    
    public Fragment lastIn;
    
    public boolean lastInIsPop;
    
    public BackStackRecord lastInTransaction;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\FragmentTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */