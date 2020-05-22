.class public Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;
.super Lcom/drms/drms_drone/Controller/MultiSetting/SettingView;
.source "BoxSettingView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;
    }
.end annotation


# instance fields
.field private BOXITEMNUM:I

.field private checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

.field private mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

.field private offTemp:Landroid/graphics/Bitmap;

.field private onTemp:Landroid/graphics/Bitmap;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mActivity"    # Landroid/app/Activity;

    .prologue
    const/4 v2, 0x0

    .line 27
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Controller/MultiSetting/SettingView;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    .line 24
    iput v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->BOXITEMNUM:I

    .line 29
    new-instance v0, Lcom/drms/drms_drone/Sound/SoundManager;

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 31
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getBoxITEM()[Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 32
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getBoxITEM()[Ljava/lang/String;

    move-result-object v0

    array-length v0, v0

    iput v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->BOXITEMNUM:I

    .line 37
    :goto_0
    iget v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->BOXITEMNUM:I

    const/16 v1, 0xc

    filled-new-array {v0, v1}, [I

    move-result-object v0

    const-class v1, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    .line 39
    return-void

    .line 35
    :cond_0
    iput v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->BOXITEMNUM:I

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->onTemp:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->offTemp:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method private initializeOnOff()V
    .locals 13

    .prologue
    .line 42
    const/high16 v8, 0x40400000    # 3.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->y:F

    mul-float/2addr v8, v9

    float-to-int v8, v8

    const/high16 v9, 0x40400000    # 3.0f

    iget v10, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->y:F

    mul-float/2addr v9, v10

    float-to-int v9, v9

    sget-object v10, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v8, v9, v10}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v8

    iput-object v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->onTemp:Landroid/graphics/Bitmap;

    .line 43
    const/high16 v8, 0x40400000    # 3.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->y:F

    mul-float/2addr v8, v9

    float-to-int v8, v8

    const/high16 v9, 0x40400000    # 3.0f

    iget v10, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->y:F

    mul-float/2addr v9, v10

    float-to-int v9, v9

    sget-object v10, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v8, v9, v10}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v8

    iput-object v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->offTemp:Landroid/graphics/Bitmap;

    .line 45
    new-instance v6, Landroid/graphics/Canvas;

    iget-object v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->onTemp:Landroid/graphics/Bitmap;

    invoke-direct {v6, v8}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 46
    .local v6, "onCanvas":Landroid/graphics/Canvas;
    new-instance v7, Landroid/graphics/Paint;

    invoke-direct {v7}, Landroid/graphics/Paint;-><init>()V

    .line 47
    .local v7, "onPaint":Landroid/graphics/Paint;
    const/high16 v8, 0x41000000    # 8.0f

    invoke-virtual {v7, v8}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 48
    iget-object v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f0c0028

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    invoke-virtual {v7, v8}, Landroid/graphics/Paint;->setColor(I)V

    .line 49
    sget-object v8, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v7, v8}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 50
    invoke-virtual {v6}, Landroid/graphics/Canvas;->getWidth()I

    move-result v8

    div-int/lit8 v8, v8, 0x2

    int-to-float v8, v8

    invoke-virtual {v6}, Landroid/graphics/Canvas;->getHeight()I

    move-result v9

    div-int/lit8 v9, v9, 0x2

    int-to-float v9, v9

    invoke-virtual {v6}, Landroid/graphics/Canvas;->getHeight()I

    move-result v10

    div-int/lit8 v10, v10, 0x2

    int-to-float v10, v10

    invoke-virtual {v7}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v11

    const/high16 v12, 0x40000000    # 2.0f

    div-float/2addr v11, v12

    sub-float/2addr v10, v11

    invoke-virtual {v6, v8, v9, v10, v7}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 52
    new-instance v4, Landroid/graphics/Canvas;

    iget-object v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->offTemp:Landroid/graphics/Bitmap;

    invoke-direct {v4, v8}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 53
    .local v4, "offCanvas":Landroid/graphics/Canvas;
    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    .line 54
    .local v5, "offPaint":Landroid/graphics/Paint;
    const/high16 v8, 0x41000000    # 8.0f

    invoke-virtual {v5, v8}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 55
    iget-object v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f0c002a

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    invoke-virtual {v5, v8}, Landroid/graphics/Paint;->setColor(I)V

    .line 56
    sget-object v8, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v5, v8}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 57
    invoke-virtual {v6}, Landroid/graphics/Canvas;->getWidth()I

    move-result v8

    div-int/lit8 v8, v8, 0x2

    int-to-float v8, v8

    invoke-virtual {v6}, Landroid/graphics/Canvas;->getHeight()I

    move-result v9

    div-int/lit8 v9, v9, 0x2

    int-to-float v9, v9

    invoke-virtual {v6}, Landroid/graphics/Canvas;->getHeight()I

    move-result v10

    div-int/lit8 v10, v10, 0x2

    int-to-float v10, v10

    invoke-virtual {v7}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v11

    const/high16 v12, 0x40000000    # 2.0f

    div-float/2addr v11, v12

    sub-float/2addr v10, v11

    invoke-virtual {v4, v8, v9, v10, v5}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 58
    const/high16 v8, 0x41700000    # 15.0f

    invoke-virtual {v5, v8}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 59
    invoke-virtual {v4}, Landroid/graphics/Canvas;->getWidth()I

    move-result v8

    div-int/lit8 v8, v8, 0x2

    int-to-float v8, v8

    invoke-virtual {v4}, Landroid/graphics/Canvas;->getHeight()I

    move-result v9

    div-int/lit8 v9, v9, 0x2

    int-to-float v9, v9

    invoke-virtual {v4, v8, v9, v5}, Landroid/graphics/Canvas;->drawPoint(FFLandroid/graphics/Paint;)V

    .line 61
    const/high16 v8, 0x41200000    # 10.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->x:F

    mul-float v0, v8, v9

    .line 62
    .local v0, "Xtemp":F
    const/high16 v8, 0x40e00000    # 7.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->y:F

    mul-float v1, v8, v9

    .line 64
    .local v1, "Ytemp":F
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->BOXITEMNUM:I

    if-ge v2, v8, :cond_2

    .line 65
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_1
    const/16 v8, 0xc

    if-ge v3, v8, :cond_1

    .line 66
    iget-object v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v8, v8, v2

    new-instance v9, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v10}, Lcom/drms/drms_drone/MultiData;->getCheckboxData()[[Z

    move-result-object v10

    aget-object v10, v10, v2

    aget-boolean v10, v10, v3

    invoke-direct {v9, p0, v0, v1, v10}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;-><init>(Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;FFZ)V

    aput-object v9, v8, v3

    .line 67
    rem-int/lit8 v8, v3, 0x3

    const/4 v9, 0x2

    if-eq v8, v9, :cond_0

    .line 68
    const/high16 v8, 0x40800000    # 4.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->x:F

    mul-float/2addr v8, v9

    add-float/2addr v0, v8

    .line 65
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 71
    :cond_0
    const/high16 v8, 0x40c00000    # 6.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->x:F

    mul-float/2addr v8, v9

    add-float/2addr v0, v8

    goto :goto_2

    .line 74
    :cond_1
    const/high16 v8, 0x41200000    # 10.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->x:F

    mul-float v0, v8, v9

    .line 75
    const/high16 v8, 0x40800000    # 4.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->y:F

    mul-float/2addr v8, v9

    add-float/2addr v1, v8

    .line 64
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 78
    .end local v3    # "j":I
    :cond_2
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->invalidate()V

    .line 79
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 12
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 83
    invoke-super {p0, p1}, Lcom/drms/drms_drone/Controller/MultiSetting/SettingView;->onDraw(Landroid/graphics/Canvas;)V

    .line 84
    iget v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->canvasWidth:F

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v7

    int-to-float v7, v7

    cmpl-float v6, v6, v7

    if-nez v6, :cond_0

    iget v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->canvasHeight:F

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v7

    int-to-float v7, v7

    cmpl-float v6, v6, v7

    if-eqz v6, :cond_1

    .line 85
    :cond_0
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v6

    int-to-float v6, v6

    iput v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->canvasWidth:F

    .line 86
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v6

    int-to-float v6, v6

    iput v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->canvasHeight:F

    .line 87
    iget v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->canvasWidth:F

    const/high16 v7, 0x42820000    # 65.0f

    div-float/2addr v6, v7

    iput v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->x:F

    .line 88
    iget v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->canvasHeight:F

    const/high16 v7, 0x42200000    # 40.0f

    div-float/2addr v6, v7

    iput v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->y:F

    .line 89
    invoke-direct {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->initializeOnOff()V

    .line 92
    :cond_1
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    iget v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->BOXITEMNUM:I

    if-ge v4, v6, :cond_3

    .line 93
    const/4 v5, 0x0

    .local v5, "j":I
    :goto_1
    const/16 v6, 0xc

    if-ge v5, v6, :cond_2

    .line 94
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v6, v6, v4

    aget-object v6, v6, v5

    invoke-virtual {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getDisplayed_check()Landroid/graphics/Bitmap;

    move-result-object v6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v7, v7, v4

    aget-object v7, v7, v5

    invoke-virtual {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionX()F

    move-result v7

    iget-object v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v8, v8, v4

    aget-object v8, v8, v5

    invoke-virtual {v8}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionY()F

    move-result v8

    const/4 v9, 0x0

    invoke-virtual {p1, v6, v7, v8, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 93
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 92
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 98
    .end local v5    # "j":I
    :cond_3
    const/16 v6, 0xa

    new-array v2, v6, [Landroid/graphics/Paint;

    .line 100
    .local v2, "boxPaint":[Landroid/graphics/Paint;
    const/4 v6, 0x0

    new-instance v7, Landroid/graphics/Paint;

    invoke-direct {v7}, Landroid/graphics/Paint;-><init>()V

    aput-object v7, v2, v6

    .line 101
    const/4 v6, 0x0

    aget-object v6, v2, v6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f0c002b

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/graphics/Paint;->setColor(I)V

    .line 102
    const/4 v6, 0x0

    aget-object v6, v2, v6

    const/high16 v7, 0x40e00000    # 7.0f

    invoke-virtual {v6, v7}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 103
    const/4 v6, 0x0

    aget-object v6, v2, v6

    sget-object v7, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v6, v7}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 104
    const/4 v6, 0x0

    aget-object v6, v2, v6

    const/high16 v7, 0x40000000    # 2.0f

    iget v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->y:F

    mul-float/2addr v7, v8

    invoke-virtual {v6, v7}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 107
    iget v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->BOXITEMNUM:I

    if-eqz v6, :cond_7

    .line 108
    iget v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->BOXITEMNUM:I

    new-array v3, v6, [Ljava/lang/String;

    .line 109
    .local v3, "contents":[Ljava/lang/String;
    const/4 v4, 0x0

    :goto_2
    iget v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->BOXITEMNUM:I

    if-ge v4, v6, :cond_4

    .line 110
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v6}, Lcom/drms/drms_drone/MultiData;->getBoxITEM()[Ljava/lang/String;

    move-result-object v6

    aget-object v6, v6, v4

    aput-object v6, v3, v4

    .line 109
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 112
    :cond_4
    const/4 v4, 0x0

    :goto_3
    iget v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->BOXITEMNUM:I

    if-ge v4, v6, :cond_5

    .line 113
    aget-object v6, v3, v4

    const/high16 v7, 0x40a00000    # 5.0f

    iget v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->x:F

    mul-float/2addr v7, v8

    iget-object v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v8, v8, v4

    const/4 v9, 0x0

    aget-object v8, v8, v9

    invoke-virtual {v8}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionY()F

    move-result v8

    iget-object v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v9, v9, v4

    const/4 v10, 0x0

    aget-object v9, v9, v10

    invoke-virtual {v9}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionY()F

    move-result v9

    iget-object v10, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v10, v10, v4

    const/4 v11, 0x0

    aget-object v10, v10, v11

    invoke-virtual {v10}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getDisplayed_check()Landroid/graphics/Bitmap;

    move-result-object v10

    invoke-virtual {v10}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v10

    int-to-float v10, v10

    add-float/2addr v9, v10

    add-float/2addr v8, v9

    const/high16 v9, 0x40000000    # 2.0f

    div-float/2addr v8, v9

    const/4 v9, 0x0

    aget-object v9, v2, v9

    invoke-virtual {v9}, Landroid/graphics/Paint;->getTextSize()F

    move-result v9

    const/high16 v10, 0x40000000    # 2.0f

    div-float/2addr v9, v10

    add-float/2addr v8, v9

    const/4 v9, 0x0

    aget-object v9, v2, v9

    invoke-virtual {p1, v6, v7, v8, v9}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 112
    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    .line 115
    :cond_5
    const/4 v6, 0x3

    new-array v0, v6, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v7, "L"

    aput-object v7, v0, v6

    const/4 v6, 0x1

    const-string v7, "M"

    aput-object v7, v0, v6

    const/4 v6, 0x2

    const-string v7, "H"

    aput-object v7, v0, v6

    .line 116
    .local v0, "LMH":[Ljava/lang/String;
    const/4 v4, 0x0

    :goto_4
    const/16 v6, 0xc

    if-ge v4, v6, :cond_6

    .line 117
    rem-int/lit8 v6, v4, 0x3

    aget-object v6, v0, v6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    const/4 v8, 0x0

    aget-object v7, v7, v8

    aget-object v7, v7, v4

    invoke-virtual {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionX()F

    move-result v7

    iget-object v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    const/4 v9, 0x0

    aget-object v8, v8, v9

    aget-object v8, v8, v4

    invoke-virtual {v8}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionX()F

    move-result v8

    iget-object v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    const/4 v10, 0x0

    aget-object v9, v9, v10

    aget-object v9, v9, v4

    invoke-virtual {v9}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getDisplayed_check()Landroid/graphics/Bitmap;

    move-result-object v9

    invoke-virtual {v9}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v9

    int-to-float v9, v9

    add-float/2addr v8, v9

    add-float/2addr v7, v8

    const/high16 v8, 0x40000000    # 2.0f

    div-float/2addr v7, v8

    const/high16 v8, 0x40c00000    # 6.0f

    iget v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->y:F

    mul-float/2addr v8, v9

    const/4 v9, 0x0

    aget-object v9, v2, v9

    invoke-virtual {p1, v6, v7, v8, v9}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 116
    add-int/lit8 v4, v4, 0x1

    goto :goto_4

    .line 120
    :cond_6
    const/4 v6, 0x0

    aget-object v6, v2, v6

    const/high16 v7, 0x40400000    # 3.0f

    iget v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->y:F

    mul-float/2addr v7, v8

    invoke-virtual {v6, v7}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 121
    const/4 v6, 0x0

    aget-object v6, v2, v6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f0c0053

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/graphics/Paint;->setColor(I)V

    .line 122
    const/4 v6, 0x4

    new-array v1, v6, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v7, "AUX1"

    aput-object v7, v1, v6

    const/4 v6, 0x1

    const-string v7, "AUX2"

    aput-object v7, v1, v6

    const/4 v6, 0x2

    const-string v7, "AUX3"

    aput-object v7, v1, v6

    const/4 v6, 0x3

    const-string v7, "AUX4"

    aput-object v7, v1, v6

    .line 123
    .local v1, "aux":[Ljava/lang/String;
    const/4 v4, 0x0

    :goto_5
    const/4 v6, 0x4

    if-ge v4, v6, :cond_7

    .line 124
    aget-object v6, v1, v4

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    const/4 v8, 0x0

    aget-object v7, v7, v8

    mul-int/lit8 v8, v4, 0x3

    add-int/lit8 v8, v8, 0x1

    aget-object v7, v7, v8

    invoke-virtual {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionX()F

    move-result v7

    iget-object v8, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    const/4 v9, 0x0

    aget-object v8, v8, v9

    mul-int/lit8 v9, v4, 0x3

    add-int/lit8 v9, v9, 0x1

    aget-object v8, v8, v9

    invoke-virtual {v8}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionX()F

    move-result v8

    iget-object v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    const/4 v10, 0x0

    aget-object v9, v9, v10

    mul-int/lit8 v10, v4, 0x3

    add-int/lit8 v10, v10, 0x1

    aget-object v9, v9, v10

    invoke-virtual {v9}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getDisplayed_check()Landroid/graphics/Bitmap;

    move-result-object v9

    invoke-virtual {v9}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v9

    int-to-float v9, v9

    add-float/2addr v8, v9

    add-float/2addr v7, v8

    const/high16 v8, 0x40000000    # 2.0f

    div-float/2addr v7, v8

    const v8, 0x40533333

    iget v9, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->y:F

    mul-float/2addr v8, v9

    const/4 v9, 0x0

    aget-object v9, v2, v9

    invoke-virtual {p1, v6, v7, v8, v9}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 123
    add-int/lit8 v4, v4, 0x1

    goto :goto_5

    .line 127
    .end local v0    # "LMH":[Ljava/lang/String;
    .end local v1    # "aux":[Ljava/lang/String;
    .end local v3    # "contents":[Ljava/lang/String;
    :cond_7
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 7
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 131
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_3

    .line 132
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->BOXITEMNUM:I

    if-ge v0, v2, :cond_3

    .line 133
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_1
    const/16 v2, 0xc

    if-ge v1, v2, :cond_0

    .line 134
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v3, v3, v0

    aget-object v3, v3, v1

    invoke-virtual {v3}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionX()F

    move-result v3

    cmpl-float v2, v2, v3

    if-ltz v2, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v3, v3, v0

    aget-object v3, v3, v1

    invoke-virtual {v3}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionX()F

    move-result v3

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v4, v4, v0

    aget-object v4, v4, v1

    invoke-virtual {v4}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getDisplayed_check()Landroid/graphics/Bitmap;

    move-result-object v4

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    int-to-float v4, v4

    add-float/2addr v3, v4

    cmpg-float v2, v2, v3

    if-gtz v2, :cond_2

    .line 135
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v3, v3, v0

    aget-object v3, v3, v1

    invoke-virtual {v3}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionY()F

    move-result v3

    cmpl-float v2, v2, v3

    if-ltz v2, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v3, v3, v0

    aget-object v3, v3, v1

    invoke-virtual {v3}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getPositionY()F

    move-result v3

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v4, v4, v0

    aget-object v4, v4, v1

    invoke-virtual {v4}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->getDisplayed_check()Landroid/graphics/Bitmap;

    move-result-object v4

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    int-to-float v4, v4

    add-float/2addr v3, v4

    cmpg-float v2, v2, v3

    if-gtz v2, :cond_2

    .line 136
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v2, v2, v0

    aget-object v2, v2, v1

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->isChecked()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 137
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v2, v2, v0

    aget-object v2, v2, v1

    invoke-virtual {v2, v5}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->setChecked(Z)V

    .line 141
    :goto_2
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->invalidate()V

    .line 142
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v2, v5}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 144
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v3, v3, v0

    aget-object v3, v3, v1

    invoke-virtual {v3}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->isChecked()Z

    move-result v3

    invoke-virtual {v2, v0, v1, v3}, Lcom/drms/drms_drone/MultiData;->setEachCheckboxData(IIZ)V

    .line 132
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 139
    :cond_1
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->checkbox:[[Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;

    aget-object v2, v2, v0

    aget-object v2, v2, v1

    invoke-virtual {v2, v6}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->setChecked(Z)V

    goto :goto_2

    .line 133
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_1

    .line 151
    .end local v0    # "i":I
    .end local v1    # "j":I
    :cond_3
    return v6
.end method
