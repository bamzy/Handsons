.class public final Lcom/drms/drms_drone/MultiData;
.super Landroid/app/Application;
.source "MultiData.java"


# static fields
.field private static BtAddress:Ljava/lang/String; = null

.field private static BtName:Ljava/lang/String; = null

.field private static DISCOVER_LOOP:J = 0x0L

.field public static final DUAL1:I = 0x0

.field public static final DUAL2:I = 0x1

.field public static final PITCH_DOWN:I = 0x2

.field public static final PITCH_UP:I = 0x3

.field public static final ROLL_DOWN:I = 0x0

.field public static final ROLL_UP:I = 0x1

.field public static final SINGLE:I = 0x2

.field public static final YAW_DOWN:I = 0x4

.field public static final YAW_UP:I = 0x5

.field public static final fast:I = 0x15e

.field public static final middle:I = 0x12c

.field public static final slow:I = 0xc8

.field public static final veryfast:I = 0x190

.field public static final veryslow:I = 0x64


# instance fields
.field private ALTITUDEdata:[F

.field private BOX_ITEM:[Ljava/lang/String;

.field private DRONE_SPEED:I

.field private HEX_GY521_EEPROM:[B

.field private IMUdata:[I

.field private MISCdata:[F

.field private MSP_TIME:I

.field private MYJOYSTICK:I

.field private PIDdata:[I

.field private QUAD_GY521_EEPROM:[B

.field private RCTUNEdata:[F

.field private analogData:[F

.field private attitudeData:[F

.field private calibration:[Z

.field private checkboxData:[[Z

.field public controllerConnected:Z

.field private identData:[I

.field private locked:Z

.field private mobile_vbat:I

.field private rawRCData:[I

.field private rcdata:[I

.field private receivedRcdata:[I

.field private sendcheckboxData:[[Z

.field private smartphoneAngle:I

.field private tream:[I

.field private treamInterval:I

.field private tream_touched:[Z

.field private tts:Landroid/speech/tts/TextToSpeech;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 21
    const-string v0, ""

    sput-object v0, Lcom/drms/drms_drone/MultiData;->BtName:Ljava/lang/String;

    .line 22
    const-string v0, ""

    sput-object v0, Lcom/drms/drms_drone/MultiData;->BtAddress:Ljava/lang/String;

    .line 24
    const-wide/16 v0, 0x1b58

    sput-wide v0, Lcom/drms/drms_drone/MultiData;->DISCOVER_LOOP:J

    return-void
.end method

.method public constructor <init>()V
    .locals 6

    .prologue
    const/4 v5, 0x4

    const/4 v4, 0x2

    const/4 v3, 0x3

    const/16 v1, 0x8

    const/4 v2, 0x0

    .line 13
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    .line 26
    iput v2, p0, Lcom/drms/drms_drone/MultiData;->mobile_vbat:I

    .line 34
    const/16 v0, 0x12c

    iput v0, p0, Lcom/drms/drms_drone/MultiData;->DRONE_SPEED:I

    .line 36
    const/16 v0, 0x32

    iput v0, p0, Lcom/drms/drms_drone/MultiData;->smartphoneAngle:I

    .line 38
    iput v2, p0, Lcom/drms/drms_drone/MultiData;->MYJOYSTICK:I

    .line 40
    const/16 v0, 0x17

    iput v0, p0, Lcom/drms/drms_drone/MultiData;->MSP_TIME:I

    .line 42
    iput v3, p0, Lcom/drms/drms_drone/MultiData;->treamInterval:I

    .line 46
    new-array v0, v3, [I

    fill-array-data v0, :array_0

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->tream:[I

    .line 57
    const/4 v0, 0x6

    new-array v0, v0, [Z

    fill-array-data v0, :array_1

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->tream_touched:[Z

    .line 76
    iput-boolean v2, p0, Lcom/drms/drms_drone/MultiData;->locked:Z

    .line 78
    new-array v0, v5, [I

    fill-array-data v0, :array_2

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->identData:[I

    .line 82
    new-array v0, v1, [I

    fill-array-data v0, :array_3

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->rcdata:[I

    .line 93
    new-array v0, v1, [I

    fill-array-data v0, :array_4

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->receivedRcdata:[I

    .line 103
    new-array v0, v3, [F

    fill-array-data v0, :array_5

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->attitudeData:[F

    .line 108
    new-array v0, v5, [F

    fill-array-data v0, :array_6

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    .line 115
    new-array v0, v1, [I

    fill-array-data v0, :array_7

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    .line 119
    const/16 v0, 0x9

    new-array v0, v0, [I

    fill-array-data v0, :array_8

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->IMUdata:[I

    .line 123
    const/16 v0, 0xc

    new-array v0, v0, [F

    fill-array-data v0, :array_9

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->MISCdata:[F

    .line 127
    const/4 v0, 0x7

    new-array v0, v0, [F

    fill-array-data v0, :array_a

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->RCTUNEdata:[F

    .line 131
    const/16 v0, 0x1e

    new-array v0, v0, [I

    fill-array-data v0, :array_b

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->PIDdata:[I

    .line 137
    new-array v0, v4, [F

    fill-array-data v0, :array_c

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->ALTITUDEdata:[F

    .line 139
    new-array v0, v4, [Z

    fill-array-data v0, :array_d

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->calibration:[Z

    .line 142
    const/16 v0, 0xc

    filled-new-array {v1, v0}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[Z

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->sendcheckboxData:[[Z

    .line 156
    iput-boolean v2, p0, Lcom/drms/drms_drone/MultiData;->controllerConnected:Z

    .line 441
    const/16 v0, 0x8c

    new-array v0, v0, [B

    fill-array-data v0, :array_e

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->QUAD_GY521_EEPROM:[B

    .line 463
    const/16 v0, 0x8c

    new-array v0, v0, [B

    fill-array-data v0, :array_f

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->HEX_GY521_EEPROM:[B

    return-void

    .line 46
    :array_0
    .array-data 4
        0x0
        0x0
        0x0
    .end array-data

    .line 57
    :array_1
    .array-data 1
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
    .end array-data

    .line 78
    nop

    :array_2
    .array-data 4
        0x0
        0x0
        0x0
        0x0
    .end array-data

    .line 82
    :array_3
    .array-data 4
        0x5dc
        0x5dc
        0x5dc
        0x3e8
        0x3e8
        0x3e8
        0x3e8
        0x3e8
    .end array-data

    .line 93
    :array_4
    .array-data 4
        0x5dc
        0x5dc
        0x5dc
        0x3e8
        0x3e8
        0x3e8
        0x3e8
        0x3e8
    .end array-data

    .line 103
    :array_5
    .array-data 4
        0x0
        0x0
        0x0
    .end array-data

    .line 108
    :array_6
    .array-data 4
        0x40866666
        0x0
        0x0
        0x0
    .end array-data

    .line 115
    :array_7
    .array-data 4
        0x5dc
        0x5dc
        0x5dc
        0x3e8
        0x3e8
        0x3e8
        0x3e8
        0x3e8
    .end array-data

    .line 119
    :array_8
    .array-data 4
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

    .line 123
    :array_9
    .array-data 4
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

    .line 127
    :array_a
    .array-data 4
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

    .line 131
    :array_b
    .array-data 4
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

    .line 137
    :array_c
    .array-data 4
        0x0
        0x0
    .end array-data

    .line 139
    :array_d
    .array-data 1
        0x0t
        0x0t
    .end array-data

    .line 441
    nop

    :array_e
    .array-data 1
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        0x21t
        0x1et
        0x17t
        0x21t
        0x1et
        0x17t
        0x44t
        0x2dt
        0x0t
        0x40t
        0x19t
        0x18t
        0xft
        0x0t
        0x0t
        0x22t
        0xet
        0x35t
        0x19t
        0x21t
        0x53t
        0x5at
        0xat
        0x64t
        0x28t
        -0x1t
        -0x1t
        0x0t
        0x0t
        0x0t
        0x57t
        0x3et
        0x0t
        0x0t
        0x0t
        0x32t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x8t
        0x7t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1et
        0x4t
        0xat
        0x54t
        0x4bt
        0x45t
        0x1at
        0x4t
        0xat
        0x78t
        0x0t
        -0x1ct
    .end array-data

    .line 463
    :array_f
    .array-data 1
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        0x21t
        0x1et
        0x17t
        0x21t
        0x1et
        0x17t
        0x44t
        0x2dt
        0x0t
        0x40t
        0x19t
        0x18t
        0xft
        0x0t
        0x0t
        0x22t
        0xet
        0x35t
        0x19t
        0x21t
        0x53t
        0x5at
        0xat
        0x64t
        0x28t
        -0x1t
        -0x1t
        0x0t
        0x0t
        0x0t
        0x5at
        0x41t
        0x0t
        0x0t
        0x0t
        0x32t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x8t
        0x7t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1et
        0x4t
        0xat
        0x6bt
        0x64t
        0x54t
        0x1at
        0x4t
        0xat
        0x78t
        0x0t
        0x29t
    .end array-data
.end method


# virtual methods
.method public getALTITUDEdata()[F
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->ALTITUDEdata:[F

    return-object v0
.end method

.method public getAnalogData()[F
    .locals 1

    .prologue
    .line 339
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    return-object v0
.end method

.method public getAttitudeData()[F
    .locals 1

    .prologue
    .line 301
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->attitudeData:[F

    return-object v0
.end method

.method public getBoxITEM()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->BOX_ITEM:[Ljava/lang/String;

    return-object v0
.end method

.method public getCalibration()[Z
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->calibration:[Z

    return-object v0
.end method

.method public getCheckboxData()[[Z
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->checkboxData:[[Z

    return-object v0
.end method

.method public getDRONE_SPEED()I
    .locals 1

    .prologue
    .line 233
    iget v0, p0, Lcom/drms/drms_drone/MultiData;->DRONE_SPEED:I

    return v0
.end method

.method public getDiscoverLoop()J
    .locals 2

    .prologue
    .line 285
    sget-wide v0, Lcom/drms/drms_drone/MultiData;->DISCOVER_LOOP:J

    return-wide v0
.end method

.method public getHEX_GY521_EEPROM()[B
    .locals 1

    .prologue
    .line 482
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->QUAD_GY521_EEPROM:[B

    return-object v0
.end method

.method public getIMUdata()[I
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->IMUdata:[I

    return-object v0
.end method

.method public getLocked()Z
    .locals 1

    .prologue
    .line 274
    iget-boolean v0, p0, Lcom/drms/drms_drone/MultiData;->locked:Z

    return v0
.end method

.method public getMISCdata()[F
    .locals 1

    .prologue
    .line 217
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->MISCdata:[F

    return-object v0
.end method

.method public getMSP_TIME()I
    .locals 1

    .prologue
    .line 229
    iget v0, p0, Lcom/drms/drms_drone/MultiData;->MSP_TIME:I

    return v0
.end method

.method public getMYJOYSTICK()I
    .locals 1

    .prologue
    .line 72
    iget v0, p0, Lcom/drms/drms_drone/MultiData;->MYJOYSTICK:I

    return v0
.end method

.method public getMobile_vbat()I
    .locals 1

    .prologue
    .line 266
    iget v0, p0, Lcom/drms/drms_drone/MultiData;->mobile_vbat:I

    return v0
.end method

.method public getPIDdata()[I
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->PIDdata:[I

    return-object v0
.end method

.method public getQUAD_GY521_EEPROM()[B
    .locals 1

    .prologue
    .line 460
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->QUAD_GY521_EEPROM:[B

    return-object v0
.end method

.method public getRCTUNEdata()[F
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->RCTUNEdata:[F

    return-object v0
.end method

.method public getRcdata()[I
    .locals 1

    .prologue
    .line 293
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    return-object v0
.end method

.method public getReceivedRcdata()[I
    .locals 1

    .prologue
    .line 309
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->receivedRcdata:[I

    return-object v0
.end method

.method public getSmartphoneAngle()I
    .locals 1

    .prologue
    .line 237
    iget v0, p0, Lcom/drms/drms_drone/MultiData;->smartphoneAngle:I

    return v0
.end method

.method public getTream()[I
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->tream:[I

    return-object v0
.end method

.method public getTreamInterval()I
    .locals 1

    .prologue
    .line 181
    iget v0, p0, Lcom/drms/drms_drone/MultiData;->treamInterval:I

    return v0
.end method

.method public getTream_touched()[Z
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->tream_touched:[Z

    return-object v0
.end method

.method public initBoxITEM([Ljava/lang/String;)V
    .locals 3
    .param p1, "boxitem"    # [Ljava/lang/String;

    .prologue
    .line 166
    iput-object p1, p0, Lcom/drms/drms_drone/MultiData;->BOX_ITEM:[Ljava/lang/String;

    .line 167
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->BOX_ITEM:[Ljava/lang/String;

    array-length v0, v0

    const/16 v1, 0xc

    filled-new-array {v0, v1}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[Z

    iput-object v0, p0, Lcom/drms/drms_drone/MultiData;->checkboxData:[[Z

    .line 168
    const-string v0, "ContentValues"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "box item length : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    array-length v2, p1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 169
    return-void
.end method

.method public initializeMultiData()V
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    const/16 v6, 0x5dc

    const/4 v5, 0x0

    const/16 v4, 0x3e8

    .line 373
    iput v5, p0, Lcom/drms/drms_drone/MultiData;->mobile_vbat:I

    .line 375
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rcdata:[I

    aput v6, v2, v5

    .line 376
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rcdata:[I

    aput v6, v2, v8

    .line 377
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rcdata:[I

    const/4 v3, 0x2

    aput v6, v2, v3

    .line 378
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rcdata:[I

    const/4 v3, 0x3

    aput v4, v2, v3

    .line 379
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rcdata:[I

    const/4 v3, 0x4

    aput v4, v2, v3

    .line 380
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rcdata:[I

    const/4 v3, 0x5

    aput v4, v2, v3

    .line 381
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rcdata:[I

    const/4 v3, 0x6

    aput v4, v2, v3

    .line 382
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rcdata:[I

    const/4 v3, 0x7

    aput v4, v2, v3

    .line 384
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->receivedRcdata:[I

    aput v6, v2, v5

    .line 385
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->receivedRcdata:[I

    aput v6, v2, v8

    .line 386
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->receivedRcdata:[I

    const/4 v3, 0x2

    aput v6, v2, v3

    .line 387
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->receivedRcdata:[I

    const/4 v3, 0x3

    aput v4, v2, v3

    .line 388
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->receivedRcdata:[I

    const/4 v3, 0x4

    aput v4, v2, v3

    .line 389
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->receivedRcdata:[I

    const/4 v3, 0x5

    aput v4, v2, v3

    .line 390
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->receivedRcdata:[I

    const/4 v3, 0x6

    aput v4, v2, v3

    .line 391
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->receivedRcdata:[I

    const/4 v3, 0x7

    aput v4, v2, v3

    .line 393
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->attitudeData:[F

    aput v7, v2, v5

    .line 394
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->attitudeData:[F

    aput v7, v2, v8

    .line 395
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->attitudeData:[F

    const/4 v3, 0x2

    aput v7, v2, v3

    .line 397
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    const v3, 0x40866666

    aput v3, v2, v5

    .line 398
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    aput v7, v2, v8

    .line 399
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    const/4 v3, 0x2

    aput v7, v2, v3

    .line 400
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    const/4 v3, 0x3

    aput v7, v2, v3

    .line 402
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    aput v6, v2, v5

    .line 403
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    aput v6, v2, v8

    .line 404
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    const/4 v3, 0x2

    aput v6, v2, v3

    .line 405
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    const/4 v3, 0x3

    aput v4, v2, v3

    .line 406
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    const/4 v3, 0x4

    aput v4, v2, v3

    .line 407
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    const/4 v3, 0x5

    aput v4, v2, v3

    .line 408
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    const/4 v3, 0x6

    aput v4, v2, v3

    .line 409
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    const/4 v3, 0x7

    aput v4, v2, v3

    .line 411
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->calibration:[Z

    aput-boolean v5, v2, v5

    .line 412
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->calibration:[Z

    aput-boolean v5, v2, v8

    .line 414
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->IMUdata:[I

    array-length v2, v2

    if-ge v0, v2, :cond_0

    .line 415
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->IMUdata:[I

    aput v5, v2, v0

    .line 414
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 418
    :cond_0
    const/4 v0, 0x0

    :goto_1
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->MISCdata:[F

    array-length v2, v2

    if-ge v0, v2, :cond_1

    .line 419
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->MISCdata:[F

    aput v7, v2, v0

    .line 418
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 422
    :cond_1
    const/4 v0, 0x0

    :goto_2
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->RCTUNEdata:[F

    array-length v2, v2

    if-ge v0, v2, :cond_2

    .line 423
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->RCTUNEdata:[F

    aput v7, v2, v5

    .line 422
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 426
    :cond_2
    const/4 v0, 0x0

    :goto_3
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->PIDdata:[I

    array-length v2, v2

    if-ge v0, v2, :cond_3

    .line 427
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->PIDdata:[I

    aput v5, v2, v0

    .line 426
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 430
    :cond_3
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->BOX_ITEM:[Ljava/lang/String;

    if-eqz v2, :cond_5

    .line 431
    const/4 v0, 0x0

    :goto_4
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->BOX_ITEM:[Ljava/lang/String;

    array-length v2, v2

    if-ge v0, v2, :cond_5

    .line 432
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_5
    const/16 v2, 0xc

    if-ge v1, v2, :cond_4

    .line 433
    iget-object v2, p0, Lcom/drms/drms_drone/MultiData;->checkboxData:[[Z

    aget-object v2, v2, v0

    aput-boolean v5, v2, v1

    .line 432
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    .line 431
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 438
    .end local v1    # "j":I
    :cond_5
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/drms/drms_drone/MultiData;->BOX_ITEM:[Ljava/lang/String;

    .line 439
    return-void
.end method

.method public isControllerConnected()Z
    .locals 1

    .prologue
    .line 162
    iget-boolean v0, p0, Lcom/drms/drms_drone/MultiData;->controllerConnected:Z

    return v0
.end method

.method public setACCCalibration(Z)V
    .locals 2
    .param p1, "accCalibration"    # Z

    .prologue
    .line 250
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->calibration:[Z

    const/4 v1, 0x0

    aput-boolean p1, v0, v1

    .line 251
    return-void
.end method

.method public setALTITUDEdata([F)V
    .locals 0
    .param p1, "altitude"    # [F

    .prologue
    .line 145
    iput-object p1, p0, Lcom/drms/drms_drone/MultiData;->ALTITUDEdata:[F

    .line 146
    return-void
.end method

.method public setAnalogData([F)V
    .locals 5
    .param p1, "analogData"    # [F

    .prologue
    const/4 v4, 0x0

    .line 313
    iput-object p1, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    .line 314
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    aget v0, v0, v4

    float-to-double v0, v0

    const-wide/high16 v2, 0x4004000000000000L    # 2.5

    cmpg-double v0, v0, v2

    if-gez v0, :cond_0

    .line 315
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    aget v0, v0, v4

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_1

    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    aget v0, v0, v4

    float-to-double v0, v0

    const-wide v2, 0x3fc999999999999aL    # 0.2

    cmpg-double v0, v0, v2

    if-gez v0, :cond_1

    .line 316
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    const v1, 0x3dcccccd

    aput v1, v0, v4

    .line 321
    :cond_0
    :goto_0
    return-void

    .line 319
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->analogData:[F

    const/high16 v1, 0x40200000    # 2.5f

    aput v1, v0, v4

    goto :goto_0
.end method

.method public setAttitudeData([F)V
    .locals 0
    .param p1, "attitudeData"    # [F

    .prologue
    .line 297
    iput-object p1, p0, Lcom/drms/drms_drone/MultiData;->attitudeData:[F

    .line 298
    return-void
.end method

.method public setCheckboxData([[Z)V
    .locals 0
    .param p1, "checkdata"    # [[Z

    .prologue
    .line 189
    iput-object p1, p0, Lcom/drms/drms_drone/MultiData;->checkboxData:[[Z

    .line 191
    return-void
.end method

.method public setControllerConnected(Z)V
    .locals 0
    .param p1, "connected"    # Z

    .prologue
    .line 158
    iput-boolean p1, p0, Lcom/drms/drms_drone/MultiData;->controllerConnected:Z

    .line 159
    return-void
.end method

.method public setDRONE_SPEED(I)V
    .locals 3
    .param p1, "DRONE_SPEED"    # I

    .prologue
    .line 245
    const-string v0, "ContentValues"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "drone speed : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 246
    iput p1, p0, Lcom/drms/drms_drone/MultiData;->DRONE_SPEED:I

    .line 247
    return-void
.end method

.method public setDiscoverLoop(J)V
    .locals 1
    .param p1, "discoverLoop"    # J

    .prologue
    .line 281
    sput-wide p1, Lcom/drms/drms_drone/MultiData;->DISCOVER_LOOP:J

    .line 282
    return-void
.end method

.method public setEachCheckboxData(IIZ)V
    .locals 1
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "checked"    # Z

    .prologue
    .line 185
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->checkboxData:[[Z

    aget-object v0, v0, p1

    aput-boolean p3, v0, p2

    .line 186
    return-void
.end method

.method public setIMUdata([I)V
    .locals 0
    .param p1, "IMUdata"    # [I

    .prologue
    .line 221
    iput-object p1, p0, Lcom/drms/drms_drone/MultiData;->IMUdata:[I

    .line 222
    return-void
.end method

.method public setLocked(Z)V
    .locals 0
    .param p1, "locked"    # Z

    .prologue
    .line 278
    iput-boolean p1, p0, Lcom/drms/drms_drone/MultiData;->locked:Z

    .line 279
    return-void
.end method

.method public setMAGCalibration(Z)V
    .locals 2
    .param p1, "magCalibration"    # Z

    .prologue
    .line 254
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->calibration:[Z

    const/4 v1, 0x1

    aput-boolean p1, v0, v1

    .line 255
    return-void
.end method

.method public setMISCdata([F)V
    .locals 0
    .param p1, "MISCdata"    # [F

    .prologue
    .line 213
    iput-object p1, p0, Lcom/drms/drms_drone/MultiData;->MISCdata:[F

    .line 214
    return-void
.end method

.method public setMYJOYSTICK(I)V
    .locals 0
    .param p1, "MYJOYSTICK"    # I

    .prologue
    .line 68
    iput p1, p0, Lcom/drms/drms_drone/MultiData;->MYJOYSTICK:I

    .line 69
    return-void
.end method

.method public setMobile_vbat(I)V
    .locals 0
    .param p1, "vbat"    # I

    .prologue
    .line 262
    iput p1, p0, Lcom/drms/drms_drone/MultiData;->mobile_vbat:I

    .line 263
    return-void
.end method

.method public setPIDdata([I)V
    .locals 0
    .param p1, "piddata"    # [I

    .prologue
    .line 195
    iput-object p1, p0, Lcom/drms/drms_drone/MultiData;->PIDdata:[I

    .line 196
    return-void
.end method

.method public setPitchTream(I)V
    .locals 2
    .param p1, "pitchTream"    # I

    .prologue
    .line 353
    const/16 v0, 0x7f

    if-lt p1, v0, :cond_0

    .line 354
    const/16 p1, 0x7f

    .line 356
    :cond_0
    const/16 v0, -0x7f

    if-gt p1, v0, :cond_1

    .line 357
    const/16 p1, -0x7f

    .line 359
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->tream:[I

    const/4 v1, 0x1

    aput p1, v0, v1

    .line 360
    return-void
.end method

.method public setRCTUNEdata([F)V
    .locals 0
    .param p1, "RCTUNEdata"    # [F

    .prologue
    .line 204
    iput-object p1, p0, Lcom/drms/drms_drone/MultiData;->RCTUNEdata:[F

    .line 205
    return-void
.end method

.method public setRawRCDataAux(II)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "value"    # I

    .prologue
    .line 335
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    add-int/lit8 v1, p1, 0x3

    aput p2, v0, v1

    .line 336
    return-void
.end method

.method public setRawRCDataRollPitch(II)V
    .locals 2
    .param p1, "roll"    # I
    .param p2, "pitch"    # I

    .prologue
    .line 324
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    const/4 v1, 0x0

    aput p1, v0, v1

    .line 325
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    const/4 v1, 0x1

    aput p2, v0, v1

    .line 327
    return-void
.end method

.method public setRawRCDataYawThrottle(II)V
    .locals 2
    .param p1, "yaw"    # I
    .param p2, "throttle"    # I

    .prologue
    .line 330
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    const/4 v1, 0x2

    aput p1, v0, v1

    .line 331
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->rawRCData:[I

    const/4 v1, 0x3

    aput p2, v0, v1

    .line 332
    return-void
.end method

.method public setRcdata([I)V
    .locals 0
    .param p1, "rc"    # [I

    .prologue
    .line 289
    iput-object p1, p0, Lcom/drms/drms_drone/MultiData;->rcdata:[I

    .line 290
    return-void
.end method

.method public setReceivedRcdata([I)V
    .locals 0
    .param p1, "receivedRcdata"    # [I

    .prologue
    .line 305
    iput-object p1, p0, Lcom/drms/drms_drone/MultiData;->receivedRcdata:[I

    .line 306
    return-void
.end method

.method public setRollTream(I)V
    .locals 2
    .param p1, "rollTream"    # I

    .prologue
    .line 343
    const/16 v0, 0x7f

    if-lt p1, v0, :cond_0

    .line 344
    const/16 p1, 0x7f

    .line 346
    :cond_0
    const/16 v0, -0x7f

    if-gt p1, v0, :cond_1

    .line 347
    const/16 p1, -0x7f

    .line 349
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->tream:[I

    const/4 v1, 0x0

    aput p1, v0, v1

    .line 350
    return-void
.end method

.method public setSmartphoneAngle(I)V
    .locals 0
    .param p1, "smartphoneAngle"    # I

    .prologue
    .line 241
    iput p1, p0, Lcom/drms/drms_drone/MultiData;->smartphoneAngle:I

    .line 242
    return-void
.end method

.method public setTreamInterval(I)V
    .locals 0
    .param p1, "treamInterval"    # I

    .prologue
    .line 177
    iput p1, p0, Lcom/drms/drms_drone/MultiData;->treamInterval:I

    .line 178
    return-void
.end method

.method public setTream_touched(IZ)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "state"    # Z

    .prologue
    .line 60
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->tream_touched:[Z

    aput-boolean p2, v0, p1

    .line 61
    return-void
.end method

.method public setYawTream(I)V
    .locals 2
    .param p1, "yawTream"    # I

    .prologue
    .line 363
    const/16 v0, 0x7f

    if-lt p1, v0, :cond_0

    .line 364
    const/16 p1, 0x7f

    .line 366
    :cond_0
    const/16 v0, -0x7f

    if-gt p1, v0, :cond_1

    .line 367
    const/16 p1, -0x7f

    .line 369
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/MultiData;->tream:[I

    const/4 v1, 0x2

    aput p1, v0, v1

    .line 370
    return-void
.end method
