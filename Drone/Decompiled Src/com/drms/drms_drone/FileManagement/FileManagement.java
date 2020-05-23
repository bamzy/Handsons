package com.drms.drms_drone.FileManagement;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import com.drms.drms_drone.CustomAdapter.CustomAdapter1.CustomAdapter1;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FileManagement {
  public static final int FAILED_READ_DATA = 43;
  
  private static final int FILEMANAGEMENT = 4;
  
  public static final int FINISHED_READ_DATA = 42;
  
  public static final int FINISHED_WRITE_DATA = 41;
  
  public static final int REQUEST_OPEN_TEMP = 45;
  
  public static final int REQUEST_SAVE_TEMP = 44;
  
  private static final String TAG = "FileManagement.class";
  
  private CustomAdapter1 Adapter;
  
  private String BTdirPath = Environment.getExternalStorageDirectory().getAbsolutePath();
  
  private Context context;
  
  private File[] filelist;
  
  private FileInputStream inputStream;
  
  private Handler mHandler;
  
  private File myFile;
  
  private ArrayList<File> myFile_list = new ArrayList<File>();
  
  private FileOutputStream outputStream;
  
  public FileManagement(Context paramContext, Handler paramHandler) {
    this.context = paramContext;
    this.mHandler = paramHandler;
    this.BTdirPath += "/DRMS(fly)";
    this.myFile = new File(this.BTdirPath);
    this.myFile.mkdirs();
    createBTFile();
  }
  
  private boolean createBTFile() {
    boolean bool = false;
    this.myFile = new File(this.BTdirPath + "/bluetoothAddr.txt");
    if (!this.myFile.exists())
      try {
        this.myFile.createNewFile();
        return true;
      } catch (IOException iOException) {
        Log.e(getClass().getSimpleName(), "IOException");
        return false;
      }  
    return bool;
  }
  
  public String[] readBTAddress() {
    int i;
    this.myFile = new File(this.BTdirPath + "/bluetoothAddr.txt");
    char[] arrayOfChar = new char[(int)this.myFile.length()];
    if (this.myFile.exists()) {
      if (this.myFile.length() > 0L) {
        Log.d("FILE", this.BTdirPath + "bluetooth.txt exist");
        try {
          this.inputStream = new FileInputStream(this.myFile);
          BufferedInputStream bufferedInputStream = new BufferedInputStream(this.inputStream);
          for (i = 0; i < this.myFile.length(); i++) {
            arrayOfChar[i] = (char)bufferedInputStream.read();
            Log.w("READ DATA", String.valueOf(arrayOfChar[i]));
          } 
          this.inputStream.close();
          bufferedInputStream.close();
        } catch (IOException iOException) {}
      } else {
        return null;
      } 
    } else {
      Log.d("FILE", this.BTdirPath + "bluetooth.txt not exist");
    } 
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = "";
    arrayOfString2[1] = "";
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfChar.length > 0) {
      for (i = 0; arrayOfChar[i] != '\n'; i++)
        arrayOfString2[0] = arrayOfString2[0] + arrayOfChar[i]; 
    } else {
      return arrayOfString1;
    } 
    while (++i < arrayOfChar.length) {
      arrayOfString2[1] = arrayOfString2[1] + arrayOfChar[i];
      i++;
    } 
    Log.d("FileManagement.class", "name : " + arrayOfString2[0] + "\naddress : " + arrayOfString2[1]);
    return arrayOfString2;
  }
  
  public boolean writeBtAddressOnFile(String paramString1, String paramString2) {
    this.myFile = new File(this.BTdirPath + "/bluetoothAddr.txt");
    if (!this.myFile.exists())
      createBTFile(); 
    try {
      this.outputStream = new FileOutputStream(this.myFile);
      byte[] arrayOfByte = (paramString1 + "\n" + paramString2).getBytes();
      this.outputStream.write(arrayOfByte);
      return true;
    } catch (IOException iOException) {
      return false;
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\FileManagement\FileManagement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */