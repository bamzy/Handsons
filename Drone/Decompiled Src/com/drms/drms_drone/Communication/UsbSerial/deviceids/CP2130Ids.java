package com.drms.drms_drone.Communication.UsbSerial.deviceids;

public class CP2130Ids {
  private static final ConcreteDevice[] cp2130Devices = new ConcreteDevice[] { new ConcreteDevice(4292, 34720) };
  
  public static boolean isDeviceSupported(int paramInt1, int paramInt2) {
    for (int i = 0; i <= cp2130Devices.length - 1; i++) {
      if ((cp2130Devices[i]).vendorId == paramInt1 && (cp2130Devices[i]).productId == paramInt2)
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


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSerial\deviceids\CP2130Ids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */