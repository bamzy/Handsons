.class public Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;
.super Ljava/lang/Object;
.source "DrsControllerView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Throttle"
.end annotation


# instance fields
.field private RawRc:[I

.field private left:[I

.field private right:[I

.field final synthetic this$0:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

.field private throttleImage:Landroid/graphics/Bitmap;

.field private throttle_height:I

.field private throttle_position:[[I

.field private throttle_width:I


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;Landroid/graphics/Bitmap;[I[I)V
    .locals 7
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;
    .param p2, "throttle"    # Landroid/graphics/Bitmap;
    .param p3, "left"    # [I
    .param p4, "right"    # [I

    .prologue
    const/4 v6, 0x0

    const/16 v5, 0x5dc

    const/4 v4, 0x2

    .line 463
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 460
    filled-new-array {v4, v4}, [I

    move-result-object v2

    sget-object v3, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {v3, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [[I

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_position:[[I

    .line 461
    const/4 v2, 0x4

    new-array v2, v2, [I

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    .line 464
    iput-object p2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    .line 465
    iput-object p3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->left:[I

    .line 466
    iput-object p4, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->right:[I

    .line 467
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v4, :cond_1

    .line 468
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_1
    if-ge v1, v4, :cond_0

    .line 469
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_position:[[I

    aget-object v2, v2, v0

    aput v6, v2, v1

    .line 468
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 467
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 473
    .end local v1    # "j":I
    :cond_1
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    aput v5, v2, v6

    .line 474
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    const/4 v3, 0x1

    aput v5, v2, v3

    .line 475
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    aput v5, v2, v4

    .line 476
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    const/4 v3, 0x3

    const/16 v4, 0x3e8

    aput v4, v2, v3

    .line 477
    return-void
.end method


# virtual methods
.method public getLeft()[I
    .locals 1

    .prologue
    .line 511
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->left:[I

    return-object v0
.end method

.method public getRight()[I
    .locals 1

    .prologue
    .line 515
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->right:[I

    return-object v0
.end method

.method public getThrottleImage()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 507
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public setLeft([I)V
    .locals 7
    .param p1, "left"    # [I

    .prologue
    const/4 v6, 0x3

    const/4 v3, 0x1

    const/4 v5, 0x2

    const/4 v4, 0x0

    .line 480
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->left:[I

    .line 482
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_position:[[I

    aget-object v1, v1, v4

    aget v1, v1, v3

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_height:I

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    sub-int/2addr v1, v2

    aget v2, p1, v3

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    sub-int/2addr v1, v2

    mul-int/lit16 v1, v1, 0x3e8

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_height:I

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    sub-int/2addr v2, v3

    div-int/2addr v1, v2

    add-int/lit16 v1, v1, 0x3e8

    aput v1, v0, v6

    .line 484
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    aget v1, p1, v4

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_position:[[I

    aget-object v2, v2, v4

    aget v2, v2, v4

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_width:I

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_width:I

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->getWidth()I

    move-result v4

    div-int/2addr v3, v4

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    sub-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v2

    mul-int/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_width:I

    div-int/lit8 v2, v2, 0x2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    div-int/2addr v1, v2

    add-int/lit16 v1, v1, 0x5dc

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    aget v2, v2, v5

    add-int/2addr v1, v2

    aput v1, v0, v5

    .line 486
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    aget v1, v1, v5

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    aget v2, v2, v6

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 489
    return-void
.end method

.method public setRight([I)V
    .locals 6
    .param p1, "right"    # [I

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 492
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->right:[I

    .line 498
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    aget v1, p1, v5

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_position:[[I

    aget-object v2, v2, v4

    aget v2, v2, v5

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_width:I

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    sub-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v2

    mul-int/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_width:I

    div-int/lit8 v2, v2, 0x2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    div-int/2addr v1, v2

    add-int/lit16 v1, v1, 0x5dc

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    aget v2, v2, v5

    add-int/2addr v1, v2

    aput v1, v0, v5

    .line 499
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_position:[[I

    aget-object v1, v1, v4

    aget v1, v1, v4

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_height:I

    div-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    aget v2, p1, v4

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    sub-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v2

    mul-int/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_height:I

    div-int/lit8 v2, v2, 0x2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    div-int/2addr v1, v2

    add-int/lit16 v1, v1, 0x5dc

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    aget v2, v2, v4

    add-int/2addr v1, v2

    aput v1, v0, v4

    .line 501
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    aget v1, v1, v5

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->RawRc:[I

    aget v2, v2, v4

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 504
    return-void
.end method

.method public setThrottle_height(I)V
    .locals 0
    .param p1, "throttle_height"    # I

    .prologue
    .line 523
    iput p1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_height:I

    .line 524
    return-void
.end method

.method public setThrottle_position([[I)V
    .locals 0
    .param p1, "position"    # [[I

    .prologue
    .line 527
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_position:[[I

    .line 528
    return-void
.end method

.method public setThrottle_width(I)V
    .locals 0
    .param p1, "throttle_width"    # I

    .prologue
    .line 519
    iput p1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;->throttle_width:I

    .line 520
    return-void
.end method
