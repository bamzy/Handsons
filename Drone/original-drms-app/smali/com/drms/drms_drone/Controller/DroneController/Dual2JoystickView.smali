.class public Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;
.super Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
.source "Dual2JoystickView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;
    }
.end annotation


# instance fields
.field private isSensorActivation:Z

.field pitchToMSP:I

.field rollToMSP:I

.field sensorCount:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;Landroid/os/Handler;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mActivity"    # Landroid/app/Activity;
    .param p3, "mHandler"    # Landroid/os/Handler;

    .prologue
    const/4 v0, 0x0

    .line 32
    invoke-direct {p0, p1, p2, p3}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;-><init>(Landroid/content/Context;Landroid/app/Activity;Landroid/os/Handler;)V

    .line 27
    iput-boolean v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->isSensorActivation:Z

    .line 28
    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->rollToMSP:I

    .line 29
    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->pitchToMSP:I

    .line 73
    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->sensorCount:I

    .line 33
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mContext:Landroid/content/Context;

    const-string v1, "sensor"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/SensorManager;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSensorManager:Landroid/hardware/SensorManager;

    .line 34
    new-instance v0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$1;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSensorEventListener:Landroid/hardware/SensorEventListener;

    .line 35
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSensorManager:Landroid/hardware/SensorManager;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSensorEventListener:Landroid/hardware/SensorEventListener;

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSensorManager:Landroid/hardware/SensorManager;

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v2

    const/4 v3, 0x2

    invoke-virtual {v0, v1, v2, v3}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z

    .line 47
    return-void
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    .prologue
    .line 25
    iget-boolean v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->isSensorActivation:Z

    return v0
.end method


# virtual methods
.method protected drawBackground(FIFI)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "width"    # F
    .param p2, "unitW"    # I
    .param p3, "height"    # F
    .param p4, "unitH"    # I

    .prologue
    .line 61
    invoke-super {p0, p1, p2, p3, p4}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->drawBackground(FIFI)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method protected drawController(Landroid/graphics/Canvas;)V
    .locals 0
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 66
    invoke-super {p0, p1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->drawController(Landroid/graphics/Canvas;)V

    .line 68
    return-void
.end method

.method public getmSensorManager()Landroid/hardware/SensorManager;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSensorManager:Landroid/hardware/SensorManager;

    return-object v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v4, 0x40c00000    # 6.0f

    .line 51
    invoke-super {p0, p1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->onDraw(Landroid/graphics/Canvas;)V

    .line 53
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030034

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 54
    .local v0, "throttle":Landroid/graphics/Bitmap;
    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v2, v4

    float-to-int v2, v2

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 57
    .local v1, "throttle_image":Landroid/graphics/Bitmap;
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 14
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 124
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v5

    .line 125
    .local v5, "pointer_count":I
    const/4 v9, 0x2

    if-le v5, v9, :cond_0

    const/4 v5, 0x2

    .line 127
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v9

    sparse-switch v9, :sswitch_data_0

    .line 887
    :cond_1
    :goto_0
    const/4 v9, 0x1

    return v9

    .line 129
    :sswitch_0
    const-string v9, "Joystick_view"

    const-string v10, "onTouch"

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 130
    const-string v9, "Joystick_view"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "x: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\ny : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 131
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_11

    .line 132
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_11

    .line 133
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_11

    .line 134
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42480000    # 50.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_11

    .line 135
    const-string v9, "Joystick_view"

    const-string v10, "unlock left throttle"

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 137
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v9

    const/4 v10, 0x7

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_2

    .line 138
    const/high16 v9, 0x42340000    # 45.0f

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v9, v10

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v10}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v10

    invoke-virtual {v10}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v10

    int-to-float v10, v10

    sub-float v6, v9, v10

    .line 139
    .local v6, "position":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42480000    # 50.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    cmpl-float v9, v9, v6

    if-ltz v9, :cond_2

    .line 140
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x4

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 144
    .end local v6    # "position":F
    :cond_2
    const/4 v9, 0x2

    new-array v0, v9, [I

    const/4 v9, 0x0

    .line 145
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v0, v9

    const/4 v9, 0x1

    .line 146
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v0, v9

    .line 148
    .local v0, "down_left":[I
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x1

    aput-boolean v11, v9, v10

    .line 149
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x1

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    .line 150
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42480000    # 50.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_3

    .line 151
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41400000    # 12.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_10

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41b80000    # 23.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_10

    .line 152
    const/4 v9, 0x0

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v0, v9

    .line 160
    :cond_3
    :goto_1
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x1

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_4

    .line 161
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v9, v0}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 176
    .end local v0    # "down_left":[I
    :cond_4
    :goto_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_5

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_5

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42400000    # 48.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_5

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42540000    # 53.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_5

    .line 177
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-eqz v9, :cond_13

    .line 178
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    .line 183
    :goto_3
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 184
    const-string v9, "Joystick_view"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "locked : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 188
    :cond_5
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x40000000    # 2.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_6

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41100000    # 9.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_6

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40000000    # 2.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_6

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41400000    # 12.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_6

    .line 189
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mHandler:Landroid/os/Handler;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v9

    invoke-virtual {v9}, Landroid/os/Message;->sendToTarget()V

    .line 190
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 194
    :cond_6
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_7

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41000000    # 8.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_7

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_7

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_7

    .line 195
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 196
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x2

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    sub-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 199
    :cond_7
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41e00000    # 28.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_8

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_8

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_8

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_8

    .line 200
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 201
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x2

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 204
    :cond_8
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_9

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_9

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41f00000    # 30.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_9

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x420c0000    # 35.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_9

    .line 205
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 206
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x1

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 209
    :cond_9
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_a

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_a

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_a

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_a

    .line 210
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 211
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x1

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    sub-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 214
    :cond_a
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42640000    # 57.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_b

    .line 215
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 216
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x0

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    sub-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 219
    :cond_b
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x429a0000    # 77.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_c

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42a40000    # 82.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_c

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_c

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_c

    .line 220
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 221
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x0

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 224
    :cond_c
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41600000    # 14.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_d

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41980000    # 19.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_d

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40a00000    # 5.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_d

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41200000    # 10.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_d

    .line 225
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 226
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x4

    aget v9, v9, v10

    const/16 v10, 0x7d0

    if-ne v9, v10, :cond_14

    .line 227
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 234
    :cond_d
    :goto_4
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41b00000    # 22.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_e

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41d80000    # 27.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_e

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40a00000    # 5.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_e

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41200000    # 10.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_e

    .line 235
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 237
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x5

    aget v9, v9, v10

    const/16 v10, 0x7d0

    if-ne v9, v10, :cond_15

    .line 238
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x2

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 249
    :cond_e
    :goto_5
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41e80000    # 29.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_f

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42080000    # 34.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_f

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40a00000    # 5.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_f

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41200000    # 10.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_f

    .line 250
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 251
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x6

    aget v9, v9, v10

    const/16 v10, 0x7d0

    if-ne v9, v10, :cond_16

    .line 252
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x3

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 259
    :cond_f
    :goto_6
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_18

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_18

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_18

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41000000    # 8.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_18

    .line 260
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v9

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-nez v9, :cond_19

    .line 261
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 262
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setACCCalibration(Z)V

    .line 264
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x5dc

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 265
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 266
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_7
    const/4 v9, 0x5

    if-ge v1, v9, :cond_17

    .line 267
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x3e8

    invoke-virtual {v9, v1, v10}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 266
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    .line 155
    .end local v1    # "i":I
    .restart local v0    # "down_left":[I
    :cond_10
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    .line 156
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x1

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    goto/16 :goto_1

    .line 165
    .end local v0    # "down_left":[I
    :cond_11
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_12

    .line 166
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42a40000    # 82.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_12

    .line 167
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_12

    .line 168
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_12

    .line 169
    const/4 v9, 0x1

    iput-boolean v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->isSensorActivation:Z

    goto/16 :goto_2

    .line 172
    :cond_12
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    .line 173
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x1

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    goto/16 :goto_2

    .line 181
    :cond_13
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    goto/16 :goto_3

    .line 229
    :cond_14
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x4

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_d

    .line 230
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_4

    .line 240
    :cond_15
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x5

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_e

    .line 241
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x2

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_5

    .line 254
    :cond_16
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x6

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_f

    .line 255
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x3

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_6

    .line 269
    .restart local v1    # "i":I
    :cond_17
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v10, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$1;

    invoke-direct {v10, p0}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$1;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;)V

    const-wide/16 v12, 0x1f4

    invoke-virtual {v9, v10, v12, v13}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 281
    .end local v1    # "i":I
    :cond_18
    :goto_8
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x423c0000    # 47.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41000000    # 8.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_1

    .line 282
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v9

    const/4 v10, 0x1

    aget-boolean v9, v9, v10

    if-nez v9, :cond_1b

    .line 283
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 284
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setMAGCalibration(Z)V

    .line 286
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x5dc

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 287
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 288
    const/4 v1, 0x1

    .restart local v1    # "i":I
    :goto_9
    const/4 v9, 0x5

    if-ge v1, v9, :cond_1a

    .line 289
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x3e8

    invoke-virtual {v9, v1, v10}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 288
    add-int/lit8 v1, v1, 0x1

    goto :goto_9

    .line 277
    .end local v1    # "i":I
    :cond_19
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mContext:Landroid/content/Context;

    const-string v10, "\uad50\uc815 \uc911..."

    const/4 v11, 0x0

    invoke-static {v9, v10, v11}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v9

    invoke-virtual {v9}, Landroid/widget/Toast;->show()V

    goto :goto_8

    .line 290
    .restart local v1    # "i":I
    :cond_1a
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v10, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$2;

    invoke-direct {v10, p0}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$2;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;)V

    const-wide/16 v12, 0x1f4

    invoke-virtual {v9, v10, v12, v13}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 299
    .end local v1    # "i":I
    :cond_1b
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mContext:Landroid/content/Context;

    const-string v10, "\uad50\uc815 \uc911..."

    const/4 v11, 0x0

    invoke-static {v9, v10, v11}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v9

    invoke-virtual {v9}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 307
    :sswitch_1
    const/4 v9, 0x2

    new-array v2, v9, [I

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v10}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v10

    const/4 v11, 0x0

    aget v10, v10, v11

    aput v10, v2, v9

    const/4 v9, 0x1

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v10}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v10

    const/4 v11, 0x1

    aget v10, v10, v11

    aput v10, v2, v9

    .line 308
    .local v2, "left":[I
    const/4 v9, 0x2

    new-array v7, v9, [I

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v10}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getRight()[I

    move-result-object v10

    const/4 v11, 0x0

    aget v10, v10, v11

    aput v10, v7, v9

    const/4 v9, 0x1

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v10}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getRight()[I

    move-result-object v10

    const/4 v11, 0x1

    aget v10, v10, v11

    aput v10, v7, v9

    .line 310
    .local v7, "right":[I
    const/4 v9, 0x1

    if-ne v5, v9, :cond_2f

    .line 311
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_1d

    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x1

    aget-boolean v9, v9, v10

    if-nez v9, :cond_1d

    .line 312
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_23

    .line 313
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_23

    .line 315
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_22

    .line 316
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    const/high16 v11, 0x40c00000    # 6.0f

    iget v12, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v11, v12

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_21

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    const/high16 v11, 0x40c00000    # 6.0f

    iget v12, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v11, v12

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_21

    .line 317
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    .line 339
    :cond_1c
    :goto_a
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_26

    .line 340
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_26

    .line 341
    const/4 v9, 0x1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v10

    float-to-int v10, v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    sub-int/2addr v10, v11

    aput v10, v2, v9

    .line 353
    :cond_1d
    :goto_b
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_1f

    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x1

    aget-boolean v9, v9, v10

    if-nez v9, :cond_1f

    .line 355
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_2a

    const/4 v9, 0x0

    .line 356
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_2a

    .line 357
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_29

    .line 358
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    const/high16 v11, 0x40c00000    # 6.0f

    iget v12, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v11, v12

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_28

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    const/high16 v11, 0x40c00000    # 6.0f

    iget v12, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v11, v12

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_28

    .line 359
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    .line 376
    :cond_1e
    :goto_c
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_2d

    const/4 v9, 0x0

    .line 377
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_2d

    .line 378
    const/4 v9, 0x1

    const/4 v10, 0x0

    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getY(I)F

    move-result v10

    float-to-int v10, v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    sub-int/2addr v10, v11

    aput v10, v2, v9

    .line 388
    :cond_1f
    :goto_d
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v9, v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 469
    :cond_20
    :goto_e
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->invalidate()V

    goto/16 :goto_0

    .line 319
    :cond_21
    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getX(I)F

    move-result v10

    float-to-int v10, v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    sub-int/2addr v10, v11

    aput v10, v2, v9

    goto/16 :goto_a

    .line 322
    :cond_22
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_a

    .line 325
    :cond_23
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_24

    .line 326
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->width:F

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_24

    .line 327
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_1c

    .line 328
    const/4 v9, 0x0

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_a

    .line 330
    :cond_24
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_25

    .line 331
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_1c

    .line 332
    const/4 v9, 0x0

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_a

    .line 334
    :cond_25
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->width:F

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_1c

    .line 335
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_1c

    .line 336
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_a

    .line 343
    :cond_26
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_27

    .line 344
    const/4 v9, 0x1

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_b

    .line 346
    :cond_27
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_1d

    .line 347
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->height:F

    cmpg-float v9, v9, v10

    if-gez v9, :cond_1d

    .line 348
    const/4 v9, 0x1

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_b

    .line 361
    :cond_28
    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getX(I)F

    move-result v10

    float-to-int v10, v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    sub-int/2addr v10, v11

    aput v10, v2, v9

    goto/16 :goto_c

    .line 365
    :cond_29
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_c

    .line 367
    :cond_2a
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_2b

    const/4 v9, 0x0

    .line 368
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->width:F

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_2b

    .line 369
    const/4 v9, 0x0

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_c

    .line 370
    :cond_2b
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_2c

    .line 371
    const/4 v9, 0x0

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_c

    .line 372
    :cond_2c
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->width:F

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_1e

    .line 373
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_c

    .line 379
    :cond_2d
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_2e

    .line 380
    const/4 v9, 0x1

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_d

    .line 381
    :cond_2e
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_1f

    const/4 v9, 0x0

    .line 382
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->height:F

    cmpg-float v9, v9, v10

    if-gez v9, :cond_1f

    .line 383
    const/4 v9, 0x1

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_d

    .line 392
    :cond_2f
    const/4 v9, 0x2

    if-ne v5, v9, :cond_20

    .line 393
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_31

    .line 394
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_36

    const/4 v9, 0x0

    .line 395
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_36

    .line 396
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_35

    .line 397
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    const/high16 v11, 0x40c00000    # 6.0f

    iget v12, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v11, v12

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_34

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    const/high16 v11, 0x40c00000    # 6.0f

    iget v12, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v11, v12

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_34

    .line 398
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    .line 418
    :cond_30
    :goto_f
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_39

    const/4 v9, 0x0

    .line 419
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_39

    .line 420
    const/4 v9, 0x1

    const/4 v10, 0x0

    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getY(I)F

    move-result v10

    float-to-int v10, v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    sub-int/2addr v10, v11

    aput v10, v2, v9

    .line 428
    :cond_31
    :goto_10
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_33

    .line 430
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_3d

    const/4 v9, 0x1

    .line 431
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_3d

    .line 432
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_3c

    .line 433
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    const/high16 v11, 0x40c00000    # 6.0f

    iget v12, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v11, v12

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_3b

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    const/high16 v11, 0x40c00000    # 6.0f

    iget v12, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v11, v12

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_3b

    .line 434
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    .line 454
    :cond_32
    :goto_11
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_40

    const/4 v9, 0x1

    .line 455
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_40

    .line 456
    const/4 v9, 0x1

    const/4 v10, 0x1

    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getY(I)F

    move-result v10

    float-to-int v10, v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    sub-int/2addr v10, v11

    aput v10, v2, v9

    .line 465
    :cond_33
    :goto_12
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v9, v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    goto/16 :goto_e

    .line 400
    :cond_34
    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getX(I)F

    move-result v10

    float-to-int v10, v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    sub-int/2addr v10, v11

    aput v10, v2, v9

    goto/16 :goto_f

    .line 404
    :cond_35
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_f

    .line 406
    :cond_36
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_37

    const/4 v9, 0x0

    .line 407
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->width:F

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_37

    .line 408
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_30

    .line 409
    const/4 v9, 0x0

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_f

    .line 410
    :cond_37
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_38

    .line 411
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_30

    .line 412
    const/4 v9, 0x0

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_f

    .line 413
    :cond_38
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->width:F

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_30

    .line 414
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_30

    .line 415
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_f

    .line 421
    :cond_39
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_3a

    .line 422
    const/4 v9, 0x1

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_10

    .line 423
    :cond_3a
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_31

    const/4 v9, 0x0

    .line 424
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->height:F

    cmpg-float v9, v9, v10

    if-gez v9, :cond_31

    .line 425
    const/4 v9, 0x1

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_10

    .line 436
    :cond_3b
    const/4 v9, 0x0

    const/4 v10, 0x1

    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getX(I)F

    move-result v10

    float-to-int v10, v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    sub-int/2addr v10, v11

    aput v10, v2, v9

    goto/16 :goto_11

    .line 440
    :cond_3c
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_11

    .line 442
    :cond_3d
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_3e

    const/4 v9, 0x1

    .line 443
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->width:F

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_3e

    .line 444
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_32

    .line 445
    const/4 v9, 0x0

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_11

    .line 446
    :cond_3e
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_3f

    .line 447
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_32

    .line 448
    const/4 v9, 0x0

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_11

    .line 449
    :cond_3f
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->width:F

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_32

    .line 450
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-nez v9, :cond_32

    .line 451
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_11

    .line 457
    :cond_40
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_41

    .line 458
    const/4 v9, 0x1

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_12

    .line 459
    :cond_41
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_33

    const/4 v9, 0x1

    .line 460
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->height:F

    cmpg-float v9, v9, v10

    if-gez v9, :cond_33

    .line 461
    const/4 v9, 0x1

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v2, v9

    goto/16 :goto_12

    .line 473
    .end local v2    # "left":[I
    .end local v7    # "right":[I
    :sswitch_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_51

    .line 474
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_51

    .line 475
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_51

    .line 476
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42480000    # 50.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_51

    .line 477
    const-string v9, "Joystick_view"

    const-string v10, "unlock left throttle"

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 479
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v9

    const/4 v10, 0x7

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_42

    .line 480
    const/high16 v9, 0x42340000    # 45.0f

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v9, v10

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v10}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v10

    invoke-virtual {v10}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v10

    int-to-float v10, v10

    sub-float v6, v9, v10

    .line 481
    .restart local v6    # "position":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42480000    # 50.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_42

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    cmpl-float v9, v9, v6

    if-ltz v9, :cond_42

    .line 482
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x4

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 486
    .end local v6    # "position":F
    :cond_42
    const/4 v9, 0x2

    new-array v0, v9, [I

    const/4 v9, 0x0

    .line 487
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v0, v9

    const/4 v9, 0x1

    .line 488
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v0, v9

    .line 490
    .restart local v0    # "down_left":[I
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x1

    aput-boolean v11, v9, v10

    .line 491
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x1

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    .line 492
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_43

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42480000    # 50.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_43

    .line 493
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41400000    # 12.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_50

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41b80000    # 23.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_50

    .line 494
    const/4 v9, 0x0

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v0, v9

    .line 502
    :cond_43
    :goto_13
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x1

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_44

    .line 503
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v9, v0}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 514
    .end local v0    # "down_left":[I
    :cond_44
    :goto_14
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_45

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_45

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42400000    # 48.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_45

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42540000    # 53.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_45

    .line 515
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-eqz v9, :cond_52

    .line 516
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    .line 521
    :goto_15
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 522
    const-string v9, "Joystick_view"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "locked : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 526
    :cond_45
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x40000000    # 2.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_46

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41100000    # 9.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_46

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40000000    # 2.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-lez v9, :cond_46

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41400000    # 12.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_46

    .line 527
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mHandler:Landroid/os/Handler;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v9

    invoke-virtual {v9}, Landroid/os/Message;->sendToTarget()V

    .line 528
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 532
    :cond_46
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_47

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41000000    # 8.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_47

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_47

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_47

    .line 533
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 534
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x2

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    sub-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 537
    :cond_47
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41e00000    # 28.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_48

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_48

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_48

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_48

    .line 538
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 539
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x2

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 542
    :cond_48
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_49

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_49

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41f00000    # 30.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_49

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x420c0000    # 35.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_49

    .line 543
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 544
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x1

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 547
    :cond_49
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4a

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4a

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4a

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4a

    .line 548
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 549
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x1

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    sub-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 552
    :cond_4a
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42640000    # 57.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4b

    .line 553
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 554
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x0

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    sub-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 557
    :cond_4b
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x429a0000    # 77.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4c

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42a40000    # 82.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4c

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4c

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4c

    .line 558
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 559
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x0

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 562
    :cond_4c
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41600000    # 14.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4d

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41980000    # 19.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4d

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40a00000    # 5.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4d

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41200000    # 10.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4d

    .line 563
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 564
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x4

    aget v9, v9, v10

    const/16 v10, 0x7d0

    if-ne v9, v10, :cond_53

    .line 565
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 572
    :cond_4d
    :goto_16
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41b00000    # 22.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4e

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41d80000    # 27.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4e

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40a00000    # 5.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4e

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41200000    # 10.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4e

    .line 573
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 575
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x5

    aget v9, v9, v10

    const/16 v10, 0x7d0

    if-ne v9, v10, :cond_54

    .line 576
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x2

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 584
    :cond_4e
    :goto_17
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x41e80000    # 29.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4f

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42080000    # 34.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4f

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40a00000    # 5.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_4f

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41200000    # 10.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_4f

    .line 585
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 586
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x6

    aget v9, v9, v10

    const/16 v10, 0x7d0

    if-ne v9, v10, :cond_55

    .line 587
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x3

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 594
    :cond_4f
    :goto_18
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_57

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_57

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_57

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41000000    # 8.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_57

    .line 595
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v9

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-nez v9, :cond_58

    .line 596
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 597
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setACCCalibration(Z)V

    .line 599
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x5dc

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 600
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 601
    const/4 v1, 0x1

    .restart local v1    # "i":I
    :goto_19
    const/4 v9, 0x5

    if-ge v1, v9, :cond_56

    .line 602
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x3e8

    invoke-virtual {v9, v1, v10}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 601
    add-int/lit8 v1, v1, 0x1

    goto :goto_19

    .line 497
    .end local v1    # "i":I
    .restart local v0    # "down_left":[I
    :cond_50
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    .line 498
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x1

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    goto/16 :goto_13

    .line 507
    .end local v0    # "down_left":[I
    :cond_51
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_44

    const/4 v9, 0x0

    .line 508
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42a40000    # 82.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_44

    const/4 v9, 0x0

    .line 509
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_44

    const/4 v9, 0x0

    .line 510
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_44

    .line 511
    const/4 v9, 0x1

    iput-boolean v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->isSensorActivation:Z

    goto/16 :goto_14

    .line 519
    :cond_52
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    goto/16 :goto_15

    .line 567
    :cond_53
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x4

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_4d

    .line 568
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_16

    .line 578
    :cond_54
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x5

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_4e

    .line 579
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x2

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_17

    .line 589
    :cond_55
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x6

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_4f

    .line 590
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x3

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_18

    .line 604
    .restart local v1    # "i":I
    :cond_56
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v10, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$3;

    invoke-direct {v10, p0}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$3;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;)V

    const-wide/16 v12, 0x1f4

    invoke-virtual {v9, v10, v12, v13}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 616
    .end local v1    # "i":I
    :cond_57
    :goto_1a
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x423c0000    # 47.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    const/high16 v10, 0x41000000    # 8.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_1

    .line 617
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v9

    const/4 v10, 0x1

    aget-boolean v9, v9, v10

    if-nez v9, :cond_5a

    .line 618
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 619
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setMAGCalibration(Z)V

    .line 621
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x5dc

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 622
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 623
    const/4 v1, 0x1

    .restart local v1    # "i":I
    :goto_1b
    const/4 v9, 0x5

    if-ge v1, v9, :cond_59

    .line 624
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x3e8

    invoke-virtual {v9, v1, v10}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 623
    add-int/lit8 v1, v1, 0x1

    goto :goto_1b

    .line 612
    .end local v1    # "i":I
    :cond_58
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mContext:Landroid/content/Context;

    const-string v10, "\uad50\uc815 \uc911..."

    const/4 v11, 0x0

    invoke-static {v9, v10, v11}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v9

    invoke-virtual {v9}, Landroid/widget/Toast;->show()V

    goto :goto_1a

    .line 625
    .restart local v1    # "i":I
    :cond_59
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v10, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$4;

    invoke-direct {v10, p0}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$4;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;)V

    const-wide/16 v12, 0x1f4

    invoke-virtual {v9, v10, v12, v13}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 634
    .end local v1    # "i":I
    :cond_5a
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mContext:Landroid/content/Context;

    const-string v10, "\uad50\uc815 \uc911..."

    const/4 v11, 0x0

    invoke-static {v9, v10, v11}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v9

    invoke-virtual {v9}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 641
    :sswitch_3
    const-string v9, "Joystick_view"

    const-string v10, "pointer2 down"

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 643
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_69

    const/4 v9, 0x1

    .line 644
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_69

    const/4 v9, 0x1

    .line 645
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_69

    const/4 v9, 0x1

    .line 646
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42480000    # 50.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_69

    .line 647
    const-string v9, "Joystick_view"

    const-string v10, "unlock left throttle"

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 649
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v9

    const/4 v10, 0x7

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_5b

    .line 650
    const/high16 v9, 0x42340000    # 45.0f

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v9, v10

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v10}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v10

    invoke-virtual {v10}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v10

    int-to-float v10, v10

    sub-float v6, v9, v10

    .line 651
    .restart local v6    # "position":F
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42480000    # 50.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_5b

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    cmpl-float v9, v9, v6

    if-ltz v9, :cond_5b

    .line 652
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x4

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 656
    .end local v6    # "position":F
    :cond_5b
    const/4 v9, 0x2

    new-array v4, v9, [I

    const/4 v9, 0x0

    const/4 v10, 0x1

    .line 657
    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getX(I)F

    move-result v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v4, v9

    const/4 v9, 0x1

    const/4 v10, 0x1

    .line 658
    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getY(I)F

    move-result v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v4, v9

    .line 660
    .local v4, "pointer2_down_left":[I
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x1

    aput-boolean v11, v9, v10

    .line 661
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x1

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    .line 662
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_5c

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42480000    # 50.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_5c

    .line 663
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x41400000    # 12.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_68

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x41b80000    # 23.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_68

    .line 664
    const/4 v9, 0x0

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v4, v9

    .line 672
    :cond_5c
    :goto_1c
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_5d

    .line 673
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v9, v4}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 684
    .end local v4    # "pointer2_down_left":[I
    :cond_5d
    :goto_1d
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_5e

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_5e

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42400000    # 48.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_5e

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42540000    # 53.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_5e

    .line 685
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v9

    if-eqz v9, :cond_6a

    .line 686
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    .line 691
    :goto_1e
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 692
    const-string v9, "Joystick_view"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "locked : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 696
    :cond_5e
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_5f

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x41000000    # 8.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_5f

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_5f

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_5f

    .line 697
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 698
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x2

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    sub-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 701
    :cond_5f
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x41e00000    # 28.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_60

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42040000    # 33.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_60

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_60

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_60

    .line 702
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 703
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x2

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setYawTream(I)V

    .line 706
    :cond_60
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_61

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_61

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41f00000    # 30.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_61

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x420c0000    # 35.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_61

    .line 707
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 708
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x1

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 711
    :cond_61
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_62

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_62

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_62

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_62

    .line 712
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 713
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x1

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    sub-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setPitchTream(I)V

    .line 716
    :cond_62
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_63

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42640000    # 57.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_63

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_63

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_63

    .line 717
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 718
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x0

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    sub-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 721
    :cond_63
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x429a0000    # 77.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_64

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42a40000    # 82.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_64

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42380000    # 46.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_64

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x424c0000    # 51.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_64

    .line 722
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 723
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v10

    const/4 v11, 0x0

    aget v10, v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v11}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setRollTream(I)V

    .line 726
    :cond_64
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x41600000    # 14.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_65

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x41980000    # 19.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_65

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x40a00000    # 5.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_65

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41200000    # 10.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_65

    .line 727
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 728
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x4

    aget v9, v9, v10

    const/16 v10, 0x7d0

    if-ne v9, v10, :cond_6b

    .line 729
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 736
    :cond_65
    :goto_1f
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x41b00000    # 22.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_66

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x41d80000    # 27.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_66

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x40a00000    # 5.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_66

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41200000    # 10.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_66

    .line 737
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 739
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x5

    aget v9, v9, v10

    const/16 v10, 0x7d0

    if-ne v9, v10, :cond_6c

    .line 740
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x2

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 751
    :cond_66
    :goto_20
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x41e80000    # 29.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_67

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42080000    # 34.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_67

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x40a00000    # 5.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_67

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41200000    # 10.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_67

    .line 752
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 753
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x6

    aget v9, v9, v10

    const/16 v10, 0x7d0

    if-ne v9, v10, :cond_6d

    .line 754
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x3

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 761
    :cond_67
    :goto_21
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42200000    # 40.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_6f

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_6f

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_6f

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41000000    # 8.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_6f

    .line 762
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v9

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-nez v9, :cond_70

    .line 763
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 764
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setACCCalibration(Z)V

    .line 766
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x5dc

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 767
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 768
    const/4 v1, 0x1

    .restart local v1    # "i":I
    :goto_22
    const/4 v9, 0x5

    if-ge v1, v9, :cond_6e

    .line 769
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x3e8

    invoke-virtual {v9, v1, v10}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 768
    add-int/lit8 v1, v1, 0x1

    goto :goto_22

    .line 667
    .end local v1    # "i":I
    .restart local v4    # "pointer2_down_left":[I
    :cond_68
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    .line 668
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x1

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    goto/16 :goto_1c

    .line 677
    .end local v4    # "pointer2_down_left":[I
    :cond_69
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_5d

    const/4 v9, 0x1

    .line 678
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42a40000    # 82.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_5d

    const/4 v9, 0x1

    .line 679
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_5d

    const/4 v9, 0x1

    .line 680
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_5d

    .line 681
    const/4 v9, 0x1

    iput-boolean v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->isSensorActivation:Z

    goto/16 :goto_1d

    .line 689
    :cond_6a
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setLocked(Z)V

    goto/16 :goto_1e

    .line 731
    :cond_6b
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x4

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_65

    .line 732
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_1f

    .line 742
    :cond_6c
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x5

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_66

    .line 743
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x2

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_20

    .line 756
    :cond_6d
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v9

    const/4 v10, 0x6

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_67

    .line 757
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x3

    const/16 v11, 0x7d0

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_21

    .line 771
    .restart local v1    # "i":I
    :cond_6e
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v10, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$5;

    invoke-direct {v10, p0}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$5;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;)V

    const-wide/16 v12, 0x1f4

    invoke-virtual {v9, v10, v12, v13}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 783
    .end local v1    # "i":I
    :cond_6f
    :goto_23
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x423c0000    # 47.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_1

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_1

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x40400000    # 3.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_1

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41000000    # 8.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_1

    .line 784
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v9

    const/4 v10, 0x1

    aget-boolean v9, v9, v10

    if-nez v9, :cond_72

    .line 785
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 786
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/MultiData;->setMAGCalibration(Z)V

    .line 788
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x5dc

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    .line 789
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x5dc

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataYawThrottle(II)V

    .line 790
    const/4 v1, 0x1

    .restart local v1    # "i":I
    :goto_24
    const/4 v9, 0x5

    if-ge v1, v9, :cond_71

    .line 791
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v10, 0x3e8

    invoke-virtual {v9, v1, v10}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 790
    add-int/lit8 v1, v1, 0x1

    goto :goto_24

    .line 779
    .end local v1    # "i":I
    :cond_70
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mContext:Landroid/content/Context;

    const-string v10, "\uad50\uc815 \uc911..."

    const/4 v11, 0x0

    invoke-static {v9, v10, v11}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v9

    invoke-virtual {v9}, Landroid/widget/Toast;->show()V

    goto :goto_23

    .line 792
    .restart local v1    # "i":I
    :cond_71
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mHandler:Landroid/os/Handler;

    new-instance v10, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$6;

    invoke-direct {v10, p0}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$6;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;)V

    const-wide/16 v12, 0x1f4

    invoke-virtual {v9, v10, v12, v13}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 801
    .end local v1    # "i":I
    :cond_72
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mContext:Landroid/content/Context;

    const-string v10, "\uad50\uc815 \uc911..."

    const/4 v11, 0x0

    invoke-static {v9, v10, v11}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v9

    invoke-virtual {v9}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 809
    :sswitch_4
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_76

    .line 810
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->width:F

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_74

    .line 811
    const/4 v9, 0x2

    new-array v3, v9, [I

    .line 812
    .local v3, "left_temp":[I
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v9

    const/4 v10, 0x6

    aget v9, v9, v10

    const/16 v10, 0x7d0

    if-ne v9, v10, :cond_75

    .line 813
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v3, v9

    .line 814
    const/4 v9, 0x1

    const/high16 v10, 0x41f00000    # 30.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v3, v9

    .line 820
    :cond_73
    :goto_25
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v9, v3}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 821
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    .line 823
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v9

    const/4 v10, 0x3

    aget v9, v9, v10

    const/16 v10, 0x41a

    if-gt v9, v10, :cond_74

    .line 824
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x4

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 836
    .end local v3    # "left_temp":[I
    :cond_74
    :goto_26
    const-string v9, "Joystick_view"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "pointer1 count : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 816
    .restart local v3    # "left_temp":[I
    :cond_75
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v9

    const/4 v10, 0x6

    aget v9, v9, v10

    const/16 v10, 0x3e8

    if-ne v9, v10, :cond_73

    .line 817
    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v3, v9

    .line 818
    const/4 v9, 0x1

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v10}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v10

    const/4 v11, 0x1

    aget v10, v10, v11

    aput v10, v3, v9

    goto :goto_25

    .line 828
    .end local v3    # "left_temp":[I
    :cond_76
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x1

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_74

    .line 829
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_74

    const/4 v9, 0x0

    .line 830
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42a40000    # 82.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_74

    const/4 v9, 0x0

    .line 831
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_74

    const/4 v9, 0x0

    .line 832
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_74

    .line 833
    const/4 v9, 0x0

    iput-boolean v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->isSensorActivation:Z

    goto/16 :goto_26

    .line 840
    :sswitch_5
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->width:F

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_79

    .line 841
    const/4 v9, 0x2

    new-array v3, v9, [I

    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v3, v9

    const/4 v9, 0x1

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v10}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v10

    const/4 v11, 0x1

    aget v10, v10, v11

    aput v10, v3, v9

    .line 842
    .restart local v3    # "left_temp":[I
    const/4 v9, 0x2

    new-array v8, v9, [I

    const/4 v9, 0x0

    const/high16 v10, 0x42860000    # 67.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v8, v9

    const/4 v9, 0x1

    const/high16 v10, 0x41f00000    # 30.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v8, v9

    .line 843
    .local v8, "right_temp":[I
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v9, v3}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 844
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_77

    .line 845
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    .line 848
    :cond_77
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v9

    const/4 v10, 0x3

    aget v9, v9, v10

    const/16 v10, 0x41a

    if-gt v9, v10, :cond_78

    .line 849
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x4

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 858
    .end local v3    # "left_temp":[I
    .end local v8    # "right_temp":[I
    :cond_78
    :goto_27
    const-string v9, "Joystick_view"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "pointer2 count : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 852
    :cond_79
    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_78

    const/4 v9, 0x1

    .line 853
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42a40000    # 82.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_78

    const/4 v9, 0x1

    .line 854
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_78

    const/4 v9, 0x1

    .line 855
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_78

    .line 856
    const/4 v9, 0x0

    iput-boolean v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->isSensorActivation:Z

    goto/16 :goto_27

    .line 862
    :sswitch_6
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->width:F

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gez v9, :cond_7c

    .line 863
    const/4 v9, 0x2

    new-array v3, v9, [I

    const/4 v9, 0x0

    const/high16 v10, 0x41900000    # 18.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v3, v9

    const/4 v9, 0x1

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v10}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v10

    const/4 v11, 0x1

    aget v10, v10, v11

    aput v10, v3, v9

    .line 864
    .restart local v3    # "left_temp":[I
    const/4 v9, 0x2

    new-array v8, v9, [I

    const/4 v9, 0x0

    const/high16 v10, 0x42860000    # 67.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v8, v9

    const/4 v9, 0x1

    const/high16 v10, 0x41f00000    # 30.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    float-to-int v10, v10

    aput v10, v8, v9

    .line 865
    .restart local v8    # "right_temp":[I
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v9, v3}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setLeft([I)V

    .line 866
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_7a

    .line 867
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    .line 869
    :cond_7a
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-boolean v9, v9, v10

    if-eqz v9, :cond_7b

    .line 870
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->unlock_throttle:[[Z

    const/4 v10, 0x1

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x0

    aput-boolean v11, v9, v10

    .line 873
    :cond_7b
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v9}, Lcom/drms/drms_drone/MultiData;->getRcdata()[I

    move-result-object v9

    const/4 v10, 0x3

    aget v9, v9, v10

    const/16 v10, 0x41a

    if-gt v9, v10, :cond_1

    .line 874
    iget-object v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v10, 0x4

    const/16 v11, 0x3e8

    invoke-virtual {v9, v10, v11}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    goto/16 :goto_0

    .line 877
    .end local v3    # "left_temp":[I
    .end local v8    # "right_temp":[I
    :cond_7c
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42500000    # 52.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_1

    const/4 v9, 0x0

    .line 878
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    const/high16 v10, 0x42a40000    # 82.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->x:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_1

    const/4 v9, 0x0

    .line 879
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x41700000    # 15.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    add-float/2addr v10, v11

    cmpl-float v9, v9, v10

    if-ltz v9, :cond_1

    const/4 v9, 0x0

    .line 880
    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    const/high16 v10, 0x42340000    # 45.0f

    iget v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->y:F

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v11

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    cmpg-float v9, v9, v10

    if-gtz v9, :cond_1

    .line 881
    const/4 v9, 0x0

    iput-boolean v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->isSensorActivation:Z

    goto/16 :goto_0

    .line 127
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
