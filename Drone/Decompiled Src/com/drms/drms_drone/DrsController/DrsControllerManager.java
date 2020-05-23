package com.drms.drms_drone.DrsController;

import android.app.Service;
import android.content.Intent;
import com.drms.drms_drone.MultiData;

public class DrsControllerManager {
  private static final String TAG = "DrsControllerManager";
  
  private int d1;
  
  private int d2;
  
  private int d3;
  
  private int d4;
  
  private int d5;
  
  private int d6;
  
  private int left_resistor;
  
  private MultiData multiData;
  
  private int pitch;
  
  private int pitch_tream;
  
  private int power;
  
  private int right_resistor;
  
  private int roll;
  
  private int roll_tream;
  
  private Service service;
  
  private int throttle;
  
  private int yaw;
  
  private int yaw_tream;
  
  public DrsControllerManager(Service paramService) {
    this.service = paramService;
    this.multiData = (MultiData)paramService.getApplication();
  }
  
  private void setAccCalibration(int paramInt) {
    if (paramInt == 200)
      this.service.sendBroadcast(new Intent("request acc calibration")); 
  }
  
  private void setDroneSpeed(int paramInt) {
    if (paramInt == 200) {
      if (this.multiData.getDRONE_SPEED() == 100) {
        this.multiData.setDRONE_SPEED(200);
        return;
      } 
    } else {
      return;
    } 
    if (this.multiData.getDRONE_SPEED() == 200) {
      this.multiData.setDRONE_SPEED(300);
      return;
    } 
    if (this.multiData.getDRONE_SPEED() == 300) {
      this.multiData.setDRONE_SPEED(350);
      return;
    } 
    if (this.multiData.getDRONE_SPEED() == 350) {
      this.multiData.setDRONE_SPEED(400);
      return;
    } 
    if (this.multiData.getDRONE_SPEED() == 400) {
      this.multiData.setDRONE_SPEED(100);
      return;
    } 
  }
  
  private void setNextDisplay(int paramInt) {
    if (paramInt == 200)
      this.service.sendBroadcast(new Intent("con.drms.drms_drone.NEXT_DISPLAY")); 
  }
  
  private void setPower(int paramInt) {
    if (this.power == 200) {
      if (this.multiData.getRcdata()[7] == 2000) {
        this.multiData.setRawRCDataAux(4, 1000);
        return;
      } 
    } else {
      return;
    } 
    if (this.multiData.getRcdata()[7] == 1000) {
      this.multiData.setRawRCDataAux(4, 2000);
      return;
    } 
  }
  
  private void setPreviousDisplay(int paramInt) {
    if (paramInt == 200)
      this.service.sendBroadcast(new Intent("com.drms.drms_drone.PREVIOUS_DISPLAY")); 
  }
  
  private void setRPYT(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.roll = (paramInt1 - 1500) * this.multiData.getDRONE_SPEED() / 500 + 1500 + this.multiData.getTream()[0];
    this.pitch = (paramInt2 - 1500) * this.multiData.getDRONE_SPEED() / 500 + 1500 + this.multiData.getTream()[1];
    this.yaw = (paramInt3 - 1500) * this.multiData.getDRONE_SPEED() / 500 + 1500 + this.multiData.getTream()[2];
    this.multiData.setRawRCDataRollPitch(this.roll, this.pitch);
    this.multiData.setRawRCDataYawThrottle(this.yaw, this.throttle);
  }
  
  private void setTream(int paramInt1, int paramInt2, int paramInt3) {
    int[] arrayOfInt = this.multiData.getTream();
    int i = this.multiData.getTreamInterval();
    if (paramInt1 == 200) {
      arrayOfInt[0] = arrayOfInt[0] + i;
    } else if (paramInt1 == 100) {
      arrayOfInt[0] = arrayOfInt[0] - i;
    } else if (paramInt1 == 150) {
    
    } 
    if (paramInt2 == 200) {
      arrayOfInt[1] = arrayOfInt[1] + i;
    } else if (paramInt2 == 100) {
      arrayOfInt[1] = arrayOfInt[1] - i;
    } else if (paramInt2 == 150) {
    
    } 
    if (paramInt3 == 200) {
      arrayOfInt[2] = arrayOfInt[2] + i;
    } else if (paramInt3 == 100) {
      arrayOfInt[2] = arrayOfInt[2] - i;
    } else if (paramInt3 == 150) {
    
    } 
    this.multiData.setRollTream(arrayOfInt[0]);
    this.multiData.setPitchTream(arrayOfInt[1]);
    this.multiData.setYawTream(arrayOfInt[2]);
  }
  
  public boolean processControllerData(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte.length > 0) {
      if ((char)paramArrayOfbyte[0] == '#' && paramArrayOfbyte.length == 28) {
        int[] arrayOfInt = new int[14];
        String str = "";
        int i;
        for (i = 0; i < 5; i++)
          str = str + (char)paramArrayOfbyte[i]; 
        byte b = 0;
        if (str.equals("#cont")) {
          int j = 0;
          for (i = 5; j < 22; i++) {
            b = (byte)(paramArrayOfbyte[i] ^ b);
            j++;
          } 
          if (b == paramArrayOfbyte[paramArrayOfbyte.length - 1]) {
            j = 5 + 1;
            byte b1 = paramArrayOfbyte[5];
            i = j + 1;
            this.roll = read16(b1, paramArrayOfbyte[j]);
            j = i + 1;
            b1 = paramArrayOfbyte[i];
            i = j + 1;
            this.pitch = read16(b1, paramArrayOfbyte[j]);
            j = i + 1;
            b1 = paramArrayOfbyte[i];
            i = j + 1;
            this.yaw = read16(b1, paramArrayOfbyte[j]);
            j = i + 1;
            b1 = paramArrayOfbyte[i];
            i = j + 1;
            this.throttle = read16(b1, paramArrayOfbyte[j]);
            j = i + 1;
            this.power = read8(paramArrayOfbyte[i]);
            i = j + 1;
            this.d1 = read8(paramArrayOfbyte[j]);
            j = i + 1;
            this.d2 = read8(paramArrayOfbyte[i]);
            i = j + 1;
            this.d3 = read8(paramArrayOfbyte[j]);
            j = i + 1;
            this.d4 = read8(paramArrayOfbyte[i]);
            i = j + 1;
            this.d5 = read8(paramArrayOfbyte[j]);
            j = i + 1;
            this.d6 = read8(paramArrayOfbyte[i]);
            i = j + 1;
            b1 = paramArrayOfbyte[j];
            j = i + 1;
            this.left_resistor = read16(b1, paramArrayOfbyte[i]);
            i = j + 1;
            b1 = paramArrayOfbyte[j];
            j = i + 1;
            this.right_resistor = read16(b1, paramArrayOfbyte[i]);
            i = j + 1;
            this.roll_tream = read8(paramArrayOfbyte[j]);
            j = i + 1;
            this.pitch_tream = read8(paramArrayOfbyte[i]);
            this.yaw_tream = read8(paramArrayOfbyte[j]);
            setRPYT(this.roll, this.pitch, this.yaw, this.throttle);
            setPower(this.power);
            setDroneSpeed(this.d1);
            setAccCalibration(this.d6);
            setTream(this.roll_tream, this.pitch_tream, this.yaw_tream);
            setPreviousDisplay(this.d4);
            setNextDisplay(this.d5);
            return true;
          } 
        } 
        return false;
      } 
    } else {
      return false;
    } 
    return true;
  }
  
  public int read16(byte paramByte1, byte paramByte2) {
    return (paramByte1 & 0xFF) + (paramByte2 << 8);
  }
  
  public int read8(byte paramByte) {
    return paramByte & 0xFF;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\DrsController\DrsControllerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */