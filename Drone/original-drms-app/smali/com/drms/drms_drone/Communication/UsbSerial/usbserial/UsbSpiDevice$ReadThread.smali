.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;
.super Ljava/lang/Thread;
.source "UsbSpiDevice.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "ReadThread"
.end annotation


# instance fields
.field private inEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field private misoCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;

.field final synthetic this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;

.field private working:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;)V
    .locals 2
    .param p1, "this$0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 126
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->working:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 127
    return-void
.end method

.method private onReceivedData([B)V
    .locals 1
    .param p1, "data"    # [B

    .prologue
    .line 169
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->misoCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;

    if-eqz v0, :cond_0

    .line 170
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->misoCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;

    invoke-interface {v0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;->onReceivedData([B)I

    .line 171
    :cond_0
    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 137
    const/4 v0, 0x0

    .line 139
    .local v0, "dataReceived":[B
    :cond_0
    :goto_0
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->working:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 142
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    if-eqz v2, :cond_1

    .line 143
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;

    iget-object v2, v2, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;

    iget-object v4, v4, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->getBufferCompatible()[B

    move-result-object v4

    const/16 v5, 0x4000

    const/4 v6, 0x0

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/hardware/usb/UsbDeviceConnection;->bulkTransfer(Landroid/hardware/usb/UsbEndpoint;[BII)I

    move-result v1

    .line 148
    .local v1, "numberBytes":I
    :goto_1
    if-lez v1, :cond_0

    .line 150
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;

    iget-object v2, v2, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-virtual {v2, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->getDataReceivedCompatible(I)[B

    move-result-object v0

    .line 151
    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->onReceivedData([B)V

    goto :goto_0

    .line 146
    .end local v1    # "numberBytes":I
    :cond_1
    const/4 v1, 0x0

    .restart local v1    # "numberBytes":I
    goto :goto_1

    .line 155
    .end local v1    # "numberBytes":I
    :cond_2
    return-void
.end method

.method public setCallback(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;)V
    .locals 0
    .param p1, "misoCallback"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;

    .prologue
    .line 131
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->misoCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;

    .line 132
    return-void
.end method

.method public setUsbEndpoint(Landroid/hardware/usb/UsbEndpoint;)V
    .locals 0
    .param p1, "inEndpoint"    # Landroid/hardware/usb/UsbEndpoint;

    .prologue
    .line 159
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->inEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 160
    return-void
.end method

.method public stopReadThread()V
    .locals 2

    .prologue
    .line 164
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiDevice$ReadThread;->working:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 165
    return-void
.end method
