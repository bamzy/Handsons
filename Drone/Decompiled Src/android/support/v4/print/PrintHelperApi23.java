package android.support.v4.print;

import android.annotation.TargetApi;
import android.content.Context;
import android.print.PrintAttributes;
import android.support.annotation.RequiresApi;

@TargetApi(23)
@RequiresApi(23)
class PrintHelperApi23 extends PrintHelperApi20 {
  PrintHelperApi23(Context paramContext) {
    super(paramContext);
  }
  
  protected PrintAttributes.Builder copyAttributes(PrintAttributes paramPrintAttributes) {
    PrintAttributes.Builder builder = super.copyAttributes(paramPrintAttributes);
    if (paramPrintAttributes.getDuplexMode() != 0)
      builder.setDuplexMode(paramPrintAttributes.getDuplexMode()); 
    return builder;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\print\PrintHelperApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */