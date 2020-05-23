package android.support.v4.app;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@TargetApi(21)
@RequiresApi(21)
class FragmentTransitionCompat21 {
  public static void addTarget(Object paramObject, View paramView) {
    if (paramObject != null)
      ((Transition)paramObject).addTarget(paramView); 
  }
  
  public static void addTargets(Object paramObject, ArrayList<View> paramArrayList) {
    paramObject = paramObject;
    if (paramObject != null) {
      if (paramObject instanceof TransitionSet) {
        paramObject = paramObject;
        int j = paramObject.getTransitionCount();
        int i = 0;
        while (true) {
          if (i < j) {
            addTargets(paramObject.getTransitionAt(i), paramArrayList);
            i++;
            continue;
          } 
          return;
        } 
      } 
      if (!hasSimpleTarget((Transition)paramObject) && isNullOrEmpty(paramObject.getTargets())) {
        int j = paramArrayList.size();
        int i = 0;
        while (true) {
          if (i < j) {
            paramObject.addTarget(paramArrayList.get(i));
            i++;
            continue;
          } 
          return;
        } 
      } 
    } 
  }
  
  public static void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject) {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }
  
  private static void bfsAddViewChildren(List<View> paramList, View paramView) {
    int i = paramList.size();
    if (!containedBeforeIndex(paramList, paramView, i)) {
      paramList.add(paramView);
      int j = i;
      while (true) {
        if (j < paramList.size()) {
          paramView = paramList.get(j);
          if (paramView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup)paramView;
            int m = viewGroup.getChildCount();
            for (int k = 0; k < m; k++) {
              View view = viewGroup.getChildAt(k);
              if (!containedBeforeIndex(paramList, view, i))
                paramList.add(view); 
            } 
          } 
          j++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public static void captureTransitioningViews(ArrayList<View> paramArrayList, View paramView) {
    ViewGroup viewGroup;
    if (paramView.getVisibility() == 0) {
      if (paramView instanceof ViewGroup) {
        viewGroup = (ViewGroup)paramView;
        if (viewGroup.isTransitionGroup()) {
          paramArrayList.add(viewGroup);
          return;
        } 
        int j = viewGroup.getChildCount();
        int i = 0;
        while (true) {
          if (i < j) {
            captureTransitioningViews(paramArrayList, viewGroup.getChildAt(i));
            i++;
            continue;
          } 
          return;
        } 
      } 
    } else {
      return;
    } 
    paramArrayList.add(viewGroup);
  }
  
  public static Object cloneTransition(Object paramObject) {
    Transition transition = null;
    if (paramObject != null)
      transition = ((Transition)paramObject).clone(); 
    return transition;
  }
  
  private static boolean containedBeforeIndex(List<View> paramList, View paramView, int paramInt) {
    for (int i = 0; i < paramInt; i++) {
      if (paramList.get(i) == paramView)
        return true; 
    } 
    return false;
  }
  
  private static String findKeyForValue(Map<String, String> paramMap, String paramString) {
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      if (paramString.equals(entry.getValue()))
        return (String)entry.getKey(); 
    } 
    return null;
  }
  
  public static void findNamedViews(Map<String, View> paramMap, View paramView) {
    if (paramView.getVisibility() == 0) {
      String str = paramView.getTransitionName();
      if (str != null)
        paramMap.put(str, paramView); 
      if (paramView instanceof ViewGroup) {
        ViewGroup viewGroup = (ViewGroup)paramView;
        int j = viewGroup.getChildCount();
        for (int i = 0; i < j; i++)
          findNamedViews(paramMap, viewGroup.getChildAt(i)); 
      } 
    } 
  }
  
  public static void getBoundsOnScreen(View paramView, Rect paramRect) {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  private static boolean hasSimpleTarget(Transition paramTransition) {
    return (!isNullOrEmpty(paramTransition.getTargetIds()) || !isNullOrEmpty(paramTransition.getTargetNames()) || !isNullOrEmpty(paramTransition.getTargetTypes()));
  }
  
  private static boolean isNullOrEmpty(List paramList) {
    return (paramList == null || paramList.isEmpty());
  }
  
  public static Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3) {
    Object object = null;
    paramObject1 = paramObject1;
    paramObject2 = paramObject2;
    paramObject3 = paramObject3;
    if (paramObject1 != null && paramObject2 != null) {
      paramObject1 = (new TransitionSet()).addTransition((Transition)paramObject1).addTransition((Transition)paramObject2).setOrdering(1);
    } else if (paramObject1 == null) {
      paramObject1 = object;
      if (paramObject2 != null)
        paramObject1 = paramObject2; 
    } 
    if (paramObject3 != null) {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null)
        paramObject2.addTransition((Transition)paramObject1); 
      paramObject2.addTransition((Transition)paramObject3);
      return paramObject2;
    } 
    return paramObject1;
  }
  
  public static Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3) {
    TransitionSet transitionSet = new TransitionSet();
    if (paramObject1 != null)
      transitionSet.addTransition((Transition)paramObject1); 
    if (paramObject2 != null)
      transitionSet.addTransition((Transition)paramObject2); 
    if (paramObject3 != null)
      transitionSet.addTransition((Transition)paramObject3); 
    return transitionSet;
  }
  
  public static ArrayList<String> prepareSetNameOverridesOptimized(ArrayList<View> paramArrayList) {
    ArrayList<String> arrayList = new ArrayList();
    int j = paramArrayList.size();
    for (int i = 0; i < j; i++) {
      View view = paramArrayList.get(i);
      arrayList.add(view.getTransitionName());
      view.setTransitionName(null);
    } 
    return arrayList;
  }
  
  public static void removeTarget(Object paramObject, View paramView) {
    if (paramObject != null)
      ((Transition)paramObject).removeTarget(paramView); 
  }
  
  public static void replaceTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2) {
    paramObject = paramObject;
    if (paramObject instanceof TransitionSet) {
      paramObject = paramObject;
      int j = paramObject.getTransitionCount();
      for (int i = 0; i < j; i++)
        replaceTargets(paramObject.getTransitionAt(i), paramArrayList1, paramArrayList2); 
    } else if (!hasSimpleTarget((Transition)paramObject)) {
      List list = paramObject.getTargets();
      if (list != null && list.size() == paramArrayList1.size() && list.containsAll(paramArrayList1)) {
        if (paramArrayList2 == null) {
          i = 0;
        } else {
          i = paramArrayList2.size();
        } 
        int j;
        for (j = 0; j < i; j++)
          paramObject.addTarget(paramArrayList2.get(j)); 
        for (int i = paramArrayList1.size() - 1; i >= 0; i--)
          paramObject.removeTarget(paramArrayList1.get(i)); 
      } 
    } 
  }
  
  public static void scheduleHideFragmentView(Object paramObject, final View fragmentView, final ArrayList<View> exitingViews) {
    ((Transition)paramObject).addListener(new Transition.TransitionListener() {
          public void onTransitionCancel(Transition param1Transition) {}
          
          public void onTransitionEnd(Transition param1Transition) {
            param1Transition.removeListener(this);
            fragmentView.setVisibility(8);
            int j = exitingViews.size();
            for (int i = 0; i < j; i++)
              ((View)exitingViews.get(i)).setVisibility(0); 
          }
          
          public void onTransitionPause(Transition param1Transition) {}
          
          public void onTransitionResume(Transition param1Transition) {}
          
          public void onTransitionStart(Transition param1Transition) {}
        });
  }
  
  public static void scheduleNameReset(ViewGroup paramViewGroup, final ArrayList<View> sharedElementsIn, final Map<String, String> nameOverrides) {
    OneShotPreDrawListener.add((View)paramViewGroup, new Runnable() {
          public void run() {
            int j = sharedElementsIn.size();
            for (int i = 0; i < j; i++) {
              View view = sharedElementsIn.get(i);
              String str = view.getTransitionName();
              view.setTransitionName((String)nameOverrides.get(str));
            } 
          }
        });
  }
  
  public static void scheduleRemoveTargets(Object paramObject1, final Object enterTransition, final ArrayList<View> enteringViews, final Object exitTransition, final ArrayList<View> exitingViews, final Object sharedElementTransition, final ArrayList<View> sharedElementsIn) {
    ((Transition)paramObject1).addListener(new Transition.TransitionListener() {
          public void onTransitionCancel(Transition param1Transition) {}
          
          public void onTransitionEnd(Transition param1Transition) {}
          
          public void onTransitionPause(Transition param1Transition) {}
          
          public void onTransitionResume(Transition param1Transition) {}
          
          public void onTransitionStart(Transition param1Transition) {
            if (enterTransition != null)
              FragmentTransitionCompat21.replaceTargets(enterTransition, enteringViews, null); 
            if (exitTransition != null)
              FragmentTransitionCompat21.replaceTargets(exitTransition, exitingViews, null); 
            if (sharedElementTransition != null)
              FragmentTransitionCompat21.replaceTargets(sharedElementTransition, sharedElementsIn, null); 
          }
        });
  }
  
  public static void setEpicenter(Object paramObject, final Rect epicenter) {
    if (paramObject != null)
      ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback() {
            public Rect onGetEpicenter(Transition param1Transition) {
              return (epicenter == null || epicenter.isEmpty()) ? null : epicenter;
            }
          }); 
  }
  
  public static void setEpicenter(Object paramObject, View paramView) {
    if (paramView != null) {
      paramObject = paramObject;
      final Rect epicenter = new Rect();
      getBoundsOnScreen(paramView, rect);
      paramObject.setEpicenterCallback(new Transition.EpicenterCallback() {
            public Rect onGetEpicenter(Transition param1Transition) {
              return epicenter;
            }
          });
    } 
  }
  
  public static void setNameOverridesOptimized(View paramView, final ArrayList<View> sharedElementsOut, final ArrayList<View> sharedElementsIn, final ArrayList<String> inNames, Map<String, String> paramMap) {
    final int numSharedElements = sharedElementsIn.size();
    final ArrayList<String> outNames = new ArrayList();
    int i = 0;
    label18: while (i < j) {
      View view = sharedElementsOut.get(i);
      String str1 = view.getTransitionName();
      arrayList.add(str1);
      if (str1 == null)
        continue; 
      view.setTransitionName(null);
      String str2 = paramMap.get(str1);
      int k = 0;
      while (true) {
        if (k < j)
          if (str2.equals(inNames.get(k))) {
            ((View)sharedElementsIn.get(k)).setTransitionName(str1);
          } else {
            k++;
            continue;
          }  
        i++;
        continue label18;
      } 
    } 
    OneShotPreDrawListener.add(paramView, new Runnable() {
          public void run() {
            for (int i = 0; i < numSharedElements; i++) {
              ((View)sharedElementsIn.get(i)).setTransitionName(inNames.get(i));
              ((View)sharedElementsOut.get(i)).setTransitionName(outNames.get(i));
            } 
          }
        });
  }
  
  public static void setNameOverridesUnoptimized(View paramView, final ArrayList<View> sharedElementsIn, final Map<String, String> nameOverrides) {
    OneShotPreDrawListener.add(paramView, new Runnable() {
          public void run() {
            int j = sharedElementsIn.size();
            for (int i = 0; i < j; i++) {
              View view = sharedElementsIn.get(i);
              String str = view.getTransitionName();
              if (str != null)
                view.setTransitionName(FragmentTransitionCompat21.findKeyForValue(nameOverrides, str)); 
            } 
          }
        });
  }
  
  public static void setSharedElementTargets(Object paramObject, View paramView, ArrayList<View> paramArrayList) {
    paramObject = paramObject;
    List<View> list = paramObject.getTargets();
    list.clear();
    int j = paramArrayList.size();
    for (int i = 0; i < j; i++)
      bfsAddViewChildren(list, paramArrayList.get(i)); 
    list.add(paramView);
    paramArrayList.add(paramView);
    addTargets(paramObject, paramArrayList);
  }
  
  public static void swapSharedElementTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2) {
    paramObject = paramObject;
    if (paramObject != null) {
      paramObject.getTargets().clear();
      paramObject.getTargets().addAll(paramArrayList2);
      replaceTargets(paramObject, paramArrayList1, paramArrayList2);
    } 
  }
  
  public static Object wrapTransitionInSet(Object paramObject) {
    if (paramObject == null)
      return null; 
    TransitionSet transitionSet = new TransitionSet();
    transitionSet.addTransition((Transition)paramObject);
    return transitionSet;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\FragmentTransitionCompat21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */