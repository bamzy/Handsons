.class Lcom/drms/drms_drone/Upload/UploadManager$2;
.super Ljava/lang/Object;
.source "UploadManager.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


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
    .line 204
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$2;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 2
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 207
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$2;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$200(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 208
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$2;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$200(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    move-result-object v0

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->running:Z

    .line 209
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$2;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$202(Lcom/drms/drms_drone/Upload/UploadManager;Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    .line 212
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$2;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$100(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/app/Activity;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setResult(I)V

    .line 213
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$2;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$100(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 216
    return-void
.end method
