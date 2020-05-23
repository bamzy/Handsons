package android.support.v4.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class RawDocumentFile extends DocumentFile {
  private File mFile;
  
  RawDocumentFile(DocumentFile paramDocumentFile, File paramFile) {
    super(paramDocumentFile);
    this.mFile = paramFile;
  }
  
  private static boolean deleteContents(File paramFile) {
    File[] arrayOfFile = paramFile.listFiles();
    boolean bool2 = true;
    boolean bool1 = true;
    if (arrayOfFile != null) {
      int j = arrayOfFile.length;
      int i = 0;
      while (true) {
        bool2 = bool1;
        if (i < j) {
          File file = arrayOfFile[i];
          bool2 = bool1;
          if (file.isDirectory())
            bool2 = bool1 & deleteContents(file); 
          bool1 = bool2;
          if (!file.delete()) {
            Log.w("DocumentFile", "Failed to delete " + file);
            bool1 = false;
          } 
          i++;
          continue;
        } 
        break;
      } 
    } 
    return bool2;
  }
  
  private static String getTypeForName(String paramString) {
    int i = paramString.lastIndexOf('.');
    if (i >= 0) {
      paramString = paramString.substring(i + 1).toLowerCase();
      paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      if (paramString != null)
        return paramString; 
    } 
    return "application/octet-stream";
  }
  
  public boolean canRead() {
    return this.mFile.canRead();
  }
  
  public boolean canWrite() {
    return this.mFile.canWrite();
  }
  
  public DocumentFile createDirectory(String paramString) {
    File file = new File(this.mFile, paramString);
    return (file.isDirectory() || file.mkdir()) ? new RawDocumentFile(this, file) : null;
  }
  
  public DocumentFile createFile(String paramString1, String paramString2) {
    String str = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString1);
    paramString1 = paramString2;
    if (str != null)
      paramString1 = paramString2 + "." + str; 
    File file = new File(this.mFile, paramString1);
    try {
      file.createNewFile();
      return new RawDocumentFile(this, file);
    } catch (IOException iOException) {
      Log.w("DocumentFile", "Failed to createFile: " + iOException);
      return null;
    } 
  }
  
  public boolean delete() {
    deleteContents(this.mFile);
    return this.mFile.delete();
  }
  
  public boolean exists() {
    return this.mFile.exists();
  }
  
  public String getName() {
    return this.mFile.getName();
  }
  
  public String getType() {
    return this.mFile.isDirectory() ? null : getTypeForName(this.mFile.getName());
  }
  
  public Uri getUri() {
    return Uri.fromFile(this.mFile);
  }
  
  public boolean isDirectory() {
    return this.mFile.isDirectory();
  }
  
  public boolean isFile() {
    return this.mFile.isFile();
  }
  
  public boolean isVirtual() {
    return false;
  }
  
  public long lastModified() {
    return this.mFile.lastModified();
  }
  
  public long length() {
    return this.mFile.length();
  }
  
  public DocumentFile[] listFiles() {
    ArrayList<RawDocumentFile> arrayList = new ArrayList();
    File[] arrayOfFile = this.mFile.listFiles();
    if (arrayOfFile != null) {
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++)
        arrayList.add(new RawDocumentFile(this, arrayOfFile[i])); 
    } 
    return arrayList.<DocumentFile>toArray(new DocumentFile[arrayList.size()]);
  }
  
  public boolean renameTo(String paramString) {
    File file = new File(this.mFile.getParentFile(), paramString);
    if (this.mFile.renameTo(file)) {
      this.mFile = file;
      return true;
    } 
    return false;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\provider\RawDocumentFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */