.class public Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "JoystickSettingActivity.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "JoystickSettingActivity"


# instance fields
.field private bottomSetting:Landroid/widget/LinearLayout;

.field private isSettingmenu:[Z

.field private mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

.field private optionMenu:[Landroid/widget/LinearLayout;

.field private optionMenuTouchListener:Landroid/view/View$OnTouchListener;

.field private optionText:[Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x2

    .line 20
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 25
    new-array v0, v1, [Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->optionMenu:[Landroid/widget/LinearLayout;

    .line 26
    new-array v0, v1, [Landroid/widget/TextView;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->optionText:[Landroid/widget/TextView;

    .line 62
    const/4 v0, 0x3

    new-array v0, v0, [Z

    fill-array-data v0, :array_0

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->isSettingmenu:[Z

    .line 63
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;-><init>(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->optionMenuTouchListener:Landroid/view/View$OnTouchListener;

    return-void

    .line 62
    :array_0
    .array-data 1
        0x0t
        0x0t
        0x0t
    .end array-data
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->isSettingmenu:[Z

    return-object v0
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)Lcom/drms/drms_drone/Sound/SoundManager;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    return-object v0
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->optionMenu:[Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->bottomSetting:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method private initializeView()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v4, -0x1

    .line 42
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->optionMenu:[Landroid/widget/LinearLayout;

    const v2, 0x7f0d0081

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    aput-object v2, v3, v5

    .line 43
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->optionMenu:[Landroid/widget/LinearLayout;

    const v2, 0x7f0d0083

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    aput-object v2, v3, v6

    .line 45
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->optionText:[Landroid/widget/TextView;

    const v2, 0x7f0d0082

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    aput-object v2, v3, v5

    .line 46
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->optionText:[Landroid/widget/TextView;

    const v2, 0x7f0d0084

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    aput-object v2, v3, v6

    .line 48
    const v2, 0x7f0d0085

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->bottomSetting:Landroid/widget/LinearLayout;

    .line 50
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->optionText:[Landroid/widget/TextView;

    array-length v2, v2

    if-ge v0, v2, :cond_0

    .line 51
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->optionText:[Landroid/widget/TextView;

    aget-object v2, v2, v0

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->optionMenuTouchListener:Landroid/view/View$OnTouchListener;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 50
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 53
    :cond_0
    new-instance v2, Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-direct {v2, p0}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 55
    new-instance v1, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;

    invoke-direct {v1, p0, p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    .line 56
    .local v1, "setting1":Landroid/view/View;
    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v2, v4, v4}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 57
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->bottomSetting:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 59
    return-void
.end method


# virtual methods
.method public finish()V
    .locals 2

    .prologue
    .line 123
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->finish()V

    .line 124
    const v0, 0x7f05000c

    const v1, 0x7f05000e

    invoke-virtual {p0, v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->overridePendingTransition(II)V

    .line 125
    return-void
.end method

.method public onBackPressed()V
    .locals 0

    .prologue
    .line 129
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onBackPressed()V

    .line 130
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->finish()V

    .line 131
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 32
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 33
    const v0, 0x7f040022

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->setContentView(I)V

    .line 34
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x1002

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 38
    invoke-direct {p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->initializeView()V

    .line 39
    return-void
.end method
