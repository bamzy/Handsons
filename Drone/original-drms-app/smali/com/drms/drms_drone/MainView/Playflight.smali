.class public Lcom/drms/drms_drone/MainView/Playflight;
.super Landroid/widget/LinearLayout;
.source "Playflight.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;,
        Lcom/drms/drms_drone/MainView/Playflight$NextBtn;
    }
.end annotation


# instance fields
.field private Pi:D

.field private TAG:Ljava/lang/String;

.field canvas_height:F

.field canvas_width:F

.field private flight_play:Lcom/drms/drms_drone/MainView/Playflight$NextBtn;

.field private mActivity:Landroid/app/Activity;

.field private mBTService:Lcom/drms/drms_drone/Service/BTService;

.field private mContext:Landroid/content/Context;

.field private mPaint:[Landroid/graphics/Paint;

.field private mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

.field private mspdata:Lcom/drms/drms_drone/MultiData;

.field private myDrone:Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mActivity"    # Landroid/app/Activity;

    .prologue
    const/4 v2, 0x0

    .line 54
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 35
    const-wide v0, 0x400921fafc8b007aL    # 3.141592

    iput-wide v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->Pi:D

    .line 38
    iput v2, p0, Lcom/drms/drms_drone/MainView/Playflight;->canvas_width:F

    .line 39
    iput v2, p0, Lcom/drms/drms_drone/MainView/Playflight;->canvas_height:F

    .line 41
    const-class v0, Lcom/drms/drms_drone/MainView/Playflight;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->TAG:Ljava/lang/String;

    .line 46
    const/16 v0, 0xa

    new-array v0, v0, [Landroid/graphics/Paint;

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    .line 56
    iput-object p1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mContext:Landroid/content/Context;

    .line 57
    iput-object p2, p0, Lcom/drms/drms_drone/MainView/Playflight;->mActivity:Landroid/app/Activity;

    .line 58
    invoke-virtual {p2}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 59
    new-instance v0, Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-direct {v0, p1}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 60
    return-void
.end method

.method private drawCurrentDrone(Landroid/graphics/Canvas;)V
    .locals 30
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 98
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x1

    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    aput-object v5, v2, v3

    .line 99
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x1

    aget-object v2, v2, v3

    const/high16 v3, 0x40a00000    # 5.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 100
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x1

    aget-object v2, v2, v3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/MainView/Playflight;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v5, 0x7f0c002a

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 101
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x1

    aget-object v2, v2, v3

    sget-object v3, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 103
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x2

    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    aput-object v5, v2, v3

    .line 104
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x2

    aget-object v2, v2, v3

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 105
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x2

    aget-object v2, v2, v3

    const/high16 v3, 0x40e00000    # 7.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 106
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x2

    aget-object v2, v2, v3

    sget-object v3, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 108
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x6

    int-to-float v0, v2

    move/from16 v18, v0

    .line 109
    .local v18, "radius":F
    const/4 v2, 0x2

    new-array v8, v2, [F

    const/4 v2, 0x0

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x5

    int-to-float v3, v3

    aput v3, v8, v2

    const/4 v2, 0x1

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v3

    mul-int/lit8 v3, v3, 0x2

    div-int/lit8 v3, v3, 0x5

    int-to-float v3, v3

    aput v3, v8, v2

    .line 112
    .local v8, "center":[F
    const/4 v2, 0x4

    new-array v0, v2, [F

    move-object/from16 v16, v0

    const/4 v2, 0x0

    .line 113
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    mul-int/lit8 v3, v3, 0x1a

    div-int/lit8 v3, v3, 0x1e

    int-to-float v3, v3

    aput v3, v16, v2

    const/4 v2, 0x1

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v3

    mul-int/lit8 v3, v3, 0x3

    div-int/lit8 v3, v3, 0x1e

    int-to-float v3, v3

    aput v3, v16, v2

    const/4 v2, 0x2

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    mul-int/lit8 v3, v3, 0x1d

    div-int/lit8 v3, v3, 0x1e

    int-to-float v3, v3

    aput v3, v16, v2

    const/4 v2, 0x3

    .line 114
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v3

    mul-int/lit8 v3, v3, 0x9

    div-int/lit8 v3, v3, 0x1e

    int-to-float v3, v3

    aput v3, v16, v2

    .line 117
    .local v16, "positionOfRect":[F
    const/4 v2, 0x2

    aget v2, v16, v2

    const/4 v3, 0x0

    aget v3, v16, v3

    sub-float v21, v2, v3

    .line 118
    .local v21, "width":F
    const/4 v2, 0x0

    aget v3, v16, v2

    const/4 v2, 0x1

    aget v4, v16, v2

    const/4 v2, 0x2

    aget v5, v16, v2

    const/4 v2, 0x3

    aget v6, v16, v2

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x2

    aget-object v7, v2, v7

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 120
    const/4 v2, 0x0

    aget v2, v16, v2

    const/high16 v3, 0x40400000    # 3.0f

    div-float v3, v21, v3

    add-float/2addr v3, v2

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v2

    mul-int/lit8 v2, v2, 0x2

    div-int/lit8 v2, v2, 0x1e

    int-to-float v4, v2

    const/4 v2, 0x0

    aget v2, v16, v2

    const/high16 v5, 0x40000000    # 2.0f

    mul-float v5, v5, v21

    const/high16 v6, 0x40400000    # 3.0f

    div-float/2addr v5, v6

    add-float/2addr v5, v2

    const/4 v2, 0x1

    aget v6, v16, v2

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x2

    aget-object v7, v2, v7

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 123
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x3

    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    aput-object v5, v2, v3

    .line 124
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x3

    aget-object v2, v2, v3

    const/high16 v3, 0x42480000    # 50.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 125
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x3

    aget-object v2, v2, v3

    const/high16 v3, 0x40800000    # 4.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 126
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x3

    aget-object v2, v2, v3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/MainView/Playflight;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v5, 0x7f0c0028

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 127
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x3

    aget-object v2, v2, v3

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 130
    const/4 v2, 0x2

    new-array v0, v2, [I

    move-object/from16 v17, v0

    const/4 v2, 0x0

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    aput v3, v17, v2

    const/4 v2, 0x1

    const/4 v3, 0x1

    aget v3, v8, v3

    sub-float v3, v3, v18

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v6, 0x3

    aget-object v5, v5, v6

    invoke-virtual {v5}, Landroid/graphics/Paint;->getTextSize()F

    move-result v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float/2addr v5, v6

    add-float/2addr v3, v5

    float-to-int v3, v3

    aput v3, v17, v2

    .line 131
    .local v17, "positionOfText":[I
    const-string v2, "R : "

    const/4 v3, 0x0

    aget v3, v17, v3

    int-to-float v3, v3

    const/4 v5, 0x1

    aget v5, v17, v5

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x3

    aget-object v6, v6, v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 132
    const-string v2, "P : "

    const/4 v3, 0x0

    aget v3, v17, v3

    int-to-float v3, v3

    const/4 v5, 0x1

    aget v5, v17, v5

    int-to-float v5, v5

    add-float v5, v5, v18

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x3

    aget-object v6, v6, v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 133
    const-string v2, "Y : "

    const/4 v3, 0x0

    aget v3, v17, v3

    int-to-float v3, v3

    const/4 v5, 0x1

    aget v5, v17, v5

    int-to-float v5, v5

    const/high16 v6, 0x40000000    # 2.0f

    mul-float v6, v6, v18

    add-float/2addr v5, v6

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x3

    aget-object v6, v6, v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 135
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x3

    aget-object v2, v2, v3

    const-string v3, "Pitch"

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v13

    .line 137
    .local v13, "longestWidth":F
    const/16 v20, 0x0

    .line 138
    .local v20, "roll_temp":I
    const/4 v15, 0x0

    .line 139
    .local v15, "pitch_temp":I
    const/16 v22, 0x0

    .line 141
    .local v22, "yaw_temp":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    if-eqz v2, :cond_0

    .line 142
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v2

    const/4 v3, 0x0

    aget v2, v2, v3

    float-to-int v0, v2

    move/from16 v20, v0

    .line 143
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    float-to-int v15, v2

    .line 144
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v2

    const/4 v3, 0x2

    aget v2, v2, v3

    float-to-int v0, v2

    move/from16 v22, v0

    .line 147
    :cond_0
    invoke-static/range {v20 .. v20}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    aget v3, v17, v3

    int-to-float v3, v3

    add-float/2addr v3, v13

    const/4 v5, 0x1

    aget v5, v17, v5

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x3

    aget-object v6, v6, v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 148
    invoke-static {v15}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    aget v3, v17, v3

    int-to-float v3, v3

    add-float/2addr v3, v13

    const/4 v5, 0x1

    aget v5, v17, v5

    int-to-float v5, v5

    add-float v5, v5, v18

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x3

    aget-object v6, v6, v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 149
    invoke-static/range {v22 .. v22}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    aget v3, v17, v3

    int-to-float v3, v3

    add-float/2addr v3, v13

    const/4 v5, 0x1

    aget v5, v17, v5

    int-to-float v5, v5

    const/high16 v6, 0x40000000    # 2.0f

    mul-float v6, v6, v18

    add-float/2addr v5, v6

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x3

    aget-object v6, v6, v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 150
    const/16 v2, 0xb4

    move/from16 v0, v20

    if-le v0, v2, :cond_1

    .line 151
    const/16 v20, 0xb4

    .line 152
    :cond_1
    const/16 v2, -0xb4

    move/from16 v0, v20

    if-ge v0, v2, :cond_2

    .line 153
    const/16 v20, -0xb4

    .line 154
    :cond_2
    const/16 v2, 0x3c

    if-le v15, v2, :cond_3

    .line 155
    const/16 v15, 0x3c

    .line 156
    :cond_3
    const/16 v2, -0x3c

    if-ge v15, v2, :cond_4

    .line 157
    const/16 v15, -0x3c

    .line 159
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x4

    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    aput-object v5, v2, v3

    .line 160
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x4

    aget-object v2, v2, v3

    const/high16 v3, 0x41200000    # 10.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 161
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x4

    aget-object v2, v2, v3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/MainView/Playflight;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v5, 0x7f0c004c

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 163
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x5

    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    aput-object v5, v2, v3

    .line 164
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x5

    aget-object v2, v2, v3

    const/high16 v3, 0x41200000    # 10.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 165
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x5

    aget-object v2, v2, v3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/MainView/Playflight;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v5, 0x7f0c003f

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 168
    const/4 v2, 0x4

    new-array v0, v2, [I

    move-object/from16 v19, v0

    const/4 v2, 0x0

    const/4 v3, 0x0

    aget v3, v8, v3

    float-to-double v6, v3

    move/from16 v0, v18

    float-to-double v0, v0

    move-wide/from16 v24, v0

    move/from16 v0, v20

    int-to-double v0, v0

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/drms/drms_drone/MainView/Playflight;->Pi:D

    move-wide/from16 v28, v0

    mul-double v26, v26, v28

    const-wide v28, 0x4066800000000000L    # 180.0

    div-double v26, v26, v28

    .line 169
    invoke-static/range {v26 .. v27}, Ljava/lang/Math;->cos(D)D

    move-result-wide v26

    mul-double v24, v24, v26

    add-double v6, v6, v24

    double-to-int v3, v6

    aput v3, v19, v2

    const/4 v2, 0x1

    const/4 v3, 0x1

    aget v3, v8, v3

    float-to-double v6, v3

    move/from16 v0, v18

    float-to-double v0, v0

    move-wide/from16 v24, v0

    move/from16 v0, v20

    int-to-double v0, v0

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/drms/drms_drone/MainView/Playflight;->Pi:D

    move-wide/from16 v28, v0

    mul-double v26, v26, v28

    const-wide v28, 0x4066800000000000L    # 180.0

    div-double v26, v26, v28

    .line 170
    invoke-static/range {v26 .. v27}, Ljava/lang/Math;->sin(D)D

    move-result-wide v26

    mul-double v24, v24, v26

    add-double v6, v6, v24

    double-to-int v3, v6

    aput v3, v19, v2

    const/4 v2, 0x2

    const/4 v3, 0x0

    aget v3, v8, v3

    float-to-double v6, v3

    move/from16 v0, v18

    float-to-double v0, v0

    move-wide/from16 v24, v0

    move/from16 v0, v20

    add-int/lit16 v3, v0, 0xb4

    int-to-double v0, v3

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/drms/drms_drone/MainView/Playflight;->Pi:D

    move-wide/from16 v28, v0

    mul-double v26, v26, v28

    const-wide v28, 0x4066800000000000L    # 180.0

    div-double v26, v26, v28

    .line 171
    invoke-static/range {v26 .. v27}, Ljava/lang/Math;->cos(D)D

    move-result-wide v26

    mul-double v24, v24, v26

    add-double v6, v6, v24

    double-to-int v3, v6

    aput v3, v19, v2

    const/4 v2, 0x3

    const/4 v3, 0x1

    aget v3, v8, v3

    float-to-double v6, v3

    move/from16 v0, v18

    float-to-double v0, v0

    move-wide/from16 v24, v0

    move/from16 v0, v20

    add-int/lit16 v3, v0, 0xb4

    int-to-double v0, v3

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/drms/drms_drone/MainView/Playflight;->Pi:D

    move-wide/from16 v28, v0

    mul-double v26, v26, v28

    const-wide v28, 0x4066800000000000L    # 180.0

    div-double v26, v26, v28

    .line 172
    invoke-static/range {v26 .. v27}, Ljava/lang/Math;->sin(D)D

    move-result-wide v26

    mul-double v24, v24, v26

    add-double v6, v6, v24

    double-to-int v3, v6

    aput v3, v19, v2

    .line 175
    .local v19, "roll_line":[I
    const/4 v2, 0x4

    new-array v14, v2, [I

    const/4 v2, 0x0

    const/4 v3, 0x0

    aget v3, v8, v3

    float-to-double v6, v3

    move/from16 v0, v18

    float-to-double v0, v0

    move-wide/from16 v24, v0

    neg-int v3, v15

    int-to-double v0, v3

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/drms/drms_drone/MainView/Playflight;->Pi:D

    move-wide/from16 v28, v0

    mul-double v26, v26, v28

    const-wide v28, 0x4066800000000000L    # 180.0

    div-double v26, v26, v28

    .line 176
    invoke-static/range {v26 .. v27}, Ljava/lang/Math;->cos(D)D

    move-result-wide v26

    mul-double v24, v24, v26

    add-double v6, v6, v24

    double-to-int v3, v6

    aput v3, v14, v2

    const/4 v2, 0x1

    const/4 v3, 0x1

    aget v3, v8, v3

    float-to-double v6, v3

    move/from16 v0, v18

    float-to-double v0, v0

    move-wide/from16 v24, v0

    neg-int v3, v15

    int-to-double v0, v3

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/drms/drms_drone/MainView/Playflight;->Pi:D

    move-wide/from16 v28, v0

    mul-double v26, v26, v28

    const-wide v28, 0x4066800000000000L    # 180.0

    div-double v26, v26, v28

    .line 177
    invoke-static/range {v26 .. v27}, Ljava/lang/Math;->sin(D)D

    move-result-wide v26

    mul-double v24, v24, v26

    add-double v6, v6, v24

    double-to-int v3, v6

    aput v3, v14, v2

    const/4 v2, 0x2

    const/4 v3, 0x0

    aget v3, v8, v3

    float-to-double v6, v3

    move/from16 v0, v18

    float-to-double v0, v0

    move-wide/from16 v24, v0

    add-int/lit16 v3, v15, 0xb4

    int-to-double v0, v3

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/drms/drms_drone/MainView/Playflight;->Pi:D

    move-wide/from16 v28, v0

    mul-double v26, v26, v28

    const-wide v28, 0x4066800000000000L    # 180.0

    div-double v26, v26, v28

    .line 178
    invoke-static/range {v26 .. v27}, Ljava/lang/Math;->cos(D)D

    move-result-wide v26

    mul-double v24, v24, v26

    add-double v6, v6, v24

    double-to-int v3, v6

    aput v3, v14, v2

    const/4 v2, 0x3

    const/4 v3, 0x1

    aget v3, v8, v3

    float-to-double v6, v3

    move/from16 v0, v18

    float-to-double v0, v0

    move-wide/from16 v24, v0

    neg-int v3, v15

    int-to-double v0, v3

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/drms/drms_drone/MainView/Playflight;->Pi:D

    move-wide/from16 v28, v0

    mul-double v26, v26, v28

    const-wide v28, 0x4066800000000000L    # 180.0

    div-double v26, v26, v28

    .line 179
    invoke-static/range {v26 .. v27}, Ljava/lang/Math;->sin(D)D

    move-result-wide v26

    mul-double v24, v24, v26

    add-double v6, v6, v24

    double-to-int v3, v6

    aput v3, v14, v2

    .line 182
    .local v14, "pitch_line":[I
    const/16 v2, 0x9

    new-array v10, v2, [I

    fill-array-data v10, :array_0

    .line 183
    .local v10, "degree":[I
    const/4 v2, 0x0

    aget v2, v19, v2

    int-to-float v3, v2

    const/4 v2, 0x1

    aget v2, v19, v2

    int-to-float v4, v2

    const/4 v2, 0x2

    aget v2, v19, v2

    int-to-float v5, v2

    const/4 v2, 0x3

    aget v2, v19, v2

    int-to-float v6, v2

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x4

    aget-object v7, v2, v7

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 184
    const/4 v2, 0x0

    aget v2, v14, v2

    int-to-float v3, v2

    const/4 v2, 0x1

    aget v2, v14, v2

    int-to-float v4, v2

    const/4 v2, 0x2

    aget v2, v14, v2

    int-to-float v5, v2

    const/4 v2, 0x3

    aget v2, v14, v2

    int-to-float v6, v2

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x5

    aget-object v7, v2, v7

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 186
    const/4 v2, 0x0

    aget v2, v8, v2

    const/4 v3, 0x1

    aget v3, v8, v3

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v6, 0x1

    aget-object v5, v5, v6

    move-object/from16 v0, p1

    move/from16 v1, v18

    invoke-virtual {v0, v2, v3, v1, v5}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 187
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x6

    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    aput-object v5, v2, v3

    .line 188
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x6

    aget-object v2, v2, v3

    const/high16 v3, 0x41000000    # 8.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 189
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x6

    aget-object v2, v2, v3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/MainView/Playflight;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v5, 0x7f0c0028

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 190
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_0
    array-length v2, v10

    if-ge v12, v2, :cond_5

    .line 191
    const/4 v2, 0x0

    aget v2, v8, v2

    float-to-double v2, v2

    move/from16 v0, v18

    float-to-double v6, v0

    aget v5, v10, v12

    int-to-double v0, v5

    move-wide/from16 v24, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/drms/drms_drone/MainView/Playflight;->Pi:D

    move-wide/from16 v26, v0

    mul-double v24, v24, v26

    const-wide v26, 0x4066800000000000L    # 180.0

    div-double v24, v24, v26

    invoke-static/range {v24 .. v25}, Ljava/lang/Math;->cos(D)D

    move-result-wide v24

    mul-double v6, v6, v24

    add-double/2addr v2, v6

    double-to-float v2, v2

    const/4 v3, 0x1

    aget v3, v8, v3

    float-to-double v6, v3

    move/from16 v0, v18

    float-to-double v0, v0

    move-wide/from16 v24, v0

    aget v3, v10, v12

    int-to-double v0, v3

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/drms/drms_drone/MainView/Playflight;->Pi:D

    move-wide/from16 v28, v0

    mul-double v26, v26, v28

    const-wide v28, 0x4066800000000000L    # 180.0

    div-double v26, v26, v28

    .line 192
    invoke-static/range {v26 .. v27}, Ljava/lang/Math;->sin(D)D

    move-result-wide v26

    mul-double v24, v24, v26

    add-double v6, v6, v24

    double-to-float v3, v6

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v6, 0x6

    aget-object v5, v5, v6

    .line 191
    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5}, Landroid/graphics/Canvas;->drawPoint(FFLandroid/graphics/Paint;)V

    .line 190
    add-int/lit8 v12, v12, 0x1

    goto :goto_0

    .line 195
    :cond_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x7

    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    aput-object v5, v2, v3

    .line 196
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x7

    aget-object v2, v2, v3

    sget-object v3, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 197
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v3, 0x7

    aget-object v2, v2, v3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/MainView/Playflight;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v5, 0x7f0c005a

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 199
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x5

    int-to-float v2, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v5, 0x2

    aget-object v3, v3, v5

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    sub-float v11, v2, v3

    .line 201
    .local v11, "height":F
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getAnalogData()[F

    move-result-object v2

    const/4 v3, 0x0

    aget v9, v2, v3

    .line 202
    .local v9, "current_vbat":F
    const v2, 0x3dcccccd

    cmpl-float v2, v9, v2

    if-nez v2, :cond_6

    .line 203
    const/high16 v9, 0x40200000    # 2.5f

    .line 205
    :cond_6
    const/4 v2, 0x3

    aget v2, v16, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v5, 0x2

    aget-object v3, v3, v5

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v3, v5

    sub-float/2addr v2, v3

    float-to-double v2, v2

    float-to-double v6, v9

    const-wide/high16 v24, 0x4004000000000000L    # 2.5

    sub-double v6, v6, v24

    const-wide v24, 0x3ffb333333333333L    # 1.7

    div-double v6, v6, v24

    float-to-double v0, v11

    move-wide/from16 v24, v0

    mul-double v6, v6, v24

    sub-double/2addr v2, v6

    double-to-float v4, v2

    .line 207
    .local v4, "currentVbat":F
    const/4 v2, 0x0

    aget v2, v16, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v5, 0x2

    aget-object v3, v3, v5

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v3, v5

    add-float/2addr v3, v2

    const/4 v2, 0x2

    aget v2, v16, v2

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v6, 0x2

    aget-object v5, v5, v6

    .line 208
    invoke-virtual {v5}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float/2addr v5, v6

    sub-float v5, v2, v5

    const/4 v2, 0x3

    aget v2, v16, v2

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x2

    aget-object v6, v6, v7

    invoke-virtual {v6}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v6

    const/high16 v7, 0x40000000    # 2.0f

    div-float/2addr v6, v7

    sub-float v6, v2, v6

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/4 v7, 0x7

    aget-object v7, v2, v7

    move-object/from16 v2, p1

    .line 207
    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 211
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v3, 0x8

    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    aput-object v5, v2, v3

    .line 212
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v3, 0x8

    aget-object v2, v2, v3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/MainView/Playflight;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v5, 0x7f0c0021

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 213
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v3, 0x8

    aget-object v2, v2, v3

    const/high16 v3, 0x42a00000    # 80.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 214
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v3, 0x8

    aget-object v2, v2, v3

    const/high16 v3, 0x40800000    # 4.0f

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 215
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v3, 0x8

    aget-object v2, v2, v3

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 218
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    if-eqz v2, :cond_a

    .line 219
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    if-eqz v2, :cond_9

    .line 220
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v2

    const/4 v3, 0x4

    if-ne v2, v3, :cond_8

    .line 221
    const/4 v2, 0x4

    move/from16 v0, v20

    if-gt v0, v2, :cond_7

    const/4 v2, -0x4

    move/from16 v0, v20

    if-lt v0, v2, :cond_7

    const/4 v2, 0x4

    if-gt v15, v2, :cond_7

    const/4 v2, -0x4

    if-lt v15, v2, :cond_7

    .line 223
    const-string v2, "\ube44 \ud589  \uac00 \ub2a5"

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v5

    mul-int/lit8 v5, v5, 0x7

    div-int/lit8 v5, v5, 0x8

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v7, 0x8

    aget-object v6, v6, v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 243
    :goto_1
    return-void

    .line 225
    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v3, 0x8

    aget-object v2, v2, v3

    const/high16 v3, -0x10000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 226
    const-string v2, "\ube44 \ud589  \ubd88 \uac00"

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v5

    mul-int/lit8 v5, v5, 0x7

    div-int/lit8 v5, v5, 0x8

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v7, 0x8

    aget-object v6, v6, v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_1

    .line 229
    :cond_8
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v3, 0x8

    aget-object v2, v2, v3

    const/high16 v3, -0x10000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 230
    const-string v2, "قطع شده"

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v5

    mul-int/lit8 v5, v5, 0x7

    div-int/lit8 v5, v5, 0x8

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v7, 0x8

    aget-object v6, v6, v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_1

    .line 234
    :cond_9
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v3, 0x8

    aget-object v2, v2, v3

    const/high16 v3, -0x10000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 235
    const-string v2, "قطع شده"

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v5

    mul-int/lit8 v5, v5, 0x7

    div-int/lit8 v5, v5, 0x8

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v7, 0x8

    aget-object v6, v6, v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 240
    :cond_a
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v3, 0x8

    aget-object v2, v2, v3

    const/high16 v3, -0x10000

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 241
    const-string v2, "قطع شده"

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v5

    mul-int/lit8 v5, v5, 0x7

    div-int/lit8 v5, v5, 0x8

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    const/16 v7, 0x8

    aget-object v6, v6, v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 182
    :array_0
    .array-data 4
        0x0
        0x2d
        0x5a
        0x87
        0xb4
        0xe1
        0x10e
        0x13b
        0x168
    .end array-data
.end method

.method private drawTopicAndNext(Landroid/graphics/Canvas;)V
    .locals 7
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v6, 0x40000000    # 2.0f

    const/4 v5, 0x0

    .line 86
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    aput-object v2, v1, v5

    .line 87
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    aget-object v1, v1, v5

    sget-object v2, Landroid/graphics/Paint$Align;->LEFT:Landroid/graphics/Paint$Align;

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 88
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    aget-object v1, v1, v5

    const/high16 v2, 0x428c0000    # 70.0f

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 89
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    aget-object v1, v1, v5

    const/high16 v2, 0x40a00000    # 5.0f

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 90
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    aget-object v1, v1, v5

    iget-object v2, p0, Lcom/drms/drms_drone/MainView/Playflight;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0c002b

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 92
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f030024

    invoke-static {v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 93
    .local v0, "temp":Landroid/graphics/Bitmap;
    const-string v1, " \ube44 \ud589 "

    iget-object v2, p0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    aget-object v2, v2, v5

    invoke-virtual {v2}, Landroid/graphics/Paint;->getTextSize()F

    move-result v2

    div-float/2addr v2, v6

    iget-object v3, p0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    aget-object v3, v3, v5

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40400000    # 3.0f

    mul-float/2addr v3, v4

    div-float/2addr v3, v6

    iget-object v4, p0, Lcom/drms/drms_drone/MainView/Playflight;->mPaint:[Landroid/graphics/Paint;

    aget-object v4, v4, v5

    invoke-virtual {p1, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 95
    return-void
.end method


# virtual methods
.method public executeController()V
    .locals 8

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x1

    const/high16 v5, 0x40a00000    # 5.0f

    const/high16 v3, -0x3f600000    # -5.0f

    const/4 v4, 0x0

    .line 283
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v1

    invoke-virtual {v1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_1

    .line 284
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v1

    aget v1, v1, v4

    cmpl-float v1, v1, v3

    if-lez v1, :cond_0

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v1

    aget v1, v1, v4

    cmpg-float v1, v1, v5

    if-gez v1, :cond_0

    .line 285
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v1

    aget v1, v1, v6

    cmpl-float v1, v1, v3

    if-ltz v1, :cond_0

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v1

    aget v1, v1, v6

    cmpg-float v1, v1, v5

    if-gtz v1, :cond_0

    .line 286
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mContext:Landroid/content/Context;

    const-class v2, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 288
    .local v0, "JoystickIntent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mActivity:Landroid/app/Activity;

    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    const-string v3, "request controller display"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/Activity;->sendBroadcast(Landroid/content/Intent;)V

    .line 289
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mActivity:Landroid/app/Activity;

    invoke-virtual {v1, v0, v7}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 290
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mActivity:Landroid/app/Activity;

    const v2, 0x7f05000b

    const v3, 0x7f05000c

    invoke-virtual {v1, v2, v3}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 292
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 303
    .end local v0    # "JoystickIntent":Landroid/content/Intent;
    :cond_0
    :goto_0
    return-void

    .line 296
    :cond_1
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v1

    invoke-virtual {v1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v1

    if-ne v1, v7, :cond_2

    .line 297
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mActivity:Landroid/app/Activity;

    const-string v2, "\ub4dc\ub860 \uc5f0\uacb0 \uc911..."

    invoke-static {v1, v2, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 301
    :cond_2
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mActivity:Landroid/app/Activity;

    const-string v2, "\ub4dc\ub860\uc744 \uc5f0\uacb0\ud574 \uc8fc\uc138\uc694."

    invoke-static {v1, v2, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v1, 0x0

    .line 70
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onDraw(Landroid/graphics/Canvas;)V

    .line 73
    iget v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->canvas_width:F

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    iget v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->canvas_height:F

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    .line 74
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->canvas_width:F

    .line 75
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->canvas_height:F

    .line 76
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Canvas Width : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/MainView/Playflight;->canvas_width:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\nCanvas Height : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/MainView/Playflight;->canvas_height:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 79
    :cond_0
    invoke-direct {p0, p1}, Lcom/drms/drms_drone/MainView/Playflight;->drawTopicAndNext(Landroid/graphics/Canvas;)V

    .line 80
    invoke-direct {p0, p1}, Lcom/drms/drms_drone/MainView/Playflight;->drawCurrentDrone(Landroid/graphics/Canvas;)V

    .line 81
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v2, 0x1

    .line 247
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_1

    .line 279
    :cond_0
    :goto_0
    return v2

    .line 257
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 259
    const-wide/16 v0, 0x1e

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 273
    :goto_1
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->TAG:Ljava/lang/String;

    const-string v1, "onTouch PlayFlight"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 275
    invoke-virtual {p0}, Lcom/drms/drms_drone/MainView/Playflight;->executeController()V

    goto :goto_0

    .line 261
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public setmBTService(Lcom/drms/drms_drone/Service/BTService;)V
    .locals 2
    .param p1, "mBTService"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/drms/drms_drone/MainView/Playflight;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    .line 64
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight;->TAG:Ljava/lang/String;

    const-string v1, "set BTService in PlayFlight"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 65
    return-void
.end method
