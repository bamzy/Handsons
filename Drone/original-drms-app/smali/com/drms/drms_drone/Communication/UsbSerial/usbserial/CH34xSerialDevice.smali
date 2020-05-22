.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;
.super Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
.source "CH34xSerialDevice.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;
    }
.end annotation


# static fields
.field private static final CH341_NBREAK_BITS_REG1:I = 0x1

.field private static final CH341_NBREAK_BITS_REG2:I = 0x40

.field private static final CH341_REG_BREAK1:I = 0x5

.field private static final CH341_REG_BREAK2:I = 0x18

.field private static final CH341_REQ_READ_REG:I = 0x95

.field private static final CH341_REQ_WRITE_REG:I = 0x9a

.field private static final CH34X_115200_1312:I = 0xcc83

.field private static final CH34X_1200_0f2c:I = 0x3b

.field private static final CH34X_1200_1312:I = 0xb281

.field private static final CH34X_19200_0f2c_rest:I = 0x7

.field private static final CH34X_19200_1312:I = 0xd982

.field private static final CH34X_230400_1312:I = 0xe683

.field private static final CH34X_2400_0f2c:I = 0x1e

.field private static final CH34X_2400_1312:I = 0xd981

.field private static final CH34X_300_0f2c:I = 0xeb

.field private static final CH34X_300_1312:I = 0xd980

.field private static final CH34X_38400_1312:I = 0x6483

.field private static final CH34X_460800_1312:I = 0xf383

.field private static final CH34X_4800_0f2c:I = 0xf

.field private static final CH34X_4800_1312:I = 0x6482

.field private static final CH34X_57600_1312:I = 0x9883

.field private static final CH34X_600_0f2c:I = 0x76

.field private static final CH34X_600_1312:I = 0x6481

.field private static final CH34X_921600_1312:I = 0xf387

.field private static final CH34X_9600_0f2c:I = 0x8

.field private static final CH34X_9600_1312:I = 0xb282

.field private static final CH34X_FLOW_CONTROL_DSR_DTR:I = 0x202

.field private static final CH34X_FLOW_CONTROL_NONE:I = 0x0

.field private static final CH34X_FLOW_CONTROL_RTS_CTS:I = 0x101

.field private static final CH34X_PARITY_EVEN:I = 0xdb

.field private static final CH34X_PARITY_MARK:I = 0xeb

.field private static final CH34X_PARITY_NONE:I = 0xc3

.field private static final CH34X_PARITY_ODD:I = 0xcb

.field private static final CH34X_PARITY_SPACE:I = 0xfb

.field private static final CLASS_ID:Ljava/lang/String;

.field private static final DEFAULT_BAUDRATE:I = 0x2580

.field private static final REQTYPE_HOST_FROM_DEVICE:I = 0xc0

.field private static final REQTYPE_HOST_TO_DEVICE:I = 0x40


# instance fields
.field private ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

.field private ctsState:Z

.field private dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

.field private dsrState:Z

.field private dtr:Z

.field private dtrDsrEnabled:Z

.field private flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;

.field private inEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private mInterface:Landroid/hardware/usb/UsbInterface;

.field private outEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private requestIN:Landroid/hardware/usb/UsbRequest;

.field private rts:Z

.field private rtsCtsEnabled:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V
    .locals 1
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    const/4 v0, 0x0

    .line 101
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V

    .line 93
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dtr:Z

    .line 94
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->rts:Z

    .line 95
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->ctsState:Z

    .line 96
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dsrState:Z

    .line 102
    return-void
.end method

.method public constructor <init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;I)V
    .locals 1
    .param p1, "device"    # Landroid/hardware/usb/UsbDevice;
    .param p2, "connection"    # Landroid/hardware/usb/UsbDeviceConnection;
    .param p3, "iface"    # I

    .prologue
    const/4 v0, 0x0

    .line 106
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;-><init>(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)V

    .line 93
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dtr:Z

    .line 94
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->rts:Z

    .line 95
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->ctsState:Z

    .line 96
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dsrState:Z

    .line 107
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->rtsCtsEnabled:Z

    .line 108
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dtrDsrEnabled:Z

    .line 109
    if-ltz p3, :cond_0

    .end local p3    # "iface":I
    :goto_0
    invoke-virtual {p1, p3}, Landroid/hardware/usb/UsbDevice;->getInterface(I)Landroid/hardware/usb/UsbInterface;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    .line 110
    return-void

    .restart local p3    # "iface":I
    :cond_0
    move p3, v0

    .line 109
    goto :goto_0
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->rtsCtsEnabled:Z

    return v0
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->ctsState:Z

    return v0
.end method

.method static synthetic access$102(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;
    .param p1, "x1"    # Z

    .prologue
    .line 19
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->ctsState:Z

    return p1
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    return-object v0
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dtrDsrEnabled:Z

    return v0
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dsrState:Z

    return v0
.end method

.method static synthetic access$402(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;
    .param p1, "x1"    # Z

    .prologue
    .line 19
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dsrState:Z

    return p1
.end method

.method static synthetic access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    return-object v0
.end method

.method static synthetic access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->checkCTS()Z

    move-result v0

    return v0
.end method

.method static synthetic access$700(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->checkDSR()Z

    move-result v0

    return v0
.end method

.method private checkCTS()Z
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v2, 0x0

    .line 507
    new-array v0, v5, [B

    .line 508
    .local v0, "buffer":[B
    const/16 v3, 0x95

    const/16 v4, 0x706

    invoke-direct {p0, v3, v4, v2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandIn(III[B)I

    move-result v1

    .line 510
    .local v1, "ret":I
    if-eq v1, v5, :cond_1

    .line 512
    sget-object v3, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Expected 2 bytes, but get "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 521
    :cond_0
    :goto_0
    return v2

    .line 516
    :cond_1
    aget-byte v3, v0, v2

    and-int/lit8 v3, v3, 0x1

    if-nez v3, :cond_0

    .line 518
    const/4 v2, 0x1

    goto :goto_0
.end method

.method private checkDSR()Z
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v2, 0x0

    .line 527
    new-array v0, v5, [B

    .line 528
    .local v0, "buffer":[B
    const/16 v3, 0x95

    const/16 v4, 0x706

    invoke-direct {p0, v3, v4, v2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandIn(III[B)I

    move-result v1

    .line 530
    .local v1, "ret":I
    if-eq v1, v5, :cond_1

    .line 532
    sget-object v3, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Expected 2 bytes, but get "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 541
    :cond_0
    :goto_0
    return v2

    .line 536
    :cond_1
    aget-byte v3, v0, v2

    and-int/lit8 v3, v3, 0x2

    if-nez v3, :cond_0

    .line 538
    const/4 v2, 0x1

    goto :goto_0
.end method

.method private checkState(Ljava/lang/String;II[I)I
    .locals 5
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "request"    # I
    .param p3, "value"    # I
    .param p4, "expected"    # [I

    .prologue
    const/4 v2, 0x0

    .line 492
    array-length v3, p4

    new-array v0, v3, [B

    .line 493
    .local v0, "buffer":[B
    invoke-direct {p0, p2, p3, v2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandIn(III[B)I

    move-result v1

    .line 495
    .local v1, "ret":I
    array-length v3, p4

    if-eq v1, v3, :cond_0

    .line 497
    sget-object v2, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Expected "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    array-length v4, p4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " bytes, but get "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 498
    const/4 v2, -0x1

    .line 501
    :cond_0
    return v2
.end method

.method private createFlowControlThread()V
    .locals 1

    .prologue
    .line 581
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;

    .line 582
    return-void
.end method

.method private init()I
    .locals 9

    .prologue
    const/4 v8, 0x2

    const/16 v7, 0x9a

    const/4 v1, 0x0

    const/4 v6, 0x0

    const/4 v0, -0x1

    .line 400
    const/16 v2, 0xa1

    const v3, 0xc29c

    const v4, 0xb2b9

    invoke-direct {p0, v2, v3, v4, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-gez v2, :cond_1

    .line 402
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "init failed! #1"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 454
    :cond_0
    :goto_0
    return v0

    .line 406
    :cond_1
    const/16 v2, 0xa4

    const/16 v3, 0xdf

    invoke-direct {p0, v2, v3, v1, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-gez v2, :cond_2

    .line 408
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "init failed! #2"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 412
    :cond_2
    const/16 v2, 0xa4

    const/16 v3, 0x9f

    invoke-direct {p0, v2, v3, v1, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-gez v2, :cond_3

    .line 414
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "init failed! #3"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 418
    :cond_3
    const-string v2, "init #4"

    const/16 v3, 0x95

    const/16 v4, 0x706

    new-array v5, v8, [I

    fill-array-data v5, :array_0

    invoke-direct {p0, v2, v3, v4, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->checkState(Ljava/lang/String;II[I)I

    move-result v2

    if-eq v2, v0, :cond_0

    .line 421
    const/16 v2, 0x2727

    invoke-direct {p0, v7, v2, v1, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-gez v2, :cond_4

    .line 423
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "init failed! #5"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 427
    :cond_4
    const/16 v2, 0x1312

    const v3, 0xb282

    invoke-direct {p0, v7, v2, v3, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-gez v2, :cond_5

    .line 429
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "init failed! #6"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 433
    :cond_5
    const/16 v2, 0xf2c

    const/16 v3, 0x8

    invoke-direct {p0, v7, v2, v3, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-gez v2, :cond_6

    .line 435
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "init failed! #7"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 439
    :cond_6
    const/16 v2, 0x2518

    const/16 v3, 0xc3

    invoke-direct {p0, v7, v2, v3, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-gez v2, :cond_7

    .line 441
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "init failed! #8"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 445
    :cond_7
    const-string v2, "init #9"

    const/16 v3, 0x95

    const/16 v4, 0x706

    new-array v5, v8, [I

    fill-array-data v5, :array_1

    invoke-direct {p0, v2, v3, v4, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->checkState(Ljava/lang/String;II[I)I

    move-result v2

    if-eq v2, v0, :cond_0

    .line 448
    const/16 v2, 0x2727

    invoke-direct {p0, v7, v2, v1, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-gez v2, :cond_8

    .line 450
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "init failed! #10"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    :cond_8
    move v0, v1

    .line 454
    goto/16 :goto_0

    .line 418
    nop

    :array_0
    .array-data 4
        0x9f
        0xee
    .end array-data

    .line 445
    :array_1
    .array-data 4
        0x9f
        0xee
    .end array-data
.end method

.method private openCH34X()Z
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 366
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5, v6, v3}, Landroid/hardware/usb/UsbDeviceConnection;->claimInterface(Landroid/hardware/usb/UsbInterface;Z)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 368
    sget-object v5, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v6, "Interface succesfully claimed"

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 376
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5}, Landroid/hardware/usb/UsbInterface;->getEndpointCount()I

    move-result v2

    .line 377
    .local v2, "numberEndpoints":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    add-int/lit8 v5, v2, -0x1

    if-gt v1, v5, :cond_4

    .line 379
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v5, v1}, Landroid/hardware/usb/UsbInterface;->getEndpoint(I)Landroid/hardware/usb/UsbEndpoint;

    move-result-object v0

    .line 380
    .local v0, "endpoint":Landroid/hardware/usb/UsbEndpoint;
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getType()I

    move-result v5

    if-ne v5, v7, :cond_3

    .line 381
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getDirection()I

    move-result v5

    const/16 v6, 0x80

    if-ne v5, v6, :cond_3

    .line 383
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 377
    :cond_0
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 371
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .end local v1    # "i":I
    .end local v2    # "numberEndpoints":I
    :cond_1
    sget-object v3, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v5, "Interface could not be claimed"

    invoke-static {v3, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v3, v4

    .line 391
    :cond_2
    :goto_2
    return v3

    .line 384
    .restart local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    .restart local v1    # "i":I
    .restart local v2    # "numberEndpoints":I
    :cond_3
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getType()I

    move-result v5

    if-ne v5, v7, :cond_0

    .line 385
    invoke-virtual {v0}, Landroid/hardware/usb/UsbEndpoint;->getDirection()I

    move-result v5

    if-nez v5, :cond_0

    .line 387
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    goto :goto_1

    .line 391
    .end local v0    # "endpoint":Landroid/hardware/usb/UsbEndpoint;
    :cond_4
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->init()I

    move-result v5

    if-eqz v5, :cond_2

    move v3, v4

    goto :goto_2
.end method

.method private setBaudRate(II)I
    .locals 8
    .param p1, "index1312"    # I
    .param p2, "index0f2c"    # I

    .prologue
    const/4 v1, 0x0

    const/4 v7, 0x0

    const/16 v6, 0x9a

    const/4 v0, -0x1

    .line 459
    const/16 v2, 0x1312

    invoke-direct {p0, v6, v2, p1, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-gez v2, :cond_1

    .line 467
    :cond_0
    :goto_0
    return v0

    .line 461
    :cond_1
    const/16 v2, 0xf2c

    invoke-direct {p0, v6, v2, p2, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-ltz v2, :cond_0

    .line 463
    const-string v2, "set_baud_rate"

    const/16 v3, 0x95

    const/16 v4, 0x706

    const/4 v5, 0x2

    new-array v5, v5, [I

    fill-array-data v5, :array_0

    invoke-direct {p0, v2, v3, v4, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->checkState(Ljava/lang/String;II[I)I

    move-result v2

    if-eq v2, v0, :cond_0

    .line 465
    const/16 v2, 0x2727

    invoke-direct {p0, v6, v2, v1, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-ltz v2, :cond_0

    move v0, v1

    .line 467
    goto :goto_0

    .line 463
    :array_0
    .array-data 4
        0x9f
        0xee
    .end array-data
.end method

.method private setCh340xFlow(I)I
    .locals 5
    .param p1, "flowControl"    # I

    .prologue
    const/4 v0, -0x1

    .line 483
    const-string v1, "set_flow_control"

    const/16 v2, 0x95

    const/16 v3, 0x706

    const/4 v4, 0x2

    new-array v4, v4, [I

    fill-array-data v4, :array_0

    invoke-direct {p0, v1, v2, v3, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->checkState(Ljava/lang/String;II[I)I

    move-result v1

    if-ne v1, v0, :cond_1

    .line 487
    :cond_0
    :goto_0
    return v0

    .line 485
    :cond_1
    const/16 v1, 0x9a

    const/16 v2, 0x2727

    const/4 v3, 0x0

    invoke-direct {p0, v1, v2, p1, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v1

    if-eq v1, v0, :cond_0

    .line 487
    const/4 v0, 0x0

    goto :goto_0

    .line 483
    nop

    :array_0
    .array-data 4
        0x9f
        0xee
    .end array-data
.end method

.method private setCh340xParity(I)I
    .locals 8
    .param p1, "indexParity"    # I

    .prologue
    const/4 v7, 0x0

    const/16 v6, 0x9a

    const/4 v1, 0x0

    const/4 v0, -0x1

    .line 472
    const/16 v2, 0x2518

    invoke-direct {p0, v6, v2, p1, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-gez v2, :cond_1

    .line 478
    :cond_0
    :goto_0
    return v0

    .line 474
    :cond_1
    const-string v2, "set_parity"

    const/16 v3, 0x95

    const/16 v4, 0x706

    const/4 v5, 0x2

    new-array v5, v5, [I

    fill-array-data v5, :array_0

    invoke-direct {p0, v2, v3, v4, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->checkState(Ljava/lang/String;II[I)I

    move-result v2

    if-eq v2, v0, :cond_0

    .line 476
    const/16 v2, 0x2727

    invoke-direct {p0, v6, v2, v1, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v2

    if-ltz v2, :cond_0

    move v0, v1

    .line 478
    goto :goto_0

    .line 474
    :array_0
    .array-data 4
        0x9f
        0xee
    .end array-data
.end method

.method private setControlCommandIn(III[B)I
    .locals 9
    .param p1, "request"    # I
    .param p2, "value"    # I
    .param p3, "index"    # I
    .param p4, "data"    # [B

    .prologue
    .line 569
    const/4 v6, 0x0

    .line 570
    .local v6, "dataLength":I
    if-eqz p4, :cond_0

    .line 572
    array-length v6, p4

    .line 574
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0xc0

    const/16 v7, 0x1388

    move v2, p1

    move v3, p2

    move v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 575
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 576
    return v8
.end method

.method private setControlCommandOut(III[B)I
    .locals 9
    .param p1, "request"    # I
    .param p2, "value"    # I
    .param p3, "index"    # I
    .param p4, "data"    # [B

    .prologue
    .line 557
    const/4 v6, 0x0

    .line 558
    .local v6, "dataLength":I
    if-eqz p4, :cond_0

    .line 560
    array-length v6, p4

    .line 562
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    const/16 v1, 0x40

    const/16 v7, 0x1388

    move v2, p1

    move v3, p2

    move v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v7}, Landroid/hardware/usb/UsbDeviceConnection;->controlTransfer(IIII[BII)I

    move-result v8

    .line 563
    .local v8, "response":I
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

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

    .line 564
    return v8
.end method

.method private startFlowControlThread()V
    .locals 1

    .prologue
    .line 586
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->isAlive()Z

    move-result v0

    if-nez v0, :cond_0

    .line 587
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->start()V

    .line 588
    :cond_0
    return-void
.end method

.method private stopFlowControlThread()V
    .locals 1

    .prologue
    .line 592
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;

    if-eqz v0, :cond_0

    .line 594
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->stopThread()V

    .line 595
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->flowControlThread:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;

    .line 597
    :cond_0
    return-void
.end method

.method private writeHandshakeByte()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 547
    const/16 v3, 0xa4

    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dtr:Z

    if-eqz v0, :cond_1

    const/16 v0, 0x20

    :goto_0
    iget-boolean v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->rts:Z

    if-eqz v2, :cond_2

    const/16 v2, 0x40

    :goto_1
    or-int/2addr v0, v2

    xor-int/lit8 v0, v0, -0x1

    const/4 v2, 0x0

    invoke-direct {p0, v3, v0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setControlCommandOut(III[B)I

    move-result v0

    if-gez v0, :cond_0

    .line 549
    sget-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v1, "Failed to set handshake byte"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 550
    const/4 v1, -0x1

    .line 552
    :cond_0
    return v1

    :cond_1
    move v0, v1

    .line 547
    goto :goto_0

    :cond_2
    move v2, v1

    goto :goto_1
.end method


# virtual methods
.method public close()V
    .locals 2

    .prologue
    .line 144
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->killWorkingThread()V

    .line 145
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->killWriteThread()V

    .line 146
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->stopFlowControlThread()V

    .line 147
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 148
    return-void
.end method

.method public getBreak(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;)V
    .locals 0
    .param p1, "breakCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    .prologue
    .line 344
    return-void
.end method

.method public getCTS(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;)V
    .locals 0
    .param p1, "ctsCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    .prologue
    .line 331
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    .line 332
    return-void
.end method

.method public getDSR(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;)V
    .locals 0
    .param p1, "dsrCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    .prologue
    .line 337
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    .line 338
    return-void
.end method

.method public getFrame(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;)V
    .locals 0
    .param p1, "frameCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    .prologue
    .line 350
    return-void
.end method

.method public getOverrun(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;)V
    .locals 0
    .param p1, "overrunCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    .prologue
    .line 356
    return-void
.end method

.method public getParity(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;)V
    .locals 0
    .param p1, "parityCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    .prologue
    .line 362
    return-void
.end method

.method public open()Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    .line 115
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->openCH34X()Z

    move-result v0

    .line 116
    .local v0, "ret":Z
    if-eqz v0, :cond_0

    .line 119
    new-instance v2, Landroid/hardware/usb/UsbRequest;

    invoke-direct {v2}, Landroid/hardware/usb/UsbRequest;-><init>()V

    iput-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    .line 120
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {v2, v3, v4}, Landroid/hardware/usb/UsbRequest;->initialize(Landroid/hardware/usb/UsbDeviceConnection;Landroid/hardware/usb/UsbEndpoint;)Z

    .line 123
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->restartWorkingThread()V

    .line 124
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->restartWriteThread()V

    .line 127
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->createFlowControlThread()V

    .line 130
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->requestIN:Landroid/hardware/usb/UsbRequest;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setThreadsParams(Landroid/hardware/usb/UsbRequest;Landroid/hardware/usb/UsbEndpoint;)V

    .line 132
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->asyncMode:Z

    .line 137
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
    const/16 v5, 0x4b0

    const/16 v4, 0x258

    const/16 v1, 0x12c

    const/4 v2, 0x7

    const/4 v3, -0x1

    .line 177
    if-gt p1, v1, :cond_1

    .line 179
    const v1, 0xd980

    const/16 v2, 0xeb

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 180
    .local v0, "ret":I
    if-ne v0, v3, :cond_0

    .line 181
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 244
    .end local v0    # "ret":I
    :cond_0
    :goto_0
    return-void

    .line 182
    :cond_1
    if-le p1, v1, :cond_2

    if-gt p1, v4, :cond_2

    .line 184
    const/16 v1, 0x6481

    const/16 v2, 0x76

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 185
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 186
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 188
    .end local v0    # "ret":I
    :cond_2
    if-le p1, v4, :cond_3

    if-gt p1, v5, :cond_3

    .line 190
    const v1, 0xb281

    const/16 v2, 0x3b

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 191
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 192
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 193
    .end local v0    # "ret":I
    :cond_3
    if-le p1, v5, :cond_4

    const/16 v1, 0x960

    if-gt p1, v1, :cond_4

    .line 195
    const v1, 0xd981

    const/16 v2, 0x1e

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 196
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 197
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 198
    .end local v0    # "ret":I
    :cond_4
    const/16 v1, 0x960

    if-le p1, v1, :cond_5

    const/16 v1, 0x12c0

    if-gt p1, v1, :cond_5

    .line 200
    const/16 v1, 0x6482

    const/16 v2, 0xf

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 201
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 202
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 203
    .end local v0    # "ret":I
    :cond_5
    const/16 v1, 0x12c0

    if-le p1, v1, :cond_6

    const/16 v1, 0x2580

    if-gt p1, v1, :cond_6

    .line 205
    const v1, 0xb282

    const/16 v2, 0x8

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 206
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 207
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 208
    .end local v0    # "ret":I
    :cond_6
    const/16 v1, 0x2580

    if-le p1, v1, :cond_7

    const/16 v1, 0x4b00

    if-gt p1, v1, :cond_7

    .line 210
    const v1, 0xd982

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 211
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 212
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 213
    .end local v0    # "ret":I
    :cond_7
    const/16 v1, 0x4b00

    if-le p1, v1, :cond_8

    const v1, 0x9600

    if-gt p1, v1, :cond_8

    .line 215
    const/16 v1, 0x6483

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 216
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 217
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 218
    .end local v0    # "ret":I
    :cond_8
    const v1, 0x9600

    if-le p1, v1, :cond_9

    const v1, 0xe100

    if-gt p1, v1, :cond_9

    .line 220
    const v1, 0x9883

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 221
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 222
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 223
    .end local v0    # "ret":I
    :cond_9
    const v1, 0xe100

    if-le p1, v1, :cond_a

    const v1, 0x1c200

    if-gt p1, v1, :cond_a

    .line 225
    const v1, 0xcc83

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 226
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 227
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 228
    .end local v0    # "ret":I
    :cond_a
    const v1, 0x1c200

    if-le p1, v1, :cond_b

    const v1, 0x38400

    if-gt p1, v1, :cond_b

    .line 230
    const v1, 0xe683

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 231
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 232
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 233
    .end local v0    # "ret":I
    :cond_b
    const v1, 0x38400

    if-le p1, v1, :cond_c

    const v1, 0x70800

    if-gt p1, v1, :cond_c

    .line 235
    const v1, 0xf383

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 236
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 237
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 238
    .end local v0    # "ret":I
    :cond_c
    const v1, 0x70800

    if-le p1, v1, :cond_0

    const v1, 0xe1000

    if-gt p1, v1, :cond_0

    .line 240
    const v1, 0xf387

    invoke-direct {p0, v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setBaudRate(II)I

    move-result v0

    .line 241
    .restart local v0    # "ret":I
    if-ne v0, v3, :cond_0

    .line 242
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->CLASS_ID:Ljava/lang/String;

    const-string v2, "SetBaudRate failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0
.end method

.method public setDTR(Z)V
    .locals 0
    .param p1, "state"    # Z

    .prologue
    .line 324
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dtr:Z

    .line 325
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->writeHandshakeByte()I

    .line 326
    return-void
.end method

.method public setDataBits(I)V
    .locals 0
    .param p1, "dataBits"    # I

    .prologue
    .line 251
    return-void
.end method

.method public setFlowControl(I)V
    .locals 2
    .param p1, "flowControl"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 288
    packed-switch p1, :pswitch_data_0

    .line 312
    :goto_0
    return-void

    .line 291
    :pswitch_0
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->rtsCtsEnabled:Z

    .line 292
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dtrDsrEnabled:Z

    .line 293
    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setCh340xFlow(I)I

    goto :goto_0

    .line 296
    :pswitch_1
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->rtsCtsEnabled:Z

    .line 297
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dtrDsrEnabled:Z

    .line 298
    const/16 v0, 0x101

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setCh340xFlow(I)I

    .line 299
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->checkCTS()Z

    move-result v0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->ctsState:Z

    .line 300
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->startFlowControlThread()V

    goto :goto_0

    .line 303
    :pswitch_2
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->rtsCtsEnabled:Z

    .line 304
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dtrDsrEnabled:Z

    .line 305
    const/16 v0, 0x202

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setCh340xFlow(I)I

    .line 306
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->checkDSR()Z

    move-result v0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->dsrState:Z

    .line 307
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->startFlowControlThread()V

    goto :goto_0

    .line 288
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public setParity(I)V
    .locals 1
    .param p1, "parity"    # I

    .prologue
    .line 263
    packed-switch p1, :pswitch_data_0

    .line 283
    :goto_0
    return-void

    .line 266
    :pswitch_0
    const/16 v0, 0xc3

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setCh340xParity(I)I

    goto :goto_0

    .line 269
    :pswitch_1
    const/16 v0, 0xcb

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setCh340xParity(I)I

    goto :goto_0

    .line 272
    :pswitch_2
    const/16 v0, 0xdb

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setCh340xParity(I)I

    goto :goto_0

    .line 275
    :pswitch_3
    const/16 v0, 0xeb

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setCh340xParity(I)I

    goto :goto_0

    .line 278
    :pswitch_4
    const/16 v0, 0xfb

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setCh340xParity(I)I

    goto :goto_0

    .line 263
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
    .line 317
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->rts:Z

    .line 318
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->writeHandshakeByte()I

    .line 319
    return-void
.end method

.method public setStopBits(I)V
    .locals 0
    .param p1, "stopBits"    # I

    .prologue
    .line 258
    return-void
.end method

.method public syncClose()V
    .locals 2

    .prologue
    .line 170
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->stopFlowControlThread()V

    .line 171
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->mInterface:Landroid/hardware/usb/UsbInterface;

    invoke-virtual {v0, v1}, Landroid/hardware/usb/UsbDeviceConnection;->releaseInterface(Landroid/hardware/usb/UsbInterface;)Z

    .line 172
    return-void
.end method

.method public syncOpen()Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 153
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->openCH34X()Z

    move-result v0

    .line 154
    .local v0, "ret":Z
    if-eqz v0, :cond_0

    .line 157
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->createFlowControlThread()V

    .line 158
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    invoke-virtual {p0, v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->setSyncParams(Landroid/hardware/usb/UsbEndpoint;Landroid/hardware/usb/UsbEndpoint;)V

    .line 159
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->asyncMode:Z

    .line 160
    const/4 v1, 0x1

    .line 163
    :cond_0
    return v1
.end method
