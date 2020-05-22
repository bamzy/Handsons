.class Lcom/drms/drms_drone/Activity/DroneMainActivity$9;
.super Ljava/lang/Object;
.source "DroneMainActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Activity/DroneMainActivity;->onActivityResult(IILandroid/content/Intent;)V
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
    .line 552
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$9;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 555
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 556
    .local v0, "requestBt":Landroid/content/Intent;
    const-string v1, "request_connect_bt"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 557
    const-string v1, "BT"

    iget-object v2, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$9;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$400(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/FileManagement/FileManagement;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    aget-object v2, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 558
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$9;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v1, v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 559
    return-void
.end method
