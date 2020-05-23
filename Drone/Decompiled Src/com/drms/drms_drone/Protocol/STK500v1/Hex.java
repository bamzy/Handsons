package com.drms.drms_drone.Protocol.STK500v1;

import java.util.ArrayList;

public class Hex {
  private ArrayList<ArrayList<Byte>> binList = new ArrayList<ArrayList<Byte>>();
  
  private ArrayList<Byte> dataList = new ArrayList<Byte>();
  
  private boolean state = false;
  
  private byte[] subHex;
  
  public Hex(byte[] paramArrayOfbyte) {
    this.subHex = paramArrayOfbyte;
    this.state = splitHex();
  }
  
  public static String bytesToHex(byte[] paramArrayOfbyte) {
    char[] arrayOfChar1 = new char[16];
    arrayOfChar1[0] = '0';
    arrayOfChar1[1] = '1';
    arrayOfChar1[2] = '2';
    arrayOfChar1[3] = '3';
    arrayOfChar1[4] = '4';
    arrayOfChar1[5] = '5';
    arrayOfChar1[6] = '6';
    arrayOfChar1[7] = '7';
    arrayOfChar1[8] = '8';
    arrayOfChar1[9] = '9';
    arrayOfChar1[10] = 'a';
    arrayOfChar1[11] = 'b';
    arrayOfChar1[12] = 'c';
    arrayOfChar1[13] = 'd';
    arrayOfChar1[14] = 'e';
    arrayOfChar1[15] = 'f';
    char[] arrayOfChar2 = new char[paramArrayOfbyte.length * 5];
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      int j = paramArrayOfbyte[i] & 0xFF;
      arrayOfChar2[i * 5] = '[';
      arrayOfChar2[i * 5 + 1] = arrayOfChar1[j >>> 4];
      arrayOfChar2[i * 5 + 2] = arrayOfChar1[j & 0xF];
      arrayOfChar2[i * 5 + 3] = ']';
      arrayOfChar2[i * 5 + 4] = ' ';
    } 
    return new String(arrayOfChar2);
  }
  
  private boolean checkData(byte[] paramArrayOfbyte, int paramInt) {
    int j = 0;
    for (int i = 0; i < paramArrayOfbyte.length - 2; i++)
      j += this.subHex[paramInt + i + 1]; 
    return ((byte)((byte)(256 - j) & 0xFF) == paramArrayOfbyte[paramArrayOfbyte.length - 1 & 0xFF]);
  }
  
  private byte[] formatHexLine(int paramInt1, int paramInt2) throws IndexOutOfBoundsException {
    try {
      this.dataList.get(paramInt1);
      int i = paramInt2;
      if (paramInt1 + paramInt2 > this.dataList.size())
        i = this.dataList.size() - paramInt1; 
      byte[] arrayOfByte = new byte[i];
      for (paramInt2 = 0; paramInt2 < i; paramInt2++)
        arrayOfByte[paramInt2] = ((Byte)this.dataList.get(paramInt1 + paramInt2)).byteValue(); 
    } catch (Exception exception) {
      throw new IndexOutOfBoundsException("Index " + paramInt1 + " is out of bounds!");
    } 
    return (byte[])exception;
  }
  
  public static String oneByteToHex(byte paramByte) {
    return new String(bytesToHex(new byte[] { paramByte }));
  }
  
  private int splitHex(int paramInt) {
    if (this.subHex.length + paramInt >= 6) {
      byte b = this.subHex[paramInt + 1];
      if (this.subHex[paramInt] == 58 && (this.subHex[paramInt + 4] != 1 || b <= 0) && (this.subHex[paramInt + 4] != 1 || this.subHex.length <= paramInt + b + 6) && (this.subHex[paramInt + 4] != 0 || this.subHex[paramInt + 1] != 0)) {
        this.binList.add(new ArrayList<Byte>());
        byte[] arrayOfByte = new byte[this.subHex[paramInt + 1] + 6];
        arrayOfByte[0] = this.subHex[paramInt + 1];
        arrayOfByte[1] = this.subHex[paramInt + 2];
        arrayOfByte[2] = this.subHex[paramInt + 3];
        arrayOfByte[3] = this.subHex[paramInt + 4];
        int i;
        for (i = 0; i < b; i++)
          arrayOfByte[i] = this.subHex[i + paramInt + 5]; 
        arrayOfByte[arrayOfByte.length - 1] = this.subHex[paramInt + 5 + b];
        if (checkData(arrayOfByte, paramInt)) {
          i = 0;
          while (true) {
            if (i < b) {
              try {
                this.dataList.add(Byte.valueOf(this.subHex[paramInt + i + 5]));
                i++;
              } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                return -1;
              } 
              continue;
            } 
            return paramInt + b + 6;
          } 
        } 
      } 
    } 
    return -1;
  }
  
  private boolean splitHex() {
    int i = 0;
    while (i < this.subHex.length) {
      int j = splitHex(i);
      i = j;
      if (j < 0)
        return false; 
    } 
    return true;
  }
  
  public boolean getChecksumStatus() {
    return this.state;
  }
  
  public int getDataSize() {
    return this.dataList.size();
  }
  
  public byte[] getHexLine(int paramInt1, int paramInt2) {
    try {
      return formatHexLine(paramInt1, paramInt2);
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      return new byte[0];
    } 
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Protocol\STK500v1\Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */