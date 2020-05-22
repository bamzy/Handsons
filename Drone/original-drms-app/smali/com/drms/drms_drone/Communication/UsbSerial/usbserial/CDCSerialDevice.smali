.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;
.super Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
.source "CDCSerialDevice.java"


# static fields
.field private static final CDC_CONTROL_LINE_OFF:I = 0x0

.field private static final CDC_CONTROL_LINE_ON:I = 0x3

.field private static final CDC_DEFAULT_LINE_CODING:[B

.field private static final CDC_GET_LINE_CODING:I = 0x21

.field private static final CDC_REQTYPE_DEVICE2HOST:I = 0xa1

.field private static final CDC_REQTYPE_HOST2DEVICE:I = 0x21

.field private static final CDC_SET_CONTROL_LINE_STATE:I = 0x22

.field private static final CDC_SET_LINE_CODING:I = 0x20

.field private static final CLASS_ID:Ljava/lang/String;


# instance fields
.field private inEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private mInterface:Landroid/hardware/usb/UsbInterface;

.field private outEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private requestIN:Landroid/hardware/usb/UsbRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->CLASS_ID:Ljava/lang/String;

    .line 30
    const/4 v0, 0x7

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->CDC_DEFAULT_LINE_CODING:[B

    return-void

    nop

    :array_0
    .array-data 1
        0x0t
        -0x3et
        0x1t
        0x0t
        0x0t
        0x0t
        0x8t
    .end array-data
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V
    .locals 1
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    .line 50
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    .line 51
    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V
    .locals 1
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;
    .param p3, "iface"    # I

    .prologue
    .line 55
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V

    .line 56
    if-ltz p3, :cond_0

    .end local p3    # "iface":I
    :goto_0
    invoke-virtual {p1, p3}, Landroid/hardware/usb/UsbDevice;->getInterface(I)Landroid/hardware/usb/UsbInterface;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    .line 57
    return-void

    .line 56
    .restart local p3    # "iface":I
    :cond_0
    invoke-static {p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->findFirstCDC(Landroid/hardware/usb/UsbDevice;)I

    move-result p3

    goto :goto_0
.end method

.method private static findFirstCDC(Landroid/hardware/usb/UsbDevice;)I
    .locals 4
    .param p0, "device"    # Landroid/hardware/usb/UsbDevice;

    .prologue
    .line 328
    invoke-virtual {p0}, Landroid/hardware/usb/UsbDevice;->getInterfaceCount()I

    move-result v1

    .line 330
    .local v1, "interfaceCount":I
    const/4 v0, 0x0

    .local v0, "iIndex":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 332
    invoke-virtual {p0, v0}, Landroid/hardware/usb/UsbDevice;->getInterface(I)Landroid/hardware/usb/UsbInterface;

    move-result-object v2

    invoke-virtual {v2}, Landroid/hardware/usb/UsbInterface;->getInterfaceClass()I

    move-result v2

    const/16 v3, 0xa

    if-ne v2, v3, :cond_0

    .line 339
    .end local v0    # "iIndex":I
    :goto_1
    return v0

    .line 330
    .restart local v0    # "iIndex":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 338
    :cond_1
    sget-object v2, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v3, "There is no CDC class interface"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 339
    const/4 v0, -0x1

    goto :goto_1
.end method

.method private getLineCoding()[B
    .locals 9

    .prologue
    const/4 v3, 0x0

    .line 320
    const/4 v0, 0x7

    new-array v5, v0, [B

    .line 321
    .local v5, "data":[B
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0xa1

    const/16 v2, 0x21

    array-length v6, v5

    const/16 v7, 0x1388

    move v4, v3

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 322
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 323
    return-object v5
.end method

.method private openCDC()Z
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 268
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5, v6, v3}, Landroid/hardware/usb/UsbDeviceConnection;->claimInterface(Landroid/hardware/usb/UsbInterface;Z)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 270
    sget-object v5, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v6, "Interface succesfully claimed"

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 278
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5}, Landroid/hardware/usb/UsbInterface;->getEndpointCount()I

    move-result v2

    .line 279
    .local v2, "numberEndpoints":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    add-int/lit8 v5, v2, -0x1

    if-gt v1, v5, :cond_3

    .line 281
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5, v1}, Landroid/hardware/usb/UsbInterface;->getEndpoint(I)Landroid/hardware/usb/UsbEndpoint;

    move-result-object v0

    .line 282
    .local v0, "endpoint":Landroid/hardware/usb/UsbEndpoint;
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getType()I

    move-result v5

    if-ne v5, v7, :cond_2

    .line 283
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getDirection()I

    move-result v5

    const/16 v6, 0x80

    if-ne v5, v6, :cond_2

    .line 285
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 279
    :cond_0
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 273
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .end local v1    # "i":I
    .end local v2    # "numberEndpoints":I
    :cond_1
    sget-object v3, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v5, "Interface could not be claimed"

    invoke-static {v3, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v3, v4

    .line 303
    :goto_2
    return v3

    .line 286
    .restart local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .restart local v1    # "i":I
    .restart local v2    # "numberEndpoints":I
    :cond_2
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getType()I

    move-result v5

    if-ne v5, v7, :cond_0

    .line 287
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getDirection()I

    move-result v5

    if-nez v5, :cond_0

    .line 289
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    goto :goto_1

    .line 293
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    :cond_3
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    if-eqz v5, :cond_4

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    if-nez v5, :cond_5

    .line 295
    :cond_4
    sget-object v3, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v5, "Interface does not have an IN or OUT interface"

    invoke-static {v3, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v3, v4

    .line 296
    goto :goto_2

    .line 300
    :cond_5
    const/16 v5, 0x20

    sget-object v6, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->CDC_DEFAULT_LINE_CODING:[B

    invoke-direct {p0, v5, v4, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->setControlCommand(II[B)I

    .line 301
    const/16 v4, 0x22

    const/4 v5, 0x3

    const/4 v6, 0x0

    invoke-direct {p0, v4, v5, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->setControlCommand(II[B)I

    goto :goto_2
.end method

.method private setControlCommand(II[B)I
    .locals 9
    .param p1, "request"    # I
    .param p2, "value"    # I
    .param p3, "data"    # [B

    .prologue
    .line 308
    const/4 v6, 0x0

    .line 309
    .local v6, "dataLength":I
    if-eqz p3, :cond_0

    .line 311
    array-length v6, p3

    .line 313
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0x21

    const/4 v4, 0x0

    const/16 v7, 0x1388

    move v2, p1

    move v3, p2

    move-object v5, p3

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 314
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 315
    return v8
.end method


# virtual methods
.method public close()V
    .locals 3

    .prologue
    .line 89
    const/16 v0, 0x22

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->setControlCommand(II[B)I

    .line 90
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->killWorkingThread()V

    .line 91
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->killWriteThread()V

    .line 92
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 93
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    invoke-virtual {v0}, Landroid/hardware/usb/UsbDeviceConnection;->close()V

    .line 94
    return-void
.end method

.method public getBreak(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;)V
    .locals 0
    .param p1, "breakCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    .prologue
    .line 246
    return-void
.end method

.method public getCTS(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;)V
    .locals 0
    .param p1, "ctsCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    .prologue
    .line 234
    return-void
.end method

.method public getDSR(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;)V
    .locals 0
    .param p1, "dsrCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    .prologue
    .line 240
    return-void
.end method

.method public getFrame(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;)V
    .locals 0
    .param p1, "frameCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    .prologue
    .line 252
    return-void
.end method

.method public getOverrun(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;)V
    .locals 0
    .param p1, "overrunCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    .prologue
    .line 258
    return-void
.end method

.method public getParity(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;)V
    .locals 0
    .param p1, "parityCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    .prologue
    .line 264
    return-void
.end method

.method public open()Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    .line 62
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->openCDC()Z

    move-result v0

    .line 64
    .local v0, "ret":Z
    if-eqz v0, :cond_0

    .line 67
    new-instance v2, Landroid/hardware/usb/UsbRequest;

    invoke-direct {v2}, Landroid/hardware/usb/UsbRequest;-><init>()V

    iput-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    .line 68
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {v2, v3, v4}, Landroid/hardware/usb/UsbRequest;->initialize(Landroid/hardware/usb/UsbDeviceConnection;Landroid/hardware/usb/UsbEndpoint;)Z

    .line 71
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->restartWorkingThread()V

    .line 72
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->restartWriteThread()V

    .line 75
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->setThreadsParams(Landroid/hardware/usb/UsbRequest;Landroid/hardware/usb/UsbEndpoint;)V

    .line 77
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->asyncMode:Z

    .line 82
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

    .line 122
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->getLineCoding()[B

    move-result-object v0

    .line 124
    .local v0, "data":[B
    and-int/lit16 v1, p1, 0xff

    int-to-byte v1, v1

    aput-byte v1, v0, v3

    .line 125
    const/4 v1, 0x1

    shr-int/lit8 v2, p1, 0x8

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 126
    const/4 v1, 0x2

    shr-int/lit8 v2, p1, 0x10

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 127
    const/4 v1, 0x3

    shr-int/lit8 v2, p1, 0x18

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 129
    const/16 v1, 0x20

    invoke-direct {p0, v1, v3, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->setControlCommand(II[B)I

    .line 130
    return-void
.end method

.method public setDTR(Z)V
    .locals 0
    .param p1, "state"    # Z

    .prologue
    .line 228
    return-void
.end method

.method public setDataBits(I)V
    .locals 3
    .param p1, "dataBits"    # I

    .prologue
    const/4 v2, 0x6

    .line 135
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->getLineCoding()[B

    move-result-object v0

    .line 136
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 156
    :goto_0
    return-void

    .line 139
    :pswitch_0
    const/4 v1, 0x5

    aput-byte v1, v0, v2

    .line 154
    :goto_1
    const/16 v1, 0x20

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 142
    :pswitch_1
    aput-byte v2, v0, v2

    goto :goto_1

    .line 145
    :pswitch_2
    const/4 v1, 0x7

    aput-byte v1, v0, v2

    goto :goto_1

    .line 148
    :pswitch_3
    const/16 v1, 0x8

    aput-byte v1, v0, v2

    goto :goto_1

    .line 136
    nop

    :pswitch_data_0
    .packed-switch 0x5
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public setFlowControl(I)V
    .locals 0
    .param p1, "flowControl"    # I

    .prologue
    .line 216
    return-void
.end method

.method public setParity(I)V
    .locals 4
    .param p1, "parity"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x5

    .line 185
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->getLineCoding()[B

    move-result-object v0

    .line 186
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 209
    :goto_0
    return-void

    .line 189
    :pswitch_0
    aput-byte v3, v0, v2

    .line 207
    :goto_1
    const/16 v1, 0x20

    invoke-direct {p0, v1, v3, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 192
    :pswitch_1
    const/4 v1, 0x1

    aput-byte v1, v0, v2

    goto :goto_1

    .line 195
    :pswitch_2
    const/4 v1, 0x2

    aput-byte v1, v0, v2

    goto :goto_1

    .line 198
    :pswitch_3
    const/4 v1, 0x3

    aput-byte v1, v0, v2

    goto :goto_1

    .line 201
    :pswitch_4
    const/4 v1, 0x4

    aput-byte v1, v0, v2

    goto :goto_1

    .line 186
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
    .locals 0
    .param p1, "state"    # Z

    .prologue
    .line 222
    return-void
.end method

.method public setStopBits(I)V
    .locals 4
    .param p1, "stopBits"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x4

    .line 161
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->getLineCoding()[B

    move-result-object v0

    .line 162
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 180
    :goto_0
    return-void

    .line 165
    :pswitch_0
    aput-byte v3, v0, v2

    .line 177
    :goto_1
    const/16 v1, 0x20

    invoke-direct {p0, v1, v3, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 168
    :pswitch_1
    const/4 v1, 0x1

    aput-byte v1, v0, v2

    goto :goto_1

    .line 171
    :pswitch_2
    const/4 v1, 0x2

    aput-byte v1, v0, v2

    goto :goto_1

    .line 162
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public syncClose()V
    .locals 3

    .prologue
    .line 114
    const/16 v0, 0x22

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->setControlCommand(II[B)I

    .line 115
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 116
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    invoke-virtual {v0}, Landroid/hardware/usb/UsbDeviceConnection;->close()V

    .line 117
    return-void
.end method

.method public syncOpen()Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 99
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->openCDC()Z

    move-result v0

    .line 100
    .local v0, "ret":Z
    if-eqz v0, :cond_0

    .line 102
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->setSyncParams(Landroid/hardware/usb/UsbEndpoint;Landroid/hardware/usb/UsbEndpoint;)V

    .line 103
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;->asyncMode:Z

    .line 104
    const/4 v1, 0x1

    .line 107
    :cond_0
    return v1
.end method
