package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

@TargetApi(16)
@RequiresApi(16)
class TextViewCompatJb {
  static int getMaxLines(TextView paramTextView) {
    return paramTextView.getMaxLines();
  }
  
  static int getMinLines(TextView paramTextView) {
    return paramTextView.getMinLines();
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\widget\TextViewCompatJb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */