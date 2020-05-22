.class Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1$1;
.super Ljava/lang/Object;
.source "CheckPermissionActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;)V
    .locals 0
    .param p1, "this$1"    # Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1$1;->this$1:Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 80
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1$1;->this$1:Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;

    iget-object v0, v0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const-string v1, "\uc5b4\ud50c\ub9ac\ucf00\uc774\uc158\uc744 \uc885\ub8cc\ud569\ub2c8\ub2e4."

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 81
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1$1;->this$1:Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;

    iget-object v0, v0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->finish()V

    .line 82
    return-void
.end method
