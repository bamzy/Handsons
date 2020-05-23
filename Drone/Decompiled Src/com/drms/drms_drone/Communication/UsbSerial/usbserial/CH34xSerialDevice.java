package com.drms.drms_drone.Communication.UsbSerial.usbserial;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public class CH34xSerialDevice extends UsbSerialDevice {
  private static final int CH341_NBREAK_BITS_REG1 = 1;
  
  private static final int CH341_NBREAK_BITS_REG2 = 64;
  
  private static final int CH341_REG_BREAK1 = 5;
  
  private static final int CH341_REG_BREAK2 = 24;
  
  private static final int CH341_REQ_READ_REG = 149;
  
  private static final int CH341_REQ_WRITE_REG = 154;
  
  private static final int CH34X_115200_1312 = 52355;
  
  private static final int CH34X_1200_0f2c = 59;
  
  private static final int CH34X_1200_1312 = 45697;
  
  private static final int CH34X_19200_0f2c_rest = 7;
  
  private static final int CH34X_19200_1312 = 55682;
  
  private static final int CH34X_230400_1312 = 59011;
  
  private static final int CH34X_2400_0f2c = 30;
  
  private static final int CH34X_2400_1312 = 55681;
  
  private static final int CH34X_300_0f2c = 235;
  
  private static final int CH34X_300_1312 = 55680;
  
  private static final int CH34X_38400_1312 = 25731;
  
  private static final int CH34X_460800_1312 = 62339;
  
  private static final int CH34X_4800_0f2c = 15;
  
  private static final int CH34X_4800_1312 = 25730;
  
  private static final int CH34X_57600_1312 = 39043;
  
  private static final int CH34X_600_0f2c = 118;
  
  private static final int CH34X_600_1312 = 25729;
  
  private static final int CH34X_921600_1312 = 62343;
  
  private static final int CH34X_9600_0f2c = 8;
  
  private static final int CH34X_9600_1312 = 45698;
  
  private static final int CH34X_FLOW_CONTROL_DSR_DTR = 514;
  
  private static final int CH34X_FLOW_CONTROL_NONE = 0;
  
  private static final int CH34X_FLOW_CONTROL_RTS_CTS = 257;
  
  private static final int CH34X_PARITY_EVEN = 219;
  
  private static final int CH34X_PARITY_MARK = 235;
  
  private static final int CH34X_PARITY_NONE = 195;
  
  private static final int CH34X_PARITY_ODD = 203;
  
  private static final int CH34X_PARITY_SPACE = 251;
  
  private static final String CLASS_ID = CH34xSerialDevice.class.getSimpleName();
  
  private static final int DEFAULT_BAUDRATE = 9600;
  
  private static final int REQTYPE_HOST_FROM_DEVICE = 192;
  
  private static final int REQTYPE_HOST_TO_DEVICE = 64;
  
  private UsbSerialInterface.UsbCTSCallback ctsCallback;
  
  private boolean ctsState = false;
  
  private UsbSerialInterface.UsbDSRCallback dsrCallback;
  
  private boolean dsrState = false;
  
  private boolean dtr = false;
  
  private boolean dtrDsrEnabled;
  
  private FlowControlThread flowControlThread;
  
  private UsbEndpoint inEndpoint;
  
  private UsbInterface mInterface;
  
  private UsbEndpoint outEndpoint;
  
  private UsbRequest requestIN;
  
  private boolean rts = false;
  
  private boolean rtsCtsEnabled;
  
  public CH34xSerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection) {
    super(paramUsbDevice, paramUsbDeviceConnection);
  }
  
  public CH34xSerialDevice(UsbDevice paramUsbDevice, UsbDeviceConnection paramUsbDeviceConnection, int paramInt) {
    super(paramUsbDevice, paramUsbDeviceConnection);
    this.rtsCtsEnabled = false;
    this.dtrDsrEnabled = false;
    if (paramInt < 0)
      paramInt = 0; 
    this.mInterface = paramUsbDevice.getInterface(paramInt);
  }
  
  private boolean checkCTS() {
    byte[] arrayOfByte = new byte[2];
    int i = setControlCommandIn(149, 1798, 0, arrayOfByte);
    if (i != 2) {
      Log.i(CLASS_ID, "Expected 2 bytes, but get " + i);
      return false;
    } 
    return ((arrayOfByte[0] & 0x1) == 0);
  }
  
  private boolean checkDSR() {
    byte[] arrayOfByte = new byte[2];
    int i = setControlCommandIn(149, 1798, 0, arrayOfByte);
    if (i != 2) {
      Log.i(CLASS_ID, "Expected 2 bytes, but get " + i);
      return false;
    } 
    return ((arrayOfByte[0] & 0x2) == 0);
  }
  
  private int checkState(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    boolean bool = false;
    paramInt2 = setControlCommandIn(paramInt1, paramInt2, 0, new byte[paramArrayOfint.length]);
    paramInt1 = bool;
    if (paramInt2 != paramArrayOfint.length) {
      Log.i(CLASS_ID, "Expected " + paramArrayOfint.length + " bytes, but get " + paramInt2 + " [" + paramString + "]");
      paramInt1 = -1;
    } 
    return paramInt1;
  }
  
  private void createFlowControlThread() {
    this.flowControlThread = new FlowControlThread();
  }
  
  private int init() {
    if (setControlCommandOut(161, 49820, 45753, (byte[])null) < 0) {
      Log.i(CLASS_ID, "init failed! #1");
      return -1;
    } 
    if (setControlCommandOut(164, 223, 0, (byte[])null) < 0) {
      Log.i(CLASS_ID, "init failed! #2");
      return -1;
    } 
    if (setControlCommandOut(164, 159, 0, (byte[])null) < 0) {
      Log.i(CLASS_ID, "init failed! #3");
      return -1;
    } 
    if (checkState("init #4", 149, 1798, new int[] { 159, 238 }) != -1) {
      if (setControlCommandOut(154, 10023, 0, (byte[])null) < 0) {
        Log.i(CLASS_ID, "init failed! #5");
        return -1;
      } 
      if (setControlCommandOut(154, 4882, 45698, (byte[])null) < 0) {
        Log.i(CLASS_ID, "init failed! #6");
        return -1;
      } 
      if (setControlCommandOut(154, 3884, 8, (byte[])null) < 0) {
        Log.i(CLASS_ID, "init failed! #7");
        return -1;
      } 
      if (setControlCommandOut(154, 9496, 195, (byte[])null) < 0) {
        Log.i(CLASS_ID, "init failed! #8");
        return -1;
      } 
      if (checkState("init #9", 149, 1798, new int[] { 159, 238 }) != -1) {
        if (setControlCommandOut(154, 10023, 0, (byte[])null) < 0) {
          Log.i(CLASS_ID, "init failed! #10");
          return -1;
        } 
        return 0;
      } 
    } 
    return -1;
  }
  
  private boolean openCH34X() {
    boolean bool = true;
    if (this.connection.claimInterface(this.mInterface, true)) {
      Log.i(CLASS_ID, "Interface succesfully claimed");
      int j = this.mInterface.getEndpointCount();
      for (int i = 0; i <= j - 1; i++) {
        UsbEndpoint usbEndpoint = this.mInterface.getEndpoint(i);
        if (usbEndpoint.getType() == 2 && usbEndpoint.getDirection() == 128) {
          this.inEndpoint = usbEndpoint;
        } else if (usbEndpoint.getType() == 2 && usbEndpoint.getDirection() == 0) {
          this.outEndpoint = usbEndpoint;
        } 
      } 
    } else {
      Log.i(CLASS_ID, "Interface could not be claimed");
      return false;
    } 
    return (init() != 0) ? false : bool;
  }
  
  private int setBaudRate(int paramInt1, int paramInt2) {
    return (setControlCommandOut(154, 4882, paramInt1, (byte[])null) >= 0 && setControlCommandOut(154, 3884, paramInt2, (byte[])null) >= 0 && checkState("set_baud_rate", 149, 1798, new int[] { 159, 238 }) != -1 && setControlCommandOut(154, 10023, 0, (byte[])null) >= 0) ? 0 : -1;
  }
  
  private int setCh340xFlow(int paramInt) {
    return (checkState("set_flow_control", 149, 1798, new int[] { 159, 238 }) != -1 && setControlCommandOut(154, 10023, paramInt, (byte[])null) != -1) ? 0 : -1;
  }
  
  private int setCh340xParity(int paramInt) {
    return (setControlCommandOut(154, 9496, paramInt, (byte[])null) >= 0 && checkState("set_parity", 149, 1798, new int[] { 159, 238 }) != -1 && setControlCommandOut(154, 10023, 0, (byte[])null) >= 0) ? 0 : -1;
  }
  
  private int setControlCommandIn(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfbyte) {
    int i = 0;
    if (paramArrayOfbyte != null)
      i = paramArrayOfbyte.length; 
    paramInt1 = this.connection.controlTransfer(192, paramInt1, paramInt2, paramInt3, paramArrayOfbyte, i, 5000);
    Log.i(CLASS_ID, "Control Transfer Response: " + String.valueOf(paramInt1));
    return paramInt1;
  }
  
  private int setControlCommandOut(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfbyte) {
    int i = 0;
    if (paramArrayOfbyte != null)
      i = paramArrayOfbyte.length; 
    paramInt1 = this.connection.controlTransfer(64, paramInt1, paramInt2, paramInt3, paramArrayOfbyte, i, 5000);
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
  
  private int writeHandshakeByte() {
    boolean bool1;
    boolean bool2;
    byte b = 0;
    if (this.dtr) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.rts) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (setControlCommandOut(164, (bool1 | bool2) ^ 0xFFFFFFFF, 0, (byte[])null) < 0) {
      Log.i(CLASS_ID, "Failed to set handshake byte");
      b = -1;
    } 
    return b;
  }
  
  public void close() {
    killWorkingThread();
    killWriteThread();
    stopFlowControlThread();
    this.connection.releaseInterface(this.mInterface);
  }
  
  public void getBreak(UsbSerialInterface.UsbBreakCallback paramUsbBreakCallback) {}
  
  public void getCTS(UsbSerialInterface.UsbCTSCallback paramUsbCTSCallback) {
    this.ctsCallback = paramUsbCTSCallback;
  }
  
  public void getDSR(UsbSerialInterface.UsbDSRCallback paramUsbDSRCallback) {
    this.dsrCallback = paramUsbDSRCallback;
  }
  
  public void getFrame(UsbSerialInterface.UsbFrameCallback paramUsbFrameCallback) {}
  
  public void getOverrun(UsbSerialInterface.UsbOverrunCallback paramUsbOverrunCallback) {}
  
  public void getParity(UsbSerialInterface.UsbParityCallback paramUsbParityCallback) {}
  
  public boolean open() {
    if (openCH34X()) {
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
    if (paramInt <= 300) {
      if (setBaudRate(55680, 235) == -1)
        Log.i(CLASS_ID, "SetBaudRate failed!"); 
      return;
    } 
    if (paramInt > 300 && paramInt <= 600) {
      if (setBaudRate(25729, 118) == -1) {
        Log.i(CLASS_ID, "SetBaudRate failed!");
        return;
      } 
      return;
    } 
    if (paramInt > 600 && paramInt <= 1200) {
      if (setBaudRate(45697, 59) == -1) {
        Log.i(CLASS_ID, "SetBaudRate failed!");
        return;
      } 
      return;
    } 
    if (paramInt > 1200 && paramInt <= 2400) {
      if (setBaudRate(55681, 30) == -1) {
        Log.i(CLASS_ID, "SetBaudRate failed!");
        return;
      } 
      return;
    } 
    if (paramInt > 2400 && paramInt <= 4800) {
      if (setBaudRate(25730, 15) == -1) {
        Log.i(CLASS_ID, "SetBaudRate failed!");
        return;
      } 
      return;
    } 
    if (paramInt > 4800 && paramInt <= 9600) {
      if (setBaudRate(45698, 8) == -1) {
        Log.i(CLASS_ID, "SetBaudRate failed!");
        return;
      } 
      return;
    } 
    if (paramInt > 9600 && paramInt <= 19200) {
      if (setBaudRate(55682, 7) == -1) {
        Log.i(CLASS_ID, "SetBaudRate failed!");
        return;
      } 
      return;
    } 
    if (paramInt > 19200 && paramInt <= 38400) {
      if (setBaudRate(25731, 7) == -1) {
        Log.i(CLASS_ID, "SetBaudRate failed!");
        return;
      } 
      return;
    } 
    if (paramInt > 38400 && paramInt <= 57600) {
      if (setBaudRate(39043, 7) == -1) {
        Log.i(CLASS_ID, "SetBaudRate failed!");
        return;
      } 
      return;
    } 
    if (paramInt > 57600 && paramInt <= 115200) {
      if (setBaudRate(52355, 7) == -1) {
        Log.i(CLASS_ID, "SetBaudRate failed!");
        return;
      } 
      return;
    } 
    if (paramInt > 115200 && paramInt <= 230400) {
      if (setBaudRate(59011, 7) == -1) {
        Log.i(CLASS_ID, "SetBaudRate failed!");
        return;
      } 
      return;
    } 
    if (paramInt > 230400 && paramInt <= 460800) {
      if (setBaudRate(62339, 7) == -1) {
        Log.i(CLASS_ID, "SetBaudRate failed!");
        return;
      } 
      return;
    } 
    if (paramInt > 460800 && paramInt <= 921600 && setBaudRate(62343, 7) == -1) {
      Log.i(CLASS_ID, "SetBaudRate failed!");
      return;
    } 
  }
  
  public void setDTR(boolean paramBoolean) {
    this.dtr = paramBoolean;
    writeHandshakeByte();
  }
  
  public void setDataBits(int paramInt) {}
  
  public void setFlowControl(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 0:
        this.rtsCtsEnabled = false;
        this.dtrDsrEnabled = false;
        setCh340xFlow(0);
        return;
      case 1:
        this.rtsCtsEnabled = true;
        this.dtrDsrEnabled = false;
        setCh340xFlow(257);
        this.ctsState = checkCTS();
        startFlowControlThread();
        return;
      case 2:
        break;
    } 
    this.rtsCtsEnabled = false;
    this.dtrDsrEnabled = true;
    setCh340xFlow(514);
    this.dsrState = checkDSR();
    startFlowControlThread();
  }
  
  public void setParity(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 0:
        setCh340xParity(195);
        return;
      case 1:
        setCh340xParity(203);
        return;
      case 2:
        setCh340xParity(219);
        return;
      case 3:
        setCh340xParity(235);
        return;
      case 4:
        break;
    } 
    setCh340xParity(251);
  }
  
  public void setRTS(boolean paramBoolean) {
    this.rts = paramBoolean;
    writeHandshakeByte();
  }
  
  public void setStopBits(int paramInt) {}
  
  public void syncClose() {
    stopFlowControlThread();
    this.connection.releaseInterface(this.mInterface);
  }
  
  public boolean syncOpen() {
    boolean bool = false;
    if (openCH34X()) {
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
    
    private long time = 100L;
    
    public boolean pollForCTS() {
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
      //   13: getfield this$0 : Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;
      //   16: invokestatic access$600 : (Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z
      //   19: ireturn
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
    
    public boolean pollForDSR() {
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
      //   13: getfield this$0 : Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;
      //   16: invokestatic access$700 : (Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z
      //   19: ireturn
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
          if (CH34xSerialDevice.this.rtsCtsEnabled) {
            boolean bool = pollForCTS();
            if (CH34xSerialDevice.this.ctsState != bool) {
              CH34xSerialDevice cH34xSerialDevice = CH34xSerialDevice.this;
              if (!CH34xSerialDevice.this.ctsState) {
                bool = true;
              } else {
                bool = false;
              } 
              CH34xSerialDevice.access$102(cH34xSerialDevice, bool);
              if (CH34xSerialDevice.this.ctsCallback != null)
                CH34xSerialDevice.this.ctsCallback.onCTSChanged(CH34xSerialDevice.this.ctsState); 
            } 
          } 
          if (CH34xSerialDevice.this.dtrDsrEnabled) {
            boolean bool = pollForDSR();
            if (CH34xSerialDevice.this.dsrState != bool) {
              CH34xSerialDevice cH34xSerialDevice = CH34xSerialDevice.this;
              if (!CH34xSerialDevice.this.dsrState) {
                bool = true;
              } else {
                bool = false;
              } 
              CH34xSerialDevice.access$402(cH34xSerialDevice, bool);
              if (CH34xSerialDevice.this.dsrCallback != null)
                CH34xSerialDevice.this.dsrCallback.onDSRChanged(CH34xSerialDevice.this.dsrState); 
            } 
          } 
          continue;
        } 
        if (CH34xSerialDevice.this.rtsCtsEnabled && CH34xSerialDevice.this.ctsCallback != null)
          CH34xSerialDevice.this.ctsCallback.onCTSChanged(CH34xSerialDevice.this.ctsState); 
        if (CH34xSerialDevice.this.dtrDsrEnabled && CH34xSerialDevice.this.dsrCallback != null)
          CH34xSerialDevice.this.dsrCallback.onDSRChanged(CH34xSerialDevice.this.dsrState); 
        this.firstTime = false;
      } 
    }
    
    public void stopThread() {
      this.keep.set(false);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\UsbSeria\\usbserial\CH34xSerialDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */