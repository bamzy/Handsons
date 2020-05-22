.class Lcom/drms/drms_drone/Upload/UploadManager$5;
.super Ljava/lang/Object;
.source "UploadManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Upload/UploadManager;->requestUpload()Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Upload/UploadManager;

.field final synthetic val$binaryFile:[B


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Upload/UploadManager;[B)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 273
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$5;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    iput-object p2, p0, Lcom/drms/drms_drone/Upload/UploadManager$5;->val$binaryFile:[B

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 276
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$5;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$200(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 277
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$5;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$5;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$200(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    move-result-object v1

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager$5;->val$binaryFile:[B

    const/16 v3, 0x100

    invoke-virtual {v1, v2, v3, v4}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programHexFile([BIZ)Z

    move-result v1

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$702(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z

    .line 278
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$5;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$700(Lcom/drms/drms_drone/Upload/UploadManager;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 279
    const-string v0, "UplaodManager"

    const-string v1, "Uploading Successful"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 280
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$5;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$002(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z

    .line 281
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$5;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$500(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/os/Handler;

    move-result-object v0

    const/16 v1, 0x17

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v4, v2}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 289
    :goto_0
    return-void

    .line 283
    :cond_0
    const-string v0, "UplaodManager"

    const-string v1, "Failed to Uploading"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 287
    :cond_1
    const-string v0, "UplaodManager"

    const-string v1, "STK500 instance is null"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
