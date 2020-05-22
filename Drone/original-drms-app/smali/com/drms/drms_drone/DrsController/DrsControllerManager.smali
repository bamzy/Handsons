.class public Lcom/drms/drms_drone/DrsController/DrsControllerManager;
.super Ljava/lang/Object;
.source "DrsControllerManager.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "DrsControllerManager"


# instance fields
.field private d1:I

.field private d2:I

.field private d3:I

.field private d4:I

.field private d5:I

.field private d6:I

.field private left_resistor:I

.field private multiData:Lcom/drms/drms_drone/MultiData;

.field private pitch:I

.field private pitch_tream:I

.field private power:I

.field private right_resistor:I

.field private roll:I

.field private roll_tream:I

.field private service:Landroid/app/Service;

.field private throttle:I

.field private yaw:I

.field private yaw_tream:I


# direct methods
.method public constructor <init>(Landroid/app/Service;)V
    .locals 1
    .param p1, "service"    # Landroid/app/Service;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->service:Landroid/app/Service;

    .line 29
    invoke-virtual {p1}, Landroid/app/Service;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    .line 30
    return-void
.end method

.method private setAccCalibration(I)V
    .locals 3
    .param p1, "d6"    # I

    .prologue
    .line 207
    const/16 v0, 0xc8

    if-ne p1, v0, :cond_0

    .line 208
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->service:Landroid/app/Service;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "request acc calibration"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Service;->sendBroadcast(Landroid/content/Intent;)V

    .line 210
    :cond_0
    return-void
.end method

.method private setDroneSpeed(I)V
    .locals 6
    .param p1, "d1"    # I

    .prologue
    const/16 v5, 0x190

    const/16 v4, 0x15e

    const/16 v3, 0x12c

    const/16 v2, 0x64

    const/16 v1, 0xc8

    .line 182
    if-ne p1, v1, :cond_0

    .line 183
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v0

    if-ne v0, v2, :cond_1

    .line 184
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/MultiData;->setDRONE_SPEED(I)V

    .line 204
    :cond_0
    :goto_0
    return-void

    .line 187
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v0

    if-ne v0, v1, :cond_2

    .line 188
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0, v3}, Lcom/drms/drms_drone/MultiData;->setDRONE_SPEED(I)V

    goto :goto_0

    .line 191
    :cond_2
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v0

    if-ne v0, v3, :cond_3

    .line 192
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0, v4}, Lcom/drms/drms_drone/MultiData;->setDRONE_SPEED(I)V

    goto :goto_0

    .line 195
    :cond_3
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v0

    if-ne v0, v4, :cond_4

    .line 196
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0, v5}, Lcom/drms/drms_drone/MultiData;->setDRONE_SPEED(I)V

    goto :goto_0

    .line 199
    :cond_4
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v0

    if-ne v0, v5, :cond_0

    .line 200
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0, v2}, Lcom/drms/drms_drone/MultiData;->setDRONE_SPEED(I)V

    goto :goto_0
.end method

.method private setNextDisplay(I)V
    .locals 3
    .param p1, "d5"    # I

    .prologue
    .line 133
    const/16 v0, 0xc8

    if-ne p1, v0, :cond_0

    .line 134
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->service:Landroid/app/Service;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "con.drms.drms_drone.NEXT_DISPLAY"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Service;->sendBroadcast(Landroid/content/Intent;)V

    .line 137
    :cond_0
    return-void
.end method

.method private setPower(I)V
    .locals 6
    .param p1, "aux4"    # I

    .prologue
    const/16 v5, 0x7d0

    const/16 v4, 0x3e8

    const/4 v3, 0x7

    const/4 v2, 0x4

    .line 116
    iget v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->power:I

    const/16 v1, 0xc8

    if-ne v0, v1, :cond_0

    .line 117
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v0

    aget v0, v0, v3

    if-ne v0, v5, :cond_1

    .line 118
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0, v2, v4}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 123
    :cond_0
    :goto_0
    return-void

    .line 119
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v0

    aget v0, v0, v3

    if-ne v0, v4, :cond_0

    .line 120
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0, v2, v5}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto :goto_0
.end method

.method private setPreviousDisplay(I)V
    .locals 3
    .param p1, "d4"    # I

    .prologue
    .line 126
    const/16 v0, 0xc8

    if-ne p1, v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->service:Landroid/app/Service;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.drms.drms_drone.PREVIOUS_DISPLAY"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Service;->sendBroadcast(Landroid/content/Intent;)V

    .line 130
    :cond_0
    return-void
.end method

.method private setRPYT(IIII)V
    .locals 3
    .param p1, "roll"    # I
    .param p2, "pitch"    # I
    .param p3, "yaw"    # I
    .param p4, "throttle"    # I

    .prologue
    .line 108
    add-int/lit16 v0, p1, -0x5dc

    iget-object v1, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v1

    mul-int/2addr v0, v1

    div-int/lit16 v0, v0, 0x1f4

    add-int/lit16 v0, v0, 0x5dc

    iget-object v1, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v1

    const/4 v2, 0x0

    aget v1, v1, v2

    add-int/2addr v0, v1

    iput v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->roll:I

    .line 109
    add-int/lit16 v0, p2, -0x5dc

    iget-object v1, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v1

    mul-int/2addr v0, v1

    div-int/lit16 v0, v0, 0x1f4

    add-int/lit16 v0, v0, 0x5dc

    iget-object v1, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v1

    const/4 v2, 0x1

    aget v1, v1, v2

    add-int/2addr v0, v1

    iput v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->pitch:I

    .line 110
    add-int/lit16 v0, p3, -0x5dc

    iget-object v1, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v1

    mul-int/2addr v0, v1

    div-int/lit16 v0, v0, 0x1f4

    add-int/lit16 v0, v0, 0x5dc

    iget-object v1, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v1

    const/4 v2, 0x2

    aget v1, v1, v2

    add-int/2addr v0, v1

    iput v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->yaw:I

    .line 111
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    iget v1, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->roll:I

    iget v2, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->pitch:I

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 112
    iget-object v0, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    iget v1, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->yaw:I

    iget v2, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->throttle:I

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 113
    return-void
.end method

.method private setTream(III)V
    .locals 8
    .param p1, "roll"    # I
    .param p2, "pitch"    # I
    .param p3, "yaw"    # I

    .prologue
    const/16 v7, 0x96

    const/16 v6, 0x64

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 141
    iget-object v2, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v1

    .line 142
    .local v1, "tream":[I
    iget-object v2, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v0

    .line 144
    .local v0, "interval":I
    const/16 v2, 0xc8

    if-ne p1, v2, :cond_3

    .line 145
    aget v2, v1, v3

    add-int/2addr v2, v0

    aput v2, v1, v3

    .line 154
    :cond_0
    :goto_0
    const/16 v2, 0xc8

    if-ne p2, v2, :cond_5

    .line 155
    aget v2, v1, v4

    add-int/2addr v2, v0

    aput v2, v1, v4

    .line 164
    :cond_1
    :goto_1
    const/16 v2, 0xc8

    if-ne p3, v2, :cond_7

    .line 165
    aget v2, v1, v5

    add-int/2addr v2, v0

    aput v2, v1, v5

    .line 174
    :cond_2
    :goto_2
    iget-object v2, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    aget v3, v1, v3

    invoke-virtual {v2, v3}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 175
    iget-object v2, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    aget v3, v1, v4

    invoke-virtual {v2, v3}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 176
    iget-object v2, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->multiData:Lcom/drms/drms_drone/MultiData;

    aget v3, v1, v5

    invoke-virtual {v2, v3}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 179
    return-void

    .line 147
    :cond_3
    if-ne p1, v6, :cond_4

    .line 148
    aget v2, v1, v3

    sub-int/2addr v2, v0

    aput v2, v1, v3

    goto :goto_0

    .line 150
    :cond_4
    if-ne p1, v7, :cond_0

    goto :goto_0

    .line 157
    :cond_5
    if-ne p2, v6, :cond_6

    .line 158
    aget v2, v1, v4

    sub-int/2addr v2, v0

    aput v2, v1, v4

    goto :goto_1

    .line 160
    :cond_6
    if-ne p2, v7, :cond_1

    goto :goto_1

    .line 167
    :cond_7
    if-ne p3, v6, :cond_8

    .line 168
    aget v2, v1, v5

    sub-int/2addr v2, v0

    aput v2, v1, v5

    goto :goto_2

    .line 170
    :cond_8
    if-ne p3, v7, :cond_2

    goto :goto_2
.end method


# virtual methods
.method public processControllerData([B)Z
    .locals 11
    .param p1, "data"    # [B

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 33
    array-length v8, p1

    if-lez v8, :cond_1

    .line 35
    aget-byte v8, p1, v6

    int-to-char v8, v8

    const/16 v9, 0x23

    if-ne v8, v9, :cond_4

    array-length v8, p1

    const/16 v9, 0x1c

    if-ne v8, v9, :cond_4

    .line 36
    const/16 v8, 0xe

    new-array v5, v8, [I

    .line 37
    .local v5, "recvdata":[I
    const-string v1, ""

    .line 38
    .local v1, "header":Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    const/4 v8, 0x5

    if-ge v2, v8, :cond_0

    .line 39
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    aget-byte v9, p1, v2

    int-to-char v9, v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 38
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 42
    :cond_0
    const/4 v3, 0x5

    .line 43
    .local v3, "index":I
    const/4 v0, 0x0

    .line 44
    .local v0, "checksum":B
    const-string v8, "#cont"

    invoke-virtual {v1, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_2

    .line 104
    .end local v0    # "checksum":B
    .end local v1    # "header":Ljava/lang/String;
    .end local v2    # "i":I
    .end local v3    # "index":I
    .end local v5    # "recvdata":[I
    :cond_1
    :goto_1
    return v6

    .line 48
    .restart local v0    # "checksum":B
    .restart local v1    # "header":Ljava/lang/String;
    .restart local v2    # "i":I
    .restart local v3    # "index":I
    .restart local v5    # "recvdata":[I
    :cond_2
    const/4 v2, 0x0

    move v4, v3

    .end local v3    # "index":I
    .local v4, "index":I
    :goto_2
    const/16 v8, 0x16

    if-ge v2, v8, :cond_3

    .line 49
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v8, p1, v4

    xor-int/2addr v8, v0

    int-to-byte v0, v8

    .line 48
    add-int/lit8 v2, v2, 0x1

    move v4, v3

    .end local v3    # "index":I
    .restart local v4    # "index":I
    goto :goto_2

    .line 52
    :cond_3
    array-length v8, p1

    add-int/lit8 v8, v8, -0x1

    aget-byte v8, p1, v8

    if-ne v0, v8, :cond_1

    .line 53
    const/4 v3, 0x5

    .line 55
    .end local v4    # "index":I
    .restart local v3    # "index":I
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .restart local v4    # "index":I
    aget-byte v6, p1, v3

    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v8, p1, v4

    invoke-virtual {p0, v6, v8}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read16(BB)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->roll:I

    .line 56
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .restart local v4    # "index":I
    aget-byte v6, p1, v3

    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v8, p1, v4

    invoke-virtual {p0, v6, v8}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read16(BB)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->pitch:I

    .line 57
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .restart local v4    # "index":I
    aget-byte v6, p1, v3

    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v8, p1, v4

    invoke-virtual {p0, v6, v8}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read16(BB)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->yaw:I

    .line 58
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .restart local v4    # "index":I
    aget-byte v6, p1, v3

    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v8, p1, v4

    invoke-virtual {p0, v6, v8}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read16(BB)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->throttle:I

    .line 60
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .restart local v4    # "index":I
    aget-byte v6, p1, v3

    invoke-virtual {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read8(B)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->power:I

    .line 61
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v6, p1, v4

    invoke-virtual {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read8(B)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->d1:I

    .line 62
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .restart local v4    # "index":I
    aget-byte v6, p1, v3

    invoke-virtual {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read8(B)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->d2:I

    .line 63
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v6, p1, v4

    invoke-virtual {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read8(B)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->d3:I

    .line 64
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .restart local v4    # "index":I
    aget-byte v6, p1, v3

    invoke-virtual {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read8(B)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->d4:I

    .line 65
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v6, p1, v4

    invoke-virtual {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read8(B)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->d5:I

    .line 66
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .restart local v4    # "index":I
    aget-byte v6, p1, v3

    invoke-virtual {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read8(B)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->d6:I

    .line 68
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v6, p1, v4

    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .restart local v4    # "index":I
    aget-byte v8, p1, v3

    invoke-virtual {p0, v6, v8}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read16(BB)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->left_resistor:I

    .line 69
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v6, p1, v4

    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .restart local v4    # "index":I
    aget-byte v8, p1, v3

    invoke-virtual {p0, v6, v8}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read16(BB)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->right_resistor:I

    .line 71
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v6, p1, v4

    invoke-virtual {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read8(B)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->roll_tream:I

    .line 72
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .restart local v4    # "index":I
    aget-byte v6, p1, v3

    invoke-virtual {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read8(B)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->pitch_tream:I

    .line 73
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    aget-byte v6, p1, v4

    invoke-virtual {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->read8(B)I

    move-result v6

    iput v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->yaw_tream:I

    .line 86
    iget v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->roll:I

    iget v8, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->pitch:I

    iget v9, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->yaw:I

    iget v10, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->throttle:I

    invoke-direct {p0, v6, v8, v9, v10}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->setRPYT(IIII)V

    .line 87
    iget v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->power:I

    invoke-direct {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->setPower(I)V

    .line 88
    iget v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->d1:I

    invoke-direct {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->setDroneSpeed(I)V

    .line 89
    iget v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->d6:I

    invoke-direct {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->setAccCalibration(I)V

    .line 90
    iget v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->roll_tream:I

    iget v8, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->pitch_tream:I

    iget v9, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->yaw_tream:I

    invoke-direct {p0, v6, v8, v9}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->setTream(III)V

    .line 91
    iget v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->d4:I

    invoke-direct {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->setPreviousDisplay(I)V

    .line 92
    iget v6, p0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->d5:I

    invoke-direct {p0, v6}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->setNextDisplay(I)V

    move v6, v7

    .line 98
    goto/16 :goto_1

    .end local v0    # "checksum":B
    .end local v1    # "header":Ljava/lang/String;
    .end local v2    # "i":I
    .end local v3    # "index":I
    .end local v5    # "recvdata":[I
    :cond_4
    move v6, v7

    .line 104
    goto/16 :goto_1
.end method

.method public read16(BB)I
    .locals 2
    .param p1, "int_16_1"    # B
    .param p2, "int_16_2"    # B

    .prologue
    .line 217
    and-int/lit16 v0, p1, 0xff

    shl-int/lit8 v1, p2, 0x8

    add-int/2addr v0, v1

    return v0
.end method

.method public read8(B)I
    .locals 1
    .param p1, "int_8_1"    # B

    .prologue
    .line 213
    and-int/lit16 v0, p1, 0xff

    return v0
.end method
