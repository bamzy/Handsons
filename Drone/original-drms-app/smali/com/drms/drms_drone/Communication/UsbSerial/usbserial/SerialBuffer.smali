.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;
.super Ljava/lang/Object;
.source "SerialBuffer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;
    }
.end annotation


# static fields
.field public static final DEFAULT_READ_BUFFER_SIZE:I = 0x4000

.field public static final DEFAULT_WRITE_BUFFER_SIZE:I = 0x4000


# instance fields
.field private debugging:Z

.field private readBuffer:Ljava/nio/ByteBuffer;

.field private readBuffer_compatible:[B

.field private writeBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;


# direct methods
.method public constructor <init>(Z)V
    .locals 2
    .param p1, "version"    # Z

    .prologue
    const/16 v1, 0x4000

    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->debugging:Z

    .line 18
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->writeBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;

    .line 19
    if-eqz p1, :cond_0

    .line 21
    invoke-static {v1}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->readBuffer:Ljava/nio/ByteBuffer;

    .line 27
    :goto_0
    return-void

    .line 25
    :cond_0
    new-array v0, v1, [B

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->readBuffer_compatible:[B

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    .prologue
    .line 7
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->debugging:Z

    return v0
.end method


# virtual methods
.method public clearReadBuffer()V
    .locals 1

    .prologue
    .line 75
    monitor-enter p0

    .line 77
    :try_start_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->readBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    .line 78
    monitor-exit p0

    .line 79
    return-void

    .line 78
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public debug(Z)V
    .locals 0
    .param p1, "value"    # Z

    .prologue
    .line 34
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->debugging:Z

    .line 35
    return-void
.end method

.method public getBufferCompatible()[B
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->readBuffer_compatible:[B

    return-object v0
.end method

.method public getDataReceived()[B
    .locals 4

    .prologue
    .line 62
    monitor-enter p0

    .line 64
    :try_start_0
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->readBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->position()I

    move-result v1

    new-array v0, v1, [B

    .line 65
    .local v0, "dst":[B
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->readBuffer:Ljava/nio/ByteBuffer;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 66
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->readBuffer:Ljava/nio/ByteBuffer;

    const/4 v2, 0x0

    array-length v3, v0

    invoke-virtual {v1, v0, v2, v3}, Ljava/nio/ByteBuffer;->get([BII)Ljava/nio/ByteBuffer;

    .line 67
    iget-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->debugging:Z

    if-eqz v1, :cond_0

    .line 68
    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDebugger;->printReadLogGet([BZ)V

    .line 69
    :cond_0
    monitor-exit p0

    return-object v0

    .line 70
    .end local v0    # "dst":[B
    :catchall_0
    move-exception v1

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public getDataReceivedCompatible(I)[B
    .locals 3
    .param p1, "numberBytes"    # I

    .prologue
    .line 104
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->readBuffer_compatible:[B

    const/4 v2, 0x0

    invoke-static {v1, v2, p1}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v0

    .line 105
    .local v0, "tempBuff":[B
    return-object v0
.end method

.method public getReadBuffer()Ljava/nio/ByteBuffer;
    .locals 1

    .prologue
    .line 53
    monitor-enter p0

    .line 55
    :try_start_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->readBuffer:Ljava/nio/ByteBuffer;

    monitor-exit p0

    return-object v0

    .line 56
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getWriteBuffer()[B
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->writeBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->get()[B

    move-result-object v0

    return-object v0
.end method

.method public putReadBuffer(Ljava/nio/ByteBuffer;)V
    .locals 1
    .param p1, "data"    # Ljava/nio/ByteBuffer;

    .prologue
    .line 39
    monitor-enter p0

    .line 43
    :try_start_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->readBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->put(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    :try_end_0
    .catch Ljava/nio/BufferOverflowException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 48
    :goto_0
    :try_start_1
    monitor-exit p0

    .line 49
    return-void

    .line 48
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 44
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public putWriteBuffer([B)V
    .locals 1
    .param p1, "data"    # [B

    .prologue
    .line 88
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->writeBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;

    invoke-virtual {v0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->put([B)V

    .line 89
    return-void
.end method

.method public resetWriteBuffer()V
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->writeBuffer:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->reset()V

    .line 95
    return-void
.end method
