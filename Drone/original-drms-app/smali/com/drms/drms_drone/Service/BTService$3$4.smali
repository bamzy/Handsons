.class Lcom/drms/drms_drone/Service/BTService$3$4;
.super Ljava/lang/Object;
.source "BTService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Service/BTService$3;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/drms/drms_drone/Service/BTService$3;

.field final synthetic val$intent:Landroid/content/Intent;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Service/BTService$3;Landroid/content/Intent;)V
    .locals 0
    .param p1, "this$1"    # Lcom/drms/drms_drone/Service/BTService$3;

    .prologue
    .line 385
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iput-object p2, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->val$intent:Landroid/content/Intent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 14

    .prologue
    const/4 v13, 0x0

    .line 388
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v1, v1, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getRCTUNEdata()[F

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->SendRequestMSP_SET_RC_TUNING([F)V

    .line 389
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v1, v1, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v1

    aget v1, v1, v13

    float-to-int v1, v1

    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v2, v2, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    float-to-int v2, v2

    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v3, v3, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v3

    const/4 v4, 0x2

    aget v3, v3, v4

    float-to-int v3, v3

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v4, v4, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    .line 390
    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    invoke-virtual {v4}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v4

    const/4 v5, 0x3

    aget v4, v4, v5

    float-to-int v4, v4

    iget-object v5, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v5, v5, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v5}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v5

    const/4 v6, 0x4

    aget v5, v5, v6

    float-to-int v5, v5

    iget-object v6, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v6, v6, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v6}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v6

    invoke-virtual {v6}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v6

    const/4 v7, 0x7

    aget v6, v6, v7

    iget-object v7, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v7, v7, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v7}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v7

    invoke-virtual {v7}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v7

    const/16 v8, 0x8

    aget v7, v7, v8

    float-to-int v7, v7

    iget-object v8, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v8, v8, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    .line 391
    invoke-static {v8}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v8

    invoke-virtual {v8}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v8

    const/16 v9, 0x9

    aget v8, v8, v9

    iget-object v9, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v9, v9, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v9}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v9

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v9

    const/16 v10, 0xa

    aget v9, v9, v10

    iget-object v10, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v10, v10, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v10}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v10

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v10

    const/16 v12, 0xb

    aget v10, v10, v12

    .line 389
    invoke-virtual/range {v0 .. v10}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->SendRequestMSP_SET_MISC(IIIIIFIFFF)V

    .line 393
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->val$intent:Landroid/content/Intent;

    const-string v1, "REQUEST_BACK"

    invoke-virtual {v0, v1, v13}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v11

    .line 394
    .local v11, "requestExit":I
    if-nez v11, :cond_1

    .line 395
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$3$4;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/drms/drms_drone/Service/BTService$3$4$1;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Service/BTService$3$4$1;-><init>(Lcom/drms/drms_drone/Service/BTService$3$4;)V

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 406
    :cond_0
    :goto_0
    return-void

    .line 402
    :cond_1
    const/4 v0, -0x1

    if-ne v11, v0, :cond_0

    .line 403
    const-string v0, "BTService"

    const-string v1, "go to Main"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
