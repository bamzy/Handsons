package com.drms.drms_drone;

import android.app.Application;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import java.lang.reflect.Array;

public final class MultiData extends Application {
  private static String BtAddress;
  
  private static String BtName = "";
  
  private static long DISCOVER_LOOP = 0L;
  
  public static final int DUAL1 = 0;
  
  public static final int DUAL2 = 1;
  
  public static final int PITCH_DOWN = 2;
  
  public static final int PITCH_UP = 3;
  
  public static final int ROLL_DOWN = 0;
  
  public static final int ROLL_UP = 1;
  
  public static final int SINGLE = 2;
  
  public static final int YAW_DOWN = 4;
  
  public static final int YAW_UP = 5;
  
  public static final int fast = 350;
  
  public static final int middle = 300;
  
  public static final int slow = 200;
  
  public static final int veryfast = 400;
  
  public static final int veryslow = 100;
  
  private float[] ALTITUDEdata = new float[] { 0.0F, 0.0F };
  
  private String[] BOX_ITEM;
  
  private int DRONE_SPEED = 300;
  
  private byte[] HEX_GY521_EEPROM = new byte[] { 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, 33, 30, 23, 33, 
      30, 23, 68, 45, 0, 64, 25, 24, 15, 0, 
      0, 34, 14, 53, 25, 33, 83, 90, 10, 100, 
      40, -1, -1, 0, 0, 0, 90, 65, 0, 0, 
      0, 50, 0, 0, 0, 0, 0, 0, 8, 7, 
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      0, 0, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -30, 4, 
      10, 107, 100, 84, 26, 4, 10, 120, 0, 41 };
  
  private int[] IMUdata = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  private float[] MISCdata = new float[] { 
      0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 
      0.0F, 0.0F };
  
  private int MSP_TIME = 23;
  
  private int MYJOYSTICK = 0;
  
  private int[] PIDdata = new int[] { 
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  private byte[] QUAD_GY521_EEPROM = new byte[] { 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, 33, 30, 23, 33, 
      30, 23, 68, 45, 0, 64, 25, 24, 15, 0, 
      0, 34, 14, 53, 25, 33, 83, 90, 10, 100, 
      40, -1, -1, 0, 0, 0, 87, 62, 0, 0, 
      0, 50, 0, 0, 0, 0, 0, 0, 8, 7, 
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      0, 0, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -30, 4, 
      10, 84, 75, 69, 26, 4, 10, 120, 0, -28 };
  
  private float[] RCTUNEdata = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
  private float[] analogData = new float[] { 4.2F, 0.0F, 0.0F, 0.0F };
  
  private float[] attitudeData = new float[] { 0.0F, 0.0F, 0.0F };
  
  private boolean[] calibration = new boolean[] { false, false };
  
  private boolean[][] checkboxData;
  
  public boolean controllerConnected = false;
  
  private int[] identData = new int[] { 0, 0, 0, 0 };
  
  private boolean locked = false;
  
  private int mobile_vbat = 0;
  
  private int[] rawRCData = new int[] { 1500, 1500, 1500, 1000, 1000, 1000, 1000, 1000 };
  
  private int[] rcdata = new int[] { 1500, 1500, 1500, 1000, 1000, 1000, 1000, 1000 };
  
  private int[] receivedRcdata = new int[] { 1500, 1500, 1500, 1000, 1000, 1000, 1000, 1000 };
  
  private boolean[][] sendcheckboxData = (boolean[][])Array.newInstance(boolean.class, new int[] { 8, 12 });
  
  private int smartphoneAngle = 50;
  
  private int[] tream = new int[] { 0, 0, 0 };
  
  private int treamInterval = 3;
  
  private boolean[] tream_touched = new boolean[] { false, false, false, false, false, false };
  
  private TextToSpeech tts;
  
  static {
    BtAddress = "";
    DISCOVER_LOOP = 7000L;
  }
  
  public float[] getALTITUDEdata() {
    return this.ALTITUDEdata;
  }
  
  public float[] getAnalogData() {
    return this.analogData;
  }
  
  public float[] getAttitudeData() {
    return this.attitudeData;
  }
  
  public String[] getBoxITEM() {
    return this.BOX_ITEM;
  }
  
  public boolean[] getCalibration() {
    return this.calibration;
  }
  
  public boolean[][] getCheckboxData() {
    return this.checkboxData;
  }
  
  public int getDRONE_SPEED() {
    return this.DRONE_SPEED;
  }
  
  public long getDiscoverLoop() {
    return DISCOVER_LOOP;
  }
  
  public byte[] getHEX_GY521_EEPROM() {
    return this.QUAD_GY521_EEPROM;
  }
  
  public int[] getIMUdata() {
    return this.IMUdata;
  }
  
  public boolean getLocked() {
    return this.locked;
  }
  
  public float[] getMISCdata() {
    return this.MISCdata;
  }
  
  public int getMSP_TIME() {
    return this.MSP_TIME;
  }
  
  public int getMYJOYSTICK() {
    return this.MYJOYSTICK;
  }
  
  public int getMobile_vbat() {
    return this.mobile_vbat;
  }
  
  public int[] getPIDdata() {
    return this.PIDdata;
  }
  
  public byte[] getQUAD_GY521_EEPROM() {
    return this.QUAD_GY521_EEPROM;
  }
  
  public float[] getRCTUNEdata() {
    return this.RCTUNEdata;
  }
  
  public int[] getRcdata() {
    return this.rawRCData;
  }
  
  public int[] getReceivedRcdata() {
    return this.receivedRcdata;
  }
  
  public int getSmartphoneAngle() {
    return this.smartphoneAngle;
  }
  
  public int[] getTream() {
    return this.tream;
  }
  
  public int getTreamInterval() {
    return this.treamInterval;
  }
  
  public boolean[] getTream_touched() {
    return this.tream_touched;
  }
  
  public void initBoxITEM(String[] paramArrayOfString) {
    this.BOX_ITEM = paramArrayOfString;
    int i = this.BOX_ITEM.length;
    this.checkboxData = (boolean[][])Array.newInstance(boolean.class, new int[] { i, 12 });
    Log.d("ContentValues", "box item length : " + paramArrayOfString.length);
  }
  
  public void initializeMultiData() {
    this.mobile_vbat = 0;
    this.rcdata[0] = 1500;
    this.rcdata[1] = 1500;
    this.rcdata[2] = 1500;
    this.rcdata[3] = 1000;
    this.rcdata[4] = 1000;
    this.rcdata[5] = 1000;
    this.rcdata[6] = 1000;
    this.rcdata[7] = 1000;
    this.receivedRcdata[0] = 1500;
    this.receivedRcdata[1] = 1500;
    this.receivedRcdata[2] = 1500;
    this.receivedRcdata[3] = 1000;
    this.receivedRcdata[4] = 1000;
    this.receivedRcdata[5] = 1000;
    this.receivedRcdata[6] = 1000;
    this.receivedRcdata[7] = 1000;
    this.attitudeData[0] = 0.0F;
    this.attitudeData[1] = 0.0F;
    this.attitudeData[2] = 0.0F;
    this.analogData[0] = 4.2F;
    this.analogData[1] = 0.0F;
    this.analogData[2] = 0.0F;
    this.analogData[3] = 0.0F;
    this.rawRCData[0] = 1500;
    this.rawRCData[1] = 1500;
    this.rawRCData[2] = 1500;
    this.rawRCData[3] = 1000;
    this.rawRCData[4] = 1000;
    this.rawRCData[5] = 1000;
    this.rawRCData[6] = 1000;
    this.rawRCData[7] = 1000;
    this.calibration[0] = false;
    this.calibration[1] = false;
    int i;
    for (i = 0; i < this.IMUdata.length; i++)
      this.IMUdata[i] = 0; 
    for (i = 0; i < this.MISCdata.length; i++)
      this.MISCdata[i] = 0.0F; 
    for (i = 0; i < this.RCTUNEdata.length; i++)
      this.RCTUNEdata[0] = 0.0F; 
    for (i = 0; i < this.PIDdata.length; i++)
      this.PIDdata[i] = 0; 
    if (this.BOX_ITEM != null)
      for (i = 0; i < this.BOX_ITEM.length; i++) {
        for (int j = 0; j < 12; j++)
          this.checkboxData[i][j] = false; 
      }  
    this.BOX_ITEM = null;
  }
  
  public boolean isControllerConnected() {
    return this.controllerConnected;
  }
  
  public void setACCCalibration(boolean paramBoolean) {
    this.calibration[0] = paramBoolean;
  }
  
  public void setALTITUDEdata(float[] paramArrayOffloat) {
    this.ALTITUDEdata = paramArrayOffloat;
  }
  
  public void setAnalogData(float[] paramArrayOffloat) {
    this.analogData = paramArrayOffloat;
    if (this.analogData[0] < 2.5D) {
      if (this.analogData[0] >= 0.0F && this.analogData[0] < 0.2D) {
        this.analogData[0] = 0.1F;
        return;
      } 
    } else {
      return;
    } 
    this.analogData[0] = 2.5F;
  }
  
  public void setAttitudeData(float[] paramArrayOffloat) {
    this.attitudeData = paramArrayOffloat;
  }
  
  public void setCheckboxData(boolean[][] paramArrayOfboolean) {
    this.checkboxData = paramArrayOfboolean;
  }
  
  public void setControllerConnected(boolean paramBoolean) {
    this.controllerConnected = paramBoolean;
  }
  
  public void setDRONE_SPEED(int paramInt) {
    Log.d("ContentValues", "drone speed : " + paramInt);
    this.DRONE_SPEED = paramInt;
  }
  
  public void setDiscoverLoop(long paramLong) {
    DISCOVER_LOOP = paramLong;
  }
  
  public void setEachCheckboxData(int paramInt1, int paramInt2, boolean paramBoolean) {
    this.checkboxData[paramInt1][paramInt2] = paramBoolean;
  }
  
  public void setIMUdata(int[] paramArrayOfint) {
    this.IMUdata = paramArrayOfint;
  }
  
  public void setLocked(boolean paramBoolean) {
    this.locked = paramBoolean;
  }
  
  public void setMAGCalibration(boolean paramBoolean) {
    this.calibration[1] = paramBoolean;
  }
  
  public void setMISCdata(float[] paramArrayOffloat) {
    this.MISCdata = paramArrayOffloat;
  }
  
  public void setMYJOYSTICK(int paramInt) {
    this.MYJOYSTICK = paramInt;
  }
  
  public void setMobile_vbat(int paramInt) {
    this.mobile_vbat = paramInt;
  }
  
  public void setPIDdata(int[] paramArrayOfint) {
    this.PIDdata = paramArrayOfint;
  }
  
  public void setPitchTream(int paramInt) {
    int i = paramInt;
    if (paramInt >= 127)
      i = 127; 
    paramInt = i;
    if (i <= -127)
      paramInt = -127; 
    this.tream[1] = paramInt;
  }
  
  public void setRCTUNEdata(float[] paramArrayOffloat) {
    this.RCTUNEdata = paramArrayOffloat;
  }
  
  public void setRawRCDataAux(int paramInt1, int paramInt2) {
    this.rawRCData[paramInt1 + 3] = paramInt2;
  }
  
  public void setRawRCDataRollPitch(int paramInt1, int paramInt2) {
    this.rawRCData[0] = paramInt1;
    this.rawRCData[1] = paramInt2;
  }
  
  public void setRawRCDataYawThrottle(int paramInt1, int paramInt2) {
    this.rawRCData[2] = paramInt1;
    this.rawRCData[3] = paramInt2;
  }
  
  public void setRcdata(int[] paramArrayOfint) {
    this.rcdata = paramArrayOfint;
  }
  
  public void setReceivedRcdata(int[] paramArrayOfint) {
    this.receivedRcdata = paramArrayOfint;
  }
  
  public void setRollTream(int paramInt) {
    int i = paramInt;
    if (paramInt >= 127)
      i = 127; 
    paramInt = i;
    if (i <= -127)
      paramInt = -127; 
    this.tream[0] = paramInt;
  }
  
  public void setSmartphoneAngle(int paramInt) {
    this.smartphoneAngle = paramInt;
  }
  
  public void setTreamInterval(int paramInt) {
    this.treamInterval = paramInt;
  }
  
  public void setTream_touched(int paramInt, boolean paramBoolean) {
    this.tream_touched[paramInt] = paramBoolean;
  }
  
  public void setYawTream(int paramInt) {
    int i = paramInt;
    if (paramInt >= 127)
      i = 127; 
    paramInt = i;
    if (i <= -127)
      paramInt = -127; 
    this.tream[2] = paramInt;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\MultiData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */