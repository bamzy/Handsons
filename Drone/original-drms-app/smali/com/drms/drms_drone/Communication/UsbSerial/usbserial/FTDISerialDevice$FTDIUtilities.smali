.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;
.super Ljava/lang/Object;
.source "FTDISerialDevice.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "FTDIUtilities"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .prologue
    .line 484
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private copyData([B[B)V
    .locals 3
    .param p1, "src"    # [B
    .param p2, "dst"    # [B

    .prologue
    .line 583
    const/4 v0, 0x0

    .line 584
    .local v0, "i":I
    const/4 v1, 0x0

    .line 585
    .local v1, "j":I
    :goto_0
    array-length v2, p1

    add-int/lit8 v2, v2, -0x1

    if-gt v0, v2, :cond_2

    .line 587
    if-eqz v0, :cond_1

    const/4 v2, 0x1

    if-eq v0, v2, :cond_1

    .line 589
    rem-int/lit8 v2, v0, 0x40

    if-nez v2, :cond_0

    const/16 v2, 0x40

    if-lt v0, v2, :cond_0

    .line 591
    add-int/lit8 v0, v0, 0x2

    goto :goto_0

    .line 594
    :cond_0
    aget-byte v2, p1, v0

    aput-byte v2, p2, v1

    .line 595
    add-int/lit8 v0, v0, 0x1

    .line 596
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 600
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 603
    :cond_2
    return-void
.end method


# virtual methods
.method public adaptArray([B)[B
    .locals 6
    .param p1, "ftdiData"    # [B

    .prologue
    .line 489
    array-length v1, p1

    .line 490
    .local v1, "length":I
    const/16 v5, 0x40

    if-le v1, v5, :cond_1

    .line 492
    const/4 v2, 0x1

    .line 493
    .local v2, "n":I
    const/16 v3, 0x40

    .line 495
    .local v3, "p":I
    :goto_0
    if-ge v3, v1, :cond_0

    .line 497
    add-int/lit8 v2, v2, 0x1

    .line 498
    mul-int/lit8 v3, v2, 0x40

    goto :goto_0

    .line 500
    :cond_0
    mul-int/lit8 v5, v2, 0x2

    sub-int v4, v1, v5

    .line 501
    .local v4, "realLength":I
    new-array v0, v4, [B

    .line 502
    .local v0, "data":[B
    invoke-direct {p0, p1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->copyData([B[B)V

    .line 506
    .end local v0    # "data":[B
    .end local v2    # "n":I
    .end local v3    # "p":I
    .end local v4    # "realLength":I
    :goto_1
    return-object v0

    :cond_1
    const/4 v5, 0x2

    invoke-static {p1, v5, v1}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v0

    goto :goto_1
.end method

.method public checkModemStatus([B)V
    .locals 7
    .param p1, "data"    # [B

    .prologue
    const/16 v6, 0x10

    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 512
    array-length v4, p1

    if-nez v4, :cond_1

    .line 578
    :cond_0
    :goto_0
    return-void

    .line 515
    :cond_1
    aget-byte v4, p1, v3

    and-int/lit8 v4, v4, 0x10

    if-ne v4, v6, :cond_4

    move v0, v2

    .line 516
    .local v0, "cts":Z
    :goto_1
    aget-byte v4, p1, v3

    and-int/lit8 v4, v4, 0x20

    const/16 v5, 0x20

    if-ne v4, v5, :cond_5

    move v1, v2

    .line 518
    .local v1, "dsr":Z
    :goto_2
    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 520
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v2, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$102(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;Z)Z

    .line 521
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v2, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$202(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;Z)Z

    .line 523
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 524
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v2

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v4

    invoke-interface {v2, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;->onCTSChanged(Z)V

    .line 526
    :cond_2
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v2

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 527
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v2

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v4

    invoke-interface {v2, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;->onDSRChanged(Z)V

    .line 529
    :cond_3
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$002(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;Z)Z

    goto :goto_0

    .end local v0    # "cts":Z
    .end local v1    # "dsr":Z
    :cond_4
    move v0, v3

    .line 515
    goto :goto_1

    .restart local v0    # "cts":Z
    :cond_5
    move v1, v3

    .line 516
    goto :goto_2

    .line 533
    .restart local v1    # "dsr":Z
    :cond_6
    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v4

    if-eqz v4, :cond_7

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .line 534
    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v4

    if-eq v0, v4, :cond_7

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v4

    if-eqz v4, :cond_7

    .line 536
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v4

    if-nez v4, :cond_d

    move v4, v2

    :goto_3
    invoke-static {v5, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$102(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;Z)Z

    .line 537
    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$100(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v5

    invoke-interface {v4, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;->onCTSChanged(Z)V

    .line 540
    :cond_7
    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$500(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v4

    if-eqz v4, :cond_9

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    .line 541
    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v4

    if-eq v1, v4, :cond_9

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v4

    if-eqz v4, :cond_9

    .line 543
    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v5

    if-nez v5, :cond_8

    move v3, v2

    :cond_8
    invoke-static {v4, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$202(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;Z)Z

    .line 544
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$600(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v3

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Z

    move-result v4

    invoke-interface {v3, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;->onDSRChanged(Z)V

    .line 547
    :cond_9
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$700(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    move-result-object v3

    if-eqz v3, :cond_a

    .line 549
    aget-byte v3, p1, v2

    and-int/lit8 v3, v3, 0x4

    const/4 v4, 0x4

    if-ne v3, v4, :cond_a

    .line 551
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$700(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;

    move-result-object v3

    invoke-interface {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbParityCallback;->onParityError()V

    .line 555
    :cond_a
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$800(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    move-result-object v3

    if-eqz v3, :cond_b

    .line 557
    aget-byte v3, p1, v2

    and-int/lit8 v3, v3, 0x8

    const/16 v4, 0x8

    if-ne v3, v4, :cond_b

    .line 559
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$800(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;

    move-result-object v3

    invoke-interface {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbFrameCallback;->onFramingError()V

    .line 563
    :cond_b
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$900(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    move-result-object v3

    if-eqz v3, :cond_c

    .line 565
    aget-byte v3, p1, v2

    and-int/lit8 v3, v3, 0x2

    const/4 v4, 0x2

    if-ne v3, v4, :cond_c

    .line 567
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$900(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;

    move-result-object v3

    invoke-interface {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbOverrunCallback;->onOverrunError()V

    .line 571
    :cond_c
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$1000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 573
    aget-byte v2, p1, v2

    and-int/lit8 v2, v2, 0x10

    if-ne v2, v6, :cond_0

    .line 575
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice$FTDIUtilities;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;->access$1000(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/FTDISerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;

    move-result-object v2

    invoke-interface {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbBreakCallback;->onBreakInterrupt()V

    goto/16 :goto_0

    :cond_d
    move v4, v3

    .line 536
    goto/16 :goto_3
.end method
