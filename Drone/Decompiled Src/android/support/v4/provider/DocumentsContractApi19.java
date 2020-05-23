package android.support.v4.provider;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;

@TargetApi(19)
@RequiresApi(19)
class DocumentsContractApi19 {
  private static final int FLAG_VIRTUAL_DOCUMENT = 512;
  
  private static final String TAG = "DocumentFile";
  
  public static boolean canRead(Context paramContext, Uri paramUri) {
    return (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) == 0 && !TextUtils.isEmpty(getRawType(paramContext, paramUri)));
  }
  
  public static boolean canWrite(Context paramContext, Uri paramUri) {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) == 0) {
      String str = getRawType(paramContext, paramUri);
      int i = queryForInt(paramContext, paramUri, "flags", 0);
      if (!TextUtils.isEmpty(str)) {
        if ((i & 0x4) != 0)
          return true; 
        if ("vnd.android.document/directory".equals(str) && (i & 0x8) != 0)
          return true; 
        if (!TextUtils.isEmpty(str) && (i & 0x2) != 0)
          return true; 
      } 
    } 
    return false;
  }
  
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
  
  public static boolean delete(Context paramContext, Uri paramUri) {
    return DocumentsContract.deleteDocument(paramContext.getContentResolver(), paramUri);
  }
  
  public static boolean exists(Context paramContext, Uri paramUri) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    Cursor cursor = null;
    paramContext = null;
    try {
      Cursor cursor1 = contentResolver.query(paramUri, new String[] { "document_id" }, null, null, null);
      null = cursor1;
      cursor = cursor1;
      int i = cursor1.getCount();
      if (i > 0)
        return true; 
      return false;
    } catch (Exception exception) {
      cursor = null;
      Log.w("DocumentFile", "Failed query: " + exception);
      return false;
    } finally {
      closeQuietly((AutoCloseable)cursor);
    } 
  }
  
  public static long getFlags(Context paramContext, Uri paramUri) {
    return queryForLong(paramContext, paramUri, "flags", 0L);
  }
  
  public static String getName(Context paramContext, Uri paramUri) {
    return queryForString(paramContext, paramUri, "_display_name", null);
  }
  
  private static String getRawType(Context paramContext, Uri paramUri) {
    return queryForString(paramContext, paramUri, "mime_type", null);
  }
  
  public static String getType(Context paramContext, Uri paramUri) {
    String str2 = getRawType(paramContext, paramUri);
    String str1 = str2;
    if ("vnd.android.document/directory".equals(str2))
      str1 = null; 
    return str1;
  }
  
  public static boolean isDirectory(Context paramContext, Uri paramUri) {
    return "vnd.android.document/directory".equals(getRawType(paramContext, paramUri));
  }
  
  public static boolean isDocumentUri(Context paramContext, Uri paramUri) {
    return DocumentsContract.isDocumentUri(paramContext, paramUri);
  }
  
  public static boolean isFile(Context paramContext, Uri paramUri) {
    String str = getRawType(paramContext, paramUri);
    return !("vnd.android.document/directory".equals(str) || TextUtils.isEmpty(str));
  }
  
  public static boolean isVirtual(Context paramContext, Uri paramUri) {
    return (isDocumentUri(paramContext, paramUri) && (getFlags(paramContext, paramUri) & 0x200L) != 0L);
  }
  
  public static long lastModified(Context paramContext, Uri paramUri) {
    return queryForLong(paramContext, paramUri, "last_modified", 0L);
  }
  
  public static long length(Context paramContext, Uri paramUri) {
    return queryForLong(paramContext, paramUri, "_size", 0L);
  }
  
  private static int queryForInt(Context paramContext, Uri paramUri, String paramString, int paramInt) {
    return (int)queryForLong(paramContext, paramUri, paramString, paramInt);
  }
  
  private static long queryForLong(Context paramContext, Uri paramUri, String paramString, long paramLong) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    Cursor cursor = null;
    paramContext = null;
    try {
      Cursor cursor1 = contentResolver.query(paramUri, new String[] { paramString }, null, null, null);
      null = cursor1;
      cursor = cursor1;
      if (cursor1.moveToFirst()) {
        null = cursor1;
        cursor = cursor1;
        if (!cursor1.isNull(0)) {
          null = cursor1;
          cursor = cursor1;
          return cursor1.getLong(0);
        } 
      } 
      return paramLong;
    } catch (Exception exception) {
      cursor = null;
      Log.w("DocumentFile", "Failed query: " + exception);
      return paramLong;
    } finally {
      closeQuietly((AutoCloseable)cursor);
    } 
  }
  
  private static String queryForString(Context paramContext, Uri paramUri, String paramString1, String paramString2) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    Cursor cursor = null;
    paramContext = null;
    try {
      Cursor cursor1 = contentResolver.query(paramUri, new String[] { paramString1 }, null, null, null);
      null = cursor1;
      cursor = cursor1;
      if (cursor1.moveToFirst()) {
        null = cursor1;
        cursor = cursor1;
        if (!cursor1.isNull(0)) {
          null = cursor1;
          cursor = cursor1;
          paramString1 = cursor1.getString(0);
          return paramString1;
        } 
      } 
      return paramString2;
    } catch (Exception exception) {
      cursor = null;
      Log.w("DocumentFile", "Failed query: " + exception);
      return paramString2;
    } finally {
      closeQuietly((AutoCloseable)cursor);
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\provider\DocumentsContractApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */