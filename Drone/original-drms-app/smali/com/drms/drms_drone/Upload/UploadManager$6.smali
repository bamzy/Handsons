.class Lcom/drms/drms_drone/Upload/UploadManager$6;
.super Ljava/lang/Object;
.source "UploadManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Upload/UploadManager;->displayStateOfUpload()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Upload/UploadManager;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Upload/UploadManager;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 316
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$6;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 319
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$6;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$000(Lcom/drms/drms_drone/Upload/UploadManager;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 320
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$6;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$500(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/os/Handler;

    move-result-object v0

    const/4 v1, 0x4

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager$6;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v2}, Lcom/drms/drms_drone/Upload/UploadManager;->access$808(Lcom/drms/drms_drone/Upload/UploadManager;)I

    move-result v2

    const/4 v3, -0x1

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 322
    const-wide/16 v0, 0x64

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 324
    :goto_1
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$6;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$800(Lcom/drms/drms_drone/Upload/UploadManager;)I

    move-result v0

    const/4 v1, 0x2

    if-le v0, v1, :cond_0

    .line 325
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$6;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$802(Lcom/drms/drms_drone/Upload/UploadManager;I)I

    goto :goto_0

    .line 323
    :catch_0
    move-exception v0

    goto :goto_1

    .line 328
    :cond_1
    return-void
.end method
