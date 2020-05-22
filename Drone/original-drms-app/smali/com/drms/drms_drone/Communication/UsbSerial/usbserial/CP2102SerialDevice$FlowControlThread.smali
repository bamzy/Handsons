.class Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;
.super Ljava/lang/Thread;
.source "CP2102SerialDevice.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FlowControlThread"
.end annotation


# instance fields
.field private firstTime:Z

.field private keep:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final synthetic this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

.field private time:J


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 406
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 399
    const-wide/16 v0, 0x28

    iput-wide v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->time:J

    .line 407
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->keep:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 408
    iput-boolean v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->firstTime:Z

    .line 409
    return-void
.end method

.method private pollLines()[B
    .locals 4

    .prologue
    .line 501
    monitor-enter p0

    .line 505
    :try_start_0
    iget-wide v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->time:J

    invoke-virtual {p0, v2, v3}, Ljava/lang/Object;->wait(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 510
    :goto_0
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 512
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$1100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)[B

    move-result-object v1

    return-object v1

    .line 506
    :catch_0
    move-exception v0

    .line 508
    .local v0, "e":Ljava/lang/InterruptedException;
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0

    .line 510
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v1

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/16 v7, 0x10

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 414
    :cond_0
    :goto_0
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->keep:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v2

    if-eqz v2, :cond_e

    .line 416
    iget-boolean v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->firstTime:Z

    if-nez v2, :cond_b

    .line 418
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->pollLines()[B

    move-result-object v1

    .line 419
    .local v1, "modemState":[B
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)[B

    move-result-object v0

    .line 422
    .local v0, "commStatus":[B
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 424
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v5

    aget-byte v2, v1, v4

    and-int/lit8 v2, v2, 0x10

    if-ne v2, v7, :cond_7

    move v2, v3

    :goto_1
    if-eq v5, v2, :cond_1

    .line 426
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v2

    if-nez v2, :cond_8

    move v2, v3

    :goto_2
    invoke-static {v5, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$202(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;Z)Z

    .line 427
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 428
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v2

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v5

    invoke-interface {v2, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;->onCTSChanged(Z)V

    .line 433
    :cond_1
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 435
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v5

    aget-byte v2, v1, v4

    and-int/lit8 v2, v2, 0x20

    const/16 v6, 0x20

    if-ne v2, v6, :cond_9

    move v2, v3

    :goto_3
    if-eq v5, v2, :cond_2

    .line 437
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v2

    if-nez v2, :cond_a

    move v2, v3

    :goto_4
    invoke-static {v5, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$502(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;Z)Z

    .line 438
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 439
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v2

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v5

    invoke-interface {v2, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;->onDSRChanged(Z)V

    .line 444
    :cond_2
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$700(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 446
    aget-byte v2, v0, v4

    and-int/lit8 v2, v2, 0x10

    if-ne v2, v7, :cond_3

    .line 448
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$700(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    move-result-object v2

    invoke-interface {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;->onParityError()V

    .line 453
    :cond_3
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$800(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 455
    aget-byte v2, v0, v4

    and-int/lit8 v2, v2, 0x2

    const/4 v5, 0x2

    if-ne v2, v5, :cond_4

    .line 457
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$800(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    move-result-object v2

    invoke-interface {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;->onFramingError()V

    .line 462
    :cond_4
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$900(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    move-result-object v2

    if-eqz v2, :cond_5

    .line 464
    aget-byte v2, v0, v4

    and-int/lit8 v2, v2, 0x1

    if-ne v2, v3, :cond_5

    .line 466
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$900(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    move-result-object v2

    invoke-interface {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;->onBreakInterrupt()V

    .line 472
    :cond_5
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$1000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 474
    aget-byte v2, v0, v4

    and-int/lit8 v2, v2, 0x4

    const/4 v5, 0x4

    if-eq v2, v5, :cond_6

    aget-byte v2, v0, v4

    and-int/lit8 v2, v2, 0x8

    const/16 v5, 0x8

    if-ne v2, v5, :cond_0

    .line 477
    :cond_6
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$1000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    move-result-object v2

    invoke-interface {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;->onOverrunError()V

    goto/16 :goto_0

    :cond_7
    move v2, v4

    .line 424
    goto/16 :goto_1

    :cond_8
    move v2, v4

    .line 426
    goto/16 :goto_2

    :cond_9
    move v2, v4

    .line 435
    goto/16 :goto_3

    :cond_a
    move v2, v4

    .line 437
    goto/16 :goto_4

    .line 483
    .end local v0    # "commStatus":[B
    .end local v1    # "modemState":[B
    :cond_b
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v2

    if-eqz v2, :cond_c

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v2

    if-eqz v2, :cond_c

    .line 484
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v2

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v5

    invoke-interface {v2, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;->onCTSChanged(Z)V

    .line 486
    :cond_c
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v2

    if-eqz v2, :cond_d

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v2

    if-eqz v2, :cond_d

    .line 487
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v2

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;->access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice;)Z

    move-result v5

    invoke-interface {v2, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;->onDSRChanged(Z)V

    .line 489
    :cond_d
    iput-boolean v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->firstTime:Z

    goto/16 :goto_0

    .line 492
    :cond_e
    return-void
.end method

.method public stopThread()V
    .locals 2

    .prologue
    .line 496
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CP2102SerialDevice$FlowControlThread;->keep:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 497
    return-void
.end method
