.class public Lcom/drms/drms_drone/Activity/DroneMainActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "DroneMainActivity.java"

# interfaces
.implements Landroid/view/View$OnSystemUiVisibilityChangeListener;


# static fields
.field public static final D:Z = true

.field private static DISPLAY_LOOP:I = 0x0

.field private static final MESSAGE_FROM_USBSERVERICE:I = 0xb

.field private static final MESSAGE_READ:I = 0x3

.field private static final MESSAGE_STATE_CHANGE:I = 0xa

.field private static final MESSAGE_WRITE:I = 0x2

.field public static final REQUEST_CAFE:I = 0x6

.field private static final REQUEST_CONNECT_DEVICE:I = 0x1

.field public static final REQUEST_CONTROLLER:I = 0x3

.field private static final REQUEST_ENABLE_BT:I = 0x2

.field public static final REQUEST_PROGRAMDRONE:I = 0x8

.field public static final REQUEST_SETTING:I = 0x4

.field public static final REQUEST_UPLAOD:I = 0x5

.field public static final REQUEST_WEB:I = 0x7

.field private static final STATE_NO_SENDING:I = 0x2

.field private static final STATE_SENDING:I = 0x1


# instance fields
.field private final BTConnection:Landroid/content/ServiceConnection;

.field private BT_Connecting_tries:I

.field private BtDiscoverEnable:Z

.field private MainReceiver:Landroid/content/BroadcastReceiver;

.field private TAG:Ljava/lang/String;

.field private bluetooth:Landroid/widget/ImageView;

.field private bt_address:Ljava/lang/String;

.field private bt_name:Ljava/lang/String;

.field private controller:Landroid/widget/ImageView;

.field private count_display:I

.field private device_address:Landroid/widget/TextView;

.field private device_name:Landroid/widget/TextView;

.field private etc:Landroid/widget/LinearLayout;

.field private isReqeustBTConnect:Z

.field private mBTService:Lcom/drms/drms_drone/Service/BTService;

.field private mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

.field private mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

.field private mDrawerToggle:Landroid/support/v7/app/ActionBarDrawerToggle;

.field private mEtcView:Lcom/drms/drms_drone/MainView/EtcView;

.field private mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

.field private mHandler:Landroid/os/Handler;

.field private mPlayflight:Lcom/drms/drms_drone/MainView/Playflight;

.field private mSendingState:I

.field private mSettingView:Lcom/drms/drms_drone/MainView/SettingView;

.field private mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

.field private mUploadingView:Lcom/drms/drms_drone/MainView/UploadingView;

.field private mainTouchListener:Landroid/view/View$OnTouchListener;

.field private menu:Landroid/widget/ImageView;

.field private menuIcon:Landroid/graphics/Bitmap;

.field private mspdata:Lcom/drms/drms_drone/MultiData;

.field private myDevice:Landroid/widget/TextView;

.field private playflight:Landroid/widget/LinearLayout;

.field private requestReconnect:Z

.field private setting:Landroid/widget/LinearLayout;

.field private tryConnect:Landroid/widget/ProgressBar;

.field private uploading:Landroid/widget/LinearLayout;

.field private final usbConnection:Landroid/content/ServiceConnection;

.field private usbService:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 101
    const/4 v0, 0x2

    sput v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->DISPLAY_LOOP:I

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 70
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 73
    const-class v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    .line 96
    const-string v0, ""

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_address:Ljava/lang/String;

    .line 97
    const-string v0, ""

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_name:Ljava/lang/String;

    .line 99
    iput-boolean v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->requestReconnect:Z

    .line 102
    iput v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->count_display:I

    .line 131
    iput-boolean v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->BtDiscoverEnable:Z

    .line 394
    iput-boolean v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->isReqeustBTConnect:Z

    .line 395
    new-instance v0, Lcom/drms/drms_drone/Activity/DroneMainActivity$5;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity$5;-><init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mainTouchListener:Landroid/view/View$OnTouchListener;

    .line 441
    iput v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->BT_Connecting_tries:I

    .line 443
    new-instance v0, Lcom/drms/drms_drone/Activity/DroneMainActivity$6;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity$6;-><init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mHandler:Landroid/os/Handler;

    .line 476
    new-instance v0, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity$7;-><init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->BTConnection:Landroid/content/ServiceConnection;

    .line 495
    new-instance v0, Lcom/drms/drms_drone/Activity/DroneMainActivity$8;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity$8;-><init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->usbConnection:Landroid/content/ServiceConnection;

    .line 717
    new-instance v0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;-><init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->MainReceiver:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Sound/SoundManager;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    return-object v0
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/support/v4/widget/DrawerLayout;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/MainView/Playflight;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mPlayflight:Lcom/drms/drms_drone/MainView/Playflight;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/MainView/UploadingView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mUploadingView:Lcom/drms/drms_drone/MainView/UploadingView;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/MainView/SettingView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mSettingView:Lcom/drms/drms_drone/MainView/SettingView;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->usbService:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    return-object v0
.end method

.method static synthetic access$1502(Lcom/drms/drms_drone/Activity/DroneMainActivity;Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;
    .param p1, "x1"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->usbService:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    return-object p1
.end method

.method static synthetic access$1600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ProgressBar;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->tryConnect:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$1702(Lcom/drms/drms_drone/Activity/DroneMainActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 70
    iput-boolean p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->BtDiscoverEnable:Z

    return p1
.end method

.method static synthetic access$1800(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/content/BroadcastReceiver;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->MainReceiver:Landroid/content/BroadcastReceiver;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/content/ServiceConnection;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->BTConnection:Landroid/content/ServiceConnection;

    return-object v0
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_name:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2000(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/content/ServiceConnection;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->usbConnection:Landroid/content/ServiceConnection;

    return-object v0
.end method

.method static synthetic access$202(Lcom/drms/drms_drone/Activity/DroneMainActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_name:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$2100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->controller:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$2200(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/MultiData;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    return-object v0
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_address:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$302(Lcom/drms/drms_drone/Activity/DroneMainActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_address:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/FileManagement/FileManagement;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    return-object v0
.end method

.method static synthetic access$500(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Service/BTService;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    return-object v0
.end method

.method static synthetic access$502(Lcom/drms/drms_drone/Activity/DroneMainActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;
    .param p1, "x1"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    return-object p1
.end method

.method static synthetic access$600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bluetooth:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$700(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->device_name:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$800(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->device_address:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$900(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->myDevice:Landroid/widget/TextView;

    return-object v0
.end method

.method private getBitmapSize(I)[I
    .locals 7
    .param p1, "id"    # I

    .prologue
    const/4 v6, 0x2

    .line 266
    :try_start_0
    new-instance v3, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v3}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 267
    .local v3, "option":Landroid/graphics/BitmapFactory$Options;
    const/4 v4, 0x1

    iput-boolean v4, v3, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 268
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-static {v4, p1, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 269
    const/4 v4, 0x2

    new-array v1, v4, [I

    const/4 v4, 0x0

    iget v5, v3, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    aput v5, v1, v4

    const/4 v4, 0x1

    iget v5, v3, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    aput v5, v1, v4
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .local v1, "imageSize":[I
    move-object v2, v1

    .line 276
    .end local v1    # "imageSize":[I
    .end local v3    # "option":Landroid/graphics/BitmapFactory$Options;
    .local v2, "imageSize":[I
    :goto_0
    return-object v2

    .line 274
    .end local v2    # "imageSize":[I
    :catch_0
    move-exception v0

    .line 275
    .local v0, "e":Ljava/lang/Exception;
    new-array v1, v6, [I

    fill-array-data v1, :array_0

    .restart local v1    # "imageSize":[I
    move-object v2, v1

    .line 276
    .end local v1    # "imageSize":[I
    .restart local v2    # "imageSize":[I
    goto :goto_0

    .line 275
    nop

    :array_0
    .array-data 4
        0x0
        0x0
    .end array-data
.end method

.method private implementationDrawerList()V
    .locals 7

    .prologue
    .line 281
    new-instance v0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;-><init>(Landroid/content/Context;)V

    .line 282
    .local v0, "adapter":Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;
    new-instance v4, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f030022

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    const-string v6, "\ub098\uc758 \ub514\ubc14\uc774\uc2a4"

    invoke-direct {v4, v5, v6}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;)V

    .line 283
    new-instance v4, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f030016

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    const-string v6, "\ub514\ubc14\uc774\uc2a4 \ucd08\uae30\ud654"

    invoke-direct {v4, v5, v6}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;)V

    .line 286
    const v4, 0x7f0d006d

    invoke-virtual {p0, v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    .line 287
    .local v1, "drawerlist":Landroid/widget/ListView;
    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 288
    new-instance v4, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;

    invoke-direct {v4, p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;-><init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V

    invoke-virtual {v1, v4}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 343
    const v4, 0x7f0d007d

    invoke-virtual {p0, v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 344
    .local v2, "gotoCafe":Landroid/widget/ImageView;
    new-instance v4, Lcom/drms/drms_drone/Activity/DroneMainActivity$2;

    invoke-direct {v4, p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity$2;-><init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 353
    const v4, 0x7f0d007e

    invoke-virtual {p0, v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 354
    .local v3, "gotoWeb":Landroid/widget/ImageView;
    new-instance v4, Lcom/drms/drms_drone/Activity/DroneMainActivity$3;

    invoke-direct {v4, p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity$3;-><init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 363
    return-void
.end method

.method private initLayout()V
    .locals 3

    .prologue
    const v2, 0x7f0c001f

    .line 258
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->playflight:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 259
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->setting:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 260
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->uploading:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 261
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->etc:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 262
    return-void
.end method

.method private initializeView()V
    .locals 18

    .prologue
    .line 153
    const v3, 0x7f0d0079

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->playflight:Landroid/widget/LinearLayout;

    .line 154
    const v3, 0x7f0d007a

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->setting:Landroid/widget/LinearLayout;

    .line 155
    const v3, 0x7f0d007b

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->uploading:Landroid/widget/LinearLayout;

    .line 156
    const v3, 0x7f0d007c

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->etc:Landroid/widget/LinearLayout;

    .line 158
    new-instance v3, Lcom/drms/drms_drone/MainView/Playflight;

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v3, v0, v1}, Lcom/drms/drms_drone/MainView/Playflight;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mPlayflight:Lcom/drms/drms_drone/MainView/Playflight;

    .line 159
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mPlayflight:Lcom/drms/drms_drone/MainView/Playflight;

    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v5, -0x1

    const/4 v6, -0x1

    invoke-direct {v4, v5, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v4}, Lcom/drms/drms_drone/MainView/Playflight;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 160
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->playflight:Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mPlayflight:Lcom/drms/drms_drone/MainView/Playflight;

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 161
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->playflight:Landroid/widget/LinearLayout;

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->invalidate()V

    .line 163
    new-instance v3, Lcom/drms/drms_drone/MainView/SettingView;

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v3, v0, v1}, Lcom/drms/drms_drone/MainView/SettingView;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mSettingView:Lcom/drms/drms_drone/MainView/SettingView;

    .line 164
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mSettingView:Lcom/drms/drms_drone/MainView/SettingView;

    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v5, -0x1

    const/4 v6, -0x1

    invoke-direct {v4, v5, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v4}, Lcom/drms/drms_drone/MainView/SettingView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 165
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->setting:Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mSettingView:Lcom/drms/drms_drone/MainView/SettingView;

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 166
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mSettingView:Lcom/drms/drms_drone/MainView/SettingView;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MainView/SettingView;->invalidate()V

    .line 168
    new-instance v3, Lcom/drms/drms_drone/MainView/UploadingView;

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v3, v0, v1}, Lcom/drms/drms_drone/MainView/UploadingView;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mUploadingView:Lcom/drms/drms_drone/MainView/UploadingView;

    .line 169
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mUploadingView:Lcom/drms/drms_drone/MainView/UploadingView;

    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v5, -0x1

    const/4 v6, -0x1

    invoke-direct {v4, v5, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v4}, Lcom/drms/drms_drone/MainView/UploadingView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 170
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->uploading:Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mUploadingView:Lcom/drms/drms_drone/MainView/UploadingView;

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 171
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mUploadingView:Lcom/drms/drms_drone/MainView/UploadingView;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MainView/UploadingView;->invalidate()V

    .line 173
    new-instance v3, Lcom/drms/drms_drone/MainView/EtcView;

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v3, v0, v1}, Lcom/drms/drms_drone/MainView/EtcView;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mEtcView:Lcom/drms/drms_drone/MainView/EtcView;

    .line 174
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mEtcView:Lcom/drms/drms_drone/MainView/EtcView;

    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v5, -0x1

    const/4 v6, -0x1

    invoke-direct {v4, v5, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v4}, Lcom/drms/drms_drone/MainView/EtcView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 175
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->etc:Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mEtcView:Lcom/drms/drms_drone/MainView/EtcView;

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 176
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mEtcView:Lcom/drms/drms_drone/MainView/EtcView;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MainView/EtcView;->invalidate()V

    .line 178
    const v3, 0x7f0d0077

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->controller:Landroid/widget/ImageView;

    .line 179
    invoke-virtual/range {p0 .. p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f03000e

    invoke-static {v3, v4}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v14

    .line 180
    .local v14, "cont_temp":Landroid/graphics/Bitmap;
    invoke-virtual {v14}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    invoke-virtual {v14}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    sget-object v5, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v3, v4, v5}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v17

    .line 181
    .local v17, "notcontroller":Landroid/graphics/Bitmap;
    new-instance v2, Landroid/graphics/Canvas;

    move-object/from16 v0, v17

    invoke-direct {v2, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 182
    .local v2, "notContCanvas":Landroid/graphics/Canvas;
    new-instance v7, Landroid/graphics/Paint;

    invoke-direct {v7}, Landroid/graphics/Paint;-><init>()V

    .line 183
    .local v7, "paint":Landroid/graphics/Paint;
    const/high16 v3, 0x41000000    # 8.0f

    invoke-virtual {v7, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 184
    invoke-virtual/range {p0 .. p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0029

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v7, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 187
    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v2, v14, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 188
    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v2}, Landroid/graphics/Canvas;->getWidth()I

    move-result v5

    int-to-float v5, v5

    invoke-virtual {v2}, Landroid/graphics/Canvas;->getHeight()I

    move-result v6

    int-to-float v6, v6

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 189
    invoke-virtual {v2}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    int-to-float v3, v3

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v2}, Landroid/graphics/Canvas;->getHeight()I

    move-result v6

    int-to-float v6, v6

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 191
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->controller:Landroid/widget/ImageView;

    new-instance v4, Landroid/graphics/drawable/BitmapDrawable;

    move-object/from16 v0, v17

    invoke-direct {v4, v0}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/graphics/Bitmap;)V

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 194
    const v3, 0x7f0d0075

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->menu:Landroid/widget/ImageView;

    .line 195
    const v3, 0x7f030014

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getBitmapSize(I)[I

    move-result-object v16

    .line 196
    .local v16, "imageSize":[I
    const/4 v3, 0x0

    aget v3, v16, v3

    const/4 v4, 0x1

    aget v4, v16, v4

    sget-object v5, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v3, v4, v5}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->menuIcon:Landroid/graphics/Bitmap;

    .line 197
    new-instance v8, Landroid/graphics/Canvas;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->menuIcon:Landroid/graphics/Bitmap;

    invoke-direct {v8, v3}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 198
    .local v8, "canvas":Landroid/graphics/Canvas;
    new-instance v13, Landroid/graphics/Paint;

    invoke-direct {v13}, Landroid/graphics/Paint;-><init>()V

    .line 199
    .local v13, "menuIconPaint":Landroid/graphics/Paint;
    const/high16 v3, 0x41000000    # 8.0f

    invoke-virtual {v13, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 200
    invoke-virtual/range {p0 .. p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0028

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v13, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 202
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_0
    const/4 v3, 0x3

    if-ge v15, v3, :cond_0

    .line 203
    invoke-virtual {v8}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x5

    int-to-float v9, v3

    invoke-virtual {v8}, Landroid/graphics/Canvas;->getHeight()I

    move-result v3

    add-int/lit8 v4, v15, 0x1

    mul-int/2addr v3, v4

    div-int/lit8 v3, v3, 0x4

    int-to-float v10, v3

    invoke-virtual {v8}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    mul-int/lit8 v3, v3, 0x4

    div-int/lit8 v3, v3, 0x5

    int-to-float v11, v3

    invoke-virtual {v8}, Landroid/graphics/Canvas;->getHeight()I

    move-result v3

    add-int/lit8 v4, v15, 0x1

    mul-int/2addr v3, v4

    div-int/lit8 v3, v3, 0x4

    int-to-float v12, v3

    invoke-virtual/range {v8 .. v13}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 202
    add-int/lit8 v15, v15, 0x1

    goto :goto_0

    .line 206
    :cond_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->menu:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->menuIcon:Landroid/graphics/Bitmap;

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 207
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->menu:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mainTouchListener:Landroid/view/View$OnTouchListener;

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 209
    const v3, 0x7f0d006a

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bluetooth:Landroid/widget/ImageView;

    .line 210
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bluetooth:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mainTouchListener:Landroid/view/View$OnTouchListener;

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 212
    const v3, 0x7f0d0076

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ProgressBar;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->tryConnect:Landroid/widget/ProgressBar;

    .line 214
    const v3, 0x7f0d0066

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->device_name:Landroid/widget/TextView;

    .line 215
    const v3, 0x7f0d0067

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->device_address:Landroid/widget/TextView;

    .line 217
    new-instance v3, Lcom/drms/drms_drone/Sound/SoundManager;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 218
    new-instance v3, Lcom/drms/drms_drone/FileManagement/FileManagement;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mHandler:Landroid/os/Handler;

    move-object/from16 v0, p0

    invoke-direct {v3, v0, v4}, Lcom/drms/drms_drone/FileManagement/FileManagement;-><init>(Landroid/content/Context;Landroid/os/Handler;)V

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    .line 221
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "mFileManager "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 222
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v3}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 223
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v3}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    aget-object v3, v3, v4

    if-eqz v3, :cond_1

    .line 224
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v3}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    aget-object v3, v3, v4

    const-string v4, ""

    if-eq v3, v4, :cond_2

    .line 225
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v3}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    aget-object v3, v3, v4

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_name:Ljava/lang/String;

    .line 226
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v3}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    aget-object v3, v3, v4

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_address:Ljava/lang/String;

    .line 236
    :cond_1
    :goto_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "BT address : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_address:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 238
    const v3, 0x7f0d0068

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/support/v4/widget/DrawerLayout;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    .line 240
    const v3, 0x7f0d006c

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->myDevice:Landroid/widget/TextView;

    .line 241
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_name:Ljava/lang/String;

    if-eqz v3, :cond_4

    .line 242
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_address:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    const/16 v4, 0x11

    if-ne v3, v4, :cond_3

    .line 243
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->myDevice:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 253
    :goto_2
    invoke-direct/range {p0 .. p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->implementationDrawerList()V

    .line 255
    return-void

    .line 229
    :cond_2
    const-string v3, ""

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_name:Ljava/lang/String;

    .line 230
    const-string v3, ""

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_address:Ljava/lang/String;

    goto :goto_1

    .line 245
    :cond_3
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->myDevice:Landroid/widget/TextView;

    const-string v4, "No device"

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 250
    :cond_4
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->myDevice:Landroid/widget/TextView;

    const-string v4, "No device"

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2
.end method

.method private requestSettingBtDialog()V
    .locals 4

    .prologue
    .line 366
    new-instance v0, Landroid/support/v7/app/AlertDialog$Builder;

    const v1, 0x7f0a0165

    invoke-direct {v0, p0, v1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;I)V

    .line 367
    .local v0, "requestBtAddress":Landroid/support/v7/app/AlertDialog$Builder;
    const-string v1, "\ube14\ub8e8\ud22c\uc2a4 \uc7a5\uce58 \uc120\ud0dd \uc548\ub428"

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 368
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->setCancelable(Z)Landroid/support/v7/app/AlertDialog$Builder;

    .line 369
    const-string v1, "\ube14\ub8e8\ud22c\uc2a4 \uc7a5\uce58\ub97c \uc120\ud0dd\ud654\uba74\uc73c\ub85c \uc774\ub3d9\ud558\uc2dc\uaca0\uc2b5\ub2c8\uae4c?"

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v1

    const-string v2, "\ud655\uc778"

    new-instance v3, Lcom/drms/drms_drone/Activity/DroneMainActivity$4;

    invoke-direct {v3, p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity$4;-><init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V

    .line 370
    invoke-virtual {v1, v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v1

    const-string v2, "\ucde8\uc18c"

    const/4 v3, 0x0

    .line 391
    invoke-virtual {v1, v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/app/AlertDialog$Builder;->create()Landroid/support/v7/app/AlertDialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/app/AlertDialog;->show()V

    .line 392
    return-void
.end method

.method private setFilter()V
    .locals 2

    .prologue
    .line 859
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 860
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string v1, "connected bluetooth in Service"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 861
    const-string v1, "disconnected bluetooth in Service"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 862
    const-string v1, "failed bluetooth in Service"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 863
    const-string v1, "android.intent.action.CLOSE_SYSTEM_DIALOGS"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 864
    const-string v1, "discover bluetooth"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 865
    const-string v1, "discovr failed"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 866
    const-string v1, "com.felhr.usbservice.USB_PERMISSION_GRANTED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 867
    const-string v1, "com.felhr.usbservice.NO_USB"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 868
    const-string v1, "com.felhr.usbservice.USB_DISCONNECTED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 869
    const-string v1, "com.felhr.usbservice.USB_NOT_SUPPORTED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 870
    const-string v1, "com.felhr.usbservice.USB_PERMISSION_NOT_GRANTED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 871
    const-string v1, "com.drms.drms_drone.CONNECTED_CONTROLLER"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 872
    const-string v1, "con.drms.drms_drone.NEXT_DISPLAY"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 873
    const-string v1, "com.drms.drms_drone.PREVIOUS_DISPLAY"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 874
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->MainReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 875
    return-void
.end method

.method private startDiscoveringBtDevice()V
    .locals 5

    .prologue
    .line 610
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v1

    .line 611
    .local v1, "btAdapter_temp":Landroid/bluetooth/BluetoothAdapter;
    if-eqz v1, :cond_1

    .line 612
    invoke-virtual {v1}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 613
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 614
    .local v0, "action":Landroid/content/Intent;
    const-string v3, "request_connect_bt"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 615
    const-string v3, "BT"

    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_address:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 616
    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 617
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->isReqeustBTConnect:Z

    .line 628
    .end local v0    # "action":Landroid/content/Intent;
    :goto_0
    return-void

    .line 620
    :cond_0
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.bluetooth.adapter.action.REQUEST_ENABLE"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 621
    .local v2, "btEnabledIntent":Landroid/content/Intent;
    const/4 v3, 0x2

    invoke-virtual {p0, v2, v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 625
    .end local v2    # "btEnabledIntent":Landroid/content/Intent;
    :cond_1
    iget-object v3, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    const-string v4, "Bluetooth is not available"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
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
    .line 704
    .local p1, "service":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 705
    .local v4, "startService":Landroid/content/Intent;
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Landroid/os/Bundle;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    .line 706
    invoke-virtual {p3}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v3

    .line 707
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

    .line 708
    .local v2, "key":Ljava/lang/String;
    invoke-virtual {p3, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 709
    .local v1, "extra":Ljava/lang/String;
    invoke-virtual {v4, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 713
    .end local v1    # "extra":Ljava/lang/String;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 714
    .local v0, "bindingIntent":Landroid/content/Intent;
    const/4 v5, 0x1

    invoke-virtual {p0, v0, p2, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 715
    return-void
.end method


# virtual methods
.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 10
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 509
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "onActivityResult"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 510
    packed-switch p1, :pswitch_data_0

    .line 607
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 512
    :pswitch_1
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Result Code : "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 513
    const/4 v5, -0x1

    if-ne p2, v5, :cond_3

    .line 514
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v5}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 515
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v5}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x1

    aget-object v5, v5, v6

    const-string v6, ""

    if-ne v5, v6, :cond_1

    .line 516
    new-instance v4, Landroid/content/Intent;

    const-class v5, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-direct {v4, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 517
    .local v4, "scanIntent":Landroid/content/Intent;
    const/4 v5, 0x1

    invoke-virtual {p0, v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 518
    const v5, 0x7f05000b

    const v6, 0x7f05000c

    invoke-virtual {p0, v5, v6}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->overridePendingTransition(II)V

    goto :goto_0

    .line 520
    .end local v4    # "scanIntent":Landroid/content/Intent;
    :cond_1
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_address:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    const/16 v6, 0x11

    if-ne v5, v6, :cond_2

    .line 521
    const/4 v5, 0x0

    iput-boolean v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->isReqeustBTConnect:Z

    goto :goto_0

    .line 523
    :cond_2
    invoke-direct {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->requestSettingBtDialog()V

    goto :goto_0

    .line 528
    :cond_3
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    const-string v6, "Bluetooth is not enable"

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 529
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->finish()V

    goto :goto_0

    .line 534
    :pswitch_2
    const/4 v5, -0x1

    if-ne p2, v5, :cond_0

    .line 535
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    sget-object v6, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->EXTRA_DEVICE_NAME:Ljava/lang/String;

    invoke-virtual {p3, v6}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    sget-object v7, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->EXTRA_DEVICE_ADDRESS:Ljava/lang/String;

    invoke-virtual {p3, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lcom/drms/drms_drone/FileManagement/FileManagement;->writeBtAddressOnFile(Ljava/lang/String;Ljava/lang/String;)Z

    .line 537
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v5}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x1

    aget-object v5, v5, v6

    iput-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_address:Ljava/lang/String;

    .line 538
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->myDevice:Landroid/widget/TextView;

    iget-object v6, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v6}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    aget-object v6, v6, v7

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 539
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v5}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    aget-object v5, v5, v6

    iput-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_name:Ljava/lang/String;

    .line 542
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bt_address:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    const/16 v6, 0x11

    if-ne v5, v6, :cond_4

    .line 543
    const/4 v5, 0x0

    iput-boolean v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->isReqeustBTConnect:Z

    .line 548
    :goto_1
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 549
    .local v0, "btIntent":Landroid/content/Intent;
    const-string v5, "bluetooth address"

    invoke-virtual {v0, v5}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 550
    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 552
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mHandler:Landroid/os/Handler;

    new-instance v6, Lcom/drms/drms_drone/Activity/DroneMainActivity$9;

    invoke-direct {v6, p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity$9;-><init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V

    const-wide/16 v8, 0x1f4

    invoke-virtual {v5, v6, v8, v9}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 546
    .end local v0    # "btIntent":Landroid/content/Intent;
    :cond_4
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    const-string v6, "not selected "

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 566
    :pswitch_3
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    iget-object v6, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mHandler:Landroid/os/Handler;

    invoke-virtual {v5, v6}, Lcom/drms/drms_drone/Service/BTService;->setHandler(Landroid/os/Handler;)V

    .line 567
    new-instance v5, Landroid/content/Intent;

    const-string v6, "request main display"

    invoke-direct {v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 568
    const/4 v5, 0x1

    if-ne p2, v5, :cond_0

    .line 569
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->device_name:Landroid/widget/TextView;

    const-string v6, "disconnected"

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 570
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->device_address:Landroid/widget/TextView;

    const-string v6, "..."

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 575
    :pswitch_4
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    iget-object v6, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mHandler:Landroid/os/Handler;

    invoke-virtual {v5, v6}, Lcom/drms/drms_drone/Service/BTService;->setHandler(Landroid/os/Handler;)V

    .line 576
    new-instance v2, Landroid/content/Intent;

    const-class v5, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;

    invoke-direct {v2, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 577
    .local v2, "result_setting":Landroid/content/Intent;
    const-string v5, "request"

    const/4 v6, 0x1

    invoke-virtual {v2, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 578
    const/4 v5, 0x1

    invoke-virtual {p0, v2, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 579
    const v5, 0x7f05000b

    const v6, 0x7f05000c

    invoke-virtual {p0, v5, v6}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->overridePendingTransition(II)V

    .line 580
    new-instance v5, Landroid/content/Intent;

    const-string v6, "request main display"

    invoke-direct {v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 584
    .end local v2    # "result_setting":Landroid/content/Intent;
    :pswitch_5
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    iget-object v6, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mHandler:Landroid/os/Handler;

    invoke-virtual {v5, v6}, Lcom/drms/drms_drone/Service/BTService;->setHandler(Landroid/os/Handler;)V

    .line 585
    new-instance v3, Landroid/content/Intent;

    const-class v5, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;

    invoke-direct {v3, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 586
    .local v3, "result_upload":Landroid/content/Intent;
    const-string v5, "request"

    const/4 v6, 0x1

    invoke-virtual {v3, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 587
    const/4 v5, 0x1

    invoke-virtual {p0, v3, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 588
    const v5, 0x7f05000b

    const v6, 0x7f05000c

    invoke-virtual {p0, v5, v6}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->overridePendingTransition(II)V

    .line 589
    new-instance v5, Landroid/content/Intent;

    const-string v6, "request main display"

    invoke-direct {v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 595
    .end local v3    # "result_upload":Landroid/content/Intent;
    :pswitch_6
    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    iget-object v6, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mHandler:Landroid/os/Handler;

    invoke-virtual {v5, v6}, Lcom/drms/drms_drone/Service/BTService;->setHandler(Landroid/os/Handler;)V

    .line 596
    new-instance v1, Landroid/content/Intent;

    const-class v5, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;

    invoke-direct {v1, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 597
    .local v1, "requst_program":Landroid/content/Intent;
    const-string v5, "request"

    const/4 v6, 0x1

    invoke-virtual {v1, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 598
    const/4 v5, 0x1

    invoke-virtual {p0, v1, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 599
    const v5, 0x7f05000b

    const v6, 0x7f05000c

    invoke-virtual {p0, v5, v6}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->overridePendingTransition(II)V

    .line 600
    new-instance v5, Landroid/content/Intent;

    const-string v6, "request main display"

    invoke-direct {v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 510
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_0
        :pswitch_0
        :pswitch_6
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 135
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 137
    const v0, 0x7f040020

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->setContentView(I)V

    .line 141
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x80

    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 142
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 143
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->initializeMultiData()V

    .line 144
    invoke-direct {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->initializeView()V

    .line 145
    return-void
.end method

.method protected onDestroy()V
    .locals 0

    .prologue
    .line 699
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onDestroy()V

    .line 700
    return-void
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const v2, 0x800003

    .line 881
    const/4 v1, 0x4

    if-ne p1, v1, :cond_0

    .line 882
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v1, v2}, Landroid/support/v4/widget/DrawerLayout;->isDrawerOpen(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 883
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v1, v2}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    .line 901
    :cond_0
    :goto_0
    const/4 v1, 0x1

    return v1

    .line 886
    :cond_1
    new-instance v1, Landroid/content/Intent;

    const-string v2, "request nothing"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 887
    new-instance v1, Landroid/content/Intent;

    const-string v2, "request_finish_service"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 888
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bluetooth:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030004

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 889
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->device_name:Landroid/widget/TextView;

    const-string v2, " Disconnected..."

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 890
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->device_address:Landroid/widget/TextView;

    const-string v2, "..."

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 892
    const-string v0, "#bye"

    .line 893
    .local v0, "bye_msg":Ljava/lang/String;
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setControllerConnected(Z)V

    .line 894
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->usbService:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->write([B)V

    .line 895
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->BTConnection:Landroid/content/ServiceConnection;

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 896
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->usbConnection:Landroid/content/ServiceConnection;

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 897
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->finish()V

    goto :goto_0
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 656
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onPause()V

    .line 664
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->MainReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 668
    return-void
.end method

.method protected onRestart()V
    .locals 3

    .prologue
    .line 672
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onRestart()V

    .line 673
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    const-string v2, "onRestart()"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 674
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/drms/drms_drone/Service/BTService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 675
    .local v0, "intent":Landroid/content/Intent;
    invoke-direct {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->setFilter()V

    .line 677
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->BTConnection:Landroid/content/ServiceConnection;

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 679
    return-void
.end method

.method public onResume()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 632
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onResume()V

    .line 633
    invoke-direct {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->setFilter()V

    .line 634
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    .line 635
    .local v0, "btAdapter":Landroid/bluetooth/BluetoothAdapter;
    if-eqz v0, :cond_0

    .line 636
    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 637
    const-class v2, Lcom/drms/drms_drone/Service/BTService;

    iget-object v3, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->BTConnection:Landroid/content/ServiceConnection;

    invoke-direct {p0, v2, v3, v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startService(Ljava/lang/Class;Landroid/content/ServiceConnection;Landroid/os/Bundle;)V

    .line 638
    const-class v2, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    iget-object v3, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->usbConnection:Landroid/content/ServiceConnection;

    invoke-direct {p0, v2, v3, v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startService(Ljava/lang/Class;Landroid/content/ServiceConnection;Landroid/os/Bundle;)V

    .line 646
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v2

    const/16 v3, 0x1002

    invoke-virtual {v2, v3}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 652
    return-void

    .line 641
    :cond_1
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.bluetooth.adapter.action.REQUEST_ENABLE"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 642
    .local v1, "btEnabledIntent":Landroid/content/Intent;
    const/4 v2, 0x2

    invoke-virtual {p0, v1, v2}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0
.end method

.method protected onStop()V
    .locals 2

    .prologue
    .line 683
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStop()V

    .line 684
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    const-string v1, "onStop"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 686
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    if-eqz v0, :cond_0

    .line 687
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 688
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 691
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->requestReconnect:Z

    .line 695
    :cond_0
    return-void
.end method

.method public onSystemUiVisibilityChange(I)V
    .locals 2
    .param p1, "visibility"    # I

    .prologue
    .line 149
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity;->TAG:Ljava/lang/String;

    const-string v1, "changed"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 150
    return-void
.end method
