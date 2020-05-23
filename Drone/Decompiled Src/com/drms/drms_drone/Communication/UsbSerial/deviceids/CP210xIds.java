package com.drms.drms_drone.Communication.UsbSerial.deviceids;

public class CP210xIds {
  private static final ConcreteDevice[] cp210xDevices = new ConcreteDevice[] { 
      new ConcreteDevice(1115, 83), new ConcreteDevice(1137, 1642), new ConcreteDevice(1161, 57344), new ConcreteDevice(1161, 57347), new ConcreteDevice(1861, 4096), new ConcreteDevice(2118, 4352), new ConcreteDevice(2278, 21761), new ConcreteDevice(2301, 10), new ConcreteDevice(3053, 4352), new ConcreteDevice(3053, 4353), 
      new ConcreteDevice(4047, 4099), new ConcreteDevice(4047, 4100), new ConcreteDevice(4047, 4102), new ConcreteDevice(4062, 51717), new ConcreteDevice(4262, 43558), new ConcreteDevice(4267, 4293), new ConcreteDevice(4277, 44144), new ConcreteDevice(4292, 3985), new ConcreteDevice(4292, 4353), new ConcreteDevice(4292, 5633), 
      new ConcreteDevice(4292, 32778), new ConcreteDevice(4292, 32827), new ConcreteDevice(4292, 32836), new ConcreteDevice(4292, 32846), new ConcreteDevice(4292, 32851), new ConcreteDevice(4292, 32852), new ConcreteDevice(4292, 32870), new ConcreteDevice(4292, 32879), new ConcreteDevice(4292, 32890), new ConcreteDevice(4292, 32964), 
      new ConcreteDevice(4292, 32970), new ConcreteDevice(4292, 32989), new ConcreteDevice(4292, 33014), new ConcreteDevice(4292, 33045), new ConcreteDevice(4292, 33085), new ConcreteDevice(4292, 33087), new ConcreteDevice(4292, 33098), new ConcreteDevice(4292, 33099), new ConcreteDevice(9221, 3), new ConcreteDevice(4292, 33110), 
      new ConcreteDevice(4292, 33118), new ConcreteDevice(4292, 33119), new ConcreteDevice(4292, 33163), new ConcreteDevice(4292, 33183), new ConcreteDevice(4292, 33190), new ConcreteDevice(4292, 33193), new ConcreteDevice(4292, 33196), new ConcreteDevice(4292, 33197), new ConcreteDevice(4292, 33224), new ConcreteDevice(4292, 33250), 
      new ConcreteDevice(4292, 33255), new ConcreteDevice(4292, 33256), new ConcreteDevice(4292, 33266), new ConcreteDevice(4292, 33304), new ConcreteDevice(4292, 33323), new ConcreteDevice(4292, 33387), new ConcreteDevice(4292, 33409), new ConcreteDevice(4292, 33427), new ConcreteDevice(4292, 33529), new ConcreteDevice(4292, 33601), 
      new ConcreteDevice(4292, 33666), new ConcreteDevice(4292, 33704), new ConcreteDevice(4292, 33752), new ConcreteDevice(4292, 33809), new ConcreteDevice(4292, 33816), new ConcreteDevice(4292, 33902), new ConcreteDevice(4292, 33911), new ConcreteDevice(4292, 34282), new ConcreteDevice(4292, 34283), new ConcreteDevice(4292, 34296), 
      new ConcreteDevice(4292, 34404), new ConcreteDevice(4292, 34405), new ConcreteDevice(4292, 34980), new ConcreteDevice(4292, 34981), new ConcreteDevice(4292, 60000), new ConcreteDevice(4292, 60001), new ConcreteDevice(4292, 60016), new ConcreteDevice(4292, 60032), new ConcreteDevice(4292, 60017), new ConcreteDevice(4292, 61441), 
      new ConcreteDevice(4292, 61442), new ConcreteDevice(4292, 61443), new ConcreteDevice(4292, 61444), new ConcreteDevice(4293, 60001), new ConcreteDevice(4302, 60010), new ConcreteDevice(5037, 39321), new ConcreteDevice(5461, 4), new ConcreteDevice(5738, 513), new ConcreteDevice(5738, 769), new ConcreteDevice(5738, 771), 
      new ConcreteDevice(5738, 772), new ConcreteDevice(5738, 773), new ConcreteDevice(5738, 1025), new ConcreteDevice(5738, 257), new ConcreteDevice(5846, 1), new ConcreteDevice(5852, 16), new ConcreteDevice(5852, 17), new ConcreteDevice(5852, 18), new ConcreteDevice(5852, 21), new ConcreteDevice(6056, 1), 
      new ConcreteDevice(6056, 5), new ConcreteDevice(6132, 43690), new ConcreteDevice(6211, 512), new ConcreteDevice(6383, 57359), new ConcreteDevice(6875, 1), new ConcreteDevice(7139, 1958), new ConcreteDevice(7721, 258), new ConcreteDevice(7721, 1281), new ConcreteDevice(8121, 256), new ConcreteDevice(8121, 512), 
      new ConcreteDevice(8121, 513), new ConcreteDevice(8121, 514), new ConcreteDevice(8121, 515), new ConcreteDevice(8121, 768), new ConcreteDevice(8121, 769), new ConcreteDevice(8121, 770), new ConcreteDevice(8121, 771), new ConcreteDevice(8121, 1024), new ConcreteDevice(8121, 1025), new ConcreteDevice(8121, 1026), 
      new ConcreteDevice(8121, 1027), new ConcreteDevice(8121, 1028), new ConcreteDevice(8121, 1536), new ConcreteDevice(8121, 1537), new ConcreteDevice(8121, 1538), new ConcreteDevice(8121, 1792), new ConcreteDevice(8121, 1793), new ConcreteDevice(12693, 61840), new ConcreteDevice(12693, 62080), new ConcreteDevice(12693, 62081), 
      new ConcreteDevice(16700, 38144) };
  
  public static boolean isDeviceSupported(int paramInt1, int paramInt2) {
    for (int i = 0; i <= cp210xDevices.length - 1; i++) {
      if ((cp210xDevices[i]).vendorId == paramInt1 && (cp210xDevices[i]).productId == paramInt2)
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


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSerial\deviceids\CP210xIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */