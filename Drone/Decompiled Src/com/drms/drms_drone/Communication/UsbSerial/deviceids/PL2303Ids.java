package com.drms.drms_drone.Communication.UsbSerial.deviceids;

public class PL2303Ids {
  private static final ConcreteDevice[] pl2303Devices = new ConcreteDevice[] { 
      new ConcreteDevice(1189, 16423), new ConcreteDevice(1659, 8963), new ConcreteDevice(1659, 1211), new ConcreteDevice(1659, 4660), new ConcreteDevice(1659, 43680), new ConcreteDevice(1659, 43682), new ConcreteDevice(1659, 1553), new ConcreteDevice(1659, 1554), new ConcreteDevice(1659, 1545), new ConcreteDevice(1659, 13082), 
      new ConcreteDevice(1659, 775), new ConcreteDevice(1659, 1123), new ConcreteDevice(1367, 8200), new ConcreteDevice(1351, 8200), new ConcreteDevice(1211, 2563), new ConcreteDevice(1211, 2574), new ConcreteDevice(1390, 20483), new ConcreteDevice(1390, 20484), new ConcreteDevice(3770, 4224), new ConcreteDevice(3770, 8320), 
      new ConcreteDevice(3575, 1568), new ConcreteDevice(1412, 45056), new ConcreteDevice(9336, 8200), new ConcreteDevice(5203, 16422), new ConcreteDevice(1841, 1320), new ConcreteDevice(24969, 8296), new ConcreteDevice(4599, 735), new ConcreteDevice(1256, 32769), new ConcreteDevice(4597, 1), new ConcreteDevice(4597, 3), 
      new ConcreteDevice(4597, 4), new ConcreteDevice(4597, 5), new ConcreteDevice(1861, 1), new ConcreteDevice(1931, 4660), new ConcreteDevice(4277, 44144), new ConcreteDevice(1947, 39), new ConcreteDevice(1043, 8449), new ConcreteDevice(3669, 4363), new ConcreteDevice(1841, 8195), new ConcreteDevice(1293, 599), 
      new ConcreteDevice(1423, 38688), new ConcreteDevice(4598, 8193), new ConcreteDevice(1962, 42), new ConcreteDevice(1453, 4026), new ConcreteDevice(21362, 8963), new ConcreteDevice(1008, 2873), new ConcreteDevice(1008, 12601), new ConcreteDevice(1008, 12857), new ConcreteDevice(1008, 13604), new ConcreteDevice(1208, 1313), 
      new ConcreteDevice(1208, 1314), new ConcreteDevice(1356, 1079), new ConcreteDevice(4525, 1), new ConcreteDevice(2915, 25904), new ConcreteDevice(2956, 8963), new ConcreteDevice(4362, 4432), new ConcreteDevice(1367, 8200) };
  
  public static boolean isDeviceSupported(int paramInt1, int paramInt2) {
    for (int i = 0; i <= pl2303Devices.length - 1; i++) {
      if ((pl2303Devices[i]).vendorId == paramInt1 && (pl2303Devices[i]).productId == paramInt2)
        return true; 
    } 
    return false;
  }
  
  private static class ConcreteDevice {
    public int productId;
    
    public int vendorId;
    
    public ConcreteDevice(int param1Int1, int param1Int2) {
      this.vendorId = param1Int1;
      this.productId = param1Int2;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSerial\deviceids\PL2303Ids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */