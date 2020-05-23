package com.drms.drms_drone.Communication.UsbSerial.deviceids;

public class XdcVcpIds {
  private static final ConcreteDevice[] xdcvcpDevices = new ConcreteDevice[] { new ConcreteDevice(9805, 562), new ConcreteDevice(9805, 288) };
  
  public static boolean isDeviceSupported(int paramInt1, int paramInt2) {
    for (int i = 0; i <= xdcvcpDevices.length - 1; i++) {
      if ((xdcvcpDevices[i]).vendorId == paramInt1 && (xdcvcpDevices[i]).productId == paramInt2)
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


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSerial\deviceids\XdcVcpIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */