.class public Lcom/drms/drms_drone/Protocol/Multiwii/MSP;
.super Ljava/lang/Object;
.source "MSP.java"


# static fields
.field private static CHECKBOXITEM:I = 0x0

.field public static final MODE_REQUEST:I = 0x1

.field public static final MSP_ACC_CALIBRATION:I = 0xcd

.field public static final MSP_ALTITUDE:I = 0x6d

.field public static final MSP_ANALOG:I = 0x6e

.field public static final MSP_ATTITUDE:I = 0x6c

.field public static final MSP_BIND:I = 0xf0

.field public static final MSP_BOX:I = 0x71

.field public static final MSP_BOXIDS:I = 0x77

.field public static final MSP_BOXNAMES:I = 0x74

.field public static final MSP_COMP_GPS:I = 0x6b

.field public static final MSP_DEBUG:I = 0xfe

.field public static final MSP_DEBUGMSG:I = 0xfd

.field public static final MSP_EEPROM_WRITE:I = 0xfa

.field public static final MSP_ENABLE_FRSKY:I = 0xc6

.field private static final MSP_HEADER:Ljava/lang/String; = "$M<"

.field public static final MSP_IDENT:I = 0x64

.field public static final MSP_MAG_CALIBRATION:I = 0xce

.field public static final MSP_MISC:I = 0x72

.field public static final MSP_MOTOR:I = 0x68

.field public static final MSP_MOTOR_PINS:I = 0x73

.field public static final MSP_NAV_CONFIG:I = 0x7a

.field public static final MSP_NAV_STATUS:I = 0x79

.field public static final MSP_PID:I = 0x70

.field public static final MSP_PIDNAMES:I = 0x75

.field public static final MSP_RAW_GPS:I = 0x6a

.field public static final MSP_RAW_IMU:I = 0x66

.field public static final MSP_RC:I = 0x69

.field public static final MSP_RC_TUNING:I = 0x6f

.field public static final MSP_RESET_CONF:I = 0xd0

.field public static final MSP_SELECT_SETTING:I = 0xd2

.field public static final MSP_SERVO:I = 0x67

.field public static final MSP_SERVO_CONF:I = 0x78

.field public static final MSP_SET_BOX:I = 0xcb

.field public static final MSP_SET_HEAD:I = 0xd3

.field public static final MSP_SET_MISC:I = 0xcf

.field public static final MSP_SET_MOTOR:I = 0xd6

.field public static final MSP_SET_PID:I = 0xca

.field public static final MSP_SET_RAW_GPS:I = 0xc9

.field public static final MSP_SET_RAW_RC:I = 0xc8

.field public static final MSP_SET_RC_TUNING:I = 0xcc

.field public static final MSP_SET_SERIAL_BAUDRATE:I = 0xc7

.field public static final MSP_SET_SERVO_CONF:I = 0xd4

.field public static final MSP_SET_WP:I = 0xd1

.field public static final MSP_STATUS:I = 0x65

.field public static final MSP_WP:I = 0x76


# instance fields
.field private mHandler:Landroid/os/Handler;

.field private mbluetoothservice:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

.field private payload:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Character;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 91
    const/4 v0, 0x0

    sput v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->CHECKBOXITEM:I

    return-void
.end method

.method public constructor <init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/os/Handler;)V
    .locals 0
    .param p1, "bluetoothservice"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
    .param p2, "mHandler"    # Landroid/os/Handler;

    .prologue
    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    iput-object p1, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mbluetoothservice:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .line 88
    iput-object p2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    .line 89
    return-void
.end method


# virtual methods
.method public SendRequestMSP_ACC_CALIBRATION()V
    .locals 1

    .prologue
    .line 288
    const/16 v0, 0xcd

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 289
    return-void
.end method

.method public SendRequestMSP_ENABLE_FRSKY()V
    .locals 2

    .prologue
    .line 297
    const/16 v0, 0xc6

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 298
    const-string v0, "aaa"

    const-string v1, "MSP_ENABLE_FRSKY"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 300
    return-void
.end method

.method public SendRequestMSP_MAG_CALIBRATION()V
    .locals 1

    .prologue
    .line 292
    const/16 v0, 0xce

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 293
    return-void
.end method

.method public SendRequestMSP_SET_HEAD(I)V
    .locals 3
    .param p1, "heading"    # I

    .prologue
    .line 216
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    .line 217
    iget-object v0, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    and-int/lit16 v1, p1, 0xff

    int-to-char v1, v1

    invoke-static {v1}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 218
    iget-object v0, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    shr-int/lit8 v1, p1, 0x8

    and-int/lit16 v1, v1, 0xff

    int-to-char v1, v1

    invoke-static {v1}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 219
    const/16 v1, 0xd3

    iget-object v0, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    new-array v2, v2, [Ljava/lang/Character;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/Character;

    invoke-virtual {p0, v1, v0}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I[Ljava/lang/Character;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 220
    return-void
.end method

.method public SendRequestMSP_SET_MISC(IIIIIFIFFF)V
    .locals 5
    .param p1, "PowerTrigger"    # I
    .param p2, "minthrottle"    # I
    .param p3, "maxthrottle"    # I
    .param p4, "mincommand"    # I
    .param p5, "failsafe_throttle"    # I
    .param p6, "mag_decliniation"    # F
    .param p7, "vbatscale"    # I
    .param p8, "vbatlevel_warn1"    # F
    .param p9, "vbatlevel_warn2"    # F
    .param p10, "vbatlevel_crit"    # F

    .prologue
    .line 122
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    .line 123
    const/4 v0, 0x0

    .line 125
    .local v0, "intPowerTrigger":I
    int-to-float v2, p1

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v0

    .line 126
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    rem-int/lit16 v3, v0, 0x100

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 127
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    div-int/lit16 v3, v0, 0x100

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 129
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    rem-int/lit16 v3, p2, 0x100

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 130
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    div-int/lit16 v3, p2, 0x100

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 132
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    rem-int/lit16 v3, p3, 0x100

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 133
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    div-int/lit16 v3, p3, 0x100

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 135
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    rem-int/lit16 v3, p4, 0x100

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 136
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    div-int/lit16 v3, p4, 0x100

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 138
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    rem-int/lit16 v3, p5, 0x100

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 139
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    div-int/lit16 v3, p5, 0x100

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 141
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 142
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 144
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 146
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 148
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 150
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 157
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    const/high16 v3, 0x43800000    # 256.0f

    rem-float v3, p6, v3

    float-to-int v3, v3

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 158
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    const/high16 v3, 0x43800000    # 256.0f

    div-float v3, p6, v3

    float-to-int v3, v3

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 163
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    and-int/lit16 v3, p7, 0xff

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 165
    const/high16 v2, 0x41f00000    # 30.0f

    mul-float/2addr v2, p8

    float-to-int v1, v2

    .line 166
    .local v1, "q":I
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    int-to-char v3, v1

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 168
    const/high16 v2, 0x41f00000    # 30.0f

    mul-float/2addr v2, p9

    float-to-int v1, v2

    .line 169
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    int-to-char v3, v1

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 171
    const/high16 v2, 0x41f00000    # 30.0f

    mul-float/2addr v2, p10

    float-to-int v1, v2

    .line 172
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    int-to-char v3, v1

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 174
    const/16 v3, 0xcf

    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    new-array v4, v4, [Ljava/lang/Character;

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/Character;

    invoke-virtual {p0, v3, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I[Ljava/lang/Character;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 177
    const/16 v2, 0xfa

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 181
    return-void
.end method

.method public SendRequestMSP_SET_PID_TUNING([F[F[F)V
    .locals 7
    .param p1, "pid_p_term"    # [F
    .param p2, "pid_i_term"    # [F
    .param p3, "pid_d_term"    # [F

    .prologue
    .line 198
    move-object v3, p1

    .line 199
    .local v3, "pid_p":[F
    move-object v2, p2

    .line 200
    .local v2, "pid_i":[F
    move-object v1, p3

    .line 202
    .local v1, "pid_d":[F
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    .line 204
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    const/16 v4, 0xa

    if-ge v0, v4, :cond_0

    .line 205
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    aget v5, v3, v0

    float-to-int v5, v5

    and-int/lit16 v5, v5, 0xff

    int-to-char v5, v5

    invoke-static {v5}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 206
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    aget v5, v2, v0

    float-to-int v5, v5

    and-int/lit16 v5, v5, 0xff

    int-to-char v5, v5

    invoke-static {v5}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 207
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    aget v5, v1, v0

    float-to-int v5, v5

    and-int/lit16 v5, v5, 0xff

    int-to-char v5, v5

    invoke-static {v5}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 204
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 210
    :cond_0
    const/16 v5, 0xca

    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    iget-object v6, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    new-array v6, v6, [Ljava/lang/Character;

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Ljava/lang/Character;

    invoke-virtual {p0, v5, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I[Ljava/lang/Character;)Ljava/util/List;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 212
    const/16 v4, 0xfa

    invoke-virtual {p0, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 213
    return-void
.end method

.method public SendRequestMSP_SET_RC_TUNING([F)V
    .locals 5
    .param p1, "rc_tuning_data"    # [F

    .prologue
    .line 184
    move-object v1, p1

    .line 186
    .local v1, "rc_tune":[F
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    .line 188
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_0

    .line 189
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    aget v3, v1, v0

    float-to-int v3, v3

    and-int/lit16 v3, v3, 0xff

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 188
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 192
    :cond_0
    const/16 v3, 0xcc

    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    new-array v4, v4, [Ljava/lang/Character;

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/Character;

    invoke-virtual {p0, v3, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I[Ljava/lang/Character;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 194
    const/16 v2, 0xfa

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 195
    return-void
.end method

.method public read16(BB)I
    .locals 2
    .param p1, "int_16_1"    # B
    .param p2, "int_16_2"    # B

    .prologue
    .line 695
    and-int/lit16 v0, p1, 0xff

    shl-int/lit8 v1, p2, 0x8

    add-int/2addr v0, v1

    return v0
.end method

.method public read32(BBBB)I
    .locals 2
    .param p1, "int_32_1"    # B
    .param p2, "int_32_2"    # B
    .param p3, "int_32_3"    # B
    .param p4, "int_32_4"    # B

    .prologue
    .line 699
    and-int/lit16 v0, p1, 0xff

    and-int/lit16 v1, p2, 0xff

    shl-int/lit8 v1, v1, 0x8

    add-int/2addr v0, v1

    and-int/lit16 v1, p3, 0xff

    shl-int/lit8 v1, v1, 0x10

    add-int/2addr v0, v1

    and-int/lit16 v1, p4, 0xff

    shl-int/lit8 v1, v1, 0x18

    add-int/2addr v0, v1

    return v0
.end method

.method public read8(B)I
    .locals 1
    .param p1, "int_8_1"    # B

    .prologue
    .line 691
    and-int/lit16 v0, p1, 0xff

    return v0
.end method

.method public readMSP([B)V
    .locals 26
    .param p1, "read_data"    # [B

    .prologue
    .line 303
    move-object/from16 v9, p1

    .line 305
    .local v9, "data":[B
    const/4 v11, 0x0

    .line 306
    .local v11, "header":Ljava/lang/String;
    const/16 v21, 0x4

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v15, v0, 0xff

    .line 307
    .local v15, "msp":I
    const/4 v8, 0x0

    .line 309
    .local v8, "checksum":B
    sparse-switch v15, :sswitch_data_0

    .line 688
    :cond_0
    :goto_0
    return-void

    .line 312
    :sswitch_0
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_1
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_2

    .line 313
    if-nez v11, :cond_1

    .line 314
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 312
    :goto_2
    add-int/lit8 v12, v12, 0x1

    goto :goto_1

    .line 317
    :cond_1
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_2

    .line 320
    :cond_2
    const/4 v12, 0x0

    :goto_3
    const/16 v21, 0x18

    move/from16 v0, v21

    if-ge v12, v0, :cond_3

    .line 321
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 320
    add-int/lit8 v12, v12, 0x1

    goto :goto_3

    .line 324
    :cond_3
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    const/16 v21, 0x1b

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 326
    const/16 v21, 0xc

    move/from16 v0, v21

    new-array v0, v0, [F

    move-object/from16 v16, v0

    .line 327
    .local v16, "payload":[F
    const/16 v21, 0x0

    const/16 v22, 0x5

    aget-byte v22, v9, v22

    const/16 v23, 0x6

    aget-byte v23, v9, v23

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 328
    const/16 v21, 0x1

    const/16 v22, 0x7

    aget-byte v22, v9, v22

    const/16 v23, 0x8

    aget-byte v23, v9, v23

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 329
    const/16 v21, 0x2

    const/16 v22, 0x9

    aget-byte v22, v9, v22

    const/16 v23, 0xa

    aget-byte v23, v9, v23

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 330
    const/16 v21, 0x3

    const/16 v22, 0xb

    aget-byte v22, v9, v22

    const/16 v23, 0xc

    aget-byte v23, v9, v23

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 331
    const/16 v21, 0x4

    const/16 v22, 0xd

    aget-byte v22, v9, v22

    const/16 v23, 0xe

    aget-byte v23, v9, v23

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 332
    const/16 v21, 0x5

    const/16 v22, 0xf

    aget-byte v22, v9, v22

    const/16 v23, 0x10

    aget-byte v23, v9, v23

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 333
    const/16 v21, 0x6

    const/16 v22, 0x11

    aget-byte v22, v9, v22

    const/16 v23, 0x12

    aget-byte v23, v9, v23

    const/16 v24, 0x13

    aget-byte v24, v9, v24

    const/16 v25, 0x14

    aget-byte v25, v9, v25

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move/from16 v4, v25

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read32(BBBB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 334
    const/16 v21, 0x7

    const/16 v22, 0x15

    aget-byte v22, v9, v22

    const/16 v23, 0x16

    aget-byte v23, v9, v23

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    const/high16 v23, 0x41200000    # 10.0f

    div-float v22, v22, v23

    aput v22, v16, v21

    .line 335
    const/16 v21, 0x8

    const/16 v22, 0x17

    aget-byte v22, v9, v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 336
    const/16 v21, 0x9

    const/16 v22, 0x18

    aget-byte v22, v9, v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    const/high16 v23, 0x41f00000    # 30.0f

    div-float v22, v22, v23

    aput v22, v16, v21

    .line 337
    const/16 v21, 0xa

    const/16 v22, 0x19

    aget-byte v22, v9, v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    const/high16 v23, 0x41f00000    # 30.0f

    div-float v22, v22, v23

    aput v22, v16, v21

    .line 338
    const/16 v21, 0xb

    const/16 v22, 0x1a

    aget-byte v22, v9, v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    const/high16 v23, 0x41f00000    # 30.0f

    div-float v22, v22, v23

    aput v22, v16, v21

    .line 341
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x72

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move-object/from16 v4, v16

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 347
    .end local v12    # "i":I
    .end local v16    # "payload":[F
    :sswitch_1
    const/4 v12, 0x0

    .restart local v12    # "i":I
    :goto_4
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_5

    .line 348
    if-nez v11, :cond_4

    .line 349
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 347
    :goto_5
    add-int/lit8 v12, v12, 0x1

    goto :goto_4

    .line 352
    :cond_4
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_5

    .line 355
    :cond_5
    const/4 v12, 0x0

    :goto_6
    const/16 v21, 0x9

    move/from16 v0, v21

    if-ge v12, v0, :cond_6

    .line 356
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 355
    add-int/lit8 v12, v12, 0x1

    goto :goto_6

    .line 359
    :cond_6
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    const/16 v21, 0xc

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 360
    const/16 v21, 0x7

    move/from16 v0, v21

    new-array v0, v0, [F

    move-object/from16 v16, v0

    .line 362
    .restart local v16    # "payload":[F
    const/4 v12, 0x0

    :goto_7
    const/16 v21, 0x7

    move/from16 v0, v21

    if-ge v12, v0, :cond_7

    .line 363
    add-int/lit8 v21, v12, 0x5

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    aput v21, v16, v12

    .line 362
    add-int/lit8 v12, v12, 0x1

    goto :goto_7

    .line 366
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x6f

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move-object/from16 v4, v16

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 372
    .end local v12    # "i":I
    .end local v16    # "payload":[F
    :sswitch_2
    const/16 v21, 0x0

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v17, v0

    .line 374
    .local v17, "payload_string":[Ljava/lang/String;
    const/4 v12, 0x0

    .restart local v12    # "i":I
    :goto_8
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_9

    .line 375
    if-nez v11, :cond_8

    .line 376
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 374
    :goto_9
    add-int/lit8 v12, v12, 0x1

    goto :goto_8

    .line 379
    :cond_8
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_9

    .line 382
    :cond_9
    const/16 v21, 0x3

    aget-byte v19, v9, v21

    .line 384
    .local v19, "sizeOfdata":I
    const/4 v12, 0x0

    :goto_a
    add-int/lit8 v21, v19, 0x2

    move/from16 v0, v21

    if-ge v12, v0, :cond_a

    .line 385
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 384
    add-int/lit8 v12, v12, 0x1

    goto :goto_a

    .line 388
    :cond_a
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    array-length v0, v9

    move/from16 v21, v0

    add-int/lit8 v21, v21, -0x1

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 389
    move/from16 v0, v19

    new-array v0, v0, [B

    move-object/from16 v20, v0

    .line 390
    .local v20, "temp":[B
    const/4 v12, 0x0

    :goto_b
    move/from16 v0, v19

    if-ge v12, v0, :cond_b

    .line 391
    add-int/lit8 v21, v12, 0x5

    aget-byte v21, v9, v21

    aput-byte v21, v20, v12

    .line 390
    add-int/lit8 v12, v12, 0x1

    goto :goto_b

    .line 393
    :cond_b
    new-instance v21, Ljava/lang/String;

    const/16 v22, 0x0

    move-object/from16 v0, v20

    array-length v0, v0

    move/from16 v23, v0

    move-object/from16 v0, v21

    move-object/from16 v1, v20

    move/from16 v2, v22

    move/from16 v3, v23

    invoke-direct {v0, v1, v2, v3}, Ljava/lang/String;-><init>([BII)V

    const-string v22, ";"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v17

    .line 394
    move-object/from16 v0, v17

    array-length v0, v0

    move/from16 v21, v0

    sput v21, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->CHECKBOXITEM:I

    .line 396
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x74

    move-object/from16 v0, v17

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move-object/from16 v4, v17

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 401
    .end local v12    # "i":I
    .end local v17    # "payload_string":[Ljava/lang/String;
    .end local v19    # "sizeOfdata":I
    .end local v20    # "temp":[B
    :sswitch_3
    const/4 v12, 0x0

    .restart local v12    # "i":I
    :goto_c
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_d

    .line 402
    if-nez v11, :cond_c

    .line 403
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 401
    :goto_d
    add-int/lit8 v12, v12, 0x1

    goto :goto_c

    .line 406
    :cond_c
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_d

    .line 408
    :cond_d
    const/16 v21, 0x3

    aget-byte v18, v9, v21

    .line 409
    .local v18, "sizeOfMSP_BOXDATA":I
    const/4 v12, 0x0

    :goto_e
    add-int/lit8 v21, v18, 0x2

    move/from16 v0, v21

    if-ge v12, v0, :cond_e

    .line 410
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 409
    add-int/lit8 v12, v12, 0x1

    goto :goto_e

    .line 413
    :cond_e
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    array-length v0, v9

    move/from16 v21, v0

    add-int/lit8 v21, v21, -0x1

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 414
    const/16 v21, 0x8

    move/from16 v0, v21

    new-array v0, v0, [I

    move-object/from16 v16, v0

    .line 415
    .local v16, "payload":[I
    const/4 v13, 0x5

    .line 416
    .local v13, "index":I
    sget v21, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->CHECKBOXITEM:I

    const/16 v22, 0xc

    filled-new-array/range {v21 .. v22}, [I

    move-result-object v21

    sget-object v22, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    invoke-static {v0, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [[Z

    .line 418
    .local v6, "Checkbox":[[Z
    const/4 v12, 0x0

    :goto_f
    sget v21, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->CHECKBOXITEM:I

    move/from16 v0, v21

    if-ge v12, v0, :cond_11

    .line 419
    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .local v14, "index":I
    aget-byte v21, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v22, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v21

    move/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v21

    aput v21, v16, v12

    .line 421
    const/4 v7, 0x0

    .local v7, "aa":I
    :goto_10
    const/16 v21, 0xc

    move/from16 v0, v21

    if-ge v7, v0, :cond_10

    .line 422
    aget v21, v16, v12

    const/16 v22, 0x1

    shl-int v22, v22, v7

    and-int v21, v21, v22

    if-lez v21, :cond_f

    .line 423
    aget-object v21, v6, v12

    const/16 v22, 0x1

    aput-boolean v22, v21, v7

    .line 421
    :goto_11
    add-int/lit8 v7, v7, 0x1

    goto :goto_10

    .line 425
    :cond_f
    aget-object v21, v6, v12

    const/16 v22, 0x0

    aput-boolean v22, v21, v7

    goto :goto_11

    .line 418
    :cond_10
    add-int/lit8 v12, v12, 0x1

    goto :goto_f

    .line 429
    .end local v7    # "aa":I
    :cond_11
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x71

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    invoke-virtual {v0, v1, v2, v3, v6}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 434
    .end local v6    # "Checkbox":[[Z
    .end local v12    # "i":I
    .end local v13    # "index":I
    .end local v16    # "payload":[I
    .end local v18    # "sizeOfMSP_BOXDATA":I
    :sswitch_4
    const/4 v12, 0x0

    .restart local v12    # "i":I
    :goto_12
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_13

    .line 435
    if-nez v11, :cond_12

    .line 436
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 434
    :goto_13
    add-int/lit8 v12, v12, 0x1

    goto :goto_12

    .line 439
    :cond_12
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_13

    .line 442
    :cond_13
    const/4 v12, 0x0

    :goto_14
    const/16 v21, 0x9

    move/from16 v0, v21

    if-ge v12, v0, :cond_14

    .line 443
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 442
    add-int/lit8 v12, v12, 0x1

    goto :goto_14

    .line 446
    :cond_14
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    const/16 v21, 0xc

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 447
    const/16 v21, 0x4

    move/from16 v0, v21

    new-array v0, v0, [F

    move-object/from16 v16, v0

    .line 449
    .local v16, "payload":[F
    const/16 v21, 0x0

    const/16 v22, 0x5

    aget-byte v22, v9, v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    const/high16 v23, 0x41f00000    # 30.0f

    div-float v22, v22, v23

    aput v22, v16, v21

    .line 450
    const/16 v21, 0x1

    const/16 v22, 0x6

    aget-byte v22, v9, v22

    const/16 v23, 0x7

    aget-byte v23, v9, v23

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 451
    const/16 v21, 0x2

    const/16 v22, 0x8

    aget-byte v22, v9, v22

    const/16 v23, 0x9

    aget-byte v23, v9, v23

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 452
    const/16 v21, 0x3

    const/16 v22, 0xa

    aget-byte v22, v9, v22

    const/16 v23, 0xb

    aget-byte v23, v9, v23

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 454
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x6e

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move-object/from16 v4, v16

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 461
    .end local v12    # "i":I
    .end local v16    # "payload":[F
    :sswitch_5
    const/4 v12, 0x0

    .restart local v12    # "i":I
    :goto_15
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_16

    .line 462
    if-nez v11, :cond_15

    .line 463
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 461
    :goto_16
    add-int/lit8 v12, v12, 0x1

    goto :goto_15

    .line 466
    :cond_15
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_16

    .line 469
    :cond_16
    const/4 v12, 0x0

    :goto_17
    const/16 v21, 0x12

    move/from16 v0, v21

    if-ge v12, v0, :cond_17

    .line 470
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 469
    add-int/lit8 v12, v12, 0x1

    goto :goto_17

    .line 473
    :cond_17
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    const/16 v21, 0x15

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 474
    const/16 v21, 0x8

    move/from16 v0, v21

    new-array v0, v0, [I

    move-object/from16 v16, v0

    .line 475
    .local v16, "payload":[I
    const/4 v13, 0x5

    .line 476
    .restart local v13    # "index":I
    const/4 v12, 0x0

    move v14, v13

    .end local v13    # "index":I
    .restart local v14    # "index":I
    :goto_18
    const/16 v21, 0x8

    move/from16 v0, v21

    if-ge v12, v0, :cond_18

    .line 477
    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v21, v9, v14

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    move-object/from16 v0, p0

    move/from16 v1, v21

    move/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v21

    aput v21, v16, v12

    .line 476
    add-int/lit8 v12, v12, 0x1

    goto :goto_18

    .line 480
    :cond_18
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x69

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move-object/from16 v4, v16

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 487
    .end local v12    # "i":I
    .end local v14    # "index":I
    .end local v16    # "payload":[I
    :sswitch_6
    const/4 v12, 0x0

    .restart local v12    # "i":I
    :goto_19
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_1a

    .line 488
    if-nez v11, :cond_19

    .line 489
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 487
    :goto_1a
    add-int/lit8 v12, v12, 0x1

    goto :goto_19

    .line 492
    :cond_19
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_1a

    .line 495
    :cond_1a
    const/4 v12, 0x0

    :goto_1b
    const/16 v21, 0x8

    move/from16 v0, v21

    if-ge v12, v0, :cond_1b

    .line 496
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 495
    add-int/lit8 v12, v12, 0x1

    goto :goto_1b

    .line 499
    :cond_1b
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    const/16 v21, 0xb

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 500
    const/16 v21, 0x3

    move/from16 v0, v21

    new-array v0, v0, [F

    move-object/from16 v16, v0

    .line 501
    .local v16, "payload":[F
    const/4 v13, 0x5

    .line 503
    .restart local v13    # "index":I
    const/4 v12, 0x0

    move v14, v13

    .end local v13    # "index":I
    .restart local v14    # "index":I
    :goto_1c
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_1c

    .line 504
    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v21, v9, v14

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    move-object/from16 v0, p0

    move/from16 v1, v21

    move/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v21

    div-int/lit8 v21, v21, 0xa

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    aput v21, v16, v12

    .line 503
    add-int/lit8 v12, v12, 0x1

    goto :goto_1c

    .line 507
    :cond_1c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x6c

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move-object/from16 v4, v16

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 513
    .end local v12    # "i":I
    .end local v14    # "index":I
    .end local v16    # "payload":[F
    :sswitch_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0xcd

    const/16 v23, 0x0

    const/16 v24, -0x1

    invoke-virtual/range {v21 .. v24}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 518
    :sswitch_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0xce

    const/16 v23, 0x0

    const/16 v24, -0x1

    invoke-virtual/range {v21 .. v24}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 522
    :sswitch_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0xd3

    const/16 v23, 0x0

    const/16 v24, -0x1

    invoke-virtual/range {v21 .. v24}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 527
    :sswitch_a
    const/4 v12, 0x0

    .restart local v12    # "i":I
    :goto_1d
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_1e

    .line 528
    if-nez v11, :cond_1d

    .line 529
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 527
    :goto_1e
    add-int/lit8 v12, v12, 0x1

    goto :goto_1d

    .line 532
    :cond_1d
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_1e

    .line 535
    :cond_1e
    const/4 v12, 0x0

    :goto_1f
    const/16 v21, 0x9

    move/from16 v0, v21

    if-ge v12, v0, :cond_1f

    .line 536
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 535
    add-int/lit8 v12, v12, 0x1

    goto :goto_1f

    .line 540
    :cond_1f
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    const/16 v21, 0xc

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 541
    const/16 v21, 0x4

    move/from16 v0, v21

    new-array v0, v0, [I

    move-object/from16 v16, v0

    .line 542
    .local v16, "payload":[I
    const/4 v13, 0x5

    .line 543
    .restart local v13    # "index":I
    const/4 v12, 0x0

    move v14, v13

    .end local v13    # "index":I
    .restart local v14    # "index":I
    :goto_20
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_20

    .line 544
    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v21, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    aput v21, v16, v12

    .line 543
    add-int/lit8 v12, v12, 0x1

    move v14, v13

    .end local v13    # "index":I
    .restart local v14    # "index":I
    goto :goto_20

    .line 547
    :cond_20
    const/16 v21, 0x3

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v22, v9, v14

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v23, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v24, v9, v14

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v25, v9, v13

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move/from16 v4, v25

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read32(BBBB)I

    move-result v22

    aput v22, v16, v21

    .line 549
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x64

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move-object/from16 v4, v16

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 556
    .end local v12    # "i":I
    .end local v14    # "index":I
    .end local v16    # "payload":[I
    :sswitch_b
    const/4 v12, 0x0

    .restart local v12    # "i":I
    :goto_21
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_22

    .line 557
    if-nez v11, :cond_21

    .line 558
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 556
    :goto_22
    add-int/lit8 v12, v12, 0x1

    goto :goto_21

    .line 561
    :cond_21
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_22

    .line 564
    :cond_22
    const/4 v12, 0x0

    :goto_23
    const/16 v21, 0x1f

    move/from16 v0, v21

    if-ge v12, v0, :cond_23

    .line 565
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 564
    add-int/lit8 v12, v12, 0x1

    goto :goto_23

    .line 568
    :cond_23
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    const/16 v21, 0x23

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 569
    const/16 v21, 0x1e

    move/from16 v0, v21

    new-array v0, v0, [I

    move-object/from16 v16, v0

    .line 570
    .restart local v16    # "payload":[I
    const/4 v13, 0x5

    .line 572
    .restart local v13    # "index":I
    const/4 v12, 0x0

    move v14, v13

    .end local v13    # "index":I
    .restart local v14    # "index":I
    :goto_24
    const/16 v21, 0x1e

    move/from16 v0, v21

    if-ge v12, v0, :cond_24

    .line 573
    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v21, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    aput v21, v16, v12

    .line 572
    add-int/lit8 v12, v12, 0x1

    move v14, v13

    .end local v13    # "index":I
    .restart local v14    # "index":I
    goto :goto_24

    .line 577
    :cond_24
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x70

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move-object/from16 v4, v16

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 585
    .end local v12    # "i":I
    .end local v14    # "index":I
    .end local v16    # "payload":[I
    :sswitch_c
    const/4 v12, 0x0

    .restart local v12    # "i":I
    :goto_25
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_26

    .line 586
    if-nez v11, :cond_25

    .line 587
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 585
    :goto_26
    add-int/lit8 v12, v12, 0x1

    goto :goto_25

    .line 590
    :cond_25
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_26

    .line 595
    :cond_26
    const/4 v12, 0x0

    :goto_27
    const/16 v21, 0x12

    move/from16 v0, v21

    if-ge v12, v0, :cond_27

    .line 596
    add-int/lit8 v21, v12, 0x3

    :try_start_0
    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 595
    add-int/lit8 v12, v12, 0x1

    goto :goto_27

    .line 599
    :cond_27
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    const/16 v21, 0x15

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 600
    const/16 v21, 0x7

    move/from16 v0, v21

    new-array v0, v0, [D

    move-object/from16 v16, v0

    .line 601
    .local v16, "payload":[D
    const/4 v13, 0x5

    .line 603
    .restart local v13    # "index":I
    const/16 v21, 0x0

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v22

    move/from16 v0, v22

    int-to-double v0, v0

    move-wide/from16 v22, v0

    aput-wide v22, v16, v21

    .line 604
    const/16 v21, 0x1

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v22, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v22

    move/from16 v0, v22

    int-to-double v0, v0

    move-wide/from16 v22, v0

    aput-wide v22, v16, v21

    .line 605
    const/16 v21, 0x2

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v24, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v25, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move/from16 v4, v25

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read32(BBBB)I

    move-result v22

    move/from16 v0, v22

    int-to-double v0, v0

    move-wide/from16 v22, v0

    aput-wide v22, v16, v21

    .line 606
    const/16 v21, 0x3

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v24, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v25, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move/from16 v4, v25

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read32(BBBB)I

    move-result v22

    move/from16 v0, v22

    int-to-double v0, v0

    move-wide/from16 v22, v0

    aput-wide v22, v16, v21

    .line 607
    const/16 v21, 0x4

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-double v0, v0

    move-wide/from16 v22, v0

    aput-wide v22, v16, v21

    .line 608
    const/16 v21, 0x5

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-double v0, v0

    move-wide/from16 v22, v0

    aput-wide v22, v16, v21

    .line 609
    const/16 v21, 0x6

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-double v0, v0

    move-wide/from16 v22, v0

    aput-wide v22, v16, v21

    .line 611
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x6a

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move-object/from16 v4, v16

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V
    :try_end_0
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 614
    .end local v13    # "index":I
    .end local v16    # "payload":[D
    :catch_0
    move-exception v10

    .line 615
    .local v10, "e":Ljava/lang/ArrayIndexOutOfBoundsException;
    const/4 v12, 0x0

    :goto_28
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_28

    .line 616
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 615
    add-int/lit8 v12, v12, 0x1

    goto :goto_28

    .line 619
    :cond_28
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x6a

    const/16 v23, 0x0

    const/16 v24, -0x1

    const/16 v25, 0x0

    invoke-virtual/range {v21 .. v25}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 626
    .end local v10    # "e":Ljava/lang/ArrayIndexOutOfBoundsException;
    .end local v12    # "i":I
    :sswitch_d
    const/4 v12, 0x0

    .restart local v12    # "i":I
    :goto_29
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_2a

    .line 627
    if-nez v11, :cond_29

    .line 628
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 626
    :goto_2a
    add-int/lit8 v12, v12, 0x1

    goto :goto_29

    .line 631
    :cond_29
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_2a

    .line 634
    :cond_2a
    const/4 v12, 0x0

    :goto_2b
    const/16 v21, 0x14

    move/from16 v0, v21

    if-ge v12, v0, :cond_2b

    .line 635
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 634
    add-int/lit8 v12, v12, 0x1

    goto :goto_2b

    .line 638
    :cond_2b
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    const/16 v21, 0x17

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 639
    const/16 v21, 0x9

    move/from16 v0, v21

    new-array v0, v0, [I

    move-object/from16 v16, v0

    .line 640
    .local v16, "payload":[I
    const/4 v13, 0x5

    .line 642
    .restart local v13    # "index":I
    const/16 v21, 0x0

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    aput v22, v16, v21

    .line 643
    const/16 v21, 0x1

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    aput v22, v16, v21

    .line 644
    const/16 v21, 0x2

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    aput v22, v16, v21

    .line 645
    const/16 v21, 0x3

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    aput v22, v16, v21

    .line 646
    const/16 v21, 0x4

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    aput v22, v16, v21

    .line 647
    const/16 v21, 0x5

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    aput v22, v16, v21

    .line 648
    const/16 v21, 0x6

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    aput v22, v16, v21

    .line 649
    const/16 v21, 0x7

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    aput v22, v16, v21

    .line 650
    const/16 v21, 0x8

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    aput v22, v16, v21

    .line 653
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x66

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move-object/from16 v4, v16

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 659
    .end local v12    # "i":I
    .end local v13    # "index":I
    .end local v16    # "payload":[I
    :sswitch_e
    const/4 v12, 0x0

    .restart local v12    # "i":I
    :goto_2c
    const/16 v21, 0x3

    move/from16 v0, v21

    if-ge v12, v0, :cond_2d

    .line 660
    if-nez v11, :cond_2c

    .line 661
    aget-byte v21, v9, v12

    move/from16 v0, v21

    int-to-char v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    .line 659
    :goto_2d
    add-int/lit8 v12, v12, 0x1

    goto :goto_2c

    .line 664
    :cond_2c
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    aget-byte v22, v9, v12

    move/from16 v0, v22

    int-to-char v0, v0

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_2d

    .line 667
    :cond_2d
    const/4 v12, 0x0

    :goto_2e
    const/16 v21, 0x8

    move/from16 v0, v21

    if-ge v12, v0, :cond_2e

    .line 668
    add-int/lit8 v21, v12, 0x3

    aget-byte v21, v9, v21

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read8(B)I

    move-result v21

    move/from16 v0, v21

    and-int/lit16 v0, v0, 0xff

    move/from16 v21, v0

    xor-int v21, v21, v8

    move/from16 v0, v21

    int-to-byte v8, v0

    .line 667
    add-int/lit8 v12, v12, 0x1

    goto :goto_2e

    .line 672
    :cond_2e
    const-string v21, "$M>"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_0

    const/16 v21, 0xb

    aget-byte v21, v9, v21

    move/from16 v0, v21

    if-ne v8, v0, :cond_0

    .line 673
    const/16 v21, 0x2

    move/from16 v0, v21

    new-array v0, v0, [F

    move-object/from16 v16, v0

    .line 674
    .local v16, "payload":[F
    const/4 v13, 0x5

    .line 676
    .restart local v13    # "index":I
    const/16 v21, 0x0

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v24, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v25, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move/from16 v4, v25

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read32(BBBB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 677
    const/16 v21, 0x1

    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    aget-byte v22, v9, v13

    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget-byte v23, v9, v14

    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->read16(BB)I

    move-result v22

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    aput v22, v16, v21

    .line 679
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mHandler:Landroid/os/Handler;

    move-object/from16 v21, v0

    const/16 v22, 0x6d

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, -0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    move-object/from16 v4, v16

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 309
    nop

    :sswitch_data_0
    .sparse-switch
        0x64 -> :sswitch_a
        0x66 -> :sswitch_d
        0x69 -> :sswitch_5
        0x6a -> :sswitch_c
        0x6c -> :sswitch_6
        0x6d -> :sswitch_e
        0x6e -> :sswitch_4
        0x6f -> :sswitch_1
        0x70 -> :sswitch_b
        0x71 -> :sswitch_3
        0x72 -> :sswitch_0
        0x74 -> :sswitch_2
        0xcd -> :sswitch_7
        0xce -> :sswitch_8
        0xd3 -> :sswitch_9
    .end sparse-switch
.end method

.method public requestMSP(I)Ljava/util/List;
    .locals 1
    .param p1, "msp"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Byte;",
            ">;"
        }
    .end annotation

    .prologue
    .line 243
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I[Ljava/lang/Character;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public requestMSP(I[Ljava/lang/Character;)Ljava/util/List;
    .locals 9
    .param p1, "msp"    # I
    .param p2, "payload"    # [Ljava/lang/Character;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I[",
            "Ljava/lang/Character;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Byte;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 247
    const/4 v1, 0x0

    .line 249
    .local v1, "checksum":B
    new-instance v2, Ljava/util/LinkedList;

    invoke-direct {v2}, Ljava/util/LinkedList;-><init>()V

    .line 251
    .local v2, "msp_data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Byte;>;"
    const-string v4, "$M<"

    invoke-virtual {v4}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    array-length v7, v6

    move v4, v5

    :goto_0
    if-ge v4, v7, :cond_0

    aget-byte v0, v6, v4

    .line 252
    .local v0, "c":B
    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v8

    invoke-interface {v2, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 251
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 255
    .end local v0    # "c":B
    :cond_0
    if-eqz p2, :cond_1

    array-length v4, p2

    :goto_1
    and-int/lit16 v4, v4, 0xff

    int-to-byte v3, v4

    .line 256
    .local v3, "sizeOfpayload":B
    invoke-static {v3}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 257
    and-int/lit16 v4, v3, 0xff

    xor-int/2addr v4, v1

    int-to-byte v1, v4

    .line 259
    and-int/lit16 v4, p1, 0xff

    int-to-byte v4, v4

    invoke-static {v4}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 260
    and-int/lit16 v4, p1, 0xff

    xor-int/2addr v4, v1

    int-to-byte v1, v4

    .line 262
    if-eqz p2, :cond_2

    .line 263
    array-length v4, p2

    :goto_2
    if-ge v5, v4, :cond_2

    aget-object v6, p2, v5

    invoke-virtual {v6}, Ljava/lang/Character;->charValue()C

    move-result v0

    .line 264
    .local v0, "c":C
    and-int/lit16 v6, v0, 0xff

    int-to-byte v6, v6

    invoke-static {v6}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v6

    invoke-interface {v2, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 265
    and-int/lit16 v6, v0, 0xff

    xor-int/2addr v6, v1

    int-to-byte v1, v6

    .line 263
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .end local v0    # "c":C
    .end local v3    # "sizeOfpayload":B
    :cond_1
    move v4, v5

    .line 255
    goto :goto_1

    .line 269
    .restart local v3    # "sizeOfpayload":B
    :cond_2
    invoke-static {v1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 271
    return-object v2
.end method

.method public sendRequestMSP(Ljava/util/List;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Byte;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 276
    .local p1, "msp":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Byte;>;"
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v4

    new-array v0, v4, [B

    .line 277
    .local v0, "arr":[B
    const/4 v2, 0x0

    .line 278
    .local v2, "i":I
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Byte;

    invoke-virtual {v4}, Ljava/lang/Byte;->byteValue()B

    move-result v1

    .line 279
    .local v1, "b":B
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "i":I
    .local v3, "i":I
    aput-byte v1, v0, v2

    move v2, v3

    .line 280
    .end local v3    # "i":I
    .restart local v2    # "i":I
    goto :goto_0

    .line 281
    .end local v1    # "b":B
    :cond_0
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->mbluetoothservice:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    const/4 v5, 0x1

    invoke-virtual {v4, v0, v5}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->write([BI)V

    .line 283
    return-void
.end method

.method public sendRequestMSP_SET_BOX([[Z)V
    .locals 9
    .param p1, "boxdata"    # [[Z

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 94
    move-object v2, p1

    .line 95
    .local v2, "check_temp":[[Z
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    .line 96
    sget v4, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->CHECKBOXITEM:I

    new-array v1, v4, [I

    .line 98
    .local v1, "activation":[I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    sget v4, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->CHECKBOXITEM:I

    if-ge v3, v4, :cond_2

    .line 99
    aput v6, v1, v3

    .line 100
    const/4 v0, 0x0

    .local v0, "aa":I
    :goto_1
    const/16 v4, 0xc

    if-ge v0, v4, :cond_1

    .line 101
    aget v7, v1, v3

    aget-object v4, v2, v3

    aget-boolean v4, v4, v0

    if-eqz v4, :cond_0

    move v4, v5

    :goto_2
    shl-int v8, v5, v0

    mul-int/2addr v4, v8

    add-int/2addr v4, v7

    aput v4, v1, v3

    .line 100
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_0
    move v4, v6

    .line 101
    goto :goto_2

    .line 106
    :cond_1
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    aget v7, v1, v3

    rem-int/lit16 v7, v7, 0x100

    int-to-char v7, v7

    invoke-static {v7}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v7

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 107
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    aget v7, v1, v3

    div-int/lit16 v7, v7, 0x100

    int-to-char v7, v7

    invoke-static {v7}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v7

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 98
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 110
    .end local v0    # "aa":I
    :cond_2
    const/16 v5, 0xcb

    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    iget-object v6, p0, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->payload:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    new-array v6, v6, [Ljava/lang/Character;

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Ljava/lang/Character;

    invoke-virtual {p0, v5, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I[Ljava/lang/Character;)Ljava/util/List;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 112
    const/16 v4, 0xfa

    invoke-virtual {p0, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 113
    return-void
.end method

.method public sendRequestMSP_SET_RAW_RC([I)V
    .locals 9
    .param p1, "rcdata"    # [I

    .prologue
    .line 223
    const/4 v1, 0x0

    .line 227
    .local v1, "index":I
    const/16 v5, 0x10

    new-array v4, v5, [Ljava/lang/Character;

    .line 229
    .local v4, "rc_signal_array":[Ljava/lang/Character;
    const/4 v0, 0x0

    .local v0, "i":I
    move v2, v1

    .end local v1    # "index":I
    .local v2, "index":I
    :goto_0
    const/16 v5, 0x8

    if-ge v0, v5, :cond_0

    .line 230
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "index":I
    .restart local v1    # "index":I
    aget v5, p1, v0

    and-int/lit16 v5, v5, 0xff

    int-to-char v5, v5

    invoke-static {v5}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v5

    aput-object v5, v4, v2

    .line 231
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "index":I
    .restart local v2    # "index":I
    aget v5, p1, v0

    shr-int/lit8 v5, v5, 0x8

    and-int/lit16 v5, v5, 0xff

    int-to-char v5, v5

    invoke-static {v5}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v5

    aput-object v5, v4, v1

    .line 229
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 234
    :cond_0
    const-string v3, ""

    .line 235
    .local v3, "rcData":Ljava/lang/String;
    array-length v6, p1

    const/4 v5, 0x0

    :goto_1
    if-ge v5, v6, :cond_1

    aget v0, p1, v5

    .line 236
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 235
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 239
    :cond_1
    const/16 v5, 0xc8

    invoke-virtual {p0, v5, v4}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I[Ljava/lang/Character;)Ljava/util/List;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 240
    return-void
.end method
