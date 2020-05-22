.class public abstract Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;
.super Ljava/lang/Object;
.source "UsbSpiDevice.java"

# interfaces
.implements Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;,
        Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;
    }
.end annotation


# static fields
.field private static final CLASS_ID:Ljava/lang/String;

.field protected static final USB_TIMEOUT:I = 0x1388


# instance fields
.field protected final connection:Landroid/hardware/usb/UsbDeviceConnection;

.field protected final device:Landroid/hardware/usb/UsbDevice;

.field private inEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private outEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field protected readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;

.field protected serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

.field protected writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->CLASS_ID:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V
    .locals 2
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->device:Landroid/hardware/usb/UsbDevice;

    .line 33
    iput-object p2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    .line 34
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;-><init>(Z)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    .line 35
    return-void
.end method

.method public static createUsbSerialDevice(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;
    .locals 1
    .param p0, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p1, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    .line 39
    const/4 v0, -0x1

    invoke-static {p0, p1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->createUsbSerialDevice(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;

    move-result-object v0

    return-object v0
.end method

.method public static createUsbSerialDevice(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;
    .locals 3
    .param p0, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p1, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;
    .param p2, "iface"    # I

    .prologue
    .line 44
    invoke-virtual {p0}, Landroid/hardware/usb/UsbDevice;->getVendorId()I

    move-result v1

    .line 45
    .local v1, "vid":I
    invoke-virtual {p0}, Landroid/hardware/usb/UsbDevice;->getProductId()I

    move-result v0

    .line 47
    .local v0, "pid":I
    invoke-static {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids;->isDeviceSupported(II)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 48
    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;

    invoke-direct {v2, p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    .line 50
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public abstract closeSPI()V
.end method

.method public abstract connectSPI()Z
.end method

.method public abstract getClockDivider()I
.end method

.method public abstract getSelectedSlave()I
.end method

.method protected killWorkingThread()V
    .locals 1

    .prologue
    .line 188
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;

    if-eqz v0, :cond_0

    .line 190
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->stopReadThread()V

    .line 191
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;

    .line 193
    :cond_0
    return-void
.end method

.method protected killWriteThread()V
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;->stopWriteThread()V

    .line 210
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;

    .line 211
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->resetWriteBuffer()V

    .line 213
    :cond_0
    return-void
.end method

.method public abstract readMISO(I)V
.end method

.method protected restartWorkingThread()V
    .locals 1

    .prologue
    .line 200
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;

    .line 201
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->start()V

    .line 202
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->isAlive()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 203
    return-void
.end method

.method protected restartWriteThread()V
    .locals 1

    .prologue
    .line 217
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;

    if-nez v0, :cond_1

    .line 219
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;

    .line 220
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;->start()V

    .line 221
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;->isAlive()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 223
    :cond_1
    return-void
.end method

.method public abstract selectSlave(I)V
.end method

.method public abstract setClock(I)V
.end method

.method public setMISOCallback(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;)V
    .locals 1
    .param p1, "misoCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;

    .prologue
    .line 75
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;

    invoke-virtual {v0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->setCallback(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;)V

    .line 76
    return-void
.end method

.method protected setThreadsParams(Landroid/hardware/usb/UsbEndpoint;Landroid/hardware/usb/UsbEndpoint;)V
    .locals 1
    .param p1, "inEndpoint"    # Landroid/hardware/usb/UsbEndpoint;
    .param p2, "outEndpoint"    # Landroid/hardware/usb/UsbEndpoint;

    .prologue
    .line 176
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;

    if-eqz v0, :cond_0

    .line 177
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;

    invoke-virtual {v0, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$WriteThread;->setUsbEndpoint(Landroid/hardware/usb/UsbEndpoint;)V

    .line 179
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;

    if-eqz v0, :cond_1

    .line 180
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;

    invoke-virtual {v0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->setUsbEndpoint(Landroid/hardware/usb/UsbEndpoint;)V

    .line 181
    :cond_1
    return-void
.end method

.method public abstract writeMOSI([B)V
.end method

.method public abstract writeRead([BI)V
.end method
