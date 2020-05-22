.class Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;
.super Ljava/lang/Object;
.source "SerialBuffer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SynchronizedBuffer"
.end annotation


# instance fields
.field private buffer:[B

.field private position:I

.field final synthetic this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;)V
    .locals 1

    .prologue
    .line 114
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 115
    const/16 v0, 0x4000

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->buffer:[B

    .line 116
    const/4 v0, -0x1

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    .line 117
    return-void
.end method


# virtual methods
.method public declared-synchronized get()[B
    .locals 5

    .prologue
    const/4 v3, -0x1

    .line 141
    monitor-enter p0

    :try_start_0
    iget v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v2, v3, :cond_0

    .line 145
    :try_start_1
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 151
    :cond_0
    :goto_0
    :try_start_2
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->buffer:[B

    const/4 v3, 0x0

    iget v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    invoke-static {v2, v3, v4}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v0

    .line 152
    .local v0, "dst":[B
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->access$000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 153
    const/4 v2, 0x1

    invoke-static {v0, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDebugger;->printLogGet([BZ)V

    .line 154
    :cond_1
    const/4 v2, -0x1

    iput v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 155
    monitor-exit p0

    return-object v0

    .line 146
    .end local v0    # "dst":[B
    :catch_0
    move-exception v1

    .line 148
    .local v1, "e":Ljava/lang/InterruptedException;
    :try_start_3
    invoke-virtual {v1}, Ljava/lang/InterruptedException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 141
    .end local v1    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized put([B)V
    .locals 4
    .param p1, "src"    # [B

    .prologue
    const/16 v2, 0x4000

    .line 121
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 122
    const/4 v0, 0x0

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    .line 123
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;

    invoke-static {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;->access$000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 124
    const/4 v0, 0x1

    invoke-static {p1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDebugger;->printLogPut([BZ)V

    .line 125
    :cond_1
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    array-length v1, p1

    add-int/2addr v0, v1

    const/16 v1, 0x3fff

    if-le v0, v1, :cond_3

    .line 127
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    if-ge v0, v2, :cond_2

    .line 128
    const/4 v0, 0x0

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->buffer:[B

    iget v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    iget v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    rsub-int v3, v3, 0x4000

    invoke-static {p1, v0, v1, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 129
    :cond_2
    const/16 v0, 0x4000

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    .line 130
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 137
    :goto_0
    monitor-exit p0

    return-void

    .line 133
    :cond_3
    const/4 v0, 0x0

    :try_start_1
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->buffer:[B

    iget v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    array-length v3, p1

    invoke-static {p1, v0, v1, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 134
    iget v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    array-length v1, p1

    add-int/2addr v0, v1

    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I

    .line 135
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 121
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized reset()V
    .locals 1

    .prologue
    .line 160
    monitor-enter p0

    const/4 v0, -0x1

    :try_start_0
    iput v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialBuffer$SynchronizedBuffer;->position:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 161
    monitor-exit p0

    return-void

    .line 160
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
