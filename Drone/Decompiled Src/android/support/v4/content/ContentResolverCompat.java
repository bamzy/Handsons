package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v4.os.CancellationSignal;
import android.support.v4.os.OperationCanceledException;

public final class ContentResolverCompat {
  private static final ContentResolverCompatImpl IMPL = new ContentResolverCompatImplBase();
  
  public static Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, CancellationSignal paramCancellationSignal) {
    return IMPL.query(paramContentResolver, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramCancellationSignal);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new ContentResolverCompatImplJB();
      return;
    } 
  }
  
  static interface ContentResolverCompatImpl {
    Cursor query(ContentResolver param1ContentResolver, Uri param1Uri, String[] param1ArrayOfString1, String param1String1, String[] param1ArrayOfString2, String param1String2, CancellationSignal param1CancellationSignal);
  }
  
  static class ContentResolverCompatImplBase implements ContentResolverCompatImpl {
    public Cursor query(ContentResolver param1ContentResolver, Uri param1Uri, String[] param1ArrayOfString1, String param1String1, String[] param1ArrayOfString2, String param1String2, CancellationSignal param1CancellationSignal) {
      if (param1CancellationSignal != null)
        param1CancellationSignal.throwIfCanceled(); 
      return param1ContentResolver.query(param1Uri, param1ArrayOfString1, param1String1, param1ArrayOfString2, param1String2);
    }
  }
  
  static class ContentResolverCompatImplJB extends ContentResolverCompatImplBase {
    public Cursor query(ContentResolver param1ContentResolver, Uri param1Uri, String[] param1ArrayOfString1, String param1String1, String[] param1ArrayOfString2, String param1String2, CancellationSignal param1CancellationSignal) {
      if (param1CancellationSignal != null)
        try {
          Object object = param1CancellationSignal.getCancellationSignalObject();
          return ContentResolverCompatJellybean.query(param1ContentResolver, param1Uri, param1ArrayOfString1, param1String1, param1ArrayOfString2, param1String2, object);
        } catch (Exception exception) {
          if (ContentResolverCompatJellybean.isFrameworkOperationCanceledException(exception))
            throw new OperationCanceledException(); 
          throw exception;
        }  
      param1CancellationSignal = null;
      return ContentResolverCompatJellybean.query((ContentResolver)exception, param1Uri, param1ArrayOfString1, param1String1, param1ArrayOfString2, param1String2, param1CancellationSignal);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\ContentResolverCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */