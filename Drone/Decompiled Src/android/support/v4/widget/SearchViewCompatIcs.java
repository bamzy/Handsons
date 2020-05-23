package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.SearchView;

@TargetApi(14)
@RequiresApi(14)
class SearchViewCompatIcs {
  public static View newSearchView(Context paramContext) {
    return (View)new MySearchView(paramContext);
  }
  
  public static void setImeOptions(View paramView, int paramInt) {
    ((SearchView)paramView).setImeOptions(paramInt);
  }
  
  public static void setInputType(View paramView, int paramInt) {
    ((SearchView)paramView).setInputType(paramInt);
  }
  
  public static class MySearchView extends SearchView {
    public MySearchView(Context param1Context) {
      super(param1Context);
    }
    
    public void onActionViewCollapsed() {
      setQuery("", false);
      super.onActionViewCollapsed();
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\SearchViewCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */