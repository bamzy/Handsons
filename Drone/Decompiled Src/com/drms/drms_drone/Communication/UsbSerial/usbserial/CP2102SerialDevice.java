package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public class CP2102SerialDevice extends UsbSerialDevice {
  private static final String CLASS_ID = CP2102SerialDevice.class.getSimpleName();
  
  private static final int CP210x_GET_COMM_STATUS = 16;
  
  private static final int CP210x_GET_LINE_CTL = 4;
  
  private static final int CP210x_GET_MDMSTS = 8;
  
  private static final int CP210x_IFC_ENABLE = 0;
  
  private static final int CP210x_LINE_CTL_DEFAULT = 2048;
  
  private static final int CP210x_MHS_ALL = 17;
  
  private static final int CP210x_MHS_DEFAULT = 0;
  
  private static final int CP210x_MHS_DTR = 1;
  
  private static final int CP210x_MHS_DTR_OFF = 256;
  
  private static final int CP210x_MHS_DTR_ON = 257;
  
  private static final int CP210x_MHS_RTS = 16;
  
  private static final int CP210x_MHS_RTS_OFF = 512;
  
  private static final int CP210x_MHS_RTS_ON = 514;
  
  private static final int CP210x_REQTYPE_DEVICE2HOST = 193;
  
  private static final int CP210x_REQTYPE_HOST2DEVICE = 65;
  
  private static final int CP210x_SET_BAUDDIV = 1;
  
  private static final int CP210x_SET_BAUDRATE = 30;
  
  private static final int CP210x_SET_CHARS = 25;
  
  private static final int CP210x_SET_FLOW = 19;
  
  private static final int CP210x_SET_LINE_CTL = 3;
  
  private static final int CP210x_SET_MHS = 7;
  
  private static final int CP210x_SET_XOFF = 10;
  
  private static final int CP210x_SET_XON = 9;
  
  private static final int CP210x_UART_DISABLE = 0;
  
  private static final int CP210x_UART_ENABLE = 1;
  
  private static final int CP210x_XOFF = 0;
  
  private static final int CP210x_XON = 0;
  
  private static final int DEFAULT_BAUDRATE = 9600;
  
  private UsbSerialInterface.UsbBreakCallback breakCallback;
  
  private UsbSerialInterface.UsbCTSCallback ctsCallback;
  
  private boolean ctsState = true;
  
  private UsbSerialInterface.UsbDSRCallback dsrCallback;
  
  private boolean dsrState = true;
  
  private boolean dtrDsrEnabled = false;
  
  private FlowControlThread flowControlThread;
  
  private UsbSerialInterface.UsbFrameCallback frameCallback;
  
  private UsbEndpoint inEndpoint;
  
  private UsbInterface mInterface;
  
  private UsbEndpoint outEndpoint;
  
  private UsbSerialInterface.UsbOverrunCallback overrunCallback;
  
  private UsbSerialInterface.UsbParityCallback parityCallback;
  
  private UsbRequest requestIN;
  
  private boolean rtsCtsEnabled = false;
  
  public CP2102SerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    this(paramUsbDevice, paramUsbDeviceConnection, -1);
  }
  
  public CP2102SerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection, int paramInt) {
    super(paramUsbDevice, paramUsbDeviceConnection);
    if (paramInt < 0)
      paramInt = 0; 
    this.mInterface = paramUsbDevice.getInterface(paramInt);
  }
  
  private void createFlowControlThread() {
    this.flowControlThread = new FlowControlThread();
  }
  
  private byte[] getCTL() {
    byte[] arrayOfByte = new byte[2];
    int i = this.connection.controlTransfer(193, 4, 0, this.mInterface.getId(), arrayOfByte, arrayOfByte.length, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(i));
    return arrayOfByte;
  }
  
  private byte[] getCommStatus() {
    byte[] arrayOfByte = new byte[19];
    int i = this.connection.controlTransfer(193, 16, 0, this.mInterface.getId(), arrayOfByte, 19, 5000);
    Log.i(CLASS_ID, "Control Transfer Response (Comm status): " + String.valueOf(i));
    return arrayOfByte;
  }
  
  private byte[] getModemState() {
    byte[] arrayOfByte = new byte[1];
    this.connection.controlTransfer(193, 8, 0, this.mInterface.getId(), arrayOfByte, 1, 5000);
    return arrayOfByte;
  }
  
  private boolean openCP2102() {
    if (this.connection.claimInterface(this.mInterface, true)) {
      Log.i(CLASS_ID, "Interface succesfully claimed");
      int j = this.mInterface.getEndpointCount();
      for (int i = 0; i <= j - 1; i++) {
        UsbEndpoint usbEndpoint = this.mInterface.getEndpoint(i);
        if (usbEndpoint.getType() == 2 && usbEndpoint.getDirection() == 128) {
          this.inEndpoint = usbEndpoint;
        } else {
          this.outEndpoint = usbEndpoint;
        } 
      } 
    } else {
      Log.i(CLASS_ID, "Interface could not be claimed");
      return false;
    } 
    if (setControlCommand(0, 1, (byte[])null) >= 0) {
      setBaudRate(9600);
      if (setControlCommand(3, 2048, (byte[])null) >= 0) {
        setFlowControl(0);
        if (setControlCommand(7, 0, (byte[])null) >= 0)
          return true; 
      } 
    } 
    return false;
  }
  
  private int setControlCommand(int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
    int i = 0;
    if (paramArrayOfbyte != null)
      i = paramArrayOfbyte.length; 
    paramInt1 = this.connection.controlTransfer(65, paramInt1, paramInt2, this.mInterface.getId(), paramArrayOfbyte, i, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(paramInt1));
    return paramInt1;
  }
  
  private void startFlowControlThread() {
    if (!this.flowControlThread.isAlive())
      this.flowControlThread.start(); 
  }
  
  private void stopFlowControlThread() {
    if (this.flowControlThread != null) {
      this.flowControlThread.stopThread();
      this.flowControlThread = null;
    } 
  }
  
  public void close() {
    setControlCommand(0, 0, (byte[])null);
    killWorkingThread();
    killWriteThread();
    stopFlowControlThread();
    this.connection.releaseInterface(this.mInterface);
  }
  
  public void getBreak(UsbSerialInterface.UsbBreakCallback paramUsbBreakCallback) {
    this.breakCallback = paramUsbBreakCallback;
  }
  
  public void getCTS(UsbSerialInterface.UsbCTSCallback paramUsbCTSCallback) {
    this.ctsCallback = paramUsbCTSCallback;
  }
  
  public void getDSR(UsbSerialInterface.UsbDSRCallback paramUsbDSRCallback) {
    this.dsrCallback = paramUsbDSRCallback;
  }
  
  public void getFrame(UsbSerialInterface.UsbFrameCallback paramUsbFrameCallback) {
    this.frameCallback = paramUsbFrameCallback;
  }
  
  public void getOverrun(UsbSerialInterface.UsbOverrunCallback paramUsbOverrunCallback) {
    this.overrunCallback = paramUsbOverrunCallback;
  }
  
  public void getParity(UsbSerialInterface.UsbParityCallback paramUsbParityCallback) {
    this.parityCallback = paramUsbParityCallback;
    startFlowControlThread();
  }
  
  public boolean open() {
    if (openCP2102()) {
      this.requestIN = new UsbRequest();
      this.requestIN.initialize(this.connection, this.inEndpoint);
      restartWorkingThread();
      restartWriteThread();
      createFlowControlThread();
      setThreadsParams(this.requestIN, this.outEndpoint);
      this.asyncMode = true;
      return true;
    } 
    return false;
  }
  
  public void setBaudRate(int paramInt) {
    setControlCommand(30, 0, new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 24 & 0xFF) });
  }
  
  public void setDTR(boolean paramBoolean) {
    if (paramBoolean) {
      setControlCommand(7, 257, (byte[])null);
      return;
    } 
    setControlCommand(7, 256, (byte[])null);
  }
  
  public void setDataBits(int paramInt) {
    byte[] arrayOfByte = getCTL();
    switch (paramInt) {
      default:
        return;
      case 5:
        arrayOfByte[1] = 5;
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 6:
        arrayOfByte[1] = 6;
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 7:
        arrayOfByte[1] = 7;
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 8:
        break;
    } 
    arrayOfByte[1] = 8;
    setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
  }
  
  public void setFlowControl(int paramInt) {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramInt) {
      default:
        return;
      case 0:
        this.rtsCtsEnabled = false;
        this.dtrDsrEnabled = false;
        setControlCommand(19, 0, new byte[] { 
              1, 0, 0, 0, 64, 0, 0, 0, 0, Byte.MIN_VALUE, 
              0, 0, 0, 32, 0, 0 });
        return;
      case 1:
        this.rtsCtsEnabled = true;
        this.dtrDsrEnabled = false;
        setControlCommand(19, 0, new byte[] { 
              9, 0, 0, 0, 64, 0, 0, 0, 0, Byte.MIN_VALUE, 
              0, 0, 0, 32, 0, 0 });
        setControlCommand(7, 514, (byte[])null);
        if ((getCommStatus()[4] & 0x1) != 0)
          bool1 = false; 
        this.ctsState = bool1;
        startFlowControlThread();
        return;
      case 2:
        this.dtrDsrEnabled = true;
        this.rtsCtsEnabled = false;
        setControlCommand(19, 0, new byte[] { 
              17, 0, 0, 0, 64, 0, 0, 0, 0, Byte.MIN_VALUE, 
              0, 0, 0, 32, 0, 0 });
        setControlCommand(7, 257, (byte[])null);
        if ((getCommStatus()[4] & 0x2) == 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        } 
        this.dsrState = bool1;
        startFlowControlThread();
        return;
      case 3:
        break;
    } 
    setControlCommand(25, 0, new byte[] { 0, 0, 0, 0, 17, 19 });
    setControlCommand(19, 0, new byte[] { 
          1, 0, 0, 0, 67, 0, 0, 0, 0, Byte.MIN_VALUE, 
          0, 0, 0, 32, 0, 0 });
  }
  
  public void setParity(int paramInt) {
    byte[] arrayOfByte = getCTL();
    switch (paramInt) {
      default:
        return;
      case 0:
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFEF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFDF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFBF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFF7F);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 1:
        arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x10);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFDF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFBF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFF7F);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 2:
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFEF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x20);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFBF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFF7F);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 3:
        arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x10);
        arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x20);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFBF);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFF7F);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 4:
        break;
    } 
    arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFEF);
    arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFDF);
    arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x40);
    arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFF7F);
    setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
  }
  
  public void setRTS(boolean paramBoolean) {
    if (paramBoolean) {
      setControlCommand(7, 514, (byte[])null);
      return;
    } 
    setControlCommand(7, 512, (byte[])null);
  }
  
  public void setStopBits(int paramInt) {
    byte[] arrayOfByte = getCTL();
    switch (paramInt) {
      default:
        return;
      case 1:
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFFE);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFFD);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 3:
        arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x1);
        arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFFD);
        setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
        return;
      case 2:
        break;
    } 
    arrayOfByte[0] = (byte)(arrayOfByte[0] & 0xFFFFFFFE);
    arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x2);
    setControlCommand(3, (byte)(arrayOfByte[1] << 8 | arrayOfByte[0] & 0xFF), (byte[])null);
  }
  
  public void syncClose() {
    setControlCommand(0, 0, (byte[])null);
    stopFlowControlThread();
    this.connection.releaseInterface(this.mInterface);
  }
  
  public boolean syncOpen() {
    boolean bool = false;
    if (openCP2102()) {
      createFlowControlThread();
      setSyncParams(this.inEndpoint, this.outEndpoint);
      this.asyncMode = false;
      bool = true;
    } 
    return bool;
  }
  
  private class FlowControlThread extends Thread {
    private boolean firstTime = true;
    
    private AtomicBoolean keep = new AtomicBoolean(true);
    
    private long time = 40L;
    
    private byte[] pollLines() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_0
      //   4: getfield time : J
      //   7: invokevirtual wait : (J)V
      //   10: aload_0
      //   11: monitorexit
      //   12: aload_0
      //   13: getfield this$0 : Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;
      //   16: invokestatic access$1100 : (Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)[B
      //   19: areturn
      //   20: astore_1
      //   21: aload_1
      //   22: invokevirtual printStackTrace : ()V
      //   25: goto -> 10
      //   28: astore_1
      //   29: aload_0
      //   30: monitorexit
      //   31: aload_1
      //   32: athrow
      // Exception table:
      //   from	to	target	type
      //   2	10	20	java/lang/InterruptedException
      //   2	10	28	finally
      //   10	12	28	finally
      //   21	25	28	finally
      //   29	31	28	finally
    }
    
    public void run() {
      while (this.keep.get()) {
        if (!this.firstTime) {
          byte[] arrayOfByte2 = pollLines();
          byte[] arrayOfByte1 = CP2102SerialDevice.this.getCommStatus();
          if (CP2102SerialDevice.this.rtsCtsEnabled) {
            boolean bool1;
            boolean bool2 = CP2102SerialDevice.this.ctsState;
            if ((arrayOfByte2[0] & 0x10) == 16) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            if (bool2 != bool1) {
              CP2102SerialDevice cP2102SerialDevice = CP2102SerialDevice.this;
              if (!CP2102SerialDevice.this.ctsState) {
                bool1 = true;
              } else {
                bool1 = false;
              } 
              CP2102SerialDevice.access$202(cP2102SerialDevice, bool1);
              if (CP2102SerialDevice.this.ctsCallback != null)
                CP2102SerialDevice.this.ctsCallback.onCTSChanged(CP2102SerialDevice.this.ctsState); 
            } 
          } 
          if (CP2102SerialDevice.this.dtrDsrEnabled) {
            boolean bool1;
            boolean bool2 = CP2102SerialDevice.this.dsrState;
            if ((arrayOfByte2[0] & 0x20) == 32) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            if (bool2 != bool1) {
              CP2102SerialDevice cP2102SerialDevice = CP2102SerialDevice.this;
              if (!CP2102SerialDevice.this.dsrState) {
                bool1 = true;
              } else {
                bool1 = false;
              } 
              CP2102SerialDevice.access$502(cP2102SerialDevice, bool1);
              if (CP2102SerialDevice.this.dsrCallback != null)
                CP2102SerialDevice.this.dsrCallback.onDSRChanged(CP2102SerialDevice.this.dsrState); 
            } 
          } 
          if (CP2102SerialDevice.this.parityCallback != null && (arrayOfByte1[0] & 0x10) == 16)
            CP2102SerialDevice.this.parityCallback.onParityError(); 
          if (CP2102SerialDevice.this.frameCallback != null && (arrayOfByte1[0] & 0x2) == 2)
            CP2102SerialDevice.this.frameCallback.onFramingError(); 
          if (CP2102SerialDevice.this.breakCallback != null && (arrayOfByte1[0] & 0x1) == 1)
            CP2102SerialDevice.this.breakCallback.onBreakInterrupt(); 
          if (CP2102SerialDevice.this.overrunCallback != null && ((arrayOfByte1[0] & 0x4) == 4 || (arrayOfByte1[0] & 0x8) == 8))
            CP2102SerialDevice.this.overrunCallback.onOverrunError(); 
          continue;
        } 
        if (CP2102SerialDevice.this.rtsCtsEnabled && CP2102SerialDevice.this.ctsCallback != null)
          CP2102SerialDevice.this.ctsCallback.onCTSChanged(CP2102SerialDevice.this.ctsState); 
        if (CP2102SerialDevice.this.dtrDsrEnabled && CP2102SerialDevice.this.dsrCallback != null)
          CP2102SerialDevice.this.dsrCallback.onDSRChanged(CP2102SerialDevice.this.dsrState); 
        this.firstTime = false;
      } 
    }
    
    public void stopThread() {
      this.keep.set(false);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\CP2102SerialDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */