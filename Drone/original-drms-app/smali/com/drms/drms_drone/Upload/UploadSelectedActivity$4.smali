.class Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;
.super Ljava/lang/Object;
.source "UploadSelectedActivity.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Upload/UploadSelectedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    .prologue
    .line 151
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 4
    .param p1, "arg0"    # Landroid/content/ComponentName;
    .param p2, "arg1"    # Landroid/os/IBinder;

    .prologue
    .line 154
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    check-cast p2, Lcom/drms/drms_drone/Service/BTService$BtBinder;

    .end local p2    # "arg1":Landroid/os/IBinder;
    invoke-virtual {p2}, Lcom/drms/drms_drone/Service/BTService$BtBinder;->getService()Lcom/drms/drms_drone/Service/BTService;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$302(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;

    .line 155
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$300(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$400(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Service/BTService;->setHandler(Landroid/os/Handler;)V

    .line 156
    const-string v0, "UploadSelectActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Service : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$300(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 157
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$300(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v1

    invoke-virtual {v1}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$102(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .line 158
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    new-instance v1, Lcom/drms/drms_drone/FileManagement/FileManagement;

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$400(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Landroid/os/Handler;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/drms/drms_drone/FileManagement/FileManagement;-><init>(Landroid/content/Context;Landroid/os/Handler;)V

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$202(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;Lcom/drms/drms_drone/FileManagement/FileManagement;)Lcom/drms/drms_drone/FileManagement/FileManagement;

    .line 159
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    new-instance v1, Lcom/drms/drms_drone/Sound/SoundManager;

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-direct {v1, v2}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$002(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;Lcom/drms/drms_drone/Sound/SoundManager;)Lcom/drms/drms_drone/Sound/SoundManager;

    .line 162
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 2
    .param p1, "arg0"    # Landroid/content/ComponentName;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$302(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;

    .line 167
    const-string v0, "UploadSelectActivity"

    const-string v1, "Service Disconnected"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 168
    return-void
.end method
