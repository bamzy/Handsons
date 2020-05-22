.class Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1$2;
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
    .line 66
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1$2;->this$1:Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 69
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_0

    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1$2;->this$1:Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;

    iget-object v0, v0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;->this$0:Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "android.permission.WRITE_EXTERNAL_STORAGE"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "android.permission.ACCESS_COARSE_LOCATION"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "android.permission.ACCESS_FINE_LOCATION"

    aput-object v3, v1, v2

    const/16 v2, 0x3e8

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->requestPermissions([Ljava/lang/String;I)V

    .line 76
    :cond_0
    return-void
.end method
