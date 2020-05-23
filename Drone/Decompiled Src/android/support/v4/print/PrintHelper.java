package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import java.io.FileNotFoundException;

public final class PrintHelper {
  public static final int COLOR_MODE_COLOR = 2;
  
  public static final int COLOR_MODE_MONOCHROME = 1;
  
  public static final int ORIENTATION_LANDSCAPE = 1;
  
  public static final int ORIENTATION_PORTRAIT = 2;
  
  public static final int SCALE_MODE_FILL = 2;
  
  public static final int SCALE_MODE_FIT = 1;
  
  PrintHelperVersionImpl mImpl;
  
  public PrintHelper(Context paramContext) {
    if (systemSupportsPrint()) {
      if (Build.VERSION.SDK_INT >= 24) {
        this.mImpl = new PrintHelperApi24Impl(paramContext);
        return;
      } 
      if (Build.VERSION.SDK_INT >= 23) {
        this.mImpl = new PrintHelperApi23Impl(paramContext);
        return;
      } 
      if (Build.VERSION.SDK_INT >= 20) {
        this.mImpl = new PrintHelperApi20Impl(paramContext);
        return;
      } 
      this.mImpl = new PrintHelperKitkatImpl(paramContext);
      return;
    } 
    this.mImpl = new PrintHelperStubImpl();
  }
  
  public static boolean systemSupportsPrint() {
    return (Build.VERSION.SDK_INT >= 19);
  }
  
  public int getColorMode() {
    return this.mImpl.getColorMode();
  }
  
  public int getOrientation() {
    return this.mImpl.getOrientation();
  }
  
  public int getScaleMode() {
    return this.mImpl.getScaleMode();
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap) {
    this.mImpl.printBitmap(paramString, paramBitmap, (OnPrintFinishCallback)null);
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap, OnPrintFinishCallback paramOnPrintFinishCallback) {
    this.mImpl.printBitmap(paramString, paramBitmap, paramOnPrintFinishCallback);
  }
  
  public void printBitmap(String paramString, Uri paramUri) throws FileNotFoundException {
    this.mImpl.printBitmap(paramString, paramUri, (OnPrintFinishCallback)null);
  }
  
  public void printBitmap(String paramString, Uri paramUri, OnPrintFinishCallback paramOnPrintFinishCallback) throws FileNotFoundException {
    this.mImpl.printBitmap(paramString, paramUri, paramOnPrintFinishCallback);
  }
  
  public void setColorMode(int paramInt) {
    this.mImpl.setColorMode(paramInt);
  }
  
  public void setOrientation(int paramInt) {
    this.mImpl.setOrientation(paramInt);
  }
  
  public void setScaleMode(int paramInt) {
    this.mImpl.setScaleMode(paramInt);
  }
  
  public static interface OnPrintFinishCallback {
    void onFinish();
  }
  
  private static final class PrintHelperApi20Impl extends PrintHelperImpl<PrintHelperApi20> {
    PrintHelperApi20Impl(Context param1Context) {
      super(new PrintHelperApi20(param1Context));
    }
  }
  
  private static final class PrintHelperApi23Impl extends PrintHelperImpl<PrintHelperApi23> {
    PrintHelperApi23Impl(Context param1Context) {
      super(new PrintHelperApi23(param1Context));
    }
  }
  
  private static final class PrintHelperApi24Impl extends PrintHelperImpl<PrintHelperApi24> {
    PrintHelperApi24Impl(Context param1Context) {
      super(new PrintHelperApi24(param1Context));
    }
  }
  
  private static class PrintHelperImpl<RealHelper extends PrintHelperKitkat> implements PrintHelperVersionImpl {
    private final RealHelper mPrintHelper;
    
    protected PrintHelperImpl(RealHelper param1RealHelper) {
      this.mPrintHelper = param1RealHelper;
    }
    
    public int getColorMode() {
      return this.mPrintHelper.getColorMode();
    }
    
    public int getOrientation() {
      return this.mPrintHelper.getOrientation();
    }
    
    public int getScaleMode() {
      return this.mPrintHelper.getScaleMode();
    }
    
    public void printBitmap(String param1String, Bitmap param1Bitmap, final PrintHelper.OnPrintFinishCallback callback) {
      PrintHelperKitkat.OnPrintFinishCallback onPrintFinishCallback = null;
      if (callback != null)
        onPrintFinishCallback = new PrintHelperKitkat.OnPrintFinishCallback() {
            public void onFinish() {
              callback.onFinish();
            }
          }; 
      this.mPrintHelper.printBitmap(param1String, param1Bitmap, onPrintFinishCallback);
    }
    
    public void printBitmap(String param1String, Uri param1Uri, final PrintHelper.OnPrintFinishCallback callback) throws FileNotFoundException {
      PrintHelperKitkat.OnPrintFinishCallback onPrintFinishCallback = null;
      if (callback != null)
        onPrintFinishCallback = new PrintHelperKitkat.OnPrintFinishCallback() {
            public void onFinish() {
              callback.onFinish();
            }
          }; 
      this.mPrintHelper.printBitmap(param1String, param1Uri, onPrintFinishCallback);
    }
    
    public void setColorMode(int param1Int) {
      this.mPrintHelper.setColorMode(param1Int);
    }
    
    public void setOrientation(int param1Int) {
      this.mPrintHelper.setOrientation(param1Int);
    }
    
    public void setScaleMode(int param1Int) {
      this.mPrintHelper.setScaleMode(param1Int);
    }
  }
  
  class null implements PrintHelperKitkat.OnPrintFinishCallback {
    public void onFinish() {
      callback.onFinish();
    }
  }
  
  class null implements PrintHelperKitkat.OnPrintFinishCallback {
    public void onFinish() {
      callback.onFinish();
    }
  }
  
  private static final class PrintHelperKitkatImpl extends PrintHelperImpl<PrintHelperKitkat> {
    PrintHelperKitkatImpl(Context param1Context) {
      super(new PrintHelperKitkat(param1Context));
    }
  }
  
  private static final class PrintHelperStubImpl implements PrintHelperVersionImpl {
    int mColorMode = 2;
    
    int mOrientation = 1;
    
    int mScaleMode = 2;
    
    private PrintHelperStubImpl() {}
    
    public int getColorMode() {
      return this.mColorMode;
    }
    
    public int getOrientation() {
      return this.mOrientation;
    }
    
    public int getScaleMode() {
      return this.mScaleMode;
    }
    
    public void printBitmap(String param1String, Bitmap param1Bitmap, PrintHelper.OnPrintFinishCallback param1OnPrintFinishCallback) {}
    
    public void printBitmap(String param1String, Uri param1Uri, PrintHelper.OnPrintFinishCallback param1OnPrintFinishCallback) {}
    
    public void setColorMode(int param1Int) {
      this.mColorMode = param1Int;
    }
    
    public void setOrientation(int param1Int) {
      this.mOrientation = param1Int;
    }
    
    public void setScaleMode(int param1Int) {
      this.mScaleMode = param1Int;
    }
  }
  
  static interface PrintHelperVersionImpl {
    int getColorMode();
    
    int getOrientation();
    
    int getScaleMode();
    
    void printBitmap(String param1String, Bitmap param1Bitmap, PrintHelper.OnPrintFinishCallback param1OnPrintFinishCallback);
    
    void printBitmap(String param1String, Uri param1Uri, PrintHelper.OnPrintFinishCallback param1OnPrintFinishCallback) throws FileNotFoundException;
    
    void setColorMode(int param1Int);
    
    void setOrientation(int param1Int);
    
    void setScaleMode(int param1Int);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\print\PrintHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */