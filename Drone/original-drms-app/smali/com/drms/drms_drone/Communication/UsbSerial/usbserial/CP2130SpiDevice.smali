.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;
.super Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;
.source "CP2130SpiDevice.java"


# static fields
.field private static final BM_REQ_DEVICE_2_HOST:I = 0xc0

.field private static final BM_REQ_HOST_2_DEVICE:I = 0x40

.field private static CLASS_ID:Ljava/lang/String; = null

.field public static final CLOCK_12MHz:I = 0x0

.field public static final CLOCK_187_5KHz:I = 0x6

.field public static final CLOCK_1_5MHz:I = 0x3

.field public static final CLOCK_375KHz:I = 0x5

.field public static final CLOCK_3MHz:I = 0x2

.field public static final CLOCK_6MHz:I = 0x1

.field public static final CLOCK_750KHz:I = 0x4

.field public static final CLOCK_93_75KHz:I = 0x7

.field private static final GET_SPI_WORD:I = 0x30

.field private static final SET_GPIO_CHIP_SELECT:I = 0x25

.field private static final SET_SPI_WORD:I = 0x31


# instance fields
.field private currentChannel:I

.field private inEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private mInterface:Landroid/hardware/usb/UsbInterface;

.field private outEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private requestIN:Landroid/hardware/usb/UsbRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->CLASS_ID:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V
    .locals 1
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    .line 41
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    .line 42
    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V
    .locals 2
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;
    .param p3, "iface"    # I

    .prologue
    const/4 v0, 0x0

    .line 46
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V

    .line 47
    if-ltz p3, :cond_0

    .end local p3    # "iface":I
    :goto_0
    invoke-virtual {p1, p3}, Landroid/hardware/usb/UsbDevice;->getInterface(I)Landroid/hardware/usb/UsbInterface;

    move-result-object v1

    iput-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    .line 48
    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    .line 49
    return-void

    .restart local p3    # "iface":I
    :cond_0
    move p3, v0

    .line 47
    goto :goto_0
.end method

.method private getSpiWord()[B
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 265
    const/16 v0, 0x30

    const/4 v1, 0x2

    invoke-direct {p0, v0, v2, v2, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setControlCommandIn(IIII)[B

    move-result-object v0

    return-object v0
.end method

.method private openCP2130()Z
    .locals 6

    .prologue
    const/4 v3, 0x1

    .line 189
    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v4, v5, v3}, Landroid/hardware/usb/UsbDeviceConnection;->claimInterface(Landroid/hardware/usb/UsbInterface;Z)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 191
    sget-object v4, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->CLASS_ID:Ljava/lang/String;

    const-string v5, "Interface succesfully claimed"

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 199
    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v4}, Landroid/hardware/usb/UsbInterface;->getEndpointCount()I

    move-result v2

    .line 200
    .local v2, "numberEndpoints":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    add-int/lit8 v4, v2, -0x1

    if-gt v1, v4, :cond_1

    .line 202
    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v4, v1}, Landroid/hardware/usb/UsbInterface;->getEndpoint(I)Landroid/hardware/usb/UsbEndpoint;

    move-result-object v0

    .line 203
    .local v0, "endpoint":Landroid/hardware/usb/UsbEndpoint;
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getType()I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_2

    .line 204
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getDirection()I

    move-result v4

    const/16 v5, 0x80

    if-ne v4, v5, :cond_2

    .line 206
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 200
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 194
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .end local v1    # "i":I
    .end local v2    # "numberEndpoints":I
    :cond_0
    sget-object v3, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->CLASS_ID:Ljava/lang/String;

    const-string v4, "Interface could not be claimed"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 195
    const/4 v3, 0x0

    .line 213
    :cond_1
    return v3

    .line 209
    .restart local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .restart local v1    # "i":I
    .restart local v2    # "numberEndpoints":I
    :cond_2
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    goto :goto_1
.end method

.method private setControlCommandIn(IIII)[B
    .locals 9
    .param p1, "request"    # I
    .param p2, "value"    # I
    .param p3, "index"    # I
    .param p4, "length"    # I

    .prologue
    .line 282
    new-array v5, p4, [B

    .line 283
    .local v5, "data":[B
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0xc0

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v2}, Landroid/hardware/usb/UsbInterface;->getId()I

    move-result v4

    const/16 v7, 0x1388

    move v2, p1

    move v3, p2

    move v6, p4

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 284
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 285
    return-object v5
.end method

.method private setControlCommandOut(III[B)I
    .locals 9
    .param p1, "request"    # I
    .param p2, "value"    # I
    .param p3, "index"    # I
    .param p4, "data"    # [B

    .prologue
    .line 270
    const/4 v6, 0x0

    .line 271
    .local v6, "dataLength":I
    if-eqz p4, :cond_0

    .line 273
    array-length v6, p4

    .line 275
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0x40

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v2}, Landroid/hardware/usb/UsbInterface;->getId()I

    move-result v4

    const/16 v7, 0x1388

    move v2, p1

    move v3, p2

    move-object v5, p4

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 276
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 277
    return v8
.end method

.method private setGpioChipSelect(IZ)V
    .locals 5
    .param p1, "channel"    # I
    .param p2, "othersDisabled"    # Z

    .prologue
    const/4 v4, 0x0

    .line 237
    const/4 v3, 0x2

    new-array v1, v3, [B

    .line 239
    .local v1, "payload":[B
    if-ltz p1, :cond_1

    const/16 v3, 0xa

    if-gt p1, v3, :cond_1

    .line 241
    int-to-byte v3, p1

    aput-byte v3, v1, v4

    .line 249
    if-eqz p2, :cond_2

    .line 250
    const/4 v0, 0x2

    .line 254
    .local v0, "control":B
    :goto_0
    const/4 v3, 0x1

    aput-byte v0, v1, v3

    .line 256
    const/16 v3, 0x25

    invoke-direct {p0, v3, v4, v4, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setControlCommandOut(III[B)I

    move-result v2

    .line 258
    .local v2, "ret":I
    const/4 v3, -0x1

    if-eq v2, v3, :cond_0

    .line 259
    iput p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    .line 261
    .end local v0    # "control":B
    .end local v2    # "ret":I
    :cond_0
    :goto_1
    return-void

    .line 244
    :cond_1
    sget-object v3, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->CLASS_ID:Ljava/lang/String;

    const-string v4, "Channel not valid"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 252
    :cond_2
    const/4 v0, 0x1

    .restart local v0    # "control":B
    goto :goto_0
.end method

.method private setSetSpiWord(II)V
    .locals 4
    .param p1, "channel"    # I
    .param p2, "freq"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 218
    const/4 v1, 0x2

    new-array v0, v1, [B

    .line 220
    .local v0, "payload":[B
    if-ltz p1, :cond_0

    const/16 v1, 0xa

    if-gt p1, v1, :cond_0

    .line 222
    int-to-byte v1, p1

    aput-byte v1, v0, v2

    .line 228
    int-to-byte v1, p2

    aput-byte v1, v0, v3

    .line 229
    aget-byte v1, v0, v3

    or-int/lit8 v1, v1, 0x8

    int-to-byte v1, v1

    aput-byte v1, v0, v3

    .line 231
    const/16 v1, 0x31

    invoke-direct {p0, v1, v2, v2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setControlCommandOut(III[B)I

    .line 233
    :goto_0
    return-void

    .line 225
    :cond_0
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "Channel not valid"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method


# virtual methods
.method public closeSPI()V
    .locals 2

    .prologue
    .line 182
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->killWorkingThread()V

    .line 183
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->killWriteThread()V

    .line 184
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 185
    return-void
.end method

.method public connectSPI()Z
    .locals 3

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->openCP2130()Z

    move-result v0

    .line 57
    .local v0, "ret":Z
    if-nez v0, :cond_0

    .line 58
    const/4 v1, 0x0

    .line 67
    :goto_0
    return v1

    .line 61
    :cond_0
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->restartWorkingThread()V

    .line 62
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->restartWriteThread()V

    .line 65
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setThreadsParams(Landroid/hardware/usb/UsbEndpoint;Landroid/hardware/usb/UsbEndpoint;)V

    .line 67
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public getClockDivider()I
    .locals 2

    .prologue
    .line 175
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->getSpiWord()[B

    move-result-object v0

    .line 176
    .local v0, "data":[B
    iget v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    aget-byte v1, v0, v1

    and-int/lit8 v1, v1, 0x7

    return v1
.end method

.method public getSelectedSlave()I
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    return v0
.end method

.method public readMISO(I)V
    .locals 3
    .param p1, "lengthBuffer"    # I

    .prologue
    const/4 v2, 0x0

    .line 129
    const/16 v1, 0x8

    new-array v0, v1, [B

    .line 130
    .local v0, "buffCommand":[B
    aput-byte v2, v0, v2

    .line 131
    const/4 v1, 0x1

    aput-byte v2, v0, v1

    .line 132
    const/4 v1, 0x2

    aput-byte v2, v0, v1

    .line 133
    const/4 v1, 0x3

    const/16 v2, -0x80

    aput-byte v2, v0, v1

    .line 134
    const/4 v1, 0x4

    and-int/lit16 v2, p1, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 135
    const/4 v1, 0x5

    shr-int/lit8 v2, p1, 0x8

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 136
    const/4 v1, 0x6

    shr-int/lit8 v2, p1, 0x10

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 137
    const/4 v1, 0x7

    shr-int/lit8 v2, p1, 0x18

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 139
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-virtual {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->putWriteBuffer([B)V

    .line 140
    return-void
.end method

.method public selectSlave(I)V
    .locals 2
    .param p1, "nSlave"    # I

    .prologue
    .line 163
    const/16 v0, 0xa

    if-gt p1, v0, :cond_0

    if-gez p1, :cond_1

    .line 165
    :cond_0
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->CLASS_ID:Ljava/lang/String;

    const-string v1, "selected slave must be in 0-10 range"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 170
    :goto_0
    return-void

    .line 169
    :cond_1
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setGpioChipSelect(IZ)V

    goto :goto_0
.end method

.method public setClock(I)V
    .locals 2
    .param p1, "clockDivider"    # I

    .prologue
    .line 97
    packed-switch p1, :pswitch_data_0

    .line 124
    :goto_0
    return-void

    .line 100
    :pswitch_0
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setSetSpiWord(II)V

    goto :goto_0

    .line 103
    :pswitch_1
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setSetSpiWord(II)V

    goto :goto_0

    .line 106
    :pswitch_2
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    const/4 v1, 0x2

    invoke-direct {p0, v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setSetSpiWord(II)V

    goto :goto_0

    .line 109
    :pswitch_3
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    const/4 v1, 0x3

    invoke-direct {p0, v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setSetSpiWord(II)V

    goto :goto_0

    .line 112
    :pswitch_4
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    const/4 v1, 0x4

    invoke-direct {p0, v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setSetSpiWord(II)V

    goto :goto_0

    .line 115
    :pswitch_5
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    const/4 v1, 0x5

    invoke-direct {p0, v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setSetSpiWord(II)V

    goto :goto_0

    .line 118
    :pswitch_6
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    const/4 v1, 0x6

    invoke-direct {p0, v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setSetSpiWord(II)V

    goto :goto_0

    .line 121
    :pswitch_7
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->currentChannel:I

    const/4 v1, 0x7

    invoke-direct {p0, v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->setSetSpiWord(II)V

    goto :goto_0

    .line 97
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public writeMOSI([B)V
    .locals 4
    .param p1, "buffer"    # [B

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 79
    array-length v1, p1

    add-int/lit8 v1, v1, 0x8

    new-array v0, v1, [B

    .line 80
    .local v0, "buffCommand":[B
    aput-byte v3, v0, v3

    .line 81
    aput-byte v3, v0, v2

    .line 82
    const/4 v1, 0x2

    aput-byte v2, v0, v1

    .line 83
    const/4 v1, 0x3

    const/16 v2, -0x80

    aput-byte v2, v0, v1

    .line 84
    const/4 v1, 0x4

    array-length v2, p1

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 85
    const/4 v1, 0x5

    array-length v2, p1

    shr-int/lit8 v2, v2, 0x8

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 86
    const/4 v1, 0x6

    array-length v2, p1

    shr-int/lit8 v2, v2, 0x10

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 87
    const/4 v1, 0x7

    array-length v2, p1

    shr-int/lit8 v2, v2, 0x18

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 89
    const/16 v1, 0x8

    array-length v2, p1

    invoke-static {p1, v3, v0, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 91
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-virtual {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->putWriteBuffer([B)V

    .line 92
    return-void
.end method

.method public writeRead([BI)V
    .locals 4
    .param p1, "buffer"    # [B
    .param p2, "lengthRead"    # I

    .prologue
    const/4 v2, 0x2

    const/4 v3, 0x0

    .line 145
    array-length v1, p1

    add-int/lit8 v1, v1, 0x8

    new-array v0, v1, [B

    .line 146
    .local v0, "buffCommand":[B
    aput-byte v3, v0, v3

    .line 147
    const/4 v1, 0x1

    aput-byte v3, v0, v1

    .line 148
    aput-byte v2, v0, v2

    .line 149
    const/4 v1, 0x3

    const/16 v2, -0x80

    aput-byte v2, v0, v1

    .line 150
    const/4 v1, 0x4

    and-int/lit16 v2, p2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 151
    const/4 v1, 0x5

    shr-int/lit8 v2, p2, 0x8

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 152
    const/4 v1, 0x6

    shr-int/lit8 v2, p2, 0x10

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 153
    const/4 v1, 0x7

    shr-int/lit8 v2, p2, 0x18

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 155
    const/16 v1, 0x8

    array-length v2, p1

    invoke-static {p1, v3, v0, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 157
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2130SpiDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-virtual {v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->putWriteBuffer([B)V

    .line 158
    return-void
.end method
