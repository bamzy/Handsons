package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ViewPropertyAnimatorCompat {
  static final ViewPropertyAnimatorCompatImpl IMPL = new BaseViewPropertyAnimatorCompatImpl();
  
  static final int LISTENER_TAG_ID = 2113929216;
  
  private static final String TAG = "ViewAnimatorCompat";
  
  Runnable mEndAction = null;
  
  int mOldLayerType = -1;
  
  Runnable mStartAction = null;
  
  private WeakReference<View> mView;
  
  ViewPropertyAnimatorCompat(View paramView) {
    this.mView = new WeakReference<View>(paramView);
  }
  
  public ViewPropertyAnimatorCompat alpha(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.alpha(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat alphaBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.alphaBy(this, view, paramFloat); 
    return this;
  }
  
  public void cancel() {
    View view = this.mView.get();
    if (view != null)
      IMPL.cancel(this, view); 
  }
  
  public long getDuration() {
    View view = this.mView.get();
    return (view != null) ? IMPL.getDuration(this, view) : 0L;
  }
  
  public Interpolator getInterpolator() {
    View view = this.mView.get();
    return (view != null) ? IMPL.getInterpolator(this, view) : null;
  }
  
  public long getStartDelay() {
    View view = this.mView.get();
    return (view != null) ? IMPL.getStartDelay(this, view) : 0L;
  }
  
  public ViewPropertyAnimatorCompat rotation(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.rotation(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.rotationBy(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationX(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.rotationX(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationXBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.rotationXBy(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationY(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.rotationY(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationYBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.rotationYBy(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleX(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.scaleX(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleXBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.scaleXBy(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleY(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.scaleY(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleYBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.scaleYBy(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat setDuration(long paramLong) {
    View view = this.mView.get();
    if (view != null)
      IMPL.setDuration(this, view, paramLong); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat setInterpolator(Interpolator paramInterpolator) {
    View view = this.mView.get();
    if (view != null)
      IMPL.setInterpolator(this, view, paramInterpolator); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener) {
    View view = this.mView.get();
    if (view != null)
      IMPL.setListener(this, view, paramViewPropertyAnimatorListener); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat setStartDelay(long paramLong) {
    View view = this.mView.get();
    if (view != null)
      IMPL.setStartDelay(this, view, paramLong); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener) {
    View view = this.mView.get();
    if (view != null)
      IMPL.setUpdateListener(this, view, paramViewPropertyAnimatorUpdateListener); 
    return this;
  }
  
  public void start() {
    View view = this.mView.get();
    if (view != null)
      IMPL.start(this, view); 
  }
  
  public ViewPropertyAnimatorCompat translationX(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.translationX(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationXBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.translationXBy(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationY(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.translationY(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationYBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.translationYBy(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationZ(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.translationZ(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationZBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.translationZBy(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat withEndAction(Runnable paramRunnable) {
    View view = this.mView.get();
    if (view != null)
      IMPL.withEndAction(this, view, paramRunnable); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat withLayer() {
    View view = this.mView.get();
    if (view != null)
      IMPL.withLayer(this, view); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat withStartAction(Runnable paramRunnable) {
    View view = this.mView.get();
    if (view != null)
      IMPL.withStartAction(this, view, paramRunnable); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat x(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.x(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat xBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.xBy(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat y(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.y(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat yBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.yBy(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat z(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.z(this, view, paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat zBy(float paramFloat) {
    View view = this.mView.get();
    if (view != null)
      IMPL.zBy(this, view, paramFloat); 
    return this;
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      IMPL = new LollipopViewPropertyAnimatorCompatImpl();
      return;
    } 
    if (i >= 19) {
      IMPL = new KitKatViewPropertyAnimatorCompatImpl();
      return;
    } 
    if (i >= 18) {
      IMPL = new JBMr2ViewPropertyAnimatorCompatImpl();
      return;
    } 
    if (i >= 16) {
      IMPL = new JBViewPropertyAnimatorCompatImpl();
      return;
    } 
    if (i >= 14) {
      IMPL = new ICSViewPropertyAnimatorCompatImpl();
      return;
    } 
  }
  
  static class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {
    WeakHashMap<View, Runnable> mStarterMap = null;
    
    private void postStartMessage(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      Runnable runnable1 = null;
      if (this.mStarterMap != null)
        runnable1 = this.mStarterMap.get(param1View); 
      Runnable runnable2 = runnable1;
      if (runnable1 == null) {
        runnable2 = new Starter(param1ViewPropertyAnimatorCompat, param1View);
        if (this.mStarterMap == null)
          this.mStarterMap = new WeakHashMap<View, Runnable>(); 
        this.mStarterMap.put(param1View, runnable2);
      } 
      param1View.removeCallbacks(runnable2);
      param1View.post(runnable2);
    }
    
    private void removeStartMessage(View param1View) {
      if (this.mStarterMap != null) {
        Runnable runnable = this.mStarterMap.get(param1View);
        if (runnable != null)
          param1View.removeCallbacks(runnable); 
      } 
    }
    
    public void alpha(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void alphaBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void cancel(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public long getDuration(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      return 0L;
    }
    
    public Interpolator getInterpolator(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      return null;
    }
    
    public long getStartDelay(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      return 0L;
    }
    
    public void rotation(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void rotationBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void rotationX(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void rotationXBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void rotationY(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void rotationYBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void scaleX(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void scaleXBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void scaleY(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void scaleYBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void setDuration(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, long param1Long) {}
    
    public void setInterpolator(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, Interpolator param1Interpolator) {}
    
    public void setListener(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, ViewPropertyAnimatorListener param1ViewPropertyAnimatorListener) {
      param1View.setTag(2113929216, param1ViewPropertyAnimatorListener);
    }
    
    public void setStartDelay(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, long param1Long) {}
    
    public void setUpdateListener(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, ViewPropertyAnimatorUpdateListener param1ViewPropertyAnimatorUpdateListener) {}
    
    public void start(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      removeStartMessage(param1View);
      startAnimation(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    void startAnimation(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      Object object = param1View.getTag(2113929216);
      ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
      if (object instanceof ViewPropertyAnimatorListener)
        viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object; 
      object = param1ViewPropertyAnimatorCompat.mStartAction;
      Runnable runnable = param1ViewPropertyAnimatorCompat.mEndAction;
      param1ViewPropertyAnimatorCompat.mStartAction = null;
      param1ViewPropertyAnimatorCompat.mEndAction = null;
      if (object != null)
        object.run(); 
      if (viewPropertyAnimatorListener != null) {
        viewPropertyAnimatorListener.onAnimationStart(param1View);
        viewPropertyAnimatorListener.onAnimationEnd(param1View);
      } 
      if (runnable != null)
        runnable.run(); 
      if (this.mStarterMap != null)
        this.mStarterMap.remove(param1View); 
    }
    
    public void translationX(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void translationXBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void translationY(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void translationYBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void translationZ(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {}
    
    public void translationZBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {}
    
    public void withEndAction(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, Runnable param1Runnable) {
      param1ViewPropertyAnimatorCompat.mEndAction = param1Runnable;
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void withLayer(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {}
    
    public void withStartAction(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, Runnable param1Runnable) {
      param1ViewPropertyAnimatorCompat.mStartAction = param1Runnable;
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void x(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void xBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void y(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void yBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      postStartMessage(param1ViewPropertyAnimatorCompat, param1View);
    }
    
    public void z(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {}
    
    public void zBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {}
    
    class Starter implements Runnable {
      WeakReference<View> mViewRef;
      
      ViewPropertyAnimatorCompat mVpa;
      
      Starter(ViewPropertyAnimatorCompat param2ViewPropertyAnimatorCompat, View param2View) {
        this.mViewRef = new WeakReference<View>(param2View);
        this.mVpa = param2ViewPropertyAnimatorCompat;
      }
      
      public void run() {
        View view = this.mViewRef.get();
        if (view != null)
          ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl.this.startAnimation(this.mVpa, view); 
      }
    }
  }
  
  class Starter implements Runnable {
    WeakReference<View> mViewRef;
    
    ViewPropertyAnimatorCompat mVpa;
    
    Starter(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      this.mViewRef = new WeakReference<View>(param1View);
      this.mVpa = param1ViewPropertyAnimatorCompat;
    }
    
    public void run() {
      View view = this.mViewRef.get();
      if (view != null)
        this.this$0.startAnimation(this.mVpa, view); 
    }
  }
  
  static class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {
    WeakHashMap<View, Integer> mLayerMap = null;
    
    public void alpha(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.alpha(param1View, param1Float);
    }
    
    public void alphaBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.alphaBy(param1View, param1Float);
    }
    
    public void cancel(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      ViewPropertyAnimatorCompatICS.cancel(param1View);
    }
    
    public long getDuration(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      return ViewPropertyAnimatorCompatICS.getDuration(param1View);
    }
    
    public long getStartDelay(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      return ViewPropertyAnimatorCompatICS.getStartDelay(param1View);
    }
    
    public void rotation(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.rotation(param1View, param1Float);
    }
    
    public void rotationBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.rotationBy(param1View, param1Float);
    }
    
    public void rotationX(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.rotationX(param1View, param1Float);
    }
    
    public void rotationXBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.rotationXBy(param1View, param1Float);
    }
    
    public void rotationY(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.rotationY(param1View, param1Float);
    }
    
    public void rotationYBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.rotationYBy(param1View, param1Float);
    }
    
    public void scaleX(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.scaleX(param1View, param1Float);
    }
    
    public void scaleXBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.scaleXBy(param1View, param1Float);
    }
    
    public void scaleY(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.scaleY(param1View, param1Float);
    }
    
    public void scaleYBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.scaleYBy(param1View, param1Float);
    }
    
    public void setDuration(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, long param1Long) {
      ViewPropertyAnimatorCompatICS.setDuration(param1View, param1Long);
    }
    
    public void setInterpolator(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, Interpolator param1Interpolator) {
      ViewPropertyAnimatorCompatICS.setInterpolator(param1View, param1Interpolator);
    }
    
    public void setListener(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, ViewPropertyAnimatorListener param1ViewPropertyAnimatorListener) {
      param1View.setTag(2113929216, param1ViewPropertyAnimatorListener);
      ViewPropertyAnimatorCompatICS.setListener(param1View, new MyVpaListener(param1ViewPropertyAnimatorCompat));
    }
    
    public void setStartDelay(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, long param1Long) {
      ViewPropertyAnimatorCompatICS.setStartDelay(param1View, param1Long);
    }
    
    public void start(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      ViewPropertyAnimatorCompatICS.start(param1View);
    }
    
    public void translationX(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.translationX(param1View, param1Float);
    }
    
    public void translationXBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.translationXBy(param1View, param1Float);
    }
    
    public void translationY(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.translationY(param1View, param1Float);
    }
    
    public void translationYBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.translationYBy(param1View, param1Float);
    }
    
    public void withEndAction(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, Runnable param1Runnable) {
      ViewPropertyAnimatorCompatICS.setListener(param1View, new MyVpaListener(param1ViewPropertyAnimatorCompat));
      param1ViewPropertyAnimatorCompat.mEndAction = param1Runnable;
    }
    
    public void withLayer(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      param1ViewPropertyAnimatorCompat.mOldLayerType = ViewCompat.getLayerType(param1View);
      ViewPropertyAnimatorCompatICS.setListener(param1View, new MyVpaListener(param1ViewPropertyAnimatorCompat));
    }
    
    public void withStartAction(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, Runnable param1Runnable) {
      ViewPropertyAnimatorCompatICS.setListener(param1View, new MyVpaListener(param1ViewPropertyAnimatorCompat));
      param1ViewPropertyAnimatorCompat.mStartAction = param1Runnable;
    }
    
    public void x(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.x(param1View, param1Float);
    }
    
    public void xBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.xBy(param1View, param1Float);
    }
    
    public void y(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.y(param1View, param1Float);
    }
    
    public void yBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatICS.yBy(param1View, param1Float);
    }
    
    static class MyVpaListener implements ViewPropertyAnimatorListener {
      boolean mAnimEndCalled;
      
      ViewPropertyAnimatorCompat mVpa;
      
      MyVpaListener(ViewPropertyAnimatorCompat param2ViewPropertyAnimatorCompat) {
        this.mVpa = param2ViewPropertyAnimatorCompat;
      }
      
      public void onAnimationCancel(View param2View) {
        Object object = param2View.getTag(2113929216);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
        if (object instanceof ViewPropertyAnimatorListener)
          viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object; 
        if (viewPropertyAnimatorListener != null)
          viewPropertyAnimatorListener.onAnimationCancel(param2View); 
      }
      
      public void onAnimationEnd(View param2View) {
        if (this.mVpa.mOldLayerType >= 0) {
          ViewCompat.setLayerType(param2View, this.mVpa.mOldLayerType, null);
          this.mVpa.mOldLayerType = -1;
        } 
        if (Build.VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
          if (this.mVpa.mEndAction != null) {
            Runnable runnable = this.mVpa.mEndAction;
            this.mVpa.mEndAction = null;
            runnable.run();
          } 
          Object object = param2View.getTag(2113929216);
          ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
          if (object instanceof ViewPropertyAnimatorListener)
            viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object; 
          if (viewPropertyAnimatorListener != null)
            viewPropertyAnimatorListener.onAnimationEnd(param2View); 
          this.mAnimEndCalled = true;
        } 
      }
      
      public void onAnimationStart(View param2View) {
        this.mAnimEndCalled = false;
        if (this.mVpa.mOldLayerType >= 0)
          ViewCompat.setLayerType(param2View, 2, null); 
        if (this.mVpa.mStartAction != null) {
          Runnable runnable = this.mVpa.mStartAction;
          this.mVpa.mStartAction = null;
          runnable.run();
        } 
        Object object = param2View.getTag(2113929216);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
        if (object instanceof ViewPropertyAnimatorListener)
          viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object; 
        if (viewPropertyAnimatorListener != null)
          viewPropertyAnimatorListener.onAnimationStart(param2View); 
      }
    }
  }
  
  static class MyVpaListener implements ViewPropertyAnimatorListener {
    boolean mAnimEndCalled;
    
    ViewPropertyAnimatorCompat mVpa;
    
    MyVpaListener(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat) {
      this.mVpa = param1ViewPropertyAnimatorCompat;
    }
    
    public void onAnimationCancel(View param1View) {
      Object object = param1View.getTag(2113929216);
      ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
      if (object instanceof ViewPropertyAnimatorListener)
        viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object; 
      if (viewPropertyAnimatorListener != null)
        viewPropertyAnimatorListener.onAnimationCancel(param1View); 
    }
    
    public void onAnimationEnd(View param1View) {
      if (this.mVpa.mOldLayerType >= 0) {
        ViewCompat.setLayerType(param1View, this.mVpa.mOldLayerType, null);
        this.mVpa.mOldLayerType = -1;
      } 
      if (Build.VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
        if (this.mVpa.mEndAction != null) {
          Runnable runnable = this.mVpa.mEndAction;
          this.mVpa.mEndAction = null;
          runnable.run();
        } 
        Object object = param1View.getTag(2113929216);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
        if (object instanceof ViewPropertyAnimatorListener)
          viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object; 
        if (viewPropertyAnimatorListener != null)
          viewPropertyAnimatorListener.onAnimationEnd(param1View); 
        this.mAnimEndCalled = true;
      } 
    }
    
    public void onAnimationStart(View param1View) {
      this.mAnimEndCalled = false;
      if (this.mVpa.mOldLayerType >= 0)
        ViewCompat.setLayerType(param1View, 2, null); 
      if (this.mVpa.mStartAction != null) {
        Runnable runnable = this.mVpa.mStartAction;
        this.mVpa.mStartAction = null;
        runnable.run();
      } 
      Object object = param1View.getTag(2113929216);
      ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
      if (object instanceof ViewPropertyAnimatorListener)
        viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object; 
      if (viewPropertyAnimatorListener != null)
        viewPropertyAnimatorListener.onAnimationStart(param1View); 
    }
  }
  
  static class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl {
    public Interpolator getInterpolator(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(param1View);
    }
  }
  
  static class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl {
    public void setListener(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, ViewPropertyAnimatorListener param1ViewPropertyAnimatorListener) {
      ViewPropertyAnimatorCompatJB.setListener(param1View, param1ViewPropertyAnimatorListener);
    }
    
    public void withEndAction(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, Runnable param1Runnable) {
      ViewPropertyAnimatorCompatJB.withEndAction(param1View, param1Runnable);
    }
    
    public void withLayer(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View) {
      ViewPropertyAnimatorCompatJB.withLayer(param1View);
    }
    
    public void withStartAction(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, Runnable param1Runnable) {
      ViewPropertyAnimatorCompatJB.withStartAction(param1View, param1Runnable);
    }
  }
  
  static class KitKatViewPropertyAnimatorCompatImpl extends JBMr2ViewPropertyAnimatorCompatImpl {
    public void setUpdateListener(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, ViewPropertyAnimatorUpdateListener param1ViewPropertyAnimatorUpdateListener) {
      ViewPropertyAnimatorCompatKK.setUpdateListener(param1View, param1ViewPropertyAnimatorUpdateListener);
    }
  }
  
  static class LollipopViewPropertyAnimatorCompatImpl extends KitKatViewPropertyAnimatorCompatImpl {
    public void translationZ(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatLollipop.translationZ(param1View, param1Float);
    }
    
    public void translationZBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatLollipop.translationZBy(param1View, param1Float);
    }
    
    public void z(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatLollipop.z(param1View, param1Float);
    }
    
    public void zBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float) {
      ViewPropertyAnimatorCompatLollipop.zBy(param1View, param1Float);
    }
  }
  
  static interface ViewPropertyAnimatorCompatImpl {
    void alpha(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void alphaBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void cancel(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View);
    
    long getDuration(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View);
    
    Interpolator getInterpolator(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View);
    
    long getStartDelay(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View);
    
    void rotation(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void rotationBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void rotationX(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void rotationXBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void rotationY(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void rotationYBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void scaleX(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void scaleXBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void scaleY(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void scaleYBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void setDuration(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, long param1Long);
    
    void setInterpolator(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, Interpolator param1Interpolator);
    
    void setListener(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, ViewPropertyAnimatorListener param1ViewPropertyAnimatorListener);
    
    void setStartDelay(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, long param1Long);
    
    void setUpdateListener(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, ViewPropertyAnimatorUpdateListener param1ViewPropertyAnimatorUpdateListener);
    
    void start(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View);
    
    void translationX(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void translationXBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void translationY(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void translationYBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void translationZ(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void translationZBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void withEndAction(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, Runnable param1Runnable);
    
    void withLayer(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View);
    
    void withStartAction(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, Runnable param1Runnable);
    
    void x(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void xBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void y(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void yBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void z(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
    
    void zBy(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat, View param1View, float param1Float);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\ViewPropertyAnimatorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */