.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;
.super Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
.source "XdcVcpSerialDevice.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final CLASS_ID:Ljava/lang/String;

.field private static final DEFAULT_BAUDRATE:I = 0x1c200

.field private static final XDCVCP_GET_LINE_CTL:I = 0x4

.field private static final XDCVCP_IFC_ENABLE:I = 0x0

.field private static final XDCVCP_LINE_CTL_DEFAULT:I = 0x800

.field private static final XDCVCP_MHS_ALL:I = 0x11

.field private static final XDCVCP_MHS_DEFAULT:I = 0x0

.field private static final XDCVCP_MHS_DTR:I = 0x1

.field private static final XDCVCP_MHS_RTS:I = 0x10

.field private static final XDCVCP_REQTYPE_DEVICE2HOST:I = 0xc1

.field private static final XDCVCP_REQTYPE_HOST2DEVICE:I = 0x41

.field private static final XDCVCP_SET_BAUDDIV:I = 0x1

.field private static final XDCVCP_SET_BAUDRATE:I = 0x1e

.field private static final XDCVCP_SET_CHARS:I = 0x19

.field private static final XDCVCP_SET_FLOW:I = 0x13

.field private static final XDCVCP_SET_LINE_CTL:I = 0x3

.field private static final XDCVCP_SET_MHS:I = 0x7

.field private static final XDCVCP_SET_XOFF:I = 0xa

.field private static final XDCVCP_SET_XON:I = 0x9

.field private static final XDCVCP_UART_DISABLE:I = 0x0

.field private static final XDCVCP_UART_ENABLE:I = 0x1

.field private static final XDCVCP_XOFF:I

.field private static final XDCVCP_XON:I


# instance fields
.field private inEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private mInterface:Landroid/hardware/usb/UsbInterface;

.field private outEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private requestIN:Landroid/hardware/usb/UsbRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->CLASS_ID:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V
    .locals 1
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    .line 59
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    .line 60
    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V
    .locals 1
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;
    .param p3, "iface"    # I

    .prologue
    .line 65
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V

    .line 66
    if-ltz p3, :cond_0

    .end local p3    # "iface":I
    :goto_0
    invoke-virtual {p1, p3}, Landroid/hardware/usb/UsbDevice;->getInterface(I)Landroid/hardware/usb/UsbInterface;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    .line 67
    return-void

    .line 66
    .restart local p3    # "iface":I
    :cond_0
    const/4 p3, 0x0

    goto :goto_0
.end method

.method private getCTL()[B
    .locals 9

    .prologue
    .line 363
    const/4 v0, 0x2

    new-array v5, v0, [B

    .line 364
    .local v5, "data":[B
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0xc1

    const/4 v2, 0x4

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v4}, Landroid/hardware/usb/UsbInterface;->getId()I

    move-result v4

    array-length v6, v5

    const/16 v7, 0x1388

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 365
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 366
    return-object v5
.end method

.method private setControlCommand(II[B)I
    .locals 9
    .param p1, "request"    # I
    .param p2, "value"    # I
    .param p3, "data"    # [B

    .prologue
    .line 351
    const/4 v6, 0x0

    .line 352
    .local v6, "dataLength":I
    if-eqz p3, :cond_0

    .line 354
    array-length v6, p3

    .line 356
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0x41

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v2}, Landroid/hardware/usb/UsbInterface;->getId()I

    move-result v4

    const/16 v7, 0x1388

    move v2, p1

    move v3, p2

    move-object v5, p3

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 357
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 358
    return v8
.end method


# virtual methods
.method public close()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 125
    const/4 v0, 0x0

    invoke-direct {p0, v1, v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    .line 126
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->killWorkingThread()V

    .line 127
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->killWriteThread()V

    .line 128
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 129
    return-void
.end method

.method public getBreak(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;)V
    .locals 0
    .param p1, "breakCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    .prologue
    .line 329
    return-void
.end method

.method public getCTS(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;)V
    .locals 0
    .param p1, "ctsCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    .prologue
    .line 317
    return-void
.end method

.method public getDSR(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;)V
    .locals 0
    .param p1, "dsrCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    .prologue
    .line 323
    return-void
.end method

.method public getFrame(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;)V
    .locals 0
    .param p1, "frameCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    .prologue
    .line 335
    return-void
.end method

.method public getOverrun(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;)V
    .locals 0
    .param p1, "overrunCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    .prologue
    .line 341
    return-void
.end method

.method public getParity(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;)V
    .locals 0
    .param p1, "parityCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    .prologue
    .line 347
    return-void
.end method

.method public open()Z
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 74
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->restartWorkingThread()V

    .line 75
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->restartWriteThread()V

    .line 77
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5, v6, v4}, Landroid/hardware/usb/UsbDeviceConnection;->claimInterface(Landroid/hardware/usb/UsbInterface;Z)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 79
    sget-object v5, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v6, "Interface succesfully claimed"

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 87
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5}, Landroid/hardware/usb/UsbInterface;->getEndpointCount()I

    move-result v2

    .line 88
    .local v2, "numberEndpoints":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    add-int/lit8 v5, v2, -0x1

    if-gt v1, v5, :cond_3

    .line 90
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5, v1}, Landroid/hardware/usb/UsbInterface;->getEndpoint(I)Landroid/hardware/usb/UsbEndpoint;

    move-result-object v0

    .line 91
    .local v0, "endpoint":Landroid/hardware/usb/UsbEndpoint;
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getType()I

    move-result v5

    const/4 v6, 0x2

    if-ne v5, v6, :cond_2

    .line 92
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getDirection()I

    move-result v5

    const/16 v6, 0x80

    if-ne v5, v6, :cond_2

    .line 94
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 88
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 82
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .end local v1    # "i":I
    .end local v2    # "numberEndpoints":I
    :cond_0
    sget-object v4, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v5, "Interface could not be claimed"

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 119
    :cond_1
    :goto_2
    return v3

    .line 97
    .restart local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .restart local v1    # "i":I
    .restart local v2    # "numberEndpoints":I
    :cond_2
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    goto :goto_1

    .line 103
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    :cond_3
    invoke-direct {p0, v3, v4, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    move-result v5

    if-ltz v5, :cond_1

    .line 105
    const v5, 0x1c200

    invoke-virtual {p0, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setBaudRate(I)V

    .line 106
    const/4 v5, 0x3

    const/16 v6, 0x800

    invoke-direct {p0, v5, v6, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    move-result v5

    if-ltz v5, :cond_1

    .line 108
    invoke-virtual {p0, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setFlowControl(I)V

    .line 109
    const/4 v5, 0x7

    invoke-direct {p0, v5, v3, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    move-result v5

    if-ltz v5, :cond_1

    .line 113
    new-instance v3, Landroid/hardware/usb/UsbRequest;

    invoke-direct {v3}, Landroid/hardware/usb/UsbRequest;-><init>()V

    iput-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    .line 114
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {v3, v5, v6}, Landroid/hardware/usb/UsbRequest;->initialize(Landroid/hardware/usb/UsbDeviceConnection;Landroid/hardware/usb/UsbEndpoint;)Z

    .line 117
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v3, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setThreadsParams(Landroid/hardware/usb/UsbRequest;Landroid/hardware/usb/UsbEndpoint;)V

    move v3, v4

    .line 119
    goto :goto_2
.end method

.method public setBaudRate(I)V
    .locals 4
    .param p1, "baudRate"    # I

    .prologue
    const/4 v3, 0x0

    .line 146
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

    .line 152
    .local v0, "data":[B
    const/16 v1, 0x1e

    invoke-direct {p0, v1, v3, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    .line 153
    return-void
.end method

.method public setDTR(Z)V
    .locals 0
    .param p1, "state"    # Z

    .prologue
    .line 311
    return-void
.end method

.method public setDataBits(I)V
    .locals 4
    .param p1, "dataBits"    # I

    .prologue
    const/4 v3, 0x1

    .line 158
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->getCTL()[B

    move-result-object v0

    .line 159
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 179
    :goto_0
    return-void

    .line 162
    :pswitch_0
    const/4 v2, 0x5

    aput-byte v2, v0, v3

    .line 176
    :goto_1
    aget-byte v2, v0, v3

    shl-int/lit8 v2, v2, 0x8

    const/4 v3, 0x0

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    or-int/2addr v2, v3

    int-to-byte v1, v2

    .line 177
    .local v1, "wValue":B
    const/4 v2, 0x3

    const/4 v3, 0x0

    invoke-direct {p0, v2, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 165
    .end local v1    # "wValue":B
    :pswitch_1
    const/4 v2, 0x6

    aput-byte v2, v0, v3

    goto :goto_1

    .line 168
    :pswitch_2
    const/4 v2, 0x7

    aput-byte v2, v0, v3

    goto :goto_1

    .line 171
    :pswitch_3
    const/16 v2, 0x8

    aput-byte v2, v0, v3

    goto :goto_1

    .line 159
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
    const/16 v7, 0x13

    const/16 v5, 0x10

    const/4 v6, 0x0

    .line 252
    packed-switch p1, :pswitch_data_0

    .line 299
    :goto_0
    return-void

    .line 255
    :pswitch_0
    new-array v2, v5, [B

    fill-array-data v2, :array_0

    .line 261
    .local v2, "dataOff":[B
    invoke-direct {p0, v7, v6, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 264
    .end local v2    # "dataOff":[B
    :pswitch_1
    new-array v3, v5, [B

    fill-array-data v3, :array_1

    .line 270
    .local v3, "dataRTSCTS":[B
    invoke-direct {p0, v7, v6, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 273
    .end local v3    # "dataRTSCTS":[B
    :pswitch_2
    new-array v1, v5, [B

    fill-array-data v1, :array_2

    .line 279
    .local v1, "dataDSRDTR":[B
    invoke-direct {p0, v7, v6, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 282
    .end local v1    # "dataDSRDTR":[B
    :pswitch_3
    new-array v4, v5, [B

    fill-array-data v4, :array_3

    .line 289
    .local v4, "dataXONXOFF":[B
    const/4 v5, 0x6

    new-array v0, v5, [B

    fill-array-data v0, :array_4

    .line 293
    .local v0, "dataChars":[B
    const/16 v5, 0x19

    invoke-direct {p0, v5, v6, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    .line 294
    invoke-direct {p0, v7, v6, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 252
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch

    .line 255
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

    .line 264
    :array_1
    .array-data 1
        0x9t
        0x0t
        0x0t
        0x0t
        -0x80t
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

    .line 273
    :array_2
    .array-data 1
        0x12t
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

    .line 282
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

    .line 289
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

    .line 209
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->getCTL()[B

    move-result-object v0

    .line 210
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 247
    :goto_0
    return-void

    .line 213
    :pswitch_0
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x11

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 214
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x21

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 215
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x41

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 216
    aget-byte v2, v0, v3

    and-int/lit16 v2, v2, -0x81

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 245
    :goto_1
    const/4 v2, 0x1

    aget-byte v2, v0, v2

    shl-int/lit8 v2, v2, 0x8

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    or-int/2addr v2, v3

    int-to-byte v1, v2

    .line 246
    .local v1, "wValue":B
    const/4 v2, 0x3

    const/4 v3, 0x0

    invoke-direct {p0, v2, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 219
    .end local v1    # "wValue":B
    :pswitch_1
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x10

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 220
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x21

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 221
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x41

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 222
    aget-byte v2, v0, v3

    and-int/lit16 v2, v2, -0x81

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    goto :goto_1

    .line 225
    :pswitch_2
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x11

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 226
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x20

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 227
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x41

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 228
    aget-byte v2, v0, v3

    and-int/lit16 v2, v2, -0x81

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    goto :goto_1

    .line 231
    :pswitch_3
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x10

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 232
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x20

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

    goto :goto_1

    .line 237
    :pswitch_4
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x11

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 238
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x21

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 239
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x40

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 240
    aget-byte v2, v0, v3

    and-int/lit16 v2, v2, -0x81

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    goto/16 :goto_1

    .line 210
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
    .locals 0
    .param p1, "state"    # Z

    .prologue
    .line 305
    return-void
.end method

.method public setStopBits(I)V
    .locals 4
    .param p1, "stopBits"    # I

    .prologue
    const/4 v3, 0x0

    .line 184
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->getCTL()[B

    move-result-object v0

    .line 185
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 204
    :goto_0
    return-void

    .line 188
    :pswitch_0
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x2

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 189
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x3

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 202
    :goto_1
    const/4 v2, 0x1

    aget-byte v2, v0, v2

    shl-int/lit8 v2, v2, 0x8

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    or-int/2addr v2, v3

    int-to-byte v1, v2

    .line 203
    .local v1, "wValue":B
    const/4 v2, 0x3

    const/4 v3, 0x0

    invoke-direct {p0, v2, v1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/XdcVcpSerialDevice;->setControlCommand(II[B)I

    goto :goto_0

    .line 192
    .end local v1    # "wValue":B
    :pswitch_1
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 193
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x3

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    goto :goto_1

    .line 196
    :pswitch_2
    aget-byte v2, v0, v3

    and-int/lit8 v2, v2, -0x2

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    .line 197
    aget-byte v2, v0, v3

    or-int/lit8 v2, v2, 0x2

    int-to-byte v2, v2

    aput-byte v2, v0, v3

    goto :goto_1

    .line 185
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public syncClose()V
    .locals 0

    .prologue
    .line 141
    return-void
.end method

.method public syncOpen()Z
    .locals 1

    .prologue
    .line 134
    const/4 v0, 0x0

    return v0
.end method
