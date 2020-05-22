.class public Lcom/drms/drms_drone/Service/BTService;
.super Landroid/app/Service;
.source "BTService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;,
        Lcom/drms/drms_drone/Service/BTService$BtBinder;
    }
.end annotation


# static fields
.field public static final ArduinoReset:Ljava/lang/String; = "arduino reset"

.field public static final BLUETOOTH_ADDRESS:Ljava/lang/String; = "bluetooth address"

.field public static final CONNECTED_BLUETOOTH:Ljava/lang/String; = "connected bluetooth in Service"

.field public static final CONTROLLER:I = 0x1

.field public static final D:Z = true

.field public static final DISCONNECTED_BLUETOOTH:Ljava/lang/String; = "disconnected bluetooth in Service"

.field public static final DISCOVER_BT:Ljava/lang/String; = "discover bluetooth"

.field public static final DISCOVER_FAILED:Ljava/lang/String; = "discovr failed"

.field public static DISCOVER_LOOP:J = 0x0L

.field public static final FAILED_BLUETOOTH:Ljava/lang/String; = "failed bluetooth in Service"

.field public static final MAINACTIVITY:I = 0x0

.field private static final MESSAGE_READ:I = 0x3

.field private static final MESSAGE_STATE_CHANGE:I = 0xa

.field private static final MESSAGE_WRITE:I = 0x2

.field private static final Multiwii_PROTOCOL:I = 0x66

.field public static final NEXT_DISPLAY:Ljava/lang/String; = "con.drms.drms_drone.NEXT_DISPLAY"

.field public static final NOTHIHG:I = -0x1

.field public static final PREVIOUS_DISPLAY:Ljava/lang/String; = "com.drms.drms_drone.PREVIOUS_DISPLAY"

.field public static final PROGRAMDRONE:I = 0x4

.field public static final REQUEST_ACC_CALIBRATION:Ljava/lang/String; = "request acc calibration"

.field public static final REQUEST_BOX_SETTING:Ljava/lang/String; = "request box setting"

.field public static final REQUEST_CONNECT_BT:Ljava/lang/String; = "request_connect_bt"

.field private static final REQUEST_CONNECT_DEVICE:I = 0x1

.field public static final REQUEST_DISPLAY_CONTROLLER:Ljava/lang/String; = "request controller display"

.field public static final REQUEST_DISPLAY_MAIN:Ljava/lang/String; = "request main display"

.field public static final REQUEST_DISPLAY_NOTHING:Ljava/lang/String; = "request nothing"

.field public static final REQUEST_DISPLAY_SETTING:Ljava/lang/String; = "request display setting"

.field public static final REQUEST_DISPLAY_UPLOAD:Ljava/lang/String; = "request upload display"

.field private static final REQUEST_ENABLE_BT:I = 0x2

.field public static final REQUEST_FINISH_SERVICE:Ljava/lang/String; = "request_finish_service"

.field public static final REQUEST_MAG_CALIBRATION:Ljava/lang/String; = "request mag calibration"

.field public static final REQUEST_MSP_SET_HEAD:Ljava/lang/String; = "reqeust set head"

.field public static final REQUEST_PID_SETTING:Ljava/lang/String; = "request pid setting"

.field public static final REQUEST_PROGRAMDRONE:Ljava/lang/String; = "request_program"

.field public static final REQUEST_RC_SETTING:Ljava/lang/String; = "request rc setting"

.field public static final REQUEST_SCAN_DEVICE:Ljava/lang/String; = "request scan device"

.field public static final SETTING:I = 0x3

.field private static final STATE_NO_SENDING:I = 0x2

.field private static final STATE_SENDING:I = 0x1

.field private static final TAG:Ljava/lang/String; = "BTService"

.field public static final UPDATE_UI:I = 0x64

.field public static final UPLOAD:I = 0x2


# instance fields
.field private BTcurrent_t:J

.field private BTprev_t:J

.field private BtHandler:Landroid/os/Handler;

.field private BtReceiver:Landroid/content/BroadcastReceiver;

.field private MSP_handler:Landroid/os/Handler;

.field public binder:Landroid/os/IBinder;

.field private bt_address:Ljava/lang/String;

.field checkData:Z

.field private count:I

.field private currentDisplay:I

.field private isDiscovered:Z

.field private isDoCalibration:Z

.field private isProcessed:Z

.field private isServiceOn:Z

.field private mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

.field private mDiscoverThread:Ljava/lang/Thread;

.field private mFilemanagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

.field private mMSP:Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

.field private mSendingState:I

.field private mainHandler:Landroid/os/Handler;

.field private mspData:Lcom/drms/drms_drone/MultiData;

.field private prev_t:J

.field private tts:Landroid/speech/tts/TextToSpeech;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 66
    const-wide/16 v0, 0x1388

    sput-wide v0, Lcom/drms/drms_drone/Service/BTService;->DISCOVER_LOOP:J

    return-void
.end method

.method public constructor <init>()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    const/4 v1, 0x0

    .line 34
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 69
    iput v1, p0, Lcom/drms/drms_drone/Service/BTService;->currentDisplay:I

    .line 95
    const-string v0, ""

    iput-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->bt_address:Ljava/lang/String;

    .line 97
    new-instance v0, Lcom/drms/drms_drone/Service/BTService$BtBinder;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Service/BTService$BtBinder;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->binder:Landroid/os/IBinder;

    .line 101
    iput-boolean v1, p0, Lcom/drms/drms_drone/Service/BTService;->isServiceOn:Z

    .line 102
    iput-boolean v1, p0, Lcom/drms/drms_drone/Service/BTService;->isDoCalibration:Z

    .line 103
    iput-boolean v1, p0, Lcom/drms/drms_drone/Service/BTService;->isDiscovered:Z

    .line 176
    new-instance v0, Lcom/drms/drms_drone/Service/BTService$2;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Service/BTService$2;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->BtHandler:Landroid/os/Handler;

    .line 243
    new-instance v0, Lcom/drms/drms_drone/Service/BTService$3;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Service/BTService$3;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->BtReceiver:Landroid/content/BroadcastReceiver;

    .line 494
    iput v1, p0, Lcom/drms/drms_drone/Service/BTService;->count:I

    .line 495
    iput-wide v2, p0, Lcom/drms/drms_drone/Service/BTService;->prev_t:J

    .line 554
    iput-boolean v1, p0, Lcom/drms/drms_drone/Service/BTService;->isProcessed:Z

    .line 630
    iput-boolean v1, p0, Lcom/drms/drms_drone/Service/BTService;->checkData:Z

    .line 725
    iput-wide v2, p0, Lcom/drms/drms_drone/Service/BTService;->BTprev_t:J

    .line 726
    iput-wide v2, p0, Lcom/drms/drms_drone/Service/BTService;->BTcurrent_t:J

    .line 727
    new-instance v0, Lcom/drms/drms_drone/Service/BTService$8;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Service/BTService$8;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->MSP_handler:Landroid/os/Handler;

    return-void
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Service/BTService;)Landroid/speech/tts/TextToSpeech;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->tts:Landroid/speech/tts/TextToSpeech;

    return-object v0
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->mMSP:Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/drms/drms_drone/Service/BTService;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->bt_address:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1002(Lcom/drms/drms_drone/Service/BTService;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService;->bt_address:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$102(Lcom/drms/drms_drone/Service/BTService;Lcom/drms/drms_drone/Protocol/Multiwii/MSP;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;
    .param p1, "x1"    # Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService;->mMSP:Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    return-object p1
.end method

.method static synthetic access$1100(Lcom/drms/drms_drone/Service/BTService;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/drms/drms_drone/Service/BTService;->implementationProgramThread()V

    return-void
.end method

.method static synthetic access$1200(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->BtHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/drms/drms_drone/Service/BTService;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-boolean v0, p0, Lcom/drms/drms_drone/Service/BTService;->isDoCalibration:Z

    return v0
.end method

.method static synthetic access$1302(Lcom/drms/drms_drone/Service/BTService;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;
    .param p1, "x1"    # Z

    .prologue
    .line 34
    iput-boolean p1, p0, Lcom/drms/drms_drone/Service/BTService;->isDoCalibration:Z

    return p1
.end method

.method static synthetic access$1400(Lcom/drms/drms_drone/Service/BTService;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/drms/drms_drone/Service/BTService;->implementationSettingThread()V

    return-void
.end method

.method static synthetic access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->mspData:Lcom/drms/drms_drone/MultiData;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->mainHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/drms/drms_drone/Service/BTService;)J
    .locals 2
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-wide v0, p0, Lcom/drms/drms_drone/Service/BTService;->prev_t:J

    return-wide v0
.end method

.method static synthetic access$1702(Lcom/drms/drms_drone/Service/BTService;J)J
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;
    .param p1, "x1"    # J

    .prologue
    .line 34
    iput-wide p1, p0, Lcom/drms/drms_drone/Service/BTService;->prev_t:J

    return-wide p1
.end method

.method static synthetic access$1802(Lcom/drms/drms_drone/Service/BTService;J)J
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;
    .param p1, "x1"    # J

    .prologue
    .line 34
    iput-wide p1, p0, Lcom/drms/drms_drone/Service/BTService;->BTprev_t:J

    return-wide p1
.end method

.method static synthetic access$1900(Lcom/drms/drms_drone/Service/BTService;)J
    .locals 2
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-wide v0, p0, Lcom/drms/drms_drone/Service/BTService;->BTcurrent_t:J

    return-wide v0
.end method

.method static synthetic access$1902(Lcom/drms/drms_drone/Service/BTService;J)J
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;
    .param p1, "x1"    # J

    .prologue
    .line 34
    iput-wide p1, p0, Lcom/drms/drms_drone/Service/BTService;->BTcurrent_t:J

    return-wide p1
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    return-object v0
.end method

.method static synthetic access$2000(Lcom/drms/drms_drone/Service/BTService;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-boolean v0, p0, Lcom/drms/drms_drone/Service/BTService;->isServiceOn:Z

    return v0
.end method

.method static synthetic access$202(Lcom/drms/drms_drone/Service/BTService;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;
    .param p1, "x1"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    return-object p1
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->MSP_handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Service/BTService;)I
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget v0, p0, Lcom/drms/drms_drone/Service/BTService;->currentDisplay:I

    return v0
.end method

.method static synthetic access$402(Lcom/drms/drms_drone/Service/BTService;I)I
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;
    .param p1, "x1"    # I

    .prologue
    .line 34
    iput p1, p0, Lcom/drms/drms_drone/Service/BTService;->currentDisplay:I

    return p1
.end method

.method static synthetic access$500(Lcom/drms/drms_drone/Service/BTService;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/drms/drms_drone/Service/BTService;->implementationMainDisplayThread()V

    return-void
.end method

.method static synthetic access$600(Lcom/drms/drms_drone/Service/BTService;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/drms/drms_drone/Service/BTService;->implementationControlThread()V

    return-void
.end method

.method static synthetic access$700(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/FileManagement/FileManagement;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->mFilemanagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    return-object v0
.end method

.method static synthetic access$800(Lcom/drms/drms_drone/Service/BTService;)Ljava/lang/Thread;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->mDiscoverThread:Ljava/lang/Thread;

    return-object v0
.end method

.method static synthetic access$802(Lcom/drms/drms_drone/Service/BTService;Ljava/lang/Thread;)Ljava/lang/Thread;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;
    .param p1, "x1"    # Ljava/lang/Thread;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService;->mDiscoverThread:Ljava/lang/Thread;

    return-object p1
.end method

.method static synthetic access$900(Lcom/drms/drms_drone/Service/BTService;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 34
    iget-boolean v0, p0, Lcom/drms/drms_drone/Service/BTService;->isDiscovered:Z

    return v0
.end method

.method static synthetic access$902(Lcom/drms/drms_drone/Service/BTService;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Service/BTService;
    .param p1, "x1"    # Z

    .prologue
    .line 34
    iput-boolean p1, p0, Lcom/drms/drms_drone/Service/BTService;->isDiscovered:Z

    return p1
.end method

.method private implementationControlThread()V
    .locals 2

    .prologue
    .line 556
    const-string v0, "BTService"

    const-string v1, "implementationControlThread"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 557
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/drms/drms_drone/Service/BTService$6;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Service/BTService$6;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 627
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 628
    return-void
.end method

.method private implementationMainDisplayThread()V
    .locals 2

    .prologue
    .line 498
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/drms/drms_drone/Service/BTService$4;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Service/BTService$4;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 529
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 530
    return-void
.end method

.method private implementationProgramThread()V
    .locals 2

    .prologue
    .line 533
    const-string v0, "BTService"

    const-string v1, "implementation Program Thread"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 534
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/drms/drms_drone/Service/BTService$5;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Service/BTService$5;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 551
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 552
    return-void
.end method

.method private implementationSettingThread()V
    .locals 2

    .prologue
    .line 632
    const-string v0, "BTService"

    const-string v1, "implementationSettingThread"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 633
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Service/BTService;->checkData:Z

    .line 634
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/drms/drms_drone/Service/BTService$7;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Service/BTService$7;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 722
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 723
    return-void
.end method

.method private setFilter()V
    .locals 2

    .prologue
    .line 463
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 464
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string v1, "request_connect_bt"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 465
    const-string v1, "request_finish_service"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 466
    const-string v1, "request main display"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 467
    const-string v1, "request_program"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 468
    const-string v1, "request controller display"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 469
    const-string v1, "request nothing"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 470
    const-string v1, "request upload display"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 471
    const-string v1, "request acc calibration"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 472
    const-string v1, "request mag calibration"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 473
    const-string v1, "reqeust set head"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 474
    const-string v1, "request display setting"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 475
    const-string v1, "request box setting"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 476
    const-string v1, "request rc setting"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 477
    const-string v1, "request pid setting"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 478
    const-string v1, "con.drms.drms_drone.NEXT_DISPLAY"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 479
    const-string v1, "com.drms.drms_drone.PREVIOUS_DISPLAY"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 482
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->BtReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/drms/drms_drone/Service/BTService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 483
    return-void
.end method


# virtual methods
.method public getCurrentDisplay()I
    .locals 1

    .prologue
    .line 853
    iget v0, p0, Lcom/drms/drms_drone/Service/BTService;->currentDisplay:I

    return v0
.end method

.method public getMspData()Lcom/drms/drms_drone/MultiData;
    .locals 1

    .prologue
    .line 837
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->mspData:Lcom/drms/drms_drone/MultiData;

    return-object v0
.end method

.method public getisDiscovered()Z
    .locals 1

    .prologue
    .line 236
    iget-boolean v0, p0, Lcom/drms/drms_drone/Service/BTService;->isDiscovered:Z

    return v0
.end method

.method public getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
    .locals 1

    .prologue
    .line 491
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    return-object v0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation

    .prologue
    .line 119
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->binder:Landroid/os/IBinder;

    return-object v0
.end method

.method public onCreate()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 130
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 131
    const-string v1, "BTService"

    const-string v2, "onCreate Service"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 132
    const-string v1, "BTService"

    const-string v2, "start BTService"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 133
    new-instance v1, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService;->BtHandler:Landroid/os/Handler;

    const-string v3, "MSP"

    invoke-direct {v1, p0, v2, v3}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;-><init>(Landroid/app/Service;Landroid/os/Handler;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .line 135
    invoke-direct {p0}, Lcom/drms/drms_drone/Service/BTService;->setFilter()V

    .line 136
    const/4 v1, 0x0

    iput v1, p0, Lcom/drms/drms_drone/Service/BTService;->currentDisplay:I

    .line 137
    invoke-virtual {p0}, Lcom/drms/drms_drone/Service/BTService;->getApplication()Landroid/app/Application;

    move-result-object v1

    check-cast v1, Lcom/drms/drms_drone/MultiData;

    iput-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->mspData:Lcom/drms/drms_drone/MultiData;

    .line 139
    const-string v1, "BTService"

    const-string v2, "start discovering"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 140
    iput-boolean v4, p0, Lcom/drms/drms_drone/Service/BTService;->isServiceOn:Z

    .line 143
    new-instance v1, Lcom/drms/drms_drone/FileManagement/FileManagement;

    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService;->mainHandler:Landroid/os/Handler;

    invoke-direct {v1, p0, v2}, Lcom/drms/drms_drone/FileManagement/FileManagement;-><init>(Landroid/content/Context;Landroid/os/Handler;)V

    iput-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->mFilemanagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    .line 144
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->mFilemanagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v1}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 145
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->mFilemanagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v1}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v1

    aget-object v1, v1, v4

    const-string v2, ""

    if-ne v1, v2, :cond_3

    .line 146
    const-string v1, ""

    iput-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->bt_address:Ljava/lang/String;

    .line 152
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->tts:Landroid/speech/tts/TextToSpeech;

    if-nez v1, :cond_1

    .line 153
    new-instance v1, Landroid/speech/tts/TextToSpeech;

    new-instance v2, Lcom/drms/drms_drone/Service/BTService$1;

    invoke-direct {v2, p0}, Lcom/drms/drms_drone/Service/BTService$1;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    invoke-direct {v1, p0, v2}, Landroid/speech/tts/TextToSpeech;-><init>(Landroid/content/Context;Landroid/speech/tts/TextToSpeech$OnInitListener;)V

    iput-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->tts:Landroid/speech/tts/TextToSpeech;

    .line 160
    :cond_1
    const-string v1, "BTService"

    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService;->bt_address:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 161
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    .line 163
    .local v0, "btAdapter":Landroid/bluetooth/BluetoothAdapter;
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->mFilemanagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v1}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 164
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->mFilemanagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v1}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v1

    aget-object v1, v1, v4

    const-string v2, ""

    if-eq v1, v2, :cond_2

    .line 165
    const-string v1, "BTService"

    const-string v2, "trying to connect BT "

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 166
    new-instance v1, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    iput-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->mDiscoverThread:Ljava/lang/Thread;

    .line 167
    iput-boolean v4, p0, Lcom/drms/drms_drone/Service/BTService;->isDiscovered:Z

    .line 168
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->mDiscoverThread:Ljava/lang/Thread;

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 174
    :cond_2
    return-void

    .line 148
    .end local v0    # "btAdapter":Landroid/bluetooth/BluetoothAdapter;
    :cond_3
    iget-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->mFilemanagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v1}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v1

    aget-object v1, v1, v4

    iput-object v1, p0, Lcom/drms/drms_drone/Service/BTService;->bt_address:Ljava/lang/String;

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 843
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Service/BTService;->isServiceOn:Z

    .line 844
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 845
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->tts:Landroid/speech/tts/TextToSpeech;

    if-eqz v0, :cond_0

    .line 846
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->tts:Landroid/speech/tts/TextToSpeech;

    invoke-virtual {v0}, Landroid/speech/tts/TextToSpeech;->shutdown()V

    .line 848
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService;->BtReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Service/BTService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 849
    const-string v0, "BTService"

    const-string v1, "onDestroy() on BTService"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 850
    return-void
.end method

.method public setCurrentDisplay(I)V
    .locals 0
    .param p1, "currentDisplay"    # I

    .prologue
    .line 857
    iput p1, p0, Lcom/drms/drms_drone/Service/BTService;->currentDisplay:I

    .line 858
    return-void
.end method

.method public setHandler(Landroid/os/Handler;)V
    .locals 0
    .param p1, "mainHandler"    # Landroid/os/Handler;

    .prologue
    .line 486
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService;->mainHandler:Landroid/os/Handler;

    .line 487
    return-void
.end method

.method public setisDiscovered(Z)V
    .locals 0
    .param p1, "isDiscovered"    # Z

    .prologue
    .line 240
    iput-boolean p1, p0, Lcom/drms/drms_drone/Service/BTService;->isDiscovered:Z

    .line 241
    return-void
.end method
