.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;
.super Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
.source "PL2303SerialDevice.java"


# static fields
.field private static final CLASS_ID:Ljava/lang/String;

.field private static final PL2303_REQTYPE_DEVICE2HOST_VENDOR:I = 0xc0

.field private static final PL2303_REQTYPE_HOST2DEVICE:I = 0x21

.field private static final PL2303_REQTYPE_HOST2DEVICE_VENDOR:I = 0x40

.field private static final PL2303_SET_CONTROL_REQUEST:I = 0x22

.field private static final PL2303_SET_LINE_CODING:I = 0x20

.field private static final PL2303_VENDOR_WRITE_REQUEST:I = 0x1


# instance fields
.field private defaultSetLine:[B

.field private inEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private mInterface:Landroid/hardware/usb/UsbInterface;

.field private outEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private requestIN:Landroid/hardware/usb/UsbRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->CLASS_ID:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V
    .locals 1
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    .line 42
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V

    .line 43
    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V
    .locals 2
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;
    .param p3, "iface"    # I

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V

    .line 23
    const/4 v0, 0x7

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    .line 49
    const/4 v0, 0x1

    if-le p3, v0, :cond_0

    .line 51
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Multi-interface PL2303 devices not supported!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 54
    :cond_0
    if-ltz p3, :cond_1

    .end local p3    # "iface":I
    :goto_0
    invoke-virtual {p1, p3}, Landroid/hardware/usb/UsbDevice;->getInterface(I)Landroid/hardware/usb/UsbInterface;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    .line 55
    return-void

    .line 54
    .restart local p3    # "iface":I
    :cond_1
    const/4 p3, 0x0

    goto :goto_0

    .line 23
    nop

    :array_0
    .array-data 1
        -0x80t
        0x25t
        0x0t
        0x0t
        0x0t
        0x0t
        0x8t
    .end array-data
.end method

.method private openPL2303()Z
    .locals 15

    .prologue
    .line 305
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/hardware/usb/UsbDeviceConnection;->claimInterface(Landroid/hardware/usb/UsbInterface;Z)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 307
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v1, "Interface succesfully claimed"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 315
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0}, Landroid/hardware/usb/UsbInterface;->getEndpointCount()I

    move-result v14

    .line 316
    .local v14, "numberEndpoints":I
    const/4 v13, 0x0

    .local v13, "i":I
    :goto_0
    add-int/lit8 v0, v14, -0x1

    if-gt v13, v0, :cond_3

    .line 318
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v13}, Landroid/hardware/usb/UsbInterface;->getEndpoint(I)Landroid/hardware/usb/UsbEndpoint;

    move-result-object v12

    .line 319
    .local v12, "endpoint":Landroid/hardware/usb/UsbEndpoint;
    invoke-virtual {v12}, Landroid/hardware/usb/UsbEndpoint;->getType()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 320
    invoke-virtual {v12}, Landroid/hardware/usb/UsbEndpoint;->getDirection()I

    move-result v0

    const/16 v1, 0x80

    if-ne v0, v1, :cond_2

    .line 321
    iput-object v12, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 316
    :cond_0
    :goto_1
    add-int/lit8 v13, v13, 0x1

    goto :goto_0

    .line 310
    .end local v12    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .end local v13    # "i":I
    .end local v14    # "numberEndpoints":I
    :cond_1
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v1, "Interface could not be claimed"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 311
    const/4 v0, 0x0

    .line 360
    :goto_2
    return v0

    .line 322
    .restart local v12    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .restart local v13    # "i":I
    .restart local v14    # "numberEndpoints":I
    :cond_2
    invoke-virtual {v12}, Landroid/hardware/usb/UsbEndpoint;->getType()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 323
    invoke-virtual {v12}, Landroid/hardware/usb/UsbEndpoint;->getDirection()I

    move-result v0

    if-nez v0, :cond_0

    .line 324
    iput-object v12, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    goto :goto_1

    .line 328
    .end local v12    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    :cond_3
    const/4 v0, 0x1

    new-array v5, v0, [B

    .line 330
    .local v5, "buf":[B
    const/16 v1, 0xc0

    const/4 v2, 0x1

    const v3, 0x8484

    const/4 v4, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_4

    .line 331
    const/4 v0, 0x0

    goto :goto_2

    .line 332
    :cond_4
    const/16 v7, 0x40

    const/4 v8, 0x1

    const/16 v9, 0x404

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object v6, p0

    invoke-direct/range {v6 .. v11}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_5

    .line 333
    const/4 v0, 0x0

    goto :goto_2

    .line 334
    :cond_5
    const/16 v1, 0xc0

    const/4 v2, 0x1

    const v3, 0x8484

    const/4 v4, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_6

    .line 335
    const/4 v0, 0x0

    goto :goto_2

    .line 336
    :cond_6
    const/16 v1, 0xc0

    const/4 v2, 0x1

    const v3, 0x8383

    const/4 v4, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_7

    .line 337
    const/4 v0, 0x0

    goto :goto_2

    .line 338
    :cond_7
    const/16 v1, 0xc0

    const/4 v2, 0x1

    const v3, 0x8484

    const/4 v4, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_8

    .line 339
    const/4 v0, 0x0

    goto :goto_2

    .line 340
    :cond_8
    const/16 v7, 0x40

    const/4 v8, 0x1

    const/16 v9, 0x404

    const/4 v10, 0x1

    const/4 v11, 0x0

    move-object v6, p0

    invoke-direct/range {v6 .. v11}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_9

    .line 341
    const/4 v0, 0x0

    goto :goto_2

    .line 342
    :cond_9
    const/16 v1, 0xc0

    const/4 v2, 0x1

    const v3, 0x8484

    const/4 v4, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_a

    .line 343
    const/4 v0, 0x0

    goto/16 :goto_2

    .line 344
    :cond_a
    const/16 v1, 0xc0

    const/4 v2, 0x1

    const v3, 0x8383

    const/4 v4, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_b

    .line 345
    const/4 v0, 0x0

    goto/16 :goto_2

    .line 346
    :cond_b
    const/16 v7, 0x40

    const/4 v8, 0x1

    const/4 v9, 0x0

    const/4 v10, 0x1

    const/4 v11, 0x0

    move-object v6, p0

    invoke-direct/range {v6 .. v11}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_c

    .line 347
    const/4 v0, 0x0

    goto/16 :goto_2

    .line 348
    :cond_c
    const/16 v7, 0x40

    const/4 v8, 0x1

    const/4 v9, 0x1

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object v6, p0

    invoke-direct/range {v6 .. v11}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_d

    .line 349
    const/4 v0, 0x0

    goto/16 :goto_2

    .line 350
    :cond_d
    const/16 v7, 0x40

    const/4 v8, 0x1

    const/4 v9, 0x2

    const/16 v10, 0x44

    const/4 v11, 0x0

    move-object v6, p0

    invoke-direct/range {v6 .. v11}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_e

    .line 351
    const/4 v0, 0x0

    goto/16 :goto_2

    .line 353
    :cond_e
    const/16 v7, 0x21

    const/16 v8, 0x22

    const/4 v9, 0x3

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object v6, p0

    invoke-direct/range {v6 .. v11}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_f

    .line 354
    const/4 v0, 0x0

    goto/16 :goto_2

    .line 355
    :cond_f
    const/16 v7, 0x21

    const/16 v8, 0x20

    const/4 v9, 0x0

    const/4 v10, 0x0

    iget-object v11, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v6, p0

    invoke-direct/range {v6 .. v11}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_10

    .line 356
    const/4 v0, 0x0

    goto/16 :goto_2

    .line 357
    :cond_10
    const/16 v7, 0x40

    const/4 v8, 0x1

    const/16 v9, 0x505

    const/16 v10, 0x1311

    const/4 v11, 0x0

    move-object v6, p0

    invoke-direct/range {v6 .. v11}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    move-result v0

    if-gez v0, :cond_11

    .line 358
    const/4 v0, 0x0

    goto/16 :goto_2

    .line 360
    :cond_11
    const/4 v0, 0x1

    goto/16 :goto_2
.end method

.method private setControlCommand(IIII[B)I
    .locals 9
    .param p1, "reqType"    # I
    .param p2, "request"    # I
    .param p3, "value"    # I
    .param p4, "index"    # I
    .param p5, "data"    # [B

    .prologue
    .line 365
    const/4 v6, 0x0

    .line 366
    .local v6, "dataLength":I
    if-eqz p5, :cond_0

    .line 367
    array-length v6, p5

    .line 368
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v7, 0x1388

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 369
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 370
    return v8
.end method


# virtual methods
.method public close()V
    .locals 2

    .prologue
    .line 87
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->killWorkingThread()V

    .line 88
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->killWriteThread()V

    .line 89
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 90
    return-void
.end method

.method public getBreak(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;)V
    .locals 0
    .param p1, "breakCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    .prologue
    .line 283
    return-void
.end method

.method public getCTS(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;)V
    .locals 0
    .param p1, "ctsCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    .prologue
    .line 271
    return-void
.end method

.method public getDSR(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;)V
    .locals 0
    .param p1, "dsrCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    .prologue
    .line 277
    return-void
.end method

.method public getFrame(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;)V
    .locals 0
    .param p1, "frameCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    .prologue
    .line 289
    return-void
.end method

.method public getOverrun(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;)V
    .locals 0
    .param p1, "overrunCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    .prologue
    .line 295
    return-void
.end method

.method public getParity(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;)V
    .locals 0
    .param p1, "parityCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    .prologue
    .line 301
    return-void
.end method

.method public open()Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    .line 60
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->openPL2303()Z

    move-result v0

    .line 62
    .local v0, "ret":Z
    if-eqz v0, :cond_0

    .line 65
    new-instance v2, Landroid/hardware/usb/UsbRequest;

    invoke-direct {v2}, Landroid/hardware/usb/UsbRequest;-><init>()V

    iput-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    .line 66
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {v2, v3, v4}, Landroid/hardware/usb/UsbRequest;->initialize(Landroid/hardware/usb/UsbDeviceConnection;Landroid/hardware/usb/UsbEndpoint;)Z

    .line 69
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->restartWorkingThread()V

    .line 70
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->restartWriteThread()V

    .line 73
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setThreadsParams(Landroid/hardware/usb/UsbRequest;Landroid/hardware/usb/UsbEndpoint;)V

    .line 75
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->asyncMode:Z

    .line 80
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setBaudRate(I)V
    .locals 7
    .param p1, "baudRate"    # I

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 116
    const/4 v0, 0x4

    new-array v6, v0, [B

    .line 117
    .local v6, "tempBuffer":[B
    and-int/lit16 v0, p1, 0xff

    int-to-byte v0, v0

    aput-byte v0, v6, v3

    .line 118
    shr-int/lit8 v0, p1, 0x8

    and-int/lit16 v0, v0, 0xff

    int-to-byte v0, v0

    aput-byte v0, v6, v2

    .line 119
    shr-int/lit8 v0, p1, 0x10

    and-int/lit16 v0, v0, 0xff

    int-to-byte v0, v0

    aput-byte v0, v6, v4

    .line 120
    shr-int/lit8 v0, p1, 0x18

    and-int/lit16 v0, v0, 0xff

    int-to-byte v0, v0

    aput-byte v0, v6, v5

    .line 121
    aget-byte v0, v6, v3

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v1, v1, v3

    if-ne v0, v1, :cond_0

    aget-byte v0, v6, v2

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v1, v1, v2

    if-ne v0, v1, :cond_0

    aget-byte v0, v6, v4

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v1, v1, v4

    if-ne v0, v1, :cond_0

    aget-byte v0, v6, v5

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v1, v1, v5

    if-eq v0, v1, :cond_1

    .line 124
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v1, v6, v3

    aput-byte v1, v0, v3

    .line 125
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v1, v6, v2

    aput-byte v1, v0, v2

    .line 126
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v1, v6, v4

    aput-byte v1, v0, v4

    .line 127
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v1, v6, v5

    aput-byte v1, v0, v5

    .line 128
    const/16 v1, 0x21

    const/16 v2, 0x20

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    .line 130
    :cond_1
    return-void
.end method

.method public setDTR(Z)V
    .locals 0
    .param p1, "state"    # Z

    .prologue
    .line 265
    return-void
.end method

.method public setDataBits(I)V
    .locals 6
    .param p1, "dataBits"    # I

    .prologue
    const/4 v4, 0x5

    const/16 v1, 0x21

    const/16 v2, 0x20

    const/4 v3, 0x0

    const/4 v5, 0x6

    .line 135
    packed-switch p1, :pswitch_data_0

    .line 169
    :cond_0
    :goto_0
    return-void

    .line 138
    :pswitch_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    if-eq v0, v4, :cond_0

    .line 140
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aput-byte v4, v0, v5

    .line 141
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 145
    :pswitch_1
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    if-eq v0, v5, :cond_0

    .line 147
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aput-byte v5, v0, v5

    .line 148
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 152
    :pswitch_2
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    const/4 v4, 0x7

    if-eq v0, v4, :cond_0

    .line 154
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    const/4 v4, 0x7

    aput-byte v4, v0, v5

    .line 155
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 159
    :pswitch_3
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    const/16 v4, 0x8

    if-eq v0, v4, :cond_0

    .line 161
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    const/16 v4, 0x8

    aput-byte v4, v0, v5

    .line 162
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 135
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
    .line 253
    return-void
.end method

.method public setParity(I)V
    .locals 6
    .param p1, "parity"    # I

    .prologue
    const/4 v4, 0x1

    const/16 v1, 0x21

    const/16 v2, 0x20

    const/4 v5, 0x5

    const/4 v3, 0x0

    .line 205
    packed-switch p1, :pswitch_data_0

    .line 246
    :cond_0
    :goto_0
    return-void

    .line 208
    :pswitch_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    if-eqz v0, :cond_0

    .line 210
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aput-byte v3, v0, v5

    .line 211
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 215
    :pswitch_1
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    if-eq v0, v4, :cond_0

    .line 217
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aput-byte v4, v0, v5

    .line 218
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 222
    :pswitch_2
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    const/4 v4, 0x2

    if-eq v0, v4, :cond_0

    .line 224
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    const/4 v4, 0x2

    aput-byte v4, v0, v5

    .line 225
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 229
    :pswitch_3
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    const/4 v4, 0x3

    if-eq v0, v4, :cond_0

    .line 231
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    const/4 v4, 0x3

    aput-byte v4, v0, v5

    .line 232
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 236
    :pswitch_4
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    const/4 v4, 0x4

    if-eq v0, v4, :cond_0

    .line 238
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    const/4 v4, 0x4

    aput-byte v4, v0, v5

    .line 239
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 205
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
    .line 259
    return-void
.end method

.method public setStopBits(I)V
    .locals 6
    .param p1, "stopBits"    # I

    .prologue
    const/4 v4, 0x1

    const/16 v1, 0x21

    const/16 v2, 0x20

    const/4 v5, 0x4

    const/4 v3, 0x0

    .line 174
    packed-switch p1, :pswitch_data_0

    .line 200
    :cond_0
    :goto_0
    return-void

    .line 177
    :pswitch_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    if-eqz v0, :cond_0

    .line 179
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aput-byte v3, v0, v5

    .line 180
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 184
    :pswitch_1
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    if-eq v0, v4, :cond_0

    .line 186
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aput-byte v4, v0, v5

    .line 187
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 191
    :pswitch_2
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    aget-byte v0, v0, v5

    const/4 v4, 0x2

    if-eq v0, v4, :cond_0

    .line 193
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    const/4 v4, 0x2

    aput-byte v4, v0, v5

    .line 194
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->defaultSetLine:[B

    move-object v0, p0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setControlCommand(IIII[B)I

    goto :goto_0

    .line 174
    nop

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
    .line 110
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 111
    return-void
.end method

.method public syncOpen()Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 95
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->openPL2303()Z

    move-result v0

    .line 96
    .local v0, "ret":Z
    if-eqz v0, :cond_0

    .line 98
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->setSyncParams(Landroid/hardware/usb/UsbEndpoint;Landroid/hardware/usb/UsbEndpoint;)V

    .line 99
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/PL2303SerialDevice;->asyncMode:Z

    .line 100
    const/4 v1, 0x1

    .line 103
    :cond_0
    return v1
.end method
