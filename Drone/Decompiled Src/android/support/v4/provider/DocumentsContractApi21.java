package android.support.v4.provider;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.util.ArrayList;

@TargetApi(21)
@RequiresApi(21)
class DocumentsContractApi21 {
  private static final String TAG = "DocumentFile";
  
  private static void closeQuietly(AutoCloseable paramAutoCloseable) {
    if (paramAutoCloseable != null)
      try {
        paramAutoCloseable.close();
        return;
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static Uri createDirectory(Context paramContext, Uri paramUri, String paramString) {
    return createFile(paramContext, paramUri, "vnd.android.document/directory", paramString);
  }
  
  public static Uri createFile(Context paramContext, Uri paramUri, String paramString1, String paramString2) {
    return DocumentsContract.createDocument(paramContext.getContentResolver(), paramUri, paramString1, paramString2);
  }
  
  public static Uri[] listFiles(Context paramContext, Uri paramUri) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    Uri uri = DocumentsContract.buildChildDocumentsUriUsingTree(paramUri, DocumentsContract.getDocumentId(paramUri));
    ArrayList<Uri> arrayList = new ArrayList();
    Cursor cursor = null;
    paramContext = null;
    try {
      Cursor cursor1 = contentResolver.query(uri, new String[] { "document_id" }, null, null, null);
      while (true) {
        null = cursor1;
        cursor = cursor1;
        if (cursor1.moveToNext()) {
          null = cursor1;
          cursor = cursor1;
          arrayList.add(DocumentsContract.buildDocumentUriUsingTree(paramUri, cursor1.getString(0)));
          continue;
        } 
        return arrayList.<Uri>toArray(new Uri[arrayList.size()]);
      } 
    } catch (Exception exception) {
      cursor = null;
      Log.w("DocumentFile", "Failed query: " + exception);
      return arrayList.<Uri>toArray(new Uri[arrayList.size()]);
    } finally {
      closeQuietly((AutoCloseable)cursor);
    } 
  }
  
  public static Uri prepareTreeUri(Uri paramUri) {
    return DocumentsContract.buildDocumentUriUsingTree(paramUri, DocumentsContract.getTreeDocumentId(paramUri));
  }
  
  public static Uri renameTo(Context paramContext, Uri paramUri, String paramString) {
    return DocumentsContract.renameDocument(paramContext.getContentResolver(), paramUri, paramString);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\provider\DocumentsContractApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */