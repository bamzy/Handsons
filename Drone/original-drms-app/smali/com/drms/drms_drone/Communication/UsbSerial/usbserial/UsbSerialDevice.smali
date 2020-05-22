.class public abstract Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
.super Ljava/lang/Object;
.source "UsbSerialDevice.java"

# interfaces
.implements Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;,
        Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;,
        Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;
    }
.end annotation


# static fields
.field private static final CLASS_ID:Ljava/lang/String;

.field protected static final USB_TIMEOUT:I = 0x1388

.field private static mr1Version:Z


# instance fields
.field protected asyncMode:Z

.field protected final connection:Landroid/hardware/usb/UsbDeviceConnection;

.field protected final device:Landroid/hardware/usb/UsbDevice;

.field private inEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private outEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field protected readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;

.field protected serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

.field protected workerThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

.field protected writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 20
    const-class v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->CLASS_ID:Ljava/lang/String;

    .line 43
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x11

    if-le v0, v1, :cond_0

    .line 44
    const/4 v0, 0x1

    sput-boolean v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->mr1Version:Z

    .line 47
    :goto_0
    return-void

    .line 46
    :cond_0
    const/4 v0, 0x0

    sput-boolean v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->mr1Version:Z

    goto :goto_0
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V
    .locals 2
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->device:Landroid/hardware/usb/UsbDevice;

    .line 52
    iput-object p2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    .line 53
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->asyncMode:Z

    .line 54
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    sget-boolean v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->mr1Version:Z

    invoke-direct {v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;-><init>(Z)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    .line 55
    return-void
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->isFTDIDevice()Z

    move-result v0

    return v0
.end method

.method public static createUsbSerialDevice(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
    .locals 1
    .param p0, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p1, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    .line 59
    const/4 v0, -0x1

    invoke-static {p0, p1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->createUsbSerialDevice(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v0

    return-object v0
.end method

.method public static createUsbSerialDevice(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
    .locals 3
    .param p0, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p1, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;
    .param p2, "iface"    # I

    .prologue
    .line 69
    invoke-virtual {p0}, Landroid/hardware/usb/UsbDevice;->getVendorId()I

    move-result v1

    .line 70
    .local v1, "vid":I
    invoke-virtual {p0}, Landroid/hardware/usb/UsbDevice;->getProductId()I

    move-result v0

    .line 72
    .local v0, "pid":I
    invoke-static {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/FTDISioIds;->isDeviceSupported(II)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 73
    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-direct {v2, p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    .line 83
    :goto_0
    return-object v2

    .line 74
    :cond_0
    invoke-static {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP210xIds;->isDeviceSupported(II)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 75
    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-direct {v2, p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    goto :goto_0

    .line 76
    :cond_1
    invoke-static {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/PL2303Ids;->isDeviceSupported(II)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 77
    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;

    invoke-direct {v2, p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    goto :goto_0

    .line 78
    :cond_2
    invoke-static {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds;->isDeviceSupported(II)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 79
    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-direct {v2, p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    goto :goto_0

    .line 80
    :cond_3
    invoke-static {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->isCdcDevice(Landroid/hardware/usb/UsbDevice;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 81
    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;

    invoke-direct {v2, p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    goto :goto_0

    .line 83
    :cond_4
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static isCdcDevice(Landroid/hardware/usb/UsbDevice;)Z
    .locals 5
    .param p0, "device"    # Landroid/hardware/usb/UsbDevice;

    .prologue
    .line 200
    invoke-virtual {p0}, Landroid/hardware/usb/UsbDevice;->getInterfaceCount()I

    move-result v1

    .line 201
    .local v1, "iIndex":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    add-int/lit8 v3, v1, -0x1

    if-gt v0, v3, :cond_1

    .line 203
    invoke-virtual {p0, v0}, Landroid/hardware/usb/UsbDevice;->getInterface(I)Landroid/hardware/usb/UsbInterface;

    move-result-object v2

    .line 204
    .local v2, "iface":Landroid/hardware/usb/UsbInterface;
    invoke-virtual {v2}, Landroid/hardware/usb/UsbInterface;->getInterfaceClass()I

    move-result v3

    const/16 v4, 0xa

    if-ne v3, v4, :cond_0

    .line 205
    const/4 v3, 0x1

    .line 207
    .end local v2    # "iface":Landroid/hardware/usb/UsbInterface;
    :goto_1
    return v3

    .line 201
    .restart local v2    # "iface":Landroid/hardware/usb/UsbInterface;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 207
    .end local v2    # "iface":Landroid/hardware/usb/UsbInterface;
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method private isFTDIDevice()Z
    .locals 1

    .prologue
    .line 195
    instance-of v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    return v0
.end method

.method public static isSupported(Landroid/hardware/usb/UsbDevice;)Z
    .locals 4
    .param p0, "device"    # Landroid/hardware/usb/UsbDevice;

    .prologue
    const/4 v2, 0x1

    .line 88
    invoke-virtual {p0}, Landroid/hardware/usb/UsbDevice;->getVendorId()I

    move-result v1

    .line 89
    .local v1, "vid":I
    invoke-virtual {p0}, Landroid/hardware/usb/UsbDevice;->getProductId()I

    move-result v0

    .line 91
    .local v0, "pid":I
    invoke-static {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/FTDISioIds;->isDeviceSupported(II)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 102
    :cond_0
    :goto_0
    return v2

    .line 93
    :cond_1
    invoke-static {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP210xIds;->isDeviceSupported(II)Z

    move-result v3

    if-nez v3, :cond_0

    .line 95
    invoke-static {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/PL2303Ids;->isDeviceSupported(II)Z

    move-result v3

    if-nez v3, :cond_0

    .line 97
    invoke-static {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds;->isDeviceSupported(II)Z

    move-result v3

    if-nez v3, :cond_0

    .line 99
    invoke-static {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->isCdcDevice(Landroid/hardware/usb/UsbDevice;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 102
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public abstract close()V
.end method

.method public debug(Z)V
    .locals 1
    .param p1, "value"    # Z

    .prologue
    .line 189
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    if-eqz v0, :cond_0

    .line 190
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-virtual {v0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->debug(Z)V

    .line 191
    :cond_0
    return-void
.end method

.method protected killWorkingThread()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 418
    sget-boolean v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->mr1Version:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->workerThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

    if-eqz v0, :cond_1

    .line 420
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->workerThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;->stopWorkingThread()V

    .line 421
    iput-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->workerThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

    .line 427
    :cond_0
    :goto_0
    return-void

    .line 422
    :cond_1
    sget-boolean v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->mr1Version:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;

    if-eqz v0, :cond_0

    .line 424
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;->stopReadThread()V

    .line 425
    iput-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;

    goto :goto_0
.end method

.method protected killWriteThread()V
    .locals 1

    .prologue
    .line 449
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;

    if-eqz v0, :cond_0

    .line 451
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->stopWriteThread()V

    .line 452
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;

    .line 453
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->resetWriteBuffer()V

    .line 455
    :cond_0
    return-void
.end method

.method public abstract open()Z
.end method

.method public read(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;)I
    .locals 3
    .param p1, "mCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;

    .prologue
    .line 119
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->asyncMode:Z

    if-nez v0, :cond_0

    .line 120
    const/4 v0, -0x1

    .line 131
    :goto_0
    return v0

    .line 122
    :cond_0
    sget-boolean v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->mr1Version:Z

    if-eqz v0, :cond_1

    .line 124
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->workerThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

    invoke-virtual {v0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;->setCallback(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;)V

    .line 125
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->workerThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;->getUsbRequest()Landroid/hardware/usb/UsbRequest;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->getReadBuffer()Ljava/nio/ByteBuffer;

    move-result-object v1

    const/16 v2, 0x4000

    invoke-virtual {v0, v1, v2}, Landroid/hardware/usb/UsbRequest;->queue(Ljava/nio/ByteBuffer;I)Z

    .line 131
    :goto_1
    const/4 v0, 0x0

    goto :goto_0

    .line 128
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;

    invoke-virtual {v0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;->setCallback(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;)V

    goto :goto_1
.end method

.method protected restartWorkingThread()V
    .locals 1

    .prologue
    .line 434
    sget-boolean v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->mr1Version:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->workerThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

    if-nez v0, :cond_2

    .line 436
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

    invoke-direct {v0, p0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->workerThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

    .line 437
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->workerThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;->start()V

    .line 438
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->workerThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;->isAlive()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 445
    :cond_1
    return-void

    .line 439
    :cond_2
    sget-boolean v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->mr1Version:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;

    if-nez v0, :cond_1

    .line 441
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;

    invoke-direct {v0, p0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;

    .line 442
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;->start()V

    .line 443
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;->isAlive()Z

    move-result v0

    if-nez v0, :cond_1

    goto :goto_0
.end method

.method protected restartWriteThread()V
    .locals 1

    .prologue
    .line 459
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;

    if-nez v0, :cond_1

    .line 461
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;

    .line 462
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->start()V

    .line 463
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->isAlive()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 465
    :cond_1
    return-void
.end method

.method public abstract setBaudRate(I)V
.end method

.method public abstract setDataBits(I)V
.end method

.method public abstract setFlowControl(I)V
.end method

.method public abstract setParity(I)V
.end method

.method public abstract setStopBits(I)V
.end method

.method protected setSyncParams(Landroid/hardware/usb/UsbEndpoint;Landroid/hardware/usb/UsbEndpoint;)V
    .locals 0
    .param p1, "inEndpoint"    # Landroid/hardware/usb/UsbEndpoint;
    .param p2, "outEndpoint"    # Landroid/hardware/usb/UsbEndpoint;

    .prologue
    .line 396
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 397
    iput-object p2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 398
    return-void
.end method

.method protected setThreadsParams(Landroid/hardware/usb/UsbRequest;Landroid/hardware/usb/UsbEndpoint;)V
    .locals 2
    .param p1, "request"    # Landroid/hardware/usb/UsbRequest;
    .param p2, "endpoint"    # Landroid/hardware/usb/UsbEndpoint;

    .prologue
    .line 402
    sget-boolean v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->mr1Version:Z

    if-eqz v0, :cond_0

    .line 404
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->workerThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;

    invoke-virtual {v0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WorkerThread;->setUsbRequest(Landroid/hardware/usb/UsbRequest;)V

    .line 405
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;

    invoke-virtual {v0, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->setUsbEndpoint(Landroid/hardware/usb/UsbEndpoint;)V

    .line 411
    :goto_0
    return-void

    .line 408
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->readThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;

    invoke-virtual {p1}, Landroid/hardware/usb/UsbRequest;->getEndpoint()Landroid/hardware/usb/UsbEndpoint;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$ReadThread;->setUsbEndpoint(Landroid/hardware/usb/UsbEndpoint;)V

    .line 409
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->writeThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;

    invoke-virtual {v0, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->setUsbEndpoint(Landroid/hardware/usb/UsbEndpoint;)V

    goto :goto_0
.end method

.method public abstract syncClose()V
.end method

.method public abstract syncOpen()Z
.end method

.method public syncRead([BI)I
    .locals 3
    .param p1, "buffer"    # [B
    .param p2, "timeout"    # I

    .prologue
    .line 163
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->asyncMode:Z

    if-eqz v0, :cond_0

    .line 165
    const/4 v0, -0x1

    .line 171
    :goto_0
    return v0

    .line 168
    :cond_0
    if-nez p1, :cond_1

    .line 169
    const/4 v0, 0x0

    goto :goto_0

    .line 171
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    array-length v2, p1

    invoke-virtual {v0, v1, p1, v2, p2}, Landroid/hardware/usb/UsbDeviceConnection;->bulkTransfer(Landroid/hardware/usb/UsbEndpoint;[BII)I

    move-result v0

    goto :goto_0
.end method

.method public syncWrite([BI)I
    .locals 3
    .param p1, "buffer"    # [B
    .param p2, "timeout"    # I

    .prologue
    .line 148
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->asyncMode:Z

    if-nez v0, :cond_1

    .line 150
    if-nez p1, :cond_0

    .line 151
    const/4 v0, 0x0

    .line 156
    :goto_0
    return v0

    .line 153
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    array-length v2, p1

    invoke-virtual {v0, v1, p1, v2, p2}, Landroid/hardware/usb/UsbDeviceConnection;->bulkTransfer(Landroid/hardware/usb/UsbEndpoint;[BII)I

    move-result v0

    goto :goto_0

    .line 156
    :cond_1
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public write([B)V
    .locals 1
    .param p1, "buffer"    # [B

    .prologue
    .line 112
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->asyncMode:Z

    if-eqz v0, :cond_0

    .line 113
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-virtual {v0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->putWriteBuffer([B)V

    .line 114
    :cond_0
    return-void
.end method
