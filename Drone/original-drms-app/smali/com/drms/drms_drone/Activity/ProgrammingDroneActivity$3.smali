.class Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$3;
.super Ljava/lang/Object;
.source "ProgrammingDroneActivity.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$3;->this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 3
    .param p1, "arg0"    # Landroid/content/ComponentName;
    .param p2, "arg1"    # Landroid/os/IBinder;

    .prologue
    .line 81
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$3;->this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    check-cast p2, Lcom/drms/drms_drone/Service/BTService$BtBinder;

    .end local p2    # "arg1":Landroid/os/IBinder;
    invoke-virtual {p2}, Lcom/drms/drms_drone/Service/BTService$BtBinder;->getService()Lcom/drms/drms_drone/Service/BTService;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->access$202(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;

    .line 82
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$3;->this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->access$200(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v0

    invoke-static {}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->access$300()Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Service/BTService;->setHandler(Landroid/os/Handler;)V

    .line 83
    const-string v0, "ProgrammingDrone"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Service : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$3;->this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->access$200(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 85
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 2
    .param p1, "arg0"    # Landroid/content/ComponentName;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$3;->this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->access$202(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;

    .line 90
    const-string v0, "ProgrammingDrone"

    const-string v1, "Service Disconnected"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 91
    return-void
.end method
