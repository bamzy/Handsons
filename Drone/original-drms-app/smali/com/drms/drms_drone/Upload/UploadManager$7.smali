.class Lcom/drms/drms_drone/Upload/UploadManager$7;
.super Ljava/lang/Object;
.source "UploadManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Upload/UploadManager;->display_initializing()V
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
    .line 334
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 337
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$900(Lcom/drms/drms_drone/Upload/UploadManager;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 339
    const-wide/16 v0, 0xc8

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 341
    :goto_1
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$100(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/drms/drms_drone/Upload/UploadManager$7$1;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Upload/UploadManager$7$1;-><init>(Lcom/drms/drms_drone/Upload/UploadManager$7;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 340
    :catch_0
    move-exception v0

    goto :goto_1

    .line 357
    :cond_0
    return-void
.end method
