.class public Lcom/drms/drms_drone/Activity/CheckPermissionActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "CheckPermissionActivity.java"


# static fields
.field private static final ALLPERMISSION_GRANGTED:I = 0x0

.field private static final PERMISSION_RESULT_OK:I = 0x1

.field private static final REQUEST_PERMISSION:I = 0x0

.field public static final REQUEST_TUTORIAL:Ljava/lang/String; = "requset tutorial"


# instance fields
.field private checkPermission:Landroid/widget/Button;

.field private mHandler:Landroid/os/Handler;

.field private running:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 29
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 30
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->running:Z

    .line 147
    new-instance v0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$3;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$3;-><init>(Lcom/drms/drms_drone/Activity/CheckPermissionActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->mHandler:Landroid/os/Handler;

    return-void
.end method

.method static synthetic access$002(Lcom/drms/drms_drone/Activity/CheckPermissionActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/CheckPermissionActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 29
    iput-boolean p1, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->running:Z

    return p1
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/16 v1, 0x400

    .line 40
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 42
    const v0, 0x7f04001b

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->setContentView(I)V

    .line 44
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/ActionBar;->hide()V

    .line 46
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Landroid/view/Window;->setFlags(II)V

    .line 48
    const v0, 0x7f0d005e

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->checkPermission:Landroid/widget/Button;

    .line 49
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->checkPermission:Landroid/widget/Button;

    new-instance v1, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$1;-><init>(Lcom/drms/drms_drone/Activity/CheckPermissionActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 99
    return-void
.end method

.method public onRequestPermissionsResult(I[Ljava/lang/String;[I)V
    .locals 8
    .param p1, "requestCode"    # I
    .param p2, "permissions"    # [Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p3, "grantResults"    # [I
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    const/4 v6, 0x1

    .line 103
    invoke-super {p0, p1, p2, p3}, Landroid/support/v7/app/AppCompatActivity;->onRequestPermissionsResult(I[Ljava/lang/String;[I)V

    .line 104
    const/16 v3, 0x3e8

    if-ne p1, v3, :cond_0

    .line 105
    const/4 v3, 0x0

    aget v3, p3, v3

    if-nez v3, :cond_1

    aget v3, p3, v6

    if-nez v3, :cond_1

    const/4 v3, 0x2

    aget v3, p3, v3

    if-nez v3, :cond_1

    .line 107
    const-wide/16 v4, 0x12c

    :try_start_0
    invoke-static {v4, v5}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 110
    :goto_0
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {v2, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 111
    .local v2, "intent":Landroid/content/Intent;
    const-string v3, "requset tutorial"

    invoke-virtual {v2, v3, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 112
    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->startActivity(Landroid/content/Intent;)V

    .line 113
    const v3, 0x7f05000b

    const v4, 0x7f05000c

    invoke-virtual {p0, v3, v4}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->overridePendingTransition(II)V

    .line 114
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->finish()V

    .line 136
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_0
    :goto_1
    return-void

    .line 117
    :cond_1
    new-instance v1, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v1, p0}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 118
    .local v1, "dialog":Landroid/support/v7/app/AlertDialog$Builder;
    const-string v3, "\uacbd\uace0"

    invoke-virtual {v1, v3}, Landroid/support/v7/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 119
    const-string v3, "\uad8c\ud55c\uc744 \ud5c8\uc6a9\ud558\uc9c0 \uc54a\uc544 \uc5b4\ud50c\ub9ac\ucf00\uc774\uc158\uc744 \uc885\ub8cc\ud569\ub2c8\ub2e4."

    invoke-virtual {v1, v3}, Landroid/support/v7/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 122
    invoke-virtual {v1}, Landroid/support/v7/app/AlertDialog$Builder;->create()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    .line 123
    .local v0, "ad":Landroid/support/v7/app/AlertDialog;
    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog;->show()V

    .line 126
    new-instance v3, Landroid/os/Handler;

    invoke-direct {v3}, Landroid/os/Handler;-><init>()V

    new-instance v4, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$2;

    invoke-direct {v4, p0, v0}, Lcom/drms/drms_drone/Activity/CheckPermissionActivity$2;-><init>(Lcom/drms/drms_drone/Activity/CheckPermissionActivity;Landroid/support/v7/app/AlertDialog;)V

    const-wide/16 v6, 0x3e8

    invoke-virtual {v3, v4, v6, v7}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_1

    .line 108
    .end local v0    # "ad":Landroid/support/v7/app/AlertDialog;
    .end local v1    # "dialog":Landroid/support/v7/app/AlertDialog$Builder;
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 141
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStop()V

    .line 143
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Activity/CheckPermissionActivity;->running:Z

    .line 144
    return-void
.end method
