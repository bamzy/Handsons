package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import java.util.Arrays;

public class FTDISerialDevice extends UsbSerialDevice {
  private static final String CLASS_ID = FTDISerialDevice.class.getSimpleName();
  
  public static final int FTDI_BAUDRATE_115200 = 26;
  
  public static final int FTDI_BAUDRATE_1200 = 2500;
  
  public static final int FTDI_BAUDRATE_19200 = 32924;
  
  public static final int FTDI_BAUDRATE_230400 = 13;
  
  public static final int FTDI_BAUDRATE_2400 = 1250;
  
  public static final int FTDI_BAUDRATE_300 = 10000;
  
  public static final int FTDI_BAUDRATE_38400 = 49230;
  
  public static final int FTDI_BAUDRATE_460800 = 16390;
  
  public static final int FTDI_BAUDRATE_4800 = 625;
  
  public static final int FTDI_BAUDRATE_57600 = 52;
  
  public static final int FTDI_BAUDRATE_600 = 5000;
  
  public static final int FTDI_BAUDRATE_921600 = 32771;
  
  public static final int FTDI_BAUDRATE_9600 = 16696;
  
  private static final int FTDI_REQTYPE_HOST2DEVICE = 64;
  
  private static final int FTDI_SET_DATA_DEFAULT = 8;
  
  private static final int FTDI_SET_FLOW_CTRL_DEFAULT = 0;
  
  private static final int FTDI_SET_MODEM_CTRL_DEFAULT1 = 257;
  
  private static final int FTDI_SET_MODEM_CTRL_DEFAULT2 = 514;
  
  private static final int FTDI_SET_MODEM_CTRL_DEFAULT3 = 256;
  
  private static final int FTDI_SET_MODEM_CTRL_DEFAULT4 = 512;
  
  private static final int FTDI_SIO_MODEM_CTRL = 1;
  
  private static final int FTDI_SIO_RESET = 0;
  
  private static final int FTDI_SIO_SET_BAUD_RATE = 3;
  
  private static final int FTDI_SIO_SET_DATA = 4;
  
  private static final int FTDI_SIO_SET_DTR_HIGH = 257;
  
  private static final int FTDI_SIO_SET_DTR_LOW = 256;
  
  private static final int FTDI_SIO_SET_DTR_MASK = 1;
  
  private static final int FTDI_SIO_SET_FLOW_CTRL = 2;
  
  private static final int FTDI_SIO_SET_RTS_HIGH = 514;
  
  private static final int FTDI_SIO_SET_RTS_LOW = 512;
  
  private static final int FTDI_SIO_SET_RTS_MASK = 2;
  
  private UsbSerialInterface.UsbBreakCallback breakCallback;
  
  private UsbSerialInterface.UsbCTSCallback ctsCallback;
  
  private boolean ctsState = true;
  
  private int currentSioSetData = 0;
  
  private UsbSerialInterface.UsbDSRCallback dsrCallback;
  
  private boolean dsrState = true;
  
  private boolean dtrDsrEnabled = false;
  
  private boolean firstTime = true;
  
  private UsbSerialInterface.UsbFrameCallback frameCallback;
  
  public FTDIUtilities ftdiUtilities = new FTDIUtilities();
  
  private UsbEndpoint inEndpoint;
  
  private UsbInterface mInterface;
  
  private UsbEndpoint outEndpoint;
  
  private UsbSerialInterface.UsbOverrunCallback overrunCallback;
  
  private UsbSerialInterface.UsbParityCallback parityCallback;
  
  private UsbRequest requestIN;
  
  private boolean rtsCtsEnabled = false;
  
  public FTDISerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    this(paramUsbDevice, paramUsbDeviceConnection, -1);
  }
  
  public FTDISerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection, int paramInt) {
    super(paramUsbDevice, paramUsbDeviceConnection);
    if (paramInt < 0)
      paramInt = 0; 
    this.mInterface = paramUsbDevice.getInterface(paramInt);
  }
  
  private boolean openFTDI() {
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
    this.firstTime = true;
    if (setControlCommand(0, 0, 0, (byte[])null) >= 0 && setControlCommand(4, 8, 0, (byte[])null) >= 0) {
      this.currentSioSetData = 8;
      if (setControlCommand(1, 257, 0, (byte[])null) >= 0 && setControlCommand(1, 514, 0, (byte[])null) >= 0 && setControlCommand(2, 0, 0, (byte[])null) >= 0 && setControlCommand(3, 16696, 0, (byte[])null) >= 0) {
        this.rtsCtsEnabled = false;
        this.dtrDsrEnabled = false;
        return true;
      } 
    } 
    return false;
  }
  
  private int setControlCommand(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfbyte) {
    int i = 0;
    if (paramArrayOfbyte != null)
      i = paramArrayOfbyte.length; 
    paramInt1 = this.connection.controlTransfer(64, paramInt1, paramInt2, this.mInterface.getId() + 1 + paramInt3, paramArrayOfbyte, i, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(paramInt1));
    return paramInt1;
  }
  
  public void close() {
    setControlCommand(1, 256, 0, (byte[])null);
    setControlCommand(1, 512, 0, (byte[])null);
    this.currentSioSetData = 0;
    killWorkingThread();
    killWriteThread();
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
  }
  
  public boolean open() {
    if (openFTDI()) {
      this.requestIN = new UsbRequest();
      this.requestIN.initialize(this.connection, this.inEndpoint);
      restartWorkingThread();
      restartWriteThread();
      setThreadsParams(this.requestIN, this.outEndpoint);
      this.asyncMode = true;
      return true;
    } 
    return false;
  }
  
  public void setBaudRate(int paramInt) {
    if (paramInt >= 0 && paramInt <= 300) {
      paramInt = 10000;
    } else if (paramInt > 300 && paramInt <= 600) {
      paramInt = 5000;
    } else if (paramInt > 600 && paramInt <= 1200) {
      paramInt = 2500;
    } else if (paramInt > 1200 && paramInt <= 2400) {
      paramInt = 1250;
    } else if (paramInt > 2400 && paramInt <= 4800) {
      paramInt = 625;
    } else if (paramInt > 4800 && paramInt <= 9600) {
      paramInt = 16696;
    } else if (paramInt > 9600 && paramInt <= 19200) {
      paramInt = 32924;
    } else if (paramInt > 19200 && paramInt <= 38400) {
      paramInt = 49230;
    } else if (paramInt > 19200 && paramInt <= 57600) {
      paramInt = 52;
    } else if (paramInt > 57600 && paramInt <= 115200) {
      paramInt = 26;
    } else if (paramInt > 115200 && paramInt <= 230400) {
      paramInt = 13;
    } else if (paramInt > 230400 && paramInt <= 460800) {
      paramInt = 16390;
    } else if (paramInt > 460800 && paramInt <= 921600) {
      paramInt = 32771;
    } else if (paramInt > 921600) {
      paramInt = 32771;
    } else {
      paramInt = 16696;
    } 
    setControlCommand(3, paramInt, 0, (byte[])null);
  }
  
  public void setDTR(boolean paramBoolean) {
    if (paramBoolean) {
      setControlCommand(1, 257, 0, (byte[])null);
      return;
    } 
    setControlCommand(1, 256, 0, (byte[])null);
  }
  
  public void setDataBits(int paramInt) {
    switch (paramInt) {
      default:
        this.currentSioSetData &= 0xFFFFFFFE;
        this.currentSioSetData &= 0xFFFFFFFD;
        this.currentSioSetData &= 0xFFFFFFFB;
        this.currentSioSetData |= 0x8;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 5:
        this.currentSioSetData |= 0x1;
        this.currentSioSetData &= 0xFFFFFFFD;
        this.currentSioSetData |= 0x4;
        this.currentSioSetData &= 0xFFFFFFF7;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 6:
        this.currentSioSetData &= 0xFFFFFFFE;
        this.currentSioSetData |= 0x2;
        this.currentSioSetData |= 0x4;
        this.currentSioSetData &= 0xFFFFFFF7;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 7:
        this.currentSioSetData |= 0x1;
        this.currentSioSetData |= 0x2;
        this.currentSioSetData |= 0x4;
        this.currentSioSetData &= 0xFFFFFFF7;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 8:
        break;
    } 
    this.currentSioSetData &= 0xFFFFFFFE;
    this.currentSioSetData &= 0xFFFFFFFD;
    this.currentSioSetData &= 0xFFFFFFFB;
    this.currentSioSetData |= 0x8;
    setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
  }
  
  public void setFlowControl(int paramInt) {
    switch (paramInt) {
      default:
        setControlCommand(2, 0, 0, (byte[])null);
        return;
      case 0:
        setControlCommand(2, 0, 0, (byte[])null);
        this.rtsCtsEnabled = false;
        this.dtrDsrEnabled = false;
        return;
      case 1:
        this.rtsCtsEnabled = true;
        this.dtrDsrEnabled = false;
        setControlCommand(2, 0, 1, (byte[])null);
        return;
      case 2:
        this.dtrDsrEnabled = true;
        this.rtsCtsEnabled = false;
        setControlCommand(2, 0, 2, (byte[])null);
        return;
      case 3:
        break;
    } 
    setControlCommand(2, 4881, 4, (byte[])null);
  }
  
  public void setParity(int paramInt) {
    switch (paramInt) {
      default:
        this.currentSioSetData &= 0xFFFFFEFF;
        this.currentSioSetData &= 0xFFFFFDFF;
        this.currentSioSetData &= 0xFFFFFBFF;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 0:
        this.currentSioSetData &= 0xFFFFFEFF;
        this.currentSioSetData &= 0xFFFFFDFF;
        this.currentSioSetData &= 0xFFFFFBFF;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 1:
        this.currentSioSetData |= 0x100;
        this.currentSioSetData &= 0xFFFFFDFF;
        this.currentSioSetData &= 0xFFFFFBFF;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 2:
        this.currentSioSetData &= 0xFFFFFEFF;
        this.currentSioSetData |= 0x200;
        this.currentSioSetData &= 0xFFFFFBFF;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 3:
        this.currentSioSetData |= 0x100;
        this.currentSioSetData |= 0x200;
        this.currentSioSetData &= 0xFFFFFBFF;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 4:
        break;
    } 
    this.currentSioSetData &= 0xFFFFFEFF;
    this.currentSioSetData &= 0xFFFFFDFF;
    this.currentSioSetData |= 0x400;
    setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
  }
  
  public void setRTS(boolean paramBoolean) {
    if (paramBoolean) {
      setControlCommand(1, 514, 0, (byte[])null);
      return;
    } 
    setControlCommand(1, 512, 0, (byte[])null);
  }
  
  public void setStopBits(int paramInt) {
    switch (paramInt) {
      default:
        this.currentSioSetData &= 0xFFFFF7FF;
        this.currentSioSetData &= 0xFFFFEFFF;
        this.currentSioSetData &= 0xFFFFDFFF;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 1:
        this.currentSioSetData &= 0xFFFFF7FF;
        this.currentSioSetData &= 0xFFFFEFFF;
        this.currentSioSetData &= 0xFFFFDFFF;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 3:
        this.currentSioSetData |= 0x800;
        this.currentSioSetData &= 0xFFFFEFFF;
        this.currentSioSetData &= 0xFFFFDFFF;
        setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
        return;
      case 2:
        break;
    } 
    this.currentSioSetData &= 0xFFFFF7FF;
    this.currentSioSetData |= 0x1000;
    this.currentSioSetData &= 0xFFFFDFFF;
    setControlCommand(4, this.currentSioSetData, 0, (byte[])null);
  }
  
  public void syncClose() {
    setControlCommand(1, 256, 0, (byte[])null);
    setControlCommand(1, 512, 0, (byte[])null);
    this.currentSioSetData = 0;
    this.connection.releaseInterface(this.mInterface);
  }
  
  public boolean syncOpen() {
    boolean bool = false;
    if (openFTDI()) {
      setSyncParams(this.inEndpoint, this.outEndpoint);
      this.asyncMode = false;
      bool = true;
    } 
    return bool;
  }
  
  public int syncRead(byte[] paramArrayOfbyte, int paramInt) {
    long l1 = System.currentTimeMillis();
    long l2 = paramInt;
    if (this.asyncMode)
      return -1; 
    if (paramArrayOfbyte == null)
      return 0; 
    int j = paramArrayOfbyte.length / 62;
    int i = j;
    if (paramArrayOfbyte.length % 62 != 0)
      i = j + 1; 
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length + i * 2];
    i = 0;
    while (true) {
      j = 0;
      if (paramInt > 0) {
        int m = (int)(l1 + l2 - System.currentTimeMillis());
        j = i;
        if (m > 0) {
          j = m;
        } else {
          return j;
        } 
      } 
      int k = this.connection.bulkTransfer(this.inEndpoint, arrayOfByte, arrayOfByte.length, j);
      j = i;
      if (k > 2) {
        System.arraycopy(this.ftdiUtilities.adaptArray(arrayOfByte), 0, paramArrayOfbyte, 0, paramArrayOfbyte.length);
        j = k / 64;
        i = j;
        if (k % 64 != 0)
          i = j + 1; 
        j = k - i * 2;
      } 
      i = j;
      if (j > 0)
        return j; 
    } 
  }
  
  public class FTDIUtilities {
    private void copyData(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
      int i = 0;
      int j = 0;
      while (i <= param1ArrayOfbyte1.length - 1) {
        if (i != 0 && i != 1) {
          if (i % 64 == 0 && i >= 64) {
            i += 2;
            continue;
          } 
          param1ArrayOfbyte2[j] = param1ArrayOfbyte1[i];
          i++;
          j++;
          continue;
        } 
        i++;
      } 
    }
    
    public byte[] adaptArray(byte[] param1ArrayOfbyte) {
      int i = param1ArrayOfbyte.length;
      if (i > 64) {
        int j = 1;
        for (int k = 64; k < i; k = ++j * 64);
        byte[] arrayOfByte = new byte[i - j * 2];
        copyData(param1ArrayOfbyte, arrayOfByte);
        return arrayOfByte;
      } 
      return Arrays.copyOfRange(param1ArrayOfbyte, 2, i);
    }
    
    public void checkModemStatus(byte[] param1ArrayOfbyte) {
      boolean bool = false;
      if (param1ArrayOfbyte.length != 0) {
        boolean bool1;
        boolean bool2;
        if ((param1ArrayOfbyte[0] & 0x10) == 16) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        if ((param1ArrayOfbyte[0] & 0x20) == 32) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (FTDISerialDevice.this.firstTime) {
          FTDISerialDevice.access$102(FTDISerialDevice.this, bool2);
          FTDISerialDevice.access$202(FTDISerialDevice.this, bool1);
          if (FTDISerialDevice.this.rtsCtsEnabled && FTDISerialDevice.this.ctsCallback != null)
            FTDISerialDevice.this.ctsCallback.onCTSChanged(FTDISerialDevice.this.ctsState); 
          if (FTDISerialDevice.this.dtrDsrEnabled && FTDISerialDevice.this.dsrCallback != null)
            FTDISerialDevice.this.dsrCallback.onDSRChanged(FTDISerialDevice.this.dsrState); 
          FTDISerialDevice.access$002(FTDISerialDevice.this, false);
          return;
        } 
        if (FTDISerialDevice.this.rtsCtsEnabled && bool2 != FTDISerialDevice.this.ctsState && FTDISerialDevice.this.ctsCallback != null) {
          FTDISerialDevice fTDISerialDevice = FTDISerialDevice.this;
          if (!FTDISerialDevice.this.ctsState) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          FTDISerialDevice.access$102(fTDISerialDevice, bool2);
          FTDISerialDevice.this.ctsCallback.onCTSChanged(FTDISerialDevice.this.ctsState);
        } 
        if (FTDISerialDevice.this.dtrDsrEnabled && bool1 != FTDISerialDevice.this.dsrState && FTDISerialDevice.this.dsrCallback != null) {
          FTDISerialDevice fTDISerialDevice = FTDISerialDevice.this;
          bool1 = bool;
          if (!FTDISerialDevice.this.dsrState)
            bool1 = true; 
          FTDISerialDevice.access$202(fTDISerialDevice, bool1);
          FTDISerialDevice.this.dsrCallback.onDSRChanged(FTDISerialDevice.this.dsrState);
        } 
        if (FTDISerialDevice.this.parityCallback != null && (param1ArrayOfbyte[1] & 0x4) == 4)
          FTDISerialDevice.this.parityCallback.onParityError(); 
        if (FTDISerialDevice.this.frameCallback != null && (param1ArrayOfbyte[1] & 0x8) == 8)
          FTDISerialDevice.this.frameCallback.onFramingError(); 
        if (FTDISerialDevice.this.overrunCallback != null && (param1ArrayOfbyte[1] & 0x2) == 2)
          FTDISerialDevice.this.overrunCallback.onOverrunError(); 
        if (FTDISerialDevice.this.breakCallback != null && (param1ArrayOfbyte[1] & 0x10) == 16) {
          FTDISerialDevice.this.breakCallback.onBreakInterrupt();
          return;
        } 
      } 
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\FTDISerialDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */