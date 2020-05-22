.class Lcom/drms/drms_drone/Service/BTService$8$2$1;
.super Ljava/lang/Object;
.source "BTService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Service/BTService$8$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/drms/drms_drone/Service/BTService$8$2;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Service/BTService$8$2;)V
    .locals 0
    .param p1, "this$2"    # Lcom/drms/drms_drone/Service/BTService$8$2;

    .prologue
    .line 790
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$8$2$1;->this$2:Lcom/drms/drms_drone/Service/BTService$8$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 793
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$8$2$1;->this$2:Lcom/drms/drms_drone/Service/BTService$8$2;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$8$2;->this$1:Lcom/drms/drms_drone/Service/BTService$8;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$400(Lcom/drms/drms_drone/Service/BTService;)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 794
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$8$2$1;->this$2:Lcom/drms/drms_drone/Service/BTService$8$2;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$8$2;->this$1:Lcom/drms/drms_drone/Service/BTService$8;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$600(Lcom/drms/drms_drone/Service/BTService;)V

    .line 795
    :cond_0
    return-void
.end method
