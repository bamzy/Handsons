.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;
.super Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
.source "CP2102SerialDevice.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;
    }
.end annotation


# static fields
.field private static final CLASS_ID:Ljava/lang/String;

.field private static final CP210x_GET_COMM_STATUS:I = 0x10

.field private static final CP210x_GET_LINE_CTL:I = 0x4

.field private static final CP210x_GET_MDMSTS:I = 0x8

.field private static final CP210x_IFC_ENABLE:I = 0x0

.field private static final CP210x_LINE_CTL_DEFAULT:I = 0x800

.field private static final CP210x_MHS_ALL:I = 0x11

.field private static final CP210x_MHS_DEFAULT:I = 0x0

.field private static final CP210x_MHS_DTR:I = 0x1

.field private static final CP210x_MHS_DTR_OFF:I = 0x100

.field private static final CP210x_MHS_DTR_ON:I = 0x101

.field private static final CP210x_MHS_RTS:I = 0x10

.field private static final CP210x_MHS_RTS_OFF:I = 0x200

.field private static final CP210x_MHS_RTS_ON:I = 0x202

.field private static final CP210x_REQTYPE_DEVICE2HOST:I = 0xc1

.field private static final CP210x_REQTYPE_HOST2DEVICE:I = 0x41

.field private static final CP210x_SET_BAUDDIV:I = 0x1

.field private static final CP210x_SET_BAUDRATE:I = 0x1e

.field private static final CP210x_SET_CHARS:I = 0x19

.field private static final CP210x_SET_FLOW:I = 0x13

.field private static final CP210x_SET_LINE_CTL:I = 0x3

.field private static final CP210x_SET_MHS:I = 0x7

.field private static final CP210x_SET_XOFF:I = 0xa

.field private static final CP210x_SET_XON:I = 0x9

.field private static final CP210x_UART_DISABLE:I = 0x0

.field private static final CP210x_UART_ENABLE:I = 0x1

.field private static final CP210x_XOFF:I = 0x0

.field private static final CP210x_XON:I = 0x0

.field private static final DEFAULT_BAUDRATE:I = 0x2580


# instance fields
.field private breakCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

.field private ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

.field private ctsState:Z

.field private dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

.field private dsrState:Z

.field private dtrDsrEnabled:Z

.field private flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;

.field private frameCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

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
    const-class v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->CLASS_ID:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V
    .locals 1
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    .line 83
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    .line 84
    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V
    .locals 2
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;
    .param p3, "iface"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 88
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V

    .line 89
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->rtsCtsEnabled:Z

    .line 90
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->dtrDsrEnabled:Z

    .line 91
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->ctsState:Z

    .line 92
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->dsrState:Z

    .line 93
    if-ltz p3, :cond_0

    .end local p3    # "iface":I
    :goto_0
    invoke-virtual {p1, p3}, Landroid/hardware/usb/UsbDevice;->getInterface(I)Landroid/hardware/usb/UsbInterface;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    .line 94
    return-void

    .restart local p3    # "iface":I
    :cond_0
    move p3, v0

    .line 93
    goto :goto_0
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)[B
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->getCommStatus()[B

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->rtsCtsEnabled:Z

    return v0
.end method

.method static synthetic access$1000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->overrunCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)[B
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->getModemState()[B

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->ctsState:Z

    return v0
.end method

.method static synthetic access$202(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;
    .param p1, "x1"    # Z

    .prologue
    .line 13
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->ctsState:Z

    return p1
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    return-object v0
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->dtrDsrEnabled:Z

    return v0
.end method

.method static synthetic access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->dsrState:Z

    return v0
.end method

.method static synthetic access$502(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;
    .param p1, "x1"    # Z

    .prologue
    .line 13
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->dsrState:Z

    return p1
.end method

.method static synthetic access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    return-object v0
.end method

.method static synthetic access$700(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->parityCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    return-object v0
.end method

.method static synthetic access$800(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->frameCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    return-object v0
.end method

.method static synthetic access$900(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->breakCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    return-object v0
.end method

.method private createFlowControlThread()V
    .locals 1

    .prologue
    .line 558
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;

    .line 559
    return-void
.end method

.method private getCTL()[B
    .locals 9

    .prologue
    .line 605
    const/4 v0, 0x2

    new-array v5, v0, [B

    .line 606
    .local v5, "data":[B
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0xc1

    const/4 v2, 0x4

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v4}, Landroid/hardware/usb/UsbInterface;->getId()I

    move-result v4

    array-length v6, v5

    const/16 v7, 0x1388

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 607
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 608
    return-object v5
.end method

.method private getCommStatus()[B
    .locals 9

    .prologue
    const/16 v6, 0x13

    .line 597
    new-array v5, v6, [B

    .line 598
    .local v5, "data":[B
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0xc1

    const/16 v2, 0x10

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v4}, Landroid/hardware/usb/UsbInterface;->getId()I

    move-result v4

    const/16 v7, 0x1388

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 599
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->CLASS_ID:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Control Transfer Response (Comm status): "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 600
    return-object v5
.end method

.method private getModemState()[B
    .locals 8

    .prologue
    const/4 v6, 0x1

    .line 590
    new-array v5, v6, [B

    .line 591
    .local v5, "data":[B
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0xc1

    const/16 v2, 0x8

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v4}, Landroid/hardware/usb/UsbInterface;->getId()I

    move-result v4

    const/16 v7, 0x1388

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    .line 592
    return-object v5
.end method

.method private openCP2102()Z
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 518
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5, v6, v4}, Landroid/hardware/usb/UsbDeviceConnection;->claimInterface(Landroid/hardware/usb/UsbInterface;Z)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 520
    sget-object v5, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v6, "Interface succesfully claimed"

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 528
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5}, Landroid/hardware/usb/UsbInterface;->getEndpointCount()I

    move-result v2

    .line 529
    .local v2, "numberEndpoints":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    add-int/lit8 v5, v2, -0x1

    if-gt v1, v5, :cond_3

    .line 531
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5, v1}, Landroid/hardware/usb/UsbInterface;->getEndpoint(I)Landroid/hardware/usb/UsbEndpoint;

    move-result-object v0

    .line 532
    .local v0, "endpoint":Landroid/hardware/usb/UsbEndpoint;
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getType()I

    move-result v5

    const/4 v6, 0x2

    if-ne v5, v6, :cond_2

    .line 533
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getDirection()I

    move-result v5

    const/16 v6, 0x80

    if-ne v5, v6, :cond_2

    .line 535
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 529
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 523
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .end local v1    # "i":I
    .end local v2    # "numberEndpoints":I
    :cond_0
    sget-object v4, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v5, "Interface could not be claimed"

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 553
    :cond_1
    :goto_2
    return v3

    .line 538
    .restart local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .restart local v1    # "i":I
    .restart local v2    # "numberEndpoints":I
    :cond_2
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    goto :goto_1

    .line 544
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    :cond_3
    invoke-direct {p0, v3, v4, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    move-result v5

    if-ltz v5, :cond_1

    .line 546
    const/16 v5, 0x2580

    invoke-virtual {p0, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setBaudRate(I)V

    .line 547
    const/4 v5, 0x3

    const/16 v6, 0x800

    invoke-direct {p0, v5, v6, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    move-result v5

    if-ltz v5, :cond_1

    .line 549
    invoke-virtual {p0, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setFlowControl(I)V

    .line 550
    const/4 v5, 0x7

    invoke-direct {p0, v5, v3, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    move-result v5

    if-ltz v5, :cond_1

    move v3, v4

    .line 553
    goto :goto_2
.end method

.method private setControlCommand(II[B)I
    .locals 9
    .param p1, "request"    # I
    .param p2, "value"    # I
    .param p3, "data"    # [B

    .prologue
    .line 578
    const/4 v6, 0x0

    .line 579
    .local v6, "dataLength":I
    if-eqz p3, :cond_0

    .line 581
    array-length v6, p3

    .line 583
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0x41

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v2}, Landroid/hardware/usb/UsbInterface;->getId()I

    move-result v4

    const/16 v7, 0x1388

    move v2, p1

    move v3, p2

    move-object v5, p3

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 584
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 585
    return v8
.end method

.method private startFlowControlThread()V
    .locals 1

    .prologue
    .line 563
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->isAlive()Z

    move-result v0

    if-nez v0, :cond_0

    .line 564
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->start()V

    .line 565
    :cond_0
    return-void
.end method

.method private stopFlowControlThread()V
    .locals 1

    .prologue
    .line 569
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;

    if-eqz v0, :cond_0

    .line 571
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->stopThread()V

    .line 572
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;

    .line 574
    :cond_0
    return-void
.end method


# virtual methods
.method public close()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 129
    const/4 v0, 0x0

    invoke-direct {p0, v1, v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    .line 130
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->killWorkingThread()V

    .line 131
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->killWriteThread()V

    .line 132
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->stopFlowControlThread()V

    .line 133
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 134
    return-void
.end method

.method public getBreak(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;)V
    .locals 0
    .param p1, "breakCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    .prologue
    .line 372
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->breakCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    .line 373
    return-void
.end method

.method public getCTS(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;)V
    .locals 0
    .param p1, "ctsCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    .prologue
    .line 360
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    .line 361
    return-void
.end method

.method public getDSR(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;)V
    .locals 0
    .param p1, "dsrCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    .prologue
    .line 366
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    .line 367
    return-void
.end method

.method public getFrame(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;)V
    .locals 0
    .param p1, "frameCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    .prologue
    .line 378
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->frameCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    .line 379
    return-void
.end method

.method public getOverrun(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;)V
    .locals 0
    .param p1, "overrunCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    .prologue
    .line 384
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->overrunCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    .line 385
    return-void
.end method

.method public getParity(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;)V
    .locals 0
    .param p1, "parityCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    .prologue
    .line 390
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->parityCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    .line 391
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->startFlowControlThread()V

    .line 392
    return-void
.end method

.method public open()Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    .line 99
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->openCP2102()Z

    move-result v0

    .line 101
    .local v0, "ret":Z
    if-eqz v0, :cond_0

    .line 104
    new-instance v2, Landroid/hardware/usb/UsbRequest;

    invoke-direct {v2}, Landroid/hardware/usb/UsbRequest;-><init>()V

    iput-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    .line 105
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {v2, v3, v4}, Landroid/hardware/usb/UsbRequest;->initialize(Landroid/hardware/usb/UsbDeviceConnection;Landroid/hardware/usb/UsbEndpoint;)Z

    .line 108
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->restartWorkingThread()V

    .line 109
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->restartWriteThread()V

    .line 112
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->createFlowControlThread()V

    .line 115
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setThreadsParams(Landroid/hardware/usb/UsbRequest;Landroid/hardware/usb/UsbEndpoint;)V

    .line 117
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->asyncMode:Z

    .line 122
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setBaudRate(I)V
    .locals 4
    .param p1, "baudRate"    # I

    .prologue
    const/4 v3, 0x0

    .line 164
    const/4 v1, 0x4

    new-array v0, v1, [B

    and-int/lit16 v1, p1, 0xff

    int-to-byte v1, v1

    aput-byte v1, v0, v3

    const/4 v1, 0x1

    shr-int/lit8 v2, p1, 0x8

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    const/4 v1, 0x2

    shr-int/lit8 v2, p1, 0x10

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    const/4 v1, 0x3

    shr-int/lit8 v2, p1, 0x18

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 170
    .local v0, "data":[B
    const/16 v1, 0x1e

    invoke-direct {p0, v1, v3, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    .line 171
    return-void
.end method

.method public setDTR(Z)V
    .locals 3
    .param p1, "state"    # Z

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x7

    .line 348
    if-eqz p1, :cond_0

    .line 350
    const/16 v0, 0x101

    invoke-direct {p0, v1, v0, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    .line 355
    :goto_0
    return-void

    .line 353
    :cond_0
    const/16 v0, 0x100

    invoke-direct {p0, v1, v0, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    goto :goto_0
.end method

.method public setDataBits(I)V
    .locals 4
    .param p1, "dataBits"    # I

    .prologue
    const/4 v3, 0x1

    .line 176
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->getCTL()[B

    move-result-object v0

    .line 177
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 197
    :goto_0
    return-void

    .line 180
    :pswitch_0
    const/4 v2, 0x5

    aput-byte v2, v0, v3

    .line 194
    :goto_1
    aget-byte v2, v0, v3

    shl-int/lit8 v2, v2, 0x8

    const/4 v3, 0x0

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    or-int/2addr v2, v3

    int-to-byte v1, v2

    .line 195
    .local v1, "wValue":B
    const/4 v2, 0x3

    const/4 v3, 0x0

    invoke-direct {p0, v2, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 183
    .end local v1    # "wValue":B
    :pswitch_1
    const/4 v2, 0x6

    aput-byte v2, v0, v3

    goto :goto_1

    .line 186
    :pswitch_2
    const/4 v2, 0x7

    aput-byte v2, v0, v3

    goto :goto_1

    .line 189
    :pswitch_3
    const/16 v2, 0x8

    aput-byte v2, v0, v3

    goto :goto_1

    .line 177
    :pswitch_data_0
    .packed-switch 0x5
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public setFlowControl(I)V
    .locals 13
    .param p1, "flowControl"    # I

    .prologue
    const/4 v12, 0x4

    const/16 v10, 0x13

    const/16 v9, 0x10

    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 270
    packed-switch p1, :pswitch_data_0

    .line 331
    :goto_0
    return-void

    .line 273
    :pswitch_0
    new-array v4, v9, [B

    fill-array-data v4, :array_0

    .line 279
    .local v4, "dataOff":[B
    iput-boolean v8, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->rtsCtsEnabled:Z

    .line 280
    iput-boolean v8, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->dtrDsrEnabled:Z

    .line 281
    invoke-direct {p0, v10, v8, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 284
    .end local v4    # "dataOff":[B
    :pswitch_1
    new-array v5, v9, [B

    fill-array-data v5, :array_1

    .line 290
    .local v5, "dataRTSCTS":[B
    iput-boolean v7, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->rtsCtsEnabled:Z

    .line 291
    iput-boolean v8, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->dtrDsrEnabled:Z

    .line 292
    invoke-direct {p0, v10, v8, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    .line 293
    const/4 v9, 0x7

    const/16 v10, 0x202

    const/4 v11, 0x0

    invoke-direct {p0, v9, v10, v11}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    .line 294
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->getCommStatus()[B

    move-result-object v0

    .line 295
    .local v0, "commStatusCTS":[B
    aget-byte v9, v0, v12

    and-int/lit8 v9, v9, 0x1

    if-nez v9, :cond_0

    :goto_1
    iput-boolean v7, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->ctsState:Z

    .line 296
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->startFlowControlThread()V

    goto :goto_0

    :cond_0
    move v7, v8

    .line 295
    goto :goto_1

    .line 299
    .end local v0    # "commStatusCTS":[B
    .end local v5    # "dataRTSCTS":[B
    :pswitch_2
    new-array v3, v9, [B

    fill-array-data v3, :array_2

    .line 305
    .local v3, "dataDSRDTR":[B
    iput-boolean v7, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->dtrDsrEnabled:Z

    .line 306
    iput-boolean v8, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->rtsCtsEnabled:Z

    .line 307
    invoke-direct {p0, v10, v8, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    .line 308
    const/4 v9, 0x7

    const/16 v10, 0x101

    const/4 v11, 0x0

    invoke-direct {p0, v9, v10, v11}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    .line 309
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->getCommStatus()[B

    move-result-object v1

    .line 310
    .local v1, "commStatusDSR":[B
    aget-byte v9, v1, v12

    and-int/lit8 v9, v9, 0x2

    if-nez v9, :cond_1

    :goto_2
    iput-boolean v7, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->dsrState:Z

    .line 311
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->startFlowControlThread()V

    goto :goto_0

    :cond_1
    move v7, v8

    .line 310
    goto :goto_2

    .line 314
    .end local v1    # "commStatusDSR":[B
    .end local v3    # "dataDSRDTR":[B
    :pswitch_3
    new-array v6, v9, [B

    fill-array-data v6, :array_3

    .line 321
    .local v6, "dataXONXOFF":[B
    const/4 v7, 0x6

    new-array v2, v7, [B

    fill-array-data v2, :array_4

    .line 325
    .local v2, "dataChars":[B
    const/16 v7, 0x19

    invoke-direct {p0, v7, v8, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    .line 326
    invoke-direct {p0, v10, v8, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 270
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch

    .line 273
    :array_0
    .array-data 1
        0x1t
        0x0t
        0x0t
        0x0t
        0x40t
        0x0t
        0x0t
        0x0t
        0x0t
        -0x80t
        0x0t
        0x0t
        0x0t
        0x20t
        0x0t
        0x0t
    .end array-data

    .line 284
    :array_1
    .array-data 1
        0x9t
        0x0t
        0x0t
        0x0t
        0x40t
        0x0t
        0x0t
        0x0t
        0x0t
        -0x80t
        0x0t
        0x0t
        0x0t
        0x20t
        0x0t
        0x0t
    .end array-data

    .line 299
    :array_2
    .array-data 1
        0x11t
        0x0t
        0x0t
        0x0t
        0x40t
        0x0t
        0x0t
        0x0t
        0x0t
        -0x80t
        0x0t
        0x0t
        0x0t
        0x20t
        0x0t
        0x0t
    .end array-data

    .line 314
    :array_3
    .array-data 1
        0x1t
        0x0t
        0x0t
        0x0t
        0x43t
        0x0t
        0x0t
        0x0t
        0x0t
        -0x80t
        0x0t
        0x0t
        0x0t
        0x20t
        0x0t
        0x0t
    .end array-data

    .line 321
    :array_4
    .array-data 1
        0x0t
        0x0t
        0x0t
        0x0t
        0x11t
        0x13t
    .end array-data
.end method

.method public setParity(I)V
    .locals 4
    .param p1, "parity"    # I

    .prologue
    const/4 v3, 0x0

    .line 227
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->getCTL()[B

    move-result-object v0

    .line 228
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 265
    :goto_0
    return-void

    .line 231
    :pswitch_0
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x11

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 232
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x21

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 233
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x41

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 234
    aget-byte v2, v0, v3

    and-int/lit16 v2, v2, -0x81

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 263
    :goto_1
    const/4 v2, 0x1

    aget-byte v2, v0, v2

    shl-int/lit8 v2, v2, 0x8

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    or-int/2addr v2, v3

    int-to-byte v1, v2

    .line 264
    .local v1, "wValue":B
    const/4 v2, 0x3

    const/4 v3, 0x0

    invoke-direct {p0, v2, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 237
    .end local v1    # "wValue":B
    :pswitch_1
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x10

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 238
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x21

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 239
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x41

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 240
    aget-byte v2, v0, v3

    and-int/lit16 v2, v2, -0x81

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    goto :goto_1

    .line 243
    :pswitch_2
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x11

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 244
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x20

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 245
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x41

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 246
    aget-byte v2, v0, v3

    and-int/lit16 v2, v2, -0x81

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    goto :goto_1

    .line 249
    :pswitch_3
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x10

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 250
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x20

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 251
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x41

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 252
    aget-byte v2, v0, v3

    and-int/lit16 v2, v2, -0x81

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    goto :goto_1

    .line 255
    :pswitch_4
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x11

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 256
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x21

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 257
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x40

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 258
    aget-byte v2, v0, v3

    and-int/lit16 v2, v2, -0x81

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    goto/16 :goto_1

    .line 228
    nop

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
    .locals 3
    .param p1, "state"    # Z

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x7

    .line 336
    if-eqz p1, :cond_0

    .line 338
    const/16 v0, 0x202

    invoke-direct {p0, v1, v0, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    .line 343
    :goto_0
    return-void

    .line 341
    :cond_0
    const/16 v0, 0x200

    invoke-direct {p0, v1, v0, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    goto :goto_0
.end method

.method public setStopBits(I)V
    .locals 4
    .param p1, "stopBits"    # I

    .prologue
    const/4 v3, 0x0

    .line 202
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->getCTL()[B

    move-result-object v0

    .line 203
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 222
    :goto_0
    return-void

    .line 206
    :pswitch_0
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x2

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 207
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x3

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 220
    :goto_1
    const/4 v2, 0x1

    aget-byte v2, v0, v2

    shl-int/lit8 v2, v2, 0x8

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    or-int/2addr v2, v3

    int-to-byte v1, v2

    .line 221
    .local v1, "wValue":B
    const/4 v2, 0x3

    const/4 v3, 0x0

    invoke-direct {p0, v2, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 210
    .end local v1    # "wValue":B
    :pswitch_1
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 211
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x3

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    goto :goto_1

    .line 214
    :pswitch_2
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x2

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 215
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x2

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    goto :goto_1

    .line 203
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public syncClose()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 156
    const/4 v0, 0x0

    invoke-direct {p0, v1, v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setControlCommand(II[B)I

    .line 157
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->stopFlowControlThread()V

    .line 158
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 159
    return-void
.end method

.method public syncOpen()Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 139
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->openCP2102()Z

    move-result v0

    .line 140
    .local v0, "ret":Z
    if-eqz v0, :cond_0

    .line 143
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->createFlowControlThread()V

    .line 144
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->setSyncParams(Landroid/hardware/usb/UsbEndpoint;Landroid/hardware/usb/UsbEndpoint;)V

    .line 145
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->asyncMode:Z

    .line 146
    const/4 v1, 0x1

    .line 149
    :cond_0
    return v1
.end method
