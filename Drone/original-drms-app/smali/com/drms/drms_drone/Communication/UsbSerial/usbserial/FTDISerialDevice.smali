.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;
.super Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
.source "FTDISerialDevice.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;
    }
.end annotation


# static fields
.field private static final CLASS_ID:Ljava/lang/String;

.field public static final FTDI_BAUDRATE_115200:I = 0x1a

.field public static final FTDI_BAUDRATE_1200:I = 0x9c4

.field public static final FTDI_BAUDRATE_19200:I = 0x809c

.field public static final FTDI_BAUDRATE_230400:I = 0xd

.field public static final FTDI_BAUDRATE_2400:I = 0x4e2

.field public static final FTDI_BAUDRATE_300:I = 0x2710

.field public static final FTDI_BAUDRATE_38400:I = 0xc04e

.field public static final FTDI_BAUDRATE_460800:I = 0x4006

.field public static final FTDI_BAUDRATE_4800:I = 0x271

.field public static final FTDI_BAUDRATE_57600:I = 0x34

.field public static final FTDI_BAUDRATE_600:I = 0x1388

.field public static final FTDI_BAUDRATE_921600:I = 0x8003

.field public static final FTDI_BAUDRATE_9600:I = 0x4138

.field private static final FTDI_REQTYPE_HOST2DEVICE:I = 0x40

.field private static final FTDI_SET_DATA_DEFAULT:I = 0x8

.field private static final FTDI_SET_FLOW_CTRL_DEFAULT:I = 0x0

.field private static final FTDI_SET_MODEM_CTRL_DEFAULT1:I = 0x101

.field private static final FTDI_SET_MODEM_CTRL_DEFAULT2:I = 0x202

.field private static final FTDI_SET_MODEM_CTRL_DEFAULT3:I = 0x100

.field private static final FTDI_SET_MODEM_CTRL_DEFAULT4:I = 0x200

.field private static final FTDI_SIO_MODEM_CTRL:I = 0x1

.field private static final FTDI_SIO_RESET:I = 0x0

.field private static final FTDI_SIO_SET_BAUD_RATE:I = 0x3

.field private static final FTDI_SIO_SET_DATA:I = 0x4

.field private static final FTDI_SIO_SET_DTR_HIGH:I = 0x101

.field private static final FTDI_SIO_SET_DTR_LOW:I = 0x100

.field private static final FTDI_SIO_SET_DTR_MASK:I = 0x1

.field private static final FTDI_SIO_SET_FLOW_CTRL:I = 0x2

.field private static final FTDI_SIO_SET_RTS_HIGH:I = 0x202

.field private static final FTDI_SIO_SET_RTS_LOW:I = 0x200

.field private static final FTDI_SIO_SET_RTS_MASK:I = 0x2


# instance fields
.field private breakCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

.field private ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

.field private ctsState:Z

.field private currentSioSetData:I

.field private dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

.field private dsrState:Z

.field private dtrDsrEnabled:Z

.field private firstTime:Z

.field private frameCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

.field public ftdiUtilities:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;

.field private inEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private mInterface:Landroid/hardware/usb/UsbInterface;

.field private outEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private overrunCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

.field private parityCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

.field private requestIN:Landroid/hardware/usb/UsbRequest;

.field private rtsCtsEnabled:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->CLASS_ID:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V
    .locals 1
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    .line 95
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    .line 96
    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V
    .locals 3
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;
    .param p3, "iface"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v0, 0x0

    .line 100
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V

    .line 65
    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 101
    new-instance v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)V

    iput-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->ftdiUtilities:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;

    .line 102
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->rtsCtsEnabled:Z

    .line 103
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->dtrDsrEnabled:Z

    .line 104
    iput-boolean v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->ctsState:Z

    .line 105
    iput-boolean v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->dsrState:Z

    .line 106
    iput-boolean v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->firstTime:Z

    .line 107
    if-ltz p3, :cond_0

    .end local p3    # "iface":I
    :goto_0
    invoke-virtual {p1, p3}, Landroid/hardware/usb/UsbDevice;->getInterface(I)Landroid/hardware/usb/UsbInterface;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    .line 108
    return-void

    .restart local p3    # "iface":I
    :cond_0
    move p3, v0

    .line 107
    goto :goto_0
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 13
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->firstTime:Z

    return v0
.end method

.method static synthetic access$002(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;
    .param p1, "x1"    # Z

    .prologue
    .line 13
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->firstTime:Z

    return p1
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 13
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->ctsState:Z

    return v0
.end method

.method static synthetic access$1000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->breakCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    return-object v0
.end method

.method static synthetic access$102(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;
    .param p1, "x1"    # Z

    .prologue
    .line 13
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->ctsState:Z

    return p1
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 13
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->dsrState:Z

    return v0
.end method

.method static synthetic access$202(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;
    .param p1, "x1"    # Z

    .prologue
    .line 13
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->dsrState:Z

    return p1
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 13
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->rtsCtsEnabled:Z

    return v0
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    return-object v0
.end method

.method static synthetic access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 13
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->dtrDsrEnabled:Z

    return v0
.end method

.method static synthetic access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    return-object v0
.end method

.method static synthetic access$700(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->parityCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    return-object v0
.end method

.method static synthetic access$800(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->frameCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    return-object v0
.end method

.method static synthetic access$900(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->overrunCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    return-object v0
.end method

.method private openFTDI()Z
    .locals 10

    .prologue
    const/16 v9, 0x8

    const/4 v8, 0x2

    const/4 v4, 0x1

    const/4 v7, 0x0

    const/4 v3, 0x0

    .line 425
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5, v6, v4}, Landroid/hardware/usb/UsbDeviceConnection;->claimInterface(Landroid/hardware/usb/UsbInterface;Z)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 427
    sget-object v5, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v6, "Interface succesfully claimed"

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 435
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5}, Landroid/hardware/usb/UsbInterface;->getEndpointCount()I

    move-result v2

    .line 436
    .local v2, "numberEndpoints":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    add-int/lit8 v5, v2, -0x1

    if-gt v1, v5, :cond_3

    .line 438
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5, v1}, Landroid/hardware/usb/UsbInterface;->getEndpoint(I)Landroid/hardware/usb/UsbEndpoint;

    move-result-object v0

    .line 439
    .local v0, "endpoint":Landroid/hardware/usb/UsbEndpoint;
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getType()I

    move-result v5

    if-ne v5, v8, :cond_2

    .line 440
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getDirection()I

    move-result v5

    const/16 v6, 0x80

    if-ne v5, v6, :cond_2

    .line 442
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 436
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 430
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .end local v1    # "i":I
    .end local v2    # "numberEndpoints":I
    :cond_0
    sget-object v4, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v5, "Interface could not be claimed"

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 469
    :cond_1
    :goto_2
    return v3

    .line 445
    .restart local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .restart local v1    # "i":I
    .restart local v2    # "numberEndpoints":I
    :cond_2
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    goto :goto_1

    .line 450
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    :cond_3
    iput-boolean v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->firstTime:Z

    .line 451
    invoke-direct {p0, v3, v3, v3, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    move-result v5

    if-ltz v5, :cond_1

    .line 453
    const/4 v5, 0x4

    invoke-direct {p0, v5, v9, v3, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    move-result v5

    if-ltz v5, :cond_1

    .line 455
    iput v9, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 456
    const/16 v5, 0x101

    invoke-direct {p0, v4, v5, v3, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    move-result v5

    if-ltz v5, :cond_1

    .line 458
    const/16 v5, 0x202

    invoke-direct {p0, v4, v5, v3, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    move-result v5

    if-ltz v5, :cond_1

    .line 460
    invoke-direct {p0, v8, v3, v3, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    move-result v5

    if-ltz v5, :cond_1

    .line 462
    const/4 v5, 0x3

    const/16 v6, 0x4138

    invoke-direct {p0, v5, v6, v3, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    move-result v5

    if-ltz v5, :cond_1

    .line 466
    iput-boolean v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->rtsCtsEnabled:Z

    .line 467
    iput-boolean v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->dtrDsrEnabled:Z

    move v3, v4

    .line 469
    goto :goto_2
.end method

.method private setControlCommand(III[B)I
    .locals 9
    .param p1, "request"    # I
    .param p2, "value"    # I
    .param p3, "index"    # I
    .param p4, "data"    # [B

    .prologue
    .line 474
    const/4 v6, 0x0

    .line 475
    .local v6, "dataLength":I
    if-eqz p4, :cond_0

    .line 477
    array-length v6, p4

    .line 479
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0x40

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v2}, Landroid/hardware/usb/UsbInterface;->getId()I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    add-int v4, v2, p3

    const/16 v7, 0x1388

    move v2, p1

    move v3, p2

    move-object v5, p4

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 480
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->CLASS_ID:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Control Transfer Response: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 481
    return v8
.end method


# virtual methods
.method public close()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 140
    const/16 v0, 0x100

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 141
    const/16 v0, 0x200

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 142
    iput v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 143
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->killWorkingThread()V

    .line 144
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->killWriteThread()V

    .line 145
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 146
    return-void
.end method

.method public getBreak(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;)V
    .locals 0
    .param p1, "breakCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    .prologue
    .line 402
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->breakCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    .line 403
    return-void
.end method

.method public getCTS(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;)V
    .locals 0
    .param p1, "ctsCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    .prologue
    .line 390
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    .line 391
    return-void
.end method

.method public getDSR(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;)V
    .locals 0
    .param p1, "dsrCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    .prologue
    .line 396
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    .line 397
    return-void
.end method

.method public getFrame(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;)V
    .locals 0
    .param p1, "frameCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    .prologue
    .line 408
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->frameCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    .line 409
    return-void
.end method

.method public getOverrun(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;)V
    .locals 0
    .param p1, "overrunCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    .prologue
    .line 414
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->overrunCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    .line 415
    return-void
.end method

.method public getParity(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;)V
    .locals 0
    .param p1, "parityCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    .prologue
    .line 420
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->parityCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    .line 421
    return-void
.end method

.method public open()Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    .line 113
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->openFTDI()Z

    move-result v0

    .line 115
    .local v0, "ret":Z
    if-eqz v0, :cond_0

    .line 118
    new-instance v2, Landroid/hardware/usb/UsbRequest;

    invoke-direct {v2}, Landroid/hardware/usb/UsbRequest;-><init>()V

    iput-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    .line 119
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {v2, v3, v4}, Landroid/hardware/usb/UsbRequest;->initialize(Landroid/hardware/usb/UsbDeviceConnection;Landroid/hardware/usb/UsbEndpoint;)Z

    .line 122
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->restartWorkingThread()V

    .line 123
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->restartWriteThread()V

    .line 126
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setThreadsParams(Landroid/hardware/usb/UsbRequest;Landroid/hardware/usb/UsbEndpoint;)V

    .line 128
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->asyncMode:Z

    .line 133
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setBaudRate(I)V
    .locals 6
    .param p1, "baudRate"    # I

    .prologue
    const/16 v5, 0x960

    const/16 v4, 0x4b0

    const/16 v3, 0x258

    const/16 v1, 0x12c

    const/16 v2, 0x4b00

    .line 175
    const/4 v0, 0x0

    .line 176
    .local v0, "value":I
    if-ltz p1, :cond_0

    if-gt p1, v1, :cond_0

    .line 177
    const/16 v0, 0x2710

    .line 206
    :goto_0
    const/4 v1, 0x3

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-direct {p0, v1, v0, v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 207
    return-void

    .line 178
    :cond_0
    if-le p1, v1, :cond_1

    if-gt p1, v3, :cond_1

    .line 179
    const/16 v0, 0x1388

    goto :goto_0

    .line 180
    :cond_1
    if-le p1, v3, :cond_2

    if-gt p1, v4, :cond_2

    .line 181
    const/16 v0, 0x9c4

    goto :goto_0

    .line 182
    :cond_2
    if-le p1, v4, :cond_3

    if-gt p1, v5, :cond_3

    .line 183
    const/16 v0, 0x4e2

    goto :goto_0

    .line 184
    :cond_3
    if-le p1, v5, :cond_4

    const/16 v1, 0x12c0

    if-gt p1, v1, :cond_4

    .line 185
    const/16 v0, 0x271

    goto :goto_0

    .line 186
    :cond_4
    const/16 v1, 0x12c0

    if-le p1, v1, :cond_5

    const/16 v1, 0x2580

    if-gt p1, v1, :cond_5

    .line 187
    const/16 v0, 0x4138

    goto :goto_0

    .line 188
    :cond_5
    const/16 v1, 0x2580

    if-le p1, v1, :cond_6

    if-gt p1, v2, :cond_6

    .line 189
    const v0, 0x809c

    goto :goto_0

    .line 190
    :cond_6
    if-le p1, v2, :cond_7

    const v1, 0x9600

    if-gt p1, v1, :cond_7

    .line 191
    const v0, 0xc04e

    goto :goto_0

    .line 192
    :cond_7
    if-le p1, v2, :cond_8

    const v1, 0xe100

    if-gt p1, v1, :cond_8

    .line 193
    const/16 v0, 0x34

    goto :goto_0

    .line 194
    :cond_8
    const v1, 0xe100

    if-le p1, v1, :cond_9

    const v1, 0x1c200

    if-gt p1, v1, :cond_9

    .line 195
    const/16 v0, 0x1a

    goto :goto_0

    .line 196
    :cond_9
    const v1, 0x1c200

    if-le p1, v1, :cond_a

    const v1, 0x38400

    if-gt p1, v1, :cond_a

    .line 197
    const/16 v0, 0xd

    goto :goto_0

    .line 198
    :cond_a
    const v1, 0x38400

    if-le p1, v1, :cond_b

    const v1, 0x70800

    if-gt p1, v1, :cond_b

    .line 199
    const/16 v0, 0x4006

    goto :goto_0

    .line 200
    :cond_b
    const v1, 0x70800

    if-le p1, v1, :cond_c

    const v1, 0xe1000

    if-gt p1, v1, :cond_c

    .line 201
    const v0, 0x8003

    goto/16 :goto_0

    .line 202
    :cond_c
    const v1, 0xe1000

    if-le p1, v1, :cond_d

    .line 203
    const v0, 0x8003

    goto/16 :goto_0

    .line 205
    :cond_d
    const/16 v0, 0x4138

    goto/16 :goto_0
.end method

.method public setDTR(Z)V
    .locals 4
    .param p1, "state"    # Z

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 378
    if-eqz p1, :cond_0

    .line 380
    const/16 v0, 0x101

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 385
    :goto_0
    return-void

    .line 383
    :cond_0
    const/16 v0, 0x100

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0
.end method

.method public setDataBits(I)V
    .locals 4
    .param p1, "dataBits"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x4

    const/4 v1, 0x0

    .line 212
    packed-switch p1, :pswitch_data_0

    .line 243
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 244
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 245
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit8 v0, v0, -0x5

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 246
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit8 v0, v0, 0x8

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 247
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 251
    :goto_0
    return-void

    .line 215
    :pswitch_0
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 216
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 217
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 218
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit8 v0, v0, -0x9

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 219
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 222
    :pswitch_1
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 223
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 224
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 225
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit8 v0, v0, -0x9

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 226
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 229
    :pswitch_2
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 230
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 231
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 232
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit8 v0, v0, -0x9

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 233
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 236
    :pswitch_3
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 237
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 238
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit8 v0, v0, -0x5

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 239
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit8 v0, v0, 0x8

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 240
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 212
    :pswitch_data_0
    .packed-switch 0x5
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public setFlowControl(I)V
    .locals 8
    .param p1, "flowControl"    # I

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    const/4 v5, 0x2

    const/4 v4, 0x0

    .line 333
    packed-switch p1, :pswitch_data_0

    .line 358
    invoke-direct {p0, v5, v4, v4, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 361
    :goto_0
    return-void

    .line 336
    :pswitch_0
    invoke-direct {p0, v5, v4, v4, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 337
    iput-boolean v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->rtsCtsEnabled:Z

    .line 338
    iput-boolean v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->dtrDsrEnabled:Z

    goto :goto_0

    .line 341
    :pswitch_1
    iput-boolean v7, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->rtsCtsEnabled:Z

    .line 342
    iput-boolean v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->dtrDsrEnabled:Z

    .line 343
    const/4 v1, 0x1

    .line 344
    .local v1, "indexRTSCTS":I
    invoke-direct {p0, v5, v4, v1, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 347
    .end local v1    # "indexRTSCTS":I
    :pswitch_2
    iput-boolean v7, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->dtrDsrEnabled:Z

    .line 348
    iput-boolean v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->rtsCtsEnabled:Z

    .line 349
    const/4 v0, 0x2

    .line 350
    .local v0, "indexDSRDTR":I
    invoke-direct {p0, v5, v4, v0, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 353
    .end local v0    # "indexDSRDTR":I
    :pswitch_3
    const/4 v2, 0x4

    .line 354
    .local v2, "indexXONXOFF":I
    const/16 v3, 0x1311

    .line 355
    .local v3, "wValue":I
    invoke-direct {p0, v5, v3, v2, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 333
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public setParity(I)V
    .locals 4
    .param p1, "parity"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x4

    const/4 v1, 0x0

    .line 288
    packed-switch p1, :pswitch_data_0

    .line 321
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x101

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 322
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x201

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 323
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x401

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 324
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 328
    :goto_0
    return-void

    .line 291
    :pswitch_0
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x101

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 292
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x201

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 293
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x401

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 294
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 297
    :pswitch_1
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit16 v0, v0, 0x100

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 298
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x201

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 299
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x401

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 300
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 303
    :pswitch_2
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x101

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 304
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit16 v0, v0, 0x200

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 305
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x401

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 306
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 309
    :pswitch_3
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit16 v0, v0, 0x100

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 310
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit16 v0, v0, 0x200

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 311
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x401

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 312
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 315
    :pswitch_4
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x101

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 316
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x201

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 317
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit16 v0, v0, 0x400

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 318
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 288
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public setRTS(Z)V
    .locals 4
    .param p1, "state"    # Z

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 366
    if-eqz p1, :cond_0

    .line 368
    const/16 v0, 0x202

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 373
    :goto_0
    return-void

    .line 371
    :cond_0
    const/16 v0, 0x200

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0
.end method

.method public setStopBits(I)V
    .locals 4
    .param p1, "stopBits"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x4

    const/4 v1, 0x0

    .line 256
    packed-switch p1, :pswitch_data_0

    .line 277
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x801

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 278
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x1001

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 279
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x2001

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 280
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 283
    :goto_0
    return-void

    .line 259
    :pswitch_0
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x801

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 260
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x1001

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 261
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x2001

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 262
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 265
    :pswitch_1
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit16 v0, v0, 0x800

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 266
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x1001

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 267
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x2001

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 268
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 271
    :pswitch_2
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x801

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 272
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    or-int/lit16 v0, v0, 0x1000

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 273
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    and-int/lit16 v0, v0, -0x2001

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 274
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    goto :goto_0

    .line 256
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public syncClose()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 166
    const/16 v0, 0x100

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 167
    const/16 v0, 0x200

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setControlCommand(III[B)I

    .line 168
    iput v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->currentSioSetData:I

    .line 169
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 170
    return-void
.end method

.method public syncOpen()Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 151
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->openFTDI()Z

    move-result v0

    .line 152
    .local v0, "ret":Z
    if-eqz v0, :cond_0

    .line 154
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->setSyncParams(Landroid/hardware/usb/UsbEndpoint;Landroid/hardware/usb/UsbEndpoint;)V

    .line 155
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->asyncMode:Z

    .line 156
    const/4 v1, 0x1

    .line 159
    :cond_0
    return v1
.end method

.method public syncRead([BI)I
    .locals 16
    .param p1, "buffer"    # [B
    .param p2, "timeout"    # I

    .prologue
    .line 609
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 610
    .local v2, "beginTime":J
    move/from16 v0, p2

    int-to-long v14, v0

    add-long v10, v2, v14

    .line 612
    .local v10, "stopTime":J
    move-object/from16 v0, p0

    iget-boolean v13, v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->asyncMode:Z

    if-eqz v13, :cond_1

    .line 614
    const/4 v8, -0x1

    .line 660
    :cond_0
    :goto_0
    return v8

    .line 617
    :cond_1
    if-nez p1, :cond_2

    .line 619
    const/4 v8, 0x0

    goto :goto_0

    .line 622
    :cond_2
    move-object/from16 v0, p1

    array-length v13, v0

    div-int/lit8 v4, v13, 0x3e

    .line 623
    .local v4, "n":I
    move-object/from16 v0, p1

    array-length v13, v0

    rem-int/lit8 v13, v13, 0x3e

    if-eqz v13, :cond_3

    .line 625
    add-int/lit8 v4, v4, 0x1

    .line 628
    :cond_3
    move-object/from16 v0, p1

    array-length v13, v0

    mul-int/lit8 v14, v4, 0x2

    add-int/2addr v13, v14

    new-array v9, v13, [B

    .line 630
    .local v9, "tempBuffer":[B
    const/4 v8, 0x0

    .line 634
    .local v8, "readen":I
    :cond_4
    const/4 v12, 0x0

    .line 635
    .local v12, "timeLeft":I
    if-lez p2, :cond_5

    .line 637
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v14

    sub-long v14, v10, v14

    long-to-int v12, v14

    .line 638
    if-lez v12, :cond_0

    .line 644
    :cond_5
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    array-length v15, v9

    invoke-virtual {v13, v14, v9, v15, v12}, Landroid/hardware/usb/UsbDeviceConnection;->bulkTransfer(Landroid/hardware/usb/UsbEndpoint;[BII)I

    move-result v6

    .line 646
    .local v6, "numberBytes":I
    const/4 v13, 0x2

    if-le v6, v13, :cond_7

    .line 648
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->ftdiUtilities:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;

    invoke-virtual {v13, v9}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->adaptArray([B)[B

    move-result-object v5

    .line 649
    .local v5, "newBuffer":[B
    const/4 v13, 0x0

    const/4 v14, 0x0

    move-object/from16 v0, p1

    array-length v15, v0

    move-object/from16 v0, p1

    invoke-static {v5, v13, v0, v14, v15}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 651
    div-int/lit8 v7, v6, 0x40

    .line 652
    .local v7, "p":I
    rem-int/lit8 v13, v6, 0x40

    if-eqz v13, :cond_6

    .line 654
    add-int/lit8 v7, v7, 0x1

    .line 656
    :cond_6
    mul-int/lit8 v13, v7, 0x2

    sub-int v8, v6, v13

    .line 658
    .end local v5    # "newBuffer":[B
    .end local v7    # "p":I
    :cond_7
    if-lez v8, :cond_4

    goto :goto_0
.end method
