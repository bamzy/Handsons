.class Lcom/drms/drms_drone/Service/BTService$3$3$1;
.super Ljava/lang/Object;
.source "BTService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Service/BTService$3$3;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/drms/drms_drone/Service/BTService$3$3;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Service/BTService$3$3;)V
    .locals 0
    .param p1, "this$2"    # Lcom/drms/drms_drone/Service/BTService$3$3;

    .prologue
    .line 369
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$3$3$1;->this$2:Lcom/drms/drms_drone/Service/BTService$3$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 372
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$3$3$1;->this$2:Lcom/drms/drms_drone/Service/BTService$3$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$3$3;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v1, 0x3

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Service/BTService;->access$402(Lcom/drms/drms_drone/Service/BTService;I)I

    .line 373
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$3$3$1;->this$2:Lcom/drms/drms_drone/Service/BTService$3$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$3$3;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1400(Lcom/drms/drms_drone/Service/BTService;)V

    .line 374
    return-void
.end method
