package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.view.View;

public final class SearchViewCompat {
  private static final SearchViewCompatImpl IMPL = new SearchViewCompatStubImpl();
  
  private SearchViewCompat(Context paramContext) {}
  
  public static CharSequence getQuery(View paramView) {
    return IMPL.getQuery(paramView);
  }
  
  public static boolean isIconified(View paramView) {
    return IMPL.isIconified(paramView);
  }
  
  public static boolean isQueryRefinementEnabled(View paramView) {
    return IMPL.isQueryRefinementEnabled(paramView);
  }
  
  public static boolean isSubmitButtonEnabled(View paramView) {
    return IMPL.isSubmitButtonEnabled(paramView);
  }
  
  public static View newSearchView(Context paramContext) {
    return IMPL.newSearchView(paramContext);
  }
  
  public static void setIconified(View paramView, boolean paramBoolean) {
    IMPL.setIconified(paramView, paramBoolean);
  }
  
  public static void setImeOptions(View paramView, int paramInt) {
    IMPL.setImeOptions(paramView, paramInt);
  }
  
  public static void setInputType(View paramView, int paramInt) {
    IMPL.setInputType(paramView, paramInt);
  }
  
  public static void setMaxWidth(View paramView, int paramInt) {
    IMPL.setMaxWidth(paramView, paramInt);
  }
  
  public static void setOnCloseListener(View paramView, OnCloseListener paramOnCloseListener) {
    IMPL.setOnCloseListener(paramView, paramOnCloseListener);
  }
  
  public static void setOnQueryTextListener(View paramView, OnQueryTextListener paramOnQueryTextListener) {
    IMPL.setOnQueryTextListener(paramView, paramOnQueryTextListener);
  }
  
  public static void setQuery(View paramView, CharSequence paramCharSequence, boolean paramBoolean) {
    IMPL.setQuery(paramView, paramCharSequence, paramBoolean);
  }
  
  public static void setQueryHint(View paramView, CharSequence paramCharSequence) {
    IMPL.setQueryHint(paramView, paramCharSequence);
  }
  
  public static void setQueryRefinementEnabled(View paramView, boolean paramBoolean) {
    IMPL.setQueryRefinementEnabled(paramView, paramBoolean);
  }
  
  public static void setSearchableInfo(View paramView, ComponentName paramComponentName) {
    IMPL.setSearchableInfo(paramView, paramComponentName);
  }
  
  public static void setSubmitButtonEnabled(View paramView, boolean paramBoolean) {
    IMPL.setSubmitButtonEnabled(paramView, paramBoolean);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new SearchViewCompatIcsImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 11) {
      IMPL = new SearchViewCompatHoneycombImpl();
      return;
    } 
  }
  
  public static interface OnCloseListener {
    boolean onClose();
  }
  
  @Deprecated
  public static abstract class OnCloseListenerCompat implements OnCloseListener {
    public boolean onClose() {
      return false;
    }
  }
  
  public static interface OnQueryTextListener {
    boolean onQueryTextChange(String param1String);
    
    boolean onQueryTextSubmit(String param1String);
  }
  
  @Deprecated
  public static abstract class OnQueryTextListenerCompat implements OnQueryTextListener {
    public boolean onQueryTextChange(String param1String) {
      return false;
    }
    
    public boolean onQueryTextSubmit(String param1String) {
      return false;
    }
  }
  
  static class SearchViewCompatHoneycombImpl extends SearchViewCompatStubImpl {
    protected void checkIfLegalArg(View param1View) {
      SearchViewCompatHoneycomb.checkIfLegalArg(param1View);
    }
    
    public CharSequence getQuery(View param1View) {
      checkIfLegalArg(param1View);
      return SearchViewCompatHoneycomb.getQuery(param1View);
    }
    
    public boolean isIconified(View param1View) {
      checkIfLegalArg(param1View);
      return SearchViewCompatHoneycomb.isIconified(param1View);
    }
    
    public boolean isQueryRefinementEnabled(View param1View) {
      checkIfLegalArg(param1View);
      return SearchViewCompatHoneycomb.isQueryRefinementEnabled(param1View);
    }
    
    public boolean isSubmitButtonEnabled(View param1View) {
      checkIfLegalArg(param1View);
      return SearchViewCompatHoneycomb.isSubmitButtonEnabled(param1View);
    }
    
    public Object newOnCloseListener(final SearchViewCompat.OnCloseListener listener) {
      return SearchViewCompatHoneycomb.newOnCloseListener(new SearchViewCompatHoneycomb.OnCloseListenerCompatBridge() {
            public boolean onClose() {
              return listener.onClose();
            }
          });
    }
    
    public Object newOnQueryTextListener(final SearchViewCompat.OnQueryTextListener listener) {
      return SearchViewCompatHoneycomb.newOnQueryTextListener(new SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge() {
            public boolean onQueryTextChange(String param2String) {
              return listener.onQueryTextChange(param2String);
            }
            
            public boolean onQueryTextSubmit(String param2String) {
              return listener.onQueryTextSubmit(param2String);
            }
          });
    }
    
    public View newSearchView(Context param1Context) {
      return SearchViewCompatHoneycomb.newSearchView(param1Context);
    }
    
    public void setIconified(View param1View, boolean param1Boolean) {
      checkIfLegalArg(param1View);
      SearchViewCompatHoneycomb.setIconified(param1View, param1Boolean);
    }
    
    public void setMaxWidth(View param1View, int param1Int) {
      checkIfLegalArg(param1View);
      SearchViewCompatHoneycomb.setMaxWidth(param1View, param1Int);
    }
    
    public void setOnCloseListener(View param1View, SearchViewCompat.OnCloseListener param1OnCloseListener) {
      checkIfLegalArg(param1View);
      SearchViewCompatHoneycomb.setOnCloseListener(param1View, newOnCloseListener(param1OnCloseListener));
    }
    
    public void setOnQueryTextListener(View param1View, SearchViewCompat.OnQueryTextListener param1OnQueryTextListener) {
      checkIfLegalArg(param1View);
      SearchViewCompatHoneycomb.setOnQueryTextListener(param1View, newOnQueryTextListener(param1OnQueryTextListener));
    }
    
    public void setQuery(View param1View, CharSequence param1CharSequence, boolean param1Boolean) {
      checkIfLegalArg(param1View);
      SearchViewCompatHoneycomb.setQuery(param1View, param1CharSequence, param1Boolean);
    }
    
    public void setQueryHint(View param1View, CharSequence param1CharSequence) {
      checkIfLegalArg(param1View);
      SearchViewCompatHoneycomb.setQueryHint(param1View, param1CharSequence);
    }
    
    public void setQueryRefinementEnabled(View param1View, boolean param1Boolean) {
      checkIfLegalArg(param1View);
      SearchViewCompatHoneycomb.setQueryRefinementEnabled(param1View, param1Boolean);
    }
    
    public void setSearchableInfo(View param1View, ComponentName param1ComponentName) {
      checkIfLegalArg(param1View);
      SearchViewCompatHoneycomb.setSearchableInfo(param1View, param1ComponentName);
    }
    
    public void setSubmitButtonEnabled(View param1View, boolean param1Boolean) {
      checkIfLegalArg(param1View);
      SearchViewCompatHoneycomb.setSubmitButtonEnabled(param1View, param1Boolean);
    }
  }
  
  class null implements SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge {
    public boolean onQueryTextChange(String param1String) {
      return listener.onQueryTextChange(param1String);
    }
    
    public boolean onQueryTextSubmit(String param1String) {
      return listener.onQueryTextSubmit(param1String);
    }
  }
  
  class null implements SearchViewCompatHoneycomb.OnCloseListenerCompatBridge {
    public boolean onClose() {
      return listener.onClose();
    }
  }
  
  static class SearchViewCompatIcsImpl extends SearchViewCompatHoneycombImpl {
    public View newSearchView(Context param1Context) {
      return SearchViewCompatIcs.newSearchView(param1Context);
    }
    
    public void setImeOptions(View param1View, int param1Int) {
      checkIfLegalArg(param1View);
      SearchViewCompatIcs.setImeOptions(param1View, param1Int);
    }
    
    public void setInputType(View param1View, int param1Int) {
      checkIfLegalArg(param1View);
      SearchViewCompatIcs.setInputType(param1View, param1Int);
    }
  }
  
  static interface SearchViewCompatImpl {
    CharSequence getQuery(View param1View);
    
    boolean isIconified(View param1View);
    
    boolean isQueryRefinementEnabled(View param1View);
    
    boolean isSubmitButtonEnabled(View param1View);
    
    Object newOnCloseListener(SearchViewCompat.OnCloseListener param1OnCloseListener);
    
    Object newOnQueryTextListener(SearchViewCompat.OnQueryTextListener param1OnQueryTextListener);
    
    View newSearchView(Context param1Context);
    
    void setIconified(View param1View, boolean param1Boolean);
    
    void setImeOptions(View param1View, int param1Int);
    
    void setInputType(View param1View, int param1Int);
    
    void setMaxWidth(View param1View, int param1Int);
    
    void setOnCloseListener(View param1View, SearchViewCompat.OnCloseListener param1OnCloseListener);
    
    void setOnQueryTextListener(View param1View, SearchViewCompat.OnQueryTextListener param1OnQueryTextListener);
    
    void setQuery(View param1View, CharSequence param1CharSequence, boolean param1Boolean);
    
    void setQueryHint(View param1View, CharSequence param1CharSequence);
    
    void setQueryRefinementEnabled(View param1View, boolean param1Boolean);
    
    void setSearchableInfo(View param1View, ComponentName param1ComponentName);
    
    void setSubmitButtonEnabled(View param1View, boolean param1Boolean);
  }
  
  static class SearchViewCompatStubImpl implements SearchViewCompatImpl {
    public CharSequence getQuery(View param1View) {
      return null;
    }
    
    public boolean isIconified(View param1View) {
      return true;
    }
    
    public boolean isQueryRefinementEnabled(View param1View) {
      return false;
    }
    
    public boolean isSubmitButtonEnabled(View param1View) {
      return false;
    }
    
    public Object newOnCloseListener(SearchViewCompat.OnCloseListener param1OnCloseListener) {
      return null;
    }
    
    public Object newOnQueryTextListener(SearchViewCompat.OnQueryTextListener param1OnQueryTextListener) {
      return null;
    }
    
    public View newSearchView(Context param1Context) {
      return null;
    }
    
    public void setIconified(View param1View, boolean param1Boolean) {}
    
    public void setImeOptions(View param1View, int param1Int) {}
    
    public void setInputType(View param1View, int param1Int) {}
    
    public void setMaxWidth(View param1View, int param1Int) {}
    
    public void setOnCloseListener(View param1View, SearchViewCompat.OnCloseListener param1OnCloseListener) {}
    
    public void setOnQueryTextListener(View param1View, SearchViewCompat.OnQueryTextListener param1OnQueryTextListener) {}
    
    public void setQuery(View param1View, CharSequence param1CharSequence, boolean param1Boolean) {}
    
    public void setQueryHint(View param1View, CharSequence param1CharSequence) {}
    
    public void setQueryRefinementEnabled(View param1View, boolean param1Boolean) {}
    
    public void setSearchableInfo(View param1View, ComponentName param1ComponentName) {}
    
    public void setSubmitButtonEnabled(View param1View, boolean param1Boolean) {}
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\SearchViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */