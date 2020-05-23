package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import android.util.Log;
import com.drms.drms_drone.Communication.UsbSerial.utils.HexData;

public class UsbSerialDebugger {
  private static final String CLASS_ID = UsbSerialDebugger.class.getSimpleName();
  
  public static final String ENCODING = "UTF-8";
  
  public static void printLogGet(byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (!paramBoolean) {
      Log.i(CLASS_ID, "Data obtained from write buffer: " + new String(paramArrayOfbyte));
      return;
    } 
    Log.i(CLASS_ID, "Data obtained from write buffer: " + new String(paramArrayOfbyte));
    Log.i(CLASS_ID, "Raw data from write buffer: " + HexData.hexToString(paramArrayOfbyte));
    Log.i(CLASS_ID, "Number of bytes obtained from write buffer: " + paramArrayOfbyte.length);
  }
  
  public static void printLogPut(byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (!paramBoolean) {
      Log.i(CLASS_ID, "Data obtained pushed to write buffer: " + new String(paramArrayOfbyte));
      return;
    } 
    Log.i(CLASS_ID, "Data obtained pushed to write buffer: " + new String(paramArrayOfbyte));
    Log.i(CLASS_ID, "Raw data pushed to write buffer: " + HexData.hexToString(paramArrayOfbyte));
    Log.i(CLASS_ID, "Number of bytes pushed from write buffer: " + paramArrayOfbyte.length);
  }
  
  public static void printReadLogGet(byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (!paramBoolean) {
      Log.i(CLASS_ID, "Data obtained from Read buffer: " + new String(paramArrayOfbyte));
      return;
    } 
    Log.i(CLASS_ID, "Data obtained from Read buffer: " + new String(paramArrayOfbyte));
    Log.i(CLASS_ID, "Raw data from Read buffer: " + HexData.hexToString(paramArrayOfbyte));
    Log.i(CLASS_ID, "Number of bytes obtained from Read buffer: " + paramArrayOfbyte.length);
  }
  
  public static void printReadLogPut(byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (!paramBoolean) {
      Log.i(CLASS_ID, "Data obtained pushed to read buffer: " + new String(paramArrayOfbyte));
      return;
    } 
    Log.i(CLASS_ID, "Data obtained pushed to read buffer: " + new String(paramArrayOfbyte));
    Log.i(CLASS_ID, "Raw data pushed to read buffer: " + HexData.hexToString(paramArrayOfbyte));
    Log.i(CLASS_ID, "Number of bytes pushed from read buffer: " + paramArrayOfbyte.length);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\UsbSerialDebugger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */