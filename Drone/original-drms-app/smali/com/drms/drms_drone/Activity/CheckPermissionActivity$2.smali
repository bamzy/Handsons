.class Lcom/drms/drms_drone/Activity/CheckPermissionActivity$2;
.super Ljava/lang/Object;
.source "CheckPermissionActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->onRequestPermissionsResult(I[Ljava/lang/String;[I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

.field final synthetic val$ad:Landroid/support/v7/app/AlertDialog;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/CheckPermissionActivity;Landroid/support/v7/app/AlertDialog;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$2;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    iput-object p2, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$2;->val$ad:Landroid/support/v7/app/AlertDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$2;->val$ad:Landroid/support/v7/app/AlertDialog;

    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog;->dismiss()V

    .line 130
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$2;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->finish()V

    .line 131
    return-void
.end method
