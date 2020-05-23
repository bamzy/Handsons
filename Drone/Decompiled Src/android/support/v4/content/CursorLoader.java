package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.os.CancellationSignal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {
  CancellationSignal mCancellationSignal;
  
  Cursor mCursor;
  
  final Loader<Cursor>.ForceLoadContentObserver mObserver = new Loader.ForceLoadContentObserver(this);
  
  String[] mProjection;
  
  String mSelection;
  
  String[] mSelectionArgs;
  
  String mSortOrder;
  
  Uri mUri;
  
  public CursorLoader(Context paramContext) {
    super(paramContext);
  }
  
  public CursorLoader(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    super(paramContext);
    this.mUri = paramUri;
    this.mProjection = paramArrayOfString1;
    this.mSelection = paramString1;
    this.mSelectionArgs = paramArrayOfString2;
    this.mSortOrder = paramString2;
  }
  
  public void cancelLoadInBackground() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial cancelLoadInBackground : ()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield mCancellationSignal : Landroid/support/v4/os/CancellationSignal;
    //   10: ifnull -> 20
    //   13: aload_0
    //   14: getfield mCancellationSignal : Landroid/support/v4/os/CancellationSignal;
    //   17: invokevirtual cancel : ()V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   6	20	23	finally
    //   20	22	23	finally
    //   24	26	23	finally
  }
  
  public void deliverResult(Cursor paramCursor) {
    if (isReset()) {
      if (paramCursor != null)
        paramCursor.close(); 
      return;
    } 
    Cursor cursor = this.mCursor;
    this.mCursor = paramCursor;
    if (isStarted())
      super.deliverResult(paramCursor); 
    if (cursor != null && cursor != paramCursor && !cursor.isClosed()) {
      cursor.close();
      return;
    } 
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mUri=");
    paramPrintWriter.println(this.mUri);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mProjection=");
    paramPrintWriter.println(Arrays.toString((Object[])this.mProjection));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelection=");
    paramPrintWriter.println(this.mSelection);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelectionArgs=");
    paramPrintWriter.println(Arrays.toString((Object[])this.mSelectionArgs));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSortOrder=");
    paramPrintWriter.println(this.mSortOrder);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCursor=");
    paramPrintWriter.println(this.mCursor);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mContentChanged=");
    paramPrintWriter.println(this.mContentChanged);
  }
  
  public String[] getProjection() {
    return this.mProjection;
  }
  
  public String getSelection() {
    return this.mSelection;
  }
  
  public String[] getSelectionArgs() {
    return this.mSelectionArgs;
  }
  
  public String getSortOrder() {
    return this.mSortOrder;
  }
  
  public Uri getUri() {
    return this.mUri;
  }
  
  public Cursor loadInBackground() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual isLoadInBackgroundCanceled : ()Z
    //   6: ifeq -> 22
    //   9: new android/support/v4/os/OperationCanceledException
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: athrow
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    //   22: aload_0
    //   23: new android/support/v4/os/CancellationSignal
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: putfield mCancellationSignal : Landroid/support/v4/os/CancellationSignal;
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: invokevirtual getContext : ()Landroid/content/Context;
    //   39: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   42: aload_0
    //   43: getfield mUri : Landroid/net/Uri;
    //   46: aload_0
    //   47: getfield mProjection : [Ljava/lang/String;
    //   50: aload_0
    //   51: getfield mSelection : Ljava/lang/String;
    //   54: aload_0
    //   55: getfield mSelectionArgs : [Ljava/lang/String;
    //   58: aload_0
    //   59: getfield mSortOrder : Ljava/lang/String;
    //   62: aload_0
    //   63: getfield mCancellationSignal : Landroid/support/v4/os/CancellationSignal;
    //   66: invokestatic query : (Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/support/v4/os/CancellationSignal;)Landroid/database/Cursor;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull -> 91
    //   74: aload_1
    //   75: invokeinterface getCount : ()I
    //   80: pop
    //   81: aload_1
    //   82: aload_0
    //   83: getfield mObserver : Landroid/support/v4/content/Loader$ForceLoadContentObserver;
    //   86: invokeinterface registerContentObserver : (Landroid/database/ContentObserver;)V
    //   91: aload_0
    //   92: monitorenter
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield mCancellationSignal : Landroid/support/v4/os/CancellationSignal;
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: areturn
    //   102: astore_2
    //   103: aload_1
    //   104: invokeinterface close : ()V
    //   109: aload_2
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: monitorenter
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield mCancellationSignal : Landroid/support/v4/os/CancellationSignal;
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	17	finally
    //   18	20	17	finally
    //   22	35	17	finally
    //   35	70	111	finally
    //   74	91	102	java/lang/RuntimeException
    //   74	91	111	finally
    //   93	100	123	finally
    //   103	111	111	finally
    //   114	121	128	finally
    //   124	126	123	finally
    //   129	131	128	finally
  }
  
  public void onCanceled(Cursor paramCursor) {
    if (paramCursor != null && !paramCursor.isClosed())
      paramCursor.close(); 
  }
  
  protected void onReset() {
    super.onReset();
    onStopLoading();
    if (this.mCursor != null && !this.mCursor.isClosed())
      this.mCursor.close(); 
    this.mCursor = null;
  }
  
  protected void onStartLoading() {
    if (this.mCursor != null)
      deliverResult(this.mCursor); 
    if (takeContentChanged() || this.mCursor == null)
      forceLoad(); 
  }
  
  protected void onStopLoading() {
    cancelLoad();
  }
  
  public void setProjection(String[] paramArrayOfString) {
    this.mProjection = paramArrayOfString;
  }
  
  public void setSelection(String paramString) {
    this.mSelection = paramString;
  }
  
  public void setSelectionArgs(String[] paramArrayOfString) {
    this.mSelectionArgs = paramArrayOfString;
  }
  
  public void setSortOrder(String paramString) {
    this.mSortOrder = paramString;
  }
  
  public void setUri(Uri paramUri) {
    this.mUri = paramUri;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\CursorLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */