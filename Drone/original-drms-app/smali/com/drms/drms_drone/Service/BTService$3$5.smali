.class Lcom/drms/drms_drone/Service/BTService$3$5;
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

.field final synthetic val$d:[F

.field final synthetic val$i:[F

.field final synthetic val$intent:Landroid/content/Intent;

.field final synthetic val$p:[F


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Service/BTService$3;[F[F[FLandroid/content/Intent;)V
    .locals 0
    .param p1, "this$1"    # Lcom/drms/drms_drone/Service/BTService$3;

    .prologue
    .line 414
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$3$5;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iput-object p2, p0, Lcom/drms/drms_drone/Service/BTService$3$5;->val$p:[F

    iput-object p3, p0, Lcom/drms/drms_drone/Service/BTService$3$5;->val$i:[F

    iput-object p4, p0, Lcom/drms/drms_drone/Service/BTService$3$5;->val$d:[F

    iput-object p5, p0, Lcom/drms/drms_drone/Service/BTService$3$5;->val$intent:Landroid/content/Intent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 417
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$3$5;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v1, v1, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v1

    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$3$5;->val$p:[F

    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$3$5;->val$i:[F

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$3$5;->val$d:[F

    invoke-virtual {v1, v2, v3, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->SendRequestMSP_SET_PID_TUNING([F[F[F)V

    .line 418
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$3$5;->val$intent:Landroid/content/Intent;

    const-string v2, "REQUEST_BACK"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 419
    .local v0, "requestExit":I
    if-nez v0, :cond_1

    .line 420
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$3$5;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v1, v1, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v1

    new-instance v2, Lcom/drms/drms_drone/Service/BTService$3$5$1;

    invoke-direct {v2, p0}, Lcom/drms/drms_drone/Service/BTService$3$5$1;-><init>(Lcom/drms/drms_drone/Service/BTService$3$5;)V

    const-wide/16 v4, 0x3e8

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 431
    :cond_0
    :goto_0
    return-void

    .line 427
    :cond_1
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 428
    const-string v1, "BTService"

    const-string v2, "go to Main"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
