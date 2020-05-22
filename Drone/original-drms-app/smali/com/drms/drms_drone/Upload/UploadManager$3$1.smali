.class Lcom/drms/drms_drone/Upload/UploadManager$3$1;
.super Ljava/lang/Object;
.source "UploadManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Upload/UploadManager$3;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/drms/drms_drone/Upload/UploadManager$3;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Upload/UploadManager$3;)V
    .locals 0
    .param p1, "this$1"    # Lcom/drms/drms_drone/Upload/UploadManager$3;

    .prologue
    .line 230
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$3$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 233
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$3$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Upload/UploadManager$3;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$100(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/drms/drms_drone/Upload/UploadManager$3$1$1;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Upload/UploadManager$3$1$1;-><init>(Lcom/drms/drms_drone/Upload/UploadManager$3$1;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 239
    return-void
.end method
