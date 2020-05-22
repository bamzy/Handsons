.class public Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;
.super Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
.source "Dual1JoystickView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;Landroid/os/Handler;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mActivity"    # Landroid/app/Activity;
    .param p3, "mHandler"    # Landroid/os/Handler;

    .prologue
    .line 27
    invoke-direct {p0, p1, p2, p3}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;-><init>(Landroid/content/Context;Landroid/app/Activity;Landroid/os/Handler;)V

    .line 29
    return-void
.end method


# virtual methods
.method protected drawBackground(FIFI)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "width"    # F
    .param p2, "unitW"    # I
    .param p3, "height"    # F
    .param p4, "unitH"    # I

    .prologue
    .line 41
    invoke-super {p0, p1, p2, p3, p4}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->drawBackground(FIFI)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method protected drawController(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 46
    invoke-super {p0, p1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->drawController(Landroid/graphics/Canvas;)V

    .line 48
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getRight()[I

    move-result-object v1

    const/4 v2, 0x0

    aget v1, v1, v2

    int-to-float v1, v1

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getRight()[I

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    int-to-float v2, v2

    const/4 v3, 0x0

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 49
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v4, 0x40c00000    # 6.0f

    .line 33
    invoke-super {p0, p1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->onDraw(Landroid/graphics/Canvas;)V

    .line 35
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030034

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 36
    .local v0, "throttle":Landroid/graphics/Bitmap;
    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    mul-float/2addr v2, v4

    float-to-int v2, v2

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 37
    .local v1, "throttle_image":Landroid/graphics/Bitmap;
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 18
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 53
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v10

    .line 54
    .local v10, "pointer_count":I
    const/4 v14, 0x2

    if-le v10, v14, :cond_0

    const/4 v10, 0x2

    .line 56
    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v14

    sparse-switch v14, :sswitch_data_0

    .line 980
    :cond_1
    :goto_0
    const/4 v14, 0x1

    return v14

    .line 58
    :sswitch_0
    const-string v14, "Joystick_view"

    const-string v15, "onTouch"

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 59
    const-string v14, "Joystick_view"

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "x: "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "\ny : "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 60
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_11

    .line 61
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_11

    .line 62
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_11

    .line 63
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_11

    .line 64
    const-string v14, "Joystick_view"

    const-string v15, "unlock left throttle"

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 66
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x7

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_2

    .line 67
    const/high16 v14, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    mul-float/2addr v14, v15

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v15}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v15

    invoke-virtual {v15}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v15

    int-to-float v15, v15

    sub-float v11, v14, v15

    .line 68
    .local v11, "position":F
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_2

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    cmpl-float v14, v14, v11

    if-ltz v14, :cond_2

    .line 69
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x4

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 73
    .end local v11    # "position":F
    :cond_2
    const/4 v14, 0x2

    new-array v2, v14, [I

    const/4 v14, 0x0

    .line 74
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v2, v14

    const/4 v14, 0x1

    .line 75
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v2, v14

    .line 77
    .local v2, "down_left":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x1

    aput-boolean v16, v14, v15

    .line 78
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 79
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_3

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_3

    .line 80
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41400000    # 12.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_10

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41b80000    # 23.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_10

    .line 81
    const/4 v14, 0x0

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v2, v14

    .line 89
    :cond_3
    :goto_1
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_4

    .line 90
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 112
    .end local v2    # "down_left":[I
    :cond_4
    :goto_2
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_5

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_5

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42400000    # 48.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_5

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42540000    # 53.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_5

    .line 113
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-eqz v14, :cond_13

    .line 114
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    .line 119
    :goto_3
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 120
    const-string v14, "Joystick_view"

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "locked : "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 124
    :cond_5
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x40000000    # 2.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_6

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41100000    # 9.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_6

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x40000000    # 2.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_6

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41400000    # 12.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_6

    .line 125
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mHandler:Landroid/os/Handler;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v14

    invoke-virtual {v14}, Landroid/os/Message;->sendToTarget()V

    .line 126
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 130
    :cond_6
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7

    .line 131
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 132
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x2

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    sub-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 133
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x4

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 136
    :cond_7
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41e00000    # 28.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_8

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_8

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_8

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_8

    .line 137
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 138
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x2

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 139
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x5

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 142
    :cond_8
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_9

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_9

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_9

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_9

    .line 143
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 144
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x1

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 145
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x3

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 148
    :cond_9
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_a

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_a

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_a

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_a

    .line 149
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 150
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x1

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    sub-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 151
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x2

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 154
    :cond_a
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_b

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42640000    # 57.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_b

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_b

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_b

    .line 155
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 156
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x0

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    sub-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 157
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x0

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 160
    :cond_b
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x429a0000    # 77.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_c

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_c

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_c

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_c

    .line 161
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 162
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x0

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 163
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 166
    :cond_c
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41600000    # 14.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_d

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41980000    # 19.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_d

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_d

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41200000    # 10.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_d

    .line 167
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 168
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x4

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_14

    .line 169
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 176
    :cond_d
    :goto_4
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41b00000    # 22.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_e

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_e

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_e

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41200000    # 10.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_e

    .line 177
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 179
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x5

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_15

    .line 180
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x2

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 191
    :cond_e
    :goto_5
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41e80000    # 29.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_f

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42080000    # 34.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_f

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_f

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41200000    # 10.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_f

    .line 192
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 193
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_16

    .line 194
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x3

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 201
    :cond_f
    :goto_6
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_18

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_18

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_18

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_18

    .line 202
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v14

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-nez v14, :cond_19

    .line 203
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 204
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setACCCalibration(Z)V

    .line 206
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x5dc

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 207
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 208
    const/4 v4, 0x1

    .local v4, "i":I
    :goto_7
    const/4 v14, 0x5

    if-ge v4, v14, :cond_17

    .line 209
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x3e8

    invoke-virtual {v14, v4, v15}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 208
    add-int/lit8 v4, v4, 0x1

    goto :goto_7

    .line 84
    .end local v4    # "i":I
    .restart local v2    # "down_left":[I
    :cond_10
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 85
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    goto/16 :goto_1

    .line 94
    .end local v2    # "down_left":[I
    :cond_11
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_12

    .line 95
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_12

    .line 96
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_12

    .line 97
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_12

    .line 98
    const-string v14, "Joystick_view"

    const-string v15, "unlock right throttle"

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 99
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 100
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x1

    aput-boolean v16, v14, v15

    .line 101
    const/4 v14, 0x2

    new-array v3, v14, [I

    const/4 v14, 0x0

    .line 102
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v3, v14

    const/4 v14, 0x1

    .line 103
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v3, v14

    .line 105
    .local v3, "down_right":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v3}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setRight([I)V

    goto/16 :goto_2

    .line 108
    .end local v3    # "down_right":[I
    :cond_12
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 109
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    goto/16 :goto_2

    .line 117
    :cond_13
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    goto/16 :goto_3

    .line 171
    :cond_14
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x4

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_d

    .line 172
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_4

    .line 182
    :cond_15
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x5

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_e

    .line 183
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x2

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_5

    .line 196
    :cond_16
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_f

    .line 197
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x3

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_6

    .line 211
    .restart local v4    # "i":I
    :cond_17
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v15, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$1;

    move-object/from16 v0, p0

    invoke-direct {v15, v0}, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$1;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;)V

    const-wide/16 v16, 0x1f4

    invoke-virtual/range {v14 .. v17}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 223
    .end local v4    # "i":I
    :cond_18
    :goto_8
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x423c0000    # 47.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_1

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_1

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_1

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_1

    .line 224
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v14

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-nez v14, :cond_1b

    .line 225
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 226
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setMAGCalibration(Z)V

    .line 228
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x5dc

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 229
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 230
    const/4 v4, 0x1

    .restart local v4    # "i":I
    :goto_9
    const/4 v14, 0x5

    if-ge v4, v14, :cond_1a

    .line 231
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x3e8

    invoke-virtual {v14, v4, v15}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 230
    add-int/lit8 v4, v4, 0x1

    goto :goto_9

    .line 219
    .end local v4    # "i":I
    :cond_19
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mContext:Landroid/content/Context;

    const-string v15, "\uad50\uc815 \uc911..."

    const/16 v16, 0x0

    invoke-static/range {v14 .. v16}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v14

    invoke-virtual {v14}, Landroid/widget/Toast;->show()V

    goto/16 :goto_8

    .line 232
    .restart local v4    # "i":I
    :cond_1a
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v15, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$2;

    move-object/from16 v0, p0

    invoke-direct {v15, v0}, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$2;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;)V

    const-wide/16 v16, 0x1f4

    invoke-virtual/range {v14 .. v17}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 241
    .end local v4    # "i":I
    :cond_1b
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mContext:Landroid/content/Context;

    const-string v15, "\uad50\uc815 \uc911..."

    const/16 v16, 0x0

    invoke-static/range {v14 .. v16}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v14

    invoke-virtual {v14}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 249
    :sswitch_1
    const/4 v14, 0x2

    new-array v5, v14, [I

    const/4 v14, 0x0

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v15}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v15

    const/16 v16, 0x0

    aget v15, v15, v16

    aput v15, v5, v14

    const/4 v14, 0x1

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v15}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v15

    const/16 v16, 0x1

    aget v15, v15, v16

    aput v15, v5, v14

    .line 250
    .local v5, "left":[I
    const/4 v14, 0x2

    new-array v12, v14, [I

    const/4 v14, 0x0

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v15}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getRight()[I

    move-result-object v15

    const/16 v16, 0x0

    aget v15, v15, v16

    aput v15, v12, v14

    const/4 v14, 0x1

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v15}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getRight()[I

    move-result-object v15

    const/16 v16, 0x1

    aget v15, v15, v16

    aput v15, v12, v14

    .line 252
    .local v12, "right":[I
    const/4 v14, 0x1

    if-ne v10, v14, :cond_3d

    .line 253
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_1d

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-nez v14, :cond_1d

    .line 254
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_27

    .line 255
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_27

    .line 257
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_26

    .line 258
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    const/high16 v16, 0x40c00000    # 6.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v17, v0

    mul-float v16, v16, v17

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_25

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    const/high16 v16, 0x40c00000    # 6.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v17, v0

    mul-float v16, v16, v17

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_25

    .line 259
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    .line 281
    :cond_1c
    :goto_a
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_2a

    .line 282
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_2a

    .line 283
    const/4 v14, 0x1

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v5, v14

    .line 294
    :cond_1d
    :goto_b
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-nez v14, :cond_1f

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_1f

    .line 296
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_2c

    .line 297
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_2c

    .line 298
    const/4 v14, 0x0

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v12, v14

    .line 312
    :cond_1e
    :goto_c
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_2f

    .line 313
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_2f

    .line 314
    const/4 v14, 0x1

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v12, v14

    .line 323
    :cond_1f
    :goto_d
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_21

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-nez v14, :cond_21

    .line 325
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_33

    const/4 v14, 0x0

    .line 326
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_33

    .line 327
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_32

    .line 328
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    const/high16 v16, 0x40c00000    # 6.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v17, v0

    mul-float v16, v16, v17

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_31

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    const/high16 v16, 0x40c00000    # 6.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v17, v0

    mul-float v16, v16, v17

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_31

    .line 329
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    .line 346
    :cond_20
    :goto_e
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_36

    const/4 v14, 0x0

    .line 347
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_36

    .line 348
    const/4 v14, 0x1

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getY(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v5, v14

    .line 358
    :cond_21
    :goto_f
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_23

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-nez v14, :cond_23

    .line 359
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_38

    const/4 v14, 0x0

    .line 360
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_38

    .line 361
    const/4 v14, 0x0

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getX(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v12, v14

    .line 372
    :cond_22
    :goto_10
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_3b

    const/4 v14, 0x0

    .line 373
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_3b

    .line 374
    const/4 v14, 0x1

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getY(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v12, v14

    .line 383
    :cond_23
    :goto_11
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v5}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 384
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v12}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setRight([I)V

    .line 515
    :cond_24
    :goto_12
    invoke-virtual/range {p0 .. p0}, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->invalidate()V

    goto/16 :goto_0

    .line 261
    :cond_25
    const/4 v14, 0x0

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getX(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v5, v14

    goto/16 :goto_a

    .line 264
    :cond_26
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_a

    .line 267
    :cond_27
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_28

    .line 268
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_28

    .line 269
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_1c

    .line 270
    const/4 v14, 0x0

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_a

    .line 272
    :cond_28
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_29

    .line 273
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_1c

    .line 274
    const/4 v14, 0x0

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_a

    .line 276
    :cond_29
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_1c

    .line 277
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_1c

    .line 278
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_a

    .line 285
    :cond_2a
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_2b

    .line 286
    const/4 v14, 0x1

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_b

    .line 288
    :cond_2b
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_1d

    .line 289
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->height:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_1d

    .line 290
    const/4 v14, 0x1

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_b

    .line 300
    :cond_2c
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_2d

    .line 301
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_2d

    .line 302
    const/4 v14, 0x0

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_c

    .line 304
    :cond_2d
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_2e

    .line 305
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_2e

    .line 306
    const/4 v14, 0x0

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_c

    .line 308
    :cond_2e
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_1e

    .line 309
    const/4 v14, 0x0

    const/high16 v15, 0x42860000    # 67.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_c

    .line 315
    :cond_2f
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_30

    .line 316
    const/4 v14, 0x1

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_d

    .line 317
    :cond_30
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_1f

    .line 318
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->height:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_1f

    .line 319
    const/4 v14, 0x1

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_d

    .line 331
    :cond_31
    const/4 v14, 0x0

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getX(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v5, v14

    goto/16 :goto_e

    .line 335
    :cond_32
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_e

    .line 337
    :cond_33
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_34

    const/4 v14, 0x0

    .line 338
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_34

    .line 339
    const/4 v14, 0x0

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_e

    .line 340
    :cond_34
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_35

    .line 341
    const/4 v14, 0x0

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_e

    .line 342
    :cond_35
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_20

    .line 343
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_e

    .line 349
    :cond_36
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_37

    .line 350
    const/4 v14, 0x1

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_f

    .line 351
    :cond_37
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_21

    const/4 v14, 0x0

    .line 352
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->height:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_21

    .line 353
    const/4 v14, 0x1

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_f

    .line 362
    :cond_38
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_39

    const/4 v14, 0x0

    .line 363
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_39

    .line 364
    const/4 v14, 0x0

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_10

    .line 365
    :cond_39
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_3a

    const/4 v14, 0x0

    .line 366
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_3a

    .line 367
    const/4 v14, 0x0

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_10

    .line 368
    :cond_3a
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_22

    .line 369
    const/4 v14, 0x0

    const/high16 v15, 0x42860000    # 67.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_10

    .line 375
    :cond_3b
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_3c

    .line 376
    const/4 v14, 0x1

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_11

    .line 377
    :cond_3c
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_23

    const/4 v14, 0x0

    .line 378
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->height:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_23

    .line 379
    const/4 v14, 0x1

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_11

    .line 387
    :cond_3d
    const/4 v14, 0x2

    if-ne v10, v14, :cond_24

    .line 388
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_3f

    .line 389
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_48

    const/4 v14, 0x0

    .line 390
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_48

    .line 391
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_47

    .line 392
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    const/high16 v16, 0x40c00000    # 6.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v17, v0

    mul-float v16, v16, v17

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_46

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    const/high16 v16, 0x40c00000    # 6.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v17, v0

    mul-float v16, v16, v17

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_46

    .line 393
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    .line 413
    :cond_3e
    :goto_13
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_4b

    const/4 v14, 0x0

    .line 414
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_4b

    .line 415
    const/4 v14, 0x1

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getY(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v5, v14

    .line 423
    :cond_3f
    :goto_14
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_41

    .line 425
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_4f

    const/4 v14, 0x1

    .line 426
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_4f

    .line 427
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_4e

    .line 428
    const-string v14, "Joystick_view"

    const-string v15, "second Move left throttle"

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 429
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    const/high16 v16, 0x40c00000    # 6.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v17, v0

    mul-float v16, v16, v17

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_4d

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    const/high16 v16, 0x40c00000    # 6.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v17, v0

    mul-float v16, v16, v17

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_4d

    .line 430
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    .line 451
    :cond_40
    :goto_15
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_52

    const/4 v14, 0x1

    .line 452
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_52

    .line 453
    const/4 v14, 0x1

    const/4 v15, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getY(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v5, v14

    .line 462
    :cond_41
    :goto_16
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v5}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 464
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_43

    .line 465
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_54

    const/4 v14, 0x0

    .line 466
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_54

    .line 467
    const/4 v14, 0x0

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getX(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v12, v14

    .line 478
    :cond_42
    :goto_17
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_57

    const/4 v14, 0x0

    .line 479
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_57

    .line 480
    const/4 v14, 0x1

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getY(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v12, v14

    .line 488
    :cond_43
    :goto_18
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_45

    .line 489
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_59

    const/4 v14, 0x1

    .line 490
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_59

    .line 491
    const/4 v14, 0x0

    const/4 v15, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getX(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v12, v14

    .line 502
    :cond_44
    :goto_19
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_5c

    const/4 v14, 0x1

    .line 503
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_5c

    .line 504
    const/4 v14, 0x1

    const/4 v15, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getY(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v12, v14

    .line 512
    :cond_45
    :goto_1a
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v12}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setRight([I)V

    goto/16 :goto_12

    .line 395
    :cond_46
    const/4 v14, 0x0

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getX(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v5, v14

    goto/16 :goto_13

    .line 399
    :cond_47
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_13

    .line 401
    :cond_48
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_49

    const/4 v14, 0x0

    .line 402
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_49

    .line 403
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_3e

    .line 404
    const/4 v14, 0x0

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_13

    .line 405
    :cond_49
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_4a

    .line 406
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_3e

    .line 407
    const/4 v14, 0x0

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_13

    .line 408
    :cond_4a
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_3e

    .line 409
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_3e

    .line 410
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_13

    .line 416
    :cond_4b
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_4c

    .line 417
    const/4 v14, 0x1

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_14

    .line 418
    :cond_4c
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_3f

    const/4 v14, 0x0

    .line 419
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->height:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_3f

    .line 420
    const/4 v14, 0x1

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_14

    .line 433
    :cond_4d
    const/4 v14, 0x0

    const/4 v15, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getX(I)F

    move-result v15

    float-to-int v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    sub-int v15, v15, v16

    aput v15, v5, v14

    goto/16 :goto_15

    .line 437
    :cond_4e
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_15

    .line 439
    :cond_4f
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_50

    const/4 v14, 0x1

    .line 440
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_50

    .line 441
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_40

    .line 442
    const/4 v14, 0x0

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_15

    .line 443
    :cond_50
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_51

    .line 444
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_40

    .line 445
    const/4 v14, 0x0

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_15

    .line 446
    :cond_51
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_40

    .line 447
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-nez v14, :cond_40

    .line 448
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_15

    .line 454
    :cond_52
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_53

    .line 455
    const/4 v14, 0x1

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_16

    .line 456
    :cond_53
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_41

    const/4 v14, 0x1

    .line 457
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->height:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_41

    .line 458
    const/4 v14, 0x1

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v5, v14

    goto/16 :goto_16

    .line 468
    :cond_54
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_55

    const/4 v14, 0x0

    .line 469
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_55

    .line 470
    const/4 v14, 0x0

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_17

    .line 471
    :cond_55
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_56

    const/4 v14, 0x0

    .line 472
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_56

    .line 473
    const/4 v14, 0x0

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_17

    .line 474
    :cond_56
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_42

    .line 475
    const/4 v14, 0x0

    const/high16 v15, 0x42860000    # 67.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_17

    .line 481
    :cond_57
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_58

    .line 482
    const/4 v14, 0x1

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_18

    .line 483
    :cond_58
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_43

    const/4 v14, 0x0

    .line 484
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->height:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_43

    .line 485
    const/4 v14, 0x1

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_18

    .line 492
    :cond_59
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_5a

    const/4 v14, 0x1

    .line 493
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_5a

    .line 494
    const/4 v14, 0x0

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_19

    .line 495
    :cond_5a
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_5b

    const/4 v14, 0x1

    .line 496
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_5b

    .line 497
    const/4 v14, 0x0

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_19

    .line 498
    :cond_5b
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_44

    .line 499
    const/4 v14, 0x0

    const/high16 v15, 0x42860000    # 67.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_19

    .line 505
    :cond_5c
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_5d

    .line 506
    const/4 v14, 0x1

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_1a

    .line 507
    :cond_5d
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_45

    const/4 v14, 0x1

    .line 508
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->height:F

    cmpg-float v14, v14, v15

    if-gez v14, :cond_45

    .line 509
    const/4 v14, 0x1

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v12, v14

    goto/16 :goto_1a

    .line 519
    .end local v5    # "left":[I
    .end local v12    # "right":[I
    :sswitch_2
    const-string v14, "Joystick_view"

    const-string v15, "pointer1 down"

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 520
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_6c

    .line 521
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_6c

    .line 522
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_6c

    .line 523
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_6c

    .line 524
    const-string v14, "Joystick_view"

    const-string v15, "unlock left throttle"

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 525
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x7

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_5e

    .line 526
    const/high16 v14, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    mul-float/2addr v14, v15

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v15}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v15

    invoke-virtual {v15}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v15

    int-to-float v15, v15

    sub-float v11, v14, v15

    .line 527
    .restart local v11    # "position":F
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_5e

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    cmpl-float v14, v14, v11

    if-ltz v14, :cond_5e

    .line 528
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x4

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 532
    .end local v11    # "position":F
    :cond_5e
    const/4 v14, 0x2

    new-array v2, v14, [I

    const/4 v14, 0x0

    .line 533
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v2, v14

    const/4 v14, 0x1

    .line 534
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v2, v14

    .line 536
    .restart local v2    # "down_left":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x1

    aput-boolean v16, v14, v15

    .line 537
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 538
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_5f

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_5f

    .line 539
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41400000    # 12.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_6b

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41b80000    # 23.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_6b

    .line 540
    const/4 v14, 0x0

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v2, v14

    .line 548
    :cond_5f
    :goto_1b
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_60

    .line 549
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 567
    .end local v2    # "down_left":[I
    :cond_60
    :goto_1c
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_61

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_61

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42400000    # 48.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_61

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42540000    # 53.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_61

    .line 568
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-eqz v14, :cond_6d

    .line 569
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    .line 574
    :goto_1d
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 575
    const-string v14, "Joystick_view"

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "locked : "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 579
    :cond_61
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_62

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_62

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_62

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_62

    .line 580
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 581
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x2

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    sub-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 582
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x4

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 585
    :cond_62
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41e00000    # 28.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_63

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_63

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_63

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_63

    .line 586
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 587
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x2

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 588
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x5

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 591
    :cond_63
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_64

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_64

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_64

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_64

    .line 592
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 593
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x1

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 594
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x3

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 597
    :cond_64
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_65

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_65

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_65

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_65

    .line 598
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 599
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x1

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    sub-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 600
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x2

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 603
    :cond_65
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_66

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42640000    # 57.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_66

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_66

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_66

    .line 604
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 605
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x0

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    sub-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 606
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x0

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 609
    :cond_66
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x429a0000    # 77.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_67

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_67

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_67

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_67

    .line 610
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 611
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x0

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 612
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 615
    :cond_67
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41600000    # 14.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_68

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41980000    # 19.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_68

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_68

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41200000    # 10.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_68

    .line 616
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 617
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x4

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_6e

    .line 618
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 625
    :cond_68
    :goto_1e
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41b00000    # 22.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_69

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_69

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_69

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41200000    # 10.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_69

    .line 626
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 628
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x5

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_6f

    .line 629
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x2

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 640
    :cond_69
    :goto_1f
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x41e80000    # 29.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_6a

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42080000    # 34.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_6a

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_6a

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41200000    # 10.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_6a

    .line 641
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 642
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_70

    .line 643
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x3

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 650
    :cond_6a
    :goto_20
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_72

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_72

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_72

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_72

    .line 651
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v14

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-nez v14, :cond_73

    .line 652
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 653
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setACCCalibration(Z)V

    .line 655
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x5dc

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 656
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 657
    const/4 v4, 0x1

    .restart local v4    # "i":I
    :goto_21
    const/4 v14, 0x5

    if-ge v4, v14, :cond_71

    .line 658
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x3e8

    invoke-virtual {v14, v4, v15}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 657
    add-int/lit8 v4, v4, 0x1

    goto :goto_21

    .line 543
    .end local v4    # "i":I
    .restart local v2    # "down_left":[I
    :cond_6b
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 544
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    goto/16 :goto_1b

    .line 553
    .end local v2    # "down_left":[I
    :cond_6c
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_60

    const/4 v14, 0x0

    .line 554
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_60

    const/4 v14, 0x0

    .line 555
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_60

    const/4 v14, 0x0

    .line 556
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_60

    .line 557
    const-string v14, "Joystick_view"

    const-string v15, "unlock right throttle"

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 558
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 559
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x1

    aput-boolean v16, v14, v15

    .line 560
    const/4 v14, 0x2

    new-array v7, v14, [I

    const/4 v14, 0x0

    const/4 v15, 0x0

    .line 561
    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getX(I)F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v7, v14

    const/4 v14, 0x1

    const/4 v15, 0x0

    .line 562
    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getY(I)F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v7, v14

    .line 564
    .local v7, "pointer1_down_right":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v7}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setRight([I)V

    goto/16 :goto_1c

    .line 572
    .end local v7    # "pointer1_down_right":[I
    :cond_6d
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    goto/16 :goto_1d

    .line 620
    :cond_6e
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x4

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_68

    .line 621
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_1e

    .line 631
    :cond_6f
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x5

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_69

    .line 632
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x2

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_1f

    .line 645
    :cond_70
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_6a

    .line 646
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x3

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_20

    .line 660
    .restart local v4    # "i":I
    :cond_71
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v15, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$3;

    move-object/from16 v0, p0

    invoke-direct {v15, v0}, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$3;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;)V

    const-wide/16 v16, 0x1f4

    invoke-virtual/range {v14 .. v17}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 672
    .end local v4    # "i":I
    :cond_72
    :goto_22
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x423c0000    # 47.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_1

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_1

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_1

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v14

    const/high16 v15, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_1

    .line 673
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v14

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-nez v14, :cond_75

    .line 674
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 675
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setMAGCalibration(Z)V

    .line 677
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x5dc

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 678
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 679
    const/4 v4, 0x1

    .restart local v4    # "i":I
    :goto_23
    const/4 v14, 0x5

    if-ge v4, v14, :cond_74

    .line 680
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x3e8

    invoke-virtual {v14, v4, v15}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 679
    add-int/lit8 v4, v4, 0x1

    goto :goto_23

    .line 668
    .end local v4    # "i":I
    :cond_73
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mContext:Landroid/content/Context;

    const-string v15, "\uad50\uc815 \uc911..."

    const/16 v16, 0x0

    invoke-static/range {v14 .. v16}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v14

    invoke-virtual {v14}, Landroid/widget/Toast;->show()V

    goto/16 :goto_22

    .line 681
    .restart local v4    # "i":I
    :cond_74
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v15, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$4;

    move-object/from16 v0, p0

    invoke-direct {v15, v0}, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$4;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;)V

    const-wide/16 v16, 0x1f4

    invoke-virtual/range {v14 .. v17}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 690
    .end local v4    # "i":I
    :cond_75
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mContext:Landroid/content/Context;

    const-string v15, "\uad50\uc815 \uc911..."

    const/16 v16, 0x0

    invoke-static/range {v14 .. v16}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v14

    invoke-virtual {v14}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 698
    :sswitch_3
    const-string v14, "Joystick_view"

    const-string v15, "pointer2 down"

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 699
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_82

    const/4 v14, 0x1

    .line 700
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_82

    const/4 v14, 0x1

    .line 701
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_82

    const/4 v14, 0x1

    .line 702
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_82

    .line 703
    const-string v14, "Joystick_view"

    const-string v15, "unlock left throttle"

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 704
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x7

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_76

    .line 705
    const/high16 v14, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    mul-float/2addr v14, v15

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v15}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v15

    invoke-virtual {v15}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v15

    int-to-float v15, v15

    sub-float v11, v14, v15

    .line 706
    .restart local v11    # "position":F
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_76

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    cmpl-float v14, v14, v11

    if-ltz v14, :cond_76

    .line 707
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x4

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 710
    .end local v11    # "position":F
    :cond_76
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x1

    aput-boolean v16, v14, v15

    .line 711
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 712
    const/4 v14, 0x2

    new-array v8, v14, [I

    const/4 v14, 0x0

    const/4 v15, 0x1

    .line 713
    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getX(I)F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v8, v14

    const/4 v14, 0x1

    const/4 v15, 0x1

    .line 714
    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getY(I)F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v8, v14

    .line 716
    .local v8, "pointer2_down_left":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v8}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 733
    .end local v8    # "pointer2_down_left":[I
    :cond_77
    :goto_24
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_78

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_78

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42400000    # 48.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_78

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42540000    # 53.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_78

    .line 734
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v14

    if-eqz v14, :cond_83

    .line 735
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    .line 740
    :goto_25
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 741
    const-string v14, "Joystick_view"

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "locked : "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 745
    :cond_78
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_79

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_79

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_79

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_79

    .line 746
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 747
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x2

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    sub-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 748
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x4

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 751
    :cond_79
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x41e00000    # 28.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7a

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7a

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7a

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7a

    .line 752
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 753
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x2

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 754
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x5

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 757
    :cond_7a
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7b

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7b

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7b

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7b

    .line 758
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 759
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x1

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 760
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x3

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 763
    :cond_7b
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7c

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7c

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7c

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7c

    .line 764
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 765
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x1

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    sub-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 766
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x2

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 769
    :cond_7c
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7d

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42640000    # 57.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7d

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7d

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7d

    .line 770
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 771
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x0

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    sub-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 772
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x0

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 775
    :cond_7d
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x429a0000    # 77.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7e

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7e

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7e

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x424c0000    # 51.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7e

    .line 776
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 777
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v15}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v15

    const/16 v16, 0x0

    aget v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 778
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setTream_touched(IZ)V

    .line 781
    :cond_7e
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x41600000    # 14.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7f

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x41980000    # 19.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7f

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_7f

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41200000    # 10.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_7f

    .line 782
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 783
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x4

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_84

    .line 784
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 791
    :cond_7f
    :goto_26
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x41b00000    # 22.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_80

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_80

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_80

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41200000    # 10.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_80

    .line 792
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 794
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x5

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_85

    .line 795
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x2

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 806
    :cond_80
    :goto_27
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x41e80000    # 29.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_81

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42080000    # 34.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_81

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_81

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41200000    # 10.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_81

    .line 807
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 808
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_86

    .line 809
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x3

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 816
    :cond_81
    :goto_28
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_88

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_88

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_88

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_88

    .line 817
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v14

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-nez v14, :cond_89

    .line 818
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 819
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setACCCalibration(Z)V

    .line 821
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x5dc

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 822
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 823
    const/4 v4, 0x1

    .restart local v4    # "i":I
    :goto_29
    const/4 v14, 0x5

    if-ge v4, v14, :cond_87

    .line 824
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x3e8

    invoke-virtual {v14, v4, v15}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 823
    add-int/lit8 v4, v4, 0x1

    goto :goto_29

    .line 719
    .end local v4    # "i":I
    :cond_82
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_77

    const/4 v14, 0x1

    .line 720
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_77

    const/4 v14, 0x1

    .line 721
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    add-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_77

    const/4 v14, 0x1

    .line 722
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_77

    .line 723
    const-string v14, "Joystick_view"

    const-string v15, "unlock right throttle"

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 724
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 725
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x1

    aput-boolean v16, v14, v15

    .line 726
    const/4 v14, 0x2

    new-array v9, v14, [I

    const/4 v14, 0x0

    const/4 v15, 0x1

    .line 727
    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getX(I)F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v9, v14

    const/4 v14, 0x1

    const/4 v15, 0x1

    .line 728
    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/MotionEvent;->getY(I)F

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v9, v14

    .line 730
    .local v9, "pointer2_down_right":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v9}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setRight([I)V

    goto/16 :goto_24

    .line 738
    .end local v9    # "pointer2_down_right":[I
    :cond_83
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    goto/16 :goto_25

    .line 786
    :cond_84
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x4

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_7f

    .line 787
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_26

    .line 797
    :cond_85
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x5

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_80

    .line 798
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x2

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_27

    .line 811
    :cond_86
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_81

    .line 812
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x3

    const/16 v16, 0x7d0

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_28

    .line 826
    .restart local v4    # "i":I
    :cond_87
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v15, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$5;

    move-object/from16 v0, p0

    invoke-direct {v15, v0}, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$5;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;)V

    const-wide/16 v16, 0x1f4

    invoke-virtual/range {v14 .. v17}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 838
    .end local v4    # "i":I
    :cond_88
    :goto_2a
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x423c0000    # 47.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_1

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    const/high16 v15, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_1

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-ltz v14, :cond_1

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v14

    const/high16 v15, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gtz v14, :cond_1

    .line 839
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v14

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-nez v14, :cond_8b

    .line 840
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 841
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x1

    invoke-virtual {v14, v15}, Lcom/drms/drms_drone/MultiData;->setMAGCalibration(Z)V

    .line 843
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x5dc

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 844
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x5dc

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 845
    const/4 v4, 0x1

    .restart local v4    # "i":I
    :goto_2b
    const/4 v14, 0x5

    if-ge v4, v14, :cond_8a

    .line 846
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v15, 0x3e8

    invoke-virtual {v14, v4, v15}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 845
    add-int/lit8 v4, v4, 0x1

    goto :goto_2b

    .line 834
    .end local v4    # "i":I
    :cond_89
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mContext:Landroid/content/Context;

    const-string v15, "\uad50\uc815 \uc911..."

    const/16 v16, 0x0

    invoke-static/range {v14 .. v16}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v14

    invoke-virtual {v14}, Landroid/widget/Toast;->show()V

    goto/16 :goto_2a

    .line 847
    .restart local v4    # "i":I
    :cond_8a
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v15, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$6;

    move-object/from16 v0, p0

    invoke-direct {v15, v0}, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$6;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;)V

    const-wide/16 v16, 0x1f4

    invoke-virtual/range {v14 .. v17}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 856
    .end local v4    # "i":I
    :cond_8b
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mContext:Landroid/content/Context;

    const-string v15, "\uad50\uc815 \uc911..."

    const/16 v16, 0x0

    invoke-static/range {v14 .. v16}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v14

    invoke-virtual {v14}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 863
    :sswitch_4
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_8f

    .line 864
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_8d

    .line 865
    const/4 v14, 0x2

    new-array v6, v14, [I

    .line 866
    .local v6, "left_temp":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_8e

    .line 867
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 868
    const/4 v14, 0x1

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 874
    :cond_8c
    :goto_2c
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v6}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 875
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 876
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x3

    aget v14, v14, v15

    const/16 v15, 0x41a

    if-gt v14, v15, :cond_8d

    .line 877
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x4

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 891
    .end local v6    # "left_temp":[I
    :cond_8d
    :goto_2d
    const-string v14, "Joystick_view"

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "pointer1 count : "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 870
    .restart local v6    # "left_temp":[I
    :cond_8e
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_8c

    .line 871
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 872
    const/4 v14, 0x1

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v15}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v15

    const/16 v16, 0x1

    aget v15, v15, v16

    aput v15, v6, v14

    goto/16 :goto_2c

    .line 881
    .end local v6    # "left_temp":[I
    :cond_8f
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_8d

    .line 882
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpl-float v14, v14, v15

    if-lez v14, :cond_8d

    .line 883
    const/4 v14, 0x2

    new-array v6, v14, [I

    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    const/4 v14, 0x1

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 884
    .restart local v6    # "left_temp":[I
    const/4 v14, 0x2

    new-array v13, v14, [I

    const/4 v14, 0x0

    const/high16 v15, 0x42860000    # 67.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v13, v14

    const/4 v14, 0x1

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v13, v14

    .line 885
    .local v13, "right_temp":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v13}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setRight([I)V

    .line 886
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_8d

    .line 887
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    goto/16 :goto_2d

    .line 904
    .end local v6    # "left_temp":[I
    .end local v13    # "right_temp":[I
    :sswitch_5
    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_93

    .line 905
    const/4 v14, 0x2

    new-array v6, v14, [I

    .line 906
    .restart local v6    # "left_temp":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_92

    .line 907
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 908
    const/4 v14, 0x1

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 914
    :cond_90
    :goto_2e
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v6}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 915
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 916
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x3

    aget v14, v14, v15

    const/16 v15, 0x41a

    if-gt v14, v15, :cond_91

    .line 917
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x4

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 928
    :cond_91
    :goto_2f
    const-string v14, "Joystick_view"

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "pointer2 count : "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 910
    :cond_92
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_90

    .line 911
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 912
    const/4 v14, 0x1

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v15}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v15

    const/16 v16, 0x1

    aget v15, v15, v16

    aput v15, v6, v14

    goto/16 :goto_2e

    .line 921
    .end local v6    # "left_temp":[I
    :cond_93
    const/4 v14, 0x2

    new-array v6, v14, [I

    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    const/4 v14, 0x1

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 922
    .restart local v6    # "left_temp":[I
    const/4 v14, 0x2

    new-array v13, v14, [I

    const/4 v14, 0x0

    const/high16 v15, 0x42860000    # 67.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v13, v14

    const/4 v14, 0x1

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v13, v14

    .line 923
    .restart local v13    # "right_temp":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v13}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setRight([I)V

    .line 924
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_91

    .line 925
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    goto/16 :goto_2f

    .line 943
    .end local v6    # "left_temp":[I
    .end local v13    # "right_temp":[I
    :sswitch_6
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->width:F

    const/high16 v16, 0x40000000    # 2.0f

    div-float v15, v15, v16

    cmpg-float v14, v14, v15

    if-gez v14, :cond_98

    .line 944
    const/4 v14, 0x2

    new-array v6, v14, [I

    .line 945
    .restart local v6    # "left_temp":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x7d0

    if-ne v14, v15, :cond_97

    .line 946
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 947
    const/4 v14, 0x1

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 953
    :cond_94
    :goto_30
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v6}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 954
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_95

    .line 955
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 957
    :cond_95
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x0

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_96

    .line 958
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 961
    :cond_96
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x3

    aget v14, v14, v15

    const/16 v15, 0x41a

    if-gt v14, v15, :cond_1

    .line 962
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v15, 0x4

    const/16 v16, 0x3e8

    invoke-virtual/range {v14 .. v16}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_0

    .line 949
    :cond_97
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v14}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v14

    const/4 v15, 0x6

    aget v14, v14, v15

    const/16 v15, 0x3e8

    if-ne v14, v15, :cond_94

    .line 950
    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 951
    const/4 v14, 0x1

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v15}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v15

    const/16 v16, 0x1

    aget v15, v15, v16

    aput v15, v6, v14

    goto/16 :goto_30

    .line 967
    .end local v6    # "left_temp":[I
    :cond_98
    const/4 v14, 0x2

    new-array v6, v14, [I

    const/4 v14, 0x0

    const/high16 v15, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    const/4 v14, 0x1

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v6, v14

    .line 968
    .restart local v6    # "left_temp":[I
    const/4 v14, 0x2

    new-array v13, v14, [I

    const/4 v14, 0x0

    const/high16 v15, 0x42860000    # 67.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->x:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v13, v14

    const/4 v14, 0x1

    const/high16 v15, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->y:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    div-int/lit8 v16, v16, 0x2

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    sub-float v15, v15, v16

    float-to-int v15, v15

    aput v15, v13, v14

    .line 969
    .restart local v13    # "right_temp":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v14, v13}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setRight([I)V

    .line 970
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_99

    .line 971
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x0

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    .line 973
    :cond_99
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x1

    aget-boolean v14, v14, v15

    if-eqz v14, :cond_1

    .line 974
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->unlock_throttle:[[Z

    const/4 v15, 0x1

    aget-object v14, v14, v15

    const/4 v15, 0x1

    const/16 v16, 0x0

    aput-boolean v16, v14, v15

    goto/16 :goto_0

    .line 56
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x1 -> :sswitch_6
        0x2 -> :sswitch_1
        0x5 -> :sswitch_2
        0x6 -> :sswitch_4
        0x105 -> :sswitch_3
        0x106 -> :sswitch_5
    .end sparse-switch
.end method
