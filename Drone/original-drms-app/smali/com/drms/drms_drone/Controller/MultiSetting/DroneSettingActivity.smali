.class public Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "DroneSettingActivity.java"


# static fields
.field private static final BOX:I = 0x2

.field private static DISPLAY_LOOP:I = 0x0

.field private static final GPS:I = 0x4

.field private static final MYDRONE:I = 0x0

.field private static final PID:I = 0x3

.field private static final RC:I = 0x1

.field private static final TAG:Ljava/lang/String; = "DroneSettingActivity"


# instance fields
.field private final BTConnection:Landroid/content/ServiceConnection;

.field private DroneSettingHandler:Landroid/os/Handler;

.field private DroneSettingReceiver:Landroid/content/BroadcastReceiver;

.field private MSP_PID_D:[F

.field private MSP_PID_I:[F

.field private MSP_PID_P:[F

.field private SETTINGDISPLAY:I

.field private alt_d:Landroid/widget/EditText;

.field private alt_i:Landroid/widget/EditText;

.field private alt_p:Landroid/widget/EditText;

.field private box:Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;

.field private count_display:I

.field private currentvbat:Landroid/widget/EditText;

.field private dialog:Landroid/app/AlertDialog;

.field private drawer:Landroid/support/v4/widget/DrawerLayout;

.field private drone:Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

.field private failsafe:Landroid/widget/EditText;

.field private isPIDSetting:Z

.field private isRcSetting:Z

.field private lev_d:Landroid/widget/EditText;

.field private lev_i:Landroid/widget/EditText;

.field private lev_p:Landroid/widget/EditText;

.field private mBTService:Lcom/drms/drms_drone/Service/BTService;

.field private mFileManagemnet:Lcom/drms/drms_drone/FileManagement/FileManagement;

.field private mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

.field private mag_p:Landroid/widget/EditText;

.field private mspdata:Lcom/drms/drms_drone/MultiData;

.field private navr_d:Landroid/widget/EditText;

.field private navr_i:Landroid/widget/EditText;

.field private navr_p:Landroid/widget/EditText;

.field private openDrawer:Landroid/widget/ImageView;

.field private pitch_d:Landroid/widget/EditText;

.field private pitch_i:Landroid/widget/EditText;

.field private pitch_p:Landroid/widget/EditText;

.field private pos_i:Landroid/widget/EditText;

.field private pos_p:Landroid/widget/EditText;

.field private posr_d:Landroid/widget/EditText;

.field private posr_i:Landroid/widget/EditText;

.field private posr_p:Landroid/widget/EditText;

.field private rcexpo:Landroid/widget/EditText;

.field private rcrate:Landroid/widget/EditText;

.field private roll_d:Landroid/widget/EditText;

.field private roll_i:Landroid/widget/EditText;

.field private roll_p:Landroid/widget/EditText;

.field private rpexpo:Landroid/widget/EditText;

.field private scale:Landroid/widget/EditText;

.field private settinglayout:Landroid/widget/LinearLayout;

.field private thr_expo:Landroid/widget/EditText;

.field private thr_mid:Landroid/widget/EditText;

.field private throttlemax:Landroid/widget/EditText;

.field private throttlemin:Landroid/widget/EditText;

.field private warning1:Landroid/widget/EditText;

.field private warning2:Landroid/widget/EditText;

.field private warning3:Landroid/widget/EditText;

.field private yaw_d:Landroid/widget/EditText;

.field private yaw_i:Landroid/widget/EditText;

.field private yaw_p:Landroid/widget/EditText;

.field private yawrate:Landroid/widget/EditText;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 64
    const/4 v0, 0x2

    sput v0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->DISPLAY_LOOP:I

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/16 v1, 0xa

    const/4 v0, 0x0

    .line 48
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 65
    iput v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->count_display:I

    .line 67
    iput v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->SETTINGDISPLAY:I

    .line 300
    iput-boolean v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->isRcSetting:Z

    .line 365
    iput-boolean v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->isPIDSetting:Z

    .line 368
    new-array v0, v1, [F

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    .line 369
    new-array v0, v1, [F

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    .line 370
    new-array v0, v1, [F

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    .line 452
    new-instance v0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$7;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$7;-><init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->BTConnection:Landroid/content/ServiceConnection;

    .line 469
    new-instance v0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$8;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$8;-><init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->DroneSettingHandler:Landroid/os/Handler;

    .line 507
    new-instance v0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$9;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$9;-><init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->DroneSettingReceiver:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/app/AlertDialog;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->dialog:Landroid/app/AlertDialog;

    return-object v0
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)I
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->SETTINGDISPLAY:I

    return v0
.end method

.method static synthetic access$1000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->failsafe:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$102(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;I)I
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;
    .param p1, "x1"    # I

    .prologue
    .line 48
    iput p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->SETTINGDISPLAY:I

    return p1
.end method

.method static synthetic access$1100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->scale:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning1:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning2:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning3:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_p:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_p:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_p:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_p:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pos_p:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rcrate:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_p:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_p:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_p:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mag_p:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2400(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)[F
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    return-object v0
.end method

.method static synthetic access$2500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_i:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_i:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2700(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_i:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_i:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2900(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pos_i:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rcexpo:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$3000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_i:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$3100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_i:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$3200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_i:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$3300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)[F
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    return-object v0
.end method

.method static synthetic access$3400(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_d:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$3500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_d:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$3600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_d:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$3700(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_d:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$3800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)[F
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    return-object v0
.end method

.method static synthetic access$3900(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_d:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rpexpo:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$4000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_d:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$4100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_d:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$4200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/Sound/SoundManager;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    return-object v0
.end method

.method static synthetic access$4300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/support/v4/widget/DrawerLayout;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->drawer:Landroid/support/v4/widget/DrawerLayout;

    return-object v0
.end method

.method static synthetic access$4400(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-boolean v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->isRcSetting:Z

    return v0
.end method

.method static synthetic access$4402(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 48
    iput-boolean p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->isRcSetting:Z

    return p1
.end method

.method static synthetic access$4500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->settinglayout:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$4600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->drone:Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

    return-object v0
.end method

.method static synthetic access$4602(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;)Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;
    .param p1, "x1"    # Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->drone:Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

    return-object p1
.end method

.method static synthetic access$4700(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->implementationRcSetting()V

    return-void
.end method

.method static synthetic access$4800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->box:Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;

    return-object v0
.end method

.method static synthetic access$4802(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;)Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;
    .param p1, "x1"    # Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->box:Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;

    return-object p1
.end method

.method static synthetic access$4900(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->implementationPIDSetting()V

    return-void
.end method

.method static synthetic access$500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yawrate:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$5000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->currentvbat:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$5100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/Service/BTService;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    return-object v0
.end method

.method static synthetic access$5102(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;
    .param p1, "x1"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    return-object p1
.end method

.method static synthetic access$5200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->DroneSettingHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$5302(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;I)I
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;
    .param p1, "x1"    # I

    .prologue
    .line 48
    iput p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->count_display:I

    return p1
.end method

.method static synthetic access$5308(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)I
    .locals 2
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->count_display:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->count_display:I

    return v0
.end method

.method static synthetic access$5400()I
    .locals 1

    .prologue
    .line 48
    sget v0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->DISPLAY_LOOP:I

    return v0
.end method

.method static synthetic access$600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/MultiData;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    return-object v0
.end method

.method static synthetic access$700(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->thr_mid:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->thr_expo:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$900(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->throttlemin:Landroid/widget/EditText;

    return-object v0
.end method

.method private implementationDrawer()V
    .locals 6

    .prologue
    .line 247
    const v3, 0x7f0d006d

    invoke-virtual {p0, v3}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    .line 248
    .local v1, "drawerList":Landroid/widget/ListView;
    new-instance v0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;-><init>(Landroid/content/Context;)V

    .line 249
    .local v0, "adapter":Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;
    new-instance v3, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f030023

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    const-string v5, "My Drone"

    invoke-direct {v3, v4, v5}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;)V

    .line 250
    new-instance v3, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f03002b

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    const-string v5, "RC & Battery"

    invoke-direct {v3, v4, v5}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;)V

    .line 251
    new-instance v3, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f030006

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    const-string v5, "Box Setting"

    invoke-direct {v3, v4, v5}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;)V

    .line 252
    new-instance v3, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f030026

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    const-string v5, "PID Setting"

    invoke-direct {v3, v4, v5}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;)V

    .line 255
    const v3, 0x7f0d006c

    invoke-virtual {p0, v3}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 256
    .local v2, "mydevice":Landroid/widget/TextView;
    new-instance v3, Lcom/drms/drms_drone/FileManagement/FileManagement;

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->DroneSettingHandler:Landroid/os/Handler;

    invoke-direct {v3, p0, v4}, Lcom/drms/drms_drone/FileManagement/FileManagement;-><init>(Landroid/content/Context;Landroid/os/Handler;)V

    iput-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mFileManagemnet:Lcom/drms/drms_drone/FileManagement/FileManagement;

    .line 257
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mFileManagemnet:Lcom/drms/drms_drone/FileManagement/FileManagement;

    invoke-virtual {v3}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 259
    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 261
    new-instance v3, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;

    invoke-direct {v3, p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;-><init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V

    invoke-virtual {v1, v3}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 298
    return-void
.end method

.method private implementationPIDSetting()V
    .locals 12

    .prologue
    const/4 v11, 0x0

    const/high16 v10, 0x42c80000    # 100.0f

    const/4 v9, 0x1

    const/high16 v8, 0x41200000    # 10.0f

    const/high16 v7, 0x447a0000    # 1000.0f

    .line 372
    iput-boolean v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->isPIDSetting:Z

    .line 373
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->settinglayout:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 374
    const v4, 0x7f04003a

    const/4 v5, 0x0

    invoke-static {p0, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 375
    .local v3, "pidsetting":Landroid/widget/LinearLayout;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v5, -0x1

    const/4 v6, -0x1

    invoke-direct {v4, v5, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 376
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->settinglayout:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 378
    const v4, 0x7f0d00a8

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_p:Landroid/widget/EditText;

    .line 379
    const v4, 0x7f0d00a9

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_i:Landroid/widget/EditText;

    .line 380
    const v4, 0x7f0d00aa

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_d:Landroid/widget/EditText;

    .line 382
    const v4, 0x7f0d00ab

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_p:Landroid/widget/EditText;

    .line 383
    const v4, 0x7f0d00ac

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_i:Landroid/widget/EditText;

    .line 384
    const v4, 0x7f0d00ad

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_d:Landroid/widget/EditText;

    .line 386
    const v4, 0x7f0d00ae

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_p:Landroid/widget/EditText;

    .line 387
    const v4, 0x7f0d00af

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_i:Landroid/widget/EditText;

    .line 388
    const v4, 0x7f0d00b0

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_d:Landroid/widget/EditText;

    .line 390
    const v4, 0x7f0d00b1

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_p:Landroid/widget/EditText;

    .line 391
    const v4, 0x7f0d00b2

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_i:Landroid/widget/EditText;

    .line 392
    const v4, 0x7f0d00b3

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_d:Landroid/widget/EditText;

    .line 394
    const v4, 0x7f0d00b4

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pos_p:Landroid/widget/EditText;

    .line 395
    const v4, 0x7f0d00b5

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pos_i:Landroid/widget/EditText;

    .line 397
    const v4, 0x7f0d00b6

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_p:Landroid/widget/EditText;

    .line 398
    const v4, 0x7f0d00b7

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_i:Landroid/widget/EditText;

    .line 399
    const v4, 0x7f0d00b8

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_d:Landroid/widget/EditText;

    .line 401
    const v4, 0x7f0d00b9

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_p:Landroid/widget/EditText;

    .line 402
    const v4, 0x7f0d00ba

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_i:Landroid/widget/EditText;

    .line 403
    const v4, 0x7f0d00bb

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_d:Landroid/widget/EditText;

    .line 405
    const v4, 0x7f0d00bc

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_p:Landroid/widget/EditText;

    .line 406
    const v4, 0x7f0d00bd

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_i:Landroid/widget/EditText;

    .line 407
    const v4, 0x7f0d00be

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_d:Landroid/widget/EditText;

    .line 409
    const v4, 0x7f0d00bf

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mag_p:Landroid/widget/EditText;

    .line 413
    const/4 v1, 0x0

    .line 414
    .local v1, "index":I
    const/4 v0, 0x0

    .local v0, "i":I
    move v2, v1

    .end local v1    # "index":I
    .local v2, "index":I
    :goto_0
    const/16 v4, 0xa

    if-ge v0, v4, :cond_0

    .line 415
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v5}, Lcom/drms/drms_drone/MultiData;->getPIDdata()[I

    move-result-object v5

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "index":I
    .restart local v1    # "index":I
    aget v5, v5, v2

    int-to-float v5, v5

    aput v5, v4, v0

    .line 416
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v5}, Lcom/drms/drms_drone/MultiData;->getPIDdata()[I

    move-result-object v5

    add-int/lit8 v2, v1, 0x1

    .end local v1    # "index":I
    .restart local v2    # "index":I
    aget v5, v5, v1

    int-to-float v5, v5

    aput v5, v4, v0

    .line 417
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v5}, Lcom/drms/drms_drone/MultiData;->getPIDdata()[I

    move-result-object v5

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "index":I
    .restart local v1    # "index":I
    aget v5, v5, v2

    int-to-float v5, v5

    aput v5, v4, v0

    .line 414
    add-int/lit8 v0, v0, 0x1

    move v2, v1

    .end local v1    # "index":I
    .restart local v2    # "index":I
    goto :goto_0

    .line 420
    :cond_0
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_p:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    aget v5, v5, v11

    div-float/2addr v5, v8

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 421
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_p:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    aget v5, v5, v9

    div-float/2addr v5, v8

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 422
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_p:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    const/4 v6, 0x2

    aget v5, v5, v6

    div-float/2addr v5, v8

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 423
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_p:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    const/4 v6, 0x3

    aget v5, v5, v6

    div-float/2addr v5, v8

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 424
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pos_p:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    const/4 v6, 0x4

    aget v5, v5, v6

    div-float/2addr v5, v10

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 425
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_p:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    const/4 v6, 0x5

    aget v5, v5, v6

    div-float/2addr v5, v8

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 426
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_p:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    const/4 v6, 0x6

    aget v5, v5, v6

    div-float/2addr v5, v8

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 427
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_p:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    const/4 v6, 0x7

    aget v5, v5, v6

    float-to-int v5, v5

    div-int/lit8 v5, v5, 0xa

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 428
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mag_p:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    const/16 v6, 0x8

    aget v5, v5, v6

    float-to-int v5, v5

    div-int/lit8 v5, v5, 0xa

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 430
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_i:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    aget v5, v5, v11

    div-float/2addr v5, v7

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 431
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_i:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    aget v5, v5, v9

    div-float/2addr v5, v7

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 432
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_i:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    const/4 v6, 0x2

    aget v5, v5, v6

    div-float/2addr v5, v7

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 433
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_i:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    const/4 v6, 0x3

    aget v5, v5, v6

    div-float/2addr v5, v7

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 434
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pos_i:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    const/4 v6, 0x4

    aget v5, v5, v6

    div-float/2addr v5, v7

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 435
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_i:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    const/4 v6, 0x5

    aget v5, v5, v6

    div-float/2addr v5, v10

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 436
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_i:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    const/4 v6, 0x6

    aget v5, v5, v6

    div-float/2addr v5, v10

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 437
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_i:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    const/4 v6, 0x7

    aget v5, v5, v6

    div-float/2addr v5, v7

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 439
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_d:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    aget v5, v5, v11

    float-to-int v5, v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 440
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_d:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    aget v5, v5, v9

    float-to-int v5, v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 441
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_d:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    const/4 v6, 0x2

    aget v5, v5, v6

    float-to-int v5, v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 442
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_d:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    const/4 v6, 0x3

    aget v5, v5, v6

    float-to-int v5, v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 444
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_d:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    const/4 v6, 0x5

    aget v5, v5, v6

    div-float/2addr v5, v7

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 445
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_d:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    const/4 v6, 0x6

    aget v5, v5, v6

    div-float/2addr v5, v7

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 446
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_d:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    const/4 v6, 0x7

    aget v5, v5, v6

    float-to-int v5, v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 449
    return-void
.end method

.method private implementationRcSetting()V
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v4, -0x1

    const/4 v6, 0x1

    .line 303
    iput-boolean v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->isRcSetting:Z

    .line 304
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->settinglayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 305
    const v2, 0x7f04003b

    const/4 v3, 0x0

    invoke-static {p0, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 306
    .local v1, "rcsettingLayout":Landroid/widget/LinearLayout;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v2, v4, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 307
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->settinglayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 308
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v2, "#.##"

    invoke-direct {v0, v2}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 310
    .local v0, "form":Ljava/text/DecimalFormat;
    const v2, 0x7f0d00c0

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rcrate:Landroid/widget/EditText;

    .line 311
    const v2, 0x7f0d00c2

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rcexpo:Landroid/widget/EditText;

    .line 312
    const v2, 0x7f0d00c4

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rpexpo:Landroid/widget/EditText;

    .line 313
    const v2, 0x7f0d00c1

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->thr_mid:Landroid/widget/EditText;

    .line 314
    const v2, 0x7f0d00c3

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->thr_expo:Landroid/widget/EditText;

    .line 315
    const v2, 0x7f0d00c5

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yawrate:Landroid/widget/EditText;

    .line 317
    const v2, 0x7f0d00c6

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->throttlemin:Landroid/widget/EditText;

    .line 318
    const v2, 0x7f0d00c7

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->throttlemax:Landroid/widget/EditText;

    .line 319
    const v2, 0x7f0d00c8

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->failsafe:Landroid/widget/EditText;

    .line 321
    const v2, 0x7f0d00c9

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->scale:Landroid/widget/EditText;

    .line 322
    const v2, 0x7f0d00ca

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->currentvbat:Landroid/widget/EditText;

    .line 323
    const v2, 0x7f0d00cb

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning1:Landroid/widget/EditText;

    .line 324
    const v2, 0x7f0d00cc

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning2:Landroid/widget/EditText;

    .line 325
    const v2, 0x7f0d00cd

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning3:Landroid/widget/EditText;

    .line 327
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->throttlemin:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v3

    aget v3, v3, v6

    float-to-int v3, v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 328
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->throttlemax:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v3

    aget v3, v3, v7

    float-to-int v3, v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 329
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->failsafe:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v3

    const/4 v4, 0x4

    aget v3, v3, v4

    float-to-int v3, v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 331
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->scale:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v3

    const/16 v4, 0x8

    aget v3, v3, v4

    float-to-int v3, v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 332
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning1:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v3

    const/16 v4, 0x9

    aget v3, v3, v4

    float-to-double v4, v3

    invoke-virtual {v0, v4, v5}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 333
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning2:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v3

    const/16 v4, 0xa

    aget v3, v3, v4

    float-to-double v4, v3

    invoke-virtual {v0, v4, v5}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 334
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning3:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v3

    const/16 v4, 0xb

    aget v3, v3, v4

    float-to-double v4, v3

    invoke-virtual {v0, v4, v5}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 336
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rcrate:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getRCTUNEdata()[F

    move-result-object v3

    const/4 v4, 0x0

    aget v3, v3, v4

    invoke-static {v3}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 337
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rcexpo:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getRCTUNEdata()[F

    move-result-object v3

    aget v3, v3, v6

    invoke-static {v3}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 338
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rpexpo:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getRCTUNEdata()[F

    move-result-object v3

    aget v3, v3, v7

    invoke-static {v3}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 339
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yawrate:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getRCTUNEdata()[F

    move-result-object v3

    const/4 v4, 0x3

    aget v3, v3, v4

    invoke-static {v3}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 340
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->thr_mid:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getRCTUNEdata()[F

    move-result-object v3

    const/4 v4, 0x5

    aget v3, v3, v4

    invoke-static {v3}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 341
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->thr_expo:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getRCTUNEdata()[F

    move-result-object v3

    const/4 v4, 0x6

    aget v3, v3, v4

    invoke-static {v3}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 342
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;

    invoke-direct {v3, p0, v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;-><init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;Ljava/text/DecimalFormat;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 361
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 363
    return-void
.end method

.method private initializeView()V
    .locals 3

    .prologue
    const/4 v2, -0x1

    .line 119
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 120
    new-instance v0, Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 122
    const v0, 0x7f0d0068

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/DrawerLayout;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->drawer:Landroid/support/v4/widget/DrawerLayout;

    .line 124
    const v0, 0x7f0d0069

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->openDrawer:Landroid/widget/ImageView;

    .line 125
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->openDrawer:Landroid/widget/ImageView;

    new-instance v1, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;-><init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 236
    const v0, 0x7f0d006b

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->settinglayout:Landroid/widget/LinearLayout;

    .line 237
    new-instance v0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

    invoke-direct {v0, p0, p0}, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->drone:Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

    .line 238
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->drone:Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 240
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->settinglayout:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->drone:Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 242
    invoke-direct {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->implementationDrawer()V

    .line 243
    return-void
.end method

.method private setFilter()V
    .locals 2

    .prologue
    .line 486
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 488
    .local v0, "filter":Landroid/content/IntentFilter;
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->DroneSettingReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 490
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
    .line 494
    .local p1, "service":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 495
    .local v4, "startService":Landroid/content/Intent;
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Landroid/os/Bundle;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    .line 496
    invoke-virtual {p3}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v3

    .line 497
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

    .line 498
    .local v2, "key":Ljava/lang/String;
    invoke-virtual {p3, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 499
    .local v1, "extra":Ljava/lang/String;
    invoke-virtual {v4, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 503
    .end local v1    # "extra":Ljava/lang/String;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 504
    .local v0, "bindingIntent":Landroid/content/Intent;
    const/4 v5, 0x1

    invoke-virtual {p0, v0, p2, v5}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 505
    return-void
.end method


# virtual methods
.method public finish()V
    .locals 2

    .prologue
    .line 649
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->finish()V

    .line 650
    const v0, 0x7f05000c

    const v1, 0x7f05000a

    invoke-virtual {p0, v0, v1}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->overridePendingTransition(II)V

    .line 651
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 78
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 79
    const v4, 0x7f04001e

    invoke-virtual {p0, v4}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->setContentView(I)V

    .line 80
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->getWindow()Landroid/view/Window;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v4

    const/16 v5, 0x1002

    invoke-virtual {v4, v5}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 84
    new-instance v4, Landroid/content/Intent;

    const-string v5, "request display setting"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v4}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 86
    invoke-direct {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->initializeView()V

    .line 88
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 89
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    const v4, 0x7f04003f

    const/4 v5, 0x0

    invoke-static {p0, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 90
    .local v3, "warning":Landroid/widget/LinearLayout;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v5, -0x1

    const/4 v6, -0x2

    invoke-direct {v4, v5, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 91
    invoke-virtual {v0, v3}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 92
    const v4, 0x7f0d00ce

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 93
    .local v1, "continue_setting":Landroid/widget/TextView;
    const v4, 0x7f0d00cf

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 94
    .local v2, "exit_setting":Landroid/widget/TextView;
    new-instance v4, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$1;

    invoke-direct {v4, p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$1;-><init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 101
    new-instance v4, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$2;

    invoke-direct {v4, p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$2;-><init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v4

    iput-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->dialog:Landroid/app/AlertDialog;

    .line 108
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->dialog:Landroid/app/AlertDialog;

    invoke-virtual {v4}, Landroid/app/AlertDialog;->show()V

    .line 109
    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->dialog:Landroid/app/AlertDialog;

    new-instance v5, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$3;

    invoke-direct {v5, p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$3;-><init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V

    invoke-virtual {v4, v5}, Landroid/app/AlertDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 116
    return-void
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 13
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v12, 0x0

    const/16 v11, 0x9

    const/4 v10, 0x4

    const/high16 v9, 0x447a0000    # 1000.0f

    const/high16 v8, 0x41200000    # 10.0f

    .line 537
    if-ne p1, v10, :cond_0

    .line 538
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->drawer:Landroid/support/v4/widget/DrawerLayout;

    const v7, 0x800003

    invoke-virtual {v6, v7}, Landroid/support/v4/widget/DrawerLayout;->isDrawerOpen(I)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 539
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->drawer:Landroid/support/v4/widget/DrawerLayout;

    const v7, 0x800003

    invoke-virtual {v6, v7}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    .line 644
    :cond_0
    :goto_0
    const/4 v6, 0x1

    return v6

    .line 542
    :cond_1
    new-instance v5, Landroid/content/Intent;

    invoke-direct {v5}, Landroid/content/Intent;-><init>()V

    .line 543
    .local v5, "requestSetting":Landroid/content/Intent;
    const-string v6, "REQUEST_BACK"

    const/4 v7, -0x1

    invoke-virtual {v5, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 544
    iget v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->SETTINGDISPLAY:I

    packed-switch v6, :pswitch_data_0

    goto :goto_0

    .line 547
    :pswitch_0
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->finish()V

    goto :goto_0

    .line 551
    :pswitch_1
    const-string v6, "request rc setting"

    invoke-virtual {v5, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 552
    const/4 v6, 0x7

    new-array v4, v6, [F

    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rcrate:Landroid/widget/EditText;

    .line 553
    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    aput v6, v4, v12

    const/4 v6, 0x1

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rcexpo:Landroid/widget/EditText;

    .line 554
    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v4, v6

    const/4 v6, 0x2

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->rpexpo:Landroid/widget/EditText;

    .line 555
    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v4, v6

    const/4 v6, 0x3

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yawrate:Landroid/widget/EditText;

    .line 556
    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v4, v6

    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 557
    invoke-virtual {v6}, Lcom/drms/drms_drone/MultiData;->getRCTUNEdata()[F

    move-result-object v6

    aget v6, v6, v10

    aput v6, v4, v10

    const/4 v6, 0x5

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->thr_mid:Landroid/widget/EditText;

    .line 558
    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v4, v6

    const/4 v6, 0x6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->thr_expo:Landroid/widget/EditText;

    .line 559
    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v4, v6

    .line 561
    .local v4, "rctuneData":[F
    const/16 v6, 0xc

    new-array v0, v6, [F

    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 562
    invoke-virtual {v6}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v6

    aget v6, v6, v12

    aput v6, v0, v12

    const/4 v6, 0x1

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->throttlemin:Landroid/widget/EditText;

    .line 563
    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v0, v6

    const/4 v6, 0x2

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 564
    invoke-virtual {v7}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v7

    const/4 v8, 0x2

    aget v7, v7, v8

    aput v7, v0, v6

    const/4 v6, 0x3

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 565
    invoke-virtual {v7}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v7

    const/4 v8, 0x3

    aget v7, v7, v8

    aput v7, v0, v6

    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->failsafe:Landroid/widget/EditText;

    .line 566
    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    aput v6, v0, v10

    const/4 v6, 0x5

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 567
    invoke-virtual {v7}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v7

    const/4 v8, 0x5

    aget v7, v7, v8

    aput v7, v0, v6

    const/4 v6, 0x6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 568
    invoke-virtual {v7}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v7

    const/4 v8, 0x6

    aget v7, v7, v8

    aput v7, v0, v6

    const/4 v6, 0x7

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 569
    invoke-virtual {v7}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v7

    const/4 v8, 0x7

    aget v7, v7, v8

    aput v7, v0, v6

    const/16 v6, 0x8

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->scale:Landroid/widget/EditText;

    .line 570
    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v0, v6

    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning1:Landroid/widget/EditText;

    .line 571
    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    aput v6, v0, v11

    const/16 v6, 0xa

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning2:Landroid/widget/EditText;

    .line 572
    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v0, v6

    const/16 v6, 0xb

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->warning3:Landroid/widget/EditText;

    .line 573
    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v0, v6

    .line 575
    .local v0, "miscData":[F
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v6, v4}, Lcom/drms/drms_drone/MultiData;->setRCTUNEdata([F)V

    .line 576
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v6, v0}, Lcom/drms/drms_drone/MultiData;->setMISCdata([F)V

    .line 578
    invoke-virtual {p0, v5}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 579
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->finish()V

    goto/16 :goto_0

    .line 584
    .end local v0    # "miscData":[F
    .end local v4    # "rctuneData":[F
    :pswitch_2
    const-string v6, "DroneSettingActivity"

    const-string v7, "send box data"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 585
    const-string v6, "request box setting"

    invoke-virtual {v5, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 586
    invoke-virtual {p0, v5}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 587
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->finish()V

    goto/16 :goto_0

    .line 591
    :pswitch_3
    const/16 v6, 0xa

    new-array v3, v6, [F

    .line 592
    .local v3, "pid_p_temp":[F
    const/16 v6, 0xa

    new-array v2, v6, [F

    .line 593
    .local v2, "pid_i_temp":[F
    const/16 v6, 0xa

    new-array v1, v6, [F

    .line 595
    .local v1, "pid_d_temp":[F
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_p:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    mul-float/2addr v6, v8

    aput v6, v3, v12

    .line 596
    const/4 v6, 0x1

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_p:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 597
    const/4 v6, 0x2

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_p:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 598
    const/4 v6, 0x3

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_p:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 599
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pos_p:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    const/high16 v7, 0x42c80000    # 100.0f

    mul-float/2addr v6, v7

    aput v6, v3, v10

    .line 600
    const/4 v6, 0x5

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_p:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 601
    const/4 v6, 0x6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_p:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 602
    const/4 v6, 0x7

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_p:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 603
    const/16 v6, 0x8

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->mag_p:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 604
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_P:[F

    aget v6, v6, v11

    aput v6, v3, v11

    .line 606
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_i:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    mul-float/2addr v6, v9

    aput v6, v2, v12

    .line 607
    const/4 v6, 0x1

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_i:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v9

    aput v7, v2, v6

    .line 608
    const/4 v6, 0x2

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_i:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v9

    aput v7, v2, v6

    .line 609
    const/4 v6, 0x3

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_i:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v9

    aput v7, v2, v6

    .line 610
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pos_i:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    mul-float/2addr v6, v9

    aput v6, v2, v10

    .line 611
    const/4 v6, 0x5

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_i:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    const/high16 v8, 0x42c80000    # 100.0f

    mul-float/2addr v7, v8

    aput v7, v2, v6

    .line 612
    const/4 v6, 0x6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_i:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    const/high16 v8, 0x42c80000    # 100.0f

    mul-float/2addr v7, v8

    aput v7, v2, v6

    .line 613
    const/4 v6, 0x7

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_i:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v9

    aput v7, v2, v6

    .line 614
    const/16 v6, 0x8

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    const/16 v8, 0x8

    aget v7, v7, v8

    aput v7, v2, v6

    .line 615
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_I:[F

    aget v6, v6, v11

    aput v6, v2, v11

    .line 617
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->roll_d:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    aput v6, v1, v12

    .line 618
    const/4 v6, 0x1

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->pitch_d:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v1, v6

    .line 619
    const/4 v6, 0x2

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->yaw_d:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v1, v6

    .line 620
    const/4 v6, 0x3

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->alt_d:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v1, v6

    .line 621
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    aget v6, v6, v10

    aput v6, v1, v10

    .line 622
    const/4 v6, 0x5

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->posr_d:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v9

    aput v7, v1, v6

    .line 623
    const/4 v6, 0x6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->navr_d:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v9

    aput v7, v1, v6

    .line 624
    const/4 v6, 0x7

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->lev_d:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v1, v6

    .line 625
    const/16 v6, 0x8

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    const/16 v8, 0x8

    aget v7, v7, v8

    aput v7, v1, v6

    .line 626
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->MSP_PID_D:[F

    aget v6, v6, v11

    aput v6, v1, v11

    .line 628
    const-string v6, "P"

    invoke-virtual {v5, v6, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[F)Landroid/content/Intent;

    .line 629
    const-string v6, "I"

    invoke-virtual {v5, v6, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[F)Landroid/content/Intent;

    .line 630
    const-string v6, "D"

    invoke-virtual {v5, v6, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[F)Landroid/content/Intent;

    .line 631
    const-string v6, "request pid setting"

    invoke-virtual {v5, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 633
    invoke-virtual {p0, v5}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 635
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->finish()V

    goto/16 :goto_0

    .line 544
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 523
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onPause()V

    .line 525
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->DroneSettingReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 526
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    .line 516
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onResume()V

    .line 517
    invoke-direct {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->setFilter()V

    .line 518
    const-class v0, Lcom/drms/drms_drone/Service/BTService;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->BTConnection:Landroid/content/ServiceConnection;

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->startService(Ljava/lang/Class;Landroid/content/ServiceConnection;Landroid/os/Bundle;)V

    .line 519
    return-void
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 530
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStop()V

    .line 531
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->isRcSetting:Z

    .line 532
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->BTConnection:Landroid/content/ServiceConnection;

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 533
    return-void
.end method
