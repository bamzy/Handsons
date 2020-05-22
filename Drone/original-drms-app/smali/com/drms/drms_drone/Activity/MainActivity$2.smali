.class Lcom/drms/drms_drone/Activity/MainActivity$2;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Activity/MainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/MainActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/MainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/MainActivity;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    const v8, 0x7f05000c

    const v7, 0x7f05000b

    const/4 v6, -0x1

    .line 84
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0x17

    if-lt v4, v5, :cond_2

    .line 85
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    const-string v5, "android.permission.ACCESS_FINE_LOCATION"

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/MainActivity;->checkSelfPermission(Ljava/lang/String;)I

    move-result v0

    .line 86
    .local v0, "permissionResult":I
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    const-string v5, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/MainActivity;->checkSelfPermission(Ljava/lang/String;)I

    move-result v1

    .line 87
    .local v1, "permissionResult2":I
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    const-string v5, "android.permission.WRITE_EXTERNAL_STORAGE"

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/MainActivity;->checkSelfPermission(Ljava/lang/String;)I

    move-result v2

    .line 89
    .local v2, "permissionResult3":I
    if-eq v0, v6, :cond_0

    if-eq v1, v6, :cond_0

    if-ne v2, v6, :cond_1

    .line 92
    :cond_0
    new-instance v3, Landroid/content/Intent;

    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    const-class v5, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 93
    .local v3, "splash_intent":Landroid/content/Intent;
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    const/4 v5, 0x0

    invoke-virtual {v4, v3, v5}, Lcom/drms/drms_drone/Activity/MainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 94
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-virtual {v4, v7, v8}, Lcom/drms/drms_drone/Activity/MainActivity;->overridePendingTransition(II)V

    .line 95
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Activity/MainActivity;->finish()V

    .line 113
    .end local v0    # "permissionResult":I
    .end local v1    # "permissionResult2":I
    .end local v2    # "permissionResult3":I
    :goto_0
    return-void

    .line 98
    .end local v3    # "splash_intent":Landroid/content/Intent;
    .restart local v0    # "permissionResult":I
    .restart local v1    # "permissionResult2":I
    .restart local v2    # "permissionResult3":I
    :cond_1
    const-string v4, "HANDLER"

    const-string v5, "OK"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 99
    new-instance v3, Landroid/content/Intent;

    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    const-class v5, Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 100
    .restart local v3    # "splash_intent":Landroid/content/Intent;
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/Activity/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 101
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-virtual {v4, v7, v8}, Lcom/drms/drms_drone/Activity/MainActivity;->overridePendingTransition(II)V

    .line 102
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Activity/MainActivity;->finish()V

    goto :goto_0

    .line 107
    .end local v0    # "permissionResult":I
    .end local v1    # "permissionResult2":I
    .end local v2    # "permissionResult3":I
    .end local v3    # "splash_intent":Landroid/content/Intent;
    :cond_2
    new-instance v3, Landroid/content/Intent;

    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    const-class v5, Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 108
    .restart local v3    # "splash_intent":Landroid/content/Intent;
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/Activity/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 109
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-virtual {v4, v7, v8}, Lcom/drms/drms_drone/Activity/MainActivity;->overridePendingTransition(II)V

    .line 110
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/MainActivity$2;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Activity/MainActivity;->finish()V

    goto :goto_0
.end method
