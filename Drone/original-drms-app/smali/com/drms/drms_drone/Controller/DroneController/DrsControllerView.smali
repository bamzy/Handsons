.class public Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;
.super Landroid/view/View;
.source "DrsControllerView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$SensorListener;,
        Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;
    }
.end annotation


# static fields
.field protected static final TAG:Ljava/lang/String; = "DrsControllerView"


# instance fields
.field protected backBitmap:Landroid/graphics/Bitmap;

.field protected droneThrottle:Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView$Throttle;

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
    iput v1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->width:F

    .line 42
    const/16 v0, 0x55

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->unitWidth:I

    .line 43
    iput v1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->height:F

    .line 44
    const/16 v0, 0x3c

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->unitHeight:I

    .line 48
    iput-wide v4, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->timer:J

    .line 49
    iput-wide v4, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->init_time:J

    .line 50
    iput v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->minute:I

    .line 51
    const/4 v0, 0x1

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->seconds:I

    .line 53
    iput-boolean v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->unlocked_left_throttle:Z

    .line 54
    iput-boolean v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->unlocked_right_throttle:Z

    .line 55
    filled-new-array {v3, v3}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[Z

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->unlock_throttle:[[Z

    .line 264
    iput-boolean v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->isArmed:Z

    .line 62
    iput-object p2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mActivity:Landroid/app/Activity;

    .line 63
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    .line 64
    invoke-virtual {p2}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 66
    iput-object p3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mHandler:Landroid/os/Handler;

    .line 67
    new-instance v0, Lcom/drms/drms_drone/Sound/SoundManager;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 68
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    iput-wide v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->init_time:J

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
    .line 105
    const/16 v2, 0xa

    new-array v11, v2, [Landroid/graphics/Paint;

    .line 107
    .local v11, "backPaint":[Landroid/graphics/Paint;
    const/4 v2, 0x0

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v11, v2

    .line 108
    const/4 v2, 0x0

    aget-object v2, v11, v2

    const/16 v3, 0x14

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 109
    const/4 v2, 0x0

    aget-object v2, v11, v2

    const/high16 v3, 0x40400000    # 3.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 110
    const/4 v2, 0x0

    aget-object v2, v11, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0028

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 111
    const/4 v2, 0x0

    aget-object v2, v11, v2

    const/16 v3, 0x82

    const/16 v4, 0xa7

    const/16 v5, 0xa7

    const/16 v23, 0xa7

    move/from16 v0, v23

    invoke-virtual {v2, v3, v4, v5, v0}, Landroid/graphics/Paint;->setARGB(IIII)V

    .line 112
    const/4 v2, 0x0

    aget-object v2, v11, v2

    sget-object v3, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 114
    move/from16 v0, p1

    float-to-int v2, v0

    move/from16 v0, p3

    float-to-int v3, v0

    sget-object v4, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v2, v3, v4}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v19

    .line 115
    .local v19, "tempBitmap":Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    move-object/from16 v0, v19

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 121
    .local v1, "canvas":Landroid/graphics/Canvas;
    const/4 v2, 0x1

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v11, v2

    .line 122
    const/4 v2, 0x1

    aget-object v2, v11, v2

    const/high16 v3, 0x40e00000    # 7.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 123
    const/4 v2, 0x1

    aget-object v2, v11, v2

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 125
    const/4 v2, 0x2

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v11, v2

    .line 126
    const/4 v2, 0x2

    aget-object v2, v11, v2

    const/high16 v3, 0x40a00000    # 5.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 127
    const/4 v2, 0x2

    aget-object v2, v11, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0029

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 129
    const/high16 v2, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42140000    # 37.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 130
    const/high16 v2, 0x42400000    # 48.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 131
    const/high16 v2, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42140000    # 37.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 132
    const/high16 v2, 0x42400000    # 48.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x1

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 133
    const/high16 v2, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

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

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

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

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    .line 134
    const/high16 v2, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

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

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

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

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    .line 135
    const/high16 v2, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x2

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 136
    const/high16 v2, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41a00000    # 20.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41a00000    # 20.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x2

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 137
    const/high16 v2, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42340000    # 45.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x2

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 139
    const/4 v2, 0x2

    aget-object v2, v11, v2

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 140
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_0
    const/4 v2, 0x6

    if-ge v12, v2, :cond_0

    .line 141
    const/high16 v2, 0x42280000    # 42.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    add-int/lit8 v3, v12, 0xe

    int-to-float v3, v3

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x422c0000    # 43.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v4, v5

    add-int/lit8 v5, v12, 0xe

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x2

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 140
    add-int/lit8 v12, v12, 0x1

    goto :goto_0

    .line 142
    :cond_0
    const/4 v12, 0x0

    :goto_1
    const/4 v2, 0x6

    if-ge v12, v2, :cond_1

    .line 143
    const/high16 v2, 0x42280000    # 42.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    add-int/lit8 v3, v12, 0x15

    int-to-float v3, v3

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x422c0000    # 43.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v4, v5

    add-int/lit8 v5, v12, 0x15

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget v0, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    move/from16 v23, v0

    mul-float v5, v5, v23

    const/16 v23, 0x2

    aget-object v6, v11, v23

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 142
    add-int/lit8 v12, v12, 0x1

    goto :goto_1

    .line 145
    :cond_1
    const/4 v2, 0x2

    aget-object v2, v11, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c005a

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 146
    const/4 v2, 0x2

    aget-object v2, v11, v2

    const/high16 v3, 0x41200000    # 10.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 150
    new-instance v17, Landroid/graphics/BitmapFactory$Options;

    invoke-direct/range {v17 .. v17}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 151
    .local v17, "option":Landroid/graphics/BitmapFactory$Options;
    const/4 v2, 0x2

    move-object/from16 v0, v17

    iput v2, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 152
    const/4 v2, 0x4

    new-array v7, v2, [Landroid/graphics/Bitmap;

    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    .line 153
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f030021

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v7, v2

    const/4 v2, 0x1

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    .line 154
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f03001c

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v7, v2

    const/4 v2, 0x2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    .line 155
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f03001d

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v7, v2

    const/4 v2, 0x3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    .line 156
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f03001f

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v7, v2

    .line 158
    .local v7, "arrowIcon":[Landroid/graphics/Bitmap;
    const/4 v2, 0x4

    new-array v10, v2, [Landroid/graphics/Bitmap;

    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    .line 159
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f030035

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v10, v2

    const/4 v2, 0x1

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    .line 160
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f030010

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v10, v2

    const/4 v2, 0x2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    .line 161
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f030017

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v10, v2

    const/4 v2, 0x3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    .line 162
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f03002c

    move-object/from16 v0, v17

    invoke-static {v3, v4, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    aput-object v3, v10, v2

    .line 165
    .local v10, "arrowIcon_on":[Landroid/graphics/Bitmap;
    const/4 v2, 0x4

    new-array v8, v2, [Landroid/graphics/Bitmap;

    .line 166
    .local v8, "arrowIconTemp":[Landroid/graphics/Bitmap;
    const/4 v2, 0x4

    new-array v9, v2, [Landroid/graphics/Bitmap;

    .line 168
    .local v9, "arrowIconTemp_on":[Landroid/graphics/Bitmap;
    const/4 v12, 0x0

    :goto_2
    const/4 v2, 0x4

    if-ge v12, v2, :cond_2

    .line 169
    aget-object v2, v7, v12

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    aput-object v2, v8, v12

    .line 168
    add-int/lit8 v12, v12, 0x1

    goto :goto_2

    .line 171
    :cond_2
    const/4 v12, 0x0

    :goto_3
    const/4 v2, 0x4

    if-ge v12, v2, :cond_3

    .line 172
    aget-object v2, v7, v12

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    aput-object v2, v9, v12

    .line 171
    add-int/lit8 v12, v12, 0x1

    goto :goto_3

    .line 181
    :cond_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x0

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_4

    .line 182
    const/4 v2, 0x2

    aget-object v2, v9, v2

    const/high16 v3, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 188
    :goto_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x1

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_5

    .line 189
    const/4 v2, 0x3

    aget-object v2, v9, v2

    const/high16 v3, 0x429a0000    # 77.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 195
    :goto_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x2

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_6

    .line 196
    const/4 v2, 0x1

    aget-object v2, v9, v2

    const/high16 v3, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 202
    :goto_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x3

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_7

    .line 203
    const/4 v2, 0x0

    aget-object v2, v9, v2

    const/high16 v3, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 209
    :goto_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x4

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_8

    .line 210
    const/4 v2, 0x2

    aget-object v2, v9, v2

    const/high16 v3, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 216
    :goto_8
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream_touched()[Z

    move-result-object v2

    const/4 v3, 0x5

    aget-boolean v2, v2, v3

    if-eqz v2, :cond_9

    .line 217
    const/4 v2, 0x3

    aget-object v2, v9, v2

    const/high16 v3, 0x41e00000    # 28.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 225
    :goto_9
    const/high16 v2, 0x40e00000    # 7.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    sget-object v4, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v2, v3, v4}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v14

    .line 226
    .local v14, "menuIcon":Landroid/graphics/Bitmap;
    new-instance v18, Landroid/graphics/Canvas;

    move-object/from16 v0, v18

    invoke-direct {v0, v14}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 227
    .local v18, "temp":Landroid/graphics/Canvas;
    new-instance v6, Landroid/graphics/Paint;

    invoke-direct {v6}, Landroid/graphics/Paint;-><init>()V

    .line 228
    .local v6, "menuIconPaint":Landroid/graphics/Paint;
    const/high16 v2, 0x40a00000    # 5.0f

    invoke-virtual {v6, v2}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 229
    const/high16 v2, -0x1000000

    invoke-virtual {v6, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 230
    const/4 v12, 0x0

    :goto_a
    const/4 v2, 0x3

    if-ge v12, v2, :cond_a

    .line 231
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

    .line 230
    add-int/lit8 v12, v12, 0x1

    goto :goto_a

    .line 185
    .end local v6    # "menuIconPaint":Landroid/graphics/Paint;
    .end local v14    # "menuIcon":Landroid/graphics/Bitmap;
    .end local v18    # "temp":Landroid/graphics/Canvas;
    :cond_4
    const/4 v2, 0x2

    aget-object v2, v8, v2

    const/high16 v3, 0x42500000    # 52.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_4

    .line 192
    :cond_5
    const/4 v2, 0x3

    aget-object v2, v8, v2

    const/high16 v3, 0x429a0000    # 77.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_5

    .line 199
    :cond_6
    const/4 v2, 0x1

    aget-object v2, v8, v2

    const/high16 v3, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_6

    .line 206
    :cond_7
    const/4 v2, 0x0

    aget-object v2, v8, v2

    const/high16 v3, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41f00000    # 30.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_7

    .line 213
    :cond_8
    const/4 v2, 0x2

    aget-object v2, v8, v2

    const/high16 v3, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_8

    .line 220
    :cond_9
    const/4 v2, 0x3

    aget-object v2, v8, v2

    const/high16 v3, 0x41e00000    # 28.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42380000    # 46.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_9

    .line 233
    .restart local v6    # "menuIconPaint":Landroid/graphics/Paint;
    .restart local v14    # "menuIcon":Landroid/graphics/Bitmap;
    .restart local v18    # "temp":Landroid/graphics/Canvas;
    :cond_a
    const/high16 v2, 0x40000000    # 2.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x40000000    # 2.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    invoke-virtual {v1, v14, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 236
    const/4 v2, 0x3

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v11, v2

    .line 237
    const/4 v2, 0x3

    aget-object v2, v11, v2

    const/16 v3, 0xff

    const/16 v4, 0xfa

    const/16 v5, 0xe0

    const/16 v23, 0xd4

    move/from16 v0, v23

    invoke-virtual {v2, v3, v4, v5, v0}, Landroid/graphics/Paint;->setARGB(IIII)V

    .line 238
    const/4 v2, 0x3

    aget-object v2, v11, v2

    const/high16 v3, 0x40a00000    # 5.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 239
    const/4 v2, 0x3

    aget-object v2, v11, v2

    sget-object v3, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 248
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030013

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v22

    .line 249
    .local v22, "vbatIcon":Landroid/graphics/Bitmap;
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    move-object/from16 v0, v22

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v13

    .line 250
    .local v13, "icon":Landroid/graphics/Bitmap;
    const/high16 v2, 0x42920000    # 73.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x42540000    # 53.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    invoke-virtual {v1, v13, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 252
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03001b

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v16

    .line 253
    .local v16, "mobileIcon":Landroid/graphics/Bitmap;
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    move-object/from16 v0, v16

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v15

    .line 254
    .local v15, "mobile":Landroid/graphics/Bitmap;
    const/high16 v2, 0x42700000    # 60.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x42540000    # 53.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    invoke-virtual {v1, v15, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 257
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020067

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v21

    .line 258
    .local v21, "timerback_temp":Landroid/graphics/Bitmap;
    const/high16 v2, 0x41a00000    # 20.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x41100000    # 9.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    move-object/from16 v0, v21

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v20

    .line 259
    .local v20, "timer_back":Landroid/graphics/Bitmap;
    const/high16 v2, 0x42640000    # 57.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    int-to-float v2, v2

    const/high16 v3, 0x40800000    # 4.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/4 v4, 0x0

    move-object/from16 v0, v20

    invoke-virtual {v1, v0, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 261
    return-object v19
.end method

.method protected drawController(Landroid/graphics/Canvas;)V
    .locals 40
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 270
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    move-object/from16 v0, p0

    iget-wide v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->init_time:J

    sub-long/2addr v2, v4

    move-object/from16 v0, p0

    iput-wide v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->timer:J

    .line 273
    move-object/from16 v0, p0

    iget-wide v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->timer:J

    const-wide/16 v4, 0x3c

    div-long/2addr v2, v4

    long-to-int v2, v2

    move-object/from16 v0, p0

    iput v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->minute:I

    .line 274
    move-object/from16 v0, p0

    iget-wide v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->timer:J

    const-wide/16 v4, 0x3c

    rem-long/2addr v2, v4

    long-to-int v2, v2

    move-object/from16 v0, p0

    iput v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->seconds:I

    .line 276
    const/16 v2, 0xa

    new-array v0, v2, [Landroid/graphics/Paint;

    move-object/from16 v17, v0

    .line 279
    .local v17, "contPaint":[Landroid/graphics/Paint;
    const/4 v2, 0x0

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 280
    const/4 v2, 0x0

    aget-object v2, v17, v2

    const/high16 v3, 0x41200000    # 10.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 281
    const/4 v2, 0x0

    aget-object v2, v17, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0053

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 283
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    neg-float v0, v2

    move/from16 v25, v0

    .line 284
    .local v25, "pitch":F
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v2

    const/4 v3, 0x0

    aget v29, v2, v3

    .line 286
    .local v29, "roll":F
    const/high16 v2, 0x42700000    # 60.0f

    cmpl-float v2, v25, v2

    if-lez v2, :cond_0

    const/high16 v25, 0x42700000    # 60.0f

    .line 287
    :cond_0
    const/high16 v2, -0x3d900000    # -60.0f

    cmpg-float v2, v25, v2

    if-gez v2, :cond_1

    const/high16 v25, -0x3d900000    # -60.0f

    .line 288
    :cond_1
    const/high16 v2, 0x42b40000    # 90.0f

    cmpl-float v2, v29, v2

    if-lez v2, :cond_2

    const/high16 v29, 0x42b40000    # 90.0f

    .line 289
    :cond_2
    const/high16 v2, -0x3d4c0000    # -90.0f

    cmpg-float v2, v29, v2

    if-gez v2, :cond_3

    const/high16 v29, -0x3d4c0000    # -90.0f

    .line 291
    :cond_3
    const/4 v2, 0x2

    new-array v0, v2, [F

    move-object/from16 v16, v0

    const/4 v2, 0x0

    const/high16 v3, 0x420c0000    # 35.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x42480000    # 50.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v4, v5

    add-float/2addr v3, v4

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    aput v3, v16, v2

    const/4 v2, 0x1

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    add-float/2addr v3, v4

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v4, v5

    const/high16 v5, 0x42700000    # 60.0f

    div-float v5, v25, v5

    mul-float/2addr v4, v5

    add-float/2addr v3, v4

    aput v3, v16, v2

    .line 292
    .local v16, "center":[F
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float v28, v2, v3

    .line 294
    .local v28, "radius":F
    const/high16 v2, 0x42140000    # 37.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v2

    const/4 v2, 0x1

    aget v4, v16, v2

    const/high16 v2, 0x42400000    # 48.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v5, v2

    const/4 v2, 0x1

    aget v6, v16, v2

    const/4 v2, 0x0

    aget-object v7, v17, v2

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 296
    const/4 v2, 0x0

    aget-object v2, v17, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c002b

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 297
    const/4 v2, 0x1

    const/high16 v3, 0x41500000    # 13.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41d80000    # 27.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    add-float/2addr v3, v4

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    aput v3, v16, v2

    .line 299
    const/4 v2, 0x0

    aget v2, v16, v2

    float-to-double v2, v2

    move/from16 v0, v28

    float-to-double v4, v0

    move/from16 v0, v29

    float-to-double v6, v0

    const-wide v34, 0x400921fafc8b007aL    # 3.141592

    mul-double v6, v6, v34

    const-wide v34, 0x4066800000000000L    # 180.0

    div-double v6, v6, v34

    invoke-static {v6, v7}, Ljava/lang/Math;->cos(D)D

    move-result-wide v6

    mul-double/2addr v4, v6

    add-double/2addr v2, v4

    double-to-float v3, v2

    const/4 v2, 0x1

    aget v2, v16, v2

    float-to-double v4, v2

    move/from16 v0, v28

    float-to-double v6, v0

    move/from16 v0, v29

    float-to-double v0, v0

    move-wide/from16 v34, v0

    const-wide v36, 0x400921fafc8b007aL    # 3.141592

    mul-double v34, v34, v36

    const-wide v36, 0x4066800000000000L    # 180.0

    div-double v34, v34, v36

    .line 300
    invoke-static/range {v34 .. v35}, Ljava/lang/Math;->sin(D)D

    move-result-wide v34

    mul-double v6, v6, v34

    add-double/2addr v4, v6

    double-to-float v4, v4

    const/4 v2, 0x0

    aget v2, v16, v2

    float-to-double v6, v2

    move/from16 v0, v28

    float-to-double v0, v0

    move-wide/from16 v34, v0

    const/high16 v2, 0x43340000    # 180.0f

    add-float v2, v2, v29

    float-to-double v0, v2

    move-wide/from16 v36, v0

    const-wide v38, 0x400921fafc8b007aL    # 3.141592

    mul-double v36, v36, v38

    const-wide v38, 0x4066800000000000L    # 180.0

    div-double v36, v36, v38

    .line 301
    invoke-static/range {v36 .. v37}, Ljava/lang/Math;->cos(D)D

    move-result-wide v36

    mul-double v34, v34, v36

    add-double v6, v6, v34

    double-to-float v5, v6

    const/4 v2, 0x1

    aget v2, v16, v2

    float-to-double v6, v2

    move/from16 v0, v28

    float-to-double v0, v0

    move-wide/from16 v34, v0

    const/high16 v2, 0x43340000    # 180.0f

    add-float v2, v2, v29

    float-to-double v0, v2

    move-wide/from16 v36, v0

    const-wide v38, 0x400921fafc8b007aL    # 3.141592

    mul-double v36, v36, v38

    const-wide v38, 0x4066800000000000L    # 180.0

    div-double v36, v36, v38

    .line 302
    invoke-static/range {v36 .. v37}, Ljava/lang/Math;->sin(D)D

    move-result-wide v36

    mul-double v34, v34, v36

    add-double v6, v6, v34

    double-to-float v6, v6

    const/4 v2, 0x0

    aget-object v7, v17, v2

    move-object/from16 v2, p1

    .line 299
    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 312
    const/4 v2, 0x1

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 313
    const/4 v2, 0x1

    aget-object v2, v17, v2

    const-wide/high16 v4, 0x4004000000000000L    # 2.5

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    float-to-double v6, v3

    mul-double/2addr v4, v6

    double-to-float v3, v4

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 314
    const/4 v2, 0x1

    aget-object v2, v17, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0028

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 315
    const/4 v2, 0x1

    aget-object v2, v17, v2

    const/high16 v3, 0x40400000    # 3.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 316
    const/4 v2, 0x1

    aget-object v2, v17, v2

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 318
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

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

    .line 319
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

    .line 321
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

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x425c0000    # 55.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    .line 323
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getMobile_vbat()I

    move-result v24

    .line 324
    .local v24, "mobileVbat":I
    const/4 v2, 0x1

    aget-object v2, v17, v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {v24 .. v24}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " %"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v23

    .line 325
    .local v23, "mobileBatWidth":F
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {v24 .. v24}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

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

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x425c0000    # 55.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    .line 329
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030004

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v11

    .line 330
    .local v11, "bluetooth":Landroid/graphics/Bitmap;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    if-eqz v2, :cond_4

    .line 331
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v2

    const/4 v3, 0x4

    if-ne v2, v3, :cond_5

    .line 332
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030005

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v11

    .line 338
    :cond_4
    :goto_0
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    int-to-float v3, v3

    div-float v30, v2, v3

    .line 339
    .local v30, "scale":F
    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    int-to-float v2, v2

    mul-float v2, v2, v30

    float-to-int v2, v2

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    int-to-float v3, v3

    mul-float v3, v3, v30

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v11, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v12

    .line 340
    .local v12, "bt_image":Landroid/graphics/Bitmap;
    move-object/from16 v0, p0

    iget v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    const/high16 v3, 0x42540000    # 53.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v12, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 343
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03000a

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v14

    .line 344
    .local v14, "caliIcon":Landroid/graphics/Bitmap;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030003

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v15

    .line 345
    .local v15, "caliIcon_on":Landroid/graphics/Bitmap;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030001

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v8

    .line 346
    .local v8, "Aux4":Landroid/graphics/Bitmap;
    const/4 v2, 0x4

    new-array v13, v2, [Landroid/graphics/Bitmap;

    .line 347
    .local v13, "cali":[Landroid/graphics/Bitmap;
    const/16 v20, 0x0

    .local v20, "i":I
    :goto_1
    const/4 v2, 0x3

    move/from16 v0, v20

    if-ge v0, v2, :cond_8

    .line 348
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v2

    add-int/lit8 v3, v20, 0x4

    aget v2, v2, v3

    const/16 v3, 0x3e8

    if-ne v2, v3, :cond_6

    .line 349
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v14, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    aput-object v2, v13, v20

    .line 347
    :goto_2
    add-int/lit8 v20, v20, 0x1

    goto :goto_1

    .line 334
    .end local v8    # "Aux4":Landroid/graphics/Bitmap;
    .end local v12    # "bt_image":Landroid/graphics/Bitmap;
    .end local v13    # "cali":[Landroid/graphics/Bitmap;
    .end local v14    # "caliIcon":Landroid/graphics/Bitmap;
    .end local v15    # "caliIcon_on":Landroid/graphics/Bitmap;
    .end local v20    # "i":I
    .end local v30    # "scale":F
    :cond_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030004

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v11

    goto/16 :goto_0

    .line 351
    .restart local v8    # "Aux4":Landroid/graphics/Bitmap;
    .restart local v12    # "bt_image":Landroid/graphics/Bitmap;
    .restart local v13    # "cali":[Landroid/graphics/Bitmap;
    .restart local v14    # "caliIcon":Landroid/graphics/Bitmap;
    .restart local v15    # "caliIcon_on":Landroid/graphics/Bitmap;
    .restart local v20    # "i":I
    .restart local v30    # "scale":F
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v2

    add-int/lit8 v3, v20, 0x4

    aget v2, v2, v3

    const/16 v3, 0x7d0

    if-ne v2, v3, :cond_7

    .line 352
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v15, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    aput-object v2, v13, v20

    goto :goto_2

    .line 355
    :cond_7
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v14, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    aput-object v2, v13, v20

    goto :goto_2

    .line 360
    :cond_8
    const/high16 v2, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    invoke-static {v8, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 361
    .local v10, "aux":Landroid/graphics/Bitmap;
    const/4 v2, 0x2

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 362
    const/4 v2, 0x2

    aget-object v2, v17, v2

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 363
    const/4 v2, 0x2

    aget-object v2, v17, v2

    const/high16 v3, 0x40000000    # 2.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 364
    const/4 v2, 0x2

    aget-object v2, v17, v2

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 366
    const/4 v2, 0x0

    aget-object v2, v13, v2

    const/high16 v3, 0x41600000    # 14.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 367
    const/4 v2, 0x1

    aget-object v2, v13, v2

    const/high16 v3, 0x41b00000    # 22.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 368
    const/4 v2, 0x2

    aget-object v2, v13, v2

    const/high16 v3, 0x41e80000    # 29.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 370
    const-string v2, "Aux1"

    const-wide v4, 0x4030800000000000L    # 16.5

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    float-to-double v6, v3

    mul-double/2addr v4, v6

    double-to-int v3, v4

    int-to-float v3, v3

    const/high16 v4, 0x41300000    # 11.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x2

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 371
    const-string v2, "Aux2"

    const-wide v4, 0x4038800000000000L    # 24.5

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    float-to-double v6, v3

    mul-double/2addr v4, v6

    double-to-int v3, v4

    int-to-float v3, v3

    const/high16 v4, 0x41300000    # 11.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x2

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 372
    const-string v2, "Aux3"

    const-wide v4, 0x403f800000000000L    # 31.5

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    float-to-double v6, v3

    mul-double/2addr v4, v6

    double-to-int v3, v4

    int-to-float v3, v3

    const/high16 v4, 0x41300000    # 11.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    int-to-float v4, v4

    const/4 v5, 0x2

    aget-object v5, v17, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 378
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v2

    const/4 v3, 0x7

    aget v2, v2, v3

    const/16 v3, 0x3e8

    if-ne v2, v3, :cond_9

    .line 379
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030027

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v26

    .line 388
    .local v26, "plane":Landroid/graphics/Bitmap;
    :goto_3
    const/high16 v2, 0x40e00000    # 7.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/high16 v3, 0x40e00000    # 7.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x1

    move-object/from16 v0, v26

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v27

    .line 389
    .local v27, "plane_image":Landroid/graphics/Bitmap;
    const/high16 v2, 0x42680000    # 58.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 392
    const/4 v2, 0x3

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 393
    const/4 v2, 0x3

    aget-object v2, v17, v2

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 394
    const/4 v2, 0x3

    aget-object v2, v17, v2

    const/high16 v3, 0x40400000    # 3.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 395
    const/4 v2, 0x3

    aget-object v2, v17, v2

    const/high16 v3, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 396
    const/4 v2, 0x3

    aget-object v2, v17, v2

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 399
    move-object/from16 v0, p0

    iget v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->minute:I

    const/16 v3, 0xa

    if-ge v2, v3, :cond_b

    .line 400
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "0"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->minute:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    .line 403
    .local v22, "minute_text":Ljava/lang/String;
    :goto_4
    move-object/from16 v0, p0

    iget v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->seconds:I

    const/16 v3, 0xa

    if-ge v2, v3, :cond_c

    .line 404
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "0"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->seconds:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v31

    .line 409
    .local v31, "seconds_text":Ljava/lang/String;
    :goto_5
    const/4 v2, 0x4

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 410
    const/4 v2, 0x4

    aget-object v2, v17, v2

    const/high16 v3, 0x40000000    # 2.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 411
    const/4 v2, 0x4

    aget-object v2, v17, v2

    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 412
    const/4 v2, 0x4

    aget-object v2, v17, v2

    const/high16 v3, 0x41000000    # 8.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 413
    const/4 v2, 0x4

    aget-object v2, v17, v2

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 415
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    const/4 v3, 0x0

    aget v2, v2, v3

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/high16 v3, 0x42860000    # 67.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x42420000    # 48.5f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    .line 416
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/high16 v3, 0x422a0000    # 42.5f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x42160000    # 37.5f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    .line 417
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v2

    const/4 v3, 0x2

    aget v2, v2, v3

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/high16 v3, 0x41900000    # 18.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    int-to-float v3, v3

    const/high16 v4, 0x42420000    # 48.5f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    .line 419
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v22

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, v31

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    .line 420
    .local v32, "timer_text":Ljava/lang/String;
    const/high16 v2, 0x428e0000    # 71.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    int-to-float v2, v2

    const/high16 v3, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    move-object/from16 v1, v32

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 424
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v2

    const/4 v3, 0x0

    aget-boolean v2, v2, v3

    const/4 v3, 0x1

    if-ne v2, v3, :cond_d

    .line 425
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03000b

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v9

    .line 432
    .local v9, "accCali":Landroid/graphics/Bitmap;
    :goto_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getCalibration()[Z

    move-result-object v2

    const/4 v3, 0x1

    aget-boolean v2, v2, v3

    const/4 v3, 0x1

    if-ne v2, v3, :cond_e

    .line 433
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03000b

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v21

    .line 439
    .local v21, "magCali":Landroid/graphics/Bitmap;
    :goto_7
    const-string v2, "acc\uad50\uc815"

    const/high16 v3, 0x422a0000    # 42.5f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    .line 440
    const-string v2, " mag\uad50\uc815"

    const/high16 v3, 0x42460000    # 49.5f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x41000000    # 8.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

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

    .line 442
    const/high16 v2, 0x42200000    # 40.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v9, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 443
    const/high16 v2, 0x423c0000    # 47.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v2, v3

    const/high16 v3, 0x40400000    # 3.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v3, v4

    const/4 v4, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 445
    const/4 v2, 0x5

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    aput-object v3, v17, v2

    .line 446
    const/4 v2, 0x5

    aget-object v2, v17, v2

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 447
    const/4 v2, 0x5

    aget-object v2, v17, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0c0028

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 448
    const/4 v2, 0x5

    aget-object v2, v17, v2

    const/high16 v3, 0x40800000    # 4.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 450
    return-void

    .line 381
    .end local v9    # "accCali":Landroid/graphics/Bitmap;
    .end local v21    # "magCali":Landroid/graphics/Bitmap;
    .end local v22    # "minute_text":Ljava/lang/String;
    .end local v26    # "plane":Landroid/graphics/Bitmap;
    .end local v27    # "plane_image":Landroid/graphics/Bitmap;
    .end local v31    # "seconds_text":Ljava/lang/String;
    .end local v32    # "timer_text":Ljava/lang/String;
    :cond_9
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v2

    const/4 v3, 0x7

    aget v2, v2, v3

    const/16 v3, 0x7d0

    if-ne v2, v3, :cond_a

    .line 382
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030028

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v26

    .restart local v26    # "plane":Landroid/graphics/Bitmap;
    goto/16 :goto_3

    .line 385
    .end local v26    # "plane":Landroid/graphics/Bitmap;
    :cond_a
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030027

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v26

    .restart local v26    # "plane":Landroid/graphics/Bitmap;
    goto/16 :goto_3

    .line 402
    .restart local v27    # "plane_image":Landroid/graphics/Bitmap;
    :cond_b
    move-object/from16 v0, p0

    iget v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->minute:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v22

    .restart local v22    # "minute_text":Ljava/lang/String;
    goto/16 :goto_4

    .line 406
    :cond_c
    move-object/from16 v0, p0

    iget v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->seconds:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v31

    .restart local v31    # "seconds_text":Ljava/lang/String;
    goto/16 :goto_5

    .line 428
    .restart local v32    # "timer_text":Ljava/lang/String;
    :cond_d
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03000a

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v9

    .restart local v9    # "accCali":Landroid/graphics/Bitmap;
    goto/16 :goto_6

    .line 436
    :cond_e
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f03000a

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    const/high16 v3, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v4, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v21

    .restart local v21    # "magCali":Landroid/graphics/Bitmap;
    goto/16 :goto_7
.end method

.method protected getmSensorEventListener()Landroid/hardware/SensorEventListener;
    .locals 1

    .prologue
    .line 543
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mSensorEventListener:Landroid/hardware/SensorEventListener;

    return-object v0
.end method

.method protected getmSensorManager()Landroid/hardware/SensorManager;
    .locals 1

    .prologue
    .line 539
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mSensorManager:Landroid/hardware/SensorManager;

    return-object v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 74
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 75
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    .line 76
    .local v0, "paint":Landroid/graphics/Paint;
    const/high16 v2, 0x40a00000    # 5.0f

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 77
    const/4 v2, -0x1

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 78
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->backBitmap:Landroid/graphics/Bitmap;

    if-nez v2, :cond_0

    .line 79
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v2

    int-to-float v2, v2

    iput v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->width:F

    .line 80
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v2

    int-to-float v2, v2

    iput v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->height:F

    .line 81
    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->width:F

    const/high16 v3, 0x42aa0000    # 85.0f

    div-float/2addr v2, v3

    iput v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->x:F

    .line 82
    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->height:F

    const/high16 v3, 0x42700000    # 60.0f

    div-float/2addr v2, v3

    iput v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->y:F

    .line 84
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020057

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->width:F

    float-to-int v3, v3

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->height:F

    float-to-int v4, v4

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 85
    .local v1, "scaled":Landroid/graphics/Bitmap;
    new-instance v2, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v2, v1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/graphics/Bitmap;)V

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 87
    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->width:F

    const/16 v3, 0x55

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->height:F

    const/16 v5, 0x3c

    invoke-virtual {p0, v2, v3, v4, v5}, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->drawBackground(FIFI)Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->backBitmap:Landroid/graphics/Bitmap;

    .line 88
    new-instance v2, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->backBitmap:Landroid/graphics/Bitmap;

    invoke-direct {v2, v3}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/graphics/Bitmap;)V

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 91
    .end local v1    # "scaled":Landroid/graphics/Bitmap;
    :cond_0
    invoke-virtual {p0, p1}, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->drawController(Landroid/graphics/Canvas;)V

    .line 93
    return-void
.end method

.method public setmBluetoothService(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V
    .locals 0
    .param p1, "mBluetoothService"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .prologue
    .line 532
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .line 533
    return-void
.end method
