package com.drms.drms_drone.Communication.UsbSerial.utils;

public class HexData {
  private static final String HEXES = "0123456789ABCDEF";
  
  private static final String HEX_INDICATOR = "0x";
  
  private static final String SPACE = " ";
  
  public static String hex4digits(String paramString) {
    if (paramString.length() == 1)
      return "000" + paramString; 
    if (paramString.length() == 2)
      return "00" + paramString; 
    String str = paramString;
    return (paramString.length() == 3) ? ("0" + paramString) : str;
  }
  
  public static String hexToString(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null) {
      StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
      for (int i = 0; i <= paramArrayOfbyte.length - 1; i++) {
        byte b = paramArrayOfbyte[i];
        stringBuilder.append("0x");
        stringBuilder.append("0123456789ABCDEF".charAt((b & 0xF0) >> 4)).append("0123456789ABCDEF".charAt(b & 0xF));
        stringBuilder.append(" ");
      } 
      return stringBuilder.toString();
    } 
    return null;
  }
  
  public static byte[] stringTobytes(String paramString) {
    paramString = paramString.trim().replaceAll("0x", "").replaceAll("\\s+", "");
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    int j = 0;
    while (i <= paramString.length() - 1) {
      arrayOfByte[j] = (byte)Integer.parseInt(paramString.substring(i, i + 2), 16);
      j++;
      i += 2;
    } 
    return arrayOfByte;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\utils\HexData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */