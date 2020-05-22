.class public Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "WaitActivity.java"


# static fields
.field public static final REQUEST_MAIN_THREAD:I = 0x1


# instance fields
.field private count:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 42
    const/4 v0, 0x0

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;->count:I

    return-void
.end method


# virtual methods
.method public finish()V
    .locals 2

    .prologue
    .line 50
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->finish()V

    .line 51
    const v0, 0x7f05000c

    const v1, 0x7f05000a

    invoke-virtual {p0, v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;->overridePendingTransition(II)V

    .line 52
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 24
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 25
    const v0, 0x7f040026

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;->setContentView(I)V

    .line 27
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x1002

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 32
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity$1;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity$1;-><init>(Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;)V

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 40
    return-void
.end method

.method protected onStop()V
    .locals 0

    .prologue
    .line 45
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStop()V

    .line 46
    return-void
.end method
