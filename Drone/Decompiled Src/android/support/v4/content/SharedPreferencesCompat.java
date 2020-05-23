package android.support.v4.content;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public final class SharedPreferencesCompat {
  public static final class EditorCompat {
    private static EditorCompat sInstance;
    
    private final Helper mHelper = new Helper();
    
    public static EditorCompat getInstance() {
      if (sInstance == null)
        sInstance = new EditorCompat(); 
      return sInstance;
    }
    
    public void apply(@NonNull SharedPreferences.Editor param1Editor) {
      this.mHelper.apply(param1Editor);
    }
    
    private static class Helper {
      public void apply(@NonNull SharedPreferences.Editor param2Editor) {
        try {
          param2Editor.apply();
          return;
        } catch (AbstractMethodError abstractMethodError) {
          param2Editor.commit();
          return;
        } 
      }
    }
  }
  
  private static class Helper {
    public void apply(@NonNull SharedPreferences.Editor param1Editor) {
      try {
        param1Editor.apply();
        return;
      } catch (AbstractMethodError abstractMethodError) {
        param1Editor.commit();
        return;
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\SharedPreferencesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */