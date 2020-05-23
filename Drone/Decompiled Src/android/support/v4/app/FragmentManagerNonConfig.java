package android.support.v4.app;

import java.util.List;

public class FragmentManagerNonConfig {
  private final List<FragmentManagerNonConfig> mChildNonConfigs;
  
  private final List<Fragment> mFragments;
  
  FragmentManagerNonConfig(List<Fragment> paramList, List<FragmentManagerNonConfig> paramList1) {
    this.mFragments = paramList;
    this.mChildNonConfigs = paramList1;
  }
  
  List<FragmentManagerNonConfig> getChildNonConfigs() {
    return this.mChildNonConfigs;
  }
  
  List<Fragment> getFragments() {
    return this.mFragments;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\FragmentManagerNonConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */