.class Lcom/drms/drms_drone/Service/BTService$7;
.super Ljava/lang/Object;
.source "BTService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Service/BTService;->implementationSettingThread()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Service/BTService;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Service/BTService;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 634
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const-wide/16 v6, 0x0

    .line 637
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$400(Lcom/drms/drms_drone/Service/BTService;)I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_2

    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1300(Lcom/drms/drms_drone/Service/BTService;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 638
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 639
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    if-nez v0, :cond_1

    .line 640
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    new-instance v1, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$300(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;-><init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/os/Handler;)V

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Service/BTService;->access$102(Lcom/drms/drms_drone/Service/BTService;Lcom/drms/drms_drone/Protocol/Multiwii/MSP;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    .line 643
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v0

    const/4 v1, 0x4

    if-eq v0, v1, :cond_3

    .line 721
    :cond_2
    return-void

    .line 647
    :cond_3
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1702(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 648
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    const/16 v2, 0x6c

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 650
    :try_start_0
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-lez v0, :cond_4

    .line 651
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_7

    .line 656
    :cond_4
    :goto_1
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1702(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 657
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    const/16 v2, 0x6e

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 659
    :try_start_1
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-lez v0, :cond_5

    .line 660
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_6

    .line 664
    :cond_5
    :goto_2
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1702(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 665
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    const/16 v2, 0x66

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 667
    :try_start_2
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-lez v0, :cond_6

    .line 668
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_5

    .line 673
    :cond_6
    :goto_3
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    iget-boolean v0, v0, Lcom/drms/drms_drone/Service/BTService;->checkData:Z

    if-nez v0, :cond_0

    .line 675
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1702(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 676
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    const/16 v2, 0x74

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 678
    :try_start_3
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-lez v0, :cond_7

    .line 679
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_4

    .line 683
    :cond_7
    :goto_4
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1702(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 684
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    const/16 v2, 0x72

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 686
    :try_start_4
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-lez v0, :cond_8

    .line 687
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_4
    .catch Ljava/lang/InterruptedException; {:try_start_4 .. :try_end_4} :catch_3

    .line 691
    :cond_8
    :goto_5
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1702(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 692
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    const/16 v2, 0x6f

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 694
    :try_start_5
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-lez v0, :cond_9

    .line 695
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_2

    .line 699
    :cond_9
    :goto_6
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1702(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 700
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    const/16 v2, 0x71

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 702
    :try_start_6
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-lez v0, :cond_a

    .line 703
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_6
    .catch Ljava/lang/InterruptedException; {:try_start_6 .. :try_end_6} :catch_1

    .line 707
    :cond_a
    :goto_7
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1702(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 708
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    const/16 v2, 0x70

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 710
    :try_start_7
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-lez v0, :cond_b

    .line 711
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_7
    .catch Ljava/lang/InterruptedException; {:try_start_7 .. :try_end_7} :catch_0

    .line 715
    :cond_b
    :goto_8
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$7;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/drms/drms_drone/Service/BTService;->checkData:Z

    goto/16 :goto_0

    .line 713
    :catch_0
    move-exception v0

    goto :goto_8

    .line 705
    :catch_1
    move-exception v0

    goto :goto_7

    .line 697
    :catch_2
    move-exception v0

    goto/16 :goto_6

    .line 689
    :catch_3
    move-exception v0

    goto/16 :goto_5

    .line 681
    :catch_4
    move-exception v0

    goto/16 :goto_4

    .line 670
    :catch_5
    move-exception v0

    goto/16 :goto_3

    .line 662
    :catch_6
    move-exception v0

    goto/16 :goto_2

    .line 653
    :catch_7
    move-exception v0

    goto/16 :goto_1
.end method
