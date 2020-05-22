.class Lcom/drms/drms_drone/Activity/CheckPermissionActivity$3;
.super Landroid/os/Handler;
.source "CheckPermissionActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Activity/CheckPermissionActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/CheckPermissionActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    .prologue
    .line 147
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$3;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 150
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 152
    iget v1, p1, Landroid/os/Message;->what:I

    if-nez v1, :cond_0

    .line 154
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$3;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->access$002(Lcom/drms/drms_drone/Activity/CheckPermissionActivity;Z)Z

    .line 156
    const-wide/16 v2, 0x12c

    :try_start_0
    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 159
    :goto_0
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$3;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const-class v2, Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 160
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "requset tutorial"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 161
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$3;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    invoke-virtual {v1, v0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->startActivity(Landroid/content/Intent;)V

    .line 162
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$3;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const v2, 0x7f05000b

    const v3, 0x7f05000c

    invoke-virtual {v1, v2, v3}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->overridePendingTransition(II)V

    .line 163
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$3;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->finish()V

    .line 166
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    return-void

    .line 157
    :catch_0
    move-exception v1

    goto :goto_0
.end method
