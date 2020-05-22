.class Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;
.super Ljava/lang/Object;
.source "CheckPermissionActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/CheckPermissionActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v8, 0x1

    const/4 v6, -0x1

    .line 52
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    invoke-static {v4, v8}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->access$002(Lcom/drms/drms_drone/Activity/CheckPermissionActivity;Z)Z

    .line 55
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0x17

    if-lt v4, v5, :cond_2

    .line 56
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const-string v5, "android.permission.ACCESS_FINE_LOCATION"

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->checkSelfPermission(Ljava/lang/String;)I

    move-result v1

    .line 57
    .local v1, "permissionResult":I
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const-string v5, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->checkSelfPermission(Ljava/lang/String;)I

    move-result v2

    .line 58
    .local v2, "permissionResult2":I
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const-string v5, "android.permission.WRITE_EXTERNAL_STORAGE"

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->checkSelfPermission(Ljava/lang/String;)I

    move-result v3

    .line 60
    .local v3, "permissionResult3":I
    if-eq v1, v6, :cond_0

    if-eq v2, v6, :cond_0

    if-ne v3, v6, :cond_2

    .line 62
    :cond_0
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const-string v5, "android.permission.ACCESS_FINE_LOCATION"

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->shouldShowRequestPermissionRationale(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    iget-object v4, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const-string v5, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->shouldShowRequestPermissionRationale(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    iget-object v4, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const-string v5, "android.permission.WRITE_EXTERNAL_STORAGE"

    .line 63
    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->shouldShowRequestPermissionRationale(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 64
    :cond_1
    new-instance v0, Landroid/support/v7/app/AlertDialog$Builder;

    iget-object v4, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    invoke-direct {v0, v4}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 65
    .local v0, "dialog":Landroid/support/v7/app/AlertDialog$Builder;
    const-string v4, "\uad8c\ud55c\uc774 \ud544\uc694\ud569\ub2c8\ub2e4."

    invoke-virtual {v0, v4}, Landroid/support/v7/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v4

    const-string v5, "\uc774 \uae30\ub2a5\uc744 \uc0ac\uc6a9\ud558\uae30 \uc704\ud574\uc11c\ub294 \ub2e8\ub9d0\uae30\uc758 \uad8c\ud55c\uc774 \ud544\uc694\ud569\ub2c8\ub2e4. \uacc4\uc18d \ud558\uc2dc\uaca0\uc2b5\ub2c8\uae4c"

    invoke-virtual {v4, v5}, Landroid/support/v7/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v4

    const-string v5, "\ub124"

    new-instance v6, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1$2;

    invoke-direct {v6, p0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1$2;-><init>(Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;)V

    .line 66
    invoke-virtual {v4, v5, v6}, Landroid/support/v7/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v4

    const-string v5, "\uc544\ub2c8\uc624"

    new-instance v6, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1$1;

    invoke-direct {v6, p0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1$1;-><init>(Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;)V

    .line 77
    invoke-virtual {v4, v5, v6}, Landroid/support/v7/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v4

    .line 83
    invoke-virtual {v4}, Landroid/support/v7/app/AlertDialog$Builder;->create()Landroid/support/v7/app/AlertDialog;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v7/app/AlertDialog;->show()V

    .line 96
    .end local v0    # "dialog":Landroid/support/v7/app/AlertDialog$Builder;
    .end local v1    # "permissionResult":I
    .end local v2    # "permissionResult2":I
    .end local v3    # "permissionResult3":I
    :cond_2
    :goto_0
    return-void

    .line 86
    .restart local v1    # "permissionResult":I
    .restart local v2    # "permissionResult2":I
    .restart local v3    # "permissionResult3":I
    :cond_3
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v7, "android.permission.ACCESS_COARSE_LOCATION"

    aput-object v7, v5, v6

    const-string v6, "android.permission.ACCESS_FINE_LOCATION"

    aput-object v6, v5, v8

    const/4 v6, 0x2

    const-string v7, "android.permission.WRITE_EXTERNAL_STORAGE"

    aput-object v7, v5, v6

    const/16 v6, 0x3e8

    invoke-virtual {v4, v5, v6}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->requestPermissions([Ljava/lang/String;I)V

    goto :goto_0
.end method
