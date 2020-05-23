package android.support.v4.app;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

abstract class BaseFragmentActivityHoneycomb extends BaseFragmentActivityGingerbread {
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    View view2 = dispatchFragmentsOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
    View view1 = view2;
    if (view2 == null) {
      view1 = view2;
      if (Build.VERSION.SDK_INT >= 11)
        view1 = super.onCreateView(paramView, paramString, paramContext, paramAttributeSet); 
    } 
    return view1;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\BaseFragmentActivityHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */