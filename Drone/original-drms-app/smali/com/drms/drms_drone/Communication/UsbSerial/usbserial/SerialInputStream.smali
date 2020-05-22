.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialInputStream;
.super Ljava/io/InputStream;
.source "SerialInputStream.java"

# interfaces
.implements Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;


# instance fields
.field protected data:Ljava/util/concurrent/ArrayBlockingQueue;

.field protected final device:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;

.field protected volatile is_open:Z


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;)V
    .locals 2
    .param p1, "device"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 9
    new-instance v0, Ljava/util/concurrent/ArrayBlockingQueue;

    const/16 v1, 0x100

    invoke-direct {v0, v1}, Ljava/util/concurrent/ArrayBlockingQueue;-><init>(I)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialInputStream;->data:Ljava/util/concurrent/ArrayBlockingQueue;

    .line 14
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialInputStream;->device:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;

    .line 15
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialInputStream;->is_open:Z

    .line 16
    invoke-interface {p1, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;->read(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;)I

    .line 17
    return-void
.end method


# virtual methods
.method public close()V
    .locals 3

    .prologue
    .line 37
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialInputStream;->is_open:Z

    .line 40
    :try_start_0
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialInputStream;->data:Ljava/util/concurrent/ArrayBlockingQueue;

    const/4 v2, -0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/concurrent/ArrayBlockingQueue;->put(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 45
    :goto_0
    return-void

    .line 41
    :catch_0
    move-exception v0

    .line 43
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method

.method public onReceivedData([B)V
    .locals 5
    .param p1, "new_data"    # [B

    .prologue
    .line 49
    array-length v2, p1

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v2, :cond_0

    aget-byte v0, p1, v1

    .line 53
    .local v0, "b":B
    :try_start_0
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialInputStream;->data:Ljava/util/concurrent/ArrayBlockingQueue;

    and-int/lit16 v4, v0, 0xff

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/concurrent/ArrayBlockingQueue;->put(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 49
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 59
    .end local v0    # "b":B
    :cond_0
    return-void

    .line 54
    .restart local v0    # "b":B
    :catch_0
    move-exception v3

    goto :goto_1
.end method

.method public read()I
    .locals 1

    .prologue
    .line 22
    :goto_0
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialInputStream;->is_open:Z

    if-eqz v0, :cond_0

    .line 26
    :try_start_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialInputStream;->data:Ljava/util/concurrent/ArrayBlockingQueue;

    invoke-virtual {v0}, Ljava/util/concurrent/ArrayBlockingQueue;->take()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 32
    :goto_1
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_1

    .line 27
    :catch_0
    move-exception v0

    goto :goto_0
.end method
