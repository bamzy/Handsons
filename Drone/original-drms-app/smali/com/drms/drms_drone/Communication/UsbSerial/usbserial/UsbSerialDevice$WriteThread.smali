.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;
.super Ljava/lang/Thread;
.source "UsbSerialDevice.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "WriteThread"
.end annotation


# instance fields
.field private outEndpoint:Landroid/hardware/usb/UsbEndpoint;

.field final synthetic this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

.field private working:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;)V
    .locals 2
    .param p1, "this$0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    .prologue
    .line 296
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 297
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->working:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 298
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 303
    :goto_0
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->working:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 305
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    iget-object v1, v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->serialBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->getWriteBuffer()[B

    move-result-object v0

    .line 306
    .local v0, "data":[B
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    iget-object v1, v1, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    array-length v3, v0

    const/16 v4, 0x1388

    invoke-virtual {v1, v2, v0, v3, v4}, Landroid/hardware/usb/UsbDeviceConnection;->bulkTransfer(Landroid/hardware/usb/UsbEndpoint;[BII)I

    goto :goto_0

    .line 308
    .end local v0    # "data":[B
    :cond_0
    return-void
.end method

.method public setUsbEndpoint(Landroid/hardware/usb/UsbEndpoint;)V
    .locals 0
    .param p1, "outEndpoint"    # Landroid/hardware/usb/UsbEndpoint;

    .prologue
    .line 312
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->outEndpoint:Landroid/hardware/usb/UsbEndpoint;

    .line 313
    return-void
.end method

.method public stopWriteThread()V
    .locals 2

    .prologue
    .line 317
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice$WriteThread;->working:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 318
    return-void
.end method
