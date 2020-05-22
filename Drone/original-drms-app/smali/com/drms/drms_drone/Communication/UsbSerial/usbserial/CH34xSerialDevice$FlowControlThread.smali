.class Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;
.super Ljava/lang/Thread;
.source "CH34xSerialDevice.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FlowControlThread"
.end annotation


# instance fields
.field private firstTime:Z

.field private keep:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final synthetic this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

.field private time:J


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 608
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 601
    const-wide/16 v0, 0x64

    iput-wide v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->time:J

    .line 609
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->keep:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 610
    iput-boolean v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->firstTime:Z

    .line 611
    return-void
.end method


# virtual methods
.method public pollForCTS()Z
    .locals 4

    .prologue
    .line 663
    monitor-enter p0

    .line 667
    :try_start_0
    iget-wide v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->time:J

    invoke-virtual {p0, v2, v3}, Ljava/lang/Object;->wait(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 672
    :goto_0
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 674
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v1

    return v1

    .line 668
    :catch_0
    move-exception v0

    .line 670
    .local v0, "e":Ljava/lang/InterruptedException;
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0

    .line 672
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v1

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public pollForDSR()Z
    .locals 4

    .prologue
    .line 679
    monitor-enter p0

    .line 683
    :try_start_0
    iget-wide v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->time:J

    invoke-virtual {p0, v2, v3}, Ljava/lang/Object;->wait(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 688
    :goto_0
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 690
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$700(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v1

    return v1

    .line 684
    :catch_0
    move-exception v0

    .line 686
    .local v0, "e":Ljava/lang/InterruptedException;
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0

    .line 688
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v1

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public run()V
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 616
    :cond_0
    :goto_0
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->keep:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v2

    if-eqz v2, :cond_7

    .line 618
    iget-boolean v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->firstTime:Z

    if-nez v2, :cond_4

    .line 621
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 623
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->pollForCTS()Z

    move-result v0

    .line 624
    .local v0, "cts":Z
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v2

    if-eq v2, v0, :cond_1

    .line 626
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v2

    if-nez v2, :cond_2

    move v2, v3

    :goto_1
    invoke-static {v5, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$102(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;Z)Z

    .line 627
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 628
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v2

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v5

    invoke-interface {v2, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;->onCTSChanged(Z)V

    .line 633
    .end local v0    # "cts":Z
    :cond_1
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 635
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->pollForDSR()Z

    move-result v1

    .line 636
    .local v1, "dsr":Z
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v2

    if-eq v2, v1, :cond_0

    .line 638
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v2

    if-nez v2, :cond_3

    move v2, v3

    :goto_2
    invoke-static {v5, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$402(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;Z)Z

    .line 639
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 640
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v2

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v5

    invoke-interface {v2, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;->onDSRChanged(Z)V

    goto :goto_0

    .end local v1    # "dsr":Z
    .restart local v0    # "cts":Z
    :cond_2
    move v2, v4

    .line 626
    goto :goto_1

    .end local v0    # "cts":Z
    .restart local v1    # "dsr":Z
    :cond_3
    move v2, v4

    .line 638
    goto :goto_2

    .line 645
    .end local v1    # "dsr":Z
    :cond_4
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v2

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v2

    if-eqz v2, :cond_5

    .line 646
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v2

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v5

    invoke-interface {v2, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;->onCTSChanged(Z)V

    .line 648
    :cond_5
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v2

    if-eqz v2, :cond_6

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v2

    if-eqz v2, :cond_6

    .line 649
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v2

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice;)Z

    move-result v5

    invoke-interface {v2, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;->onDSRChanged(Z)V

    .line 651
    :cond_6
    iput-boolean v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->firstTime:Z

    goto/16 :goto_0

    .line 654
    :cond_7
    return-void
.end method

.method public stopThread()V
    .locals 2

    .prologue
    .line 658
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CH34xSerialDevice$FlowControlThread;->keep:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 659
    return-void
.end method
