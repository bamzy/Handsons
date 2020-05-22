.class public Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "JoystickActivity.java"


# static fields
.field public static final REQUEST_JOYSTICK_MENU:I = 0x0

.field public static final REQUEST_WAIT:I = 0x0

.field private static final TAG:Ljava/lang/String; = "JoystickActivity"


# instance fields
.field private final BTConnection:Landroid/content/ServiceConnection;

.field private Joystick1_drawer_layout:Landroid/support/v4/widget/DrawerLayout;

.field private JoystickHandler:Landroid/os/Handler;

.field private JoystickReceiver:Landroid/content/BroadcastReceiver;

.field battery_level:I

.field private joystick_layout:Landroid/widget/LinearLayout;

.field private mBTService:Lcom/drms/drms_drone/Service/BTService;

.field private mDrsControllerView:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

.field private mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

.field private mSingleJoystickView:Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

.field private mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

.field private mspdata:Lcom/drms/drms_drone/MultiData;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 58
    const/4 v0, 0x0

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->battery_level:I

    .line 107
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;-><init>(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->BTConnection:Landroid/content/ServiceConnection;

    .line 136
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;-><init>(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->JoystickHandler:Landroid/os/Handler;

    .line 228
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;-><init>(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->JoystickReceiver:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Service/BTService;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    return-object v0
.end method

.method static synthetic access$002(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
    .param p1, "x1"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    return-object p1
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->JoystickHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/MultiData;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    return-object v0
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    return-object v0
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mSingleJoystickView:Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

    return-object v0
.end method

.method static synthetic access$500(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDrsControllerView:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    return-object v0
.end method

.method static synthetic access$600(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->implementationJoystickSettingMenu()V

    return-void
.end method

.method static synthetic access$700(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->updateJoystick(Ljava/lang/String;)V

    return-void
.end method

.method private implementationJoystickSettingMenu()V
    .locals 3

    .prologue
    .line 300
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 301
    .local v0, "settingIntent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->startActivity(Landroid/content/Intent;)V

    .line 302
    const v1, 0x7f05000d

    const v2, 0x7f05000c

    invoke-virtual {p0, v1, v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->overridePendingTransition(II)V

    .line 303
    return-void
.end method

.method private setFilter()V
    .locals 2

    .prologue
    .line 276
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 277
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string v1, "android.intent.action.BATTERY_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 278
    const-string v1, "disconnected bluetooth in Service"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 279
    const-string v1, "request dual1"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 280
    const-string v1, "request dual2"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 281
    const-string v1, "request single"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 282
    const-string v1, "arduino reset"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 283
    const-string v1, "com.drms.drms_drone.PREVIOUS_DISPLAY"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 284
    const-string v1, "con.drms.drms_drone.NEXT_DISPLAY"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 286
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->JoystickReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 287
    return-void
.end method

.method private startService(Ljava/lang/Class;Landroid/content/ServiceConnection;Landroid/os/Bundle;)V
    .locals 7
    .param p2, "serviceConnection"    # Landroid/content/ServiceConnection;
    .param p3, "extras"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Landroid/content/ServiceConnection;",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .prologue
    .line 215
    .local p1, "service":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 216
    .local v4, "startService":Landroid/content/Intent;
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Landroid/os/Bundle;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    .line 217
    invoke-virtual {p3}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v3

    .line 218
    .local v3, "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 219
    .local v2, "key":Ljava/lang/String;
    invoke-virtual {p3, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 220
    .local v1, "extra":Ljava/lang/String;
    invoke-virtual {v4, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 224
    .end local v1    # "extra":Ljava/lang/String;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 225
    .local v0, "bindingIntent":Landroid/content/Intent;
    const/4 v5, 0x1

    invoke-virtual {p0, v0, p2, v5}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 226
    return-void
.end method

.method private updateJoystick(Ljava/lang/String;)V
    .locals 3
    .param p1, "request"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 306
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    if-eqz v0, :cond_0

    .line 307
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->joystick_layout:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 308
    iput-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    .line 309
    iput-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mSingleJoystickView:Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

    .line 311
    :cond_0
    const-string v0, "request dual1"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 312
    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->setRequestedOrientation(I)V

    .line 313
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->JoystickHandler:Landroid/os/Handler;

    invoke-direct {v0, p0, p0, v1}, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;-><init>(Landroid/content/Context;Landroid/app/Activity;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    .line 314
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->joystick_layout:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 315
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->setmBluetoothService(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V

    .line 330
    :cond_1
    :goto_0
    return-void

    .line 317
    :cond_2
    const-string v0, "request dual2"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 318
    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->setRequestedOrientation(I)V

    .line 319
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->JoystickHandler:Landroid/os/Handler;

    invoke-direct {v0, p0, p0, v1}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;-><init>(Landroid/content/Context;Landroid/app/Activity;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    .line 320
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->joystick_layout:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 321
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->setmBluetoothService(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V

    goto :goto_0

    .line 324
    :cond_3
    const-string v0, "request single"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 325
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->setRequestedOrientation(I)V

    .line 326
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mSingleJoystickView:Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

    .line 327
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->joystick_layout:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mSingleJoystickView:Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_0
.end method


# virtual methods
.method public finish()V
    .locals 2

    .prologue
    .line 343
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->finish()V

    .line 344
    const v0, 0x7f05000c

    const v1, 0x7f05000a

    invoke-virtual {p0, v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->overridePendingTransition(II)V

    .line 345
    return-void
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 0
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 334
    invoke-super {p0, p1, p2, p3}, Landroid/support/v7/app/AppCompatActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 336
    if-nez p1, :cond_0

    .line 339
    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v2, -0x1

    .line 64
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 65
    const v0, 0x7f040021

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->setContentView(I)V

    .line 67
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x1002

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 74
    const v0, 0x7f0d0080

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->joystick_layout:Landroid/widget/LinearLayout;

    .line 75
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 78
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->isControllerConnected()Z

    move-result v0

    if-nez v0, :cond_3

    .line 79
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    if-nez v0, :cond_1

    .line 80
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->JoystickHandler:Landroid/os/Handler;

    invoke-direct {v0, p0, p0, v1}, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;-><init>(Landroid/content/Context;Landroid/app/Activity;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    .line 81
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 82
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->joystick_layout:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 99
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x80

    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 101
    new-instance v0, Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 105
    return-void

    .line 83
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    .line 84
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->JoystickHandler:Landroid/os/Handler;

    invoke-direct {v0, p0, p0, v1}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;-><init>(Landroid/content/Context;Landroid/app/Activity;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    .line 85
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 86
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->joystick_layout:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 87
    :cond_2
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 88
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mSingleJoystickView:Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

    .line 89
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->joystick_layout:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mSingleJoystickView:Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 93
    :cond_3
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->JoystickHandler:Landroid/os/Handler;

    invoke-direct {v0, p0, p0, v1}, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;-><init>(Landroid/content/Context;Landroid/app/Activity;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDrsControllerView:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    .line 94
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDrsControllerView:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 95
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->joystick_layout:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDrsControllerView:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 0

    .prologue
    .line 349
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onDestroy()V

    .line 351
    return-void
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 291
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 293
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->finish()V

    .line 295
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method protected onPause()V
    .locals 3

    .prologue
    .line 185
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onPause()V

    .line 189
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->BTConnection:Landroid/content/ServiceConnection;

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 190
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_0
    const/4 v1, 0x5

    if-ge v0, v1, :cond_0

    .line 191
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v2, 0x3e8

    invoke-virtual {v1, v0, v2}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 190
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 193
    :cond_0
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->initializeMultiData()V

    .line 199
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    .line 170
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onResume()V

    .line 172
    invoke-direct {p0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->setFilter()V

    .line 173
    const-class v0, Lcom/drms/drms_drone/Service/BTService;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->BTConnection:Landroid/content/ServiceConnection;

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->startService(Ljava/lang/Class;Landroid/content/ServiceConnection;Landroid/os/Bundle;)V

    .line 176
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    if-eqz v0, :cond_0

    .line 180
    :cond_0
    const-string v0, "JoystickActivity"

    const-string v1, "start on"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 181
    return-void
.end method

.method protected onStop()V
    .locals 2

    .prologue
    .line 203
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStop()V

    .line 204
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->JoystickReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 205
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    if-eqz v0, :cond_0

    .line 206
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorManager()Landroid/hardware/SensorManager;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorEventListener()Landroid/hardware/SensorEventListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 207
    const-string v0, "JoystickActivity"

    const-string v1, "unregister Listener"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 208
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorManager()Landroid/hardware/SensorManager;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->mDualJoystickView:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorEventListener()Landroid/hardware/SensorEventListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;)V

    .line 211
    :cond_0
    return-void
.end method
