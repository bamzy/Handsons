.class Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$7;
.super Ljava/lang/Object;
.source "DroneSettingActivity.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 452
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$7;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 3
    .param p1, "arg0"    # Landroid/content/ComponentName;
    .param p2, "arg1"    # Landroid/os/IBinder;

    .prologue
    .line 455
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$7;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    check-cast p2, Lcom/drms/drms_drone/Service/BTService$BtBinder;

    .end local p2    # "arg1":Landroid/os/IBinder;
    invoke-virtual {p2}, Lcom/drms/drms_drone/Service/BTService$BtBinder;->getService()Lcom/drms/drms_drone/Service/BTService;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$5102(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;

    .line 456
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$7;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$5100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$7;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$5200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Service/BTService;->setHandler(Landroid/os/Handler;)V

    .line 457
    const-string v0, "DroneSettingActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Service : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$7;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$5100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 460
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 2
    .param p1, "arg0"    # Landroid/content/ComponentName;

    .prologue
    .line 464
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$7;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$5102(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;

    .line 465
    const-string v0, "DroneSettingActivity"

    const-string v1, "Service Disconnected"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 466
    return-void
.end method
