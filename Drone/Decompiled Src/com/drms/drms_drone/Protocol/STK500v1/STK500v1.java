package com.drms.drms_drone.Protocol.STK500v1;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.drms.drms_drone.Communication.ClassicBluetooth.BluetoothService;
import com.drms.drms_drone.MultiData;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class STK500v1 {
  public static final int MODE_REQUEST = 1;
  
  private static final int ORIENT_COMMAND = 20;
  
  private static final int RECEIVED_MESSAGE = 21;
  
  private static final String TAG = "STK500";
  
  private static final int UPLOADPROGRESS = 22;
  
  private static final int UPLOAD_STATE = 23;
  
  private BluetoothService bluetoothService;
  
  private int bytesToLoad = 0;
  
  private byte[] command_set;
  
  private int complete_size = 0;
  
  private ConstantsStk500v1 conststk500;
  
  long endTime;
  
  private Hex hexParser;
  
  private int hexPosition = 0;
  
  private InputStream inputstream;
  
  boolean loadAddress_each_success = false;
  
  boolean loadAddress_success = false;
  
  private Activity mActivity;
  
  private Handler mHandler;
  
  private MultiData mspdata;
  
  private OutputStream outstream;
  
  boolean programMode_entered = false;
  
  boolean programMode_left = false;
  
  boolean programPage_each_success = false;
  
  boolean programPage_success = false;
  
  private int request;
  
  public boolean running = true;
  
  long startTime;
  
  public Handler stk500_handler = new Handler() {
      boolean toast_state = false;
      
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        switch (param1Message.what) {
          default:
            return;
          case 21:
            break;
        } 
        byte b = (byte)param1Message.arg1;
        byte[] arrayOfByte = (byte[])param1Message.obj;
        switch (b) {
          default:
            return;
          case 80:
            if (arrayOfByte[0] == 20) {
              STK500v1.this.programMode_entered = true;
              return;
            } 
            if (arrayOfByte[0] == 21) {
              STK500v1.this.programMode_entered = false;
              return;
            } 
          case 81:
            if (arrayOfByte[0] == 20) {
              STK500v1.this.programMode_left = true;
              return;
            } 
            if (arrayOfByte[0] == 21) {
              STK500v1.this.programMode_left = false;
              return;
            } 
          case 85:
            if (arrayOfByte[0] == 20) {
              STK500v1.this.loadAddress_success = true;
              STK500v1.this.loadAddress_each_success = true;
              return;
            } 
            if (arrayOfByte[0] == 21) {
              STK500v1.this.loadAddress_success = false;
              STK500v1.this.loadAddress_each_success = false;
              return;
            } 
            STK500v1.this.loadAddress_success = false;
            STK500v1.this.loadAddress_each_success = false;
            return;
          case 100:
            break;
        } 
        if (arrayOfByte[0] == 20) {
          STK500v1.this.programPage_success = true;
          STK500v1.this.programPage_each_success = true;
          return;
        } 
        if (arrayOfByte[0] == 21) {
          STK500v1.this.programPage_success = false;
          STK500v1.this.programPage_each_success = false;
          return;
        } 
        STK500v1.this.programPage_success = false;
        STK500v1.this.programPage_each_success = false;
      }
    };
  
  int triesToleaveProgrammode = 0;
  
  int uploadFileTries = 0;
  
  public STK500v1(Activity paramActivity, BluetoothService paramBluetoothService, Handler paramHandler, int paramInt) {
    this.bluetoothService = paramBluetoothService;
    this.mHandler = paramHandler;
    this.mActivity = paramActivity;
    this.request = paramInt;
    this.mspdata = (MultiData)paramActivity.getApplication();
    if (paramInt == 0) {
      this.command_set = this.mspdata.getQUAD_GY521_EEPROM();
    } else if (paramInt == 3) {
      this.command_set = this.mspdata.getHEX_GY521_EEPROM();
    } 
    this.conststk500 = new ConstantsStk500v1();
  }
  
  private boolean enterProgramMode() {
    ConstantsStk500v1 constantsStk500v11 = this.conststk500;
    constantsStk500v11 = this.conststk500;
    Handler handler = this.mHandler;
    ConstantsStk500v1 constantsStk500v12 = this.conststk500;
    handler.obtainMessage(20, 80, -1).sendToTarget();
    this.bluetoothService.write(new byte[] { 80, 32 }, 1);
    Log.d("STK500", "write enterProgramMode command");
    try {
      Thread.sleep(500L);
    } catch (InterruptedException interruptedException) {}
    return this.programMode_entered;
  }
  
  private boolean leaveProgramMode() {
    ConstantsStk500v1 constantsStk500v11 = this.conststk500;
    constantsStk500v11 = this.conststk500;
    Handler handler = this.mHandler;
    ConstantsStk500v1 constantsStk500v12 = this.conststk500;
    handler.obtainMessage(20, 81, -1).sendToTarget();
    this.bluetoothService.write(new byte[] { 81, 32 }, 1);
    Log.d("STK500", "write LeaveProgramMode command");
    try {
      Thread.sleep(300L);
    } catch (InterruptedException interruptedException) {}
    return this.programMode_left;
  }
  
  private boolean loadAddress(int paramInt) {
    byte[] arrayOfByte = packTwoBytes(paramInt / 2);
    byte b1 = arrayOfByte[1];
    byte b2 = arrayOfByte[0];
    Handler handler = this.mHandler;
    ConstantsStk500v1 constantsStk500v1 = this.conststk500;
    handler.obtainMessage(20, 85, -1).sendToTarget();
    this.bluetoothService.write(new byte[] { 85, b1, b2, 32 }, 1);
    paramInt = 0;
    while (true) {
      if (!this.loadAddress_each_success) {
        int i = paramInt + 1;
        if (paramInt <= 1000) {
          try {
            Thread.sleep(1L);
            paramInt = i;
          } catch (InterruptedException interruptedException) {
            paramInt = i;
          } 
          continue;
        } 
      } 
      return this.loadAddress_each_success;
    } 
  }
  
  private byte[] packTwoBytes(int paramInt) {
    byte b = (byte)(paramInt & 0xFF);
    return new byte[] { (byte)(paramInt >> 8 & 0xFF), b };
  }
  
  private boolean programPage(boolean paramBoolean, byte[] paramArrayOfbyte) {
    byte b;
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length + 5];
    arrayOfByte[0] = 100;
    arrayOfByte[1] = (byte)(paramArrayOfbyte.length >> 8 & 0xFF);
    arrayOfByte[2] = (byte)(paramArrayOfbyte.length & 0xFF);
    if (paramBoolean) {
      b = 70;
    } else {
      b = 69;
    } 
    arrayOfByte[3] = b;
    int i;
    for (i = 0; i < paramArrayOfbyte.length; i++)
      arrayOfByte[i + 4] = paramArrayOfbyte[i]; 
    arrayOfByte[paramArrayOfbyte.length + 4] = 32;
    Handler handler = this.mHandler;
    ConstantsStk500v1 constantsStk500v1 = this.conststk500;
    handler.obtainMessage(20, 100, -1).sendToTarget();
    this.bluetoothService.write(arrayOfByte, 1);
    i = 0;
    while (true) {
      if (!this.programPage_each_success)
        try {
          Thread.sleep(1L);
          if (i <= 1000) {
            i++;
            continue;
          } 
          return this.programPage_success;
        } catch (InterruptedException interruptedException) {
          continue;
        }  
      return this.programPage_success;
    } 
  }
  
  private boolean writeDataOnEEPROM() {
    boolean bool = false;
    int k = this.command_set.length / 256 + 1;
    int i = 0;
    ArrayList<byte[]> arrayList = new ArrayList();
    int j;
    for (j = 0; j < k; j++) {
      if (j == k - 1) {
        byte[] arrayOfByte = new byte[this.command_set.length % 256];
        int m = 0;
        while (m < this.command_set.length % 256) {
          arrayOfByte[m] = this.command_set[i];
          m++;
          i++;
        } 
        arrayList.add(arrayOfByte);
      } else {
        byte[] arrayOfByte = new byte[256];
        int m = 0;
        while (m < 256) {
          arrayOfByte[m] = this.command_set[i];
          m++;
          i++;
        } 
        arrayList.add(arrayOfByte);
      } 
    } 
    j = 0;
    i = 0;
    label37: while (i < k && this.running) {
      this.programPage_each_success = false;
      this.loadAddress_each_success = false;
      Log.w("STK500", "cycle index : " + i + ", data_Set_number " + k);
      int m = 0;
      while (true) {
        if (m < 5)
          if (loadAddress(j)) {
            Log.d("STK500", "Upload files");
          } else {
            m++;
            continue;
          }  
        m = j;
        if (programPage(false, arrayList.get(i))) {
          Log.d("STK500", "Success Write data on EEPROM");
          m = j + 256;
          bool = true;
        } 
        i++;
        Log.w("STK500", "Finished Write EEPROM data");
        j = m;
        continue label37;
      } 
    } 
    return bool;
  }
  
  private boolean writeHexFile() {
    boolean bool2;
    boolean bool1 = false;
    this.hexPosition = 0;
    label25: while (true) {
      bool2 = bool1;
      if (this.hexPosition < this.hexParser.getDataSize()) {
        bool2 = bool1;
        if (this.running) {
          this.programPage_each_success = false;
          this.loadAddress_each_success = false;
          this.mHandler.obtainMessage(23, this.hexPosition, this.hexParser.getDataSize()).sendToTarget();
          Log.d("STK500", "hexPosition : " + String.valueOf(this.hexPosition));
          if (this.uploadFileTries > 10)
            return false; 
          byte[] arrayOfByte = this.hexParser.getHexLine(this.hexPosition, this.bytesToLoad);
          Log.d("STK500", "tempArray size : " + String.valueOf(arrayOfByte.length));
          if (arrayOfByte.length == 0)
            return true; 
          int i = 0;
          while (true) {
            if (i < 5)
              if (loadAddress(this.hexPosition)) {
                Log.d("STK500", "Upload files");
              } else {
                this.uploadFileTries++;
                i++;
                continue;
              }  
            if (programPage(true, arrayOfByte)) {
              Log.d("STK500", "temp_array size : " + arrayOfByte.length);
              this.hexPosition += arrayOfByte.length;
              bool1 = true;
              Log.d("STK500", "Finished the writeHexFile programPage_success : " + String.valueOf(this.programPage_success));
              continue label25;
            } 
            bool2 = false;
            break;
          } 
        } 
      } 
      break;
    } 
    return bool2;
  }
  
  public int getDataSize() {
    return this.complete_size;
  }
  
  public int getHexPosition() {
    return this.hexPosition;
  }
  
  public Handler getStk500_handler() {
    return this.stk500_handler;
  }
  
  boolean initializeEEPROM() {
    boolean bool = false;
    int[] arrayOfInt = new int[1024];
    int i;
    for (i = 0; i < arrayOfInt.length; i++)
      arrayOfInt[i] = 255; 
    byte[] arrayOfByte = new byte[arrayOfInt.length];
    for (i = 0; i < arrayOfByte.length; i++)
      arrayOfByte[i] = (byte)(char)(arrayOfInt[i] & 0xFF); 
    int k = arrayOfByte.length / 256 + 1;
    i = 0;
    ArrayList<byte[]> arrayList = new ArrayList();
    int j;
    for (j = 0; j < k; j++) {
      if (j == k - 1) {
        byte[] arrayOfByte1 = new byte[arrayOfByte.length % 256];
        int m = 0;
        while (m < arrayOfByte.length % 256) {
          arrayOfByte1[m] = arrayOfByte[i];
          m++;
          i++;
        } 
        arrayList.add(arrayOfByte1);
      } else {
        byte[] arrayOfByte1 = new byte[256];
        int m = 0;
        while (m < 256) {
          arrayOfByte1[m] = arrayOfByte[i];
          m++;
          i++;
        } 
        arrayList.add(arrayOfByte1);
      } 
    } 
    j = 0;
    i = 0;
    label47: while (i < k && this.running) {
      this.programPage_each_success = false;
      this.loadAddress_each_success = false;
      Log.d("STK500", "init -> cycle_index : " + i + "/ data_num : " + k);
      int m = 0;
      while (true) {
        if (m < 5)
          if (loadAddress(j)) {
            Log.d("STK500", "Upload files");
          } else {
            m++;
            continue;
          }  
        m = j;
        if (programPage(false, arrayList.get(i))) {
          m = j + 256;
          bool = true;
        } 
        i++;
        Log.w("STK500", "Finished Write EEPROM data");
        j = m;
        continue label47;
      } 
    } 
    return bool;
  }
  
  public boolean programHexFile(byte[] paramArrayOfbyte, int paramInt, boolean paramBoolean) {
    this.hexParser = new Hex(paramArrayOfbyte);
    this.complete_size = this.hexParser.getDataSize();
    this.bytesToLoad = paramInt;
    this.startTime = System.currentTimeMillis();
    this.endTime = System.currentTimeMillis();
    while (true) {
      if (this.endTime - this.startTime > 1500L || enterProgramMode()) {
        if (this.programMode_entered) {
          Log.d("STK500", "Entering the Programm ModeprogramMode_entered : " + String.valueOf(this.programMode_entered));
          this.mHandler.obtainMessage(23, 3, -1).sendToTarget();
          if (initializeEEPROM() && writeHexFile()) {
            this.mHandler.obtainMessage(23, 4, -1).sendToTarget();
            if (this.request == 0 || this.request == 3)
              writeDataOnEEPROM(); 
            Log.d("STK500", "Write Command data on Arduino EEPROM");
          } 
        } else if (!this.programMode_entered && this.endTime - this.startTime <= 1500L) {
          Log.d("STK500", "Entering the Programm ModeprogramMode_entered : " + String.valueOf(this.programMode_entered));
          return false;
        } 
        if (this.programMode_entered) {
          while (true) {
            if (!leaveProgramMode() && this.triesToleaveProgrammode < 5) {
              try {
                Thread.sleep(300L);
              } catch (InterruptedException interruptedException) {}
              this.triesToleaveProgrammode++;
              continue;
            } 
            Log.d("STK500", "leaving the Programm ModeprogramMode_left : " + String.valueOf(this.programMode_left));
            if (this.programMode_entered && this.loadAddress_success && this.programPage_success && this.programMode_left)
              return true; 
            paramBoolean = false;
            this.mHandler.obtainMessage(23, -1, -1).sendToTarget();
            return paramBoolean;
          } 
          break;
        } 
      } else {
        this.endTime = System.currentTimeMillis();
        if (this.endTime - this.startTime > 1500L) {
          this.mHandler.obtainMessage(23, 2, -1).sendToTarget();
          return false;
        } 
        continue;
      } 
      return false;
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Protocol\STK500v1\STK500v1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */