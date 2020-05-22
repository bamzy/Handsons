.class Lcom/drms/drms_drone/Service/BTService$3$2;
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


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Service/BTService$3;)V
    .locals 0
    .param p1, "this$1"    # Lcom/drms/drms_drone/Service/BTService$3;

    .prologue
    .line 353
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$3$2;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 356
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$3$2;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$1400(Lcom/drms/drms_drone/Service/BTService;)V

    .line 357
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$3$2;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v1, 0x3

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Service/BTService;->access$402(Lcom/drms/drms_drone/Service/BTService;I)I

    .line 358
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$3$2;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v0}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService$3$2;->this$1:Lcom/drms/drms_drone/Service/BTService$3;

    iget-object v1, v1, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v1}, Lcom/drms/drms_drone/Service/BTService;->access$1200(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->setmHandler(Landroid/os/Handler;)V

    .line 359
    return-void
.end method
