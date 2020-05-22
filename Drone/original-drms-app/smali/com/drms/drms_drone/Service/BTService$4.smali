.class Lcom/drms/drms_drone/Service/BTService$4;
.super Ljava/lang/Object;
.source "BTService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Service/BTService;->implementationMainDisplayThread()V
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
    .line 498
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const-wide/16 v6, 0x0

    .line 501
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$400(Lcom/drms/drms_drone/Service/BTService;)I

    move-result v0

    if-nez v0, :cond_2

    .line 502
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 503
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    if-nez v0, :cond_1

    .line 504
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    new-instance v1, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$300(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;-><init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/os/Handler;)V

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Service/BTService;->access$102(Lcom/drms/drms_drone/Service/BTService;Lcom/drms/drms_drone/Protocol/Multiwii/MSP;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    .line 507
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v0

    const/4 v1, 0x4

    if-eq v0, v1, :cond_3

    .line 528
    :cond_2
    return-void

    .line 510
    :cond_3
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1702(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 511
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    const/16 v2, 0x6c

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 513
    :try_start_0
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-lez v0, :cond_4

    .line 514
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1

    .line 519
    :cond_4
    :goto_1
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1702(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 520
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    const/16 v2, 0x6e

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 522
    :try_start_1
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-lez v0, :cond_0

    .line 523
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMSP_TIME()I

    move-result v0

    int-to-long v0, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$4;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1700(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    sub-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 525
    :catch_0
    move-exception v0

    goto/16 :goto_0

    .line 516
    :catch_1
    move-exception v0

    goto :goto_1
.end method
