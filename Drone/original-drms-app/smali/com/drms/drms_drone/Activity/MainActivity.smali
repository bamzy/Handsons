.class public Lcom/drms/drms_drone/Activity/MainActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "MainActivity.java"


# static fields
.field private static final PERMISSION_RESULT_OK:I = 0x1

.field private static final REQUEST_PERMISSION:I


# instance fields
.field private alpha:I

.field private count:I

.field private isSplash:Z

.field private logo:Landroid/widget/TextView;

.field private mHandler:Landroid/os/Handler;

.field private nextActivityRunnable:Ljava/lang/Runnable;

.field private version:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 20
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 29
    iput-boolean v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->isSplash:Z

    .line 30
    iput v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->alpha:I

    .line 31
    iput v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->count:I

    .line 79
    new-instance v0, Lcom/drms/drms_drone/Activity/MainActivity$2;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Activity/MainActivity$2;-><init>(Lcom/drms/drms_drone/Activity/MainActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->nextActivityRunnable:Ljava/lang/Runnable;

    return-void
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Activity/MainActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/MainActivity;

    .prologue
    .line 20
    iget-boolean v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->isSplash:Z

    return v0
.end method

.method static synthetic access$002(Lcom/drms/drms_drone/Activity/MainActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/MainActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 20
    iput-boolean p1, p0, Lcom/drms/drms_drone/Activity/MainActivity;->isSplash:Z

    return p1
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Activity/MainActivity;)I
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/MainActivity;

    .prologue
    .line 20
    iget v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->alpha:I

    return v0
.end method

.method static synthetic access$102(Lcom/drms/drms_drone/Activity/MainActivity;I)I
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/MainActivity;
    .param p1, "x1"    # I

    .prologue
    .line 20
    iput p1, p0, Lcom/drms/drms_drone/Activity/MainActivity;->alpha:I

    return p1
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Activity/MainActivity;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/MainActivity;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->logo:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Activity/MainActivity;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/MainActivity;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->nextActivityRunnable:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Activity/MainActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/MainActivity;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->mHandler:Landroid/os/Handler;

    return-object v0
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 118
    invoke-super {p0, p1, p2, p3}, Landroid/support/v7/app/AppCompatActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 119
    if-nez p1, :cond_0

    .line 120
    const/4 v1, 0x1

    if-ne p2, v1, :cond_0

    .line 121
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 122
    .local v0, "startIntent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 123
    const v1, 0x7f05000b

    const v2, 0x7f05000c

    invoke-virtual {p0, v1, v2}, Lcom/drms/drms_drone/Activity/MainActivity;->overridePendingTransition(II)V

    .line 124
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/MainActivity;->finish()V

    .line 128
    .end local v0    # "startIntent":Landroid/content/Intent;
    :cond_0
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 132
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onBackPressed()V

    .line 133
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->isSplash:Z

    .line 134
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/MainActivity;->finish()V

    .line 135
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 38
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 39
    const v0, 0x7f040023

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/MainActivity;->setContentView(I)V

    .line 41
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/MainActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x1002

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 46
    const v0, 0x7f0d0087

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->version:Landroid/widget/TextView;

    .line 47
    const v0, 0x7f0d0086

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->logo:Landroid/widget/TextView;

    .line 49
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->mHandler:Landroid/os/Handler;

    .line 51
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->version:Landroid/widget/TextView;

    const-string v1, "v 2.0.3"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 54
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/drms/drms_drone/Activity/MainActivity;->isSplash:Z

    .line 55
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/drms/drms_drone/Activity/MainActivity$1;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Activity/MainActivity$1;-><init>(Lcom/drms/drms_drone/Activity/MainActivity;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 76
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 77
    return-void
.end method
