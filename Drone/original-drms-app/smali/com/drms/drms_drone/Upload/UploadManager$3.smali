.class Lcom/drms/drms_drone/Upload/UploadManager$3;
.super Ljava/lang/Object;
.source "UploadManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Upload/UploadManager;->requestUploadDialog()V
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
    .line 222
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$3;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 225
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$3;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$300(Lcom/drms/drms_drone/Upload/UploadManager;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 227
    const-wide/16 v0, 0x64

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 228
    :catch_0
    move-exception v0

    goto :goto_0

    .line 230
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$3;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$500(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/drms/drms_drone/Upload/UploadManager$3$1;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Upload/UploadManager$3$1;-><init>(Lcom/drms/drms_drone/Upload/UploadManager$3;)V

    const-wide/16 v2, 0x7d0

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 241
    return-void
.end method
