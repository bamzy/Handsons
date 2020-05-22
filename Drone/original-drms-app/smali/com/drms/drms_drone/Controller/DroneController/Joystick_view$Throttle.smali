.class public Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;
.super Ljava/lang/Object;
.source "Joystick_view.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Throttle"
.end annotation


# instance fields
.field private RawRc:[I

.field private left:[I

.field private right:[I

.field final synthetic this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

.field private throttleImage:Landroid/graphics/Bitmap;

.field private throttle_height:I

.field private throttle_position:[[I

.field private throttle_width:I


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;Landroid/graphics/Bitmap;[I[I)V
    .locals 7
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
    .param p2, "throttle"    # Landroid/graphics/Bitmap;
    .param p3, "left"    # [I
    .param p4, "right"    # [I

    .prologue
    const/4 v6, 0x0

    const/16 v5, 0x5dc

    const/4 v4, 0x2

    .line 492
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 489
    filled-new-array {v4, v4}, [I

    move-result-object v2

    sget-object v3, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {v3, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [[I

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_position:[[I

    .line 490
    const/4 v2, 0x4

    new-array v2, v2, [I

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    .line 493
    iput-object p2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    .line 494
    iput-object p3, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->left:[I

    .line 495
    iput-object p4, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->right:[I

    .line 496
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v4, :cond_1

    .line 497
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_1
    if-ge v1, v4, :cond_0

    .line 498
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_position:[[I

    aget-object v2, v2, v0

    aput v6, v2, v1

    .line 497
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 496
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 502
    .end local v1    # "j":I
    :cond_1
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    aput v5, v2, v6

    .line 503
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    const/4 v3, 0x1

    aput v5, v2, v3

    .line 504
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    aput v5, v2, v4

    .line 505
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    const/4 v3, 0x3

    const/16 v4, 0x3e8

    aput v4, v2, v3

    .line 506
    return-void
.end method


# virtual methods
.method public getLeft()[I
    .locals 1

    .prologue
    .line 540
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->left:[I

    return-object v0
.end method

.method public getRight()[I
    .locals 1

    .prologue
    .line 544
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->right:[I

    return-object v0
.end method

.method public getThrottleImage()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 536
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttleImage:Landroid/graphics/Bitmap;

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

    .line 509
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->left:[I

    .line 511
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_position:[[I

    aget-object v1, v1, v4

    aget v1, v1, v3

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_height:I

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    sub-int/2addr v1, v2

    aget v2, p1, v3

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    sub-int/2addr v1, v2

    mul-int/lit16 v1, v1, 0x3e8

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_height:I

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    sub-int/2addr v2, v3

    div-int/2addr v1, v2

    add-int/lit16 v1, v1, 0x3e8

    aput v1, v0, v6

    .line 513
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    aget v1, p1, v4

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_position:[[I

    aget-object v2, v2, v4

    aget v2, v2, v4

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_width:I

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_width:I

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getWidth()I

    move-result v4

    div-int/2addr v3, v4

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    sub-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v2

    mul-int/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_width:I

    div-int/lit8 v2, v2, 0x2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    div-int/2addr v1, v2

    add-int/lit16 v1, v1, 0x5dc

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    aget v2, v2, v5

    add-int/2addr v1, v2

    aput v1, v0, v5

    .line 515
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    aget v1, v1, v5

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    aget v2, v2, v6

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 518
    return-void
.end method

.method public setRight([I)V
    .locals 6
    .param p1, "right"    # [I

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 521
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->right:[I

    .line 527
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    aget v1, p1, v5

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_position:[[I

    aget-object v2, v2, v4

    aget v2, v2, v5

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_width:I

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    sub-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v2

    mul-int/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_width:I

    div-int/lit8 v2, v2, 0x2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    div-int/2addr v1, v2

    add-int/lit16 v1, v1, 0x5dc

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    aget v2, v2, v5

    add-int/2addr v1, v2

    aput v1, v0, v5

    .line 528
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_position:[[I

    aget-object v1, v1, v4

    aget v1, v1, v4

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_height:I

    div-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    aget v2, p1, v4

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    sub-int/2addr v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v2

    mul-int/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_height:I

    div-int/lit8 v2, v2, 0x2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttleImage:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    div-int/2addr v1, v2

    add-int/lit16 v1, v1, 0x5dc

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    aget v2, v2, v4

    add-int/2addr v1, v2

    aput v1, v0, v4

    .line 530
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    aget v1, v1, v5

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->RawRc:[I

    aget v2, v2, v4

    invoke-virtual {v0, v1, v2}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 533
    return-void
.end method

.method public setThrottle_height(I)V
    .locals 0
    .param p1, "throttle_height"    # I

    .prologue
    .line 552
    iput p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_height:I

    .line 553
    return-void
.end method

.method public setThrottle_position([[I)V
    .locals 0
    .param p1, "position"    # [[I

    .prologue
    .line 556
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_position:[[I

    .line 557
    return-void
.end method

.method public setThrottle_width(I)V
    .locals 0
    .param p1, "throttle_width"    # I

    .prologue
    .line 548
    iput p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->throttle_width:I

    .line 549
    return-void
.end method
