.class public Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;
.super Ljava/lang/Object;
.source "STK500v1.java"


# static fields
.field public static final MODE_REQUEST:I = 0x1

.field private static final ORIENT_COMMAND:I = 0x14

.field private static final RECEIVED_MESSAGE:I = 0x15

.field private static final TAG:Ljava/lang/String; = "STK500"

.field private static final UPLOADPROGRESS:I = 0x16

.field private static final UPLOAD_STATE:I = 0x17


# instance fields
.field private bluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

.field private bytesToLoad:I

.field private command_set:[B

.field private complete_size:I

.field private conststk500:Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;

.field endTime:J

.field private hexParser:Lcom/drms/drms_drone/Protocol/STK500v1/Hex;

.field private hexPosition:I

.field private inputstream:Ljava/io/InputStream;

.field loadAddress_each_success:Z

.field loadAddress_success:Z

.field private mActivity:Landroid/app/Activity;

.field private mHandler:Landroid/os/Handler;

.field private mspdata:Lcom/drms/drms_drone/MultiData;

.field private outstream:Ljava/io/OutputStream;

.field programMode_entered:Z

.field programMode_left:Z

.field programPage_each_success:Z

.field programPage_success:Z

.field private request:I

.field public running:Z

.field startTime:J

.field public stk500_handler:Landroid/os/Handler;

.field triesToleaveProgrammode:I

.field uploadFileTries:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/os/Handler;I)V
    .locals 2
    .param p1, "mActivity"    # Landroid/app/Activity;
    .param p2, "bluetoothservice"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
    .param p3, "mHandler"    # Landroid/os/Handler;
    .param p4, "request"    # I

    .prologue
    const/4 v1, 0x0

    .line 139
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->bytesToLoad:I

    .line 47
    iput v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexPosition:I

    .line 48
    iput v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->complete_size:I

    .line 50
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->running:Z

    .line 56
    iput-boolean v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_entered:Z

    .line 57
    iput-boolean v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_success:Z

    .line 58
    iput-boolean v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_left:Z

    .line 59
    iput-boolean v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_success:Z

    .line 61
    iput-boolean v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_each_success:Z

    .line 62
    iput-boolean v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_each_success:Z

    .line 64
    iput v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->triesToleaveProgrammode:I

    .line 70
    new-instance v0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;-><init>(Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->stk500_handler:Landroid/os/Handler;

    .line 278
    iput v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->uploadFileTries:I

    .line 142
    iput-object p2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->bluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .line 143
    iput-object p3, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mHandler:Landroid/os/Handler;

    .line 144
    iput-object p1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mActivity:Landroid/app/Activity;

    .line 145
    iput p4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->request:I

    .line 146
    invoke-virtual {p1}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 147
    if-nez p4, :cond_1

    .line 148
    iget-object v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getQUAD_GY521_EEPROM()[B

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->command_set:[B

    .line 154
    :cond_0
    :goto_0
    new-instance v0, Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;

    invoke-direct {v0}, Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;-><init>()V

    iput-object v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->conststk500:Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;

    .line 155
    return-void

    .line 150
    :cond_1
    const/4 v0, 0x3

    if-ne p4, v0, :cond_0

    .line 151
    iget-object v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getHEX_GY521_EEPROM()[B

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->command_set:[B

    goto :goto_0
.end method

.method private enterProgramMode()Z
    .locals 7

    .prologue
    const/16 v6, 0x50

    const/4 v5, 0x1

    .line 233
    const/4 v1, 0x0

    .line 234
    .local v1, "entered":Z
    const/4 v2, 0x2

    new-array v0, v2, [B

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->conststk500:Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;

    aput-byte v6, v0, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->conststk500:Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;

    const/16 v2, 0x20

    aput-byte v2, v0, v5

    .line 238
    .local v0, "command":[B
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mHandler:Landroid/os/Handler;

    const/16 v3, 0x14

    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->conststk500:Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;

    const/4 v4, -0x1

    invoke-virtual {v2, v3, v6, v4}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/Message;->sendToTarget()V

    .line 240
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->bluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-virtual {v2, v0, v5}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->write([BI)V

    .line 241
    const-string v2, "STK500"

    const-string v3, "write enterProgramMode command"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 243
    const-wide/16 v2, 0x1f4

    :try_start_0
    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 246
    :goto_0
    iget-boolean v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_entered:Z

    if-eqz v2, :cond_0

    .line 247
    const/4 v1, 0x1

    .line 253
    :goto_1
    return v1

    .line 250
    :cond_0
    const/4 v1, 0x0

    goto :goto_1

    .line 244
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private leaveProgramMode()Z
    .locals 8

    .prologue
    const/16 v7, 0x51

    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 258
    const/4 v1, 0x0

    .line 260
    .local v1, "success":Z
    const/4 v4, 0x2

    new-array v0, v4, [B

    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->conststk500:Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;

    aput-byte v7, v0, v3

    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->conststk500:Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;

    const/16 v4, 0x20

    aput-byte v4, v0, v2

    .line 264
    .local v0, "command":[B
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mHandler:Landroid/os/Handler;

    const/16 v5, 0x14

    iget-object v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->conststk500:Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;

    const/4 v6, -0x1

    invoke-virtual {v4, v5, v7, v6}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v4

    invoke-virtual {v4}, Landroid/os/Message;->sendToTarget()V

    .line 265
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->bluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-virtual {v4, v0, v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->write([BI)V

    .line 266
    const-string v4, "STK500"

    const-string v5, "write LeaveProgramMode command"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 269
    const-wide/16 v4, 0x12c

    :try_start_0
    invoke-static {v4, v5}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 272
    :goto_0
    iget-boolean v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_left:Z

    if-eqz v4, :cond_0

    .line 275
    :goto_1
    return v2

    :cond_0
    move v2, v3

    goto :goto_1

    .line 270
    :catch_0
    move-exception v4

    goto :goto_0
.end method

.method private loadAddress(I)Z
    .locals 10
    .param p1, "address"    # I

    .prologue
    const/16 v9, 0x55

    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 406
    div-int/lit8 v6, p1, 0x2

    invoke-direct {p0, v6}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->packTwoBytes(I)[B

    move-result-object v3

    .line 408
    .local v3, "tempAddr":[B
    const/4 v6, 0x4

    new-array v2, v6, [B

    .line 410
    .local v2, "loadAddr":[B
    aput-byte v9, v2, v5

    .line 411
    aget-byte v6, v3, v4

    aput-byte v6, v2, v4

    .line 412
    const/4 v6, 0x2

    aget-byte v7, v3, v5

    aput-byte v7, v2, v6

    .line 413
    const/4 v6, 0x3

    const/16 v7, 0x20

    aput-byte v7, v2, v6

    .line 416
    iget-object v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mHandler:Landroid/os/Handler;

    const/16 v7, 0x14

    iget-object v8, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->conststk500:Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;

    const/4 v8, -0x1

    invoke-virtual {v6, v7, v9, v8}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v6

    invoke-virtual {v6}, Landroid/os/Message;->sendToTarget()V

    .line 417
    iget-object v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->bluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-virtual {v6, v2, v4}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->write([BI)V

    .line 424
    const/4 v0, 0x0

    .line 425
    .local v0, "count":I
    :goto_0
    iget-boolean v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_each_success:Z

    if-nez v6, :cond_0

    .line 427
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "count":I
    .local v1, "count":I
    const/16 v6, 0x3e8

    if-le v0, v6, :cond_1

    move v0, v1

    .line 435
    .end local v1    # "count":I
    .restart local v0    # "count":I
    :cond_0
    iget-boolean v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_each_success:Z

    if-eqz v6, :cond_2

    .line 439
    :goto_1
    return v4

    .line 430
    .end local v0    # "count":I
    .restart local v1    # "count":I
    :cond_1
    const-wide/16 v6, 0x1

    :try_start_0
    invoke-static {v6, v7}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move v0, v1

    .line 432
    .end local v1    # "count":I
    .restart local v0    # "count":I
    goto :goto_0

    .end local v0    # "count":I
    .restart local v1    # "count":I
    :catch_0
    move-exception v6

    move v0, v1

    .end local v1    # "count":I
    .restart local v0    # "count":I
    goto :goto_0

    :cond_2
    move v4, v5

    .line 439
    goto :goto_1
.end method

.method private packTwoBytes(I)[B
    .locals 3
    .param p1, "integer"    # I

    .prologue
    .line 446
    const/4 v1, 0x2

    new-array v0, v1, [B

    .line 448
    .local v0, "bytes":[B
    const/4 v1, 0x1

    and-int/lit16 v2, p1, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 450
    const/4 v1, 0x0

    shr-int/lit8 v2, p1, 0x8

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 451
    return-object v0
.end method

.method private programPage(Z[B)Z
    .locals 11
    .param p1, "writeFlash"    # Z
    .param p2, "data"    # [B

    .prologue
    const/16 v10, 0x64

    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 455
    array-length v7, p2

    add-int/lit8 v7, v7, 0x5

    new-array v4, v7, [B

    .line 458
    .local v4, "programPage":[B
    aput-byte v10, v4, v6

    .line 460
    array-length v7, p2

    shr-int/lit8 v7, v7, 0x8

    and-int/lit16 v7, v7, 0xff

    int-to-byte v7, v7

    aput-byte v7, v4, v5

    .line 461
    const/4 v7, 0x2

    array-length v8, p2

    and-int/lit16 v8, v8, 0xff

    int-to-byte v8, v8

    aput-byte v8, v4, v7

    .line 464
    if-eqz p1, :cond_0

    .line 465
    const/16 v3, 0x46

    .line 474
    .local v3, "memtype":B
    :goto_0
    const/4 v7, 0x3

    aput-byte v3, v4, v7

    .line 477
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v7, p2

    if-ge v2, v7, :cond_1

    .line 478
    add-int/lit8 v7, v2, 0x4

    aget-byte v8, p2, v2

    aput-byte v8, v4, v7

    .line 477
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 472
    .end local v2    # "i":I
    .end local v3    # "memtype":B
    :cond_0
    const/16 v3, 0x45

    .restart local v3    # "memtype":B
    goto :goto_0

    .line 481
    .restart local v2    # "i":I
    :cond_1
    array-length v7, p2

    add-int/lit8 v7, v7, 0x4

    const/16 v8, 0x20

    aput-byte v8, v4, v7

    .line 484
    iget-object v7, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mHandler:Landroid/os/Handler;

    const/16 v8, 0x14

    iget-object v9, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->conststk500:Lcom/drms/drms_drone/Protocol/STK500v1/ConstantsStk500v1;

    const/4 v9, -0x1

    invoke-virtual {v7, v8, v10, v9}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v7

    invoke-virtual {v7}, Landroid/os/Message;->sendToTarget()V

    .line 485
    iget-object v7, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->bluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-virtual {v7, v4, v5}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->write([BI)V

    .line 487
    const/4 v0, 0x0

    .line 488
    .local v0, "count":I
    :goto_2
    iget-boolean v7, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_each_success:Z

    if-nez v7, :cond_2

    .line 490
    const-wide/16 v8, 0x1

    :try_start_0
    invoke-static {v8, v9}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 491
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "count":I
    .local v1, "count":I
    const/16 v7, 0x3e8

    if-le v0, v7, :cond_3

    move v0, v1

    .line 496
    .end local v1    # "count":I
    .restart local v0    # "count":I
    :cond_2
    iget-boolean v7, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_success:Z

    if-eqz v7, :cond_4

    .line 500
    :goto_3
    return v5

    .end local v0    # "count":I
    .restart local v1    # "count":I
    :cond_3
    move v0, v1

    .line 493
    .end local v1    # "count":I
    .restart local v0    # "count":I
    goto :goto_2

    :cond_4
    move v5, v6

    .line 500
    goto :goto_3

    .line 493
    :catch_0
    move-exception v7

    goto :goto_2
.end method

.method private writeDataOnEEPROM()Z
    .locals 15

    .prologue
    const/16 v12, 0x100

    const/4 v14, 0x0

    .line 515
    const/4 v9, 0x0

    .line 516
    .local v9, "success":Z
    const/4 v3, 0x0

    .line 517
    .local v3, "data_set_index":I
    iget-object v11, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->command_set:[B

    array-length v11, v11

    div-int/lit16 v11, v11, 0x100

    add-int/lit8 v4, v11, 0x1

    .line 519
    .local v4, "data_set_number":I
    const/4 v6, 0x0

    .line 521
    .local v6, "index":I
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 523
    .local v1, "command":Ljava/util/ArrayList;, "Ljava/util/ArrayList<[B>;"
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    if-ge v5, v4, :cond_3

    .line 524
    add-int/lit8 v11, v4, -0x1

    if-ne v5, v11, :cond_1

    .line 525
    iget-object v11, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->command_set:[B

    array-length v11, v11

    rem-int/lit16 v11, v11, 0x100

    new-array v10, v11, [B

    .line 526
    .local v10, "temp_array":[B
    const/4 v8, 0x0

    .local v8, "j":I
    :goto_1
    iget-object v11, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->command_set:[B

    array-length v11, v11

    rem-int/lit16 v11, v11, 0x100

    if-ge v8, v11, :cond_0

    .line 527
    iget-object v11, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->command_set:[B

    add-int/lit8 v7, v6, 0x1

    .end local v6    # "index":I
    .local v7, "index":I
    aget-byte v11, v11, v6

    aput-byte v11, v10, v8

    .line 526
    add-int/lit8 v8, v8, 0x1

    move v6, v7

    .end local v7    # "index":I
    .restart local v6    # "index":I
    goto :goto_1

    .line 529
    :cond_0
    invoke-virtual {v1, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 523
    :goto_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 532
    .end local v8    # "j":I
    .end local v10    # "temp_array":[B
    :cond_1
    new-array v10, v12, [B

    .line 533
    .restart local v10    # "temp_array":[B
    const/4 v8, 0x0

    .restart local v8    # "j":I
    move v7, v6

    .end local v6    # "index":I
    .restart local v7    # "index":I
    :goto_3
    if-ge v8, v12, :cond_2

    .line 534
    iget-object v11, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->command_set:[B

    add-int/lit8 v6, v7, 0x1

    .end local v7    # "index":I
    .restart local v6    # "index":I
    aget-byte v11, v11, v7

    aput-byte v11, v10, v8

    .line 533
    add-int/lit8 v8, v8, 0x1

    move v7, v6

    .end local v6    # "index":I
    .restart local v7    # "index":I
    goto :goto_3

    .line 537
    :cond_2
    invoke-virtual {v1, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move v6, v7

    .end local v7    # "index":I
    .restart local v6    # "index":I
    goto :goto_2

    .line 541
    .end local v8    # "j":I
    .end local v10    # "temp_array":[B
    :cond_3
    const/4 v0, 0x0

    .line 542
    .local v0, "address_allocation":I
    const/4 v2, 0x0

    .line 544
    .local v2, "cycle_index":I
    :goto_4
    if-ge v2, v4, :cond_7

    iget-boolean v11, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->running:Z

    if-eqz v11, :cond_7

    .line 545
    iput-boolean v14, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_each_success:Z

    .line 546
    iput-boolean v14, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_each_success:Z

    .line 547
    const-string v11, "STK500"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "cycle index : "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, ", data_Set_number "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 548
    const/4 v5, 0x0

    :goto_5
    const/4 v11, 0x5

    if-ge v5, v11, :cond_4

    .line 549
    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress(I)Z

    move-result v11

    if-eqz v11, :cond_6

    .line 550
    const-string v11, "STK500"

    const-string v12, "Upload files"

    invoke-static {v11, v12}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 555
    :cond_4
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, [B

    invoke-direct {p0, v14, v11}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage(Z[B)Z

    move-result v11

    if-eqz v11, :cond_5

    .line 556
    const-string v11, "STK500"

    const-string v12, "Success Write data on EEPROM"

    invoke-static {v11, v12}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 557
    add-int/lit16 v0, v0, 0x100

    .line 558
    const/4 v9, 0x1

    .line 560
    :cond_5
    add-int/lit8 v2, v2, 0x1

    .line 562
    const-string v11, "STK500"

    const-string v12, "Finished Write EEPROM data"

    invoke-static {v11, v12}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_4

    .line 548
    :cond_6
    add-int/lit8 v5, v5, 0x1

    goto :goto_5

    .line 566
    :cond_7
    return v9
.end method

.method private writeHexFile()Z
    .locals 9

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 281
    const/4 v1, 0x0

    .line 282
    .local v1, "success":Z
    iput v3, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexPosition:I

    .line 284
    :goto_0
    iget v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexPosition:I

    iget-object v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexParser:Lcom/drms/drms_drone/Protocol/STK500v1/Hex;

    invoke-virtual {v6}, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->getDataSize()I

    move-result v6

    if-ge v5, v6, :cond_5

    iget-boolean v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->running:Z

    if-eqz v5, :cond_5

    .line 286
    iput-boolean v3, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_each_success:Z

    .line 287
    iput-boolean v3, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_each_success:Z

    .line 289
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mHandler:Landroid/os/Handler;

    const/16 v6, 0x17

    iget v7, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexPosition:I

    iget-object v8, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexParser:Lcom/drms/drms_drone/Protocol/STK500v1/Hex;

    invoke-virtual {v8}, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->getDataSize()I

    move-result v8

    invoke-virtual {v5, v6, v7, v8}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v5

    invoke-virtual {v5}, Landroid/os/Message;->sendToTarget()V

    .line 290
    const-string v5, "STK500"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "hexPosition : "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget v7, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexPosition:I

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 291
    iget v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->uploadFileTries:I

    const/16 v6, 0xa

    if-le v5, v6, :cond_0

    .line 334
    :goto_1
    return v3

    .line 293
    :cond_0
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexParser:Lcom/drms/drms_drone/Protocol/STK500v1/Hex;

    iget v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexPosition:I

    iget v7, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->bytesToLoad:I

    invoke-virtual {v5, v6, v7}, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->getHexLine(II)[B

    move-result-object v2

    .line 294
    .local v2, "tempArray":[B
    const-string v5, "STK500"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "tempArray size : "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    array-length v7, v2

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 296
    array-length v5, v2

    if-nez v5, :cond_1

    move v3, v4

    .line 297
    goto :goto_1

    .line 299
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_2
    const/4 v5, 0x5

    if-ge v0, v5, :cond_2

    .line 300
    iget v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexPosition:I

    invoke-direct {p0, v5}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress(I)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 301
    const-string v5, "STK500"

    const-string v6, "Upload files"

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 309
    :cond_2
    invoke-direct {p0, v4, v2}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage(Z[B)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 310
    const-string v5, "STK500"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "temp_array size : "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    array-length v7, v2

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 311
    iget v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexPosition:I

    array-length v6, v2

    add-int/2addr v5, v6

    iput v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexPosition:I

    .line 312
    const/4 v1, 0x1

    .line 319
    const-string v5, "STK500"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Finished the writeHexFile programPage_success : "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-boolean v7, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_success:Z

    invoke-static {v7}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 305
    :cond_3
    iget v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->uploadFileTries:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->uploadFileTries:I

    .line 299
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 315
    :cond_4
    const/4 v1, 0x0

    .end local v0    # "i":I
    .end local v2    # "tempArray":[B
    :cond_5
    move v3, v1

    .line 334
    goto/16 :goto_1
.end method


# virtual methods
.method public getDataSize()I
    .locals 1

    .prologue
    .line 507
    iget v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->complete_size:I

    return v0
.end method

.method public getHexPosition()I
    .locals 1

    .prologue
    .line 511
    iget v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexPosition:I

    return v0
.end method

.method public getStk500_handler()Landroid/os/Handler;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->stk500_handler:Landroid/os/Handler;

    return-object v0
.end method

.method initializeEEPROM()Z
    .locals 20

    .prologue
    .line 340
    const/4 v15, 0x0

    .line 342
    .local v15, "success":Z
    const/16 v17, 0x400

    move/from16 v0, v17

    new-array v12, v0, [I

    .line 343
    .local v12, "init_EEPROM":[I
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_0
    array-length v0, v12

    move/from16 v17, v0

    move/from16 v0, v17

    if-ge v9, v0, :cond_0

    .line 344
    const/16 v17, 0xff

    aput v17, v12, v9

    .line 343
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 346
    :cond_0
    array-length v0, v12

    move/from16 v17, v0

    move/from16 v0, v17

    new-array v13, v0, [B

    .line 347
    .local v13, "init_EEPROM_BYTE":[B
    const/4 v3, 0x0

    .line 348
    .local v3, "EEPROM_index":I
    const/4 v9, 0x0

    :goto_1
    array-length v0, v13

    move/from16 v17, v0

    move/from16 v0, v17

    if-ge v9, v0, :cond_1

    .line 349
    aget v17, v12, v9

    move/from16 v0, v17

    and-int/lit16 v0, v0, 0xff

    move/from16 v17, v0

    move/from16 v0, v17

    int-to-char v0, v0

    move/from16 v17, v0

    move/from16 v0, v17

    int-to-byte v0, v0

    move/from16 v17, v0

    aput-byte v17, v13, v9

    .line 348
    add-int/lit8 v9, v9, 0x1

    goto :goto_1

    .line 352
    :cond_1
    const/4 v7, 0x0

    .line 354
    .local v7, "data_set_index":I
    array-length v0, v13

    move/from16 v17, v0

    move/from16 v0, v17

    div-int/lit16 v0, v0, 0x100

    move/from16 v17, v0

    add-int/lit8 v8, v17, 0x1

    .line 356
    .local v8, "data_set_number":I
    const/4 v10, 0x0

    .line 358
    .local v10, "index":I
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 360
    .local v5, "command":Ljava/util/ArrayList;, "Ljava/util/ArrayList<[B>;"
    const/4 v9, 0x0

    :goto_2
    if-ge v9, v8, :cond_5

    .line 361
    add-int/lit8 v17, v8, -0x1

    move/from16 v0, v17

    if-ne v9, v0, :cond_3

    .line 362
    array-length v0, v13

    move/from16 v17, v0

    move/from16 v0, v17

    rem-int/lit16 v0, v0, 0x100

    move/from16 v17, v0

    move/from16 v0, v17

    new-array v0, v0, [B

    move-object/from16 v16, v0

    .line 363
    .local v16, "temp_array":[B
    const/4 v14, 0x0

    .local v14, "j":I
    :goto_3
    array-length v0, v13

    move/from16 v17, v0

    move/from16 v0, v17

    rem-int/lit16 v0, v0, 0x100

    move/from16 v17, v0

    move/from16 v0, v17

    if-ge v14, v0, :cond_2

    .line 364
    add-int/lit8 v11, v10, 0x1

    .end local v10    # "index":I
    .local v11, "index":I
    aget-byte v17, v13, v10

    aput-byte v17, v16, v14

    .line 363
    add-int/lit8 v14, v14, 0x1

    move v10, v11

    .end local v11    # "index":I
    .restart local v10    # "index":I
    goto :goto_3

    .line 366
    :cond_2
    move-object/from16 v0, v16

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 360
    :goto_4
    add-int/lit8 v9, v9, 0x1

    goto :goto_2

    .line 369
    .end local v14    # "j":I
    .end local v16    # "temp_array":[B
    :cond_3
    const/16 v17, 0x100

    move/from16 v0, v17

    new-array v0, v0, [B

    move-object/from16 v16, v0

    .line 370
    .restart local v16    # "temp_array":[B
    const/4 v14, 0x0

    .restart local v14    # "j":I
    move v11, v10

    .end local v10    # "index":I
    .restart local v11    # "index":I
    :goto_5
    const/16 v17, 0x100

    move/from16 v0, v17

    if-ge v14, v0, :cond_4

    .line 371
    add-int/lit8 v10, v11, 0x1

    .end local v11    # "index":I
    .restart local v10    # "index":I
    aget-byte v17, v13, v11

    aput-byte v17, v16, v14

    .line 370
    add-int/lit8 v14, v14, 0x1

    move v11, v10

    .end local v10    # "index":I
    .restart local v11    # "index":I
    goto :goto_5

    .line 374
    :cond_4
    move-object/from16 v0, v16

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move v10, v11

    .end local v11    # "index":I
    .restart local v10    # "index":I
    goto :goto_4

    .line 378
    .end local v14    # "j":I
    .end local v16    # "temp_array":[B
    :cond_5
    const/4 v4, 0x0

    .line 379
    .local v4, "address_allocation":I
    const/4 v6, 0x0

    .line 381
    .local v6, "cycle_index":I
    :goto_6
    if-ge v6, v8, :cond_9

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->running:Z

    move/from16 v17, v0

    if-eqz v17, :cond_9

    .line 382
    const/16 v17, 0x0

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_each_success:Z

    .line 383
    const/16 v17, 0x0

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_each_success:Z

    .line 384
    const-string v17, "STK500"

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "init -> cycle_index : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "/ data_num : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 385
    const/4 v9, 0x0

    :goto_7
    const/16 v17, 0x5

    move/from16 v0, v17

    if-ge v9, v0, :cond_6

    .line 386
    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress(I)Z

    move-result v17

    if-eqz v17, :cond_8

    .line 387
    const-string v17, "STK500"

    const-string v18, "Upload files"

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 392
    :cond_6
    const/16 v18, 0x0

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, [B

    move-object/from16 v0, p0

    move/from16 v1, v18

    move-object/from16 v2, v17

    invoke-direct {v0, v1, v2}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage(Z[B)Z

    move-result v17

    if-eqz v17, :cond_7

    .line 393
    add-int/lit16 v4, v4, 0x100

    .line 394
    const/4 v15, 0x1

    .line 397
    :cond_7
    add-int/lit8 v6, v6, 0x1

    .line 399
    const-string v17, "STK500"

    const-string v18, "Finished Write EEPROM data"

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_6

    .line 385
    :cond_8
    add-int/lit8 v9, v9, 0x1

    goto :goto_7

    .line 402
    :cond_9
    return v15
.end method

.method public programHexFile([BIZ)Z
    .locals 6
    .param p1, "binaryFile"    # [B
    .param p2, "numberOfBytes"    # I
    .param p3, "checkWrittenData"    # Z

    .prologue
    .line 158
    new-instance v2, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;

    invoke-direct {v2, p1}, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;-><init>([B)V

    iput-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexParser:Lcom/drms/drms_drone/Protocol/STK500v1/Hex;

    .line 160
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->hexParser:Lcom/drms/drms_drone/Protocol/STK500v1/Hex;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->getDataSize()I

    move-result v2

    iput v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->complete_size:I

    .line 161
    iput p2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->bytesToLoad:I

    .line 163
    const/4 v1, 0x0

    .line 164
    .local v1, "success":Z
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->startTime:J

    .line 165
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->endTime:J

    .line 166
    const/4 v0, 0x0

    .line 171
    .local v0, "entered":Z
    :cond_0
    iget-wide v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->endTime:J

    iget-wide v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->startTime:J

    sub-long/2addr v2, v4

    const-wide/16 v4, 0x5dc

    cmp-long v2, v2, v4

    if-gtz v2, :cond_1

    .line 172
    invoke-direct {p0}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->enterProgramMode()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 183
    :cond_1
    iget-boolean v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_entered:Z

    if-eqz v2, :cond_6

    .line 184
    const-string v2, "STK500"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Entering the Programm ModeprogramMode_entered : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-boolean v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_entered:Z

    invoke-static {v4}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 185
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mHandler:Landroid/os/Handler;

    const/16 v3, 0x17

    const/4 v4, 0x3

    const/4 v5, -0x1

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/Message;->sendToTarget()V

    .line 186
    invoke-virtual {p0}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->initializeEEPROM()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 187
    invoke-direct {p0}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->writeHexFile()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 188
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mHandler:Landroid/os/Handler;

    const/16 v3, 0x17

    const/4 v4, 0x4

    const/4 v5, -0x1

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/Message;->sendToTarget()V

    .line 189
    iget v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->request:I

    if-eqz v2, :cond_2

    iget v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->request:I

    const/4 v3, 0x3

    if-ne v2, v3, :cond_3

    .line 190
    :cond_2
    invoke-direct {p0}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->writeDataOnEEPROM()Z

    .line 191
    :cond_3
    const-string v2, "STK500"

    const-string v3, "Write Command data on Arduino EEPROM"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 203
    :cond_4
    iget-boolean v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_entered:Z

    if-eqz v2, :cond_9

    .line 204
    :goto_0
    invoke-direct {p0}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->leaveProgramMode()Z

    move-result v2

    if-nez v2, :cond_7

    iget v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->triesToleaveProgrammode:I

    const/4 v3, 0x5

    if-ge v2, v3, :cond_7

    .line 206
    const-wide/16 v2, 0x12c

    :try_start_0
    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 210
    :goto_1
    iget v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->triesToleaveProgrammode:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->triesToleaveProgrammode:I

    goto :goto_0

    .line 175
    :cond_5
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->endTime:J

    .line 176
    iget-wide v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->endTime:J

    iget-wide v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->startTime:J

    sub-long/2addr v2, v4

    const-wide/16 v4, 0x5dc

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    .line 177
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mHandler:Landroid/os/Handler;

    const/16 v3, 0x17

    const/4 v4, 0x2

    const/4 v5, -0x1

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/Message;->sendToTarget()V

    .line 178
    const/4 v2, 0x0

    .line 228
    :goto_2
    return v2

    .line 195
    :cond_6
    iget-boolean v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_entered:Z

    if-nez v2, :cond_4

    iget-wide v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->endTime:J

    iget-wide v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->startTime:J

    sub-long/2addr v2, v4

    const-wide/16 v4, 0x5dc

    cmp-long v2, v2, v4

    if-gtz v2, :cond_4

    .line 196
    const-string v2, "STK500"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Entering the Programm ModeprogramMode_entered : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-boolean v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_entered:Z

    invoke-static {v4}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 197
    const/4 v2, 0x0

    goto :goto_2

    .line 213
    :cond_7
    const-string v2, "STK500"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "leaving the Programm ModeprogramMode_left : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-boolean v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_left:Z

    invoke-static {v4}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 215
    iget-boolean v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_entered:Z

    if-eqz v2, :cond_8

    iget-boolean v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_success:Z

    if-eqz v2, :cond_8

    iget-boolean v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_success:Z

    if-eqz v2, :cond_8

    iget-boolean v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_left:Z

    if-eqz v2, :cond_8

    .line 216
    const/4 v1, 0x1

    :goto_3
    move v2, v1

    .line 228
    goto :goto_2

    .line 218
    :cond_8
    const/4 v1, 0x0

    .line 220
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->mHandler:Landroid/os/Handler;

    const/16 v3, 0x17

    const/4 v4, -0x1

    const/4 v5, -0x1

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/Message;->sendToTarget()V

    goto :goto_3

    .line 225
    :cond_9
    const/4 v1, 0x0

    goto :goto_3

    .line 207
    :catch_0
    move-exception v2

    goto/16 :goto_1
.end method
