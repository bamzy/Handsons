package com.drms.drms_drone.Communication.UsbSerial.deviceids;

public class CH34xIds {
  private static final ConcreteDevice[] ch34xDevices = new ConcreteDevice[] { new ConcreteDevice(17224, 21795), new ConcreteDevice(6790, 29987), new ConcreteDevice(6790, 21795), new ConcreteDevice(6790, 1093) };
  
  public static boolean isDeviceSupported(int paramInt1, int paramInt2) {
    for (int i = 0; i <= ch34xDevices.length - 1; i++) {
      if ((ch34xDevices[i]).vendorId == paramInt1 && (ch34xDevices[i]).productId == paramInt2)
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


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSerial\deviceids\CH34xIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */