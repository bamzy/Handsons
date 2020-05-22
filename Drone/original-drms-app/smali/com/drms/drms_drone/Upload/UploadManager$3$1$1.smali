.class Lcom/drms/drms_drone/Upload/UploadManager$3$1$1;
.super Ljava/lang/Object;
.source "UploadManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Upload/UploadManager$3$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/drms/drms_drone/Upload/UploadManager$3$1;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Upload/UploadManager$3$1;)V
    .locals 0
    .param p1, "this$2"    # Lcom/drms/drms_drone/Upload/UploadManager$3$1;

    .prologue
    .line 233
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$3$1$1;->this$2:Lcom/drms/drms_drone/Upload/UploadManager$3$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$3$1$1;->this$2:Lcom/drms/drms_drone/Upload/UploadManager$3$1;

    iget-object v0, v0, Lcom/drms/drms_drone/Upload/UploadManager$3$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$3;

    iget-object v0, v0, Lcom/drms/drms_drone/Upload/UploadManager$3;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$400(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog;->dismiss()V

    .line 237
    return-void
.end method
