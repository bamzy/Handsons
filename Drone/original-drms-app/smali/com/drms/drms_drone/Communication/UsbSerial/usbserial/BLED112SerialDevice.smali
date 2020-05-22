.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;
.super Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
.source "BLED112SerialDevice.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final BLED112_DEFAULT_CONTROL_LINE:I = 0x3

.field private static final BLED112_DEFAULT_LINE_CODING:[B

.field private static final BLED112_DISCONNECT_CONTROL_LINE:I = 0x2

.field private static final BLED112_GET_LINE_CODING:I = 0x21

.field private static final BLED112_REQTYPE_DEVICE2HOST:I = 0xa1

.field private static final BLED112_REQTYPE_HOST2DEVICE:I = 0x21

.field private static final BLED112_SET_CONTROL_LINE_STATE:I = 0x22

.field private static final BLED112_SET_LINE_CODING:I = 0x20

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
    .line 14
    const-class v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->CLASS_ID:Ljava/lang/String;

    .line 31
    const/4 v0, 0x7

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->BLED112_DEFAULT_LINE_CODING:[B

    return-void

    nop

    :array_0
    .array-data 1
        0x0t
        0x1t
        -0x3et
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
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 52
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V

    .line 53
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/hardware/usb/UsbDevice;->getInterface(I)Landroid/hardware/usb/UsbInterface;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    .line 54
    return-void
.end method

.method private getLineCoding()[B
    .locals 9

    .prologue
    const/4 v3, 0x0

    .line 276
    const/4 v0, 0x7

    new-array v5, v0, [B

    .line 277
    .local v5, "data":[B
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0xa1

    const/16 v2, 0x21

    array-length v6, v5

    const/16 v7, 0x1388

    move v4, v3

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 278
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 279
    return-object v5
.end method

.method private setControlCommand(II[B)I
    .locals 9
    .param p1, "request"    # I
    .param p2, "value"    # I
    .param p3, "data"    # [B

    .prologue
    .line 264
    const/4 v6, 0x0

    .line 265
    .local v6, "dataLength":I
    if-eqz p3, :cond_0

    .line 267
    array-length v6, p3

    .line 269
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0x21

    const/4 v4, 0x0

    const/16 v7, 0x1388

    move v2, p1

    move v3, p2

    move-object v5, p3

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 270
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 271
    return v8
.end method


# virtual methods
.method public close()V
    .locals 3

    .prologue
    .line 103
    const/16 v0, 0x22

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->setControlCommand(II[B)I

    .line 104
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->killWorkingThread()V

    .line 105
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->killWriteThread()V

    .line 106
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 107
    return-void
.end method

.method public getBreak(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;)V
    .locals 0
    .param p1, "breakCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    .prologue
    .line 242
    return-void
.end method

.method public getCTS(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;)V
    .locals 0
    .param p1, "ctsCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    .prologue
    .line 230
    return-void
.end method

.method public getDSR(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;)V
    .locals 0
    .param p1, "dsrCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    .prologue
    .line 236
    return-void
.end method

.method public getFrame(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;)V
    .locals 0
    .param p1, "frameCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    .prologue
    .line 248
    return-void
.end method

.method public getOverrun(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;)V
    .locals 0
    .param p1, "overrunCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    .prologue
    .line 254
    return-void
.end method

.method public getParity(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;)V
    .locals 0
    .param p1, "parityCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    .prologue
    .line 260
    return-void
.end method

.method public open()Z
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 60
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->restartWorkingThread()V

    .line 61
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->restartWriteThread()V

    .line 63
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v3, v4, v6}, Landroid/hardware/usb/UsbDeviceConnection;->claimInterface(Landroid/hardware/usb/UsbInterface;Z)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 65
    sget-object v3, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v4, "Interface succesfully claimed"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 72
    :goto_0
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v3}, Landroid/hardware/usb/UsbInterface;->getEndpointCount()I

    move-result v2

    .line 73
    .local v2, "numberEndpoints":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    add-int/lit8 v3, v2, -0x1

    if-gt v1, v3, :cond_2

    .line 75
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v3, v1}, Landroid/hardware/usb/UsbInterface;->getEndpoint(I)Landroid/hardware/usb/UsbEndpoint;

    move-result-object v0

    .line 76
    .local v0, "endpoint":Landroid/hardware/usb/UsbEndpoint;
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getType()I

    move-result v3

    const/4 v4, 0x2

    if-ne v3, v4, :cond_1

    .line 77
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getDirection()I

    move-result v3

    const/16 v4, 0x80

    if-ne v3, v4, :cond_1

    .line 79
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 73
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 68
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .end local v1    # "i":I
    .end local v2    # "numberEndpoints":I
    :cond_0
    sget-object v3, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v4, "Interface could not be claimed"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 82
    .restart local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .restart local v1    # "i":I
    .restart local v2    # "numberEndpoints":I
    :cond_1
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    goto :goto_2

    .line 87
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    :cond_2
    const/16 v3, 0x20

    const/4 v4, 0x0

    sget-object v5, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->BLED112_DEFAULT_LINE_CODING:[B

    invoke-direct {p0, v3, v4, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->setControlCommand(II[B)I

    .line 88
    const/16 v3, 0x22

    const/4 v4, 0x3

    const/4 v5, 0x0

    invoke-direct {p0, v3, v4, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->setControlCommand(II[B)I

    .line 91
    new-instance v3, Landroid/hardware/usb/UsbRequest;

    invoke-direct {v3}, Landroid/hardware/usb/UsbRequest;-><init>()V

    iput-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    .line 92
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {v3, v4, v5}, Landroid/hardware/usb/UsbRequest;->initialize(Landroid/hardware/usb/UsbDeviceConnection;Landroid/hardware/usb/UsbEndpoint;)Z

    .line 95
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v3, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->setThreadsParams(Landroid/hardware/usb/UsbRequest;Landroid/hardware/usb/UsbEndpoint;)V

    .line 97
    return v6
.end method

.method public setBaudRate(I)V
    .locals 4
    .param p1, "baudRate"    # I

    .prologue
    const/4 v3, 0x0

    .line 124
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->getLineCoding()[B

    move-result-object v0

    .line 126
    .local v0, "data":[B
    const/4 v1, 0x3

    and-int/lit16 v2, p1, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 127
    const/4 v1, 0x2

    shr-int/lit8 v2, p1, 0x8

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 128
    const/4 v1, 0x1

    shr-int/lit8 v2, p1, 0x10

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 129
    shr-int/lit8 v1, p1, 0x18

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    aput-byte v1, v0, v3

    .line 131
    const/16 v1, 0x20

    invoke-direct {p0, v1, v3, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->setControlCommand(II[B)I

    .line 132
    return-void
.end method

.method public setDTR(Z)V
    .locals 0
    .param p1, "state"    # Z

    .prologue
    .line 217
    return-void
.end method

.method public setDataBits(I)V
    .locals 3
    .param p1, "dataBits"    # I

    .prologue
    const/4 v2, 0x6

    .line 137
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->getLineCoding()[B

    move-result-object v0

    .line 138
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 154
    :goto_0
    const/16 v1, 0x20

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->setControlCommand(II[B)I

    .line 156
    return-void

    .line 141
    :pswitch_0
    const/4 v1, 0x5

    aput-byte v1, v0, v2

    goto :goto_0

    .line 144
    :pswitch_1
    aput-byte v2, v0, v2

    goto :goto_0

    .line 147
    :pswitch_2
    const/4 v1, 0x7

    aput-byte v1, v0, v2

    goto :goto_0

    .line 150
    :pswitch_3
    const/16 v1, 0x8

    aput-byte v1, v0, v2

    goto :goto_0

    .line 138
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
    .line 224
    return-void
.end method

.method public setParity(I)V
    .locals 4
    .param p1, "parity"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x5

    .line 183
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->getLineCoding()[B

    move-result-object v0

    .line 184
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 203
    :goto_0
    const/16 v1, 0x20

    invoke-direct {p0, v1, v3, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->setControlCommand(II[B)I

    .line 205
    return-void

    .line 187
    :pswitch_0
    aput-byte v3, v0, v2

    goto :goto_0

    .line 190
    :pswitch_1
    const/4 v1, 0x1

    aput-byte v1, v0, v2

    goto :goto_0

    .line 193
    :pswitch_2
    const/4 v1, 0x2

    aput-byte v1, v0, v2

    goto :goto_0

    .line 196
    :pswitch_3
    const/4 v1, 0x3

    aput-byte v1, v0, v2

    goto :goto_0

    .line 199
    :pswitch_4
    const/4 v1, 0x4

    aput-byte v1, v0, v2

    goto :goto_0

    .line 184
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
    .line 211
    return-void
.end method

.method public setStopBits(I)V
    .locals 4
    .param p1, "stopBits"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x4

    .line 161
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->getLineCoding()[B

    move-result-object v0

    .line 162
    .local v0, "data":[B
    packed-switch p1, :pswitch_data_0

    .line 175
    :goto_0
    const/16 v1, 0x20

    invoke-direct {p0, v1, v3, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/BLED112SerialDevice;->setControlCommand(II[B)I

    .line 178
    return-void

    .line 165
    :pswitch_0
    aput-byte v3, v0, v2

    goto :goto_0

    .line 168
    :pswitch_1
    const/4 v1, 0x1

    aput-byte v1, v0, v2

    goto :goto_0

    .line 171
    :pswitch_2
    const/4 v1, 0x2

    aput-byte v1, v0, v2

    goto :goto_0

    .line 162
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
    .line 119
    return-void
.end method

.method public syncOpen()Z
    .locals 1

    .prologue
    .line 112
    const/4 v0, 0x0

    return v0
.end method
