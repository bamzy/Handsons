.class Lcom/drms/drms_drone/Upload/UploadSelectedActivity$5;
.super Landroid/content/BroadcastReceiver;
.source "UploadSelectedActivity.java"


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
    .line 218
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$5;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 221
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 223
    .local v0, "action":Ljava/lang/String;
    return-void
.end method
