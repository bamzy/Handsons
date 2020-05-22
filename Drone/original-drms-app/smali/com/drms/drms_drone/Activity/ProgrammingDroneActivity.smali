.class public Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "ProgrammingDroneActivity.java"


# static fields
.field private static ProgramHandler:Landroid/os/Handler; = null

.field private static final TAG:Ljava/lang/String; = "ProgrammingDrone"


# instance fields
.field private final BTConnection:Landroid/content/ServiceConnection;

.field private mBTService:Lcom/drms/drms_drone/Service/BTService;

.field private mspdata:Lcom/drms/drms_drone/MultiData;

.field private programDroneRecevier:Landroid/content/BroadcastReceiver;

.field private running:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 71
    new-instance v0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$2;

    invoke-direct {v0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$2;-><init>()V

    sput-object v0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->ProgramHandler:Landroid/os/Handler;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 33
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->running:Z

    .line 78
    new-instance v0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$3;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$3;-><init>(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->BTConnection:Landroid/content/ServiceConnection;

    .line 119
    new-instance v0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$4;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$4;-><init>(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->programDroneRecevier:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    .prologue
    .line 28
    iget-boolean v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->running:Z

    return v0
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)Lcom/drms/drms_drone/MultiData;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    return-object v0
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)Lcom/drms/drms_drone/Service/BTService;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    return-object v0
.end method

.method static synthetic access$202(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;
    .param p1, "x1"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    return-object p1
.end method

.method static synthetic access$300()Landroid/os/Handler;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->ProgramHandler:Landroid/os/Handler;

    return-object v0
.end method

.method private setFilter()V
    .locals 2

    .prologue
    .line 95
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 96
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string v1, "android.intent.action.BATTERY_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 97
    const-string v1, "disconnected bluetooth in Service"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 99
    const-string v1, "arduino reset"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 101
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->programDroneRecevier:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 102
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
    .line 106
    .local p1, "service":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 107
    .local v4, "startService":Landroid/content/Intent;
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Landroid/os/Bundle;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    .line 108
    invoke-virtual {p3}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v3

    .line 109
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

    .line 110
    .local v2, "key":Ljava/lang/String;
    invoke-virtual {p3, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 111
    .local v1, "extra":Ljava/lang/String;
    invoke-virtual {v4, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 115
    .end local v1    # "extra":Ljava/lang/String;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 116
    .local v0, "bindingIntent":Landroid/content/Intent;
    const/4 v5, 0x1

    invoke-virtual {p0, v0, p2, v5}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 117
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 37
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 38
    const v0, 0x7f040024

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->setContentView(I)V

    .line 40
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 42
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$1;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$1;-><init>(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 52
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 53
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 65
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onPause()V

    .line 66
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->BTConnection:Landroid/content/ServiceConnection;

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 67
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->running:Z

    .line 68
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->programDroneRecevier:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 69
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    .line 57
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onResume()V

    .line 58
    invoke-direct {p0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->setFilter()V

    .line 59
    const-class v0, Lcom/drms/drms_drone/Service/BTService;

    iget-object v1, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->BTConnection:Landroid/content/ServiceConnection;

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->startService(Ljava/lang/Class;Landroid/content/ServiceConnection;Landroid/os/Bundle;)V

    .line 60
    const-string v0, "ProgrammingDrone"

    const-string v1, "programDrone Service"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 61
    return-void
.end method
