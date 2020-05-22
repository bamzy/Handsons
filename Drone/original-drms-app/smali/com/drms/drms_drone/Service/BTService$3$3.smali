.class Lcom/drms/drms_drone/Service/BTService$3$3;
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
    .line 363
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$3$3;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iput-object p2, p0, Lcom/drms/drms_drone/Service/BTService$3$3;->val$intent:Landroid/content/Intent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 366
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$3$3;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v1, v1, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$3$3;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v2, v2, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getCheckboxData()[[Z

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP_SET_BOX([[Z)V

    .line 367
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$3$3;->val$intent:Landroid/content/Intent;

    const-string v2, "REQUEST_BACK"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 368
    .local v0, "requestExit":I
    if-nez v0, :cond_1

    .line 369
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$3$3;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v1, v1, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v1

    new-instance v2, Lcom/drms/drms_drone/Service/BTService$3$3$1;

    invoke-direct {v2, p0}, Lcom/drms/drms_drone/Service/BTService$3$3$1;-><init>(Lcom/drms/drms_drone/Service/BTService$3$3;)V

    const-wide/16 v4, 0x3e8

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 380
    :cond_0
    :goto_0
    return-void

    .line 376
    :cond_1
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 377
    const-string v1, "BTService"

    const-string v2, "go to Main"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
