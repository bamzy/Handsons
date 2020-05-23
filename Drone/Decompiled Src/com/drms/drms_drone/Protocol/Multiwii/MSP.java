package com.drms.drms_drone.Protocol.Multiwii;

import android.os.Handler;
import android.util.Log;
import com.drms.drms_drone.Communication.ClassicBluetooth.BluetoothService;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MSP {
  private static int CHECKBOXITEM = 0;
  
  public static final int MODE_REQUEST = 1;
  
  public static final int MSP_ACC_CALIBRATION = 205;
  
  public static final int MSP_ALTITUDE = 109;
  
  public static final int MSP_ANALOG = 110;
  
  public static final int MSP_ATTITUDE = 108;
  
  public static final int MSP_BIND = 240;
  
  public static final int MSP_BOX = 113;
  
  public static final int MSP_BOXIDS = 119;
  
  public static final int MSP_BOXNAMES = 116;
  
  public static final int MSP_COMP_GPS = 107;
  
  public static final int MSP_DEBUG = 254;
  
  public static final int MSP_DEBUGMSG = 253;
  
  public static final int MSP_EEPROM_WRITE = 250;
  
  public static final int MSP_ENABLE_FRSKY = 198;
  
  private static final String MSP_HEADER = "$M<";
  
  public static final int MSP_IDENT = 100;
  
  public static final int MSP_MAG_CALIBRATION = 206;
  
  public static final int MSP_MISC = 114;
  
  public static final int MSP_MOTOR = 104;
  
  public static final int MSP_MOTOR_PINS = 115;
  
  public static final int MSP_NAV_CONFIG = 122;
  
  public static final int MSP_NAV_STATUS = 121;
  
  public static final int MSP_PID = 112;
  
  public static final int MSP_PIDNAMES = 117;
  
  public static final int MSP_RAW_GPS = 106;
  
  public static final int MSP_RAW_IMU = 102;
  
  public static final int MSP_RC = 105;
  
  public static final int MSP_RC_TUNING = 111;
  
  public static final int MSP_RESET_CONF = 208;
  
  public static final int MSP_SELECT_SETTING = 210;
  
  public static final int MSP_SERVO = 103;
  
  public static final int MSP_SERVO_CONF = 120;
  
  public static final int MSP_SET_BOX = 203;
  
  public static final int MSP_SET_HEAD = 211;
  
  public static final int MSP_SET_MISC = 207;
  
  public static final int MSP_SET_MOTOR = 214;
  
  public static final int MSP_SET_PID = 202;
  
  public static final int MSP_SET_RAW_GPS = 201;
  
  public static final int MSP_SET_RAW_RC = 200;
  
  public static final int MSP_SET_RC_TUNING = 204;
  
  public static final int MSP_SET_SERIAL_BAUDRATE = 199;
  
  public static final int MSP_SET_SERVO_CONF = 212;
  
  public static final int MSP_SET_WP = 209;
  
  public static final int MSP_STATUS = 101;
  
  public static final int MSP_WP = 118;
  
  private Handler mHandler;
  
  private BluetoothService mbluetoothservice;
  
  private ArrayList<Character> payload;
  
  public MSP(BluetoothService paramBluetoothService, Handler paramHandler) {
    this.mbluetoothservice = paramBluetoothService;
    this.mHandler = paramHandler;
  }
  
  public void SendRequestMSP_ACC_CALIBRATION() {
    sendRequestMSP(requestMSP(205));
  }
  
  public void SendRequestMSP_ENABLE_FRSKY() {
    sendRequestMSP(requestMSP(198));
    Log.d("aaa", "MSP_ENABLE_FRSKY");
  }
  
  public void SendRequestMSP_MAG_CALIBRATION() {
    sendRequestMSP(requestMSP(206));
  }
  
  public void SendRequestMSP_SET_HEAD(int paramInt) {
    this.payload = new ArrayList<Character>();
    this.payload.add(Character.valueOf((char)(paramInt & 0xFF)));
    this.payload.add(Character.valueOf((char)(paramInt >> 8 & 0xFF)));
    sendRequestMSP(requestMSP(211, this.payload.<Character>toArray(new Character[this.payload.size()])));
  }
  
  public void SendRequestMSP_SET_MISC(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, float paramFloat2, float paramFloat3, float paramFloat4) {
    this.payload = new ArrayList<Character>();
    paramInt1 = Math.round(paramInt1);
    this.payload.add(Character.valueOf((char)(paramInt1 % 256)));
    this.payload.add(Character.valueOf((char)(paramInt1 / 256)));
    this.payload.add(Character.valueOf((char)(paramInt2 % 256)));
    this.payload.add(Character.valueOf((char)(paramInt2 / 256)));
    this.payload.add(Character.valueOf((char)(paramInt3 % 256)));
    this.payload.add(Character.valueOf((char)(paramInt3 / 256)));
    this.payload.add(Character.valueOf((char)(paramInt4 % 256)));
    this.payload.add(Character.valueOf((char)(paramInt4 / 256)));
    this.payload.add(Character.valueOf((char)(paramInt5 % 256)));
    this.payload.add(Character.valueOf((char)(paramInt5 / 256)));
    this.payload.add(Character.valueOf(false));
    this.payload.add(Character.valueOf(false));
    this.payload.add(Character.valueOf(false));
    this.payload.add(Character.valueOf(false));
    this.payload.add(Character.valueOf(false));
    this.payload.add(Character.valueOf(false));
    this.payload.add(Character.valueOf((char)(int)(paramFloat1 % 256.0F)));
    this.payload.add(Character.valueOf((char)(int)(paramFloat1 / 256.0F)));
    this.payload.add(Character.valueOf((char)(paramInt6 & 0xFF)));
    paramInt1 = (int)(30.0F * paramFloat2);
    this.payload.add(Character.valueOf((char)paramInt1));
    paramInt1 = (int)(30.0F * paramFloat3);
    this.payload.add(Character.valueOf((char)paramInt1));
    paramInt1 = (int)(30.0F * paramFloat4);
    this.payload.add(Character.valueOf((char)paramInt1));
    sendRequestMSP(requestMSP(207, this.payload.<Character>toArray(new Character[this.payload.size()])));
    sendRequestMSP(requestMSP(250));
  }
  
  public void SendRequestMSP_SET_PID_TUNING(float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3) {
    this.payload = new ArrayList<Character>();
    int i;
    for (i = 0; i < 10; i++) {
      this.payload.add(Character.valueOf((char)((int)paramArrayOffloat1[i] & 0xFF)));
      this.payload.add(Character.valueOf((char)((int)paramArrayOffloat2[i] & 0xFF)));
      this.payload.add(Character.valueOf((char)((int)paramArrayOffloat3[i] & 0xFF)));
    } 
    sendRequestMSP(requestMSP(202, this.payload.<Character>toArray(new Character[this.payload.size()])));
    sendRequestMSP(requestMSP(250));
  }
  
  public void SendRequestMSP_SET_RC_TUNING(float[] paramArrayOffloat) {
    this.payload = new ArrayList<Character>();
    for (int i = 0; i < paramArrayOffloat.length; i++)
      this.payload.add(Character.valueOf((char)((int)paramArrayOffloat[i] & 0xFF))); 
    sendRequestMSP(requestMSP(204, this.payload.<Character>toArray(new Character[this.payload.size()])));
    sendRequestMSP(requestMSP(250));
  }
  
  public int read16(byte paramByte1, byte paramByte2) {
    return (paramByte1 & 0xFF) + (paramByte2 << 8);
  }
  
  public int read32(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4) {
    return (paramByte1 & 0xFF) + ((paramByte2 & 0xFF) << 8) + ((paramByte3 & 0xFF) << 16) + ((paramByte4 & 0xFF) << 24);
  }
  
  public int read8(byte paramByte) {
    return paramByte & 0xFF;
  }
  
  public void readMSP(byte[] paramArrayOfbyte) {
    String[] arrayOfString;
    String str1;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    String str8 = null;
    String str9 = null;
    String str10 = null;
    String str11 = null;
    String str12 = null;
    String str13 = null;
    String str2 = null;
    int i = read8(paramArrayOfbyte[4]);
    byte b1 = 0;
    int j = 0;
    int k = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    byte b = 0;
    switch (i & 0xFF) {
      default:
        return;
      case 114:
        for (i = 0; i < 3; i++) {
          if (str2 == null) {
            str2 = String.valueOf((char)paramArrayOfbyte[i]);
          } else {
            str2 = str2 + (char)paramArrayOfbyte[i];
          } 
        } 
        i = 0;
        j = b;
        while (i < 24) {
          j = (byte)(read8(paramArrayOfbyte[i + 3]) & 0xFF ^ j);
          i++;
        } 
        if (str2.equals("$M>") && j == paramArrayOfbyte[27]) {
          float[] arrayOfFloat = new float[12];
          arrayOfFloat[0] = read16(paramArrayOfbyte[5], paramArrayOfbyte[6]);
          arrayOfFloat[1] = read16(paramArrayOfbyte[7], paramArrayOfbyte[8]);
          arrayOfFloat[2] = read16(paramArrayOfbyte[9], paramArrayOfbyte[10]);
          arrayOfFloat[3] = read16(paramArrayOfbyte[11], paramArrayOfbyte[12]);
          arrayOfFloat[4] = read16(paramArrayOfbyte[13], paramArrayOfbyte[14]);
          arrayOfFloat[5] = read16(paramArrayOfbyte[15], paramArrayOfbyte[16]);
          arrayOfFloat[6] = read32(paramArrayOfbyte[17], paramArrayOfbyte[18], paramArrayOfbyte[19], paramArrayOfbyte[20]);
          arrayOfFloat[7] = read16(paramArrayOfbyte[21], paramArrayOfbyte[22]) / 10.0F;
          arrayOfFloat[8] = read8(paramArrayOfbyte[23]);
          arrayOfFloat[9] = read8(paramArrayOfbyte[24]) / 30.0F;
          arrayOfFloat[10] = read8(paramArrayOfbyte[25]) / 30.0F;
          arrayOfFloat[11] = read8(paramArrayOfbyte[26]) / 30.0F;
          this.mHandler.obtainMessage(114, arrayOfFloat.length, -1, arrayOfFloat).sendToTarget();
          return;
        } 
      case 111:
        i = 0;
        str2 = str3;
        while (i < 3) {
          if (str2 == null) {
            str2 = String.valueOf((char)paramArrayOfbyte[i]);
          } else {
            str2 = str2 + (char)paramArrayOfbyte[i];
          } 
          i++;
        } 
        i = 0;
        j = b1;
        while (i < 9) {
          j = (byte)(read8(paramArrayOfbyte[i + 3]) & 0xFF ^ j);
          i++;
        } 
        if (str2.equals("$M>") && j == paramArrayOfbyte[12]) {
          float[] arrayOfFloat = new float[7];
          for (i = 0; i < 7; i++)
            arrayOfFloat[i] = read8(paramArrayOfbyte[i + 5]); 
          this.mHandler.obtainMessage(111, arrayOfFloat.length, -1, arrayOfFloat).sendToTarget();
          return;
        } 
      case 116:
        i = 0;
        str2 = str4;
        while (i < 3) {
          if (str2 == null) {
            str2 = String.valueOf((char)paramArrayOfbyte[i]);
          } else {
            str2 = str2 + (char)paramArrayOfbyte[i];
          } 
          i++;
        } 
        k = paramArrayOfbyte[3];
        for (i = 0; i < k + 2; i++)
          j = (byte)(read8(paramArrayOfbyte[i + 3]) & 0xFF ^ j); 
        if (str2.equals("$M>") && j == paramArrayOfbyte[paramArrayOfbyte.length - 1]) {
          byte[] arrayOfByte = new byte[k];
          for (i = 0; i < k; i++)
            arrayOfByte[i] = paramArrayOfbyte[i + 5]; 
          arrayOfString = (new String(arrayOfByte, 0, arrayOfByte.length)).split(";");
          CHECKBOXITEM = arrayOfString.length;
          this.mHandler.obtainMessage(116, arrayOfString.length, -1, arrayOfString).sendToTarget();
          return;
        } 
      case 113:
        i = 0;
        str2 = str5;
        while (i < 3) {
          if (str2 == null) {
            str2 = String.valueOf((char)arrayOfString[i]);
          } else {
            str2 = str2 + (char)arrayOfString[i];
          } 
          i++;
        } 
        str1 = arrayOfString[3];
        i = 0;
        j = k;
        while (i < str1 + 2) {
          j = (byte)(read8(arrayOfString[i + 3]) & 0xFF ^ j);
          i++;
        } 
        if (str2.equals("$M>") && j == arrayOfString[arrayOfString.length - 1]) {
          int[] arrayOfInt = new int[8];
          j = 5;
          i = CHECKBOXITEM;
          boolean[][] arrayOfBoolean = (boolean[][])Array.newInstance(boolean.class, new int[] { i, 12 });
          i = 0;
          while (i < CHECKBOXITEM) {
            int m = j + 1;
            String str = arrayOfString[j];
            k = m + 1;
            arrayOfInt[i] = read16(str, arrayOfString[m]);
            for (j = 0; j < 12; j++) {
              if ((arrayOfInt[i] & 1 << j) > 0) {
                arrayOfBoolean[i][j] = true;
              } else {
                arrayOfBoolean[i][j] = false;
              } 
            } 
            i++;
            j = k;
          } 
          this.mHandler.obtainMessage(113, arrayOfInt.length, -1, arrayOfBoolean).sendToTarget();
          return;
        } 
      case 110:
        i = 0;
        str2 = str6;
        while (i < 3) {
          if (str2 == null) {
            str2 = String.valueOf((char)arrayOfString[i]);
          } else {
            str2 = str2 + (char)arrayOfString[i];
          } 
          i++;
        } 
        i = 0;
        j = bool1;
        while (i < 9) {
          j = (byte)(read8(arrayOfString[i + 3]) & 0xFF ^ j);
          i++;
        } 
        if (str2.equals("$M>") && j == arrayOfString[12]) {
          float[] arrayOfFloat = new float[4];
          arrayOfFloat[0] = read8(arrayOfString[5]) / 30.0F;
          arrayOfFloat[1] = read16(arrayOfString[6], arrayOfString[7]);
          arrayOfFloat[2] = read16(arrayOfString[8], arrayOfString[9]);
          arrayOfFloat[3] = read16(arrayOfString[10], arrayOfString[11]);
          this.mHandler.obtainMessage(110, arrayOfFloat.length, -1, arrayOfFloat).sendToTarget();
          return;
        } 
      case 105:
        i = 0;
        str2 = str7;
        while (i < 3) {
          if (str2 == null) {
            str2 = String.valueOf((char)arrayOfString[i]);
          } else {
            str2 = str2 + (char)arrayOfString[i];
          } 
          i++;
        } 
        i = 0;
        j = bool2;
        while (i < 18) {
          j = (byte)(read8(arrayOfString[i + 3]) & 0xFF ^ j);
          i++;
        } 
        if (str2.equals("$M>") && j == arrayOfString[21]) {
          int[] arrayOfInt = new int[8];
          i = 0;
          j = 5;
          while (i < 8) {
            k = j + 1;
            String str = arrayOfString[j];
            j = k + 1;
            arrayOfInt[i] = read16(str, arrayOfString[k]);
            i++;
          } 
          this.mHandler.obtainMessage(105, arrayOfInt.length, -1, arrayOfInt).sendToTarget();
          return;
        } 
      case 108:
        i = 0;
        str2 = str8;
        while (i < 3) {
          if (str2 == null) {
            str2 = String.valueOf((char)arrayOfString[i]);
          } else {
            str2 = str2 + (char)arrayOfString[i];
          } 
          i++;
        } 
        i = 0;
        j = bool3;
        while (i < 8) {
          j = (byte)(read8(arrayOfString[i + 3]) & 0xFF ^ j);
          i++;
        } 
        if (str2.equals("$M>") && j == arrayOfString[11]) {
          float[] arrayOfFloat = new float[3];
          i = 0;
          j = 5;
          while (i < 3) {
            k = j + 1;
            String str = arrayOfString[j];
            j = k + 1;
            arrayOfFloat[i] = (read16(str, arrayOfString[k]) / 10);
            i++;
          } 
          this.mHandler.obtainMessage(108, arrayOfFloat.length, -1, arrayOfFloat).sendToTarget();
          return;
        } 
      case 205:
        this.mHandler.obtainMessage(205, 0, -1).sendToTarget();
        return;
      case 206:
        this.mHandler.obtainMessage(206, 0, -1).sendToTarget();
        return;
      case 211:
        this.mHandler.obtainMessage(211, 0, -1).sendToTarget();
        return;
      case 100:
        i = 0;
        str2 = str9;
        while (i < 3) {
          if (str2 == null) {
            str2 = String.valueOf((char)arrayOfString[i]);
          } else {
            str2 = str2 + (char)arrayOfString[i];
          } 
          i++;
        } 
        i = 0;
        j = bool4;
        while (i < 9) {
          j = (byte)(read8(arrayOfString[i + 3]) & 0xFF ^ j);
          i++;
        } 
        if (str2.equals("$M>") && j == arrayOfString[12]) {
          int[] arrayOfInt = new int[4];
          j = 0;
          for (i = 5; j < 3; i++) {
            arrayOfInt[j] = read8(arrayOfString[i]);
            j++;
          } 
          j = i + 1;
          String str14 = arrayOfString[i];
          i = j + 1;
          String str15 = arrayOfString[j];
          j = i + 1;
          arrayOfInt[3] = read32(str14, str15, arrayOfString[i], arrayOfString[j]);
          this.mHandler.obtainMessage(100, arrayOfInt.length, -1, arrayOfInt).sendToTarget();
          return;
        } 
      case 112:
        i = 0;
        str2 = str10;
        while (i < 3) {
          if (str2 == null) {
            str2 = String.valueOf((char)arrayOfString[i]);
          } else {
            str2 = str2 + (char)arrayOfString[i];
          } 
          i++;
        } 
        i = 0;
        j = bool5;
        while (i < 31) {
          j = (byte)(read8(arrayOfString[i + 3]) & 0xFF ^ j);
          i++;
        } 
        if (str2.equals("$M>") && j == arrayOfString[35]) {
          int[] arrayOfInt = new int[30];
          j = 0;
          for (i = 5; j < 30; i++) {
            arrayOfInt[j] = read8(arrayOfString[i]);
            j++;
          } 
          this.mHandler.obtainMessage(112, arrayOfInt.length, -1, arrayOfInt).sendToTarget();
          return;
        } 
      case 106:
        i = 0;
        str2 = str11;
        while (i < 3) {
          if (str2 == null) {
            str2 = String.valueOf((char)arrayOfString[i]);
          } else {
            str2 = str2 + (char)arrayOfString[i];
          } 
          i++;
        } 
        j = 0;
        i = bool6;
        while (true) {
          if (j < 18)
            try {
              k = (byte)(read8(arrayOfString[j + 3]) & 0xFF ^ i);
              j++;
              i = k;
              continue;
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
              j = 0;
              break;
            }  
          if (arrayIndexOutOfBoundsException.equals("$M>") && i == arrayOfString[21]) {
            double[] arrayOfDouble = new double[7];
            k = 5 + 1;
            arrayOfDouble[0] = read8(arrayOfString[5]);
            j = k + 1;
            arrayOfDouble[1] = read8(arrayOfString[k]);
            k = j + 1;
            String str14 = arrayOfString[j];
            j = k + 1;
            String str15 = arrayOfString[k];
            k = j + 1;
            String str16 = arrayOfString[j];
            j = k + 1;
            arrayOfDouble[2] = read32(str14, str15, str16, arrayOfString[k]);
            k = j + 1;
            str14 = arrayOfString[j];
            j = k + 1;
            str15 = arrayOfString[k];
            k = j + 1;
            str16 = arrayOfString[j];
            j = k + 1;
            arrayOfDouble[3] = read32(str14, str15, str16, arrayOfString[k]);
            k = j + 1;
            str14 = arrayOfString[j];
            j = k + 1;
            arrayOfDouble[4] = read16(str14, arrayOfString[k]);
            k = j + 1;
            str14 = arrayOfString[j];
            j = k + 1;
            arrayOfDouble[5] = read16(str14, arrayOfString[k]);
            k = j + 1;
            arrayOfDouble[6] = read16(arrayOfString[j], arrayOfString[k]);
            this.mHandler.obtainMessage(106, arrayOfDouble.length, -1, arrayOfDouble).sendToTarget();
            return;
          } 
        } 
        while (j < 3) {
          i = (byte)(read8(arrayOfString[j + 3]) & 0xFF ^ i);
          j++;
        } 
        this.mHandler.obtainMessage(106, 0, -1, null).sendToTarget();
        return;
      case 102:
        i = 0;
        str2 = str12;
        while (i < 3) {
          if (str2 == null) {
            str2 = String.valueOf((char)arrayOfString[i]);
          } else {
            str2 = str2 + (char)arrayOfString[i];
          } 
          i++;
        } 
        i = 0;
        j = bool7;
        while (i < 20) {
          j = (byte)(read8(arrayOfString[i + 3]) & 0xFF ^ j);
          i++;
        } 
        if (str2.equals("$M>") && j == arrayOfString[23]) {
          int[] arrayOfInt = new int[9];
          j = 5 + 1;
          String str = arrayOfString[5];
          i = j + 1;
          arrayOfInt[0] = read16(str, arrayOfString[j]);
          j = i + 1;
          str = arrayOfString[i];
          i = j + 1;
          arrayOfInt[1] = read16(str, arrayOfString[j]);
          j = i + 1;
          str = arrayOfString[i];
          i = j + 1;
          arrayOfInt[2] = read16(str, arrayOfString[j]);
          j = i + 1;
          str = arrayOfString[i];
          i = j + 1;
          arrayOfInt[3] = read16(str, arrayOfString[j]);
          j = i + 1;
          str = arrayOfString[i];
          i = j + 1;
          arrayOfInt[4] = read16(str, arrayOfString[j]);
          j = i + 1;
          str = arrayOfString[i];
          i = j + 1;
          arrayOfInt[5] = read16(str, arrayOfString[j]);
          j = i + 1;
          str = arrayOfString[i];
          i = j + 1;
          arrayOfInt[6] = read16(str, arrayOfString[j]);
          j = i + 1;
          str = arrayOfString[i];
          i = j + 1;
          arrayOfInt[7] = read16(str, arrayOfString[j]);
          j = i + 1;
          arrayOfInt[8] = read16(arrayOfString[i], arrayOfString[j]);
          this.mHandler.obtainMessage(102, arrayOfInt.length, -1, arrayOfInt).sendToTarget();
          return;
        } 
      case 109:
        break;
    } 
    i = 0;
    str2 = str13;
    while (i < 3) {
      if (str2 == null) {
        str2 = String.valueOf((char)arrayOfString[i]);
      } else {
        str2 = str2 + (char)arrayOfString[i];
      } 
      i++;
    } 
    i = 0;
    j = bool8;
    while (i < 8) {
      j = (byte)(read8(arrayOfString[i + 3]) & 0xFF ^ j);
      i++;
    } 
    if (str2.equals("$M>") && j == arrayOfString[11]) {
      float[] arrayOfFloat = new float[2];
      j = 5 + 1;
      String str14 = arrayOfString[5];
      i = j + 1;
      String str15 = arrayOfString[j];
      j = i + 1;
      String str16 = arrayOfString[i];
      i = j + 1;
      arrayOfFloat[0] = read32(str14, str15, str16, arrayOfString[j]);
      j = i + 1;
      arrayOfFloat[1] = read16(arrayOfString[i], arrayOfString[j]);
      this.mHandler.obtainMessage(109, arrayOfFloat.length, -1, arrayOfFloat).sendToTarget();
      return;
    } 
  }
  
  public List<Byte> requestMSP(int paramInt) {
    return requestMSP(paramInt, null);
  }
  
  public List<Byte> requestMSP(int paramInt, Character[] paramArrayOfCharacter) {
    char c = Character.MIN_VALUE;
    LinkedList<Byte> linkedList = new LinkedList();
    byte[] arrayOfByte = "$M<".getBytes();
    int j = arrayOfByte.length;
    int i;
    for (i = 0; i < j; i++)
      linkedList.add(Byte.valueOf(arrayOfByte[i])); 
    if (paramArrayOfCharacter != null) {
      i = paramArrayOfCharacter.length;
    } else {
      i = 0;
    } 
    byte b = (byte)(i & 0xFF);
    linkedList.add(Byte.valueOf(b));
    i = (byte)(b & 0xFF ^ 0x0);
    linkedList.add(Byte.valueOf((byte)(paramInt & 0xFF)));
    b = (byte)(paramInt & 0xFF ^ i);
    byte b1 = b;
    if (paramArrayOfCharacter != null) {
      i = paramArrayOfCharacter.length;
      paramInt = c;
      while (true) {
        b1 = b;
        if (paramInt < i) {
          c = paramArrayOfCharacter[paramInt].charValue();
          linkedList.add(Byte.valueOf((byte)(c & 0xFF)));
          b = (byte)(c & 0xFF ^ b);
          paramInt++;
          continue;
        } 
        break;
      } 
    } 
    linkedList.add(Byte.valueOf(b1));
    return linkedList;
  }
  
  public void sendRequestMSP(List<Byte> paramList) {
    byte[] arrayOfByte = new byte[paramList.size()];
    int i = 0;
    Iterator<Byte> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      arrayOfByte[i] = ((Byte)iterator.next()).byteValue();
      i++;
    } 
    this.mbluetoothservice.write(arrayOfByte, 1);
  }
  
  public void sendRequestMSP_SET_BOX(boolean[][] paramArrayOfboolean) {
    this.payload = new ArrayList<Character>();
    int[] arrayOfInt = new int[CHECKBOXITEM];
    for (int i = 0; i < CHECKBOXITEM; i++) {
      arrayOfInt[i] = 0;
      for (int j = 0; j < 12; j++) {
        byte b;
        int k = arrayOfInt[i];
        if (paramArrayOfboolean[i][j]) {
          b = 1;
        } else {
          b = 0;
        } 
        arrayOfInt[i] = b * (1 << j) + k;
      } 
      this.payload.add(Character.valueOf((char)(arrayOfInt[i] % 256)));
      this.payload.add(Character.valueOf((char)(arrayOfInt[i] / 256)));
    } 
    sendRequestMSP(requestMSP(203, this.payload.<Character>toArray(new Character[this.payload.size()])));
    sendRequestMSP(requestMSP(250));
  }
  
  public void sendRequestMSP_SET_RAW_RC(int[] paramArrayOfint) {
    Character[] arrayOfCharacter = new Character[16];
    int i = 0;
    int j = 0;
    while (i < 8) {
      int k = j + 1;
      arrayOfCharacter[j] = Character.valueOf((char)(paramArrayOfint[i] & 0xFF));
      j = k + 1;
      arrayOfCharacter[k] = Character.valueOf((char)(paramArrayOfint[i] >> 8 & 0xFF));
      i++;
    } 
    String str = "";
    j = paramArrayOfint.length;
    for (i = 0; i < j; i++) {
      int k = paramArrayOfint[i];
      str = str + String.valueOf(k) + " ";
    } 
    sendRequestMSP(requestMSP(200, arrayOfCharacter));
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Protocol\Multiwii\MSP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */