package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

@TargetApi(9)
@RequiresApi(9)
class LayoutInflaterCompatBase {
  static LayoutInflaterFactory getFactory(LayoutInflater paramLayoutInflater) {
    LayoutInflater.Factory factory = paramLayoutInflater.getFactory();
    return (factory instanceof FactoryWrapper) ? ((FactoryWrapper)factory).mDelegateFactory : null;
  }
  
  static void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory) {
    if (paramLayoutInflaterFactory != null) {
      FactoryWrapper factoryWrapper = new FactoryWrapper(paramLayoutInflaterFactory);
    } else {
      paramLayoutInflaterFactory = null;
    } 
    paramLayoutInflater.setFactory((LayoutInflater.Factory)paramLayoutInflaterFactory);
  }
  
  static class FactoryWrapper implements LayoutInflater.Factory {
    final LayoutInflaterFactory mDelegateFactory;
    
    FactoryWrapper(LayoutInflaterFactory param1LayoutInflaterFactory) {
      this.mDelegateFactory = param1LayoutInflaterFactory;
    }
    
    public View onCreateView(String param1String, Context param1Context, AttributeSet param1AttributeSet) {
      return this.mDelegateFactory.onCreateView(null, param1String, param1Context, param1AttributeSet);
    }
    
    public String toString() {
      return getClass().getName() + "{" + this.mDelegateFactory + "}";
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\view\LayoutInflaterCompatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */