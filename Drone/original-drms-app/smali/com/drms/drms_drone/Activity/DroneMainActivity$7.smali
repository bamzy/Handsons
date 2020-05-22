.class Lcom/drms/drms_drone/Activity/DroneMainActivity$7;
.super Ljava/lang/Object;
.source "DroneMainActivity.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Activity/DroneMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 476
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 3
    .param p1, "arg0"    # Landroid/content/ComponentName;
    .param p2, "arg1"    # Landroid/os/IBinder;

    .prologue
    .line 479
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    check-cast p2, Lcom/drms/drms_drone/Service/BTService$BtBinder;

    .end local p2    # "arg1":Landroid/os/IBinder;
    invoke-virtual {p2}, Lcom/drms/drms_drone/Service/BTService$BtBinder;->getService()Lcom/drms/drms_drone/Service/BTService;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$502(Lcom/drms/drms_drone/Activity/DroneMainActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;

    .line 480
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$500(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1200(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Service/BTService;->setHandler(Landroid/os/Handler;)V

    .line 481
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Service : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$500(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 482
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/MainView/Playflight;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$500(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/MainView/Playflight;->setmBTService(Lcom/drms/drms_drone/Service/BTService;)V

    .line 483
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1300(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/MainView/UploadingView;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$500(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/MainView/UploadingView;->setmBTService(Lcom/drms/drms_drone/Service/BTService;)V

    .line 484
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1400(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/MainView/SettingView;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$500(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/MainView/SettingView;->setmBTService(Lcom/drms/drms_drone/Service/BTService;)V

    .line 486
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 2
    .param p1, "arg0"    # Landroid/content/ComponentName;

    .prologue
    .line 490
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$502(Lcom/drms/drms_drone/Activity/DroneMainActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;

    .line 491
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "Service Disconnected"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 492
    return-void
.end method
