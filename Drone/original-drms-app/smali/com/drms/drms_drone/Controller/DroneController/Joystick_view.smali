.class public Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
.super Landroid/view/View;
.source "Joystick_view.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$SensorListener;,
        Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;
    }
.end annotation


# static fields
.field protected static final TAG:Ljava/lang/String; = "Joystick_view"


# instance fields
.field protected backBitmap:Landroid/graphics/Bitmap;

.field protected droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

.field protected height:F

.field protected init_time:J

.field private isArmed:Z

.field protected mActivity:Landroid/app/Activity;

.field protected mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

.field protected mContext:Landroid/content/Context;

.field protected mHandler:Landroid/os/Handler;

.field protected mSensorEventListener:Landroid/hardware/SensorEventListener;

.field protected mSensorManager:Landroid/hardware/SensorManager;

.field protected mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

.field protected minute:I

.field protected mspdata:Lcom/drms/drms_drone/MultiData;

.field protected seconds:I

.field protected timer:J

.field protected final unitHeight:I

.field protected final unitWidth:I

.field protected unlock_throttle:[[Z

.field protected unlocked_left_throttle:Z

.field protected unlocked_right_throttle:Z

.field protected width:F

.field protected x:F

.field protected y:F


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;Landroid/os/Handler;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mActivity"    # Landroid/app/Activity;
    .param p3, "mHandler"    # Landroid/os/Handler;

    .prologue
    const-wide/16 v4, 0x0

    const/4 v3, 0x2

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 61
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 41
    iput v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->width:F

    .line 42
    const/16 v0, 0x55

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->unitWidth:I

    .line 43
    iput v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->height:F

    .line 44
    const/16 v0, 0x3c

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->unitHeight:I

    .line 48
    iput-wide v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->timer:J

    .line 49
    iput-wide v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->init_time:J

    .line 50
    iput v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->minute:I

    .line 51
    const/4 v0, 0x1

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->seconds:I

    .line 53
    iput-boolean v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->unlocked_left_throttle:Z

    .line 54
    iput-boolean v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->unlocked_right_throttle:Z

    .line 55
    filled-new-array {v3, v3}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[Z

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->unlock_throttle:[[Z

    .line 285
    iput-boolean v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->isArmed:Z

    .line 62
    iput-object p2, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mActivity:Landroid/app/Activity;

    .line 63
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    .line 64
    invoke-virtual {p2}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 66
    iput-object p3, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mHandler:Landroid/os/Handler;

    .line 67
    new-instance v0, Lcom/drms/drms_drone/Sound/SoundManager;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 68
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    iput-wide v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->init_time:J

    .line 70
    return-void
.end method


# virtual methods
.method protected drawBackground(FIFI)Landroid/graphics/Bitmap;
    .locals 25
    .param p1, "width"    # F
    .param p2, "unitW"    # I
    .param p3, "height"    # F
    .param p4, "unitH"    # I

    .prologue
    .line 122
    const/16 v2, 0xa

    new-array v11, v2, [Landroid/graphics/Paint;

    .line 124
    .local v11, "backPaint":[Landroid/graphics/Paint;
    const/4 v2, 0x0

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v11, v2

    .line 125
    const/4 v2, 0x0

    aget-object v2, v11, v2

    const/16 v3, 0x14

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 126
    const/4 v2, 0x0

    aget-object v2, v11, v2

    const/high16 v3, 0x40400000    # 3.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 127
    const/4 v2, 0x0

    aget-object v2, v11, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0028

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 128
    const/4 v2, 0x0

    aget-object v2, v11, v2

    const/16 v3, 0x82

    const/16 v4, 0xa7

    const/16 v5, 0xa7

    const/16 v23, 0xa7

    move/from16 v0, v23

    invoke-virtual {v2, v3, v4, v5, v0}, Landroid/graphics/Paint;->setARGB(IIII)V

    .line 129
    const/4 v2, 0x0

    aget-object v2, v11, v2

    sget-object v3, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 131
    move/from16 v0, p1

    float-to-int v2, v0

    move/from16 v0, p3

    float-to-int v3, v0

    sget-object v4, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v2, v3, v4}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v19

    .line 132
    .local v19, "tempBitmap":Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    move-object/from16 v0, v19

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 138
    .local v1, "canvas":Landroid/graphics/Canvas;
    const/high16 v2, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42040000    # 33.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x0

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 139
    const/high16 v2, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41700000    # 15.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42a40000    # 82.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x0

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 142
    const/4 v2, 0x1

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v11, v2

    .line 143
    const/4 v2, 0x1

    aget-object v2, v11, v2

    const/high16 v3, 0x40e00000    # 7.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 144
    const/4 v2, 0x1

    aget-object v2, v11, v2

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 146
    const/4 v2, 0x2

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v11, v2

    .line 147
    const/4 v2, 0x2

    aget-object v2, v11, v2

    const/high16 v3, 0x40a00000    # 5.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 148
    const/4 v2, 0x2

    aget-object v2, v11, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0029

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 150
    const/high16 v2, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42140000    # 37.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 151
    const/high16 v2, 0x42400000    # 48.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 152
    const/high16 v2, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42140000    # 37.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 153
    const/high16 v2, 0x42400000    # 48.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 154
    const/high16 v2, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    sub-float/2addr v3, v4

    const/high16 v4, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/4 v5, 0x1

    aget-object v5, v11, v5

    invoke-virtual {v5}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v5

    const/high16 v23, 0x40000000    # 2.0f

    div-float v5, v5, v23

    add-float/2addr v4, v5

    const/high16 v5, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v23, v11, v23

    invoke-virtual/range {v23 .. v23}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v23

    const/high16 v24, 0x40000000    # 2.0f

    div-float v23, v23, v24

    add-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 155
    const/high16 v2, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    sub-float/2addr v3, v4

    const/high16 v4, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/4 v5, 0x1

    aget-object v5, v11, v5

    invoke-virtual {v5}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v5

    const/high16 v23, 0x40000000    # 2.0f

    div-float v5, v5, v23

    add-float/2addr v4, v5

    const/high16 v5, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v23, v11, v23

    invoke-virtual/range {v23 .. v23}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v23

    const/high16 v24, 0x40000000    # 2.0f

    div-float v23, v23, v24

    add-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 156
    const/high16 v2, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x2

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 157
    const/high16 v2, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41a00000    # 20.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41a00000    # 20.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x2

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 158
    const/high16 v2, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x2

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 160
    const/4 v2, 0x2

    aget-object v2, v11, v2

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 161
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_0
    const/4 v2, 0x6

    if-ge v12, v2, :cond_0

    .line 162
    const/high16 v2, 0x42280000    # 42.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    add-int/lit8 v3, v12, 0xe

    int-to-float v3, v3

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x422c0000    # 43.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    add-int/lit8 v5, v12, 0xe

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x2

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 161
    add-int/lit8 v12, v12, 0x1

    goto :goto_0

    .line 163
    :cond_0
    const/4 v12, 0x0

    :goto_1
    const/4 v2, 0x6

    if-ge v12, v2, :cond_1

    .line 164
    const/high16 v2, 0x42280000    # 42.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    add-int/lit8 v3, v12, 0x15

    int-to-float v3, v3

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x422c0000    # 43.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    add-int/lit8 v5, v12, 0x15

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x2

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 163
    add-int/lit8 v12, v12, 0x1

    goto :goto_1

    .line 166
    :cond_1
    const/4 v2, 0x2

    aget-object v2, v11, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c005a

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 167
    const/4 v2, 0x2

    aget-object v2, v11, v2

    const/high16 v3, 0x41200000    # 10.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 171
    new-instance v17, Landroid/graphics/BitmapFactory$Options;

    invoke-direct/range {v17 .. v17}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 172
    .local v17, "option":Landroid/graphics/BitmapFactory$Options;
    const/4 v2, 0x2

    move-object/from16 v0, v17

    iput v2, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 173
    const/4 v2, 0x4

    new-array v7, v2, [Landroid/graphics/Bitmap;

    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    .line 174
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f030021

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v7, v2

    const/4 v2, 0x1

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    .line 175
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f03001c

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v7, v2

    const/4 v2, 0x2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    .line 176
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f03001d

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v7, v2

    const/4 v2, 0x3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    .line 177
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f03001f

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v7, v2

    .line 179
    .local v7, "arrowIcon":[Landroid/graphics/Bitmap;
    const/4 v2, 0x4

    new-array v10, v2, [Landroid/graphics/Bitmap;

    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    .line 180
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f030035

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v10, v2

    const/4 v2, 0x1

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    .line 181
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f030010

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v10, v2

    const/4 v2, 0x2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    .line 182
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f030017

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v10, v2

    const/4 v2, 0x3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    .line 183
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f03002c

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v10, v2

    .line 186
    .local v10, "arrowIcon_on":[Landroid/graphics/Bitmap;
    const/4 v2, 0x4

    new-array v8, v2, [Landroid/graphics/Bitmap;

    .line 187
    .local v8, "arrowIconTemp":[Landroid/graphics/Bitmap;
    const/4 v2, 0x4

    new-array v9, v2, [Landroid/graphics/Bitmap;

    .line 189
    .local v9, "arrowIconTemp_on":[Landroid/graphics/Bitmap;
    const/4 v12, 0x0

    :goto_2
    const/4 v2, 0x4

    if-ge v12, v2, :cond_2

    .line 190
    aget-object v2, v7, v12

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    aput-object v2, v8, v12

    .line 189
    add-int/lit8 v12, v12, 0x1

    goto :goto_2

    .line 192
    :cond_2
    const/4 v12, 0x0

    :goto_3
    const/4 v2, 0x4

    if-ge v12, v2, :cond_3

    .line 193
    aget-object v2, v7, v12

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    aput-object v2, v9, v12

    .line 192
    add-int/lit8 v12, v12, 0x1

    goto :goto_3

    .line 202
    :cond_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x0

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_4

    .line 203
    const/4 v2, 0x2

    aget-object v2, v9, v2

    const/high16 v3, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 209
    :goto_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x1

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_5

    .line 210
    const/4 v2, 0x3

    aget-object v2, v9, v2

    const/high16 v3, 0x429a0000    # 77.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 216
    :goto_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x2

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_6

    .line 217
    const/4 v2, 0x1

    aget-object v2, v9, v2

    const/high16 v3, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 223
    :goto_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x3

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_7

    .line 224
    const/4 v2, 0x0

    aget-object v2, v9, v2

    const/high16 v3, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 230
    :goto_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x4

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_8

    .line 231
    const/4 v2, 0x2

    aget-object v2, v9, v2

    const/high16 v3, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 237
    :goto_8
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x5

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_9

    .line 238
    const/4 v2, 0x3

    aget-object v2, v9, v2

    const/high16 v3, 0x41e00000    # 28.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 246
    :goto_9
    const/high16 v2, 0x40e00000    # 7.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    sget-object v4, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v2, v3, v4}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v14

    .line 247
    .local v14, "menuIcon":Landroid/graphics/Bitmap;
    new-instance v18, Landroid/graphics/Canvas;

    move-object/from16 v0, v18

    invoke-direct {v0, v14}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 248
    .local v18, "temp":Landroid/graphics/Canvas;
    new-instance v6, Landroid/graphics/Paint;

    invoke-direct {v6}, Landroid/graphics/Paint;-><init>()V

    .line 249
    .local v6, "menuIconPaint":Landroid/graphics/Paint;
    const/high16 v2, 0x40a00000    # 5.0f

    invoke-virtual {v6, v2}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 250
    const/high16 v2, -0x1000000

    invoke-virtual {v6, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 251
    const/4 v12, 0x0

    :goto_a
    const/4 v2, 0x3

    if-ge v12, v2, :cond_a

    .line 252
    invoke-virtual/range {v18 .. v18}, Landroid/graphics/Canvas;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x5

    int-to-float v2, v2

    invoke-virtual/range {v18 .. v18}, Landroid/graphics/Canvas;->getHeight()I

    move-result v3

    add-int/lit8 v4, v12, 0x1

    mul-int/2addr v3, v4

    div-int/lit8 v3, v3, 0x4

    int-to-float v3, v3

    invoke-virtual/range {v18 .. v18}, Landroid/graphics/Canvas;->getWidth()I

    move-result v4

    mul-int/lit8 v4, v4, 0x4

    div-int/lit8 v4, v4, 0x5

    int-to-float v4, v4

    invoke-virtual/range {v18 .. v18}, Landroid/graphics/Canvas;->getHeight()I

    move-result v5

    add-int/lit8 v23, v12, 0x1

    mul-int v5, v5, v23

    div-int/lit8 v5, v5, 0x4

    int-to-float v5, v5

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 251
    add-int/lit8 v12, v12, 0x1

    goto :goto_a

    .line 206
    .end local v6    # "menuIconPaint":Landroid/graphics/Paint;
    .end local v14    # "menuIcon":Landroid/graphics/Bitmap;
    .end local v18    # "temp":Landroid/graphics/Canvas;
    :cond_4
    const/4 v2, 0x2

    aget-object v2, v8, v2

    const/high16 v3, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_4

    .line 213
    :cond_5
    const/4 v2, 0x3

    aget-object v2, v8, v2

    const/high16 v3, 0x429a0000    # 77.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_5

    .line 220
    :cond_6
    const/4 v2, 0x1

    aget-object v2, v8, v2

    const/high16 v3, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_6

    .line 227
    :cond_7
    const/4 v2, 0x0

    aget-object v2, v8, v2

    const/high16 v3, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_7

    .line 234
    :cond_8
    const/4 v2, 0x2

    aget-object v2, v8, v2

    const/high16 v3, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_8

    .line 241
    :cond_9
    const/4 v2, 0x3

    aget-object v2, v8, v2

    const/high16 v3, 0x41e00000    # 28.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_9

    .line 254
    .restart local v6    # "menuIconPaint":Landroid/graphics/Paint;
    .restart local v14    # "menuIcon":Landroid/graphics/Bitmap;
    .restart local v18    # "temp":Landroid/graphics/Canvas;
    :cond_a
    const/high16 v2, 0x40000000    # 2.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x40000000    # 2.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    invoke-virtual {v1, v14, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 257
    const/4 v2, 0x3

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v11, v2

    .line 258
    const/4 v2, 0x3

    aget-object v2, v11, v2

    const/16 v3, 0xff

    const/16 v4, 0xfa

    const/16 v5, 0xe0

    const/16 v23, 0xd4

    move/from16 v0, v23

    invoke-virtual {v2, v3, v4, v5, v0}, Landroid/graphics/Paint;->setARGB(IIII)V

    .line 259
    const/4 v2, 0x3

    aget-object v2, v11, v2

    const/high16 v3, 0x40a00000    # 5.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 260
    const/4 v2, 0x3

    aget-object v2, v11, v2

    sget-object v3, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 269
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030013

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v22

    .line 270
    .local v22, "vbatIcon":Landroid/graphics/Bitmap;
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    move-object/from16 v0, v22

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v13

    .line 271
    .local v13, "icon":Landroid/graphics/Bitmap;
    const/high16 v2, 0x42920000    # 73.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x42540000    # 53.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    invoke-virtual {v1, v13, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 273
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03001b

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v16

    .line 274
    .local v16, "mobileIcon":Landroid/graphics/Bitmap;
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    move-object/from16 v0, v16

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v15

    .line 275
    .local v15, "mobile":Landroid/graphics/Bitmap;
    const/high16 v2, 0x42700000    # 60.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x42540000    # 53.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    invoke-virtual {v1, v15, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 278
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020067

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v21

    .line 279
    .local v21, "timerback_temp":Landroid/graphics/Bitmap;
    const/high16 v2, 0x41a00000    # 20.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x41100000    # 9.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    move-object/from16 v0, v21

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v20

    .line 280
    .local v20, "timer_back":Landroid/graphics/Bitmap;
    const/high16 v2, 0x42640000    # 57.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    int-to-float v2, v2

    const/high16 v3, 0x40800000    # 4.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/4 v4, 0x0

    move-object/from16 v0, v20

    invoke-virtual {v1, v0, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 282
    return-object v19
.end method

.method protected drawController(Landroid/graphics/Canvas;)V
    .locals 42
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 291
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    move-object/from16 v0, p0

    iget-wide v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->init_time:J

    sub-long/2addr v2, v4

    move-object/from16 v0, p0

    iput-wide v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->timer:J

    .line 294
    move-object/from16 v0, p0

    iget-wide v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->timer:J

    const-wide/16 v4, 0x3c

    div-long/2addr v2, v4

    long-to-int v2, v2

    move-object/from16 v0, p0

    iput v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->minute:I

    .line 295
    move-object/from16 v0, p0

    iget-wide v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->timer:J

    const-wide/16 v4, 0x3c

    rem-long/2addr v2, v4

    long-to-int v2, v2

    move-object/from16 v0, p0

    iput v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->seconds:I

    .line 297
    const/16 v2, 0xa

    new-array v0, v2, [Landroid/graphics/Paint;

    move-object/from16 v17, v0

    .line 300
    .local v17, "contPaint":[Landroid/graphics/Paint;
    const/4 v2, 0x0

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 301
    const/4 v2, 0x0

    aget-object v2, v17, v2

    const/high16 v3, 0x41200000    # 10.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 302
    const/4 v2, 0x0

    aget-object v2, v17, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0053

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 304
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    neg-float v0, v2

    move/from16 v26, v0

    .line 305
    .local v26, "pitch":F
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v2

    const/4 v3, 0x0

    aget v30, v2, v3

    .line 307
    .local v30, "roll":F
    const/high16 v2, 0x42700000    # 60.0f

    cmpl-float v2, v26, v2

    if-lez v2, :cond_0

    const/high16 v26, 0x42700000    # 60.0f

    .line 308
    :cond_0
    const/high16 v2, -0x3d900000    # -60.0f

    cmpg-float v2, v26, v2

    if-gez v2, :cond_1

    const/high16 v26, -0x3d900000    # -60.0f

    .line 309
    :cond_1
    const/high16 v2, 0x42b40000    # 90.0f

    cmpl-float v2, v30, v2

    if-lez v2, :cond_2

    const/high16 v30, 0x42b40000    # 90.0f

    .line 310
    :cond_2
    const/high16 v2, -0x3d4c0000    # -90.0f

    cmpg-float v2, v30, v2

    if-gez v2, :cond_3

    const/high16 v30, -0x3d4c0000    # -90.0f

    .line 312
    :cond_3
    const/4 v2, 0x2

    new-array v0, v2, [F

    move-object/from16 v16, v0

    const/4 v2, 0x0

    const/high16 v3, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    add-float/2addr v3, v4

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    aput v3, v16, v2

    const/4 v2, 0x1

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    add-float/2addr v3, v4

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x42700000    # 60.0f

    div-float v5, v26, v5

    mul-float/2addr v4, v5

    add-float/2addr v3, v4

    aput v3, v16, v2

    .line 313
    .local v16, "center":[F
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float v29, v2, v3

    .line 315
    .local v29, "radius":F
    const/high16 v2, 0x42140000    # 37.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v2

    const/4 v2, 0x1

    aget v4, v16, v2

    const/high16 v2, 0x42400000    # 48.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v5, v2

    const/4 v2, 0x1

    aget v6, v16, v2

    const/4 v2, 0x0

    aget-object v7, v17, v2

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 317
    const/4 v2, 0x0

    aget-object v2, v17, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c002b

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 318
    const/4 v2, 0x1

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    add-float/2addr v3, v4

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    aput v3, v16, v2

    .line 320
    const/4 v2, 0x0

    aget v2, v16, v2

    float-to-double v2, v2

    move/from16 v0, v29

    float-to-double v4, v0

    move/from16 v0, v30

    float-to-double v6, v0

    const-wide v36, 0x400921fafc8b007aL    # 3.141592

    mul-double v6, v6, v36

    const-wide v36, 0x4066800000000000L    # 180.0

    div-double v6, v6, v36

    invoke-static {v6, v7}, Ljava/lang/Math;->cos(D)D

    move-result-wide v6

    mul-double/2addr v4, v6

    add-double/2addr v2, v4

    double-to-float v3, v2

    const/4 v2, 0x1

    aget v2, v16, v2

    float-to-double v4, v2

    move/from16 v0, v29

    float-to-double v6, v0

    move/from16 v0, v30

    float-to-double v0, v0

    move-wide/from16 v36, v0

    const-wide v38, 0x400921fafc8b007aL    # 3.141592

    mul-double v36, v36, v38

    const-wide v38, 0x4066800000000000L    # 180.0

    div-double v36, v36, v38

    .line 321
    invoke-static/range {v36 .. v37}, Ljava/lang/Math;->sin(D)D

    move-result-wide v36

    mul-double v6, v6, v36

    add-double/2addr v4, v6

    double-to-float v4, v4

    const/4 v2, 0x0

    aget v2, v16, v2

    float-to-double v6, v2

    move/from16 v0, v29

    float-to-double v0, v0

    move-wide/from16 v36, v0

    const/high16 v2, 0x43340000    # 180.0f

    add-float v2, v2, v30

    float-to-double v0, v2

    move-wide/from16 v38, v0

    const-wide v40, 0x400921fafc8b007aL    # 3.141592

    mul-double v38, v38, v40

    const-wide v40, 0x4066800000000000L    # 180.0

    div-double v38, v38, v40

    .line 322
    invoke-static/range {v38 .. v39}, Ljava/lang/Math;->cos(D)D

    move-result-wide v38

    mul-double v36, v36, v38

    add-double v6, v6, v36

    double-to-float v5, v6

    const/4 v2, 0x1

    aget v2, v16, v2

    float-to-double v6, v2

    move/from16 v0, v29

    float-to-double v0, v0

    move-wide/from16 v36, v0

    const/high16 v2, 0x43340000    # 180.0f

    add-float v2, v2, v30

    float-to-double v0, v2

    move-wide/from16 v38, v0

    const-wide v40, 0x400921fafc8b007aL    # 3.141592

    mul-double v38, v38, v40

    const-wide v40, 0x4066800000000000L    # 180.0

    div-double v38, v38, v40

    .line 323
    invoke-static/range {v38 .. v39}, Ljava/lang/Math;->sin(D)D

    move-result-wide v38

    mul-double v36, v36, v38

    add-double v6, v6, v36

    double-to-float v6, v6

    const/4 v2, 0x0

    aget-object v7, v17, v2

    move-object/from16 v2, p1

    .line 320
    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 329
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getThrottleImage()Landroid/graphics/Bitmap;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v3}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v3

    const/4 v4, 0x0

    aget v3, v3, v4

    int-to-float v3, v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->getLeft()[I

    move-result-object v4

    const/4 v5, 0x1

    aget v4, v4, v5

    int-to-float v4, v4

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 333
    const/4 v2, 0x1

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 334
    const/4 v2, 0x1

    aget-object v2, v17, v2

    const-wide/high16 v4, 0x4004000000000000L    # 2.5

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    float-to-double v6, v3

    mul-double/2addr v4, v6

    double-to-float v3, v4

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 335
    const/4 v2, 0x1

    aget-object v2, v17, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0028

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 336
    const/4 v2, 0x1

    aget-object v2, v17, v2

    const/high16 v3, 0x40400000    # 3.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 337
    const/4 v2, 0x1

    aget-object v2, v17, v2

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 339
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getAnalogData()[F

    move-result-object v2

    const/4 v3, 0x0

    aget v2, v2, v3

    float-to-double v2, v2

    const-wide/high16 v4, 0x4004000000000000L    # 2.5

    sub-double/2addr v2, v4

    const-wide v4, 0x3ffb333333333333L    # 1.7

    div-double/2addr v2, v4

    const-wide/high16 v4, 0x4059000000000000L    # 100.0

    mul-double/2addr v2, v4

    double-to-int v0, v2

    move/from16 v18, v0

    .line 340
    .local v18, "currentVbat":I
    const/4 v2, 0x1

    aget-object v2, v17, v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {v18 .. v18}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " %"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v19

    .line 342
    .local v19, "droneBatWidth":F
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {v18 .. v18}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " %"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/high16 v3, 0x42a20000    # 81.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x425c0000    # 55.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x1

    aget-object v5, v17, v5

    invoke-virtual {v5}, Landroid/graphics/Paint;->getTextSize()F

    move-result v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float/2addr v5, v6

    add-float/2addr v4, v5

    const/4 v5, 0x1

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 344
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getMobile_vbat()I

    move-result v25

    .line 345
    .local v25, "mobileVbat":I
    const/4 v2, 0x1

    aget-object v2, v17, v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {v25 .. v25}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " %"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v24

    .line 346
    .local v24, "mobileBatWidth":F
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {v25 .. v25}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " %"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/high16 v3, 0x42880000    # 68.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x425c0000    # 55.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x1

    aget-object v5, v17, v5

    invoke-virtual {v5}, Landroid/graphics/Paint;->getTextSize()F

    move-result v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float/2addr v5, v6

    add-float/2addr v4, v5

    const/4 v5, 0x1

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 350
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030004

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v11

    .line 351
    .local v11, "bluetooth":Landroid/graphics/Bitmap;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    if-eqz v2, :cond_4

    .line 352
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v2

    const/4 v3, 0x4

    if-ne v2, v3, :cond_5

    .line 353
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030005

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v11

    .line 359
    :cond_4
    :goto_0
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    int-to-float v3, v3

    div-float v31, v2, v3

    .line 360
    .local v31, "scale":F
    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    int-to-float v2, v2

    mul-float v2, v2, v31

    float-to-int v2, v2

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    int-to-float v3, v3

    mul-float v3, v3, v31

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v11, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v12

    .line 361
    .local v12, "bt_image":Landroid/graphics/Bitmap;
    move-object/from16 v0, p0

    iget v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    const/high16 v3, 0x42540000    # 53.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v12, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 364
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03000a

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v14

    .line 365
    .local v14, "caliIcon":Landroid/graphics/Bitmap;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030003

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v15

    .line 366
    .local v15, "caliIcon_on":Landroid/graphics/Bitmap;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030001

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v8

    .line 367
    .local v8, "Aux4":Landroid/graphics/Bitmap;
    const/4 v2, 0x4

    new-array v13, v2, [Landroid/graphics/Bitmap;

    .line 368
    .local v13, "cali":[Landroid/graphics/Bitmap;
    const/16 v20, 0x0

    .local v20, "i":I
    :goto_1
    const/4 v2, 0x3

    move/from16 v0, v20

    if-ge v0, v2, :cond_8

    .line 369
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v2

    add-int/lit8 v3, v20, 0x4

    aget v2, v2, v3

    const/16 v3, 0x3e8

    if-ne v2, v3, :cond_6

    .line 370
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v14, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    aput-object v2, v13, v20

    .line 368
    :goto_2
    add-int/lit8 v20, v20, 0x1

    goto :goto_1

    .line 355
    .end local v8    # "Aux4":Landroid/graphics/Bitmap;
    .end local v12    # "bt_image":Landroid/graphics/Bitmap;
    .end local v13    # "cali":[Landroid/graphics/Bitmap;
    .end local v14    # "caliIcon":Landroid/graphics/Bitmap;
    .end local v15    # "caliIcon_on":Landroid/graphics/Bitmap;
    .end local v20    # "i":I
    .end local v31    # "scale":F
    :cond_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030004

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v11

    goto/16 :goto_0

    .line 372
    .restart local v8    # "Aux4":Landroid/graphics/Bitmap;
    .restart local v12    # "bt_image":Landroid/graphics/Bitmap;
    .restart local v13    # "cali":[Landroid/graphics/Bitmap;
    .restart local v14    # "caliIcon":Landroid/graphics/Bitmap;
    .restart local v15    # "caliIcon_on":Landroid/graphics/Bitmap;
    .restart local v20    # "i":I
    .restart local v31    # "scale":F
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v2

    add-int/lit8 v3, v20, 0x4

    aget v2, v2, v3

    const/16 v3, 0x7d0

    if-ne v2, v3, :cond_7

    .line 373
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v15, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    aput-object v2, v13, v20

    goto :goto_2

    .line 376
    :cond_7
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v14, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    aput-object v2, v13, v20

    goto :goto_2

    .line 381
    :cond_8
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v8, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 382
    .local v10, "aux":Landroid/graphics/Bitmap;
    const/4 v2, 0x2

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 383
    const/4 v2, 0x2

    aget-object v2, v17, v2

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 384
    const/4 v2, 0x2

    aget-object v2, v17, v2

    const/high16 v3, 0x40000000    # 2.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 385
    const/4 v2, 0x2

    aget-object v2, v17, v2

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 387
    const/4 v2, 0x0

    aget-object v2, v13, v2

    const/high16 v3, 0x41600000    # 14.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 388
    const/4 v2, 0x1

    aget-object v2, v13, v2

    const/high16 v3, 0x41b00000    # 22.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 389
    const/4 v2, 0x2

    aget-object v2, v13, v2

    const/high16 v3, 0x41e80000    # 29.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 391
    const-string v2, "Aux1"

    const-wide v4, 0x4030800000000000L    # 16.5

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    float-to-double v6, v3

    mul-double/2addr v4, v6

    double-to-int v3, v4

    int-to-float v3, v3

    const/high16 v4, 0x41300000    # 11.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x2

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 392
    const-string v2, "Aux2"

    const-wide v4, 0x4038800000000000L    # 24.5

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    float-to-double v6, v3

    mul-double/2addr v4, v6

    double-to-int v3, v4

    int-to-float v3, v3

    const/high16 v4, 0x41300000    # 11.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x2

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 393
    const-string v2, "Aux3"

    const-wide v4, 0x403f800000000000L    # 31.5

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    float-to-double v6, v3

    mul-double/2addr v4, v6

    double-to-int v3, v4

    int-to-float v3, v3

    const/high16 v4, 0x41300000    # 11.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x2

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 397
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getLocked()Z

    move-result v2

    if-eqz v2, :cond_9

    .line 398
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030019

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v34

    .line 402
    .local v34, "yawLock":Landroid/graphics/Bitmap;
    :goto_3
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    move-object/from16 v0, v34

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v21

    .line 403
    .local v21, "lockIcon":Landroid/graphics/Bitmap;
    const/high16 v2, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    int-to-float v2, v2

    const/high16 v3, 0x42400000    # 48.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/4 v4, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 407
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v2

    const/4 v3, 0x7

    aget v2, v2, v3

    const/16 v3, 0x3e8

    if-ne v2, v3, :cond_a

    .line 408
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030027

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v27

    .line 417
    .local v27, "plane":Landroid/graphics/Bitmap;
    :goto_4
    const/high16 v2, 0x40e00000    # 7.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40e00000    # 7.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    move-object/from16 v0, v27

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v28

    .line 418
    .local v28, "plane_image":Landroid/graphics/Bitmap;
    const/high16 v2, 0x42680000    # 58.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v28

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 421
    const/4 v2, 0x3

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 422
    const/4 v2, 0x3

    aget-object v2, v17, v2

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 423
    const/4 v2, 0x3

    aget-object v2, v17, v2

    const/high16 v3, 0x40400000    # 3.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 424
    const/4 v2, 0x3

    aget-object v2, v17, v2

    const/high16 v3, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 425
    const/4 v2, 0x3

    aget-object v2, v17, v2

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 428
    move-object/from16 v0, p0

    iget v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->minute:I

    const/16 v3, 0xa

    if-ge v2, v3, :cond_c

    .line 429
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "0"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->minute:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    .line 432
    .local v23, "minute_text":Ljava/lang/String;
    :goto_5
    move-object/from16 v0, p0

    iget v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->seconds:I

    const/16 v3, 0xa

    if-ge v2, v3, :cond_d

    .line 433
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "0"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->seconds:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    .line 438
    .local v32, "seconds_text":Ljava/lang/String;
    :goto_6
    const/4 v2, 0x4

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 439
    const/4 v2, 0x4

    aget-object v2, v17, v2

    const/high16 v3, 0x40000000    # 2.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 440
    const/4 v2, 0x4

    aget-object v2, v17, v2

    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 441
    const/4 v2, 0x4

    aget-object v2, v17, v2

    const/high16 v3, 0x41000000    # 8.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 442
    const/4 v2, 0x4

    aget-object v2, v17, v2

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 444
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    const/4 v3, 0x0

    aget v2, v2, v3

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/high16 v3, 0x42860000    # 67.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x42420000    # 48.5f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x4

    aget-object v5, v17, v5

    invoke-virtual {v5}, Landroid/graphics/Paint;->getTextSize()F

    move-result v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float/2addr v5, v6

    add-float/2addr v4, v5

    const/4 v5, 0x4

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 445
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/high16 v3, 0x422a0000    # 42.5f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x42160000    # 37.5f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x4

    aget-object v5, v17, v5

    invoke-virtual {v5}, Landroid/graphics/Paint;->getTextSize()F

    move-result v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float/2addr v5, v6

    add-float/2addr v4, v5

    const/4 v5, 0x4

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 446
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    const/4 v3, 0x2

    aget v2, v2, v3

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/high16 v3, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x42420000    # 48.5f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x4

    aget-object v5, v17, v5

    invoke-virtual {v5}, Landroid/graphics/Paint;->getTextSize()F

    move-result v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float/2addr v5, v6

    add-float/2addr v4, v5

    const/4 v5, 0x4

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 448
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v23

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, v32

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    .line 449
    .local v33, "timer_text":Ljava/lang/String;
    const/high16 v2, 0x428e0000    # 71.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    int-to-float v2, v2

    const/high16 v3, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/4 v4, 0x3

    aget-object v4, v17, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getTextSize()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    add-float/2addr v3, v4

    const/4 v4, 0x3

    aget-object v4, v17, v4

    move-object/from16 v0, p1

    move-object/from16 v1, v33

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 453
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v2

    const/4 v3, 0x0

    aget-boolean v2, v2, v3

    const/4 v3, 0x1

    if-ne v2, v3, :cond_e

    .line 454
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03000b

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v9

    .line 461
    .local v9, "accCali":Landroid/graphics/Bitmap;
    :goto_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v2

    const/4 v3, 0x1

    aget-boolean v2, v2, v3

    const/4 v3, 0x1

    if-ne v2, v3, :cond_f

    .line 462
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03000b

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v22

    .line 468
    .local v22, "magCali":Landroid/graphics/Bitmap;
    :goto_8
    const-string v2, "acc\uad50\uc815"

    const/high16 v3, 0x422a0000    # 42.5f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x4

    aget-object v5, v17, v5

    invoke-virtual {v5}, Landroid/graphics/Paint;->getTextSize()F

    move-result v5

    add-float/2addr v4, v5

    const/4 v5, 0x4

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 469
    const-string v2, " mag\uad50\uc815"

    const/high16 v3, 0x42460000    # 49.5f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x4

    aget-object v5, v17, v5

    invoke-virtual {v5}, Landroid/graphics/Paint;->getTextSize()F

    move-result v5

    add-float/2addr v4, v5

    const/4 v5, 0x4

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 471
    const/high16 v2, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v9, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 472
    const/high16 v2, 0x423c0000    # 47.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v22

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 474
    const/4 v2, 0x5

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 475
    const/4 v2, 0x5

    aget-object v2, v17, v2

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 476
    const/4 v2, 0x5

    aget-object v2, v17, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0028

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 477
    const/4 v2, 0x5

    aget-object v2, v17, v2

    const/high16 v3, 0x40800000    # 4.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 479
    return-void

    .line 400
    .end local v9    # "accCali":Landroid/graphics/Bitmap;
    .end local v21    # "lockIcon":Landroid/graphics/Bitmap;
    .end local v22    # "magCali":Landroid/graphics/Bitmap;
    .end local v23    # "minute_text":Ljava/lang/String;
    .end local v27    # "plane":Landroid/graphics/Bitmap;
    .end local v28    # "plane_image":Landroid/graphics/Bitmap;
    .end local v32    # "seconds_text":Ljava/lang/String;
    .end local v33    # "timer_text":Ljava/lang/String;
    .end local v34    # "yawLock":Landroid/graphics/Bitmap;
    :cond_9
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03001a

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v34

    .restart local v34    # "yawLock":Landroid/graphics/Bitmap;
    goto/16 :goto_3

    .line 410
    .restart local v21    # "lockIcon":Landroid/graphics/Bitmap;
    :cond_a
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v2

    const/4 v3, 0x7

    aget v2, v2, v3

    const/16 v3, 0x7d0

    if-ne v2, v3, :cond_b

    .line 411
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030028

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v27

    .restart local v27    # "plane":Landroid/graphics/Bitmap;
    goto/16 :goto_4

    .line 414
    .end local v27    # "plane":Landroid/graphics/Bitmap;
    :cond_b
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030027

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v27

    .restart local v27    # "plane":Landroid/graphics/Bitmap;
    goto/16 :goto_4

    .line 431
    .restart local v28    # "plane_image":Landroid/graphics/Bitmap;
    :cond_c
    move-object/from16 v0, p0

    iget v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->minute:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v23

    .restart local v23    # "minute_text":Ljava/lang/String;
    goto/16 :goto_5

    .line 435
    :cond_d
    move-object/from16 v0, p0

    iget v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->seconds:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v32

    .restart local v32    # "seconds_text":Ljava/lang/String;
    goto/16 :goto_6

    .line 457
    .restart local v33    # "timer_text":Ljava/lang/String;
    :cond_e
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03000a

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v9

    .restart local v9    # "accCali":Landroid/graphics/Bitmap;
    goto/16 :goto_7

    .line 465
    :cond_f
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03000a

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v22

    .restart local v22    # "magCali":Landroid/graphics/Bitmap;
    goto/16 :goto_8
.end method

.method protected getmSensorEventListener()Landroid/hardware/SensorEventListener;
    .locals 1

    .prologue
    .line 572
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mSensorEventListener:Landroid/hardware/SensorEventListener;

    return-object v0
.end method

.method protected getmSensorManager()Landroid/hardware/SensorManager;
    .locals 1

    .prologue
    .line 568
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mSensorManager:Landroid/hardware/SensorManager;

    return-object v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 11
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 74
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 75
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    .line 76
    .local v1, "paint":Landroid/graphics/Paint;
    const/high16 v7, 0x40a00000    # 5.0f

    invoke-virtual {v1, v7}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 77
    const/4 v7, -0x1

    invoke-virtual {v1, v7}, Landroid/graphics/Paint;->setColor(I)V

    .line 78
    iget-object v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->backBitmap:Landroid/graphics/Bitmap;

    if-nez v7, :cond_0

    .line 79
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v7

    int-to-float v7, v7

    iput v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->width:F

    .line 80
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v7

    int-to-float v7, v7

    iput v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->height:F

    .line 81
    iget v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->width:F

    const/high16 v8, 0x42aa0000    # 85.0f

    div-float/2addr v7, v8

    iput v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    .line 82
    iget v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->height:F

    const/high16 v8, 0x42700000    # 60.0f

    div-float/2addr v7, v8

    iput v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    .line 84
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f020057

    invoke-static {v7, v8}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v7

    iget v8, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->width:F

    float-to-int v8, v8

    iget v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->height:F

    float-to-int v9, v9

    const/4 v10, 0x1

    invoke-static {v7, v8, v9, v10}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v4

    .line 85
    .local v4, "scaled":Landroid/graphics/Bitmap;
    new-instance v7, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v7, v4}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/graphics/Bitmap;)V

    invoke-virtual {p0, v7}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 87
    iget-object v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f030034

    invoke-static {v7, v8}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v5

    .line 88
    .local v5, "throttle":Landroid/graphics/Bitmap;
    const/high16 v7, 0x40c00000    # 6.0f

    iget v8, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v7, v8

    float-to-int v7, v7

    const/high16 v8, 0x40c00000    # 6.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v8, v9

    float-to-int v8, v8

    const/4 v9, 0x1

    invoke-static {v5, v7, v8, v9}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v6

    .line 90
    .local v6, "throttle_image":Landroid/graphics/Bitmap;
    const/4 v7, 0x2

    new-array v0, v7, [I

    const/4 v7, 0x0

    const/high16 v8, 0x41900000    # 18.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v8, v9

    invoke-virtual {v6}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v9

    div-int/lit8 v9, v9, 0x2

    int-to-float v9, v9

    sub-float/2addr v8, v9

    float-to-int v8, v8

    aput v8, v0, v7

    const/4 v7, 0x1

    const/high16 v8, 0x42340000    # 45.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v8, v9

    invoke-virtual {v6}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v9

    int-to-float v9, v9

    sub-float/2addr v8, v9

    float-to-int v8, v8

    aput v8, v0, v7

    .line 91
    .local v0, "left_temp":[I
    const/4 v7, 0x2

    new-array v3, v7, [I

    const/4 v7, 0x0

    const/high16 v8, 0x42860000    # 67.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v8, v9

    invoke-virtual {v6}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v9

    div-int/lit8 v9, v9, 0x2

    int-to-float v9, v9

    sub-float/2addr v8, v9

    float-to-int v8, v8

    aput v8, v3, v7

    const/4 v7, 0x1

    const/high16 v8, 0x41f00000    # 30.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v8, v9

    invoke-virtual {v6}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v9

    div-int/lit8 v9, v9, 0x2

    int-to-float v9, v9

    sub-float/2addr v8, v9

    float-to-int v8, v8

    aput v8, v3, v7

    .line 93
    .local v3, "right_temp":[I
    new-instance v7, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-direct {v7, p0, v6, v0, v3}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;Landroid/graphics/Bitmap;[I[I)V

    iput-object v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    .line 94
    iget-object v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    const/high16 v8, 0x41f00000    # 30.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v8, v9

    float-to-int v8, v8

    invoke-virtual {v7, v8}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setThrottle_width(I)V

    .line 95
    iget-object v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    const/high16 v8, 0x41f00000    # 30.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v8, v9

    float-to-int v8, v8

    invoke-virtual {v7, v8}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setThrottle_height(I)V

    .line 96
    const/4 v7, 0x2

    const/4 v8, 0x2

    filled-new-array {v7, v8}, [I

    move-result-object v7

    sget-object v8, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {v8, v7}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [[I

    .line 97
    .local v2, "position":[[I
    const/4 v7, 0x0

    aget-object v7, v2, v7

    const/4 v8, 0x0

    const/high16 v9, 0x40400000    # 3.0f

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v9, v10

    float-to-int v9, v9

    aput v9, v7, v8

    .line 98
    const/4 v7, 0x0

    aget-object v7, v2, v7

    const/4 v8, 0x1

    const/high16 v9, 0x41700000    # 15.0f

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v9, v10

    float-to-int v9, v9

    aput v9, v7, v8

    .line 99
    const/4 v7, 0x1

    aget-object v7, v2, v7

    const/4 v8, 0x0

    const/high16 v9, 0x42500000    # 52.0f

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->x:F

    mul-float/2addr v9, v10

    float-to-int v9, v9

    aput v9, v7, v8

    .line 100
    const/4 v7, 0x1

    aget-object v7, v2, v7

    const/4 v8, 0x1

    const/high16 v9, 0x41700000    # 15.0f

    iget v10, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->y:F

    mul-float/2addr v9, v10

    float-to-int v9, v9

    aput v9, v7, v8

    .line 102
    iget-object v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;

    invoke-virtual {v7, v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$Throttle;->setThrottle_position([[I)V

    .line 104
    iget v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->width:F

    const/16 v8, 0x55

    iget v9, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->height:F

    const/16 v10, 0x3c

    invoke-virtual {p0, v7, v8, v9, v10}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->drawBackground(FIFI)Landroid/graphics/Bitmap;

    move-result-object v7

    iput-object v7, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->backBitmap:Landroid/graphics/Bitmap;

    .line 105
    new-instance v7, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v8, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->backBitmap:Landroid/graphics/Bitmap;

    invoke-direct {v7, v8}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/graphics/Bitmap;)V

    invoke-virtual {p0, v7}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 108
    .end local v0    # "left_temp":[I
    .end local v2    # "position":[[I
    .end local v3    # "right_temp":[I
    .end local v4    # "scaled":Landroid/graphics/Bitmap;
    .end local v5    # "throttle":Landroid/graphics/Bitmap;
    .end local v6    # "throttle_image":Landroid/graphics/Bitmap;
    :cond_0
    invoke-virtual {p0, p1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->drawController(Landroid/graphics/Canvas;)V

    .line 110
    return-void
.end method

.method public setmBluetoothService(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V
    .locals 0
    .param p1, "mBluetoothService"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .prologue
    .line 561
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .line 562
    return-void
.end method
