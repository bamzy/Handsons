.class Lcom/drms/drms_drone/Upload/UploadManager$1;
.super Ljava/lang/Object;
.source "UploadManager.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


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
    .line 175
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$1;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "i"    # I

    .prologue
    .line 178
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$1;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$000(Lcom/drms/drms_drone/Upload/UploadManager;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 179
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 185
    :goto_0
    return-void

    .line 182
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$1;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v0}, Lcom/drms/drms_drone/Upload/UploadManager;->access$100(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/app/Activity;

    move-result-object v0

    const-string v1, "\uc5c5\ub85c\ub4dc \uc911\uc5d0\ub294 \uc885\ub8cc\ud560 \uc218 \uc5c6\uc2b5\ub2c8\ub2e4."

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method
