.class Lcom/drms/drms_drone/Upload/UploadManager$8$1;
.super Ljava/lang/Object;
.source "UploadManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Upload/UploadManager$8;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/drms/drms_drone/Upload/UploadManager$8;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Upload/UploadManager$8;)V
    .locals 0
    .param p1, "this$1"    # Lcom/drms/drms_drone/Upload/UploadManager$8;

    .prologue
    .line 387
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$8$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$8;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 390
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$8$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$8;

    iget-object v0, v0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$400(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog;->dismiss()V

    .line 391
    return-void
.end method
